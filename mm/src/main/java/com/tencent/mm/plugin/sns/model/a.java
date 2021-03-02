package com.tencent.mm.plugin.sns.model;

import android.database.Cursor;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelstat.p;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.sns.ad.timeline.b.d;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.j;
import com.tencent.mm.plugin.sns.storage.AdSnsInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.y;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.ad;
import com.tencent.mm.protocal.protobuf.cj;
import com.tencent.mm.protocal.protobuf.dkg;
import com.tencent.mm.protocal.protobuf.ds;
import com.tencent.mm.protocal.protobuf.dzd;
import com.tencent.mm.protocal.protobuf.dzg;
import com.tencent.mm.protocal.protobuf.dzi;
import com.tencent.mm.protocal.protobuf.dzj;
import com.tencent.mm.protocal.protobuf.dzo;
import com.tencent.mm.protocal.protobuf.eaq;
import com.tencent.mm.protocal.protobuf.eco;
import com.tencent.mm.protocal.protobuf.ecp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a {
    private static Comparator<dzo> DGA = new Comparator<dzo>() {
        /* class com.tencent.mm.plugin.sns.model.a.AnonymousClass1 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public final /* bridge */ /* synthetic */ int compare(dzo dzo, dzo dzo2) {
            return dzo.CreateTime - dzo2.CreateTime;
        }
    };
    private static final String DGy;
    private static LinkedHashMap<Long, Integer> DGz;

    static {
        AppMethodBeat.i(95410);
        StringBuilder sb = new StringBuilder();
        g.aAi();
        DGy = sb.append(g.aAh().cachePath).append("sns_recvd_ad").toString();
        AppMethodBeat.o(95410);
    }

    public static void a(dzd dzd, SKBuiltinBuffer_t sKBuiltinBuffer_t) {
        AppMethodBeat.i(95380);
        if (dzd == null) {
            Log.i("MicroMsg.AdSnsInfoStorageLogic", "error adobj");
            AppMethodBeat.o(95380);
        } else if (dzd.MYH == null) {
            Log.i("MicroMsg.AdSnsInfoStorageLogic", "error adobj");
            AppMethodBeat.o(95380);
        } else {
            AdSnsInfo b2 = b(dzd);
            if (b2 == null) {
                AppMethodBeat.o(95380);
                return;
            }
            b2.field_adinfo = a(b2.field_adinfo, sKBuiltinBuffer_t);
            if (aj.faR().JF(dzd.MYH.Id)) {
                Log.i("MicroMsg.AdSnsInfoStorageLogic", "find this adobj and update" + dzd.MYH.Id);
                aj.faR().b(dzd.MYH.Id, b2);
                AppMethodBeat.o(95380);
                return;
            }
            Log.i("MicroMsg.AdSnsInfoStorageLogic", "local can not find this adobj " + dzd.MYH.Id);
            AppMethodBeat.o(95380);
        }
    }

    public static void a(eaq eaq) {
        AppMethodBeat.i(95381);
        a(b(eaq));
        AppMethodBeat.o(95381);
    }

    public static void a(dzd dzd) {
        AppMethodBeat.i(95382);
        if (dzd == null) {
            Log.i("MicroMsg.AdSnsInfoStorageLogic", "error adobj");
            AppMethodBeat.o(95382);
        } else if (dzd.MYH == null) {
            Log.i("MicroMsg.AdSnsInfoStorageLogic", "error adobj");
            AppMethodBeat.o(95382);
        } else {
            aj.faR().a(dzd.MYH.Id, b(dzd));
            AppMethodBeat.o(95382);
        }
    }

    public static void b(ds dsVar) {
        AppMethodBeat.i(95383);
        if (dsVar == null) {
            Log.i("MicroMsg.AdSnsInfoStorageLogic", "advertiseObject null");
            AppMethodBeat.o(95383);
        } else if (dsVar.KHG == null) {
            Log.i("MicroMsg.AdSnsInfoStorageLogic", "advertiseObject.SnsADObject is null");
            AppMethodBeat.o(95383);
        } else if (dsVar.KHG.MYH == null) {
            Log.i("MicroMsg.AdSnsInfoStorageLogic", "advertiseObject.SnsADObject.SnsObject is null");
            AppMethodBeat.o(95383);
        } else {
            String Jb = r.Jb(dsVar.KHG.MYH.Id);
            if (!aj.faR().JF(dsVar.KHG.MYH.Id)) {
                int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
                if (dsVar.KHG.MYH.CommentUserListCount > 0) {
                    currentTimeMillis = dsVar.KHG.MYH.CommentUserList.get(0).CreateTime;
                }
                Log.i("MicroMsg.AdSnsInfoStorageLogic", "replaceAtObj, insert at adObject, snsId=" + Jb + ", createTime=" + currentTimeMillis);
                a(dsVar, currentTimeMillis, currentTimeMillis);
                AdSnsInfo JE = aj.faR().JE(dsVar.KHG.MYH.Id);
                if (JE != null) {
                    Log.i("MicroMsg.AdSnsInfoStorageLogic", "set at ad invisible");
                    JE.setLocalInvisible();
                    aj.faR().a(JE.field_snsId, JE);
                }
            } else {
                Log.i("MicroMsg.AdSnsInfoStorageLogic", "replaceAtObj, update, snsId=".concat(String.valueOf(Jb)));
                a(dsVar.KHG);
            }
            AdSnsInfo JE2 = aj.faR().JE(dsVar.KHG.MYH.Id);
            if (JE2 != null) {
                JE2.field_atAdinfo = z.a(dsVar.KHH);
                cj remindInfoGroup = JE2.getRemindInfoGroup();
                if (remindInfoGroup == null) {
                    remindInfoGroup = new cj();
                }
                remindInfoGroup.KGE = dsVar.KHJ;
                if (remindInfoGroup.KGE != null) {
                    Log.i("MicroMsg.AdSnsInfoStorageLogic", "update atFriend remindInfo, aid64 %d, aid %d", Long.valueOf(remindInfoGroup.KGE.MQh), Integer.valueOf(remindInfoGroup.KGE.MQc));
                } else {
                    Log.e("MicroMsg.AdSnsInfoStorageLogic", "atFriendRemindInfo == null");
                }
                JE2.setRemindInfoGroup(remindInfoGroup);
                aj.faR().a(JE2.field_snsId, JE2);
            }
            AppMethodBeat.o(95383);
        }
    }

    public static void U(long j2, int i2) {
        AppMethodBeat.i(202713);
        try {
            String Jb = r.Jb(j2);
            AdSnsInfo JE = aj.faR().JE(j2);
            if (JE == null) {
                Log.i("MicroMsg.AdSnsInfoStorageLogic", "deleteAdWithNoCheck, adSnsInfo is null, snsId=".concat(String.valueOf(Jb)));
                AppMethodBeat.o(202713);
                return;
            }
            Log.i("MicroMsg.AdSnsInfoStorageLogic", "deleteAdWithNoCheck, snsId=".concat(String.valueOf(Jb)));
            try {
                i.a(i2, j2, JE.getAdInfo(), JE.getAdXml());
            } catch (Throwable th) {
                Log.e("MicroMsg.AdSnsInfoStorageLogic", "reportAdDelException: " + th.toString());
            }
            aj.faR().delete(j2);
            aj.faT().JI(j2);
            com.tencent.mm.plugin.sns.storage.g.JH(j2);
            AppMethodBeat.o(202713);
        } catch (Exception e2) {
            Log.e("MicroMsg.AdSnsInfoStorageLogic", "deleteAdWithNoCheck, snsId=" + r.Jb(j2) + ", exp=" + e2.toString());
            AppMethodBeat.o(202713);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:127:0x0243 A[EDGE_INSN: B:127:0x0243->B:124:0x0243 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0262  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.tencent.mm.plugin.sns.storage.AdSnsInfo b(com.tencent.mm.protocal.protobuf.dzd r15) {
        /*
        // Method dump skipped, instructions count: 817
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.model.a.b(com.tencent.mm.protocal.protobuf.dzd):com.tencent.mm.plugin.sns.storage.AdSnsInfo");
    }

    private static boolean a(dzo dzo, List<dzo> list) {
        AppMethodBeat.i(95386);
        for (dzo dzo2 : list) {
            if (!Util.isNullOrNil(dzo.Username) && dzo.Username.equals(dzo2.Username)) {
                AppMethodBeat.o(95386);
                return true;
            }
        }
        AppMethodBeat.o(95386);
        return false;
    }

    private static boolean b(dzo dzo, List<dzo> list) {
        AppMethodBeat.i(95387);
        for (dzo dzo2 : list) {
            if (dzo.MYV == dzo2.MYV && dzo2.MYV != 0) {
                AppMethodBeat.o(95387);
                return true;
            }
        }
        AppMethodBeat.o(95387);
        return false;
    }

    private static void a(ds dsVar, int i2, int i3) {
        AppMethodBeat.i(95388);
        if (dsVar == null) {
            Log.i("MicroMsg.AdSnsInfoStorageLogic", "error adobj");
            AppMethodBeat.o(95388);
        } else if (dsVar.KHG == null || dsVar.KHG.MYH == null) {
            Log.i("MicroMsg.AdSnsInfoStorageLogic", "error adobj");
            AppMethodBeat.o(95388);
        } else {
            SnsObject snsObject = dsVar.KHG.MYH;
            AdSnsInfo b2 = b(dsVar.KHG);
            if (b2 == null) {
                Log.w("MicroMsg.AdSnsInfoStorageLogic", "adSnsInfo is null!");
                AppMethodBeat.o(95388);
                return;
            }
            ADInfo aDInfo = new ADInfo(z.a(dsVar.KHH));
            TimeLineObject timeLine = b2.getTimeLine();
            eco eco = new eco();
            eco.NcH = new ecp();
            eco.NcH.KxO = aDInfo.uxInfo;
            eco.NcH.NcK = timeLine.Id;
            eco.NcH.source = b2.getSource();
            eco.NcH.ElT = p.a(eco.NcH);
            if (timeLine.ContentObj.LoU == 1) {
                eco.NcH.adType = 1;
            } else if (timeLine.ContentObj.LoU == 15) {
                eco.NcH.adType = 2;
            } else {
                eco.NcH.adType = 0;
            }
            eco.NcH.NcL = b2.getExpId();
            try {
                String replace = Base64.encodeToString(eco.toByteArray(), 0).replace("\n", "");
                Log.i("MicroMsg.AdSnsInfoStorageLogic", "replace newly add snsId:%s, statExtStr:%s(id=%s,uxInfo=%s)", timeLine.Id, replace, eco.NcH.NcK, eco.NcH.KxO);
                timeLine.statExtStr = replace;
                b2.setTimeLine(timeLine);
            } catch (IOException e2) {
                Log.printErrStackTrace("MicroMsg.AdSnsInfoStorageLogic", e2, "", new Object[0]);
            }
            if (b2 == null) {
                AppMethodBeat.o(95388);
                return;
            }
            b2.field_createTime = i2;
            b2.field_createAdTime = i3;
            String a2 = z.a(dsVar.KHG.MYI);
            if (!Util.isNullOrNil(a2)) {
                b2.field_recxml = a2;
            }
            b2.field_adinfo = z.a(dsVar.KHH);
            b2.field_adxml = b2.field_recxml;
            aj.faR().a(snsObject.Id, b2);
            AppMethodBeat.o(95388);
        }
    }

    private static dzd b(eaq eaq) {
        AppMethodBeat.i(95389);
        if (eaq != null) {
            dzd dzd = new dzd();
            dzd.MYI = eaq.Nad;
            if (dzd.MYI == null) {
                Log.i("MicroMsg.AdSnsInfoStorageLogic", "recommendObj.RecommendXml is null");
            }
            dzd.MYH = eaq.MYH;
            AppMethodBeat.o(95389);
            return dzd;
        }
        AppMethodBeat.o(95389);
        return null;
    }

    private static ds a(dkg dkg) {
        AppMethodBeat.i(95390);
        if (dkg != null) {
            ds dsVar = new ds();
            dsVar.KHH = dkg.MOg;
            if (dsVar.KHH == null) {
                Log.i("MicroMsg.AdSnsInfoStorageLogic", "recObject.RecommendInfo is null");
                AppMethodBeat.o(95390);
                return null;
            }
            dsVar.KHG = b(dkg.MOf);
            AppMethodBeat.o(95390);
            return dsVar;
        }
        AppMethodBeat.o(95390);
        return null;
    }

    public static void b(dkg dkg) {
        int nowSecond;
        int i2;
        AppMethodBeat.i(95391);
        ds a2 = a(dkg);
        if (a2 == null) {
            AppMethodBeat.o(95391);
            return;
        }
        ADInfo aDInfo = new ADInfo(z.a(a2.KHH));
        int i3 = aDInfo.ad_sns_pos;
        int i4 = i3 <= 0 ? 1 : i3 + 1;
        int aQC = aj.faO().aQC("");
        Log.i("MicroMsg.AdSnsInfoStorageLogic", "ad.pos = %d, dbLimit = %d, createTime.limit = %d", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(aQC));
        Cursor aA = aj.faO().aA("", aQC, i4);
        if (aA == null || aA.getCount() <= 0) {
            Log.i("MicroMsg.AdSnsInfoStorageLogic", "db return nothing");
            nowSecond = (int) Util.nowSecond();
        } else {
            Log.i("MicroMsg.AdSnsInfoStorageLogic", "db return %d feeds", Integer.valueOf(aA.getCount()));
            SnsInfo snsInfo = new SnsInfo();
            if (i3 < 0) {
                i2 = 0;
            } else {
                i2 = i3;
            }
            if (aA.moveToPosition(i2)) {
                snsInfo.convertFrom(aA);
            } else {
                aA.moveToLast();
                snsInfo.convertFrom(aA);
            }
            nowSecond = snsInfo.getCreateTime() + 1;
        }
        aA.close();
        Log.i("MicroMsg.AdSnsInfoStorageLogic", "inserting snsid  " + a2.KHG.MYH.Id + " ,createTime " + nowSecond);
        a(a2, nowSecond, (int) Util.nowSecond());
        j.a(a2, true);
        a(a2.KHG.MYH.Id, aDInfo);
        try {
            String Jb = r.Jb(a2.KHG.MYH.Id);
            if (!d.a(aDInfo, Jb)) {
                d.a(Jb, aDInfo);
            }
            AppMethodBeat.o(95391);
        } catch (Throwable th) {
            Log.e("MicroMsg.AdSnsInfoStorageLogic", th.toString());
            AppMethodBeat.o(95391);
        }
    }

    public static void e(LinkedList<dkg> linkedList, LinkedList<SnsObject> linkedList2) {
        AppMethodBeat.i(95392);
        if (linkedList != null) {
            LinkedList<ds> bn = bn(linkedList);
            Log.i("MicroMsg.AdSnsInfoStorageLogic", "convert " + bn.size() + " recObj to AdvertiseObj");
            Iterator<ds> it = bn.iterator();
            while (it.hasNext()) {
                ds next = it.next();
                if (Jd(next.KHG.MYH.Id)) {
                    Log.w("MicroMsg.AdSnsInfoStorageLogic", "ignore recvd ad filter by snsId " + next.KHG.MYH.Id);
                    it.remove();
                }
            }
            s(bn, linkedList2);
        }
        AppMethodBeat.o(95392);
    }

    private static LinkedList<ds> bn(LinkedList<dkg> linkedList) {
        AppMethodBeat.i(95393);
        LinkedList<ds> linkedList2 = new LinkedList<>();
        Iterator<dkg> it = linkedList.iterator();
        while (it.hasNext()) {
            ds a2 = a(it.next());
            if (a2 != null) {
                linkedList2.add(a2);
            }
        }
        AppMethodBeat.o(95393);
        return linkedList2;
    }

    private static void s(List<ds> list, List<SnsObject> list2) {
        AppMethodBeat.i(95394);
        if (list == null || list2 == null || list2.size() == 0) {
            AppMethodBeat.o(95394);
            return;
        }
        int b2 = b(list2.get(list2.size() - 1));
        for (int i2 = 0; i2 < list.size(); i2++) {
            ds dsVar = list.get(i2);
            if (dsVar == null) {
                Log.i("MicroMsg.AdSnsInfoStorageLogic", "ad is null");
            } else if (dsVar.KHG == null) {
                Log.i("MicroMsg.AdSnsInfoStorageLogic", "item.SnsADObject is null");
            } else if (dsVar.KHG.MYH == null) {
                Log.i("MicroMsg.AdSnsInfoStorageLogic", "item.SnsADObject.SnsObject is null");
            } else {
                String a2 = z.a(dsVar.KHH);
                String a3 = z.a(dsVar.KHG.MYI);
                String b3 = z.b(dsVar.KHG.MYH.ObjectDesc);
                ADInfo aDInfo = new ADInfo(a2);
                Log.i("MicroMsg.AdSnsInfoStorageLogic", "skXml ".concat(String.valueOf(a2)));
                Log.i("MicroMsg.AdSnsInfoStorageLogic", "adXml ".concat(String.valueOf(a3)));
                Log.i("MicroMsg.AdSnsInfoStorageLogic", "snsXml " + b3 + APLogFileUtil.SEPARATOR_LINE);
                ADXml aDXml = new ADXml(a3);
                if (aDXml.originSnsId == 0 || !Jd(aDXml.originSnsId)) {
                    int i3 = b2 + 1;
                    if (aDInfo.ad_sns_pos >= list2.size() || aDInfo.ad_sns_pos < 0) {
                        Log.w("MicroMsg.AdSnsInfoStorageLogic", "invalid ad.pos " + aDInfo.ad_sns_pos);
                    } else {
                        i3 = b(list2.get(aDInfo.ad_sns_pos)) + 1;
                        Log.i("MicroMsg.AdSnsInfoStorageLogic", "create adinfo time  " + i3 + " pos " + aDInfo.ad_sns_pos);
                    }
                    int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
                    Log.i("MicroMsg.AdSnsInfoStorageLogic", "gettime ".concat(String.valueOf(currentTimeMillis)));
                    a(dsVar, i3, currentTimeMillis);
                    Je(dsVar.KHG.MYH.Id);
                    Je(aDXml.originSnsId);
                    a(dsVar.KHG.MYH.Id, aDInfo);
                } else {
                    Log.w("MicroMsg.AdSnsInfoStorageLogic", "ignore recvd ad filter by originSnsId " + aDXml.originSnsId);
                }
            }
        }
        AppMethodBeat.o(95394);
    }

    public static void a(List<ds> list, List<SnsObject> list2, boolean z, int i2) {
        boolean z2;
        AppMethodBeat.i(202714);
        if (WeChatBrands.Business.Entries.MomentAds.banned()) {
            AppMethodBeat.o(202714);
        } else if (list == null || list2 == null || list2.size() == 0) {
            AppMethodBeat.o(202714);
        } else {
            int b2 = b(list2.get(list2.size() - 1));
            boolean z3 = false;
            StringBuilder sb = new StringBuilder();
            sb.append("adList[");
            int i3 = 0;
            while (true) {
                z2 = z3;
                if (i3 >= list.size()) {
                    break;
                }
                ds dsVar = list.get(i3);
                if (dsVar == null) {
                    Log.i("MicroMsg.AdSnsInfoStorageLogic", "ad is null");
                } else if (dsVar.KHG == null) {
                    Log.i("MicroMsg.AdSnsInfoStorageLogic", "item.SnsADObject is null");
                } else if (dsVar.KHG.MYH == null) {
                    Log.i("MicroMsg.AdSnsInfoStorageLogic", "item.SnsADObject.SnsObject is null");
                } else {
                    String a2 = z.a(dsVar.KHH);
                    String a3 = z.a(dsVar.KHG.MYI);
                    String b3 = z.b(dsVar.KHG.MYH.ObjectDesc);
                    ADInfo aDInfo = new ADInfo(a2);
                    Log.i("MicroMsg.AdSnsInfoStorageLogic", "skXml %s, adXml %s, snsXml %s", a2, a3, b3);
                    String Jb = r.Jb(dsVar.KHG.MYH.Id);
                    try {
                        sb.append(Jb).append(",");
                        sb.append(aDInfo.ad_sns_pos).append("|");
                    } catch (Exception e2) {
                        Log.e("MicroMsg.AdSnsInfoStorageLogic", "log exp=" + e2.toString());
                    }
                    int i4 = b2 + 1;
                    if (aDInfo.ad_sns_pos >= list2.size() || aDInfo.ad_sns_pos < 0) {
                        Log.w("MicroMsg.AdSnsInfoStorageLogic", "invalid ad.pos " + aDInfo.ad_sns_pos);
                    } else {
                        i4 = b(list2.get(aDInfo.ad_sns_pos)) + 1;
                        Log.i("MicroMsg.AdSnsInfoStorageLogic", "create adinfo time  " + i4 + " pos " + aDInfo.ad_sns_pos);
                    }
                    int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
                    Log.i("MicroMsg.AdSnsInfoStorageLogic", "gettime ".concat(String.valueOf(currentTimeMillis)));
                    a(dsVar, i4, currentTimeMillis);
                    AdSnsInfo JE = aj.faR().JE(dsVar.KHG.MYH.Id);
                    if (JE != null) {
                        Log.i("MicroMsg.AdSnsInfoStorageLogic", "insert, snsId=" + Jb + ", exposureTime=" + JE.field_exposureTime + ", , expouseCnt=" + JE.field_exposureCount + ", isExposued=" + JE.isExposured() + ", adDupSnsIdDel=" + aDInfo.adDupSnsIdDel);
                        if (aDInfo.adDupSnsIdDel == 1 && JE != null) {
                            Log.i("AdExpireDeleteHelper", "resetAdExposureInfo, snsId=" + r.Jb(JE.field_snsId) + ", exposureTime=" + JE.field_exposureTime + ", exposureCount=" + JE.field_exposureCount + ", isExposured=" + JE.isExposured());
                            JE.field_exposureTime = 0;
                            JE.field_exposureCount = 0;
                            JE.setNotExposured();
                        }
                        cj remindInfoGroup = JE.getRemindInfoGroup();
                        if (remindInfoGroup == null) {
                            remindInfoGroup = new cj();
                        }
                        remindInfoGroup.KGD = dsVar.KHJ;
                        if (remindInfoGroup.KGD != null) {
                            Log.i("MicroMsg.AdSnsInfoStorageLogic", "update timeline remind info , aid64:%d, aid:%d", Long.valueOf(remindInfoGroup.KGD.MQh), Integer.valueOf(remindInfoGroup.KGD.MQc));
                        }
                        JE.setRemindInfoGroup(remindInfoGroup);
                        JE.setLocalVisible();
                        aj.faR().replace(JE);
                        SnsInfo convertToSnsInfo = JE.convertToSnsInfo();
                        if (com.tencent.mm.plugin.sns.ad.timeline.b.a.n(convertToSnsInfo)) {
                            z2 = true;
                            aj.faM().G(convertToSnsInfo);
                        }
                    }
                    a(dsVar.KHG.MYH.Id, aDInfo);
                    try {
                        String Jb2 = r.Jb(dsVar.KHG.MYH.Id);
                        if (!d.a(aDInfo, Jb2)) {
                            d.a(Jb2, aDInfo);
                        }
                    } catch (Throwable th) {
                        Log.e("MicroMsg.AdSnsInfoStorageLogic", th.toString());
                    }
                }
                z3 = z2;
                i3++;
            }
            if (z2) {
                Log.i("MicroMsg.AdSnsInfoStorageLogic", "the on line video preload start in AdSnsInfoStorageLogic ");
                aj.faM().fbO();
            }
            try {
                sb.append("], objList[");
                for (int i5 = 0; i5 < list2.size(); i5++) {
                    if (list2.size() > 0) {
                        sb.append(r.Jb(list2.get(i5).Id)).append("|").append(list2.get(i5).Username).append(",");
                    } else {
                        sb.append(r.Jb(list2.get(i5).Id)).append(",");
                    }
                }
                sb.append("], isFp:").append(z).append(", pullType:").append(i2);
                Log.i("MicroMsg.AdSnsInfoStorageLogic", "insert ad, " + sb.toString());
                AppMethodBeat.o(202714);
            } catch (Exception e3) {
                Log.e("MicroMsg.AdSnsInfoStorageLogic", "log exp=" + e3.toString());
                AppMethodBeat.o(202714);
            }
        }
    }

    private static void a(long j2, ADInfo aDInfo) {
        AppMethodBeat.i(95396);
        if (!aDInfo.adInfoSyncBufferImm || Util.isNullOrNil(aDInfo.adInfoSyncBuffer)) {
            AppMethodBeat.o(95396);
            return;
        }
        m mVar = new m(j2, 1, aDInfo.adInfoSyncBuffer);
        g.aAi();
        g.aAg().hqi.a(mVar, 0);
        AppMethodBeat.o(95396);
    }

    public static void bo(LinkedList<dkg> linkedList) {
        AppMethodBeat.i(95397);
        if (linkedList != null && !linkedList.isEmpty()) {
            LinkedList<ds> bn = bn(linkedList);
            Log.i("MicroMsg.AdSnsInfoStorageLogic", "convert " + bn.size() + " recObj to AdvertiseObj");
            j.d(bn, true);
        }
        AppMethodBeat.o(95397);
    }

    private static int b(SnsObject snsObject) {
        AppMethodBeat.i(95402);
        SnsInfo JJ = aj.faO().JJ(snsObject.Id);
        if (JJ == null) {
            int i2 = snsObject.CreateTime;
            AppMethodBeat.o(95402);
            return i2;
        }
        int i3 = JJ.field_createTime;
        AppMethodBeat.o(95402);
        return i3;
    }

    public static boolean a(long j2, dzj dzj, int i2, int i3, int i4, boolean z) {
        int i5;
        int i6;
        AppMethodBeat.i(95403);
        if (dzj != null) {
            dzi dzi = dzj.MZb;
            if (!(dzi.oUv == 7 || dzi.oUv == 8 || dzi.oUv == 16)) {
                AppMethodBeat.o(95403);
                return false;
            }
        }
        String aTY = com.tencent.mm.model.z.aTY();
        if (dzj == null || dzj.MZc == null || dzj.MZc.MKC == null || !dzj.MZc.MKC.equals(aTY)) {
            AdSnsInfo JE = aj.faR().JE(j2);
            if (JE == null) {
                Log.i("MicroMsg.AdSnsInfoStorageLogic", "AdSnsInfo of %s is not exist!", Long.valueOf(j2));
                AppMethodBeat.o(95403);
                return false;
            }
            try {
                SnsObject snsObject = (SnsObject) new SnsObject().parseFrom(JE.field_attrBuf);
                snsObject.Id = j2;
                int i7 = JE.field_firstControlTime;
                dzi dzi2 = dzj.MZb;
                if (dzi2.oUv == 7) {
                    if (i3 > 0 && i7 + i3 < dzi2.CreateTime) {
                        if (z) {
                            if (aj.faO().aQl(JE.getSnsId()) != null) {
                                ADInfo adInfo = JE.getAdInfo();
                                if (adInfo != null) {
                                    com.tencent.mm.plugin.sns.b.d dVar = (com.tencent.mm.plugin.sns.b.d) g.af(com.tencent.mm.plugin.sns.b.d.class);
                                    int source = JE.getSource();
                                    Object[] objArr = new Object[7];
                                    objArr[0] = Long.valueOf(y.aOa(JE.getSnsId()));
                                    objArr[1] = adInfo.viewId;
                                    objArr[2] = 2;
                                    objArr[3] = 1;
                                    objArr[4] = Integer.valueOf(snsObject.LikeUserList != null ? snsObject.LikeUserList.size() : 0);
                                    objArr[5] = Integer.valueOf(snsObject.CommentUserList != null ? snsObject.CommentUserList.size() : 0);
                                    objArr[6] = Integer.valueOf((int) (System.currentTimeMillis() / 1000));
                                    dVar.a(13182, source, objArr);
                                } else {
                                    Log.i("MicroMsg.AdSnsInfoStorageLogic", "when report ad time limit,the adinfo is null!");
                                }
                            } else {
                                Log.i("MicroMsg.AdSnsInfoStorageLogic", "when report ad time limit,the snsInfo is null!");
                            }
                        }
                        Log.i("MicroMsg.AdSnsInfoStorageLogic", "snsid " + j2 + " firstCreateTime " + i7 + " actionLikeTimeLimit: " + i3 + " curAction.createTime: " + dzi2.CreateTime + "is over the time limit!");
                        AppMethodBeat.o(95403);
                        return false;
                    }
                } else if ((dzi2.oUv == 8 || dzi2.oUv == 16) && i4 > 0 && i7 + i4 < dzi2.CreateTime) {
                    if (z) {
                        if (aj.faO().aQl(JE.getSnsId()) != null) {
                            ADInfo adInfo2 = JE.getAdInfo();
                            if (adInfo2 != null) {
                                com.tencent.mm.plugin.sns.b.d dVar2 = (com.tencent.mm.plugin.sns.b.d) g.af(com.tencent.mm.plugin.sns.b.d.class);
                                int source2 = JE.getSource();
                                Object[] objArr2 = new Object[7];
                                objArr2[0] = Long.valueOf(y.aOa(JE.getSnsId()));
                                objArr2[1] = adInfo2.viewId;
                                objArr2[2] = 2;
                                objArr2[3] = 2;
                                objArr2[4] = Integer.valueOf(snsObject.LikeUserList != null ? snsObject.LikeUserList.size() : 0);
                                objArr2[5] = Integer.valueOf(snsObject.CommentUserList != null ? snsObject.CommentUserList.size() : 0);
                                objArr2[6] = Integer.valueOf((int) (System.currentTimeMillis() / 1000));
                                dVar2.a(13182, source2, objArr2);
                            } else {
                                Log.i("MicroMsg.AdSnsInfoStorageLogic", "when report ad time limit,the adinfo is null!");
                            }
                        } else {
                            Log.i("MicroMsg.AdSnsInfoStorageLogic", "when report ad time limit,the snsInfo is null!");
                        }
                    }
                    Log.i("MicroMsg.AdSnsInfoStorageLogic", "snsid " + j2 + " firstCreateTime " + i7 + " actionCommentTimeLimit: " + i4 + " curAction.createTime: " + dzi2.CreateTime + "is over the time limit!");
                    AppMethodBeat.o(95403);
                    return false;
                }
                int i8 = 0;
                Iterator<dzo> it = snsObject.LikeUserList.iterator();
                while (it.hasNext()) {
                    dzo next = it.next();
                    if (next.CreateTime <= i7 || !(next == null || next.Username == null || !next.Username.equals(aTY))) {
                        i6 = i8;
                    } else {
                        i6 = i8 + 1;
                    }
                    i8 = i6;
                }
                int i9 = i8 + 0;
                int i10 = 0;
                Iterator<dzo> it2 = snsObject.CommentUserList.iterator();
                while (it2.hasNext()) {
                    dzo next2 = it2.next();
                    if (next2.CreateTime <= i7 || !(next2 == null || next2.Username == null || !next2.Username.equals(aTY))) {
                        i5 = i10;
                    } else {
                        i5 = i10 + 1;
                    }
                    i10 = i5;
                }
                int i11 = i9 + i10;
                Log.i("MicroMsg.AdSnsInfoStorageLogic", "totalsize " + i11 + " firstCreateTime " + i7 + " actionLimit: " + i2 + " actionLikeTimeLimit: " + i3 + " actionCommentTimeLimit: " + i4);
                if (i11 >= i2) {
                    if (z) {
                        SnsInfo aQl = aj.faO().aQl(JE.getSnsId());
                        if (aQl != null) {
                            ADInfo adInfo3 = aQl.getAdInfo();
                            if (adInfo3 != null) {
                                com.tencent.mm.plugin.sns.b.d dVar3 = (com.tencent.mm.plugin.sns.b.d) g.af(com.tencent.mm.plugin.sns.b.d.class);
                                int source3 = JE.getSource();
                                Object[] objArr3 = new Object[7];
                                objArr3[0] = Long.valueOf(y.aOa(JE.getSnsId()));
                                objArr3[1] = adInfo3.viewId;
                                objArr3[2] = 1;
                                objArr3[3] = 2;
                                objArr3[4] = Integer.valueOf(snsObject.LikeUserList != null ? snsObject.LikeUserList.size() : 0);
                                objArr3[5] = Integer.valueOf(snsObject.CommentUserList != null ? snsObject.CommentUserList.size() : 0);
                                objArr3[6] = Integer.valueOf((int) (System.currentTimeMillis() / 1000));
                                dVar3.a(13182, source3, objArr3);
                            } else {
                                Log.i("MicroMsg.AdSnsInfoStorageLogic", "when report ad time limit,the adinfo is null!");
                            }
                        } else {
                            Log.i("MicroMsg.AdSnsInfoStorageLogic", "when report ad time limit,the snsInfo is null!");
                        }
                    }
                    AppMethodBeat.o(95403);
                    return false;
                }
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.AdSnsInfoStorageLogic", e2, "", new Object[0]);
            }
            AppMethodBeat.o(95403);
            return true;
        }
        AppMethodBeat.o(95403);
        return true;
    }

    public static boolean a(long j2, dzj dzj) {
        AppMethodBeat.i(95404);
        dzi dzi = dzj.MZb;
        if (dzi.oUv == 7 || dzi.oUv == 8 || dzi.oUv == 16) {
            AdSnsInfo JE = aj.faR().JE(j2);
            if (JE == null) {
                Log.i("MicroMsg.AdSnsInfoStorageLogic", "pass the action because the snsinfo is null ".concat(String.valueOf(j2)));
                AppMethodBeat.o(95404);
                return false;
            }
            try {
                SnsObject snsObject = (SnsObject) new SnsObject().parseFrom(JE.field_attrBuf);
                snsObject.Id = j2;
                if (dzi.oUv == 7) {
                    Iterator<dzo> it = snsObject.LikeUserList.iterator();
                    while (it.hasNext()) {
                        dzo next = it.next();
                        if (next.CreateTime == dzi.CreateTime && next.Username.equals(dzi.MKC)) {
                            Log.i("MicroMsg.AdSnsInfoStorageLogic", "like create time " + next.CreateTime + " ");
                            AppMethodBeat.o(95404);
                            return false;
                        }
                    }
                    snsObject.LikeUserList.add(ag.b(dzj));
                } else if (dzi.oUv == 8 || dzi.oUv == 16) {
                    Iterator<dzo> it2 = snsObject.CommentUserList.iterator();
                    while (it2.hasNext()) {
                        dzo next2 = it2.next();
                        if (next2.CreateTime == dzi.CreateTime && next2.Username.equals(dzi.MKC)) {
                            Log.i("MicroMsg.AdSnsInfoStorageLogic", "like create time " + next2.CreateTime + " ");
                            AppMethodBeat.o(95404);
                            return false;
                        }
                    }
                    snsObject.CommentUserList.add(ag.b(dzj));
                }
                JE.setAttrBuf(snsObject.toByteArray());
                aj.faR().a(snsObject.Id, JE);
            } catch (Exception e2) {
                Log.e("MicroMsg.AdSnsInfoStorageLogic", "e " + e2.getMessage());
                Log.printErrStackTrace("MicroMsg.AdSnsInfoStorageLogic", e2, "", new Object[0]);
            }
            AppMethodBeat.o(95404);
            return true;
        }
        AppMethodBeat.o(95404);
        return false;
    }

    private static boolean Jd(long j2) {
        AppMethodBeat.i(95405);
        eZV();
        if (DGz.get(Long.valueOf(j2)) != null) {
            AppMethodBeat.o(95405);
            return true;
        }
        AppMethodBeat.o(95405);
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0041 A[SYNTHETIC, Splitter:B:22:0x0041] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0055 A[SYNTHETIC, Splitter:B:29:0x0055] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0069 A[SYNTHETIC, Splitter:B:36:0x0069] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0073 A[SYNTHETIC, Splitter:B:42:0x0073] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void eZV() {
        /*
        // Method dump skipped, instructions count: 134
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.model.a.eZV():void");
    }

    private static void eZW() {
        AppMethodBeat.i(95407);
        DGz = new LinkedHashMap<Long, Integer>(((int) Math.ceil(666.6666870117188d)) + 1) {
            /* class com.tencent.mm.plugin.sns.model.a.AnonymousClass2 */

            /* access modifiers changed from: protected */
            @Override // java.util.LinkedHashMap
            public final boolean removeEldestEntry(Map.Entry<Long, Integer> entry) {
                AppMethodBeat.i(202712);
                if (size() > 500 && entry != null) {
                    Log.i("MicroMsg.AdSnsInfoStorageLogic", "remove eldest ad snsId " + entry.getKey());
                }
                if (size() > 500) {
                    AppMethodBeat.o(202712);
                    return true;
                }
                AppMethodBeat.o(202712);
                return false;
            }
        };
        AppMethodBeat.o(95407);
    }

    private static void Je(long j2) {
        AppMethodBeat.i(95408);
        if (j2 == 0) {
            AppMethodBeat.o(95408);
            return;
        }
        if (DGz == null) {
            eZV();
        }
        DGz.put(Long.valueOf(j2), 0);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(DGz);
            objectOutputStream.flush();
            com.tencent.mm.pluginsdk.j.a.d.a.y(DGy, byteArrayOutputStream.toByteArray());
            try {
                byteArrayOutputStream.close();
                AppMethodBeat.o(95408);
            } catch (IOException e2) {
                AppMethodBeat.o(95408);
            }
        } catch (IOException e3) {
            Log.e("MicroMsg.AdSnsInfoStorageLogic", Util.stackTraceToString(e3));
            try {
                byteArrayOutputStream.close();
                AppMethodBeat.o(95408);
            } catch (IOException e4) {
                AppMethodBeat.o(95408);
            }
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (IOException e5) {
            }
            AppMethodBeat.o(95408);
            throw th;
        }
    }

    private static String a(String str, SKBuiltinBuffer_t sKBuiltinBuffer_t) {
        String str2;
        Exception e2;
        String str3;
        String group;
        AppMethodBeat.i(95409);
        if (sKBuiltinBuffer_t == null || str == null) {
            Log.i("MicroMsg.AdSnsInfoStorageLogic", "update with empty dynamic data");
            AppMethodBeat.o(95409);
            return str;
        }
        try {
            ad adVar = new ad();
            adVar.parseFrom(sKBuiltinBuffer_t.getBufferToBytes());
            if (adVar.KCs != null) {
                String str4 = "";
                Iterator<dzg> it = adVar.KCs.iterator();
                str2 = str;
                while (it.hasNext()) {
                    try {
                        dzg next = it.next();
                        if (next.key != null) {
                            String format = String.format("<(([a-zA-Z0-9\\-_]+)([^>]+)dynamicKey=[\"']%s[\"']([^>]*))", next.key);
                            Matcher matcher = Pattern.compile(format).matcher(str2);
                            if (matcher.find() && (group = matcher.group(2)) != null && group.length() > 0) {
                                str2 = str2.replaceAll(format + String.format("((>[\\s\\S]*</%s>)|(/([^>]*)>))", group), String.format("<$1>%s</%s>", next.value, group));
                                str3 = str4 + next.key + ":" + next.value + ";";
                                str4 = str3;
                            }
                        }
                        str3 = str4;
                        str4 = str3;
                    } catch (Exception e3) {
                        e2 = e3;
                        Log.printErrStackTrace("MicroMsg.AdSnsInfoStorageLogic", e2, "replace error occurs!", new Object[0]);
                        AppMethodBeat.o(95409);
                        return str2;
                    }
                }
                Log.i("MicroMsg.AdSnsInfoStorageLogic", "DynamicData is: [%s]", str4);
                if (XmlParser.parseXml(str, "ADInfo", null) == null) {
                    Log.w("MicroMsg.AdSnsInfoStorageLogic", "DynamicData xml format error!");
                    AppMethodBeat.o(95409);
                    return str;
                }
            } else {
                str2 = str;
            }
        } catch (Exception e4) {
            e2 = e4;
            str2 = str;
            Log.printErrStackTrace("MicroMsg.AdSnsInfoStorageLogic", e2, "replace error occurs!", new Object[0]);
            AppMethodBeat.o(95409);
            return str2;
        }
        AppMethodBeat.o(95409);
        return str2;
    }
}
