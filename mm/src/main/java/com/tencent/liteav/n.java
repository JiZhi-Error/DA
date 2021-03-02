package com.tencent.liteav;

import android.content.Context;
import android.view.Surface;
import com.tencent.liteav.basic.b.b;
import com.tencent.liteav.basic.c.o;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.ugc.TXRecordCommon;
import java.lang.ref.WeakReference;

public abstract class n {

    /* renamed from: a  reason: collision with root package name */
    protected h f852a = null;

    /* renamed from: b  reason: collision with root package name */
    protected Context f853b = null;

    /* renamed from: c  reason: collision with root package name */
    protected TXCloudVideoView f854c = null;

    /* renamed from: d  reason: collision with root package name */
    protected WeakReference<b> f855d;

    public abstract int a(String str, int i2);

    public abstract int a(boolean z);

    public abstract void a(int i2);

    public abstract void a(o oVar);

    public abstract void a(boolean z, int i2);

    public abstract void b(int i2);

    public abstract void b(boolean z);

    public abstract void c(int i2);

    public abstract void c(boolean z);

    public abstract boolean c();

    public abstract int d();

    public abstract int d(int i2);

    public abstract int h();

    public n(Context context) {
        if (context != null) {
            this.f853b = context.getApplicationContext();
        }
    }

    public h i() {
        return this.f852a;
    }

    public void a(h hVar) {
        this.f852a = hVar;
        if (this.f852a == null) {
            this.f852a = new h();
        }
    }

    public void a() {
        TXCLog.w("TXIPlayer", "pause not support");
    }

    public void b() {
        TXCLog.w("TXIPlayer", "resume not support");
    }

    public void a(Surface surface) {
    }

    public void a(int i2, int i3) {
    }

    public void e(int i2) {
        TXCLog.w("TXIPlayer", "seek not support");
    }

    public void a(TXCloudVideoView tXCloudVideoView) {
        this.f854c = tXCloudVideoView;
    }

    public void a(b bVar) {
        this.f855d = new WeakReference<>(bVar);
    }

    public void a(TXRecordCommon.ITXVideoRecordListener iTXVideoRecordListener) {
    }

    public void a(TXLivePlayer.ITXAudioRawDataListener iTXAudioRawDataListener) {
    }

    public void d(boolean z) {
        TXCLog.w("TXIPlayer", "autoPlay not implement");
    }

    public void a(float f2) {
        TXCLog.w("TXIPlayer", "rate not implement");
    }

    public void a(o oVar, com.tencent.liteav.basic.a.b bVar, Object obj) {
    }

    public int a(String str) {
        return -1;
    }

    public void f() {
    }

    public boolean e() {
        return false;
    }
}
