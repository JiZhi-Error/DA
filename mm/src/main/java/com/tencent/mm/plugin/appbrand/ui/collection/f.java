package com.tencent.mm.plugin.appbrand.ui.collection;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.ui.collection.h;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J&\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000f2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0016J\u0018\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u000fH\u0016J\u0014\u0010\u001e\u001a\u00020\u00152\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00050 R!\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder;", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "Lkotlin/collections/ArrayList;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder$IEnterWxaListener;", "(Ljava/util/ArrayList;Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder$IEnterWxaListener;)V", "getDataList", "()Ljava/util/ArrayList;", "mListener", "cloneList", "getItemCount", "", "getItemId", "", "position", "getItemViewType", "onBindViewHolder", "", "holder", "payloads", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "replaceList", "list", "", "plugin-appbrand-integration_release"})
public final class f extends RecyclerView.a<h> {
    final ArrayList<LocalUsageInfo> kgc;
    private final h.a obe;

    public f(ArrayList<LocalUsageInfo> arrayList, h.a aVar) {
        p.h(arrayList, "dataList");
        AppMethodBeat.i(51278);
        this.kgc = arrayList;
        this.obe = aVar;
        AppMethodBeat.o(51278);
    }

    /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ h a(ViewGroup viewGroup, int i2) {
        AppMethodBeat.i(51273);
        p.h(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.e8, viewGroup, false);
        p.g(inflate, "LayoutInflater.from(pare…as_normal, parent, false)");
        h hVar = new h(inflate, this.obe);
        AppMethodBeat.o(51273);
        return hVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* bridge */ /* synthetic */ void a(h hVar, int i2) {
        AppMethodBeat.i(51275);
        a(hVar, i2);
        AppMethodBeat.o(51275);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int, java.util.List] */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ void a(h hVar, int i2, List list) {
        AppMethodBeat.i(51276);
        h hVar2 = hVar;
        p.h(hVar2, "holder");
        p.h(list, "payloads");
        if (!list.isEmpty()) {
            Object obj = list.get(0);
            if (!(obj instanceof Bundle)) {
                obj = null;
            }
            Bundle bundle = (Bundle) obj;
            if (bundle != null && !bundle.isEmpty()) {
                LocalUsageInfo localUsageInfo = this.kgc.get(i2);
                p.g(localUsageInfo, "dataList[position]");
                LocalUsageInfo localUsageInfo2 = localUsageInfo;
                p.h(localUsageInfo2, "newItem");
                p.h(bundle, "diffs");
                hVar2.obk = localUsageInfo2;
                if (bundle.get("icon") != null) {
                    hVar2.bYn();
                }
                if (bundle.get("nick_name") != null) {
                    hVar2.bYo();
                }
                AppMethodBeat.o(51276);
                return;
            }
        }
        a(hVar2, i2);
        AppMethodBeat.o(51276);
    }

    public final ArrayList<LocalUsageInfo> bYm() {
        ArrayList<LocalUsageInfo> arrayList;
        AppMethodBeat.i(51270);
        synchronized (this.kgc) {
            try {
                arrayList = new ArrayList<>(this.kgc.size());
                arrayList.addAll(this.kgc);
            } finally {
                AppMethodBeat.o(51270);
            }
        }
        return arrayList;
    }

    public final void bT(List<? extends LocalUsageInfo> list) {
        AppMethodBeat.i(51271);
        p.h(list, "list");
        synchronized (this.kgc) {
            try {
                this.kgc.clear();
                this.kgc.addAll(list);
            } finally {
                AppMethodBeat.o(51271);
            }
        }
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemCount() {
        AppMethodBeat.i(51272);
        int size = this.kgc.size();
        AppMethodBeat.o(51272);
        return size;
    }

    private void a(h hVar, int i2) {
        AppMethodBeat.i(51274);
        p.h(hVar, "holder");
        LocalUsageInfo localUsageInfo = this.kgc.get(i2);
        p.g(localUsageInfo, "dataList[position]");
        hVar.f(localUsageInfo);
        AppMethodBeat.o(51274);
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemViewType(int i2) {
        return 1;
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final long getItemId(int i2) {
        AppMethodBeat.i(51277);
        LocalUsageInfo localUsageInfo = this.kgc.get(i2);
        long hashCode = (long) (localUsageInfo.username + localUsageInfo.iOo).hashCode();
        AppMethodBeat.o(51277);
        return hashCode;
    }
}
