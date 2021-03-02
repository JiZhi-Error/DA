package com.tencent.mm.compatible.e;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.provider.Settings;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.lang.reflect.Method;

public final class b {
    private static Boolean gLa = null;

    public static boolean api() {
        AppMethodBeat.i(155848);
        if (!Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
            AppMethodBeat.o(155848);
            return true;
        }
        int i2 = 0;
        if (Build.VERSION.SDK_INT == 17) {
            i2 = 36;
        } else if (Build.VERSION.SDK_INT >= 19) {
            i2 = 27;
        }
        boolean oC = oC(i2);
        AppMethodBeat.o(155848);
        return oC;
    }

    public static boolean cv(Context context) {
        boolean z = false;
        AppMethodBeat.i(155849);
        if (gLa == null) {
            if (context != null) {
                z = context.getPackageManager().hasSystemFeature("org.chromium.arc.device_management");
            }
            try {
                gLa = Boolean.valueOf(z);
                gLa = Boolean.FALSE;
            } catch (Throwable th) {
                gLa = Boolean.FALSE;
                AppMethodBeat.o(155849);
                throw th;
            }
        }
        boolean booleanValue = gLa.booleanValue();
        AppMethodBeat.o(155849);
        return booleanValue;
    }

    public static boolean apj() {
        AppMethodBeat.i(155850);
        if (!Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
            AppMethodBeat.o(155850);
            return true;
        }
        int i2 = 0;
        if (Build.VERSION.SDK_INT == 17) {
            i2 = 35;
        } else if (Build.VERSION.SDK_INT >= 19) {
            i2 = 26;
        }
        boolean oC = oC(i2);
        AppMethodBeat.o(155850);
        return oC;
    }

    public static void cw(Context context) {
        AppMethodBeat.i(155851);
        if (Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
            try {
                Intent intent = new Intent();
                intent.setClassName("com.android.settings", "com.android.settings.applications.AppsCheckReadPermission");
                a bl = new a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/compatible/permission/PermissionUtil", "showPermissionSettingsOfMeizu", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/compatible/permission/PermissionUtil", "showPermissionSettingsOfMeizu", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(155851);
                return;
            } catch (Exception e2) {
                Log.e("MicroMsg.PermissionUtil", "unable start activity AppsCheckReadPermission");
                try {
                    Intent intent2 = new Intent("android.settings.APP_OPS_SETTINGS");
                    intent2.addCategory("android.intent.category.DEFAULT");
                    a bl2 = new a().bl(intent2);
                    com.tencent.mm.hellhoundlib.a.a.a(context, bl2.axQ(), "com/tencent/mm/compatible/permission/PermissionUtil", "showPermissionSettingsOfMeizu", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    context.startActivity((Intent) bl2.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/compatible/permission/PermissionUtil", "showPermissionSettingsOfMeizu", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    AppMethodBeat.o(155851);
                    return;
                } catch (Exception e3) {
                    Log.e("MicroMsg.PermissionUtil", "unable start activity APP_OPS_SETTINGS");
                    try {
                        Intent intent3 = new Intent();
                        intent3.setClassName("com.android.settings", "com.android.settings.Settings$AppControlSettingsActivity");
                        a bl3 = new a().bl(intent3);
                        com.tencent.mm.hellhoundlib.a.a.a(context, bl3.axQ(), "com/tencent/mm/compatible/permission/PermissionUtil", "showPermissionSettingsOfMeizu", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        context.startActivity((Intent) bl3.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/compatible/permission/PermissionUtil", "showPermissionSettingsOfMeizu", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        AppMethodBeat.o(155851);
                        return;
                    } catch (Exception e4) {
                        Log.e("MicroMsg.PermissionUtil", "unable start activity AppControlSettingsActivity");
                    }
                }
            }
        }
        AppMethodBeat.o(155851);
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x003f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean oC(int r10) {
        /*
        // Method dump skipped, instructions count: 198
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.compatible.e.b.oC(int):boolean");
    }

    @TargetApi(19)
    public static boolean cx(Context context) {
        Method method;
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(155853);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23) {
            try {
                boolean booleanValue = ((Boolean) Settings.class.getDeclaredMethod("canDrawOverlays", Context.class).invoke(null, context)).booleanValue();
                Log.i("MicroMsg.PermissionUtil", "isFloatWindowOpAllowed allowed: ".concat(String.valueOf(booleanValue)));
                AppMethodBeat.o(155853);
                return booleanValue;
            } catch (Exception e2) {
                Log.e("MicroMsg.PermissionUtil", "getDeclaredMethod:canDrawOverlays! Error:%s, etype:%s", e2.getMessage(), e2.getClass().getCanonicalName());
                AppMethodBeat.o(155853);
                return true;
            }
        } else if (i2 >= 19) {
            Object systemService = MMApplicationContext.getContext().getSystemService("appops");
            try {
                method = Class.forName("android.app.AppOpsManager").getMethod("checkOp", Integer.TYPE, Integer.TYPE, String.class);
            } catch (NoSuchMethodException e3) {
                Log.e("MicroMsg.PermissionUtil", "NoSuchMethodException method:checkOp! Error:%s", e3.getMessage());
                method = null;
            } catch (ClassNotFoundException e4) {
                Log.e("MicroMsg.PermissionUtil", "ClassNotFoundException class:android.app.AppOpsManager! Error:%s", e4.getMessage());
                method = null;
            }
            if (method != null) {
                try {
                    if (((Integer) method.invoke(systemService, 24, Integer.valueOf(MMApplicationContext.getContext().getApplicationInfo().uid), MMApplicationContext.getPackageName())).intValue() == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    z2 = z;
                } catch (Exception e5) {
                    Log.e("MicroMsg.PermissionUtil", "call checkOp failed: %s etype:%s", e5.getMessage(), e5.getClass().getCanonicalName());
                }
            }
            Log.i("MicroMsg.PermissionUtil", "isFloatWindowOpAllowed allowed: ".concat(String.valueOf(z2)));
            AppMethodBeat.o(155853);
            return z2;
        } else {
            AppMethodBeat.o(155853);
            return true;
        }
    }
}
