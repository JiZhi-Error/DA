package com.tencent.mm.plugin.sns.l;

import android.graphics.Bitmap;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.a.hb;
import com.tencent.mm.g.c.f;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.ar;
import com.tencent.mm.plugin.sns.model.ay;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.y;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.amo;
import com.tencent.mm.protocal.protobuf.amt;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.anh;
import com.tencent.mm.protocal.protobuf.anq;
import com.tencent.mm.protocal.protobuf.cli;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.vfs.s;
import java.util.LinkedList;
import java.util.Map;

public final class a {
    public static boolean a(cz czVar, SnsInfo snsInfo) {
        int i2;
        AppMethodBeat.i(97654);
        if (snsInfo == null) {
            Log.w("MicroMsg.Sns.GetFavDataSource", "fill sight favorite event fail, event is null or tlObj is null");
            czVar.dFZ.dGe = R.string.c_2;
            AppMethodBeat.o(97654);
            return false;
        }
        anb anb = new anb();
        anh anh = new anh();
        TimeLineObject timeLine = snsInfo.getTimeLine();
        cnb cnb = timeLine.ContentObj.LoV.get(0);
        if (snsInfo.isAd() && timeLine.ContentObj.LoU == 15) {
            timeLine.streamvideo.izf = snsInfo.getAdInfo().uxInfo;
            timeLine.streamvideo.izg = timeLine.Id;
        }
        String format = String.format("%s#%s", r.Jb(snsInfo.field_snsId), cnb.Id);
        anh.bhf(snsInfo.field_userName);
        anh.bhg(z.aTY());
        anh.ajm(2);
        anh.MA(Util.nowMilliSecond());
        anh.bhk(snsInfo.getSnsId());
        anh.bhh(format);
        anb.a(anh);
        aml aml = new aml();
        aml.bgx(format);
        String ki = ar.ki(aj.getAccSnsPath(), cnb.Id);
        String j2 = r.j(cnb);
        String e2 = r.e(cnb);
        if (Util.isNullOrNil(ay.a(snsInfo.getLocalid(), cnb))) {
            Log.w("MicroMsg.Sns.GetFavDataSource", "this sight had no download finish, can not favorite.");
            czVar.dFZ.dGe = R.string.c_i;
            AppMethodBeat.o(97654);
            return false;
        } else if (!s.YS(ki + j2)) {
            Log.i("MicroMsg.Sns.GetFavDataSource", "fav error sight: " + s.YS(ki + j2) + " thumb:" + s.YS(ki + e2));
            czVar.dFZ.dGe = R.string.c_i;
            AppMethodBeat.o(97654);
            return false;
        } else {
            if (!s.YS(ki + e2)) {
                int i3 = 320;
                int i4 = 240;
                if (cnb.MsB != null && cnb.MsB.Mtp > 0.0f && cnb.MsB.Mto > 0.0f) {
                    i3 = (int) cnb.MsB.Mto;
                    i4 = (int) cnb.MsB.Mtp;
                }
                Bitmap az = e.az(ki + j2, i3, i4);
                if (az == null) {
                    Log.i("MicroMsg.Sns.GetFavDataSource", "fav error on get thumb:" + s.YS(ki + e2));
                    czVar.dFZ.dGe = R.string.c_i;
                    AppMethodBeat.o(97654);
                    return false;
                }
                try {
                    BitmapUtil.saveBitmapToImage(az, 60, Bitmap.CompressFormat.JPEG, ki + e2, true);
                } catch (Exception e3) {
                    Log.printErrStackTrace("MicroMsg.Sns.GetFavDataSource", e3, "save bmp error %s", e3.getMessage());
                    Log.i("MicroMsg.Sns.GetFavDataSource", "fav error on save thumb:" + s.YS(ki + e2));
                    czVar.dFZ.dGe = R.string.c_i;
                    AppMethodBeat.o(97654);
                    return false;
                }
            }
            aml.bgt(ki + j2);
            aml.bgu(ki + e2);
            aml.bgf(Util.isNullOrNil(cnb.MsJ) ? timeLine.ContentDesc : cnb.MsJ);
            aml.bgE(timeLine.canvasInfo);
            if (!Util.isNullOrNil(timeLine.canvasInfo)) {
                Map<String, String> parseXml = XmlParser.parseXml(timeLine.canvasInfo, f.COL_ADXML, null);
                if (parseXml.size() > 0) {
                    aml.bgf(Util.nullAs(parseXml.get(".adxml.adCanvasInfo.shareTitle"), ""));
                    aml.bgg(Util.nullAs(parseXml.get(".adxml.adCanvasInfo.shareDesc"), ""));
                }
            }
            int i5 = 4;
            if (snsInfo.isAd()) {
                ADXml adXml = snsInfo.getAdXml();
                amo amo = new amo();
                amo.izb = Util.isNullOrNil(cnb.MsJ) ? timeLine.ContentDesc : cnb.MsJ;
                amo.LxJ = cnb.ERX;
                amo.iyZ = cnb.MsF;
                amo.izf = timeLine.streamvideo.izf;
                amo.izg = timeLine.streamvideo.izg;
                if (Util.isNullOrNil(amo.izg)) {
                    amo.izg = timeLine.Id;
                }
                amo.ize = Util.isNullOrNil(cnb.MsI) ? cnb.Msz : cnb.MsI;
                if (adXml != null && adXml.attachShareLinkIsHidden == 0) {
                    amo.izd = adXml.attachShareLinkUrl;
                    amo.izc = adXml.attachShareLinkWording;
                }
                aml.a(amo);
                i2 = 16;
                i5 = 15;
            } else {
                i2 = 4;
            }
            aml.ajd(i5);
            com.tencent.mm.plugin.sight.base.a aNx = e.aNx(aml.LvL);
            if (aNx != null) {
                aml.ajc(aNx.getVideoDuration());
            } else {
                aml.ajc(1);
            }
            LinkedList<aml> linkedList = new LinkedList<>();
            linkedList.add(aml);
            anb.bH(linkedList);
            czVar.dFZ.dGb = anb;
            czVar.dFZ.type = i2;
            a(aml, snsInfo);
            Log.i("MicroMsg.Sns.GetFavDataSource", "fill event Info sight dataType %d eventType %d", Integer.valueOf(i5), Integer.valueOf(i2));
            AppMethodBeat.o(97654);
            return true;
        }
    }

    public static boolean a(cz czVar, String str, String str2) {
        AppMethodBeat.i(259448);
        boolean b2 = b(czVar, str, str2);
        AppMethodBeat.o(259448);
        return b2;
    }

    public static boolean b(cz czVar, String str, String str2) {
        AppMethodBeat.i(97656);
        if (czVar == null || !y.aQJ(str2) || str == null) {
            Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or url is null");
            if (czVar != null) {
                czVar.dFZ.dGe = R.string.c_2;
            }
            AppMethodBeat.o(97656);
            return false;
        } else if (aj.isInValid()) {
            Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
            czVar.dFZ.dGe = R.string.c_j;
            AppMethodBeat.o(97656);
            return false;
        } else {
            SnsInfo aQm = com.tencent.mm.plugin.sns.storage.f.aQm(str2);
            if (aQm == null) {
                Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
                czVar.dFZ.dGe = R.string.c_3;
                AppMethodBeat.o(97656);
                return false;
            } else if (aQm.getTimeLine().ContentObj == null || aQm.getTimeLine().ContentObj.LoU != 26) {
                String str3 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                cnb b2 = an.b(aQm, 0);
                if (b2 != null) {
                    str3 = b2.Id;
                }
                String format = String.format("%s#%s", r.Jb(aQm.field_snsId), str3);
                anb anb = new anb();
                anh anh = new anh();
                Log.i("MicroMsg.Sns.GetFavDataSource", "fav sns url, from %s", aQm.getUserName());
                anh.bhf(aQm.getUserName());
                anh.bhg(z.aTY());
                anh.ajm(2);
                anh.MA(((long) aQm.getCreateTime()) * 1000);
                anh.bhk(aQm.getSnsId());
                anh.bhh(format);
                anh.bhm(str);
                aml aml = new aml();
                aml.bgx(format);
                if (b2 != null) {
                    String str4 = ar.ki(aj.getAccSnsPath(), b2.Id) + r.e(b2);
                    if (s.YS(str4)) {
                        aml.bgu(str4);
                    } else {
                        aml.At(true);
                        aml.bgo(b2.Msz);
                        anq anq = new anq();
                        anq.bhv(b2.Msz);
                        anb.b(anq);
                    }
                } else {
                    aml.At(true);
                }
                aml.ajd(5);
                TimeLineObject timeLine = aQm.getTimeLine();
                aml.bgf(timeLine.ContentObj.Title);
                aml.bgg(timeLine.ContentObj.Desc);
                aml.bgE(timeLine.canvasInfo);
                if (!Util.isNullOrNil(timeLine.canvasInfo)) {
                    Map<String, String> parseXml = XmlParser.parseXml(timeLine.canvasInfo, f.COL_ADXML, null);
                    if (parseXml.size() > 0) {
                        aml.bgf(Util.nullAs(parseXml.get(".adxml.adCanvasInfo.shareTitle"), ""));
                        aml.bgg(Util.nullAs(parseXml.get(".adxml.adCanvasInfo.shareDesc"), ""));
                    }
                }
                a(aml, timeLine);
                aml.As(true);
                anb.ppH.add(aml);
                anq anq2 = new anq();
                anq2.ajo(timeLine.contentattr);
                anq2.bhs(aml.title);
                if (timeLine.webSearchInfo != null && !Util.isNullOrNil(timeLine.webSearchInfo.IEy)) {
                    com.tencent.mm.plugin.websearch.api.aj ajVar = new com.tencent.mm.plugin.websearch.api.aj();
                    ajVar.IEy = timeLine.webSearchInfo.IEy;
                    ajVar.IEz = timeLine.webSearchInfo.IEz;
                    ajVar.IEA = timeLine.webSearchInfo.IEA;
                    ajVar.IEB = timeLine.webSearchInfo.IEB;
                    ajVar.IEC = timeLine.webSearchInfo.IEC;
                    ajVar.rCq = timeLine.webSearchInfo.rCq;
                    ajVar.msN = timeLine.webSearchInfo.msN;
                    ajVar.xDQ = timeLine.webSearchInfo.xDQ;
                    ajVar.IED = timeLine.webSearchInfo.IED;
                    ajVar.IEE = timeLine.webSearchInfo.IEE;
                    ajVar.IEF = timeLine.webSearchInfo.IEF;
                    ajVar.source = timeLine.webSearchInfo.source;
                    ajVar.eby = timeLine.webSearchInfo.eby;
                    ajVar.IEG = timeLine.webSearchInfo.IEG;
                    ajVar.IEH = timeLine.webSearchInfo.IEH;
                    ajVar.IEI = timeLine.webSearchInfo.IEI;
                    ajVar.IEJ = timeLine.webSearchInfo.IEJ;
                    ajVar.IEK = timeLine.webSearchInfo.IEK;
                    ajVar.thumbUrl = timeLine.webSearchInfo.thumbUrl;
                    ajVar.IEL = timeLine.webSearchInfo.IEL;
                    StringBuilder sb = new StringBuilder();
                    ajVar.a(sb, null, null, null, 0, 0);
                    anq2.bhx(sb.toString());
                }
                anb.b(anq2);
                a(anb, timeLine, anq2);
                anb.a(anh);
                czVar.dFZ.dGb = anb;
                czVar.dFZ.desc = timeLine.ContentObj.Title;
                czVar.dFZ.type = 5;
                AppMethodBeat.o(97656);
                return true;
            } else {
                boolean a2 = a(czVar, str2);
                AppMethodBeat.o(97656);
                return a2;
            }
        }
    }

    private static boolean a(anb anb, TimeLineObject timeLineObject, anq anq) {
        AppMethodBeat.i(97657);
        if (timeLineObject.ContentObj.LoY == null || timeLineObject.ContentObj.LoY.iAb == -1) {
            AppMethodBeat.o(97657);
            return false;
        }
        cli cli = timeLineObject.ContentObj.LoY;
        amt amt = new amt();
        anb.f(amt);
        amt.iwe = timeLineObject.ContentObj.LoY.iwe;
        amt.iwc = cli.iAb;
        amt.iwf = cli.iwf;
        amt.iwd = cli.iwd;
        amt.duration = cli.duration;
        amt.iwg = cli.iwg;
        amt.vid = cli.vid;
        amt.videoWidth = cli.videoWidth;
        amt.videoHeight = cli.videoHeight;
        amt.dHc = timeLineObject.publicUserName;
        amt.iAg = timeLineObject.sourceNickName;
        amt.iAo = cli.coverUrl;
        anq.bht(cli.desc);
        AppMethodBeat.o(97657);
        return true;
    }

    public static boolean a(cz czVar, String str, CharSequence charSequence) {
        AppMethodBeat.i(97658);
        if (y.aQK(str) || charSequence == null) {
            Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or text is null");
            czVar.dFZ.dGe = R.string.c_2;
            AppMethodBeat.o(97658);
            return false;
        } else if (aj.isInValid()) {
            Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
            czVar.dFZ.dGe = R.string.c_j;
            AppMethodBeat.o(97658);
            return false;
        } else {
            SnsInfo aQm = aj.faO().aQm(str);
            if (aQm == null) {
                Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
                czVar.dFZ.dGe = R.string.c_3;
                AppMethodBeat.o(97658);
                return false;
            } else if (0 == aQm.field_snsId) {
                Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo.field_snsId is 0");
                czVar.dFZ.dGe = R.string.c_1;
                AppMethodBeat.o(97658);
                return false;
            } else {
                String format = String.format("%s#0", r.Jb(aQm.field_snsId));
                anb anb = new anb();
                anh anh = new anh();
                Log.i("MicroMsg.Sns.GetFavDataSource", "fav sns text, from %s", aQm.getUserName());
                anh.bhf(aQm.getUserName());
                anh.bhg(z.aTY());
                anh.ajm(2);
                anh.MA(((long) aQm.getCreateTime()) * 1000);
                anh.bhk(aQm.getSnsId());
                anh.bhh(format);
                anb.a(anh);
                czVar.dFZ.dGb = anb;
                czVar.dFZ.desc = charSequence.toString();
                czVar.dFZ.type = 1;
                AppMethodBeat.o(97658);
                return true;
            }
        }
    }

    public static boolean a(cz czVar, SnsInfo snsInfo, String str) {
        AppMethodBeat.i(97659);
        if (czVar == null || Util.isNullOrNil(str)) {
            Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or media id is null");
            if (czVar != null) {
                czVar.dFZ.dGe = R.string.c_2;
            }
            AppMethodBeat.o(97659);
            return false;
        } else if (snsInfo == null) {
            Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
            czVar.dFZ.dGe = R.string.c_3;
            AppMethodBeat.o(97659);
            return false;
        } else {
            cnb a2 = an.a(snsInfo, str);
            if (a2 == null) {
                Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, mediaObj is null");
                czVar.dFZ.dGe = R.string.c_3;
                AppMethodBeat.o(97659);
                return false;
            }
            String format = String.format("%s#%s", r.Jb(snsInfo.field_snsId), str);
            anb anb = new anb();
            anh anh = new anh();
            aml aml = new aml();
            Log.i("MicroMsg.Sns.GetFavDataSource", "fav sns image, from %s", snsInfo.getUserName());
            anh.bhf(snsInfo.getUserName());
            anh.bhg(z.aTY());
            anh.ajm(2);
            anh.MA(((long) snsInfo.getCreateTime()) * 1000);
            anh.bhk(snsInfo.getSnsId());
            anh.bhh(format);
            aml.bgx(format);
            aml.bgt(ar.ki(aj.getAccSnsPath(), str) + r.l(a2));
            if (snsInfo.getTimeLine() != null) {
                aml.bgE(snsInfo.getTimeLine().canvasInfo);
                if (!Util.isNullOrNil(snsInfo.getTimeLine().canvasInfo)) {
                    Map<String, String> parseXml = XmlParser.parseXml(snsInfo.getTimeLine().canvasInfo, f.COL_ADXML, null);
                    if (parseXml.size() > 0) {
                        aml.bgf(Util.nullAs(parseXml.get(".adxml.adCanvasInfo.shareTitle"), ""));
                        aml.bgg(Util.nullAs(parseXml.get(".adxml.adCanvasInfo.shareDesc"), ""));
                    }
                }
            }
            a(aml, snsInfo);
            String str2 = ar.ki(aj.getAccSnsPath(), a2.Id) + r.e(a2);
            if (s.YS(aml.LvL) || !snsInfo.getUserName().endsWith(aj.fau())) {
                if (s.YS(str2)) {
                    aml.bgu(str2);
                } else {
                    aml.At(true);
                    aml.bgo(a2.Msz);
                    anq anq = new anq();
                    anq.bhv(a2.Msz);
                    anb.b(anq);
                }
                aml.ajd(2);
                anb.ppH.add(aml);
                anb.a(anh);
                czVar.dFZ.dGb = anb;
                czVar.dFZ.type = 2;
                AppMethodBeat.o(97659);
                return true;
            }
            Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, mediaObj is null");
            czVar.dFZ.dGe = R.string.c_3;
            AppMethodBeat.o(97659);
            return false;
        }
    }

    public static boolean a(cz czVar, String str, int i2) {
        AppMethodBeat.i(97660);
        if (y.aQK(str) || i2 < 0) {
            Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or position errro");
            czVar.dFZ.dGe = R.string.c_2;
            AppMethodBeat.o(97660);
            return false;
        } else if (aj.isInValid()) {
            Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
            czVar.dFZ.dGe = R.string.c_j;
            AppMethodBeat.o(97660);
            return false;
        } else {
            SnsInfo aQm = aj.faO().aQm(str);
            if (aQm == null) {
                Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
                czVar.dFZ.dGe = R.string.c_3;
                AppMethodBeat.o(97660);
                return false;
            }
            cnb b2 = an.b(aQm, i2);
            if (b2 == null) {
                Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, media obj is null");
                czVar.dFZ.dGe = R.string.c_3;
                AppMethodBeat.o(97660);
                return false;
            }
            boolean a2 = a(czVar, aQm, b2.Id);
            AppMethodBeat.o(97660);
            return a2;
        }
    }

    public static void a(aml aml, TimeLineObject timeLineObject) {
        AppMethodBeat.i(97661);
        if (!(aml == null || timeLineObject == null || Util.isNullOrNil(timeLineObject.statExtStr))) {
            aml.bgD(timeLineObject.statExtStr);
        }
        AppMethodBeat.o(97661);
    }

    public static void a(aml aml, SnsInfo snsInfo) {
        AppMethodBeat.i(97662);
        if (snsInfo != null) {
            a(aml, snsInfo.getTimeLine());
        }
        AppMethodBeat.o(97662);
    }

    public static boolean a(cz czVar, String str) {
        LinkedList<aml> linkedList;
        AppMethodBeat.i(97663);
        if (czVar == null || !y.aQJ(str)) {
            Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or url is null");
            if (czVar != null) {
                czVar.dFZ.dGe = R.string.c_2;
            }
            AppMethodBeat.o(97663);
            return false;
        } else if (aj.isInValid()) {
            Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
            czVar.dFZ.dGe = R.string.c_j;
            AppMethodBeat.o(97663);
            return false;
        } else {
            SnsInfo aQm = com.tencent.mm.plugin.sns.storage.f.aQm(str);
            if (aQm == null) {
                Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
                czVar.dFZ.dGe = R.string.c_3;
                AppMethodBeat.o(97663);
                return false;
            }
            String str2 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            cnb b2 = an.b(aQm, 0);
            if (b2 != null) {
                str2 = b2.Id;
            }
            String format = String.format("%s#%s", r.Jb(aQm.field_snsId), str2);
            anh anh = new anh();
            TimeLineObject timeLine = aQm.getTimeLine();
            if (timeLine == null) {
                Log.i("MicroMsg.Sns.GetFavDataSource", "fav NoteLink, tlObj is null , return");
                AppMethodBeat.o(97663);
                return false;
            }
            Log.i("MicroMsg.Sns.GetFavDataSource", "fav NoteLink, from %s", aQm.getUserName());
            anh.bhf(aQm.getUserName());
            anh.bhg(z.aTY());
            anh.ajm(2);
            anh.MA(((long) aQm.getCreateTime()) * 1000);
            anh.bhk(aQm.getSnsId());
            anh.bhh(format);
            hb hbVar = new hb();
            hbVar.dLm.type = 30;
            hbVar.dLm.dLt = 4;
            hbVar.dLm.desc = timeLine.ContentObj.LoX;
            EventCenter.instance.publish(hbVar);
            hbVar.dLm.dGb.a(anh);
            czVar.dFZ.dGb = hbVar.dLm.dGb;
            if (!(czVar.dFZ.dGb == null || (linkedList = czVar.dFZ.dGb.ppH) == null)) {
                for (int i2 = 0; i2 < linkedList.size(); i2++) {
                    aml aml = linkedList.get(i2);
                    if (aml != null) {
                        aml.As(true);
                        aml.At(true);
                    }
                }
            }
            czVar.dFZ.desc = timeLine.ContentObj.Title;
            czVar.dFZ.type = 18;
            AppMethodBeat.o(97663);
            return true;
        }
    }
}
