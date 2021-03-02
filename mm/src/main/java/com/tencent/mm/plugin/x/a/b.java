package com.tencent.mm.plugin.x.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.plugin.x.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.HashMap;
import java.util.Map;

/* access modifiers changed from: package-private */
public final class b extends a.AbstractC2012a {
    private final Map<String, a.b> DlW = new HashMap();

    b() {
        AppMethodBeat.i(151590);
        this.DlW.put("xiaomi", new a.b() {
            /* class com.tencent.mm.plugin.x.a.b.AnonymousClass1 */

            /* access modifiers changed from: protected */
            @Override // com.tencent.mm.plugin.x.a.a.b
            public final Intent eVp() {
                AppMethodBeat.i(151587);
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity"));
                intent.putExtra("extra_pkgname", MMApplicationContext.getPackageName());
                AppMethodBeat.o(151587);
                return intent;
            }
        });
        this.DlW.put("oppo", new a.b() {
            /* class com.tencent.mm.plugin.x.a.b.AnonymousClass2 */

            /* access modifiers changed from: protected */
            @Override // com.tencent.mm.plugin.x.a.a.b
            public final Intent eVp() {
                AppMethodBeat.i(151588);
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.oppo.launcher", "com.oppo.launcher.shortcut.ShortcutSettingsActivity"));
                intent.setAction("coloros.intent.action.launcher.SHORTCUT_SETTINGS");
                AppMethodBeat.o(151588);
                return intent;
            }
        });
        this.DlW.put("vivo", new a.b() {
            /* class com.tencent.mm.plugin.x.a.b.AnonymousClass3 */

            /* access modifiers changed from: protected */
            @Override // com.tencent.mm.plugin.x.a.a.b
            public final Intent eVp() {
                AppMethodBeat.i(151589);
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.bbk.launcher2", "com.bbk.launcher2.installshortcut.PurviewActivity"));
                AppMethodBeat.o(151589);
                return intent;
            }
        });
        AppMethodBeat.o(151590);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0186  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0192  */
    @Override // com.tencent.mm.plugin.x.a.a.AbstractC2012a
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int eVm() {
        /*
        // Method dump skipped, instructions count: 450
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.x.a.b.eVm():int");
    }

    @Override // com.tencent.mm.plugin.x.a.a.AbstractC2012a
    public final void gX(Context context) {
        AppMethodBeat.i(151592);
        String lowerCase = ae.cu(context).toLowerCase();
        Log.i("MicroMsg.AppPermissionSettingAdapterFactory", "[jumpPermissionSettingPage] manufacturer = %s", lowerCase);
        a.b bVar = this.DlW.get(lowerCase);
        if (bVar != null) {
            bVar.gY(context);
        }
        AppMethodBeat.o(151592);
    }

    @Override // com.tencent.mm.plugin.x.a.a.AbstractC2012a
    public final boolean eVn() {
        AppMethodBeat.i(151593);
        String manufacturer = getManufacturer();
        Log.i("MicroMsg.AppPermissionSettingAdapterFactory", "[canJumpSettingPage] manufacturer = %s", manufacturer);
        a.b bVar = this.DlW.get(manufacturer);
        if (!this.DlW.containsKey(manufacturer) || !bVar.eVo()) {
            AppMethodBeat.o(151593);
            return false;
        }
        AppMethodBeat.o(151593);
        return true;
    }

    private static String getManufacturer() {
        AppMethodBeat.i(151594);
        String lowerCase = ae.cu(MMApplicationContext.getContext()).toLowerCase();
        AppMethodBeat.o(151594);
        return lowerCase;
    }
}
