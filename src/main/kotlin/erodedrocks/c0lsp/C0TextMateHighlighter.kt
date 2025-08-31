package erodedrocks.c0lsp

import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.PlainSyntaxHighlighter
import com.intellij.openapi.util.text.Strings
import com.intellij.psi.tree.IElementType
import com.intellij.util.Function
import com.intellij.util.containers.ContainerUtil
import org.jetbrains.annotations.NotNull
import org.jetbrains.plugins.textmate.TextMateService
import org.jetbrains.plugins.textmate.language.TextMateScopeComparator
import org.jetbrains.plugins.textmate.language.syntax.highlighting.TextMateHighlighter
import org.jetbrains.plugins.textmate.language.syntax.highlighting.TextMateTheme
import org.jetbrains.plugins.textmate.language.syntax.lexer.TextMateElementType
import org.jetbrains.plugins.textmate.language.syntax.lexer.TextMateScope


class C0TextMateHighlighter(l: Lexer?) : TextMateHighlighter(l) {
    companion object {
        val PLAIN_SYNTAX_HIGHLIGHTER: PlainSyntaxHighlighter = PlainSyntaxHighlighter()
    }
    override fun getTokenHighlights(tokenType: IElementType?): @NotNull Array<TextAttributesKey?> {
        if (tokenType !is TextMateElementType) return PLAIN_SYNTAX_HIGHLIGHTER.getTokenHighlights(tokenType)
        val service = TextMateService.getInstance()
        val customHighlightingColors = service.customHighlightingColors

        val highlightingRules = ContainerUtil.union(customHighlightingColors.keys, C0TextMateTheme.rules)

        val textMateScope = trimEmbeddedScope(tokenType)
        val selectors: MutableList<CharSequence?> = ContainerUtil.reverse<CharSequence?>(
            TextMateScopeComparator<CharSequence?>(textMateScope, { x -> x }).sortAndFilter(highlightingRules)
        )
        return ContainerUtil.map2Array<CharSequence?, TextAttributesKey?>(
            selectors,
            TextAttributesKey::class.java,
            Function { rule: CharSequence? ->
                val customTextAttributes = customHighlightingColors[rule]
                C0TextMateTheme.INSTANCE.getTextAttributesKey(rule)
            })
    }

    private fun trimEmbeddedScope(tokenType: TextMateElementType): TextMateScope {
        var current: TextMateScope? = tokenType.getScope()
        val trail: MutableList<CharSequence?> = ArrayList<CharSequence?>()
        while (current != null) {
            val scopeName = current.scopeName
            if (scopeName != null && Strings.contains(scopeName, ".embedded.")) {
                var result = TextMateScope.EMPTY
                for (i in trail.indices.reversed()) {
                    result = result.add(trail[i])
                }
                return result
            }
            trail.add(scopeName)
            current = current.parent
        }
        return tokenType.getScope()
    }
}