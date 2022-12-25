package me.d151l.javalin.annotations.core.annotation

/**
 * @created 25/12/2022 - 11:49
 * @project Javalin-Annotations
 * @author  D151l
 */
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class JavalinPath(val path: String)