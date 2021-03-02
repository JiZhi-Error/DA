package com.tencent.map.lib.models;

import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Keep
public class SubMarkerInfo {
    private boolean mAvoidOtherMarker = false;
    private int mIconHeight;
    private String mIconName;
    private int mIconWidth;
    private boolean mInteractive = false;
    private boolean mIsAvoidAnnotation = false;

    public SubMarkerInfo iconName(String str) {
        this.mIconName = str;
        return this;
    }

    public SubMarkerInfo iconWidth(int i2) {
        this.mIconWidth = i2;
        return this;
    }

    public SubMarkerInfo iconHeight(int i2) {
        this.mIconHeight = i2;
        return this;
    }

    public SubMarkerInfo interactive(boolean z) {
        this.mInteractive = z;
        return this;
    }

    public SubMarkerInfo avoidAnnotation(boolean z) {
        this.mIsAvoidAnnotation = z;
        return this;
    }

    public SubMarkerInfo avoidOtherMarker(boolean z) {
        this.mAvoidOtherMarker = z;
        return this;
    }

    public String toString() {
        AppMethodBeat.i(193501);
        String str = "SubMarkerInfo{mIconName='" + this.mIconName + '\'' + ", mIconWidth=" + this.mIconWidth + ", mIconHeight=" + this.mIconHeight + ", mInteractive=" + this.mInteractive + ", mIsAvoidAnnotation=" + this.mIsAvoidAnnotation + ", mAvoidOtherMarker=" + this.mAvoidOtherMarker + '}';
        AppMethodBeat.o(193501);
        return str;
    }
}
