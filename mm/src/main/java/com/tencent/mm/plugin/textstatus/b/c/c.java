package com.tencent.mm.plugin.textstatus.b.c;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.textstatus.ui.TextStatusSameTopicsActivity;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001a\u001bB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\t\u001a\u00020\nH\u0016J@\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00132\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015H\u0017J \u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\nH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/convert/planet/PlanetItemConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/textstatus/model/planet/PlanetItem;", "itemClickListener", "Lcom/tencent/mm/plugin/textstatus/convert/planet/PlanetItemConvert$OnClickCardItemListener;", "(Lcom/tencent/mm/plugin/textstatus/convert/planet/PlanetItemConvert$OnClickCardItemListener;)V", "getItemClickListener", "()Lcom/tencent/mm/plugin/textstatus/convert/planet/PlanetItemConvert$OnClickCardItemListener;", "setItemClickListener", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "planetItem", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "Companion", "OnClickCardItemListener", "plugin-textstatus_release"})
public final class c extends e<com.tencent.mm.plugin.textstatus.f.d.b> {
    public static final a FXV = new a((byte) 0);
    b FXU;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/convert/planet/PlanetItemConvert$OnClickCardItemListener;", "", "onClickItem", "", "itemData", "Lcom/tencent/mm/plugin/textstatus/model/planet/PlanetItem;", "view", "Landroid/view/View;", "plugin-textstatus_release"})
    public interface b {
        void a(com.tencent.mm.plugin.textstatus.f.d.b bVar, View view);
    }

    static {
        AppMethodBeat.i(216120);
        AppMethodBeat.o(216120);
    }

    public c(b bVar) {
        p.h(bVar, "itemClickListener");
        AppMethodBeat.i(216119);
        this.FXU = bVar;
        AppMethodBeat.o(216119);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.view.recyclerview.a, int, int, boolean, java.util.List] */
    @Override // com.tencent.mm.view.recyclerview.e
    public final /* synthetic */ void a(h hVar, com.tencent.mm.plugin.textstatus.f.d.b bVar, int i2, int i3, boolean z, List list) {
        AppMethodBeat.i(216118);
        com.tencent.mm.plugin.textstatus.f.d.b bVar2 = bVar;
        p.h(hVar, "holder");
        p.h(bVar2, "planetItem");
        View Mn = hVar.Mn(R.id.iyz);
        p.g(Mn, "holder.getView<TextView>(R.id.tv_topic)");
        StringBuilder sb = new StringBuilder("#");
        com.tencent.mm.plugin.textstatus.j.b bVar3 = com.tencent.mm.plugin.textstatus.j.b.GfZ;
        ((TextView) Mn).setText(sb.append(com.tencent.mm.plugin.textstatus.j.b.getName(bVar2.iHf.get(0).field_IconID)).toString());
        View Mn2 = hVar.Mn(R.id.ixg);
        p.g(Mn2, "holder.getView<TextView>(R.id.tv_friend_count)");
        ((TextView) Mn2).setText(hVar.getContext().getString(R.string.hnd, Integer.valueOf(bVar2.iHf.size())));
        LinearLayout linearLayout = (LinearLayout) hVar.Mn(R.id.be6);
        linearLayout.removeAllViews();
        Context context = hVar.getContext();
        p.g(context, "holder.context");
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.cc);
        Context context2 = hVar.getContext();
        p.g(context2, "holder.context");
        int dimensionPixelSize2 = context2.getResources().getDimensionPixelSize(R.dimen.bt);
        for (com.tencent.mm.plugin.textstatus.f.f.a aVar : j.b(bVar2.iHf, 3)) {
            ImageView imageView = new ImageView(hVar.getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
            layoutParams.setMarginEnd(dimensionPixelSize2);
            if (linearLayout != null) {
                linearLayout.addView(imageView, layoutParams);
            }
            imageView.setImageResource(R.raw.default_avatar);
            a.b.c(imageView, aVar.field_UserName);
        }
        hVar.Mn(R.id.aeu).setOnClickListener(new View$OnClickListenerC1813c(this, bVar2));
        ((TextView) hVar.Mn(R.id.ixg)).setOnClickListener(new d(hVar, bVar2));
        AppMethodBeat.o(216118);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/convert/planet/PlanetItemConvert$Companion;", "", "()V", "TAG", "", "plugin-textstatus_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final int getLayoutId() {
        return R.layout.c2s;
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final void a(RecyclerView recyclerView, h hVar, int i2) {
        AppMethodBeat.i(216117);
        p.h(recyclerView, "recyclerView");
        p.h(hVar, "holder");
        AppMethodBeat.o(216117);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.textstatus.b.c.c$c  reason: collision with other inner class name */
    static final class View$OnClickListenerC1813c implements View.OnClickListener {
        final /* synthetic */ c FXW;
        final /* synthetic */ com.tencent.mm.plugin.textstatus.f.d.b FXX;

        View$OnClickListenerC1813c(c cVar, com.tencent.mm.plugin.textstatus.f.d.b bVar) {
            this.FXW = cVar;
            this.FXX = bVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(216115);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/convert/planet/PlanetItemConvert$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            b bVar2 = this.FXW.FXU;
            com.tencent.mm.plugin.textstatus.f.d.b bVar3 = this.FXX;
            p.g(view, LocaleUtil.ITALIAN);
            bVar2.a(bVar3, view);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/convert/planet/PlanetItemConvert$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(216115);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class d implements View.OnClickListener {
        final /* synthetic */ com.tencent.mm.plugin.textstatus.f.d.b FXX;
        final /* synthetic */ h qhp;

        d(h hVar, com.tencent.mm.plugin.textstatus.f.d.b bVar) {
            this.qhp = hVar;
            this.FXX = bVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(216116);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/convert/planet/PlanetItemConvert$onBindViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            TextStatusSameTopicsActivity.a aVar = TextStatusSameTopicsActivity.GfI;
            View view2 = this.qhp.aus;
            p.g(view2, "holder.itemView");
            Context context = view2.getContext();
            p.g(context, "holder.itemView.context");
            TextStatusSameTopicsActivity.a.bE(context, this.FXX.FZz);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/convert/planet/PlanetItemConvert$onBindViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(216116);
        }
    }
}
