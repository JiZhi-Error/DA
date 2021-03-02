package com.tencent.tav.core.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.asset.AssetTrack;
import com.tencent.tav.asset.AssetTrackSegment;
import com.tencent.tav.asset.CompositionTrackSegment;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.AudioDecoderTrack;
import com.tencent.tav.decoder.AudioInfo;
import com.tencent.tav.decoder.DecoderAssetTrack;
import com.tencent.tav.decoder.DecoderTrackSegment;
import com.tencent.tav.decoder.IDecoder;
import java.util.ArrayList;
import java.util.List;

class AudioSourceTrack implements IAudioSource<AudioDecoderTrack> {
    public static final String TAG = "AudioCompositionTrackEncoder2";
    private AssetTrack mAssetTrack;
    private AudioInfo mAudioInfo = new AudioInfo(44100, 1, 2);

    public AudioSourceTrack(AssetTrack assetTrack) {
        AppMethodBeat.i(218000);
        this.mAssetTrack = assetTrack;
        AppMethodBeat.o(218000);
    }

    private DecoderTrackSegment createDecoderTrackSegment(AssetTrack assetTrack, AssetTrackSegment assetTrackSegment) {
        AppMethodBeat.i(218001);
        DecoderAssetTrack decoderAssetTrack = null;
        if (!assetTrackSegment.isEmpty()) {
            decoderAssetTrack = new DecoderAssetTrack();
            decoderAssetTrack.assetPath = assetTrack.getSourcePath();
            decoderAssetTrack.trackId = assetTrack.getTrackID();
            decoderAssetTrack.mediaType = assetTrack.getMediaType();
            decoderAssetTrack.size = assetTrack.getNaturalSize();
            decoderAssetTrack.preferredTransform = assetTrack.getPreferredTransform();
            decoderAssetTrack.preferredVolume = assetTrack.getPreferredVolume();
            decoderAssetTrack.frameRate = (int) assetTrack.getNominalFrameRate();
        }
        CMTimeRange source = assetTrackSegment.getTimeMapping().getSource();
        DecoderTrackSegment decoderTrackSegment = new DecoderTrackSegment(new CMTimeRange(source.getStart(), source.getDuration()), decoderAssetTrack);
        decoderTrackSegment.setScaledDuration(assetTrackSegment.getScaleDuration());
        AppMethodBeat.o(218001);
        return decoderTrackSegment;
    }

    private DecoderTrackSegment createDecoderTrackSegment(AssetTrack assetTrack, CompositionTrackSegment compositionTrackSegment) {
        AppMethodBeat.i(218002);
        DecoderAssetTrack decoderAssetTrack = null;
        if (!compositionTrackSegment.isEmpty()) {
            decoderAssetTrack = new DecoderAssetTrack();
            decoderAssetTrack.trackId = compositionTrackSegment.getSourceTrackID();
            decoderAssetTrack.mediaType = assetTrack.getMediaType();
            decoderAssetTrack.assetPath = compositionTrackSegment.getSourcePath();
            decoderAssetTrack.preferredTransform = assetTrack.getPreferredTransform();
            decoderAssetTrack.size = assetTrack.getNaturalSize();
            decoderAssetTrack.frameRate = (int) assetTrack.getNominalFrameRate();
            decoderAssetTrack.preferredVolume = assetTrack.getPreferredVolume();
        }
        CMTimeRange source = compositionTrackSegment.getTimeMapping().getSource();
        DecoderTrackSegment decoderTrackSegment = new DecoderTrackSegment(new CMTimeRange(source.getStart(), source.getDuration()), decoderAssetTrack);
        decoderTrackSegment.setScaledDuration(compositionTrackSegment.getScaleDuration());
        AppMethodBeat.o(218002);
        return decoderTrackSegment;
    }

    @Override // com.tencent.tav.core.audio.IAudioSource
    public AudioDecoderTrack getSourceAudioDecoder(CMTimeRange cMTimeRange) {
        AppMethodBeat.i(218003);
        AudioDecoderTrack audioDecoderTrack = new AudioDecoderTrack();
        if (this.mAssetTrack.getMediaType() == 2) {
            AudioDecoderTrack audioDecoderTrack2 = new AudioDecoderTrack();
            List<AssetTrackSegment> segments = this.mAssetTrack.getSegments();
            ArrayList arrayList = new ArrayList();
            for (AssetTrackSegment assetTrackSegment : segments) {
                if (assetTrackSegment instanceof CompositionTrackSegment) {
                    arrayList.add(createDecoderTrackSegment(this.mAssetTrack, (CompositionTrackSegment) assetTrackSegment));
                } else {
                    arrayList.add(createDecoderTrackSegment(this.mAssetTrack, assetTrackSegment));
                }
            }
            audioDecoderTrack2.setTrackID(this.mAssetTrack.getTrackID());
            audioDecoderTrack2.setTrackSegments(arrayList);
            audioDecoderTrack2.setFrameRate((int) this.mAssetTrack.getNominalFrameRate());
            audioDecoderTrack2.setVolume(this.mAssetTrack.getPreferredVolume());
            audioDecoderTrack2.setDecodeType(IDecoder.DecodeType.Audio);
            audioDecoderTrack2.setAudioInfo(this.mAudioInfo);
            audioDecoderTrack2.clipRangeAndClearRange(new CMTimeRange(CMTime.CMTimeZero, cMTimeRange.getEnd()));
            AppMethodBeat.o(218003);
            return audioDecoderTrack;
        }
        AppMethodBeat.o(218003);
        return null;
    }

    @Override // com.tencent.tav.core.audio.IAudioSource
    public CMTime getDuration() {
        AppMethodBeat.i(218004);
        CMTime duration = this.mAssetTrack.getDuration();
        AppMethodBeat.o(218004);
        return duration;
    }
}
