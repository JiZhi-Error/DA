package com.tencent.mm.plugin.mmsight.segment.a;

import android.view.Surface;

public interface a {

    /* renamed from: com.tencent.mm.plugin.mmsight.segment.a.a$a  reason: collision with other inner class name */
    public interface AbstractC1482a {
        boolean hc(int i2, int i3);
    }

    public interface b {
        void dD(Object obj);
    }

    public interface c {
        void dE(Object obj);
    }

    public interface d {
        void ap(int i2, int i3, int i4);
    }

    void a(AbstractC1482a aVar);

    void a(b bVar);

    void a(c cVar);

    void a(d dVar);

    int getCurrentPosition();

    int getDuration();

    boolean isPlaying();

    void pause();

    void prepareAsync();

    void release();

    void seekTo(int i2);

    void setAudioStreamType(int i2);

    void setDataSource(String str);

    void setLoop(int i2, int i3);

    void setLooping(boolean z);

    void setSurface(Surface surface);

    void start();

    void stop();
}
