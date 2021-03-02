package com.tencent.mm.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum a {
    DEFAULT(0),
    DOODLE(3),
    MOSAIC(2),
    EMOJI_AND_TEXT(4),
    CROP_PHOTO(Integer.MAX_VALUE),
    CROP_VIDEO(Integer.MAX_VALUE),
    FILTER(1);
    
    public int value;

    public static a valueOf(String str) {
        AppMethodBeat.i(9116);
        a aVar = (a) Enum.valueOf(a.class, str);
        AppMethodBeat.o(9116);
        return aVar;
    }

    static {
        AppMethodBeat.i(9117);
        AppMethodBeat.o(9117);
    }

    private a(int i2) {
        this.value = i2;
    }
}
