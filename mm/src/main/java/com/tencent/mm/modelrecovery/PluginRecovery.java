package com.tencent.mm.modelrecovery;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.rf;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.protocal.d;
import com.tencent.mm.recoveryv2.h;
import com.tencent.mm.recoveryv2.k;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.vfs.s;
import com.tencent.recovery.ConstantsRecovery;
import com.tencent.recovery.RecoveryContext;
import com.tencent.recovery.RecoveryLogic;
import com.tencent.recovery.log.RecoveryLog;
import com.tencent.recovery.option.CommonOptions;
import com.tencent.recovery.wx.WXConstantsRecovery;
import com.tencent.recovery.wx.service.WXRecoveryHandleService;
import com.tencent.recovery.wx.service.WXRecoveryUploadService;
import com.tencent.recovery.wx.util.WXUtil;
import java.io.File;

public class PluginRecovery extends f implements c {
    private IListener<rf> jhI = new IListener<rf>() {
        /* class com.tencent.mm.modelrecovery.PluginRecovery.AnonymousClass4 */

        {
            AppMethodBeat.i(231552);
            this.__eventId = rf.class.getName().hashCode();
            AppMethodBeat.o(231552);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(rf rfVar) {
            AppMethodBeat.i(231554);
            boolean a2 = a(rfVar);
            AppMethodBeat.o(231554);
            return a2;
        }

        private static boolean a(rf rfVar) {
            AppMethodBeat.i(231553);
            switch (rfVar.dXV.action) {
                case 1:
                    Context context = MMApplicationContext.getContext();
                    CommonOptions.Builder builder = new CommonOptions.Builder();
                    builder.setRecoveryHandleService(WXRecoveryHandleService.class.getName());
                    builder.setRecoveryUploadService(WXRecoveryUploadService.class.getName());
                    builder.setClientVersion(BuildInfo.CLIENT_VERSION);
                    builder.setConfigUrl(String.format("file:///sdcard/test-recovery.conf", new Object[0]));
                    builder.setUUID(WXUtil.getWXUin(context));
                    RecoveryLogic.startHandleService(context, builder.build(), new RecoveryContext());
                    break;
                case 2:
                    b.bex();
                    break;
                case 3:
                    Context context2 = MMApplicationContext.getContext();
                    CommonOptions.Builder builder2 = new CommonOptions.Builder();
                    builder2.setRecoveryHandleService(WXRecoveryHandleService.class.getName());
                    builder2.setRecoveryUploadService(WXRecoveryUploadService.class.getName());
                    builder2.setClientVersion(BuildInfo.CLIENT_VERSION);
                    builder2.setConfigUrl("http://dldir1.qq.com/weixin/android/recovery-0x26032011.conf");
                    builder2.setUUID(WXUtil.getWXUin(context2));
                    RecoveryLogic.startHandleService(context2, builder2.build(), new RecoveryContext());
                    break;
            }
            AppMethodBeat.o(231553);
            return false;
        }
    };
    private RecoveryLog.RecoveryLogImpl logImpl = new RecoveryLog.RecoveryLogImpl() {
        /* class com.tencent.mm.modelrecovery.PluginRecovery.AnonymousClass8 */

        @Override // com.tencent.recovery.log.RecoveryLog.RecoveryLogImpl
        public final void d(String str, String str2, Object... objArr) {
            AppMethodBeat.i(231558);
            Log.d(str, str2, objArr);
            AppMethodBeat.o(231558);
        }

        @Override // com.tencent.recovery.log.RecoveryLog.RecoveryLogImpl
        public final void v(String str, String str2, Object... objArr) {
            AppMethodBeat.i(231559);
            Log.v(str, str2, objArr);
            AppMethodBeat.o(231559);
        }

        @Override // com.tencent.recovery.log.RecoveryLog.RecoveryLogImpl
        public final void i(String str, String str2, Object... objArr) {
            AppMethodBeat.i(231560);
            Log.i(str, str2, objArr);
            AppMethodBeat.o(231560);
        }

        @Override // com.tencent.recovery.log.RecoveryLog.RecoveryLogImpl
        public final void w(String str, String str2, Object... objArr) {
            AppMethodBeat.i(231561);
            Log.w(str, str2, objArr);
            AppMethodBeat.o(231561);
        }

        @Override // com.tencent.recovery.log.RecoveryLog.RecoveryLogImpl
        public final void e(String str, String str2, Object... objArr) {
            AppMethodBeat.i(231562);
            Log.e(str, str2, objArr);
            AppMethodBeat.o(231562);
        }

        @Override // com.tencent.recovery.log.RecoveryLog.RecoveryLogImpl
        public final void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
            AppMethodBeat.i(231563);
            Log.printErrStackTrace(str, th, str2, objArr);
            AppMethodBeat.o(231563);
        }

        @Override // com.tencent.recovery.log.RecoveryLog.RecoveryLogImpl
        public final void setDebugMode() {
        }
    };
    private BroadcastReceiver receiver = new BroadcastReceiver() {
        /* class com.tencent.mm.modelrecovery.PluginRecovery.AnonymousClass5 */

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(231555);
            if (intent != null) {
                if (ConstantsRecovery.IntentAction.ACTION_LOG.equals(intent.getAction())) {
                    PluginRecovery.access$000(PluginRecovery.this);
                    AppMethodBeat.o(231555);
                    return;
                } else if (WXConstantsRecovery.IntentAction.RECOVERY_STATUS_UPLOAD.equals(intent.getAction())) {
                    PluginRecovery.access$100(PluginRecovery.this);
                }
            }
            AppMethodBeat.o(231555);
        }
    };

    public PluginRecovery() {
        AppMethodBeat.i(20580);
        AppMethodBeat.o(20580);
    }

    static /* synthetic */ void access$000(PluginRecovery pluginRecovery) {
        AppMethodBeat.i(20586);
        pluginRecovery.postLog();
        AppMethodBeat.o(20586);
    }

    static /* synthetic */ void access$100(PluginRecovery pluginRecovery) {
        AppMethodBeat.i(20587);
        pluginRecovery.postReport();
        AppMethodBeat.o(20587);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void configure(g gVar) {
        AppMethodBeat.i(20581);
        RecoveryLog.setLogImpl(this.logImpl);
        if (gVar.FY(":sandbox")) {
            long currentTimeMillis = System.currentTimeMillis();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(ConstantsRecovery.IntentAction.ACTION_LOG);
            intentFilter.addAction(WXConstantsRecovery.IntentAction.RECOVERY_STATUS_UPLOAD);
            try {
                MMApplicationContext.getContext().registerReceiver(this.receiver, intentFilter);
            } catch (Exception e2) {
            }
            File file = new File(WXConstantsRecovery.RecoverySDCardDir);
            if (!file.exists()) {
                file.mkdir();
            }
            File file2 = new File(file, WXConstantsRecovery.VersionInfoFile);
            if (file2.exists()) {
                file2.delete();
            }
            try {
                String absolutePath = file2.getAbsolutePath();
                byte[] bytes = Integer.toHexString(d.KyO).getBytes();
                s.f(absolutePath, bytes, bytes.length);
            } catch (Exception e3) {
            }
            Log.i("MicroMsg.recovery.PluginRecovery", "add recovery intent filter and save client verison file %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        }
        AppMethodBeat.o(20581);
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(final g gVar) {
        AppMethodBeat.i(231564);
        if (gVar.aBb()) {
            h.RTc.aX(new Runnable() {
                /* class com.tencent.mm.modelrecovery.PluginRecovery.AnonymousClass1 */

                /* JADX WARNING: Removed duplicated region for block: B:46:0x0189  */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void run() {
                    /*
                    // Method dump skipped, instructions count: 640
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelrecovery.PluginRecovery.AnonymousClass1.run():void");
                }
            });
            com.tencent.mm.kernel.g.aAi().a(new com.tencent.mm.kernel.api.g() {
                /* class com.tencent.mm.modelrecovery.PluginRecovery.AnonymousClass2 */

                @Override // com.tencent.mm.kernel.api.g
                public final void WY() {
                    AppMethodBeat.i(231550);
                    com.tencent.mm.kernel.g.aAi().b(this);
                    h.RTc.aX(new Runnable() {
                        /* class com.tencent.mm.modelrecovery.PluginRecovery.AnonymousClass2.AnonymousClass1 */

                        public final void run() {
                            boolean z;
                            AppMethodBeat.i(231549);
                            if (com.tencent.mm.kernel.g.aAi().hrh.hrB) {
                                Log.i("MicroMsg.recovery.PluginRecovery", "pull recovery online config");
                                Context context = MMApplicationContext.getContext();
                                try {
                                    b bVar = (b) com.tencent.mm.kernel.g.af(b.class);
                                    if (bVar != null) {
                                        h.a iN = h.a.iN(context);
                                        int a2 = bVar.a(b.a.clicfg_recovery_enable, 1);
                                        if (a2 > 0) {
                                            z = true;
                                        } else {
                                            z = false;
                                        }
                                        iN.mEnabled = z;
                                        iN.NBQ.de("enable", iN.mEnabled).guF();
                                        Log.i("MicroMsg.recovery.reporter", "online config, enabled = ".concat(String.valueOf(a2)));
                                        com.tencent.mm.recoveryv2.h iM = com.tencent.mm.recoveryv2.h.iM(context);
                                        int a3 = bVar.a(b.a.clicfg_recovery_threshold_1, iM.NBK);
                                        int a4 = bVar.a(b.a.clicfg_recovery_threshold_2, iM.NBL);
                                        long a5 = bVar.a(b.a.clicfg_recovery_auto_reset, iM.NBP);
                                        long a6 = bVar.a(b.a.clicfg_recovery_interval, iM.NBM);
                                        long a7 = bVar.a(b.a.clicfg_recovery_interval_sub, iM.NBN);
                                        if (a3 >= 2) {
                                            Log.i("MicroMsg.recovery.reporter", "setThresholdLevel1, value = ".concat(String.valueOf(a3)));
                                            iM.NBK = a3;
                                        }
                                        if (a4 >= iM.NBK) {
                                            Log.i("MicroMsg.recovery.reporter", "setThresholdLevel2, value = ".concat(String.valueOf(a4)));
                                            iM.NBL = a4;
                                        }
                                        if (a5 >= 5000) {
                                            Log.i("MicroMsg.recovery.reporter", "setAutoResetDelay, value = ".concat(String.valueOf(a5)));
                                            iM.NBP = a5;
                                        }
                                        if (a6 >= 5000) {
                                            Log.i("MicroMsg.recovery.reporter", "setCrashInterval, value = ".concat(String.valueOf(a6)));
                                            iM.NBM = a6;
                                        }
                                        if (a7 >= 5000) {
                                            Log.i("MicroMsg.recovery.reporter", "setCrashSubInterval, value = ".concat(String.valueOf(a7)));
                                            iM.NBN = a7;
                                        }
                                        iM.NBQ.gL("setting_threshold_1", iM.NBK).gL("setting_threshold_2", iM.NBL).bT("setting_crash_interval", iM.NBM).bT("setting_crash_interval_sub", iM.NBN).bT("setting_crash_minimal_interval", iM.NBO).bT("setting_reset_delay", iM.NBP).guF();
                                    }
                                } catch (Throwable th) {
                                    Log.printErrStackTrace("MicroMsg.recovery.reporter", th, "pull abtest config for recovery fail", new Object[0]);
                                }
                            }
                            try {
                                Thread.sleep(com.tencent.mm.recoveryv2.h.iM(gVar.ca).NBP);
                            } catch (InterruptedException e2) {
                            } finally {
                                Log.i("MicroMsg.recovery.PluginRecovery", "unregister recovery on time out");
                                k.guX().unregister();
                                AppMethodBeat.o(231549);
                            }
                        }
                    });
                    AppMethodBeat.o(231550);
                }

                @Override // com.tencent.mm.kernel.api.g
                public final void cQ(boolean z) {
                }
            });
            MMUncaughtExceptionHandler.setAfterReport(new MMUncaughtExceptionHandler.IAfterReport() {
                /* class com.tencent.mm.modelrecovery.PluginRecovery.AnonymousClass3 */

                @Override // com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler.IAfterReport
                public final void afterReport() {
                    AppMethodBeat.i(231551);
                    Log.i("MicroMsg.recovery.PluginRecovery", "#afterReport, handling java crash with recovery");
                    k.guX().ajx(3);
                    AppMethodBeat.o(231551);
                }
            });
        }
        AppMethodBeat.o(231564);
    }

    private void testRecoveryExceptionHandler() {
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(20582);
        this.jhI.alive();
        AppMethodBeat.o(20582);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountRelease() {
        AppMethodBeat.i(20583);
        this.jhI.dead();
        AppMethodBeat.o(20583);
    }

    private void postLog() {
        AppMethodBeat.i(20584);
        ThreadPool.post(new Runnable() {
            /* class com.tencent.mm.modelrecovery.PluginRecovery.AnonymousClass6 */

            public final void run() {
                AppMethodBeat.i(231556);
                Log.i("MicroMsg.recovery.PluginRecovery", "postLog");
                b.bex();
                AppMethodBeat.o(231556);
            }
        }, "RecoveryWriteLogThread");
        AppMethodBeat.o(20584);
    }

    private void postReport() {
        AppMethodBeat.i(20585);
        ThreadPool.post(new Runnable() {
            /* class com.tencent.mm.modelrecovery.PluginRecovery.AnonymousClass7 */

            public final void run() {
                AppMethodBeat.i(231557);
                Log.i("MicroMsg.recovery.PluginRecovery", "postReport");
                c.bey();
                AppMethodBeat.o(231557);
            }
        }, "RecoveryReportStatusThread");
        AppMethodBeat.o(20585);
    }
}
