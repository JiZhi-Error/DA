package com.tencent.mm.plugin.appbrand.backgroundrunning;

import android.app.Notification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;

public final class d {
    public static List<b> bp(List<AppBrandBackgroundRunningApp> list) {
        AppMethodBeat.i(226446);
        if (list == null || list.isEmpty()) {
            Log.i("MicroMsg.AppBrand.AppBrandForegroundNotificationCommons", "buildCustomForegroundNotifications, apps is null");
            AppMethodBeat.o(226446);
            return null;
        }
        Log.i("MicroMsg.AppBrand.AppBrandForegroundNotificationCommons", "buildCustomForegroundNotifications, apps:%s", list);
        ArrayList arrayList = new ArrayList(list.size());
        for (AppBrandBackgroundRunningApp appBrandBackgroundRunningApp : list) {
            if (Util.isNullOrNil(appBrandBackgroundRunningApp.kYf) || Util.isNullOrNil(appBrandBackgroundRunningApp.appId)) {
                Log.w("MicroMsg.AppBrand.AppBrandForegroundNotificationCommons", "buildCustomForegroundNotifications, customNotificationLogicClassName:%s, appId: %s", appBrandBackgroundRunningApp.kYf, appBrandBackgroundRunningApp.appId);
            } else {
                q TQ = com.tencent.mm.plugin.appbrand.a.TQ(appBrandBackgroundRunningApp.appId);
                if (TQ == null) {
                    Log.w("MicroMsg.AppBrand.AppBrandForegroundNotificationCommons", "buildCustomForegroundNotifications, runtime of %s is null", appBrandBackgroundRunningApp.appId);
                } else {
                    Class<? extends CustomBackgroundRunningNotificationLogic> WB = WB(appBrandBackgroundRunningApp.kYf);
                    if (WB == null) {
                        Log.w("MicroMsg.AppBrand.AppBrandForegroundNotificationCommons", "buildCustomForegroundNotifications, customNotificationLogicClass of %s is null", appBrandBackgroundRunningApp.appId);
                    } else {
                        CustomBackgroundRunningNotificationLogic customBackgroundRunningNotificationLogic = (CustomBackgroundRunningNotificationLogic) TQ.aw(WB);
                        if (customBackgroundRunningNotificationLogic == null) {
                            customBackgroundRunningNotificationLogic = cO(appBrandBackgroundRunningApp.kYf, appBrandBackgroundRunningApp.appId);
                            if (customBackgroundRunningNotificationLogic == null) {
                                Log.w("MicroMsg.AppBrand.AppBrandForegroundNotificationCommons", "buildCustomForegroundNotifications, customNotificationLogic of %s is null", appBrandBackgroundRunningApp.appId);
                            } else {
                                TQ.a(customBackgroundRunningNotificationLogic);
                            }
                        }
                        customBackgroundRunningNotificationLogic.byQ();
                        arrayList.add(new b(customBackgroundRunningNotificationLogic.byP(), customBackgroundRunningNotificationLogic.getNotificationId()));
                    }
                }
            }
        }
        AppMethodBeat.o(226446);
        return arrayList;
    }

    /* JADX DEBUG: Type inference failed for r0v5. Raw type applied. Possible types: java.lang.Class<?>, java.lang.Class<? extends com.tencent.mm.plugin.appbrand.backgroundrunning.CustomBackgroundRunningNotificationLogic> */
    public static Class<? extends CustomBackgroundRunningNotificationLogic> WB(String str) {
        AppMethodBeat.i(226447);
        try {
            Class cls = Class.forName(str);
            AppMethodBeat.o(226447);
            return cls;
        } catch (Exception e2) {
            Log.w("MicroMsg.AppBrand.AppBrandForegroundNotificationCommons", "getCustomNotificationLogicClass fail since " + e2.toString());
            AppMethodBeat.o(226447);
            return null;
        }
    }

    private static CustomBackgroundRunningNotificationLogic cO(String str, String str2) {
        AppMethodBeat.i(226448);
        Log.i("MicroMsg.AppBrand.AppBrandForegroundNotificationCommons", "createCustomNotificationLogic, customNotificationLogicClassName:%s, appId: %s", str, str2);
        try {
            CustomBackgroundRunningNotificationLogic customBackgroundRunningNotificationLogic = (CustomBackgroundRunningNotificationLogic) WB(str).getConstructor(String.class).newInstance(str2);
            AppMethodBeat.o(226448);
            return customBackgroundRunningNotificationLogic;
        } catch (Exception e2) {
            Log.w("MicroMsg.AppBrand.AppBrandForegroundNotificationCommons", "createCustomNotificationLogic fail since " + e2.toString());
            AppMethodBeat.o(226448);
            return null;
        }
    }

    public static class a {
        public List<AppBrandBackgroundRunningApp> kYw;
        public List<AppBrandBackgroundRunningApp> kYx;

        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static class b {
        public final Notification kYy;
        public final int notificationId;

        public b(Notification notification, int i2) {
            this.kYy = notification;
            this.notificationId = i2;
        }
    }
}
