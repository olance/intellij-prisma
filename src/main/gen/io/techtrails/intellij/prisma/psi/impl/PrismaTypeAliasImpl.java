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

public class PrismaTypeAliasImpl extends PrismaBlockImpl implements PrismaTypeAlias {

  public PrismaTypeAliasImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull PrismaVisitor visitor) {
    visitor.visitTypeAlias(this);
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
  public PrismaTypeName getTypeName() {
    return findChildByClass(PrismaTypeName.class);
  }

  @Override
  @Nullable
  public PsiElement getDoubleComment() {
    return findChildByType(DOUBLE_COMMENT);
  }

  @Override
  @Nullable
  public PsiElement getTripleComment() {
    return findChildByType(TRIPLE_COMMENT);
  }

}
