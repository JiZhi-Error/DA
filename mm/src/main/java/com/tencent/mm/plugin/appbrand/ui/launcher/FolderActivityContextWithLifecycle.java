package com.tencent.mm.plugin.appbrand.ui.launcher;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.ContextWrapper;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.plugin.appbrand.widget.i.a;
import com.tencent.mm.ui.MMActivity;

public abstract class FolderActivityContextWithLifecycle extends ContextWrapper implements LifecycleObserver, a {
    public void S(Intent intent) {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onActivityDidResume() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onActivityWillPause() {
    }

    public FolderActivityContextWithLifecycle(MMActivity mMActivity) {
        super(mMActivity);
    }

    /* access modifiers changed from: protected */
    public final MMActivity getActivity() {
        return (MMActivity) getBaseContext();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public final void onActivityDidCreateCall() {
        S(((MMActivity) getBaseContext()).getIntent());
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onActivityWillDestroy() {
        View findViewById = ((MMActivity) getBaseContext()).findViewById(16908290);
        if (findViewById instanceof ViewGroup) {
            a.m((ViewGroup) findViewById);
        }
    }
}
