package com.tencent.mm.plugin.webview.model;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.d;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.widget.r;
import com.tencent.mm.protocal.protobuf.cua;
import com.tencent.mm.protocal.protobuf.cub;
import com.tencent.mm.protocal.protobuf.cuc;
import com.tencent.mm.protocal.protobuf.cud;
import com.tencent.mm.protocal.protobuf.cuh;
import com.tencent.mm.protocal.protobuf.drb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;

public final class ag {
    private static String[] IYa;
    private static boolean IYb = false;

    public interface a {
        void xr();
    }

    public interface c {
        void aXL(String str);

        void cGW();

        void e(DialogInterface.OnCancelListener onCancelListener);

        void goBack();
    }

    static /* synthetic */ ArrayList bB(LinkedList linkedList) {
        AppMethodBeat.i(210999);
        ArrayList<byte[]> bA = bA(linkedList);
        AppMethodBeat.o(210999);
        return bA;
    }

    public static String gcB() {
        AppMethodBeat.i(210998);
        String a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_native_oauth_host_for_h5, "");
        Log.i("MicroMsg.OauthAuthorizeLogic", "getOauthHostPaths %s", a2);
        AppMethodBeat.o(210998);
        return a2;
    }

    public static final class b {
        public static long IYc = 0;
        public static long startTime = 0;

        public static boolean gr(String str, int i2) {
            boolean z;
            boolean z2;
            AppMethodBeat.i(210993);
            if (6 == i2) {
                Log.i("MicroMsg.OauthAuthorizeLogic", "shouldNativeOauthIntercept from oauth");
                AppMethodBeat.o(210993);
                return false;
            } else if (Util.isNullOrNil(str)) {
                AppMethodBeat.o(210993);
                return false;
            } else {
                int a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_native_oauth_host_for_h5, 1);
                Log.i("MicroMsg.OauthAuthorizeLogic", "isABTestOpen %d", Integer.valueOf(a2));
                if (a2 == 1) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    if (ag.IYa == null && !ag.IYb) {
                        String gcB = ag.gcB();
                        if (Util.isNullOrNil(gcB)) {
                            gcB = WeChatHosts.domainString(R.string.e22) + "/connect/oauth2/authorize";
                        }
                        String[] unused = ag.IYa = gcB.split(";");
                        boolean unused2 = ag.IYb = true;
                    }
                    if (ag.IYa != null && ag.IYa.length != 0) {
                        Uri parse = Uri.parse(str);
                        String str2 = parse.getAuthority() + parse.getPath();
                        if (!Util.isNullOrNil(str2)) {
                            Log.d("MicroMsg.OauthAuthorizeLogic", "isOauthHost target:%s", str2);
                            int i3 = 0;
                            while (true) {
                                if (i3 >= ag.IYa.length) {
                                    break;
                                } else if (str2.equalsIgnoreCase(ag.IYa[i3])) {
                                    z2 = true;
                                    break;
                                } else {
                                    i3++;
                                }
                            }
                        } else {
                            Log.i("MicroMsg.OauthAuthorizeLogic", "isOauthHost target nil");
                        }
                    } else {
                        Log.i("MicroMsg.OauthAuthorizeLogic", "isOauthHost sOauthHostPaths nil");
                    }
                    z2 = false;
                    if (z2) {
                        AppMethodBeat.o(210993);
                        return true;
                    }
                }
                AppMethodBeat.o(210993);
                return false;
            }
        }

        public static boolean a(final String str, String str2, int i2, final e eVar, final c cVar, final a aVar, final int i3, Context context) {
            AppMethodBeat.i(210994);
            if (eVar == null) {
                Log.e("MicroMsg.OauthAuthorizeLogic", "doOauthAuthorize invoker null");
                AppMethodBeat.o(210994);
                return false;
            }
            startTime = System.currentTimeMillis();
            com.tencent.mm.plugin.webview.k.b.INSTANCE.da(1, "");
            Log.i("MicroMsg.OauthAuthorizeLogic", "doOauthAuthorize scene: %d", Integer.valueOf(i2));
            cVar.e(new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.plugin.webview.model.ag.b.AnonymousClass1 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(78944);
                    Log.i("MicroMsg.OauthAuthorizeLogic", "doOauthAuthorize user cancel");
                    cVar.cGW();
                    AppMethodBeat.o(78944);
                }
            });
            cuc cuc = new cuc();
            cuc.Mzp = str;
            cuc.KUC = str2;
            cuc.scene = i2;
            d.a aVar2 = new d.a();
            aVar2.iLN = cuc;
            aVar2.iLO = new cud();
            aVar2.uri = "/cgi-bin/mmbiz-bin/oauth_authorize";
            aVar2.funcId = 1254;
            aVar2.iLP = 0;
            aVar2.respCmdId = 0;
            final WeakReference weakReference = new WeakReference(context);
            IPCRunCgi.a(aVar2.aXF(), new IPCRunCgi.a() {
                /* class com.tencent.mm.plugin.webview.model.ag.b.AnonymousClass2 */

                @Override // com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a
                public final void a(int i2, int i3, String str, d dVar) {
                    AppMethodBeat.i(210980);
                    Context context = (Context) weakReference.get();
                    Log.i("MicroMsg.OauthAuthorizeLogic", "onSceneEnd doOauthAuthorize errType = %d, errCode = %d ,errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                    if (context == null || eVar == null || cVar == null || aVar == null) {
                        AppMethodBeat.o(210980);
                        return;
                    }
                    Bundle bundle = new Bundle();
                    if (i2 != 0 || i3 != 0 || dVar == null || dVar.iLL.iLR == null || !(dVar.iLL.iLR instanceof cud)) {
                        b.a(false, str, bundle, context, eVar, cVar, aVar, i3, i3);
                        AppMethodBeat.o(210980);
                        return;
                    }
                    cud cud = (cud) dVar.iLL.iLR;
                    bundle.putString("oauth_url", str);
                    bundle.putSerializable("scope_list", ag.bB(cud.Mzs));
                    bundle.putString("appname", cud.ixZ);
                    bundle.putString("appicon_url", cud.Mzt);
                    bundle.putString("redirect_url", cud.KJw);
                    bundle.putBoolean("is_recent_has_auth", cud.Mzu);
                    bundle.putBoolean("is_silence_auth", cud.Mzv);
                    bundle.putBoolean("is_call_server_when_confirm", cud.Mzw);
                    bundle.putSerializable("avatar_list", ah.bC(cud.Mzx));
                    bundle.putBoolean("is_use_new_page", cud.Mzy);
                    bundle.putBoolean("is_ban_modify_avatar", cud.lHF);
                    bundle.putInt("avatar_limit", cud.lHG);
                    bundle.putInt("default_avatar_id", cud.lHH);
                    bundle.putString("default_headimg_url", cud.lHI);
                    bundle.putString("default_headimg_fileid", cud.lHJ);
                    b.a(true, str, bundle, context, eVar, cVar, aVar, i3, i3);
                    AppMethodBeat.o(210980);
                }
            });
            AppMethodBeat.o(210994);
            return true;
        }

        public static void a(boolean z, final String str, final Bundle bundle, final Context context, final e eVar, final c cVar, final a aVar, final int i2, final int i3) {
            AppMethodBeat.i(78954);
            Log.i("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeSceneEnd suc: %b", Boolean.valueOf(z));
            cVar.cGW();
            final String aYE = aYE(bundle.getString("oauth_url"));
            Log.i("MicroMsg.OauthAuthorizeLogic", "parse appID:%s", aYE);
            if (!z) {
                h.RTc.aV(new Runnable() {
                    /* class com.tencent.mm.plugin.webview.model.ag.b.AnonymousClass3 */

                    public final void run() {
                        AppMethodBeat.i(210982);
                        com.tencent.mm.ui.base.h.d(context, str, MMApplicationContext.getContext().getString(R.string.j1i), new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.webview.model.ag.b.AnonymousClass3.AnonymousClass1 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(210981);
                                cVar.goBack();
                                AppMethodBeat.o(210981);
                            }
                        });
                        AppMethodBeat.o(210982);
                    }
                });
                com.tencent.mm.plugin.webview.k.b.INSTANCE.a(aYE == null ? "" : aYE, startTime, 2, 1, 0, 0, i3);
                com.tencent.mm.plugin.webview.k.b.INSTANCE.aO(1, (int) (System.currentTimeMillis() - startTime), i3);
                AppMethodBeat.o(78954);
                return;
            }
            boolean z2 = bundle.getBoolean("is_recent_has_auth");
            boolean z3 = bundle.getBoolean("is_silence_auth");
            if (z2 || z3) {
                final String string = bundle.getString("redirect_url");
                if (Util.isNullOrNil(string)) {
                    Log.e("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeSceneEnd redirect null");
                    AppMethodBeat.o(78954);
                    return;
                }
                Log.i("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeSceneEnd isRecentHasAuth:%b isSilenceAuth:%b redirectUrl:%s", Boolean.valueOf(z2), Boolean.valueOf(z3), string);
                com.tencent.mm.model.gdpr.c.a(context, com.tencent.mm.model.gdpr.a.OPENSDK, aYE, new com.tencent.mm.model.gdpr.b() {
                    /* class com.tencent.mm.plugin.webview.model.ag.b.AnonymousClass4 */

                    @Override // com.tencent.mm.model.gdpr.b
                    public final void sx(final int i2) {
                        AppMethodBeat.i(210984);
                        Log.i("MicroMsg.OauthAuthorizeLogic", " MPGdprPolicyUtil.checkPolicy onPermissionReturn:%d", Integer.valueOf(i2));
                        MMHandlerThread.postToMainThread(new Runnable() {
                            /* class com.tencent.mm.plugin.webview.model.ag.b.AnonymousClass4.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(210983);
                                if (i2 == 1) {
                                    cVar.goBack();
                                    com.tencent.mm.plugin.webview.k.b.INSTANCE.a(aYE == null ? "" : aYE, b.startTime, 0, 1, 0, 0, i3);
                                } else {
                                    cVar.aXL(string);
                                    com.tencent.mm.plugin.webview.k.b.INSTANCE.a(aYE == null ? "" : aYE, b.startTime, 1, 1, 0, 0, i3);
                                }
                                com.tencent.mm.plugin.webview.k.b.INSTANCE.aO(1, (int) (System.currentTimeMillis() - b.startTime), i3);
                                AppMethodBeat.o(210983);
                            }
                        });
                        AppMethodBeat.o(210984);
                    }
                });
                AppMethodBeat.o(78954);
                return;
            }
            boolean z4 = bundle.getBoolean("is_use_new_page", false);
            int a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_open_native_oauth_new, 1);
            Log.i("MicroMsg.OauthAuthorizeLogic", "isUseNewPage = %b, open= %d", Boolean.valueOf(z4), Integer.valueOf(a2));
            if (!z4 || 1 != a2) {
                final AnonymousClass6 r2 = new r.a() {
                    /* class com.tencent.mm.plugin.webview.model.ag.b.AnonymousClass6 */

                    @Override // com.tencent.mm.plugin.webview.ui.tools.widget.r.a
                    public final void i(int i2, final Bundle bundle) {
                        AppMethodBeat.i(210988);
                        Log.i("MicroMsg.OauthAuthorizeLogic", "WebAuthorizeDialog#onRevMsg resultCode %d", Integer.valueOf(i2));
                        switch (i2) {
                            case 1:
                                com.tencent.mm.model.gdpr.c.a(context, com.tencent.mm.model.gdpr.a.OPENSDK, aYE, new com.tencent.mm.model.gdpr.b() {
                                    /* class com.tencent.mm.plugin.webview.model.ag.b.AnonymousClass6.AnonymousClass1 */

                                    @Override // com.tencent.mm.model.gdpr.b
                                    public final void sx(final int i2) {
                                        AppMethodBeat.i(210987);
                                        Log.i("MicroMsg.OauthAuthorizeLogic", " MPGdprPolicyUtil.checkPolicy onPermissionReturn:%d", Integer.valueOf(i2));
                                        MMHandlerThread.postToMainThread(new Runnable() {
                                            /* class com.tencent.mm.plugin.webview.model.ag.b.AnonymousClass6.AnonymousClass1.AnonymousClass1 */

                                            public final void run() {
                                                AppMethodBeat.i(210986);
                                                if (i2 == 1) {
                                                    cVar.goBack();
                                                    com.tencent.mm.plugin.webview.k.b.INSTANCE.a(aYE == null ? "" : aYE, b.startTime, 0, 1, 0, 1, i3);
                                                } else {
                                                    com.tencent.mm.plugin.webview.k.b.INSTANCE.a(aYE == null ? "" : aYE, b.startTime, 1, 1, 0, 1, i3);
                                                    b.a(bundle, bundle, cVar, eVar, aVar, context);
                                                }
                                                com.tencent.mm.plugin.webview.k.b.INSTANCE.aO(2, (int) (System.currentTimeMillis() - b.IYc), i3);
                                                AppMethodBeat.o(210986);
                                            }
                                        });
                                        AppMethodBeat.o(210987);
                                    }
                                });
                                AppMethodBeat.o(210988);
                                return;
                            case 2:
                            case 3:
                                b.b(bundle, bundle, cVar, eVar, aVar, context);
                                com.tencent.mm.plugin.webview.k.b.INSTANCE.a(aYE == null ? "" : aYE, b.startTime, 0, 1, 0, 1, i3);
                                com.tencent.mm.plugin.webview.k.b.INSTANCE.aO(2, (int) (System.currentTimeMillis() - b.IYc), i3);
                                AppMethodBeat.o(210988);
                                return;
                            default:
                                cVar.goBack();
                                AppMethodBeat.o(210988);
                                return;
                        }
                    }
                };
                if (!(context instanceof WebViewUI) || !((WebViewUI) context).isFinishing()) {
                    final LinkedList<drb> aZ = ag.aZ((ArrayList) bundle.getSerializable("scope_list"));
                    final String string2 = bundle.getString("appname");
                    final String string3 = bundle.getString("appicon_url");
                    h.RTc.aV(new Runnable() {
                        /* class com.tencent.mm.plugin.webview.model.ag.b.AnonymousClass8 */

                        public final void run() {
                            AppMethodBeat.i(210991);
                            new r(context).a(aZ, string2, string3, context.getString(R.string.j1v), r2);
                            AppMethodBeat.o(210991);
                        }
                    });
                } else {
                    Log.i("MicroMsg.OauthAuthorizeLogic", "showWebAuthorizeDialog isFinishing");
                }
            } else {
                h.RTc.aV(new Runnable() {
                    /* class com.tencent.mm.plugin.webview.model.ag.b.AnonymousClass5 */

                    public final void run() {
                        AppMethodBeat.i(210985);
                        ah.a(context, bundle, i2, cVar);
                        AppMethodBeat.o(210985);
                    }
                });
            }
            com.tencent.mm.plugin.webview.k.b.INSTANCE.aO(1, (int) (System.currentTimeMillis() - startTime), i3);
            AppMethodBeat.o(78954);
        }

        public static void a(boolean z, final String str, Bundle bundle, final Context context, final c cVar, a aVar) {
            AppMethodBeat.i(78955);
            Log.i("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeConfirmSceneEnd suc: %b", Boolean.valueOf(z));
            if (context == null || ((WebViewUI) context).isFinishing()) {
                AppMethodBeat.o(78955);
                return;
            }
            aVar.xr();
            if (!z) {
                h.RTc.aV(new Runnable() {
                    /* class com.tencent.mm.plugin.webview.model.ag.b.AnonymousClass7 */

                    public final void run() {
                        AppMethodBeat.i(210990);
                        com.tencent.mm.ui.base.h.d(context, str, MMApplicationContext.getContext().getString(R.string.j1i), new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.webview.model.ag.b.AnonymousClass7.AnonymousClass1 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(210989);
                                cVar.goBack();
                                AppMethodBeat.o(210989);
                            }
                        });
                        AppMethodBeat.o(210990);
                    }
                });
                AppMethodBeat.o(78955);
                return;
            }
            String string = bundle.getString("redirect_url");
            if (Util.isNullOrNil(string)) {
                Log.e("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeConfirmSceneEnd redirect null");
                AppMethodBeat.o(78955);
                return;
            }
            cVar.aXL(string);
            Log.i("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeConfirmSceneEnd redirectUrl: %s", string);
            AppMethodBeat.o(78955);
        }

        private static void a(final e eVar, String str, int i2, ArrayList<String> arrayList, final a aVar, final boolean z, final c cVar, final Context context) {
            AppMethodBeat.i(210995);
            if (eVar == null) {
                Log.e("MicroMsg.OauthAuthorizeLogic", "doOauthAuthorizeConfirm invoker null");
                AppMethodBeat.o(210995);
                return;
            }
            IYc = System.currentTimeMillis();
            cua cua = new cua();
            cua.Mzp = str;
            cua.Mzq = i2;
            cua.Mzr = new LinkedList<>(arrayList);
            d.a aVar2 = new d.a();
            aVar2.iLN = cua;
            aVar2.iLO = new cub();
            aVar2.uri = "/cgi-bin/mmbiz-bin/oauth_authorize_confirm";
            aVar2.funcId = 1373;
            aVar2.iLP = 0;
            aVar2.respCmdId = 0;
            IPCRunCgi.a(aVar2.aXF(), new IPCRunCgi.a() {
                /* class com.tencent.mm.plugin.webview.model.ag.b.AnonymousClass9 */

                @Override // com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a
                public final void a(int i2, int i3, String str, d dVar) {
                    AppMethodBeat.i(210992);
                    Log.i("MicroMsg.OauthAuthorizeLogic", "onSceneEnd doOauthAuthorizeConfirm errType = %d, errCode = %d ,errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                    if (eVar == null || aVar == null || !z) {
                        AppMethodBeat.o(210992);
                        return;
                    }
                    Bundle bundle = new Bundle();
                    if (i2 != 0 || i3 != 0 || dVar == null || dVar.iLL.iLR == null || !(dVar.iLL.iLR instanceof cub)) {
                        b.a(false, str, bundle, context, cVar, aVar);
                        AppMethodBeat.o(210992);
                        return;
                    }
                    bundle.putString("redirect_url", ((cub) dVar.iLL.iLR).KJw);
                    b.a(true, str, bundle, context, cVar, aVar);
                    AppMethodBeat.o(210992);
                }
            });
            AppMethodBeat.o(210995);
        }

        public static String aYE(String str) {
            String str2 = null;
            AppMethodBeat.i(78959);
            if (Util.isNullOrNil(str)) {
                AppMethodBeat.o(78959);
            } else {
                try {
                    str2 = Uri.parse(str).getQueryParameter("appid");
                    if (Util.isNullOrNil(str2)) {
                        Log.i("MicroMsg.OauthAuthorizeLogic", "parseAppId try case not sensitive, oauthUrl:%s", str);
                        str2 = Uri.parse(str.toLowerCase()).getQueryParameter("appid");
                    }
                } catch (Exception e2) {
                }
                AppMethodBeat.o(78959);
            }
            return str2;
        }

        static /* synthetic */ void a(Bundle bundle, Bundle bundle2, c cVar, e eVar, a aVar, Context context) {
            AppMethodBeat.i(210996);
            Log.i("MicroMsg.OauthAuthorizeLogic", "doAcceptLogic");
            if (bundle.getBoolean("is_call_server_when_confirm")) {
                a(eVar, bundle.getString("oauth_url"), 1, (ArrayList<String>) ((ArrayList) bundle2.getSerializable("key_scope")), aVar, true, cVar, context);
                AppMethodBeat.o(210996);
                return;
            }
            String string = bundle.getString("redirect_url");
            cVar.aXL(string);
            Log.i("MicroMsg.OauthAuthorizeLogic", "doAcceptLogic redirectUrl: %s", string);
            AppMethodBeat.o(210996);
        }

        static /* synthetic */ void b(Bundle bundle, Bundle bundle2, c cVar, e eVar, a aVar, Context context) {
            ArrayList arrayList;
            AppMethodBeat.i(210997);
            Log.i("MicroMsg.OauthAuthorizeLogic", "doRejectLogic");
            String string = bundle.getString("oauth_url");
            if (bundle2 == null) {
                arrayList = new ArrayList();
            } else {
                arrayList = (ArrayList) bundle2.getSerializable("key_scope");
            }
            a(eVar, string, 2, (ArrayList<String>) arrayList, aVar, false, cVar, context);
            cVar.goBack();
            AppMethodBeat.o(210997);
        }
    }

    private static ArrayList<byte[]> bA(LinkedList<cuh> linkedList) {
        AppMethodBeat.i(78962);
        ArrayList<byte[]> arrayList = new ArrayList<>();
        if (linkedList == null || linkedList.isEmpty()) {
            AppMethodBeat.o(78962);
            return arrayList;
        }
        for (int i2 = 0; i2 < linkedList.size(); i2++) {
            try {
                arrayList.add(linkedList.get(i2).toByteArray());
            } catch (IOException e2) {
                Log.w("MicroMsg.OauthAuthorizeLogic", "oauthScopeInfoListToBytesList index:%d, exp:%s ", Integer.valueOf(i2), e2.getLocalizedMessage());
                arrayList.clear();
                AppMethodBeat.o(78962);
                return arrayList;
            }
        }
        AppMethodBeat.o(78962);
        return arrayList;
    }

    public static LinkedList<drb> aZ(ArrayList<byte[]> arrayList) {
        AppMethodBeat.i(78963);
        LinkedList<drb> linkedList = new LinkedList<>();
        if (arrayList == null || arrayList.isEmpty()) {
            AppMethodBeat.o(78963);
            return linkedList;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            try {
                cuh cuh = new cuh();
                cuh.parseFrom(arrayList.get(i2));
                drb drb = new drb();
                drb.MTI = cuh.MzA;
                drb.Desc = cuh.desc;
                drb.KWK = cuh.scope;
                drb.nBo = cuh.nBo;
                linkedList.add(drb);
            } catch (IOException e2) {
                Log.w("MicroMsg.OauthAuthorizeLogic", "bytesListToBytesListScopeInfoList: i:%d, exp:%s", Integer.valueOf(i2), e2.getLocalizedMessage());
                linkedList.clear();
                AppMethodBeat.o(78963);
                return linkedList;
            }
        }
        AppMethodBeat.o(78963);
        return linkedList;
    }
}
