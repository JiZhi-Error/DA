package com.tencent.mm.plugin.ac;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001:\u000f\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001aB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0005\u001a\u00020\u0003XD¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/webjsengine/WebJsEngineReporter;", "", "reportId", "", "(J)V", "baseReportId", "getReportId", "()J", "report", "", "item", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineReporter$ReportItem;", "ClientContextErr", "ClientContextJsErr", "ClientContextStart", "ClientContextSucc", "EngineContextErr", "EngineContextJsErr", "EngineContextStart", "EngineContextSucc", "IsolateStart", "IsolateSucc", "MainContextErr", "MainContextJsErr", "MainContextStart", "MainContextSucc", "ReportItem", "webview-sdk_release"})
public final class g {
    private final long IBA = 1476;
    private final long IBJ = 1477;

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/webjsengine/WebJsEngineReporter$ReportItem;", "", "value", "", "(J)V", "getValue", "()J", "webview-sdk_release"})
    public static abstract class o {
        final long value;

        public o(long j2) {
            this.value = j2;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, hxF = {"Lcom/tencent/mm/plugin/webjsengine/WebJsEngineReporter$IsolateStart;", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineReporter$ReportItem;", "()V", "webview-sdk_release"})
    public static final class i extends o {
        public i() {
            super(0);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, hxF = {"Lcom/tencent/mm/plugin/webjsengine/WebJsEngineReporter$MainContextStart;", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineReporter$ReportItem;", "()V", "webview-sdk_release"})
    public static final class m extends o {
        public m() {
            super(1);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, hxF = {"Lcom/tencent/mm/plugin/webjsengine/WebJsEngineReporter$EngineContextStart;", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineReporter$ReportItem;", "()V", "webview-sdk_release"})
    /* renamed from: com.tencent.mm.plugin.ac.g$g  reason: collision with other inner class name */
    public static final class C0517g extends o {
        public C0517g() {
            super(2);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, hxF = {"Lcom/tencent/mm/plugin/webjsengine/WebJsEngineReporter$ClientContextStart;", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineReporter$ReportItem;", "()V", "webview-sdk_release"})
    public static final class c extends o {
        public c() {
            super(3);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, hxF = {"Lcom/tencent/mm/plugin/webjsengine/WebJsEngineReporter$IsolateSucc;", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineReporter$ReportItem;", "()V", "webview-sdk_release"})
    public static final class j extends o {
        public j() {
            super(5);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, hxF = {"Lcom/tencent/mm/plugin/webjsengine/WebJsEngineReporter$MainContextSucc;", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineReporter$ReportItem;", "()V", "webview-sdk_release"})
    public static final class n extends o {
        public n() {
            super(10);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, hxF = {"Lcom/tencent/mm/plugin/webjsengine/WebJsEngineReporter$MainContextErr;", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineReporter$ReportItem;", "()V", "webview-sdk_release"})
    public static final class k extends o {
        public k() {
            super(11);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, hxF = {"Lcom/tencent/mm/plugin/webjsengine/WebJsEngineReporter$MainContextJsErr;", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineReporter$ReportItem;", "()V", "webview-sdk_release"})
    public static final class l extends o {
        public l() {
            super(12);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, hxF = {"Lcom/tencent/mm/plugin/webjsengine/WebJsEngineReporter$EngineContextSucc;", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineReporter$ReportItem;", "()V", "webview-sdk_release"})
    public static final class h extends o {
        public h() {
            super(13);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, hxF = {"Lcom/tencent/mm/plugin/webjsengine/WebJsEngineReporter$EngineContextErr;", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineReporter$ReportItem;", "()V", "webview-sdk_release"})
    public static final class e extends o {
        public e() {
            super(14);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, hxF = {"Lcom/tencent/mm/plugin/webjsengine/WebJsEngineReporter$EngineContextJsErr;", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineReporter$ReportItem;", "()V", "webview-sdk_release"})
    public static final class f extends o {
        public f() {
            super(15);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, hxF = {"Lcom/tencent/mm/plugin/webjsengine/WebJsEngineReporter$ClientContextSucc;", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineReporter$ReportItem;", "()V", "webview-sdk_release"})
    public static final class d extends o {
        public d() {
            super(16);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, hxF = {"Lcom/tencent/mm/plugin/webjsengine/WebJsEngineReporter$ClientContextErr;", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineReporter$ReportItem;", "()V", "webview-sdk_release"})
    public static final class a extends o {
        public a() {
            super(17);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, hxF = {"Lcom/tencent/mm/plugin/webjsengine/WebJsEngineReporter$ClientContextJsErr;", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineReporter$ReportItem;", "()V", "webview-sdk_release"})
    public static final class b extends o {
        public b() {
            super(18);
        }
    }

    public final void a(o oVar) {
        AppMethodBeat.i(224903);
        p.h(oVar, "item");
        com.tencent.mm.plugin.report.service.h.INSTANCE.F(this.IBA, oVar.value);
        com.tencent.mm.plugin.report.service.h.INSTANCE.F(this.IBJ, oVar.value);
        AppMethodBeat.o(224903);
    }
}
