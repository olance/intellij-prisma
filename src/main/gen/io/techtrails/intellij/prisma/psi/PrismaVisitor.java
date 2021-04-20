// This is a generated file. Not intended for manual editing.
package io.techtrails.intellij.prisma.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class PrismaVisitor extends PsiElementVisitor {

  public void visitAttributeArgName(@NotNull PrismaAttributeArgName o) {
    visitPsiElement(o);
  }

  public void visitAttributeArgValue(@NotNull PrismaAttributeArgValue o) {
    visitPsiElement(o);
  }

  public void visitBlock(@NotNull PrismaBlock o) {
    visitPsiElement(o);
  }

  public void visitBlockName(@NotNull PrismaBlockName o) {
    visitPsiElement(o);
  }

  public void visitConfigBlock(@NotNull PrismaConfigBlock o) {
    visitBlock(o);
  }

  public void visitConfigBlockStatement(@NotNull PrismaConfigBlockStatement o) {
    visitPsiElement(o);
  }

  public void visitEnumBlock(@NotNull PrismaEnumBlock o) {
    visitBlock(o);
  }

  public void visitEnumBlockStatement(@NotNull PrismaEnumBlockStatement o) {
    visitPsiElement(o);
  }

  public void visitEnumConstant(@NotNull PrismaEnumConstant o) {
    visitPsiElement(o);
  }

  public void visitEnumConstantValue(@NotNull PrismaEnumConstantValue o) {
    visitPsiElement(o);
  }

  public void visitFieldName(@NotNull PrismaFieldName o) {
    visitPsiElement(o);
  }

  public void visitFieldType(@NotNull PrismaFieldType o) {
    visitPsiElement(o);
  }

  public void visitFieldValue(@NotNull PrismaFieldValue o) {
    visitPsiElement(o);
  }

  public void visitIdentifier(@NotNull PrismaIdentifier o) {
    visitPsiElement(o);
  }

  public void visitModelBlock(@NotNull PrismaModelBlock o) {
    visitBlock(o);
  }

  public void visitModelBlockStatement(@NotNull PrismaModelBlockStatement o) {
    visitPsiElement(o);
  }

  public void visitTypeAlias(@NotNull PrismaTypeAlias o) {
    visitBlock(o);
  }

  public void visitTypeModifier(@NotNull PrismaTypeModifier o) {
    visitPsiElement(o);
  }

  public void visitTypeName(@NotNull PrismaTypeName o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
