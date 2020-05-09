// This is a generated file. Not intended for manual editing.
package io.techtrails.intellij.prisma.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface PrismaDatasourceBlock extends PrismaBlock {

  @NotNull
  List<PrismaDatasourceBlockStatement> getDatasourceBlockStatementList();

  @Nullable
  PsiElement getBlockName();

}
