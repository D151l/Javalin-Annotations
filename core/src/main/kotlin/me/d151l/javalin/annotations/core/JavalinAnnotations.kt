package me.d151l.javalin.annotations.core

import io.javalin.Javalin
import io.javalin.http.Context
import me.d151l.javalin.annotations.core.annotation.AnnotationHandler
import me.d151l.javalin.annotations.core.controller.Controller

/**
 * @created 25/12/2022 - 11:46
 * @project Javalin-Annotations
 * @author  D151l
 */
class JavalinAnnotations(
    val app: Javalin
) {

    private val annotationHandler = AnnotationHandler()

    fun register(controller: Controller) {
        val consumerMap = this.annotationHandler.getAnnotationMethods(controller)

        consumerMap.forEach { (path, consumer) ->
            this.app[path, {context: Context ->
                consumer.accept(context)
            }]
        }
    }
}