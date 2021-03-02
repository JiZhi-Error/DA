package com.tencent.mm.fontdecode;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class PathExtractor {
    private String filePath;
    private long hgs;

    @Keep
    public static class Metrics {
        public float ascender;
        public float descender;
        public float height;
    }

    private static native boolean nExtractPath(long j2, char c2, Path path, int[] iArr);

    private static native void nFinalize(long j2);

    private static native void nGetMetrics(long j2, Metrics metrics);

    private static native long nInit(String str);

    private static native void nSetTextSize(long j2, int i2);

    public PathExtractor(String str) {
        AppMethodBeat.i(145544);
        this.filePath = str;
        this.hgs = nInit(str);
        if (this.hgs != 0) {
            Log.i("MicroMsg.PathExtractor", "create for %s, %d", str, Long.valueOf(this.hgs));
            AppMethodBeat.o(145544);
            return;
        }
        Log.e("MicroMsg.PathExtractor", "create for %s failed", str);
        AppMethodBeat.o(145544);
    }

    public final boolean isValid() {
        return this.hgs != 0;
    }

    public final void setTextSize(int i2) {
        AppMethodBeat.i(145545);
        Log.i("MicroMsg.PathExtractor", "set text size %d, %d", Long.valueOf(this.hgs), Integer.valueOf(i2));
        nSetTextSize(this.hgs, i2);
        AppMethodBeat.o(145545);
    }

    public final void a(Metrics metrics) {
        AppMethodBeat.i(145546);
        if (metrics == null) {
            Log.w("MicroMsg.PathExtractor", "metrics is null");
            AppMethodBeat.o(145546);
            return;
        }
        nGetMetrics(this.hgs, metrics);
        metrics.height *= 0.015625f;
        metrics.ascender *= 0.015625f;
        metrics.descender *= 0.015625f;
        AppMethodBeat.o(145546);
    }

    public final boolean a(char c2, Path path, RectF rectF) {
        boolean z;
        AppMethodBeat.i(145547);
        int[] iArr = new int[4];
        try {
            z = nExtractPath(this.hgs, c2, path, iArr);
        } catch (Exception e2) {
            Log.e("MicroMsg.PathExtractor", "extract path error %c", Character.valueOf(c2));
            z = false;
        }
        if (z) {
            Matrix matrix = new Matrix();
            matrix.setScale(0.015625f, 0.015625f);
            path.transform(matrix);
            rectF.set(((float) iArr[0]) * 0.015625f, ((float) iArr[3]) * 0.015625f, ((float) iArr[2]) * 0.015625f, ((float) iArr[1]) * 0.015625f);
            Log.i("MicroMsg.PathExtractor", "load path for ".concat(String.valueOf(c2)));
            AppMethodBeat.o(145547);
            return true;
        }
        Log.w("MicroMsg.PathExtractor", "not such char ".concat(String.valueOf(c2)));
        AppMethodBeat.o(145547);
        return false;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        AppMethodBeat.i(145548);
        try {
            nFinalize(this.hgs);
        } finally {
            super.finalize();
            AppMethodBeat.o(145548);
        }
    }

    static {
        AppMethodBeat.i(145549);
        System.loadLibrary("fontdecode");
        AppMethodBeat.o(145549);
    }
}
