package com.tencent.mapsdk.raster.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class CustomLayerOptions {
    private String mLayerId;
    private String mLayerVersion;

    public CustomLayerOptions layerId(String str) {
        AppMethodBeat.i(181497);
        if (!TextUtils.isEmpty(str)) {
            this.mLayerId = str;
        }
        AppMethodBeat.o(181497);
        return this;
    }

    public String getLayerId() {
        return this.mLayerId;
    }
}
