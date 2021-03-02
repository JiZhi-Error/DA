package com.tencent.tav.decoder.muxer;

import android.media.MediaCodec;
import android.media.MediaFormat;
import com.tencent.tav.core.ExportConfig;
import com.tencent.tav.coremedia.CMTime;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;

public interface IMediaMuxer {

    @Retention(RetentionPolicy.SOURCE)
    public @interface Format {
    }

    int addTrack(MediaFormat mediaFormat);

    int audioTrackIndex();

    boolean ignoreHeader();

    boolean isMuxerStarted();

    void release();

    void setExportConfig(ExportConfig exportConfig);

    void start();

    void stop();

    int videoTrackIndex();

    void writeSampleData(int i2, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo);

    void writeSampleDataTime(boolean z, CMTime cMTime);

    public static final class OutputFormat {
        public static final int MUXER_OUTPUT_3GPP = 2;
        public static final int MUXER_OUTPUT_FIRST = 0;
        public static final int MUXER_OUTPUT_HEIF = 3;
        public static final int MUXER_OUTPUT_LAST = 3;
        public static final int MUXER_OUTPUT_MPEG_4 = 0;
        public static final int MUXER_OUTPUT_WEBM = 1;

        private OutputFormat() {
        }
    }
}
