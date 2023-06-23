package me.d151l.javalin.annotations.core.request.annotation

import me.d151l.javalin.annotations.core.request.RequestType

/**
 * @created 27/12/2022 - 19:11
 * @project Javalin-Annotations
 * @author  D151l
 */
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class WebRequest(val path: String, val requestType: RequestType)