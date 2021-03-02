package com.tencent.mm.plugin.finder.live.plugin;

import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;
import org.libpag.PAGView;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0016\u001a\u00020\u000b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u0019\u001a\u00020\u000b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u001a\u001a\u00020\u000b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u001b\u001a\u00020\u000b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0014\u0010\u001c\u001a\u00020\u000b2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000b0\nR\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/plugin/BigAnimListener;", "Lorg/libpag/PAGView$PAGViewListener;", "plugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveLotteryCardPlugin;", "(Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveLotteryCardPlugin;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "animCallback", "Lkotlin/Function0;", "", "getAnimCallback", "()Lkotlin/jvm/functions/Function0;", "setAnimCallback", "(Lkotlin/jvm/functions/Function0;)V", "rPlugin", "Ljava/lang/ref/WeakReference;", "getRPlugin", "()Ljava/lang/ref/WeakReference;", "setRPlugin", "(Ljava/lang/ref/WeakReference;)V", "onAnimationCancel", "view", "Lorg/libpag/PAGView;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "setCallback", "callback", "plugin-finder_release"})
public final class a implements PAGView.PAGViewListener {
    private final String TAG = "FinderLiveLotteryCardPlugin";
    private kotlin.g.a.a<x> uhH;
    private WeakReference<an> ulz;

    public a(an anVar) {
        p.h(anVar, "plugin");
        AppMethodBeat.i(246367);
        this.ulz = new WeakReference<>(anVar);
        AppMethodBeat.o(246367);
    }

    public final void N(kotlin.g.a.a<x> aVar) {
        AppMethodBeat.i(246363);
        p.h(aVar, "callback");
        this.uhH = aVar;
        AppMethodBeat.o(246363);
    }

    @Override // org.libpag.PAGView.PAGViewListener
    public final void onAnimationRepeat(PAGView pAGView) {
    }

    @Override // org.libpag.PAGView.PAGViewListener
    public final void onAnimationEnd(PAGView pAGView) {
        PAGView pAGView2;
        FrameLayout frameLayout;
        AppMethodBeat.i(246364);
        an anVar = this.ulz.get();
        Log.i(this.TAG, "BigAnimListener onAnimationEnd ViewCallback is null:" + (anVar == null));
        if (!(anVar == null || (frameLayout = anVar.urR) == null)) {
            frameLayout.setVisibility(8);
        }
        if (!(anVar == null || (pAGView2 = anVar.urS) == null)) {
            pAGView2.setVisibility(8);
        }
        kotlin.g.a.a<x> aVar = this.uhH;
        if (aVar != null) {
            aVar.invoke();
            AppMethodBeat.o(246364);
            return;
        }
        AppMethodBeat.o(246364);
    }

    @Override // org.libpag.PAGView.PAGViewListener
    public final void onAnimationCancel(PAGView pAGView) {
        PAGView pAGView2;
        FrameLayout frameLayout;
        AppMethodBeat.i(246365);
        an anVar = this.ulz.get();
        Log.i(this.TAG, "BigAnimListener onAnimationCancel ViewCallback is null:" + (anVar == null));
        if (!(anVar == null || (frameLayout = anVar.urR) == null)) {
            frameLayout.setVisibility(8);
        }
        if (!(anVar == null || (pAGView2 = anVar.urS) == null)) {
            pAGView2.setVisibility(8);
        }
        kotlin.g.a.a<x> aVar = this.uhH;
        if (aVar != null) {
            aVar.invoke();
            AppMethodBeat.o(246365);
            return;
        }
        AppMethodBeat.o(246365);
    }

    @Override // org.libpag.PAGView.PAGViewListener
    public final void onAnimationStart(PAGView pAGView) {
        boolean z;
        PAGView pAGView2;
        PAGView pAGView3;
        FrameLayout frameLayout;
        AppMethodBeat.i(246366);
        an anVar = this.ulz.get();
        String str = this.TAG;
        StringBuilder sb = new StringBuilder("BigAnimListener onAnimationStart ViewCallback is null:");
        if (anVar == null) {
            z = true;
        } else {
            z = false;
        }
        Log.i(str, sb.append(z).toString());
        if (!(anVar == null || (frameLayout = anVar.urR) == null)) {
            frameLayout.setVisibility(0);
        }
        if (!(anVar == null || (pAGView3 = anVar.urS) == null)) {
            pAGView3.setVisibility(0);
        }
        if (anVar == null || (pAGView2 = anVar.urS) == null) {
            AppMethodBeat.o(246366);
            return;
        }
        pAGView2.flush();
        AppMethodBeat.o(246366);
    }
}
