package com.tencent.mm.plugin.appbrand.jsapi.video.e;

import android.view.Surface;

public interface c {

    public interface a {
        void id(int i2);
    }

    public interface b {
        void QA();
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.video.e.c$c  reason: collision with other inner class name */
    public interface AbstractC0716c {
        void bKA();
    }

    public interface d {
        void abu(String str);
    }

    public interface e {
        boolean cc(int i2, int i3);
    }

    public interface f {
        boolean cb(int i2, int i3);
    }

    public interface g {
        void a(c cVar);
    }

    public interface h {
        void b(c cVar);
    }

    public interface i {
        void a(c cVar, int i2, int i3);
    }

    void a(a aVar);

    void a(b bVar);

    void a(d dVar);

    void a(e eVar);

    void a(f fVar);

    void a(g gVar);

    void a(h hVar);

    void a(i iVar);

    void a(String str, String str2, AbstractC0716c cVar);

    boolean aP(float f2);

    void dU(String str, String str2);

    int getCurrentPosition();

    int getDuration();

    int getState();

    int getVideoHeight();

    int getVideoWidth();

    boolean isPlaying();

    void pause();

    void prepareAsync();

    void release();

    void reset();

    void seekTo(long j2);

    void setDataSource(String str);

    void setLooping(boolean z);

    void setMute(boolean z);

    void setSurface(Surface surface);

    void setVolume(float f2, float f3);

    void start();

    void stop();
}
