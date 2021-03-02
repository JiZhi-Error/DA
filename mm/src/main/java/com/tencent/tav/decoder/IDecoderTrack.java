package com.tencent.tav.decoder;

import android.view.Surface;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.IDecoder;
import java.util.List;

public interface IDecoderTrack {

    public interface SurfaceCreator {
        Surface createOutputSurface(int i2, int i3, int i4);

        void free(Surface surface);

        void release();

        VideoTexture videoTextureForSurface(Surface surface);
    }

    void asyncReadNextSample(CMTime cMTime);

    void clipRangeAndClearRange(CMTimeRange cMTimeRange);

    CMTime getCurrentSampleTime();

    CMTime getDuration();

    CMTime getFrameDuration();

    int getFrameRate();

    long getLaggingTime();

    int getTrackId();

    CMSampleBuffer readSample();

    CMSampleBuffer readSample(CMTime cMTime);

    void release();

    CMSampleBuffer seekTo(CMTime cMTime, boolean z, boolean z2);

    void setDecodeType(IDecoder.DecodeType decodeType);

    void setFrameRate(int i2);

    void setTrackSegments(List<DecoderTrackSegment> list);

    void setVolume(float f2);

    void start();

    void start(SurfaceCreator surfaceCreator);

    void start(SurfaceCreator surfaceCreator, CMTimeRange cMTimeRange);
}
