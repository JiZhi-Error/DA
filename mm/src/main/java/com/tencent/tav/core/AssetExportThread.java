package com.tencent.tav.core;

import android.graphics.Matrix;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.asset.AssetTrack;
import com.tencent.tav.core.AssetExportSession;
import com.tencent.tav.core.AssetWriterInput;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMSampleState;
import com.tencent.tav.decoder.AssetWriterVideoEncoder;
import com.tencent.tav.decoder.AudioInfo;
import com.tencent.tav.decoder.DecoderUtils;
import com.tencent.tav.decoder.RenderContextParams;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tav.report.ExportReportSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* access modifiers changed from: package-private */
public class AssetExportThread extends HandlerThread implements Handler.Callback {
    private static final String TAG = "AssetExportThread";
    private static final int msg_done_a = 2;
    private static final int msg_done_v = 1;
    private AssetReader assetReader;
    private AssetWriter assetWriter;
    private HandlerThread audioExportThread;
    private AudioInfo audioInfo;
    private AudioMix audioMix;
    private float audioProgress;
    private boolean audioReadFinish = false;
    private AssetReaderOutput audioReader;
    private long audioTime = 0;
    private AssetWriterInput audioWriter;
    private volatile boolean audioWriterDone = false;
    private AssetExportSession.ExportCallbackHandler callbackHandler;
    private volatile boolean cancel = false;
    private final ExportConfig encodeOption;
    private Handler exportHandler;
    private AssetExportSession exportSession;
    private boolean isFinishing;
    private RenderContextParams renderContextParams;
    private ExportReportSession reportSession = new ExportReportSession();
    private AssetWriterVideoEncoder videoEncoder;
    private HandlerThread videoExportThread;
    private float videoProgress;
    private boolean videoReadFinish = false;
    private AssetReaderOutput videoReader;
    private long videoTime = 0;
    private AssetWriterInput videoWriter;
    private volatile boolean videoWriterDone = false;

    static /* synthetic */ void access$1000(AssetExportThread assetExportThread) {
        AppMethodBeat.i(217726);
        assetExportThread.exportSuccess();
        AppMethodBeat.o(217726);
    }

    static /* synthetic */ void access$1200(AssetExportThread assetExportThread) {
        AppMethodBeat.i(217727);
        assetExportThread.exporting();
        AppMethodBeat.o(217727);
    }

    static /* synthetic */ long access$1700(AssetExportThread assetExportThread) {
        AppMethodBeat.i(217728);
        long duration = assetExportThread.getDuration();
        AppMethodBeat.o(217728);
        return duration;
    }

    static /* synthetic */ void access$2400(AssetExportThread assetExportThread, ExportErrorStatus exportErrorStatus) {
        AppMethodBeat.i(217729);
        assetExportThread.exportError(exportErrorStatus);
        AppMethodBeat.o(217729);
    }

    static /* synthetic */ void access$400(AssetExportThread assetExportThread, int i2, Throwable th) {
        AppMethodBeat.i(217725);
        assetExportThread.exportError(i2, th);
        AppMethodBeat.o(217725);
    }

    AssetExportThread(AssetExportSession assetExportSession, AssetExportSession.ExportCallbackHandler exportCallbackHandler, AudioMix audioMix2, ExportConfig exportConfig) {
        super("ExportThread");
        AppMethodBeat.i(217709);
        this.exportSession = assetExportSession;
        this.callbackHandler = exportCallbackHandler;
        this.audioMix = audioMix2;
        this.audioInfo = new AudioInfo(exportConfig.getAudioSampleRateHz(), exportConfig.getAudioChannelCount(), 2);
        this.encodeOption = exportConfig;
        AppMethodBeat.o(217709);
    }

    public void setVideoEncoder(AssetWriterVideoEncoder assetWriterVideoEncoder) {
        this.videoEncoder = assetWriterVideoEncoder;
    }

    private void finish() {
        AppMethodBeat.i(217710);
        new Handler(this.videoExportThread.getLooper()).post(new Runnable() {
            /* class com.tencent.tav.core.AssetExportThread.AnonymousClass1 */

            public void run() {
                AppMethodBeat.i(217699);
                if (AssetExportThread.this.videoExportThread != null) {
                    if (Build.VERSION.SDK_INT >= 18) {
                        AssetExportThread.this.videoExportThread.quitSafely();
                    } else {
                        AssetExportThread.this.videoExportThread.quit();
                    }
                    AssetExportThread.this.videoExportThread = null;
                }
                if (AssetExportThread.this.audioExportThread != null) {
                    if (Build.VERSION.SDK_INT >= 18) {
                        AssetExportThread.this.audioExportThread.quitSafely();
                    } else {
                        AssetExportThread.this.audioExportThread.quit();
                    }
                    AssetExportThread.this.audioExportThread = null;
                }
                if (AssetExportThread.this.assetReader != null) {
                    AssetExportThread.this.assetReader.cancelReading();
                    AssetExportThread.this.assetReader = null;
                }
                boolean z = false;
                if (AssetExportThread.this.assetWriter != null) {
                    try {
                        AssetExportThread.this.assetWriter.finishWriting();
                        z = true;
                    } catch (Exception e2) {
                        Logger.e(AssetExportSession.TAG, "code = -10 run: finishWriting error", e2);
                        AssetExportThread.access$400(AssetExportThread.this, -10, e2);
                    }
                    AssetExportThread.this.assetWriter = null;
                }
                if (AssetExportThread.this.videoWriter != null) {
                    AssetExportThread.this.videoWriter.close();
                }
                if (AssetExportThread.this.audioWriter != null) {
                    AssetExportThread.this.audioWriter.close();
                }
                if (AssetExportThread.this.videoWriterDone && AssetExportThread.this.audioWriterDone && z && !AssetExportThread.this.cancel) {
                    AssetExportThread.access$1000(AssetExportThread.this);
                }
                if (Build.VERSION.SDK_INT >= 18) {
                    AssetExportThread.this.quitSafely();
                } else {
                    AssetExportThread.this.quit();
                }
                if (AssetExportThread.this.exportSession != null) {
                    AssetExportThread.this.exportSession.release();
                }
                AppMethodBeat.o(217699);
            }
        });
        AppMethodBeat.o(217710);
    }

    /* access modifiers changed from: package-private */
    public synchronized void cancel() {
        AppMethodBeat.i(217711);
        this.cancel = true;
        this.exportSession.status = AssetExportSession.AssetExportSessionStatus.AssetExportSessionStatusCancelled;
        if (this.reportSession != null) {
            this.reportSession.reset();
            this.reportSession = null;
        }
        AppMethodBeat.o(217711);
    }

    private synchronized void exportError(int i2, Throwable th) {
        AppMethodBeat.i(217712);
        exportError(new ExportErrorStatus(i2, th));
        AppMethodBeat.o(217712);
    }

    private void exportError(ExportErrorStatus exportErrorStatus) {
        AppMethodBeat.i(217713);
        if (this.exportSession.status != AssetExportSession.AssetExportSessionStatus.AssetExportSessionStatusFailed) {
            this.cancel = true;
            this.exportSession.status = AssetExportSession.AssetExportSessionStatus.AssetExportSessionStatusFailed;
            this.exportSession.exportErrorStatus = exportErrorStatus;
            if (this.reportSession != null) {
                this.reportSession.onExportError();
            }
            if (this.callbackHandler != null) {
                this.callbackHandler.handlerCallback(this.exportSession);
            }
        }
        AppMethodBeat.o(217713);
    }

    private synchronized void exportSuccess() {
        AppMethodBeat.i(217714);
        synchronized (this) {
            try {
                if (this.exportSession.status != AssetExportSession.AssetExportSessionStatus.AssetExportSessionStatusCompleted) {
                    this.exportSession.progress = 1.0f;
                    this.exportSession.status = AssetExportSession.AssetExportSessionStatus.AssetExportSessionStatusCompleted;
                    if (this.reportSession != null) {
                        this.reportSession.onExportSuccess();
                    }
                    if (this.callbackHandler != null) {
                        this.callbackHandler.handlerCallback(this.exportSession);
                    }
                    AppMethodBeat.o(217714);
                }
            } finally {
                AppMethodBeat.o(217714);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void startExport() {
        AppMethodBeat.i(217715);
        start();
        this.cancel = false;
        if (this.reportSession != null) {
            this.reportSession.onExportStart(System.nanoTime());
        }
        this.exportHandler = new Handler(getLooper(), this);
        this.exportHandler.post(new Runnable() {
            /* class com.tencent.tav.core.AssetExportThread.AnonymousClass2 */

            public void run() {
                AppMethodBeat.i(217700);
                AssetExportThread.access$1200(AssetExportThread.this);
                AppMethodBeat.o(217700);
            }
        });
        AppMethodBeat.o(217715);
    }

    private void exporting() {
        AppMethodBeat.i(217716);
        initReaderAndWriter();
        this.exportSession.status = AssetExportSession.AssetExportSessionStatus.AssetExportSessionStatusExporting;
        this.videoExportThread = new HandlerThread("VideoWriter");
        this.videoWriter.setWriterProgressListener(new VideoWriterProgressListener());
        this.videoWriter.requestMediaDataWhenReadyOnQueue(this.videoExportThread, new VideoRequestMediaDataCallback());
        if (this.audioWriter != null) {
            this.audioExportThread = new HandlerThread("AudioWriter");
            this.audioWriter.setWriterProgressListener(new AudioWriterProgressListener());
            this.audioWriter.requestMediaDataWhenReadyOnQueue(this.audioExportThread, new AudioRequestMediaDataCallback());
            AppMethodBeat.o(217716);
            return;
        }
        this.audioReadFinish = true;
        this.audioWriterDone = true;
        AppMethodBeat.o(217716);
    }

    private void initReaderAndWriter() {
        AppMethodBeat.i(217717);
        this.assetReader = new AssetReader(this.exportSession.asset);
        this.assetReader.setTimeRange(this.exportSession.timeRange);
        this.videoReader = createVideoTrackOutput();
        this.audioReader = createAudioTrackOutput();
        if (this.assetReader.canAddOutput(this.videoReader)) {
            this.assetReader.addOutput(this.videoReader);
        }
        if (!(this.audioReader instanceof EmptyReaderOutput) && this.assetReader.canAddOutput(this.audioReader)) {
            this.assetReader.addOutput(this.audioReader);
        }
        this.assetWriter = new AssetWriter(this.exportSession.outputFilePath, this.exportSession.outputFileType);
        this.assetWriter.setRenderContextParams(this.renderContextParams);
        if (this.exportSession.timeRange != null) {
            this.assetWriter.startSessionAtSourceTime(this.exportSession.timeRange.getStart());
            this.assetWriter.endSessionAtSourceTime(this.exportSession.timeRange.getEnd());
            if (this.reportSession != null) {
                this.reportSession.setFileDurationUs(this.exportSession.timeRange.getDurationUs());
            }
        }
        this.assetWriter.setEncodeOption(this.encodeOption);
        this.videoWriter = createVideoWriterInput();
        if (!(this.audioReader instanceof EmptyReaderOutput)) {
            this.audioWriter = createAudioWriterInput();
        }
        if (this.assetWriter.canAddInput(this.videoWriter)) {
            Matrix matrix = null;
            if (this.exportSession.appliesPreferredTrackTransform) {
                matrix = DecoderUtils.getPreferMatrix(new CGSize((float) this.encodeOption.getOutputWidth(), (float) this.encodeOption.getOutputHeight()), this.exportSession.asset.getNaturalSize(), this.exportSession.asset.getPreferRotation());
            }
            this.videoWriter.setTransform(matrix);
            this.assetWriter.addInput(this.videoWriter);
        }
        if (this.audioWriter != null && this.assetWriter.canAddInput(this.audioWriter)) {
            this.assetWriter.addInput(this.audioWriter);
        }
        this.assetWriter.startWriting(this.videoEncoder);
        this.assetReader.startReading(this.assetWriter);
        AppMethodBeat.o(217717);
    }

    private AssetWriterInput createVideoWriterInput() {
        AppMethodBeat.i(217718);
        if (this.reportSession != null) {
            this.reportSession.setFramePerSecond(this.encodeOption.getVideoFrameRate());
        }
        AssetWriterInput assetWriterInput = new AssetWriterInput(1);
        AppMethodBeat.o(217718);
        return assetWriterInput;
    }

    private AssetWriterInput createAudioWriterInput() {
        AppMethodBeat.i(217719);
        AssetWriterInput assetWriterInput = new AssetWriterInput(2);
        AppMethodBeat.o(217719);
        return assetWriterInput;
    }

    private AssetReaderOutput createVideoTrackOutput() {
        AppMethodBeat.i(217720);
        List<AssetTrack> tracksWithMediaType = this.exportSession.asset.tracksWithMediaType(1);
        if (tracksWithMediaType == null || tracksWithMediaType.size() <= 0) {
            EmptyReaderOutput emptyReaderOutput = new EmptyReaderOutput();
            AppMethodBeat.o(217720);
            return emptyReaderOutput;
        }
        HashMap hashMap = new HashMap(4);
        hashMap.put("frame-rate", Integer.valueOf(this.encodeOption.getVideoFrameRate()));
        AssetReaderVideoCompositionOutput assetReaderVideoCompositionOutput = new AssetReaderVideoCompositionOutput(tracksWithMediaType, hashMap, this.exportSession.assetExtension);
        assetReaderVideoCompositionOutput.setVideoComposition(this.exportSession.videoComposition);
        assetReaderVideoCompositionOutput.setVideoCompositing(this.exportSession.videoCompositing);
        assetReaderVideoCompositionOutput.setVideoRevertMode(this.exportSession.isRevertMode());
        AppMethodBeat.o(217720);
        return assetReaderVideoCompositionOutput;
    }

    private AssetReaderOutput createAudioTrackOutput() {
        AppMethodBeat.i(217721);
        ArrayList arrayList = (ArrayList) this.exportSession.asset.tracksWithMediaType(2);
        if (arrayList == null || arrayList.size() <= 0) {
            EmptyReaderOutput emptyReaderOutput = new EmptyReaderOutput();
            AppMethodBeat.o(217721);
            return emptyReaderOutput;
        }
        AssetReaderAudioMixOutput assetReaderAudioMixOutput = new AssetReaderAudioMixOutput(arrayList, null);
        assetReaderAudioMixOutput.setAudioMix(this.audioMix);
        assetReaderAudioMixOutput.setAudioInfo(this.audioInfo);
        AppMethodBeat.o(217721);
        return assetReaderAudioMixOutput;
    }

    private long getDuration() {
        long j2 = 0;
        AppMethodBeat.i(217722);
        if (this.exportSession == null || this.exportSession.timeRange == null) {
            long duration = this.audioReader != null ? this.audioReader.duration() : 0;
            if (this.videoReader != null) {
                j2 = this.videoReader.duration();
            }
            long j3 = duration + j2;
            AppMethodBeat.o(217722);
            return j3;
        }
        long timeUs = this.exportSession.timeRange.getDuration().getTimeUs() * 2;
        AppMethodBeat.o(217722);
        return timeUs;
    }

    public boolean handleMessage(Message message) {
        AppMethodBeat.i(217723);
        switch (message.what) {
            case 1:
            case 2:
                if (!this.isFinishing) {
                    if (this.cancel) {
                        this.isFinishing = true;
                        finish();
                    }
                    if (this.videoWriterDone && this.audioWriterDone && this.audioReadFinish && this.videoReadFinish) {
                        this.isFinishing = true;
                        finish();
                        break;
                    }
                }
                break;
        }
        AppMethodBeat.o(217723);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void setRenderContextParams(RenderContextParams renderContextParams2) {
        AppMethodBeat.i(217724);
        this.renderContextParams = renderContextParams2;
        if (this.assetWriter != null) {
            this.assetWriter.setRenderContextParams(renderContextParams2);
        }
        AppMethodBeat.o(217724);
    }

    /* access modifiers changed from: package-private */
    public class VideoWriterProgressListener implements AssetWriterInput.WriterProgressListener {
        private VideoWriterProgressListener() {
        }

        @Override // com.tencent.tav.core.AssetWriterInput.WriterProgressListener
        public void onProgressChanged(AssetWriterInput assetWriterInput, long j2) {
            long j3;
            AppMethodBeat.i(217707);
            Logger.i(AssetExportSession.TAG, "onProgressChanged: videoWriter " + j2 + "  / " + AssetExportThread.access$1700(AssetExportThread.this));
            if (j2 == -1) {
                AssetExportThread.this.videoTime = AssetExportThread.this.exportSession.timeRange.getDuration().getTimeUs();
                AssetExportThread.this.videoProgress = 1.0f;
                AssetExportThread.this.videoWriterDone = true;
                AssetExportThread.this.exportHandler.sendEmptyMessage(1);
                AppMethodBeat.o(217707);
                return;
            }
            AssetExportThread.this.videoTime = j2;
            if (AssetExportThread.this.exportSession.timeRange != null) {
                j3 = AssetExportThread.this.exportSession.timeRange.getDuration().getTimeUs();
            } else if (AssetExportThread.this.videoReader != null) {
                j3 = AssetExportThread.this.videoReader.duration();
            } else {
                j3 = 0;
            }
            if (j3 != 0) {
                AssetExportThread.this.videoProgress = (((float) AssetExportThread.this.videoTime) * 1.0f) / ((float) j3);
            } else {
                AssetExportThread.this.videoProgress = 1.0f;
            }
            AssetExportThread.this.exportSession.progress = Math.min(AssetExportThread.this.videoProgress, AssetExportThread.this.audioProgress);
            if (AssetExportThread.this.callbackHandler != null) {
                AssetExportThread.this.callbackHandler.handlerCallback(AssetExportThread.this.exportSession);
            }
            AppMethodBeat.o(217707);
        }

        @Override // com.tencent.tav.core.AssetWriterInput.WriterProgressListener
        public void onError(ExportErrorStatus exportErrorStatus) {
            AppMethodBeat.i(217708);
            Logger.e(AssetExportThread.TAG, "VideoWriterProgressListener onError: ", exportErrorStatus.throwable);
            AssetExportThread.access$2400(AssetExportThread.this, exportErrorStatus);
            AppMethodBeat.o(217708);
        }
    }

    /* access modifiers changed from: package-private */
    public class VideoRequestMediaDataCallback implements Runnable {
        private VideoRequestMediaDataCallback() {
        }

        public void run() {
            AppMethodBeat.i(217705);
            try {
                onRequestMediaData();
                AppMethodBeat.o(217705);
            } catch (Throwable th) {
                Logger.e(AssetExportThread.TAG, "VideoRequestMediaDateCallback run: ", th);
                AssetExportThread.access$400(AssetExportThread.this, -14, th);
                AppMethodBeat.o(217705);
            }
        }

        private void onRequestMediaData() {
            boolean z = false;
            AppMethodBeat.i(217706);
            while (true) {
                if (AssetExportThread.this.videoWriterDone || AssetExportThread.this.cancel) {
                    break;
                } else if (AssetExportThread.this.videoReader != null && AssetExportThread.this.videoWriter.isReadyForMoreMediaData()) {
                    long nanoTime = System.nanoTime();
                    CMSampleBuffer copyNextSampleBuffer = AssetExportThread.this.videoReader.copyNextSampleBuffer();
                    CMSampleState state = copyNextSampleBuffer.getState();
                    Logger.i(AssetExportThread.TAG, "onRequestMediaData stateCode: " + state.getStateCode());
                    if (state.getStateCode() >= 0) {
                        ExportErrorStatus appendSampleBuffer = AssetExportThread.this.videoWriter.appendSampleBuffer(copyNextSampleBuffer);
                        if (appendSampleBuffer != null) {
                            AssetExportThread.access$2400(AssetExportThread.this, appendSampleBuffer);
                        }
                        if (AssetExportThread.this.reportSession != null) {
                            AssetExportThread.this.reportSession.tickExport(System.nanoTime() - nanoTime);
                        }
                    } else {
                        if (state.stateMatchingTo(-1)) {
                            AssetExportThread.this.videoWriter.markAsFinished();
                            break;
                        } else if (state.getStateCode() != -4) {
                            AssetExportThread.access$2400(AssetExportThread.this, new ExportErrorStatus(state));
                            break;
                        }
                    }
                }
            }
            if (AssetExportThread.this.videoWriter.matrixFilter != null) {
                AssetExportThread.this.videoWriter.matrixFilter.release();
            }
            if (AssetExportThread.this.exportSession.videoCompositing != null) {
                AssetExportThread.this.exportSession.videoCompositing.release();
            }
            AssetExportThread assetExportThread = AssetExportThread.this;
            if (!AssetExportThread.this.cancel) {
                z = true;
            }
            assetExportThread.videoReadFinish = z;
            AssetExportThread.this.exportHandler.sendEmptyMessage(1);
            AppMethodBeat.o(217706);
        }
    }

    /* access modifiers changed from: package-private */
    public class AudioWriterProgressListener implements AssetWriterInput.WriterProgressListener {
        private AudioWriterProgressListener() {
        }

        @Override // com.tencent.tav.core.AssetWriterInput.WriterProgressListener
        public void onProgressChanged(AssetWriterInput assetWriterInput, long j2) {
            long j3;
            AppMethodBeat.i(217703);
            Logger.i(AssetExportSession.TAG, "onProgressChanged: audioWriter " + j2 + "  / " + AssetExportThread.access$1700(AssetExportThread.this));
            if (j2 == -1) {
                AssetExportThread.this.audioTime = AssetExportThread.this.exportSession.timeRange.getDuration().getTimeUs();
                AssetExportThread.this.audioProgress = 1.0f;
                AssetExportThread.this.audioWriterDone = true;
                AssetExportThread.this.exportHandler.sendEmptyMessage(2);
                AppMethodBeat.o(217703);
                return;
            }
            AssetExportThread.this.audioTime = j2;
            if (AssetExportThread.this.exportSession.timeRange != null) {
                j3 = AssetExportThread.this.exportSession.timeRange.getDuration().getTimeUs();
            } else if (AssetExportThread.this.audioReader != null) {
                j3 = AssetExportThread.this.audioReader.duration();
            } else {
                j3 = 0;
            }
            if (j3 != 0) {
                AssetExportThread.this.audioProgress = (((float) AssetExportThread.this.videoTime) * 1.0f) / ((float) j3);
            } else {
                AssetExportThread.this.audioProgress = 1.0f;
            }
            AssetExportThread.this.exportSession.progress = Math.min(AssetExportThread.this.videoProgress, AssetExportThread.this.audioProgress);
            if (AssetExportThread.this.callbackHandler != null) {
                AssetExportThread.this.callbackHandler.handlerCallback(AssetExportThread.this.exportSession);
            }
            if ((AssetExportThread.this.audioTime > AssetExportThread.this.videoTime && AssetExportThread.this.videoWriterDone) || AssetExportThread.this.audioTime >= AssetExportThread.this.exportSession.timeRange.getDuration().getTimeUs()) {
                AssetExportThread.this.audioTime = AssetExportThread.this.exportSession.timeRange.getDuration().getTimeUs();
                AssetExportThread.this.audioWriterDone = true;
                AssetExportThread.this.exportHandler.sendEmptyMessage(2);
            }
            AppMethodBeat.o(217703);
        }

        @Override // com.tencent.tav.core.AssetWriterInput.WriterProgressListener
        public void onError(ExportErrorStatus exportErrorStatus) {
            AppMethodBeat.i(217704);
            Logger.e(AssetExportThread.TAG, "AudioWriterProgressListener onError: ", exportErrorStatus.throwable);
            AssetExportThread.access$2400(AssetExportThread.this, exportErrorStatus);
            AppMethodBeat.o(217704);
        }
    }

    /* access modifiers changed from: package-private */
    public class AudioRequestMediaDataCallback implements Runnable {
        private AudioRequestMediaDataCallback() {
        }

        public void run() {
            AppMethodBeat.i(217701);
            try {
                onAudioRequestMediaData();
                AppMethodBeat.o(217701);
            } catch (Throwable th) {
                Logger.e(AssetExportThread.TAG, "AudioRequestMediaDateCallback run: ", th);
                AssetExportThread.access$400(AssetExportThread.this, -15, th);
                AppMethodBeat.o(217701);
            }
        }

        private void onAudioRequestMediaData() {
            AppMethodBeat.i(217702);
            while (true) {
                if (AssetExportThread.this.audioWriterDone || AssetExportThread.this.cancel || AssetExportThread.this.audioWriter == null) {
                    break;
                } else if (AssetExportThread.this.audioReader != null && AssetExportThread.this.audioWriter.isReadyForMoreMediaData()) {
                    AssetExportThread.this.audioReader.duration();
                    CMSampleBuffer copyNextSampleBuffer = AssetExportThread.this.audioReader.copyNextSampleBuffer();
                    CMSampleState state = copyNextSampleBuffer.getState();
                    if (state.getStateCode() >= 0) {
                        ExportErrorStatus appendSampleBuffer = AssetExportThread.this.audioWriter.appendSampleBuffer(copyNextSampleBuffer);
                        if (appendSampleBuffer != null) {
                            AssetExportThread.access$2400(AssetExportThread.this, appendSampleBuffer);
                        }
                        if (copyNextSampleBuffer.getTime().getTimeUs() >= AssetExportThread.this.exportSession.timeRange.getDuration().getTimeUs()) {
                            AssetExportThread.this.audioWriter.markAsFinished();
                            break;
                        }
                    } else if (state.getStateCode() == -1) {
                        AssetExportThread.this.audioWriter.markAsFinished();
                        break;
                    } else if (state.getStateCode() != -4) {
                        AssetExportThread.access$2400(AssetExportThread.this, new ExportErrorStatus(state));
                        break;
                    }
                }
            }
            AssetExportThread.this.audioReadFinish = !AssetExportThread.this.cancel;
            AssetExportThread.this.exportHandler.sendEmptyMessage(2);
            AppMethodBeat.o(217702);
        }
    }
}
