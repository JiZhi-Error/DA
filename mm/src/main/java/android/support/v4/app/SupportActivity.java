package android.support.v4.app;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.ReportFragment;
import android.os.Bundle;
import android.support.v4.e.n;
import android.support.v4.view.e;
import android.view.KeyEvent;
import android.view.View;
import com.tencent.mm.hellhoundlib.activities.HellActivity;

public class SupportActivity extends HellActivity implements LifecycleOwner, e.a {
    private n<Class<? extends a>, a> mExtraDataMap = new n<>();
    private LifecycleRegistry mLifecycleRegistry = new LifecycleRegistry(this);

    public static class a {
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: android.support.v4.e.n<java.lang.Class<? extends android.support.v4.app.SupportActivity$a>, android.support.v4.app.SupportActivity$a> */
    /* JADX WARN: Multi-variable type inference failed */
    public void putExtraData(a aVar) {
        this.mExtraDataMap.put(aVar.getClass(), aVar);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ReportFragment.injectIfNeededIn(this);
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        this.mLifecycleRegistry.markState(Lifecycle.State.CREATED);
        super.onSaveInstanceState(bundle);
    }

    public <T extends a> T getExtraData(Class<T> cls) {
        return (T) this.mExtraDataMap.get(cls);
    }

    @Override // android.arch.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Override // android.support.v4.view.e.a
    public boolean superDispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !e.a(decorView, keyEvent)) {
            return super.dispatchKeyShortcutEvent(keyEvent);
        }
        return true;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !e.a(decorView, keyEvent)) {
            return e.a(this, decorView, this, keyEvent);
        }
        return true;
    }
}
