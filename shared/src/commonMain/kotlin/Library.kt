package com.kal.tryKmpWasm

import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

@OptIn(ExperimentalJsExport::class)
@JsExport
fun hello(name: String): String = "Hello, $name!"
