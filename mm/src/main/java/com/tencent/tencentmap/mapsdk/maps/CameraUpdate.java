package com.tencent.tencentmap.mapsdk.maps;

import com.tencent.tencentmap.mapsdk.maps.model.CamerParameter;

public final class CameraUpdate {
    private final CamerParameter camerPara;

    CameraUpdate(CamerParameter camerParameter) {
        this.camerPara = camerParameter;
    }

    public final CamerParameter getParams() {
        return this.camerPara;
    }
}
