package com.tencent.tencentmap.mapsdk.maps.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;

public enum MapKernel implements TencentMapOptions.IMapKernel {
    Vector;

    public static MapKernel valueOf(String str) {
        AppMethodBeat.i(181076);
        MapKernel mapKernel = (MapKernel) Enum.valueOf(MapKernel.class, str);
        AppMethodBeat.o(181076);
        return mapKernel;
    }

    static {
        AppMethodBeat.i(181077);
        AppMethodBeat.o(181077);
    }
}
