package com.hangduykhiem.springboottest.repo;

import com.hangduykhiem.springboottest.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Long> {
}
