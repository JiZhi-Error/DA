package com.tencent.mm.plugin.finder.convert;

import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.model.al;
import com.tencent.mm.protocal.protobuf.axk;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\t\u001a\u00020\nH\u0016J@\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00132\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015H\u0016J \u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\nH\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/FinderLiveSubTagConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderLiveTagData;", "selectedTagInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTagInfo;", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveTagInfo;)V", "getSelectedTagInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveTagInfo;", "setSelectedTagInfo", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
public final class at extends e<al> {
    public axk tEC;

    public at(axk axk) {
        this.tEC = axk;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.view.recyclerview.a, int, int, boolean, java.util.List] */
    @Override // com.tencent.mm.view.recyclerview.e
    public final /* synthetic */ void a(h hVar, al alVar, int i2, int i3, boolean z, List list) {
        axk axk;
        AppMethodBeat.i(243156);
        al alVar2 = alVar;
        p.h(hVar, "holder");
        p.h(alVar2, "item");
        TextView textView = (TextView) hVar.Mn(R.id.cxv);
        if (textView != null) {
            textView.setText(alVar2.uOy.qHk);
        }
        axk axk2 = this.tEC;
        if (axk2 == null || (axk = axk2.LHU) == null || axk.LHS != alVar2.uOy.LHS) {
            LinearLayout linearLayout = (LinearLayout) hVar.Mn(R.id.cxw);
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
                AppMethodBeat.o(243156);
                return;
            }
            AppMethodBeat.o(243156);
            return;
        }
        LinearLayout linearLayout2 = (LinearLayout) hVar.Mn(R.id.cxw);
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(0);
            AppMethodBeat.o(243156);
            return;
        }
        AppMethodBeat.o(243156);
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final int getLayoutId() {
        return R.layout.afe;
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final void a(RecyclerView recyclerView, h hVar, int i2) {
        AppMethodBeat.i(243155);
        p.h(recyclerView, "recyclerView");
        p.h(hVar, "holder");
        AppMethodBeat.o(243155);
    }
}
