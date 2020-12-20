package com.mahmutkayadelen.isyonetimi.repository;

import com.mahmutkayadelen.isyonetimi.entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
/**
 * Create by mkayadelen 13.12.2020
 *
 */
public interface ProjectRepository extends JpaRepository<Project, Long> {

    Project getAllByProjectCode(String projectCode);

    List<Project> getAllByProjectCodeAndProjectNameContains(String projectCode, String name);

    Page<Project> findAll(Pageable pageable); //sayfalama yapıyor işte istediğimiz yerden çağırmak için falan işe yarıyor.

    List<Project> findAll(Sort sort);

}
