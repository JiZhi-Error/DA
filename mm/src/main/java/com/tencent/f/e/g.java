package com.tencent.f.e;

import java.util.concurrent.Executor;

public interface g extends Executor {
    String getTag();

    void onShutdown();
}
