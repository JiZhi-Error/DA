package com.tencent.mm.plugin.webview.model;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.modelmsg.SendTdiAuth;
import com.tencent.mm.plugin.webview.model.ai;
import com.tencent.mm.protocal.protobuf.cuh;
import com.tencent.mm.protocal.protobuf.dri;
import com.tencent.mm.protocal.protobuf.drk;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.Iterator;
import java.util.LinkedList;

public final class aj {
    private boolean IYZ;
    boolean IZa = false;
    private String lDx;
    public String mAppId;
    private Context mContext;
    private String xFX;
    String xOq;
    private String xyo;

    public aj(Context context, String str, String str2) {
        this.mContext = context;
        this.IZa = true;
        this.mAppId = str;
        this.xyo = str2;
    }

    public aj(Context context, String str, String str2, String str3, String str4) {
        this.mContext = context;
        this.mAppId = str;
        this.xOq = str2;
        this.lDx = str3;
        this.IYZ = false;
        this.xFX = str4;
    }

    public final void bE(LinkedList<String> linkedList) {
        AppMethodBeat.i(78968);
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < linkedList.size(); i2++) {
            sb.append(linkedList.get(i2)).append(",");
        }
        Log.i("MicroMsg.SDKOauthUtil", "doSDKOauthAuthorizeConfirm selectedScopes: %s", sb.toString());
        g.azz().a(new ac(1, this.mAppId, this.lDx, aYG(this.mAppId), linkedList, this.xFX), 0);
        AppMethodBeat.o(78968);
    }

    public final void k(LinkedList<String> linkedList, int i2) {
        AppMethodBeat.i(78969);
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < linkedList.size(); i3++) {
            sb.append(linkedList.get(i3)).append(",");
        }
        Log.i("MicroMsg.SDKOauthUtil", "doSDKOauthAuthorizeConfirm selectedScopes: %s", sb.toString());
        g.azz().a(new ac(this.mAppId, this.lDx, aYG(this.mAppId), linkedList, i2, this.xFX), 0);
        AppMethodBeat.o(78969);
    }

    public final void i(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(78970);
        Log.i("MicroMsg.SDKOauthUtil", "onSDKOauthAuthorizeConfirmEnd errType:%d errCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 && i3 == 0) {
            dri gcA = ((ac) qVar).gcA();
            a(ai.a.a(gcA), org.apache.commons.b.g.a(new LinkedList(((ac) qVar).IXZ), ","));
            AppMethodBeat.o(78970);
        } else if (!agc(i2)) {
            axc(this.mContext.getString(R.string.j1j));
            AppMethodBeat.o(78970);
        } else {
            axc(str);
            AppMethodBeat.o(78970);
        }
    }

    public static void a(LinkedList<String> linkedList, int i2, String str) {
        AppMethodBeat.i(78971);
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < linkedList.size(); i3++) {
            sb.append(linkedList.get(i3)).append(",");
        }
        Log.i("MicroMsg.SDKOauthUtil", "doQRCodeOauthAuthorizeConfirm selectedScopes: %s", sb.toString());
        g.azz().a(new aa(1, str, linkedList, i2), 0);
        AppMethodBeat.o(78971);
    }

    public final void Q(int i2, int i3, String str) {
        AppMethodBeat.i(78972);
        Log.i("MicroMsg.SDKOauthUtil", "onQRCodeOauthAuthorizeConfirmEnd errType:%d errCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 && i3 == 0) {
            ((MMActivity) this.mContext).finish();
            AppMethodBeat.o(78972);
        } else if (!agc(i2)) {
            axc(this.mContext.getString(R.string.j1j));
            AppMethodBeat.o(78972);
        } else {
            axc(str);
            AppMethodBeat.o(78972);
        }
    }

    public final void a(ai aiVar, String str) {
        SendAuth.Resp resp;
        Uri uri;
        String str2;
        AppMethodBeat.i(211000);
        String gcK = aiVar.gcK();
        Log.i("MicroMsg.SDKOauthUtil", "dealWithLoginCallback url : %s", gcK);
        String aYG = aYG(this.mAppId);
        if (Util.isNullOrNil(aYG)) {
            Log.e("MicroMsg.SDKOauthUtil", "dealWithLoginCallback pkg nil");
            AppMethodBeat.o(211000);
            return;
        }
        boolean equals = str.trim().equals("snsapi_wxaapp_info");
        if (aiVar.gcL() == null || aiVar.gcL().zy.length <= 0) {
            resp = new SendAuth.Resp();
        } else {
            resp = new SendTdiAuth.Resp(Bundle.EMPTY);
            ((SendTdiAuth.Resp) resp).tdiAuthBuffer = aiVar.gcL().toByteArray();
        }
        resp.transaction = this.xOq;
        resp.lang = gcM();
        resp.country = getCountry();
        if (!Util.isNullOrNil(gcK)) {
            uri = Uri.parse(gcK);
        } else {
            uri = null;
        }
        if (uri != null) {
            str2 = uri.getQueryParameter(TMQQDownloaderOpenSDKConst.UINTYPE_CODE);
            resp.state = uri.getQueryParameter("state");
            resp.errStr = uri.getQueryParameter("reason");
        } else {
            str2 = null;
        }
        if (Util.isNullOrNil(str2) && !equals) {
            resp.errCode = -1;
        } else if (Util.nullAsNil(str2).toLowerCase().equals("authdeny")) {
            resp.errCode = -4;
        } else {
            resp.errCode = 0;
            if (!equals) {
                resp.code = str2;
            } else {
                resp.authResult = true;
            }
        }
        if (!equals) {
            resp.url = gcK;
        }
        Log.i("MicroMsg.SDKOauthUtil", "dealWithLoginCallback, pkg:%s code:%s errCode:%d state:%s", aYG, resp.code, Integer.valueOf(resp.errCode), resp.state);
        a(aYG, resp);
        ((MMActivity) this.mContext).finish();
        AppMethodBeat.o(211000);
    }

    public static cuh e(String str, LinkedList<cuh> linkedList) {
        AppMethodBeat.i(78974);
        Iterator<cuh> it = linkedList.iterator();
        while (it.hasNext()) {
            cuh next = it.next();
            if (str.equals(next.scope)) {
                AppMethodBeat.o(78974);
                return next;
            }
        }
        AppMethodBeat.o(78974);
        return null;
    }

    public final void agb(int i2) {
        AppMethodBeat.i(78975);
        Log.i("MicroMsg.SDKOauthUtil", "dealWithCancel");
        if (this.IZa) {
            g.azz().a(new aa(2, this.xyo, null, 0), 0);
            ((MMActivity) this.mContext).finish();
            AppMethodBeat.o(78975);
            return;
        }
        String aYG = aYG(this.mAppId);
        g.azz().a(new ac(2, this.mAppId, this.lDx, aYG, (LinkedList<String>) null, this.xFX), 0);
        SendAuth.Resp resp = new SendAuth.Resp();
        resp.transaction = this.xOq;
        resp.errCode = i2;
        resp.lang = gcM();
        resp.country = getCountry();
        a(aYG, resp);
        ((MMActivity) this.mContext).finish();
        AppMethodBeat.o(78975);
    }

    private void axc(final String str) {
        AppMethodBeat.i(78976);
        h.d(this.mContext, str, this.mContext.getString(R.string.j1i), new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.webview.model.aj.AnonymousClass1 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(78966);
                if (!aj.this.IZa) {
                    aj ajVar = aj.this;
                    String str = str;
                    String aYG = aj.aYG(ajVar.mAppId);
                    if (Util.isNullOrNil(aYG)) {
                        Log.e("MicroMsg.SDKOauthUtil", "dealWithError pkg nil");
                        AppMethodBeat.o(78966);
                        return;
                    }
                    SendAuth.Resp resp = new SendAuth.Resp();
                    resp.transaction = ajVar.xOq;
                    resp.errCode = -1;
                    resp.errStr = str;
                    resp.lang = ajVar.gcM();
                    resp.country = aj.getCountry();
                    ajVar.a(aYG, resp);
                }
                AppMethodBeat.o(78966);
            }
        });
        AppMethodBeat.o(78976);
    }

    /* access modifiers changed from: package-private */
    public final void a(String str, SendAuth.Resp resp) {
        AppMethodBeat.i(78977);
        if (this.IYZ) {
            Log.i("MicroMsg.SDKOauthUtil", "doCallback has callback");
            AppMethodBeat.o(78977);
        } else if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(78977);
        } else {
            this.IYZ = true;
            Bundle bundle = new Bundle();
            resp.toBundle(bundle);
            com.tencent.mm.pluginsdk.model.app.q.bo(bundle);
            MMessageActV2.Args args = new MMessageActV2.Args();
            args.targetPkgName = str;
            args.bundle = bundle;
            MMessageActV2.send(this.mContext, args);
            AppMethodBeat.o(78977);
        }
    }

    static String aYG(String str) {
        AppMethodBeat.i(78978);
        String str2 = null;
        com.tencent.mm.pluginsdk.model.app.g o = com.tencent.mm.pluginsdk.model.app.h.o(str, false, false);
        if (o != null) {
            str2 = o.field_packageName;
        } else {
            Log.w("MicroMsg.SDKOauthUtil", "dealWithCancel getAppInfo null; appid: %s", str);
        }
        AppMethodBeat.o(78978);
        return str2;
    }

    static String getCountry() {
        AppMethodBeat.i(78979);
        String nullAs = Util.nullAs((String) g.aAh().azQ().get(274436, (Object) null), (String) null);
        AppMethodBeat.o(78979);
        return nullAs;
    }

    /* access modifiers changed from: package-private */
    public final String gcM() {
        AppMethodBeat.i(78980);
        String loadApplicationLanguage = LocaleUtil.loadApplicationLanguage(this.mContext.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), this.mContext);
        AppMethodBeat.o(78980);
        return loadApplicationLanguage;
    }

    private boolean agc(int i2) {
        AppMethodBeat.i(78981);
        if (i2 == 1 || i2 == 2 || i2 == 7 || i2 == 8) {
            Log.e("MicroMsg.SDKOauthUtil", "isNetworkAvailable false, errType = ".concat(String.valueOf(i2)));
            AppMethodBeat.o(78981);
            return false;
        } else if (!NetStatusUtil.isConnected(this.mContext)) {
            Log.e("MicroMsg.SDKOauthUtil", "isNetworkAvailable false, not connected");
            AppMethodBeat.o(78981);
            return false;
        } else {
            AppMethodBeat.o(78981);
            return true;
        }
    }

    public static void aT(final Activity activity) {
        AppMethodBeat.i(78982);
        activity.overridePendingTransition(R.anim.s, R.anim.s);
        if (d.oD(28)) {
            activity.finish();
            AppMethodBeat.o(78982);
            return;
        }
        MMHandlerThread.postToMainThreadDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.webview.model.aj.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(78967);
                activity.finish();
                AppMethodBeat.o(78967);
            }
        }, 500);
        AppMethodBeat.o(78982);
    }

    public static boolean b(drk drk) {
        AppMethodBeat.i(78983);
        if (e("snsapi_userinfo", drk.Mzs) == null && e("snsapi_login", drk.Mzs) == null && e("group_sns_login", drk.Mzs) == null) {
            AppMethodBeat.o(78983);
            return false;
        }
        AppMethodBeat.o(78983);
        return true;
    }

    public static void a(drk drk, LinkedList<String> linkedList) {
        AppMethodBeat.i(78984);
        if (e("snsapi_userinfo", drk.Mzs) != null) {
            linkedList.add("snsapi_userinfo");
            AppMethodBeat.o(78984);
        } else if (e("snsapi_login", drk.Mzs) != null) {
            linkedList.add("snsapi_login");
            AppMethodBeat.o(78984);
        } else {
            linkedList.add("group_sns_login");
            AppMethodBeat.o(78984);
        }
    }
}
