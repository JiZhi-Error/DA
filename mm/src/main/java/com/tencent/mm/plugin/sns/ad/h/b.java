package com.tencent.mm.plugin.sns.ad.h;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.i.c;
import com.tencent.mm.protocal.protobuf.bvj;
import com.tencent.mm.protocal.protobuf.bvk;
import com.tencent.mm.sdk.platformtools.Log;

public final class b extends a<bvj, bvk> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.protocal.protobuf.dop, java.lang.Object[]] */
    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.ad.h.a
    public final /* synthetic */ void a(bvj bvj, Object[] objArr) {
        AppMethodBeat.i(202055);
        bvj bvj2 = bvj;
        if (bvj2 == null || c.w(objArr)) {
            AppMethodBeat.o(202055);
            return;
        }
        for (int i2 = 0; i2 < objArr.length; i2++) {
            Object obj = objArr[i2];
            if (obj instanceof String) {
                if (i2 == 0) {
                    bvj2.dNI = (String) obj;
                } else if (i2 == 1) {
                    bvj2.Mby = (String) obj;
                } else if (i2 == 2) {
                    bvj2.gTk = (String) obj;
                } else if (i2 == 3) {
                    bvj2.Mbz = (String) obj;
                }
            }
        }
        if (bvj2 != null) {
            StringBuilder sb = new StringBuilder("REQ:[");
            sb.append("appId: ");
            if (!TextUtils.isEmpty(bvj2.dNI)) {
                sb.append(bvj2.dNI);
            }
            sb.append(", stockid: ");
            if (!TextUtils.isEmpty(bvj2.Mby)) {
                sb.append(bvj2.Mby);
            }
            sb.append(", uxinfo: ");
            if (!TextUtils.isEmpty(bvj2.gTk)) {
                sb.append(bvj2.gTk);
            }
            sb.append(", compid: ");
            if (!TextUtils.isEmpty(bvj2.Mbz)) {
                sb.append(bvj2.Mbz);
            }
            sb.append("]");
            Log.d("SnsAd.CouponCardNetScene", sb.toString());
        }
        AppMethodBeat.o(202055);
    }

    public b(String str, String str2, String str3, String str4) {
        AppMethodBeat.i(202054);
        a(new bvj(), new bvk(), "/cgi-bin/mmoc-bin/adplayinfo/send_ad_coupon", 4743, str, str2, str3, str4);
        AppMethodBeat.o(202054);
    }
}
