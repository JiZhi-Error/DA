package com.tencent.tav.decoder.decodecache;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.IDecoderTrack;
import com.tencent.tav.decoder.ITexturePool;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tav.decoder.TexturePool;
import com.tencent.tav.decoder.logger.Logger;
import java.util.concurrent.CountDownLatch;

/* access modifiers changed from: package-private */
public class SegmentDecoderThread implements Handler.Callback {
    private static final int MSG_DECODER_FRAME = 3;
    private static final int MSG_DECODER_SEGMENT = 2;
    private static final int MSG_QUIT = 1000;
    private static final int MSG_START = 1;
    private static final String TAG = "SegmentDecoderThread";
    private CachedVideoDecoderTrack cachedVideoDecoderTrack;
    boolean cancel = false;
    RenderContext context;
    private Handler decoderHandler;
    private HandlerThread decoderThread;
    IDecoderTrack decoderTrack;
    private CopyFilter filter;
    CMSampleBuffer seekSampleBuffer;
    private volatile boolean started = false;
    ITexturePool texturePool;

    SegmentDecoderThread(CachedVideoDecoderTrack cachedVideoDecoderTrack2, IDecoderTrack iDecoderTrack) {
        AppMethodBeat.i(218438);
        this.cachedVideoDecoderTrack = cachedVideoDecoderTrack2;
        this.decoderTrack = iDecoderTrack;
        this.texturePool = new TexturePool();
        AppMethodBeat.o(218438);
    }

    private void start() {
        AppMethodBeat.i(218439);
        this.decoderThread = new HandlerThread("SegmentDecoder");
        this.decoderThread.start();
        this.decoderHandler = new Handler(this.decoderThread.getLooper(), this);
        AppMethodBeat.o(218439);
    }

    /* access modifiers changed from: package-private */
    public void decoderSegment(CacheSegment cacheSegment, RequestStatus requestStatus) {
        AppMethodBeat.i(218440);
        this.cancel = true;
        this.decoderHandler.removeCallbacksAndMessages(null);
        this.decoderHandler.obtainMessage(2, new DecoderSegmentMsg(cacheSegment, requestStatus)).sendToTarget();
        AppMethodBeat.o(218440);
    }

    /* access modifiers changed from: package-private */
    public void decoderSegment(CMTime cMTime, CountDownLatch countDownLatch) {
        AppMethodBeat.i(218441);
        this.cancel = true;
        this.decoderHandler.removeCallbacksAndMessages(null);
        this.decoderHandler.obtainMessage(3, new DecoderFrameMsg(cMTime, countDownLatch)).sendToTarget();
        AppMethodBeat.o(218441);
    }

    private void startDecoder() {
        AppMethodBeat.i(218442);
        this.context = new RenderContext(this.cachedVideoDecoderTrack.renderContext.width(), this.cachedVideoDecoderTrack.renderContext.height(), null, this.cachedVideoDecoderTrack.renderContext.eglContext());
        this.decoderTrack.start(this.context, this.cachedVideoDecoderTrack.validTimeRange);
        this.started = true;
        this.context.makeCurrent();
        this.filter = new CopyFilter();
        AppMethodBeat.o(218442);
    }

    private void quit() {
        AppMethodBeat.i(218443);
        if (!(this.seekSampleBuffer == null || this.seekSampleBuffer.getTextureInfo() == null)) {
            this.seekSampleBuffer.getTextureInfo().release();
        }
        this.filter.release();
        this.decoderTrack.release();
        this.texturePool.release();
        this.context.release();
        this.decoderHandler.removeCallbacksAndMessages(null);
        this.decoderThread.quit();
        AppMethodBeat.o(218443);
    }

    private void decoder(DecoderSegmentMsg decoderSegmentMsg) {
        CMTime cMTime;
        CMTimeRange cMTimeRange;
        AppMethodBeat.i(218444);
        synchronized (this.cachedVideoDecoderTrack.nextFrameDecoderLock) {
            try {
                this.cancel = false;
                CacheSegment cacheSegment = decoderSegmentMsg.segment;
                Logger.d(TAG, "decoder:------------------- " + decoderSegmentMsg.segment.segmentTimeRange.getStart() + "  -  " + decoderSegmentMsg.segment.segmentTimeRange.getEnd());
                CMTime start = cacheSegment.segmentTimeRange.getStart();
                CMTime end = cacheSegment.segmentTimeRange.getEnd();
                CMTime duration = cacheSegment.segmentTimeRange.getDuration();
                if (end.bigThan(this.decoderTrack.getDuration())) {
                    end = this.decoderTrack.getDuration();
                    cMTime = end.sub(start);
                } else {
                    cMTime = duration;
                }
                CMTimeRange cMTimeRange2 = new CMTimeRange(start, cacheSegment.segmentTimeRange.getDuration());
                if (this.cachedVideoDecoderTrack.revert) {
                    CMTime sub = this.decoderTrack.getDuration().sub(end);
                    if (sub.smallThan(CMTime.CMTimeZero)) {
                        sub = CMTime.CMTimeZero;
                    }
                    cMTimeRange = new CMTimeRange(sub, cMTime);
                } else {
                    cMTimeRange = cMTimeRange2;
                }
                Logger.d(TAG, "decoder2:------------------- " + cMTimeRange.getStart() + "  -  " + cMTimeRange.getEnd());
                if (cMTimeRange.getStart() != CMTime.CMTimeInvalid && this.cachedVideoDecoderTrack != null && this.context != null) {
                    this.context.makeCurrent();
                    this.decoderTrack.seekTo(cMTimeRange.getStart(), false, false);
                    CMSampleBuffer readSample = this.decoderTrack.readSample(cMTimeRange.getStart());
                    Logger.d(TAG, "decoder: readFirst " + readSample.getTime() + " cancel = " + this.cancel + "  - " + cMTimeRange.getEnd());
                    while (!readSample.getTime().smallThan(CMTime.CMTimeZero) && !this.cancel && readSample.getTime().smallThan(cMTimeRange.getEnd())) {
                        CacheFrame cacheFrame = new CacheFrame();
                        cacheFrame.texturePool = this.texturePool;
                        cacheFrame.frameTime = readSample.getTime();
                        Logger.d(TAG, "decoder:==================== frame.frameTime = " + cacheFrame.frameTime + "  " + readSample.getTextureInfo());
                        if (this.cachedVideoDecoderTrack.revert) {
                            cacheFrame.frameTime = this.decoderTrack.getDuration().sub(readSample.getTime());
                        }
                        cacheFrame.realFrameTime = readSample.getTime();
                        if (readSample.getTextureInfo() != null) {
                            RenderContext renderContext = this.context;
                            this.filter.setRenderForScreen(false);
                            this.filter.setRendererWidth(renderContext.width());
                            this.filter.setRendererHeight(renderContext.height());
                            renderContext.makeCurrent();
                            TextureInfo popTexture = this.texturePool.popTexture(3553, renderContext.width(), renderContext.height());
                            this.filter.setDesTextureInfo(popTexture);
                            Logger.d(TAG, "decoder:==================== " + readSample.getTime() + "  " + readSample.isNewFrame() + "  " + cacheFrame.frameTime);
                            this.filter.clearBufferBuffer(WebView.NIGHT_MODE_COLOR);
                            this.filter.applyFilter(readSample.getTextureInfo(), readSample.getTextureInfo().getTextureMatrix());
                            cacheFrame.sampleBuffer = new CMSampleBuffer(cacheFrame.frameTime, popTexture, readSample.isNewFrame());
                            cacheSegment.pushFrame(cacheFrame);
                        }
                        if (!cacheFrame.realFrameTime.add(this.cachedVideoDecoderTrack.getFrameDuration()).smallThan(cMTimeRange.getEnd())) {
                            break;
                        }
                        readSample = this.decoderTrack.readSample();
                    }
                }
            } finally {
                AppMethodBeat.o(218444);
            }
        }
        if (decoderSegmentMsg.callbackObject != null) {
            synchronized (decoderSegmentMsg.callbackObject) {
                try {
                    decoderSegmentMsg.callbackObject.setFinish(true);
                    decoderSegmentMsg.callbackObject.notifyAll();
                } finally {
                    AppMethodBeat.o(218444);
                }
            }
            return;
        }
        AppMethodBeat.o(218444);
    }

    private void decoder(DecoderFrameMsg decoderFrameMsg) {
        TextureInfo popTexture;
        AppMethodBeat.i(218445);
        CMTime cMTime = decoderFrameMsg.time;
        if (this.cachedVideoDecoderTrack.revert) {
            cMTime = this.decoderTrack.getDuration().sub(decoderFrameMsg.time);
        }
        if (this.context != null) {
            this.context.makeCurrent();
        }
        CMSampleBuffer seekTo = this.decoderTrack.seekTo(cMTime, true, false);
        if (seekTo.getTextureInfo() != null) {
            RenderContext renderContext = this.context;
            this.filter.setRenderForScreen(false);
            this.filter.setRendererWidth(renderContext.width());
            this.filter.setRendererHeight(renderContext.height());
            if (this.seekSampleBuffer != null) {
                popTexture = this.seekSampleBuffer.getTextureInfo();
            } else {
                popTexture = this.texturePool.popTexture(3553, renderContext.width(), renderContext.height());
            }
            this.filter.setDesTextureInfo(popTexture);
            Logger.d(TAG, "decoder:==========|=|========= " + seekTo.getTime() + "  " + seekTo.isNewFrame() + "  ");
            this.filter.clearBufferBuffer(WebView.NIGHT_MODE_COLOR);
            this.filter.applyFilter(seekTo.getTextureInfo(), seekTo.getTextureInfo().getTextureMatrix());
            CMTime time = seekTo.getTime();
            if (this.cachedVideoDecoderTrack.revert) {
                time = this.decoderTrack.getDuration().sub(time);
            }
            this.seekSampleBuffer = new CMSampleBuffer(time, popTexture, seekTo.isNewFrame());
        }
        if (decoderFrameMsg.finishWait != null) {
            synchronized (decoderFrameMsg.finishWait) {
                try {
                    decoderFrameMsg.finishWait.countDown();
                } finally {
                    AppMethodBeat.o(218445);
                }
            }
            return;
        }
        AppMethodBeat.o(218445);
    }

    /* access modifiers changed from: package-private */
    public void startForReady() {
        AppMethodBeat.i(218446);
        start();
        this.decoderHandler.sendEmptyMessage(1);
        while (!this.started) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e2) {
            }
        }
        AppMethodBeat.o(218446);
    }

    public boolean handleMessage(Message message) {
        AppMethodBeat.i(218447);
        switch (message.what) {
            case 1:
                startDecoder();
                break;
            case 2:
                decoder((DecoderSegmentMsg) message.obj);
                break;
            case 3:
                decoder((DecoderFrameMsg) message.obj);
                break;
            case 1000:
                quit();
                break;
        }
        AppMethodBeat.o(218447);
        return false;
    }

    /* access modifiers changed from: package-private */
    public void release() {
        AppMethodBeat.i(218448);
        this.cancel = true;
        if (this.decoderThread != null) {
            this.decoderHandler.removeCallbacksAndMessages(null);
            this.decoderHandler.sendEmptyMessage(1000);
        }
        AppMethodBeat.o(218448);
    }
}
