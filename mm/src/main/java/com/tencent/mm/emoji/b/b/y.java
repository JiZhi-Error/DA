package com.tencent.mm.emoji.b.b;

import android.support.v7.widget.RecyclerView;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b&\u0018\u00002\u00020\u0001B\u001d\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u0018\u0010\u000f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u0010\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u0011\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u0012\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016R\u0012\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/emoji/model/panel/PanelDataAdapterListener;", "Lcom/tencent/mm/emoji/model/panel/PanelDataListener;", "groupAdapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "tabAdapter", "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/support/v7/widget/RecyclerView$Adapter;)V", "onGroupChange", "", "start", "", "count", "onGroupInsert", "onGroupMoved", "from", "to", "onGroupRemove", "onTabChange", "onTabInsert", "onTabRemove", "plugin-emojisdk_release"})
public abstract class y implements z {
    private final RecyclerView.a<?> gYO;
    private final RecyclerView.a<?> gYP;

    public y(RecyclerView.a<?> aVar, RecyclerView.a<?> aVar2) {
        p.h(aVar, "groupAdapter");
        p.h(aVar2, "tabAdapter");
        this.gYO = aVar;
        this.gYP = aVar2;
    }

    @Override // com.tencent.mm.emoji.b.b.r
    public final void cA(int i2, int i3) {
        this.gYO.as(i2, i3);
    }

    @Override // com.tencent.mm.emoji.b.b.r
    public final void cB(int i2, int i3) {
        this.gYO.aq(i2, i3);
    }

    @Override // com.tencent.mm.emoji.b.b.r
    public final void cC(int i2, int i3) {
        this.gYO.at(i2, i3);
    }

    @Override // com.tencent.mm.emoji.b.b.an
    public final void cH(int i2, int i3) {
        this.gYP.as(i2, i3);
    }

    @Override // com.tencent.mm.emoji.b.b.an
    public final void cI(int i2, int i3) {
        this.gYP.aq(i2, i3);
    }

    @Override // com.tencent.mm.emoji.b.b.an
    public final void cJ(int i2, int i3) {
        this.gYP.at(i2, i3);
    }
}
