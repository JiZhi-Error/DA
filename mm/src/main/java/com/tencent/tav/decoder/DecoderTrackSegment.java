package com.tencent.tav.decoder;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.asset.AssetTrack;
import com.tencent.tav.asset.AssetTrackSegment;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;

public class DecoderTrackSegment {
    private CMTime decoderStartTime;
    private CMTime scaledDuration;
    private CMTimeRange timeRange;
    private DecoderAssetTrack videoAsset;

    public DecoderTrackSegment(long j2) {
        this(new CMTimeRange(CMTime.CMTimeZero, new CMTime(((float) j2) / 1000.0f)), (DecoderAssetTrack) null);
        AppMethodBeat.i(218147);
        AppMethodBeat.o(218147);
    }

    public DecoderTrackSegment(CMTimeRange cMTimeRange, DecoderAssetTrack decoderAssetTrack) {
        AppMethodBeat.i(218148);
        this.videoAsset = decoderAssetTrack;
        this.timeRange = cMTimeRange;
        this.scaledDuration = cMTimeRange.getDuration();
        this.decoderStartTime = CMTime.CMTimeZero;
        AppMethodBeat.o(218148);
    }

    public DecoderTrackSegment(AssetTrack assetTrack, AssetTrackSegment assetTrackSegment) {
        this(assetTrackSegment.getTimeMapping().getSource().clone(), DecoderAssetTrack.create(assetTrack, assetTrackSegment));
        AppMethodBeat.i(218149);
        setScaledDuration(assetTrackSegment.getScaleDuration());
        AppMethodBeat.o(218149);
    }

    public void setTimeRange(CMTimeRange cMTimeRange) {
        this.timeRange = cMTimeRange;
    }

    public CMTimeRange getTimeRange() {
        return this.timeRange;
    }

    public DecoderAssetTrack getVideoAsset() {
        return this.videoAsset;
    }

    public CMTime getScaledDuration() {
        return this.scaledDuration;
    }

    public void setScaledDuration(CMTime cMTime) {
        this.scaledDuration = cMTime;
    }

    public CMTime getDecoderStartTime() {
        return this.decoderStartTime;
    }
}
