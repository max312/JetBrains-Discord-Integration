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

package com.almightyalpaca.jetbrains.plugins.discord.plugin.render

import com.almightyalpaca.jetbrains.plugins.discord.plugin.settings.settings

class ApplicationRenderer(context: RenderContext) : Renderer(context) {
    override fun RenderContext.render() = render(
        details = settings.applicationDetails,
        detailsCustom = settings.applicationDetailsCustom,
        state = settings.applicationState,
        stateCustom = settings.applicationStateCustom,
        largeIcon = settings.applicationIconLarge,
        largeIconText = settings.applicationIconLargeText,
        largeIconTextCustom = settings.fileIconLargeTextCustom,
        smallIcon = settings.applicationIconSmall,
        smallIconText = settings.applicationIconSmallText,
        smallIconTextCustom = settings.fileIconSmallTextCustom,
        startTimestamp = settings.applicationTime
    )
}
