package com.tencent.tav.core;

import com.tencent.tav.core.AssetReader;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMTimeRange;
import java.util.List;

public abstract class AssetReaderOutput {
    protected boolean alwaysCopiesSampleData = false;
    protected int mediaType;
    private StatusListener statusListener;
    protected boolean supportsRandomAccess = false;

    /* access modifiers changed from: package-private */
    public interface StatusListener {
        void statusChanged(AssetReaderOutput assetReaderOutput, AssetReader.AVAssetReaderStatus aVAssetReaderStatus);
    }

    public abstract void markConfigurationAsFinal();

    public abstract CMSampleBuffer nextSampleBuffer();

    /* access modifiers changed from: package-private */
    public abstract void release();

    public abstract void resetForReadingTimeRanges(List<CMTimeRange> list);

    /* access modifiers changed from: package-private */
    public abstract void start(IContextCreate iContextCreate, AssetReader assetReader);

    public int getMediaType() {
        return this.mediaType;
    }

    public boolean isAlwaysCopiesSampleData() {
        return this.alwaysCopiesSampleData;
    }

    public boolean isSupportsRandomAccess() {
        return this.supportsRandomAccess;
    }

    public void setAlwaysCopiesSampleData(boolean z) {
        this.alwaysCopiesSampleData = z;
    }

    public void setSupportsRandomAccess(boolean z) {
        this.supportsRandomAccess = z;
    }

    public final CMSampleBuffer copyNextSampleBuffer() {
        CMSampleBuffer nextSampleBuffer = nextSampleBuffer();
        if (nextSampleBuffer.getTime().getTimeUs() <= 0) {
            if (nextSampleBuffer.getState().getStateCode() == -1) {
                if (this.statusListener != null) {
                    this.statusListener.statusChanged(this, AssetReader.AVAssetReaderStatus.AssetReaderStatusCompleted);
                }
            } else if (this.statusListener != null) {
                this.statusListener.statusChanged(this, AssetReader.AVAssetReaderStatus.AssetReaderStatusFailed);
            }
        }
        return nextSampleBuffer;
    }

    /* access modifiers changed from: package-private */
    public long duration() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public void addStatusListener(StatusListener statusListener2) {
        this.statusListener = statusListener2;
    }
}
