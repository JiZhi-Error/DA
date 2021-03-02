package com.bumptech.glide.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicReference;

public final class a {
    private static final AtomicReference<byte[]> aNK = new AtomicReference<>();

    static {
        AppMethodBeat.i(77721);
        AppMethodBeat.o(77721);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002e A[SYNTHETIC, Splitter:B:12:0x002e] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0029 A[SYNTHETIC, Splitter:B:9:0x0029] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.nio.ByteBuffer v(java.io.File r10) {
        /*
        // Method dump skipped, instructions count: 125
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.g.a.v(java.io.File):java.nio.ByteBuffer");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x003a A[SYNTHETIC, Splitter:B:18:0x003a] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x003f A[SYNTHETIC, Splitter:B:21:0x003f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void b(java.nio.ByteBuffer r5, java.io.File r6) {
        /*
            r2 = 0
            r0 = 0
            r4 = 77718(0x12f96, float:1.08906E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
            r5.position(r0)
            java.io.RandomAccessFile r3 = new java.io.RandomAccessFile     // Catch:{ all -> 0x0035 }
            java.lang.String r0 = "rw"
            r3.<init>(r6, r0)     // Catch:{ all -> 0x0035 }
            java.nio.channels.FileChannel r1 = r3.getChannel()     // Catch:{ all -> 0x004c }
            r1.write(r5)     // Catch:{ all -> 0x004f }
            r0 = 0
            r1.force(r0)     // Catch:{ all -> 0x004f }
            r1.close()     // Catch:{ all -> 0x004f }
            r3.close()     // Catch:{ all -> 0x004f }
            if (r1 == 0) goto L_0x0029
            r1.close()     // Catch:{ IOException -> 0x0046 }
        L_0x0029:
            r3.close()     // Catch:{ IOException -> 0x0030 }
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
        L_0x002f:
            return
        L_0x0030:
            r0 = move-exception
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            goto L_0x002f
        L_0x0035:
            r0 = move-exception
            r1 = r2
            r3 = r2
        L_0x0038:
            if (r1 == 0) goto L_0x003d
            r1.close()     // Catch:{ IOException -> 0x0048 }
        L_0x003d:
            if (r3 == 0) goto L_0x0042
            r3.close()     // Catch:{ IOException -> 0x004a }
        L_0x0042:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            throw r0
        L_0x0046:
            r0 = move-exception
            goto L_0x0029
        L_0x0048:
            r1 = move-exception
            goto L_0x003d
        L_0x004a:
            r1 = move-exception
            goto L_0x0042
        L_0x004c:
            r0 = move-exception
            r1 = r2
            goto L_0x0038
        L_0x004f:
            r0 = move-exception
            goto L_0x0038
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.g.a.b(java.nio.ByteBuffer, java.io.File):void");
    }

    public static InputStream d(ByteBuffer byteBuffer) {
        AppMethodBeat.i(77720);
        C0065a aVar = new C0065a(byteBuffer);
        AppMethodBeat.o(77720);
        return aVar;
    }

    /* access modifiers changed from: package-private */
    public static final class b {
        final byte[] data;
        final int limit;
        final int offset;

        b(byte[] bArr, int i2, int i3) {
            this.data = bArr;
            this.offset = i2;
            this.limit = i3;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.bumptech.glide.g.a$a  reason: collision with other inner class name */
    public static class C0065a extends InputStream {
        private int aNL = -1;
        private final ByteBuffer byteBuffer;

        C0065a(ByteBuffer byteBuffer2) {
            this.byteBuffer = byteBuffer2;
        }

        @Override // java.io.InputStream
        public final int available() {
            AppMethodBeat.i(77711);
            int remaining = this.byteBuffer.remaining();
            AppMethodBeat.o(77711);
            return remaining;
        }

        @Override // java.io.InputStream
        public final int read() {
            AppMethodBeat.i(77712);
            if (!this.byteBuffer.hasRemaining()) {
                AppMethodBeat.o(77712);
                return -1;
            }
            byte b2 = this.byteBuffer.get();
            AppMethodBeat.o(77712);
            return b2;
        }

        public final synchronized void mark(int i2) {
            AppMethodBeat.i(77713);
            this.aNL = this.byteBuffer.position();
            AppMethodBeat.o(77713);
        }

        public final boolean markSupported() {
            return true;
        }

        @Override // java.io.InputStream
        public final int read(byte[] bArr, int i2, int i3) {
            AppMethodBeat.i(77714);
            if (!this.byteBuffer.hasRemaining()) {
                AppMethodBeat.o(77714);
                return -1;
            }
            int min = Math.min(i3, available());
            this.byteBuffer.get(bArr, i2, min);
            AppMethodBeat.o(77714);
            return min;
        }

        @Override // java.io.InputStream
        public final synchronized void reset() {
            AppMethodBeat.i(77715);
            if (this.aNL == -1) {
                IOException iOException = new IOException("Cannot reset to unset mark position");
                AppMethodBeat.o(77715);
                throw iOException;
            }
            this.byteBuffer.position(this.aNL);
            AppMethodBeat.o(77715);
        }

        @Override // java.io.InputStream
        public final long skip(long j2) {
            AppMethodBeat.i(77716);
            if (!this.byteBuffer.hasRemaining()) {
                AppMethodBeat.o(77716);
                return -1;
            }
            long min = Math.min(j2, (long) available());
            this.byteBuffer.position((int) (((long) this.byteBuffer.position()) + min));
            AppMethodBeat.o(77716);
            return min;
        }
    }

    public static byte[] c(ByteBuffer byteBuffer) {
        b bVar;
        byte[] bArr;
        AppMethodBeat.i(77719);
        if (byteBuffer.isReadOnly() || !byteBuffer.hasArray()) {
            bVar = null;
        } else {
            bVar = new b(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.limit());
        }
        if (bVar != null && bVar.offset == 0 && bVar.limit == bVar.data.length) {
            bArr = byteBuffer.array();
        } else {
            ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
            bArr = new byte[asReadOnlyBuffer.limit()];
            asReadOnlyBuffer.position(0);
            asReadOnlyBuffer.get(bArr);
        }
        AppMethodBeat.o(77719);
        return bArr;
    }
}
