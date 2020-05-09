// This is a generated file. Not intended for manual editing.
package io.techtrails.intellij.prisma.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static io.techtrails.intellij.prisma.psi.PrismaTypes.*;
import io.techtrails.intellij.prisma.psi.*;

public class PrismaDatasourceBlockImpl extends PrismaBlockImpl implements PrismaDatasourceBlock {

  public PrismaDatasourceBlockImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PrismaVisitor visitor) {
    visitor.visitDatasourceBlock(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PrismaVisitor) accept((PrismaVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<PrismaDatasourceBlockStatement> getDatasourceBlockStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, PrismaDatasourceBlockStatement.class);
  }

  @Override
  @Nullable
  public PsiElement getBlockName() {
    return findChildByType(BLOCK_NAME);
  }

}
