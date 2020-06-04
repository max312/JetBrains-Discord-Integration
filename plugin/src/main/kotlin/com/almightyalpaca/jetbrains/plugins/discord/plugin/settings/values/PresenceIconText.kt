/*
 * Copyright 2017-2020 Aljoscha Grebe
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.almightyalpaca.jetbrains.plugins.discord.plugin.settings.values

import com.almightyalpaca.jetbrains.plugins.discord.plugin.render.RenderContext
import com.almightyalpaca.jetbrains.plugins.discord.plugin.settings.options.types.SimpleValue
import com.almightyalpaca.jetbrains.plugins.discord.plugin.settings.options.types.UiValueType

typealias IconTextValue = SimpleValue<PresenceIconText>

enum class PresenceIconText(override val text: String, override val description: String? = null) : RenderedValue<PresenceIconText.Result>, UiValueType {
    APPLICATION_VERSION("Application Version") {
        override fun RenderContext.getResult() = applicationData?.applicationVersion.toResult()
    },
    FILE_LANGUAGE("File Language") {
        override fun RenderContext.getResult() = language?.name.toResult()
    },
    CUSTOM("Custom") {
        override fun RenderContext.getResult() = Result.Custom
    },
    NONE("None") {
        override fun RenderContext.getResult() = Result.Empty
    };

    object Large {
        val Application = APPLICATION_VERSION to arrayOf(APPLICATION_VERSION, NONE)
        val Project = APPLICATION_VERSION to arrayOf(APPLICATION_VERSION, NONE)
        val File = FILE_LANGUAGE to arrayOf(APPLICATION_VERSION, FILE_LANGUAGE, CUSTOM, NONE)
    }

    object Small {
        val Application = NONE to arrayOf(APPLICATION_VERSION, NONE)
        val Project = NONE to arrayOf(APPLICATION_VERSION, NONE)
        val File = APPLICATION_VERSION to arrayOf(APPLICATION_VERSION, FILE_LANGUAGE, CUSTOM, NONE)
    }

    fun String?.toResult() = when {
        this == null || trim().isBlank() -> Result.Empty
        else -> Result.String(trim())
    }

    sealed class Result {
        object Empty : Result()
        object Custom : Result()
        data class String(val value: kotlin.String) : Result()
    }
}
