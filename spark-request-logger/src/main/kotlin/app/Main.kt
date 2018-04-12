package app

import spark.Spark.get

fun main(args : Array<String>) {
    get ("/hello") { req, res -> "hello world" }
}
