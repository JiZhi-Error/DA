package com.tencent.tav.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.asset.AssetTrack;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMSampleState;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.AudioInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AssetReaderAudioMixOutput extends AssetReaderOutput {
    public static final String TAG = "AssetReaderAudioMixOutput";
    private AssetReader assetReader;
    private AudioCompositionDecoderTrack audioCompositionDecoderTrack;
    private Map<String, Object> audioSettings;
    private ArrayList<AssetTrack> audioTracks;
    private boolean decoderStarted = false;

    public AssetReaderAudioMixOutput(ArrayList<AssetTrack> arrayList, Map<String, Object> map) {
        AppMethodBeat.i(217777);
        this.audioTracks = arrayList;
        this.audioSettings = map;
        this.audioCompositionDecoderTrack = new AudioCompositionDecoderTrack(arrayList, 2);
        AppMethodBeat.o(217777);
    }

    public ArrayList<AssetTrack> getAudioTracks() {
        return this.audioTracks;
    }

    public Map<String, Object> getAudioSettings() {
        return this.audioSettings;
    }

    @Override // com.tencent.tav.core.AssetReaderOutput
    public CMSampleBuffer nextSampleBuffer() {
        AppMethodBeat.i(217778);
        CMSampleBuffer readSample = this.audioCompositionDecoderTrack.readSample();
        if (readSample.getTime().smallThan(this.assetReader.getTimeRange().getStart())) {
            AppMethodBeat.o(217778);
            return readSample;
        } else if (readSample.getTime().smallThan(this.assetReader.getTimeRange().getEnd())) {
            CMSampleBuffer cMSampleBuffer = new CMSampleBuffer(readSample.getTime().sub(this.assetReader.getTimeRange().getStart()), readSample.getSampleByteBuffer(), readSample.isNewFrame());
            AppMethodBeat.o(217778);
            return cMSampleBuffer;
        } else {
            CMSampleBuffer cMSampleBuffer2 = new CMSampleBuffer(CMSampleState.fromError(-1));
            AppMethodBeat.o(217778);
            return cMSampleBuffer2;
        }
    }

    public void setAudioInfo(AudioInfo audioInfo) {
        AppMethodBeat.i(217779);
        this.audioCompositionDecoderTrack.setAudioInfo(audioInfo);
        AppMethodBeat.o(217779);
    }

    @Override // com.tencent.tav.core.AssetReaderOutput
    public void resetForReadingTimeRanges(List<CMTimeRange> list) {
    }

    @Override // com.tencent.tav.core.AssetReaderOutput
    public void markConfigurationAsFinal() {
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.tav.core.AssetReaderOutput
    public void start(IContextCreate iContextCreate, AssetReader assetReader2) {
        AppMethodBeat.i(217780);
        this.assetReader = assetReader2;
        if (this.audioCompositionDecoderTrack != null && !this.decoderStarted) {
            this.audioCompositionDecoderTrack.start(null);
            this.audioCompositionDecoderTrack.seekTo(assetReader2.getTimeRange().getStart(), false, true);
            this.decoderStarted = true;
        }
        AppMethodBeat.o(217780);
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.tav.core.AssetReaderOutput
    public void release() {
        AppMethodBeat.i(217781);
        if (this.audioCompositionDecoderTrack != null) {
            this.audioCompositionDecoderTrack.release();
        }
        AppMethodBeat.o(217781);
    }

    public void setAudioMix(AudioMix audioMix) {
        AppMethodBeat.i(217782);
        if (this.audioCompositionDecoderTrack != null) {
            this.audioCompositionDecoderTrack.setAudioMix(audioMix);
        }
        AppMethodBeat.o(217782);
    }
}
