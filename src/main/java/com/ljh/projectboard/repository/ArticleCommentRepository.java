package com.ljh.projectboard.repository;

import com.ljh.projectboard.domain.ArticleComment;
import com.ljh.projectboard.domain.QArticleComment;
import com.ljh.projectboard.domain.projection.ArticleCommentProjection;
import com.querydsl.core.types.dsl.DateTimeExpression;
import com.querydsl.core.types.dsl.StringExpression;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(excerptProjection = ArticleCommentProjection.class)
public interface ArticleCommentRepository extends JpaRepository<ArticleComment,
        Long>, QuerydslPredicateExecutor<ArticleComment>, QuerydslBinderCustomizer<QArticleComment> {

    List<ArticleComment> findByArticle_Id(Long articleId);
    void deleteByIdAndUserAccount_UserId(Long articleId, String userid);

    @Override
    default void customize(QuerydslBindings bindings, QArticleComment root){
        bindings.excludeUnlistedProperties(true);
        bindings.including(root.content, root.createdAt, root.createdAt);
        bindings.bind(root.content).first(StringExpression::containsIgnoreCase); // LIKE '%${v}%'
        bindings.bind(root.createdAt).first(DateTimeExpression::eq);
        bindings.bind(root.createdBy).first(StringExpression::containsIgnoreCase);
    }
}
