package android.support.v7.app;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.view.e;
import android.support.v7.view.b;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;

public class e extends Dialog implements c {
    private final e.a ZG;
    private d mDelegate;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        getDelegate().gB();
        super.onCreate(bundle);
        getDelegate().onCreate(bundle);
    }

    @Override // android.app.Dialog
    public void setContentView(int i2) {
        getDelegate().setContentView(i2);
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        getDelegate().setContentView(view);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        getDelegate().setContentView(view, layoutParams);
    }

    @Override // android.app.Dialog
    public <T extends View> T findViewById(int i2) {
        return (T) getDelegate().findViewById(i2);
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        getDelegate().setTitle(charSequence);
    }

    @Override // android.app.Dialog
    public void setTitle(int i2) {
        super.setTitle(i2);
        getDelegate().setTitle(getContext().getString(i2));
    }

    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        getDelegate().addContentView(view, layoutParams);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        getDelegate().onStop();
    }

    public final boolean gR() {
        return getDelegate().requestWindowFeature(1);
    }

    public void invalidateOptionsMenu() {
        getDelegate().invalidateOptionsMenu();
    }

    private d getDelegate() {
        if (this.mDelegate == null) {
            this.mDelegate = d.a(this, this);
        }
        return this.mDelegate;
    }

    @Override // android.support.v7.app.c
    public void onSupportActionModeStarted(b bVar) {
    }

    @Override // android.support.v7.app.c
    public void onSupportActionModeFinished(b bVar) {
    }

    @Override // android.support.v7.app.c
    public b onWindowStartingSupportActionMode(b.a aVar) {
        return null;
    }

    /* access modifiers changed from: package-private */
    public final boolean superDispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return android.support.v4.view.e.a(this.ZG, getWindow().getDecorView(), this, keyEvent);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public e(android.content.Context r5, int r6) {
        /*
            r4 = this;
            if (r6 != 0) goto L_0x0014
            android.util.TypedValue r0 = new android.util.TypedValue
            r0.<init>()
            android.content.res.Resources$Theme r1 = r5.getTheme()
            r2 = 2130968940(0x7f04016c, float:1.7546548E38)
            r3 = 1
            r1.resolveAttribute(r2, r0, r3)
            int r6 = r0.resourceId
        L_0x0014:
            r4.<init>(r5, r6)
            android.support.v7.app.e$1 r0 = new android.support.v7.app.e$1
            r0.<init>()
            r4.ZG = r0
            android.support.v7.app.d r0 = r4.getDelegate()
            r1 = 0
            r0.onCreate(r1)
            android.support.v7.app.d r0 = r4.getDelegate()
            r0.gC()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.app.e.<init>(android.content.Context, int):void");
    }
}
