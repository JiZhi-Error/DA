package com.tencent.tav.core.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.core.AudioCompositionDecoderTrack;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.AudioInfo;
import com.tencent.tav.decoder.IDecoder;

public class AudioSourceComposition implements IAudioSource<AudioCompositionDecoderTrack> {
    private Asset mAsset;
    private AudioInfo mAudioInfo = new AudioInfo(44100, 1, 2);

    public AudioSourceComposition(Asset asset) {
        AppMethodBeat.i(217996);
        this.mAsset = asset;
        AppMethodBeat.o(217996);
    }

    @Override // com.tencent.tav.core.audio.IAudioSource
    public AudioCompositionDecoderTrack getSourceAudioDecoder(CMTimeRange cMTimeRange) {
        AppMethodBeat.i(217997);
        AudioCompositionDecoderTrack audioCompositionDecoderTrack = new AudioCompositionDecoderTrack(this.mAsset.getTracks(), -1);
        audioCompositionDecoderTrack.setAudioInfo(this.mAudioInfo);
        audioCompositionDecoderTrack.setDecodeType(IDecoder.DecodeType.Audio);
        audioCompositionDecoderTrack.setFrameRate(44);
        AppMethodBeat.o(217997);
        return audioCompositionDecoderTrack;
    }

    @Override // com.tencent.tav.core.audio.IAudioSource
    public CMTime getDuration() {
        AppMethodBeat.i(217998);
        CMTime duration = this.mAsset.getDuration();
        AppMethodBeat.o(217998);
        return duration;
    }
}
