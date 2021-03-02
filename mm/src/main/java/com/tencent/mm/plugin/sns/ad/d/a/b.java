package com.tencent.mm.plugin.sns.ad.d.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.d.a.c;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Arrays;
import java.util.LinkedList;

public final class b implements Runnable {
    private final c Dsw;
    private final String Dsy;

    b(c cVar, String str) {
        this.Dsw = cVar;
        this.Dsy = str;
    }

    public final void run() {
        c.b bVar;
        String aNC;
        AppMethodBeat.i(201879);
        Log.d("SnsAd.H5PrefetchTask", "AdH5PrefetchTask is running, the task key is " + this.Dsy);
        if (TextUtils.isEmpty(this.Dsy)) {
            Log.w("SnsAd.H5PrefetchTask", "AdH5PrefetchTask: the task key is empty");
            AppMethodBeat.o(201879);
            return;
        }
        c cVar = this.Dsw;
        String str = this.Dsy;
        if (!TextUtils.isEmpty(str)) {
            bVar = cVar.Dsz.remove(str);
        } else {
            bVar = null;
        }
        if (bVar != null) {
            c cVar2 = this.Dsw;
            if (bVar != null && !TextUtils.isEmpty(bVar.gWK)) {
                c.a aVar = new c.a();
                aVar.gWK = bVar.gWK;
                aVar.DsB = System.currentTimeMillis();
                cVar2.DsA.put(aVar.gWK, aVar);
                Log.i("SnsAd.H5Prefetch", "the prefetch info is recorded");
            }
            if (bVar != null) {
                int i2 = bVar.type;
                if (i2 == 0) {
                    int i3 = bVar.source;
                    SnsInfo snsInfo = bVar.DsC;
                    if (snsInfo == null) {
                        Log.w("SnsAd.H5PrefetchTask", "doPrefetch: the snsInfo is null");
                        AppMethodBeat.o(201879);
                        return;
                    }
                    LinkedList linkedList = new LinkedList();
                    String adInfoLink = snsInfo.getAdInfoLink();
                    if (TextUtils.isEmpty(adInfoLink)) {
                        adInfoLink = snsInfo.getAdLink();
                    }
                    ADInfo adInfo = snsInfo.getAdInfo(i3);
                    if (adInfo != null) {
                        adInfoLink = r.kb(adInfoLink, adInfo.uxInfo);
                    }
                    String aNC2 = a.aNC(adInfoLink);
                    Log.d("SnsAd.H5PrefetchTask", "doTextAdLink: the url is ".concat(String.valueOf(aNC2)));
                    if (!TextUtils.isEmpty(aNC2)) {
                        linkedList.add(aNC2);
                    }
                    ADXml adXml = snsInfo.getAdXml();
                    if (adXml == null) {
                        aNC = "";
                    } else {
                        ADXml.AdCardActionBtnInfo adCardActionBtnInfo = adXml.adCardActionBtnInfo;
                        if (adCardActionBtnInfo == null) {
                            aNC = "";
                        } else if (adCardActionBtnInfo.clickActionType != 0) {
                            aNC = "";
                        } else {
                            String str2 = adCardActionBtnInfo.clickActionLink;
                            if (TextUtils.isEmpty(str2)) {
                                aNC = "";
                            } else {
                                ADInfo adInfo2 = snsInfo.getAdInfo(i3);
                                if (adInfo2 != null) {
                                    str2 = r.kb(str2, adInfo2.uxInfo);
                                }
                                aNC = a.aNC(str2);
                                Log.d("SnsAd.H5PrefetchTask", "doActionBtnUrl: the url is ".concat(String.valueOf(aNC)));
                            }
                        }
                    }
                    if (!TextUtils.isEmpty(aNC)) {
                        linkedList.add(aNC);
                    }
                    ADXml adXml2 = snsInfo.getAdXml();
                    String str3 = "";
                    if (!(adXml2 == null || adXml2.adFloatWebViewInfo == null)) {
                        String str4 = adXml2.adFloatWebViewInfo.lDS;
                        if (TextUtils.isEmpty(str4)) {
                            str3 = "";
                        } else {
                            ADInfo adInfo3 = snsInfo.getAdInfo();
                            if (adInfo3 != null) {
                                str4 = r.kb(str4, adInfo3.uxInfo);
                            }
                            str3 = a.aNC(str4);
                            Log.d("SnsAd.H5PrefetchTask", "doWebViewOnePlusOne: the url is ".concat(String.valueOf(str3)));
                        }
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        linkedList.add(str3);
                    }
                    a.gL(linkedList);
                    AppMethodBeat.o(201879);
                    return;
                } else if (i2 == 1) {
                    if (bVar == null || com.tencent.mm.plugin.sns.ad.i.c.w(bVar.cze)) {
                        Log.w("SnsAd.H5PrefetchTask", "doPrefetchNativeLanding: the task is null or urls is empty");
                        AppMethodBeat.o(201879);
                        return;
                    }
                    a.gL(Arrays.asList(bVar.cze));
                }
            }
        }
        AppMethodBeat.o(201879);
    }
}
