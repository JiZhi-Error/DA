package com.bumptech.glide.load.d.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import com.bumptech.glide.load.b.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.TXLiveConstants;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class q {
    private static final Paint aLv = new Paint(6);
    private static final Paint aLw = new Paint(7);
    private static final Paint aLx;
    private static final Set<String> aLy;
    private static final Lock aLz;

    static {
        AppMethodBeat.i(77436);
        HashSet hashSet = new HashSet(Arrays.asList("XT1085", "XT1092", "XT1093", "XT1094", "XT1095", "XT1096", "XT1097", "XT1098", "XT1031", "XT1028", "XT937C", "XT1032", "XT1008", "XT1033", "XT1035", "XT1034", "XT939G", "XT1039", "XT1040", "XT1042", "XT1045", "XT1063", "XT1064", "XT1068", "XT1069", "XT1072", "XT1077", "XT1078", "XT1079"));
        aLy = hashSet;
        aLz = hashSet.contains(Build.MODEL) ? new ReentrantLock() : new a();
        Paint paint = new Paint(7);
        aLx = paint;
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        AppMethodBeat.o(77436);
    }

    public static Lock pI() {
        return aLz;
    }

    public static int dn(int i2) {
        switch (i2) {
            case 3:
            case 4:
                return TXLiveConstants.RENDER_ROTATION_180;
            case 5:
            case 6:
                return 90;
            case 7:
            case 8:
                return 270;
            default:
                return 0;
        }
    }

    public static Bitmap a(e eVar, Bitmap bitmap, int i2) {
        Bitmap.Config config;
        AppMethodBeat.i(77435);
        if (!m2do(i2)) {
            AppMethodBeat.o(77435);
            return bitmap;
        }
        Matrix matrix = new Matrix();
        switch (i2) {
            case 2:
                matrix.setScale(-1.0f, 1.0f);
                break;
            case 3:
                matrix.setRotate(180.0f);
                break;
            case 4:
                matrix.setRotate(180.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 5:
                matrix.setRotate(90.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 6:
                matrix.setRotate(90.0f);
                break;
            case 7:
                matrix.setRotate(-90.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 8:
                matrix.setRotate(-90.0f);
                break;
        }
        RectF rectF = new RectF(0.0f, 0.0f, (float) bitmap.getWidth(), (float) bitmap.getHeight());
        matrix.mapRect(rectF);
        int round = Math.round(rectF.width());
        int round2 = Math.round(rectF.height());
        if (bitmap.getConfig() != null) {
            config = bitmap.getConfig();
        } else {
            config = Bitmap.Config.ARGB_8888;
        }
        Bitmap b2 = eVar.b(round, round2, config);
        matrix.postTranslate(-rectF.left, -rectF.top);
        b2.setHasAlpha(bitmap.hasAlpha());
        aLz.lock();
        try {
            Canvas canvas = new Canvas(b2);
            canvas.drawBitmap(bitmap, matrix, aLv);
            canvas.setBitmap(null);
            return b2;
        } finally {
            aLz.unlock();
            AppMethodBeat.o(77435);
        }
    }

    /* renamed from: do  reason: not valid java name */
    public static boolean m2do(int i2) {
        switch (i2) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return true;
            default:
                return false;
        }
    }

    static final class a implements Lock {
        a() {
        }

        public final void lock() {
        }

        @Override // java.util.concurrent.locks.Lock
        public final void lockInterruptibly() {
        }

        public final boolean tryLock() {
            return true;
        }

        @Override // java.util.concurrent.locks.Lock
        public final boolean tryLock(long j2, TimeUnit timeUnit) {
            return true;
        }

        public final void unlock() {
        }

        public final Condition newCondition() {
            AppMethodBeat.i(77434);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Should not be called");
            AppMethodBeat.o(77434);
            throw unsupportedOperationException;
        }
    }
}
