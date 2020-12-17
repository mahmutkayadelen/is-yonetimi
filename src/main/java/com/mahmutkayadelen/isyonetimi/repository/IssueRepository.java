package com.mahmutkayadelen.isyonetimi.repository;

import com.mahmutkayadelen.isyonetimi.entity.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRepository extends JpaRepository<Issue,Long> {

}
