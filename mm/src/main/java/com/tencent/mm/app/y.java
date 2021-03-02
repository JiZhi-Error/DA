package com.tencent.mm.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kernel.i;
import com.tencent.mm.kernel.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.splash.d;
import com.tencent.mm.splash.h;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public final class y {
    public static final d dme = new d() {
        /* class com.tencent.mm.app.y.AnonymousClass1 */

        @Override // com.tencent.mm.splash.d
        public final boolean gh(String str) {
            AppMethodBeat.i(160130);
            boolean gi = y.gi(str);
            AppMethodBeat.o(160130);
            return gi;
        }

        @Override // com.tencent.mm.splash.d
        public final Activity q(Activity activity) {
            AppMethodBeat.i(160131);
            Activity p = y.p(activity);
            AppMethodBeat.o(160131);
            return p;
        }
    };
    private static final HashSet dmf = new HashSet();

    static /* synthetic */ boolean gi(String str) {
        AppMethodBeat.i(160104);
        boolean gh = gh(str);
        AppMethodBeat.o(160104);
        return gh;
    }

    static {
        AppMethodBeat.i(160106);
        dmf.addAll(Arrays.asList("com.tencent.mm.plugin.card.ui.CardHomePageUI", "com.tencent.mm.plugin.card.ui.CardHomePageNewUI", "com.tencent.mm.plugin.sns.ui.SnsTimeLineUI", "com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2UI", "com.tencent.mm.ui.chatting.gallery.ImageGalleryUI", "com.tencent.mm.ui.chatting.ChattingUI", "com.tencent.mm.plugin.setting.ui.setting.SettingsUI", "com.tencent.mm.plugin.scanner.ui.BaseScanUI", "com.tencent.mm.plugin.readerapp.ui.ReaderAppUI", "com.tencent.mm.ui.SingleChatInfoUI", "com.tencent.mm.plugin.sns.ui.SnsUploadUI", "com.tencent.mm.plugin.setting.ui.setting.SettingsPersonalInfoUI", "com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI", "com.tencent.mm.plugin.sns.ui.SnsBrowseUI", "com.tencent.mm.chatroom.ui.ChatroomInfoUI"));
        AppMethodBeat.o(160106);
    }

    private static boolean cO(boolean z) {
        AppMethodBeat.i(160101);
        if (!g.aAe().azG().aBb()) {
            if (z) {
                Log.i("MicroMsg.PreventAccountNotReady", "not main process");
            }
            AppMethodBeat.o(160101);
            return true;
        } else if (!g.aAi().hrr || !g.aAf().azp()) {
            AppMethodBeat.o(160101);
            return false;
        } else {
            if (z) {
                Log.i("MicroMsg.PreventAccountNotReady", "account hasInitialized");
            }
            AppMethodBeat.o(160101);
            return true;
        }
    }

    private static boolean gh(String str) {
        AppMethodBeat.i(160102);
        Log.i("MicroMsg.PreventAccountNotReady", "eatActivity %s", str);
        if (cO(true)) {
            AppMethodBeat.o(160102);
            return false;
        }
        if (str != null) {
            if (dmf.contains(str)) {
                Log.w("MicroMsg.PreventAccountNotReady", "protect this activity %s", str);
                AppMethodBeat.o(160102);
                return true;
            }
            try {
                g.aAe();
                ActivityInfo activityInfo = g.aAe().azG().ca.getPackageManager().getActivityInfo(new ComponentName(MMApplicationContext.getPackageName(), str), 128);
                if (activityInfo != null) {
                    Log.i("MicroMsg.PreventAccountNotReady", "%s info.exported = %s", str, Boolean.valueOf(activityInfo.exported));
                    if (!activityInfo.exported) {
                        AppMethodBeat.o(160102);
                        return true;
                    }
                }
            } catch (PackageManager.NameNotFoundException e2) {
                Log.printErrStackTrace("MicroMsg.PreventAccountNotReady", e2, "", new Object[0]);
            }
        }
        AppMethodBeat.o(160102);
        return false;
    }

    public static void WG() {
        boolean z;
        AppMethodBeat.i(160103);
        ArrayList arrayList = new ArrayList();
        Iterator<Message> it = h.NLC.iterator();
        while (it.hasNext()) {
            Message next = it.next();
            try {
                String h2 = a.h(next);
                if (h2 != null) {
                    if (((k) Class.forName(h2).getAnnotation(k.class)) != null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        h.p(next);
                        Log.i("MicroMsg.PreventAccountNotReady", "replay message for %s", h2);
                    }
                }
            } catch (Throwable th) {
                Log.printErrStackTrace("MicroMsg.PreventAccountNotReady", th, "", new Object[0]);
            }
            arrayList.add(next);
        }
        h.NLC.clear();
        h.NLC.addAll(arrayList);
        AppMethodBeat.o(160103);
    }

    public static final class a {
        private static boolean dmg = false;
        private static Class dmh;
        private static Field dmi;
        private static Class dmj;
        private static Field dmk;

        public static String h(Message message) {
            Intent intent;
            AppMethodBeat.i(160115);
            if (!dmg) {
                try {
                    Class<?> cls = Class.forName("android.app.ActivityThread$ReceiverData");
                    dmh = cls;
                    Field declaredField = cls.getDeclaredField("intent");
                    dmi = declaredField;
                    declaredField.setAccessible(true);
                    Class<?> cls2 = Class.forName("android.app.ActivityThread$CreateServiceData");
                    dmj = cls2;
                    Field declaredField2 = cls2.getDeclaredField("intent");
                    dmk = declaredField2;
                    declaredField2.setAccessible(true);
                    dmg = true;
                } catch (Throwable th) {
                    Log.printErrStackTrace("MicroMsg.PreventAccountNotReady", th, "", new Object[0]);
                }
            }
            if (!dmg) {
                AppMethodBeat.o(160115);
                return null;
            }
            try {
                if (dmh.isInstance(message.obj)) {
                    intent = (Intent) dmi.get(message.obj);
                } else {
                    if (dmj.isInstance(message.obj)) {
                        intent = (Intent) dmk.get(message.obj);
                    }
                    intent = null;
                }
            } catch (Throwable th2) {
                Log.printErrStackTrace("MicroMsg.PreventAccountNotReady", th2, "", new Object[0]);
            }
            if (intent != null) {
                String className = intent.getComponent().getClassName();
                AppMethodBeat.o(160115);
                return className;
            }
            AppMethodBeat.o(160115);
            return null;
        }
    }

    static /* synthetic */ Activity p(Activity activity) {
        boolean z;
        AppMethodBeat.i(160105);
        if (!cO(false) && activity != null) {
            Class<?> cls = activity.getClass();
            i iVar = (i) cls.getAnnotation(i.class);
            if (iVar != null || cls.getSuperclass() == null) {
                z = iVar != null;
            } else if (((i) cls.getSuperclass().getAnnotation(i.class)) != null) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                Log.w("MicroMsg.PreventAccountNotReady", "this activity %s need account but account not initiated, so we need replace it with a suicide activity.", activity);
                ad adVar = new ad();
                AppMethodBeat.o(160105);
                return adVar;
            }
        }
        AppMethodBeat.o(160105);
        return activity;
    }
}
