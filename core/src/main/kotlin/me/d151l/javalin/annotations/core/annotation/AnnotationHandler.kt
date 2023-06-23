package me.d151l.javalin.annotations.core.annotation

import io.javalin.http.Context
import me.d151l.javalin.annotations.core.controller.Controller
import me.d151l.javalin.annotations.core.request.RequestType
import java.util.function.Consumer

/**
 * @created 25/12/2022 - 11:49
 * @project Javalin-Annotations
 * @author  D151l
 */
class AnnotationHandler {

    fun getAnnotationMethods(controller: Controller): Map<Pair<String, RequestType>, Consumer<Context>> {
        val methods: MutableMap<Pair<String, RequestType>, Consumer<Context>> = mutableMapOf()

        controller.javaClass.declaredMethods.forEach {
            if (it.parameterTypes.size != 1)
                return@forEach

            if (it.isAnnotationPresent(JavalinPostPath::class.java)) {
                val annotation = it.getAnnotation(JavalinPostPath::class.java)

                it.isAccessible = true
                methods.put(Pair(annotation.path, RequestType.POST)) { context -> it.invoke(controller, context) }
            }

            if (it.isAnnotationPresent(JavalinPath::class.java)) {
                val annotation = it.getAnnotation(JavalinPath::class.java)

                it.isAccessible = true
                methods.put(Pair(annotation.path, RequestType.GET)) { context -> it.invoke(controller, context) }
            }

            if (it.isAnnotationPresent(JavalinPutPath::class.java)) {
                val annotation = it.getAnnotation(JavalinPutPath::class.java)

                it.isAccessible = true
                methods.put(Pair(annotation.path, RequestType.PUT)) { context -> it.invoke(controller, context) }
            }

            if (it.isAnnotationPresent(JavalinDeletePath::class.java)) {
                val annotation = it.getAnnotation(JavalinDeletePath::class.java)

                it.isAccessible = true
                methods.put(Pair(annotation.path, RequestType.DELETE)) { context -> it.invoke(controller, context) }
            }

            if (it.isAnnotationPresent(JavalinPatchPath::class.java)) {
                val annotation = it.getAnnotation(JavalinPatchPath::class.java)

                it.isAccessible = true
                methods.put(Pair(annotation.path, RequestType.PATCH)) { context -> it.invoke(controller, context) }
            }

            if (it.isAnnotationPresent(JavalinGetPath::class.java)) {
                val annotation = it.getAnnotation(JavalinGetPath::class.java)

                it.isAccessible = true
                methods.put(Pair(annotation.path, RequestType.GET)) { context -> it.invoke(controller, context) }
            }
        }

        return methods
    }
}