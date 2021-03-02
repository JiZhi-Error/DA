package com.tencent.tavkit.composition;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.core.AudioMix;
import com.tencent.tav.core.composition.VideoComposition;

public class TAVSource {
    private Asset asset;
    private AudioMix audioMix;
    private VideoComposition videoComposition;

    public Asset getAsset() {
        return this.asset;
    }

    public void setAsset(Asset asset2) {
        this.asset = asset2;
    }

    public VideoComposition getVideoComposition() {
        return this.videoComposition;
    }

    public AudioMix getAudioMix() {
        return this.audioMix;
    }

    public void setVideoComposition(VideoComposition videoComposition2) {
        this.videoComposition = videoComposition2;
    }

    public void setAudioMix(AudioMix audioMix2) {
        this.audioMix = audioMix2;
    }

    public String toString() {
        AppMethodBeat.i(197495);
        String str = "TAVSource{\nasset=" + this.asset + "\nvideoComposition=" + this.videoComposition + "\naudioMix=" + this.audioMix + '}';
        AppMethodBeat.o(197495);
        return str;
    }
}
