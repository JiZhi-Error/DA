package com.tencent.mm.plugin.ac;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.plugin.webview.stub.f;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.e;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0010B1\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u000b\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/webjsengine/JsApiHandlerBuilder;", "", "stubService", "Ljava/lang/Class;", "Landroid/app/Service;", "name", "", "appId", "jsPerm", "Lcom/tencent/mm/protocal/JsapiPermissionWrapper;", "(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/protocal/JsapiPermissionWrapper;)V", "TAG", "callbackHandler", "Lcom/tencent/mm/plugin/webview/jsapi/ICallbackHandler;", "build", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;", "JsApiWebViewStub_Callback_AIDL", "webview-sdk_release"})
public final class a {
    private final com.tencent.mm.plugin.webview.d.b IBt = new c(this);
    public final Class<? extends Service> IBu;
    public final JsapiPermissionWrapper IBv;
    final String TAG = "MicroMsg.JsApiHandlerBuilder";
    public final String appId;
    public final String name;

    public a(Class<? extends Service> cls, String str, String str2, JsapiPermissionWrapper jsapiPermissionWrapper) {
        p.h(cls, "stubService");
        p.h(str, "name");
        p.h(str2, "appId");
        AppMethodBeat.i(224855);
        this.IBu = cls;
        this.name = str;
        this.appId = str2;
        this.IBv = jsapiPermissionWrapper;
        AppMethodBeat.o(224855);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u001a\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\fH\u0016J\b\u0010\u0014\u001a\u00020\u0006H\u0016J\b\u0010\u0015\u001a\u00020\u0006H\u0016J\b\u0010\u0016\u001a\u00020\u0006H\u0016J\b\u0010\u0017\u001a\u00020\u0006H\u0016J\u001c\u0010\u0018\u001a\u00020\u000e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\nH\u0016J\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u001c\u0010\u001e\u001a\u00020\u00102\b\u0010\u001f\u001a\u0004\u0018\u00010\u00062\b\u0010 \u001a\u0004\u0018\u00010\u0006H\u0016J.\u0010!\u001a\u00020\n2\b\u0010\"\u001a\u0004\u0018\u00010\u00062\b\u0010#\u001a\u0004\u0018\u00010\u00062\b\u0010$\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0012\u001a\u00020\nH\u0016J\u0012\u0010%\u001a\u00020\n2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\b\u0010(\u001a\u00020\u0010H\u0016J\u0012\u0010)\u001a\u00020\u00102\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010*\u001a\u00020\u00102\b\u0010+\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010,\u001a\u00020\u00102\u0006\u0010-\u001a\u00020\nH\u0016J\u001a\u0010.\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u001c\u0010/\u001a\u00020\u00102\b\u00100\u001a\u0004\u0018\u00010\u00062\b\u00101\u001a\u0004\u0018\u00010\u0006H\u0016J,\u00102\u001a\u00020\u00102\b\u00103\u001a\u0004\u0018\u00010\u00062\b\u00104\u001a\u0004\u0018\u00010\u00062\u0006\u00105\u001a\u00020\f2\u0006\u00106\u001a\u00020\fH\u0016J\u0010\u00107\u001a\u00020\u00102\u0006\u0010-\u001a\u00020\nH\u0016J\u0010\u00108\u001a\u00020\n2\u0006\u00109\u001a\u00020\fH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006:"}, hxF = {"Lcom/tencent/mm/plugin/webjsengine/JsApiHandlerBuilder$JsApiWebViewStub_Callback_AIDL;", "Lcom/tencent/mm/plugin/webview/stub/WebViewStub_Callback_AIDL$Stub;", "jsapi", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;", "(Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;)V", "TAG", "", "asBinder", "Landroid/os/IBinder;", "callback", "", "actionCode", "", "data", "Landroid/os/Bundle;", "closeWindow", "", "bundle", "dealNext", "getA8keyScene", "getCommitUrl", "getCurrentUrl", "getInitUrl", "getPublisher", "handleMsg", "func", "param", "hideMenuEntry", "ishide", "invokeAsResult", "loadUrl", "url", "jsCode", "onHandleEnd", "callbackId", "ret", "retData", "onSceneEnd", "aidl", "Lcom/tencent/mm/plugin/webview/stub/OnSceneEnd_AIDL;", "requestClearMsgList", "setCustomMenu", "setFontSizeCb", "font", "setFooterBarVisible", "visible", "setMenuItemsVisible", "setPageOwner", "userName", "nickName", "setRecogResultForQBarImg", "filePath", "result", "codeType", "codeVersion", "setShareBtnVisible", "setTitlePbVisibility", "visibility", "webview-sdk_release"})
    /* renamed from: com.tencent.mm.plugin.ac.a$a  reason: collision with other inner class name */
    public static final class BinderC0511a extends f.a {
        private final h IBw;
        private final String TAG = "MicroMsg.JsApiWebViewStub_Callback_AIDL";

        public BinderC0511a(h hVar) {
            p.h(hVar, "jsapi");
            AppMethodBeat.i(224852);
            this.IBw = hVar;
            AppMethodBeat.o(224852);
        }

        @Override // com.tencent.mm.plugin.webview.stub.f
        public final boolean a(String str, String str2, Bundle bundle, boolean z) {
            AppMethodBeat.i(224848);
            this.IBw.a(str, str2, n.aN(bundle), z);
            AppMethodBeat.o(224848);
            return true;
        }

        @Override // com.tencent.mm.plugin.webview.stub.f
        public final Bundle j(int i2, Bundle bundle) {
            AppMethodBeat.i(224849);
            Log.i(this.TAG, "invokeAsResult:".concat(String.valueOf(i2)));
            Bundle bundle2 = new Bundle();
            switch (i2) {
                case 101:
                    if (bundle == null) {
                        p.hyc();
                    }
                    bundle.setClassLoader(e.p.class.getClassLoader());
                    Context context = this.IBw.getContext();
                    String string = bundle.getString("open_ui_with_webview_ui_plugin_name");
                    String string2 = bundle.getString("open_ui_with_webview_ui_plugin_entry");
                    Intent intent = new Intent();
                    Bundle bundle3 = bundle.getBundle("open_ui_with_webview_ui_extras");
                    if (bundle3 == null) {
                        p.hyc();
                    }
                    com.tencent.mm.br.c.b(context, string, string2, intent.putExtras(bundle3));
                    break;
                case 200:
                    b.a aVar = new b.a();
                    Intent intent2 = new Intent();
                    if (bundle == null) {
                        p.hyc();
                    }
                    int i3 = bundle.getInt("scene");
                    int i4 = bundle.getInt(e.b.OyR, 10000);
                    String string3 = bundle.getString("url");
                    if (((com.tencent.mm.plugin.brandservice.a.b) g.af(com.tencent.mm.plugin.brandservice.a.b.class)).isMpUrl(string3)) {
                        string3 = ((com.tencent.mm.plugin.brandservice.a.b) g.af(com.tencent.mm.plugin.brandservice.a.b.class)).d(string3, i3, i4, (int) (System.currentTimeMillis() / 1000));
                    }
                    Context context2 = this.IBw.getContext();
                    int i5 = bundle.getInt("item_show_type");
                    bundle.getBoolean("isNativePage");
                    bundle2.putBoolean("success", ((com.tencent.mm.plugin.brandservice.a.b) g.af(com.tencent.mm.plugin.brandservice.a.b.class)).a(context2, string3, i5, i3, i4, intent2, bundle.getInt("openType"), aVar));
                    if (!aVar.success && aVar.message != null) {
                        bundle2.putString("desc", aVar.message);
                        break;
                    }
            }
            AppMethodBeat.o(224849);
            return bundle2;
        }

        @Override // com.tencent.mm.plugin.webview.stub.f
        public final void fWV() {
        }

        @Override // com.tencent.mm.plugin.webview.stub.f
        public final void e(String str, String str2, int i2, int i3) {
        }

        @Override // com.tencent.mm.plugin.webview.stub.f
        public final void aL(Bundle bundle) {
        }

        @Override // com.tencent.mm.plugin.webview.stub.f
        public final String ePp() {
            return this.TAG;
        }

        @Override // com.tencent.mm.plugin.webview.stub.f
        public final boolean afl(int i2) {
            return true;
        }

        @Override // com.tencent.mm.plugin.webview.stub.f
        public final String fWW() {
            return this.TAG;
        }

        @Override // com.tencent.mm.plugin.webview.stub.f
        public final void yL(boolean z) {
        }

        @Override // com.tencent.mm.plugin.webview.stub.f
        public final Bundle fl(String str, String str2) {
            AppMethodBeat.i(224850);
            Bundle bundle = new Bundle();
            AppMethodBeat.o(224850);
            return bundle;
        }

        @Override // com.tencent.mm.plugin.webview.stub.f
        public final String fWX() {
            return this.TAG;
        }

        @Override // com.tencent.mm.plugin.webview.stub.f
        public final void yM(boolean z) {
        }

        @Override // com.tencent.mm.plugin.webview.stub.f
        public final boolean f(int i2, Bundle bundle) {
            return true;
        }

        @Override // com.tencent.mm.plugin.webview.stub.f.a
        public final IBinder asBinder() {
            AppMethodBeat.i(224851);
            IBinder asBinder = super.asBinder();
            AppMethodBeat.o(224851);
            return asBinder;
        }

        @Override // com.tencent.mm.plugin.webview.stub.f
        public final void t(int i2, Bundle bundle) {
        }

        @Override // com.tencent.mm.plugin.webview.stub.f
        public final boolean a(d dVar) {
            return false;
        }

        @Override // com.tencent.mm.plugin.webview.stub.f
        public final void yN(boolean z) {
        }

        @Override // com.tencent.mm.plugin.webview.stub.f
        public final void lz(String str, String str2) {
        }

        @Override // com.tencent.mm.plugin.webview.stub.f
        public final int fWY() {
            return 0;
        }

        @Override // com.tencent.mm.plugin.webview.stub.f
        public final void aWP(String str) {
        }

        @Override // com.tencent.mm.plugin.webview.stub.f
        public final void fWZ() {
        }

        @Override // com.tencent.mm.plugin.webview.stub.f
        public final void lA(String str, String str2) {
        }

        @Override // com.tencent.mm.plugin.webview.stub.f
        public final String getCurrentUrl() {
            return this.TAG;
        }

        @Override // com.tencent.mm.plugin.webview.stub.f
        public final void aM(Bundle bundle) {
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032F\u0010\u0006\u001aB\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\b0\b \u0004* \u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\b0\b\u0018\u00010\t0\u0007H\n¢\u0006\u0002\b\n"}, hxF = {"<anonymous>", "", "callbackId", "", "kotlin.jvm.PlatformType", "ret", "retValue", "", "", "", "doCallback"})
    static final class c implements com.tencent.mm.plugin.webview.d.b {
        final /* synthetic */ a IBz;

        c(a aVar) {
            this.IBz = aVar;
        }

        @Override // com.tencent.mm.plugin.webview.d.b
        public final void h(String str, String str2, Map<String, Object> map) {
            AppMethodBeat.i(224854);
            HashMap hashMap = new HashMap();
            p.g(str2, "ret");
            hashMap.put("err_msg", str2);
            if (map != null) {
                hashMap.putAll(map);
            }
            String a2 = n.a.a(str, (Map<String, Object>) hashMap, false, "");
            String iVar = new i(a2).FJ("__params").toString();
            p.g(iVar, "JSONObject(resp).getJSON…ct(\"__params\").toString()");
            Log.d(this.IBz.TAG, "invoke callback: " + iVar + ", " + a2);
            AppMethodBeat.o(224854);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/webjsengine/JsApiHandlerBuilder$build$2", "Lcom/tencent/mm/plugin/webview/core/IWebViewUIConnectionBinder;", "onConnected", "", "conn", "Lcom/tencent/mm/plugin/webview/core/IWebViewUIConnection;", "onDisconnected", "", "webview-sdk_release"})
    public static final class b implements com.tencent.mm.plugin.webview.core.d {
        final /* synthetic */ h IBx;
        final /* synthetic */ int IBy;

        public b(h hVar, int i2) {
            this.IBx = hVar;
            this.IBy = i2;
        }

        @Override // com.tencent.mm.plugin.webview.core.d
        public final void a(com.tencent.mm.plugin.webview.core.c cVar) {
            AppMethodBeat.i(224853);
            p.h(cVar, "conn");
            this.IBx.b(cVar.fZs());
            cVar.fZs().a(new BinderC0511a(this.IBx), this.IBy);
            this.IBx.yV(true);
            AppMethodBeat.o(224853);
        }

        @Override // com.tencent.mm.plugin.webview.core.d
        public final boolean fXa() {
            return false;
        }
    }
}
