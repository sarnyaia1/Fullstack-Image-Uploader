package com.spring.fullstack.profile;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Data
public class UserProfile {

    private UUID userProfileId;
    private String userName;
    private String userProfileImageLink; // S3 Key

    public Optional<String> getUserProfileImageLink(){
        return Optional.ofNullable(userProfileImageLink);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserProfile that = (UserProfile) o;
        return Objects.equals(userProfileId, that.userProfileId)
                && Objects.equals(userName,that.userName)
                && Objects.equals(userProfileImageLink, that.userProfileImageLink);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userProfileId, userName, userProfileImageLink);
    }
}
