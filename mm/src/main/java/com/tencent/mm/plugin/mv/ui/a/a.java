package com.tencent.mm.plugin.mv.ui.a;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.mv.a.d;
import com.tencent.mm.plugin.mv.ui.uic.MusicMvMakerEditUIC;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000  2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001 B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0010\u001a\u00020\rH\u0016J@\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00192\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bH\u0016J \u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\rH\u0016R\u000e\u0010\b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006!"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/convert/MusicMVVideoItemConverter;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData;", "sizeResolver", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerEditUIC$IMVItemSizeResolver;", "actionCallback", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerEditUIC$IMVEditItemAction;", "(Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerEditUIC$IMVItemSizeResolver;Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerEditUIC$IMVEditItemAction;)V", "TAG", "", "getActionCallback", "()Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerEditUIC$IMVEditItemAction;", "itemWidth", "", "getSizeResolver", "()Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerEditUIC$IMVItemSizeResolver;", "getLayoutId", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "Companion", "plugin-mv_release"})
public final class a extends e<d> {
    public static final c JRL = new c((byte) 0);
    private final MusicMvMakerEditUIC.c ArU;
    final MusicMvMakerEditUIC.b ArV;
    private final String TAG = "MicroMsg.MusicMVVideoItemConverter";
    private final int qmd = this.ArU.getItemWidth();

    static {
        AppMethodBeat.i(258209);
        AppMethodBeat.o(258209);
    }

    public a(MusicMvMakerEditUIC.c cVar, MusicMvMakerEditUIC.b bVar) {
        p.h(cVar, "sizeResolver");
        p.h(bVar, "actionCallback");
        AppMethodBeat.i(257000);
        this.ArU = cVar;
        this.ArV = bVar;
        AppMethodBeat.o(257000);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.view.recyclerview.a, int, int, boolean, java.util.List] */
    @Override // com.tencent.mm.view.recyclerview.e
    public final /* synthetic */ void a(h hVar, d dVar, int i2, int i3, boolean z, List list) {
        AppMethodBeat.i(256998);
        d dVar2 = dVar;
        p.h(hVar, "holder");
        p.h(dVar2, "item");
        Log.i(this.TAG, "onBindViewHolder: ".concat(String.valueOf(i2)));
        if (list != null) {
            d.b bVar = d.Aps;
            if (list.contains(d.Apr)) {
                c.a(hVar, dVar2);
                AppMethodBeat.o(256998);
                return;
            }
        }
        c.a(hVar, dVar2);
        View Mn = hVar.Mn(R.id.frj);
        p.g(Mn, "holder.getView(R.id.mvItemThumb)");
        ImageView imageView = (ImageView) Mn;
        View Mn2 = hVar.Mn(R.id.frf);
        p.g(Mn2, "holder.getView(R.id.mvItemLyricContent)");
        TextView textView = (TextView) Mn2;
        if (dVar2.type != 0) {
            hVar.Mn(R.id.fr4).setOnClickListener(new View$OnClickListenerC1546a(this, i2, dVar2, hVar));
            hVar.Mn(R.id.fr3).setOnClickListener(new b(this, i2, dVar2, hVar));
        }
        d.g gVar = dVar2.Apo;
        if (gVar != null) {
            d.g.a.a(gVar, imageView);
        } else {
            imageView.setImageDrawable(null);
        }
        textView.setText(d.a(dVar2));
        if (dVar2.type == 0) {
            View Mn3 = hVar.Mn(R.id.fr6);
            p.g(Mn3, "holder.getView<View>(R.id.mvItemChoose)");
            Mn3.setVisibility(0);
            View Mn4 = hVar.Mn(R.id.fr7);
            p.g(Mn4, "holder.getView<TextView>….id.mvItemChooseDuration)");
            ((TextView) Mn4).setText(hVar.getContext().getString(R.string.f8w, Integer.valueOf(e.Tl(dVar2.getDurationMs()))));
            AppMethodBeat.o(256998);
            return;
        }
        View Mn5 = hVar.Mn(R.id.fr6);
        p.g(Mn5, "holder.getView<View>(R.id.mvItemChoose)");
        Mn5.setVisibility(8);
        AppMethodBeat.o(256998);
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final int getLayoutId() {
        return R.layout.bek;
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final void a(RecyclerView recyclerView, h hVar, int i2) {
        AppMethodBeat.i(256997);
        p.h(recyclerView, "recyclerView");
        p.h(hVar, "holder");
        LinearLayout linearLayout = (LinearLayout) hVar.Mn(R.id.fri);
        Log.d(this.TAG, "onCreateViewHolder, itemWidth:" + this.qmd);
        p.g(linearLayout, "root");
        linearLayout.getLayoutParams().width = this.qmd;
        linearLayout.getLayoutParams().height = -1;
        AppMethodBeat.o(256997);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.mv.ui.a.a$a  reason: collision with other inner class name */
    static final class View$OnClickListenerC1546a implements View.OnClickListener {
        final /* synthetic */ a ArW;
        final /* synthetic */ d ArX;
        final /* synthetic */ int gUj;
        final /* synthetic */ h qhp;

        View$OnClickListenerC1546a(a aVar, int i2, d dVar, h hVar) {
            this.ArW = aVar;
            this.gUj = i2;
            this.ArX = dVar;
            this.qhp = hVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(256995);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/convert/MusicMVVideoItemConverter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            MusicMvMakerEditUIC.b bVar2 = this.ArW.ArV;
            int i2 = this.gUj;
            d dVar = this.ArX;
            View view2 = this.qhp.aus;
            p.g(view2, "holder.itemView");
            bVar2.a(i2, dVar, view2);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/convert/MusicMVVideoItemConverter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(256995);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b implements View.OnClickListener {
        final /* synthetic */ a ArW;
        final /* synthetic */ d ArX;
        final /* synthetic */ int gUj;
        final /* synthetic */ h qhp;

        b(a aVar, int i2, d dVar, h hVar) {
            this.ArW = aVar;
            this.gUj = i2;
            this.ArX = dVar;
            this.qhp = hVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(256996);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/convert/MusicMVVideoItemConverter$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            MusicMvMakerEditUIC.b bVar2 = this.ArW.ArV;
            int i2 = this.gUj;
            d dVar = this.ArX;
            View view2 = this.qhp.aus;
            p.g(view2, "holder.itemView");
            bVar2.b(i2, dVar, view2);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/convert/MusicMVVideoItemConverter$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(256996);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/convert/MusicMVVideoItemConverter$Companion;", "", "()V", "handleSelection", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData;", "plugin-mv_release"})
    public static final class c {
        private c() {
        }

        public /* synthetic */ c(byte b2) {
            this();
        }

        public static void a(h hVar, d dVar) {
            AppMethodBeat.i(258208);
            p.h(hVar, "holder");
            p.h(dVar, "item");
            View view = hVar.aus;
            p.g(view, "holder.itemView");
            view.setSelected(dVar.uOQ);
            View Mn = hVar.Mn(R.id.fr5);
            if (dVar.uOQ) {
                if (dVar.type != 0) {
                    View findViewById = hVar.aus.findViewById(R.id.frh);
                    p.g(findViewById, "holder.itemView.findView…Id<View>(R.id.mvItemMask)");
                    findViewById.setVisibility(8);
                    p.g(Mn, "actionRoot");
                    Mn.setVisibility(0);
                } else {
                    View findViewById2 = hVar.aus.findViewById(R.id.frh);
                    p.g(findViewById2, "holder.itemView.findView…Id<View>(R.id.mvItemMask)");
                    findViewById2.setVisibility(0);
                    p.g(Mn, "actionRoot");
                    Mn.setVisibility(8);
                }
                View Mn2 = hVar.Mn(R.id.frg);
                p.g(Mn2, "holder.getView<View>(R.id.mvItemLyricRoot)");
                Mn2.setVisibility(0);
                AppMethodBeat.o(258208);
                return;
            }
            ((ProgressBar) hVar.aus.findViewById(R.id.g8s)).setProgress(0);
            View findViewById3 = hVar.aus.findViewById(R.id.frh);
            p.g(findViewById3, "holder.itemView.findView…Id<View>(R.id.mvItemMask)");
            findViewById3.setVisibility(0);
            p.g(Mn, "actionRoot");
            Mn.setVisibility(8);
            View Mn3 = hVar.Mn(R.id.frg);
            p.g(Mn3, "holder.getView<View>(R.id.mvItemLyricRoot)");
            Mn3.setVisibility(8);
            AppMethodBeat.o(258208);
        }
    }
}
