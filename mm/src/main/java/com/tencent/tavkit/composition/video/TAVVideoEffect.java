package com.tencent.tavkit.composition.video;

import com.tencent.tavkit.ciimage.CIImage;

public interface TAVVideoEffect {

    public interface Filter {
        @RenderThread
        CIImage apply(TAVVideoEffect tAVVideoEffect, CIImage cIImage, RenderInfo renderInfo);

        @RenderThread
        void release();
    }

    @RenderThread
    Filter createFilter();

    String effectId();
}
