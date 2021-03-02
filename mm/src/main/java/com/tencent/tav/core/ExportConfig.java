package com.tencent.tav.core;

import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.decoder.CodecHelper;
import com.tencent.tav.decoder.EncoderWriter;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.thumbplayer.core.common.TPDecoderType;

public class ExportConfig implements Cloneable {
    private static final String TAG = "ExportConfig";
    private int audioAacProfile = 2;
    private int audioBitRate = EncoderWriter.OUTPUT_AUDIO_BIT_RATE;
    private int audioChannelCount = 1;
    private boolean audioEncodeNeedCodecSpecificData = true;
    private MediaFormat audioFormat;
    private int audioSampleRateHz = 44100;
    private boolean highProfile = false;
    private String outputFilePath;
    private int outputHeight;
    private int outputWidth;
    private int videoBitRate = 8000000;
    private MediaFormat videoFormat;
    private int videoFrameRate = 30;
    private int videoIFrameInterval = 1;
    private String videoMimeType = "video/avc";

    public ExportConfig(int i2, int i3) {
        this.outputWidth = i2;
        this.outputHeight = i3;
    }

    @Deprecated
    public ExportConfig(EncoderWriter.OutputConfig outputConfig) {
        this.outputWidth = outputConfig.VIDEO_TARGET_WIDTH;
        this.outputHeight = outputConfig.VIDEO_TARGET_HEIGHT;
        this.videoIFrameInterval = outputConfig.VIDEO_IFRAME_INTERVAL;
        this.videoBitRate = outputConfig.VIDEO_BIT_RATE;
        this.videoFrameRate = outputConfig.VIDEO_FRAME_RATE;
        this.highProfile = outputConfig.HIGH_PROFILE;
        this.audioChannelCount = outputConfig.AUDIO_CHANNEL_COUNT;
        this.audioBitRate = outputConfig.AUDIO_BIT_RATE;
        this.audioAacProfile = outputConfig.AUDIO_AAC_PROFILE;
    }

    public void setOutputFilePath(String str) {
        this.outputFilePath = str;
    }

    public void setOutputSize(int i2, int i3) {
        AppMethodBeat.i(217874);
        this.outputWidth = i2;
        this.outputHeight = i3;
        initOutputSize();
        AppMethodBeat.o(217874);
    }

    public void setVideoBitRate(int i2) {
        AppMethodBeat.i(217875);
        this.videoBitRate = i2;
        initVideoBitrate();
        AppMethodBeat.o(217875);
    }

    public void setVideoFrameRate(int i2) {
        AppMethodBeat.i(217876);
        this.videoFrameRate = i2;
        initFrameRate();
        AppMethodBeat.o(217876);
    }

    public void setVideoIFrameInterval(int i2) {
        AppMethodBeat.i(217877);
        this.videoIFrameInterval = i2;
        initIFrameInterval();
        AppMethodBeat.o(217877);
    }

    public void setHighProfile(boolean z) {
        AppMethodBeat.i(217878);
        this.highProfile = z;
        initHighProfile();
        AppMethodBeat.o(217878);
    }

    public void setEncodeHevc(boolean z) {
        if (z) {
            this.videoMimeType = TPDecoderType.TP_CODEC_MIMETYPE_HEVC;
        } else {
            this.videoMimeType = "video/avc";
        }
    }

    public void setAudioChannelCount(int i2) {
        AppMethodBeat.i(217879);
        this.audioChannelCount = i2;
        initAudioChannelCount();
        AppMethodBeat.o(217879);
    }

    public void setAudioSampleRateHz(int i2) {
        AppMethodBeat.i(217880);
        this.audioSampleRateHz = i2;
        initAudioSampleRate();
        AppMethodBeat.o(217880);
    }

    public void setAudioEncodeNeedCodecSpecificData(boolean z) {
        AppMethodBeat.i(217881);
        Logger.i(TAG, "setAudioEncodeNeedCodecSpecificData:".concat(String.valueOf(z)));
        this.audioEncodeNeedCodecSpecificData = z;
        AppMethodBeat.o(217881);
    }

    public boolean isAudioEncodeNeedCodecSpecificData() {
        return this.audioEncodeNeedCodecSpecificData;
    }

    public void setAudioBitRate(int i2) {
        this.audioBitRate = i2;
    }

    public String getOutputFilePath() {
        return this.outputFilePath;
    }

    public boolean available() {
        AppMethodBeat.i(217882);
        if (getOutputWidth() <= 0 || getOutputHeight() <= 0) {
            AppMethodBeat.o(217882);
            return false;
        }
        AppMethodBeat.o(217882);
        return true;
    }

    public int getOutputWidth() {
        AppMethodBeat.i(217883);
        int findVideoFormatValue = findVideoFormatValue("width", this.outputWidth);
        AppMethodBeat.o(217883);
        return findVideoFormatValue;
    }

    public int getOutputHeight() {
        AppMethodBeat.i(217884);
        int findVideoFormatValue = findVideoFormatValue("height", this.outputHeight);
        AppMethodBeat.o(217884);
        return findVideoFormatValue;
    }

    public CGSize getOutputSize() {
        AppMethodBeat.i(217885);
        CGSize cGSize = new CGSize((float) getOutputWidth(), (float) getOutputHeight());
        AppMethodBeat.o(217885);
        return cGSize;
    }

    public int getVideoBitRate() {
        AppMethodBeat.i(217886);
        int findVideoFormatValue = findVideoFormatValue(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, this.videoBitRate);
        AppMethodBeat.o(217886);
        return findVideoFormatValue;
    }

    public int getVideoFrameRate() {
        AppMethodBeat.i(217887);
        int findVideoFormatValue = findVideoFormatValue("frame-rate", this.videoFrameRate);
        AppMethodBeat.o(217887);
        return findVideoFormatValue;
    }

    public int getAudioChannelCount() {
        AppMethodBeat.i(217888);
        int findFormatValue = findFormatValue("channel-count", this.audioChannelCount, this.audioFormat);
        AppMethodBeat.o(217888);
        return findFormatValue;
    }

    public int getAudioSampleRateHz() {
        AppMethodBeat.i(217889);
        int findFormatValue = findFormatValue("sample-rate", this.audioSampleRateHz, this.audioFormat);
        AppMethodBeat.o(217889);
        return findFormatValue;
    }

    public MediaFormat getVideoFormat() {
        AppMethodBeat.i(217890);
        if (this.videoFormat == null) {
            this.videoFormat = new MediaFormat();
            this.videoFormat.setString("mime", this.videoMimeType);
            this.videoFormat.setInteger("color-format", EncoderWriter.OUTPUT_VIDEO_COLOR_FORMAT);
            initOutputSize();
            initVideoBitrate();
            initFrameRate();
            initIFrameInterval();
            initHighProfile();
        }
        MediaFormat mediaFormat = this.videoFormat;
        AppMethodBeat.o(217890);
        return mediaFormat;
    }

    public MediaFormat getAudioFormat() {
        AppMethodBeat.i(217891);
        if (this.audioFormat == null) {
            this.audioFormat = new MediaFormat();
            this.audioFormat.setString("mime", EncoderWriter.OUTPUT_AUDIO_MIME_TYPE);
            this.audioFormat.setInteger("sample-rate", this.audioSampleRateHz);
            initAudioChannelCount();
            this.audioFormat.setInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, this.audioBitRate);
            this.audioFormat.setInteger("aac-profile", this.audioAacProfile);
        }
        Logger.i(TAG, "getAudioFormat:" + this.audioFormat);
        MediaFormat mediaFormat = this.audioFormat;
        AppMethodBeat.o(217891);
        return mediaFormat;
    }

    private void initAudioChannelCount() {
        AppMethodBeat.i(217892);
        setToAudioFormat("channel-count", this.audioChannelCount);
        AppMethodBeat.o(217892);
    }

    private void initHighProfile() {
        AppMethodBeat.i(217893);
        if (this.highProfile && this.videoMimeType.equalsIgnoreCase("video/avc")) {
            CodecHelper.selectProfileAndLevel(this.videoFormat);
        }
        AppMethodBeat.o(217893);
    }

    private void initIFrameInterval() {
        AppMethodBeat.i(217894);
        setToVideoFormat("i-frame-interval", this.videoIFrameInterval);
        AppMethodBeat.o(217894);
    }

    private void initFrameRate() {
        AppMethodBeat.i(217895);
        setToVideoFormat("frame-rate", this.videoFrameRate);
        AppMethodBeat.o(217895);
    }

    private void initVideoBitrate() {
        AppMethodBeat.i(217896);
        setToVideoFormat(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, this.videoBitRate);
        AppMethodBeat.o(217896);
    }

    private void initAudioSampleRate() {
        AppMethodBeat.i(217897);
        setToAudioFormat("sample-rate", this.audioSampleRateHz);
        AppMethodBeat.o(217897);
    }

    private void initOutputSize() {
        AppMethodBeat.i(217898);
        CGSize correctSupportSize = CodecHelper.correctSupportSize(getOutputSize(), "video/avc");
        setToVideoFormat("width", (int) correctSupportSize.width);
        setToVideoFormat("height", (int) correctSupportSize.height);
        AppMethodBeat.o(217898);
    }

    private void setToVideoFormat(String str, int i2) {
        AppMethodBeat.i(217899);
        if (this.videoFormat == null) {
            getVideoFormat();
        }
        setToFormat(str, i2, this.videoFormat);
        AppMethodBeat.o(217899);
    }

    private void setToAudioFormat(String str, int i2) {
        AppMethodBeat.i(217900);
        if (this.audioFormat == null) {
            getAudioFormat();
        }
        setToFormat(str, i2, this.audioFormat);
        AppMethodBeat.o(217900);
    }

    private void setToFormat(String str, int i2, MediaFormat mediaFormat) {
        AppMethodBeat.i(217901);
        if (mediaFormat == null) {
            AppMethodBeat.o(217901);
            return;
        }
        mediaFormat.setInteger(str, i2);
        AppMethodBeat.o(217901);
    }

    private int findVideoFormatValue(String str, int i2) {
        AppMethodBeat.i(217902);
        int findFormatValue = findFormatValue(str, i2, this.videoFormat);
        AppMethodBeat.o(217902);
        return findFormatValue;
    }

    private int findFormatValue(String str, int i2, MediaFormat mediaFormat) {
        AppMethodBeat.i(217903);
        if (mediaFormat == null || !mediaFormat.containsKey(str)) {
            AppMethodBeat.o(217903);
            return i2;
        }
        int integer = mediaFormat.getInteger(str);
        AppMethodBeat.o(217903);
        return integer;
    }

    @Override // java.lang.Object
    public ExportConfig clone() {
        AppMethodBeat.i(217904);
        ExportConfig exportConfig = new ExportConfig(this.outputWidth, this.outputHeight);
        exportConfig.videoBitRate = this.videoBitRate;
        exportConfig.videoFrameRate = this.videoFrameRate;
        exportConfig.videoIFrameInterval = this.videoIFrameInterval;
        exportConfig.outputWidth = this.outputWidth;
        exportConfig.outputHeight = this.outputHeight;
        exportConfig.highProfile = this.highProfile;
        exportConfig.videoMimeType = this.videoMimeType;
        exportConfig.audioBitRate = this.audioBitRate;
        exportConfig.audioAacProfile = this.audioAacProfile;
        exportConfig.audioChannelCount = this.audioChannelCount;
        exportConfig.audioSampleRateHz = this.audioSampleRateHz;
        exportConfig.audioEncodeNeedCodecSpecificData = this.audioEncodeNeedCodecSpecificData;
        AppMethodBeat.o(217904);
        return exportConfig;
    }
}
