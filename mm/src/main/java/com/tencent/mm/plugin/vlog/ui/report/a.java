package com.tencent.mm.plugin.vlog.ui.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import kotlin.a.j;
import kotlin.g.a.b;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007J\u000e\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u000fR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/report/MultiVideoPerformance;", "", "()V", "MAX_INDEX", "", "seekTimeArray", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "updateCompositionTimeArray", "addSeekTime", "", "time", "addUpdateCompositionTime", "getSeekTimeStr", "", "getUpdateTimeStr", "plugin-vlog_release"})
public final class a {
    public final int GOA = 50;
    public ArrayList<Long> GOB = new ArrayList<>();
    public ArrayList<Long> GOC = new ArrayList<>();

    public a() {
        AppMethodBeat.i(192024);
        AppMethodBeat.o(192024);
    }

    public final String agM() {
        AppMethodBeat.i(192022);
        String a2 = j.a(this.GOB, "#", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (b) null, 62);
        AppMethodBeat.o(192022);
        return a2;
    }

    public final String fEt() {
        AppMethodBeat.i(192023);
        String a2 = j.a(this.GOC, "#", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (b) null, 62);
        AppMethodBeat.o(192023);
        return a2;
    }
}
