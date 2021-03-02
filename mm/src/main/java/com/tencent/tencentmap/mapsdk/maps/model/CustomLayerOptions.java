package com.tencent.tencentmap.mapsdk.maps.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class CustomLayerOptions {
    private String mLayerId;
    private String mLayerVersion;

    public CustomLayerOptions layerId(String str) {
        AppMethodBeat.i(173135);
        if (!TextUtils.isEmpty(str)) {
            this.mLayerId = str;
        }
        AppMethodBeat.o(173135);
        return this;
    }

    public String getLayerId() {
        return this.mLayerId;
    }
}
