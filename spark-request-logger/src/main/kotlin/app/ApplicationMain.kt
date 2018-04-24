package app

import app.utils.SparkUtils
import org.apache.logging.log4j.LogManager
import spark.Spark.get

fun main(args: Array<String>) {
    val logger = LogManager.getLogger()
    SparkUtils.createServerWithRequestLog(logger)

    get("/hello") { request, response -> "world" }
}
