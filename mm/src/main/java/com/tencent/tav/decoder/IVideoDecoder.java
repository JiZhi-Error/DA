package com.tencent.tav.decoder;

import android.view.Surface;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.IDecoderTrack;

public interface IVideoDecoder extends IDecoder {
    long getPreReadCost();

    TextureInfo getTextureInfo();

    void init(String str, CGSize cGSize, IDecoderTrack.SurfaceCreator surfaceCreator);

    boolean isLastFrameValid();

    CMTime nextFrameTime(CMTime cMTime);

    Surface outputSurface();

    void release(boolean z);

    void seekTo(CMTime cMTime, boolean z);

    void switchFrame();
}
