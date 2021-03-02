package com.tencent.mm.plugin.music.f.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.ConcurrentHashMap;

public final class b {
    private static b Amn = null;
    private ConcurrentHashMap<Class<? extends a>, a> Amo = new ConcurrentHashMap<>();
    private Context ctx;

    private b(Context context) {
        AppMethodBeat.i(137414);
        this.ctx = context;
        AppMethodBeat.o(137414);
    }

    public static synchronized void init(Context context) {
        synchronized (b.class) {
            AppMethodBeat.i(137415);
            if (Amn != null) {
                AppMethodBeat.o(137415);
            } else {
                Log.i("MicroMsg.Audio.AudioPlayerCoreService", "create");
                Amn = new b(context);
                AppMethodBeat.o(137415);
            }
        }
    }

    private static b eva() {
        AppMethodBeat.i(137416);
        if (Amn == null) {
            init(null);
        }
        b bVar = Amn;
        AppMethodBeat.o(137416);
        return bVar;
    }

    public static synchronized void release() {
        synchronized (b.class) {
            AppMethodBeat.i(137417);
            Log.i("MicroMsg.Audio.AudioPlayerCoreService", "release");
            b bVar = Amn;
            bVar.Amo.clear();
            bVar.ctx = null;
            Amn = null;
            AppMethodBeat.o(137417);
        }
    }

    public static void a(Class<? extends a> cls, a aVar) {
        AppMethodBeat.i(137418);
        eva().Amo.put(cls, aVar);
        AppMethodBeat.o(137418);
    }

    public static void ag(Class<? extends a> cls) {
        AppMethodBeat.i(137419);
        eva().Amo.remove(cls);
        AppMethodBeat.o(137419);
    }

    public static <T extends a> T aS(Class<T> cls) {
        AppMethodBeat.i(137420);
        T t = (T) eva().Amo.get(cls);
        AppMethodBeat.o(137420);
        return t;
    }
}
