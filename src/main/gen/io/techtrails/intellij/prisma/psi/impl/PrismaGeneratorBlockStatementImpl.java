// This is a generated file. Not intended for manual editing.
package io.techtrails.intellij.prisma.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static io.techtrails.intellij.prisma.psi.PrismaTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import io.techtrails.intellij.prisma.psi.*;

public class PrismaGeneratorBlockStatementImpl extends ASTWrapperPsiElement implements PrismaGeneratorBlockStatement {

  public PrismaGeneratorBlockStatementImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PrismaVisitor visitor) {
    visitor.visitGeneratorBlockStatement(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PrismaVisitor) accept((PrismaVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PsiElement getBoolean() {
    return findChildByType(BOOLEAN);
  }

  @Override
  @Nullable
  public PsiElement getEntityName() {
    return findChildByType(ENTITY_NAME);
  }

  @Override
  @Nullable
  public PsiElement getNumber() {
    return findChildByType(NUMBER);
  }

}