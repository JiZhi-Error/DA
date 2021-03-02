package com.tencent.tav.player;

import com.tencent.tav.asset.AssetTrack;

public class PlayerItemTrack {
    private AssetTrack assetTrack;
    private float currentVideoFrameRate;
    private boolean enabled = true;
    private String videoFieldMode;

    public boolean isEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean z) {
        this.enabled = z;
    }

    public float getCurrentVideoFrameRate() {
        return this.currentVideoFrameRate;
    }

    /* access modifiers changed from: package-private */
    public void setCurrentVideoFrameRate(float f2) {
        this.currentVideoFrameRate = f2;
    }

    public String getVideoFieldMode() {
        return this.videoFieldMode;
    }

    public void setVideoFieldMode(String str) {
        this.videoFieldMode = str;
    }

    public AssetTrack getAssetTrack() {
        return this.assetTrack;
    }

    /* access modifiers changed from: package-private */
    public void setAssetTrack(AssetTrack assetTrack2) {
        this.assetTrack = assetTrack2;
    }
}
