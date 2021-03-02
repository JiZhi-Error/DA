package com.tencent.mm.plugin.base.stub;

import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Binder;
import android.os.Looper;
import android.os.Process;
import android.support.constraint.ConstraintLayout;
import com.facebook.appevents.AppEventsConstants;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.WorkerProfile;
import com.tencent.mm.g.a.aak;
import com.tencent.mm.g.a.bw;
import com.tencent.mm.g.a.cq;
import com.tencent.mm.g.a.fr;
import com.tencent.mm.g.a.fs;
import com.tencent.mm.g.a.fy;
import com.tencent.mm.g.a.km;
import com.tencent.mm.g.a.ta;
import com.tencent.mm.g.a.tb;
import com.tencent.mm.g.a.tc;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bu;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelbiz.WXLaunchWxaRedirectingPage;
import com.tencent.mm.plugin.account.ui.LoginUI;
import com.tencent.mm.plugin.appbrand.jsapi.bv;
import com.tencent.mm.plugin.appbrand.jsapi.fakenative.d;
import com.tencent.mm.plugin.appbrand.jsapi.pay.n;
import com.tencent.mm.plugin.appbrand.jsapi.wifi.a;
import com.tencent.mm.plugin.appbrand.jsapi.wifi.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.g;
import com.tencent.mm.pluginsdk.model.app.aq;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.protocal.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.SyncTask;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatAuthorities;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.PROVIDERCHECK})
public class WXCommProvider extends ContentProvider {
    private static final String AUTHORITY = WeChatAuthorities.AUTHORITIES_SDK_COMM_PROVIDER();
    public static final String PREF_NAME = (MMApplicationContext.getPackageName() + "_comm_preferences");
    private static final Object lock = new Object();
    private static final String[] pel = {AssistantStore.DownloadInfos.DownloadInfoColumns.PACKAGENAME, "data"};
    private static final UriMatcher pen = new UriMatcher(-1);
    private static volatile boolean peo = false;
    protected static boolean pep = false;
    private MMHandler handler;
    protected MatrixCursor pem = new MatrixCursor(new String[0]);
    private SharedPreferences sp;

    public WXCommProvider() {
        AppMethodBeat.i(22253);
        AppMethodBeat.o(22253);
    }

    static {
        AppMethodBeat.i(22261);
        pen.addURI(AUTHORITY, "pref", 1);
        pen.addURI(AUTHORITY, "openQRCodeScan", 18);
        pen.addURI(AUTHORITY, "batchAddShortcut", 19);
        pen.addURI(AUTHORITY, "getUnreadCount", 20);
        pen.addURI(AUTHORITY, "jumpToBizProfile", 21);
        pen.addURI(AUTHORITY, "jumpToBizTempSession", 27);
        pen.addURI(AUTHORITY, "registerMsgListener", 22);
        pen.addURI(AUTHORITY, "getAvatar", 23);
        pen.addURI(AUTHORITY, "regWatchAppId", 24);
        pen.addURI(AUTHORITY, "decodeVoice", 25);
        pen.addURI(AUTHORITY, "addCardToWX", 26);
        pen.addURI(AUTHORITY, "unReadMsgs", 9);
        pen.addURI(AUTHORITY, "to_chatting", 3);
        pen.addURI(AUTHORITY, "setReaded", 13);
        pen.addURI(AUTHORITY, "voiceControl", 29);
        pen.addURI(AUTHORITY, "openRankList", 28);
        pen.addURI(AUTHORITY, "openWebview", 30);
        pen.addURI(AUTHORITY, "openBusiLuckyMoney", 31);
        pen.addURI(AUTHORITY, "createChatroom", 32);
        pen.addURI(AUTHORITY, "joinChatroom", 33);
        pen.addURI(AUTHORITY, "sendSight", 34);
        pen.addURI(AUTHORITY, "redirectToChattingByPhoneNumber", 35);
        pen.addURI(AUTHORITY, "redirectToWechatOutByPhoneNumber", 36);
        pen.addURI(AUTHORITY, c.NAME, 37);
        pen.addURI(AUTHORITY, a.NAME, 38);
        pen.addURI(AUTHORITY, "chooseCardFromWX", 39);
        pen.addURI(AUTHORITY, "openOfflinePay", 42);
        pen.addURI(AUTHORITY, "setWechatSportStep", 40);
        pen.addURI(AUTHORITY, "getWechatSportConfig", 41);
        pen.addURI(AUTHORITY, "handleScanResult", 44);
        pen.addURI(AUTHORITY, "openTypeWebview", 45);
        pen.addURI(AUTHORITY, "openCleanUI", 46);
        pen.addURI(AUTHORITY, "launchWXMiniprogram", 47);
        pen.addURI(AUTHORITY, "preloadWXMiniprogram", 57);
        pen.addURI(AUTHORITY, "preloadWXMiniprogramEnvironment", 62);
        pen.addURI(AUTHORITY, d.NAME, 53);
        pen.addURI(AUTHORITY, "genTokenForOpenSdk", 43);
        pen.addURI(AUTHORITY, "qrcodeEvent", 48);
        pen.addURI(AUTHORITY, "jumpToOfflinePay", 49);
        pen.addURI(AUTHORITY, "openBusinessWebview", 50);
        pen.addURI(AUTHORITY, "getWxaInfo", 51);
        pen.addURI(AUTHORITY, "openWxaDesktopOrWxaMyFavorite", 52);
        pen.addURI(AUTHORITY, "openWxaListPage", 56);
        pen.addURI(AUTHORITY, "getSimpleWxaInfo", 54);
        pen.addURI(AUTHORITY, "launchWXMiniprogramWithToken", 55);
        pen.addURI(AUTHORITY, WXLaunchWxaRedirectingPage.URI_PATH, 58);
        pen.addURI(AUTHORITY, "checkSupportWxaOpenAPI", 59);
        pen.addURI(AUTHORITY, "getWCProbeWaid", 60);
        pen.addURI(AUTHORITY, "checkIfSupportWxaSDKFeature", 61);
        pen.addURI(AUTHORITY, "finderShareVideo", 63);
        pen.addURI(AUTHORITY, "finderOpenProfile", 64);
        pen.addURI(AUTHORITY, "finderOpenLive", 65);
        pen.addURI(AUTHORITY, "finderOpenFeed", 66);
        AppMethodBeat.o(22261);
    }

    public boolean onCreate() {
        AppMethodBeat.i(22254);
        Log.d("MicroMsg.WXCommProvider", "onCreate");
        this.handler = new MMHandler();
        Log.i("MicroMsg.WXCommProvider", "pid = " + Process.myPid() + ", tid : = " + Process.myTid());
        this.sp = getContext().getSharedPreferences(PREF_NAME, 0);
        getContext().registerReceiver(new BroadcastReceiver() {
            /* class com.tencent.mm.plugin.base.stub.WXCommProvider.AnonymousClass1 */

            public void onReceive(Context context, Intent intent) {
                aq aqVar;
                AppMethodBeat.i(22243);
                if (System.currentTimeMillis() - aq.JXw >= 600000) {
                    Log.e("MicroMsg.AppUtil", "hy: get comm model time expired");
                    aqVar = null;
                } else {
                    aqVar = aq.JXv;
                }
                if (aqVar != null) {
                    Log.i("MicroMsg.WXCommProvider", "hy: has wxcomm query request. start to continue requesting");
                    Cursor a2 = WXCommProvider.this.a(aqVar.uri, aqVar.projection, aqVar.selection, aqVar.selectionArgs, aqVar.JXt, aqVar.code, aqVar.JXu);
                    if (a2 != null) {
                        a2.close();
                    }
                    q.gmZ();
                }
                AppMethodBeat.o(22243);
            }
        }, new IntentFilter(ConstantsAPI.ACTION_REFRESH_WXAPP));
        if (this.sp != null) {
            AppMethodBeat.o(22254);
            return true;
        }
        AppMethodBeat.o(22254);
        return false;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        AppMethodBeat.i(22255);
        Log.i("MicroMsg.WXCommProvider", "uri:%s", uri);
        if (uri == null) {
            Log.e("MicroMsg.WXCommProvider", "query fail, uri is null return null");
            AppMethodBeat.o(22255);
            return null;
        }
        int match = pen.match(uri);
        if (WorkerProfile.Xg() == null || !WorkerProfile.Xg().dnm) {
            new MTimerHandler(Looper.getMainLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
                /* class com.tencent.mm.plugin.base.stub.WXCommProvider.AnonymousClass2 */

                @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                public final boolean onTimerExpired() {
                    AppMethodBeat.i(22244);
                    if (EventCenter.instance == null || !EventCenter.instance.hasListener(fr.class)) {
                        AppMethodBeat.o(22244);
                        return true;
                    }
                    synchronized (WXCommProvider.lock) {
                        try {
                            Log.i("MicroMsg.WXCommProvider", "The lock was released.");
                            boolean unused = WXCommProvider.peo = true;
                            WXCommProvider.lock.notifyAll();
                        } catch (Throwable th) {
                            AppMethodBeat.o(22244);
                            throw th;
                        }
                    }
                    AppMethodBeat.o(22244);
                    return false;
                }
            }, true).startTimer(50);
            try {
                synchronized (lock) {
                    try {
                        Log.i("MicroMsg.WXCommProvider", "Lock to wait for the first initialize of the Application.");
                        while (!peo) {
                            lock.wait();
                        }
                        peo = false;
                    } catch (Throwable th) {
                        AppMethodBeat.o(22255);
                        throw th;
                    }
                }
            } catch (InterruptedException e2) {
                Log.e("MicroMsg.WXCommProvider", "the lock may have some problem," + e2.getMessage());
                Log.printErrStackTrace("MicroMsg.WXCommProvider", e2, "", new Object[0]);
            }
        }
        String[] a2 = a(uri, strArr2);
        if (a2 == null || a2.length <= 0) {
            Log.e("MicroMsg.WXCommProvider", "CallingPackages is null return null");
            AppMethodBeat.o(22255);
            return null;
        }
        Cursor a3 = a(uri, strArr, str, strArr2, str2, match, a2);
        AppMethodBeat.o(22255);
        return a3;
    }

    public final Cursor a(final Uri uri, String[] strArr, String str, String[] strArr2, String str2, final int i2, final String[] strArr3) {
        AppMethodBeat.i(22256);
        Log.i("MicroMsg.WXCommProvider", "dealWithRealLogic:%d", Integer.valueOf(i2));
        switch (i2) {
            case 3:
            case 9:
            case 13:
            case 22:
            case 23:
            case 25:
            case 29:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 40:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_CREATOR:
            case 42:
            case 46:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
            case 51:
            case 52:
            case 54:
            case 56:
                long currentTimeMillis = System.currentTimeMillis();
                String nullAsNil = Util.nullAsNil(uri.getQueryParameter("appid"));
                if (ckf()) {
                    fy fyVar = new fy();
                    fyVar.dJy.dIT = i2;
                    fyVar.dJy.uri = uri;
                    fyVar.dJy.selectionArgs = strArr2;
                    fyVar.dJy.context = getContext();
                    fyVar.dJy.dBX = strArr3;
                    fyVar.dJy.appId = nullAsNil;
                    if (!EventCenter.instance.publish(fyVar)) {
                        Log.e("MicroMsg.WXCommProvider", "ExtCallEvent fail return code = 8");
                        MatrixCursor matrixCursor = new MatrixCursor(b.sMy);
                        matrixCursor.addRow(new Object[]{8});
                        AppMethodBeat.o(22256);
                        return matrixCursor;
                    }
                    Log.i("MicroMsg.WXCommProvider", "[extApiCost] total cost = %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    Cursor cursor = fyVar.dJz.dIU;
                    AppMethodBeat.o(22256);
                    return cursor;
                } else if ("1".equals(Util.nullAs(uri.getQueryParameter("autoLogin"), AppEventsConstants.EVENT_PARAM_VALUE_NO))) {
                    Log.i("MicroMsg.WXCommProvider", "hy: not login. try to login return code = 9");
                    aq.JXv = new aq(uri, strArr, str, strArr2, str2, i2, strArr3);
                    aq.JXw = System.currentTimeMillis();
                    Intent intent = new Intent(getContext(), LoginUI.class);
                    intent.addFlags(268435456);
                    Context context = getContext();
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/base/stub/WXCommProvider", "startToLoginWithQueryAction", "(Lcom/tencent/mm/pluginsdk/model/app/WxProviderQueryStubModel;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    context.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/base/stub/WXCommProvider", "startToLoginWithQueryAction", "(Lcom/tencent/mm/pluginsdk/model/app/WxProviderQueryStubModel;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    MatrixCursor matrixCursor2 = new MatrixCursor(b.sMy);
                    matrixCursor2.addRow(new Object[]{9});
                    AppMethodBeat.o(22256);
                    return matrixCursor2;
                } else {
                    Log.i("MicroMsg.WXCommProvider", "not login, appID = %s, apiID = %s return code =%s ", nullAsNil, Integer.valueOf(i2), 3);
                    h.INSTANCE.a(10505, Util.nullAsNil(strArr3[0]), nullAsNil, Integer.valueOf(i2), 1, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    MatrixCursor matrixCursor3 = new MatrixCursor(b.sMy);
                    matrixCursor3.addRow(new Object[]{3});
                    AppMethodBeat.o(22256);
                    return matrixCursor3;
                }
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 14:
            case 15:
            case 16:
            case 17:
            default:
                final MatrixCursor matrixCursor4 = new MatrixCursor(pel);
                Cursor cursor2 = (Cursor) new SyncTask<Cursor>() {
                    /* class com.tencent.mm.plugin.base.stub.WXCommProvider.AnonymousClass4 */

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // com.tencent.mm.sdk.platformtools.SyncTask
                    public final /* synthetic */ Cursor run() {
                        AppMethodBeat.i(22246);
                        Log.d("MicroMsg.WXCommProvider", "query, uri = %s, code = %d", uri.toString(), Integer.valueOf(i2));
                        if (i2 != 1) {
                            Log.e("MicroMsg.WXCommProvider", "query fail, invalid code = %d", Integer.valueOf(i2));
                            AppMethodBeat.o(22246);
                            return null;
                        }
                        String[] strArr = strArr3;
                        for (String str : strArr) {
                            matrixCursor4.addRow(new String[]{str, WXCommProvider.this.sp.getString(str, "")});
                        }
                        Log.d("MicroMsg.WXCommProvider", "query size = %d", Integer.valueOf(matrixCursor4.getCount()));
                        MatrixCursor matrixCursor = matrixCursor4;
                        AppMethodBeat.o(22246);
                        return matrixCursor;
                    }
                }.exec(this.handler);
                if (cursor2 == null) {
                    matrixCursor4.close();
                }
                AppMethodBeat.o(22256);
                return cursor2;
            case 18:
            case 19:
            case 20:
                if (!cke()) {
                    AppMethodBeat.o(22256);
                    return null;
                }
                fs fsVar = new fs();
                fsVar.dIR.dIT = i2;
                fsVar.dIR.uri = uri;
                fsVar.dIR.selectionArgs = strArr2;
                fsVar.dIR.context = getContext();
                fsVar.dIR.dBX = strArr3;
                if (!EventCenter.instance.publish(fsVar)) {
                    Log.e("MicroMsg.WXCommProvider", "ExtCallEvent fail");
                    AppMethodBeat.o(22256);
                    return null;
                }
                Cursor cursor3 = fsVar.dIS.dIU;
                AppMethodBeat.o(22256);
                return cursor3;
            case 21:
                fr frVar = new fr();
                frVar.dIP.op = 21;
                frVar.dIP.source = 1;
                frVar.dIP.selectionArgs = strArr2;
                frVar.dIP.context = getContext();
                frVar.dIP.dBX = strArr3;
                if (!EventCenter.instance.publish(frVar)) {
                    Log.e("MicroMsg.WXCommProvider", "ExtCallBizEvent fail");
                }
                AppMethodBeat.o(22256);
                return null;
            case 24:
                if (!cke()) {
                    MatrixCursor matrixCursor5 = this.pem;
                    AppMethodBeat.o(22256);
                    return matrixCursor5;
                }
                aak aak = new aak();
                aak.ehi.dIT = i2;
                aak.ehi.uri = uri;
                aak.ehi.context = getContext();
                int i3 = 0;
                while (true) {
                    if (i3 < strArr3.length) {
                        if (strArr3[i3] != null) {
                            aak.ehi.callingPackage = strArr3[i3];
                        } else {
                            i3++;
                        }
                    }
                }
                if (!EventCenter.instance.publish(aak)) {
                    Log.e("MicroMsg.WXCommProvider", "WatchAppIdRegEvent fail");
                    AppMethodBeat.o(22256);
                    return null;
                }
                Cursor cursor4 = aak.ehj.dIU;
                AppMethodBeat.o(22256);
                return cursor4;
            case 26:
                com.tencent.mm.g.a.h hVar = new com.tencent.mm.g.a.h();
                hVar.dBW.selectionArgs = strArr2;
                hVar.dBW.dBX = strArr3;
                hVar.dBW.context = getContext();
                if (!EventCenter.instance.publish(hVar)) {
                    Log.e("MicroMsg.WXCommProvider", "add card to wx fail");
                }
                AppMethodBeat.o(22256);
                return null;
            case 27:
                if (strArr2 == null || strArr2.length < 2) {
                    Log.e("MicroMsg.WXCommProvider", "wrong args");
                    AppMethodBeat.o(22256);
                    return null;
                }
                fr frVar2 = new fr();
                frVar2.dIP.op = 27;
                frVar2.dIP.source = 1;
                frVar2.dIP.selectionArgs = strArr2;
                frVar2.dIP.context = getContext();
                frVar2.dIP.dBX = strArr3;
                if (!EventCenter.instance.publish(frVar2)) {
                    Log.e("MicroMsg.WXCommProvider", "ExtCallBizEvent fail");
                }
                AppMethodBeat.o(22256);
                return null;
            case 28:
                fr frVar3 = new fr();
                frVar3.dIP.op = i2;
                frVar3.dIP.selectionArgs = strArr2;
                frVar3.dIP.context = getContext();
                frVar3.dIP.dBX = strArr3;
                if (!EventCenter.instance.publish(frVar3)) {
                    Log.e("MicroMsg.WXCommProvider", "ExtCallBizEvent fail");
                }
                AppMethodBeat.o(22256);
                return null;
            case 30:
            case 45:
                tc tcVar = new tc();
                tcVar.dZy.selectionArgs = strArr2;
                tcVar.dZy.dBX = strArr3;
                tcVar.dZy.context = getContext();
                tcVar.dZy.dZz = i2 == 45;
                if (i2 == 30 && strArr2 != null && strArr2.length > 2) {
                    g.JSP = strArr2[2];
                }
                if (!EventCenter.instance.publish(tcVar)) {
                    Log.e("MicroMsg.WXCommProvider", "open webview fail");
                }
                AppMethodBeat.o(22256);
                return null;
            case 31:
                ta taVar = new ta();
                taVar.dZw.selectionArgs = strArr2;
                taVar.dZw.dBX = strArr3;
                taVar.dZw.context = getContext();
                if (!EventCenter.instance.publish(taVar)) {
                    Log.e("MicroMsg.WXCommProvider", "open busi luckymoney fail");
                }
                AppMethodBeat.o(22256);
                return null;
            case 32:
                cq cqVar = new cq();
                cqVar.dFJ.action = 1;
                cqVar.dFJ.selectionArgs = strArr2;
                cqVar.dFJ.dBX = strArr3;
                cqVar.dFJ.context = getContext();
                if (!EventCenter.instance.publish(cqVar)) {
                    Log.e("MicroMsg.WXCommProvider", "open webview fail");
                }
                AppMethodBeat.o(22256);
                return null;
            case 33:
                cq cqVar2 = new cq();
                cqVar2.dFJ.action = 2;
                cqVar2.dFJ.selectionArgs = strArr2;
                cqVar2.dFJ.dBX = strArr3;
                cqVar2.dFJ.context = getContext();
                if (!EventCenter.instance.publish(cqVar2)) {
                    Log.e("MicroMsg.WXCommProvider", "open webview fail");
                }
                AppMethodBeat.o(22256);
                return null;
            case 39:
                bw bwVar = new bw();
                bwVar.dFg.selectionArgs = strArr2;
                bwVar.dFg.dBX = strArr3;
                bwVar.dFg.context = getContext();
                if (!EventCenter.instance.publish(bwVar)) {
                    Log.e("MicroMsg.WXCommProvider", "choose card from wx fail");
                }
                AppMethodBeat.o(22256);
                return null;
            case 43:
                if (strArr3.length > 0) {
                    String str3 = "OpenSdkToken@" + Util.nowMilliSecond();
                    ad.aVe().G(str3, true).l("open_sdk_token_package_name", strArr3[0]);
                    Log.i("MicroMsg.WXCommProvider", "gen token for opensdk ,package = %s", strArr3[0]);
                    MatrixCursor matrixCursor6 = new MatrixCursor(new String[]{"token"});
                    matrixCursor6.addRow(new String[]{str3});
                    AppMethodBeat.o(22256);
                    return matrixCursor6;
                }
                AppMethodBeat.o(22256);
                return null;
            case 44:
                final km kmVar = new km();
                kmVar.dPC.selectionArgs = strArr2;
                kmVar.dPC.dBX = strArr3;
                kmVar.dPC.context = getContext();
                if (!EventCenter.instance.publish(kmVar)) {
                    Log.e("MicroMsg.WXCommProvider", "handle scan result failed try again");
                    MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                        /* class com.tencent.mm.plugin.base.stub.WXCommProvider.AnonymousClass3 */

                        public final void run() {
                            AppMethodBeat.i(22245);
                            if (!EventCenter.instance.publish(kmVar)) {
                                Log.e("MicroMsg.WXCommProvider", "handle scan result failed again");
                            }
                            AppMethodBeat.o(22245);
                        }
                    }, 200);
                }
                AppMethodBeat.o(22256);
                return null;
            case 47:
                f.CD(1);
                f.a(getContext(), strArr2, strArr3, false, false, false);
                AppMethodBeat.o(22256);
                return null;
            case 49:
                tb tbVar = new tb();
                tbVar.dZx.selectionArgs = strArr2;
                tbVar.dZx.dBX = strArr3;
                tbVar.dZx.context = getContext();
                if (!EventCenter.instance.publish(tbVar)) {
                    Log.e("MicroMsg.WXCommProvider", "open offline pay fail");
                }
                AppMethodBeat.o(22256);
                return null;
            case 50:
                f.a(getContext(), strArr2, strArr3);
                AppMethodBeat.o(22256);
                return null;
            case 53:
                f.b(getContext(), strArr2, strArr3);
                AppMethodBeat.o(22256);
                return null;
            case 55:
                f.a(getContext(), strArr2, strArr3, false, false, true);
                AppMethodBeat.o(22256);
                return null;
            case n.CTRL_INDEX:
                f.CD(10);
                boolean u = f.u(strArr2);
                Log.i("MicroMsg.WXCommProvider", "needFetchPkg = %b", Boolean.valueOf(u));
                MatrixCursor a2 = f.a(getContext(), strArr2, strArr3, true, u, false);
                AppMethodBeat.o(22256);
                return a2;
            case 58:
                f.c(getContext(), strArr2, strArr3);
                AppMethodBeat.o(22256);
                return null;
            case bv.CTRL_INDEX:
                MatrixCursor matrixCursor7 = new MatrixCursor(new String[]{"support"}, 1);
                matrixCursor7.addRow(new Object[]{1});
                AppMethodBeat.o(22256);
                return matrixCursor7;
            case 60:
                MatrixCursor matrixCursor8 = new MatrixCursor(new String[]{"waid"}, 1);
                matrixCursor8.addRow(new Object[]{com.tencent.mm.plugin.normsg.a.d.INSTANCE.exQ()});
                AppMethodBeat.o(22256);
                return matrixCursor8;
            case PlayerException.EXCEPTION_TYPE_INITLIB /*{ENCODED_INT: 61}*/:
                MatrixCursor v = f.v(strArr2);
                AppMethodBeat.o(22256);
                return v;
            case 62:
                f.CD(13);
                MatrixCursor a3 = f.a(getContext(), strArr2, strArr3, false, false, false, true);
                AppMethodBeat.o(22256);
                return a3;
            case 63:
                f.d(getContext(), strArr2, strArr3);
                AppMethodBeat.o(22256);
                return null;
            case 64:
                f.e(getContext(), strArr2, strArr3);
                AppMethodBeat.o(22256);
                return null;
            case 65:
                f.f(getContext(), strArr2, strArr3);
                AppMethodBeat.o(22256);
                return null;
            case 66:
                f.g(getContext(), strArr2, strArr3);
                AppMethodBeat.o(22256);
                return null;
        }
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public int delete(final Uri uri, String str, String[] strArr) {
        AppMethodBeat.i(22257);
        if (uri == null) {
            Log.e("MicroMsg.WXCommProvider", "delete fail, uri is null");
            AppMethodBeat.o(22257);
            return 0;
        }
        final int match = pen.match(uri);
        final String[] a2 = a(uri, strArr);
        int intValue = ((Integer) new SyncTask<Integer>(0) {
            /* class com.tencent.mm.plugin.base.stub.WXCommProvider.AnonymousClass5 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // com.tencent.mm.sdk.platformtools.SyncTask
            public final /* synthetic */ Integer run() {
                AppMethodBeat.i(22247);
                Log.d("MicroMsg.WXCommProvider", "delete, uri = %s, code = %d", uri.toString(), Integer.valueOf(match));
                if (match != 1) {
                    Log.e("MicroMsg.WXCommProvider", "delete fail, invalid code = %d", Integer.valueOf(match));
                    AppMethodBeat.o(22247);
                    return null;
                }
                String[] strArr = a2;
                int i2 = 0;
                for (String str : strArr) {
                    if (!Util.isNullOrNil(str)) {
                        if (WXCommProvider.this.sp.contains(str) && WXCommProvider.this.sp.edit().remove(str).commit()) {
                            i2++;
                        }
                    }
                }
                Log.d("MicroMsg.WXCommProvider", "delete result = %d", Integer.valueOf(i2));
                Integer valueOf = Integer.valueOf(i2);
                AppMethodBeat.o(22247);
                return valueOf;
            }
        }.exec(this.handler)).intValue();
        AppMethodBeat.o(22257);
        return intValue;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    private String[] a(Uri uri, String[] strArr) {
        String str;
        boolean z;
        AppMethodBeat.i(179579);
        try {
            f.ckb();
            if (f.ckc()) {
                String callingPackage = getCallingPackage();
                Log.i("MicroMsg.WXCommProvider", "getCallingPackage %s", callingPackage);
                if (!Util.isNullOrNil(callingPackage)) {
                    String[] strArr2 = {callingPackage};
                    AppMethodBeat.o(179579);
                    return strArr2;
                }
                f.cjS();
            }
            int callingUid = Binder.getCallingUid();
            String[] packagesForUid = getContext().getPackageManager().getPackagesForUid(Binder.getCallingUid());
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(callingUid);
            objArr[1] = Integer.valueOf(packagesForUid == null ? 0 : packagesForUid.length);
            Log.i("MicroMsg.WXCommProvider", "getCallingPackages, callingUid = %d, packages size = %d", objArr);
            if (packagesForUid != null && packagesForUid.length > 1) {
                f.cjT();
            }
            if (packagesForUid == null) {
                Log.w("MicroMsg.WXCommProvider", "getCallingPackages fail, packages is null");
                String[] strArr3 = new String[0];
                AppMethodBeat.o(179579);
                return strArr3;
            }
            int length = packagesForUid.length;
            for (int i2 = 0; i2 < length; i2++) {
                Log.i("MicroMsg.WXCommProvider", "getCallingPackages = %s", packagesForUid[i2]);
            }
            if (packagesForUid.length <= 1 || strArr == null || strArr.length <= 0) {
                AppMethodBeat.o(179579);
                return packagesForUid;
            }
            String queryParameter = uri.getQueryParameter("appid");
            if (Util.isNullOrNil(queryParameter)) {
                queryParameter = uri.getQueryParameter("appId");
            }
            if (Util.isNullOrNil(queryParameter) && strArr != null && strArr.length > 1) {
                queryParameter = strArr[0];
            }
            if (Util.isNullOrNil(queryParameter) || !queryParameter.startsWith("wx")) {
                queryParameter = null;
            }
            if (Util.isNullOrNil(queryParameter)) {
                Log.e("MicroMsg.WXCommProvider", "getTargetPackageByAppId appId invalid");
                AppMethodBeat.o(179579);
                return packagesForUid;
            }
            if (Util.isNullOrNil(queryParameter)) {
                Log.e("MicroMsg.WXCommProvider", "getPackageNameByAppId appId invalid");
                str = null;
            } else {
                com.tencent.mm.pluginsdk.model.app.g o = com.tencent.mm.pluginsdk.model.app.h.o(queryParameter, true, false);
                if (o == null) {
                    Log.e("MicroMsg.WXCommProvider", "getPackageNameByAppId appInfo is null");
                    str = null;
                } else {
                    str = o.field_packageName;
                }
            }
            if (!Util.isNullOrNil(str)) {
                int length2 = packagesForUid.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length2) {
                        z = false;
                        break;
                    } else if (str.equals(packagesForUid[i3])) {
                        z = true;
                        break;
                    } else {
                        i3++;
                    }
                }
                if (z) {
                    Log.i("MicroMsg.WXCommProvider", "getTargetPackageByAppId match: %s", str);
                    h.INSTANCE.n(1194, 55, 1);
                    String[] strArr4 = {str};
                    AppMethodBeat.o(179579);
                    return strArr4;
                }
                Log.i("MicroMsg.WXCommProvider", "getTargetPackageByAppId not match: %s", str);
                h.INSTANCE.n(1194, 54, 1);
            } else {
                Log.e("MicroMsg.WXCommProvider", "getCallingPackages, getPackageNameByAppId return null");
                h.INSTANCE.n(1194, 52, 1);
            }
            AppMethodBeat.o(179579);
            return packagesForUid;
        } catch (Exception e2) {
            Log.e("MicroMsg.WXCommProvider", "getCallingPackages, ex = %s", e2.getMessage());
            String[] strArr5 = new String[0];
            AppMethodBeat.o(179579);
            return strArr5;
        }
    }

    private boolean cke() {
        AppMethodBeat.i(22259);
        try {
            Log.i("MicroMsg.WXCommProvider", "checkIsLogin()");
            if (pep || ((Boolean) new SyncTask<Boolean>(Boolean.FALSE) {
                /* class com.tencent.mm.plugin.base.stub.WXCommProvider.AnonymousClass6 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // com.tencent.mm.sdk.platformtools.SyncTask
                public final /* synthetic */ Boolean run() {
                    AppMethodBeat.i(22250);
                    Boolean bRZ = bRZ();
                    AppMethodBeat.o(22250);
                    return bRZ;
                }

                private Boolean bRZ() {
                    AppMethodBeat.i(22249);
                    try {
                        Log.i("MicroMsg.WXCommProvider", "checkIsLogin run");
                        if (!bg.aAc()) {
                            Boolean bool = Boolean.FALSE;
                            AppMethodBeat.o(22249);
                            return bool;
                        }
                        Log.i("MicroMsg.WXCommProvider", "checkIsLogin doScene");
                        Boolean valueOf = Boolean.valueOf(bg.azz().a(new bu(new bu.a() {
                            /* class com.tencent.mm.plugin.base.stub.WXCommProvider.AnonymousClass6.AnonymousClass1 */

                            @Override // com.tencent.mm.model.bu.a
                            public final void a(com.tencent.mm.network.g gVar) {
                                AppMethodBeat.i(22248);
                                Log.i("MicroMsg.WXCommProvider", "checkIsLogin onSceneEnd() hasLogin:%s", Boolean.valueOf(WXCommProvider.pep));
                                AnonymousClass6.this.setResultFinish(Boolean.TRUE);
                                AppMethodBeat.o(22248);
                            }
                        }), 0));
                        AppMethodBeat.o(22249);
                        return valueOf;
                    } catch (Exception e2) {
                        Log.e("MicroMsg.WXCommProvider", "exception in NetSceneLocalProxy.");
                        setResultFinish(Boolean.FALSE);
                        Boolean bool2 = Boolean.FALSE;
                        AppMethodBeat.o(22249);
                        return bool2;
                    }
                }
            }.exec(this.handler)).booleanValue()) {
                if (!bg.aAc() || !bg.aVG() || bg.azj()) {
                    pep = false;
                } else {
                    pep = true;
                }
                Log.i("MicroMsg.WXCommProvider", "hasLogin = " + pep);
                boolean z = pep;
                AppMethodBeat.o(22259);
                return z;
            }
            Log.i("MicroMsg.WXCommProvider", "checkIsLogin !syncTaskRet");
            pep = false;
            AppMethodBeat.o(22259);
            return false;
        } catch (Exception e2) {
            Log.w("MicroMsg.WXCommProvider", e2.getMessage());
            Log.printErrStackTrace("MicroMsg.WXCommProvider", e2, "", new Object[0]);
            AppMethodBeat.o(22259);
            return false;
        }
    }

    private boolean ckf() {
        boolean z = false;
        AppMethodBeat.i(22260);
        try {
            Log.i("MicroMsg.WXCommProvider", "checkIsLogin()");
            if (!pep) {
                final com.tencent.mm.pluginsdk.d.a.b bVar = new com.tencent.mm.pluginsdk.d.a.b();
                bVar.c(4000, new Runnable() {
                    /* class com.tencent.mm.plugin.base.stub.WXCommProvider.AnonymousClass7 */

                    public final void run() {
                        AppMethodBeat.i(22252);
                        try {
                            if (!bg.aAc()) {
                                AppMethodBeat.o(22252);
                                return;
                            }
                            bg.azz().a(new bu(new bu.a() {
                                /* class com.tencent.mm.plugin.base.stub.WXCommProvider.AnonymousClass7.AnonymousClass1 */

                                @Override // com.tencent.mm.model.bu.a
                                public final void a(com.tencent.mm.network.g gVar) {
                                    AppMethodBeat.i(22251);
                                    Log.i("MicroMsg.WXCommProvider", "checkIsLogin() onSceneEnd()");
                                    bVar.countDown();
                                    AppMethodBeat.o(22251);
                                }
                            }), 0);
                            AppMethodBeat.o(22252);
                        } catch (Exception e2) {
                            Log.e("MicroMsg.WXCommProvider", "exception in NetSceneLocalProxy");
                            bVar.countDown();
                            AppMethodBeat.o(22252);
                        }
                    }
                });
            }
            if (!bg.aAc() || !bg.aVG() || bg.azj()) {
                pep = false;
            } else {
                pep = true;
            }
            Log.i("MicroMsg.WXCommProvider", "hasLogin = " + pep);
            z = pep;
            AppMethodBeat.o(22260);
        } catch (Exception e2) {
            Log.w("MicroMsg.WXCommProvider", e2.getMessage());
            Log.printErrStackTrace("MicroMsg.WXCommProvider", e2, "", new Object[0]);
            AppMethodBeat.o(22260);
        }
        return z;
    }
}
