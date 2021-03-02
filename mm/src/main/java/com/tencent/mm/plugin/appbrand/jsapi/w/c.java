package com.tencent.mm.plugin.appbrand.jsapi.w;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import org.json.JSONException;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u000b\f\rB\u0005¢\u0006\u0002\u0010\u0003J%\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0002¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/report/JsApiOperateRealtimeReport;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "Event_onRealtimeDataResponse", "Priority", "plugin-appbrand-integration_release"})
public final class c extends d<com.tencent.mm.plugin.appbrand.d> {
    private static final int CTRL_INDEX = CTRL_INDEX;
    private static final String NAME = NAME;
    @Deprecated
    public static final a mpd = new a((byte) 0);

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/report/JsApiOperateRealtimeReport$Companion;", "", "()V", "CTRL_INDEX", "", "getCTRL_INDEX", "()I", "NAME", "", "getNAME", "()Ljava/lang/String;", "plugin-appbrand-integration_release"})
    static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(com.tencent.mm.plugin.appbrand.d dVar, JSONObject jSONObject, int i2) {
        EnumC0721c cVar;
        AppMethodBeat.i(50671);
        com.tencent.mm.plugin.appbrand.d dVar2 = dVar;
        if (dVar2 == null) {
            AppMethodBeat.o(50671);
        } else if (jSONObject == null) {
            AppMethodBeat.o(50671);
        } else {
            try {
                String string = jSONObject.getString("content");
                if (((long) string.length()) >= 65536) {
                    dVar2.i(i2, Zf("fail too large data"));
                    AppMethodBeat.o(50671);
                    return;
                }
                try {
                    int i3 = jSONObject.getInt("type");
                    try {
                        EnumC0721c.a aVar = EnumC0721c.mpj;
                        String string2 = jSONObject.getString(DownloadInfo.PRIORITY);
                        p.g(string2, "data.getString(\"priority\")");
                        p.h(string2, "str");
                        EnumC0721c[] values = EnumC0721c.values();
                        int length = values.length;
                        int i4 = 0;
                        while (true) {
                            if (i4 >= length) {
                                cVar = EnumC0721c.LOW;
                                break;
                            }
                            cVar = values[i4];
                            if (n.I(cVar.name(), string2, true)) {
                                break;
                            }
                            i4++;
                        }
                        try {
                            int i5 = jSONObject.getInt("id");
                            try {
                                h hVar = h.mpp;
                                p.g(string, "content");
                                hVar.a(dVar2, i5, i3, string, cVar);
                                dVar2.i(i2, Zf("ok"));
                                AppMethodBeat.o(50671);
                            } catch (Exception e2) {
                                dVar2.i(i2, Zf("fail:internal error " + e2.getMessage()));
                                AppMethodBeat.o(50671);
                            }
                        } catch (JSONException e3) {
                            dVar2.i(i2, Zf("fail:invalid data id"));
                            AppMethodBeat.o(50671);
                        }
                    } catch (JSONException e4) {
                        dVar2.i(i2, Zf("fail:invalid data priority"));
                        AppMethodBeat.o(50671);
                    }
                } catch (JSONException e5) {
                    dVar2.i(i2, Zf("fail:invalid data type"));
                    AppMethodBeat.o(50671);
                }
            } catch (JSONException e6) {
                dVar2.i(i2, Zf("fail:invalid data content"));
                AppMethodBeat.o(50671);
            }
        }
    }

    static {
        AppMethodBeat.i(50672);
        AppMethodBeat.o(50672);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/report/JsApiOperateRealtimeReport$Priority;", "", "(Ljava/lang/String;I)V", "HIGH", "LOW", "IMMEDIATE", "Companion", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.w.c$c  reason: collision with other inner class name */
    public enum EnumC0721c {
        HIGH,
        LOW,
        IMMEDIATE;
        
        public static final a mpj = new a((byte) 0);

        static {
            AppMethodBeat.i(50668);
            AppMethodBeat.o(50668);
        }

        public static EnumC0721c valueOf(String str) {
            AppMethodBeat.i(50670);
            EnumC0721c cVar = (EnumC0721c) Enum.valueOf(EnumC0721c.class, str);
            AppMethodBeat.o(50670);
            return cVar;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/report/JsApiOperateRealtimeReport$Priority$Companion;", "", "()V", "of", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/JsApiOperateRealtimeReport$Priority;", "str", "", "plugin-appbrand-integration_release"})
        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.w.c$c$a */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(byte b2) {
                this();
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/report/JsApiOperateRealtimeReport$Event_onRealtimeDataResponse;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApiEvent;", "()V", "Companion", "plugin-appbrand-integration_release"})
    public static final class b extends s {
        public static final int CTRL_INDEX = 653;
        public static final String NAME = "onRealtimeDataResponse";
        @Deprecated
        public static final a mpe = new a((byte) 0);

        static {
            AppMethodBeat.i(50667);
            AppMethodBeat.o(50667);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/report/JsApiOperateRealtimeReport$Event_onRealtimeDataResponse$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "plugin-appbrand-integration_release"})
        static final class a {
            private a() {
            }

            public /* synthetic */ a(byte b2) {
                this();
            }
        }
    }
}
