package com.tencent.e.b;

import android.content.Context;
import android.os.Build;
import com.tencent.e.e.a.a.a;
import com.tencent.e.f.b;
import com.tencent.e.f.d;
import com.tencent.e.f.i;
import com.tencent.e.f.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.system.MimeTypeUtil;

public final class c {
    private int RKX = -1;
    private com.tencent.e.c.a.c RKZ = null;
    private Context mContext;
    private String mVersionName = null;

    public c(Context context) {
        AppMethodBeat.i(138316);
        this.mContext = context;
        a cU = i.cU(context, context.getPackageName());
        this.mVersionName = cU.versionName;
        this.RKX = cU.versionCode;
        AppMethodBeat.o(138316);
    }

    public final byte[] c(String str, String str2, com.tencent.e.e.a.b.a aVar) {
        AppMethodBeat.i(138317);
        byte[] bArr = null;
        try {
            l lVar = new l();
            lVar.IK();
            lVar.cy(str);
            lVar.cz(str2);
            lVar.bqf(MimeTypeUtil.ContentType.DEFAULT_CHARSET);
            lVar.put("userInfo", a(aVar));
            lVar.put("req", aVar);
            byte[] compress = b.compress(lVar.IJ());
            if (compress == null) {
                RuntimeException runtimeException = new RuntimeException("compress data fail");
                AppMethodBeat.o(138317);
                throw runtimeException;
            }
            bArr = com.tencent.e.f.c.n(compress, com.tencent.e.f.c.hkP());
            AppMethodBeat.o(138317);
            return bArr;
        } catch (Exception e2) {
        }
    }

    private com.tencent.e.c.a.c a(com.tencent.e.e.a.b.a aVar) {
        int i2;
        int i3;
        int i4;
        AppMethodBeat.i(138318);
        if (this.RKZ == null) {
            this.RKZ = new com.tencent.e.c.a.c();
            this.RKZ.RLj = 82;
            this.RKZ.RLo = this.RKX;
            this.RKZ.RLh = new StringBuilder().append(aVar.channel).toString();
            this.RKZ.RLg = aVar.RLg;
            try {
                String[] split = this.mVersionName.trim().split("[\\.]");
                if (split == null || split.length < 3) {
                    i2 = 0;
                    i3 = 0;
                    i4 = 0;
                } else {
                    i4 = Integer.parseInt(split[0]);
                    i3 = Integer.parseInt(split[1]);
                    i2 = Integer.parseInt(split[2]);
                }
                this.RKZ.RLk = new com.tencent.e.c.a.b();
                this.RKZ.RLk.RLd = i4;
                this.RKZ.RLk.RLe = i3;
                this.RKZ.RLk.RLf = i2;
            } catch (Exception e2) {
            }
            this.RKZ.RLl = 0;
            this.RKZ.RLn = d.getSDKVersion();
            this.RKZ.imei = bpY(aVar.imei);
            this.RKZ.imsi = bpY(aVar.imsi);
            this.RKZ.KFF = bpY(Build.MODEL);
            this.RKZ.aid = bpY(d.kZ(this.mContext));
            this.RKZ.RLt = bpY(d.DO(true));
            this.RKZ.RLu = bpY(d.DO(false));
            this.RKZ.RLm = 0;
        }
        this.RKZ.RLi = getNetworkType();
        this.RKZ.guid = bpY("");
        com.tencent.e.c.a.c cVar = this.RKZ;
        AppMethodBeat.o(138318);
        return cVar;
    }

    private int getNetworkType() {
        AppMethodBeat.i(138319);
        try {
            if (d.la(this.mContext) == d.a.CONN_WIFI) {
                AppMethodBeat.o(138319);
                return 2;
            }
            AppMethodBeat.o(138319);
            return 1;
        } catch (Throwable th) {
            AppMethodBeat.o(138319);
            return 2;
        }
    }

    private static String bpY(String str) {
        return str == null ? "" : str;
    }
}
