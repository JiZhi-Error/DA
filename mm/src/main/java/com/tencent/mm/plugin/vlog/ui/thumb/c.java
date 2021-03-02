package com.tencent.mm.plugin.vlog.ui.thumb;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.mmsight.segment.EditSliderSeekBar;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.videocomposition.g;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00046789B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010 \u001a\u00020\u0012J\u000e\u0010!\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\tJ\b\u0010\"\u001a\u00020\tH\u0016J\u0010\u0010#\u001a\u00020$2\u0006\u0010\u000f\u001a\u00020\tH\u0016J\u0010\u0010%\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\tH\u0016J\u0018\u0010&\u001a\u00020\u00122\u0006\u0010'\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\tH\u0016J&\u0010&\u001a\u00020\u00122\u0006\u0010'\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\t2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)H\u0016J\u0018\u0010+\u001a\u00020\u00022\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\tH\u0016J\u0010\u0010/\u001a\u00020\u00122\u0006\u00100\u001a\u00020\u0002H\u0016J\u000e\u00101\u001a\u00020\u00122\u0006\u00102\u001a\u00020\tJ\u000e\u00103\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u0007J\u0014\u00103\u001a\u00020\u00122\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u001005R\u000e\u0010\u0004\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000RL\u0010\u000b\u001a4\u0012\u0013\u0012\u00110\t¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00100\u001fX\u0004¢\u0006\u0002\n\u0000¨\u0006:"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/thumb/EditFrameListAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/vlog/ui/thumb/EditFrameListAdapter$BaseViewHolder;", "()V", "TAG", "", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "contentEndPos", "", "contentStartPos", "onItemClickListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "position", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackThumbInfo;", "trackThumbInfo", "", "getOnItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "onSliderTouchListener", "Lcom/tencent/mm/plugin/vlog/ui/thumb/EditFrameListAdapter$OnSliderTouchListener;", "getOnSliderTouchListener", "()Lcom/tencent/mm/plugin/vlog/ui/thumb/EditFrameListAdapter$OnSliderTouchListener;", "setOnSliderTouchListener", "(Lcom/tencent/mm/plugin/vlog/ui/thumb/EditFrameListAdapter$OnSliderTouchListener;)V", "selectedIndex", "trackList", "Ljava/util/LinkedList;", "clearFocus", "getItem", "getItemCount", "getItemId", "", "getItemViewType", "onBindViewHolder", "viewHolder", "payloads", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onViewRecycled", "holder", "setSelection", "trackIndex", "update", "tracks", "", "BaseViewHolder", "EmptyViewHolder", "FrameViewHolder", "OnSliderTouchListener", "plugin-vlog_release"})
public final class c extends RecyclerView.a<a> {
    private final LinkedList<h> GOJ = new LinkedList<>();
    private int GOK = -1;
    private int GOL = -1;
    d GOM;
    private final String TAG = "MicroMsg.EditFrameListAdapter";
    private int bxP = -1;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&J(\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH&J \u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/thumb/EditFrameListAdapter$OnSliderTouchListener;", "", "onDown", "", "position", "", "startAvailableSpace", "left", "", "onMove", "consumed", "rawX", "", "onUp", "plugin-vlog_release"})
    public interface d {
        void a(int i2, int i3, boolean z, float f2);

        void bf(int i2, boolean z);

        void bg(int i2, boolean z);
    }

    public c() {
        AppMethodBeat.i(192047);
        au(true);
        AppMethodBeat.o(192047);
    }

    /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ a a(ViewGroup viewGroup, int i2) {
        b bVar;
        AppMethodBeat.i(192040);
        p.h(viewGroup, "parent");
        switch (i2) {
            case 1:
                bVar = new b(this, new View(viewGroup.getContext()));
                break;
            default:
                View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.c68, viewGroup, false);
                p.g(inflate, "LayoutInflater.from(pare…rame_item, parent, false)");
                bVar = new C1883c(this, inflate, viewGroup.getHeight());
                break;
        }
        RecyclerView.v vVar = bVar;
        AppMethodBeat.o(192040);
        return vVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v] */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ void a(a aVar) {
        AppMethodBeat.i(192046);
        a aVar2 = aVar;
        p.h(aVar2, "holder");
        super.a(aVar2);
        aVar2.avR();
        AppMethodBeat.o(192046);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* bridge */ /* synthetic */ void a(a aVar, int i2) {
        AppMethodBeat.i(192044);
        a(aVar, i2);
        AppMethodBeat.o(192044);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int, java.util.List] */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ void a(a aVar, int i2, List list) {
        AppMethodBeat.i(192045);
        a aVar2 = aVar;
        p.h(aVar2, "viewHolder");
        p.h(list, "payloads");
        Object kt = j.kt(list);
        if (!(kt instanceof Boolean)) {
            kt = null;
        }
        Boolean bool = (Boolean) kt;
        if (bool == null) {
            a(aVar2, i2);
            AppMethodBeat.o(192045);
            return;
        }
        h hVar = this.GOJ.get(i2);
        p.g(hVar, "trackList[position]");
        bool.booleanValue();
        aVar2.b(hVar);
        AppMethodBeat.o(192045);
    }

    public final void hw(List<h> list) {
        int i2 = -1;
        AppMethodBeat.i(192037);
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
        AppMethodBeat.o(192037);
    }

    public final void setSelection(int i2) {
        AppMethodBeat.i(192038);
        if (i2 != this.bxP) {
            Iterator<h> it = this.GOJ.iterator();
            int i3 = 0;
            while (true) {
                if (!it.hasNext()) {
                    i3 = -1;
                    break;
                }
                if (it.next().trackIndex == this.bxP) {
                    break;
                }
                i3++;
            }
            if (i3 >= 0) {
                b(i3, Boolean.FALSE);
            }
            Iterator<h> it2 = this.GOJ.iterator();
            int i4 = 0;
            while (true) {
                if (!it2.hasNext()) {
                    i4 = -1;
                    break;
                }
                if (it2.next().trackIndex == i2) {
                    break;
                }
                i4++;
            }
            if (i4 >= 0) {
                b(i4, Boolean.TRUE);
            }
            this.bxP = i2;
        }
        AppMethodBeat.o(192038);
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final long getItemId(int i2) {
        AppMethodBeat.i(192039);
        long j2 = (long) this.GOJ.get(i2).trackIndex;
        AppMethodBeat.o(192039);
        return j2;
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemCount() {
        AppMethodBeat.i(192041);
        int size = this.GOJ.size();
        AppMethodBeat.o(192041);
        return size;
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemViewType(int i2) {
        AppMethodBeat.i(192042);
        if (this.GOJ.get(i2).isEmpty()) {
            AppMethodBeat.o(192042);
            return 1;
        }
        int itemViewType = super.getItemViewType(i2);
        AppMethodBeat.o(192042);
        return itemViewType;
    }

    private void a(a aVar, int i2) {
        AppMethodBeat.i(192043);
        p.h(aVar, "viewHolder");
        h hVar = this.GOJ.get(i2);
        p.g(hVar, "trackList[position]");
        aVar.a(hVar);
        AppMethodBeat.o(192043);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\u0006H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH&¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/thumb/EditFrameListAdapter$BaseViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "onBind", "", "trackInfo", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackThumbInfo;", "onUnbind", "onUpdateSelect", "select", "", "plugin-vlog_release"})
    public static abstract class a extends RecyclerView.v {
        public abstract void a(h hVar);

        public abstract void b(h hVar);

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            p.h(view, "itemView");
        }

        public void avR() {
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\rH\u0016J\u0018\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/thumb/EditFrameListAdapter$FrameViewHolder;", "Lcom/tencent/mm/plugin/vlog/ui/thumb/EditFrameListAdapter$BaseViewHolder;", "itemView", "Landroid/view/View;", "parentHeight", "", "(Lcom/tencent/mm/plugin/vlog/ui/thumb/EditFrameListAdapter;Landroid/view/View;I)V", "frameList", "Lcom/tencent/mm/plugin/vlog/ui/thumb/EditFrameListView;", "padding", "seekSlider", "Lcom/tencent/mm/plugin/mmsight/segment/EditSliderSeekBar;", "onBind", "", "trackInfo", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackThumbInfo;", "onUnbind", "onUpdateSelect", "select", "", "plugin-vlog_release"})
    /* renamed from: com.tencent.mm.plugin.vlog.ui.thumb.c$c  reason: collision with other inner class name */
    public final class C1883c extends a {
        final /* synthetic */ c GON;
        private final EditFrameListView GOO;
        private final EditSliderSeekBar GOP;
        private final int oh;
        private final int padding;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C1883c(c cVar, View view, int i2) {
            super(view);
            p.h(view, "itemView");
            this.GON = cVar;
            AppMethodBeat.i(192036);
            this.oh = i2;
            this.padding = com.tencent.mm.cb.a.fromDPToPix(view.getContext(), 8);
            View findViewById = view.findViewById(R.id.d9v);
            p.g(findViewById, "itemView.findViewById(R.id.frame_list)");
            this.GOO = (EditFrameListView) findViewById;
            View findViewById2 = view.findViewById(R.id.iuj);
            p.g(findViewById2, "itemView.findViewById(R.id.track_crop_slider_seek)");
            this.GOP = (EditSliderSeekBar) findViewById2;
            AppMethodBeat.o(192036);
        }

        @Override // com.tencent.mm.plugin.vlog.ui.thumb.c.a
        public final void a(h hVar) {
            AppMethodBeat.i(192033);
            p.h(hVar, "trackInfo");
            EditFrameListView editFrameListView = this.GOO;
            editFrameListView.GPa = true;
            editFrameListView.GPb = true;
            EditFrameListView editFrameListView2 = this.GOO;
            editFrameListView2.GPc = false;
            editFrameListView2.GPd = false;
            this.GOP.setMaskColor(1999383596);
            this.GOP.setEnableHapticAtEdge(true);
            this.GOO.a(hVar, this.oh, true, true);
            this.GOP.setOnSliderTouchListener(new a(this, hVar));
            if (hVar.trackIndex == this.GON.bxP) {
                this.GOP.ao(this.GOO.getShowWidth() - (this.padding * 2), this.GOO.getMinWidth(), this.padding);
            } else {
                this.GOP.ekn();
            }
            View view = this.aus;
            p.g(view, "itemView");
            View view2 = this.aus;
            p.g(view2, "itemView");
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            layoutParams.width = this.GOO.getValidWidth();
            view.setLayoutParams(layoutParams);
            EditSliderSeekBar editSliderSeekBar = this.GOP;
            ViewGroup.LayoutParams layoutParams2 = this.GOP.getLayoutParams();
            layoutParams2.width = this.GOO.getValidWidth();
            editSliderSeekBar.setLayoutParams(layoutParams2);
            EditFrameListView editFrameListView3 = this.GOO;
            ViewGroup.LayoutParams layoutParams3 = this.GOO.getLayoutParams();
            layoutParams3.width = this.GOO.getValidWidth();
            editFrameListView3.setLayoutParams(layoutParams3);
            AppMethodBeat.o(192033);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\n"}, hxF = {"com/tencent/mm/plugin/vlog/ui/thumb/EditFrameListAdapter$FrameViewHolder$onBind$1", "Lcom/tencent/mm/plugin/mmsight/segment/EditSliderSeekBar$OnSliderTouchListener;", "onDown", "", "left", "", "onMove", "rawX", "", "onUp", "plugin-vlog_release"})
        /* renamed from: com.tencent.mm.plugin.vlog.ui.thumb.c$c$a */
        public static final class a implements EditSliderSeekBar.a {
            final /* synthetic */ C1883c GOQ;
            final /* synthetic */ h GOR;
            final /* synthetic */ boolean GOS = true;
            final /* synthetic */ boolean GOT = true;

            /* JADX WARN: Incorrect types in method signature: (Lcom/tencent/mm/plugin/vlog/ui/thumb/h;Z)V */
            a(C1883c cVar, h hVar) {
                this.GOQ = cVar;
                this.GOR = hVar;
            }

            @Override // com.tencent.mm.plugin.mmsight.segment.EditSliderSeekBar.a
            public final void rf(boolean z) {
                boolean z2;
                int i2 = 1;
                AppMethodBeat.i(192030);
                this.GOR.GQb = z;
                h hVar = this.GOR;
                if (!z) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                hVar.GQa = z2;
                this.GOQ.GOO.a(this.GOR, this.GOQ.oh, this.GOS, this.GOT);
                this.GOQ.GOP.ao(this.GOQ.GOO.getShowWidth() - (this.GOQ.padding * 2), this.GOQ.GOO.getMinWidth(), this.GOQ.padding);
                if (z) {
                    this.GOQ.GOP.b(true, (float) (((int) ((((float) this.GOR.GOD) / ((float) this.GOR.GQc.GzA.GJB)) * ((float) this.GOQ.GOO.getTotalFrameWidth()))) + this.GOQ.padding));
                    this.GOQ.GOP.b(false, (float) (this.GOQ.padding + this.GOQ.GOO.getFrameWidth()));
                } else {
                    this.GOQ.GOP.b(true, (float) this.GOQ.padding);
                    this.GOQ.GOP.b(false, (float) (((int) ((((float) this.GOR.fEu()) / ((float) this.GOR.GQc.GzA.GJB)) * ((float) this.GOQ.GOO.getTotalFrameWidth()))) + this.GOQ.padding));
                }
                EditSliderSeekBar editSliderSeekBar = this.GOQ.GOP;
                ViewGroup.LayoutParams layoutParams = this.GOQ.GOP.getLayoutParams();
                layoutParams.width = this.GOQ.GOO.getShowWidth();
                editSliderSeekBar.setLayoutParams(layoutParams);
                View view = this.GOQ.aus;
                p.g(view, "itemView");
                View view2 = this.GOQ.aus;
                p.g(view2, "itemView");
                ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
                layoutParams2.width = this.GOQ.GOO.getValidWidth();
                view.setLayoutParams(layoutParams2);
                EditFrameListView editFrameListView = this.GOQ.GOO;
                ViewGroup.LayoutParams layoutParams3 = this.GOQ.GOO.getLayoutParams();
                layoutParams3.width = this.GOQ.GOO.getShowWidth();
                editFrameListView.setLayoutParams(layoutParams3);
                View view3 = this.GOQ.aus;
                p.g(view3, "itemView");
                if (!z) {
                    i2 = 0;
                }
                view3.setLayoutDirection(i2);
                this.GOQ.GOO.getTotalWidth();
                int unused = this.GOQ.padding;
                d dVar = this.GOQ.GON.GOM;
                if (dVar != null) {
                    dVar.bf(this.GOQ.lR(), z);
                    AppMethodBeat.o(192030);
                    return;
                }
                AppMethodBeat.o(192030);
            }

            @Override // com.tencent.mm.plugin.mmsight.segment.EditSliderSeekBar.a
            public final void rg(boolean z) {
                long leftSliderBound;
                long rightSliderBound;
                AppMethodBeat.i(192031);
                this.GOR.GQb = false;
                this.GOR.GQa = false;
                if (z) {
                    leftSliderBound = (long) ((((float) this.GOQ.GOP.getLeftSliderBound()) / ((float) this.GOQ.GOO.getFrameWidth())) * ((float) this.GOR.GOE));
                } else {
                    leftSliderBound = this.GOR.GOD + ((long) ((((float) this.GOQ.GOP.getLeftSliderBound()) / ((float) this.GOQ.GOO.getFrameWidth())) * ((float) (this.GOR.GQc.GzA.GJB - this.GOR.GOD))));
                }
                if (z) {
                    rightSliderBound = (long) ((((float) this.GOQ.GOP.getRightSliderBound()) / ((float) this.GOQ.GOO.getFrameWidth())) * ((float) this.GOR.GOE));
                } else {
                    rightSliderBound = this.GOR.GOD + ((long) ((((float) this.GOQ.GOP.getRightSliderBound()) / ((float) this.GOQ.GOO.getFrameWidth())) * ((float) (this.GOR.GQc.GzA.GJB - this.GOR.GOD))));
                }
                this.GOR.GOD = leftSliderBound;
                this.GOR.GOE = rightSliderBound;
                Log.d(this.GOQ.GON.TAG, "onUp, frameStartMs:" + leftSliderBound + ", frameEndMs:" + rightSliderBound);
                this.GOQ.GOO.a(this.GOR, this.GOQ.oh, this.GOS, this.GOT);
                this.GOQ.GOP.ao(this.GOQ.GOO.getShowWidth() - (this.GOQ.padding * 2), this.GOQ.GOO.getMinWidth(), this.GOQ.padding);
                EditSliderSeekBar editSliderSeekBar = this.GOQ.GOP;
                ViewGroup.LayoutParams layoutParams = this.GOQ.GOP.getLayoutParams();
                layoutParams.width = this.GOQ.GOO.getValidWidth();
                editSliderSeekBar.setLayoutParams(layoutParams);
                View view = this.GOQ.aus;
                p.g(view, "itemView");
                View view2 = this.GOQ.aus;
                p.g(view2, "itemView");
                ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
                layoutParams2.width = this.GOQ.GOO.getValidWidth();
                view.setLayoutParams(layoutParams2);
                EditFrameListView editFrameListView = this.GOQ.GOO;
                ViewGroup.LayoutParams layoutParams3 = this.GOQ.GOO.getLayoutParams();
                layoutParams3.width = this.GOQ.GOO.getValidWidth();
                editFrameListView.setLayoutParams(layoutParams3);
                View view3 = this.GOQ.aus;
                p.g(view3, "itemView");
                view3.setLayoutDirection(0);
                this.GOQ.GOO.getTotalFrameWidth();
                d dVar = this.GOQ.GON.GOM;
                if (dVar != null) {
                    dVar.bg(this.GOQ.lR(), z);
                    AppMethodBeat.o(192031);
                    return;
                }
                AppMethodBeat.o(192031);
            }

            @Override // com.tencent.mm.plugin.mmsight.segment.EditSliderSeekBar.a
            public final void c(boolean z, float f2) {
                long leftSliderBound;
                long rightSliderBound;
                AppMethodBeat.i(192032);
                if (z) {
                    leftSliderBound = (long) ((((float) this.GOQ.GOP.getLeftSliderBound()) / ((float) this.GOQ.GOO.getFrameWidth())) * ((float) this.GOR.GOE));
                } else {
                    leftSliderBound = this.GOR.GOD + ((long) ((((float) this.GOQ.GOP.getLeftSliderBound()) / ((float) this.GOQ.GOO.getFrameWidth())) * ((float) (this.GOR.GQc.GzA.GJB - this.GOR.GOD))));
                }
                if (z) {
                    rightSliderBound = (long) ((((float) this.GOQ.GOP.getRightSliderBound()) / ((float) this.GOQ.GOO.getFrameWidth())) * ((float) this.GOR.GOE));
                } else {
                    rightSliderBound = this.GOR.GOD + ((long) ((((float) this.GOQ.GOP.getRightSliderBound()) / ((float) this.GOQ.GOO.getFrameWidth())) * ((float) (this.GOR.GQc.GzA.GJB - this.GOR.GOD))));
                }
                this.GOR.GOD = leftSliderBound;
                this.GOR.GOE = rightSliderBound;
                Log.d(this.GOQ.GON.TAG, "onMove, frameStartMs:" + leftSliderBound + ", frameEndMs:" + rightSliderBound + ", leftSliderBound:" + this.GOQ.GOP.getLeftSliderBound() + ", rightSliderBound:" + this.GOQ.GOP.getRightSliderBound() + ", frameWidth:" + this.GOQ.GOO.getFrameWidth());
                View view = this.GOQ.aus;
                p.g(view, "itemView");
                View view2 = this.GOQ.aus;
                p.g(view2, "itemView");
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                int validWidth = layoutParams.width - this.GOQ.GOO.getValidWidth();
                layoutParams.width = this.GOQ.GOO.getValidWidth();
                view.setLayoutParams(layoutParams);
                d dVar = this.GOQ.GON.GOM;
                if (dVar != null) {
                    dVar.a(this.GOQ.lR(), validWidth, z, f2);
                    AppMethodBeat.o(192032);
                    return;
                }
                AppMethodBeat.o(192032);
            }
        }

        @Override // com.tencent.mm.plugin.vlog.ui.thumb.c.a
        public final void avR() {
            AppMethodBeat.i(192035);
            EditFrameListView editFrameListView = this.GOO;
            g gVar = editFrameListView.vNj;
            if (gVar != null) {
                gVar.destroy();
            }
            editFrameListView.vNj = null;
            AppMethodBeat.o(192035);
        }

        @Override // com.tencent.mm.plugin.vlog.ui.thumb.c.a
        public final void b(h hVar) {
            AppMethodBeat.i(192034);
            p.h(hVar, "trackInfo");
            if (hVar.trackIndex == this.GON.bxP) {
                View view = this.aus;
                p.g(view, "itemView");
                int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix(view.getContext(), 8);
                if (this.GOO.getShowWidth() > 0) {
                    this.GOP.ao(this.GOO.getShowWidth() - (fromDPToPix * 2), this.GOO.getMinWidth(), fromDPToPix);
                    AppMethodBeat.o(192034);
                    return;
                }
            } else {
                this.GOP.ekn();
            }
            AppMethodBeat.o(192034);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/thumb/EditFrameListAdapter$EmptyViewHolder;", "Lcom/tencent/mm/plugin/vlog/ui/thumb/EditFrameListAdapter$BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/vlog/ui/thumb/EditFrameListAdapter;Landroid/view/View;)V", "onBind", "", "trackInfo", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackThumbInfo;", "onUpdateSelect", "select", "", "plugin-vlog_release"})
    public final class b extends a {
        final /* synthetic */ c GON;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(c cVar, View view) {
            super(view);
            p.h(view, "itemView");
            this.GON = cVar;
            AppMethodBeat.i(192029);
            view.setOnClickListener(null);
            AppMethodBeat.o(192029);
        }

        @Override // com.tencent.mm.plugin.vlog.ui.thumb.c.a
        public final void a(h hVar) {
            AppMethodBeat.i(192027);
            p.h(hVar, "trackInfo");
            View view = this.aus;
            p.g(view, "itemView");
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                ViewGroup.LayoutParams layoutParams2 = new ViewGroup.LayoutParams(hVar.hEp, -1);
                View view2 = this.aus;
                p.g(view2, "itemView");
                view2.setLayoutParams(layoutParams2);
                AppMethodBeat.o(192027);
                return;
            }
            if (layoutParams.width != hVar.hEp) {
                layoutParams.width = hVar.hEp;
                View view3 = this.aus;
                p.g(view3, "itemView");
                view3.setLayoutParams(layoutParams);
            }
            AppMethodBeat.o(192027);
        }

        @Override // com.tencent.mm.plugin.vlog.ui.thumb.c.a
        public final void b(h hVar) {
            AppMethodBeat.i(192028);
            p.h(hVar, "trackInfo");
            AppMethodBeat.o(192028);
        }
    }
}
