package android.support.v7.view.menu;

import android.content.Context;
import android.os.Build;
import android.support.v4.a.a.a;
import android.support.v4.a.a.b;
import android.view.Menu;
import android.view.MenuItem;

public final class q {
    public static Menu a(Context context, a aVar) {
        return new r(context, aVar);
    }

    public static MenuItem a(Context context, b bVar) {
        if (Build.VERSION.SDK_INT >= 16) {
            return new l(context, bVar);
        }
        return new k(context, bVar);
    }
}
