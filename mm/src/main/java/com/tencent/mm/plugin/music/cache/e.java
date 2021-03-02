package com.tencent.mm.plugin.music.cache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.j;
import com.tencent.mm.plugin.music.c.a;
import com.tencent.mm.plugin.music.f.c.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class e {
    public static boolean etK() {
        AppMethodBeat.i(137164);
        if (b.aS(c.class) != null) {
            AppMethodBeat.o(137164);
            return true;
        }
        AppMethodBeat.o(137164);
        return false;
    }

    public static String getAccPath() {
        AppMethodBeat.i(137165);
        if (etK()) {
            String accPath = ((c) b.aS(c.class)).getAccPath();
            if (!Util.isNullOrNil(accPath)) {
                AppMethodBeat.o(137165);
                return accPath;
            }
        }
        Log.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
        String aKJ = com.tencent.mm.loader.j.b.aKJ();
        AppMethodBeat.o(137165);
        return aKJ;
    }

    public static j aHs(String str) {
        AppMethodBeat.i(137166);
        if (etK()) {
            j aHs = ((c) b.aS(c.class)).aHs(str);
            AppMethodBeat.o(137166);
            return aHs;
        }
        Log.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
        AppMethodBeat.o(137166);
        return null;
    }

    public static void t(String str, byte[] bArr) {
        AppMethodBeat.i(137167);
        if (etK()) {
            ((c) b.aS(c.class)).t(str, bArr);
            AppMethodBeat.o(137167);
            return;
        }
        Log.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
        AppMethodBeat.o(137167);
    }

    public static void eS(String str, int i2) {
        AppMethodBeat.i(137168);
        if (etK()) {
            ((c) b.aS(c.class)).eS(str, i2);
        }
        AppMethodBeat.o(137168);
    }

    public static a aHw(String str) {
        AppMethodBeat.i(137169);
        if (etK()) {
            a aHw = ((c) b.aS(c.class)).aHw(str);
            AppMethodBeat.o(137169);
            return aHw;
        }
        Log.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
        a aVar = new a();
        AppMethodBeat.o(137169);
        return aVar;
    }

    public static void a(String str, a aVar) {
        AppMethodBeat.i(137170);
        if (etK()) {
            ((c) b.aS(c.class)).a(str, aVar);
            AppMethodBeat.o(137170);
            return;
        }
        Log.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
        AppMethodBeat.o(137170);
    }
}
