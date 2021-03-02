package com.tencent.mm.plugin.vlog.ui.thumb;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0003123B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010 \u001a\u00020\u0018J\u000e\u0010!\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\tJ\b\u0010\"\u001a\u00020\tH\u0016J\u0010\u0010#\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\tH\u0016J\u001c\u0010$\u001a\u00020\u00182\n\u0010%\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0015\u001a\u00020\tH\u0016J\u001c\u0010&\u001a\u00060\u0002R\u00020\u00002\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\tH\u0016J\u0014\u0010*\u001a\u00020\u00182\n\u0010+\u001a\u00060\u0002R\u00020\u0000H\u0016J\u000e\u0010,\u001a\u00020\u00182\u0006\u0010-\u001a\u00020\tJ\u000e\u0010.\u001a\u00020\u00182\u0006\u0010\u0006\u001a\u00020\u0007J\u0014\u0010.\u001a\u00020\u00182\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u001600R\u000e\u0010\u0004\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010RL\u0010\u0011\u001a4\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00160\u001fX\u0004¢\u0006\u0002\n\u0000¨\u00064"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter$BaseViewHolder;", "()V", "TAG", "", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "contentEndPos", "", "contentStartPos", "inTimeCropMode", "", "getInTimeCropMode", "()Z", "setInTimeCropMode", "(Z)V", "itemClickListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "position", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackThumbInfo;", "trackThumbInfo", "", "getItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "selectedIndex", "trackList", "Ljava/util/LinkedList;", "clearFocus", "getItem", "getItemCount", "getItemViewType", "onBindViewHolder", "viewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onViewRecycled", "holder", "setSelection", "trackIndex", "update", "tracks", "", "BaseViewHolder", "EmptyViewHolder", "FrameViewHolder", "plugin-vlog_release"})
public final class f extends RecyclerView.a<a> {
    private final LinkedList<h> GOJ = new LinkedList<>();
    private int GOK = -1;
    private int GOL = -1;
    public boolean GPp;
    private final String TAG = "MicroMsg.FrameListAdapter";
    private int bxP = -1;
    public m<? super Integer, ? super h, x> rsD;

    public f() {
        AppMethodBeat.i(192080);
        AppMethodBeat.o(192080);
    }

    /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ a a(ViewGroup viewGroup, int i2) {
        b bVar;
        AppMethodBeat.i(192075);
        p.h(viewGroup, "parent");
        switch (i2) {
            case 1:
                bVar = new b(this, new View(viewGroup.getContext()));
                break;
            default:
                View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.c69, viewGroup, false);
                p.g(inflate, "LayoutInflater.from(pare…rame_item, parent, false)");
                bVar = new c(this, inflate);
                break;
        }
        RecyclerView.v vVar = bVar;
        AppMethodBeat.o(192075);
        return vVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v] */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ void a(a aVar) {
        AppMethodBeat.i(192079);
        a aVar2 = aVar;
        p.h(aVar2, "holder");
        super.a(aVar2);
        aVar2.avR();
        AppMethodBeat.o(192079);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ void a(a aVar, int i2) {
        AppMethodBeat.i(192078);
        a aVar2 = aVar;
        p.h(aVar2, "viewHolder");
        h hVar = this.GOJ.get(i2);
        p.g(hVar, "trackList[position]");
        aVar2.a(hVar);
        AppMethodBeat.o(192078);
    }

    public final void hw(List<h> list) {
        int i2 = -1;
        AppMethodBeat.i(192072);
        p.h(list, "tracks");
        this.GOJ.clear();
        this.GOJ.addAll(list);
        int i3 = 0;
        Iterator<h> it = this.GOJ.iterator();
        while (true) {
            if (!it.hasNext()) {
                i3 = -1;
                break;
            } else if (it.next().isEmpty()) {
                break;
            } else {
                i3++;
            }
        }
        this.GOK = i3 + 1;
        LinkedList<h> linkedList = this.GOJ;
        ListIterator<h> listIterator = linkedList.listIterator(linkedList.size());
        while (true) {
            if (listIterator.hasPrevious()) {
                if (listIterator.previous().isEmpty()) {
                    i2 = listIterator.nextIndex();
                    break;
                }
            } else {
                break;
            }
        }
        this.GOL = i2 - 1;
        AppMethodBeat.o(192072);
    }

    public final void setSelection(int i2) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(192073);
        if (i2 != this.bxP) {
            for (h hVar : this.GOJ) {
                if (hVar.trackIndex == this.bxP) {
                    z2 = true;
                    continue;
                } else {
                    z2 = false;
                    continue;
                }
                if (z2) {
                    break;
                }
            }
            for (h hVar2 : this.GOJ) {
                if (hVar2.trackIndex == i2) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    break;
                }
            }
            this.bxP = i2;
            notifyDataSetChanged();
        }
        AppMethodBeat.o(192073);
    }

    public final h acK(int i2) {
        AppMethodBeat.i(192074);
        h hVar = this.GOJ.get(i2);
        p.g(hVar, "trackList[position]");
        h hVar2 = hVar;
        AppMethodBeat.o(192074);
        return hVar2;
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemCount() {
        AppMethodBeat.i(192076);
        int size = this.GOJ.size();
        AppMethodBeat.o(192076);
        return size;
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemViewType(int i2) {
        AppMethodBeat.i(192077);
        if (this.GOJ.get(i2).isEmpty()) {
            AppMethodBeat.o(192077);
            return 1;
        }
        int itemViewType = super.getItemViewType(i2);
        AppMethodBeat.o(192077);
        return itemViewType;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b¦\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\u0006H\u0016¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter$BaseViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter;Landroid/view/View;)V", "onBind", "", "trackInfo", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackThumbInfo;", "onUnbind", "plugin-vlog_release"})
    public abstract class a extends RecyclerView.v {
        final /* synthetic */ f GPq;

        public abstract void a(h hVar);

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(f fVar, View view) {
            super(view);
            p.h(view, "itemView");
            this.GPq = fVar;
        }

        public void avR() {
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter$FrameViewHolder;", "Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter;Landroid/view/View;)V", "frameList", "Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListView;", "getFrameList", "()Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListView;", "onBind", "", "trackInfo", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackThumbInfo;", "onUnbind", "plugin-vlog_release"})
    public final class c extends a {
        private final FrameListView Avq;
        final /* synthetic */ f GPq;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(f fVar, View view) {
            super(fVar, view);
            p.h(view, "itemView");
            this.GPq = fVar;
            AppMethodBeat.i(192071);
            View findViewById = view.findViewById(R.id.d9v);
            p.g(findViewById, "itemView.findViewById(R.id.frame_list)");
            this.Avq = (FrameListView) findViewById;
            AppMethodBeat.o(192071);
        }

        @Override // com.tencent.mm.plugin.vlog.ui.thumb.f.a
        public final void a(h hVar) {
            boolean z;
            boolean z2;
            boolean z3 = true;
            AppMethodBeat.i(192069);
            p.h(hVar, "trackInfo");
            if (this.GPq.GPp) {
                boolean z4 = lR() != this.GPq.GOK;
                if (lR() != this.GPq.GOL) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                this.Avq.aC(true, true);
                this.Avq.aD(z4, z2);
            } else {
                FrameListView frameListView = this.Avq;
                if (lR() == this.GPq.GOK) {
                    z = true;
                } else {
                    z = false;
                }
                if (lR() != this.GPq.GOL) {
                    z3 = false;
                }
                frameListView.aC(z, z3);
                this.Avq.aD(false, false);
            }
            this.Avq.setTrackInfo(hVar);
            View view = this.aus;
            p.g(view, "itemView");
            view.setBackground(null);
            View view2 = this.aus;
            p.g(view2, "itemView");
            view2.setVisibility(0);
            if (this.GPq.bxP >= 0) {
                if (hVar.trackIndex == this.GPq.bxP) {
                    View view3 = this.aus;
                    p.g(view3, "itemView");
                    View view4 = this.aus;
                    p.g(view4, "itemView");
                    view3.setBackground(com.tencent.mm.cb.a.l(view4.getContext(), R.drawable.b1z));
                } else {
                    View view5 = this.aus;
                    p.g(view5, "itemView");
                    view5.setVisibility(4);
                }
            }
            this.aus.setOnClickListener(new a(this));
            AppMethodBeat.o(192069);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        static final class a implements View.OnClickListener {
            final /* synthetic */ c GPr;

            a(c cVar) {
                this.GPr = cVar;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(192068);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter$FrameViewHolder$onBind$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                m<? super Integer, ? super h, x> mVar = this.GPr.GPq.rsD;
                if (mVar != null) {
                    Integer valueOf = Integer.valueOf(this.GPr.lR());
                    Object obj = this.GPr.GPq.GOJ.get(this.GPr.lR());
                    p.g(obj, "trackList[adapterPosition]");
                    mVar.invoke(valueOf, obj);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter$FrameViewHolder$onBind$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(192068);
            }
        }

        @Override // com.tencent.mm.plugin.vlog.ui.thumb.f.a
        public final void avR() {
            AppMethodBeat.i(192070);
            this.Avq.release();
            AppMethodBeat.o(192070);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter$EmptyViewHolder;", "Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter;Landroid/view/View;)V", "onBind", "", "trackInfo", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackThumbInfo;", "plugin-vlog_release"})
    public final class b extends a {
        final /* synthetic */ f GPq;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(f fVar, View view) {
            super(fVar, view);
            p.h(view, "itemView");
            this.GPq = fVar;
            AppMethodBeat.i(192067);
            view.setOnClickListener(null);
            AppMethodBeat.o(192067);
        }

        @Override // com.tencent.mm.plugin.vlog.ui.thumb.f.a
        public final void a(h hVar) {
            AppMethodBeat.i(192066);
            p.h(hVar, "trackInfo");
            View view = this.aus;
            p.g(view, "itemView");
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                ViewGroup.LayoutParams layoutParams2 = new ViewGroup.LayoutParams(hVar.hEp, -1);
                View view2 = this.aus;
                p.g(view2, "itemView");
                view2.setLayoutParams(layoutParams2);
                AppMethodBeat.o(192066);
                return;
            }
            if (layoutParams.width != hVar.hEp) {
                layoutParams.width = hVar.hEp;
                View view3 = this.aus;
                p.g(view3, "itemView");
                view3.setLayoutParams(layoutParams);
            }
            AppMethodBeat.o(192066);
        }
    }
}
