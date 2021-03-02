package com.tencent.rtmp;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.liteav.audio.TXCAudioEngine;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.Monitor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.trtc.TRTCCloudListener;
import com.tencent.trtc.WXTRTCCloud;
import java.lang.ref.WeakReference;

public class WXLivePlayer extends TXLivePlayer implements ITXLivePlayListener, WXTRTCCloud.ITXAudioVolumeEvaluationListener {
    private static final String RTC_ADDRESS1 = "room://cloud.tencent.com/rtc";
    private static final String RTC_ADDRESS2 = "room://rtc.tencent.com";
    private static final String RTMP_PROXY_ADDRESS = "room://";
    private static final String TAG = "WXLivePlayer";
    private TXLivePlayer.ITXAudioVolumeEvaluationListener mAudioVolumeListener = null;
    private int mAudioVolumeNotifyInterval = 0;
    private boolean mIsRtmpProxy = false;
    private boolean mIsTRTC = false;
    private boolean mMuteAudio = false;
    private boolean mMuteVideo = false;
    private WXLivePlayConfig mPlayConfig = new WXLivePlayConfig();
    private WeakReference<ITXLivePlayListener> mPlayListener = null;
    private int mRenderMode = 1;
    private int mRenderRotation = 0;
    private String mStreamType = "";
    private Surface mSurface = null;
    private int mSurfaceHeight = 0;
    private int mSurfaceWidth = 0;
    private WXTRTCCloud mTRTCCloud = null;
    private boolean mTRTCPlaying = false;
    private String mUserId = "";
    private TXCloudVideoView mVideoView = null;

    public WXLivePlayer(Context context) {
        super(context);
        AppMethodBeat.i(14101);
        this.mTRTCCloud = WXTRTCCloud.sharedInstance(context);
        AppMethodBeat.o(14101);
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        this.mTRTCCloud = null;
    }

    @Override // com.tencent.rtmp.TXLivePlayer
    public void setPlayerView(TXCloudVideoView tXCloudVideoView) {
        AppMethodBeat.i(14102);
        super.setPlayerView(tXCloudVideoView);
        this.mVideoView = tXCloudVideoView;
        AppMethodBeat.o(14102);
    }

    @Override // com.tencent.rtmp.TXLivePlayer
    public void setPlayListener(ITXLivePlayListener iTXLivePlayListener) {
        AppMethodBeat.i(14103);
        super.setPlayListener(iTXLivePlayListener);
        this.mPlayListener = new WeakReference<>(iTXLivePlayListener);
        AppMethodBeat.o(14103);
    }

    @Override // com.tencent.rtmp.TXLivePlayer
    public void setSurface(Surface surface) {
        AppMethodBeat.i(14104);
        super.setSurface(surface);
        this.mSurface = surface;
        apiLog("[API] setSurface", "userId: " + this.mUserId + ", surface: " + surface);
        if (this.mIsTRTC && this.mTRTCPlaying && !TextUtils.isEmpty(this.mUserId) && !TextUtils.isEmpty(this.mStreamType)) {
            if (this.mStreamType.equalsIgnoreCase("aux")) {
                this.mTRTCCloud.setRemoteSubStreamSurface(this.mUserId, this.mSurface);
                AppMethodBeat.o(14104);
                return;
            }
            this.mTRTCCloud.setRemoteSurface(this.mUserId, this.mSurface);
        }
        AppMethodBeat.o(14104);
    }

    @Override // com.tencent.rtmp.TXLivePlayer
    public void setSurfaceSize(int i2, int i3) {
        AppMethodBeat.i(14105);
        super.setSurfaceSize(i2, i3);
        this.mSurfaceWidth = i2;
        this.mSurfaceHeight = i3;
        apiLog("[API] setSurfaceSize", "width: " + i2 + ", height: " + i3 + ", userId: " + this.mUserId);
        if (this.mIsTRTC && this.mTRTCPlaying && !TextUtils.isEmpty(this.mUserId) && !TextUtils.isEmpty(this.mStreamType)) {
            if (this.mStreamType.equalsIgnoreCase("aux")) {
                this.mTRTCCloud.setRemoteSubStreamSurfaceSize(this.mUserId, i2, i3);
                AppMethodBeat.o(14105);
                return;
            }
            this.mTRTCCloud.setRemoteSurfaceSize(this.mUserId, i2, i3);
        }
        AppMethodBeat.o(14105);
    }

    @Override // com.tencent.rtmp.TXLivePlayer
    public boolean isPlaying() {
        AppMethodBeat.i(14106);
        if (this.mIsTRTC) {
            boolean z = this.mTRTCPlaying;
            AppMethodBeat.o(14106);
            return z;
        }
        boolean isPlaying = super.isPlaying();
        AppMethodBeat.o(14106);
        return isPlaying;
    }

    public void showDebugLog(boolean z) {
        AppMethodBeat.i(14107);
        if (this.mVideoView != null) {
            this.mVideoView.showLog(z);
        }
        this.mTRTCCloud.showDebugView(z ? 2 : 0);
        AppMethodBeat.o(14107);
    }

    public void setConfig(WXLivePlayConfig wXLivePlayConfig) {
        AppMethodBeat.i(14108);
        apiLog("[API] setConfig", "config: ".concat(String.valueOf(wXLivePlayConfig)) != null ? wXLivePlayConfig.toString() : "");
        if (this.mIsTRTC) {
            Monitor.a(1, "[API] setConfig", " config: ".concat(String.valueOf(wXLivePlayConfig)) != null ? wXLivePlayConfig.toString() : ", userId: " + this.mUserId, 0);
        }
        super.setConfig((TXLivePlayConfig) wXLivePlayConfig);
        this.mPlayConfig = wXLivePlayConfig;
        AppMethodBeat.o(14108);
    }

    public void muteAudio(boolean z) {
        AppMethodBeat.i(14109);
        apiLog("[API] muteAudio", "mute: " + z + ", userId: " + this.mUserId);
        if (this.mIsRtmpProxy) {
            Monitor.a(1, "[API] muteAudio", " mute: " + z + ", userId: " + this.mUserId, 0);
        }
        super.setMute(z);
        this.mMuteAudio = z;
        if (this.mIsTRTC && this.mTRTCPlaying) {
            Monitor.a(1, "[API] muteAudio", " mute: " + z + ", userId: " + this.mUserId, 0);
            this.mTRTCCloud.muteRemoteAudio(this.mUserId, z);
        }
        AppMethodBeat.o(14109);
    }

    public void muteVideo(boolean z) {
        AppMethodBeat.i(14110);
        apiLog("[API] muteVideo", "mute: " + z + ", userId: " + this.mUserId);
        if (this.mIsRtmpProxy) {
            Monitor.a(1, "[API] muteVideo", " mute: " + z + ", userId: " + this.mUserId, 0);
        }
        this.mMuteVideo = z;
        if (this.mIsTRTC && this.mTRTCPlaying) {
            Monitor.a(1, "[API] muteVideo", " mute: " + z + ", userId: " + this.mUserId, 0);
            this.mTRTCCloud.muteRemoteVideoStream(this.mUserId, z);
        }
        AppMethodBeat.o(14110);
    }

    @Override // com.tencent.rtmp.TXLivePlayer
    public void setRenderMode(int i2) {
        AppMethodBeat.i(14111);
        apiLog("[API] setRenderMode", "mode: " + i2 + ", userId: " + this.mUserId);
        super.setRenderMode(i2);
        if (i2 == 0) {
            this.mRenderMode = 0;
        } else if (i2 == 1) {
            this.mRenderMode = 1;
        }
        if (this.mIsTRTC && this.mTRTCPlaying) {
            if (this.mStreamType.equalsIgnoreCase("aux")) {
                this.mTRTCCloud.setRemoteSubStreamViewFillMode(this.mUserId, this.mRenderMode);
                AppMethodBeat.o(14111);
                return;
            }
            this.mTRTCCloud.setRemoteViewFillMode(this.mUserId, this.mRenderMode);
        }
        AppMethodBeat.o(14111);
    }

    @Override // com.tencent.rtmp.TXLivePlayer
    public void setRenderRotation(int i2) {
        AppMethodBeat.i(14112);
        apiLog("[API] setRenderRotation", "rotation: " + i2 + ", userId: " + this.mUserId);
        super.setRenderRotation(i2);
        if (i2 == 270) {
            this.mRenderRotation = 3;
        } else if (i2 == 0) {
            this.mRenderRotation = 0;
        }
        if (this.mIsTRTC && this.mTRTCPlaying) {
            if (this.mStreamType.equalsIgnoreCase("aux")) {
                this.mTRTCCloud.setRemoteSubStreamViewRotation(this.mUserId, this.mRenderRotation);
                AppMethodBeat.o(14112);
                return;
            }
            this.mTRTCCloud.setRemoteViewRotation(this.mUserId, this.mRenderRotation);
        }
        AppMethodBeat.o(14112);
    }

    @Override // com.tencent.rtmp.TXLivePlayer
    public void setAudioRoute(int i2) {
        AppMethodBeat.i(14113);
        apiLog("[API] setAudioRoute", "audioRoute: ".concat(String.valueOf(i2)));
        Monitor.a(1, "[API] setAudioRoute", " audioRoute: ".concat(String.valueOf(i2)), 0);
        TXCAudioEngine.setAudioRoute(i2);
        AppMethodBeat.o(14113);
    }

    @Override // com.tencent.rtmp.TXLivePlayer
    public void snapshot(final TXLivePlayer.ITXSnapshotListener iTXSnapshotListener) {
        AppMethodBeat.i(14114);
        if (!this.mIsTRTC) {
            super.snapshot(iTXSnapshotListener);
        } else if (this.mTRTCPlaying) {
            if (this.mStreamType.equalsIgnoreCase("aux")) {
                this.mTRTCCloud.snapshotVideo(this.mUserId, 2, new TRTCCloudListener.TRTCSnapshotListener() {
                    /* class com.tencent.rtmp.WXLivePlayer.AnonymousClass1 */

                    @Override // com.tencent.trtc.TRTCCloudListener.TRTCSnapshotListener
                    public void onSnapshotComplete(Bitmap bitmap) {
                        AppMethodBeat.i(182234);
                        if (iTXSnapshotListener != null) {
                            iTXSnapshotListener.onSnapshot(bitmap);
                        }
                        AppMethodBeat.o(182234);
                    }
                });
                AppMethodBeat.o(14114);
                return;
            }
            this.mTRTCCloud.snapshotVideo(this.mUserId, 0, new TRTCCloudListener.TRTCSnapshotListener() {
                /* class com.tencent.rtmp.WXLivePlayer.AnonymousClass2 */

                @Override // com.tencent.trtc.TRTCCloudListener.TRTCSnapshotListener
                public void onSnapshotComplete(Bitmap bitmap) {
                    AppMethodBeat.i(182240);
                    if (iTXSnapshotListener != null) {
                        iTXSnapshotListener.onSnapshot(bitmap);
                    }
                    AppMethodBeat.o(182240);
                }
            });
            AppMethodBeat.o(14114);
            return;
        }
        AppMethodBeat.o(14114);
    }

    @Override // com.tencent.rtmp.TXLivePlayer
    public void enableAudioVolumeEvaluation(int i2) {
        AppMethodBeat.i(14115);
        this.mAudioVolumeNotifyInterval = i2;
        super.enableAudioVolumeEvaluation(i2);
        AppMethodBeat.o(14115);
    }

    @Override // com.tencent.rtmp.TXLivePlayer
    public void setAudioVolumeEvaluationListener(TXLivePlayer.ITXAudioVolumeEvaluationListener iTXAudioVolumeEvaluationListener) {
        AppMethodBeat.i(14116);
        super.setAudioVolumeEvaluationListener(iTXAudioVolumeEvaluationListener);
        this.mAudioVolumeListener = iTXAudioVolumeEvaluationListener;
        AppMethodBeat.o(14116);
    }

    @Override // com.tencent.trtc.WXTRTCCloud.ITXAudioVolumeEvaluationListener
    public void onAudioVolumeEvaluationNotify(int i2) {
        AppMethodBeat.i(14117);
        if (this.mAudioVolumeListener != null) {
            this.mAudioVolumeListener.onAudioVolumeEvaluationNotify(i2);
        }
        AppMethodBeat.o(14117);
    }

    @Override // com.tencent.rtmp.TXLivePlayer
    public int startPlay(String str, int i2) {
        boolean z;
        AppMethodBeat.i(14118);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(14118);
            return -1;
        }
        this.mIsRtmpProxy = isRtmpProxyUrl(str);
        if (this.mIsRtmpProxy) {
            Monitor.a(1, "[API] startPlay", "url:" + str + " type:" + i2 + ", userId: " + this.mUserId, 0);
        }
        this.mIsTRTC = isTRTCPlayerUrl(str);
        apiLog("[API] startPlay", "url:" + str + " type:" + i2 + ", isTRTC: " + this.mIsTRTC + ", userId: " + this.mUserId);
        if (!this.mIsTRTC) {
            super.enableAudioVolumeEvaluation(this.mAudioVolumeNotifyInterval);
            int startPlay = super.startPlay(str, i2);
            AppMethodBeat.o(14118);
            return startPlay;
        } else if (parseTRTCParams(str)) {
            this.mTRTCCloud.muteRemoteAudio(this.mUserId, this.mMuteAudio);
            this.mTRTCCloud.muteRemoteVideoStream(this.mUserId, this.mMuteVideo);
            if (this.mStreamType.equalsIgnoreCase("main")) {
                this.mTRTCCloud.setRemoteVideoStreamType(this.mUserId, 0);
                this.mTRTCCloud.startRemoteView(this.mUserId, this.mVideoView);
                this.mTRTCCloud.setRemoteSurface(this.mUserId, this.mSurface);
                this.mTRTCCloud.setRemoteSurfaceSize(this.mUserId, this.mSurfaceWidth, this.mSurfaceHeight);
                z = false;
            } else if (this.mStreamType.equalsIgnoreCase("small")) {
                this.mTRTCCloud.setRemoteVideoStreamType(this.mUserId, 1);
                this.mTRTCCloud.startRemoteView(this.mUserId, this.mVideoView);
                this.mTRTCCloud.setRemoteSurface(this.mUserId, this.mSurface);
                this.mTRTCCloud.setRemoteSurfaceSize(this.mUserId, this.mSurfaceWidth, this.mSurfaceHeight);
                z = false;
            } else if (this.mStreamType.equalsIgnoreCase("aux")) {
                this.mTRTCCloud.startRemoteSubStreamView(this.mUserId, this.mVideoView);
                this.mTRTCCloud.setRemoteSubStreamSurface(this.mUserId, this.mSurface);
                this.mTRTCCloud.setRemoteSubStreamSurfaceSize(this.mUserId, this.mSurfaceWidth, this.mSurfaceHeight);
                z = true;
            } else {
                z = false;
            }
            if (z) {
                this.mTRTCCloud.setRemoteSubStreamViewFillMode(this.mUserId, this.mRenderMode);
            } else {
                this.mTRTCCloud.setRemoteViewFillMode(this.mUserId, this.mRenderMode);
            }
            if (z) {
                this.mTRTCCloud.setRemoteSubStreamViewRotation(this.mUserId, this.mRenderRotation);
            } else {
                this.mTRTCCloud.setRemoteViewRotation(this.mUserId, this.mRenderRotation);
            }
            this.mTRTCCloud.registerAudioVolumeEvaluationListener(this.mUserId, z, this);
            this.mTRTCCloud.registerPlayListener(this.mUserId, z, this);
            this.mTRTCPlaying = true;
            Monitor.a(1, "[API] startPlay", "url:" + str + " type:" + i2 + ", userId: " + this.mUserId, 0);
            AppMethodBeat.o(14118);
            return 0;
        } else {
            TXCLog.e(TAG, "parse playUrl failed!!!");
            AppMethodBeat.o(14118);
            return -1;
        }
    }

    @Override // com.tencent.rtmp.TXLivePlayer
    public int stopPlay(boolean z) {
        boolean z2 = true;
        AppMethodBeat.i(14119);
        apiLog("[API] stopPlay", "isNeedClearLastImg: " + z + ", isTRTC: " + this.mIsTRTC + ", userId: " + this.mUserId);
        if (this.mIsRtmpProxy) {
            Monitor.a(1, "[API] stopPlay", "isNeedClearLastImg: " + z + ", isTRTC: " + this.mIsTRTC + ", userId: " + this.mUserId, 0);
        }
        if (z && this.mVideoView != null) {
            this.mVideoView.setVisibility(8);
        }
        if (this.mIsTRTC) {
            Monitor.a(1, "[API] stopPlay", "isNeedClearLastImg: " + z + ", isTRTC: " + this.mIsTRTC + ", userId: " + this.mUserId, 0);
            if (this.mStreamType.equalsIgnoreCase("main")) {
                this.mTRTCCloud.stopRemoteView(this.mUserId);
                z2 = false;
            } else if (this.mStreamType.equalsIgnoreCase("small")) {
                this.mTRTCCloud.stopRemoteView(this.mUserId);
                z2 = false;
            } else if (this.mStreamType.equalsIgnoreCase("aux")) {
                this.mTRTCCloud.stopRemoteSubStreamView(this.mUserId);
            } else {
                z2 = false;
            }
            this.mTRTCCloud.unregisterAudioVolumeEvaluationListener(this.mUserId, z2);
            this.mTRTCCloud.unregisterPlayListener(this.mUserId, z2);
            resetParams();
            AppMethodBeat.o(14119);
            return 0;
        }
        resetParams();
        int stopPlay = super.stopPlay(z);
        AppMethodBeat.o(14119);
        return stopPlay;
    }

    @Override // com.tencent.rtmp.ITXLivePlayListener
    public void onPlayEvent(int i2, Bundle bundle) {
        ITXLivePlayListener iTXLivePlayListener;
        AppMethodBeat.i(14120);
        apiLog("[API] onPlayEvent", "event: ".concat(String.valueOf(i2)));
        if (this.mIsTRTC) {
            Monitor.a(1, "[API] onPlayEvent", "event: " + i2 + ", userId: " + this.mUserId, 0);
        }
        if (!(this.mPlayListener == null || (iTXLivePlayListener = this.mPlayListener.get()) == null)) {
            iTXLivePlayListener.onPlayEvent(i2, bundle);
        }
        AppMethodBeat.o(14120);
    }

    @Override // com.tencent.rtmp.ITXLivePlayListener
    public void onNetStatus(Bundle bundle) {
        ITXLivePlayListener iTXLivePlayListener;
        AppMethodBeat.i(14121);
        if (!(this.mPlayListener == null || (iTXLivePlayListener = this.mPlayListener.get()) == null)) {
            iTXLivePlayListener.onNetStatus(bundle);
        }
        AppMethodBeat.o(14121);
    }

    private void resetParams() {
        this.mIsTRTC = false;
        this.mTRTCPlaying = false;
        this.mUserId = "";
        this.mStreamType = "";
    }

    private boolean isTRTCPlayerUrl(String str) {
        AppMethodBeat.i(14122);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(14122);
            return false;
        } else if (str.startsWith(RTC_ADDRESS1) || str.startsWith(RTC_ADDRESS2)) {
            AppMethodBeat.o(14122);
            return true;
        } else {
            AppMethodBeat.o(14122);
            return false;
        }
    }

    private boolean isRtmpProxyUrl(String str) {
        AppMethodBeat.i(259976);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(259976);
            return false;
        } else if (str.startsWith(RTC_ADDRESS1) || str.startsWith(RTC_ADDRESS2)) {
            AppMethodBeat.o(259976);
            return false;
        } else {
            boolean startsWith = str.startsWith(RTMP_PROXY_ADDRESS);
            AppMethodBeat.o(259976);
            return startsWith;
        }
    }

    private boolean parseTRTCParams(String str) {
        AppMethodBeat.i(14123);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(14123);
            return false;
        }
        try {
            String[] split = str.split("[?&]");
            for (String str2 : split) {
                if (str2.indexOf("=") != -1) {
                    String[] split2 = str2.split("[=]");
                    if (split2.length == 2) {
                        String str3 = split2[0];
                        String str4 = split2[1];
                        if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
                            if (str3.equalsIgnoreCase("userid")) {
                                this.mUserId = str4;
                            } else if (str3.equalsIgnoreCase("streamtype")) {
                                this.mStreamType = str4;
                            }
                        }
                    }
                }
            }
        } catch (Exception e2) {
            TXCLog.e(TAG, "parse trtc params failed.", e2);
        }
        if (TextUtils.isEmpty(this.mStreamType)) {
            this.mStreamType = "main";
        }
        if (TextUtils.isEmpty(this.mUserId)) {
            AppMethodBeat.o(14123);
            return false;
        }
        AppMethodBeat.o(14123);
        return true;
    }

    public void apiLog(String str, String str2) {
        AppMethodBeat.i(259977);
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        TXCLog.i(TAG, ("wx_liveplayer(" + hashCode() + ") " + str) + " " + str2);
        AppMethodBeat.o(259977);
    }
}
