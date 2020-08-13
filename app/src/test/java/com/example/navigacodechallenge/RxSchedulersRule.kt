package com.example.navigacodechallenge

import io.reactivex.Scheduler
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.functions.Function
import io.reactivex.internal.schedulers.ExecutorScheduler.ExecutorWorker
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement
import java.util.concurrent.Callable
import java.util.concurrent.Executor

/**
 * Class which sets up a new rule for scheduling to be used with jUnit tests
 */
class RxSchedulersRule : TestRule {
    override fun apply(base: Statement, description: Description): Statement {
        val immediate: Scheduler = object : Scheduler() {
            override fun createWorker(): Worker {
                return ExecutorWorker(Executor { obj: Runnable -> obj.run() })
            }
        }

        val immediateScheduler = Function<Scheduler, Scheduler> { immediate }
        val mainThreadScheduler = Function<Scheduler, Scheduler> { Schedulers.trampoline() }
        val initMainThreadScheduler = Function<Callable<Scheduler?>, Scheduler> { Schedulers.trampoline() }

        return object : Statement() {
            @Throws(Throwable::class)
            override fun evaluate() {
                RxJavaPlugins.setIoSchedulerHandler(mainThreadScheduler)
                RxJavaPlugins.setNewThreadSchedulerHandler(mainThreadScheduler)
                RxJavaPlugins.setComputationSchedulerHandler(immediateScheduler)
                RxAndroidPlugins.setMainThreadSchedulerHandler(mainThreadScheduler)
                RxAndroidPlugins.setInitMainThreadSchedulerHandler(initMainThreadScheduler)
                try {
                    base.evaluate()
                } finally {
                    RxJavaPlugins.reset()
                    RxAndroidPlugins.reset()
                }
            }
        }
    }
}
