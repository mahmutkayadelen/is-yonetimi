package com.mahmutkayadelen.isyonetimi.service.impl;

import com.mahmutkayadelen.isyonetimi.dto.IssueDto;
import com.mahmutkayadelen.isyonetimi.entity.Issue;
import com.mahmutkayadelen.isyonetimi.repository.IssueRepository;
import com.mahmutkayadelen.isyonetimi.service.IssueService;
import com.mahmutkayadelen.isyonetimi.util.Tpage;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * Create by mkayadelen 14.12.2020
 */
@Service
public class IssueServiceImpl implements IssueService {

    //@Autowired
    // private IssueRepository  issueRepository;  //birinci yol
    private final IssueRepository issueRepository;
    private final ModelMapper modelMapper;

    public IssueServiceImpl(IssueRepository issueRepository, ModelMapper modelMapper) {
        this.issueRepository = issueRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public IssueDto save(IssueDto issue) {
        if (issue.getDate() == null) {
            throw new IllegalArgumentException("Tarih boş olamaz");
        }
        Issue issueDb = modelMapper.map(issue, Issue.class);
        issueRepository.save(issueDb);
        return modelMapper.map(issueDb, IssueDto.class);
    }

    @Override
    public IssueDto getById(Long id) {
        Issue issue = issueRepository.getOne(id);

        return modelMapper.map(issue, IssueDto.class);
    }

    @Override
    public Tpage<IssueDto> getAllPageable(Pageable pageable) {
        Page<Issue> data = issueRepository.findAll(pageable);
        Tpage page = new Tpage<IssueDto>();
        IssueDto[] dtos = modelMapper.map(data.getContent(), IssueDto[].class);
        page.setStat(data, Arrays.asList(dtos));
        return page;
    }

    @Override
    public Boolean delete(IssueDto issue) {

        return null;
    }

    @Override
    public Boolean delete(Long id) {
        issueRepository.deleteById(id);
        return true;
    }

    @Override
    public IssueDto update(IssueDto issue) {
        {
            Issue projectDb = issueRepository.getOne(issue.getId());

            Issue guncellenek = modelMapper.map(issue, Issue.class);
            issueRepository.save(guncellenek);
            return modelMapper.map(guncellenek, IssueDto.class);
        }
    }
}
