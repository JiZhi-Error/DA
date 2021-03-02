package com.tencent.mm.plugin.ac;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001:\f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001bB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0007\u001a\u00020\u0003XD¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter;", "", "reportId", "", "type", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter$Type;", "(JLcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter$Type;)V", "baseReportId", "getReportId", "()J", "getType", "()Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter$Type;", "report", "", "item", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter$ReportItem;", "ContextConfigErr", "ContextDependenceErr", "ContextErr", "ContextJSAPIErr", "ContextJsErr", "ContextLibErr", "ContextScriptErr", "ContextStart", "ContextSucc", "ContextValidErr", "ReportItem", "Type", "webview-sdk_release"})
public final class f {
    private final long IBA = 1478;
    private final long IBJ;
    final j ICn;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter$Type;", "", "(Ljava/lang/String;I)V", "Main", "Engine", "Client", "webview-sdk_release"})
    public enum j {
        Main,
        Engine,
        Client;

        static {
            AppMethodBeat.i(224898);
            AppMethodBeat.o(224898);
        }

        public static j valueOf(String str) {
            AppMethodBeat.i(224900);
            j jVar = (j) Enum.valueOf(j.class, str);
            AppMethodBeat.o(224900);
            return jVar;
        }
    }

    public f(long j2, j jVar) {
        p.h(jVar, "type");
        AppMethodBeat.i(224902);
        this.IBJ = j2;
        this.ICn = jVar;
        AppMethodBeat.o(224902);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter$ReportItem;", "", "value", "", "(J)V", "getValue", "()J", "webview-sdk_release"})
    public static abstract class i {
        final long value;

        public i(long j2) {
            this.value = j2;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, hxF = {"Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter$ContextStart;", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter$ReportItem;", "()V", "webview-sdk_release"})
    public static final class g extends i {
        public g() {
            super(0);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, hxF = {"Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter$ContextSucc;", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter$ReportItem;", "()V", "webview-sdk_release"})
    public static final class h extends i {
        public h() {
            super(1);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, hxF = {"Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter$ContextErr;", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter$ReportItem;", "()V", "webview-sdk_release"})
    public static final class b extends i {
        public b() {
            super(2);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, hxF = {"Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter$ContextJsErr;", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter$ReportItem;", "()V", "webview-sdk_release"})
    public static final class d extends i {
        public d() {
            super(3);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, hxF = {"Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter$ContextJSAPIErr;", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter$ReportItem;", "()V", "webview-sdk_release"})
    public static final class c extends i {
        public c() {
            super(10);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, hxF = {"Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter$ContextDependenceErr;", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter$ReportItem;", "()V", "webview-sdk_release"})
    public static final class a extends i {
        public a() {
            super(11);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, hxF = {"Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter$ContextLibErr;", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter$ReportItem;", "()V", "webview-sdk_release"})
    public static final class e extends i {
        public e() {
            super(13);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, hxF = {"Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter$ContextScriptErr;", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter$ReportItem;", "()V", "webview-sdk_release"})
    /* renamed from: com.tencent.mm.plugin.ac.f$f  reason: collision with other inner class name */
    public static final class C0516f extends i {
        public C0516f() {
            super(15);
        }
    }

    public final void a(i iVar) {
        AppMethodBeat.i(224901);
        p.h(iVar, "item");
        com.tencent.mm.plugin.report.service.h.INSTANCE.F(this.IBA, iVar.value);
        if (this.IBJ > 0) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.F(this.IBJ, iVar.value);
        }
        AppMethodBeat.o(224901);
    }
}
