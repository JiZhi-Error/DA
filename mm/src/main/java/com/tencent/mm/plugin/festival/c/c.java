package com.tencent.mm.plugin.festival.c;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/festival/util/FestivalCdnHttpsRequestType;", "", "cdnAppType", "", "(Ljava/lang/String;II)V", "getCdnAppType", "()I", "Canvas", "Music", "Avatar", "plugin-festival_release"})
public enum c {
    Canvas(CdnLogic.kAppTypeFestivalImage),
    Music(0),
    Avatar(CdnLogic.kAppTypeFestivalVideo);
    
    final int UGh;

    public static c valueOf(String str) {
        AppMethodBeat.i(263481);
        c cVar = (c) Enum.valueOf(c.class, str);
        AppMethodBeat.o(263481);
        return cVar;
    }

    private c(int i2) {
        this.UGh = i2;
    }

    static {
        AppMethodBeat.i(263479);
        AppMethodBeat.o(263479);
    }
}
