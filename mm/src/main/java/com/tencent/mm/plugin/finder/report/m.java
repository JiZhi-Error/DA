package com.tencent.mm.plugin.finder.report;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bJ \u0010\f\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/FinderShareReporter;", "", "()V", "report21673", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "eventCode", "", "eventTime", "", FirebaseAnalytics.b.INDEX, "report21856", "Companion", "plugin-finder_release"})
public final class m {
    private static final m vfC = new m();
    public static final a vfD = new a((byte) 0);

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rXT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/FinderShareReporter$Companion;", "", "()V", "EVENT_CODE_CLICK", "", "EVENT_CODE_SHOW", "EVENT_EXPOSE_ANIMATION", "EVENT_EXPOSE_STATIC", "INSTANCE", "Lcom/tencent/mm/plugin/finder/report/FinderShareReporter;", "getINSTANCE", "()Lcom/tencent/mm/plugin/finder/report/FinderShareReporter;", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    private m() {
    }

    static {
        AppMethodBeat.i(250712);
        AppMethodBeat.o(250712);
    }

    public static void a(bbn bbn, int i2, long j2, int i3) {
        AppMethodBeat.i(250710);
        if (bbn != null) {
            Log.i("Finder.FinderShareReporter", "FinderShareReporter.report21673, sessionId = " + bbn.sessionId + ", clickTabContextId = " + bbn.sGE + ", contextId = " + bbn.sGQ + ", commentScene = " + bbn.tCE + ", eventCode = " + i2 + ", eventTime = " + j2 + ", index = " + i3);
            h.INSTANCE.a(21673, bbn.sessionId, bbn.sGE, bbn.sGQ, Integer.valueOf(bbn.tCE), Integer.valueOf(i2), Long.valueOf(j2), Integer.valueOf(i3));
        }
        AppMethodBeat.o(250710);
    }

    public static void a(bbn bbn, int i2, long j2) {
        AppMethodBeat.i(250711);
        if (bbn != null) {
            Log.i("Finder.FinderShareReporter", "FinderShareReporter.report21856, sessionId = " + bbn.sessionId + ", clickTabContextId = " + bbn.sGE + ", contextId = " + bbn.sGQ + ", commentScene = " + bbn.tCE + ", eventCode = " + i2 + ", eventTime = " + j2);
            h.INSTANCE.a(21856, bbn.sessionId, bbn.sGE, bbn.sGQ, Integer.valueOf(bbn.tCE), Integer.valueOf(i2), Long.valueOf(j2));
        }
        AppMethodBeat.o(250711);
    }
}
