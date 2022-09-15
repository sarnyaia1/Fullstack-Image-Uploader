package com.spring.fullstack.dataStore;

import com.spring.fullstack.profile.UserProfile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class FakeUserProfileDataStore {

    private static final List<UserProfile> USER_PROFILES = new ArrayList<>();

    static{
        USER_PROFILES.add(new UserProfile(UUID.fromString("a575e6d4-c4cb-467f-9887-9151e52812c2"), "janetjones", null));
        USER_PROFILES.add(new UserProfile(UUID.fromString("3d7a626e-f034-4fff-9887-d9e019be7918"), "antoniojunior", null));
    }

    public List<UserProfile> getUserProfiles(){
        return USER_PROFILES;
    }
}
