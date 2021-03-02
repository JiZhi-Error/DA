package com.tencent.mm.plugin.fav.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.i.a.ak;
import com.tencent.mm.plugin.i.a.l;
import com.tencent.mm.protocal.protobuf.amj;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.amm;
import com.tencent.mm.protocal.protobuf.amn;
import com.tencent.mm.protocal.protobuf.amo;
import com.tencent.mm.protocal.protobuf.ams;
import com.tencent.mm.protocal.protobuf.ana;
import com.tencent.mm.protocal.protobuf.ank;
import com.tencent.mm.protocal.protobuf.anq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;

public final class a {
    public static String dE(List<aml> list) {
        AppMethodBeat.i(103494);
        if (list == null || list.size() == 0) {
            Log.v("MicroMsg.FavDataItemParser", "klem toXml data list empty");
            AppMethodBeat.o(103494);
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
                stringBuffer.append(" htmlid='").append(Util.escapeStringForXml(aml.Lwp)).append("'");
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
                stringBuffer.append("<cdn_thumburl>").append(Util.escapeStringForXml(aml.iwX)).append("</cdn_thumburl>");
            }
            if (aml.Lvm) {
                stringBuffer.append("<thumb_width>").append(aml.thumbWidth).append("</thumb_width>");
            }
            if (aml.Lvn) {
                stringBuffer.append("<thumb_height>").append(aml.thumbHeight).append("</thumb_height>");
            }
            if (aml.Lvo) {
                stringBuffer.append("<cdn_dataurl>").append(Util.escapeStringForXml(aml.KuR)).append("</cdn_dataurl>");
            }
            if (aml.Lvl) {
                stringBuffer.append("<cdn_thumbkey>").append(Util.escapeStringForXml(aml.Lvk)).append("</cdn_thumbkey>");
            }
            if (aml.Lvq) {
                stringBuffer.append("<cdn_datakey>").append(Util.escapeStringForXml(aml.Lvp)).append("</cdn_datakey>");
            }
            if (aml.Lvs) {
                stringBuffer.append("<cdn_encryver>").append(aml.Lvr).append("</cdn_encryver>");
            }
            if (aml.Lvt) {
                stringBuffer.append("<duration>").append(aml.duration).append("</duration>");
            }
            if (aml.Lvv) {
                stringBuffer.append("<stream_weburl>").append(Util.escapeStringForXml(aml.Lvu)).append("</stream_weburl>");
            }
            if (aml.LwM) {
                stringBuffer.append("<songalbumurl>").append(Util.escapeStringForXml(aml.songAlbumUrl)).append("</songalbumurl>");
            }
            if (aml.LwN) {
                stringBuffer.append("<songlyric>").append(Util.escapeStringForXml(aml.songLyric)).append("</songlyric>");
            }
            if (aml.Lvx) {
                stringBuffer.append("<stream_dataurl>").append(Util.escapeStringForXml(aml.Lvw)).append("</stream_dataurl>");
            }
            if (aml.Lvz) {
                stringBuffer.append("<stream_lowbandurl>").append(Util.escapeStringForXml(aml.Lvy)).append("</stream_lowbandurl>");
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
                stringBuffer.append("<fullsize>").append(aml.LvI).append("</fullsize>");
            }
            if (aml.LvQ) {
                stringBuffer.append("<thumbfullmd5>").append(aml.LvP).append("</thumbfullmd5>");
            }
            if (aml.LvS) {
                stringBuffer.append("<thumbhead256md5>").append(aml.LvR).append("</thumbhead256md5>");
            }
            if (aml.LvU) {
                stringBuffer.append("<thumbfullsize>").append(aml.LvT).append("</thumbfullsize>");
            }
            if (aml.LvY) {
                stringBuffer.append("<stream_videoid>").append(Util.escapeStringForXml(aml.LvX)).append("</stream_videoid>");
            }
            if (aml.Lwg) {
                stringBuffer.append("<datasrctitle>").append(Util.escapeStringForXml(aml.Lwf)).append("</datasrctitle>");
            }
            if (aml.Lwk) {
                stringBuffer.append("<datasrcname>").append(Util.escapeStringForXml(aml.Lwj)).append("</datasrcname>");
            }
            if (aml.Lwm) {
                stringBuffer.append("<datasrctime>").append(Util.escapeStringForXml(aml.Lwl)).append("</datasrctime>");
            }
            if (aml.Lws && (aml.Lwh == null || aml.Lwh.LwS == null || aml.Lwh.LwS.computeSize() == 0)) {
                stringBuffer.append("<canvasPageXml>").append(Util.escapeStringForXml(aml.canvasPageXml)).append("</canvasPageXml>");
            }
            if (aml.Lwr) {
                stringBuffer.append("<statextstr>").append(Util.escapeStringForXml(aml.ean)).append("</statextstr>");
            }
            if (aml.Lwy) {
                stringBuffer.append("<recordxml>").append(aml.Lwx).append("</recordxml>");
            }
            if (aml.jsB) {
                stringBuffer.append("<messageuuid>").append(Util.escapeStringForXml(aml.jsz)).append("</messageuuid>");
            }
            amo amo = aml.Lwn;
            if (amo != null) {
                stringBuffer.append("<streamvideo>");
                stringBuffer.append("<streamvideourl>").append(Util.escapeStringForXml(amo.iyZ)).append("</streamvideourl>");
                stringBuffer.append("<streamvideototaltime>").append(amo.LxJ).append("</streamvideototaltime>");
                stringBuffer.append("<streamvideotitle>").append(Util.escapeStringForXml(amo.izb)).append("</streamvideotitle>");
                stringBuffer.append("<streamvideowording>").append(Util.escapeStringForXml(amo.izc)).append("</streamvideowording>");
                stringBuffer.append("<streamvideoweburl>").append(Util.escapeStringForXml(amo.izd)).append("</streamvideoweburl>");
                stringBuffer.append("<streamvideoaduxinfo>").append(Util.escapeStringForXml(amo.izf)).append("</streamvideoaduxinfo>");
                stringBuffer.append("<streamvideopublishid>").append(Util.escapeStringForXml(amo.izg)).append("</streamvideopublishid>");
                stringBuffer.append("</streamvideo>");
            }
            amm amm = aml.Lwh;
            if (amm == null || amm.LwO == null || amm.LwO.computeSize() == 0) {
                Log.v("MicroMsg.FavDataItemParser", "klem toXml, data source item empty");
            } else {
                amn amn = amm.LwO;
                stringBuffer.append("<dataitemsource");
                if (amn.Lxw) {
                    stringBuffer.append(" sourcetype='").append(amn.sourceType).append("'");
                }
                if (amn.Lxz) {
                    stringBuffer.append(" sourceid='").append(amn.Gah).append("'");
                }
                stringBuffer.append(">");
                if (amn.Lxx) {
                    stringBuffer.append("<fromusr>").append(Util.escapeStringForXml(amn.dRL)).append("</fromusr>");
                }
                if (amn.Lxy) {
                    stringBuffer.append("<tousr>").append(Util.escapeStringForXml(amn.toUser)).append("</tousr>");
                }
                if (amn.LxB) {
                    stringBuffer.append("<realchatname>").append(Util.escapeStringForXml(amn.LxA)).append("</realchatname>");
                }
                if (amn.LxC) {
                    stringBuffer.append("<msgid>").append(amn.msgId).append("</msgid>");
                }
                if (amn.LxD) {
                    stringBuffer.append("<eventid>").append(amn.edD).append("</eventid>");
                }
                if (amn.LxE) {
                    stringBuffer.append("<appid>").append(amn.appId).append("</appid>");
                }
                if (amn.LxF) {
                    stringBuffer.append("<link>").append(Util.escapeStringForXml(amn.link)).append("</link>");
                }
                if (amn.LxI) {
                    stringBuffer.append("<brandid>").append(Util.escapeStringForXml(amn.dCl)).append("</brandid>");
                }
                stringBuffer.append("</dataitemsource>");
            }
            amm amm2 = aml.Lwh;
            if (amm2 == null || amm2.LwQ == null || amm2.LwQ.computeSize() == 0) {
                Log.v("MicroMsg.FavDataItemParser", "klem toXml, loc item empty");
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
                Log.v("MicroMsg.FavDataItemParser", "klem toXml, url item empty");
            } else {
                anq anq = amm3.LwS;
                stringBuffer.append("<weburlitem>");
                if (anq.LyD) {
                    stringBuffer.append("<clean_url>").append(Util.escapeStringForXml(anq.LyC)).append("</clean_url>");
                }
                if (anq.Lvi) {
                    stringBuffer.append("<pagedesc>").append(Util.escapeStringForXml(anq.desc)).append("</pagedesc>");
                }
                if (anq.LxX) {
                    stringBuffer.append("<pagethumb_url>").append(Util.escapeStringForXml(anq.thumbUrl)).append("</pagethumb_url>");
                }
                if (anq.Lvh) {
                    stringBuffer.append("<pagetitle>").append(Util.escapeStringForXml(anq.title)).append("</pagetitle>");
                }
                if (anq.LyF) {
                    stringBuffer.append("<opencache>").append(anq.LyE).append("</opencache>");
                }
                if (anq.LyG) {
                    stringBuffer.append("<contentattr>").append(anq.contentattr).append("</contentattr>");
                }
                if (anq.Lws) {
                    stringBuffer.append("<canvasPageXml>").append(Util.escapeStringForXml(anq.canvasPageXml)).append("</canvasPageXml>");
                }
                if (anq.LyI) {
                    stringBuffer.append("<wsVideoFlowXml>").append(Util.escapeStringForXml(anq.LyH)).append("</wsVideoFlowXml>");
                }
                if (amm3 == null || amm3.IXu == null) {
                    Log.d("MicroMsg.FavDataItemParser", "setMpMsgXml toXml, item empty");
                } else {
                    stringBuffer.append(b.a(amm3.IXu));
                }
                stringBuffer.append("</weburlitem>");
            }
            amm amm4 = aml.Lwh;
            if (amm4 == null || amm4.Lxk == null) {
                Log.i("MicroMsg.FavDataItemParser", "klem toXml, finder item empty");
            } else {
                stringBuffer.append(l.b(amm4.Lxk));
            }
            amm amm5 = aml.Lwh;
            if (amm5 == null || amm5.Lxs == null) {
                Log.i("MicroMsg.FavDataItemParser", "klem toXml, music item empty");
            } else {
                stringBuffer.append(ak.a(amm5.Lxs));
            }
            amm amm6 = aml.Lwh;
            if (amm6 == null || amm6.Lxm == null) {
                Log.i("MicroMsg.FavDataItemParser", "klem toXml, finder live item empty");
            } else {
                stringBuffer.append(l.c(amm6.Lxm));
            }
            amm amm7 = aml.Lwh;
            if (amm7 == null || amm7.Lxu == null) {
                Log.i("MicroMsg.FavDataItemParser", "klem toXml, finder topic item empty");
            } else {
                stringBuffer.append(l.b(amm7.Lxu));
            }
            amm amm8 = aml.Lwh;
            if (amm8 == null || amm8.Lxi == null) {
                Log.d("MicroMsg.FavDataItemParser", "setMpVideoXml toXml, item empty");
            } else {
                stringBuffer.append(b.b(amm8.Lxi));
            }
            amm amm9 = aml.Lwh;
            if (amm9 == null || amm9.LwU == null || amm9.LwU.computeSize() == 0) {
                Log.v("MicroMsg.FavDataItemParser", "klem toXml, product item empty");
            } else {
                ana ana = amm9.LwU;
                stringBuffer.append("<productitem");
                if (ana.LxZ) {
                    stringBuffer.append(" type='").append(ana.type).append("'");
                }
                stringBuffer.append(">");
                if (ana.Lvh) {
                    stringBuffer.append("<producttitle>").append(Util.escapeStringForXml(ana.title)).append("</producttitle>");
                }
                if (ana.Lvi) {
                    stringBuffer.append("<productdesc>").append(Util.escapeStringForXml(ana.desc)).append("</productdesc>");
                }
                if (ana.LxX) {
                    stringBuffer.append("<productthumb_url>").append(Util.escapeStringForXml(ana.thumbUrl)).append("</productthumb_url>");
                }
                if (ana.LxY) {
                    stringBuffer.append("<productinfo>").append(Util.escapeStringForXml(ana.info)).append("</productinfo>");
                }
                stringBuffer.append("</productitem>");
            }
            amm amm10 = aml.Lwh;
            if (amm10 == null || amm10.LwW == null || amm10.LwW.computeSize() == 0) {
                Log.v("MicroMsg.FavDataItemParser", "klem toXml, product item empty");
            } else {
                ank ank = amm10.LwW;
                stringBuffer.append("<tvitem>");
                if (ank.Lvh) {
                    stringBuffer.append("<tvtitle>").append(Util.escapeStringForXml(ank.title)).append("</tvtitle>");
                }
                if (ank.Lvi) {
                    stringBuffer.append("<tvdesc>").append(Util.escapeStringForXml(ank.desc)).append("</tvdesc>");
                }
                if (ank.LxX) {
                    stringBuffer.append("<tvthumb_url>").append(Util.escapeStringForXml(ank.thumbUrl)).append("</tvthumb_url>");
                }
                if (ank.LxY) {
                    stringBuffer.append("<tvinfo>").append(Util.escapeStringForXml(ank.info)).append("</tvinfo>");
                }
                stringBuffer.append("</tvitem>");
            }
            amm amm11 = aml.Lwh;
            if (amm11 == null || amm11.Lxf == null) {
                Log.e("MicroMsg.FavDataItemParser", "setAppBrandXml toXml, item empty");
            } else {
                amj amj = amm11.Lxf;
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
            stringBuffer.append("</dataitem>");
        }
        stringBuffer.append("</datalist>");
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(103494);
        return stringBuffer2;
    }
}
