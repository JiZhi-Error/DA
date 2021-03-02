package com.tencent.tencentmap.mapsdk.maps.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum MapViewType {
    SurfaceView,
    TextureView,
    RenderLayer;

    public static MapViewType valueOf(String str) {
        AppMethodBeat.i(181083);
        MapViewType mapViewType = (MapViewType) Enum.valueOf(MapViewType.class, str);
        AppMethodBeat.o(181083);
        return mapViewType;
    }

    static {
        AppMethodBeat.i(181084);
        AppMethodBeat.o(181084);
    }
}
