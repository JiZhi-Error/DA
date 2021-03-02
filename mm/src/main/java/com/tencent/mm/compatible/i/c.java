package com.tencent.mm.compatible.i;

import android.annotation.TargetApi;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileDescriptor;
import java.nio.ByteBuffer;

@TargetApi(16)
public final class c {
    public final MediaExtractor gLF = new MediaExtractor();

    public c() {
        AppMethodBeat.i(155923);
        AppMethodBeat.o(155923);
    }

    public final void setDataSource(FileDescriptor fileDescriptor) {
        AppMethodBeat.i(155926);
        this.gLF.setDataSource(fileDescriptor);
        AppMethodBeat.o(155926);
    }

    public final void setDataSource(FileDescriptor fileDescriptor, long j2, long j3) {
        AppMethodBeat.i(155927);
        this.gLF.setDataSource(fileDescriptor, j2, j3);
        AppMethodBeat.o(155927);
    }

    public final void release() {
        AppMethodBeat.i(186056);
        this.gLF.release();
        AppMethodBeat.o(186056);
    }

    public final int getTrackCount() {
        AppMethodBeat.i(186057);
        int trackCount = this.gLF.getTrackCount();
        AppMethodBeat.o(186057);
        return trackCount;
    }

    public final MediaFormat getTrackFormat(int i2) {
        AppMethodBeat.i(155930);
        MediaFormat trackFormat = this.gLF.getTrackFormat(i2);
        AppMethodBeat.o(155930);
        return trackFormat;
    }

    public final void selectTrack(int i2) {
        AppMethodBeat.i(155931);
        this.gLF.selectTrack(i2);
        AppMethodBeat.o(155931);
    }

    public final void unselectTrack(int i2) {
        AppMethodBeat.i(155932);
        this.gLF.unselectTrack(i2);
        AppMethodBeat.o(155932);
    }

    public final void seekTo(long j2, int i2) {
        AppMethodBeat.i(155933);
        this.gLF.seekTo(j2, i2);
        AppMethodBeat.o(155933);
    }

    public final boolean advance() {
        AppMethodBeat.i(186058);
        boolean advance = this.gLF.advance();
        AppMethodBeat.o(186058);
        return advance;
    }

    public final int readSampleData(ByteBuffer byteBuffer, int i2) {
        AppMethodBeat.i(204400);
        int readSampleData = this.gLF.readSampleData(byteBuffer, i2);
        AppMethodBeat.o(204400);
        return readSampleData;
    }

    public final int getSampleTrackIndex() {
        AppMethodBeat.i(155936);
        int sampleTrackIndex = this.gLF.getSampleTrackIndex();
        AppMethodBeat.o(155936);
        return sampleTrackIndex;
    }

    public final long getSampleTime() {
        AppMethodBeat.i(186059);
        long sampleTime = this.gLF.getSampleTime();
        AppMethodBeat.o(186059);
        return sampleTime;
    }

    public final int getSampleFlags() {
        AppMethodBeat.i(204401);
        int sampleFlags = this.gLF.getSampleFlags();
        AppMethodBeat.o(204401);
        return sampleFlags;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0063  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setDataSource(java.lang.String r7) {
        /*
        // Method dump skipped, instructions count: 172
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.compatible.i.c.setDataSource(java.lang.String):void");
    }
}
