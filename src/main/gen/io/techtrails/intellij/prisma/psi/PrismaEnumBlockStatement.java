// This is a generated file. Not intended for manual editing.
package io.techtrails.intellij.prisma.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface PrismaEnumBlockStatement extends PsiElement {

  @NotNull
  List<PrismaAttributeArgName> getAttributeArgNameList();

  @NotNull
  List<PrismaAttributeArgValue> getAttributeArgValueList();

  @Nullable
  PrismaEnumConstant getEnumConstant();

  @Nullable
  PrismaEnumConstantValue getEnumConstantValue();

  @Nullable
  PsiElement getModelBlockAttributeName();

  @Nullable
  PsiElement getModelFieldAttributeName();

}
