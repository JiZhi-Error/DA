package com.tencent.qqmusic.mediaplayer.codec;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.AudioInformation;
import com.tencent.qqmusic.mediaplayer.NativeLibs;
import com.tencent.qqmusic.mediaplayer.upstream.FileDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.INativeDataSource;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class NativeDecoder extends BaseDecoder {
    private static final String TAG = "NativeDecoder";
    private long mNativePointer = 0;
    private final ReadWriteLock mReadWriteLock = new ReentrantReadWriteLock();

    private native int nativeDecode(long j2, byte[] bArr, int i2, int i3);

    private native AudioInformation nativeGetAudioInformation(long j2);

    private native long nativeGetBytePositionOfTime(long j2, long j3);

    private native long nativeGetCurrentPosition(long j2);

    private native int nativeGetDetailErrorCode(long j2);

    private native String nativeGetDetailErrorDescription(long j2);

    private native long nativeGetDuration(long j2);

    private native long nativeGetMinBufferSize(long j2);

    private native long[] nativeInit(long j2);

    private native long[] nativeInit(IDataSource iDataSource);

    private native int nativeRelease(long j2);

    private native long nativeSeekTo(long j2, long j3);

    public NativeDecoder() {
        AppMethodBeat.i(114340);
        AppMethodBeat.o(114340);
    }

    @Override // com.tencent.qqmusic.mediaplayer.codec.BaseDecoder
    public int init(IDataSource iDataSource) {
        AppMethodBeat.i(114341);
        this.mReadWriteLock.writeLock().lock();
        try {
            long[] nativeInit = nativeInit(iDataSource);
            long j2 = -1;
            if (nativeInit != null && nativeInit.length >= 2) {
                this.mNativePointer = nativeInit[0];
                j2 = nativeInit[1];
            }
            return (int) j2;
        } finally {
            this.mReadWriteLock.writeLock().unlock();
            AppMethodBeat.o(114341);
        }
    }

    @Override // com.tencent.qqmusic.mediaplayer.codec.BaseDecoder
    public int init(INativeDataSource iNativeDataSource) {
        AppMethodBeat.i(114342);
        this.mReadWriteLock.writeLock().lock();
        long j2 = -1;
        if (iNativeDataSource != null) {
            try {
                long[] nativeInit = nativeInit(iNativeDataSource.getNativeInstance());
                if (nativeInit != null && nativeInit.length >= 2) {
                    this.mNativePointer = nativeInit[0];
                    j2 = nativeInit[1];
                }
            } catch (Throwable th) {
                this.mReadWriteLock.writeLock().unlock();
                AppMethodBeat.o(114342);
                throw th;
            }
        }
        int i2 = (int) j2;
        this.mReadWriteLock.writeLock().unlock();
        AppMethodBeat.o(114342);
        return i2;
    }

    @Override // com.tencent.qqmusic.mediaplayer.codec.BaseDecoder
    public int init(String str, boolean z) {
        AppMethodBeat.i(114343);
        int init = init(new FileDataSource(str));
        AppMethodBeat.o(114343);
        return init;
    }

    @Override // com.tencent.qqmusic.mediaplayer.codec.BaseDecoder
    public int decodeData(int i2, byte[] bArr) {
        AppMethodBeat.i(114344);
        this.mReadWriteLock.readLock().lock();
        try {
            return nativeDecode(this.mNativePointer, bArr, 0, i2);
        } finally {
            this.mReadWriteLock.readLock().unlock();
            AppMethodBeat.o(114344);
        }
    }

    @Override // com.tencent.qqmusic.mediaplayer.codec.BaseDecoder
    public int seekTo(int i2) {
        AppMethodBeat.i(114345);
        this.mReadWriteLock.readLock().lock();
        try {
            return (int) nativeSeekTo(this.mNativePointer, (long) i2);
        } finally {
            this.mReadWriteLock.readLock().unlock();
            AppMethodBeat.o(114345);
        }
    }

    @Override // com.tencent.qqmusic.mediaplayer.codec.BaseDecoder
    public long getCurrentTime() {
        AppMethodBeat.i(114346);
        this.mReadWriteLock.readLock().lock();
        try {
            return nativeGetCurrentPosition(this.mNativePointer);
        } finally {
            this.mReadWriteLock.readLock().unlock();
            AppMethodBeat.o(114346);
        }
    }

    @Override // com.tencent.qqmusic.mediaplayer.codec.BaseDecoder
    public long getDuration() {
        AppMethodBeat.i(114347);
        this.mReadWriteLock.readLock().lock();
        try {
            return nativeGetDuration(this.mNativePointer);
        } finally {
            this.mReadWriteLock.readLock().unlock();
            AppMethodBeat.o(114347);
        }
    }

    @Override // com.tencent.qqmusic.mediaplayer.codec.BaseDecoder
    public AudioInformation getAudioInformation() {
        AppMethodBeat.i(114348);
        this.mReadWriteLock.readLock().lock();
        try {
            return nativeGetAudioInformation(this.mNativePointer);
        } finally {
            this.mReadWriteLock.readLock().unlock();
            AppMethodBeat.o(114348);
        }
    }

    @Override // com.tencent.qqmusic.mediaplayer.codec.BaseDecoder
    public int release() {
        AppMethodBeat.i(114349);
        this.mReadWriteLock.writeLock().lock();
        try {
            int nativeRelease = nativeRelease(this.mNativePointer);
            this.mNativePointer = 0;
            return nativeRelease;
        } finally {
            this.mReadWriteLock.writeLock().unlock();
            AppMethodBeat.o(114349);
        }
    }

    @Override // com.tencent.qqmusic.mediaplayer.codec.BaseDecoder
    public long getMinBufferSize() {
        AppMethodBeat.i(114350);
        this.mReadWriteLock.readLock().lock();
        try {
            return nativeGetMinBufferSize(this.mNativePointer);
        } finally {
            this.mReadWriteLock.readLock().unlock();
            AppMethodBeat.o(114350);
        }
    }

    @Override // com.tencent.qqmusic.mediaplayer.codec.BaseDecoder
    public long getBytePositionOfTime(long j2) {
        AppMethodBeat.i(114351);
        this.mReadWriteLock.readLock().lock();
        try {
            return nativeGetBytePositionOfTime(this.mNativePointer, j2);
        } finally {
            this.mReadWriteLock.readLock().unlock();
            AppMethodBeat.o(114351);
        }
    }

    @Override // com.tencent.qqmusic.mediaplayer.codec.BaseDecoder
    public int getErrorCodeMask() {
        return -1;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.qqmusic.mediaplayer.codec.BaseDecoder
    public List<NativeLibs> getNativeLibs() {
        AppMethodBeat.i(114352);
        List<NativeLibs> asList = Arrays.asList(NativeLibs.audioCommon, NativeLibs.formatDetector, NativeLibs.codecFactory, NativeLibs.decoderJni, NativeLibs.cppShared, NativeLibs.stlportShared, NativeLibs.xlog, NativeLibs.FFmpeg);
        AppMethodBeat.o(114352);
        return asList;
    }
}
