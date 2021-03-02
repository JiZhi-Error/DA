package com.tencent.mm.xeffect.effect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 15}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/xeffect/effect/PAGReplacementType;", "", "(Ljava/lang/String;I)V", "Image", "Text", "renderlib_release"})
public enum q {
    Image,
    Text;

    static {
        AppMethodBeat.i(237094);
        AppMethodBeat.o(237094);
    }

    public static q valueOf(String str) {
        AppMethodBeat.i(237096);
        q qVar = (q) Enum.valueOf(q.class, str);
        AppMethodBeat.o(237096);
        return qVar;
    }
}
