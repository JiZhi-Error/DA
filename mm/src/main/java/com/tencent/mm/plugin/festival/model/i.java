package com.tencent.mm.plugin.festival.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/festival/model/FestivalKeyStepLogGather;", "", "()V", "TAG", "", "log", "", "content", "plugin-festival_release"})
public final class i {
    public static final i Uyl = new i();

    static {
        AppMethodBeat.i(262990);
        AppMethodBeat.o(262990);
    }

    private i() {
    }

    public static void log(String str) {
        AppMethodBeat.i(262989);
        p.h(str, "content");
        Log.i("FestivalKeyStep", str);
        AppMethodBeat.o(262989);
    }
}
