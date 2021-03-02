package com.tencent.mm.plugin.sns.ad.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.sns.ad.e.l;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.data.k;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.AdSnsInfo;
import com.tencent.mm.plugin.sns.storage.g;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.aez;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class c {
    public static void c(LinkedList<aez> linkedList, int i2, int i3) {
        int i4 = 0;
        AppMethodBeat.i(201899);
        if (i2 > 0) {
            Log.i("AdPullDeleteHelper", "handleAdPullDelete, count=" + i2 + ", scene=" + i3);
            if (linkedList == null || linkedList.size() != i2) {
                StringBuilder append = new StringBuilder("handleAdPullDelete, count=").append(i2).append(", list.size=");
                if (linkedList != null) {
                    i4 = linkedList.size();
                }
                Log.e("AdPullDeleteHelper", append.append(i4).toString());
            } else {
                l.a aVar = new l.a();
                StringBuilder sb = new StringBuilder();
                for (int i5 = 0; i5 < i2; i5++) {
                    long j2 = linkedList.get(i5).Id;
                    String Jb = r.Jb(j2);
                    sb.append(Jb).append("|");
                    if (j2 != 0) {
                        AdSnsInfo JE = aj.faR().JE(j2);
                        if (JE == null) {
                            sb.append(1).append(", ");
                            aVar.m("", Jb, 1, 1);
                            Log.i("AdPullDeleteHelper", "handleAdPullDelete, adSnsInfo==null, snsId=".concat(String.valueOf(Jb)));
                        } else {
                            int IN = IN(j2);
                            aVar.m(JE.getAdInfo().uxInfo, Jb, 1, IN);
                            sb.append(IN).append(", ");
                        }
                    }
                }
                aVar.report();
                Log.i("AdPullDeleteHelper", "handleAdPullDelete, ret=" + sb.toString());
                AppMethodBeat.o(201899);
                return;
            }
        }
        AppMethodBeat.o(201899);
    }

    private static int IN(long j2) {
        boolean z = true;
        AppMethodBeat.i(201900);
        AdSnsInfo JE = aj.faR().JE(j2);
        String Jb = r.Jb(j2);
        if (JE == null) {
            Log.w("AdPullDeleteHelper", "deleteAd, adSnsInfo==null, snsId=".concat(String.valueOf(Jb)));
            AppMethodBeat.o(201900);
            return 1;
        }
        try {
            SnsObject snsObject = (SnsObject) new SnsObject().parseFrom(JE.field_attrBuf);
            if (snsObject == null) {
                Log.w("AdPullDeleteHelper", "deleteAd, snsObject==null, snsId=".concat(String.valueOf(Jb)));
                AppMethodBeat.o(201900);
                return 4;
            }
            boolean a2 = k.a(snsObject, z.aTY());
            if ((JE.field_localFlag & 128) <= 0) {
                z = false;
            }
            Log.i("AdPullDeleteHelper", "deleteAd, hasCommentLike=" + a2 + ", isExposure=" + z + ", snsId=" + Jb);
            if (a2) {
                AppMethodBeat.o(201900);
                return 2;
            } else if (z) {
                AppMethodBeat.o(201900);
                return 3;
            } else {
                aj.faR().delete(j2);
                aj.faT().JI(j2);
                g.JH(j2);
                try {
                    i.a(0, j2, JE.getAdInfo(), JE.getAdXml());
                } catch (Throwable th) {
                    Log.e("AdPullDeleteHelper", "deleteAd, reportAdDel exp=" + th.toString());
                }
                AppMethodBeat.o(201900);
                return 0;
            }
        } catch (Exception e2) {
            Log.e("AdPullDeleteHelper", "deleteAD, snsId=" + r.Jb(j2) + ", exp=" + e2.toString());
            AppMethodBeat.o(201900);
            return 4;
        }
    }
}
