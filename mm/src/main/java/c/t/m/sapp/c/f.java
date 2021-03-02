package c.t.m.sapp.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import dalvik.system.DexClassLoader;

public class f {

    /* renamed from: a  reason: collision with root package name */
    public static DexClassLoader f64a;

    /* renamed from: b  reason: collision with root package name */
    public static Context f65b;

    /* renamed from: c  reason: collision with root package name */
    public static f f66c;

    public f(Context context) {
        AppMethodBeat.i(222962);
        f65b = context;
        n.a(context).a();
        AppMethodBeat.o(222962);
    }

    public static f a(Context context) {
        AppMethodBeat.i(222963);
        if (f66c == null) {
            synchronized (f.class) {
                try {
                    if (f66c == null) {
                        f66c = new f(context);
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(222963);
                    throw th;
                }
            }
        }
        f fVar = f66c;
        AppMethodBeat.o(222963);
        return fVar;
    }

    public void b() {
        AppMethodBeat.i(222965);
        try {
            new Thread(new i(f65b, q.e(q.a(f65b, "__SP_Tencent_Loc_COMP_INFO__sapp_", "")), false)).start();
            AppMethodBeat.o(222965);
        } catch (Throwable th) {
            AppMethodBeat.o(222965);
        }
    }

    public void c() {
        f66c = null;
        f64a = null;
    }

    public synchronized DexClassLoader a() {
        DexClassLoader dexClassLoader;
        AppMethodBeat.i(222964);
        dexClassLoader = f64a;
        if (dexClassLoader != null) {
            AppMethodBeat.o(222964);
        } else {
            Context context = f65b;
            if (context == null) {
                dexClassLoader = null;
                AppMethodBeat.o(222964);
            } else {
                d.a(context).b("load_sapp");
                q.f97e = System.currentTimeMillis();
                DexClassLoader b2 = h.a(f65b).b();
                f64a = b2;
                if (b2 != null) {
                    e.a(f65b).a();
                }
                b();
                d.a(f65b).c("load_sapp");
                dexClassLoader = f64a;
                AppMethodBeat.o(222964);
            }
        }
        return dexClassLoader;
    }
}
