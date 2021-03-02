package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 #2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0007!\"#$%&'B\u0015\u0012\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004¢\u0006\u0002\u0010\u0006J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017H\u0016J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0017H\u0016J\u0018\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0017H\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0006R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006("}, hxF = {"Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ViewHolder;", "items", "", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$Item;", "(Ljava/util/List;)V", "itemCheckedListener", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ItemCheckedListener;", "getItemCheckedListener", "()Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ItemCheckedListener;", "setItemCheckedListener", "(Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ItemCheckedListener;)V", "getItems", "()Ljava/util/List;", "setItems", "onListItemLongClickListener", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$OnListItemLongClickListener;", "getOnListItemLongClickListener", "()Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$OnListItemLongClickListener;", "setOnListItemLongClickListener", "(Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$OnListItemLongClickListener;)V", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Item", "ItemCheckedListener", "ItemType", "OnListItemLongClickListener", "ScopeInfoViewHolder", "UserInfoViewHolder", "ViewHolder", "luggage-wechat-full-sdk_release"})
public final class i extends RecyclerView.a<g> {
    public static final c oqY = new c((byte) 0);
    public List<a> iHf;
    public b nbX;
    public d oqX;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ItemCheckedListener;", "", "onChecked", "", "item", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$Item;", "luggage-wechat-full-sdk_release"})
    public interface b {
        void a(a aVar);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$OnListItemLongClickListener;", "", "onLongClick", "", "v", "Landroid/view/View;", "item", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$Item;", FirebaseAnalytics.b.INDEX, "", "luggage-wechat-full-sdk_release"})
    public interface d {
        void a(View view, a aVar, int i2);
    }

    static {
        AppMethodBeat.i(230261);
        AppMethodBeat.o(230261);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005H\n¢\u0006\u0002\b\u0006¨\u0006\u0007"}, hxF = {"<anonymous>", "", "changed", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "invoke", "com/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$onBindViewHolder$1$1"})
    static final class h extends q implements kotlin.g.a.b<ArrayList<Integer>, x> {
        final /* synthetic */ int oeZ;
        final /* synthetic */ i orh;
        final /* synthetic */ g ori;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(i iVar, g gVar, int i2) {
            super(1);
            this.orh = iVar;
            this.ori = gVar;
            this.oeZ = i2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(ArrayList<Integer> arrayList) {
            AppMethodBeat.i(230255);
            ArrayList<Integer> arrayList2 = arrayList;
            p.h(arrayList2, "changed");
            Iterator<T> it = arrayList2.iterator();
            while (it.hasNext()) {
                this.orh.ci(it.next().intValue());
            }
            x xVar = x.SXb;
            AppMethodBeat.o(230255);
            return xVar;
        }
    }

    public i(List<a> list) {
        p.h(list, "items");
        AppMethodBeat.i(230260);
        this.iHf = list;
        AppMethodBeat.o(230260);
    }

    /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ g a(ViewGroup viewGroup, int i2) {
        e eVar;
        AppMethodBeat.i(230256);
        p.h(viewGroup, "parent");
        switch (i2) {
            case 1:
                eVar = new e(viewGroup, this.iHf, this);
                break;
            default:
                eVar = new f(viewGroup, this.iHf, this);
                break;
        }
        RecyclerView.v vVar = eVar;
        AppMethodBeat.o(230256);
        return vVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ void a(g gVar, int i2) {
        AppMethodBeat.i(230258);
        g gVar2 = gVar;
        p.h(gVar2, "holder");
        a aVar = this.iHf.get(i2);
        if (aVar != null) {
            h hVar = new h(this, gVar2, i2);
            p.h(aVar, "item");
            p.h(hVar, "checkStateChange");
            gVar2.c(aVar);
            gVar2.a(aVar.jCx, aVar);
            gVar2.view.setOnClickListener(new g.a(gVar2, aVar, i2, hVar));
            gVar2.view.setOnLongClickListener(new g.b(gVar2, aVar, i2));
            AppMethodBeat.o(230258);
            return;
        }
        AppMethodBeat.o(230258);
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemCount() {
        AppMethodBeat.i(230257);
        int size = this.iHf.size();
        AppMethodBeat.o(230257);
        return size;
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemViewType(int i2) {
        AppMethodBeat.i(230259);
        a aVar = this.iHf.get(i2);
        if (aVar != null) {
            int i3 = aVar.type;
            AppMethodBeat.o(230259);
            return i3;
        }
        AppMethodBeat.o(230259);
        return 0;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJI\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u001421\u0010\u0015\u001a-\u0012#\u0012!\u0012\u0004\u0012\u00020\u00140\u0017j\b\u0012\u0004\u0012\u00020\u0014`\u0018¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u00110\u0016J\u0010\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0006H&J\u0018\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0012\u001a\u00020\u0006H\u0002J\u0010\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u001fH&R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\""}, hxF = {"Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "items", "", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$Item;", "itemAdapter", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter;", "(Landroid/view/View;Ljava/util/List;Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter;)V", "getItems", "()Ljava/util/List;", "getView", "()Landroid/view/View;", "setView", "(Landroid/view/View;)V", "applyData", "", "item", "position", "", "checkStateChange", "Lkotlin/Function1;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Lkotlin/ParameterName;", "name", "posChanged", "reanderView", "refreshCheckView", "check", "", "renderViewChecked", "checked", "luggage-wechat-full-sdk_release"})
    public static abstract class g extends RecyclerView.v {
        final List<a> iHf;
        private final i ord;
        View view;

        public abstract void c(a aVar);

        public abstract void jf(boolean z);

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(View view2, List<a> list, i iVar) {
            super(view2);
            p.h(view2, "view");
            p.h(list, "items");
            p.h(iVar, "itemAdapter");
            this.view = view2;
            this.iHf = list;
            this.ord = iVar;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        static final class a implements View.OnClickListener {
            final /* synthetic */ int gUj;
            final /* synthetic */ g ore;
            final /* synthetic */ a orf;

            /* renamed from: org  reason: collision with root package name */
            final /* synthetic */ kotlin.g.a.b f1502org;

            a(g gVar, a aVar, int i2, kotlin.g.a.b bVar) {
                this.ore = gVar;
                this.orf = aVar;
                this.gUj = i2;
                this.f1502org = bVar;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(230253);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ViewHolder$applyData$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                this.orf.jCx = true;
                this.ore.a((g) this.orf.jCx, (boolean) this.orf);
                ArrayList arrayList = new ArrayList();
                int i2 = 0;
                for (T t : this.ore.iHf) {
                    int i3 = i2 + 1;
                    if (i2 < 0) {
                        j.hxH();
                    }
                    T t2 = t;
                    arrayList.add(Integer.valueOf(i2));
                    if (this.gUj != i2) {
                        if (t2 == null) {
                            i2 = i3;
                        } else if (t2.jCx) {
                            t2.jCx = false;
                            arrayList.add(Integer.valueOf(this.gUj));
                        }
                    }
                    i2 = i3;
                }
                this.f1502org.invoke(arrayList);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ViewHolder$applyData$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(230253);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
        static final class b implements View.OnLongClickListener {
            final /* synthetic */ int gUj;
            final /* synthetic */ g ore;
            final /* synthetic */ a orf;

            b(g gVar, a aVar, int i2) {
                this.ore = gVar;
                this.orf = aVar;
                this.gUj = i2;
            }

            public final boolean onLongClick(View view) {
                AppMethodBeat.i(230254);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ViewHolder$applyData$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
                d dVar = this.ore.ord.oqX;
                if (dVar != null) {
                    dVar.a(this.ore.view, this.orf, this.gUj);
                }
                com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ViewHolder$applyData$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                AppMethodBeat.o(230254);
                return true;
            }
        }

        /* access modifiers changed from: package-private */
        public final void a(boolean z, a aVar) {
            b bVar;
            if (this.iHf.size() == 1) {
                jf(true);
                if (z && (bVar = this.ord.nbX) != null) {
                    bVar.a(aVar);
                }
            } else if (z) {
                b bVar2 = this.ord.nbX;
                if (bVar2 != null) {
                    bVar2.a(aVar);
                }
                jf(true);
            } else {
                jf(false);
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0006H\u0016J\u0010\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001bH\u0016R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$UserInfoViewHolder;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ViewHolder;", "parent", "Landroid/view/ViewGroup;", "items", "", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$Item;", "itemAdapter", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter;", "(Landroid/view/ViewGroup;Ljava/util/List;Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter;)V", "icon", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "setIcon", "(Landroid/widget/ImageView;)V", "getParent", "()Landroid/view/ViewGroup;", "selected", "subTitle", "Landroid/widget/TextView;", "title", "reanderView", "", "item", "renderViewChecked", "checked", "", "luggage-wechat-full-sdk_release"})
    public static final class f extends g {
        private final TextView hbb;
        private ImageView kc;
        private final ImageView ora;
        private final TextView orb;
        private final ViewGroup parent;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public f(android.view.ViewGroup r5, java.util.List<com.tencent.mm.plugin.appbrand.widget.dialog.i.a> r6, com.tencent.mm.plugin.appbrand.widget.dialog.i r7) {
            /*
            // Method dump skipped, instructions count: 131
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.widget.dialog.i.f.<init>(android.view.ViewGroup, java.util.List, com.tencent.mm.plugin.appbrand.widget.dialog.i):void");
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.dialog.i.g
        public final void c(a aVar) {
            String str;
            String str2;
            AppMethodBeat.i(230250);
            p.h(aVar, "item");
            this.kc.setImageResource(R.drawable.bca);
            TextView textView = this.hbb;
            SpannableString a2 = com.tencent.mm.plugin.appbrand.widget.input.a.a.cce().a(this.hbb.getContext(), aVar.title, this.hbb.getTextSize());
            if (a2 != null) {
                str = a2;
            }
            textView.setText(str);
            if (!TextUtils.isEmpty(aVar.oqZ)) {
                this.orb.setVisibility(0);
                TextView textView2 = this.orb;
                String str3 = aVar.oqZ;
                if (str3 != null) {
                    str2 = str3;
                }
                textView2.setText(str2);
            } else {
                this.orb.setVisibility(8);
            }
            if (aVar.nEk != null) {
                Bitmap roundedCornerBitmap = BitmapUtil.getRoundedCornerBitmap(aVar.nEk, false, ((float) com.tencent.mm.cb.a.fromDPToPix(this.view.getContext(), 4)) * 1.0f, false);
                if (roundedCornerBitmap != null) {
                    this.kc.setImageBitmap(roundedCornerBitmap);
                    AppMethodBeat.o(230250);
                    return;
                }
                this.kc.setImageResource(R.drawable.bca);
                AppMethodBeat.o(230250);
                return;
            }
            if (aVar.iconUrl.length() > 0) {
                com.tencent.mm.modelappbrand.a.b.aXY().a(this.kc, aVar.iconUrl, R.drawable.bca, new a(this));
            }
            AppMethodBeat.o(230250);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, hxF = {"com/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$UserInfoViewHolder$reanderView$1", "Lcom/tencent/mm/modelappbrand/image/AppBrandSimpleImageLoader$IBitmapTransformation;", "key", "", "transform", "Landroid/graphics/Bitmap;", "bitmap", "luggage-wechat-full-sdk_release"})
        public static final class a implements b.h {
            final /* synthetic */ f orc;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            a(f fVar) {
                this.orc = fVar;
            }

            @Override // com.tencent.mm.modelappbrand.a.c
            public final String Lb() {
                return "appbrand_user_avatar";
            }

            @Override // com.tencent.mm.modelappbrand.a.b.h
            public final Bitmap J(Bitmap bitmap) {
                AppMethodBeat.i(230249);
                p.h(bitmap, "bitmap");
                Bitmap roundedCornerBitmap = BitmapUtil.getRoundedCornerBitmap(bitmap, false, ((float) com.tencent.mm.cb.a.fromDPToPix(this.orc.view.getContext(), 4)) * 1.0f, false);
                p.g(roundedCornerBitmap, "BitmapUtil.getRoundedCor…ontext, 4) * 1.0f, false)");
                AppMethodBeat.o(230249);
                return roundedCornerBitmap;
            }
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.dialog.i.g
        public final void jf(boolean z) {
            AppMethodBeat.i(230251);
            this.ora.setVisibility(z ? 0 : 8);
            AppMethodBeat.o(230251);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0006H\u0016J\u0010\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ScopeInfoViewHolder;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ViewHolder;", "parent", "Landroid/view/ViewGroup;", "items", "", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$Item;", "itemAdapter", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter;", "(Landroid/view/ViewGroup;Ljava/util/List;Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter;)V", "getParent", "()Landroid/view/ViewGroup;", "selected", "Landroid/widget/ImageView;", "title", "Landroid/widget/TextView;", "reanderView", "", "item", "renderViewChecked", "checked", "", "luggage-wechat-full-sdk_release"})
    public static final class e extends g {
        private final TextView hbb;
        private final ImageView ora;
        private final ViewGroup parent;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public e(android.view.ViewGroup r5, java.util.List<com.tencent.mm.plugin.appbrand.widget.dialog.i.a> r6, com.tencent.mm.plugin.appbrand.widget.dialog.i r7) {
            /*
                r4 = this;
                r3 = 230248(0x38368, float:3.22646E-40)
                java.lang.String r0 = "parent"
                kotlin.g.b.p.h(r5, r0)
                java.lang.String r0 = "items"
                kotlin.g.b.p.h(r6, r0)
                java.lang.String r0 = "itemAdapter"
                kotlin.g.b.p.h(r7, r0)
                android.content.Context r0 = r5.getContext()
                android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r0)
                r1 = 2131493009(0x7f0c0091, float:1.8609486E38)
                r2 = 0
                android.view.View r0 = r0.inflate(r1, r5, r2)
                java.lang.String r1 = "LayoutInflater.from(pare…list_item, parent, false)"
                kotlin.g.b.p.g(r0, r1)
                r4.<init>(r0, r6, r7)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
                r4.parent = r5
                android.view.View r0 = r4.view
                r1 = 2131309195(0x7f09328b, float:1.8236667E38)
                android.view.View r0 = r0.findViewById(r1)
                java.lang.String r1 = "view.findViewById(R.id.title)"
                kotlin.g.b.p.g(r0, r1)
                android.widget.TextView r0 = (android.widget.TextView) r0
                r4.hbb = r0
                android.view.View r0 = r4.view
                r1 = 2131307564(0x7f092c2c, float:1.8233359E38)
                android.view.View r0 = r0.findViewById(r1)
                java.lang.String r1 = "view.findViewById(R.id.selected)"
                kotlin.g.b.p.g(r0, r1)
                android.widget.ImageView r0 = (android.widget.ImageView) r0
                r4.ora = r0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.widget.dialog.i.e.<init>(android.view.ViewGroup, java.util.List, com.tencent.mm.plugin.appbrand.widget.dialog.i):void");
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.dialog.i.g
        public final void c(a aVar) {
            AppMethodBeat.i(230246);
            p.h(aVar, "item");
            this.hbb.setText(aVar.title);
            AppMethodBeat.o(230246);
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.dialog.i.g
        public final void jf(boolean z) {
            AppMethodBeat.i(230247);
            this.ora.setVisibility(z ? 0 : 8);
            AppMethodBeat.o(230247);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0018\u0018\u00002\u00020\u0001BE\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0003¢\u0006\u0002\u0010\fBG\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u000b\u001a\u00020\u0003¢\u0006\u0002\u0010\u000fB+\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\u0010BS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003¢\u0006\u0002\u0010\u0011R\u001a\u0010\u000b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\n\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0013¨\u0006&"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$Item;", "", "type", "", "title", "", "subTitle", "scope", "check", "", "iconUrl", "avatarId", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;I)V", "icon", "Landroid/graphics/Bitmap;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLandroid/graphics/Bitmap;I)V", "(ILjava/lang/String;Ljava/lang/String;Z)V", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/graphics/Bitmap;ZLjava/lang/String;I)V", "getAvatarId", "()I", "setAvatarId", "(I)V", "getCheck", "()Z", "setCheck", "(Z)V", "getIcon", "()Landroid/graphics/Bitmap;", "setIcon", "(Landroid/graphics/Bitmap;)V", "getIconUrl", "()Ljava/lang/String;", "setIconUrl", "(Ljava/lang/String;)V", "getScope", "getSubTitle", "getTitle", "getType", "luggage-wechat-full-sdk_release"})
    public static final class a {
        String iconUrl;
        public boolean jCx;
        public int lGW;
        Bitmap nEk;
        final String oqZ;
        public final String scope;
        final String title;
        final int type;

        public a(int i2, String str, String str2, String str3, Bitmap bitmap, boolean z, String str4, int i3) {
            p.h(str4, "iconUrl");
            AppMethodBeat.i(230243);
            this.type = i2;
            this.title = str;
            this.oqZ = str2;
            this.scope = str3;
            this.nEk = bitmap;
            this.jCx = z;
            this.iconUrl = str4;
            this.lGW = i3;
            AppMethodBeat.o(230243);
        }

        public /* synthetic */ a(String str, String str2, String str3, Bitmap bitmap) {
            this(0, str, str2, str3, bitmap, false, "", 0);
            AppMethodBeat.i(230244);
            AppMethodBeat.o(230244);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public a(String str, String str2, String str3, boolean z, String str4, int i2) {
            this(0, str, str2, str3, null, z, str4, i2);
            p.h(str4, "iconUrl");
            AppMethodBeat.i(230245);
            AppMethodBeat.o(230245);
        }

        public a(String str, String str2, String str3, Bitmap bitmap, byte b2) {
            this(0, str, str2, str3, bitmap, true, "", 0);
        }

        public a(String str, String str2, boolean z) {
            this(1, str, "", str2, null, z, "", 0);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ItemType;", "", "()V", "ITEM_TYPE_SCOPE_INFO", "", "ITEM_TYPE_USER_INFO", "luggage-wechat-full-sdk_release"})
    public static final class c {
        private c() {
        }

        public /* synthetic */ c(byte b2) {
            this();
        }
    }
}
