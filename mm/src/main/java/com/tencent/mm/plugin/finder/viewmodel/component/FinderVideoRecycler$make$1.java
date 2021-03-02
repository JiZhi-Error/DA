package com.tencent.mm.plugin.finder.viewmodel.component;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderVideoRecycler;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.a.j;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.z;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0007¨\u0006\u0004"}, hxF = {"com/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler$make$1", "Landroid/arch/lifecycle/LifecycleObserver;", "onDestroy", "", "plugin-finder_release"})
public final class FinderVideoRecycler$make$1 implements LifecycleObserver {
    final /* synthetic */ String $key;
    final /* synthetic */ AppCompatActivity uQi;
    final /* synthetic */ FinderVideoRecycler wBg;

    FinderVideoRecycler$make$1(FinderVideoRecycler finderVideoRecycler, AppCompatActivity appCompatActivity, String str) {
        this.wBg = finderVideoRecycler;
        this.uQi = appCompatActivity;
        this.$key = str;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        AppMethodBeat.i(256048);
        FinderVideoRecycler finderVideoRecycler = this.wBg;
        finderVideoRecycler.wBc = finderVideoRecycler.wBc - 1;
        if (this.wBg.wBc == 0) {
            FinderVideoRecycler.c(this.wBg);
        } else {
            FinderVideoRecycler finderVideoRecycler2 = this.wBg;
            AppCompatActivity appCompatActivity = this.uQi;
            p.h(appCompatActivity, "context");
            j.a((Iterable) finderVideoRecycler2.wAW, (b) new FinderVideoRecycler.p(appCompatActivity));
            z.d dVar = new z.d();
            dVar.SYE = 0;
            finderVideoRecycler2.I(new FinderVideoRecycler.q(finderVideoRecycler2, appCompatActivity, dVar));
            Log.i("Finder.VideoRecycler", "[removeByContext] simpleName=" + appCompatActivity.getClass().getSimpleName() + " removeCount=" + dVar.SYE + " videoCount=" + FinderVideoRecycler.a(finderVideoRecycler2));
        }
        this.wBg.wBa.remove(this.$key);
        this.uQi.getLifecycle().removeObserver(this);
        AppMethodBeat.o(256048);
    }
}
