package com.tencent.mm.picker.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.picker.base.a.a;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import com.tenpay.android.wechat.PayuSecureEncrypt;
import junit.framework.Assert;

public final class b implements a {
    private Context ctx;
    private final String[] jJU = {"1", "2", TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL, "4", "5", "6", "7", "8", "9", PayuSecureEncrypt.ENCRYPT_VERSION_DEFAULT, "11", "12"};
    private final int[] jJV = {R.string.fmk, R.string.fmj, R.string.fmn, R.string.fmg, R.string.fmo, R.string.fmm, R.string.fml, R.string.fmh, R.string.fmr, R.string.fmq, R.string.fmp, R.string.fmi};

    public b(Context context) {
        AppMethodBeat.i(175287);
        this.ctx = context;
        AppMethodBeat.o(175287);
    }

    @Override // com.tencent.mm.picker.base.a.a
    public final String Sf(String str) {
        AppMethodBeat.i(175288);
        Assert.assertEquals(12, this.jJU.length);
        Assert.assertEquals(12, this.jJV.length);
        int i2 = 0;
        while (true) {
            if (i2 >= this.jJU.length) {
                break;
            } else if (str.equals(this.jJU[i2])) {
                str = this.ctx.getResources().getString(this.jJV[i2]);
                break;
            } else {
                i2++;
            }
        }
        AppMethodBeat.o(175288);
        return str;
    }
}
