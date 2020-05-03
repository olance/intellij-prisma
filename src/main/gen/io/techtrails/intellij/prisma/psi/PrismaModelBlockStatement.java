// This is a generated file. Not intended for manual editing.
package io.techtrails.intellij.prisma.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface PrismaModelBlockStatement extends PsiElement {

  @Nullable
  PrismaModelBlockAttribute getModelBlockAttribute();

  @NotNull
  List<PrismaModelFieldAttribute> getModelFieldAttributeList();

  @Nullable
  PrismaModelFieldType getModelFieldType();

  @Nullable
  PsiElement getEntityName();

}
