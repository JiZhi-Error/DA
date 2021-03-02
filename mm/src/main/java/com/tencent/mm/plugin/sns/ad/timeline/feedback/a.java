package com.tencent.mm.plugin.sns.ad.timeline.feedback;

import android.content.Intent;
import android.text.TextUtils;
import android.util.ArrayMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.ad.timeline.feedback.b;
import com.tencent.mm.plugin.sns.data.c;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.s;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class a implements b.AbstractC1712b {
    SnsInfo DqO;
    c DxX;
    String DxY = LocaleUtil.CHINA;

    public final boolean eXJ() {
        AppMethodBeat.i(202157);
        try {
            ADXml adXml = getAdXml();
            if (adXml != null) {
                if (adXml.newFeedbackPanel > 0) {
                    AppMethodBeat.o(202157);
                    return true;
                }
                AppMethodBeat.o(202157);
                return false;
            }
        } catch (Throwable th) {
        }
        AppMethodBeat.o(202157);
        return false;
    }

    public final boolean eXK() {
        AppMethodBeat.i(202158);
        try {
            ADInfo adInfo = getAdInfo();
            if (!(adInfo == null || adInfo.adUnlikeInfo == null)) {
                boolean o = com.tencent.mm.plugin.sns.ad.i.c.o(adInfo.adUnlikeInfo.fcH());
                AppMethodBeat.o(202158);
                return o;
            }
        } catch (Throwable th) {
        }
        AppMethodBeat.o(202158);
        return false;
    }

    public final s XL(int i2) {
        AppMethodBeat.i(202160);
        SnsInfo snsInfo = this.DqO;
        c cVar = this.DxX;
        if (snsInfo == null || cVar == null) {
            AppMethodBeat.o(202160);
            return null;
        }
        ADInfo.c.a aVar = new ADInfo.c.a();
        if (i2 == 0) {
            aVar.DWd = ADInfo.c.a.DVZ;
        }
        aVar.DDs = cVar.DDs;
        if (i2 == 0) {
            aVar.DWe = 0;
        } else {
            aVar.DWe = System.currentTimeMillis();
        }
        s sVar = new s(snsInfo.field_snsId, 8, aVar);
        AppMethodBeat.o(202160);
        return sVar;
    }

    @Override // com.tencent.mm.plugin.sns.ad.timeline.feedback.b.AbstractC1712b
    public final Map<String, Object> aNQ(String str) {
        boolean z;
        int i2;
        AppMethodBeat.i(202161);
        ArrayMap arrayMap = new ArrayMap();
        try {
            if ("ad_delay_interval_day".equals(str)) {
                c cVar = this.DxX;
                if (cVar == null || cVar.DDr == null || cVar.DDr.EQZ == null) {
                    Log.e("FeedbackDisplayDataSupplier", "the data tag is null!");
                    i2 = 7;
                } else {
                    ADInfo aDInfo = cVar.DDr.EQZ;
                    if (aDInfo.adUnlikeInfo != null) {
                        i2 = aDInfo.adUnlikeInfo.DVT;
                    } else {
                        Log.e("FeedbackDisplayDataSupplier", "the adUnlikeInfo is null in data tag!");
                        i2 = 7;
                    }
                }
                arrayMap.put(str, Integer.valueOf(i2));
            } else if ("reason_list".equals(str)) {
                arrayMap.put(str, eXM());
            } else if ("expand_title".equals(str)) {
                arrayMap.put(str, eXN());
            } else if ("special_prompt".equals(str)) {
                ADInfo adInfo = getAdInfo();
                String str2 = "";
                if (!(adInfo == null || adInfo.adUnlikeInfo == null)) {
                    str2 = LocaleUtil.CHINA.equals(this.DxY) ? adInfo.adUnlikeInfo.DVW : (LocaleUtil.HONGKONG.equals(this.DxY) || LocaleUtil.TAIWAN.equals(this.DxY)) ? adInfo.adUnlikeInfo.DVX : adInfo.adUnlikeInfo.DVY;
                }
                if (TextUtils.isEmpty(str2)) {
                    str2 = eXN();
                }
                arrayMap.put(str, str2);
            } else if ("is_special".equals(str)) {
                ADInfo adInfo2 = getAdInfo();
                if (adInfo2 != null) {
                    z = adInfo2.forbidClick;
                } else {
                    z = false;
                }
                arrayMap.put(str, Boolean.valueOf(z));
            } else if ("unlike_tag".equals(str) && this.DxX != null) {
                arrayMap.put(str, this.DxX);
            }
        } catch (Throwable th) {
            Log.w("FeedbackDisplayDataSupplier", "there is something wrong in getData. the key is ".concat(String.valueOf(str)));
        }
        AppMethodBeat.o(202161);
        return arrayMap;
    }

    private List<b.d> eXM() {
        String str;
        AppMethodBeat.i(202162);
        ArrayList arrayList = new ArrayList();
        ADInfo adInfo = getAdInfo();
        if (!(adInfo == null || adInfo.adUnlikeInfo == null)) {
            List<ADInfo.c.a> fcH = adInfo.adUnlikeInfo.fcH();
            if (com.tencent.mm.plugin.sns.ad.i.c.o(fcH)) {
                for (ADInfo.c.a aVar : fcH) {
                    int i2 = aVar.DWd;
                    if (LocaleUtil.CHINA.equals(this.DxY)) {
                        str = aVar.DWa;
                    } else if (LocaleUtil.HONGKONG.equals(this.DxY) || LocaleUtil.TAIWAN.equals(this.DxY)) {
                        str = aVar.DWb;
                    } else {
                        str = aVar.DWc;
                    }
                    arrayList.add(new b.d(i2, str));
                }
            }
        }
        AppMethodBeat.o(202162);
        return arrayList;
    }

    private String eXN() {
        AppMethodBeat.i(202163);
        ADXml adXml = getAdXml();
        if (adXml == null) {
            Log.w("FeedbackDisplayDataSupplier", "the ad xml is null in data");
            AppMethodBeat.o(202163);
            return "";
        } else if (LocaleUtil.CHINA.equals(this.DxY)) {
            String str = adXml.expandInsideTitle_cn;
            AppMethodBeat.o(202163);
            return str;
        } else if (LocaleUtil.TAIWAN.equals(this.DxY) || LocaleUtil.HONGKONG.equals(this.DxY)) {
            String str2 = adXml.expandInsideTitle_tw;
            AppMethodBeat.o(202163);
            return str2;
        } else {
            String str3 = adXml.expandInsideTitle_en;
            AppMethodBeat.o(202163);
            return str3;
        }
    }

    /* access modifiers changed from: package-private */
    public final ADInfo getAdInfo() {
        ADInfo aDInfo = null;
        AppMethodBeat.i(202164);
        c cVar = this.DxX;
        SnsInfo snsInfo = this.DqO;
        if (cVar == null) {
            AppMethodBeat.o(202164);
        } else {
            if (snsInfo != null) {
                aDInfo = snsInfo.getAdInfo();
            }
            if (aDInfo == null && cVar.DDr != null) {
                aDInfo = cVar.DDr.EQZ;
            }
            AppMethodBeat.o(202164);
        }
        return aDInfo;
    }

    /* access modifiers changed from: package-private */
    public final ADXml getAdXml() {
        AppMethodBeat.i(202165);
        c cVar = this.DxX;
        SnsInfo snsInfo = this.DqO;
        ADXml aDXml = null;
        if (!(cVar == null || cVar.DDr == null)) {
            aDXml = cVar.DDr.EQY;
        }
        if (aDXml == null && snsInfo != null) {
            aDXml = snsInfo.getAdXml();
        }
        AppMethodBeat.o(202165);
        return aDXml;
    }

    public final Intent eXL() {
        String str;
        String str2;
        AppMethodBeat.i(202159);
        try {
            ADXml adXml = getAdXml();
            if (adXml == null || adXml.adFeedbackInfo == null) {
                Log.e("FeedbackDisplayDataSupplier", "there is no feedback info!!!");
                str = "";
            } else {
                ADXml.e eVar = adXml.adFeedbackInfo;
                if (com.tencent.mm.plugin.sns.ad.i.c.isEmpty(eVar.list)) {
                    Log.e("FeedbackDisplayDataSupplier", "there is no feedback item!");
                    str = "";
                } else {
                    Iterator<ADXml.f> it = eVar.list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            str = "";
                            break;
                        }
                        ADXml.f next = it.next();
                        if (next != null && !TextUtils.isEmpty(next.url)) {
                            str = next.url;
                            break;
                        }
                    }
                    if (TextUtils.isEmpty(str)) {
                        Log.e("FeedbackDisplayDataSupplier", "there is feedback item, but no url!!!");
                    }
                }
            }
            SnsInfo snsInfo = this.DqO;
            if (!TextUtils.isEmpty(str) && snsInfo != null) {
                try {
                    Object[] objArr = {snsInfo.getTimeLine().Id};
                    Object[] objArr2 = {snsInfo.getAid()};
                    Object[] objArr3 = {snsInfo.getTraceid()};
                    g.aAf();
                    str2 = i.n(str, String.format("snsid=%s", objArr), String.format("aid=%s", objArr2), String.format("traceid=%s", objArr3), String.format("uin=%s", com.tencent.mm.kernel.a.ayV()));
                } catch (Exception e2) {
                    str2 = str;
                }
                Intent intent = new Intent();
                intent.putExtra("rawUrl", str2);
                intent.putExtra("useJs", true);
                intent.putExtra("KPublisherId", "sns_" + r.Jb(snsInfo.field_snsId));
                intent.putExtra("pre_username", snsInfo.field_userName);
                intent.putExtra("prePublishId", "sns_" + r.Jb(snsInfo.field_snsId));
                intent.putExtra("preUsername", snsInfo.field_userName);
                AppMethodBeat.o(202159);
                return intent;
            }
        } catch (Throwable th) {
        }
        AppMethodBeat.o(202159);
        return null;
    }
}
