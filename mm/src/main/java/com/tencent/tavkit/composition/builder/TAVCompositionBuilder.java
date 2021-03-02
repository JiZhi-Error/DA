package com.tencent.tavkit.composition.builder;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.asset.MutableComposition;
import com.tencent.tav.core.AudioMix;
import com.tencent.tav.core.AudioMixInputParameters;
import com.tencent.tav.core.MutableAudioMix;
import com.tencent.tav.core.composition.MutableVideoComposition;
import com.tencent.tav.core.composition.VideoComposition;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.TAVSource;
import com.tencent.tavkit.composition.audio.TAVAudioMixInputParameters;
import com.tencent.tavkit.composition.model.TAVTransitionableAudio;
import com.tencent.tavkit.composition.model.TAVTransitionableVideo;
import com.tencent.tavkit.composition.video.TAVVideoCompositing;
import com.tencent.tavkit.utils.CompositionUtils;
import java.util.List;

public class TAVCompositionBuilder {
    private static final String TAG = "TAVCompositionBuilder";
    private final BuilderModel builderModel;
    private boolean isAudioTracksMerge = true;
    private boolean isReloadChannels = true;
    private boolean isVideoTracksMerge = true;

    public TAVCompositionBuilder(TAVComposition tAVComposition) {
        AppMethodBeat.i(197532);
        this.builderModel = new BuilderModel(tAVComposition);
        AppMethodBeat.o(197532);
    }

    public void setAudioTracksMerge(boolean z) {
        this.isAudioTracksMerge = z;
    }

    public void setVideoTracksMerge(boolean z) {
        this.isVideoTracksMerge = z;
    }

    public void setReloadChannels(boolean z) {
        this.isReloadChannels = z;
    }

    public TAVSource buildSource() {
        AppMethodBeat.i(197533);
        Logger.i(TAG, "buildSource: begin, tavComposition = " + this.builderModel.getTavComposition());
        TAVSource tAVSource = new TAVSource();
        tAVSource.setAsset(buildComposition());
        tAVSource.setVideoComposition(buildVideoComposition());
        tAVSource.setAudioMix(buildAudioMix());
        Logger.i(TAG, "buildSource: end, return source = ".concat(String.valueOf(tAVSource)));
        AppMethodBeat.o(197533);
        return tAVSource;
    }

    private Asset buildComposition() {
        AppMethodBeat.i(197534);
        if (this.isReloadChannels) {
            reloadChannels();
        }
        MutableComposition build = new CompositionBuilder(this.builderModel, this.isVideoTracksMerge, this.isAudioTracksMerge).build();
        AppMethodBeat.o(197534);
        return build;
    }

    private void reloadChannels() {
        AppMethodBeat.i(197535);
        for (List<? extends TAVTransitionableVideo> list : this.builderModel.getVideoChannels()) {
            CompositionUtils.reloadVideoStartTimeWithTransitionableVideo(list);
        }
        Logger.d(TAG, "buildComposition: reloadVideoChannels = " + this.builderModel.getVideoChannels());
        for (List<? extends TAVTransitionableAudio> list2 : this.builderModel.getAudioChannels()) {
            CompositionUtils.reloadAudioStartTimeWithTransitionableAudio(list2);
        }
        Logger.d(TAG, "buildComposition: reloadAudioChannels = " + this.builderModel.getAudioChannels());
        AppMethodBeat.o(197535);
    }

    private VideoComposition buildVideoComposition() {
        AppMethodBeat.i(197536);
        MutableVideoComposition mutableVideoComposition = new MutableVideoComposition();
        mutableVideoComposition.setFrameDuration(new CMTime(1, 30));
        mutableVideoComposition.setRenderSize(this.builderModel.getRenderSize());
        mutableVideoComposition.setRenderLayoutMode(this.builderModel.getRenderLayoutMode());
        mutableVideoComposition.setCustomVideoCompositorClass(TAVVideoCompositing.class);
        mutableVideoComposition.setInstructions(new VideoInstructionsBuilder(this.builderModel).build());
        AppMethodBeat.o(197536);
        return mutableVideoComposition;
    }

    private AudioMix<? extends AudioMixInputParameters> buildAudioMix() {
        AppMethodBeat.i(197537);
        List<TAVAudioMixInputParameters> build = new AudioParamsBuilder(this.builderModel).build();
        if (build.size() == 0) {
            AppMethodBeat.o(197537);
            return null;
        }
        MutableAudioMix mutableAudioMix = new MutableAudioMix(build);
        AppMethodBeat.o(197537);
        return mutableAudioMix;
    }
}
