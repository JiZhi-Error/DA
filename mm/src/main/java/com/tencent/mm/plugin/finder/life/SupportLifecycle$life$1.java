package com.tencent.mm.plugin.finder.life;

import android.arch.lifecycle.LifecycleOwner;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.life.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragmentActivity;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/finder/life/SupportLifecycle$life$1", "Lcom/tencent/mm/plugin/finder/life/UILifecycleObserver;", "onCreate", "", "var1", "Landroid/arch/lifecycle/LifecycleOwner;", "onDestroy", "onPause", "onResume", "onStart", "onStop", "plugin-finder_release"})
public final class SupportLifecycle$life$1 implements UILifecycleObserver {
    final /* synthetic */ MMFragmentActivity grG;
    final /* synthetic */ a uff;
    final /* synthetic */ UILifecycleObserver ufg;

    SupportLifecycle$life$1(a aVar, UILifecycleObserver uILifecycleObserver, MMFragmentActivity mMFragmentActivity) {
        this.uff = aVar;
        this.ufg = uILifecycleObserver;
        this.grG = mMFragmentActivity;
    }

    @Override // com.tencent.mm.plugin.finder.life.UILifecycleObserver
    public final void onCreate(LifecycleOwner lifecycleOwner) {
        AppMethodBeat.i(166292);
        p.h(lifecycleOwner, "var1");
        this.uff.ueU = a.EnumC1174a.ON_CREATE;
        UILifecycleObserver uILifecycleObserver = this.ufg;
        if (uILifecycleObserver != null) {
            uILifecycleObserver.onCreate(lifecycleOwner);
            AppMethodBeat.o(166292);
            return;
        }
        AppMethodBeat.o(166292);
    }

    @Override // com.tencent.mm.plugin.finder.life.UILifecycleObserver
    public final void onStart(LifecycleOwner lifecycleOwner) {
        AppMethodBeat.i(166293);
        p.h(lifecycleOwner, "var1");
        this.uff.ueU = a.EnumC1174a.ON_START;
        UILifecycleObserver uILifecycleObserver = this.ufg;
        if (uILifecycleObserver != null) {
            uILifecycleObserver.onStart(lifecycleOwner);
            AppMethodBeat.o(166293);
            return;
        }
        AppMethodBeat.o(166293);
    }

    @Override // com.tencent.mm.plugin.finder.life.UILifecycleObserver
    public final void onResume(LifecycleOwner lifecycleOwner) {
        AppMethodBeat.i(166294);
        p.h(lifecycleOwner, "var1");
        this.uff.ueU = a.EnumC1174a.ON_RESUME;
        UILifecycleObserver uILifecycleObserver = this.ufg;
        if (uILifecycleObserver != null) {
            uILifecycleObserver.onResume(lifecycleOwner);
        }
        Log.v("Finder.EventObserver", "onResume life " + this.grG + " this" + this.uff);
        AppMethodBeat.o(166294);
    }

    @Override // com.tencent.mm.plugin.finder.life.UILifecycleObserver
    public final void onPause(LifecycleOwner lifecycleOwner) {
        AppMethodBeat.i(166295);
        p.h(lifecycleOwner, "var1");
        this.uff.ueU = a.EnumC1174a.ON_PAUSE;
        UILifecycleObserver uILifecycleObserver = this.ufg;
        if (uILifecycleObserver != null) {
            uILifecycleObserver.onPause(lifecycleOwner);
        }
        Log.v("Finder.EventObserver", "onPause life " + this.grG + " this" + this.uff);
        AppMethodBeat.o(166295);
    }

    @Override // com.tencent.mm.plugin.finder.life.UILifecycleObserver
    public final void onStop(LifecycleOwner lifecycleOwner) {
        AppMethodBeat.i(166296);
        p.h(lifecycleOwner, "var1");
        this.uff.ueU = a.EnumC1174a.ON_STOP;
        UILifecycleObserver uILifecycleObserver = this.ufg;
        if (uILifecycleObserver != null) {
            uILifecycleObserver.onStop(lifecycleOwner);
            AppMethodBeat.o(166296);
            return;
        }
        AppMethodBeat.o(166296);
    }

    @Override // com.tencent.mm.plugin.finder.life.UILifecycleObserver
    public final void onDestroy(LifecycleOwner lifecycleOwner) {
        AppMethodBeat.i(166297);
        p.h(lifecycleOwner, "var1");
        this.uff.ueU = a.EnumC1174a.ON_DESTROY;
        UILifecycleObserver uILifecycleObserver = this.ufg;
        if (uILifecycleObserver != null) {
            uILifecycleObserver.onDestroy(lifecycleOwner);
        }
        UILifecycleObserver uILifecycleObserver2 = this.uff.ueW;
        if (uILifecycleObserver2 != null) {
            Log.i("Finder.EventObserver", "auto life remove " + this.grG + " this" + this.uff);
            this.grG.getLifecycle().removeObserver(uILifecycleObserver2);
            this.uff.ueW = null;
            AppMethodBeat.o(166297);
            return;
        }
        AppMethodBeat.o(166297);
    }
}
