package com.spring.fullstack.s3buckets;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum BucketName {

    PROFILE_IMAGE("image-fullstack-upload-123");

    private final String bucketName;

}
