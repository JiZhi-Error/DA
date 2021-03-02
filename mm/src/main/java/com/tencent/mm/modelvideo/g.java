package com.tencent.mm.modelvideo;

import android.database.Cursor;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.g.b.a.w;
import com.tencent.mm.g.b.a.y;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.br;
import com.tencent.mm.modelcontrol.e;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.network.ag;
import com.tencent.mm.network.m;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.f.b;
import com.tencent.mm.pluginsdk.f.d;
import com.tencent.mm.pluginsdk.f.g;
import com.tencent.mm.pluginsdk.model.z;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.eeq;
import com.tencent.mm.protocal.protobuf.eoc;
import com.tencent.mm.protocal.protobuf.eod;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.s;
import com.tencent.smtt.sdk.TbsMediaPlayer;
import java.io.ByteArrayOutputStream;
import java.util.Map;
import java.util.Vector;
import junit.framework.Assert;

public final class g extends q implements m {
    private static int jqN = 32000;
    private final int MAX_TIMES;
    private i callback;
    boolean dwS = false;
    private String ebj = "";
    public String fileName;
    int hjI = 0;
    f.a hvh = null;
    MTimerHandler iKj = new MTimerHandler(new MTimerHandler.CallBack() {
        /* class com.tencent.mm.modelvideo.g.AnonymousClass3 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(240860);
            if (g.this.doScene(g.p(g.this), g.this.callback) == -1) {
                g.this.retCode = 0 - (f.getLine() + 10000);
                g.this.callback.onSceneEnd(3, -1, "doScene failed", g.this);
            }
            AppMethodBeat.o(240860);
            return false;
        }
    }, true);
    private String iYT = "";
    private g.a iZc = new g.a() {
        /* class com.tencent.mm.modelvideo.g.AnonymousClass2 */

        @Override // com.tencent.mm.i.g.a
        public final int a(String str, int i2, c cVar, final d dVar, boolean z) {
            int i3;
            int i4;
            int f2;
            int i5;
            AppMethodBeat.i(240859);
            Log.d("MicroMsg.NetSceneUploadVideo", "%s cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", g.e(g.this), g.this.iYT, Integer.valueOf(i2), cVar, dVar);
            if (i2 == -21005) {
                Log.d("MicroMsg.NetSceneUploadVideo", "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", g.this.iYT);
                AppMethodBeat.o(240859);
                return 0;
            } else if (i2 != 0) {
                u.QE(g.this.fileName);
                new y(a.t(Integer.valueOf(i2), 1, Long.valueOf(g.this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(g.this.jqs), 0, "")).bfK();
                g.this.callback.onSceneEnd(3, i2, "", g.this);
                AppMethodBeat.o(240859);
                return 0;
            } else {
                g.this.jqq = u.QN(g.this.fileName);
                if (g.this.jqq == null || g.this.jqq.status == 105) {
                    if (g.this.jqq == null) {
                        i3 = -1;
                    } else {
                        i3 = g.this.jqq.status;
                    }
                    Log.i("MicroMsg.NetSceneUploadVideo", "%s info is null or has paused, status:%d", g.e(g.this), Integer.valueOf(i3));
                    com.tencent.mm.an.f.baQ().Ob(g.this.iYT);
                    g.this.callback.onSceneEnd(3, i2, "info is null or has paused, status".concat(String.valueOf(i3)), g.this);
                    AppMethodBeat.o(240859);
                    return 0;
                } else if (cVar == null) {
                    if (dVar != null) {
                        if (dVar.field_retCode != 0) {
                            Log.e("MicroMsg.NetSceneUploadVideo", "%s cdntra sceneResult.retCode :%d arg[%s] info[%s]", g.e(g.this), Integer.valueOf(dVar.field_retCode), dVar.field_arg, dVar.field_transInfo);
                            u.QE(g.this.fileName);
                            String t = a.t(Integer.valueOf(dVar.field_retCode), 1, Long.valueOf(g.this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(g.this.jqs), Long.valueOf(dVar.field_fileLength), dVar.field_transInfo, "", "", "", "", "", "", "", dVar.gqk);
                            new y(t).bfK();
                            new w(t).bfK();
                            g.this.callback.onSceneEnd(3, dVar.field_retCode, "", g.this);
                        } else {
                            Log.i("MicroMsg.NetSceneUploadVideo", "%s summersafecdn uploadvideo by cdn, videohash isHitCacheUpload: %d, enableHitcheck:%b", g.e(g.this), Integer.valueOf(dVar.field_UploadHitCacheType), Boolean.valueOf(g.this.iZk));
                            h hVar = h.INSTANCE;
                            Object[] objArr = new Object[2];
                            if (g.this.jqR) {
                                i4 = 810;
                            } else {
                                i4 = g.this.jqQ ? com.tencent.mm.plugin.appbrand.jsapi.pay.i.CTRL_INDEX : 830;
                            }
                            objArr[0] = Integer.valueOf(i4 + dVar.field_UploadHitCacheType);
                            objArr[1] = Integer.valueOf(g.this.jqq.iKP);
                            hVar.a(12696, objArr);
                            boolean z2 = dVar.field_isVideoReduced;
                            Log.i("MicroMsg.NetSceneUploadVideo", "%s it video was reduced by cdn %b %s", g.e(g.this), Boolean.valueOf(z2), g.this.fileName);
                            if (!z2) {
                                h.INSTANCE.idkeyStat(106, 205, 1, false);
                                if (g.this.jqS > 0 && dVar.field_thumbimgLength > 0) {
                                    Log.i("MicroMsg.NetSceneUploadVideo", "%s send video thumb too big thumb length [%d, %d] ", g.e(g.this), Integer.valueOf(g.this.jqS), Integer.valueOf(dVar.field_thumbimgLength));
                                    if (g.this.jqS * 2 > dVar.field_thumbimgLength) {
                                        h.INSTANCE.idkeyStat(106, 206, 1, false);
                                    } else {
                                        h.INSTANCE.idkeyStat(106, 207, 1, false);
                                    }
                                }
                                o.bhj();
                                int boW = (int) s.boW(t.Qw(g.this.fileName));
                                Log.i("MicroMsg.NetSceneUploadVideo", "%s send video too big thumb length [%d, %d] ", g.e(g.this), Integer.valueOf(g.this.jqq.iKP), Integer.valueOf(boW));
                                if (g.this.jqq.iKP != boW) {
                                    h.INSTANCE.idkeyStat(106, 208, 1, false);
                                } else {
                                    h.INSTANCE.idkeyStat(106, 209, 1, false);
                                }
                            } else {
                                h.INSTANCE.idkeyStat(106, 200, 1, false);
                            }
                            g.this.jqq = u.QN(g.this.fileName);
                            if (Util.isNullOrNil(g.this.jqq.bhv())) {
                                String str2 = ((("<msg><videomsg aeskey=\"" + dVar.field_aesKey + "\" cdnthumbaeskey=\"" + dVar.field_aesKey + "\" cdnvideourl=\"" + dVar.field_fileId + "\" ") + "cdnthumburl=\"" + dVar.field_fileId + "\" ") + "length=\"" + dVar.field_fileLength + "\" ") + "cdnthumblength=\"" + dVar.field_thumbimgLength + "\"/></msg>";
                                Log.i("MicroMsg.NetSceneUploadVideo", "%s cdn callback new build cdnInfo:%s", g.e(g.this), str2);
                                g.this.jqq.jst = str2;
                                u.f(g.this.jqq);
                            }
                            Map<String, String> parseXml = XmlParser.parseXml(g.this.jqq.bhv(), "msg", null);
                            if (parseXml != null) {
                                t bhj = o.bhj();
                                o.bhj();
                                boolean q = bhj.q(t.Qw(g.this.fileName), parseXml.get(".msg.videomsg.$cdnvideourl"), parseXml.get(".msg.videomsg.$aeskey"));
                                h hVar2 = h.INSTANCE;
                                Object[] objArr2 = new Object[2];
                                if (q) {
                                    i5 = 1;
                                } else {
                                    i5 = 2;
                                }
                                objArr2[0] = Integer.valueOf(i5 + TbsMediaPlayer.TbsMediaPlayerListener.MEDIA_INFO_TIMED_TEXT_ERROR);
                                objArr2[1] = Integer.valueOf(g.this.jqq.iKP);
                                hVar2.a(12696, objArr2);
                            }
                            com.tencent.mm.av.s bcY = com.tencent.mm.av.s.bcY();
                            bcY.fileName = g.this.fileName;
                            if (z2) {
                                f2 = 0;
                            } else {
                                f2 = g.f(g.this);
                            }
                            bcY.jaB = f2;
                            bcY.jaC = dVar;
                            bcY.jaD = new com.tencent.mm.av.f() {
                                /* class com.tencent.mm.modelvideo.g.AnonymousClass2.AnonymousClass1 */

                                @Override // com.tencent.mm.av.f
                                public final void dq(int i2, int i3) {
                                    AppMethodBeat.i(240858);
                                    if (i2 == 4 && i3 == 102) {
                                        com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable() {
                                            /* class com.tencent.mm.modelvideo.g.AnonymousClass2.AnonymousClass1.AnonymousClass1 */

                                            public final void run() {
                                                AppMethodBeat.i(240857);
                                                g.this.iZk = false;
                                                g.this.jqq.status = 104;
                                                g.this.jqq.createTime = Util.nowSecond();
                                                g.this.jqq.jsm = Util.nowSecond();
                                                g.this.jqq.jqP = 0;
                                                g.this.jqq.cSx = 1800;
                                                Log.i("MicroMsg.NetSceneUploadVideo", "%s summersafecdn MM_ERR_GET_AESKEY_FAILED doScene again enableHitcheck[%b], ret[%b] new createtime:%d", g.e(g.this), Boolean.valueOf(g.this.iZk), Boolean.valueOf(u.f(g.this.jqq)), Long.valueOf(g.this.jqq.createTime));
                                                g.this.doScene(g.o(g.this), g.this.callback);
                                                AppMethodBeat.o(240857);
                                            }
                                        });
                                        AppMethodBeat.o(240858);
                                        return;
                                    }
                                    new y(a.t(Integer.valueOf(i3), 1, Long.valueOf(g.this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(g.this.jqs), Long.valueOf(dVar.field_fileLength), dVar.field_transInfo, "", "", "", "", "", "", "", dVar.gqk)).bfK();
                                    a.a(g.this.jqq, 0);
                                    g.a(g.this, dVar);
                                    g.this.callback.onSceneEnd(i2, i3, "", g.this);
                                    AppMethodBeat.o(240858);
                                }
                            };
                            bcY.jdR = 4;
                            bcY.bdQ().execute();
                        }
                    }
                    AppMethodBeat.o(240859);
                    return 0;
                } else if (((long) g.this.jqq.jqP) > cVar.field_finishedLength) {
                    Log.w("MicroMsg.NetSceneUploadVideo", "%s cdntra cdnEndProc error oldpos:%d newpos:%d", g.e(g.this), Integer.valueOf(g.this.jqq.jqP), Long.valueOf(cVar.field_finishedLength));
                    AppMethodBeat.o(240859);
                    return 0;
                } else {
                    g.this.jqq.jsm = Util.nowSecond();
                    g.this.jqq.jqP = (int) cVar.field_finishedLength;
                    g.this.jqq.cSx = 1032;
                    u.f(g.this.jqq);
                    AppMethodBeat.o(240859);
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
    private boolean iZk = true;
    private d.a iZw = new d.a() {
        /* class com.tencent.mm.modelvideo.g.AnonymousClass1 */

        @Override // com.tencent.mm.pluginsdk.f.d.a
        public final void a(g.a aVar) {
            AppMethodBeat.i(240854);
            Log.i("MicroMsg.NetSceneUploadVideo", "upload success, field_aesKey:%s, fileId:%s, fileLen:%s", aVar.aesKey, aVar.fileId, Long.valueOf(aVar.jPY));
            long nowMilliSecond = Util.nowMilliSecond();
            long j2 = nowMilliSecond - g.this.startTime;
            long j3 = aVar.jPY;
            h.INSTANCE.a(10420, 0, 1, Long.valueOf(g.this.startTime), Long.valueOf(nowMilliSecond), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(g.this.jqs), Long.valueOf(j3), Long.valueOf(j3 / j2), 1);
            com.tencent.mm.i.d dVar = new com.tencent.mm.i.d();
            dVar.field_aesKey = aVar.aesKey;
            dVar.field_fileId = aVar.fileId;
            dVar.field_filemd5 = aVar.pkL;
            dVar.field_fileLength = aVar.jPY;
            o.bhj();
            String Qw = t.Qw(g.this.fileName);
            o.bhj();
            final String Qx = t.Qx(g.this.fileName);
            dVar.field_thumbimgLength = (int) s.boW(g.a(g.this, Qx));
            com.tencent.mm.an.f.baR();
            dVar.field_filecrc = com.tencent.mm.an.a.NW(Qw);
            dVar.field_toUser = g.this.jqq.getUser();
            com.tencent.f.h.RTc.aX(new Runnable() {
                /* class com.tencent.mm.modelvideo.g.AnonymousClass1.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(240851);
                    if (!g.a(g.this, Qx).equals(Qx)) {
                        s.deleteFile(g.a(g.this, Qx));
                        Log.i("MicroMsg.NetSceneUploadVideo", "delete thumbPath %s", Qx);
                    }
                    AppMethodBeat.o(240851);
                }
            });
            final s QN = u.QN(g.this.fileName);
            if (Util.isNullOrNil(QN.bhv())) {
                String str = ((("<msg><videomsg aeskey=\"" + dVar.field_aesKey + "\" cdnthumbaeskey=\"" + dVar.field_aesKey + "\" cdnvideourl=\"" + dVar.field_fileId + "\" ") + "cdnthumburl=\"" + dVar.field_fileId + "\" ") + "length=\"" + dVar.field_fileLength + "\" ") + "cdnthumblength=\"" + dVar.field_thumbimgLength + "\"/></msg>";
                Log.i("MicroMsg.NetSceneUploadVideo", "%s cdn callback new build cdnInfo:%s", g.e(g.this), str);
                QN.jst = str;
                u.f(QN);
            }
            Map<String, String> parseXml = XmlParser.parseXml(QN.bhv(), "msg", null);
            if (parseXml != null) {
                t bhj = o.bhj();
                o.bhj();
                bhj.q(t.Qw(g.this.fileName), parseXml.get(".msg.videomsg.$cdnvideourl"), parseXml.get(".msg.videomsg.$aeskey"));
            }
            com.tencent.mm.kernel.g.azz().a(new h(g.this.fileName, g.f(g.this), dVar, new com.tencent.mm.av.f() {
                /* class com.tencent.mm.modelvideo.g.AnonymousClass1.AnonymousClass2 */

                @Override // com.tencent.mm.av.f
                public final void dq(int i2, int i3) {
                    AppMethodBeat.i(240853);
                    if (i2 == 4 && i3 == 102) {
                        com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable() {
                            /* class com.tencent.mm.modelvideo.g.AnonymousClass1.AnonymousClass2.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(240852);
                                g.this.iZk = false;
                                QN.status = 104;
                                QN.createTime = Util.nowSecond();
                                QN.jsm = Util.nowSecond();
                                QN.jqP = 0;
                                QN.cSx = 1800;
                                Log.i("MicroMsg.NetSceneUploadVideo", "%s summersafecdn MM_ERR_GET_AESKEY_FAILED doScene again enableHitcheck[%b], ret[%b] new createtime:%d", g.e(g.this), Boolean.valueOf(g.this.iZk), Boolean.valueOf(u.f(QN)), Long.valueOf(QN.createTime));
                                g.this.doScene(g.i(g.this), g.this.callback);
                                AppMethodBeat.o(240852);
                            }
                        });
                        AppMethodBeat.o(240853);
                        return;
                    }
                    g.this.callback.onSceneEnd(i2, i3, "", g.this);
                    AppMethodBeat.o(240853);
                }
            }), 0);
            AppMethodBeat.o(240854);
        }

        @Override // com.tencent.mm.pluginsdk.f.d.a
        public final void M(int i2, String str) {
            AppMethodBeat.i(240855);
            Log.e("MicroMsg.NetSceneUploadVideo", "onUploadFailure, errCode:%s, uploadID:%s", Integer.valueOf(i2), str);
            h.INSTANCE.a(10420, Integer.valueOf(i2), 1, Long.valueOf(g.this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(g.this.jqs), 0, 0, 0);
            Log.e("MicroMsg.NetSceneUploadVideo", "onUploadFailure, uploadId:%s", str);
            u.QE(g.this.fileName);
            g.this.callback.onSceneEnd(3, i2, "", g.this);
            AppMethodBeat.o(240855);
        }

        @Override // com.tencent.mm.pluginsdk.f.d.a
        public final void a(float f2, long j2) {
            AppMethodBeat.i(240856);
            s QN = u.QN(g.this.fileName);
            if (QN == null) {
                Log.e("MicroMsg.NetSceneUploadVideo", "%s info is null", g.e(g.this));
                AppMethodBeat.o(240856);
            } else if (((long) QN.jqP) > j2) {
                Log.w("MicroMsg.NetSceneUploadVideo", "%s cdntra cdnEndProc error oldpos:%d newpos:%d", g.e(g.this), Integer.valueOf(QN.jqP), Long.valueOf(j2));
                AppMethodBeat.o(240856);
            } else {
                QN.jsm = Util.nowSecond();
                QN.jqP = (int) j2;
                QN.cSx = 1032;
                u.f(QN);
                AppMethodBeat.o(240856);
            }
        }
    };
    private final long jqO = 1800000;
    private int jqP = -1;
    private boolean jqQ = false;
    private boolean jqR = false;
    private int jqS = 0;
    private int jqT = 0;
    public s jqq;
    private int jqs = com.tencent.mm.i.a.MediaType_VIDEO;
    private boolean jqt = false;
    int retCode = 0;
    private com.tencent.mm.ak.d rr;
    private long startTime = 0;

    static /* synthetic */ String a(g gVar, String str) {
        AppMethodBeat.i(240861);
        String Qf = gVar.Qf(str);
        AppMethodBeat.o(240861);
        return Qf;
    }

    static /* synthetic */ String e(g gVar) {
        AppMethodBeat.i(240862);
        String bgZ = gVar.bgZ();
        AppMethodBeat.o(240862);
        return bgZ;
    }

    static /* synthetic */ com.tencent.mm.network.g i(g gVar) {
        AppMethodBeat.i(240864);
        com.tencent.mm.network.g dispatcher = gVar.dispatcher();
        AppMethodBeat.o(240864);
        return dispatcher;
    }

    static /* synthetic */ com.tencent.mm.network.g o(g gVar) {
        AppMethodBeat.i(126870);
        com.tencent.mm.network.g dispatcher = gVar.dispatcher();
        AppMethodBeat.o(126870);
        return dispatcher;
    }

    static /* synthetic */ com.tencent.mm.network.g p(g gVar) {
        AppMethodBeat.i(240866);
        com.tencent.mm.network.g dispatcher = gVar.dispatcher();
        AppMethodBeat.o(240866);
        return dispatcher;
    }

    private boolean bgY() {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        String[] strArr;
        String str;
        int i2;
        int i3;
        int i4;
        int i5;
        AppMethodBeat.i(126857);
        String user = this.jqq.getUser();
        if (ab.JF(user)) {
            Log.w("MicroMsg.NetSceneUploadVideo", "%s cdntra not use cdn user:%s", bgZ(), user);
            AppMethodBeat.o(126857);
            return false;
        } else if (!b.gmg()) {
            Log.i("MicroMsg.NetSceneUploadVideo", "isAllow2UseCdnWithXLab = false");
            AppMethodBeat.o(126857);
            return false;
        } else {
            com.tencent.mm.an.f.baQ();
            if (com.tencent.mm.an.b.sS(2) || this.jqq.jss == 1) {
                this.iYT = com.tencent.mm.an.c.a("upvideo", this.jqq.createTime, user, this.jqq.getFileName());
                if (Util.isNullOrNil(this.iYT)) {
                    Log.w("MicroMsg.NetSceneUploadVideo", "%s cdntra genClientId failed not use cdn file:%s", bgZ(), this.jqq.getFileName());
                    AppMethodBeat.o(126857);
                    return false;
                }
                o.bhj();
                String Qx = t.Qx(this.fileName);
                o.bhj();
                String Qw = t.Qw(this.fileName);
                com.tencent.mm.i.g gVar = new com.tencent.mm.i.g();
                gVar.taskName = "task_NetSceneUploadVideo_1";
                gVar.gqy = this.iZc;
                gVar.field_mediaId = this.iYT;
                gVar.field_fullpath = Qw;
                gVar.field_thumbpath = Qf(Qx);
                gVar.field_fileType = com.tencent.mm.i.a.MediaType_VIDEO;
                if (as.bjw(this.jqq.getUser())) {
                    gVar.field_sendmsg_viacdn = false;
                } else if (z.bdv(Qw)) {
                    h.INSTANCE.idkeyStat(106, 30, 1, false);
                    gVar.field_use_multithread = true;
                }
                gVar.field_enable_hitcheck = !as.bjw(this.jqq.getUser()) && this.iZk;
                gVar.field_largesvideo = e.baZ().Oh(Qw) ? 1 : 0;
                if (this.jqq != null && 3 == this.jqq.jsu) {
                    gVar.field_smallVideoFlag = 1;
                }
                Object[] objArr = new Object[3];
                objArr[0] = bgZ();
                objArr[1] = Boolean.valueOf(this.jqq.jsx == null);
                objArr[2] = this.fileName;
                Log.i("MicroMsg.NetSceneUploadVideo", "%s upload video MMSightExtInfo is null? %b %s", objArr);
                if (this.jqq.jsx != null && this.jqq.jsx.Mrn) {
                    Log.i("MicroMsg.NetSceneUploadVideo", "%s local capture video, mark use large video", bgZ());
                    e.baZ();
                    gVar.field_largesvideo = e.b(e.baZ().bba());
                }
                n bhh = n.bhh();
                o.bhj();
                bhh.a("", t.Qw(this.fileName), this.jqq.getUser(), "", "", 2, 2);
                Object[] objArr2 = new Object[3];
                objArr2[0] = bgZ();
                objArr2[1] = this.jqq.getFileName();
                objArr2[2] = this.jqq.jsw == null ? BuildConfig.COMMAND : this.jqq.jsw.izf;
                Log.i("MicroMsg.NetSceneUploadVideo", "%s checkAD file:%s adinfo:%s", objArr2);
                if (this.jqq.jsw != null && !Util.isNullOrNil(this.jqq.jsw.izf)) {
                    gVar.field_advideoflag = 1;
                }
                gVar.field_talker = user;
                gVar.field_chattype = ab.Eq(user) ? 1 : 0;
                gVar.field_priority = com.tencent.mm.i.a.gpM;
                gVar.field_needStorage = false;
                gVar.field_isStreamMedia = false;
                gVar.field_trysafecdn = true;
                this.jqT = (int) s.boW(gVar.field_fullpath);
                this.jqS = (int) s.boW(gVar.field_thumbpath);
                if (this.jqS >= com.tencent.mm.i.a.gqi) {
                    Log.w("MicroMsg.NetSceneUploadVideo", "%s cdntra thumb[%s][%d] Too Big Not Use CDN TRANS", bgZ(), gVar.field_thumbpath, Integer.valueOf(this.jqS));
                    AppMethodBeat.o(126857);
                    return false;
                }
                Map<String, String> parseXml = XmlParser.parseXml(this.jqq.bhv(), "msg", null);
                if (parseXml != null) {
                    gVar.field_fileId = parseXml.get(".msg.videomsg.$cdnvideourl");
                    gVar.field_aesKey = parseXml.get(".msg.videomsg.$aeskey");
                    this.jqR = true;
                } else {
                    Log.i("MicroMsg.NetSceneUploadVideo", "%s cdntra parse video recv xml failed", bgZ());
                    try {
                        String nullAsNil = Util.nullAsNil(((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("UseVideoHash"));
                        String[] split = nullAsNil.split(",");
                        com.tencent.mm.kernel.g.aAi();
                        com.tencent.mm.kernel.g.aAf();
                        int ch = com.tencent.mm.b.i.ch(com.tencent.mm.kernel.a.getUin(), 100);
                        boolean z5 = (split == null || split.length <= 0) ? false : Util.getInt(split[0], 0) >= ch;
                        boolean z6 = (split == null || split.length < 2) ? false : Util.getInt(split[1], 0) >= ch;
                        if (split == null || split.length < 3) {
                            z = false;
                        } else {
                            z = Util.getInt(split[2], 0) >= ch;
                        }
                        if (CrashReportFactory.hasDebuger()) {
                            z2 = true;
                            z3 = true;
                            z4 = true;
                        } else {
                            z2 = z6;
                            z3 = z5;
                            z4 = z;
                        }
                        if (z3) {
                            t bhj = o.bhj();
                            int i6 = Util.getInt(split[2], 0);
                            Log.i("MicroMsg.VideoInfoStorage", "checkVideoHash in fullCheckRatio:%s path:%s stack:%s", Integer.valueOf(i6), Qw, Util.getStack());
                            long nowMilliSecond = Util.nowMilliSecond();
                            if (Util.isNullOrNil(Qw)) {
                                Log.e("MicroMsg.VideoInfoStorage", "checkVideoHash failed , path:%s ", Qw);
                                str = "";
                            } else {
                                int[] Qz = t.Qz(Qw);
                                if (Qz == null || Qz.length < 33) {
                                    Log.e("MicroMsg.VideoInfoStorage", "checkVideoHash  readHash failed :%s", Qw);
                                    str = "";
                                } else {
                                    bhj.iFy.execSQL("VideoHash", "delete from VideoHash where CreateTime < " + (Util.nowSecond() - 432000));
                                    int i7 = Qz[32];
                                    StringBuffer stringBuffer = new StringBuffer();
                                    for (int i8 = 0; i8 < 32; i8++) {
                                        stringBuffer.append(Integer.toHexString(Qz[i8]));
                                    }
                                    int length = stringBuffer.length();
                                    Vector vector = new Vector();
                                    Vector vector2 = new Vector();
                                    Vector vector3 = new Vector();
                                    Vector vector4 = new Vector();
                                    int i9 = -1;
                                    Cursor rawQuery = bhj.iFy.rawQuery("select size, CreateTime, hash, cdnxml, orgpath from VideoHash where size = ".concat(String.valueOf(i7)), null);
                                    while (rawQuery.moveToNext()) {
                                        long j2 = rawQuery.getLong(1);
                                        String string = rawQuery.getString(2);
                                        String string2 = rawQuery.getString(3);
                                        String string3 = rawQuery.getString(4);
                                        Log.v("MicroMsg.VideoInfoStorage", "checkVideoHash select [%s][%s]", string, string2);
                                        if (Util.isNullOrNil(string) || Util.isNullOrNil(string2)) {
                                            h.INSTANCE.a(12696, 104, Integer.valueOf(i7));
                                            Log.w("MicroMsg.VideoInfoStorage", "checkVideoHash select error [%s][%s]", string, string2);
                                        } else if (length != string.length()) {
                                            h.INSTANCE.a(12696, 105, Integer.valueOf(i7));
                                            Log.w("MicroMsg.VideoInfoStorage", "checkVideoHash err length file:%d cursor:%d", Integer.valueOf(length), Integer.valueOf(string.length()));
                                        } else {
                                            int i10 = 0;
                                            int i11 = 0;
                                            while (i11 < length) {
                                                if (stringBuffer.charAt(i11) == string.charAt(i11)) {
                                                    i4 = i10 + 1;
                                                } else {
                                                    i4 = i10;
                                                }
                                                i11++;
                                                i10 = i4;
                                            }
                                            if (i9 < 0 || vector3.size() <= i9 || ((Integer) vector3.get(i9)).intValue() < i10) {
                                                i3 = vector3.size();
                                            } else {
                                                i3 = i9;
                                            }
                                            vector3.add(Integer.valueOf(i10));
                                            vector.add(string2);
                                            vector2.add(string3);
                                            vector4.add(Long.valueOf(j2));
                                            Log.d("MicroMsg.VideoInfoStorage", "checkVideoHash cursor hitCount:%d/%d ,max:%d vector:%d/%d", Integer.valueOf(i10), Integer.valueOf(length), vector3.get(i3), Integer.valueOf(i3), Integer.valueOf(vector3.size()));
                                            i9 = i3;
                                        }
                                    }
                                    rawQuery.close();
                                    if (i9 < 0 || vector3.size() <= 0) {
                                        h.INSTANCE.a(12696, 201, Integer.valueOf(i7));
                                        Log.w("MicroMsg.VideoInfoStorage", "checkVideoHash cursor empty maxHitIndex:%d vector:%d", Integer.valueOf(i9), Integer.valueOf(vector3.size()));
                                        str = "";
                                    } else {
                                        int intValue = ((Integer) vector3.get(i9)).intValue();
                                        int i12 = (intValue * 100) / 256;
                                        if (i12 < 77) {
                                            h.INSTANCE.a(12696, 202, Integer.valueOf(i7), Integer.valueOf(intValue), 0, Integer.valueOf(vector4.size()));
                                            Log.w("MicroMsg.VideoInfoStorage", "checkVideoHash NotEnoughHit. time:%d hit:%d percentMatch:%s arr:%d path:%s", Long.valueOf(Util.milliSecondsToNow(nowMilliSecond)), Integer.valueOf(intValue), Integer.valueOf(i12), Integer.valueOf(Qz.length - 1), Qw);
                                            str = "";
                                        } else {
                                            String nullAsNil2 = Util.nullAsNil((String) vector.get(i9));
                                            int i13 = 0;
                                            int i14 = 0;
                                            while (i14 < vector3.size()) {
                                                if (i14 == i9 || ((Integer) vector3.get(i14)).intValue() < intValue || nullAsNil2.hashCode() == ((String) vector.get(i14)).hashCode()) {
                                                    i2 = i13;
                                                } else {
                                                    i2 = i13 + 1;
                                                }
                                                i14++;
                                                i13 = i2;
                                            }
                                            if (i13 > 0) {
                                                bhj.iFy.execSQL("VideoHash", "delete from VideoHash where size = ".concat(String.valueOf(i7)));
                                                h.INSTANCE.a(12696, 203, Integer.valueOf(i7), Integer.valueOf(intValue), 0, Integer.valueOf(vector4.size()), 0, "", "", "", Integer.valueOf(i13));
                                                Log.e("MicroMsg.VideoInfoStorage", "checkVideoHash Not ONE hash hit this path, give up duplicate:%s path:%s", Integer.valueOf(i13), Qw);
                                                str = "";
                                            } else {
                                                long milliSecondsToNow = Util.milliSecondsToNow(nowMilliSecond);
                                                long nullAs = Util.nullAs((Long) vector4.get(i9), 0);
                                                String format = String.format("%s,%s,%s,%s,%s", Integer.valueOf(i7), Integer.valueOf(intValue), Long.valueOf(nullAs), Integer.valueOf(vector4.size()), Long.valueOf(milliSecondsToNow));
                                                h.INSTANCE.a(12696, 300, format);
                                                h.INSTANCE.a(12696, Integer.valueOf(i12 + 3000), format);
                                                Log.i("MicroMsg.VideoInfoStorage", "checkVideoHash Succ time:%s hit:%s match:%s%% savetime:%s path:%s xml:%s orgpath:%s", Long.valueOf(milliSecondsToNow), Integer.valueOf(intValue), Integer.valueOf(i12), Long.valueOf(nullAs), Qw, nullAsNil2, vector2.get(i9));
                                                String str2 = (String) vector2.get(i9);
                                                long nowMilliSecond2 = Util.nowMilliSecond() % 1000;
                                                boolean z7 = nowMilliSecond2 < ((long) (i6 * 10)) || i12 < 90;
                                                Log.i("MicroMsg.VideoInfoStorage", "checkVideoHashByteDiff should:%s now:%s ratio:%s percentMatch:%s debuger:%s", Boolean.valueOf(z7), Long.valueOf(nowMilliSecond2), Integer.valueOf(i6), Integer.valueOf(i12), Boolean.valueOf(CrashReportFactory.hasDebuger()));
                                                if (z7 || CrashReportFactory.hasDebuger()) {
                                                    ThreadPool.post(new Runnable(Qw, str2, format) {
                                                        /* class com.tencent.mm.modelvideo.t.AnonymousClass2 */
                                                        final /* synthetic */ String jsE;
                                                        final /* synthetic */ String jsF;
                                                        final /* synthetic */ String jsG;

                                                        {
                                                            this.jsE = r2;
                                                            this.jsF = r3;
                                                            this.jsG = r4;
                                                        }

                                                        /* JADX WARNING: Removed duplicated region for block: B:32:0x00e9  */
                                                        /* JADX WARNING: Removed duplicated region for block: B:36:0x0144  */
                                                        /* Code decompiled incorrectly, please refer to instructions dump. */
                                                        public final void run() {
                                                            /*
                                                            // Method dump skipped, instructions count: 419
                                                            */
                                                            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelvideo.t.AnonymousClass2.run():void");
                                                        }
                                                    }, "checkVideoHashByteDiff", 1);
                                                }
                                                str = nullAsNil2;
                                            }
                                        }
                                    }
                                }
                            }
                            if (!Util.isNullOrNil(str)) {
                                strArr = str.split("##");
                                if (z2 && strArr != null && strArr.length == 2) {
                                    gVar.field_fileId = strArr[0];
                                    gVar.field_aesKey = strArr[1];
                                    this.jqQ = true;
                                }
                                Log.i("MicroMsg.NetSceneUploadVideo", "%s CheckUseVideoHash debug:%s str:%s [%s,%s,%s] hasHash:%s [%s,%s]", bgZ(), Boolean.valueOf(CrashReportFactory.hasDebuger()), nullAsNil, Boolean.valueOf(z3), Boolean.valueOf(z2), Boolean.valueOf(z4), Boolean.valueOf(this.jqQ), gVar.field_fileId, gVar.field_aesKey);
                            }
                        }
                        strArr = null;
                        gVar.field_fileId = strArr[0];
                        gVar.field_aesKey = strArr[1];
                        this.jqQ = true;
                        Log.i("MicroMsg.NetSceneUploadVideo", "%s CheckUseVideoHash debug:%s str:%s [%s,%s,%s] hasHash:%s [%s,%s]", bgZ(), Boolean.valueOf(CrashReportFactory.hasDebuger()), nullAsNil, Boolean.valueOf(z3), Boolean.valueOf(z2), Boolean.valueOf(z4), Boolean.valueOf(this.jqQ), gVar.field_fileId, gVar.field_aesKey);
                    } catch (Exception e2) {
                        Log.e("MicroMsg.NetSceneUploadVideo", "Check use videohash :%s", Util.stackTraceToString(e2));
                    }
                }
                h hVar = h.INSTANCE;
                Object[] objArr3 = new Object[2];
                if (this.jqQ) {
                    i5 = 1;
                } else {
                    i5 = this.jqR ? 2 : 0;
                }
                objArr3[0] = Integer.valueOf(i5 + 700);
                objArr3[1] = Integer.valueOf(this.jqq.iKP);
                hVar.a(12696, objArr3);
                if (Util.isNullOrNil(gVar.field_aesKey) || Util.isNullOrNil(gVar.field_aesKey)) {
                    gVar.field_aesKey = "";
                    gVar.field_fileId = "";
                }
                Log.i("MicroMsg.NetSceneUploadVideo", "%s summersafecdn check hit cache VideoHash :%s %s %s %b %d", bgZ(), gVar.field_mediaId, gVar.field_fileId, gVar.field_aesKey, Boolean.valueOf(this.iZk), Integer.valueOf(gVar.field_largesvideo));
                if (!com.tencent.mm.an.f.baQ().f(gVar)) {
                    h.INSTANCE.idkeyStat(111, 226, 1, false);
                    Log.e("MicroMsg.NetSceneUploadVideo", "%s cdntra addSendTask failed.", bgZ());
                    this.iYT = "";
                    AppMethodBeat.o(126857);
                    return false;
                }
                if (this.jqq.jss != 1) {
                    this.jqq.jss = 1;
                    this.jqq.status = 104;
                    this.jqq.clientId = this.iYT;
                    this.jqq.cSx = 524544;
                    u.f(this.jqq);
                }
                AppMethodBeat.o(126857);
                return true;
            }
            com.tencent.mm.an.f.baQ();
            Log.w("MicroMsg.NetSceneUploadVideo", "%s cdntra not use cdn flag:%b getCdnInfo:%d", bgZ(), Boolean.valueOf(com.tencent.mm.an.b.sS(2)), Integer.valueOf(this.jqq.jss));
            AppMethodBeat.o(126857);
            return false;
        }
    }

    public g(String str) {
        AppMethodBeat.i(126858);
        Assert.assertTrue(str != null);
        Log.d("MicroMsg.NetSceneUploadVideo", "NetSceneUploadVideo:  file:".concat(String.valueOf(str)));
        this.fileName = str;
        this.jqq = u.QN(str);
        if (this.jqq != null) {
            this.MAX_TIMES = 2500;
        } else {
            this.MAX_TIMES = 0;
        }
        this.hvh = new f.a();
        if (this.jqq != null && 3 == this.jqq.jsu) {
            this.jqs = com.tencent.mm.i.a.MediaType_TinyVideo;
        }
        Log.i("MicroMsg.NetSceneUploadVideo", "%s NetSceneUploadVideo:  videoType:[%d]", bgZ(), Integer.valueOf(this.jqs));
        AppMethodBeat.o(126858);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        boolean z;
        boolean z2;
        String str;
        String KC;
        AppMethodBeat.i(126859);
        this.callback = iVar;
        this.jqq = u.QN(this.fileName);
        if (this.jqq == null || !(this.jqq.status == 104 || this.jqq.status == 103)) {
            Log.e("MicroMsg.NetSceneUploadVideo", "%s Get info Failed file:", bgZ(), this.fileName);
            this.retCode = 0 - (f.getLine() + 10000);
            AppMethodBeat.o(126859);
            return -1;
        }
        StringBuilder append = new StringBuilder("doscene file:").append(this.fileName).append(" stat:").append(this.jqq.status).append(" [").append(this.jqq.jsk).append(",").append(this.jqq.jsl).append("] [").append(this.jqq.jqP).append(",").append(this.jqq.iKP).append("]  netTimes:").append(this.jqq.jsp).append(" times:");
        int i2 = this.hjI;
        this.hjI = i2 + 1;
        Log.d("MicroMsg.NetSceneUploadVideo", append.append(i2).toString());
        if (this.startTime == 0) {
            this.startTime = Util.nowMilliSecond();
            this.jqP = this.jqq.jqP;
        }
        o.bhj();
        if (r.Qm(t.Qw(this.fileName))) {
            Log.w("MicroMsg.NetSceneUploadVideo", "%s it is mm h265 video xml[%s]", bgZ(), this.jqq.bhv());
            h.INSTANCE.idkeyStat(354, 139, 1, false);
        }
        if (bgY()) {
            Log.d("MicroMsg.NetSceneUploadVideo", "cdntra use cdn return -1 for onGYNetEnd clientid:%s", this.fileName);
            AppMethodBeat.o(126859);
            return 0;
        }
        if (ab.JF(this.jqq.getUser())) {
            Log.w("MicroMsg.NetSceneUploadVideo", "%s cdntra not use parallel-upload user:%s", bgZ(), this.jqq.getUser());
            z2 = false;
        } else {
            if (1 == ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_parallel_upload_video_android, 0)) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                Log.i("MicroMsg.NetSceneUploadVideo", "NOT ALLOW USE PARALLEL UPLOAD VIDEO");
                z2 = false;
            } else {
                o.bhj();
                String Qx = t.Qx(this.fileName);
                o.bhj();
                String Qw = t.Qw(this.fileName);
                String Qf = Qf(Qx);
                com.tencent.mm.pluginsdk.f.d dVar = new com.tencent.mm.pluginsdk.f.d();
                dVar.iXv = (long) this.jqq.jso;
                dVar.JTT = this.iZw;
                dVar.scene = 2;
                dVar.fileType = 4;
                dVar.thumbPath = Qf;
                dVar.fullPath = Qw;
                new com.tencent.mm.pluginsdk.f.c().a(dVar);
                Log.i("MicroMsg.NetSceneUploadVideo", "use ParallelUploader, filename:%s", this.fileName);
                z2 = true;
            }
        }
        if (z2) {
            Log.d("MicroMsg.NetSceneUploadVideo", "cdntra use parallel-upload return -1 for onGYNetEnd clientid:%s", this.fileName);
            AppMethodBeat.o(126859);
            return 0;
        }
        if (this.jqq.jsr == 1) {
            this.dwS = true;
        } else if (this.jqq.createTime + 600 < Util.nowSecond()) {
            Log.e("MicroMsg.NetSceneUploadVideo", "create time check error:" + this.fileName);
            u.QE(this.fileName);
            this.retCode = 0 - (f.getLine() + 10000);
            AppMethodBeat.o(126859);
            return -1;
        } else if (!u.QD(this.fileName)) {
            Log.e("MicroMsg.NetSceneUploadVideo", "checkVoiceNetTimes Failed file:" + this.fileName);
            u.QE(this.fileName);
            this.retCode = 0 - (f.getLine() + 10000);
            AppMethodBeat.o(126859);
            return -1;
        }
        d.a aVar = new d.a();
        aVar.iLN = new eoc();
        aVar.iLO = new eod();
        aVar.uri = "/cgi-bin/micromsg-bin/uploadvideo";
        aVar.funcId = 149;
        aVar.iLP = 39;
        aVar.respCmdId = 1000000039;
        this.rr = aVar.aXF();
        eoc eoc = (eoc) this.rr.iLK.iLR;
        eoc.xNH = (String) com.tencent.mm.kernel.g.aAh().azQ().get(2, "");
        eoc.xNG = this.jqq.getUser();
        eoc.KIz = this.fileName;
        if (this.dwS) {
            eoc.KTf = 2;
        }
        if (this.jqq.jsu == 3) {
            eoc.KTf = 3;
        }
        eoc.MXo = this.jqq.iFw;
        eoc.MrT = this.jqq.jsl;
        eoc.NlP = this.jqq.iKP;
        eoc.LrC = ag.dm(MMApplicationContext.getContext()) ? 1 : 2;
        eoc.MrW = 2;
        eoc.NlQ = 0;
        eoc.NlR = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
        eoc.MrV = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
        if (Util.isNullOrNil(this.ebj)) {
            o.bhj();
            str = s.bhK(t.Qw(this.fileName));
            this.ebj = str;
        } else {
            str = this.ebj;
        }
        eoc.NlU = str;
        if (!Util.isNullOrNil(this.jqq.jsz)) {
            KC = br.KC(this.jqq.jsz);
        } else if (this.jqq.jsy > 0) {
            KC = br.KC(br.KB(((l) com.tencent.mm.kernel.g.af(l.class)).eiy().Hb((long) this.jqq.jsy).fqK));
        } else {
            String bhK = s.bhK(this.jqq.bhu());
            v vVar = v.jNy;
            KC = br.KC(v.Ss(bhK));
        }
        if (Util.isNullOrNil(KC)) {
            KC = br.ajw();
        }
        Log.i("MicroMsg.NetSceneUploadVideo", "video msg source is %s".concat(String.valueOf(KC)));
        eoc.KHq = KC;
        eoc.Nmd = this.jqq.ean;
        eeq eeq = this.jqq.jsw;
        if (eeq != null && !Util.isNullOrNil(eeq.iyZ)) {
            eoc.NlV = Util.nullAs(eeq.iyZ, "");
            eoc.NlW = eeq.LxJ;
            eoc.NlX = Util.nullAs(eeq.izb, "");
            eoc.NlZ = Util.nullAs(eeq.izd, "");
            eoc.NlY = Util.nullAs(eeq.izc, "");
            eoc.Nma = Util.nullAs(eeq.ize, "");
        } else if (eeq != null && !Util.isNullOrNil(eeq.izd) && !Util.isNullOrNil(eeq.izc)) {
            eoc.NlZ = eeq.izd;
            eoc.NlY = eeq.izc;
        }
        if (((com.tencent.mm.plugin.messenger.foundation.a.s) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).ifAddTicketByActionFlag(this.jqq.getUser())) {
            eoc.LbN = ((l) com.tencent.mm.kernel.g.af(l.class)).aSN().bjT(this.jqq.getUser());
        }
        if (eeq != null) {
            eoc.Nmc = Util.nullAs(eeq.izf, "");
            eoc.Nmb = Util.nullAs(eeq.izg, "");
        }
        Log.d("MicroMsg.NetSceneUploadVideo", "upload video: play length %d, thumb totalLen %d, video totalLen %d, funcFlag %d, videoMd5: %s stream %s streamtime: %d title %s thumburl %s", Integer.valueOf(eoc.MXo), Integer.valueOf(eoc.MrU), Integer.valueOf(eoc.NlP), Integer.valueOf(eoc.KTf), eoc.NlU, eoc.NlV, Integer.valueOf(eoc.NlW), eoc.NlX, eoc.Nma);
        if (this.jqq.status == 103) {
            o.bhj();
            t.b t = t.t(t.Qx(this.fileName), this.jqq.jsk, jqN);
            if (t.ret < 0 || t.dAc == 0) {
                h.INSTANCE.idkeyStat(111, 225, 1, false);
                u.QE(this.fileName);
                Log.e("MicroMsg.NetSceneUploadVideo", "doScene READ THUMB[" + this.fileName + "]  Error ");
                this.retCode = 0 - (f.getLine() + 10000);
                AppMethodBeat.o(126859);
                return -1;
            }
            Log.d("MicroMsg.NetSceneUploadVideo", "doScene READ THUMB[" + this.fileName + "] read ret:" + t.ret + " readlen:" + t.dAc + " newOff:" + t.jsR + " netOff:" + this.jqq.jsk);
            if (t.jsR < this.jqq.jsk) {
                Log.e("MicroMsg.NetSceneUploadVideo", "Err doScene READ THUMB[" + this.fileName + "] newOff:" + t.jsR + " OldtOff:" + this.jqq.jsk);
                u.QE(this.fileName);
                this.retCode = 0 - (f.getLine() + 10000);
                AppMethodBeat.o(126859);
                return -1;
            }
            byte[] bArr = new byte[t.dAc];
            System.arraycopy(t.buf, 0, bArr, 0, t.dAc);
            eoc.MrU = this.jqq.jsk;
            eoc.MrV = new SKBuiltinBuffer_t().setBuffer(bArr);
        } else {
            o.bhj();
            t.b t2 = t.t(t.Qw(this.fileName), this.jqq.jqP, jqN);
            if (t2.ret < 0 || t2.dAc == 0) {
                h.INSTANCE.idkeyStat(111, 224, 1, false);
                u.QE(this.fileName);
                Log.e("MicroMsg.NetSceneUploadVideo", "doScene READ VIDEO[" + this.fileName + "]  Error ");
                this.retCode = 0 - (f.getLine() + 10000);
                AppMethodBeat.o(126859);
                return -1;
            }
            Log.d("MicroMsg.NetSceneUploadVideo", "doScene READ VIDEO[" + this.fileName + "] read ret:" + t2.ret + " readlen:" + t2.dAc + " newOff:" + t2.jsR + " netOff:" + this.jqq.jqP);
            if (t2.jsR < this.jqq.jqP) {
                Log.e("MicroMsg.NetSceneUploadVideo", "Err doScene READ VIDEO[" + this.fileName + "] newOff:" + t2.jsR + " OldtOff:" + this.jqq.jqP);
                u.QE(this.fileName);
                this.retCode = 0 - (f.getLine() + 10000);
                AppMethodBeat.o(126859);
                return -1;
            } else if (t2.jsR >= c.jpN) {
                h.INSTANCE.idkeyStat(111, 222, 1, false);
                Log.e("MicroMsg.NetSceneUploadVideo", "Err doScene READ VIDEO[" + this.fileName + "] maxsize:" + c.jpN);
                u.QE(this.fileName);
                this.retCode = 0 - (f.getLine() + 10000);
                AppMethodBeat.o(126859);
                return -1;
            } else {
                byte[] bArr2 = new byte[t2.dAc];
                System.arraycopy(t2.buf, 0, bArr2, 0, t2.dAc);
                eoc.NlQ = this.jqq.jqP;
                eoc.MrU = this.jqq.jsk;
                eoc.NlR = new SKBuiltinBuffer_t().setBuffer(bArr2);
            }
        }
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(126859);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final q.b securityVerificationChecked(com.tencent.mm.network.s sVar) {
        AppMethodBeat.i(126860);
        eoc eoc = (eoc) ((com.tencent.mm.ak.d) sVar).iLK.iLR;
        if (Util.isNullOrNil(eoc.KIz) || eoc.MrW <= 0 || Util.isNullOrNil(eoc.xNH) || Util.isNullOrNil(eoc.xNG) || eoc.LrC <= 0 || eoc.MrU > eoc.MrT || eoc.MrU < 0 || eoc.NlQ > eoc.NlP || eoc.NlQ < 0 || ((eoc.NlQ == eoc.NlP && eoc.MrU == eoc.MrT) || eoc.MrT <= 0 || eoc.NlP <= 0 || (eoc.NlR.getILen() <= 0 && eoc.MrV.getILen() <= 0))) {
            Log.e("MicroMsg.NetSceneUploadVideo", "ERR: Security Check Failed file:" + this.fileName + " user:" + eoc.xNG);
            q.b bVar = q.b.EFailed;
            AppMethodBeat.o(126860);
            return bVar;
        }
        q.b bVar2 = q.b.EOk;
        AppMethodBeat.o(126860);
        return bVar2;
    }

    @Override // com.tencent.mm.ak.q
    public final int securityLimitCount() {
        return this.MAX_TIMES;
    }

    @Override // com.tencent.mm.ak.q
    public final void setSecurityCheckError(q.a aVar) {
        AppMethodBeat.i(126861);
        h.INSTANCE.idkeyStat(111, 221, 1, false);
        u.QE(this.fileName);
        AppMethodBeat.o(126861);
    }

    @Override // com.tencent.mm.ak.q
    public final long getReturnTimeout() {
        return 1800000;
    }

    @Override // com.tencent.mm.ak.q
    public final boolean securityLimitCountReach() {
        AppMethodBeat.i(126862);
        boolean securityLimitCountReach = super.securityLimitCountReach();
        if (securityLimitCountReach) {
            h.INSTANCE.idkeyStat(111, 210, 1, false);
        }
        AppMethodBeat.o(126862);
        return securityLimitCountReach;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, com.tencent.mm.network.s sVar, byte[] bArr) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(126863);
        Log.i("MicroMsg.NetSceneUploadVideo", "cdntra onGYNetEnd errtype:" + i3 + " errcode:" + i4 + " useCdnTransClientId:" + this.iYT);
        if (this.jqt) {
            Log.d("MicroMsg.NetSceneUploadVideo", "onGYNetEnd Call Stop by Service   file:" + this.fileName + " user:" + this.jqq.getUser());
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(126863);
            return;
        }
        eod eod = (eod) ((com.tencent.mm.ak.d) sVar).iLL.iLR;
        eoc eoc = (eoc) ((com.tencent.mm.ak.d) sVar).iLK.iLR;
        if (eod != null && (i3 == 4 || (i3 == 0 && i4 == 0))) {
            ((com.tencent.mm.plugin.messenger.foundation.a.s) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).setEnSendMsgActionFlag(eod.LbO);
        }
        if (i3 == 3 && i4 == -1 && !Util.isNullOrNil(this.iYT)) {
            Log.w("MicroMsg.NetSceneUploadVideo", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", this.iYT);
            AppMethodBeat.o(126863);
            return;
        }
        this.jqq = u.QN(this.fileName);
        if (this.jqq == null) {
            Log.e("MicroMsg.NetSceneUploadVideo", "ERR: onGYNetEnd Get INFO FAILED :" + this.fileName);
            this.retCode = (0 - f.getLine()) - 10000;
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(126863);
        } else if (this.jqq.status == 105) {
            Log.w("MicroMsg.NetSceneUploadVideo", "onGYNetEnd STATUS PAUSE [" + this.fileName + "," + this.jqq.dTS + "," + this.jqq.bhs() + "," + this.jqq.getUser() + "] ");
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(126863);
        } else if (this.jqq.status != 104 && this.jqq.status != 103) {
            Log.e("MicroMsg.NetSceneUploadVideo", "ERR: onGYNetEnd STATUS ERR: status:" + this.jqq.status + " [" + this.fileName + "," + this.jqq.dTS + "," + this.jqq.bhs() + "," + this.jqq.getUser() + "] ");
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(126863);
        } else if (i3 == 4 && i4 == -22) {
            Log.e("MicroMsg.NetSceneUploadVideo", "ERR: onGYNetEnd BLACK  errtype:" + i3 + " errCode:" + i4 + "  file:" + this.fileName + " user:" + this.jqq.getUser());
            u.QF(this.fileName);
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(126863);
        } else if (i3 == 4 && i4 != 0) {
            h.INSTANCE.idkeyStat(111, 220, 1, false);
            Log.e("MicroMsg.NetSceneUploadVideo", "ERR: onGYNetEnd SERVER FAILED errtype:" + i3 + " errCode:" + i4 + "  file:" + this.fileName + " user:" + this.jqq.getUser());
            u.QE(this.fileName);
            h.INSTANCE.a(10420, Integer.valueOf(i4), 1, Long.valueOf(this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(this.jqs), 0);
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(126863);
        } else if (i3 != 0 || i4 != 0) {
            h.INSTANCE.idkeyStat(111, 219, 1, false);
            Log.e("MicroMsg.NetSceneUploadVideo", "ERR: onGYNetEnd FAILED (WILL RETRY) errtype:" + i3 + " errCode:" + i4 + "  file:" + this.fileName + " user:" + this.jqq.getUser());
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(126863);
        } else if (!Util.isNullOrNil(eoc.MrV.getBuffer().zy) && eoc.MrU != eod.MrU - eoc.MrV.getILen()) {
            Log.e("MicroMsg.NetSceneUploadVideo", "onGYNetEnd Err Thumb Pos:[" + eoc.MrU + "," + eoc.MrV.getILen() + "," + eod.MrU + "] file:" + this.fileName + " user:" + eoc.xNG);
            u.QE(this.fileName);
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(126863);
        } else if (Util.isNullOrNil(eoc.NlR.getBuffer().zy) || eoc.NlQ == eod.NlQ - eoc.NlR.getILen()) {
            this.jqq.jsm = Util.nowSecond();
            this.jqq.dTS = eod.Brn;
            this.jqq.cSx = TXLiteAVCode.EVT_SW_ENCODER_START_SUCC;
            Log.d("MicroMsg.NetSceneUploadVideo", "dkmsgid  set svrmsgid %d -> %d", Long.valueOf(this.jqq.dTS), Integer.valueOf(ac.jOD));
            if (!(10007 != ac.jOC || ac.jOD == 0 || this.jqq.dTS == 0)) {
                this.jqq.dTS = (long) ac.jOD;
                ac.jOD = 0;
            }
            int i5 = this.jqq.status;
            if (i5 == 103) {
                this.jqq.jsk = eoc.MrV.getILen() + eoc.MrU;
                this.jqq.cSx |= 64;
                if (this.jqq.jsk >= this.jqq.jsl) {
                    this.jqq.status = 104;
                    this.jqq.cSx |= 256;
                    z = false;
                }
                z = false;
            } else if (i5 == 104) {
                this.jqq.jqP = eoc.NlR.getILen() + eoc.NlQ;
                this.jqq.cSx |= 8;
                if (this.jqq.jqP >= this.jqq.iKP) {
                    this.jqq.status = 199;
                    this.jqq.cSx |= 256;
                    u.d(this.jqq);
                    z = true;
                }
                z = false;
            } else {
                Log.e("MicroMsg.NetSceneUploadVideo", "onGYNetEnd ERROR STATUS:" + i5 + " file:" + this.fileName + " user:" + eoc.xNG);
                u.QE(this.fileName);
                this.callback.onSceneEnd(i3, i4, str, this);
                AppMethodBeat.o(126863);
                return;
            }
            u.f(this.jqq);
            if (this.jqt) {
                this.callback.onSceneEnd(i3, i4, str, this);
                AppMethodBeat.o(126863);
            } else if (!z) {
                this.iKj.startTimer(10);
                AppMethodBeat.o(126863);
            } else {
                ca Hb = ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().Hb((long) this.jqq.jso);
                Hb.BB(eod.KHq);
                ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().a(Hb.field_msgId, Hb);
                com.tencent.mm.modelstat.b.jmd.s(Hb);
                h.INSTANCE.a(10420, 0, 1, Long.valueOf(this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(this.jqs), Integer.valueOf(this.jqq.iKP - this.jqP));
                if (this.jqq == null) {
                    z2 = false;
                } else {
                    as Kn = ((l) com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(this.jqq.getUser());
                    if (Kn == null || ((int) Kn.gMZ) <= 0) {
                        z2 = false;
                    } else {
                        z2 = Kn.gBM();
                    }
                }
                if (z2 || ab.Jf(this.jqq.getUser())) {
                    Log.i("MicroMsg.NetSceneUploadVideo", "upload to biz :%s", this.jqq.getUser());
                    if (this.jqq.dTS < 0) {
                        Log.e("MicroMsg.NetSceneUploadVideo", "ERR: finish video invaild MSGSVRID :" + this.jqq.dTS + " file:" + this.fileName + " toUser:" + this.jqq.getUser());
                        u.QE(this.fileName);
                    }
                } else {
                    Log.i("MicroMsg.NetSceneUploadVideo", "not upload to biz");
                    if (this.jqq.dTS <= 0) {
                        Log.e("MicroMsg.NetSceneUploadVideo", "ERR: finish video invaild MSGSVRID :" + this.jqq.dTS + " file:" + this.fileName + " toUser:" + this.jqq.getUser());
                        u.QE(this.fileName);
                    }
                }
                long apr = this.hvh != null ? this.hvh.apr() : 0;
                Log.d("MicroMsg.NetSceneUploadVideo", "!!!FIN: file:" + this.fileName + " toUser:" + this.jqq.getUser() + " msgsvrid:" + this.jqq.dTS + " thumbsize:" + this.jqq.jsl + " videosize:" + this.jqq.iKP + " useTime:" + apr);
                Log.d("MicroMsg.NetSceneUploadVideo", "FinishLogForTime file:" + this.fileName + " packSize:" + jqN + " filesize:" + this.jqq.iKP + " useTime:" + apr);
                a.a(this.jqq, 0);
                this.callback.onSceneEnd(i3, i4, str, this);
                AppMethodBeat.o(126863);
            }
        } else {
            Log.e("MicroMsg.NetSceneUploadVideo", "onGYNetEnd Err Thumb Pos:[" + eoc.NlQ + "," + eoc.NlR.getILen() + "," + eod.NlQ + "] file:" + this.fileName + " user:" + eoc.xNG);
            u.QE(this.fileName);
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(126863);
        }
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 149;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x016e A[SYNTHETIC, Splitter:B:41:0x016e] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0173 A[SYNTHETIC, Splitter:B:44:0x0173] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0180 A[SYNTHETIC, Splitter:B:51:0x0180] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0185 A[SYNTHETIC, Splitter:B:54:0x0185] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x018f  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x01d8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String Qf(java.lang.String r13) {
        /*
        // Method dump skipped, instructions count: 482
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelvideo.g.Qf(java.lang.String):java.lang.String");
    }

    private String bgZ() {
        AppMethodBeat.i(126865);
        String str = this.fileName + "_" + hashCode();
        AppMethodBeat.o(126865);
        return str;
    }

    @Override // com.tencent.mm.ak.q
    public final void cancel() {
        AppMethodBeat.i(126856);
        Log.i("MicroMsg.NetSceneUploadVideo", "%s stop %s", bgZ(), this.iYT);
        if (!Util.isNullOrNil(this.iYT)) {
            com.tencent.mm.an.f.baQ().Ob(this.iYT);
        }
        this.jqt = true;
        super.cancel();
        AppMethodBeat.o(126856);
    }

    static /* synthetic */ int f(g gVar) {
        int i2;
        AppMethodBeat.i(240863);
        o.bhj();
        String Qw = t.Qw(gVar.jqq.getFileName());
        if (!com.tencent.mm.plugin.a.c.Sx(Qw)) {
            Log.w("MicroMsg.NetSceneUploadVideo", "%s check preload length but it not mp4.", gVar.bgZ());
            AppMethodBeat.o(240863);
            return 0;
        }
        com.tencent.mm.plugin.a.b bVar = new com.tencent.mm.plugin.a.b();
        long Sw = bVar.Sw(Qw);
        long j2 = bVar.jPX;
        if (Sw >= 131072 || Sw <= 0 || gVar.jqq.iFw <= 5 || bVar.jPY <= 0 || j2 <= 0) {
            i2 = 0;
        } else {
            i2 = ((int) j2) + ((int) ((bVar.jPY * 5) / ((long) gVar.jqq.iFw)));
            if (i2 <= 131072) {
                i2 += 131072;
            }
        }
        Log.i("MicroMsg.NetSceneUploadVideo", "%s check preload length[%d] moovPos[%d %d] duration[%d] filelen[%d]", gVar.bgZ(), Integer.valueOf(i2), Long.valueOf(Sw), Long.valueOf(j2), Integer.valueOf(gVar.jqq.iFw), Long.valueOf(bVar.jPY));
        AppMethodBeat.o(240863);
        return i2;
    }

    static /* synthetic */ void a(g gVar, com.tencent.mm.i.d dVar) {
        String KB;
        AppMethodBeat.i(240865);
        ca Hb = ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().Hb((long) gVar.jqq.jso);
        if (!Util.isNullOrNil(gVar.jqq.jsz)) {
            KB = gVar.jqq.jsz;
        } else {
            KB = br.KB(Hb.fqK);
        }
        n bhh = n.bhh();
        o.bhj();
        bhh.a(dVar, t.Qw(gVar.fileName), KB, Hb.field_msgSvrId);
        AppMethodBeat.o(240865);
    }
}
