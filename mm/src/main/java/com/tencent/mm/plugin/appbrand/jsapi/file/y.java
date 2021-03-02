package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.jsapi.ab;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.InputStream;
import java.nio.ByteBuffer;
import kotlin.g.b.q;
import kotlin.l;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0003J\u001b\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/file/JsApiLoadWAFileSync;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandSyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "Companion", "luggage-wechat-full-sdk_release"})
public final class y extends ab<d> {
    private static final int CTRL_INDEX = 909;
    private static final String NAME = "loadWAFileSync";
    public static final a lVi = new a((byte) 0);

    static {
        AppMethodBeat.i(230098);
        AppMethodBeat.o(230098);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J#\u0010\u0007\u001a\u00020\b*\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0000¢\u0006\u0002\b\rJ\f\u0010\u000e\u001a\u00020\u000f*\u00020\u0010H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/file/JsApiLoadWAFileSync$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "invokeSync", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi$CallResult;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "TAG", "data", "Lorg/json/JSONObject;", "invokeSync$luggage_wechat_full_sdk_release", "toDirectByteBuffer", "Ljava/nio/ByteBuffer;", "Ljava/io/InputStream;", "luggage-wechat-full-sdk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static p.a a(d dVar, String str, JSONObject jSONObject) {
            boolean z;
            Throwable th;
            Throwable th2;
            AppMethodBeat.i(230096);
            kotlin.g.b.p.h(dVar, "$this$invokeSync");
            kotlin.g.b.p.h(str, "TAG");
            String optString = jSONObject != null ? jSONObject.optString("filename") : null;
            Log.i(str, "invokeSync with filename:" + optString + ", appId:" + dVar.getAppId());
            String str2 = optString;
            if (str2 == null || str2.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                p.a aVar = new p.a("fail:invalid data", new Object[0]);
                AppMethodBeat.o(230096);
                return aVar;
            }
            ICommLibReader bqZ = dVar.bqZ();
            if (bqZ == null) {
                p.a aVar2 = (p.a) new b(dVar, str).invoke();
                AppMethodBeat.o(230096);
                return aVar2;
            }
            kotlin.g.b.p.g(bqZ, "this.libReader ?: return…AL_ERROR)\n            }()");
            InputStream openRead = bqZ.openRead(optString);
            if (openRead != null) {
                InputStream inputStream = openRead;
                try {
                    InputStream inputStream2 = inputStream;
                    a aVar3 = y.lVi;
                    kotlin.g.b.p.g(inputStream2, LocaleUtil.ITALIAN);
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(inputStream2.available());
                    if (inputStream2 instanceof com.tencent.luggage.h.a) {
                        allocateDirect.put(((com.tencent.luggage.h.a) inputStream2).Pf());
                    } else {
                        allocateDirect.put(ByteBuffer.wrap(com.tencent.mm.plugin.appbrand.ac.d.H(inputStream2)));
                    }
                    kotlin.g.b.p.g(allocateDirect, "buffer");
                    p.a o = new p.a("ok", new Object[0]).o("arrayBuffer", allocateDirect);
                    kotlin.g.b.p.g(o, "CallResult(\"ok\").put(\"arrayBuffer\", buffer)");
                    kotlin.f.b.a(inputStream, null);
                    AppMethodBeat.o(230096);
                    return o;
                } catch (Throwable th3) {
                    th = th3;
                    th2 = th;
                    kotlin.f.b.a(inputStream, th2);
                    AppMethodBeat.o(230096);
                    throw th;
                }
            } else {
                p.a aVar4 = (p.a) new C0665a(dVar, str, optString).invoke();
                AppMethodBeat.o(230096);
                return aVar4;
            }
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi$CallResult;", "invoke"})
        public static final class b extends q implements kotlin.g.a.a<p.a> {
            final /* synthetic */ d lVj;
            final /* synthetic */ String lVk;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(d dVar, String str) {
                super(0);
                this.lVj = dVar;
                this.lVk = str;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ p.a invoke() {
                AppMethodBeat.i(230095);
                Log.e(this.lVk, "invokeSync get NULL reader, appId:" + this.lVj.getAppId());
                p.a aVar = new p.a("fail:internal error", new Object[0]);
                AppMethodBeat.o(230095);
                return aVar;
            }
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi$CallResult;", "invoke"})
        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.file.y$a$a  reason: collision with other inner class name */
        public static final class C0665a extends q implements kotlin.g.a.a<p.a> {
            final /* synthetic */ d lVj;
            final /* synthetic */ String lVk;
            final /* synthetic */ String lVl;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0665a(d dVar, String str, String str2) {
                super(0);
                this.lVj = dVar;
                this.lVk = str;
                this.lVl = str2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ p.a invoke() {
                AppMethodBeat.i(230094);
                Log.e(this.lVk, "invokeSync filename(" + this.lVl + ") not found, appId:" + this.lVj.getAppId());
                p.a aVar = new p.a("fail:file doesn't exist", new Object[0]);
                AppMethodBeat.o(230094);
                return aVar;
            }
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.ab
    public final /* synthetic */ String a(d dVar, JSONObject jSONObject) {
        AppMethodBeat.i(230097);
        d dVar2 = dVar;
        kotlin.g.b.p.h(dVar2, "env");
        p.a a2 = a.a(dVar2, "Luggage.JsApiLoadWAFileSync", jSONObject);
        if (kotlin.g.b.p.j(a2.errMsg, "ok")) {
            String a3 = a(dVar2, a2.errMsg, a2.values);
            kotlin.g.b.p.g(a3, "makeReturnJsonWithNative…, ret.errMsg, ret.values)");
            AppMethodBeat.o(230097);
            return a3;
        }
        String n = n(a2.errMsg, a2.values);
        kotlin.g.b.p.g(n, "makeReturnJson(ret.errMsg, ret.values)");
        AppMethodBeat.o(230097);
        return n;
    }
}
