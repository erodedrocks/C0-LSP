package erodedrocks.c0lsp.language

import com.intellij.lang.Language
import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

class C0FileType : LanguageFileType(C0Language.INSTANCE) {
    companion object {
        val INSTANCE = C0FileType()
    }

    override fun getName(): String = "C0"

    override fun getIcon(): Icon = C0Icon.FILE

    override fun getDefaultExtension(): String = "c0"

    override fun getDescription(): String = "C0 files"
}