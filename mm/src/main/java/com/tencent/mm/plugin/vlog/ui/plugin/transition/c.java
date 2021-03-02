package com.tencent.mm.plugin.vlog.ui.plugin.transition;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.vlog.model.local.a;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u001e2\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0005\u001d\u001e\u001f !B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016J\u001c\u0010\u000f\u001a\u00020\u00102\n\u0010\u0011\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\fH\u0016J*\u0010\u000f\u001a\u00020\u00102\n\u0010\u0011\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0016J\u001c\u0010\u0015\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\fH\u0016J\u0014\u0010\u0019\u001a\u00020\u00102\n\u0010\u001a\u001a\u00060\u0002R\u00020\u0000H\u0016J\u000e\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\bR\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\""}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter$BaseViewHolder;", "transitionList", "", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionItem;", "(Ljava/util/List;)V", "onItemClickListener", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter$OnItemClickListener;", "getTransitionList", "()Ljava/util/List;", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "viewHolder", "payloads", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onViewRecycled", "holder", "setOnItemClickListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "BaseViewHolder", "Companion", "NoneViewHolder", "OnItemClickListener", "TransitionViewHolder", "plugin-vlog_release"})
public final class c extends RecyclerView.a<a> {
    public static final b GNS = new b((byte) 0);
    d GNQ;
    private final List<d> GNR;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter$OnItemClickListener;", "", "onItemClick", "", "transitionInfo", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionItem;", "position", "", "plugin-vlog_release"})
    public interface d {
        void a(d dVar, int i2);
    }

    static {
        AppMethodBeat.i(192011);
        AppMethodBeat.o(192011);
    }

    public c(List<d> list) {
        p.h(list, "transitionList");
        AppMethodBeat.i(192010);
        this.GNR = list;
        AppMethodBeat.o(192010);
    }

    /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ a a(ViewGroup viewGroup, int i2) {
        e eVar;
        AppMethodBeat.i(192006);
        p.h(viewGroup, "parent");
        if (i2 == 0) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.a0s, viewGroup, false);
            p.g(inflate, "LayoutInflater.from(pare…none_item, parent, false)");
            eVar = new C1879c(this, inflate);
        } else {
            View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.a0r, viewGroup, false);
            p.g(inflate2, "LayoutInflater.from(pare…tion_item, parent, false)");
            eVar = new e(this, inflate2);
        }
        RecyclerView.v vVar = eVar;
        AppMethodBeat.o(192006);
        return vVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v] */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ void a(a aVar) {
        AppMethodBeat.i(192009);
        a aVar2 = aVar;
        p.h(aVar2, "holder");
        aVar2.avR();
        AppMethodBeat.o(192009);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ void a(a aVar, int i2) {
        AppMethodBeat.i(192007);
        a aVar2 = aVar;
        p.h(aVar2, "viewHolder");
        aVar2.b(this.GNR.get(i2), i2);
        AppMethodBeat.o(192007);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int, java.util.List] */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ void a(a aVar, int i2, List list) {
        AppMethodBeat.i(192008);
        a aVar2 = aVar;
        p.h(aVar2, "viewHolder");
        p.h(list, "payloads");
        if (list.size() > 0) {
            d dVar = this.GNR.get(i2);
            p.h(dVar, "item");
            View view = aVar2.aus;
            p.g(view, "itemView");
            view.setSelected(dVar.uOQ);
            AppMethodBeat.o(192008);
            return;
        }
        aVar2.b(this.GNR.get(i2), i2);
        AppMethodBeat.o(192008);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\b¦\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J&\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fJ\b\u0010\u000e\u001a\u00020\u0006H&¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter$BaseViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter;Landroid/view/View;)V", "onBind", "", "item", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionItem;", "position", "", "payloads", "", "", "onUnbind", "plugin-vlog_release"})
    public abstract class a extends RecyclerView.v {
        final /* synthetic */ c GNT;

        public abstract void avR();

        public abstract void b(d dVar, int i2);

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(c cVar, View view) {
            super(view);
            p.h(view, "itemView");
            this.GNT = cVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000bH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter$TransitionViewHolder;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter;Landroid/view/View;)V", "iconImg", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "transNameText", "Landroid/widget/TextView;", "onBind", "", "item", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionItem;", "position", "", "onUnbind", "plugin-vlog_release"})
    public final class e extends a {
        final /* synthetic */ c GNT;
        private final WeImageView GNW;
        private final TextView GNX;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(c cVar, View view) {
            super(cVar, view);
            p.h(view, "itemView");
            this.GNT = cVar;
            AppMethodBeat.i(192004);
            View findViewById = view.findViewById(R.id.dk0);
            p.g(findViewById, "itemView.findViewById(R.id.gif_iv)");
            this.GNW = (WeImageView) findViewById;
            View findViewById2 = view.findViewById(R.id.iv3);
            p.g(findViewById2, "itemView.findViewById(R.id.transition_name_text)");
            this.GNX = (TextView) findViewById2;
            AppMethodBeat.o(192004);
        }

        @Override // com.tencent.mm.plugin.vlog.ui.plugin.transition.c.a
        public final void b(d dVar, int i2) {
            String str;
            int i3;
            String str2;
            AppMethodBeat.i(192002);
            p.h(dVar, "item");
            CharSequence text = this.GNX.getText();
            a.C1849a aVar = dVar.GNZ;
            if (aVar != null) {
                str = aVar.name;
            } else {
                str = null;
            }
            if (!p.j(text, str)) {
                WeImageView weImageView = this.GNW;
                Context context = this.GNW.getContext();
                a.C1849a aVar2 = dVar.GNZ;
                if (aVar2 != null) {
                    i3 = aVar2.GAE;
                } else {
                    i3 = -1;
                }
                weImageView.setImageDrawable(com.tencent.mm.cb.a.l(context, i3));
                TextView textView = this.GNX;
                a.C1849a aVar3 = dVar.GNZ;
                if (aVar3 != null) {
                    str2 = aVar3.name;
                } else {
                    str2 = null;
                }
                textView.setText(str2);
            }
            View view = this.aus;
            p.g(view, "itemView");
            view.setSelected(dVar.uOQ);
            this.aus.setOnClickListener(new a(this, dVar, i2));
            AppMethodBeat.o(192002);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        static final class a implements View.OnClickListener {
            final /* synthetic */ d GNV;
            final /* synthetic */ e GNY;
            final /* synthetic */ int gUj;

            a(e eVar, d dVar, int i2) {
                this.GNY = eVar;
                this.GNV = dVar;
                this.gUj = i2;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(192001);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter$TransitionViewHolder$onBind$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                d dVar = this.GNY.GNT.GNQ;
                if (dVar != null) {
                    dVar.a(this.GNV, this.gUj);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter$TransitionViewHolder$onBind$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(192001);
            }
        }

        @Override // com.tencent.mm.plugin.vlog.ui.plugin.transition.c.a
        public final void avR() {
            AppMethodBeat.i(192003);
            View view = this.aus;
            p.g(view, "itemView");
            view.setSelected(false);
            AppMethodBeat.o(192003);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u0007H\u0016¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter$NoneViewHolder;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter;Landroid/view/View;)V", "onBind", "", "item", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionItem;", "position", "", "onUnbind", "plugin-vlog_release"})
    /* renamed from: com.tencent.mm.plugin.vlog.ui.plugin.transition.c$c  reason: collision with other inner class name */
    public final class C1879c extends a {
        final /* synthetic */ c GNT;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C1879c(c cVar, View view) {
            super(cVar, view);
            p.h(view, "itemView");
            this.GNT = cVar;
            AppMethodBeat.i(192000);
            AppMethodBeat.o(192000);
        }

        @Override // com.tencent.mm.plugin.vlog.ui.plugin.transition.c.a
        public final void b(d dVar, int i2) {
            AppMethodBeat.i(191999);
            p.h(dVar, "item");
            View view = this.aus;
            p.g(view, "itemView");
            view.setSelected(dVar.uOQ);
            this.aus.setOnClickListener(new a(this, dVar, i2));
            AppMethodBeat.o(191999);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        /* renamed from: com.tencent.mm.plugin.vlog.ui.plugin.transition.c$c$a */
        static final class a implements View.OnClickListener {
            final /* synthetic */ C1879c GNU;
            final /* synthetic */ d GNV;
            final /* synthetic */ int gUj;

            a(C1879c cVar, d dVar, int i2) {
                this.GNU = cVar;
                this.GNV = dVar;
                this.gUj = i2;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(191998);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter$NoneViewHolder$onBind$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                d dVar = this.GNU.GNT.GNQ;
                if (dVar != null) {
                    dVar.a(this.GNV, this.gUj);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter$NoneViewHolder$onBind$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(191998);
            }
        }

        @Override // com.tencent.mm.plugin.vlog.ui.plugin.transition.c.a
        public final void avR() {
        }
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemCount() {
        AppMethodBeat.i(192005);
        int size = this.GNR.size();
        AppMethodBeat.o(192005);
        return size;
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemViewType(int i2) {
        return i2 == 0 ? 0 : 1;
    }
}
