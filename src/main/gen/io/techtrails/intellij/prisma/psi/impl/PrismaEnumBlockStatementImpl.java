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

public class PrismaEnumBlockStatementImpl extends ASTWrapperPsiElement implements PrismaEnumBlockStatement {

  public PrismaEnumBlockStatementImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PrismaVisitor visitor) {
    visitor.visitEnumBlockStatement(this);
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
  @NotNull
  public List<PrismaAttributeArgValue> getAttributeArgValueList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, PrismaAttributeArgValue.class);
  }

  @Override
  @Nullable
  public PrismaEnumConstant getEnumConstant() {
    return findChildByClass(PrismaEnumConstant.class);
  }

  @Override
  @Nullable
  public PsiElement getModelBlockAttributeName() {
    return findChildByType(MODEL_BLOCK_ATTRIBUTE_NAME);
  }

  @Override
  @Nullable
  public PsiElement getModelFieldAttributeName() {
    return findChildByType(MODEL_FIELD_ATTRIBUTE_NAME);
  }

}
