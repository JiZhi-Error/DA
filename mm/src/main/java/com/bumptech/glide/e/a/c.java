package com.bumptech.glide.e.a;

import com.bumptech.glide.g.k;

@Deprecated
public abstract class c<Z> extends a<Z> {
    private final int height;
    private final int width;

    public c() {
        this((byte) 0);
    }

    private c(byte b2) {
        this.width = Integer.MIN_VALUE;
        this.height = Integer.MIN_VALUE;
    }

    @Override // com.bumptech.glide.e.a.e
    public final void a(d dVar) {
        if (!k.aT(this.width, this.height)) {
            throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + this.width + " and height: " + this.height + ", either provide dimensions in the constructor or call override()");
        }
        dVar.aS(this.width, this.height);
    }
}
