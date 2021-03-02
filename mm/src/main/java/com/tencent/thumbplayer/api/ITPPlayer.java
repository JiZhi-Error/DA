package com.tencent.thumbplayer.api;

import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.thumbplayer.a.b.b.a;
import com.tencent.thumbplayer.api.ITPPlayerListener;
import com.tencent.thumbplayer.api.composition.ITPMediaAsset;
import com.tencent.thumbplayer.api.proxy.ITPPlayerProxy;
import com.tencent.thumbplayer.api.proxy.TPDownloadParamData;
import com.tencent.thumbplayer.api.report.ITPBusinessReportManager;
import com.tencent.thumbplayer.api.resourceloader.ITPAssetResourceLoaderListener;
import com.tencent.thumbplayer.f.b;
import java.util.Map;

public interface ITPPlayer {
    public static final String TP_MIMETYPE_TEXT_SUBRIP = "text/x-subrip";
    public static final String TP_MIMETYPE_TEXT_VTT = "text/vtt";
    public static final int TP_PLAYER_LOOPBACK_ENDPOSITION_DEFAULT = -1;
    public static final int TP_PLAYER_LOOPBACK_STARTPOSITION_DEFAULT = 0;
    @a.h(3)
    public static final int TP_PLAYER_SEEK_MODE_ACCURATE_POSITION = 3;
    @a.h(1)
    public static final int TP_PLAYER_SEEK_MODE_FREVIOUS_KFRAME = 1;
    @a.h(4)
    public static final int TP_PLAYER_SEEK_MODE_NEXT_CLIP = 4;
    @a.h(2)
    public static final int TP_PLAYER_SEEK_MODE_NEXT_KFRAME = 2;
    @a.i(3)
    public static final int TP_PLAYER_SWITCH_DEF_AFTER_ALL_RESOURCE_CONSUME = 3;
    @a.i(2)
    public static final int TP_PLAYER_SWITCH_DEF_FAST_WITH_KEEP_NO_BUFFERING = 2;
    @a.i(1)
    public static final int TP_PLAYER_SWITCH_DEF_IMMEDIATELY = 1;

    void addAudioTrackSource(String str, String str2);

    void addAudioTrackSource(String str, String str2, TPDownloadParamData tPDownloadParamData);

    void addSubtitleSource(String str, String str2, String str3);

    void addSubtitleSource(String str, String str2, String str3, TPDownloadParamData tPDownloadParamData);

    void captureVideo(TPCaptureParams tPCaptureParams, TPCaptureCallBack tPCaptureCallBack);

    void deselectTrack(int i2, long j2);

    void enableTPAssetResourceLoader(ITPAssetResourceLoaderListener iTPAssetResourceLoaderListener, Looper looper);

    void enableTPAssetResourceLoader(com.tencent.thumbplayer.e.a.a aVar);

    int getBufferPercent();

    long getCurrentPositionMs();

    int getCurrentState();

    long getDurationMs();

    long getPlayableDurationMs();

    ITPPlayerProxy getPlayerProxy();

    int getPlayerType();

    TPProgramInfo[] getProgramInfo();

    long getPropertyLong(int i2);

    String getPropertyString(int i2);

    ITPBusinessReportManager getReportManager();

    TPTrackInfo[] getTrackInfo();

    int getVideoHeight();

    int getVideoWidth();

    void pause();

    void pauseDownload();

    void prepareAsync();

    void release();

    void reset();

    void resumeDownload();

    void seekTo(int i2);

    void seekTo(int i2, int i3);

    void selectProgram(int i2, long j2);

    void selectTrack(int i2, long j2);

    void setAudioGainRatio(float f2);

    void setAudioNormalizeVolumeParams(String str);

    void setDataSource(ParcelFileDescriptor parcelFileDescriptor);

    void setDataSource(ITPMediaAsset iTPMediaAsset);

    void setDataSource(String str);

    void setDataSource(String str, Map<String, String> map);

    void setLoopback(boolean z);

    void setLoopback(boolean z, long j2, long j3);

    void setOnAudioFrameOutputListener(ITPPlayerListener.IOnAudioFrameOutputListener iOnAudioFrameOutputListener);

    void setOnAudioProcessFrameOutputListener(ITPPlayerListener.IOnAudioProcessFrameOutputListener iOnAudioProcessFrameOutputListener);

    void setOnCompletionListener(ITPPlayerListener.IOnCompletionListener iOnCompletionListener);

    void setOnErrorListener(ITPPlayerListener.IOnErrorListener iOnErrorListener);

    void setOnInfoListener(ITPPlayerListener.IOnInfoListener iOnInfoListener);

    void setOnPlayerStateChangeListener(ITPPlayerListener.IOnStateChangeListener iOnStateChangeListener);

    void setOnPreparedListener(ITPPlayerListener.IOnPreparedListener iOnPreparedListener);

    void setOnSeekCompleteListener(ITPPlayerListener.IOnSeekCompleteListener iOnSeekCompleteListener);

    void setOnStopAsyncCompleteListener(ITPPlayerListener.IOnStopAsyncCompleteListener iOnStopAsyncCompleteListener);

    void setOnSubtitleDataListener(ITPPlayerListener.IOnSubtitleDataListener iOnSubtitleDataListener);

    void setOnSubtitleFrameOutListener(ITPPlayerListener.IOnSubtitleFrameOutListener iOnSubtitleFrameOutListener);

    void setOnVideoFrameOutListener(ITPPlayerListener.IOnVideoFrameOutListener iOnVideoFrameOutListener);

    void setOnVideoProcessFrameOutputListener(ITPPlayerListener.IOnVideoProcessFrameOutputListener iOnVideoProcessFrameOutputListener);

    void setOnVideoSizeChangedListener(ITPPlayerListener.IOnVideoSizeChangedListener iOnVideoSizeChangedListener);

    void setOutputMute(boolean z);

    void setPlaySpeedRatio(float f2);

    void setPlayerOptionalParam(TPOptionalParam tPOptionalParam);

    void setSurface(Surface surface);

    void setSurfaceHolder(SurfaceHolder surfaceHolder);

    void setTPSurface(ITPSurface iTPSurface);

    void setVideoInfo(TPVideoInfo tPVideoInfo);

    void start();

    void stop();

    void stopAsync();

    void switchDefinition(ITPMediaAsset iTPMediaAsset, long j2, TPVideoInfo tPVideoInfo);

    void switchDefinition(ITPMediaAsset iTPMediaAsset, long j2, TPVideoInfo tPVideoInfo, int i2);

    void switchDefinition(String str, long j2, TPVideoInfo tPVideoInfo);

    void switchDefinition(String str, long j2, TPVideoInfo tPVideoInfo, int i2);

    void updateLoggerContext(b bVar);
}
