package com.tencent.tav.decoder;

import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.asset.AssetTrack;
import com.tencent.tav.asset.AssetTrackSegment;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMSampleState;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.IDecoder;
import com.tencent.tav.decoder.IDecoderTrack;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tav.extractor.ExtractorUtils;
import com.tencent.tav.report.AverageTimeReporter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VideoDecoderTrack implements IDecoderTrack {
    public static boolean LOG_VERBOSE = false;
    public static boolean PRE_READ = true;
    private static String TAG = "VDecoderTrack";
    private Surface _outputSurface;
    private float _speed = 1.0f;
    private IVideoDecoder currentDecoder;
    private final Object currentDecoderLock = new Object();
    private CMSampleBuffer currentFrame = null;
    private CMTime currentSegmentStartTime = CMTime.CMTimeZero;
    private IDecoder.DecodeType decodeType = IDecoder.DecodeType.Video;
    private DecoderCreateThread decoderCreateThread = null;
    private final DecoderThread decoderThread = new DecoderThread();
    private CMTime duration = CMTime.CMTimeZero;
    private CMTime frameDuration = new CMTime(1, 44);
    private int frameRate = 44;
    private boolean isReleased = false;
    private CMSampleState lastSampleState = new CMSampleState();
    private DecoderWrapper nextDecoder;
    private final Object nextDecoderLock = new Object();
    private CMSampleBuffer nextFrame = null;
    private final Object nextFrameDecoderLock = new Object();
    private ArrayList<AverageTimeReporter> preReadReporters = new ArrayList<>();
    private int segmentIndex = -1;
    private ArrayList<DecoderTrackSegment> segments = new ArrayList<>();
    private boolean started = false;
    private IDecoderTrack.SurfaceCreator surfaceCreator = null;
    private int trackId;

    static /* synthetic */ void access$1200(VideoDecoderTrack videoDecoderTrack, Surface surface) {
        AppMethodBeat.i(218374);
        videoDecoderTrack.free(surface);
        AppMethodBeat.o(218374);
    }

    static /* synthetic */ DecoderTrackSegment access$1300(VideoDecoderTrack videoDecoderTrack, int i2) {
        AppMethodBeat.i(218375);
        DecoderTrackSegment segment = videoDecoderTrack.getSegment(i2);
        AppMethodBeat.o(218375);
        return segment;
    }

    static /* synthetic */ void access$1900(VideoDecoderTrack videoDecoderTrack, String str) {
        AppMethodBeat.i(218376);
        videoDecoderTrack.logVerbose(str);
        AppMethodBeat.o(218376);
    }

    static /* synthetic */ CMSampleBuffer access$2000(VideoDecoderTrack videoDecoderTrack, CMTime cMTime, boolean z) {
        AppMethodBeat.i(218377);
        CMSampleBuffer doReadSample = videoDecoderTrack.doReadSample(cMTime, z);
        AppMethodBeat.o(218377);
        return doReadSample;
    }

    static /* synthetic */ void access$500(VideoDecoderTrack videoDecoderTrack, IVideoDecoder iVideoDecoder) {
        AppMethodBeat.i(218373);
        videoDecoderTrack.tryReleaseDecoder(iVideoDecoder);
        AppMethodBeat.o(218373);
    }

    public VideoDecoderTrack(AssetTrack assetTrack) {
        AppMethodBeat.i(218332);
        this.trackId = assetTrack.getTrackID();
        List<AssetTrackSegment> segments2 = assetTrack.getSegments();
        ArrayList arrayList = new ArrayList();
        this.preReadReporters.clear();
        for (AssetTrackSegment assetTrackSegment : segments2) {
            arrayList.add(new DecoderTrackSegment(assetTrack, assetTrackSegment));
            this.preReadReporters.add(new AverageTimeReporter());
        }
        setTrackSegments(arrayList);
        setFrameRate(getFrameRate() > 0 ? getFrameRate() : (int) assetTrack.getNominalFrameRate());
        setVolume(assetTrack.getPreferredVolume());
        setDecodeType(IDecoder.DecodeType.Video);
        if (assetTrack.getTimeRange() != null) {
            clipRangeAndClearRange(assetTrack.getTimeRange().clone());
        }
        AppMethodBeat.o(218332);
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void setDecodeType(IDecoder.DecodeType decodeType2) {
        this.decodeType = decodeType2;
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void setFrameRate(int i2) {
        AppMethodBeat.i(218333);
        this.frameRate = i2;
        this.frameDuration = new CMTime((long) (600 / i2), 600);
        AppMethodBeat.o(218333);
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
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public int getTrackId() {
        return this.trackId;
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void setTrackSegments(List<DecoderTrackSegment> list) {
        AppMethodBeat.i(218334);
        if (this.segments == null) {
            this.segments = new ArrayList<>();
        }
        this.segments.clear();
        this.segments.addAll(list);
        AppMethodBeat.o(218334);
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public CMTime getDuration() {
        AppMethodBeat.i(218335);
        if (this.duration == CMTime.CMTimeZero) {
            CMTime cMTime = CMTime.CMTimeZero;
            Iterator<DecoderTrackSegment> it = this.segments.iterator();
            while (it.hasNext()) {
                cMTime = cMTime.add(it.next().getScaledDuration());
            }
            this.duration = cMTime;
        }
        CMTime cMTime2 = this.duration;
        AppMethodBeat.o(218335);
        return cMTime2;
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public CMTime getCurrentSampleTime() {
        AppMethodBeat.i(218336);
        CMTime time = this.lastSampleState.getTime();
        AppMethodBeat.o(218336);
        return time;
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void clipRangeAndClearRange(CMTimeRange cMTimeRange) {
        AppMethodBeat.i(218337);
        if (cMTimeRange == null || cMTimeRange.getDurationUs() <= 0 || this.segments.size() == 0) {
            AppMethodBeat.o(218337);
            return;
        }
        CMTime start = cMTimeRange.getStart();
        CMTime end = cMTimeRange.getEnd();
        CMTime segmentsDuration = segmentsDuration();
        clipRangeAndRemoveRange(cMTimeRange);
        if (start.getValue() != 0) {
            this.segments.add(0, new DecoderTrackSegment(new CMTimeRange(CMTime.CMTimeZero, start), (DecoderAssetTrack) null));
        }
        if (end.getTimeUs() < segmentsDuration.getTimeUs()) {
            this.segments.add(new DecoderTrackSegment(new CMTimeRange(end, new CMTime(segmentsDuration.getTimeSeconds() - end.getTimeSeconds())), (DecoderAssetTrack) null));
        }
        AppMethodBeat.o(218337);
    }

    private void clipRangeAndRemoveRange(CMTimeRange cMTimeRange) {
        AppMethodBeat.i(218338);
        if (cMTimeRange == null || cMTimeRange.getDurationUs() <= 0 || this.segments.size() == 0) {
            AppMethodBeat.o(218338);
            return;
        }
        CMTime start = cMTimeRange.getStart();
        CMTime end = cMTimeRange.getEnd();
        int findSegmentIndexAt = findSegmentIndexAt(start, false);
        if (findSegmentIndexAt == -1) {
            AppMethodBeat.o(218338);
            return;
        }
        int findSegmentIndexAt2 = findSegmentIndexAt(end, false);
        if (findSegmentIndexAt2 == -1) {
            findSegmentIndexAt2 = this.segments.size() - 1;
        } else if (getSegmentStartTime(findSegmentIndexAt2) == end) {
            findSegmentIndexAt2--;
        }
        CMTime segmentStartTime = getSegmentStartTime(findSegmentIndexAt);
        CMTime segmentStartTime2 = getSegmentStartTime(findSegmentIndexAt2);
        DecoderTrackSegment segment = getSegment(findSegmentIndexAt);
        DecoderTrackSegment segment2 = getSegment(findSegmentIndexAt2);
        if (segment2.getTimeRange().getDurationUs() > 0 && !getSegmentStartTime(findSegmentIndexAt2 + 1).smallThan(cMTimeRange.getEnd())) {
            CMTime sub = cMTimeRange.getEnd().sub(segmentStartTime2);
            segment2.setTimeRange(new CMTimeRange(segment2.getTimeRange().getStart(), sub.divide((((float) segment2.getScaledDuration().getTimeUs()) * 1.0f) / ((float) segment2.getTimeRange().getDurationUs()))));
            segment2.setScaledDuration(sub);
        }
        if (segment.getTimeRange().getDurationUs() > 0) {
            float timeUs = (((float) segment.getScaledDuration().getTimeUs()) * 1.0f) / ((float) segment.getTimeRange().getDurationUs());
            CMTime sub2 = cMTimeRange.getStart().sub(segmentStartTime);
            CMTime divide = sub2.divide(timeUs);
            segment.setTimeRange(new CMTimeRange(segment.getTimeRange().getStart().add(divide), segment.getTimeRange().getDuration().sub(divide)));
            segment.setScaledDuration(segment.getScaledDuration().sub(sub2));
        }
        for (int size = this.segments.size() - 1; size >= 0; size--) {
            if (size > findSegmentIndexAt2 || size < findSegmentIndexAt) {
                this.segments.remove(size);
            }
        }
        if (getSegmentStartTime(findSegmentIndexAt2 + 1).smallThan(cMTimeRange.getEnd())) {
            this.segments.add(new DecoderTrackSegment(new CMTimeRange(CMTime.CMTimeZero, end.sub(segment2.getScaledDuration().add(segmentStartTime2))), (DecoderAssetTrack) null));
        }
        AppMethodBeat.o(218338);
    }

    private int findSegmentIndexAt(CMTime cMTime, boolean z) {
        int i2;
        boolean z2 = false;
        AppMethodBeat.i(218339);
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
            AppMethodBeat.o(218339);
            return i2;
        }
        AppMethodBeat.o(218339);
        return -1;
    }

    private CMTime getSegmentStartTime(int i2) {
        AppMethodBeat.i(218340);
        CMTime cMTime = CMTime.CMTimeZero;
        int i3 = 0;
        while (i3 < i2 && i3 < this.segments.size()) {
            cMTime = CMTime.add(cMTime, getSegment(i3).getScaledDuration());
            i3++;
        }
        AppMethodBeat.o(218340);
        return cMTime;
    }

    private CMTime segmentsDuration() {
        AppMethodBeat.i(218341);
        CMTime segmentStartTime = getSegmentStartTime(this.segments.size());
        AppMethodBeat.o(218341);
        return segmentStartTime;
    }

    private boolean nextSegment(boolean z) {
        boolean z2;
        AppMethodBeat.i(218342);
        Logger.d(TAG, "nextSegment:".concat(String.valueOf(z)));
        this.segmentIndex++;
        this._outputSurface = null;
        if (this.segmentIndex >= this.segments.size()) {
            this.segmentIndex = -1;
            AppMethodBeat.o(218342);
            return false;
        }
        this.currentSegmentStartTime = getSegmentStartTime(this.segmentIndex);
        this.lastSampleState = new CMSampleState(this.currentSegmentStartTime);
        DecoderTrackSegment currentSegment = getCurrentSegment();
        if (currentSegment.getVideoAsset() != null) {
            synchronized (this.currentDecoderLock) {
                try {
                    if (!(this.currentDecoder == null || this.currentDecoder.getSourcePath() == null)) {
                        new ReleaseDecoderThread(this.currentDecoder).start();
                        this.currentDecoder = null;
                    }
                } finally {
                    AppMethodBeat.o(218342);
                }
            }
            IVideoDecoder createDecoder = createDecoder(currentSegment, z ? getCurrentSegment().getDecoderStartTime() : CMTime.CMTimeInvalid);
            synchronized (this.currentDecoderLock) {
                try {
                    this.currentDecoder = createDecoder;
                    if (this.currentDecoder != null && this.currentDecoder.hasTrack()) {
                        if (z) {
                            this.currentDecoder.seekTo(currentSegment.getDecoderStartTime());
                        }
                        this._outputSurface = this.currentDecoder.outputSurface();
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
                    AppMethodBeat.o(218342);
                    throw th2;
                }
            }
        }
        if (currentSegment.getScaledDuration().getTimeUs() > 0) {
            this._speed = (((float) currentSegment.getTimeRange().getDurationUs()) * 1.0f) / ((float) currentSegment.getScaledDuration().getTimeUs());
        }
        String str = TAG;
        StringBuilder sb = new StringBuilder("nextSegment:");
        if (this.currentDecoder == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Logger.d(str, sb.append(z2).append(" ").append(this._speed).toString());
        AppMethodBeat.o(218342);
        return true;
    }

    private DecoderTrackSegment getCurrentSegment() {
        AppMethodBeat.i(218343);
        DecoderTrackSegment segment = getSegment(this.segmentIndex);
        AppMethodBeat.o(218343);
        return segment;
    }

    private DecoderTrackSegment getSegment(int i2) {
        AppMethodBeat.i(218344);
        DecoderTrackSegment decoderTrackSegment = this.segments.get(i2);
        AppMethodBeat.o(218344);
        return decoderTrackSegment;
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void start() {
        AppMethodBeat.i(218345);
        start(null);
        AppMethodBeat.o(218345);
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void start(IDecoderTrack.SurfaceCreator surfaceCreator2) {
        AppMethodBeat.i(218346);
        start(surfaceCreator2, null);
        AppMethodBeat.o(218346);
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void start(IDecoderTrack.SurfaceCreator surfaceCreator2, CMTimeRange cMTimeRange) {
        AppMethodBeat.i(218347);
        Logger.d(TAG, "VideoDecoderTrack start:".concat(String.valueOf(cMTimeRange)));
        if (this.segments.size() == 0) {
            release();
            AppMethodBeat.o(218347);
            return;
        }
        this.isReleased = false;
        this.started = true;
        this.surfaceCreator = surfaceCreator2;
        this.segmentIndex = -1;
        this.decoderThread.start();
        clipRangeAndRemoveRange(cMTimeRange);
        nextSegment(true);
        Logger.d(TAG, "VideoDecoderTrack start finish:");
        AppMethodBeat.o(218347);
    }

    /* JADX WARNING: Removed duplicated region for block: B:53:0x0106 A[Catch:{ Exception -> 0x01e1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01d8  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0205  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized com.tencent.tav.decoder.IVideoDecoder createDecoder(com.tencent.tav.decoder.DecoderTrackSegment r12, com.tencent.tav.coremedia.CMTime r13) {
        /*
        // Method dump skipped, instructions count: 564
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tav.decoder.VideoDecoderTrack.createDecoder(com.tencent.tav.decoder.DecoderTrackSegment, com.tencent.tav.coremedia.CMTime):com.tencent.tav.decoder.IVideoDecoder");
    }

    private void createNextDecoder(int i2) {
        AppMethodBeat.i(218349);
        if (this.segments == null || !PRE_READ) {
            AppMethodBeat.o(218349);
            return;
        }
        int i3 = i2 + 1;
        if (i3 >= this.segments.size()) {
            AppMethodBeat.o(218349);
            return;
        }
        if (this.decoderCreateThread == null) {
            DecoderAssetTrack videoAsset = getSegment(i3).getVideoAsset();
            if (videoAsset != null) {
                if (this.nextDecoder == null || !ExtractorUtils.isSameExtractor(this.nextDecoder.extractor, videoAsset)) {
                    createDecoder(videoAsset, i3);
                    AppMethodBeat.o(218349);
                    return;
                }
            } else if (!(this.nextDecoder == null || this.nextDecoder.segmentIndex == i2)) {
                this.nextDecoder.decoder.start(getSegment(i2).getTimeRange());
                this.nextDecoder.segmentIndex = i2;
            }
        }
        AppMethodBeat.o(218349);
    }

    private void createDecoder(DecoderAssetTrack decoderAssetTrack, int i2) {
        AppMethodBeat.i(218350);
        try {
            if (!(this.surfaceCreator == null || decoderAssetTrack.size == null)) {
                CGSize cGSize = decoderAssetTrack.size;
                this.decoderCreateThread = new DecoderCreateThread(decoderAssetTrack, this.surfaceCreator.createOutputSurface((int) cGSize.width, (int) cGSize.height, decoderAssetTrack.preferRotation), i2);
                this.decoderCreateThread.start();
            }
            AppMethodBeat.o(218350);
        } catch (Exception e2) {
            Logger.e(TAG, "createNextDecoder: try start DecoderCreateThread", e2);
            AppMethodBeat.o(218350);
        }
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public CMSampleBuffer seekTo(CMTime cMTime, boolean z, boolean z2) {
        CMSampleBuffer cMSampleBuffer = null;
        AppMethodBeat.i(218351);
        logVerbose("seekTo:[time " + cMTime + "] [needRead " + z + "] [quickSeek " + z2 + "]");
        synchronized (this.nextFrameDecoderLock) {
            try {
                this.currentFrame = null;
                this.nextFrame = null;
            } finally {
                AppMethodBeat.o(218351);
            }
        }
        synchronized (this) {
            try {
                if (!this.started || this.isReleased) {
                    Logger.e(TAG, "seekTo: [failed] [started " + this.started + "] [isReleased " + this.isReleased + "]");
                } else {
                    int findSegmentIndexAt = findSegmentIndexAt(cMTime, true);
                    if (findSegmentIndexAt == -1) {
                        this.segmentIndex = -1;
                        Logger.e(TAG, "seekTo: [failed] [index " + findSegmentIndexAt + "]");
                        AppMethodBeat.o(218351);
                    } else {
                        CMTime segmentStartTime = getSegmentStartTime(findSegmentIndexAt);
                        if (this.segmentIndex != findSegmentIndexAt || this.currentDecoder == null) {
                            this.segmentIndex = findSegmentIndexAt - 1;
                            nextSegment(false);
                        }
                        CMTime multi = cMTime.sub(segmentStartTime).multi(this._speed);
                        DecoderTrackSegment currentSegment = getCurrentSegment();
                        if (this.currentDecoder == null) {
                            this.lastSampleState = new CMSampleState(cMTime);
                            Logger.e(TAG, "seekTo: [failed] [currentDecoder == null]");
                            AppMethodBeat.o(218351);
                        } else {
                            this.currentDecoder.seekTo(currentSegment.getDecoderStartTime().add(multi), z2);
                            if (cMTime.bigThan(this.frameDuration)) {
                                this.lastSampleState = new CMSampleState(cMTime.sub(this.frameDuration));
                            } else {
                                this.lastSampleState = new CMSampleState(cMTime);
                            }
                            if (z) {
                                cMSampleBuffer = readSample();
                            }
                            this.currentFrame = null;
                            this.nextFrame = null;
                            logVerbose("seekTo: [success] [lastSampleState " + this.lastSampleState + "] [sampleBuffer " + cMSampleBuffer + "]");
                            AppMethodBeat.o(218351);
                        }
                    }
                }
            } finally {
                AppMethodBeat.o(218351);
            }
        }
        return cMSampleBuffer;
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public CMSampleBuffer readSample() {
        AppMethodBeat.i(218352);
        if (this.lastSampleState.isInvalid()) {
            CMSampleBuffer readSample = readSample(CMTime.CMTimeZero);
            AppMethodBeat.o(218352);
            return readSample;
        }
        CMSampleBuffer readSample2 = readSample(this.lastSampleState.getTime().add(this.frameDuration));
        AppMethodBeat.o(218352);
        return readSample2;
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public CMSampleBuffer readSample(CMTime cMTime) {
        CMSampleBuffer switchToNextFrame;
        AppMethodBeat.i(218353);
        logVerbose("readSample: start expectFrameTime = ".concat(String.valueOf(cMTime)));
        if (this.isReleased) {
            releaseDecoder();
            CMSampleBuffer createSampleBuffer = createSampleBuffer(CMSampleState.fromError(-100));
            AppMethodBeat.o(218353);
            return createSampleBuffer;
        } else if (cMTime.bigThan(getDuration())) {
            releaseDecoder();
            CMSampleBuffer createSampleBuffer2 = createSampleBuffer(CMSampleState.fromError(-1));
            AppMethodBeat.o(218353);
            return createSampleBuffer2;
        } else if (this.currentFrame == null || this.currentFrame.getTime().getTimeUs() < 0 || this.currentFrame.getTextureInfo() == null || this.currentFrame.getTime().smallThan(cMTime)) {
            logVerbose("readSample: step 1 ");
            CMTime add = cMTime.sub(this.frameDuration).add(new CMTime(1, cMTime.timeScale));
            if (findSegmentIndexAt(cMTime, false) != this.segmentIndex || this.nextFrame == null || this.nextFrame.getState().getStateCode() < 0 || this.decodeType != IDecoder.DecodeType.Video) {
                logVerbose("readSample:" + add + " nextFrame not hit");
                if (findSegmentIndexAt(cMTime, false) != this.segmentIndex) {
                    this.nextFrame = doReadSample(cMTime);
                } else {
                    this.nextFrame = doReadSample(add);
                }
            } else {
                synchronized (this.nextFrameDecoderLock) {
                    try {
                        if (this.nextFrame == null || this.nextFrame.getState().getStateCode() < -1 || (this.nextFrame.getTextureInfo() == null && this.nextFrame.getSampleByteBuffer() == null)) {
                            logVerbose("readSample:" + add + " nextFrame not hit time");
                            this.nextFrame = doReadSample(add);
                        }
                    } catch (Throwable th) {
                        AppMethodBeat.o(218353);
                        throw th;
                    }
                }
            }
            logVerbose("readSample: step 2 ");
            boolean needSwitchNextFrame = needSwitchNextFrame(this.currentFrame, this.nextFrame, cMTime);
            logVerbose("readSample: needSwitch: " + needSwitchNextFrame + " expectFrameTime = " + cMTime + " currentFrame = " + (this.currentFrame == null ? CMTime.CMTimeZero : this.currentFrame.getTime()) + "  nextFrame = " + this.nextFrame);
            if (!needSwitchNextFrame || (switchToNextFrame = switchToNextFrame()) == null) {
                logVerbose("readSample: step 3 ");
                createNextDecoder(this.segmentIndex);
                this.lastSampleState = new CMSampleState(cMTime);
                logVerbose("readSample: step 4 ");
                CMSampleBuffer createSampleBuffer3 = createSampleBuffer(needSwitchNextFrame);
                AppMethodBeat.o(218353);
                return createSampleBuffer3;
            }
            AppMethodBeat.o(218353);
            return switchToNextFrame;
        } else {
            this.lastSampleState = new CMSampleState(cMTime);
            CMSampleBuffer createSampleBuffer4 = createSampleBuffer(this.lastSampleState, this.currentFrame.getTextureInfo(), false);
            AppMethodBeat.o(218353);
            return createSampleBuffer4;
        }
    }

    private CMSampleBuffer switchToNextFrame() {
        VideoTexture texture;
        AppMethodBeat.i(218354);
        this.currentFrame = createSampleBuffer(this.nextFrame.getState(), this.nextFrame.getTextureInfo(), this.nextFrame.isNewFrame());
        if (this.nextFrame.isNewFrame() && (this.nextFrame instanceof CacheSampleBuffer) && (texture = ((CacheSampleBuffer) this.nextFrame).getTexture()) != null && !Thread.currentThread().getName().equals("VideoDecoder")) {
            logVerbose("readSample: awaitNewImage: " + this.nextFrame.getTime());
            try {
                texture.awaitNewImage();
            } catch (Throwable th) {
                Logger.e(TAG, "readSample: videoTexture.awaitNewImage() error", th);
                CMSampleBuffer createSampleBuffer = createSampleBuffer(CMSampleState.fromError(-3));
                AppMethodBeat.o(218354);
                return createSampleBuffer;
            }
        }
        this.nextFrame = createSampleBuffer(new CMSampleState());
        if (this.currentFrame.getTime().smallThan(CMTime.CMTimeZero)) {
            this.lastSampleState = this.currentFrame.getState();
            CMSampleBuffer createSampleBuffer2 = createSampleBuffer(this.currentFrame.getState());
            AppMethodBeat.o(218354);
            return createSampleBuffer2;
        }
        AppMethodBeat.o(218354);
        return null;
    }

    private synchronized CMSampleBuffer doReadSample(CMTime cMTime) {
        CMSampleBuffer doReadSample;
        AppMethodBeat.i(218355);
        doReadSample = doReadSample(cMTime, false);
        AppMethodBeat.o(218355);
        return doReadSample;
    }

    private synchronized CMSampleBuffer doReadSample(CMTime cMTime, boolean z) {
        CMSampleState readSample;
        boolean z2;
        CMSampleBuffer createSampleBuffer;
        AppMethodBeat.i(218356);
        logVerbose("doReadSample: step 1 ");
        if (this.isReleased) {
            createSampleBuffer = createSampleBuffer(-100);
            AppMethodBeat.o(218356);
        } else if (cMTime == null) {
            createSampleBuffer = createSampleBuffer(-3);
            AppMethodBeat.o(218356);
        } else if (this.segmentIndex != -1) {
            DecoderTrackSegment currentSegment = getCurrentSegment();
            CMSampleState fromError = CMSampleState.fromError(-1);
            boolean z3 = false;
            DecoderTrackSegment decoderTrackSegment = currentSegment;
            while (true) {
                logVerbose("doReadSample: step 2 ");
                if (this.currentDecoder == null) {
                    this.lastSampleState = new CMSampleState(this.lastSampleState.getTime().add(this.frameDuration));
                    if (!this.lastSampleState.getTime().smallThan(this.currentSegmentStartTime.add(decoderTrackSegment.getScaledDuration()))) {
                        z2 = z3;
                    } else if (this.surfaceCreator == null) {
                        createSampleBuffer = createSampleBuffer(this.lastSampleState);
                        AppMethodBeat.o(218356);
                    } else {
                        createSampleBuffer = createSampleBuffer(this.lastSampleState, this.surfaceCreator.videoTextureForSurface(this._outputSurface), false);
                        AppMethodBeat.o(218356);
                    }
                } else {
                    CMTime limitMin = cMTime.sub(this.currentSegmentStartTime).multi(this._speed).limitMin(CMTime.CMTimeZero);
                    if (((float) limitMin.getTimeUs()) > ((float) decoderTrackSegment.getScaledDuration().getTimeUs()) * this._speed) {
                        fromError = CMSampleState.fromError(-1);
                        z2 = z3;
                    } else {
                        CMTime add = limitMin.add(decoderTrackSegment.getDecoderStartTime());
                        if (this.currentDecoder == null) {
                            readSample = CMSampleState.fromError(-100);
                        } else {
                            readSample = this.currentDecoder.readSample(add);
                        }
                        z2 = true;
                        fromError = readSample;
                    }
                }
                if (fromError.stateMatchingTo(-1) || fromError.getTime().bigThan(decoderTrackSegment.getTimeRange().getDuration())) {
                    if (decoderTrackSegment.getScaledDuration().add(this.currentSegmentStartTime).sub(this.frameDuration).bigThan(cMTime)) {
                        createSampleBuffer = createSampleBuffer(new CMSampleState(cMTime), z2 && this.currentDecoder != null && this.currentDecoder.isLastFrameValid());
                        AppMethodBeat.o(218356);
                    } else if (z) {
                        Logger.d(TAG, "async read finish , skip it!");
                        createSampleBuffer = null;
                        AppMethodBeat.o(218356);
                        break;
                    } else if (!nextSegment(true)) {
                        createSampleBuffer = createSampleBuffer(CMSampleState.fromError(-1), false);
                        AppMethodBeat.o(218356);
                        break;
                    } else {
                        decoderTrackSegment = getCurrentSegment();
                        z3 = z2;
                    }
                } else if (fromError.getStateCode() < 0) {
                    if (!fromError.stateMatchingTo(-3)) {
                        createSampleBuffer = createSampleBuffer(this.lastSampleState);
                        AppMethodBeat.o(218356);
                    } else {
                        createSampleBuffer = createSampleBuffer(fromError);
                        AppMethodBeat.o(218356);
                    }
                } else {
                    logVerbose("doReadSample: step 3 ");
                    CMTime sub = fromError.getTime().sub(decoderTrackSegment.getDecoderStartTime());
                    if (sub.bigThan(decoderTrackSegment.getTimeRange().getDuration())) {
                        sub = decoderTrackSegment.getTimeRange().getDuration();
                    }
                    CMSampleState cMSampleState = new CMSampleState(this.currentSegmentStartTime.add(sub.divide(this._speed)));
                    logVerbose("readSample: currentTime = " + cMTime + "  sampleState = " + cMSampleState);
                    createSampleBuffer = createSampleBuffer(cMSampleState, true);
                    AppMethodBeat.o(218356);
                }
            }
        } else if (this.lastSampleState.getStateCode() >= -1) {
            createSampleBuffer = createSampleBuffer(-1);
            AppMethodBeat.o(218356);
        } else {
            createSampleBuffer = createSampleBuffer(-100);
            AppMethodBeat.o(218356);
        }
        return createSampleBuffer;
    }

    private CMSampleBuffer createSampleBuffer(boolean z) {
        AppMethodBeat.i(218357);
        if (this.currentFrame != null) {
            CMSampleBuffer createSampleBuffer = createSampleBuffer(this.lastSampleState, this.currentFrame.getTextureInfo(), z);
            AppMethodBeat.o(218357);
            return createSampleBuffer;
        }
        CMSampleBuffer createSampleBuffer2 = createSampleBuffer(this.lastSampleState, this.currentDecoder == null ? null : this.currentDecoder.getTextureInfo(), z);
        AppMethodBeat.o(218357);
        return createSampleBuffer2;
    }

    private CMSampleBuffer createSampleBuffer(CMSampleState cMSampleState, boolean z) {
        AppMethodBeat.i(218358);
        if (this.currentDecoder instanceof VideoDecoder) {
            CMSampleBuffer createSampleBuffer = createSampleBuffer(cMSampleState, this.surfaceCreator.videoTextureForSurface(this._outputSurface), z);
            AppMethodBeat.o(218358);
            return createSampleBuffer;
        }
        CMSampleBuffer createSampleBuffer2 = createSampleBuffer(cMSampleState, this.currentDecoder == null ? null : this.currentDecoder.getTextureInfo(), z);
        AppMethodBeat.o(218358);
        return createSampleBuffer2;
    }

    private CMSampleBuffer createSampleBuffer(long j2) {
        AppMethodBeat.i(218359);
        CMSampleBuffer createSampleBuffer = createSampleBuffer(CMSampleState.fromError(j2));
        AppMethodBeat.o(218359);
        return createSampleBuffer;
    }

    private CMSampleBuffer createSampleBuffer(CMSampleState cMSampleState) {
        AppMethodBeat.i(218360);
        CMSampleBuffer cMSampleBuffer = new CMSampleBuffer(cMSampleState);
        AppMethodBeat.o(218360);
        return cMSampleBuffer;
    }

    private CMSampleBuffer createSampleBuffer(CMSampleState cMSampleState, VideoTexture videoTexture, boolean z) {
        AppMethodBeat.i(218361);
        CacheSampleBuffer cacheSampleBuffer = new CacheSampleBuffer(cMSampleState, videoTexture == null ? null : videoTexture.getTextureInfo(), z);
        cacheSampleBuffer.setTexture(videoTexture);
        AppMethodBeat.o(218361);
        return cacheSampleBuffer;
    }

    private CMSampleBuffer createSampleBuffer(CMSampleState cMSampleState, TextureInfo textureInfo, boolean z) {
        AppMethodBeat.i(218362);
        CMSampleBuffer cMSampleBuffer = new CMSampleBuffer(cMSampleState, textureInfo, z);
        AppMethodBeat.o(218362);
        return cMSampleBuffer;
    }

    private boolean needSwitchNextFrame(CMSampleBuffer cMSampleBuffer, CMSampleBuffer cMSampleBuffer2, CMTime cMTime) {
        AppMethodBeat.i(218363);
        if (cMSampleBuffer == null || cMSampleBuffer2.getTime().smallThan(CMTime.CMTimeZero)) {
            AppMethodBeat.o(218363);
            return true;
        }
        long timeUs = cMSampleBuffer2.getTime().getTimeUs();
        long timeUs2 = cMTime.getTimeUs();
        if (cMSampleBuffer2.isNewFrame()) {
            CMTime cMTime2 = CMTime.CMTimeZero;
            int i2 = 0;
            while (i2 < this.segmentIndex && i2 < this.segments.size()) {
                cMTime2.add(this.segments.get(i2).getScaledDuration());
                i2++;
            }
            if (cMTime.bigThan(cMSampleBuffer.getTime()) && !cMTime.smallThan(cMTime2)) {
                AppMethodBeat.o(218363);
                return true;
            }
        }
        if (Math.abs(timeUs2) >= Math.abs(timeUs)) {
            AppMethodBeat.o(218363);
            return true;
        }
        AppMethodBeat.o(218363);
        return false;
    }

    private boolean unNeedReDecoderNextFrame(CMTime cMTime) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(218364);
        if (this.nextFrame == null || !this.nextFrame.getTime().bigThan(cMTime)) {
            z = false;
        } else {
            z = true;
        }
        if (this.nextFrame == null || this.currentFrame == null || !this.nextFrame.getTime().bigThan(this.currentFrame.getTime())) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z || z2) {
            AppMethodBeat.o(218364);
            return true;
        }
        AppMethodBeat.o(218364);
        return false;
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public synchronized void asyncReadNextSample(CMTime cMTime) {
        AppMethodBeat.i(218365);
        if (unNeedReDecoderNextFrame(cMTime)) {
            AppMethodBeat.o(218365);
        } else if (this.isReleased) {
            AppMethodBeat.o(218365);
        } else {
            this.nextFrame = new CMSampleBuffer(cMTime);
            synchronized (this.decoderThread) {
                try {
                    this.decoderThread.action();
                } finally {
                    AppMethodBeat.o(218365);
                }
            }
        }
    }

    private void release(Surface surface) {
        AppMethodBeat.i(218366);
        if (surface != null) {
            try {
                surface.release();
            } catch (Exception e2) {
                AppMethodBeat.o(218366);
                return;
            }
        }
        AppMethodBeat.o(218366);
    }

    private void free(Surface surface) {
        AppMethodBeat.i(218367);
        if (surface != null) {
            try {
                this.surfaceCreator.free(surface);
            } catch (Exception e2) {
                AppMethodBeat.o(218367);
                return;
            }
        }
        AppMethodBeat.o(218367);
    }

    private void releaseDecoder() {
        AppMethodBeat.i(218368);
        if (this.currentDecoder == null) {
            AppMethodBeat.o(218368);
            return;
        }
        synchronized (this.currentDecoderLock) {
            try {
                if (!(this.currentDecoder == null || this.currentDecoder.getSourcePath() == null)) {
                    new ReleaseDecoderThread(this.currentDecoder).start();
                    this.currentDecoder = null;
                }
            } finally {
                AppMethodBeat.o(218368);
            }
        }
    }

    private void tryReleaseDecoder(IVideoDecoder iVideoDecoder) {
        AppMethodBeat.i(218369);
        if (iVideoDecoder != null) {
            try {
                iVideoDecoder.release(true);
                free(iVideoDecoder.outputSurface());
            } catch (Exception e2) {
                Logger.e(TAG, "tryReleaseDecoder Exception, ignore", e2);
                AppMethodBeat.o(218369);
                return;
            }
        }
        AppMethodBeat.o(218369);
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public synchronized void release() {
        AppMethodBeat.i(218370);
        this.decoderThread.release();
        Logger.d(TAG, "release: start ".concat(String.valueOf(this)));
        this.isReleased = true;
        this.segments.clear();
        if (this.currentDecoder != null) {
            this.currentDecoder.release(true);
            release(this.currentDecoder.outputSurface());
            this.currentDecoder = null;
        }
        synchronized (this.nextDecoderLock) {
            try {
                if (this.nextDecoder != null) {
                    DecoderWrapper.access$300(this.nextDecoder);
                    this.nextDecoder = null;
                }
            } catch (Throwable th) {
                AppMethodBeat.o(218370);
                throw th;
            }
        }
        if (!(this.currentFrame == null || this.currentFrame.getTextureInfo() == null)) {
            this.currentFrame.getTextureInfo().release();
        }
        if (!(this.nextFrame == null || !(this.nextFrame instanceof CacheSampleBuffer) || ((CacheSampleBuffer) this.nextFrame).getTexture() == null)) {
            ((CacheSampleBuffer) this.nextFrame).getTexture().release();
        }
        Logger.d(TAG, "release: finish");
        AppMethodBeat.o(218370);
    }

    private void logVerbose(String str) {
        AppMethodBeat.i(218371);
        Logger.v(TAG, str);
        AppMethodBeat.o(218371);
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public long getLaggingTime() {
        AppMethodBeat.i(218372);
        long j2 = 0;
        for (int i2 = 1; i2 < this.preReadReporters.size(); i2++) {
            j2 += Math.max(0L, this.preReadReporters.get(i2).average() - (this.segments.get(i2).getScaledDuration().getTimeUs() / 1000));
        }
        AppMethodBeat.o(218372);
        return j2;
    }

    /* access modifiers changed from: package-private */
    public class DecoderWrapper {
        IVideoDecoder decoder;
        DecoderAssetTrack extractor;
        Surface outputSurface;
        int segmentIndex;

        private DecoderWrapper() {
            this.segmentIndex = -1;
        }

        static /* synthetic */ void access$300(DecoderWrapper decoderWrapper) {
            AppMethodBeat.i(218328);
            decoderWrapper.release();
            AppMethodBeat.o(218328);
        }

        private void release() {
            AppMethodBeat.i(218327);
            Logger.d(VideoDecoderTrack.TAG, "Video DecoderWrapper release: ");
            VideoDecoderTrack.access$500(VideoDecoderTrack.this, this.decoder);
            AppMethodBeat.o(218327);
        }
    }

    /* access modifiers changed from: package-private */
    public class DecoderCreateThread extends Thread {
        private Surface outputSurface;
        private int segmentIndex;
        DecoderAssetTrack videoAsset;

        private DecoderCreateThread(DecoderAssetTrack decoderAssetTrack, Surface surface, int i2) {
            super("DecoderCreateThread " + decoderAssetTrack.assetPath);
            AppMethodBeat.i(218320);
            this.videoAsset = decoderAssetTrack;
            this.outputSurface = surface;
            this.segmentIndex = i2;
            AppMethodBeat.o(218320);
        }

        public void run() {
            AppMethodBeat.i(218321);
            Logger.d(VideoDecoderTrack.TAG, "DecoderCreateThread start - " + this.videoAsset.assetPath + " - " + (this.outputSurface != null));
            if (VideoDecoderTrack.this.isReleased) {
                VideoDecoderTrack.this.decoderCreateThread = null;
                AppMethodBeat.o(218321);
                return;
            }
            synchronized (VideoDecoderTrack.this.nextDecoderLock) {
                try {
                    checkCreateDecoder();
                } catch (Throwable th) {
                    AppMethodBeat.o(218321);
                    throw th;
                }
            }
            VideoDecoderTrack.this.decoderCreateThread = null;
            if (VideoDecoderTrack.this.isReleased) {
                releaseNextDecoder();
            }
            Logger.d(VideoDecoderTrack.TAG, "DecoderCreateThread finish - " + this.videoAsset.assetPath);
            AppMethodBeat.o(218321);
        }

        private void checkCreateDecoder() {
            AppMethodBeat.i(218322);
            if (VideoDecoderTrack.this.nextDecoder != null && ExtractorUtils.isSameExtractor(VideoDecoderTrack.this.nextDecoder.extractor, this.videoAsset)) {
                AppMethodBeat.o(218322);
            } else if (VideoDecoderTrack.this.nextDecoder == null) {
                createDecoder();
                AppMethodBeat.o(218322);
            } else {
                Logger.d(VideoDecoderTrack.TAG, "DecoderCreateThread create - " + this.videoAsset.assetPath);
                if (!(VideoDecoderTrack.this.nextDecoder.decoder == null || VideoDecoderTrack.this.nextDecoder.decoder == VideoDecoderTrack.this.currentDecoder)) {
                    releaseNextDecoder();
                }
                createDecoder();
                AppMethodBeat.o(218322);
            }
        }

        private void createDecoder() {
            IVideoDecoder iVideoDecoder;
            Exception e2;
            AppMethodBeat.i(218323);
            if (VideoDecoderTrack.this.segments == null || this.segmentIndex >= VideoDecoderTrack.this.segments.size()) {
                AppMethodBeat.o(218323);
                return;
            }
            try {
                Surface surface = this.outputSurface;
                if (this.videoAsset.sourceType == 3) {
                    iVideoDecoder = new ImageDecoder();
                    try {
                        VideoDecoderTrack.access$1200(VideoDecoderTrack.this, surface);
                        iVideoDecoder.init(this.videoAsset.assetPath, ImageDecoder.IMAGE_DECODE_SIZE, null);
                    } catch (Exception e3) {
                        e2 = e3;
                        Logger.e(VideoDecoderTrack.TAG, "createDecoder: ", e2);
                        VideoDecoderTrack.access$500(VideoDecoderTrack.this, iVideoDecoder);
                        AppMethodBeat.o(218323);
                    }
                } else {
                    iVideoDecoder = new VideoDecoder(this.videoAsset.assetPath, surface);
                }
                iVideoDecoder.start(VideoDecoderTrack.access$1300(VideoDecoderTrack.this, this.segmentIndex).getTimeRange(), VideoDecoderTrack.access$1300(VideoDecoderTrack.this, this.segmentIndex).getDecoderStartTime());
                VideoDecoderTrack.this.nextDecoder = new DecoderWrapper();
                VideoDecoderTrack.this.nextDecoder.outputSurface = surface;
                VideoDecoderTrack.this.nextDecoder.decoder = iVideoDecoder;
                VideoDecoderTrack.this.nextDecoder.extractor = this.videoAsset;
                VideoDecoderTrack.this.nextDecoder.segmentIndex = this.segmentIndex;
                ((AverageTimeReporter) VideoDecoderTrack.this.preReadReporters.get(this.segmentIndex)).add(iVideoDecoder.getPreReadCost());
                Logger.d(VideoDecoderTrack.TAG, "DecoderCreateThread success - " + this.videoAsset.assetPath);
                AppMethodBeat.o(218323);
            } catch (Exception e4) {
                e2 = e4;
                iVideoDecoder = null;
                Logger.e(VideoDecoderTrack.TAG, "createDecoder: ", e2);
                VideoDecoderTrack.access$500(VideoDecoderTrack.this, iVideoDecoder);
                AppMethodBeat.o(218323);
            }
        }

        private void releaseNextDecoder() {
            AppMethodBeat.i(218324);
            synchronized (VideoDecoderTrack.this.nextDecoderLock) {
                try {
                    if (VideoDecoderTrack.this.nextDecoder != null) {
                        DecoderWrapper.access$300(VideoDecoderTrack.this.nextDecoder);
                        VideoDecoderTrack.this.nextDecoder = null;
                    }
                } finally {
                    AppMethodBeat.o(218324);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public class ReleaseDecoderThread extends Thread {
        private IVideoDecoder decoder;

        ReleaseDecoderThread(IVideoDecoder iVideoDecoder) {
            super("ReleaseDecoderThread");
            this.decoder = iVideoDecoder;
        }

        public void run() {
            AppMethodBeat.i(218329);
            doRelease();
            AppMethodBeat.o(218329);
        }

        private void doRelease() {
            AppMethodBeat.i(218330);
            if (this.decoder != null) {
                Logger.d(VideoDecoderTrack.TAG, "ReleaseDecoderThread start");
                this.decoder.release(true);
                VideoDecoderTrack.access$1200(VideoDecoderTrack.this, this.decoder.outputSurface());
                this.decoder = null;
                Logger.d(VideoDecoderTrack.TAG, "ReleaseDecoderThread end");
            }
            AppMethodBeat.o(218330);
        }

        public void start() {
            AppMethodBeat.i(218331);
            if (!(this.decoder instanceof VideoDecoder)) {
                doRelease();
            }
            super.start();
            AppMethodBeat.o(218331);
        }
    }

    /* access modifiers changed from: package-private */
    public class DecoderThread extends ReActionThread {
        private static final String NAME = "VideoDecoder";

        private DecoderThread() {
            super(NAME);
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.tav.decoder.ReActionThread
        public void doAction() {
            AppMethodBeat.i(218325);
            synchronized (VideoDecoderTrack.this.nextFrameDecoderLock) {
                try {
                    doActionInDecoderLock();
                } finally {
                    AppMethodBeat.o(218325);
                }
            }
        }

        private void doActionInDecoderLock() {
            AppMethodBeat.i(218326);
            if (VideoDecoderTrack.this.nextFrame == null) {
                AppMethodBeat.o(218326);
            } else if (VideoDecoderTrack.this.lastSampleState.isInvalid()) {
                VideoDecoderTrack.access$1900(VideoDecoderTrack.this, "DecoderThread doAction: CMTime.CMTimeZero");
                VideoDecoderTrack.this.nextFrame = VideoDecoderTrack.access$2000(VideoDecoderTrack.this, CMTime.CMTimeZero, true);
                AppMethodBeat.o(218326);
            } else {
                if (VideoDecoderTrack.this.lastSampleState.getStateCode() >= 0) {
                    VideoDecoderTrack.access$1900(VideoDecoderTrack.this, "DecoderThread doAction: lastSampleTime.add(frameDuration) ");
                    VideoDecoderTrack.this.nextFrame = VideoDecoderTrack.access$2000(VideoDecoderTrack.this, VideoDecoderTrack.this.nextFrame.getTime(), true);
                }
                AppMethodBeat.o(218326);
            }
        }
    }
}
