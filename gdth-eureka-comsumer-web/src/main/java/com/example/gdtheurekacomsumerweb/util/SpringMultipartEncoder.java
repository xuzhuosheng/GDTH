package com.example.gdtheurekacomsumerweb.util;

import feign.RequestTemplate;
import feign.codec.Encoder;
import feign.form.ContentType;
import feign.form.FormEncoder;
import feign.form.MultipartFormContentProcessor;
import feign.form.spring.SpringManyMultipartFilesWriter;
import feign.form.spring.SpringSingleMultipartFileWriter;
import org.springframework.web.multipart.MultipartFile;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.Map;

public class SpringMultipartEncoder extends FormEncoder {


    public SpringMultipartEncoder() {
        this(new Default());
    }


    public SpringMultipartEncoder(Encoder delegate) {
        super(delegate);

        MultipartFormContentProcessor processor = (MultipartFormContentProcessor) getContentProcessor(ContentType.MULTIPART);
        processor.addWriter(new SpringManyMultipartFilesWriter());
        processor.addWriter(new SpringSingleMultipartFileWriter());

    }


    @Override
    public void encode(Object object, Type bodyType, RequestTemplate template) {
        if (bodyType.equals(MultipartFile.class)) {
            MultipartFile file = (MultipartFile) object;
            Map data = Collections.singletonMap(file.getName(), object);
            super.encode(data, MAP_STRING_WILDCARD, template);
            return;
        } else if (bodyType.equals(MultipartFile[].class)) {
            MultipartFile[] files = (MultipartFile[]) object;
            if (files != null) {
                Map data = Collections.singletonMap(files.length == 0 ? "" : files[0].getName(), object);
                super.encode(data, MAP_STRING_WILDCARD, template);
                return;
            }
        }

        super.encode(object, bodyType, template);
    }


}
