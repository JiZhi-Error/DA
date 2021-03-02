package com.tencent.mm.plugin.groupsolitaire.b;

import android.content.Context;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.b.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.memory.a.c;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.groupsolitaire.PluginGroupSolitaire;
import com.tencent.mm.plugin.groupsolitaire.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.cjv;
import com.tencent.mm.protocal.protobuf.cjw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ca;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public final class b {
    private static final f<Integer, a> gAU = new c(32);

    public static String dXC() {
        AppMethodBeat.i(110322);
        String a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_solitaire_content_regex, "^([0-9]{1,3})(\\s*)([[)]．.,~。，、:;\\-_#@!&*%）：；\\—\\—！])(\\s*)");
        Log.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "mainBodyRegex:%s", a2);
        AppMethodBeat.o(110322);
        return a2;
    }

    public static String dXD() {
        AppMethodBeat.i(110323);
        String a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_solitaire_separator_regex, "^([0-9]{1,3})(\\s*)([[)]．.,~。，、:;\\-_#@!&*%）：；\\—\\—！])");
        Log.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "separatorRegex:%s", a2);
        AppMethodBeat.o(110323);
        return a2;
    }

    public static String dXE() {
        AppMethodBeat.i(110324);
        String a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_solitaire_content_separator_regex, "([0-9]{1,3})(\\s*)([.。;；、:,，])");
        Log.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "contentSeparatorRegex:%s", a2);
        AppMethodBeat.o(110324);
        return a2;
    }

    public static String dXF() {
        AppMethodBeat.i(110325);
        String a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_solitaire_num_regex, "^\\d{1,3}");
        Log.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "numRegex:%s", a2);
        AppMethodBeat.o(110325);
        return a2;
    }

    public static String dXG() {
        AppMethodBeat.i(194422);
        String a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_solitaire_single_num_regex, "^\\d{1,3}$");
        Log.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "SingleNum:%s", a2);
        AppMethodBeat.o(194422);
        return a2;
    }

    public static String dXH() {
        AppMethodBeat.i(110326);
        String a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_solitaire_content_num_regex, "\\d{1,3}");
        Log.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "contentNumRegex:%s", a2);
        AppMethodBeat.o(110326);
        return a2;
    }

    public static String dXI() {
        AppMethodBeat.i(110327);
        String a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_solitaire_example_regex, "(例|例如|如|格式|格式如)(\\s*)([,.:，：、 ])(.+)");
        Log.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "exampleRegex:%s", a2);
        AppMethodBeat.o(110327);
        return a2;
    }

    public static int dXJ() {
        AppMethodBeat.i(110328);
        int a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_solitaire_active_duration, 3);
        Log.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "getLastSolitatireActiveIntervalTime() maxNum:%s", Integer.valueOf(a2));
        AppMethodBeat.o(110328);
        return a2;
    }

    public static int dXK() {
        AppMethodBeat.i(110329);
        int a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_solitaire_active_max_count, 5);
        Log.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "getMaxGroupSolitatireActiveNum() maxNum:%s", Integer.valueOf(a2));
        AppMethodBeat.o(110329);
        return a2;
    }

    public static int dXL() {
        AppMethodBeat.i(110330);
        int a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_solitaire_match_duration, 24);
        Log.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "getLastSolitatireMatchIntervalTime() maxNum:%s", Integer.valueOf(a2));
        AppMethodBeat.o(110330);
        return a2;
    }

    public static int dXM() {
        AppMethodBeat.i(110331);
        int a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_solitaire_match_max_count, 10);
        Log.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "getMaxGroupSolitatireMatchNum() maxNum:%s", Integer.valueOf(a2));
        AppMethodBeat.o(110331);
        return a2;
    }

    public static int dXN() {
        AppMethodBeat.i(110332);
        int a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_solitaire_content_max_count, 500);
        Log.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "getMaxSolitatireNum() maxNum:%s", Integer.valueOf(a2));
        AppMethodBeat.o(110332);
        return a2;
    }

    public static int dXO() {
        AppMethodBeat.i(110333);
        int a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_solitaire_body_item_word_maxcount, 150);
        Log.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "getMaxSolitatireItemWordNum() maxNum:%s", Integer.valueOf(a2));
        AppMethodBeat.o(110333);
        return a2;
    }

    public static int dXP() {
        AppMethodBeat.i(178792);
        int a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_solitaire_header_word_maxcount, 500);
        Log.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "getMaxSolitatireItemWordNum() maxNum:%s", Integer.valueOf(a2));
        AppMethodBeat.o(178792);
        return a2;
    }

    public static int dXQ() {
        AppMethodBeat.i(178793);
        int a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_solitaire_end_word_maxcount, 500);
        Log.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "getMaxSolitatireItemWordNum() maxNum:%s", Integer.valueOf(a2));
        AppMethodBeat.o(178793);
        return a2;
    }

    private static boolean dXR() {
        AppMethodBeat.i(194423);
        int a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_solitaire_xml_use_c_tag_sw, 0);
        Log.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "isXmlForceUseCTagSwt() swt:%s", Integer.valueOf(a2));
        if (a2 == 1) {
            AppMethodBeat.o(194423);
            return true;
        }
        AppMethodBeat.o(194423);
        return false;
    }

    public static String dXS() {
        AppMethodBeat.i(194424);
        String a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_solitaire_content_equal_white_list_regex, "(\\.|。|,|，|:|：|;|；|、|-|\\s)");
        Log.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "equalStrWhiteListRegex:%s", a2);
        AppMethodBeat.o(194424);
        return a2;
    }

    public static String a(a aVar) {
        AppMethodBeat.i(110334);
        if (Util.isNullOrNil(aVar.header) && Util.isNullOrNil(aVar.yfB) && Util.isNullOrNil(aVar.xxN) && aVar.yfC == 1) {
            aVar.yfC = 0;
            if (aVar.yfE.size() > 0) {
                aVar.header = aVar.yfE.get(1).content;
                aVar.yfE.get(1).yfH = 1;
            }
        }
        String messageDigest = com.tencent.mm.b.g.getMessageDigest(MMApplicationContext.getContext().getString(R.string.dw2, aVar.header.trim(), new StringBuilder().append(aVar.yfC).toString(), aVar.yfB.trim(), aVar.xxN.trim()).getBytes());
        AppMethodBeat.o(110334);
        return messageDigest;
    }

    public static boolean aS(Context context, String str) {
        AppMethodBeat.i(110335);
        if (Util.isNullOrNil(str) || context == null) {
            AppMethodBeat.o(110335);
            return false;
        }
        String trim = str.trim();
        if (Util.isEqual(trim, context.getString(R.string.dvu)) || Util.isEqual(trim, context.getString(R.string.dvv))) {
            AppMethodBeat.o(110335);
            return true;
        }
        AppMethodBeat.o(110335);
        return false;
    }

    public static boolean aT(Context context, String str) {
        AppMethodBeat.i(110336);
        if (Util.isNullOrNil(str) || context == null) {
            AppMethodBeat.o(110336);
            return false;
        }
        String trim = str.trim();
        if (trim.startsWith(context.getString(R.string.dvu)) || trim.startsWith(context.getString(R.string.dvv))) {
            AppMethodBeat.o(110336);
            return true;
        }
        AppMethodBeat.o(110336);
        return false;
    }

    public static void a(String str, String str2, a aVar, long j2, boolean z) {
        AppMethodBeat.i(110337);
        long aWB = (long) cl.aWB();
        if (j2 != 0) {
            aWB = ((l) g.af(l.class)).eiy().Hb(j2).field_createTime / 1000;
        }
        b(str, str2, aVar, aWB, z);
        AppMethodBeat.o(110337);
    }

    public static void a(String str, String str2, a aVar) {
        AppMethodBeat.i(110338);
        b(str, str2, aVar, (long) cl.aWB(), true);
        AppMethodBeat.o(110338);
    }

    private static void b(String str, String str2, a aVar, long j2, boolean z) {
        AppMethodBeat.i(110339);
        if (aVar == null) {
            AppMethodBeat.o(110339);
            return;
        }
        aVar.field_key = a(aVar);
        aVar.field_lastActiveTime = j2;
        if (z) {
            aVar.field_active = 1;
        } else {
            aVar.field_active = 0;
        }
        if (Util.isNullOrNil(aVar.field_username)) {
            aVar.field_username = str;
        }
        if (Util.isNullOrNil(aVar.field_creator)) {
            aVar.field_creator = str2;
        }
        HashMap<Integer, com.tencent.mm.plugin.groupsolitaire.c.b> hashMap = new HashMap<>();
        HashSet hashSet = new HashSet();
        aVar.yfF = false;
        aVar.header = aVar.header.trim();
        aVar.yfB = aVar.yfB.trim();
        aVar.xxN = aVar.xxN.trim();
        for (int i2 = 1; i2 <= aVar.yfE.size(); i2++) {
            com.tencent.mm.plugin.groupsolitaire.c.b bVar = aVar.yfE.get(Integer.valueOf(i2));
            if (!Util.isNullOrNil(bVar.content) && !Util.isNullOrNil(bVar.content.trim())) {
                bVar.content = bVar.content.trim();
                if (hashSet.contains(((com.tencent.mm.plugin.emoji.b.a) g.af(com.tencent.mm.plugin.emoji.b.a.class)).alW(bVar.content))) {
                    aVar.yfF = true;
                }
                hashSet.add(((com.tencent.mm.plugin.emoji.b.a) g.af(com.tencent.mm.plugin.emoji.b.a.class)).alW(bVar.content));
                hashMap.put(Integer.valueOf(hashMap.size() + 1), bVar);
                if (bVar.createtime == MAlarmHandler.NEXT_FIRE_INTERVAL) {
                    bVar.createtime = j2;
                }
                if (Util.isNullOrNil(bVar.username)) {
                    bVar.username = str2;
                }
            }
        }
        aVar.yfE = hashMap;
        AppMethodBeat.o(110339);
    }

    public static void b(a aVar) {
        AppMethodBeat.i(161734);
        if (aVar != null && aVar.field_msgSvrId == 0) {
            aVar.field_msgSvrId = ((l) g.af(l.class)).eiy().Hb(aVar.field_firstMsgId).field_msgSvrId;
            Log.i("MicroMsg.groupsolitaire.GroupSolitatireHelp", "fixMsgSvrId ret:%s", Boolean.valueOf(((PluginGroupSolitaire) g.ah(PluginGroupSolitaire.class)).getGroupSolitatireStorage().a(aVar, true)));
        }
        AppMethodBeat.o(161734);
    }

    public static void c(a aVar) {
        AppMethodBeat.i(110340);
        if (aVar != null && aVar.yfF) {
            HashMap<Integer, com.tencent.mm.plugin.groupsolitaire.c.b> hashMap = new HashMap<>();
            HashSet hashSet = new HashSet();
            aVar.yfF = false;
            for (int i2 = 1; i2 <= aVar.yfE.size(); i2++) {
                com.tencent.mm.plugin.groupsolitaire.c.b bVar = aVar.yfE.get(Integer.valueOf(i2));
                if (!hashSet.contains(bVar.content)) {
                    hashSet.add(bVar.content);
                    hashMap.put(Integer.valueOf(hashMap.size() + 1), bVar);
                }
            }
            aVar.yfE = hashMap;
        }
        AppMethodBeat.o(110340);
    }

    public static boolean ay(ca caVar) {
        AppMethodBeat.i(110341);
        if (caVar == null) {
            AppMethodBeat.o(110341);
            return false;
        }
        String str = caVar.field_talker;
        String str2 = caVar.fRd;
        if (((j) g.af(j.class)).aBg(str)) {
            a ib = ((PluginGroupSolitaire) g.ah(PluginGroupSolitaire.class)).getGroupSolitatireManager().ib(str, str2);
            a aBm = ((PluginGroupSolitaire) g.ah(PluginGroupSolitaire.class)).getGroupSolitatireManager().aBm(str);
            if (ib == null) {
                AppMethodBeat.o(110341);
                return false;
            } else if (aBm == null) {
                AppMethodBeat.o(110341);
                return false;
            } else if (ib.field_active != 1 || ib.field_lastActiveTime < aBm.yfa || ib.yfE.size() >= dXN() || caVar.field_msgId < ib.field_firstMsgId) {
                AppMethodBeat.o(110341);
                return false;
            } else {
                AppMethodBeat.o(110341);
                return true;
            }
        } else {
            AppMethodBeat.o(110341);
            return false;
        }
    }

    public static boolean U(String str, String str2, int i2) {
        boolean z;
        boolean z2;
        boolean z3;
        AppMethodBeat.i(194425);
        a ib = ((PluginGroupSolitaire) g.ah(PluginGroupSolitaire.class)).getGroupSolitatireManager().ib(str, str2);
        a aBm = ((PluginGroupSolitaire) g.ah(PluginGroupSolitaire.class)).getGroupSolitatireManager().aBm(str);
        if (ib == null) {
            AppMethodBeat.o(194425);
            return true;
        }
        if (aBm == null) {
            z3 = true;
        } else {
            if (ib.field_active != 1 || ib.field_lastActiveTime < aBm.yfa || ib.yfE.size() >= dXN()) {
                z = false;
            } else {
                z = true;
            }
            if (ib.field_active != 0 || ib.field_lastActiveTime < aBm.yfc) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z || z2) {
                z3 = false;
            } else {
                z3 = true;
            }
        }
        if (z3 || !Util.isEqual(ib.field_creator, z.aTY()) || i2 > 1) {
            AppMethodBeat.o(194425);
            return z3;
        }
        AppMethodBeat.o(194425);
        return true;
    }

    public static a a(a aVar, a aVar2, String str, int i2) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(174561);
        if (aVar == null || aVar2 == null) {
            AppMethodBeat.o(174561);
            return aVar2;
        }
        int a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_solitaire_loss_efficacy_sw, 1);
        Log.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "getLossEfficacySwt() swt:%s", Integer.valueOf(a2));
        if (a2 == 1) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            AppMethodBeat.o(174561);
            return aVar2;
        }
        if (i2 == 1) {
            if (!Util.isEqual(str, aVar2.field_creator)) {
                AppMethodBeat.o(174561);
                return aVar2;
            } else if (aVar.yfE.size() > 1) {
                AppMethodBeat.o(174561);
                return aVar2;
            }
        } else if (i2 != 2) {
            if (i2 != 3) {
                AppMethodBeat.o(174561);
                return aVar2;
            } else if (!aVar.yfD) {
                AppMethodBeat.o(174561);
                return aVar2;
            }
        }
        com.tencent.mm.plugin.groupsolitaire.c.c groupSolitatireStorage = ((PluginGroupSolitaire) g.ah(PluginGroupSolitaire.class)).getGroupSolitatireStorage();
        if (aVar2 == null) {
            z2 = true;
        } else {
            boolean delete = groupSolitatireStorage.delete(aVar2.systemRowid);
            if (delete) {
                ((PluginGroupSolitaire) g.ah(PluginGroupSolitaire.class)).getGroupSolitatireManager().ic(aVar2.field_username, aVar2.field_key);
            }
            z2 = delete;
        }
        Log.i("MicroMsg.groupsolitaire.GroupSolitatireHelp", "handleSolitatireLossEfficacy key:%s result:%s", aVar2.field_key, Boolean.valueOf(z2));
        AppMethodBeat.o(174561);
        return null;
    }

    public static boolean a(a aVar, a aVar2, long j2, boolean z, String str, boolean z2, long j3) {
        AppMethodBeat.i(194426);
        boolean a2 = a(aVar, aVar2, j2, z, str, z2, false, j3);
        AppMethodBeat.o(194426);
        return a2;
    }

    public static boolean a(a aVar, a aVar2, long j2, boolean z, String str, boolean z2, boolean z3, long j3) {
        AppMethodBeat.i(194427);
        a a2 = a(aVar, aVar2, str, z2, z3);
        if (a2 != null && a2.field_firstMsgId == 0) {
            a2.field_firstMsgId = j2;
        }
        a2.field_lastActiveTime = j3;
        boolean a3 = a(a2, aVar2 != null, z);
        if (j2 != 0 && a3) {
            ca Hb = ((l) g.af(l.class)).eiy().Hb(j2);
            Hb.CJ(aVar.field_key);
            ((l) g.af(l.class)).eiy().a(j2, Hb);
            if (z && aVar2 != null && aVar2.field_active == 0 && a2.yfE.size() > 1) {
                ((PluginGroupSolitaire) g.ah(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
                d.b(a2, str);
            }
            if (aVar2 == null && a2 != null) {
                a r = ((PluginGroupSolitaire) g.ah(PluginGroupSolitaire.class)).getGroupSolitatireStorage().r(a2.field_username, a2.field_key, true);
                if (r.field_msgSvrId == 0) {
                    r.field_msgSvrId = Hb.field_msgSvrId;
                    ((PluginGroupSolitaire) g.ah(PluginGroupSolitaire.class)).getGroupSolitatireStorage().a(r, true);
                }
            }
        }
        Object[] objArr = new Object[3];
        objArr[0] = a2 == null ? BuildConfig.COMMAND : a2.field_key;
        objArr[1] = Long.valueOf(j2);
        objArr[2] = Boolean.valueOf(a3);
        Log.i("MicroMsg.groupsolitaire.GroupSolitatireHelp", "mergeAndSaveGroupSolitatire() key:%s msgId:%s ret:%s", objArr);
        AppMethodBeat.o(194427);
        return a3;
    }

    public static boolean a(a aVar, boolean z, boolean z2) {
        boolean i2;
        AppMethodBeat.i(110344);
        if (aVar == null) {
            AppMethodBeat.o(110344);
            return false;
        } else if (!((j) g.af(j.class)).aBg(aVar.field_username)) {
            AppMethodBeat.o(110344);
            return false;
        } else {
            Log.i("MicroMsg.groupsolitaire.GroupSolitatireHelp", "saveGroupSolitatire key:%s exist:%s supportOnlyOne:%s num:%s", aVar.field_key, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(aVar.yfE.size()));
            if (z) {
                if (aVar.yfE.size() > dXN()) {
                    i2 = false;
                } else {
                    i2 = ((PluginGroupSolitaire) g.ah(PluginGroupSolitaire.class)).getGroupSolitatireStorage().a(aVar, false);
                }
            } else if (!z2 || aVar.yfE.size() <= 1) {
                i2 = ((PluginGroupSolitaire) g.ah(PluginGroupSolitaire.class)).getGroupSolitatireStorage().i(aVar);
            } else {
                i2 = false;
            }
            Log.i("MicroMsg.groupsolitaire.GroupSolitatireHelp", "saveGroupSolitatire() ret:%s", Boolean.valueOf(i2));
            if (i2) {
                ((PluginGroupSolitaire) g.ah(PluginGroupSolitaire.class)).getGroupSolitatireManager().aBn(aVar.field_username);
                ((PluginGroupSolitaire) g.ah(PluginGroupSolitaire.class)).getGroupSolitatireManager().ic(aVar.field_username, aVar.field_key);
                aBh(aVar.field_username);
            }
            Log.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "saveGroupSolitatire() groupSolitatire:%s", aVar);
            AppMethodBeat.o(110344);
            return i2;
        }
    }

    public static void aBh(final String str) {
        AppMethodBeat.i(110345);
        Log.i("MicroMsg.groupsolitaire.GroupSolitatireHelp", "deleteExpireGroupSolitatire() batch delete expire data!! (%s)", str);
        if (Util.isNullOrNil(str) || !ab.Eq(str)) {
            AppMethodBeat.o(110345);
            return;
        }
        MMHandlerThread.postToMainThreadDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.groupsolitaire.b.b.AnonymousClass1 */

            public final void run() {
                boolean z;
                boolean z2;
                AppMethodBeat.i(110317);
                a aBm = ((PluginGroupSolitaire) g.ah(PluginGroupSolitaire.class)).getGroupSolitatireManager().aBm(str);
                if (aBm == null) {
                    Log.i("MicroMsg.groupsolitaire.GroupSolitatireHelp", "deleteExpireGroupSolitatire() chatRoomGroupSolitatire == null");
                    AppMethodBeat.o(110317);
                    return;
                }
                List<a> E = ((PluginGroupSolitaire) g.ah(PluginGroupSolitaire.class)).getGroupSolitatireStorage().E(str, 1, aBm.yfa);
                if (E.size() > 0) {
                    z = ((PluginGroupSolitaire) g.ah(PluginGroupSolitaire.class)).getGroupSolitatireStorage().F(str, 1, aBm.yfa);
                    if (aBm.yeZ) {
                        ((PluginGroupSolitaire) g.ah(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
                        d.x(E, 2);
                    } else {
                        ((PluginGroupSolitaire) g.ah(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
                        d.x(E, 1);
                    }
                } else {
                    z = false;
                }
                List<a> E2 = ((PluginGroupSolitaire) g.ah(PluginGroupSolitaire.class)).getGroupSolitatireStorage().E(str, 0, aBm.yfc);
                if (E2.size() > 0) {
                    boolean F = ((PluginGroupSolitaire) g.ah(PluginGroupSolitaire.class)).getGroupSolitatireStorage().F(str, 0, aBm.yfc);
                    if (aBm.yfb) {
                        ((PluginGroupSolitaire) g.ah(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
                        d.x(E2, 2);
                        z2 = F;
                    } else {
                        ((PluginGroupSolitaire) g.ah(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
                        d.x(E2, 1);
                        z2 = F;
                    }
                } else {
                    z2 = false;
                }
                Log.i("MicroMsg.groupsolitaire.GroupSolitatireHelp", "deleteExpireGroupSolitatire() activeResult:%s unActiveResult:%s", Boolean.valueOf(z), Boolean.valueOf(z2));
                AppMethodBeat.o(110317);
            }
        }, 1000);
        AppMethodBeat.o(110345);
    }

    public static void a(String str, a aVar) {
        AppMethodBeat.i(110346);
        if (aVar == null) {
            AppMethodBeat.o(110346);
            return;
        }
        String aTY = z.aTY();
        if (Util.isNullOrNil(aVar.field_creator)) {
            aVar.field_creator = aTY;
        }
        if (Util.isNullOrNil(aVar.field_username)) {
            aVar.field_username = str;
        }
        for (int i2 = 1; i2 <= aVar.yfE.size(); i2++) {
            com.tencent.mm.plugin.groupsolitaire.c.b bVar = aVar.yfE.get(Integer.valueOf(i2));
            if (Util.isNullOrNil(bVar.username)) {
                bVar.username = aTY;
            }
        }
        AppMethodBeat.o(110346);
    }

    public static a a(a aVar, a aVar2, a aVar3) {
        com.tencent.mm.plugin.groupsolitaire.c.b bVar;
        AppMethodBeat.i(178794);
        if (aVar == null && aVar3 == null) {
            AppMethodBeat.o(178794);
            return null;
        } else if (aVar == null && aVar3 != null) {
            AppMethodBeat.o(178794);
            return aVar3;
        } else if (aVar != null && aVar3 == null) {
            AppMethodBeat.o(178794);
            return aVar;
        } else if (!Util.isEqual(aVar.field_key, aVar3.field_key)) {
            AppMethodBeat.o(178794);
            return aVar;
        } else {
            a dXV = aVar3.dXV();
            LinkedHashSet<com.tencent.mm.plugin.groupsolitaire.c.b> linkedHashSet = new LinkedHashSet();
            LinkedHashSet linkedHashSet2 = new LinkedHashSet();
            LinkedHashSet<com.tencent.mm.plugin.groupsolitaire.c.b> linkedHashSet3 = new LinkedHashSet();
            LinkedHashSet linkedHashSet4 = new LinkedHashSet();
            HashMap hashMap = new HashMap();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 1; i2 <= aVar3.yfE.size(); i2++) {
                com.tencent.mm.plugin.groupsolitaire.c.b dXW = aVar3.yfE.get(Integer.valueOf(i2)).dXW();
                if (Util.isEqual(dXW.username, z.aTY())) {
                    linkedHashSet2.add(dXW);
                    hashMap.put(dXW.content, dXW);
                    arrayList.add(dXW);
                } else {
                    linkedHashSet.add(dXW);
                }
            }
            if (aVar2 != null) {
                for (int i3 = 1; i3 <= aVar2.yfE.size(); i3++) {
                    linkedHashSet4.add(aVar2.yfE.get(Integer.valueOf(i3)).dXW());
                }
            }
            for (int i4 = 1; i4 <= aVar.yfE.size(); i4++) {
                com.tencent.mm.plugin.groupsolitaire.c.b bVar2 = aVar.yfE.get(Integer.valueOf(i4));
                if (!linkedHashSet.contains(bVar2) && (!linkedHashSet4.contains(bVar2) || linkedHashSet2.contains(bVar2))) {
                    linkedHashSet3.add(bVar2);
                }
            }
            for (com.tencent.mm.plugin.groupsolitaire.c.b bVar3 : linkedHashSet3) {
                if (linkedHashSet2.contains(bVar3)) {
                    arrayList.remove(bVar3);
                }
            }
            for (com.tencent.mm.plugin.groupsolitaire.c.b bVar4 : linkedHashSet3) {
                if (linkedHashSet2.contains(bVar4)) {
                    com.tencent.mm.plugin.groupsolitaire.c.b bVar5 = (com.tencent.mm.plugin.groupsolitaire.c.b) hashMap.get(bVar4.content);
                    if (bVar5 == null) {
                        linkedHashSet.add(bVar4);
                    } else {
                        linkedHashSet.add(bVar5);
                    }
                } else {
                    Iterator it = arrayList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            bVar = null;
                            break;
                        }
                        bVar = (com.tencent.mm.plugin.groupsolitaire.c.b) it.next();
                        if (Util.isEqual(bVar.yfI, bVar4.yfI)) {
                            break;
                        }
                    }
                    if (bVar == null) {
                        linkedHashSet.add(bVar4);
                    } else {
                        arrayList.remove(bVar);
                        bVar.content = bVar4.content;
                        linkedHashSet.add(bVar);
                    }
                }
            }
            dXV.yfE.clear();
            ArrayList arrayList2 = new ArrayList();
            for (com.tencent.mm.plugin.groupsolitaire.c.b bVar6 : linkedHashSet) {
                arrayList2.add(bVar6);
            }
            Collections.sort(arrayList2, new Comparator<com.tencent.mm.plugin.groupsolitaire.c.b>() {
                /* class com.tencent.mm.plugin.groupsolitaire.b.b.AnonymousClass2 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                @Override // java.util.Comparator
                public final /* bridge */ /* synthetic */ int compare(com.tencent.mm.plugin.groupsolitaire.c.b bVar, com.tencent.mm.plugin.groupsolitaire.c.b bVar2) {
                    AppMethodBeat.i(110318);
                    int compare = Long.compare(bVar.createtime, bVar2.createtime);
                    AppMethodBeat.o(110318);
                    return compare;
                }
            });
            Iterator it2 = arrayList2.iterator();
            int i5 = 0;
            while (it2.hasNext()) {
                i5++;
                dXV.yfE.put(Integer.valueOf(i5), (com.tencent.mm.plugin.groupsolitaire.c.b) it2.next());
            }
            dXV.yfG = aVar.yfG;
            AppMethodBeat.o(178794);
            return dXV;
        }
    }

    private static a a(a aVar, a aVar2, String str, boolean z, boolean z2) {
        int i2 = 1;
        AppMethodBeat.i(194428);
        if (aVar == null && aVar2 == null) {
            AppMethodBeat.o(194428);
            return null;
        } else if (aVar == null && aVar2 != null) {
            AppMethodBeat.o(194428);
            return aVar2;
        } else if (aVar != null && aVar2 == null) {
            AppMethodBeat.o(194428);
            return aVar;
        } else if (!Util.isEqual(aVar.field_key, aVar2.field_key)) {
            AppMethodBeat.o(194428);
            return aVar;
        } else {
            a dXV = aVar2.dXV();
            LinkedHashSet<com.tencent.mm.plugin.groupsolitaire.c.b> linkedHashSet = new LinkedHashSet();
            if (z2) {
                while (i2 <= aVar.yfE.size()) {
                    com.tencent.mm.plugin.groupsolitaire.c.b bVar = aVar.yfE.get(Integer.valueOf(i2));
                    if (!linkedHashSet.contains(bVar)) {
                        linkedHashSet.add(bVar);
                    }
                    i2++;
                }
            } else {
                HashSet hashSet = new HashSet();
                HashMap hashMap = new HashMap();
                for (int i3 = 1; i3 <= aVar2.yfE.size(); i3++) {
                    com.tencent.mm.plugin.groupsolitaire.c.b bVar2 = aVar2.yfE.get(Integer.valueOf(i3));
                    if (!Util.isEqual(bVar2.username, str)) {
                        linkedHashSet.add(bVar2);
                    } else {
                        hashSet.add(bVar2);
                        hashMap.put(bVar2.content, bVar2);
                    }
                }
                while (i2 <= aVar.yfE.size()) {
                    com.tencent.mm.plugin.groupsolitaire.c.b bVar3 = aVar.yfE.get(Integer.valueOf(i2));
                    if (!linkedHashSet.contains(bVar3) && Util.isEqual(bVar3.username, str)) {
                        if (z) {
                            linkedHashSet.add(bVar3);
                        } else {
                            com.tencent.mm.plugin.groupsolitaire.c.b bVar4 = (com.tencent.mm.plugin.groupsolitaire.c.b) hashMap.get(bVar3.content);
                            if (bVar4 == null) {
                                linkedHashSet.add(bVar3);
                            } else {
                                linkedHashSet.add(bVar4);
                            }
                        }
                    }
                    i2++;
                }
            }
            dXV.yfE.clear();
            ArrayList arrayList = new ArrayList();
            for (com.tencent.mm.plugin.groupsolitaire.c.b bVar5 : linkedHashSet) {
                arrayList.add(bVar5);
            }
            Collections.sort(arrayList, new Comparator<com.tencent.mm.plugin.groupsolitaire.c.b>() {
                /* class com.tencent.mm.plugin.groupsolitaire.b.b.AnonymousClass3 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                @Override // java.util.Comparator
                public final /* bridge */ /* synthetic */ int compare(com.tencent.mm.plugin.groupsolitaire.c.b bVar, com.tencent.mm.plugin.groupsolitaire.c.b bVar2) {
                    AppMethodBeat.i(110319);
                    int compare = Long.compare(bVar.createtime, bVar2.createtime);
                    AppMethodBeat.o(110319);
                    return compare;
                }
            });
            Iterator it = arrayList.iterator();
            int i4 = 0;
            while (it.hasNext()) {
                i4++;
                dXV.yfE.put(Integer.valueOf(i4), (com.tencent.mm.plugin.groupsolitaire.c.b) it.next());
            }
            dXV.yfG = aVar.yfG;
            AppMethodBeat.o(194428);
            return dXV;
        }
    }

    public static Pair<Boolean, a> hW(String str, String str2) {
        AppMethodBeat.i(110350);
        if (Util.isNullOrNil(str2)) {
            Pair<Boolean, a> pair = new Pair<>(Boolean.FALSE, null);
            AppMethodBeat.o(110350);
            return pair;
        }
        a ib = ((PluginGroupSolitaire) g.ah(PluginGroupSolitaire.class)).getGroupSolitatireManager().ib(str, str2);
        if (ib == null) {
            Pair<Boolean, a> pair2 = new Pair<>(Boolean.FALSE, null);
            AppMethodBeat.o(110350);
            return pair2;
        }
        Pair<Boolean, a> pair3 = new Pair<>(Boolean.TRUE, ib);
        AppMethodBeat.o(110350);
        return pair3;
    }

    public static boolean d(a aVar) {
        boolean z;
        AppMethodBeat.i(110351);
        if (aVar == null) {
            AppMethodBeat.o(110351);
            return false;
        }
        int a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_solitaire_keyword_detect_switch, 0);
        Log.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "getKeywordCheckSwt() swt:%s", Integer.valueOf(a2));
        if (a2 == 1) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            StringBuilder sb = new StringBuilder();
            if (aVar.yfC == 1) {
                sb.append(aVar.header);
            }
            sb.append(aVar.yfB).append(aVar.xxN);
            String a3 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_solitaire_keyword_regex, "(接龙|报名|参加|参与|活动|组织|投票|回复|统计)");
            Log.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "exampleRegex:%s", a3);
            boolean find = Pattern.compile(a3).matcher(sb.toString()).find();
            AppMethodBeat.o(110351);
            return find;
        }
        AppMethodBeat.o(110351);
        return true;
    }

    public static String e(a aVar) {
        AppMethodBeat.i(110352);
        if (aVar == null) {
            AppMethodBeat.o(110352);
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<solitaire>");
        sb.append("<tt>").append(Util.escapeStringForXml(aVar.header)).append("</tt>");
        sb.append("<ex>").append(Util.escapeStringForXml(aVar.yfB)).append("</ex>");
        sb.append("<tl>").append(Util.escapeStringForXml(aVar.xxN)).append("</tl>");
        sb.append("<s>").append(Util.escapeStringForXml(aVar.separator)).append("</s>");
        sb.append("<au>").append(aVar.field_creator).append("</au>");
        sb.append("<hrt>").append(new StringBuilder().append(aVar.yfC).toString()).append("</hrt>");
        sb.append("<content>");
        sb.append("<s>").append(aVar.yfE.size()).append("</s>");
        for (int i2 = 1; i2 <= aVar.yfE.size(); i2++) {
            com.tencent.mm.plugin.groupsolitaire.c.b bVar = aVar.yfE.get(Integer.valueOf(i2));
            if (bVar != null) {
                sb.append("<i>");
                sb.append("<u>").append(bVar.username).append("</u>");
                sb.append("<h>").append(bVar.yfH).append("</h>");
                sb.append("<s>").append(Util.escapeStringForXml(bVar.separator)).append("</s>");
                sb.append("<t>").append(bVar.createtime).append("</t>");
                sb.append("<c>").append(Util.escapeStringForXml(bVar.content)).append("</c>");
                sb.append("<o>").append(bVar.yfI).append("</o>");
                sb.append("</i>");
            }
        }
        sb.append("</content>");
        sb.append("</solitaire>");
        String sb2 = sb.toString();
        AppMethodBeat.o(110352);
        return sb2;
    }

    public static String b(String str, a aVar) {
        AppMethodBeat.i(110353);
        String a2 = a(str, aVar, false);
        AppMethodBeat.o(110353);
        return a2;
    }

    public static String a(String str, a aVar, boolean z) {
        AppMethodBeat.i(174560);
        if (aVar == null) {
            AppMethodBeat.o(174560);
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<solitaire_info>");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("<solitaire>");
        sb2.append("<tt>").append(hY(str, aVar.header)).append("</tt>");
        sb2.append("<ex>").append(hY(str, aVar.yfB)).append("</ex>");
        sb2.append("<tl>").append(hY(str, aVar.xxN)).append("</tl>");
        sb2.append("<s>").append(Util.escapeStringForXml(aVar.separator)).append("</s>");
        sb2.append("<au>").append(aVar.field_creator).append("</au>");
        sb2.append("<hrt>").append(new StringBuilder().append(aVar.yfC).toString()).append("</hrt>");
        sb2.append("<loss>").append(z ? 1 : 0).append("</loss>");
        sb2.append("<content>");
        sb2.append("<s>").append(aVar.yfE.size()).append("</s>");
        for (int i2 = 1; i2 <= aVar.yfE.size(); i2++) {
            com.tencent.mm.plugin.groupsolitaire.c.b bVar = aVar.yfE.get(Integer.valueOf(i2));
            if (bVar != null) {
                sb2.append("<i>");
                sb2.append("<u>").append(bVar.username).append("</u>");
                sb2.append("<h>").append(bVar.yfH).append("</h>");
                sb2.append("<s>").append(Util.escapeStringForXml(bVar.separator)).append("</s>");
                sb2.append("<t>").append(bVar.createtime).append("</t>");
                Pair<Integer, Integer> hX = hX(str, bVar.content);
                if (hX == null) {
                    sb2.append("<c>").append(Util.escapeStringForXml(bVar.content)).append("</c>");
                } else {
                    sb2.append("<r>").append(c(hX)).append("</r>");
                }
                sb2.append("</i>");
            }
        }
        sb2.append("</content>");
        sb2.append("</solitaire>");
        sb.append("<![CDATA[").append(sb2.toString()).append("]]>");
        sb.append("</solitaire_info>");
        String sb3 = sb.toString();
        AppMethodBeat.o(174560);
        return sb3;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: java.util.HashMap<java.lang.Integer, com.tencent.mm.plugin.groupsolitaire.c.b> */
    /* JADX WARN: Multi-variable type inference failed */
    public static void f(a aVar) {
        AppMethodBeat.i(110354);
        String str = aVar.field_content;
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.groupsolitaire.GroupSolitatireHelp", "xml is null");
            AppMethodBeat.o(110354);
        } else if (!str.trim().contains("<solitaire>")) {
            Log.e("MicroMsg.groupsolitaire.GroupSolitatireHelp", "<solitaire> no contains");
            AppMethodBeat.o(110354);
        } else {
            Map<String, String> parseXml = XmlParser.parseXml(str, "solitaire", null);
            if (parseXml == null) {
                Log.e("MicroMsg.groupsolitaire.GroupSolitatireHelp", "newValues is null: %s", str);
                AppMethodBeat.o(110354);
                return;
            }
            aVar.header = parseXml.get(".solitaire.tt");
            aVar.yfB = parseXml.get(".solitaire.ex");
            aVar.xxN = parseXml.get(".solitaire.tl");
            aVar.separator = parseXml.get(".solitaire.s");
            aVar.field_creator = parseXml.get(".solitaire.au");
            aVar.yfC = Util.getInt(parseXml.get(".solitaire.hrt"), 1);
            if (parseXml.containsKey(".solitaire.content" + ".s")) {
                int i2 = Util.getInt(parseXml.get(".solitaire.content" + ".s"), 0);
                ArrayList arrayList = new ArrayList();
                for (int i3 = 0; i3 < i2; i3++) {
                    com.tencent.mm.plugin.groupsolitaire.c.b bVar = new com.tencent.mm.plugin.groupsolitaire.c.b();
                    if (i3 == 0) {
                        bVar.username = parseXml.get(".solitaire.content.i" + ".u");
                        bVar.yfH = Util.getInt(parseXml.get(".solitaire.content.i" + ".h"), 0);
                        bVar.separator = parseXml.get(".solitaire.content.i" + ".s");
                        bVar.createtime = Util.getLong(parseXml.get(".solitaire.content.i" + ".t"), 0);
                        bVar.content = parseXml.get(".solitaire.content.i" + ".c");
                        bVar.yfI = Util.getInt(parseXml.get(".solitaire.content.i" + ".o"), 0);
                    } else {
                        bVar.username = parseXml.get(".solitaire.content.i" + i3 + ".u");
                        bVar.yfH = Util.getInt(parseXml.get(".solitaire.content.i" + i3 + ".h"), 0);
                        bVar.separator = parseXml.get(".solitaire.content.i" + i3 + ".s");
                        bVar.createtime = Util.getLong(parseXml.get(".solitaire.content.i" + i3 + ".t"), 0);
                        bVar.content = parseXml.get(".solitaire.content.i" + i3 + ".c");
                        bVar.yfI = Util.getInt(parseXml.get(".solitaire.content.i" + i3 + ".o"), 0);
                    }
                    arrayList.add(bVar);
                }
                Collections.sort(arrayList, new Comparator<com.tencent.mm.plugin.groupsolitaire.c.b>() {
                    /* class com.tencent.mm.plugin.groupsolitaire.b.b.AnonymousClass4 */

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                    @Override // java.util.Comparator
                    public final /* bridge */ /* synthetic */ int compare(com.tencent.mm.plugin.groupsolitaire.c.b bVar, com.tencent.mm.plugin.groupsolitaire.c.b bVar2) {
                        AppMethodBeat.i(110320);
                        int compare = Long.compare(bVar.createtime, bVar2.createtime);
                        AppMethodBeat.o(110320);
                        return compare;
                    }
                });
                for (int i4 = 0; i4 < i2; i4++) {
                    aVar.yfE.put(Integer.valueOf(aVar.yfE.size() + 1), arrayList.get(i4));
                }
            }
            AppMethodBeat.o(110354);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v17, resolved type: java.util.HashMap<java.lang.Integer, com.tencent.mm.plugin.groupsolitaire.c.b> */
    /* JADX WARN: Multi-variable type inference failed */
    public static a au(String str, String str2, String str3) {
        String str4;
        String str5;
        AppMethodBeat.i(110355);
        if (Util.isNullOrNil(str3)) {
            Log.e("MicroMsg.groupsolitaire.GroupSolitatireHelp", "xml is null");
            AppMethodBeat.o(110355);
            return null;
        }
        int hashCode = (str3 + Util.nullAs(str2, "")).hashCode();
        a aVar = gAU.get(Integer.valueOf(hashCode));
        if (aVar != null) {
            Log.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "get GroupSolitatire data from cache");
            AppMethodBeat.o(110355);
            return aVar;
        } else if (!str3.trim().contains("<solitaire>")) {
            AppMethodBeat.o(110355);
            return null;
        } else {
            Map<String, String> parseXml = XmlParser.parseXml(str3, "solitaire", null);
            if (parseXml == null) {
                Log.e("MicroMsg.groupsolitaire.GroupSolitatireHelp", "newValues is null: %s", str3);
                AppMethodBeat.o(110355);
                return null;
            }
            a aVar2 = new a();
            aVar2.header = hZ(str2, parseXml.get(".solitaire.tt"));
            aVar2.yfB = hZ(str2, parseXml.get(".solitaire.ex"));
            aVar2.xxN = hZ(str2, parseXml.get(".solitaire.tl"));
            aVar2.separator = parseXml.get(".solitaire.s");
            aVar2.field_creator = parseXml.get(".solitaire.au");
            aVar2.field_username = str;
            aVar2.yfC = Util.getInt(parseXml.get(".solitaire.hrt"), 1);
            aVar2.yfD = Util.getInt(parseXml.get(".solitaire.loss"), 0) == 1;
            if (parseXml.containsKey(".solitaire.content" + ".s")) {
                int i2 = Util.getInt(parseXml.get(".solitaire.content" + ".s"), 0);
                ArrayList arrayList = new ArrayList();
                for (int i3 = 0; i3 < i2; i3++) {
                    com.tencent.mm.plugin.groupsolitaire.c.b bVar = new com.tencent.mm.plugin.groupsolitaire.c.b();
                    if (i3 == 0) {
                        bVar.username = parseXml.get(".solitaire.content.i" + ".u");
                        bVar.yfH = Util.getInt(parseXml.get(".solitaire.content.i" + ".h"), 0);
                        bVar.separator = parseXml.get(".solitaire.content.i" + ".s");
                        bVar.createtime = Util.getLong(parseXml.get(".solitaire.content.i" + ".t"), 0);
                        str4 = parseXml.get(".solitaire.content.i" + ".c");
                        str5 = parseXml.get(".solitaire.content.i" + ".r");
                    } else {
                        bVar.username = parseXml.get(".solitaire.content.i" + i3 + ".u");
                        bVar.yfH = Util.getInt(parseXml.get(".solitaire.content.i" + i3 + ".h"), 0);
                        bVar.separator = parseXml.get(".solitaire.content.i" + i3 + ".s");
                        bVar.createtime = Util.getLong(parseXml.get(".solitaire.content.i" + i3 + ".t"), 0);
                        str4 = parseXml.get(".solitaire.content.i" + i3 + ".c");
                        str5 = parseXml.get(".solitaire.content.i" + i3 + ".r");
                    }
                    if (!Util.isNullOrNil(str4)) {
                        bVar.content = str4;
                    } else if (!Util.isNullOrNil(str5)) {
                        bVar.content = hZ(str2, str5);
                    }
                    arrayList.add(bVar);
                }
                Collections.sort(arrayList, new Comparator<com.tencent.mm.plugin.groupsolitaire.c.b>() {
                    /* class com.tencent.mm.plugin.groupsolitaire.b.b.AnonymousClass5 */

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                    @Override // java.util.Comparator
                    public final /* bridge */ /* synthetic */ int compare(com.tencent.mm.plugin.groupsolitaire.c.b bVar, com.tencent.mm.plugin.groupsolitaire.c.b bVar2) {
                        AppMethodBeat.i(110321);
                        int compare = Long.compare(bVar.createtime, bVar2.createtime);
                        AppMethodBeat.o(110321);
                        return compare;
                    }
                });
                for (int i4 = 0; i4 < i2; i4++) {
                    aVar2.yfE.put(Integer.valueOf(aVar2.yfE.size() + 1), arrayList.get(i4));
                }
            }
            aVar2.field_key = a(aVar2);
            gAU.put(Integer.valueOf(hashCode), aVar2);
            AppMethodBeat.o(110355);
            return aVar2;
        }
    }

    public static String g(a aVar) {
        AppMethodBeat.i(110356);
        if (aVar == null) {
            AppMethodBeat.o(110356);
            return "";
        }
        StringBuilder sb = new StringBuilder();
        if (aVar.header != null && !Util.isNullOrNil(aVar.header.trim()) && aVar.yfC == 1) {
            aVar.header = aVar.header.trim();
            sb.append(aVar.header).append("\n");
        }
        if (aVar.yfB != null && !Util.isNullOrNil(aVar.yfB.trim())) {
            aVar.yfB = aVar.yfB.trim();
            sb.append(aVar.yfB).append("\n");
        }
        if (!Util.isNullOrNil(sb.toString())) {
            sb.append("\n");
        }
        if (aVar.yfE.size() > 0) {
            for (int i2 = 1; i2 <= aVar.yfE.size(); i2++) {
                sb.append(i2).append(aVar.separator).append(" ").append(aVar.yfE.get(Integer.valueOf(i2)).content);
                if (i2 < aVar.yfE.size()) {
                    sb.append("\n");
                }
            }
        }
        if (aVar.xxN != null && !Util.isNullOrNil(aVar.xxN.trim())) {
            aVar.xxN = aVar.xxN.trim();
            sb.append("\n");
            sb.append("\n");
            sb.append(aVar.xxN);
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(110356);
        return sb2;
    }

    public static void a(long j2, String str, a aVar) {
        String str2;
        String str3;
        AppMethodBeat.i(194429);
        if (aVar == null) {
            Log.e("MicroMsg.groupsolitaire.GroupSolitatireHelp", "setLocalSolitaireFoldInfoFromMsg: groupSolitatire is null");
            AppMethodBeat.o(194429);
        } else if (j2 != 0) {
            ca Hb = ((l) g.af(l.class)).eiy().Hb(j2);
            a r = ((PluginGroupSolitaire) g.ah(PluginGroupSolitaire.class)).getGroupSolitatireStorage().r(aVar.field_username, aVar.field_key, false);
            cjv cjv = new cjv();
            if (Hb.isText()) {
                str2 = Hb.field_content;
            } else if (Hb.gDx()) {
                k.b HD = k.b.HD(Hb.field_content);
                if (HD == null) {
                    Log.e("MicroMsg.groupsolitaire.GroupSolitatireHelp", "setLocalSolitaireFoldInfoFromMsg: amc is null");
                    AppMethodBeat.o(194429);
                    return;
                }
                str2 = HD.title;
            } else {
                str2 = "";
            }
            if (Util.isNullOrNil(str2)) {
                Log.e("MicroMsg.groupsolitaire.GroupSolitatireHelp", "setLocalSolitaireFoldInfoFromMsg: content is null");
                AppMethodBeat.o(194429);
                return;
            }
            if (r != null) {
                String str4 = r.separator;
                if (aVar == null || r == null) {
                    str3 = str4;
                } else {
                    LinkedHashSet linkedHashSet = new LinkedHashSet();
                    for (int i2 = 1; i2 <= r.yfE.size(); i2++) {
                        com.tencent.mm.plugin.groupsolitaire.c.b bVar = r.yfE.get(Integer.valueOf(i2));
                        if (bVar != null && Util.isEqual(bVar.username, str)) {
                            linkedHashSet.add(bVar);
                        }
                    }
                    for (int i3 = 1; i3 <= aVar.yfE.size(); i3++) {
                        com.tencent.mm.plugin.groupsolitaire.c.b bVar2 = aVar.yfE.get(Integer.valueOf(i3));
                        if (bVar2 != null) {
                            if (linkedHashSet.contains(bVar2)) {
                                bVar2.username = str;
                            } else {
                                bVar2.username = "";
                            }
                        }
                    }
                    str3 = str4;
                }
            } else {
                str3 = aVar.separator;
            }
            int i4 = 1;
            if (aVar.yfC == 0) {
                i4 = 2;
            }
            while (i4 <= aVar.yfE.size()) {
                com.tencent.mm.plugin.groupsolitaire.c.b bVar3 = aVar.yfE.get(Integer.valueOf(i4));
                if (!Util.isNullOrNil(bVar3.content) && !Util.isNullOrNil(bVar3.content.trim())) {
                    bVar3.content = bVar3.content.trim();
                    if (Util.isEqual(bVar3.username, str)) {
                        cjv.Mpm.add(a(str2, str3, bVar3, i4));
                    }
                }
                i4++;
            }
            if (cjv.Mpm.size() <= 0) {
                cjv.Mpm.add(a(str2, str3, aVar.yfE.get(Integer.valueOf(aVar.yfE.size())), aVar.yfE.size()));
            }
            if ((aVar.yfC == 0 ? (aVar.yfE.size() - cjv.Mpm.size()) - 1 : aVar.yfE.size() - cjv.Mpm.size()) < 2) {
                Log.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "setLocalSolitaireFoldInfoFromMsg fold condition min num is not");
                AppMethodBeat.o(194429);
                return;
            }
            cjv.yfC = aVar.yfC;
            cjv.Mpo = aVar.yfE.size() - cjv.Mpm.size();
            cjv.dTS = aVar.field_msgSvrId;
            cjv.key = aVar.field_key;
            if (aVar.yfC == 0) {
                cjv.Mpl.add(a(str2, str3, aVar.yfE.get(1), 1));
            } else {
                if (aVar.header != null && !Util.isNullOrNil(aVar.header.trim())) {
                    cjw cjw = new cjw();
                    a(cjw, str2, aVar.header.trim());
                    cjv.Mpl.add(cjw);
                }
                if (aVar.yfB != null && !Util.isNullOrNil(aVar.yfB.trim())) {
                    Pair<Integer, Integer> hX = hX(str2, aVar.yfB.trim());
                    cjw cjw2 = new cjw();
                    if (hX == null) {
                        cjw2.start = 0;
                        cjw2.end = 0;
                    } else {
                        if (cjv.Mpl.size() > 0) {
                            cjw2.Mpp = "\n";
                        }
                        cjw2.start = ((Integer) hX.first).intValue();
                        cjw2.end = ((Integer) hX.second).intValue() + ((Integer) hX.first).intValue();
                    }
                    cjv.Mpl.add(cjw2);
                }
            }
            if (aVar.xxN != null && !Util.isNullOrNil(aVar.xxN.trim())) {
                cjw cjw3 = new cjw();
                a(cjw3, str2, aVar.xxN.trim());
                cjv.Mpn = cjw3;
            }
            Hb.field_solitaireFoldInfo = cjv;
            Hb.fQN = true;
            try {
                ((l) g.af(l.class)).eiy().a(Hb.field_msgId, Hb);
            } catch (Exception e2) {
                Log.e("MicroMsg.groupsolitaire.GroupSolitatireHelp", "%s %s", e2.getClass().getSimpleName(), e2.getMessage());
            }
            Log.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "setLocalSolitaireFoldInfoFromMsg msgId:%s", Long.valueOf(Hb.field_msgId));
            AppMethodBeat.o(194429);
        } else {
            Log.e("MicroMsg.groupsolitaire.GroupSolitatireHelp", "setLocalSolitaireFoldInfoFromMsg msgId == 0");
            AppMethodBeat.o(194429);
        }
    }

    private static cjw a(String str, String str2, com.tencent.mm.plugin.groupsolitaire.c.b bVar, int i2) {
        AppMethodBeat.i(194430);
        cjw cjw = new cjw();
        cjw.Mpp = i2 + str2 + " ";
        a(cjw, str, bVar.content);
        AppMethodBeat.o(194430);
        return cjw;
    }

    private static void a(cjw cjw, String str, String str2) {
        AppMethodBeat.i(194431);
        Pair<Integer, Integer> hX = hX(str, str2);
        if (hX == null) {
            cjw.start = 0;
            cjw.end = 0;
            AppMethodBeat.o(194431);
            return;
        }
        cjw.start = ((Integer) hX.first).intValue();
        cjw.end = ((Integer) hX.second).intValue() + ((Integer) hX.first).intValue();
        AppMethodBeat.o(194431);
    }

    static {
        AppMethodBeat.i(110365);
        AppMethodBeat.o(110365);
    }

    private static Pair<Integer, Integer> hX(String str, String str2) {
        AppMethodBeat.i(110357);
        if (dXR()) {
            AppMethodBeat.o(110357);
            return null;
        } else if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(110357);
            return null;
        } else {
            int indexOf = str.indexOf(str2);
            if (indexOf >= 0) {
                Pair<Integer, Integer> pair = new Pair<>(Integer.valueOf(indexOf), Integer.valueOf(str2.length()));
                AppMethodBeat.o(110357);
                return pair;
            }
            AppMethodBeat.o(110357);
            return null;
        }
    }

    private static String c(Pair<Integer, Integer> pair) {
        AppMethodBeat.i(174562);
        if (pair == null) {
            AppMethodBeat.o(174562);
            return "";
        }
        String str = pair.first + "-" + pair.second;
        AppMethodBeat.o(174562);
        return str;
    }

    private static String hY(String str, String str2) {
        AppMethodBeat.i(110358);
        Pair<Integer, Integer> hX = hX(str, str2);
        if (hX == null) {
            AppMethodBeat.o(110358);
            return str2;
        }
        String str3 = hX.first + "-" + hX.second;
        AppMethodBeat.o(110358);
        return str3;
    }

    private static String hZ(String str, String str2) {
        AppMethodBeat.i(110359);
        if (Util.isNullOrNil(str) || Util.isNullOrNil(str2)) {
            AppMethodBeat.o(110359);
            return "";
        }
        String[] split = str2.split("-");
        if (split != null && split.length == 2) {
            int i2 = Util.getInt(split[0], 0);
            int i3 = Util.getInt(split[1], 0) + i2;
            if (i2 >= 0 && i3 <= str.length()) {
                String substring = str.substring(i2, i3);
                AppMethodBeat.o(110359);
                return substring;
            }
        }
        AppMethodBeat.o(110359);
        return str2;
    }

    public static boolean aBi(String str) {
        AppMethodBeat.i(110360);
        if (aBl(str) > dXO() * 2) {
            AppMethodBeat.o(110360);
            return true;
        }
        AppMethodBeat.o(110360);
        return false;
    }

    public static boolean aBj(String str) {
        AppMethodBeat.i(110361);
        if (aBl(str) > dXP() * 2) {
            AppMethodBeat.o(110361);
            return true;
        }
        AppMethodBeat.o(110361);
        return false;
    }

    public static boolean h(a aVar) {
        AppMethodBeat.i(110362);
        if (aVar == null) {
            AppMethodBeat.o(110362);
            return false;
        } else if (aVar.yfC != 1 || !aBj(aVar.header)) {
            AppMethodBeat.o(110362);
            return false;
        } else {
            AppMethodBeat.o(110362);
            return true;
        }
    }

    public static boolean aBk(String str) {
        AppMethodBeat.i(178795);
        if (aBl(str) > dXQ() * 2) {
            AppMethodBeat.o(178795);
            return true;
        }
        AppMethodBeat.o(178795);
        return false;
    }

    public static int aBl(String str) {
        int length;
        AppMethodBeat.i(110363);
        if (str == null) {
            AppMethodBeat.o(110363);
            return 0;
        }
        try {
            length = str.getBytes("GBK").length;
        } catch (Exception e2) {
            Log.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "getStringByteLen Exception：%s，%s", e2.getClass().getSimpleName(), e2.getMessage());
            length = str.getBytes().length;
        }
        Log.d("MicroMsg.groupsolitaire.GroupSolitatireHelp", "length:%s", Integer.valueOf(length));
        AppMethodBeat.o(110363);
        return length;
    }

    public static int em(String str, int i2) {
        AppMethodBeat.i(110364);
        int length = str.length();
        int i3 = 0;
        while (i3 <= length) {
            int i4 = (i3 + length) / 2;
            int aBl = aBl(str.substring(0, i4));
            if (aBl == i2) {
                AppMethodBeat.o(110364);
                return i4;
            }
            if (aBl > i2) {
                length = i4 - 1;
            }
            if (aBl < i2) {
                i3 = i4 + 1;
            }
        }
        AppMethodBeat.o(110364);
        return length;
    }

    public static a a(a aVar, a aVar2, String str) {
        AppMethodBeat.i(110348);
        a a2 = a(aVar, aVar2, str, true, false);
        AppMethodBeat.o(110348);
        return a2;
    }
}
