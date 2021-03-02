package com.tencent.mm.plugin.expt.j;

import android.content.SharedPreferences;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.vendor.MIUI;
import java.util.Map;

public final class c implements b {
    @Override // com.tencent.mm.plugin.expt.j.b
    public final void axE() {
        Map<String, String> parseXml;
        int i2;
        boolean z = false;
        AppMethodBeat.i(220647);
        SharedPreferences apK = a.apK();
        apK.edit().putBoolean("keepaliveserviceswitch", ((b) g.af(b.class)).a(b.a.clicfg_keepaliveserviceswitch, false)).commit();
        int a2 = ((b) g.af(b.class)).a(b.a.clicfg_specialscenesetingsswitch, -1);
        Log.i("MicroMsg.NotificationSpecialSingleton", "iniNotificationSpecialSceneSwitchEnable() enable:%s", Integer.valueOf(a2));
        if (Util.isEqual(a2, 1)) {
            String a3 = ((b) g.af(b.class)).a(b.a.clicfg_specialscenesetingsswitchdetail, "");
            Log.i("MicroMsg.NotificationSpecialSingleton", "specialSceneDetail %s", a3);
            if (!Util.isNullOrNil(a3) && (parseXml = XmlParser.parseXml(a3, "manufacturerlist", null)) != null) {
                if (parseXml.containsKey(".manufacturerlist.size")) {
                    i2 = Util.getInt(parseXml.get(".manufacturerlist.size"), 0);
                } else {
                    i2 = 0;
                }
                int i3 = Build.VERSION.SDK_INT;
                int i4 = 0;
                while (true) {
                    if (i4 >= i2) {
                        break;
                    }
                    if (i4 == 0) {
                        if (String.valueOf(Util.nullAsNil(parseXml.get(".manufacturerlist.manufacturer.name"))).equalsIgnoreCase(Build.MANUFACTURER)) {
                            z = MIUI.ifInMinAndMax(i3, Util.nullAsNil(parseXml.get(".manufacturerlist.manufacturer.sdkversionmin")), Util.nullAsNil(parseXml.get(".manufacturerlist.manufacturer.sdkversionmax")), Util.nullAsNil(parseXml.get(".manufacturerlist.manufacturer.versintime")));
                            break;
                        }
                    } else if (String.valueOf(Util.nullAsNil(parseXml.get(".manufacturerlist.manufacturer" + i4 + ".name"))).equalsIgnoreCase(Build.MANUFACTURER)) {
                        z = MIUI.ifInMinAndMax(i3, Util.nullAsNil(parseXml.get(".manufacturerlist.manufacturer" + i4 + ".sdkversionmin")), Util.nullAsNil(parseXml.get(".manufacturerlist.manufacturer" + i4 + ".sdkversionmax")), Util.nullAsNil(parseXml.get(".manufacturerlist.manufacturer" + i4 + ".versintime")));
                        break;
                    }
                    i4++;
                }
            }
            a(apK, z);
            AppMethodBeat.o(220647);
        } else if (Util.isEqual(a2, 0)) {
            a(apK, false);
            AppMethodBeat.o(220647);
        } else {
            if (Util.isEqual(a2, 2)) {
                a(apK, true);
            }
            AppMethodBeat.o(220647);
        }
    }

    private static void a(SharedPreferences sharedPreferences, boolean z) {
        int i2;
        AppMethodBeat.i(220648);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        if (z) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        edit.putInt("special_scene_enable", i2).commit();
        Log.i("MicroMsg.NotificationSpecialSingleton", "setSpecialSceneEnable() enable: %s", Boolean.valueOf(z));
        AppMethodBeat.o(220648);
    }
}
