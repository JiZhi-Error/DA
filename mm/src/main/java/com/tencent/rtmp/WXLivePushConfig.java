package com.tencent.rtmp;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class WXLivePushConfig extends TXLivePushConfig {
    public int mVideoEncodeHeight = 640;
    public int mVideoEncodeWidth = 368;

    public WXLivePushConfig() {
        this.mTouchFocus = false;
    }

    public void setVideoResolution(int i2, int i3) {
        this.mVideoEncodeWidth = i2;
        this.mVideoEncodeHeight = i3;
    }

    public WXLivePushConfig clone() {
        AppMethodBeat.i(13939);
        WXLivePushConfig wXLivePushConfig = new WXLivePushConfig();
        wXLivePushConfig.mVideoEncodeWidth = this.mVideoEncodeWidth;
        wXLivePushConfig.mVideoEncodeHeight = this.mVideoEncodeHeight;
        wXLivePushConfig.mHomeOrientation = this.mHomeOrientation;
        wXLivePushConfig.mFrontCamera = this.mFrontCamera;
        wXLivePushConfig.mTouchFocus = this.mTouchFocus;
        wXLivePushConfig.mEnableZoom = this.mEnableZoom;
        wXLivePushConfig.mMinVideoBitrate = this.mMinVideoBitrate;
        wXLivePushConfig.mMaxVideoBitrate = this.mMaxVideoBitrate;
        wXLivePushConfig.mVideoBitrate = this.mVideoBitrate;
        wXLivePushConfig.mVideoFPS = this.mVideoFPS;
        wXLivePushConfig.mVideoResolution = this.mVideoResolution;
        wXLivePushConfig.mVideoEncodeGop = this.mVideoEncodeGop;
        wXLivePushConfig.mVideoEncoderXMirror = this.mVideoEncoderXMirror;
        wXLivePushConfig.mHardwareAccel = this.mHardwareAccel;
        wXLivePushConfig.mAudioSample = this.mAudioSample;
        wXLivePushConfig.mAudioChannels = this.mAudioChannels;
        wXLivePushConfig.mAudioBitrate = this.mAudioBitrate;
        wXLivePushConfig.mEnableAec = this.mEnableAec;
        wXLivePushConfig.mEnableAgc = this.mEnableAgc;
        wXLivePushConfig.mEnableAns = this.mEnableAns;
        wXLivePushConfig.mVolumeType = this.mVolumeType;
        wXLivePushConfig.mPauseFlag = this.mPauseFlag;
        wXLivePushConfig.mHomeOrientation = this.mHomeOrientation;
        wXLivePushConfig.mLocalVideoMirrorType = this.mLocalVideoMirrorType;
        wXLivePushConfig.mEnableAudioPreview = this.mEnableAudioPreview;
        AppMethodBeat.o(13939);
        return wXLivePushConfig;
    }
}
