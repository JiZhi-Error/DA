package com.tencent.tav.core.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.IDecoderTrack;
import com.tencent.tav.decoder.logger.Logger;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class AudioExportTask implements IAudioExportTask {
    private static final String TAG = "AudioEncoderTask";
    private IAudioSource<? extends IDecoderTrack> mAsset;
    private ExportCallback mCallback;
    private List<AudioExportRunner> mEncoderList = new ArrayList();
    private String mOutSavePath;
    private HashMap<Integer, SegmentStatus> mProgressMap = new HashMap<>();
    private int mSegmentCount = 0;
    private String mSessionId = new StringBuilder().append(new Random().nextLong()).toString();

    static /* synthetic */ SegmentStatus access$100(AudioExportTask audioExportTask, int i2, int i3, float f2) {
        AppMethodBeat.i(217994);
        SegmentStatus createOrUpdateSegmentStatus = audioExportTask.createOrUpdateSegmentStatus(i2, i3, f2);
        AppMethodBeat.o(217994);
        return createOrUpdateSegmentStatus;
    }

    static /* synthetic */ void access$200(AudioExportTask audioExportTask) {
        AppMethodBeat.i(217995);
        audioExportTask.notifyProgressAndStatusUpdate();
        AppMethodBeat.o(217995);
    }

    public AudioExportTask(IAudioSource<? extends IDecoderTrack> iAudioSource, String str) {
        AppMethodBeat.i(217984);
        this.mAsset = iAudioSource;
        this.mOutSavePath = str;
        AppMethodBeat.o(217984);
    }

    public AudioExportTask(String str) {
        AppMethodBeat.i(217985);
        this.mOutSavePath = str;
        AppMethodBeat.o(217985);
    }

    /* access modifiers changed from: protected */
    public CMTime getDuration() {
        AppMethodBeat.i(217986);
        if (this.mAsset != null) {
            CMTime duration = this.mAsset.getDuration();
            AppMethodBeat.o(217986);
            return duration;
        }
        CMTime cMTime = CMTime.CMTimeZero;
        AppMethodBeat.o(217986);
        return cMTime;
    }

    @Override // com.tencent.tav.core.audio.IAudioExportTask
    public void start() {
        long j2;
        int i2 = 1;
        AppMethodBeat.i(217987);
        this.mProgressMap.clear();
        this.mEncoderList.clear();
        long timeUs = getDuration().getTimeUs();
        long j3 = (long) AudioExportSession.SEGMENT_DURATION_US;
        long j4 = 0;
        this.mSessionId = new StringBuilder().append(System.currentTimeMillis()).toString();
        this.mSegmentCount = (int) (((timeUs + j3) - 1) / j3);
        int i3 = 1;
        for (int i4 = 0; i4 < this.mSegmentCount; i4++) {
            if (j4 + j3 > timeUs) {
                j2 = timeUs - j4;
            } else {
                j2 = j3;
            }
            createSegmentStatus(i3, new CMTimeRange(CMTime.fromUs(j4), CMTime.fromUs(j2)));
            j4 += j3;
            i3++;
        }
        for (Map.Entry<Integer, SegmentStatus> entry : this.mProgressMap.entrySet()) {
            exportAudio(entry.getValue().mTimeRange, i2);
            i2++;
        }
        AppMethodBeat.o(217987);
    }

    private void exportAudio(CMTimeRange cMTimeRange, final int i2) {
        AppMethodBeat.i(217988);
        Logger.d(TAG, "exportAudio timeRange = " + cMTimeRange + " index = " + i2);
        AudioExportRunner audioExportRunner = new AudioExportRunner(this.mAsset, cMTimeRange);
        audioExportRunner.setSavePath(EncoderUtils.getAudioOutSaveFilePath(this.mOutSavePath, i2, this.mSessionId));
        audioExportRunner.setCallback(new ExportCallback() {
            /* class com.tencent.tav.core.audio.AudioExportTask.AnonymousClass1 */

            @Override // com.tencent.tav.core.audio.ExportCallback
            public void onProgress(int i2, float f2) {
                AppMethodBeat.i(217983);
                synchronized (AudioExportTask.this) {
                    try {
                        AudioExportTask.access$100(AudioExportTask.this, i2, i2, f2);
                        AudioExportTask.access$200(AudioExportTask.this);
                    } finally {
                        AppMethodBeat.o(217983);
                    }
                }
            }
        });
        try {
            audioExportRunner.prepare();
            audioExportRunner.start();
            this.mEncoderList.add(audioExportRunner);
            AppMethodBeat.o(217988);
        } catch (IOException e2) {
            AppMethodBeat.o(217988);
        }
    }

    private void notifyProgressAndStatusUpdate() {
        AppMethodBeat.i(217989);
        if (this.mProgressMap.size() == 0) {
            AppMethodBeat.o(217989);
            return;
        }
        float f2 = (float) this.mSegmentCount;
        int i2 = 0;
        float f3 = 0.0f;
        for (Map.Entry<Integer, SegmentStatus> entry : this.mProgressMap.entrySet()) {
            i2 = entry.getValue().mStatus | i2;
            f3 = entry.getValue().mProgress + f3;
        }
        float f4 = f3 / f2;
        Logger.i(TAG, " mStatus = " + i2 + " mProgress = " + f4);
        if (i2 == 255) {
            onProgress(255, f4);
            EncoderUtils.deleteAllTmpFiles(this.mOutSavePath, this.mSegmentCount, this.mSessionId);
            new File(this.mOutSavePath).delete();
            AppMethodBeat.o(217989);
        } else if (i2 >= 4) {
            onProgress(4, f4);
            EncoderUtils.deleteAllTmpFiles(this.mOutSavePath, this.mSegmentCount, this.mSessionId);
            new File(this.mOutSavePath).delete();
            AppMethodBeat.o(217989);
        } else if (i2 == 2) {
            if (EncoderUtils.mergeAllFiles(this.mOutSavePath, this.mSegmentCount, this.mSessionId)) {
                onProgress(2, 1.0f);
            } else {
                onProgress(255, 1.0f);
            }
            EncoderUtils.deleteAllTmpFiles(this.mOutSavePath, this.mSegmentCount, this.mSessionId);
            AppMethodBeat.o(217989);
        } else if (i2 > 0) {
            onProgress(1, f4);
            AppMethodBeat.o(217989);
        } else {
            onProgress(0, f4);
            AppMethodBeat.o(217989);
        }
    }

    private void onProgress(int i2, float f2) {
        AppMethodBeat.i(217990);
        if (this.mCallback != null) {
            this.mCallback.onProgress(i2, f2);
        }
        AppMethodBeat.o(217990);
    }

    private SegmentStatus createSegmentStatus(int i2, CMTimeRange cMTimeRange) {
        AppMethodBeat.i(217991);
        SegmentStatus segmentStatus = new SegmentStatus(0, 0.0f);
        segmentStatus.mTimeRange = cMTimeRange;
        this.mProgressMap.put(Integer.valueOf(i2), segmentStatus);
        AppMethodBeat.o(217991);
        return segmentStatus;
    }

    private SegmentStatus createOrUpdateSegmentStatus(int i2, int i3, float f2) {
        SegmentStatus segmentStatus;
        AppMethodBeat.i(217992);
        Logger.d(TAG, "createOrUpdateSegmentStatus index = " + i2 + " mStatus = " + i3 + " mProgress = " + f2);
        if (this.mProgressMap.containsKey(Integer.valueOf(i2))) {
            segmentStatus = this.mProgressMap.get(Integer.valueOf(i2));
            segmentStatus.mProgress = f2;
            segmentStatus.mStatus = i3;
        } else {
            segmentStatus = new SegmentStatus(i3, f2);
            this.mProgressMap.put(Integer.valueOf(i2), segmentStatus);
        }
        AppMethodBeat.o(217992);
        return segmentStatus;
    }

    @Override // com.tencent.tav.core.audio.IAudioExportTask
    public void cancel() {
        AppMethodBeat.i(217993);
        for (AudioExportRunner audioExportRunner : this.mEncoderList) {
            audioExportRunner.cancel();
        }
        AppMethodBeat.o(217993);
    }

    @Override // com.tencent.tav.core.audio.IAudioExportTask
    public void setExportCallback(ExportCallback exportCallback) {
        this.mCallback = exportCallback;
    }

    /* access modifiers changed from: package-private */
    public static class SegmentStatus {
        private float mProgress;
        private int mStatus;
        private CMTimeRange mTimeRange;

        public SegmentStatus(int i2, float f2) {
            this.mStatus = i2;
            this.mProgress = f2;
        }

        public CMTimeRange getTimeRange() {
            return this.mTimeRange;
        }

        public void setTimeRange(CMTimeRange cMTimeRange) {
            this.mTimeRange = cMTimeRange;
        }
    }
}
