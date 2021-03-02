package com.tencent.tav.core;

import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tav.core.compositing.AsynchronousVideoCompositionRequest;
import com.tencent.tav.core.compositing.IVideoCompositionInstruction;
import com.tencent.tav.core.compositing.VideoCompositing;
import com.tencent.tav.core.compositing.VideoCompositionRenderContext;
import com.tencent.tav.core.composition.VideoCompositionLayerInstruction;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.coremedia.Transform;
import com.tencent.tav.decoder.DecoderUtils;
import com.tencent.tav.decoder.RenderContext;
import java.util.HashMap;

public class VideoCompositor implements VideoCompositing {
    private MultiTextureFilter filter;

    @Override // com.tencent.tav.core.compositing.VideoCompositing
    public HashMap<String, Object> sourcePixelBufferAttributes() {
        return null;
    }

    @Override // com.tencent.tav.core.compositing.VideoCompositing
    public HashMap<String, Object> requiredPixelBufferAttributesForRenderContext() {
        return null;
    }

    @Override // com.tencent.tav.core.compositing.VideoCompositing
    public void renderContextChanged(VideoCompositionRenderContext videoCompositionRenderContext) {
    }

    @Override // com.tencent.tav.core.compositing.VideoCompositing
    public void startVideoCompositionRequest(AsynchronousVideoCompositionRequest asynchronousVideoCompositionRequest) {
        AppMethodBeat.i(217952);
        if (!checkRequest(asynchronousVideoCompositionRequest)) {
            AppMethodBeat.o(217952);
            return;
        }
        initFilter(asynchronousVideoCompositionRequest);
        CMSampleBuffer cMSampleBuffer = new CMSampleBuffer(asynchronousVideoCompositionRequest.getCompositionTime(), asynchronousVideoCompositionRequest.getRenderContext().newTextureInfo(), false);
        if (cMSampleBuffer.getTextureInfo() == null) {
            AppMethodBeat.o(217952);
            return;
        }
        this.filter.setDesTextureInfo(cMSampleBuffer.getTextureInfo());
        IVideoCompositionInstruction videoCompositionInstruction = asynchronousVideoCompositionRequest.getVideoCompositionInstruction();
        if (videoCompositionInstruction == null || videoCompositionInstruction.getLayerInstructions() == null || videoCompositionInstruction.getLayerInstructions().size() == 0) {
            drawSrcBuffer(asynchronousVideoCompositionRequest);
        } else {
            drawInstructionBuffer(asynchronousVideoCompositionRequest, videoCompositionInstruction);
        }
        asynchronousVideoCompositionRequest.finishWithComposedVideoFrame(finishComposedVideoFrame(asynchronousVideoCompositionRequest.getRenderContext().getRenderContext(), cMSampleBuffer));
        AppMethodBeat.o(217952);
    }

    public CMSampleBuffer finishComposedVideoFrame(RenderContext renderContext, CMSampleBuffer cMSampleBuffer) {
        return cMSampleBuffer;
    }

    private boolean checkRequest(AsynchronousVideoCompositionRequest asynchronousVideoCompositionRequest) {
        AppMethodBeat.i(217953);
        if (asynchronousVideoCompositionRequest.getRenderContext() == null || asynchronousVideoCompositionRequest.getSourceTrackIDs() == null || asynchronousVideoCompositionRequest.getSourceTrackIDs().isEmpty()) {
            AppMethodBeat.o(217953);
            return false;
        }
        AppMethodBeat.o(217953);
        return true;
    }

    private void initFilter(AsynchronousVideoCompositionRequest asynchronousVideoCompositionRequest) {
        AppMethodBeat.i(217954);
        if (this.filter == null) {
            CGSize size = asynchronousVideoCompositionRequest.getRenderContext().getSize();
            this.filter = new MultiTextureFilter();
            this.filter.setRendererWidth((int) size.width);
            this.filter.setRendererHeight((int) size.height);
            this.filter.setRenderForScreen(false);
        }
        AppMethodBeat.o(217954);
    }

    private void drawSrcBuffer(AsynchronousVideoCompositionRequest asynchronousVideoCompositionRequest) {
        AppMethodBeat.i(217955);
        this.filter.clearBufferBuffer(WebView.NIGHT_MODE_COLOR);
        for (Integer num : asynchronousVideoCompositionRequest.getSourceTrackIDs()) {
            CMSampleBuffer sourceFrameByTrackID = asynchronousVideoCompositionRequest.sourceFrameByTrackID(num.intValue());
            if (!(sourceFrameByTrackID == null || sourceFrameByTrackID.getTextureInfo() == null)) {
                TextureInfo textureInfo = sourceFrameByTrackID.getTextureInfo();
                Matrix matrix = new Matrix();
                DecoderUtils.getRotationMatrix(matrix, textureInfo.preferRotation, (float) textureInfo.width, (float) textureInfo.height);
                this.filter.applyFilter(sourceFrameByTrackID.getTextureInfo(), matrix, textureInfo.getTextureMatrix(), 1.0f, null);
            }
        }
        AppMethodBeat.o(217955);
    }

    private void drawInstructionBuffer(AsynchronousVideoCompositionRequest asynchronousVideoCompositionRequest, IVideoCompositionInstruction iVideoCompositionInstruction) {
        AppMethodBeat.i(217956);
        this.filter.clearBufferBuffer(iVideoCompositionInstruction.getBackgroundColor());
        for (VideoCompositionLayerInstruction videoCompositionLayerInstruction : iVideoCompositionInstruction.getLayerInstructions()) {
            CMSampleBuffer sourceFrameByTrackID = asynchronousVideoCompositionRequest.sourceFrameByTrackID(videoCompositionLayerInstruction.getTrackID());
            if (!(sourceFrameByTrackID == null || sourceFrameByTrackID.getTextureInfo() == null)) {
                CMTime compositionTime = asynchronousVideoCompositionRequest.getCompositionTime();
                Transform transformForTime = getTransformForTime(compositionTime, videoCompositionLayerInstruction.getTransformRampForTime(compositionTime));
                Matrix matrix = transformForTime == null ? null : transformForTime.toMatrix();
                this.filter.applyFilter(sourceFrameByTrackID.getTextureInfo(), matrix, null, getOpacityForTime(compositionTime, videoCompositionLayerInstruction.getOpacityRampForTime(compositionTime)), getCropRectangleForTime(compositionTime, videoCompositionLayerInstruction.getCropRectangleRampForTime(compositionTime)));
            }
        }
        AppMethodBeat.o(217956);
    }

    private static Transform getTransformForTime(CMTime cMTime, VideoCompositionLayerInstruction.TransformRamp transformRamp) {
        AppMethodBeat.i(217957);
        if (!transformRamp.timeRange.containsTime(cMTime) || transformRamp.startTransform == null || transformRamp.endTransform == null) {
            AppMethodBeat.o(217957);
            return null;
        }
        float timeUs = (((float) (cMTime.getTimeUs() - transformRamp.timeRange.getStartUs())) * 1.0f) / ((float) transformRamp.timeRange.getDurationUs());
        Transform transform = new Transform(interpolation(timeUs, transformRamp.startTransform.scaleX, transformRamp.endTransform.scaleX), interpolation(timeUs, transformRamp.startTransform.scaleY, transformRamp.endTransform.scaleY), interpolation(timeUs, transformRamp.startTransform.translateX, transformRamp.endTransform.translateX), interpolation(timeUs, transformRamp.startTransform.translateY, transformRamp.endTransform.translateY), interpolation(timeUs, transformRamp.startTransform.degrees, transformRamp.endTransform.degrees));
        AppMethodBeat.o(217957);
        return transform;
    }

    private static float getOpacityForTime(CMTime cMTime, VideoCompositionLayerInstruction.OpacityRamp opacityRamp) {
        AppMethodBeat.i(217958);
        if (!opacityRamp.timeRange.containsTime(cMTime)) {
            AppMethodBeat.o(217958);
            return 1.0f;
        }
        float interpolation = interpolation((1.0f * ((float) (cMTime.getTimeUs() - opacityRamp.timeRange.getStartUs()))) / ((float) opacityRamp.timeRange.getDurationUs()), opacityRamp.startOpacity, opacityRamp.endOpacity);
        AppMethodBeat.o(217958);
        return interpolation;
    }

    private static CGRect getCropRectangleForTime(CMTime cMTime, VideoCompositionLayerInstruction.CropRectangleRamp cropRectangleRamp) {
        AppMethodBeat.i(217959);
        if (cropRectangleRamp.startCropRectangle == null || cropRectangleRamp.endCropRectangle == null || !cropRectangleRamp.timeRange.containsTime(cMTime)) {
            AppMethodBeat.o(217959);
            return null;
        }
        float timeUs = (((float) (cMTime.getTimeUs() - cropRectangleRamp.timeRange.getStartUs())) * 1.0f) / ((float) cropRectangleRamp.timeRange.getDurationUs());
        CGRect cGRect = new CGRect(interpolation(timeUs, cropRectangleRamp.startCropRectangle.origin.x, cropRectangleRamp.endCropRectangle.origin.x), interpolation(timeUs, cropRectangleRamp.startCropRectangle.origin.y, cropRectangleRamp.endCropRectangle.origin.y), interpolation(timeUs, cropRectangleRamp.startCropRectangle.size.width, cropRectangleRamp.endCropRectangle.size.width), interpolation(timeUs, cropRectangleRamp.startCropRectangle.size.height, cropRectangleRamp.endCropRectangle.size.height));
        AppMethodBeat.o(217959);
        return cGRect;
    }

    private static float interpolation(float f2, float f3, float f4) {
        return f3 == f4 ? f3 : f3 + ((f4 - f3) * f2);
    }

    @Override // com.tencent.tav.core.compositing.VideoCompositing
    public void cancelAllPendingVideoCompositionRequests() {
    }

    @Override // com.tencent.tav.core.compositing.VideoCompositing
    public void release() {
        AppMethodBeat.i(217960);
        if (this.filter != null) {
            this.filter.release();
            this.filter = null;
        }
        AppMethodBeat.o(217960);
    }
}
