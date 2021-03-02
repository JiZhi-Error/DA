package com.tencent.tav.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.asset.AssetTrack;
import com.tencent.tav.asset.AssetTrackSegment;
import com.tencent.tav.asset.CompositionTrackSegment;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMSampleState;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.AudioDecoderTrack;
import com.tencent.tav.decoder.AudioInfo;
import com.tencent.tav.decoder.AudioMixer;
import com.tencent.tav.decoder.DecoderAssetTrack;
import com.tencent.tav.decoder.DecoderTrackSegment;
import com.tencent.tav.decoder.IDecoder;
import com.tencent.tav.decoder.IDecoderTrack;
import com.tencent.tav.decoder.ReActionThread;
import com.tencent.tav.decoder.logger.Logger;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class AudioCompositionDecoderTrack implements IDecoderTrack {
    private static final String TAG = "AudioCompositionDecoder";
    private CMSampleBuffer _lastReadAudioBuffer;
    private HashMap<Integer, AudioCompositor> audioCompositorMap = new HashMap<>();
    private AudioInfo audioInfo = new AudioInfo();
    private AudioMix audioMix;
    private List<AssetTrack> audioTracks = new ArrayList();
    private boolean decoderStarted = false;
    private final DecoderThread decoderThread = new DecoderThread();
    private ArrayList<AudioDecoderTrack> decoderTrackList = new ArrayList<>();
    private AudioMixer mAudioMixer = new AudioMixer();
    private float rate = 1.0f;
    private float volume = 1.0f;

    static /* synthetic */ CMSampleBuffer access$200(AudioCompositionDecoderTrack audioCompositionDecoderTrack) {
        AppMethodBeat.i(217844);
        CMSampleBuffer doReadSample = audioCompositionDecoderTrack.doReadSample();
        AppMethodBeat.o(217844);
        return doReadSample;
    }

    public AudioCompositionDecoderTrack(List<AssetTrack> list, int i2) {
        AppMethodBeat.i(217821);
        this.audioTracks = list;
        initAudioDecodeTracks(null);
        initAudioMix();
        AppMethodBeat.o(217821);
    }

    public AudioCompositionDecoderTrack(int i2) {
        AppMethodBeat.i(217822);
        initAudioDecodeTracks(null);
        initAudioMix();
        AppMethodBeat.o(217822);
    }

    public void setRate(float f2) {
        this.rate = f2;
    }

    public synchronized void addTrack(AssetTrack assetTrack) {
        AppMethodBeat.i(217823);
        this.audioTracks.add(assetTrack);
        AppMethodBeat.o(217823);
    }

    public synchronized void removeTrack(AssetTrack assetTrack) {
        AppMethodBeat.i(217824);
        this.audioTracks.remove(assetTrack);
        AppMethodBeat.o(217824);
    }

    public void setAudioMix(AudioMix audioMix2) {
        this.audioMix = audioMix2;
    }

    public void setAudioInfo(AudioInfo audioInfo2) {
        AppMethodBeat.i(217825);
        this.audioInfo = audioInfo2.clone();
        this.mAudioMixer = new AudioMixer(audioInfo2.sampleRate, audioInfo2.channelCount);
        Iterator<AudioDecoderTrack> it = this.decoderTrackList.iterator();
        while (it.hasNext()) {
            it.next().setAudioInfo(audioInfo2);
        }
        for (AudioCompositor audioCompositor : this.audioCompositorMap.values()) {
            audioCompositor.setAudioInfo(audioInfo2);
        }
        AppMethodBeat.o(217825);
    }

    private void initAudioDecodeTracks(CMTimeRange cMTimeRange) {
        AppMethodBeat.i(217826);
        if (this.audioTracks == null) {
            AppMethodBeat.o(217826);
            return;
        }
        synchronized (this) {
            try {
                this.decoderTrackList.clear();
            } finally {
                AppMethodBeat.o(217826);
            }
        }
        AudioDecoderTrack audioDecoderTrack = new AudioDecoderTrack();
        ArrayList arrayList = new ArrayList();
        arrayList.add(createDecoderTrackSegment((AssetTrack) null, new CompositionTrackSegment(new CMTimeRange(CMTime.CMTimeZero, cMTimeRange == null ? getDuration() : cMTimeRange.getDuration()))));
        audioDecoderTrack.setTrackID(0);
        audioDecoderTrack.setTrackSegments(arrayList);
        audioDecoderTrack.setVolume(0.0f);
        audioDecoderTrack.setDecodeType(IDecoder.DecodeType.Audio);
        audioDecoderTrack.setAudioInfo(this.audioInfo);
        this.decoderTrackList.add(audioDecoderTrack);
        for (AssetTrack assetTrack : this.audioTracks) {
            if (assetTrack.getMediaType() == 2) {
                AudioDecoderTrack audioDecoderTrack2 = new AudioDecoderTrack();
                AudioCompositor audioCompositor = new AudioCompositor(this.audioInfo);
                List<AssetTrackSegment> segments = assetTrack.getSegments();
                ArrayList arrayList2 = new ArrayList();
                for (AssetTrackSegment assetTrackSegment : segments) {
                    if (assetTrackSegment instanceof CompositionTrackSegment) {
                        arrayList2.add(createDecoderTrackSegment(assetTrack, (CompositionTrackSegment) assetTrackSegment));
                    } else {
                        arrayList2.add(createDecoderTrackSegment(assetTrack, assetTrackSegment));
                    }
                }
                audioDecoderTrack2.setTrackID(assetTrack.getTrackID());
                audioDecoderTrack2.setTrackSegments(arrayList2);
                audioDecoderTrack2.setFrameRate((int) assetTrack.getNominalFrameRate());
                audioDecoderTrack2.setVolume(assetTrack.getPreferredVolume());
                audioDecoderTrack2.setDecodeType(IDecoder.DecodeType.Audio);
                audioDecoderTrack2.setAudioInfo(this.audioInfo);
                if (assetTrack.getTimeRange() != null) {
                    audioDecoderTrack2.clipRangeAndClearRange(new CMTimeRange(assetTrack.getTimeRange().getStart(), assetTrack.getTimeRange().getDuration()));
                }
                this.decoderTrackList.add(audioDecoderTrack2);
                this.audioCompositorMap.put(Integer.valueOf(assetTrack.getTrackID()), audioCompositor);
            }
        }
    }

    private void initAudioMix() {
        AppMethodBeat.i(217827);
        if (this.audioTracks != null && this.audioTracks.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (AssetTrack assetTrack : this.audioTracks) {
                if (assetTrack != null) {
                    MutableAudioMixInputParameters mutableAudioMixInputParameters = new MutableAudioMixInputParameters(assetTrack, null);
                    mutableAudioMixInputParameters.setVolumeForTimeRange(assetTrack.getPreferredVolume(), assetTrack.getTimeRange());
                    arrayList.add(mutableAudioMixInputParameters);
                }
            }
            this.audioMix = new AudioMix(arrayList);
        }
        AppMethodBeat.o(217827);
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void start() {
        AppMethodBeat.i(217828);
        start(null);
        AppMethodBeat.o(217828);
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void start(IDecoderTrack.SurfaceCreator surfaceCreator) {
        AppMethodBeat.i(217829);
        start(surfaceCreator, null);
        AppMethodBeat.o(217829);
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void start(IDecoderTrack.SurfaceCreator surfaceCreator, CMTimeRange cMTimeRange) {
        CMTimeRange cMTimeRange2;
        AppMethodBeat.i(217830);
        Logger.d(TAG, "start: ".concat(String.valueOf(cMTimeRange)));
        if (!this.decoderStarted) {
            Logger.d(TAG, "start: ".concat(String.valueOf(this)));
            this.decoderThread.start();
            initAudioDecodeTracks(cMTimeRange);
            this.decoderStarted = true;
            CMTimeRange cMTimeRange3 = null;
            for (int i2 = 0; i2 < this.decoderTrackList.size(); i2++) {
                if (i2 <= 0 || i2 - 1 >= this.audioTracks.size()) {
                    cMTimeRange2 = new CMTimeRange(CMTime.CMTimeZero, getDuration());
                } else {
                    AssetTrack assetTrack = this.audioTracks.get(i2 - 1);
                    if (assetTrack == null || assetTrack.getTimeRange() == null) {
                        cMTimeRange2 = cMTimeRange3;
                    } else {
                        cMTimeRange2 = new CMTimeRange(assetTrack.getTimeRange().getStart(), assetTrack.getTimeRange().getDuration());
                    }
                }
                cMTimeRange3 = cMTimeRange2;
                this.decoderTrackList.get(i2).start(null, cMTimeRange3);
            }
        }
        AppMethodBeat.o(217830);
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void setFrameRate(int i2) {
        AppMethodBeat.i(217831);
        Iterator<AudioDecoderTrack> it = this.decoderTrackList.iterator();
        while (it.hasNext()) {
            it.next().setFrameRate(i2);
        }
        AppMethodBeat.o(217831);
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public int getFrameRate() {
        return 0;
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public CMTime getFrameDuration() {
        return CMTime.CMTimeZero;
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void setVolume(float f2) {
        List<AudioMixInputParameters> inputParameters;
        AppMethodBeat.i(217832);
        Logger.i(TAG, "setVolume: ".concat(String.valueOf(f2)));
        if (!(this.audioMix == null || (inputParameters = this.audioMix.getInputParameters()) == null)) {
            for (AudioMixInputParameters audioMixInputParameters : inputParameters) {
                if (audioMixInputParameters != null && (audioMixInputParameters instanceof MutableAudioMixInputParameters)) {
                    ((MutableAudioMixInputParameters) audioMixInputParameters).setVolumeForTimeRange(f2);
                }
            }
        }
        this.volume = f2;
        AppMethodBeat.o(217832);
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public int getTrackId() {
        return 0;
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void setDecodeType(IDecoder.DecodeType decodeType) {
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void setTrackSegments(List<DecoderTrackSegment> list) {
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void clipRangeAndClearRange(CMTimeRange cMTimeRange) {
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public CMSampleBuffer seekTo(CMTime cMTime, boolean z, boolean z2) {
        AppMethodBeat.i(217833);
        Logger.v(TAG, "seekTo:[timeUs " + cMTime + "] [needRead " + z + "] [quickSeek " + z2 + "]");
        synchronized (this.decoderThread.nextFrameDecoderLock) {
            try {
                this.decoderThread.pcmFrame = null;
            } finally {
                AppMethodBeat.o(217833);
            }
        }
        Iterator<AudioDecoderTrack> it = this.decoderTrackList.iterator();
        while (it.hasNext()) {
            AudioDecoderTrack next = it.next();
            Logger.v(TAG, "seekTo: ".concat(String.valueOf(next)));
            next.seekTo(cMTime, false, z2);
        }
        synchronized (this) {
            try {
                this._lastReadAudioBuffer = null;
                for (AudioCompositor audioCompositor : this.audioCompositorMap.values()) {
                    audioCompositor.clear();
                }
            } finally {
                AppMethodBeat.o(217833);
            }
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003e, code lost:
        r0 = doReadSample();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0042, code lost:
        if (r0 == null) goto L_0x005b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0048, code lost:
        if (r0.getSampleByteBuffer() == null) goto L_0x005b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004a, code lost:
        r0.setSampleByteBuffer(processFrame(r0.getSampleByteBuffer(), r6.volume, r6.rate, r6.audioInfo));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x005b, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(217834);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        return r0;
     */
    @Override // com.tencent.tav.decoder.IDecoderTrack
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.tencent.tav.coremedia.CMSampleBuffer readSample() {
        /*
        // Method dump skipped, instructions count: 101
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tav.core.AudioCompositionDecoderTrack.readSample():com.tencent.tav.coremedia.CMSampleBuffer");
    }

    private synchronized CMSampleBuffer doReadSample() {
        ByteBuffer byteBuffer;
        CMSampleBuffer cMSampleBuffer;
        AppMethodBeat.i(217835);
        Logger.v(TAG, "doReadSample: start ");
        if (this.decoderTrackList.isEmpty()) {
            Logger.e(TAG, "doReadSample:[finish] decoderTrackList.isEmpty ");
            cMSampleBuffer = new CMSampleBuffer(CMSampleState.fromError(-100));
            AppMethodBeat.o(217835);
        } else {
            AudioDecoderTrack audioDecoderTrack = this.decoderTrackList.get(0);
            CMSampleBuffer readSample = audioDecoderTrack.readSample();
            if (readSample.getState().getStateCode() < -1) {
                Logger.e(TAG, "doReadSample:[failed]");
                AppMethodBeat.o(217835);
                cMSampleBuffer = readSample;
            } else {
                this._lastReadAudioBuffer = readSample;
                ByteBuffer sampleByteBuffer = this._lastReadAudioBuffer.getSampleByteBuffer();
                if (this._lastReadAudioBuffer.getSampleByteBuffer() == null) {
                    byteBuffer = audioDecoderTrack.getEmptyAudioBuffer();
                } else {
                    byteBuffer = sampleByteBuffer;
                }
                if (byteBuffer != null) {
                    byteBuffer.position(0);
                }
                CMSampleBuffer cMSampleBuffer2 = new CMSampleBuffer(this._lastReadAudioBuffer.getTime(), byteBuffer);
                int size = this.decoderTrackList.size() - 1;
                while (true) {
                    if (size <= 0) {
                        cMSampleBuffer = cMSampleBuffer2;
                        break;
                    }
                    AudioDecoderTrack audioDecoderTrack2 = this.decoderTrackList.get(size);
                    AudioCompositor audioCompositor = this.audioCompositorMap.get(Integer.valueOf(audioDecoderTrack2.getTrackID()));
                    if (audioCompositor != null) {
                        Logger.v(TAG, "doReadSample: readMergeSample ".concat(String.valueOf(size)));
                        cMSampleBuffer = audioCompositor.readMergeSample(audioDecoderTrack2, this.audioMix != null ? this.audioMix.getInputParametersWithTrackID(audioDecoderTrack2.getTrackID()) : null, cMSampleBuffer2);
                        Logger.v(TAG, "doReadSample: readMergeSample finish ".concat(String.valueOf(size)));
                        if (cMSampleBuffer != null && cMSampleBuffer.getState().getStateCode() < -1) {
                            break;
                        }
                    } else {
                        Logger.e(TAG, "doReadSample: audioCompositorMap.get(decoderTrack.getTrackID(), return null!");
                        cMSampleBuffer = cMSampleBuffer2;
                    }
                    size--;
                    cMSampleBuffer2 = cMSampleBuffer;
                }
                Logger.v(TAG, "doReadSample:[success]  " + (cMSampleBuffer == null ? null : cMSampleBuffer.getTime()));
                AppMethodBeat.o(217835);
            }
        }
        return cMSampleBuffer;
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public CMSampleBuffer readSample(CMTime cMTime) {
        AppMethodBeat.i(217836);
        CMSampleBuffer readSample = readSample();
        AppMethodBeat.o(217836);
        return readSample;
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void asyncReadNextSample(CMTime cMTime) {
        AppMethodBeat.i(217837);
        Logger.v(TAG, "asyncReadNextSample: ".concat(String.valueOf(cMTime)));
        if (this.decoderThread.pcmFrame == null) {
            synchronized (this.decoderThread.nextFrameDecoderLock) {
                try {
                    if (this.decoderThread.pcmFrame == null) {
                        this.decoderThread.action();
                    }
                } finally {
                    AppMethodBeat.o(217837);
                }
            }
            return;
        }
        AppMethodBeat.o(217837);
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public CMTime getDuration() {
        AppMethodBeat.i(217838);
        CMTime cMTime = CMTime.CMTimeZero;
        for (AssetTrack assetTrack : this.audioTracks) {
            cMTime = assetTrack.getDuration();
            if (!cMTime.bigThan(cMTime)) {
                cMTime = cMTime;
            }
        }
        AppMethodBeat.o(217838);
        return cMTime;
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public CMTime getCurrentSampleTime() {
        AppMethodBeat.i(217839);
        CMTime currentSampleTime = this.decoderTrackList.get(0).getCurrentSampleTime();
        AppMethodBeat.o(217839);
        return currentSampleTime;
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public synchronized void release() {
        AppMethodBeat.i(217840);
        Logger.d(TAG, "release: ".concat(String.valueOf(this)));
        Iterator<AudioDecoderTrack> it = this.decoderTrackList.iterator();
        while (it.hasNext()) {
            it.next().release();
        }
        this.decoderTrackList.clear();
        this.audioTracks.clear();
        this.decoderThread.release();
        Logger.d(TAG, "release: finish".concat(String.valueOf(this)));
        AppMethodBeat.o(217840);
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public long getLaggingTime() {
        return 0;
    }

    private DecoderTrackSegment createDecoderTrackSegment(AssetTrack assetTrack, AssetTrackSegment assetTrackSegment) {
        AppMethodBeat.i(217841);
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
        AppMethodBeat.o(217841);
        return decoderTrackSegment;
    }

    private DecoderTrackSegment createDecoderTrackSegment(AssetTrack assetTrack, CompositionTrackSegment compositionTrackSegment) {
        AppMethodBeat.i(217842);
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
        AppMethodBeat.o(217842);
        return decoderTrackSegment;
    }

    /* access modifiers changed from: package-private */
    public class DecoderThread extends ReActionThread {
        private static final String NAME = "AudioDecoderThread";
        private final Object nextFrameDecoderLock = new Object();
        private CMSampleBuffer pcmFrame;

        public DecoderThread() {
            super(NAME);
            AppMethodBeat.i(217818);
            AppMethodBeat.o(217818);
        }

        @Override // com.tencent.tav.decoder.ReActionThread
        public void run() {
            AppMethodBeat.i(217819);
            super.run();
            AppMethodBeat.o(217819);
        }

        @Override // com.tencent.tav.decoder.ReActionThread
        public void doAction() {
            AppMethodBeat.i(217820);
            synchronized (this.nextFrameDecoderLock) {
                try {
                    Logger.v(AudioCompositionDecoderTrack.TAG, "doAction: start ");
                    this.pcmFrame = AudioCompositionDecoderTrack.access$200(AudioCompositionDecoderTrack.this);
                    if (this.pcmFrame.getSampleByteBuffer() != null) {
                        this.pcmFrame.setSampleByteBuffer(AudioCompositionDecoderTrack.this.processFrame(this.pcmFrame.getSampleByteBuffer(), AudioCompositionDecoderTrack.this.volume, AudioCompositionDecoderTrack.this.rate, AudioCompositionDecoderTrack.this.audioInfo));
                    }
                    Logger.v(AudioCompositionDecoderTrack.TAG, "doAction: finish ");
                } finally {
                    AppMethodBeat.o(217820);
                }
            }
        }
    }

    public synchronized ByteBuffer processFrame(ByteBuffer byteBuffer, float f2, float f3, AudioInfo audioInfo2) {
        ByteBuffer processBytes;
        AppMethodBeat.i(217843);
        this.mAudioMixer.setAudioInfo(audioInfo2.sampleRate, audioInfo2.channelCount, audioInfo2.pcmEncoding);
        processBytes = this.mAudioMixer.processBytes(byteBuffer, f3, f2, 1.0f);
        AppMethodBeat.o(217843);
        return processBytes;
    }
}
