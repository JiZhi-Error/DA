package com.bumptech.glide.load.b.a;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Set;

public final class k implements e {
    private static final Bitmap.Config aIy = Bitmap.Config.ARGB_8888;
    private final Set<Bitmap.Config> aIA;
    private final long aIB;
    private final a aIC;
    private long aID;
    private int aIE;
    private int aIF;
    private int aIG;
    private int aIH;
    private final l aIz;
    private long maxSize;

    interface a {
    }

    private k(long j2, l lVar, Set<Bitmap.Config> set) {
        AppMethodBeat.i(77113);
        this.aIB = j2;
        this.maxSize = j2;
        this.aIz = lVar;
        this.aIA = set;
        this.aIC = new b();
        AppMethodBeat.o(77113);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public k(long r6) {
        /*
            r5 = this;
            r4 = 77114(0x12d3a, float:1.0806E-40)
            r3 = 19
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 < r3) goto L_0x003c
            com.bumptech.glide.load.b.a.n r0 = new com.bumptech.glide.load.b.a.n
            r0.<init>()
        L_0x000e:
            java.util.HashSet r1 = new java.util.HashSet
            android.graphics.Bitmap$Config[] r2 = android.graphics.Bitmap.Config.values()
            java.util.List r2 = java.util.Arrays.asList(r2)
            r1.<init>(r2)
            int r2 = android.os.Build.VERSION.SDK_INT
            if (r2 < r3) goto L_0x0023
            r2 = 0
            r1.add(r2)
        L_0x0023:
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 26
            if (r2 < r3) goto L_0x002e
            android.graphics.Bitmap$Config r2 = android.graphics.Bitmap.Config.HARDWARE
            r1.remove(r2)
        L_0x002e:
            java.util.Set r1 = java.util.Collections.unmodifiableSet(r1)
            r5.<init>(r6, r0, r1)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            return
        L_0x003c:
            com.bumptech.glide.load.b.a.c r0 = new com.bumptech.glide.load.b.a.c
            r0.<init>()
            goto L_0x000e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.b.a.k.<init>(long):void");
    }

    @Override // com.bumptech.glide.load.b.a.e
    public final synchronized void g(Bitmap bitmap) {
        AppMethodBeat.i(77115);
        if (bitmap == null) {
            NullPointerException nullPointerException = new NullPointerException("Bitmap must not be null");
            AppMethodBeat.o(77115);
            throw nullPointerException;
        } else if (bitmap.isRecycled()) {
            IllegalStateException illegalStateException = new IllegalStateException("Cannot pool recycled bitmap");
            AppMethodBeat.o(77115);
            throw illegalStateException;
        } else if (!bitmap.isMutable() || ((long) this.aIz.i(bitmap)) > this.maxSize || !this.aIA.contains(bitmap.getConfig())) {
            if (Log.isLoggable("LruBitmapPool", 2)) {
                new StringBuilder("Reject bitmap from pool, bitmap: ").append(this.aIz.h(bitmap)).append(", is mutable: ").append(bitmap.isMutable()).append(", is allowed config: ").append(this.aIA.contains(bitmap.getConfig()));
            }
            bitmap.recycle();
            AppMethodBeat.o(77115);
        } else {
            int i2 = this.aIz.i(bitmap);
            this.aIz.g(bitmap);
            this.aIG++;
            this.aID = ((long) i2) + this.aID;
            if (Log.isLoggable("LruBitmapPool", 2)) {
                new StringBuilder("Put bitmap in pool=").append(this.aIz.h(bitmap));
            }
            dump();
            o(this.maxSize);
            AppMethodBeat.o(77115);
        }
    }

    @Override // com.bumptech.glide.load.b.a.e
    public final Bitmap b(int i2, int i3, Bitmap.Config config) {
        AppMethodBeat.i(77116);
        Bitmap h2 = h(i2, i3, config);
        if (h2 != null) {
            h2.eraseColor(0);
        } else {
            h2 = createBitmap(i2, i3, config);
        }
        AppMethodBeat.o(77116);
        return h2;
    }

    @Override // com.bumptech.glide.load.b.a.e
    public final Bitmap g(int i2, int i3, Bitmap.Config config) {
        AppMethodBeat.i(77117);
        Bitmap h2 = h(i2, i3, config);
        if (h2 == null) {
            h2 = createBitmap(i2, i3, config);
        }
        AppMethodBeat.o(77117);
        return h2;
    }

    private static Bitmap createBitmap(int i2, int i3, Bitmap.Config config) {
        AppMethodBeat.i(77118);
        if (config == null) {
            config = aIy;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i2, i3, config);
        AppMethodBeat.o(77118);
        return createBitmap;
    }

    @Override // com.bumptech.glide.load.b.a.e
    public final void oZ() {
        AppMethodBeat.i(77120);
        Log.isLoggable("LruBitmapPool", 3);
        o(0);
        AppMethodBeat.o(77120);
    }

    @Override // com.bumptech.glide.load.b.a.e
    @SuppressLint({"InlinedApi"})
    public final void trimMemory(int i2) {
        AppMethodBeat.i(77121);
        Log.isLoggable("LruBitmapPool", 3);
        if (i2 >= 40) {
            oZ();
            AppMethodBeat.o(77121);
            return;
        }
        if (i2 >= 20 || i2 == 15) {
            o(this.maxSize / 2);
        }
        AppMethodBeat.o(77121);
    }

    private synchronized void o(long j2) {
        AppMethodBeat.i(77122);
        while (true) {
            if (this.aID <= j2) {
                AppMethodBeat.o(77122);
                break;
            }
            Bitmap pa = this.aIz.pa();
            if (pa == null) {
                if (Log.isLoggable("LruBitmapPool", 5)) {
                    pe();
                }
                this.aID = 0;
                AppMethodBeat.o(77122);
            } else {
                this.aID -= (long) this.aIz.i(pa);
                this.aIH++;
                if (Log.isLoggable("LruBitmapPool", 3)) {
                    new StringBuilder("Evicting bitmap=").append(this.aIz.h(pa));
                }
                dump();
                pa.recycle();
            }
        }
    }

    private void dump() {
        AppMethodBeat.i(77123);
        if (Log.isLoggable("LruBitmapPool", 2)) {
            pe();
        }
        AppMethodBeat.o(77123);
    }

    private void pe() {
        AppMethodBeat.i(77124);
        new StringBuilder("Hits=").append(this.aIE).append(", misses=").append(this.aIF).append(", puts=").append(this.aIG).append(", evictions=").append(this.aIH).append(", currentSize=").append(this.aID).append(", maxSize=").append(this.maxSize).append("\nStrategy=").append(this.aIz);
        AppMethodBeat.o(77124);
    }

    static final class b implements a {
        b() {
        }
    }

    private synchronized Bitmap h(int i2, int i3, Bitmap.Config config) {
        Bitmap b2;
        AppMethodBeat.i(77119);
        if (Build.VERSION.SDK_INT < 26 || config != Bitmap.Config.HARDWARE) {
            b2 = this.aIz.b(i2, i3, config != null ? config : aIy);
            if (b2 == null) {
                if (Log.isLoggable("LruBitmapPool", 3)) {
                    new StringBuilder("Missing bitmap=").append(this.aIz.c(i2, i3, config));
                }
                this.aIF++;
            } else {
                this.aIE++;
                this.aID -= (long) this.aIz.i(b2);
                b2.setHasAlpha(true);
                if (Build.VERSION.SDK_INT >= 19) {
                    b2.setPremultiplied(true);
                }
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                new StringBuilder("Get bitmap=").append(this.aIz.c(i2, i3, config));
            }
            dump();
            AppMethodBeat.o(77119);
        } else {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + config + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
            AppMethodBeat.o(77119);
            throw illegalArgumentException;
        }
        return b2;
    }
}
