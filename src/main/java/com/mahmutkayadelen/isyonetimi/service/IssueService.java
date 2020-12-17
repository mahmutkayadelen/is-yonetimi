package com.mahmutkayadelen.isyonetimi.service;

import com.mahmutkayadelen.isyonetimi.dto.IssueDto;
import com.mahmutkayadelen.isyonetimi.entity.Issue;
import com.mahmutkayadelen.isyonetimi.util.Tpage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
/**
 * Create by mkayadelen 14.12.2020
 *
 */
public interface IssueService {
   IssueDto save(IssueDto issue) throws IllegalAccessException;

   IssueDto getById(Long id);

   Tpage<IssueDto> getAllPageable(Pageable pageable);  //5 sayfayaı gösyter 5. sayfayı gönder gibi

   Boolean delete(IssueDto issue);

}
