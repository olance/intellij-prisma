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

public class PrismaModelFieldAttributeImpl extends ASTWrapperPsiElement implements PrismaModelFieldAttribute {

  public PrismaModelFieldAttributeImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PrismaVisitor visitor) {
    visitor.visitModelFieldAttribute(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PrismaVisitor) accept((PrismaVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<PrismaModelAttributeParamName> getModelAttributeParamNameList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, PrismaModelAttributeParamName.class);
  }

  @Override
  @NotNull
  public List<PrismaModelAttributeParamValue> getModelAttributeParamValueList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, PrismaModelAttributeParamValue.class);
  }

  @Override
  @NotNull
  public PsiElement getModelFieldAttributeName() {
    return findNotNullChildByType(MODEL_FIELD_ATTRIBUTE_NAME);
  }

}
