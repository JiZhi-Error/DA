package com.tencent.mm.sdk.platformtools;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.view.accessibility.AccessibilityManager;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;

public class AccessibilityUtil {
    private static String TAG = "AccessibilityUtil";
    private static HashSet<String> spokenServiceBlackSet;

    static /* synthetic */ void access$000(AccessibilityManager accessibilityManager) {
        AppMethodBeat.i(215280);
        printEnabledAccessibilityServiceInfo(accessibilityManager);
        AppMethodBeat.o(215280);
    }

    static {
        AppMethodBeat.i(215281);
        HashSet<String> hashSet = new HashSet<>();
        spokenServiceBlackSet = hashSet;
        hashSet.add("com.eg.android.AlipayGphone/com.alipay.mobile.rome.voicebroadcast.a11y.A11yService");
        spokenServiceBlackSet.add("com.apowersoft.mirror/.service.ListenAppService");
        spokenServiceBlackSet.add("com.tencent.android.qqdownloader/com.tencent.nucleus.manager.accessibility.YYBAccessibilityService");
        spokenServiceBlackSet.add("com.huawei.recsys/.service.PortraitDaService");
        spokenServiceBlackSet.add("com.samsung.android.app.sreminder/.phone.shoppingassistant.ShoppingAssistantService");
        AppMethodBeat.o(215281);
    }

    public static void smartDisableAccessibility() {
        AppMethodBeat.i(215277);
        try {
            Log.i(TAG, "smartDisableAccessibility");
            final AccessibilityManager accessibilityManager = (AccessibilityManager) MMApplicationContext.getContext().getSystemService("accessibility");
            boolean isEnabled = accessibilityManager.isEnabled();
            Field declaredField = AccessibilityManager.class.getDeclaredField("mIsHighTextContrastEnabled");
            declaredField.setAccessible(true);
            boolean booleanValue = ((Boolean) declaredField.get(accessibilityManager)).booleanValue();
            if (!isEnabled) {
                recoverAccessibilityEnable(accessibilityManager, booleanValue);
            }
            if (WeChatEnvironment.isCoolassistEnv() || BuildInfo.IS_FLAVOR_RED) {
                Log.i(TAG, "isCoolassistEnv or flavor red, return");
                AppMethodBeat.o(215277);
                return;
            }
            for (AccessibilityServiceInfo accessibilityServiceInfo : accessibilityManager.getEnabledAccessibilityServiceList(1)) {
                if (!spokenServiceBlackSet.contains(accessibilityServiceInfo.getId())) {
                    Log.i(TAG, "has spoken service, return");
                    printEnabledAccessibilityServiceInfo(accessibilityManager);
                    AppMethodBeat.o(215277);
                    return;
                }
            }
            if (accessibilityManager.isTouchExplorationEnabled()) {
                Log.i(TAG, "isTouchExplorationEnabled is true, return");
                AppMethodBeat.o(215277);
                return;
            }
            Log.i(TAG, "disableAccessibility");
            Method declaredMethod = AccessibilityManager.class.getDeclaredMethod("setStateLocked", Integer.TYPE);
            declaredMethod.setAccessible(true);
            int i2 = booleanValue ? 4 : 0;
            declaredMethod.invoke(accessibilityManager, Integer.valueOf(i2));
            Log.i(TAG, "smartDisableAccessibility setStateLocked is invoked, flag = %d", Integer.valueOf(i2));
            h.RTc.aX(new Runnable() {
                /* class com.tencent.mm.sdk.platformtools.AccessibilityUtil.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(215276);
                    AccessibilityUtil.access$000(accessibilityManager);
                    AppMethodBeat.o(215276);
                }
            });
            AppMethodBeat.o(215277);
        } catch (Throwable th) {
            Log.w(TAG, "disableAccessibility exception -> " + th.getMessage());
            AppMethodBeat.o(215277);
        }
    }

    private static void recoverAccessibilityEnable(AccessibilityManager accessibilityManager, boolean z) {
        int i2;
        AppMethodBeat.i(215278);
        try {
            Log.i(TAG, "recoverAccessibilityEnable");
            Method declaredMethod = AccessibilityManager.class.getDeclaredMethod("setStateLocked", Integer.TYPE);
            declaredMethod.setAccessible(true);
            if (accessibilityManager.isTouchExplorationEnabled()) {
                i2 = 3;
            } else {
                i2 = 1;
            }
            if (z) {
                i2 |= 4;
            }
            declaredMethod.invoke(accessibilityManager, Integer.valueOf(i2));
            Log.i(TAG, "recoverAccessibilityEnable setStateLocked is invoked, flag = %d", Integer.valueOf(i2));
            AppMethodBeat.o(215278);
        } catch (Throwable th) {
            Log.e(TAG, "recoverAccessibilityEnable error : %s", th.getMessage());
            AppMethodBeat.o(215278);
        }
    }

    private static void printEnabledAccessibilityServiceInfo(AccessibilityManager accessibilityManager) {
        AppMethodBeat.i(215279);
        Log.i(TAG, "printEnabledAccessibilityServiceInfo");
        try {
            Log.i(TAG, "printEnabledAccessibilityServiceInfo enabled = " + accessibilityManager.isEnabled());
            Iterator<AccessibilityServiceInfo> it = accessibilityManager.getEnabledAccessibilityServiceList(-1).iterator();
            while (it.hasNext()) {
                Log.i(TAG, "enabledAccessibilityServiceInfo : %s", it.next().toString());
            }
            AppMethodBeat.o(215279);
        } catch (Throwable th) {
            Log.e(TAG, "printEnabledAccessibilityServiceInfo error : %s", th.getMessage());
            AppMethodBeat.o(215279);
        }
    }
}
