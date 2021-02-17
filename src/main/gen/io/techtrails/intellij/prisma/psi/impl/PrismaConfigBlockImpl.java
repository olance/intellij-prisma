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

public class PrismaConfigBlockImpl extends PrismaBlockImpl implements PrismaConfigBlock {

  public PrismaConfigBlockImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull PrismaVisitor visitor) {
    visitor.visitConfigBlock(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PrismaVisitor) accept((PrismaVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PrismaBlockName getBlockName() {
    return findChildByClass(PrismaBlockName.class);
  }

  @Override
  @NotNull
  public List<PrismaConfigBlockStatement> getConfigBlockStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, PrismaConfigBlockStatement.class);
  }

}
