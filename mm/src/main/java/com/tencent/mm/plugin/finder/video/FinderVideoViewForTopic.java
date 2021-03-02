package com.tencent.mm.plugin.finder.video;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PInt;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J \u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0014R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/finder/video/FinderVideoViewForTopic;", "Lcom/tencent/mm/plugin/finder/video/FinderVideoView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "firstCacheTimeStep", "", "calcDownloadRange", "", "playTime", "start", "Lcom/tencent/mm/pointers/PInt;", "end", "plugin-finder_release"})
public final class FinderVideoViewForTopic extends FinderVideoView {
    private int wgg = 3;

    public FinderVideoViewForTopic(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.tencent.mm.plugin.finder.video.FinderVideoView, com.tencent.mm.modelvideo.MMVideoView
    public final boolean a(int i2, PInt pInt, PInt pInt2) {
        AppMethodBeat.i(254403);
        p.h(pInt, "start");
        p.h(pInt2, "end");
        pInt.value = Math.max(i2, this.jqc);
        if (this.jpW == 1) {
            pInt.value = i2;
            pInt2.value = pInt.value + this.wgg + 1;
        }
        this.wgg += this.jqh.jqm;
        if (this.jpW == 2) {
            pInt.value = i2 - 8;
            if (pInt.value < 0) {
                pInt.value = 0;
            }
            pInt2.value = pInt.value + this.jqd + 8;
        }
        if (this.jpW == 3 || this.jpW == 4) {
            pInt.value = this.jqc;
            pInt2.value = this.jqd + i2 + 1 + this.jqh.jqn;
            pInt2.value = this.jpY + 1;
        }
        if (pInt2.value >= this.jpY + 1) {
            pInt2.value = this.jpY + 1;
        }
        if (pInt2.value < pInt.value) {
            pInt2.value = pInt.value + this.jqh.jqn;
            start();
            AppMethodBeat.o(254403);
        } else {
            AppMethodBeat.o(254403);
        }
        return true;
    }
}
