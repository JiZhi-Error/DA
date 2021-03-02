package com.tencent.mm.plugin.finder.live.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.live.plugin.aa;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.storage.s;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.at;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.a.r;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001+B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u001f\u001a\u00020\u0018H\u0016J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0018H\u0016J\u0010\u0010#\u001a\u00020$2\u0006\u0010\"\u001a\u00020\u0018H\u0016J$\u0010%\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u00182\b\u0010&\u001a\u0004\u0018\u00010\u00152\b\u0010'\u001a\u0004\u0018\u00010\u0011H\u0016J\u001c\u0010(\u001a\u00020\u001a2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0)2\u0006\u0010*\u001a\u00020\u0018R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eX\u0004¢\u0006\u0002\n\u0000Rv\u0010\u000f\u001a^\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006,"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveGiftGridAdapter;", "Landroid/widget/BaseAdapter;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getContext", "()Landroid/content/Context;", "giftList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/storage/FinderLiveGiftInfo;", "Lkotlin/collections/ArrayList;", "onGiftItemClick", "Lkotlin/Function4;", "Landroid/view/ViewGroup;", "Lkotlin/ParameterName;", "name", "view", "Landroid/view/View;", "curThumbView", "giftId", "", "bottomMargin", "", "getOnGiftItemClick", "()Lkotlin/jvm/functions/Function4;", "setOnGiftItemClick", "(Lkotlin/jvm/functions/Function4;)V", "getCount", "getItem", "", "position", "getItemId", "", "getView", "convertView", "parent", "updateGift", "", "pageIndex", "FinderLiveGiftItemHolder", "plugin-finder_release"})
public final class d extends BaseAdapter {
    private final String TAG = "FinderLiveGiftGridAdapter";
    private final Context context;
    private final ArrayList<s> uAK = new ArrayList<>();
    public r<? super ViewGroup, ? super View, ? super String, ? super Integer, x> upn;

    public d(Context context2) {
        p.h(context2, "context");
        AppMethodBeat.i(247778);
        this.context = context2;
        AppMethodBeat.o(247778);
    }

    public final void r(List<s> list, int i2) {
        AppMethodBeat.i(247773);
        p.h(list, "giftList");
        int size = list.size();
        Log.i(this.TAG, "updateGift pageIndex:" + i2 + ",size:" + size);
        this.uAK.clear();
        aa.a aVar = aa.ups;
        int dhj = aa.dhj() * i2;
        aa.a aVar2 = aa.ups;
        int dhj2 = aa.dhj() + dhj;
        while (dhj < size && dhj < dhj2) {
            this.uAK.add(list.get(dhj));
            dhj++;
        }
        AppMethodBeat.o(247773);
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        a aVar;
        AppMethodBeat.i(247774);
        Log.i(this.TAG, "getView position:" + i2 + ",convertView is null:" + (view == null));
        if (view == null) {
            view = LayoutInflater.from(this.context).inflate(R.layout.adp, viewGroup, false);
            p.g(view, "LayoutInflater.from(cont…t_item_ui, parent, false)");
            a aVar2 = new a(view);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            Object tag = view.getTag();
            if (tag == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.live.view.adapter.FinderLiveGiftGridAdapter.FinderLiveGiftItemHolder");
                AppMethodBeat.o(247774);
                throw tVar;
            }
            aVar = (a) tag;
        }
        s sVar = this.uAK.get(i2);
        p.g(sVar, "giftList[position]");
        s sVar2 = sVar;
        m mVar = m.uJa;
        m.djY().bQ(new com.tencent.mm.plugin.finder.loader.p(sVar2.field_thumbnailFileUrl, com.tencent.mm.plugin.finder.storage.x.THUMB_IMAGE)).c(aVar.uAL);
        aVar.uAM.setText(sVar2.field_name);
        int i3 = (int) sVar2.field_price;
        if (i3 > 0) {
            aVar.uAP.setText(String.valueOf(i3));
        } else {
            aVar.uAP.setText(String.valueOf(sVar2.field_price));
        }
        aVar.aus.setOnClickListener(new b(this, aVar, sVar2));
        AppMethodBeat.o(247774);
        return view;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b implements View.OnClickListener {
        final /* synthetic */ d uAQ;
        final /* synthetic */ a uAR;
        final /* synthetic */ s uAS;

        b(d dVar, a aVar, s sVar) {
            this.uAQ = dVar;
            this.uAR = aVar;
            this.uAS = sVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(247772);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveGiftGridAdapter$getView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            p.g(view, LocaleUtil.ITALIAN);
            int measuredHeight = this.uAR.uAN.getMeasuredHeight() + this.uAR.uAM.getMeasuredHeight() + at.fromDPToPix(view.getContext(), 12);
            r<? super ViewGroup, ? super View, ? super String, ? super Integer, x> rVar = this.uAQ.upn;
            if (rVar != null) {
                ImageView imageView = this.uAR.uAL;
                String str = this.uAS.field_rewardProductId;
                p.g(str, "giftInfo.field_rewardProductId");
                rVar.invoke((ViewGroup) view, imageView, str, Integer.valueOf(measuredHeight));
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveGiftGridAdapter$getView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(247772);
        }
    }

    public final Object getItem(int i2) {
        AppMethodBeat.i(247775);
        Log.i(this.TAG, "getItem:".concat(String.valueOf(i2)));
        s sVar = this.uAK.get(i2);
        p.g(sVar, "giftList[position]");
        AppMethodBeat.o(247775);
        return sVar;
    }

    public final long getItemId(int i2) {
        AppMethodBeat.i(247776);
        Log.i(this.TAG, "getItemId:".concat(String.valueOf(i2)));
        long j2 = (long) i2;
        AppMethodBeat.o(247776);
        return j2;
    }

    public final int getCount() {
        AppMethodBeat.i(247777);
        Log.i(this.TAG, "getCount:" + this.uAK.size());
        int size = this.uAK.size();
        AppMethodBeat.o(247777);
        return size;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\bR\u0011\u0010\u0012\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000b¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveGiftGridAdapter$FinderLiveGiftItemHolder;", "", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "giftName", "Landroid/widget/TextView;", "getGiftName", "()Landroid/widget/TextView;", "giftPriceGroup", "getGiftPriceGroup", "()Landroid/view/View;", "giftPriceIcon", "Landroid/widget/ImageView;", "getGiftPriceIcon", "()Landroid/widget/ImageView;", "giftPriceTv", "getGiftPriceTv", "giftThumb", "getGiftThumb", "getItemView", "plugin-finder_release"})
    public static final class a {
        final View aus;
        final ImageView uAL;
        final TextView uAM;
        final View uAN;
        private final ImageView uAO;
        final TextView uAP;

        public a(View view) {
            p.h(view, "itemView");
            AppMethodBeat.i(247771);
            this.aus = view;
            View findViewById = this.aus.findViewById(R.id.cr3);
            p.g(findViewById, "itemView.findViewById(R.id.finder_live_gift_thumb)");
            this.uAL = (ImageView) findViewById;
            View findViewById2 = this.aus.findViewById(R.id.cqe);
            p.g(findViewById2, "itemView.findViewById(R.id.finder_live_gift_name)");
            this.uAM = (TextView) findViewById2;
            View findViewById3 = this.aus.findViewById(R.id.cqv);
            p.g(findViewById3, "itemView.findViewById(R.…er_live_gift_price_group)");
            this.uAN = findViewById3;
            View findViewById4 = this.aus.findViewById(R.id.cqw);
            p.g(findViewById4, "itemView.findViewById(R.…der_live_gift_price_icon)");
            this.uAO = (ImageView) findViewById4;
            View findViewById5 = this.aus.findViewById(R.id.cqx);
            p.g(findViewById5, "itemView.findViewById(R.…inder_live_gift_price_tv)");
            this.uAP = (TextView) findViewById5;
            this.uAM.setTextSize(1, 12.0f);
            this.uAP.setTextSize(1, 12.0f);
            AppMethodBeat.o(247771);
        }
    }
}
