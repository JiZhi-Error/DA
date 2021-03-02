package com.tencent.mm.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.ag;
import com.tencent.mm.co.a;
import com.tencent.mm.g.a.po;
import com.tencent.mm.g.a.pp;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.a.b;
import com.tencent.mm.kernel.a.c;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.sdcard_migrate.ExtStorageMigrateMonitor;
import com.tencent.mm.sdcard_migrate.ExtStorageMigrateRoutine;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.PeriodRecorder;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.splash.e;
import com.tencent.mm.splash.m;
import com.tencent.mm.splash.o;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.vending.h.d;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.z;
import com.tencent.recovery.wx.util.WXUtil;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.tinker.entry.ApplicationLifeCycle;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Stack;
import java.util.concurrent.TimeUnit;

public class WeChatSplashStartup implements m.a {
    private Application app;
    h profile;
    private String thisProcess;

    @Override // com.tencent.mm.splash.m.a
    public final void a(Application application, String str) {
        AppMethodBeat.i(160088);
        this.app = application;
        this.thisProcess = str;
        this.profile = aj.dmN;
        g.a(this.profile);
        h hVar = this.profile;
        hVar.htA.a(new a.AbstractC0297a<ApplicationLifeCycle>(this.app) {
            /* class com.tencent.mm.kernel.b.h.AnonymousClass6 */
            final /* synthetic */ Context val$context;

            {
                this.val$context = r2;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.co.a.AbstractC0297a
            public final /* synthetic */ void bw(ApplicationLifeCycle applicationLifeCycle) {
                AppMethodBeat.i(132218);
                applicationLifeCycle.onBaseContextAttached(this.val$context);
                AppMethodBeat.o(132218);
            }
        });
        AppMethodBeat.o(160088);
    }

    @Override // com.tencent.mm.splash.m.a
    public final void a(o.a aVar) {
        AppMethodBeat.i(160089);
        b(aVar);
        AppMethodBeat.o(160089);
    }

    @Override // com.tencent.mm.splash.m.a
    public final void WW() {
        AppMethodBeat.i(160090);
        b((o.a) null);
        AppMethodBeat.o(160090);
    }

    private void b(final o.a aVar) {
        b bVar;
        AppMethodBeat.i(160091);
        com.tencent.mm.f.a.bT(this.app);
        com.tencent.mm.blink.a.nO(2);
        final boolean z = aVar == null;
        this.profile.onCreate();
        if (this.profile.FY(":tools") || this.profile.FY(":toolsmp")) {
            bVar = new ah();
        } else if (this.profile.FZ(":appbrand")) {
            bVar = new c();
        } else {
            bVar = new i();
        }
        this.profile.hqy.a(bVar);
        if (!z) {
            com.tencent.mm.splash.h.gyi();
            new IListener<po>() {
                /* class com.tencent.mm.app.WeChatSplashStartup.AnonymousClass1 */

                {
                    AppMethodBeat.i(161817);
                    this.__eventId = po.class.getName().hashCode();
                    AppMethodBeat.o(161817);
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
                @Override // com.tencent.mm.sdk.event.IListener
                public final /* synthetic */ boolean callback(po poVar) {
                    AppMethodBeat.i(160059);
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        /* class com.tencent.mm.app.WeChatSplashStartup.AnonymousClass1.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(160127);
                            Log.i("MicroMsg.WeChatSplashStartup", "Replay pending messages, so early.");
                            y.WG();
                            AppMethodBeat.o(160127);
                        }
                    });
                    dead();
                    AppMethodBeat.o(160059);
                    return false;
                }
            }.alive();
            new IListener<pp>() {
                /* class com.tencent.mm.app.WeChatSplashStartup.AnonymousClass3 */

                {
                    AppMethodBeat.i(161818);
                    this.__eventId = pp.class.getName().hashCode();
                    AppMethodBeat.o(161818);
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
                @Override // com.tencent.mm.sdk.event.IListener
                public final /* synthetic */ boolean callback(pp ppVar) {
                    AppMethodBeat.i(160138);
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        /* class com.tencent.mm.app.WeChatSplashStartup.AnonymousClass3.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(160136);
                            Log.i("MicroMsg.WeChatSplashStartup", "Replay pending messages.");
                            aVar.gyr();
                            AppMethodBeat.o(160136);
                        }
                    });
                    dead();
                    AppMethodBeat.o(160138);
                    return false;
                }
            }.alive();
        }
        g.aAi().a(cP(z));
        com.tencent.mm.splash.h.a(new e() {
            /* class com.tencent.mm.app.WeChatSplashStartup.AnonymousClass4 */
            com.tencent.mm.ui.o dmS = new com.tencent.mm.ui.o();

            {
                AppMethodBeat.i(160064);
                AppMethodBeat.o(160064);
            }

            @Override // com.tencent.mm.splash.e
            public final boolean n(Intent intent) {
                AppMethodBeat.i(160065);
                if (intent == null || IntentUtil.getIntExtra(intent, "absolutely_exit_pid", 0) != Process.myPid()) {
                    AppMethodBeat.o(160065);
                    return false;
                }
                Log.i("MicroMsg.WeChatSplashStartup", "handle exit intent.");
                MMAppMgr.Bj(IntentUtil.getBooleanExtra(intent, "kill_service", true));
                AppMethodBeat.o(160065);
                return true;
            }

            @Override // com.tencent.mm.splash.e
            public final boolean a(Activity activity, final Runnable runnable) {
                AppMethodBeat.i(160066);
                g.aAf();
                if (!(!com.tencent.mm.kernel.a.azo() && bf.iDu.aA(WXUtil.LAST_LOGIN_USERNAME, "").equals(""))) {
                    AppMethodBeat.o(160066);
                    return false;
                } else if (ChannelUtil.shouldShowGprsAlert) {
                    boolean a2 = MMAppMgr.a(activity, new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.app.WeChatSplashStartup.AnonymousClass4.AnonymousClass1 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(160107);
                            runnable.run();
                            AppMethodBeat.o(160107);
                        }
                    });
                    AppMethodBeat.o(160066);
                    return a2;
                } else {
                    AppMethodBeat.o(160066);
                    return false;
                }
            }

            @Override // com.tencent.mm.splash.e
            public final boolean WX() {
                AppMethodBeat.i(169426);
                boolean gIz = com.tencent.mm.ui.o.gIz();
                AppMethodBeat.o(169426);
                return gIz;
            }

            @Override // com.tencent.mm.splash.e
            public final boolean a(Activity activity, int i2, String[] strArr, int[] iArr) {
                AppMethodBeat.i(160068);
                boolean a2 = this.dmS.a(activity, i2, strArr, iArr);
                AppMethodBeat.o(160068);
                return a2;
            }
        });
        com.tencent.mm.splash.h.a(y.dme);
        g.aAi().a(new com.tencent.mm.kernel.api.g() {
            /* class com.tencent.mm.app.WeChatSplashStartup.AnonymousClass5 */

            @Override // com.tencent.mm.kernel.api.g
            public final void WY() {
                AppMethodBeat.i(160049);
                g.aAi().b(this);
                if (!z) {
                    aVar.done();
                    AppMethodBeat.o(160049);
                    return;
                }
                com.tencent.mm.splash.h.c("MicroMsg.FigLeaf", "deleteRequest ", new Object[0]);
                String gya = com.tencent.mm.splash.a.gya();
                if (!new com.tencent.mm.vfs.o(gya).exists()) {
                    com.tencent.mm.splash.h.c("MicroMsg.FigLeaf", "deleteRequest dex opt dir not exists.", new Object[0]);
                    AppMethodBeat.o(160049);
                    return;
                }
                com.tencent.mm.vfs.o oVar = new com.tencent.mm.vfs.o(gya + "/main-process-blocking");
                if (oVar.exists()) {
                    com.tencent.mm.splash.h.c("MicroMsg.FigLeaf", "deleteRequest result %s.", Boolean.valueOf(oVar.delete()));
                }
                AppMethodBeat.o(160049);
            }

            @Override // com.tencent.mm.kernel.api.g
            public final void cQ(boolean z) {
            }
        });
        g.aAi().a(new com.tencent.mm.kernel.api.g() {
            /* class com.tencent.mm.app.WeChatSplashStartup.AnonymousClass6 */

            @Override // com.tencent.mm.kernel.api.g
            public final void WY() {
                AppMethodBeat.i(160075);
                g.aAi().b(this);
                com.tencent.mm.blink.a.WU();
                WeChatSplashStartup.a(WeChatSplashStartup.this);
                z.bUV();
                ExtStorageMigrateMonitor.gwL();
                com.tencent.mm.sdcard_migrate.b.gxh();
                ExtStorageMigrateRoutine.triggerMediaRescanOnDemand();
                if (WeChatSplashStartup.this.profile.aBb()) {
                    try {
                        MMApplicationContext.getContext().getSharedPreferences("system_config_prefs", 0).edit().putInt("launch_last_status", 2).commit();
                    } catch (Exception e2) {
                        Log.printErrStackTrace("MicroMsg.WeChatSplashStartup", e2, "%s", e2.getMessage());
                    }
                }
                if (WeChatSplashStartup.this.profile.aBb()) {
                    com.tencent.mm.kernel.a aAf = g.aAf();
                    Log.i("MMKernel.CoreAccount", "summerhardcoder hasInitialized[%b] mHardCoderStartPerformance[%d] stack[%s]", Boolean.valueOf(aAf.azp()), Integer.valueOf(aAf.hpP), Util.getStack());
                    if (aAf.azp() && aAf.hpP != 0) {
                        WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcBootEnable, aAf.hpP);
                        Log.i("MMKernel.CoreAccount", "summerhardcoder stopPerformance[%s] stack[%s]", Integer.valueOf(aAf.hpP), Util.getStack());
                        aAf.hpP = 0;
                    }
                }
                AppMethodBeat.o(160075);
            }

            @Override // com.tencent.mm.kernel.api.g
            public final void cQ(boolean z) {
            }
        });
        g.aAi().a(new com.tencent.mm.kernel.api.g() {
            /* class com.tencent.mm.app.WeChatSplashStartup.AnonymousClass7 */

            @Override // com.tencent.mm.kernel.api.g
            public final void WY() {
                AppMethodBeat.i(160071);
                if (!MMApplicationContext.isToolsIsolatedProcess()) {
                    ag.a.dmC.WM();
                }
                x.execute();
                AppMethodBeat.o(160071);
            }

            @Override // com.tencent.mm.kernel.api.g
            public final void cQ(boolean z) {
            }
        });
        g.aAi().a(new com.tencent.mm.kernel.api.g() {
            /* class com.tencent.mm.app.WeChatSplashStartup.AnonymousClass8 */

            @Override // com.tencent.mm.kernel.api.g
            public final void WY() {
                AppMethodBeat.i(160117);
                b.c(WeChatSplashStartup.this.app);
                AppMethodBeat.o(160117);
            }

            @Override // com.tencent.mm.kernel.api.g
            public final void cQ(boolean z) {
            }
        });
        g.aAi().a(new com.tencent.mm.kernel.api.g() {
            /* class com.tencent.mm.app.WeChatSplashStartup.AnonymousClass9 */
            private final int IDKEY_ID = 1315;
            private final PeriodRecorder dmV = new PeriodRecorder("FixMigrate", TimeUnit.DAYS.toMillis(1), true, true);
            private final int dmW = TbsListener.ErrorCode.NEEDDOWNLOAD_TRUE;
            private final int dmX = TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_1;
            private final int dmY = 172;
            private final int dmZ = TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_3;
            private final int dna = TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_4;
            private final int dnb = TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_5;
            private final int dnc = TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_6;
            private final int dnd = TbsListener.ErrorCode.NONEEDDOWNLOAD_OTHER_PROCESS_DOWNLOADING;

            {
                AppMethodBeat.i(257913);
                AppMethodBeat.o(257913);
            }

            @Override // com.tencent.mm.kernel.api.g
            public final void WY() {
                AppMethodBeat.i(160116);
                if (!MMApplicationContext.isMainProcess()) {
                    AppMethodBeat.o(160116);
                    return;
                }
                com.tencent.f.h.RTc.b(new Runnable() {
                    /* class com.tencent.mm.app.WeChatSplashStartup.AnonymousClass9.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(257917);
                        File file = new File(com.tencent.mm.loader.j.b.aKF(), "/MicroMsg/WeiXin/");
                        File file2 = new File(com.tencent.mm.loader.j.b.aKF(), "/MicroMsg/WeChat/");
                        File file3 = new File(com.tencent.mm.loader.j.b.aKU());
                        if (file.exists()) {
                            AnonymousClass9.f(file, file3);
                            if (!file3.exists()) {
                                AnonymousClass9.a(AnonymousClass9.this, TbsListener.ErrorCode.NEEDDOWNLOAD_TRUE, TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_4);
                            } else if (!file.exists()) {
                                AnonymousClass9.a(AnonymousClass9.this, TbsListener.ErrorCode.NEEDDOWNLOAD_TRUE, 172);
                            } else {
                                AnonymousClass9.a(AnonymousClass9.this, TbsListener.ErrorCode.NEEDDOWNLOAD_TRUE, TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_3);
                            }
                        }
                        if (file2.exists()) {
                            AnonymousClass9.f(file2, file3);
                            if (!file3.exists()) {
                                AnonymousClass9.a(AnonymousClass9.this, TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_1, TbsListener.ErrorCode.NONEEDDOWNLOAD_OTHER_PROCESS_DOWNLOADING);
                                AppMethodBeat.o(257917);
                                return;
                            } else if (!file2.exists()) {
                                AnonymousClass9.a(AnonymousClass9.this, TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_1, TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_5);
                                AppMethodBeat.o(257917);
                                return;
                            } else {
                                AnonymousClass9.a(AnonymousClass9.this, TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_1, TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_6);
                            }
                        }
                        AppMethodBeat.o(257917);
                    }
                }, "FixMigrate");
                AppMethodBeat.o(160116);
            }

            private static void e(File file, File file2) {
                BufferedOutputStream bufferedOutputStream;
                BufferedInputStream bufferedInputStream;
                AppMethodBeat.i(257914);
                if (!file2.exists()) {
                    file2.getParentFile().mkdirs();
                }
                try {
                    bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                    try {
                        bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
                    } catch (Throwable th) {
                        th = th;
                        bufferedOutputStream = null;
                        aa.closeQuietly(bufferedOutputStream);
                        aa.closeQuietly(bufferedInputStream);
                        AppMethodBeat.o(257914);
                        throw th;
                    }
                    try {
                        byte[] bArr = new byte[4096];
                        while (true) {
                            int read = bufferedInputStream.read(bArr);
                            if (read > 0) {
                                bufferedOutputStream.write(bArr, 0, read);
                            } else {
                                Log.i("MicroMsg.WeChatSplashStartup", "[+] moveDir, copy %s to %s.", file.getAbsolutePath(), file2.getAbsolutePath());
                                aa.closeQuietly(bufferedOutputStream);
                                aa.closeQuietly(bufferedInputStream);
                                AppMethodBeat.o(257914);
                                return;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        aa.closeQuietly(bufferedOutputStream);
                        aa.closeQuietly(bufferedInputStream);
                        AppMethodBeat.o(257914);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bufferedOutputStream = null;
                    bufferedInputStream = null;
                    aa.closeQuietly(bufferedOutputStream);
                    aa.closeQuietly(bufferedInputStream);
                    AppMethodBeat.o(257914);
                    throw th;
                }
            }

            @Override // com.tencent.mm.kernel.api.g
            public final void cQ(boolean z) {
            }

            static /* synthetic */ void f(File file, File file2) {
                File file3;
                AppMethodBeat.i(257915);
                if (!file.exists()) {
                    Log.w("MicroMsg.WeChatSplashStartup", "[!] moveDir, srcDir is not exists, skip moving.");
                    AppMethodBeat.o(257915);
                } else if (file.equals(file2)) {
                    Log.w("MicroMsg.WeChatSplashStartup", "[!] moveDir, srcDir points to the same place with destDir, skip moving.");
                    AppMethodBeat.o(257915);
                } else {
                    ArrayList arrayList = new ArrayList();
                    Stack stack = new Stack();
                    arrayList.add(file);
                    while (!arrayList.isEmpty()) {
                        File file4 = (File) arrayList.remove(0);
                        String substring = file4.getAbsolutePath().substring(file.getAbsolutePath().length());
                        if (TextUtils.isEmpty(substring)) {
                            file3 = file2;
                        } else {
                            file3 = new File(file2, substring);
                        }
                        if (file4.renameTo(file3)) {
                            Log.i("MicroMsg.WeChatSplashStartup", "[+] moveDir, move %s to %s.", file4.getAbsolutePath(), file3.getAbsolutePath());
                        } else {
                            File[] listFiles = file4.listFiles();
                            if (listFiles == null) {
                                Log.i("MicroMsg.WeChatSplashStartup", "[+] moveDir, delete empty dir: %s", file4.getAbsolutePath());
                                if (!file4.delete()) {
                                    Log.w("MicroMsg.WeChatSplashStartup", "[!] moveDir, fail to delete empty dir: %s", file4.getAbsolutePath());
                                }
                            } else {
                                for (File file5 : listFiles) {
                                    if (file5.isDirectory()) {
                                        arrayList.add(file5);
                                    } else {
                                        File file6 = new File(file3, file5.getName());
                                        if (file6.exists()) {
                                            Log.w("MicroMsg.WeChatSplashStartup", "[!] moveDir, dest file: %s exists, skip moving it.", file6.getAbsolutePath());
                                        } else if (file5.renameTo(file6)) {
                                            Log.i("MicroMsg.WeChatSplashStartup", "[+] moveDir, move %s to %s.", file5.getAbsolutePath(), file6.getAbsolutePath());
                                        } else {
                                            try {
                                                e(file5, file6);
                                                if (!file5.delete()) {
                                                    Log.w("MicroMsg.WeChatSplashStartup", "[!] moveDir, fail to delete %s after copy.", file5.getAbsolutePath());
                                                }
                                            } catch (IOException e2) {
                                                Log.printErrStackTrace("MicroMsg.WeChatSplashStartup", e2, "[-] moveDir, fail to copy %s to %s.", file5.getAbsolutePath(), file6.getAbsolutePath());
                                            }
                                        }
                                    }
                                }
                                stack.push(file4);
                            }
                        }
                    }
                    while (!stack.isEmpty()) {
                        File file7 = (File) stack.pop();
                        file7.delete();
                        Log.i("MicroMsg.WeChatSplashStartup", "[+] moveDir, remove dir: %s after copy.", file7.getAbsolutePath());
                    }
                    AppMethodBeat.o(257915);
                }
            }

            static /* synthetic */ void a(AnonymousClass9 r7, int i2, int i3) {
                AppMethodBeat.i(257916);
                if (r7.dmV.isExpired("idkey_1315_" + i2 + "_" + i3)) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.b(1315, i2, i3, 1, true);
                }
                AppMethodBeat.o(257916);
            }
        });
        AppMethodBeat.o(160091);
    }

    private d cP(boolean z) {
        AppMethodBeat.i(160092);
        if (!z) {
            final q Ws = q.Ws();
            Ws.setHighPriority();
            g.aAi().a(new com.tencent.mm.kernel.api.g() {
                /* class com.tencent.mm.app.WeChatSplashStartup.AnonymousClass10 */

                @Override // com.tencent.mm.kernel.api.g
                public final void WY() {
                    AppMethodBeat.i(257912);
                    Ws.dli.quit();
                    g.aAi().b(this);
                    AppMethodBeat.o(257912);
                }

                @Override // com.tencent.mm.kernel.api.g
                public final void cQ(boolean z) {
                }
            });
            c.aAu().f(Ws.dli.getLooper());
            d dVar = Ws.mScheduler;
            AppMethodBeat.o(160092);
            return dVar;
        }
        AppMethodBeat.o(160092);
        return null;
    }

    static /* synthetic */ void a(WeChatSplashStartup weChatSplashStartup) {
        AppMethodBeat.i(160093);
        com.tencent.mm.vending.g.g.hdG().Oc(500).d(new com.tencent.mm.vending.c.a<Void, Void>() {
            /* class com.tencent.mm.app.WeChatSplashStartup.AnonymousClass2 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.vending.c.a
            public final /* synthetic */ Void call(Void r15) {
                AppMethodBeat.i(257911);
                ArrayList<long[]> arrayList = com.tencent.mm.splash.h.gyq().gkx;
                Iterator<long[]> it = arrayList.iterator();
                while (it.hasNext()) {
                    long[] next = it.next();
                    Log.i("MicroMsg.WeChatSplashStartup", "splash %s, %s, %s", Long.valueOf(next[0]), Long.valueOf(next[1]), Long.valueOf(next[2]));
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(next[0], next[1], next[2], false);
                }
                ArrayList<String> arrayList2 = com.tencent.mm.splash.h.gyq().NMC;
                HashMap hashMap = new HashMap();
                hashMap.put("processName", WeChatSplashStartup.this.thisProcess);
                Iterator<String> it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    String next2 = it2.next();
                    Log.i("MicroMsg.WeChatSplashStartup", "splash message %s", next2);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.e("NewSplash", next2, hashMap);
                }
                Log.i("MicroMsg.WeChatSplashStartup", "report splash info %s %s", Integer.valueOf(arrayList.size()), Integer.valueOf(arrayList2.size()));
                Void r0 = QZL;
                AppMethodBeat.o(257911);
                return r0;
            }
        });
        AppMethodBeat.o(160093);
    }
}
