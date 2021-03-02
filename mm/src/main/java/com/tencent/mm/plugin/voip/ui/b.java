package com.tencent.mm.plugin.voip.ui;

import android.content.Context;
import android.graphics.SurfaceTexture;
import com.tencent.mm.media.g.d;
import com.tencent.mm.plugin.voip.video.b.a;
import com.tencent.mm.plugin.voip.video.camera.prev.CaptureView;

public interface b {
    @Deprecated
    void a(SurfaceTexture surfaceTexture, d dVar);

    @Deprecated
    void a(byte[] bArr, long j2, int i2, int i3, int i4, int i5, int i6);

    void aUB(String str);

    @Deprecated
    a adw(int i2);

    void adx(int i2);

    void ady(int i2);

    void adz(int i2);

    void cF(int i2, String str);

    void ebH();

    void enR();

    @Deprecated
    void f(int i2, int i3, byte[] bArr);

    void fFL();

    @Deprecated
    void fJj();

    @Deprecated
    com.tencent.mm.plugin.voip.video.d.b fJk();

    Context fJl();

    void fJm();

    void fJn();

    @Deprecated
    void jA(int i2, int i3);

    void jD(int i2, int i3);

    @Deprecated
    void releaseSurfaceTexture();

    @Deprecated
    void requestRender();

    @Deprecated
    void setCaptureView(CaptureView captureView);

    void setConnectSec(long j2);

    @Deprecated
    void setHWDecMode(int i2);

    void setMute(boolean z);

    void setScreenEnable(boolean z);

    @Deprecated
    void setSpatiotemporalDenosing(int i2);

    void setVoicePlayDevice(int i2);

    @Deprecated
    void setVoipBeauty(int i2);

    void uninit();

    void xi(boolean z);
}
