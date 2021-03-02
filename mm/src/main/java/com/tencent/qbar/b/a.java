package com.tencent.qbar.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lcom/tencent/qbar/util/ScanBitmapUtil;", "", "()V", "TAG", "", "calculateInSampleSize", "", "imageWidth", "imageHeight", "reqWidth", "reqHeight", "scan-sdk_release"})
public final class a {
    public static final a RKD = new a();

    static {
        AppMethodBeat.i(194811);
        AppMethodBeat.o(194811);
    }

    private a() {
    }

    public static final int calculateInSampleSize(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(194810);
        int i6 = 1;
        if (i3 > i5 || i2 > i4) {
            if (i2 > i3) {
                i6 = Math.round((((float) i3) / ((float) i5)) + 0.5f);
            } else {
                i6 = Math.round((((float) i2) / ((float) i4)) + 0.5f);
            }
            while ((((float) i2) * ((float) i3)) / ((float) (i6 * i6)) > ((float) (i4 * i5)) * 2.0f) {
                i6++;
            }
        }
        AppMethodBeat.o(194810);
        return i6;
    }
}
