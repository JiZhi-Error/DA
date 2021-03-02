package com.tencent.mm.plugin.sns.ad.timeline.c;

import android.content.Context;
import android.graphics.Rect;
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
import com.tencent.mm.plugin.sns.ad.timeline.c.a.c;
import com.tencent.mm.plugin.sns.ad.timeline.c.a.f;
import com.tencent.mm.plugin.sns.ad.timeline.video.online.e;
import com.tencent.mm.plugin.sns.ad.widget.recyclerview.CardLayoutManager;
import com.tencent.mm.plugin.sns.ad.widget.recyclerview.b;
import com.tencent.mm.plugin.sns.ad.widget.stackup.StackUpLayout;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.SnsTimeLineUI;
import com.tencent.mm.plugin.sns.ui.bk;
import com.tencent.mm.plugin.sns.ui.bl;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;

public final class a extends BaseTimeLineItem implements d, b, com.tencent.mm.plugin.sns.ui.video.a {
    SnsInfo DqO;
    CardLayoutManager DyT;
    e DyU = new e();
    C1708a DyV;
    com.tencent.mm.plugin.sns.ad.timeline.c.a.b DyW;
    f DyX;
    c DyY = new c();
    com.tencent.mm.plugin.sns.ad.timeline.c.a.a DyZ;

    /* renamed from: com.tencent.mm.plugin.sns.ad.timeline.c.a$a  reason: collision with other inner class name */
    public static class C1708a extends BaseTimeLineItem.BaseViewHolder {
        RoundedCornerFrameLayout Dzc;
        RecyclerView Dzd;
        ViewGroup Dze;
        ImageView Dzf;
        TextView Dzg;
        StackUpLayout Dzh;
        TextView Dzi;
        ViewGroup jLx;
    }

    public a() {
        AppMethodBeat.i(202238);
        AppMethodBeat.o(202238);
    }

    @Override // com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem
    public final void d(BaseTimeLineItem.BaseViewHolder baseViewHolder) {
        AppMethodBeat.i(202239);
        Log.d("SnsAd.FinderTopicTimeLineItem", "AdFinderTopicTimeLineItem build content is called");
        if (!(baseViewHolder instanceof C1708a)) {
            Log.e("SnsAd.FinderTopicTimeLineItem", "buildContent::the holder is not type of FinderTopicItemViewHolder!!!");
            AppMethodBeat.o(202239);
            return;
        }
        this.DyV = (C1708a) baseViewHolder;
        try {
            if (baseViewHolder.EWD != null) {
                baseViewHolder.EWD.setLayoutResource(R.layout.bty);
                if (!baseViewHolder.EWE) {
                    this.DyV.jLx = (ViewGroup) baseViewHolder.EWD.inflate();
                    baseViewHolder.EWE = true;
                }
            } else if (!baseViewHolder.EWE) {
                this.DyV.jLx = (ViewGroup) baseViewHolder.convertView.findViewById(R.id.fg);
                baseViewHolder.EWE = true;
            }
            this.DyZ = new com.tencent.mm.plugin.sns.ad.timeline.c.a.a(1);
            C1708a aVar = this.DyV;
            if (aVar != null) {
                ViewGroup viewGroup = aVar.jLx;
                if (viewGroup == null) {
                    Log.e("SnsAd.FinderTopicTimeLineItem", "fillViewHolder::the root null, is it right????");
                    AppMethodBeat.o(202239);
                    return;
                }
                aVar.Dzc = (RoundedCornerFrameLayout) viewGroup.findViewById(R.id.hv5);
                aVar.Dzd = (RecyclerView) viewGroup.findViewById(R.id.hv4);
                aVar.Dzf = (ImageView) viewGroup.findViewById(R.id.hv1);
                aVar.Dzg = (TextView) viewGroup.findViewById(R.id.hv3);
                aVar.Dzh = (StackUpLayout) viewGroup.findViewById(R.id.hv0);
                aVar.Dzi = (TextView) viewGroup.findViewById(R.id.huz);
                aVar.Dze = (ViewGroup) viewGroup.findViewById(R.id.hv2);
                if (aVar.Dzf != null) {
                    aVar.Dzf.setImageResource(R.raw.sns_ad_finder_topic_item_rear_flag);
                }
                if (aVar.Dzh != null) {
                    StackUpLayout stackUpLayout = aVar.Dzh;
                    stackUpLayout.setStackUpWidthSize(com.tencent.mm.cb.a.fromDPToPix((Context) this.mActivity, 6));
                    int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix((Context) this.mActivity, 20);
                    stackUpLayout.ir(fromDPToPix, fromDPToPix);
                }
                if (aVar.Dzc != null) {
                    int fromDPToPix2 = com.tencent.mm.cb.a.fromDPToPix((Context) this.mActivity, 8);
                    aVar.Dzc.s((float) fromDPToPix2, (float) fromDPToPix2, 0.0f, 0.0f);
                }
                if (aVar.Dzd != null) {
                    aVar.Dzd.setHasFixedSize(true);
                    this.DyT = new CardLayoutManager(aVar.Dzd);
                    this.DyX = new f(this.DyU, this.DyZ);
                    this.DyT.a(new com.tencent.mm.plugin.sns.ad.widget.recyclerview.a(com.tencent.mm.cb.a.fromDPToPix((Context) this.mActivity, 12), com.tencent.mm.cb.a.fromDPToPix((Context) this.mActivity, 8)));
                    this.DyT.DBs = this.DyX;
                    aVar.Dzd.setLayoutManager(this.DyT);
                }
                this.DyW = new com.tencent.mm.plugin.sns.ad.timeline.c.a.b(this.mActivity, aVar.Dzi, aVar.Dzd);
            }
            AppMethodBeat.o(202239);
        } catch (Throwable th) {
            AppMethodBeat.o(202239);
        }
    }

    @Override // com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem
    public final void a(BaseTimeLineItem.BaseViewHolder baseViewHolder, int i2, bl blVar, TimeLineObject timeLineObject, int i3, bk bkVar) {
        boolean z;
        AppMethodBeat.i(202240);
        if (!(baseViewHolder instanceof C1708a)) {
            Log.e("SnsAd.FinderTopicTimeLineItem", "fillItem::the holder is not type of FinderTopicItemViewHolder!!!");
            AppMethodBeat.o(202240);
        } else if (blVar == null) {
            Log.e("SnsAd.FinderTopicTimeLineItem", "fillItem::the struct is null!!!");
            AppMethodBeat.o(202240);
        } else if (baseViewHolder.hho) {
            Log.i("SnsAd.FinderTopicTimeLineItem", "holder is busy");
            AppMethodBeat.o(202240);
        } else {
            baseViewHolder.hho = true;
            final SnsInfo snsInfo = blVar.DqO;
            if (snsInfo == null || snsInfo.getAdXml() == null) {
                AppMethodBeat.o(202240);
                return;
            }
            this.DqO = snsInfo;
            try {
                C1708a aVar = (C1708a) baseViewHolder;
                com.tencent.mm.plugin.sns.ad.a.d dVar = snsInfo.getAdXml().adFinderTopicInfo;
                if (aVar != null) {
                    m.f(aVar.Dzi, (CharSequence) dVar.DrQ);
                    this.DyY.a(aVar.Dzh, snsInfo);
                }
                if (aVar != null) {
                    if (aVar.Dzg != null) {
                        aVar.Dzg.setText(dVar.DrP);
                    }
                    if (aVar.Dze != null) {
                        aVar.Dze.setOnClickListener(new View.OnClickListener() {
                            /* class com.tencent.mm.plugin.sns.ad.timeline.c.a.AnonymousClass1 */

                            public final void onClick(View view) {
                                AppMethodBeat.i(202237);
                                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                bVar.bm(view);
                                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ad/timeline/item/AdFinderTopicTimeLineItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                try {
                                    if (a.this.DyZ != null) {
                                        a.this.DyZ.eXZ();
                                    }
                                    a.this.b(view, snsInfo);
                                } catch (Throwable th) {
                                }
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ad/timeline/item/AdFinderTopicTimeLineItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(202237);
                            }
                        });
                    }
                }
                if (this.DyX != null) {
                    this.DyX.DqO = snsInfo;
                }
                RecyclerView recyclerView = aVar.Dzd;
                if (recyclerView != null) {
                    RecyclerView.a adapter = recyclerView.getAdapter();
                    if (!(adapter instanceof com.tencent.mm.plugin.sns.ad.timeline.c.a.d) || !((com.tencent.mm.plugin.sns.ad.timeline.c.a.d) adapter).p(snsInfo)) {
                        z = true;
                    } else {
                        adapter.atj.notifyChanged();
                        z = false;
                    }
                    if (z) {
                        Log.d("SnsAd.FinderTopicTimeLineItem", "the adapter sns info is not same");
                        com.tencent.mm.plugin.sns.ad.timeline.c.a.d dVar2 = new com.tencent.mm.plugin.sns.ad.timeline.c.a.d(aVar.Dzd, snsInfo);
                        dVar2.au(true);
                        dVar2.DzB = this;
                        recyclerView.setAdapter(dVar2);
                    }
                }
                c(snsInfo, true);
                if (this.DyZ != null) {
                    this.DyZ.a(snsInfo, 0, dVar);
                }
                k kVar = null;
                if (bkVar != null && bkVar.EKl != null && bkVar.EKl.EoE != null) {
                    kVar = bkVar.EKl.EoE;
                } else if (this.mActivity instanceof SnsTimeLineUI) {
                    kVar = ((SnsTimeLineUI) this.mActivity).fjf();
                }
                if (kVar != null) {
                    String v = r.v(snsInfo);
                    if (!TextUtils.isEmpty(v) && !AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(v)) {
                        kVar.a(v, this);
                    }
                }
            } catch (Throwable th) {
            }
            baseViewHolder.hho = false;
            AppMethodBeat.o(202240);
        }
    }

    @Override // com.tencent.mm.plugin.sns.ui.video.a
    public final void a(BaseTimeLineItem.BaseViewHolder baseViewHolder, int i2) {
        AppMethodBeat.i(202241);
        try {
            Log.d("SnsAd.FinderTopicTimeLineItem", "the item video play!!! item hash " + hashCode());
            com.tencent.mm.plugin.sns.ui.video.d.fkS().cXa();
            com.tencent.mm.plugin.sns.ui.video.b.fkM().a(this);
            if (this.DyX != null) {
                this.DyX.b(this.DyT);
            }
            AppMethodBeat.o(202241);
        } catch (Throwable th) {
            AppMethodBeat.o(202241);
        }
    }

    @Override // com.tencent.mm.plugin.sns.ui.video.a
    public final void pause() {
        AppMethodBeat.i(202242);
        try {
            Log.d("SnsAd.FinderTopicTimeLineItem", "the item  video pause!!! item hash " + hashCode());
            a(this.DyT);
            AppMethodBeat.o(202242);
        } catch (Throwable th) {
            AppMethodBeat.o(202242);
        }
    }

    @Override // com.tencent.mm.plugin.sns.ui.video.a
    public final void onUIPause() {
        AppMethodBeat.i(202243);
        try {
            Log.d("SnsAd.FinderTopicTimeLineItem", "the item  video onUIPause!!! item hash " + hashCode());
            a(this.DyT);
            AppMethodBeat.o(202243);
        } catch (Throwable th) {
            AppMethodBeat.o(202243);
        }
    }

    @Override // com.tencent.mm.plugin.sns.ui.video.a
    public final void stop() {
        AppMethodBeat.i(202244);
        try {
            Log.d("SnsAd.FinderTopicTimeLineItem", "the item video stop!!! item hash " + hashCode());
            if (this.DyU != null) {
                this.DyU.stopAll();
            }
            AppMethodBeat.o(202244);
        } catch (Throwable th) {
            AppMethodBeat.o(202244);
        }
    }

    @Override // com.tencent.mm.plugin.sns.ui.video.a
    public final Rect getDisplayRect() {
        AppMethodBeat.i(202245);
        try {
            C1708a aVar = this.DyV;
            if (!(aVar == null || aVar.Dzc == null)) {
                int[] iArr = new int[2];
                aVar.Dzc.getLocationOnScreen(iArr);
                int i2 = iArr[0];
                int i3 = iArr[1];
                Rect rect = new Rect(i2, i3, aVar.Dzc.getWidth() + i2, aVar.Dzc.getHeight() + i3);
                AppMethodBeat.o(202245);
                return rect;
            }
        } catch (Throwable th) {
        }
        AppMethodBeat.o(202245);
        return null;
    }

    @Override // com.tencent.mm.plugin.sns.ad.widget.recyclerview.b
    public final void au(View view, int i2) {
        AppMethodBeat.i(202246);
        try {
            b(view, this.DqO);
            if (this.DyZ != null) {
                this.DyZ.XN(i2);
            }
            AppMethodBeat.o(202246);
        } catch (Throwable th) {
            AppMethodBeat.o(202246);
        }
    }

    @Override // com.tencent.mm.plugin.sns.ad.g.d
    public final void aNK(String str) {
        AppMethodBeat.i(202247);
        try {
            if (this.DqO != null) {
                String v = r.v(this.DqO);
                if (!TextUtils.isEmpty(v) && v.equals(str)) {
                    i.a(this.DyZ);
                }
            }
            AppMethodBeat.o(202247);
        } catch (Throwable th) {
            AppMethodBeat.o(202247);
        }
    }

    private void c(SnsInfo snsInfo, boolean z) {
        AppMethodBeat.i(202248);
        com.tencent.mm.plugin.sns.ad.timeline.c.a.b bVar = this.DyW;
        if (bVar != null) {
            bVar.c(snsInfo, z);
        }
        AppMethodBeat.o(202248);
    }

    private void a(CardLayoutManager cardLayoutManager) {
        AppMethodBeat.i(202249);
        if (this.DyX != null) {
            this.DyX.eYb();
        }
        if (cardLayoutManager != null) {
            cardLayoutManager.eYC();
        }
        AppMethodBeat.o(202249);
    }

    /* access modifiers changed from: protected */
    public final void b(View view, SnsInfo snsInfo) {
        k fjf;
        AppMethodBeat.i(202250);
        com.tencent.mm.plugin.sns.ad.timeline.a.c d2 = com.tencent.mm.plugin.sns.ad.timeline.a.a.d(5, this.mActivity);
        if (d2 != null) {
            com.tencent.mm.plugin.sns.ad.timeline.a.d dVar = new com.tencent.mm.plugin.sns.ad.timeline.a.d();
            if ((this.mActivity instanceof SnsTimeLineUI) && (fjf = ((SnsTimeLineUI) this.mActivity).fjf()) != null) {
                dVar.z("sns_ad_statistic", fjf);
            }
            d2.a(view, 0, snsInfo, dVar);
            c(this.DqO, false);
        }
        AppMethodBeat.o(202250);
    }
}
