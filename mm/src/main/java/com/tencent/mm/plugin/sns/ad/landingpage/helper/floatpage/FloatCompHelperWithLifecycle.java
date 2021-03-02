package com.tencent.mm.plugin.sns.ad.landingpage.helper.floatpage;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public abstract class FloatCompHelperWithLifecycle<INFO extends z, COMP extends m> implements LifecycleObserver {
    protected INFO DtZ;
    protected COMP Dua;
    protected ViewGroup Dub;
    protected Context mContext;

    /* access modifiers changed from: protected */
    public abstract COMP a(Context context, INFO info, ViewGroup viewGroup);

    protected FloatCompHelperWithLifecycle(INFO info, ViewGroup viewGroup) {
        this.DtZ = info;
        this.Dub = viewGroup;
        this.mContext = viewGroup != null ? viewGroup.getContext() : MMApplicationContext.getContext();
    }

    public final COMP eXj() {
        return this.Dua;
    }

    /* access modifiers changed from: protected */
    public void eX(View view) {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public final void doCreate(LifecycleOwner lifecycleOwner) {
        try {
            INFO info = this.DtZ;
            ViewGroup viewGroup = this.Dub;
            if (info == null || viewGroup == null) {
                Log.w("FloatCompHelperWithLifecycle", "the info or container is null, please check input param");
                return;
            }
            this.Dua = a(viewGroup.getContext(), info, viewGroup);
            ViewGroup viewGroup2 = this.Dub;
            COMP comp = this.Dua;
            if (viewGroup2 == null || comp == null) {
                Log.w("FloatCompHelperWithLifecycle", "the comp is null, please check config!!!!");
                return;
            }
            View view = comp.getView();
            if (view != null) {
                eX(view);
                com.tencent.mm.plugin.sns.ad.i.m.a(viewGroup2, view, viewGroup2.getChildCount() - 1);
            }
        } catch (Throwable th) {
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void doResume(LifecycleOwner lifecycleOwner) {
        try {
            if (this.Dua != null) {
                this.Dua.eWZ();
            }
        } catch (Throwable th) {
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void doPause(LifecycleOwner lifecycleOwner) {
        try {
            if (this.Dua != null) {
                this.Dua.eXa();
            }
        } catch (Throwable th) {
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void doDestroy(LifecycleOwner lifecycleOwner) {
        try {
            if (this.Dua != null) {
                this.Dua.eXd();
            }
        } catch (Throwable th) {
        }
    }
}
