package com.tencent.mm.pluginsdk.permission;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import java.util.HashMap;

public final class b {
    private static HashMap<String, c> JXE = new HashMap<>();
    private static HashMap<String, d> JXF = new HashMap<>();

    static {
        AppMethodBeat.i(151866);
        AppMethodBeat.o(151866);
    }

    public static boolean a(final Activity activity, final String[] strArr, final int i2, String str, String str2) {
        AppMethodBeat.i(177303);
        if (Build.VERSION.SDK_INT >= 23 || "MNC".equals(Build.VERSION.CODENAME)) {
            try {
                int i3 = 0;
                for (String str3 : strArr) {
                    i3 = android.support.v4.content.b.checkSelfPermission(activity, str3);
                    if (i3 != 0) {
                        break;
                    }
                }
                if (i3 == 0) {
                    AppMethodBeat.o(177303);
                    return true;
                }
                if (!Util.isNullOrNil(str2)) {
                    h.a((Context) activity, str2, str, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.pluginsdk.permission.b.AnonymousClass1 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(151848);
                            dialogInterface.dismiss();
                            a.a(activity, strArr, i2);
                            AppMethodBeat.o(151848);
                        }
                    });
                } else {
                    a.a(activity, strArr, i2);
                }
                AppMethodBeat.o(177303);
                return false;
            } catch (Exception e2) {
                Log.e("MicroMsg.MPermissionUtil", "check mpermission exception:%s.", e2);
                AppMethodBeat.o(177303);
                return true;
            }
        } else {
            AppMethodBeat.o(177303);
            return true;
        }
    }

    public static boolean a(final Activity activity, final String str, final int i2, String str2, String str3) {
        AppMethodBeat.i(151851);
        if (Build.VERSION.SDK_INT >= 23 || "MNC".equals(Build.VERSION.CODENAME)) {
            try {
                if (android.support.v4.content.b.checkSelfPermission(activity, str) == 0) {
                    AppMethodBeat.o(151851);
                    return true;
                }
                if (!Util.isNullOrNil(str3)) {
                    h.a((Context) activity, str3, str2, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.pluginsdk.permission.b.AnonymousClass2 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(151849);
                            dialogInterface.dismiss();
                            a.a(activity, new String[]{str}, i2);
                            AppMethodBeat.o(151849);
                        }
                    });
                } else {
                    a.a(activity, new String[]{str}, i2);
                }
                AppMethodBeat.o(151851);
                return false;
            } catch (Exception e2) {
                Log.e("MicroMsg.MPermissionUtil", "check mpermission exception:%s.", e2);
                AppMethodBeat.o(151851);
                return true;
            }
        } else {
            AppMethodBeat.o(151851);
            return true;
        }
    }

    public static boolean aW(Activity activity) {
        AppMethodBeat.i(151852);
        Log.i("MicroMsg.MPermissionUtil", "summerper checkPermission checkStorage[%b]", Boolean.valueOf(o(activity, "android.permission.WRITE_EXTERNAL_STORAGE")));
        boolean o = o(activity, "android.permission.READ_PHONE_STATE");
        Log.i("MicroMsg.MPermissionUtil", "summerper checkPermission checkPhone[%b]", Boolean.valueOf(o));
        if (!o) {
            AppMethodBeat.o(151852);
            return false;
        }
        AppMethodBeat.o(151852);
        return true;
    }

    private static boolean o(Activity activity, String str) {
        AppMethodBeat.i(151853);
        if (Build.VERSION.SDK_INT >= 23 || "MNC".equals(Build.VERSION.CODENAME)) {
            try {
                if (android.support.v4.content.b.checkSelfPermission(activity, str) == 0) {
                    AppMethodBeat.o(151853);
                    return true;
                }
                AppMethodBeat.o(151853);
                return false;
            } catch (Exception e2) {
                Log.e("MicroMsg.MPermissionUtil", "check mpermission exception:%s.", e2);
                AppMethodBeat.o(151853);
                return true;
            }
        } else {
            AppMethodBeat.o(151853);
            return true;
        }
    }

    public static boolean n(Context context, String str) {
        AppMethodBeat.i(151854);
        boolean k = k(context, str, true);
        AppMethodBeat.o(151854);
        return k;
    }

    public static boolean k(Context context, String str, boolean z) {
        int i2;
        AppMethodBeat.i(151855);
        try {
            int checkSelfPermission = android.support.v4.content.b.checkSelfPermission(context, str);
            if (checkSelfPermission != 0) {
                AppMethodBeat.o(151855);
                return false;
            } else if (!z) {
                AppMethodBeat.o(151855);
                return true;
            } else {
                String str2 = null;
                if (str.equals("android.permission.READ_CONTACTS")) {
                    str2 = "android.permission.WRITE_CONTACTS";
                } else if (str.equals("android.permission.WRITE_CONTACTS")) {
                    str2 = "android.permission.READ_CONTACTS";
                }
                if (!Util.isNullOrNil(str2)) {
                    try {
                        i2 = android.support.v4.content.b.checkSelfPermission(context, str2);
                    } catch (Exception e2) {
                        Log.e("MicroMsg.MPermissionUtil", "check mpermission otherPermisson exception:%s.", e2);
                        AppMethodBeat.o(151855);
                        return false;
                    }
                } else {
                    i2 = checkSelfPermission;
                }
                if (i2 == 0) {
                    AppMethodBeat.o(151855);
                    return true;
                }
                AppMethodBeat.o(151855);
                return false;
            }
        } catch (Exception e3) {
            Log.e("MicroMsg.MPermissionUtil", "check mpermission exception:%s.", e3);
            AppMethodBeat.o(151855);
            return false;
        }
    }

    public static void b(Activity activity, String str, int i2) {
        AppMethodBeat.i(151856);
        a.a(activity, new String[]{str}, i2);
        AppMethodBeat.o(151856);
    }

    public static void a(Activity activity, String[] strArr, int i2) {
        AppMethodBeat.i(151857);
        a.a(activity, strArr, i2);
        AppMethodBeat.o(151857);
    }

    public static void a(c cVar, String str) {
        AppMethodBeat.i(151858);
        a(1001, cVar, new String[]{str});
        AppMethodBeat.o(151858);
    }

    public static void a(int i2, c cVar, String[] strArr) {
        AppMethodBeat.i(223776);
        if (cVar == null) {
            Log.i("MicroMsg.MPermissionUtil", "listener is null");
            AppMethodBeat.o(223776);
            return;
        }
        Log.i("MicroMsg.MPermissionUtil", "requestPermission requestCode:%s", Integer.valueOf(i2));
        Context context = MMApplicationContext.getContext();
        int[] iArr = new int[strArr.length];
        for (int i3 = 0; i3 < iArr.length; i3++) {
            iArr[i3] = 0;
        }
        if (Build.VERSION.SDK_INT < 23 || e(context, strArr)) {
            cVar.b(i2, iArr);
            AppMethodBeat.o(223776);
            return;
        }
        String valueOf = String.valueOf(System.currentTimeMillis());
        JXE.put(valueOf, cVar);
        Intent intent = new Intent(context, PermissionActivity.class);
        intent.putExtra("scene", 1);
        intent.putExtra("requestCode", i2);
        intent.putExtra("permission", strArr);
        intent.putExtra("key", valueOf);
        intent.addFlags(268435456);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/pluginsdk/permission/MPermissionUtil", "requestPermission", "(ILcom/tencent/mm/pluginsdk/permission/PermissionListener;[Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/pluginsdk/permission/MPermissionUtil", "requestPermission", "(ILcom/tencent/mm/pluginsdk/permission/PermissionListener;[Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(223776);
    }

    public static void a(Intent intent, String str, String str2, d dVar) {
        AppMethodBeat.i(151860);
        Log.i("MicroMsg.MPermissionUtil", "startSettings reasonTitle:%s, reasonMsg:%s", str, str2);
        String valueOf = String.valueOf(System.currentTimeMillis());
        JXF.put(valueOf, dVar);
        Context context = MMApplicationContext.getContext();
        Intent intent2 = new Intent(context, PermissionActivity.class);
        intent2.putExtra("scene", 2);
        intent2.setSelector(intent);
        intent2.putExtra("key", valueOf);
        intent2.putExtra("reasonTitle", str);
        intent2.putExtra("reasonMsg", str2);
        intent2.addFlags(268435456);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/pluginsdk/permission/MPermissionUtil", "startSettings", "(Landroid/content/Intent;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/pluginsdk/permission/SettingsListener;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/pluginsdk/permission/MPermissionUtil", "startSettings", "(Landroid/content/Intent;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/pluginsdk/permission/SettingsListener;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(151860);
    }

    public static void a(Intent intent, d dVar) {
        AppMethodBeat.i(151861);
        a(intent, "", "", dVar);
        AppMethodBeat.o(151861);
    }

    public static boolean e(Context context, String... strArr) {
        AppMethodBeat.i(151862);
        if (strArr.length == 0) {
            AppMethodBeat.o(151862);
            return false;
        }
        for (String str : strArr) {
            if (!cl(context, str)) {
                AppMethodBeat.o(151862);
                return false;
            }
        }
        AppMethodBeat.o(151862);
        return true;
    }

    private static boolean cl(Context context, String str) {
        AppMethodBeat.i(151863);
        try {
            if (android.support.v4.content.b.checkSelfPermission(context, str) != 0) {
                AppMethodBeat.o(151863);
                return false;
            }
            AppMethodBeat.o(151863);
            return true;
        } catch (Exception e2) {
            Log.e("MicroMsg.MPermissionUtil", "check mpermission exception:%s.", e2);
            AppMethodBeat.o(151863);
            return false;
        }
    }

    static c bdP(String str) {
        AppMethodBeat.i(151864);
        c remove = JXE.remove(str);
        AppMethodBeat.o(151864);
        return remove;
    }

    static d bdQ(String str) {
        AppMethodBeat.i(151865);
        d remove = JXF.remove(str);
        AppMethodBeat.o(151865);
        return remove;
    }
}
