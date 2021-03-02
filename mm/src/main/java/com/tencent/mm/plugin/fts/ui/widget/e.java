package com.tencent.mm.plugin.fts.ui.widget;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.b;
import com.tencent.mm.protocal.protobuf.efk;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.view.recyclerview.h;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J@\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00122\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014H\u0016J \u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\tH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/plugin/fts/ui/widget/KeyboardSugConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/fts/ui/widget/KeyboardSugItem;", "clickListener", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/OnItemClickListener;", "(Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/OnItemClickListener;)V", "getClickListener", "()Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/OnItemClickListener;", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "ui-fts_release"})
public final class e extends com.tencent.mm.view.recyclerview.e<g> {
    final b xfK;

    public e(b bVar) {
        p.h(bVar, "clickListener");
        AppMethodBeat.i(235457);
        this.xfK = bVar;
        AppMethodBeat.o(235457);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.view.recyclerview.a, int, int, boolean, java.util.List] */
    @Override // com.tencent.mm.view.recyclerview.e
    public final /* synthetic */ void a(h hVar, g gVar, int i2, int i3, boolean z, List list) {
        String str;
        AppMethodBeat.i(235456);
        g gVar2 = gVar;
        p.h(hVar, "holder");
        p.h(gVar2, "item");
        View Mn = hVar.Mn(R.id.ie5);
        p.g(Mn, "holder.getView<TextView>(R.id.sug_tv)");
        TextView textView = (TextView) Mn;
        efk efk = gVar2.xfN;
        textView.setText((efk == null || (str = efk.MGp) == null) ? "" : str);
        hVar.aus.setOnClickListener(new a(this, i2, gVar2));
        AppMethodBeat.o(235456);
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final int getLayoutId() {
        return R.layout.anh;
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final void a(RecyclerView recyclerView, h hVar, int i2) {
        AppMethodBeat.i(235455);
        p.h(recyclerView, "recyclerView");
        p.h(hVar, "holder");
        AppMethodBeat.o(235455);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a implements View.OnClickListener {
        final /* synthetic */ int gUj;
        final /* synthetic */ e xfL;
        final /* synthetic */ g xfM;

        a(e eVar, int i2, g gVar) {
            this.xfL = eVar;
            this.gUj = i2;
            this.xfM = gVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(235454);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fts/ui/widget/KeyboardSugConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.xfL.xfK.Q(view, this.gUj);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/widget/KeyboardSugConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(235454);
        }
    }
}
