// This is a generated file. Not intended for manual editing.
package io.techtrails.intellij.prisma.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface PrismaTypeAlias extends PsiElement {

  @NotNull
  List<PrismaAttributeArgName> getAttributeArgNameList();

  @Nullable
  PrismaFieldType getFieldType();

  @NotNull
  List<PrismaIdentifier> getIdentifierList();

  @Nullable
  PrismaTypeName getTypeName();

  @Nullable
  PsiElement getDoubleComment();

  @Nullable
  PsiElement getTripleComment();

}
