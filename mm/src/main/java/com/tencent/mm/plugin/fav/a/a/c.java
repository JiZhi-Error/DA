package com.tencent.mm.plugin.fav.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.i.a.ak;
import com.tencent.mm.plugin.i.a.l;
import com.tencent.mm.protocal.protobuf.amj;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.amm;
import com.tencent.mm.protocal.protobuf.amn;
import com.tencent.mm.protocal.protobuf.amo;
import com.tencent.mm.protocal.protobuf.ams;
import com.tencent.mm.protocal.protobuf.amt;
import com.tencent.mm.protocal.protobuf.ana;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.ank;
import com.tencent.mm.protocal.protobuf.anq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.io.ByteArrayInputStream;
import java.util.Map;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public final class c {
    public static anb c(anb anb) {
        AppMethodBeat.i(103500);
        if (anb == null) {
            AppMethodBeat.o(103500);
            return null;
        }
        anb anb2 = new anb();
        if (anb.Lyb) {
            anb2.a(anb.Lya);
        }
        if (anb.Lyc) {
            anb2.bH(anb.ppH);
        }
        if (anb.LwR) {
            anb2.d(anb.LwQ);
        }
        if (anb.LwT) {
            anb2.b(anb.LwS);
        }
        if (anb.LwY) {
            anb2.bhc(anb.remark);
        }
        if (anb.Lvh) {
            anb2.bhd(anb.title);
        }
        if (anb.Lvi) {
            anb2.bhe(anb.desc);
        }
        if (anb.Lxa) {
            anb2.My(anb.LwZ);
        }
        if (anb.Lxc) {
            anb2.ajk(anb.Lxb);
        }
        if (anb.LwV) {
            anb2.b(anb.LwU);
        }
        if (anb.Lxd) {
            anb2.Mz(anb.rnM);
        }
        if (anb.LwX) {
            anb2.b(anb.LwW);
        }
        if (anb.Lyd) {
            anb2.ajl(anb.version);
        }
        if (anb.Lxe) {
            anb2.a(anb.KBr);
        }
        if (anb.Lxg) {
            anb2.c(anb.Lxf);
        }
        if (anb.Lxh) {
            anb2.f(anb.IXu);
        }
        if (anb.Lxl) {
            anb2.d(anb.Lxk);
        }
        AppMethodBeat.o(103500);
        return anb2;
    }

    public static void a(String str, anb anb) {
        NodeList childNodes;
        AppMethodBeat.i(103499);
        anb.ppH.clear();
        try {
            Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new ByteArrayInputStream(str.getBytes())));
            parse.normalize();
            NodeList elementsByTagName = parse.getDocumentElement().getElementsByTagName("datalist");
            if (!(elementsByTagName == null || (childNodes = elementsByTagName.item(0).getChildNodes()) == null || childNodes.getLength() <= 0)) {
                int length = childNodes.getLength();
                for (int i2 = 0; i2 < length; i2++) {
                    Node item = childNodes.item(i2);
                    String nodeToString = XmlParser.nodeToString(item);
                    NodeList elementsByTagName2 = ((Element) item).getElementsByTagName("recordxml");
                    String nodeToString2 = (elementsByTagName2 == null || elementsByTagName2.getLength() <= 0) ? null : XmlParser.nodeToString(elementsByTagName2.item(0).getFirstChild());
                    Map<String, String> parseXml = nodeToString.trim().startsWith("<dataitem") ? XmlParser.parseXml(nodeToString, "dataitem", null) : null;
                    if (parseXml != null) {
                        aml aml = new aml();
                        aml.ajd(Util.getInt(parseXml.get(".dataitem" + ".$datatype"), 0));
                        aml.bgx(parseXml.get(".dataitem" + ".$datasourceid"));
                        aml.aje(Util.getInt(parseXml.get(".dataitem" + ".$datastatus"), 0));
                        aml.bgp(parseXml.get(".dataitem" + ".datafmt"));
                        aml.bgf(parseXml.get(".dataitem" + ".datatitle"));
                        aml.bgg(parseXml.get(".dataitem" + ".datadesc"));
                        aml.bgh(parseXml.get(".dataitem" + ".cdn_thumburl"));
                        aml.bgi(parseXml.get(".dataitem" + ".cdn_thumbkey"));
                        aml.aja(Util.getInt(parseXml.get(".dataitem" + ".thumb_width"), 0));
                        aml.ajb(Util.getInt(parseXml.get(".dataitem" + ".thumb_height"), 0));
                        aml.bgj(parseXml.get(".dataitem" + ".cdn_dataurl"));
                        aml.bgk(parseXml.get(".dataitem" + ".cdn_datakey"));
                        String str2 = parseXml.get(".dataitem" + ".duration");
                        if (str2 != null && str2.length() > 0) {
                            aml.ajc(Util.getInt(str2, 0));
                        }
                        aml.bgm(parseXml.get(".dataitem" + ".stream_dataurl"));
                        aml.bgn(parseXml.get(".dataitem" + ".stream_lowbandurl"));
                        aml.bgl(parseXml.get(".dataitem" + ".stream_weburl"));
                        aml.bgL(parseXml.get(".dataitem" + ".songalbumurl"));
                        aml.bgM(parseXml.get(".dataitem" + ".songlyric"));
                        aml.bgE(parseXml.get(".dataitem" + ".canvasPageXml"));
                        aml.bgq(parseXml.get(".dataitem" + ".fullmd5"));
                        aml.bgr(parseXml.get(".dataitem" + ".head256md5"));
                        String str3 = parseXml.get(".dataitem" + ".fullsize");
                        if (!Util.isNullOrNil(str3)) {
                            aml.Mu((long) Util.getInt(str3, 0));
                        }
                        aml.bgo(parseXml.get(".dataitem" + ".dataext"));
                        aml.bgv(parseXml.get(".dataitem" + ".thumbfullmd5"));
                        aml.bgw(parseXml.get(".dataitem" + ".thumbhead256md5"));
                        String str4 = parseXml.get(".dataitem" + ".thumbfullsize");
                        if (!Util.isNullOrNil(str4)) {
                            aml.Mv((long) Util.getInt(str4, 0));
                        }
                        aml.bgy(parseXml.get(".dataitem" + ".stream_videoid"));
                        String str5 = parseXml.get(".dataitem" + ".$dataid");
                        if (Util.isNullOrNil(str5) || str5.length() < 32) {
                            str5 = b.ds(aml.toString(), aml.dataType);
                        }
                        aml.bgs(str5);
                        aml.bgz(parseXml.get(".dataitem" + ".datasrctitle"));
                        aml.bgA(parseXml.get(".dataitem" + ".datasrcname"));
                        aml.bgB(parseXml.get(".dataitem" + ".datasrctime"));
                        aml.bgD(parseXml.get(".dataitem" + ".statextstr"));
                        aml.bgC(parseXml.get(".dataitem" + ".$htmlid"));
                        aml.ajf(Util.getInt(parseXml.get(".dataitem" + ".$dataillegaltype"), 0));
                        aml.bgN(parseXml.get(".dataitem" + ".messageuuid"));
                        if (nodeToString2 != null) {
                            aml.bgF(nodeToString2);
                        }
                        amo amo = new amo();
                        amo.iyZ = Util.nullAs(parseXml.get(".dataitem" + ".streamvideo.streamvideourl"), "");
                        amo.LxJ = Util.safeParseInt(parseXml.get(".dataitem" + ".streamvideo.streamvideototaltime"));
                        amo.izb = Util.nullAs(parseXml.get(".dataitem" + ".streamvideo.streamvideotitle"), "");
                        amo.izc = Util.nullAs(parseXml.get(".dataitem" + ".streamvideo.streamvideowording"), "");
                        amo.izd = Util.nullAs(parseXml.get(".dataitem" + ".streamvideo.streamvideoweburl"), "");
                        amo.izf = Util.nullAs(parseXml.get(".dataitem" + ".streamvideo.streamvideoaduxinfo"), "");
                        amo.izg = Util.nullAs(parseXml.get(".dataitem" + ".streamvideo.streamvideopublishid"), "");
                        aml.a(amo);
                        amm amm = new amm();
                        String str6 = ".dataitem" + ".dataitemsource";
                        if (!parseXml.containsKey(str6)) {
                            Log.v("MicroMsg.FavDataItemParser", "cur fav not contains %s", str6);
                        } else {
                            amn amn = new amn();
                            amn.ajh(Util.getInt(parseXml.get(str6 + ".$sourcetype"), 0));
                            amn.bgQ(parseXml.get(str6 + ".$sourceid"));
                            amn.bgO(parseXml.get(str6 + ".fromusr"));
                            amn.bgP(parseXml.get(str6 + ".tousr"));
                            amn.bgR(parseXml.get(str6 + ".realchatname"));
                            amn.Mx(Util.getLong(parseXml.get(str6 + ".createtime"), 0));
                            amn.bgS(parseXml.get(str6 + ".msgid"));
                            amn.edD = parseXml.get(str6 + ".eventid");
                            amn.LxD = true;
                            amn.bgT(parseXml.get(str6 + ".appid"));
                            amn.bgU(parseXml.get(str6 + ".link"));
                            amn.bgV(parseXml.get(str6 + ".brandid"));
                            amm.c(amn);
                        }
                        String str7 = ".dataitem" + ".locitem";
                        if (!parseXml.containsKey(str7)) {
                            Log.v("MicroMsg.FavDataItemParser", "cur fav not contains %s", str7);
                        } else {
                            ams ams = new ams();
                            if (!Util.isNullOrNil(parseXml.get(str7 + ".label"))) {
                                ams.bgW(parseXml.get(str7 + ".label"));
                            }
                            if (!Util.isNullOrNil(parseXml.get(str7 + ".poiname"))) {
                                ams.bgX(parseXml.get(str7 + ".poiname"));
                            }
                            String str8 = parseXml.get(str7 + ".lng");
                            if (!Util.isNullOrNil(str8)) {
                                ams.B(Util.getDouble(str8, 0.0d));
                            }
                            String str9 = parseXml.get(str7 + ".lat");
                            if (!Util.isNullOrNil(str9)) {
                                ams.C(Util.getDouble(str9, 0.0d));
                            }
                            String str10 = parseXml.get(str7 + ".scale");
                            if (!Util.isNullOrNil(str10)) {
                                if (str10.indexOf(46) != -1) {
                                    ams.aji(Util.getInt(str10.substring(0, str10.indexOf(46)), -1));
                                } else {
                                    ams.aji(Util.getInt(str10, -1));
                                }
                            }
                            amm.c(ams);
                        }
                        String str11 = ".dataitem" + ".weburlitem";
                        if (!parseXml.containsKey(str11)) {
                            Log.v("MicroMsg.FavDataItemParser", "cur fav not contains %s", str11);
                        } else {
                            anq anq = new anq();
                            anq.bhu(parseXml.get(str11 + ".clean_url"));
                            anq.bht(parseXml.get(str11 + ".pagedesc"));
                            anq.bhv(parseXml.get(str11 + ".pagethumb_url"));
                            anq.bhs(parseXml.get(str11 + ".pagetitle"));
                            anq.ajn(Util.getInt(parseXml.get(str11 + ".opencache"), 0));
                            anq.ajo(Util.getInt(parseXml.get(str11 + ".contentattr"), 0));
                            anq.bhw(parseXml.get(str11 + ".canvasPageXml"));
                            anq.bhx(parseXml.get(str11 + ".wsVideoFlowXml"));
                            amm.a(anq);
                        }
                        amm.c(l.x(".dataitem", parseXml));
                        amm.e(ak.C(".dataitem", parseXml));
                        amm.e(l.v(".dataitem", parseXml));
                        amm.c(l.z(".dataitem", parseXml));
                        String str12 = ".dataitem" + ".productitem";
                        if (!parseXml.containsKey(str12)) {
                            Log.v("MicroMsg.FavDataItemParser", "cur fav not contains %s", str12);
                        } else {
                            ana ana = new ana();
                            ana.bgY(parseXml.get(str12 + ".producttitle"));
                            ana.bgZ(parseXml.get(str12 + ".productdesc"));
                            ana.bha(parseXml.get(str12 + ".productthumb_url"));
                            ana.bhb(parseXml.get(str12 + ".productinfo"));
                            ana.ajj(Util.getInt(parseXml.get(str12 + ".$type"), 0));
                            amm.a(ana);
                        }
                        String str13 = ".dataitem" + ".tvitem";
                        if (!parseXml.containsKey(str13)) {
                            Log.v("MicroMsg.FavDataItemParser", "cur fav not contains %s", str13);
                        } else {
                            ank ank = new ank();
                            ank.bho(parseXml.get(str13 + ".tvtitle"));
                            ank.bhp(parseXml.get(str13 + ".tvdesc"));
                            ank.bhq(parseXml.get(str13 + ".tvthumb_url"));
                            ank.bhr(parseXml.get(str13 + ".tvinfo"));
                            amm.a(ank);
                        }
                        String str14 = ".dataitem" + ".appbranditem";
                        if (!parseXml.containsKey(str14)) {
                            Log.v("MicroMsg.FavDataItemParser", "cur fav not contains %s", str14);
                        } else {
                            amj amj = new amj();
                            amj.username = parseXml.get(str14 + ".username");
                            amj.appId = parseXml.get(str14 + ".appid");
                            amj.dMe = Util.getInt(parseXml.get(str14 + ".pkgtype"), 0);
                            amj.iconUrl = parseXml.get(str14 + ".iconurl");
                            amj.type = Util.getInt(parseXml.get(str14 + ".type"), 0);
                            amj.dCx = parseXml.get(str14 + ".pagepath");
                            amj.Lve = parseXml.get(str14 + ".sourcedisplayname");
                            amj.version = Util.getInt(parseXml.get(str14 + ".version"), 0);
                            amj.lyE = Util.getInt(parseXml.get(str14 + ".disableforward"), 0);
                            amj.leb = Util.getInt(parseXml.get(str14 + ".tradingguaranteeflag"), 0);
                            amj.eda = parseXml.get(str14 + ".messageextradata");
                            amj.subType = Util.getInt(parseXml.get(str14 + ".subtype"), 0);
                            amm.b(amj);
                        }
                        amt t = b.t(".dataitem" + ".weburlitem.appmsgshareitem", parseXml);
                        if (t != null) {
                            amm.d(t);
                        }
                        amt u = b.u(".dataitem" + ".favbrandmpvideo", parseXml);
                        if (u != null) {
                            amm.e(u);
                        }
                        aml.a(amm);
                        anb.ppH.add(aml);
                    }
                }
            }
            AppMethodBeat.o(103499);
        } catch (Exception e2) {
            Log.e("MicroMsg.FavProtoItemParser", "[parser] parseXML exception:%s", e2.toString());
            AppMethodBeat.o(103499);
        }
    }
}
