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

package com.almightyalpaca.jetbrains.plugins.discord.shared.source.local

import com.almightyalpaca.jetbrains.plugins.discord.shared.matcher.Matcher
import com.almightyalpaca.jetbrains.plugins.discord.shared.source.Language
import com.almightyalpaca.jetbrains.plugins.discord.shared.source.LanguageMap
import com.almightyalpaca.jetbrains.plugins.discord.shared.source.LanguageSource
import com.almightyalpaca.jetbrains.plugins.discord.shared.source.abstract.AbstractLanguageSourceMap

class LocalLanguageSourceMap(private val source: LocalSource, map: Map<String, LanguageSource>) : AbstractLanguageSourceMap(map) {
    override fun createLanguageMap(languages: Map<String, Language>): LanguageMap = LocalLanguageMap(languages.values)

    override fun createDefaultLanguage(name: String, assetId: String): Language.Default = LocalLanguage.Default(source, name, assetId)

    override fun createSimpleLanguage(fileId: String, name: String, parent: Language?, assetIds: List<String>?, matchers: Map<Matcher.Target, Matcher>): Language.Simple =
        LocalLanguage.Simple(source, fileId, name, parent, assetIds, matchers)
}
