package com.tencent.luggage.d;

import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.ConcurrentHashMap;

public final class l {
    public ConcurrentHashMap<f, Boolean> ctz = new ConcurrentHashMap<>();
    private Handler mMainHandler = new Handler(Looper.getMainLooper());

    public l() {
        AppMethodBeat.i(140410);
        AppMethodBeat.o(140410);
    }

    private static boolean LB() {
        AppMethodBeat.i(140411);
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            AppMethodBeat.o(140411);
            return true;
        }
        AppMethodBeat.o(140411);
        return false;
    }

    public final void a(f fVar) {
        AppMethodBeat.i(140412);
        this.ctz.put(fVar, Boolean.TRUE);
        AppMethodBeat.o(140412);
    }

    /* access modifiers changed from: package-private */
    public final boolean Q(Class<? extends f> cls) {
        AppMethodBeat.i(140413);
        if (!LB()) {
            Log.e("LuggagePageEventBus", "notifyListener on non-UI thread");
            AppMethodBeat.o(140413);
            return false;
        }
        for (f fVar : this.ctz.keySet()) {
            if (cls.isInstance(fVar)) {
                boolean call = fVar.call();
                if (this.ctz.get(fVar).booleanValue()) {
                    this.ctz.remove(fVar);
                }
                if (call) {
                    AppMethodBeat.o(140413);
                    return true;
                }
            }
        }
        AppMethodBeat.o(140413);
        return false;
    }

    public static abstract class f {
        public abstract boolean call();

        /* synthetic */ f(byte b2) {
            this();
        }

        private f() {
        }
    }

    public static abstract class e extends f {
        public abstract void onReady();

        public e() {
            super((byte) 0);
        }

        @Override // com.tencent.luggage.d.l.f
        public final boolean call() {
            onReady();
            return false;
        }
    }

    public static abstract class b extends f {
        public b() {
            super((byte) 0);
        }
    }

    public static abstract class d extends f {
        public d() {
            super((byte) 0);
        }
    }

    public static abstract class c extends f {
        public c() {
            super((byte) 0);
        }
    }

    public static abstract class a extends f {
        public abstract boolean onBackPressed();

        public a() {
            super((byte) 0);
        }

        @Override // com.tencent.luggage.d.l.f
        public final boolean call() {
            return onBackPressed();
        }
    }
}
