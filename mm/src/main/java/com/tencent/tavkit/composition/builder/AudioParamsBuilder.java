package com.tencent.tavkit.composition.builder;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.composition.audio.TAVAudioMixInputParameters;
import com.tencent.tavkit.composition.audio.TAVAudioTapProcessor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* access modifiers changed from: package-private */
public class AudioParamsBuilder {
    private HashMap<Integer, TAVAudioMixInputParameters> audioMixInputParametersHashMap = new HashMap<>();
    private final BuilderModel builderModel;

    AudioParamsBuilder(BuilderModel builderModel2) {
        AppMethodBeat.i(197506);
        this.builderModel = builderModel2;
        AppMethodBeat.o(197506);
    }

    /* access modifiers changed from: package-private */
    public List<TAVAudioMixInputParameters> build() {
        AppMethodBeat.i(197507);
        buildMainAudioInputParameters();
        buildBgAudioInputParameters();
        ArrayList arrayList = new ArrayList(this.audioMixInputParametersHashMap.values());
        AppMethodBeat.o(197507);
        return arrayList;
    }

    private void buildBgAudioInputParameters() {
        AppMethodBeat.i(197508);
        for (AudioMixInfo audioMixInfo : this.builderModel.getAudioTrackInfo()) {
            int trackID = audioMixInfo.track.getTrackID();
            TAVAudioMixInputParameters tAVAudioMixInputParameters = this.audioMixInputParametersHashMap.get(Integer.valueOf(trackID));
            if (tAVAudioMixInputParameters == null) {
                tAVAudioMixInputParameters = new TAVAudioMixInputParameters(audioMixInfo.track);
                this.audioMixInputParametersHashMap.put(Integer.valueOf(trackID), tAVAudioMixInputParameters);
            }
            tAVAudioMixInputParameters.addAudioConfiguration(new CMTimeRange(audioMixInfo.audio.getStartTime(), audioMixInfo.audio.getDuration()), audioMixInfo.audio.getAudioConfiguration());
            tAVAudioMixInputParameters.setAudioTapProcessor(new TAVAudioTapProcessor(tAVAudioMixInputParameters.getAudioConfigurationSegmentList()));
        }
        AppMethodBeat.o(197508);
    }

    private void buildMainAudioInputParameters() {
        AppMethodBeat.i(197509);
        List<AudioParamsInfo> mainAudioTrackInfo = this.builderModel.getMainAudioTrackInfo();
        for (int i2 = 0; i2 < mainAudioTrackInfo.size(); i2++) {
            buildAudioParametersByTrackInfo(mainAudioTrackInfo.get(i2));
        }
        AppMethodBeat.o(197509);
    }

    private void buildAudioParametersByTrackInfo(AudioParamsInfo audioParamsInfo) {
        AppMethodBeat.i(197510);
        for (AudioInfo audioInfo : audioParamsInfo.audioInfos) {
            int trackID = audioInfo.compositionTrack.getTrackID();
            TAVAudioMixInputParameters tAVAudioMixInputParameters = this.audioMixInputParametersHashMap.get(Integer.valueOf(trackID));
            if (tAVAudioMixInputParameters == null) {
                tAVAudioMixInputParameters = new TAVAudioMixInputParameters(audioInfo.compositionTrack);
                this.audioMixInputParametersHashMap.put(Integer.valueOf(trackID), tAVAudioMixInputParameters);
            }
            tAVAudioMixInputParameters.addAudioConfiguration(new CMTimeRange(audioInfo.audio.getStartTime(), audioInfo.audio.getDuration()), audioInfo.audio.getAudioConfiguration());
            tAVAudioMixInputParameters.setAudioTapProcessor(new TAVAudioTapProcessor(tAVAudioMixInputParameters.getAudioConfigurationSegmentList()));
        }
        AppMethodBeat.o(197510);
    }
}
