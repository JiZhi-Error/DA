package com.tencent.liteav.basic.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum c {
    RESOLUTION_TYPE_INVALID,
    RESOLUTION_TYPE_360_640,
    RESOLUTION_TYPE_540_960,
    RESOLUTION_TYPE_720_1280,
    RESOLUTION_TYPE_640_360,
    RESOLUTION_TYPE_960_540,
    RESOLUTION_TYPE_1280_720,
    RESOLUTION_TYPE_320_480,
    RESOLUTION_TYPE_180_320,
    RESOLUTION_TYPE_270_480,
    RESOLUTION_TYPE_320_180,
    RESOLUTION_TYPE_480_270,
    RESOLUTION_TYPE_240_320,
    RESOLUTION_TYPE_360_480,
    RESOLUTION_TYPE_480_640,
    RESOLUTION_TYPE_320_240,
    RESOLUTION_TYPE_480_360,
    RESOLUTION_TYPE_640_480,
    RESOLUTION_TYPE_480_480,
    RESOLUTION_TYPE_270_270,
    RESOLUTION_TYPE_160_160,
    RESOLUTION_TYPE_120_120,
    RESOLUTION_TYPE_1080_1920,
    RESOLUTION_TYPE_1920_1080;

    public static c valueOf(String str) {
        AppMethodBeat.i(222181);
        c cVar = (c) Enum.valueOf(c.class, str);
        AppMethodBeat.o(222181);
        return cVar;
    }

    static {
        AppMethodBeat.i(222182);
        AppMethodBeat.o(222182);
    }
}
