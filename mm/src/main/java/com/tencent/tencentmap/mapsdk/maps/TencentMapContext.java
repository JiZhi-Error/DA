package com.tencent.tencentmap.mapsdk.maps;

import android.content.Context;

public interface TencentMapContext extends TencentMapComponent, TencentMapResource {
    Context getContext();

    TencentMapComponent getMapComponent();

    TencentMapResource getMapResource();
}
