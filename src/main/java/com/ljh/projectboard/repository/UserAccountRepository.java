package com.ljh.projectboard.repository;

import com.ljh.projectboard.domain.UserAccount;
import com.ljh.projectboard.domain.projection.UserAccountProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(excerptProjection = UserAccountProjection.class)
public interface UserAccountRepository extends JpaRepository<UserAccount, String> {
}
