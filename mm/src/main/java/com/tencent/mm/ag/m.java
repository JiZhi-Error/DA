package com.tencent.mm.ag;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.p;
import com.tencent.mm.al.k;
import com.tencent.mm.b.f;
import com.tencent.mm.b.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.q;
import com.tencent.mm.plugin.biz.a.a;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.amt;
import com.tencent.mm.protocal.protobuf.anq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.SemiXml;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.u;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;

public final class m {
    private static final f<Long, u> gAU = new h(50);
    private static final ConcurrentHashMap<Long, Integer> izR = new ConcurrentHashMap<>(50);

    public static boolean HF(String str) {
        AppMethodBeat.i(123938);
        if (str == null || !str.endsWith("@app")) {
            AppMethodBeat.o(123938);
            return false;
        }
        AppMethodBeat.o(123938);
        return true;
    }

    public static String HG(String str) {
        AppMethodBeat.i(123939);
        Map<String, String> parseXml = XmlParser.parseXml(str, "msg", null);
        if (parseXml == null) {
            Log.e("MicroMsg.AppMsgBizHelper", "getAppMsgDyeingTempTitle fail, values is null");
            AppMethodBeat.o(123939);
            return " ";
        }
        Util.getInt(parseXml.get(".msg.appmsg.mmreader.template_detail.template_show_type"), 0);
        Util.nullAs(parseXml.get(".msg.appmsg.ext_pay_info.pay_type"), "");
        String nullAsNil = Util.nullAsNil(parseXml.get(".msg.appmsg.title"));
        if (Util.isNullOrNil(nullAsNil)) {
            nullAsNil = parseXml.get(".msg.appmsg.mmreader.category.item.title");
        }
        if (Util.isNullOrNil(nullAsNil)) {
            nullAsNil = " ";
        }
        AppMethodBeat.o(123939);
        return nullAsNil;
    }

    public static String HH(String str) {
        AppMethodBeat.i(123940);
        Map<String, String> decode = SemiXml.decode(str);
        if (decode == null) {
            u uVar = new u();
            StringBuilder sb = new StringBuilder("");
            Iterator it = uVar.iAd.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                v vVar = (v) it.next();
                if (!Util.isNullOrNil(vVar.title)) {
                    sb.append(vVar.title);
                    break;
                }
            }
            String sb2 = sb.toString();
            AppMethodBeat.o(123940);
            return sb2;
        }
        String str2 = decode.get(".msg.appmsg.mmreader.category.item.title");
        if (str2 == null) {
            AppMethodBeat.o(123940);
            return "";
        }
        AppMethodBeat.o(123940);
        return str2;
    }

    static {
        AppMethodBeat.i(123952);
        AppMethodBeat.o(123952);
    }

    public static u a(long j2, String str) {
        u uVar;
        AppMethodBeat.i(123941);
        if (j2 <= 0 || (uVar = gAU.get(Long.valueOf(j2))) == null) {
            Map<String, String> decode = SemiXml.decode(str);
            if (decode == null) {
                u uVar2 = new u();
                AppMethodBeat.o(123941);
                return uVar2;
            }
            int i2 = Util.getInt(decode.get(".msg.appmsg.mmreader.category.$type"), 0);
            String nullAsNil = Util.nullAsNil(decode.get(".msg.appmsg.mmreader.name"));
            int i3 = Util.getInt(decode.get(".msg.appmsg.mmreader.forbid_forward"), 0);
            int i4 = Util.getInt(decode.get(".msg.appmsg.mmreader.category.$count"), 0);
            u uVar3 = new u();
            uVar3.type = i2;
            uVar3.name = nullAsNil;
            uVar3.fQR = decode.get(".msg.commenturl");
            uVar3.iAe = i3;
            int i5 = 0;
            while (i5 < i4) {
                v vVar = new v();
                String str2 = ".msg.appmsg.mmreader.category.item" + (i5 == 0 ? "" : String.valueOf(i5));
                vVar.title = decode.get(str2 + ".title");
                vVar.url = decode.get(str2 + ".url");
                vVar.iAm = decode.get(str2 + ".shorturl");
                vVar.iAn = decode.get(str2 + ".longurl");
                vVar.time = Util.getLong(decode.get(str2 + ".pub_time"), 0);
                vVar.iAp = decode.get(str2 + ".tweetid");
                vVar.iAq = decode.get(str2 + ".digest");
                vVar.type = Util.getInt(decode.get(str2 + ".itemshowtype"), 0);
                vVar.iAs = Util.getInt(decode.get(str2 + ".play_length"), 0);
                vVar.iAo = decode.get(str2 + ".cover");
                String str3 = decode.get(str2 + ".cover_235_1");
                String str4 = decode.get(str2 + ".cover_16_9");
                if ((vVar.type != 5 && !Util.isNullOrNil(str3)) || Util.isNullOrNil(vVar.iAo)) {
                    vVar.iAo = str3;
                }
                if (vVar.type == 5 && !Util.isNullOrNil(str4)) {
                    vVar.iAo = str4;
                }
                int i6 = 0;
                while (i6 < 100) {
                    String str5 = decode.get(str2 + ".pic_urls.pic_url" + (i6 == 0 ? "" : String.valueOf(i6)));
                    if (Util.isNullOrNil(str5)) {
                        break;
                    }
                    vVar.iAE.add(str5);
                    i6++;
                }
                if (vVar.iAE.size() == 0) {
                    vVar.iAE.add(vVar.iAo);
                }
                vVar.iAD = decode.get(str2 + ".cover_1_1");
                vVar.iAr = Util.getInt(decode.get(str2 + ".del_flag"), 0);
                vVar.iAt = decode.get(str2 + ".weapp_username");
                vVar.weappPath = decode.get(str2 + ".weapp_path");
                vVar.weappVersion = Util.getInt(decode.get(str2 + ".weapp_version"), 0);
                vVar.iAu = Util.getInt(decode.get(str2 + ".weapp_state"), 0);
                vVar.iAv = decode.get(str2 + ".weapp_appid");
                vVar.iAw = decode.get(str2 + ".weapp_image_url");
                vVar.iAx = decode.get(str2 + ".weapp_icon");
                vVar.iAy = decode.get(str2 + ".weapp_nickname");
                vVar.iAz = decode.get(str2 + ".play_url");
                vVar.iAA = decode.get(str2 + ".player");
                vVar.iAB = Util.getInt(decode.get(str2 + ".music_source"), 1);
                vVar.iAC = Util.getInt(decode.get(str2 + ".pic_num"), 1);
                vVar.videoWidth = Util.getInt(decode.get(str2 + ".video_width"), 0);
                vVar.videoHeight = Util.getInt(decode.get(str2 + ".video_height"), 0);
                vVar.iwf = Util.getInt(decode.get(str2 + ".is_pay_subscribe"), 0);
                vVar.iAH = Util.getLong(decode.get(str2 + ".comment_topic_id"), 0);
                vVar.vid = decode.get(str2 + ".vid");
                uVar3.iAd.add(vVar);
                i5++;
            }
            uVar3.iwz = k.E(decode);
            String nullAsNil2 = Util.nullAsNil(decode.get(".msg.fromusername"));
            if (!Util.isNullOrNil(nullAsNil2)) {
                String arI = ((l) g.af(l.class)).aSN().Kn(nullAsNil2).arI();
                uVar3.eag = nullAsNil2;
                uVar3.eah = arI;
            }
            if (j2 > 0) {
                gAU.x(Long.valueOf(j2), uVar3);
                izR.put(Long.valueOf(j2), Integer.valueOf(i4));
            }
            AppMethodBeat.o(123941);
            return uVar3;
        }
        AppMethodBeat.o(123941);
        return uVar;
    }

    public static int b(long j2, String str) {
        Integer num;
        AppMethodBeat.i(123942);
        if (j2 <= 0 || (num = izR.get(Long.valueOf(j2))) == null) {
            Map<String, String> decode = SemiXml.decode(str);
            if (decode == null) {
                AppMethodBeat.o(123942);
                return 0;
            }
            Integer valueOf = Integer.valueOf(Util.getInt(decode.get(".msg.appmsg.mmreader.category.$count"), 0));
            if (j2 > 0) {
                izR.put(Long.valueOf(j2), valueOf);
            }
            int intValue = valueOf.intValue();
            AppMethodBeat.o(123942);
            return intValue;
        }
        int intValue2 = num.intValue();
        AppMethodBeat.o(123942);
        return intValue2;
    }

    public static String a(v vVar) {
        AppMethodBeat.i(123943);
        if (vVar.type == 5) {
            if (Util.isNullOrNil(vVar.iAo)) {
                String str = vVar.iAD;
                AppMethodBeat.o(123943);
                return str;
            }
            String str2 = vVar.iAo;
            AppMethodBeat.o(123943);
            return str2;
        } else if (Util.isNullOrNil(vVar.iAD)) {
            String str3 = vVar.iAo;
            AppMethodBeat.o(123943);
            return str3;
        } else {
            String str4 = vVar.iAD;
            AppMethodBeat.o(123943);
            return str4;
        }
    }

    public static amt a(ca caVar, anq anq) {
        AppMethodBeat.i(123944);
        if (caVar == null) {
            AppMethodBeat.o(123944);
            return null;
        } else if (!caVar.dOQ() || caVar.gAt()) {
            AppMethodBeat.o(123944);
            return null;
        } else {
            k.b aD = k.b.aD(caVar.field_content, caVar.field_reserved);
            if (aD == null) {
                AppMethodBeat.o(123944);
                return null;
            }
            e eVar = (e) aD.as(e.class);
            if (eVar == null || (eVar.iwc == -1 && eVar.iwj != 1)) {
                AppMethodBeat.o(123944);
                return null;
            }
            amt amt = new amt();
            amt.iwe = eVar.iwe;
            amt.iwc = eVar.iwc;
            amt.iwf = eVar.iwf;
            amt.vid = eVar.vid;
            amt.videoWidth = eVar.videoWidth;
            amt.videoHeight = eVar.videoHeight;
            amt.duration = eVar.duration;
            amt.iwd = eVar.iwd;
            amt.iAo = aD.thumburl;
            amt.dHc = aD.eag;
            amt.iAg = aD.eah;
            anq.bhs(aD.title);
            anq.bht(aD.description);
            AppMethodBeat.o(123944);
            return amt;
        }
    }

    public static amt v(ca caVar) {
        AppMethodBeat.i(123945);
        if (caVar == null) {
            AppMethodBeat.o(123945);
            return null;
        } else if (caVar.cWK()) {
            k.b aD = k.b.aD(caVar.field_content, caVar.field_reserved);
            if (aD == null) {
                AppMethodBeat.o(123945);
                return null;
            }
            e eVar = (e) aD.as(e.class);
            if (eVar == null || eVar.iwi == null) {
                AppMethodBeat.o(123945);
                return null;
            }
            amt amt = new amt();
            amt.dHc = aD.eag;
            amt.iAg = aD.eah;
            amt.KOe = eVar.iwi.KOe;
            amt.videoUrl = eVar.iwi.videoUrl;
            amt.vid = eVar.iwi.KOf;
            amt.iAo = eVar.iwi.iAo;
            amt.videoWidth = eVar.iwi.width;
            amt.videoHeight = eVar.iwi.height;
            amt.duration = eVar.iwi.videoDuration;
            AppMethodBeat.o(123945);
            return amt;
        } else {
            AppMethodBeat.o(123945);
            return null;
        }
    }

    public static amt a(v vVar, anq anq, String str, String str2) {
        AppMethodBeat.i(123946);
        if (vVar == null || vVar.type == -1) {
            AppMethodBeat.o(123946);
            return null;
        }
        amt amt = new amt();
        amt.iwe = vVar.type == 5 ? 1 : 0;
        amt.iwc = vVar.type;
        amt.iwf = vVar.iwf;
        amt.vid = vVar.vid;
        amt.videoWidth = vVar.videoWidth;
        amt.videoHeight = vVar.videoHeight;
        amt.duration = vVar.iAs;
        amt.iwd = (int) vVar.time;
        amt.dHc = str;
        amt.iAg = str2;
        amt.iAo = vVar.iAo;
        anq.bhs(vVar.title);
        anq.bht(vVar.iAq);
        AppMethodBeat.o(123946);
        return amt;
    }

    public static String rJ(int i2) {
        String str;
        AppMethodBeat.i(123947);
        if (i2 <= 0 || ((long) i2) >= 86400) {
            AppMethodBeat.o(123947);
            return null;
        }
        if (((long) i2) < 3600) {
            str = "mm:ss";
        } else {
            str = "HH:mm:ss";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+0:00"));
        String format = simpleDateFormat.format(Long.valueOf(((long) i2) * 1000));
        AppMethodBeat.o(123947);
        return format;
    }

    public static boolean c(long j2, String str) {
        AppMethodBeat.i(123948);
        if (str == null) {
            AppMethodBeat.o(123948);
            return false;
        }
        u a2 = ((a) g.af(a.class)).a(j2, str);
        if (a2 == null) {
            Log.w("MicroMsg.AppMsgBizHelper", "isBizMsgForbidForward reader is null");
            AppMethodBeat.o(123948);
            return false;
        } else if (a2.iAe == 1) {
            AppMethodBeat.o(123948);
            return true;
        } else {
            AppMethodBeat.o(123948);
            return false;
        }
    }

    public static String a(Context context, int i2, String str, String str2, long j2) {
        i Mx;
        AppMethodBeat.i(123949);
        if (context == null) {
            Log.w("MicroMsg.AppMsgBizHelper", "getReaderAppMsgContent: context is null");
            AppMethodBeat.o(123949);
            return null;
        } else if (str == null || str2 == null) {
            Log.w("MicroMsg.AppMsgBizHelper", "getReaderAppMsgContent: msg is null");
            AppMethodBeat.o(123949);
            return null;
        } else {
            g.aAi();
            if (!g.aAh().isSDCardAvailable()) {
                u.g(context, null);
                AppMethodBeat.o(123949);
                return null;
            }
            try {
                u a2 = ((a) g.af(a.class)).a(j2, str);
                LinkedList linkedList = a2.iAd;
                if (linkedList != null && linkedList.size() > 0 && i2 < linkedList.size()) {
                    v vVar = (v) linkedList.get(i2);
                    k.b bVar = new k.b();
                    bVar.title = vVar.title;
                    bVar.description = vVar.iAq;
                    bVar.action = "view";
                    bVar.type = 5;
                    bVar.url = vVar.url;
                    bVar.eag = a2.eag;
                    bVar.eah = a2.eah;
                    bVar.fQR = a2.fQR;
                    bVar.thumburl = a(vVar);
                    e eVar = new e();
                    eVar.iwc = vVar.type;
                    eVar.iwf = vVar.iwf;
                    if (vVar.type == 5) {
                        eVar.vid = vVar.vid;
                        eVar.iwd = (int) vVar.time;
                        eVar.duration = vVar.iAs;
                        eVar.videoWidth = vVar.videoWidth;
                        eVar.videoHeight = vVar.videoHeight;
                    }
                    bVar.a(eVar);
                    if (Util.isNullOrNil(bVar.thumburl) && (Mx = p.aYB().Mx(str2)) != null) {
                        bVar.thumburl = Mx.aYt();
                    }
                    String a3 = k.b.a(bVar, null, null);
                    AppMethodBeat.o(123949);
                    return a3;
                }
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.AppMsgBizHelper", e2, "", new Object[0]);
                Log.e("MicroMsg.AppMsgBizHelper", "retransmit app msg error : %s", e2.getLocalizedMessage());
            }
            AppMethodBeat.o(123949);
            return null;
        }
    }

    public static String d(String str, int i2, int i3, int i4) {
        String str2;
        boolean z = false;
        AppMethodBeat.i(123950);
        int sessionId = ab.getSessionId();
        if (str == null || !str.contains(WeChatHosts.domainString(R.string.e20)) || (sessionId <= 0 && i3 < 0 && i2 < 0 && i4 <= 0)) {
            AppMethodBeat.o(123950);
            return str;
        }
        String str3 = "";
        int indexOf = str.indexOf("#");
        if (indexOf > 0) {
            str2 = str.substring(0, indexOf);
            str3 = str.substring(indexOf);
        } else {
            str2 = str;
        }
        if (!str.contains("?")) {
            str2 = str2 + "?";
            z = true;
        }
        if (i2 >= 0) {
            str2 = str2.replaceAll("(scene=[\\d]*)", "") + "&scene=" + i2;
        }
        if (i3 >= 0) {
            str2 = str2.replaceAll("(subscene=[\\d]*)", "") + "&subscene=" + i3;
        }
        if (sessionId > 0) {
            str2 = str2 + "&sessionid=" + sessionId;
        }
        if (i4 > 0) {
            str2 = (str2 + "&clicktime=" + i4) + "&enterid=" + i4;
        }
        if (z) {
            str2 = str2.replace("?&", "?");
        }
        String str4 = str2 + str3;
        AppMethodBeat.o(123950);
        return str4;
    }

    public static int ape() {
        AppMethodBeat.i(123951);
        Context context = MMApplicationContext.getContext();
        if (!NetStatusUtil.isNetworkConnected(context)) {
            AppMethodBeat.o(123951);
            return 100;
        } else if (NetStatusUtil.is2G(context)) {
            AppMethodBeat.o(123951);
            return 2;
        } else if (NetStatusUtil.is3G(context)) {
            AppMethodBeat.o(123951);
            return 3;
        } else if (NetStatusUtil.is4G(context)) {
            AppMethodBeat.o(123951);
            return 4;
        } else if (NetStatusUtil.is5G(context)) {
            AppMethodBeat.o(123951);
            return 5;
        } else if (NetStatusUtil.isWifi(context)) {
            AppMethodBeat.o(123951);
            return 1;
        } else {
            AppMethodBeat.o(123951);
            return 0;
        }
    }

    public static String aE(String str, String str2) {
        WxaAttributes Xk;
        String str3 = null;
        AppMethodBeat.i(123937);
        Map<String, String> parseXml = XmlParser.parseXml(str, "msg", null);
        if (parseXml == null) {
            Log.e("MicroMsg.AppMsgBizHelper", "getAppMsgDyeingTempFromUser fail, values is null");
        } else {
            str3 = parseXml.get(".msg.fromusername");
        }
        if (!Util.isNullOrNil(str3) || com.tencent.mm.model.ab.Js(str2)) {
            str2 = str3;
        }
        if (Util.isNullOrNil(str2)) {
            AppMethodBeat.o(123937);
            return "";
        } else if (!HF(str2) || (Xk = ((q) g.af(q.class)).Xk(str2)) == null || TextUtils.isEmpty(Xk.field_nickname)) {
            as Kn = ((l) g.af(l.class)).aSN().Kn(str2);
            if (Kn == null || ((int) Kn.gMZ) <= 0) {
                AppMethodBeat.o(123937);
                return "";
            }
            String displayName = ((b) g.af(b.class)).getDisplayName(str2);
            AppMethodBeat.o(123937);
            return displayName;
        } else {
            String str4 = Xk.field_nickname;
            AppMethodBeat.o(123937);
            return str4;
        }
    }
}
