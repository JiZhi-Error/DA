package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.b.b;
import com.tencent.mm.ak.d;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.model.ad;
import com.tencent.mm.modelappbrand.t;
import com.tencent.mm.plugin.appbrand.dynamic.e;
import com.tencent.mm.plugin.appbrand.dynamic.h;
import com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView;
import com.tencent.mm.plugin.appbrand.jsapi.auth.k;
import com.tencent.mm.plugin.webview.ui.tools.widget.r;
import com.tencent.mm.protocal.protobuf.cem;
import com.tencent.mm.protocal.protobuf.cen;
import com.tencent.mm.protocal.protobuf.ceo;
import com.tencent.mm.protocal.protobuf.cep;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a extends com.tencent.mm.plugin.appbrand.dynamic.d.a.a {
    private static final String lnh = (MMApplicationContext.getPackageName() + ":tools");

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.d.a$a  reason: collision with other inner class name */
    public interface AbstractC0572a {
        void v(Bundle bundle);
    }

    static {
        AppMethodBeat.i(192519);
        AppMethodBeat.o(192519);
    }

    public a() {
        super(k.NAME, 419);
    }

    @Override // com.tencent.mm.plugin.appbrand.dynamic.d.a.a
    public final void a(com.tencent.mm.aa.c.a aVar, JSONObject jSONObject, final b.a<JSONObject> aVar2) {
        AppMethodBeat.i(121307);
        ad.b ayQ = aVar.ayQ();
        Bundle bundle = new Bundle();
        try {
            bundle.putString("scope", jSONObject.getString("scope"));
            bundle.putString("appId", ayQ.getString("__page_app_id", ""));
            bundle.putString("widgetId", ayQ.getString("__page_view_id", ""));
            XIPCInvoker.a(ayQ.getString("__process_name", lnh), bundle, b.class, new d<Bundle>() {
                /* class com.tencent.mm.plugin.appbrand.dynamic.d.a.AnonymousClass1 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.ipcinvoker.d
                public final /* synthetic */ void bn(Bundle bundle) {
                    Bundle bundle2;
                    String str;
                    AppMethodBeat.i(121295);
                    Bundle bundle3 = bundle;
                    boolean z = false;
                    if (bundle3 != null) {
                        z = bundle3.getBoolean("ret");
                        String string = bundle3.getString("reason");
                        bundle2 = bundle3.getBundle("data");
                        str = string;
                    } else {
                        bundle2 = null;
                        str = null;
                    }
                    aVar2.bt(a.this.a(z, str, bundle2));
                    AppMethodBeat.o(121295);
                }
            });
            AppMethodBeat.o(121307);
        } catch (Exception e2) {
            Log.e("MicroMsg.JsApiFunc_DoAuthroize", "JSON Exception[%s]", e2.getMessage());
            AppMethodBeat.o(121307);
        }
    }

    static class b implements com.tencent.mm.ipcinvoker.b<Bundle, Bundle> {
        private static final String[] lnk = {"scope.userLocation"};

        private b() {
        }

        static /* synthetic */ void b(d dVar, boolean z, String str) {
            AppMethodBeat.i(121303);
            a(dVar, z, str);
            AppMethodBeat.o(121303);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public /* synthetic */ void invoke(Bundle bundle, final d<Bundle> dVar) {
            AppMethodBeat.i(121302);
            Bundle bundle2 = bundle;
            Log.i("MicroMsg.IPCInvoke_DoAuthorize", "widget doOauthAuthorize!");
            String string = bundle2.getString("scope");
            final String string2 = bundle2.getString("appId");
            final String string3 = bundle2.getString("widgetId");
            LinkedList<String> linkedList = new LinkedList<>();
            try {
                List asList = Arrays.asList(lnk);
                JSONArray jSONArray = new JSONArray(string);
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    String optString = jSONArray.optString(i2);
                    if (asList.contains(optString)) {
                        linkedList.add(optString);
                    }
                }
                if (linkedList.size() <= 0) {
                    Log.w("MicroMsg.IPCInvoke_DoAuthorize", "no valid scope, raw scope[%s]", string);
                    a(dVar, false, "invalid args");
                    AppMethodBeat.o(121302);
                    return;
                }
                d.a aVar = new d.a();
                aVar.funcId = 1157;
                aVar.uri = "/cgi-bin/mmbiz-bin/js-authorize";
                ceo ceo = new ceo();
                ceo.jfi = string2;
                ceo.MjX = linkedList;
                ceo.MjZ = 0;
                aVar.iLN = ceo;
                aVar.iLO = new cep();
                IPCRunCgi.a(aVar.aXF(), new IPCRunCgi.a() {
                    /* class com.tencent.mm.plugin.appbrand.dynamic.d.a.b.AnonymousClass1 */

                    @Override // com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a
                    public final void a(int i2, int i3, String str, com.tencent.mm.ak.d dVar) {
                        AppMethodBeat.i(121297);
                        Log.i("MicroMsg.IPCInvoke_DoAuthorize", "onSceneEnd errType[%d], errCode[%d] ,errMsg[%s]", Integer.valueOf(i2), Integer.valueOf(i3), str);
                        if (i2 == 0 && i3 == 0) {
                            if (dVar.iLL.iLR != null) {
                                cep cep = (cep) dVar.iLL.iLR;
                                int i4 = cep.Mkb.dIZ;
                                String str2 = cep.Mkb.dJa;
                                Log.i("MicroMsg.IPCInvoke_DoAuthorize", "NetSceneJSAuthorize jsErrcode[%d], jsErrmsg[%s]", Integer.valueOf(i4), str2);
                                if (i4 == -12000) {
                                    b.a(b.this, string3, b.Yw(cep.xMq), b.Yw(cep.KFs), cep.LRN, new AbstractC0572a() {
                                        /* class com.tencent.mm.plugin.appbrand.dynamic.d.a.b.AnonymousClass1.AnonymousClass1 */

                                        @Override // com.tencent.mm.plugin.appbrand.dynamic.d.a.AbstractC0572a
                                        public final void v(Bundle bundle) {
                                            AppMethodBeat.i(121296);
                                            int i2 = bundle.getInt("retCode");
                                            if (i2 == 1) {
                                                int i3 = bundle.getInt("resultCode");
                                                b.a(b.this, string3, string2, bundle.getBundle("resultData"), i3, dVar);
                                                AppMethodBeat.o(121296);
                                                return;
                                            }
                                            b.b(dVar, false, "deny");
                                            Log.e("MicroMsg.IPCInvoke_DoAuthorize", "authorize fail, retCode[%d]", Integer.valueOf(i2));
                                            AppMethodBeat.o(121296);
                                        }
                                    });
                                    AppMethodBeat.o(121297);
                                    return;
                                } else if (i4 == 0) {
                                    b.a(b.this, string3);
                                    b.b(dVar, true, "");
                                    AppMethodBeat.o(121297);
                                    return;
                                } else {
                                    Log.e("MicroMsg.IPCInvoke_DoAuthorize", "onSceneEnd NetSceneJSAuthorize ERROR %s", str2);
                                    b.b(dVar, false, String.valueOf(str2));
                                }
                            }
                            AppMethodBeat.o(121297);
                            return;
                        }
                        b.b(dVar, false, "cgi fail");
                        AppMethodBeat.o(121297);
                    }
                });
                AppMethodBeat.o(121302);
            } catch (Exception e2) {
                Log.e("MicroMsg.IPCInvoke_DoAuthorize", "Parse scrope array string Exception[%s]", e2.getMessage());
                a(dVar, false, "exception");
                AppMethodBeat.o(121302);
            }
        }

        private static void a(com.tencent.mm.ipcinvoker.d<Bundle> dVar, boolean z, String str) {
            AppMethodBeat.i(121301);
            Bundle bundle = new Bundle();
            bundle.putBoolean("ret", z);
            bundle.putString("reason", str);
            dVar.bn(bundle);
            AppMethodBeat.o(121301);
        }

        static /* synthetic */ String Yw(String str) {
            return str != null ? str : "";
        }

        static /* synthetic */ void a(b bVar, final String str, String str2, Bundle bundle, final int i2, final com.tencent.mm.ipcinvoker.d dVar) {
            AppMethodBeat.i(121304);
            LinkedList<String> linkedList = new LinkedList<>();
            Iterator it = ((ArrayList) bundle.getSerializable("key_scope")).iterator();
            while (it.hasNext()) {
                linkedList.add((String) it.next());
            }
            d.a aVar = new d.a();
            aVar.funcId = 1158;
            aVar.uri = "/cgi-bin/mmbiz-bin/js-authorize-confirm";
            cem cem = new cem();
            cem.jfi = str2;
            cem.MjX = linkedList;
            cem.MjZ = 0;
            cem.MjY = i2;
            aVar.iLN = cem;
            aVar.iLO = new cen();
            IPCRunCgi.a(aVar.aXF(), new IPCRunCgi.a() {
                /* class com.tencent.mm.plugin.appbrand.dynamic.d.a.b.AnonymousClass2 */

                @Override // com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a
                public final void a(int i2, int i3, String str, com.tencent.mm.ak.d dVar) {
                    AppMethodBeat.i(121298);
                    Log.d("MicroMsg.IPCInvoke_DoAuthorize", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                    if (i2 == 0 && i3 == 0) {
                        if (dVar.iLL.iLR != null) {
                            if (i2 == 2) {
                                b.b(dVar, false, "cgi fail");
                                AppMethodBeat.o(121298);
                                return;
                            }
                            cen cen = (cen) dVar.iLL.iLR;
                            int i4 = cen.Mkb.dIZ;
                            Log.i("MicroMsg.IPCInvoke_DoAuthorize", "NetSceneJSAuthorizeConfirm jsErrcode[%d], jsErrmsg[%s]", Integer.valueOf(i4), cen.Mkb.dJa);
                            if (i4 == 0) {
                                b.a(b.this, str);
                                b.b(dVar, true, "");
                                AppMethodBeat.o(121298);
                                return;
                            }
                            b.b(dVar, false, "cgi fail");
                        }
                        AppMethodBeat.o(121298);
                        return;
                    }
                    b.b(dVar, false, "cgi fail");
                    AppMethodBeat.o(121298);
                }
            });
            AppMethodBeat.o(121304);
        }

        static /* synthetic */ void a(b bVar, final String str, final String str2, final String str3, final LinkedList linkedList, final AbstractC0572a aVar) {
            AppMethodBeat.i(121305);
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.dynamic.d.a.b.AnonymousClass4 */

                public final void run() {
                    boolean z = true;
                    AppMethodBeat.i(121300);
                    IPCDynamicPageView YC = com.tencent.mm.plugin.appbrand.dynamic.h.a.bCk().YC(str);
                    if (YC == null) {
                        Log.e("MicroMsg.IPCInvoke_DoAuthorize", "dynamicPageView not found! widgetid[%s]", str);
                        AppMethodBeat.o(121300);
                        return;
                    }
                    r rVar = new r(YC.getContext());
                    AnonymousClass1 r2 = new r.a() {
                        /* class com.tencent.mm.plugin.appbrand.dynamic.d.a.b.AnonymousClass4.AnonymousClass1 */

                        @Override // com.tencent.mm.plugin.webview.ui.tools.widget.r.a
                        public final void i(int i2, Bundle bundle) {
                            AppMethodBeat.i(121299);
                            Log.i("MicroMsg.IPCInvoke_DoAuthorize", "stev onRevMsg resultCode %d", Integer.valueOf(i2));
                            Bundle bundle2 = new Bundle();
                            switch (i2) {
                                case 1:
                                case 2:
                                    bundle2.putInt("retCode", 0);
                                    bundle2.putInt("resultCode", i2);
                                    bundle2.putBundle("resultData", bundle);
                                    break;
                                default:
                                    Log.d("MicroMsg.IPCInvoke_DoAuthorize", "press back button!");
                                    bundle2.putInt("retCode", -1);
                                    break;
                            }
                            aVar.v(bundle2);
                            AppMethodBeat.o(121299);
                        }
                    };
                    if (linkedList == null || linkedList.size() <= 0) {
                        Log.e("MicroMsg.IPCInvoke_DoAuthorize", "scopeInfoList is empty!");
                    } else if (rVar.a(linkedList, str2, str3, r2)) {
                        z = false;
                    }
                    if (z) {
                        Bundle bundle = new Bundle();
                        bundle.putInt("retCode", -2);
                        aVar.v(bundle);
                    }
                    AppMethodBeat.o(121300);
                }
            });
            AppMethodBeat.o(121305);
        }

        static /* synthetic */ void a(b bVar, String str) {
            AppMethodBeat.i(121306);
            View Yj = e.bBI().Yj(str);
            if (!(Yj instanceof h)) {
                Log.i("MicroMsg.IPCInvoke_DoAuthorize", "authorize failed, view is not a instance of DynamicPageAccessible.(%s)", str);
                AppMethodBeat.o(121306);
                return;
            }
            ((h) Yj).c(str, new t() {
                /* class com.tencent.mm.plugin.appbrand.dynamic.d.a.b.AnonymousClass3 */

                @Override // com.tencent.mm.modelappbrand.t
                public final void b(boolean z, String str, Bundle bundle) {
                }
            });
            AppMethodBeat.o(121306);
        }
    }
}
