package com.tencent.mm.plugin.fav.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.SparseIntArray;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.e;
import com.tencent.mm.ag.k;
import com.tencent.mm.ag.w;
import com.tencent.mm.ag.y;
import com.tencent.mm.g.a.px;
import com.tencent.mm.g.a.rc;
import com.tencent.mm.g.a.xn;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.am;
import com.tencent.mm.model.z;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.f;
import com.tencent.mm.plugin.appbrand.service.q;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.protocal.protobuf.amj;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.amo;
import com.tencent.mm.protocal.protobuf.ams;
import com.tencent.mm.protocal.protobuf.amt;
import com.tencent.mm.protocal.protobuf.ana;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.anh;
import com.tencent.mm.protocal.protobuf.ank;
import com.tencent.mm.protocal.protobuf.anq;
import com.tencent.mm.protocal.protobuf.css;
import com.tencent.mm.protocal.protobuf.eeq;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import java.io.ByteArrayOutputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class l {
    public static void a(Context context, String str, String str2, g gVar, Runnable runnable) {
        AppMethodBeat.i(106900);
        LinkedList linkedList = new LinkedList();
        linkedList.add(gVar);
        a(context, str, str2, linkedList, runnable);
        AppMethodBeat.o(106900);
    }

    public static void a(final Context context, final String str, final String str2, final List<g> list, final Runnable runnable) {
        AppMethodBeat.i(106901);
        if (context == null) {
            Log.w("MicroMsg.FavSendLogic", "want to send fav msg, but context is null");
            MMHandlerThread.postToMainThread(runnable);
            AppMethodBeat.o(106901);
        } else if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.FavSendLogic", "want to send fav msg, but to user is null");
            MMHandlerThread.postToMainThread(runnable);
            AppMethodBeat.o(106901);
        } else if (list.isEmpty()) {
            Log.w("MicroMsg.FavSendLogic", "want to send fav msg, but info is null");
            MMHandlerThread.postToMainThread(runnable);
            AppMethodBeat.o(106901);
        } else {
            h.RTc.aX(new Runnable() {
                /* class com.tencent.mm.plugin.fav.ui.l.AnonymousClass1 */

                public final void run() {
                    String string;
                    String str;
                    css css;
                    AppMethodBeat.i(106886);
                    for (String str2 : Util.stringsToList(str.split(","))) {
                        for (g gVar : list) {
                            if (gVar != null) {
                                com.tencent.mm.plugin.report.service.h.INSTANCE.a(10925, Integer.valueOf(gVar.field_type), Integer.valueOf(gVar.field_id));
                                switch (gVar.field_type) {
                                    case 1:
                                        com.tencent.mm.plugin.messenger.a.g.eir().ad(str2, gVar.field_favProto.desc, ab.JG(str2));
                                        break;
                                    case 2:
                                        Iterator<aml> it = gVar.field_favProto.ppH.iterator();
                                        while (it.hasNext()) {
                                            aml next = it.next();
                                            com.tencent.mm.plugin.messenger.a.g.eir().a(context, str2, b.d(next), 0, "", "", 0, next.jsz);
                                        }
                                        break;
                                    case 4:
                                        l.b(context, str2, b.c(gVar));
                                        break;
                                    case 5:
                                        if (gVar == null) {
                                            Log.w("MicroMsg.FavSendLogic", "item info is null, send fav url fail, return");
                                            break;
                                        } else {
                                            aml c2 = b.c(gVar);
                                            anq anq = gVar.field_favProto.LwS;
                                            anh anh = gVar.field_favProto.Lya;
                                            k.b bVar = new k.b();
                                            if (anq != null) {
                                                bVar.title = anq.title;
                                                String str3 = anq.thumbUrl;
                                                if (Util.isNullOrNil(str3)) {
                                                    str3 = Util.nullAs(c2.dFN, "");
                                                }
                                                bVar.thumburl = str3;
                                            }
                                            if (Util.isNullOrNil(bVar.title)) {
                                                bVar.title = c2.title;
                                            }
                                            if (anq != null) {
                                                bVar.description = anq.desc;
                                            }
                                            if (Util.isNullOrNil(bVar.description)) {
                                                bVar.description = c2.desc;
                                            }
                                            if (gVar.field_favProto.LwS != null) {
                                                bVar.url = gVar.field_favProto.LwS.LyC;
                                            }
                                            if (anh != null && Util.isNullOrNil(bVar.url)) {
                                                bVar.url = anh.link;
                                            }
                                            if (gVar.tad && Util.isNullOrNil(bVar.url)) {
                                                bVar.url = c2.Lvu;
                                            }
                                            if (!Util.isNullOrNil(c2.canvasPageXml)) {
                                                bVar.canvasPageXml = c2.canvasPageXml;
                                            }
                                            bVar.action = "view";
                                            bVar.type = 5;
                                            bVar.eag = anh.dCl;
                                            if (gVar.field_favProto.IXu != null) {
                                                amt amt = gVar.field_favProto.IXu;
                                                e eVar = new e();
                                                eVar.iwc = amt.iwc;
                                                eVar.iwf = amt.iwf;
                                                if (Util.isNullOrNil(bVar.eag)) {
                                                    bVar.eag = amt.dHc;
                                                }
                                                if (amt.iwc == 5) {
                                                    eVar.vid = amt.vid;
                                                    eVar.iwd = amt.iwd;
                                                    eVar.duration = amt.duration;
                                                    eVar.videoWidth = amt.videoWidth;
                                                    eVar.videoHeight = amt.videoHeight;
                                                }
                                                bVar.a(eVar);
                                            }
                                            if (anq != null && !Util.isNullOrNil(anq.LyH)) {
                                                Map<String, String> parseXml = XmlParser.parseXml(anq.LyH, "websearch", null);
                                                aj ajVar = new aj();
                                                ajVar.IEy = parseXml.get(".websearch.relevant_vid");
                                                ajVar.IEz = parseXml.get(".websearch.relevant_expand");
                                                ajVar.IEA = parseXml.get(".websearch.relevant_pre_searchid");
                                                ajVar.IEB = parseXml.get(".websearch.relevant_shared_openid");
                                                ajVar.IEC = (long) Util.getInt(parseXml.get(".websearch.rec_category"), -1);
                                                ajVar.rCq = parseXml.get(".websearch.shareUrl");
                                                ajVar.msN = parseXml.get(".websearch.shareTitle");
                                                ajVar.xDQ = parseXml.get(".websearch.shareDesc");
                                                ajVar.IED = parseXml.get(".websearch.shareImgUrl");
                                                ajVar.IEE = parseXml.get(".websearch.shareString");
                                                ajVar.IEF = parseXml.get(".websearch.shareStringUrl");
                                                ajVar.source = parseXml.get(".websearch.source");
                                                ajVar.eby = parseXml.get(".websearch.sourceUrl");
                                                ajVar.IEG = parseXml.get(".websearch.strPlayCount");
                                                ajVar.IEH = parseXml.get(".websearch.titleUrl");
                                                ajVar.IEI = parseXml.get(".websearch.extReqParams");
                                                ajVar.IEJ = parseXml.get(".websearch.tagList");
                                                ajVar.IEK = Util.getLong(parseXml.get(".websearch.channelId"), -1);
                                                ajVar.thumbUrl = parseXml.get(".websearch.thumbUrl");
                                                ajVar.IEL = parseXml.get(".websearch.shareTag");
                                                bVar.a(ajVar);
                                            }
                                            bVar.ean = c2.ean;
                                            byte[] readFromFile = Util.readFromFile(b.a(c2));
                                            if (readFromFile == null) {
                                                if (anq == null) {
                                                    str = null;
                                                } else {
                                                    str = anq.thumbUrl;
                                                }
                                                if (Util.isNullOrNil(str)) {
                                                    str = Util.nullAs(c2.dFN, "");
                                                }
                                                readFromFile = Util.readFromFile(b.cUf() + com.tencent.mm.b.g.getMessageDigest(str.getBytes()));
                                            }
                                            String str4 = "fav_" + z.aTY() + "_" + gVar.field_id;
                                            String JX = ad.JX(str4);
                                            ad.b G = ad.aVe().G(JX, true);
                                            G.l("prePublishId", str4);
                                            G.l("preUsername", gVar.field_fromUser);
                                            G.l("sendAppMsgScene", 1);
                                            G.l("adExtStr", c2.ean);
                                            com.tencent.mm.plugin.messenger.a.g.eir().a(str2, readFromFile, k.b.a(bVar, null, null), JX);
                                            break;
                                        }
                                    case 6:
                                        ams ams = gVar.field_favProto.LwQ;
                                        StringBuilder sb = new StringBuilder();
                                        sb.append("<msg>");
                                        sb.append("<location ");
                                        sb.append("x=\"").append(ams.lat).append("\" ");
                                        sb.append("y=\"").append(ams.lng).append("\" ");
                                        sb.append("scale=\"").append(ams.dRt).append("\" ");
                                        sb.append("label=\"").append(Util.nullAs(ams.label, "")).append("\" ");
                                        sb.append("maptype=\"0\" ");
                                        sb.append("poiname=\"").append(Util.nullAs(ams.dWi, "")).append("\" ");
                                        sb.append("/>");
                                        sb.append("</msg>");
                                        com.tencent.mm.plugin.messenger.a.g.eir().ad(str2, sb.toString(), 48);
                                        break;
                                    case 7:
                                        Context context = context;
                                        aml c3 = b.c(gVar);
                                        WXMusicObject wXMusicObject = new WXMusicObject();
                                        wXMusicObject.musicUrl = c3.Lvu;
                                        wXMusicObject.musicDataUrl = c3.Lvw;
                                        wXMusicObject.musicLowBandUrl = c3.Lvy;
                                        wXMusicObject.musicLowBandDataUrl = c3.Lvy;
                                        wXMusicObject.songAlbumUrl = c3.songAlbumUrl;
                                        wXMusicObject.songLyric = c3.songLyric;
                                        WXMediaMessage wXMediaMessage = new WXMediaMessage();
                                        wXMediaMessage.mediaObject = wXMusicObject;
                                        wXMediaMessage.title = c3.title;
                                        wXMediaMessage.description = c3.desc;
                                        byte[] readFromFile2 = Util.readFromFile(b.a(c3));
                                        if (readFromFile2 == null) {
                                            readFromFile2 = Util.readFromFile(b.cUf() + com.tencent.mm.b.g.getMessageDigest(Util.nullAs(c3.dFN, "").getBytes()));
                                        }
                                        wXMediaMessage.thumbData = readFromFile2;
                                        String str5 = gVar.field_favProto.Lya.appId;
                                        ((com.tencent.mm.plugin.fav.a.ab) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.fav.a.ab.class)).a(wXMediaMessage, str5, am.a.iDo.r(context, str5), str2);
                                        break;
                                    case 8:
                                        l.a(str2, gVar, b.c(gVar));
                                        break;
                                    case 10:
                                        Context context2 = context;
                                        ana ana = gVar.field_favProto.LwU;
                                        px pxVar = new px();
                                        pxVar.dVZ.opType = 0;
                                        pxVar.dVZ.dWb = ana.info;
                                        pxVar.dVZ.context = context2;
                                        EventCenter.instance.publish(pxVar);
                                        if (!pxVar.dWa.dFE) {
                                            break;
                                        } else {
                                            byte[] readFromFile3 = Util.readFromFile(b.cUf() + com.tencent.mm.b.g.getMessageDigest(Util.nullAs(ana.thumbUrl, "").getBytes()));
                                            if (readFromFile3 == null) {
                                                readFromFile3 = Util.readFromFile(pxVar.dWa.thumbPath);
                                            }
                                            com.tencent.mm.plugin.messenger.a.g.eir().a(str2, readFromFile3, pxVar.dWa.dWc, null);
                                            break;
                                        }
                                    case 11:
                                        Context context3 = context;
                                        ana ana2 = gVar.field_favProto.LwU;
                                        px pxVar2 = new px();
                                        pxVar2.dVZ.opType = 1;
                                        pxVar2.dVZ.dWb = ana2.info;
                                        pxVar2.dVZ.context = context3;
                                        EventCenter.instance.publish(pxVar2);
                                        if (!pxVar2.dWa.dFE) {
                                            break;
                                        } else {
                                            byte[] readFromFile4 = Util.readFromFile(b.cUf() + com.tencent.mm.b.g.getMessageDigest(Util.nullAs(ana2.thumbUrl, "").getBytes()));
                                            if (readFromFile4 == null) {
                                                readFromFile4 = Util.readFromFile(pxVar2.dWa.thumbPath);
                                            }
                                            com.tencent.mm.plugin.messenger.a.g.eir().a(str2, readFromFile4, pxVar2.dWa.dWc, null);
                                            break;
                                        }
                                    case 14:
                                    case 18:
                                        Log.i("MicroMsg.FavSendLogic", "want send record, fav id %d", Integer.valueOf(gVar.field_id));
                                        a a2 = a.a(context, gVar);
                                        anb anb = new anb();
                                        try {
                                            Log.d("MicroMsg.FavSendLogic", "do clone fav proto item");
                                            anb.parseFrom(gVar.field_favProto.toByteArray());
                                        } catch (Exception e2) {
                                            Log.printErrStackTrace("MicroMsg.FavSendLogic", e2, "", new Object[0]);
                                            Log.e("MicroMsg.FavSendLogic", "clone fav proto item error: %s", e2.getMessage());
                                        }
                                        LinkedList<aml> linkedList = anb.ppH;
                                        int i2 = 0;
                                        Iterator<aml> it2 = linkedList.iterator();
                                        while (it2.hasNext()) {
                                            aml next2 = it2.next();
                                            if (!(next2.Lwh == null || next2.Lwh.Lxf == null || !c.a(next2.Lwh.Lxf))) {
                                                next2.ajd(1);
                                                next2.bgg(context.getString(R.string.x8));
                                                linkedList.set(i2, next2);
                                                anb.bH(linkedList);
                                            }
                                            i2++;
                                        }
                                        rc rcVar = new rc();
                                        rcVar.dXF.type = 2;
                                        rcVar.dXF.toUser = str2;
                                        rcVar.dXF.dXI = anb;
                                        rcVar.dXF.title = a2.title;
                                        rcVar.dXF.desc = a2.desc;
                                        rcVar.dXF.thumbPath = a2.thumbPath;
                                        rcVar.dXF.dXL = a2.tfO;
                                        EventCenter.instance.publish(rcVar);
                                        break;
                                    case 15:
                                        Context context4 = context;
                                        ank ank = gVar.field_favProto.LwW;
                                        xn xnVar = new xn();
                                        xnVar.edL.opType = 0;
                                        xnVar.edL.edN = ank.info;
                                        xnVar.edL.context = context4;
                                        EventCenter.instance.publish(xnVar);
                                        Log.d("MicroMsg.FavSendLogic", "sendFavTV ret = [%s], thumbUrl = [%s]", Boolean.valueOf(xnVar.edM.dFE), ank.thumbUrl);
                                        if (!xnVar.edM.dFE) {
                                            break;
                                        } else {
                                            byte[] readFromFile5 = Util.readFromFile(b.cUf() + com.tencent.mm.b.g.getMessageDigest(Util.nullAs(ank.thumbUrl, "").getBytes()));
                                            if (readFromFile5 == null) {
                                                readFromFile5 = Util.readFromFile(xnVar.edM.thumbPath);
                                            }
                                            com.tencent.mm.plugin.messenger.a.g.eir().a(str2, readFromFile5, xnVar.edM.dWc, null);
                                            break;
                                        }
                                    case 16:
                                        l.a(context, str2, b.c(gVar));
                                        break;
                                    case 17:
                                        String str6 = b.c(gVar).desc;
                                        com.tencent.mm.plugin.messenger.a.g.eir().ad(str2, str6, as.bjp(ca.a.bkA(str6).dkU) ? 66 : 42);
                                        break;
                                    case 19:
                                        if (gVar.field_type == 19) {
                                            if (c.a(gVar.field_favProto.Lxf)) {
                                                Log.e("MicroMsg.FavAppBrandLogic", "not expect branch for ban forward");
                                                break;
                                            } else {
                                                amj amj = gVar.field_favProto.Lxf;
                                                WxaAttributes Xk = ((q) com.tencent.mm.kernel.g.af(q.class)).Xk(amj.username);
                                                if (Xk != null) {
                                                    string = Xk.field_nickname;
                                                } else {
                                                    string = MMApplicationContext.getContext().getString(R.string.a0f);
                                                }
                                                k.b bVar2 = new k.b();
                                                bVar2.title = gVar.field_favProto.title;
                                                bVar2.description = gVar.field_favProto.title;
                                                bVar2.izi = amj.username;
                                                bVar2.izh = amj.dCx;
                                                bVar2.izj = amj.appId;
                                                bVar2.izz = amj.dMe;
                                                bVar2.izA = amj.version;
                                                bVar2.izk = 2;
                                                bVar2.izr = amj.lyE;
                                                bVar2.url = ((f) com.tencent.mm.kernel.g.af(f.class)).Ur(amj.appId);
                                                bVar2.izB = amj.iconUrl;
                                                bVar2.eam = "wxapp_" + amj.appId + amj.dCx;
                                                bVar2.eag = amj.username;
                                                bVar2.eah = string;
                                                com.tencent.mm.ag.a aVar = new com.tencent.mm.ag.a();
                                                aVar.ivc = amj.leb;
                                                aVar.ive = amj.eda;
                                                aVar.ivf = amj.subType;
                                                bVar2.a(aVar);
                                                bVar2.type = 33;
                                                byte[] bArr = new byte[0];
                                                Bitmap a3 = o.a(b.c(gVar), gVar);
                                                if (a3 == null || a3.isRecycled()) {
                                                    Log.e("MicroMsg.FavAppBrandLogic", "thumb image is null");
                                                } else {
                                                    Log.i("MicroMsg.FavAppBrandLogic", "thumb image is not null ");
                                                    Bitmap createBitmap = Bitmap.createBitmap(a3.getWidth(), a3.getHeight(), Bitmap.Config.ARGB_8888);
                                                    Canvas canvas = new Canvas(createBitmap);
                                                    canvas.drawColor(-1);
                                                    canvas.drawBitmap(a3, 0.0f, 0.0f, (Paint) null);
                                                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                                    createBitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
                                                    bArr = byteArrayOutputStream.toByteArray();
                                                    Log.i("MicroMsg.FavAppBrandLogic", "bitmap recycle %s", createBitmap);
                                                    createBitmap.recycle();
                                                }
                                                w.a.aSz().a(bVar2, amj.appId, "", str2, "", bArr);
                                                break;
                                            }
                                        } else {
                                            Log.e("MicroMsg.FavAppBrandLogic", "not expect type:%d", Integer.valueOf(gVar.field_type));
                                            break;
                                        }
                                    case 20:
                                        f fVar = f.teu;
                                        f.a(str2, gVar);
                                        break;
                                    case 21:
                                        Context context5 = context;
                                        aml c4 = b.c(gVar);
                                        WXMusicObject wXMusicObject2 = new WXMusicObject();
                                        wXMusicObject2.musicUrl = c4.Lvu;
                                        wXMusicObject2.musicDataUrl = c4.Lvw;
                                        wXMusicObject2.musicLowBandUrl = c4.Lvy;
                                        wXMusicObject2.musicLowBandDataUrl = c4.Lvy;
                                        wXMusicObject2.songAlbumUrl = c4.songAlbumUrl;
                                        wXMusicObject2.songLyric = c4.songLyric;
                                        WXMediaMessage wXMediaMessage2 = new WXMediaMessage();
                                        wXMediaMessage2.mediaObject = wXMusicObject2;
                                        wXMediaMessage2.title = c4.title;
                                        wXMediaMessage2.description = c4.desc;
                                        byte[] readFromFile6 = Util.readFromFile(b.a(c4));
                                        if (readFromFile6 == null) {
                                            readFromFile6 = Util.readFromFile(b.cUf() + com.tencent.mm.b.g.getMessageDigest(Util.nullAs(c4.dFN, "").getBytes()));
                                        }
                                        wXMediaMessage2.thumbData = readFromFile6;
                                        String str7 = gVar.field_favProto.Lya.appId;
                                        String r = am.a.iDo.r(context5, str7);
                                        k.b bVar3 = new k.b();
                                        bVar3.title = c4.title;
                                        bVar3.description = c4.desc;
                                        bVar3.url = c4.Lvu;
                                        bVar3.iwH = c4.Lvy;
                                        bVar3.ixd = c4.Lvw;
                                        bVar3.ixe = c4.Lvy;
                                        bVar3.appId = str7;
                                        bVar3.type = 76;
                                        bVar3.appName = r;
                                        bVar3.iwL = 3;
                                        if (!(c4 == null || c4.Lwh == null || (css = c4.Lwh.Lxs) == null)) {
                                            com.tencent.mm.pluginsdk.ui.tools.b bVar4 = new com.tencent.mm.pluginsdk.ui.tools.b();
                                            bVar4.songAlbumUrl = c4.songAlbumUrl;
                                            bVar4.songLyric = c4.songLyric;
                                            bVar4.Ktn = css.Ktn;
                                            bVar4.Kto = css.Kto;
                                            bVar4.Ktp = css.Ktp;
                                            bVar4.Ktq = css.Ktq;
                                            bVar4.Ktr = css.singerName;
                                            bVar4.Kts = css.albumName;
                                            bVar4.Ktt = css.musicGenre;
                                            bVar4.Ktu = String.valueOf(css.issueDate);
                                            bVar4.Ktv = css.identification;
                                            bVar4.Alz = css.Alz;
                                            bVar4.Ktw = css.extraInfo;
                                            bVar3.a(bVar4);
                                        }
                                        ((com.tencent.mm.plugin.fav.a.ab) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.fav.a.ab.class)).a(bVar3, wXMediaMessage2, str2);
                                        break;
                                }
                            } else {
                                Log.e("MicroMsg.FavSendLogic", "in run workerThread,want to send fav msg, but info is null,infos.size = %d", Integer.valueOf(list.size()));
                            }
                        }
                        if (!Util.isNullOrNil(str2)) {
                            com.tencent.mm.plugin.messenger.a.g.eir().ad(str2, str2, ab.JG(str2));
                        }
                    }
                    MMHandlerThread.postToMainThread(runnable);
                    AppMethodBeat.o(106886);
                }

                public final String toString() {
                    AppMethodBeat.i(106887);
                    String str = super.toString() + "|sendFavMsg";
                    AppMethodBeat.o(106887);
                    return str;
                }
            });
            AppMethodBeat.o(106901);
        }
    }

    public static boolean j(aml aml) {
        AppMethodBeat.i(106902);
        if (aml == null || Util.isNullOrNil(aml.LvC) || (!Util.isEqual(aml.LvC, ".htm") && !Util.isEqual(aml.LvC, "htm"))) {
            AppMethodBeat.o(106902);
            return false;
        }
        AppMethodBeat.o(106902);
        return true;
    }

    public static class a {
        public String desc;
        public String tfO;
        public String thumbPath;
        public String title;

        private static boolean asq(String str) {
            AppMethodBeat.i(106895);
            boolean exists = new o(str).exists();
            AppMethodBeat.o(106895);
            return exists;
        }

        private static String a(ams ams) {
            AppMethodBeat.i(106896);
            if (ams == null) {
                Log.i("MicroMsg.FavSendLogic", "getLabel but locItem is null");
                AppMethodBeat.o(106896);
                return "";
            }
            String str = ams.label;
            AppMethodBeat.o(106896);
            return str;
        }

        private static String b(ams ams) {
            AppMethodBeat.i(106897);
            if (ams == null) {
                Log.i("MicroMsg.FavSendLogic", "getPoiname but locItem is null");
                AppMethodBeat.o(106897);
                return "";
            }
            String str = ams.dWi;
            AppMethodBeat.o(106897);
            return str;
        }

        public static a a(Context context, g gVar) {
            boolean z;
            boolean z2;
            String str;
            boolean z3;
            AppMethodBeat.i(106898);
            if (gVar.field_type == 18) {
                a aVar = new a();
                SparseIntArray sparseIntArray = new SparseIntArray();
                if (gVar.field_type == 18) {
                    aVar.title = gVar.field_favProto.title;
                }
                boolean z4 = false;
                LinkedList linkedList = new LinkedList();
                boolean z5 = false;
                for (aml aml : gVar.field_favProto.ppH) {
                    if (gVar.field_type != 18 || !l.j(aml)) {
                        sparseIntArray.put(aml.dataType, sparseIntArray.get(aml.dataType) + 1);
                        switch (aml.dataType) {
                            case 1:
                                if (linkedList.size() < 4) {
                                    String str2 = aml.desc;
                                    if (!Util.isNullOrNil(str2)) {
                                        linkedList.add(str2.replaceAll("&lt;", "<").replaceAll("&gt;", ">") + "\n");
                                        break;
                                    } else {
                                        break;
                                    }
                                } else {
                                    continue;
                                }
                            case 2:
                                if (!z5) {
                                    String a2 = b.a(aml);
                                    if (asq(a2)) {
                                        aVar.thumbPath = a2;
                                        z5 = true;
                                        break;
                                    } else {
                                        aVar.thumbPath = b.d(aml);
                                        z5 = true;
                                        break;
                                    }
                                } else {
                                    continue;
                                }
                            case 3:
                                if (linkedList.size() < 4) {
                                    linkedList.add(context.getString(R.string.zz) + context.getString(R.string.c8p, Integer.valueOf((int) b.DO((long) aml.duration))) + "\n");
                                    break;
                                } else {
                                    continue;
                                }
                            case 4:
                                if (linkedList.size() < 4) {
                                    linkedList.add(context.getString(R.string.zv) + "\n");
                                    break;
                                } else {
                                    continue;
                                }
                            case 6:
                                if (linkedList.size() < 4) {
                                    ams ams = aml.Lwh.LwQ;
                                    linkedList.add(context.getString(R.string.we) + ((Util.isNullOrNil(b(ams)) || b(ams).equals(context.getString(R.string.el9))) ? a(ams) : b(ams)) + "\n");
                                }
                                if (!z4) {
                                    z4 = true;
                                    break;
                                } else {
                                    continue;
                                }
                            case 8:
                                if (linkedList.size() < 4) {
                                    linkedList.add(context.getString(R.string.ve) + aml.title + "\n");
                                }
                                if (!z4) {
                                    z4 = true;
                                    break;
                                } else {
                                    continue;
                                }
                            case 17:
                                if (linkedList.size() < 4) {
                                    linkedList.add(context.getString(R.string.yc) + "\n");
                                    break;
                                } else {
                                    continue;
                                }
                            case 19:
                                if (linkedList.size() < 4) {
                                    linkedList.add(context.getString(R.string.hc) + aml.title + "\n");
                                    break;
                                } else {
                                    continue;
                                }
                        }
                    }
                }
                String str3 = "";
                aVar.desc = "";
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    str3 = str3 + ((String) it.next());
                }
                String trim = str3.trim();
                if (linkedList.size() >= 4) {
                    trim = trim + "...";
                }
                aVar.desc = trim;
                if (aVar.title == null) {
                    aVar.title = "";
                }
                AppMethodBeat.o(106898);
                return aVar;
            }
            a aVar2 = new a();
            SparseIntArray sparseIntArray2 = new SparseIntArray();
            if (gVar.field_type == 14) {
                aVar2.title = gVar.field_favProto.title;
            }
            LinkedList linkedList2 = new LinkedList();
            boolean z6 = false;
            for (aml aml2 : gVar.field_favProto.ppH) {
                sparseIntArray2.put(aml2.dataType, sparseIntArray2.get(aml2.dataType) + 1);
                switch (aml2.dataType) {
                    case 1:
                        if (linkedList2.size() < 4) {
                            linkedList2.add(aml2.Lwj + ":" + aml2.desc + "\n");
                            break;
                        } else {
                            break;
                        }
                    case 2:
                        if (linkedList2.size() < 4) {
                            linkedList2.add(aml2.Lwj + ":" + context.getString(R.string.xr) + "\n");
                        }
                        if (!z6) {
                            String a3 = b.a(aml2);
                            if (asq(a3)) {
                                aVar2.thumbPath = a3;
                                z3 = true;
                            } else {
                                z3 = z6;
                            }
                            z6 = z3;
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        if (linkedList2.size() < 4) {
                            linkedList2.add(aml2.Lwj + ":" + context.getString(R.string.zz) + context.getString(R.string.c8p, Integer.valueOf((int) b.AO((long) aml2.duration))) + "\n");
                            break;
                        } else {
                            break;
                        }
                    case 4:
                        if (linkedList2.size() < 4) {
                            linkedList2.add(aml2.Lwj + ":" + context.getString(R.string.zv) + "\n");
                        }
                        if (!z6) {
                            String a4 = b.a(aml2);
                            if (asq(a4)) {
                                aVar2.thumbPath = a4;
                                z = true;
                            } else {
                                z = z6;
                            }
                            z6 = z;
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        if (linkedList2.size() < 4) {
                            linkedList2.add(aml2.Lwj + ":" + context.getString(R.string.zp) + aml2.title + "\n");
                        }
                        if (!z6) {
                            String a5 = b.a(aml2);
                            if (asq(a5)) {
                                aVar2.thumbPath = a5;
                            } else {
                                anq anq = aml2.Lwh.LwS;
                                if (anq == null) {
                                    str = "";
                                } else {
                                    str = anq.thumbUrl;
                                }
                                if (Util.isNullOrNil(str)) {
                                    str = Util.nullAs(aml2.dFN, "");
                                }
                                a(aVar2, str);
                            }
                            z6 = true;
                            break;
                        } else {
                            break;
                        }
                    case 6:
                        if (linkedList2.size() < 4) {
                            ams ams2 = aml2.Lwh.LwQ;
                            linkedList2.add(aml2.Lwj + ":" + context.getString(R.string.we) + ((Util.isNullOrNil(b(ams2)) || b(ams2).equals(context.getString(R.string.el9))) ? a(ams2) : b(ams2)) + "\n");
                        }
                        if (!z6) {
                            z6 = true;
                            break;
                        } else {
                            break;
                        }
                        break;
                    case 7:
                    case 29:
                        if (linkedList2.size() < 4) {
                            linkedList2.add(aml2.Lwj + ":" + context.getString(R.string.wv) + aml2.title + "\n");
                        }
                        if (!z6) {
                            a(aVar2, aml2.dFN);
                            z6 = true;
                            break;
                        } else {
                            break;
                        }
                    case 8:
                        if (linkedList2.size() < 4) {
                            linkedList2.add(aml2.Lwj + ":" + context.getString(R.string.ve) + aml2.title + "\n");
                        }
                        if (!z6) {
                            z6 = true;
                            break;
                        } else {
                            break;
                        }
                    case 10:
                    case 11:
                        if (linkedList2.size() < 4) {
                            linkedList2.add(aml2.Lwj + ":" + context.getString(R.string.xz) + aml2.Lwh.LwU.title + "\n");
                        }
                        if (z6) {
                            break;
                        } else {
                            ana ana = aml2.Lwh.LwU;
                            if (ana != null) {
                                a(aVar2, ana.thumbUrl);
                            }
                            z6 = true;
                            break;
                        }
                    case 14:
                        if (linkedList2.size() < 4) {
                            linkedList2.add(aml2.Lwj + ":" + context.getString(R.string.hb) + "\n");
                        }
                        if (z6) {
                            break;
                        } else {
                            ank ank = aml2.Lwh.LwW;
                            if (ank != null) {
                                a(aVar2, ank.thumbUrl);
                            }
                            z6 = true;
                            break;
                        }
                    case 15:
                        if (linkedList2.size() < 4) {
                            linkedList2.add(aml2.Lwj + ":" + context.getString(R.string.z1) + "\n");
                        }
                        if (!z6) {
                            String a6 = b.a(aml2);
                            if (asq(a6)) {
                                aVar2.thumbPath = a6;
                                z2 = true;
                            } else {
                                z2 = z6;
                            }
                            z6 = z2;
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        if (linkedList2.size() < 4) {
                            linkedList2.add(aml2.Lwj + ":" + context.getString(R.string.vp) + "\n");
                        }
                        if (!z6) {
                            aVar2.tfO = ((com.tencent.mm.plugin.messenger.foundation.a.l) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().aEK(aml2.desc).dkU;
                            z6 = true;
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        if (linkedList2.size() < 4) {
                            linkedList2.add(aml2.Lwj + ":" + context.getString(R.string.yc) + "\n");
                            break;
                        } else {
                            break;
                        }
                    case 19:
                        if (linkedList2.size() < 4) {
                            if (aml2.Lwh.Lxf == null || aml2.Lwh.Lxf.type != 3) {
                                linkedList2.add(aml2.Lwj + ":" + context.getString(R.string.hc) + aml2.title + "\n");
                                break;
                            } else {
                                linkedList2.add(aml2.Lwj + ":" + context.getString(R.string.x8) + "\n");
                                break;
                            }
                        } else {
                            break;
                        }
                        break;
                    case 22:
                    case 26:
                    case 27:
                    case 28:
                        if (!b.cUq() && linkedList2.size() < 4) {
                            linkedList2.add(aml2.Lwj + ":" + context.getString(R.string.zp) + aml2.title + "\n");
                            break;
                        }
                }
            }
            String str4 = "";
            aVar2.desc = "";
            Iterator it2 = linkedList2.iterator();
            while (it2.hasNext()) {
                str4 = str4 + ((String) it2.next());
            }
            String trim2 = str4.trim();
            if (linkedList2.size() >= 4) {
                trim2 = trim2 + "...";
            }
            aVar2.desc = trim2;
            AppMethodBeat.o(106898);
            return aVar2;
        }

        private static void a(a aVar, String str) {
            AppMethodBeat.i(106899);
            String str2 = b.cUf() + com.tencent.mm.b.g.getMessageDigest(Util.nullAs(str, "").getBytes());
            if (asq(str2)) {
                aVar.thumbPath = str2;
            }
            AppMethodBeat.o(106899);
        }
    }

    public static void a(final Context context, final String str, final aml aml, final Runnable runnable) {
        AppMethodBeat.i(106903);
        if (context == null) {
            Log.w("MicroMsg.FavSendLogic", "want to send fav video, but context is null");
            AppMethodBeat.o(106903);
        } else if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.FavSendLogic", "want to send fav video, but to user is null");
            AppMethodBeat.o(106903);
        } else if (aml == null) {
            Log.w("MicroMsg.FavSendLogic", "want to send fav video, but dataItem is null");
            AppMethodBeat.o(106903);
        } else {
            com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable() {
                /* class com.tencent.mm.plugin.fav.ui.l.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(106889);
                    if (aml.dataType == 15) {
                        l.a(context, str, aml);
                    } else {
                        l.b(context, str, aml);
                    }
                    MMHandlerThread.postToMainThread(runnable);
                    AppMethodBeat.o(106889);
                }

                public final String toString() {
                    AppMethodBeat.i(106890);
                    String str = super.toString() + "|sendFavVideo";
                    AppMethodBeat.o(106890);
                    return str;
                }
            });
            AppMethodBeat.o(106903);
        }
    }

    public static void a(Context context, final String str, final g gVar, final aml aml, final Runnable runnable) {
        AppMethodBeat.i(106904);
        if (context == null) {
            Log.w("MicroMsg.FavSendLogic", "want to send fav file, but context is null");
            AppMethodBeat.o(106904);
        } else if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.FavSendLogic", "want to send fav file, but to user is null");
            AppMethodBeat.o(106904);
        } else {
            if (gVar == null) {
                Log.w("MicroMsg.FavSendLogic", "want to send fav file, but info is null");
            }
            if (aml == null) {
                Log.w("MicroMsg.FavSendLogic", "want to send fav file, but dataItem is null");
                AppMethodBeat.o(106904);
                return;
            }
            com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable() {
                /* class com.tencent.mm.plugin.fav.ui.l.AnonymousClass4 */

                public final void run() {
                    AppMethodBeat.i(106891);
                    l.a(str, gVar, aml);
                    MMHandlerThread.postToMainThread(runnable);
                    AppMethodBeat.o(106891);
                }

                public final String toString() {
                    AppMethodBeat.i(106892);
                    String str = super.toString() + "|sendFavFile";
                    AppMethodBeat.o(106892);
                    return str;
                }
            });
            AppMethodBeat.o(106904);
        }
    }

    public static String k(aml aml) {
        String str;
        AppMethodBeat.i(106905);
        o oVar = new o(b.a(aml));
        if (oVar.exists()) {
            str = aa.z(oVar.her());
        } else {
            str = b.cUf() + com.tencent.mm.b.g.getMessageDigest(Util.nullAs(aml.dFN, "").getBytes());
        }
        AppMethodBeat.o(106905);
        return str;
    }

    public static void g(String str, String str2, String str3, String str4, String str5) {
        AppMethodBeat.i(235320);
        WXFileObject wXFileObject = new WXFileObject();
        wXFileObject.setFilePath(str2);
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXFileObject;
        wXMediaMessage.title = str3;
        wXMediaMessage.description = str4;
        wXMediaMessage.thumbData = Util.readFromFile(b.EX(str5));
        ((com.tencent.mm.plugin.fav.a.ab) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.fav.a.ab.class)).a(wXMediaMessage, "", "", str);
        AppMethodBeat.o(235320);
    }

    static /* synthetic */ void a(Context context, String str, aml aml) {
        AppMethodBeat.i(106906);
        o oVar = new o(b.d(aml));
        if (oVar.exists()) {
            String k = k(aml);
            Log.d("MicroMsg.FavSendLogic", "send fav short Video::data path[%s] thumb path[%s]", aa.z(oVar.her()), k);
            eeq eeq = null;
            amo amo = aml.Lwn;
            if (amo != null) {
                eeq = new eeq();
                eeq.ize = amo.ize;
                eeq.izb = amo.izb;
                eeq.LxJ = amo.LxJ;
                eeq.iyZ = amo.iyZ;
                eeq.izc = amo.izc;
                eeq.izf = amo.izf;
                eeq.izg = amo.izg;
                eeq.izd = amo.izd;
            }
            if (eeq != null) {
                com.tencent.mm.plugin.messenger.a.g.eir().a(context, str, aa.z(oVar.her()), k, 62, aml.duration, eeq, aml.ean, aml.jsz);
                AppMethodBeat.o(106906);
                return;
            }
            com.tencent.mm.plugin.messenger.a.g.eir().a(context, str, aa.z(oVar.her()), k, 62, aml.duration, aml.ean, aml.jsz);
            AppMethodBeat.o(106906);
            return;
        }
        Log.w("MicroMsg.FavSendLogic", "sendShortVideo, error! data not existed");
        AppMethodBeat.o(106906);
    }

    static /* synthetic */ void b(Context context, String str, aml aml) {
        y yVar;
        String str2;
        eeq eeq;
        AppMethodBeat.i(106907);
        o oVar = new o(b.d(aml));
        if (oVar.exists()) {
            o oVar2 = new o(b.a(aml));
            if (oVar2.exists()) {
                str2 = aa.z(oVar2.her());
            } else {
                str2 = b.cUf() + com.tencent.mm.b.g.getMessageDigest(Util.nullAs(aml.dFN, "").getBytes());
            }
            Log.d("MicroMsg.FavSendLogic", "sendVideo::data path[%s] thumb path[%s]", aa.z(oVar.her()), str2);
            amo amo = aml.Lwn;
            if (amo != null) {
                eeq = new eeq();
                eeq.ize = amo.ize;
                eeq.izb = amo.izb;
                eeq.LxJ = amo.LxJ;
                eeq.iyZ = amo.iyZ;
                eeq.izc = amo.izc;
                eeq.izf = amo.izf;
                eeq.izg = amo.izg;
            } else {
                eeq = null;
            }
            if (eeq != null) {
                com.tencent.mm.plugin.messenger.a.g.eir().a(context, str, aa.z(oVar.her()), str2, 1, aml.duration, eeq, aml.ean, aml.jsz);
                AppMethodBeat.o(106907);
                return;
            }
            com.tencent.mm.plugin.messenger.a.g.eir().a(context, str, aa.z(oVar.her()), str2, 1, aml.duration, aml.ean, aml.jsz);
            AppMethodBeat.o(106907);
            return;
        }
        if (aml.Lwh == null || aml.Lwh.Lxi == null) {
            yVar = null;
        } else {
            amt amt = aml.Lwh.Lxi;
            y yVar2 = new y();
            yVar2.KOe = amt.KOe;
            yVar2.videoUrl = amt.videoUrl;
            yVar2.KOf = amt.vid;
            yVar2.title = aml.title;
            yVar2.iAo = amt.iAo;
            yVar2.videoDuration = amt.duration;
            yVar2.width = amt.videoWidth;
            yVar2.height = amt.videoHeight;
            yVar2.url = aml.Lvu;
            yVar2.dHc = amt.dHc;
            yVar2.iAg = amt.iAg;
            yVar = yVar2;
        }
        if (yVar != null) {
            ((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).a(str, yVar, "", new d<Bundle>() {
                /* class com.tencent.mm.plugin.fav.ui.l.AnonymousClass5 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.ipcinvoker.d
                public final /* bridge */ /* synthetic */ void bn(Bundle bundle) {
                }
            });
            AppMethodBeat.o(106907);
            return;
        }
        String str3 = aml.Lvu;
        if (!Util.isNullOrNil(str3)) {
            WXVideoObject wXVideoObject = new WXVideoObject();
            wXVideoObject.videoUrl = str3;
            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXVideoObject);
            String nullAs = Util.nullAs(aml.title, context.getResources().getString(R.string.cd1));
            wXMediaMessage.mediaObject = wXVideoObject;
            wXMediaMessage.title = nullAs;
            wXMediaMessage.description = aml.desc;
            wXMediaMessage.thumbData = Util.readFromFile(b.a(aml));
            if (wXMediaMessage.thumbData == null) {
                wXMediaMessage.thumbData = Util.readFromFile(b.cUf() + com.tencent.mm.b.g.getMessageDigest(Util.nullAs(aml.dFN, "").getBytes()));
            }
            k.b bVar = new k.b();
            bVar.iwL = 3;
            amo amo2 = aml.Lwn;
            if (amo2 != null) {
                bVar.ize = amo2.ize;
                bVar.izb = amo2.izb;
                bVar.iza = amo2.LxJ;
                bVar.iyZ = amo2.iyZ;
                bVar.izc = amo2.izc;
                bVar.izf = amo2.izf;
                bVar.izg = amo2.izg;
            }
            ((com.tencent.mm.plugin.fav.a.ab) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.fav.a.ab.class)).a(bVar, wXMediaMessage, str);
        }
        AppMethodBeat.o(106907);
    }

    static /* synthetic */ void a(String str, g gVar, aml aml) {
        AppMethodBeat.i(106908);
        String d2 = b.d(aml);
        WXFileObject wXFileObject = new WXFileObject();
        wXFileObject.setFilePath(d2);
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXFileObject;
        wXMediaMessage.title = aml.title;
        if (Util.isNullOrNil(wXMediaMessage.title)) {
            wXMediaMessage.title = gVar.field_favProto.title;
        }
        wXMediaMessage.description = aml.desc;
        wXMediaMessage.thumbData = Util.readFromFile(b.a(aml));
        ((com.tencent.mm.plugin.fav.a.ab) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.fav.a.ab.class)).a(wXMediaMessage, "", "", str);
        AppMethodBeat.o(106908);
    }
}
