package me.d151l.javalin.annotations.core.annotation

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class JavalinPatchPath(val path: String)
