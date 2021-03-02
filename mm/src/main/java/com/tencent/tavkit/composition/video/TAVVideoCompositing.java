package com.tencent.tavkit.composition.video;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.core.compositing.AsynchronousVideoCompositionRequest;
import com.tencent.tav.core.compositing.IVideoCompositionInstruction;
import com.tencent.tav.core.compositing.VideoCompositing;
import com.tencent.tav.core.compositing.VideoCompositionRenderContext;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.ErrorMsg;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tavkit.ciimage.CIContext;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.ciimage.ThreadLocalTextureCache;
import com.tencent.tavkit.composition.model.TAVVideoConfiguration;
import com.tencent.tavkit.composition.video.TAVAttachTimeRangeSourceEffect;
import com.tencent.tavkit.composition.video.TAVVideoEffect;
import com.tencent.tavkit.composition.video.TAVVideoMixEffect;
import com.tencent.tavkit.composition.video.TAVVideoTransition;
import com.tencent.tavkit.report.CompositingReportSession;
import com.tencent.tavkit.report.MemoryReportHelper;
import com.tencent.tavkit.utils.BenchUtil;
import java.util.HashMap;
import java.util.List;

public class TAVVideoCompositing implements VideoCompositing {
    private final String TAG = ("TAVVideoCompositing@" + Integer.toHexString(hashCode()));
    private CIContext ciContext;
    private final TAVVideoMixEffect.Filter defaultVideoMixFilter = new DefaultVideoMixFilter();
    private final HashMap<String, TAVVideoEffect.Filter> globalFilterMap = new HashMap<>();
    private final HashMap<String, TAVVideoMixEffect.Filter> mixFilterMap = new HashMap<>();
    private Thread renderThread;
    private CompositingReportSession reportSession;
    private final HashMap<String, TAVVideoEffect.Filter> sourceFilterMap = new HashMap<>();
    private final HashMap<String, TAVVideoTransition.Filter> transitionFilterMap = new HashMap<>();
    private boolean tryPostReleaseDone = false;

    public TAVVideoCompositing() {
        AppMethodBeat.i(197614);
        AppMethodBeat.o(197614);
    }

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
    public void cancelAllPendingVideoCompositionRequests() {
    }

    @Override // com.tencent.tav.core.compositing.VideoCompositing
    public void startVideoCompositionRequest(AsynchronousVideoCompositionRequest asynchronousVideoCompositionRequest) {
        AppMethodBeat.i(197615);
        if (this.reportSession == null) {
            this.reportSession = new CompositingReportSession(asynchronousVideoCompositionRequest.getRenderContext().getSize().width, asynchronousVideoCompositionRequest.getRenderContext().getSize().height);
        }
        long nanoTime = System.nanoTime();
        Logger.v(this.TAG, "startVideoCompositionRequest: begin, currentThread = " + Thread.currentThread().getName() + ", request = [" + asynchronousVideoCompositionRequest + "]");
        if (this.ciContext == null) {
            this.ciContext = new CIContext(asynchronousVideoCompositionRequest.getRenderContext().getRenderContext());
        }
        if (this.renderThread == null) {
            this.renderThread = Thread.currentThread();
        }
        IVideoCompositionInstruction videoCompositionInstruction = asynchronousVideoCompositionRequest.getVideoCompositionInstruction();
        if (!(videoCompositionInstruction instanceof TAVVideoCompositionInstruction)) {
            Logger.e(this.TAG, "startVideoCompositionRequest: end, ".concat(String.valueOf("instruction not instanceof TAVVideoCompositionInstruction")));
            this.reportSession.tickFailed();
            asynchronousVideoCompositionRequest.finishWithError(new ErrorMsg(10086, "instruction not instanceof TAVVideoCompositionInstruction"));
            AppMethodBeat.o(197615);
            return;
        }
        BenchUtil.benchStart("compositingImages");
        CIImage compositingImages = compositingImages(asynchronousVideoCompositionRequest, (TAVVideoCompositionInstruction) videoCompositionInstruction);
        BenchUtil.benchEnd("compositingImages");
        BenchUtil.benchStart("renderToSampleBuffer");
        reportMemory();
        if (compositingImages != null) {
            CMSampleBuffer renderToSampleBuffer = this.ciContext.renderToSampleBuffer(compositingImages, asynchronousVideoCompositionRequest.getCompositionTime(), asynchronousVideoCompositionRequest.getRenderContext().getRenderContext());
            Logger.v(this.TAG, "startVideoCompositionRequest: end, resultPixels = [" + renderToSampleBuffer + "]");
            this.reportSession.tickSuccess(System.nanoTime() - nanoTime);
            asynchronousVideoCompositionRequest.finishWithComposedVideoFrame(renderToSampleBuffer);
        } else {
            Logger.e(this.TAG, "startVideoCompositionRequest: end, ".concat(String.valueOf("destImage is null ")));
            this.reportSession.tickFailed();
            asynchronousVideoCompositionRequest.finishWithError(new ErrorMsg(10086, "destImage is null "));
        }
        BenchUtil.benchEnd("renderToSampleBuffer");
        AppMethodBeat.o(197615);
    }

    private void reportMemory() {
        AppMethodBeat.i(197616);
        if (MemoryReportHelper.isInIntervalTime()) {
            AppMethodBeat.o(197616);
            return;
        }
        String appendReportKey = MemoryReportHelper.appendReportKey(this.sourceFilterMap.values());
        String appendReportKey2 = MemoryReportHelper.appendReportKey(this.mixFilterMap.values());
        MemoryReportHelper.getInstance().tick("sourceFilter:[" + appendReportKey + "], mixFilter:[" + appendReportKey2 + "], globalFilter:[" + MemoryReportHelper.appendReportKey(this.globalFilterMap.values()) + "]");
        AppMethodBeat.o(197616);
    }

    private CIImage compositingImages(AsynchronousVideoCompositionRequest asynchronousVideoCompositionRequest, TAVVideoCompositionInstruction tAVVideoCompositionInstruction) {
        AppMethodBeat.i(197617);
        if (this.ciContext == null) {
            AppMethodBeat.o(197617);
            return null;
        }
        for (TAVVideoEffect.Filter filter : this.sourceFilterMap.values()) {
            if (filter instanceof TAVAttachTimeRangeSourceEffect.TimeAttachFilter) {
                ((TAVAttachTimeRangeSourceEffect.TimeAttachFilter) filter).attachPositionTime(asynchronousVideoCompositionRequest.getCompositionTime());
            }
        }
        RenderInfo renderInfo = new RenderInfo(asynchronousVideoCompositionRequest.getCompositionTime(), asynchronousVideoCompositionRequest.getRenderContext().getSize(), this.ciContext);
        ImageCollection convertToImageCollection = convertToImageCollection(asynchronousVideoCompositionRequest, renderInfo, tAVVideoCompositionInstruction);
        TAVVideoMixEffect.Filter videoMixFilter = getVideoMixFilter(tAVVideoCompositionInstruction, tAVVideoCompositionInstruction.getVideoMixEffect());
        CIImage apply = videoMixFilter != null ? videoMixFilter.apply(tAVVideoCompositionInstruction.getVideoMixEffect(), convertToImageCollection, renderInfo) : null;
        if (apply == null) {
            apply = this.defaultVideoMixFilter.apply(null, convertToImageCollection, renderInfo);
        }
        TAVVideoEffect.Filter globalFilter = getGlobalFilter(tAVVideoCompositionInstruction.getGlobalVideoEffect());
        if (globalFilter != null) {
            apply = globalFilter.apply(tAVVideoCompositionInstruction.getGlobalVideoEffect(), apply, renderInfo);
        }
        AppMethodBeat.o(197617);
        return apply;
    }

    private ImageCollection convertToImageCollection(AsynchronousVideoCompositionRequest asynchronousVideoCompositionRequest, RenderInfo renderInfo, TAVVideoCompositionInstruction tAVVideoCompositionInstruction) {
        AppMethodBeat.i(197618);
        ImageCollection imageCollection = new ImageCollection();
        for (List<TAVVideoCompositionLayerInstruction> list : tAVVideoCompositionInstruction.getChannelLayers()) {
            for (TAVVideoCompositionLayerInstruction tAVVideoCompositionLayerInstruction : list) {
                CIImage convertLayerToImage = convertLayerToImage(asynchronousVideoCompositionRequest, renderInfo, tAVVideoCompositionLayerInstruction, tAVVideoCompositionInstruction.getSourceVideoEffect());
                if (convertLayerToImage != null && !convertLayerToImage.isCanvasImage()) {
                    imageCollection.addChannelImage(convertLayerToImage, tAVVideoCompositionLayerInstruction.getImageSource());
                }
            }
        }
        for (TAVVideoCompositionLayerInstruction tAVVideoCompositionLayerInstruction2 : tAVVideoCompositionInstruction.getOverlayLayers()) {
            CIImage convertLayerToImage2 = convertLayerToImage(asynchronousVideoCompositionRequest, renderInfo, tAVVideoCompositionLayerInstruction2, tAVVideoCompositionInstruction.getSourceVideoEffect());
            if (convertLayerToImage2 != null && !convertLayerToImage2.isCanvasImage()) {
                imageCollection.addOverlayImage(convertLayerToImage2, tAVVideoCompositionLayerInstruction2.getImageSource());
            }
        }
        Logger.v(this.TAG, "convertToImageCollection: result imageCollection = ".concat(String.valueOf(imageCollection)));
        AppMethodBeat.o(197618);
        return imageCollection;
    }

    private TAVVideoMixEffect.Filter getVideoMixFilter(TAVVideoCompositionInstruction tAVVideoCompositionInstruction, TAVVideoMixEffect tAVVideoMixEffect) {
        TAVVideoMixEffect.Filter createFilter;
        AppMethodBeat.i(197619);
        if (tAVVideoMixEffect == null || TextUtils.isEmpty(tAVVideoMixEffect.effectId())) {
            AppMethodBeat.o(197619);
            return null;
        }
        String effectId = tAVVideoMixEffect.effectId();
        if (this.mixFilterMap.containsKey(effectId)) {
            createFilter = this.mixFilterMap.get(effectId);
        } else {
            createFilter = tAVVideoCompositionInstruction.getVideoMixEffect().createFilter();
            this.mixFilterMap.put(effectId, createFilter);
        }
        AppMethodBeat.o(197619);
        return createFilter;
    }

    private TAVVideoEffect.Filter getGlobalFilter(TAVVideoEffect tAVVideoEffect) {
        TAVVideoEffect.Filter createFilter;
        AppMethodBeat.i(197620);
        if (tAVVideoEffect == null || TextUtils.isEmpty(tAVVideoEffect.effectId())) {
            AppMethodBeat.o(197620);
            return null;
        }
        String effectId = tAVVideoEffect.effectId();
        if (this.globalFilterMap.containsKey(effectId)) {
            createFilter = this.globalFilterMap.get(effectId);
        } else {
            createFilter = tAVVideoEffect.createFilter();
            this.globalFilterMap.put(effectId, createFilter);
        }
        AppMethodBeat.o(197620);
        return createFilter;
    }

    private CIImage convertLayerToImage(AsynchronousVideoCompositionRequest asynchronousVideoCompositionRequest, RenderInfo renderInfo, TAVVideoCompositionLayerInstruction tAVVideoCompositionLayerInstruction, TAVVideoEffect tAVVideoEffect) {
        AppMethodBeat.i(197621);
        if (!tAVVideoCompositionLayerInstruction.getTimeRange().containsTime(renderInfo.getTime())) {
            AppMethodBeat.o(197621);
            return null;
        }
        CIImage sourceImageAtTime = tAVVideoCompositionLayerInstruction.getImageSource().sourceImageAtTime(renderInfo.getTime().sub(tAVVideoCompositionLayerInstruction.getTimeRange().getStart()), renderInfo.getRenderSize());
        if (sourceImageAtTime == null) {
            sourceImageAtTime = getImageWithRequest(asynchronousVideoCompositionRequest, tAVVideoCompositionLayerInstruction);
            Logger.v(this.TAG, "convertLayerToImage: begin sourceImage by request, sourceImage = ".concat(String.valueOf(sourceImageAtTime)));
        }
        if (sourceImageAtTime == null) {
            Logger.w(this.TAG, "convertLayerToImage: begin sourceImage by request, sourceImage is null ");
            AppMethodBeat.o(197621);
            return null;
        }
        renderInfo.addTrack(tAVVideoCompositionLayerInstruction.getImageSource());
        sourceImageAtTime.applyPreferRotation(tAVVideoCompositionLayerInstruction.getVideoConfiguration().getPreferRotation());
        applySourceTransform(tAVVideoCompositionLayerInstruction.getVideoConfiguration(), sourceImageAtTime, renderInfo);
        CIImage applyCompositionSourceEffect = applyCompositionSourceEffect(renderInfo, applyClipSourceEffect(renderInfo, sourceImageAtTime, tAVVideoCompositionLayerInstruction.getVideoConfiguration().getEffects()), tAVVideoEffect);
        Logger.v(this.TAG, "convertLayerToImage: end, returned: ".concat(String.valueOf(applyCompositionSourceEffect)));
        AppMethodBeat.o(197621);
        return applyCompositionSourceEffect;
    }

    private CIImage getImageWithRequest(AsynchronousVideoCompositionRequest asynchronousVideoCompositionRequest, TAVVideoCompositionLayerInstruction tAVVideoCompositionLayerInstruction) {
        AppMethodBeat.i(197622);
        CMSampleBuffer sourceFrameByTrackID = asynchronousVideoCompositionRequest.sourceFrameByTrackID(tAVVideoCompositionLayerInstruction.getTrackID());
        if (sourceFrameByTrackID == null || sourceFrameByTrackID.getTextureInfo() == null) {
            AppMethodBeat.o(197622);
            return null;
        }
        CIImage cIImage = new CIImage(sourceFrameByTrackID.getTextureInfo());
        AppMethodBeat.o(197622);
        return cIImage;
    }

    private CIImage applyClipSourceEffect(RenderInfo renderInfo, CIImage cIImage, List<TAVVideoEffect> list) {
        AppMethodBeat.i(197623);
        if (list == null || list.isEmpty()) {
            AppMethodBeat.o(197623);
        } else {
            for (TAVVideoEffect tAVVideoEffect : list) {
                TAVVideoEffect.Filter sourceFilter = getSourceFilter(tAVVideoEffect);
                if (sourceFilter != null) {
                    cIImage = sourceFilter.apply(tAVVideoEffect, cIImage, renderInfo);
                }
            }
            AppMethodBeat.o(197623);
        }
        return cIImage;
    }

    private CIImage applyCompositionSourceEffect(RenderInfo renderInfo, CIImage cIImage, TAVVideoEffect tAVVideoEffect) {
        AppMethodBeat.i(197624);
        TAVVideoEffect.Filter sourceFilter = getSourceFilter(tAVVideoEffect);
        if (sourceFilter == null) {
            AppMethodBeat.o(197624);
            return cIImage;
        }
        CIImage apply = sourceFilter.apply(tAVVideoEffect, cIImage, renderInfo);
        AppMethodBeat.o(197624);
        return apply;
    }

    private TAVVideoEffect.Filter getSourceFilter(TAVVideoEffect tAVVideoEffect) {
        TAVVideoEffect.Filter createFilter;
        AppMethodBeat.i(197625);
        if (tAVVideoEffect == null || TextUtils.isEmpty(tAVVideoEffect.effectId())) {
            AppMethodBeat.o(197625);
            return null;
        }
        String effectId = tAVVideoEffect.effectId();
        if (this.sourceFilterMap.containsKey(effectId)) {
            createFilter = this.sourceFilterMap.get(effectId);
        } else {
            createFilter = tAVVideoEffect.createFilter();
            this.sourceFilterMap.put(effectId, createFilter);
        }
        AppMethodBeat.o(197625);
        return createFilter;
    }

    private void applySourceTransform(TAVVideoConfiguration tAVVideoConfiguration, CIImage cIImage, RenderInfo renderInfo) {
        AppMethodBeat.i(197626);
        Logger.v(this.TAG, "applySourceTransform() called with: config = [" + tAVVideoConfiguration + "]");
        if (tAVVideoConfiguration.frameEnable()) {
            cIImage.applyFillInFrame(tAVVideoConfiguration.getFrame(), tAVVideoConfiguration.getContentMode());
        } else if (tAVVideoConfiguration.getFrame() == TAVVideoConfiguration.FIX_RENDER_SIZE) {
            cIImage.applyFixInSize(renderInfo.getRenderSize(), tAVVideoConfiguration.getContentMode());
        }
        cIImage.safeApplyTransform(tAVVideoConfiguration.getTransform());
        AppMethodBeat.o(197626);
    }

    @Override // com.tencent.tav.core.compositing.VideoCompositing
    public void release() {
        AppMethodBeat.i(197627);
        if (this.renderThread == null || Thread.currentThread().equals(this.renderThread)) {
            this.tryPostReleaseDone = false;
            Logger.d(this.TAG, "release: begin, currentThread = " + Thread.currentThread().getName());
            if (this.ciContext != null) {
                this.ciContext.release();
            }
            for (TAVVideoTransition.Filter filter : this.transitionFilterMap.values()) {
                filter.release();
            }
            for (TAVVideoEffect.Filter filter2 : this.sourceFilterMap.values()) {
                filter2.release();
            }
            for (TAVVideoMixEffect.Filter filter3 : this.mixFilterMap.values()) {
                filter3.release();
            }
            for (TAVVideoEffect.Filter filter4 : this.globalFilterMap.values()) {
                filter4.release();
            }
            this.transitionFilterMap.clear();
            this.sourceFilterMap.clear();
            this.mixFilterMap.clear();
            this.globalFilterMap.clear();
            ThreadLocalTextureCache.getInstance().release();
            if (this.reportSession != null) {
                this.reportSession.flush();
                this.reportSession = null;
            }
            Logger.d(this.TAG, "release: end, currentThread = " + Thread.currentThread().getName());
            AppMethodBeat.o(197627);
            return;
        }
        Logger.e(this.TAG, "release: 当前线程非渲染线程！currentThread = " + Thread.currentThread().getName() + ", renderThread = " + this.renderThread.getName());
        tryPostReleaseToRenderThread();
        AppMethodBeat.o(197627);
    }

    private void tryPostReleaseToRenderThread() {
        AppMethodBeat.i(197628);
        if (this.tryPostReleaseDone) {
            AppMethodBeat.o(197628);
            return;
        }
        this.tryPostReleaseDone = true;
        if (this.renderThread instanceof HandlerThread) {
            new Handler(((HandlerThread) this.renderThread).getLooper()).post(new Runnable() {
                /* class com.tencent.tavkit.composition.video.TAVVideoCompositing.AnonymousClass1 */

                public void run() {
                    AppMethodBeat.i(197613);
                    TAVVideoCompositing.this.release();
                    AppMethodBeat.o(197613);
                }
            });
        }
        AppMethodBeat.o(197628);
    }
}
