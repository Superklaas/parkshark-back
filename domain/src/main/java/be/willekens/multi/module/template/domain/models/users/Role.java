package be.willekens.multi.module.template.domain.models.users;

import org.assertj.core.util.Lists;

import java.util.List;

public enum Role {

    MANAGER(Feature.CREATE_PARKING_LOT);

    private final List<Feature> featureList;

    Role(Feature... featureList) {
        this.featureList = Lists.newArrayList(featureList);
    }

    public List<Feature> getFeatureList() {
        return featureList;
    }
}
