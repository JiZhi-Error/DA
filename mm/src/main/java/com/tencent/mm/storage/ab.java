package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.h;
import com.tencent.mm.al.ag;
import com.tencent.mm.contact.c;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.p;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.webcanvas.l;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.anx;
import com.tencent.mm.protocal.protobuf.efz;
import com.tencent.mm.protocal.protobuf.ega;
import com.tencent.mm.protocal.protobuf.egb;
import com.tencent.mm.protocal.protobuf.egd;
import com.tencent.mm.protocal.protobuf.ege;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.y;
import com.tencent.rtmp.TXLiveConstants;
import java.util.Calendar;
import java.util.Map;
import kotlin.g.b.p;

public final class ab {
    private static String NQL = null;
    private static long NQM = 0;
    public static int NQN = 0;
    public static int NQO = 1;
    public static long NQP = 180;
    public static long NQQ = 60;
    public static boolean NQR = false;
    private static boolean NQS = false;
    public static long NQT = 0;
    public static long NQU = 0;
    public static int NQV = 0;
    private static Boolean NQW = null;
    private static Boolean NQX = null;
    private static Boolean NQY = null;
    private static int dEb = 0;

    /* JADX WARNING: Removed duplicated region for block: B:45:0x0152  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x01ad  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void aV(com.tencent.mm.storage.ca r18) {
        /*
        // Method dump skipped, instructions count: 809
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.ab.aV(com.tencent.mm.storage.ca):void");
    }

    public static void AK(boolean z) {
        NQR = z;
    }

    public static long Na(long j2) {
        return (4278190080L & j2) >> 24;
    }

    public static void c(final Map<String, String> map, h.a aVar) {
        int i2;
        AppMethodBeat.i(124666);
        if (aVar == null || aVar.heO == null || aVar.heO.KHn == null) {
            Log.w("MicroMsg.BizTimeLineInfoStorageLogic", "onBizRecommendNotify data invalid");
            AppMethodBeat.o(124666);
        } else if (!g.aAc()) {
            Log.i("MicroMsg.BizTimeLineInfoStorageLogic", "onBizRecommendNotify acc not ready");
            AppMethodBeat.o(124666);
        } else {
            int i3 = Util.getInt(map.get(".sysmsg.BizAccountRecommend.Style"), -1);
            b bVar = (b) g.af(b.class);
            if (bVar == null) {
                Log.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] onBizRecommendNotify IBrandService null");
                AppMethodBeat.o(124666);
            } else if (!bVar.CT(i3)) {
                Log.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] onBizRecommendNotify style = %s not support", Integer.valueOf(i3));
                AppMethodBeat.o(124666);
            } else {
                int i4 = Util.getInt(map.get(".sysmsg.BizAccountRecommend.RedDotFlag"), -1);
                Log.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] onBizRecommendNotify redDot = %s", Integer.valueOf(i4));
                final String a2 = z.a(aVar.heO.KHn);
                MultiProcessMMKV singleMMKV = MultiProcessMMKV.getSingleMMKV("brandService");
                if (i4 == 0) {
                    StringBuilder sb = new StringBuilder("BizLatestRecommendCardInfo");
                    g.aAf();
                    singleMMKV.encode(sb.append(a.ayV()).toString(), a2);
                } else if (i4 == 1) {
                    com.tencent.f.h.RTc.b(new Runnable() {
                        /* class com.tencent.mm.storage.ab.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(124656);
                            ab.X(a2, map);
                            ad adVar = ad.NRn;
                            if (ad.gBk()) {
                                ad adVar2 = ad.NRn;
                                ad.aka(ab.NQN);
                            }
                            y yVar = y.NPP;
                            y.a(y.b.RECYCLE_CARD_SCENE_NEW_MSG);
                            AppMethodBeat.o(124656);
                        }
                    }, "BizInsertTlRecCardThreadImmediately");
                } else if (i4 == 2) {
                    ac acVar = ac.NRc;
                    ac.bjb(a2);
                    ac acVar2 = ac.NRc;
                    ac.Nd(3);
                }
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(1149, 0, 1, false);
                long j2 = Util.getLong(map.get(".sysmsg.BizAccountRecommend.RecID"), 0);
                String str = map.get(".sysmsg.BizAccountRecommend.BizAccount.UserName");
                int i5 = Util.getInt(map.get(".sysmsg.BizAccountRecommend.Pos"), -1);
                int i6 = Util.getInt(map.get(".sysmsg.BizAccountRecommend.Weight"), -1);
                int i7 = Util.getInt(map.get(".sysmsg.BizAccountRecommend.UseServerTime"), 0);
                String str2 = map.get(".sysmsg.BizAccountRecommend.CardId");
                String str3 = map.get(".sysmsg.BizAccountRecommend.ExpType");
                for (int i8 = 0; i8 < 2; i8++) {
                    StringBuilder append = new StringBuilder().append(".sysmsg.BizAccountRecommend.BizAccount");
                    if (i8 == 0) {
                        i2 = "";
                    } else {
                        i2 = 1;
                    }
                    String sb2 = append.append(i2).toString();
                    String str4 = map.get(sb2 + ".AppMsg.Title");
                    if (Util.isNullOrNil(str4)) {
                        break;
                    }
                    String str5 = map.get(sb2 + ".UserName");
                    String bfG = com.tencent.mm.pluginsdk.ui.tools.z.bfG(str4);
                    String bfG2 = com.tencent.mm.pluginsdk.ui.tools.z.bfG(map.get(sb2 + ".AppMsg.ContentUrl"));
                    Log.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] onBizRecommendNotify bizUserName %s", str5);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(18106, str5, Long.valueOf(j2), Integer.valueOf(i5), Integer.valueOf(i6), bfG, bfG2);
                }
                Log.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] onBizRecommendNotify userName %s, recId %d", str, Long.valueOf(j2));
                if (i3 == 101) {
                    l lVar = l.IAx;
                    l.LV(83);
                    s sVar = s.NPC;
                    s.a(i5, i6, i7, 3, i3, j2, str2, str3, "");
                }
                AppMethodBeat.o(124666);
            }
        }
    }

    public static void gAX() {
        AppMethodBeat.i(124667);
        com.tencent.f.h.RTc.b(new Runnable() {
            /* class com.tencent.mm.storage.ab.AnonymousClass2 */

            public final void run() {
                long j2;
                AppMethodBeat.i(212359);
                ab.gAY();
                r rVar = r.NPl;
                if (r.gzL()) {
                    if (r.gzL()) {
                        if (!ab.gBb()) {
                            if (r.gzN()) {
                                aa ban = ag.ban();
                                String format = String.format("DELETE FROM %s WHERE type = %d and isRead = 1 and createTime < %d", "BizTimeLineInfo", 637534257, Long.valueOf(bp.aVP() - Util.MILLSECONDS_OF_DAY));
                                Log.d("MicroMsg.BizTimeLineInfoStorage", "deleteExposedAdMsgByType ret:%b, sql=%s", Boolean.valueOf(ban.iFy.execSQL("BizTimeLineInfo", format)), format);
                                aa.a aVar = new aa.a();
                                aVar.NQE = aa.b.DELETE;
                                ban.a(aVar);
                            } else {
                                ag.ban().ajX(1);
                            }
                        }
                        l lVar = l.IAx;
                        l.LV(29);
                        String decodeString = r.gzI().decodeString(r.biG("biz_ad_card_data"));
                        if (!r.cg(r.biI(decodeString))) {
                            Log.w("MicroMsg.BizCardLogic", "insertAd ad data invalid");
                            if (!Util.isNullOrNil(decodeString)) {
                                r.gzI().encode(r.biG("biz_ad_card_data"), "");
                                l lVar2 = l.IAx;
                                l.LV(102);
                            }
                            l lVar3 = l.IAx;
                            l.LV(30);
                            z gzX = r.gzX();
                            if (gzX != null) {
                                if (!r.cg(gzX.gAE())) {
                                    ag.ban().MX(gzX.field_msgId);
                                    Log.i("MicroMsg.BizCardLogic", "insertAd delete invalid ad aid=" + gzX.gAG());
                                } else {
                                    r rVar2 = r.NPl;
                                    long MJ = r.MJ(gzX.field_orderFlag);
                                    if (gzX.field_orderFlag != MJ && MJ > 0) {
                                        gzX.field_orderFlag = MJ;
                                        l lVar4 = l.IAx;
                                        l.LV(36);
                                        r.NPl.z(gzX);
                                        Log.i("MicroMsg.BizCardLogic", "insertAd updateById result: " + ag.ban().c(gzX, true) + ", msgId:" + gzX.field_msgId + " orderFlag:" + gzX.field_orderFlag + " aid: " + gzX.gAG());
                                    }
                                }
                            }
                        } else {
                            aa ban2 = ag.ban();
                            p.g(ban2, "SubCoreBiz.getBizTimeLineInfoStorage()");
                            z gAM = ban2.gAM();
                            if (gAM == null) {
                                Log.i("MicroMsg.BizCardLogic", "insertAd lastTimeLineInfo is null");
                            } else {
                                l lVar5 = l.IAx;
                                l.LV(31);
                                com.tencent.mm.plugin.report.service.h.INSTANCE.a(20636, "", "", 4);
                                aa ban3 = ag.ban();
                                p.g(ban3, "SubCoreBiz.getBizTimeLineInfoStorage()");
                                long gAS = ban3.gAS();
                                z zVar = new z();
                                zVar.field_content = decodeString;
                                zVar.field_type = 637534257;
                                if (!((Boolean) r.NPb.getValue()).booleanValue() || r.gzJ() == 1 || ag.ban().MZ(gAS << 32) == null) {
                                    boolean z = false;
                                    if (!ab.gBb() && r.gzX() != null) {
                                        l lVar6 = l.IAx;
                                        l.LV(37);
                                        ag.ban().ajX(0);
                                        z = true;
                                    }
                                    if (r.gzJ() <= 0) {
                                        q bao = ag.bao();
                                        Calendar instance = Calendar.getInstance();
                                        p.g(instance, "Calendar.getInstance()");
                                        instance.setTimeInMillis(System.currentTimeMillis());
                                        instance.set(11, 0);
                                        instance.set(13, 0);
                                        instance.set(12, 0);
                                        instance.set(14, 0);
                                        long timeInMillis = instance.getTimeInMillis();
                                        Cursor rawQuery = bao.iFy.rawQuery("SELECT count(*) FROM BizAdInfo where exposeTime > ".concat(String.valueOf(timeInMillis)), null);
                                        int i2 = 0;
                                        if (rawQuery.moveToFirst()) {
                                            i2 = rawQuery.getInt(0);
                                        }
                                        rawQuery.close();
                                        Log.d("MicroMsg.BizAdInfoStorage", "getAdCardCount count=" + i2 + ", beginTime=" + timeInMillis);
                                        int i3 = r.NOT;
                                        if (1 > i3 || 10 < i3) {
                                            r.NOT = r.gzI().decodeInt("biz_card_max_ad_count", 1);
                                            int i4 = r.NOT;
                                            if (1 > i4 || 10 < i4) {
                                                r.NOT = 1;
                                            }
                                        }
                                        if (i2 >= r.NOT) {
                                            Log.i("MicroMsg.BizCardLogic", "insertAd too much ad count=".concat(String.valueOf(i2)));
                                            l lVar7 = l.IAx;
                                            l.LV(32);
                                            com.tencent.mm.plugin.report.service.h.INSTANCE.a(20636, zVar.gAG(), zVar.getTraceId(), 3);
                                        }
                                    } else {
                                        Log.i("MicroMsg.BizCardLogic", "insertAd delete all ad msg");
                                        aa ban4 = ag.ban();
                                        Log.i("MicroMsg.BizTimeLineInfoStorage", "deleteByType type:%d ret:%b", 637534257, Boolean.valueOf(ban4.iFy.execSQL("BizTimeLineInfo", String.format("DELETE FROM %s WHERE %s = %d", "BizTimeLineInfo", "type", 637534257))));
                                        aa.a aVar2 = new aa.a();
                                        aVar2.NQE = aa.b.DELETE;
                                        ban4.a(aVar2);
                                    }
                                    aa ban5 = ag.ban();
                                    Cursor rawQuery2 = ban5.iFy.rawQuery("SELECT * FROM BizTimeLineInfo where type=637534257 and orderFlag > ".concat(String.valueOf(gAS << 32)), null);
                                    z zVar2 = null;
                                    if (rawQuery2.moveToFirst()) {
                                        zVar2 = new z();
                                        zVar2.convertFrom(rawQuery2);
                                    }
                                    rawQuery2.close();
                                    if (zVar2 != null) {
                                        Log.i("MicroMsg.BizCardLogic", "insertAd groupId %d already has a adCard", Long.valueOf(gAS));
                                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(20636, zVar.gAG(), zVar.getTraceId(), 2);
                                        l lVar8 = l.IAx;
                                        l.LV(33);
                                    } else {
                                        zVar.field_msgId = ag.ban().gAW();
                                        zVar.field_msgSvrId = 0;
                                        zVar.field_talker = "";
                                        zVar.field_talkerId = 0;
                                        zVar.field_hasShow = 1;
                                        zVar.field_createTime = bp.aVP();
                                        if (gAM.gAv()) {
                                            j2 = gAM.fqM;
                                        } else {
                                            j2 = gAM.field_createTime;
                                        }
                                        zVar.yw(j2);
                                        zVar.nc(1);
                                        zVar.field_status = 3;
                                        zVar.field_orderFlag = r.MJ(0);
                                        if (zVar.field_orderFlag > 0) {
                                            r.gzI().encode(r.biG("biz_ad_card_data"), "");
                                            rVar.z(zVar);
                                            boolean B = ag.ban().B(zVar);
                                            Log.i("MicroMsg.BizCardLogic", "insertAd result: " + B + ", msgId:" + zVar.field_msgId + " orderFlag:" + zVar.field_orderFlag + " aid: " + zVar.gAG());
                                            com.tencent.mm.plugin.report.service.h.INSTANCE.a(20636, zVar.gAG(), zVar.getTraceId(), 0);
                                            l lVar9 = l.IAx;
                                            l.LV(35);
                                            if (!z) {
                                                l lVar10 = l.IAx;
                                                l.LV(38);
                                            }
                                            if (B) {
                                                ag.bao().biF(zVar.gAG());
                                            }
                                        }
                                    }
                                } else {
                                    Log.i("MicroMsg.BizCardLogic", "insertAd groupId %d already has a recCard", Long.valueOf(gAS));
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(20636, zVar.gAG(), zVar.getTraceId(), 1);
                                    l lVar11 = l.IAx;
                                    l.LV(34);
                                }
                            }
                        }
                    }
                    if (r.gzN()) {
                        ((b) g.af(b.class)).P("wxa06c02b5c00ff39b", "bizBoxClick", null);
                        AppMethodBeat.o(212359);
                        return;
                    }
                    r.eXq();
                }
                AppMethodBeat.o(212359);
            }
        }, "BizInsertTlRecCardThread");
        ac acVar = ac.NRc;
        ac.gBh();
        AppMethodBeat.o(124667);
    }

    public static void gAY() {
        AppMethodBeat.i(124668);
        if (!g.aAc()) {
            AppMethodBeat.o(124668);
            return;
        }
        MultiProcessMMKV singleMMKV = MultiProcessMMKV.getSingleMMKV("brandService");
        StringBuilder sb = new StringBuilder("BizLatestRecommendCardInfo");
        g.aAf();
        biZ(singleMMKV.decodeString(sb.append(a.ayV()).toString()));
        AppMethodBeat.o(124668);
    }

    public static void biZ(String str) {
        long j2;
        as Kn;
        AppMethodBeat.i(212360);
        if (Util.isNullOrNil(str)) {
            Log.d("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertTlRecCard no need to insert");
            AppMethodBeat.o(212360);
            return;
        }
        int indexOf = str.indexOf("<sysmsg");
        if (indexOf != -1) {
            Map<String, String> parseXml = XmlParser.parseXml(str.substring(indexOf), "sysmsg", null);
            if (parseXml == null) {
                Log.e("MicroMsg.BizTimeLineInfoStorageLogic", "XmlParser values is null, msgContent %s", str);
                AppMethodBeat.o(212360);
            } else if (af.bU(parseXml)) {
                af.bW(parseXml);
                AppMethodBeat.o(212360);
            } else {
                ege bT = bT(parseXml);
                af.a(bT, parseXml);
                z gAM = ag.ban().gAM();
                if (gAM == null) {
                    Log.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] doInsertTlRecCard lastTimeLineInfo is null");
                    af.a(bT, bT.MOD, 1);
                    AppMethodBeat.o(212360);
                    return;
                }
                MultiProcessMMKV singleMMKV = MultiProcessMMKV.getSingleMMKV("brandService");
                if (bT.MOD != 2) {
                    if (gAM.field_status == 4) {
                        Log.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] doInsertTlRecCard lastTimeLineInfo is exposed");
                        af.a(bT, bT.MOD, 2);
                        AppMethodBeat.o(212360);
                        return;
                    }
                    StringBuilder sb = new StringBuilder("BizLatestRecommendCardInfo");
                    g.aAf();
                    singleMMKV.encode(sb.append(a.ayV()).toString(), "");
                }
                if (!af.b(bT, (z) null)) {
                    Log.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] doInsertTlRecCard wrapper illegal");
                    af.a(bT, bT.MOD, 3);
                    AppMethodBeat.o(212360);
                    return;
                }
                int i2 = bT.pos;
                long j3 = (long) bT.weight;
                if (i2 >= 0 || j3 >= 0) {
                    Log.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] doInsertTlRecCard pos %d, weight %d", Integer.valueOf(i2), Long.valueOf(j3));
                    if (af.g(bT)) {
                        af.a(bT, bT.MOD, 5);
                        AppMethodBeat.o(212360);
                        return;
                    }
                    long gAS = ag.ban().gAS();
                    if (bT.style == 103 || (Kn = ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(bT.NfY.NfT.UserName)) == null || !c.oR(Kn.field_type)) {
                        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(1149, 1, 1, false);
                        long gAO = ag.ban().gAO();
                        z zVar = new z();
                        zVar.field_msgId = ag.ban().gAW();
                        zVar.field_msgSvrId = 0;
                        zVar.field_type = 620757041;
                        zVar.field_talker = bT.NfY.NfT.UserName;
                        zVar.field_talkerId = 0;
                        zVar.field_createTime = gAO - 1000;
                        zVar.nc(1);
                        zVar.field_status = 3;
                        af.a(zVar, bT);
                        zVar.c(bT);
                        long j4 = 0;
                        if (j3 >= 0) {
                            j4 = Math.min(j3, 255L);
                        } else if (i2 == 0) {
                            j4 = Na(gAM.field_orderFlag);
                            zVar.field_createTime = gAO + 1000;
                        } else {
                            z ajV = ag.ban().ajV(i2 - 1);
                            if (ajV == null) {
                                Log.w("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertTlRecCard lastTimeLineInfo is null");
                            } else {
                                j4 = Na(ajV.field_orderFlag);
                                zVar.field_createTime = ajV.field_createTime - 1000;
                            }
                        }
                        long j5 = (j4 << 24) & 4278190080L;
                        long aF = bT.MOD == 2 ? aF(gAS, zVar.field_createTime / 1000) : aE(gAS, zVar.field_createTime / 1000);
                        if (bT.MOD != 2) {
                            j2 = gAS;
                        } else if (gAS <= 10) {
                            AppMethodBeat.o(212360);
                            return;
                        } else {
                            j2 = gAS - 1;
                            zVar.field_hasShow = 1;
                            zVar.field_status = 4;
                            zVar.iF(2);
                        }
                        zVar.field_orderFlag = aF | (j2 << 32) | j5;
                        E(zVar);
                        boolean b2 = ag.ban().b(zVar, bT.MOD != 2);
                        Log.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] doInsertTlRecCard result: %b, username: %s, redDotFlag=%d ", Boolean.valueOf(b2), bT.NfY.NfT.UserName, Integer.valueOf(bT.MOD));
                        af.a(bT, bT.MOD, b2 ? 0 : 7);
                        AppMethodBeat.o(212360);
                        return;
                    }
                    Log.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] doInsertTlRecCard %s is contact", bT.NfY.NfT.UserName);
                    af.a(bT, bT.MOD, 6);
                    AppMethodBeat.o(212360);
                    return;
                }
                Log.w("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertTlRecCard data invalid pos %d, weight %d", Integer.valueOf(i2), Long.valueOf(j3));
                af.a(bT, bT.MOD, 4);
                AppMethodBeat.o(212360);
            }
        } else {
            AppMethodBeat.o(212360);
        }
    }

    public static z X(String str, Map<String, String> map) {
        long j2;
        as Kn;
        AppMethodBeat.i(212361);
        if (!g.aAc()) {
            AppMethodBeat.o(212361);
            return null;
        } else if (Util.isNullOrNil(str)) {
            Log.d("MicroMsg.BizTimeLineInfoStorageLogic", "insertTlRecCardImmediately no need to insert");
            AppMethodBeat.o(212361);
            return null;
        } else {
            if (map == null) {
                int indexOf = str.indexOf("<sysmsg");
                if (indexOf != -1) {
                    map = XmlParser.parseXml(str.substring(indexOf), "sysmsg", null);
                    if (map == null) {
                        Log.e("MicroMsg.BizTimeLineInfoStorageLogic", "XmlParser values is null, msgContent %s", str);
                        AppMethodBeat.o(212361);
                        return null;
                    }
                } else {
                    AppMethodBeat.o(212361);
                    return null;
                }
            }
            z gAM = ag.ban().gAM();
            ege bT = bT(map);
            af.a(bT, map);
            if (!af.b(bT, (z) null)) {
                Log.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] insertTlRecCardImmediately wrapper illegal");
                af.a(bT, bT.MOD, 3);
                AppMethodBeat.o(212361);
                return null;
            }
            int i2 = bT.pos;
            long j3 = (long) bT.weight;
            if (i2 >= 0 || j3 >= 0) {
                Log.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] insertTlRecCardImmediately pos %d, weight %d", Integer.valueOf(i2), Long.valueOf(j3));
                if (af.g(bT)) {
                    af.a(bT, bT.MOD, 5);
                    AppMethodBeat.o(212361);
                    return null;
                }
                long gAo = ag.ban().gAo();
                if (bT.style == 103 || (Kn = ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(bT.NfY.NfT.UserName)) == null || !c.oR(Kn.field_type)) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(1149, 1, 1, false);
                    z zVar = new z();
                    zVar.field_msgId = ag.ban().gAW();
                    zVar.field_msgSvrId = 0;
                    zVar.field_type = 620757041;
                    zVar.field_talker = bT.NfY.NfT.UserName;
                    zVar.field_talkerId = 0;
                    if (bT.Ngb == 1) {
                        zVar.field_createTime = Math.abs((bT.MOC * 1000) - bp.aVP()) <= Util.MILLSECONDS_OF_DAY ? bT.MOC * 1000 : bp.aVP();
                    } else {
                        zVar.field_createTime = ag.ban().gAO() + 1000;
                    }
                    zVar.nc(1);
                    zVar.field_status = 3;
                    af.a(zVar, bT);
                    zVar.c(bT);
                    long j4 = 0;
                    if (gAM != null) {
                        if (j3 >= 0) {
                            j4 = Math.min(j3, Na(gAM.field_orderFlag));
                        } else if (i2 == 0) {
                            j4 = Na(gAM.field_orderFlag);
                        } else {
                            z ajV = ag.ban().ajV(i2 - 1);
                            if (ajV == null) {
                                Log.w("MicroMsg.BizTimeLineInfoStorageLogic", "insertTlRecCardImmediately lastTimeLineInfo is null");
                            } else {
                                j4 = Na(ajV.field_orderFlag);
                            }
                        }
                    }
                    long j5 = (j4 << 24) & 4278190080L;
                    long aE = aE(gAo, zVar.field_createTime / 1000);
                    if (aE >= 4294967296L) {
                        Log.w("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] insertTlRecCardImmediately serialNumber is too big %d", Long.valueOf(aE));
                        j2 = ag.ban().gAT();
                        aE = aE(j2, zVar.field_createTime / 1000);
                    } else {
                        j2 = gAo;
                    }
                    zVar.field_orderFlag = aE | (j2 << 32) | j5;
                    E(zVar);
                    boolean B = ag.ban().B(zVar);
                    Log.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] insertTlRecCardImmediately result: %b, username: %s", Boolean.valueOf(B), bT.NfY.NfT.UserName);
                    af.a(bT, bT.MOD, B ? 0 : 7);
                    AppMethodBeat.o(212361);
                    return zVar;
                }
                Log.w("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] insertTlRecCardImmediately %s is contact", bT.NfY.NfT.UserName);
                af.a(bT, bT.MOD, 6);
                AppMethodBeat.o(212361);
                return null;
            }
            Log.w("MicroMsg.BizTimeLineInfoStorageLogic", "insertTlRecCardImmediately data invalid pos %d, weight %d", Integer.valueOf(i2), Long.valueOf(j3));
            af.a(bT, bT.MOD, 4);
            AppMethodBeat.o(212361);
            return null;
        }
    }

    private static ege bT(Map<String, String> map) {
        int i2 = 0;
        AppMethodBeat.i(124669);
        ege ege = new ege();
        ege.NfY = new efz();
        ege.NfY.Lug = map.get(".sysmsg.BizAccountRecommend.Title");
        ege.NfY.KWx = map.get(".sysmsg.BizAccountRecommend.BizAccount.AppMsgRecReason");
        ege.NfY.NfT = new egb();
        ege.NfY.NfT.KQY = map.get(".sysmsg.BizAccountRecommend.BizAccount.BrandIconUrl");
        ege.NfY.NfT.UserName = map.get(".sysmsg.BizAccountRecommend.BizAccount.UserName");
        ege.NfY.NfT.oUJ = map.get(".sysmsg.BizAccountRecommend.BizAccount.NickName");
        ege.NfY.NfT.NfV = map.get(".sysmsg.BizAccountRecommend.BizAccount.RecommendReason");
        ege.NfY.NfT.keb = map.get(".sysmsg.BizAccountRecommend.BizAccount.Signature");
        egd egd = new egd();
        anx anx = new anx();
        int i3 = 0;
        while (i3 < 20) {
            String str = map.get(".sysmsg.BizAccountRecommend.BizAccount.NegativeFeedbackReason" + (i3 == 0 ? "" : Integer.valueOf(i3)));
            if (Util.isNullOrNil(str)) {
                break;
            }
            anx.KWr.add(str);
            i3++;
        }
        anx.KWs = Util.getInt(map.get(".sysmsg.BizAccountRecommend.BizAccount.ShowNegativeFeedbackReason"), 1);
        egd.NfX = anx;
        ege.NfY.NfU = egd;
        while (i2 < 2) {
            ega ega = new ega();
            String str2 = ".sysmsg.BizAccountRecommend.BizAccount" + (i2 == 0 ? "" : 1);
            ega.Title = map.get(str2 + ".AppMsg.Title");
            if (Util.isNullOrNil(ega.Title)) {
                break;
            }
            ega.KSh = map.get(str2 + ".AppMsg.Digest");
            ega.KSj = map.get(str2 + ".AppMsg.ContentUrl");
            ega.KSl = map.get(str2 + ".AppMsg.CoverImgUrl");
            ega.KSm = map.get(str2 + ".AppMsg.CoverImgUrl_1_1");
            ega.KSn = map.get(str2 + ".AppMsg.CoverImgUrl_235_1");
            ega.iAb = Util.getInt(map.get(str2 + ".AppMsg.ItemShowType"), -1);
            ega.KSu = map.get(str2 + ".AppMsg.VideoId");
            ega.KSv = Util.getInt(map.get(str2 + ".AppMsg.VideoWidth"), -1);
            ega.KSw = Util.getInt(map.get(str2 + ".AppMsg.VideoHeight"), -1);
            ega.KSx = Util.getInt(map.get(str2 + ".AppMsg.VideoDuration"), -1);
            ega.CreateTime = Util.getInt(map.get(str2 + ".AppMsg.CreateTime"), -1);
            ega.KWt = map.get(str2 + ".AppMsg.VoicePlayUrl");
            ega.KWu = Util.getInt(map.get(str2 + ".AppMsg.VoiceDuration"), -1);
            ege.NfY.KWy.add(ega);
            i2++;
        }
        ege.pos = Util.getInt(map.get(".sysmsg.BizAccountRecommend.Pos"), -1);
        ege.weight = Util.getInt(map.get(".sysmsg.BizAccountRecommend.Weight"), -1);
        ege.MOC = Util.getLong(map.get(".sysmsg.BizAccountRecommend.RecID"), -1);
        ege.Ngd = map.get(".sysmsg.BizAccountRecommend.CardId");
        ege.style = Util.getInt(map.get(".sysmsg.BizAccountRecommend.Style"), -1);
        ege.dSJ = map.get(".sysmsg.BizAccountRecommend.ExtraData");
        ege.MOD = Util.getInt(map.get(".sysmsg.BizAccountRecommend.RedDotFlag"), -1);
        AppMethodBeat.o(124669);
        return ege;
    }

    public static void E(z zVar) {
        AppMethodBeat.i(124670);
        while (ag.ban().ML(zVar.field_orderFlag) != null) {
            zVar.field_orderFlag++;
        }
        AppMethodBeat.o(124670);
    }

    public static void gAZ() {
        AppMethodBeat.i(212362);
        com.tencent.f.h.RTc.b(new Runnable() {
            /* class com.tencent.mm.storage.ab.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(124660);
                if (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_delete_office_account_msg, 1) == 1) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(1378, 1, 1, false);
                    aa ban = ag.ban();
                    Log.i("MicroMsg.BizTimeLineInfoStorage", "deleteTable start");
                    ban.iFy.execSQL("BizTimeLineInfo", "delete from BizTimeLineInfo");
                    Log.i("MicroMsg.BizTimeLineInfoStorage", "deleteTable end");
                    ae bap = ag.bap();
                    Log.i("MicroMsg.BizTimeLineInfoStorage", "deleteTable start");
                    bap.iFy.execSQL("BizTimeLineSingleMsgInfo", "delete from BizTimeLineSingleMsgInfo");
                    Log.i("MicroMsg.BizTimeLineInfoStorage", "deleteTable end");
                }
                AppMethodBeat.o(124660);
            }
        }, "BizTimeLineInfoStorageThread");
        AppMethodBeat.o(212362);
    }

    public static boolean Nb(long j2) {
        AppMethodBeat.i(124675);
        if (ag.ban().MR(j2) <= 0) {
            AppMethodBeat.o(124675);
            return false;
        }
        if (ag.ban().gAo() <= ag.ban().gAS()) {
            ag.ban().gAT();
        }
        ag.ban().MQ(j2);
        AppMethodBeat.o(124675);
        return true;
    }

    public static void aW(ca caVar) {
        AppMethodBeat.i(124676);
        if (caVar == null) {
            AppMethodBeat.o(124676);
            return;
        }
        ag.ban().MX(caVar.field_msgId);
        AppMethodBeat.o(124676);
    }

    public static long aE(long j2, long j3) {
        long j4;
        long j5 = -1;
        AppMethodBeat.i(124677);
        String str = (String) g.aAh().azQ().get(ar.a.USERINFO_BIZ_TIME_LINE_GROUP_START_TIME_STRING_SYNC, "");
        if (!Util.isNullOrNil(str)) {
            String[] split = str.split(":");
            if (split.length == 2 && Util.getLong(split[0], -1) == j2) {
                j5 = j3 - Util.getLong(split[1], -1);
            }
        }
        if (j5 < 0) {
            j4 = 604800;
            String str2 = j2 + ":" + (j3 - 604800);
            g.aAh().azQ().set(ar.a.USERINFO_BIZ_TIME_LINE_GROUP_START_TIME_STRING_SYNC, str2);
            Log.d("MicroMsg.BizTimeLineInfoStorageLogic", "getSerialNumber set groupStartTime %s,createTime %d", str2, Long.valueOf(j3));
        } else {
            Log.i("MicroMsg.BizTimeLineInfoStorageLogic", "getSerialNumber groupStartTime %s,createTime %d", str, Long.valueOf(j3));
            j4 = j5;
        }
        AppMethodBeat.o(124677);
        return j4;
    }

    public static long aF(long j2, long j3) {
        AppMethodBeat.i(212364);
        z MU = ag.ban().MU(j2);
        if (MU == null) {
            AppMethodBeat.o(212364);
            return 604800;
        }
        long j4 = j3 - ((MU.field_createTime / 1000) - 604800);
        AppMethodBeat.o(212364);
        return j4;
    }

    public static void gBa() {
        boolean z;
        az azVar;
        z zVar;
        long a2;
        String str;
        AppMethodBeat.i(124678);
        if (!clc()) {
            AppMethodBeat.o(124678);
            return;
        }
        bw aST = ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aST();
        az bjY = aST.bjY("officialaccounts");
        if (bjY == null) {
            z = true;
            azVar = new az("officialaccounts");
        } else {
            z = false;
            azVar = bjY;
        }
        int i2 = 0;
        z gAM = ag.bap().gAM();
        z gAM2 = ag.ban().gAM();
        long gAO = ag.ban().gAO();
        long j2 = gAM != null ? gAM.field_createTime : 0;
        if (gAM2 != null) {
            i2 = ag.ban().MW(gAM2.field_orderFlag);
        }
        int ctM = ag.bap().ctM();
        if (ctM <= 0) {
            azVar.oT(16);
            azVar.nt(i2);
            zVar = gAM2;
        } else if (j2 > gAO) {
            azVar.oU(16);
            azVar.nt(ctM);
            zVar = gAM;
        } else {
            azVar.oT(16);
            azVar.nt(i2);
            zVar = gAM2;
        }
        if (zVar == null || zVar.field_msgId == 0) {
            Log.w("MicroMsg.BizTimeLineInfoStorageLogic", "doUpdateBizMainCell BizTimeLineInfo is null");
            azVar.gCr();
            if (!z) {
                aST.a(azVar, azVar.field_username);
            }
            AppMethodBeat.o(124678);
            return;
        }
        if (zVar == gAM2 && zVar.field_placeTop == 1) {
            azVar.oT(32);
        } else {
            azVar.oU(32);
        }
        if (zVar == gAM) {
            long j3 = zVar.field_msgId;
            if (NQM == 0) {
                NQM = MMApplicationContext.getDefaultPreference().getLong("biz_time_line_last_notify_msg_id", -1);
            }
            if (j3 == NQM) {
                azVar.oU(64);
            } else {
                azVar.oT(64);
            }
        }
        ca caVar = new ca();
        caVar.setContent(zVar.field_content);
        caVar.Cy(zVar.field_talker);
        caVar.setStatus(zVar.field_status);
        if (zVar.gAv()) {
            caVar.setCreateTime(zVar.fqM);
        } else {
            caVar.setCreateTime(zVar.field_createTime);
        }
        caVar.setMsgId(zVar.field_msgId);
        caVar.setType(zVar.field_type);
        caVar.BB(zVar.fqK);
        caVar.Cz(zVar.field_imgPath);
        long min = Math.min(cl.aWz(), azVar.field_conversationTime);
        long max = Math.max(j2, gAO);
        azVar.aX(caVar);
        azVar.setContent(caVar.field_talker + ":" + caVar.field_content);
        azVar.Cl(Integer.toString(caVar.getType()));
        bw.b Xh = aST.Xh();
        if (Xh != null) {
            PString pString = new PString();
            PString pString2 = new PString();
            PInt pInt = new PInt();
            caVar.Cy("officialaccounts");
            caVar.setContent(azVar.field_content);
            Xh.a(caVar, pString, pString2, pInt, true);
            if (zVar.gAu()) {
                boolean z2 = false;
                ege gAD = zVar.gAD();
                if (gAD != null && gAD.style == 1001 && gAD.Ngc != null && !Util.isNullOrNil(gAD.Ngc.Lui)) {
                    pString.value = gAD.Ngc.Lui;
                    z2 = true;
                }
                if (!z2 && gAD != null && gAD.NfY != null && !Util.isNullOrNil(gAD.NfY.Lug)) {
                    pString.value = gAD.NfY.Lug;
                    if ((gAD.style == 101 || gAD.style == 102 || gAD.style == 103) && gAD.Nga != null && !Util.isNullOrNil(gAD.Nga.Lui)) {
                        pString.value = gAD.Nga.Lui;
                    }
                } else if (!z2) {
                    pString.value = MMApplicationContext.getResources().getString(R.string.ah9);
                }
            }
            if (zVar.gAv()) {
                pString.value = MMApplicationContext.getResources().getString(R.string.ah8);
            }
            if (zVar.gAw()) {
                if (zVar.NQo != null) {
                    str = zVar.NQo.iAq;
                } else {
                    com.tencent.mm.plugin.biz.b.b bVar = com.tencent.mm.plugin.biz.b.b.pfn;
                    zVar.NQo = com.tencent.mm.plugin.biz.b.b.ahh(zVar.field_content);
                    str = zVar.NQo.iAq;
                }
                pString.value = str;
            }
            if (zVar.isText() || zVar.gAz() || zVar.gAx()) {
                String H = ag.H(zVar);
                if (!Util.isNullOrNil(H)) {
                    pString.value = H;
                }
            }
            azVar.Cm(pString.value);
            azVar.Cn(pString2.value);
            azVar.nw(pInt.value);
        }
        azVar.yA(Math.max(min, max));
        if (z) {
            a2 = aST.e(azVar);
        } else {
            a2 = (long) aST.a(azVar, azVar.field_username);
        }
        MultiProcessMMKV singleMMKV = MultiProcessMMKV.getSingleMMKV("brandService");
        if (singleMMKV != null) {
            singleMMKV.encode("BizLastMsgId", zVar.field_msgId);
            singleMMKV.encode("BizLastMsgTime", zVar.field_createTime);
        }
        Log.i("MicroMsg.BizTimeLineInfoStorageLogic", "doUpdateBizMainCell ret %d, shouldOfInsert %b, time %d, unread %d, msgId %d, talker:%s", Long.valueOf(a2), Boolean.valueOf(z), Long.valueOf(azVar.field_conversationTime), Integer.valueOf(azVar.field_unReadCount), Long.valueOf(zVar.field_msgId), zVar.field_talker);
        AppMethodBeat.o(124678);
    }

    public static void bja(String str) {
        NQL = str;
    }

    public static void Nc(long j2) {
        AppMethodBeat.i(124679);
        NQM = j2;
        MMApplicationContext.getDefaultPreference().edit().putLong("biz_time_line_last_notify_msg_id", j2).apply();
        AppMethodBeat.o(124679);
    }

    public static void DU(int i2) {
        dEb = i2;
    }

    public static int getSessionId() {
        return dEb;
    }

    public static boolean gBb() {
        AppMethodBeat.i(212365);
        long currentTimeMillis = System.currentTimeMillis();
        int gBc = gBc() * 1000;
        if (NQT == 0 || NQU == 0 || currentTimeMillis - NQT >= ((long) gBc)) {
            AppMethodBeat.o(212365);
            return false;
        }
        AppMethodBeat.o(212365);
        return true;
    }

    public static boolean bD(int i2, boolean z) {
        AppMethodBeat.i(212366);
        if (!gBd()) {
            AppMethodBeat.o(212366);
            return z;
        } else if (z) {
            AppMethodBeat.o(212366);
            return true;
        } else if (i2 > 0) {
            AppMethodBeat.o(212366);
            return false;
        } else {
            if (System.currentTimeMillis() - NQT < ((long) (com.tencent.mm.model.p.aTG() * 1000))) {
                AppMethodBeat.o(212366);
                return true;
            }
            AppMethodBeat.o(212366);
            return false;
        }
    }

    public static int gBc() {
        AppMethodBeat.i(212367);
        if (NQV != 0) {
            int i2 = NQV;
            AppMethodBeat.o(212367);
            return i2;
        }
        int a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_open_biz_time_line_stay_time, TXLiveConstants.RENDER_ROTATION_180);
        NQV = a2;
        AppMethodBeat.o(212367);
        return a2;
    }

    public static boolean clc() {
        boolean z;
        AppMethodBeat.i(124680);
        if (NQW != null) {
            boolean booleanValue = NQW.booleanValue();
            AppMethodBeat.o(124680);
            return booleanValue;
        }
        if (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_open_biz_time_line, 1) == 1) {
            z = true;
        } else {
            z = false;
        }
        NQW = Boolean.valueOf(z);
        Log.i("MicroMsg.BizTimeLineInfoStorageLogic", "isBizTimeLineOpen open %b", NQW);
        boolean booleanValue2 = NQW.booleanValue();
        AppMethodBeat.o(124680);
        return booleanValue2;
    }

    public static boolean gBd() {
        boolean z;
        boolean z2;
        AppMethodBeat.i(212368);
        if (NQX != null) {
            boolean booleanValue = NQX.booleanValue();
            AppMethodBeat.o(212368);
            return booleanValue;
        }
        int decodeInt = MultiProcessMMKV.getSingleMMKV("brandService").decodeInt("BizTimeLineOpenStatus", BuildInfo.DEBUG || BuildInfo.IS_FLAVOR_RED || WeChatEnvironment.hasDebugger() ? 1 : -1);
        if (decodeInt == 1) {
            NQX = Boolean.TRUE;
        } else if (decodeInt == 0) {
            NQX = Boolean.FALSE;
        } else {
            if (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_open_biz_rec_time_line, 0) == 1) {
                z = true;
            } else {
                z = false;
            }
            p.a aVar = com.tencent.mm.model.p.iCa;
            boolean aTK = p.a.aTK();
            if (!z || !aTK) {
                z2 = false;
            } else {
                z2 = true;
            }
            NQX = Boolean.valueOf(z2);
            Log.i("MicroMsg.BizTimeLineInfoStorageLogic", "isRecFeedsOpen localOpen %b, svrOpen %b", Boolean.valueOf(z), Boolean.valueOf(aTK));
        }
        boolean booleanValue2 = NQX.booleanValue();
        AppMethodBeat.o(212368);
        return booleanValue2;
    }

    public static boolean gBe() {
        boolean z;
        AppMethodBeat.i(176159);
        if (NQY != null) {
            boolean booleanValue = NQY.booleanValue();
            AppMethodBeat.o(176159);
            return booleanValue;
        }
        if (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_open_biz_time_line_show_time, 1) == 1) {
            z = true;
        } else {
            z = false;
        }
        NQY = Boolean.valueOf(z);
        Log.i("MicroMsg.BizTimeLineInfoStorageLogic", "isShowBizTimeLineTime %b", NQY);
        boolean booleanValue2 = NQY.booleanValue();
        AppMethodBeat.o(176159);
        return booleanValue2;
    }

    public static void e(ca caVar, boolean z) {
        AppMethodBeat.i(212363);
        if (Util.isEqual(caVar.field_talker, NQL)) {
            Log.v("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertBizTimeLineMsg is currentTalker %s, just return.", NQL);
            AppMethodBeat.o(212363);
            return;
        }
        z R = ag.bap().R(caVar.field_msgSvrId, "msgSvrId");
        z zVar = R == null ? new z() : R;
        if (z) {
            zVar.field_msgId = ag.bap().gBo();
        } else {
            zVar.field_msgId = caVar.field_msgId;
        }
        zVar.field_msgSvrId = caVar.field_msgSvrId;
        zVar.field_content = caVar.field_content;
        zVar.field_type = caVar.getType();
        zVar.field_talker = caVar.field_talker;
        zVar.field_talkerId = caVar.field_talkerId;
        zVar.field_createTime = caVar.field_createTime;
        zVar.field_imgPath = caVar.field_imgPath;
        zVar.nc(caVar.fqJ);
        zVar.BB(caVar.fqK);
        zVar.field_status = caVar.field_status;
        if (R == null) {
            ag.bap().B(zVar);
            AppMethodBeat.o(212363);
            return;
        }
        ag.bap().C(zVar);
        AppMethodBeat.o(212363);
    }
}
