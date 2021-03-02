package com.tencent.mm.plugin.sns.ad.timeline.dynamic;

import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.SparseArray;
import android.util.SparseLongArray;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.sns.ad.a.b;
import com.tencent.mm.plugin.sns.ad.a.g;
import com.tencent.mm.plugin.sns.ad.c.b;
import com.tencent.mm.plugin.sns.ad.i.c;
import com.tencent.mm.plugin.sns.ad.widget.living.b;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.protocal.protobuf.bz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class a {
    static volatile a DxO;
    private static final SparseLongArray DxQ;
    private final Map<String, SparseArray<c>> DxP = new ArrayMap();

    /* renamed from: com.tencent.mm.plugin.sns.ad.timeline.dynamic.a$a  reason: collision with other inner class name */
    public interface AbstractC1710a {
        void m(SnsInfo snsInfo);
    }

    public a() {
        AppMethodBeat.i(202126);
        AppMethodBeat.o(202126);
    }

    public static a eXI() {
        AppMethodBeat.i(202127);
        if (DxO == null) {
            synchronized (a.class) {
                try {
                    if (DxO == null) {
                        DxO = new a();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(202127);
                    throw th;
                }
            }
        }
        a aVar = DxO;
        AppMethodBeat.o(202127);
        return aVar;
    }

    public final void a(int i2, SnsInfo snsInfo) {
        AppMethodBeat.i(202128);
        try {
            a(i2, snsInfo, false);
            AppMethodBeat.o(202128);
        } catch (Throwable th) {
            AppMethodBeat.o(202128);
        }
    }

    public final void b(int i2, SnsInfo snsInfo) {
        AppMethodBeat.i(202129);
        try {
            a(i2, snsInfo, true);
            AppMethodBeat.o(202129);
        } catch (Throwable th) {
            AppMethodBeat.o(202129);
        }
    }

    public final void a(SnsInfo snsInfo, boolean z, AbstractC1710a aVar) {
        AppMethodBeat.i(202130);
        if (snsInfo == null || aVar == null || snsInfo.getAdXml() == null) {
            Log.w("SnsAd.DynamicUpdate", "the sns info or request action is null, please check it !!!");
            AppMethodBeat.o(202130);
            return;
        }
        try {
            String v = r.v(snsInfo);
            if (TextUtils.isEmpty(v) || AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(v)) {
                Log.w("SnsAd.DynamicUpdate", "the sns id is empty, is it right?");
                AppMethodBeat.o(202130);
            } else if (!a(v, 3, snsInfo.getAdXml().adDynamicUpdateInfo, z)) {
                Log.i("SnsAd.DynamicUpdate", "the request is too frequently, snsId is ".concat(String.valueOf(v)));
                AppMethodBeat.o(202130);
            } else {
                Log.d("SnsAd.DynamicUpdate", "it is going to do dynamic request, snsId is ".concat(String.valueOf(v)));
                aVar.m(snsInfo);
                AppMethodBeat.o(202130);
            }
        } catch (Throwable th) {
            AppMethodBeat.o(202130);
        }
    }

    private void a(int i2, SnsInfo snsInfo, boolean z) {
        AppMethodBeat.i(202131);
        if (snsInfo == null || snsInfo.getAdXml() == null || snsInfo.getAdXml().adLiveInfo == null) {
            AppMethodBeat.o(202131);
            return;
        }
        g gVar = snsInfo.getAdXml().adLiveInfo;
        if (gVar.liveType == 0) {
            b(i2, snsInfo, z);
            AppMethodBeat.o(202131);
        } else if (gVar.liveType == 1) {
            a(snsInfo, z);
            AppMethodBeat.o(202131);
        } else {
            if (gVar.liveType == 2) {
                b(snsInfo, z);
            }
            AppMethodBeat.o(202131);
        }
    }

    private void b(int i2, SnsInfo snsInfo, boolean z) {
        AppMethodBeat.i(202132);
        String v = r.v(snsInfo);
        String str = "";
        ADInfo adInfo = snsInfo.getAdInfo();
        if (i2 == 2) {
            adInfo = snsInfo.getAtAdInfo();
        }
        if (adInfo != null) {
            str = adInfo.uxInfo;
        }
        bz[] a2 = a(v, com.tencent.mm.plugin.sns.ad.widget.living.a.q(snsInfo), z);
        if (c.x(a2)) {
            new com.tencent.mm.plugin.sns.ad.h.c(v, str, a2).a(new b() {
                /* class com.tencent.mm.plugin.sns.ad.timeline.dynamic.a.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.sns.ad.timeline.dynamic.b
                public final void c(int i2, String str, List<bz> list) {
                    AppMethodBeat.i(202123);
                    int i3 = -1;
                    if (i2 == 0) {
                        try {
                            i3 = b.C(str, list);
                        } catch (Throwable th) {
                            AppMethodBeat.o(202123);
                            return;
                        }
                    }
                    Log.d("SnsAd.DynamicUpdate", "doWeAppLivingRequest::sns id is " + str + ", the status is " + i3);
                    AppMethodBeat.o(202123);
                }
            });
            AppMethodBeat.o(202132);
            return;
        }
        Log.d("SnsAd.DynamicUpdate", "doWeAppLivingRequest::is the time not expired??");
        AppMethodBeat.o(202132);
    }

    private void a(SnsInfo snsInfo, boolean z) {
        AppMethodBeat.i(202133);
        ADXml.AdCardActionBtnInfo adCardActionBtnInfo = snsInfo.getAdXml().adCardActionBtnInfo;
        if (adCardActionBtnInfo == null) {
            AppMethodBeat.o(202133);
            return;
        }
        String v = r.v(snsInfo);
        if (!r(v, 1000001, z)) {
            Log.i("SnsAd.DynamicUpdate", "requestFinderLivingNoticeState: is the time not expired??");
            AppMethodBeat.o(202133);
            return;
        }
        com.tencent.mm.plugin.sns.ad.c.b.a(v, adCardActionBtnInfo.finderUsername, adCardActionBtnInfo.finderLiveNoticeId, new b.a() {
            /* class com.tencent.mm.plugin.sns.ad.timeline.dynamic.a.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.sns.ad.c.b.a
            public final void b(String str, int i2, Object obj) {
                AppMethodBeat.i(202124);
                try {
                    Log.i("SnsAd.DynamicUpdate", "the requestLivingNoticeState return errorCode is  ".concat(String.valueOf(i2)));
                    if (i2 == 0 && (obj instanceof Integer)) {
                        com.tencent.mm.plugin.sns.ad.widget.living.b.fv(str, ((Integer) obj).intValue());
                    }
                    AppMethodBeat.o(202124);
                } catch (Throwable th) {
                    AppMethodBeat.o(202124);
                }
            }
        });
        AppMethodBeat.o(202133);
    }

    private void b(SnsInfo snsInfo, boolean z) {
        AppMethodBeat.i(202134);
        g gVar = snsInfo.getAdXml().adLiveInfo;
        String v = r.v(snsInfo);
        if (!r(v, 1000003, z)) {
            Log.i("SnsAd.DynamicUpdate", "requestFinderLivingState: is the time not expired??");
            AppMethodBeat.o(202134);
            return;
        }
        com.tencent.mm.plugin.sns.ad.c.b.a(v, gVar.finderLiveId, new b.a() {
            /* class com.tencent.mm.plugin.sns.ad.timeline.dynamic.a.AnonymousClass3 */

            @Override // com.tencent.mm.plugin.sns.ad.c.b.a
            public final void b(String str, int i2, Object obj) {
                AppMethodBeat.i(202125);
                try {
                    Log.i("SnsAd.DynamicUpdate", "the requestFinderLivingState return errorCode is  ".concat(String.valueOf(i2)));
                    if (i2 == 0 && (obj instanceof Integer)) {
                        com.tencent.mm.plugin.sns.ad.widget.living.b.fv(str, ((Integer) obj).intValue());
                    }
                    AppMethodBeat.o(202125);
                } catch (Throwable th) {
                    AppMethodBeat.o(202125);
                }
            }
        });
        AppMethodBeat.o(202134);
    }

    private bz[] a(String str, bz[] bzVarArr, boolean z) {
        AppMethodBeat.i(202135);
        if (bzVarArr == null) {
            AppMethodBeat.o(202135);
            return null;
        }
        LinkedList linkedList = new LinkedList();
        for (bz bzVar : bzVarArr) {
            if (bzVar != null && r(str, bzVar.pTI, z)) {
                linkedList.add(bzVar);
            }
        }
        bz[] bzVarArr2 = (bz[]) linkedList.toArray(new bz[0]);
        AppMethodBeat.o(202135);
        return bzVarArr2;
    }

    private boolean r(String str, int i2, boolean z) {
        AppMethodBeat.i(202136);
        boolean a2 = a(str, i2, null, z);
        AppMethodBeat.o(202136);
        return a2;
    }

    private boolean a(String str, int i2, com.tencent.mm.plugin.sns.ad.a.b bVar, boolean z) {
        SparseArray<c> sparseArray;
        AppMethodBeat.i(202137);
        SparseArray<c> sparseArray2 = this.DxP.get(str);
        if (sparseArray2 == null) {
            SparseArray<c> sparseArray3 = new SparseArray<>();
            this.DxP.put(str, sparseArray3);
            sparseArray = sparseArray3;
        } else {
            sparseArray = sparseArray2;
        }
        c cVar = null;
        boolean z2 = true;
        if (z && (cVar = sparseArray.get(i2)) != null) {
            if (cl.aWA() - cVar.pnE < cVar.DxS) {
                z2 = false;
            }
        }
        if (z2) {
            sparseArray.put(i2, a(i2, bVar, cVar));
        }
        AppMethodBeat.o(202137);
        return z2;
    }

    private static c a(int i2, com.tencent.mm.plugin.sns.ad.a.b bVar, c cVar) {
        c cVar2;
        AppMethodBeat.i(202138);
        b.a aVar = null;
        if (!(bVar == null || bVar.DrN == null)) {
            aVar = bVar.DrN.get(i2);
        }
        long aWA = cl.aWA();
        if (cVar == null) {
            long j2 = DxQ.get(i2, 5000);
            if (aVar != null && ((long) aVar.DrO) > 5000) {
                j2 = (long) aVar.DrO;
            }
            cVar2 = new c(aWA, j2, i2);
        } else {
            cVar.pnE = aWA;
            cVar2 = cVar;
        }
        AppMethodBeat.o(202138);
        return cVar2;
    }

    static {
        AppMethodBeat.i(202139);
        SparseLongArray sparseLongArray = new SparseLongArray();
        DxQ = sparseLongArray;
        sparseLongArray.append(1, 1800000);
        DxQ.append(2, 300000);
        DxQ.append(1000001, 5000);
        DxQ.append(1000003, Util.MILLSECONDS_OF_MINUTE);
        DxQ.append(3, Util.MILLSECONDS_OF_HOUR);
        AppMethodBeat.o(202139);
    }
}
