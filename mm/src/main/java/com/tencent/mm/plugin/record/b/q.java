package com.tencent.mm.plugin.record.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a.e;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.fav.a.a.b;
import com.tencent.mm.plugin.i.a.ak;
import com.tencent.mm.plugin.i.a.l;
import com.tencent.mm.protocal.protobuf.amj;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.amm;
import com.tencent.mm.protocal.protobuf.amn;
import com.tencent.mm.protocal.protobuf.ams;
import com.tencent.mm.protocal.protobuf.ana;
import com.tencent.mm.protocal.protobuf.ank;
import com.tencent.mm.protocal.protobuf.anq;
import com.tencent.mm.protocal.protobuf.bci;
import com.tencent.mm.protocal.protobuf.bcl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.List;

public final class q {
    public static String dE(List<aml> list) {
        AppMethodBeat.i(9550);
        if (list == null || list.size() == 0) {
            Log.w("MicroMsg.RecordMsgParser", "klem toXml data list empty");
            AppMethodBeat.o(9550);
            return "";
        }
        int size = list.size();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<datalist count='").append(size).append("'>");
        for (int i2 = 0; i2 < size; i2++) {
            aml aml = list.get(i2);
            stringBuffer.append("<dataitem ");
            if (aml.LvB) {
                stringBuffer.append("datatype='").append(aml.dataType).append("'");
            }
            if (aml.Lwe) {
                stringBuffer.append(" datastatus='").append(aml.Lwd).append("'");
            }
            if (aml.LvK) {
                stringBuffer.append(" dataid='").append(aml.dLl).append("'");
            }
            if (aml.Lwq) {
                stringBuffer.append(" htmlid='").append(aml.Lwp).append("'");
            }
            if (aml.Lww) {
                stringBuffer.append(" dataillegaltype='").append(aml.Lwv).append("'");
            }
            if (aml.LvW) {
                stringBuffer.append(" datasourceid='").append(aml.LvV).append("'");
            }
            stringBuffer.append(">");
            if (aml.LvD) {
                stringBuffer.append("<datafmt>").append(aml.LvC).append("</datafmt>");
            }
            if (aml.Lvh) {
                stringBuffer.append("<datatitle>").append(Util.escapeStringForXml(aml.title)).append("</datatitle>");
            }
            if (aml.Lvi) {
                stringBuffer.append("<datadesc>").append(Util.escapeStringForXml(aml.desc)).append("</datadesc>");
            }
            if (aml.Lvj) {
                stringBuffer.append("<cdnthumburl>").append(Util.escapeStringForXml(aml.iwX)).append("</cdnthumburl>");
            }
            if (aml.Lvm) {
                stringBuffer.append("<thumbwidth>").append(aml.thumbWidth).append("</thumbwidth>");
            }
            if (aml.Lvn) {
                stringBuffer.append("<thumbheight>").append(aml.thumbHeight).append("</thumbheight>");
            }
            if (aml.Lvo) {
                stringBuffer.append("<cdndataurl>").append(Util.escapeStringForXml(aml.KuR)).append("</cdndataurl>");
            }
            if (aml.Lvl) {
                stringBuffer.append("<cdnthumbkey>").append(Util.escapeStringForXml(aml.Lvk)).append("</cdnthumbkey>");
            }
            if (aml.Lvq) {
                stringBuffer.append("<cdndatakey>").append(Util.escapeStringForXml(aml.Lvp)).append("</cdndatakey>");
            }
            if (aml.Lvs) {
                stringBuffer.append("<cdnencryver>").append(aml.Lvr).append("</cdnencryver>");
            }
            if (aml.Lvt) {
                stringBuffer.append("<duration>").append(aml.duration).append("</duration>");
            }
            if (aml.Lvv) {
                stringBuffer.append("<streamweburl>").append(Util.escapeStringForXml(aml.Lvu)).append("</streamweburl>");
            }
            if (aml.Lvx) {
                stringBuffer.append("<streamdataurl>").append(Util.escapeStringForXml(aml.Lvw)).append("</streamdataurl>");
            }
            if (aml.Lvz) {
                stringBuffer.append("<streamlowbandurl>").append(Util.escapeStringForXml(aml.Lvy)).append("</streamlowbandurl>");
            }
            if (aml.LvA) {
                stringBuffer.append("<dataext>").append(Util.escapeStringForXml(aml.dFN)).append("</dataext>");
            }
            if (aml.LvF) {
                stringBuffer.append("<fullmd5>").append(aml.LvE).append("</fullmd5>");
            }
            if (aml.LvH) {
                stringBuffer.append("<head256md5>").append(aml.LvG).append("</head256md5>");
            }
            if (aml.LvJ) {
                stringBuffer.append("<datasize>").append(aml.LvI).append("</datasize>");
            }
            if (aml.LvQ) {
                stringBuffer.append("<thumbfullmd5>").append(aml.LvP).append("</thumbfullmd5>");
            }
            if (aml.LvS) {
                stringBuffer.append("<thumbhead256md5>").append(aml.LvR).append("</thumbhead256md5>");
            }
            if (aml.LvU) {
                stringBuffer.append("<thumbsize>").append(aml.LvT).append("</thumbsize>");
            }
            if (aml.LvY) {
                stringBuffer.append("<streamvideoid>").append(Util.escapeStringForXml(aml.LvX)).append("</streamvideoid>");
            }
            if (aml.Lwg) {
                stringBuffer.append("<sourcetitle>").append(Util.escapeStringForXml(aml.Lwf)).append("</sourcetitle>");
            }
            if (aml.Lwk) {
                stringBuffer.append("<sourcename>").append(Util.escapeStringForXml(aml.Lwj)).append("</sourcename>");
            }
            if (aml.LwJ) {
                stringBuffer.append("<sourcedesc>").append(Util.escapeStringForXml(aml.LwI)).append("</sourcedesc>");
            }
            if (aml.LwL) {
                stringBuffer.append("<sourceheadurl>").append(Util.escapeStringForXml(aml.LwK)).append("</sourceheadurl>");
            }
            if (aml.Lwm) {
                stringBuffer.append("<sourcetime>").append(Util.escapeStringForXml(aml.Lwl)).append("</sourcetime>");
            }
            if (aml.Lwr) {
                stringBuffer.append("<statextstr>").append(Util.escapeStringForXml(aml.ean)).append("</statextstr>");
            }
            if (aml.LwM) {
                stringBuffer.append("<songalbumurl>").append(Util.escapeStringForXml(aml.songAlbumUrl)).append("</songalbumurl>");
            }
            if (aml.LwN) {
                stringBuffer.append("<songlyric>").append(Util.escapeStringForXml(aml.songLyric)).append("</songlyric>");
            }
            if (aml.Lwy) {
                stringBuffer.append("<recordxml>").append(aml.Lwx).append("</recordxml>");
            }
            if (aml.jsB) {
                stringBuffer.append("<messageuuid>").append(Util.escapeStringForXml(aml.jsz)).append("</messageuuid>");
            }
            amm amm = aml.Lwh;
            if (amm == null || amm.LwO == null || amm.LwO.computeSize() == 0) {
                Log.w("MicroMsg.RecordMsgParser", "klem toXml, data source item empty");
            } else {
                amn amn = amm.LwO;
                if (amn.LxE) {
                    stringBuffer.append("<appid>").append(amn.appId).append("</appid>");
                }
                if (amn.LxF) {
                    stringBuffer.append("<link>").append(Util.escapeStringForXml(amn.link)).append("</link>");
                }
                if (amn.LxI) {
                    stringBuffer.append("<brandid>").append(Util.escapeStringForXml(amn.dCl)).append("</brandid>");
                }
                if (!amn.Lxx || !amn.LxB) {
                    if (amn.Lxx) {
                        stringBuffer.append("<dataitemsource><fromusr>").append(Util.escapeStringForXml(amn.dRL)).append("</fromusr></dataitemsource>");
                    } else if (amn.LxB) {
                        stringBuffer.append("<dataitemsource><realchatname>").append(Util.escapeStringForXml(amn.LxA)).append("</realchatname></dataitemsource>");
                    }
                } else if (amn.dRL.equals(amn.LxA)) {
                    stringBuffer.append("<dataitemsource><fromusr>").append(Util.escapeStringForXml(amn.dRL)).append("</fromusr></dataitemsource>");
                } else if (ab.Eq(amn.dRL) || e.NF(amn.LxA)) {
                    stringBuffer.append("<dataitemsource><realchatname>").append(Util.escapeStringForXml(amn.LxA)).append("</realchatname></dataitemsource>");
                }
            }
            amm amm2 = aml.Lwh;
            if (amm2 == null || amm2.LwQ == null || amm2.LwQ.computeSize() == 0) {
                Log.w("MicroMsg.RecordMsgParser", "klem toXml, loc item empty");
            } else {
                ams ams = amm2.LwQ;
                stringBuffer.append("<locitem>");
                if (ams.LxQ) {
                    stringBuffer.append("<label>").append(Util.escapeStringForXml(ams.label)).append("</label>");
                }
                if (ams.LxO) {
                    stringBuffer.append("<lat>").append(ams.lat).append("</lat>");
                }
                if (ams.LxN) {
                    stringBuffer.append("<lng>").append(ams.lng).append("</lng>");
                }
                if (ams.LxP) {
                    stringBuffer.append("<scale>").append(ams.dRt).append("</scale>");
                }
                if (ams.LxR) {
                    stringBuffer.append("<poiname>").append(ams.dWi).append("</poiname>");
                }
                stringBuffer.append("</locitem>");
            }
            amm amm3 = aml.Lwh;
            if (amm3 == null || amm3.LwS == null || amm3.LwS.computeSize() == 0) {
                Log.w("MicroMsg.RecordMsgParser", "klem toXml, url item empty");
            } else {
                anq anq = amm3.LwS;
                stringBuffer.append("<weburlitem>");
                if (anq.LyD) {
                    stringBuffer.append("<link>").append(Util.escapeStringForXml(anq.LyC)).append("</link>");
                }
                if (anq.Lvi) {
                    stringBuffer.append("<desc>").append(Util.escapeStringForXml(anq.desc)).append("</desc>");
                }
                if (anq.LxX) {
                    stringBuffer.append("<thumburl>").append(Util.escapeStringForXml(anq.thumbUrl)).append("</thumburl>");
                }
                if (anq.Lvh) {
                    stringBuffer.append("<title>").append(Util.escapeStringForXml(anq.title)).append("</title>");
                }
                if (anq.LyF) {
                    stringBuffer.append("<opencache>").append(anq.LyE).append("</opencache>");
                }
                if (anq.LyG) {
                    stringBuffer.append("<contentattr>").append(anq.contentattr).append("</contentattr>");
                }
                if (amm3 == null || amm3.IXu == null) {
                    Log.d("MicroMsg.RecordMsgParser", "setMpMsgXml toXml, item empty");
                } else {
                    stringBuffer.append(b.a(amm3.IXu));
                }
                stringBuffer.append("</weburlitem>");
            }
            amm amm4 = aml.Lwh;
            if (amm4 == null || amm4.Lxk == null) {
                Log.i("MicroMsg.RecordMsgParser", "klem toXml, finder item empty");
            } else {
                stringBuffer.append(l.b(amm4.Lxk));
            }
            amm amm5 = aml.Lwh;
            if (amm5 == null || amm5.Lxm == null) {
                Log.i("MicroMsg.RecordMsgParser", "klem toXml, finder item empty");
            } else {
                stringBuffer.append(l.c(amm5.Lxm));
            }
            amm amm6 = aml.Lwh;
            if (amm6 == null || amm6.Lxu == null) {
                Log.i("MicroMsg.RecordMsgParser", "klem toXml, finder topic item empty");
            } else {
                bcl bcl = amm6.Lxu;
                StringBuilder sb = new StringBuilder();
                if (bcl != null) {
                    sb.append("<finderTopicShareItem><topic>").append(Util.escapeStringForXml(bcl.dST)).append("</topic><topicType>").append(bcl.tvC).append("</topicType><iconUrl>").append(XmlParser.getCDataWrapper(bcl.iconUrl)).append("</iconUrl><desc>").append(Util.escapeStringForXml(bcl.desc)).append("</desc><patMusicId>").append(Util.escapeStringForXml(bcl.LLC)).append("</patMusicId>");
                    if (bcl.LLB != null) {
                        sb.append("<location><poiClassifyId>").append(Util.escapeStringForXml(bcl.LLB.LIb)).append("</poiClassifyId><longitude>").append(bcl.LLB.dTj).append("</longitude><latitude>").append(bcl.LLB.latitude).append("</latitude></location>");
                    }
                    if (bcl.LLD != null) {
                        sb.append("<event><topicId>").append(bcl.LLD.LAp).append("</topicId><name>").append(Util.escapeStringForXml(bcl.LLD.LAq)).append("</name><creatorNickName>").append(Util.escapeStringForXml(bcl.LLD.LAr)).append("</creatorNickName></event>");
                    }
                    sb.append("</finderTopicShareItem>");
                }
                stringBuffer.append(sb.toString());
            }
            amm amm7 = aml.Lwh;
            if (amm7 == null || amm7.Lxo == null) {
                Log.i("MicroMsg.RecordMsgParser", "klem toXml, finder namecard item empty");
            } else {
                bci bci = amm7.Lxo;
                StringBuilder sb2 = new StringBuilder();
                if (bci != null) {
                    sb2.append("<finderShareNameCard><username>").append(Util.escapeStringForXml(bci.username)).append("</username><nickname>").append(Util.escapeStringForXml(bci.nickname)).append("</nickname><avatar>").append(XmlParser.getCDataWrapper(bci.uNR)).append("</avatar><authJob>").append(Util.escapeStringForXml(bci.wDX)).append("</authJob><authIcon>").append(bci.wDY).append("</authIcon></finderShareNameCard>");
                }
                stringBuffer.append(sb2.toString());
            }
            amm amm8 = aml.Lwh;
            if (amm8 == null || amm8.Lxq == null) {
                Log.i("MicroMsg.RecordMsgParser", "klem toXml, finder column item empty");
            } else {
                stringBuffer.append(l.b(amm8.Lxq));
            }
            amm amm9 = aml.Lwh;
            if (amm9 == null || amm9.Lxi == null) {
                Log.d("MicroMsg.RecordMsgParser", "setMpVideoXml toXml, item empty");
            } else {
                stringBuffer.append(b.b(amm9.Lxi));
            }
            amm amm10 = aml.Lwh;
            if (amm10 == null || amm10.LwU == null || amm10.LwU.computeSize() == 0) {
                Log.w("MicroMsg.RecordMsgParser", "klem toXml, product item empty");
            } else {
                ana ana = amm10.LwU;
                stringBuffer.append("<productitem");
                if (ana.LxZ) {
                    stringBuffer.append(" type='").append(ana.type).append("'");
                }
                stringBuffer.append(">");
                if (ana.Lvh) {
                    stringBuffer.append("<title>").append(Util.escapeStringForXml(ana.title)).append("</title>");
                }
                if (ana.Lvi) {
                    stringBuffer.append("<desc>").append(Util.escapeStringForXml(ana.desc)).append("</desc>");
                }
                if (ana.LxX) {
                    stringBuffer.append("<thumburl>").append(Util.escapeStringForXml(ana.thumbUrl)).append("</thumburl>");
                }
                if (ana.LxY) {
                    stringBuffer.append("<productinfo>").append(Util.escapeStringForXml(ana.info)).append("</productinfo>");
                }
                stringBuffer.append("</productitem>");
            }
            amm amm11 = aml.Lwh;
            if (amm11 == null || amm11.LwW == null || amm11.LwW.computeSize() == 0) {
                Log.w("MicroMsg.RecordMsgParser", "klem toXml, product item empty");
            } else {
                ank ank = amm11.LwW;
                stringBuffer.append("<tvitem>");
                if (ank.Lvh) {
                    stringBuffer.append("<title>").append(Util.escapeStringForXml(ank.title)).append("</title>");
                }
                if (ank.Lvi) {
                    stringBuffer.append("<desc>").append(Util.escapeStringForXml(ank.desc)).append("</desc>");
                }
                if (ank.LxX) {
                    stringBuffer.append("<thumburl>").append(Util.escapeStringForXml(ank.thumbUrl)).append("</thumburl>");
                }
                if (ank.LxY) {
                    stringBuffer.append("<tvinfo>").append(Util.escapeStringForXml(ank.info)).append("</tvinfo>");
                }
                stringBuffer.append("</tvitem>");
            }
            amm amm12 = aml.Lwh;
            if (amm12 == null || amm12.Lxf == null) {
                Log.e("MicroMsg.RecordMsgParser", "setAppBrandXml toXml, item empty");
            } else {
                amj amj = amm12.Lxf;
                if (amj != null) {
                    stringBuffer.append("<appbranditem>");
                    stringBuffer.append("<username>").append(Util.escapeStringForXml(amj.username)).append("</username>");
                    stringBuffer.append("<appid>").append(Util.escapeStringForXml(amj.appId)).append("</appid>");
                    stringBuffer.append("<pkgtype>").append(amj.dMe).append("</pkgtype>");
                    stringBuffer.append("<iconurl>").append(Util.escapeStringForXml(amj.iconUrl)).append("</iconurl>");
                    stringBuffer.append("<type>").append(amj.type).append("</type>");
                    stringBuffer.append("<pagepath>").append(Util.escapeStringForXml(amj.dCx)).append("</pagepath>");
                    stringBuffer.append("<sourcedisplayname>").append(Util.escapeStringForXml(amj.Lve)).append("</sourcedisplayname>");
                    stringBuffer.append("<version>").append(amj.version).append("</version>");
                    stringBuffer.append("<disableforward>").append(amj.lyE).append("</disableforward>");
                    stringBuffer.append("<tradingguaranteeflag>").append(amj.leb).append("</tradingguaranteeflag>");
                    stringBuffer.append("<messageextradata>").append(String.format("<![CDATA[%s]]>", amj.eda)).append("</messageextradata>");
                    stringBuffer.append("<subtype>").append(amj.subType).append("</subtype>");
                    stringBuffer.append("</appbranditem>");
                }
            }
            amm amm13 = aml.Lwh;
            if (amm13 == null || amm13.Lxs == null) {
                Log.w("MicroMsg.RecordMsgParser", "klem toXml, music item empty");
            } else {
                stringBuffer.append(ak.a(amm13.Lxs));
            }
            stringBuffer.append("</dataitem>");
        }
        stringBuffer.append("</datalist>");
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(9550);
        return stringBuffer2;
    }
}
