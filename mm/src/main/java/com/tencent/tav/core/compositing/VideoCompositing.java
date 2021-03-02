package com.tencent.tav.core.compositing;

import java.util.HashMap;

public interface VideoCompositing {
    void cancelAllPendingVideoCompositionRequests();

    void release();

    void renderContextChanged(VideoCompositionRenderContext videoCompositionRenderContext);

    HashMap<String, Object> requiredPixelBufferAttributesForRenderContext();

    HashMap<String, Object> sourcePixelBufferAttributes();

    void startVideoCompositionRequest(AsynchronousVideoCompositionRequest asynchronousVideoCompositionRequest);
}
