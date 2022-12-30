package me.d151l.javalin.annotations.core.annotation

/**
 * @created 30/12/2022 - 11:14
 * @project Javalin-Annotations
 * @author  D151l
 */
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class JavalinPostPath(val path: String)
