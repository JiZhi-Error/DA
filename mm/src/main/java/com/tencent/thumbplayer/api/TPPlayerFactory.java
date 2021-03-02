package com.tencent.thumbplayer.api;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.g.b;
import com.tencent.thumbplayer.g.e;

public class TPPlayerFactory {
    public static ITPPlayer createTPPlayer(Context context) {
        AppMethodBeat.i(189021);
        b bVar = new b(context);
        AppMethodBeat.o(189021);
        return bVar;
    }

    public static ITPPlayer createTPPlayer(Context context, com.tencent.thumbplayer.f.b bVar) {
        AppMethodBeat.i(189022);
        b bVar2 = new b(context, null, null, bVar);
        AppMethodBeat.o(189022);
        return bVar2;
    }

    public static ITPPlayer createTPPlayer(Context context, Looper looper) {
        AppMethodBeat.i(189023);
        b bVar = new b(context, looper);
        AppMethodBeat.o(189023);
        return bVar;
    }

    public static ITPPlayer createTPPlayer(Context context, Looper looper, Looper looper2) {
        AppMethodBeat.i(189024);
        b bVar = new b(context, looper, looper2);
        AppMethodBeat.o(189024);
        return bVar;
    }

    public static ITPPlayer createTPPlayer(Context context, Looper looper, Looper looper2, com.tencent.thumbplayer.f.b bVar) {
        AppMethodBeat.i(189025);
        b bVar2 = new b(context, looper, looper2, bVar);
        AppMethodBeat.o(189025);
        return bVar2;
    }

    public static ITPSurface createTPSurface(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(189026);
        e eVar = new e(surfaceTexture);
        AppMethodBeat.o(189026);
        return eVar;
    }
}
