package io.flutter.embedding.engine.plugins.lifecycle;

import android.arch.lifecycle.Lifecycle;
import android.support.annotation.Keep;

@Keep
public class HiddenLifecycleReference {
    private final Lifecycle lifecycle;

    public HiddenLifecycleReference(Lifecycle lifecycle2) {
        this.lifecycle = lifecycle2;
    }

    public Lifecycle getLifecycle() {
        return this.lifecycle;
    }
}
