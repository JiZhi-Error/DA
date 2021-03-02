package com.tencent.mm.loader.h;

import android.graphics.Bitmap;

public final class e<T> {
    private e<?> ice;
    public T value;

    public e() {
    }

    public e(T t) {
        this.value = t;
    }

    public final T getValue() {
        return this.value;
    }

    public final T value() {
        return this.value;
    }

    public final boolean isValid() {
        if (this.value == null) {
            return false;
        }
        if (this.value instanceof Bitmap) {
            return !this.value.isRecycled();
        }
        return true;
    }

    public final e aKq() {
        return this.ice;
    }
}
