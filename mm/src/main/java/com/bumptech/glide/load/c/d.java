package com.bumptech.glide.load.c;

import android.util.Log;
import com.bumptech.glide.g;
import com.bumptech.glide.load.a.d;
import com.bumptech.glide.load.c.n;
import com.bumptech.glide.load.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class d implements n<File, ByteBuffer> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.bumptech.glide.load.c.n
    public final /* bridge */ /* synthetic */ boolean X(File file) {
        return true;
    }

    /* Return type fixed from 'com.bumptech.glide.load.c.n$a' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, int, com.bumptech.glide.load.i] */
    @Override // com.bumptech.glide.load.c.n
    public final /* synthetic */ n.a<ByteBuffer> b(File file, int i2, int i3, i iVar) {
        AppMethodBeat.i(77216);
        File file2 = file;
        n.a aVar = new n.a(new com.bumptech.glide.f.b(file2), new a(file2));
        AppMethodBeat.o(77216);
        return aVar;
    }

    public static class b implements o<File, ByteBuffer> {
        @Override // com.bumptech.glide.load.c.o
        public final n<File, ByteBuffer> a(r rVar) {
            AppMethodBeat.i(77215);
            d dVar = new d();
            AppMethodBeat.o(77215);
            return dVar;
        }
    }

    static final class a implements com.bumptech.glide.load.a.d<ByteBuffer> {
        private final File file;

        a(File file2) {
            this.file = file2;
        }

        @Override // com.bumptech.glide.load.a.d
        public final void a(g gVar, d.a<? super ByteBuffer> aVar) {
            AppMethodBeat.i(77214);
            try {
                aVar.S(com.bumptech.glide.g.a.v(this.file));
                AppMethodBeat.o(77214);
            } catch (IOException e2) {
                Log.isLoggable("ByteBufferFileLoader", 3);
                aVar.e(e2);
                AppMethodBeat.o(77214);
            }
        }

        @Override // com.bumptech.glide.load.a.d
        public final void cleanup() {
        }

        @Override // com.bumptech.glide.load.a.d
        public final void cancel() {
        }

        @Override // com.bumptech.glide.load.a.d
        public final Class<ByteBuffer> os() {
            return ByteBuffer.class;
        }

        @Override // com.bumptech.glide.load.a.d
        public final com.bumptech.glide.load.a ot() {
            return com.bumptech.glide.load.a.LOCAL;
        }
    }
}
