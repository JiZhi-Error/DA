package com.tencent.mm.plugin.story.ui.a;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.story.api.l;
import com.tencent.mm.plugin.story.ui.view.StoryAvatarItemView;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.at;
import java.util.ArrayList;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001$B\u001f\u0012\u0018\b\u0002\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u001c\u0010\u001a\u001a\u00020\u00132\n\u0010\u001b\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u0019H\u0016J\u001c\u0010\u001d\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0019H\u0016J\u0014\u0010!\u001a\u00020\u00132\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00050#R*\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0007RL\u0010\u000b\u001a4\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006%"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/adapter/StoryHeaderTipAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/story/ui/adapter/StoryHeaderTipAdapter$StoryHeaderTipHolder;", "datas", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher$StoryFetcherItemEntity;", "Lkotlin/collections/ArrayList;", "(Ljava/util/ArrayList;)V", "getDatas", "()Ljava/util/ArrayList;", "setDatas", "onItemClick", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", ch.COL_USERNAME, "", "isReply", "", "getOnItemClick", "()Lkotlin/jvm/functions/Function2;", "setOnItemClick", "(Lkotlin/jvm/functions/Function2;)V", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "type", "updateDatas", "newDatas", "", "StoryHeaderTipHolder", "plugin-story_release"})
public final class j extends RecyclerView.a<a> {
    public m<? super String, ? super Boolean, x> Fyk;
    public ArrayList<l.d> Fyl;

    public /* synthetic */ j() {
        this(new ArrayList());
        AppMethodBeat.i(119780);
        AppMethodBeat.o(119780);
    }

    private j(ArrayList<l.d> arrayList) {
        p.h(arrayList, "datas");
        AppMethodBeat.i(119779);
        this.Fyl = arrayList;
        AppMethodBeat.o(119779);
    }

    /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ a a(ViewGroup viewGroup, int i2) {
        AppMethodBeat.i(119776);
        p.h(viewGroup, "parent");
        View inflate = View.inflate(viewGroup.getContext(), R.layout.c0c, null);
        p.g(inflate, "itemView");
        a aVar = new a(this, inflate);
        AppMethodBeat.o(119776);
        return aVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ void a(a aVar, int i2) {
        AppMethodBeat.i(119778);
        a aVar2 = aVar;
        p.h(aVar2, "holder");
        if (i2 == 0) {
            RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(-2, -2);
            View view = aVar2.aus;
            p.g(view, "holder.itemView");
            layoutParams.setMarginStart(at.fromDPToPix(view.getContext(), 26));
            layoutParams.setMarginEnd(0);
            View view2 = aVar2.aus;
            p.g(view2, "holder.itemView");
            view2.setLayoutParams(layoutParams);
        } else if (i2 == this.Fyl.size() - 1) {
            RecyclerView.LayoutParams layoutParams2 = new RecyclerView.LayoutParams(-2, -2);
            View view3 = aVar2.aus;
            p.g(view3, "holder.itemView");
            layoutParams2.setMarginStart(at.fromDPToPix(view3.getContext(), 24));
            View view4 = aVar2.aus;
            p.g(view4, "holder.itemView");
            layoutParams2.setMarginEnd(at.fromDPToPix(view4.getContext(), 22));
            View view5 = aVar2.aus;
            p.g(view5, "holder.itemView");
            view5.setLayoutParams(layoutParams2);
        } else {
            RecyclerView.LayoutParams layoutParams3 = new RecyclerView.LayoutParams(-2, -2);
            View view6 = aVar2.aus;
            p.g(view6, "holder.itemView");
            layoutParams3.setMarginStart(at.fromDPToPix(view6.getContext(), 24));
            layoutParams3.setMarginEnd(0);
            View view7 = aVar2.aus;
            p.g(view7, "holder.itemView");
            view7.setLayoutParams(layoutParams3);
        }
        l.d dVar = this.Fyl.get(i2);
        p.g(dVar, "datas[position]");
        l.d dVar2 = dVar;
        String str = dVar2.username;
        StoryAvatarItemView storyAvatarItemView = aVar2.Fym;
        p.g(str, ch.COL_USERNAME);
        storyAvatarItemView.setAvatar(str);
        aVar2.Fym.setTag(dVar2);
        aVar2.Fym.setOnClickListener(new b(this, str));
        if (dVar2.fnp()) {
            aVar2.Fym.setTipCount(com.tencent.mm.plugin.story.f.f.a.FpB.aSf(str));
            AppMethodBeat.o(119778);
            return;
        }
        aVar2.Fym.setTipCount(0);
        AppMethodBeat.o(119778);
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemCount() {
        AppMethodBeat.i(119777);
        int size = this.Fyl.size();
        AppMethodBeat.o(119777);
        return size;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b implements View.OnClickListener {
        final /* synthetic */ j Fyn;
        final /* synthetic */ String hLl;

        b(j jVar, String str) {
            this.Fyn = jVar;
            this.hLl = str;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(119775);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/adapter/StoryHeaderTipAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            p.g(view, LocaleUtil.ITALIAN);
            Object tag = view.getTag();
            if (tag == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.story.api.IStoryStateFetcher.StoryFetcherItemEntity");
                AppMethodBeat.o(119775);
                throw tVar;
            }
            boolean fnp = ((l.d) tag).fnp();
            m<? super String, ? super Boolean, x> mVar = this.Fyn.Fyk;
            if (mVar != null) {
                String str = this.hLl;
                p.g(str, ch.COL_USERNAME);
                mVar.invoke(str, Boolean.valueOf(fnp));
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/adapter/StoryHeaderTipAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(119775);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/adapter/StoryHeaderTipAdapter$StoryHeaderTipHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/adapter/StoryHeaderTipAdapter;Landroid/view/View;)V", "avatarItem", "Lcom/tencent/mm/plugin/story/ui/view/StoryAvatarItemView;", "getAvatarItem", "()Lcom/tencent/mm/plugin/story/ui/view/StoryAvatarItemView;", "plugin-story_release"})
    public final class a extends RecyclerView.v {
        final StoryAvatarItemView Fym;
        final /* synthetic */ j Fyn;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(j jVar, View view) {
            super(view);
            p.h(view, "itemView");
            this.Fyn = jVar;
            AppMethodBeat.i(119774);
            View findViewById = view.findViewById(R.id.ib9);
            p.g(findViewById, "itemView.findViewById(R.…ory_header_tip_item_view)");
            this.Fym = (StoryAvatarItemView) findViewById;
            AppMethodBeat.o(119774);
        }
    }
}
