package erodedrocks.c0lsp

import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.colors.EditorColorsScheme
import com.intellij.openapi.editor.ex.util.DataStorage
import com.intellij.openapi.editor.ex.util.LexerEditorHighlighter
import com.intellij.openapi.editor.highlighter.EditorHighlighter
import com.intellij.openapi.fileTypes.EditorHighlighterProvider
import com.intellij.openapi.fileTypes.FileType
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.fileTypes.SyntaxHighlighterFactory
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import org.jetbrains.plugins.textmate.language.syntax.highlighting.TextMateHighlighter
import org.jetbrains.plugins.textmate.language.syntax.lexer.TextMateLexerDataStorage

class C0TextMateEditorHighlighterProvider : EditorHighlighterProvider {
    override fun getEditorHighlighter(
        project: Project?,
        fileType: FileType,
        virtualFile: VirtualFile?,
        colors: EditorColorsScheme
    ): EditorHighlighter {
        return TextMateLexerEditorHighlighter(
            SyntaxHighlighterFactory.getSyntaxHighlighter(
                fileType,
                project,
                virtualFile
            ), colors
        )
    }

    private class TextMateLexerEditorHighlighter(highlighter: SyntaxHighlighter?, colors: EditorColorsScheme) :
        LexerEditorHighlighter(
            (highlighter ?: C0TextMateHighlighter(null)),
            colors
        ) {
        override fun createStorage(): DataStorage {
            return TextMateLexerDataStorage()
        }
    }
}
