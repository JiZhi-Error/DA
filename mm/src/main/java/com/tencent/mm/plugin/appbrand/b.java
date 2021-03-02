package com.tencent.mm.plugin.appbrand;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import android.widget.Toast;
import com.facebook.internal.ServerProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.ad;
import com.tencent.mm.plugin.appbrand.appcache.ak;
import com.tencent.mm.plugin.appbrand.appcache.as;
import com.tencent.mm.plugin.appbrand.appcache.au;
import com.tencent.mm.plugin.appbrand.appcache.ay;
import com.tencent.mm.plugin.appbrand.appcache.bd;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.appcache.n;
import com.tencent.mm.plugin.appbrand.appcache.u;
import com.tencent.mm.plugin.appbrand.appstorage.MD5JNI;
import com.tencent.mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.mm.plugin.appbrand.appstorage.n;
import com.tencent.mm.plugin.appbrand.appusage.y;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.aa;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.game.a.v;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.appbrand.service.w;
import com.tencent.mm.plugin.appbrand.service.x;
import com.tencent.mm.plugin.appbrand.task.h;
import com.tencent.mm.plugin.appbrand.task.preload.e;
import com.tencent.mm.plugin.appbrand.xweb_ext.c;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ar;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.ZipInputStream;

public final class b implements a {
    @Override // com.tencent.mm.pluginsdk.cmd.a
    public final boolean a(Context context, String[] strArr, String str) {
        boolean z;
        char c2 = 65535;
        boolean z2 = false;
        int i2 = 0;
        AppMethodBeat.i(43788);
        if (((WeChatEnvironment.hasDebugger() || BuildInfo.IS_FLAVOR_RED || BuildInfo.IS_FLAVOR_PURPLE) ? 1 : null) == null) {
            AppMethodBeat.o(43788);
        } else if ("//enable_appbrand_monkey_test".equals(strArr[0])) {
            DebuggerShell.bAB();
            AppMethodBeat.o(43788);
        } else if ("//disable_appbrand_monkey_test".equals(strArr[0])) {
            DebuggerShell.bAC();
            AppMethodBeat.o(43788);
        } else if ("//appbrand_monkey_bringtofront".equals(strArr[0])) {
            Pair<String, Integer> afj = h.bWb().afj(strArr.length > 1 ? strArr[1].trim() : "");
            if (afj != null) {
                g gVar = new g();
                gVar.appId = (String) afj.first;
                gVar.iOo = ((Integer) afj.second).intValue();
                gVar.scene = 1030;
                ((r) com.tencent.mm.kernel.g.af(r.class)).a(context, gVar);
            }
            AppMethodBeat.o(43788);
        } else if ("//appbrand_monkey_test_skip_appbrand_process_suicide".equals(strArr[0])) {
            if (strArr.length <= 1 || Util.getInt(strArr[1].trim(), 1) > 0) {
                z = true;
            } else {
                z = false;
            }
            DebuggerShell.gV(z);
            AppMethodBeat.o(43788);
        } else if ("//appbrand_predownload_trigger".equals(strArr[0])) {
            ((w) com.tencent.mm.kernel.g.af(w.class)).bb(strArr.length > 1 ? strArr[1].trim() : "", 0);
            AppMethodBeat.o(43788);
        } else if ("//xweb_live".equals(strArr[0])) {
            String str2 = strArr[1];
            switch (str2.hashCode()) {
                case 3569038:
                    if (str2.equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE)) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 94746189:
                    if (str2.equals("clear")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 97196323:
                    if (str2.equals("false")) {
                        c2 = 2;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    c.cdy();
                    break;
                case 1:
                    c.AM(1);
                    break;
                case 2:
                    c.AM(0);
                    break;
            }
            AppMethodBeat.o(43788);
        } else if ("//xweb_video_preload".equals(strArr[0])) {
            String str3 = strArr[1];
            switch (str3.hashCode()) {
                case 3569038:
                    if (str3.equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE)) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 94746189:
                    if (str3.equals("clear")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 97196323:
                    if (str3.equals("false")) {
                        c2 = 2;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    MultiProcessMMKV.getMMKV("xweb_abtest_command").removeValueForKey("xweb_video_preload_command_value");
                    break;
                case 1:
                    com.tencent.mm.plugin.appbrand.xweb_ext.video.b.AP(1);
                    break;
                case 2:
                    com.tencent.mm.plugin.appbrand.xweb_ext.video.b.AP(0);
                    break;
            }
            AppMethodBeat.o(43788);
        } else if ("//xweb_video_ps".equals(strArr[0])) {
            int safeParseInt = Util.safeParseInt(strArr[1]);
            if (safeParseInt < 0) {
                MultiProcessMMKV.getMMKV("xweb_abtest_command").removeValueForKey("xweb_video_weishi_ps_command_value");
            } else {
                MultiProcessMMKV.getMMKV("xweb_abtest_command").encode("xweb_video_weishi_ps_command_value", safeParseInt);
            }
            AppMethodBeat.o(43788);
        } else if ("//xweb_video_player".equals(strArr[0])) {
            String str4 = strArr[1];
            switch (str4.hashCode()) {
                case 3569038:
                    if (str4.equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE)) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 94746189:
                    if (str4.equals("clear")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 97196323:
                    if (str4.equals("false")) {
                        c2 = 2;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    MultiProcessMMKV.getMMKV("xweb_abtest_command").removeValueForKey("xweb_video_player_command_value");
                    break;
                case 1:
                    com.tencent.mm.plugin.appbrand.xweb_ext.video.b.AQ(1);
                    break;
                case 2:
                    com.tencent.mm.plugin.appbrand.xweb_ext.video.b.AQ(0);
                    break;
            }
            AppMethodBeat.o(43788);
        } else if ("//xweb_hls_video_player".equals(strArr[0])) {
            String str5 = strArr[1];
            switch (str5.hashCode()) {
                case 3569038:
                    if (str5.equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE)) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 94746189:
                    if (str5.equals("clear")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 97196323:
                    if (str5.equals("false")) {
                        c2 = 2;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    MultiProcessMMKV.getMMKV("xweb_abtest_command").removeValueForKey("xweb_hls_video_player_command_value");
                    break;
                case 1:
                    com.tencent.mm.plugin.appbrand.xweb_ext.video.b.AR(1);
                    break;
                case 2:
                    com.tencent.mm.plugin.appbrand.xweb_ext.video.b.AR(0);
                    break;
            }
            AppMethodBeat.o(43788);
        } else if ("//xweb_video_proxy".equals(strArr[0])) {
            String str6 = strArr[1];
            switch (str6.hashCode()) {
                case 3569038:
                    if (str6.equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE)) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 94746189:
                    if (str6.equals("clear")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 97196323:
                    if (str6.equals("false")) {
                        c2 = 2;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    MultiProcessMMKV.getMMKV("xweb_abtest_command").removeValueForKey("xweb_video_proxy_command_value");
                    break;
                case 1:
                    com.tencent.mm.plugin.appbrand.xweb_ext.video.b.AS(1);
                    break;
                case 2:
                    com.tencent.mm.plugin.appbrand.xweb_ext.video.b.AS(0);
                    break;
            }
            AppMethodBeat.o(43788);
        } else if ("//xweb_video_hls_proxy".equals(strArr[0])) {
            String str7 = strArr[1];
            switch (str7.hashCode()) {
                case 3569038:
                    if (str7.equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE)) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 94746189:
                    if (str7.equals("clear")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 97196323:
                    if (str7.equals("false")) {
                        c2 = 2;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    MultiProcessMMKV.getMMKV("xweb_abtest_command").removeValueForKey("xweb_video_hls_proxy_command_value");
                    break;
                case 1:
                    com.tencent.mm.plugin.appbrand.xweb_ext.video.b.AT(1);
                    break;
                case 2:
                    com.tencent.mm.plugin.appbrand.xweb_ext.video.b.AT(0);
                    break;
            }
            AppMethodBeat.o(43788);
        } else if ("//xweb_video".equals(strArr[0])) {
            String str8 = strArr[1];
            switch (str8.hashCode()) {
                case 3569038:
                    if (str8.equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE)) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 94746189:
                    if (str8.equals("clear")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 97196323:
                    if (str8.equals("false")) {
                        c2 = 2;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    c.cdj();
                    break;
                case 1:
                    c.AL(1);
                    break;
                case 2:
                    c.AL(0);
                    break;
            }
            AppMethodBeat.o(43788);
        } else if ("//showad".equals(strArr[0])) {
            String str9 = strArr[1];
            switch (str9.hashCode()) {
                case 3569038:
                    if (str9.equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE)) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 94746189:
                    if (str9.equals("clear")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 97196323:
                    if (str9.equals("false")) {
                        c2 = 2;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    com.tencent.mm.plugin.appbrand.ad.b.btE();
                    break;
                case 1:
                    com.tencent.mm.plugin.appbrand.ad.b.vJ(1);
                    break;
                case 2:
                    com.tencent.mm.plugin.appbrand.ad.b.vJ(0);
                    break;
            }
            AppMethodBeat.o(43788);
        } else if ("//allshowad".equals(strArr[0])) {
            String str10 = strArr[1];
            switch (str10.hashCode()) {
                case 3569038:
                    if (str10.equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE)) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 94746189:
                    if (str10.equals("clear")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 97196323:
                    if (str10.equals("false")) {
                        c2 = 2;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    com.tencent.mm.plugin.appbrand.ad.b.btG();
                    break;
                case 1:
                    com.tencent.mm.plugin.appbrand.ad.b.vK(1);
                    break;
                case 2:
                    com.tencent.mm.plugin.appbrand.ad.b.vK(0);
                    break;
            }
            AppMethodBeat.o(43788);
        } else if ("//localwxalibrary".equals(strArr[0])) {
            MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("__appbrand_comm_lib__prefs");
            String str11 = strArr[1];
            switch (str11.hashCode()) {
                case 3569038:
                    if (str11.equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE)) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 94746189:
                    if (str11.equals("clear")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 97196323:
                    if (str11.equals("false")) {
                        c2 = 2;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    mmkv.edit().remove("localwxalibrary").commit();
                    break;
                case 1:
                    mmkv.edit().putBoolean("localwxalibrary", true).commit();
                    break;
                case 2:
                    mmkv.edit().putBoolean("localwxalibrary", false).commit();
                    break;
            }
            AppMethodBeat.o(43788);
        } else if ("//getsearchshowoutwxaapp".equals(strArr[0])) {
            if (strArr.length <= 1 || !strArr[1].contains("daily")) {
                y.a aVar = y.a.SEARCH;
                y.bys();
            } else {
                y.a aVar2 = y.a.DAILY;
                y.bys();
            }
            AppMethodBeat.o(43788);
        } else if ("//callsearchshowoutwxaapp".equals(strArr[0])) {
            ((x) com.tencent.mm.kernel.g.af(x.class)).byv();
            AppMethodBeat.o(43788);
        } else if ("//wagame".equals(strArr[0])) {
            v.a(context, strArr);
            AppMethodBeat.o(43788);
        } else {
            String lowerCase = strArr[1].toLowerCase();
            switch (lowerCase.hashCode()) {
                case -2120258717:
                    if (lowerCase.equals("incremental_insert_24")) {
                        c2 = 18;
                        break;
                    }
                    break;
                case -2120258713:
                    if (lowerCase.equals("incremental_insert_28")) {
                        c2 = 19;
                        break;
                    }
                    break;
                case -2094503115:
                    if (lowerCase.equals("incremental_delete_28")) {
                        c2 = 20;
                        break;
                    }
                    break;
                case -2086708598:
                    if (lowerCase.equals("deletebetalib")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case -1958532869:
                    if (lowerCase.equals("historycount")) {
                        c2 = 11;
                        break;
                    }
                    break;
                case -1897191982:
                    if (lowerCase.equals("starmax")) {
                        c2 = 14;
                        break;
                    }
                    break;
                case -1819844161:
                    if (lowerCase.equals("javazip")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -1786125444:
                    if (lowerCase.equals("open_material")) {
                        c2 = '#';
                        break;
                    }
                    break;
                case -1553762615:
                    if (lowerCase.equals("insert_pdd_ori_1170_app")) {
                        c2 = '\"';
                        break;
                    }
                    break;
                case -1513405239:
                    if (lowerCase.equals("clear_mocklib")) {
                        c2 = 23;
                        break;
                    }
                    break;
                case -1226808944:
                    if (lowerCase.equals("pre_load_launch")) {
                        c2 = 31;
                        break;
                    }
                    break;
                case -1155441316:
                    if (lowerCase.equals("jnizip")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -917899243:
                    if (lowerCase.equals("deletecontact")) {
                        c2 = '\n';
                        break;
                    }
                    break;
                case -738930766:
                    if (lowerCase.equals("disable_preload")) {
                        c2 = 25;
                        break;
                    }
                    break;
                case -725390129:
                    if (lowerCase.equals("clearguide")) {
                        c2 = 16;
                        break;
                    }
                    break;
                case -724739237:
                    if (lowerCase.equals("enable_pre_loading_rainbow")) {
                        c2 = 26;
                        break;
                    }
                    break;
                case -724650944:
                    if (lowerCase.equals("disable_pre_loading_rainbow")) {
                        c2 = 27;
                        break;
                    }
                    break;
                case -681162920:
                    if (lowerCase.equals("pkgcleanup")) {
                        c2 = 7;
                        break;
                    }
                    break;
                case -501183631:
                    if (lowerCase.equals("releasepkghighversion")) {
                        c2 = 17;
                        break;
                    }
                    break;
                case -401845503:
                    if (lowerCase.equals("trigger_check_lib_update")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case -358696710:
                    if (lowerCase.equals("deletelib")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case -358692799:
                    if (lowerCase.equals("deletepkg")) {
                        c2 = 6;
                        break;
                    }
                    break;
                case -345825124:
                    if (lowerCase.equals("trigger_daily_clean")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -220425171:
                    if (lowerCase.equals("pluginlruclean")) {
                        c2 = '\b';
                        break;
                    }
                    break;
                case -78191370:
                    if (lowerCase.equals("incremental_delete_latest")) {
                        c2 = 21;
                        break;
                    }
                    break;
                case 3545755:
                    if (lowerCase.equals("sync")) {
                        c2 = '\r';
                        break;
                    }
                    break;
                case 98712316:
                    if (lowerCase.equals("guide")) {
                        c2 = 15;
                        break;
                    }
                    break;
                case 424332448:
                    if (lowerCase.equals("incremental_lib")) {
                        c2 = 22;
                        break;
                    }
                    break;
                case 635580990:
                    if (lowerCase.equals("checkdemoclean")) {
                        c2 = '\t';
                        break;
                    }
                    break;
                case 1102626508:
                    if (lowerCase.equals("disable_develop_lib")) {
                        c2 = 24;
                        break;
                    }
                    break;
                case 1127987502:
                    if (lowerCase.equals("resetsyncversion")) {
                        c2 = '\f';
                        break;
                    }
                    break;
                case 1227329365:
                    if (lowerCase.equals("insert_pdd_enc_1170_app")) {
                        c2 = '!';
                        break;
                    }
                    break;
                case 1351365709:
                    if (lowerCase.equals("lazy_code_pkg_launch")) {
                        c2 = 30;
                        break;
                    }
                    break;
                case 1484566023:
                    if (lowerCase.equals("pre_load_level")) {
                        c2 = ' ';
                        break;
                    }
                    break;
                case 1535659209:
                    if (lowerCase.equals("disable_pre_loading")) {
                        c2 = 28;
                        break;
                    }
                    break;
                case 1600208612:
                    if (lowerCase.equals("enable_pre_loading")) {
                        c2 = 29;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    ThreadPool.post(new Runnable() {
                        /* class com.tencent.mm.plugin.appbrand.b.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(43784);
                            Log.i("[ZIP]", "unzip JNI %d, cost %d", Integer.valueOf(ZipJNI.unzip("/sdcard/test_zip.zip", "/sdcard/test_zip/", null)), Long.valueOf(Util.nowMilliSecond() - Util.nowMilliSecond()));
                            AppMethodBeat.o(43784);
                        }
                    }, "TestZipJNI");
                    break;
                case 1:
                    ThreadPool.post(new Runnable() {
                        /* class com.tencent.mm.plugin.appbrand.b.AnonymousClass2 */

                        public final void run() {
                            AppMethodBeat.i(43785);
                            long nowMilliSecond = Util.nowMilliSecond();
                            int i2 = -1;
                            try {
                                i2 = n.a(new ZipInputStream(s.ao(new o("/sdcard/test_zip.zip"))), "/sdcard/test_zip/");
                            } catch (Exception e2) {
                                Log.e("[ZIP]", "unzip Java ex=%s", e2);
                            }
                            Log.i("[ZIP]", "unzip Java %d, cost %d", Integer.valueOf(i2), Long.valueOf(Util.nowMilliSecond() - nowMilliSecond));
                            AppMethodBeat.o(43785);
                        }
                    }, "TestZipJava");
                    break;
                case 2:
                    l.brc();
                    break;
                case 3:
                    au.gH(true);
                    break;
                case 4:
                    bh buL = com.tencent.mm.plugin.appbrand.app.n.buL();
                    bd bdVar = new bd();
                    bdVar.field_appId = "@LibraryAppId";
                    bdVar.field_debugType = 999;
                    bdVar.field_version = 1;
                    buL.kNK.delete(bdVar, bd.kNu);
                    int i3 = ay.VERSION;
                    as.bvR();
                    break;
                case 5:
                    com.tencent.mm.plugin.appbrand.app.n.buL().aZ("@LibraryAppId", 0);
                    int i4 = ay.VERSION;
                    as.bvR();
                    break;
                case 6:
                    String trim = strArr.length > 2 ? strArr[2].trim() : null;
                    if (strArr.length > 3) {
                        i2 = Util.getInt(strArr[3].trim(), 0);
                    }
                    if (!TextUtils.isEmpty(trim)) {
                        com.tencent.mm.plugin.appbrand.app.n.buL().aZ(trim, i2);
                        break;
                    }
                    break;
                case 7:
                    ThreadPool.post(n.c.bvr(), "WxaPkgCleanupByCMD");
                    break;
                case '\b':
                    Log.i("PluginCodePruneLRULogic", "pluginCode lru cleanup!");
                    final AtomicBoolean atomicBoolean = new AtomicBoolean();
                    try {
                        ak.b(4194304, new ak.a() {
                            /* class com.tencent.mm.plugin.appbrand.b.AnonymousClass3 */

                            @Override // com.tencent.mm.plugin.appbrand.appcache.ak.a
                            public final boolean bqX() {
                                AppMethodBeat.i(43786);
                                boolean z = atomicBoolean.get();
                                AppMethodBeat.o(43786);
                                return z;
                            }
                        });
                        break;
                    } catch (InterruptedException e2) {
                        break;
                    }
                case '\t':
                    Log.i("MicroMsg.AppBrandTaskWxaCheckDemoInfoStorage", "checkdemoclean deleteAll!");
                    com.tencent.mm.plugin.appbrand.app.n.buG().byC();
                    break;
                case '\n':
                    com.tencent.mm.plugin.appbrand.config.y.XA(strArr[2]);
                    break;
                case 11:
                    if (Util.getInt(strArr[2].trim(), 0) > 0) {
                        z2 = true;
                    }
                    com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_APP_BRAND_SHOW_HISTORY_COUNT_BOOLEAN, Boolean.valueOf(z2));
                    break;
                case '\f':
                    com.tencent.mm.plugin.appbrand.config.y.Xz(strArr[2]);
                    break;
                case '\r':
                    aa.XD(strArr[2]);
                    break;
                case 14:
                    com.tencent.mm.plugin.appbrand.appusage.v.vY(Math.max(0, Util.getInt(strArr[2], 0)));
                    break;
                case 15:
                    com.tencent.mm.br.c.V(MMApplicationContext.getContext(), "appbrand", ".ui.AppBrandGuideUI");
                    break;
                case 16:
                    com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_APP_BRAND_USAGE_RECORD_HAS_HISTORY_BOOLEAN, Boolean.FALSE);
                    break;
                case 17:
                    try {
                        String str12 = strArr[2];
                        WxaAttributes.WxaVersionInfo wxaVersionInfo = new WxaAttributes.WxaVersionInfo();
                        wxaVersionInfo.appVersion = 1000;
                        wxaVersionInfo.lgS = "fake";
                        com.tencent.mm.plugin.appbrand.app.n.buL().a(str12, wxaVersionInfo);
                        break;
                    } catch (Exception e3) {
                        break;
                    }
                case 18:
                    bd bdVar2 = new bd();
                    bdVar2.field_appId = "wx4ffb369b6881ee5e";
                    bdVar2.field_version = 24;
                    bdVar2.field_versionMd5 = "a47b978d23679075cbbed1030f71b7bb";
                    bdVar2.field_debugType = 0;
                    bdVar2.field_pkgPath = "/sdcard/_276854502_24.wxapkg";
                    com.tencent.mm.plugin.appbrand.app.n.buL().f(bdVar2);
                    break;
                case 19:
                    bd bdVar3 = new bd();
                    bdVar3.field_appId = "wx4ffb369b6881ee5e";
                    bdVar3.field_version = 28;
                    bdVar3.field_versionMd5 = "5713e70880cc2d356905d6189ba37a72";
                    bdVar3.field_debugType = 0;
                    bdVar3.field_pkgPath = "/sdcard/_276854502_28.wxapkg";
                    com.tencent.mm.plugin.appbrand.app.n.buL().f(bdVar3);
                    break;
                case 20:
                    bd bdVar4 = new bd();
                    bdVar4.field_appId = "wx4ffb369b6881ee5e";
                    bdVar4.field_version = 28;
                    bdVar4.field_debugType = 0;
                    com.tencent.mm.plugin.appbrand.app.n.buL().a(bdVar4);
                    break;
                case 21:
                    bh buL2 = com.tencent.mm.plugin.appbrand.app.n.buL();
                    bd a2 = buL2.a("wx4ffb369b6881ee5e", 0, "version");
                    if (a2 != null) {
                        buL2.a(a2);
                        break;
                    }
                    break;
                case 22:
                    new u(Util.getInt(strArr[2], 78), strArr[3]).run();
                    break;
                case 23:
                    ay.bwc();
                    Toast.makeText(MMApplicationContext.getContext(), "MockLib已清除，重启微信生效", 1).show();
                    break;
                case 24:
                    if (strArr.length >= 3) {
                        ay.gI(strArr[2].trim().contentEquals("1"));
                        break;
                    }
                    break;
                case 25:
                    if (strArr.length < 3) {
                        com.tencent.mm.ui.base.u.cG(MMApplicationContext.getContext(), " 预载已禁用，即将重启微信...");
                        e.iG(true);
                        MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                            /* class com.tencent.mm.plugin.appbrand.b.AnonymousClass4 */

                            public final void run() {
                                AppMethodBeat.i(43787);
                                com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
                                Object obj = new Object();
                                com.tencent.mm.hellhoundlib.a.a.a(obj, a2.axQ(), "com/tencent/mm/plugin/appbrand/AppBrandCommand$4", "run", "()V", "java/lang/System_EXEC_", "exit", "(I)V");
                                System.exit(((Integer) a2.pG(0)).intValue());
                                com.tencent.mm.hellhoundlib.a.a.a(obj, "com/tencent/mm/plugin/appbrand/AppBrandCommand$4", "run", "()V", "java/lang/System_EXEC_", "exit", "(I)V");
                                AppMethodBeat.o(43787);
                            }
                        }, 2000);
                        break;
                    } else {
                        e.iG(strArr[2].trim().contentEquals("1"));
                        break;
                    }
                case 26:
                    com.tencent.mm.ui.base.u.cG(MMApplicationContext.getContext(), "已开启");
                    f.kIs.VQ().putBoolean("enable_pre_loading_rainbow", true);
                    break;
                case 27:
                    com.tencent.mm.ui.base.u.cG(MMApplicationContext.getContext(), "已关闭");
                    f.kIs.VQ().putBoolean("enable_pre_loading_rainbow", false);
                    break;
                case 28:
                    f.kIs.VQ().putBoolean("enable_pre_loading", false);
                    break;
                case 29:
                    f.kIs.VQ().putBoolean("enable_pre_loading", true);
                    break;
                case 30:
                    if (strArr.length >= 3) {
                        String str13 = strArr[2];
                        if (s.YS(str13)) {
                            String mD5Wrap = MD5JNI.getMD5Wrap(str13);
                            if (!TextUtils.isEmpty(mD5Wrap)) {
                                com.tencent.mm.plugin.appbrand.app.n.buL().a("wx5b3f21610c440402", 1, null, mD5Wrap, 0, 0);
                                com.tencent.mm.plugin.appbrand.app.n.buL().e("wx5b3f21610c440402", 1, 0, str13);
                                g gVar2 = new g();
                                gVar2.appId = "wx5b3f21610c440402";
                                gVar2.iOo = 1;
                                gVar2.scene = 1001;
                                ((r) com.tencent.mm.kernel.g.af(r.class)).a(context, gVar2);
                                break;
                            }
                        }
                    }
                    break;
                case 31:
                    if (strArr.length == 3) {
                        new com.tencent.mm.plugin.appbrand.appcache.predownload.b.h();
                        com.tencent.mm.plugin.appbrand.appcache.predownload.b.h.cx("", strArr[2]);
                        break;
                    }
                    break;
                case ' ':
                    f.kIs.VQ().putInt("pre_load_level", Integer.valueOf(strArr[2]).intValue());
                    break;
                case '!':
                    bd bdVar5 = new bd();
                    bdVar5.field_appId = new ad("wx32540bd863b27570", ModulePkgInfo.MAIN_MODULE_NAME, 4).toString();
                    bdVar5.field_version = 1170;
                    bdVar5.field_versionMd5 = "cf3f65adde418a69001fe285a37ad2ce";
                    bdVar5.field_NewMd5 = "b1d11357e7ae7ca9139f6a9641da26b0";
                    bdVar5.field_pkgPath = "/sdcard/enc.wxapkg";
                    com.tencent.mm.plugin.appbrand.app.n.buL().b(bdVar5);
                    break;
                case '\"':
                    bd bdVar6 = new bd();
                    bdVar6.field_appId = new ad("wx32540bd863b27570", ModulePkgInfo.MAIN_MODULE_NAME, 4).toString();
                    bdVar6.field_version = 1170;
                    bdVar6.field_versionMd5 = "cf3f65adde418a69001fe285a37ad2ce";
                    bdVar6.field_NewMd5 = "b1d11357e7ae7ca9139f6a9641da26b0";
                    bdVar6.field_pkgPath = "/sdcard/origin.wxapkg";
                    com.tencent.mm.plugin.appbrand.app.n.buL().b(bdVar6);
                    break;
                case '#':
                    try {
                        f.kIs.VQ().putBoolean("open_material_fake", "fake".equals(strArr[2]));
                        break;
                    } catch (Exception e4) {
                        break;
                    }
            }
            AppMethodBeat.o(43788);
        }
        return true;
    }
}
