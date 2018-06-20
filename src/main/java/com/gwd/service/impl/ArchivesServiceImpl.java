package com.gwd.service.impl;

import com.gwd.dao.ArchivesDao;
import com.gwd.entity.Archives;
import com.gwd.service.ArchivesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("archivesService")
public class ArchivesServiceImpl implements ArchivesService {

    @Resource
    private ArchivesDao archivesDao;

    @Override
    public List<Archives> selectAllArchives() {
        return archivesDao.selectAllArchives();
    }
}
