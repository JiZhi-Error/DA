package com.tencent.mm.plugin.sns.ad.timeline.c.a;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.a.d;
import com.tencent.mm.plugin.sns.ad.a.e;
import com.tencent.mm.plugin.sns.ad.i.c;
import com.tencent.mm.plugin.sns.ad.i.m;
import com.tencent.mm.plugin.sns.ad.timeline.dynamic.a;
import com.tencent.mm.plugin.sns.ad.timeline.dynamic.b.a;
import com.tencent.mm.plugin.sns.ad.timeline.dynamic.listener.RequestListenerManager;
import com.tencent.mm.plugin.sns.ad.timeline.dynamic.listener.a;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.List;

public final class b implements a {
    SnsInfo DqO;
    TextView Dzu;
    a.AbstractC1710a Dzv;
    WeakReference<Activity> mActivityRef;
    RecyclerView mRecyclerView;

    public b(Activity activity, TextView textView, RecyclerView recyclerView) {
        AppMethodBeat.i(202269);
        if (activity != null) {
            this.mActivityRef = new WeakReference<>(activity);
            this.Dzv = new com.tencent.mm.plugin.sns.ad.timeline.dynamic.a.a(activity);
        }
        this.Dzu = textView;
        this.mRecyclerView = recyclerView;
        AppMethodBeat.o(202269);
    }

    public final void c(SnsInfo snsInfo, boolean z) {
        AppMethodBeat.i(202270);
        try {
            d(snsInfo, z);
            AppMethodBeat.o(202270);
        } catch (Throwable th) {
            Log.e("SnsAd.TopicCardDynamic", "doDynamicRequest failed!!!");
            AppMethodBeat.o(202270);
        }
    }

    private void d(SnsInfo snsInfo, boolean z) {
        AppMethodBeat.i(202271);
        if (snsInfo == null) {
            Log.w("SnsAd.TopicCardDynamic", "Are you OK??? The input sns info or listener is null!!");
            AppMethodBeat.o(202271);
        } else if (this.Dzv == null) {
            Log.w("SnsAd.TopicCardDynamic", "Are you OK??? I think the activity is null, which is input in constructor!!!!");
            AppMethodBeat.o(202271);
        } else {
            String v = r.v(snsInfo);
            if (TextUtils.isEmpty(v) || AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(v)) {
                Log.w("SnsAd.TopicCardDynamic", "the sns id is empty!! Are you sure?");
                AppMethodBeat.o(202271);
                return;
            }
            Activity activity = getActivity();
            if (activity == null) {
                Log.w("SnsAd.TopicCardDynamic", "the context is null! Is activity destroyed?");
                AppMethodBeat.o(202271);
                return;
            }
            RequestListenerManager aF = RequestListenerManager.aF(activity);
            if (aF == null) {
                Log.w("SnsAd.TopicCardDynamic", "OK, i fu le you!!! the activity is not life cycle owner!");
                AppMethodBeat.o(202271);
                return;
            }
            aF.a(v, this);
            com.tencent.mm.plugin.sns.ad.timeline.dynamic.a eXI = com.tencent.mm.plugin.sns.ad.timeline.dynamic.a.eXI();
            if (eXI == null) {
                Log.w("SnsAd.TopicCardDynamic", "OK, i fule you!!! the request manager is null. Isn't the RequestManager singleton?");
                AppMethodBeat.o(202271);
                return;
            }
            this.DqO = snsInfo;
            eXI.a(snsInfo, z, this.Dzv);
            AppMethodBeat.o(202271);
        }
    }

    private Activity getActivity() {
        AppMethodBeat.i(202273);
        if (this.mActivityRef == null) {
            AppMethodBeat.o(202273);
            return null;
        }
        Activity activity = this.mActivityRef.get();
        AppMethodBeat.o(202273);
        return activity;
    }

    @Override // com.tencent.mm.plugin.sns.ad.timeline.dynamic.listener.a
    public final void A(String str, Object obj) {
        d dVar;
        RecyclerView.a adapter;
        int i2 = 0;
        AppMethodBeat.i(202272);
        try {
            String v = r.v(this.DqO);
            if (TextUtils.isEmpty(v) || !v.equals(str)) {
                Log.w("SnsAd.TopicCardDynamic", "en ?? the sns is not same as the one when request used!");
                AppMethodBeat.o(202272);
            } else if (!(obj instanceof com.tencent.mm.plugin.sns.ad.timeline.dynamic.b.a)) {
                Log.w("SnsAd.TopicCardDynamic", "Crazy!!! the result data is not TopicCardResponseModel!");
                AppMethodBeat.o(202272);
            } else {
                SnsInfo snsInfo = this.DqO;
                if (snsInfo == null || snsInfo.getAdXml() == null) {
                    AppMethodBeat.o(202272);
                    return;
                }
                d dVar2 = snsInfo.getAdXml().adFinderTopicInfo;
                if (dVar2 == null) {
                    Log.w("SnsAd.TopicCardDynamic", "Yep !!! topicInfo is null, please check!!!");
                    AppMethodBeat.o(202272);
                    return;
                }
                com.tencent.mm.plugin.sns.ad.timeline.dynamic.b.a aVar = (com.tencent.mm.plugin.sns.ad.timeline.dynamic.b.a) obj;
                if (dVar2 == null) {
                    dVar = dVar2;
                } else {
                    List<e> list = dVar2.DrS;
                    if (c.isEmpty(list) || c.isEmpty(aVar.DxV) || list.size() != aVar.DxV.size()) {
                        Log.w("SnsAd.TopicCardResponseModel", "the targetResInfoList size is not same as res infos size");
                    } else {
                        while (i2 < aVar.DxV.size() && i2 < list.size()) {
                            e eVar = list.get(i2);
                            a.b bVar = aVar.DxV.get(i2);
                            if (!(eVar == null || bVar == null)) {
                                if (bVar.uNR != null) {
                                    eVar.uNR = bVar.uNR;
                                }
                                if (bVar.nickname != null) {
                                    eVar.nickname = bVar.nickname;
                                }
                                if (bVar.tag != null) {
                                    eVar.tag = bVar.tag;
                                }
                                if (bVar.desc != null) {
                                    eVar.desc = bVar.desc;
                                }
                                if (bVar.DrT != null) {
                                    eVar.DrT = bVar.DrT;
                                }
                                if (bVar.DrV != null) {
                                    eVar.DrV = bVar.DrV;
                                }
                                if (bVar.DxW != null) {
                                    a.C1711a aVar2 = bVar.DxW;
                                    cnb cnb = eVar.ebR;
                                    if (aVar2 != null && cnb != null && !TextUtils.isEmpty(aVar2.wQO) && !TextUtils.isEmpty(aVar2.url) && !TextUtils.isEmpty(aVar2.dWJ)) {
                                        cnb.Id = aVar2.wQO;
                                        cnb.Url = aVar2.url;
                                        cnb.Msz = aVar2.dWJ;
                                    }
                                }
                            }
                            i2++;
                        }
                        i2 = 1;
                    }
                    if (i2 != 0) {
                        if (!TextUtils.isEmpty(aVar.DrQ)) {
                            dVar2.DrQ = aVar.DrQ;
                        }
                        dVar = dVar2;
                    } else {
                        dVar = null;
                    }
                }
                if (dVar == null) {
                    Log.w("SnsAd.TopicCardDynamic", "Yep !!! after converting, the topic info is null!!! Don't update!");
                    AppMethodBeat.o(202272);
                    return;
                }
                if (dVar.DrQ != null) {
                    m.f(this.Dzu, (CharSequence) dVar.DrQ);
                }
                if (!(this.mRecyclerView == null || (adapter = this.mRecyclerView.getAdapter()) == null)) {
                    adapter.atj.notifyChanged();
                }
                AppMethodBeat.o(202272);
            }
        } catch (Throwable th) {
            Log.e("SnsAd.TopicCardDynamic", "the on result failed!");
            AppMethodBeat.o(202272);
        }
    }
}
