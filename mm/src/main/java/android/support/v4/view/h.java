package android.support.v4.view;

import android.view.MenuItem;

public final class h {

    @Deprecated
    public interface a {
        boolean fA();

        boolean fB();
    }

    @Deprecated
    public static MenuItem a(MenuItem menuItem, final a aVar) {
        return menuItem.setOnActionExpandListener(new MenuItem.OnActionExpandListener() {
            /* class android.support.v4.view.h.AnonymousClass1 */

            public final boolean onMenuItemActionExpand(MenuItem menuItem) {
                return aVar.fA();
            }

            public final boolean onMenuItemActionCollapse(MenuItem menuItem) {
                return aVar.fB();
            }
        });
    }
}
