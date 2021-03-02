package com.bumptech.glide.load.d.e;

import android.util.Log;
import com.bumptech.glide.g.a;
import com.bumptech.glide.load.b.v;
import com.bumptech.glide.load.c;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.IOException;

public final class d implements k<c> {
    @Override // com.bumptech.glide.load.d
    public final /* bridge */ /* synthetic */ boolean a(Object obj, File file, i iVar) {
        AppMethodBeat.i(77502);
        boolean a2 = a((v) obj, file);
        AppMethodBeat.o(77502);
        return a2;
    }

    @Override // com.bumptech.glide.load.k
    public final c b(i iVar) {
        return c.SOURCE;
    }

    private static boolean a(v<c> vVar, File file) {
        boolean z;
        AppMethodBeat.i(77501);
        try {
            a.b(vVar.get().getBuffer(), file);
            z = true;
        } catch (IOException e2) {
            Log.isLoggable("GifEncoder", 5);
            z = false;
        }
        AppMethodBeat.o(77501);
        return z;
    }
}
