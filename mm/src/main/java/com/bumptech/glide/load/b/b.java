package com.bumptech.glide.load.b;

/* access modifiers changed from: package-private */
public final class b extends RuntimeException {
    b(Throwable th) {
        super("Unexpected exception thrown by non-Glide code", th);
    }
}