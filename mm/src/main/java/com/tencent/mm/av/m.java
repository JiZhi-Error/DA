package com.tencent.mm.av;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.q;
import com.tencent.mm.an.f;
import com.tencent.mm.g.b.a.w;
import com.tencent.mm.g.b.a.y;
import com.tencent.mm.i.c;
import com.tencent.mm.i.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.modelstat.h;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.protocal.protobuf.bqv;
import com.tencent.mm.protocal.protobuf.bqw;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.o;
import com.tencent.tavkit.component.TAVExporter;
import java.io.ByteArrayOutputStream;
import java.util.Map;
import junit.framework.Assert;

public final class m extends q implements com.tencent.mm.network.m {
    String TAG;
    i callback;
    ca dCM;
    int gVY;
    long hmj;
    private boolean iKG;
    int iKP;
    private int iXp;
    final j iYO;
    public final long iYP;
    private long iYQ;
    private int iYR;
    private h iYS;
    String iYT;
    private String iYU;
    public String iYV;
    int iYW;
    public boolean iYX;
    private int iYY;
    private String iYZ;
    private int iZa;
    boolean iZb;
    private g.a iZc;
    private long msgId;
    private final d rr;
    private int startOffset;
    long startTime;
    private int token;

    static /* synthetic */ boolean a(m mVar, g gVar, int i2, int i3, int i4) {
        AppMethodBeat.i(150679);
        boolean a2 = mVar.a(gVar, i2, i3, i4, (byte[]) null);
        AppMethodBeat.o(150679);
        return a2;
    }

    public m(long j2, long j3, int i2, j jVar) {
        this(j2, j3, i2, jVar, -1);
    }

    public m(long j2, long j3, int i2, final j jVar, int i3) {
        g gVar;
        AppMethodBeat.i(150673);
        this.TAG = "MicroMsg.NetSceneGetMsgImg";
        this.iYQ = -1;
        this.iYS = null;
        this.msgId = -1;
        this.dCM = null;
        this.iYT = "";
        this.startTime = 0;
        this.startOffset = -1;
        this.gVY = 0;
        this.iKG = true;
        this.iYU = "";
        this.iYV = "";
        this.iKP = 0;
        this.iYW = -1;
        this.iYX = false;
        this.iYY = -1;
        this.iYZ = null;
        this.iZa = 0;
        this.token = -1;
        this.iZb = false;
        this.iZc = new g.a() {
            /* class com.tencent.mm.av.m.AnonymousClass2 */

            @Override // com.tencent.mm.i.g.a
            public final int a(String str, int i2, c cVar, com.tencent.mm.i.d dVar, boolean z) {
                String str2;
                long j2;
                String str3;
                AppMethodBeat.i(150671);
                if (i2 == -21006) {
                    Log.i(m.this.TAG, "cdntra  ERR_CNDCOM_MEDIA_IS_DOWNLOADING clientid:%s", m.this.iYT);
                    AppMethodBeat.o(150671);
                    return 0;
                } else if (i2 != 0) {
                    k.tp((int) m.this.iYP);
                    k.to((int) m.this.iYP);
                    Object[] objArr = new Object[16];
                    objArr[0] = Integer.valueOf(i2);
                    objArr[1] = 2;
                    objArr[2] = Long.valueOf(m.this.startTime);
                    objArr[3] = Long.valueOf(Util.nowMilliSecond());
                    objArr[4] = Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext()));
                    objArr[5] = Integer.valueOf(m.this.gVY);
                    objArr[6] = Integer.valueOf(m.this.iKP);
                    objArr[7] = dVar == null ? "" : dVar.field_transInfo;
                    objArr[8] = "";
                    objArr[9] = "";
                    objArr[10] = "";
                    objArr[11] = "";
                    objArr[12] = "";
                    objArr[13] = "";
                    objArr[14] = "";
                    objArr[15] = dVar == null ? "" : dVar.gqk;
                    String t = a.t(objArr);
                    new y(t).bfK();
                    new w(t).bfK();
                    m.this.callback.onSceneEnd(3, i2, "", m.this);
                    AppMethodBeat.o(150671);
                    return 0;
                } else {
                    g c2 = q.bcR().c(Long.valueOf(m.this.hmj));
                    if (cVar == null) {
                        if (dVar != null) {
                            if (dVar.field_retCode != 0) {
                                k.to((int) m.this.iYP);
                                Log.e(m.this.TAG, "cdntra sceneResult.retCode :%d", Integer.valueOf(dVar.field_retCode));
                                m.this.callback.onSceneEnd(3, dVar.field_retCode, "", m.this);
                            } else {
                                Log.i(m.this.TAG, "cdntra getimg ok. need convert:%b", Boolean.valueOf(dVar.field_convert2baseline));
                                if (c2.iXp == 1) {
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(198, 26, (long) c2.iKP, false);
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(198, 27, 1, false);
                                    com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
                                    if (m.this.dCM != null) {
                                        str3 = m.this.dCM.field_talker;
                                    } else {
                                        str3 = "";
                                    }
                                    hVar.idkeyStat(198, ab.Eq(str3) ? 29 : 28, 1, false);
                                } else {
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(198, 21, (long) c2.iKP, false);
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(198, 22, 1, false);
                                    com.tencent.mm.plugin.report.service.h hVar2 = com.tencent.mm.plugin.report.service.h.INSTANCE;
                                    if (m.this.dCM != null) {
                                        str2 = m.this.dCM.field_talker;
                                    } else {
                                        str2 = "";
                                    }
                                    if (ab.Eq(str2)) {
                                        j2 = 24;
                                    } else {
                                        j2 = 23;
                                    }
                                    hVar2.idkeyStat(198, j2, 1, false);
                                }
                                if (dVar.field_convert2baseline) {
                                    Log.i(m.this.TAG, "cdntra need convert2baseline. file:%s", m.this.iYV);
                                    Log.i(m.this.TAG, "convert result:%b", Boolean.valueOf(MMNativeJpeg.Convert2Baseline(m.this.iYV, 60)));
                                }
                                if (m.this.iZb) {
                                    m.a(m.this, c2, c2.offset, c2.offset, 0);
                                } else {
                                    m.a(m.this, c2, m.this.iKP, c2.offset, m.this.iKP - c2.offset);
                                }
                            }
                            Object[] objArr2 = new Object[16];
                            objArr2[0] = Integer.valueOf(dVar.field_retCode);
                            objArr2[1] = 2;
                            objArr2[2] = Long.valueOf(m.this.startTime);
                            objArr2[3] = Long.valueOf(Util.nowMilliSecond());
                            objArr2[4] = Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext()));
                            objArr2[5] = Integer.valueOf(m.this.gVY);
                            objArr2[6] = Integer.valueOf(m.this.iKP);
                            objArr2[7] = dVar == null ? "" : dVar.field_transInfo;
                            objArr2[8] = "";
                            objArr2[9] = "";
                            objArr2[10] = "";
                            objArr2[11] = "";
                            objArr2[12] = "";
                            objArr2[13] = "";
                            objArr2[14] = "";
                            objArr2[15] = dVar == null ? "" : dVar.gqk;
                            new y(a.t(objArr2)).bfK();
                            if (dVar.field_retCode != 0) {
                                Object[] objArr3 = new Object[16];
                                objArr3[0] = Integer.valueOf(dVar.field_retCode);
                                objArr3[1] = 2;
                                objArr3[2] = Long.valueOf(m.this.startTime);
                                objArr3[3] = Long.valueOf(Util.nowMilliSecond());
                                objArr3[4] = Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext()));
                                objArr3[5] = Integer.valueOf(m.this.gVY);
                                objArr3[6] = Integer.valueOf(m.this.iKP);
                                objArr3[7] = dVar == null ? "" : dVar.field_transInfo;
                                objArr3[8] = "";
                                objArr3[9] = "";
                                objArr3[10] = "";
                                objArr3[11] = "";
                                objArr3[12] = "";
                                objArr3[13] = "";
                                objArr3[14] = "";
                                objArr3[15] = dVar == null ? "" : dVar.gqk;
                                new w(a.t(objArr3)).bfK();
                            }
                        }
                        AppMethodBeat.o(150671);
                        return 0;
                    } else if (cVar.field_finishedLength == ((long) m.this.iKP)) {
                        Log.d(m.this.TAG, "cdntra ignore progress 100%");
                        AppMethodBeat.o(150671);
                        return 0;
                    } else {
                        m.this.iZb = true;
                        if (!m.this.iYX) {
                            m.this.iYX = cVar.field_mtlnotify;
                        }
                        Log.i(m.this.TAG, "cdntra progresscallback id:%s finish:%d total:%d,  canshowProgressimg:%b", m.this.iYT, Long.valueOf(cVar.field_finishedLength), Long.valueOf(cVar.field_toltalLength), Boolean.valueOf(m.this.iYX));
                        m.a(m.this, c2, m.this.iKP, c2.offset, ((int) cVar.field_finishedLength) - c2.offset);
                        AppMethodBeat.o(150671);
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
        Assert.assertTrue(j2 >= 0 && j3 >= 0 && jVar != null);
        this.iYO = jVar;
        this.iXp = i2;
        this.iYP = j2;
        this.iYQ = j2;
        this.hmj = j2;
        this.msgId = j3;
        this.iYY = i3;
        g c2 = q.bcR().c(Long.valueOf(this.hmj));
        if (i2 == 1) {
            this.hmj = (long) c2.iXx;
            gVar = q.bcR().c(Long.valueOf(this.hmj));
        } else {
            gVar = c2;
        }
        this.TAG += "[" + this.hmj + "]";
        d.a aVar = new d.a();
        aVar.iLN = new bqv();
        aVar.iLO = new bqw();
        aVar.uri = "/cgi-bin/micromsg-bin/getmsgimg";
        aVar.funcId = 109;
        aVar.iLP = 10;
        aVar.respCmdId = 1000000010;
        this.rr = aVar.aXF();
        bqv bqv = (bqv) this.rr.iLK.iLR;
        this.dCM = ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().Hb(j3);
        bqv.BsG = gVar.offset;
        bqv.BsF = gVar.iKP;
        Log.d(this.TAG, "cdntra offset:%d total:%d stack:[%s]", Integer.valueOf(gVar.offset), Integer.valueOf(gVar.iKP), Util.getStack());
        bqv.Brn = this.dCM.field_msgSvrId;
        bqv.KHl = new dqi().bhy(this.dCM.field_talker);
        bqv.KHm = new dqi().bhy((String) com.tencent.mm.kernel.g.aAh().azQ().get(2, (Object) null));
        bqv.LYt = i2;
        if (gVar.offset == 0) {
            this.iYS = new h(getType(), false, (long) gVar.iKP);
        }
        this.iYR = 8192;
        if (jVar != null) {
            final int i4 = gVar.offset;
            final int i5 = gVar.iKP;
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.av.m.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(150670);
                    jVar.a(i4, i5, m.this);
                    AppMethodBeat.o(150670);
                }
            });
        }
        AppMethodBeat.o(150673);
    }

    @Override // com.tencent.mm.ak.q
    public final int securityLimitCount() {
        if (this.iXp == 0) {
            return 100;
        }
        return TAVExporter.VIDEO_EXPORT_HEIGHT;
    }

    @Override // com.tencent.mm.ak.q
    public final q.b securityVerificationChecked(s sVar) {
        return q.b.EOk;
    }

    @Override // com.tencent.mm.ak.q
    public final void cancel() {
        AppMethodBeat.i(150675);
        if (!Util.isNullOrNil(this.iYT) && f.baQ() != null) {
            Log.d(this.TAG, "cancel recv task");
            f.baQ().Oc(this.iYT);
        }
        super.cancel();
        AppMethodBeat.o(150675);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(150676);
        this.callback = iVar;
        bqv bqv = (bqv) this.rr.iLK.iLR;
        g c2 = q.bcR().c(Long.valueOf(this.hmj));
        if (c2.localId == 0) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(111, 195, 1, false);
            Log.e(this.TAG, "doScene id:%d  img:%s", Long.valueOf(this.hmj), c2);
            AppMethodBeat.o(150676);
            return -1;
        } else if (c2.status != 0) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(111, 194, 1, false);
            Log.e(this.TAG, "doSceneError, id:%d, status:%d", Long.valueOf(c2.localId), Integer.valueOf(c2.status));
            AppMethodBeat.o(150676);
            return -1;
        } else {
            String str = c2.iXm;
            if (str.startsWith("SERVERID://")) {
                this.iYU = com.tencent.mm.b.g.getMessageDigest(c2.iXm.getBytes());
                this.iYV = q.bcR().o(this.iYU, null, ".temp");
                c2.Oq(this.iYU + ".temp");
                q.bcR().a(Long.valueOf(this.hmj), c2);
            } else {
                this.iYU = c2.iXm;
                this.iYV = q.bcR().o(this.iYU, null, "");
            }
            Log.i(this.TAG, "doscene id:%d comp:%d off:%d total:%d name:%s tmp:%s full:%s", Long.valueOf(c2.localId), Integer.valueOf(this.iXp), Integer.valueOf(c2.offset), Integer.valueOf(c2.iKP), str, this.iYU, this.iYV);
            if (this.startTime == 0) {
                this.startTime = Util.nowMilliSecond();
                this.startOffset = c2.offset;
                this.gVY = this.iXp == 1 ? com.tencent.mm.i.a.MediaType_FULLSIZEIMAGE : com.tencent.mm.i.a.MediaType_IMAGE;
            }
            if (d(c2)) {
                Log.d(this.TAG, "cdntra this img use cdn : %s", this.iYT);
                AppMethodBeat.o(150676);
                return 0;
            }
            Log.d(this.TAG, "cdntra this img NOT USE CDN: %s", this.iYT);
            c2.Ot("");
            c2.cSx = 4096;
            q.bcR().a(Long.valueOf(this.hmj), c2);
            bqv.BsG = c2.offset;
            bqv.BsH = this.iYR;
            bqv.BsF = c2.iKP;
            if (this.iYS != null) {
                this.iYS.bgi();
            }
            int dispatch = dispatch(gVar, this.rr, this);
            AppMethodBeat.o(150676);
            return dispatch;
        }
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 109;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(150677);
        if (i3 == 3 && i4 == -1 && !Util.isNullOrNil(this.iYT)) {
            Log.w(this.TAG, "cdntra using cdn trans,  wait cdn service callback! clientid:%s", this.iYT);
            AppMethodBeat.o(150677);
        } else if (i3 == 0 && i4 == 0) {
            bqw bqw = (bqw) ((d) sVar).iLL.iLR;
            g c2 = q.bcR().c(Long.valueOf(this.hmj));
            char c3 = 0;
            if (bqw.BsH <= 0) {
                Log.e(this.TAG, "flood control, malformed data_len");
                c3 = 65535;
            } else if (bqw.BsI == null || bqw.BsH != bqw.BsI.getILen()) {
                Log.e(this.TAG, "flood control, malformed data is null or dataLen not match with data buf length");
                c3 = 65535;
            } else if (bqw.BsG < 0 || bqw.BsG + bqw.BsH > bqw.BsF) {
                Log.e(this.TAG, "flood control, malformed start pos");
                c3 = 65535;
            } else if (bqw.BsG != c2.offset) {
                Log.e(this.TAG, "flood control, malformed start_pos");
                c3 = 65535;
            } else if (bqw.BsF <= 0) {
                Log.e(this.TAG, "flood control, malformed total_len");
                c3 = 65535;
            }
            if (c3 != 0) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(111, 192, 1, false);
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(10420, -1, 2, Long.valueOf(this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(this.gVY), Integer.valueOf(this.iKP - this.startOffset));
                this.callback.onSceneEnd(4, -1, "", this);
                AppMethodBeat.o(150677);
                return;
            }
            if (a(c2, bqw.BsF, bqw.BsG, bqw.BsH, bqw.BsI.getBuffer().zy) && doScene(dispatcher(), this.callback) < 0) {
                this.callback.onSceneEnd(3, -1, "", this);
            }
            AppMethodBeat.o(150677);
        } else {
            if (i3 == 4) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(111, 193, 1, false);
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(10420, Integer.valueOf(i4), 2, Long.valueOf(this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(this.gVY), Integer.valueOf(this.iKP - this.startOffset));
            }
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(150677);
        }
    }

    private boolean a(final g gVar, int i2, int i3, int i4, byte[] bArr) {
        boolean z;
        AppMethodBeat.i(150678);
        gVar.tf(i2);
        gVar.setOffset(i3 + i4);
        this.iYR = i4;
        if (bArr != null) {
            com.tencent.mm.vfs.s.e(this.iYV, bArr, bArr.length);
        }
        Log.d(this.TAG, "onGYNetEnd : offset = " + gVar.offset + " totalLen = " + gVar.iKP + " stack:[%s]", Util.getStack());
        String str = null;
        if (gVar.bcu()) {
            String identifyImgType = ImgUtil.identifyImgType(this.iYV);
            boolean isImgFile = ImgUtil.isImgFile(this.iYV);
            o oVar = new o(this.iYV);
            if (ImgUtil.isWXGF(this.iYV)) {
                Log.i(this.TAG, "hevc download is hevc %s", Boolean.valueOf(isImgFile));
                String str2 = com.tencent.mm.vfs.s.k(this.iYV, false) + "_temp";
                int nativeWxam2Pic = ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.emoji.b.c.class)).nativeWxam2Pic(this.iYV, str2);
                int a2 = ((b) com.tencent.mm.kernel.g.af(b.class)).a(b.a.clicfg_c2c_download_delete_hevc, 1);
                Log.i(this.TAG, "convert jpg: %s path %s, config %s", Integer.valueOf(nativeWxam2Pic), str2, Integer.valueOf(a2));
                if (nativeWxam2Pic != 0) {
                    z = false;
                } else {
                    identifyImgType = ImgUtil.identifyImgType(str2);
                    if (a2 == 1) {
                        com.tencent.mm.vfs.s.nx(str2, this.iYV);
                        z = isImgFile;
                    } else {
                        String alX = ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.emoji.b.c.class)).alX(q.bcR().o(this.iYU, null, identifyImgType));
                        com.tencent.mm.vfs.s.nx(this.iYV, alX);
                        com.tencent.mm.vfs.s.nx(str2, this.iYV);
                        gVar.Ou(alX);
                        z = isImgFile;
                    }
                }
                if (!z) {
                    this.iKG = false;
                    com.tencent.mm.vfs.s.deleteFile(this.iYV);
                    d(gVar);
                    AppMethodBeat.o(150678);
                    return false;
                }
            } else {
                z = isImgFile;
            }
            if (z) {
                str = q.bcR().o(this.iYU, null, identifyImgType);
                Log.i(this.TAG, "sceneEndproc ext:%s tmp:%s tmpfull:%s full:%s ", identifyImgType, this.iYU, this.iYV, str);
                oVar.am(new o(str));
                gVar.Oq(this.iYU + identifyImgType);
                gVar.Op(h.Ow(str));
                gVar.tk(this.iXp);
            } else {
                if (this.iXp == 1) {
                    g c2 = q.bcR().c(Long.valueOf(this.iYQ));
                    c2.tg(0);
                    q.bcR().a(Long.valueOf(this.iYQ), c2);
                }
                oVar.delete();
            }
        }
        if (q.bcR().a(Long.valueOf(this.hmj), gVar) < 0) {
            Log.e(this.TAG, "onGYNetEnd : update img fail");
            this.callback.onSceneEnd(3, -1, "", this);
            AppMethodBeat.o(150678);
            return false;
        }
        if (this.iYO != null) {
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.av.m.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(150672);
                    m.this.iYO.a(gVar.offset, gVar.iKP, m.this);
                    AppMethodBeat.o(150672);
                }
            });
        }
        Log.d(this.TAG, "cdntra check iscompleted :%b clientid:%s", Boolean.valueOf(gVar.bcu()), this.iYT);
        if (gVar.bcu()) {
            if (Util.isNullOrNil(this.iYT)) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(10420, 0, 2, Long.valueOf(this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(this.gVY), Integer.valueOf(i2 - this.startOffset));
            }
            boolean z2 = false;
            if (this.iYW > 0) {
                z2 = q.bcR().a(str, gVar.iXo, this.iYW, 1, this.dCM.fQS, this.dCM.fQT);
            }
            if (z2) {
                gVar.bcw();
                ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().a(this.dCM.field_msgId, this.dCM);
            }
            q.bcR().a(Long.valueOf(this.hmj), gVar);
            Log.d(this.TAG, "cdntra ext:%s %s %s  MediaCheckDuplicationStorage md5:%s", this.iYV, str, gVar.iXm, this.iYZ);
            if (this.iYS != null) {
                this.iYS.AH((long) gVar.iKP);
            }
            if (!Util.isNullOrNil(this.iYZ) && this.iZa > 0) {
                com.tencent.mm.plugin.image.c.dZD();
                com.tencent.mm.plugin.image.c.aSV().P(this.iYZ, this.iZa, str);
            }
            this.callback.onSceneEnd(0, 0, "", this);
            AppMethodBeat.o(150678);
            return false;
        }
        AppMethodBeat.o(150678);
        return true;
    }

    private boolean d(g gVar) {
        String str;
        String str2;
        String str3;
        AppMethodBeat.i(150674);
        if (Util.isNullOrNil(gVar.iXy)) {
            AppMethodBeat.o(150674);
            return false;
        }
        Map<String, String> parseXml = XmlParser.parseXml(gVar.iXy, "msg", null);
        if (parseXml == null) {
            Log.e(this.TAG, "parse cdnInfo failed. [%s]", gVar.iXy);
            AppMethodBeat.o(150674);
            return false;
        }
        this.iKP = 0;
        if (this.iXp != 1) {
            this.iKP = Util.getInt(parseXml.get(".msg.img.$length"), 0);
            str = parseXml.get(".msg.img.$cdnmidimgurl");
        } else {
            this.iKP = Util.getInt(parseXml.get(".msg.img.$hdlength"), 0);
            str = parseXml.get(".msg.img.$cdnbigimgurl");
        }
        if (this.iXp != 1) {
            str2 = parseXml.get(".msg.img.$tpurl");
            if (!Util.isNullOrNil(str2)) {
                this.iKP = Util.getInt(parseXml.get(".msg.img.$tplength"), 0);
                str3 = str2;
            }
            str3 = str2;
        } else {
            str2 = parseXml.get(".msg.img.$tphdurl");
            if (!Util.isNullOrNil(str2)) {
                this.iKP = Util.getInt(parseXml.get(".msg.img.$tphdlength"), 0);
            }
            str3 = str2;
        }
        Log.d(this.TAG, "cdntra read xml  comptype:%d totallen:%d url:[%s] [%s]", Integer.valueOf(this.iXp), Integer.valueOf(this.iKP), str, str3);
        if (!Util.isNullOrNil(str) || !Util.isNullOrNil(str3)) {
            String str4 = parseXml.get(".msg.img.$aeskey");
            if (Util.isNullOrNil(str4)) {
                Log.e(this.TAG, "cdntra get aes key failed.");
                AppMethodBeat.o(150674);
                return false;
            }
            this.iYT = com.tencent.mm.an.c.a("downimg", (long) gVar.iXu, this.dCM.field_talker, new StringBuilder().append(this.dCM.field_msgId).toString());
            if (Util.isNullOrNil(this.iYT)) {
                Log.w(this.TAG, "cdntra genClientId failed not use cdn imgLocalId:%d", Long.valueOf(this.hmj));
                AppMethodBeat.o(150674);
                return false;
            }
            String str5 = parseXml.get(".msg.img.$md5");
            if (Util.isNullOrNil(str3) && !Util.isNullOrNil(str5) && (Util.isNullOrNil(parseXml.get(".msg.img.$cdnbigimgurl")) || this.iXp == 1)) {
                com.tencent.mm.plugin.image.c.dZD();
                String gS = com.tencent.mm.plugin.image.c.aSV().gS(str5, this.iKP);
                int boW = (int) com.tencent.mm.vfs.s.boW(gS);
                int i2 = this.iKP - boW;
                String str6 = this.TAG;
                Object[] objArr = new Object[8];
                objArr[0] = Integer.valueOf(this.iKP);
                objArr[1] = str5;
                objArr[2] = parseXml.get(".msg.img.$cdnbigimgurl");
                objArr[3] = Boolean.valueOf(this.iXp == 1);
                objArr[4] = Integer.valueOf(boW);
                objArr[5] = gS;
                objArr[6] = Integer.valueOf(i2);
                objArr[7] = this.iYV;
                Log.i(str6, "MediaCheckDuplicationStorage: totallen:%s md5:%s big:%s NOcompress:%s  dup(len:%d path:%s) diffLen:%d to:%s", objArr);
                if (Util.isNullOrNil(gS)) {
                    this.iYZ = str5;
                    this.iZa = this.iKP;
                } else if (i2 >= 0 && i2 <= 16) {
                    boolean z = false;
                    if (!Util.isEqual(gS, this.iYV)) {
                        z = com.tencent.mm.vfs.s.nw(gS, this.iYV) >= 0;
                    }
                    Log.i(this.TAG, "MediaCheckDuplicationStorage copy dup file now :%s -> %s [%b]", gS, this.iYV, Boolean.valueOf(z));
                    a(gVar, this.iKP, this.iKP, 0, (byte[]) null);
                    if (this.dCM != null) {
                        ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().a(new i.c(this.dCM.field_talker, "update", this.dCM));
                    }
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(13267, str, Long.valueOf(this.dCM.field_msgSvrId), str5, Long.valueOf(this.dCM.field_createTime / 1000), this.dCM.field_talker, 3, Integer.valueOf(boW));
                    AppMethodBeat.o(150674);
                    return true;
                }
            }
            boolean z2 = this.iKG && ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.emoji.b.c.class)).cEP();
            Log.i(this.TAG, "checkUseCdn: %s, %s", Boolean.valueOf(this.iKG), Boolean.valueOf(z2));
            g gVar2 = new g();
            if (z2) {
                gVar2.taskName = "task_NetSceneGetMsgImg_1";
                gVar2.field_mediaId = this.iYT;
            } else {
                gVar2.taskName = "task_NetSceneGetMsgImg_2";
                gVar2.field_mediaId = this.iYT + "_hevc";
            }
            gVar2.field_fullpath = this.iYV;
            gVar2.field_fileType = this.gVY;
            gVar2.field_totalLen = this.iKP;
            gVar2.field_aesKey = str4;
            gVar2.field_fileId = str;
            gVar2.field_priority = com.tencent.mm.i.a.gpM;
            gVar2.gqy = this.iZc;
            gVar2.field_chattype = ab.Eq(this.dCM.field_talker) ? 1 : 0;
            gVar2.expectImageFormat = z2 ? 2 : 1;
            if (!Util.isNullOrNil(str3)) {
                gVar2.field_fileType = 19;
                gVar2.field_authKey = parseXml.get(".msg.img.$tpauthkey");
                gVar2.gqB = str3;
                gVar2.field_fileId = "";
            }
            Log.i(this.TAG, "cdnautostart %s %b", "image_" + this.dCM.field_msgId, Boolean.valueOf(f.baQ().iRE.contains("image_" + this.dCM.field_msgId)));
            if (f.baQ().iRE.contains("image_" + this.dCM.field_msgId)) {
                f.baQ().iRE.remove("image_" + this.dCM.field_msgId);
                gVar2.field_autostart = true;
            } else {
                gVar2.field_autostart = false;
            }
            if (!f.baQ().b(gVar2, this.iYY)) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(111, 196, 1, false);
                Log.e(this.TAG, "addRecvTask failed :%s", this.iYT);
                this.iYT = "";
                AppMethodBeat.o(150674);
                return false;
            }
            Log.i(this.TAG, "add recv task");
            AppMethodBeat.o(150674);
            return true;
        }
        Log.e(this.TAG, "cdntra get cdnUrlfailed.");
        AppMethodBeat.o(150674);
        return false;
    }
}
