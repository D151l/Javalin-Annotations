package me.d151l.javalin.annotations.core.annotation

import io.javalin.http.Context
import me.d151l.javalin.annotations.core.controller.Controller
import java.util.function.Consumer

/**
 * @created 25/12/2022 - 11:49
 * @project Javalin-Annotations
 * @author  D151l
 */
class AnnotationHandler {

    fun getAnnotationMethods(controller: Controller): Map<String, Consumer<Context>> {
        val methods: MutableMap<String, Consumer<Context>> = mutableMapOf()

        controller.javaClass.declaredMethods.forEach {
            if (it.parameterTypes.size != 1)
                return@forEach
            if (!it.isAnnotationPresent(JavalinPath::class.java))
                return@forEach

            val annotation = it.getAnnotation(JavalinPath::class.java)

            it.isAccessible = true
            methods.put(annotation.path) { context -> it.invoke(controller, context) }
        }

        return methods
    }
}