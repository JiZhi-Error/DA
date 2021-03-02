package com.tencent.rtmp;

import android.graphics.Bitmap;
import com.tencent.liteav.basic.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public class TXLivePushConfig {
    public static final int DEFAULT_MAX_VIDEO_BITRATE = 1200;
    public static final int DEFAULT_MIN_VIDEO_BITRATE = 800;
    int mAudioBitrate;
    int mAudioChannels = 1;
    String mAudioPreProcessFuncName;
    String mAudioPreProcessLibrary;
    int mAudioSample = 48000;
    boolean mAutoAdjustBitrate = false;
    int mAutoAdjustStrategy = 0;
    int mBeautyLevel = 0;
    int mConnectRetryCount = 3;
    int mConnectRetryInterval = 3;
    int mCustomModeType = 0;
    boolean mEnableAec = false;
    boolean mEnableAgc = false;
    boolean mEnableAns = false;
    boolean mEnableAudioPreview = false;
    boolean mEnableHighResolutionCapture = true;
    boolean mEnableNearestIP = true;
    boolean mEnablePureAudioPush = false;
    boolean mEnableScreenCaptureAutoRotate = false;
    boolean mEnableVideoHardEncoderMainProfile = true;
    boolean mEnableZoom = false;
    int mEyeScaleLevel = 0;
    int mFaceSlimLevel = 0;
    boolean mFrontCamera = true;
    int mHardwareAccel = 2;
    int mHomeOrientation = 1;
    int mLocalVideoMirrorType = 0;
    int mMaxVideoBitrate = 1500;
    HashMap<String, String> mMetaData;
    int mMinVideoBitrate = 800;
    int mPauseFlag = 1;
    int mPauseFps = 5;
    Bitmap mPauseImg = null;
    int mPauseTime = 300;
    int mRtmpChannelType = 0;
    int mRuddyLevel = 0;
    boolean mTouchFocus = true;
    int mVideoBitrate = 1200;
    int mVideoEncodeGop = 3;
    boolean mVideoEncoderXMirror = false;
    int mVideoFPS = 20;
    String mVideoPreProcessFuncName;
    String mVideoPreProcessLibrary;
    c mVideoResolution = c.RESOLUTION_TYPE_540_960;
    int mVolumeType = 0;
    Bitmap mWatermark;
    float mWatermarkWidth = -1.0f;
    int mWatermarkX = 0;
    float mWatermarkXF = 0.0f;
    int mWatermarkY = 0;
    float mWatermarkYF = 0.0f;
    int mWhiteningLevel = 0;

    public void setHomeOrientation(int i2) {
        this.mHomeOrientation = i2;
    }

    public void setTouchFocus(boolean z) {
        this.mTouchFocus = z;
    }

    public void setEnableZoom(boolean z) {
        this.mEnableZoom = z;
    }

    public void setWatermark(Bitmap bitmap, int i2, int i3) {
        this.mWatermark = bitmap;
        this.mWatermarkX = i2;
        this.mWatermarkY = i3;
    }

    public void setWatermark(Bitmap bitmap, float f2, float f3, float f4) {
        this.mWatermark = bitmap;
        this.mWatermarkXF = f2;
        this.mWatermarkYF = f3;
        this.mWatermarkWidth = f4;
    }

    public void setLocalVideoMirrorType(int i2) {
        this.mLocalVideoMirrorType = i2;
    }

    public void setPauseImg(Bitmap bitmap) {
        this.mPauseImg = bitmap;
    }

    public void setPauseImg(int i2, int i3) {
        this.mPauseTime = i2;
        this.mPauseFps = i3;
    }

    public void setPauseFlag(int i2) {
        this.mPauseFlag = i2;
    }

    public void setVideoResolution(int i2) {
        switch (i2) {
            case 0:
                this.mVideoResolution = c.RESOLUTION_TYPE_360_640;
                return;
            case 1:
                this.mVideoResolution = c.RESOLUTION_TYPE_540_960;
                return;
            case 2:
                this.mVideoResolution = c.RESOLUTION_TYPE_720_1280;
                return;
            case 3:
                this.mVideoResolution = c.RESOLUTION_TYPE_640_360;
                return;
            case 4:
                this.mVideoResolution = c.RESOLUTION_TYPE_960_540;
                return;
            case 5:
                this.mVideoResolution = c.RESOLUTION_TYPE_1280_720;
                return;
            case 6:
                this.mVideoResolution = c.RESOLUTION_TYPE_320_480;
                return;
            case 7:
                this.mVideoResolution = c.RESOLUTION_TYPE_180_320;
                return;
            case 8:
                this.mVideoResolution = c.RESOLUTION_TYPE_270_480;
                return;
            case 9:
                this.mVideoResolution = c.RESOLUTION_TYPE_320_180;
                return;
            case 10:
                this.mVideoResolution = c.RESOLUTION_TYPE_480_270;
                return;
            case 11:
                this.mVideoResolution = c.RESOLUTION_TYPE_240_320;
                return;
            case 12:
                this.mVideoResolution = c.RESOLUTION_TYPE_360_480;
                return;
            case 13:
                this.mVideoResolution = c.RESOLUTION_TYPE_480_640;
                return;
            case 14:
                this.mVideoResolution = c.RESOLUTION_TYPE_320_240;
                return;
            case 15:
                this.mVideoResolution = c.RESOLUTION_TYPE_480_360;
                return;
            case 16:
                this.mVideoResolution = c.RESOLUTION_TYPE_640_480;
                return;
            case 17:
                this.mVideoResolution = c.RESOLUTION_TYPE_480_480;
                return;
            case 18:
                this.mVideoResolution = c.RESOLUTION_TYPE_270_270;
                return;
            case 19:
                this.mVideoResolution = c.RESOLUTION_TYPE_160_160;
                return;
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            default:
                return;
            case 30:
                this.mVideoResolution = c.RESOLUTION_TYPE_1080_1920;
                return;
            case 31:
                this.mVideoResolution = c.RESOLUTION_TYPE_1920_1080;
                return;
        }
    }

    public void setVideoFPS(int i2) {
        this.mVideoFPS = i2;
    }

    public void setVideoEncodeGop(int i2) {
        this.mVideoEncodeGop = i2;
    }

    public void setVideoBitrate(int i2) {
        this.mVideoBitrate = i2;
    }

    public void setMaxVideoBitrate(int i2) {
        this.mMaxVideoBitrate = i2;
    }

    public void setMinVideoBitrate(int i2) {
        this.mMinVideoBitrate = i2;
    }

    public void setAutoAdjustBitrate(boolean z) {
        this.mAutoAdjustBitrate = z;
    }

    public void setAutoAdjustStrategy(int i2) {
        this.mAutoAdjustStrategy = i2;
    }

    public void setAudioSampleRate(int i2) {
        this.mAudioSample = i2;
    }

    public void setAudioChannels(int i2) {
        this.mAudioChannels = i2;
    }

    public void enablePureAudioPush(boolean z) {
        this.mEnablePureAudioPush = z;
    }

    public void enableScreenCaptureAutoRotate(boolean z) {
        this.mEnableScreenCaptureAutoRotate = z;
    }

    public void enableHighResolutionCaptureMode(boolean z) {
        this.mEnableHighResolutionCapture = z;
    }

    public void setVideoEncoderXMirror(boolean z) {
        this.mVideoEncoderXMirror = z;
    }

    public void enableAudioEarMonitoring(boolean z) {
        this.mEnableAudioPreview = z;
    }

    public void setConnectRetryCount(int i2) {
        this.mConnectRetryCount = i2;
    }

    public void setConnectRetryInterval(int i2) {
        this.mConnectRetryInterval = i2;
    }

    public void setCustomModeType(int i2) {
        this.mCustomModeType = i2;
    }

    public void enableAEC(boolean z) {
        this.mEnableAec = z;
    }

    public void enableAGC(boolean z) {
        this.mEnableAgc = z;
    }

    public void enableANS(boolean z) {
        this.mEnableAns = z;
    }

    public void setVolumeType(int i2) {
        this.mVolumeType = i2;
    }

    public void setHardwareAcceleration(int i2) {
        int i3;
        int i4 = 2;
        if (i2 < 0) {
            i3 = 2;
        } else {
            i3 = i2;
        }
        if (i3 <= 2) {
            i4 = i3;
        }
        this.mHardwareAccel = i4;
    }

    public void enableVideoHardEncoderMainProfile(boolean z) {
        this.mEnableVideoHardEncoderMainProfile = z;
    }

    public void setMetaData(HashMap<String, String> hashMap) {
        this.mMetaData = hashMap;
    }

    @Deprecated
    public void setFrontCamera(boolean z) {
        this.mFrontCamera = z;
    }

    @Deprecated
    public void setBeautyFilter(int i2, int i3, int i4) {
        this.mBeautyLevel = i2;
        this.mWhiteningLevel = i3;
        this.mRuddyLevel = i4;
    }

    @Deprecated
    public void setEyeScaleLevel(int i2) {
        this.mEyeScaleLevel = i2;
    }

    @Deprecated
    public void setFaceSlimLevel(int i2) {
        this.mFaceSlimLevel = i2;
    }

    @Deprecated
    public void setRtmpChannelType(int i2) {
        this.mRtmpChannelType = i2;
    }

    @Deprecated
    public void enableNearestIP(boolean z) {
        this.mEnableNearestIP = z;
    }

    public void setCustomVideoPreProcessLibrary(String str, String str2) {
        this.mVideoPreProcessLibrary = str;
        this.mVideoPreProcessFuncName = str2;
    }

    public void setCustomAudioPreProcessLibrary(String str, String str2) {
        this.mAudioPreProcessLibrary = str;
        this.mAudioPreProcessFuncName = str2;
    }

    public String toString() {
        AppMethodBeat.i(259978);
        String str = "{mCustomModeType=" + this.mCustomModeType + ", mAudioSample=" + this.mAudioSample + ", mAudioBitrate=" + this.mAudioBitrate + ", mAudioChannels=" + this.mAudioChannels + ", mVideoFPS=" + this.mVideoFPS + ", mVideoResolution=" + this.mVideoResolution + ", mVideoBitrate=" + this.mVideoBitrate + ", mMaxVideoBitrate=" + this.mMaxVideoBitrate + ", mMinVideoBitrate=" + this.mMinVideoBitrate + ", mConnectRetryCount=" + this.mConnectRetryCount + ", mConnectRetryInterval=" + this.mConnectRetryInterval + ", mVideoEncodeGop=" + this.mVideoEncodeGop + ", mVideoEncoderXMirror=" + this.mVideoEncoderXMirror + ", mEnableHighResolutionCapture=" + this.mEnableHighResolutionCapture + ", mEnableVideoHardEncoderMainProfile=" + this.mEnableVideoHardEncoderMainProfile + ", mFrontCamera=" + this.mFrontCamera + ", mAutoAdjustBitrate=" + this.mAutoAdjustBitrate + ", mAutoAdjustStrategy=" + this.mAutoAdjustStrategy + ", mHardwareAccel=" + this.mHardwareAccel + ", mTouchFocus=" + this.mTouchFocus + ", mEnableZoom=" + this.mEnableZoom + ", mHomeOrientation=" + this.mHomeOrientation + ", mEnableAec=" + this.mEnableAec + ", mEnableAgc=" + this.mEnableAgc + ", mEnableAns=" + this.mEnableAns + ", mEnableAudioPreview=" + this.mEnableAudioPreview + ", mEnableScreenCaptureAutoRotate=" + this.mEnableScreenCaptureAutoRotate + ", mEnablePureAudioPush=" + this.mEnablePureAudioPush + ", mEnableNearestIP=" + this.mEnableNearestIP + ", mVolumeType=" + this.mVolumeType + ", mLocalVideoMirrorType=" + this.mLocalVideoMirrorType + ", mRtmpChannelType=" + this.mRtmpChannelType + '}';
        AppMethodBeat.o(259978);
        return str;
    }
}
