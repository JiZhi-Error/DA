package com.tencent.tav.extractor;

import android.annotation.TargetApi;
import android.content.res.AssetFileDescriptor;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.decoder.logger.Logger;
import java.io.FileDescriptor;
import java.io.IOException;
import java.nio.ByteBuffer;

public class ApiAssetExtractorDelegate implements IAssetExtractorDelegate {
    private static final String TAG = "ApiAssetExtractorDelegate";
    private MediaExtractor mediaExtractor = new MediaExtractor();
    private boolean released = false;

    public ApiAssetExtractorDelegate() {
        AppMethodBeat.i(218468);
        AppMethodBeat.o(218468);
    }

    @Override // com.tencent.tav.extractor.IAssetExtractorDelegate
    public final synchronized void setDataSource(String str) {
        AppMethodBeat.i(218469);
        try {
            this.mediaExtractor.setDataSource(str);
            AppMethodBeat.o(218469);
        } catch (IOException e2) {
            Logger.e(TAG, "setDataSource", e2);
            AppMethodBeat.o(218469);
        }
    }

    @Override // com.tencent.tav.extractor.IAssetExtractorDelegate
    @TargetApi(24)
    public final synchronized void setDataSource(AssetFileDescriptor assetFileDescriptor) {
        AppMethodBeat.i(218470);
        try {
            this.mediaExtractor.setDataSource(assetFileDescriptor);
            AppMethodBeat.o(218470);
        } catch (IOException e2) {
            Logger.e(TAG, "setDataSource", e2);
            AppMethodBeat.o(218470);
        }
    }

    @Override // com.tencent.tav.extractor.IAssetExtractorDelegate
    public final synchronized void setDataSource(FileDescriptor fileDescriptor) {
        AppMethodBeat.i(218471);
        try {
            this.mediaExtractor.setDataSource(fileDescriptor, 0, 576460752303423487L);
            AppMethodBeat.o(218471);
        } catch (IOException e2) {
            Logger.e(TAG, "setDataSource", e2);
            AppMethodBeat.o(218471);
        }
    }

    @Override // com.tencent.tav.extractor.IAssetExtractorDelegate
    public final synchronized void release() {
        AppMethodBeat.i(218472);
        this.mediaExtractor.release();
        AppMethodBeat.o(218472);
    }

    @Override // com.tencent.tav.extractor.IAssetExtractorDelegate
    public final synchronized int getTrackCount() {
        int i2;
        AppMethodBeat.i(218473);
        if (!this.released) {
            i2 = this.mediaExtractor.getTrackCount();
            AppMethodBeat.o(218473);
        } else {
            i2 = 0;
            AppMethodBeat.o(218473);
        }
        return i2;
    }

    @Override // com.tencent.tav.extractor.IAssetExtractorDelegate
    public synchronized MediaFormat getTrackFormat(int i2) {
        MediaFormat trackFormat;
        AppMethodBeat.i(218474);
        trackFormat = this.mediaExtractor.getTrackFormat(i2);
        AppMethodBeat.o(218474);
        return trackFormat;
    }

    @Override // com.tencent.tav.extractor.IAssetExtractorDelegate
    public synchronized void selectTrack(int i2) {
        AppMethodBeat.i(218475);
        if (!this.released) {
            this.mediaExtractor.selectTrack(i2);
        }
        AppMethodBeat.o(218475);
    }

    @Override // com.tencent.tav.extractor.IAssetExtractorDelegate
    public synchronized void unselectTrack(int i2) {
        AppMethodBeat.i(218476);
        if (!this.released) {
            this.mediaExtractor.unselectTrack(i2);
        }
        AppMethodBeat.o(218476);
    }

    @Override // com.tencent.tav.extractor.IAssetExtractorDelegate
    public synchronized void seekTo(long j2, int i2) {
        AppMethodBeat.i(218477);
        if (!this.released) {
            this.mediaExtractor.seekTo(j2, i2);
        }
        AppMethodBeat.o(218477);
    }

    @Override // com.tencent.tav.extractor.IAssetExtractorDelegate
    public synchronized boolean advance() {
        AppMethodBeat.i(218478);
        if (!this.released) {
            this.mediaExtractor.advance();
        }
        AppMethodBeat.o(218478);
        return false;
    }

    @Override // com.tencent.tav.extractor.IAssetExtractorDelegate
    public synchronized int readSampleData(ByteBuffer byteBuffer, int i2) {
        int i3;
        AppMethodBeat.i(218479);
        if (!this.released) {
            i3 = this.mediaExtractor.readSampleData(byteBuffer, i2);
            AppMethodBeat.o(218479);
        } else {
            i3 = -1;
            AppMethodBeat.o(218479);
        }
        return i3;
    }

    @Override // com.tencent.tav.extractor.IAssetExtractorDelegate
    public synchronized int getSampleTrackIndex() {
        int i2;
        AppMethodBeat.i(218480);
        if (!this.released) {
            i2 = this.mediaExtractor.getSampleTrackIndex();
            AppMethodBeat.o(218480);
        } else {
            i2 = -1;
            AppMethodBeat.o(218480);
        }
        return i2;
    }

    @Override // com.tencent.tav.extractor.IAssetExtractorDelegate
    public synchronized long getSampleTime() {
        long j2;
        AppMethodBeat.i(218481);
        if (!this.released) {
            j2 = this.mediaExtractor.getSampleTime();
            AppMethodBeat.o(218481);
        } else {
            j2 = -1;
            AppMethodBeat.o(218481);
        }
        return j2;
    }
}
