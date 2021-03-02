package com.tencent.mm.plugin.appbrand.appcache;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.b.p;
import com.tencent.mm.co.f;
import com.tencent.mm.plugin.appbrand.appcache.j;
import com.tencent.mm.plugin.appbrand.config.t;
import com.tencent.mm.protocal.protobuf.acc;
import com.tencent.mm.protocal.protobuf.bml;
import com.tencent.mm.protocal.protobuf.km;
import com.tencent.mm.protocal.protobuf.kn;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;

public final class g extends c<kn> {
    final d rr;

    public g(km kmVar) {
        this(kmVar, "/cgi-bin/mmbiz-bin/wxaapp/batchgetwxadownloadurl");
    }

    private g(km kmVar, String str) {
        AppMethodBeat.i(174705);
        d.a aVar = new d.a();
        aVar.funcId = 1713;
        aVar.uri = str;
        aVar.iLN = kmVar;
        aVar.iLO = new kn();
        if (kmVar.KOF == null || kmVar.KOF.dUS == 0) {
            Iterator<bml> it = kmVar.KOE.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Integer num = t.lfK.get(it.next().LVf.dNI);
                if (num != null && num.intValue() > 0) {
                    if (kmVar.KOF == null) {
                        kmVar.KOF = new acc();
                        kmVar.KOF.LmF = false;
                        kmVar.KOF.LmG = 1;
                    }
                    kmVar.KOF.dUS = num.intValue();
                }
            }
        }
        d aXF = aVar.aXF();
        this.rr = aXF;
        c(aXF);
        AppMethodBeat.o(174705);
    }

    @Override // com.tencent.mm.ak.c
    public final f<c.a<kn>> aYI() {
        f<c.a<kn>> aYI;
        AppMethodBeat.i(226350);
        km kmVar = (km) super.rr.iLK.iLR;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(kmVar.scene);
        objArr[1] = a.a((acc) Objects.requireNonNull(kmVar.KOF));
        LinkedList<bml> linkedList = kmVar.KOE;
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (bml bml : linkedList) {
            sb.append("{");
            if (!TextUtils.isEmpty(bml.LVf.dNI)) {
                sb.append("appId:").append(bml.LVf.dNI);
            } else if (!TextUtils.isEmpty(bml.LVf.username)) {
                sb.append("username:").append(bml.LVf.username);
            }
            sb.append(", module:").append(bml.LVf.MbW);
            sb.append(", package_type:").append(bml.LVf.MbZ);
            sb.append(", version_type:").append(bml.LVf.KXC);
            if (j.a.sE(bml.LVf.KXC) && bml.LVk != 0) {
                sb.append(", dev_uin:").append(p.getString(bml.LVk));
            }
            if (bml.KXD > 0) {
                sb.append(", version:").append(bml.KXD);
            }
            if (bml.LVg != null && bml.LVg.KXD > 0) {
                sb.append(", local_version:").append(bml.LVg.KXD);
            }
            if (bml.LVj) {
                sb.append(", need_zstd:true");
            }
            sb.append("},");
        }
        sb.append("]");
        objArr[2] = sb.toString();
        Log.i("MicroMsg.AppBrand.CgiBatchGetPkgDownloadInfo", "run(), scene:%d, source:%s, req_list:%s", objArr);
        synchronized (this) {
            try {
                aYI = super.aYI();
            } finally {
                AppMethodBeat.o(226350);
            }
        }
        return aYI;
    }
}
