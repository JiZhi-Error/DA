package com.tencent.mm.plugin.mmsight.segment;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.q;
import java.nio.ByteBuffer;

public final class MP4MuxerJNI {
    public static final int SEGMENT_COLOR_FORMAT_YUV420P = 2;
    public static final int SEGMENT_COLOR_FORMAT_YUV420SP = 1;
    private static final Object lock = new Object();

    public static native boolean ffmpegCheckIfReachEndTimestamp();

    public static native byte[] ffmpegGetNextVideoFrameData(byte[] bArr);

    public static native int ffmpegGetVideoHeight();

    public static native int ffmpegGetVideoWidth();

    private static native int ffmpegOpenAndSeekFile(String str, double d2, double d3);

    private static native byte[] getVideoThumb(String str, int i2, int i3);

    public static native int initDataBuf(int i2);

    public static native int initH264Encoder(int i2, int i3, float f2, int i4, int i5, int i6, int i7, float f3, int i8, int i9);

    private static native int muxing(int i2, int i3, int i4, int i5, int i6, String str, float f2, byte[] bArr, int i7);

    public static native int muxingForX264(int i2, int i3, int i4, int i5, String str, float f2, int i6, byte[] bArr, int i7);

    public static native void releaseDataBuf(int i2);

    public static native int triggerEncodeForSegment(int i2, boolean z);

    public static native void writeAACData(int i2, ByteBuffer byteBuffer, int i3);

    public static native void writeH264Data(int i2, ByteBuffer byteBuffer, int i3);

    public static native int writeYuvDataForSegment(byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7, int i8);

    public static native void yuv420pTo420XXAndScale(byte[] bArr, int i2, byte[] bArr2, int i3, int i4, int i5, int i6, int i7, int i8, int i9);

    static {
        AppMethodBeat.i(133591);
        AppMethodBeat.o(133591);
    }

    public static int initDataBufLock(int i2) {
        int initDataBuf;
        AppMethodBeat.i(133572);
        synchronized (lock) {
            try {
                initDataBuf = initDataBuf(i2);
            } finally {
                AppMethodBeat.o(133572);
            }
        }
        return initDataBuf;
    }

    public static void writeH264DataLock(int i2, ByteBuffer byteBuffer, int i3) {
        AppMethodBeat.i(133573);
        synchronized (lock) {
            try {
                writeH264Data(i2, byteBuffer, i3);
            } finally {
                AppMethodBeat.o(133573);
            }
        }
    }

    public static void writeAACDataLock(int i2, ByteBuffer byteBuffer, int i3) {
        AppMethodBeat.i(133574);
        synchronized (lock) {
            try {
                writeAACData(i2, byteBuffer, i3);
            } finally {
                AppMethodBeat.o(133574);
            }
        }
    }

    public static void releaseDataBufLock(int i2) {
        AppMethodBeat.i(133575);
        synchronized (lock) {
            try {
                releaseDataBuf(i2);
            } finally {
                AppMethodBeat.o(133575);
            }
        }
    }

    public static int muxingVFS(int i2, int i3, int i4, int i5, int i6, String str, float f2, byte[] bArr, int i7) {
        AppMethodBeat.i(133576);
        int muxing = muxing(i2, i3, i4, i5, i6, q.k(str, false), f2, bArr, i7);
        AppMethodBeat.o(133576);
        return muxing;
    }

    public static int muxingLock(int i2, int i3, int i4, int i5, int i6, String str, float f2, byte[] bArr, int i7) {
        int muxingVFS;
        AppMethodBeat.i(133577);
        synchronized (lock) {
            try {
                muxingVFS = muxingVFS(i2, i3, i4, i5, i6, str, f2, bArr, i7);
            } finally {
                AppMethodBeat.o(133577);
            }
        }
        return muxingVFS;
    }

    public static int initH264EncoderLock(int i2, int i3, float f2, int i4, int i5, int i6, int i7, float f3, int i8, int i9) {
        int initH264Encoder;
        AppMethodBeat.i(133578);
        synchronized (lock) {
            try {
                initH264Encoder = initH264Encoder(i2, i3, f2, i4, i5, i6, i7, f3, i8, i9);
            } finally {
                AppMethodBeat.o(133578);
            }
        }
        return initH264Encoder;
    }

    public static int muxingForX264VFS(int i2, int i3, int i4, int i5, String str, float f2, int i6, byte[] bArr, int i7) {
        AppMethodBeat.i(133579);
        int muxingForX264 = muxingForX264(i2, i3, i4, i5, q.k(str, false), f2, i6, bArr, i7);
        AppMethodBeat.o(133579);
        return muxingForX264;
    }

    public static int muxingForX264Lock(int i2, int i3, int i4, int i5, String str, float f2, int i6, byte[] bArr, int i7) {
        int muxingForX264VFS;
        AppMethodBeat.i(133580);
        synchronized (lock) {
            try {
                muxingForX264VFS = muxingForX264VFS(i2, i3, i4, i5, str, f2, i6, bArr, i7);
            } finally {
                AppMethodBeat.o(133580);
            }
        }
        return muxingForX264VFS;
    }

    public static int writeYuvDataForSegmentLock(byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int writeYuvDataForSegment;
        AppMethodBeat.i(133581);
        synchronized (lock) {
            try {
                writeYuvDataForSegment = writeYuvDataForSegment(bArr, i2, i3, i4, i5, i6, i7, i8);
            } finally {
                AppMethodBeat.o(133581);
            }
        }
        return writeYuvDataForSegment;
    }

    public static void yuv420pTo420XXAndScaleLock(byte[] bArr, int i2, byte[] bArr2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        AppMethodBeat.i(133582);
        synchronized (lock) {
            try {
                yuv420pTo420XXAndScale(bArr, i2, bArr2, i3, i4, i5, i6, i7, i8, i9);
            } finally {
                AppMethodBeat.o(133582);
            }
        }
    }

    public static int triggerEncodeForSegmentLock(int i2, boolean z) {
        int triggerEncodeForSegment;
        AppMethodBeat.i(133583);
        synchronized (lock) {
            try {
                triggerEncodeForSegment = triggerEncodeForSegment(i2, z);
            } finally {
                AppMethodBeat.o(133583);
            }
        }
        return triggerEncodeForSegment;
    }

    public static int ffmpegOpenAndSeekFileVFS(String str, double d2, double d3) {
        AppMethodBeat.i(133584);
        int ffmpegOpenAndSeekFile = ffmpegOpenAndSeekFile(q.k(str, false), d2, d3);
        AppMethodBeat.o(133584);
        return ffmpegOpenAndSeekFile;
    }

    public static int ffmpegOpenAndSeekFileLock(String str, double d2, double d3) {
        int ffmpegOpenAndSeekFileVFS;
        AppMethodBeat.i(133585);
        synchronized (lock) {
            try {
                ffmpegOpenAndSeekFileVFS = ffmpegOpenAndSeekFileVFS(str, d2, d3);
            } finally {
                AppMethodBeat.o(133585);
            }
        }
        return ffmpegOpenAndSeekFileVFS;
    }

    public static byte[] ffmpegGetNextVideoFrameDataLock(byte[] bArr) {
        byte[] ffmpegGetNextVideoFrameData;
        AppMethodBeat.i(133586);
        synchronized (lock) {
            try {
                ffmpegGetNextVideoFrameData = ffmpegGetNextVideoFrameData(bArr);
            } finally {
                AppMethodBeat.o(133586);
            }
        }
        return ffmpegGetNextVideoFrameData;
    }

    public static boolean ffmpegCheckIfReachEndTimestampLock() {
        boolean ffmpegCheckIfReachEndTimestamp;
        AppMethodBeat.i(133587);
        synchronized (lock) {
            try {
                ffmpegCheckIfReachEndTimestamp = ffmpegCheckIfReachEndTimestamp();
            } finally {
                AppMethodBeat.o(133587);
            }
        }
        return ffmpegCheckIfReachEndTimestamp;
    }

    public static int ffmpegGetVideoWidthLock() {
        int ffmpegGetVideoWidth;
        AppMethodBeat.i(133588);
        synchronized (lock) {
            try {
                ffmpegGetVideoWidth = ffmpegGetVideoWidth();
            } finally {
                AppMethodBeat.o(133588);
            }
        }
        return ffmpegGetVideoWidth;
    }

    public static int ffmpegGetVideoHeightLock() {
        int ffmpegGetVideoHeight;
        AppMethodBeat.i(133589);
        synchronized (lock) {
            try {
                ffmpegGetVideoHeight = ffmpegGetVideoHeight();
            } finally {
                AppMethodBeat.o(133589);
            }
        }
        return ffmpegGetVideoHeight;
    }

    public static byte[] getVideoThumbVFS(String str, int i2, int i3) {
        AppMethodBeat.i(133590);
        byte[] videoThumb = getVideoThumb(q.k(str, false), i2, i3);
        AppMethodBeat.o(133590);
        return videoThumb;
    }
}
