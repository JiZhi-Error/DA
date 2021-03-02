package com.tencent.rtmp;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public class TXLivePlayConfig {
    boolean mAutoAdjustCacheTime = true;
    boolean mAutoRotate = true;
    String mCacheFolderPath;
    float mCacheTime = 5.0f;
    int mConnectRetryCount = 3;
    int mConnectRetryInterval = 3;
    boolean mEnableAec = false;
    boolean mEnableMessage = false;
    boolean mEnableMetaData = false;
    boolean mEnableNearestIP = true;
    String mFlvSessionKey = "";
    protected Map<String, String> mHeaders;
    float mMaxAutoAdjustCacheTime = 5.0f;
    int mMaxCacheItems;
    float mMinAutoAdjustCacheTime = 1.0f;
    int mRtmpChannelType = 0;
    int mVideoBlockThreshold = 800;

    public void setAutoAdjustCacheTime(boolean z) {
        this.mAutoAdjustCacheTime = z;
    }

    public void setCacheTime(float f2) {
        this.mCacheTime = f2;
    }

    public void setMaxAutoAdjustCacheTime(float f2) {
        this.mMaxAutoAdjustCacheTime = f2;
    }

    public void setMinAutoAdjustCacheTime(float f2) {
        this.mMinAutoAdjustCacheTime = f2;
    }

    public void setVideoBlockThreshold(int i2) {
        this.mVideoBlockThreshold = i2;
    }

    public void setConnectRetryCount(int i2) {
        this.mConnectRetryCount = i2;
    }

    public void setConnectRetryInterval(int i2) {
        this.mConnectRetryInterval = i2;
    }

    public void setEnableMessage(boolean z) {
        this.mEnableMessage = z;
    }

    public void enableAEC(boolean z) {
        this.mEnableAec = z;
    }

    public void setEnableMetaData(boolean z) {
        this.mEnableMetaData = z;
    }

    public void setFlvSessionKey(String str) {
        this.mFlvSessionKey = str;
    }

    @Deprecated
    public void setEnableNearestIP(boolean z) {
        this.mEnableNearestIP = z;
    }

    @Deprecated
    public void setRtmpChannelType(int i2) {
        this.mRtmpChannelType = i2;
    }

    @Deprecated
    public void setCacheFolderPath(String str) {
        this.mCacheFolderPath = str;
    }

    @Deprecated
    public void setMaxCacheItems(int i2) {
        this.mMaxCacheItems = i2;
    }

    @Deprecated
    public void setHeaders(Map<String, String> map) {
        this.mHeaders = map;
    }

    public String toString() {
        AppMethodBeat.i(259979);
        String str = "{mCacheTime=" + this.mCacheTime + ", mMaxAutoAdjustCacheTime=" + this.mMaxAutoAdjustCacheTime + ", mMinAutoAdjustCacheTime=" + this.mMinAutoAdjustCacheTime + ", mVideoBlockThreshold=" + this.mVideoBlockThreshold + ", mConnectRetryCount=" + this.mConnectRetryCount + ", mConnectRetryInterval=" + this.mConnectRetryInterval + ", mAutoAdjustCacheTime=" + this.mAutoAdjustCacheTime + ", mEnableAec=" + this.mEnableAec + ", mEnableNearestIP=" + this.mEnableNearestIP + ", mEnableMessage=" + this.mEnableMessage + ", mEnableMetaData=" + this.mEnableMetaData + ", mRtmpChannelType=" + this.mRtmpChannelType + '}';
        AppMethodBeat.o(259979);
        return str;
    }
}
