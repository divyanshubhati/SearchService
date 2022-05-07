package com.zotdrive.searchservice.service;

import com.zotdrive.searchservice.document.File;
import com.zotdrive.searchservice.repositories.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileService {

    private final FileRepository repository;

    @Autowired
    public FileService(FileRepository repository) {
        this.repository = repository;
    }

    public void save(final File file){
        repository.save(file);
    }

    public File findById(final Long id){
        return repository.findById(id).orElse(null);
    }

}
