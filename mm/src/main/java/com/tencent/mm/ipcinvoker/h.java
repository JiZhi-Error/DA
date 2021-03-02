package com.tencent.mm.ipcinvoker;

import android.os.Bundle;
import android.os.Parcelable;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b.b;
import com.tencent.mm.ipcinvoker.f.c;
import com.tencent.mm.ipcinvoker.h.b;
import java.util.HashSet;
import java.util.Set;

public class h {
    static /* synthetic */ Bundle d(Parcelable parcelable) {
        AppMethodBeat.i(158744);
        Bundle c2 = c(parcelable);
        AppMethodBeat.o(158744);
        return c2;
    }

    public static <T extends b<InputType, ResultType>, InputType extends Parcelable, ResultType extends Parcelable> boolean a(final String str, final InputType inputtype, final Class<T> cls, final d<ResultType> dVar) {
        AppMethodBeat.i(158740);
        if (str == null || str.length() == 0) {
            b.e("IPC.IPCInvoker", "invokeAsync failed, process is null or nil.", new Object[0]);
            AppMethodBeat.o(158740);
            return false;
        } else if (cls == null) {
            b.e("IPC.IPCInvoker", "invokeAsync failed, taskClass is null(process : %s).", str);
            AppMethodBeat.o(158740);
            return false;
        } else {
            boolean A = p.A(new Runnable() {
                /* class com.tencent.mm.ipcinvoker.h.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(158735);
                    if (g.Fp(str)) {
                        b bVar = (b) o.i(cls, b.class);
                        if (bVar == null) {
                            b.e("IPC.IPCInvoker", "invokeAsync failed, newInstance(%s) return null.", cls);
                            AppMethodBeat.o(158735);
                            return;
                        }
                        bVar.invoke(inputtype, dVar);
                        AppMethodBeat.o(158735);
                        return;
                    }
                    com.tencent.mm.ipcinvoker.b.a Fn = c.axW().Fn(str);
                    if (Fn == null) {
                        b.e("IPC.IPCInvoker", "invokeAsync failed, get bridge is null by process(%s).", str);
                        if (dVar instanceof e) {
                            ((e) dVar).axY();
                        }
                        AppMethodBeat.o(158735);
                        return;
                    }
                    a aVar = null;
                    try {
                        if (dVar != null) {
                            aVar = new a(str, dVar);
                        }
                        Fn.a(h.d(inputtype), cls.getName(), aVar);
                        AppMethodBeat.o(158735);
                    } catch (Exception e2) {
                        b.d("IPC.IPCInvoker", "invokeAsync failed, ipc invoke error : %s", e2);
                        if (dVar instanceof e) {
                            ((e) dVar).i(e2);
                        }
                        AppMethodBeat.o(158735);
                    }
                }
            });
            AppMethodBeat.o(158740);
            return A;
        }
    }

    public static void a(String str, n nVar) {
        AppMethodBeat.i(158741);
        c axW = c.axW();
        synchronized (axW.hmL) {
            try {
                Set<n> set = axW.hmL.get(str);
                if (set == null) {
                    set = new HashSet<>();
                }
                set.add(nVar);
                axW.hmL.put(str, set);
            } finally {
                AppMethodBeat.o(158741);
            }
        }
    }

    public static void b(String str, m mVar) {
        AppMethodBeat.i(240218);
        c axW = c.axW();
        synchronized (axW.hmM) {
            try {
                Set<m> set = axW.hmM.get(str);
                if (set == null) {
                    set = new HashSet<>();
                }
                set.add(mVar);
                axW.hmM.put(str, set);
            } finally {
                AppMethodBeat.o(240218);
            }
        }
    }

    public static boolean a(String str, m mVar) {
        AppMethodBeat.i(240219);
        boolean a2 = c.axW().a(str, mVar);
        AppMethodBeat.o(240219);
        return a2;
    }

    public static <T extends k<InputType, ResultType>, InputType extends Parcelable, ResultType extends Parcelable> ResultType a(String str, InputType inputtype, Class<T> cls) {
        AppMethodBeat.i(158742);
        if (str == null || str.length() == 0) {
            b.e("IPC.IPCInvoker", "invokeSync failed, process is null or nil.", new Object[0]);
            AppMethodBeat.o(158742);
            return null;
        } else if (cls == null) {
            b.e("IPC.IPCInvoker", "invokeSync failed, taskClass is null(process : %s).", str);
            AppMethodBeat.o(158742);
            return null;
        } else if (g.Fp(str)) {
            Object invoke = ((k) o.i(cls, k.class)).invoke(inputtype);
            if (invoke == null) {
                AppMethodBeat.o(158742);
                return null;
            }
            ResultType resulttype = (ResultType) ((Parcelable) invoke);
            AppMethodBeat.o(158742);
            return resulttype;
        } else {
            com.tencent.mm.ipcinvoker.b.a Fn = c.axW().Fn(str);
            if (Fn == null) {
                b.e("IPC.IPCInvoker", "invokeSync failed, get bridge is null by process(%s).", str);
                AppMethodBeat.o(158742);
                return null;
            }
            try {
                Bundle e2 = Fn.e(c(inputtype), cls.getName());
                if (e2 == null) {
                    AppMethodBeat.o(158742);
                    return null;
                }
                e2.setClassLoader(h.class.getClassLoader());
                ResultType resulttype2 = (ResultType) e2.getParcelable("__remote_task_result_data");
                AppMethodBeat.o(158742);
                return resulttype2;
            } catch (RemoteException e3) {
                b.d("IPC.IPCInvoker", "invokeSync failed, ipc invoke error : %s", e3);
                AppMethodBeat.o(158742);
                return null;
            }
        }
    }

    private static Bundle c(Parcelable parcelable) {
        AppMethodBeat.i(158743);
        Bundle bundle = new Bundle();
        bundle.putParcelable("__remote_task_data", parcelable);
        AppMethodBeat.o(158743);
        return bundle;
    }

    static class a extends b.a implements c {
        String hmX;
        d hnd;

        a(String str, d dVar) {
            AppMethodBeat.i(158736);
            this.hnd = dVar;
            this.hmX = str;
            com.tencent.mm.ipcinvoker.f.b.a(str, this);
            com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCInvokeCallbackWrapper", "keep ref of callback(%s)", Integer.valueOf(dVar.hashCode()));
            AppMethodBeat.o(158736);
        }

        @Override // com.tencent.mm.ipcinvoker.b.b
        public final void v(Bundle bundle) {
            AppMethodBeat.i(158737);
            d dVar = this.hnd;
            if (dVar == null) {
                com.tencent.mm.ipcinvoker.h.b.w("IPC.IPCInvokeCallbackWrapper", "callback failed, ref has been release", new Object[0]);
                AppMethodBeat.o(158737);
            } else if (bundle == null) {
                dVar.bn(null);
                AppMethodBeat.o(158737);
            } else {
                bundle.setClassLoader(h.class.getClassLoader());
                if (bundle.getBoolean("__command_release_ref")) {
                    com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCInvokeCallbackWrapper", "release ref of callback(%s)", Integer.valueOf(dVar.hashCode()));
                    recycle();
                    AppMethodBeat.o(158737);
                    return;
                }
                dVar.bn(bundle.getParcelable("__remote_task_result_data"));
                AppMethodBeat.o(158737);
            }
        }

        @Override // com.tencent.mm.ipcinvoker.f.c
        public final void recycle() {
            AppMethodBeat.i(158738);
            this.hnd = null;
            com.tencent.mm.ipcinvoker.f.b.b(this.hmX, this);
            AppMethodBeat.o(158738);
        }

        /* access modifiers changed from: protected */
        @Override // java.lang.Object
        public final void finalize() {
            AppMethodBeat.i(158739);
            recycle();
            com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCInvokeCallbackWrapper", "finalize(%s)", Integer.valueOf(hashCode()));
            super.finalize();
            AppMethodBeat.o(158739);
        }
    }
}
