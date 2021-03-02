package com.davemorrissey.labs.subscaleview.a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import android.os.Build;
import com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class e implements d {
    private final Bitmap.Config aEF;
    private BitmapRegionDecoder aWD;
    private final ReadWriteLock aWE;

    public e() {
        this((byte) 0);
    }

    private e(byte b2) {
        AppMethodBeat.i(157343);
        this.aWE = new ReentrantReadWriteLock(true);
        Bitmap.Config preferredBitmapConfig = SubsamplingScaleImageView.getPreferredBitmapConfig();
        if (preferredBitmapConfig != null) {
            this.aEF = preferredBitmapConfig;
            AppMethodBeat.o(157343);
            return;
        }
        this.aEF = Bitmap.Config.RGB_565;
        AppMethodBeat.o(157343);
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00b8  */
    @Override // com.davemorrissey.labs.subscaleview.a.d
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.graphics.Point d(android.content.Context r10, android.net.Uri r11) {
        /*
        // Method dump skipped, instructions count: 206
        */
        throw new UnsupportedOperationException("Method not decompiled: com.davemorrissey.labs.subscaleview.a.e.d(android.content.Context, android.net.Uri):android.graphics.Point");
    }

    @Override // com.davemorrissey.labs.subscaleview.a.d
    public final Bitmap a(Rect rect, int i2) {
        AppMethodBeat.i(157345);
        rH().lock();
        try {
            if (this.aWD == null || this.aWD.isRecycled()) {
                IllegalStateException illegalStateException = new IllegalStateException("Cannot decode region after decoder has been recycled");
                AppMethodBeat.o(157345);
                throw illegalStateException;
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = i2;
            options.inPreferredConfig = this.aEF;
            Bitmap decodeRegion = this.aWD.decodeRegion(rect, options);
            if (decodeRegion != null) {
                return decodeRegion;
            }
            RuntimeException runtimeException = new RuntimeException("Skia image decoder returned null bitmap - image format may not be supported");
            AppMethodBeat.o(157345);
            throw runtimeException;
        } finally {
            rH().unlock();
            AppMethodBeat.o(157345);
        }
    }

    @Override // com.davemorrissey.labs.subscaleview.a.d
    public final synchronized boolean isReady() {
        boolean z;
        AppMethodBeat.i(157346);
        if (this.aWD == null || this.aWD.isRecycled()) {
            z = false;
            AppMethodBeat.o(157346);
        } else {
            z = true;
            AppMethodBeat.o(157346);
        }
        return z;
    }

    @Override // com.davemorrissey.labs.subscaleview.a.d
    public final synchronized void recycle() {
        AppMethodBeat.i(157347);
        this.aWE.writeLock().lock();
        try {
            this.aWD.recycle();
            this.aWD = null;
        } finally {
            this.aWE.writeLock().unlock();
            AppMethodBeat.o(157347);
        }
    }

    private Lock rH() {
        AppMethodBeat.i(157348);
        if (Build.VERSION.SDK_INT < 21) {
            Lock writeLock = this.aWE.writeLock();
            AppMethodBeat.o(157348);
            return writeLock;
        }
        Lock readLock = this.aWE.readLock();
        AppMethodBeat.o(157348);
        return readLock;
    }
}
