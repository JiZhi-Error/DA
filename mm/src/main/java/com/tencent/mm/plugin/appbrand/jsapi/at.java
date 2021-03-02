package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.ab;
import com.tencent.mm.protocal.protobuf.fcw;
import com.tencent.mm.protocal.protobuf.ll;
import com.tencent.mm.protocal.protobuf.lm;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.g.d;
import java.lang.ref.WeakReference;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\r\u000e\u000fB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0014J%\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContactNew;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "()V", "dispatchInJsThread", "", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Constants", "EventOnContactUpdate", "Loader", "luggage-wechat-full-sdk_release"})
public final class at extends d<com.tencent.mm.plugin.appbrand.d> {
    public static final int CTRL_INDEX = 410;
    public static final String NAME = NAME;
    public static final String lyN = lyN;
    @Deprecated
    public static final a lyO = new a((byte) 0);

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "list", "", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "invoke"})
    static final class d extends q implements kotlin.g.a.b<List<? extends WxaAttributes>, x> {
        final /* synthetic */ int lyo;
        final /* synthetic */ h lzc;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(int i2, h hVar) {
            super(1);
            this.lyo = i2;
            this.lzc = hVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.tencent.mm.plugin.appbrand.jsapi.at$h */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(List<? extends WxaAttributes> list) {
            AppMethodBeat.i(183044);
            List<? extends WxaAttributes> list2 = list;
            p.h(list2, "list");
            a unused = at.lyO;
            Log.i("Luggage.FULL.JsApiBatchGetContact", "Loader(" + this.lyo + ").onLoaded, list.size:" + list2.size());
            this.lzc.by(list2);
            x xVar = x.SXb;
            AppMethodBeat.o(183044);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "list", "", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "invoke"})
    static final class e extends q implements kotlin.g.a.b<List<? extends WxaAttributes>, x> {
        final /* synthetic */ int lyo;
        final /* synthetic */ h lzc;
        final /* synthetic */ WeakReference lzd;
        final /* synthetic */ String lze;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(int i2, h hVar, WeakReference weakReference, String str) {
            super(1);
            this.lyo = i2;
            this.lzc = hVar;
            this.lzd = weakReference;
            this.lze = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.tencent.mm.plugin.appbrand.jsapi.at$h */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(List<? extends WxaAttributes> list) {
            AppMethodBeat.i(183045);
            List<? extends WxaAttributes> list2 = list;
            p.h(list2, "list");
            a unused = at.lyO;
            Log.i("Luggage.FULL.JsApiBatchGetContact", "Loader(" + this.lyo + ").onUpdated, list.size:" + list2.size());
            if (!this.lzc.by(list2).booleanValue()) {
                b.a aVar = b.lyP;
                b.a.a((com.tencent.mm.plugin.appbrand.d) this.lzd.get(), list2, this.lze);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(183045);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "errMsg", "", "invoke"})
    static final class g extends q implements kotlin.g.a.b<String, x> {
        final /* synthetic */ int lyo;
        final /* synthetic */ WeakReference lzd;
        final /* synthetic */ at lzf;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(at atVar, int i2, WeakReference weakReference) {
            super(1);
            this.lzf = atVar;
            this.lyo = i2;
            this.lzd = weakReference;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(String str) {
            boolean z;
            String concat;
            AppMethodBeat.i(183047);
            String str2 = str;
            a unused = at.lyO;
            Log.e("Luggage.FULL.JsApiBatchGetContact", "Loader(" + this.lyo + ").onError, errMsg:" + str2);
            com.tencent.mm.plugin.appbrand.d dVar = (com.tencent.mm.plugin.appbrand.d) this.lzd.get();
            if (dVar != null) {
                int i2 = this.lyo;
                at atVar = this.lzf;
                StringBuilder sb = new StringBuilder("fail");
                String str3 = str2;
                if (str3 == null || str3.length() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    concat = "";
                } else {
                    concat = ":".concat(String.valueOf(str2));
                }
                dVar.i(i2, atVar.Zf(sb.append(concat).toString()));
            }
            x xVar = x.SXb;
            AppMethodBeat.o(183047);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n*\b\u0012\u0004\u0012\u00020\f0\u000bR\u0010\u0010\u0003\u001a\u00020\u00048\u0006XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00068\u0006XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00048\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContactNew$Constants;", "", "()V", "BATCH_GET_CGI_URI", "", "CTRL_INDEX", "", "NAME", "TAG", "toJsonContactList", "Lorg/json/JSONArray;", "", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "luggage-wechat-full-sdk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static /* synthetic */ JSONArray bx(List<WxaAttributes> list) {
            AppMethodBeat.i(183036);
            p.h(list, "$this$toJsonContactList");
            JSONArray jSONArray = new JSONArray();
            for (T t : list) {
                JSONObject optJSONObject = new JSONObject(((WxaAttributes) t).field_appInfo).optJSONObject("PluginInfo");
                if (optJSONObject == null) {
                    optJSONObject = new JSONObject();
                }
                jSONArray.put(optJSONObject.put("appId", ((WxaAttributes) t).field_appId));
            }
            AppMethodBeat.o(183036);
            return jSONArray;
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(com.tencent.mm.plugin.appbrand.d dVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(183051);
        com.tencent.mm.plugin.appbrand.d dVar2 = dVar;
        if (dVar2 == null) {
            AppMethodBeat.o(183051);
        } else if (jSONObject == null) {
            dVar2.i(i2, Zf("fail:invalid data"));
            AppMethodBeat.o(183051);
        } else {
            JSONArray optJSONArray = jSONObject.optJSONArray("appIds");
            if (optJSONArray != null) {
                LinkedList linkedList = new LinkedList();
                int length = optJSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    String optString = optJSONArray.optString(i3);
                    String str = optString;
                    if (!(str == null || str.length() == 0)) {
                        linkedList.add(optString);
                    }
                }
                if (linkedList.isEmpty()) {
                    linkedList = null;
                }
                if (linkedList != null) {
                    String uuid = UUID.randomUUID().toString();
                    p.g(uuid, "UUID.randomUUID().toString()");
                    com.tencent.mm.plugin.appbrand.networking.c cVar = (com.tencent.mm.plugin.appbrand.networking.c) dVar2.M(com.tencent.mm.plugin.appbrand.networking.c.class);
                    if (cVar == null) {
                        dVar2.i(i2, Zf("fail:internal error"));
                        AppMethodBeat.o(183051);
                        return;
                    }
                    p.g(cVar, "env.customize(ICgiServic…iMsg.API_INTERNAL_ERROR))");
                    WeakReference weakReference = new WeakReference(dVar2);
                    h hVar = new h(this, weakReference, i2, uuid);
                    Log.i("Luggage.FULL.JsApiBatchGetContact", "Loader(" + i2 + ").load(), hostWxaAppId[" + dVar2.getAppId() + "], eventCallbackId[" + uuid + "] appIds[" + org.apache.commons.b.g.a(linkedList.iterator(), ",") + ']');
                    String appId = dVar2.getAppId();
                    p.g(appId, "env.appId");
                    c cVar2 = new c(appId, i2, linkedList, cVar);
                    d dVar3 = new d(i2, hVar);
                    e eVar = new e(i2, hVar, weakReference, uuid);
                    f fVar = new f(i2, weakReference, uuid);
                    g gVar = new g(this, i2, weakReference);
                    p.h(dVar3, "onLoaded");
                    p.h(eVar, "onUpdated");
                    p.h(fVar, "onNoUpdate");
                    p.h(gVar, "onError");
                    com.tencent.f.h.RTc.aX(new c.a(cVar2, gVar, dVar3, eVar, fVar));
                    AppMethodBeat.o(183051);
                    return;
                }
            }
            dVar2.i(i2, Zf("fail:appIds is empty"));
            AppMethodBeat.o(183051);
        }
    }

    static {
        AppMethodBeat.i(183052);
        AppMethodBeat.o(183052);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final boolean bEa() {
        return true;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001J\u001b\u0010\n\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0002\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\r"}, hxF = {"com/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContactNew$invoke$callback$1", "Landroid/arch/core/util/Function;", "", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "", "callbackInvoked", "getCallbackInvoked", "()Z", "setCallbackInvoked", "(Z)V", "apply", "input", "(Ljava/util/List;)Ljava/lang/Boolean;", "luggage-wechat-full-sdk_release"})
    public static final class h implements android.arch.a.c.a<List<? extends WxaAttributes>, Boolean> {
        final /* synthetic */ int lyo;
        final /* synthetic */ WeakReference lzd;
        final /* synthetic */ String lze;
        final /* synthetic */ at lzf;
        private boolean lzg;

        h(at atVar, WeakReference weakReference, int i2, String str) {
            this.lzf = atVar;
            this.lzd = weakReference;
            this.lyo = i2;
            this.lze = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.arch.a.c.a
        public final /* synthetic */ Boolean apply(List<? extends WxaAttributes> list) {
            AppMethodBeat.i(183049);
            Boolean by = by(list);
            AppMethodBeat.o(183049);
            return by;
        }

        public final Boolean by(List<WxaAttributes> list) {
            boolean z;
            AppMethodBeat.i(183048);
            p.h(list, "input");
            if (!this.lzg) {
                try {
                    com.tencent.mm.plugin.appbrand.d dVar = (com.tencent.mm.plugin.appbrand.d) this.lzd.get();
                    if (dVar != null) {
                        int i2 = this.lyo;
                        at atVar = this.lzf;
                        JSONObject jSONObject = new JSONObject();
                        a unused = at.lyO;
                        jSONObject.put("contactList", a.bx(list));
                        jSONObject.put("callbackId", this.lze);
                        dVar.i(i2, atVar.h("ok", jSONObject));
                    }
                } catch (JSONException e2) {
                    com.tencent.mm.plugin.appbrand.d dVar2 = (com.tencent.mm.plugin.appbrand.d) this.lzd.get();
                    if (dVar2 != null) {
                        dVar2.i(this.lyo, this.lzf.Zf("fail: toJson fail"));
                    }
                }
                this.lzg = true;
                z = true;
            } else {
                z = false;
            }
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.o(183048);
            return valueOf;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContactNew$EventOnContactUpdate;", "Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiEvent;", "()V", "Companion", "luggage-wechat-full-sdk_release"})
    public static final class b extends bc {
        public static final int CTRL_INDEX = -2;
        public static final String NAME = NAME;
        public static final a lyP = new a((byte) 0);

        @l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006R\u0010\u0010\u0003\u001a\u00020\u00048\u0006XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00068\u0006XD¢\u0006\u0002\n\u0000¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContactNew$EventOnContactUpdate$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "dispatch", "", "env", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "attrList", "", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "eventCallbackId", "luggage-wechat-full-sdk_release"})
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(byte b2) {
                this();
            }

            public static void a(com.tencent.mm.plugin.appbrand.d dVar, List<WxaAttributes> list, String str) {
                AppMethodBeat.i(183037);
                if (dVar == null) {
                    AppMethodBeat.o(183037);
                    return;
                }
                String str2 = str;
                if (str2 == null || str2.length() == 0) {
                    AppMethodBeat.o(183037);
                    return;
                }
                b bVar = new b();
                if (list != null) {
                    a unused = at.lyO;
                    bVar.p("contactList", a.bx(list));
                }
                bVar.p("callbackId", str);
                dVar.a(bVar);
                AppMethodBeat.o(183037);
            }
        }

        static {
            AppMethodBeat.i(183038);
            AppMethodBeat.o(183038);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ^\u0010\r\u001a\u00020\u000e2\u0018\u0010\u000f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0007\u0012\u0004\u0012\u00020\u000e0\u00102\u0018\u0010\u0012\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0007\u0012\u0004\u0012\u00020\u000e0\u00102\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00142\u0014\u0010\u0015\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u000e0\u0010JH\u0010\u0016\u001a\u00020\u000e*\u00020\t2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00072\u0014\u0010\u0019\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0012\u0004\u0012\u00020\u000e0\u00102\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u000e0\u0010H\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContactNew$Loader;", "", "hostWxaAppId", "", "tag", "", "appIds", "", "cgiService", "Lcom/tencent/mm/plugin/appbrand/networking/ICgiService;", "(Ljava/lang/String;ILjava/util/List;Lcom/tencent/mm/plugin/appbrand/networking/ICgiService;)V", "INTERVAL_SECONDS", "", "load", "", "onLoaded", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "onUpdated", "onNoUpdate", "Lkotlin/Function0;", "onError", "waitForBatchCgiUpdate", "requestList", "Lcom/tencent/mm/protocal/protobuf/WxaAttrSyncSingleReqInfo;", "onSuccess", "Lcom/tencent/mm/protocal/protobuf/BatchWxaAttrSyncResponse;", "luggage-wechat-full-sdk_release"})
    static final class c {
        final String kOn;
        final long lyQ = TimeUnit.MINUTES.toSeconds(5);
        final List<String> lyR;
        final com.tencent.mm.plugin.appbrand.networking.c lyS;
        final int tag;

        public c(String str, int i2, List<String> list, com.tencent.mm.plugin.appbrand.networking.c cVar) {
            p.h(str, "hostWxaAppId");
            p.h(list, "appIds");
            p.h(cVar, "cgiService");
            AppMethodBeat.i(183043);
            this.kOn = str;
            this.tag = i2;
            this.lyR = list;
            this.lyS = cVar;
            AppMethodBeat.o(183043);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContactNew$Loader$load$runnable$1", "Lcom/tencent/threadpool/runnable/KeyRunnable;", "getKey", "", "run", "", "luggage-wechat-full-sdk_release"})
        public static final class a implements com.tencent.f.i.h {
            final /* synthetic */ c lyT;
            final /* synthetic */ kotlin.g.a.b lyU;
            final /* synthetic */ kotlin.g.a.b lyV;
            final /* synthetic */ kotlin.g.a.b lyW;
            final /* synthetic */ kotlin.g.a.a lyX;

            @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/protocal/protobuf/BatchWxaAttrSyncResponse;", "invoke"})
            /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.at$c$a$a  reason: collision with other inner class name */
            static final class C0627a extends q implements kotlin.g.a.b<lm, x> {
                final /* synthetic */ a lyY;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                C0627a(a aVar) {
                    super(1);
                    this.lyY = aVar;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                /* JADX WARNING: Code restructure failed: missing block: B:10:0x003c, code lost:
                    if (r0 == null) goto L_0x003e;
                 */
                @Override // kotlin.g.a.b
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final /* synthetic */ kotlin.x invoke(com.tencent.mm.protocal.protobuf.lm r4) {
                    /*
                        r3 = this;
                        r2 = 183039(0x2caff, float:2.56492E-40)
                        com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                        com.tencent.mm.protocal.protobuf.lm r4 = (com.tencent.mm.protocal.protobuf.lm) r4
                        if (r4 != 0) goto L_0x001a
                        com.tencent.mm.plugin.appbrand.jsapi.at$c$a r0 = r3.lyY
                        kotlin.g.a.b r0 = r0.lyU
                        java.lang.String r1 = "get contact fail response is null"
                        r0.invoke(r1)
                    L_0x0014:
                        kotlin.x r0 = kotlin.x.SXb
                        com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                        return r0
                    L_0x001a:
                        com.tencent.mm.plugin.appbrand.config.ab.bAu()
                        boolean r0 = com.tencent.mm.plugin.appbrand.config.ab.a(r4)
                        if (r0 == 0) goto L_0x0049
                        com.tencent.mm.plugin.appbrand.config.ab.bAu()
                        com.tencent.mm.plugin.appbrand.jsapi.at$c$a r0 = r3.lyY
                        com.tencent.mm.plugin.appbrand.jsapi.at$c r0 = r0.lyT
                        java.util.List<java.lang.String> r0 = r0.lyR
                        r1 = 0
                        java.lang.String[] r1 = new java.lang.String[r1]
                        java.util.List r0 = com.tencent.mm.plugin.appbrand.config.ab.a(r0, r1)
                        if (r0 == 0) goto L_0x003e
                        com.tencent.mm.plugin.appbrand.jsapi.at$c$a r1 = r3.lyY
                        kotlin.g.a.b r1 = r1.lyW
                        r1.invoke(r0)
                        if (r0 != 0) goto L_0x0014
                    L_0x003e:
                        com.tencent.mm.plugin.appbrand.jsapi.at$c$a r0 = r3.lyY
                        kotlin.g.a.b r0 = r0.lyU
                        java.lang.String r1 = "get contact fail"
                        r0.invoke(r1)
                        goto L_0x0014
                    L_0x0049:
                        com.tencent.mm.plugin.appbrand.jsapi.at$c$a r0 = r3.lyY
                        kotlin.g.a.b r0 = r0.lyU
                        java.lang.String r1 = "update contacts fail"
                        r0.invoke(r1)
                        goto L_0x0014
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.at.c.a.C0627a.invoke(java.lang.Object):java.lang.Object");
                }
            }

            a(c cVar, kotlin.g.a.b bVar, kotlin.g.a.b bVar2, kotlin.g.a.b bVar3, kotlin.g.a.a aVar) {
                this.lyT = cVar;
                this.lyU = bVar;
                this.lyV = bVar2;
                this.lyW = bVar3;
                this.lyX = aVar;
            }

            public final void run() {
                fcw fcw;
                byte[] bArr;
                AppMethodBeat.i(183040);
                LinkedList linkedList = new LinkedList();
                LinkedList linkedList2 = new LinkedList();
                try {
                    HashSet<String> hashSet = new HashSet(this.lyT.lyR);
                    ab.bAu();
                    List<WxaAttributes> a2 = ab.a(this.lyT.lyR, "appId", "appInfo", "syncVersion", "syncTimeSecond");
                    if (a2 != null) {
                        for (T t : a2) {
                            String str = ((WxaAttributes) t).field_appInfo;
                            if (!(str == null || str.length() == 0)) {
                                hashSet.remove(((WxaAttributes) t).field_appId);
                                linkedList.add(t);
                                if (Util.secondsToNow(((WxaAttributes) t).field_syncTimeSecond) > this.lyT.lyQ) {
                                    fcw fcw2 = new fcw();
                                    fcw2.dNI = ((WxaAttributes) t).field_appId;
                                    String str2 = ((WxaAttributes) t).field_syncVersion;
                                    if (str2 != null) {
                                        Charset charset = kotlin.n.d.UTF_8;
                                        if (str2 == null) {
                                            t tVar = new t("null cannot be cast to non-null type java.lang.String");
                                            AppMethodBeat.o(183040);
                                            throw tVar;
                                        }
                                        bArr = str2.getBytes(charset);
                                        p.g(bArr, "(this as java.lang.String).getBytes(charset)");
                                        if (bArr != null) {
                                            fcw = fcw2;
                                            fcw.KSW = new com.tencent.mm.bw.b(bArr);
                                            linkedList2.add(fcw2);
                                        }
                                    }
                                    fcw = fcw2;
                                    bArr = new byte[0];
                                    fcw.KSW = new com.tencent.mm.bw.b(bArr);
                                    linkedList2.add(fcw2);
                                } else {
                                    continue;
                                }
                            }
                        }
                        for (String str3 : hashSet) {
                            fcw fcw3 = new fcw();
                            fcw3.dNI = str3;
                            fcw3.KSW = new com.tencent.mm.bw.b(new byte[0]);
                            linkedList2.add(fcw3);
                        }
                        if (linkedList.size() == this.lyT.lyR.size()) {
                            this.lyV.invoke(linkedList);
                        }
                        if (!(linkedList2.isEmpty())) {
                            a unused = at.lyO;
                            Log.i("Luggage.FULL.JsApiBatchGetContact", "Loader(" + this.lyT.tag + ").waitForBatchCgiUpdate requestList.size:" + linkedList2.size());
                            kotlin.g.a.b bVar = this.lyU;
                            ll llVar = new ll();
                            llVar.KOw.addAll(linkedList2);
                            llVar.Scene = 100;
                            com.tencent.mm.vending.h.d.LOGIC.arrange(new b(this.lyT, llVar, new C0627a(this), bVar));
                            AppMethodBeat.o(183040);
                            return;
                        }
                        this.lyX.invoke();
                        AppMethodBeat.o(183040);
                        return;
                    }
                    this.lyU.invoke("get contact fail");
                    AppMethodBeat.o(183040);
                } catch (JSONException e2) {
                    a unused2 = at.lyO;
                    Log.e("Luggage.FULL.JsApiBatchGetContact", "Loader(" + this.lyT.hashCode() + ").run(), make callback array e=" + e2);
                    this.lyU.invoke("get contact json error");
                    AppMethodBeat.o(183040);
                }
            }

            @Override // com.tencent.f.i.h, com.tencent.f.i.g
            public final String getKey() {
                return "Luggage.FULL.JsApiBatchGetContact.Loader";
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        static final class b implements Runnable {
            final /* synthetic */ c lyT;
            final /* synthetic */ kotlin.g.a.b lyU;
            final /* synthetic */ ll lyZ;
            final /* synthetic */ kotlin.g.a.b lza;

            b(c cVar, ll llVar, kotlin.g.a.b bVar, kotlin.g.a.b bVar2) {
                this.lyT = cVar;
                this.lyZ = llVar;
                this.lza = bVar;
                this.lyU = bVar2;
            }

            public final void run() {
                Object obj;
                AppMethodBeat.i(183042);
                com.tencent.mm.plugin.appbrand.networking.c cVar = this.lyT.lyS;
                a unused = at.lyO;
                com.tencent.mm.vending.g.c a2 = cVar.a(at.lyN, this.lyZ, lm.class);
                kotlin.g.a.b bVar = this.lza;
                if (bVar != null) {
                    obj = new au(bVar);
                } else {
                    obj = bVar;
                }
                a2.a((d.b) obj).a(new d.a<Object>(this) {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.at.c.b.AnonymousClass1 */
                    final /* synthetic */ b lzb;

                    {
                        this.lzb = r1;
                    }

                    @Override // com.tencent.mm.vending.g.d.a
                    public final void cn(Object obj) {
                        String obj2;
                        AppMethodBeat.i(183041);
                        if (obj == null) {
                            obj2 = null;
                        } else if (obj instanceof Throwable) {
                            obj2 = ((Throwable) obj).getMessage();
                        } else {
                            obj2 = obj.toString();
                        }
                        this.lzb.lyU.invoke(obj2);
                        AppMethodBeat.o(183041);
                    }
                });
                AppMethodBeat.o(183042);
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class f extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ int lyo;
        final /* synthetic */ WeakReference lzd;
        final /* synthetic */ String lze;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(int i2, WeakReference weakReference, String str) {
            super(0);
            this.lyo = i2;
            this.lzd = weakReference;
            this.lze = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(183046);
            a unused = at.lyO;
            Log.i("Luggage.FULL.JsApiBatchGetContact", "Loader(" + this.lyo + ").onNoUpdate");
            b.a aVar = b.lyP;
            b.a.a((com.tencent.mm.plugin.appbrand.d) this.lzd.get(), null, this.lze);
            x xVar = x.SXb;
            AppMethodBeat.o(183046);
            return xVar;
        }
    }
}
