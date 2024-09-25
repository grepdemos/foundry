/*
 * Copyright (C) 2024 Slack Technologies, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.slack.sgp.intellij.aibot

import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.ToolWindow
import com.intellij.openapi.wm.ToolWindowFactory
import com.intellij.ui.content.ContentFactory
import javax.swing.JComponent
import slack.tooling.aibot.ChatPanel

class ChatBotToolWindow : ToolWindowFactory {
  override fun createToolWindowContent(project: Project, toolWindow: ToolWindow) {
    val contentFactory = ContentFactory.getInstance()
    val content = contentFactory.createContent(createComposePanel(project), "", false)
    toolWindow.contentManager.addContent(content)
  }

  private fun createComposePanel(project: Project): JComponent {
    val scriptFetcher = AIBotScriptFetcher(project)
    println("AIBotScriptFetcher $scriptFetcher")
    val scriptPath = scriptFetcher.getAIBotScript()
    println("apple $scriptPath")
    return ChatPanel.createPanel(scriptPath.toString())
  }
}
