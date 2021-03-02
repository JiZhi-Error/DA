package com.tencent.mm.emoji.panel.a;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.emoji.b.b.aa;
import com.tencent.mm.emoji.b.b.ac;
import com.tencent.mm.emoji.b.b.q;
import com.tencent.mm.emoji.b.b.w;
import java.util.ArrayList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001:\u0001$B\u0005¢\u0006\u0002\u0010\u0003J\u0014\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0013J\u0016\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000eJ\u0006\u0010\u0018\u001a\u00020\u0011J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001a\u001a\u00020\u0016J\b\u0010\u001b\u001a\u00020\u0016H\u0016J\u0010\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u0016H\u0016J\u001c\u0010\u001d\u001a\u00020\u00112\n\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u001a\u001a\u00020\u0016H\u0016J\u001c\u0010\u001f\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0016H\u0016J\u0014\u0010#\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0013R\u000e\u0010\u0004\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, hxF = {"Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelItemAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "()V", "TAG", "", "clickListener", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "getClickListener", "()Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "setClickListener", "(Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "itemList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "Lkotlin/collections/ArrayList;", "addData", "", "items", "", "addDataByIndex", FirebaseAnalytics.b.INDEX, "", "item", "clearData", "getItem", "position", "getItemCount", "getItemViewType", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateData", "ListenerToAdapter", "plugin-emojisdk_release"})
public class h extends RecyclerView.a<q<?>> {
    private final String TAG = "MicroMsg.EmojiPanelItemAdapter";
    public final ArrayList<ac> gUV = new ArrayList<>();
    public n haK;

    public h() {
        AppMethodBeat.i(105665);
        AppMethodBeat.o(105665);
    }

    /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
    @Override // android.support.v7.widget.RecyclerView.a
    public /* synthetic */ q<?> a(ViewGroup viewGroup, int i2) {
        AppMethodBeat.i(105662);
        q<?> f2 = f(viewGroup, i2);
        AppMethodBeat.o(105662);
        return f2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
    @Override // android.support.v7.widget.RecyclerView.a
    public /* bridge */ /* synthetic */ void a(q<?> qVar, int i2) {
        AppMethodBeat.i(105664);
        a(qVar, i2);
        AppMethodBeat.o(105664);
    }

    public final void ad(List<? extends ac> list) {
        AppMethodBeat.i(105656);
        p.h(list, "items");
        this.gUV.clear();
        this.gUV.addAll(list);
        AppMethodBeat.o(105656);
    }

    public final void a(int i2, ac acVar) {
        AppMethodBeat.i(105657);
        p.h(acVar, "item");
        this.gUV.add(i2, acVar);
        AppMethodBeat.o(105657);
    }

    public final ac pm(int i2) {
        AppMethodBeat.i(105658);
        ac acVar = (ac) j.L(this.gUV, i2);
        AppMethodBeat.o(105658);
        return acVar;
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemCount() {
        AppMethodBeat.i(105659);
        int size = this.gUV.size();
        AppMethodBeat.o(105659);
        return size;
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public int getItemViewType(int i2) {
        AppMethodBeat.i(105660);
        ac pm = pm(i2);
        if (pm != null) {
            int i3 = pm.type;
            AppMethodBeat.o(105660);
            return i3;
        }
        AppMethodBeat.o(105660);
        return 0;
    }

    public q<?> f(ViewGroup viewGroup, int i2) {
        AppMethodBeat.i(105661);
        p.h(viewGroup, "parent");
        q qVar = q.gYK;
        com.tencent.mm.emoji.b.b.p pk = q.pk(i2);
        if (pk != null) {
            q<?> d2 = pk.d(viewGroup);
            AppMethodBeat.o(105661);
            return d2;
        }
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        switch (i2) {
            case 1:
                View inflate = from.inflate(R.layout.a2a, viewGroup, false);
                p.g(inflate, "itemView");
                ac acVar = new ac(inflate, this.haK);
                AppMethodBeat.o(105661);
                return acVar;
            case 2:
                View inflate2 = from.inflate(R.layout.a2b, viewGroup, false);
                p.g(inflate2, "itemView");
                ae aeVar = new ae(inflate2, this.haK);
                AppMethodBeat.o(105661);
                return aeVar;
            case 3:
                View inflate3 = from.inflate(R.layout.btk, viewGroup, false);
                p.g(inflate3, "itemView");
                l lVar = new l(inflate3, this.haK);
                AppMethodBeat.o(105661);
                return lVar;
            case 4:
                View inflate4 = from.inflate(R.layout.a26, viewGroup, false);
                p.g(inflate4, "itemView");
                m mVar = new m(inflate4, this.haK);
                AppMethodBeat.o(105661);
                return mVar;
            case 5:
                View inflate5 = from.inflate(R.layout.btl, viewGroup, false);
                p.g(inflate5, "itemView");
                q<?> qVar2 = new q<>(inflate5, this.haK);
                AppMethodBeat.o(105661);
                return qVar2;
            case 6:
                View inflate6 = from.inflate(R.layout.a25, viewGroup, false);
                p.g(inflate6, "itemView");
                b bVar = new b(inflate6, this.haK);
                AppMethodBeat.o(105661);
                return bVar;
            case 7:
                View inflate7 = from.inflate(R.layout.a23, viewGroup, false);
                p.g(inflate7, "itemView");
                a aVar = new a(inflate7, this.haK);
                AppMethodBeat.o(105661);
                return aVar;
            default:
                View inflate8 = from.inflate(R.layout.a24, viewGroup, false);
                p.g(inflate8, "itemView");
                k kVar = new k(inflate8, this.haK);
                AppMethodBeat.o(105661);
                return kVar;
        }
    }

    public void a(q<?> qVar, int i2) {
        AppMethodBeat.i(105663);
        p.h(qVar, "holder");
        ac acVar = this.gUV.get(i2);
        p.g(acVar, "itemList[position]");
        qVar.a(acVar);
        AppMethodBeat.o(105663);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\bH\u0016J\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelItemAdapter$ListenerToAdapter;", "Lcom/tencent/mm/emoji/model/panel/PanelGroupDataListener;", "adapter", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelItemAdapter;", "(Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelItemAdapter;)V", "onGroupItemsChange", "", "start", "", "count", "onGroupItemsInsert", "onGroupItemsMoved", "from", "to", "onGroupItemsRemove", "onUpdateData", "data", "Lcom/tencent/mm/emoji/model/panel/IPanelItemGroup;", "plugin-emojisdk_release"})
    public static final class a implements aa {
        private final h haQ;

        public a(h hVar) {
            p.h(hVar, "adapter");
            AppMethodBeat.i(105655);
            this.haQ = hVar;
            AppMethodBeat.o(105655);
        }

        @Override // com.tencent.mm.emoji.b.b.s
        public final void b(w wVar) {
            AppMethodBeat.i(105650);
            p.h(wVar, "data");
            this.haQ.ad(wVar.avn());
            AppMethodBeat.o(105650);
        }

        @Override // com.tencent.mm.emoji.b.b.x
        public final void cD(int i2, int i3) {
            AppMethodBeat.i(105651);
            this.haQ.as(i2, i3);
            AppMethodBeat.o(105651);
        }

        @Override // com.tencent.mm.emoji.b.b.x
        public final void cE(int i2, int i3) {
            AppMethodBeat.i(105652);
            this.haQ.at(i2, i3);
            AppMethodBeat.o(105652);
        }

        @Override // com.tencent.mm.emoji.b.b.x
        public final void cF(int i2, int i3) {
            AppMethodBeat.i(105653);
            this.haQ.ar(i2, i3);
            AppMethodBeat.o(105653);
        }

        @Override // com.tencent.mm.emoji.b.b.x
        public final void cG(int i2, int i3) {
            AppMethodBeat.i(105654);
            this.haQ.aq(i2, i3);
            AppMethodBeat.o(105654);
        }
    }
}
