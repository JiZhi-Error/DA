package io.flutter.embedding.engine;

import android.support.annotation.Keep;
import android.view.Surface;

@Keep
public class FlutterOverlaySurface {
    private final int id;
    private final Surface surface;

    public FlutterOverlaySurface(int i2, Surface surface2) {
        this.id = i2;
        this.surface = surface2;
    }

    public int getId() {
        return this.id;
    }

    public Surface getSurface() {
        return this.surface;
    }
}
