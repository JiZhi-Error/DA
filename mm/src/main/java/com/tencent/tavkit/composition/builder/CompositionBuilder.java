package com.tencent.tavkit.composition.builder;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.asset.CompositionTrack;
import com.tencent.tav.asset.MutableComposition;
import com.tencent.tavkit.composition.audio.TAVAudioTransition;
import com.tencent.tavkit.composition.model.TAVAudio;
import com.tencent.tavkit.composition.model.TAVTransitionableAudio;
import com.tencent.tavkit.composition.model.TAVTransitionableVideo;
import com.tencent.tavkit.composition.model.TAVVideo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* access modifiers changed from: package-private */
public class CompositionBuilder {
    private BuilderModel builderModel;
    private MutableComposition composition = new MutableComposition();
    private boolean isAudioTracksMerge;
    private boolean isVideoTracksMerge;

    public CompositionBuilder(BuilderModel builderModel2, boolean z, boolean z2) {
        AppMethodBeat.i(197525);
        this.builderModel = builderModel2;
        this.isVideoTracksMerge = z;
        this.isAudioTracksMerge = z2;
        AppMethodBeat.o(197525);
    }

    /* access modifiers changed from: package-private */
    public MutableComposition build() {
        AppMethodBeat.i(197526);
        initCompositionWithVideoChannels();
        initCompositionWithAudioChannels();
        initCompositionWithOverlays(this.builderModel.getOverlays());
        initCompositionWithMixAudios(this.builderModel.getMixAudios());
        MutableComposition mutableComposition = this.composition;
        AppMethodBeat.o(197526);
        return mutableComposition;
    }

    private void initCompositionWithVideoChannels() {
        AppMethodBeat.i(197527);
        for (List<? extends TAVTransitionableVideo> list : this.builderModel.getVideoChannels()) {
            ArrayList arrayList = new ArrayList();
            for (TAVTransitionableVideo tAVTransitionableVideo : list) {
                for (int i2 = 0; i2 < tAVTransitionableVideo.numberOfVideoTracks(); i2++) {
                    CompositionTrack videoCompositionTrackForComposition = tAVTransitionableVideo.videoCompositionTrackForComposition(this.composition, i2, this.isVideoTracksMerge);
                    if (videoCompositionTrackForComposition != null) {
                        arrayList.add(new VideoInfo(videoCompositionTrackForComposition, tAVTransitionableVideo));
                    }
                }
            }
            this.builderModel.addMainVideoTrackInfo(arrayList);
        }
        AppMethodBeat.o(197527);
    }

    private void initCompositionWithAudioChannels() {
        AppMethodBeat.i(197528);
        for (List<? extends TAVTransitionableAudio> list : this.builderModel.getAudioChannels()) {
            ArrayList arrayList = new ArrayList();
            HashMap hashMap = new HashMap();
            TAVAudioTransition tAVAudioTransition = null;
            for (int i2 = 0; i2 < list.size(); i2++) {
                TAVTransitionableAudio tAVTransitionableAudio = (TAVTransitionableAudio) list.get(i2);
                for (int i3 = 0; i3 < tAVTransitionableAudio.numberOfAudioTracks(); i3++) {
                    CompositionTrack audioCompositionTrackForComposition = tAVTransitionableAudio.audioCompositionTrackForComposition(this.composition, i3, this.isAudioTracksMerge);
                    if (audioCompositionTrackForComposition != null) {
                        arrayList.add(new AudioInfo(audioCompositionTrackForComposition, tAVTransitionableAudio));
                    }
                }
                hashMap.put(String.valueOf(i2), getAudioTransitionInfo(list, tAVAudioTransition, tAVTransitionableAudio, i2));
                tAVAudioTransition = tAVTransitionableAudio.getAudioTransition();
            }
            this.builderModel.addMainAudioTrackInfo(new AudioParamsInfo(arrayList, hashMap));
        }
        AppMethodBeat.o(197528);
    }

    private AudioTransitionInfo getAudioTransitionInfo(List<? extends TAVTransitionableAudio> list, TAVAudioTransition tAVAudioTransition, TAVTransitionableAudio tAVTransitionableAudio, int i2) {
        AppMethodBeat.i(197529);
        if (i2 == 0 && list.size() > 1) {
            AudioTransitionInfo audioTransitionInfo = new AudioTransitionInfo(null, tAVTransitionableAudio.getAudioTransition());
            AppMethodBeat.o(197529);
            return audioTransitionInfo;
        } else if (i2 == list.size() - 1) {
            AudioTransitionInfo audioTransitionInfo2 = new AudioTransitionInfo(tAVAudioTransition, null);
            AppMethodBeat.o(197529);
            return audioTransitionInfo2;
        } else {
            AudioTransitionInfo audioTransitionInfo3 = new AudioTransitionInfo(tAVAudioTransition, tAVTransitionableAudio.getAudioTransition());
            AppMethodBeat.o(197529);
            return audioTransitionInfo3;
        }
    }

    private void initCompositionWithOverlays(List<? extends TAVVideo> list) {
        AppMethodBeat.i(197530);
        if (list == null) {
            AppMethodBeat.o(197530);
            return;
        }
        for (TAVVideo tAVVideo : list) {
            for (int i2 = 0; i2 < tAVVideo.numberOfVideoTracks(); i2++) {
                CompositionTrack videoCompositionTrackForComposition = tAVVideo.videoCompositionTrackForComposition(this.composition, i2, this.isVideoTracksMerge);
                if (videoCompositionTrackForComposition != null) {
                    this.builderModel.addOverlayTrackInfo(new VideoOverlayInfo(videoCompositionTrackForComposition, tAVVideo));
                }
            }
        }
        AppMethodBeat.o(197530);
    }

    private void initCompositionWithMixAudios(List<? extends TAVAudio> list) {
        AppMethodBeat.i(197531);
        if (list == null) {
            AppMethodBeat.o(197531);
            return;
        }
        for (TAVAudio tAVAudio : list) {
            for (int i2 = 0; i2 < tAVAudio.numberOfAudioTracks(); i2++) {
                CompositionTrack audioCompositionTrackForComposition = tAVAudio.audioCompositionTrackForComposition(this.composition, i2, this.isAudioTracksMerge);
                if (audioCompositionTrackForComposition != null) {
                    this.builderModel.addAudioTrackInfo(new AudioMixInfo(audioCompositionTrackForComposition, tAVAudio));
                }
            }
        }
        AppMethodBeat.o(197531);
    }
}
