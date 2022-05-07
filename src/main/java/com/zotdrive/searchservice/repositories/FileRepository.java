package com.zotdrive.searchservice.repositories;

import com.zotdrive.searchservice.document.File;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface FileRepository extends ElasticsearchRepository<File, Long> {
}
