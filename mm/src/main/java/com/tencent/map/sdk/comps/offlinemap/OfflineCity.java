package com.tencent.map.sdk.comps.offlinemap;

public final class OfflineCity extends OfflineItem {
    private OfflineProvince mProvince;

    public final OfflineProvince getProvince() {
        return this.mProvince;
    }

    public final void setProvince(OfflineProvince offlineProvince) {
        this.mProvince = offlineProvince;
    }
}
