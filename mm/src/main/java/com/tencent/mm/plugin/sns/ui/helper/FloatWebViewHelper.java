package com.tencent.mm.plugin.sns.ui.helper;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e;

public final class FloatWebViewHelper implements LifecycleObserver {
    public e EWp;
    private com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.e EWq;
    private ViewGroup EWr;

    public static FloatWebViewHelper a(e eVar, ViewGroup viewGroup) {
        AppMethodBeat.i(203903);
        FloatWebViewHelper floatWebViewHelper = new FloatWebViewHelper(eVar, viewGroup);
        AppMethodBeat.o(203903);
        return floatWebViewHelper;
    }

    private FloatWebViewHelper(e eVar, ViewGroup viewGroup) {
        this.EWp = eVar;
        this.EWr = viewGroup;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public final void onCreate(LifecycleOwner lifecycleOwner) {
        View view;
        AppMethodBeat.i(203904);
        try {
            if (this.EWp != null) {
                e eVar = this.EWp;
                ViewGroup viewGroup = this.EWr;
                if (!(viewGroup == null || eVar == null)) {
                    this.EWq = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.e(viewGroup.getContext(), eVar, viewGroup);
                    if (!(this.EWq == null || (view = this.EWq.getView()) == null || this.EWr == null)) {
                        ViewGroup viewGroup2 = (ViewGroup) view.getParent();
                        if (viewGroup2 == null) {
                            this.EWr.addView(view, this.EWr.getChildCount() - 1);
                            AppMethodBeat.o(203904);
                            return;
                        } else if (viewGroup2 != this.EWr) {
                            viewGroup2.removeView(view);
                            this.EWr.addView(view, this.EWr.getChildCount() - 1);
                        }
                    }
                }
            }
            AppMethodBeat.o(203904);
        } catch (Throwable th) {
            AppMethodBeat.o(203904);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume(LifecycleOwner lifecycleOwner) {
        AppMethodBeat.i(203905);
        try {
            if (this.EWq != null) {
                this.EWq.eWZ();
            }
            AppMethodBeat.o(203905);
        } catch (Throwable th) {
            AppMethodBeat.o(203905);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause(LifecycleOwner lifecycleOwner) {
        AppMethodBeat.i(203906);
        try {
            if (this.EWq != null) {
                this.EWq.eXa();
            }
            AppMethodBeat.o(203906);
        } catch (Throwable th) {
            AppMethodBeat.o(203906);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy(LifecycleOwner lifecycleOwner) {
        AppMethodBeat.i(203907);
        try {
            if (this.EWq != null) {
                this.EWq.eXd();
            }
            AppMethodBeat.o(203907);
        } catch (Throwable th) {
            AppMethodBeat.o(203907);
        }
    }
}
