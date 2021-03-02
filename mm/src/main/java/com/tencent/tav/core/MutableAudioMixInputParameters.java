package com.tencent.tav.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.asset.AssetTrack;
import com.tencent.tav.core.AudioMixInputParameters;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import java.util.Iterator;

public class MutableAudioMixInputParameters extends AudioMixInputParameters {
    public MutableAudioMixInputParameters(AssetTrack assetTrack, String str) {
        super(assetTrack.getTrackID(), str);
        AppMethodBeat.i(217927);
        AppMethodBeat.o(217927);
    }

    public MutableAudioMixInputParameters(AssetTrack assetTrack) {
        super(assetTrack.getTrackID(), "");
        AppMethodBeat.i(217928);
        AppMethodBeat.o(217928);
    }

    public void setTrackID(int i2) {
        this.trackID = i2;
    }

    public void setAudioTimePitchAlgorithm(String str) {
        this.audioTimePitchAlgorithm = str;
    }

    public void setAudioTapProcessor(AudioTapProcessor audioTapProcessor) {
        this.audioTapProcessor = audioTapProcessor;
    }

    public void setVolumeRampForTimeRange(float f2, float f3, CMTimeRange cMTimeRange) {
        AppMethodBeat.i(217929);
        AudioMixInputParameters.VolumeRange volumeRange = new AudioMixInputParameters.VolumeRange();
        volumeRange.timeRange = cMTimeRange;
        volumeRange.startVolume = f2;
        volumeRange.endVolume = f3;
        this.volumeRanges.add(0, volumeRange);
        AppMethodBeat.o(217929);
    }

    public void setVolumeForTimeRange(float f2) {
        AppMethodBeat.i(217930);
        Iterator it = this.volumeRanges.iterator();
        while (it.hasNext()) {
            AudioMixInputParameters.VolumeRange volumeRange = (AudioMixInputParameters.VolumeRange) it.next();
            volumeRange.startVolume = f2;
            volumeRange.endVolume = f2;
        }
        AppMethodBeat.o(217930);
    }

    public void setVolumeForTimeRange(float f2, CMTimeRange cMTimeRange) {
        AppMethodBeat.i(217931);
        setVolumeRampForTimeRange(f2, f2, cMTimeRange);
        AppMethodBeat.o(217931);
    }

    public void setVolumeAtTime(float f2, CMTime cMTime) {
    }
}
