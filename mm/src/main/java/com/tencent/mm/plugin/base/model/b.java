package com.tencent.mm.plugin.base.model;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.c;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.network.af;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.f;
import java.util.ArrayList;
import java.util.List;

public final class b {
    public static final String SOURCE_KEY = MMApplicationContext.getPackageName();
    private static char[] iNl = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static String pdg = "";

    static {
        AppMethodBeat.i(151453);
        AppMethodBeat.o(151453);
    }

    public static boolean ah(Context context, String str) {
        AppMethodBeat.i(151433);
        pdg = z.aTY();
        Intent a2 = a(context, str, true, pdg);
        Intent intent = (Intent) a2.getParcelableExtra("android.intent.extra.shortcut.INTENT");
        if (intent == null) {
            AppMethodBeat.o(151433);
            return false;
        }
        a(context, a2, intent.getStringExtra("app_shortcut_custom_id"), true);
        AppMethodBeat.o(151433);
        return true;
    }

    public static void o(Context context, Intent intent) {
        AppMethodBeat.i(151434);
        a(context, intent, (String) null, true);
        AppMethodBeat.o(151434);
    }

    private static void a(Context context, Intent intent, String str, boolean z) {
        AppMethodBeat.i(151435);
        a(context, intent, str, null, z);
        AppMethodBeat.o(151435);
    }

    public static void a(Context context, Intent intent, String str, String str2, boolean z) {
        boolean b2;
        AppMethodBeat.i(151436);
        if (context == null) {
            Log.e("MicroMsg.ShortcutManager", "context is null");
            AppMethodBeat.o(151436);
        } else if (intent == null) {
            Log.e("MicroMsg.ShortcutManager", "intent is null");
            AppMethodBeat.o(151436);
        } else {
            if (Build.VERSION.SDK_INT < 26) {
                b2 = c(context, intent, z);
            } else {
                b2 = b(context, intent, str, str2, z);
            }
            if (!b2 && z) {
                d(context, false, z);
            }
            AppMethodBeat.o(151436);
        }
    }

    public static void p(Context context, Intent intent) {
        AppMethodBeat.i(151437);
        a(context, intent, (String) null, false);
        AppMethodBeat.o(151437);
    }

    private static boolean c(Context context, Intent intent, boolean z) {
        AppMethodBeat.i(151438);
        context.sendBroadcast(intent);
        d(context, true, z);
        AppMethodBeat.o(151438);
        return true;
    }

    @TargetApi(26)
    private static boolean b(Context context, Intent intent, String str, String str2, boolean z) {
        boolean z2;
        String str3;
        Bitmap bitmap;
        boolean z3;
        boolean z4;
        ShortcutInfo shortcutInfo;
        AppMethodBeat.i(151439);
        ShortcutManager shortcutManager = (ShortcutManager) context.getSystemService(ShortcutManager.class);
        if (shortcutManager == null) {
            Log.e("MicroMsg.ShortcutManager", "shortcut manager is null");
            AppMethodBeat.o(151439);
            return false;
        } else if (!shortcutManager.isRequestPinShortcutSupported()) {
            Log.e("MicroMsg.ShortcutManager", "alvinluo not support pin shortcuts");
            AppMethodBeat.o(151439);
            return false;
        } else if (intent.getBooleanExtra("is_main_shortcut", false)) {
            Log.i("MicroMsg.ShortcutManager", "alvinluo main icon, do not create shortcut");
            AppMethodBeat.o(151439);
            return false;
        } else {
            Intent intent2 = (Intent) intent.getParcelableExtra("android.intent.extra.shortcut.INTENT");
            if (intent2 == null) {
                Log.e("MicroMsg.ShortcutManager", "alvinluo shortcut intent is null");
                AppMethodBeat.o(151439);
                return false;
            }
            if (Util.isNullOrNil(str)) {
                str = intent2.getStringExtra("app_shortcut_custom_id");
            }
            if (Util.isNullOrNil(str)) {
                Log.i("MicroMsg.ShortcutManager", "alvinluo shortcutId is null, then use short name as shortcutId");
                str3 = intent.getStringExtra("android.intent.extra.shortcut.NAME");
                z2 = true;
            } else {
                z2 = false;
                str3 = str;
            }
            Log.i("MicroMsg.ShortcutManager", "alvinluo shortcutId: %s", str3);
            String stringExtra = intent.getStringExtra("android.intent.extra.shortcut.NAME");
            Intent.ShortcutIconResource shortcutIconResource = (Intent.ShortcutIconResource) intent.getParcelableExtra("android.intent.extra.shortcut.ICON_RESOURCE");
            if (shortcutIconResource != null) {
                Log.i("MicroMsg.ShortcutManager", "alvinluo icon resource name: %s, %s", shortcutIconResource.resourceName, shortcutIconResource.packageName);
            }
            Bitmap bitmap2 = (Bitmap) intent.getParcelableExtra("android.intent.extra.shortcut.ICON");
            if (bitmap2 == null) {
                Log.i("MicroMsg.ShortcutManager", "extra_shortcut_icon is null, use icon resource id");
                int intExtra = intent.getIntExtra("shortcut_icon_resource_id", -1);
                if (intExtra == -1) {
                    Log.e("MicroMsg.ShortcutManager", "icon resource id is null");
                    AppMethodBeat.o(151439);
                    return false;
                }
                bitmap = BitmapFactory.decodeResource(context.getResources(), intExtra);
            } else {
                bitmap = bitmap2;
            }
            if (bitmap == null) {
                Log.e("MicroMsg.ShortcutManager", "icon bitmap is null");
                AppMethodBeat.o(151439);
                return false;
            }
            boolean booleanExtra = intent.getBooleanExtra("shortcut_is_adaptive_icon", false);
            ShortcutInfo a2 = a(context, str3, intent, intent2, booleanExtra, bitmap);
            boolean booleanExtra2 = intent.getBooleanExtra("duplicate", false);
            Log.i("MicroMsg.ShortcutManager", "alvinluo add shortcut above android o, duplicate: %b", Boolean.valueOf(booleanExtra2));
            if (booleanExtra2) {
                shortcutManager.requestPinShortcut(a2, null);
                d(context, true, z);
            } else {
                List<ShortcutInfo> pinnedShortcuts = shortcutManager.getPinnedShortcuts();
                int i2 = 0;
                while (true) {
                    if (i2 >= pinnedShortcuts.size()) {
                        z3 = false;
                        z4 = false;
                        break;
                    }
                    ShortcutInfo shortcutInfo2 = pinnedShortcuts.get(i2);
                    if (!z2) {
                        if (shortcutInfo2 == null || !shortcutInfo2.getId().equals(str2)) {
                            if (shortcutInfo2 != null && shortcutInfo2.getId().equals(str3)) {
                                z3 = false;
                                z4 = true;
                                break;
                            }
                        } else {
                            z3 = true;
                            z4 = true;
                            break;
                        }
                    } else if (!(shortcutInfo2 == null || shortcutInfo2.getShortLabel() == null || !shortcutInfo2.getShortLabel().equals(stringExtra))) {
                        z3 = false;
                        z4 = true;
                        break;
                    }
                    i2++;
                }
                Log.i("MicroMsg.ShortcutManager", "alvinluo shortcut exist: %b, shortcutName: %s", Boolean.valueOf(z4), stringExtra);
                if (z3) {
                    shortcutInfo = a(context, str2, intent, intent2, booleanExtra, bitmap);
                } else {
                    shortcutInfo = a2;
                }
                if (z4) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(shortcutInfo);
                    Log.i("MicroMsg.ShortcutManager", "alvinluo update shortcuts result: %b", Boolean.valueOf(shortcutManager.updateShortcuts(arrayList)));
                    d(context, true, z);
                } else if (z) {
                    Intent createShortcutResultIntent = shortcutManager.createShortcutResultIntent(shortcutInfo);
                    createShortcutResultIntent.setClass(context, ShortcutBroadCastReceiver.class);
                    shortcutManager.requestPinShortcut(shortcutInfo, PendingIntent.getBroadcast(context, 0, createShortcutResultIntent, 134217728).getIntentSender());
                } else {
                    shortcutManager.requestPinShortcut(shortcutInfo, null);
                }
            }
            AppMethodBeat.o(151439);
            return true;
        }
    }

    private static void d(Context context, boolean z, boolean z2) {
        String string;
        AppMethodBeat.i(151440);
        if (z2) {
            if (z) {
                string = context.getString(R.string.h9);
            } else {
                string = context.getString(R.string.h7);
            }
            h.cD(context, string);
        }
        AppMethodBeat.o(151440);
    }

    public static void K(final Activity activity) {
        AppMethodBeat.i(151441);
        if (!MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getBoolean("no_more_show_add_short_cut_dialog", false)) {
            final f.a aVar = new f.a(activity);
            aVar.boz(activity.getString(R.string.h1e));
            String string = activity.getString(R.string.h1g);
            String string2 = activity.getString(R.string.h1d);
            aVar.aC(string);
            aVar.bow(string2);
            aVar.apa(R.string.w1);
            aVar.JnN = true;
            aVar.a(new f.b() {
                /* class com.tencent.mm.plugin.base.model.b.AnonymousClass1 */

                @Override // com.tencent.mm.ui.widget.a.f.b
                public final void D(boolean z, boolean z2) {
                    AppMethodBeat.i(151432);
                    aVar.kdo.dismiss();
                    if (z2) {
                        activity.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).edit().putBoolean("no_more_show_add_short_cut_dialog", true).apply();
                    }
                    AppMethodBeat.o(151432);
                }
            });
            aVar.show();
        }
        AppMethodBeat.o(151441);
    }

    public static boolean ai(Context context, String str) {
        AppMethodBeat.i(151442);
        pdg = z.aTY();
        q(context, a(context, str, false, pdg));
        AppMethodBeat.o(151442);
        return true;
    }

    public static boolean q(Context context, Intent intent) {
        AppMethodBeat.i(151443);
        if (context == null) {
            Log.e("MicroMsg.ShortcutManager", "context is null");
            AppMethodBeat.o(151443);
            return false;
        } else if (intent == null) {
            Log.e("MicroMsg.ShortcutManager", "intent is null");
            AppMethodBeat.o(151443);
            return false;
        } else if (Build.VERSION.SDK_INT < 26) {
            context.sendBroadcast(intent);
            AppMethodBeat.o(151443);
            return true;
        } else {
            AppMethodBeat.o(151443);
            return true;
        }
    }

    private static Intent a(Context context, String str, boolean z, String str2) {
        AppMethodBeat.i(151444);
        if (str == null || context == null) {
            Log.e("MicroMsg.ShortcutManager", "getIntent, wrong parameters");
            AppMethodBeat.o(151444);
            return null;
        }
        Bitmap aj = aj(context, str);
        if (aj == null) {
            Log.e("MicroMsg.ShortcutManager", "no bmp");
            AppMethodBeat.o(151444);
            return null;
        }
        as Kn = ((l) g.af(l.class)).aSN().Kn(str);
        if (Kn == null || ((int) Kn.gMZ) <= 0) {
            Log.e("MicroMsg.ShortcutManager", "no such user");
            AppMethodBeat.o(151444);
            return null;
        }
        String agZ = agZ(str);
        Log.i("MicroMsg.ShortcutManager", "alvinluo encryptShortcutUser: %s", agZ);
        if (Util.isNullOrNil(agZ)) {
            AppMethodBeat.o(151444);
            return null;
        }
        Intent intent = new Intent("com.tencent.mm.action.BIZSHORTCUT");
        intent.putExtra("LauncherUI.Shortcut.Username", agZ);
        intent.putExtra("LauncherUI.From.Biz.Shortcut", true);
        intent.putExtra("app_shortcut_custom_id", agZ);
        intent.setPackage(context.getPackageName());
        intent.addFlags(67108864);
        Intent intent2 = new Intent(z ? "com.android.launcher.action.INSTALL_SHORTCUT" : "com.android.launcher.action.UNINSTALL_SHORTCUT");
        intent2.putExtra("android.intent.extra.shortcut.NAME", ((com.tencent.mm.plugin.messenger.a.b) g.af(com.tencent.mm.plugin.messenger.a.b.class)).b(Kn, str));
        intent2.putExtra("duplicate", false);
        intent2.putExtra("android.intent.extra.shortcut.INTENT", intent);
        intent2.putExtra("android.intent.extra.shortcut.ICON", aj);
        intent2.putExtra("com.tencent.qlauncher.extra.EXTRA_PUSH_ITEM_SOURCE_KEY", SOURCE_KEY);
        intent2.putExtra("com.tencent.qlauncher.extra.EXTRA_PUSH_ITEM_OWNER_ID", agZ(str2));
        intent2.putExtra("com.tencent.qlauncher.extra.EXTRA_PUSH_ITEM_UNIQUE_ID", agZ);
        intent2.putExtra("com.tencent.qlauncher.extra.EXTRA_PUSH_ITEM_TYPE", Q(Kn));
        intent2.putExtra("com.tencent.qlauncher.extra.EXTRA_PUSH_ITEM_CONTAINER", 0);
        AppMethodBeat.o(151444);
        return intent2;
    }

    @TargetApi(26)
    private static ShortcutInfo a(Context context, String str, Intent intent, Intent intent2, boolean z, Bitmap bitmap) {
        AppMethodBeat.i(151445);
        ShortcutInfo.Builder intent3 = new ShortcutInfo.Builder(context, str).setShortLabel(intent.getStringExtra("android.intent.extra.shortcut.NAME")).setLongLabel(intent.getStringExtra("android.intent.extra.shortcut.NAME")).setIntent(intent2);
        if (z) {
            intent3.setIcon(Icon.createWithBitmap(bitmap));
        } else {
            intent3.setIcon(Icon.createWithAdaptiveBitmap(bitmap));
        }
        ShortcutInfo build = intent3.build();
        AppMethodBeat.o(151445);
        return build;
    }

    private static Bitmap aj(Context context, String str) {
        AppMethodBeat.i(151446);
        int i2 = (int) (context.getResources().getDisplayMetrics().density * 48.0f);
        Bitmap a2 = c.a(str, false, -1, null);
        if (a2 == null) {
            Log.e("MicroMsg.ShortcutManager", "getScaledBitmap fail, bmp is null");
            a2 = BitmapUtil.getBitmapNative((int) R.drawable.bca);
        }
        if (a2 == null) {
            Log.e("MicroMsg.ShortcutManager", "use default avatar, bmp is null");
            AppMethodBeat.o(151446);
            return null;
        }
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(a2, i2, i2, false);
        AppMethodBeat.o(151446);
        return createScaledBitmap;
    }

    public static int Q(as asVar) {
        AppMethodBeat.i(151447);
        if (asVar.gBM()) {
            AppMethodBeat.o(151447);
            return 2;
        } else if (!ab.JF(asVar.field_username)) {
            AppMethodBeat.o(151447);
            return 1;
        } else {
            AppMethodBeat.o(151447);
            return 0;
        }
    }

    public static String eW(String str, String str2) {
        AppMethodBeat.i(151448);
        try {
            int[] iArr = new int[256];
            byte[] bArr = new byte[256];
            for (int i2 = 0; i2 < 256; i2++) {
                iArr[i2] = i2;
            }
            for (short s = 0; s < 256; s = (short) (s + 1)) {
                bArr[s] = (byte) str2.charAt(s % str2.length());
            }
            int i3 = 0;
            for (int i4 = 0; i4 < 255; i4++) {
                i3 = ((i3 + iArr[i4]) + bArr[i4]) % 256;
                int i5 = iArr[i4];
                iArr[i4] = iArr[i3];
                iArr[i3] = i5;
            }
            char[] charArray = str.toCharArray();
            char[] cArr = new char[charArray.length];
            int i6 = 0;
            int i7 = 0;
            for (short s2 = 0; s2 < charArray.length; s2 = (short) (s2 + 1)) {
                i6 = (i6 + 1) % 256;
                i7 = (i7 + iArr[i6]) % 256;
                int i8 = iArr[i6];
                iArr[i6] = iArr[i7];
                iArr[i7] = i8;
                cArr[s2] = (char) (((char) iArr[(iArr[i6] + (iArr[i7] % 256)) % 256]) ^ charArray[s2]);
            }
            String str3 = new String(cArr);
            AppMethodBeat.o(151448);
            return str3;
        } catch (Exception e2) {
            Log.e("MicroMsg.ShortcutManager", "Exception in rc4, %s", e2.getMessage());
            Log.printErrStackTrace("MicroMsg.ShortcutManager", e2, "", new Object[0]);
            AppMethodBeat.o(151448);
            return null;
        }
    }

    public static String agY(String str) {
        int uin;
        AppMethodBeat.i(151449);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(151449);
            return null;
        }
        String processNameByPid = Util.getProcessNameByPid(MMApplicationContext.getContext(), Process.myPid());
        String packageName = MMApplicationContext.getPackageName();
        Log.i("MicroMsg.ShortcutManager", "process name: %s", processNameByPid);
        try {
            if (!packageName.equals(processNameByPid)) {
                uin = af.bkl().jEj.getUin();
            } else if (!g.aAf().azp()) {
                AppMethodBeat.o(151449);
                return null;
            } else {
                g.aAf();
                uin = a.getUin();
            }
            if (str.startsWith("shortcut_")) {
                String eW = eW(new String(aha(str.substring(9))), String.valueOf(uin));
                AppMethodBeat.o(151449);
                return eW;
            }
            AppMethodBeat.o(151449);
            return str;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.ShortcutManager", null, "exception: %s", e2.getMessage());
            AppMethodBeat.o(151449);
            return null;
        }
    }

    public static String agZ(String str) {
        String eW;
        AppMethodBeat.i(151450);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(151450);
            return null;
        }
        String processNameByPid = Util.getProcessNameByPid(MMApplicationContext.getContext(), Process.myPid());
        String packageName = MMApplicationContext.getPackageName();
        if (!packageName.equals(processNameByPid) || g.aAf().azp()) {
            Log.i("MicroMsg.ShortcutManager", "process name: %s", processNameByPid);
            try {
                if (packageName.equals(processNameByPid)) {
                    StringBuilder sb = new StringBuilder();
                    g.aAf();
                    eW = eW(str, sb.append(a.getUin()).toString());
                } else {
                    eW = eW(str, new StringBuilder().append(af.bkl().jEj.getUin()).toString());
                }
                if (Util.isNullOrNil(eW)) {
                    AppMethodBeat.o(151450);
                    return null;
                }
                String str2 = "shortcut_" + toHexString(eW.getBytes());
                AppMethodBeat.o(151450);
                return str2;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.ShortcutManager", null, "exception: %s", e2.getMessage());
                AppMethodBeat.o(151450);
                return null;
            }
        } else {
            AppMethodBeat.o(151450);
            return null;
        }
    }

    public static String toHexString(byte[] bArr) {
        AppMethodBeat.i(151451);
        if (bArr == null) {
            AppMethodBeat.o(151451);
            return null;
        }
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i2 = 0; i2 < bArr.length; i2++) {
            sb.append(iNl[(bArr[i2] & 240) >>> 4]);
            sb.append(iNl[bArr[i2] & 15]);
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(151451);
        return sb2;
    }

    public static final byte[] aha(String str) {
        AppMethodBeat.i(151452);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(151452);
            return null;
        }
        byte[] bArr = new byte[(str.length() / 2)];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr[i2] = (byte) Integer.parseInt(str.substring(i2 * 2, (i2 * 2) + 2), 16);
        }
        AppMethodBeat.o(151452);
        return bArr;
    }
}
