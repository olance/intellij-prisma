package io.techtrails.intellij.prisma

import com.intellij.testFramework.ParsingTestCase

class PrismaParserTest : ParsingTestCase("parser", "prisma", PrismaParserDefinition()) {
    fun testCompleteSchema() = doTest(true)

    override fun getTestDataPath() = "src/test/testData"
    override fun includeRanges() = true
}