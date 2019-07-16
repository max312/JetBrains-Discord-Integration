/*
 * Copyright 2017-2019 Aljoscha Grebe
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.almightyalpaca.jetbrains.plugins.discord.plugin.utils

inline fun <T> tryCatch(print: Boolean = true, block: () -> T): T? = tryCatch(null, print, block)

inline fun <T> tryCatch(default: T, print: Boolean = true, block: () -> T): T = try {
    block()
} catch (e: Exception) {
    if (print) {
        e.printStackTrace()
    }
    default
}
