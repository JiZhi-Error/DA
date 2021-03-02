package com.tencent.tav.player;

import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.asset.AssetTrack;
import com.tencent.tav.asset.MetadataItem;
import com.tencent.tav.asset.URLAsset;
import com.tencent.tav.core.AssetExtension;
import com.tencent.tav.core.AudioCompositionDecoderTrack;
import com.tencent.tav.core.AudioMix;
import com.tencent.tav.core.VideoCompositionDecoderTrack;
import com.tencent.tav.core.compositing.VideoCompositing;
import com.tencent.tav.core.composition.VideoComposition;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.IDecoderTrack;
import com.tencent.tav.decoder.decodecache.CachedVideoDecoderTrack;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PlayerItem {
    private Asset asset;
    private AssetExtension assetExtension;
    private AudioCompositionDecoderTrack audioCompositionDecoderTrack;
    private AudioMix audioMix;
    String audioTimePitchAlgorithm;
    VideoCompositing customVideoCompositor;
    private List<IDecoderTrack> decoderTrackList;
    private CMTime duration;
    private ErrorMsg errorMsg;
    private CMTime forwardPlaybackEndTime;
    private PlayerLayer layer;
    private int maxCacheSize;
    List<PlayerItemOutput> outputs;
    private Player player;
    private PlayerThreadAudio playerThreadAudio;
    private PlayerThread playerThreadMain;
    private CGSize presentationSize;
    private float rate;
    private IDecoderTrack realVDecoderTrack;
    private CMTime reversePlaybackEndTime;
    private List<CMTimeRange> seekableTimeRanges;
    private boolean seekingWaitsForVideoCompositionRendering;
    private PlayerItemStatus status;
    private List<MetadataItem> timedMetadata;
    private List<PlayerItemTrack> tracks;
    private IDecoderTrack vDecoderTrack;
    int videoApertureMode;
    private VideoComposition videoComposition;

    public enum PlayerItemStatus {
        PlayerItemStatusUnknown,
        PlayerItemStatusReadyToPlay,
        PlayerItemStatusFailed;

        public static PlayerItemStatus valueOf(String str) {
            AppMethodBeat.i(218595);
            PlayerItemStatus playerItemStatus = (PlayerItemStatus) Enum.valueOf(PlayerItemStatus.class, str);
            AppMethodBeat.o(218595);
            return playerItemStatus;
        }

        static {
            AppMethodBeat.i(218596);
            AppMethodBeat.o(218596);
        }
    }

    public List<MetadataItem> getTimedMetadata() {
        return this.timedMetadata;
    }

    public CMTime currentTime() {
        return null;
    }

    public CMTime getForwardPlaybackEndTime() {
        return this.forwardPlaybackEndTime;
    }

    public void setForwardPlaybackEndTime(CMTime cMTime) {
        this.forwardPlaybackEndTime = cMTime;
    }

    public CMTime getReversePlaybackEndTime() {
        return this.reversePlaybackEndTime;
    }

    public void setReversePlaybackEndTime(CMTime cMTime) {
        this.reversePlaybackEndTime = cMTime;
    }

    public List<CMTimeRange> getSeekableTimeRanges() {
        return this.seekableTimeRanges;
    }

    public void setSeekableTimeRanges(List<CMTimeRange> list) {
        this.seekableTimeRanges = list;
    }

    public VideoComposition getVideoComposition() {
        return this.videoComposition;
    }

    public void setVideoComposition(VideoComposition videoComposition2) {
        AppMethodBeat.i(218597);
        this.videoComposition = videoComposition2;
        if (videoComposition2 != null) {
            this.customVideoCompositor = videoComposition2.getCustomVideoCompositor();
        }
        AppMethodBeat.o(218597);
    }

    public AudioMix getAudioMix() {
        return this.audioMix;
    }

    public void setAudioMix(AudioMix audioMix2) {
        AppMethodBeat.i(218598);
        this.audioMix = audioMix2;
        if (this.audioCompositionDecoderTrack != null) {
            this.audioCompositionDecoderTrack.setAudioMix(audioMix2);
        }
        AppMethodBeat.o(218598);
    }

    public VideoCompositing getCustomVideoCompositor() {
        return this.customVideoCompositor;
    }

    /* access modifiers changed from: package-private */
    public void setCustomVideoCompositor(VideoCompositing videoCompositing) {
        this.customVideoCompositor = videoCompositing;
    }

    public boolean isSeekingWaitsForVideoCompositionRendering() {
        return this.seekingWaitsForVideoCompositionRendering;
    }

    public void setSeekingWaitsForVideoCompositionRendering(boolean z) {
        this.seekingWaitsForVideoCompositionRendering = z;
    }

    public int getVideoApertureMode() {
        return this.videoApertureMode;
    }

    public void setVideoApertureMode(int i2) {
        this.videoApertureMode = i2;
    }

    public String getAudioTimePitchAlgorithm() {
        return this.audioTimePitchAlgorithm;
    }

    public void setAudioTimePitchAlgorithm(String str) {
        this.audioTimePitchAlgorithm = str;
    }

    public List<PlayerItemOutput> getOutputs() {
        return this.outputs;
    }

    /* access modifiers changed from: package-private */
    public void setOutputs(List<PlayerItemOutput> list) {
        this.outputs = list;
    }

    public PlayerItem(String str) {
        this(new URLAsset(str), null);
        AppMethodBeat.i(218599);
        AppMethodBeat.o(218599);
    }

    public PlayerItem(Asset asset2) {
        this(asset2, new AssetExtension(AssetExtension.SCENE_PLAY));
        AppMethodBeat.i(218600);
        AppMethodBeat.o(218600);
    }

    public PlayerItem(Asset asset2, AssetExtension assetExtension2) {
        AppMethodBeat.i(218601);
        this.status = PlayerItemStatus.PlayerItemStatusUnknown;
        this.tracks = new ArrayList();
        this.rate = 1.0f;
        this.layer = null;
        this.maxCacheSize = 60;
        this.asset = asset2;
        this.assetExtension = assetExtension2;
        for (AssetTrack assetTrack : asset2.getTracks()) {
            PlayerItemTrack playerItemTrack = new PlayerItemTrack();
            playerItemTrack.setAssetTrack(assetTrack);
            playerItemTrack.setCurrentVideoFrameRate(getVideoFrameRate());
            playerItemTrack.setEnabled(true);
            this.tracks.add(playerItemTrack);
        }
        AppMethodBeat.o(218601);
    }

    private float getVideoFrameRate() {
        AppMethodBeat.i(218602);
        if (this.videoComposition != null) {
            float value = (((float) this.videoComposition.getFrameDuration().timeScale) * 1.0f) / ((float) this.videoComposition.getFrameDuration().getValue());
            AppMethodBeat.o(218602);
            return value;
        }
        float f2 = (float) PlayerDefaultConfigs.DEFAULT_FRAME_DURATION.timeScale;
        AppMethodBeat.o(218602);
        return f2;
    }

    /* access modifiers changed from: package-private */
    public void setRate(float f2, int i2) {
        AppMethodBeat.i(218603);
        this.rate = f2;
        this.maxCacheSize = i2;
        if (this.playerThreadMain != null) {
            this.playerThreadMain.setRate(f2);
        }
        AppMethodBeat.o(218603);
    }

    public PlayerItemStatus getStatus() {
        return this.status;
    }

    public ErrorMsg getErrorMsg() {
        return this.errorMsg;
    }

    public Asset getAsset() {
        return this.asset;
    }

    public List<PlayerItemTrack> getTracks() {
        return this.tracks;
    }

    public CMTime getDuration() {
        return this.duration;
    }

    public AssetExtension getAssetExtension() {
        return this.assetExtension;
    }

    public CGSize getPresentationSize() {
        AppMethodBeat.i(218604);
        if (this.presentationSize == null) {
            CGSize naturalSize = this.asset.getNaturalSize();
            AppMethodBeat.o(218604);
            return naturalSize;
        }
        CGSize cGSize = new CGSize(16.0f, 16.0f);
        AppMethodBeat.o(218604);
        return cGSize;
    }

    /* access modifiers changed from: package-private */
    public PlayerThread getPlayerThreadMain() {
        return this.playerThreadMain;
    }

    /* access modifiers changed from: package-private */
    public PlayerThreadAudio getPlayerThreadAudio() {
        return this.playerThreadAudio;
    }

    public IDecoderTrack getRealDecoderTrack() {
        return this.realVDecoderTrack;
    }

    public AudioCompositionDecoderTrack getAudioCompositionDecoderTrack() {
        return this.audioCompositionDecoderTrack;
    }

    /* access modifiers changed from: package-private */
    public void start(Player player2) {
        Surface surface = null;
        AppMethodBeat.i(218605);
        initVideoCompositionDecoderTrack();
        initAudioCompositionDecoderTrack();
        IDecoderTrack iDecoderTrack = this.layer == null ? null : this.vDecoderTrack;
        AudioCompositionDecoderTrack audioCompositionDecoderTrack2 = this.audioCompositionDecoderTrack;
        CGSize presentationSize2 = getPresentationSize();
        if (this.layer != null) {
            surface = this.layer.getSurface();
        }
        this.playerThreadMain = new PlayerThread(iDecoderTrack, audioCompositionDecoderTrack2, presentationSize2, surface, player2.mMainHandler, player2);
        this.playerThreadMain.setRate(this.rate);
        if (this.videoComposition != null) {
            this.playerThreadMain.setFrameDuration(this.videoComposition.getFrameDuration());
        }
        AppMethodBeat.o(218605);
    }

    public void updateComposition(Asset asset2) {
        AppMethodBeat.i(218606);
        this.asset = asset2;
        this.tracks.clear();
        for (AssetTrack assetTrack : asset2.getTracks()) {
            PlayerItemTrack playerItemTrack = new PlayerItemTrack();
            playerItemTrack.setAssetTrack(assetTrack);
            playerItemTrack.setCurrentVideoFrameRate(getVideoFrameRate());
            playerItemTrack.setEnabled(true);
            this.tracks.add(playerItemTrack);
        }
        AppMethodBeat.o(218606);
    }

    /* access modifiers changed from: package-private */
    public void updateDecoderTrack() {
        AppMethodBeat.i(218607);
        initVideoCompositionDecoderTrack();
        initAudioCompositionDecoderTrack();
        AppMethodBeat.o(218607);
    }

    /* access modifiers changed from: package-private */
    public void bindLayer(PlayerLayer playerLayer) {
        IDecoderTrack iDecoderTrack;
        AppMethodBeat.i(218608);
        this.layer = playerLayer;
        if (this.playerThreadMain == null) {
            AppMethodBeat.o(218608);
            return;
        }
        if (this.rate < 0.0f) {
            this.vDecoderTrack = new CachedVideoDecoderTrack(this.realVDecoderTrack, this.rate < 0.0f);
            ((CachedVideoDecoderTrack) this.vDecoderTrack).setMaxFrameCacheSize(this.maxCacheSize);
            iDecoderTrack = this.vDecoderTrack;
        } else {
            iDecoderTrack = this.realVDecoderTrack;
        }
        this.playerThreadMain.bindSurface(iDecoderTrack, playerLayer);
        AppMethodBeat.o(218608);
    }

    private void initVideoCompositionDecoderTrack() {
        int i2;
        int i3;
        AppMethodBeat.i(218609);
        VideoCompositionDecoderTrack videoCompositionDecoderTrack = new VideoCompositionDecoderTrack(this.asset, this.assetExtension, 1);
        int i4 = 24;
        Iterator<PlayerItemTrack> it = this.tracks.iterator();
        while (true) {
            i2 = i4;
            if (!it.hasNext()) {
                break;
            }
            PlayerItemTrack next = it.next();
            if (next != null && next.isEnabled() && next.getAssetTrack().getMediaType() == 1) {
                videoCompositionDecoderTrack.addTrack(next.getAssetTrack());
                i2 = (int) Math.min(next.getCurrentVideoFrameRate(), (float) i2);
            }
            i4 = i2;
        }
        if (this.videoComposition == null || this.videoComposition.getFrameDuration() == null) {
            i3 = i2;
        } else {
            i3 = (int) (((long) this.videoComposition.getFrameDuration().timeScale) / this.videoComposition.getFrameDuration().value);
        }
        if (i3 <= 0) {
            i3 = 30;
        }
        videoCompositionDecoderTrack.setVideoComposition(this.videoComposition);
        if (this.customVideoCompositor != null) {
            videoCompositionDecoderTrack.setVideoCompositing(this.customVideoCompositor);
        }
        videoCompositionDecoderTrack.setFrameRate(i3);
        videoCompositionDecoderTrack.setFrameDuration(new CMTime(1, i3));
        this.realVDecoderTrack = videoCompositionDecoderTrack;
        AppMethodBeat.o(218609);
    }

    /* access modifiers changed from: package-private */
    public AudioCompositionDecoderTrack initAudioCompositionDecoderTrack() {
        AppMethodBeat.i(218610);
        this.audioCompositionDecoderTrack = new AudioCompositionDecoderTrack(2);
        for (PlayerItemTrack playerItemTrack : this.tracks) {
            if (playerItemTrack != null && playerItemTrack.isEnabled() && playerItemTrack.getAssetTrack().getMediaType() == 2) {
                this.audioCompositionDecoderTrack.addTrack(playerItemTrack.getAssetTrack());
            }
        }
        this.audioCompositionDecoderTrack.setAudioMix(this.audioMix);
        AudioCompositionDecoderTrack audioCompositionDecoderTrack2 = this.audioCompositionDecoderTrack;
        AppMethodBeat.o(218610);
        return audioCompositionDecoderTrack2;
    }

    public void seekToTime(CMTime cMTime, Callback callback) {
        AppMethodBeat.i(218611);
        CMTime cMTime2 = CMTime.CMTimeZero;
        seekToTime(cMTime, cMTime2, cMTime2, callback);
        AppMethodBeat.o(218611);
    }

    public void seekToTime(CMTime cMTime, CMTime cMTime2, CMTime cMTime3, Callback callback) {
        AppMethodBeat.i(218612);
        if (this.playerThreadMain != null) {
            this.playerThreadMain.updatePositionRightAway(cMTime);
            this.playerThreadMain.sendMessage(5, cMTime, "main");
        }
        AppMethodBeat.o(218612);
    }

    public void cancelPendingSeeks() {
        AppMethodBeat.i(218613);
        if (this.playerThreadMain != null) {
            this.playerThreadMain.cancelAllPendingSeeks();
        }
        AppMethodBeat.o(218613);
    }

    public void addOutput(PlayerItemOutput playerItemOutput) {
        AppMethodBeat.i(218614);
        this.outputs.add(playerItemOutput);
        AppMethodBeat.o(218614);
    }

    public void removeOutput(PlayerItemOutput playerItemOutput) {
        AppMethodBeat.i(218615);
        this.outputs.remove(playerItemOutput);
        AppMethodBeat.o(218615);
    }

    /* access modifiers changed from: package-private */
    public void release() {
        AppMethodBeat.i(218616);
        if (this.layer != null) {
            this.layer.release();
        }
        if (this.audioMix != null) {
            this.audioMix.release();
        }
        AppMethodBeat.o(218616);
    }

    public long getLaggingTime() {
        AppMethodBeat.i(218617);
        if (this.realVDecoderTrack != null) {
            long laggingTime = this.realVDecoderTrack.getLaggingTime();
            AppMethodBeat.o(218617);
            return laggingTime;
        }
        AppMethodBeat.o(218617);
        return 0;
    }
}
