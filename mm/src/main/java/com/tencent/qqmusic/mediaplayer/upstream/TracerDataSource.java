package com.tencent.qqmusic.mediaplayer.upstream;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.AudioFormat;
import com.tencent.qqmusic.mediaplayer.util.Logger;

public class TracerDataSource implements IDataSource {
    private static final String TAG = "TracerDataSource";
    private final IDataSource impl;

    public TracerDataSource(IDataSource iDataSource) {
        this.impl = iDataSource;
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.IDataSource
    public void open() {
        AppMethodBeat.i(76513);
        try {
            this.impl.open();
            AppMethodBeat.o(76513);
        } catch (Throwable th) {
            Logger.e(TAG, "[open] failed!", th);
            AppMethodBeat.o(76513);
            throw th;
        }
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.IDataSource
    public int readAt(long j2, byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(76514);
        try {
            int readAt = this.impl.readAt(j2, bArr, i2, i3);
            AppMethodBeat.o(76514);
            return readAt;
        } catch (Throwable th) {
            Logger.e(TAG, "[readAt] failed! pos = " + j2 + ", offset = " + i2 + ", size = " + i3, th);
            AppMethodBeat.o(76514);
            throw th;
        }
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.IDataSource
    public long getSize() {
        AppMethodBeat.i(76515);
        try {
            long size = this.impl.getSize();
            AppMethodBeat.o(76515);
            return size;
        } catch (Throwable th) {
            Logger.e(TAG, "[getSize] failed!", th);
            AppMethodBeat.o(76515);
            throw th;
        }
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.IDataSource
    public AudioFormat.AudioType getAudioType() {
        AppMethodBeat.i(76516);
        try {
            AudioFormat.AudioType audioType = this.impl.getAudioType();
            AppMethodBeat.o(76516);
            return audioType;
        } catch (Throwable th) {
            Logger.e(TAG, "[getAudioType] failed!", th);
            AppMethodBeat.o(76516);
            throw th;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        AppMethodBeat.i(76517);
        try {
            this.impl.close();
            AppMethodBeat.o(76517);
        } catch (Throwable th) {
            Logger.e(TAG, "[close] failed!", th);
            AppMethodBeat.o(76517);
            throw th;
        }
    }

    public String toString() {
        AppMethodBeat.i(76518);
        String obj = this.impl.toString();
        AppMethodBeat.o(76518);
        return obj;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(76519);
        boolean equals = this.impl.equals(obj);
        AppMethodBeat.o(76519);
        return equals;
    }

    public int hashCode() {
        AppMethodBeat.i(76520);
        int hashCode = this.impl.hashCode();
        AppMethodBeat.o(76520);
        return hashCode;
    }
}
