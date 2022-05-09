package com.zotdrive.searchservice.document;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.zotdrive.searchservice.helper.Indices;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;

import java.util.Date;

//@Document(indexName = Indices.FILE_INDEX)
public class FileObject {

    //@Id
    private String id;

    private String name;

    private String tag;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date created;

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date createdAt) {
        this.created = createdAt;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
