package com.tencent.tav.core;

import android.graphics.Matrix;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.asset.MetadataItem;
import com.tencent.tav.core.AssetWriter;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.EncoderWriter;
import com.tencent.tav.decoder.Filter;
import com.tencent.tav.decoder.logger.Logger;
import java.nio.ByteBuffer;
import java.util.List;

public class AssetWriterInput {
    private static final String TAG = "AssetWriterInput";
    private AssetWriter assetWriter;
    private Handler handler;
    private HandlerThread handlerThread;
    Filter matrixFilter;
    private int mediaType;
    private List<MetadataItem> metadata;
    private WriterProgressListener progressListener;
    private boolean readyForMoreMediaData;
    private boolean started = false;
    private StatusListener statusListener;
    private boolean stop = false;
    private Matrix transform;
    private EncoderWriter writer;
    private Handler writerHandler;
    private HandlerThread writerThread;

    /* access modifiers changed from: package-private */
    public interface StatusListener {
        void statusChanged(AssetWriterInput assetWriterInput, AssetWriter.AssetWriterStatus assetWriterStatus);
    }

    /* access modifiers changed from: package-private */
    public interface WriterProgressListener {
        void onError(ExportErrorStatus exportErrorStatus);

        void onProgressChanged(AssetWriterInput assetWriterInput, long j2);
    }

    public void setMetadata(List<MetadataItem> list) {
        this.metadata = list;
    }

    public void setTransform(Matrix matrix) {
        this.transform = matrix;
    }

    public int getMediaType() {
        return this.mediaType;
    }

    public List<MetadataItem> getMetadata() {
        return this.metadata;
    }

    public boolean isReadyForMoreMediaData() {
        AppMethodBeat.i(217807);
        if (!this.readyForMoreMediaData || (this.mediaType != 1 ? !this.writer.audioTrackWritable() : !this.writer.videoTrackWritable())) {
            AppMethodBeat.o(217807);
            return false;
        }
        AppMethodBeat.o(217807);
        return true;
    }

    public AssetWriterInput(int i2) {
        this.mediaType = i2;
    }

    public synchronized void requestMediaDataWhenReadyOnQueue(HandlerThread handlerThread2, final Runnable runnable) {
        AppMethodBeat.i(217808);
        if (this.handler != null) {
            Logger.e(TAG, "正在处理上一次的request请求，无法重复发起");
            AppMethodBeat.o(217808);
        } else if (this.assetWriter == null) {
            Logger.e(TAG, "还没有与AssetWriter关联，无法发起request请求");
            AppMethodBeat.o(217808);
        } else {
            this.handlerThread = handlerThread2;
            handlerThread2.start();
            this.handler = new Handler(handlerThread2.getLooper());
            this.handler.post(new Runnable() {
                /* class com.tencent.tav.core.AssetWriterInput.AnonymousClass1 */

                public void run() {
                    AppMethodBeat.i(217803);
                    if (AssetWriterInput.this.start()) {
                        runnable.run();
                    }
                    AppMethodBeat.o(217803);
                }
            });
            this.writerThread = new HandlerThread("writerThread");
            this.writerThread.start();
            this.writerHandler = new Handler(this.writerThread.getLooper());
            AppMethodBeat.o(217808);
        }
    }

    public ExportErrorStatus appendSampleBuffer(CMSampleBuffer cMSampleBuffer) {
        AppMethodBeat.i(217809);
        if (!this.stop) {
            try {
                Logger.e(TAG, "appendSampleBuffer: start " + cMSampleBuffer.getTime() + " type: " + this.mediaType);
                if (this.mediaType == 1 && this.assetWriter.renderContext() != null) {
                    ExportErrorStatus appendVideoSampleBuffer = appendVideoSampleBuffer(cMSampleBuffer);
                    AppMethodBeat.o(217809);
                    return appendVideoSampleBuffer;
                } else if (this.mediaType == 2) {
                    ExportErrorStatus appendAudioSampleBuffer = appendAudioSampleBuffer(cMSampleBuffer);
                    AppMethodBeat.o(217809);
                    return appendAudioSampleBuffer;
                }
            } catch (Throwable th) {
                Logger.e(TAG, "appendSampleBuffer: error", th);
                if (this.statusListener != null) {
                    this.statusListener.statusChanged(this, AssetWriter.AssetWriterStatus.AssetWriterStatusFailed);
                }
                ExportErrorStatus exportErrorStatus = new ExportErrorStatus(ExportErrorStatus.APPEND_BUFFER, th);
                AppMethodBeat.o(217809);
                return exportErrorStatus;
            }
        }
        ExportErrorStatus exportErrorStatus2 = new ExportErrorStatus(-11);
        AppMethodBeat.o(217809);
        return exportErrorStatus2;
    }

    private ExportErrorStatus appendAudioSampleBuffer(CMSampleBuffer cMSampleBuffer) {
        AppMethodBeat.i(217810);
        boolean smallThan = cMSampleBuffer.getTime().smallThan(CMTime.CMTimeZero);
        if (!smallThan) {
            ByteBuffer allocate = ByteBuffer.allocate(cMSampleBuffer.getSampleByteBuffer().limit());
            allocate.order(cMSampleBuffer.getSampleByteBuffer().order());
            allocate.put(cMSampleBuffer.getSampleByteBuffer());
            allocate.flip();
            cMSampleBuffer = new CMSampleBuffer(cMSampleBuffer.getTime(), allocate);
        }
        this.writerHandler.post(new WriterAudioRunnable(cMSampleBuffer, smallThan));
        AppMethodBeat.o(217810);
        return null;
    }

    private ExportErrorStatus appendVideoSampleBuffer(CMSampleBuffer cMSampleBuffer) {
        ExportErrorStatus exportErrorStatus;
        AppMethodBeat.i(217811);
        try {
            this.assetWriter.renderContext().makeCurrent();
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
            GLES20.glClear(16640);
            if (cMSampleBuffer == null || cMSampleBuffer.getTime().getTimeUs() < 0) {
                exportErrorStatus = null;
            } else {
                Logger.i(TAG, "appendSampleBuffer: start " + cMSampleBuffer.getTime());
                try {
                    TextureInfo renderSampleBuffer = renderSampleBuffer(cMSampleBuffer);
                    if (this.writer.isVideoEncodeNeedVideoRenderOutputTexture()) {
                        GLES20.glFinish();
                    }
                    this.writer.inputVideoSampleTexture(renderSampleBuffer);
                    exportErrorStatus = null;
                } catch (Exception e2) {
                    exportErrorStatus = new ExportErrorStatus(ExportErrorStatus.RENDER_SAMPLE_BUFFER, e2);
                }
                try {
                    this.assetWriter.renderContext().setPresentationTime(cMSampleBuffer.getTime().getTimeUs());
                    this.assetWriter.renderContext().swapBuffers();
                } catch (Exception e3) {
                    exportErrorStatus = new ExportErrorStatus(ExportErrorStatus.APPEND_VIDEO_SAMPLE_SWAP_BUFFERS, e3);
                }
                Logger.v(TAG, "appendSampleBuffer: end " + cMSampleBuffer.getTime());
            }
            this.writerHandler.post(new WriterVideoRunnable(cMSampleBuffer));
            AppMethodBeat.o(217811);
            return exportErrorStatus;
        } catch (Exception e4) {
            ExportErrorStatus exportErrorStatus2 = new ExportErrorStatus(ExportErrorStatus.APPEND_VIDEO_SAMPLE_MAKE_CURRENT, e4);
            AppMethodBeat.o(217811);
            return exportErrorStatus2;
        }
    }

    private TextureInfo renderSampleBuffer(CMSampleBuffer cMSampleBuffer) {
        AppMethodBeat.i(217812);
        TextureInfo textureInfo = cMSampleBuffer.getTextureInfo();
        if (textureInfo != null) {
            if (this.matrixFilter == null) {
                this.matrixFilter = new Filter();
                this.matrixFilter.setRendererWidth(this.assetWriter.renderContext().width());
                this.matrixFilter.setRendererHeight(this.assetWriter.renderContext().height());
                this.matrixFilter.setRenderForScreen(!this.writer.isVideoEncodeNeedVideoRenderOutputTexture());
            }
            TextureInfo applyFilter = this.matrixFilter.applyFilter(textureInfo, this.transform, textureInfo.getTextureMatrix());
            AppMethodBeat.o(217812);
            return applyFilter;
        }
        AppMethodBeat.o(217812);
        return null;
    }

    public void markAsFinished() {
        AppMethodBeat.i(217813);
        this.writerHandler.post(new Runnable() {
            /* class com.tencent.tav.core.AssetWriterInput.AnonymousClass2 */

            public void run() {
                AppMethodBeat.i(217804);
                if (AssetWriterInput.this.mediaType == 1) {
                    try {
                        AssetWriterInput.this.writer.endWriteVideoSample(null);
                    } catch (Throwable th) {
                        if (AssetWriterInput.this.progressListener != null) {
                            AssetWriterInput.this.progressListener.onError(new ExportErrorStatus(ExportErrorStatus.END_WRITE_VIDEO_SAMPLE, th));
                            AppMethodBeat.o(217804);
                            return;
                        }
                    }
                    if (AssetWriterInput.this.progressListener != null) {
                        AssetWriterInput.this.progressListener.onProgressChanged(AssetWriterInput.this, -1);
                        AppMethodBeat.o(217804);
                        return;
                    }
                } else {
                    try {
                        AssetWriterInput.this.writer.endWriteAudioSample();
                    } catch (Throwable th2) {
                        if (AssetWriterInput.this.progressListener != null) {
                            AssetWriterInput.this.progressListener.onError(new ExportErrorStatus(ExportErrorStatus.END_WRITE_AUDIO_SAMPLE, th2));
                            AppMethodBeat.o(217804);
                            return;
                        }
                    }
                    if (AssetWriterInput.this.progressListener != null) {
                        AssetWriterInput.this.progressListener.onProgressChanged(AssetWriterInput.this, -1);
                    }
                }
                AppMethodBeat.o(217804);
            }
        });
        AppMethodBeat.o(217813);
    }

    /* access modifiers changed from: package-private */
    public void stop() {
        this.stop = true;
        this.readyForMoreMediaData = false;
    }

    /* access modifiers changed from: package-private */
    public void initConfig(AssetWriter assetWriter2) {
        AppMethodBeat.i(217814);
        this.assetWriter = assetWriter2;
        this.writer = assetWriter2.encoderWriter();
        AppMethodBeat.o(217814);
    }

    /* access modifiers changed from: package-private */
    public boolean start() {
        AppMethodBeat.i(217815);
        Logger.i(TAG, "start");
        if (this.started) {
            AppMethodBeat.o(217815);
            return true;
        }
        try {
            if (this.mediaType == 1) {
                this.writer.startVideoEncoder();
                this.writer.setVideoSampleRenderContext(this.assetWriter.renderContext());
            } else {
                this.writer.startAudioEncoder();
            }
            this.readyForMoreMediaData = true;
            this.started = true;
        } catch (Exception e2) {
            Logger.e(TAG, "start: ", e2);
            onStartError(e2, this.mediaType);
        }
        boolean z = this.started;
        AppMethodBeat.o(217815);
        return z;
    }

    private void onStartError(Exception exc, int i2) {
        ExportErrorStatus exportErrorStatus;
        AppMethodBeat.i(217816);
        if (exc instanceof ExportRuntimeException) {
            exportErrorStatus = ((ExportRuntimeException) exc).getErrorStatus();
        } else {
            exportErrorStatus = new ExportErrorStatus(i2 == 1 ? -101 : -102, exc);
        }
        if (this.progressListener != null) {
            this.progressListener.onError(exportErrorStatus);
        }
        AppMethodBeat.o(217816);
    }

    public synchronized void close() {
        AppMethodBeat.i(217817);
        Logger.i(TAG, "close");
        if (this.handlerThread != null) {
            this.readyForMoreMediaData = false;
            this.handlerThread.quit();
            this.handlerThread = null;
            this.handler = null;
        }
        if (this.writerThread != null) {
            this.writerHandler.removeCallbacks(null);
            this.writerThread.quit();
            this.writerThread = null;
            this.writerHandler = null;
        }
        AppMethodBeat.o(217817);
    }

    /* access modifiers changed from: package-private */
    public void addStatusListener(StatusListener statusListener2) {
        this.statusListener = statusListener2;
    }

    /* access modifiers changed from: package-private */
    public void setWriterProgressListener(WriterProgressListener writerProgressListener) {
        this.progressListener = writerProgressListener;
    }

    /* access modifiers changed from: package-private */
    public class WriterAudioRunnable implements Runnable {
        private final boolean isEndBuffer;
        private final CMSampleBuffer sampleBuffer;

        private WriterAudioRunnable(CMSampleBuffer cMSampleBuffer, boolean z) {
            this.sampleBuffer = cMSampleBuffer;
            this.isEndBuffer = z;
        }

        public void run() {
            ExportErrorStatus exportErrorStatus;
            long j2;
            AppMethodBeat.i(217805);
            if (AssetWriterInput.this.handler == null) {
                AppMethodBeat.o(217805);
                return;
            }
            try {
                if (this.isEndBuffer) {
                    AssetWriterInput.this.writer.endWriteAudioSample();
                    j2 = -1;
                } else {
                    AssetWriterInput.this.writer.writeAudioSample(this.sampleBuffer.getTime().getTimeUs(), this.sampleBuffer.getSampleByteBuffer());
                    j2 = AssetWriterInput.this.writer.getAudioPresentationTimeUs();
                }
            } catch (Throwable th) {
                if (th instanceof ExportRuntimeException) {
                    exportErrorStatus = ((ExportRuntimeException) th).getErrorStatus();
                } else {
                    exportErrorStatus = new ExportErrorStatus(ExportErrorStatus.WRITE_AUDIO_SAMPLE, th);
                }
                if (AssetWriterInput.this.progressListener != null) {
                    AssetWriterInput.this.progressListener.onError(exportErrorStatus);
                    AppMethodBeat.o(217805);
                    return;
                }
                j2 = -1;
            }
            if (AssetWriterInput.this.progressListener != null) {
                AssetWriterInput.this.progressListener.onProgressChanged(AssetWriterInput.this, j2);
            }
            AppMethodBeat.o(217805);
        }
    }

    /* access modifiers changed from: package-private */
    public class WriterVideoRunnable implements Runnable {
        private final CMSampleBuffer sampleBuffer;

        private WriterVideoRunnable(CMSampleBuffer cMSampleBuffer) {
            this.sampleBuffer = cMSampleBuffer;
        }

        public void run() {
            ExportErrorStatus exportErrorStatus;
            AppMethodBeat.i(217806);
            if (AssetWriterInput.this.handler != null) {
                try {
                    AssetWriterInput.this.writer.writeVideoSample(this.sampleBuffer);
                    if (this.sampleBuffer != null) {
                        if (this.sampleBuffer.getState().stateMatchingTo(-1)) {
                            AssetWriterInput.this.writer.endWriteVideoSample(this.sampleBuffer);
                        }
                    }
                } catch (Throwable th) {
                    if (th instanceof ExportRuntimeException) {
                        exportErrorStatus = ((ExportRuntimeException) th).getErrorStatus();
                    } else {
                        exportErrorStatus = new ExportErrorStatus(ExportErrorStatus.WRITE_VIDEO_SAMPLE, th);
                    }
                    if (AssetWriterInput.this.progressListener != null) {
                        AssetWriterInput.this.progressListener.onError(exportErrorStatus);
                        AppMethodBeat.o(217806);
                        return;
                    }
                }
                if (AssetWriterInput.this.progressListener != null) {
                    AssetWriterInput.this.progressListener.onProgressChanged(AssetWriterInput.this, AssetWriterInput.this.writer.getVideoPresentationTimeUs());
                }
            }
            AppMethodBeat.o(217806);
        }
    }
}
