package com.tencent.tavkit.composition;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tav.core.composition.VideoComposition;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tavkit.component.effectchain.IVideoEffectContext;
import com.tencent.tavkit.composition.model.TAVAudio;
import com.tencent.tavkit.composition.model.TAVTransitionableAudio;
import com.tencent.tavkit.composition.model.TAVTransitionableVideo;
import com.tencent.tavkit.composition.model.TAVVideo;
import com.tencent.tavkit.composition.video.TAVVideoEffect;
import com.tencent.tavkit.composition.video.TAVVideoMixEffect;
import com.tencent.tavkit.utils.ListUtils;
import java.util.ArrayList;
import java.util.List;

public class TAVComposition {
    private List<List<? extends TAVTransitionableAudio>> audioChannels;
    private List<? extends TAVAudio> audios;
    private int backgroundColor;
    private CMTime frameDuration;
    private TAVVideoEffect globalVideoEffect;
    private List<? extends TAVVideo> overlays;
    private VideoComposition.RenderLayoutMode renderLayoutMode;
    private CGSize renderSize;
    private TAVVideoEffect sourceVideoEffect;
    private List<List<? extends TAVTransitionableVideo>> videoChannels;
    private TAVVideoMixEffect videoMixEffect;

    public TAVComposition(TAVClip... tAVClipArr) {
        this(ListUtils.listWithObjects(tAVClipArr));
        AppMethodBeat.i(197486);
        AppMethodBeat.o(197486);
    }

    public TAVComposition(List<TAVClip> list) {
        this(list, list);
        AppMethodBeat.i(197487);
        AppMethodBeat.o(197487);
    }

    public TAVComposition(List<? extends TAVTransitionableVideo> list, List<? extends TAVTransitionableAudio> list2) {
        this();
        AppMethodBeat.i(197488);
        addVideoChannel(list);
        addAudioChannel(list2);
        AppMethodBeat.o(197488);
    }

    public TAVComposition() {
        AppMethodBeat.i(197489);
        this.videoChannels = new ArrayList();
        this.audioChannels = new ArrayList();
        this.backgroundColor = WebView.NIGHT_MODE_COLOR;
        AppMethodBeat.o(197489);
    }

    public CGSize getRenderSize() {
        return this.renderSize;
    }

    public void setRenderSize(CGSize cGSize) {
        this.renderSize = cGSize;
    }

    public VideoComposition.RenderLayoutMode getRenderLayoutMode() {
        return this.renderLayoutMode;
    }

    public void setRenderLayoutMode(VideoComposition.RenderLayoutMode renderLayoutMode2) {
        this.renderLayoutMode = renderLayoutMode2;
    }

    public int getBackgroundColor() {
        return this.backgroundColor;
    }

    public void setBackgroundColor(int i2) {
        this.backgroundColor = i2;
    }

    public CMTime getFrameDuration() {
        return this.frameDuration;
    }

    public void setFrameDuration(CMTime cMTime) {
        this.frameDuration = cMTime;
    }

    public List<List<? extends TAVTransitionableVideo>> getVideoChannels() {
        return this.videoChannels;
    }

    public void setVideoChannels(List<List<? extends TAVTransitionableVideo>> list) {
        this.videoChannels = list;
    }

    public List<List<? extends TAVTransitionableAudio>> getAudioChannels() {
        return this.audioChannels;
    }

    public void setAudioChannels(List<List<? extends TAVTransitionableAudio>> list) {
        this.audioChannels = list;
    }

    public void setOverlays(List<? extends TAVVideo> list) {
        this.overlays = list;
    }

    public void setAudios(List<? extends TAVAudio> list) {
        this.audios = list;
    }

    public TAVVideoEffect getSourceVideoEffect() {
        return this.sourceVideoEffect;
    }

    public void setSourceVideoEffect(TAVVideoEffect tAVVideoEffect) {
        this.sourceVideoEffect = tAVVideoEffect;
    }

    public TAVVideoMixEffect getVideoMixEffect() {
        return this.videoMixEffect;
    }

    public void setVideoMixEffect(TAVVideoMixEffect tAVVideoMixEffect) {
        this.videoMixEffect = tAVVideoMixEffect;
    }

    public TAVVideoEffect getGlobalVideoEffect() {
        return this.globalVideoEffect;
    }

    public void setGlobalVideoEffect(TAVVideoEffect tAVVideoEffect) {
        this.globalVideoEffect = tAVVideoEffect;
    }

    public void addVideoChannel(List<? extends TAVTransitionableVideo> list) {
        AppMethodBeat.i(197490);
        if (this.videoChannels == null) {
            this.videoChannels = new ArrayList();
        }
        this.videoChannels.add(new ArrayList(list));
        AppMethodBeat.o(197490);
    }

    public void addAudioChannel(List<? extends TAVTransitionableAudio> list) {
        AppMethodBeat.i(197491);
        if (this.audioChannels == null) {
            this.audioChannels = new ArrayList();
        }
        this.audioChannels.add(new ArrayList(list));
        AppMethodBeat.o(197491);
    }

    public void attachVideoEffectChain(IVideoEffectContext iVideoEffectContext) {
        AppMethodBeat.i(197492);
        this.sourceVideoEffect = iVideoEffectContext.getSourceVideoEffect();
        this.videoMixEffect = iVideoEffectContext.getVideoMixEffect();
        this.globalVideoEffect = iVideoEffectContext.getGlobalVideoEffect();
        AppMethodBeat.o(197492);
    }

    public List<? extends TAVVideo> getOverlays() {
        return this.overlays;
    }

    public List<? extends TAVAudio> getAudios() {
        return this.audios;
    }

    public CMTime getDuration() {
        CMTime cMTime;
        CMTime cMTime2;
        AppMethodBeat.i(197493);
        if (this.videoChannels == null) {
            CMTime cMTime3 = CMTime.CMTimeZero;
            AppMethodBeat.o(197493);
            return cMTime3;
        }
        int size = this.videoChannels.size();
        CMTime cMTime4 = CMTime.CMTimeZero;
        CMTime cMTime5 = CMTime.CMTimeZero;
        int i2 = 0;
        while (i2 < size) {
            List<? extends TAVTransitionableVideo> list = this.videoChannels.get(i2);
            if (list != null) {
                for (TAVTransitionableVideo tAVTransitionableVideo : list) {
                    if (tAVTransitionableVideo != null) {
                        cMTime2 = cMTime5.add(tAVTransitionableVideo.getDuration());
                    } else {
                        cMTime2 = cMTime5;
                    }
                    cMTime5 = cMTime2;
                }
                if (!cMTime5.bigThan(cMTime4)) {
                    cMTime5 = cMTime4;
                }
                cMTime = CMTime.CMTimeZero;
                cMTime4 = cMTime5;
            } else {
                cMTime = cMTime5;
            }
            i2++;
            cMTime5 = cMTime;
        }
        AppMethodBeat.o(197493);
        return cMTime4;
    }

    public String toString() {
        AppMethodBeat.i(197494);
        String str = "TAVComposition{\nrenderSize=" + this.renderSize + ", renderLayoutMode=" + this.renderLayoutMode + ", backgroundColor=" + this.backgroundColor + ", frameDuration=" + this.frameDuration + "\nvideoChannels=" + this.videoChannels + "\naudioChannels=" + this.audioChannels + "\noverlays=" + this.overlays + "\naudios=" + this.audios + '}';
        AppMethodBeat.o(197494);
        return str;
    }
}
