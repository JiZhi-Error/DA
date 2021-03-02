package com.tencent.mm.app;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.v;
import com.tencent.mm.blink.b;
import com.tencent.mm.booter.CoreService;
import com.tencent.mm.booter.c;
import com.tencent.mm.g.a.hc;
import com.tencent.mm.model.cm;
import com.tencent.mm.network.d;
import com.tencent.mm.network.g;
import com.tencent.mm.network.h;
import com.tencent.mm.network.i;
import com.tencent.mm.network.j;
import com.tencent.mm.network.k;
import com.tencent.mm.network.u;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.aa;
import com.tencent.mm.protocal.ab;
import com.tencent.mm.protocal.o;
import com.tencent.mm.sdk.crash.CallbackForReset;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.an;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import junit.framework.Assert;

public final class g implements ServiceConnection {
    private static final String dkC = (MMApplicationContext.getApplicationId() + ":push");
    private static int dkD = 0;
    private static int dkE = 40000;
    private static boolean dkx = false;
    private static Object lock = new Object();
    private IBinder dkA = null;
    private a dkB = new a();
    private ReentrantLock dky = new ReentrantLock();
    private boolean dkz = false;

    public g() {
        AppMethodBeat.i(131773);
        AppMethodBeat.o(131773);
    }

    static {
        AppMethodBeat.i(131782);
        AppMethodBeat.o(131782);
    }

    public final void onServiceConnected(final ComponentName componentName, final IBinder iBinder) {
        AppMethodBeat.i(131774);
        Log.w("MicroMsg.CoreServiceConnection", "onServiceConnected ");
        gb(dkC);
        if (!c.akA()) {
            synchronized (lock) {
                try {
                    Log.i("MicroMsg.CoreServiceConnection", "remove zombie killer.");
                    Wk();
                    dkx = false;
                } finally {
                    AppMethodBeat.o(131774);
                }
            }
            try {
                this.dky.lock();
                this.dkz = false;
                this.dkA = iBinder;
                this.dky.unlock();
                b.ake().arrange(new Runnable() {
                    /* class com.tencent.mm.app.g.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(131768);
                        g.a(g.this, iBinder);
                        AppMethodBeat.o(131768);
                    }
                });
            } catch (Throwable th) {
                this.dky.unlock();
                AppMethodBeat.o(131774);
                throw th;
            }
        } else if (iBinder == null) {
            Log.w("MicroMsg.CoreServiceConnection", "onServiceConnected binder == null");
            AppMethodBeat.o(131774);
        } else if (com.tencent.mm.kernel.g.aAe().azG().aBb()) {
            synchronized (lock) {
                try {
                    Log.i("MicroMsg.CoreServiceConnection", "remove zombie killer.");
                    Wk();
                    dkx = false;
                } catch (Throwable th2) {
                    AppMethodBeat.o(131774);
                    throw th2;
                }
            }
            try {
                this.dky.lock();
                this.dkz = false;
                if (this.dkA == null || !Util.isEqual(this.dkA.hashCode(), iBinder.hashCode())) {
                    this.dkA = iBinder;
                    this.dky.unlock();
                    b.ake().arrange(new Runnable() {
                        /* class com.tencent.mm.app.g.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(131767);
                            g.a(g.this, iBinder);
                            AppMethodBeat.o(131767);
                        }
                    });
                    AppMethodBeat.o(131774);
                    return;
                }
                Log.w("MicroMsg.CoreServiceConnection", "onServiceConnected binder == serviceBinder");
            } finally {
                this.dky.unlock();
                AppMethodBeat.o(131774);
            }
        }
    }

    public final void onServiceDisconnected(final ComponentName componentName) {
        AppMethodBeat.i(131775);
        Log.w("MicroMsg.CoreServiceConnection", "onServiceDisconnected ");
        if (com.tencent.mm.kernel.g.aAe().azG().aBb()) {
            try {
                this.dky.lock();
                this.dkz = false;
                this.dkA = null;
                this.dky.unlock();
                b.ake().arrange(new Runnable() {
                    /* class com.tencent.mm.app.g.AnonymousClass5 */

                    public final void run() {
                        AppMethodBeat.i(131771);
                        g.a(g.this);
                        AppMethodBeat.o(131771);
                    }
                });
            } catch (Throwable th) {
                this.dky.unlock();
                AppMethodBeat.o(131775);
                throw th;
            }
        }
        AppMethodBeat.o(131775);
    }

    public final void bG(Context context) {
        int i2;
        AppMethodBeat.i(131776);
        com.tencent.mm.blink.a.CM("bindCore");
        try {
            this.dky.lock();
            boolean z = this.dkA != null && this.dkA.isBinderAlive();
            Log.i("MicroMsg.CoreServiceConnection", "enter bindCore, isBinding: %b, binderAlive: %b", Boolean.valueOf(this.dkz), Boolean.valueOf(z));
            if (this.dkz || z) {
                Log.w("MicroMsg.CoreServiceConnection", "bindCore reenter, isBinding: %b, binderAlive: %b, return directly.", Boolean.valueOf(this.dkz), Boolean.valueOf(z));
                return;
            }
            this.dky.unlock();
            if (c.akA()) {
                Intent intent = new Intent(context, CoreService.class);
                Log.i("MicroMsg.CoreServiceConnection", "prepare dispatcher / bind core service");
                try {
                    if (!context.bindService(intent, this, 1)) {
                        Log.e("MicroMsg.CoreServiceConnection", "bindService failed, may be caused by some crashes");
                        AppMethodBeat.o(131776);
                        return;
                    }
                    try {
                        this.dky.lock();
                        this.dkz = true;
                        this.dky.unlock();
                        synchronized (lock) {
                            try {
                                if (!dkx) {
                                    dkx = true;
                                    Log.i("MicroMsg.CoreServiceConnection", "ZombieWaker posted.");
                                    MMHandlerThread.postToMainThreadDelayed(this.dkB, (long) cL(false));
                                }
                            } finally {
                                AppMethodBeat.o(131776);
                            }
                        }
                    } catch (Throwable th) {
                        this.dky.unlock();
                        AppMethodBeat.o(131776);
                        throw th;
                    }
                } catch (Exception e2) {
                    Log.e("MicroMsg.CoreServiceConnection", "CoreServiceConnection bindService Exception:%s", e2.getMessage());
                    AppMethodBeat.o(131776);
                }
            } else if (!com.tencent.mm.booter.b.c(context, "noop", false)) {
                Log.i("MicroMsg.CoreServiceConnection", "ensureServiceInstance return false");
                AppMethodBeat.o(131776);
            } else {
                try {
                    this.dky.lock();
                    this.dkz = true;
                    this.dky.unlock();
                    synchronized (lock) {
                        try {
                            if (!dkx) {
                                dkx = true;
                                Log.i("MicroMsg.CoreServiceConnection", "ZombieWaker posted.");
                                MMHandlerThread.postToMainThreadDelayed(this.dkB, (long) cL(false));
                            }
                        } catch (Throwable th2) {
                            AppMethodBeat.o(131776);
                            throw th2;
                        }
                    }
                    Intent intent2 = new Intent(context, CoreService.class);
                    Log.i("MicroMsg.CoreServiceConnection", "prepare dispatcher / bind core service");
                    try {
                        if (!context.bindService(intent2, this, 1)) {
                            Log.e("MicroMsg.CoreServiceConnection", "bindService failed, may be caused by some crashes");
                            try {
                                this.dky.lock();
                                this.dkz = false;
                                this.dky.unlock();
                                try {
                                    String lowerCase = Build.BRAND.toLowerCase();
                                    if (lowerCase.contains("xiaomi") || lowerCase.contains("redmi")) {
                                        i2 = 41;
                                    } else if (lowerCase.contains("huawei") || lowerCase.contains("honor")) {
                                        i2 = 40;
                                    } else if (lowerCase.contains("vivo")) {
                                        i2 = 43;
                                    } else if (lowerCase.contains("oppo")) {
                                        i2 = 42;
                                    } else if (lowerCase.contains("samsung")) {
                                        i2 = 44;
                                    } else {
                                        i2 = 45;
                                    }
                                    e.INSTANCE.idkeyStat(954, (long) i2, 1, false);
                                    e.INSTANCE.a(20661, 0);
                                    AppMethodBeat.o(131776);
                                } catch (Throwable th3) {
                                    Log.printErrStackTrace("MicroMsg.CoreServiceUtil", th3, "", new Object[0]);
                                    AppMethodBeat.o(131776);
                                }
                            } catch (Throwable th4) {
                                this.dky.unlock();
                                AppMethodBeat.o(131776);
                                throw th4;
                            }
                        } else {
                            AppMethodBeat.o(131776);
                        }
                    } catch (Exception e3) {
                        Log.e("MicroMsg.CoreServiceConnection", "bindCore() bindService Exception:%S", e3.getMessage());
                        AppMethodBeat.o(131776);
                    }
                } catch (Throwable th5) {
                    this.dky.unlock();
                    AppMethodBeat.o(131776);
                    throw th5;
                }
            }
        } finally {
            this.dky.unlock();
            AppMethodBeat.o(131776);
        }
    }

    public static int gb(String str) {
        int i2;
        AppMethodBeat.i(131777);
        if (Util.isNullOrNil(str)) {
            Log.i("MicroMsg.CoreServiceConnection", "getPicByProcessName() processName == null");
            AppMethodBeat.o(131777);
            return -1;
        }
        try {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) MMApplicationContext.getContext().getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME)).getRunningAppProcesses();
            if (runningAppProcesses == null) {
                Log.i("MicroMsg.CoreServiceConnection", "getPicByProcessName() processes == null");
                AppMethodBeat.o(131777);
                return -1;
            }
            Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
            while (true) {
                if (!it.hasNext()) {
                    i2 = -1;
                    break;
                }
                ActivityManager.RunningAppProcessInfo next = it.next();
                if (next.processName.equals(str)) {
                    i2 = next.pid;
                    break;
                }
            }
            AppMethodBeat.o(131777);
            return i2;
        } catch (Exception e2) {
            Log.e("MicroMsg.CoreServiceConnection", "getPidByProcessName() %s %s %s", str, e2.getClass().getSimpleName(), e2.getMessage());
            i2 = -1;
        }
    }

    public static void Wj() {
        AppMethodBeat.i(131778);
        int gb = gb(dkC);
        Log.e("MicroMsg.CoreServiceConnection", "killPushProcess() pid = %s, stack[%s]", Integer.valueOf(gb), Util.getStack());
        killProcess(gb);
        AppMethodBeat.o(131778);
    }

    public static void killProcess(int i2) {
        AppMethodBeat.i(131779);
        try {
            com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(i2, new com.tencent.mm.hellhoundlib.b.a());
            Object obj = new Object();
            com.tencent.mm.hellhoundlib.a.a.a(obj, a2.axQ(), "com/tencent/mm/app/CoreServiceConnection", "killProcess", "(I)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
            Process.killProcess(((Integer) a2.pG(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(obj, "com/tencent/mm/app/CoreServiceConnection", "killProcess", "(I)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
            AppMethodBeat.o(131779);
        } catch (Exception e2) {
            Log.e("MicroMsg.CoreServiceConnection", "killProcess %s, %s %s", Integer.valueOf(i2), e2.getClass().getSimpleName(), e2.getMessage());
            AppMethodBeat.o(131779);
        }
    }

    public static int cL(boolean z) {
        AppMethodBeat.i(196970);
        int i2 = dkE;
        if (z) {
            int i3 = dkD + 1;
            dkD = i3;
            if (i3 == 5 && i2 < 600000) {
                dkE += com.tencent.mm.hardcoder.g.sHCENCODEVIDEOTIMEOUT;
                dkD = 0;
                Log.i("MicroMsg.CoreServiceConnection", "ZOMBIE_CHECK_TIME:%s", Integer.valueOf(dkE));
            }
        }
        AppMethodBeat.o(196970);
        return i2;
    }

    private void Wk() {
        AppMethodBeat.i(196971);
        MMHandlerThread.removeRunnable(this.dkB);
        this.dkB.dkI = 0;
        AppMethodBeat.o(196971);
    }

    /* access modifiers changed from: package-private */
    public class a implements Runnable {
        int dkI = 0;

        a() {
        }

        public final void run() {
            AppMethodBeat.i(196969);
            try {
                g.this.dky.lock();
                boolean z = g.this.dkA != null && g.this.dkA.isBinderAlive();
                Log.i("MicroMsg.CoreServiceConnection", "mZombieWaker run serviceBinder: %s, binderAlive: %b", g.this.dkA, Boolean.valueOf(z));
                if (z) {
                    Log.w("MicroMsg.CoreServiceConnection", "mZombieWaker run binderAlive return directly.");
                    return;
                }
                g.this.dky.unlock();
                Log.e("MicroMsg.CoreServiceConnection", String.format("CoreService started but not responding, possibly zombie. Use step %d to restart CoreService.", Integer.valueOf(this.dkI)));
                if (this.dkI == 1) {
                    int gb = g.gb(g.dkC);
                    if (gb != -1) {
                        Log.i("MicroMsg.CoreServiceConnection", String.format("Push Process %d killed.", Integer.valueOf(gb)));
                        Log.appenderFlush();
                        g.killProcess(gb);
                    } else {
                        Log.i("MicroMsg.CoreServiceConnection", "Push Process not found.");
                    }
                }
                Context context = MMApplicationContext.getContext();
                Intent intent = new Intent(context, CoreService.class);
                try {
                    Log.i("MicroMsg.CoreServiceConnection", "unbinding CoreService...");
                    context.unbindService(g.this);
                    try {
                        if (c.akA()) {
                            context.bindService(intent, g.this, 1);
                        } else {
                            context.stopService(intent);
                            context.bindService(intent, g.this, 1);
                            context.startService(intent);
                        }
                    } catch (Exception e2) {
                        Log.e("MicroMsg.CoreServiceConnection", "CoreServiceConnection mZombieWaker Exception:%s", e2.getMessage());
                    }
                } catch (Exception e3) {
                    try {
                        if (c.akA()) {
                            context.bindService(intent, g.this, 1);
                        } else {
                            context.stopService(intent);
                            context.bindService(intent, g.this, 1);
                            context.startService(intent);
                        }
                    } catch (Exception e4) {
                        Log.e("MicroMsg.CoreServiceConnection", "CoreServiceConnection mZombieWaker Exception:%s", e4.getMessage());
                    }
                } catch (Throwable th) {
                    try {
                        if (c.akA()) {
                            context.bindService(intent, g.this, 1);
                        } else {
                            context.stopService(intent);
                            context.bindService(intent, g.this, 1);
                            context.startService(intent);
                        }
                    } catch (Exception e5) {
                        Log.e("MicroMsg.CoreServiceConnection", "CoreServiceConnection mZombieWaker Exception:%s", e5.getMessage());
                    }
                    AppMethodBeat.o(196969);
                    throw th;
                }
                if (this.dkI == 1) {
                    this.dkI = 0;
                } else {
                    this.dkI++;
                }
                MMHandlerThread.postToMainThreadDelayed(this, (long) g.cL(true));
                Log.i("MicroMsg.CoreServiceConnection", String.format("ZombieWaker posted again with step %d", Integer.valueOf(this.dkI)));
                AppMethodBeat.o(196969);
            } finally {
                g.this.dky.unlock();
                AppMethodBeat.o(196969);
            }
        }
    }

    static /* synthetic */ void a(g gVar, IBinder iBinder) {
        long j2;
        AppMethodBeat.i(131780);
        com.tencent.mm.blink.a.CM("onServiceConnected");
        if (iBinder == null) {
            Assert.assertTrue("WorkerProfile onServiceConnected binder == null", false);
            CrashReportFactory.reportRawMessage("WorkerProfile onServiceConnected binder == null", "it will result in accInfo being null");
        }
        v vVar = new v(h.a.n(iBinder));
        try {
            vVar.iML.a(new u.a() {
                /* class com.tencent.mm.app.g.AnonymousClass3 */

                @Override // com.tencent.mm.network.u
                public final boolean check() {
                    return true;
                }
            });
        } catch (Exception e2) {
            Log.e("MicroMsg.RDispatcher", "exception:%s", Util.stackTraceToString(e2));
        }
        try {
            vVar.iML.a(new i.a() {
                /* class com.tencent.mm.app.g.AnonymousClass4 */

                @Override // com.tencent.mm.network.i
                public final void iM(final int i2) {
                    AppMethodBeat.i(131770);
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.app.g.AnonymousClass4.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(131769);
                            if (com.tencent.mm.kernel.b.azx() != null) {
                                com.tencent.mm.kernel.b.azx().rU(i2);
                            }
                            AppMethodBeat.o(131769);
                        }
                    });
                    AppMethodBeat.o(131770);
                }
            });
        } catch (Exception e3) {
            Log.e("MicroMsg.RDispatcher", "exception:%s", Util.stackTraceToString(e3));
        }
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.b aAg = com.tencent.mm.kernel.g.aAg();
        Log.w("MMKernel.CoreNetwork", "setting up remote dispatcher ".concat(String.valueOf(vVar)));
        aAg.hqh.b(vVar);
        vVar.a(new j.a() {
            /* class com.tencent.mm.kernel.b.AnonymousClass4 */

            @Override // com.tencent.mm.network.j
            public final void networkAnalysisCallBack(int i2, int i3, boolean z, String str) {
                AppMethodBeat.i(132049);
                Log.i("MMKernel.CoreNetwork", "callback, kv:%s", str);
                b.a(i2, i3, z, str);
                AppMethodBeat.o(132049);
            }
        });
        try {
            k aZi = vVar.aZi();
            if (aZi != null) {
                aZi.c(aAg.hqk);
            }
        } catch (RemoteException e4) {
            Log.e("MMKernel.CoreNetwork", "exception:%s", Util.stackTraceToString(e4));
        }
        vVar.a(new ab.a() {
            /* class com.tencent.mm.kernel.b.AnonymousClass5 */
            private byte[] hqn;

            @Override // com.tencent.mm.protocal.ab
            public final byte[] azB() {
                AppMethodBeat.i(132050);
                if (!g.aAc()) {
                    AppMethodBeat.o(132050);
                    return null;
                }
                aa.a aVar = new aa.a();
                g.aAi();
                g.aAf();
                aVar.setUin(a.getUin());
                g.aAi();
                aVar.jcK = Util.decodeHexString((String) g.aAh().azQ().get(8195, (Object) null));
                aVar.netType = com.tencent.mm.protocal.a.getNetType(MMApplicationContext.getContext());
                aVar.KzG = com.tencent.mm.protocal.a.gtq();
                try {
                    byte[] protoBuf = aVar.toProtoBuf();
                    this.hqn = aVar.hqn;
                    AppMethodBeat.o(132050);
                    return protoBuf;
                } catch (Exception e2) {
                    Log.e("MMKernel.CoreNetwork", "exception:%s", Util.stackTraceToString(e2));
                    AppMethodBeat.o(132050);
                    return null;
                }
            }

            @Override // com.tencent.mm.protocal.ab
            public final int ac(byte[] bArr) {
                AppMethodBeat.i(132051);
                aa.b bVar = new aa.b();
                try {
                    bVar.fromProtoBuf(bArr);
                    int i2 = (int) bVar.KAs;
                    AppMethodBeat.o(132051);
                    return i2;
                } catch (Exception e2) {
                    Log.e("MMKernel.CoreNetwork", "exception:%s", Util.stackTraceToString(e2));
                    AppMethodBeat.o(132051);
                    return 0;
                }
            }

            @Override // com.tencent.mm.protocal.ab
            public final byte[] azC() {
                return this.hqn;
            }
        });
        com.tencent.mm.network.e aZh = vVar.aZh();
        if (aZh == null) {
            Log.f("MMKernel.CoreNetwork", "accInfo is null, it would assert before!!!");
            aAg.hqi.reset();
            aAg.hqi.aYW();
        } else {
            CrashReportFactory.setCallbackForReset(new CallbackForReset() {
                /* class com.tencent.mm.kernel.b.AnonymousClass6 */

                @Override // com.tencent.mm.sdk.crash.CallbackForReset
                public final void callbackForReset(String str) {
                    AppMethodBeat.i(132052);
                    Log.w("MMKernel.CoreNetwork", "CallbackForReset errorStack %s ", str);
                    g.aAi();
                    if (g.aAj() != null) {
                        g.aAi();
                        cm aAj = g.aAj();
                        aAj.isRunning = true;
                        for (cm.a aVar : aAj.iGc) {
                            if (aVar != null) {
                                aVar.aWC();
                            }
                        }
                        aAj.isRunning = false;
                    }
                    g.aAi();
                    if (g.aAh() != null) {
                        g.aAi();
                        g.aAh().CL(str);
                    }
                    AppMethodBeat.o(132052);
                }
            });
            com.tencent.mm.kernel.g.aAi();
            an anVar = com.tencent.mm.kernel.g.aAh().hqB;
            Assert.assertTrue("setAutoAuth, getSysCfg() is null, stack = " + Util.getStack(), anVar != null);
            int ake = anVar.ake(47);
            String str = (String) anVar.get(2);
            String str2 = (String) anVar.get(3);
            String str3 = (String) anVar.get(6);
            String str4 = (String) anVar.get(7);
            String str5 = (String) anVar.get(25);
            String str6 = (String) anVar.get(24);
            o.a mJ = o.mJ(str3, str4);
            Log.d("MMKernel.CoreNetwork", "dkidc host[s:%s l:%s] builtin[s:%s l:%s] ports[%s] timeout[%s] mmtls[%d]", str6, str5, str, str2, str3, str4, Integer.valueOf(ake));
            Assert.assertTrue("setAutoAuth, autoAuth is null, stack = " + Util.getStack(), true);
            vVar.a(false, str, str2, mJ.KzK, mJ.KzL, mJ.KzM, mJ.KzN, str6, str5);
            vVar.fB((ake & 1) == 0);
            com.tencent.mm.kernel.g.aAi();
            com.tencent.mm.kernel.g.aAf();
            Assert.assertTrue("setAutoAuth, accInfo is null, stack = " + Util.getStack(), aZh != null);
            if (!com.tencent.mm.kernel.g.aAc() || !com.tencent.mm.kernel.g.aAf().hpY) {
                Log.w("MMKernel.CoreNetwork", "need to clear acc info and maybe stop networking accHasReady():%b isInitializedNotifyAllDone:%b", Boolean.valueOf(com.tencent.mm.kernel.g.aAc()), Boolean.valueOf(com.tencent.mm.kernel.g.aAf().hpY));
                e.INSTANCE.idkeyStat(148, com.tencent.mm.kernel.g.aAc() ? 44 : 43, 1, false);
                aZh.reset();
                vVar.reset();
                aAg.hqi.c(vVar);
                d.a(new d.a() {
                    /* class com.tencent.mm.kernel.b.AnonymousClass7 */

                    @Override // com.tencent.mm.network.d.a
                    public final g azD() {
                        AppMethodBeat.i(132053);
                        try {
                            g gVar = b.this.hqi.iMw;
                            AppMethodBeat.o(132053);
                            return gVar;
                        } catch (Throwable th) {
                            Log.e("MMKernel.CoreNetwork", "%s", Util.stackTraceToString(th));
                            AppMethodBeat.o(132053);
                            return null;
                        }
                    }
                });
                if (com.tencent.mm.kernel.a.getUin() != aZh.getUin()) {
                    e.INSTANCE.idkeyStat(148, 45, 1, false);
                    Log.w("MMKernel.CoreNetwork", "summerauth update acc info with acc stg: old acc uin=%d, acc stg uin=%d, acc init %b %b", Integer.valueOf(aZh.getUin()), Integer.valueOf(com.tencent.mm.kernel.a.getUin()), Boolean.valueOf(com.tencent.mm.kernel.g.aAf().azp()), Boolean.valueOf(com.tencent.mm.kernel.g.aAf().hpY));
                    aZh.setUin(com.tencent.mm.kernel.a.getUin());
                } else {
                    Log.i("MMKernel.CoreNetwork", "acc info uin same with acc stg", Integer.valueOf(aZh.getUin()), Integer.valueOf(com.tencent.mm.kernel.a.getUin()));
                }
            } else {
                aAg.hqi.c(vVar);
                d.a(new d.a() {
                    /* class com.tencent.mm.kernel.b.AnonymousClass8 */

                    @Override // com.tencent.mm.network.d.a
                    public final g azD() {
                        AppMethodBeat.i(132054);
                        try {
                            g gVar = b.this.hqi.iMw;
                            AppMethodBeat.o(132054);
                            return gVar;
                        } catch (Throwable th) {
                            Log.e("MMKernel.CoreNetwork", "%s", Util.stackTraceToString(th));
                            AppMethodBeat.o(132054);
                            return null;
                        }
                    }
                });
                Log.i("MMKernel.CoreNetwork", "setAutoAuth differrent accStg uin[%d], accInfo uin[%d], acc init[%b]", Integer.valueOf(com.tencent.mm.kernel.a.getUin()), Integer.valueOf(aZh.getUin()), Boolean.valueOf(com.tencent.mm.kernel.g.aAf().azp()));
                if (com.tencent.mm.kernel.a.getUin() != aZh.getUin()) {
                    Log.w("MMKernel.CoreNetwork", "update acc info with acc stg: uin =" + aZh.getUin());
                    String str7 = "setAutoAuth, getConfigStg() is null, stack = " + Util.getStack();
                    com.tencent.mm.kernel.g.aAi();
                    Assert.assertTrue(str7, com.tencent.mm.kernel.g.aAh().azQ() != null);
                    com.tencent.mm.kernel.g.aAi();
                    aZh.a(new byte[0], new byte[0], new byte[0], com.tencent.mm.kernel.a.getUin());
                    aZh.setUsername((String) com.tencent.mm.kernel.g.aAh().azQ().get(2, (Object) null));
                }
            }
        }
        if (com.tencent.mm.model.a.aSG()) {
            try {
                com.tencent.mm.kernel.g.aAi();
                if (com.tencent.mm.kernel.g.aAf().hpN != null) {
                    com.tencent.mm.kernel.g.aAi();
                    if (com.tencent.mm.kernel.g.aAg().hqi.iMw != null) {
                        com.tencent.mm.kernel.g.aAi();
                        com.tencent.mm.model.a aVar = com.tencent.mm.kernel.g.aAf().hpN;
                        com.tencent.mm.kernel.g.aAi();
                        com.tencent.mm.network.e aZh2 = com.tencent.mm.kernel.g.aAg().hqi.iMw.aZh();
                        long nowMilliSecond = Util.nowMilliSecond();
                        if (aZh2 == null) {
                            Log.e("MicroMsg.AccInfoCacheInWorker", "reuseToPush  accinfo == null");
                            e.INSTANCE.idkeyStat(226, 6, 1, false);
                        } else {
                            Log.i("MicroMsg.AccInfoCacheInWorker", "reuseToPush islogin:%b cache:%s", Boolean.valueOf(aZh2.aZb()), Integer.valueOf(aVar.aSF()));
                            if (aZh2.aZb()) {
                                if (aVar.aSF() > 0) {
                                    e.INSTANCE.idkeyStat(226, 7, 1, false);
                                    Log.e("MicroMsg.AccInfoCacheInWorker", "reuseToPush  something Error! islogin && isCacheValid . Clean Cache Now !");
                                    aVar.iBl = null;
                                } else {
                                    Log.w("MicroMsg.AccInfoCacheInWorker", "reuseToPush Here, DANGER! . HERE means worker just init , try set from push now!");
                                    e.INSTANCE.idkeyStat(226, 8, 1, false);
                                }
                                aVar.iBl = aZh2.aZe();
                                e eVar = e.INSTANCE;
                                if (aVar.aSF() > 0) {
                                    j2 = 9;
                                } else {
                                    j2 = 10;
                                }
                                eVar.idkeyStat(226, j2, 1, false);
                            } else if (aVar.aSF() <= 0) {
                                e.INSTANCE.idkeyStat(226, 11, 1, false);
                                Log.w("MicroMsg.AccInfoCacheInWorker", "reuseToPush something is null. give up %s", aVar.toString());
                            } else {
                                int al = aZh2.al(aVar.iBl);
                                Log.i("MicroMsg.AccInfoCacheInWorker", "reuseToPush parseBuf ret:%s time:%s  cache:%s", Integer.valueOf(al), Long.valueOf(Util.milliSecondsToNow(nowMilliSecond)), Integer.valueOf(aVar.aSF()));
                                if (al != 0) {
                                    Log.e("MicroMsg.AccInfoCacheInWorker", "reuseToPush parseBuf ret:%s", Integer.valueOf(al));
                                    aVar.iBl = null;
                                } else {
                                    aVar.iBm = 0;
                                }
                                e.INSTANCE.idkeyStat(226, (long) (al + 20), 1, false);
                            }
                        }
                    }
                }
                com.tencent.mm.kernel.g.aAi();
                com.tencent.mm.kernel.g.aAi();
                Log.i("MicroMsg.AccInfoCacheInWorker", "tryReuseToPush but object is null [%s, %s]", com.tencent.mm.kernel.g.aAf().hpN, com.tencent.mm.kernel.g.aAg().hqi.iMw);
            } catch (Throwable th) {
                Log.e("MicroMsg.AccInfoCacheInWorker", "tryReuseToPush Exception:%s", Util.stackTraceToString(th));
            }
        }
        if (com.tencent.mm.kernel.g.aAc()) {
            com.tencent.mm.kernel.g.aAi();
            if (com.tencent.mm.kernel.g.aAg().hqi != null) {
                com.tencent.mm.kernel.g.aAi();
                if (com.tencent.mm.kernel.g.aAg().hqi.iMw != null) {
                    com.tencent.mm.kernel.g.aAi();
                    com.tencent.mm.kernel.g.aAg().hqi.iMw.fz(true);
                }
            }
        }
        if (com.tencent.mm.kernel.g.aAc()) {
            EventCenter.instance.publish(new hc());
        }
        com.tencent.mm.blink.a.CM("onServiceConnected done");
        AppMethodBeat.o(131780);
    }

    static /* synthetic */ void a(g gVar) {
        AppMethodBeat.i(131781);
        com.tencent.mm.kernel.g.aAf();
        if (!com.tencent.mm.kernel.a.azo() || com.tencent.mm.kernel.a.azj()) {
            com.tencent.mm.kernel.g.aAi();
            com.tencent.mm.kernel.g.aAg().hqi.aYW();
            com.tencent.mm.kernel.g.aAi();
            com.tencent.mm.kernel.g.aAg().hqi.reset();
            AppMethodBeat.o(131781);
            return;
        }
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAg().hqi.aYV();
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAg().hqi.aYW();
        gVar.bG(MMApplicationContext.getContext());
        AppMethodBeat.o(131781);
    }
}
