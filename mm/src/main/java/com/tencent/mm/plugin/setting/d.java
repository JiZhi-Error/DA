package com.tencent.mm.plugin.setting;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v4.app.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.ch;
import com.tencent.mm.model.cj;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.protocal.protobuf.dbw;
import com.tencent.mm.protocal.protobuf.ye;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.ui.e;
import com.tencent.mm.y.c;
import com.tencent.recovery.wx.util.WXUtil;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class d implements bd {
    private static List<ye> CXv = null;
    private q CXA = new q() {
        /* class com.tencent.mm.plugin.setting.d.AnonymousClass5 */

        @Override // com.tencent.mm.plugin.messenger.foundation.a.q
        public final void onNewXmlReceived(String str, Map<String, String> map, h.a aVar) {
            AppMethodBeat.i(73750);
            if (map != null) {
                String str2 = map.get(".sysmsg.security");
                if (!Util.isNullOrNil(str2)) {
                    try {
                        int i2 = Util.getInt(str2, 0);
                        g.aAh().azQ().set(ar.a.USERINFO_DEVICE_PROTECT_SECURITY_STATUS_INT_SYNC, Integer.valueOf(i2));
                        if (i2 != 0) {
                            c.axV().b(ar.a.NEW_BANDAGE_DATASOURCE_DEVICE_PROTECT_STRING_SYNC, true);
                            AppMethodBeat.o(73750);
                            return;
                        }
                        c.axV().b(ar.a.NEW_BANDAGE_DATASOURCE_DEVICE_PROTECT_STRING_SYNC, false);
                        AppMethodBeat.o(73750);
                        return;
                    } catch (Exception e2) {
                        Log.printErrStackTrace("MicroMsg.SubCoreSetting", e2, "device protect security value is not number!", new Object[0]);
                    }
                }
            }
            AppMethodBeat.o(73750);
        }
    };
    private MStorageEx.IOnStorageChange CXw = new MStorageEx.IOnStorageChange() {
        /* class com.tencent.mm.plugin.setting.d.AnonymousClass1 */

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0009, code lost:
            r8 = (java.lang.String) r8;
         */
        @Override // com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onNotifyChange(int r6, com.tencent.mm.sdk.storage.MStorageEx r7, java.lang.Object r8) {
            /*
                r5 = this;
                r4 = 73746(0x12012, float:1.0334E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
                r0 = 2
                if (r6 != r0) goto L_0x003f
                java.lang.String r8 = (java.lang.String) r8
                java.lang.Class<com.tencent.mm.plugin.messenger.foundation.a.l> r0 = com.tencent.mm.plugin.messenger.foundation.a.l.class
                com.tencent.mm.kernel.c.a r0 = com.tencent.mm.kernel.g.af(r0)
                com.tencent.mm.plugin.messenger.foundation.a.l r0 = (com.tencent.mm.plugin.messenger.foundation.a.l) r0
                com.tencent.mm.storage.bv r0 = r0.aSN()
                com.tencent.mm.storage.as r0 = r0.bjF(r8)
                if (r0 == 0) goto L_0x003f
                int r1 = r0.field_type
                boolean r1 = com.tencent.mm.contact.c.oR(r1)
                if (r1 != 0) goto L_0x003f
                boolean r1 = r0.arw()
                if (r1 == 0) goto L_0x003f
                boolean r0 = r0.arx()
                if (r0 != 0) goto L_0x003f
                com.tencent.mm.sdk.platformtools.MMHandlerThread r0 = com.tencent.mm.kernel.g.aAk()
                com.tencent.mm.plugin.setting.d$1$1 r1 = new com.tencent.mm.plugin.setting.d$1$1
                r1.<init>(r8)
                r2 = 5000(0x1388, double:2.4703E-320)
                r0.postToWorkerDelayed(r1, r2)
            L_0x003f:
                com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.setting.d.AnonymousClass1.onNotifyChange(int, com.tencent.mm.sdk.storage.MStorageEx, java.lang.Object):void");
        }
    };
    private cj.a CXx = new cj.a() {
        /* class com.tencent.mm.plugin.setting.d.AnonymousClass2 */

        @Override // com.tencent.mm.model.cj.a
        public final void a(h.a aVar) {
            String str;
            AppMethodBeat.i(73747);
            String a2 = z.a(aVar.heO.KHn);
            if (a2 == null || a2.length() == 0) {
                Log.e("MicroMsg.SubCoreSetting", "onReceiveMsg, ShakeCardRedDotMsg msgContent is null");
                AppMethodBeat.o(73747);
                return;
            }
            Map<String, String> parseXml = XmlParser.parseXml(a2, "sysmsg", null);
            if (parseXml == null) {
                AppMethodBeat.o(73747);
                return;
            }
            String nullAs = Util.nullAs(parseXml.get(".sysmsg.RedPoints.redPoint.path"), "");
            int safeParseInt = Util.safeParseInt(Util.nullAs(parseXml.get(".sysmsg.RedPoints.redPoint.redPointId"), ""));
            Util.safeParseInt(Util.nullAs(parseXml.get(".sysmsg.RedPoints.redPoint.mustClearInSameTime"), ""));
            if (Util.isNullOrNil(nullAs)) {
                AppMethodBeat.o(73747);
            } else if (!nullAs.equals("my_setting_privaty_recentOption")) {
                if (nullAs.equals("my_setting_plugin_switch")) {
                    String nullAs2 = Util.nullAs(parseXml.get(".sysmsg.RedPoints.redPoint.ext"), "");
                    if (Util.isNullOrNil(nullAs2)) {
                        AppMethodBeat.o(73747);
                        return;
                    } else if (((Integer) g.aAh().azQ().get(ar.a.USERINFO_SETTING_PLUGIN_SWITCH_REDDOT_INT, (Object) 0)).intValue() >= safeParseInt) {
                        AppMethodBeat.o(73747);
                        return;
                    } else {
                        g.aAh().azQ().set(ar.a.USERINFO_SETTING_PLUGIN_SWITCH_REDDOT_INT, Integer.valueOf(safeParseInt));
                        String str2 = (String) g.aAh().azQ().get(ar.a.USERINFO_SETTING_PLUGIN_SWITCH_NAMES_STRING, "");
                        if (!Util.isNullOrNil(str2)) {
                            str = nullAs2.concat(",").concat(str2);
                        } else {
                            str = nullAs2;
                        }
                        g.aAh().azQ().set(ar.a.USERINFO_SETTING_PLUGIN_SWITCH_NAMES_STRING, str);
                        c.axV().B(262158, true);
                    }
                }
                AppMethodBeat.o(73747);
            } else if (((Integer) g.aAh().azQ().get(ar.a.USERINFO_SETTING_RECENT_RED_DOT_ID_INT, (Object) 0)).intValue() >= safeParseInt) {
                AppMethodBeat.o(73747);
            } else {
                g.aAh().azQ().set(ar.a.USERINFO_SETTING_RECENT_RED_DOT_ID_INT, Integer.valueOf(safeParseInt));
                g.aAh().azQ().set(ar.a.USERINFO_MY_RED_DOT_WILL_SHOW_ID_INT, Integer.valueOf(safeParseInt));
                g.aAh().azQ().set(ar.a.USERINFO_SETTING_RED_DOT_WILL_SHOW_ID_INT, Integer.valueOf(safeParseInt));
                g.aAh().azQ().set(ar.a.USERINFO_PRIVATY_RED_DOT_WILL_SHOW_ID_INT, Integer.valueOf(safeParseInt));
                g.aAh().azQ().set(ar.a.USERINFO_RECENT_RED_DOT_WILL_SHOW_ID_INT, Integer.valueOf(safeParseInt));
                c.axV().B(266260, true);
                AppMethodBeat.o(73747);
            }
        }

        @Override // com.tencent.mm.model.cj.a
        public final void a(h.c cVar) {
        }
    };
    private q CXy = new q() {
        /* class com.tencent.mm.plugin.setting.d.AnonymousClass3 */

        @Override // com.tencent.mm.plugin.messenger.foundation.a.q
        public final void onNewXmlReceived(String str, Map<String, String> map, h.a aVar) {
            AppMethodBeat.i(73748);
            if (map != null) {
                String str2 = map.get(".sysmsg.showtrustedfriends.wording");
                if (!Util.isNullOrNil(str2)) {
                    Intent intent = new Intent();
                    intent.putExtra(e.m.Ozm, str2);
                    com.tencent.mm.br.c.b(MMApplicationContext.getContext(), "setting", ".ui.setting.SettingsTrustFriendUI", intent);
                }
            }
            AppMethodBeat.o(73748);
        }
    };
    private cj.a CXz = new cj.a() {
        /* class com.tencent.mm.plugin.setting.d.AnonymousClass4 */

        @Override // com.tencent.mm.model.cj.a
        public final void a(h.a aVar) {
            AppMethodBeat.i(73749);
            String a2 = z.a(aVar.heO.KHn);
            if (a2 == null || a2.length() == 0) {
                Log.e("MicroMsg.SubCoreSetting", "onReceiveMsg, crowdtest msgContent is null");
                AppMethodBeat.o(73749);
                return;
            }
            Map<String, String> parseXml = XmlParser.parseXml(a2, "sysmsg", null);
            if (parseXml == null) {
                AppMethodBeat.o(73749);
                return;
            }
            int i2 = Util.getInt(parseXml.get(".sysmsg.crowdtest.$clientversion"), 0);
            if (i2 <= com.tencent.mm.protocal.d.KyO) {
                AppMethodBeat.o(73749);
                return;
            }
            long j2 = 0;
            try {
                j2 = new SimpleDateFormat("yyyy-MM-dd").parse(parseXml.get(".sysmsg.crowdtest.apply.$expire")).getTime();
            } catch (Exception e2) {
            }
            if (j2 < System.currentTimeMillis()) {
                d.eSF();
                AppMethodBeat.o(73749);
                return;
            }
            g.aAh().azQ().set(ar.a.USERINFO_CROWDTEST_CLIENT_VERSION_INT, Integer.valueOf(i2));
            g.aAh().azQ().set(ar.a.USERINFO_CROWDTEST_APPLY_EXPIRE_LONG, Long.valueOf(j2));
            g.aAh().azQ().set(ar.a.USERINFO_CROWDTEST_APPLY_LINK_STRING, parseXml.get(".sysmsg.crowdtest.apply.link"));
            g.aAh().azQ().set(ar.a.USERINFO_CROWDTEST_FEEDBACK_LINK_STRING, parseXml.get(".sysmsg.crowdtest.feedback.link"));
            int i3 = Util.getInt(parseXml.get(".sysmsg.crowdtest.apply.reddotlevel"), 0);
            c.axV().B(262157, i3 > 0);
            if (i3 < 3) {
                c.axV().cQ(262157, 266261);
            }
            if (i3 < 2) {
                c.axV().cQ(262157, 266262);
            }
            AppMethodBeat.o(73749);
        }

        @Override // com.tencent.mm.model.cj.a
        public final void a(h.c cVar) {
        }
    };

    static /* synthetic */ void eSF() {
        AppMethodBeat.i(256454);
        eSD();
        AppMethodBeat.o(256454);
    }

    public d() {
        AppMethodBeat.i(73751);
        Log.i("MicroMsg.SubCoreSetting", "SubCoreSetting constructor: " + System.currentTimeMillis());
        AppMethodBeat.o(73751);
    }

    @Override // com.tencent.mm.model.bd
    @SuppressLint({"UseSparseArrays"})
    public final HashMap<Integer, h.b> getBaseDBFactories() {
        return null;
    }

    @Override // com.tencent.mm.model.bd
    public final void clearPluginData(int i2) {
        AppMethodBeat.i(73752);
        Log.i("MicroMsg.SubCoreSetting", "SubCoreSetting clearPluginData: " + System.currentTimeMillis());
        AppMethodBeat.o(73752);
    }

    @Override // com.tencent.mm.model.bd
    public final void onAccountPostReset(boolean z) {
        AppMethodBeat.i(73753);
        Log.i("MicroMsg.SubCoreSetting", "SubCoreSetting onAccountPostReset: " + System.currentTimeMillis());
        ((s) g.ah(s.class)).getSysCmdMsgExtension().a("redpointinfo", this.CXx, true);
        ((s) g.ah(s.class)).getSysCmdMsgExtension().a("crowdtest", this.CXz, true);
        ((s) g.ah(s.class)).getSysCmdMsgExtension().a("showtrustedfriends", this.CXy);
        ((s) g.ah(s.class)).getSysCmdMsgExtension().a("DeviceProtectRedSpot", this.CXA);
        int intValue = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_CROWDTEST_CLIENT_VERSION_INT, Integer.valueOf(com.tencent.mm.protocal.d.KyO))).intValue();
        long longValue = ((Long) g.aAh().azQ().get(ar.a.USERINFO_CROWDTEST_APPLY_EXPIRE_LONG, (Object) 0L)).longValue();
        if (intValue <= com.tencent.mm.protocal.d.KyO || longValue < System.currentTimeMillis()) {
            eSD();
        }
        int intValue2 = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_FLAVOR_BLUE_CLIENT_VERSION_INT, (Object) 0)).intValue();
        Log.i("MicroMsg.SubCoreSetting", "SubCoreSetting onAccountPostReset flavorBlueCV: " + intValue2 + ",CLIENT_VERSION:" + com.tencent.mm.protocal.d.KyO);
        if (BuildInfo.IS_FLAVOR_BLUE && intValue2 < com.tencent.mm.protocal.d.KyO) {
            c.axV().B(262164, true);
            g.aAh().azQ().set(ar.a.USERINFO_FLAVOR_BLUE_CLIENT_VERSION_INT, Integer.valueOf(com.tencent.mm.protocal.d.KyO));
        }
        if (z) {
            g.aAh().azQ().set(34, Integer.valueOf(com.tencent.mm.model.z.aUl() & -1048577 & -4194305));
            dbw dbw = new dbw();
            dbw.KEc = 1048576;
            dbw.MGK = 0;
            ((l) g.af(l.class)).aSM().d(new k.a(39, dbw));
            dbw dbw2 = new dbw();
            dbw2.KEc = 4194304;
            dbw2.MGK = 0;
            ((l) g.af(l.class)).aSM().d(new k.a(39, dbw2));
            Log.i("MicroMsg.SubCoreSetting", "set void default open");
            if (!v.P(MMApplicationContext.getContext()).areNotificationsEnabled()) {
                Log.w("MicroMsg.SubCoreSetting", "sys notification disable！");
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(500, 18, 1, false);
            }
            Log.i("MicroMsg.SubCoreSetting", "is update from %s", Integer.valueOf(g.aAf().hpO.hrd));
            Set<String> aWo = ch.iFO.aWo();
            if (aWo.size() == 2) {
                String[] strArr = new String[2];
                int i2 = 0;
                for (String str : aWo) {
                    strArr[i2] = ch.iFO.getString(str, WXUtil.LAST_LOGIN_USERNAME);
                    i2++;
                }
                if (!Util.isNullOrNil(strArr[0], strArr[1]) && strArr[0].equals(strArr[1])) {
                    Log.w("MicroMsg.SubCoreSetting", "old dirty data!!!");
                    ch.iFO.KH(strArr[0]);
                    ch.iFO.KH(strArr[1]);
                }
            }
        }
        if (com.tencent.mm.n.h.aqJ().getInt("ShowTurnOnFriendVerificationSysmsgSwitch", 0) == 1 && (com.tencent.mm.model.z.aUc() & 32) == 0) {
            ((l) g.af(l.class)).aSN().add(this.CXw);
        }
        AppMethodBeat.o(73753);
    }

    @Override // com.tencent.mm.model.bd
    public final void onSdcardMount(boolean z) {
        AppMethodBeat.i(73754);
        Log.i("MicroMsg.SubCoreSetting", "SubCoreSetting onSdcardMount: " + System.currentTimeMillis());
        AppMethodBeat.o(73754);
    }

    @Override // com.tencent.mm.model.bd
    public final void onAccountRelease() {
        AppMethodBeat.i(73755);
        Log.i("MicroMsg.SubCoreSetting", "SubCoreSetting onAccountRelease: " + System.currentTimeMillis());
        ((s) g.ah(s.class)).getSysCmdMsgExtension().b("redpointinfo", this.CXx, true);
        ((s) g.ah(s.class)).getSysCmdMsgExtension().b("crowdtest", this.CXz, true);
        ((s) g.ah(s.class)).getSysCmdMsgExtension().b("showtrustedfriends", this.CXy);
        ((s) g.ah(s.class)).getSysCmdMsgExtension().b("DeviceProtectRedSpot", this.CXA);
        ((l) g.af(l.class)).aSN().remove(this.CXw);
        AppMethodBeat.o(73755);
    }

    private static void eSD() {
        AppMethodBeat.i(73756);
        g.aAh().azQ().set(ar.a.USERINFO_CROWDTEST_APPLY_EXPIRE_LONG, (Object) 0L);
        g.aAh().azQ().set(ar.a.USERINFO_CROWDTEST_APPLY_LINK_STRING, "");
        c.axV().B(262157, false);
        AppMethodBeat.o(73756);
    }

    public static List<ye> eSE() {
        return CXv;
    }

    public static void gF(List<ye> list) {
        CXv = list;
    }
}
