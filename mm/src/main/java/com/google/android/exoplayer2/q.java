package com.google.android.exoplayer2;

public interface q {

    public interface a {
        void a(e eVar);

        void aA(int i2);

        void aR(boolean z);

        void b(p pVar);

        void c(boolean z, int i2);

        void tA();

        void ty();

        void tz();
    }

    void a(p pVar);

    void a(a aVar);

    void aO(boolean z);

    void b(a aVar);

    int getBufferedPercentage();

    long getBufferedPosition();

    long getCurrentPosition();

    long getDuration();

    boolean isLoading();

    void release();

    void seekTo(long j2);

    void setRepeatMode(int i2);

    void stop();

    int ti();

    boolean tj();
}
