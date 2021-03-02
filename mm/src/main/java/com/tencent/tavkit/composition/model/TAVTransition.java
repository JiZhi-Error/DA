package com.tencent.tavkit.composition.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.core.MutableAudioMixInputParameters;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.composition.audio.TAVAudioTransition;
import com.tencent.tavkit.composition.video.TAVVideoTransition;

public class TAVTransition {
    private TAVAudioTransition audioTransition;
    private CMTime duration;
    private TAVVideoTransition videoTransition;

    public TAVTransition(CMTime cMTime) {
        AppMethodBeat.i(197568);
        this.duration = cMTime;
        this.audioTransition = new EmptyAudioTransition(cMTime);
        this.videoTransition = new EmptyVideoTransition(cMTime);
        AppMethodBeat.o(197568);
    }

    public TAVAudioTransition getAudioTransition() {
        return this.audioTransition;
    }

    public void setAudioTransition(TAVAudioTransition tAVAudioTransition) {
        this.audioTransition = tAVAudioTransition;
    }

    public TAVVideoTransition getVideoTransition() {
        return this.videoTransition;
    }

    public void setVideoTransition(TAVVideoTransition tAVVideoTransition) {
        this.videoTransition = tAVVideoTransition;
    }

    public CMTime getDuration() {
        return this.duration;
    }

    static class EmptyAudioTransition implements TAVAudioTransition {
        private CMTime duration;
        private String identifier;

        EmptyAudioTransition(CMTime cMTime) {
            this.duration = cMTime;
        }

        @Override // com.tencent.tavkit.composition.audio.TAVAudioTransition
        public String getIdentifier() {
            return this.identifier;
        }

        @Override // com.tencent.tavkit.composition.audio.TAVAudioTransition
        public void setIdentifier(String str) {
            this.identifier = str;
        }

        @Override // com.tencent.tavkit.composition.audio.TAVAudioTransition
        public CMTime getDuration() {
            return this.duration;
        }

        @Override // com.tencent.tavkit.composition.audio.TAVAudioTransition
        public void applyPreviousAudioMixInputParameters(MutableAudioMixInputParameters mutableAudioMixInputParameters, CMTimeRange cMTimeRange) {
        }

        @Override // com.tencent.tavkit.composition.audio.TAVAudioTransition
        public void applyNextAudioMixInputParameters(MutableAudioMixInputParameters mutableAudioMixInputParameters, CMTimeRange cMTimeRange) {
        }
    }

    static class EmptyVideoTransition implements TAVVideoTransition {
        private CMTime duration;

        public EmptyVideoTransition(CMTime cMTime) {
            this.duration = cMTime;
        }

        @Override // com.tencent.tavkit.composition.video.TAVVideoTransition
        public String effectId() {
            AppMethodBeat.i(197567);
            String obj = toString();
            AppMethodBeat.o(197567);
            return obj;
        }

        @Override // com.tencent.tavkit.composition.video.TAVVideoTransition
        public CMTime getDuration() {
            return this.duration;
        }

        @Override // com.tencent.tavkit.composition.video.TAVVideoTransition
        public TAVVideoTransition.Filter createFilter() {
            return null;
        }
    }
}
