package com.tencent.mm.plugin.sns.ad.timeline.c.a;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.sns.ad.a.e;
import com.tencent.mm.plugin.sns.ad.i.c;
import com.tencent.mm.plugin.sns.ad.i.m;
import com.tencent.mm.plugin.sns.ad.widget.recyclerview.b;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import java.util.List;
import java.util.Objects;

public final class d extends RecyclerView.a<e> implements View.OnClickListener {
    SnsInfo DqO;
    List<e> DzA;
    public b DzB;
    Context mContext;
    RecyclerView mRecyclerView;

    /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ e a(ViewGroup viewGroup, int i2) {
        AppMethodBeat.i(202292);
        e D = D(viewGroup);
        AppMethodBeat.o(202292);
        return D;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ void a(e eVar, int i2) {
        AppMethodBeat.i(202291);
        e eVar2 = eVar;
        try {
            Log.d("SnsAd.RecyclerViewAdapter", "onBindViewHolder:: the pos is ".concat(String.valueOf(i2)));
            e XQ = XQ(i2);
            RecyclerView recyclerView = this.mRecyclerView;
            if (XQ == null || recyclerView == null || eVar2 == null) {
                Log.w("SnsAd.RecyclerViewAdapter", "the res info or recyclerView is null!!!!");
                AppMethodBeat.o(202291);
                return;
            }
            int width = recyclerView.getWidth();
            m.fa(eVar2.DzG);
            m.fa(eVar2.DzD);
            com.tencent.mm.plugin.sns.ad.i.b.a(XQ.uNR, eVar2.DzE, 1);
            m.f(eVar2.DzF, (CharSequence) XQ.nickname);
            m.aw(eVar2.DzF, (int) ((((float) (width - a.fromDPToPix(this.mContext, 80))) - m.f(eVar2.DzF, XQ.DrV)) + 0.5f));
            if (!TextUtils.isEmpty(XQ.DrV)) {
                m.u(eVar2.DzG, true);
                m.f(eVar2.DzG, (CharSequence) XQ.DrV);
            } else {
                m.u(eVar2.DzG, false);
            }
            float fromDPToPix = ((float) (width - a.fromDPToPix(this.mContext, 76))) - m.f(eVar2.DzI, XQ.tag);
            m.f(eVar2.DzI, (CharSequence) XQ.tag);
            m.aw(eVar2.DzJ, (int) (fromDPToPix + 0.5f));
            m.f(eVar2.DzJ, (CharSequence) XQ.desc);
            m.b(eVar2.DzH, (float) a.fromDPToPix(this.mContext, 100), XQ.DrU <= 0.0f ? 0.8f : XQ.DrU, com.tencent.mm.plugin.sns.ad.i.d.aNT(XQ.DrT));
            if (XQ.eWB()) {
                Log.i("SnsAd.RecyclerViewAdapter", "the resInfo is sight");
                g faL = aj.faL();
                cnb cnb = XQ.ebR;
                ImageView imageView = eVar2.DzC;
                int hashCode = this.mContext.hashCode();
                bp bpVar = bp.Oqu;
                bpVar.hXs = this.DqO.getTimeLine().CreateTime;
                faL.b(cnb, imageView, -1, hashCode, bpVar);
                m.u(eVar2.DzD, true);
                AppMethodBeat.o(202291);
                return;
            }
            com.tencent.mm.plugin.sns.ad.i.b.a(XQ.ebR.Msz, eVar2.DzC, 3);
            AppMethodBeat.o(202291);
        } catch (Throwable th) {
            AppMethodBeat.o(202291);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v] */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ void l(e eVar) {
        AppMethodBeat.i(202290);
        e eVar2 = eVar;
        super.l(eVar2);
        try {
            Log.d("SnsAd.RecyclerViewAdapter", "the onViewDetachedFromWindow is called , position is " + eVar2.lR());
            m.F(eVar2.DzD);
            AppMethodBeat.o(202290);
        } catch (Throwable th) {
            AppMethodBeat.o(202290);
        }
    }

    public d(RecyclerView recyclerView, SnsInfo snsInfo) {
        AppMethodBeat.i(202284);
        if (recyclerView != null) {
            this.mRecyclerView = recyclerView;
            this.mContext = recyclerView.getContext();
        } else {
            this.mContext = MMApplicationContext.getContext();
        }
        if (snsInfo != null) {
            try {
                if (snsInfo.getAdXml() != null) {
                    ADXml adXml = snsInfo.getAdXml();
                    if (adXml.adFinderTopicInfo == null || c.isEmpty(adXml.adFinderTopicInfo.DrS)) {
                        Log.w("SnsAd.RecyclerViewAdapter", "the adFinderTopicInfo or resource info list is null, initialize adapter failed!!!");
                        AppMethodBeat.o(202284);
                        return;
                    }
                    this.DqO = snsInfo;
                    this.DzA = adXml.adFinderTopicInfo.DrS;
                    AppMethodBeat.o(202284);
                    return;
                }
            } catch (Throwable th) {
                AppMethodBeat.o(202284);
                return;
            }
        }
        Log.w("SnsAd.RecyclerViewAdapter", "the sns info is null, initialize adapter failed!");
        AppMethodBeat.o(202284);
    }

    public final void onClick(View view) {
        AppMethodBeat.i(202285);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ad/timeline/item/topic/TopicCardRecyclerViewAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        try {
            b bVar2 = this.DzB;
            RecyclerView recyclerView = this.mRecyclerView;
            if (view == null || recyclerView == null || bVar2 == null) {
                Log.w("SnsAd.RecyclerViewAdapter", "the recycler view or click listener is null!!!");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ad/timeline/item/topic/TopicCardRecyclerViewAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(202285);
            } else if (view.getParent() != recyclerView) {
                Log.e("SnsAd.RecyclerViewAdapter", "are you cray?!! the parent of the clicked view is not same as the input recycler view!!");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ad/timeline/item/topic/TopicCardRecyclerViewAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(202285);
            } else {
                RecyclerView.v bi = recyclerView.bi(view);
                if (bi == null) {
                    Log.e("SnsAd.RecyclerViewAdapter", "I think the statement can't be reached, why?");
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ad/timeline/item/topic/TopicCardRecyclerViewAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(202285);
                    return;
                }
                bVar2.au(view, bi.lR());
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ad/timeline/item/topic/TopicCardRecyclerViewAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(202285);
            }
        } catch (Throwable th) {
        }
    }

    private e D(ViewGroup viewGroup) {
        AppMethodBeat.i(202286);
        try {
            Log.d("SnsAd.RecyclerViewAdapter", "mRecyclerView width is " + viewGroup.getWidth());
            View e2 = m.e(this.mContext, viewGroup);
            int fromDPToPix = a.fromDPToPix(this.mContext, 8);
            if (e2 instanceof RoundedCornerFrameLayout) {
                ((RoundedCornerFrameLayout) e2).s((float) fromDPToPix, (float) fromDPToPix, 0.0f, 0.0f);
            }
            if (e2 != null) {
                e2.setOnClickListener(this);
                e eVar = new e(e2);
                AppMethodBeat.o(202286);
                return eVar;
            }
            Log.e("SnsAd.RecyclerViewAdapter", "the inflated view is null????");
            e eVar2 = new e(new View(viewGroup.getContext()));
            AppMethodBeat.o(202286);
            return eVar2;
        } catch (Throwable th) {
            Log.e("SnsAd.RecyclerViewAdapter", "onCreateViewHolder failed????");
            e eVar3 = new e(new View(MMApplicationContext.getContext()));
            AppMethodBeat.o(202286);
            return eVar3;
        }
    }

    public final e XQ(int i2) {
        AppMethodBeat.i(202287);
        try {
            if (this.DzA != null && i2 >= 0 && i2 < this.DzA.size()) {
                e eVar = this.DzA.get(i2);
                AppMethodBeat.o(202287);
                return eVar;
            }
        } catch (Throwable th) {
            Log.w("SnsAd.RecyclerViewAdapter", "the getResInfo has something wrong " + th.getMessage());
        }
        AppMethodBeat.o(202287);
        return null;
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemCount() {
        AppMethodBeat.i(202288);
        if (this.DzA != null) {
            int size = this.DzA.size();
            AppMethodBeat.o(202288);
            return size;
        }
        AppMethodBeat.o(202288);
        return 0;
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final long getItemId(int i2) {
        return (long) i2;
    }

    public final boolean p(SnsInfo snsInfo) {
        boolean z = false;
        AppMethodBeat.i(202289);
        if (snsInfo == null) {
            AppMethodBeat.o(202289);
        } else {
            try {
                z = Objects.equals(r.v(this.DqO), r.v(snsInfo));
                AppMethodBeat.o(202289);
            } catch (Throwable th) {
                AppMethodBeat.o(202289);
            }
        }
        return z;
    }
}
