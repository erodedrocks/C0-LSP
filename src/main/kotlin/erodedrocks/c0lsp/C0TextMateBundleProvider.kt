package erodedrocks.c0lsp

import com.intellij.openapi.application.PathManager
import org.jetbrains.plugins.textmate.api.TextMateBundleProvider
import org.jetbrains.plugins.textmate.language.syntax.highlighting.TextMateSyntaxHighlighterFactory
import java.io.IOException
import java.net.URL
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.nio.file.StandardCopyOption
import java.util.Arrays
import java.util.Collections.singletonList
import kotlin.io.path.Path


class C0TextMateBundleProvider : TextMateBundleProvider {
    override fun getBundles(): List<TextMateBundleProvider.PluginBundle> {
        val tmp: Path = Files.createTempDirectory(
            Paths.get(PathManager.getTempPath()), "textmate"
        )

        val tmBundleFiles: MutableList<String> = mutableListOf(
            "Syntaxes/BC0.tmLanguage",
            "Syntaxes/C0.tmLanguage",
            "Syntaxes/Clac.tmLanguage",
            "info.plist"
        )

        val classLoader = C0TextMateBundleProvider::class.java.getClassLoader()

        for (file in tmBundleFiles) {
            val resource: URL = classLoader.getResource("textmatebundle/c0/" + file)!!

            resource.openStream().use { resourceStream ->
                val target: Path = tmp.resolve(file)
                Files.createDirectories(target.parent)
                Files.copy(resourceStream, target, StandardCopyOption.REPLACE_EXISTING)
            }
        }

        return singletonList(TextMateBundleProvider.PluginBundle("c0", tmp))
    }
}