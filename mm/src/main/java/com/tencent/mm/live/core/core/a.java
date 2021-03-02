package com.tencent.mm.live.core.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/live/core/core/CdnQualityTag;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "CDN_QUALITY_HD", "CDN_QUALITY_SD1", "CDN_QUALITY_SD2", "CDN_QUALITY_SM", "CDN_QUALITY_SB", "CDN_QUALITY_HEVC", "CDN_QUALITY_AUTO_CLIQOS", "CDN_QUALITY_AUTO_SVRML", "plugin-core_release"})
public enum a {
    CDN_QUALITY_HD(0),
    CDN_QUALITY_SD1(1),
    CDN_QUALITY_SD2(2),
    CDN_QUALITY_SM(3),
    CDN_QUALITY_SB(4),
    CDN_QUALITY_HEVC(5),
    CDN_QUALITY_AUTO_CLIQOS(101),
    CDN_QUALITY_AUTO_SVRML(102);
    
    public final int value;

    public static a valueOf(String str) {
        AppMethodBeat.i(196387);
        a aVar = (a) Enum.valueOf(a.class, str);
        AppMethodBeat.o(196387);
        return aVar;
    }

    private a(int i2) {
        this.value = i2;
    }

    static {
        AppMethodBeat.i(196385);
        AppMethodBeat.o(196385);
    }
}
