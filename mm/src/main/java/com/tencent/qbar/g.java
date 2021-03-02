package com.tencent.qbar;

import android.graphics.Point;
import android.graphics.PointF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.qbar.QbarNative;
import com.tencent.qbar.WxQbarNative;
import com.tencent.qbar.a;
import com.tencent.scanlib.b.a;
import java.util.ArrayList;
import java.util.List;

public final class g extends a {
    private int RKo = 0;

    public g(String str) {
        super(str);
        AppMethodBeat.i(91168);
        this.ROD = new f();
        AppMethodBeat.o(91168);
    }

    public final List<a.C2180a> a(byte[] bArr, int i2, int i3, List<QbarNative.QBarPoint> list, List<WxQbarNative.QBarReportMsg> list2) {
        AppMethodBeat.i(91169);
        synchronized (this.CCt) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                int d2 = ((f) this.ROD).d(bArr, i2, i3, true);
                if (d2 < 0) {
                    Log.e("WxQBarAIDecoder", "scanImage result ".concat(String.valueOf(d2)));
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                int b2 = ((f) this.ROD).b(arrayList, list, list2, true);
                this.RKo = ((f) this.ROD).RKo;
                Log.i("WxQBarAIDecoder", String.format("get %d results ,cost %dms", Integer.valueOf(b2), Long.valueOf(System.currentTimeMillis() - currentTimeMillis)));
                AppMethodBeat.o(91169);
                return arrayList;
            } finally {
                AppMethodBeat.o(91169);
            }
        }
    }

    public final int hkn() {
        int i2;
        synchronized (this.CCt) {
            i2 = this.RKo;
        }
        return i2;
    }

    public final void hko() {
        AppMethodBeat.i(91170);
        b.a((f) this.ROD);
        AppMethodBeat.o(91170);
    }

    public final void setBlackInterval(int i2) {
        AppMethodBeat.i(176208);
        b.a((f) this.ROD, i2);
        AppMethodBeat.o(176208);
    }

    public final List<a.C2180a> a(int[] iArr, Point point, PointF pointF, List<QbarNative.QBarPoint> list, List<WxQbarNative.QBarReportMsg> list2, boolean z) {
        AppMethodBeat.i(194831);
        Log.i("WxQBarAIDecoder", "decodeFile size: %s, useNewInterface: %b", point, Boolean.valueOf(z));
        long currentTimeMillis = System.currentTimeMillis();
        if (iArr.length <= 0) {
            Log.w("WxQBarAIDecoder", "prepareGrayData , data is null");
            AppMethodBeat.o(194831);
            return null;
        }
        byte[] bArr = new byte[(point.x * point.y)];
        int a2 = d.a(iArr, bArr, point.x, point.y);
        if (a2 != 0) {
            Log.e("WxQBarAIDecoder", "rotate result ".concat(String.valueOf(a2)));
            AppMethodBeat.o(194831);
            return null;
        }
        int d2 = ((f) this.ROD).d(bArr, point.x, point.y, z);
        if (d2 < 0) {
            Log.e("WxQBarAIDecoder", "scanImage result ".concat(String.valueOf(d2)));
            AppMethodBeat.o(194831);
            return null;
        }
        if (pointF != null) {
            ((f) this.ROD).aG(pointF.x, pointF.y);
        }
        ArrayList arrayList = new ArrayList();
        Log.i("WxQBarAIDecoder", String.format("get %d results ,cost %dms", Integer.valueOf(((f) this.ROD).b(arrayList, list, list2, z)), Long.valueOf(System.currentTimeMillis() - currentTimeMillis)));
        AppMethodBeat.o(194831);
        return arrayList;
    }

    public final void reset(boolean z) {
        AppMethodBeat.i(194832);
        synchronized (this.CCt) {
            try {
                if (this.ROD != null) {
                    ((f) this.ROD).reset(z);
                }
            } finally {
                AppMethodBeat.o(194832);
            }
        }
    }

    public final String jS() {
        AppMethodBeat.i(194833);
        synchronized (this.CCt) {
            try {
                if (this.ROD != null) {
                    return ((f) this.ROD).jS() + "wait frame: " + this.RKo;
                }
                AppMethodBeat.o(194833);
                return "";
            } finally {
                AppMethodBeat.o(194833);
            }
        }
    }
}
