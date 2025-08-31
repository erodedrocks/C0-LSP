package erodedrocks.c0lsp

import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.fileTypes.SyntaxHighlighterFactory
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.registry.Registry
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.textmate.joni.JoniRegexFactory
import org.jetbrains.plugins.textmate.TextMateService
import org.jetbrains.plugins.textmate.language.syntax.highlighting.TextMateHighlighter
import org.jetbrains.plugins.textmate.language.syntax.lexer.TextMateCachingSyntaxMatcher
import org.jetbrains.plugins.textmate.language.syntax.lexer.TextMateHighlightingLexer
import org.jetbrains.plugins.textmate.language.syntax.lexer.TextMateSyntaxMatcherImpl
import org.jetbrains.plugins.textmate.language.syntax.selector.TextMateSelectorCachingWeigher
import org.jetbrains.plugins.textmate.language.syntax.selector.TextMateSelectorWeigherImpl
import org.jetbrains.plugins.textmate.regex.CachingRegexFactory
import org.jetbrains.plugins.textmate.regex.RememberingLastMatchRegexFactory

class C0TextMateSyntaxHighlighterFactory : SyntaxHighlighterFactory() {
    companion object {
        val BASE_TEXTMATE_SYNTAX_HIGHLIGHTER: TextMateHighlighter = TextMateHighlighter(null);
    }
    override fun getSyntaxHighlighter(project: Project?, virtualFile: VirtualFile?): SyntaxHighlighter {
        if (virtualFile == null) {
            return BASE_TEXTMATE_SYNTAX_HIGHLIGHTER;
        }
        else {
            val tms: TextMateService = TextMateService.getInstance() ?: return BASE_TEXTMATE_SYNTAX_HIGHLIGHTER;
            var languageDescriptor = tms.getLanguageDescriptorByFileName(virtualFile.name) ?: return BASE_TEXTMATE_SYNTAX_HIGHLIGHTER;
            val regexFactory = CachingRegexFactory(RememberingLastMatchRegexFactory(JoniRegexFactory()))
            val weigher = TextMateSelectorCachingWeigher(TextMateSelectorWeigherImpl())
            val syntaxMatcher = TextMateCachingSyntaxMatcher(TextMateSyntaxMatcherImpl(regexFactory, weigher))
            return C0TextMateHighlighter(
                TextMateHighlightingLexer(languageDescriptor, syntaxMatcher, Registry.get("textmate.line.highlighting.limit").asInteger())
            )
        }
    }
}