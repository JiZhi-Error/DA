package com.tencent.tavkit.composition.resource;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.asset.AssetTrack;
import com.tencent.tav.asset.URLAsset;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import java.util.ArrayList;
import java.util.List;

public class TAVAssetTrackResource extends TAVResource {
    private Asset asset;

    public TAVAssetTrackResource(String str) {
        this(new URLAsset(str));
        AppMethodBeat.i(197580);
        AppMethodBeat.o(197580);
    }

    public TAVAssetTrackResource(Asset asset2) {
        AppMethodBeat.i(197581);
        this.asset = asset2;
        this.duration = asset2.getDuration();
        this.sourceTimeRange = new CMTimeRange(CMTime.CMTimeZero, asset2.getDuration());
        AppMethodBeat.o(197581);
    }

    public Asset getAsset() {
        return this.asset;
    }

    @Override // com.tencent.tavkit.composition.resource.TAVResource
    public List<AssetTrack> tracksForType(int i2) {
        AppMethodBeat.i(197582);
        if (this.asset != null) {
            List<AssetTrack> tracksWithMediaType = this.asset.tracksWithMediaType(i2);
            AppMethodBeat.o(197582);
            return tracksWithMediaType;
        }
        ArrayList arrayList = new ArrayList();
        AppMethodBeat.o(197582);
        return arrayList;
    }

    @Override // com.tencent.tavkit.composition.resource.TAVResource
    public TrackInfo trackInfoForType(int i2, int i3) {
        AppMethodBeat.i(197583);
        TrackInfo trackInfo = new TrackInfo();
        trackInfo.setTrack(tracksForType(i2).get(i3));
        trackInfo.setSelectedTimeRange(getSourceTimeRange());
        trackInfo.setScaleToDuration(getScaledDuration());
        AppMethodBeat.o(197583);
        return trackInfo;
    }

    @Override // com.tencent.tavkit.composition.resource.TAVResource, com.tencent.tavkit.composition.resource.TAVResource, java.lang.Object
    public TAVResource clone() {
        AppMethodBeat.i(197584);
        TAVAssetTrackResource tAVAssetTrackResource = new TAVAssetTrackResource(this.asset);
        tAVAssetTrackResource.sourceTimeRange = this.sourceTimeRange.clone();
        tAVAssetTrackResource.scaledDuration = this.scaledDuration.clone();
        tAVAssetTrackResource.duration = this.duration.clone();
        AppMethodBeat.o(197584);
        return tAVAssetTrackResource;
    }
}
