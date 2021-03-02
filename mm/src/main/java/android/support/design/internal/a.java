package android.support.design.internal;

import android.content.Context;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.j;
import android.view.MenuItem;
import android.view.SubMenu;

public final class a extends h {
    public a(Context context) {
        super(context);
    }

    @Override // android.support.v7.view.menu.h, android.view.Menu
    public final SubMenu addSubMenu(int i2, int i3, int i4, CharSequence charSequence) {
        throw new UnsupportedOperationException("BottomNavigationView does not support submenus");
    }

    @Override // android.support.v7.view.menu.h
    public final MenuItem a(int i2, int i3, int i4, CharSequence charSequence) {
        if (size() + 1 > 5) {
            throw new IllegalArgumentException("Maximum number of items supported by BottomNavigationView is 5. Limit can be checked with BottomNavigationView#getMaxItemCount()");
        }
        ia();
        MenuItem a2 = super.a(i2, i3, i4, charSequence);
        if (a2 instanceof j) {
            ((j) a2).ab(true);
        }
        ib();
        return a2;
    }
}
