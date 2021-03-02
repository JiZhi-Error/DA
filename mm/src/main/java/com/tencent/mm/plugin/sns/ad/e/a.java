package com.tencent.mm.plugin.sns.ad.e;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.ad.e.l;
import com.tencent.mm.plugin.sns.data.k;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.m;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.AdSnsInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;

public final class a {
    private static long DsD;

    public static void G(int i2, int i3, String str) {
        AppMethodBeat.i(201887);
        ArrayList<Long> arrayList = new ArrayList();
        if (i2 != i3) {
            long currentTimeMillis = System.currentTimeMillis();
            if (i3 == 0) {
                Log.e("AdExpireDeleteHelper", "query startTime==0");
                h.INSTANCE.dN(1612, 1);
            }
            eWJ();
            int i4 = 0;
            Cursor iG = aj.faR().iG(i2, i3);
            if (iG != null && iG.moveToFirst()) {
                l.a aVar = new l.a();
                while (true) {
                    if (i4 >= 20) {
                        Log.i("AdExpireDeleteHelper", "reach max count:".concat(String.valueOf(i4)));
                        break;
                    }
                    int i5 = i4 + 1;
                    AdSnsInfo adSnsInfo = new AdSnsInfo();
                    adSnsInfo.convertFrom(iG);
                    SnsInfo convertToSnsInfo = adSnsInfo.convertToSnsInfo();
                    String Jb = r.Jb(convertToSnsInfo.field_snsId);
                    long j2 = 21600;
                    ADInfo adInfo = convertToSnsInfo.getAdInfo();
                    int i6 = convertToSnsInfo.field_createTime;
                    boolean isExposured = adSnsInfo.isExposured();
                    if (adInfo != null) {
                        if (isExposured) {
                            j2 = adInfo.exposureNoActionExpireTime * 60;
                            i6 = adSnsInfo.field_exposureTime;
                        } else {
                            j2 = adInfo.noExposureExpireTime * 60;
                            i6 = adSnsInfo.field_createAdTime;
                        }
                    }
                    long secondsToNow = Util.secondsToNow((long) i6);
                    StringBuilder sb = new StringBuilder();
                    sb.append("expire check, snsId=").append(Jb).append(", isExposured=").append(isExposured).append(", exposureCnt=").append(adSnsInfo.field_exposureCount).append(", exposureTime=").append(j2).append(", field_createTime=").append(convertToSnsInfo.field_createTime).append(", checktime=").append(secondsToNow).append(", gettime=").append(i6).append(", exposureTime=").append(adSnsInfo.field_exposureTime).append(", adCreateTIme=").append(adSnsInfo.field_createAdTime);
                    Log.i("AdExpireDeleteHelper", sb.toString());
                    if (secondsToNow >= j2 && !k.a(an.C(convertToSnsInfo), str)) {
                        arrayList.add(Long.valueOf(convertToSnsInfo.field_snsId));
                        if (!isExposured) {
                            aVar.m(adSnsInfo.getAdInfo().uxInfo, Jb, 2, 0);
                        }
                    } else if (convertToSnsInfo != null) {
                        long j3 = convertToSnsInfo.field_snsId;
                        if (m.Jg(j3)) {
                            m mVar = new m(j3, 1, convertToSnsInfo.getAdInfo().adInfoSyncBuffer);
                            g.aAi();
                            g.aAg().hqi.a(mVar, 0);
                        }
                    }
                    if (!iG.moveToNext()) {
                        i4 = i5;
                        break;
                    }
                    i4 = i5;
                }
                aVar.report();
            }
            if (iG != null) {
                iG.close();
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            Log.i("AdExpireDeleteHelper", "checkExpireAd, topAdTime=" + i2 + ", belowAdTime=" + i3 + ", adCount=" + i4 + ", delCount=" + arrayList.size() + ", timeCost=" + (currentTimeMillis2 - currentTimeMillis));
        }
        if (!arrayList.isEmpty()) {
            for (Long l : arrayList) {
                long longValue = l.longValue();
                Log.i("AdExpireDeleteHelper", "deleteAdWithNoCheck, id=" + r.Jb(longValue));
                com.tencent.mm.plugin.sns.model.a.U(longValue, 1);
            }
            arrayList.clear();
        }
        AppMethodBeat.o(201887);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0152 A[SYNTHETIC, Splitter:B:24:0x0152] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x015e A[Catch:{ Throwable -> 0x0177 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void eWJ() {
        /*
        // Method dump skipped, instructions count: 498
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.ad.e.a.eWJ():void");
    }
}
