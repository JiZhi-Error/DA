package com.tencent.matrix.report;

import com.facebook.internal.ServerProtocol;
import com.facebook.login.widget.ToolTipPopup;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.b;
import com.tencent.matrix.trace.a;
import com.tencent.matrix.trace.b.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.sqlitelint.SQLiteLintPlugin;
import com.tencent.sqlitelint.config.SharePluginInfo;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.n.n;
import org.json.JSONObject;

public final class f {
    private int cWj = 17108;
    private int cWk = 19999;
    private int cWl = 20841;
    private int cWm = 21019;

    public final void g(String str, JSONObject jSONObject) {
        boolean z;
        int safeParseInt;
        int i2;
        boolean z2;
        int i3;
        int i4;
        try {
            String string = jSONObject.getString("process");
            Log.i("MatrixIdKeyReporter", "[report] tag:%s processName:%s", str, string);
            if (!b.isInstalled()) {
                Log.i("MatrixIdKeyReporter", "matrix not installed");
                return;
            }
            com.tencent.matrix.e.b bVar = null;
            if (str != null) {
                if (!str.startsWith("Trace")) {
                    Iterator<com.tencent.matrix.e.b> it = b.RG().cqP.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            bVar = null;
                            break;
                        }
                        bVar = it.next();
                        if (bVar.getTag().equals(str)) {
                            break;
                        }
                    }
                } else {
                    bVar = b.RG().Y(a.class);
                }
            }
            if (bVar == null) {
                Log.e("MatrixIdKeyReporter", "plugin is null");
                return;
            }
            String str2 = "";
            if (bVar instanceof a) {
                String string2 = jSONObject.getString("tag");
                Log.i("MatrixIdKeyReporter", "[report] _tag:%s", string2);
                if (string2.equalsIgnoreCase("Trace_EvilMethod")) {
                    str2 = jSONObject.getString("detail");
                    if (str2.equalsIgnoreCase(a.EnumC0233a.ANR.toString())) {
                        boolean z3 = jSONObject.getBoolean("isProcessForeground");
                        String string3 = jSONObject.getString("stackKey");
                        String string4 = jSONObject.getString("threadStack");
                        String string5 = jSONObject.getString("scene");
                        h hVar = h.INSTANCE;
                        int i5 = this.cWj;
                        Object[] objArr = new Object[8];
                        objArr[0] = str;
                        objArr[1] = Integer.valueOf(d.KyO);
                        objArr[2] = str2;
                        objArr[3] = string3;
                        objArr[4] = string5;
                        objArr[5] = string4;
                        objArr[6] = string;
                        objArr[7] = Integer.valueOf(z3 ? 1 : 0);
                        hVar.a(i5, objArr);
                        h hVar2 = h.INSTANCE;
                        int i6 = this.cWk;
                        Object[] objArr2 = new Object[7];
                        objArr2[0] = Integer.valueOf(d.KyO);
                        objArr2[1] = str2;
                        objArr2[2] = string3;
                        objArr2[3] = string5;
                        objArr2[4] = string4;
                        objArr2[5] = string;
                        objArr2[6] = Integer.valueOf(z3 ? 1 : 0);
                        hVar2.a(i6, objArr2);
                        if (z3) {
                            e.INSTANCE.idkeyStat((long) eJ(string), 1, 1, true);
                        }
                        e.INSTANCE.idkeyStat((long) eJ(string), 0, 1, true);
                        e eVar = e.cWi;
                        p.h(string5, "scene");
                        if (e.eE(string5)) {
                            h.INSTANCE.n(1343, 100, 1);
                        }
                        z = true;
                    } else if (str2.equalsIgnoreCase(a.EnumC0233a.NORMAL.toString())) {
                        String string6 = jSONObject.getString("stackKey");
                        String string7 = jSONObject.getString("scene");
                        e.INSTANCE.idkeyStat((long) eJ(string), 21, 1, true);
                        h.INSTANCE.a(this.cWj, str, Integer.valueOf(d.KyO), str2, string6, string7, BuildConfig.COMMAND, string);
                        z = true;
                    } else if (str2.equalsIgnoreCase(a.EnumC0233a.LAG.toString())) {
                        String string8 = jSONObject.getString("scene");
                        if (string8.contains("Finder") || ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_lag_report, false)) {
                            h.INSTANCE.a(this.cWl, string8, jSONObject.getString("threadStack"), Boolean.valueOf(jSONObject.getBoolean("isProcessForeground")), 0, 0, string);
                        }
                        z = false;
                    }
                } else if (string2.equalsIgnoreCase("Trace_StartUp")) {
                    long j2 = jSONObject.getLong("startup_duration");
                    boolean z4 = jSONObject.getBoolean("is_warm_start_up");
                    Log.i("MatrixIdKeyReporter", "[startup] duration=%s isWarmStartUp=%s", Long.valueOf(j2), Boolean.valueOf(z4));
                    ArrayList<IDKey> arrayList = new ArrayList<>();
                    IDKey iDKey = new IDKey();
                    iDKey.SetID(eK(string));
                    iDKey.SetKey(z4 ? 3 : 0);
                    iDKey.SetValue(1);
                    arrayList.add(iDKey);
                    IDKey iDKey2 = new IDKey();
                    iDKey2.SetID(eK(string));
                    iDKey2.SetKey(z4 ? 4 : 1);
                    iDKey2.SetValue(j2);
                    arrayList.add(iDKey2);
                    IDKey iDKey3 = new IDKey();
                    iDKey3.SetID(eK(string));
                    iDKey3.SetValue(1);
                    arrayList.add(iDKey3);
                    if (j2 <= 3000) {
                        i3 = 1;
                        if (z4) {
                            i4 = 11;
                        } else {
                            i4 = 6;
                        }
                        iDKey3.SetKey(i4);
                    } else if (j2 <= ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME) {
                        i3 = 2;
                        iDKey3.SetKey(z4 ? 12 : 7);
                    } else if (j2 <= 9000) {
                        i3 = 3;
                        iDKey3.SetKey(z4 ? 13 : 8);
                    } else if (j2 <= 12000) {
                        i3 = 4;
                        iDKey3.SetKey(z4 ? 14 : 9);
                    } else {
                        i3 = 5;
                        iDKey3.SetKey(z4 ? 15 : 10);
                    }
                    e.INSTANCE.b(arrayList, true);
                    e.INSTANCE.a(this.cWm, Boolean.valueOf(z4), Long.valueOf(j2), Integer.valueOf(i3), string);
                    z = false;
                } else if (string2.equalsIgnoreCase("Trace_FPS")) {
                    String string9 = jSONObject.getString("scene");
                    e eVar2 = e.cWi;
                    p.h(string9, "scene");
                    p.h(jSONObject, "content");
                    p.h(string9, "scene");
                    if (e.eD(string9) || e.eE(string9) || e.eG(string9) || e.eF(string9)) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        double d2 = jSONObject.getDouble("fps");
                        String string10 = jSONObject.getString("machine");
                        p.g(string10, "content.getString(DeviceUtil.DEVICE_MACHINE)");
                        JSONObject jSONObject2 = jSONObject.getJSONObject("dropLevel");
                        p.g(jSONObject2, "content.getJSONObject(Sh…ginInfo.ISSUE_DROP_LEVEL)");
                        jSONObject2.getInt("DROPPED_BEST");
                        int i7 = jSONObject2.getInt("DROPPED_NORMAL");
                        int i8 = jSONObject2.getInt("DROPPED_MIDDLE");
                        int i9 = jSONObject2.getInt("DROPPED_HIGH");
                        int i10 = jSONObject2.getInt("DROPPED_FROZEN");
                        int i11 = i7 + i8 + i9 + i10;
                        float f2 = ((1.0f * ((float) i7)) / ((float) i11)) + ((14.0f * ((float) i8)) / ((float) i11)) + ((25.0f * ((float) i9)) / ((float) i11)) + ((60.0f * ((float) i10)) / ((float) i11));
                        ArrayList<IDKey> arrayList2 = new ArrayList<>();
                        p.h(string9, "scene");
                        if (n.e(string9, "FinderHomeUI")) {
                            IDKey iDKey4 = new IDKey();
                            iDKey4.SetID(1343);
                            iDKey4.SetKey(e.eH(string10) + 0);
                            iDKey4.SetValue((long) d2);
                            arrayList2.add(iDKey4);
                            IDKey iDKey5 = new IDKey();
                            iDKey5.SetID(1343);
                            iDKey5.SetKey(e.eH(string10) + 1);
                            iDKey5.SetValue((long) f2);
                            arrayList2.add(iDKey5);
                            IDKey iDKey6 = new IDKey();
                            iDKey6.SetID(1343);
                            iDKey6.SetKey(e.eH(string10) + 4);
                            iDKey6.SetValue(1);
                            arrayList2.add(iDKey6);
                        } else if (e.eE(string9)) {
                            IDKey iDKey7 = new IDKey();
                            iDKey7.SetID(1343);
                            iDKey7.SetKey(e.eH(string10) + 2);
                            iDKey7.SetValue((long) d2);
                            arrayList2.add(iDKey7);
                            IDKey iDKey8 = new IDKey();
                            iDKey8.SetID(1343);
                            iDKey8.SetKey(e.eH(string10) + 3);
                            iDKey8.SetValue((long) f2);
                            arrayList2.add(iDKey8);
                            IDKey iDKey9 = new IDKey();
                            iDKey9.SetID(1343);
                            iDKey9.SetKey(e.eH(string10) + 5);
                            iDKey9.SetValue(1);
                            arrayList2.add(iDKey9);
                        } else if (e.eD(string9)) {
                            IDKey iDKey10 = new IDKey();
                            iDKey10.SetID(1343);
                            iDKey10.SetKey(e.eI(string10) + 30);
                            iDKey10.SetValue((long) d2);
                            arrayList2.add(iDKey10);
                            IDKey iDKey11 = new IDKey();
                            iDKey11.SetID(1343);
                            iDKey11.SetKey(e.eI(string10) + 31);
                            iDKey11.SetValue((long) f2);
                            arrayList2.add(iDKey11);
                            IDKey iDKey12 = new IDKey();
                            iDKey12.SetID(1343);
                            iDKey12.SetKey(e.eI(string10) + 32);
                            iDKey12.SetValue(1);
                            arrayList2.add(iDKey12);
                        } else if (e.eF(string9)) {
                            IDKey iDKey13 = new IDKey();
                            iDKey13.SetID(1343);
                            iDKey13.SetKey(e.eI(string10) + 50);
                            iDKey13.SetValue((long) d2);
                            arrayList2.add(iDKey13);
                            IDKey iDKey14 = new IDKey();
                            iDKey14.SetID(1343);
                            iDKey14.SetKey(e.eI(string10) + 51);
                            iDKey14.SetValue((long) f2);
                            arrayList2.add(iDKey14);
                            IDKey iDKey15 = new IDKey();
                            iDKey15.SetID(1343);
                            iDKey15.SetKey(e.eI(string10) + 52);
                            iDKey15.SetValue(1);
                            arrayList2.add(iDKey15);
                        } else if (e.eG(string9)) {
                            IDKey iDKey16 = new IDKey();
                            iDKey16.SetID(1343);
                            iDKey16.SetKey(e.eI(string10) + 70);
                            iDKey16.SetValue((long) d2);
                            arrayList2.add(iDKey16);
                            IDKey iDKey17 = new IDKey();
                            iDKey17.SetID(1343);
                            iDKey17.SetKey(e.eI(string10) + 71);
                            iDKey17.SetValue((long) f2);
                            arrayList2.add(iDKey17);
                            IDKey iDKey18 = new IDKey();
                            iDKey18.SetID(1343);
                            iDKey18.SetKey(e.eI(string10) + 72);
                            iDKey18.SetValue(1);
                            arrayList2.add(iDKey18);
                        }
                        if (!arrayList2.isEmpty()) {
                            h.INSTANCE.b(arrayList2, false);
                            h.INSTANCE.a(19508, Long.valueOf((long) d2), string10, Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10), Float.valueOf(f2));
                        }
                    }
                    int i12 = -1;
                    if (string9.endsWith("SnsTimeLineUI")) {
                        i12 = 0;
                    } else if (string9.endsWith("ChattingUIFragment") || string9.endsWith("ChattingUI")) {
                        i12 = 20;
                    } else if (string9.endsWith("MainUI")) {
                        i12 = 40;
                    } else if (string9.endsWith("FinderHomeUI")) {
                        i12 = 100;
                    } else if (string9.endsWith("FinderProfileUI")) {
                        i12 = 120;
                    } else if (string9.endsWith("FinderTimelineLbsUI")) {
                        i12 = 140;
                    } else if (string9.endsWith("AddressUI")) {
                        i12 = 160;
                    }
                    if (i12 >= 0) {
                        double d3 = jSONObject.getDouble("fps");
                        JSONObject jSONObject3 = jSONObject.getJSONObject("dropLevel");
                        int i13 = jSONObject3.getInt("DROPPED_BEST");
                        int i14 = jSONObject3.getInt("DROPPED_NORMAL");
                        int i15 = jSONObject3.getInt("DROPPED_MIDDLE");
                        int i16 = jSONObject3.getInt("DROPPED_HIGH");
                        int i17 = jSONObject3.getInt("DROPPED_FROZEN");
                        Log.i("MatrixIdKeyReporter", "[getKeyOffset] scene:%s fps:%s offset:%s", string9, Double.valueOf(d3), Integer.valueOf(i12));
                        ArrayList<IDKey> arrayList3 = new ArrayList<>();
                        IDKey iDKey19 = new IDKey();
                        iDKey19.SetID(eJ(string));
                        iDKey19.SetKey(i12 + 47);
                        iDKey19.SetValue(1);
                        arrayList3.add(iDKey19);
                        IDKey iDKey20 = new IDKey();
                        iDKey20.SetID(eJ(string));
                        iDKey20.SetKey(i12 + 48);
                        iDKey20.SetValue((long) d3);
                        if (iDKey20.GetValue() > 0) {
                            arrayList3.add(iDKey20);
                        }
                        IDKey iDKey21 = new IDKey();
                        iDKey21.SetID(eJ(string));
                        iDKey21.SetKey(i12 + 49);
                        iDKey21.SetValue((long) i13);
                        if (iDKey21.GetValue() > 0) {
                            arrayList3.add(iDKey21);
                            IDKey iDKey22 = new IDKey();
                            iDKey22.SetID(eJ(string));
                            iDKey22.SetKey(i12 + 54);
                            iDKey22.SetValue(1);
                            arrayList3.add(iDKey22);
                        }
                        IDKey iDKey23 = new IDKey();
                        iDKey23.SetID(eJ(string));
                        iDKey23.SetKey(i12 + 50);
                        iDKey23.SetValue((long) i14);
                        if (iDKey23.GetValue() > 0) {
                            arrayList3.add(iDKey23);
                            IDKey iDKey24 = new IDKey();
                            iDKey24.SetID(eJ(string));
                            iDKey24.SetKey(i12 + 55);
                            iDKey24.SetValue(1);
                            arrayList3.add(iDKey24);
                        }
                        IDKey iDKey25 = new IDKey();
                        iDKey25.SetID(eJ(string));
                        iDKey25.SetKey(i12 + 51);
                        iDKey25.SetValue((long) i15);
                        if (iDKey25.GetValue() > 0) {
                            arrayList3.add(iDKey25);
                            IDKey iDKey26 = new IDKey();
                            iDKey26.SetID(eJ(string));
                            iDKey26.SetKey(i12 + 56);
                            iDKey26.SetValue(1);
                            arrayList3.add(iDKey26);
                        }
                        IDKey iDKey27 = new IDKey();
                        iDKey27.SetID(eJ(string));
                        iDKey27.SetKey(i12 + 52);
                        iDKey27.SetValue((long) i16);
                        if (iDKey27.GetValue() > 0) {
                            arrayList3.add(iDKey27);
                            IDKey iDKey28 = new IDKey();
                            iDKey28.SetID(eJ(string));
                            iDKey28.SetKey(i12 + 57);
                            iDKey28.SetValue(1);
                            arrayList3.add(iDKey28);
                        }
                        IDKey iDKey29 = new IDKey();
                        iDKey29.SetID(eJ(string));
                        iDKey29.SetKey(i12 + 53);
                        iDKey29.SetValue((long) i17);
                        if (iDKey29.GetValue() > 0) {
                            arrayList3.add(iDKey29);
                            IDKey iDKey30 = new IDKey();
                            iDKey30.SetID(eJ(string));
                            iDKey30.SetKey(i12 + 58);
                            iDKey30.SetValue(1);
                            arrayList3.add(iDKey30);
                        }
                        e.INSTANCE.b(arrayList3, false);
                    } else {
                        return;
                    }
                }
                z = false;
                str2 = str2;
            } else if (bVar instanceof com.tencent.matrix.iocanary.a) {
                e.INSTANCE.idkeyStat((long) eJ(string), 30, 1, false);
                z = false;
            } else if (bVar instanceof SQLiteLintPlugin) {
                e.INSTANCE.idkeyStat((long) eJ(string), 31, 1, false);
                if (ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equalsIgnoreCase(jSONObject.getString(SharePluginInfo.ISSUE_KEY_IS_IN_MAIN_THREAD)) && (safeParseInt = Util.safeParseInt(jSONObject.getString("sqlTimeCost"))) >= 80) {
                    if (safeParseInt < 500) {
                        i2 = 110;
                    } else if (safeParseInt < 1000) {
                        i2 = 111;
                    } else if (safeParseInt < 3000) {
                        i2 = 112;
                    } else if (safeParseInt < 5000) {
                        i2 = 113;
                    } else {
                        i2 = 114;
                    }
                    e.INSTANCE.idkeyStat((long) eJ(string), (long) i2, 1, false);
                }
                z = false;
            } else if (bVar instanceof com.tencent.matrix.a.a) {
                e.INSTANCE.idkeyStat((long) eJ(string), 32, 1, false);
                z = false;
            } else {
                if (bVar instanceof com.tencent.matrix.resource.b) {
                    e.INSTANCE.idkeyStat((long) eJ(string), 33, 1, false);
                    if (jSONObject.getString(EnvConsts.ACTIVITY_MANAGER_SRVNAME).endsWith("SnsTimeLineUI")) {
                        e.INSTANCE.idkeyStat((long) eJ(string), 34, 1, true);
                    }
                }
                z = false;
            }
            if (!z && !str.equalsIgnoreCase("io") && !str.equalsIgnoreCase("sqlitelint") && !str.equalsIgnoreCase("battery")) {
                h.INSTANCE.a(this.cWj, str, Integer.valueOf(d.KyO), str2);
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MatrixIdKeyReporter", e2, "data:%s", jSONObject.toString());
        }
    }

    private static int eJ(String str) {
        if (str.equalsIgnoreCase(MMApplicationContext.getApplicationId())) {
            return 1033;
        }
        if (str.equalsIgnoreCase(MMApplicationContext.getApplicationId() + ":tools")) {
            return 1187;
        }
        if (str.equalsIgnoreCase(MMApplicationContext.getApplicationId() + ":toolsmp")) {
            return 1188;
        }
        if (str.equalsIgnoreCase(MMApplicationContext.getApplicationId() + ":push")) {
            return 1189;
        }
        if (str.startsWith(MMApplicationContext.getApplicationId() + ":appbrand")) {
            return 1190;
        }
        return 1191;
    }

    private static int eK(String str) {
        if (str.equalsIgnoreCase(MMApplicationContext.getApplicationId())) {
            return 1192;
        }
        if (str.equalsIgnoreCase(MMApplicationContext.getApplicationId() + ":tools")) {
            return 1193;
        }
        return 1191;
    }
}
