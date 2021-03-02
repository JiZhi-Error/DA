package com.tencent.mm.modelvoice;

import com.tencent.mm.compatible.util.b;

public interface d {

    public interface a {
        void onCompletion();
    }

    public interface b {
        void onError();
    }

    boolean Qt();

    double ZY();

    void a(a aVar);

    void a(b bVar);

    void bhQ();

    void c(b.a aVar);

    boolean c(String str, boolean z, int i2);

    void cU(boolean z);

    boolean da(boolean z);

    int getStatus();

    boolean isPlaying();

    boolean resume();
}
