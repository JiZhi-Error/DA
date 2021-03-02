package com.tencent.tav.asset;

import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.asset.AssetTrackSegment;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.coremedia.TimeUtil;
import com.tencent.tav.extractor.AssetExtractor;
import com.tencent.tav.extractor.ExtractorUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class AssetTrack<Segment extends AssetTrackSegment> {
    public static final int PersistentTrackID_Invalid = -1;
    protected WeakReference<Asset> asset;
    protected List<String> availableMetadataFormats;
    protected List<String> availableTrackAssociationTypes;
    protected List<MetadataItem> commonMetadata;
    protected boolean enabled = true;
    protected float estimatedDataRate;
    protected int mediaType;
    protected CGSize naturalSize;
    protected int naturalTimeScale;
    protected float nominalFrameRate = 30.0f;
    protected int preferredRotation = 0;
    protected Matrix preferredTransform;
    protected float preferredVolume = 1.0f;
    protected List<Segment> segments = new ArrayList();
    protected String sourcePath;
    protected CMTimeRange timeRange;
    protected long totalSampleDataLength;
    protected int trackID;

    AssetTrack() {
        AppMethodBeat.i(217630);
        AppMethodBeat.o(217630);
    }

    AssetTrack(Asset asset2, int i2, int i3, CMTimeRange cMTimeRange) {
        AppMethodBeat.i(217631);
        this.trackID = i2;
        this.mediaType = i3;
        this.timeRange = cMTimeRange;
        if (asset2 != null && i2 < asset2.getTrackCount()) {
            this.asset = new WeakReference<>(asset2);
            this.nominalFrameRate = (float) ExtractorUtils.getFrameRate(asset2.getTrackFormat(i2));
            this.naturalSize = asset2.getNaturalSize();
            this.sourcePath = asset2.getSourcePath();
        }
        createAssetTrackSegments(asset2);
        AppMethodBeat.o(217631);
    }

    public String getSourcePath() {
        return this.sourcePath;
    }

    public Asset getAsset() {
        AppMethodBeat.i(217632);
        if (this.asset != null) {
            Asset asset2 = this.asset.get();
            AppMethodBeat.o(217632);
            return asset2;
        }
        AppMethodBeat.o(217632);
        return null;
    }

    public int getTrackID() {
        return this.trackID;
    }

    public int getMediaType() {
        return this.mediaType;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public long getTotalSampleDataLength() {
        return this.totalSampleDataLength;
    }

    public CMTimeRange getTimeRange() {
        AppMethodBeat.i(217633);
        if (this.timeRange == null || this.timeRange == CMTimeRange.CMTimeRangeInvalid) {
            this.timeRange = new CMTimeRange(CMTime.CMTimeZero, getDuration());
        }
        CMTimeRange cMTimeRange = this.timeRange;
        AppMethodBeat.o(217633);
        return cMTimeRange;
    }

    public int getNaturalTimeScale() {
        return this.naturalTimeScale;
    }

    public float getEstimatedDataRate() {
        return this.estimatedDataRate;
    }

    public CGSize getNaturalSize() {
        return this.naturalSize;
    }

    public Matrix getPreferredTransform() {
        return this.preferredTransform;
    }

    /* access modifiers changed from: package-private */
    public void setPreferredTransform(Matrix matrix) {
        this.preferredTransform = matrix;
    }

    /* access modifiers changed from: package-private */
    public void setPreferredVolume(float f2) {
        this.preferredVolume = f2;
    }

    public float getPreferredVolume() {
        return this.preferredVolume;
    }

    /* access modifiers changed from: package-private */
    public void setPreferredRotation(int i2) {
        this.preferredRotation = i2;
    }

    public int getPreferredRotation() {
        return this.preferredRotation;
    }

    public float getNominalFrameRate() {
        return this.nominalFrameRate;
    }

    public List<Segment> getSegments() {
        return this.segments;
    }

    public List<MetadataItem> getCommonMetadata() {
        return this.commonMetadata;
    }

    public List<String> getAvailableMetadataFormats() {
        return this.availableMetadataFormats;
    }

    public List<String> getAvailableTrackAssociationTypes() {
        return this.availableTrackAssociationTypes;
    }

    public boolean hasMediaCharacteristic(String str) {
        return false;
    }

    public AssetTrackSegment segmentForTrackTime(CMTime cMTime) {
        CMTimeRange target;
        AppMethodBeat.i(217634);
        if (this.segments != null) {
            for (Segment segment : this.segments) {
                if (!(segment == null || (target = segment.getTimeMapping().getTarget()) == null || !target.containsTime(cMTime))) {
                    AppMethodBeat.o(217634);
                    return segment;
                }
            }
        }
        AppMethodBeat.o(217634);
        return null;
    }

    public CMTime samplePresentationTimeForTrackTime(CMTime cMTime) {
        AssetExtractor extractor;
        AppMethodBeat.i(217635);
        if (this.asset == null || this.asset.get() == null || (extractor = this.asset.get().getExtractor()) == null) {
            AppMethodBeat.o(217635);
            return null;
        }
        extractor.seekTo(cMTime.getTimeUs(), 2);
        if (extractor.getSampleTime() > cMTime.getTimeUs()) {
            extractor.seekTo(cMTime.getTimeUs(), 0);
        }
        CMTime us2CMTime = TimeUtil.us2CMTime(extractor.getSampleTime());
        AppMethodBeat.o(217635);
        return us2CMTime;
    }

    public List<MetadataItem> metadataForFormat(String str) {
        return null;
    }

    public List<AssetTrack> associatedTracksOfType(String str) {
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: java.util.List<Segment extends com.tencent.tav.asset.AssetTrackSegment> */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: protected */
    public void createAssetTrackSegments(Asset asset2) {
        AppMethodBeat.i(217636);
        if (this.segments == null) {
            this.segments = new ArrayList();
        }
        if (asset2 != null && asset2.getTrackCount() > this.trackID) {
            this.segments.add(new AssetTrackSegment(this.timeRange, this.timeRange));
        }
        AppMethodBeat.o(217636);
    }

    public CMTime getDuration() {
        AppMethodBeat.i(217637);
        if (this.timeRange != null) {
            CMTime duration = this.timeRange.getDuration();
            AppMethodBeat.o(217637);
            return duration;
        }
        CMTime cMTime = CMTime.CMTimeZero;
        AppMethodBeat.o(217637);
        return cMTime;
    }
}
