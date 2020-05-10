import com.intellij.testFramework.ParsingTestCase
import io.techtrails.intellij.prisma.PrismaParserDefinition

class PrismaParserTest : ParsingTestCase("parser", "prisma", PrismaParserDefinition()) {
    fun testCompleteSchema() = doTest(true)

    override fun getTestDataPath() = "src/test/testData"
    override fun includeRanges() = true
}