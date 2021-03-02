package com.tencent.tav.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.asset.MetadataItem;
import com.tencent.tav.core.compositing.VideoCompositing;
import com.tencent.tav.core.composition.VideoComposition;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.AssetWriterVideoEncoder;
import com.tencent.tav.decoder.EncoderWriter;
import com.tencent.tav.decoder.RenderContextParams;
import com.tencent.tav.decoder.logger.Logger;
import java.util.List;

public class AssetExportSession {
    public static final String TAG = "AssetExportSession";
    boolean appliesPreferredTrackTransform;
    Asset asset;
    AssetExtension assetExtension;
    private AudioMix audioMix;
    private final ExportConfig exportConfig;
    ExportErrorStatus exportErrorStatus;
    private AssetExportThread exportThread;
    private List<MetadataItem> metadata;
    String outputFilePath;
    String outputFileType;
    private String presetName;
    float progress;
    private RenderContextParams renderContextParams;
    private boolean revertMode;
    AssetExportSessionStatus status;
    private List<String> supportedFileTypes;
    CMTimeRange timeRange;
    VideoCompositing videoCompositing;
    VideoComposition videoComposition;
    private AssetWriterVideoEncoder videoEncoder;

    public interface ExportCallbackHandler {
        void handlerCallback(AssetExportSession assetExportSession);
    }

    public boolean isRevertMode() {
        return this.revertMode;
    }

    public void setRevertMode(boolean z) {
        this.revertMode = z;
    }

    public enum AssetExportSessionStatus {
        AssetExportSessionStatusUnknown,
        AssetExportSessionStatusExporting,
        AssetExportSessionStatusCompleted,
        AssetExportSessionStatusFailed,
        AssetExportSessionStatusCancelled;

        public static AssetExportSessionStatus valueOf(String str) {
            AppMethodBeat.i(217689);
            AssetExportSessionStatus assetExportSessionStatus = (AssetExportSessionStatus) Enum.valueOf(AssetExportSessionStatus.class, str);
            AppMethodBeat.o(217689);
            return assetExportSessionStatus;
        }

        static {
            AppMethodBeat.i(217690);
            AppMethodBeat.o(217690);
        }
    }

    public void setOutputFileType(String str) {
        this.outputFileType = str;
    }

    public void setOutputFilePath(String str) {
        this.outputFilePath = str;
    }

    public void setTimeRange(CMTimeRange cMTimeRange) {
        this.timeRange = cMTimeRange;
    }

    public void setMetadata(List<MetadataItem> list) {
        this.metadata = list;
    }

    public String getPresetName() {
        return this.presetName;
    }

    public Asset getAsset() {
        return this.asset;
    }

    public String getOutputFileType() {
        return this.outputFileType;
    }

    public String getOutputFilePath() {
        return this.outputFilePath;
    }

    public ExportConfig getExportConfig() {
        return this.exportConfig;
    }

    public AssetExportSessionStatus getStatus() {
        return this.status;
    }

    public List<String> getSupportedFileTypes() {
        return this.supportedFileTypes;
    }

    public int getErrCode() {
        if (this.exportErrorStatus != null) {
            return this.exportErrorStatus.code;
        }
        return 0;
    }

    public ExportErrorStatus getExportErrorStatus() {
        return this.exportErrorStatus;
    }

    public Throwable getThrowable() {
        if (this.exportErrorStatus != null) {
            return this.exportErrorStatus.throwable;
        }
        return null;
    }

    public float getProgress() {
        return this.progress;
    }

    public CMTimeRange getTimeRange() {
        return this.timeRange;
    }

    public List<MetadataItem> getMetadata() {
        return this.metadata;
    }

    public void setAppliesPreferredTrackTransform(boolean z) {
        this.appliesPreferredTrackTransform = z;
    }

    public void setAudioMix(AudioMix audioMix2) {
        this.audioMix = audioMix2;
    }

    public AudioMix getAudioMix() {
        return this.audioMix;
    }

    public void setVideoComposition(VideoComposition videoComposition2) {
        AppMethodBeat.i(217691);
        this.videoComposition = videoComposition2;
        if (videoComposition2 != null) {
            this.videoCompositing = videoComposition2.getCustomVideoCompositor();
        }
        AppMethodBeat.o(217691);
    }

    public VideoComposition getVideoComposition() {
        return this.videoComposition;
    }

    public RenderContextParams getRenderContextParams() {
        return this.renderContextParams;
    }

    public void setRenderContextParams(RenderContextParams renderContextParams2) {
        AppMethodBeat.i(217692);
        this.renderContextParams = renderContextParams2;
        if (this.exportThread != null) {
            this.exportThread.setRenderContextParams(renderContextParams2);
        }
        AppMethodBeat.o(217692);
    }

    public void setVideoEncoder(AssetWriterVideoEncoder assetWriterVideoEncoder) {
        this.videoEncoder = assetWriterVideoEncoder;
    }

    @Deprecated
    public AssetExportSession(Asset asset2, EncoderWriter.OutputConfig outputConfig) {
        this(asset2, new ExportConfig(outputConfig), new AssetExtension(AssetExtension.SCENE_EXPORT));
        AppMethodBeat.i(217693);
        AppMethodBeat.o(217693);
    }

    public AssetExportSession(Asset asset2, ExportConfig exportConfig2) {
        this(asset2, exportConfig2, new AssetExtension(AssetExtension.SCENE_EXPORT));
        AppMethodBeat.i(217694);
        AppMethodBeat.o(217694);
    }

    public AssetExportSession(Asset asset2, ExportConfig exportConfig2, AssetExtension assetExtension2) {
        AppMethodBeat.i(217695);
        this.outputFileType = "mp4";
        this.revertMode = false;
        this.appliesPreferredTrackTransform = false;
        this.asset = asset2;
        this.assetExtension = assetExtension2;
        if (exportConfig2 == null || !exportConfig2.available()) {
            Logger.e(TAG, "AssetExportSession: encodeOption 不合法");
            exportConfig2 = new ExportConfig((int) asset2.getNaturalSize().width, (int) asset2.getNaturalSize().height);
        }
        this.exportConfig = exportConfig2;
        AppMethodBeat.o(217695);
    }

    public void exportAsynchronouslyWithCompletionHandler(ExportCallbackHandler exportCallbackHandler) {
        AppMethodBeat.i(217696);
        this.exportThread = new AssetExportThread(this, exportCallbackHandler, this.audioMix, this.exportConfig);
        this.exportThread.setRenderContextParams(this.renderContextParams);
        this.exportThread.setVideoEncoder(this.videoEncoder);
        this.exportThread.startExport();
        AppMethodBeat.o(217696);
    }

    public void cancelExport() {
        AppMethodBeat.i(217697);
        Logger.i(TAG, "cancelExport");
        if (this.exportThread != null) {
            this.exportThread.cancel();
        }
        AppMethodBeat.o(217697);
    }

    /* access modifiers changed from: package-private */
    public void release() {
        AppMethodBeat.i(217698);
        if (this.audioMix != null) {
            this.audioMix.release();
            this.audioMix = null;
        }
        AppMethodBeat.o(217698);
    }
}
