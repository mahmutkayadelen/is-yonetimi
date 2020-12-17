package com.mahmutkayadelen.isyonetimi.repository;

import com.mahmutkayadelen.isyonetimi.entity.Issue;
import com.mahmutkayadelen.isyonetimi.entity.IssueHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueHistoryRepository extends JpaRepository<IssueHistory,Long> {

}
