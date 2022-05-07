package com.zotdrive.searchservice.document;


import com.zotdrive.searchservice.helper.Indices;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;

@Document(indexName = Indices.FILE_INDEX)
@Setting(settingPath = "static/es-settings.json")
public class File {

    @Id
    @Field(type = FieldType.Long)
    private long id;

    @Field(type = FieldType.Text)
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
