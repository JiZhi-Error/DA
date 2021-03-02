package com.tencent.mm.plugin.ext.openapi.provider;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.support.constraint.ConstraintLayout;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.aj.e;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.ft;
import com.tencent.mm.g.a.fw;
import com.tencent.mm.g.a.ge;
import com.tencent.mm.g.a.ws;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelvoice.k;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.appusage.ag;
import com.tencent.mm.plugin.appbrand.appusage.ah;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.m;
import com.tencent.mm.plugin.appbrand.service.q;
import com.tencent.mm.plugin.ext.d.b;
import com.tencent.mm.plugin.ext.d.d;
import com.tencent.mm.plugin.ext.d.e;
import com.tencent.mm.plugin.ext.provider.ExtContentProviderBase;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.pluginsdk.b;
import com.tencent.mm.pluginsdk.d.a.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.SyncTask;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.cr;
import com.tencent.mm.vfs.s;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.p;
import org.xwalk.core.XWalkAppVersion;

public class ExtControlProviderOpenApi extends ExtContentProviderBase {
    public static boolean IS_DEBUG = false;
    private static final String[] sMG = {"retCode", "selfId"};
    private static final String[] sMH = {"retCode", "sportConfig"};
    private static final String[] sMI = {Scopes.OPEN_ID, "avatar"};
    private static final String[] sMJ = {"voiceType", "sampleRateInHz", "channelConfig", "audioFormat", "filePath"};
    private static final String[] sMK = {TPDownloadProxyEnum.USER_SSID, "macAddress", "isSupportWechat", "name"};
    private static final String[] sML = {ch.COL_USERNAME, "appId", "versionType", "nickname", "shortNickname", "iconURL", "collection", "runningFlag", "wechatPkg", NativeProtocol.WEB_DIALOG_ACTION, "intentInfo"};
    private static final String[] sMM = {"token", "nickname", "iconURL"};
    private String appId;
    private Context context;
    private MMHandler handler;
    private String[] sMN;
    private int sMO;

    static /* synthetic */ Cursor a(ExtControlProviderOpenApi extControlProviderOpenApi, String[] strArr) {
        AppMethodBeat.i(24402);
        Cursor a2 = extControlProviderOpenApi.a(strArr, true);
        AppMethodBeat.o(24402);
        return a2;
    }

    static /* synthetic */ String b(ExtControlProviderOpenApi extControlProviderOpenApi) {
        AppMethodBeat.i(24399);
        String cSt = extControlProviderOpenApi.cSt();
        AppMethodBeat.o(24399);
        return cSt;
    }

    static /* synthetic */ String c(ExtControlProviderOpenApi extControlProviderOpenApi) {
        AppMethodBeat.i(24400);
        String cSt = extControlProviderOpenApi.cSt();
        AppMethodBeat.o(24400);
        return cSt;
    }

    static /* synthetic */ String e(ExtControlProviderOpenApi extControlProviderOpenApi) {
        AppMethodBeat.i(24401);
        String cSt = extControlProviderOpenApi.cSt();
        AppMethodBeat.o(24401);
        return cSt;
    }

    private ExtControlProviderOpenApi(String[] strArr, int i2, Context context2) {
        this.sMN = null;
        this.appId = "";
        this.sMO = -1;
        this.sMN = strArr;
        this.sMO = i2;
        this.context = context2;
    }

    public ExtControlProviderOpenApi(String[] strArr, int i2, Context context2, String str) {
        this(strArr, i2, context2);
        this.appId = str;
    }

    @Override // com.tencent.mm.plugin.ext.provider.ExtContentProviderBase
    public String getType(Uri uri) {
        return null;
    }

    @Override // com.tencent.mm.plugin.ext.provider.ExtContentProviderBase
    public boolean onCreate() {
        AppMethodBeat.i(24390);
        this.handler = new MMHandler();
        AppMethodBeat.o(24390);
        return true;
    }

    @Override // com.tencent.mm.plugin.ext.provider.ExtContentProviderBase
    public Cursor query(Uri uri, String[] strArr, String str, final String[] strArr2, String str2) {
        String str3;
        e.a aVar;
        e.a aVar2;
        boolean z;
        AppMethodBeat.i(24391);
        Log.i("MicroMsg.ExtControlProviderOpenApi", "query(), ApiId = %s", Integer.valueOf(this.sMO));
        a(uri, this.context, this.sMO, this.sMN);
        String str4 = this.sMZ;
        if (uri == null) {
            Log.e("MicroMsg.ExtControlProviderOpenApi", "uri == null return code = 5");
            fP(3, 5);
            MatrixCursor ahx = a.ahx(5);
            AppMethodBeat.o(24391);
            return ahx;
        } else if (Util.isNullOrNil(this.sMZ)) {
            Log.e("MicroMsg.ExtControlProviderOpenApi", "AppID == null return code = 7");
            fP(3, 7);
            MatrixCursor ahx2 = a.ahx(7);
            AppMethodBeat.o(24391);
            return ahx2;
        } else if (Util.isNullOrNil(cSt())) {
            Log.e("MicroMsg.ExtControlProviderOpenApi", "PkgName == null return code = 6");
            fP(3, 6);
            MatrixCursor ahx3 = a.ahx(6);
            AppMethodBeat.o(24391);
            return ahx3;
        } else if (!ckf()) {
            Log.e("MicroMsg.ExtControlProviderOpenApi", "not login return code = 3");
            fP(1, 3);
            MatrixCursor ahx4 = a.ahx(3);
            AppMethodBeat.o(24391);
            return ahx4;
        } else {
            int i2 = 1;
            if (!IS_DEBUG) {
                i2 = cSu();
            }
            if (i2 != 1) {
                Log.e("MicroMsg.ExtControlProviderOpenApi", "invalid appid ! return code = ".concat(String.valueOf(i2)));
                fP(2, i2);
                MatrixCursor ahx5 = a.ahx(i2);
                AppMethodBeat.o(24391);
                return ahx5;
            }
            switch (this.sMO) {
                case 22:
                    Cursor m = m(uri.getQueryParameter("op"), uri.getQueryParameter("scene"), uri.getQueryParameter("msgType"), uri.getQueryParameter("msgState"));
                    AppMethodBeat.o(24391);
                    return m;
                case 23:
                    Cursor y = y(strArr2);
                    AppMethodBeat.o(24391);
                    return y;
                case 24:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 39:
                case 43:
                case 44:
                case 45:
                case 47:
                case 49:
                case 50:
                case 53:
                case 55:
                default:
                    fP(3, 15);
                    AppMethodBeat.o(24391);
                    return null;
                case 25:
                    Cursor z2 = z(strArr2);
                    AppMethodBeat.o(24391);
                    return z2;
                case 34:
                    Log.i("MicroMsg.ExtControlProviderOpenApi", "sendSight ");
                    if (strArr2 == null || strArr2.length <= 0 || strArr2[0].length() <= 0) {
                        Object[] objArr = new Object[1];
                        objArr[0] = Boolean.valueOf(strArr2 == null);
                        Log.e("MicroMsg.ExtControlProviderOpenApi", "sendSight wrong args,args == null:%s", objArr);
                        fP(3, 3401);
                        MatrixCursor ahx6 = a.ahx(3401);
                        AppMethodBeat.o(24391);
                        return ahx6;
                    }
                    String str5 = strArr2[0];
                    if (Util.isNullOrNil(str5) || !s.YS(str5)) {
                        z = false;
                    } else {
                        d dVar = new d();
                        z = SightVideoJNI.isSightOkVFS(str5, dVar.Dmj, dVar.Dmk, dVar.Dml, dVar.Dmn, dVar.Dmm, dVar.Dmm.length) == 0;
                    }
                    if (!z) {
                        Log.e("MicroMsg.ExtControlProviderOpenApi", "isSightOk wrong args");
                        fP(3, 3402);
                        MatrixCursor ahx7 = a.ahx(3402);
                        AppMethodBeat.o(24391);
                        return ahx7;
                    }
                    Intent intent = new Intent();
                    intent.addFlags(268435456);
                    intent.addFlags(67108864);
                    intent.putExtra("sight_local_path", str5);
                    c.f(this.context, ".ui.transmit.SightForwardUI", intent);
                    ac(12, 0, 1);
                    MatrixCursor ahx8 = a.ahx(1);
                    AppMethodBeat.o(24391);
                    return ahx8;
                case 35:
                    Log.i("MicroMsg.ExtControlProviderOpenApi", "hy: start redirect to chatting by phone num");
                    if (strArr2 == null || strArr2.length <= 0 || Util.isNullOrNil(strArr2[0])) {
                        Log.e("MicroMsg.ExtControlProviderOpenApi", "hy: args error: no phone num or phone num is null or nil");
                        fP(3, 3201);
                        MatrixCursor ahx9 = a.ahx(3201);
                        AppMethodBeat.o(24391);
                        return ahx9;
                    }
                    String str6 = strArr2[0];
                    Log.i("MicroMsg.ExtControlProviderOpenApi", "hy: start searching for phone num: %s", str6);
                    int cSp = new com.tencent.mm.plugin.ext.b.c(this.context, str6).cSp();
                    Log.i("MicroMsg.ExtControlProviderOpenApi", " ret =  ", Integer.valueOf(cSp));
                    if (cSp != -1) {
                        ac(14, 0, cSp);
                        cSp = 0;
                    } else {
                        ac(15, 0, cSp);
                    }
                    MatrixCursor ahx10 = a.ahx(cSp);
                    AppMethodBeat.o(24391);
                    return ahx10;
                case 36:
                    Log.i("MicroMsg.ExtControlProviderOpenApi", "hy: start redirect to wechat out by phone num");
                    if (strArr2 == null || strArr2.length < 3) {
                        Log.e("MicroMsg.ExtControlProviderOpenApi", "hy: wechat out args error: args length error");
                        fP(3, 3301);
                        MatrixCursor ahx11 = a.ahx(3301);
                        AppMethodBeat.o(24391);
                        return ahx11;
                    }
                    String str7 = strArr2[0];
                    int i3 = Util.getInt(strArr2[1], -1);
                    String str8 = strArr2[2];
                    Log.i("MicroMsg.ExtControlProviderOpenApi", "hy: start wechat out: contactid: %s, countrycode: %s,  phone num: %s", str7, Integer.valueOf(i3), str8);
                    if (Util.isNullOrNil(str7) || i3 < 0 || Util.isNullOrNil(str8)) {
                        Log.i("MicroMsg.ExtControlProviderOpenApi", "hy: param err");
                        fP(3, 3302);
                        MatrixCursor ahx12 = a.ahx(3302);
                        AppMethodBeat.o(24391);
                        return ahx12;
                    }
                    ws wsVar = new ws();
                    wsVar.ede.edf = str7;
                    wsVar.ede.edg = i3;
                    wsVar.ede.ebd = str8;
                    wsVar.ede.nickName = b.k(str7, this.context);
                    EventCenter.instance.publish(wsVar);
                    ac(16, 0, 1);
                    MatrixCursor ahx13 = a.ahx(1);
                    AppMethodBeat.o(24391);
                    return ahx13;
                case 37:
                    Log.d("MicroMsg.ExtControlProviderOpenApi", com.tencent.mm.plugin.appbrand.jsapi.wifi.c.NAME);
                    this.handler = new MMHandler(Looper.getMainLooper());
                    MatrixCursor matrixCursor = (MatrixCursor) new SyncTask<MatrixCursor>() {
                        /* class com.tencent.mm.plugin.ext.openapi.provider.ExtControlProviderOpenApi.AnonymousClass2 */

                        /* Return type fixed from 'java.lang.Object' to match base method */
                        @Override // com.tencent.mm.sdk.platformtools.SyncTask
                        public final /* synthetic */ MatrixCursor run() {
                            AppMethodBeat.i(24386);
                            MatrixCursor cSr = cSr();
                            AppMethodBeat.o(24386);
                            return cSr;
                        }

                        private MatrixCursor cSr() {
                            AppMethodBeat.i(24385);
                            try {
                                Log.d("MicroMsg.ExtControlProviderOpenApi", "syncTaskCur run ");
                                final fw fwVar = new fw();
                                fwVar.dJq.dJs = strArr2;
                                fwVar.callback = new Runnable() {
                                    /* class com.tencent.mm.plugin.ext.openapi.provider.ExtControlProviderOpenApi.AnonymousClass2.AnonymousClass1 */

                                    public final void run() {
                                        AppMethodBeat.i(24384);
                                        Log.i("MicroMsg.ExtControlProviderOpenApi", "getWifiList run");
                                        if (fwVar == null || fwVar.dJr == null || fwVar.dJr.dIY == 0) {
                                            AppMethodBeat.o(24384);
                                            return;
                                        }
                                        Log.i("MicroMsg.ExtControlProviderOpenApi", "getWifiList return cursor");
                                        AnonymousClass2.this.setResultFinish(fwVar.dJr.dJt);
                                        AppMethodBeat.o(24384);
                                    }
                                };
                                if (!EventCenter.instance.publish(fwVar)) {
                                    Log.i("MicroMsg.ExtControlProviderOpenApi", "getWifiList publish getWifiListEvent fail");
                                    setResultFinish(a.ahx(8));
                                }
                            } catch (Exception e2) {
                                Log.e("MicroMsg.ExtControlProviderOpenApi", "exception in getWifiList syncTaskCur.", e2);
                                setResultFinish(a.ahx(12));
                            }
                            AppMethodBeat.o(24385);
                            return null;
                        }
                    }.exec(this.handler);
                    if (matrixCursor == null) {
                        ac(19, 4, 14);
                        MatrixCursor ahx14 = a.ahx(14);
                        AppMethodBeat.o(24391);
                        return ahx14;
                    }
                    ac(18, 0, 1);
                    Log.i("MicroMsg.ExtControlProviderOpenApi", "returnMatrix syncTaskCur");
                    AppMethodBeat.o(24391);
                    return matrixCursor;
                case 38:
                    Log.d("MicroMsg.ExtControlProviderOpenApi", com.tencent.mm.plugin.appbrand.jsapi.wifi.a.NAME);
                    this.handler = new MMHandler(Looper.getMainLooper());
                    Integer num = (Integer) new SyncTask<Integer>() {
                        /* class com.tencent.mm.plugin.ext.openapi.provider.ExtControlProviderOpenApi.AnonymousClass3 */

                        /* Return type fixed from 'java.lang.Object' to match base method */
                        @Override // com.tencent.mm.sdk.platformtools.SyncTask
                        public final /* synthetic */ Integer run() {
                            AppMethodBeat.i(24389);
                            Integer bjO = bjO();
                            AppMethodBeat.o(24389);
                            return bjO;
                        }

                        private Integer bjO() {
                            AppMethodBeat.i(24388);
                            try {
                                Log.d("MicroMsg.ExtControlProviderOpenApi", "syncTaskCur run ");
                                final ft ftVar = new ft();
                                ftVar.dIV.version = Util.getInt(strArr2[0], 0);
                                ftVar.dIV.ssid = strArr2[1];
                                ftVar.dIV.bssid = strArr2[2];
                                ftVar.dIV.dIX = Util.getInt(strArr2[3], 0);
                                ftVar.callback = new Runnable() {
                                    /* class com.tencent.mm.plugin.ext.openapi.provider.ExtControlProviderOpenApi.AnonymousClass3.AnonymousClass1 */

                                    public final void run() {
                                        AppMethodBeat.i(24387);
                                        Log.i("MicroMsg.ExtControlProviderOpenApi", "connectWifi run");
                                        if (ftVar == null || ftVar.dIW == null || ftVar.dIW.dIY == 0) {
                                            AppMethodBeat.o(24387);
                                            return;
                                        }
                                        Log.i("MicroMsg.ExtControlProviderOpenApi", "connectWifi errcode = %s,errmsg = %s", Integer.valueOf(ftVar.dIW.dIZ), ftVar.dIW.dJa);
                                        AnonymousClass3.this.setResultFinish(Integer.valueOf(ftVar.dIW.dIZ));
                                        AppMethodBeat.o(24387);
                                    }
                                };
                                if (!EventCenter.instance.publish(ftVar)) {
                                    Log.i("MicroMsg.ExtControlProviderOpenApi", "connectWifi publish getWifiListEvent fail");
                                    setResultFinish(8);
                                }
                            } catch (Exception e2) {
                                Log.e("MicroMsg.ExtControlProviderOpenApi", "exception in connectWifi syncTaskInt.", e2);
                                setResultFinish(12);
                            }
                            AppMethodBeat.o(24388);
                            return 0;
                        }
                    }.exec(this.handler);
                    if (num == null) {
                        ac(21, 4, 14);
                        MatrixCursor ahx15 = a.ahx(14);
                        AppMethodBeat.o(24391);
                        return ahx15;
                    }
                    ac(20, 0, num.intValue());
                    MatrixCursor ahx16 = a.ahx(num.intValue());
                    AppMethodBeat.o(24391);
                    return ahx16;
                case 40:
                    Log.i("MicroMsg.ExtControlProviderOpenApi", "setSportStep start");
                    if (strArr2 == null || strArr2.length < 3) {
                        Log.e("MicroMsg.ExtControlProviderOpenApi", "args error: args length error");
                        ac(23, 3, 2);
                        MatrixCursor ahx17 = a.ahx(2);
                        AppMethodBeat.o(24391);
                        return ahx17;
                    }
                    long j2 = Util.getLong(strArr2[0], -1);
                    long j3 = Util.getLong(strArr2[1], -1);
                    long j4 = Util.getLong(strArr2[2], -1);
                    Log.i("MicroMsg.ExtControlProviderOpenApi", "setSportStep: timestampe: %s, stepcount: %s,  version: %s", Long.valueOf(j3), Long.valueOf(j2), Long.valueOf(j4));
                    if (j3 < 0 || j2 < 0 || j4 < 0) {
                        Log.i("MicroMsg.ExtControlProviderOpenApi", "param err");
                        ac(23, 3, 2);
                        MatrixCursor ahx18 = a.ahx(2);
                        AppMethodBeat.o(24391);
                        return ahx18;
                    }
                    cSq();
                    ge geVar = new ge();
                    geVar.dJP.action = 2;
                    geVar.dJP.dJR = j3;
                    geVar.dJP.dJS = j2;
                    geVar.dJP.bqc = j4;
                    if (!EventCenter.instance.publish(geVar) || !geVar.dJQ.dJT) {
                        ac(23, 4, 8);
                        MatrixCursor ahx19 = a.ahx(8);
                        AppMethodBeat.o(24391);
                        return ahx19;
                    }
                    ac(22, 0, geVar.dJQ.dJU);
                    MatrixCursor ahx20 = a.ahx(geVar.dJQ.dJU);
                    AppMethodBeat.o(24391);
                    return ahx20;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_CREATOR:
                    Log.i("MicroMsg.ExtControlProviderOpenApi", "getSportConfig start");
                    cSq();
                    ge geVar2 = new ge();
                    geVar2.dJP.action = 3;
                    if (!EventCenter.instance.publish(geVar2) || !geVar2.dJQ.dJT) {
                        ac(23, 4, 8);
                        MatrixCursor ahx21 = a.ahx(8);
                        AppMethodBeat.o(24391);
                        return ahx21;
                    }
                    String str9 = geVar2.dJQ.config;
                    MatrixCursor matrixCursor2 = new MatrixCursor(sMH);
                    matrixCursor2.addRow(new Object[]{Integer.valueOf(geVar2.dJQ.dJU), Util.nullAsNil(str9)});
                    ac(22, 0, geVar2.dJQ.dJU);
                    Log.i("MicroMsg.ExtControlProviderOpenApi", "return  code =%s ", Integer.valueOf(geVar2.dJQ.dJU));
                    AppMethodBeat.o(24391);
                    return matrixCursor2;
                case 42:
                    Intent intent2 = new Intent();
                    intent2.addFlags(131072);
                    intent2.putExtra("key_from_scene", 4);
                    if (strArr2 == null || strArr2.length <= 0 || strArr2[0].length() <= 0) {
                        Log.i("MicroMsg.ExtControlProviderOpenApi", "openOffline appid:%s", str4);
                    } else {
                        Log.i("MicroMsg.ExtControlProviderOpenApi", "openOffline business_attach:%s,appid:%s", strArr2[0], str4);
                        intent2.putExtra("key_business_attach", strArr2[0]);
                    }
                    intent2.putExtra("key_appid", str4);
                    c.b(this.context, "offline", ".ui.WalletOfflineEntranceUI", intent2);
                    h.INSTANCE.a(12097, 9, 0, Long.valueOf(System.currentTimeMillis()));
                    ac(24, 0, 1);
                    MatrixCursor ahx22 = a.ahx(1);
                    AppMethodBeat.o(24391);
                    return ahx22;
                case 46:
                    Log.d("MicroMsg.ExtControlProviderOpenApi", "openClean appid:%s", str4);
                    bg.aVF();
                    if (!com.tencent.mm.model.c.isSDCardAvailable()) {
                        ac(27, 5, 4);
                        MatrixCursor ahx23 = a.ahx(4101);
                        AppMethodBeat.o(24391);
                        return ahx23;
                    }
                    Intent intent3 = new Intent();
                    intent3.putExtra("key_from_openapi", true);
                    intent3.putExtra("key_openapi_appid", str4);
                    c.b(this.context, "clean", ".ui.CleanUI", intent3);
                    ac(26, 0, 1);
                    MatrixCursor ahx24 = a.ahx(1);
                    AppMethodBeat.o(24391);
                    return ahx24;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                    e.cSE().mContext = this.context;
                    if (strArr2 == null || strArr2.length <= 0) {
                        Log.w("MicroMsg.ExtControlProviderOpenApi", "hy: invalid arg length!");
                        MatrixCursor ahx25 = a.ahx(4201);
                        AppMethodBeat.o(24391);
                        return ahx25;
                    }
                    int i4 = Util.getInt(strArr2[0], -1);
                    if (i4 < 0 || !(i4 == 0 || i4 == 1 || i4 == 2)) {
                        Log.w("MicroMsg.ExtControlProviderOpenApi", "hy: invalid command!");
                        ac(32, 3, 2);
                        MatrixCursor ahx26 = a.ahx(4201);
                        AppMethodBeat.o(24391);
                        return ahx26;
                    }
                    String str10 = null;
                    if (i4 != 0 && i4 != 1) {
                        str3 = null;
                    } else if (strArr2.length < 2) {
                        Log.w("MicroMsg.ExtControlProviderOpenApi", "hy: invalid arg length when check or open!");
                        MatrixCursor ahx27 = a.ahx(4205);
                        AppMethodBeat.o(24391);
                        return ahx27;
                    } else {
                        String str11 = strArr2[1];
                        if (i4 != 1) {
                            str3 = str11;
                        } else if (strArr2.length < 3) {
                            Log.w("MicroMsg.ExtControlProviderOpenApi", "hy: not providing md5!");
                            MatrixCursor ahx28 = a.ahx(4208);
                            AppMethodBeat.o(24391);
                            return ahx28;
                        } else {
                            str10 = strArr2[2];
                            str3 = str11;
                        }
                    }
                    Log.i("MicroMsg.ExtControlProviderOpenApi", "hy: cmdid: %d, yuvHandle: %s", Integer.valueOf(i4), str3);
                    switch (i4) {
                        case 0:
                            e cSE = e.cSE();
                            if (Util.isNullOrNil(str3)) {
                                Log.w("MicroMsg.ExtQrCodeHandler", "hy: null handle in doHandleCheckQrCode");
                                e.Z(null, -1, 4205);
                                MatrixCursor ahx29 = a.ahx(4205);
                                AppMethodBeat.o(24391);
                                return ahx29;
                            }
                            e.a art = com.tencent.mm.plugin.ext.d.c.art(str3);
                            if (art == null || Util.isNullOrNil(art.url)) {
                                d.b bc = e.bc(str3, false);
                                if (bc == null) {
                                    Log.w("MicroMsg.ExtQrCodeHandler", "hy: not retrieved yuv data in doHandleCheckQrCode");
                                    e.Z(null, -1, 4206);
                                    MatrixCursor ahx30 = a.ahx(4206);
                                    AppMethodBeat.o(24391);
                                    return ahx30;
                                }
                                e.a a2 = cSE.a(bc);
                                if (a2 == null || Util.isNullOrNil(a2.url)) {
                                    Log.w("MicroMsg.ExtQrCodeHandler", "hy: not resolved model");
                                    MatrixCursor ahx31 = a.ahx(4203);
                                    AppMethodBeat.o(24391);
                                    return ahx31;
                                }
                                aVar2 = a2;
                            } else {
                                Log.i("MicroMsg.ExtQrCodeHandler", "hy: handled previously. yuvhandle: %s, url: %s. direct return", str3, art);
                                aVar2 = art;
                            }
                            if (aVar2.type != 19) {
                                Log.i("MicroMsg.ExtQrCodeHandler", "hy: subapp code. can open");
                                MatrixCursor ahx32 = a.ahx(1);
                                AppMethodBeat.o(24391);
                                return ahx32;
                            } else if (com.tencent.mm.plugin.ext.d.c.arv(aVar2.url)) {
                                Log.i("MicroMsg.ExtQrCodeHandler", "hy: fastjudge wechat cannot open: %s", aVar2.url.toUpperCase());
                                e.Z(aVar2.url, aVar2.type, 4207);
                                MatrixCursor bdj = a.bdj(aVar2.url);
                                AppMethodBeat.o(24391);
                                return bdj;
                            } else if (com.tencent.mm.plugin.ext.d.c.aru(aVar2.url)) {
                                Log.i("MicroMsg.ExtQrCodeHandler", "hy: wechat can open: %s", aVar2.url);
                                e.Z(aVar2.url, aVar2.type, 1);
                                MatrixCursor ahx33 = a.ahx(1);
                                AppMethodBeat.o(24391);
                                return ahx33;
                            } else {
                                long currentTicks = Util.currentTicks();
                                b.EnumC1032b arw = com.tencent.mm.plugin.ext.d.c.arw(aVar2.url);
                                Log.i("MicroMsg.ExtQrCodeHandler", "hy: resolve config: %s, using: %d ms", arw.toString(), Long.valueOf(Util.ticksToNow(currentTicks)));
                                if (arw == b.EnumC1032b.WHITE) {
                                    com.tencent.mm.plugin.ext.d.c.arr(aVar2.url);
                                    e.Z(aVar2.url, aVar2.type, 1);
                                    MatrixCursor ahx34 = a.ahx(1);
                                    AppMethodBeat.o(24391);
                                    return ahx34;
                                }
                                if (arw != b.EnumC1032b.BLACK) {
                                    String str12 = aVar2.url;
                                    int i5 = aVar2.type;
                                    int i6 = aVar2.sOh;
                                    Log.i("MicroMsg.ExtQrCodeHandler", "hy: start remote judge url: %s", str12);
                                    long currentTimeMillis = System.currentTimeMillis();
                                    Boolean bool = (Boolean) 
                                    /*  JADX ERROR: Method code generation error
                                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0841: CHECK_CAST (r2v114 'bool' java.lang.Boolean) = (java.lang.Boolean) (wrap: java.lang.Object : 0x083d: INVOKE  (r2v113 java.lang.Object) = 
                                          (wrap: com.tencent.mm.plugin.ext.d.e$2 : 0x0836: CONSTRUCTOR  (r2v112 com.tencent.mm.plugin.ext.d.e$2) = 
                                          (r3v64 'cSE' com.tencent.mm.plugin.ext.d.e)
                                          (wrap: java.lang.Boolean : 0x0834: SGET  (r4v43 java.lang.Boolean) =  java.lang.Boolean.TRUE java.lang.Boolean)
                                          (r5v7 'str12' java.lang.String)
                                          (r6v15 'i5' int)
                                          (r7v8 'i6' int)
                                         call: com.tencent.mm.plugin.ext.d.e.2.<init>(com.tencent.mm.plugin.ext.d.e, java.lang.Boolean, java.lang.String, int, int):void type: CONSTRUCTOR)
                                          (wrap: com.tencent.mm.sdk.platformtools.MMHandler : 0x0839: INVOKE  (r3v75 com.tencent.mm.sdk.platformtools.MMHandler) =  type: STATIC call: com.tencent.mm.plugin.ext.d.e.cSG():com.tencent.mm.sdk.platformtools.MMHandler)
                                         type: VIRTUAL call: com.tencent.mm.plugin.ext.d.e.2.exec(com.tencent.mm.sdk.platformtools.MMHandler):java.lang.Object) in method: com.tencent.mm.plugin.ext.openapi.provider.ExtControlProviderOpenApi.query(android.net.Uri, java.lang.String[], java.lang.String, java.lang.String[], java.lang.String):android.database.Cursor, file: classes5.dex
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:157)
                                        	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:176)
                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:153)
                                        	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:176)
                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:153)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                        	at jadx.core.codegen.RegionGen.makeSwitch(RegionGen.java:274)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                        	at jadx.core.codegen.RegionGen.makeSwitch(RegionGen.java:274)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:157)
                                        	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:176)
                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:153)
                                        	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:176)
                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:153)
                                        	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:176)
                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:153)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                        	at java.util.ArrayList.forEach(ArrayList.java:1259)
                                        	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                        	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x083d: INVOKE  (r2v113 java.lang.Object) = 
                                          (wrap: com.tencent.mm.plugin.ext.d.e$2 : 0x0836: CONSTRUCTOR  (r2v112 com.tencent.mm.plugin.ext.d.e$2) = 
                                          (r3v64 'cSE' com.tencent.mm.plugin.ext.d.e)
                                          (wrap: java.lang.Boolean : 0x0834: SGET  (r4v43 java.lang.Boolean) =  java.lang.Boolean.TRUE java.lang.Boolean)
                                          (r5v7 'str12' java.lang.String)
                                          (r6v15 'i5' int)
                                          (r7v8 'i6' int)
                                         call: com.tencent.mm.plugin.ext.d.e.2.<init>(com.tencent.mm.plugin.ext.d.e, java.lang.Boolean, java.lang.String, int, int):void type: CONSTRUCTOR)
                                          (wrap: com.tencent.mm.sdk.platformtools.MMHandler : 0x0839: INVOKE  (r3v75 com.tencent.mm.sdk.platformtools.MMHandler) =  type: STATIC call: com.tencent.mm.plugin.ext.d.e.cSG():com.tencent.mm.sdk.platformtools.MMHandler)
                                         type: VIRTUAL call: com.tencent.mm.plugin.ext.d.e.2.exec(com.tencent.mm.sdk.platformtools.MMHandler):java.lang.Object in method: com.tencent.mm.plugin.ext.openapi.provider.ExtControlProviderOpenApi.query(android.net.Uri, java.lang.String[], java.lang.String, java.lang.String[], java.lang.String):android.database.Cursor, file: classes5.dex
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:290)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                        	... 69 more
                                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0836: CONSTRUCTOR  (r2v112 com.tencent.mm.plugin.ext.d.e$2) = 
                                          (r3v64 'cSE' com.tencent.mm.plugin.ext.d.e)
                                          (wrap: java.lang.Boolean : 0x0834: SGET  (r4v43 java.lang.Boolean) =  java.lang.Boolean.TRUE java.lang.Boolean)
                                          (r5v7 'str12' java.lang.String)
                                          (r6v15 'i5' int)
                                          (r7v8 'i6' int)
                                         call: com.tencent.mm.plugin.ext.d.e.2.<init>(com.tencent.mm.plugin.ext.d.e, java.lang.Boolean, java.lang.String, int, int):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.ext.openapi.provider.ExtControlProviderOpenApi.query(android.net.Uri, java.lang.String[], java.lang.String, java.lang.String[], java.lang.String):android.database.Cursor, file: classes5.dex
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                                        	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:87)
                                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:715)
                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                        	... 73 more
                                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.ext.d.e, state: GENERATED_AND_UNLOADED
                                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                        	... 79 more
                                        */
                                    /*
                                    // Method dump skipped, instructions count: 2938
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.ext.openapi.provider.ExtControlProviderOpenApi.query(android.net.Uri, java.lang.String[], java.lang.String, java.lang.String[], java.lang.String):android.database.Cursor");
                                }

                                private Cursor x(String[] strArr) {
                                    AppMethodBeat.i(24392);
                                    if (strArr == null || strArr.length == 0) {
                                        Log.w("MicroMsg.ExtControlProviderOpenApi", "hy: invalid arg length!");
                                        MatrixCursor ahx = a.ahx(2);
                                        AppMethodBeat.o(24392);
                                        return ahx;
                                    }
                                    try {
                                        int parseInt = Integer.parseInt(strArr[0]);
                                        if (1 == parseInt) {
                                            try {
                                                int parseInt2 = Integer.parseInt(strArr[1]);
                                                if (1 == parseInt2 || 2 == parseInt2 || parseInt2 == 0) {
                                                    ((m) g.af(m.class)).a(this.context, parseInt2, this.appId);
                                                } else {
                                                    MatrixCursor ahx2 = a.ahx(2);
                                                    AppMethodBeat.o(24392);
                                                    return ahx2;
                                                }
                                            } catch (NumberFormatException e2) {
                                                Log.printErrStackTrace("MicroMsg.ExtControlProviderOpenApi", e2, "", new Object[0]);
                                                MatrixCursor ahx3 = a.ahx(2);
                                                AppMethodBeat.o(24392);
                                                return ahx3;
                                            }
                                        } else if (2 == parseInt) {
                                            ((m) g.af(m.class)).af(this.context, this.appId);
                                        } else {
                                            MatrixCursor ahx4 = a.ahx(2);
                                            AppMethodBeat.o(24392);
                                            return ahx4;
                                        }
                                        MatrixCursor ahx5 = a.ahx(1);
                                        AppMethodBeat.o(24392);
                                        return ahx5;
                                    } catch (NumberFormatException e3) {
                                        Log.printErrStackTrace("MicroMsg.ExtControlProviderOpenApi", e3, "", new Object[0]);
                                        MatrixCursor ahx6 = a.ahx(2);
                                        AppMethodBeat.o(24392);
                                        return ahx6;
                                    }
                                }

                                private Cursor a(String[] strArr, boolean z) {
                                    String str;
                                    Bundle extras;
                                    AppMethodBeat.i(24393);
                                    if (strArr == null || strArr.length < 2) {
                                        Log.w("MicroMsg.ExtControlProviderOpenApi", "hy: invalid arg length!");
                                        MatrixCursor ahx = a.ahx(2);
                                        AppMethodBeat.o(24393);
                                        return ahx;
                                    }
                                    MatrixCursor matrixCursor = z ? new MatrixCursor(sMM) : new MatrixCursor(sML);
                                    try {
                                        int parseInt = Integer.parseInt(strArr[0]);
                                        int parseInt2 = Integer.parseInt(strArr[1]);
                                        List<LocalUsageInfo> list = null;
                                        if (1 == parseInt) {
                                            if (z) {
                                                list = ((ah) g.af(ah.class)).dP(parseInt2, 0);
                                            } else {
                                                list = ((ah) g.af(ah.class)).vW(parseInt2);
                                            }
                                        } else if (2 == parseInt) {
                                            if (z) {
                                                list = ((ag) g.af(ag.class)).a(parseInt2, null, 0);
                                            } else {
                                                list = ((ag) g.af(ag.class)).a(parseInt2, null);
                                            }
                                        }
                                        for (LocalUsageInfo localUsageInfo : com.tencent.luggage.h.b.G(list)) {
                                            WxaAttributes Xl = ((q) g.af(q.class)).Xl(localUsageInfo.appId);
                                            if (Xl != null) {
                                                if (!z) {
                                                    String[] strArr2 = {Xl.field_roundedSquareIconURL, Xl.field_brandIconURL, Xl.field_bigHeadURL};
                                                    String packageName = MMApplicationContext.getPackageName();
                                                    int i2 = localUsageInfo.iOo;
                                                    String str2 = Xl.field_username;
                                                    String str3 = Xl.field_nickname;
                                                    String str4 = Xl.field_appId;
                                                    g.aAf();
                                                    Intent a2 = ((com.tencent.mm.modelappbrand.b.a) g.af(com.tencent.mm.modelappbrand.b.a.class)).a(packageName, i2, str2, str3, strArr2, str4, com.tencent.mm.kernel.a.getUin(), 3);
                                                    if (!(a2 == null || (extras = a2.getExtras()) == null)) {
                                                        HashMap hashMap = new HashMap();
                                                        for (String str5 : extras.keySet()) {
                                                            hashMap.put(str5, extras.get(str5));
                                                        }
                                                        Object[] objArr = new Object[11];
                                                        objArr[0] = localUsageInfo.username;
                                                        objArr[1] = localUsageInfo.appId;
                                                        objArr[2] = Integer.valueOf(localUsageInfo.iOo);
                                                        objArr[3] = localUsageInfo.nickname;
                                                        objArr[4] = localUsageInfo.cyB;
                                                        objArr[5] = Xl.field_brandIconURL;
                                                        objArr[6] = Integer.valueOf(localUsageInfo.kWa ? 1 : 0);
                                                        objArr[7] = Long.valueOf(localUsageInfo.czf);
                                                        objArr[8] = a2.getPackage();
                                                        objArr[9] = a2.getAction();
                                                        objArr[10] = new i(hashMap).toString();
                                                        matrixCursor.addRow(objArr);
                                                    }
                                                } else {
                                                    StringBuilder append = new StringBuilder().append(localUsageInfo.username).append(",");
                                                    g.aAf();
                                                    byte[] bytes = append.append(com.tencent.mm.kernel.a.getUin()).append(",").append(this.sMZ).toString().getBytes();
                                                    try {
                                                        MessageDigest instance = MessageDigest.getInstance(XWalkAppVersion.XWALK_APK_HASH_ALGORITHM);
                                                        instance.update(bytes);
                                                        str = String.format("%064x", new BigInteger(1, instance.digest()));
                                                    } catch (NoSuchAlgorithmException e2) {
                                                        str = "";
                                                    }
                                                    com.tencent.mm.plugin.ext.a.a cSj = com.tencent.mm.plugin.ext.b.cSj();
                                                    String str6 = localUsageInfo.username;
                                                    g.aAf();
                                                    int uin = com.tencent.mm.kernel.a.getUin();
                                                    String str7 = this.sMZ;
                                                    p.h(str, "token");
                                                    p.h(str6, "userName");
                                                    p.h(str7, "appid");
                                                    com.tencent.mm.kernel.e aAh = g.aAh();
                                                    p.g(aAh, "MMKernel.storage()");
                                                    Cursor query = aAh.hqK.query(cSj.getTableName(), null, null, null, null, null, null);
                                                    StringBuilder sb = new StringBuilder();
                                                    p.g(query, SearchIntents.EXTRA_QUERY);
                                                    sb.append(query.getColumnNames());
                                                    com.tencent.e.f.h.hkS();
                                                    com.tencent.mm.plugin.ext.a.b bVar = new com.tencent.mm.plugin.ext.a.b();
                                                    bVar.field_token = str;
                                                    bVar.field_username = str6;
                                                    bVar.field_uin = uin;
                                                    bVar.field_appid = str7;
                                                    if (cSj.arm(str) != null) {
                                                        cSj.update(bVar, new String[0]);
                                                    } else {
                                                        cSj.insert(bVar);
                                                    }
                                                    matrixCursor.addRow(new Object[]{str, localUsageInfo.nickname, Xl.field_brandIconURL});
                                                }
                                            }
                                        }
                                        h.INSTANCE.a(18601, this.sMZ, Integer.valueOf(parseInt), Integer.valueOf(matrixCursor.getCount()));
                                        AppMethodBeat.o(24393);
                                        return matrixCursor;
                                    } catch (NumberFormatException e3) {
                                        Log.printErrStackTrace("MicroMsg.ExtControlProviderOpenApi", e3, "", new Object[0]);
                                        MatrixCursor ahx2 = a.ahx(2);
                                        AppMethodBeat.o(24393);
                                        return ahx2;
                                    }
                                }

                                @Override // com.tencent.mm.plugin.ext.provider.ExtContentProviderBase
                                public Uri insert(Uri uri, ContentValues contentValues) {
                                    return null;
                                }

                                @Override // com.tencent.mm.plugin.ext.provider.ExtContentProviderBase
                                public int delete(Uri uri, String str, String[] strArr) {
                                    return 0;
                                }

                                @Override // com.tencent.mm.plugin.ext.provider.ExtContentProviderBase
                                public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
                                    return 0;
                                }

                                private Cursor m(String str, String str2, String str3, String str4) {
                                    boolean z;
                                    AppMethodBeat.i(24394);
                                    Log.i("MicroMsg.ExtControlProviderOpenApi", "registerMsgReceiver, op = %s", str);
                                    if (this.context == null) {
                                        Log.e("MicroMsg.ExtControlProviderOpenApi", "context == null return code = 2001");
                                        fP(4, 2001);
                                        MatrixCursor ahx = a.ahx(2001);
                                        AppMethodBeat.o(24394);
                                        return ahx;
                                    } else if (Util.isNullOrNil(str)) {
                                        Log.e("MicroMsg.ExtControlProviderOpenApi", "wrong args, op is null return code = 2002");
                                        fP(3, 2002);
                                        MatrixCursor ahx2 = a.ahx(2002);
                                        AppMethodBeat.o(24394);
                                        return ahx2;
                                    } else {
                                        int i2 = -1;
                                        try {
                                            i2 = Util.getInt(str, -1);
                                        } catch (Exception e2) {
                                        }
                                        if (i2 == 1) {
                                            Cursor ad = ad(str2, str3, str4);
                                            AppMethodBeat.o(24394);
                                            return ad;
                                        } else if (i2 == 2) {
                                            Log.d("MicroMsg.ExtControlProviderOpenApi", "doUnRegisterMsgListener");
                                            if (com.tencent.mm.plugin.ext.b.cSh().bkL(this.sMZ) == null) {
                                                Log.w("MicroMsg.ExtControlProviderOpenApi", "This app never been registered, appId = %s, pkg = %s", this.sMZ, cSt());
                                                MatrixCursor ahx3 = a.ahx(2007);
                                                AppMethodBeat.o(24394);
                                                return ahx3;
                                            }
                                            com.tencent.mm.storage.ch cSh = com.tencent.mm.plugin.ext.b.cSh();
                                            String str5 = this.sMZ;
                                            if (str5 == null || str5.length() <= 0) {
                                                z = false;
                                            } else {
                                                if (cSh.db.delete("OpenMsgListener", "appId=?", new String[]{Util.escapeSqlValue(str5)}) <= 0) {
                                                    z = false;
                                                } else {
                                                    z = true;
                                                }
                                            }
                                            Log.i("MicroMsg.ExtControlProviderOpenApi", "doUnRegisterMsgListener ret = %s, appId = %s, pkg = %s", Boolean.valueOf(z), this.sMZ, cSt());
                                            if (!z) {
                                                MatrixCursor ahx4 = a.ahx(2008);
                                                AppMethodBeat.o(24394);
                                                return ahx4;
                                            }
                                            ac(0, 0, 1);
                                            MatrixCursor ahx5 = a.ahx(1);
                                            AppMethodBeat.o(24394);
                                            return ahx5;
                                        } else {
                                            Log.e("MicroMsg.ExtControlProviderOpenApi", "wrong args, no such op, %s", Integer.valueOf(i2));
                                            fP(3, 2003);
                                            MatrixCursor ahx6 = a.ahx(2003);
                                            AppMethodBeat.o(24394);
                                            return ahx6;
                                        }
                                    }
                                }

                                /* JADX WARNING: Removed duplicated region for block: B:29:0x0125  */
                                /* Code decompiled incorrectly, please refer to instructions dump. */
                                private android.database.Cursor ad(java.lang.String r11, java.lang.String r12, java.lang.String r13) {
                                    /*
                                    // Method dump skipped, instructions count: 430
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.ext.openapi.provider.ExtControlProviderOpenApi.ad(java.lang.String, java.lang.String, java.lang.String):android.database.Cursor");
                                }

                                private Cursor y(String[] strArr) {
                                    String str;
                                    AppMethodBeat.i(24396);
                                    Log.i("MicroMsg.ExtControlProviderOpenApi", "getUserAvatarByOpenId");
                                    if (strArr == null || strArr.length <= 0) {
                                        Log.e("MicroMsg.ExtControlProviderOpenApi", "wrong args");
                                        fP(3, 3001);
                                        MatrixCursor ahx = a.ahx(3001);
                                        AppMethodBeat.o(24396);
                                        return ahx;
                                    }
                                    MatrixCursor matrixCursor = new MatrixCursor(sMI);
                                    int i2 = 0;
                                    while (i2 < strArr.length && i2 < 5) {
                                        try {
                                            if (!Util.isNullOrNil(strArr[i2])) {
                                                cr bkX = com.tencent.mm.plugin.ext.b.cSi().bkX(strArr[i2]);
                                                if (bkX == null || Util.isNullOrNil(bkX.field_openId) || Util.isNullOrNil(bkX.field_username)) {
                                                    Log.e("MicroMsg.ExtControlProviderOpenApi", "openidInApp is null");
                                                } else {
                                                    bg.aVF();
                                                    as Kn = com.tencent.mm.model.c.aSN().Kn(bkX.field_username);
                                                    if (Kn == null || Kn.field_username == null || Kn.field_username.length() <= 0) {
                                                        Log.e("MicroMsg.ExtControlProviderOpenApi", "contact is null");
                                                    } else {
                                                        com.tencent.mm.aj.p.aYn();
                                                        String M = com.tencent.mm.aj.e.M(Kn.field_username, false);
                                                        if (Util.isNullOrNil(M)) {
                                                            Log.w("MicroMsg.ExtControlProviderOpenApi", "hy: get avatar sfs path is null or nil");
                                                        } else {
                                                            if (M.startsWith(g.aAh().cachePath)) {
                                                                str = g.aAh().hqG + M.substring(g.aAh().cachePath.length());
                                                                s.boN(s.boZ(str));
                                                                s.nw(M, str);
                                                            } else {
                                                                str = M;
                                                            }
                                                            e.b.Ms(str);
                                                            matrixCursor.addRow(new Object[]{strArr[i2], str});
                                                        }
                                                    }
                                                }
                                            }
                                            i2++;
                                        } catch (Exception e2) {
                                            Log.e("MicroMsg.ExtControlProviderOpenApi", "Exception occur, %s", e2.getMessage());
                                            ac(7, 4, 12);
                                            matrixCursor.close();
                                            MatrixCursor ahx2 = a.ahx(12);
                                            AppMethodBeat.o(24396);
                                            return ahx2;
                                        }
                                    }
                                    ac(6, 0, 1);
                                    AppMethodBeat.o(24396);
                                    return matrixCursor;
                                }

                                private Cursor z(String[] strArr) {
                                    String bD;
                                    AppMethodBeat.i(24397);
                                    Log.i("MicroMsg.ExtControlProviderOpenApi", "decodeVoice");
                                    if (strArr == null || strArr.length <= 0 || strArr[0].length() <= 0) {
                                        Log.e("MicroMsg.ExtControlProviderOpenApi", "decodeVoice wrong args");
                                        fP(3, 3101);
                                        MatrixCursor ahx = a.ahx(3101);
                                        AppMethodBeat.o(24397);
                                        return ahx;
                                    }
                                    MatrixCursor matrixCursor = null;
                                    int i2 = 0;
                                    while (i2 < 5 && i2 < strArr.length) {
                                        String str = strArr[i2];
                                        try {
                                            if (!com.tencent.mm.modelvoice.q.i(str, 0, true)) {
                                                Log.w("MicroMsg.ExtControlProviderOpenApi", "wrong args : %s", strArr[i2]);
                                            } else {
                                                if (matrixCursor == null) {
                                                    matrixCursor = new MatrixCursor(sMJ);
                                                }
                                                k kVar = new k();
                                                String str2 = com.tencent.mm.plugin.ext.b.cSl() + FilePathGenerator.ANDROID_DIR_SEP + MD5Util.getMD5String(str);
                                                Log.i("MicroMsg.ExtControlProviderOpenApi", "summerpcm pcmPath[%s]", str2);
                                                if (s.boW(str2) > 0) {
                                                    Log.d("MicroMsg.ExtControlProviderOpenApi", "pcm already exist");
                                                    bD = str2;
                                                } else {
                                                    bD = kVar.bD(str, str2);
                                                }
                                                if (s.boW(str2) == 0) {
                                                    bD = kVar.bD(str, str2);
                                                }
                                                if (Util.isNullOrNil(bD)) {
                                                    Log.w("MicroMsg.ExtControlProviderOpenApi", "wrong args targetFilePath is null");
                                                } else {
                                                    Log.d("MicroMsg.ExtControlProviderOpenApi", "decode to pcm success %d", Integer.valueOf(i2));
                                                    matrixCursor.addRow(new Object[]{1, Integer.valueOf(kVar.mSampleRate), Integer.valueOf(kVar.dzz), 2, bD});
                                                }
                                            }
                                        } catch (Exception e2) {
                                            Log.e("MicroMsg.ExtControlProviderOpenApi", "Exception in decodeVoice, %s", e2.getMessage());
                                        }
                                        i2++;
                                    }
                                    if (matrixCursor != null) {
                                        ac(8, 0, 1);
                                        AppMethodBeat.o(24397);
                                        return matrixCursor;
                                    }
                                    ac(9, 3, 4);
                                    MatrixCursor ahx2 = a.ahx(4);
                                    AppMethodBeat.o(24397);
                                    return ahx2;
                                }

                                private void cSq() {
                                    AppMethodBeat.i(24398);
                                    String str = (String) com.tencent.mm.plugin.ext.b.cSg().get(ar.a.USERINFO_EXT_SPORT_PKGNAME_STRING, (Object) null);
                                    String cSt = cSt();
                                    Log.i("MicroMsg.ExtControlProviderOpenApi", "setSportBroadPkg: pkgNames: %s, pkg: %s", str, cSt);
                                    if (str != null) {
                                        if (!com.tencent.mm.compatible.loader.a.contains(str.split(";"), cSt)) {
                                            com.tencent.mm.plugin.ext.b.cSg().set(ar.a.USERINFO_EXT_SPORT_PKGNAME_STRING, str + ";" + cSt());
                                        }
                                        AppMethodBeat.o(24398);
                                        return;
                                    }
                                    com.tencent.mm.plugin.ext.b.cSg().set(ar.a.USERINFO_EXT_SPORT_PKGNAME_STRING, cSt());
                                    AppMethodBeat.o(24398);
                                }
                            }
