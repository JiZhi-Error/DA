package com.tencent.mm.plugin.x.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.List;

public final class a {
    private static final AbstractC2012a DlV = new AbstractC2012a() {
        /* class com.tencent.mm.plugin.x.a.a.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.x.a.a.AbstractC2012a
        public final int eVm() {
            return -1;
        }

        @Override // com.tencent.mm.plugin.x.a.a.AbstractC2012a
        public final void gX(Context context) {
        }

        @Override // com.tencent.mm.plugin.x.a.a.AbstractC2012a
        public final boolean eVn() {
            return false;
        }
    };

    /* renamed from: com.tencent.mm.plugin.x.a.a$a  reason: collision with other inner class name */
    public static abstract class AbstractC2012a {
        public abstract int eVm();

        public abstract boolean eVn();

        public abstract void gX(Context context);
    }

    static {
        AppMethodBeat.i(151586);
        AppMethodBeat.o(151586);
    }

    public static AbstractC2012a eVl() {
        AppMethodBeat.i(151585);
        b bVar = new b();
        AppMethodBeat.o(151585);
        return bVar;
    }

    static abstract class b {
        /* access modifiers changed from: protected */
        public abstract Intent eVp();

        b() {
        }

        public final void gY(Context context) {
            Intent eVp = eVp();
            if (!(context instanceof Activity)) {
                eVp.addFlags(268435456);
            }
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(eVp);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/shortcut/permission/AppPermissionSettingAdapterFactory$SettingPageJumper", "jump", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/shortcut/permission/AppPermissionSettingAdapterFactory$SettingPageJumper", "jump", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }

        public final boolean eVo() {
            boolean z;
            List<ResolveInfo> queryIntentActivities = MMApplicationContext.getContext().getPackageManager().queryIntentActivities(eVp(), 0);
            if (queryIntentActivities == null || queryIntentActivities.isEmpty()) {
                z = true;
            } else {
                z = false;
            }
            return !z && queryIntentActivities.get(0).activityInfo.exported;
        }
    }
}
