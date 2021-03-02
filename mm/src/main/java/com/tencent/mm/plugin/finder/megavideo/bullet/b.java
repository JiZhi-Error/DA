package com.tencent.mm.plugin.finder.megavideo.bullet;

import android.content.Context;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.q;

public final class b {
    private static final f uJY = g.ah(C1213b.uKa);
    public static final a uJZ = new a((byte) 0);
    public HandlerThread uJW;
    private final HashSet<WeakReference<Context>> uJX = new HashSet<>();

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public b() {
        AppMethodBeat.i(248262);
        AppMethodBeat.o(248262);
    }

    static {
        AppMethodBeat.i(248263);
        AppMethodBeat.o(248263);
    }

    /* renamed from: com.tencent.mm.plugin.finder.megavideo.bullet.b$b */
    static final class C1213b extends q implements kotlin.g.a.a<b> {
        public static final C1213b uKa = new C1213b();

        static {
            AppMethodBeat.i(248261);
            AppMethodBeat.o(248261);
        }

        C1213b() {
            super(0);
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ b invoke() {
            AppMethodBeat.i(248260);
            b bVar = new b();
            AppMethodBeat.o(248260);
            return bVar;
        }
    }
}
