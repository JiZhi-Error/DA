package com.tencent.mm.console;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Debug;
import android.text.TextUtils;
import android.util.Base64;
import android.widget.Toast;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.g.a.ku;
import com.tencent.mm.g.a.uq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cr;
import com.tencent.mm.modelmulti.p;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.performance.watchdogs.d;
import com.tencent.mm.plugin.textstatus.a.c;
import com.tencent.mm.recovery.ui.RecoveryUI;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.recovery.wx.service.WXRecoveryUploadService;
import com.tencent.sqlitelint.config.SharePluginInfo;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteDirectCursor;
import com.tencent.youtu.sdkkitframework.common.StateEvent;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public final class Shell {
    private static HashMap<String, a> gMF = new HashMap<>();
    private static IntentFilter gMG = new IntentFilter();
    private static Runnable gMH = new Runnable() {
        /* class com.tencent.mm.console.Shell.AnonymousClass35 */

        public final void run() {
            AppMethodBeat.i(231527);
            Log.d("MicroMsg.Shell", "dkcrash begin tid:%d [%s]", Long.valueOf(Thread.currentThread().getId()), Thread.currentThread().getName());
            String str = null;
            Log.d("MicroMsg.Shell", "%d ", Integer.valueOf(str.length()));
            AppMethodBeat.o(231527);
        }
    };
    private Receiver gME = null;

    public interface a {
        void s(Intent intent);
    }

    public interface b extends a {
    }

    static /* synthetic */ void aqL() {
    }

    static {
        AppMethodBeat.i(20168);
        a("wechat.shell.SET_NEXTRET", new a() {
            /* class com.tencent.mm.console.Shell.AnonymousClass1 */

            @Override // com.tencent.mm.console.Shell.a
            public final void s(Intent intent) {
                AppMethodBeat.i(20140);
                int intExtra = intent.getIntExtra("type", Integer.MAX_VALUE);
                int intExtra2 = intent.getIntExtra("error", 0);
                if (intExtra == Integer.MAX_VALUE || intExtra2 == 0) {
                    AppMethodBeat.o(20140);
                    return;
                }
                Log.w("MicroMsg.Shell", "kiro set Test.pushNextErrorRet(type=%d, err=%d)", Integer.valueOf(intExtra), Integer.valueOf(intExtra2));
                ac.dF(intExtra, intExtra2);
                AppMethodBeat.o(20140);
            }
        }, true);
        a("wechat.shell.SET_LOGLEVEL", new a() {
            /* class com.tencent.mm.console.Shell.AnonymousClass12 */

            @Override // com.tencent.mm.console.Shell.a
            public final void s(Intent intent) {
                AppMethodBeat.i(20153);
                int intExtra = intent.getIntExtra("level", 0);
                Log.w("MicroMsg.Shell", "kiro set Log.level=%d", Integer.valueOf(Log.getLogLevel()));
                Log.setLevel(intExtra, false);
                AppMethodBeat.o(20153);
            }
        }, true);
        a("wechat.shell.SET_CDNTRANS", new a() {
            /* class com.tencent.mm.console.Shell.AnonymousClass23 */

            @Override // com.tencent.mm.console.Shell.a
            public final void s(Intent intent) {
                AppMethodBeat.i(20157);
                ac.jOw = intent.getBooleanExtra("value", false);
                Log.w("MicroMsg.Shell", "kiro set Test.forceCDNTrans=%b", Boolean.valueOf(ac.jOw));
                AppMethodBeat.o(20157);
            }
        }, true);
        a("wechat.shell.SET_DKTEST", new a() {
            /* class com.tencent.mm.console.Shell.AnonymousClass34 */

            @Override // com.tencent.mm.console.Shell.a
            public final void s(Intent intent) {
                AppMethodBeat.i(20158);
                ac.jOC = Util.safeParseInt(intent.getStringExtra("key"));
                ac.jOD = Util.safeParseInt(intent.getStringExtra("val"));
                ac.jOE = intent.getStringExtra("str");
                Log.w("MicroMsg.Shell", "dkshell set [%d %d] [%s]", Integer.valueOf(ac.jOC), Integer.valueOf(ac.jOD), ac.jOE);
                if (10009 == ac.jOC) {
                    int i2 = ac.jOD;
                    Shell.aqL();
                    AppMethodBeat.o(20158);
                } else if (10014 != ac.jOC || !MMApplicationContext.isMMProcess()) {
                    if (10015 == ac.jOC) {
                        MMApplicationContext.isPushProcess();
                    }
                    AppMethodBeat.o(20158);
                } else {
                    p.bdS().a(7, 1, "");
                    AppMethodBeat.o(20158);
                }
            }
        }, true);
        a("wechat.shell.NET_DNS_TEST", new a() {
            /* class com.tencent.mm.console.Shell.AnonymousClass36 */

            @Override // com.tencent.mm.console.Shell.a
            public final void s(Intent intent) {
                AppMethodBeat.i(20159);
                ac.jOB = intent.getIntExtra("value", 0);
                Log.w("MicroMsg.Shell", "dkdnstd set Test.netDnsSimulateFault=%s", Integer.toBinaryString(ac.jOB));
                AppMethodBeat.o(20159);
            }
        }, true);
        a("wechat.shell.IDC_ERROR", new a() {
            /* class com.tencent.mm.console.Shell.AnonymousClass37 */

            @Override // com.tencent.mm.console.Shell.a
            public final void s(Intent intent) {
                AppMethodBeat.i(20160);
                ac.jOF = intent.getStringExtra("errmsg");
                Log.w("MicroMsg.Shell", "tiger set tigerIDCErrMsg =%s", ac.jOF);
                AppMethodBeat.o(20160);
            }
        }, true);
        a("wechat.shell.SET_DK_WT_TEST", new a() {
            /* class com.tencent.mm.console.Shell.AnonymousClass38 */

            @Override // com.tencent.mm.console.Shell.a
            public final void s(Intent intent) {
                AppMethodBeat.i(20161);
                ac.jOG = intent.getStringExtra("acc");
                ac.jOH = intent.getStringExtra(StateEvent.ActionValue.STAGE_PASS);
                Log.w("MicroMsg.Shell", "dkwt shell [%s %s]", ac.jOG, ac.jOH);
                AppMethodBeat.o(20161);
            }
        }, true);
        a("wechat.shell.SET_MUTE_ROOM_TEST", new a() {
            /* class com.tencent.mm.console.Shell.AnonymousClass39 */

            @Override // com.tencent.mm.console.Shell.a
            public final void s(Intent intent) {
                AppMethodBeat.i(20162);
                ac.jPk = intent.getIntExtra("flag", 0);
                Log.w("MicroMsg.Shell", "dkwt shell [%d]", Integer.valueOf(ac.jPk));
                AppMethodBeat.o(20162);
            }
        }, true);
        a("wechat.shell.HOTPATCH_TEST", new a() {
            /* class com.tencent.mm.console.Shell.AnonymousClass40 */

            @Override // com.tencent.mm.console.Shell.a
            public final void s(Intent intent) {
                AppMethodBeat.i(20163);
                ku kuVar = new ku();
                kuVar.dPP.dPU = intent.getExtras().getString("path", "/data/local/tmp/test.apk");
                Log.w("MicroMsg.Shell", "hotpatch test [%s]", kuVar.dPP.dPU);
                EventCenter.instance.publish(kuVar);
                AppMethodBeat.o(20163);
            }
        }, true);
        a("wechat.shell.EXEC_STATUSDB_SQL", new a() {
            /* class com.tencent.mm.console.Shell.AnonymousClass2 */

            @Override // com.tencent.mm.console.Shell.a
            public final void s(Intent intent) {
                AppMethodBeat.i(20143);
                String stringExtra = intent.getStringExtra(SharePluginInfo.ISSUE_KEY_SQL);
                if (stringExtra != null) {
                    ((c) g.ah(c.class)).execSQL(stringExtra);
                }
                AppMethodBeat.o(20143);
            }
        }, true);
        a("wechat.shell.EXEC_SQL", new a() {
            /* class com.tencent.mm.console.Shell.AnonymousClass3 */

            @Override // com.tencent.mm.console.Shell.a
            public final void s(Intent intent) {
                AppMethodBeat.i(20144);
                if (!MMApplicationContext.isMMProcess()) {
                    AppMethodBeat.o(20144);
                    return;
                }
                final String stringExtra = intent.getStringExtra(SharePluginInfo.ISSUE_KEY_SQL);
                final String stringExtra2 = intent.getStringExtra("file");
                if (stringExtra == null || stringExtra.length() <= 0) {
                    if (stringExtra2 != null && stringExtra2.length() > 0) {
                        g.aAk().postToWorker(new Runnable() {
                            /* class com.tencent.mm.console.Shell.AnonymousClass3.AnonymousClass2 */

                            /* JADX WARNING: Removed duplicated region for block: B:14:0x005e A[SYNTHETIC, Splitter:B:14:0x005e] */
                            /* JADX WARNING: Removed duplicated region for block: B:18:0x0067  */
                            /* JADX WARNING: Removed duplicated region for block: B:31:0x00b7 A[SYNTHETIC, Splitter:B:31:0x00b7] */
                            /* JADX WARNING: Removed duplicated region for block: B:35:0x00c0  */
                            /* JADX WARNING: Removed duplicated region for block: B:39:0x00cc A[SYNTHETIC, Splitter:B:39:0x00cc] */
                            /* JADX WARNING: Removed duplicated region for block: B:43:0x00d5  */
                            /* Code decompiled incorrectly, please refer to instructions dump. */
                            public final void run() {
                                /*
                                // Method dump skipped, instructions count: 248
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.console.Shell.AnonymousClass3.AnonymousClass2.run():void");
                            }
                        });
                    }
                    AppMethodBeat.o(20144);
                    return;
                }
                g.aAk().postToWorker(new Runnable() {
                    /* class com.tencent.mm.console.Shell.AnonymousClass3.AnonymousClass1 */

                    public final void run() {
                        Cursor cursor = null;
                        AppMethodBeat.i(231507);
                        SQLiteDatabase gFH = g.aAh().hqK.gFH();
                        try {
                            long currentTimeMillis = System.currentTimeMillis();
                            com.tencent.wcdb.Cursor rawQueryWithFactory = gFH.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, stringExtra, null, null);
                            String[] columnNames = rawQueryWithFactory.getColumnNames();
                            int length = columnNames == null ? 0 : columnNames.length;
                            Log.i("MicroMsg.Shell", "Executing SQL from shell: " + stringExtra);
                            if (length > 0) {
                                Log.i("MicroMsg.Shell", " > " + TextUtils.join(APLogFileUtil.SEPARATOR_LOG, columnNames));
                            }
                            StringBuilder sb = new StringBuilder(1024);
                            while (rawQueryWithFactory.moveToNext()) {
                                sb.setLength(0);
                                sb.append(" > ");
                                for (int i2 = 0; i2 < length; i2++) {
                                    switch (rawQueryWithFactory.getType(i2)) {
                                        case 0:
                                            sb.append("(null)");
                                            break;
                                        case 4:
                                            sb.append("(blob)");
                                            break;
                                        default:
                                            sb.append(rawQueryWithFactory.getString(i2));
                                            break;
                                    }
                                    sb.append(APLogFileUtil.SEPARATOR_LOG);
                                }
                                Log.i("MicroMsg.Shell", sb.toString());
                            }
                            Log.i("MicroMsg.Shell", "Finish executing SQL in %d ms: %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), stringExtra);
                            if (rawQueryWithFactory != null) {
                                rawQueryWithFactory.close();
                                AppMethodBeat.o(231507);
                                return;
                            }
                        } catch (RuntimeException e2) {
                            Log.e("MicroMsg.Shell", "Failed to execute SQL '%s': %s", stringExtra, e2.getMessage());
                            if (0 != 0) {
                                cursor.close();
                                AppMethodBeat.o(231507);
                                return;
                            }
                        } catch (Throwable th) {
                            if (0 != 0) {
                                cursor.close();
                            }
                            AppMethodBeat.o(231507);
                            throw th;
                        }
                        AppMethodBeat.o(231507);
                    }
                });
                AppMethodBeat.o(20144);
            }
        }, true);
        a("wechat.shell.GC", new a() {
            /* class com.tencent.mm.console.Shell.AnonymousClass4 */

            @Override // com.tencent.mm.console.Shell.a
            public final void s(Intent intent) {
                AppMethodBeat.i(20145);
                Runtime.getRuntime().gc();
                Toast.makeText(MMApplicationContext.getContext(), "trigger gc...", 0).show();
                AppMethodBeat.o(20145);
            }
        }, true);
        a("wechat.shell.DUMP_HPROF", new b() {
            /* class com.tencent.mm.console.Shell.AnonymousClass5 */

            @Override // com.tencent.mm.console.Shell.a
            public final void s(Intent intent) {
                AppMethodBeat.i(20146);
                if (WeChatEnvironment.hasDebugger() || WeChatEnvironment.isMonkeyEnv()) {
                    Runtime.getRuntime().gc();
                    String stringExtra = intent.getStringExtra("process_suffix");
                    if (Util.isNullOrNil(stringExtra)) {
                        if (!MMApplicationContext.isMMProcess()) {
                            AppMethodBeat.o(20146);
                            return;
                        }
                    } else if (!stringExtra.startsWith(":")) {
                        Log.e("MicroMsg.Shell", "bad process suffix: %s", stringExtra);
                        AppMethodBeat.o(20146);
                        return;
                    } else if (!MMApplicationContext.getProcessName().endsWith(stringExtra)) {
                        AppMethodBeat.o(20146);
                        return;
                    }
                    o oVar = new o(com.tencent.mm.loader.j.b.aKJ() + "hprofs");
                    if (!oVar.exists()) {
                        oVar.mkdirs();
                    }
                    try {
                        Debug.dumpHprofData(aa.z(new o(oVar, MMApplicationContext.getProcessName().replace(".", "_").replace(":", "_") + "_" + new SimpleDateFormat("yyyyMMddHHmmss", Locale.getDefault()).format(new Date()) + ".hprof").her()));
                        Toast.makeText(MMApplicationContext.getContext(), "Done.", 1).show();
                        AppMethodBeat.o(20146);
                    } catch (IOException e2) {
                        Log.printErrStackTrace("MicroMsg.Shell", e2, "dump hprof failed.", new Object[0]);
                        Toast.makeText(MMApplicationContext.getContext(), "Failure.", 1).show();
                        AppMethodBeat.o(20146);
                    }
                } else {
                    Log.e("MicroMsg.Shell", "not coolassist or monkey env, disable hprof dump cmd.");
                    AppMethodBeat.o(20146);
                }
            }
        }, true);
        a("wechat.shell.HOOK_ALL", new a() {
            /* class com.tencent.mm.console.Shell.AnonymousClass6 */

            @Override // com.tencent.mm.console.Shell.a
            public final void s(Intent intent) {
                AppMethodBeat.i(20147);
                if (WeChatEnvironment.hasDebugger() || WeChatEnvironment.isMonkeyEnv()) {
                    com.tencent.mm.plugin.performance.a.a.INSTANCE.aJQ("<cmd><diagnostic><MemoryHook enable='1' source='push' multiprocess='0' duration='24' hook='.*\\.so$' stack='0' min='0' max='0' force='1' enableExpt='0' sampling='1'/></diagnostic></cmd>");
                    Toast.makeText(MMApplicationContext.getContext(), "Hook ALL .*\\.so", 0).show();
                    AppMethodBeat.o(20147);
                    return;
                }
                Log.e("MicroMsg.Shell", "Environment denied: not coolassist or monkey env");
                AppMethodBeat.o(20147);
            }
        }, true);
        a("wechat.shell.HOOK_MM", new a() {
            /* class com.tencent.mm.console.Shell.AnonymousClass7 */

            @Override // com.tencent.mm.console.Shell.a
            public final void s(Intent intent) {
                AppMethodBeat.i(20148);
                if (WeChatEnvironment.hasDebugger() || WeChatEnvironment.isMonkeyEnv()) {
                    com.tencent.mm.plugin.performance.a.a.INSTANCE.aJQ("<cmd><diagnostic><MemoryHook\n enable='1' source='push' multiprocess='0' duration='24' hook='" + (BuildInfo.IS_FLAVOR_RED ? ".*com\\.tencent\\.mm.*\\.so$;.*libhwui\\.so$;.*libEGL\\.so$;.*libGLES.*\\.so$" : ".*com\\.tencent\\.mm.*\\.so$") + "' stack='0' min='0' max='0' force='1' enableExpt='0' sampling='1' mmap='1'/></diagnostic></cmd>");
                    Toast.makeText(MMApplicationContext.getContext(), "Hook MM so", 0).show();
                    AppMethodBeat.o(20148);
                    return;
                }
                Log.e("MicroMsg.Shell", "Environment denied: not coolassist or monkey env");
                AppMethodBeat.o(20148);
            }
        }, true);
        a("wechat.shell.HOOK_DISABLE", new a() {
            /* class com.tencent.mm.console.Shell.AnonymousClass8 */

            @Override // com.tencent.mm.console.Shell.a
            public final void s(Intent intent) {
                AppMethodBeat.i(20149);
                if (WeChatEnvironment.hasDebugger() || WeChatEnvironment.isMonkeyEnv()) {
                    com.tencent.mm.plugin.performance.a.a.INSTANCE.aJQ("<cmd><diagnostic><MemoryHook enable='0' source='push' enableExpt='0' force='1'/></diagnostic></cmd>");
                    Toast.makeText(MMApplicationContext.getContext(), "Hook Disable", 0).show();
                    AppMethodBeat.o(20149);
                    return;
                }
                Log.e("MicroMsg.Shell", "Environment denied: not coolassist or monkey env");
                AppMethodBeat.o(20149);
            }
        }, true);
        a("wechat.shell.HOOK_REPORT", new a() {
            /* class com.tencent.mm.console.Shell.AnonymousClass9 */

            @Override // com.tencent.mm.console.Shell.a
            public final void s(Intent intent) {
                AppMethodBeat.i(20150);
                if (WeChatEnvironment.hasDebugger() || WeChatEnvironment.isMonkeyEnv()) {
                    com.tencent.mm.plugin.performance.a.a.INSTANCE.aJQ("<cmd><diagnostic><report><memory/></report></diagnostic></cmd>");
                    Toast.makeText(MMApplicationContext.getContext(), "Hook report", 0).show();
                    AppMethodBeat.o(20150);
                    return;
                }
                Log.e("MicroMsg.Shell", "Environment denied: not coolassist or monkey env");
                AppMethodBeat.o(20150);
            }
        }, true);
        a("wechat.shell.MEMORY_HOOK", new a() {
            /* class com.tencent.mm.console.Shell.AnonymousClass10 */

            @Override // com.tencent.mm.console.Shell.a
            public final void s(Intent intent) {
                AppMethodBeat.i(20151);
                if (WeChatEnvironment.hasDebugger() || WeChatEnvironment.isMonkeyEnv()) {
                    String str = "<cmd><diagnostic><MemoryHook enable='" + Shell.ak(intent.getStringExtra("enable"), AppEventsConstants.EVENT_PARAM_VALUE_NO) + "' source='push' multiprocess='" + Shell.ak(intent.getStringExtra("multiprocess"), AppEventsConstants.EVENT_PARAM_VALUE_NO) + "' duration='" + Shell.ak(intent.getStringExtra(FFmpegMetadataRetriever.METADATA_KEY_DURATION), "1") + "' hook='" + Shell.ak(intent.getStringExtra("hook"), ".*com\\.tencent\\.mm.*\\.so$") + "' ignore='" + Shell.ak(intent.getStringExtra("ignore"), "") + "' stack='" + Shell.ak(intent.getStringExtra(SharePluginInfo.ISSUE_KEY_STACK), AppEventsConstants.EVENT_PARAM_VALUE_NO) + "' min='" + Shell.ak(intent.getStringExtra("min"), AppEventsConstants.EVENT_PARAM_VALUE_NO) + "' max='" + Shell.ak(intent.getStringExtra("max"), AppEventsConstants.EVENT_PARAM_VALUE_NO) + "' force='" + Shell.ak(intent.getStringExtra("force"), AppEventsConstants.EVENT_PARAM_VALUE_NO) + "' sampling='" + Shell.ak(intent.getStringExtra("sampling"), "1") + "' extreme='" + Shell.ak(intent.getStringExtra("extreme"), AppEventsConstants.EVENT_PARAM_VALUE_NO) + "' mmap='" + Shell.ak(intent.getStringExtra("mmap"), AppEventsConstants.EVENT_PARAM_VALUE_NO) + "'/></diagnostic></cmd>";
                    com.tencent.mm.plugin.performance.a.a.INSTANCE.aJQ(str);
                    Toast.makeText(MMApplicationContext.getContext(), str, 0).show();
                    AppMethodBeat.o(20151);
                    return;
                }
                Log.e("MicroMsg.Shell", "Environment denied: not coolassist or monkey env");
                AppMethodBeat.o(20151);
            }
        }, true);
        a("wechat.shell." + com.tencent.mm.plugin.performance.a.b.aJR(""), new a() {
            /* class com.tencent.mm.console.Shell.AnonymousClass11 */

            @Override // com.tencent.mm.console.Shell.a
            public final void s(Intent intent) {
                AppMethodBeat.i(20152);
                com.tencent.mm.plugin.performance.a.a.INSTANCE.aJQ("<cmd><diagnostic>" + String.format("<fetch target='%s' network='any' />", com.tencent.mm.plugin.performance.a.b.aJR("©¥¶£ê¯¥§»")) + "</diagnostic></cmd>");
                Toast.makeText(MMApplicationContext.getContext(), "Diag op1 triggered.", 1).show();
                AppMethodBeat.o(20152);
            }
        }, true);
        a("wechat.shell." + com.tencent.mm.plugin.performance.a.b.aJR(""), new a() {
            /* class com.tencent.mm.console.Shell.AnonymousClass13 */

            @Override // com.tencent.mm.console.Shell.a
            public final void s(Intent intent) {
                AppMethodBeat.i(20154);
                com.tencent.mm.plugin.performance.a.a.INSTANCE.aJQ("<cmd><diagnostic>" + String.format("<fetch target='%s' network='any' />", com.tencent.mm.plugin.performance.a.b.aJR("©¥¶£ê¶¥§»")) + "</diagnostic></cmd>");
                Toast.makeText(MMApplicationContext.getContext(), "Diag op2 triggered.", 1).show();
                AppMethodBeat.o(20154);
            }
        }, true);
        a("wechat.shell." + com.tencent.mm.plugin.performance.a.b.aJR(""), new a() {
            /* class com.tencent.mm.console.Shell.AnonymousClass14 */

            @Override // com.tencent.mm.console.Shell.a
            public final void s(Intent intent) {
                AppMethodBeat.i(20155);
                String nullAsNil = Util.nullAsNil(intent.getStringExtra("name_regex"));
                com.tencent.mm.plugin.performance.a.a.INSTANCE.aJQ("<cmd><diagnostic>" + String.format("<fetch target='%s' name_regex='%s' network='any' />", com.tencent.mm.plugin.performance.a.b.aJR("§§´¥ì±¬"), nullAsNil) + "</diagnostic></cmd>");
                Toast.makeText(MMApplicationContext.getContext(), "Diag op3 triggered.", 1).show();
                AppMethodBeat.o(20155);
            }
        }, true);
        a("wechat.shell." + com.tencent.mm.plugin.performance.a.b.aJR(""), new a() {
            /* class com.tencent.mm.console.Shell.AnonymousClass15 */

            @Override // com.tencent.mm.console.Shell.a
            public final void s(Intent intent) {
                AppMethodBeat.i(231509);
                String nullAsNil = Util.nullAsNil(intent.getStringExtra("process"));
                com.tencent.mm.plugin.performance.a.a.INSTANCE.aJQ("<cmd><diagnostic>" + String.format("<fetch target='%s' process='%s' network='any' />", com.tencent.mm.plugin.performance.a.b.aJR("­ ²°"), nullAsNil) + "</diagnostic></cmd>");
                Toast.makeText(MMApplicationContext.getContext(), "Diag op4 triggered.", 1).show();
                AppMethodBeat.o(231509);
            }
        }, true);
        a("wechat.shell." + com.tencent.mm.plugin.performance.a.b.aJR(""), new a() {
            /* class com.tencent.mm.console.Shell.AnonymousClass16 */

            @Override // com.tencent.mm.console.Shell.a
            public final void s(Intent intent) {
                AppMethodBeat.i(231510);
                String nullAsNil = Util.nullAsNil(intent.getStringExtra("process"));
                com.tencent.mm.plugin.performance.a.a.INSTANCE.aJQ("<cmd><diagnostic>" + String.format("<fetch target='%s' process='%s' network='any' />", com.tencent.mm.plugin.performance.a.b.aJR("´­ ²°"), nullAsNil) + "</diagnostic></cmd>");
                Toast.makeText(MMApplicationContext.getContext(), "Diag op5 triggered.", 1).show();
                AppMethodBeat.o(231510);
            }
        }, true);
        a("wechat.shell.RECOVERY_LAUNCH_UI", new a() {
            /* class com.tencent.mm.console.Shell.AnonymousClass17 */

            @Override // com.tencent.mm.console.Shell.a
            @SuppressLint({"VisibleForTests"})
            public final void s(Intent intent) {
                AppMethodBeat.i(231511);
                if (WeChatEnvironment.hasDebugger() || WeChatEnvironment.isMonkeyEnv()) {
                    Log.i("MicroMsg.Shell", "#RECOVERY_LAUNCH_UI");
                    Intent intent2 = new Intent(MMApplicationContext.getContext(), RecoveryUI.class);
                    intent2.addFlags(268435456);
                    intent2.putExtra("extra_crash_count", 3);
                    Context context = MMApplicationContext.getContext();
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
                    com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/console/Shell$24", "exec", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    context.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/console/Shell$24", "exec", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    AppMethodBeat.o(231511);
                    return;
                }
                Log.e("MicroMsg.Shell", "Environment denied: not coolassist or monkey env");
                AppMethodBeat.o(231511);
            }
        }, true);
        a("wechat.shell.RECOVERY_FETCH_PATCH", new a() {
            /* class com.tencent.mm.console.Shell.AnonymousClass18 */

            @Override // com.tencent.mm.console.Shell.a
            @SuppressLint({"VisibleForTests"})
            public final void s(Intent intent) {
                AppMethodBeat.i(231512);
                if (WeChatEnvironment.hasDebugger() || WeChatEnvironment.isMonkeyEnv()) {
                    String stringExtra = intent.getStringExtra("fetch_base_id");
                    if (TextUtils.isEmpty(stringExtra)) {
                        Log.e("MicroMsg.Shell", "base id is empty, abort");
                        Toast.makeText(MMApplicationContext.getContext(), "base id is empty, abort", 1).show();
                        AppMethodBeat.o(231512);
                        return;
                    }
                    Log.i("MicroMsg.Shell", "#RECOVERY_FETCH_PATCH, baseId = ".concat(String.valueOf(stringExtra)));
                    WXRecoveryUploadService.fetchTinkerPatch(MMApplicationContext.getContext(), stringExtra);
                    AppMethodBeat.o(231512);
                    return;
                }
                Log.e("MicroMsg.Shell", "Environment denied: not coolassist or monkey env");
                AppMethodBeat.o(231512);
            }
        }, true);
        a("wechat.shell.THREAD_HOOK", new a() {
            /* class com.tencent.mm.console.Shell.AnonymousClass19 */

            @Override // com.tencent.mm.console.Shell.a
            public final void s(Intent intent) {
                AppMethodBeat.i(231513);
                com.tencent.mm.plugin.performance.a.a.INSTANCE.aJQ("<cmd><diagnostic><PthreadHook enable='1' source='push' multiprocess='0' duration='24' hook='.*\\.so$' force='1' thread='.*'/></diagnostic></cmd>");
                Toast.makeText(MMApplicationContext.getContext(), "PthreadHook enable", 1).show();
                AppMethodBeat.o(231513);
            }
        }, true);
        a("wechat.shell.THREAD_DUMP", new a() {
            /* class com.tencent.mm.console.Shell.AnonymousClass20 */

            @Override // com.tencent.mm.console.Shell.a
            public final void s(Intent intent) {
                AppMethodBeat.i(231514);
                com.tencent.mm.plugin.performance.a.a.INSTANCE.aJQ("<cmd><diagnostic><report><pthread/></report></diagnostic></cmd>");
                Toast.makeText(MMApplicationContext.getContext(), "PthreadHook report", 1).show();
                AppMethodBeat.o(231514);
            }
        }, true);
        a("wechat.shell.FINDER_SHELL", new a() {
            /* class com.tencent.mm.console.Shell.AnonymousClass21 */

            @Override // com.tencent.mm.console.Shell.a
            public final void s(Intent intent) {
                AppMethodBeat.i(231515);
                uq uqVar = new uq();
                uqVar.eaT.action = "wechat.shell.FINDER_SHELL";
                uqVar.eaT.intent = intent;
                EventCenter.instance.publish(uqVar);
                AppMethodBeat.o(231515);
            }
        }, true);
        a("wechat.shell.WATCH_MEM", new a() {
            /* class com.tencent.mm.console.Shell.AnonymousClass22 */

            @Override // com.tencent.mm.console.Shell.a
            public final void s(Intent intent) {
                AppMethodBeat.i(231516);
                com.tencent.mm.plugin.performance.watchdogs.c.eCH().eCL();
                AppMethodBeat.o(231516);
            }
        }, true);
        a("wechat.shell.WATCH_PROC", new a() {
            /* class com.tencent.mm.console.Shell.AnonymousClass24 */

            @Override // com.tencent.mm.console.Shell.a
            public final void s(Intent intent) {
                AppMethodBeat.i(231517);
                Log.d("MicroMsg.ProcessWatchDog", "DumpProcesses: %s", Arrays.toString(d.eCN().eCO().toArray()));
                AppMethodBeat.o(231517);
            }
        }, true);
        a("wechat.shell.MOVE_XLOG", new a() {
            /* class com.tencent.mm.console.Shell.AnonymousClass25 */
            boolean gMK = false;

            @Override // com.tencent.mm.console.Shell.a
            public final void s(Intent intent) {
                AppMethodBeat.i(231518);
                if (this.gMK) {
                    Toast.makeText(MMApplicationContext.getContext(), "xlog had moved.", 0).show();
                    AppMethodBeat.o(231518);
                    return;
                }
                Log.i("MicroMsg.Shell", "action: wechat.shell.PULL_XLOG");
                Toast.makeText(MMApplicationContext.getContext(), "start to move xlog.", 0).show();
                Log.moveLogsFromCacheDirToLogDir();
                Toast.makeText(MMApplicationContext.getContext(), "xlog move success", 0).show();
                this.gMK = true;
                AppMethodBeat.o(231518);
            }
        }, false);
        a("wechat.shell.OpenWeApp", new a() {
            /* class com.tencent.mm.console.Shell.AnonymousClass26 */

            @Override // com.tencent.mm.console.Shell.a
            public final void s(Intent intent) {
                AppMethodBeat.i(231519);
                if (!WeChatEnvironment.hasDebugger() && !WeChatEnvironment.isMonkeyEnv()) {
                    Log.e("MicroMsg.Shell", "OpenWeApp not coolassist or monkey env, disable hprof dump cmd.");
                    AppMethodBeat.o(231519);
                } else if (!MMApplicationContext.isMMProcess()) {
                    AppMethodBeat.o(231519);
                } else {
                    String stringExtra = intent.getStringExtra("kContent");
                    if (Util.isNullOrNil(stringExtra)) {
                        AppMethodBeat.o(231519);
                        return;
                    }
                    Map<String, String> parseXml = XmlParser.parseXml(new String(Base64.decode(stringExtra, 0)), "sysmsg", null);
                    if (parseXml == null) {
                        AppMethodBeat.o(231519);
                        return;
                    }
                    int i2 = Util.getInt(parseXml.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.VersionType"), 0);
                    int i3 = Util.getInt(parseXml.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.AppVersion"), 0);
                    com.tencent.mm.plugin.appbrand.api.g gVar = new com.tencent.mm.plugin.appbrand.api.g();
                    gVar.appId = parseXml.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.AppID");
                    gVar.username = parseXml.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.UserName");
                    gVar.iOo = i2;
                    gVar.version = i3;
                    gVar.kHw = parseXml.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.Path");
                    gVar.scene = 1030;
                    ((r) g.af(r.class)).a(MMApplicationContext.getContext(), gVar);
                    AppMethodBeat.o(231519);
                }
            }
        }, true);
        a("wechat.shell.FINDER_VIDEO_TEST", new a() {
            /* class com.tencent.mm.console.Shell.AnonymousClass27 */

            @Override // com.tencent.mm.console.Shell.a
            public final void s(Intent intent) {
                AppMethodBeat.i(231520);
                uq uqVar = new uq();
                uqVar.eaT.action = "wechat.shell.FINDER_VIDEO_TEST";
                uqVar.eaT.intent = intent;
                EventCenter.instance.publish(uqVar);
                AppMethodBeat.o(231520);
            }
        }, true);
        a("wechat.shell.DUMP_MAPS", new b() {
            /* class com.tencent.mm.console.Shell.AnonymousClass28 */

            /* JADX WARNING: Removed duplicated region for block: B:33:0x00fd A[SYNTHETIC, Splitter:B:33:0x00fd] */
            /* JADX WARNING: Removed duplicated region for block: B:36:0x0102 A[SYNTHETIC, Splitter:B:36:0x0102] */
            /* JADX WARNING: Removed duplicated region for block: B:52:0x0129 A[SYNTHETIC, Splitter:B:52:0x0129] */
            /* JADX WARNING: Removed duplicated region for block: B:55:0x012e A[SYNTHETIC, Splitter:B:55:0x012e] */
            /* JADX WARNING: Removed duplicated region for block: B:59:0x0135  */
            @Override // com.tencent.mm.console.Shell.a
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void s(android.content.Intent r10) {
                /*
                // Method dump skipped, instructions count: 334
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.console.Shell.AnonymousClass28.s(android.content.Intent):void");
            }
        }, true);
        a("wechat.shell.BRANDS_XID", new a() {
            /* class com.tencent.mm.console.Shell.AnonymousClass29 */

            @Override // com.tencent.mm.console.Shell.a
            @SuppressLint({"VisibleForTests"})
            public final void s(Intent intent) {
                AppMethodBeat.i(231522);
                if (WeChatEnvironment.hasDebugger() || WeChatEnvironment.isMonkeyEnv()) {
                    Bundle extras = intent.getExtras();
                    if (extras == null) {
                        Log.e("MicroMsg.Shell", "extras is null");
                        AppMethodBeat.o(231522);
                        return;
                    }
                    int parseInt = Integer.parseInt(String.valueOf(extras.get("set_xid")));
                    Log.i("MicroMsg.Shell", "#BRANDS_XID, set_xid = ".concat(String.valueOf(parseInt)));
                    if (parseInt >= 0) {
                        cr.d.sw(parseInt);
                    }
                    AppMethodBeat.o(231522);
                    return;
                }
                Log.e("MicroMsg.Shell", "Environment denied: not coolassist or monkey env");
                AppMethodBeat.o(231522);
            }
        }, true);
        a("wechat.shell.BRANDS_BIZ", new a() {
            /* class com.tencent.mm.console.Shell.AnonymousClass30 */

            @Override // com.tencent.mm.console.Shell.a
            @SuppressLint({"VisibleForTests"})
            public final void s(Intent intent) {
                AppMethodBeat.i(231523);
                if (WeChatEnvironment.hasDebugger() || WeChatEnvironment.isMonkeyEnv()) {
                    Bundle extras = intent.getExtras();
                    if (extras == null) {
                        Log.e("MicroMsg.Shell", "extras is null");
                        AppMethodBeat.o(231523);
                        return;
                    }
                    Log.i("MicroMsg.Shell", "#BRANDS_BIZ");
                    for (String str : extras.keySet()) {
                        if (str.startsWith("set_biz_") && str.length() > 8) {
                            String substring = str.substring(str.indexOf("set_biz_") + 8);
                            int parseInt = Integer.parseInt(String.valueOf(extras.get(str)));
                            Log.i("MicroMsg.Shell", "#BRANDS_BIZ, set " + substring + " = " + parseInt);
                            cr.d.am(substring, parseInt);
                        }
                    }
                    AppMethodBeat.o(231523);
                    return;
                }
                Log.e("MicroMsg.Shell", "Environment denied: not coolassist or monkey env");
                AppMethodBeat.o(231523);
            }
        }, true);
        a("wechat.shell.BRANDS_CLEAR", new a() {
            /* class com.tencent.mm.console.Shell.AnonymousClass31 */

            @Override // com.tencent.mm.console.Shell.a
            @SuppressLint({"VisibleForTests"})
            public final void s(Intent intent) {
                AppMethodBeat.i(231524);
                if (WeChatEnvironment.hasDebugger() || WeChatEnvironment.isMonkeyEnv()) {
                    Log.i("MicroMsg.Shell", "#BRANDS_CLEAR");
                    cr.d.clearAll();
                    AppMethodBeat.o(231524);
                    return;
                }
                Log.e("MicroMsg.Shell", "Environment denied: not coolassist or monkey env");
                AppMethodBeat.o(231524);
            }
        }, true);
        a("wechat.shell.BRANDS_DUMP", new a() {
            /* class com.tencent.mm.console.Shell.AnonymousClass32 */

            @Override // com.tencent.mm.console.Shell.a
            @SuppressLint({"VisibleForTests"})
            public final void s(Intent intent) {
                AppMethodBeat.i(231525);
                if (WeChatEnvironment.hasDebugger() || WeChatEnvironment.isMonkeyEnv()) {
                    Log.i("MicroMsg.Shell", "#BRANDS_DUMP");
                    cr.d.aWO();
                    AppMethodBeat.o(231525);
                    return;
                }
                Log.e("MicroMsg.Shell", "Environment denied: not coolassist or monkey env");
                AppMethodBeat.o(231525);
            }
        }, true);
        a("wechat.shell.WATCH_FD", new a() {
            /* class com.tencent.mm.console.Shell.AnonymousClass33 */

            @Override // com.tencent.mm.console.Shell.a
            public final void s(Intent intent) {
                AppMethodBeat.i(231526);
                if (WeChatEnvironment.hasDebugger() || WeChatEnvironment.isMonkeyEnv()) {
                    com.tencent.mm.plugin.performance.watchdogs.a.eCE().run();
                    AppMethodBeat.o(231526);
                    return;
                }
                Log.e("MicroMsg.Shell", "Environment denied: not coolassist or monkey env");
                AppMethodBeat.o(231526);
            }
        }, true);
        AppMethodBeat.o(20168);
    }

    private static void a(String str, a aVar, boolean z) {
        AppMethodBeat.i(231528);
        if (!z || WeChatEnvironment.hasDebugger()) {
            gMG.addAction(str);
            gMF.put(str, aVar);
        }
        AppMethodBeat.o(231528);
    }

    public static class Receiver extends BroadcastReceiver {
        public void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(20164);
            String action = intent.getAction();
            a aVar = (a) Shell.gMF.get(action);
            if (aVar == null) {
                Log.e("MicroMsg.Shell", "no action found for %s", action);
                AppMethodBeat.o(20164);
            } else if (MMApplicationContext.isMainProcess() || (aVar instanceof b)) {
                Log.e("MicroMsg.Shell", "shell action %s", action);
                aVar.s(intent);
                AppMethodBeat.o(20164);
            } else {
                Log.e("MicroMsg.Shell", "action[%s] can only run in mm process", action);
                AppMethodBeat.o(20164);
            }
        }
    }

    public final void init(Context context) {
        AppMethodBeat.i(20166);
        if (this.gME == null) {
            this.gME = new Receiver();
            context.registerReceiver(this.gME, gMG, WeChatEnvironment.hasDebugger() ? null : "com.tencent.mm.permission.MOVE_XLOG", null);
        }
        AppMethodBeat.o(20166);
    }

    static /* synthetic */ String ak(String str, String str2) {
        AppMethodBeat.i(20167);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(20167);
            return str2;
        }
        AppMethodBeat.o(20167);
        return str;
    }
}
