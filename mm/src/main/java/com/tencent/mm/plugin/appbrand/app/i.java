package com.tencent.mm.plugin.appbrand.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.t;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherFolderUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI;
import com.tencent.mm.plugin.appbrand.ui.recommend.c;
import com.tencent.mm.plugin.profile.ui.BizBindWxaInfoUI;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;

public final class i implements t {
    @Override // com.tencent.mm.plugin.appbrand.service.t
    public final void a(Context context, String str, String str2, List<WxaAttributes.WxaEntryInfo> list) {
        AppMethodBeat.i(44128);
        Intent intent = new Intent(context, BizBindWxaInfoUI.class);
        intent.putParcelableArrayListExtra("extra_wxa_entry_info_list", new ArrayList<>(list));
        intent.putExtra("extra_username", str);
        intent.putExtra("extra_appid", str2);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        a bl = new a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/appbrand/app/ExportUILauncher", "openBizWxaEntryInfoUI", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/appbrand/app/ExportUILauncher", "openBizWxaEntryInfoUI", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(44128);
    }

    @Override // com.tencent.mm.plugin.appbrand.service.t
    public final void K(Context context, int i2) {
        AppMethodBeat.i(180186);
        boolean bYQ = c.bYQ();
        Context context2 = context == null ? MMApplicationContext.getContext() : context;
        a bl = new a().bl(new Intent(context2, AppBrandLauncherUI.class).putExtra("extra_start_activity_click_timestamp_ms", Util.nowMilliSecond()).putExtra("extra_enter_scene", i2).putExtra("extra_show_recommend", bYQ).addFlags(context instanceof Activity ? 0 : 268435456));
        com.tencent.mm.hellhoundlib.a.a.a(context2, bl.axQ(), "com/tencent/mm/plugin/appbrand/app/ExportUILauncher", "openLauncherUI", "(Landroid/content/Context;IZ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context2.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context2, "com/tencent/mm/plugin/appbrand/app/ExportUILauncher", "openLauncherUI", "(Landroid/content/Context;IZ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(180186);
    }

    @Override // com.tencent.mm.plugin.appbrand.service.t
    public final void L(Context context, int i2) {
        AppMethodBeat.i(226309);
        Context context2 = context == null ? MMApplicationContext.getContext() : context;
        Intent putExtra = new Intent().putExtra("extra_show_recents_from_task_bar", true).putExtra("extra_start_activity_click_timestamp_ms", Util.nowMilliSecond()).putExtra("extra_get_usage_reason", 9).putExtra("extra_desktop_open_session", i2).putExtra("extra_enter_scene", 13);
        if (!c.bYQ() || !c.bYR()) {
            a bl = new a().bl(new Intent(context2, AppBrandLauncherUI.class).putExtras(putExtra).addFlags(context2 instanceof Activity ? 0 : 268435456));
            com.tencent.mm.hellhoundlib.a.a.a(context2, bl.axQ(), "com/tencent/mm/plugin/appbrand/app/ExportUILauncher", "openRecentsUI", "(Landroid/content/Context;II)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context2.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context2, "com/tencent/mm/plugin/appbrand/app/ExportUILauncher", "openRecentsUI", "(Landroid/content/Context;II)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(226309);
            return;
        }
        AppBrandLauncherFolderUI.m(context2, putExtra);
        AppMethodBeat.o(226309);
    }

    @Override // com.tencent.mm.plugin.appbrand.service.t
    public final void O(Context context, int i2) {
        AppMethodBeat.i(261627);
        if (context == null) {
            context = MMApplicationContext.getContext();
        }
        Intent intent = new Intent();
        if (i2 == 3) {
            intent.putExtra("extra_get_usage_reason", 7);
        } else {
            intent.putExtra("extra_get_usage_reason", 3);
        }
        intent.putExtra("extra_enter_scene", i2);
        AppBrandLauncherFolderUI.n(context, intent);
        AppMethodBeat.o(261627);
    }

    @Override // com.tencent.mm.plugin.appbrand.service.t
    public final boolean dG(Context context) {
        AppMethodBeat.i(180187);
        if (BuildInfo.IS_FLAVOR_RED || BuildInfo.IS_FLAVOR_PURPLE) {
            com.tencent.mm.plugin.appbrand.ui.i iVar = com.tencent.mm.plugin.appbrand.ui.i.nTZ;
            com.tencent.mm.plugin.appbrand.ui.i.em(context);
            AppMethodBeat.o(180187);
            return true;
        }
        AppMethodBeat.o(180187);
        return false;
    }
}
