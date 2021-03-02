package com.tencent.tav.decoder;

import android.util.Log;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMSampleState;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.coremedia.TimeUtil;
import com.tencent.tav.decoder.IDecoder;
import com.tencent.tav.decoder.IDecoderTrack;
import com.tencent.tav.decoder.logger.Logger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AudioDecoderTrack implements IDecoderTrack {
    private static String TAG = "AudioDecoderTrack";
    private float _speed = 1.0f;
    private AudioInfo audioInfo = new AudioInfo();
    private AudioMixer audioMixer = new AudioMixer();
    private AudioDecoder currentDecoder;
    private final Object currentDecoderLock = new Object();
    private CMTime currentSegmentStartTime = CMTime.CMTimeZero;
    private IDecoder.DecodeType decodeType = IDecoder.DecodeType.Audio;
    private AudioDecoderCreateThread decoderCreateThread = null;
    private final DecoderThread decoderThread = new DecoderThread();
    private CMTime duration = CMTime.CMTimeZero;
    private ByteBuffer emptyAudioBuffer;
    private CMTime frameDuration = new CMTime(92880, 1000000);
    private int frameRate = 11;
    private boolean isEmptyFrame = false;
    private boolean isReleased = false;
    private CMSampleState lastSampleState = new CMSampleState();
    private DecoderWrapper nextDecoder;
    private final Object nextDecoderLock = new Object();
    private boolean preRead = false;
    private int segmentIndex = -1;
    private ArrayList<DecoderTrackSegment> segments = new ArrayList<>();
    private boolean started = false;
    private int trackID = -1;
    private float volume = 1.0f;

    static /* synthetic */ boolean access$1200(DecoderAssetTrack decoderAssetTrack, DecoderAssetTrack decoderAssetTrack2) {
        AppMethodBeat.i(218117);
        boolean isSameExtractor = isSameExtractor(decoderAssetTrack, decoderAssetTrack2);
        AppMethodBeat.o(218117);
        return isSameExtractor;
    }

    static /* synthetic */ CMSampleBuffer access$1700(AudioDecoderTrack audioDecoderTrack, CMTime cMTime) {
        AppMethodBeat.i(218118);
        CMSampleBuffer doReadSample = audioDecoderTrack.doReadSample(cMTime);
        AppMethodBeat.o(218118);
        return doReadSample;
    }

    public AudioDecoderTrack() {
        AppMethodBeat.i(218089);
        AppMethodBeat.o(218089);
    }

    public ByteBuffer outputBuffer() {
        AppMethodBeat.i(218090);
        if (this.isEmptyFrame) {
            ByteBuffer emptyAudioBuffer2 = getEmptyAudioBuffer();
            AppMethodBeat.o(218090);
            return emptyAudioBuffer2;
        } else if (this.currentDecoder == null) {
            AppMethodBeat.o(218090);
            return null;
        } else {
            ByteBuffer outputBuffer = this.currentDecoder.outputBuffer();
            AppMethodBeat.o(218090);
            return outputBuffer;
        }
    }

    public float speed() {
        return this._speed;
    }

    public int getTrackID() {
        return this.trackID;
    }

    public void setTrackID(int i2) {
        this.trackID = i2;
    }

    private int findSegmentIndexAt(CMTime cMTime, boolean z) {
        int i2;
        boolean z2 = false;
        AppMethodBeat.i(218091);
        CMTime cMTime2 = CMTime.CMTimeZero;
        Iterator<DecoderTrackSegment> it = this.segments.iterator();
        int i3 = 0;
        CMTime cMTime3 = cMTime2;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            CMTime scaledDuration = it.next().getScaledDuration();
            if (cMTime.compare(cMTime3) >= 0 && cMTime.smallThan(cMTime3.add(scaledDuration))) {
                z2 = true;
                break;
            }
            cMTime3 = cMTime3.add(scaledDuration);
            i3++;
        }
        if (z2 || cMTime != cMTime3 || i3 <= 0 || !z) {
            i2 = i3;
        } else {
            z2 = true;
            i2 = i3 - 1;
        }
        if (z2) {
            AppMethodBeat.o(218091);
            return i2;
        }
        AppMethodBeat.o(218091);
        return -1;
    }

    private CMTime getSegmentStartTime(int i2) {
        AppMethodBeat.i(218092);
        CMTime cMTime = CMTime.CMTimeZero;
        for (int i3 = 0; i3 < i2; i3++) {
            cMTime = CMTime.add(cMTime, this.segments.get(i3).getScaledDuration());
        }
        AppMethodBeat.o(218092);
        return cMTime;
    }

    public CMTime duration() {
        AppMethodBeat.i(218093);
        CMTime segmentStartTime = getSegmentStartTime(this.segments.size());
        AppMethodBeat.o(218093);
        return segmentStartTime;
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void start() {
        AppMethodBeat.i(218094);
        start(null);
        AppMethodBeat.o(218094);
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void start(IDecoderTrack.SurfaceCreator surfaceCreator) {
        AppMethodBeat.i(218095);
        start(surfaceCreator, null);
        AppMethodBeat.o(218095);
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void start(IDecoderTrack.SurfaceCreator surfaceCreator, CMTimeRange cMTimeRange) {
        AppMethodBeat.i(218096);
        if (this.segments.size() == 0) {
            release();
            AppMethodBeat.o(218096);
            return;
        }
        this.isReleased = false;
        this.decoderThread.start();
        this.started = true;
        this.segmentIndex = -1;
        clipRangeAndRemoveRange(cMTimeRange);
        nextSegment(true);
        AppMethodBeat.o(218096);
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void setFrameRate(int i2) {
        AppMethodBeat.i(218097);
        this.frameDuration = this.frameDuration.divide((float) (i2 / this.frameRate));
        this.frameRate = i2;
        AppMethodBeat.o(218097);
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public int getFrameRate() {
        return this.frameRate;
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public CMTime getFrameDuration() {
        return this.frameDuration;
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void setVolume(float f2) {
        this.volume = f2;
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public int getTrackId() {
        return this.trackID;
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void setDecodeType(IDecoder.DecodeType decodeType2) {
        this.decodeType = decodeType2;
    }

    public AudioInfo getAudioInfo() {
        AppMethodBeat.i(218098);
        if (this.currentDecoder != null) {
            AudioInfo audioInfo2 = this.currentDecoder.getAudioInfo();
            AppMethodBeat.o(218098);
            return audioInfo2;
        }
        AudioInfo audioInfo3 = this.audioInfo;
        AppMethodBeat.o(218098);
        return audioInfo3;
    }

    public void setAudioInfo(AudioInfo audioInfo2) {
        AppMethodBeat.i(218099);
        this.audioInfo = audioInfo2.clone();
        if (this.emptyAudioBuffer != null) {
            this.emptyAudioBuffer = null;
        }
        AppMethodBeat.o(218099);
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void clipRangeAndClearRange(CMTimeRange cMTimeRange) {
        AppMethodBeat.i(218100);
        if (cMTimeRange == null || cMTimeRange.getDurationUs() <= 0 || this.segments.size() == 0) {
            AppMethodBeat.o(218100);
            return;
        }
        CMTime start = cMTimeRange.getStart();
        CMTime end = cMTimeRange.getEnd();
        CMTime duration2 = duration();
        clipRangeAndRemoveRange(cMTimeRange);
        if (start.getValue() != 0) {
            this.segments.add(0, new DecoderTrackSegment(new CMTimeRange(CMTime.CMTimeZero, start), (DecoderAssetTrack) null));
        }
        if (end.getTimeUs() < duration2.getTimeUs()) {
            this.segments.add(new DecoderTrackSegment(new CMTimeRange(end, new CMTime(duration2.getTimeSeconds() - end.getTimeSeconds())), (DecoderAssetTrack) null));
        }
        AppMethodBeat.o(218100);
    }

    public void clipRangeAndRemoveRange(CMTimeRange cMTimeRange) {
        int i2;
        AppMethodBeat.i(218101);
        if (cMTimeRange == null || cMTimeRange.getDurationUs() <= 0 || this.segments.size() == 0) {
            AppMethodBeat.o(218101);
            return;
        }
        CMTime start = cMTimeRange.getStart();
        CMTime end = cMTimeRange.getEnd();
        int findSegmentIndexAt = findSegmentIndexAt(start, false);
        if (findSegmentIndexAt == -1) {
            AppMethodBeat.o(218101);
            return;
        }
        int findSegmentIndexAt2 = findSegmentIndexAt(end, false);
        if (findSegmentIndexAt2 == -1) {
            i2 = this.segments.size() - 1;
        } else if (getSegmentStartTime(findSegmentIndexAt2) == end) {
            i2 = findSegmentIndexAt2 - 1;
        } else {
            i2 = findSegmentIndexAt2;
        }
        CMTime segmentStartTime = getSegmentStartTime(findSegmentIndexAt);
        CMTime segmentStartTime2 = getSegmentStartTime(i2);
        DecoderTrackSegment decoderTrackSegment = this.segments.get(findSegmentIndexAt);
        DecoderTrackSegment decoderTrackSegment2 = this.segments.get(i2);
        CMTime sub = cMTimeRange.getEnd().sub(segmentStartTime2);
        decoderTrackSegment2.setTimeRange(new CMTimeRange(decoderTrackSegment2.getTimeRange().getStart(), sub.divide((((float) decoderTrackSegment2.getScaledDuration().getTimeUs()) * 1.0f) / ((float) decoderTrackSegment2.getTimeRange().getDurationUs()))));
        decoderTrackSegment2.setScaledDuration(sub);
        float timeUs = (((float) decoderTrackSegment.getScaledDuration().getTimeUs()) * 1.0f) / ((float) decoderTrackSegment.getTimeRange().getDurationUs());
        CMTime sub2 = cMTimeRange.getStart().sub(segmentStartTime);
        CMTime divide = sub2.divide(timeUs);
        decoderTrackSegment.setTimeRange(new CMTimeRange(decoderTrackSegment.getTimeRange().getStart().add(divide), decoderTrackSegment.getTimeRange().getDuration().sub(divide)));
        decoderTrackSegment.setScaledDuration(decoderTrackSegment.getScaledDuration().sub(sub2));
        for (int size = this.segments.size() - 1; size >= 0; size--) {
            if (size > i2 || size < findSegmentIndexAt) {
                this.segments.remove(size);
            }
        }
        AppMethodBeat.o(218101);
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void setTrackSegments(List<DecoderTrackSegment> list) {
        AppMethodBeat.i(218102);
        if (this.segments == null) {
            this.segments = new ArrayList<>();
        }
        this.segments.clear();
        this.segments.addAll(list);
        AppMethodBeat.o(218102);
    }

    /* JADX WARNING: Removed duplicated region for block: B:76:0x01b8 A[SYNTHETIC, Splitter:B:76:0x01b8] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized com.tencent.tav.decoder.IDecoder createDecoder(com.tencent.tav.decoder.DecoderTrackSegment r9, com.tencent.tav.coremedia.CMTime r10) {
        /*
        // Method dump skipped, instructions count: 471
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tav.decoder.AudioDecoderTrack.createDecoder(com.tencent.tav.decoder.DecoderTrackSegment, com.tencent.tav.coremedia.CMTime):com.tencent.tav.decoder.IDecoder");
    }

    private boolean nextSegment(boolean z) {
        boolean z2;
        AppMethodBeat.i(218104);
        Logger.d(TAG, "nextSegment:".concat(String.valueOf(z)));
        this.segmentIndex++;
        if (this.segmentIndex >= this.segments.size()) {
            this.segmentIndex = -1;
            AppMethodBeat.o(218104);
            return false;
        }
        this.currentSegmentStartTime = getSegmentStartTime(this.segmentIndex);
        this.lastSampleState = new CMSampleState(this.currentSegmentStartTime);
        if (this.lastSampleState.getTime().equalsTo(CMTime.CMTimeZero)) {
            this.lastSampleState = new CMSampleState();
        }
        DecoderTrackSegment decoderTrackSegment = this.segments.get(this.segmentIndex);
        if (decoderTrackSegment.getVideoAsset() != null) {
            synchronized (this.currentDecoderLock) {
                try {
                    if (!(this.currentDecoder == null || this.currentDecoder.getSourcePath() == null)) {
                        new ReleaseDecoderThread(this.currentDecoder).start();
                        this.currentDecoder = null;
                    }
                } finally {
                    AppMethodBeat.o(218104);
                }
            }
            IDecoder createDecoder = createDecoder(decoderTrackSegment, z ? this.segments.get(this.segmentIndex).getDecoderStartTime() : CMTime.CMTimeInvalid);
            synchronized (this.currentDecoderLock) {
                try {
                    this.currentDecoder = (AudioDecoder) createDecoder;
                    if (this.audioMixer != null) {
                        this.audioMixer.release();
                    }
                    this.audioMixer = new AudioMixer();
                    if (this.currentDecoder != null && this.currentDecoder.hasTrack() && z) {
                        this.currentDecoder.seekTo(decoderTrackSegment.getDecoderStartTime());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } else {
            Logger.d(TAG, "nextSegment: videoAsset is null");
            synchronized (this.currentDecoderLock) {
                try {
                    if (this.currentDecoder != null) {
                        new ReleaseDecoderThread(this.currentDecoder).start();
                        this.currentDecoder = null;
                    }
                } catch (Throwable th2) {
                    AppMethodBeat.o(218104);
                    throw th2;
                }
            }
        }
        if (decoderTrackSegment.getScaledDuration().getTimeUs() > 0) {
            this._speed = (((float) decoderTrackSegment.getTimeRange().getDurationUs()) * 1.0f) / ((float) decoderTrackSegment.getScaledDuration().getTimeUs());
        }
        String str = TAG;
        StringBuilder sb = new StringBuilder("nextSegment:");
        if (this.currentDecoder == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Logger.d(str, sb.append(z2).append(" ").append(this._speed).toString());
        AppMethodBeat.o(218104);
        return true;
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public CMSampleBuffer seekTo(CMTime cMTime, boolean z, boolean z2) {
        AppMethodBeat.i(218105);
        Logger.v(TAG, "seekTo:[time " + cMTime + "] [needRead " + z + "] [quickSeek " + z2 + "]");
        if (this.isReleased) {
            Logger.e(TAG, "seekTo: [failed] has released");
            CMSampleBuffer cMSampleBuffer = new CMSampleBuffer(CMSampleState.fromError(-1));
            AppMethodBeat.o(218105);
            return cMSampleBuffer;
        }
        synchronized (this.decoderThread.nextFrameDecoderLock) {
            try {
                this.decoderThread.pcmFrame = null;
            } catch (Throwable th) {
                AppMethodBeat.o(218105);
                throw th;
            }
        }
        if (!this.started) {
            Logger.w(TAG, "seekTo: [failed] un started, stack = " + Log.getStackTraceString(new RuntimeException()));
            AppMethodBeat.o(218105);
            return null;
        }
        int findSegmentIndexAt = findSegmentIndexAt(cMTime, true);
        if (findSegmentIndexAt == -1) {
            this.segmentIndex = -1;
            Logger.e(TAG, "seekTo: [failed] segmentIndex = -1");
            AppMethodBeat.o(218105);
            return null;
        }
        CMTime segmentStartTime = getSegmentStartTime(findSegmentIndexAt);
        if (this.segmentIndex != findSegmentIndexAt || this.currentDecoder == null) {
            this.segmentIndex = findSegmentIndexAt - 1;
            nextSegment(false);
        }
        CMTime multi = cMTime.sub(segmentStartTime).multi(this._speed);
        DecoderTrackSegment decoderTrackSegment = this.segments.get(this.segmentIndex);
        if (this.currentDecoder == null) {
            this.lastSampleState = new CMSampleState(cMTime);
            Logger.d(TAG, "seekTo: [failed] currentDecoder == null ");
            AppMethodBeat.o(218105);
            return null;
        }
        this.currentDecoder.seekTo(decoderTrackSegment.getDecoderStartTime().add(multi));
        if (cMTime.bigThan(this.frameDuration)) {
            this.lastSampleState = new CMSampleState(cMTime.sub(this.frameDuration));
        } else {
            this.lastSampleState = new CMSampleState(cMTime);
        }
        Logger.v(TAG, "seekTo: [success] [lastSampleState " + this.lastSampleState + "]");
        AppMethodBeat.o(218105);
        return null;
    }

    public ByteBuffer getEmptyAudioBuffer() {
        AppMethodBeat.i(218106);
        if (this.emptyAudioBuffer == null) {
            long timeUs = (((long) (this.audioInfo.channelCount * this.audioInfo.sampleRate)) * this.frameDuration.getTimeUs()) / TimeUtil.SECOND_TO_US;
            this.emptyAudioBuffer = ByteBuffer.allocate(((int) timeUs) * 2);
            this.emptyAudioBuffer.order(ByteOrder.LITTLE_ENDIAN);
            short[] sArr = new short[((int) timeUs)];
            for (int i2 = 0; ((long) i2) < timeUs; i2++) {
                sArr[i2] = 0;
            }
            this.emptyAudioBuffer.asShortBuffer().put(sArr, 0, (int) timeUs);
        }
        this.emptyAudioBuffer.position(0);
        ByteBuffer byteBuffer = this.emptyAudioBuffer;
        AppMethodBeat.o(218106);
        return byteBuffer;
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public CMSampleBuffer readSample() {
        AppMethodBeat.i(218107);
        CMSampleBuffer readSample = readSample(CMTime.CMTimeInvalid);
        AppMethodBeat.o(218107);
        return readSample;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x008f, code lost:
        r0 = doReadSample(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0097, code lost:
        if (r0.getSampleByteBuffer() == null) goto L_0x0113;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x00a0, code lost:
        if (r6._speed <= 0.1f) goto L_0x0113;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00a8, code lost:
        if (r6._speed >= 16.0f) goto L_0x0113;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00aa, code lost:
        com.tencent.tav.decoder.logger.Logger.v(com.tencent.tav.decoder.AudioDecoderTrack.TAG, "readSample: processFrame [volume " + r6.volume + "] [_speed " + r6._speed + "]");
        r0.setSampleByteBuffer(processFrame(r0.getSampleByteBuffer(), r6.volume, r6._speed, getAudioInfo()));
        com.tencent.tav.decoder.logger.Logger.v(com.tencent.tav.decoder.AudioDecoderTrack.TAG, "readSample: processFrame finish [volume " + r6.volume + "] [_speed " + r6._speed + "]");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0113, code lost:
        r6.lastSampleState = r0.getState();
        createNextDecoder(r6.segmentIndex);
        com.tencent.tav.decoder.logger.Logger.v(com.tencent.tav.decoder.AudioDecoderTrack.TAG, "readSample: [success]  - " + r6.lastSampleState);
        com.tencent.matrix.trace.core.AppMethodBeat.o(218108);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        return r0;
     */
    @Override // com.tencent.tav.decoder.IDecoderTrack
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.tencent.tav.coremedia.CMSampleBuffer readSample(com.tencent.tav.coremedia.CMTime r7) {
        /*
        // Method dump skipped, instructions count: 320
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tav.decoder.AudioDecoderTrack.readSample(com.tencent.tav.coremedia.CMTime):com.tencent.tav.coremedia.CMSampleBuffer");
    }

    private CMSampleBuffer doReadSample(CMTime cMTime) {
        CMSampleBuffer cMSampleBuffer;
        CMTime cMTime2;
        ByteBuffer byteBuffer = null;
        AppMethodBeat.i(218109);
        synchronized (this) {
            try {
                if (this.isReleased) {
                    Logger.e(TAG, "doReadSample: has released");
                    cMSampleBuffer = new CMSampleBuffer(CMSampleState.fromError(-1));
                } else {
                    CMSampleState fromError = CMSampleState.fromError(-1);
                    this.isEmptyFrame = false;
                    if (this.segmentIndex == -1) {
                        Logger.i(TAG, "doReadSample: segmentIndex == -1");
                        if (this.lastSampleState.getStateCode() < -1) {
                            cMSampleBuffer = new CMSampleBuffer(CMSampleState.fromError(-100));
                        } else {
                            cMSampleBuffer = new CMSampleBuffer(CMSampleState.fromError(-1));
                        }
                        AppMethodBeat.o(218109);
                    } else {
                        DecoderTrackSegment decoderTrackSegment = this.segments.get(this.segmentIndex);
                        while (true) {
                            DecoderTrackSegment decoderTrackSegment2 = decoderTrackSegment;
                            if (this.currentDecoder == null) {
                                CMTime add = this.lastSampleState.getTime().add(this.frameDuration);
                                if (this.lastSampleState.isInvalid()) {
                                    cMTime2 = CMTime.CMTimeZero;
                                } else {
                                    cMTime2 = add;
                                }
                                if (cMTime2.smallThan(this.currentSegmentStartTime.add(decoderTrackSegment2.getScaledDuration()))) {
                                    this.isEmptyFrame = true;
                                    Logger.v(TAG, "doReadSample: return emptyBuffer currentDecoder == null");
                                    cMSampleBuffer = new CMSampleBuffer(cMTime2, outputBuffer());
                                    AppMethodBeat.o(218109);
                                    break;
                                }
                            } else if (this.lastSampleState.getTime().sub(this.currentSegmentStartTime).multi(this._speed).bigThan(decoderTrackSegment2.getScaledDuration().multi(this._speed))) {
                                fromError = CMSampleState.fromError(-1);
                            } else {
                                fromError = this.currentDecoder.readSample(CMTime.CMTimeInvalid);
                            }
                            if (fromError.getStateCode() == -1) {
                                CMTime add2 = decoderTrackSegment2.getScaledDuration().add(this.currentSegmentStartTime);
                                CMTime add3 = this.lastSampleState.getTime().add(this.frameDuration);
                                if (add2.bigThan(add3)) {
                                    ByteBuffer emptyAudioBuffer2 = this.currentDecoder == null ? getEmptyAudioBuffer() : this.currentDecoder.outputBuffer();
                                    Logger.v(TAG, "doReadSample: finish && !end");
                                    if (emptyAudioBuffer2 == null) {
                                        emptyAudioBuffer2 = getEmptyAudioBuffer();
                                    }
                                    cMSampleBuffer = new CMSampleBuffer(add3, emptyAudioBuffer2);
                                    AppMethodBeat.o(218109);
                                } else if (!nextSegment(true)) {
                                    Logger.v(TAG, "doReadSample: finish && end && next failed");
                                    CMSampleState fromError2 = CMSampleState.fromError(-1);
                                    if (this.currentDecoder != null) {
                                        byteBuffer = this.currentDecoder.outputBuffer();
                                    }
                                    cMSampleBuffer = new CMSampleBuffer(fromError2, byteBuffer);
                                    AppMethodBeat.o(218109);
                                } else {
                                    decoderTrackSegment = this.segments.get(this.segmentIndex);
                                }
                            } else if (fromError.getStateCode() >= 0) {
                                CMTime divide = fromError.getTime().sub(decoderTrackSegment2.getDecoderStartTime()).divide(this._speed);
                                if (divide.getTimeUs() > decoderTrackSegment2.getScaledDuration().getTimeUs()) {
                                    divide = decoderTrackSegment2.getScaledDuration();
                                }
                                CMSampleState cMSampleState = new CMSampleState(divide.add(this.currentSegmentStartTime));
                                Logger.v(TAG, "doReadSample: [success] ".concat(String.valueOf(cMSampleState)));
                                if (this.currentDecoder != null) {
                                    byteBuffer = this.currentDecoder.outputBuffer();
                                }
                                cMSampleBuffer = new CMSampleBuffer(cMSampleState, byteBuffer);
                                AppMethodBeat.o(218109);
                            } else if (fromError.getStateCode() == -3 || fromError.getStateCode() == -100) {
                                cMSampleBuffer = new CMSampleBuffer(fromError);
                                AppMethodBeat.o(218109);
                            } else {
                                cMSampleBuffer = new CMSampleBuffer(this.lastSampleState);
                                AppMethodBeat.o(218109);
                            }
                        }
                    }
                }
            } finally {
                AppMethodBeat.o(218109);
            }
        }
        return cMSampleBuffer;
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void asyncReadNextSample(CMTime cMTime) {
        AppMethodBeat.i(218110);
        if (this.decoderThread.pcmFrame == null) {
            synchronized (this.decoderThread) {
                try {
                    if (this.decoderThread.pcmFrame == null) {
                        this.decoderThread.action();
                    }
                } finally {
                    AppMethodBeat.o(218110);
                }
            }
            return;
        }
        AppMethodBeat.o(218110);
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public CMTime getDuration() {
        AppMethodBeat.i(218111);
        if (this.duration == CMTime.CMTimeZero) {
            CMTime cMTime = CMTime.CMTimeZero;
            Iterator<DecoderTrackSegment> it = this.segments.iterator();
            while (it.hasNext()) {
                cMTime = cMTime.add(it.next().getScaledDuration());
            }
            this.duration = cMTime;
        }
        CMTime cMTime2 = this.duration;
        AppMethodBeat.o(218111);
        return cMTime2;
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public CMTime getCurrentSampleTime() {
        AppMethodBeat.i(218112);
        CMTime time = this.lastSampleState.getTime();
        AppMethodBeat.o(218112);
        return time;
    }

    private synchronized void createNextDecoder(int i2) {
        AppMethodBeat.i(218113);
        if (this.segments == null || !this.preRead) {
            AppMethodBeat.o(218113);
        } else {
            int i3 = i2 + 1;
            if (i3 >= this.segments.size()) {
                AppMethodBeat.o(218113);
            } else {
                if (this.decoderCreateThread == null) {
                    DecoderAssetTrack videoAsset = this.segments.get(i3).getVideoAsset();
                    if (videoAsset != null) {
                        if (this.nextDecoder == null || !isSameExtractor(this.nextDecoder.extractor, videoAsset)) {
                            try {
                                this.decoderCreateThread = new AudioDecoderCreateThread(videoAsset, null, i3);
                                this.decoderCreateThread.start();
                                AppMethodBeat.o(218113);
                            } catch (Exception e2) {
                                Logger.e(TAG, "createNextDecoder", e2);
                                AppMethodBeat.o(218113);
                            }
                        }
                    } else if (this.nextDecoder != null && i2 >= 0 && i2 < this.segments.size() && this.nextDecoder.segmentIndex != i2) {
                        this.nextDecoder.decoder.start(this.segments.get(i2).getTimeRange());
                        this.nextDecoder.segmentIndex = i2;
                    }
                }
                AppMethodBeat.o(218113);
            }
        }
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public synchronized void release() {
        AppMethodBeat.i(218114);
        Logger.d(TAG, "release: start ");
        this.decoderThread.release();
        this.isReleased = true;
        if (this.currentDecoder != null) {
            this.currentDecoder.release();
            this.currentDecoder = null;
        }
        synchronized (this.nextDecoderLock) {
            try {
                if (this.nextDecoder != null) {
                    DecoderWrapper.access$600(this.nextDecoder);
                    this.nextDecoder = null;
                }
            } catch (Throwable th) {
                AppMethodBeat.o(218114);
                throw th;
            }
        }
        Logger.d(TAG, "release: finish ");
        AppMethodBeat.o(218114);
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public long getLaggingTime() {
        return 0;
    }

    private static boolean isSameExtractor(DecoderAssetTrack decoderAssetTrack, DecoderAssetTrack decoderAssetTrack2) {
        AppMethodBeat.i(218115);
        if (decoderAssetTrack == null || decoderAssetTrack2 == null || decoderAssetTrack.assetPath == null || !decoderAssetTrack.assetPath.equals(decoderAssetTrack2.assetPath)) {
            AppMethodBeat.o(218115);
            return false;
        }
        AppMethodBeat.o(218115);
        return true;
    }

    /* access modifiers changed from: package-private */
    public static class DecoderWrapper {
        IDecoder decoder;
        DecoderAssetTrack extractor;
        int segmentIndex;

        private DecoderWrapper() {
            this.segmentIndex = -1;
        }

        static /* synthetic */ void access$600(DecoderWrapper decoderWrapper) {
            AppMethodBeat.i(218087);
            decoderWrapper.release();
            AppMethodBeat.o(218087);
        }

        private void release() {
            AppMethodBeat.i(218086);
            Logger.d(AudioDecoderTrack.TAG, "Audio DecoderWrapper release: ");
            try {
                if (this.decoder != null) {
                    this.decoder.release();
                }
                AppMethodBeat.o(218086);
            } catch (Error | Exception e2) {
                AppMethodBeat.o(218086);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public class AudioDecoderCreateThread extends Thread {
        DecoderAssetTrack extractor;
        private Surface outputSurface;
        private int segmentIndex;

        private AudioDecoderCreateThread(DecoderAssetTrack decoderAssetTrack, Surface surface, int i2) {
            super("AudioDCreateThread " + decoderAssetTrack.assetPath);
            AppMethodBeat.i(218081);
            this.segmentIndex = 0;
            this.extractor = decoderAssetTrack;
            this.outputSurface = surface;
            this.segmentIndex = i2;
            AppMethodBeat.o(218081);
        }

        public void run() {
            AppMethodBeat.i(218082);
            Logger.d(AudioDecoderTrack.TAG, "AudioDecoderCreateThread start - " + this.extractor.assetPath + " - " + (this.outputSurface != null));
            if (AudioDecoderTrack.this.isReleased) {
                AudioDecoderTrack.this.decoderCreateThread = null;
                AppMethodBeat.o(218082);
                return;
            }
            synchronized (AudioDecoderTrack.this.nextDecoderLock) {
                try {
                    if (AudioDecoderTrack.this.nextDecoder == null || !AudioDecoderTrack.access$1200(AudioDecoderTrack.this.nextDecoder.extractor, this.extractor)) {
                        if (AudioDecoderTrack.this.nextDecoder != null) {
                            Logger.d(AudioDecoderTrack.TAG, "AudioDecoderCreateThread create - " + this.extractor.assetPath);
                            if (!(AudioDecoderTrack.this.nextDecoder.decoder == null || AudioDecoderTrack.this.nextDecoder.decoder == AudioDecoderTrack.this.currentDecoder)) {
                                DecoderWrapper.access$600(AudioDecoderTrack.this.nextDecoder);
                                AudioDecoderTrack.this.nextDecoder = null;
                            }
                            createDecoder();
                        } else {
                            createDecoder();
                        }
                    }
                } finally {
                    AppMethodBeat.o(218082);
                }
            }
            AudioDecoderTrack.this.decoderCreateThread = null;
            if (AudioDecoderTrack.this.isReleased) {
                synchronized (AudioDecoderTrack.this.nextDecoderLock) {
                    try {
                        if (AudioDecoderTrack.this.nextDecoder != null) {
                            DecoderWrapper.access$600(AudioDecoderTrack.this.nextDecoder);
                            AudioDecoderTrack.this.nextDecoder = null;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            Logger.d(AudioDecoderTrack.TAG, "AudioDecoderCreateThread finish - " + this.extractor.assetPath);
            AppMethodBeat.o(218082);
        }

        /* JADX WARNING: Removed duplicated region for block: B:30:0x00ff A[SYNTHETIC, Splitter:B:30:0x00ff] */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x010a  */
        /* JADX WARNING: Removed duplicated region for block: B:49:0x013f  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void createDecoder() {
            /*
            // Method dump skipped, instructions count: 376
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.tav.decoder.AudioDecoderTrack.AudioDecoderCreateThread.createDecoder():void");
        }
    }

    /* access modifiers changed from: package-private */
    public static class ReleaseDecoderThread extends Thread {
        private IDecoder decoder;

        ReleaseDecoderThread(IDecoder iDecoder) {
            super("ReleaseDecoderThread");
            this.decoder = iDecoder;
        }

        public void run() {
            AppMethodBeat.i(218088);
            if (this.decoder != null) {
                this.decoder.release();
            }
            AppMethodBeat.o(218088);
        }
    }

    /* access modifiers changed from: package-private */
    public class DecoderThread extends ReActionThread {
        private static final String NAME = "AudioDecoderThread";
        private final Object nextFrameDecoderLock = new Object();
        private CacheBuffer pcmFrame;

        public DecoderThread() {
            super(NAME);
            AppMethodBeat.i(218084);
            AppMethodBeat.o(218084);
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.tav.decoder.ReActionThread
        public void doAction() {
            CMSampleBuffer cMSampleBuffer = null;
            AppMethodBeat.i(218085);
            synchronized (this.nextFrameDecoderLock) {
                try {
                    if (this.pcmFrame != null) {
                        if (AudioDecoderTrack.this.lastSampleState.getTime() == CMTime.CMTimeInvalid) {
                            Logger.v(AudioDecoderTrack.TAG, "doAction: CMTime.CMTimeZero");
                            cMSampleBuffer = AudioDecoderTrack.access$1700(AudioDecoderTrack.this, CMTime.CMTimeZero);
                        } else if (!AudioDecoderTrack.this.lastSampleState.getTime().smallThan(CMTime.CMTimeZero)) {
                            Logger.v(AudioDecoderTrack.TAG, "doAction: lastSampleTime.add(frameDuration)");
                            cMSampleBuffer = AudioDecoderTrack.access$1700(AudioDecoderTrack.this, AudioDecoderTrack.this.lastSampleState.getTime().add(AudioDecoderTrack.this.frameDuration));
                        }
                        if (cMSampleBuffer != null) {
                            if (cMSampleBuffer.getSampleByteBuffer() != null) {
                                Logger.v(AudioDecoderTrack.TAG, "doAction: processFrame [volume " + AudioDecoderTrack.this.volume + "] [_speed " + AudioDecoderTrack.this._speed + "]");
                                cMSampleBuffer.setSampleByteBuffer(AudioDecoderTrack.this.processFrame(cMSampleBuffer.getSampleByteBuffer(), 1.0f, AudioDecoderTrack.this._speed, AudioDecoderTrack.this.getAudioInfo()));
                                Logger.v(AudioDecoderTrack.TAG, "doAction: processFrame finish [volume " + AudioDecoderTrack.this.volume + "] [_speed " + AudioDecoderTrack.this._speed + "]");
                            }
                            this.pcmFrame = new CacheBuffer();
                            this.pcmFrame.preFrameTime = AudioDecoderTrack.this.lastSampleState.getTime();
                            this.pcmFrame.frameTime = cMSampleBuffer.getTime();
                        }
                    }
                } finally {
                    AppMethodBeat.o(218085);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static class CacheBuffer {
        private CMTime frameTime;
        private CMTime preFrameTime;
        private CMSampleBuffer sampleBuffer;

        private CacheBuffer() {
        }
    }

    public synchronized ByteBuffer processFrame(ByteBuffer byteBuffer, float f2, float f3, AudioInfo audioInfo2) {
        ByteBuffer processBytes;
        AppMethodBeat.i(218116);
        if (this.audioMixer.getDestAudioChannelCount() != audioInfo2.channelCount) {
            this.audioMixer.release();
            this.audioMixer = new AudioMixer(audioInfo2.sampleRate, audioInfo2.channelCount);
        }
        processBytes = this.audioMixer.processBytes(byteBuffer, f3, f2, 1.0f);
        AppMethodBeat.o(218116);
        return processBytes;
    }
}
