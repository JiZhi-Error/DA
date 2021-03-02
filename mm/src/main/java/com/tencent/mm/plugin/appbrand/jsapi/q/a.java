package com.tencent.mm.plugin.appbrand.jsapi.q;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u0016\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0006\"\u0004\b\u0013\u0010\b¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/perf/EventOnNewPerformanceMetric;", "", "()V", "endTime", "", "getEndTime", "()J", "setEndTime", "(J)V", "extraInfo", "Lorg/json/JSONObject;", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "startTime", "getStartTime", "setStartTime", "dispatch", "", "receiver", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "putExtraInfo", "value", "Companion", "plugin-appbrand-integration_release"})
public final class a {
    @Deprecated
    public static final C0698a mmB = new C0698a((byte) 0);
    public long endTime;
    private final JSONObject mmA = new JSONObject();
    private String name = "";
    public long startTime;

    static {
        AppMethodBeat.i(162176);
        AppMethodBeat.o(162176);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/perf/EventOnNewPerformanceMetric$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.q.a$a  reason: collision with other inner class name */
    static final class C0698a {
        private C0698a() {
        }

        public /* synthetic */ C0698a(byte b2) {
            this();
        }
    }

    public a() {
        AppMethodBeat.i(162175);
        AppMethodBeat.o(162175);
    }

    public final void setName(String str) {
        AppMethodBeat.i(162172);
        p.h(str, "<set-?>");
        this.name = str;
        AppMethodBeat.o(162172);
    }

    public final void r(String str, Object obj) {
        AppMethodBeat.i(162173);
        p.h(str, "name");
        p.h(obj, "value");
        this.mmA.put(str, obj);
        AppMethodBeat.o(162173);
    }

    public final void d(s sVar) {
        AppMethodBeat.i(162174);
        p.h(sVar, "receiver");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("name", this.name);
        jSONObject.put("startTime", this.startTime);
        jSONObject.put("endTime", this.endTime);
        jSONObject.put("extraInfo", this.mmA);
        Log.i("MicroMsg.AppBrand.EventOnNewPerformanceMetric", "dispatch ".concat(String.valueOf(jSONObject)));
        sVar.co("onNewPerformanceMetric", jSONObject.toString());
        AppMethodBeat.o(162174);
    }
}
