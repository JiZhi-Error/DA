package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.api.g;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.sortview.BaseSortView;
import com.tencent.mm.ui.base.sortview.c;
import com.tencent.mm.ui.base.sortview.d;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u001aB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\u001c\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016R\u000e\u0010\b\u001a\u00020\tXD¢\u0006\u0002\n\u0000¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/FinderContactSortView;", "Lcom/tencent/mm/ui/base/sortview/BaseSortView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TAG", "", "getItemViewCreator", "Lcom/tencent/mm/ui/base/sortview/SortAdapter$IViewCreator;", "getListView", "Landroid/widget/ListView;", "getNoResultView", "Landroid/view/View;", "getScrollBar", "Lcom/tencent/mm/ui/base/VerticalScrollBar;", "inflate", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "", "isMatch", "", "word", "entity", "Lcom/tencent/mm/ui/base/sortview/SortEntity;", "ViewHolder", "plugin-finder_release"})
public final class FinderContactSortView extends BaseSortView {
    private final String TAG = "Finder.FinderContactSortView";

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000e¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/FinderContactSortView$ViewHolder;", "", "()V", "avatarIv", "Landroid/widget/ImageView;", "getAvatarIv", "()Landroid/widget/ImageView;", "setAvatarIv", "(Landroid/widget/ImageView;)V", "catalogTv", "Landroid/widget/TextView;", "getCatalogTv", "()Landroid/widget/TextView;", "setCatalogTv", "(Landroid/widget/TextView;)V", "content", "Landroid/view/View;", "getContent", "()Landroid/view/View;", "setContent", "(Landroid/view/View;)V", "nickTv", "getNickTv", "setNickTv", "plugin-finder_release"})
    public static final class a {
        ImageView gyr;
        TextView kcY;
        TextView kib;
        View pxo;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderContactSortView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        p.h(attributeSet, "attrs");
        AppMethodBeat.i(168305);
        setOnItemClickListener(new c(this));
        AppMethodBeat.o(168305);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012\u0012\u0002\b\u0003 \u0004*\b\u0012\u0002\b\u0003\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\n¢\u0006\u0002\b\u000b"}, hxF = {"<anonymous>", "", "adapterView", "Landroid/widget/AdapterView;", "kotlin.jvm.PlatformType", "view", "Landroid/view/View;", "position", "", "id", "", "onItemClick"})
    static final class c implements AdapterView.OnItemClickListener {
        final /* synthetic */ FinderContactSortView wlq;

        c(FinderContactSortView finderContactSortView) {
            this.wlq = finderContactSortView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            AppMethodBeat.i(168298);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(adapterView);
            bVar.bm(view);
            bVar.pH(i2);
            bVar.zo(j2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderContactSortView$init$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
            if (j2 >= 0 && j2 < ((long) this.wlq.getDatas().size())) {
                Intent intent = new Intent();
                d dVar = this.wlq.getDatas().get((int) j2);
                p.g(dVar, "datas[id.toInt()]");
                Object data = dVar.getData();
                if (data == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.api.LocalFinderContact");
                    AppMethodBeat.o(168298);
                    throw tVar;
                }
                intent.putExtra("finder_username", ((g) data).getUsername());
                FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
                Context context = this.wlq.getContext();
                p.g(context, "context");
                FinderReporterUIC.a.a(context, intent, 0, 0, false, 124);
                com.tencent.mm.plugin.finder.utils.a aVar2 = com.tencent.mm.plugin.finder.utils.a.vUU;
                Context context2 = this.wlq.getContext();
                p.g(context2, "context");
                com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI(context2, intent);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderContactSortView$init$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(168298);
        }
    }

    @Override // com.tencent.mm.ui.base.sortview.BaseSortView
    public final View inflate() {
        AppMethodBeat.i(168299);
        View inflate = View.inflate(getContext(), R.layout.a_6, this);
        p.g(inflate, "View.inflate(context, R.…_contact_sort_view, this)");
        AppMethodBeat.o(168299);
        return inflate;
    }

    @Override // com.tencent.mm.ui.base.sortview.BaseSortView
    public final VerticalScrollBar getScrollBar() {
        AppMethodBeat.i(168300);
        View findViewById = findViewById(R.id.i2i);
        p.g(findViewById, "this.findViewById(R.id.sort_bar)");
        VerticalScrollBar verticalScrollBar = (VerticalScrollBar) findViewById;
        AppMethodBeat.o(168300);
        return verticalScrollBar;
    }

    @Override // com.tencent.mm.ui.base.sortview.BaseSortView
    public final ListView getListView() {
        AppMethodBeat.i(168301);
        View findViewById = findViewById(R.id.ecx);
        p.g(findViewById, "this.findViewById(R.id.list_view)");
        ListView listView = (ListView) findViewById;
        AppMethodBeat.o(168301);
        return listView;
    }

    @Override // com.tencent.mm.ui.base.sortview.BaseSortView
    public final View getNoResultView() {
        AppMethodBeat.i(168302);
        View findViewById = findViewById(R.id.fzz);
        p.g(findViewById, "this.findViewById(R.id.no_result)");
        AppMethodBeat.o(168302);
        return findViewById;
    }

    @Override // com.tencent.mm.ui.base.sortview.BaseSortView
    public final boolean a(String str, d dVar) {
        String str2;
        AppMethodBeat.i(168303);
        if (str != null) {
            if (dVar != null) {
                str2 = dVar.gLX();
            } else {
                str2 = null;
            }
            String nullAsNil = Util.nullAsNil(str2);
            p.g(nullAsNil, "Util.nullAsNil(entity?.alpha)");
            boolean J = n.J(str, nullAsNil, false);
            AppMethodBeat.o(168303);
            return J;
        }
        AppMethodBeat.o(168303);
        return false;
    }

    @Override // com.tencent.mm.ui.base.sortview.BaseSortView
    public final c.a getItemViewCreator() {
        AppMethodBeat.i(168304);
        b bVar = new b(this);
        AppMethodBeat.o(168304);
        return bVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u000e\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00040\u00042\u000e\u0010\u0005\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u000e\u0010\u0006\u001a\n \u0002*\u0004\u0018\u00010\u00070\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\n¢\u0006\u0002\b\u000e"}, hxF = {"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "item", "Lcom/tencent/mm/ui/base/sortview/SortEntity;", "convertView", "parent", "Landroid/view/ViewGroup;", "position", "", "count", "isFirstOfPage", "", "isLastOfPage", "createView"})
    static final class b implements c.a {
        final /* synthetic */ FinderContactSortView wlq;

        b(FinderContactSortView finderContactSortView) {
            this.wlq = finderContactSortView;
        }

        @Override // com.tencent.mm.ui.base.sortview.c.a
        public final View a(d dVar, View view, int i2, boolean z, boolean z2) {
            a aVar;
            AppMethodBeat.i(168297);
            if (view == null) {
                view = View.inflate(this.wlq.getContext(), R.layout.a_4, null);
                aVar = new a();
                aVar.gyr = (ImageView) view.findViewById(R.id.x1);
                aVar.kib = (TextView) view.findViewById(R.id.fzg);
                aVar.kcY = (TextView) view.findViewById(R.id.apx);
                aVar.pxo = view.findViewById(R.id.e23);
                p.g(view, "itemView");
                view.setTag(aVar);
            } else {
                p.g(view, "convertView");
                Object tag = view.getTag();
                if (tag == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.FinderContactSortView.ViewHolder");
                    AppMethodBeat.o(168297);
                    throw tVar;
                }
                aVar = (a) tag;
            }
            p.g(dVar, "item");
            Object data = dVar.getData();
            if (data == null) {
                t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.api.LocalFinderContact");
                AppMethodBeat.o(168297);
                throw tVar2;
            }
            g gVar = (g) data;
            m mVar = m.uJa;
            com.tencent.mm.loader.d<o> dka = m.dka();
            com.tencent.mm.plugin.finder.loader.a aVar2 = new com.tencent.mm.plugin.finder.loader.a(gVar.cXH());
            ImageView imageView = aVar.gyr;
            if (imageView == null) {
                p.hyc();
            }
            m mVar2 = m.uJa;
            dka.a(aVar2, imageView, m.a(m.a.AVATAR));
            TextView textView = aVar.kib;
            if (textView != null) {
                textView.setText(com.tencent.mm.pluginsdk.ui.span.l.c(this.wlq.getContext(), gVar.getNickname()));
            }
            if (!this.wlq.gLU() || !z) {
                TextView textView2 = aVar.kcY;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                }
            } else {
                TextView textView3 = aVar.kcY;
                if (textView3 != null) {
                    textView3.setText(dVar.gLX());
                }
                TextView textView4 = aVar.kcY;
                if (textView4 != null) {
                    textView4.setVisibility(0);
                }
            }
            if (this.wlq.getMode() != 0 || !z2) {
                View view2 = aVar.pxo;
                if (view2 != null) {
                    view2.setBackgroundResource(R.drawable.b9w);
                }
            } else {
                View view3 = aVar.pxo;
                if (view3 != null) {
                    view3.setBackgroundResource(R.drawable.qd);
                }
            }
            AppMethodBeat.o(168297);
            return view;
        }
    }
}
