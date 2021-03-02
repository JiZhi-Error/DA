package android.support.v7.view.menu;

import android.content.Context;
import android.support.v4.a.a.b;
import android.support.v4.view.b;
import android.support.v7.view.menu.k;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.view.View;

/* access modifiers changed from: package-private */
public final class l extends k {
    l(Context context, b bVar) {
        super(context, bVar);
    }

    /* access modifiers changed from: package-private */
    @Override // android.support.v7.view.menu.k
    public final k.a a(ActionProvider actionProvider) {
        return new a(this.mContext, actionProvider);
    }

    class a extends k.a implements ActionProvider.VisibilityListener {
        b.AbstractC0037b ahb;

        public a(Context context, ActionProvider actionProvider) {
            super(context, actionProvider);
        }

        @Override // android.support.v4.view.b
        public final View onCreateActionView(MenuItem menuItem) {
            return this.agY.onCreateActionView(menuItem);
        }

        @Override // android.support.v4.view.b
        public final boolean overridesItemVisibility() {
            return this.agY.overridesItemVisibility();
        }

        @Override // android.support.v4.view.b
        public final boolean isVisible() {
            return this.agY.isVisible();
        }

        @Override // android.support.v4.view.b
        public final void a(b.AbstractC0037b bVar) {
            this.ahb = bVar;
            this.agY.setVisibilityListener(this);
        }

        public final void onActionProviderVisibilityChanged(boolean z) {
            if (this.ahb != null) {
                this.ahb.fz();
            }
        }
    }
}
