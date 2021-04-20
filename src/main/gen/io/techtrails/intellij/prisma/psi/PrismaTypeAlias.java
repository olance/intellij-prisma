// This is a generated file. Not intended for manual editing.
package io.techtrails.intellij.prisma.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface PrismaTypeAlias extends PrismaBlock {

  @NotNull
  List<PrismaAttributeArgName> getAttributeArgNameList();

  @NotNull
  List<PrismaAttributeArgValue> getAttributeArgValueList();

  @Nullable
  PrismaFieldType getFieldType();

  @Nullable
  PrismaTypeName getTypeName();

  @Nullable
  PsiElement getDoubleComment();

  @Nullable
  PsiElement getTripleComment();

}
