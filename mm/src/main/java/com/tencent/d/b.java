package com.tencent.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import io.flutter.plugin.a.b;
import java.util.ArrayList;
import java.util.HashMap;

public final class b {

    public static class a {
        ArrayList BOZ;
        Long BOd;
        String BPc;
        ArrayList RIo;
        Long RIp;
        Boolean RIq;
        String cachePath;
        String musicUrl;
    }

    public static class ae {
        String RJd;
        Long RJe;
    }

    public static class ag {
        ArrayList BOZ;
        Long BOd;
        String BPc;
        Long RIp;
        Boolean RIq;
        ArrayList RJg;
        String cachePath;
        String musicUrl;
        String playUrl;
    }

    public static class ao {
        Long RHn;
        Long RHq;
        Long RHr;
        Long RHs;
        Long RHt;
        Long RId;
        Long RIe;
        Long RIf;
        Double RIj;
        Double RJl;
        Long RJm;
        aq RJn;
        String path;
    }

    public static class ap {
        String RJo;
        String RJp;
        String name;
    }

    public static class aq {
        Long BOd;
        Long RHl;
        String path;
    }

    public static class au {
        Long BOd;
        String IFw;
        Boolean RJs;
        String iiv;
    }

    /* renamed from: com.tencent.d.b$b  reason: collision with other inner class name */
    public static class C0133b {
        String BPp;
        Long RIr;
        Long jnK;
    }

    public static class d {
        ArrayList RIs;
    }

    public static class e {
        Boolean RIt;
    }

    public static class h {
        Long RHA;
        Long RHB;
        Long RHD;
        Long RHE;
        Long RHF;
        Long RIE;
        Long RIF;
        Long RIG;
        Long RIH;
        ArrayList RII;
        Double RIJ;
        Long RIK;
        Long RIL;
        String rpE;
    }

    public static class aj {
        private String result;

        public final void bpS(String str) {
            this.result = str;
        }

        /* access modifiers changed from: package-private */
        public final HashMap hjw() {
            AppMethodBeat.i(196105);
            HashMap hashMap = new HashMap();
            hashMap.put("result", this.result);
            AppMethodBeat.o(196105);
            return hashMap;
        }
    }

    public static class ak {
        private String RJi;

        public final String hjZ() {
            return this.RJi;
        }

        static ak y(HashMap hashMap) {
            AppMethodBeat.i(196106);
            ak akVar = new ak();
            akVar.RJi = (String) hashMap.get("requestName");
            AppMethodBeat.o(196106);
            return akVar;
        }
    }

    public static class s {
        String RIQ;
        ArrayList RIR;
        ArrayList RIS;
        ArrayList RIT;

        public final void bpP(String str) {
            this.RIQ = str;
        }
    }

    public static class r {
        String RIP;

        public final String hjQ() {
            return this.RIP;
        }
    }

    public static class x {
        ArrayList RIX;
        ArrayList RIY;
        ArrayList RIZ;

        public final void bx(ArrayList arrayList) {
            this.RIX = arrayList;
        }

        public final void by(ArrayList arrayList) {
            this.RIY = arrayList;
        }

        public final void bz(ArrayList arrayList) {
            this.RIZ = arrayList;
        }
    }

    public static class w {
        ArrayList RIN;
        Long RIV;
        String RIW;
        String designerName;

        public final ArrayList hjR() {
            return this.RIN;
        }

        public final void bw(ArrayList arrayList) {
            this.RIN = arrayList;
        }

        public final void o(Long l) {
            this.RIV = l;
        }

        public final void bpQ(String str) {
            this.designerName = str;
        }

        public final void bpR(String str) {
            this.RIW = str;
        }
    }

    public static class v {
        String productId;

        public final String getProductId() {
            return this.productId;
        }
    }

    public static class q {
        byte[] RIM;
        String RIO;
        Boolean wJQ;

        public final void cS(byte[] bArr) {
            this.RIM = bArr;
        }

        public final void bpO(String str) {
            this.RIO = str;
        }

        public final void v(Boolean bool) {
            this.wJQ = bool;
        }
    }

    public static class p {
        String productId;
        String zfo;

        public final String getProductId() {
            return this.productId;
        }

        public final String hjP() {
            return this.zfo;
        }
    }

    public static class c {
        Long RIr;
        Long jnK;
        String path;

        public final String getPath() {
            return this.path;
        }

        public final Long hjA() {
            return this.jnK;
        }

        public final Long hjB() {
            return this.RIr;
        }
    }

    public static class af {
        Long RJf;
        String name;

        public final String getName() {
            return this.name;
        }

        public final Long hjX() {
            return this.RJf;
        }
    }

    public static class n {
        byte[] RIM;

        public final void cS(byte[] bArr) {
            this.RIM = bArr;
        }
    }

    public static class l {
        String md5;

        public final String getMd5() {
            return this.md5;
        }
    }

    public static class m {
        ArrayList RIN;

        public final void bw(ArrayList arrayList) {
            this.RIN = arrayList;
        }
    }

    public static class am {
        ArrayList RIN;

        public final void bw(ArrayList arrayList) {
            this.RIN = arrayList;
        }
    }

    public static class j {
        byte[] RIM;

        public final void cS(byte[] bArr) {
            this.RIM = bArr;
        }
    }

    public static class i {
        String md5;

        public final String getMd5() {
            return this.md5;
        }
    }

    public static class k {
        ArrayList RIN;

        public final void bw(ArrayList arrayList) {
            this.RIN = arrayList;
        }
    }

    public static class u {
        Long RHy;
        Long RIU;
        byte[] data;

        public final void m(Long l) {
            this.RIU = l;
        }

        public final void n(Long l) {
            this.RHy = l;
        }

        public final void setData(byte[] bArr) {
            this.data = bArr;
        }
    }

    public static class t {
        String md5;

        public final String getMd5() {
            return this.md5;
        }
    }

    public static class ac {
        Long RHn;
        String md5;

        public final String getMd5() {
            return this.md5;
        }

        public final Long hjC() {
            return this.RHn;
        }
    }

    public static class o {
        Long RHn;
        String md5;

        public final String getMd5() {
            return this.md5;
        }

        public final Long hjC() {
            return this.RHn;
        }
    }

    public static class f {
        Long RHn;
        String filePath;

        public final Long hjC() {
            return this.RHn;
        }

        public final String getFilePath() {
            return this.filePath;
        }
    }

    public static class ad {
        Long RIp;
        String cachePath;
        String musicUrl;

        public final Long hjV() {
            return this.RIp;
        }

        public final String hjW() {
            return this.musicUrl;
        }

        public final String azM() {
            return this.cachePath;
        }
    }

    public static class ai {
        String productId;

        public final String getProductId() {
            return this.productId;
        }
    }

    public static class ah {
        byte[] RJh;
        String path;

        public final byte[] hjY() {
            return this.RJh;
        }

        public final String getPath() {
            return this.path;
        }
    }

    public static class g {
        private ArrayList Gzn;
        private HashMap RIA;
        private HashMap RIB;
        private Long RIC;
        private ArrayList RID;
        private HashMap RIu;
        private Boolean RIv;
        private Boolean RIw;
        private Boolean RIx;
        private Long RIy;
        private Long RIz;
        private String editId;
        private String iiv;
        private String thumbPath;

        public final String hjD() {
            return this.editId;
        }

        public final HashMap hjE() {
            return this.RIu;
        }

        public final String aQn() {
            return this.thumbPath;
        }

        public final Boolean hjF() {
            return this.RIv;
        }

        public final Boolean hjG() {
            return this.RIw;
        }

        public final String hjH() {
            return this.iiv;
        }

        public final Boolean hjI() {
            return this.RIx;
        }

        public final Long hjJ() {
            return this.RIy;
        }

        public final Long hjK() {
            return this.RIz;
        }

        public final ArrayList hjL() {
            return this.Gzn;
        }

        public final HashMap hjM() {
            return this.RIB;
        }

        public final Long hjN() {
            return this.RIC;
        }

        public final ArrayList hjO() {
            return this.RID;
        }

        static g x(HashMap hashMap) {
            Long valueOf;
            Long valueOf2;
            Long l = null;
            AppMethodBeat.i(196104);
            g gVar = new g();
            gVar.editId = (String) hashMap.get("editId");
            gVar.RIu = (HashMap) hashMap.get("editData");
            gVar.thumbPath = (String) hashMap.get("thumbPath");
            gVar.RIv = (Boolean) hashMap.get("enableOriginAudio");
            gVar.RIw = (Boolean) hashMap.get("enableVideoEnhanceMent");
            gVar.iiv = (String) hashMap.get("musicPath");
            gVar.RIx = (Boolean) hashMap.get("needPlay");
            Object obj = hashMap.get("playEndMs");
            if (obj == null) {
                valueOf = null;
            } else {
                valueOf = Long.valueOf(obj instanceof Integer ? (long) ((Integer) obj).intValue() : ((Long) obj).longValue());
            }
            gVar.RIy = valueOf;
            Object obj2 = hashMap.get("playStartMs");
            if (obj2 == null) {
                valueOf2 = null;
            } else {
                valueOf2 = Long.valueOf(obj2 instanceof Integer ? (long) ((Integer) obj2).intValue() : ((Long) obj2).longValue());
            }
            gVar.RIz = valueOf2;
            gVar.Gzn = (ArrayList) hashMap.get("trackList");
            gVar.RIA = (HashMap) hashMap.get("videoTemplateInfoProto");
            gVar.RIB = (HashMap) hashMap.get("outputConfig");
            Object obj3 = hashMap.get("exportStartTime");
            if (obj3 != null) {
                l = Long.valueOf(obj3 instanceof Integer ? (long) ((Integer) obj3).intValue() : ((Long) obj3).longValue());
            }
            gVar.RIC = l;
            gVar.RID = (ArrayList) hashMap.get("labelList");
            AppMethodBeat.o(196104);
            return gVar;
        }
    }

    public static class ab {
        Long RHm;

        public final Long hjS() {
            return this.RHm;
        }
    }

    public static class y {
        Boolean RJa;

        public final void w(Boolean bool) {
            this.RJa = bool;
        }
    }

    public static class ar {
        Boolean RJa;

        public final void w(Boolean bool) {
            this.RJa = bool;
        }
    }

    public static class z {
        Long RHm;
        Long RJb;
        Long RJc;

        public final Long hjS() {
            return this.RHm;
        }

        public final Long hjT() {
            return this.RJb;
        }

        public final Long hjU() {
            return this.RJc;
        }
    }

    public static class aa {
        Long RHG;

        public final void p(Long l) {
            this.RHG = l;
        }
    }

    public static class al {
        String RJj;

        public final void bpT(String str) {
            this.RJj = str;
        }
    }

    public static class at {
        ArrayList RJr;

        public final ArrayList hkb() {
            return this.RJr;
        }
    }

    public static class an {
        String RJk;
        String text;

        public final String getText() {
            return this.text;
        }

        public final String hka() {
            return this.RJk;
        }
    }

    public static abstract class as {
        public abstract aj a(ak akVar);

        public abstract al a(at atVar);

        public abstract d a(c cVar);

        public abstract j a(i iVar);

        public abstract n a(l lVar);

        public abstract q a(p pVar);

        public abstract s a(r rVar);

        public abstract u a(t tVar);

        public abstract w a(v vVar);

        public abstract void a(ab abVar);

        public abstract void a(ac acVar);

        public abstract void a(ad adVar);

        public abstract void a(af afVar);

        public abstract void a(ah ahVar);

        public abstract void a(ai aiVar);

        public abstract void a(an anVar);

        public abstract void a(f fVar);

        public abstract void a(g gVar);

        public abstract void a(o oVar);

        public abstract void a(z zVar);

        public abstract aj b(ak akVar);

        public abstract m dLA();

        public abstract am dLB();

        public abstract k dLC();

        public abstract aa dLD();

        public abstract void dLE();

        public abstract void dLF();

        public abstract void dLG();

        public abstract void dLH();

        public abstract void dLI();

        public abstract void dLJ();

        public abstract void dLK();

        public abstract void dLL();

        public abstract void dLM();

        public abstract void dLN();

        public abstract void dLO();

        public abstract x dLw();

        public abstract void dLx();

        public abstract y dLy();

        public abstract ar dLz();

        public static void a(io.flutter.plugin.a.c cVar, as asVar) {
            new io.flutter.plugin.a.b(cVar, "dev.flutter.pigeon.VideoEditorCompositionApi.simple", new io.flutter.plugin.a.n()).a(new b.AbstractC2252b<Object>(asVar) {
                /* class com.tencent.d.b.as.AnonymousClass1 */
                final /* synthetic */ as RJq;

                {
                    this.RJq = r1;
                }

                @Override // io.flutter.plugin.a.b.AbstractC2252b
                public final void a(Object obj, b.c<Object> cVar) {
                    AppMethodBeat.i(196107);
                    HashMap hashMap = new HashMap();
                    try {
                        hashMap.put("result", this.RJq.a(ak.y((HashMap) obj)).hjw());
                    } catch (Exception e2) {
                        hashMap.put("error", b.q(e2));
                    }
                    cVar.eO(hashMap);
                    AppMethodBeat.o(196107);
                }
            });
            new io.flutter.plugin.a.b(cVar, "dev.flutter.pigeon.VideoEditorCompositionApi.simple2", new io.flutter.plugin.a.n()).a(new b.AbstractC2252b<Object>(asVar) {
                /* class com.tencent.d.b.as.AnonymousClass12 */
                final /* synthetic */ as RJq;

                {
                    this.RJq = r1;
                }

                @Override // io.flutter.plugin.a.b.AbstractC2252b
                public final void a(Object obj, b.c<Object> cVar) {
                    AppMethodBeat.i(196118);
                    HashMap hashMap = new HashMap();
                    try {
                        hashMap.put("result", this.RJq.b(ak.y((HashMap) obj)).hjw());
                    } catch (Exception e2) {
                        hashMap.put("error", b.q(e2));
                    }
                    cVar.eO(hashMap);
                    AppMethodBeat.o(196118);
                }
            });
            new io.flutter.plugin.a.b(cVar, "dev.flutter.pigeon.VideoEditorCompositionApi.testEmoji", new io.flutter.plugin.a.n()).a(new b.AbstractC2252b<Object>(asVar) {
                /* class com.tencent.d.b.as.AnonymousClass23 */
                final /* synthetic */ as RJq;

                {
                    this.RJq = r1;
                }

                @Override // io.flutter.plugin.a.b.AbstractC2252b
                public final void a(Object obj, b.c<Object> cVar) {
                    AppMethodBeat.i(196129);
                    HashMap hashMap = new HashMap();
                    try {
                        r rVar = new r();
                        rVar.RIP = (String) ((HashMap) obj).get("testRequest");
                        s a2 = this.RJq.a(rVar);
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("testResponse", a2.RIQ);
                        hashMap2.put("emojiDataList", a2.RIR);
                        hashMap2.put("emojiBitmap", a2.RIS);
                        hashMap2.put("base64Emoji", a2.RIT);
                        hashMap.put("result", hashMap2);
                    } catch (Exception e2) {
                        hashMap.put("error", b.q(e2));
                    }
                    cVar.eO(hashMap);
                    AppMethodBeat.o(196129);
                }
            });
            new io.flutter.plugin.a.b(cVar, "dev.flutter.pigeon.VideoEditorCompositionApi.getGroupProductId", new io.flutter.plugin.a.n()).a(new b.AbstractC2252b<Object>(asVar) {
                /* class com.tencent.d.b.as.AnonymousClass34 */
                final /* synthetic */ as RJq;

                {
                    this.RJq = r1;
                }

                @Override // io.flutter.plugin.a.b.AbstractC2252b
                public final void a(Object obj, b.c<Object> cVar) {
                    AppMethodBeat.i(196140);
                    HashMap hashMap = new HashMap();
                    try {
                        x dLw = this.RJq.dLw();
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("packIconUrl", dLw.RIX);
                        hashMap2.put("productIdList", dLw.RIY);
                        hashMap2.put("packNameList", dLw.RIZ);
                        hashMap.put("result", hashMap2);
                    } catch (Exception e2) {
                        hashMap.put("error", b.q(e2));
                    }
                    cVar.eO(hashMap);
                    AppMethodBeat.o(196140);
                }
            });
            new io.flutter.plugin.a.b(cVar, "dev.flutter.pigeon.VideoEditorCompositionApi.getEmojiMd5ListByProductId", new io.flutter.plugin.a.n()).a(new b.AbstractC2252b<Object>(asVar) {
                /* class com.tencent.d.b.as.AnonymousClass37 */
                final /* synthetic */ as RJq;

                {
                    this.RJq = r1;
                }

                @Override // io.flutter.plugin.a.b.AbstractC2252b
                public final void a(Object obj, b.c<Object> cVar) {
                    AppMethodBeat.i(196143);
                    HashMap hashMap = new HashMap();
                    try {
                        v vVar = new v();
                        vVar.productId = (String) ((HashMap) obj).get("productId");
                        w a2 = this.RJq.a(vVar);
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("md5List", a2.RIN);
                        hashMap2.put("designerUin", a2.RIV);
                        hashMap2.put("designerName", a2.designerName);
                        hashMap2.put("designerHeadUrl", a2.RIW);
                        hashMap.put("result", hashMap2);
                    } catch (Exception e2) {
                        hashMap.put("error", b.q(e2));
                    }
                    cVar.eO(hashMap);
                    AppMethodBeat.o(196143);
                }
            });
            new io.flutter.plugin.a.b(cVar, "dev.flutter.pigeon.VideoEditorCompositionApi.getEmojiDataBase64", new io.flutter.plugin.a.n()).a(new b.AbstractC2252b<Object>(asVar) {
                /* class com.tencent.d.b.as.AnonymousClass38 */
                final /* synthetic */ as RJq;

                {
                    this.RJq = r1;
                }

                @Override // io.flutter.plugin.a.b.AbstractC2252b
                public final void a(Object obj, b.c<Object> cVar) {
                    AppMethodBeat.i(196144);
                    HashMap hashMap = new HashMap();
                    try {
                        HashMap hashMap2 = (HashMap) obj;
                        p pVar = new p();
                        pVar.productId = (String) hashMap2.get("productId");
                        pVar.zfo = (String) hashMap2.get("emojiMd5");
                        q a2 = this.RJq.a(pVar);
                        HashMap hashMap3 = new HashMap();
                        hashMap3.put("uInt8List", a2.RIM);
                        hashMap3.put("emojiName", a2.RIO);
                        hashMap3.put("isSystemEmoji", a2.wJQ);
                        hashMap.put("result", hashMap3);
                    } catch (Exception e2) {
                        hashMap.put("error", b.q(e2));
                    }
                    cVar.eO(hashMap);
                    AppMethodBeat.o(196144);
                }
            });
            new io.flutter.plugin.a.b(cVar, "dev.flutter.pigeon.VideoEditorCompositionApi.getAudioRecommend", new io.flutter.plugin.a.n()).a(new b.AbstractC2252b<Object>(asVar) {
                /* class com.tencent.d.b.as.AnonymousClass39 */
                final /* synthetic */ as RJq;

                {
                    this.RJq = r1;
                }

                @Override // io.flutter.plugin.a.b.AbstractC2252b
                public final void a(Object obj, b.c<Object> cVar) {
                    Long valueOf;
                    Long valueOf2;
                    AppMethodBeat.i(196145);
                    HashMap hashMap = new HashMap();
                    try {
                        HashMap hashMap2 = (HashMap) obj;
                        c cVar2 = new c();
                        cVar2.path = (String) hashMap2.get("path");
                        Object obj2 = hashMap2.get("startTime");
                        if (obj2 == null) {
                            valueOf = null;
                        } else {
                            valueOf = Long.valueOf(obj2 instanceof Integer ? (long) ((Integer) obj2).intValue() : ((Long) obj2).longValue());
                        }
                        cVar2.jnK = valueOf;
                        Object obj3 = hashMap2.get("endTime");
                        if (obj3 == null) {
                            valueOf2 = null;
                        } else {
                            valueOf2 = Long.valueOf(obj3 instanceof Integer ? (long) ((Integer) obj3).intValue() : ((Long) obj3).longValue());
                        }
                        cVar2.RIr = valueOf2;
                        d a2 = this.RJq.a(cVar2);
                        HashMap hashMap3 = new HashMap();
                        hashMap3.put("audioInfoList", a2.RIs);
                        hashMap.put("result", hashMap3);
                    } catch (Exception e2) {
                        hashMap.put("error", b.q(e2));
                    }
                    cVar.eO(hashMap);
                    AppMethodBeat.o(196145);
                }
            });
            new io.flutter.plugin.a.b(cVar, "dev.flutter.pigeon.VideoEditorCompositionApi.doMusicSearchRequest", new io.flutter.plugin.a.n()).a(new b.AbstractC2252b<Object>(asVar) {
                /* class com.tencent.d.b.as.AnonymousClass40 */
                final /* synthetic */ as RJq;

                {
                    this.RJq = r1;
                }

                @Override // io.flutter.plugin.a.b.AbstractC2252b
                public final void a(Object obj, b.c<Object> cVar) {
                    Long valueOf;
                    AppMethodBeat.i(196146);
                    HashMap hashMap = new HashMap();
                    try {
                        HashMap hashMap2 = (HashMap) obj;
                        af afVar = new af();
                        afVar.name = (String) hashMap2.get("name");
                        Object obj2 = hashMap2.get("searchOffset");
                        if (obj2 == null) {
                            valueOf = null;
                        } else {
                            valueOf = Long.valueOf(obj2 instanceof Integer ? (long) ((Integer) obj2).intValue() : ((Long) obj2).longValue());
                        }
                        afVar.RJf = valueOf;
                        this.RJq.a(afVar);
                        hashMap.put("result", null);
                    } catch (Exception e2) {
                        hashMap.put("error", b.q(e2));
                    }
                    cVar.eO(hashMap);
                    AppMethodBeat.o(196146);
                }
            });
            new io.flutter.plugin.a.b(cVar, "dev.flutter.pigeon.VideoEditorCompositionApi.getCustomEmojiData", new io.flutter.plugin.a.n()).a(new b.AbstractC2252b<Object>(asVar) {
                /* class com.tencent.d.b.as.AnonymousClass41 */
                final /* synthetic */ as RJq;

                {
                    this.RJq = r1;
                }

                @Override // io.flutter.plugin.a.b.AbstractC2252b
                public final void a(Object obj, b.c<Object> cVar) {
                    AppMethodBeat.i(196147);
                    HashMap hashMap = new HashMap();
                    try {
                        l lVar = new l();
                        lVar.md5 = (String) ((HashMap) obj).get("md5");
                        n a2 = this.RJq.a(lVar);
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("uInt8List", a2.RIM);
                        hashMap.put("result", hashMap2);
                    } catch (Exception e2) {
                        hashMap.put("error", b.q(e2));
                    }
                    cVar.eO(hashMap);
                    AppMethodBeat.o(196147);
                }
            });
            new io.flutter.plugin.a.b(cVar, "dev.flutter.pigeon.VideoEditorCompositionApi.getCustomEmojiMd5List", new io.flutter.plugin.a.n()).a(new b.AbstractC2252b<Object>(asVar) {
                /* class com.tencent.d.b.as.AnonymousClass2 */
                final /* synthetic */ as RJq;

                {
                    this.RJq = r1;
                }

                @Override // io.flutter.plugin.a.b.AbstractC2252b
                public final void a(Object obj, b.c<Object> cVar) {
                    AppMethodBeat.i(196108);
                    HashMap hashMap = new HashMap();
                    try {
                        m dLA = this.RJq.dLA();
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("md5List", dLA.RIN);
                        hashMap.put("result", hashMap2);
                    } catch (Exception e2) {
                        hashMap.put("error", b.q(e2));
                    }
                    cVar.eO(hashMap);
                    AppMethodBeat.o(196108);
                }
            });
            new io.flutter.plugin.a.b(cVar, "dev.flutter.pigeon.VideoEditorCompositionApi.getSystemEmojiMd5List", new io.flutter.plugin.a.n()).a(new b.AbstractC2252b<Object>(asVar) {
                /* class com.tencent.d.b.as.AnonymousClass3 */
                final /* synthetic */ as RJq;

                {
                    this.RJq = r1;
                }

                @Override // io.flutter.plugin.a.b.AbstractC2252b
                public final void a(Object obj, b.c<Object> cVar) {
                    AppMethodBeat.i(196109);
                    HashMap hashMap = new HashMap();
                    try {
                        am dLB = this.RJq.dLB();
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("md5List", dLB.RIN);
                        hashMap.put("result", hashMap2);
                    } catch (Exception e2) {
                        hashMap.put("error", b.q(e2));
                    }
                    cVar.eO(hashMap);
                    AppMethodBeat.o(196109);
                }
            });
            new io.flutter.plugin.a.b(cVar, "dev.flutter.pigeon.VideoEditorCompositionApi.getCustomEmojiCapture", new io.flutter.plugin.a.n()).a(new b.AbstractC2252b<Object>(asVar) {
                /* class com.tencent.d.b.as.AnonymousClass4 */
                final /* synthetic */ as RJq;

                {
                    this.RJq = r1;
                }

                @Override // io.flutter.plugin.a.b.AbstractC2252b
                public final void a(Object obj, b.c<Object> cVar) {
                    AppMethodBeat.i(196110);
                    HashMap hashMap = new HashMap();
                    try {
                        i iVar = new i();
                        iVar.md5 = (String) ((HashMap) obj).get("md5");
                        j a2 = this.RJq.a(iVar);
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("uInt8List", a2.RIM);
                        hashMap.put("result", hashMap2);
                    } catch (Exception e2) {
                        hashMap.put("error", b.q(e2));
                    }
                    cVar.eO(hashMap);
                    AppMethodBeat.o(196110);
                }
            });
            new io.flutter.plugin.a.b(cVar, "dev.flutter.pigeon.VideoEditorCompositionApi.getCustomEmojiCaptureMd5List", new io.flutter.plugin.a.n()).a(new b.AbstractC2252b<Object>(asVar) {
                /* class com.tencent.d.b.as.AnonymousClass5 */
                final /* synthetic */ as RJq;

                {
                    this.RJq = r1;
                }

                @Override // io.flutter.plugin.a.b.AbstractC2252b
                public final void a(Object obj, b.c<Object> cVar) {
                    AppMethodBeat.i(196111);
                    HashMap hashMap = new HashMap();
                    try {
                        k dLC = this.RJq.dLC();
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("md5List", dLC.RIN);
                        hashMap.put("result", hashMap2);
                    } catch (Exception e2) {
                        hashMap.put("error", b.q(e2));
                    }
                    cVar.eO(hashMap);
                    AppMethodBeat.o(196111);
                }
            });
            new io.flutter.plugin.a.b(cVar, "dev.flutter.pigeon.VideoEditorCompositionApi.getEmojiGIFData", new io.flutter.plugin.a.n()).a(new b.AbstractC2252b<Object>(asVar) {
                /* class com.tencent.d.b.as.AnonymousClass6 */
                final /* synthetic */ as RJq;

                {
                    this.RJq = r1;
                }

                @Override // io.flutter.plugin.a.b.AbstractC2252b
                public final void a(Object obj, b.c<Object> cVar) {
                    AppMethodBeat.i(196112);
                    HashMap hashMap = new HashMap();
                    try {
                        t tVar = new t();
                        tVar.md5 = (String) ((HashMap) obj).get("md5");
                        u a2 = this.RJq.a(tVar);
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("heigth", a2.RIU);
                        hashMap2.put("width", a2.RHy);
                        hashMap2.put("data", a2.data);
                        hashMap.put("result", hashMap2);
                    } catch (Exception e2) {
                        hashMap.put("error", b.q(e2));
                    }
                    cVar.eO(hashMap);
                    AppMethodBeat.o(196112);
                }
            });
            new io.flutter.plugin.a.b(cVar, "dev.flutter.pigeon.VideoEditorCompositionApi.MoveEmojiToFront", new io.flutter.plugin.a.n()).a(new b.AbstractC2252b<Object>(asVar) {
                /* class com.tencent.d.b.as.AnonymousClass7 */
                final /* synthetic */ as RJq;

                {
                    this.RJq = r1;
                }

                @Override // io.flutter.plugin.a.b.AbstractC2252b
                public final void a(Object obj, b.c<Object> cVar) {
                    Long valueOf;
                    AppMethodBeat.i(196113);
                    HashMap hashMap = new HashMap();
                    try {
                        HashMap hashMap2 = (HashMap) obj;
                        ac acVar = new ac();
                        acVar.md5 = (String) hashMap2.get("md5");
                        Object obj2 = hashMap2.get("type");
                        if (obj2 == null) {
                            valueOf = null;
                        } else {
                            valueOf = Long.valueOf(obj2 instanceof Integer ? (long) ((Integer) obj2).intValue() : ((Long) obj2).longValue());
                        }
                        acVar.RHn = valueOf;
                        this.RJq.a(acVar);
                        hashMap.put("result", null);
                    } catch (Exception e2) {
                        hashMap.put("error", b.q(e2));
                    }
                    cVar.eO(hashMap);
                    AppMethodBeat.o(196113);
                }
            });
            new io.flutter.plugin.a.b(cVar, "dev.flutter.pigeon.VideoEditorCompositionApi.DeleteEmoji", new io.flutter.plugin.a.n()).a(new b.AbstractC2252b<Object>(asVar) {
                /* class com.tencent.d.b.as.AnonymousClass8 */
                final /* synthetic */ as RJq;

                {
                    this.RJq = r1;
                }

                @Override // io.flutter.plugin.a.b.AbstractC2252b
                public final void a(Object obj, b.c<Object> cVar) {
                    Long valueOf;
                    AppMethodBeat.i(196114);
                    HashMap hashMap = new HashMap();
                    try {
                        HashMap hashMap2 = (HashMap) obj;
                        o oVar = new o();
                        oVar.md5 = (String) hashMap2.get("md5");
                        Object obj2 = hashMap2.get("type");
                        if (obj2 == null) {
                            valueOf = null;
                        } else {
                            valueOf = Long.valueOf(obj2 instanceof Integer ? (long) ((Integer) obj2).intValue() : ((Long) obj2).longValue());
                        }
                        oVar.RHn = valueOf;
                        this.RJq.a(oVar);
                        hashMap.put("result", null);
                    } catch (Exception e2) {
                        hashMap.put("error", b.q(e2));
                    }
                    cVar.eO(hashMap);
                    AppMethodBeat.o(196114);
                }
            });
            new io.flutter.plugin.a.b(cVar, "dev.flutter.pigeon.VideoEditorCompositionApi.getCaptionData", new io.flutter.plugin.a.n()).a(new b.AbstractC2252b<Object>(asVar) {
                /* class com.tencent.d.b.as.AnonymousClass9 */
                final /* synthetic */ as RJq;

                {
                    this.RJq = r1;
                }

                @Override // io.flutter.plugin.a.b.AbstractC2252b
                public final void a(Object obj, b.c<Object> cVar) {
                    Long valueOf;
                    AppMethodBeat.i(196115);
                    HashMap hashMap = new HashMap();
                    try {
                        HashMap hashMap2 = (HashMap) obj;
                        f fVar = new f();
                        Object obj2 = hashMap2.get("type");
                        if (obj2 == null) {
                            valueOf = null;
                        } else {
                            valueOf = Long.valueOf(obj2 instanceof Integer ? (long) ((Integer) obj2).intValue() : ((Long) obj2).longValue());
                        }
                        fVar.RHn = valueOf;
                        fVar.filePath = (String) hashMap2.get("filePath");
                        this.RJq.a(fVar);
                        hashMap.put("result", null);
                    } catch (Exception e2) {
                        hashMap.put("error", b.q(e2));
                    }
                    cVar.eO(hashMap);
                    AppMethodBeat.o(196115);
                }
            });
            new io.flutter.plugin.a.b(cVar, "dev.flutter.pigeon.VideoEditorCompositionApi.downloadMusic", new io.flutter.plugin.a.n()).a(new b.AbstractC2252b<Object>(asVar) {
                /* class com.tencent.d.b.as.AnonymousClass10 */
                final /* synthetic */ as RJq;

                {
                    this.RJq = r1;
                }

                @Override // io.flutter.plugin.a.b.AbstractC2252b
                public final void a(Object obj, b.c<Object> cVar) {
                    Long valueOf;
                    AppMethodBeat.i(196116);
                    HashMap hashMap = new HashMap();
                    try {
                        HashMap hashMap2 = (HashMap) obj;
                        ad adVar = new ad();
                        Object obj2 = hashMap2.get("musicId");
                        if (obj2 == null) {
                            valueOf = null;
                        } else {
                            valueOf = Long.valueOf(obj2 instanceof Integer ? (long) ((Integer) obj2).intValue() : ((Long) obj2).longValue());
                        }
                        adVar.RIp = valueOf;
                        adVar.musicUrl = (String) hashMap2.get("musicUrl");
                        adVar.cachePath = (String) hashMap2.get("cachePath");
                        this.RJq.a(adVar);
                        hashMap.put("result", null);
                    } catch (Exception e2) {
                        hashMap.put("error", b.q(e2));
                    }
                    cVar.eO(hashMap);
                    AppMethodBeat.o(196116);
                }
            });
            new io.flutter.plugin.a.b(cVar, "dev.flutter.pigeon.VideoEditorCompositionApi.showeEmojiGroupDetail", new io.flutter.plugin.a.n()).a(new b.AbstractC2252b<Object>(asVar) {
                /* class com.tencent.d.b.as.AnonymousClass11 */
                final /* synthetic */ as RJq;

                {
                    this.RJq = r1;
                }

                @Override // io.flutter.plugin.a.b.AbstractC2252b
                public final void a(Object obj, b.c<Object> cVar) {
                    AppMethodBeat.i(196117);
                    HashMap hashMap = new HashMap();
                    try {
                        ai aiVar = new ai();
                        aiVar.productId = (String) ((HashMap) obj).get("productId");
                        this.RJq.a(aiVar);
                        hashMap.put("result", null);
                    } catch (Exception e2) {
                        hashMap.put("error", b.q(e2));
                    }
                    cVar.eO(hashMap);
                    AppMethodBeat.o(196117);
                }
            });
            new io.flutter.plugin.a.b(cVar, "dev.flutter.pigeon.VideoEditorCompositionApi.getTransitionData", new io.flutter.plugin.a.n()).a(new b.AbstractC2252b<Object>(asVar) {
                /* class com.tencent.d.b.as.AnonymousClass13 */
                final /* synthetic */ as RJq;

                {
                    this.RJq = r1;
                }

                @Override // io.flutter.plugin.a.b.AbstractC2252b
                public final void a(Object obj, b.c<Object> cVar) {
                    AppMethodBeat.i(196119);
                    HashMap hashMap = new HashMap();
                    try {
                        this.RJq.dLx();
                        hashMap.put("result", null);
                    } catch (Exception e2) {
                        hashMap.put("error", b.q(e2));
                    }
                    cVar.eO(hashMap);
                    AppMethodBeat.o(196119);
                }
            });
            new io.flutter.plugin.a.b(cVar, "dev.flutter.pigeon.VideoEditorCompositionApi.saveImageByteToPath", new io.flutter.plugin.a.n()).a(new b.AbstractC2252b<Object>(asVar) {
                /* class com.tencent.d.b.as.AnonymousClass14 */
                final /* synthetic */ as RJq;

                {
                    this.RJq = r1;
                }

                @Override // io.flutter.plugin.a.b.AbstractC2252b
                public final void a(Object obj, b.c<Object> cVar) {
                    AppMethodBeat.i(196120);
                    HashMap hashMap = new HashMap();
                    try {
                        HashMap hashMap2 = (HashMap) obj;
                        ah ahVar = new ah();
                        ahVar.RJh = (byte[]) hashMap2.get("imageByte");
                        ahVar.path = (String) hashMap2.get("path");
                        this.RJq.a(ahVar);
                        hashMap.put("result", null);
                    } catch (Exception e2) {
                        hashMap.put("error", b.q(e2));
                    }
                    cVar.eO(hashMap);
                    AppMethodBeat.o(196120);
                }
            });
            new io.flutter.plugin.a.b(cVar, "dev.flutter.pigeon.VideoEditorCompositionApi.jumpToPostUI", new io.flutter.plugin.a.n()).a(new b.AbstractC2252b<Object>(asVar) {
                /* class com.tencent.d.b.as.AnonymousClass15 */
                final /* synthetic */ as RJq;

                {
                    this.RJq = r1;
                }

                @Override // io.flutter.plugin.a.b.AbstractC2252b
                public final void a(Object obj, b.c<Object> cVar) {
                    AppMethodBeat.i(196121);
                    HashMap hashMap = new HashMap();
                    try {
                        this.RJq.a(g.x((HashMap) obj));
                        hashMap.put("result", null);
                    } catch (Exception e2) {
                        hashMap.put("error", b.q(e2));
                    }
                    cVar.eO(hashMap);
                    AppMethodBeat.o(196121);
                }
            });
            new io.flutter.plugin.a.b(cVar, "dev.flutter.pigeon.VideoEditorCompositionApi.jumpToPostUI2", new io.flutter.plugin.a.n()).a(new b.AbstractC2252b<Object>(asVar) {
                /* class com.tencent.d.b.as.AnonymousClass16 */
                final /* synthetic */ as RJq;

                {
                    this.RJq = r1;
                }

                @Override // io.flutter.plugin.a.b.AbstractC2252b
                public final void a(Object obj, b.c<Object> cVar) {
                    Long valueOf;
                    AppMethodBeat.i(196122);
                    HashMap hashMap = new HashMap();
                    try {
                        ab abVar = new ab();
                        Object obj2 = ((HashMap) obj).get("id");
                        if (obj2 == null) {
                            valueOf = null;
                        } else {
                            valueOf = Long.valueOf(obj2 instanceof Integer ? (long) ((Integer) obj2).intValue() : ((Long) obj2).longValue());
                        }
                        abVar.RHm = valueOf;
                        this.RJq.a(abVar);
                        hashMap.put("result", null);
                    } catch (Exception e2) {
                        hashMap.put("error", b.q(e2));
                    }
                    cVar.eO(hashMap);
                    AppMethodBeat.o(196122);
                }
            });
            new io.flutter.plugin.a.b(cVar, "dev.flutter.pigeon.VideoEditorCompositionApi.checkFontFamilyRes", new io.flutter.plugin.a.n()).a(new b.AbstractC2252b<Object>(asVar) {
                /* class com.tencent.d.b.as.AnonymousClass17 */
                final /* synthetic */ as RJq;

                {
                    this.RJq = r1;
                }

                @Override // io.flutter.plugin.a.b.AbstractC2252b
                public final void a(Object obj, b.c<Object> cVar) {
                    AppMethodBeat.i(196123);
                    HashMap hashMap = new HashMap();
                    try {
                        y dLy = this.RJq.dLy();
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("exist", dLy.RJa);
                        hashMap.put("result", hashMap2);
                    } catch (Exception e2) {
                        hashMap.put("error", b.q(e2));
                    }
                    cVar.eO(hashMap);
                    AppMethodBeat.o(196123);
                }
            });
            new io.flutter.plugin.a.b(cVar, "dev.flutter.pigeon.VideoEditorCompositionApi.checkTransitionRes", new io.flutter.plugin.a.n()).a(new b.AbstractC2252b<Object>(asVar) {
                /* class com.tencent.d.b.as.AnonymousClass18 */
                final /* synthetic */ as RJq;

                {
                    this.RJq = r1;
                }

                @Override // io.flutter.plugin.a.b.AbstractC2252b
                public final void a(Object obj, b.c<Object> cVar) {
                    AppMethodBeat.i(196124);
                    HashMap hashMap = new HashMap();
                    try {
                        ar dLz = this.RJq.dLz();
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("exist", dLz.RJa);
                        hashMap.put("result", hashMap2);
                    } catch (Exception e2) {
                        hashMap.put("error", b.q(e2));
                    }
                    cVar.eO(hashMap);
                    AppMethodBeat.o(196124);
                }
            });
            new io.flutter.plugin.a.b(cVar, "dev.flutter.pigeon.VideoEditorCompositionApi.getFontDataResponse", new io.flutter.plugin.a.n()).a(new b.AbstractC2252b<Object>(asVar) {
                /* class com.tencent.d.b.as.AnonymousClass19 */
                final /* synthetic */ as RJq;

                {
                    this.RJq = r1;
                }

                @Override // io.flutter.plugin.a.b.AbstractC2252b
                public final void a(Object obj, b.c<Object> cVar) {
                    AppMethodBeat.i(196125);
                    HashMap hashMap = new HashMap();
                    try {
                        this.RJq.dLE();
                        hashMap.put("result", null);
                    } catch (Exception e2) {
                        hashMap.put("error", b.q(e2));
                    }
                    cVar.eO(hashMap);
                    AppMethodBeat.o(196125);
                }
            });
            new io.flutter.plugin.a.b(cVar, "dev.flutter.pigeon.VideoEditorCompositionApi.improveVideoQuality", new io.flutter.plugin.a.n()).a(new b.AbstractC2252b<Object>(asVar) {
                /* class com.tencent.d.b.as.AnonymousClass20 */
                final /* synthetic */ as RJq;

                {
                    this.RJq = r1;
                }

                @Override // io.flutter.plugin.a.b.AbstractC2252b
                public final void a(Object obj, b.c<Object> cVar) {
                    AppMethodBeat.i(196126);
                    HashMap hashMap = new HashMap();
                    try {
                        new e().RIt = (Boolean) ((HashMap) obj).get("requestBool");
                        hashMap.put("result", null);
                    } catch (Exception e2) {
                        hashMap.put("error", b.q(e2));
                    }
                    cVar.eO(hashMap);
                    AppMethodBeat.o(196126);
                }
            });
            new io.flutter.plugin.a.b(cVar, "dev.flutter.pigeon.VideoEditorCompositionApi.idkeyStat", new io.flutter.plugin.a.n()).a(new b.AbstractC2252b<Object>(asVar) {
                /* class com.tencent.d.b.as.AnonymousClass21 */
                final /* synthetic */ as RJq;

                {
                    this.RJq = r1;
                }

                @Override // io.flutter.plugin.a.b.AbstractC2252b
                public final void a(Object obj, b.c<Object> cVar) {
                    Long valueOf;
                    Long valueOf2;
                    Long valueOf3;
                    AppMethodBeat.i(196127);
                    HashMap hashMap = new HashMap();
                    try {
                        HashMap hashMap2 = (HashMap) obj;
                        z zVar = new z();
                        Object obj2 = hashMap2.get("id");
                        if (obj2 == null) {
                            valueOf = null;
                        } else {
                            valueOf = Long.valueOf(obj2 instanceof Integer ? (long) ((Integer) obj2).intValue() : ((Long) obj2).longValue());
                        }
                        zVar.RHm = valueOf;
                        Object obj3 = hashMap2.get("key");
                        if (obj3 == null) {
                            valueOf2 = null;
                        } else {
                            valueOf2 = Long.valueOf(obj3 instanceof Integer ? (long) ((Integer) obj3).intValue() : ((Long) obj3).longValue());
                        }
                        zVar.RJb = valueOf2;
                        Object obj4 = hashMap2.get("value");
                        if (obj4 == null) {
                            valueOf3 = null;
                        } else {
                            valueOf3 = Long.valueOf(obj4 instanceof Integer ? (long) ((Integer) obj4).intValue() : ((Long) obj4).longValue());
                        }
                        zVar.RJc = valueOf3;
                        this.RJq.a(zVar);
                        hashMap.put("result", null);
                    } catch (Exception e2) {
                        hashMap.put("error", b.q(e2));
                    }
                    cVar.eO(hashMap);
                    AppMethodBeat.o(196127);
                }
            });
            new io.flutter.plugin.a.b(cVar, "dev.flutter.pigeon.VideoEditorCompositionApi.getNetWorkType", new io.flutter.plugin.a.n()).a(new b.AbstractC2252b<Object>(asVar) {
                /* class com.tencent.d.b.as.AnonymousClass22 */
                final /* synthetic */ as RJq;

                {
                    this.RJq = r1;
                }

                @Override // io.flutter.plugin.a.b.AbstractC2252b
                public final void a(Object obj, b.c<Object> cVar) {
                    AppMethodBeat.i(196128);
                    HashMap hashMap = new HashMap();
                    try {
                        aa dLD = this.RJq.dLD();
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("result", dLD.RHG);
                        hashMap.put("result", hashMap2);
                    } catch (Exception e2) {
                        hashMap.put("error", b.q(e2));
                    }
                    cVar.eO(hashMap);
                    AppMethodBeat.o(196128);
                }
            });
            new io.flutter.plugin.a.b(cVar, "dev.flutter.pigeon.VideoEditorCompositionApi.getVideoGOPStr", new io.flutter.plugin.a.n()).a(new b.AbstractC2252b<Object>(asVar) {
                /* class com.tencent.d.b.as.AnonymousClass24 */
                final /* synthetic */ as RJq;

                {
                    this.RJq = r1;
                }

                @Override // io.flutter.plugin.a.b.AbstractC2252b
                public final void a(Object obj, b.c<Object> cVar) {
                    AppMethodBeat.i(196130);
                    HashMap hashMap = new HashMap();
                    try {
                        at atVar = new at();
                        atVar.RJr = (ArrayList) ((HashMap) obj).get("videoPathList");
                        al a2 = this.RJq.a(atVar);
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("reponseStr", a2.RJj);
                        hashMap.put("result", hashMap2);
                    } catch (Exception e2) {
                        hashMap.put("error", b.q(e2));
                    }
                    cVar.eO(hashMap);
                    AppMethodBeat.o(196130);
                }
            });
            new io.flutter.plugin.a.b(cVar, "dev.flutter.pigeon.VideoEditorCompositionApi.textToSpeech", new io.flutter.plugin.a.n()).a(new b.AbstractC2252b<Object>(asVar) {
                /* class com.tencent.d.b.as.AnonymousClass25 */
                final /* synthetic */ as RJq;

                {
                    this.RJq = r1;
                }

                @Override // io.flutter.plugin.a.b.AbstractC2252b
                public final void a(Object obj, b.c<Object> cVar) {
                    AppMethodBeat.i(196131);
                    HashMap hashMap = new HashMap();
                    try {
                        HashMap hashMap2 = (HashMap) obj;
                        an anVar = new an();
                        anVar.text = (String) hashMap2.get("text");
                        anVar.RJk = (String) hashMap2.get("uniqueKeyId");
                        this.RJq.a(anVar);
                        hashMap.put("result", null);
                    } catch (Exception e2) {
                        hashMap.put("error", b.q(e2));
                    }
                    cVar.eO(hashMap);
                    AppMethodBeat.o(196131);
                }
            });
            new io.flutter.plugin.a.b(cVar, "dev.flutter.pigeon.VideoEditorCompositionApi.addMember", new io.flutter.plugin.a.n()).a(new b.AbstractC2252b<Object>(asVar) {
                /* class com.tencent.d.b.as.AnonymousClass26 */
                final /* synthetic */ as RJq;

                {
                    this.RJq = r1;
                }

                @Override // io.flutter.plugin.a.b.AbstractC2252b
                public final void a(Object obj, b.c<Object> cVar) {
                    Long valueOf;
                    Long valueOf2;
                    AppMethodBeat.i(196132);
                    HashMap hashMap = new HashMap();
                    try {
                        HashMap hashMap2 = (HashMap) obj;
                        C0133b bVar = new C0133b();
                        bVar.BPp = (String) hashMap2.get("lrc");
                        Object obj2 = hashMap2.get("startTime");
                        if (obj2 == null) {
                            valueOf = null;
                        } else {
                            valueOf = Long.valueOf(obj2 instanceof Integer ? (long) ((Integer) obj2).intValue() : ((Long) obj2).longValue());
                        }
                        bVar.jnK = valueOf;
                        Object obj3 = hashMap2.get("endTime");
                        if (obj3 == null) {
                            valueOf2 = null;
                        } else {
                            valueOf2 = Long.valueOf(obj3 instanceof Integer ? (long) ((Integer) obj3).intValue() : ((Long) obj3).longValue());
                        }
                        bVar.RIr = valueOf2;
                        this.RJq.dLF();
                        hashMap.put("result", null);
                    } catch (Exception e2) {
                        hashMap.put("error", b.q(e2));
                    }
                    cVar.eO(hashMap);
                    AppMethodBeat.o(196132);
                }
            });
            new io.flutter.plugin.a.b(cVar, "dev.flutter.pigeon.VideoEditorCompositionApi.addMember2", new io.flutter.plugin.a.n()).a(new b.AbstractC2252b<Object>(asVar) {
                /* class com.tencent.d.b.as.AnonymousClass27 */
                final /* synthetic */ as RJq;

                {
                    this.RJq = r1;
                }

                @Override // io.flutter.plugin.a.b.AbstractC2252b
                public final void a(Object obj, b.c<Object> cVar) {
                    Long valueOf;
                    Long valueOf2;
                    AppMethodBeat.i(196133);
                    HashMap hashMap = new HashMap();
                    try {
                        HashMap hashMap2 = (HashMap) obj;
                        a aVar = new a();
                        aVar.cachePath = (String) hashMap2.get("cachePath");
                        aVar.musicUrl = (String) hashMap2.get("musicUrl");
                        Object obj2 = hashMap2.get(FFmpegMetadataRetriever.METADATA_KEY_DURATION);
                        if (obj2 == null) {
                            valueOf = null;
                        } else {
                            valueOf = Long.valueOf(obj2 instanceof Integer ? (long) ((Integer) obj2).intValue() : ((Long) obj2).longValue());
                        }
                        aVar.BOd = valueOf;
                        aVar.RIo = (ArrayList) hashMap2.get("lrcList");
                        aVar.BOZ = (ArrayList) hashMap2.get("singers");
                        aVar.BPc = (String) hashMap2.get("songName");
                        Object obj3 = hashMap2.get("musicId");
                        if (obj3 == null) {
                            valueOf2 = null;
                        } else {
                            valueOf2 = Long.valueOf(obj3 instanceof Integer ? (long) ((Integer) obj3).intValue() : ((Long) obj3).longValue());
                        }
                        aVar.RIp = valueOf2;
                        aVar.RIq = (Boolean) hashMap2.get("cached");
                        this.RJq.dLG();
                        hashMap.put("result", null);
                    } catch (Exception e2) {
                        hashMap.put("error", b.q(e2));
                    }
                    cVar.eO(hashMap);
                    AppMethodBeat.o(196133);
                }
            });
            new io.flutter.plugin.a.b(cVar, "dev.flutter.pigeon.VideoEditorCompositionApi.addMember3", new io.flutter.plugin.a.n()).a(new b.AbstractC2252b<Object>(asVar) {
                /* class com.tencent.d.b.as.AnonymousClass28 */
                final /* synthetic */ as RJq;

                {
                    this.RJq = r1;
                }

                @Override // io.flutter.plugin.a.b.AbstractC2252b
                public final void a(Object obj, b.c<Object> cVar) {
                    Long valueOf;
                    Long valueOf2;
                    AppMethodBeat.i(196134);
                    HashMap hashMap = new HashMap();
                    try {
                        HashMap hashMap2 = (HashMap) obj;
                        ag agVar = new ag();
                        agVar.musicUrl = (String) hashMap2.get("musicUrl");
                        agVar.BPc = (String) hashMap2.get("songName");
                        agVar.playUrl = (String) hashMap2.get("playUrl");
                        Object obj2 = hashMap2.get(FFmpegMetadataRetriever.METADATA_KEY_DURATION);
                        if (obj2 == null) {
                            valueOf = null;
                        } else {
                            valueOf = Long.valueOf(obj2 instanceof Integer ? (long) ((Integer) obj2).intValue() : ((Long) obj2).longValue());
                        }
                        agVar.BOd = valueOf;
                        agVar.RIq = (Boolean) hashMap2.get("cached");
                        Object obj3 = hashMap2.get("musicId");
                        if (obj3 == null) {
                            valueOf2 = null;
                        } else {
                            valueOf2 = Long.valueOf(obj3 instanceof Integer ? (long) ((Integer) obj3).intValue() : ((Long) obj3).longValue());
                        }
                        agVar.RIp = valueOf2;
                        agVar.BOZ = (ArrayList) hashMap2.get("singers");
                        agVar.RJg = (ArrayList) hashMap2.get("lrcInfoList");
                        agVar.cachePath = (String) hashMap2.get("cachePath");
                        this.RJq.dLH();
                        hashMap.put("result", null);
                    } catch (Exception e2) {
                        hashMap.put("error", b.q(e2));
                    }
                    cVar.eO(hashMap);
                    AppMethodBeat.o(196134);
                }
            });
            new io.flutter.plugin.a.b(cVar, "dev.flutter.pigeon.VideoEditorCompositionApi.addMember4", new io.flutter.plugin.a.n()).a(new b.AbstractC2252b<Object>(asVar) {
                /* class com.tencent.d.b.as.AnonymousClass29 */
                final /* synthetic */ as RJq;

                {
                    this.RJq = r1;
                }

                @Override // io.flutter.plugin.a.b.AbstractC2252b
                public final void a(Object obj, b.c<Object> cVar) {
                    Long valueOf;
                    AppMethodBeat.i(196135);
                    HashMap hashMap = new HashMap();
                    try {
                        HashMap hashMap2 = (HashMap) obj;
                        ae aeVar = new ae();
                        aeVar.RJd = (String) hashMap2.get("lrcContent");
                        Object obj2 = hashMap2.get("startPlayTime");
                        if (obj2 == null) {
                            valueOf = null;
                        } else {
                            valueOf = Long.valueOf(obj2 instanceof Integer ? (long) ((Integer) obj2).intValue() : ((Long) obj2).longValue());
                        }
                        aeVar.RJe = valueOf;
                        this.RJq.dLI();
                        hashMap.put("result", null);
                    } catch (Exception e2) {
                        hashMap.put("error", b.q(e2));
                    }
                    cVar.eO(hashMap);
                    AppMethodBeat.o(196135);
                }
            });
            new io.flutter.plugin.a.b(cVar, "dev.flutter.pigeon.VideoEditorCompositionApi.addMember5", new io.flutter.plugin.a.n()).a(new b.AbstractC2252b<Object>(asVar) {
                /* class com.tencent.d.b.as.AnonymousClass30 */
                final /* synthetic */ as RJq;

                {
                    this.RJq = r1;
                }

                @Override // io.flutter.plugin.a.b.AbstractC2252b
                public final void a(Object obj, b.c<Object> cVar) {
                    AppMethodBeat.i(196136);
                    HashMap hashMap = new HashMap();
                    try {
                        HashMap hashMap2 = (HashMap) obj;
                        ap apVar = new ap();
                        apVar.name = (String) hashMap2.get("name");
                        apVar.RJo = (String) hashMap2.get("svgName");
                        apVar.RJp = (String) hashMap2.get("effectPath");
                        this.RJq.dLJ();
                        hashMap.put("result", null);
                    } catch (Exception e2) {
                        hashMap.put("error", b.q(e2));
                    }
                    cVar.eO(hashMap);
                    AppMethodBeat.o(196136);
                }
            });
            new io.flutter.plugin.a.b(cVar, "dev.flutter.pigeon.VideoEditorCompositionApi.addMember10", new io.flutter.plugin.a.n()).a(new b.AbstractC2252b<Object>(asVar) {
                /* class com.tencent.d.b.as.AnonymousClass31 */
                final /* synthetic */ as RJq;

                {
                    this.RJq = r1;
                }

                @Override // io.flutter.plugin.a.b.AbstractC2252b
                public final void a(Object obj, b.c<Object> cVar) {
                    Long valueOf;
                    Long valueOf2;
                    AppMethodBeat.i(196137);
                    HashMap hashMap = new HashMap();
                    try {
                        HashMap hashMap2 = (HashMap) obj;
                        aq aqVar = new aq();
                        aqVar.path = (String) hashMap2.get("path");
                        Object obj2 = hashMap2.get("effectId");
                        if (obj2 == null) {
                            valueOf = null;
                        } else {
                            valueOf = Long.valueOf(obj2 instanceof Integer ? (long) ((Integer) obj2).intValue() : ((Long) obj2).longValue());
                        }
                        aqVar.RHl = valueOf;
                        Object obj3 = hashMap2.get(FFmpegMetadataRetriever.METADATA_KEY_DURATION);
                        if (obj3 == null) {
                            valueOf2 = null;
                        } else {
                            valueOf2 = Long.valueOf(obj3 instanceof Integer ? (long) ((Integer) obj3).intValue() : ((Long) obj3).longValue());
                        }
                        aqVar.BOd = valueOf2;
                        this.RJq.dLO();
                        hashMap.put("result", null);
                    } catch (Exception e2) {
                        hashMap.put("error", b.q(e2));
                    }
                    cVar.eO(hashMap);
                    AppMethodBeat.o(196137);
                }
            });
            new io.flutter.plugin.a.b(cVar, "dev.flutter.pigeon.VideoEditorCompositionApi.addMember6", new io.flutter.plugin.a.n()).a(new b.AbstractC2252b<Object>(asVar) {
                /* class com.tencent.d.b.as.AnonymousClass32 */
                final /* synthetic */ as RJq;

                {
                    this.RJq = r1;
                }

                @Override // io.flutter.plugin.a.b.AbstractC2252b
                public final void a(Object obj, b.c<Object> cVar) {
                    Long valueOf;
                    Long valueOf2;
                    Long valueOf3;
                    Long valueOf4;
                    Long valueOf5;
                    Long valueOf6;
                    Long valueOf7;
                    Long valueOf8;
                    Long valueOf9;
                    AppMethodBeat.i(196138);
                    HashMap hashMap = new HashMap();
                    try {
                        HashMap hashMap2 = (HashMap) obj;
                        ao aoVar = new ao();
                        aoVar.path = (String) hashMap2.get("path");
                        Object obj2 = hashMap2.get("type");
                        if (obj2 == null) {
                            valueOf = null;
                        } else {
                            valueOf = Long.valueOf(obj2 instanceof Integer ? (long) ((Integer) obj2).intValue() : ((Long) obj2).longValue());
                        }
                        aoVar.RHn = valueOf;
                        Object obj3 = hashMap2.get("startTimeMs");
                        if (obj3 == null) {
                            valueOf2 = null;
                        } else {
                            valueOf2 = Long.valueOf(obj3 instanceof Integer ? (long) ((Integer) obj3).intValue() : ((Long) obj3).longValue());
                        }
                        aoVar.RHq = valueOf2;
                        Object obj4 = hashMap2.get("endTimeMs");
                        if (obj4 == null) {
                            valueOf3 = null;
                        } else {
                            valueOf3 = Long.valueOf(obj4 instanceof Integer ? (long) ((Integer) obj4).intValue() : ((Long) obj4).longValue());
                        }
                        aoVar.RHr = valueOf3;
                        Object obj5 = hashMap2.get("trackStartTimeMs");
                        if (obj5 == null) {
                            valueOf4 = null;
                        } else {
                            valueOf4 = Long.valueOf(obj5 instanceof Integer ? (long) ((Integer) obj5).intValue() : ((Long) obj5).longValue());
                        }
                        aoVar.RHs = valueOf4;
                        Object obj6 = hashMap2.get("trackEndTimeMs");
                        if (obj6 == null) {
                            valueOf5 = null;
                        } else {
                            valueOf5 = Long.valueOf(obj6 instanceof Integer ? (long) ((Integer) obj6).intValue() : ((Long) obj6).longValue());
                        }
                        aoVar.RHt = valueOf5;
                        Object obj7 = hashMap2.get("sourceDuration");
                        if (obj7 == null) {
                            valueOf6 = null;
                        } else {
                            valueOf6 = Long.valueOf(obj7 instanceof Integer ? (long) ((Integer) obj7).intValue() : ((Long) obj7).longValue());
                        }
                        aoVar.RId = valueOf6;
                        Object obj8 = hashMap2.get("sourceWidth");
                        if (obj8 == null) {
                            valueOf7 = null;
                        } else {
                            valueOf7 = Long.valueOf(obj8 instanceof Integer ? (long) ((Integer) obj8).intValue() : ((Long) obj8).longValue());
                        }
                        aoVar.RIe = valueOf7;
                        Object obj9 = hashMap2.get("sourceHeight");
                        if (obj9 == null) {
                            valueOf8 = null;
                        } else {
                            valueOf8 = Long.valueOf(obj9 instanceof Integer ? (long) ((Integer) obj9).intValue() : ((Long) obj9).longValue());
                        }
                        aoVar.RIf = valueOf8;
                        aoVar.RJl = (Double) hashMap2.get("sourceScale");
                        aoVar.RIj = (Double) hashMap2.get("volume");
                        Object obj10 = hashMap2.get("fromCamera");
                        if (obj10 == null) {
                            valueOf9 = null;
                        } else {
                            valueOf9 = Long.valueOf(obj10 instanceof Integer ? (long) ((Integer) obj10).intValue() : ((Long) obj10).longValue());
                        }
                        aoVar.RJm = valueOf9;
                        aoVar.RJn = (aq) hashMap2.get("transitionInfoProto");
                        this.RJq.dLK();
                        hashMap.put("result", null);
                    } catch (Exception e2) {
                        hashMap.put("error", b.q(e2));
                    }
                    cVar.eO(hashMap);
                    AppMethodBeat.o(196138);
                }
            });
            new io.flutter.plugin.a.b(cVar, "dev.flutter.pigeon.VideoEditorCompositionApi.addMember7", new io.flutter.plugin.a.n()).a(new b.AbstractC2252b<Object>(asVar) {
                /* class com.tencent.d.b.as.AnonymousClass33 */
                final /* synthetic */ as RJq;

                {
                    this.RJq = r1;
                }

                @Override // io.flutter.plugin.a.b.AbstractC2252b
                public final void a(Object obj, b.c<Object> cVar) {
                    Long valueOf;
                    AppMethodBeat.i(196139);
                    HashMap hashMap = new HashMap();
                    try {
                        HashMap hashMap2 = (HashMap) obj;
                        au auVar = new au();
                        auVar.IFw = (String) hashMap2.get("templatePath");
                        auVar.iiv = (String) hashMap2.get("musicPath");
                        Object obj2 = hashMap2.get(FFmpegMetadataRetriever.METADATA_KEY_DURATION);
                        if (obj2 == null) {
                            valueOf = null;
                        } else {
                            valueOf = Long.valueOf(obj2 instanceof Integer ? (long) ((Integer) obj2).intValue() : ((Long) obj2).longValue());
                        }
                        auVar.BOd = valueOf;
                        auVar.RJs = (Boolean) hashMap2.get("trackCropToTemplateSize");
                        this.RJq.dLL();
                        hashMap.put("result", null);
                    } catch (Exception e2) {
                        hashMap.put("error", b.q(e2));
                    }
                    cVar.eO(hashMap);
                    AppMethodBeat.o(196139);
                }
            });
            new io.flutter.plugin.a.b(cVar, "dev.flutter.pigeon.VideoEditorCompositionApi.addMember8", new io.flutter.plugin.a.n()).a(new b.AbstractC2252b<Object>(asVar) {
                /* class com.tencent.d.b.as.AnonymousClass35 */
                final /* synthetic */ as RJq;

                {
                    this.RJq = r1;
                }

                @Override // io.flutter.plugin.a.b.AbstractC2252b
                public final void a(Object obj, b.c<Object> cVar) {
                    Long valueOf;
                    Long valueOf2;
                    Long valueOf3;
                    Long valueOf4;
                    Long valueOf5;
                    Long valueOf6;
                    Long valueOf7;
                    Long valueOf8;
                    Long valueOf9;
                    Long valueOf10;
                    Long valueOf11;
                    AppMethodBeat.i(196141);
                    HashMap hashMap = new HashMap();
                    try {
                        HashMap hashMap2 = (HashMap) obj;
                        h hVar = new h();
                        Object obj2 = hashMap2.get("absSwitch");
                        if (obj2 == null) {
                            valueOf = null;
                        } else {
                            valueOf = Long.valueOf(obj2 instanceof Integer ? (long) ((Integer) obj2).intValue() : ((Long) obj2).longValue());
                        }
                        hVar.RIE = valueOf;
                        Object obj3 = hashMap2.get("audioBitrate");
                        if (obj3 == null) {
                            valueOf2 = null;
                        } else {
                            valueOf2 = Long.valueOf(obj3 instanceof Integer ? (long) ((Integer) obj3).intValue() : ((Long) obj3).longValue());
                        }
                        hVar.RHD = valueOf2;
                        Object obj4 = hashMap2.get("audioChannelCount");
                        if (obj4 == null) {
                            valueOf3 = null;
                        } else {
                            valueOf3 = Long.valueOf(obj4 instanceof Integer ? (long) ((Integer) obj4).intValue() : ((Long) obj4).longValue());
                        }
                        hVar.RHF = valueOf3;
                        Object obj5 = hashMap2.get("audioSampleRate");
                        if (obj5 == null) {
                            valueOf4 = null;
                        } else {
                            valueOf4 = Long.valueOf(obj5 instanceof Integer ? (long) ((Integer) obj5).intValue() : ((Long) obj5).longValue());
                        }
                        hVar.RHE = valueOf4;
                        Object obj6 = hashMap2.get("fps");
                        if (obj6 == null) {
                            valueOf5 = null;
                        } else {
                            valueOf5 = Long.valueOf(obj6 instanceof Integer ? (long) ((Integer) obj6).intValue() : ((Long) obj6).longValue());
                        }
                        hVar.RHB = valueOf5;
                        Object obj7 = hashMap2.get("iFrame");
                        if (obj7 == null) {
                            valueOf6 = null;
                        } else {
                            valueOf6 = Long.valueOf(obj7 instanceof Integer ? (long) ((Integer) obj7).intValue() : ((Long) obj7).longValue());
                        }
                        hVar.RIF = valueOf6;
                        Object obj8 = hashMap2.get("originHeight");
                        if (obj8 == null) {
                            valueOf7 = null;
                        } else {
                            valueOf7 = Long.valueOf(obj8 instanceof Integer ? (long) ((Integer) obj8).intValue() : ((Long) obj8).longValue());
                        }
                        hVar.RIG = valueOf7;
                        Object obj9 = hashMap2.get("originWidth");
                        if (obj9 == null) {
                            valueOf8 = null;
                        } else {
                            valueOf8 = Long.valueOf(obj9 instanceof Integer ? (long) ((Integer) obj9).intValue() : ((Long) obj9).longValue());
                        }
                        hVar.RIH = valueOf8;
                        hVar.RII = (ArrayList) hashMap2.get("originRect");
                        hVar.rpE = (String) hashMap2.get("outputPath");
                        hVar.RIJ = (Double) hashMap2.get("outputScale");
                        Object obj10 = hashMap2.get("targetHeight");
                        if (obj10 == null) {
                            valueOf9 = null;
                        } else {
                            valueOf9 = Long.valueOf(obj10 instanceof Integer ? (long) ((Integer) obj10).intValue() : ((Long) obj10).longValue());
                        }
                        hVar.RIK = valueOf9;
                        Object obj11 = hashMap2.get("targetWidth");
                        if (obj11 == null) {
                            valueOf10 = null;
                        } else {
                            valueOf10 = Long.valueOf(obj11 instanceof Integer ? (long) ((Integer) obj11).intValue() : ((Long) obj11).longValue());
                        }
                        hVar.RIL = valueOf10;
                        Object obj12 = hashMap2.get("videoBitrate");
                        if (obj12 == null) {
                            valueOf11 = null;
                        } else {
                            valueOf11 = Long.valueOf(obj12 instanceof Integer ? (long) ((Integer) obj12).intValue() : ((Long) obj12).longValue());
                        }
                        hVar.RHA = valueOf11;
                        this.RJq.dLM();
                        hashMap.put("result", null);
                    } catch (Exception e2) {
                        hashMap.put("error", b.q(e2));
                    }
                    cVar.eO(hashMap);
                    AppMethodBeat.o(196141);
                }
            });
            new io.flutter.plugin.a.b(cVar, "dev.flutter.pigeon.VideoEditorCompositionApi.addMember9", new io.flutter.plugin.a.n()).a(new b.AbstractC2252b<Object>(asVar) {
                /* class com.tencent.d.b.as.AnonymousClass36 */
                final /* synthetic */ as RJq;

                {
                    this.RJq = r1;
                }

                @Override // io.flutter.plugin.a.b.AbstractC2252b
                public final void a(Object obj, b.c<Object> cVar) {
                    AppMethodBeat.i(196142);
                    HashMap hashMap = new HashMap();
                    try {
                        g.x((HashMap) obj);
                        this.RJq.dLN();
                        hashMap.put("result", null);
                    } catch (Exception e2) {
                        hashMap.put("error", b.q(e2));
                    }
                    cVar.eO(hashMap);
                    AppMethodBeat.o(196142);
                }
            });
        }
    }

    static /* synthetic */ HashMap q(Exception exc) {
        AppMethodBeat.i(196148);
        HashMap hashMap = new HashMap();
        hashMap.put("message", exc.toString());
        hashMap.put(TMQQDownloaderOpenSDKConst.UINTYPE_CODE, null);
        hashMap.put("details", null);
        AppMethodBeat.o(196148);
        return hashMap;
    }
}
