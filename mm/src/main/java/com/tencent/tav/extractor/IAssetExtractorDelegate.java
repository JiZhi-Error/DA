package com.tencent.tav.extractor;

import android.content.res.AssetFileDescriptor;
import android.media.MediaFormat;
import java.io.FileDescriptor;
import java.nio.ByteBuffer;

/* access modifiers changed from: package-private */
public interface IAssetExtractorDelegate {
    boolean advance();

    long getSampleTime();

    int getSampleTrackIndex();

    int getTrackCount();

    MediaFormat getTrackFormat(int i2);

    int readSampleData(ByteBuffer byteBuffer, int i2);

    void release();

    void seekTo(long j2, int i2);

    void selectTrack(int i2);

    void setDataSource(AssetFileDescriptor assetFileDescriptor);

    void setDataSource(FileDescriptor fileDescriptor);

    void setDataSource(String str);

    void unselectTrack(int i2);
}
