package com.tencent.mm.av.a.c;

import java.util.concurrent.Executor;

public interface j extends Executor {
    boolean YY();

    boolean isShutdown();

    void pause();

    void remove(Object obj);

    void resume();
}
