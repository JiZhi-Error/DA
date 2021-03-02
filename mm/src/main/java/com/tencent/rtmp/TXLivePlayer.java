package com.tencent.rtmp;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.ugc.TXRecordCommon;

public class TXLivePlayer {
    public static final int PLAY_TYPE_LIVE_FLV = 1;
    public static final int PLAY_TYPE_LIVE_RTMP = 0;
    public static final int PLAY_TYPE_LIVE_RTMP_ACC = 5;
    public static final int PLAY_TYPE_LOCAL_VIDEO = 6;
    public static final int PLAY_TYPE_VOD_FLV = 2;
    public static final int PLAY_TYPE_VOD_HLS = 3;
    public static final int PLAY_TYPE_VOD_MP4 = 4;
    public static final String TAG = "TXLivePlayer";
    private a mTXLivePlayerImpl;

    public interface ITXAudioRawDataListener {
        void onAudioInfoChanged(int i2, int i3, int i4);

        void onPcmDataAvailable(byte[] bArr, long j2);
    }

    public interface ITXAudioVolumeEvaluationListener {
        void onAudioVolumeEvaluationNotify(int i2);
    }

    public interface ITXLivePlayVideoRenderListener {
        void onRenderVideoFrame(TXLiteAVTexture tXLiteAVTexture);
    }

    public interface ITXSnapshotListener {
        void onSnapshot(Bitmap bitmap);
    }

    public interface ITXVideoRawDataListener {
        void onVideoRawDataAvailable(byte[] bArr, int i2, int i3, int i4);
    }

    public static class TXLiteAVTexture {
        public Object eglContext;
        public int height;
        public int textureId;
        public int width;
    }

    public TXLivePlayer(Context context) {
        AppMethodBeat.i(14009);
        this.mTXLivePlayerImpl = new a(context);
        AppMethodBeat.o(14009);
    }

    public void setConfig(TXLivePlayConfig tXLivePlayConfig) {
        AppMethodBeat.i(14010);
        this.mTXLivePlayerImpl.a(tXLivePlayConfig);
        AppMethodBeat.o(14010);
    }

    public void setPlayListener(ITXLivePlayListener iTXLivePlayListener) {
        AppMethodBeat.i(14011);
        this.mTXLivePlayerImpl.a(iTXLivePlayListener);
        AppMethodBeat.o(14011);
    }

    public void setPlayerView(TXCloudVideoView tXCloudVideoView) {
        AppMethodBeat.i(14012);
        this.mTXLivePlayerImpl.a(tXCloudVideoView);
        AppMethodBeat.o(14012);
    }

    public int startPlay(String str, int i2) {
        AppMethodBeat.i(14013);
        int a2 = this.mTXLivePlayerImpl.a(str, i2);
        AppMethodBeat.o(14013);
        return a2;
    }

    public int stopPlay(boolean z) {
        AppMethodBeat.i(14014);
        int a2 = this.mTXLivePlayerImpl.a(z);
        AppMethodBeat.o(14014);
        return a2;
    }

    public boolean isPlaying() {
        AppMethodBeat.i(14015);
        boolean a2 = this.mTXLivePlayerImpl.a();
        AppMethodBeat.o(14015);
        return a2;
    }

    public void pause() {
        AppMethodBeat.i(14016);
        this.mTXLivePlayerImpl.b();
        AppMethodBeat.o(14016);
    }

    public void resume() {
        AppMethodBeat.i(14017);
        this.mTXLivePlayerImpl.c();
        AppMethodBeat.o(14017);
    }

    public void setSurface(Surface surface) {
        AppMethodBeat.i(14018);
        this.mTXLivePlayerImpl.a(surface);
        AppMethodBeat.o(14018);
    }

    public void setSurfaceSize(int i2, int i3) {
        AppMethodBeat.i(14019);
        this.mTXLivePlayerImpl.a(i2, i3);
        AppMethodBeat.o(14019);
    }

    public void setRenderMode(int i2) {
        AppMethodBeat.i(14020);
        this.mTXLivePlayerImpl.a(i2);
        AppMethodBeat.o(14020);
    }

    public void setRenderRotation(int i2) {
        AppMethodBeat.i(14021);
        this.mTXLivePlayerImpl.b(i2);
        AppMethodBeat.o(14021);
    }

    public boolean enableHardwareDecode(boolean z) {
        AppMethodBeat.i(14022);
        boolean b2 = this.mTXLivePlayerImpl.b(z);
        AppMethodBeat.o(14022);
        return b2;
    }

    public void setMute(boolean z) {
        AppMethodBeat.i(14023);
        this.mTXLivePlayerImpl.c(z);
        AppMethodBeat.o(14023);
    }

    public void setVolume(int i2) {
        AppMethodBeat.i(14024);
        this.mTXLivePlayerImpl.c(i2);
        AppMethodBeat.o(14024);
    }

    public void setAudioRoute(int i2) {
        AppMethodBeat.i(14025);
        this.mTXLivePlayerImpl.d(i2);
        AppMethodBeat.o(14025);
    }

    public int switchStream(String str) {
        AppMethodBeat.i(14026);
        int a2 = this.mTXLivePlayerImpl.a(str);
        AppMethodBeat.o(14026);
        return a2;
    }

    public void setAudioVolumeEvaluationListener(ITXAudioVolumeEvaluationListener iTXAudioVolumeEvaluationListener) {
        AppMethodBeat.i(14027);
        this.mTXLivePlayerImpl.a(iTXAudioVolumeEvaluationListener);
        AppMethodBeat.o(14027);
    }

    public void enableAudioVolumeEvaluation(int i2) {
        AppMethodBeat.i(14028);
        this.mTXLivePlayerImpl.e(i2);
        AppMethodBeat.o(14028);
    }

    public void callExperimentalAPI(String str) {
        AppMethodBeat.i(14029);
        this.mTXLivePlayerImpl.b(str);
        AppMethodBeat.o(14029);
    }

    public void setVideoRecordListener(TXRecordCommon.ITXVideoRecordListener iTXVideoRecordListener) {
        AppMethodBeat.i(14030);
        this.mTXLivePlayerImpl.a(iTXVideoRecordListener);
        AppMethodBeat.o(14030);
    }

    public int startRecord(int i2) {
        AppMethodBeat.i(14031);
        int f2 = this.mTXLivePlayerImpl.f(i2);
        AppMethodBeat.o(14031);
        return f2;
    }

    public int stopRecord() {
        AppMethodBeat.i(14032);
        int d2 = this.mTXLivePlayerImpl.d();
        AppMethodBeat.o(14032);
        return d2;
    }

    public void snapshot(ITXSnapshotListener iTXSnapshotListener) {
        AppMethodBeat.i(14033);
        this.mTXLivePlayerImpl.a(iTXSnapshotListener);
        AppMethodBeat.o(14033);
    }

    public boolean addVideoRawData(byte[] bArr) {
        AppMethodBeat.i(14034);
        boolean a2 = this.mTXLivePlayerImpl.a(bArr);
        AppMethodBeat.o(14034);
        return a2;
    }

    public void setVideoRawDataListener(ITXVideoRawDataListener iTXVideoRawDataListener) {
        AppMethodBeat.i(14035);
        this.mTXLivePlayerImpl.a(iTXVideoRawDataListener);
        AppMethodBeat.o(14035);
    }

    public int setVideoRenderListener(ITXLivePlayVideoRenderListener iTXLivePlayVideoRenderListener, Object obj) {
        AppMethodBeat.i(222664);
        int a2 = this.mTXLivePlayerImpl.a(iTXLivePlayVideoRenderListener, obj);
        AppMethodBeat.o(222664);
        return a2;
    }

    public void setAudioRawDataListener(ITXAudioRawDataListener iTXAudioRawDataListener) {
        AppMethodBeat.i(14036);
        this.mTXLivePlayerImpl.a(iTXAudioRawDataListener);
        AppMethodBeat.o(14036);
    }

    public int prepareLiveSeek(String str, int i2) {
        AppMethodBeat.i(14037);
        int b2 = this.mTXLivePlayerImpl.b(str, i2);
        AppMethodBeat.o(14037);
        return b2;
    }

    public void seek(int i2) {
        AppMethodBeat.i(14038);
        this.mTXLivePlayerImpl.g(i2);
        AppMethodBeat.o(14038);
    }

    public int resumeLive() {
        AppMethodBeat.i(14039);
        int e2 = this.mTXLivePlayerImpl.e();
        AppMethodBeat.o(14039);
        return e2;
    }

    @Deprecated
    public void setAutoPlay(boolean z) {
        AppMethodBeat.i(14040);
        this.mTXLivePlayerImpl.d(z);
        AppMethodBeat.o(14040);
    }

    @Deprecated
    public void setRate(float f2) {
        AppMethodBeat.i(14041);
        this.mTXLivePlayerImpl.a(f2);
        AppMethodBeat.o(14041);
    }
}
