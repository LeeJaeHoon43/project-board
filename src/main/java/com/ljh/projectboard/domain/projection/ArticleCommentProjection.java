package com.ljh.projectboard.domain.projection;

import com.ljh.projectboard.domain.ArticleComment;
import com.ljh.projectboard.domain.UserAccount;
import org.springframework.data.rest.core.config.Projection;
import java.time.LocalDateTime;

@Projection(name = "withUserAccount", types = ArticleComment.class)
public interface ArticleCommentProjection {
    Long getId();
    UserAccount getUserAccount();
    Long getParentCommentId();
    String getContent();
    LocalDateTime getCreatedAt();
    String getCreatedBy();
    LocalDateTime getModifiedAt();
    String getModifiedBy();
}
