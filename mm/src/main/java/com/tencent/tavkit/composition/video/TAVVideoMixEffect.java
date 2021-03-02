package com.tencent.tavkit.composition.video;

import com.tencent.tavkit.ciimage.CIImage;

public interface TAVVideoMixEffect {

    public interface Filter {
        @RenderThread
        CIImage apply(TAVVideoMixEffect tAVVideoMixEffect, ImageCollection imageCollection, RenderInfo renderInfo);

        @RenderThread
        void release();
    }

    @RenderThread
    Filter createFilter();

    String effectId();
}
