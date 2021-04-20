// This is a generated file. Not intended for manual editing.
package io.techtrails.intellij.prisma.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface PrismaModelBlockStatement extends PsiElement {

  @NotNull
  List<PrismaAttributeArgName> getAttributeArgNameList();

  @NotNull
  List<PrismaAttributeArgValue> getAttributeArgValueList();

  @Nullable
  PrismaFieldName getFieldName();

  @Nullable
  PrismaFieldType getFieldType();

  @Nullable
  PsiElement getModelBlockAttributeName();

}
