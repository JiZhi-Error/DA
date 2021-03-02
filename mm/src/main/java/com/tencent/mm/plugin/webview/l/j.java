package com.tencent.mm.plugin.webview.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedDeque;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/webview/webcompt/WebComptReporter;", "", "()V", "bizReportIds", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "", "getBizReportIds", "()Ljava/util/concurrent/ConcurrentLinkedDeque;", "report", "", "key", "Lcom/tencent/mm/plugin/webview/webcompt/Key;", "Companion", "webview-sdk_release"})
public final class j {
    public static final a JEP = new a((byte) 0);
    final ConcurrentLinkedDeque<Long> JEO = new ConcurrentLinkedDeque<>();

    static {
        AppMethodBeat.i(82961);
        AppMethodBeat.o(82961);
    }

    public j() {
        AppMethodBeat.i(82960);
        AppMethodBeat.o(82960);
    }

    public final void a(b bVar) {
        AppMethodBeat.i(82959);
        p.h(bVar, "key");
        h.INSTANCE.idkeyStat(1147, (long) bVar.value, 1, false);
        ArrayList<Long> arrayList = new ArrayList();
        for (T t : this.JEO) {
            if (t.longValue() > 0) {
                arrayList.add(t);
            }
        }
        for (Long l : arrayList) {
            h hVar = h.INSTANCE;
            p.g(l, LocaleUtil.ITALIAN);
            hVar.idkeyStat(l.longValue(), (long) bVar.value, 1, false);
        }
        AppMethodBeat.o(82959);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/webview/webcompt/WebComptReporter$Companion;", "", "()V", "ID", "", "webview-sdk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
