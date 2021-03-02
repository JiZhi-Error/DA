package com.tencent.mm.plugin.sns.ui.c.a;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.sns.ad.g.d;
import com.tencent.mm.plugin.sns.ad.g.k;
import com.tencent.mm.plugin.sns.ad.i.i;
import com.tencent.mm.plugin.sns.ad.i.m;
import com.tencent.mm.plugin.sns.ad.timeline.c.a.a;
import com.tencent.mm.plugin.sns.ad.timeline.c.a.c;
import com.tencent.mm.plugin.sns.ad.timeline.c.a.f;
import com.tencent.mm.plugin.sns.ad.widget.recyclerview.CardLayoutManager;
import com.tencent.mm.plugin.sns.ad.widget.recyclerview.b;
import com.tencent.mm.plugin.sns.ad.widget.stackup.StackUpLayout;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import com.tencent.smtt.sdk.TbsListener;

public final class e extends a implements d, b {
    RoundedCornerFrameLayout Dzc;
    RecyclerView Dzd;
    ViewGroup Dze;
    ImageView Dzf;
    TextView Dzg;
    TextView Dzi;
    k EBv;
    StackUpLayout EVX;
    CardLayoutManager EVY;
    com.tencent.mm.plugin.sns.ad.timeline.video.online.e EVZ = new com.tencent.mm.plugin.sns.ad.timeline.video.online.e();
    f EWa;
    c EWb = new c();
    com.tencent.mm.plugin.sns.ad.timeline.c.a.b EWc;
    a EWd;
    Context context;

    public e(TimeLineObject timeLineObject, SnsInfo snsInfo, com.tencent.mm.plugin.sns.ui.d.c cVar, k kVar) {
        AppMethodBeat.i(203896);
        this.timeLineObject = timeLineObject;
        this.DsC = snsInfo;
        this.Dyw = cVar;
        this.EBv = kVar;
        this.EWd = new a(2);
        AppMethodBeat.o(203896);
    }

    @Override // com.tencent.mm.plugin.sns.ui.c.a.a
    public final void refreshView() {
        AppMethodBeat.i(203898);
        try {
            Log.d("SnsAd.TopicCardDetail", "the refresh view is called");
            if (this.EWa != null) {
                this.EWa.b(this.EVY);
            }
            AppMethodBeat.o(203898);
        } catch (Throwable th) {
            AppMethodBeat.o(203898);
        }
    }

    @Override // com.tencent.mm.plugin.sns.ui.c.a.a
    public final void onPause() {
        AppMethodBeat.i(203899);
        Log.d("SnsAd.TopicCardDetail", "the onPause is called");
        try {
            super.onPause();
            if (this.EWa != null) {
                this.EWa.eYb();
            }
            if (this.EVY != null) {
                this.EVY.eYC();
            }
            AppMethodBeat.o(203899);
        } catch (Throwable th) {
            AppMethodBeat.o(203899);
        }
    }

    @Override // com.tencent.mm.plugin.sns.ad.widget.recyclerview.b
    public final void au(View view, int i2) {
        AppMethodBeat.i(203900);
        try {
            Log.d("SnsAd.TopicCardDetail", "the item is click");
            b(view, this.DsC);
            if (this.EWd != null) {
                this.EWd.XN(i2);
            }
            AppMethodBeat.o(203900);
        } catch (Throwable th) {
            AppMethodBeat.o(203900);
        }
    }

    @Override // com.tencent.mm.plugin.sns.ad.g.d
    public final void aNK(String str) {
        AppMethodBeat.i(203901);
        try {
            if (this.DsC != null) {
                String v = r.v(this.DsC);
                if (!TextUtils.isEmpty(v) && v.equals(str)) {
                    i.a(this.EWd);
                }
            }
            AppMethodBeat.o(203901);
        } catch (Throwable th) {
            AppMethodBeat.o(203901);
        }
    }

    /* access modifiers changed from: protected */
    public final void b(View view, SnsInfo snsInfo) {
        AppMethodBeat.i(203902);
        com.tencent.mm.plugin.sns.ad.timeline.a.c d2 = com.tencent.mm.plugin.sns.ad.timeline.a.a.d(5, this.context);
        if (d2 != null) {
            com.tencent.mm.plugin.sns.ad.timeline.a.d dVar = new com.tencent.mm.plugin.sns.ad.timeline.a.d();
            if (this.EBv != null) {
                dVar.z("sns_ad_statistic", this.EBv);
            }
            d2.a(view, getSource(), snsInfo, dVar);
        }
        if (this.EWc != null) {
            this.EWc.c(snsInfo, false);
        }
        AppMethodBeat.o(203902);
    }

    private int getSource() {
        if (this.EBv != null) {
            return this.EBv.source;
        }
        return 1;
    }

    @Override // com.tencent.mm.plugin.sns.ui.c.a.a
    public final void n(View view, View view2) {
        ViewGroup.LayoutParams layoutParams;
        AppMethodBeat.i(203897);
        if (view != null) {
            try {
                if (!(this.DsC == null || this.DsC.getAdXml() == null)) {
                    com.tencent.mm.plugin.sns.ad.a.d dVar = this.DsC.getAdXml().adFinderTopicInfo;
                    if (dVar == null) {
                        Log.w("SnsAd.TopicCardDetail", "the adFinderTopicInfo is null");
                        AppMethodBeat.o(203897);
                        return;
                    }
                    if (this.EWd != null) {
                        this.EWd.a(this.DsC, getSource(), dVar);
                    }
                    this.context = view.getContext();
                    this.Dzc = (RoundedCornerFrameLayout) view.findViewById(R.id.hv5);
                    this.Dzd = (RecyclerView) view.findViewById(R.id.hv4);
                    this.Dzf = (ImageView) view.findViewById(R.id.hv1);
                    this.Dzg = (TextView) view.findViewById(R.id.hv3);
                    this.EVX = (StackUpLayout) view.findViewById(R.id.hv0);
                    this.Dzi = (TextView) view.findViewById(R.id.huz);
                    this.Dze = (ViewGroup) view.findViewById(R.id.hv2);
                    if (this.Dzf != null) {
                        this.Dzf.setImageResource(R.raw.sns_ad_finder_topic_item_rear_flag);
                    }
                    if (this.Dze != null) {
                        this.Dze.setOnClickListener(new View.OnClickListener() {
                            /* class com.tencent.mm.plugin.sns.ui.c.a.e.AnonymousClass1 */

                            public final void onClick(View view) {
                                AppMethodBeat.i(203895);
                                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                bVar.bm(view);
                                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/detail/item/TopicCardDetailItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                if (e.this.EWd != null) {
                                    e.this.EWd.eXZ();
                                }
                                e.this.b(view, e.this.DsC);
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/detail/item/TopicCardDetailItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(203895);
                            }
                        });
                    }
                    m.f(this.Dzg, (CharSequence) dVar.DrP);
                    m.f(this.Dzi, (CharSequence) dVar.DrQ);
                    if (this.EVX != null) {
                        this.EVX.setStackUpWidthSize(com.tencent.mm.cb.a.fromDPToPix(this.context, 6));
                        int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix(this.context, 20);
                        this.EVX.ir(fromDPToPix, fromDPToPix);
                        this.EWb.a(this.EVX, this.DsC);
                    }
                    if (this.Dzc != null) {
                        int fromDPToPix2 = com.tencent.mm.cb.a.fromDPToPix(this.context, 8);
                        this.Dzc.s((float) fromDPToPix2, (float) fromDPToPix2, 0.0f, 0.0f);
                    }
                    if (this.Dzd != null) {
                        if (!(this.Dzd == null || (layoutParams = this.Dzd.getLayoutParams()) == null)) {
                            layoutParams.height = com.tencent.mm.cb.a.fromDPToPix(this.context, (int) TbsListener.ErrorCode.UNLZMA_FAIURE);
                        }
                        this.EVY = new CardLayoutManager(this.Dzd);
                        this.EWa = new f(this.EVZ, this.EWd);
                        this.EWa.DqO = this.DsC;
                        this.EVY.a(new com.tencent.mm.plugin.sns.ad.widget.recyclerview.a(com.tencent.mm.cb.a.fromDPToPix(this.context, 12), com.tencent.mm.cb.a.fromDPToPix(this.context, 8)));
                        this.EVY.DBs = this.EWa;
                        this.Dzd.setLayoutManager(this.EVY);
                        com.tencent.mm.plugin.sns.ad.timeline.c.a.d dVar2 = new com.tencent.mm.plugin.sns.ad.timeline.c.a.d(this.Dzd, this.DsC);
                        dVar2.au(true);
                        dVar2.DzB = this;
                        this.Dzd.setAdapter(dVar2);
                    }
                    if (this.context instanceof Activity) {
                        this.EWc = new com.tencent.mm.plugin.sns.ad.timeline.c.a.b((Activity) this.context, this.Dzi, this.Dzd);
                        this.EWc.c(this.DsC, true);
                    }
                    k kVar = this.EBv;
                    if (kVar != null) {
                        String v = r.v(this.DsC);
                        if (!TextUtils.isEmpty(v) && !AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(v)) {
                            kVar.a(v, this);
                        }
                    }
                    AppMethodBeat.o(203897);
                    return;
                }
            } catch (Throwable th) {
                Log.e("SnsAd.TopicCardDetail", "the init view failed");
                AppMethodBeat.o(203897);
                return;
            }
        }
        Log.w("SnsAd.TopicCardDetail", "the content view is null??? the init view can't complete!!!!");
        AppMethodBeat.o(203897);
    }
}
