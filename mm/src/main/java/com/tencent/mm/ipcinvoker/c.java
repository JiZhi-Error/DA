package com.tencent.mm.ipcinvoker;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b.a;
import com.tencent.mm.ipcinvoker.h.b;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class c {
    private static volatile c hmH;
    Map<String, Class<?>> hmI = new HashMap();
    public final Map<String, a> hmJ = new ConcurrentHashMap();
    private volatile boolean hmK;
    final Map<String, Set<n>> hmL = new HashMap();
    final Map<String, Set<m>> hmM = new HashMap();
    private Handler mHandler = l.ayc();

    static /* synthetic */ void a(c cVar, String str) {
        AppMethodBeat.i(240216);
        cVar.t(str, true);
        AppMethodBeat.o(240216);
    }

    public static c axW() {
        AppMethodBeat.i(158721);
        if (hmH == null) {
            synchronized (c.class) {
                try {
                    if (hmH == null) {
                        hmH = new c();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(158721);
                    throw th;
                }
            }
        }
        c cVar = hmH;
        AppMethodBeat.o(158721);
        return cVar;
    }

    private c() {
        AppMethodBeat.i(158722);
        AppMethodBeat.o(158722);
    }

    public final com.tencent.mm.ipcinvoker.b.a Fn(final String str) {
        long j2;
        AppMethodBeat.i(158723);
        b.i("IPC.IPCBridgeManager", "[getIPCBridge] process:%s", str);
        a aVar = this.hmJ.get(str);
        if (aVar == null) {
            if (this.hmK) {
                b.i("IPC.IPCBridgeManager", "build IPCBridge(process : %s) failed, locked.", str);
                AppMethodBeat.o(158723);
                return null;
            } else if (Looper.getMainLooper() == Looper.myLooper()) {
                b.w("IPC.IPCBridgeManager", "getIPCBridge failed, can not create bridge on Main thread.", new Object[0]);
                AppMethodBeat.o(158723);
                return null;
            } else {
                String ar = com.tencent.mm.ipcinvoker.h.c.ar(str, g.getContext().getPackageName());
                Class<?> cls = this.hmI.get(ar + '/' + str);
                if (cls == null) {
                    b.w("IPC.IPCBridgeManager", "getServiceClass by '%s', got null.", str);
                    AppMethodBeat.o(158723);
                    return null;
                }
                final a aVar2 = new a((byte) 0);
                synchronized (this.hmJ) {
                    try {
                        this.hmJ.put(str, aVar2);
                    } finally {
                        AppMethodBeat.o(158723);
                    }
                }
                synchronized (aVar2) {
                    try {
                        aVar2.hmV = true;
                    } finally {
                        AppMethodBeat.o(158723);
                    }
                }
                final Context context = g.getContext();
                aVar2.serviceConnection = new ServiceConnection() {
                    /* class com.tencent.mm.ipcinvoker.c.AnonymousClass1 */

                    public final void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
                        AppMethodBeat.i(158717);
                        if (iBinder == null) {
                            b.i("IPC.IPCBridgeManager", "onServiceConnected(%s), but service is null", Integer.valueOf(aVar2.hashCode()));
                            context.unbindService(aVar2.serviceConnection);
                            c.this.hmJ.remove(str);
                            aVar2.serviceConnection = null;
                            aVar2.hmU = null;
                        } else {
                            b.i("IPC.IPCBridgeManager", "onServiceConnected(%s)", Integer.valueOf(aVar2.hashCode()));
                            aVar2.hmU = a.AbstractBinderC0353a.l(iBinder);
                            try {
                                iBinder.linkToDeath(new IBinder.DeathRecipient() {
                                    /* class com.tencent.mm.ipcinvoker.c.AnonymousClass1.AnonymousClass1 */

                                    public final void binderDied() {
                                        AppMethodBeat.i(240212);
                                        b.i("IPC.IPCBridgeManager", "binderDied(%d, tid:%d)", Integer.valueOf(aVar2.hashCode()), Long.valueOf(Thread.currentThread().getId()));
                                        com.tencent.mm.ipcinvoker.f.a aVar = new com.tencent.mm.ipcinvoker.f.a(str);
                                        c.a(c.this, str);
                                        aVar.binderDied();
                                        c.b(c.this, str);
                                        iBinder.unlinkToDeath(this, 0);
                                        AppMethodBeat.o(240212);
                                    }
                                }, 0);
                            } catch (RemoteException e2) {
                                b.e("IPC.IPCBridgeManager", "binder register linkToDeath listener error, %s", Log.getStackTraceString(e2));
                            }
                        }
                        if (aVar2.hmW != null) {
                            c.this.mHandler.removeCallbacks(aVar2.hmW);
                        }
                        synchronized (aVar2) {
                            try {
                                aVar2.hmV = false;
                                aVar2.notifyAll();
                                aVar2.hmW = null;
                            } finally {
                                AppMethodBeat.o(158717);
                            }
                        }
                    }

                    public final void onServiceDisconnected(ComponentName componentName) {
                        AppMethodBeat.i(158718);
                        b.i("IPC.IPCBridgeManager", "onServiceDisconnected(%s, tid : %s)", Integer.valueOf(aVar2.hashCode()), Long.valueOf(Thread.currentThread().getId()));
                        c.a(c.this, str);
                        com.tencent.mm.ipcinvoker.f.b.Ft(str);
                        c.c(c.this, str);
                        AppMethodBeat.o(158718);
                    }
                };
                try {
                    Intent className = new Intent().setClassName(ar, cls.getCanonicalName());
                    b.i("IPC.IPCBridgeManager", "bindService(bw : %s, tid : %s, intent : %s)", Integer.valueOf(aVar2.hashCode()), Long.valueOf(Thread.currentThread().getId()), className);
                    context.bindService(className, aVar2.serviceConnection, 33);
                    aVar2.hmW = new Runnable() {
                        /* class com.tencent.mm.ipcinvoker.c.AnonymousClass2 */

                        public final void run() {
                            AppMethodBeat.i(158719);
                            b.i("IPC.IPCBridgeManager", "on connect timeout(%s, tid : %s)", Integer.valueOf(aVar2.hashCode()), Long.valueOf(Thread.currentThread().getId()));
                            if (!aVar2.hmV) {
                                AppMethodBeat.o(158719);
                                return;
                            }
                            synchronized (aVar2) {
                                try {
                                    if (aVar2.hmV) {
                                        aVar2.hmV = false;
                                        aVar2.notifyAll();
                                        aVar2.hmW = null;
                                        synchronized (c.this.hmJ) {
                                            try {
                                                c.this.hmJ.remove(str);
                                            } finally {
                                                AppMethodBeat.o(158719);
                                            }
                                        }
                                    }
                                } finally {
                                    AppMethodBeat.o(158719);
                                }
                            }
                        }
                    };
                    Handler handler = this.mHandler;
                    Runnable runnable = aVar2.hmW;
                    if (Looper.myLooper() == Looper.getMainLooper()) {
                        j2 = 3000;
                    } else {
                        j2 = 10000;
                    }
                    handler.postDelayed(runnable, j2);
                    synchronized (aVar2) {
                        try {
                            if (aVar2.hmV) {
                                aVar2.wait();
                            }
                        } catch (Throwable th) {
                            AppMethodBeat.o(158723);
                            throw th;
                        }
                    }
                    synchronized (aVar2) {
                        try {
                            aVar2.hmV = false;
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                    aVar = aVar2;
                } catch (Exception e2) {
                    b.e("IPC.IPCBridgeManager", "bindService error : %s", Log.getStackTraceString(e2));
                    synchronized (this.hmJ) {
                        this.hmJ.remove(str);
                        synchronized (aVar2) {
                            aVar2.hmV = false;
                            AppMethodBeat.o(158723);
                            return null;
                        }
                    }
                } catch (Throwable th3) {
                    AppMethodBeat.o(158723);
                    throw th3;
                }
            }
        } else if (aVar.hmV) {
            try {
                synchronized (aVar) {
                    try {
                        if (aVar.hmV) {
                            aVar.wait();
                        }
                    } catch (Throwable th4) {
                        AppMethodBeat.o(158723);
                        throw th4;
                    }
                }
            } catch (InterruptedException e3) {
                b.e("IPC.IPCBridgeManager", "%s", e3);
            }
        }
        com.tencent.mm.ipcinvoker.b.a aVar3 = aVar.hmU;
        AppMethodBeat.o(158723);
        return aVar3;
    }

    public final boolean a(String str, m mVar) {
        AppMethodBeat.i(240214);
        if (mVar == null) {
            AppMethodBeat.o(240214);
            return false;
        }
        synchronized (this.hmM) {
            try {
                Set<m> set = this.hmM.get(str);
                if (set != null) {
                    return set.remove(mVar);
                }
                AppMethodBeat.o(240214);
                return false;
            } finally {
                AppMethodBeat.o(240214);
            }
        }
    }

    public final boolean Fo(String str) {
        AppMethodBeat.i(158724);
        if (g.Fp(str)) {
            AppMethodBeat.o(158724);
            return false;
        } else if (this.hmJ.get(str) != null) {
            AppMethodBeat.o(158724);
            return true;
        } else {
            AppMethodBeat.o(158724);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final void t(final String str, boolean z) {
        final a aVar;
        AppMethodBeat.i(240215);
        if (g.Fp(str)) {
            b.i("IPC.IPCBridgeManager", "the same process(%s), do not need to release IPCBridge.", str);
            AppMethodBeat.o(240215);
            return;
        }
        synchronized (this.hmJ) {
            try {
                aVar = this.hmJ.get(str);
            } finally {
                AppMethodBeat.o(240215);
            }
        }
        if (aVar == null) {
            b.i("IPC.IPCBridgeManager", "releaseIPCBridge(%s) failed, IPCBridgeWrapper is null.", str);
            AppMethodBeat.o(240215);
            return;
        }
        if (aVar.hmV) {
            synchronized (aVar) {
                try {
                    aVar.hmV = false;
                    aVar.notifyAll();
                } catch (Throwable th) {
                    AppMethodBeat.o(240215);
                    throw th;
                }
            }
        }
        if (aVar.serviceConnection == null) {
            b.i("IPC.IPCBridgeManager", "releaseIPCBridge(%s) failed, ServiceConnection is null.", str);
            AppMethodBeat.o(240215);
            return;
        }
        synchronized (this.hmL) {
            try {
                this.hmL.put(str, new HashSet());
            } catch (Throwable th2) {
                throw th2;
            }
        }
        final AnonymousClass3 r1 = new Runnable() {
            /* class com.tencent.mm.ipcinvoker.c.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(158720);
                synchronized (c.this.hmJ) {
                    try {
                        c.this.hmJ.remove(str);
                    } finally {
                        AppMethodBeat.o(158720);
                    }
                }
                synchronized (aVar) {
                    try {
                        aVar.hmU = null;
                        aVar.hmV = false;
                        aVar.serviceConnection = null;
                    } finally {
                        AppMethodBeat.o(158720);
                    }
                }
            }
        };
        if (z) {
            r1.run();
            AppMethodBeat.o(240215);
            return;
        }
        this.mHandler.post(new Runnable() {
            /* class com.tencent.mm.ipcinvoker.c.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(240213);
                ServiceConnection serviceConnection = aVar.serviceConnection;
                if (serviceConnection == null) {
                    b.i("IPC.IPCBridgeManager", "releaseIPCBridge(%s) failed, ServiceConnection is null.", str);
                    AppMethodBeat.o(240213);
                    return;
                }
                try {
                    g.getContext().unbindService(serviceConnection);
                } catch (Exception e2) {
                    b.e("IPC.IPCBridgeManager", "unbindService(%s) error, %s", str, Log.getStackTraceString(e2));
                }
                r1.run();
                AppMethodBeat.o(240213);
            }
        });
        AppMethodBeat.o(240215);
    }

    public final synchronized void axX() {
        this.hmK = true;
    }

    public static class a {
        com.tencent.mm.ipcinvoker.b.a hmU;
        public volatile boolean hmV;
        Runnable hmW;
        ServiceConnection serviceConnection;

        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }
    }

    static /* synthetic */ void b(c cVar, String str) {
        AppMethodBeat.i(158726);
        synchronized (cVar.hmM) {
            try {
                Set<m> set = cVar.hmM.get(str);
                if (set != null) {
                    for (m mVar : set) {
                        mVar.aye();
                    }
                }
            } finally {
                AppMethodBeat.o(158726);
            }
        }
    }

    static /* synthetic */ void c(c cVar, String str) {
        AppMethodBeat.i(240217);
        synchronized (cVar.hmL) {
            try {
                Set<n> set = cVar.hmL.get(str);
                if (set != null) {
                    for (n nVar : set) {
                        nVar.onDisconnect();
                    }
                }
            } finally {
                AppMethodBeat.o(240217);
            }
        }
    }
}
