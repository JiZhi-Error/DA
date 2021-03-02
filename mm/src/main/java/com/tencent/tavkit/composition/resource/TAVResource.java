package com.tencent.tavkit.composition.resource;

import com.tencent.tav.asset.AssetTrack;
import com.tencent.tav.asset.MutableComposition;
import com.tencent.tav.asset.MutableCompositionTrack;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.ciimage.CIImage;
import java.util.ArrayList;
import java.util.List;

public abstract class TAVResource implements Cloneable {
    protected CMTime duration = CMTime.CMTimeZero;
    protected CMTime scaledDuration;
    protected CMTimeRange sourceTimeRange;

    @Override // java.lang.Object
    public abstract TAVResource clone();

    public TAVResource() {
        CMTime cMTime = CMTime.CMTimeZero;
        this.sourceTimeRange = new CMTimeRange(cMTime, cMTime);
        this.scaledDuration = CMTime.CMTimeInvalid;
    }

    public void setDuration(CMTime cMTime) {
        this.duration = cMTime;
    }

    public CMTime getDuration() {
        return this.duration;
    }

    public void setSourceTimeRange(CMTimeRange cMTimeRange) {
        this.sourceTimeRange = cMTimeRange.clone();
    }

    public CMTimeRange getSourceTimeRange() {
        return this.sourceTimeRange;
    }

    public void setScaledDuration(CMTime cMTime) {
        this.scaledDuration = cMTime;
    }

    public CMTime getScaledDuration() {
        if (this.scaledDuration.equals(CMTime.CMTimeInvalid)) {
            return this.sourceTimeRange.getDuration();
        }
        return this.scaledDuration;
    }

    public List<AssetTrack> tracksForType(int i2) {
        ArrayList arrayList = new ArrayList();
        MutableCompositionTrack addMutableTrackWithMediaType = new MutableComposition().addMutableTrackWithMediaType(i2, 0);
        addMutableTrackWithMediaType.insertEmptyTimeRange(new CMTimeRange(CMTime.CMTimeZero, this.duration));
        arrayList.add(addMutableTrackWithMediaType);
        return arrayList;
    }

    public TrackInfo trackInfoForType(int i2, int i3) {
        return newEmptyTrackInfo(i2, i3);
    }

    /* access modifiers changed from: protected */
    public TrackInfo newEmptyTrackInfo(int i2, int i3) {
        TrackInfo trackInfo = new TrackInfo();
        trackInfo.setTrack(tracksForType(i2).get(i3));
        trackInfo.setSelectedTimeRange(new CMTimeRange(CMTime.CMTimeZero, new CMTime(1, 30)));
        trackInfo.setScaleToDuration(getScaledDuration());
        return trackInfo;
    }

    public CIImage imageAtTime(CMTime cMTime, CGSize cGSize) {
        return null;
    }

    public String toString() {
        return "TAVResource{durationUs=" + this.duration.getTimeUs() + ", sourceTimeRange=" + this.sourceTimeRange.toSimpleString() + ", scaledDurationUs=" + this.scaledDuration.getTimeUs() + '}';
    }
}
