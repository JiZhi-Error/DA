package com.tencent.tav.core;

import android.os.Build;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import com.tencent.tav.asset.MetadataItem;
import com.tencent.tav.core.AssetWriterInput;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.decoder.AssetWriterVideoEncoder;
import com.tencent.tav.decoder.CodecHelper;
import com.tencent.tav.decoder.EncoderWriter;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tav.decoder.RenderContextParams;
import com.tencent.tav.decoder.logger.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class AssetWriter implements AssetWriterInput.StatusListener, IContextCreate {
    public static final int MAX_BIT_RATE = 8000000;
    private static final String TAG = "AssetWriter";
    private List<Integer> availableMediaTypes;
    private String directoryForTemporaryFiles;
    private ExportConfig encodeOption;
    private EncoderWriter encoderWriter;
    private CMTime endTime = new CMTime((long) MAlarmHandler.NEXT_FIRE_INTERVAL);
    private int errCode;
    private HashMap<AssetWriterInput, AssetWriterStatus> inputStatusHashMap = new HashMap<>();
    private List<AssetWriterInput> inputs = new ArrayList();
    private List<MetadataItem> metadata;
    private String outputFileType;
    private Surface rendSurface;
    private RenderContext renderContext;
    private RenderContextParams renderContextParams;
    private boolean shouldOptimizeForNetworkUse;
    private CMTime startTime = new CMTime(0L);
    private AssetWriterStatus status;
    private String videoOutputPath;

    /* access modifiers changed from: package-private */
    public enum AssetWriterStatus {
        AssetWriterStatusUnknown,
        AssetWriterStatusWriting,
        AssetWriterStatusCompleted,
        AssetWriterStatusFailed,
        AssetWriterStatusCancelled;

        public static AssetWriterStatus valueOf(String str) {
            AppMethodBeat.i(217789);
            AssetWriterStatus assetWriterStatus = (AssetWriterStatus) Enum.valueOf(AssetWriterStatus.class, str);
            AppMethodBeat.o(217789);
            return assetWriterStatus;
        }

        static {
            AppMethodBeat.i(217790);
            AppMethodBeat.o(217790);
        }
    }

    public String getVideoOutputPath() {
        return this.videoOutputPath;
    }

    public String getOutputFileType() {
        return this.outputFileType;
    }

    public List<Integer> getAvailableMediaTypes() {
        return this.availableMediaTypes;
    }

    public AssetWriterStatus getStatus() {
        return this.status;
    }

    public int getErrCode() {
        return this.errCode;
    }

    public List<MetadataItem> getMetadata() {
        return this.metadata;
    }

    public void setMetadata(List<MetadataItem> list) {
        this.metadata = list;
    }

    public boolean isShouldOptimizeForNetworkUse() {
        return this.shouldOptimizeForNetworkUse;
    }

    public void setShouldOptimizeForNetworkUse(boolean z) {
        this.shouldOptimizeForNetworkUse = z;
    }

    public String getDirectoryForTemporaryFiles() {
        return this.directoryForTemporaryFiles;
    }

    public void setDirectoryForTemporaryFiles(String str) {
        this.directoryForTemporaryFiles = str;
    }

    public List<AssetWriterInput> getInputs() {
        return this.inputs;
    }

    public RenderContextParams getRenderContextParams() {
        return this.renderContextParams;
    }

    public void setRenderContextParams(RenderContextParams renderContextParams2) {
        AppMethodBeat.i(217791);
        this.renderContextParams = renderContextParams2;
        if (this.renderContext != null) {
            this.renderContext.setParams(renderContextParams2);
        }
        AppMethodBeat.o(217791);
    }

    public AssetWriter(String str, String str2) {
        AppMethodBeat.i(217792);
        this.videoOutputPath = str;
        this.outputFileType = str2;
        AppMethodBeat.o(217792);
    }

    public boolean canApplyOutputSettings(HashMap<String, Object> hashMap, int i2) {
        int i3;
        int i4;
        int i5 = 2;
        int i6 = -1;
        AppMethodBeat.i(217793);
        if (i2 == 1) {
            String str = hashMap.containsKey("mime") ? (String) hashMap.get("mime") : "video/avc";
            if (hashMap.containsKey("width")) {
                i4 = ((Integer) hashMap.get("width")).intValue();
            } else {
                i4 = -1;
            }
            if (hashMap.containsKey("height")) {
                i6 = ((Integer) hashMap.get("height")).intValue();
            }
            int intValue = hashMap.containsKey("frame-rate") ? ((Integer) hashMap.get("frame-rate")).intValue() : 30;
            int intValue2 = hashMap.containsKey(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE) ? ((Integer) hashMap.get(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE)).intValue() : 8000000;
            if (Build.VERSION.SDK_INT >= 21) {
                boolean checkVideoOutSupported = CodecHelper.checkVideoOutSupported(i4, i6, intValue, intValue2, str);
                AppMethodBeat.o(217793);
                return checkVideoOutSupported;
            } else if (i4 <= 0 || i6 <= 0) {
                AppMethodBeat.o(217793);
                return false;
            } else {
                AppMethodBeat.o(217793);
                return true;
            }
        } else if (i2 == 2) {
            String str2 = hashMap.containsKey("mime") ? (String) hashMap.get("mime") : EncoderWriter.OUTPUT_AUDIO_MIME_TYPE;
            if (hashMap.containsKey("aac-profile")) {
                i5 = ((Integer) hashMap.get("aac-profile")).intValue();
            }
            int intValue3 = hashMap.containsKey(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE) ? ((Integer) hashMap.get(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE)).intValue() : 8000000;
            if (hashMap.containsKey("channel-count")) {
                i3 = ((Integer) hashMap.get("channel-count")).intValue();
            } else {
                i3 = 1;
            }
            int intValue4 = hashMap.containsKey("sample-rate") ? ((Integer) hashMap.get("sample-rate")).intValue() : 44100;
            if (Build.VERSION.SDK_INT >= 21) {
                boolean checkAudioOutSupported = CodecHelper.checkAudioOutSupported(intValue3, i3, intValue4, str2);
                AppMethodBeat.o(217793);
                return checkAudioOutSupported;
            } else if (i5 <= 0 || intValue3 <= 0 || i3 <= 0 || intValue4 <= 0) {
                AppMethodBeat.o(217793);
                return false;
            } else {
                AppMethodBeat.o(217793);
                return true;
            }
        } else {
            AppMethodBeat.o(217793);
            return false;
        }
    }

    public boolean canAddInput(AssetWriterInput assetWriterInput) {
        AppMethodBeat.i(217794);
        for (AssetWriterInput assetWriterInput2 : this.inputs) {
            if (assetWriterInput2.getMediaType() == assetWriterInput.getMediaType()) {
                AppMethodBeat.o(217794);
                return false;
            }
        }
        AppMethodBeat.o(217794);
        return true;
    }

    public void addInput(AssetWriterInput assetWriterInput) {
        AppMethodBeat.i(217795);
        if (canAddInput(assetWriterInput)) {
            this.inputs.add(assetWriterInput);
            assetWriterInput.addStatusListener(this);
        }
        AppMethodBeat.o(217795);
    }

    public void setEncodeOption(ExportConfig exportConfig) {
        this.encodeOption = exportConfig;
    }

    public boolean startWriting(AssetWriterVideoEncoder assetWriterVideoEncoder) {
        AppMethodBeat.i(217796);
        if (this.videoOutputPath == null) {
            AppMethodBeat.o(217796);
            return false;
        }
        cancelWriting();
        try {
            this.encoderWriter = new EncoderWriter(this.videoOutputPath, assetWriterVideoEncoder);
            this.encoderWriter.setEncodeOption(this.encodeOption);
            for (AssetWriterInput assetWriterInput : this.inputs) {
                assetWriterInput.initConfig(this);
            }
            AppMethodBeat.o(217796);
            return true;
        } catch (Exception e2) {
            Logger.e(TAG, "startWriting", e2);
            this.inputStatusHashMap.clear();
            if (this.encoderWriter != null) {
                this.encoderWriter.stop();
                this.encoderWriter = null;
            }
            AppMethodBeat.o(217796);
            return false;
        }
    }

    public EncoderWriter encoderWriter() {
        return this.encoderWriter;
    }

    public void cancelWriting() {
        AppMethodBeat.i(217797);
        if (this.encoderWriter != null) {
            this.encoderWriter.stop();
            this.encoderWriter = null;
        }
        for (AssetWriterInput assetWriterInput : this.inputs) {
            this.inputStatusHashMap.put(assetWriterInput, AssetWriterStatus.AssetWriterStatusCancelled);
        }
        this.status = AssetWriterStatus.AssetWriterStatusCancelled;
        AppMethodBeat.o(217797);
    }

    public boolean finishWriting() {
        AppMethodBeat.i(217798);
        if (this.encoderWriter != null) {
            this.encoderWriter.stop();
            this.encoderWriter = null;
        }
        this.status = AssetWriterStatus.AssetWriterStatusCompleted;
        if (this.renderContext != null) {
            this.renderContext.release();
            this.renderContext = null;
        }
        if (this.rendSurface != null) {
            this.rendSurface.release();
            this.rendSurface = null;
        }
        AppMethodBeat.o(217798);
        return true;
    }

    public void startSessionAtSourceTime(CMTime cMTime) {
        this.startTime = cMTime;
    }

    public void endSessionAtSourceTime(CMTime cMTime) {
        this.endTime = cMTime;
    }

    public Surface createInputSurface() {
        AppMethodBeat.i(217799);
        if (this.encoderWriter != null) {
            Surface createInputSurface = this.encoderWriter.createInputSurface();
            AppMethodBeat.o(217799);
            return createInputSurface;
        }
        AppMethodBeat.o(217799);
        return null;
    }

    @Override // com.tencent.tav.core.IContextCreate
    public RenderContext renderContext() {
        AppMethodBeat.i(217800);
        if (this.renderContext == null && this.encoderWriter != null) {
            this.rendSurface = this.encoderWriter.createInputSurface();
            this.renderContext = new RenderContext(this.encoderWriter.getOutWidth(), this.encoderWriter.getOutHeight(), this.rendSurface);
            this.renderContext.setParams(this.renderContextParams);
        }
        RenderContext renderContext2 = this.renderContext;
        AppMethodBeat.o(217800);
        return renderContext2;
    }

    private void updateAssetStatus() {
        AppMethodBeat.i(217801);
        boolean z = true;
        for (AssetWriterInput assetWriterInput : this.inputs) {
            z = (this.inputStatusHashMap.get(assetWriterInput) == AssetWriterStatus.AssetWriterStatusCompleted) & z;
        }
        if (z) {
            this.status = AssetWriterStatus.AssetWriterStatusCancelled;
            AppMethodBeat.o(217801);
            return;
        }
        boolean z2 = true;
        for (AssetWriterInput assetWriterInput2 : this.inputs) {
            z2 = (this.inputStatusHashMap.get(assetWriterInput2) == AssetWriterStatus.AssetWriterStatusWriting || this.inputStatusHashMap.get(assetWriterInput2) == AssetWriterStatus.AssetWriterStatusCompleted) & z2;
        }
        if (z2) {
            this.status = AssetWriterStatus.AssetWriterStatusWriting;
            AppMethodBeat.o(217801);
            return;
        }
        for (AssetWriterInput assetWriterInput3 : this.inputs) {
            if (this.inputStatusHashMap.get(assetWriterInput3) == AssetWriterStatus.AssetWriterStatusFailed) {
                this.status = AssetWriterStatus.AssetWriterStatusFailed;
                AppMethodBeat.o(217801);
                return;
            }
        }
        for (AssetWriterInput assetWriterInput4 : this.inputs) {
            if (this.inputStatusHashMap.get(assetWriterInput4) == AssetWriterStatus.AssetWriterStatusCancelled) {
                this.status = AssetWriterStatus.AssetWriterStatusCancelled;
                AppMethodBeat.o(217801);
                return;
            }
        }
        AppMethodBeat.o(217801);
    }

    @Override // com.tencent.tav.core.AssetWriterInput.StatusListener
    public void statusChanged(AssetWriterInput assetWriterInput, AssetWriterStatus assetWriterStatus) {
        AppMethodBeat.i(217802);
        this.inputStatusHashMap.put(assetWriterInput, assetWriterStatus);
        AssetWriterStatus assetWriterStatus2 = this.status;
        updateAssetStatus();
        if (assetWriterStatus2 != this.status && this.status == AssetWriterStatus.AssetWriterStatusWriting) {
            Iterator<AssetWriterInput> it = this.inputs.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
        AppMethodBeat.o(217802);
    }
}
