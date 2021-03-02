package com.tencent.mm.plugin.finder.live.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.live.viewmodel.e;
import com.tencent.mm.plugin.finder.live.viewmodel.g;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00014B\u0019\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\u0010\u0007J\b\u0010$\u001a\u00020%H\u0016J\u0018\u0010&\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\rH\u0002J\u000e\u0010)\u001a\u00020%2\u0006\u0010(\u001a\u00020\rJ\u0018\u0010*\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020\u00022\u0006\u0010+\u001a\u00020%H\u0016J\u0018\u0010,\u001a\u00020\u00022\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020%H\u0016J\u000e\u00100\u001a\u00020\u001b2\u0006\u00101\u001a\u00020\rJ\u001c\u00102\u001a\u00020\u001b2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\r032\u0006\u0010\u000f\u001a\u00020\u0005R\u000e\u0010\b\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R7\u0010\u0016\u001a\u001f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR7\u0010 \u001a\u001f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001d\"\u0004\b#\u0010\u001f¨\u00065"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveApplyLinkSearchAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveApplyLinkSearchAdapter$ApplyLinkViewHolder;", "applyLinkUserDescMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveLinkMicUserDesc;", "(Ljava/util/HashMap;)V", "TAG", "getApplyLinkUserDescMap", "()Ljava/util/HashMap;", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveLinkMicUser;", "Lkotlin/collections/ArrayList;", "keyword", "liveData", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;", "getLiveData", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;", "setLiveData", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;)V", "onAcceptLinkUser", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "acceptUser", "", "getOnAcceptLinkUser", "()Lkotlin/jvm/functions/Function1;", "setOnAcceptLinkUser", "(Lkotlin/jvm/functions/Function1;)V", "onHungupLinkUser", "hungupUser", "getOnHungupLinkUser", "setOnHungupLinkUser", "getItemCount", "", "handleDescTv", "holder", "data", "indexOfData", "onBindViewHolder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "type", "removeAndNotify", "micUser", "updateData", "", "ApplyLinkViewHolder", "plugin-finder_release"})
public final class b extends RecyclerView.a<a> {
    private final String TAG = "Finder.FinderLiveApplyLinkSearchAdapter";
    private final HashMap<String, com.tencent.mm.plugin.finder.live.viewmodel.l> UNL;
    public kotlin.g.a.b<? super e, x> UNY;
    private String dDv = "";
    public final ArrayList<e> kgc = new ArrayList<>();
    g liveData;
    public kotlin.g.a.b<? super e, x> uzX;

    public b(HashMap<String, com.tencent.mm.plugin.finder.live.viewmodel.l> hashMap) {
        p.h(hashMap, "applyLinkUserDescMap");
        AppMethodBeat.i(260881);
        this.UNL = hashMap;
        AppMethodBeat.o(260881);
    }

    /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ a a(ViewGroup viewGroup, int i2) {
        AppMethodBeat.i(247729);
        p.h(viewGroup, "parent");
        View inflate = View.inflate(viewGroup.getContext(), R.layout.ae5, null);
        p.g(inflate, "View.inflate(parent.cont…ve_link_apply_item, null)");
        a aVar = new a(inflate);
        AppMethodBeat.o(247729);
        return aVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
    /* JADX WARNING: Code restructure failed: missing block: B:145:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x01ba, code lost:
        if (r2.UPO == 2) goto L_0x01ee;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x01ec, code lost:
        if (r2.UPO == 1) goto L_0x01ee;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x01ee, code lost:
        r1 = r14.oSD;
        kotlin.g.b.p.g(r1, "holder.progress");
        r1.setVisibility(0);
        r1 = r14.uAa;
        kotlin.g.b.p.g(r1, "holder.acceptBtn");
        r1.setVisibility(8);
        com.tencent.matrix.trace.core.AppMethodBeat.o(247731);
     */
    @Override // android.support.v7.widget.RecyclerView.a
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void a(com.tencent.mm.plugin.finder.live.view.adapter.b.a r14, int r15) {
        /*
        // Method dump skipped, instructions count: 1213
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.live.view.adapter.b.a(android.support.v7.widget.RecyclerView$v, int):void");
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemCount() {
        AppMethodBeat.i(247730);
        int size = this.kgc.size();
        AppMethodBeat.o(247730);
        return size;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.finder.live.view.adapter.b$b  reason: collision with other inner class name */
    static final class View$OnClickListenerC1196b implements View.OnClickListener {
        final /* synthetic */ int gUj;
        final /* synthetic */ b uAc;

        View$OnClickListenerC1196b(b bVar, int i2) {
            this.uAc = bVar;
            this.gUj = i2;
        }

        public final void onClick(View view) {
            T t;
            List<e> list;
            T t2;
            AppMethodBeat.i(247728);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveApplyLinkSearchAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            e eVar = (e) j.L(this.uAc.kgc, this.gUj);
            if (eVar != null) {
                g gVar = this.uAc.liveData;
                if (gVar == null || (list = gVar.UPZ) == null) {
                    t = null;
                } else {
                    List<e> list2 = list;
                    synchronized (list2) {
                        try {
                            Iterator<T> it = list2.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    t2 = null;
                                    break;
                                }
                                T next = it.next();
                                if (Util.isEqual(next.uCo, eVar.uCo)) {
                                    t2 = next;
                                    break;
                                }
                            }
                        } catch (Throwable th) {
                            AppMethodBeat.o(247728);
                            throw th;
                        }
                    }
                    t = t2;
                }
                if (t != null) {
                    kotlin.g.a.b<? super e, x> bVar2 = this.uAc.UNY;
                    if (bVar2 != null) {
                        bVar2.invoke(eVar);
                    }
                } else {
                    kotlin.g.a.b<? super e, x> bVar3 = this.uAc.uzX;
                    if (bVar3 != null) {
                        bVar3.invoke(eVar);
                    }
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveApplyLinkSearchAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(247728);
        }
    }

    public final void j(List<e> list, String str) {
        AppMethodBeat.i(247732);
        p.h(list, "data");
        p.h(str, "keyword");
        this.dDv = str;
        this.kgc.clear();
        this.kgc.addAll(list);
        AppMethodBeat.o(247732);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0019\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0019\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0019\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\tR\u0019\u0010\u000e\u001a\n \u0007*\u0004\u0018\u00010\u000f0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0012\u001a\n \u0007*\u0004\u0018\u00010\u00130\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveApplyLinkSearchAdapter$ApplyLinkViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "acceptBtn", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getAcceptBtn", "()Landroid/widget/TextView;", "descTv", "getDescTv", "nicknameTv", "getNicknameTv", "progress", "Landroid/widget/ProgressBar;", "getProgress", "()Landroid/widget/ProgressBar;", "typeIcon", "Landroid/widget/ImageView;", "getTypeIcon", "()Landroid/widget/ImageView;", "plugin-finder_release"})
    public static final class a extends RecyclerView.v {
        final TextView hPW;
        final ProgressBar oSD;
        final TextView pIN;
        final TextView uAa;
        final ImageView uzZ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            p.h(view, "itemView");
            AppMethodBeat.i(247727);
            this.pIN = (TextView) view.findViewById(R.id.csd);
            this.uzZ = (ImageView) view.findViewById(R.id.cse);
            this.uAa = (TextView) view.findViewById(R.id.csa);
            this.hPW = (TextView) view.findViewById(R.id.jxt);
            this.oSD = (ProgressBar) view.findViewById(R.id.jxw);
            AppMethodBeat.o(247727);
        }
    }
}
