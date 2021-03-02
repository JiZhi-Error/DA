package com.bumptech.glide.load.c;

import com.bumptech.glide.g;
import com.bumptech.glide.load.a.d;
import com.bumptech.glide.load.c.n;
import com.bumptech.glide.load.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class b<Data> implements n<byte[], Data> {
    private final AbstractC0072b<Data> aJG;

    /* renamed from: com.bumptech.glide.load.c.b$b  reason: collision with other inner class name */
    public interface AbstractC0072b<Data> {
        Data l(byte[] bArr);

        Class<Data> os();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.bumptech.glide.load.c.n
    public final /* bridge */ /* synthetic */ boolean X(byte[] bArr) {
        return true;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, int, com.bumptech.glide.load.i] */
    @Override // com.bumptech.glide.load.c.n
    public final /* synthetic */ n.a b(byte[] bArr, int i2, int i3, i iVar) {
        AppMethodBeat.i(77211);
        byte[] bArr2 = bArr;
        n.a aVar = new n.a(new com.bumptech.glide.f.b(bArr2), new c(bArr2, this.aJG));
        AppMethodBeat.o(77211);
        return aVar;
    }

    public b(AbstractC0072b<Data> bVar) {
        this.aJG = bVar;
    }

    static class c<Data> implements com.bumptech.glide.load.a.d<Data> {
        private final AbstractC0072b<Data> aJG;
        private final byte[] aJI;

        c(byte[] bArr, AbstractC0072b<Data> bVar) {
            this.aJI = bArr;
            this.aJG = bVar;
        }

        @Override // com.bumptech.glide.load.a.d
        public final void a(g gVar, d.a<? super Data> aVar) {
            AppMethodBeat.i(77207);
            aVar.S(this.aJG.l(this.aJI));
            AppMethodBeat.o(77207);
        }

        @Override // com.bumptech.glide.load.a.d
        public final void cleanup() {
        }

        @Override // com.bumptech.glide.load.a.d
        public final void cancel() {
        }

        @Override // com.bumptech.glide.load.a.d
        public final Class<Data> os() {
            AppMethodBeat.i(77208);
            Class<Data> os = this.aJG.os();
            AppMethodBeat.o(77208);
            return os;
        }

        @Override // com.bumptech.glide.load.a.d
        public final com.bumptech.glide.load.a ot() {
            return com.bumptech.glide.load.a.LOCAL;
        }
    }

    public static class a implements o<byte[], ByteBuffer> {
        @Override // com.bumptech.glide.load.c.o
        public final n<byte[], ByteBuffer> a(r rVar) {
            AppMethodBeat.i(77206);
            b bVar = new b(new AbstractC0072b<ByteBuffer>() {
                /* class com.bumptech.glide.load.c.b.a.AnonymousClass1 */

                @Override // com.bumptech.glide.load.c.b.AbstractC0072b
                public final Class<ByteBuffer> os() {
                    return ByteBuffer.class;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // com.bumptech.glide.load.c.b.AbstractC0072b
                public final /* synthetic */ ByteBuffer l(byte[] bArr) {
                    AppMethodBeat.i(77205);
                    ByteBuffer wrap = ByteBuffer.wrap(bArr);
                    AppMethodBeat.o(77205);
                    return wrap;
                }
            });
            AppMethodBeat.o(77206);
            return bVar;
        }
    }

    public static class d implements o<byte[], InputStream> {
        @Override // com.bumptech.glide.load.c.o
        public final n<byte[], InputStream> a(r rVar) {
            AppMethodBeat.i(77210);
            b bVar = new b(new AbstractC0072b<InputStream>() {
                /* class com.bumptech.glide.load.c.b.d.AnonymousClass1 */

                @Override // com.bumptech.glide.load.c.b.AbstractC0072b
                public final Class<InputStream> os() {
                    return InputStream.class;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // com.bumptech.glide.load.c.b.AbstractC0072b
                public final /* synthetic */ InputStream l(byte[] bArr) {
                    AppMethodBeat.i(77209);
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                    AppMethodBeat.o(77209);
                    return byteArrayInputStream;
                }
            });
            AppMethodBeat.o(77210);
            return bVar;
        }
    }
}
