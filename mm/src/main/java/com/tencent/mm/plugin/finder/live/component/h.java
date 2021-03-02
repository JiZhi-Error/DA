package com.tencent.mm.plugin.finder.live.component;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.component.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;
import org.libpag.PAGView;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0012\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u0015\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u0016\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u0017\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0014\u0010\u0018\u001a\u00020\u00072\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006R\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/component/SmallAnimListener;", "Lorg/libpag/PAGView$PAGViewListener;", "viewCallback", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryBubbleViewCallback;", "(Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryBubbleViewCallback;)V", "animCallback", "Lkotlin/Function0;", "", "getAnimCallback", "()Lkotlin/jvm/functions/Function0;", "setAnimCallback", "(Lkotlin/jvm/functions/Function0;)V", "rViewCallback", "Ljava/lang/ref/WeakReference;", "getRViewCallback", "()Ljava/lang/ref/WeakReference;", "setRViewCallback", "(Ljava/lang/ref/WeakReference;)V", "onAnimationCancel", "view", "Lorg/libpag/PAGView;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "setCallback", "callback", "plugin-finder_release"})
public final class h implements PAGView.PAGViewListener {
    private WeakReference<c> uhG;
    a<x> uhH;

    public h(c cVar) {
        p.h(cVar, "viewCallback");
        AppMethodBeat.i(245976);
        this.uhG = new WeakReference<>(cVar);
        AppMethodBeat.o(245976);
    }

    @Override // org.libpag.PAGView.PAGViewListener
    public final void onAnimationRepeat(PAGView pAGView) {
    }

    @Override // org.libpag.PAGView.PAGViewListener
    public final void onAnimationEnd(PAGView pAGView) {
        boolean z;
        TextView textView;
        AppMethodBeat.i(245974);
        c cVar = this.uhG.get();
        if (cVar == null) {
            z = true;
        } else {
            z = false;
        }
        c.a aVar = c.ugB;
        Log.i(c.access$getTAG$cp(), "showPrepareLottery onAnimationEnd emptyViewCallback:".concat(String.valueOf(z)));
        if (!(cVar == null || (textView = cVar.ugv) == null)) {
            textView.setVisibility(0);
        }
        a<x> aVar2 = this.uhH;
        if (aVar2 != null) {
            aVar2.invoke();
            AppMethodBeat.o(245974);
            return;
        }
        AppMethodBeat.o(245974);
    }

    @Override // org.libpag.PAGView.PAGViewListener
    public final void onAnimationCancel(PAGView pAGView) {
        AppMethodBeat.i(245975);
        boolean z = this.uhG.get() == null;
        c.a aVar = c.ugB;
        Log.i(c.access$getTAG$cp(), "showPrepareLottery onAnimationCancel emptyViewCallback:".concat(String.valueOf(z)));
        a<x> aVar2 = this.uhH;
        if (aVar2 != null) {
            aVar2.invoke();
            AppMethodBeat.o(245975);
            return;
        }
        AppMethodBeat.o(245975);
    }

    @Override // org.libpag.PAGView.PAGViewListener
    public final void onAnimationStart(PAGView pAGView) {
    }
}
