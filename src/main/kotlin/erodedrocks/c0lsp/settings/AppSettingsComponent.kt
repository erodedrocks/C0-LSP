package erodedrocks.c0lsp.settings

import com.intellij.ui.components.JBLabel
import com.intellij.ui.components.JBTextField
import com.intellij.util.ui.FormBuilder
import javax.swing.JComponent
import javax.swing.JPanel

class AppSettingsComponent {
    val panel: JPanel?
    private val serverjsPath = JBTextField()

    init {
        this.panel = FormBuilder.createFormBuilder()
            .addLabeledComponent(JBLabel("C0 Language Server server.js file location"), serverjsPath, 1, false)
            .addComponentFillVertically(JPanel(), 0)
            .getPanel()
    }

    val preferredFocusedComponent: JComponent
        get() = serverjsPath

    fun getServerjsPath(): String {
        return serverjsPath.getText()
    }

    fun setServerjsPath(newText: String) {
        serverjsPath.setText(newText)
    }
}
