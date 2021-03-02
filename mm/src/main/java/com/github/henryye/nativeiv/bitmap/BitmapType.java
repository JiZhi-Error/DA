package com.github.henryye.nativeiv.bitmap;

import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Keep
public enum BitmapType {
    Native,
    Legacy,
    Undefined;

    public static BitmapType valueOf(String str) {
        AppMethodBeat.i(127360);
        BitmapType bitmapType = (BitmapType) Enum.valueOf(BitmapType.class, str);
        AppMethodBeat.o(127360);
        return bitmapType;
    }

    static {
        AppMethodBeat.i(127361);
        AppMethodBeat.o(127361);
    }
}
