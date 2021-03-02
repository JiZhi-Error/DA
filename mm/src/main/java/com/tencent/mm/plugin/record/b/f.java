package com.tencent.mm.plugin.record.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.b.a.w;
import com.tencent.mm.g.b.a.y;
import com.tencent.mm.i.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.z;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.comm.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.c;
import com.tencent.mm.protocal.protobuf.aht;
import com.tencent.mm.protocal.protobuf.ahu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.smtt.sdk.TbsListener;
import java.io.ByteArrayOutputStream;

public final class f extends q implements m {
    private boolean BGA;
    private boolean BGB;
    c BGu;
    public long BGw;
    private int BGx;
    String BGy;
    private boolean BGz;
    private i callback;
    ca dTX;
    j iYO;
    String iYT;
    private g.a iZc;
    private String mediaId;
    public long msgId;
    private long oNJ;
    public boolean qJf;
    public int retCode;
    private d rr;
    long startTime;
    private int type;

    public interface a {
        void eIn();
    }

    static /* synthetic */ void a(f fVar, int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(9483);
        fVar.g(i2, i3, str, qVar);
        AppMethodBeat.o(9483);
    }

    public f(String str) {
        this(str, 0, (j) null);
    }

    public f(long j2, String str, j jVar) {
        this(str, j2, jVar);
        this.msgId = j2;
    }

    public f(long j2, long j3, j jVar) {
        AppMethodBeat.i(9475);
        this.BGu = null;
        this.BGw = -1;
        this.mediaId = "";
        this.msgId = 0;
        this.dTX = null;
        this.iYT = "";
        this.startTime = 0;
        this.BGx = -1;
        this.BGy = "";
        this.type = 0;
        this.retCode = 0;
        this.BGz = false;
        this.BGA = false;
        this.oNJ = 0;
        this.qJf = false;
        this.BGB = false;
        this.iZc = new g.a() {
            /* class com.tencent.mm.plugin.record.b.f.AnonymousClass1 */

            @Override // com.tencent.mm.i.g.a
            public final int a(String str, final int i2, com.tencent.mm.i.c cVar, final com.tencent.mm.i.d dVar, boolean z) {
                String str2;
                AppMethodBeat.i(9473);
                Object[] objArr = new Object[5];
                objArr[0] = str;
                objArr[1] = Integer.valueOf(i2);
                objArr[2] = cVar;
                objArr[3] = dVar;
                objArr[4] = Boolean.valueOf(cVar == null);
                Log.d("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback mediaId[%s], startRet[%d], progressInfo[%s], sceneResult[%s], finish[%b]", objArr);
                if (i2 == -21006) {
                    Log.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra  ERR_CNDCOM_MEDIA_IS_DOWNLOADING clientid:%s", f.this.iYT);
                    AppMethodBeat.o(9473);
                    return 0;
                } else if (i2 != 0) {
                    a.HS(f.this.BGu.systemRowid);
                    new y(com.tencent.mm.plugin.report.a.t(Integer.valueOf(i2), 2, Long.valueOf(f.this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), 0, "")).bfK();
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.record.b.f.AnonymousClass1.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(9465);
                            f.a(f.this, 3, i2, "", f.this);
                            AppMethodBeat.o(9465);
                        }
                    });
                    AppMethodBeat.o(9473);
                    return 0;
                } else {
                    f.this.BGu = a.s(str, f.this.msgId);
                    if (f.this.BGu == null) {
                        Log.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig attachInfo is null");
                        MMHandlerThread.postToMainThread(new Runnable() {
                            /* class com.tencent.mm.plugin.record.b.f.AnonymousClass1.AnonymousClass2 */

                            public final void run() {
                                AppMethodBeat.i(9466);
                                f.a(f.this, 3, i2, "", f.this);
                                AppMethodBeat.o(9466);
                            }
                        });
                        AppMethodBeat.o(9473);
                        return 0;
                    } else if (f.this.BGu.field_status == 102) {
                        Log.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig dancy attach download has paused, status:%d", Long.valueOf(f.this.BGu.field_status));
                        com.tencent.mm.an.f.baQ().Ob(f.this.iYT);
                        MMHandlerThread.postToMainThread(new Runnable() {
                            /* class com.tencent.mm.plugin.record.b.f.AnonymousClass1.AnonymousClass3 */

                            public final void run() {
                                AppMethodBeat.i(9467);
                                f.a(f.this, 3, i2, "attach  has paused, status=" + f.this.BGu.field_status, f.this);
                                AppMethodBeat.o(9467);
                            }
                        });
                        AppMethodBeat.o(9473);
                        return 0;
                    } else if (cVar == null) {
                        if (dVar != null) {
                            if (dVar.field_retCode != 0) {
                                a.HS(f.this.BGu.systemRowid);
                                Log.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra sceneResult.retCode :%d", Integer.valueOf(dVar.field_retCode));
                            } else {
                                new o(f.this.BGy).am(new o(f.this.BGu.field_fileFullPath));
                                f.this.BGu.field_status = 199;
                                f.this.BGu.field_offset = f.this.BGu.field_totalLen;
                                com.tencent.mm.plugin.r.a.cgO().a(f.this.BGu, new String[0]);
                                h.INSTANCE.idkeyStat(198, 45, f.this.BGu.field_totalLen, false);
                                h.INSTANCE.idkeyStat(198, 46, 1, false);
                                h hVar = h.INSTANCE;
                                if (f.this.dTX == null) {
                                    str2 = "";
                                } else {
                                    str2 = f.this.dTX.field_talker;
                                }
                                hVar.idkeyStat(198, ab.Eq(str2) ? 48 : 47, 1, false);
                                ca Hb = ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().Hb(f.this.BGu.field_msgInfoId);
                                if (Hb.field_status == 5) {
                                    Hb.setStatus(3);
                                    ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().a(Hb.field_msgId, Hb);
                                } else {
                                    ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().a(new i.c(Hb.field_talker, "update", Hb));
                                }
                            }
                            new y(com.tencent.mm.plugin.report.a.t(Integer.valueOf(dVar.field_retCode), 2, Long.valueOf(f.this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(f.this.BGu.field_totalLen), dVar.field_transInfo, "", "", "", "", "", "", "", dVar.gqk)).bfK();
                            if (dVar.field_retCode != 0) {
                                new w(com.tencent.mm.plugin.report.a.t(Integer.valueOf(dVar.field_retCode), 2, Long.valueOf(f.this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(f.this.BGu.field_totalLen), dVar.field_transInfo, "", "", "", "", "", "", "", dVar.gqk)).bfK();
                            }
                            if (f.this.iYO != null) {
                                MMHandlerThread.postToMainThread(new Runnable() {
                                    /* class com.tencent.mm.plugin.record.b.f.AnonymousClass1.AnonymousClass6 */

                                    public final void run() {
                                        AppMethodBeat.i(9470);
                                        f.this.iYO.a((int) f.this.BGu.field_offset, (int) f.this.BGu.field_totalLen, f.this);
                                        AppMethodBeat.o(9470);
                                    }
                                });
                            }
                            if (dVar.field_retCode != 0) {
                                MMHandlerThread.postToMainThread(new Runnable() {
                                    /* class com.tencent.mm.plugin.record.b.f.AnonymousClass1.AnonymousClass7 */

                                    public final void run() {
                                        AppMethodBeat.i(9471);
                                        f.a(f.this, 3, dVar.field_retCode, "", f.this);
                                        AppMethodBeat.o(9471);
                                    }
                                });
                            } else {
                                MMHandlerThread.postToMainThread(new Runnable() {
                                    /* class com.tencent.mm.plugin.record.b.f.AnonymousClass1.AnonymousClass8 */

                                    public final void run() {
                                        AppMethodBeat.i(9472);
                                        f.a(f.this, 0, 0, "", f.this);
                                        AppMethodBeat.o(9472);
                                    }
                                });
                            }
                        }
                        AppMethodBeat.o(9473);
                        return 0;
                    } else if (cVar.field_finishedLength == f.this.BGu.field_totalLen) {
                        Log.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra ignore progress 100%");
                        AppMethodBeat.o(9473);
                        return 0;
                    } else if (f.this.BGu.field_offset > cVar.field_finishedLength) {
                        Log.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdnEndProc error oldpos:%d newpos:%d", Long.valueOf(f.this.BGu.field_offset), Long.valueOf(cVar.field_finishedLength));
                        a.HS(f.this.BGu.systemRowid);
                        MMHandlerThread.postToMainThread(new Runnable() {
                            /* class com.tencent.mm.plugin.record.b.f.AnonymousClass1.AnonymousClass4 */

                            public final void run() {
                                AppMethodBeat.i(9468);
                                f.a(f.this, 3, i2, "", f.this);
                                AppMethodBeat.o(9468);
                            }
                        });
                        AppMethodBeat.o(9473);
                        return 0;
                    } else {
                        f.this.BGu.field_offset = cVar.field_finishedLength;
                        com.tencent.mm.plugin.r.a.cgO().a(f.this.BGu, new String[0]);
                        if (f.this.iYO != null) {
                            MMHandlerThread.postToMainThread(new Runnable() {
                                /* class com.tencent.mm.plugin.record.b.f.AnonymousClass1.AnonymousClass5 */

                                public final void run() {
                                    AppMethodBeat.i(9469);
                                    f.this.iYO.a((int) f.this.BGu.field_offset, (int) f.this.BGu.field_totalLen, f.this);
                                    AppMethodBeat.o(9469);
                                }
                            });
                        }
                        Log.d("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra progresscallback id:%s finish:%d total:%d", f.this.iYT, Long.valueOf(cVar.field_finishedLength), Long.valueOf(cVar.field_toltalLength));
                        AppMethodBeat.o(9473);
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
        this.oNJ = j3;
        this.msgId = j2;
        this.BGu = com.tencent.mm.plugin.r.a.cgO().Mp(j2);
        this.iYO = jVar;
        this.BGA = true;
        if (this.BGu == null) {
            Log.e("MicroMsg.NetSceneDownloadAppAttach", "big appMsg, info is null, msgid = , svrId".concat(String.valueOf(j2)), Long.valueOf(j3));
            AppMethodBeat.o(9475);
            return;
        }
        d.a aVar = new d.a();
        aVar.iLN = new aht();
        aVar.iLO = new ahu();
        aVar.uri = "/cgi-bin/micromsg-bin/downloadappattach";
        aVar.funcId = TbsListener.ErrorCode.INCRUPDATE_INSTALL_SUCCESS;
        aVar.iLP = 106;
        aVar.respCmdId = 1000000106;
        this.rr = aVar.aXF();
        AppMethodBeat.o(9475);
    }

    public f(c cVar) {
        AppMethodBeat.i(9476);
        this.BGu = null;
        this.BGw = -1;
        this.mediaId = "";
        this.msgId = 0;
        this.dTX = null;
        this.iYT = "";
        this.startTime = 0;
        this.BGx = -1;
        this.BGy = "";
        this.type = 0;
        this.retCode = 0;
        this.BGz = false;
        this.BGA = false;
        this.oNJ = 0;
        this.qJf = false;
        this.BGB = false;
        this.iZc = new g.a() {
            /* class com.tencent.mm.plugin.record.b.f.AnonymousClass1 */

            @Override // com.tencent.mm.i.g.a
            public final int a(String str, final int i2, com.tencent.mm.i.c cVar, final com.tencent.mm.i.d dVar, boolean z) {
                String str2;
                AppMethodBeat.i(9473);
                Object[] objArr = new Object[5];
                objArr[0] = str;
                objArr[1] = Integer.valueOf(i2);
                objArr[2] = cVar;
                objArr[3] = dVar;
                objArr[4] = Boolean.valueOf(cVar == null);
                Log.d("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback mediaId[%s], startRet[%d], progressInfo[%s], sceneResult[%s], finish[%b]", objArr);
                if (i2 == -21006) {
                    Log.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra  ERR_CNDCOM_MEDIA_IS_DOWNLOADING clientid:%s", f.this.iYT);
                    AppMethodBeat.o(9473);
                    return 0;
                } else if (i2 != 0) {
                    a.HS(f.this.BGu.systemRowid);
                    new y(com.tencent.mm.plugin.report.a.t(Integer.valueOf(i2), 2, Long.valueOf(f.this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), 0, "")).bfK();
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.record.b.f.AnonymousClass1.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(9465);
                            f.a(f.this, 3, i2, "", f.this);
                            AppMethodBeat.o(9465);
                        }
                    });
                    AppMethodBeat.o(9473);
                    return 0;
                } else {
                    f.this.BGu = a.s(str, f.this.msgId);
                    if (f.this.BGu == null) {
                        Log.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig attachInfo is null");
                        MMHandlerThread.postToMainThread(new Runnable() {
                            /* class com.tencent.mm.plugin.record.b.f.AnonymousClass1.AnonymousClass2 */

                            public final void run() {
                                AppMethodBeat.i(9466);
                                f.a(f.this, 3, i2, "", f.this);
                                AppMethodBeat.o(9466);
                            }
                        });
                        AppMethodBeat.o(9473);
                        return 0;
                    } else if (f.this.BGu.field_status == 102) {
                        Log.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig dancy attach download has paused, status:%d", Long.valueOf(f.this.BGu.field_status));
                        com.tencent.mm.an.f.baQ().Ob(f.this.iYT);
                        MMHandlerThread.postToMainThread(new Runnable() {
                            /* class com.tencent.mm.plugin.record.b.f.AnonymousClass1.AnonymousClass3 */

                            public final void run() {
                                AppMethodBeat.i(9467);
                                f.a(f.this, 3, i2, "attach  has paused, status=" + f.this.BGu.field_status, f.this);
                                AppMethodBeat.o(9467);
                            }
                        });
                        AppMethodBeat.o(9473);
                        return 0;
                    } else if (cVar == null) {
                        if (dVar != null) {
                            if (dVar.field_retCode != 0) {
                                a.HS(f.this.BGu.systemRowid);
                                Log.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra sceneResult.retCode :%d", Integer.valueOf(dVar.field_retCode));
                            } else {
                                new o(f.this.BGy).am(new o(f.this.BGu.field_fileFullPath));
                                f.this.BGu.field_status = 199;
                                f.this.BGu.field_offset = f.this.BGu.field_totalLen;
                                com.tencent.mm.plugin.r.a.cgO().a(f.this.BGu, new String[0]);
                                h.INSTANCE.idkeyStat(198, 45, f.this.BGu.field_totalLen, false);
                                h.INSTANCE.idkeyStat(198, 46, 1, false);
                                h hVar = h.INSTANCE;
                                if (f.this.dTX == null) {
                                    str2 = "";
                                } else {
                                    str2 = f.this.dTX.field_talker;
                                }
                                hVar.idkeyStat(198, ab.Eq(str2) ? 48 : 47, 1, false);
                                ca Hb = ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().Hb(f.this.BGu.field_msgInfoId);
                                if (Hb.field_status == 5) {
                                    Hb.setStatus(3);
                                    ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().a(Hb.field_msgId, Hb);
                                } else {
                                    ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().a(new i.c(Hb.field_talker, "update", Hb));
                                }
                            }
                            new y(com.tencent.mm.plugin.report.a.t(Integer.valueOf(dVar.field_retCode), 2, Long.valueOf(f.this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(f.this.BGu.field_totalLen), dVar.field_transInfo, "", "", "", "", "", "", "", dVar.gqk)).bfK();
                            if (dVar.field_retCode != 0) {
                                new w(com.tencent.mm.plugin.report.a.t(Integer.valueOf(dVar.field_retCode), 2, Long.valueOf(f.this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(f.this.BGu.field_totalLen), dVar.field_transInfo, "", "", "", "", "", "", "", dVar.gqk)).bfK();
                            }
                            if (f.this.iYO != null) {
                                MMHandlerThread.postToMainThread(new Runnable() {
                                    /* class com.tencent.mm.plugin.record.b.f.AnonymousClass1.AnonymousClass6 */

                                    public final void run() {
                                        AppMethodBeat.i(9470);
                                        f.this.iYO.a((int) f.this.BGu.field_offset, (int) f.this.BGu.field_totalLen, f.this);
                                        AppMethodBeat.o(9470);
                                    }
                                });
                            }
                            if (dVar.field_retCode != 0) {
                                MMHandlerThread.postToMainThread(new Runnable() {
                                    /* class com.tencent.mm.plugin.record.b.f.AnonymousClass1.AnonymousClass7 */

                                    public final void run() {
                                        AppMethodBeat.i(9471);
                                        f.a(f.this, 3, dVar.field_retCode, "", f.this);
                                        AppMethodBeat.o(9471);
                                    }
                                });
                            } else {
                                MMHandlerThread.postToMainThread(new Runnable() {
                                    /* class com.tencent.mm.plugin.record.b.f.AnonymousClass1.AnonymousClass8 */

                                    public final void run() {
                                        AppMethodBeat.i(9472);
                                        f.a(f.this, 0, 0, "", f.this);
                                        AppMethodBeat.o(9472);
                                    }
                                });
                            }
                        }
                        AppMethodBeat.o(9473);
                        return 0;
                    } else if (cVar.field_finishedLength == f.this.BGu.field_totalLen) {
                        Log.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra ignore progress 100%");
                        AppMethodBeat.o(9473);
                        return 0;
                    } else if (f.this.BGu.field_offset > cVar.field_finishedLength) {
                        Log.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdnEndProc error oldpos:%d newpos:%d", Long.valueOf(f.this.BGu.field_offset), Long.valueOf(cVar.field_finishedLength));
                        a.HS(f.this.BGu.systemRowid);
                        MMHandlerThread.postToMainThread(new Runnable() {
                            /* class com.tencent.mm.plugin.record.b.f.AnonymousClass1.AnonymousClass4 */

                            public final void run() {
                                AppMethodBeat.i(9468);
                                f.a(f.this, 3, i2, "", f.this);
                                AppMethodBeat.o(9468);
                            }
                        });
                        AppMethodBeat.o(9473);
                        return 0;
                    } else {
                        f.this.BGu.field_offset = cVar.field_finishedLength;
                        com.tencent.mm.plugin.r.a.cgO().a(f.this.BGu, new String[0]);
                        if (f.this.iYO != null) {
                            MMHandlerThread.postToMainThread(new Runnable() {
                                /* class com.tencent.mm.plugin.record.b.f.AnonymousClass1.AnonymousClass5 */

                                public final void run() {
                                    AppMethodBeat.i(9469);
                                    f.this.iYO.a((int) f.this.BGu.field_offset, (int) f.this.BGu.field_totalLen, f.this);
                                    AppMethodBeat.o(9469);
                                }
                            });
                        }
                        Log.d("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra progresscallback id:%s finish:%d total:%d", f.this.iYT, Long.valueOf(cVar.field_finishedLength), Long.valueOf(cVar.field_toltalLength));
                        AppMethodBeat.o(9473);
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
        this.BGu = cVar;
        this.BGz = true;
        this.mediaId = this.BGu.field_mediaId;
        this.iYO = null;
        this.type = 0;
        if (cVar == null) {
            Log.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig <init>, info is null, mediaId = " + this.mediaId);
            AppMethodBeat.o(9476);
            return;
        }
        d.a aVar = new d.a();
        aVar.iLN = new aht();
        aVar.iLO = new ahu();
        aVar.uri = "/cgi-bin/micromsg-bin/downloadappattach";
        aVar.funcId = TbsListener.ErrorCode.INCRUPDATE_INSTALL_SUCCESS;
        aVar.iLP = 106;
        aVar.respCmdId = 1000000106;
        this.rr = aVar.aXF();
        Log.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig NetSceneDownloadAppAttach info fullpath[%s], justSaveFile[%b], stack[%s]", cVar.field_fileFullPath, Boolean.TRUE, Util.getStack());
        AppMethodBeat.o(9476);
    }

    private f(String str, long j2, j jVar) {
        AppMethodBeat.i(9477);
        this.BGu = null;
        this.BGw = -1;
        this.mediaId = "";
        this.msgId = 0;
        this.dTX = null;
        this.iYT = "";
        this.startTime = 0;
        this.BGx = -1;
        this.BGy = "";
        this.type = 0;
        this.retCode = 0;
        this.BGz = false;
        this.BGA = false;
        this.oNJ = 0;
        this.qJf = false;
        this.BGB = false;
        this.iZc = new g.a() {
            /* class com.tencent.mm.plugin.record.b.f.AnonymousClass1 */

            @Override // com.tencent.mm.i.g.a
            public final int a(String str, final int i2, com.tencent.mm.i.c cVar, final com.tencent.mm.i.d dVar, boolean z) {
                String str2;
                AppMethodBeat.i(9473);
                Object[] objArr = new Object[5];
                objArr[0] = str;
                objArr[1] = Integer.valueOf(i2);
                objArr[2] = cVar;
                objArr[3] = dVar;
                objArr[4] = Boolean.valueOf(cVar == null);
                Log.d("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback mediaId[%s], startRet[%d], progressInfo[%s], sceneResult[%s], finish[%b]", objArr);
                if (i2 == -21006) {
                    Log.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra  ERR_CNDCOM_MEDIA_IS_DOWNLOADING clientid:%s", f.this.iYT);
                    AppMethodBeat.o(9473);
                    return 0;
                } else if (i2 != 0) {
                    a.HS(f.this.BGu.systemRowid);
                    new y(com.tencent.mm.plugin.report.a.t(Integer.valueOf(i2), 2, Long.valueOf(f.this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), 0, "")).bfK();
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.record.b.f.AnonymousClass1.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(9465);
                            f.a(f.this, 3, i2, "", f.this);
                            AppMethodBeat.o(9465);
                        }
                    });
                    AppMethodBeat.o(9473);
                    return 0;
                } else {
                    f.this.BGu = a.s(str, f.this.msgId);
                    if (f.this.BGu == null) {
                        Log.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig attachInfo is null");
                        MMHandlerThread.postToMainThread(new Runnable() {
                            /* class com.tencent.mm.plugin.record.b.f.AnonymousClass1.AnonymousClass2 */

                            public final void run() {
                                AppMethodBeat.i(9466);
                                f.a(f.this, 3, i2, "", f.this);
                                AppMethodBeat.o(9466);
                            }
                        });
                        AppMethodBeat.o(9473);
                        return 0;
                    } else if (f.this.BGu.field_status == 102) {
                        Log.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig dancy attach download has paused, status:%d", Long.valueOf(f.this.BGu.field_status));
                        com.tencent.mm.an.f.baQ().Ob(f.this.iYT);
                        MMHandlerThread.postToMainThread(new Runnable() {
                            /* class com.tencent.mm.plugin.record.b.f.AnonymousClass1.AnonymousClass3 */

                            public final void run() {
                                AppMethodBeat.i(9467);
                                f.a(f.this, 3, i2, "attach  has paused, status=" + f.this.BGu.field_status, f.this);
                                AppMethodBeat.o(9467);
                            }
                        });
                        AppMethodBeat.o(9473);
                        return 0;
                    } else if (cVar == null) {
                        if (dVar != null) {
                            if (dVar.field_retCode != 0) {
                                a.HS(f.this.BGu.systemRowid);
                                Log.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra sceneResult.retCode :%d", Integer.valueOf(dVar.field_retCode));
                            } else {
                                new o(f.this.BGy).am(new o(f.this.BGu.field_fileFullPath));
                                f.this.BGu.field_status = 199;
                                f.this.BGu.field_offset = f.this.BGu.field_totalLen;
                                com.tencent.mm.plugin.r.a.cgO().a(f.this.BGu, new String[0]);
                                h.INSTANCE.idkeyStat(198, 45, f.this.BGu.field_totalLen, false);
                                h.INSTANCE.idkeyStat(198, 46, 1, false);
                                h hVar = h.INSTANCE;
                                if (f.this.dTX == null) {
                                    str2 = "";
                                } else {
                                    str2 = f.this.dTX.field_talker;
                                }
                                hVar.idkeyStat(198, ab.Eq(str2) ? 48 : 47, 1, false);
                                ca Hb = ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().Hb(f.this.BGu.field_msgInfoId);
                                if (Hb.field_status == 5) {
                                    Hb.setStatus(3);
                                    ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().a(Hb.field_msgId, Hb);
                                } else {
                                    ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().a(new i.c(Hb.field_talker, "update", Hb));
                                }
                            }
                            new y(com.tencent.mm.plugin.report.a.t(Integer.valueOf(dVar.field_retCode), 2, Long.valueOf(f.this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(f.this.BGu.field_totalLen), dVar.field_transInfo, "", "", "", "", "", "", "", dVar.gqk)).bfK();
                            if (dVar.field_retCode != 0) {
                                new w(com.tencent.mm.plugin.report.a.t(Integer.valueOf(dVar.field_retCode), 2, Long.valueOf(f.this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(f.this.BGu.field_totalLen), dVar.field_transInfo, "", "", "", "", "", "", "", dVar.gqk)).bfK();
                            }
                            if (f.this.iYO != null) {
                                MMHandlerThread.postToMainThread(new Runnable() {
                                    /* class com.tencent.mm.plugin.record.b.f.AnonymousClass1.AnonymousClass6 */

                                    public final void run() {
                                        AppMethodBeat.i(9470);
                                        f.this.iYO.a((int) f.this.BGu.field_offset, (int) f.this.BGu.field_totalLen, f.this);
                                        AppMethodBeat.o(9470);
                                    }
                                });
                            }
                            if (dVar.field_retCode != 0) {
                                MMHandlerThread.postToMainThread(new Runnable() {
                                    /* class com.tencent.mm.plugin.record.b.f.AnonymousClass1.AnonymousClass7 */

                                    public final void run() {
                                        AppMethodBeat.i(9471);
                                        f.a(f.this, 3, dVar.field_retCode, "", f.this);
                                        AppMethodBeat.o(9471);
                                    }
                                });
                            } else {
                                MMHandlerThread.postToMainThread(new Runnable() {
                                    /* class com.tencent.mm.plugin.record.b.f.AnonymousClass1.AnonymousClass8 */

                                    public final void run() {
                                        AppMethodBeat.i(9472);
                                        f.a(f.this, 0, 0, "", f.this);
                                        AppMethodBeat.o(9472);
                                    }
                                });
                            }
                        }
                        AppMethodBeat.o(9473);
                        return 0;
                    } else if (cVar.field_finishedLength == f.this.BGu.field_totalLen) {
                        Log.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra ignore progress 100%");
                        AppMethodBeat.o(9473);
                        return 0;
                    } else if (f.this.BGu.field_offset > cVar.field_finishedLength) {
                        Log.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdnEndProc error oldpos:%d newpos:%d", Long.valueOf(f.this.BGu.field_offset), Long.valueOf(cVar.field_finishedLength));
                        a.HS(f.this.BGu.systemRowid);
                        MMHandlerThread.postToMainThread(new Runnable() {
                            /* class com.tencent.mm.plugin.record.b.f.AnonymousClass1.AnonymousClass4 */

                            public final void run() {
                                AppMethodBeat.i(9468);
                                f.a(f.this, 3, i2, "", f.this);
                                AppMethodBeat.o(9468);
                            }
                        });
                        AppMethodBeat.o(9473);
                        return 0;
                    } else {
                        f.this.BGu.field_offset = cVar.field_finishedLength;
                        com.tencent.mm.plugin.r.a.cgO().a(f.this.BGu, new String[0]);
                        if (f.this.iYO != null) {
                            MMHandlerThread.postToMainThread(new Runnable() {
                                /* class com.tencent.mm.plugin.record.b.f.AnonymousClass1.AnonymousClass5 */

                                public final void run() {
                                    AppMethodBeat.i(9469);
                                    f.this.iYO.a((int) f.this.BGu.field_offset, (int) f.this.BGu.field_totalLen, f.this);
                                    AppMethodBeat.o(9469);
                                }
                            });
                        }
                        Log.d("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra progresscallback id:%s finish:%d total:%d", f.this.iYT, Long.valueOf(cVar.field_finishedLength), Long.valueOf(cVar.field_toltalLength));
                        AppMethodBeat.o(9473);
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
        this.mediaId = str;
        this.msgId = j2;
        this.iYO = jVar;
        this.type = 0;
        this.BGu = com.tencent.mm.plugin.r.a.cgO().bdx(str);
        if (this.BGu == null) {
            this.BGu = com.tencent.mm.plugin.r.a.cgO().Mp(j2);
        }
        if (this.BGu == null) {
            Log.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig <init>, info is null, mediaId = ".concat(String.valueOf(str)));
            AppMethodBeat.o(9477);
            return;
        }
        d.a aVar = new d.a();
        aVar.iLN = new aht();
        aVar.iLO = new ahu();
        aVar.uri = "/cgi-bin/micromsg-bin/downloadappattach";
        aVar.funcId = TbsListener.ErrorCode.INCRUPDATE_INSTALL_SUCCESS;
        aVar.iLP = 106;
        aVar.respCmdId = 1000000106;
        this.rr = aVar.aXF();
        Log.d("MicroMsg.NetSceneDownloadAppAttach", "summerbig NetSceneDownloadAppAttach , type[%d], info fullpath[%s], field_type[%d], signature[%s], stack[%s]", 0, this.BGu.field_fileFullPath, Long.valueOf(this.BGu.field_type), this.BGu.field_signature, Util.getStack());
        AppMethodBeat.o(9477);
    }

    public final void eIm() {
        AppMethodBeat.i(9478);
        this.BGB = true;
        if (this.BGB) {
            String str = this.BGu.field_fileFullPath;
            byte[] bytes = "#!AMR\n".getBytes();
            s.e(str, bytes, bytes.length);
        }
        AppMethodBeat.o(9478);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(9479);
        if (!this.BGz) {
            com.tencent.mm.an.f.baQ().Oc(this.iYT);
            this.BGu = com.tencent.mm.plugin.r.a.cgO().Mp(this.msgId);
            if (this.BGu == null) {
                Log.i("MicroMsg.NetSceneDownloadAppAttach", "pause get by msgid  %是is null then get by mediaId %s", Long.valueOf(this.msgId), this.mediaId);
                this.BGu = com.tencent.mm.plugin.r.a.cgO().bdx(this.mediaId);
            }
        }
        Log.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig pause listener[%s], info[%s], justSaveFile[%b], stack[%s]", aVar, this.BGu, Boolean.valueOf(this.BGz), Util.getStack());
        if (this.BGu == null) {
            AppMethodBeat.o(9479);
            return;
        }
        if (this.BGu.field_status == 101 && aVar != null) {
            aVar.eIn();
        }
        this.BGu.field_status = 102;
        if (!this.BGz) {
            Log.i("MicroMsg.NetSceneDownloadAppAttach", "pause done %s", Boolean.valueOf(com.tencent.mm.plugin.r.a.cgO().a(this.BGu, new String[0])));
        }
        AppMethodBeat.o(9479);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, com.tencent.mm.ak.i iVar) {
        boolean z;
        int Kp;
        AppMethodBeat.i(9480);
        this.callback = iVar;
        if (this.BGu == null) {
            Log.e("MicroMsg.NetSceneDownloadAppAttach", com.tencent.mm.compatible.util.f.apq() + " get info failed mediaId:" + this.mediaId);
            this.retCode = -10000 - com.tencent.mm.compatible.util.f.getLine();
            AppMethodBeat.o(9480);
            return -1;
        }
        this.dTX = ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().Hb(this.msgId);
        if (this.dTX == null || this.dTX.field_msgId != this.msgId) {
            Log.e("MicroMsg.NetSceneDownloadAppAttach", com.tencent.mm.compatible.util.f.apq() + " get msginfo failed mediaId:%s  msgId:%d", this.mediaId, Long.valueOf(this.msgId));
            this.retCode = -10000 - com.tencent.mm.compatible.util.f.getLine();
            AppMethodBeat.o(9480);
            return -1;
        }
        if (this.startTime == 0) {
            this.startTime = Util.nowMilliSecond();
            this.BGx = (int) this.BGu.field_offset;
        }
        if (this.oNJ != 0) {
            aht aht = (aht) this.rr.iLK.iLR;
            aht.UserName = z.aTY();
            aht.BsF = (int) this.BGu.field_totalLen;
            aht.BsG = (int) this.BGu.field_offset;
            aht.BsH = 0;
            aht.oUv = 40;
            aht.Brn = this.oNJ;
            int dispatch = dispatch(gVar, this.rr, this);
            AppMethodBeat.o(9480);
            return dispatch;
        }
        String str = this.dTX.field_content;
        if (ab.Eq(this.dTX.field_talker) && (Kp = bp.Kp(this.dTX.field_content)) != -1) {
            str = (this.dTX.field_content + " ").substring(Kp + 2).trim();
        }
        k.b HD = k.b.HD(Util.processXml(str));
        if (HD == null) {
            Log.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig checkUseCdn cdntra parse content xml failed: mediaId:%s", this.mediaId);
            z = false;
        } else {
            Log.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig cdntra checkUseCdn msgid:%d total:%d fullpath:%s fileid:%s aeskey:%s ", Long.valueOf(this.msgId), Long.valueOf(this.BGu.field_totalLen), this.BGu.field_fileFullPath, HD.iwW, Util.secPrint(HD.aesKey));
            if ((!Util.isNullOrNil(HD.iwW) || !Util.isNullOrNil(HD.iwN)) && !Util.isNullOrNil(HD.aesKey)) {
                this.iYT = com.tencent.mm.an.c.a("downattach", this.BGu.field_createTime, this.dTX.field_talker, new StringBuilder().append(this.BGw).toString());
                if (Util.isNullOrNil(this.iYT)) {
                    Log.w("MicroMsg.NetSceneDownloadAppAttach", "summerbig cdntra genClientId failed not use cdn rowid:%d", Long.valueOf(this.BGw));
                    z = false;
                } else {
                    s.boN(s.boZ(this.BGu.field_fileFullPath));
                    this.BGy = this.BGu.field_fileFullPath + "_tmp";
                    g gVar2 = new g();
                    gVar2.taskName = "task_NetSceneDownloadAppAttach";
                    gVar2.field_mediaId = this.iYT;
                    gVar2.field_fullpath = this.BGy;
                    gVar2.field_fileType = (HD.iwM != 0 || HD.iwI > 26214400) ? com.tencent.mm.i.a.gpO : com.tencent.mm.i.a.MediaType_FILE;
                    gVar2.field_totalLen = (int) this.BGu.field_totalLen;
                    gVar2.field_aesKey = HD.aesKey;
                    gVar2.field_fileId = HD.iwW;
                    gVar2.field_svr_signature = this.BGu.field_signature;
                    gVar2.field_fake_bigfile_signature_aeskey = this.BGu.field_fakeAeskey;
                    gVar2.field_fake_bigfile_signature = this.BGu.field_fakeSignature;
                    gVar2.field_onlycheckexist = false;
                    gVar2.field_priority = com.tencent.mm.i.a.gpM;
                    gVar2.gqy = this.iZc;
                    gVar2.field_chattype = ab.Eq(this.dTX.field_talker) ? 1 : 0;
                    gVar2.field_use_multithread = com.tencent.mm.an.c.baL() && (HD.iwM != 0 || HD.iwI > 26214400);
                    if (!Util.isNullOrNil(HD.iwN)) {
                        gVar2.field_fileType = 19;
                        gVar2.field_authKey = HD.iwT;
                        gVar2.gqB = HD.iwN;
                        gVar2.field_fileId = "";
                    }
                    Log.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig checkUseCdn addRecvTask taskInfo field_use_multithread[%s], field_fileType[%d], fileFullPath[%s], aeskey[%s], signature[%s], faeskey[%s], fsignature[%s], onlycheckexist[%s]", Boolean.valueOf(gVar2.field_use_multithread), Integer.valueOf(gVar2.field_fileType), gVar2.field_fullpath, Util.secPrint(gVar2.field_aesKey), Util.secPrint(gVar2.field_svr_signature), Util.secPrint(gVar2.field_fake_bigfile_signature_aeskey), Util.secPrint(gVar2.field_fake_bigfile_signature), Boolean.valueOf(gVar2.field_onlycheckexist));
                    if (!com.tencent.mm.an.f.baQ().b(gVar2, -1)) {
                        Log.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig cdntra addSendTask failed.");
                        this.iYT = "";
                        z = false;
                    } else {
                        if (this.BGu.field_isUseCdn != 1) {
                            this.BGu.field_isUseCdn = 1;
                            boolean a2 = com.tencent.mm.plugin.r.a.cgO().a(this.BGu, new String[0]);
                            if (!a2) {
                                Log.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig checkUseCdn update info ret:".concat(String.valueOf(a2)));
                                this.retCode = -10000 - com.tencent.mm.compatible.util.f.getLine();
                                g(3, -1, "", this);
                                z = false;
                            }
                        }
                        z = true;
                    }
                }
            } else {
                Log.w("MicroMsg.NetSceneDownloadAppAttach", "summerbig cdntra checkUseCdn msgId:%d Not use CDN  cdnAttachUrl:%s aes:%s ", Long.valueOf(this.msgId), HD.iwW, Util.secPrint(HD.aesKey));
                z = false;
            }
        }
        if (z) {
            Log.d("MicroMsg.NetSceneDownloadAppAttach", "cdntra use cdn return -1 for onGYNetEnd mediaid:%s", this.mediaId);
            AppMethodBeat.o(9480);
            return 0;
        }
        if (this.BGu.field_status == 102) {
            this.BGu.field_status = 101;
            if (!this.BGz) {
                com.tencent.mm.plugin.r.a.cgO().a(this.BGu, new String[0]);
            }
        }
        this.BGw = this.BGu.systemRowid;
        if (Util.isNullOrNil(this.BGu.field_mediaSvrId) && this.oNJ == 0) {
            Log.e("MicroMsg.NetSceneDownloadAppAttach", "checkArgs : mediaId is null");
            this.retCode = -10000 - com.tencent.mm.compatible.util.f.getLine();
            AppMethodBeat.o(9480);
            return -1;
        } else if (this.BGu.field_totalLen <= 0 || this.BGu.field_totalLen > 26214400) {
            Log.e("MicroMsg.NetSceneDownloadAppAttach", "checkArgs : totalLen is invalid, totalLen = " + this.BGu.field_totalLen);
            this.retCode = -10000 - com.tencent.mm.compatible.util.f.getLine();
            AppMethodBeat.o(9480);
            return -1;
        } else if (!Util.isNullOrNil(this.BGu.field_fileFullPath) || this.oNJ != 0) {
            int boW = (int) s.boW(this.BGu.field_fileFullPath);
            if (this.BGB && boW - 6 <= 0) {
                boW = 0;
            }
            if (((long) boW) != this.BGu.field_offset) {
                Log.e("MicroMsg.NetSceneDownloadAppAttach", "checkArgs : fileFullPath is invalid, fileLength = " + boW + ", info.field_offset = " + this.BGu.field_offset);
                this.retCode = -10000 - com.tencent.mm.compatible.util.f.getLine();
                AppMethodBeat.o(9480);
                return -1;
            }
            Log.i("MicroMsg.NetSceneDownloadAppAttach", "downing attach by non cdn, appId: %s,  mediaId: %s, sdkVer: %d", this.BGu.field_appId, this.BGu.field_mediaSvrId, Long.valueOf(this.BGu.field_sdkVer));
            aht aht2 = (aht) this.rr.iLK.iLR;
            aht2.jfi = this.BGu.field_appId;
            aht2.jfl = this.BGu.field_mediaSvrId;
            aht2.KIy = (int) this.BGu.field_sdkVer;
            aht2.UserName = z.aTY();
            aht2.BsF = (int) this.BGu.field_totalLen;
            aht2.BsG = (int) this.BGu.field_offset;
            aht2.BsH = 0;
            if (this.oNJ != 0) {
                aht2.Brn = this.oNJ;
            }
            if (this.type != 0) {
                aht2.oUv = this.type;
            } else {
                aht2.oUv = (int) this.BGu.field_type;
            }
            int dispatch2 = dispatch(gVar, this.rr, this);
            AppMethodBeat.o(9480);
            return dispatch2;
        } else {
            Log.e("MicroMsg.NetSceneDownloadAppAttach", "checkArgs : fileFullPath is null");
            this.retCode = -10000 - com.tencent.mm.compatible.util.f.getLine();
            AppMethodBeat.o(9480);
            return -1;
        }
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, com.tencent.mm.network.s sVar, byte[] bArr) {
        AppMethodBeat.i(9481);
        Log.d("MicroMsg.NetSceneDownloadAppAttach", "onGYNetEnd : errType = " + i3 + ", errCode = " + i4);
        if (i3 == 3 && i4 == -1 && !Util.isNullOrNil(this.iYT)) {
            Log.w("MicroMsg.NetSceneDownloadAppAttach", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", this.iYT);
            AppMethodBeat.o(9481);
        } else if (i3 == 0 && i4 == 0) {
            ahu ahu = (ahu) ((d) sVar).iLL.iLR;
            this.BGu.field_totalLen = (long) ahu.BsF;
            if (ahu.jfl != null && !ahu.jfl.equals(this.BGu.field_mediaSvrId)) {
                Log.e("MicroMsg.NetSceneDownloadAppAttach", "argument is not consistent");
                this.retCode = -10000 - com.tencent.mm.compatible.util.f.getLine();
                g(3, -1, "", this);
                AppMethodBeat.o(9481);
            } else if (((long) ahu.BsG) != this.BGu.field_offset) {
                Log.e("MicroMsg.NetSceneDownloadAppAttach", "startPos, totalLen is incorrect startpos:" + ahu.BsG);
                this.retCode = -10000 - com.tencent.mm.compatible.util.f.getLine();
                g(3, -1, "", this);
                AppMethodBeat.o(9481);
            } else if (((long) ahu.BsH) + this.BGu.field_offset > this.BGu.field_totalLen) {
                Log.e("MicroMsg.NetSceneDownloadAppAttach", "data buffer is incorrect datalen:" + ahu.BsH + " off:" + this.BGu.field_offset + " total?:" + this.BGu.field_totalLen);
                this.retCode = -10000 - com.tencent.mm.compatible.util.f.getLine();
                g(3, -1, "", this);
                AppMethodBeat.o(9481);
            } else {
                byte[] a2 = com.tencent.mm.platformtools.z.a(ahu.BsI);
                if (a2 == null || a2.length == 0 || a2.length != ahu.BsH) {
                    Log.e("MicroMsg.NetSceneDownloadAppAttach", "data buffer is incorrect");
                    this.retCode = -10000 - com.tencent.mm.compatible.util.f.getLine();
                    g(3, -1, "", this);
                    AppMethodBeat.o(9481);
                } else if (a.s(this.mediaId, this.msgId) == null) {
                    Log.e("MicroMsg.NetSceneDownloadAppAttach", "append to file failed, msg maybe revoked or deleted. msgId:%d", Long.valueOf(this.BGu.field_msgInfoId));
                    this.retCode = -10000 - com.tencent.mm.compatible.util.f.getLine();
                    g(3, -1, "", this);
                    AppMethodBeat.o(9481);
                } else {
                    String str2 = new String(a2);
                    Log.d("MicroMsg.NetSceneDownloadAppAttach", "dancy download big appmsg : %s", Boolean.valueOf(this.BGA));
                    if (this.BGu.field_offset < this.BGu.field_totalLen && this.BGA) {
                        ca Hb = ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().Hb(this.BGu.field_msgInfoId);
                        if (str2.startsWith("<?xml version=")) {
                            int indexOf = str2.indexOf("<appmsg");
                            Log.i("MicroMsg.NetSceneDownloadAppAttach", "inclued: <?xml version=  index:%s", Integer.valueOf(indexOf));
                            if (indexOf > 0) {
                                str2 = str2.substring(indexOf);
                            }
                        }
                        if (!str2.startsWith("<appmsg")) {
                            if (!Hb.field_content.startsWith("<msg>")) {
                                StringBuffer stringBuffer = new StringBuffer();
                                stringBuffer.append(Hb.field_content).append(str2);
                                this.BGu.field_fullXml = stringBuffer.toString();
                            }
                            if (str2.endsWith("</appmsg>") || this.BGu.field_offset + ((long) a2.length) == this.BGu.field_totalLen) {
                                if (ab.Eq(Hb.field_talker)) {
                                    String[] split = Hb.field_content.split("\n", 2);
                                    String str3 = split[0];
                                    StringBuffer stringBuffer2 = new StringBuffer();
                                    stringBuffer2.append(str3).append("\n<msg>").append(split.length > 1 ? split[1] : "").append(str2).append("</msg>");
                                    this.BGu.field_fullXml = stringBuffer2.toString();
                                } else {
                                    StringBuffer stringBuffer3 = new StringBuffer();
                                    stringBuffer3.append("<msg>").append(this.BGu.field_fullXml).append("</msg>");
                                    this.BGu.field_fullXml = stringBuffer3.toString();
                                }
                            }
                        } else if (!ab.Eq(Hb.field_talker)) {
                            this.BGu.field_fullXml = str2;
                        } else if (!Util.isNullOrNil(Hb.field_content)) {
                            this.BGu.field_fullXml = new StringBuffer().append(Hb.field_content.split("\n", 2)[0]).append("\n").toString();
                            StringBuffer stringBuffer4 = new StringBuffer();
                            stringBuffer4.append(this.BGu.field_fullXml).append(str2);
                            this.BGu.field_fullXml = stringBuffer4.toString();
                        }
                        Hb.setContent(this.BGu.field_fullXml);
                        ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().a(this.BGu.field_msgInfoId, Hb);
                        Log.d("MicroMsg.NetSceneDownloadAppAttach", "dancy download full xml succed! xml: [%s]", str2);
                    }
                    int e2 = s.e(this.BGu.field_fileFullPath, a2, a2.length);
                    if (Util.isNullOrNil(this.BGu.field_fileFullPath) || e2 == 0) {
                        c cVar = this.BGu;
                        cVar.field_offset = ((long) a2.length) + cVar.field_offset;
                        if (this.BGu.field_offset == this.BGu.field_totalLen) {
                            this.BGu.field_status = 199;
                        }
                        if (this.iYO != null) {
                            MMHandlerThread.postToMainThread(new Runnable() {
                                /* class com.tencent.mm.plugin.record.b.f.AnonymousClass2 */

                                public final void run() {
                                    AppMethodBeat.i(9474);
                                    f.this.iYO.a((int) f.this.BGu.field_offset, (int) f.this.BGu.field_totalLen, f.this);
                                    AppMethodBeat.o(9474);
                                }
                            });
                        }
                        if (!(this.BGz ? true : com.tencent.mm.plugin.r.a.cgO().a(this.BGu, new String[0]))) {
                            Log.e("MicroMsg.NetSceneDownloadAppAttach", "onGYNetEnd update info ret:".concat(String.valueOf(e2)));
                            this.retCode = -10000 - com.tencent.mm.compatible.util.f.getLine();
                            g(3, -1, "", this);
                            AppMethodBeat.o(9481);
                        } else if (this.BGu.field_status == 199) {
                            h.INSTANCE.a(10420, 0, 2, Long.valueOf(this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(this.BGu.field_totalLen - ((long) this.BGx)));
                            ca Hb2 = ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().Hb(this.BGu.field_msgInfoId);
                            ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().a(new i.c(Hb2.field_talker, "update", Hb2));
                            g(0, 0, "", this);
                            AppMethodBeat.o(9481);
                        } else if (this.BGu.field_status == 102) {
                            g(3, -1, "", this);
                            this.retCode = -20102;
                            AppMethodBeat.o(9481);
                        } else {
                            if (doScene(dispatcher(), this.callback) < 0) {
                                Log.e("MicroMsg.NetSceneDownloadAppAttach", "onGYNetEnd : doScene fail");
                                g(3, -1, "", this);
                            }
                            AppMethodBeat.o(9481);
                        }
                    } else {
                        Log.e("MicroMsg.NetSceneDownloadAppAttach", "append to file failed:".concat(String.valueOf(e2)));
                        this.retCode = -10000 - com.tencent.mm.compatible.util.f.getLine();
                        g(3, -1, "", this);
                        AppMethodBeat.o(9481);
                    }
                }
            }
        } else {
            Log.e("MicroMsg.NetSceneDownloadAppAttach", "onGYNetEnd : errType = " + i3 + ", errCode = " + i4);
            this.retCode = -10000 - com.tencent.mm.compatible.util.f.getLine();
            if (i3 == 4) {
                h.INSTANCE.a(10420, Integer.valueOf(i4), 2, Long.valueOf(this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), 0);
            }
            g(i3, i4, str, this);
            AppMethodBeat.o(9481);
        }
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return TbsListener.ErrorCode.INCRUPDATE_INSTALL_SUCCESS;
    }

    @Override // com.tencent.mm.ak.q
    public final q.b securityVerificationChecked(com.tencent.mm.network.s sVar) {
        return q.b.EOk;
    }

    @Override // com.tencent.mm.ak.q
    public final int securityLimitCount() {
        return 400;
    }

    public final String getMediaId() {
        if (this.BGu == null) {
            return "";
        }
        return this.BGu.field_mediaSvrId;
    }

    private void g(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(9482);
        if (this.callback != null) {
            this.callback.onSceneEnd(i2, i3, str, qVar);
            if (this.BGu != null) {
                long j2 = this.BGu.field_msgInfoId;
                ca Hb = ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().Hb(j2);
                if (i2 == 0 && i3 == 0) {
                    ((b) com.tencent.mm.kernel.g.af(b.class)).a(this.qJf, String.valueOf(j2), Hb.field_msgSvrId, true);
                    AppMethodBeat.o(9482);
                    return;
                }
                ((b) com.tencent.mm.kernel.g.af(b.class)).a(this.qJf, String.valueOf(j2), Hb.field_msgSvrId, false);
            }
        }
        AppMethodBeat.o(9482);
    }
}
