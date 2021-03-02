package com.tencent.mm.loader.h;

import android.graphics.Bitmap;
import kotlin.t;

public final class c<R> {
    private static final int STATUS_DEFAULT = -1;
    private static final int STATUS_OK;
    private static final int ibV = 1;
    private static final int ibW = 2;
    private static final int ibX = 3;
    private static final int ibY = 4;
    private static final int ibZ;
    private static final int ica = 1;
    private static final int icb = 2;
    public static final a icc = new a((byte) 0);
    public int from;
    public int status;
    public R value;

    public c() {
        this.status = STATUS_DEFAULT;
    }

    public c(int i2, int i3, R r) {
        this.status = i2;
        this.from = i3;
        this.value = r;
    }

    public final boolean isValid() {
        if (this.value == null) {
            return false;
        }
        if (!(this.value instanceof Bitmap)) {
            return true;
        }
        R r = this.value;
        if (r != null) {
            return !r.isRecycled();
        }
        throw new t("null cannot be cast to non-null type android.graphics.Bitmap");
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
