package me.d151l.javalin.annotations.example

import io.javalin.Javalin
import me.d151l.javalin.annotations.core.JavalinAnnotations
import me.d151l.javalin.annotations.example.controller.TestController

/**
 * @created 25/12/2022 - 12:13
 * @project Javalin-Annotations
 * @author  D151l
 */
class JavalinExample {

    private val app: Javalin = Javalin.create().start(7000)
    private val javalinAnnotations: JavalinAnnotations

    init {
        this.app.before { context ->
            context.header("Access-Control-Allow-Headers", "*")
            context.header("Access-Control-Allow-Origin", "*")
            context.header("Access-Control-Allow-Methods", "GET, PUT, POST, DELETE, OPTIONS")
            context.header("Content-Type", "application/json; charset=utf-8")
        }

        this.javalinAnnotations = JavalinAnnotations(this.app)
        this.javalinAnnotations.register(TestController(this))

        Runtime.getRuntime().addShutdownHook(Thread { app.stop() })
    }
}