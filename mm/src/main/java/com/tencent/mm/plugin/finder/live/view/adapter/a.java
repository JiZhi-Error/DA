package com.tencent.mm.plugin.finder.live.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.live.viewmodel.e;
import com.tencent.mm.plugin.finder.live.viewmodel.g;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001&B\u0005¢\u0006\u0002\u0010\u0003J\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\b0\u001bJ\b\u0010\u001c\u001a\u00020\u0005H\u0016J\u0018\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0005H\u0016J\u0018\u0010 \u001a\u00020\u00022\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0005H\u0016J\u0014\u0010$\u001a\u00020\u00152\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\b0\u001bR\u000e\u0010\u0004\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR7\u0010\u0010\u001a\u001f\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006'"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorApplyLinkAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorApplyLinkAdapter$ApplyLinkViewHolder;", "()V", "MAX_COUNT", "", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveLinkMicUser;", "Lkotlin/collections/ArrayList;", "liveData", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;", "getLiveData", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;", "setLiveData", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;)V", "onAcceptLinkUser", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "acceptUser", "", "getOnAcceptLinkUser", "()Lkotlin/jvm/functions/Function1;", "setOnAcceptLinkUser", "(Lkotlin/jvm/functions/Function1;)V", "getDataList", "", "getItemCount", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "type", "updateData", "data", "ApplyLinkViewHolder", "plugin-finder_release"})
public final class a extends RecyclerView.a<C1195a> {
    private final int MAX_COUNT = 300;
    private final ArrayList<e> kgc = new ArrayList<>();
    public g liveData;
    public kotlin.g.a.b<? super e, x> uzX;

    public a() {
        AppMethodBeat.i(260880);
        AppMethodBeat.o(260880);
    }

    /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ C1195a a(ViewGroup viewGroup, int i2) {
        AppMethodBeat.i(260876);
        p.h(viewGroup, "parent");
        View inflate = View.inflate(viewGroup.getContext(), R.layout.cf2, null);
        p.g(inflate, "View.inflate(parent.cont…_anchor_apply_item, null)");
        C1195a aVar = new C1195a(inflate);
        AppMethodBeat.o(260876);
        return aVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ void a(C1195a aVar, int i2) {
        String str;
        e eVar;
        AppMethodBeat.i(260878);
        C1195a aVar2 = aVar;
        p.h(aVar2, "holder");
        e eVar2 = this.kgc.get(i2);
        p.g(eVar2, "dataList[position]");
        e eVar3 = eVar2;
        m mVar = m.uJa;
        d<o> dka = m.dka();
        com.tencent.mm.plugin.finder.loader.a aVar3 = new com.tencent.mm.plugin.finder.loader.a(eVar3.headUrl);
        ImageView imageView = aVar2.keC;
        p.g(imageView, "holder.avatar");
        m mVar2 = m.uJa;
        dka.a(aVar3, imageView, m.a(m.a.AVATAR));
        TextView textView = aVar2.pIN;
        p.g(textView, "holder.nicknameTv");
        com.tencent.mm.plugin.finder.convert.d dVar = com.tencent.mm.plugin.finder.convert.d.tyZ;
        TextView textView2 = aVar2.pIN;
        p.g(textView2, "holder.nicknameTv");
        y yVar = y.vXH;
        String str2 = eVar3.username;
        if (str2 == null) {
            str2 = "";
        }
        String str3 = eVar3.nickname;
        if (str3 == null) {
            str3 = "";
        }
        textView.setText(com.tencent.mm.plugin.finder.convert.d.e(textView2, y.hf(str2, str3)));
        g gVar = this.liveData;
        if (gVar == null || (eVar = gVar.uEB) == null) {
            str = null;
        } else {
            str = eVar.username;
        }
        if (Util.isEqual(str, eVar3.username)) {
            TextView textView3 = aVar2.uAa;
            p.g(textView3, "holder.acceptBtn");
            TextView textView4 = aVar2.uAa;
            p.g(textView4, "holder.acceptBtn");
            Context context = textView4.getContext();
            p.g(context, "holder.acceptBtn.context");
            textView3.setText(context.getResources().getString(R.string.jab));
            TextView textView5 = aVar2.uAa;
            p.g(textView5, "holder.acceptBtn");
            TextView textView6 = aVar2.uAa;
            p.g(textView6, "holder.acceptBtn");
            textView5.setBackground(textView6.getContext().getDrawable(R.drawable.cun));
            TextView textView7 = aVar2.uAa;
            TextView textView8 = aVar2.uAa;
            p.g(textView8, "holder.acceptBtn");
            Context context2 = textView8.getContext();
            p.g(context2, "holder.acceptBtn.context");
            textView7.setTextColor(context2.getResources().getColor(R.color.Red_100));
        } else {
            TextView textView9 = aVar2.uAa;
            p.g(textView9, "holder.acceptBtn");
            TextView textView10 = aVar2.uAa;
            p.g(textView10, "holder.acceptBtn");
            Context context3 = textView10.getContext();
            p.g(context3, "holder.acceptBtn.context");
            textView9.setText(context3.getResources().getString(R.string.ctr));
            TextView textView11 = aVar2.uAa;
            p.g(textView11, "holder.acceptBtn");
            TextView textView12 = aVar2.uAa;
            p.g(textView12, "holder.acceptBtn");
            textView11.setBackground(textView12.getContext().getDrawable(R.drawable.a20));
            TextView textView13 = aVar2.uAa;
            TextView textView14 = aVar2.uAa;
            p.g(textView14, "holder.acceptBtn");
            Context context4 = textView14.getContext();
            p.g(context4, "holder.acceptBtn.context");
            textView13.setTextColor(context4.getResources().getColor(R.color.BW_0_Alpha_0_8));
        }
        TextView textView15 = aVar2.hPW;
        p.g(textView15, "holder.descTv");
        TextView textView16 = aVar2.hPW;
        p.g(textView16, "holder.descTv");
        TextView textView17 = aVar2.hPW;
        p.g(textView17, "holder.descTv");
        textView15.setText(com.tencent.mm.pluginsdk.ui.span.l.b(textView16.getContext(), eVar3.signature, textView17.getTextSize()));
        y yVar2 = y.vXH;
        ImageView imageView2 = aVar2.uzZ;
        p.g(imageView2, "holder.typeIcon");
        y.a(imageView2, eVar3.authInfo);
        aVar2.uAa.setOnClickListener(new b(this, i2));
        AppMethodBeat.o(260878);
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemCount() {
        AppMethodBeat.i(260877);
        int size = this.kgc.size();
        AppMethodBeat.o(260877);
        return size;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b implements View.OnClickListener {
        final /* synthetic */ a UNX;
        final /* synthetic */ int gUj;

        b(a aVar, int i2) {
            this.UNX = aVar;
            this.gUj = i2;
        }

        public final void onClick(View view) {
            kotlin.g.a.b<? super e, x> bVar;
            AppMethodBeat.i(260875);
            com.tencent.mm.hellhoundlib.b.b bVar2 = new com.tencent.mm.hellhoundlib.b.b();
            bVar2.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorApplyLinkAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar2.axR());
            e eVar = (e) j.L(this.UNX.kgc, this.gUj);
            if (!(eVar == null || (bVar = this.UNX.uzX) == null)) {
                bVar.invoke(eVar);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorApplyLinkAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(260875);
        }
    }

    public final void ad(List<e> list) {
        AppMethodBeat.i(260879);
        p.h(list, "data");
        this.kgc.clear();
        ArrayList<e> arrayList = this.kgc;
        ArrayList arrayList2 = new ArrayList();
        int i2 = 0;
        for (T t : list) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                j.hxH();
            }
            if (i2 < this.MAX_COUNT) {
                arrayList2.add(t);
            }
            i2 = i3;
        }
        arrayList.addAll(arrayList2);
        AppMethodBeat.o(260879);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0019\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0019\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u000b0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0019\u0010\u000e\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\tR\u0019\u0010\u0010\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\tR\u0019\u0010\u0012\u001a\n \u0007*\u0004\u0018\u00010\u000b0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorApplyLinkAdapter$ApplyLinkViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "acceptBtn", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getAcceptBtn", "()Landroid/widget/TextView;", "avatar", "Landroid/widget/ImageView;", "getAvatar", "()Landroid/widget/ImageView;", "descTv", "getDescTv", "nicknameTv", "getNicknameTv", "typeIcon", "getTypeIcon", "plugin-finder_release"})
    /* renamed from: com.tencent.mm.plugin.finder.live.view.adapter.a$a  reason: collision with other inner class name */
    public static final class C1195a extends RecyclerView.v {
        final TextView hPW;
        final ImageView keC;
        final TextView pIN;
        final TextView uAa;
        final ImageView uzZ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C1195a(View view) {
            super(view);
            p.h(view, "itemView");
            AppMethodBeat.i(260874);
            this.keC = (ImageView) view.findViewById(R.id.jxl);
            this.pIN = (TextView) view.findViewById(R.id.jxq);
            this.uzZ = (ImageView) view.findViewById(R.id.jxr);
            this.uAa = (TextView) view.findViewById(R.id.jxk);
            this.hPW = (TextView) view.findViewById(R.id.jxt);
            AppMethodBeat.o(260874);
        }
    }
}
