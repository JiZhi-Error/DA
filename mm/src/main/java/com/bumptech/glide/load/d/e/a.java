package com.bumptech.glide.load.d.e;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import com.bumptech.glide.b.c;
import com.bumptech.glide.b.d;
import com.bumptech.glide.g.f;
import com.bumptech.glide.g.k;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.b.a.e;
import com.bumptech.glide.load.b.v;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public final class a implements j<ByteBuffer, c> {
    private static final C0076a aLG = new C0076a();
    private static final b aLH = new b();
    private final List<ImageHeaderParser> aFx;
    private final b aLI;
    private final C0076a aLJ;
    private final b aLK;
    private final Context context;

    /* Return type fixed from 'com.bumptech.glide.load.b.v' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, int, com.bumptech.glide.load.i] */
    @Override // com.bumptech.glide.load.j
    public final /* bridge */ /* synthetic */ v<c> a(ByteBuffer byteBuffer, int i2, int i3, i iVar) {
        AppMethodBeat.i(77473);
        e a2 = a(byteBuffer, i2, i3, iVar);
        AppMethodBeat.o(77473);
        return a2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.bumptech.glide.load.i] */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0034  */
    @Override // com.bumptech.glide.load.j
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ boolean a(java.nio.ByteBuffer r8, com.bumptech.glide.load.i r9) {
        /*
            r7 = this;
            r1 = 0
            r6 = 77474(0x12ea2, float:1.08564E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r6)
            java.nio.ByteBuffer r8 = (java.nio.ByteBuffer) r8
            com.bumptech.glide.load.h<java.lang.Boolean> r0 = com.bumptech.glide.load.d.e.i.aMd
            java.lang.Object r0 = r9.a(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x0040
            java.util.List<com.bumptech.glide.load.ImageHeaderParser> r3 = r7.aFx
            if (r8 == 0) goto L_0x003d
            int r4 = r3.size()
            r2 = r1
        L_0x0020:
            if (r2 >= r4) goto L_0x003d
            java.lang.Object r0 = r3.get(r2)
            com.bumptech.glide.load.ImageHeaderParser r0 = (com.bumptech.glide.load.ImageHeaderParser) r0
            com.bumptech.glide.load.ImageHeaderParser$ImageType r0 = r0.a(r8)
            com.bumptech.glide.load.ImageHeaderParser$ImageType r5 = com.bumptech.glide.load.ImageHeaderParser.ImageType.UNKNOWN
            if (r0 == r5) goto L_0x0039
        L_0x0030:
            com.bumptech.glide.load.ImageHeaderParser$ImageType r2 = com.bumptech.glide.load.ImageHeaderParser.ImageType.GIF
            if (r0 != r2) goto L_0x0040
            r0 = 1
            com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
        L_0x0038:
            return r0
        L_0x0039:
            int r0 = r2 + 1
            r2 = r0
            goto L_0x0020
        L_0x003d:
            com.bumptech.glide.load.ImageHeaderParser$ImageType r0 = com.bumptech.glide.load.ImageHeaderParser.ImageType.UNKNOWN
            goto L_0x0030
        L_0x0040:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
            r0 = r1
            goto L_0x0038
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.d.e.a.a(java.lang.Object, com.bumptech.glide.load.i):boolean");
    }

    static {
        AppMethodBeat.i(77475);
        AppMethodBeat.o(77475);
    }

    public a(Context context2, List<ImageHeaderParser> list, e eVar, com.bumptech.glide.load.b.a.b bVar) {
        this(context2, list, eVar, bVar, aLH, aLG);
    }

    private a(Context context2, List<ImageHeaderParser> list, e eVar, com.bumptech.glide.load.b.a.b bVar, b bVar2, C0076a aVar) {
        AppMethodBeat.i(77470);
        this.context = context2.getApplicationContext();
        this.aFx = list;
        this.aLJ = aVar;
        this.aLK = new b(eVar, bVar);
        this.aLI = bVar2;
        AppMethodBeat.o(77470);
    }

    private e a(ByteBuffer byteBuffer, int i2, int i3, i iVar) {
        AppMethodBeat.i(77471);
        d b2 = this.aLI.b(byteBuffer);
        try {
            return a(byteBuffer, i2, i3, b2, iVar);
        } finally {
            this.aLI.a(b2);
            AppMethodBeat.o(77471);
        }
    }

    private e a(ByteBuffer byteBuffer, int i2, int i3, d dVar, i iVar) {
        AppMethodBeat.i(77472);
        long qt = f.qt();
        try {
            if (dVar.aEp == null) {
                IllegalStateException illegalStateException = new IllegalStateException("You must call setData() before parseHeader()");
                AppMethodBeat.o(77472);
                throw illegalStateException;
            }
            if (!dVar.op()) {
                dVar.om();
                if (!dVar.op()) {
                    dVar.ok();
                    if (dVar.aEq.frameCount < 0) {
                        dVar.aEq.status = 1;
                    }
                }
            }
            c cVar = dVar.aEq;
            if (cVar.frameCount <= 0 || cVar.status != 0) {
                if (Log.isLoggable("BufferGifDecoder", 2)) {
                    new StringBuilder("Decoded GIF from stream in ").append(f.p(qt));
                }
                AppMethodBeat.o(77472);
                return null;
            }
            Bitmap.Config config = iVar.a(i.aLc) == com.bumptech.glide.load.b.PREFER_RGB_565 ? Bitmap.Config.RGB_565 : Bitmap.Config.ARGB_8888;
            int min = Math.min(cVar.height / i3, cVar.width / i2);
            int max = Math.max(1, min == 0 ? 0 : Integer.highestOneBit(min));
            if (Log.isLoggable("BufferGifDecoder", 2) && max > 1) {
                new StringBuilder("Downsampling GIF, sampleSize: ").append(max).append(", target dimens: [").append(i2).append("x").append(i3).append("], actual dimens: [").append(cVar.width).append("x").append(cVar.height).append("]");
            }
            com.bumptech.glide.b.e eVar = new com.bumptech.glide.b.e(this.aLK, cVar, byteBuffer, max);
            eVar.a(config);
            eVar.advance();
            Bitmap oj = eVar.oj();
            if (oj == null) {
                if (Log.isLoggable("BufferGifDecoder", 2)) {
                    new StringBuilder("Decoded GIF from stream in ").append(f.p(qt));
                }
                AppMethodBeat.o(77472);
                return null;
            }
            e eVar2 = new e(new c(this.context, eVar, com.bumptech.glide.load.d.b.px(), i2, i3, oj));
            return eVar2;
        } finally {
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                new StringBuilder("Decoded GIF from stream in ").append(f.p(qt));
            }
            AppMethodBeat.o(77472);
        }
    }

    /* renamed from: com.bumptech.glide.load.d.e.a$a  reason: collision with other inner class name */
    static class C0076a {
        C0076a() {
        }
    }

    /* access modifiers changed from: package-private */
    public static class b {
        private final Queue<d> aIT = k.ds(0);

        b() {
            AppMethodBeat.i(77467);
            AppMethodBeat.o(77467);
        }

        /* access modifiers changed from: package-private */
        public final synchronized d b(ByteBuffer byteBuffer) {
            d poll;
            AppMethodBeat.i(77468);
            poll = this.aIT.poll();
            if (poll == null) {
                poll = new d();
            }
            poll.aEp = null;
            Arrays.fill(poll.aEo, (byte) 0);
            poll.aEq = new c();
            poll.blockSize = 0;
            poll.aEp = byteBuffer.asReadOnlyBuffer();
            poll.aEp.position(0);
            poll.aEp.order(ByteOrder.LITTLE_ENDIAN);
            AppMethodBeat.o(77468);
            return poll;
        }

        /* access modifiers changed from: package-private */
        public final synchronized void a(d dVar) {
            AppMethodBeat.i(77469);
            dVar.aEp = null;
            dVar.aEq = null;
            this.aIT.offer(dVar);
            AppMethodBeat.o(77469);
        }
    }
}
