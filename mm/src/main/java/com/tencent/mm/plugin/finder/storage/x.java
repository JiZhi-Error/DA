package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;", "", "detail", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getDetail", "()Ljava/lang/String;", "FULL_IMAGE", "THUMB_IMAGE", "V0_VIDEO", "V1_VIDEO", "V2_VIDEO", "V3_VIDEO", "V4_VIDEO", "V5_VIDEO", "V6_VIDEO", "V7_VIDEO", "V8_VIDEO", "V9_VIDEO", "V10_VIDEO", "V99_VIDEO", "FULL_PAG", "PREVIEW_PAG", "plugin-finder_release"})
public enum x {
    FULL_IMAGE("full_image"),
    THUMB_IMAGE("thumb_image"),
    V0_VIDEO("xV0"),
    V1_VIDEO("xV1"),
    V2_VIDEO("xV2"),
    V3_VIDEO("xV3"),
    V4_VIDEO("xV4"),
    V5_VIDEO("xV5"),
    V6_VIDEO("xV6"),
    V7_VIDEO("xV7"),
    V8_VIDEO("xV8"),
    V9_VIDEO("xV9"),
    V10_VIDEO("xV10"),
    V99_VIDEO("xV99"),
    FULL_PAG("full_pag"),
    PREVIEW_PAG("preview_pag");
    
    public final String detail;

    public static x valueOf(String str) {
        AppMethodBeat.i(167029);
        x xVar = (x) Enum.valueOf(x.class, str);
        AppMethodBeat.o(167029);
        return xVar;
    }

    private x(String str) {
        this.detail = str;
    }

    static {
        AppMethodBeat.i(167027);
        AppMethodBeat.o(167027);
    }
}
