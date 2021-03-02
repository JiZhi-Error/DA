package android.support.v7.view.menu;

import android.content.Context;
import android.support.v4.a.a.b;
import android.support.v4.e.a;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.Map;

/* access modifiers changed from: package-private */
public abstract class c<T> extends d<T> {
    Map<b, MenuItem> afk;
    Map<android.support.v4.a.a.c, SubMenu> afl;
    final Context mContext;

    c(Context context, T t) {
        super(t);
        this.mContext = context;
    }

    /* access modifiers changed from: package-private */
    public final MenuItem b(MenuItem menuItem) {
        if (!(menuItem instanceof b)) {
            return menuItem;
        }
        b bVar = (b) menuItem;
        if (this.afk == null) {
            this.afk = new a();
        }
        MenuItem menuItem2 = this.afk.get(menuItem);
        if (menuItem2 != null) {
            return menuItem2;
        }
        MenuItem a2 = q.a(this.mContext, bVar);
        this.afk.put(bVar, a2);
        return a2;
    }

    /* access modifiers changed from: package-private */
    public final SubMenu a(SubMenu subMenu) {
        if (!(subMenu instanceof android.support.v4.a.a.c)) {
            return subMenu;
        }
        android.support.v4.a.a.c cVar = (android.support.v4.a.a.c) subMenu;
        if (this.afl == null) {
            this.afl = new a();
        }
        SubMenu subMenu2 = this.afl.get(cVar);
        if (subMenu2 != null) {
            return subMenu2;
        }
        v vVar = new v(this.mContext, cVar);
        this.afl.put(cVar, vVar);
        return vVar;
    }
}
