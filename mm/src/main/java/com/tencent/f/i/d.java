package com.tencent.f.i;

import java.util.concurrent.Future;

public interface d<V> extends Future<V> {
    Thread getThread();
}
