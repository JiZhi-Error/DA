package com.tencent.mm.booter.notification;

import android.app.Notification;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.notification.queue.NotificationQueue;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.n.g;
import com.tencent.mm.plugin.base.model.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public final class e {
    private static boolean gnO = true;
    private static boolean gnP = true;
    private static boolean gnQ = false;
    private static int gnR = -1;
    private static int gnS = -1;
    private static boolean gnT = true;
    private static String gnU = "samsung";
    public static boolean gnV = true;
    public static boolean gnW = false;
    private static int gnX = -1;
    private static boolean gnY = true;
    private static Uri gnZ = Uri.parse("content://com.android.badge/badge");

    public static void D(String str, int i2) {
        AppMethodBeat.i(19975);
        if (Util.isNullOrNil(str)) {
            Log.printErrStackTrace("MicroMsg.BusinessNotification", null, "syncUserBadge username is null", new Object[0]);
            AppMethodBeat.o(19975);
            return;
        }
        String agZ = b.agZ(str);
        if (Util.isNullOrNil(agZ)) {
            AppMethodBeat.o(19975);
            return;
        }
        E(agZ, i2);
        AppMethodBeat.o(19975);
    }

    public static void dk(boolean z) {
        AppMethodBeat.i(19976);
        if (!gnY) {
            AppMethodBeat.o(19976);
            return;
        }
        Context context = MMApplicationContext.getContext();
        if (context == null) {
            AppMethodBeat.o(19976);
            return;
        }
        ContentResolver contentResolver = context.getContentResolver();
        if (contentResolver == null) {
            AppMethodBeat.o(19976);
            return;
        }
        try {
            Log.i("MicroMsg.BusinessNotification", "sync all user badge");
            Bundle call = contentResolver.call(gnZ, "getShortcutList", (String) null, (Bundle) null);
            if (call == null) {
                Log.i("MicroMsg.BusinessNotification", "getShortcutList return null");
                AppMethodBeat.o(19976);
                return;
            }
            String string = call.getString("shortcut_list");
            if (string != null) {
                JSONArray jSONArray = new JSONArray(string);
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    String string2 = ((JSONObject) jSONArray.get(i2)).getString("app_shortcut_custom_id");
                    if (string2 != null && !string2.equalsIgnoreCase(BuildConfig.COMMAND)) {
                        String agY = b.agY(string2);
                        D(agY, z ? 0 : g.Eo(agY));
                    }
                }
            }
            AppMethodBeat.o(19976);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.BusinessNotification", e2, "sync all user badge: no support getShortcutList", new Object[0]);
            AppMethodBeat.o(19976);
        }
    }

    static {
        AppMethodBeat.i(19982);
        AppMethodBeat.o(19982);
    }

    public static int a(Notification notification, com.tencent.mm.booter.notification.a.g gVar) {
        int i2;
        AppMethodBeat.i(19977);
        if (notification == null || !gnO) {
            AppMethodBeat.o(19977);
            return 0;
        }
        if (gVar == null) {
            i2 = 0;
        } else {
            int alw = gVar.alw();
            NotificationQueue notificationQueue = com.tencent.mm.booter.notification.queue.b.alj().goq;
            if (notificationQueue.goo == null) {
                notificationQueue.restore();
            }
            Iterator it = notificationQueue.goo.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                i3 = ((NotificationItem) it.next()).goj + i3;
            }
            i2 = alw - i3;
        }
        try {
            Object newInstance = Class.forName("android.app.MiuiNotification").newInstance();
            Field declaredField = newInstance.getClass().getDeclaredField("messageCount");
            declaredField.setAccessible(true);
            declaredField.set(newInstance, Integer.valueOf(i2));
            notification.getClass().getField("extraNotification").set(notification, newInstance);
            Log.i("MicroMsg.BusinessNotification", "miuiNotification: %d", Integer.valueOf(i2));
        } catch (NoSuchFieldException e2) {
            gnO = false;
        } catch (IllegalArgumentException e3) {
            gnO = false;
        } catch (IllegalAccessException e4) {
            gnO = false;
        } catch (ClassNotFoundException e5) {
            gnO = false;
        } catch (InstantiationException e6) {
            gnO = false;
        } catch (Exception e7) {
            gnO = false;
        }
        AppMethodBeat.o(19977);
        return i2;
    }

    private static boolean alh() {
        AppMethodBeat.i(19978);
        if (gnW) {
            boolean z = gnV;
            AppMethodBeat.o(19978);
            return z;
        }
        gnW = true;
        if (!Build.BRAND.equals(gnU)) {
            gnV = false;
            AppMethodBeat.o(19978);
            return false;
        }
        gnV = true;
        AppMethodBeat.o(19978);
        return true;
    }

    private static void E(String str, int i2) {
        AppMethodBeat.i(19979);
        if (MMApplicationContext.getContext() == null) {
            Log.printErrStackTrace("MicroMsg.BusinessNotification", null, "normal badge context is null", new Object[0]);
            AppMethodBeat.o(19979);
            return;
        }
        Context context = MMApplicationContext.getContext();
        if (i2 < 0) {
            i2 = g.aqG();
        }
        c(context, str, i2);
        AppMethodBeat.o(19979);
    }

    private static boolean c(final Context context, final String str, final int i2) {
        AppMethodBeat.i(19980);
        ThreadPool.post(new Runnable() {
            /* class com.tencent.mm.booter.notification.e.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(184895);
                e.d(context, str, i2);
                AppMethodBeat.o(184895);
            }
        }, "normalNotification");
        AppMethodBeat.o(19980);
        return true;
    }

    public static void nU(final int i2) {
        boolean z = true;
        AppMethodBeat.i(19974);
        if (MMApplicationContext.getContext() != null && alh()) {
            Context context = MMApplicationContext.getContext();
            int aqG = i2 == -1 ? g.aqG() : i2;
            if (!(context == null || !alh() || gnX == aqG)) {
                gnX = aqG;
                Intent intent = new Intent("android.intent.action.BADGE_COUNT_UPDATE");
                intent.putExtra("badge_count", aqG);
                intent.putExtra("badge_count_package_name", MMApplicationContext.getPackageName());
                intent.putExtra("badge_count_class_name", LauncherUI.class.getName());
                Log.i("MicroMsg.BusinessNotification", "samsungNotification: %d, %s", Integer.valueOf(aqG), Build.BRAND);
                context.sendBroadcast(intent);
            }
        }
        if (gnT) {
            if (Build.VERSION.SDK_INT < 11) {
                gnT = false;
            } else if (gnS != i2) {
                ThreadPool.post(new Runnable() {
                    /* class com.tencent.mm.booter.notification.e.AnonymousClass1 */

                    public final void run() {
                        boolean z = true;
                        AppMethodBeat.i(19973);
                        try {
                            Bundle bundle = new Bundle();
                            bundle.putString("package", MMApplicationContext.getPackageName());
                            bundle.putString("class", LauncherUI.class.getName());
                            bundle.putInt("badgenumber", i2);
                            if (MMApplicationContext.getContext().getContentResolver().call(Uri.parse("content://com.huawei.android.launcher.settings/badge/"), "change_badge", (String) null, bundle) == null) {
                                z = false;
                            }
                            boolean unused = e.gnT = z;
                            Log.i("MicroMsg.BusinessNotification", "huawei badge: %d, %b", Integer.valueOf(i2), Boolean.valueOf(e.gnT));
                            AppMethodBeat.o(19973);
                        } catch (Exception e2) {
                            Log.i("MicroMsg.BusinessNotification", "no huawei badge");
                            Log.e("MicroMsg.BusinessNotification", "alvin: no badge" + e2.toString());
                            boolean unused2 = e.gnT = false;
                            AppMethodBeat.o(19973);
                        }
                    }
                }, "huaweiNotification");
            }
        }
        if (gnQ) {
            z = gnP;
        } else {
            gnQ = true;
            if (!Build.BRAND.equals("vivo")) {
                gnP = false;
                z = false;
            } else {
                gnP = true;
            }
        }
        if (z && gnR != i2) {
            try {
                Intent intent2 = new Intent("launcher.action.CHANGE_APPLICATION_NOTIFICATION_NUM");
                intent2.putExtra(AssistantStore.DownloadInfos.DownloadInfoColumns.PACKAGENAME, MMApplicationContext.getPackageName());
                intent2.putExtra("className", LauncherUI.class.getName());
                intent2.putExtra("notificationNum", i2);
                MMApplicationContext.getContext().sendBroadcast(intent2);
                Log.i("MicroMsg.BusinessNotification", "vivo badge: %d", Integer.valueOf(i2));
            } catch (Exception e2) {
                gnP = false;
                Log.printErrStackTrace("MicroMsg.BusinessNotification", e2, "", new Object[0]);
            }
        }
        E(null, i2);
        AppMethodBeat.o(19974);
    }

    static /* synthetic */ void d(Context context, String str, int i2) {
        boolean z = true;
        AppMethodBeat.i(184896);
        if (gnY) {
            try {
                Bundle bundle = new Bundle();
                if (str != null) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    arrayList.add(str);
                    bundle.putStringArrayList("app_shortcut_custom_id", arrayList);
                } else {
                    bundle.putStringArrayList("app_shortcut_custom_id", null);
                }
                bundle.putInt("app_badge_count", i2);
                bundle.putString("app_shortcut_class_name", MMApplicationContext.getSourcePackageName() + ".ui.LauncherUI");
                ContentResolver contentResolver = context.getContentResolver();
                if (contentResolver == null || contentResolver.call(gnZ, "setAppBadgeCount", (String) null, bundle) == null) {
                    z = false;
                }
                Log.i("MicroMsg.BusinessNotification", "shortcutId: %s, normalNotification badge count: %d, result: %b", str, Integer.valueOf(i2), Boolean.valueOf(z));
                AppMethodBeat.o(184896);
                return;
            } catch (Exception e2) {
                gnY = false;
                Log.e("MicroMsg.BusinessNotification", "alvin: no support normal badge");
            }
        }
        AppMethodBeat.o(184896);
    }
}
