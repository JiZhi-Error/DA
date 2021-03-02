package com.tencent.mm.plugin.aa.model;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.av.a.a;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.q;
import com.tencent.mm.b.g;
import com.tencent.mm.g.b.a.es;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.aa.b;
import com.tencent.mm.plugin.aa.model.a.c;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.protocal.protobuf.ab;
import com.tencent.mm.protocal.protobuf.w;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.ao;
import com.tencent.smtt.sdk.TbsListener;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class i {
    private static synchronized void bV(String str, String str2) {
        k.b HD;
        long j2;
        boolean z = true;
        synchronized (i.class) {
            AppMethodBeat.i(63338);
            if (!Util.isNullOrNil(str) && (HD = k.b.HD(str)) != null && !Util.isNullOrNil(HD.iyz)) {
                c SD = b.blZ().SD(HD.iyz);
                Object[] objArr = new Object[5];
                objArr[0] = HD.iyz;
                objArr[1] = str2;
                objArr[2] = SD;
                if (SD == null || !SD.field_insertmsg) {
                    z = false;
                }
                objArr[3] = Boolean.valueOf(z);
                if (SD != null) {
                    j2 = SD.field_localMsgId;
                } else {
                    j2 = 0;
                }
                objArr[4] = Long.valueOf(j2);
                Log.i("MicroMsg.AAUtil", "insertAAMsg, billNo: %s, chatroom: %s, oldRecord: %s, insertMsg: %s, localMsgId: %s", objArr);
                if (SD == null) {
                    Log.e("MicroMsg.AAUtil", "insertAAMsg, record is null!!");
                    AppMethodBeat.o(63338);
                } else if (!SD.field_insertmsg || SD.field_localMsgId <= 0) {
                    ca caVar = new ca();
                    caVar.setCreateTime(bp.Kw(str2));
                    caVar.setType(436207665);
                    caVar.setContent(z.aTY() + ":\n" + str);
                    String messageDigest = g.getMessageDigest(new StringBuilder().append(Util.nowMilliSecond()).toString().getBytes());
                    String fullPath = q.bcR().getFullPath(messageDigest);
                    q.bcR();
                    String EX = com.tencent.mm.av.i.EX(messageDigest);
                    a bcV = q.bcV();
                    String str3 = HD.iyj;
                    c.a aVar = new c.a();
                    aVar.fullPath = fullPath;
                    aVar.jbf = true;
                    bcV.a(str3, (ImageView) null, aVar.bdv());
                    caVar.Cz(EX);
                    caVar.nv(1);
                    caVar.Cy(str2);
                    caVar.setStatus(3);
                    caVar.setMsgId(bp.x(caVar));
                    Log.i("MicroMsg.AAUtil", "finish insert aa msg");
                    a(HD.iyz, true, caVar.field_msgId);
                    k kVar = new k();
                    HD.a(kVar);
                    kVar.field_msgId = caVar.field_msgId;
                    com.tencent.mm.plugin.r.a.eAT().insert(kVar);
                }
            }
            AppMethodBeat.o(63338);
        }
    }

    public static synchronized void a(String str, boolean z, long j2) {
        synchronized (i.class) {
            AppMethodBeat.i(63339);
            if (!Util.isNullOrNil(str)) {
                Log.i("MicroMsg.AAUtil", "insertOrUpdateAARecord, billNo: %s, insertMsg: %s", str, Boolean.valueOf(z));
                com.tencent.mm.plugin.aa.model.a.c cVar = new com.tencent.mm.plugin.aa.model.a.c();
                cVar.field_billNo = str;
                cVar.field_insertmsg = z;
                cVar.field_localMsgId = j2;
                b.blZ().b(cVar);
            }
            AppMethodBeat.o(63339);
        }
    }

    public static synchronized void bW(String str, String str2) {
        boolean z;
        long j2;
        boolean z2 = true;
        synchronized (i.class) {
            AppMethodBeat.i(63340);
            if (!Util.isNullOrNil(str)) {
                k.b HD = k.b.HD(str);
                Object[] objArr = new Object[2];
                objArr[0] = HD != null ? HD.iyz : "";
                objArr[1] = str.trim().replace(" ", "");
                Log.d("MicroMsg.AAUtil", "checkIfInsertAAMsg, billNo: %s, appMsgContent: %s", objArr);
                if (HD != null && !Util.isNullOrNil(HD.iyz)) {
                    String str3 = HD.iyz;
                    com.tencent.mm.plugin.aa.model.a.c SD = b.blZ().SD(str3);
                    Object[] objArr2 = new Object[5];
                    if (SD == null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    objArr2[0] = Boolean.valueOf(z);
                    objArr2[1] = str3;
                    if (SD == null || !SD.field_insertmsg) {
                        z2 = false;
                    }
                    objArr2[2] = Boolean.valueOf(z2);
                    objArr2[3] = str2;
                    if (SD != null) {
                        j2 = SD.field_localMsgId;
                    } else {
                        j2 = 0;
                    }
                    objArr2[4] = Long.valueOf(j2);
                    Log.i("MicroMsg.AAUtil", "checkIfInsertAAMsg, record==null: %s, billNo: %s, insertMsg: %s, chatroom: %s, localMsgId: %s", objArr2);
                    if (SD == null) {
                        Log.e("MicroMsg.AAUtil", "checkIfInsertAAMsg, record is null, ignore");
                        a(str3, false, 0);
                    }
                    if (SD != null && SD.field_insertmsg && SD.field_localMsgId > 0 && ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().Hb(SD.field_localMsgId).field_msgId <= 0) {
                        Log.i("MicroMsg.AAUtil", "checkIfInsertAAMsg, the oldMsgInfo has deleted, ignore this");
                        b.blZ().a(SD, new String[0]);
                        AppMethodBeat.o(63340);
                    } else if (SD == null || !SD.field_insertmsg || SD.field_localMsgId <= 0) {
                        Log.i("MicroMsg.AAUtil", "checkIfInsertAAMsg, insert new aa msg");
                        bV(str, str2);
                        AppMethodBeat.o(63340);
                    } else {
                        Log.i("MicroMsg.AAUtil", "checkIfInsertAAMsg, update aa msg");
                        h(SD.field_localMsgId, str);
                    }
                }
            }
            AppMethodBeat.o(63340);
        }
    }

    public static synchronized void u(String str, String str2, String str3) {
        synchronized (i.class) {
            AppMethodBeat.i(63341);
            com.tencent.mm.plugin.aa.model.a.c SD = b.blZ().SD(str);
            Log.i("MicroMsg.AAUtil", "setAARecordAfterLaunchAA, billNo: %s, chatroom: %s, msgContent==null:%s, oldRecord: %s", str, str2, Boolean.valueOf(Util.isNullOrNil(str3)), SD);
            if (SD == null) {
                a(str, false, 0);
            }
            bW(str3, str2);
            AppMethodBeat.o(63341);
        }
    }

    public static w aQ(List<w> list) {
        AppMethodBeat.i(212941);
        for (w wVar : list) {
            if (wVar.KBN.equals(z.aTY())) {
                AppMethodBeat.o(212941);
                return wVar;
            }
        }
        Log.i("MicroMsg.AAUtil", "not contains self");
        AppMethodBeat.o(212941);
        return null;
    }

    public static void a(Context context, String str, boolean z, String str2, String str3) {
        AppMethodBeat.i(212942);
        Log.d("MicroMsg.AAUtil", "startAAPay, reqKey: %s, isFromChatting: %s", str, Boolean.valueOf(z));
        PayInfo payInfo = new PayInfo();
        payInfo.dDL = str;
        payInfo.dVv = 42;
        if (z) {
            payInfo.channel = 14;
        } else {
            payInfo.channel = 1;
        }
        Bundle bundle = new Bundle();
        bundle.putString("extinfo_key_1", str3);
        payInfo.iqp = bundle;
        com.tencent.mm.wallet_core.b.hgC();
        if (com.tencent.mm.wallet_core.b.b(b.a.clicfg_kinda_open, true)) {
            payInfo.iqp.putString("extinfo_key_2", str2);
            ((com.tencent.mm.pluginsdk.wallet.a) com.tencent.mm.kernel.g.af(com.tencent.mm.pluginsdk.wallet.a.class)).startSNSPay(context, payInfo);
            AppMethodBeat.o(212942);
            return;
        }
        f.a(context, false, "", payInfo, str2, new Intent(), TbsListener.ErrorCode.DECOUPLE_INSTLL_SUCCESS);
        AppMethodBeat.o(212942);
    }

    public static synchronized void c(String str, String str2, String str3, String str4, String str5) {
        String str6;
        String replace;
        Object obj;
        boolean z = true;
        synchronized (i.class) {
            AppMethodBeat.i(63342);
            Log.d("MicroMsg.AAUtil", "insertPayMsgAfterPaySucc, launcherUsername: %s, billNo: %s, payMsgId: %s", str, str3, str4);
            if (!Util.isNullOrNil(str) && !Util.isNullOrNil(str3) && !Util.isNullOrNil(str4)) {
                com.tencent.mm.plugin.aa.model.a.a SC = com.tencent.mm.plugin.aa.b.bma().SC(str4);
                Object[] objArr = new Object[5];
                objArr[0] = str;
                objArr[1] = str2;
                objArr[2] = str4;
                objArr[3] = SC;
                if (SC == null || !SC.field_insertmsg) {
                    z = false;
                }
                objArr[4] = Boolean.valueOf(z);
                Log.i("MicroMsg.AAUtil", "insertPayMsgAfterPaySucc, launcherUsername: %s, chatroom: %s, payMsgId: %s, record: %s, insertmsg: %s", objArr);
                if (SC == null || !SC.field_insertmsg) {
                    String str7 = "weixin://weixinnewaa/opendetail?billno=" + str3 + "&launcherusername=" + str;
                    if (Util.isNullOrNil(str5)) {
                        Log.i("MicroMsg.AAUtil", "empty msgxml, insert local msgcontent");
                        if (ao.isDarkMode()) {
                            obj = "#7D90A9";
                        } else {
                            obj = "#576B95";
                        }
                        if (str.equals(z.aTY())) {
                            replace = MMApplicationContext.getContext().getString(R.string.fk2, str7, obj);
                        } else {
                            replace = MMApplicationContext.getContext().getString(R.string.fk3, ((com.tencent.mm.plugin.messenger.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(str, str2), obj, str7);
                        }
                    } else {
                        if (ao.isDarkMode()) {
                            str6 = "#7D90A9";
                        } else {
                            str6 = "#576B95";
                        }
                        replace = str5.replace("\"#037AFF\"", "\"" + str6 + "\"");
                        Log.d("MicroMsg.AAUtil", "insert msgxml: %s", replace);
                    }
                    a(replace, str2, SC, str4, false);
                }
            }
            AppMethodBeat.o(63342);
        }
    }

    public static synchronized void v(String str, String str2, String str3) {
        String str4;
        synchronized (i.class) {
            AppMethodBeat.i(63343);
            try {
                if (!Util.isNullOrNil(str) && !Util.isNullOrNil(str2) && !Util.isNullOrNil(str3)) {
                    Log.i("MicroMsg.AAUtil", "checkIfInsertPaySysMsg, chatroom: %s, payMsgId: %s", str2, str3);
                    if (ao.isDarkMode()) {
                        str4 = "#7D90A9";
                    } else {
                        str4 = "#576B95";
                    }
                    String replace = str.replace("\"#037AFF\"", "\"" + str4 + "\"");
                    com.tencent.mm.plugin.aa.model.a.a SC = com.tencent.mm.plugin.aa.b.bma().SC(str3);
                    if (SC == null || !SC.field_insertmsg) {
                        Log.i("MicroMsg.AAUtil", "checkIfInsertPaySysMsg, insert new msg");
                        a(replace, str2, SC, str3, false);
                        AppMethodBeat.o(63343);
                    } else {
                        ca Hb = ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().Hb(SC.field_msgId);
                        Log.i("MicroMsg.AAUtil", "checkIfInsertPaySysMsg, update old one, msgId: %s, dbMsginfo.id: %s", Long.valueOf(SC.field_msgId), Long.valueOf(Hb.field_msgId));
                        Hb.setContent(replace);
                        ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().a(SC.field_msgId, Hb);
                    }
                }
                AppMethodBeat.o(63343);
            } catch (Exception e2) {
                Log.e("MicroMsg.AAUtil", "checkIfInsertPaySysMsg error: %s", e2.getMessage());
                AppMethodBeat.o(63343);
            }
        }
    }

    public static synchronized void a(String str, String str2, com.tencent.mm.plugin.aa.model.a.a aVar, String str3, boolean z) {
        synchronized (i.class) {
            AppMethodBeat.i(63344);
            ca caVar = new ca();
            caVar.nv(0);
            caVar.Cy(str2);
            caVar.setStatus(3);
            caVar.setContent(str);
            caVar.setCreateTime(bp.C(str2, System.currentTimeMillis() / 1000));
            caVar.setType(10000);
            if (z) {
                caVar.setFlag(caVar.field_flag | 8);
            }
            long aC = ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().aC(caVar);
            Log.i("MicroMsg.AAUtil", "insertPaySysMsg, inserted msgId: %s", Long.valueOf(aC));
            if (aVar == null) {
                aVar = new com.tencent.mm.plugin.aa.model.a.a();
            }
            if (aC > 0) {
                aVar.field_payMsgId = str3;
                aVar.field_chatroom = str2;
                aVar.field_insertmsg = true;
                aVar.field_msgId = aC;
                com.tencent.mm.plugin.aa.b.bma().replace(aVar);
            }
            AppMethodBeat.o(63344);
        }
    }

    public static synchronized void h(long j2, String str) {
        synchronized (i.class) {
            AppMethodBeat.i(63345);
            if (j2 <= 0 || Util.isNullOrNil(str)) {
                Log.e("MicroMsg.AAUtil", "updateAARecordMsgAfterReceive, msgContent is null or msgId invalid, msgId: %s, %s", Long.valueOf(j2), Boolean.valueOf(Util.isNullOrNil(str)));
                AppMethodBeat.o(63345);
            } else {
                k.b HD = k.b.HD(str);
                if (HD == null || Util.isNullOrNil(HD.iyz)) {
                    Log.e("MicroMsg.AAUtil", "updateAARecordMsgAfterReceive, parse app msg failed, msgId: %s", Long.valueOf(j2));
                    AppMethodBeat.o(63345);
                } else {
                    Log.i("MicroMsg.AAUtil", "updateAARecordMsgAfterReceive, msgId: %s, billNo: %s", Long.valueOf(j2), HD.iyz);
                    com.tencent.mm.plugin.aa.model.a.c SD = com.tencent.mm.plugin.aa.b.blZ().SD(HD.iyz);
                    if (SD != null) {
                        long j3 = SD.field_localMsgId;
                        ca Hb = ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().Hb(j3);
                        if (Hb.field_msgId > 0) {
                            Hb.setContent(bp.Ks(Hb.field_content) + ":\n" + str);
                            ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().a(j3, Hb);
                            Log.i("MicroMsg.AAUtil", "updateAARecordMsgAfterReceive, update success, oldMsgId: %s, billNo: %s", Long.valueOf(j3), SD.field_billNo);
                            AppMethodBeat.o(63345);
                        } else {
                            Log.e("MicroMsg.AAUtil", "updateAARecordMsgAfterReceive, cannot find old msg, insert new one, billNo: %s, oldMsgId: %s, newMsgId: %s, needUpdateInfo.msgId: %s", SD.field_billNo, Long.valueOf(SD.field_localMsgId), Long.valueOf(j2), Long.valueOf(Hb.field_msgId));
                            AppMethodBeat.o(63345);
                        }
                    } else {
                        com.tencent.mm.plugin.aa.model.a.c cVar = new com.tencent.mm.plugin.aa.model.a.c();
                        cVar.field_localMsgId = j2;
                        cVar.field_billNo = HD.iyz;
                        cVar.field_insertmsg = true;
                        com.tencent.mm.plugin.aa.b.blZ().a(cVar);
                        Log.i("MicroMsg.AAUtil", "updateAARecordMsgAfterReceive, insert new aa record, msgId: %s, billNo: %s", Long.valueOf(j2), HD.iyz);
                        AppMethodBeat.o(63345);
                    }
                }
            }
        }
    }

    public static void i(long j2, String str) {
        AppMethodBeat.i(63346);
        Log.i("MicroMsg.AAUtil", "do update sys msg, %s, %s", Long.valueOf(j2), str);
        ca Hb = ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().Hb(j2);
        String Sz = Sz(str);
        if (!Util.isNullOrNil(Sz)) {
            Hb.setContent(Sz);
        }
        ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().a(j2, Hb);
        AppMethodBeat.o(63346);
    }

    public static double o(double d2) {
        AppMethodBeat.i(63347);
        double a2 = a(String.valueOf(d2), "100", 2, 4);
        AppMethodBeat.o(63347);
        return a2;
    }

    public static boolean a(Activity activity, ab abVar) {
        AppMethodBeat.i(63348);
        if (abVar.KCl == 1) {
            Log.i("MicroMsg.AAUtil", "need realname verify");
            Bundle bundle = new Bundle();
            bundle.putString("realname_verify_process_jump_activity", ".ui.LaunchAAUI");
            bundle.putString("realname_verify_process_jump_plugin", "aa");
            boolean a2 = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(activity, bundle, null, 0);
            AppMethodBeat.o(63348);
            return a2;
        } else if (abVar.KCl == 2) {
            Log.i("MicroMsg.AAUtil", "need upload credit");
            boolean a3 = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(activity, abVar.yXJ, abVar.yXK, abVar.lHA, abVar.lHB, false, (DialogInterface.OnClickListener) null);
            AppMethodBeat.o(63348);
            return a3;
        } else {
            Log.i("MicroMsg.AAUtil", "realnameGuideFlag =  " + abVar.KCl);
            AppMethodBeat.o(63348);
            return false;
        }
    }

    private static String Sz(String str) {
        UnsupportedEncodingException e2;
        String str2;
        AppMethodBeat.i(63349);
        Map<String, String> parseXml = XmlParser.parseXml(str, "sysmsg", null);
        if (parseXml == null) {
            AppMethodBeat.o(63349);
            return "";
        }
        String str3 = parseXml.get(".sysmsg.paymsg.appmsgcontent");
        if (Util.isNullOrNil(str3)) {
            Log.e("MicroMsg.AAUtil", "empty appmsgcontent!");
            AppMethodBeat.o(63349);
            return "";
        }
        try {
            str2 = URLDecoder.decode(str3, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
            try {
                Log.d("MicroMsg.AAUtil", "msgContent: %s", str2);
            } catch (UnsupportedEncodingException e3) {
                e2 = e3;
                Log.e("MicroMsg.AAUtil", e2.getMessage());
                AppMethodBeat.o(63349);
                return str2;
            }
        } catch (UnsupportedEncodingException e4) {
            e2 = e4;
            str2 = "";
            Log.e("MicroMsg.AAUtil", e2.getMessage());
            AppMethodBeat.o(63349);
            return str2;
        }
        AppMethodBeat.o(63349);
        return str2;
    }

    public static double a(String str, String str2, int i2, int i3) {
        double d2 = 0.0d;
        AppMethodBeat.i(63350);
        try {
            d2 = new BigDecimal(Util.getDouble(str.trim(), 0.0d) == 0.0d ? AppEventsConstants.EVENT_PARAM_VALUE_NO : str.trim()).divide(new BigDecimal(str2.trim()), i2, i3).doubleValue();
            AppMethodBeat.o(63350);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.AAUtil", e2, "", new Object[0]);
            AppMethodBeat.o(63350);
        }
        return d2;
    }

    public static long bX(String str, String str2) {
        AppMethodBeat.i(63351);
        try {
            double d2 = Util.getDouble(str, 0.0d);
            double d3 = Util.getDouble(str2, 0.0d);
            if (d2 == 0.0d) {
                str = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            }
            BigDecimal bigDecimal = new BigDecimal(str);
            if (d3 == 0.0d) {
                str2 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            }
            long longValue = bigDecimal.multiply(new BigDecimal(str2)).longValue();
            AppMethodBeat.o(63351);
            return longValue;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.AAUtil", e2, "", new Object[0]);
            AppMethodBeat.o(63351);
            return 0;
        }
    }

    public static List<String> SA(String str) {
        AppMethodBeat.i(63352);
        if (Util.isNullOrNil(str)) {
            Log.i("MicroMsg.AAUtil", "illegal chatroomName");
            ArrayList arrayList = new ArrayList();
            AppMethodBeat.o(63352);
            return arrayList;
        } else if (!com.tencent.mm.model.ab.Eq(str)) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(z.aTY());
            arrayList2.add(str);
            AppMethodBeat.o(63352);
            return arrayList2;
        } else {
            try {
                List<String> Kh = ((com.tencent.mm.plugin.chatroom.a.c) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kh(str);
                if (Kh == null) {
                    Kh = new ArrayList<>();
                }
                AppMethodBeat.o(63352);
                return Kh;
            } catch (Exception e2) {
                Log.e("MicroMsg.AAUtil", "getChatroomMemberList error! %s", e2.getMessage());
                ArrayList arrayList3 = new ArrayList();
                AppMethodBeat.o(63352);
                return arrayList3;
            }
        }
    }

    public static String bml() {
        AppMethodBeat.i(63353);
        com.tencent.mm.kernel.g.aAi();
        String nullAsNil = Util.nullAsNil((String) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_RECENT_LAUNCH_AA_GROUP_STRING_SYNC, (Object) null));
        AppMethodBeat.o(63353);
        return nullAsNil;
    }

    public static void SB(String str) {
        AppMethodBeat.i(63354);
        String bml = bml();
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(",");
        if (!Util.isNullOrNil(bml)) {
            String[] split = bml.split(",");
            int i2 = 1;
            for (String str2 : split) {
                if (!str2.equals(str) && i2 < 5) {
                    sb.append(str2);
                    sb.append(",");
                    i2++;
                }
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        Log.d("MicroMsg.AAUtil", "recent group: %s", sb.toString());
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_RECENT_LAUNCH_AA_GROUP_STRING_SYNC, sb.toString());
        AppMethodBeat.o(63354);
    }

    public static void uZ(int i2) {
        AppMethodBeat.i(63355);
        es esVar = new es();
        esVar.eEr = (long) i2;
        esVar.bfK();
        AppMethodBeat.o(63355);
    }
}
