package erodedrocks.c0lsp.settings

import com.intellij.openapi.options.Configurable
import com.intellij.openapi.util.NlsContexts
import org.jetbrains.annotations.Nls
import org.jetbrains.annotations.Nullable
import java.util.Objects
import javax.swing.JComponent


internal class AppSettingsConfigurable : Configurable {
    private var mySettingsComponent: AppSettingsComponent? = null

    public override fun getDisplayName(): @NlsContexts.ConfigurableName String? {
        return "C0"
    }

    override fun getPreferredFocusedComponent(): JComponent? {
        return mySettingsComponent?.preferredFocusedComponent
    }

    @Nullable
    public override fun createComponent(): JComponent? {
        mySettingsComponent = AppSettingsComponent()
        return mySettingsComponent?.panel
    }

    public override fun isModified(): Boolean {
        val state: AppSettings.State =
            Objects.requireNonNull(AppSettings.instance!!.state)
        return !mySettingsComponent!!.getServerjsPath().equals(state.serverPath)
    }

    public override fun apply() {
        val state: AppSettings.State =
            Objects.requireNonNull(AppSettings.instance!!.getState())
        state.serverPath = mySettingsComponent!!.getServerjsPath()
    }

    public override fun reset() {
        val state: AppSettings.State =
            Objects.requireNonNull(AppSettings.instance!!.getState())
        mySettingsComponent!!.setServerjsPath(state.serverPath!!)
    }

    public override fun disposeUIResources() {
        mySettingsComponent = null
    }
}
