package com.tencent.scanlib.b;

import android.graphics.Point;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.qbar.QbarNative;
import com.tencent.qbar.a;
import com.tencent.qbar.d;
import com.tencent.stubs.logger.Log;
import java.util.List;

public class a {
    protected Object CCt = new Object();
    protected com.tencent.qbar.a ROD = new com.tencent.qbar.a();
    protected String TAG = "BaseQBarAIDecoder";
    protected boolean gKM;

    public a(String str) {
        AppMethodBeat.i(3546);
        this.TAG += "_" + str;
        AppMethodBeat.o(3546);
    }

    public final void a(int i2, QbarNative.QbarAiModelParam qbarAiModelParam) {
        AppMethodBeat.i(3547);
        if (this.gKM) {
            AppMethodBeat.o(3547);
            return;
        }
        try {
            synchronized (this.CCt) {
                try {
                    int a2 = this.ROD.a(i2, "ANY", MimeTypeUtil.ContentType.DEFAULT_CHARSET, qbarAiModelParam);
                    if (a2 != 0) {
                        Log.i(this.TAG, "init qbar error, ".concat(String.valueOf(a2)));
                        AppMethodBeat.o(3547);
                        return;
                    }
                    this.gKM = true;
                    Log.i(this.TAG, "init qbar success");
                } finally {
                    AppMethodBeat.o(3547);
                }
            }
        } catch (Exception e2) {
            AppMethodBeat.o(3547);
        }
    }

    public final boolean hasInited() {
        return this.gKM;
    }

    public final List<a.C2180a> a(int[] iArr, Point point) {
        AppMethodBeat.i(3548);
        Log.i(this.TAG, String.format("decode, size %s", point.toString()));
        if (iArr.length <= 0) {
            Log.w(this.TAG, "prepareGrayData , data is null");
            AppMethodBeat.o(3548);
            return null;
        }
        byte[] bArr = new byte[(point.x * point.y)];
        int a2 = d.a(iArr, bArr, point.x, point.y);
        if (a2 != 0) {
            Log.e(this.TAG, "rotate result ".concat(String.valueOf(a2)));
            AppMethodBeat.o(3548);
            return null;
        }
        List<a.C2180a> T = T(bArr, point.x, point.y);
        AppMethodBeat.o(3548);
        return T;
    }

    private List<a.C2180a> T(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(3549);
        long currentTimeMillis = System.currentTimeMillis();
        int S = this.ROD.S(bArr, i2, i3);
        if (S < 0) {
            Log.e(this.TAG, "scanImage result ".concat(String.valueOf(S)));
            AppMethodBeat.o(3549);
            return null;
        }
        List<a.C2180a> hkc = this.ROD.hkc();
        if (hkc == null || hkc.size() == 0) {
            Log.e(this.TAG, String.format("get no results ,cost %dms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis)));
        }
        Log.i(this.TAG, String.format("get %d results ,cost %dms", Integer.valueOf(hkc.size()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis)));
        AppMethodBeat.o(3549);
        return hkc;
    }

    public final void H(List<QbarNative.QBarCodeDetectInfo> list, List<QbarNative.QBarPoint> list2) {
        AppMethodBeat.i(3550);
        this.ROD.F(list, list2);
        Log.i(this.TAG, String.format("get detect code result %d", Integer.valueOf(list.size())));
        AppMethodBeat.o(3550);
    }

    public final QbarNative.QBarZoomInfo hlb() {
        AppMethodBeat.i(3551);
        QbarNative.QBarZoomInfo hkd = this.ROD.hkd();
        AppMethodBeat.o(3551);
        return hkd;
    }

    public final byte[] a(byte[] bArr, Point point, int i2, Rect rect, int[] iArr) {
        AppMethodBeat.i(3552);
        if (bArr == null || bArr.length <= 0) {
            Log.w(this.TAG, "prepareGrayData , data is null");
            AppMethodBeat.o(3552);
            return null;
        }
        Log.i(this.TAG, String.format("cropGrayData, size %s, rect %s, rotation %d", point, rect, Integer.valueOf(i2)));
        int width = rect != null ? rect.width() : point.x;
        int height = rect != null ? rect.height() : point.y;
        int i3 = rect != null ? rect.left : 0;
        int i4 = rect != null ? rect.top : 0;
        byte[] bArr2 = new byte[(((width * height) * 3) / 2)];
        synchronized (this.CCt) {
            try {
                int a2 = d.a(bArr2, iArr, bArr, point.x, point.y, i3, i4, width, height, i2);
                if (a2 != 0) {
                    Log.e(this.TAG, "rotate result ".concat(String.valueOf(a2)));
                    return null;
                }
                AppMethodBeat.o(3552);
                return bArr2;
            } finally {
                AppMethodBeat.o(3552);
            }
        }
    }

    public final List<a.C2180a> U(byte[] bArr, int i2, int i3) {
        List<a.C2180a> T;
        AppMethodBeat.i(3553);
        synchronized (this.CCt) {
            try {
                T = T(bArr, i2, i3);
            } finally {
                AppMethodBeat.o(3553);
            }
        }
        return T;
    }

    public final int T(int[] iArr) {
        int[] iArr2;
        AppMethodBeat.i(3554);
        if (iArr != null) {
            iArr2 = new int[iArr.length];
            int length = iArr.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                iArr2[i3] = iArr[i2];
                i2++;
                i3++;
            }
        } else {
            iArr2 = new int[5];
            iArr2[0] = 2;
            iArr2[1] = 1;
            iArr2[2] = 4;
            iArr2[3] = 5;
        }
        int l = this.ROD.l(iArr2, iArr2.length);
        AppMethodBeat.o(3554);
        return l;
    }

    public final void release() {
        AppMethodBeat.i(3555);
        synchronized (this.CCt) {
            try {
                this.gKM = false;
                if (this.ROD != null) {
                    this.ROD.release();
                }
            } finally {
                AppMethodBeat.o(3555);
            }
        }
    }
}
