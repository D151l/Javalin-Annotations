package me.d151l.javalin.annotations.example.controller

import io.javalin.http.Context
import me.d151l.javalin.annotations.core.annotation.JavalinPath
import me.d151l.javalin.annotations.core.controller.Controller
import me.d151l.javalin.annotations.example.JavalinExample

/**
 * @created 25/12/2022 - 12:22
 * @project Javalin-Annotations
 * @author  D151l
 */
class TestController(
    private val javalinExample: JavalinExample
): Controller {

    /*
    * example url: http://127.0.0.1:7000/test/hello
   */
    @JavalinPath("/test/hello")
    fun handleTest(context: Context) {
        context.result("Hello World!")
    }

    /*
    * example url: http://127.0.0.1:7000/test/hello/Dominic
    */
    @JavalinPath("/test/hello/<name>")
    fun handleHello(context: Context) {
        context.result("Hello ${context.pathParam("name")}!")
    }
}