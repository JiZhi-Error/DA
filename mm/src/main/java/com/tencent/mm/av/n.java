package com.tencent.mm.av;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.x;
import com.tencent.mm.ak.z;
import com.tencent.mm.an.c;
import com.tencent.mm.an.f;
import com.tencent.mm.av.o;
import com.tencent.mm.av.p;
import com.tencent.mm.g.b.a.w;
import com.tencent.mm.g.b.a.y;
import com.tencent.mm.i.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.m.a;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.br;
import com.tencent.mm.modelstat.h;
import com.tencent.mm.modelstat.r;
import com.tencent.mm.network.ag;
import com.tencent.mm.network.e;
import com.tencent.mm.network.m;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.f.d;
import com.tencent.mm.pluginsdk.f.g;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.enu;
import com.tencent.mm.protocal.protobuf.env;
import com.tencent.mm.protocal.protobuf.te;
import com.tencent.mm.protocal.protobuf.tf;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.s;
import com.tencent.wcdb.database.SQLiteException;
import g.a.a.b;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public final class n extends q implements m {
    public static boolean DEBUG = true;
    private static long iZx;
    private String TAG;
    private i callback;
    private ca dCM;
    public String dkV;
    private int gVY;
    private long hmj;
    private int hmk;
    private g hml;
    private boolean hmr;
    private int iXp;
    private long iXv;
    private final j iYO;
    public long iYP;
    private h iYS;
    private String iYT;
    private int iYW;
    private g.a iZc;
    private String iZi;
    private String iZj;
    private boolean iZk;
    private g iZl;
    private int iZm;
    public a iZn;
    private String iZo;
    public String iZp;
    public boolean iZq;
    private String iZr;
    private String iZs;
    public String iZt;
    private boolean iZu;
    private String iZv;
    private d.a iZw;
    private float latitude;
    private float longtitude;
    private final com.tencent.mm.ak.d rr;
    private int scene;
    private int startOffset;
    private long startTime;

    static /* synthetic */ com.tencent.mm.network.g F(n nVar) {
        AppMethodBeat.i(223631);
        com.tencent.mm.network.g dispatcher = nVar.dispatcher();
        AppMethodBeat.o(223631);
        return dispatcher;
    }

    static /* synthetic */ boolean a(n nVar, g gVar, int i2, long j2, int i3, com.tencent.mm.i.d dVar, String str) {
        AppMethodBeat.i(223628);
        boolean a2 = nVar.a(gVar, i2, j2, i3, dVar, str);
        AppMethodBeat.o(223628);
        return a2;
    }

    static /* synthetic */ boolean b(n nVar, g gVar) {
        AppMethodBeat.i(223630);
        boolean a2 = nVar.a(gVar, CdnLogic.kErrUploadHevcIllegal);
        AppMethodBeat.o(223630);
        return a2;
    }

    static /* synthetic */ g d(n nVar) {
        AppMethodBeat.i(150709);
        g bcB = nVar.bcB();
        AppMethodBeat.o(150709);
        return bcB;
    }

    static /* synthetic */ g e(n nVar) {
        AppMethodBeat.i(150710);
        g bcC = nVar.bcC();
        AppMethodBeat.o(150710);
        return bcC;
    }

    static /* synthetic */ com.tencent.mm.network.g v(n nVar) {
        AppMethodBeat.i(223629);
        com.tencent.mm.network.g dispatcher = nVar.dispatcher();
        AppMethodBeat.o(223629);
        return dispatcher;
    }

    private g bcB() {
        AppMethodBeat.i(150692);
        if (this.hml == null) {
            this.hml = q.bcR().c(Long.valueOf(this.hmj));
        }
        g gVar = this.hml;
        AppMethodBeat.o(150692);
        return gVar;
    }

    private g bcC() {
        AppMethodBeat.i(150693);
        if (this.iZl == null) {
            this.iZl = q.bcR().c(Long.valueOf(this.iYP));
        }
        g gVar = this.iZl;
        AppMethodBeat.o(150693);
        return gVar;
    }

    public class a {
        public com.tencent.mm.ak.n iZE;

        /* access modifiers changed from: package-private */
        public final void aYO() {
            g e2;
            AppMethodBeat.i(150691);
            if (n.this.iYP == n.this.hmj) {
                e2 = n.d(n.this);
            } else {
                e2 = n.e(n.this);
            }
            if (e2.iXz == 1) {
                com.tencent.mm.plugin.report.service.g.Wm(23);
                com.tencent.mm.plugin.report.service.g.Wm(21);
            }
            Log.i(n.this.TAG, "UploadEndWrapper onUploadEnd %s done", n.e(n.d(n.this)));
            if (q.bcR().a(Long.valueOf(n.this.hmj), n.d(n.this)) < 0) {
                Log.e(n.this.TAG, "update db failed local id:" + n.this.hmj + " server id:" + n.d(n.this).dTS);
                k.tp((int) n.this.iYP);
                k.to((int) n.this.iYP);
                n.this.callback.onSceneEnd(3, -1, "", n.this);
            }
            if (n.this.hmj != n.this.iYP) {
                Log.i(n.this.TAG, "UploadEndWrapper onUploadEnd OriImg %s done", n.e(n.e(n.this)));
                q.bcR().a(Long.valueOf(n.this.iYP), n.e(n.this));
            }
            if (CrashReportFactory.hasDebuger() || BuildInfo.IS_FLAVOR_RED || BuildInfo.IS_FLAVOR_PURPLE) {
                List<g> bcz = q.bcR().bcz();
                for (int i2 = 0; i2 < bcz.size(); i2++) {
                    Log.i(n.this.TAG, "UploadEndWrapper onUploadEnd duminfo %s %s", Integer.valueOf(i2), n.e(bcz.get(i2)));
                }
            }
            n.a(n.this, n.this.hmj);
            if (n.this.iYP != n.this.hmj) {
                n.a(n.this, n.this.iYP);
            }
            if (this.iZE != null) {
                this.iZE.aYO();
            }
            n.this.tq(n.this.iXp);
            n.this.iZn = null;
            AppMethodBeat.o(150691);
        }

        public a(com.tencent.mm.ak.n nVar) {
            this.iZE = nVar;
        }
    }

    public final ca bcD() {
        AppMethodBeat.i(223622);
        if (this.dCM == null) {
            Log.e(this.TAG, "msg is null. %s", Util.getStack());
        }
        ca caVar = this.dCM;
        AppMethodBeat.o(223622);
        return caVar;
    }

    public n(int i2, String str, String str2, String str3, int i3, j jVar) {
        this(i2, str, str2, str3, i3, jVar, 0, "", "");
    }

    public n(int i2, String str, String str2, String str3, int i3, j jVar, int i4, com.tencent.mm.ak.n nVar, int i5) {
        this(i2, str, str2, str3, i3, jVar, i4, "", "", true, i5);
        AppMethodBeat.i(223623);
        this.iZn = new a(nVar);
        AppMethodBeat.o(223623);
    }

    public n(int i2, String str, String str2, String str3, int i3, j jVar, int i4, String str4, String str5) {
        this(i2, str, str2, str3, i3, jVar, i4, str4, str5, false, -1);
    }

    public n(int i2, String str, String str2, String str3, int i3, j jVar, int i4, String str4, String str5, boolean z, int i5) {
        this(i2, str, str2, str3, i3, jVar, i4, str4, str5, z, i5, true, 0, -1000.0f, -1000.0f, -1, 0, null);
    }

    public n(int i2, String str, String str2, String str3, int i3, j jVar, int i4, String str4, String str5, boolean z, int i5, long j2, String str6) {
        this(i2, str, str2, str3, i3, jVar, i4, str4, str5, z, i5, true, 0, -1000.0f, -1000.0f, -1, j2, str6);
    }

    public n(int i2, String str, String str2, String str3, int i3, final j jVar, int i4, String str4, String str5, boolean z, int i5, boolean z2, int i6, float f2, float f3, long j2, long j3, String str6) {
        g gVar;
        int i7;
        AppMethodBeat.i(223624);
        this.TAG = "MicroMsg.NetSceneUploadMsgImg";
        this.iZi = "";
        this.iZj = "";
        this.iZk = true;
        this.iZm = 16384;
        this.iXp = 0;
        this.dCM = null;
        this.iYS = null;
        this.iYT = "";
        this.startTime = 0;
        this.startOffset = -1;
        this.gVY = 0;
        this.iZn = new a(null);
        this.iZu = false;
        this.iZw = new d.a() {
            /* class com.tencent.mm.av.n.AnonymousClass4 */

            @Override // com.tencent.mm.pluginsdk.f.d.a
            public final void a(g.a aVar) {
                String str;
                String str2;
                AppMethodBeat.i(223612);
                Log.i(n.this.TAG, "upload success, field_aesKey:%s, fileId:%s, fileLen:%s", aVar.aesKey, aVar.fileId, Long.valueOf(aVar.jPY));
                long j2 = aVar.jPY;
                long nowMilliSecond = Util.nowMilliSecond();
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(10420, 0, 1, Long.valueOf(n.this.startTime), Long.valueOf(nowMilliSecond), Integer.valueOf(c.cY(MMApplicationContext.getContext())), Integer.valueOf(n.this.gVY), Long.valueOf(j2), Long.valueOf(j2 / (nowMilliSecond - n.this.startTime)), 1);
                final com.tencent.mm.i.d dVar = new com.tencent.mm.i.d();
                dVar.field_aesKey = aVar.aesKey;
                dVar.field_fileId = aVar.fileId;
                dVar.field_filemd5 = aVar.pkL;
                final g d2 = n.d(n.this);
                String o = q.bcR().o(d2.iXm, "", "");
                String o2 = q.bcR().o(d2.iXn, "", "");
                dVar.field_thumbimgLength = (int) s.boW(q.bcR().o(d2.iXo, "", ""));
                dVar.field_midimgLength = (int) s.boW(o2);
                dVar.field_fileLength = aVar.jPY;
                f.baR();
                dVar.field_filecrc = com.tencent.mm.an.a.NW(o);
                String str3 = n.this.iZo;
                a Ov = h.Ov(str3);
                if (Ov == null || Util.isNullOrNil(Ov.appId)) {
                    str = "";
                } else {
                    str = h.c(Ov.appId, Ov.mediaTagName, Ov.messageExt, Ov.messageAction);
                }
                if (Util.isNullOrNil(str3)) {
                    str2 = (("<msg><img aeskey=\"" + dVar.field_aesKey + "\" cdnmidimgurl=\"" + dVar.field_fileId + "\" cdnbigimgurl=\"" + dVar.field_fileId + "\" ") + "cdnthumburl=\"" + dVar.field_fileId + "\" cdnthumbaeskey=\"" + dVar.field_aesKey + "\" cdnthumblength=\"" + dVar.field_thumbimgLength + "\" ") + "length=\"" + (dVar.field_midimgLength == 0 ? dVar.field_fileLength : (long) dVar.field_midimgLength) + "\" hdlength=\"" + dVar.field_fileLength + "\"/>" + str + "</msg>";
                    Log.i(n.this.TAG, "cdn callback new build cdnInfo:%s", str2);
                } else {
                    Map<String, String> parseXml = XmlParser.parseXml(str3, "msg", null);
                    if (parseXml != null) {
                        if (d2.iXp == 0) {
                            str2 = (("<msg><img aeskey=\"" + Util.nullAs(parseXml.get(".msg.img.$aeskey"), dVar.field_aesKey) + "\" cdnmidimgurl=\"" + dVar.field_fileId + "\" cdnbigimgurl=\"" + Util.nullAs(parseXml.get(".msg.img.$cdnbigimgurl"), dVar.field_fileId) + "\" ") + "cdnthumburl=\"" + Util.nullAs(parseXml.get(".msg.img.$cdnthumburl"), dVar.field_fileId) + "\" cdnthumbaeskey=\"" + Util.nullAs(parseXml.get(".msg.img.$cdnthumbaeskey"), dVar.field_aesKey) + "\" cdnthumblength=\"" + Util.nullAs(parseXml.get(".msg.img.cdnthumblength"), new StringBuilder().append(dVar.field_thumbimgLength).toString()) + "\" ") + "length=\"" + (dVar.field_midimgLength == 0 ? dVar.field_fileLength : (long) dVar.field_midimgLength) + "\" hdlength=\"" + Util.nullAs(parseXml.get(".msg.img.$hdlength"), new StringBuilder().append(dVar.field_thumbimgLength).toString()) + "\"/>" + str + "</msg>";
                        } else {
                            str2 = (("<msg><img aeskey=\"" + Util.nullAs(parseXml.get(".msg.img.$aeskey"), dVar.field_aesKey) + "\" cdnmidimgurl=\"" + Util.nullAs(parseXml.get(".msg.img.$cdnmidimgurl"), dVar.field_fileId) + "\" cdnbigimgurl=\"" + Util.nullAs(parseXml.get(".msg.img.$cdnbigimgurl"), dVar.field_fileId) + "\" ") + "cdnthumburl=\"" + Util.nullAs(parseXml.get(".msg.img.$cdnthumburl"), dVar.field_fileId) + "\" cdnthumbaeskey=\"" + Util.nullAs(parseXml.get(".msg.img.$cdnthumbaeskey"), dVar.field_aesKey) + "\" cdnthumblength=\"" + Util.nullAs(parseXml.get(".msg.img.cdnthumblength"), new StringBuilder().append(dVar.field_thumbimgLength).toString()) + "\" ") + "length=\"" + parseXml.get(".msg.img.$length") + "\" hdlength=\"" + dVar.field_fileLength + "\"/>" + str + "</msg>";
                        }
                        Log.i(n.this.TAG, "cdn callback rebuild cdnInfo:%s", str2);
                    } else {
                        str2 = str3;
                    }
                }
                n.a(n.this, d2);
                d2.Ot(str2);
                n.this.iZp = str2;
                if (n.this.iYP != n.this.hmj) {
                    n.e(n.this).Ot(str2);
                }
                c bcn = c.bcn();
                bcn.hmk = n.this.hmk;
                bcn.iWW = (enu) n.this.rr.iLK.iLR;
                bcn.iWX = d2;
                bcn.aesKey = aVar.JUg;
                bcn.hmq = dVar;
                bcn.iWY = new o.a() {
                    /* class com.tencent.mm.av.n.AnonymousClass4.AnonymousClass1 */

                    @Override // com.tencent.mm.av.o.a
                    public final void a(long j2, int i2, int i3, int i4, String str) {
                        AppMethodBeat.i(223611);
                        Log.i(n.this.TAG, "cdntra clientid:%s NetSceneUploadMsgImgForCdn ret:[%d,%d]", n.this.iYT, Integer.valueOf(i3), Integer.valueOf(i4));
                        if (i3 == 0 && i4 == 0) {
                            n.a(n.this, d2, d2.iKP, j2, i2, dVar, str);
                            AppMethodBeat.o(223611);
                            return;
                        }
                        k.tp((int) n.this.iYP);
                        k.to((int) n.this.iYP);
                        n.this.callback.onSceneEnd(i3, i4, "", n.this);
                        if (n.this.iZn != null) {
                            n.this.iZn.aYO();
                        }
                        AppMethodBeat.o(223611);
                    }
                };
                bcn.toUser = n.this.dCM.field_talker;
                bcn.bdQ().execute();
                AppMethodBeat.o(223612);
            }

            @Override // com.tencent.mm.pluginsdk.f.d.a
            public final void M(int i2, String str) {
                AppMethodBeat.i(223613);
                Log.e(n.this.TAG, "onUploadFailure, errCode:%s, uploadID:%s", Integer.valueOf(i2), str);
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(10420, 0, 1, Long.valueOf(n.this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(c.cY(MMApplicationContext.getContext())), Integer.valueOf(n.this.gVY), 0, 0, 0);
                k.tp((int) n.this.iYP);
                k.to((int) n.this.iYP);
                n.this.callback.onSceneEnd(3, i2, "", n.this);
                if (n.this.iZn != null) {
                    n.this.iZn.aYO();
                }
                AppMethodBeat.o(223613);
            }

            @Override // com.tencent.mm.pluginsdk.f.d.a
            public final void a(float f2, long j2) {
                AppMethodBeat.i(223614);
                g d2 = n.d(n.this);
                if (d2 == null || d2.localId != n.this.hmj) {
                    Log.e(n.this.TAG, "onUploadFailure, getImg fail, progress:%s, finishedLen:%s", Float.valueOf(f2), Long.valueOf(j2));
                    k.tp((int) n.this.iYP);
                    k.to((int) n.this.iYP);
                    n.this.callback.onSceneEnd(3, -5, "", n.this);
                    if (n.this.iZn != null) {
                        n.this.iZn.aYO();
                    }
                    AppMethodBeat.o(223614);
                    return;
                }
                n.a(n.this, d2, (int) j2, 0, 0, null, null);
                AppMethodBeat.o(223614);
            }
        };
        this.iZc = new g.a() {
            /* class com.tencent.mm.av.n.AnonymousClass5 */

            @Override // com.tencent.mm.i.g.a
            public final int a(String str, int i2, com.tencent.mm.i.c cVar, final com.tencent.mm.i.d dVar, boolean z) {
                int i3;
                String str2;
                String str3;
                String OI;
                AppMethodBeat.i(223618);
                Log.d(n.this.TAG, "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", n.this.iYT, Integer.valueOf(i2), cVar, dVar);
                if (i2 == -21005) {
                    Log.w(n.this.TAG, "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", n.this.iYT);
                    if (n.this.iZn != null) {
                        n.this.iZn.aYO();
                    }
                    n.this.callback.onSceneEnd(3, i2, "", n.this);
                    AppMethodBeat.o(223618);
                    return 0;
                } else if (i2 != 0) {
                    Log.e(n.this.TAG, "cdntra cdnCallback clientid:%s startRet:%d", n.this.iYT, Integer.valueOf(i2));
                    k.tp((int) n.this.iYP);
                    k.to((int) n.this.iYP);
                    if (dVar != null) {
                        Object[] objArr = new Object[16];
                        objArr[0] = Integer.valueOf(i2);
                        objArr[1] = 1;
                        objArr[2] = Long.valueOf(n.this.startTime);
                        objArr[3] = Long.valueOf(Util.nowMilliSecond());
                        objArr[4] = Integer.valueOf(c.cY(MMApplicationContext.getContext()));
                        objArr[5] = Integer.valueOf(n.this.gVY);
                        objArr[6] = Long.valueOf(dVar.field_fileLength);
                        objArr[7] = dVar.field_transInfo;
                        objArr[8] = "";
                        objArr[9] = "";
                        objArr[10] = "";
                        objArr[11] = "";
                        objArr[12] = "";
                        objArr[13] = "";
                        objArr[14] = "";
                        if (dVar == null) {
                            OI = "";
                        } else {
                            OI = n.OI(dVar.gqk);
                        }
                        objArr[15] = OI;
                        new y(com.tencent.mm.plugin.report.a.t(objArr)).bfK();
                    }
                    n.this.callback.onSceneEnd(3, i2, "", n.this);
                    if (n.this.iZn != null) {
                        n.this.iZn.aYO();
                    }
                    AppMethodBeat.o(223618);
                    return 0;
                } else {
                    final g d2 = n.d(n.this);
                    if (d2 == null || d2.localId != n.this.hmj) {
                        f.baQ().Ob(n.this.iYT);
                        Log.e(n.this.TAG, "cdntra get imginfo failed maybe delete by user imgLocalId:%d client:%s", Long.valueOf(n.this.hmj), n.this.iYT);
                        if (n.this.iZn != null) {
                            n.this.iZn.aYO();
                        }
                        AppMethodBeat.o(223618);
                        return 0;
                    } else if (cVar != null) {
                        n.a(n.this, d2, (int) cVar.field_finishedLength, 0, 0, dVar, null);
                        AppMethodBeat.o(223618);
                        return 0;
                    } else {
                        if (dVar != null) {
                            Log.i(n.this.TAG, "dkupimg sceneResult:%s", dVar);
                            if (dVar.field_retCode != 0) {
                                Log.e(n.this.TAG, "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", n.this.iYT, Integer.valueOf(dVar.field_retCode), dVar);
                                if (dVar.field_retCode == -21111) {
                                    Log.w(n.this.TAG, "summersafecdn cdntra  ERR_CDNCOM_SAFEPROTO_NOAESKEY clientid:%s, enableHitcheck:%b", n.this.iYT, Boolean.valueOf(n.this.iZk));
                                    com.tencent.mm.kernel.g.aAi();
                                    com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable() {
                                        /* class com.tencent.mm.av.n.AnonymousClass5.AnonymousClass1 */

                                        public final void run() {
                                            AppMethodBeat.i(223615);
                                            n.this.iZk = false;
                                            n.this.startTime = 0;
                                            n.this.startOffset = 0;
                                            g d2 = n.d(n.this);
                                            d2.te(0);
                                            n.this.dCM.setCreateTime(bp.Kw(n.this.dCM.field_talker));
                                            n.this.iYT = c.a("upimg", n.this.dCM.field_createTime, n.this.dCM.field_talker, n.this.dCM.field_msgId + "_" + n.this.hmj + "_" + n.this.iXp);
                                            boolean a2 = n.a(n.this, d2, 0, 0, 0, dVar, null);
                                            enu enu = (enu) n.this.rr.iLK.iLR;
                                            if (enu == null) {
                                                Log.w(n.this.TAG, "summersafecdn ERR_CDNCOM_SAFEPROTO_NOAESKEY doScene again but old req is null");
                                            } else {
                                                enu.NlB = new dqi().bhy(n.this.iYT);
                                            }
                                            Log.i(n.this.TAG, "summersafecdn ERR_CDNCOM_SAFEPROTO_NOAESKEY doScene again enableHitcheck[%b], ret[%b] new clientid[%s] createtime[%d]", Boolean.valueOf(n.this.iZk), Boolean.valueOf(a2), n.this.iYT, Long.valueOf(n.this.dCM.field_createTime));
                                            n.this.doScene(n.v(n.this), n.this.callback);
                                            AppMethodBeat.o(223615);
                                        }
                                    });
                                    AppMethodBeat.o(223618);
                                    return 0;
                                }
                                if (dVar.field_retCode == -5103237) {
                                    Log.w(n.this.TAG, "upload hevc failed try jpg, %s", Boolean.valueOf(n.this.iZu));
                                    if (n.this.iZu) {
                                        com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable() {
                                            /* class com.tencent.mm.av.n.AnonymousClass5.AnonymousClass2 */

                                            public final void run() {
                                                AppMethodBeat.i(223616);
                                                n.b(n.this, n.d(n.this));
                                                AppMethodBeat.o(223616);
                                            }
                                        });
                                        AppMethodBeat.o(223618);
                                        return 0;
                                    }
                                }
                                env env = null;
                                if (!Util.isNullOrNil(dVar.field_sKeyrespbuf)) {
                                    env = new env();
                                    try {
                                        env.parseFrom(dVar.field_sKeyrespbuf);
                                        Log.d(n.this.TAG, "parse skeyrespbuf: ret:%d,msg:%s", Integer.valueOf(env.BaseResponse.Ret), env.BaseResponse.ErrMsg.toString());
                                    } catch (IOException e2) {
                                        env = null;
                                        Log.e(n.this.TAG, "UploadMsgImgResponse parse fail: %s", e2);
                                        Log.e(n.this.TAG, "exception:%s", Util.stackTraceToString(e2));
                                    } catch (b e3) {
                                        env = null;
                                        Log.e(n.this.TAG, "UploadMsgImgResponse parse UninitializedMessageException: %s", e3);
                                        Log.e(n.this.TAG, "exception:%s", Util.stackTraceToString(e3));
                                    }
                                }
                                k.tp((int) n.this.iYP);
                                k.to((int) n.this.iYP);
                                Object[] objArr2 = new Object[16];
                                objArr2[0] = Integer.valueOf(dVar.field_retCode);
                                objArr2[1] = 1;
                                objArr2[2] = Long.valueOf(n.this.startTime);
                                objArr2[3] = Long.valueOf(Util.nowMilliSecond());
                                objArr2[4] = Integer.valueOf(c.cY(MMApplicationContext.getContext()));
                                objArr2[5] = Integer.valueOf(n.this.gVY);
                                objArr2[6] = Long.valueOf(dVar.field_fileLength);
                                objArr2[7] = dVar.field_transInfo;
                                objArr2[8] = "";
                                objArr2[9] = "";
                                objArr2[10] = "";
                                objArr2[11] = "";
                                objArr2[12] = "";
                                objArr2[13] = "";
                                objArr2[14] = "";
                                objArr2[15] = dVar == null ? "" : n.OI(dVar.gqk);
                                String t = com.tencent.mm.plugin.report.a.t(objArr2);
                                new y(t).bfK();
                                new w(t).bfK();
                                if (env == null || env.BaseResponse.Ret == 0) {
                                    n.this.callback.onSceneEnd(3, dVar.field_retCode, "", n.this);
                                } else {
                                    n.this.callback.onSceneEnd(4, env.BaseResponse.Ret, env.BaseResponse.ErrMsg.toString(), n.this);
                                }
                                if (n.this.iZn != null) {
                                    n.this.iZn.aYO();
                                }
                            } else {
                                Log.i(n.this.TAG, "summersafecdn uploadMsgImg by cdn, UploadHitCacheType: %d, needSendMsg:%b", Integer.valueOf(dVar.field_UploadHitCacheType), Boolean.valueOf(dVar.field_needSendMsgField));
                                com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
                                Object[] objArr3 = new Object[3];
                                if (d2.source == 0) {
                                    i3 = 3;
                                } else {
                                    i3 = d2.source;
                                }
                                objArr3[0] = Integer.valueOf(i3);
                                objArr3[1] = n.this.iZi;
                                objArr3[2] = Integer.valueOf(dVar.field_UploadHitCacheType);
                                hVar.a(13230, objArr3);
                                String str4 = n.this.iZo;
                                a Ov = h.Ov(str4);
                                if (Ov == null || Util.isNullOrNil(Ov.appId)) {
                                    str2 = "";
                                } else {
                                    str2 = h.c(Ov.appId, Ov.mediaTagName, Ov.messageExt, Ov.messageAction);
                                }
                                if (Util.isNullOrNil(str4)) {
                                    str3 = (("<msg><img aeskey=\"" + dVar.field_aesKey + "\" cdnmidimgurl=\"" + dVar.field_fileId + "\" cdnbigimgurl=\"" + dVar.field_fileId + "\" ") + "cdnthumburl=\"" + dVar.field_fileId + "\" cdnthumbaeskey=\"" + dVar.field_aesKey + "\" cdnthumblength=\"" + dVar.field_thumbimgLength + "\" ") + "length=\"" + (dVar.field_midimgLength == 0 ? dVar.field_fileLength : (long) dVar.field_midimgLength) + "\" hdlength=\"" + dVar.field_fileLength + "\"/>" + str2 + "</msg>";
                                    Log.i(n.this.TAG, "cdn callback new build cdnInfo:%s", str3);
                                } else {
                                    Map<String, String> parseXml = XmlParser.parseXml(str4, "msg", null);
                                    if (parseXml != null) {
                                        if (d2.iXp == 0) {
                                            str3 = (("<msg><img aeskey=\"" + Util.nullAs(parseXml.get(".msg.img.$aeskey"), dVar.field_aesKey) + "\" cdnmidimgurl=\"" + dVar.field_fileId + "\" cdnbigimgurl=\"" + Util.nullAs(parseXml.get(".msg.img.$cdnbigimgurl"), dVar.field_fileId) + "\" ") + "cdnthumburl=\"" + Util.nullAs(parseXml.get(".msg.img.$cdnthumburl"), dVar.field_fileId) + "\" cdnthumbaeskey=\"" + Util.nullAs(parseXml.get(".msg.img.$cdnthumbaeskey"), dVar.field_aesKey) + "\" cdnthumblength=\"" + Util.nullAs(parseXml.get(".msg.img.cdnthumblength"), new StringBuilder().append(dVar.field_thumbimgLength).toString()) + "\" ") + "length=\"" + (dVar.field_midimgLength == 0 ? dVar.field_fileLength : (long) dVar.field_midimgLength) + "\" hdlength=\"" + Util.nullAs(parseXml.get(".msg.img.$hdlength"), new StringBuilder().append(dVar.field_thumbimgLength).toString()) + "\"/>" + str2 + "</msg>";
                                        } else {
                                            str3 = (("<msg><img aeskey=\"" + Util.nullAs(parseXml.get(".msg.img.$aeskey"), dVar.field_aesKey) + "\" cdnmidimgurl=\"" + Util.nullAs(parseXml.get(".msg.img.$cdnmidimgurl"), dVar.field_fileId) + "\" cdnbigimgurl=\"" + Util.nullAs(parseXml.get(".msg.img.$cdnbigimgurl"), dVar.field_fileId) + "\" ") + "cdnthumburl=\"" + Util.nullAs(parseXml.get(".msg.img.$cdnthumburl"), dVar.field_fileId) + "\" cdnthumbaeskey=\"" + Util.nullAs(parseXml.get(".msg.img.$cdnthumbaeskey"), dVar.field_aesKey) + "\" cdnthumblength=\"" + Util.nullAs(parseXml.get(".msg.img.cdnthumblength"), new StringBuilder().append(dVar.field_thumbimgLength).toString()) + "\" ") + "length=\"" + parseXml.get(".msg.img.$length") + "\" hdlength=\"" + dVar.field_fileLength + "\"/>" + str2 + "</msg>";
                                        }
                                        Log.i(n.this.TAG, "cdn callback rebuild cdnInfo:%s", str3);
                                    } else {
                                        str3 = str4;
                                    }
                                }
                                if (dVar.alL()) {
                                    if (Util.isNullOrNil(n.this.iZs)) {
                                        Log.w(n.this.TAG, "summersafecdn sceneResult isUploadBySafeCDNWithMD5 but prepareResponse AESKey is null");
                                    } else {
                                        str3 = (("<msg><img aeskey=\"" + n.this.iZs + "\" cdnmidimgurl=\"" + dVar.field_fileId + "\" cdnbigimgurl=\"" + dVar.field_fileId + "\" ") + "cdnthumburl=\"" + dVar.field_fileId + "\" cdnthumbaeskey=\"" + n.this.iZs + "\" ") + "length=\"" + dVar.field_midimgLength + "\" hdlength=\"" + dVar.field_fileLength + "\"/>" + str2 + "</msg>";
                                    }
                                }
                                n.a(n.this, d2);
                                d2.Ot(str3);
                                n.this.iZp = str3;
                                if (n.this.iYP != n.this.hmj) {
                                    n.e(n.this).Ot(str3);
                                }
                                if (dVar.field_needSendMsgField) {
                                    c bcn = c.bcn();
                                    bcn.hmk = n.this.hmk;
                                    bcn.iWW = (enu) n.this.rr.iLK.iLR;
                                    bcn.iWX = d2;
                                    bcn.aesKey = n.this.iZj;
                                    bcn.hmq = dVar;
                                    bcn.iWY = new o.a() {
                                        /* class com.tencent.mm.av.n.AnonymousClass5.AnonymousClass3 */

                                        @Override // com.tencent.mm.av.o.a
                                        public final void a(long j2, int i2, int i3, int i4, String str) {
                                            AppMethodBeat.i(223617);
                                            new y(com.tencent.mm.plugin.report.a.t(Integer.valueOf(i4), 1, Long.valueOf(n.this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(c.cY(MMApplicationContext.getContext())), Integer.valueOf(n.this.gVY), Long.valueOf(dVar.field_fileLength), dVar.field_transInfo, "", "", "", "", "", "", "", n.OI(dVar.gqk))).bfK();
                                            Log.i(n.this.TAG, "cdntra clientid:%s NetSceneUploadMsgImgForCdn ret:[%d,%d]", n.this.iYT, Integer.valueOf(i3), Integer.valueOf(i4));
                                            if (i3 == 0 && i4 == 0) {
                                                n.a(n.this, d2, d2.iKP, j2, i2, dVar, str);
                                                AppMethodBeat.o(223617);
                                                return;
                                            }
                                            k.tp((int) n.this.iYP);
                                            k.to((int) n.this.iYP);
                                            n.this.callback.onSceneEnd(i3, i4, "", n.this);
                                            if (n.this.iZn != null) {
                                                n.this.iZn.aYO();
                                            }
                                            AppMethodBeat.o(223617);
                                        }
                                    };
                                    bcn.toUser = n.this.dCM.field_talker;
                                    bcn.bdQ().execute();
                                } else {
                                    new y(com.tencent.mm.plugin.report.a.t(0, 1, Long.valueOf(n.this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(c.cY(MMApplicationContext.getContext())), Integer.valueOf(n.this.gVY), Long.valueOf(dVar.field_fileLength), dVar.field_transInfo, "", "", "", "", "", "", "", n.OI(dVar.gqk))).bfK();
                                    env env2 = new env();
                                    try {
                                        env2.parseFrom(dVar.field_sKeyrespbuf);
                                        long j2 = env2.Brn != 0 ? env2.Brn : (long) env2.Brl;
                                        Log.d(n.this.TAG, "parse skeyrespbuf: ret:%d,msg:%s", Integer.valueOf(env2.BaseResponse.Ret), env2.BaseResponse.ErrMsg.toString());
                                        if (n.a(n.this, d2, d2.iKP, j2, env2.CreateTime, dVar, env2.KHq)) {
                                            n.this.callback.onSceneEnd(0, 0, "", n.this);
                                            if (n.this.iZn != null) {
                                                n.this.iZn.aYO();
                                            }
                                        }
                                        AppMethodBeat.o(223618);
                                        return 0;
                                    } catch (IOException e4) {
                                        Log.e(n.this.TAG, "UploadMsgImgResponse parse fail: %s", e4);
                                        Log.e(n.this.TAG, "exception:%s", Util.stackTraceToString(e4));
                                        n.this.callback.onSceneEnd(3, dVar.field_retCode, "", n.this);
                                        if (n.this.iZn != null) {
                                            n.this.iZn.aYO();
                                        }
                                    }
                                }
                            }
                        }
                        AppMethodBeat.o(223618);
                        return 0;
                    }
                }
            }

            @Override // com.tencent.mm.i.g.a
            public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
                AppMethodBeat.i(223619);
                enu enu = (enu) n.this.rr.iLK.iLR;
                te teVar = new te();
                teVar.Lby = enu.NlB.MTo;
                teVar.xNH = enu.KHl.MTo;
                teVar.xNG = enu.KHm.MTo;
                teVar.Lbz = enu.NlI;
                teVar.LbA = enu.NlJ;
                teVar.Scene = n.this.scene;
                teVar.LbC = n.this.longtitude;
                teVar.LbD = n.this.latitude;
                teVar.LbE = n.this.iZr;
                teVar.KHq = enu.KHq;
                teVar.LbJ = n.this.iZj;
                teVar.jfi = enu.jfi;
                teVar.KEq = enu.KEq;
                teVar.KEs = enu.KEs;
                teVar.KEr = enu.KEr;
                teVar.LbN = enu.LbN;
                g d2 = n.d(n.this);
                String o = q.bcR().o(d2.iXm, "", "");
                f.baR();
                teVar.LbL = com.tencent.mm.an.a.NW(o);
                teVar.LbM = d2.iXq;
                if (teVar.LbM <= 0) {
                    teVar.LbM = n.this.hmk == 4 ? 2 : 1;
                }
                switch (n.this.hmk) {
                    case 1:
                    case 2:
                        teVar.xub = 1;
                        break;
                    case 3:
                    case 5:
                    default:
                        teVar.xub = 2;
                        break;
                    case 4:
                        teVar.xub = 3;
                        break;
                    case 6:
                        teVar.xub = 5;
                        break;
                }
                if (teVar.LbM == 3) {
                    teVar.xub = 4;
                }
                Log.i(n.this.TAG, "getCdnAuthInfo: mediaid:%s thumbwidth:%d, thumbheight:%d,MsgSource:%s,touser:%s aeskey[%s], imgLocalId[%d], msgLocalId[%d], getBigImgPath()[%s], fullpath[%s], prereq.CRC32[%d] prereq.MsgForwardType[%d], prereq.Source[%d]", str, Integer.valueOf(teVar.Lbz), Integer.valueOf(teVar.LbA), teVar.KHq, teVar.xNG, teVar.LbJ, Long.valueOf(n.this.hmj), Long.valueOf(n.this.iXv), d2.iXm, o, Integer.valueOf(teVar.LbL), Integer.valueOf(teVar.LbM), Integer.valueOf(teVar.xub));
                d.a aVar = new d.a();
                aVar.iLN = teVar;
                aVar.iLO = new env();
                aVar.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
                aVar.funcId = 625;
                aVar.iLP = 9;
                aVar.respCmdId = 1000000009;
                com.tencent.mm.ak.d aXF = aVar.aXF();
                e aZh = n.F(n.this).aZh();
                String str2 = n.this.TAG;
                Object[] objArr = new Object[1];
                objArr[0] = aZh == null ? "acc == null" : Boolean.valueOf(aZh.aZb());
                Log.i(str2, "getCdnAuthInfo login:%s", objArr);
                if (aZh == null || !aZh.aZb()) {
                    Log.e(n.this.TAG, "getCdnAuthInfo accinfo return null. clientimgid:%s", teVar.Lby);
                    AppMethodBeat.o(223619);
                } else if (x.a(aZh.qe(1), aZh.aZa(), aZh.aZc(), aXF.getReqObj(), byteArrayOutputStream, aZh.isForeground())) {
                    Log.d(n.this.TAG, "getCdnAuthInfo successed.clientimgid:%s", teVar.Lby);
                    AppMethodBeat.o(223619);
                } else {
                    Log.e(n.this.TAG, "getCdnAuthInfo failed. clientimgid:%s", teVar.Lby);
                    AppMethodBeat.o(223619);
                }
            }

            @Override // com.tencent.mm.i.g.a
            public final byte[] f(String str, byte[] bArr) {
                AppMethodBeat.i(223620);
                PInt pInt = new PInt();
                tf tfVar = new tf();
                try {
                    byte[] a2 = z.a(bArr, com.tencent.mm.kernel.g.aAg().hqi.iMw.aZh().qe(1), pInt, tfVar);
                    Log.i(n.this.TAG, "decodePrepareResponse aeskey[%s], fileid[%s], clientimgid[%s]", tfVar.LbJ, tfVar.KMl, tfVar.Lby);
                    n.this.iZs = tfVar.LbJ;
                    ((com.tencent.mm.plugin.messenger.foundation.a.s) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).setEnSendMsgActionFlag(tfVar.LbO);
                    Log.i(n.this.TAG, "prepareResponse.ActionFlag:%s", Integer.valueOf(tfVar.LbO));
                    Log.i(n.this.TAG, "decodePrepareResponse, clientmediaid:%s, ret:%d", str, Integer.valueOf(pInt.value));
                    AppMethodBeat.o(223620);
                    return a2;
                } catch (Exception e2) {
                    Log.e(n.this.TAG, "decodePrepareResponse Exception:%s", e2);
                    n.this.iZs = null;
                    AppMethodBeat.o(223620);
                    return null;
                }
            }
        };
        this.hmr = false;
        Log.i(this.TAG, "dkupimg init uploadsrc:%d from:%s to:%s ori:%s cmptype:%d prog:%s rotate:%d cdn:%s thumb:%s chatt:%b , res:%d run:%b [%s], scene: %d, longtitude: %f, latitude: %f", Integer.valueOf(i2), str, str2, str3, Integer.valueOf(i3), jVar, Integer.valueOf(i4), str4, str5, Boolean.valueOf(z), Integer.valueOf(i5), Boolean.valueOf(z2), Util.getStack(), Integer.valueOf(i6), Float.valueOf(f2), Float.valueOf(f3));
        this.iZq = z;
        this.iYW = i5;
        this.iYO = jVar;
        this.iXp = i3;
        this.scene = i6;
        this.latitude = f3;
        this.longtitude = f2;
        this.hmk = i2;
        this.iZt = str3;
        PString pString = new PString();
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        this.iZo = str4;
        pString.value = str5;
        String str7 = j2 > 0 ? q.bcR().o(q.bcR().c(Long.valueOf(j2)).iXr, "", "") : null;
        if (j3 > 0) {
            this.iZv = br.KB(((l) com.tencent.mm.kernel.g.af(l.class)).eiy().Hb(j3).fqK);
        } else if (!Util.isNullOrNil(str6)) {
            this.iZv = str6;
        }
        try {
            this.iYP = q.bcR().a(str2, str3, str7, i3, i2, i4, pString, pInt, pInt2);
        } catch (SQLiteException e2) {
            com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(111, 182, 1, false);
            if (e2.toString().contains("UNIQUE constraint failed")) {
                q.bcR().bcy();
                Log.e(this.TAG, "fallback to insert");
                this.iYP = q.bcR().a(str2, str3, str7, i3, i2, i4, pString, pInt, pInt2);
            } else {
                AppMethodBeat.o(223624);
                throw e2;
            }
        }
        this.hmj = this.iYP;
        Log.i(this.TAG, "FROM A UI :" + str2 + " " + this.iYP);
        if (!z2 || (this.iYP >= 0 && k.tn((int) this.iYP))) {
            Assert.assertTrue(this.iYP >= 0);
            d.a aVar = new d.a();
            aVar.iLN = new enu();
            aVar.iLO = new env();
            aVar.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
            aVar.funcId = 110;
            aVar.iLP = 9;
            aVar.respCmdId = 1000000009;
            this.rr = aVar.aXF();
            this.dkV = str2;
            this.dCM = new ca();
            this.dCM.setType(ab.JH(str2));
            this.dCM.Cy(str2);
            this.dCM.nv(1);
            this.dCM.setStatus(1);
            this.dCM.Cz(pString.value);
            this.dCM.nG(pInt.value);
            this.dCM.nH(pInt2.value);
            this.dCM.setCreateTime(bp.Kw(this.dCM.field_talker));
            this.dCM.setContent(str4);
            a.C0409a.anC().n(this.dCM);
            try {
                this.iXv = ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().c(this.dCM, true);
            } catch (SQLiteException e3) {
                com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(111, 182, 1, false);
                if (e3.toString().contains("UNIQUE constraint failed")) {
                    Log.e(this.TAG, "fallback to insert");
                    ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().eiI();
                    this.iXv = ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().c(this.dCM, true);
                } else {
                    AppMethodBeat.o(223624);
                    throw e3;
                }
            }
            Assert.assertTrue(this.iXv >= 0);
            Log.i(this.TAG, "NetSceneUploadMsgImg: local msgId = " + this.iXv);
            g bcC = bcC();
            bcC.Aw((long) ((int) this.iXv));
            q.bcR().a(Long.valueOf(this.iYP), bcC);
            if (i3 == 1) {
                this.hmj = (long) bcC.iXx;
                gVar = bcB();
            } else {
                gVar = bcC;
            }
            gVar.tf((int) s.boW(q.bcR().o(gVar.iXm, "", "")));
            q.bcR().a(Long.valueOf(this.hmj), gVar);
            Log.i(this.TAG, "NetSceneUploadMsgImg: local imgId = " + this.hmj + " img len = " + gVar.iKP);
            enu enu = (enu) this.rr.iLK.iLR;
            enu.KHl = new dqi().bhy(str);
            enu.KHm = new dqi().bhy(str2);
            enu.BsG = gVar.offset;
            enu.BsF = gVar.iKP;
            enu.xKb = this.dCM.getType();
            enu.LYt = i3;
            if (ag.dm(MMApplicationContext.getContext())) {
                i7 = 1;
            } else {
                i7 = 2;
            }
            enu.Llx = i7;
            enu.NaY = gVar.source;
            enu.LbM = gVar.iXq;
            enu.NlI = pInt2.value;
            enu.NlJ = pInt.value;
            a Ov = h.Ov(str4);
            if (Ov != null && !Util.isNullOrNil(Ov.appId)) {
                enu.jfi = Ov.appId;
                enu.KEq = Ov.mediaTagName;
                enu.KEs = Ov.messageAction;
                enu.KEr = Ov.messageExt;
            }
            if (((com.tencent.mm.plugin.messenger.foundation.a.s) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).ifAddTicketByActionFlag(str2)) {
                enu.LbN = ((l) com.tencent.mm.kernel.g.af(l.class)).aSN().bjT(str2);
            }
            Log.i(this.TAG, "LINE237 thumb.width:%d,thumb.height:%d", Integer.valueOf(enu.NlI), Integer.valueOf(enu.NlJ));
            if (enu.LbM == 0) {
                enu.LbM = i2 == 4 ? 2 : 1;
            }
            Log.d(this.TAG, "dkimgsource: %d, forwardtype:%d", Integer.valueOf(gVar.source), Integer.valueOf(enu.LbM));
            if (gVar.offset == 0) {
                this.iYS = new h(getType(), true, (long) gVar.iKP);
            }
            long currentTimeMillis = System.currentTimeMillis();
            tq(i3);
            Log.d(this.TAG, "hy: create HDThumb using %d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            if (jVar != null) {
                final int i8 = gVar.offset;
                final int i9 = gVar.iKP;
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.av.n.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(150681);
                        jVar.a(i8, i9, n.this);
                        AppMethodBeat.o(150681);
                    }
                });
            }
            AppMethodBeat.o(223624);
            return;
        }
        Log.e(this.TAG, "insert to img storage failed id:" + this.iYP);
        this.iXv = -1;
        this.rr = null;
        AppMethodBeat.o(223624);
    }

    public n(long j2, int i2, String str, String str2, String str3, int i3, final j jVar, int i4, String str4, String str5, boolean z, int i5, boolean z2) {
        g gVar;
        String str6;
        int i6;
        AppMethodBeat.i(223625);
        this.TAG = "MicroMsg.NetSceneUploadMsgImg";
        this.iZi = "";
        this.iZj = "";
        this.iZk = true;
        this.iZm = 16384;
        this.iXp = 0;
        this.dCM = null;
        this.iYS = null;
        this.iYT = "";
        this.startTime = 0;
        this.startOffset = -1;
        this.gVY = 0;
        this.iZn = new a(null);
        this.iZu = false;
        this.iZw = new d.a() {
            /* class com.tencent.mm.av.n.AnonymousClass4 */

            @Override // com.tencent.mm.pluginsdk.f.d.a
            public final void a(g.a aVar) {
                String str;
                String str2;
                AppMethodBeat.i(223612);
                Log.i(n.this.TAG, "upload success, field_aesKey:%s, fileId:%s, fileLen:%s", aVar.aesKey, aVar.fileId, Long.valueOf(aVar.jPY));
                long j2 = aVar.jPY;
                long nowMilliSecond = Util.nowMilliSecond();
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(10420, 0, 1, Long.valueOf(n.this.startTime), Long.valueOf(nowMilliSecond), Integer.valueOf(c.cY(MMApplicationContext.getContext())), Integer.valueOf(n.this.gVY), Long.valueOf(j2), Long.valueOf(j2 / (nowMilliSecond - n.this.startTime)), 1);
                final com.tencent.mm.i.d dVar = new com.tencent.mm.i.d();
                dVar.field_aesKey = aVar.aesKey;
                dVar.field_fileId = aVar.fileId;
                dVar.field_filemd5 = aVar.pkL;
                final g d2 = n.d(n.this);
                String o = q.bcR().o(d2.iXm, "", "");
                String o2 = q.bcR().o(d2.iXn, "", "");
                dVar.field_thumbimgLength = (int) s.boW(q.bcR().o(d2.iXo, "", ""));
                dVar.field_midimgLength = (int) s.boW(o2);
                dVar.field_fileLength = aVar.jPY;
                f.baR();
                dVar.field_filecrc = com.tencent.mm.an.a.NW(o);
                String str3 = n.this.iZo;
                a Ov = h.Ov(str3);
                if (Ov == null || Util.isNullOrNil(Ov.appId)) {
                    str = "";
                } else {
                    str = h.c(Ov.appId, Ov.mediaTagName, Ov.messageExt, Ov.messageAction);
                }
                if (Util.isNullOrNil(str3)) {
                    str2 = (("<msg><img aeskey=\"" + dVar.field_aesKey + "\" cdnmidimgurl=\"" + dVar.field_fileId + "\" cdnbigimgurl=\"" + dVar.field_fileId + "\" ") + "cdnthumburl=\"" + dVar.field_fileId + "\" cdnthumbaeskey=\"" + dVar.field_aesKey + "\" cdnthumblength=\"" + dVar.field_thumbimgLength + "\" ") + "length=\"" + (dVar.field_midimgLength == 0 ? dVar.field_fileLength : (long) dVar.field_midimgLength) + "\" hdlength=\"" + dVar.field_fileLength + "\"/>" + str + "</msg>";
                    Log.i(n.this.TAG, "cdn callback new build cdnInfo:%s", str2);
                } else {
                    Map<String, String> parseXml = XmlParser.parseXml(str3, "msg", null);
                    if (parseXml != null) {
                        if (d2.iXp == 0) {
                            str2 = (("<msg><img aeskey=\"" + Util.nullAs(parseXml.get(".msg.img.$aeskey"), dVar.field_aesKey) + "\" cdnmidimgurl=\"" + dVar.field_fileId + "\" cdnbigimgurl=\"" + Util.nullAs(parseXml.get(".msg.img.$cdnbigimgurl"), dVar.field_fileId) + "\" ") + "cdnthumburl=\"" + Util.nullAs(parseXml.get(".msg.img.$cdnthumburl"), dVar.field_fileId) + "\" cdnthumbaeskey=\"" + Util.nullAs(parseXml.get(".msg.img.$cdnthumbaeskey"), dVar.field_aesKey) + "\" cdnthumblength=\"" + Util.nullAs(parseXml.get(".msg.img.cdnthumblength"), new StringBuilder().append(dVar.field_thumbimgLength).toString()) + "\" ") + "length=\"" + (dVar.field_midimgLength == 0 ? dVar.field_fileLength : (long) dVar.field_midimgLength) + "\" hdlength=\"" + Util.nullAs(parseXml.get(".msg.img.$hdlength"), new StringBuilder().append(dVar.field_thumbimgLength).toString()) + "\"/>" + str + "</msg>";
                        } else {
                            str2 = (("<msg><img aeskey=\"" + Util.nullAs(parseXml.get(".msg.img.$aeskey"), dVar.field_aesKey) + "\" cdnmidimgurl=\"" + Util.nullAs(parseXml.get(".msg.img.$cdnmidimgurl"), dVar.field_fileId) + "\" cdnbigimgurl=\"" + Util.nullAs(parseXml.get(".msg.img.$cdnbigimgurl"), dVar.field_fileId) + "\" ") + "cdnthumburl=\"" + Util.nullAs(parseXml.get(".msg.img.$cdnthumburl"), dVar.field_fileId) + "\" cdnthumbaeskey=\"" + Util.nullAs(parseXml.get(".msg.img.$cdnthumbaeskey"), dVar.field_aesKey) + "\" cdnthumblength=\"" + Util.nullAs(parseXml.get(".msg.img.cdnthumblength"), new StringBuilder().append(dVar.field_thumbimgLength).toString()) + "\" ") + "length=\"" + parseXml.get(".msg.img.$length") + "\" hdlength=\"" + dVar.field_fileLength + "\"/>" + str + "</msg>";
                        }
                        Log.i(n.this.TAG, "cdn callback rebuild cdnInfo:%s", str2);
                    } else {
                        str2 = str3;
                    }
                }
                n.a(n.this, d2);
                d2.Ot(str2);
                n.this.iZp = str2;
                if (n.this.iYP != n.this.hmj) {
                    n.e(n.this).Ot(str2);
                }
                c bcn = c.bcn();
                bcn.hmk = n.this.hmk;
                bcn.iWW = (enu) n.this.rr.iLK.iLR;
                bcn.iWX = d2;
                bcn.aesKey = aVar.JUg;
                bcn.hmq = dVar;
                bcn.iWY = new o.a() {
                    /* class com.tencent.mm.av.n.AnonymousClass4.AnonymousClass1 */

                    @Override // com.tencent.mm.av.o.a
                    public final void a(long j2, int i2, int i3, int i4, String str) {
                        AppMethodBeat.i(223611);
                        Log.i(n.this.TAG, "cdntra clientid:%s NetSceneUploadMsgImgForCdn ret:[%d,%d]", n.this.iYT, Integer.valueOf(i3), Integer.valueOf(i4));
                        if (i3 == 0 && i4 == 0) {
                            n.a(n.this, d2, d2.iKP, j2, i2, dVar, str);
                            AppMethodBeat.o(223611);
                            return;
                        }
                        k.tp((int) n.this.iYP);
                        k.to((int) n.this.iYP);
                        n.this.callback.onSceneEnd(i3, i4, "", n.this);
                        if (n.this.iZn != null) {
                            n.this.iZn.aYO();
                        }
                        AppMethodBeat.o(223611);
                    }
                };
                bcn.toUser = n.this.dCM.field_talker;
                bcn.bdQ().execute();
                AppMethodBeat.o(223612);
            }

            @Override // com.tencent.mm.pluginsdk.f.d.a
            public final void M(int i2, String str) {
                AppMethodBeat.i(223613);
                Log.e(n.this.TAG, "onUploadFailure, errCode:%s, uploadID:%s", Integer.valueOf(i2), str);
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(10420, 0, 1, Long.valueOf(n.this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(c.cY(MMApplicationContext.getContext())), Integer.valueOf(n.this.gVY), 0, 0, 0);
                k.tp((int) n.this.iYP);
                k.to((int) n.this.iYP);
                n.this.callback.onSceneEnd(3, i2, "", n.this);
                if (n.this.iZn != null) {
                    n.this.iZn.aYO();
                }
                AppMethodBeat.o(223613);
            }

            @Override // com.tencent.mm.pluginsdk.f.d.a
            public final void a(float f2, long j2) {
                AppMethodBeat.i(223614);
                g d2 = n.d(n.this);
                if (d2 == null || d2.localId != n.this.hmj) {
                    Log.e(n.this.TAG, "onUploadFailure, getImg fail, progress:%s, finishedLen:%s", Float.valueOf(f2), Long.valueOf(j2));
                    k.tp((int) n.this.iYP);
                    k.to((int) n.this.iYP);
                    n.this.callback.onSceneEnd(3, -5, "", n.this);
                    if (n.this.iZn != null) {
                        n.this.iZn.aYO();
                    }
                    AppMethodBeat.o(223614);
                    return;
                }
                n.a(n.this, d2, (int) j2, 0, 0, null, null);
                AppMethodBeat.o(223614);
            }
        };
        this.iZc = new g.a() {
            /* class com.tencent.mm.av.n.AnonymousClass5 */

            @Override // com.tencent.mm.i.g.a
            public final int a(String str, int i2, com.tencent.mm.i.c cVar, final com.tencent.mm.i.d dVar, boolean z) {
                int i3;
                String str2;
                String str3;
                String OI;
                AppMethodBeat.i(223618);
                Log.d(n.this.TAG, "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", n.this.iYT, Integer.valueOf(i2), cVar, dVar);
                if (i2 == -21005) {
                    Log.w(n.this.TAG, "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", n.this.iYT);
                    if (n.this.iZn != null) {
                        n.this.iZn.aYO();
                    }
                    n.this.callback.onSceneEnd(3, i2, "", n.this);
                    AppMethodBeat.o(223618);
                    return 0;
                } else if (i2 != 0) {
                    Log.e(n.this.TAG, "cdntra cdnCallback clientid:%s startRet:%d", n.this.iYT, Integer.valueOf(i2));
                    k.tp((int) n.this.iYP);
                    k.to((int) n.this.iYP);
                    if (dVar != null) {
                        Object[] objArr = new Object[16];
                        objArr[0] = Integer.valueOf(i2);
                        objArr[1] = 1;
                        objArr[2] = Long.valueOf(n.this.startTime);
                        objArr[3] = Long.valueOf(Util.nowMilliSecond());
                        objArr[4] = Integer.valueOf(c.cY(MMApplicationContext.getContext()));
                        objArr[5] = Integer.valueOf(n.this.gVY);
                        objArr[6] = Long.valueOf(dVar.field_fileLength);
                        objArr[7] = dVar.field_transInfo;
                        objArr[8] = "";
                        objArr[9] = "";
                        objArr[10] = "";
                        objArr[11] = "";
                        objArr[12] = "";
                        objArr[13] = "";
                        objArr[14] = "";
                        if (dVar == null) {
                            OI = "";
                        } else {
                            OI = n.OI(dVar.gqk);
                        }
                        objArr[15] = OI;
                        new y(com.tencent.mm.plugin.report.a.t(objArr)).bfK();
                    }
                    n.this.callback.onSceneEnd(3, i2, "", n.this);
                    if (n.this.iZn != null) {
                        n.this.iZn.aYO();
                    }
                    AppMethodBeat.o(223618);
                    return 0;
                } else {
                    final g d2 = n.d(n.this);
                    if (d2 == null || d2.localId != n.this.hmj) {
                        f.baQ().Ob(n.this.iYT);
                        Log.e(n.this.TAG, "cdntra get imginfo failed maybe delete by user imgLocalId:%d client:%s", Long.valueOf(n.this.hmj), n.this.iYT);
                        if (n.this.iZn != null) {
                            n.this.iZn.aYO();
                        }
                        AppMethodBeat.o(223618);
                        return 0;
                    } else if (cVar != null) {
                        n.a(n.this, d2, (int) cVar.field_finishedLength, 0, 0, dVar, null);
                        AppMethodBeat.o(223618);
                        return 0;
                    } else {
                        if (dVar != null) {
                            Log.i(n.this.TAG, "dkupimg sceneResult:%s", dVar);
                            if (dVar.field_retCode != 0) {
                                Log.e(n.this.TAG, "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", n.this.iYT, Integer.valueOf(dVar.field_retCode), dVar);
                                if (dVar.field_retCode == -21111) {
                                    Log.w(n.this.TAG, "summersafecdn cdntra  ERR_CDNCOM_SAFEPROTO_NOAESKEY clientid:%s, enableHitcheck:%b", n.this.iYT, Boolean.valueOf(n.this.iZk));
                                    com.tencent.mm.kernel.g.aAi();
                                    com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable() {
                                        /* class com.tencent.mm.av.n.AnonymousClass5.AnonymousClass1 */

                                        public final void run() {
                                            AppMethodBeat.i(223615);
                                            n.this.iZk = false;
                                            n.this.startTime = 0;
                                            n.this.startOffset = 0;
                                            g d2 = n.d(n.this);
                                            d2.te(0);
                                            n.this.dCM.setCreateTime(bp.Kw(n.this.dCM.field_talker));
                                            n.this.iYT = c.a("upimg", n.this.dCM.field_createTime, n.this.dCM.field_talker, n.this.dCM.field_msgId + "_" + n.this.hmj + "_" + n.this.iXp);
                                            boolean a2 = n.a(n.this, d2, 0, 0, 0, dVar, null);
                                            enu enu = (enu) n.this.rr.iLK.iLR;
                                            if (enu == null) {
                                                Log.w(n.this.TAG, "summersafecdn ERR_CDNCOM_SAFEPROTO_NOAESKEY doScene again but old req is null");
                                            } else {
                                                enu.NlB = new dqi().bhy(n.this.iYT);
                                            }
                                            Log.i(n.this.TAG, "summersafecdn ERR_CDNCOM_SAFEPROTO_NOAESKEY doScene again enableHitcheck[%b], ret[%b] new clientid[%s] createtime[%d]", Boolean.valueOf(n.this.iZk), Boolean.valueOf(a2), n.this.iYT, Long.valueOf(n.this.dCM.field_createTime));
                                            n.this.doScene(n.v(n.this), n.this.callback);
                                            AppMethodBeat.o(223615);
                                        }
                                    });
                                    AppMethodBeat.o(223618);
                                    return 0;
                                }
                                if (dVar.field_retCode == -5103237) {
                                    Log.w(n.this.TAG, "upload hevc failed try jpg, %s", Boolean.valueOf(n.this.iZu));
                                    if (n.this.iZu) {
                                        com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable() {
                                            /* class com.tencent.mm.av.n.AnonymousClass5.AnonymousClass2 */

                                            public final void run() {
                                                AppMethodBeat.i(223616);
                                                n.b(n.this, n.d(n.this));
                                                AppMethodBeat.o(223616);
                                            }
                                        });
                                        AppMethodBeat.o(223618);
                                        return 0;
                                    }
                                }
                                env env = null;
                                if (!Util.isNullOrNil(dVar.field_sKeyrespbuf)) {
                                    env = new env();
                                    try {
                                        env.parseFrom(dVar.field_sKeyrespbuf);
                                        Log.d(n.this.TAG, "parse skeyrespbuf: ret:%d,msg:%s", Integer.valueOf(env.BaseResponse.Ret), env.BaseResponse.ErrMsg.toString());
                                    } catch (IOException e2) {
                                        env = null;
                                        Log.e(n.this.TAG, "UploadMsgImgResponse parse fail: %s", e2);
                                        Log.e(n.this.TAG, "exception:%s", Util.stackTraceToString(e2));
                                    } catch (b e3) {
                                        env = null;
                                        Log.e(n.this.TAG, "UploadMsgImgResponse parse UninitializedMessageException: %s", e3);
                                        Log.e(n.this.TAG, "exception:%s", Util.stackTraceToString(e3));
                                    }
                                }
                                k.tp((int) n.this.iYP);
                                k.to((int) n.this.iYP);
                                Object[] objArr2 = new Object[16];
                                objArr2[0] = Integer.valueOf(dVar.field_retCode);
                                objArr2[1] = 1;
                                objArr2[2] = Long.valueOf(n.this.startTime);
                                objArr2[3] = Long.valueOf(Util.nowMilliSecond());
                                objArr2[4] = Integer.valueOf(c.cY(MMApplicationContext.getContext()));
                                objArr2[5] = Integer.valueOf(n.this.gVY);
                                objArr2[6] = Long.valueOf(dVar.field_fileLength);
                                objArr2[7] = dVar.field_transInfo;
                                objArr2[8] = "";
                                objArr2[9] = "";
                                objArr2[10] = "";
                                objArr2[11] = "";
                                objArr2[12] = "";
                                objArr2[13] = "";
                                objArr2[14] = "";
                                objArr2[15] = dVar == null ? "" : n.OI(dVar.gqk);
                                String t = com.tencent.mm.plugin.report.a.t(objArr2);
                                new y(t).bfK();
                                new w(t).bfK();
                                if (env == null || env.BaseResponse.Ret == 0) {
                                    n.this.callback.onSceneEnd(3, dVar.field_retCode, "", n.this);
                                } else {
                                    n.this.callback.onSceneEnd(4, env.BaseResponse.Ret, env.BaseResponse.ErrMsg.toString(), n.this);
                                }
                                if (n.this.iZn != null) {
                                    n.this.iZn.aYO();
                                }
                            } else {
                                Log.i(n.this.TAG, "summersafecdn uploadMsgImg by cdn, UploadHitCacheType: %d, needSendMsg:%b", Integer.valueOf(dVar.field_UploadHitCacheType), Boolean.valueOf(dVar.field_needSendMsgField));
                                com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
                                Object[] objArr3 = new Object[3];
                                if (d2.source == 0) {
                                    i3 = 3;
                                } else {
                                    i3 = d2.source;
                                }
                                objArr3[0] = Integer.valueOf(i3);
                                objArr3[1] = n.this.iZi;
                                objArr3[2] = Integer.valueOf(dVar.field_UploadHitCacheType);
                                hVar.a(13230, objArr3);
                                String str4 = n.this.iZo;
                                a Ov = h.Ov(str4);
                                if (Ov == null || Util.isNullOrNil(Ov.appId)) {
                                    str2 = "";
                                } else {
                                    str2 = h.c(Ov.appId, Ov.mediaTagName, Ov.messageExt, Ov.messageAction);
                                }
                                if (Util.isNullOrNil(str4)) {
                                    str3 = (("<msg><img aeskey=\"" + dVar.field_aesKey + "\" cdnmidimgurl=\"" + dVar.field_fileId + "\" cdnbigimgurl=\"" + dVar.field_fileId + "\" ") + "cdnthumburl=\"" + dVar.field_fileId + "\" cdnthumbaeskey=\"" + dVar.field_aesKey + "\" cdnthumblength=\"" + dVar.field_thumbimgLength + "\" ") + "length=\"" + (dVar.field_midimgLength == 0 ? dVar.field_fileLength : (long) dVar.field_midimgLength) + "\" hdlength=\"" + dVar.field_fileLength + "\"/>" + str2 + "</msg>";
                                    Log.i(n.this.TAG, "cdn callback new build cdnInfo:%s", str3);
                                } else {
                                    Map<String, String> parseXml = XmlParser.parseXml(str4, "msg", null);
                                    if (parseXml != null) {
                                        if (d2.iXp == 0) {
                                            str3 = (("<msg><img aeskey=\"" + Util.nullAs(parseXml.get(".msg.img.$aeskey"), dVar.field_aesKey) + "\" cdnmidimgurl=\"" + dVar.field_fileId + "\" cdnbigimgurl=\"" + Util.nullAs(parseXml.get(".msg.img.$cdnbigimgurl"), dVar.field_fileId) + "\" ") + "cdnthumburl=\"" + Util.nullAs(parseXml.get(".msg.img.$cdnthumburl"), dVar.field_fileId) + "\" cdnthumbaeskey=\"" + Util.nullAs(parseXml.get(".msg.img.$cdnthumbaeskey"), dVar.field_aesKey) + "\" cdnthumblength=\"" + Util.nullAs(parseXml.get(".msg.img.cdnthumblength"), new StringBuilder().append(dVar.field_thumbimgLength).toString()) + "\" ") + "length=\"" + (dVar.field_midimgLength == 0 ? dVar.field_fileLength : (long) dVar.field_midimgLength) + "\" hdlength=\"" + Util.nullAs(parseXml.get(".msg.img.$hdlength"), new StringBuilder().append(dVar.field_thumbimgLength).toString()) + "\"/>" + str2 + "</msg>";
                                        } else {
                                            str3 = (("<msg><img aeskey=\"" + Util.nullAs(parseXml.get(".msg.img.$aeskey"), dVar.field_aesKey) + "\" cdnmidimgurl=\"" + Util.nullAs(parseXml.get(".msg.img.$cdnmidimgurl"), dVar.field_fileId) + "\" cdnbigimgurl=\"" + Util.nullAs(parseXml.get(".msg.img.$cdnbigimgurl"), dVar.field_fileId) + "\" ") + "cdnthumburl=\"" + Util.nullAs(parseXml.get(".msg.img.$cdnthumburl"), dVar.field_fileId) + "\" cdnthumbaeskey=\"" + Util.nullAs(parseXml.get(".msg.img.$cdnthumbaeskey"), dVar.field_aesKey) + "\" cdnthumblength=\"" + Util.nullAs(parseXml.get(".msg.img.cdnthumblength"), new StringBuilder().append(dVar.field_thumbimgLength).toString()) + "\" ") + "length=\"" + parseXml.get(".msg.img.$length") + "\" hdlength=\"" + dVar.field_fileLength + "\"/>" + str2 + "</msg>";
                                        }
                                        Log.i(n.this.TAG, "cdn callback rebuild cdnInfo:%s", str3);
                                    } else {
                                        str3 = str4;
                                    }
                                }
                                if (dVar.alL()) {
                                    if (Util.isNullOrNil(n.this.iZs)) {
                                        Log.w(n.this.TAG, "summersafecdn sceneResult isUploadBySafeCDNWithMD5 but prepareResponse AESKey is null");
                                    } else {
                                        str3 = (("<msg><img aeskey=\"" + n.this.iZs + "\" cdnmidimgurl=\"" + dVar.field_fileId + "\" cdnbigimgurl=\"" + dVar.field_fileId + "\" ") + "cdnthumburl=\"" + dVar.field_fileId + "\" cdnthumbaeskey=\"" + n.this.iZs + "\" ") + "length=\"" + dVar.field_midimgLength + "\" hdlength=\"" + dVar.field_fileLength + "\"/>" + str2 + "</msg>";
                                    }
                                }
                                n.a(n.this, d2);
                                d2.Ot(str3);
                                n.this.iZp = str3;
                                if (n.this.iYP != n.this.hmj) {
                                    n.e(n.this).Ot(str3);
                                }
                                if (dVar.field_needSendMsgField) {
                                    c bcn = c.bcn();
                                    bcn.hmk = n.this.hmk;
                                    bcn.iWW = (enu) n.this.rr.iLK.iLR;
                                    bcn.iWX = d2;
                                    bcn.aesKey = n.this.iZj;
                                    bcn.hmq = dVar;
                                    bcn.iWY = new o.a() {
                                        /* class com.tencent.mm.av.n.AnonymousClass5.AnonymousClass3 */

                                        @Override // com.tencent.mm.av.o.a
                                        public final void a(long j2, int i2, int i3, int i4, String str) {
                                            AppMethodBeat.i(223617);
                                            new y(com.tencent.mm.plugin.report.a.t(Integer.valueOf(i4), 1, Long.valueOf(n.this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(c.cY(MMApplicationContext.getContext())), Integer.valueOf(n.this.gVY), Long.valueOf(dVar.field_fileLength), dVar.field_transInfo, "", "", "", "", "", "", "", n.OI(dVar.gqk))).bfK();
                                            Log.i(n.this.TAG, "cdntra clientid:%s NetSceneUploadMsgImgForCdn ret:[%d,%d]", n.this.iYT, Integer.valueOf(i3), Integer.valueOf(i4));
                                            if (i3 == 0 && i4 == 0) {
                                                n.a(n.this, d2, d2.iKP, j2, i2, dVar, str);
                                                AppMethodBeat.o(223617);
                                                return;
                                            }
                                            k.tp((int) n.this.iYP);
                                            k.to((int) n.this.iYP);
                                            n.this.callback.onSceneEnd(i3, i4, "", n.this);
                                            if (n.this.iZn != null) {
                                                n.this.iZn.aYO();
                                            }
                                            AppMethodBeat.o(223617);
                                        }
                                    };
                                    bcn.toUser = n.this.dCM.field_talker;
                                    bcn.bdQ().execute();
                                } else {
                                    new y(com.tencent.mm.plugin.report.a.t(0, 1, Long.valueOf(n.this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(c.cY(MMApplicationContext.getContext())), Integer.valueOf(n.this.gVY), Long.valueOf(dVar.field_fileLength), dVar.field_transInfo, "", "", "", "", "", "", "", n.OI(dVar.gqk))).bfK();
                                    env env2 = new env();
                                    try {
                                        env2.parseFrom(dVar.field_sKeyrespbuf);
                                        long j2 = env2.Brn != 0 ? env2.Brn : (long) env2.Brl;
                                        Log.d(n.this.TAG, "parse skeyrespbuf: ret:%d,msg:%s", Integer.valueOf(env2.BaseResponse.Ret), env2.BaseResponse.ErrMsg.toString());
                                        if (n.a(n.this, d2, d2.iKP, j2, env2.CreateTime, dVar, env2.KHq)) {
                                            n.this.callback.onSceneEnd(0, 0, "", n.this);
                                            if (n.this.iZn != null) {
                                                n.this.iZn.aYO();
                                            }
                                        }
                                        AppMethodBeat.o(223618);
                                        return 0;
                                    } catch (IOException e4) {
                                        Log.e(n.this.TAG, "UploadMsgImgResponse parse fail: %s", e4);
                                        Log.e(n.this.TAG, "exception:%s", Util.stackTraceToString(e4));
                                        n.this.callback.onSceneEnd(3, dVar.field_retCode, "", n.this);
                                        if (n.this.iZn != null) {
                                            n.this.iZn.aYO();
                                        }
                                    }
                                }
                            }
                        }
                        AppMethodBeat.o(223618);
                        return 0;
                    }
                }
            }

            @Override // com.tencent.mm.i.g.a
            public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
                AppMethodBeat.i(223619);
                enu enu = (enu) n.this.rr.iLK.iLR;
                te teVar = new te();
                teVar.Lby = enu.NlB.MTo;
                teVar.xNH = enu.KHl.MTo;
                teVar.xNG = enu.KHm.MTo;
                teVar.Lbz = enu.NlI;
                teVar.LbA = enu.NlJ;
                teVar.Scene = n.this.scene;
                teVar.LbC = n.this.longtitude;
                teVar.LbD = n.this.latitude;
                teVar.LbE = n.this.iZr;
                teVar.KHq = enu.KHq;
                teVar.LbJ = n.this.iZj;
                teVar.jfi = enu.jfi;
                teVar.KEq = enu.KEq;
                teVar.KEs = enu.KEs;
                teVar.KEr = enu.KEr;
                teVar.LbN = enu.LbN;
                g d2 = n.d(n.this);
                String o = q.bcR().o(d2.iXm, "", "");
                f.baR();
                teVar.LbL = com.tencent.mm.an.a.NW(o);
                teVar.LbM = d2.iXq;
                if (teVar.LbM <= 0) {
                    teVar.LbM = n.this.hmk == 4 ? 2 : 1;
                }
                switch (n.this.hmk) {
                    case 1:
                    case 2:
                        teVar.xub = 1;
                        break;
                    case 3:
                    case 5:
                    default:
                        teVar.xub = 2;
                        break;
                    case 4:
                        teVar.xub = 3;
                        break;
                    case 6:
                        teVar.xub = 5;
                        break;
                }
                if (teVar.LbM == 3) {
                    teVar.xub = 4;
                }
                Log.i(n.this.TAG, "getCdnAuthInfo: mediaid:%s thumbwidth:%d, thumbheight:%d,MsgSource:%s,touser:%s aeskey[%s], imgLocalId[%d], msgLocalId[%d], getBigImgPath()[%s], fullpath[%s], prereq.CRC32[%d] prereq.MsgForwardType[%d], prereq.Source[%d]", str, Integer.valueOf(teVar.Lbz), Integer.valueOf(teVar.LbA), teVar.KHq, teVar.xNG, teVar.LbJ, Long.valueOf(n.this.hmj), Long.valueOf(n.this.iXv), d2.iXm, o, Integer.valueOf(teVar.LbL), Integer.valueOf(teVar.LbM), Integer.valueOf(teVar.xub));
                d.a aVar = new d.a();
                aVar.iLN = teVar;
                aVar.iLO = new env();
                aVar.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
                aVar.funcId = 625;
                aVar.iLP = 9;
                aVar.respCmdId = 1000000009;
                com.tencent.mm.ak.d aXF = aVar.aXF();
                e aZh = n.F(n.this).aZh();
                String str2 = n.this.TAG;
                Object[] objArr = new Object[1];
                objArr[0] = aZh == null ? "acc == null" : Boolean.valueOf(aZh.aZb());
                Log.i(str2, "getCdnAuthInfo login:%s", objArr);
                if (aZh == null || !aZh.aZb()) {
                    Log.e(n.this.TAG, "getCdnAuthInfo accinfo return null. clientimgid:%s", teVar.Lby);
                    AppMethodBeat.o(223619);
                } else if (x.a(aZh.qe(1), aZh.aZa(), aZh.aZc(), aXF.getReqObj(), byteArrayOutputStream, aZh.isForeground())) {
                    Log.d(n.this.TAG, "getCdnAuthInfo successed.clientimgid:%s", teVar.Lby);
                    AppMethodBeat.o(223619);
                } else {
                    Log.e(n.this.TAG, "getCdnAuthInfo failed. clientimgid:%s", teVar.Lby);
                    AppMethodBeat.o(223619);
                }
            }

            @Override // com.tencent.mm.i.g.a
            public final byte[] f(String str, byte[] bArr) {
                AppMethodBeat.i(223620);
                PInt pInt = new PInt();
                tf tfVar = new tf();
                try {
                    byte[] a2 = z.a(bArr, com.tencent.mm.kernel.g.aAg().hqi.iMw.aZh().qe(1), pInt, tfVar);
                    Log.i(n.this.TAG, "decodePrepareResponse aeskey[%s], fileid[%s], clientimgid[%s]", tfVar.LbJ, tfVar.KMl, tfVar.Lby);
                    n.this.iZs = tfVar.LbJ;
                    ((com.tencent.mm.plugin.messenger.foundation.a.s) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).setEnSendMsgActionFlag(tfVar.LbO);
                    Log.i(n.this.TAG, "prepareResponse.ActionFlag:%s", Integer.valueOf(tfVar.LbO));
                    Log.i(n.this.TAG, "decodePrepareResponse, clientmediaid:%s, ret:%d", str, Integer.valueOf(pInt.value));
                    AppMethodBeat.o(223620);
                    return a2;
                } catch (Exception e2) {
                    Log.e(n.this.TAG, "decodePrepareResponse Exception:%s", e2);
                    n.this.iZs = null;
                    AppMethodBeat.o(223620);
                    return null;
                }
            }
        };
        this.hmr = false;
        Log.i(this.TAG, "dkupimg init id:%d uploadsrc:%d from:%s to:%s ori:%s cmptype:%d prog:%s rotate:%d cdn:%s thumb:%s chatt:%b , res:%d run:%b [%s]", Long.valueOf(j2), Integer.valueOf(i2), str, str2, str3, Integer.valueOf(i3), jVar, Integer.valueOf(i4), str4, str5, Boolean.valueOf(z), Integer.valueOf(i5), Boolean.valueOf(z2), Util.getStack());
        this.iZq = z;
        this.iYW = i5;
        this.iYO = jVar;
        this.iXp = i3;
        this.hmk = i2;
        this.iZt = str3;
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        this.iZo = str4;
        this.iYP = j2;
        this.hmj = this.iYP;
        g bcC = bcC();
        this.dCM = ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().Hb(bcC.iXv);
        this.iXv = this.dCM.field_msgId;
        pInt2.value = this.dCM.fQT;
        pInt.value = this.dCM.fQS;
        if (i3 == 1) {
            this.hmj = (long) bcC.iXx;
            this.hml = null;
            gVar = bcB();
        } else {
            gVar = bcC;
        }
        if (this.dCM.field_talker == null || this.dCM.field_talker.equals(str2)) {
            str6 = str2;
        } else {
            Log.e(this.TAG, "fatal!! Send user mis-match, want:%s, fact:%s", str2, this.dCM.field_talker);
            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(594, 4, 1, true);
            str6 = this.dCM.field_talker;
        }
        Log.i(this.TAG, "NetSceneUploadMsgImg: local msgId = " + this.dCM.field_msgId);
        Log.d(this.TAG, "FROM A UI :" + str2 + "   msg:" + str6 + this.iYP);
        if (!z2 || (this.iYP >= 0 && k.tn((int) this.iYP))) {
            Assert.assertTrue(this.iYP >= 0);
            d.a aVar = new d.a();
            aVar.iLN = new enu();
            aVar.iLO = new env();
            aVar.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
            aVar.funcId = 110;
            aVar.iLP = 9;
            aVar.respCmdId = 1000000009;
            this.rr = aVar.aXF();
            Log.i(this.TAG, "NetSceneUploadMsgImg: local imgId = " + this.hmj + " img len = " + gVar.iKP);
            enu enu = (enu) this.rr.iLK.iLR;
            enu.KHl = new dqi().bhy(str);
            enu.KHm = new dqi().bhy(str6);
            enu.BsG = gVar.offset;
            enu.BsF = gVar.iKP;
            enu.xKb = this.dCM.getType();
            enu.LYt = i3;
            if (ag.dm(MMApplicationContext.getContext())) {
                i6 = 1;
            } else {
                i6 = 2;
            }
            enu.Llx = i6;
            enu.NaY = gVar.source;
            enu.LbM = gVar.iXq;
            enu.NlI = pInt2.value;
            enu.NlJ = pInt.value;
            Log.i(this.TAG, "LINE350 thumb.width:%d,thumb.height:%d", Integer.valueOf(enu.NlI), Integer.valueOf(enu.NlJ));
            if (enu.LbM == 0) {
                enu.LbM = i2 == 4 ? 2 : 1;
            }
            if (((com.tencent.mm.plugin.messenger.foundation.a.s) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).ifAddTicketByActionFlag(str6)) {
                enu.LbN = ((l) com.tencent.mm.kernel.g.af(l.class)).aSN().bjT(str6);
            }
            Log.d(this.TAG, "dkimgsource: %d, forwardtype:%d", Integer.valueOf(gVar.source), Integer.valueOf(enu.LbM));
            if (gVar.offset == 0) {
                this.iYS = new h(getType(), true, (long) gVar.iKP);
            }
            if (jVar != null) {
                final int i7 = gVar.offset;
                final int i8 = gVar.iKP;
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.av.n.AnonymousClass3 */

                    public final void run() {
                        AppMethodBeat.i(150682);
                        jVar.a(i7, i8, n.this);
                        AppMethodBeat.o(150682);
                    }
                });
            }
            AppMethodBeat.o(223625);
            return;
        }
        Log.e(this.TAG, "insert to img storage failed id:" + this.iYP);
        this.iXv = -1;
        this.rr = null;
        AppMethodBeat.o(223625);
    }

    public final void tq(int i2) {
        int i3 = 1;
        AppMethodBeat.i(150697);
        if (this.dCM == null) {
            Log.w(this.TAG, "createHDThumb but msg is null msgLocalId[%d], compressType[%d]", Long.valueOf(this.iXv), Integer.valueOf(i2));
            AppMethodBeat.o(150697);
            return;
        }
        if (!this.iZq) {
            q.bcR().c(this.dCM.field_imgPath, com.tencent.mm.cb.a.getDensity(MMApplicationContext.getContext()));
        } else if (this.dCM.fQW == 0) {
            boolean a2 = q.bcR().a(this.dCM, this.iYW, i2);
            ca caVar = this.dCM;
            if (!a2) {
                i3 = 0;
            }
            caVar.nJ(i3);
            ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().a(this.iXv, this.dCM);
            AppMethodBeat.o(150697);
            return;
        }
        AppMethodBeat.o(150697);
    }

    public n(int i2, int i3) {
        g gVar;
        int i4;
        AppMethodBeat.i(150698);
        this.TAG = "MicroMsg.NetSceneUploadMsgImg";
        this.iZi = "";
        this.iZj = "";
        this.iZk = true;
        this.iZm = 16384;
        this.iXp = 0;
        this.dCM = null;
        this.iYS = null;
        this.iYT = "";
        this.startTime = 0;
        this.startOffset = -1;
        this.gVY = 0;
        this.iZn = new a(null);
        this.iZu = false;
        this.iZw = new d.a() {
            /* class com.tencent.mm.av.n.AnonymousClass4 */

            @Override // com.tencent.mm.pluginsdk.f.d.a
            public final void a(g.a aVar) {
                String str;
                String str2;
                AppMethodBeat.i(223612);
                Log.i(n.this.TAG, "upload success, field_aesKey:%s, fileId:%s, fileLen:%s", aVar.aesKey, aVar.fileId, Long.valueOf(aVar.jPY));
                long j2 = aVar.jPY;
                long nowMilliSecond = Util.nowMilliSecond();
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(10420, 0, 1, Long.valueOf(n.this.startTime), Long.valueOf(nowMilliSecond), Integer.valueOf(c.cY(MMApplicationContext.getContext())), Integer.valueOf(n.this.gVY), Long.valueOf(j2), Long.valueOf(j2 / (nowMilliSecond - n.this.startTime)), 1);
                final com.tencent.mm.i.d dVar = new com.tencent.mm.i.d();
                dVar.field_aesKey = aVar.aesKey;
                dVar.field_fileId = aVar.fileId;
                dVar.field_filemd5 = aVar.pkL;
                final g d2 = n.d(n.this);
                String o = q.bcR().o(d2.iXm, "", "");
                String o2 = q.bcR().o(d2.iXn, "", "");
                dVar.field_thumbimgLength = (int) s.boW(q.bcR().o(d2.iXo, "", ""));
                dVar.field_midimgLength = (int) s.boW(o2);
                dVar.field_fileLength = aVar.jPY;
                f.baR();
                dVar.field_filecrc = com.tencent.mm.an.a.NW(o);
                String str3 = n.this.iZo;
                a Ov = h.Ov(str3);
                if (Ov == null || Util.isNullOrNil(Ov.appId)) {
                    str = "";
                } else {
                    str = h.c(Ov.appId, Ov.mediaTagName, Ov.messageExt, Ov.messageAction);
                }
                if (Util.isNullOrNil(str3)) {
                    str2 = (("<msg><img aeskey=\"" + dVar.field_aesKey + "\" cdnmidimgurl=\"" + dVar.field_fileId + "\" cdnbigimgurl=\"" + dVar.field_fileId + "\" ") + "cdnthumburl=\"" + dVar.field_fileId + "\" cdnthumbaeskey=\"" + dVar.field_aesKey + "\" cdnthumblength=\"" + dVar.field_thumbimgLength + "\" ") + "length=\"" + (dVar.field_midimgLength == 0 ? dVar.field_fileLength : (long) dVar.field_midimgLength) + "\" hdlength=\"" + dVar.field_fileLength + "\"/>" + str + "</msg>";
                    Log.i(n.this.TAG, "cdn callback new build cdnInfo:%s", str2);
                } else {
                    Map<String, String> parseXml = XmlParser.parseXml(str3, "msg", null);
                    if (parseXml != null) {
                        if (d2.iXp == 0) {
                            str2 = (("<msg><img aeskey=\"" + Util.nullAs(parseXml.get(".msg.img.$aeskey"), dVar.field_aesKey) + "\" cdnmidimgurl=\"" + dVar.field_fileId + "\" cdnbigimgurl=\"" + Util.nullAs(parseXml.get(".msg.img.$cdnbigimgurl"), dVar.field_fileId) + "\" ") + "cdnthumburl=\"" + Util.nullAs(parseXml.get(".msg.img.$cdnthumburl"), dVar.field_fileId) + "\" cdnthumbaeskey=\"" + Util.nullAs(parseXml.get(".msg.img.$cdnthumbaeskey"), dVar.field_aesKey) + "\" cdnthumblength=\"" + Util.nullAs(parseXml.get(".msg.img.cdnthumblength"), new StringBuilder().append(dVar.field_thumbimgLength).toString()) + "\" ") + "length=\"" + (dVar.field_midimgLength == 0 ? dVar.field_fileLength : (long) dVar.field_midimgLength) + "\" hdlength=\"" + Util.nullAs(parseXml.get(".msg.img.$hdlength"), new StringBuilder().append(dVar.field_thumbimgLength).toString()) + "\"/>" + str + "</msg>";
                        } else {
                            str2 = (("<msg><img aeskey=\"" + Util.nullAs(parseXml.get(".msg.img.$aeskey"), dVar.field_aesKey) + "\" cdnmidimgurl=\"" + Util.nullAs(parseXml.get(".msg.img.$cdnmidimgurl"), dVar.field_fileId) + "\" cdnbigimgurl=\"" + Util.nullAs(parseXml.get(".msg.img.$cdnbigimgurl"), dVar.field_fileId) + "\" ") + "cdnthumburl=\"" + Util.nullAs(parseXml.get(".msg.img.$cdnthumburl"), dVar.field_fileId) + "\" cdnthumbaeskey=\"" + Util.nullAs(parseXml.get(".msg.img.$cdnthumbaeskey"), dVar.field_aesKey) + "\" cdnthumblength=\"" + Util.nullAs(parseXml.get(".msg.img.cdnthumblength"), new StringBuilder().append(dVar.field_thumbimgLength).toString()) + "\" ") + "length=\"" + parseXml.get(".msg.img.$length") + "\" hdlength=\"" + dVar.field_fileLength + "\"/>" + str + "</msg>";
                        }
                        Log.i(n.this.TAG, "cdn callback rebuild cdnInfo:%s", str2);
                    } else {
                        str2 = str3;
                    }
                }
                n.a(n.this, d2);
                d2.Ot(str2);
                n.this.iZp = str2;
                if (n.this.iYP != n.this.hmj) {
                    n.e(n.this).Ot(str2);
                }
                c bcn = c.bcn();
                bcn.hmk = n.this.hmk;
                bcn.iWW = (enu) n.this.rr.iLK.iLR;
                bcn.iWX = d2;
                bcn.aesKey = aVar.JUg;
                bcn.hmq = dVar;
                bcn.iWY = new o.a() {
                    /* class com.tencent.mm.av.n.AnonymousClass4.AnonymousClass1 */

                    @Override // com.tencent.mm.av.o.a
                    public final void a(long j2, int i2, int i3, int i4, String str) {
                        AppMethodBeat.i(223611);
                        Log.i(n.this.TAG, "cdntra clientid:%s NetSceneUploadMsgImgForCdn ret:[%d,%d]", n.this.iYT, Integer.valueOf(i3), Integer.valueOf(i4));
                        if (i3 == 0 && i4 == 0) {
                            n.a(n.this, d2, d2.iKP, j2, i2, dVar, str);
                            AppMethodBeat.o(223611);
                            return;
                        }
                        k.tp((int) n.this.iYP);
                        k.to((int) n.this.iYP);
                        n.this.callback.onSceneEnd(i3, i4, "", n.this);
                        if (n.this.iZn != null) {
                            n.this.iZn.aYO();
                        }
                        AppMethodBeat.o(223611);
                    }
                };
                bcn.toUser = n.this.dCM.field_talker;
                bcn.bdQ().execute();
                AppMethodBeat.o(223612);
            }

            @Override // com.tencent.mm.pluginsdk.f.d.a
            public final void M(int i2, String str) {
                AppMethodBeat.i(223613);
                Log.e(n.this.TAG, "onUploadFailure, errCode:%s, uploadID:%s", Integer.valueOf(i2), str);
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(10420, 0, 1, Long.valueOf(n.this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(c.cY(MMApplicationContext.getContext())), Integer.valueOf(n.this.gVY), 0, 0, 0);
                k.tp((int) n.this.iYP);
                k.to((int) n.this.iYP);
                n.this.callback.onSceneEnd(3, i2, "", n.this);
                if (n.this.iZn != null) {
                    n.this.iZn.aYO();
                }
                AppMethodBeat.o(223613);
            }

            @Override // com.tencent.mm.pluginsdk.f.d.a
            public final void a(float f2, long j2) {
                AppMethodBeat.i(223614);
                g d2 = n.d(n.this);
                if (d2 == null || d2.localId != n.this.hmj) {
                    Log.e(n.this.TAG, "onUploadFailure, getImg fail, progress:%s, finishedLen:%s", Float.valueOf(f2), Long.valueOf(j2));
                    k.tp((int) n.this.iYP);
                    k.to((int) n.this.iYP);
                    n.this.callback.onSceneEnd(3, -5, "", n.this);
                    if (n.this.iZn != null) {
                        n.this.iZn.aYO();
                    }
                    AppMethodBeat.o(223614);
                    return;
                }
                n.a(n.this, d2, (int) j2, 0, 0, null, null);
                AppMethodBeat.o(223614);
            }
        };
        this.iZc = new g.a() {
            /* class com.tencent.mm.av.n.AnonymousClass5 */

            @Override // com.tencent.mm.i.g.a
            public final int a(String str, int i2, com.tencent.mm.i.c cVar, final com.tencent.mm.i.d dVar, boolean z) {
                int i3;
                String str2;
                String str3;
                String OI;
                AppMethodBeat.i(223618);
                Log.d(n.this.TAG, "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", n.this.iYT, Integer.valueOf(i2), cVar, dVar);
                if (i2 == -21005) {
                    Log.w(n.this.TAG, "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", n.this.iYT);
                    if (n.this.iZn != null) {
                        n.this.iZn.aYO();
                    }
                    n.this.callback.onSceneEnd(3, i2, "", n.this);
                    AppMethodBeat.o(223618);
                    return 0;
                } else if (i2 != 0) {
                    Log.e(n.this.TAG, "cdntra cdnCallback clientid:%s startRet:%d", n.this.iYT, Integer.valueOf(i2));
                    k.tp((int) n.this.iYP);
                    k.to((int) n.this.iYP);
                    if (dVar != null) {
                        Object[] objArr = new Object[16];
                        objArr[0] = Integer.valueOf(i2);
                        objArr[1] = 1;
                        objArr[2] = Long.valueOf(n.this.startTime);
                        objArr[3] = Long.valueOf(Util.nowMilliSecond());
                        objArr[4] = Integer.valueOf(c.cY(MMApplicationContext.getContext()));
                        objArr[5] = Integer.valueOf(n.this.gVY);
                        objArr[6] = Long.valueOf(dVar.field_fileLength);
                        objArr[7] = dVar.field_transInfo;
                        objArr[8] = "";
                        objArr[9] = "";
                        objArr[10] = "";
                        objArr[11] = "";
                        objArr[12] = "";
                        objArr[13] = "";
                        objArr[14] = "";
                        if (dVar == null) {
                            OI = "";
                        } else {
                            OI = n.OI(dVar.gqk);
                        }
                        objArr[15] = OI;
                        new y(com.tencent.mm.plugin.report.a.t(objArr)).bfK();
                    }
                    n.this.callback.onSceneEnd(3, i2, "", n.this);
                    if (n.this.iZn != null) {
                        n.this.iZn.aYO();
                    }
                    AppMethodBeat.o(223618);
                    return 0;
                } else {
                    final g d2 = n.d(n.this);
                    if (d2 == null || d2.localId != n.this.hmj) {
                        f.baQ().Ob(n.this.iYT);
                        Log.e(n.this.TAG, "cdntra get imginfo failed maybe delete by user imgLocalId:%d client:%s", Long.valueOf(n.this.hmj), n.this.iYT);
                        if (n.this.iZn != null) {
                            n.this.iZn.aYO();
                        }
                        AppMethodBeat.o(223618);
                        return 0;
                    } else if (cVar != null) {
                        n.a(n.this, d2, (int) cVar.field_finishedLength, 0, 0, dVar, null);
                        AppMethodBeat.o(223618);
                        return 0;
                    } else {
                        if (dVar != null) {
                            Log.i(n.this.TAG, "dkupimg sceneResult:%s", dVar);
                            if (dVar.field_retCode != 0) {
                                Log.e(n.this.TAG, "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", n.this.iYT, Integer.valueOf(dVar.field_retCode), dVar);
                                if (dVar.field_retCode == -21111) {
                                    Log.w(n.this.TAG, "summersafecdn cdntra  ERR_CDNCOM_SAFEPROTO_NOAESKEY clientid:%s, enableHitcheck:%b", n.this.iYT, Boolean.valueOf(n.this.iZk));
                                    com.tencent.mm.kernel.g.aAi();
                                    com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable() {
                                        /* class com.tencent.mm.av.n.AnonymousClass5.AnonymousClass1 */

                                        public final void run() {
                                            AppMethodBeat.i(223615);
                                            n.this.iZk = false;
                                            n.this.startTime = 0;
                                            n.this.startOffset = 0;
                                            g d2 = n.d(n.this);
                                            d2.te(0);
                                            n.this.dCM.setCreateTime(bp.Kw(n.this.dCM.field_talker));
                                            n.this.iYT = c.a("upimg", n.this.dCM.field_createTime, n.this.dCM.field_talker, n.this.dCM.field_msgId + "_" + n.this.hmj + "_" + n.this.iXp);
                                            boolean a2 = n.a(n.this, d2, 0, 0, 0, dVar, null);
                                            enu enu = (enu) n.this.rr.iLK.iLR;
                                            if (enu == null) {
                                                Log.w(n.this.TAG, "summersafecdn ERR_CDNCOM_SAFEPROTO_NOAESKEY doScene again but old req is null");
                                            } else {
                                                enu.NlB = new dqi().bhy(n.this.iYT);
                                            }
                                            Log.i(n.this.TAG, "summersafecdn ERR_CDNCOM_SAFEPROTO_NOAESKEY doScene again enableHitcheck[%b], ret[%b] new clientid[%s] createtime[%d]", Boolean.valueOf(n.this.iZk), Boolean.valueOf(a2), n.this.iYT, Long.valueOf(n.this.dCM.field_createTime));
                                            n.this.doScene(n.v(n.this), n.this.callback);
                                            AppMethodBeat.o(223615);
                                        }
                                    });
                                    AppMethodBeat.o(223618);
                                    return 0;
                                }
                                if (dVar.field_retCode == -5103237) {
                                    Log.w(n.this.TAG, "upload hevc failed try jpg, %s", Boolean.valueOf(n.this.iZu));
                                    if (n.this.iZu) {
                                        com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable() {
                                            /* class com.tencent.mm.av.n.AnonymousClass5.AnonymousClass2 */

                                            public final void run() {
                                                AppMethodBeat.i(223616);
                                                n.b(n.this, n.d(n.this));
                                                AppMethodBeat.o(223616);
                                            }
                                        });
                                        AppMethodBeat.o(223618);
                                        return 0;
                                    }
                                }
                                env env = null;
                                if (!Util.isNullOrNil(dVar.field_sKeyrespbuf)) {
                                    env = new env();
                                    try {
                                        env.parseFrom(dVar.field_sKeyrespbuf);
                                        Log.d(n.this.TAG, "parse skeyrespbuf: ret:%d,msg:%s", Integer.valueOf(env.BaseResponse.Ret), env.BaseResponse.ErrMsg.toString());
                                    } catch (IOException e2) {
                                        env = null;
                                        Log.e(n.this.TAG, "UploadMsgImgResponse parse fail: %s", e2);
                                        Log.e(n.this.TAG, "exception:%s", Util.stackTraceToString(e2));
                                    } catch (b e3) {
                                        env = null;
                                        Log.e(n.this.TAG, "UploadMsgImgResponse parse UninitializedMessageException: %s", e3);
                                        Log.e(n.this.TAG, "exception:%s", Util.stackTraceToString(e3));
                                    }
                                }
                                k.tp((int) n.this.iYP);
                                k.to((int) n.this.iYP);
                                Object[] objArr2 = new Object[16];
                                objArr2[0] = Integer.valueOf(dVar.field_retCode);
                                objArr2[1] = 1;
                                objArr2[2] = Long.valueOf(n.this.startTime);
                                objArr2[3] = Long.valueOf(Util.nowMilliSecond());
                                objArr2[4] = Integer.valueOf(c.cY(MMApplicationContext.getContext()));
                                objArr2[5] = Integer.valueOf(n.this.gVY);
                                objArr2[6] = Long.valueOf(dVar.field_fileLength);
                                objArr2[7] = dVar.field_transInfo;
                                objArr2[8] = "";
                                objArr2[9] = "";
                                objArr2[10] = "";
                                objArr2[11] = "";
                                objArr2[12] = "";
                                objArr2[13] = "";
                                objArr2[14] = "";
                                objArr2[15] = dVar == null ? "" : n.OI(dVar.gqk);
                                String t = com.tencent.mm.plugin.report.a.t(objArr2);
                                new y(t).bfK();
                                new w(t).bfK();
                                if (env == null || env.BaseResponse.Ret == 0) {
                                    n.this.callback.onSceneEnd(3, dVar.field_retCode, "", n.this);
                                } else {
                                    n.this.callback.onSceneEnd(4, env.BaseResponse.Ret, env.BaseResponse.ErrMsg.toString(), n.this);
                                }
                                if (n.this.iZn != null) {
                                    n.this.iZn.aYO();
                                }
                            } else {
                                Log.i(n.this.TAG, "summersafecdn uploadMsgImg by cdn, UploadHitCacheType: %d, needSendMsg:%b", Integer.valueOf(dVar.field_UploadHitCacheType), Boolean.valueOf(dVar.field_needSendMsgField));
                                com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
                                Object[] objArr3 = new Object[3];
                                if (d2.source == 0) {
                                    i3 = 3;
                                } else {
                                    i3 = d2.source;
                                }
                                objArr3[0] = Integer.valueOf(i3);
                                objArr3[1] = n.this.iZi;
                                objArr3[2] = Integer.valueOf(dVar.field_UploadHitCacheType);
                                hVar.a(13230, objArr3);
                                String str4 = n.this.iZo;
                                a Ov = h.Ov(str4);
                                if (Ov == null || Util.isNullOrNil(Ov.appId)) {
                                    str2 = "";
                                } else {
                                    str2 = h.c(Ov.appId, Ov.mediaTagName, Ov.messageExt, Ov.messageAction);
                                }
                                if (Util.isNullOrNil(str4)) {
                                    str3 = (("<msg><img aeskey=\"" + dVar.field_aesKey + "\" cdnmidimgurl=\"" + dVar.field_fileId + "\" cdnbigimgurl=\"" + dVar.field_fileId + "\" ") + "cdnthumburl=\"" + dVar.field_fileId + "\" cdnthumbaeskey=\"" + dVar.field_aesKey + "\" cdnthumblength=\"" + dVar.field_thumbimgLength + "\" ") + "length=\"" + (dVar.field_midimgLength == 0 ? dVar.field_fileLength : (long) dVar.field_midimgLength) + "\" hdlength=\"" + dVar.field_fileLength + "\"/>" + str2 + "</msg>";
                                    Log.i(n.this.TAG, "cdn callback new build cdnInfo:%s", str3);
                                } else {
                                    Map<String, String> parseXml = XmlParser.parseXml(str4, "msg", null);
                                    if (parseXml != null) {
                                        if (d2.iXp == 0) {
                                            str3 = (("<msg><img aeskey=\"" + Util.nullAs(parseXml.get(".msg.img.$aeskey"), dVar.field_aesKey) + "\" cdnmidimgurl=\"" + dVar.field_fileId + "\" cdnbigimgurl=\"" + Util.nullAs(parseXml.get(".msg.img.$cdnbigimgurl"), dVar.field_fileId) + "\" ") + "cdnthumburl=\"" + Util.nullAs(parseXml.get(".msg.img.$cdnthumburl"), dVar.field_fileId) + "\" cdnthumbaeskey=\"" + Util.nullAs(parseXml.get(".msg.img.$cdnthumbaeskey"), dVar.field_aesKey) + "\" cdnthumblength=\"" + Util.nullAs(parseXml.get(".msg.img.cdnthumblength"), new StringBuilder().append(dVar.field_thumbimgLength).toString()) + "\" ") + "length=\"" + (dVar.field_midimgLength == 0 ? dVar.field_fileLength : (long) dVar.field_midimgLength) + "\" hdlength=\"" + Util.nullAs(parseXml.get(".msg.img.$hdlength"), new StringBuilder().append(dVar.field_thumbimgLength).toString()) + "\"/>" + str2 + "</msg>";
                                        } else {
                                            str3 = (("<msg><img aeskey=\"" + Util.nullAs(parseXml.get(".msg.img.$aeskey"), dVar.field_aesKey) + "\" cdnmidimgurl=\"" + Util.nullAs(parseXml.get(".msg.img.$cdnmidimgurl"), dVar.field_fileId) + "\" cdnbigimgurl=\"" + Util.nullAs(parseXml.get(".msg.img.$cdnbigimgurl"), dVar.field_fileId) + "\" ") + "cdnthumburl=\"" + Util.nullAs(parseXml.get(".msg.img.$cdnthumburl"), dVar.field_fileId) + "\" cdnthumbaeskey=\"" + Util.nullAs(parseXml.get(".msg.img.$cdnthumbaeskey"), dVar.field_aesKey) + "\" cdnthumblength=\"" + Util.nullAs(parseXml.get(".msg.img.cdnthumblength"), new StringBuilder().append(dVar.field_thumbimgLength).toString()) + "\" ") + "length=\"" + parseXml.get(".msg.img.$length") + "\" hdlength=\"" + dVar.field_fileLength + "\"/>" + str2 + "</msg>";
                                        }
                                        Log.i(n.this.TAG, "cdn callback rebuild cdnInfo:%s", str3);
                                    } else {
                                        str3 = str4;
                                    }
                                }
                                if (dVar.alL()) {
                                    if (Util.isNullOrNil(n.this.iZs)) {
                                        Log.w(n.this.TAG, "summersafecdn sceneResult isUploadBySafeCDNWithMD5 but prepareResponse AESKey is null");
                                    } else {
                                        str3 = (("<msg><img aeskey=\"" + n.this.iZs + "\" cdnmidimgurl=\"" + dVar.field_fileId + "\" cdnbigimgurl=\"" + dVar.field_fileId + "\" ") + "cdnthumburl=\"" + dVar.field_fileId + "\" cdnthumbaeskey=\"" + n.this.iZs + "\" ") + "length=\"" + dVar.field_midimgLength + "\" hdlength=\"" + dVar.field_fileLength + "\"/>" + str2 + "</msg>";
                                    }
                                }
                                n.a(n.this, d2);
                                d2.Ot(str3);
                                n.this.iZp = str3;
                                if (n.this.iYP != n.this.hmj) {
                                    n.e(n.this).Ot(str3);
                                }
                                if (dVar.field_needSendMsgField) {
                                    c bcn = c.bcn();
                                    bcn.hmk = n.this.hmk;
                                    bcn.iWW = (enu) n.this.rr.iLK.iLR;
                                    bcn.iWX = d2;
                                    bcn.aesKey = n.this.iZj;
                                    bcn.hmq = dVar;
                                    bcn.iWY = new o.a() {
                                        /* class com.tencent.mm.av.n.AnonymousClass5.AnonymousClass3 */

                                        @Override // com.tencent.mm.av.o.a
                                        public final void a(long j2, int i2, int i3, int i4, String str) {
                                            AppMethodBeat.i(223617);
                                            new y(com.tencent.mm.plugin.report.a.t(Integer.valueOf(i4), 1, Long.valueOf(n.this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(c.cY(MMApplicationContext.getContext())), Integer.valueOf(n.this.gVY), Long.valueOf(dVar.field_fileLength), dVar.field_transInfo, "", "", "", "", "", "", "", n.OI(dVar.gqk))).bfK();
                                            Log.i(n.this.TAG, "cdntra clientid:%s NetSceneUploadMsgImgForCdn ret:[%d,%d]", n.this.iYT, Integer.valueOf(i3), Integer.valueOf(i4));
                                            if (i3 == 0 && i4 == 0) {
                                                n.a(n.this, d2, d2.iKP, j2, i2, dVar, str);
                                                AppMethodBeat.o(223617);
                                                return;
                                            }
                                            k.tp((int) n.this.iYP);
                                            k.to((int) n.this.iYP);
                                            n.this.callback.onSceneEnd(i3, i4, "", n.this);
                                            if (n.this.iZn != null) {
                                                n.this.iZn.aYO();
                                            }
                                            AppMethodBeat.o(223617);
                                        }
                                    };
                                    bcn.toUser = n.this.dCM.field_talker;
                                    bcn.bdQ().execute();
                                } else {
                                    new y(com.tencent.mm.plugin.report.a.t(0, 1, Long.valueOf(n.this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(c.cY(MMApplicationContext.getContext())), Integer.valueOf(n.this.gVY), Long.valueOf(dVar.field_fileLength), dVar.field_transInfo, "", "", "", "", "", "", "", n.OI(dVar.gqk))).bfK();
                                    env env2 = new env();
                                    try {
                                        env2.parseFrom(dVar.field_sKeyrespbuf);
                                        long j2 = env2.Brn != 0 ? env2.Brn : (long) env2.Brl;
                                        Log.d(n.this.TAG, "parse skeyrespbuf: ret:%d,msg:%s", Integer.valueOf(env2.BaseResponse.Ret), env2.BaseResponse.ErrMsg.toString());
                                        if (n.a(n.this, d2, d2.iKP, j2, env2.CreateTime, dVar, env2.KHq)) {
                                            n.this.callback.onSceneEnd(0, 0, "", n.this);
                                            if (n.this.iZn != null) {
                                                n.this.iZn.aYO();
                                            }
                                        }
                                        AppMethodBeat.o(223618);
                                        return 0;
                                    } catch (IOException e4) {
                                        Log.e(n.this.TAG, "UploadMsgImgResponse parse fail: %s", e4);
                                        Log.e(n.this.TAG, "exception:%s", Util.stackTraceToString(e4));
                                        n.this.callback.onSceneEnd(3, dVar.field_retCode, "", n.this);
                                        if (n.this.iZn != null) {
                                            n.this.iZn.aYO();
                                        }
                                    }
                                }
                            }
                        }
                        AppMethodBeat.o(223618);
                        return 0;
                    }
                }
            }

            @Override // com.tencent.mm.i.g.a
            public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
                AppMethodBeat.i(223619);
                enu enu = (enu) n.this.rr.iLK.iLR;
                te teVar = new te();
                teVar.Lby = enu.NlB.MTo;
                teVar.xNH = enu.KHl.MTo;
                teVar.xNG = enu.KHm.MTo;
                teVar.Lbz = enu.NlI;
                teVar.LbA = enu.NlJ;
                teVar.Scene = n.this.scene;
                teVar.LbC = n.this.longtitude;
                teVar.LbD = n.this.latitude;
                teVar.LbE = n.this.iZr;
                teVar.KHq = enu.KHq;
                teVar.LbJ = n.this.iZj;
                teVar.jfi = enu.jfi;
                teVar.KEq = enu.KEq;
                teVar.KEs = enu.KEs;
                teVar.KEr = enu.KEr;
                teVar.LbN = enu.LbN;
                g d2 = n.d(n.this);
                String o = q.bcR().o(d2.iXm, "", "");
                f.baR();
                teVar.LbL = com.tencent.mm.an.a.NW(o);
                teVar.LbM = d2.iXq;
                if (teVar.LbM <= 0) {
                    teVar.LbM = n.this.hmk == 4 ? 2 : 1;
                }
                switch (n.this.hmk) {
                    case 1:
                    case 2:
                        teVar.xub = 1;
                        break;
                    case 3:
                    case 5:
                    default:
                        teVar.xub = 2;
                        break;
                    case 4:
                        teVar.xub = 3;
                        break;
                    case 6:
                        teVar.xub = 5;
                        break;
                }
                if (teVar.LbM == 3) {
                    teVar.xub = 4;
                }
                Log.i(n.this.TAG, "getCdnAuthInfo: mediaid:%s thumbwidth:%d, thumbheight:%d,MsgSource:%s,touser:%s aeskey[%s], imgLocalId[%d], msgLocalId[%d], getBigImgPath()[%s], fullpath[%s], prereq.CRC32[%d] prereq.MsgForwardType[%d], prereq.Source[%d]", str, Integer.valueOf(teVar.Lbz), Integer.valueOf(teVar.LbA), teVar.KHq, teVar.xNG, teVar.LbJ, Long.valueOf(n.this.hmj), Long.valueOf(n.this.iXv), d2.iXm, o, Integer.valueOf(teVar.LbL), Integer.valueOf(teVar.LbM), Integer.valueOf(teVar.xub));
                d.a aVar = new d.a();
                aVar.iLN = teVar;
                aVar.iLO = new env();
                aVar.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
                aVar.funcId = 625;
                aVar.iLP = 9;
                aVar.respCmdId = 1000000009;
                com.tencent.mm.ak.d aXF = aVar.aXF();
                e aZh = n.F(n.this).aZh();
                String str2 = n.this.TAG;
                Object[] objArr = new Object[1];
                objArr[0] = aZh == null ? "acc == null" : Boolean.valueOf(aZh.aZb());
                Log.i(str2, "getCdnAuthInfo login:%s", objArr);
                if (aZh == null || !aZh.aZb()) {
                    Log.e(n.this.TAG, "getCdnAuthInfo accinfo return null. clientimgid:%s", teVar.Lby);
                    AppMethodBeat.o(223619);
                } else if (x.a(aZh.qe(1), aZh.aZa(), aZh.aZc(), aXF.getReqObj(), byteArrayOutputStream, aZh.isForeground())) {
                    Log.d(n.this.TAG, "getCdnAuthInfo successed.clientimgid:%s", teVar.Lby);
                    AppMethodBeat.o(223619);
                } else {
                    Log.e(n.this.TAG, "getCdnAuthInfo failed. clientimgid:%s", teVar.Lby);
                    AppMethodBeat.o(223619);
                }
            }

            @Override // com.tencent.mm.i.g.a
            public final byte[] f(String str, byte[] bArr) {
                AppMethodBeat.i(223620);
                PInt pInt = new PInt();
                tf tfVar = new tf();
                try {
                    byte[] a2 = z.a(bArr, com.tencent.mm.kernel.g.aAg().hqi.iMw.aZh().qe(1), pInt, tfVar);
                    Log.i(n.this.TAG, "decodePrepareResponse aeskey[%s], fileid[%s], clientimgid[%s]", tfVar.LbJ, tfVar.KMl, tfVar.Lby);
                    n.this.iZs = tfVar.LbJ;
                    ((com.tencent.mm.plugin.messenger.foundation.a.s) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).setEnSendMsgActionFlag(tfVar.LbO);
                    Log.i(n.this.TAG, "prepareResponse.ActionFlag:%s", Integer.valueOf(tfVar.LbO));
                    Log.i(n.this.TAG, "decodePrepareResponse, clientmediaid:%s, ret:%d", str, Integer.valueOf(pInt.value));
                    AppMethodBeat.o(223620);
                    return a2;
                } catch (Exception e2) {
                    Log.e(n.this.TAG, "decodePrepareResponse Exception:%s", e2);
                    n.this.iZs = null;
                    AppMethodBeat.o(223620);
                    return null;
                }
            }
        };
        this.hmr = false;
        Log.i(this.TAG, "dkupimg init id:%d cmptype:%d  [%s]", Integer.valueOf(i2), Integer.valueOf(i3), Util.getStack());
        this.iYP = (long) i2;
        this.hmj = (long) i2;
        this.iXp = i3;
        d.a aVar = new d.a();
        aVar.iLN = new enu();
        aVar.iLO = new env();
        aVar.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
        aVar.funcId = 110;
        aVar.iLP = 9;
        aVar.respCmdId = 1000000009;
        this.rr = aVar.aXF();
        this.iYO = null;
        Log.d(this.TAG, "FROM B SERVICE:" + this.iYP);
        if (!k.tn((int) this.iYP)) {
            this.iYP = -1;
            AppMethodBeat.o(150698);
            return;
        }
        g c2 = q.bcR().c(Long.valueOf(this.iYP));
        this.iXv = c2.iXv;
        if (i3 == 1) {
            this.hmj = (long) c2.iXx;
            gVar = q.bcR().c(Long.valueOf(this.hmj));
        } else {
            gVar = c2;
        }
        g tm = q.bcR().tm((int) gVar.localId);
        if (tm != null) {
            this.iXv = tm.iXv;
        }
        this.dCM = ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().Hb(this.iXv);
        if (this.dCM == null || this.dCM.field_msgId == this.iXv) {
            if (this.dCM != null) {
                enu enu = (enu) this.rr.iLK.iLR;
                enu.KHl = new dqi().bhy(com.tencent.mm.model.z.aTY());
                enu.KHm = new dqi().bhy(this.dCM.field_talker);
                enu.BsG = gVar.offset;
                enu.BsF = gVar.iKP;
                enu.xKb = this.dCM.getType();
                enu.LYt = i3;
                if (ag.dm(MMApplicationContext.getContext())) {
                    i4 = 1;
                } else {
                    i4 = 2;
                }
                enu.Llx = i4;
                enu.NaY = gVar.source;
                enu.LbM = gVar.iXq;
                enu.LbM = gVar.iXq;
                enu.NlI = this.dCM.fQT;
                enu.NlJ = this.dCM.fQS;
                a Ov = h.Ov(this.dCM.field_content);
                if (Ov != null && !Util.isNullOrNil(Ov.appId)) {
                    this.hmk = gVar.source;
                    enu.jfi = Ov.appId;
                    enu.KEq = Ov.mediaTagName;
                    enu.KEs = Ov.messageAction;
                    enu.KEr = Ov.messageExt;
                    this.iZo = this.dCM.field_content;
                }
                if (((com.tencent.mm.plugin.messenger.foundation.a.s) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).ifAddTicketByActionFlag(this.dCM.field_talker)) {
                    enu.LbN = ((l) com.tencent.mm.kernel.g.af(l.class)).aSN().bjT(this.dCM.field_talker);
                }
                Log.i(this.TAG, "LINE425 thumb.width:%d,thumb.height:%d", Integer.valueOf(enu.NlI), Integer.valueOf(enu.NlJ));
                Log.d(this.TAG, "dkimgsource: %d, forwardtype:%d", Integer.valueOf(gVar.source), Integer.valueOf(enu.LbM));
                if (gVar.offset == 0) {
                    this.iYS = new h(getType(), true, (long) gVar.iKP);
                }
            }
            AppMethodBeat.o(150698);
            return;
        }
        Log.w(this.TAG, "init get msg by id failed:%d", Long.valueOf(this.iXv));
        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(111, 206, 1, false);
        this.dCM = null;
        AppMethodBeat.o(150698);
    }

    public n(int i2, int i3, j jVar) {
        g gVar;
        int i4;
        AppMethodBeat.i(223626);
        this.TAG = "MicroMsg.NetSceneUploadMsgImg";
        this.iZi = "";
        this.iZj = "";
        this.iZk = true;
        this.iZm = 16384;
        this.iXp = 0;
        this.dCM = null;
        this.iYS = null;
        this.iYT = "";
        this.startTime = 0;
        this.startOffset = -1;
        this.gVY = 0;
        this.iZn = new a(null);
        this.iZu = false;
        this.iZw = new d.a() {
            /* class com.tencent.mm.av.n.AnonymousClass4 */

            @Override // com.tencent.mm.pluginsdk.f.d.a
            public final void a(g.a aVar) {
                String str;
                String str2;
                AppMethodBeat.i(223612);
                Log.i(n.this.TAG, "upload success, field_aesKey:%s, fileId:%s, fileLen:%s", aVar.aesKey, aVar.fileId, Long.valueOf(aVar.jPY));
                long j2 = aVar.jPY;
                long nowMilliSecond = Util.nowMilliSecond();
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(10420, 0, 1, Long.valueOf(n.this.startTime), Long.valueOf(nowMilliSecond), Integer.valueOf(c.cY(MMApplicationContext.getContext())), Integer.valueOf(n.this.gVY), Long.valueOf(j2), Long.valueOf(j2 / (nowMilliSecond - n.this.startTime)), 1);
                final com.tencent.mm.i.d dVar = new com.tencent.mm.i.d();
                dVar.field_aesKey = aVar.aesKey;
                dVar.field_fileId = aVar.fileId;
                dVar.field_filemd5 = aVar.pkL;
                final g d2 = n.d(n.this);
                String o = q.bcR().o(d2.iXm, "", "");
                String o2 = q.bcR().o(d2.iXn, "", "");
                dVar.field_thumbimgLength = (int) s.boW(q.bcR().o(d2.iXo, "", ""));
                dVar.field_midimgLength = (int) s.boW(o2);
                dVar.field_fileLength = aVar.jPY;
                f.baR();
                dVar.field_filecrc = com.tencent.mm.an.a.NW(o);
                String str3 = n.this.iZo;
                a Ov = h.Ov(str3);
                if (Ov == null || Util.isNullOrNil(Ov.appId)) {
                    str = "";
                } else {
                    str = h.c(Ov.appId, Ov.mediaTagName, Ov.messageExt, Ov.messageAction);
                }
                if (Util.isNullOrNil(str3)) {
                    str2 = (("<msg><img aeskey=\"" + dVar.field_aesKey + "\" cdnmidimgurl=\"" + dVar.field_fileId + "\" cdnbigimgurl=\"" + dVar.field_fileId + "\" ") + "cdnthumburl=\"" + dVar.field_fileId + "\" cdnthumbaeskey=\"" + dVar.field_aesKey + "\" cdnthumblength=\"" + dVar.field_thumbimgLength + "\" ") + "length=\"" + (dVar.field_midimgLength == 0 ? dVar.field_fileLength : (long) dVar.field_midimgLength) + "\" hdlength=\"" + dVar.field_fileLength + "\"/>" + str + "</msg>";
                    Log.i(n.this.TAG, "cdn callback new build cdnInfo:%s", str2);
                } else {
                    Map<String, String> parseXml = XmlParser.parseXml(str3, "msg", null);
                    if (parseXml != null) {
                        if (d2.iXp == 0) {
                            str2 = (("<msg><img aeskey=\"" + Util.nullAs(parseXml.get(".msg.img.$aeskey"), dVar.field_aesKey) + "\" cdnmidimgurl=\"" + dVar.field_fileId + "\" cdnbigimgurl=\"" + Util.nullAs(parseXml.get(".msg.img.$cdnbigimgurl"), dVar.field_fileId) + "\" ") + "cdnthumburl=\"" + Util.nullAs(parseXml.get(".msg.img.$cdnthumburl"), dVar.field_fileId) + "\" cdnthumbaeskey=\"" + Util.nullAs(parseXml.get(".msg.img.$cdnthumbaeskey"), dVar.field_aesKey) + "\" cdnthumblength=\"" + Util.nullAs(parseXml.get(".msg.img.cdnthumblength"), new StringBuilder().append(dVar.field_thumbimgLength).toString()) + "\" ") + "length=\"" + (dVar.field_midimgLength == 0 ? dVar.field_fileLength : (long) dVar.field_midimgLength) + "\" hdlength=\"" + Util.nullAs(parseXml.get(".msg.img.$hdlength"), new StringBuilder().append(dVar.field_thumbimgLength).toString()) + "\"/>" + str + "</msg>";
                        } else {
                            str2 = (("<msg><img aeskey=\"" + Util.nullAs(parseXml.get(".msg.img.$aeskey"), dVar.field_aesKey) + "\" cdnmidimgurl=\"" + Util.nullAs(parseXml.get(".msg.img.$cdnmidimgurl"), dVar.field_fileId) + "\" cdnbigimgurl=\"" + Util.nullAs(parseXml.get(".msg.img.$cdnbigimgurl"), dVar.field_fileId) + "\" ") + "cdnthumburl=\"" + Util.nullAs(parseXml.get(".msg.img.$cdnthumburl"), dVar.field_fileId) + "\" cdnthumbaeskey=\"" + Util.nullAs(parseXml.get(".msg.img.$cdnthumbaeskey"), dVar.field_aesKey) + "\" cdnthumblength=\"" + Util.nullAs(parseXml.get(".msg.img.cdnthumblength"), new StringBuilder().append(dVar.field_thumbimgLength).toString()) + "\" ") + "length=\"" + parseXml.get(".msg.img.$length") + "\" hdlength=\"" + dVar.field_fileLength + "\"/>" + str + "</msg>";
                        }
                        Log.i(n.this.TAG, "cdn callback rebuild cdnInfo:%s", str2);
                    } else {
                        str2 = str3;
                    }
                }
                n.a(n.this, d2);
                d2.Ot(str2);
                n.this.iZp = str2;
                if (n.this.iYP != n.this.hmj) {
                    n.e(n.this).Ot(str2);
                }
                c bcn = c.bcn();
                bcn.hmk = n.this.hmk;
                bcn.iWW = (enu) n.this.rr.iLK.iLR;
                bcn.iWX = d2;
                bcn.aesKey = aVar.JUg;
                bcn.hmq = dVar;
                bcn.iWY = new o.a() {
                    /* class com.tencent.mm.av.n.AnonymousClass4.AnonymousClass1 */

                    @Override // com.tencent.mm.av.o.a
                    public final void a(long j2, int i2, int i3, int i4, String str) {
                        AppMethodBeat.i(223611);
                        Log.i(n.this.TAG, "cdntra clientid:%s NetSceneUploadMsgImgForCdn ret:[%d,%d]", n.this.iYT, Integer.valueOf(i3), Integer.valueOf(i4));
                        if (i3 == 0 && i4 == 0) {
                            n.a(n.this, d2, d2.iKP, j2, i2, dVar, str);
                            AppMethodBeat.o(223611);
                            return;
                        }
                        k.tp((int) n.this.iYP);
                        k.to((int) n.this.iYP);
                        n.this.callback.onSceneEnd(i3, i4, "", n.this);
                        if (n.this.iZn != null) {
                            n.this.iZn.aYO();
                        }
                        AppMethodBeat.o(223611);
                    }
                };
                bcn.toUser = n.this.dCM.field_talker;
                bcn.bdQ().execute();
                AppMethodBeat.o(223612);
            }

            @Override // com.tencent.mm.pluginsdk.f.d.a
            public final void M(int i2, String str) {
                AppMethodBeat.i(223613);
                Log.e(n.this.TAG, "onUploadFailure, errCode:%s, uploadID:%s", Integer.valueOf(i2), str);
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(10420, 0, 1, Long.valueOf(n.this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(c.cY(MMApplicationContext.getContext())), Integer.valueOf(n.this.gVY), 0, 0, 0);
                k.tp((int) n.this.iYP);
                k.to((int) n.this.iYP);
                n.this.callback.onSceneEnd(3, i2, "", n.this);
                if (n.this.iZn != null) {
                    n.this.iZn.aYO();
                }
                AppMethodBeat.o(223613);
            }

            @Override // com.tencent.mm.pluginsdk.f.d.a
            public final void a(float f2, long j2) {
                AppMethodBeat.i(223614);
                g d2 = n.d(n.this);
                if (d2 == null || d2.localId != n.this.hmj) {
                    Log.e(n.this.TAG, "onUploadFailure, getImg fail, progress:%s, finishedLen:%s", Float.valueOf(f2), Long.valueOf(j2));
                    k.tp((int) n.this.iYP);
                    k.to((int) n.this.iYP);
                    n.this.callback.onSceneEnd(3, -5, "", n.this);
                    if (n.this.iZn != null) {
                        n.this.iZn.aYO();
                    }
                    AppMethodBeat.o(223614);
                    return;
                }
                n.a(n.this, d2, (int) j2, 0, 0, null, null);
                AppMethodBeat.o(223614);
            }
        };
        this.iZc = new g.a() {
            /* class com.tencent.mm.av.n.AnonymousClass5 */

            @Override // com.tencent.mm.i.g.a
            public final int a(String str, int i2, com.tencent.mm.i.c cVar, final com.tencent.mm.i.d dVar, boolean z) {
                int i3;
                String str2;
                String str3;
                String OI;
                AppMethodBeat.i(223618);
                Log.d(n.this.TAG, "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", n.this.iYT, Integer.valueOf(i2), cVar, dVar);
                if (i2 == -21005) {
                    Log.w(n.this.TAG, "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", n.this.iYT);
                    if (n.this.iZn != null) {
                        n.this.iZn.aYO();
                    }
                    n.this.callback.onSceneEnd(3, i2, "", n.this);
                    AppMethodBeat.o(223618);
                    return 0;
                } else if (i2 != 0) {
                    Log.e(n.this.TAG, "cdntra cdnCallback clientid:%s startRet:%d", n.this.iYT, Integer.valueOf(i2));
                    k.tp((int) n.this.iYP);
                    k.to((int) n.this.iYP);
                    if (dVar != null) {
                        Object[] objArr = new Object[16];
                        objArr[0] = Integer.valueOf(i2);
                        objArr[1] = 1;
                        objArr[2] = Long.valueOf(n.this.startTime);
                        objArr[3] = Long.valueOf(Util.nowMilliSecond());
                        objArr[4] = Integer.valueOf(c.cY(MMApplicationContext.getContext()));
                        objArr[5] = Integer.valueOf(n.this.gVY);
                        objArr[6] = Long.valueOf(dVar.field_fileLength);
                        objArr[7] = dVar.field_transInfo;
                        objArr[8] = "";
                        objArr[9] = "";
                        objArr[10] = "";
                        objArr[11] = "";
                        objArr[12] = "";
                        objArr[13] = "";
                        objArr[14] = "";
                        if (dVar == null) {
                            OI = "";
                        } else {
                            OI = n.OI(dVar.gqk);
                        }
                        objArr[15] = OI;
                        new y(com.tencent.mm.plugin.report.a.t(objArr)).bfK();
                    }
                    n.this.callback.onSceneEnd(3, i2, "", n.this);
                    if (n.this.iZn != null) {
                        n.this.iZn.aYO();
                    }
                    AppMethodBeat.o(223618);
                    return 0;
                } else {
                    final g d2 = n.d(n.this);
                    if (d2 == null || d2.localId != n.this.hmj) {
                        f.baQ().Ob(n.this.iYT);
                        Log.e(n.this.TAG, "cdntra get imginfo failed maybe delete by user imgLocalId:%d client:%s", Long.valueOf(n.this.hmj), n.this.iYT);
                        if (n.this.iZn != null) {
                            n.this.iZn.aYO();
                        }
                        AppMethodBeat.o(223618);
                        return 0;
                    } else if (cVar != null) {
                        n.a(n.this, d2, (int) cVar.field_finishedLength, 0, 0, dVar, null);
                        AppMethodBeat.o(223618);
                        return 0;
                    } else {
                        if (dVar != null) {
                            Log.i(n.this.TAG, "dkupimg sceneResult:%s", dVar);
                            if (dVar.field_retCode != 0) {
                                Log.e(n.this.TAG, "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", n.this.iYT, Integer.valueOf(dVar.field_retCode), dVar);
                                if (dVar.field_retCode == -21111) {
                                    Log.w(n.this.TAG, "summersafecdn cdntra  ERR_CDNCOM_SAFEPROTO_NOAESKEY clientid:%s, enableHitcheck:%b", n.this.iYT, Boolean.valueOf(n.this.iZk));
                                    com.tencent.mm.kernel.g.aAi();
                                    com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable() {
                                        /* class com.tencent.mm.av.n.AnonymousClass5.AnonymousClass1 */

                                        public final void run() {
                                            AppMethodBeat.i(223615);
                                            n.this.iZk = false;
                                            n.this.startTime = 0;
                                            n.this.startOffset = 0;
                                            g d2 = n.d(n.this);
                                            d2.te(0);
                                            n.this.dCM.setCreateTime(bp.Kw(n.this.dCM.field_talker));
                                            n.this.iYT = c.a("upimg", n.this.dCM.field_createTime, n.this.dCM.field_talker, n.this.dCM.field_msgId + "_" + n.this.hmj + "_" + n.this.iXp);
                                            boolean a2 = n.a(n.this, d2, 0, 0, 0, dVar, null);
                                            enu enu = (enu) n.this.rr.iLK.iLR;
                                            if (enu == null) {
                                                Log.w(n.this.TAG, "summersafecdn ERR_CDNCOM_SAFEPROTO_NOAESKEY doScene again but old req is null");
                                            } else {
                                                enu.NlB = new dqi().bhy(n.this.iYT);
                                            }
                                            Log.i(n.this.TAG, "summersafecdn ERR_CDNCOM_SAFEPROTO_NOAESKEY doScene again enableHitcheck[%b], ret[%b] new clientid[%s] createtime[%d]", Boolean.valueOf(n.this.iZk), Boolean.valueOf(a2), n.this.iYT, Long.valueOf(n.this.dCM.field_createTime));
                                            n.this.doScene(n.v(n.this), n.this.callback);
                                            AppMethodBeat.o(223615);
                                        }
                                    });
                                    AppMethodBeat.o(223618);
                                    return 0;
                                }
                                if (dVar.field_retCode == -5103237) {
                                    Log.w(n.this.TAG, "upload hevc failed try jpg, %s", Boolean.valueOf(n.this.iZu));
                                    if (n.this.iZu) {
                                        com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable() {
                                            /* class com.tencent.mm.av.n.AnonymousClass5.AnonymousClass2 */

                                            public final void run() {
                                                AppMethodBeat.i(223616);
                                                n.b(n.this, n.d(n.this));
                                                AppMethodBeat.o(223616);
                                            }
                                        });
                                        AppMethodBeat.o(223618);
                                        return 0;
                                    }
                                }
                                env env = null;
                                if (!Util.isNullOrNil(dVar.field_sKeyrespbuf)) {
                                    env = new env();
                                    try {
                                        env.parseFrom(dVar.field_sKeyrespbuf);
                                        Log.d(n.this.TAG, "parse skeyrespbuf: ret:%d,msg:%s", Integer.valueOf(env.BaseResponse.Ret), env.BaseResponse.ErrMsg.toString());
                                    } catch (IOException e2) {
                                        env = null;
                                        Log.e(n.this.TAG, "UploadMsgImgResponse parse fail: %s", e2);
                                        Log.e(n.this.TAG, "exception:%s", Util.stackTraceToString(e2));
                                    } catch (b e3) {
                                        env = null;
                                        Log.e(n.this.TAG, "UploadMsgImgResponse parse UninitializedMessageException: %s", e3);
                                        Log.e(n.this.TAG, "exception:%s", Util.stackTraceToString(e3));
                                    }
                                }
                                k.tp((int) n.this.iYP);
                                k.to((int) n.this.iYP);
                                Object[] objArr2 = new Object[16];
                                objArr2[0] = Integer.valueOf(dVar.field_retCode);
                                objArr2[1] = 1;
                                objArr2[2] = Long.valueOf(n.this.startTime);
                                objArr2[3] = Long.valueOf(Util.nowMilliSecond());
                                objArr2[4] = Integer.valueOf(c.cY(MMApplicationContext.getContext()));
                                objArr2[5] = Integer.valueOf(n.this.gVY);
                                objArr2[6] = Long.valueOf(dVar.field_fileLength);
                                objArr2[7] = dVar.field_transInfo;
                                objArr2[8] = "";
                                objArr2[9] = "";
                                objArr2[10] = "";
                                objArr2[11] = "";
                                objArr2[12] = "";
                                objArr2[13] = "";
                                objArr2[14] = "";
                                objArr2[15] = dVar == null ? "" : n.OI(dVar.gqk);
                                String t = com.tencent.mm.plugin.report.a.t(objArr2);
                                new y(t).bfK();
                                new w(t).bfK();
                                if (env == null || env.BaseResponse.Ret == 0) {
                                    n.this.callback.onSceneEnd(3, dVar.field_retCode, "", n.this);
                                } else {
                                    n.this.callback.onSceneEnd(4, env.BaseResponse.Ret, env.BaseResponse.ErrMsg.toString(), n.this);
                                }
                                if (n.this.iZn != null) {
                                    n.this.iZn.aYO();
                                }
                            } else {
                                Log.i(n.this.TAG, "summersafecdn uploadMsgImg by cdn, UploadHitCacheType: %d, needSendMsg:%b", Integer.valueOf(dVar.field_UploadHitCacheType), Boolean.valueOf(dVar.field_needSendMsgField));
                                com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
                                Object[] objArr3 = new Object[3];
                                if (d2.source == 0) {
                                    i3 = 3;
                                } else {
                                    i3 = d2.source;
                                }
                                objArr3[0] = Integer.valueOf(i3);
                                objArr3[1] = n.this.iZi;
                                objArr3[2] = Integer.valueOf(dVar.field_UploadHitCacheType);
                                hVar.a(13230, objArr3);
                                String str4 = n.this.iZo;
                                a Ov = h.Ov(str4);
                                if (Ov == null || Util.isNullOrNil(Ov.appId)) {
                                    str2 = "";
                                } else {
                                    str2 = h.c(Ov.appId, Ov.mediaTagName, Ov.messageExt, Ov.messageAction);
                                }
                                if (Util.isNullOrNil(str4)) {
                                    str3 = (("<msg><img aeskey=\"" + dVar.field_aesKey + "\" cdnmidimgurl=\"" + dVar.field_fileId + "\" cdnbigimgurl=\"" + dVar.field_fileId + "\" ") + "cdnthumburl=\"" + dVar.field_fileId + "\" cdnthumbaeskey=\"" + dVar.field_aesKey + "\" cdnthumblength=\"" + dVar.field_thumbimgLength + "\" ") + "length=\"" + (dVar.field_midimgLength == 0 ? dVar.field_fileLength : (long) dVar.field_midimgLength) + "\" hdlength=\"" + dVar.field_fileLength + "\"/>" + str2 + "</msg>";
                                    Log.i(n.this.TAG, "cdn callback new build cdnInfo:%s", str3);
                                } else {
                                    Map<String, String> parseXml = XmlParser.parseXml(str4, "msg", null);
                                    if (parseXml != null) {
                                        if (d2.iXp == 0) {
                                            str3 = (("<msg><img aeskey=\"" + Util.nullAs(parseXml.get(".msg.img.$aeskey"), dVar.field_aesKey) + "\" cdnmidimgurl=\"" + dVar.field_fileId + "\" cdnbigimgurl=\"" + Util.nullAs(parseXml.get(".msg.img.$cdnbigimgurl"), dVar.field_fileId) + "\" ") + "cdnthumburl=\"" + Util.nullAs(parseXml.get(".msg.img.$cdnthumburl"), dVar.field_fileId) + "\" cdnthumbaeskey=\"" + Util.nullAs(parseXml.get(".msg.img.$cdnthumbaeskey"), dVar.field_aesKey) + "\" cdnthumblength=\"" + Util.nullAs(parseXml.get(".msg.img.cdnthumblength"), new StringBuilder().append(dVar.field_thumbimgLength).toString()) + "\" ") + "length=\"" + (dVar.field_midimgLength == 0 ? dVar.field_fileLength : (long) dVar.field_midimgLength) + "\" hdlength=\"" + Util.nullAs(parseXml.get(".msg.img.$hdlength"), new StringBuilder().append(dVar.field_thumbimgLength).toString()) + "\"/>" + str2 + "</msg>";
                                        } else {
                                            str3 = (("<msg><img aeskey=\"" + Util.nullAs(parseXml.get(".msg.img.$aeskey"), dVar.field_aesKey) + "\" cdnmidimgurl=\"" + Util.nullAs(parseXml.get(".msg.img.$cdnmidimgurl"), dVar.field_fileId) + "\" cdnbigimgurl=\"" + Util.nullAs(parseXml.get(".msg.img.$cdnbigimgurl"), dVar.field_fileId) + "\" ") + "cdnthumburl=\"" + Util.nullAs(parseXml.get(".msg.img.$cdnthumburl"), dVar.field_fileId) + "\" cdnthumbaeskey=\"" + Util.nullAs(parseXml.get(".msg.img.$cdnthumbaeskey"), dVar.field_aesKey) + "\" cdnthumblength=\"" + Util.nullAs(parseXml.get(".msg.img.cdnthumblength"), new StringBuilder().append(dVar.field_thumbimgLength).toString()) + "\" ") + "length=\"" + parseXml.get(".msg.img.$length") + "\" hdlength=\"" + dVar.field_fileLength + "\"/>" + str2 + "</msg>";
                                        }
                                        Log.i(n.this.TAG, "cdn callback rebuild cdnInfo:%s", str3);
                                    } else {
                                        str3 = str4;
                                    }
                                }
                                if (dVar.alL()) {
                                    if (Util.isNullOrNil(n.this.iZs)) {
                                        Log.w(n.this.TAG, "summersafecdn sceneResult isUploadBySafeCDNWithMD5 but prepareResponse AESKey is null");
                                    } else {
                                        str3 = (("<msg><img aeskey=\"" + n.this.iZs + "\" cdnmidimgurl=\"" + dVar.field_fileId + "\" cdnbigimgurl=\"" + dVar.field_fileId + "\" ") + "cdnthumburl=\"" + dVar.field_fileId + "\" cdnthumbaeskey=\"" + n.this.iZs + "\" ") + "length=\"" + dVar.field_midimgLength + "\" hdlength=\"" + dVar.field_fileLength + "\"/>" + str2 + "</msg>";
                                    }
                                }
                                n.a(n.this, d2);
                                d2.Ot(str3);
                                n.this.iZp = str3;
                                if (n.this.iYP != n.this.hmj) {
                                    n.e(n.this).Ot(str3);
                                }
                                if (dVar.field_needSendMsgField) {
                                    c bcn = c.bcn();
                                    bcn.hmk = n.this.hmk;
                                    bcn.iWW = (enu) n.this.rr.iLK.iLR;
                                    bcn.iWX = d2;
                                    bcn.aesKey = n.this.iZj;
                                    bcn.hmq = dVar;
                                    bcn.iWY = new o.a() {
                                        /* class com.tencent.mm.av.n.AnonymousClass5.AnonymousClass3 */

                                        @Override // com.tencent.mm.av.o.a
                                        public final void a(long j2, int i2, int i3, int i4, String str) {
                                            AppMethodBeat.i(223617);
                                            new y(com.tencent.mm.plugin.report.a.t(Integer.valueOf(i4), 1, Long.valueOf(n.this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(c.cY(MMApplicationContext.getContext())), Integer.valueOf(n.this.gVY), Long.valueOf(dVar.field_fileLength), dVar.field_transInfo, "", "", "", "", "", "", "", n.OI(dVar.gqk))).bfK();
                                            Log.i(n.this.TAG, "cdntra clientid:%s NetSceneUploadMsgImgForCdn ret:[%d,%d]", n.this.iYT, Integer.valueOf(i3), Integer.valueOf(i4));
                                            if (i3 == 0 && i4 == 0) {
                                                n.a(n.this, d2, d2.iKP, j2, i2, dVar, str);
                                                AppMethodBeat.o(223617);
                                                return;
                                            }
                                            k.tp((int) n.this.iYP);
                                            k.to((int) n.this.iYP);
                                            n.this.callback.onSceneEnd(i3, i4, "", n.this);
                                            if (n.this.iZn != null) {
                                                n.this.iZn.aYO();
                                            }
                                            AppMethodBeat.o(223617);
                                        }
                                    };
                                    bcn.toUser = n.this.dCM.field_talker;
                                    bcn.bdQ().execute();
                                } else {
                                    new y(com.tencent.mm.plugin.report.a.t(0, 1, Long.valueOf(n.this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(c.cY(MMApplicationContext.getContext())), Integer.valueOf(n.this.gVY), Long.valueOf(dVar.field_fileLength), dVar.field_transInfo, "", "", "", "", "", "", "", n.OI(dVar.gqk))).bfK();
                                    env env2 = new env();
                                    try {
                                        env2.parseFrom(dVar.field_sKeyrespbuf);
                                        long j2 = env2.Brn != 0 ? env2.Brn : (long) env2.Brl;
                                        Log.d(n.this.TAG, "parse skeyrespbuf: ret:%d,msg:%s", Integer.valueOf(env2.BaseResponse.Ret), env2.BaseResponse.ErrMsg.toString());
                                        if (n.a(n.this, d2, d2.iKP, j2, env2.CreateTime, dVar, env2.KHq)) {
                                            n.this.callback.onSceneEnd(0, 0, "", n.this);
                                            if (n.this.iZn != null) {
                                                n.this.iZn.aYO();
                                            }
                                        }
                                        AppMethodBeat.o(223618);
                                        return 0;
                                    } catch (IOException e4) {
                                        Log.e(n.this.TAG, "UploadMsgImgResponse parse fail: %s", e4);
                                        Log.e(n.this.TAG, "exception:%s", Util.stackTraceToString(e4));
                                        n.this.callback.onSceneEnd(3, dVar.field_retCode, "", n.this);
                                        if (n.this.iZn != null) {
                                            n.this.iZn.aYO();
                                        }
                                    }
                                }
                            }
                        }
                        AppMethodBeat.o(223618);
                        return 0;
                    }
                }
            }

            @Override // com.tencent.mm.i.g.a
            public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
                AppMethodBeat.i(223619);
                enu enu = (enu) n.this.rr.iLK.iLR;
                te teVar = new te();
                teVar.Lby = enu.NlB.MTo;
                teVar.xNH = enu.KHl.MTo;
                teVar.xNG = enu.KHm.MTo;
                teVar.Lbz = enu.NlI;
                teVar.LbA = enu.NlJ;
                teVar.Scene = n.this.scene;
                teVar.LbC = n.this.longtitude;
                teVar.LbD = n.this.latitude;
                teVar.LbE = n.this.iZr;
                teVar.KHq = enu.KHq;
                teVar.LbJ = n.this.iZj;
                teVar.jfi = enu.jfi;
                teVar.KEq = enu.KEq;
                teVar.KEs = enu.KEs;
                teVar.KEr = enu.KEr;
                teVar.LbN = enu.LbN;
                g d2 = n.d(n.this);
                String o = q.bcR().o(d2.iXm, "", "");
                f.baR();
                teVar.LbL = com.tencent.mm.an.a.NW(o);
                teVar.LbM = d2.iXq;
                if (teVar.LbM <= 0) {
                    teVar.LbM = n.this.hmk == 4 ? 2 : 1;
                }
                switch (n.this.hmk) {
                    case 1:
                    case 2:
                        teVar.xub = 1;
                        break;
                    case 3:
                    case 5:
                    default:
                        teVar.xub = 2;
                        break;
                    case 4:
                        teVar.xub = 3;
                        break;
                    case 6:
                        teVar.xub = 5;
                        break;
                }
                if (teVar.LbM == 3) {
                    teVar.xub = 4;
                }
                Log.i(n.this.TAG, "getCdnAuthInfo: mediaid:%s thumbwidth:%d, thumbheight:%d,MsgSource:%s,touser:%s aeskey[%s], imgLocalId[%d], msgLocalId[%d], getBigImgPath()[%s], fullpath[%s], prereq.CRC32[%d] prereq.MsgForwardType[%d], prereq.Source[%d]", str, Integer.valueOf(teVar.Lbz), Integer.valueOf(teVar.LbA), teVar.KHq, teVar.xNG, teVar.LbJ, Long.valueOf(n.this.hmj), Long.valueOf(n.this.iXv), d2.iXm, o, Integer.valueOf(teVar.LbL), Integer.valueOf(teVar.LbM), Integer.valueOf(teVar.xub));
                d.a aVar = new d.a();
                aVar.iLN = teVar;
                aVar.iLO = new env();
                aVar.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
                aVar.funcId = 625;
                aVar.iLP = 9;
                aVar.respCmdId = 1000000009;
                com.tencent.mm.ak.d aXF = aVar.aXF();
                e aZh = n.F(n.this).aZh();
                String str2 = n.this.TAG;
                Object[] objArr = new Object[1];
                objArr[0] = aZh == null ? "acc == null" : Boolean.valueOf(aZh.aZb());
                Log.i(str2, "getCdnAuthInfo login:%s", objArr);
                if (aZh == null || !aZh.aZb()) {
                    Log.e(n.this.TAG, "getCdnAuthInfo accinfo return null. clientimgid:%s", teVar.Lby);
                    AppMethodBeat.o(223619);
                } else if (x.a(aZh.qe(1), aZh.aZa(), aZh.aZc(), aXF.getReqObj(), byteArrayOutputStream, aZh.isForeground())) {
                    Log.d(n.this.TAG, "getCdnAuthInfo successed.clientimgid:%s", teVar.Lby);
                    AppMethodBeat.o(223619);
                } else {
                    Log.e(n.this.TAG, "getCdnAuthInfo failed. clientimgid:%s", teVar.Lby);
                    AppMethodBeat.o(223619);
                }
            }

            @Override // com.tencent.mm.i.g.a
            public final byte[] f(String str, byte[] bArr) {
                AppMethodBeat.i(223620);
                PInt pInt = new PInt();
                tf tfVar = new tf();
                try {
                    byte[] a2 = z.a(bArr, com.tencent.mm.kernel.g.aAg().hqi.iMw.aZh().qe(1), pInt, tfVar);
                    Log.i(n.this.TAG, "decodePrepareResponse aeskey[%s], fileid[%s], clientimgid[%s]", tfVar.LbJ, tfVar.KMl, tfVar.Lby);
                    n.this.iZs = tfVar.LbJ;
                    ((com.tencent.mm.plugin.messenger.foundation.a.s) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).setEnSendMsgActionFlag(tfVar.LbO);
                    Log.i(n.this.TAG, "prepareResponse.ActionFlag:%s", Integer.valueOf(tfVar.LbO));
                    Log.i(n.this.TAG, "decodePrepareResponse, clientmediaid:%s, ret:%d", str, Integer.valueOf(pInt.value));
                    AppMethodBeat.o(223620);
                    return a2;
                } catch (Exception e2) {
                    Log.e(n.this.TAG, "decodePrepareResponse Exception:%s", e2);
                    n.this.iZs = null;
                    AppMethodBeat.o(223620);
                    return null;
                }
            }
        };
        this.hmr = false;
        Log.i(this.TAG, "dkupimg init id:%d cmptype:%d pro:%s  [%s]", Integer.valueOf(i2), Integer.valueOf(i3), jVar, Util.getStack());
        this.iYP = (long) i2;
        this.hmj = (long) i2;
        this.iXp = i3;
        d.a aVar = new d.a();
        aVar.iLN = new enu();
        aVar.iLO = new env();
        aVar.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
        aVar.funcId = 110;
        aVar.iLP = 9;
        aVar.respCmdId = 1000000009;
        this.rr = aVar.aXF();
        this.iYO = null;
        Log.d(this.TAG, "FROM C SERVICE:" + this.iYP);
        if (!k.tn((int) this.iYP)) {
            this.iYP = -1;
            AppMethodBeat.o(223626);
            return;
        }
        g c2 = q.bcR().c(Long.valueOf(this.iYP));
        this.iXv = c2.iXv;
        c2.setStatus(0);
        c2.yF(0);
        c2.setOffset(0);
        q.bcR().a((int) this.hmj, c2);
        if (i3 == 1) {
            this.hmj = (long) c2.iXx;
            gVar = q.bcR().c(Long.valueOf(this.hmj));
        } else {
            gVar = c2;
        }
        this.dCM = ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().Hb(this.iXv);
        if (this.dCM != null) {
            this.dCM.setStatus(1);
            String str = gVar.iXo;
            if (str == null || !str.startsWith("THUMBNAIL_DIRPATH://")) {
                this.dCM.Cz("THUMBNAIL://" + gVar.localId);
            } else {
                this.dCM.Cz(str);
            }
            ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().a(this.iXv, this.dCM);
            enu enu = (enu) this.rr.iLK.iLR;
            enu.KHl = new dqi().bhy(com.tencent.mm.model.z.aTY());
            enu.KHm = new dqi().bhy(this.dCM.field_talker);
            enu.BsG = gVar.offset;
            enu.BsF = gVar.iKP;
            enu.xKb = this.dCM.getType();
            enu.LYt = i3;
            if (ag.dm(MMApplicationContext.getContext())) {
                i4 = 1;
            } else {
                i4 = 2;
            }
            enu.Llx = i4;
            enu.NaY = gVar.source;
            enu.LbM = gVar.iXq;
            enu.NlI = this.dCM.fQT;
            enu.NlJ = this.dCM.fQS;
            if (((com.tencent.mm.plugin.messenger.foundation.a.s) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).ifAddTicketByActionFlag(this.dCM.field_talker)) {
                enu.LbN = ((l) com.tencent.mm.kernel.g.af(l.class)).aSN().bjT(this.dCM.field_talker);
            }
            Log.i(this.TAG, "LINE492 thumb.width:%d,thumb.height:%d", Integer.valueOf(enu.NlI), Integer.valueOf(enu.NlJ));
            Log.d(this.TAG, "dkimgsource: %d, forwardtype:%d", Integer.valueOf(gVar.source), Integer.valueOf(enu.LbM));
            if (gVar.offset == 0) {
                this.iYS = new h(getType(), true, (long) gVar.iKP);
            }
        }
        AppMethodBeat.o(223626);
    }

    @Override // com.tencent.mm.ak.q
    public final q.b securityVerificationChecked(com.tencent.mm.network.s sVar) {
        return q.b.EOk;
    }

    private boolean a(g gVar, int i2) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(150700);
        String str = this.dCM.field_talker;
        if (ab.JF(str)) {
            Log.w(this.TAG, "cdntra not use cdn user:%s", str);
            AppMethodBeat.o(150700);
            return false;
        } else if (!com.tencent.mm.pluginsdk.f.b.gmg()) {
            Log.i(this.TAG, "isAllow2UseCdnWithXLab = false");
            AppMethodBeat.o(150700);
            return false;
        } else {
            f.baQ();
            if (!com.tencent.mm.an.b.sS(1) && Util.isNullOrNil(gVar.iXy)) {
                String str2 = this.TAG;
                f.baQ();
                Log.w(str2, "cdntra not use cdn flag:%b getCdnInfo:%s", Boolean.valueOf(com.tencent.mm.an.b.sS(1)), gVar.iXy);
                AppMethodBeat.o(150700);
                return false;
            } else if (Util.isNullOrNil(this.iYT)) {
                Log.w(this.TAG, "cdntra genClientId failed not use cdn imgLocalId:%d", Long.valueOf(this.hmj));
                AppMethodBeat.o(150700);
                return false;
            } else {
                String o = q.bcR().o(gVar.iXm, "", "");
                String o2 = q.bcR().o(gVar.iXn, "", "");
                String o3 = q.bcR().o(gVar.iXo, "", "");
                String o4 = q.bcR().o(gVar.iXr, "", "");
                com.tencent.mm.i.g gVar2 = new com.tencent.mm.i.g();
                gVar2.taskName = "task_NetSceneUploadMsgImg";
                gVar2.gqy = this.iZc;
                gVar2.field_mediaId = this.iYT;
                gVar2.field_fileType = this.gVY;
                gVar2.field_talker = str;
                gVar2.field_chattype = ab.Eq(str) ? 1 : 0;
                gVar2.field_priority = com.tencent.mm.i.a.gpM;
                gVar2.field_needStorage = false;
                gVar2.field_isStreamMedia = false;
                gVar2.field_sendmsg_viacdn = !as.bjw(this.dCM.field_talker);
                gVar2.field_enable_hitcheck = !as.bjw(this.dCM.field_talker) && this.iZk;
                gVar2.field_force_aeskeycdn = false;
                gVar2.field_trysafecdn = true;
                Log.i(this.TAG, "field_sendmsg_viacdn=%s talker=%s", Boolean.valueOf(gVar2.field_sendmsg_viacdn), str);
                if (i2 == -5103237) {
                    this.iYT = c.a("upimgjpg", this.dCM.field_createTime, str, this.dCM.field_msgId + "_" + this.hmj + "_" + this.iXp);
                    gVar2.field_fullpath = o;
                    gVar2.field_thumbpath = o3;
                    gVar2.field_midimgpath = o2;
                    gVar2.lastError = i2;
                    gVar2.field_mediaId = this.iYT;
                    this.iZu = false;
                } else {
                    boolean cEO = ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.emoji.b.c.class)).cEO();
                    if (this.hmk != 4 || !s.YS(o4)) {
                        o4 = ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.emoji.b.c.class)).alX(o);
                        z = this.iXp == 0 && !ImgUtil.identifyImgType(o).equals(".png") && bq(o, o4);
                        if (z) {
                            gVar.Ou(((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.emoji.b.c.class)).alX(gVar.iXm));
                        }
                    } else {
                        z = cEO;
                    }
                    String alX = ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.emoji.b.c.class)).alX(o2);
                    boolean bq = bq(o2, alX);
                    if (!z) {
                        o4 = o;
                    }
                    gVar2.field_fullpath = o4;
                    gVar2.field_thumbpath = o3;
                    if (!bq) {
                        alX = o2;
                    }
                    gVar2.field_midimgpath = alX;
                    this.iZu = z || bq;
                    String str3 = this.TAG;
                    Object[] objArr = new Object[3];
                    if (gVar2.field_fileType == com.tencent.mm.i.a.MediaType_FULLSIZEIMAGE) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    objArr[0] = Boolean.valueOf(z2);
                    objArr[1] = Boolean.valueOf(z);
                    objArr[2] = Boolean.valueOf(bq);
                    Log.d(str3, "hevc upload full size %b, use hevc %b, %b", objArr);
                }
                if (!this.iZu) {
                    Log.i(this.TAG, "checkUseCdn: use jpg, thumbIsHevc %s", Boolean.valueOf(ImgUtil.isWXGF(o3)));
                }
                if (gVar2.field_fileType == com.tencent.mm.i.a.MediaType_FULLSIZEIMAGE && Util.isNullOrNil(gVar2.field_midimgpath)) {
                    f.baQ();
                    if (com.tencent.mm.an.b.sS(256)) {
                        Log.w(this.TAG, "summersafecdn send fullsizeimage but midimgpath is null set field_force_aeskeycdn true");
                        gVar2.field_force_aeskeycdn = true;
                        gVar2.field_trysafecdn = false;
                    }
                }
                Map<String, String> parseXml = XmlParser.parseXml(this.iZo, "msg", null);
                if (parseXml != null) {
                    if (this.iXp != 1) {
                        gVar2.field_fileId = parseXml.get(".msg.img.$cdnmidimgurl");
                        gVar2.field_midFileLength = Util.getInt(parseXml.get(".msg.img.$length"), 0);
                        gVar2.field_totalLen = 0;
                    } else {
                        gVar2.field_fileId = parseXml.get(".msg.img.$cdnbigimgurl");
                        gVar2.field_midFileLength = Util.getInt(parseXml.get(".msg.img.$length"), 0);
                        gVar2.field_totalLen = 0;
                    }
                    gVar2.field_aesKey = parseXml.get(".msg.img.$aeskey");
                } else {
                    Log.i(this.TAG, "parse cdnInfo failed. [%s]", gVar.iXy);
                }
                if (Util.isNullOrNil(gVar2.field_aesKey) || BuildConfig.COMMAND.equalsIgnoreCase(gVar2.field_aesKey)) {
                    f.baR();
                    gVar2.field_aesKey = com.tencent.mm.an.a.baG();
                    Log.i(this.TAG, "summersafecdn cdntra oldAeskey is null and gen new[%s]", gVar2.field_aesKey);
                }
                Log.i(this.TAG, "dkupimg src:%d fileid:%s", Integer.valueOf(gVar.source), gVar2.field_fileId);
                this.iZi = gVar2.field_fileId;
                this.iZj = gVar2.field_aesKey;
                Log.d(this.TAG, "summersafecdn checkUseCdn field_enable_hitcheck[%b], field_fileType[%d], field_midimgpath[%s], field_fullpath[%s], aeskey[%s], fileid[%s], enable_hitcheck[%b], aeskeycdn[%b], trysafecdn[%b]", Boolean.valueOf(gVar2.field_enable_hitcheck), Integer.valueOf(gVar2.field_fileType), gVar2.field_midimgpath, gVar2.field_fullpath, gVar2.field_aesKey, gVar2.field_fileId, Boolean.valueOf(gVar2.field_enable_hitcheck), Boolean.valueOf(gVar2.field_force_aeskeycdn), Boolean.valueOf(gVar2.field_trysafecdn));
                this.iZs = null;
                if (!f.baQ().f(gVar2)) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(111, 205, 1, false);
                    Log.e(this.TAG, "cdntra addSendTask failed. clientid:%s", this.iYT);
                    this.iYT = "";
                    AppMethodBeat.o(150700);
                    return false;
                }
                if (Util.nullAsNil(gVar.iXy).length() <= 0) {
                    gVar.Ot("CDNINFO_SEND");
                    gVar.cSx = 4096;
                }
                AppMethodBeat.o(150700);
                return true;
            }
        }
    }

    private boolean bq(String str, String str2) {
        AppMethodBeat.i(150701);
        if (!((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.emoji.b.c.class)).cEO()) {
            AppMethodBeat.o(150701);
            return false;
        }
        if (s.boW(str) > 0) {
            if (s.boW(str2) > 0) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.dN(944, 9);
                s.deleteFile(str2);
            }
            if (!s.YS(str2)) {
                s.bpa(str2);
            }
            if (((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.emoji.b.c.class)).fO(str, str2) == 0) {
                AppMethodBeat.o(150701);
                return true;
            }
            Log.w(this.TAG, "file to hevc failed %s", str);
        }
        AppMethodBeat.o(150701);
        return false;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        String ajw;
        boolean z;
        boolean z2;
        String str;
        boolean z3;
        String o;
        AppMethodBeat.i(150702);
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAk().postToWorkerDelayed(new Runnable() {
            /* class com.tencent.mm.av.n.AnonymousClass6 */

            public final void run() {
                AppMethodBeat.i(150690);
                ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().aEt("SendImgSpeeder");
                AppMethodBeat.o(150690);
            }
        }, 100);
        if (this.hmj < 0) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(111, 204, 1, false);
            Log.e(this.TAG, "doScene invalid imgLocalId:" + this.hmj);
            int tr = tr(-1);
            AppMethodBeat.o(150702);
            return tr;
        } else if (this.dCM == null) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(111, 203, 1, false);
            Log.e(this.TAG, "doScene msg is null imgid:%d", Long.valueOf(this.hmj));
            k.tp((int) this.iYP);
            int tr2 = tr(-2);
            AppMethodBeat.o(150702);
            return tr2;
        } else {
            this.callback = iVar;
            prepareDispatcher(gVar);
            enu enu = (enu) this.rr.iLK.iLR;
            g bcB = bcB();
            g tm = q.bcR().tm((int) bcB.localId);
            if (tm != null) {
                if (tm.status == -1) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(111, 202, 1, false);
                    Log.e(this.TAG, "doScene hd img info is null or error.");
                    int tr3 = tr(-3);
                    AppMethodBeat.o(150702);
                    return tr3;
                }
            } else if (bcB == null || bcB.status == -1) {
                Log.e(this.TAG, "doScene img info is null or error.");
                int tr4 = tr(-4);
                AppMethodBeat.o(150702);
                return tr4;
            }
            if (a.C0409a.anC().DQ(this.dCM.field_talker)) {
                enu.KHq = a.C0409a.anC().o(this.dCM);
            } else {
                if (Util.isNullOrNil(this.iZv)) {
                    String bhK = s.bhK(this.iZt);
                    v vVar = v.jNy;
                    this.iZv = v.Ss(bhK);
                }
                if (!Util.isNullOrNil(this.iZv)) {
                    ajw = br.KC(this.iZv);
                } else {
                    ajw = br.ajw();
                }
                if ((ajw != null && !ajw.equals(this.dCM.fqK)) || (ajw == null && !Util.isNullOrNil(this.dCM.fqK))) {
                    this.dCM.BB(ajw);
                    ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().a(this.dCM.field_msgId, this.dCM);
                }
                enu.KHq = this.dCM.fqK;
            }
            Log.i(this.TAG, "upload img msg source %s", enu.KHq);
            String o2 = q.bcR().o(bcB.iXm, "", "");
            String o3 = q.bcR().o(bcB.iXo, "", "");
            if (!Util.isNullOrNil(bcB.iXn)) {
                q.bcR().o(bcB.iXn, "", "");
            }
            if (s.boW(o2) <= 0 || s.boW(o3) <= 0) {
                Log.e(this.TAG, "doScene invalid imgLocalId:%d filesize:[%d,%d] %s %s", Long.valueOf(this.hmj), Long.valueOf(s.boW(o2)), Long.valueOf(s.boW(o3)), o2, o3);
                int tr5 = tr(-5);
                AppMethodBeat.o(150702);
                return tr5;
            }
            if (enu.NlB == null || Util.isNullOrNil(enu.NlB.MTo)) {
                if (Util.isNullOrNil(this.iYT)) {
                    Log.i(this.TAG, "createMediaId time:%d talker:%s msg:%d img:%d compressType:%d", Long.valueOf(this.dCM.field_createTime), this.dCM.field_talker, Long.valueOf(this.dCM.field_msgId), Long.valueOf(this.hmj), Integer.valueOf(this.iXp));
                    this.iYT = c.a("upimg", this.dCM.field_createTime, this.dCM.field_talker, this.dCM.field_msgId + "_" + this.hmj + "_" + this.iXp);
                }
                enu.NlB = new dqi().bhy(this.iYT);
                ca caVar = this.dCM;
                caVar.fQY = this.iYT;
                caVar.fqk = true;
            }
            if (this.startTime == 0) {
                this.startTime = Util.nowMilliSecond();
                this.startOffset = bcB.offset;
                this.gVY = this.iXp == 1 ? com.tencent.mm.i.a.MediaType_FULLSIZEIMAGE : com.tencent.mm.i.a.MediaType_IMAGE;
            }
            if (a(bcB, 0)) {
                Log.d(this.TAG, "cdntra use cdn return -1 for onGYNetEnd clientid:%s", enu.NlB.MTo);
                AppMethodBeat.o(150702);
                return 0;
            } else if (as.bjw(this.dkV)) {
                Log.w(this.TAG, "just return without using cdn for byp. %s", this.dkV);
                k.tp((int) this.iYP);
                int tr6 = tr(-99);
                AppMethodBeat.o(150702);
                return tr6;
            } else {
                if (com.tencent.mm.n.h.aqJ().getInt("UploadMsgImgType", 0) == 1) {
                    z = true;
                } else {
                    z = false;
                }
                if (ab.JF(this.dCM.field_talker)) {
                    Log.w(this.TAG, "cdntra not use parallel-upload user:%s", this.dCM.field_talker);
                    z3 = false;
                } else {
                    if (1 == ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_parallel_upload_image_android, 0)) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (!z2) {
                        Log.i(this.TAG, "NOT ALLOW USE PARALLEL UPLOAD IMG");
                        z3 = false;
                    } else {
                        String o4 = q.bcR().o(bcB.iXm, "", "");
                        String o5 = q.bcR().o(bcB.iXo, "", "");
                        String o6 = q.bcR().o(bcB.iXn, "", "");
                        boolean isNullOrNil = Util.isNullOrNil(o6);
                        if (isNullOrNil) {
                            str = o4;
                        } else {
                            str = o6;
                        }
                        String alX = ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.emoji.b.c.class)).alX(str);
                        String alX2 = ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.emoji.b.c.class)).alX(o4);
                        com.tencent.mm.pluginsdk.f.d dVar = new com.tencent.mm.pluginsdk.f.d();
                        dVar.iXv = this.iXv;
                        dVar.JTT = this.iZw;
                        dVar.scene = 1;
                        dVar.fileType = 2;
                        if (!isNullOrNil) {
                            dVar.fileType = 1;
                        }
                        if (z && this.iXp == 0) {
                            bcB.Ou(alX2);
                            String o7 = q.bcR().o(bcB.iXr, "", "");
                            int fO = ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.emoji.b.c.class)).fO(o4, o7);
                            if (fO == 0) {
                                bcB.ti(1);
                                bcB.tf((int) s.boW(o7));
                            } else {
                                bcB.ti(0);
                            }
                            Log.i(this.TAG, "upload c2c cgi img use wxa %s %s %s %s", Long.valueOf(this.hmj), o7, Integer.valueOf(fO), Integer.valueOf(bcB.iKP));
                        }
                        dVar.thumbPath = o5;
                        dVar.iXn = str;
                        dVar.JTV = alX;
                        dVar.fullPath = o4;
                        dVar.JTU = alX2;
                        com.tencent.mm.pluginsdk.f.c cVar = new com.tencent.mm.pluginsdk.f.c();
                        cVar.JTQ = z;
                        cVar.a(dVar);
                        z3 = true;
                    }
                }
                if (z3) {
                    Log.d(this.TAG, "cdntra use parallel-upload return -1 for onGYNetEnd clientid:%s", enu.NlB.MTo);
                    AppMethodBeat.o(150702);
                    return 0;
                }
                if (z && this.iXp == 0) {
                    bcB.Ou(((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.emoji.b.c.class)).alX(bcB.iXm));
                    String o8 = q.bcR().o(bcB.iXr, "", "");
                    int fO2 = ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.emoji.b.c.class)).fO(o2, o8);
                    if (fO2 == 0) {
                        bcB.ti(1);
                        bcB.tf((int) s.boW(o8));
                    } else {
                        bcB.ti(0);
                    }
                    Log.i(this.TAG, "upload c2c cgi img use wxa %s %s %s %s", Long.valueOf(this.hmj), o8, Integer.valueOf(fO2), Integer.valueOf(bcB.iKP));
                }
                int i2 = bcB.iXw;
                if (i2 >= securityLimitCount()) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(111, 201, 1, false);
                    Log.e(this.TAG, "doScene limit net time:".concat(String.valueOf(i2)));
                    k.tp((int) this.iYP);
                    int tr7 = tr(-6);
                    AppMethodBeat.o(150702);
                    return tr7;
                }
                bcB.te(i2 + 1);
                bcB.cSx = 512;
                q.bcR().a(Long.valueOf(this.hmj), bcB);
                int i3 = bcB.iKP - bcB.offset;
                if (i3 > this.iZm) {
                    i3 = this.iZm;
                }
                s.boW(o2);
                if (bcB.iXs == 1) {
                    o = q.bcR().o(bcB.iXr, "", "");
                } else {
                    o = q.bcR().o(bcB.iXm, "", "");
                }
                byte[] aW = s.aW(o, bcB.offset, i3);
                if (aW == null || aW.length <= 0) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(111, 199, 1, false);
                    Log.e(this.TAG, "doScene, file read buf error.");
                    int tr8 = tr(-8);
                    AppMethodBeat.o(150702);
                    return tr8;
                }
                enu.BsH = aW.length;
                enu.BsF = bcB.iKP;
                enu.BsG = bcB.offset;
                enu.BsI = new SKBuiltinBuffer_t().setBuffer(aW);
                enu.Mwb = bcB.iXs;
                if (this.iYS != null) {
                    this.iYS.bgi();
                }
                int dispatch = dispatch(gVar, this.rr, this);
                if (dispatch < 0) {
                    Log.e(this.TAG, "doScene netId error");
                    k.tp((int) this.iYP);
                    int tr9 = tr(-9);
                    AppMethodBeat.o(150702);
                    return tr9;
                }
                AppMethodBeat.o(150702);
                return dispatch;
            }
        }
    }

    private int tr(int i2) {
        AppMethodBeat.i(150703);
        Log.e(this.TAG, "do Scene error code : " + i2 + " hashcode : " + hashCode());
        if (this.iZn != null) {
            this.iZn.aYO();
        }
        AppMethodBeat.o(150703);
        return -1;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 110;
    }

    @Override // com.tencent.mm.ak.q
    public final int securityLimitCount() {
        if (this.iXp == 0) {
            return 100;
        }
        return 1350;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, com.tencent.mm.network.s sVar, byte[] bArr) {
        AppMethodBeat.i(150704);
        Log.i(this.TAG, "cdntra onGYNetEnd errtype:" + i3 + " errcode:" + i4 + " useCdnTransClientId:" + this.iYT);
        env env = (env) ((com.tencent.mm.ak.d) sVar).iLL.iLR;
        if (env != null && (i3 == 4 || (i3 == 0 && i4 == 0))) {
            ((com.tencent.mm.plugin.messenger.foundation.a.s) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).setEnSendMsgActionFlag(env.LbO);
        }
        if (i3 == 3 && i4 == -1 && !Util.isNullOrNil(this.iYT)) {
            Log.w(this.TAG, "cdntra using cdn trans,  wait cdn service callback! clientid:%s", this.iYT);
            AppMethodBeat.o(150704);
        } else if (i3 == 0 && i4 == 0) {
            this.iZm = env.BsH;
            if (this.iZm > 16384) {
                this.iZm = 16384;
            }
            g bcB = bcB();
            Log.v(this.TAG, "onGYNetEnd localId:" + this.hmj + "  totalLen:" + bcB.iKP + " offSet:" + bcB.offset);
            if (env.BsG < 0 || (env.BsG > bcB.iKP && bcB.iKP > 0)) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(111, 197, 1, false);
                Log.e(this.TAG, "onGYNetEnd invalid server return value : startPos = " + env.BsG + " img totalLen = " + bcB.iKP);
                k.tp((int) this.iYP);
                k.to((int) this.iYP);
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(10420, -2, 1, Long.valueOf(this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(c.cY(MMApplicationContext.getContext())), Integer.valueOf(this.gVY), 0);
                this.callback.onSceneEnd(4, -2, "", this);
                if (this.iZn != null) {
                    this.iZn.aYO();
                }
                AppMethodBeat.o(150704);
            } else if (env.BsG < bcB.offset || (h.b(bcB) && this.iZm <= 0)) {
                Log.e(this.TAG, "onGYNetEnd invalid data startPos = " + env.BsG + " totalLen = " + bcB.iKP + " off:" + bcB.offset);
                k.tp((int) this.iYP);
                k.to((int) this.iYP);
                this.callback.onSceneEnd(4, -1, "", this);
                if (this.iZn != null) {
                    this.iZn.aYO();
                }
                AppMethodBeat.o(150704);
            } else {
                Log.d("ImgInfoLogic", "resp.rImpl.getStartPos() " + env.BsG);
                if (a(bcB, env.BsG, env.Brn, env.CreateTime, null, env.KHq) && doScene(dispatcher(), this.callback) < 0) {
                    k.to((int) this.iYP);
                    this.callback.onSceneEnd(3, -1, "", this);
                    if (this.iZn != null) {
                        this.iZn.aYO();
                    }
                }
                AppMethodBeat.o(150704);
            }
        } else {
            Log.e(this.TAG, "onGYNetEnd failed errtype:" + i3 + " errcode:" + i4);
            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(111, 198, 1, false);
            k.tp((int) this.iYP);
            k.to((int) this.iYP);
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(10420, Integer.valueOf(i4), 1, Long.valueOf(this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(c.cY(MMApplicationContext.getContext())), Integer.valueOf(this.gVY), 0);
            this.callback.onSceneEnd(i3, i4, str, this);
            if (this.iZn != null) {
                this.iZn.aYO();
            }
            AppMethodBeat.o(150704);
        }
    }

    public final void bcE() {
        AppMethodBeat.i(150705);
        Log.i(this.TAG, "send img from system");
        this.hmr = true;
        AppMethodBeat.o(150705);
    }

    private boolean a(g gVar, int i2, long j2, int i3, com.tencent.mm.i.d dVar, String str) {
        AppMethodBeat.i(169189);
        Log.d(this.TAG, "cdntra clientid:%s start:%d svrid:%d createtime:%d", this.iYT, Integer.valueOf(i2), Long.valueOf(j2), Integer.valueOf(i3));
        Log.i(this.TAG, "dkmsgid  set svrmsgid %d -> %d  oriImgLocalId %s imgLocalId %s", Long.valueOf(j2), Integer.valueOf(ac.jOD), Long.valueOf(this.iYP), Long.valueOf(this.hmj));
        if (10007 == ac.jOC && ac.jOD != 0) {
            j2 = (long) ac.jOD;
            ac.jOD = 0;
        }
        b(gVar.localId, i2, gVar.iKP);
        gVar.setOffset(i2);
        gVar.yF(j2);
        if (h.b(gVar)) {
            if (this.iYP != this.hmj) {
                g c2 = q.bcR().c(Long.valueOf(this.iYP));
                c2.yF(j2);
                c2.tf(gVar.iKP);
                c2.setOffset(gVar.iKP);
                q.bcR().a(Long.valueOf(this.iYP), c2);
            } else {
                g c3 = q.bcR().c(Long.valueOf(gVar.localId));
                c3.yF(j2);
                c3.tf(gVar.iKP);
                c3.setOffset(gVar.iKP);
                q.bcR().a(Long.valueOf(c3.localId), c3);
            }
        }
        if (h.b(gVar)) {
            if (Util.isNullOrNil(this.iYT)) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(10420, 0, 1, Long.valueOf(this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(c.cY(MMApplicationContext.getContext())), Integer.valueOf(this.gVY), Integer.valueOf(gVar.iKP - this.startOffset));
            }
            this.dCM.setStatus(2);
            this.dCM.yF(j2);
            this.dCM.BB(str);
            ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().a(this.iXv, this.dCM);
            if (r.jpw != null) {
                r.jpw.s(this.dCM);
            }
            if (this.iYS != null) {
                this.iYS.AH(0);
            }
            if (u.jaE != null) {
                String str2 = this.iZv;
                if (Util.isNullOrNil(str2)) {
                    str2 = br.KB(str);
                }
                u.jaE.a(this.hmj, this.dCM, this.rr, this.hmk, this.hmr, dVar, str2);
            }
            if (this.iZn != null) {
                this.iZn.aYO();
            }
            this.callback.onSceneEnd(0, 0, "", this);
            k.to((int) this.iYP);
            AppMethodBeat.o(169189);
            return false;
        }
        AppMethodBeat.o(169189);
        return true;
    }

    private void b(final long j2, final int i2, final int i3) {
        AppMethodBeat.i(150707);
        if (this.iYO != null) {
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.av.n.AnonymousClass7 */

                public final void run() {
                    p.d dVar;
                    AppMethodBeat.i(223621);
                    p bcF = p.bcF();
                    long j2 = j2;
                    long j3 = (long) i3;
                    long j4 = (long) i2;
                    if (bcF.iZG.containsKey(Long.valueOf(j2))) {
                        dVar = bcF.iZG.get(Long.valueOf(j2));
                    } else {
                        dVar = new p.d();
                    }
                    dVar.offset = j4;
                    dVar.total = j3;
                    bcF.iZG.put(Long.valueOf(j2), dVar);
                    n.this.iYO.a(i2, i3, n.this);
                    AppMethodBeat.o(223621);
                }
            });
        }
        AppMethodBeat.o(150707);
    }

    public static void Az(long j2) {
        iZx = j2;
    }

    public static String OI(String str) {
        AppMethodBeat.i(150708);
        try {
            if (Util.isNullOrNil(str)) {
                AppMethodBeat.o(150708);
                return str;
            }
            String[] split = str.split(",");
            if (split == null || split.length <= 19) {
                AppMethodBeat.o(150708);
                return str;
            }
            StringBuilder sb = new StringBuilder();
            long j2 = iZx;
            iZx = -1;
            split[19] = sb.append(j2).toString();
            String listToString = Util.listToString(Util.stringsToList(split), ",");
            AppMethodBeat.o(150708);
            return listToString;
        } catch (Exception e2) {
            AppMethodBeat.o(150708);
            return str;
        }
    }

    static /* synthetic */ String e(g gVar) {
        AppMethodBeat.i(150711);
        String format = String.format("ImgInfo localId [%s,%s,%s,%s]", Long.valueOf(gVar.localId), Integer.valueOf(gVar.offset), Integer.valueOf(gVar.iKP), Long.valueOf(gVar.dTS));
        AppMethodBeat.o(150711);
        return format;
    }

    static /* synthetic */ void a(n nVar, final long j2) {
        AppMethodBeat.i(150712);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.av.n.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(150680);
                p.bcF().iZG.remove(Long.valueOf(j2));
                AppMethodBeat.o(150680);
            }
        });
        AppMethodBeat.o(150712);
    }

    static /* synthetic */ void a(n nVar, g gVar) {
        AppMethodBeat.i(223627);
        int a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_c2c_upload_delete_hevc, 1);
        Log.i(nVar.TAG, "cleanHevc: config %s", Integer.valueOf(a2));
        if (a2 != 0) {
            String o = q.bcR().o(gVar.iXm, "", "");
            String o2 = q.bcR().o(gVar.iXn, "", "");
            String alX = ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.emoji.b.c.class)).alX(o);
            String alX2 = ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.emoji.b.c.class)).alX(o2);
            if (s.YS(o) && s.YS(alX)) {
                Log.i(nVar.TAG, "cleanHevc: delete big %s", s.k(alX, false));
                s.deleteFile(alX);
            }
            if (s.YS(o2) && s.YS(alX2)) {
                Log.i(nVar.TAG, "cleanHevc: delete mid %s", s.k(alX2, false));
                s.deleteFile(alX2);
            }
        }
        AppMethodBeat.o(223627);
    }
}
