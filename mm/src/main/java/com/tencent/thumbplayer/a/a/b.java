package com.tencent.thumbplayer.a.a;

import android.os.ParcelFileDescriptor;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.thumbplayer.a.a.c;
import com.tencent.thumbplayer.api.TPCaptureCallBack;
import com.tencent.thumbplayer.api.TPCaptureParams;
import com.tencent.thumbplayer.api.TPCommonEnum;
import com.tencent.thumbplayer.api.TPOptionalParam;
import com.tencent.thumbplayer.api.TPProgramInfo;
import com.tencent.thumbplayer.api.TPTrackInfo;
import com.tencent.thumbplayer.api.composition.ITPMediaAsset;
import java.util.List;
import java.util.Map;

public interface b {
    void L(String str, @TPCommonEnum.TPSwitchDefMode int i2, long j2);

    void a(c.a aVar);

    void a(c.b bVar);

    void a(c.AbstractC2201c cVar);

    void a(c.d dVar);

    void a(c.e eVar);

    void a(c.f fVar);

    void a(c.g gVar);

    void a(c.i iVar);

    void a(c.j jVar);

    void a(c.k kVar);

    void a(c.l lVar);

    void a(c.m mVar);

    void a(ITPMediaAsset iTPMediaAsset, @TPCommonEnum.TPSwitchDefMode int i2, long j2);

    void addSubtitleSource(String str, String str2, String str3);

    void captureVideo(TPCaptureParams tPCaptureParams, TPCaptureCallBack tPCaptureCallBack);

    void deselectTrack(int i2, long j2);

    void g(String str, String str2, List<TPOptionalParam> list);

    long getCurrentPositionMs();

    long getDurationMs();

    long getPlayableDurationMs();

    TPProgramInfo[] getProgramInfo();

    long getPropertyLong(int i2);

    String getPropertyString(int i2);

    TPTrackInfo[] getTrackInfo();

    int getVideoHeight();

    int getVideoWidth();

    void pause();

    void prepare();

    void prepareAsync();

    void release();

    void reset();

    void seekTo(int i2);

    void seekTo(int i2, @TPCommonEnum.TPSeekMode int i3);

    void selectProgram(int i2, long j2);

    void selectTrack(int i2, long j2);

    void setAudioGainRatio(float f2);

    void setAudioNormalizeVolumeParams(String str);

    void setDataSource(ParcelFileDescriptor parcelFileDescriptor);

    void setDataSource(ITPMediaAsset iTPMediaAsset);

    void setDataSource(String str, Map<String, String> map);

    void setLoopback(boolean z);

    void setLoopback(boolean z, long j2, long j3);

    void setOutputMute(boolean z);

    void setPlaySpeedRatio(float f2);

    void setPlayerOptionalParam(TPOptionalParam tPOptionalParam);

    void setSurface(Surface surface);

    void setSurfaceHolder(SurfaceHolder surfaceHolder);

    void start();

    void stop();

    void updateLoggerContext(com.tencent.thumbplayer.f.b bVar);
}
