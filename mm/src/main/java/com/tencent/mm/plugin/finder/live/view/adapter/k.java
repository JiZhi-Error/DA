package com.tencent.mm.plugin.finder.live.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fts.ui.n;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.smtt.sdk.TbsVideoCacheTask;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u0018\u0019B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\f\u0010\u000f\u001a\u00060\u0010R\u00020\u0001H\u0014J \u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\f\u0010\u0015\u001a\b\u0018\u00010\u0010R\u00020\u0001H\u0016J\f\u0010\u0016\u001a\u00060\u0017R\u00020\u0001H\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00060\fR\u00020\u0000X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00060\u000eR\u00020\u0000X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveHeaderDataItem;", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem;", "position", "", "(I)V", TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER, "", "getHeader", "()Ljava/lang/String;", "setHeader", "(Ljava/lang/String;)V", "headerViewHodler", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveHeaderDataItem$HeaderViewHolder;", "headerViewItem", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveHeaderDataItem$HeaderViewItem;", "createViewHolder", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem$BaseContactViewHolder;", "fillingDataItem", "", "context", "Landroid/content/Context;", "baseViewHolder", "getViewItem", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem$BaseContactViewItem;", "HeaderViewHolder", "HeaderViewItem", "plugin-finder_release"})
public final class k extends com.tencent.mm.ui.contact.a.a {
    private final b UOx = new b();
    final a UOy = new a();
    String header;

    public k(int i2) {
        super(0, i2);
        AppMethodBeat.i(260913);
        AppMethodBeat.o(260913);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J4\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\u0010\b\u001a\u00060\tR\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J$\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u000fH\u0016J \u0010\u0013\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u0002H\u0016¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveHeaderDataItem$HeaderViewItem;", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem$BaseContactViewItem;", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem;", "(Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveHeaderDataItem;)V", "fillingViewItem", "", "context", "Landroid/content/Context;", "holder", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem$BaseContactViewHolder;", "data", "alwaysCheck", "", "isCheck", "inflateView", "Landroid/view/View;", "parent", "Landroid/view/ViewGroup;", "convertView", "onItemClick", "v", "plugin-finder_release"})
    public final class b extends a.b {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public b() {
            super();
        }

        @Override // com.tencent.mm.ui.contact.a.a.b
        public final View a(Context context, ViewGroup viewGroup) {
            View view;
            AppMethodBeat.i(260910);
            p.h(context, "context");
            p.h(viewGroup, "parent");
            View inflate = LayoutInflater.from(context).inflate(R.layout.bq2, viewGroup, false);
            a aVar = k.this.UOy;
            if (aVar == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.live.view.adapter.FinderLiveHeaderDataItem.HeaderViewHolder");
                AppMethodBeat.o(260910);
                throw tVar;
            }
            a aVar2 = aVar;
            TextView textView = inflate != null ? (TextView) inflate.findViewById(R.id.dp0) : null;
            if (textView == null) {
                t tVar2 = new t("null cannot be cast to non-null type android.widget.TextView");
                AppMethodBeat.o(260910);
                throw tVar2;
            }
            aVar2.qqq = textView;
            if (inflate != null) {
                view = inflate.findViewById(R.id.jzt);
            } else {
                view = null;
            }
            aVar2.UOz = view;
            View view2 = aVar2.UOz;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            if (inflate != null) {
                inflate.setTag(aVar2);
            }
            AppMethodBeat.o(260910);
            return inflate;
        }

        @Override // com.tencent.mm.ui.contact.a.a.b
        public final void a(Context context, a.C2110a aVar, com.tencent.mm.ui.contact.a.a aVar2, boolean z, boolean z2) {
            AppMethodBeat.i(260911);
            p.h(context, "context");
            p.h(aVar, "holder");
            p.h(aVar2, "data");
            n.b(((k) aVar2).header, ((a) aVar).qqq);
            AppMethodBeat.o(260911);
        }

        @Override // com.tencent.mm.ui.contact.a.a.b
        public final boolean a(Context context, View view, com.tencent.mm.ui.contact.a.a aVar) {
            AppMethodBeat.i(260912);
            p.h(context, "context");
            p.h(view, "v");
            p.h(aVar, "data");
            AppMethodBeat.o(260912);
            return false;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveHeaderDataItem$HeaderViewHolder;", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem$BaseContactViewHolder;", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem;", "(Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveHeaderDataItem;)V", "headerRoot", "Landroid/view/View;", "getHeaderRoot", "()Landroid/view/View;", "setHeaderRoot", "(Landroid/view/View;)V", "headerTV", "Landroid/widget/TextView;", "getHeaderTV", "()Landroid/widget/TextView;", "setHeaderTV", "(Landroid/widget/TextView;)V", "plugin-finder_release"})
    public final class a extends a.C2110a {
        View UOz;
        TextView qqq;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public a() {
            super();
        }
    }

    @Override // com.tencent.mm.ui.contact.a.a
    public final void a(Context context, a.C2110a aVar) {
    }

    @Override // com.tencent.mm.ui.contact.a.a
    public final a.b bmx() {
        return this.UOx;
    }
}
