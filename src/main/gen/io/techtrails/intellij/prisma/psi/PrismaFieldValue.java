// This is a generated file. Not intended for manual editing.
package io.techtrails.intellij.prisma.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface PrismaFieldValue extends PsiElement {

  @NotNull
  List<PrismaFieldValue> getFieldValueList();

  @Nullable
  PsiElement getBoolean();

  @Nullable
  PsiElement getNumber();

  @Nullable
  PsiElement getString();

}
