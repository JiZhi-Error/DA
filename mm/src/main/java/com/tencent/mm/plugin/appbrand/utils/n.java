package com.tencent.mm.plugin.appbrand.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.plugin.appbrand.service.m;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherFolderUI;
import com.tencent.mm.ui.MMFragmentActivity;

public final class n implements m {
    @Override // com.tencent.mm.plugin.appbrand.service.m
    public final void a(Context context, int i2, String str) {
        int i3 = 14;
        AppMethodBeat.i(49314);
        if (1 == i2) {
            i3 = 15;
        } else if (!(2 == i2 || i2 == 0)) {
            i3 = -1;
        }
        Intent intent = new Intent(context, AppBrandLauncherFolderUI.class);
        intent.putExtra(MMFragmentActivity.EXTRA_USE_SYSTEM_DEFAULT_ENTER_EXIT_ANIM, true);
        intent.putExtra("extra_enter_scene", i3);
        intent.putExtra("extra_enter_scene_note", str);
        intent.putExtra("KEY_MODE", 1);
        intent.addFlags(context instanceof Activity ? 0 : 268435456);
        intent.addFlags(536870912);
        intent.addFlags(134217728);
        a bl = new a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/appbrand/utils/ExtOpenWxaDesktopFavoriteHelperImpl", "openWxaDesktop", "(Landroid/content/Context;ILjava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/appbrand/utils/ExtOpenWxaDesktopFavoriteHelperImpl", "openWxaDesktop", "(Landroid/content/Context;ILjava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(49314);
    }

    @Override // com.tencent.mm.plugin.appbrand.service.m
    public final void af(Context context, String str) {
        AppMethodBeat.i(49315);
        Intent intent = new Intent(context, AppBrandLauncherFolderUI.class);
        intent.putExtra(MMFragmentActivity.EXTRA_USE_SYSTEM_DEFAULT_ENTER_EXIT_ANIM, true);
        intent.putExtra("extra_enter_scene", 4);
        intent.putExtra("extra_enter_scene_note", str);
        intent.putExtra("KEY_MODE", 2);
        intent.addFlags(context instanceof Activity ? 0 : 268435456);
        intent.addFlags(536870912);
        intent.addFlags(134217728);
        a bl = new a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/appbrand/utils/ExtOpenWxaDesktopFavoriteHelperImpl", "openWxaMyFavorite", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/appbrand/utils/ExtOpenWxaDesktopFavoriteHelperImpl", "openWxaMyFavorite", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(49315);
    }
}
