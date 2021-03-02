package com.tencent.mm.bz;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.api.w;
import com.tencent.mm.av.g;
import com.tencent.mm.av.h;
import com.tencent.mm.av.i;
import com.tencent.mm.av.n;
import com.tencent.mm.av.q;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.protocal.protobuf.dnm;
import com.tencent.mm.protocal.protobuf.dns;
import com.tencent.mm.protocal.protobuf.doi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a implements i, w {
    public static final a NCE = new a();
    public ConcurrentHashMap<String, dns> uUF = new ConcurrentHashMap<>();

    public a() {
        AppMethodBeat.i(9324);
        AppMethodBeat.o(9324);
    }

    static {
        AppMethodBeat.i(9329);
        AppMethodBeat.o(9329);
    }

    @Override // com.tencent.mm.api.w
    public final void recordVideo(String str, String str2, String str3, String str4) {
        AppMethodBeat.i(9325);
        s QN = u.QN(str);
        if (QN == null || QN.jso <= 0) {
            Log.w("MicroMsg.MediaSecurityReport", "[recordVideo] imgInfo is null! %s", str);
            AppMethodBeat.o(9325);
            return;
        }
        Map<String, String> parseXml = XmlParser.parseXml(QN.bhv(), "msg", null);
        if (parseXml == null) {
            Log.w("MicroMsg.MediaSecurityReport", "attrs == null! %s", str);
            AppMethodBeat.o(9325);
            return;
        }
        dns dns = new dns();
        dns.oUv = 2;
        dns.KTg = str4;
        dns.EmotionList = new LinkedList<>(Util.stringsToList(str3.split(",")));
        doi doi = new doi();
        doi.MQG = QN.ebj;
        doi.MRE = "";
        doi.MRI = (float) QN.iFw;
        o.bhj();
        doi.MRH = h.Ow(t.Qx(str));
        doi.MRF = parseXml.get(".msg.videomsg.$cdnvideourl");
        doi.MRG = parseXml.get(".msg.videomsg.$aeskey");
        dns.MQO = doi;
        this.uUF.put(str2, dns);
        AppMethodBeat.o(9325);
    }

    @Override // com.tencent.mm.api.w
    public final void recordImage(String str, String str2, long j2, String str3, String str4) {
        g c2;
        AppMethodBeat.i(9326);
        if (j2 <= 0) {
            com.tencent.mm.av.i bcR = q.bcR();
            String Ow = h.Ow(str);
            c2 = new g();
            Cursor a2 = bcR.a(i.d.OH(""), (String[]) null, "origImgMD5=?", new String[]{String.valueOf(Ow)});
            if (a2.moveToFirst()) {
                c2.convertFrom(a2);
            }
            a2.close();
        } else {
            c2 = q.bcR().c(Long.valueOf(j2));
        }
        if (c2.localId > 0) {
            Map<String, String> parseXml = XmlParser.parseXml(c2.iXy, "msg", null);
            if (parseXml == null) {
                Log.w("MicroMsg.MediaSecurityReport", "attrs == null! %s %s", str, Long.valueOf(j2));
                AppMethodBeat.o(9326);
                return;
            }
            dns dns = new dns();
            dns.oUv = 1;
            dns.KTg = str4;
            dns.EmotionList = new LinkedList<>(Util.stringsToList(str3.split(",")));
            dnm dnm = new dnm();
            dnm.MQE = parseXml.get(".msg.img.$cdnmidimgurl");
            dnm.MQF = parseXml.get(".msg.img.$aeskey");
            dnm.MQG = "";
            dns.MQN = dnm;
            this.uUF.put(str2, dns);
            AppMethodBeat.o(9326);
            return;
        }
        Log.w("MicroMsg.MediaSecurityReport", "[recordImage] imgInfo is null! %s %s", str, Long.valueOf(j2));
        AppMethodBeat.o(9326);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        com.tencent.mm.modelvideo.g gVar;
        String bhv;
        AppMethodBeat.i(9327);
        if (qVar.getType() == 110 || qVar.getType() == 149) {
            if (i2 == 0 && i3 == 0) {
                if (qVar instanceof n) {
                    n nVar = (n) qVar;
                    if (nVar != null && nVar.iZq) {
                        String str2 = nVar.iZp;
                        final dns remove = this.uUF.remove(nVar.iZt);
                        if (!(str2 == null || remove == null)) {
                            Map<String, String> parseXml = XmlParser.parseXml(str2, "msg", null);
                            if (parseXml == null) {
                                Log.w("MicroMsg.MediaSecurityReport", "attrs == null!");
                                AppMethodBeat.o(9327);
                                return;
                            }
                            dnm dnm = remove.MQN;
                            dnm.LxW = parseXml.get(".msg.img.$cdnmidimgurl");
                            dnm.AesKey = parseXml.get(".msg.img.$aeskey");
                            dnm.MD5 = "";
                            Log.i("MicroMsg.MediaSecurityReport", "report! OrigImgPath:%s", nVar.iZt);
                            new b(remove).doScene(com.tencent.mm.kernel.g.azz().iMw, new com.tencent.mm.ak.i() {
                                /* class com.tencent.mm.bz.a.AnonymousClass1 */

                                @Override // com.tencent.mm.ak.i
                                public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
                                    AppMethodBeat.i(9322);
                                    qVar.setHasCallbackToQueue(true);
                                    if (i2 == 0 && i3 == 0) {
                                        Log.i("MicroMsg.MediaSecurityReport", "report successfully! %s", a.a(remove));
                                        AppMethodBeat.o(9322);
                                        return;
                                    }
                                    Log.e("MicroMsg.MediaSecurityReport", "report error![%s:%s] %s", Integer.valueOf(i2), Integer.valueOf(i3), a.a(remove));
                                    AppMethodBeat.o(9322);
                                }
                            });
                        }
                    }
                    AppMethodBeat.o(9327);
                    return;
                } else if ((qVar instanceof com.tencent.mm.modelvideo.g) && (gVar = (com.tencent.mm.modelvideo.g) qVar) != null) {
                    final dns remove2 = this.uUF.remove(gVar.fileName);
                    if (gVar.jqq == null) {
                        bhv = "";
                    } else {
                        bhv = gVar.jqq.bhv();
                    }
                    if (!(bhv == null || remove2 == null)) {
                        Map<String, String> parseXml2 = XmlParser.parseXml(bhv, "msg", null);
                        if (parseXml2 == null) {
                            Log.w("MicroMsg.MediaSecurityReport", "attrs == null!");
                            AppMethodBeat.o(9327);
                            return;
                        }
                        doi doi = remove2.MQO;
                        doi.AesKey = parseXml2.get(".msg.videomsg.$aeskey");
                        doi.LxW = parseXml2.get(".msg.videomsg.$cdnvideourll");
                        s sVar = gVar.jqq;
                        doi.MD5 = sVar.ebj;
                        doi.MRB = "";
                        doi.MRC = (float) sVar.iFw;
                        doi.MEd = doi.LxW;
                        doi.MEe = doi.AesKey;
                        o.bhj();
                        doi.MRD = h.Ow(t.Qx(sVar.getFileName()));
                        Log.i("MicroMsg.MediaSecurityReport", "report! OrigVideoPath:%s", gVar.fileName);
                        new b(remove2).doScene(com.tencent.mm.kernel.g.azz().iMw, new com.tencent.mm.ak.i() {
                            /* class com.tencent.mm.bz.a.AnonymousClass2 */

                            @Override // com.tencent.mm.ak.i
                            public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
                                AppMethodBeat.i(9323);
                                qVar.setHasCallbackToQueue(true);
                                if (i2 == 0 && i3 == 0) {
                                    Log.i("MicroMsg.MediaSecurityReport", "report successfully! %s", a.a(remove2));
                                    AppMethodBeat.o(9323);
                                    return;
                                }
                                Log.e("MicroMsg.MediaSecurityReport", "report error![%s:%s] %s", Integer.valueOf(i2), Integer.valueOf(i3), a.a(remove2));
                                AppMethodBeat.o(9323);
                            }
                        });
                    }
                }
            }
            AppMethodBeat.o(9327);
            return;
        }
        AppMethodBeat.o(9327);
    }

    static /* synthetic */ String a(dns dns) {
        AppMethodBeat.i(9328);
        dnm dnm = dns.MQN;
        String format = String.format("[image] %s,%s | %s,%s | %s %s", dnm.LxW, dnm.AesKey, dnm.MQE, dnm.MQF, dns.EmotionList, dns.KTg);
        AppMethodBeat.o(9328);
        return format;
    }
}
