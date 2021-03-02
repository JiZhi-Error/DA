package com.tencent.mm.plugin.festival.finder;

import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import com.tencent.mm.live.c.b;
import com.tencent.mm.plugin.finder.live.plugin.d;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0017J\b\u0010\t\u001a\u00020\bH\u0017J\b\u0010\n\u001a\u00020\bH\u0017¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/festival/finder/FestivalFinderBaseLivePlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "mount", "", "recoveryScreen", "unMount", "plugin-festival_release"})
public abstract class p extends d {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public p(ViewGroup viewGroup, b bVar) {
        super(viewGroup, bVar);
        kotlin.g.b.p.h(viewGroup, "root");
        kotlin.g.b.p.h(bVar, "statusMonitor");
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d
    public void dCW() {
        if (this.hwr.getAlpha() == 1.0f) {
            ObjectAnimator objectAnimator = this.ulY;
            if (objectAnimator != null) {
                objectAnimator.cancel();
            }
            this.hwr.setAlpha(1.0f);
            super.rg(this.ulV);
            return;
        }
        super.dCW();
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d, com.tencent.mm.live.c.a
    public void mount() {
        super.mount();
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d, com.tencent.mm.live.c.a
    public void unMount() {
        super.unMount();
    }
}
