package erodedrocks.c0lsp

import com.intellij.openapi.editor.colors.EditorColorsManager
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.util.containers.ContainerUtil
import org.jetbrains.plugins.textmate.language.syntax.highlighting.TextMateDefaultColorsProvider
import org.jetbrains.plugins.textmate.language.syntax.highlighting.TextMateTheme
import java.awt.Color

class C0TextMateTheme private constructor(val name: String) {
    val defaultBackground: Color
        get() = EditorColorsManager.getInstance().getGlobalScheme().getDefaultBackground()

    fun getTextAttributesKey(highlightingRule: CharSequence?): TextAttributesKey {
        val keyName = EXTENSIONS_MAPPING.get(highlightingRule)
        val extendedKey = if (keyName != null) TextAttributesKey.find(keyName.toString()) else null
        return if (extendedKey == null) DEFAULT_COLORS_PROVIDER.getTextAttributesKey(highlightingRule) else extendedKey
    }

    companion object {
        val INSTANCE: C0TextMateTheme = C0TextMateTheme("C0")
        private val DEFAULT_COLORS_PROVIDER = TextMateDefaultColorsProvider()
        private val EXTENSIONS_MAPPING: MutableMap<CharSequence?, CharSequence?> =
            object : HashMap<CharSequence?, CharSequence?>() {
                init {
                    this.put("keyword.control.contract", "BAD_CHARACTER")
                    this.put("comment.line.contract", "BAD_CHARACTER")
                    this.put("comment.block.contract", "BAD_CHARACTER")

                    this.put("comment.result", "JS.JSX_CLIENT_COMPONENT")
                    this.put("comment.length", "JS.JSX_CLIENT_COMPONENT")

                    this.put("keyword.other.typedef", "FILESTATUS_MERGED")

                    this.put("keyword.control.contract", "BAD_CHARACTER")

                    this.put("keyword.other.unit", "FILESTATUS_MODIFIED")

                    this.put("keyword.other.library", "JS.JSX_CLIENT_COMPONENT")

                    this.put("entity.name.function", "DEFAULT_FUNCTION_DECLARATION")
                    this.put("support.function", "DEFAULT_FUNCTION_DECLARATION")
                    this.put("support.constant.handlebars", "DEFAULT_FUNCTION_DECLARATION")
                    this.put("source.powershell variable.other.member", "DEFAULT_FUNCTION_DECLARATION")
                    this.put("entity.name.operator.custom-literal", "DEFAULT_FUNCTION_DECLARATION")

                    this.put("meta.return-type", "CUSTOM_KEYWORD2_ATTRIBUTES")
                    this.put("support.class", "CUSTOM_KEYWORD2_ATTRIBUTES")
                    this.put("support.type", "CUSTOM_KEYWORD2_ATTRIBUTES")
                    this.put("entity.name.type", "CUSTOM_KEYWORD2_ATTRIBUTES")
                    this.put("entity.name.namespace", "CUSTOM_KEYWORD2_ATTRIBUTES")
                    this.put("entity.other.attribute", "CUSTOM_KEYWORD2_ATTRIBUTES")
                    this.put("entity.name.scope-resolution", "CUSTOM_KEYWORD2_ATTRIBUTES")
                    this.put("entity.name.class", "CUSTOM_KEYWORD2_ATTRIBUTES")

                    this.put("variable", "CONSOLE_SYSTEM_OUTPUT")
                    this.put("meta.definition.variable.name", "CONSOLE_SYSTEM_OUTPUT")
                    this.put("support.variable", "CONSOLE_SYSTEM_OUTPUT")
                    this.put("entity.name.variable", "CONSOLE_SYSTEM_OUTPUT")

                    this.put("constant.character.escape", "DEFAULT_VALID_STRING_ESCAPE")

                    this.put("comment", "DEFAULT_LINE_COMMENT")
                    this.put("punctuation.definition.comment", "DEFAULT_LINE_COMMENT")

                    this.put("storage", "DEFAULT_KEYWORD")
                    this.put("storage.type", "DEFAULT_KEYWORD")
                    this.put("storage.modifier", "DEFAULT_KEYWORD")

                    this.put("constant.numeric", "DEFAULT_NUMBER")

                    this.put("constant.language", "GHERKIN_REGEXP_PARAMETER")

                    this.put("punctuation.definition.statement.clac", "TEMPLATE_VARIABLE_ATTRIBUTES")
                    this.put("punctuation.terminator.statement.clac", "TEMPLATE_VARIABLE_ATTRIBUTES")

                    this.put("keyword.other.token.clac", "FILESTATUS_COPIED")

                    this.put("constant.numeric.clac", "DEFAULT_NUMBER")

                    this.put("entity.name.function.clac", "DEFAULT_FUNCTION_DECLARATION")

                    this.put("comment.instruction.bc0", "DEFAULT_DOC_COMMENT")

                    this.put("comment.function.name.bc0", "DEFAULT_FUNCTION_DECLARATION")

                    this.put("comment.function.description.bc0", "JS.INSTANCE_MEMBER_FUNCTION")

                    this.put("comment.description.bc0", "JS.REGEXP")

                    this.put("comment.line.bc0", "DEFAULT_LINE_COMMENT")

                    this.put("token.info-token", "LOG_VERBOSE_OUTPUT")
                    this.put("token.warn-token", "TEXT_STYLE_WARNING")
                    this.put("token.error-token", "LOG_ERROR_OUTPUT")
                    this.put("token.debug-token", "JS.JSX_CLIENT_COMPONENT")

                    // Values from TextMateTheme.EXTENSIONS_MAPPING
                    this.put("entity.other.attribute-name.localname.xml", "XML_ATTRIBUTE_NAME")
                    this.put("entity.name.tag.xml", "XML_TAG_NAME")
                    this.put("comment.block.html", "HTML_COMMENT")
                    this.put("entity.name.tag", "HTML_TAG_NAME")
                    this.put("entity.other.attribute-name.html", "HTML_ATTRIBUTE_NAME")
                    this.put("entity.name.function.decorator", "PY.DECORATOR")
                    this.put("entity.other.attribute-name.class.css", "CSS.IDENT")
                    this.put("comment.block.css", "CSS.COMMENT")
                    this.put("support.type.property-name", "CSS.PROPERTY_NAME")
                    this.put("meta.property-value.css", "CSS.PROPERTY_VALUE")
                    this.put("entity.name.tag.css", "CSS.TAG_NAME")
                    this.put("constant.numeric.css", "CSS.NUMBER")
                    this.put("support.function.misc.css", "CSS.FUNCTION")
                    this.put("variable.parameter.misc.css", "CSS.URL")
                    this.put("variable.other.less", "LESS_VARIABLE")
                    this.put("source.css.less", "LESS_JS_CODE_DELIM")
                    this.put("source.js.embedded.less", "LESS_INJECTED_CODE")
                    this.put("variable.parameter.sass", "SASS_VARIABLE")
                    this.put("string.quoted.double.css", "SASS_STRING")
                    this.put("keyword.control.at-rule.css", "SASS_KEYWORD")
                    this.put("support.type.property-name.css", "SASS_PROPERTY_NAME")
                    this.put("meta.selector.css entity.name.tag", "SASS_TAG_NAME")
                    this.put("support.constant.property-value.css", "SASS_FUNCTION")
                    this.put("entity.other.attribute-name.tag", "SASS_MIXIN")
                    this.put("string.regexp", "JS.REGEXP")
                    this.put("comment.line.number-sign.yaml", "YAML_COMMENT")
                    this.put("entity.name.tag.yaml", "YAML_SCALAR_KEY")
                    this.put("string.unquoted.block.yaml", "YAML_SCALAR_VALUE")
                    this.put("string.quoted.single.yaml", "YAML_SCALAR_STRING")
                    this.put("string.quoted.double.yaml", "YAML_SCALAR_DSTRING")
                    this.put("string.unquoted.yaml", "YAML_TEXT")
                    this.put("comment.block.puppet", "PUPPET_BLOCK_COMMENT")
                    this.put("punctuation.definition.variable.puppet", "PUPPET_VARIABLE")
                    this.put("string source", "PUPPET_VARIABLE_INTERPOLATION")
                    this.put("keyword.control.puppet", "PUPPET_KEYWORD")
                    this.put("string.quoted.double.puppet", "PUPPET_STRING")
                    this.put("string.quoted.single.puppet", "PUPPET_SQ_STRING")
                    this.put("keyword.operator.assignment.puppet", "PUPPET_OPERATION_SIGN")
                    this.put("punctuation.section.scope.puppet", "PUPPET_PARENTH")
                    this.put("punctuation.definition.array.begin.puppet", "PUPPET_BRACKETS")
                    this.put("entity.name.type.class.puppet", "PUPPET_CLASS")
                    this.put("punctuation.definition.string.begin.ruby", "RUBY_HEREDOC_ID")
                    this.put("string.unquoted.heredoc.ruby", "RUBY_HEREDOC_CONTENT")
                    this.put("string.quoted.single.ruby", "RUBY_STRING")
                    this.put("string.quoted.double.ruby", "RUBY_INTERPOLATED_STRING")
                    this.put("string.quoted.other.literal.upper.ruby", "RUBY_WORDS")
                    this.put("entity.name.type.class.ruby", "RUBY_CONSTANT_DECLARATION")
                    this.put("variable.other.readwrite.global", "RUBY_GVAR")
                    this.put("variable.other.readwrite.class", "RUBY_CVAR")
                    this.put("variable.other.readwrite.instance", "RUBY_IVAR")
                    this.put("punctuation.separator.object", "RUBY_COMMA")
                    this.put("punctuation.separator.method", "RUBY_DOT")
                    this.put("punctuation.separator.statement", "RUBY_SEMICOLON")
                    this.put("punctuation.separator.key-value", "RUBY_HASH_ASSOC")
                    this.put("constant.other.symbol", "RUBY_SYMBOL")
                    this.put("punctuation.section.embedded.ruby", "RHTML_SCRIPTLET_START_ID")
                    this.put("comment.block.erb", "RHTML_COMMENT_ID")
                    this.put("source.ruby.rails.embedded.html", "RHTML_SCRIPTING_BACKGROUND_ID")
                    this.put("text.haml", "HAML_TEXT")
                    this.put("entity.name.tag.class.haml", "HAML_CLASS")
                    this.put("entity.name.tag.id.haml", "HAML_ID")
                    this.put("punctuation.definition.tag.haml", "HAML_TAG")
                    this.put("meta.tag.haml", "HAML_TAG_NAME")
                    this.put("comment.line.slash.haml", "HAML_COMMENT")
                    this.put("meta.prolog.haml", "HAML_XHTML")
                    this.put("source.ruby.embedded.haml", "HAML_RUBY_CODE")
                    this.put("meta.line.ruby.haml", "HAML_RUBY_START")
                    this.put("string.quoted.single.haml", "HAML_STRING")
                    this.put("string.quoted.double.haml", "HAML_STRING_INTERPOLATED")
                    this.put("text.slim", "SLIM_STATIC_CONTENT")
                    this.put("entity.name.tag.slim", "SLIM_TAG")
                    this.put("punctuation.definition.tag.slim", "SLIM_TAG_START")
                    this.put("comment.line.slash.slim", "SLIM_COMMENT")
                    this.put("meta.prolog.slim", "SLIM_DOCTYPE_KWD")
                    this.put("source.ruby.embedded.slim", "SLIM_RUBY_CODE")
                    this.put("meta.line.ruby.slim", "SLIM_CALL")
                    this.put("invalid.illegal.bad-ampersand.html", "SLIM_BAD_CHARACTER")
                    this.put("string.quoted.double.htm", "SLIM_STRING_INTERPOLATED")
                    this.put("text.gherkin.feature", "GHERKIN_TEXT")
                    this.put("comment.line.number-sign", "GHERKIN_COMMENT")
                    this.put("keyword.language.gherkin.feature", "GHERKIN_KEYWORD")
                    this.put("storage.type.tag.cucumber", "GHERKIN_TAG")
                    this.put("keyword.control.cucumber.table", "GHERKIN_TABLE_PIPE")
                    this.put("comment.block.coffee", "COFFEESCRIPT.BLOCK_COMMENT")
                    this.put("comment.line.coffee", "COFFEESCRIPT.LINE_COMMENT")
                    this.put("punctuation.terminator.statement.coffee", "COFFEESCRIPT.SEMICOLON")
                    this.put("meta.delimiter.object.comma.coffee", "COFFEESCRIPT.COMMA")
                    this.put("meta.delimiter.method.period.coffee", "COFFEESCRIPT.DOT")
                    this.put("entity.name.function.coffee", "COFFEESCRIPT.CLASS_NAME")
                    this.put("source.coffee", "COFFEESCRIPT.IDENTIFIER")
                    this.put("variable.assignment.coffee", "COFFEESCRIPT.OBJECT_KEY")
                    this.put("constant.numeric.coffee", "COFFEESCRIPT.NUMBER")
                    this.put("constant.language.boolean", "COFFEESCRIPT.BOOLEAN")
                    this.put("punctuation.definition.string.begin.coffee", "COFFEESCRIPT.STRING_LITERAL")
                    this.put("string.quoted.single.coffee", "COFFEESCRIPT.STRING")
                    this.put("string.quoted.double.heredoc.coffee", "COFFEESCRIPT.HEREDOC_CONTENT")
                    this.put("string.regexp.coffee", "COFFEESCRIPT.REGULAR_EXPRESSION_CONTENT")
                    this.put("punctuation.section.embedded.coffee", "COFFEESCRIPT.EXPRESSIONS_SUBSTITUTION_MARK")
                    this.put("meta.brace.round.coffee", "COFFEESCRIPT.PARENTHESIS")
                    this.put("meta.brace.square.coffee", "COFFEESCRIPT.BRACKET")
                    this.put("meta.brace.curly.coffee", "COFFEESCRIPT.BRACE")
                    this.put("keyword.operator.coffee", "COFFEESCRIPT.OPERATIONS")
                    this.put("keyword.control.coffee", "COFFEESCRIPT.KEYWORD")
                    this.put("variable.language.coffee", "COFFEESCRIPT.THIS")
                    this.put("storage.type.function.coffee", "COFFEESCRIPT.FUNCTION")
                    this.put("constant.character.escape.coffee", "COFFEESCRIPT.ESCAPE_SEQUENCE")
                    this.put("string.quoted.script.coffee", "COFFEESCRIPT.JAVASCRIPT_CONTENT")
                    this.put("keyword.other.directive", "OC.DIRECTIVE")
                    this.put("variable.other.selector.objc", "IVAR")
                    this.put("variable.language.objc", "OC.SELFSUPERTHIS")
                    this.put("meta.implementation.objc", "PROTOCOL_REFERENCE")
                    this.put("variable.parameter.function.objc", "OC.PARAMETER")
                }
            }
        val rules: MutableSet<CharSequence?> = ContainerUtil.union<CharSequence?>(
            DEFAULT_COLORS_PROVIDER.allDefaultKeys, EXTENSIONS_MAPPING.keys
        )
    }
}