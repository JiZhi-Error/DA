package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.a.a.c;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

final class v extends r implements SubMenu {
    v(Context context, c cVar) {
        super(context, cVar);
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderTitle(int i2) {
        ((c) this.afm).setHeaderTitle(i2);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderTitle(CharSequence charSequence) {
        ((c) this.afm).setHeaderTitle(charSequence);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderIcon(int i2) {
        ((c) this.afm).setHeaderIcon(i2);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderIcon(Drawable drawable) {
        ((c) this.afm).setHeaderIcon(drawable);
        return this;
    }

    public final SubMenu setHeaderView(View view) {
        ((c) this.afm).setHeaderView(view);
        return this;
    }

    public final void clearHeader() {
        ((c) this.afm).clearHeader();
    }

    @Override // android.view.SubMenu
    public final SubMenu setIcon(int i2) {
        ((c) this.afm).setIcon(i2);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setIcon(Drawable drawable) {
        ((c) this.afm).setIcon(drawable);
        return this;
    }

    public final MenuItem getItem() {
        return b(((c) this.afm).getItem());
    }
}
