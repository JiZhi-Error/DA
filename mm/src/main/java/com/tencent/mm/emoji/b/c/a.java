package com.tencent.mm.emoji.b.c;

import com.tencent.mm.vending.e.b;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\r\u001a\u00020\u000eH\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\b\"\u0004\b\t\u0010\nR\u0019\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/emoji/model/search/AbsEmojiSuggest;", "Lcom/tencent/mm/emoji/model/search/IEmojiSuggest;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "(Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;)V", "isAlive", "", "()Z", "setAlive", "(Z)V", "getLifeCycleKeeper", "()Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "dead", "", "plugin-emojisdk_release"})
public abstract class a implements j, com.tencent.mm.vending.e.a {
    boolean dbi = true;
    private final b<com.tencent.mm.vending.e.a> gZm;

    public a(b<com.tencent.mm.vending.e.a> bVar) {
        this.gZm = bVar;
        b<com.tencent.mm.vending.e.a> bVar2 = this.gZm;
        if (bVar2 != null) {
            bVar2.keep(this);
        }
    }

    @Override // com.tencent.mm.vending.e.a
    public void dead() {
        this.dbi = false;
    }
}
