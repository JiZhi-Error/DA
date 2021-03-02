package com.tencent.mm.xeffect.effect;

import android.support.e.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 15}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, hxF = {"Lcom/tencent/mm/xeffect/effect/ImageTweakParams;", "", "(Ljava/lang/String;I)V", "Brightness", a.TAG_CONTRAST, "Hue", a.TAG_SATURATION, "Temperature", "Tint", "StartAlpha", "EndAlpha", "BlurRadius", "SampleFactor", "renderlib_release"})
public enum o {
    Brightness,
    RyH,
    Hue,
    RyJ,
    Temperature,
    Tint,
    StartAlpha,
    EndAlpha,
    BlurRadius,
    SampleFactor;

    static {
        AppMethodBeat.i(237089);
        AppMethodBeat.o(237089);
    }

    public static o valueOf(String str) {
        AppMethodBeat.i(237091);
        o oVar = (o) Enum.valueOf(o.class, str);
        AppMethodBeat.o(237091);
        return oVar;
    }
}
