package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.an.e;
import com.tencent.mm.an.f;
import com.tencent.mm.g.b.a.w;
import com.tencent.mm.g.b.a.y;
import com.tencent.mm.i.a;
import com.tencent.mm.i.c;
import com.tencent.mm.i.g;
import com.tencent.mm.i.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.network.ag;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.ahv;
import com.tencent.mm.protocal.protobuf.ahw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.bz;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.ByteArrayOutputStream;
import java.util.Map;
import junit.framework.Assert;
import org.xwalk.core.XWalkFeature;

public final class d extends q implements m {
    i callback;
    String fileName;
    int iKP;
    private MTimerHandler iKj;
    String iYT;
    String iYZ;
    int iZa;
    private g.a iZc;
    boolean jqo;
    boolean jqp;
    s jqq;
    h jqr;
    int jqs;
    private boolean jqt;
    boolean jqu;
    long jqv;
    private String mediaId;
    int retCode;
    private com.tencent.mm.ak.d rr;
    private int startOffset;
    long startTime;

    @Override // com.tencent.mm.ak.q
    public final void cancel() {
        AppMethodBeat.i(126827);
        Qt();
        super.cancel();
        AppMethodBeat.o(126827);
    }

    /* access modifiers changed from: package-private */
    public final boolean Qt() {
        boolean z = false;
        AppMethodBeat.i(126828);
        if (!Util.isNullOrNil(this.mediaId)) {
            if (this.jqo) {
                Log.i("MicroMsg.NetSceneDownloadVideo", "%s cancel online video task.", bgZ());
                o.bhk().m(this.mediaId, null);
            } else {
                Log.i("MicroMsg.NetSceneDownloadVideo", "%s cancel offline video task.", bgZ());
                f.baQ().Oc(this.mediaId);
            }
            z = true;
        }
        this.jqt = true;
        AppMethodBeat.o(126828);
        return z;
    }

    public d(String str) {
        this(str, false);
    }

    public d(String str, boolean z) {
        AppMethodBeat.i(126829);
        this.jqq = null;
        this.iYT = "";
        this.startOffset = 0;
        this.startTime = 0;
        this.iKP = 0;
        this.retCode = 0;
        this.jqs = a.MediaType_VIDEO;
        this.jqt = false;
        this.jqu = true;
        this.iYZ = null;
        this.iZa = 0;
        this.jqv = 0;
        this.iZc = new g.a() {
            /* class com.tencent.mm.modelvideo.d.AnonymousClass1 */

            @Override // com.tencent.mm.i.g.a
            public final int a(String str, int i2, c cVar, com.tencent.mm.i.d dVar, boolean z) {
                int i3;
                AppMethodBeat.i(126824);
                if (i2 == -21006) {
                    Log.d("MicroMsg.NetSceneDownloadVideo", "%s cdntra  ERR_CNDCOM_MEDIA_IS_DOWNLOADING clientid:%s", d.this.bgZ(), d.this.iYT);
                    AppMethodBeat.o(126824);
                    return 0;
                } else if (i2 != 0) {
                    u.QE(d.this.fileName);
                    String t = com.tencent.mm.plugin.report.a.t(Integer.valueOf(i2), 2, Long.valueOf(d.this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(d.this.jqs), Integer.valueOf(d.this.iKP), "");
                    new y(t).bfK();
                    new w(t).bfK();
                    d.this.callback.onSceneEnd(3, i2, "", d.this);
                    AppMethodBeat.o(126824);
                    return 0;
                } else {
                    d.this.jqq = u.QN(d.this.fileName);
                    if (d.this.jqq == null || d.this.jqq.status == 113) {
                        if (d.this.jqq == null) {
                            i3 = -1;
                        } else {
                            i3 = d.this.jqq.status;
                        }
                        Log.i("MicroMsg.NetSceneDownloadVideo", "%s upload video info is null or has paused, status:%d", d.this.bgZ(), Integer.valueOf(i3));
                        d.this.Qt();
                        d.this.callback.onSceneEnd(3, i2, "upload video info is null or has paused, status".concat(String.valueOf(i3)), d.this);
                        AppMethodBeat.o(126824);
                        return 0;
                    } else if (cVar == null) {
                        if (dVar != null) {
                            Log.i("MicroMsg.NetSceneDownloadVideo", "%s cdntra sceneResult.retCode:%d useTime:%d ", d.this.bgZ(), Integer.valueOf(dVar.field_retCode), Long.valueOf(Util.nowMilliSecond() - d.this.jqv));
                            d dVar2 = d.this;
                            h hVar = d.this.jqr;
                            if (hVar == null || dVar == null) {
                                Log.w("MicroMsg.NetSceneDownloadVideo", "it had not task info or scene Result, don't report.");
                            } else if (hVar.field_smallVideoFlag == 1) {
                                Log.i("MicroMsg.NetSceneDownloadVideo", "it download short video, don't report.");
                            } else if (!(hVar == null || dVar == null)) {
                                Log.i("MicroMsg.NetSceneDownloadVideo", "%s sceneResult.field_recvedBytes %d, time [%d, %d]", dVar2.bgZ(), Long.valueOf(dVar.field_recvedBytes), Long.valueOf(dVar.field_startTime), Long.valueOf(dVar.field_endTime));
                                o.bhk();
                                e.a((Object[]) null, dVar, hVar, true);
                            }
                            if (dVar.field_retCode != 0) {
                                u.QE(d.this.fileName);
                                if (d.this.jqo) {
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(354, 13, 1, false);
                                }
                                if (d.this.jqp) {
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(354, 252, 1, false);
                                }
                                d.this.callback.onSceneEnd(3, dVar.field_retCode, "", d.this);
                            } else {
                                if (d.this.jqo) {
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(354, 12, 1, false);
                                }
                                if (d.this.jqp) {
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(354, 137, 1, false);
                                }
                                d.this.ud((int) dVar.field_fileLength);
                            }
                            new y(com.tencent.mm.plugin.report.a.t(Integer.valueOf(dVar.field_retCode), 2, Long.valueOf(d.this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(d.this.jqs), Integer.valueOf(d.this.iKP), dVar.field_transInfo, "", "", "", "", "", "", "", dVar.gqk)).bfK();
                            if (dVar.field_retCode != 0) {
                                new w(com.tencent.mm.plugin.report.a.t(Integer.valueOf(dVar.field_retCode), 2, Long.valueOf(d.this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(d.this.jqs), Integer.valueOf(d.this.iKP), dVar.field_transInfo, "", "", "", "", "", "", "", dVar.gqk)).bfK();
                            }
                            a.a(d.this.jqq, 1);
                            d.this.jqr = null;
                        }
                        AppMethodBeat.o(126824);
                        return 0;
                    } else if (cVar.field_finishedLength == ((long) d.this.iKP)) {
                        Log.d("MicroMsg.NetSceneDownloadVideo", "cdntra ignore progress 100%");
                        AppMethodBeat.o(126824);
                        return 0;
                    } else if (((long) d.this.jqq.jsj) <= cVar.field_finishedLength || d.this.jqo) {
                        int i4 = 1024;
                        d.this.jqq.jsm = Util.nowSecond();
                        if (((long) d.this.jqq.jsj) < cVar.field_finishedLength) {
                            d.this.jqq.jsj = (int) cVar.field_finishedLength;
                            i4 = XWalkFeature.INTERFACE_SHOW_HIDE;
                        }
                        d.this.jqq.cSx = i4;
                        u.f(d.this.jqq);
                        Log.d("MicroMsg.NetSceneDownloadVideo", "%s cdntra progresscallback id:%s finish:%d total:%d", d.this.bgZ(), d.this.iYT, Long.valueOf(cVar.field_finishedLength), Long.valueOf(cVar.field_toltalLength));
                        AppMethodBeat.o(126824);
                        return 0;
                    } else {
                        Log.e("MicroMsg.NetSceneDownloadVideo", "%s cdnEndProc error oldpos:%d newpos:%d", d.this.bgZ(), Integer.valueOf(d.this.jqq.jsj), Long.valueOf(cVar.field_finishedLength));
                        u.QE(d.this.fileName);
                        d.this.callback.onSceneEnd(3, i2, "", d.this);
                        AppMethodBeat.o(126824);
                        return 0;
                    }
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
        this.iKj = new MTimerHandler(new MTimerHandler.CallBack() {
            /* class com.tencent.mm.modelvideo.d.AnonymousClass3 */

            @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
            public final boolean onTimerExpired() {
                AppMethodBeat.i(126826);
                if (d.this.doScene(d.this.dispatcher(), d.this.callback) == -1) {
                    d.this.callback.onSceneEnd(3, -1, "doScene failed", d.this);
                }
                AppMethodBeat.o(126826);
                return false;
            }
        }, false);
        Assert.assertTrue(str != null);
        this.fileName = str;
        this.jqo = z;
        Log.i("MicroMsg.NetSceneDownloadVideo", "%s NetSceneDownloadVideo:  file [%s] isCompleteOnlineVideo [%b]", bgZ(), str, Boolean.valueOf(z));
        AppMethodBeat.o(126829);
    }

    /* JADX WARNING: Removed duplicated region for block: B:64:0x0506  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x05dc  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x05fb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean bgY() {
        /*
        // Method dump skipped, instructions count: 1819
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelvideo.d.bgY():boolean");
    }

    /* access modifiers changed from: package-private */
    public final void ud(final int i2) {
        final boolean z;
        AppMethodBeat.i(126831);
        if (this.jqu) {
            StringBuilder sb = new StringBuilder();
            o.bhj();
            o oVar = new o(sb.append(t.Qw(this.fileName)).append(".tmp").toString());
            o.bhj();
            z = oVar.am(new o(t.Qw(this.fileName)));
        } else {
            StringBuilder sb2 = new StringBuilder();
            o.bhj();
            s.deleteFile(sb2.append(t.Qw(this.fileName)).append(".tmp").toString());
            z = true;
        }
        com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.modelvideo.d.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(126825);
                Map<String, String> parseXml = XmlParser.parseXml(d.this.jqq.bhv(), "msg", null);
                if (parseXml != null) {
                    t bhj = o.bhj();
                    o.bhj();
                    bhj.q(t.Qw(d.this.fileName), parseXml.get(".msg.videomsg.$cdnvideourl"), parseXml.get(".msg.videomsg.$aeskey"));
                }
                boolean z = false;
                if (z) {
                    z = u.ay(d.this.fileName, i2);
                    if (d.this.jqp) {
                        u.QS(d.this.fileName);
                        Log.i("MicroMsg.NetSceneDownloadVideo", "sceneEndproc, isHadHevcLocalFile");
                    }
                } else if (d.this.jqp) {
                    u.QE(d.this.fileName);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(354, 138, 1, false);
                } else {
                    z = u.ay(d.this.fileName, i2);
                }
                Log.i("MicroMsg.NetSceneDownloadVideo", "%s ashutest::cdntra !FIN! file:%s svrid:%d human:%s user:%s updatedbsucc:%b  MediaCheckDuplicationStorage MD5:%s SIZE:%d renameFlag %b needRename %b", d.this.bgZ(), d.this.fileName, Long.valueOf(d.this.jqq.dTS), d.this.jqq.bhs(), d.this.jqq.getUser(), Boolean.valueOf(z), d.this.iYZ, Integer.valueOf(d.this.iZa), Boolean.valueOf(z), Boolean.valueOf(d.this.jqu));
                if (!Util.isNullOrNil(d.this.iYZ) && d.this.iZa > 0) {
                    bz aSV = ((com.tencent.mm.plugin.m.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.m.a.a.class)).aSV();
                    String str = d.this.iYZ;
                    int i2 = d.this.iZa;
                    o.bhj();
                    aSV.P(str, i2, t.Qw(d.this.fileName));
                }
                if (d.this.jqq.jsu == 3) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(198, 38, (long) d.this.jqq.iKP, false);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(198, 40, (long) d.this.jqq.iFw, false);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(198, 41, 1, false);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(198, ab.Eq(d.this.jqq.getUser()) ? 43 : 42, 1, false);
                } else {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(198, 31, (long) d.this.jqq.iKP, false);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(198, 33, (long) d.this.jqq.iFw, false);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(198, 34, 1, false);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(198, ab.Eq(d.this.jqq.getUser()) ? 36 : 35, 1, false);
                }
                d.this.callback.onSceneEnd(0, 0, "", d.this);
                AppMethodBeat.o(126825);
            }
        });
        AppMethodBeat.o(126831);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        int i2 = 1;
        AppMethodBeat.i(126832);
        this.callback = iVar;
        this.jqq = u.QN(this.fileName);
        if (this.jqq == null) {
            Log.e("MicroMsg.NetSceneDownloadVideo", "ERR: Get INFO FAILED :" + this.fileName);
            this.retCode = (0 - com.tencent.mm.compatible.util.f.getLine()) - 10000;
            AppMethodBeat.o(126832);
            return -1;
        }
        if (this.jqq != null && 3 == this.jqq.jsu) {
            this.jqs = a.MediaType_TinyVideo;
        }
        if (this.startTime == 0) {
            this.startTime = Util.nowMilliSecond();
            this.startOffset = this.jqq.jsj;
        }
        if (bgY()) {
            Log.d("MicroMsg.NetSceneDownloadVideo", "cdntra use cdn return -1 for onGYNetEnd clientid:%s", this.fileName);
            AppMethodBeat.o(126832);
            return 0;
        } else if (this.jqq.status != 112) {
            Log.e("MicroMsg.NetSceneDownloadVideo", "ERR: STATUS: " + this.jqq.status + " [" + this.fileName + "," + this.jqq.dTS + "," + this.jqq.bhs() + "," + this.jqq.getUser() + "]");
            this.retCode = (0 - com.tencent.mm.compatible.util.f.getLine()) - 10000;
            AppMethodBeat.o(126832);
            return -1;
        } else {
            Log.d("MicroMsg.NetSceneDownloadVideo", "start doScene  [" + this.fileName + "," + this.jqq.dTS + "," + this.jqq.bhs() + "," + this.jqq.getUser() + "]  filesize:" + this.jqq.jsj + " file:" + this.jqq.iKP + " netTimes:" + this.jqq.jsp);
            if (!u.QD(this.fileName)) {
                Log.e("MicroMsg.NetSceneDownloadVideo", "ERR: NET TIMES: " + this.jqq.jsp + " [" + this.fileName + "," + this.jqq.dTS + "," + this.jqq.bhs() + "," + this.jqq.getUser() + "] ");
                u.QE(this.fileName);
                this.retCode = (0 - com.tencent.mm.compatible.util.f.getLine()) - 10000;
                AppMethodBeat.o(126832);
                return -1;
            } else if (this.jqq.dTS <= 0) {
                Log.e("MicroMsg.NetSceneDownloadVideo", "ERR: MSGSVRID: " + this.jqq.dTS + " [" + this.fileName + "," + this.jqq.dTS + "," + this.jqq.bhs() + "," + this.jqq.getUser() + "] ");
                u.QE(this.fileName);
                this.retCode = (0 - com.tencent.mm.compatible.util.f.getLine()) - 10000;
                AppMethodBeat.o(126832);
                return -1;
            } else if (this.jqq.jsj < 0 || this.jqq.iKP <= this.jqq.jsj || this.jqq.iKP <= 0) {
                Log.e("MicroMsg.NetSceneDownloadVideo", "ERR: fileSize:" + this.jqq.jsj + " total:" + this.jqq.iKP + " [" + this.fileName + "," + this.jqq.dTS + "," + this.jqq.bhs() + "," + this.jqq.getUser() + "] ");
                u.QE(this.fileName);
                this.retCode = (0 - com.tencent.mm.compatible.util.f.getLine()) - 10000;
                AppMethodBeat.o(126832);
                return -1;
            } else {
                d.a aVar = new d.a();
                aVar.iLN = new ahv();
                aVar.iLO = new ahw();
                aVar.uri = "/cgi-bin/micromsg-bin/downloadvideo";
                aVar.funcId = 150;
                aVar.iLP = 40;
                aVar.respCmdId = 1000000040;
                this.rr = aVar.aXF();
                ahv ahv = (ahv) this.rr.iLK.iLR;
                ahv.Brn = this.jqq.dTS;
                ahv.BsG = this.jqq.jsj;
                ahv.BsF = this.jqq.iKP;
                if (!ag.dm(MMApplicationContext.getContext())) {
                    i2 = 2;
                }
                ahv.LrC = i2;
                int dispatch = dispatch(gVar, this.rr, this);
                AppMethodBeat.o(126832);
                return dispatch;
            }
        }
    }

    @Override // com.tencent.mm.ak.q
    public final q.b securityVerificationChecked(com.tencent.mm.network.s sVar) {
        AppMethodBeat.i(126833);
        ahv ahv = (ahv) ((com.tencent.mm.ak.d) sVar).iLK.iLR;
        if (ahv.Brn <= 0 || ahv.BsG < 0 || ahv.BsF <= 0 || ahv.BsF <= ahv.BsG) {
            Log.e("MicroMsg.NetSceneDownloadVideo", "ERR: SECURITY CHECK FAILED [" + this.fileName + "," + this.jqq.dTS + "," + this.jqq.bhs() + "," + this.jqq.getUser() + "] ");
            u.QE(this.fileName);
            q.b bVar = q.b.EFailed;
            AppMethodBeat.o(126833);
            return bVar;
        }
        q.b bVar2 = q.b.EOk;
        AppMethodBeat.o(126833);
        return bVar2;
    }

    @Override // com.tencent.mm.ak.q
    public final int securityLimitCount() {
        return 2500;
    }

    @Override // com.tencent.mm.ak.q
    public final boolean securityLimitCountReach() {
        AppMethodBeat.i(126834);
        boolean securityLimitCountReach = super.securityLimitCountReach();
        if (securityLimitCountReach) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(111, 210, 1, false);
        }
        AppMethodBeat.o(126834);
        return securityLimitCountReach;
    }

    @Override // com.tencent.mm.ak.q
    public final void setSecurityCheckError(q.a aVar) {
        AppMethodBeat.i(126835);
        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(111, 211, 1, false);
        u.QE(this.fileName);
        AppMethodBeat.o(126835);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, com.tencent.mm.network.s sVar, byte[] bArr) {
        int i5;
        AppMethodBeat.i(126836);
        if (this.jqt) {
            Log.d("MicroMsg.NetSceneDownloadVideo", "onGYNetEnd Call Stop by Service  [" + this.fileName + "," + this.jqq.dTS + "," + this.jqq.bhs() + "," + this.jqq.getUser() + "] ");
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(126836);
        } else if (i3 == 3 && i4 == -1 && !Util.isNullOrNil(this.iYT)) {
            Log.w("MicroMsg.NetSceneDownloadVideo", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", this.iYT);
            AppMethodBeat.o(126836);
        } else {
            ahw ahw = (ahw) ((com.tencent.mm.ak.d) sVar).iLL.iLR;
            ahv ahv = (ahv) ((com.tencent.mm.ak.d) sVar).iLK.iLR;
            this.jqq = u.QN(this.fileName);
            if (this.jqq == null) {
                Log.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd Get INFO FAILED :" + this.fileName);
                this.retCode = (0 - com.tencent.mm.compatible.util.f.getLine()) - 10000;
                this.callback.onSceneEnd(i3, i4, str, this);
                AppMethodBeat.o(126836);
            } else if (this.jqq.status == 113) {
                Log.w("MicroMsg.NetSceneDownloadVideo", "onGYNetEnd STATUS PAUSE [" + this.fileName + "," + this.jqq.dTS + "," + this.jqq.bhs() + "," + this.jqq.getUser() + "] ");
                this.callback.onSceneEnd(i3, i4, str, this);
                AppMethodBeat.o(126836);
            } else if (this.jqq.status != 112) {
                Log.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd STATUS ERR: status:" + this.jqq.status + " [" + this.fileName + "," + this.jqq.dTS + "," + this.jqq.bhs() + "," + this.jqq.getUser() + "] ");
                this.callback.onSceneEnd(i3, i4, str, this);
                AppMethodBeat.o(126836);
            } else if (i3 == 4 && i4 != 0) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(111, 208, 1, false);
                Log.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd SERVER FAILED errtype:" + i3 + " errCode:" + i4 + " [" + this.fileName + "," + this.jqq.dTS + "," + this.jqq.bhs() + "," + this.jqq.getUser() + "] ");
                u.QE(this.fileName);
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(10420, Integer.valueOf(i4), 2, Long.valueOf(this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(this.jqs), Integer.valueOf(this.iKP - this.startOffset));
                this.callback.onSceneEnd(i3, i4, str, this);
                AppMethodBeat.o(126836);
            } else if (i3 != 0 || i4 != 0) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(111, 207, 1, false);
                Log.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd SERVER FAILED (SET PAUSE) errtype:" + i3 + " errCode:" + i4 + " [" + this.fileName + "," + this.jqq.dTS + "," + this.jqq.bhs() + "," + this.jqq.getUser() + "] ");
                this.jqq.status = 113;
                u.f(this.jqq);
                this.callback.onSceneEnd(i3, i4, str, this);
                AppMethodBeat.o(126836);
            } else if (Util.isNullOrNil(ahw.BsI.getBuffer().zy)) {
                Log.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd Recv BUF ZERO length  [" + this.fileName + "," + this.jqq.dTS + "," + this.jqq.bhs() + "," + this.jqq.getUser() + "] ");
                u.QE(this.fileName);
                this.callback.onSceneEnd(i3, i4, str, this);
                AppMethodBeat.o(126836);
            } else if (ahw.BsG != ahv.BsG) {
                Log.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd OFFSET ERROR respStartPos:" + ahw.BsG + " reqStartPos:" + ahv.BsG + " [" + this.fileName + "," + this.jqq.dTS + "," + this.jqq.bhs() + "," + this.jqq.getUser() + "] ");
                u.QE(this.fileName);
                this.callback.onSceneEnd(i3, i4, str, this);
                AppMethodBeat.o(126836);
            } else if (ahw.BsF != ahv.BsF) {
                Log.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd respTotal:" + ahw.BsF + " reqTotal:" + ahv.BsF + " [" + this.fileName + "," + this.jqq.dTS + "," + this.jqq.bhs() + "," + this.jqq.getUser() + "] ");
                u.QE(this.fileName);
                this.callback.onSceneEnd(i3, i4, str, this);
                AppMethodBeat.o(126836);
            } else if (ahv.BsF < ahw.BsG) {
                Log.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd respTotal:" + ahw.BsF + " respStartPos:" + ahv.BsG + " [" + this.fileName + "," + this.jqq.dTS + "," + this.jqq.bhs() + "," + this.jqq.getUser() + "] ");
                u.QE(this.fileName);
                this.callback.onSceneEnd(i3, i4, str, this);
                AppMethodBeat.o(126836);
            } else if (ahw.Brn != ahv.Brn) {
                Log.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd respMsgId:" + ahw.Brn + " reqMsgId:" + ahv.Brn + " [" + this.fileName + "," + this.jqq.dTS + "," + this.jqq.bhs() + "," + this.jqq.getUser() + "] ");
                u.QE(this.fileName);
                this.callback.onSceneEnd(i3, i4, str, this);
                AppMethodBeat.o(126836);
            } else {
                Log.d("MicroMsg.NetSceneDownloadVideo", "onGYNetEnd respBuf:" + ahw.BsI.getILen() + " reqStartPos:" + ahv.BsG + " totallen:" + ahv.BsF + " [" + this.fileName + "," + this.jqq.dTS + "," + this.jqq.bhs() + "," + this.jqq.getUser() + "] ");
                o.bhj();
                int a2 = t.a(t.Qw(this.fileName), ahv.BsG, ahw.BsI.getBuffer().toByteArray());
                if (a2 < 0) {
                    Log.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd WRITEFILE RET:" + a2 + " [" + this.fileName + "," + this.jqq.dTS + "," + this.jqq.bhs() + "," + this.jqq.getUser() + "] ");
                    u.QE(this.fileName);
                    this.callback.onSceneEnd(i3, i4, str, this);
                    AppMethodBeat.o(126836);
                } else if (a2 > this.jqq.iKP) {
                    Log.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd WRITEFILE newOffset:" + a2 + " totalLen:" + this.jqq.iKP + " [" + this.fileName + "," + this.jqq.dTS + "," + this.jqq.bhs() + "," + this.jqq.getUser() + "] ");
                    u.QE(this.fileName);
                    this.callback.onSceneEnd(i3, i4, str, this);
                    AppMethodBeat.o(126836);
                } else {
                    String str2 = this.fileName;
                    s QN = u.QN(str2);
                    if (QN == null) {
                        Log.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.f.apq() + " getinfo failed: " + str2);
                        i5 = 0 - com.tencent.mm.compatible.util.f.getLine();
                    } else {
                        QN.jsj = a2;
                        QN.jsm = Util.nowSecond();
                        QN.cSx = XWalkFeature.INTERFACE_SHOW_HIDE;
                        i5 = 0;
                        if (QN.iKP > 0 && a2 >= QN.iKP) {
                            u.e(QN);
                            QN.status = 199;
                            QN.cSx |= 256;
                            Log.i("MicroMsg.VideoLogic", "END!!!  updateRecv  file:" + str2 + " newsize:" + a2 + " total:" + QN.iKP + " status:" + QN.status + " netTimes:" + QN.jsp);
                            i5 = 1;
                        }
                        Log.d("MicroMsg.VideoLogic", "updateRecv " + com.tencent.mm.compatible.util.f.apq() + " file:" + str2 + " newsize:" + a2 + " total:" + QN.iKP + " status:" + QN.status);
                        if (!u.f(QN)) {
                            i5 = 0 - com.tencent.mm.compatible.util.f.getLine();
                        }
                    }
                    if (i5 < 0) {
                        Log.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd updateAfterRecv Ret:" + i5 + " newOffset :" + a2 + " [" + this.fileName + "," + this.jqq.dTS + "," + this.jqq.bhs() + "," + this.jqq.getUser() + "] ");
                        this.callback.onSceneEnd(i3, i4, str, this);
                        AppMethodBeat.o(126836);
                    } else if (i5 == 1) {
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(10420, 0, 2, Long.valueOf(this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(this.jqs), Integer.valueOf(this.iKP - this.startOffset));
                        a.a(this.jqq, 1);
                        Log.i("MicroMsg.NetSceneDownloadVideo", "!!!FIN [" + this.fileName + "," + this.jqq.dTS + "," + this.jqq.bhs() + "," + this.jqq.getUser() + "]");
                        this.callback.onSceneEnd(i3, i4, str, this);
                        AppMethodBeat.o(126836);
                    } else if (this.jqt) {
                        this.callback.onSceneEnd(i3, i4, str, this);
                        AppMethodBeat.o(126836);
                    } else {
                        this.iKj.startTimer(0);
                        AppMethodBeat.o(126836);
                    }
                }
            }
        }
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 150;
    }

    /* access modifiers changed from: package-private */
    public final String bgZ() {
        AppMethodBeat.i(126837);
        String str = this.fileName + "_" + hashCode();
        AppMethodBeat.o(126837);
        return str;
    }
}
