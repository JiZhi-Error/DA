package com.tencent.mm.plugin.downloader.d;

import android.util.Pair;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.smtt.export.external.interfaces.ISelectionInterface;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public abstract class h {
    static Pair<ByteBuffer, Long> h(RandomAccessFile randomAccessFile) {
        if (randomAccessFile.length() < 22) {
            return null;
        }
        Pair<ByteBuffer, Long> g2 = g(randomAccessFile, 0);
        return g2 == null ? g(randomAccessFile, 65535) : g2;
    }

    private static Pair<ByteBuffer, Long> g(RandomAccessFile randomAccessFile, int i2) {
        if (i2 < 0 || i2 > 65535) {
            throw new IllegalArgumentException("maxCommentSize: ".concat(String.valueOf(i2)));
        }
        long length = randomAccessFile.length();
        if (length < 22) {
            return null;
        }
        ByteBuffer allocate = ByteBuffer.allocate(((int) Math.min((long) i2, length - 22)) + 22);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        long capacity = length - ((long) allocate.capacity());
        randomAccessFile.seek(capacity);
        randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
        int D = D(allocate);
        if (D == -1) {
            return null;
        }
        allocate.position(D);
        ByteBuffer slice = allocate.slice();
        slice.order(ByteOrder.LITTLE_ENDIAN);
        return Pair.create(slice, Long.valueOf(capacity + ((long) D)));
    }

    private static int D(ByteBuffer byteBuffer) {
        G(byteBuffer);
        int capacity = byteBuffer.capacity();
        if (capacity < 22) {
            return -1;
        }
        int min = Math.min(capacity - 22, 65535);
        int i2 = capacity - 22;
        for (int i3 = 0; i3 < min; i3++) {
            int i4 = i2 - i3;
            if (byteBuffer.getInt(i4) == 101010256 && (byteBuffer.getShort(i4 + 20) & ISelectionInterface.HELD_NOTHING) == i3) {
                return i4;
            }
        }
        return -1;
    }

    public static final boolean c(RandomAccessFile randomAccessFile, long j2) {
        long j3 = j2 - 20;
        if (j3 < 0) {
            return false;
        }
        randomAccessFile.seek(j3);
        if (randomAccessFile.readInt() == 1347094023) {
            return true;
        }
        return false;
    }

    public static long E(ByteBuffer byteBuffer) {
        G(byteBuffer);
        return e(byteBuffer, byteBuffer.position() + 16);
    }

    public static long F(ByteBuffer byteBuffer) {
        G(byteBuffer);
        return e(byteBuffer, byteBuffer.position() + 12);
    }

    private static void G(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    private static long e(ByteBuffer byteBuffer, int i2) {
        return ((long) byteBuffer.getInt(i2)) & Util.MAX_32BIT_VALUE;
    }
}
