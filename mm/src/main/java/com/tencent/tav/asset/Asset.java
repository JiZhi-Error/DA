package com.tencent.tav.asset;

import android.annotation.TargetApi;
import android.graphics.Matrix;
import android.media.MediaFormat;
import com.tencent.tav.asset.AssetTrack;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.coremedia.TimeUtil;
import com.tencent.tav.decoder.DecoderUtils;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tav.extractor.AssetExtractor;
import com.tencent.tav.extractor.ExtractorUtils;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public abstract class Asset<Track extends AssetTrack> implements AsynchronousKeyValueLoading {
    public static final String TAG = "Asset";
    private boolean canContainFragments;
    private boolean composable;
    private boolean containsFragments;
    private CMTime duration;
    private boolean exportable;
    protected AssetExtractor extractor;
    private int extractorRetryCount;
    private boolean hasProtectedContent;
    private String lyrics;
    private MediaFormat mediaFormat;
    private int mirror;
    protected CGSize naturalSize;
    private CMTime overallDurationHint;
    private boolean playable;
    protected int preferRotation;
    private float preferredRate;
    private Matrix preferredTransform;
    protected float preferredVolume;
    private boolean providesPreciseDurationAndTiming;
    private boolean readable;
    protected int trackCount;
    protected int trackIndex;
    protected List<Track> tracks;

    protected Asset() {
        this.trackIndex = 0;
        this.trackCount = 0;
        this.duration = CMTime.CMTimeZero;
        this.preferredRate = 1.0f;
        this.preferRotation = 0;
        this.mirror = 0;
        this.preferredVolume = 1.0f;
        this.extractorRetryCount = 3;
    }

    protected Asset(URL url) {
        this.trackIndex = 0;
        this.trackCount = 0;
        this.duration = CMTime.CMTimeZero;
        this.preferredRate = 1.0f;
        this.preferRotation = 0;
        this.mirror = 0;
        this.preferredVolume = 1.0f;
        this.extractorRetryCount = 3;
    }

    protected Asset(String str) {
        this.trackIndex = 0;
        this.trackCount = 0;
        this.duration = CMTime.CMTimeZero;
        this.preferredRate = 1.0f;
        this.preferRotation = 0;
        this.mirror = 0;
        this.preferredVolume = 1.0f;
        this.extractorRetryCount = 3;
        this.extractor = new AssetExtractor();
        this.extractor.setDataSource(str);
        tryInitMembers();
        createTracks();
    }

    private void tryInitMembers() {
        int i2 = this.extractorRetryCount;
        this.extractorRetryCount = i2 - 1;
        if (i2 > 0) {
            try {
                initMembers();
            } catch (Exception e2) {
                Logger.e(TAG, "Asset: initMembers failed, path = " + getSourcePath(), e2);
                trySleep(100);
                tryInitMembers();
            }
            Logger.v(TAG, "tryInitMembers: try count = " + (3 - this.extractorRetryCount));
        }
    }

    private void trySleep(int i2) {
        try {
            Thread.sleep((long) i2);
        } catch (Exception e2) {
            Logger.e(TAG, "tryInitMembers: Thread.sleep(100) ", e2);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v6, resolved type: java.util.List<Track extends com.tencent.tav.asset.AssetTrack> */
    /* JADX DEBUG: Multi-variable search result rejected for r3v10, resolved type: java.util.List<Track extends com.tencent.tav.asset.AssetTrack> */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: protected */
    @TargetApi(16)
    public void createTracks() {
        int trackCount2 = this.extractor.getTrackCount();
        if (this.tracks == null) {
            this.tracks = new ArrayList();
        }
        for (int i2 = 0; i2 < trackCount2; i2++) {
            String string = this.extractor.getTrackFormat(i2).getString("mime");
            if (string.startsWith("video/")) {
                int i3 = this.trackIndex;
                this.trackIndex = i3 + 1;
                AssetTrack assetTrack = new AssetTrack(this, i3, 1, new CMTimeRange(CMTime.CMTimeZero, getVideoDuration()));
                assetTrack.setPreferredTransform(this.preferredTransform);
                assetTrack.setPreferredRotation(this.preferRotation);
                this.tracks.add(assetTrack);
            } else if (string.startsWith("audio/")) {
                int i4 = this.trackIndex;
                this.trackIndex = i4 + 1;
                AssetTrack assetTrack2 = new AssetTrack(this, i4, 2, new CMTimeRange(CMTime.CMTimeZero, getAudioDuration()));
                assetTrack2.setPreferredVolume(this.preferredVolume);
                this.tracks.add(assetTrack2);
            }
        }
        Logger.d(TAG, "Asset createTracks finish, has track count: " + this.tracks);
    }

    public AssetTrack trackWithTrackID(int i2) {
        if (this.tracks != null) {
            for (Track track : this.tracks) {
                if (track != null && track.getTrackID() == i2) {
                    return track;
                }
            }
        }
        return null;
    }

    public List<AssetTrack> tracksWithMediaType(int i2) {
        if (this.tracks == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Track track : this.tracks) {
            if (track != null && track.getMediaType() == i2) {
                arrayList.add(track);
            }
        }
        return arrayList;
    }

    public List<AssetTrack> tracksWithMediaCharacteristic(String str) {
        return null;
    }

    public List<Track> getTracks() {
        Logger.e(TAG, "getTracks finish, has track count: " + this.tracks);
        return this.tracks;
    }

    public int getTrackCount() {
        return this.trackCount;
    }

    public boolean isProvidesPreciseDurationAndTiming() {
        return this.providesPreciseDurationAndTiming;
    }

    public float getPreferredRate() {
        return this.preferredRate;
    }

    public CGSize getNaturalSize() {
        return this.naturalSize;
    }

    public int getPreferRotation() {
        return this.preferRotation;
    }

    public Matrix getPreferredTransform() {
        return this.preferredTransform;
    }

    public float getPreferredVolume() {
        return this.preferredVolume;
    }

    public MediaFormat getMediaFormat() {
        return this.mediaFormat;
    }

    public String getLyrics() {
        return this.lyrics;
    }

    public boolean isHasProtectedContent() {
        return this.hasProtectedContent;
    }

    public boolean isCanContainFragments() {
        return this.canContainFragments;
    }

    public boolean isContainsFragments() {
        return this.containsFragments;
    }

    public CMTime getOverallDurationHint() {
        return this.overallDurationHint;
    }

    public boolean isPlayable() {
        return this.playable;
    }

    public boolean isExportable() {
        return this.exportable;
    }

    public boolean isReadable() {
        return this.readable;
    }

    public boolean isComposable() {
        return this.composable;
    }

    public synchronized void cancelLoading() {
    }

    public synchronized AssetExtractor getExtractor() {
        return this.extractor;
    }

    public synchronized String getSourcePath() {
        String str;
        if (this.extractor != null) {
            str = this.extractor.getSourcePath();
        } else {
            str = null;
        }
        return str;
    }

    public synchronized MediaFormat getTrackFormat(int i2) {
        MediaFormat mediaFormat2;
        if (this.extractor != null) {
            mediaFormat2 = this.extractor.getTrackFormat(i2);
        } else {
            mediaFormat2 = null;
        }
        return mediaFormat2;
    }

    public synchronized CMTime getDuration() {
        if (this.duration == null || this.duration.equalsTo(CMTime.CMTimeZero)) {
            CMTime videoDuration = getVideoDuration();
            if (CMTime.CMTimeZero.equalsTo(videoDuration)) {
                videoDuration = getAudioDuration();
            }
            this.duration = videoDuration;
        }
        return this.duration;
    }

    public synchronized void selectTrack(int i2) {
        if (this.extractor != null) {
            this.extractor.selectTrack(i2);
        }
    }

    private void initMembers() {
        this.trackCount = this.extractor.getTrackCount();
        this.duration = getDuration();
        this.naturalSize = ExtractorUtils.getVideoSize(this.extractor);
        this.preferRotation = ExtractorUtils.getPreferRotation(this.extractor);
        if (this.preferRotation != 0) {
            this.preferredTransform = new Matrix();
            while (this.preferRotation < 0) {
                this.preferRotation += 4;
            }
            this.preferRotation %= 4;
            DecoderUtils.getRotationMatrix(this.preferredTransform, this.preferRotation, this.naturalSize.width, this.naturalSize.height);
        }
    }

    /* access modifiers changed from: protected */
    public CMTime getVideoDuration() {
        return TimeUtil.us2CMTime(this.extractor.getDuration());
    }

    /* access modifiers changed from: protected */
    public CMTime getAudioDuration() {
        return TimeUtil.us2CMTime(this.extractor.getAudioDuration());
    }
}
