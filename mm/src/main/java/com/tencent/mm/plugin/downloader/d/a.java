package com.tencent.mm.plugin.downloader.d;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.RandomAccessFile;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class a {
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x008f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean akY(java.lang.String r18) {
        /*
        // Method dump skipped, instructions count: 337
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.downloader.d.a.akY(java.lang.String):boolean");
    }

    /* renamed from: com.tencent.mm.plugin.downloader.d.a$a  reason: collision with other inner class name */
    static class C0944a {
        private final ByteBuffer qHu;
        private final long qHv;
        private final long qHw;
        private final long qHx;
        private final ByteBuffer qHy;

        /* synthetic */ C0944a(ByteBuffer byteBuffer, long j2, long j3, long j4, ByteBuffer byteBuffer2, byte b2) {
            this(byteBuffer, j2, j3, j4, byteBuffer2);
        }

        private C0944a(ByteBuffer byteBuffer, long j2, long j3, long j4, ByteBuffer byteBuffer2) {
            this.qHu = byteBuffer;
            this.qHv = j2;
            this.qHw = j3;
            this.qHx = j4;
            this.qHy = byteBuffer2;
        }
    }

    public static Pair<ByteBuffer, Long> g(RandomAccessFile randomAccessFile) {
        AppMethodBeat.i(88851);
        Pair<ByteBuffer, Long> h2 = h.h(randomAccessFile);
        if (h2 == null) {
            b bVar = new b("Not an APK file: ZIP End of Central Directory record not found");
            AppMethodBeat.o(88851);
            throw bVar;
        }
        AppMethodBeat.o(88851);
        return h2;
    }

    public static long b(ByteBuffer byteBuffer, long j2) {
        AppMethodBeat.i(88852);
        long E = h.E(byteBuffer);
        if (E >= j2) {
            b bVar = new b("ZIP Central Directory offset out of range: " + E + ". ZIP End of Central Directory offset: " + j2);
            AppMethodBeat.o(88852);
            throw bVar;
        } else if (h.F(byteBuffer) + E != j2) {
            b bVar2 = new b("ZIP Central Directory is not immediately followed by End of Central Directory");
            AppMethodBeat.o(88852);
            throw bVar2;
        } else {
            AppMethodBeat.o(88852);
            return E;
        }
    }

    public static ByteBuffer c(ByteBuffer byteBuffer, int i2) {
        AppMethodBeat.i(88853);
        if (i2 < 8) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("end < start: " + i2 + " < 8");
            AppMethodBeat.o(88853);
            throw illegalArgumentException;
        }
        int capacity = byteBuffer.capacity();
        if (i2 > byteBuffer.capacity()) {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("end > capacity: " + i2 + " > " + capacity);
            AppMethodBeat.o(88853);
            throw illegalArgumentException2;
        }
        int limit = byteBuffer.limit();
        int position = byteBuffer.position();
        try {
            byteBuffer.position(0);
            byteBuffer.limit(i2);
            byteBuffer.position(8);
            ByteBuffer slice = byteBuffer.slice();
            slice.order(byteBuffer.order());
            return slice;
        } finally {
            byteBuffer.position(0);
            byteBuffer.limit(limit);
            byteBuffer.position(position);
            AppMethodBeat.o(88853);
        }
    }

    public static ByteBuffer d(ByteBuffer byteBuffer, int i2) {
        AppMethodBeat.i(88854);
        if (i2 < 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("size: ".concat(String.valueOf(i2)));
            AppMethodBeat.o(88854);
            throw illegalArgumentException;
        }
        int limit = byteBuffer.limit();
        int position = byteBuffer.position();
        int i3 = position + i2;
        if (i3 < position || i3 > limit) {
            BufferUnderflowException bufferUnderflowException = new BufferUnderflowException();
            AppMethodBeat.o(88854);
            throw bufferUnderflowException;
        }
        byteBuffer.limit(i3);
        try {
            ByteBuffer slice = byteBuffer.slice();
            slice.order(byteBuffer.order());
            byteBuffer.position(i3);
            return slice;
        } finally {
            byteBuffer.limit(limit);
            AppMethodBeat.o(88854);
        }
    }

    public static Pair<ByteBuffer, Long> b(RandomAccessFile randomAccessFile, long j2) {
        AppMethodBeat.i(88855);
        if (j2 < 32) {
            b bVar = new b("APK too small for APK Signing Block. ZIP Central Directory offset: ".concat(String.valueOf(j2)));
            AppMethodBeat.o(88855);
            throw bVar;
        }
        ByteBuffer allocate = ByteBuffer.allocate(24);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        randomAccessFile.seek(j2 - ((long) allocate.capacity()));
        randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
        if (allocate.getLong(8) == 2334950737559900225L && allocate.getLong(16) == 3617552046287187010L) {
            long j3 = allocate.getLong(0);
            if (j3 < ((long) allocate.capacity()) || j3 > 2147483639) {
                b bVar2 = new b("APK Signing Block size out of range: ".concat(String.valueOf(j3)));
                AppMethodBeat.o(88855);
                throw bVar2;
            }
            int i2 = (int) (8 + j3);
            long j4 = j2 - ((long) i2);
            if (j4 < 0) {
                b bVar3 = new b("APK Signing Block offset out of range: ".concat(String.valueOf(j4)));
                AppMethodBeat.o(88855);
                throw bVar3;
            }
            ByteBuffer allocate2 = ByteBuffer.allocate(i2);
            allocate2.order(ByteOrder.LITTLE_ENDIAN);
            randomAccessFile.seek(j4);
            randomAccessFile.readFully(allocate2.array(), allocate2.arrayOffset(), allocate2.capacity());
            long j5 = allocate2.getLong(0);
            if (j5 != j3) {
                b bVar4 = new b("APK Signing Block sizes in header and footer do not match: " + j5 + " vs " + j3);
                AppMethodBeat.o(88855);
                throw bVar4;
            }
            Pair<ByteBuffer, Long> create = Pair.create(allocate2, Long.valueOf(j4));
            AppMethodBeat.o(88855);
            return create;
        }
        b bVar5 = new b("No APK Signing Block before ZIP Central Directory");
        AppMethodBeat.o(88855);
        throw bVar5;
    }

    public static void C(ByteBuffer byteBuffer) {
        AppMethodBeat.i(88857);
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("ByteBuffer byte order must be little endian");
            AppMethodBeat.o(88857);
            throw illegalArgumentException;
        }
        AppMethodBeat.o(88857);
    }

    public static class b extends Exception {
        public b(String str) {
            super(str);
        }
    }
}
