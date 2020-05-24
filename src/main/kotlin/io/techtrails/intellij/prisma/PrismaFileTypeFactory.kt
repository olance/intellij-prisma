package io.techtrails.intellij.prisma

import com.intellij.openapi.fileTypes.FileTypeConsumer
import com.intellij.openapi.fileTypes.FileTypeFactory

/**
 * This is being used only in versions 171.*-192, as the fileTypeFactory extension point has been replaced by fileType
 */
@Suppress("DEPRECATION")
class PrismaFileTypeFactory : FileTypeFactory() {
    override fun createFileTypes(consumer: FileTypeConsumer) = consumer.consume(PrismaFileType)
}