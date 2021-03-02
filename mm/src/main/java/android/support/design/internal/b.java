package android.support.design.internal;

import android.content.Context;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.j;
import android.view.SubMenu;

public final class b extends h {
    public b(Context context) {
        super(context);
    }

    @Override // android.support.v7.view.menu.h, android.view.Menu
    public final SubMenu addSubMenu(int i2, int i3, int i4, CharSequence charSequence) {
        j jVar = (j) a(i2, i3, i4, charSequence);
        d dVar = new d(this.mContext, this, jVar);
        jVar.b(dVar);
        return dVar;
    }
}
