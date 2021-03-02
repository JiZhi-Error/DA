package com.tencent.mm.plugin.appbrand.ui.collection;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ArrayAdapter;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.widget.sortlist.DragSortListView;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0006j\b\u0012\u0004\u0012\u00020\u0002`\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\"\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J \u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u001a\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002J\u0010\u0010 \u001a\u0004\u0018\u00010\u00022\u0006\u0010!\u001a\u00020\u0013R!\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0006j\b\u0012\u0004\u0012\u00020\u0002`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, hxF = {"Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionDragSortAdapter;", "Landroid/widget/ArrayAdapter;", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "context", "Landroid/content/Context;", "dataList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "(Landroid/content/Context;Ljava/util/ArrayList;)V", "getDataList", "()Ljava/util/ArrayList;", "mList", "Lcom/tencent/mm/ui/widget/sortlist/DragSortListView;", "attachListView", "", "list", "getItemId", "", "position", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "onBindViewHolder", "holder", "Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionSortViewHolder;", "item", "onCreateViewHolder", "inflater", "Landroid/view/LayoutInflater;", "remove", FirebaseAnalytics.b.INDEX, "plugin-appbrand-integration_release"})
public final class b extends ArrayAdapter<LocalUsageInfo> {
    final ArrayList<LocalUsageInfo> kgc;
    DragSortListView oaR;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(Context context, ArrayList<LocalUsageInfo> arrayList) {
        super(context, c.bYk(), arrayList);
        p.h(context, "context");
        p.h(arrayList, "dataList");
        AppMethodBeat.i(51256);
        this.kgc = arrayList;
        AppMethodBeat.o(51256);
    }

    public final LocalUsageInfo zt(int i2) {
        AppMethodBeat.i(51253);
        LocalUsageInfo localUsageInfo = (LocalUsageInfo) getItem(i2);
        super.remove(localUsageInfo);
        AppMethodBeat.o(51253);
        return localUsageInfo;
    }

    public final long getItemId(int i2) {
        AppMethodBeat.i(51254);
        LocalUsageInfo localUsageInfo = (LocalUsageInfo) getItem(i2);
        StringBuilder sb = new StringBuilder();
        if (localUsageInfo == null) {
            p.hyc();
        }
        long hashCode = (long) sb.append(localUsageInfo.username).append(localUsageInfo.iOo).toString().hashCode();
        AppMethodBeat.o(51254);
        return hashCode;
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        e eVar;
        int i3;
        AppMethodBeat.i(51255);
        p.h(viewGroup, "parent");
        if (view == null || view.getTag() == null) {
            LayoutInflater from = LayoutInflater.from(getContext());
            p.g(from, "LayoutInflater.from(context)");
            View inflate = from.inflate(c.bYk(), viewGroup, false);
            View inflate2 = ((ViewStub) inflate.findViewById(R.id.bfa)).inflate();
            if (inflate2 != null) {
                inflate2.setBackground(null);
            }
            p.g(inflate, "view");
            eVar = new e(inflate);
        } else {
            Object tag = view.getTag();
            if (tag == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.ui.collection.CollectionSortViewHolder");
                AppMethodBeat.o(51255);
                throw tVar;
            }
            eVar = (e) tag;
        }
        Object item = getItem(i2);
        if (item == null) {
            p.hyc();
        }
        p.g(item, "getItem(position)!!");
        eVar.f((LocalUsageInfo) item);
        View view2 = eVar.aus;
        p.g(view2, "holder.itemView");
        view2.setClickable(false);
        if (i2 == getCount() - 1) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        eVar.obi.setVisibility(i3);
        View view3 = eVar.obc;
        p.g(view3, "rightExtraBottomLine");
        view3.setVisibility(i3);
        eVar.obb.setOnClickListener(new a(this, i2));
        View view4 = eVar.aus;
        p.g(view4, "holder.itemView");
        AppMethodBeat.o(51255);
        return view4;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a implements View.OnClickListener {
        final /* synthetic */ int gUj;
        final /* synthetic */ b oaW;

        a(b bVar, int i2) {
            this.oaW = bVar;
            this.gUj = i2;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(51252);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/collection/CollectionDragSortAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            DragSortListView dragSortListView = this.oaW.oaR;
            if (dragSortListView != null) {
                dragSortListView.removeItem(this.gUj);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/collection/CollectionDragSortAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(51252);
        }
    }
}
