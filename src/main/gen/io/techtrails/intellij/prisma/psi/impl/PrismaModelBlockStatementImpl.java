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

public class PrismaModelBlockStatementImpl extends ASTWrapperPsiElement implements PrismaModelBlockStatement {

  public PrismaModelBlockStatementImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PrismaVisitor visitor) {
    visitor.visitModelBlockStatement(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PrismaVisitor) accept((PrismaVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<PrismaAttributeArgName> getAttributeArgNameList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, PrismaAttributeArgName.class);
  }

  @Override
  @Nullable
  public PrismaFieldName getFieldName() {
    return findChildByClass(PrismaFieldName.class);
  }

  @Override
  @Nullable
  public PrismaFieldType getFieldType() {
    return findChildByClass(PrismaFieldType.class);
  }

  @Override
  @NotNull
  public List<PrismaIdentifier> getIdentifierList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, PrismaIdentifier.class);
  }

  @Override
  @Nullable
  public PsiElement getModelBlockAttributeName() {
    return findChildByType(MODEL_BLOCK_ATTRIBUTE_NAME);
  }

}
