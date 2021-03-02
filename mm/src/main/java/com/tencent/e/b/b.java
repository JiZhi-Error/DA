package com.tencent.e.b;

import android.content.Context;
import android.os.Build;
import com.tencent.e.c.a.a;
import com.tencent.e.c.a.c;
import com.tencent.e.f.d;
import com.tencent.e.f.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.system.MimeTypeUtil;

public final class b {
    private int RKW = -1;
    private int RKX = -1;
    private String RKY = null;
    private c RKZ = null;
    private a RLa = null;
    private String mChannelId = null;
    private Context mContext = null;
    private String mVersionName = null;

    public b(Context context) {
        AppMethodBeat.i(138313);
        this.mContext = context;
        com.tencent.e.a.a cT = com.tencent.e.f.a.cT(context, context.getPackageName());
        this.mVersionName = cT.versionName;
        this.RKX = cT.versionCode;
        this.RKW = 82;
        this.mChannelId = "105901";
        this.RKY = "7AD75E27CD5842F6";
        AppMethodBeat.o(138313);
    }

    public final byte[] a(com.tencent.e.c.b.a aVar) {
        AppMethodBeat.i(138314);
        byte[] bArr = null;
        try {
            l lVar = new l();
            lVar.IK();
            lVar.cy("viruscheck");
            lVar.cz("RiskCheck");
            lVar.bqf(MimeTypeUtil.ContentType.DEFAULT_CHARSET);
            if (this.RLa == null) {
                this.RLa = new a();
                this.RLa.RLb = 2;
                this.RLa.RLc = 201;
            }
            lVar.put("phonetype", this.RLa);
            lVar.put("userinfo", hkv());
            lVar.put("req", aVar);
            byte[] compress = com.tencent.e.f.b.compress(lVar.IJ());
            if (compress == null) {
                RuntimeException runtimeException = new RuntimeException("compress data fail");
                AppMethodBeat.o(138314);
                throw runtimeException;
            }
            bArr = com.tencent.e.f.c.n(compress, com.tencent.e.f.c.hkP());
            AppMethodBeat.o(138314);
            return bArr;
        } catch (Exception e2) {
        }
    }

    private c hkv() {
        int i2;
        int i3;
        int i4;
        int i5 = 2;
        AppMethodBeat.i(138315);
        if (this.RKZ == null) {
            this.RKZ = new c();
            this.RKZ.RLj = this.RKW;
            this.RKZ.RLo = this.RKX;
            this.RKZ.RLh = this.mChannelId;
            this.RKZ.RLg = this.RKY;
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
            this.RKZ.imei = bpY(d.getIMEI(this.mContext));
            this.RKZ.imsi = bpY(d.kY(this.mContext));
            this.RKZ.KFF = bpY(Build.MODEL);
            this.RKZ.aid = bpY(d.kZ(this.mContext));
            this.RKZ.RLt = bpY(d.DO(true));
            this.RKZ.RLu = bpY(d.DO(false));
            this.RKZ.guid = null;
            this.RKZ.RLm = 0;
        }
        c cVar = this.RKZ;
        if (d.la(this.mContext) != d.a.CONN_WIFI) {
            i5 = 1;
        }
        cVar.RLi = i5;
        c cVar2 = this.RKZ;
        AppMethodBeat.o(138315);
        return cVar2;
    }

    private static String bpY(String str) {
        return str == null ? "" : str;
    }
}
