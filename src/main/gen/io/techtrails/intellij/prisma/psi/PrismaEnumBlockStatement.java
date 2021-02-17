// This is a generated file. Not intended for manual editing.
package io.techtrails.intellij.prisma.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface PrismaEnumBlockStatement extends PsiElement {

  @NotNull
  List<PrismaAttributeArgName> getAttributeArgNameList();

  @Nullable
  PrismaEnumConstant getEnumConstant();

  @Nullable
  PrismaEnumConstantValue getEnumConstantValue();

  @NotNull
  List<PrismaIdentifier> getIdentifierList();

  @Nullable
  PsiElement getModelBlockAttributeName();

  @Nullable
  PsiElement getModelFieldAttributeName();

}
