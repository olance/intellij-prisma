// This is a generated file. Not intended for manual editing.
package io.techtrails.intellij.prisma.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class PrismaVisitor extends PsiElementVisitor {

  public void visitBlock(@NotNull PrismaBlock o) {
    visitPsiElement(o);
  }

  public void visitDatasourceBlock(@NotNull PrismaDatasourceBlock o) {
    visitBlock(o);
  }

  public void visitDatasourceBlockStatement(@NotNull PrismaDatasourceBlockStatement o) {
    visitPsiElement(o);
  }

  public void visitEnumBlock(@NotNull PrismaEnumBlock o) {
    visitBlock(o);
  }

  public void visitEnumBlockStatement(@NotNull PrismaEnumBlockStatement o) {
    visitPsiElement(o);
  }

  public void visitGeneratorBlock(@NotNull PrismaGeneratorBlock o) {
    visitBlock(o);
  }

  public void visitGeneratorBlockStatement(@NotNull PrismaGeneratorBlockStatement o) {
    visitPsiElement(o);
  }

  public void visitModelAttributeParamName(@NotNull PrismaModelAttributeParamName o) {
    visitPsiElement(o);
  }

  public void visitModelAttributeParamValue(@NotNull PrismaModelAttributeParamValue o) {
    visitPsiElement(o);
  }

  public void visitModelBlock(@NotNull PrismaModelBlock o) {
    visitBlock(o);
  }

  public void visitModelBlockAttribute(@NotNull PrismaModelBlockAttribute o) {
    visitPsiElement(o);
  }

  public void visitModelBlockStatement(@NotNull PrismaModelBlockStatement o) {
    visitPsiElement(o);
  }

  public void visitModelFieldAttribute(@NotNull PrismaModelFieldAttribute o) {
    visitPsiElement(o);
  }

  public void visitModelFieldType(@NotNull PrismaModelFieldType o) {
    visitPsiElement(o);
  }

  public void visitModelTypeModifier(@NotNull PrismaModelTypeModifier o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
