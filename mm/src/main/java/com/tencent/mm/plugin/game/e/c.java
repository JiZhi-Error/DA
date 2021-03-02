package com.tencent.mm.plugin.game.e;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import com.facebook.internal.AnalyticsEvents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.a.c.h;
import com.tencent.mm.av.a.c.k;
import com.tencent.mm.av.a.d.b;
import com.tencent.mm.av.q;
import com.tencent.mm.g.a.iz;
import com.tencent.mm.g.a.nr;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.plugin.game.model.a;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.r.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.s;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;

public final class c {
    private static int jhr = -1;
    private static int maxSize = -1;
    private static final Object ogA = new Object();
    private static Rect rect = new Rect();
    private static DisplayMetrics xTo;
    private static int xZa = -1;
    private static volatile MMHandler xvA;

    static {
        AppMethodBeat.i(42526);
        AppMethodBeat.o(42526);
    }

    public static int getScreenWidth(Context context) {
        AppMethodBeat.i(42496);
        if (context == null) {
            AppMethodBeat.o(42496);
            return 0;
        }
        if (xTo == null) {
            xTo = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(xTo);
        }
        int i2 = xTo.widthPixels;
        AppMethodBeat.o(42496);
        return i2;
    }

    public static int aQ(Context context, String str) {
        AppMethodBeat.i(42497);
        int D = D(context, str, null);
        AppMethodBeat.o(42497);
        return D;
    }

    public static int D(Context context, String str, String str2) {
        AppMethodBeat.i(42498);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(42498);
            return 0;
        } else if (aR(context, str)) {
            AppMethodBeat.o(42498);
            return 30;
        } else {
            Intent intent = new Intent();
            intent.putExtra("rawUrl", str);
            intent.putExtra("show_bottom", false);
            intent.putExtra("geta8key_scene", 32);
            intent.putExtra("KPublisherId", str2);
            w(intent, context);
            AppMethodBeat.o(42498);
            return 7;
        }
    }

    public static boolean aR(Context context, String str) {
        int i2 = 2;
        AppMethodBeat.i(42499);
        String queryParameter = Uri.parse(str).getQueryParameter("weapp");
        if (!Util.isNullOrNil(queryParameter)) {
            try {
                Uri parse = Uri.parse(queryParameter);
                String authority = parse.getAuthority();
                if (Util.isNullOrNil(authority)) {
                    Log.w("MicroMsg.GameCenterUtil", "targetAppId is null");
                    AppMethodBeat.o(42499);
                    return false;
                }
                String queryParameter2 = parse.getQueryParameter("env_version");
                String queryParameter3 = parse.getQueryParameter("path");
                String nullAsNil = Util.nullAsNil(queryParameter2);
                char c2 = 65535;
                switch (nullAsNil.hashCode()) {
                    case 110628630:
                        if (nullAsNil.equals("trial")) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case 1559690845:
                        if (nullAsNil.equals("develop")) {
                            c2 = 0;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        i2 = 1;
                        break;
                    case 1:
                        break;
                    default:
                        i2 = 0;
                        break;
                }
                Log.i("MicroMsg.GameCenterUtil", "jumpWeApp, appId: %s, versionType: %d, path: %s", authority, Integer.valueOf(i2), queryParameter3);
                AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                appBrandStatObject.scene = 1079;
                ((r) g.af(r.class)).a(context, (String) null, authority, i2, 0, queryParameter3, appBrandStatObject);
                AppMethodBeat.o(42499);
                return true;
            } catch (Exception e2) {
                Log.e("MicroMsg.GameCenterUtil", "checkJumpWeApp: " + e2.getMessage());
            }
        }
        AppMethodBeat.o(42499);
        return false;
    }

    public static void E(Context context, String str, String str2) {
        AppMethodBeat.i(204324);
        c(context, str, str2, 0);
        AppMethodBeat.o(204324);
    }

    public static void c(Context context, String str, String str2, int i2) {
        AppMethodBeat.i(204325);
        com.tencent.mm.plugin.appbrand.api.g gVar = new com.tencent.mm.plugin.appbrand.api.g();
        gVar.appId = str;
        gVar.kHw = str2;
        gVar.iOo = i2;
        gVar.scene = 1079;
        ((r) g.af(r.class)).a(context, gVar);
        AppMethodBeat.o(204325);
    }

    public static void a(Context context, o oVar, String str) {
        AppMethodBeat.i(42500);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", oVar.xFw.url);
        intent.putExtra("finishviewifloadfailed", true);
        intent.putExtra("show_full_screen", oVar.xFw.xvW);
        intent.putExtra("disable_progress_bar", oVar.xFw.xvW);
        int i2 = -1;
        switch (oVar.xFw.orientation) {
            case 1:
                i2 = 0;
                break;
            case 2:
                i2 = 1;
                break;
            case 3:
                i2 = 1001;
                break;
            case 4:
                i2 = 1002;
                break;
        }
        intent.putExtra("screen_orientation", i2);
        intent.putExtra("geta8key_scene", 32);
        intent.putExtra("KPublisherId", str);
        intent.putExtra("open_game_float", true);
        nr nrVar = new nr();
        nrVar.dTO.type = 1;
        nrVar.dTO.context = context;
        nrVar.dTO.intent = intent;
        EventCenter.instance.publish(nrVar);
        AppMethodBeat.o(42500);
    }

    public static boolean a(View view, Context context) {
        AppMethodBeat.i(42501);
        if (view.getTag() == null || !(view.getTag() instanceof String)) {
            Log.e("MicroMsg.GameCenterUtil", "Invalid Jump URL");
            AppMethodBeat.o(42501);
            return false;
        }
        String str = (String) view.getTag();
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.GameCenterUtil", "Invalid Jump URL");
            AppMethodBeat.o(42501);
            return false;
        }
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("show_bottom", false);
        w(intent, context);
        AppMethodBeat.o(42501);
        return true;
    }

    public static Dialog gl(Context context) {
        AppMethodBeat.i(42502);
        View inflate = View.inflate(context, R.layout.as6, null);
        final i iVar = new i(context, R.style.ky);
        iVar.setContentView(inflate);
        iVar.setCancelable(true);
        iVar.setCanceledOnTouchOutside(false);
        iVar.setOnCancelListener(new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.game.e.c.AnonymousClass1 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(42492);
                iVar.setOnCancelListener(null);
                AppMethodBeat.o(42492);
            }
        });
        AppMethodBeat.o(42502);
        return iVar;
    }

    public static int aAH(String str) {
        PackageInfo packageInfo;
        AppMethodBeat.i(42503);
        if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.GameCenterUtil", "Null or Nil packageName");
            AppMethodBeat.o(42503);
            return 0;
        }
        try {
            packageInfo = MMApplicationContext.getContext().getPackageManager().getPackageInfo(str, 0);
        } catch (Exception e2) {
            Log.w("MicroMsg.GameCenterUtil", "Exception: %s", e2.toString());
            packageInfo = null;
        }
        if (packageInfo == null) {
            AppMethodBeat.o(42503);
            return 0;
        }
        int i2 = packageInfo.versionCode;
        AppMethodBeat.o(42503);
        return i2;
    }

    public static String aAI(String str) {
        PackageInfo packageInfo;
        AppMethodBeat.i(204326);
        if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.GameCenterUtil", "Null or Nil packageName");
            AppMethodBeat.o(204326);
            return "";
        }
        try {
            packageInfo = MMApplicationContext.getContext().getPackageManager().getPackageInfo(str, 0);
        } catch (Exception e2) {
            Log.w("MicroMsg.GameCenterUtil", "Exception: %s", e2.toString());
            packageInfo = null;
        }
        if (packageInfo == null) {
            AppMethodBeat.o(204326);
            return "";
        }
        String str2 = packageInfo.versionName;
        AppMethodBeat.o(204326);
        return str2;
    }

    public static int aAJ(String str) {
        AppMethodBeat.i(42504);
        if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.GameCenterUtil", "Null or Nil path");
            AppMethodBeat.o(42504);
            return 0;
        }
        PackageInfo packageArchiveInfo = MMApplicationContext.getContext().getPackageManager().getPackageArchiveInfo(str, 0);
        if (packageArchiveInfo == null) {
            AppMethodBeat.o(42504);
            return 0;
        }
        int i2 = packageArchiveInfo.versionCode;
        AppMethodBeat.o(42504);
        return i2;
    }

    public static synchronized void g(String str, final float f2) {
        synchronized (c.class) {
            AppMethodBeat.i(42505);
            if (Util.isNullOrNil(str)) {
                AppMethodBeat.o(42505);
            } else {
                Log.d("MicroMsg.GameCenterUtil", "pre download entrance image : %s", str);
                final iz izVar = new iz();
                izVar.dND.EX = 1;
                izVar.dND.url = str;
                EventCenter.instance.publish(izVar);
                if (izVar.dNE.dNG) {
                    c.a aVar = new c.a();
                    aVar.jbf = true;
                    aVar.fullPath = izVar.dNE.dNF + com.tencent.mm.b.g.getMessageDigest(str.getBytes());
                    q.bcV().a(str, null, aVar.bdv(), new k() {
                        /* class com.tencent.mm.plugin.game.e.c.AnonymousClass2 */

                        @Override // com.tencent.mm.av.a.c.k
                        public final void a(String str, View view, Bitmap bitmap, Object... objArr) {
                            AppMethodBeat.i(42493);
                            izVar.dND.EX = 2;
                            izVar.dND.url = str;
                            EventCenter.instance.publish(izVar);
                            AppMethodBeat.o(42493);
                        }
                    }, new h() {
                        /* class com.tencent.mm.plugin.game.e.c.AnonymousClass3 */

                        @Override // com.tencent.mm.av.a.c.h
                        public final void b(String str, View view) {
                        }

                        @Override // com.tencent.mm.av.a.c.h
                        public final Bitmap a(String str, View view, b bVar) {
                            Bitmap roundedCornerBitmap;
                            AppMethodBeat.i(42494);
                            if (bVar.bitmap == null || bVar.bitmap.isRecycled() || f2 <= 0.0f || (roundedCornerBitmap = BitmapUtil.getRoundedCornerBitmap(bVar.bitmap, true, ((float) bVar.bitmap.getWidth()) * f2)) == null) {
                                AppMethodBeat.o(42494);
                                return null;
                            }
                            AppMethodBeat.o(42494);
                            return roundedCornerBitmap;
                        }

                        @Override // com.tencent.mm.av.a.c.h
                        public final void b(String str, View view, b bVar) {
                            AppMethodBeat.i(42495);
                            izVar.dND.EX = 2;
                            izVar.dND.url = str;
                            EventCenter.instance.publish(izVar);
                            if (bVar == null) {
                                AppMethodBeat.o(42495);
                                return;
                            }
                            int i2 = bVar.from;
                            if (bVar.status != 0 || bVar.bitmap == null) {
                                if (i2 == 2) {
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(858, 14, 1, false);
                                }
                            } else if (i2 == 2) {
                                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(858, 13, 1, false);
                                AppMethodBeat.o(42495);
                                return;
                            }
                            AppMethodBeat.o(42495);
                        }
                    });
                }
                AppMethodBeat.o(42505);
            }
        }
    }

    public static void aX(LinkedList<String> linkedList) {
        AppMethodBeat.i(42506);
        if (Util.isNullOrNil(linkedList)) {
            AppMethodBeat.o(42506);
            return;
        }
        LinkedList linkedList2 = new LinkedList();
        Iterator<String> it = linkedList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            com.tencent.mm.pluginsdk.model.app.g o = com.tencent.mm.pluginsdk.model.app.h.o(next, true, false);
            if (o != null && Util.isNullOrNil(o.field_openId)) {
                linkedList2.add(next);
            }
        }
        if (!Util.isNullOrNil(linkedList2)) {
            a.eAU().addAll(linkedList2);
        }
        AppMethodBeat.o(42506);
    }

    public static LinkedList<com.tencent.mm.pluginsdk.model.app.g> dWP() {
        AppMethodBeat.i(42507);
        Cursor gmX = a.eAS().gmX();
        LinkedList<com.tencent.mm.pluginsdk.model.app.g> linkedList = new LinkedList<>();
        if (gmX == null) {
            Log.e("MicroMsg.GameCenterUtil", "getGameAppInfo failed: curosr is null");
        } else {
            if (gmX.moveToFirst()) {
                do {
                    com.tencent.mm.pluginsdk.model.app.g gVar = new com.tencent.mm.pluginsdk.model.app.g();
                    gVar.convertFrom(gmX);
                    linkedList.add(gVar);
                } while (gmX.moveToNext());
            }
            gmX.close();
        }
        AppMethodBeat.o(42507);
        return linkedList;
    }

    public static int b(Context context, String str, String str2, Bundle bundle) {
        AppMethodBeat.i(42508);
        int a2 = a(context, str, str2, bundle, 0);
        AppMethodBeat.o(42508);
        return a2;
    }

    public static int a(Context context, String str, String str2, Bundle bundle, int i2) {
        AppMethodBeat.i(42509);
        if (!Util.isNullOrNil(str)) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            a.C1403a ei = com.tencent.mm.plugin.game.model.a.ei(str, bundle.getInt("game_report_from_scene", 0));
            if (ei.cSx == 2 && !Util.isNullOrNil(ei.url)) {
                int D = D(context, ei.url, "game_center_detail");
                AppMethodBeat.o(42509);
                return D;
            }
        }
        if (!Util.isNullOrNil(str2)) {
            int D2 = D(context, str2, "game_center_detail");
            AppMethodBeat.o(42509);
            return D2;
        }
        int dVb = e.dVb();
        if (dVb == 2) {
            int l = l(context, str, i2);
            AppMethodBeat.o(42509);
            return l;
        } else if (dVb == 1) {
            f(context, bundle);
            AppMethodBeat.o(42509);
            return 6;
        } else {
            String simCountryCode = Util.getSimCountryCode(context);
            if (Util.isNullOrNil(simCountryCode) || simCountryCode.toLowerCase().equals("cn")) {
                int l2 = l(context, str, i2);
                AppMethodBeat.o(42509);
                return l2;
            }
            f(context, bundle);
            AppMethodBeat.o(42509);
            return 6;
        }
    }

    public static int l(Context context, String str, int i2) {
        String str2;
        AppMethodBeat.i(42510);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(42510);
            return 0;
        }
        String dVa = e.dVa();
        if (!Util.isNullOrNil(dVa)) {
            HashMap hashMap = new HashMap();
            hashMap.put("appid", str);
            if (i2 > 0) {
                hashMap.put(TPDownloadProxyEnum.USER_SSID, String.valueOf(i2));
            }
            str2 = F(dVa, hashMap);
        } else {
            str2 = com.tencent.mm.plugin.game.a.xtm + "?appid=" + str;
        }
        int D = D(context, str2, "game_center_detail");
        AppMethodBeat.o(42510);
        return D;
    }

    public static String F(String str, Map<String, String> map) {
        AppMethodBeat.i(42511);
        if (Util.isNullOrNil(str) || map.isEmpty()) {
            AppMethodBeat.o(42511);
            return str;
        }
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        for (String str2 : map.keySet()) {
            buildUpon.appendQueryParameter(str2, map.get(str2));
        }
        String uri = buildUpon.build().toString();
        AppMethodBeat.o(42511);
        return uri;
    }

    public static void f(Context context, Bundle bundle) {
        AppMethodBeat.i(42512);
        Intent intent = new Intent();
        intent.setClassName(context, "com.tencent.mm.plugin.game.ui.GameDetailUI2");
        intent.putExtras(bundle);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/game/utils/GameCenterUtil", "jumpGameDetailNative", "(Landroid/content/Context;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/game/utils/GameCenterUtil", "jumpGameDetailNative", "(Landroid/content/Context;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(42512);
    }

    public static void w(Intent intent, Context context) {
        AppMethodBeat.i(42513);
        if (aAK(intent.getStringExtra("rawUrl"))) {
            x(intent, context);
            AppMethodBeat.o(42513);
            return;
        }
        nr nrVar = new nr();
        nrVar.dTO.type = 0;
        nrVar.dTO.context = context;
        nrVar.dTO.intent = intent;
        EventCenter.instance.publish(nrVar);
        AppMethodBeat.o(42513);
    }

    public static void x(Intent intent, Context context) {
        AppMethodBeat.i(42514);
        nr nrVar = new nr();
        nrVar.dTO.type = 2;
        nrVar.dTO.context = context;
        nrVar.dTO.intent = intent;
        EventCenter.instance.publish(nrVar);
        AppMethodBeat.o(42514);
    }

    public static void bZm() {
        AppMethodBeat.i(42515);
        if (xvA == null) {
            AppMethodBeat.o(42515);
            return;
        }
        synchronized (ogA) {
            try {
                if (xvA != null) {
                    com.tencent.mm.vending.h.g.boG("SubCoreGameCenter#WorkThread");
                    xvA.quit();
                    xvA = null;
                }
            } finally {
                AppMethodBeat.o(42515);
            }
        }
    }

    public static MMHandler cyh() {
        AppMethodBeat.i(183911);
        if (xvA == null) {
            synchronized (ogA) {
                try {
                    if (xvA == null) {
                        xvA = new MMHandler("SubCoreGameCenter#WorkThread");
                        com.tencent.mm.vending.h.g.a("SubCoreGameCenter#WorkThread", new com.tencent.mm.cd.a("SubCoreGameCenter#WorkThread"));
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(183911);
                    throw th;
                }
            }
        }
        MMHandler mMHandler = xvA;
        AppMethodBeat.o(183911);
        return mMHandler;
    }

    public static int parseColor(String str) {
        AppMethodBeat.i(42517);
        int i2 = 0;
        try {
            i2 = Color.parseColor(str);
        } catch (Exception e2) {
            Log.e("MicroMsg.GameCenterUtil", "parseColor: " + e2.getMessage());
        }
        AppMethodBeat.o(42517);
        return i2;
    }

    public static boolean hR(String str, String str2) {
        AppMethodBeat.i(42518);
        com.tencent.mm.vfs.o oVar = new com.tencent.mm.vfs.o(str);
        String bhK = s.bhK(aa.z(oVar.mUri));
        if (Util.isNullOrNil(str2) || Util.isNullOrNil(bhK)) {
            Log.i("MicroMsg.GameCenterUtil", "checkPkgMD5Valid, md5 is null");
            boolean exists = oVar.exists();
            AppMethodBeat.o(42518);
            return exists;
        }
        Log.i("MicroMsg.GameCenterUtil", "checkPkgMD5Valid, md5 = %s, calculateMD5 = %s", str2, bhK);
        boolean equalsIgnoreCase = str2.equalsIgnoreCase(bhK);
        AppMethodBeat.o(42518);
        return equalsIgnoreCase;
    }

    public static void GK(long j2) {
        AppMethodBeat.i(42519);
        com.tencent.mm.plugin.downloader.i.a.a(j2, false, null);
        AppMethodBeat.o(42519);
    }

    public static String dWQ() {
        AppMethodBeat.i(42520);
        String a2 = ((com.tencent.mm.game.report.a.b) g.af(com.tencent.mm.game.report.a.b.class)).a(b.a.clicfg_game_center_home_url_android, "");
        if (a2 == null || Util.isNullOrNil(a2.trim())) {
            a.C1403a dUL = com.tencent.mm.plugin.game.model.a.dUL();
            if (dUL.cSx == 2 && !Util.isNullOrNil(dUL.url)) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(848, 12, 1, false);
                String str = dUL.url;
                AppMethodBeat.o(42520);
                return str;
            } else if (com.tencent.mm.plugin.game.commlib.a.xvl == null || com.tencent.mm.plugin.game.commlib.a.xvl.GameIndexSetting == null || com.tencent.mm.plugin.game.commlib.a.xvl.GameIndexSetting.xKK != 1) {
                com.tencent.mm.plugin.game.commlib.a.dSS();
                if (com.tencent.mm.plugin.game.commlib.a.xvl == null || com.tencent.mm.plugin.game.commlib.a.xvl.GameIndexSetting == null || com.tencent.mm.plugin.game.commlib.a.xvl.GameIndexSetting.xKK != 1) {
                    AppMethodBeat.o(42520);
                    return null;
                }
                String str2 = com.tencent.mm.plugin.game.commlib.a.xvl.GameIndexSetting.xKL;
                AppMethodBeat.o(42520);
                return str2;
            } else {
                String str3 = com.tencent.mm.plugin.game.commlib.a.xvl.GameIndexSetting.xKL;
                AppMethodBeat.o(42520);
                return str3;
            }
        } else if (a2.equals(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE)) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(848, 11, 1, false);
            AppMethodBeat.o(42520);
            return null;
        } else {
            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(848, 10, 1, false);
            AppMethodBeat.o(42520);
            return a2;
        }
    }

    private static boolean aAK(String str) {
        AppMethodBeat.i(42521);
        if (!((com.tencent.mm.game.report.a.b) g.af(com.tencent.mm.game.report.a.b.class)).a(b.a.game_luggage, true)) {
            AppMethodBeat.o(42521);
            return false;
        } else if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(42521);
            return false;
        } else {
            Uri parse = Uri.parse(str);
            if (parse.getHost() == null || !parse.getHost().equals(WeChatHosts.domainString(R.string.e1h))) {
                AppMethodBeat.o(42521);
                return false;
            }
            AppMethodBeat.o(42521);
            return true;
        }
    }

    public static String aY(LinkedList<String> linkedList) {
        AppMethodBeat.i(42522);
        Iterator<String> it = linkedList.iterator();
        if (!it.hasNext()) {
            AppMethodBeat.o(42522);
            return "()";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('(');
        while (true) {
            sb.append("\"" + it.next().trim() + "\"");
            if (!it.hasNext()) {
                String sb2 = sb.append(')').toString();
                AppMethodBeat.o(42522);
                return sb2;
            }
            sb.append(',');
        }
    }

    public static LinkedList<String> aAL(String str) {
        AppMethodBeat.i(42523);
        String[] split = str.substring(1, str.length() - 1).split(",");
        LinkedList<String> linkedList = new LinkedList<>();
        for (String str2 : split) {
            linkedList.add(str2.trim());
        }
        AppMethodBeat.o(42523);
        return linkedList;
    }

    public static LinkedList<String> A(JSONArray jSONArray) {
        AppMethodBeat.i(42524);
        if (jSONArray == null || jSONArray.length() == 0) {
            AppMethodBeat.o(42524);
            return null;
        }
        LinkedList<String> linkedList = new LinkedList<>();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            linkedList.add(jSONArray.optString(i2).trim());
        }
        AppMethodBeat.o(42524);
        return linkedList;
    }

    public static JSONArray aAM(String str) {
        AppMethodBeat.i(42525);
        String[] split = str.substring(1, str.length() - 1).split(",");
        JSONArray jSONArray = new JSONArray();
        for (String str2 : split) {
            jSONArray.put(str2.trim());
        }
        AppMethodBeat.o(42525);
        return jSONArray;
    }

    public static boolean aAN(String str) {
        AppMethodBeat.i(204327);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(204327);
            return false;
        }
        if (((f) g.af(f.class)).dSL().azn("NotDisturb_" + MD5Util.getMD5String(str)) == null) {
            AppMethodBeat.o(204327);
            return false;
        }
        AppMethodBeat.o(204327);
        return true;
    }

    public static void bJ(String str, boolean z) {
        AppMethodBeat.i(204328);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(204328);
            return;
        }
        Log.i("MicroMsg.GameCenterUtil", "setNotDisturbMsg, msgRelatedId:%s, flag:%b", str, Boolean.valueOf(z));
        String str2 = "NotDisturb_" + MD5Util.getMD5String(str);
        if (z) {
            ((f) g.af(f.class)).dSL().r(str2, "1".getBytes());
            AppMethodBeat.o(204328);
            return;
        }
        ((f) g.af(f.class)).dSL().aAl(str2);
        AppMethodBeat.o(204328);
    }
}
