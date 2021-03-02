package com.tencent.tavkit.composition.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.asset.AssetTrack;
import com.tencent.tav.core.MutableAudioMixInputParameters;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tavkit.composition.model.TAVAudioConfiguration;
import java.util.ArrayList;
import java.util.List;

public class TAVAudioMixInputParameters extends MutableAudioMixInputParameters {
    private static final String TAG = "TAVAudioMixInputParameters";
    private List<TAVAudioConfigurationSegment> audioConfigurationSegmentList = new ArrayList();

    public TAVAudioMixInputParameters(AssetTrack assetTrack) {
        super(assetTrack);
        AppMethodBeat.i(197497);
        AppMethodBeat.o(197497);
    }

    @Override // com.tencent.tav.core.AudioMixInputParameters
    public float getVolumeAtTime(CMTime cMTime) {
        AppMethodBeat.i(197498);
        for (TAVAudioConfigurationSegment tAVAudioConfigurationSegment : this.audioConfigurationSegmentList) {
            if (tAVAudioConfigurationSegment != null && tAVAudioConfigurationSegment.compositionTimeRange.containsTime(cMTime)) {
                if (tAVAudioConfigurationSegment.audioConfiguration.getStartVolumeEdge() != null && tAVAudioConfigurationSegment.compositionTimeRange.getStart().add(tAVAudioConfigurationSegment.audioConfiguration.getStartVolumeEdge().getDuration()).bigThan(cMTime)) {
                    float volume = tAVAudioConfigurationSegment.audioConfiguration.getStartVolumeEdge().getVolume(cMTime.sub(tAVAudioConfigurationSegment.compositionTimeRange.getStart()));
                    AppMethodBeat.o(197498);
                    return volume;
                } else if (tAVAudioConfigurationSegment.audioConfiguration.getEndVolumeEdge() == null || !tAVAudioConfigurationSegment.compositionTimeRange.getEnd().sub(tAVAudioConfigurationSegment.audioConfiguration.getEndVolumeEdge().getDuration()).smallThan(cMTime)) {
                    float volume2 = tAVAudioConfigurationSegment.audioConfiguration.getVolume(cMTime);
                    AppMethodBeat.o(197498);
                    return volume2;
                } else {
                    float volume3 = tAVAudioConfigurationSegment.audioConfiguration.getEndVolumeEdge().getVolume(cMTime.sub(tAVAudioConfigurationSegment.compositionTimeRange.getEnd().sub(tAVAudioConfigurationSegment.audioConfiguration.getEndVolumeEdge().getDuration())));
                    AppMethodBeat.o(197498);
                    return volume3;
                }
            }
        }
        Logger.e(TAG, "没有设置正确audioConfiguration，走到了非预想的分支");
        float volumeAtTime = super.getVolumeAtTime(cMTime);
        AppMethodBeat.o(197498);
        return volumeAtTime;
    }

    public List<TAVAudioConfigurationSegment> getAudioConfigurationSegmentList() {
        return this.audioConfigurationSegmentList;
    }

    public void addAudioConfiguration(CMTimeRange cMTimeRange, TAVAudioConfiguration tAVAudioConfiguration) {
        AppMethodBeat.i(197499);
        this.audioConfigurationSegmentList.add(new TAVAudioConfigurationSegment(cMTimeRange, tAVAudioConfiguration));
        AppMethodBeat.o(197499);
    }

    public void setAudioConfigurationSegments(List<TAVAudioConfigurationSegment> list) {
        AppMethodBeat.i(197500);
        this.audioConfigurationSegmentList.clear();
        this.audioConfigurationSegmentList.addAll(list);
        AppMethodBeat.o(197500);
    }
}
