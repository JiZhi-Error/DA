package com.tencent.tavkit.composition;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.asset.CompositionTrack;
import com.tencent.tav.asset.MutableComposition;
import com.tencent.tav.asset.MutableCompositionTrack;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.audio.TAVAudioTransition;
import com.tencent.tavkit.composition.model.TAVAudioConfiguration;
import com.tencent.tavkit.composition.model.TAVTransition;
import com.tencent.tavkit.composition.model.TAVTransitionableAudio;
import com.tencent.tavkit.composition.model.TAVTransitionableVideo;
import com.tencent.tavkit.composition.model.TAVVideoConfiguration;
import com.tencent.tavkit.composition.resource.TAVAssetTrackResource;
import com.tencent.tavkit.composition.resource.TAVEmptyResource;
import com.tencent.tavkit.composition.resource.TAVImageResource;
import com.tencent.tavkit.composition.resource.TAVResource;
import com.tencent.tavkit.composition.resource.TrackInfo;
import com.tencent.tavkit.composition.video.TAVVideoTransition;
import com.tencent.tavkit.utils.CompositionUtils;
import java.util.HashMap;

public class TAVClip implements TAVTransitionableAudio, TAVTransitionableVideo, Cloneable {
    private final String TAG;
    private TAVAudioConfiguration audioConfiguration;
    private HashMap<String, Object> extraTrackInfoMap;
    private TAVResource resource;
    private CMTime startTime;
    private TAVTransition transition;
    private TAVVideoConfiguration videoConfiguration;

    public TAVClip() {
        AppMethodBeat.i(197464);
        this.TAG = "TAVClip@" + Integer.toHexString(hashCode());
        this.extraTrackInfoMap = new HashMap<>();
        this.startTime = CMTime.CMTimeZero;
        this.audioConfiguration = new TAVAudioConfiguration();
        this.videoConfiguration = new TAVVideoConfiguration();
        AppMethodBeat.o(197464);
    }

    public TAVClip(TAVResource tAVResource) {
        this();
        this.resource = tAVResource;
    }

    public TAVClip(Asset asset) {
        this(new TAVAssetTrackResource(asset));
        AppMethodBeat.i(197465);
        AppMethodBeat.o(197465);
    }

    public TAVClip(CIImage cIImage, CMTime cMTime) {
        this(new TAVImageResource(cIImage, cMTime));
        AppMethodBeat.i(197466);
        AppMethodBeat.o(197466);
    }

    public TAVClip(CMTime cMTime) {
        this(cMTime, false);
    }

    public TAVClip(CMTime cMTime, boolean z) {
        this(new TAVEmptyResource(cMTime, z));
        AppMethodBeat.i(197467);
        AppMethodBeat.o(197467);
    }

    public TAVResource getResource() {
        return this.resource;
    }

    public void setResource(TAVResource tAVResource) {
        this.resource = tAVResource;
    }

    @Override // com.tencent.tavkit.composition.model.TAVVideo
    public TAVVideoConfiguration getVideoConfiguration() {
        return this.videoConfiguration;
    }

    public void setVideoConfiguration(TAVVideoConfiguration tAVVideoConfiguration) {
        this.videoConfiguration = tAVVideoConfiguration;
    }

    @Override // com.tencent.tavkit.composition.model.TAVAudio
    public TAVAudioConfiguration getAudioConfiguration() {
        return this.audioConfiguration;
    }

    public void setAudioConfiguration(TAVAudioConfiguration tAVAudioConfiguration) {
        this.audioConfiguration = tAVAudioConfiguration;
    }

    @Override // com.tencent.tavkit.composition.model.TAVCompositionTimeRange
    public CMTime getStartTime() {
        return this.startTime;
    }

    @Override // com.tencent.tavkit.composition.model.TAVCompositionTimeRange
    public void setStartTime(CMTime cMTime) {
        AppMethodBeat.i(197468);
        this.startTime = cMTime;
        if (this.videoConfiguration != null) {
            this.videoConfiguration.updateTimeRange(getTimeRange());
        }
        AppMethodBeat.o(197468);
    }

    public TAVTransition getTransition() {
        return this.transition;
    }

    public void setTransition(TAVTransition tAVTransition) {
        this.transition = tAVTransition;
    }

    @Override // com.tencent.tavkit.composition.model.TAVTransitionableAudio
    public TAVAudioTransition getAudioTransition() {
        AppMethodBeat.i(197469);
        if (this.transition != null) {
            TAVAudioTransition audioTransition = this.transition.getAudioTransition();
            AppMethodBeat.o(197469);
            return audioTransition;
        }
        AppMethodBeat.o(197469);
        return null;
    }

    @Override // com.tencent.tavkit.composition.model.TAVTransitionableVideo
    public TAVVideoTransition getVideoTransition() {
        AppMethodBeat.i(197470);
        if (this.transition != null) {
            TAVVideoTransition videoTransition = this.transition.getVideoTransition();
            AppMethodBeat.o(197470);
            return videoTransition;
        }
        AppMethodBeat.o(197470);
        return null;
    }

    @Override // com.tencent.tavkit.composition.model.TAVVideoCompositionTrack
    public Object getExtraTrackInfo(String str) {
        AppMethodBeat.i(197471);
        Object obj = this.extraTrackInfoMap.get(str);
        AppMethodBeat.o(197471);
        return obj;
    }

    @Override // com.tencent.tavkit.composition.model.TAVVideoCompositionTrack
    public void putExtraTrackInfo(String str, Object obj) {
        AppMethodBeat.i(197472);
        this.extraTrackInfoMap.put(str, obj);
        AppMethodBeat.o(197472);
    }

    @Override // java.lang.Object
    public TAVClip clone() {
        AppMethodBeat.i(197473);
        TAVClip tAVClip = new TAVClip();
        tAVClip.resource = this.resource.clone();
        tAVClip.videoConfiguration = this.videoConfiguration.clone();
        tAVClip.audioConfiguration = this.audioConfiguration.clone();
        if (this.transition != null) {
            tAVClip.transition = this.transition;
        }
        tAVClip.extraTrackInfoMap = new HashMap<>(this.extraTrackInfoMap);
        AppMethodBeat.o(197473);
        return tAVClip;
    }

    public String toString() {
        AppMethodBeat.i(197474);
        String str = "TAVClip{resource=" + this.resource + ", videoConfiguration=" + this.videoConfiguration + ", startTime=" + this.startTime + ", transition=" + this.transition + ", extraTrackInfoMap=" + this.extraTrackInfoMap + '}';
        AppMethodBeat.o(197474);
        return str;
    }

    @Override // com.tencent.tavkit.composition.model.TAVAudioCompositionTrack
    public int numberOfAudioTracks() {
        AppMethodBeat.i(197475);
        int size = this.resource.tracksForType(2).size();
        AppMethodBeat.o(197475);
        return size;
    }

    @Override // com.tencent.tavkit.composition.model.TAVAudioCompositionTrack
    public CompositionTrack audioCompositionTrackForComposition(MutableComposition mutableComposition, int i2, boolean z) {
        MutableCompositionTrack mutableCompositionTrack = null;
        AppMethodBeat.i(197476);
        TrackInfo trackInfoForType = this.resource.trackInfoForType(2, i2);
        if (trackInfoForType == null) {
            AppMethodBeat.o(197476);
        } else {
            CMTimeRange cMTimeRange = new CMTimeRange(this.startTime, trackInfoForType.getScaleToDuration());
            if (z) {
                mutableCompositionTrack = CompositionUtils.mutableTrackCompatibleWithTimeRange(mutableComposition, cMTimeRange, 2);
            }
            if (mutableCompositionTrack == null && trackInfoForType.getMediaType() != 0) {
                mutableCompositionTrack = mutableComposition.addMutableTrackWithMediaType(trackInfoForType.getMediaType(), 0);
            }
            if (mutableCompositionTrack != null) {
                CompositionUtils.insertTimeRangeToTrack(trackInfoForType, mutableCompositionTrack, cMTimeRange);
            }
            AppMethodBeat.o(197476);
        }
        return mutableCompositionTrack;
    }

    @Override // com.tencent.tavkit.composition.model.TAVVideoCompositionTrack
    public int numberOfVideoTracks() {
        AppMethodBeat.i(197477);
        int size = this.resource.tracksForType(1).size();
        AppMethodBeat.o(197477);
        return size;
    }

    @Override // com.tencent.tavkit.composition.model.TAVVideoCompositionTrack
    public CompositionTrack videoCompositionTrackForComposition(MutableComposition mutableComposition, int i2, boolean z) {
        MutableCompositionTrack mutableCompositionTrack = null;
        AppMethodBeat.i(197478);
        TrackInfo trackInfoForType = this.resource.trackInfoForType(1, i2);
        if (trackInfoForType == null) {
            AppMethodBeat.o(197478);
        } else {
            CMTimeRange cMTimeRange = new CMTimeRange(this.startTime, trackInfoForType.getScaleToDuration());
            if (z) {
                mutableCompositionTrack = CompositionUtils.mutableTrackCompatibleWithTimeRange(mutableComposition, cMTimeRange, 1);
            }
            if (mutableCompositionTrack == null && trackInfoForType.getMediaType() != 0) {
                mutableCompositionTrack = mutableComposition.addMutableTrackWithMediaType(trackInfoForType.getMediaType(), -1);
            }
            if (mutableCompositionTrack != null) {
                CompositionUtils.insertTimeRangeToTrack(trackInfoForType, mutableCompositionTrack, cMTimeRange);
            }
            AppMethodBeat.o(197478);
        }
        return mutableCompositionTrack;
    }

    public void fitToSpeed(float f2) {
        AppMethodBeat.i(197479);
        if (f2 == 0.0f) {
            AppMethodBeat.o(197479);
            return;
        }
        this.resource.setScaledDuration(this.resource.getSourceTimeRange().getDuration().multi(1.0f / f2));
        AppMethodBeat.o(197479);
    }

    @Override // com.tencent.tavkit.composition.model.TAVVideoCompositionTrack
    public CIImage sourceImageAtTime(CMTime cMTime, CGSize cGSize) {
        AppMethodBeat.i(197480);
        CIImage imageAtTime = this.resource.imageAtTime(cMTime, cGSize);
        AppMethodBeat.o(197480);
        return imageAtTime;
    }

    @Override // com.tencent.tavkit.composition.model.TAVCompositionTimeRange
    public CMTime getDuration() {
        AppMethodBeat.i(197481);
        CMTime scaledDuration = this.resource.getScaledDuration();
        AppMethodBeat.o(197481);
        return scaledDuration;
    }

    @Override // com.tencent.tavkit.composition.model.TAVCompositionTimeRange
    public void setDuration(CMTime cMTime) {
        AppMethodBeat.i(197482);
        this.resource.setScaledDuration(cMTime);
        AppMethodBeat.o(197482);
    }

    @Override // com.tencent.tavkit.composition.model.TAVCompositionTimeRange
    public CMTimeRange getTimeRange() {
        AppMethodBeat.i(197483);
        CMTimeRange targetTimeRange = getTargetTimeRange();
        AppMethodBeat.o(197483);
        return targetTimeRange;
    }

    public CMTimeRange getTargetTimeRange() {
        AppMethodBeat.i(197484);
        CMTimeRange cMTimeRange = new CMTimeRange(this.startTime, getDuration());
        AppMethodBeat.o(197484);
        return cMTimeRange;
    }
}
