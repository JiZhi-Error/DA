package android.support.v4.app;

public final class e {
    final f<?> mHost;

    e(f<?> fVar) {
        this.mHost = fVar;
    }

    public final Fragment findFragmentByWho(String str) {
        return this.mHost.mFragmentManager.findFragmentByWho(str);
    }

    public final void noteStateNotSaved() {
        this.mHost.mFragmentManager.noteStateNotSaved();
    }

    public final boolean execPendingActions() {
        return this.mHost.mFragmentManager.execPendingActions();
    }
}
