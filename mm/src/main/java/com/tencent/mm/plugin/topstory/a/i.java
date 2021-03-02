package com.tencent.mm.plugin.topstory.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.websearch.api.a.a;
import com.tencent.mm.plugin.websearch.api.a.b;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.y;
import com.tencent.mm.protocal.protobuf.any;
import com.tencent.mm.protocal.protobuf.doc;
import com.tencent.mm.protocal.protobuf.eii;
import com.tencent.mm.protocal.protobuf.eit;
import com.tencent.mm.protocal.protobuf.eiw;
import com.tencent.mm.protocal.protobuf.fat;
import com.tencent.mm.sdk.http.HttpClientWrapper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import java.io.UnsupportedEncodingException;
import java.util.Set;

public final class i {
    public static void a(eit eit, eiw eiw, String str, String str2, String str3) {
        AppMethodBeat.i(90991);
        String format = String.format("videosharereport=1&scene=%s&searchid=%s&docid=%s&cdnsourcetype=%s&videoid=%s&optype=%s&fromuser=%s&touser=%s&channelid=%s&optypes=%s&expand=%s", Integer.valueOf(eit.scene), eit.hes, eiw.wWb, Integer.valueOf(eiw.NiB), eiw.psI, 0, str2, str3, Long.valueOf(eit.Nib), str, eiw.Nir);
        Log.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryVideoShare 15035 %s", format);
        doc doc = new doc();
        doc.MRe = format;
        Log.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryVideoShare:".concat(String.valueOf(format)));
        g.azz().a(new ad(doc), 0);
        AppMethodBeat.o(90991);
    }

    public static void a(eii eii, String str, long j2) {
        long j3;
        AppMethodBeat.i(90992);
        if (eii.Nhy.size() <= 0 || !"clickTopStory".equals(eii.Nhy.get(0).name)) {
            j3 = 0;
        } else {
            j3 = j2 - eii.Nhy.get(0).timestamp;
        }
        String format = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", Integer.valueOf(eii.scene), eii.sGQ, eii.sessionId, Integer.valueOf(ai.aft(1)), str, Long.valueOf(j2), Integer.valueOf(eii.GjO), Integer.valueOf(eii.Nhz), eii.wib, Long.valueOf(j3), eii.NhA);
        Log.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryHomeUIAction 15466 %s", format);
        h.INSTANCE.kvStat(15466, format);
        AppMethodBeat.o(90992);
    }

    public static void abQ(int i2) {
        AppMethodBeat.i(90994);
        switch (i2) {
            case -21020:
                b.pl(b.vhW);
                break;
            case -21009:
                b.pl(b.vhV);
                break;
            case -10012:
                b.pl(b.vhT);
                break;
            case HttpClientWrapper.RET_CODE_FILE_NOT_FOUND /*{ENCODED_INT: -10004}*/:
                b.pl(b.vhU);
                break;
            case -1010:
                b.pl(b.vhQ);
                break;
            case -1007:
                b.pl(b.vhR);
                break;
            case -1004:
                b.pl(b.vhS);
                break;
            case 403:
                b.pl(b.vhY);
                break;
            case 404:
                b.pl(b.vhX);
                break;
            case 405:
                b.pl(b.vie);
                break;
            case 416:
                b.pl(b.vic);
                break;
            case 502:
                b.pl(b.vib);
                break;
            case 503:
                b.pl(b.vhZ);
                break;
            default:
                b.pl(b.vif);
                break;
        }
        a.pl(7);
        AppMethodBeat.o(90994);
    }

    public static void a(eiw eiw, int i2, String str, int i3) {
        int i4;
        AppMethodBeat.i(90995);
        if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
            i4 = 2;
        } else if (!NetStatusUtil.isConnected(MMApplicationContext.getContext())) {
            i4 = 1;
        } else {
            i4 = 3;
        }
        String format = String.format("%s,%s,%s,%s,%s", Integer.valueOf(i2), str, eiw != null ? eiw.wWb : "", Integer.valueOf(i4), Integer.valueOf(i3));
        Log.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportKvTopStoryVideoPlayError %s", format);
        e.INSTANCE.kvStat(15248, format);
        AppMethodBeat.o(90995);
    }

    public static void a(eit eit, eiw eiw, Set<any> set, int i2) {
        AppMethodBeat.i(90996);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("isfeedback=1");
        stringBuffer.append("&feedtype=0");
        stringBuffer.append("&businesstype=2");
        stringBuffer.append("&itemtype=");
        stringBuffer.append(eiw.Nis);
        stringBuffer.append("&scene=");
        stringBuffer.append(eit.scene);
        stringBuffer.append("&searchid=");
        stringBuffer.append(eit.hes);
        stringBuffer.append("&clicktime=");
        stringBuffer.append(System.currentTimeMillis());
        stringBuffer.append("&docid=");
        stringBuffer.append(eiw.wWb);
        stringBuffer.append("&docpos=");
        stringBuffer.append(i2);
        stringBuffer.append("&reasonid=");
        for (any any : set) {
            stringBuffer.append(any.id);
            stringBuffer.append("#");
        }
        stringBuffer.append("&reasonwording=");
        StringBuffer stringBuffer2 = new StringBuffer();
        for (any any2 : set) {
            stringBuffer2.append(any2.dQx);
            stringBuffer2.append("#");
        }
        try {
            stringBuffer.append(q.encode(stringBuffer2.toString(), "utf8"));
        } catch (UnsupportedEncodingException e2) {
        }
        stringBuffer.append("&offset=");
        stringBuffer.append(i2);
        stringBuffer.append("&sessionid=");
        stringBuffer.append(ai.afq(eit.scene));
        stringBuffer.append("&reserveexpand=");
        stringBuffer.append(eiw.Nit);
        Log.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportFeedBackClick %s", stringBuffer.toString());
        doc doc = new doc();
        doc.MRe = stringBuffer.toString();
        g.azz().a(new ad(doc), 0);
        AppMethodBeat.o(90996);
    }

    public static final void a(eit eit, long j2, eiw eiw) {
        AppMethodBeat.i(90997);
        if (j2 > 0) {
            Object[] objArr = new Object[8];
            objArr[0] = Integer.valueOf(eit.scene);
            objArr[1] = Long.valueOf(j2 / 1000);
            objArr[2] = Long.valueOf(eit.Nib);
            objArr[3] = 3;
            objArr[4] = "";
            objArr[5] = 2;
            objArr[6] = eiw != null ? eiw.Nir : eit.NhY;
            objArr[7] = eit.hes;
            String format = String.format("videoflowbrowsereport=1&scene=%s&staytime=%s&channelid=%s&pageid=%s&nettype=%s&source=%s&expand=%s&searchid=%s", objArr);
            Log.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryVideoPageBrowseTime 15018 %s", format);
            doc doc = new doc();
            doc.MRe = format;
            g.azz().a(new ad(doc), 0);
        }
        AppMethodBeat.o(90997);
    }

    public static final void aTw(String str) {
        AppMethodBeat.i(206894);
        Log.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryWebViewVisitTime %s", str);
        doc doc = new doc();
        doc.MRe = str;
        g.azz().a(new ad(doc), 0);
        AppMethodBeat.o(206894);
    }

    public static final void fQ(String str, int i2) {
        AppMethodBeat.i(90998);
        if (!Util.isNullOrNil(str) && str.startsWith("wrd")) {
            h.INSTANCE.idkeyStat(900, (long) i2, 1, false);
        }
        AppMethodBeat.o(90998);
    }

    public static final void g(String str, String str2, int i2, long j2) {
        AppMethodBeat.i(90999);
        if (!Util.isNullOrNil(str) && str.startsWith("wrd")) {
            try {
                String format = String.format("%s,%s,%s,%s", q.encode(str2, "utf8"), Integer.valueOf(i2), str, Long.valueOf(j2));
                Log.i("MicroMsg.TopStory.TopStoryReportApiLogic", "kvReportTopStoryOpenWebViewError 15728 %s", format);
                h.INSTANCE.kvStat(15728, format);
                AppMethodBeat.o(90999);
                return;
            } catch (UnsupportedEncodingException e2) {
            }
        }
        AppMethodBeat.o(90999);
    }

    public static final void a(eit eit, eiw eiw, int i2) {
        AppMethodBeat.i(177107);
        doc doc = new doc();
        doc.MRe = String.format("logname=videopoint&scene=%s&docid=%s&searchid=%s&vid=%s&actiontype=%s&itemtype=%s", Integer.valueOf(eit.scene), eiw.wWb, eit.hes, eiw.psI, Integer.valueOf(i2), Integer.valueOf(eiw.Nis));
        Log.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportVideoPointAction %s", doc.MRe);
        g.azz().a(new y(doc), 0);
        AppMethodBeat.o(177107);
    }

    public static void a(fat fat, ca caVar) {
        String str;
        String aTY;
        int i2;
        String str2;
        AppMethodBeat.i(90993);
        if (ab.Eq(caVar.field_talker)) {
            if (caVar.field_isSend == 1) {
                str = z.aTY();
            } else {
                str = bp.Ks(caVar.field_content);
            }
            str2 = caVar.field_talker;
            i2 = 2;
        } else {
            if (caVar.field_isSend == 1) {
                str = z.aTY();
                aTY = caVar.field_talker;
            } else {
                str = caVar.field_talker;
                aTY = z.aTY();
            }
            i2 = 1;
            str2 = aTY;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("isShareClick=1");
        stringBuffer.append("&relevant_vid=");
        stringBuffer.append(fat.IEy);
        stringBuffer.append("&relevant_pre_searchid=");
        stringBuffer.append(fat.IEA);
        stringBuffer.append("&relevant_shared_openid=");
        stringBuffer.append(fat.IEB);
        stringBuffer.append("&rec_category=");
        if (fat.IEK > 0) {
            stringBuffer.append(fat.IEK);
        } else {
            stringBuffer.append(fat.IEC);
        }
        stringBuffer.append("&source=");
        stringBuffer.append(fat.source);
        stringBuffer.append("&fromUser=");
        stringBuffer.append(str);
        stringBuffer.append("&fromScene=");
        stringBuffer.append(i2);
        stringBuffer.append("&targetInfo=");
        stringBuffer.append(str2);
        stringBuffer.append("&expand=");
        stringBuffer.append(fat.IEz);
        Log.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryClickShareItem 15371 %s", stringBuffer.toString());
        doc doc = new doc();
        doc.MRe = stringBuffer.toString();
        g.azz().a(new ad(doc), 0);
        AppMethodBeat.o(90993);
    }
}
