package com.tencent.mm.plugin.profile.ui.tab.a;

import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.protocal.protobuf.qa;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.tools.o;
import com.tencent.mm.ui.widget.happybubble.LabelsView;
import java.util.List;
import kotlin.g.a.q;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \"2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004\"#$%B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\b\u0010\u001a\u001a\u00020\u0013H\u0016J\u0010\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0018\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0018\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0013H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rRa\u0010\u000e\u001aI\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\t\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006&"}, hxF = {"Lcom/tencent/mm/plugin/profile/ui/tab/menu/BizProfileMenuAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "menuList", "", "Lcom/tencent/mm/protocal/protobuf/BizServiceMenuButton;", "(Ljava/util/List;)V", "onFooterViewClick", "Lkotlin/Function0;", "", "getOnFooterViewClick", "()Lkotlin/jvm/functions/Function0;", "setOnFooterViewClick", "(Lkotlin/jvm/functions/Function0;)V", "onMenuItemClick", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "menuButton", "", "position", FirebaseAnalytics.b.INDEX, "getOnMenuItemClick", "()Lkotlin/jvm/functions/Function3;", "setOnMenuItemClick", "(Lkotlin/jvm/functions/Function3;)V", "getItemCount", "getItemViewType", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Companion", "MenuFooterViewHolder", "MenuMultiViewHolder", "MenuSingleViewHolder", "app_release"})
public final class a extends RecyclerView.a<RecyclerView.v> {
    public static final C1595a BnI = new C1595a((byte) 0);
    public q<? super qa, ? super Integer, ? super Integer, x> BnG;
    public kotlin.g.a.a<x> BnH;
    private final List<qa> dij;

    static {
        AppMethodBeat.i(230867);
        AppMethodBeat.o(230867);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\b0\bH\n¢\u0006\u0002\b\t"}, hxF = {"<anonymous>", "", "label", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", FirebaseAnalytics.b.INDEX, "", "data", "Lcom/tencent/mm/protocal/protobuf/BizServiceMenuButton;", "getLabelText"})
    static final class g<T> implements LabelsView.a<qa> {
        final /* synthetic */ a BnK;
        final /* synthetic */ int gUj;
        final /* synthetic */ RecyclerView.v wrN;

        g(a aVar, int i2, RecyclerView.v vVar) {
            this.BnK = aVar;
            this.gUj = i2;
            this.wrN = vVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.widget.TextView, int, java.lang.Object] */
        @Override // com.tencent.mm.ui.widget.happybubble.LabelsView.a
        public final /* synthetic */ CharSequence a(TextView textView, final int i2, qa qaVar) {
            AppMethodBeat.i(230860);
            final qa qaVar2 = qaVar;
            o.hp(textView);
            textView.setOnClickListener(new View.OnClickListener(this) {
                /* class com.tencent.mm.plugin.profile.ui.tab.a.a.g.AnonymousClass1 */
                final /* synthetic */ g BnL;

                {
                    this.BnL = r1;
                }

                public final void onClick(View view) {
                    AppMethodBeat.i(230859);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/tab/menu/BizProfileMenuAdapter$onBindViewHolder$3$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    q<? super qa, ? super Integer, ? super Integer, x> qVar = this.BnL.BnK.BnG;
                    if (qVar != null) {
                        qa qaVar = qaVar2;
                        p.g(qaVar, "data");
                        qVar.d(qaVar, Integer.valueOf(this.BnL.gUj), Integer.valueOf(i2));
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/tab/menu/BizProfileMenuAdapter$onBindViewHolder$3$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(230859);
                }
            });
            SpannableString c2 = com.tencent.mm.pluginsdk.ui.span.l.c(((c) this.wrN).titleView.getContext(), qaVar2 != null ? qaVar2.name : null);
            if (c2 != null) {
                SpannableString spannableString = c2;
                AppMethodBeat.o(230860);
                return spannableString;
            }
            AppMethodBeat.o(230860);
            return r0;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.List<? extends com.tencent.mm.protocal.protobuf.qa> */
    /* JADX WARN: Multi-variable type inference failed */
    public a(List<? extends qa> list) {
        p.h(list, "menuList");
        AppMethodBeat.i(230866);
        this.dij = list;
        AppMethodBeat.o(230866);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/profile/ui/tab/menu/BizProfileMenuAdapter$Companion;", "", "()V", "MENU_TYPE_FOOTER", "", "MENU_TYPE_MULTI", "MENU_TYPE_SINGLE", "app_release"})
    /* renamed from: com.tencent.mm.plugin.profile.ui.tab.a.a$a  reason: collision with other inner class name */
    public static final class C1595a {
        private C1595a() {
        }

        public /* synthetic */ C1595a(byte b2) {
            this();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final RecyclerView.v a(ViewGroup viewGroup, int i2) {
        AppMethodBeat.i(230862);
        p.h(viewGroup, "parent");
        switch (i2) {
            case 1:
                View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.xk, viewGroup, false);
                p.g(inflate, "view");
                d dVar = new d(inflate);
                AppMethodBeat.o(230862);
                return dVar;
            case 2:
                View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.xj, viewGroup, false);
                p.g(inflate2, "view");
                c cVar = new c(inflate2);
                AppMethodBeat.o(230862);
                return cVar;
            default:
                View inflate3 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.wi, viewGroup, false);
                p.g(inflate3, "view");
                b bVar = new b(inflate3);
                AppMethodBeat.o(230862);
                return bVar;
        }
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemCount() {
        AppMethodBeat.i(230863);
        int size = this.dij.size() + 1;
        AppMethodBeat.o(230863);
        return size;
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final void a(RecyclerView.v vVar, int i2) {
        AppMethodBeat.i(230864);
        p.h(vVar, "holder");
        if (vVar instanceof d) {
            o.hp(vVar.aus);
            SpannableString c2 = com.tencent.mm.pluginsdk.ui.span.l.c(((d) vVar).titleView.getContext(), this.dij.get(i2).name);
            p.g(c2, "MMSpanManager.spanForSmi… menuList[position].name)");
            ((d) vVar).titleView.setText(c2);
            vVar.aus.setOnClickListener(new e(this, i2));
            AppMethodBeat.o(230864);
        } else if (vVar instanceof c) {
            SpannableString c3 = com.tencent.mm.pluginsdk.ui.span.l.c(((c) vVar).titleView.getContext(), this.dij.get(i2).name);
            p.g(c3, "MMSpanManager.spanForSmi… menuList[position].name)");
            ((c) vVar).titleView.setText(c3);
            ((c) vVar).BnJ.setOnLabelClickListener(new f(this, i2));
            ((c) vVar).BnJ.a(this.dij.get(i2).KWT, new g(this, i2, vVar));
            AppMethodBeat.o(230864);
        } else {
            if (vVar instanceof b) {
                o.hp(vVar.aus);
                vVar.aus.setOnClickListener(new h(this));
            }
            AppMethodBeat.o(230864);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class e implements View.OnClickListener {
        final /* synthetic */ a BnK;
        final /* synthetic */ int gUj;

        e(a aVar, int i2) {
            this.BnK = aVar;
            this.gUj = i2;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(230857);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/tab/menu/BizProfileMenuAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            q<? super qa, ? super Integer, ? super Integer, x> qVar = this.BnK.BnG;
            if (qVar != null) {
                qVar.d(this.BnK.dij.get(this.gUj), Integer.valueOf(this.gUj), 0);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/tab/menu/BizProfileMenuAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(230857);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u00062\u0006\u0010\u0007\u001a\u00020\bH\n¢\u0006\u0002\b\t"}, hxF = {"<anonymous>", "", "label", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "data", "", FirebaseAnalytics.b.INDEX, "", "onLabelClick"})
    static final class f implements LabelsView.b {
        final /* synthetic */ a BnK;
        final /* synthetic */ int gUj;

        f(a aVar, int i2) {
            this.BnK = aVar;
            this.gUj = i2;
        }

        @Override // com.tencent.mm.ui.widget.happybubble.LabelsView.b
        public final void j(Object obj, int i2) {
            AppMethodBeat.i(230858);
            q<? super qa, ? super Integer, ? super Integer, x> qVar = this.BnK.BnG;
            if (qVar == null) {
                AppMethodBeat.o(230858);
            } else if (obj == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizServiceMenuButton");
                AppMethodBeat.o(230858);
                throw tVar;
            } else {
                qVar.d((qa) obj, Integer.valueOf(this.gUj), Integer.valueOf(i2));
                AppMethodBeat.o(230858);
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class h implements View.OnClickListener {
        final /* synthetic */ a BnK;

        h(a aVar) {
            this.BnK = aVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(230861);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/tab/menu/BizProfileMenuAdapter$onBindViewHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            kotlin.g.a.a<x> aVar = this.BnK.BnH;
            if (aVar != null) {
                aVar.invoke();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/tab/menu/BizProfileMenuAdapter$onBindViewHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(230861);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemViewType(int i2) {
        AppMethodBeat.i(230865);
        if (i2 >= this.dij.size()) {
            AppMethodBeat.o(230865);
            return 3;
        } else if (this.dij.get(i2).type == 0) {
            AppMethodBeat.o(230865);
            return 2;
        } else {
            AppMethodBeat.o(230865);
            return 1;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/profile/ui/tab/menu/BizProfileMenuAdapter$MenuSingleViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "titleView", "Landroid/widget/TextView;", "getTitleView", "()Landroid/widget/TextView;", "app_release"})
    public static final class d extends RecyclerView.v {
        final TextView titleView;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(View view) {
            super(view);
            p.h(view, "itemView");
            AppMethodBeat.i(230856);
            View findViewById = view.findViewById(R.id.a6a);
            p.g(findViewById, "itemView.findViewById(R.id.biz_profile_menu_title)");
            this.titleView = (TextView) findViewById;
            AppMethodBeat.o(230856);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/profile/ui/tab/menu/BizProfileMenuAdapter$MenuMultiViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "subMenuLabel", "Lcom/tencent/mm/ui/widget/happybubble/LabelsView;", "getSubMenuLabel", "()Lcom/tencent/mm/ui/widget/happybubble/LabelsView;", "titleView", "Landroid/widget/TextView;", "getTitleView", "()Landroid/widget/TextView;", "app_release"})
    public static final class c extends RecyclerView.v {
        final LabelsView BnJ;
        final TextView titleView;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(View view) {
            super(view);
            p.h(view, "itemView");
            AppMethodBeat.i(230855);
            View findViewById = view.findViewById(R.id.a6a);
            p.g(findViewById, "itemView.findViewById(R.id.biz_profile_menu_title)");
            this.titleView = (TextView) findViewById;
            View findViewById2 = view.findViewById(R.id.a6e);
            p.g(findViewById2, "itemView.findViewById(R.…ile_sub_menu_title_label)");
            this.BnJ = (LabelsView) findViewById2;
            AppMethodBeat.o(230855);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/profile/ui/tab/menu/BizProfileMenuAdapter$MenuFooterViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "app_release"})
    public static final class b extends RecyclerView.v {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(View view) {
            super(view);
            p.h(view, "itemView");
            AppMethodBeat.i(230854);
            AppMethodBeat.o(230854);
        }
    }
}
