package com.bumptech.glide.load.c;

import android.util.Log;
import com.bumptech.glide.g.a;
import com.bumptech.glide.load.d;
import com.bumptech.glide.load.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class c implements d<ByteBuffer> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.io.File, com.bumptech.glide.load.i] */
    @Override // com.bumptech.glide.load.d
    public final /* bridge */ /* synthetic */ boolean a(ByteBuffer byteBuffer, File file, i iVar) {
        AppMethodBeat.i(77213);
        boolean a2 = a(byteBuffer, file);
        AppMethodBeat.o(77213);
        return a2;
    }

    private static boolean a(ByteBuffer byteBuffer, File file) {
        AppMethodBeat.i(77212);
        boolean z = false;
        try {
            a.b(byteBuffer, file);
            z = true;
        } catch (IOException e2) {
            Log.isLoggable("ByteBufferEncoder", 3);
        }
        AppMethodBeat.o(77212);
        return z;
    }
}
