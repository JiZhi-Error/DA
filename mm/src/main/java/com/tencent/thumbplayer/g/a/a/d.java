package com.tencent.thumbplayer.g.a.a;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.map.geolocation.sapp.TencentLocation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.LinkedList;
import java.util.List;

public final class d {
    c ScJ = new c();
    j ScK = new j();
    f ScL = new f();
    C2208d ScM = new C2208d();
    e ScN = new e();
    h ScO = new h();
    k ScP = new k();
    b ScQ = new b();
    m ScR = new m();
    i ScS = new i();
    g ScT = new g();
    n ScU = new n();

    public d() {
        AppMethodBeat.i(189593);
        c cVar = this.ScJ;
        cVar.Sdi = 0;
        cVar.Sdj = 0;
        cVar.Sdk = 0;
        cVar.Sdl = "";
        cVar.Sdm = "";
        cVar.Sdn = "";
        cVar.Sdo = "";
        cVar.Sdp = "";
        cVar.Sdq = 0;
        cVar.Sdr = "";
        cVar.Sds = "";
        cVar.Sdt = "";
        cVar.Sdu = "";
        cVar.Sdv = 0;
        cVar.Sdw = 0;
        cVar.Sdx = 0;
        cVar.Sdy = 0;
        cVar.Sdz = 0;
        cVar.SdA = "";
        cVar.SdB = "";
        cVar.SdC = 0;
        cVar.SdD = "";
        cVar.SdE = "";
        cVar.SdF = "";
        cVar.SdG = "";
        cVar.SdH = 0;
        cVar.SdI = 0;
        cVar.SdJ = 0;
        cVar.scenesId = 0;
        cVar.SdL = 0;
        cVar.SdM = "";
        cVar.SdN = "";
        cVar.SdO = 0;
        cVar.SdP = 0;
        cVar.SdQ = 0.0f;
        j jVar = this.ScK;
        jVar.SeI = 0;
        jVar.SeJ = 0;
        jVar.Sdd = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        f fVar = this.ScL;
        fVar.Sda = 0;
        fVar.Sdb = 0;
        fVar.SdV = "";
        fVar.Sdd = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        C2208d dVar = this.ScM;
        dVar.Sda = 0;
        dVar.SdR = 0;
        dVar.SdS = 0;
        dVar.Sdb = 0;
        dVar.SdT = "";
        dVar.SdU = 0;
        dVar.Sdd = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        e eVar = this.ScN;
        eVar.Sda = 0;
        eVar.Sdb = 0;
        eVar.Sdd = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        h hVar = this.ScO;
        hVar.Sda = 0;
        hVar.Sdb = 0;
        hVar.Sdg = 0;
        hVar.SeF = "";
        hVar.SeG = 0;
        hVar.SdU = 0;
        hVar.Sdd = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        k kVar = this.ScP;
        kVar.Sda = 0;
        kVar.Sdb = 0;
        kVar.SeK = "";
        kVar.SeG = 0;
        kVar.SeL = 0;
        kVar.Sdd = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        this.ScQ.reset();
        this.ScR.reset();
        i iVar = this.ScS;
        iVar.ScX = 0;
        iVar.Sdb = 0;
        iVar.SeH = 0.0f;
        iVar.Sdd = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        AppMethodBeat.o(189593);
    }

    public class c {
        public String SdA;
        public String SdB;
        public int SdC;
        public String SdD;
        public String SdE;
        public String SdF;
        public String SdG;
        public int SdH;
        public int SdI;
        public int SdJ;
        public int SdK;
        public int SdL;
        public String SdM;
        public String SdN;
        public int SdO;
        public int SdP;
        public float SdQ;
        public int Sdi;
        public int Sdj = 0;
        public long Sdk;
        public String Sdl;
        public String Sdm;
        public String Sdn;
        public String Sdo;
        public String Sdp;
        public int Sdq;
        public String Sdr;
        public String Sds;
        public String Sdt;
        public String Sdu;
        public int Sdv;
        public int Sdw;
        public int Sdx;
        public int Sdy;
        public int Sdz;
        public int scenesId;

        public c() {
        }

        public final void c(a aVar) {
            AppMethodBeat.i(189587);
            aVar.put("step", this.Sdi);
            aVar.put("seq", this.Sdj);
            aVar.put(TPDownloadProxyEnum.USER_PLATFORM, this.Sdk);
            aVar.put("flowid", this.Sdl);
            aVar.put("playno", this.Sdm);
            aVar.put(OpenSDKTool4Assistant.EXTRA_UIN, this.Sdn);
            aVar.put("QQopenid", this.Sdo);
            aVar.put("WXopenid", this.Sdp);
            aVar.put("logintype", this.Sdq);
            aVar.put(TPDownloadProxyEnum.USER_GUID, this.Sdr);
            aVar.put("uip", this.Sds);
            aVar.put("cdnuip", this.Sdt);
            aVar.put("cdnip", this.Sdu);
            aVar.put("online", this.Sdv);
            aVar.put("p2p", this.Sdw);
            aVar.put("sstrength", this.Sdx);
            aVar.put(TencentLocation.NETWORK_PROVIDER, this.Sdy);
            aVar.put("speed", this.Sdz);
            aVar.put("device", this.SdA);
            aVar.put("resolution", this.SdB);
            aVar.put("testid", this.SdC);
            aVar.put("osver", this.SdD);
            aVar.put("p2pver", this.SdE);
            aVar.put("appver", this.SdF);
            aVar.put("playerver", this.SdG);
            aVar.put("playertype", this.SdH);
            aVar.put("confid", this.SdI);
            aVar.put("cdnid", this.SdJ);
            aVar.put("scenesid", this.scenesId);
            aVar.put("playtype", this.SdK);
            aVar.put("dltype", this.SdL);
            aVar.put("vid", this.SdM);
            aVar.put("definition", this.SdN);
            aVar.put("fmt", this.SdO);
            aVar.put("rate", this.SdP);
            aVar.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, this.SdQ);
            AppMethodBeat.o(189587);
        }
    }

    public class j {
        public String Sdd;
        public long SeI;
        public long SeJ;

        public j() {
        }

        public final void c(a aVar) {
            AppMethodBeat.i(189589);
            aVar.put("stime", this.SeI);
            aVar.put("etime", this.SeJ);
            aVar.put(TMQQDownloaderOpenSDKConst.UINTYPE_CODE, this.Sdd);
            AppMethodBeat.o(189589);
        }
    }

    public class f {
        public String SdV;
        public long Sda;
        public long Sdb;
        public String Sdd;

        public f() {
        }
    }

    /* renamed from: com.tencent.thumbplayer.g.a.a.d$d  reason: collision with other inner class name */
    public class C2208d {
        public long SdR;
        public long SdS;
        public String SdT;
        public int SdU;
        public long Sda;
        public long Sdb;
        public String Sdd;

        public C2208d() {
        }
    }

    public class e {
        public long Sda;
        public long Sdb;
        public String Sdd;

        public e() {
        }
    }

    public class h {
        public int SdU;
        public long Sda;
        public long Sdb;
        public String Sdd;
        public int Sdg;
        public String SeF;
        public int SeG;

        public h() {
        }
    }

    public class k {
        public long Sda;
        public long Sdb;
        public String Sdd;
        public int SeG;
        public String SeK;
        public int SeL;

        public k() {
        }
    }

    public class b {
        public int Sdf;
        public int Sdg;
        public List<a> Sdh = new LinkedList();

        public b() {
            AppMethodBeat.i(189584);
            AppMethodBeat.o(189584);
        }

        public final void reset() {
            AppMethodBeat.i(189585);
            this.Sdf = 0;
            this.Sdg = 0;
            this.Sdh.clear();
            AppMethodBeat.o(189585);
        }

        public final void c(a aVar) {
            AppMethodBeat.i(189586);
            aVar.put("bcount", this.Sdf);
            aVar.put("tduration", this.Sdg);
            AppMethodBeat.o(189586);
        }
    }

    public class a {
        public int ScV;
        public int ScW;
        public int ScX;
        public int ScY;
        public long ScZ;
        public long Sda;
        public long Sdb;
        public String Sdc;
        public String Sdd;

        public a() {
        }
    }

    public class m {
        public int SeQ;
        public int SeR;
        public int SeS;
        public List<l> SeT = new LinkedList();

        public m() {
            AppMethodBeat.i(189590);
            AppMethodBeat.o(189590);
        }

        public final void reset() {
            AppMethodBeat.i(189591);
            this.SeQ = 0;
            this.SeR = 0;
            this.SeS = 0;
            this.SeT.clear();
            AppMethodBeat.o(189591);
        }

        public final void c(a aVar) {
            AppMethodBeat.i(189592);
            aVar.put("scount", this.SeQ);
            aVar.put("tbcount", this.SeR);
            aVar.put("tbduration", this.SeS);
            AppMethodBeat.o(189592);
        }
    }

    public class l {
        public int ScY;
        public String Sdd;
        public long SeM;
        public long SeN;
        public long SeO;
        public long SeP;

        public l() {
        }
    }

    public class i {
        public int ScX;
        public long Sdb;
        public String Sdd;
        public float SeH;

        public i() {
        }

        public final void c(a aVar) {
            AppMethodBeat.i(189588);
            aVar.put("reason", this.ScX);
            aVar.put("etime", this.Sdb);
            aVar.put("playduration", this.SeH);
            aVar.put(TMQQDownloaderOpenSDKConst.UINTYPE_CODE, this.Sdd);
            AppMethodBeat.o(189588);
        }
    }

    public class n {
        int SeU;
        int SeV;
        int SeW;
        int SeX;
        int SeY;
        int SeZ;
        int Sed;
        int Sfa;
        int Sfb;
        int Sfc;

        public n() {
        }
    }

    public class g {
        String ScH;
        String ScI;
        String SdG;
        long SdW;
        String SdX;
        String SdY;
        int SdZ;
        int Sdy;
        int SeA;
        int SeB;
        String SeC;
        int SeD;
        int SeE;
        int Sea;
        String Seb;
        int Sec;
        int Sed;
        int See;
        int Sef;
        int Seg;
        int Seh;
        int Sei;
        int Sej;
        int Sek;
        String Sel;
        int Sem;
        String Sen;
        int Seo;
        int Sep;
        int Seq;
        String Ser;
        int Ses;
        int Set;
        int Seu;
        int Sev;
        int Sew;
        long Sex;
        int Sey;
        int Sez;
        String downloadUrl;

        public g() {
        }
    }
}
