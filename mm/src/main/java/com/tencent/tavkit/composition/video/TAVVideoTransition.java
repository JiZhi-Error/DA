package com.tencent.tavkit.composition.video;

import com.tencent.tav.coremedia.CMTime;
import com.tencent.tavkit.ciimage.CIImage;

public interface TAVVideoTransition {

    public interface Filter {
        @RenderThread
        CIImage apply(TAVVideoTransition tAVVideoTransition, CIImage cIImage, CIImage cIImage2, float f2, RenderInfo renderInfo);

        @RenderThread
        void release();
    }

    @RenderThread
    Filter createFilter();

    String effectId();

    CMTime getDuration();
}
