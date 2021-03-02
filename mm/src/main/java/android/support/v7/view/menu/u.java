package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.view.menu.h;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public class u extends h implements SubMenu {
    public h aho;
    private j ahp;

    public u(Context context, h hVar, j jVar) {
        super(context);
        this.aho = hVar;
        this.ahp = jVar;
    }

    @Override // android.support.v7.view.menu.h
    public void setQwertyMode(boolean z) {
        this.aho.setQwertyMode(z);
    }

    @Override // android.support.v7.view.menu.h
    public final boolean hY() {
        return this.aho.hY();
    }

    @Override // android.support.v7.view.menu.h
    public final boolean hZ() {
        return this.aho.hZ();
    }

    public MenuItem getItem() {
        return this.ahp;
    }

    @Override // android.support.v7.view.menu.h
    public final void a(h.a aVar) {
        this.aho.a(aVar);
    }

    @Override // android.support.v7.view.menu.h
    public final h ii() {
        return this.aho.ii();
    }

    /* access modifiers changed from: package-private */
    @Override // android.support.v7.view.menu.h
    public final boolean d(h hVar, MenuItem menuItem) {
        return super.d(hVar, menuItem) || this.aho.d(hVar, menuItem);
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(Drawable drawable) {
        this.ahp.setIcon(drawable);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(int i2) {
        this.ahp.setIcon(i2);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(Drawable drawable) {
        super.a(0, null, 0, drawable, null);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(int i2) {
        super.a(0, null, i2, null, null);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(CharSequence charSequence) {
        super.a(0, charSequence, 0, null, null);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(int i2) {
        super.a(i2, null, 0, null, null);
        return this;
    }

    public SubMenu setHeaderView(View view) {
        super.a(0, null, 0, null, view);
        return this;
    }

    @Override // android.support.v7.view.menu.h
    public final boolean g(j jVar) {
        return this.aho.g(jVar);
    }

    @Override // android.support.v7.view.menu.h
    public final boolean h(j jVar) {
        return this.aho.h(jVar);
    }

    @Override // android.support.v7.view.menu.h
    public final String hW() {
        int itemId = this.ahp != null ? this.ahp.getItemId() : 0;
        if (itemId == 0) {
            return null;
        }
        return super.hW() + ":" + itemId;
    }

    @Override // android.support.v7.view.menu.h
    public void setGroupDividerEnabled(boolean z) {
        this.aho.setGroupDividerEnabled(z);
    }

    @Override // android.support.v7.view.menu.h
    public final boolean hX() {
        return this.aho.hX();
    }
}
