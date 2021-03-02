package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.f;
import com.tencent.mm.g.a.wb;
import com.tencent.mm.g.b.a.w;
import com.tencent.mm.g.b.a.y;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.n;
import com.tencent.mm.plugin.mmsight.model.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.pluginsdk.model.z;
import com.tencent.mm.protocal.protobuf.cly;
import com.tencent.mm.protocal.protobuf.cmw;
import com.tencent.mm.protocal.protobuf.cne;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.io.ByteArrayOutputStream;

public final class ad {
    q DJN;
    a DJO;
    private cne DJP;
    private String clientId;
    int ecf;
    int gVY;
    String iYT;
    private g.a iZc;
    private long jSo;
    int jrO;
    private String lAl;
    private String mPath;
    long startTime;
    private String thumbPath;

    public interface a {
        void uO(boolean z);
    }

    public ad(int i2, q qVar, String str, String str2, a aVar) {
        AppMethodBeat.i(95701);
        this.clientId = "";
        this.jSo = 0;
        this.startTime = 0;
        this.gVY = 0;
        this.lAl = "";
        this.DJP = new cne();
        this.iZc = new g.a() {
            /* class com.tencent.mm.plugin.sns.model.ad.AnonymousClass4 */

            @Override // com.tencent.mm.i.g.a
            public final int a(String str, int i2, c cVar, d dVar, boolean z) {
                AppMethodBeat.i(95700);
                if (i2 == -21005) {
                    Log.d("MicroMsg.SightCdnUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", ad.this.iYT, Integer.valueOf(i2), cVar, dVar);
                    ad.this.DJO.uO(true);
                    AppMethodBeat.o(95700);
                    return 0;
                } else if (dVar != null && dVar.field_retCode == 0) {
                    Log.i("MicroMsg.SightCdnUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", ad.this.iYT, Integer.valueOf(i2), cVar, dVar);
                    ad.this.aN(dVar.field_fileUrl, dVar.field_thumbUrl, "upload_" + ad.this.iYT);
                    new y(com.tencent.mm.plugin.report.a.t(0, 1, Long.valueOf(ad.this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(ad.this.gVY), Long.valueOf(dVar.field_fileLength), dVar.field_transInfo, "", "", "", "", "", "", "", dVar.gqk)).bfK();
                    n bhh = n.bhh();
                    int i3 = ad.this.ecf;
                    int i4 = ad.this.jrO;
                    if (dVar != null) {
                        String str2 = dVar.field_fileUrl;
                        String valueOf = String.valueOf(i3);
                        n.a aVar = bhh.jrv.get(valueOf);
                        if (aVar == null) {
                            aVar = new n.a();
                        }
                        aVar.fqK = "";
                        aVar.toUser = "";
                        aVar.jrK = "";
                        aVar.jrO = i4;
                        aVar.jrN = 1;
                        aVar.dRP = str2;
                        aVar.jaC = dVar;
                        aVar.startTime = Util.nowMilliSecond();
                        bhh.jrv.put(valueOf, aVar);
                        Log.i("MicroMsg.SubCoreMediaRpt", "note sns video sendScene %d snsKey[%s] url[%s]", Integer.valueOf(i4), valueOf, str2);
                    }
                    ad.this.DJO.uO(true);
                    AppMethodBeat.o(95700);
                    return 0;
                } else if (dVar != null && dVar.field_retCode != 0) {
                    Log.i("MicroMsg.SightCdnUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", ad.this.iYT, Integer.valueOf(i2), cVar, dVar);
                    ad.this.Ys(0);
                    String t = com.tencent.mm.plugin.report.a.t(Integer.valueOf(dVar.field_retCode), 1, Long.valueOf(ad.this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(ad.this.gVY), Long.valueOf(dVar.field_fileLength), dVar.field_transInfo, "", "", "", "", "", "", "", dVar.gqk);
                    new y(t).bfK();
                    new w(t).bfK();
                    ad.this.DJO.uO(false);
                    AppMethodBeat.o(95700);
                    return 0;
                } else if (i2 != 0) {
                    Log.i("MicroMsg.SightCdnUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", ad.this.iYT, Integer.valueOf(i2), cVar, dVar);
                    ad.this.Ys(0);
                    if (dVar != null) {
                        new y(com.tencent.mm.plugin.report.a.t(Integer.valueOf(i2), 1, Long.valueOf(ad.this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(ad.this.gVY), Long.valueOf(dVar.field_fileLength), dVar.field_transInfo, "", "", "", "", "", "", "", dVar.gqk)).bfK();
                    }
                    ad.this.DJO.uO(false);
                    AppMethodBeat.o(95700);
                    return 0;
                } else {
                    Log.d("MicroMsg.SightCdnUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", ad.this.iYT, Integer.valueOf(i2), cVar, dVar);
                    AppMethodBeat.o(95700);
                    return 0;
                }
            }

            @Override // com.tencent.mm.i.g.a
            public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
            }

            @Override // com.tencent.mm.i.g.a
            public final byte[] f(String str, byte[] bArr) {
                return null;
            }
        };
        this.jSo = System.currentTimeMillis();
        this.mPath = str;
        this.thumbPath = str2;
        this.DJO = aVar;
        this.ecf = i2;
        this.DJN = qVar;
        try {
            this.DJP = (cne) new cne().parseFrom(qVar.EmR);
            this.clientId = this.DJP.Mtu;
            this.lAl = this.DJP.md5;
            if (Util.isNullOrNil(this.clientId)) {
                this.clientId = com.tencent.mm.b.g.getMessageDigest(new StringBuilder().append(Util.currentTicks()).toString().getBytes());
                this.DJP.Mtu = this.clientId;
                try {
                    qVar.EmR = this.DJP.toByteArray();
                    aj.faD().a(qVar.localid, qVar);
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.SightCdnUpload", e2, "", new Object[0]);
                }
            }
            Log.i("MicroMsg.SightCdnUpload", "sightupload %d videopath %s sightFileSize %d md5 %s", Integer.valueOf(i2), str, Integer.valueOf((int) s.boW(str)), this.lAl);
            AppMethodBeat.o(95701);
        } catch (Exception e3) {
            Log.e("MicroMsg.SightCdnUpload", "parseFrom MediaUploadInfo error in NetSceneSnsUpload");
            AppMethodBeat.o(95701);
        }
    }

    public final boolean aPf(final String str) {
        final cly cly;
        long j2;
        AppMethodBeat.i(95702);
        String bhK = s.bhK(this.mPath);
        if (Util.isNullOrNil(this.lAl) || this.lAl.equals(bhK)) {
            if (this.DJP.Mtx != null) {
                cly = this.DJP.Mtx;
            } else {
                cly = new cly();
            }
            if (!Util.isNullOrNil(str) && cly.Mrr) {
                Log.i("MicroMsg.SightCdnUpload", "from skip compress, set local capture to true, appId:%s", str);
                cly.Mrn = true;
                cly.Mrs = str;
            }
            Log.i("MicroMsg.SightCdnUpload", "check upload %s %d %s %s", this.mPath, Integer.valueOf(cly.vUh), Boolean.valueOf(cly.Mrn), str);
            com.tencent.mm.plugin.sight.base.a aNx = e.aNx(this.mPath);
            if (aNx != null) {
                Log.i("MicroMsg.SightCdnUpload", "mediaInfo: %s", aNx);
                if (!Util.isNullOrNil(str)) {
                    j2 = (long) MultiProcessMMKV.getSingleMMKV("OpenSdkVideoTime").decodeInt(str, 10);
                } else {
                    j2 = cly.Mrn ? (long) com.tencent.mm.modelcontrol.e.baZ().bbb().duration : (long) com.tencent.mm.modelcontrol.e.baZ().bbc().duration;
                }
                if (j2 <= 0) {
                    j2 = 10;
                }
                long j3 = (j2 * 1000) + 3000;
                Log.i("MicroMsg.SightCdnUpload", "maxVideoLen: %s", Long.valueOf(j3));
                if (((long) aNx.videoDuration) >= j3) {
                    Log.i("MicroMsg.SightCdnUpload", "checkUpload isNotSafeSightVideo videoDuration: %s ", Integer.valueOf(aNx.videoDuration));
                    Ys(-2);
                    this.DJO.uO(false);
                    AppMethodBeat.o(95702);
                    return false;
                }
            }
            if (!cly.Mrn) {
                a(cly, str);
                AppMethodBeat.o(95702);
                return true;
            }
            int i2 = i.zut;
            if (cly.vUh >= 3) {
                onError();
                AppMethodBeat.o(95702);
                return false;
            }
            Log.i("MicroMsg.SightCdnUpload", "try need remux %d %s", Integer.valueOf(i2), this.mPath);
            final wb wbVar = new wb();
            wbVar.callback = new Runnable() {
                /* class com.tencent.mm.plugin.sns.model.ad.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(95697);
                    Log.i("MicroMsg.SightCdnUpload", "event callback errcode %d", Integer.valueOf(wbVar.ecj.result));
                    if (wbVar.ecj.result >= 0) {
                        ad.a(ad.this);
                        ad.this.a(cly, str);
                        AppMethodBeat.o(95697);
                        return;
                    }
                    ad.this.onError();
                    AppMethodBeat.o(95697);
                }
            };
            wbVar.eci.ecm = new com.tencent.mm.plugin.mmsight.model.e() {
                /* class com.tencent.mm.plugin.sns.model.ad.AnonymousClass2 */

                @Override // com.tencent.mm.plugin.mmsight.model.e
                public final boolean ehT() {
                    AppMethodBeat.i(95698);
                    Log.i("MicroMsg.SightCdnUpload", "iUpdateVideoFile");
                    ad.a(ad.this);
                    AppMethodBeat.o(95698);
                    return false;
                }
            };
            wbVar.eci.ebP = this.mPath;
            wbVar.eci.scene = i2;
            wbVar.eci.eck = cly;
            wbVar.eci.ecl = new Runnable() {
                /* class com.tencent.mm.plugin.sns.model.ad.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(95699);
                    cly.vUh++;
                    try {
                        Log.i("MicroMsg.SightCdnUpload", "add try count %d", Integer.valueOf(cly.vUh));
                        cne cne = (cne) new cne().parseFrom(ad.this.DJN.EmR);
                        cne.Mtx = cly;
                        ad.this.DJN.EmR = cne.toByteArray();
                        aj.faD().a(ad.this.DJN.localid, ad.this.DJN);
                        AppMethodBeat.o(95699);
                    } catch (Exception e2) {
                        Log.e("MicroMsg.SightCdnUpload", "parseFrom MediaUploadInfo error in checkUploadaddCount %s", e2.getMessage());
                        AppMethodBeat.o(95699);
                    }
                }
            };
            EventCenter.instance.asyncPublish(wbVar, aj.faB());
            AppMethodBeat.o(95702);
            return true;
        }
        Log.i("MicroMsg.SightCdnUpload", "checkUpload isNotSafeSightVideo old srcmd5 %s newmd5 %s ", this.lAl, bhK);
        Ys(-2);
        this.DJO.uO(false);
        AppMethodBeat.o(95702);
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean a(cly cly, String str) {
        VideoTransPara bbc;
        AppMethodBeat.i(95703);
        if (this.startTime == 0) {
            this.startTime = Util.nowMilliSecond();
            this.gVY = com.tencent.mm.i.a.gpT;
        }
        String str2 = this.clientId;
        if (Util.isNullOrNil(str2)) {
            Log.w("MicroMsg.SightCdnUpload", "cdntra genClientId failed not use cdn");
            AppMethodBeat.o(95703);
            return false;
        }
        g gVar = new g();
        gVar.taskName = "task_NetSceneSnsUpload_2";
        gVar.gqy = this.iZc;
        gVar.field_mediaId = str2;
        gVar.field_fullpath = this.mPath;
        gVar.field_thumbpath = this.thumbPath;
        gVar.field_fileType = com.tencent.mm.i.a.gpT;
        gVar.field_talker = "";
        gVar.field_priority = com.tencent.mm.i.a.gpM;
        gVar.field_needStorage = true;
        gVar.field_isStreamMedia = false;
        gVar.field_appType = 102;
        gVar.field_bzScene = 1;
        if (!Util.isNullOrNil(str)) {
            gVar.field_largesvideo = MultiProcessMMKV.getSingleMMKV("OpenSdkVideoTime").decodeInt(str, 10);
        } else {
            com.tencent.mm.modelcontrol.e.baZ();
            if (cly.Mrn) {
                bbc = com.tencent.mm.modelcontrol.e.baZ().bbb();
            } else {
                bbc = com.tencent.mm.modelcontrol.e.baZ().bbc();
            }
            gVar.field_largesvideo = com.tencent.mm.modelcontrol.e.b(bbc);
        }
        if (z.bdw(this.mPath)) {
            h.INSTANCE.idkeyStat(106, 31, 1, false);
            gVar.snsVersion = 1;
        }
        String bhK = s.bhK(this.mPath);
        if (!Util.isNullOrNil(this.lAl) && !this.lAl.equals(bhK)) {
            Log.i("MicroMsg.SightCdnUpload", "isNotSafeSightVideo old srcmd5 %s newmd5 %s ", this.lAl, bhK);
            Ys(-2);
            this.DJO.uO(false);
            AppMethodBeat.o(95703);
            return false;
        } else if (!f.baQ().f(gVar)) {
            Log.e("MicroMsg.SightCdnUpload", "cdntra addSendTask failed. clientid:%s", str2);
            AppMethodBeat.o(95703);
            return false;
        } else {
            this.jrO = (cly == null || !cly.Mrn) ? 5 : 4;
            AppMethodBeat.o(95703);
            return true;
        }
    }

    public final boolean aN(String str, String str2, String str3) {
        cne cne;
        AppMethodBeat.i(95704);
        q JK = aj.faD().JK((long) this.ecf);
        Log.d("MicroMsg.SightCdnUpload", "upload ok " + str + "  " + str3 + "  1");
        JK.EmQ = str3;
        try {
            cne = (cne) new cne().parseFrom(JK.EmR);
        } catch (Exception e2) {
            cne = null;
        }
        if (cne == null) {
            cne = new cne();
        }
        cmw cmw = new cmw();
        cmw.oUv = 1;
        cmw.Url = str;
        cne.Mtr = cmw;
        cne.Mpa = 0;
        f.baR();
        cne.MsS = com.tencent.mm.an.a.NX(this.mPath);
        Log.i("MicroMsg.SightCdnUpload", "onPostScene videomd5 %s", cne.MsS);
        if (!Util.isNullOrNil(str2)) {
            cmw cmw2 = new cmw();
            cmw2.oUv = 1;
            cmw2.Url = str2;
            cne.Mtt.add(cmw2);
        }
        try {
            JK.EmR = cne.toByteArray();
        } catch (Exception e3) {
            Log.printErrStackTrace("MicroMsg.SightCdnUpload", e3, "", new Object[0]);
        }
        JK.ffa();
        aj.faD().a(this.ecf, JK);
        aj.faN().Yx(this.ecf);
        if (aj.faK() != null) {
            aj.faK().eZn();
        }
        AppMethodBeat.o(95704);
        return true;
    }

    /* access modifiers changed from: package-private */
    public final void Ys(int i2) {
        AppMethodBeat.i(95705);
        Log.i("MicroMsg.SightCdnUpload", "snsupload sight by cdn error!");
        q JK = aj.faD().JK((long) this.ecf);
        try {
            cne cne = (cne) new cne().parseFrom(JK.EmR);
            cne.Mpa = 1;
            cne.Mtd = i2;
            if (this.DJP.Mtx != null) {
                this.DJP.Mtx.vUh = 0;
            }
            JK.EmR = cne.toByteArray();
        } catch (Exception e2) {
        }
        aj.faN().Yx(this.ecf);
        aj.faD().a(this.ecf, JK);
        AppMethodBeat.o(95705);
    }

    /* access modifiers changed from: package-private */
    public final void onError() {
        AppMethodBeat.i(95706);
        Log.i("MicroMsg.SightCdnUpload", "snsupload sight by cdn error!");
        q JK = aj.faD().JK((long) this.ecf);
        JK.offset = 0;
        try {
            cne cne = (cne) new cne().parseFrom(JK.EmR);
            cne.Mtu = "";
            if (cne.Mtx != null) {
                cne.Mtx.vUh = 0;
            }
            JK.EmR = cne.toByteArray();
            aj.faD().a(this.ecf, JK);
            aj.faN().Yx(this.ecf);
            AppMethodBeat.o(95706);
        } catch (Exception e2) {
            Log.e("MicroMsg.SightCdnUpload", "parseFrom MediaUploadInfo error in NetSceneSnsUpload");
            AppMethodBeat.o(95706);
        }
    }

    static /* synthetic */ void a(ad adVar) {
        AppMethodBeat.i(95707);
        try {
            adVar.DJP = (cne) new cne().parseFrom(adVar.DJN.EmR);
            adVar.lAl = s.bhK(adVar.mPath);
            adVar.DJP.md5 = adVar.lAl;
            adVar.DJN.EmR = adVar.DJP.toByteArray();
            Log.i("MicroMsg.SightCdnUpload", "new md5 is %s %s", adVar.mPath, adVar.lAl);
            aj.faD().a(adVar.DJN.localid, adVar.DJN);
            AppMethodBeat.o(95707);
        } catch (Exception e2) {
            Log.e("MicroMsg.SightCdnUpload", "parseFrom MediaUploadInfo error in updateMd5Info %s", e2.getMessage());
            AppMethodBeat.o(95707);
        }
    }
}
