package com.tencent.mm.ipcinvoker;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.os.Process;
import android.os.RemoteException;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.ipcinvoker.b.a;
import com.tencent.mm.ipcinvoker.b.b;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public abstract class BaseIPCService extends Service {
    private volatile boolean hmv;
    private volatile boolean hmw;
    private a.AbstractBinderC0353a hmx = new a.AbstractBinderC0353a() {
        /* class com.tencent.mm.ipcinvoker.BaseIPCService.AnonymousClass1 */

        @Override // com.tencent.mm.ipcinvoker.b.a
        public final void a(Bundle bundle, final String str, final b bVar) {
            AppMethodBeat.i(158708);
            if (str == null || str.length() == 0) {
                com.tencent.mm.ipcinvoker.h.b.e("IPC.BaseIPCService", "invokeAsync failed, class is null or nil.", new Object[0]);
                AppMethodBeat.o(158708);
            } else if (bundle == null) {
                com.tencent.mm.ipcinvoker.h.b.e("IPC.BaseIPCService", "invokeAsync failed, data is null.", new Object[0]);
                AppMethodBeat.o(158708);
            } else {
                bundle.setClassLoader(BaseIPCService.class.getClassLoader());
                final Parcelable parcelable = bundle.getParcelable("__remote_task_data");
                final b bVar2 = (b) o.b(str, b.class);
                if (bVar2 == null) {
                    com.tencent.mm.ipcinvoker.h.b.e("IPC.BaseIPCService", "invokeAsync failed, can not newInstance by class %s.", str);
                    AppMethodBeat.o(158708);
                    return;
                }
                com.tencent.mm.ipcinvoker.h.b.i("IPC.BaseIPCService", "invokeAsync in target process, before ThreadPool.post, clazz=%s", str);
                l.post(new Runnable() {
                    /* class com.tencent.mm.ipcinvoker.BaseIPCService.AnonymousClass1.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(158707);
                        try {
                            bVar2.invoke(parcelable, new a(bVar));
                            AppMethodBeat.o(158707);
                        } catch (NullPointerException e2) {
                            com.tencent.mm.ipcinvoker.h.b.e("IPC.BaseIPCService", "invoke task, clazz=%s, npe=%s", str, e2);
                            AppMethodBeat.o(158707);
                        }
                    }
                });
                AppMethodBeat.o(158708);
            }
        }

        @Override // com.tencent.mm.ipcinvoker.b.a
        public final Bundle e(Bundle bundle, String str) {
            AppMethodBeat.i(158709);
            if (str == null || str.length() == 0) {
                com.tencent.mm.ipcinvoker.h.b.e("IPC.BaseIPCService", "invokeSync failed, class is null or nil.", new Object[0]);
                AppMethodBeat.o(158709);
                return null;
            } else if (bundle == null) {
                com.tencent.mm.ipcinvoker.h.b.e("IPC.BaseIPCService", "invokeSync failed, data is null.", new Object[0]);
                AppMethodBeat.o(158709);
                return null;
            } else {
                k kVar = (k) o.b(str, k.class);
                if (kVar == null) {
                    com.tencent.mm.ipcinvoker.h.b.e("IPC.BaseIPCService", "invokeSync failed, can not newInstance by class %s.", str);
                    AppMethodBeat.o(158709);
                    return null;
                }
                bundle.setClassLoader(BaseIPCService.class.getClassLoader());
                Parcelable parcelable = bundle.getParcelable("__remote_task_data");
                Bundle bundle2 = new Bundle();
                bundle2.putParcelable("__remote_task_result_data", (Parcelable) kVar.invoke(parcelable));
                AppMethodBeat.o(158709);
                return bundle2;
            }
        }
    };

    public abstract String getProcessName();

    public IBinder onBind(Intent intent) {
        com.tencent.mm.ipcinvoker.h.b.i("IPC.BaseIPCService", "onBind(%s), killSelf(%s)", intent, Boolean.valueOf(this.hmv));
        if (this.hmv) {
            com.tencent.mm.ipcinvoker.h.b.i("IPC.BaseIPCService", "need to kill self, return null Binder object.", new Object[0]);
            return null;
        }
        j aya = j.aya();
        String axZ = g.axZ();
        if (!(axZ == null || axZ.length() == 0)) {
            aya.hng.put(axZ, this);
        }
        this.hmw = true;
        return this.hmx;
    }

    public boolean onUnbind(Intent intent) {
        com.tencent.mm.ipcinvoker.h.b.i("IPC.BaseIPCService", "onUnbind(%s)", intent);
        boolean onUnbind = super.onUnbind(intent);
        this.hmw = false;
        return onUnbind;
    }

    public final void eo(boolean z) {
        if (!this.hmw || z) {
            com.tencent.mm.ipcinvoker.h.b.i("IPC.BaseIPCService", "kill self(%s)", getProcessName());
            this.hmv = true;
            c.axW().axX();
            c axW = c.axW();
            com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCBridgeManager", "releaseAllIPCBridge", new Object[0]);
            if (!axW.hmJ.isEmpty()) {
                synchronized (axW.hmJ) {
                    if (!axW.hmJ.isEmpty()) {
                        HashSet<String> hashSet = new HashSet(axW.hmJ.keySet());
                        if (!hashSet.isEmpty()) {
                            for (String str : hashSet) {
                                axW.t(str, false);
                            }
                        }
                    }
                }
            }
            stopSelf();
            j aya = j.aya();
            aya.hng.remove(getProcessName());
            l.x(new Runnable() {
                /* class com.tencent.mm.ipcinvoker.BaseIPCService.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(158710);
                    com.tencent.mm.hellhoundlib.b.a a2 = c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
                    Object obj = new Object();
                    com.tencent.mm.hellhoundlib.a.a.a(obj, a2.axQ(), "com/tencent/mm/ipcinvoker/BaseIPCService$2", "run", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
                    Process.killProcess(((Integer) a2.pG(0)).intValue());
                    com.tencent.mm.hellhoundlib.a.a.a(obj, "com/tencent/mm/ipcinvoker/BaseIPCService$2", "run", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
                    AppMethodBeat.o(158710);
                }
            });
            return;
        }
        com.tencent.mm.ipcinvoker.h.b.i("IPC.BaseIPCService", "abort kill self(%s), the service was connected by other process.", getProcessName());
    }

    static class a implements d<Parcelable>, com.tencent.mm.ipcinvoker.e.a {
        b hmE;
        final List<com.tencent.mm.ipcinvoker.e.b> hmF = new LinkedList();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.ipcinvoker.d
        public final /* synthetic */ void bn(Parcelable parcelable) {
            AppMethodBeat.i(158716);
            Parcelable parcelable2 = parcelable;
            if (this.hmE != null) {
                com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCInvokeCallbackProxy", "onCallback(%s)", Integer.valueOf(this.hmE.hashCode()));
                try {
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("__remote_task_result_data", parcelable2);
                    this.hmE.v(bundle);
                    AppMethodBeat.o(158716);
                    return;
                } catch (RemoteException e2) {
                    com.tencent.mm.ipcinvoker.h.b.e("IPC.IPCInvokeCallbackProxy", "%s", Log.getStackTraceString(e2));
                    if (!this.hmF.isEmpty()) {
                        synchronized (this.hmF) {
                            for (com.tencent.mm.ipcinvoker.e.b bVar : new LinkedList(this.hmF)) {
                                bVar.j(e2);
                            }
                        }
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(158716);
                    throw th;
                }
            }
            AppMethodBeat.o(158716);
        }

        public a(b bVar) {
            AppMethodBeat.i(158713);
            this.hmE = bVar;
            if (bVar != null) {
                com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCInvokeCallbackProxy", "keep ref of callback(%s)", Integer.valueOf(bVar.hashCode()));
                com.tencent.mm.ipcinvoker.f.b.br(bVar);
            }
            AppMethodBeat.o(158713);
        }

        /* access modifiers changed from: protected */
        public final void finalize() {
            AppMethodBeat.i(158714);
            try {
                com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCInvokeCallbackProxy", "finalize(%s)", Integer.valueOf(hashCode()));
                if (this.hmE != null) {
                    com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCInvokeCallbackProxy", "finalize, release callback(%s)", Integer.valueOf(this.hmE.hashCode()));
                    l.post(new RunnableC0351a(this.hmE));
                    this.hmE = null;
                }
            } finally {
                super.finalize();
                AppMethodBeat.o(158714);
            }
        }

        @Override // com.tencent.mm.ipcinvoker.e.a
        public final void a(com.tencent.mm.ipcinvoker.e.b bVar) {
            AppMethodBeat.i(158715);
            if (bVar == null) {
                AppMethodBeat.o(158715);
                return;
            }
            synchronized (this.hmF) {
                try {
                    if (!this.hmF.contains(bVar)) {
                        this.hmF.add(bVar);
                        AppMethodBeat.o(158715);
                    }
                } finally {
                    AppMethodBeat.o(158715);
                }
            }
        }

        /* renamed from: com.tencent.mm.ipcinvoker.BaseIPCService$a$a  reason: collision with other inner class name */
        static class RunnableC0351a implements Runnable {
            private static final Bundle hmG;
            b hmE;

            static {
                AppMethodBeat.i(158712);
                Bundle bundle = new Bundle();
                hmG = bundle;
                bundle.putBoolean("__command_release_ref", true);
                AppMethodBeat.o(158712);
            }

            RunnableC0351a(b bVar) {
                this.hmE = bVar;
            }

            public final void run() {
                AppMethodBeat.i(158711);
                try {
                    com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCInvokeCallbackProxy", "notify release ref of callback(%s).", Integer.valueOf(this.hmE.hashCode()));
                    this.hmE.v(hmG);
                    com.tencent.mm.ipcinvoker.f.b.bs(this.hmE);
                    this.hmE = null;
                    AppMethodBeat.o(158711);
                } catch (RemoteException e2) {
                    com.tencent.mm.ipcinvoker.h.b.e("IPC.IPCInvokeCallbackProxy", "notify release ref error, %s", Log.getStackTraceString(e2));
                    AppMethodBeat.o(158711);
                } catch (Exception e3) {
                    com.tencent.mm.ipcinvoker.h.b.e("IPC.IPCInvokeCallbackProxy", "notify release ref error, %s\n %s", e3.getMessage(), Log.getStackTraceString(e3));
                    AppMethodBeat.o(158711);
                }
            }
        }
    }
}
