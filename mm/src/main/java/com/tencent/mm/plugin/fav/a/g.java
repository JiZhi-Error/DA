package com.tencent.mm.plugin.fav.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.by;
import com.tencent.mm.plugin.fav.a.a.b;
import com.tencent.mm.plugin.fav.a.a.c;
import com.tencent.mm.plugin.fav.a.a.d;
import com.tencent.mm.plugin.i.a.l;
import com.tencent.mm.protocal.protobuf.amj;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.amn;
import com.tencent.mm.protocal.protobuf.ams;
import com.tencent.mm.protocal.protobuf.amt;
import com.tencent.mm.protocal.protobuf.amv;
import com.tencent.mm.protocal.protobuf.ana;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.anh;
import com.tencent.mm.protocal.protobuf.ank;
import com.tencent.mm.protocal.protobuf.ano;
import com.tencent.mm.protocal.protobuf.anq;
import com.tencent.mm.protocal.protobuf.bcj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.util.Iterator;
import java.util.Map;

public final class g extends by {
    public static IAutoDBItem.MAutoDBInfo info = by.ajs();
    private static a tah = new a() {
        /* class com.tencent.mm.plugin.fav.a.g.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.fav.a.g.a
        public final void log(String str) {
            AppMethodBeat.i(103370);
            Log.d("MicroMsg.FavItemInfo", str);
            AppMethodBeat.o(103370);
        }
    };
    private static a tai = new a() {
        /* class com.tencent.mm.plugin.fav.a.g.AnonymousClass2 */

        @Override // com.tencent.mm.plugin.fav.a.g.a
        public final void log(String str) {
            AppMethodBeat.i(103371);
            Log.e("MicroMsg.FavItemInfo", str);
            AppMethodBeat.o(103371);
        }
    };
    public String dLb = "";
    public boolean tad = false;
    public g tae = null;
    public String taf = "";

    /* access modifiers changed from: package-private */
    public interface a {
        void log(String str);
    }

    public final /* synthetic */ Object clone() {
        AppMethodBeat.i(103386);
        g cUC = cUC();
        AppMethodBeat.o(103386);
        return cUC;
    }

    static {
        AppMethodBeat.i(103387);
        AppMethodBeat.o(103387);
    }

    public g() {
        AppMethodBeat.i(103372);
        this.field_flag = -1;
        this.field_fromUser = "";
        this.field_toUser = "";
        this.field_id = -1;
        this.field_realChatName = "";
        this.field_sourceType = -1;
        this.field_updateTime = -1;
        this.field_type = -1;
        this.field_updateSeq = -1;
        this.field_xml = "";
        this.field_itemStatus = 0;
        cUt();
        AppMethodBeat.o(103372);
    }

    private void cUt() {
        AppMethodBeat.i(103373);
        this.field_favProto = new anb();
        anh anh = new anh();
        anh.ajm(1);
        this.field_favProto.a(anh);
        this.field_favProto.b(new anq());
        this.field_favProto.f(new amt());
        this.field_favProto.d(new ams());
        this.field_favProto.b(new ana());
        this.field_favProto.b(new ank());
        this.field_favProto.d(new bcj());
        this.field_favProto.ajk(-1);
        this.field_tagProto = new ano();
        this.field_favProto.a(new amv());
        AppMethodBeat.o(103373);
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    public final boolean cUu() {
        return (this.field_favProto.Lxb & 1) != 0;
    }

    public final boolean cUv() {
        return (this.field_favProto.Lxb & 2) != 0;
    }

    public final Bundle cUw() {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        AppMethodBeat.i(103374);
        Bundle bundle = new Bundle();
        bundle.putBoolean("key_ctrl_flag_open_chat", cUu());
        bundle.putBoolean("key_ctrl_flag_open_sns", cUv());
        if ((this.field_favProto.Lxb & 4) != 0) {
            z = true;
        } else {
            z = false;
        }
        bundle.putBoolean("key_ctrl_flag_open_weibo", z);
        if ((this.field_favProto.Lxb & 8) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        bundle.putBoolean("key_ctrl_flag_open_cplink", z2);
        if ((this.field_favProto.Lxb & 16) != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        bundle.putBoolean("key_ctrl_flag_open_browser", z3);
        if ((this.field_favProto.Lxb & 32) != 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        bundle.putBoolean("key_ctrl_flag_open_weiyun", z4);
        if ((this.field_favProto.Lxb & 64) != 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        bundle.putBoolean("key_ctrl_flag_open_facebook", z5);
        Log.i("MicroMsg.FavItemInfo", "get ctrl args=[%s]", bundle.toString());
        AppMethodBeat.o(103374);
        return bundle;
    }

    public final boolean cUx() {
        if (this.field_itemStatus == 1 || this.field_itemStatus == 4 || this.field_itemStatus == 9 || this.field_itemStatus == 12 || this.field_itemStatus == 13 || this.field_itemStatus == 15 || this.field_itemStatus == 17) {
            return true;
        }
        return false;
    }

    public final boolean cUy() {
        if (this.field_itemStatus == 3 || this.field_itemStatus == 6 || this.field_itemStatus == 11 || this.field_itemStatus == 14 || this.field_itemStatus == 16 || this.field_itemStatus == 18) {
            return true;
        }
        return false;
    }

    public final boolean isDownloading() {
        return this.field_itemStatus == 7;
    }

    public final boolean cUz() {
        return this.field_itemStatus == 8;
    }

    public final boolean isDone() {
        return this.field_itemStatus == 10;
    }

    public final boolean cUA() {
        if (this.field_itemStatus == 15 || this.field_itemStatus == 16) {
            return true;
        }
        return false;
    }

    public final boolean cUB() {
        if (this.field_itemStatus == 12 || this.field_itemStatus == 13 || this.field_itemStatus == 14) {
            return true;
        }
        return false;
    }

    public final g arQ(String str) {
        AppMethodBeat.i(103375);
        if (str == null || str.equals("")) {
            Log.e("MicroMsg.FavItemInfo", "klem, FavItemInfo xml null");
            AppMethodBeat.o(103375);
        } else {
            Map<String, String> parseXml = XmlParser.parseXml(str, "favitem", null);
            if (parseXml == null) {
                Log.e("MicroMsg.FavItemInfo", "klem, FavItemInfo maps null");
                AppMethodBeat.o(103375);
            } else {
                try {
                    cUt();
                    anb anb = this.field_favProto;
                    anb.bhd(parseXml.get(".favitem.title"));
                    anb.bhe(parseXml.get(".favitem.desc"));
                    anb.bhc(parseXml.get(".favitem.remark"));
                    anb.My(Util.getLong(parseXml.get(".favitem.remark.$time"), 0));
                    anb.ajl(Util.getInt(parseXml.get(".favitem.version"), 0));
                    anb.Mz(Util.getLong(parseXml.get(".favitem.edittime"), 0));
                    anb.ajk(Util.getInt(parseXml.get(".favitem.ctrlflag"), -1));
                    anh anh = anb.Lya;
                    anh.ajm(Util.getInt(parseXml.get(".favitem.source" + ".$sourcetype"), 0));
                    anh.bhh(parseXml.get(".favitem.source" + ".$sourceid"));
                    anh.bhf(parseXml.get(".favitem.source" + ".fromusr"));
                    anh.bhg(parseXml.get(".favitem.source" + ".tousr"));
                    anh.bhi(parseXml.get(".favitem.source" + ".realchatname"));
                    anh.MA(Util.getLong(parseXml.get(".favitem.source" + ".createtime"), 0));
                    anh.bhj(parseXml.get(".favitem.source" + ".msgid"));
                    anh.bhk(parseXml.get(".favitem.source" + ".eventid"));
                    anh.bhl(parseXml.get(".favitem.source" + ".appid"));
                    anh.bhm(parseXml.get(".favitem.source" + ".link"));
                    anh.bhn(parseXml.get(".favitem.source" + ".brandid"));
                    c.a(str, anb);
                    ams ams = anb.LwQ;
                    if (!Util.isNullOrNil(parseXml.get(".favitem.locitem" + ".label"))) {
                        ams.bgW(parseXml.get(".favitem.locitem" + ".label"));
                    }
                    if (!Util.isNullOrNil(parseXml.get(".favitem.locitem" + ".poiname"))) {
                        ams.bgX(parseXml.get(".favitem.locitem" + ".poiname"));
                    }
                    String str2 = parseXml.get(".favitem.locitem" + ".lng");
                    if (!Util.isNullOrNil(str2)) {
                        ams.B(Util.getDouble(str2, 0.0d));
                    }
                    String str3 = parseXml.get(".favitem.locitem" + ".lat");
                    if (!Util.isNullOrNil(str3)) {
                        ams.C(Util.getDouble(str3, 0.0d));
                    }
                    String str4 = parseXml.get(".favitem.locitem" + ".scale");
                    if (!Util.isNullOrNil(str4)) {
                        if (str4.indexOf(46) != -1) {
                            ams.aji(Util.getInt(str4.substring(0, str4.indexOf(46)), -1));
                        } else {
                            ams.aji(Util.getInt(str4, -1));
                        }
                    }
                    anq anq = anb.LwS;
                    anq.bhu(parseXml.get(".favitem.weburlitem" + ".clean_url"));
                    anq.bht(parseXml.get(".favitem.weburlitem" + ".pagedesc"));
                    anq.bhv(parseXml.get(".favitem.weburlitem" + ".pagethumb_url"));
                    anq.bhs(parseXml.get(".favitem.weburlitem" + ".pagetitle"));
                    anq.ajn(Util.getInt(parseXml.get(".favitem.weburlitem" + ".opencache"), 0));
                    anq.ajo(Util.getInt(parseXml.get(".favitem.weburlitem" + ".contentattr"), 0));
                    anq.bhw(parseXml.get(".favitem.weburlitem" + ".canvasPageXml"));
                    anq.bhx(parseXml.get(".favitem.weburlitem" + ".wsVideoFlowXml"));
                    anb.d(l.x(".favitem", parseXml));
                    if (anb.IXu != null) {
                        anb.f(b.t(".favitem.weburlitem.appmsgshareitem", parseXml));
                    }
                    ana ana = anb.LwU;
                    ana.bgY(parseXml.get(".favitem.productitem" + ".producttitle"));
                    ana.bgZ(parseXml.get(".favitem.productitem" + ".productdesc"));
                    ana.bha(parseXml.get(".favitem.productitem" + ".productthumb_url"));
                    ana.bhb(parseXml.get(".favitem.productitem" + ".productinfo"));
                    ana.ajj(Util.getInt(parseXml.get(".favitem.productitem" + ".$type"), 0));
                    ank ank = anb.LwW;
                    ank.bho(parseXml.get(".favitem.tvitem" + ".tvtitle"));
                    ank.bhp(parseXml.get(".favitem.tvitem" + ".tvdesc"));
                    ank.bhq(parseXml.get(".favitem.tvitem" + ".tvthumb_url"));
                    ank.bhr(parseXml.get(".favitem.tvitem" + ".tvinfo"));
                    amv amv = anb.KBr;
                    amv.LxT = parseXml.get(".favitem.noteinfo" + ".noteauthor");
                    amv.LxU = parseXml.get(".favitem.noteinfo" + ".noteeditor");
                    if (parseXml.containsKey(".favitem.appbranditem")) {
                        amj amj = new amj();
                        amj.username = parseXml.get(".favitem.appbranditem" + ".username");
                        amj.appId = parseXml.get(".favitem.appbranditem" + ".appid");
                        amj.dMe = Util.getInt(parseXml.get(".favitem.appbranditem" + ".pkgtype"), 0);
                        amj.iconUrl = parseXml.get(".favitem.appbranditem" + ".iconurl");
                        amj.type = Util.getInt(parseXml.get(".favitem.appbranditem" + ".type"), 0);
                        amj.dCx = parseXml.get(".favitem.appbranditem" + ".pagepath");
                        amj.Lve = parseXml.get(".favitem.appbranditem" + ".sourcedisplayname");
                        amj.version = Util.getInt(parseXml.get(".favitem.appbranditem" + ".version"), 0);
                        amj.lyE = Util.getInt(parseXml.get(".favitem.appbranditem" + ".disableforward"), 0);
                        amj.leb = Util.getInt(parseXml.get(".favitem.appbranditem" + ".tradingguaranteeflag"), 0);
                        amj.eda = parseXml.get(".favitem.appbranditem" + ".messageextradata");
                        amj.subType = Util.getInt(parseXml.get(".favitem.appbranditem" + ".subtype"), 0);
                        anb.c(amj);
                    }
                    if (anb.IXu != null) {
                        anb.f(b.t(".favitem.weburlitem.appmsgshareitem", parseXml));
                    }
                    if (this.field_favProto.Lya != null) {
                        anh anh2 = this.field_favProto.Lya;
                        this.field_sourceId = anh2.Lyi;
                        this.field_sourceType = anh2.sourceType;
                        this.field_fromUser = anh2.dRL;
                        this.field_toUser = anh2.toUser;
                    }
                    this.field_edittime = this.field_favProto.rnM;
                    d.a(parseXml, this.field_tagProto);
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.FavItemInfo", e2, "", new Object[0]);
                    Log.e("MicroMsg.FavItemInfo", "klem , FavItemInfo exception:+%s", e2.toString());
                }
                AppMethodBeat.o(103375);
            }
        }
        return this;
    }

    public final void arR(String str) {
        AppMethodBeat.i(103376);
        a aVar = tah;
        aVar.log("----dump favitem from[" + str + "] beg----");
        aVar.log("type: " + this.field_type);
        aVar.log("favId: " + this.field_id);
        aVar.log("localId: " + this.field_localId);
        aVar.log("itemStatus: " + this.field_itemStatus);
        aVar.log("localSeq: " + this.field_localSeq);
        aVar.log("updateSeq: " + this.field_updateSeq);
        aVar.log("ctrlFlag: " + this.field_flag);
        aVar.log("sourceId: " + this.field_sourceId);
        aVar.log("sourceType: " + this.field_sourceType);
        aVar.log("sourceCreateTime: " + this.field_sourceCreateTime);
        aVar.log("updateTime: " + this.field_updateTime);
        aVar.log("editTime: " + this.field_edittime);
        aVar.log("fromuser: " + this.field_fromUser);
        aVar.log("toUser: " + this.field_toUser);
        aVar.log("realChatName: " + this.field_realChatName);
        if (this.field_favProto != null) {
            aVar.log("remarktime: " + this.field_favProto.LwZ);
            aVar.log("dataitemCount: " + this.field_favProto.ppH.size());
            if (this.field_favProto.Lya != null) {
                aVar.log(" ----source item----");
                anh anh = this.field_favProto.Lya;
                aVar.log("  sourceType: " + anh.sourceType);
                aVar.log("  fromUser: " + anh.dRL);
                aVar.log("  toUser: " + anh.toUser);
                aVar.log("  sourceId: " + anh.Lyi);
                aVar.log("  realChatName: " + anh.LxA);
                aVar.log("  createTime: " + anh.createTime);
                aVar.log("  msgId: " + anh.msgId);
                aVar.log("  eventId: " + anh.edD);
                aVar.log("  appId: " + anh.appId);
                aVar.log("  link: " + anh.link);
                aVar.log("  mediaId: " + anh.LxG);
                aVar.log("  brandId: " + anh.dCl);
            }
            Iterator<aml> it = this.field_favProto.ppH.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                aml next = it.next();
                int i3 = i2 + 1;
                aVar.log(" ----data item " + i2 + "----");
                aVar.log("  dataId: " + next.dLl);
                aVar.log("  dataType: " + next.dataType);
                aVar.log("  dataSouceId: " + next.LvV);
                aVar.log("  svrDataStatus: " + next.Lwd);
                aVar.log("  cdnThumbUrl: " + next.iwX);
                aVar.log("  cdnThumbKey: " + next.Lvk);
                aVar.log("  cdnDataUrl: " + next.KuR);
                aVar.log("  cdnDataKey: " + next.Lvp);
                aVar.log("  cdnEncryVer: " + next.Lvr);
                aVar.log("  fullmd5: " + next.LvE);
                aVar.log("  head256md5: " + next.LvG);
                aVar.log("  fullsize: " + next.LvI);
                aVar.log("  thumbMd5: " + next.LvP);
                aVar.log("  thumbHead256md5: " + next.LvR);
                aVar.log("  thumbfullsize: " + next.LvT);
                aVar.log("  duration: " + next.duration);
                aVar.log("  datafmt: " + next.LvC);
                aVar.log("  streamWebUrl: " + next.Lvu);
                aVar.log("  streamDataUrl: " + next.Lvw);
                aVar.log("  streamLowBandUrl: " + next.Lvy);
                aVar.log("  ext: " + next.dFN);
                aVar.log("  msgUuid: " + next.jsz);
                if (next.Lwh != null) {
                    aVar.log("  remarktime: " + next.Lwh.LwZ);
                    aVar.log("  ctrlflag: " + next.Lwh.Lxb);
                    aVar.log("  edittime: " + next.Lwh.rnM);
                    if (next.Lwh.LwO != null) {
                        aVar.log("   ----data source item----");
                        amn amn = next.Lwh.LwO;
                        aVar.log("    sourceType: " + amn.sourceType);
                        aVar.log("    fromUser: " + amn.dRL);
                        aVar.log("    toUser: " + amn.toUser);
                        aVar.log("    realChatName: " + amn.LxA);
                        aVar.log("    createTime: " + amn.createTime);
                        aVar.log("    msgId: " + amn.msgId);
                        aVar.log("    eventId: " + amn.edD);
                        aVar.log("    appId: " + amn.appId);
                        aVar.log("    link: " + amn.link);
                        aVar.log("    mediaId: " + amn.LxG);
                        aVar.log("    brandId: " + amn.dCl);
                    }
                    a("  ", aVar, next.Lwh.LwQ);
                    a("  ", aVar, next.Lwh.LwS);
                    a("  ", aVar, next.Lwh.LwU);
                    a("  ", aVar, next.Lwh.LwW);
                    a("  ", aVar, next.Lwh.KBr);
                }
                i2 = i3;
            }
            a("", aVar, this.field_favProto.LwQ);
            a("", aVar, this.field_favProto.LwS);
            a("", aVar, this.field_favProto.LwU);
            a("", aVar, this.field_favProto.LwW);
            a("  ", aVar, this.field_favProto.KBr);
        }
        aVar.log("----dump favitem end----");
        AppMethodBeat.o(103376);
    }

    private static void a(String str, a aVar, ank ank) {
        AppMethodBeat.i(103377);
        if (ank == null) {
            AppMethodBeat.o(103377);
            return;
        }
        aVar.log(str + " ----tv item----");
        aVar.log(str + "  title: " + ank.title);
        aVar.log(str + "  desc: " + ank.desc);
        aVar.log(str + "  thumbUrl: " + ank.thumbUrl);
        AppMethodBeat.o(103377);
    }

    private static void a(String str, a aVar, amv amv) {
        AppMethodBeat.i(103378);
        if (amv == null) {
            AppMethodBeat.o(103378);
            return;
        }
        aVar.log(str + " ----noteInfoItem item----");
        aVar.log(str + "  author: " + amv.LxT);
        aVar.log(str + "  editor: " + amv.LxU);
        AppMethodBeat.o(103378);
    }

    private static void a(String str, a aVar, ana ana) {
        AppMethodBeat.i(103379);
        if (ana == null) {
            AppMethodBeat.o(103379);
            return;
        }
        aVar.log(str + " ----product item----");
        aVar.log(str + "  title: " + ana.title);
        aVar.log(str + "  desc: " + ana.desc);
        aVar.log(str + "  thumbUrl: " + ana.thumbUrl);
        aVar.log(str + "  type: " + ana.type);
        AppMethodBeat.o(103379);
    }

    private static void a(String str, a aVar, ams ams) {
        AppMethodBeat.i(103380);
        if (ams == null) {
            AppMethodBeat.o(103380);
            return;
        }
        aVar.log(str + " ----loc item----");
        aVar.log(str + "  lng: " + ams.lng);
        aVar.log(str + "  lat: " + ams.lat);
        aVar.log(str + "  scale: " + ams.dRt);
        aVar.log(str + "  label: " + ams.label);
        aVar.log(str + "  poiname: " + ams.dWi);
        AppMethodBeat.o(103380);
    }

    private static void a(String str, a aVar, anq anq) {
        AppMethodBeat.i(103381);
        if (anq == null) {
            AppMethodBeat.o(103381);
            return;
        }
        aVar.log(str + " ----url item----");
        aVar.log(str + "  title: " + anq.title);
        aVar.log(str + "  desc: " + anq.desc);
        aVar.log(str + "  cleanUrl: " + anq.LyC);
        aVar.log(str + "  thumbUrl: " + anq.thumbUrl);
        aVar.log(str + "  opencache: " + anq.LyE);
        aVar.log(str + "  topstory: " + anq.LyH);
        AppMethodBeat.o(103381);
    }

    public final boolean arS(String str) {
        AppMethodBeat.i(103382);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(103382);
            return false;
        }
        Iterator<String> it = this.field_tagProto.Lyo.iterator();
        while (it.hasNext()) {
            if (str.equals(it.next())) {
                AppMethodBeat.o(103382);
                return false;
            }
        }
        this.field_tagProto.Lyo.add(str);
        AppMethodBeat.o(103382);
        return true;
    }

    public static String t(g gVar) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String sb;
        AppMethodBeat.i(103383);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<favitem");
        stringBuffer.append(" type='").append(gVar.field_type).append("'");
        stringBuffer.append(">");
        anb anb = gVar.field_favProto;
        StringBuilder sb2 = new StringBuilder();
        if (!Util.isNullOrNil(anb.title)) {
            sb2.append("<title>").append(Util.escapeStringForXml(anb.title)).append("</title>");
        }
        if (!Util.isNullOrNil(anb.desc)) {
            sb2.append("<desc>").append(Util.escapeStringForXml(anb.desc)).append("</desc>");
        }
        if (anb.rnM > 0) {
            sb2.append("<edittime>").append(anb.rnM).append("</edittime>");
        }
        if (anb.KBr != null && !Util.isNullOrNil(anb.KBr.LxU)) {
            sb2.append("<editusr>").append(anb.KBr.LxU).append("</editusr>");
        }
        if (!Util.isNullOrNil(anb.remark)) {
            sb2.append("<remark ");
            if (anb.LwZ > 0) {
                sb2.append(" time ='").append(anb.LwZ).append("'");
            }
            sb2.append(">").append(Util.escapeStringForXml(anb.remark)).append("</remark>");
        }
        if (anb.Lxc) {
            sb2.append("<ctrlflag>").append(anb.Lxb).append("</ctrlflag>");
        }
        if (anb.Lyd) {
            sb2.append("<version>").append(anb.version).append("</version>");
        } else if (gVar.field_type == 18) {
            sb2.append("<version>1</version>");
        }
        anh anh = anb.Lya;
        if (anh == null || anh.computeSize() == 0) {
            Log.w("MicroMsg.FavSourceItemParser", "klem toXml, source item empty");
            str = "";
        } else {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("<source");
            if (anh.Lxw) {
                stringBuffer2.append(" sourcetype='").append(anh.sourceType).append("'");
            }
            if (anh.Lyj) {
                stringBuffer2.append(" sourceid='").append(anh.Lyi).append("'");
            }
            stringBuffer2.append(">");
            if (anh.Lxx) {
                stringBuffer2.append("<fromusr>").append(Util.escapeStringForXml(anh.dRL)).append("</fromusr>");
            }
            if (anh.Lxy) {
                stringBuffer2.append("<tousr>").append(Util.escapeStringForXml(anh.toUser)).append("</tousr>");
            }
            if (anh.LxB) {
                stringBuffer2.append("<realchatname>").append(Util.escapeStringForXml(anh.LxA)).append("</realchatname>");
            }
            if (anh.LxC) {
                stringBuffer2.append("<msgid>").append(anh.msgId).append("</msgid>");
            }
            if (anh.LxD) {
                stringBuffer2.append("<eventid>").append(anh.edD).append("</eventid>");
            }
            if (anh.LxE) {
                stringBuffer2.append("<appid>").append(anh.appId).append("</appid>");
            }
            if (anh.LxF) {
                stringBuffer2.append("<link>").append(Util.escapeStringForXml(anh.link)).append("</link>");
            }
            if (anh.LxI) {
                stringBuffer2.append("<brandid>").append(Util.escapeStringForXml(anh.dCl)).append("</brandid>");
            }
            stringBuffer2.append("</source>");
            str = stringBuffer2.toString();
        }
        sb2.append(str);
        sb2.append(com.tencent.mm.plugin.fav.a.a.a.dE(anb.ppH));
        ams ams = gVar.field_favProto.LwQ;
        if (ams == null || ams.computeSize() == 0) {
            Log.d("MicroMsg.FavLocItemParser", "klem toXml, loc item empty");
            str2 = "";
        } else {
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append("<locitem>");
            if (ams.LxQ) {
                stringBuffer3.append("<label>").append(Util.escapeStringForXml(ams.label)).append("</label>");
            }
            if (ams.LxO) {
                stringBuffer3.append("<lat>").append(ams.lat).append("</lat>");
            }
            if (ams.LxN) {
                stringBuffer3.append("<lng>").append(ams.lng).append("</lng>");
            }
            if (ams.LxP) {
                stringBuffer3.append("<scale>").append(ams.dRt).append("</scale>");
            }
            if (ams.LxR) {
                stringBuffer3.append("<poiname>").append(ams.dWi).append("</poiname>");
            }
            stringBuffer3.append("</locitem>");
            str2 = stringBuffer3.toString();
        }
        sb2.append(str2);
        anq anq = gVar.field_favProto.LwS;
        if (anq == null || anq.computeSize() == 0) {
            Log.d("MicroMsg.FavUrlItemParser", "klem toXml, url item empty");
            str3 = "";
        } else {
            StringBuffer stringBuffer4 = new StringBuffer();
            stringBuffer4.append("<weburlitem>");
            if (anq.LyD) {
                stringBuffer4.append("<clean_url>").append(Util.escapeStringForXml(anq.LyC)).append("</clean_url>");
            }
            if (anq.Lvi) {
                stringBuffer4.append("<pagedesc>").append(Util.escapeStringForXml(anq.desc)).append("</pagedesc>");
            }
            if (anq.LxX) {
                stringBuffer4.append("<pagethumb_url>").append(Util.escapeStringForXml(anq.thumbUrl)).append("</pagethumb_url>");
            }
            if (anq.Lvh) {
                stringBuffer4.append("<pagetitle>").append(Util.escapeStringForXml(anq.title)).append("</pagetitle>");
            }
            if (anq.LyF) {
                stringBuffer4.append("<opencache>").append(anq.LyE).append("</opencache>");
            }
            if (anq.LyG) {
                stringBuffer4.append("<contentattr>").append(anq.contentattr).append("</contentattr>");
            }
            if (anq.Lws) {
                stringBuffer4.append("<canvasPageXml>").append(anq.canvasPageXml).append("</canvasPageXml>");
            }
            if (anq.LyI) {
                stringBuffer4.append("<wsVideoFlowXml>").append(Util.escapeStringForXml(anq.LyH)).append("</wsVideoFlowXml>");
            }
            stringBuffer4.append(b.a(gVar.field_favProto.IXu));
            stringBuffer4.append("</weburlitem>");
            str3 = stringBuffer4.toString();
        }
        sb2.append(str3);
        ana ana = gVar.field_favProto.LwU;
        if (ana == null || ana.computeSize() == 0) {
            Log.d("MicroMsg.FavProductItemParser", "klem toXml, product item empty");
            str4 = "";
        } else {
            StringBuffer stringBuffer5 = new StringBuffer();
            stringBuffer5.append("<productitem");
            if (ana.LxZ) {
                stringBuffer5.append(" type='").append(ana.type).append("'");
            }
            stringBuffer5.append(">");
            if (ana.Lvh) {
                stringBuffer5.append("<producttitle>").append(Util.escapeStringForXml(ana.title)).append("</producttitle>");
            }
            if (ana.Lvi) {
                stringBuffer5.append("<productdesc>").append(Util.escapeStringForXml(ana.desc)).append("</productdesc>");
            }
            if (ana.LxX) {
                stringBuffer5.append("<productthumb_url>").append(Util.escapeStringForXml(ana.thumbUrl)).append("</productthumb_url>");
            }
            if (ana.LxY) {
                stringBuffer5.append("<productinfo>").append(Util.escapeStringForXml(ana.info)).append("</productinfo>");
            }
            stringBuffer5.append("</productitem>");
            str4 = stringBuffer5.toString();
        }
        sb2.append(str4);
        ank ank = gVar.field_favProto.LwW;
        if (ank == null || ank.computeSize() == 0) {
            Log.d("MicroMsg.FavTVItemParser", "klem toXml, product item empty");
            str5 = "";
        } else {
            StringBuffer stringBuffer6 = new StringBuffer();
            stringBuffer6.append("<tvitem>");
            if (ank.Lvh) {
                stringBuffer6.append("<tvtitle>").append(Util.escapeStringForXml(ank.title)).append("</tvtitle>");
            }
            if (ank.Lvi) {
                stringBuffer6.append("<tvdesc>").append(Util.escapeStringForXml(ank.desc)).append("</tvdesc>");
            }
            if (ank.LxX) {
                stringBuffer6.append("<tvthumb_url>").append(Util.escapeStringForXml(ank.thumbUrl)).append("</tvthumb_url>");
            }
            if (ank.LxY) {
                stringBuffer6.append("<tvinfo>").append(Util.escapeStringForXml(ank.info)).append("</tvinfo>");
            }
            stringBuffer6.append("</tvitem>");
            str5 = stringBuffer6.toString();
        }
        sb2.append(str5);
        amv amv = anb.KBr;
        if (amv == null || amv.computeSize() == 0) {
            Log.w("MicroMsg.FavNoteInfoItemParser", "klem toXml, source item empty");
            str6 = "";
        } else {
            StringBuffer stringBuffer7 = new StringBuffer();
            stringBuffer7.append("<noteinfo>");
            stringBuffer7.append("<noteauthor>").append(Util.escapeStringForXml(amv.LxT)).append("</noteauthor>");
            stringBuffer7.append("<noteeditor>").append(Util.escapeStringForXml(amv.LxU)).append("</noteeditor>");
            stringBuffer7.append("</noteinfo>");
            str6 = stringBuffer7.toString();
        }
        sb2.append(str6);
        sb2.append(l.b(anb.Lxk));
        amj amj = gVar.field_favProto.Lxf;
        if (amj == null) {
            sb = "";
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("<appbranditem>");
            sb3.append("<username>").append(Util.escapeStringForXml(amj.username)).append("</username>");
            sb3.append("<appid>").append(Util.escapeStringForXml(amj.appId)).append("</appid>");
            sb3.append("<pkgtype>").append(amj.dMe).append("</pkgtype>");
            sb3.append("<iconurl>").append(Util.escapeStringForXml(amj.iconUrl)).append("</iconurl>");
            sb3.append("<type>").append(amj.type).append("</type>");
            sb3.append("<pagepath>").append(Util.escapeStringForXml(amj.dCx)).append("</pagepath>");
            sb3.append("<sourcedisplayname>").append(Util.escapeStringForXml(amj.Lve)).append("</sourcedisplayname>");
            sb3.append("<version>").append(amj.version).append("</version>");
            sb3.append("<disableforward>").append(amj.lyE).append("</disableforward>");
            sb3.append("<tradingguaranteeflag>").append(amj.leb).append("</tradingguaranteeflag>");
            sb3.append("<messageextradata>").append(String.format("<![CDATA[%s]]>", amj.eda)).append("</messageextradata>");
            sb3.append("<subtype>").append(amj.subType).append("</subtype>");
            sb3.append("</appbranditem>");
            sb = sb3.toString();
        }
        sb2.append(sb);
        stringBuffer.append(sb2.toString());
        stringBuffer.append(d.a(gVar.field_tagProto));
        stringBuffer.append("</favitem>");
        String stringBuffer8 = stringBuffer.toString();
        AppMethodBeat.o(103383);
        return stringBuffer8;
    }

    public final g cUC() {
        AppMethodBeat.i(103384);
        g gVar = new g();
        gVar.field_favProto = this.field_favProto;
        gVar.field_sourceId = this.field_sourceId;
        gVar.field_edittime = this.field_edittime;
        gVar.field_ext = this.field_ext;
        gVar.field_flag = this.field_flag;
        gVar.field_fromUser = this.field_fromUser;
        gVar.field_id = this.field_id;
        gVar.field_itemStatus = this.field_itemStatus;
        gVar.field_localId = this.field_localId;
        gVar.field_localSeq = this.field_localSeq;
        gVar.field_realChatName = this.field_realChatName;
        gVar.field_tagProto = this.field_tagProto;
        gVar.field_sourceCreateTime = this.field_sourceCreateTime;
        gVar.field_updateSeq = this.field_updateSeq;
        gVar.field_toUser = this.field_toUser;
        gVar.field_updateTime = this.field_updateTime;
        gVar.field_type = this.field_type;
        gVar.field_xml = this.field_xml;
        gVar.field_datatotalsize = this.field_datatotalsize;
        gVar.tad = this.tad;
        gVar.tae = this.tae;
        gVar.dLb = this.dLb;
        AppMethodBeat.o(103384);
        return gVar;
    }

    public final boolean cUD() {
        AppMethodBeat.i(103385);
        Iterator<aml> it = this.field_favProto.ppH.iterator();
        while (it.hasNext()) {
            if (it.next().Lwz != 0) {
                AppMethodBeat.o(103385);
                return true;
            }
        }
        AppMethodBeat.o(103385);
        return false;
    }
}
