package com.tencent.map.sdk.comps.offlinemap;

import java.util.List;

public final class OfflineProvince extends OfflineItem {
    private List<OfflineCity> mCities;

    public final List<OfflineCity> getCities() {
        return this.mCities;
    }

    public final void setCities(List<OfflineCity> list) {
        this.mCities = list;
    }
}
