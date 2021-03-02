package com.tencent.mm.plugin.mmsight.segment;

public interface c {

    public interface a {
        void ri(boolean z);
    }

    public interface b {
        void W(float f2, float f3);

        void X(float f2, float f3);

        void Y(float f2, float f3);

        void Z(float f2, float f3);
    }

    void aFp(String str);

    float eko();

    float ekp();

    int getDurationMs();

    void release();

    void rh(boolean z);

    void setCurrentCursorPosition(float f2);

    void setOnPreparedListener(a aVar);

    void setThumbBarSeekListener(b bVar);
}
