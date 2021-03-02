package com.tencent.mm.compatible.h;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class a {
    public static void a(MenuItem menuItem, String str) {
        AppMethodBeat.i(155859);
        if (menuItem == null) {
            Log.w("MicroMsg.MenuItemUtil", "fixTitleCondensed fail, item is null");
            AppMethodBeat.o(155859);
        } else if (menuItem.getTitleCondensed() == null) {
            Log.w("MicroMsg.MenuItemUtil", "%s title condensed is null, fix it", str);
            menuItem.setTitleCondensed("");
            AppMethodBeat.o(155859);
        } else if (menuItem.getTitleCondensed() instanceof String) {
            AppMethodBeat.o(155859);
        } else {
            Log.w("MicroMsg.MenuItemUtil", "%s title condensed is not String type, cur type[%s], cur value[%s], fix it", str, menuItem.getTitleCondensed().getClass().getName(), menuItem.getTitleCondensed());
            menuItem.setTitleCondensed(menuItem.getTitleCondensed().toString());
            AppMethodBeat.o(155859);
        }
    }
}
