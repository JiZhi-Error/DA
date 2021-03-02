package com.tencent.i.a.e;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.h.c.f;
import com.tencent.h.c.h;
import com.tencent.h.d.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.system.MimeTypeUtil;

public final class a {
    private int Stw;
    private b Stx = null;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
        this.Stw = 91;
    }

    public final byte[] a(String str, String str2, com.tencent.i.a.c.b.a aVar) {
        byte[] bArr = null;
        AppMethodBeat.i(214828);
        if (aVar == null) {
            AppMethodBeat.o(214828);
        } else {
            try {
                com.tencent.h.d.a aVar2 = new com.tencent.h.d.a();
                aVar2.IK();
                aVar2.cy(str);
                aVar2.cz(str2);
                aVar2.bqf(MimeTypeUtil.ContentType.DEFAULT_CHARSET);
                if (this.Stx == null) {
                    this.Stx = new b();
                    this.Stx.RLj = this.Stw;
                    this.Stx.RLo = (int) aVar.SrO;
                    this.Stx.RLh = String.valueOf(aVar.channelId);
                    this.Stx.RLg = aVar.RLg;
                    this.Stx.RLl = 0;
                    this.Stx.RLn = aVar.sdkVer;
                    this.Stx.imei = TextUtils.isEmpty(aVar.imei) ? "" : aVar.imei;
                    this.Stx.imsi = aVar.imsi;
                    this.Stx.RLm = 0;
                }
                this.Stx.RLi = getNetworkType();
                aVar2.put("user", this.Stx);
                aVar2.put("req", aVar);
                byte[] compress = com.tencent.h.c.a.compress(aVar2.IJ());
                if (compress == null) {
                    RuntimeException runtimeException = new RuntimeException("compress game1.data fail");
                    AppMethodBeat.o(214828);
                    throw runtimeException;
                }
                bArr = com.tencent.h.c.b.n(compress, com.tencent.h.c.b.hkP());
                AppMethodBeat.o(214828);
            } catch (Exception e2) {
                h.e("sensor_WupProxy", e2);
            }
        }
        return bArr;
    }

    private int getNetworkType() {
        AppMethodBeat.i(214829);
        try {
            if (f.lt(this.mContext) == 0) {
                AppMethodBeat.o(214829);
                return 2;
            }
            AppMethodBeat.o(214829);
            return 1;
        } catch (Throwable th) {
            AppMethodBeat.o(214829);
            return 2;
        }
    }
}
