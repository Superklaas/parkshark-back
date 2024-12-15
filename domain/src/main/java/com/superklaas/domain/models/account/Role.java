package com.superklaas.domain.models.account;

import org.assertj.core.util.Lists;

import java.util.List;

import static com.superklaas.domain.models.account.Feature.*;

public enum Role {

    MANAGER(CREATE_PARKING_LOT, CREATE_DIVISION, VIEW_ALL_DIVISIONS, GET_ALL_PARKING_LOTS),
    MEMBER(ALLOCATE_PARKING_SPOT);

    private final List<Feature> featureList;

    Role(Feature... featureList) {
        this.featureList = Lists.newArrayList(featureList);
    }

    public List<Feature> getFeatureList() {
        return featureList;
    }

}
