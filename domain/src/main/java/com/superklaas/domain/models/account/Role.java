package com.superklaas.domain.models.account;

import org.assertj.core.util.Lists;

import java.util.List;

public enum Role {
    MANAGER(Feature.CREATE_PARKING_LOT, Feature.CREATE_DIVISION, Feature.VIEW_ALL_DIVISIONS, Feature.GET_ALL_PARKING_LOTS),
    MEMBER(Feature.ALLOCATE_PARKING_SPOT);

    private final List<Feature> featureList;

    Role(Feature... featureList) {
        this.featureList = Lists.newArrayList(featureList);
    }

    public List<Feature> getFeatureList() {
        return featureList;
    }
}
