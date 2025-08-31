package erodedrocks.c0lsp

import com.intellij.execution.configurations.GeneralCommandLine
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.platform.lsp.api.LspServer
import com.intellij.platform.lsp.api.LspServerSupportProvider
import com.intellij.platform.lsp.api.ProjectWideLspServerDescriptor
import com.intellij.platform.lsp.api.lsWidget.LspServerWidgetItem
import erodedrocks.c0lsp.settings.AppSettings

internal class C0LspServerSupportProvider : LspServerSupportProvider {
    override fun fileOpened(project: Project, file: VirtualFile, serverStarter: LspServerSupportProvider.LspServerStarter) {
        if (file.extension == "c0") {
            serverStarter.ensureServerStarted(C0LspServerDescriptor(project))
        }
    }
}

private class C0LspServerDescriptor(project: Project) : ProjectWideLspServerDescriptor(project, "C0") {
    override fun isSupportedFile(file: VirtualFile) = file.extension == "c0"
    override fun createCommandLine() : GeneralCommandLine {
        return GeneralCommandLine(mutableListOf("node", AppSettings.instance!!.state.serverPath!!, "--stdio"))
    }
}