package com.tencent.mm.plugin.d.a.b.a;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.d.a.b.h;
import com.tencent.mm.sdk.platformtools.Log;

@TargetApi(18)
public class f extends a {
    static final String TAG = f.class.getName();
    public static String pjh = h.phL;
    public static String pji = h.phM;
    public int pjj = -1;
    public int pjk = -1;
    public int pjl = -1;
    public long pjm = 0;
    public long pjn = 0;

    static {
        AppMethodBeat.i(22584);
        AppMethodBeat.o(22584);
    }

    public f() {
        this.pie = null;
        this.pif = 8;
        this.phx = 1;
    }

    @Override // com.tencent.mm.plugin.d.a.b.a.a
    public final byte[] ckM() {
        AppMethodBeat.i(22583);
        if (this.pjj < 0) {
            Log.e(TAG, "stepCount is invalid");
            AppMethodBeat.o(22583);
            return null;
        }
        int i2 = this.pjk >= 0 ? 7 : 4;
        if (this.pjl >= 0) {
            i2 += 3;
        }
        byte[] bArr = new byte[i2];
        bArr[0] = 1;
        int i3 = 1;
        for (int i4 = 0; i4 < 3; i4++) {
            bArr[i3] = (byte) ((this.pjj >> (i4 * 8)) & 255);
            i3++;
        }
        if (this.pjk >= 0) {
            bArr[0] = (byte) (bArr[0] | 2);
            for (int i5 = 0; i5 < 3; i5++) {
                bArr[i3] = (byte) ((this.pjk >> (i5 * 8)) & 255);
                i3++;
            }
        }
        if (this.pjl >= 0) {
            bArr[0] = 4;
            int i6 = 0;
            int i7 = i3;
            while (i6 < 3) {
                bArr[i7] = (byte) ((this.pjl >> (i6 * 8)) & 255);
                i6++;
                i7++;
            }
        }
        AppMethodBeat.o(22583);
        return bArr;
    }
}
