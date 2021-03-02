package com.tencent.tavkit.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.core.AssetExportSession;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.EncoderWriter;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.TAVSource;
import com.tencent.tavkit.composition.builder.TAVCompositionBuilder;
import java.io.File;
import java.io.IOException;

public class TAVExporter {
    public static final int VIDEO_EXPORT_HEIGHT = 1280;
    public static final int VIDEO_EXPORT_WIDTH = 720;
    private final String TAG = ("GameTemplateExporter@" + Integer.toHexString(hashCode()));
    private EncoderWriter.OutputConfig defaultOutputConfig = new EncoderWriter.OutputConfig();
    private ExportListener exportListener;
    private AssetExportSession exportSession;
    private volatile boolean isCanceled;
    private volatile boolean isExporting;

    public interface ExportListener {
        void onExportCancel();

        void onExportCompleted(String str);

        void onExportError(int i2, Throwable th);

        void onExportStart();

        void onExporting(float f2);
    }

    public TAVExporter() {
        AppMethodBeat.i(197360);
        this.defaultOutputConfig.VIDEO_TARGET_WIDTH = VIDEO_EXPORT_WIDTH;
        this.defaultOutputConfig.VIDEO_TARGET_HEIGHT = VIDEO_EXPORT_HEIGHT;
        this.defaultOutputConfig.VIDEO_FRAME_RATE = 25;
        AppMethodBeat.o(197360);
    }

    public AssetExportSession getExportSession() {
        return this.exportSession;
    }

    public void export(TAVComposition tAVComposition, final String str, EncoderWriter.OutputConfig outputConfig) {
        AppMethodBeat.i(197361);
        if (tAVComposition == null) {
            AppMethodBeat.o(197361);
            return;
        }
        if (this.exportSession != null) {
            this.exportSession.cancelExport();
            this.exportSession = null;
        }
        if (outputConfig == null) {
            outputConfig = this.defaultOutputConfig;
        }
        TAVCompositionBuilder tAVCompositionBuilder = new TAVCompositionBuilder(tAVComposition);
        tAVCompositionBuilder.setVideoTracksMerge(false);
        TAVSource buildSource = tAVCompositionBuilder.buildSource();
        Asset asset = buildSource.getAsset();
        this.exportSession = new AssetExportSession(asset, outputConfig);
        this.exportSession.setTimeRange(new CMTimeRange(CMTime.CMTimeZero, asset.getDuration()));
        this.exportSession.setAudioMix(buildSource.getAudioMix());
        Logger.i(this.TAG, "export composition duration: " + asset.getDuration());
        this.exportSession.setOutputFilePath(newOutputFile(str).getAbsolutePath());
        this.exportSession.setOutputFileType("mp4");
        this.exportSession.setVideoComposition(buildSource.getVideoComposition());
        this.exportSession.exportAsynchronouslyWithCompletionHandler(new AssetExportSession.ExportCallbackHandler() {
            /* class com.tencent.tavkit.component.TAVExporter.AnonymousClass1 */

            /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // com.tencent.tav.core.AssetExportSession.ExportCallbackHandler
            public void handlerCallback(AssetExportSession assetExportSession) {
                AppMethodBeat.i(197358);
                switch (AnonymousClass2.$SwitchMap$com$tencent$tav$core$AssetExportSession$AssetExportSessionStatus[assetExportSession.getStatus().ordinal()]) {
                    case 1:
                        if (TAVExporter.this.exportListener != null) {
                            Logger.i(TAVExporter.this.TAG, "export progress: " + assetExportSession.getProgress());
                            if (!TAVExporter.this.isExporting) {
                                TAVExporter.this.exportListener.onExportStart();
                            }
                            TAVExporter.this.exportListener.onExporting(assetExportSession.getProgress());
                        }
                        TAVExporter.this.isExporting = true;
                        AppMethodBeat.o(197358);
                        return;
                    case 2:
                        Logger.i(TAVExporter.this.TAG, "export progress finished");
                        if (TAVExporter.this.exportListener != null) {
                            TAVExporter.this.exportListener.onExportCompleted(str);
                        }
                        TAVExporter.this.isExporting = false;
                        AppMethodBeat.o(197358);
                        return;
                    case 3:
                    case 4:
                        Logger.i(TAVExporter.this.TAG, "export error");
                        if (TAVExporter.this.exportListener != null) {
                            TAVExporter.this.exportListener.onExportError(assetExportSession.getErrCode(), assetExportSession.getThrowable());
                        }
                        TAVExporter.this.isExporting = false;
                        AppMethodBeat.o(197358);
                        return;
                    case 5:
                        Logger.i(TAVExporter.this.TAG, "export cancel");
                        if (TAVExporter.this.exportListener != null && TAVExporter.this.isCanceled) {
                            TAVExporter.this.isCanceled = false;
                            TAVExporter.this.exportListener.onExportCancel();
                        }
                        TAVExporter.this.isExporting = false;
                        break;
                }
                AppMethodBeat.o(197358);
            }
        });
        AppMethodBeat.o(197361);
    }

    /* renamed from: com.tencent.tavkit.component.TAVExporter$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$tencent$tav$core$AssetExportSession$AssetExportSessionStatus = new int[AssetExportSession.AssetExportSessionStatus.values().length];

        static {
            AppMethodBeat.i(197359);
            try {
                $SwitchMap$com$tencent$tav$core$AssetExportSession$AssetExportSessionStatus[AssetExportSession.AssetExportSessionStatus.AssetExportSessionStatusExporting.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$tencent$tav$core$AssetExportSession$AssetExportSessionStatus[AssetExportSession.AssetExportSessionStatus.AssetExportSessionStatusCompleted.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$tencent$tav$core$AssetExportSession$AssetExportSessionStatus[AssetExportSession.AssetExportSessionStatus.AssetExportSessionStatusFailed.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$tencent$tav$core$AssetExportSession$AssetExportSessionStatus[AssetExportSession.AssetExportSessionStatus.AssetExportSessionStatusUnknown.ordinal()] = 4;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$com$tencent$tav$core$AssetExportSession$AssetExportSessionStatus[AssetExportSession.AssetExportSessionStatus.AssetExportSessionStatusCancelled.ordinal()] = 5;
                AppMethodBeat.o(197359);
            } catch (NoSuchFieldError e6) {
                AppMethodBeat.o(197359);
            }
        }
    }

    public void export(TAVComposition tAVComposition, String str) {
        AppMethodBeat.i(197362);
        export(tAVComposition, str, this.defaultOutputConfig);
        AppMethodBeat.o(197362);
    }

    public void cancelExport() {
        AppMethodBeat.i(197363);
        if (this.exportSession != null) {
            this.isCanceled = true;
            this.exportSession.cancelExport();
        }
        this.isExporting = false;
        AppMethodBeat.o(197363);
    }

    public boolean isExporting() {
        return this.isExporting;
    }

    public void setOutputConfig(EncoderWriter.OutputConfig outputConfig) {
        this.defaultOutputConfig = outputConfig;
    }

    public void setExportListener(ExportListener exportListener2) {
        this.exportListener = exportListener2;
    }

    private File newOutputFile(String str) {
        AppMethodBeat.i(197364);
        File file = new File(str);
        if (file.exists()) {
            AppMethodBeat.o(197364);
        } else {
            try {
                if (!file.createNewFile()) {
                    RuntimeException runtimeException = new RuntimeException("创建输出文件失败");
                    AppMethodBeat.o(197364);
                    throw runtimeException;
                }
                AppMethodBeat.o(197364);
            } catch (IOException e2) {
                Logger.e(this.TAG, "export: ", e2);
                RuntimeException runtimeException2 = new RuntimeException("创建输出文件失败", e2);
                AppMethodBeat.o(197364);
                throw runtimeException2;
            }
        }
        return file;
    }
}
