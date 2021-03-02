package com.tencent.tencentmap.mapsdk.maps.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class IndoorBuilding implements Cloneable {
    private int mActiveLevelIndex;
    private String mBuidlingId;
    private String mBuildingName;
    private LatLng mLatLng;
    private List<IndoorLevel> mLevels;

    public IndoorBuilding(String str, String str2, LatLng latLng, List<IndoorLevel> list, int i2) {
        this.mBuidlingId = str;
        this.mBuildingName = str2;
        this.mLatLng = latLng;
        this.mLevels = list;
        this.mActiveLevelIndex = i2;
    }

    public final String getBuidlingId() {
        return this.mBuidlingId;
    }

    public final String getBuildingName() {
        return this.mBuildingName;
    }

    public final List<IndoorLevel> getLevels() {
        return this.mLevels;
    }

    public final int getActiveLevelIndex() {
        return this.mActiveLevelIndex;
    }

    public final LatLng getBuildingLatLng() {
        return this.mLatLng;
    }

    public final String toString() {
        AppMethodBeat.i(173139);
        if (this.mBuidlingId == null || this.mLevels == null || this.mLevels.size() <= this.mActiveLevelIndex) {
            AppMethodBeat.o(173139);
            return "";
        }
        String str = this.mBuidlingId + "_" + this.mLevels.get(this.mActiveLevelIndex).getName();
        AppMethodBeat.o(173139);
        return str;
    }

    /* access modifiers changed from: protected */
    @Override // java.lang.Object
    public final Object clone() {
        AppMethodBeat.i(173140);
        IndoorBuilding indoorBuilding = (IndoorBuilding) super.clone();
        if (this.mLevels != null) {
            indoorBuilding.mLevels = new ArrayList(this.mLevels.size());
            for (int i2 = 0; i2 < this.mLevels.size(); i2++) {
                indoorBuilding.mLevels.add(new IndoorLevel(this.mLevels.get(i2).getName()));
            }
        }
        if (this.mLatLng != null) {
            indoorBuilding.mLatLng = new LatLng(this.mLatLng.latitude, this.mLatLng.longitude);
        }
        AppMethodBeat.o(173140);
        return indoorBuilding;
    }
}
