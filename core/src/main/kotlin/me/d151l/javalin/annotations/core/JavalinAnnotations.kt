package me.d151l.javalin.annotations.core

import io.javalin.Javalin
import io.javalin.http.Context
import me.d151l.javalin.annotations.core.annotation.AnnotationHandler
import me.d151l.javalin.annotations.core.controller.Controller
import me.d151l.javalin.annotations.core.request.RequestType

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

        consumerMap.forEach { (pair, consumer) ->
            if (pair.second == RequestType.GET) {
                this.app[pair.first, { context: Context ->
                    consumer.accept(context)
                }]
            }
            if (pair.second == RequestType.POST) {
                this.app.post(pair.first) {
                    consumer.accept(it)
                }
            }
            if (pair.second == RequestType.PUT) {
                this.app.put(pair.first) {
                    consumer.accept(it)
                }
            }
            if (pair.second == RequestType.DELETE) {
                this.app.delete(pair.first) {
                    consumer.accept(it)
                }
            }
            if (pair.second == RequestType.PATCH) {
                this.app.patch(pair.first) {
                    consumer.accept(it)
                }
            }
        }
    }
}