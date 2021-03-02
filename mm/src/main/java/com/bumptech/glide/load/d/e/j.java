package com.bumptech.glide.load.d.e;

import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.b.a.b;
import com.bumptech.glide.load.b.v;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public final class j implements com.bumptech.glide.load.j<InputStream, c> {
    private final b aFo;
    private final List<ImageHeaderParser> aFx;
    private final com.bumptech.glide.load.j<ByteBuffer, c> aMe;

    /* Return type fixed from 'com.bumptech.glide.load.b.v' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, int, com.bumptech.glide.load.i] */
    @Override // com.bumptech.glide.load.j
    public final /* synthetic */ v<c> a(InputStream inputStream, int i2, int i3, i iVar) {
        AppMethodBeat.i(77527);
        byte[] d2 = d(inputStream);
        if (d2 == null) {
            AppMethodBeat.o(77527);
            return null;
        }
        v<c> a2 = this.aMe.a(ByteBuffer.wrap(d2), i2, i3, iVar);
        AppMethodBeat.o(77527);
        return a2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.bumptech.glide.load.i] */
    @Override // com.bumptech.glide.load.j
    public final /* synthetic */ boolean a(InputStream inputStream, i iVar) {
        AppMethodBeat.i(77528);
        InputStream inputStream2 = inputStream;
        if (((Boolean) iVar.a(i.aMd)).booleanValue() || f.a(this.aFx, inputStream2, this.aFo) != ImageHeaderParser.ImageType.GIF) {
            AppMethodBeat.o(77528);
            return false;
        }
        AppMethodBeat.o(77528);
        return true;
    }

    public j(List<ImageHeaderParser> list, com.bumptech.glide.load.j<ByteBuffer, c> jVar, b bVar) {
        this.aFx = list;
        this.aMe = jVar;
        this.aFo = bVar;
    }

    private static byte[] d(InputStream inputStream) {
        AppMethodBeat.i(77526);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        try {
            byte[] bArr = new byte[16384];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byteArrayOutputStream.flush();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    AppMethodBeat.o(77526);
                    return byteArray;
                }
            }
        } catch (IOException e2) {
            Log.isLoggable("StreamGifDecoder", 5);
            AppMethodBeat.o(77526);
            return null;
        }
    }
}
