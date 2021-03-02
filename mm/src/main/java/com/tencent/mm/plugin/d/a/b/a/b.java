package com.tencent.mm.plugin.d.a.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.d.a.b.h;
import com.tencent.mm.sdk.platformtools.Log;

public class b extends a {
    static final String TAG = b.class.getName();
    public static String pig = h.phZ;
    public static String pih = h.pia;
    public static String pii = h.pib;
    private final int pij = 1;
    private final int pik = 2;
    private final int pil = 4;
    private final int pim = 8;
    private final int pio = 16;
    C0935b pip;
    a piq;
    int pir;

    public static class c {
        public int mDay = 0;
        public int mMonth = 0;
        public int mYear = 0;
        public int piC = 0;
        public int piD = 0;
        public int piE = 0;

        public final boolean P(byte[] bArr, int i2) {
            AppMethodBeat.i(22570);
            String str = b.TAG;
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(bArr == null ? 0 : bArr.length);
            objArr[1] = Integer.valueOf(i2);
            objArr[2] = 7;
            Log.d(str, "data size = %d, offset = %d, lenght = %d", objArr);
            if (bArr == null || i2 < 0 || bArr.length < i2 + 7) {
                Log.e(b.TAG, "data input error");
                AppMethodBeat.o(22570);
                return false;
            }
            this.mYear = (bArr[i2] & 255) + ((bArr[i2 + 1] & 255) << 8);
            this.mMonth = bArr[i2 + 2] & 255;
            this.mDay = bArr[i2 + 3] & 255;
            this.piC = bArr[i2 + 4] & 255;
            this.piD = bArr[i2 + 5] & 255;
            this.piE = bArr[i2 + 6] & 255;
            Log.d(b.TAG, "year = %d, month = %d, day = %d, hours = %d, minutes = %d, seconds = %d", Integer.valueOf(this.mYear), Integer.valueOf(this.mMonth), Integer.valueOf(this.mDay), Integer.valueOf(this.piC), Integer.valueOf(this.piD), Integer.valueOf(this.piE));
            AppMethodBeat.o(22570);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.d.a.b.a.b$b  reason: collision with other inner class name */
    class C0935b {
        public double piA = 0.0d;
        public double piB = 0.0d;
        public boolean pis = false;
        public int piu = 0;
        public int piv = 0;
        public int piw = 0;
        public c pix = new c();
        public double piz = 0.0d;

        public C0935b() {
            AppMethodBeat.i(22569);
            AppMethodBeat.o(22569);
        }
    }

    class a {
        public boolean pis = false;
        public double pit = 0.0d;
        public int piu = 0;
        public int piv = 0;
        public int piw = 0;
        public c pix = new c();

        public a() {
            AppMethodBeat.i(22568);
            AppMethodBeat.o(22568);
        }
    }

    static {
        AppMethodBeat.i(22572);
        AppMethodBeat.o(22572);
    }

    public b() {
        this.pie = null;
        this.pif = 2;
        this.phx = 8;
        this.pip = null;
    }

    static double O(byte[] bArr, int i2) {
        AppMethodBeat.i(22571);
        int i3 = (bArr[i2 + 1] << 8) & 65280;
        int i4 = (i3 >> 12) - 16;
        int i5 = i3 & 3840;
        int i6 = (bArr[i2] & 255) + (65280 & i5);
        double pow = ((double) i6) * Math.pow(10.0d, (double) i4);
        Log.d(TAG, "hbyte=" + i3 + " hvalue=" + i5 + " value=" + i6 + " exp=" + i4);
        AppMethodBeat.o(22571);
        return pow;
    }

    @Override // com.tencent.mm.plugin.d.a.b.a.a
    public final byte[] ckM() {
        return null;
    }
}
