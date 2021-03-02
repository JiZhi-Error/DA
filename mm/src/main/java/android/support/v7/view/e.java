package android.support.v7.view;

import android.content.Context;
import android.support.v7.view.b;
import android.support.v7.view.menu.h;
import android.support.v7.widget.ActionBarContextView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.lang.ref.WeakReference;

public final class e extends b implements h.a {
    private h aaQ;
    private b.a aaR;
    private WeakReference<View> aaS;
    private ActionBarContextView aau;
    private boolean adH;
    private Context mContext;
    private boolean mFinished;

    public e(Context context, ActionBarContextView actionBarContextView, b.a aVar, boolean z) {
        this.mContext = context;
        this.aau = actionBarContextView;
        this.aaR = aVar;
        h hVar = new h(actionBarContextView.getContext());
        hVar.agw = 1;
        this.aaQ = hVar;
        this.aaQ.a(this);
        this.adH = z;
    }

    @Override // android.support.v7.view.b
    public final void setTitle(CharSequence charSequence) {
        this.aau.setTitle(charSequence);
    }

    @Override // android.support.v7.view.b
    public final void setSubtitle(CharSequence charSequence) {
        this.aau.setSubtitle(charSequence);
    }

    @Override // android.support.v7.view.b
    public final void setTitle(int i2) {
        setTitle(this.mContext.getString(i2));
    }

    @Override // android.support.v7.view.b
    public final void setSubtitle(int i2) {
        setSubtitle(this.mContext.getString(i2));
    }

    @Override // android.support.v7.view.b
    public final void setTitleOptionalHint(boolean z) {
        super.setTitleOptionalHint(z);
        this.aau.setTitleOptional(z);
    }

    @Override // android.support.v7.view.b
    public final boolean isTitleOptional() {
        return this.aau.ahO;
    }

    @Override // android.support.v7.view.b
    public final void setCustomView(View view) {
        this.aau.setCustomView(view);
        this.aaS = view != null ? new WeakReference<>(view) : null;
    }

    @Override // android.support.v7.view.b
    public final void invalidate() {
        this.aaR.b(this, this.aaQ);
    }

    @Override // android.support.v7.view.b
    public final void finish() {
        if (!this.mFinished) {
            this.mFinished = true;
            this.aau.sendAccessibilityEvent(32);
            this.aaR.a(this);
        }
    }

    @Override // android.support.v7.view.b
    public final Menu getMenu() {
        return this.aaQ;
    }

    @Override // android.support.v7.view.b
    public final CharSequence getTitle() {
        return this.aau.getTitle();
    }

    @Override // android.support.v7.view.b
    public final CharSequence getSubtitle() {
        return this.aau.getSubtitle();
    }

    @Override // android.support.v7.view.b
    public final View getCustomView() {
        if (this.aaS != null) {
            return this.aaS.get();
        }
        return null;
    }

    @Override // android.support.v7.view.b
    public final MenuInflater getMenuInflater() {
        return new g(this.aau.getContext());
    }

    @Override // android.support.v7.view.menu.h.a
    public final boolean a(h hVar, MenuItem menuItem) {
        return this.aaR.a(this, menuItem);
    }

    @Override // android.support.v7.view.menu.h.a
    public final void b(h hVar) {
        invalidate();
        this.aau.showOverflowMenu();
    }
}
