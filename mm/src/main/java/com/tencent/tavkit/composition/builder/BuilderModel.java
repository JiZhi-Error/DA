package com.tencent.tavkit.composition.builder;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.core.composition.VideoComposition;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.model.TAVAudio;
import com.tencent.tavkit.composition.model.TAVTransitionableAudio;
import com.tencent.tavkit.composition.model.TAVTransitionableVideo;
import com.tencent.tavkit.composition.model.TAVVideo;
import com.tencent.tavkit.composition.video.TAVVideoEffect;
import com.tencent.tavkit.composition.video.TAVVideoMixEffect;
import java.util.ArrayList;
import java.util.List;

/* access modifiers changed from: package-private */
public class BuilderModel {
    private final List<AudioMixInfo> audioTrackInfo = new ArrayList();
    private final List<AudioParamsInfo> mainAudioTrackInfo = new ArrayList();
    private final List<List<VideoInfo>> mainVideoTrackInfo = new ArrayList();
    private final List<VideoOverlayInfo> overlayTrackInfo = new ArrayList();
    private final TAVComposition tavComposition;

    BuilderModel(TAVComposition tAVComposition) {
        AppMethodBeat.i(197511);
        this.tavComposition = tAVComposition;
        AppMethodBeat.o(197511);
    }

    public List<List<VideoInfo>> getMainVideoTrackInfo() {
        return this.mainVideoTrackInfo;
    }

    public List<VideoOverlayInfo> getOverlayTrackInfo() {
        return this.overlayTrackInfo;
    }

    public TAVComposition getTavComposition() {
        return this.tavComposition;
    }

    /* access modifiers changed from: package-private */
    public List<List<? extends TAVTransitionableVideo>> getVideoChannels() {
        AppMethodBeat.i(197512);
        List<List<? extends TAVTransitionableVideo>> videoChannels = this.tavComposition.getVideoChannels();
        AppMethodBeat.o(197512);
        return videoChannels;
    }

    /* access modifiers changed from: package-private */
    public List<List<? extends TAVTransitionableAudio>> getAudioChannels() {
        AppMethodBeat.i(197513);
        List<List<? extends TAVTransitionableAudio>> audioChannels = this.tavComposition.getAudioChannels();
        AppMethodBeat.o(197513);
        return audioChannels;
    }

    /* access modifiers changed from: package-private */
    public List<? extends TAVVideo> getOverlays() {
        AppMethodBeat.i(197514);
        List<? extends TAVVideo> overlays = this.tavComposition.getOverlays();
        AppMethodBeat.o(197514);
        return overlays;
    }

    /* access modifiers changed from: package-private */
    public List<? extends TAVAudio> getMixAudios() {
        AppMethodBeat.i(197515);
        List<? extends TAVAudio> audios = this.tavComposition.getAudios();
        AppMethodBeat.o(197515);
        return audios;
    }

    /* access modifiers changed from: package-private */
    public int getBackgroundColor() {
        AppMethodBeat.i(197516);
        int backgroundColor = this.tavComposition.getBackgroundColor();
        AppMethodBeat.o(197516);
        return backgroundColor;
    }

    /* access modifiers changed from: package-private */
    public CGSize getRenderSize() {
        AppMethodBeat.i(197517);
        CGSize renderSize = this.tavComposition.getRenderSize();
        AppMethodBeat.o(197517);
        return renderSize;
    }

    /* access modifiers changed from: package-private */
    public VideoComposition.RenderLayoutMode getRenderLayoutMode() {
        AppMethodBeat.i(197518);
        VideoComposition.RenderLayoutMode renderLayoutMode = this.tavComposition.getRenderLayoutMode();
        AppMethodBeat.o(197518);
        return renderLayoutMode;
    }

    /* access modifiers changed from: package-private */
    public TAVVideoEffect getGlobalVideoEffect() {
        AppMethodBeat.i(197519);
        TAVVideoEffect globalVideoEffect = this.tavComposition.getGlobalVideoEffect();
        AppMethodBeat.o(197519);
        return globalVideoEffect;
    }

    public TAVVideoMixEffect getVideoMixEffect() {
        AppMethodBeat.i(197520);
        TAVVideoMixEffect videoMixEffect = this.tavComposition.getVideoMixEffect();
        AppMethodBeat.o(197520);
        return videoMixEffect;
    }

    /* access modifiers changed from: package-private */
    public List<AudioParamsInfo> getMainAudioTrackInfo() {
        return this.mainAudioTrackInfo;
    }

    /* access modifiers changed from: package-private */
    public List<AudioMixInfo> getAudioTrackInfo() {
        return this.audioTrackInfo;
    }

    /* access modifiers changed from: package-private */
    public void addMainVideoTrackInfo(List<VideoInfo> list) {
        AppMethodBeat.i(197521);
        this.mainVideoTrackInfo.add(list);
        AppMethodBeat.o(197521);
    }

    /* access modifiers changed from: package-private */
    public void addMainAudioTrackInfo(AudioParamsInfo audioParamsInfo) {
        AppMethodBeat.i(197522);
        this.mainAudioTrackInfo.add(audioParamsInfo);
        AppMethodBeat.o(197522);
    }

    /* access modifiers changed from: package-private */
    public void addOverlayTrackInfo(VideoOverlayInfo videoOverlayInfo) {
        AppMethodBeat.i(197523);
        this.overlayTrackInfo.add(videoOverlayInfo);
        AppMethodBeat.o(197523);
    }

    /* access modifiers changed from: package-private */
    public void addAudioTrackInfo(AudioMixInfo audioMixInfo) {
        AppMethodBeat.i(197524);
        this.audioTrackInfo.add(audioMixInfo);
        AppMethodBeat.o(197524);
    }
}
