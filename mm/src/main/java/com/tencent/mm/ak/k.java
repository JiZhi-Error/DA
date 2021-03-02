package com.tencent.mm.ak;

public interface k {

    public interface a {
        void onCompletion();
    }

    public interface b {
        void onError();
    }

    public interface c {
        void fw(boolean z);
    }

    public interface d {
        void onStop();
    }

    boolean YY();

    double ZY();

    void a(a aVar);

    void a(b bVar);

    void a(c cVar);

    void a(d dVar);

    boolean a(String str, boolean z, int i2, int i3);

    boolean a(String str, boolean z, boolean z2, int i2);

    void cU(boolean z);

    void cY(boolean z);

    void cZ(boolean z);

    void db(boolean z);

    boolean isCalling();

    boolean isPlaying();

    boolean pause();

    boolean resume();

    void stop();

    void stop(boolean z);

    void unInit();
}
