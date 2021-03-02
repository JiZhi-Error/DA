package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.an.f;
import com.tencent.mm.g.a.qx;
import com.tencent.mm.g.a.qz;
import com.tencent.mm.g.b.a.w;
import com.tencent.mm.g.b.a.y;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.c;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.network.m;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.f.b;
import com.tencent.mm.pluginsdk.f.d;
import com.tencent.mm.pluginsdk.f.g;
import com.tencent.mm.pluginsdk.g.c;
import com.tencent.mm.pluginsdk.model.app.ah;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.emy;
import com.tencent.mm.protocal.protobuf.emz;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.s;
import com.tencent.smtt.sdk.TbsListener;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public final class aj extends q implements m {
    c BGu = null;
    long BGw = -1;
    private boolean BiZ = true;
    private long JWM = -1;
    boolean JWN = false;
    i callback;
    k.b dCN = null;
    private boolean hmn = false;
    int hmp = 0;
    d hmq;
    IListener hms = new IListener<qz>() {
        /* class com.tencent.mm.pluginsdk.model.app.aj.AnonymousClass4 */

        {
            AppMethodBeat.i(232166);
            this.__eventId = qz.class.getName().hashCode();
            AppMethodBeat.o(232166);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(qz qzVar) {
            AppMethodBeat.i(232168);
            boolean a2 = a(qzVar);
            AppMethodBeat.o(232168);
            return a2;
        }

        private boolean a(qz qzVar) {
            k.b HD;
            AppMethodBeat.i(232167);
            if (!qzVar.dXz.filePath.equals(aj.this.BGu.field_fileFullPath)) {
                AppMethodBeat.o(232167);
            } else {
                String str = "";
                try {
                    str = URLEncoder.encode(qzVar.dXz.result, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
                } catch (UnsupportedEncodingException e2) {
                    Log.printErrStackTrace("MicroMsg.NetSceneUploadAppAttach", e2, "", new Object[0]);
                }
                if (aj.this.hmp == 1) {
                    bg.aVF();
                    ca Hb = c.aSQ().Hb(aj.this.BGu.field_msgInfoId);
                    com.tencent.mm.modelsns.m mVar = new com.tencent.mm.modelsns.m();
                    mVar.n("20toUser", aj.this.toUser + ",");
                    mVar.n("21source", "4,");
                    mVar.n("22qrUrl", str + ",");
                    mVar.n("23md5", (aj.this.hmq == null ? "" : aj.this.hmq.field_filemd5) + ",");
                    mVar.n("24cdnFileId", (aj.this.hmq == null ? "" : aj.this.hmq.field_fileId) + ",");
                    mVar.n("25cdnAesKey", (aj.this.hmq == null ? "" : aj.this.hmq.field_aesKey) + ",");
                    String str2 = "";
                    if (Hb.dOQ() && (HD = k.b.HD(Hb.field_content)) != null) {
                        str2 = HD.appId;
                    }
                    mVar.n("26appip", str2 + ",");
                    mVar.n("27toUsersCount", v.Ie(aj.this.toUser) + ",");
                    mVar.n("28codeType", Integer.valueOf(qzVar.dXz.dFL));
                    Log.i("MicroMsg.NetSceneUploadAppAttach", "report qrCodeImgChatting(13628): " + mVar.abW());
                    o.O(13628, mVar.toString());
                }
                EventCenter.instance.removeListener(aj.this.hms);
                AppMethodBeat.o(232167);
            }
            return false;
        }
    };
    String iYT = "";
    private g.a iZc = new g.a() {
        /* class com.tencent.mm.pluginsdk.model.app.aj.AnonymousClass3 */

        @Override // com.tencent.mm.i.g.a
        public final int a(String str, final int i2, com.tencent.mm.i.c cVar, final d dVar, boolean z) {
            AppMethodBeat.i(232164);
            Object[] objArr = new Object[7];
            objArr[0] = aj.this.iYT;
            objArr[1] = Integer.valueOf(i2);
            objArr[2] = cVar;
            objArr[3] = dVar;
            objArr[4] = Boolean.valueOf(cVar != null);
            objArr[5] = Boolean.valueOf(dVar != null);
            objArr[6] = Boolean.valueOf(z);
            Log.d("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s], progressing[%b], finish[%b], onlyCheckExist[%b]", objArr);
            ao.cgO().get(aj.this.BGw, aj.this.BGu);
            if (i2 == -21005) {
                Log.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", aj.this.iYT);
                AppMethodBeat.o(232164);
                return 0;
            } else if (i2 != 0) {
                m.HS(aj.this.BGu.systemRowid);
                ao.cgO().get(aj.this.BGw, aj.this.BGu);
                aj.this.BGu.field_signature = "";
                Log.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback startRet[%d] rowid[%d], reset signature ret[%b]", Integer.valueOf(i2), Long.valueOf(aj.this.BGw), Boolean.valueOf(ao.cgO().a(aj.this.BGu, new String[0])));
                aj.this.callback.onSceneEnd(3, i2, "", aj.this);
                new y(a.t(Integer.valueOf(i2), 1, Long.valueOf(aj.this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), 0, "")).bfK();
                AppMethodBeat.o(232164);
                return 0;
            } else if (aj.this.BGu.field_status == 105) {
                Log.i("MicroMsg.NetSceneUploadAppAttach", "attach upload has paused, status:%d, rowid:%d", Long.valueOf(aj.this.BGu.field_status), Long.valueOf(aj.this.BGw));
                f.baQ().Ob(aj.this.iYT);
                aj.this.callback.onSceneEnd(3, i2, "attach  has paused, status" + aj.this.BGu.field_status, aj.this);
                AppMethodBeat.o(232164);
                return 0;
            } else if (cVar != null) {
                aj.this.BGu.field_lastModifyTime = Util.nowSecond();
                aj.this.BGu.field_offset = cVar.field_finishedLength;
                boolean a2 = ao.cgO().a(aj.this.BGu, new String[0]);
                if (!a2) {
                    Log.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback onGYNetEnd update info ret:".concat(String.valueOf(a2)));
                    aj.this.retCode = -10000 - com.tencent.mm.compatible.util.f.getLine();
                    aj.this.callback.onSceneEnd(3, i2, "", aj.this);
                    AppMethodBeat.o(232164);
                    return 0;
                }
                AppMethodBeat.o(232164);
                return 0;
            } else {
                if (dVar != null) {
                    if (dVar.field_retCode != 0) {
                        Log.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback sceneResult.retCode :%d arg[%s] info[%s]", Integer.valueOf(dVar.field_retCode), dVar.field_arg, dVar.field_transInfo, "", "", "", "", "", "", "", dVar.gqk);
                        m.HS(aj.this.BGu.systemRowid);
                        ao.cgO().get(aj.this.BGw, aj.this.BGu);
                        aj.this.BGu.field_signature = "";
                        Log.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback startRet[%d] sceneResult.field_retCode[%d], rowid[%d], reset signature ret[%b]", Integer.valueOf(i2), Integer.valueOf(dVar.field_retCode), Long.valueOf(aj.this.BGw), Boolean.valueOf(ao.cgO().a(aj.this.BGu, new String[0])));
                        String t = a.t(Integer.valueOf(dVar.field_retCode), 1, Long.valueOf(aj.this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(dVar.field_fileLength), dVar.field_transInfo, "", "", "", "", "", "", "", dVar.gqk);
                        new y(t).bfK();
                        new w(t).bfK();
                        aj.this.callback.onSceneEnd(3, dVar.field_retCode, "", aj.this);
                    } else {
                        Log.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback upload attach by cdn, isHitCacheUpload: %d, onlyCheckExist[%b], exist[%b], signature[%s]", Integer.valueOf(dVar.field_UploadHitCacheType), Boolean.valueOf(z), Boolean.valueOf(dVar.field_exist_whencheck), Util.secPrint(aj.this.BGu.field_signature));
                        if (!z) {
                            a(i2, dVar);
                        } else if (dVar.field_exist_whencheck) {
                            bg.azz().a(new com.tencent.mm.pluginsdk.g.c(aj.this.dCN, aj.this.BGu.field_fileFullPath, aj.this.toUser, new c.a() {
                                /* class com.tencent.mm.pluginsdk.model.app.aj.AnonymousClass3.AnonymousClass1 */

                                @Override // com.tencent.mm.pluginsdk.g.c.a
                                public final void a(String str, String str2, String str3, String str4, String str5, String str6, long j2) {
                                    boolean z;
                                    AppMethodBeat.i(232159);
                                    Object[] objArr = new Object[8];
                                    objArr[0] = str;
                                    objArr[1] = str2;
                                    objArr[2] = Util.secPrint(str3);
                                    objArr[3] = Util.secPrint(str4);
                                    objArr[4] = Util.secPrint(str5);
                                    objArr[5] = Util.secPrint(str6);
                                    if (aj.this.dCN == null) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                    objArr[6] = Boolean.valueOf(z);
                                    objArr[7] = Boolean.valueOf(aj.this.iZk);
                                    Log.i("MicroMsg.NetSceneUploadAppAttach", "summerbig NetSceneCheckBigFileUpload exist_whencheck call back new errMsg:[%s], md5[%s], aesKey[%s], signature[%s], aesKey[%s], signature[%s], amc null[%b], enableHitcheck[%b]", objArr);
                                    if (Util.isNullOrNil(str4)) {
                                        bg.aVF();
                                        ca Hb = com.tencent.mm.model.c.aSQ().Hb(aj.this.BGu.field_msgInfoId);
                                        Hb.setStatus(5);
                                        bg.aVF();
                                        com.tencent.mm.model.c.aSQ().a(Hb.field_msgId, Hb);
                                        ca caVar = new ca();
                                        caVar.setCreateTime(bp.Kw(aj.this.toUser));
                                        caVar.Cy(aj.this.toUser);
                                        caVar.setContent(str);
                                        caVar.setType(10000);
                                        caVar.setStatus(6);
                                        caVar.nv(0);
                                        bg.aVF();
                                        com.tencent.mm.model.c.aSQ().aC(caVar);
                                        AppMethodBeat.o(232159);
                                        return;
                                    }
                                    aj.this.BGu.field_signature = str4;
                                    aj.this.BGu.field_fakeAeskey = str5;
                                    aj.this.BGu.field_fakeSignature = str6;
                                    AnonymousClass3.this.a(i2, dVar);
                                    AppMethodBeat.o(232159);
                                }
                            }), 0);
                        } else {
                            Log.i("MicroMsg.NetSceneUploadAppAttach", "summerbig upload check but not exist");
                            bg.azz().a(new com.tencent.mm.pluginsdk.g.c(null, aj.this.BGu.field_fileFullPath, aj.this.toUser, new c.a() {
                                /* class com.tencent.mm.pluginsdk.model.app.aj.AnonymousClass3.AnonymousClass2 */

                                @Override // com.tencent.mm.pluginsdk.g.c.a
                                public final void a(String str, String str2, String str3, String str4, String str5, String str6, long j2) {
                                    boolean z;
                                    AppMethodBeat.i(232161);
                                    Object[] objArr = new Object[8];
                                    objArr[0] = str;
                                    objArr[1] = str2;
                                    objArr[2] = Util.secPrint(str3);
                                    objArr[3] = Util.secPrint(str4);
                                    objArr[4] = Util.secPrint(str5);
                                    objArr[5] = Util.secPrint(str6);
                                    if (aj.this.dCN == null) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                    objArr[6] = Boolean.valueOf(z);
                                    objArr[7] = Boolean.valueOf(aj.this.iZk);
                                    Log.i("MicroMsg.NetSceneUploadAppAttach", "summerbig NetSceneCheckBigFileUpload not exist_whencheck call back new errMsg[%s], md5[%s], aesKey[%s], signature[%s], aesKey[%s], signature[%s], amc null[%b], enableHitcheck[%b]", objArr);
                                    if (Util.isNullOrNil(str4)) {
                                        bg.aVF();
                                        ca Hb = com.tencent.mm.model.c.aSQ().Hb(aj.this.BGu.field_msgInfoId);
                                        Hb.setStatus(5);
                                        bg.aVF();
                                        com.tencent.mm.model.c.aSQ().a(Hb.field_msgId, Hb);
                                        ca caVar = new ca();
                                        caVar.setCreateTime(bp.Kw(aj.this.toUser));
                                        caVar.Cy(aj.this.toUser);
                                        caVar.setContent(str);
                                        caVar.setType(10000);
                                        caVar.setStatus(6);
                                        caVar.nv(0);
                                        bg.aVF();
                                        com.tencent.mm.model.c.aSQ().aC(caVar);
                                        AppMethodBeat.o(232161);
                                        return;
                                    }
                                    aj.this.BGu.field_signature = str4;
                                    aj.this.BGu.field_fakeAeskey = str5;
                                    aj.this.BGu.field_fakeSignature = str6;
                                    aj.this.BGu.field_lastModifyTime = Util.nowMilliSecond();
                                    if (aj.this.dCN != null) {
                                        aj.this.dCN.filemd5 = str2;
                                        aj.this.dCN.aesKey = str3;
                                        aj.this.dCN.iwI = (int) j2;
                                        bg.aVF();
                                        ca Hb2 = com.tencent.mm.model.c.aSQ().Hb(aj.this.BGu.field_msgInfoId);
                                        Hb2.setContent(k.b.a(aj.this.dCN, null, null));
                                        bg.aVF();
                                        com.tencent.mm.model.c.aSQ().a(Hb2.field_msgId, Hb2);
                                    }
                                    aj.this.iZk = false;
                                    boolean a2 = ao.cgO().a(aj.this.BGu, new String[0]);
                                    if (!a2) {
                                        Log.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback onGYNetEnd update info ret:".concat(String.valueOf(a2)));
                                        aj.this.retCode = -10000 - com.tencent.mm.compatible.util.f.getLine();
                                        aj.this.callback.onSceneEnd(3, i2, "", aj.this);
                                        AppMethodBeat.o(232161);
                                        return;
                                    }
                                    bg.aAk().postToWorker(new Runnable() {
                                        /* class com.tencent.mm.pluginsdk.model.app.aj.AnonymousClass3.AnonymousClass2.AnonymousClass1 */

                                        public final void run() {
                                            AppMethodBeat.i(232160);
                                            Log.i("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene again");
                                            aj.this.doScene(aj.this.dispatcher(), aj.this.callback);
                                            AppMethodBeat.o(232160);
                                        }
                                    });
                                    AppMethodBeat.o(232161);
                                }
                            }), 0);
                        }
                    }
                }
                AppMethodBeat.o(232164);
                return 0;
            }
        }

        /* access modifiers changed from: package-private */
        public final void a(int i2, final d dVar) {
            AppMethodBeat.i(232165);
            aj.this.BGu.field_status = 199;
            boolean a2 = ao.cgO().a(aj.this.BGu, new String[0]);
            if (!a2) {
                Log.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback onGYNetEnd update info ret:".concat(String.valueOf(a2)));
                aj.this.retCode = -10000 - com.tencent.mm.compatible.util.f.getLine();
                aj.this.callback.onSceneEnd(3, i2, "", aj.this);
                AppMethodBeat.o(232165);
                return;
            }
            m.a(aj.this.BGu.field_msgInfoId, aj.this.BGu.field_mediaSvrId, dVar, true);
            bg.azz().a(new ah(aj.this.BGu.field_msgInfoId, true, dVar, (ah.a) new ah.a() {
                /* class com.tencent.mm.pluginsdk.model.app.aj.AnonymousClass3.AnonymousClass3 */

                @Override // com.tencent.mm.pluginsdk.model.app.ah.a
                public final void dq(int i2, int i3) {
                    AppMethodBeat.i(232163);
                    Log.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra NetSceneSendAppMsgForCdn callback %d,%d", Integer.valueOf(i2), Integer.valueOf(i3));
                    if (i2 == 4 && i3 == 102) {
                        bg.aAk().postToWorker(new Runnable() {
                            /* class com.tencent.mm.pluginsdk.model.app.aj.AnonymousClass3.AnonymousClass3.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(232162);
                                aj.this.iZk = false;
                                aj.this.BGu.field_createTime = Util.nowMilliSecond();
                                aj.this.BGu.field_lastModifyTime = Util.nowSecond();
                                aj.this.BGu.field_offset = 0;
                                aj.this.BGu.field_status = 101;
                                Log.i("MicroMsg.NetSceneUploadAppAttach", "summersafecdn MM_ERR_GET_AESKEY_FAILED doScene again enableHitcheck[%b], ret[%b] new createtime:%d", Boolean.valueOf(aj.this.iZk), Boolean.valueOf(ao.cgO().a(aj.this.BGu, new String[0])), Long.valueOf(aj.this.BGu.field_createTime));
                                aj.this.doScene(aj.this.dispatcher(), aj.this.callback);
                                AppMethodBeat.o(232162);
                            }
                        });
                        AppMethodBeat.o(232163);
                        return;
                    }
                    new y(a.t(Integer.valueOf(i3), 1, Long.valueOf(aj.this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(dVar.field_fileLength), dVar.field_transInfo, "", "", "", "", "", "", "", dVar.gqk)).bfK();
                    if (i2 == 0 && i3 == 0) {
                        aj.this.e(dVar);
                    }
                    aj.this.callback.onSceneEnd(i2, i3, "", aj.this);
                    AppMethodBeat.o(232163);
                }
            }, aj.this.sessionId, aj.this.BGu), 0);
            AppMethodBeat.o(232165);
        }

        @Override // com.tencent.mm.i.g.a
        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        }

        @Override // com.tencent.mm.i.g.a
        public final byte[] f(String str, byte[] bArr) {
            return null;
        }
    };
    boolean iZk = true;
    private d.a iZw = new d.a() {
        /* class com.tencent.mm.pluginsdk.model.app.aj.AnonymousClass1 */

        @Override // com.tencent.mm.pluginsdk.f.d.a
        public final void a(g.a aVar) {
            AppMethodBeat.i(232154);
            Log.i("MicroMsg.NetSceneUploadAppAttach", "upload success, field_aesKey:%s, fileId:%s, fileLen:%s", aVar.aesKey, aVar.fileId, Long.valueOf(aVar.jPY));
            long nowMilliSecond = Util.nowMilliSecond();
            long j2 = nowMilliSecond - aj.this.startTime;
            long j3 = aVar.jPY;
            h.INSTANCE.a(10420, 0, 1, Long.valueOf(aj.this.startTime), Long.valueOf(nowMilliSecond), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(j3), Long.valueOf(j3 / j2), 1);
            com.tencent.mm.i.d dVar = new com.tencent.mm.i.d();
            dVar.field_aesKey = aVar.aesKey;
            dVar.field_fileId = aVar.fileId;
            dVar.field_filemd5 = aVar.pkL;
            dVar.field_fileLength = aVar.jPY;
            f.baR();
            dVar.field_filecrc = com.tencent.mm.an.a.NW(aj.this.BGu.field_fileFullPath);
            aj ajVar = aj.this;
            ajVar.BGu.field_status = 199;
            boolean a2 = ao.cgO().a(ajVar.BGu, new String[0]);
            if (!a2) {
                Log.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback onGYNetEnd update info ret:".concat(String.valueOf(a2)));
                ajVar.retCode = -10000 - com.tencent.mm.compatible.util.f.getLine();
                ajVar.callback.onSceneEnd(3, 0, "", ajVar);
                AppMethodBeat.o(232154);
                return;
            }
            m.a(ajVar.BGu.field_msgInfoId, ajVar.BGu.field_mediaSvrId, dVar, true);
            bg.azz().a(new ah(ajVar.BGu.field_msgInfoId, true, dVar, (ah.a) new ah.a() {
                /* class com.tencent.mm.pluginsdk.model.app.aj.AnonymousClass2 */

                {
                    AppMethodBeat.i(161480);
                    AppMethodBeat.o(161480);
                }

                @Override // com.tencent.mm.pluginsdk.model.app.ah.a
                public final void dq(int i2, int i3) {
                    AppMethodBeat.i(232158);
                    Log.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra NetSceneSendAppMsgForCdn callback %d,%d", Integer.valueOf(i2), Integer.valueOf(i3));
                    if (i2 == 4 && i3 == 102) {
                        bg.aAk().postToWorker(new Runnable() {
                            /* class com.tencent.mm.pluginsdk.model.app.aj.AnonymousClass2.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(232157);
                                aj.this.iZk = false;
                                aj.this.BGu.field_createTime = Util.nowMilliSecond();
                                aj.this.BGu.field_lastModifyTime = Util.nowSecond();
                                aj.this.BGu.field_offset = 0;
                                aj.this.BGu.field_status = 101;
                                Log.i("MicroMsg.NetSceneUploadAppAttach", "summersafecdn MM_ERR_GET_AESKEY_FAILED doScene again enableHitcheck[%b], ret[%b] new createtime:%d", Boolean.valueOf(aj.this.iZk), Boolean.valueOf(ao.cgO().a(aj.this.BGu, new String[0])), Long.valueOf(aj.this.BGu.field_createTime));
                                aj.this.doScene(aj.this.dispatcher(), aj.this.callback);
                                AppMethodBeat.o(232157);
                            }
                        });
                        AppMethodBeat.o(232158);
                        return;
                    }
                    aj.this.callback.onSceneEnd(i2, i3, "", aj.this);
                    AppMethodBeat.o(232158);
                }
            }, ajVar.sessionId, ajVar.BGu), 0);
            AppMethodBeat.o(232154);
        }

        @Override // com.tencent.mm.pluginsdk.f.d.a
        public final void M(int i2, String str) {
            AppMethodBeat.i(232155);
            Log.e("MicroMsg.NetSceneUploadAppAttach", "onUploadFailure, errCode:%s, uploadID:%s", Integer.valueOf(i2), str);
            h.INSTANCE.a(10420, Integer.valueOf(i2), 1, Long.valueOf(aj.this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), 0, 0, 0);
            m.HS(aj.this.BGu.systemRowid);
            ao.cgO().get(aj.this.BGw, aj.this.BGu);
            aj.this.BGu.field_signature = "";
            Log.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback startRet[%d] rowid[%d], reset signature ret[%b]", -1, Long.valueOf(aj.this.BGw), Boolean.valueOf(ao.cgO().a(aj.this.BGu, new String[0])));
            aj.this.callback.onSceneEnd(3, i2, "", aj.this);
            AppMethodBeat.o(232155);
        }

        @Override // com.tencent.mm.pluginsdk.f.d.a
        public final void a(float f2, long j2) {
            AppMethodBeat.i(232156);
            aj.this.BGu.field_lastModifyTime = Util.nowSecond();
            if (aj.this.BGu.field_offset < j2) {
                aj.this.BGu.field_offset = j2;
            }
            boolean a2 = ao.cgO().a(aj.this.BGu, new String[0]);
            if (!a2) {
                Log.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback onGYNetEnd update info ret:".concat(String.valueOf(a2)));
                aj.this.retCode = -10000 - com.tencent.mm.compatible.util.f.getLine();
                aj.this.callback.onSceneEnd(3, -1, "", aj.this);
            }
            AppMethodBeat.o(232156);
        }
    };
    private String iwK = null;
    int retCode = 0;
    private com.tencent.mm.ak.d rr;
    String sessionId;
    long startTime = 0;
    String toUser;

    public aj(long j2, String str, String str2) {
        AppMethodBeat.i(31073);
        this.BGw = j2;
        this.iwK = str;
        this.sessionId = str2;
        d.a aVar = new d.a();
        aVar.iLN = new emy();
        aVar.iLO = new emz();
        aVar.uri = "/cgi-bin/micromsg-bin/uploadappattach";
        aVar.funcId = TbsListener.ErrorCode.COPY_INSTALL_SUCCESS;
        aVar.iLP = 105;
        aVar.respCmdId = 1000000105;
        this.rr = aVar.aXF();
        Log.i("MicroMsg.NetSceneUploadAppAttach", "summerbig new NetSceneUploadAppAttach rowid[%d], emoticonmd5[%s], stack[%s]", Long.valueOf(j2), str, Util.getStack());
        AppMethodBeat.o(31073);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        boolean z;
        boolean z2;
        byte[] aW;
        boolean z3;
        String str;
        int Kp;
        String str2;
        int Kp2;
        AppMethodBeat.i(31074);
        this.callback = iVar;
        this.JWN = false;
        this.BGu = new c();
        if (!ao.cgO().get(this.BGw, this.BGu) || this.BGu == null) {
            Log.e("MicroMsg.NetSceneUploadAppAttach", com.tencent.mm.compatible.util.f.apq() + " summerbig get info failed rowid:" + this.BGw);
            this.retCode = -10000 - com.tencent.mm.compatible.util.f.getLine();
            this.BGu = null;
            AppMethodBeat.o(31074);
            return -1;
        } else if (this.BGu.field_status != 101) {
            Log.e("MicroMsg.NetSceneUploadAppAttach", com.tencent.mm.compatible.util.f.apq() + " summerbig get field_status failed rowid:" + this.BGw + " status:" + this.BGu.field_status);
            AppMethodBeat.o(31074);
            return -1;
        } else {
            if (this.startTime == 0) {
                this.startTime = Util.nowMilliSecond();
                this.JWM = this.BGu.field_offset;
            }
            Log.i("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene rowid[%d], fileFullPath[%s], totalLen[%d],isUpload[%b], isUseCdn[%b], type[%d]", Long.valueOf(this.BGw), this.BGu.field_fileFullPath, Long.valueOf(this.BGu.field_totalLen), Boolean.valueOf(this.BGu.field_isUpload), Integer.valueOf(this.BGu.field_isUseCdn), Long.valueOf(this.BGu.field_type));
            if (Util.isNullOrNil(this.BGu.field_appId)) {
                Log.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene checkArgs : appId is null");
                if (!(this.BGu.field_type == 8 || this.BGu.field_type == 6)) {
                    this.retCode = -10000 - com.tencent.mm.compatible.util.f.getLine();
                    AppMethodBeat.o(31074);
                    return -1;
                }
            }
            if (this.BGu.field_type == 8 || this.BGu.field_type == 9) {
                Log.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra cdn not support Emoji or voiceremind now type:%d", Long.valueOf(this.BGu.field_type));
                z = false;
            } else if (!b.gmg()) {
                Log.i("MicroMsg.NetSceneUploadAppAttach", "isAllow2UseCdnWithXLab = false");
                z = false;
            } else {
                f.baQ();
                if (com.tencent.mm.an.b.sS(4) || this.BGu.field_isUseCdn == 1) {
                    bg.aVF();
                    ca Hb = com.tencent.mm.model.c.aSQ().Hb(this.BGu.field_msgInfoId);
                    if (Hb.field_msgId != this.BGu.field_msgInfoId) {
                        Log.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra read msg info failed msgId[%d], rowid[%d], createtime[%d], len[%d], status[%d], upload[%b], useCdn[%d], mediaId[%s]", Long.valueOf(this.BGu.field_msgInfoId), Long.valueOf(this.BGu.systemRowid), Long.valueOf(this.BGu.field_createTime), Long.valueOf(this.BGu.field_totalLen), Long.valueOf(this.BGu.field_status), Boolean.valueOf(this.BGu.field_isUpload), Integer.valueOf(this.BGu.field_isUseCdn), this.BGu.field_mediaId);
                        this.toUser = null;
                        z = false;
                    } else {
                        this.toUser = Hb.field_talker;
                        String str3 = "";
                        if (!Util.isNullOrNil(Hb.field_imgPath)) {
                            str3 = com.tencent.mm.av.q.bcR().Oz(Hb.field_imgPath);
                        }
                        int boW = (int) s.boW(str3);
                        int boW2 = (int) s.boW(this.BGu.field_fileFullPath);
                        if (boW >= 262144) {
                            Log.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra thumb[%s][%d] Too Big Not Use CDN TRANS", str3, Integer.valueOf(boW));
                            z = false;
                        } else {
                            this.iYT = com.tencent.mm.an.c.a("upattach", this.BGu.field_createTime, Hb.field_talker, new StringBuilder().append(this.BGw).toString());
                            Log.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra genClientId field_createTime[%d], useCdnTransClientId[%s]", Long.valueOf(this.BGu.field_createTime), this.iYT);
                            if (Util.isNullOrNil(this.iYT)) {
                                Log.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra genClientId failed not use cdn rowid:%d", Long.valueOf(this.BGw));
                                z = false;
                            } else {
                                com.tencent.mm.i.g gVar2 = new com.tencent.mm.i.g();
                                gVar2.taskName = "task_NetSceneUploadAppAttach";
                                boolean z4 = false;
                                String str4 = Hb.field_content;
                                if (ab.Eq(Hb.field_talker) && (Kp2 = bp.Kp(Hb.field_content)) != -1) {
                                    str4 = (Hb.field_content + " ").substring(Kp2 + 2).trim();
                                }
                                this.dCN = k.b.HD(Util.processXml(str4));
                                if (this.dCN != null) {
                                    Log.d("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra amc.cdnAttachUrl[%s], amc.aesKey[%s], amc.filemd5[%s], amc.type[%d]", this.dCN.iwW, Util.secPrint(this.dCN.aesKey), this.dCN.filemd5, Integer.valueOf(this.dCN.type));
                                    gVar2.field_fileId = this.dCN.iwW;
                                    gVar2.field_aesKey = this.dCN.aesKey;
                                    gVar2.field_filemd5 = this.dCN.filemd5;
                                    z4 = this.dCN.iwM != 0 || this.dCN.iwI > 26214400;
                                } else {
                                    Log.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra parse content xml failed");
                                }
                                int i2 = z4 ? com.tencent.mm.i.a.gpO : com.tencent.mm.i.a.MediaType_FILE;
                                gVar2.field_appType = 0;
                                gVar2.gqy = this.iZc;
                                gVar2.field_mediaId = this.iYT;
                                gVar2.field_fullpath = this.BGu.field_fileFullPath;
                                gVar2.field_thumbpath = str3;
                                gVar2.field_fileType = i2;
                                gVar2.field_svr_signature = z4 ? Util.nullAsNil(this.BGu.field_signature) : "";
                                gVar2.field_onlycheckexist = z4 ? Util.isNullOrNil(this.BGu.field_signature) : false;
                                gVar2.field_fake_bigfile_signature_aeskey = this.BGu.field_fakeAeskey;
                                gVar2.field_fake_bigfile_signature = this.BGu.field_fakeSignature;
                                gVar2.field_talker = Hb.field_talker;
                                gVar2.field_priority = com.tencent.mm.i.a.gpM;
                                gVar2.field_totalLen = boW2;
                                gVar2.field_needStorage = false;
                                gVar2.field_isStreamMedia = false;
                                gVar2.field_enable_hitcheck = this.iZk;
                                gVar2.field_chattype = ab.Eq(Hb.field_talker) ? 1 : 0;
                                gVar2.field_force_aeskeycdn = false;
                                gVar2.field_trysafecdn = true;
                                gVar2.field_bzScene = 0;
                                gVar2.field_use_multithread = com.tencent.mm.an.c.baL() && z4;
                                Log.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra checkUseCdn field_use_multithread[%s], msgId:%d file[%s][%d] thumb[%s][%d], useCdnTransClientId[%s], fileType[%d], enable_hitcheck[%b], onlycheckexist[%b] force_aeskeycdn[%b] trysafecdn[%b] aeskey[%s], md5[%s], signature[%s], faeskey[%s], fsignature[%s]", Boolean.valueOf(gVar2.field_use_multithread), Long.valueOf(this.BGu.field_msgInfoId), gVar2.field_fullpath, Integer.valueOf(boW2), str3, Integer.valueOf(boW), this.iYT, Integer.valueOf(gVar2.field_fileType), Boolean.valueOf(gVar2.field_enable_hitcheck), Boolean.valueOf(gVar2.field_onlycheckexist), Boolean.valueOf(gVar2.field_force_aeskeycdn), Boolean.valueOf(gVar2.field_trysafecdn), Util.secPrint(gVar2.field_aesKey), gVar2.field_filemd5, Util.secPrint(gVar2.field_svr_signature), Util.secPrint(gVar2.field_fake_bigfile_signature_aeskey), Util.secPrint(gVar2.field_fake_bigfile_signature));
                                if (!f.baQ().f(gVar2)) {
                                    Log.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra addSendTask failed.");
                                    this.iYT = "";
                                    z = false;
                                } else {
                                    if (this.BGu.field_isUseCdn != 1) {
                                        this.BGu.field_isUseCdn = 1;
                                        boolean a2 = ao.cgO().a(this.BGu, new String[0]);
                                        if (!a2) {
                                            Log.e("MicroMsg.NetSceneUploadAppAttach", "summerbig checkUseCdn update info ret:".concat(String.valueOf(a2)));
                                            this.retCode = -10000 - com.tencent.mm.compatible.util.f.getLine();
                                            this.callback.onSceneEnd(3, -1, "", this);
                                            z = false;
                                        }
                                    }
                                    Log.i("MicroMsg.NetSceneUploadAppAttach", "summerbig checkUseCdn ret true useCdnTransClientId[%s]", this.iYT);
                                    z = true;
                                }
                            }
                        }
                    }
                } else {
                    f.baQ();
                    Log.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra not use cdn flag:%b getCdnInfo:%d", Boolean.valueOf(com.tencent.mm.an.b.sS(4)), Integer.valueOf(this.BGu.field_isUseCdn));
                    z = false;
                }
            }
            if (z) {
                Log.d("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene cdntra use cdn return -1 for onGYNetEnd client rowid:%d", Long.valueOf(this.BGw));
                AppMethodBeat.o(31074);
                return 0;
            }
            if (this.BGu.field_type == 8 || this.BGu.field_type == 9) {
                Log.i("MicroMsg.NetSceneUploadAppAttach", "summerbig parallel-upload support Emoji or voiceremind now type:%d", Long.valueOf(this.BGu.field_type));
                z2 = false;
            } else {
                if (1 == ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_parallel_upload_file_android, 0)) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (!z3) {
                    Log.i("MicroMsg.NetSceneUploadAppAttach", "NOT ALLOW USE PARALLEL UPLOAD APP ATTACH");
                    z2 = false;
                } else {
                    bg.aVF();
                    ca Hb2 = com.tencent.mm.model.c.aSQ().Hb(this.BGu.field_msgInfoId);
                    if (Hb2.field_msgId != this.BGu.field_msgInfoId) {
                        Log.w("MicroMsg.NetSceneUploadAppAttach", "#parallel-upload# read msg info failed msgId[%d], rowid[%d], createtime[%d], len[%d], status[%d], upload[%b], useCdn[%d], mediaId[%s]", Long.valueOf(this.BGu.field_msgInfoId), Long.valueOf(this.BGu.systemRowid), Long.valueOf(this.BGu.field_createTime), Long.valueOf(this.BGu.field_totalLen), Long.valueOf(this.BGu.field_status), Boolean.valueOf(this.BGu.field_isUpload), Integer.valueOf(this.BGu.field_isUseCdn), this.BGu.field_mediaId);
                        this.toUser = null;
                        z2 = false;
                    } else {
                        String str5 = "";
                        if (!Util.isNullOrNil(Hb2.field_imgPath)) {
                            str5 = com.tencent.mm.av.q.bcR().Oz(Hb2.field_imgPath);
                        }
                        com.tencent.mm.pluginsdk.f.d dVar = new com.tencent.mm.pluginsdk.f.d();
                        dVar.iXv = gnc();
                        dVar.JTT = this.iZw;
                        dVar.scene = 3;
                        dVar.fileType = 5;
                        dVar.thumbPath = str5;
                        dVar.fullPath = this.BGu.field_fileFullPath;
                        com.tencent.mm.pluginsdk.f.c cVar = new com.tencent.mm.pluginsdk.f.c();
                        bg.aVF();
                        ca Hb3 = com.tencent.mm.model.c.aSQ().Hb(this.BGu.field_msgInfoId);
                        if (Hb3.field_msgId != this.BGu.field_msgInfoId) {
                            Log.w("MicroMsg.NetSceneUploadAppAttach", "#parallel-upload# read msg info failed msgId[%d], rowid[%d], createtime[%d], len[%d], status[%d], upload[%b], useCdn[%d], mediaId[%s]", Long.valueOf(this.BGu.field_msgInfoId), Long.valueOf(this.BGu.systemRowid), Long.valueOf(this.BGu.field_createTime), Long.valueOf(this.BGu.field_totalLen), Long.valueOf(this.BGu.field_status), Boolean.valueOf(this.BGu.field_isUpload), Integer.valueOf(this.BGu.field_isUseCdn), this.BGu.field_mediaId);
                            this.toUser = null;
                            str = "";
                        } else {
                            String str6 = Hb3.field_content;
                            if (ab.Eq(Hb3.field_talker) && (Kp = bp.Kp(Hb3.field_content)) != -1) {
                                str6 = (Hb3.field_content + " ").substring(Kp + 2).trim();
                            }
                            this.dCN = k.b.HD(str6);
                            if ((this.dCN == null || this.dCN.iwM == 0) && this.dCN.iwI <= 26214400) {
                                Log.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra parse content xml failed");
                                str = "";
                            } else {
                                Log.d("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra amc.cdnAttachUrl[%s], amc.aesKey[%s], amc.filemd5[%s], amc.type[%d]", this.dCN.iwW, Util.secPrint(this.dCN.aesKey), this.dCN.filemd5, Integer.valueOf(this.dCN.type));
                                str = this.dCN.aesKey;
                            }
                        }
                        if (this.BGu != null) {
                            str2 = this.BGu.field_signature;
                        } else {
                            str2 = null;
                        }
                        cVar.JTD = str2;
                        cVar.JTE = str;
                        cVar.a(dVar);
                        this.JWN = true;
                        z2 = true;
                    }
                }
            }
            if (z2) {
                Log.d("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene use parallel-upload return -1 for onGYNetEnd client rowid:%d", Long.valueOf(this.BGw));
                AppMethodBeat.o(31074);
                return 0;
            } else if (this.BGu.field_netTimes > 3200) {
                m.HS(this.BGu.systemRowid);
                Log.e("MicroMsg.NetSceneUploadAppAttach", com.tencent.mm.compatible.util.f.apq() + " summerbig doScene info.field_netTimes > DOSCENE_LIMIT SET ERROR! rowid:" + this.BGw);
                AppMethodBeat.o(31074);
                return -1;
            } else {
                this.BGu.field_netTimes++;
                if (Util.isNullOrNil(this.BGu.field_clientAppDataId)) {
                    Log.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene checkArgs : clientAppDataId is null");
                    this.retCode = -10000 - com.tencent.mm.compatible.util.f.getLine();
                    AppMethodBeat.o(31074);
                    return -1;
                } else if (this.BGu.field_totalLen <= 0 || this.BGu.field_totalLen > 26214400) {
                    Log.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene checkArgs : totalLen is invalid, totalLen = " + this.BGu.field_totalLen);
                    this.retCode = -10000 - com.tencent.mm.compatible.util.f.getLine();
                    if (this.BGu.field_totalLen > 26214400) {
                        m.HS(this.BGu.systemRowid);
                    }
                    AppMethodBeat.o(31074);
                    return -1;
                } else if (Util.isNullOrNil(this.BGu.field_fileFullPath)) {
                    Log.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene checkArgs : fileFullPath is null");
                    this.retCode = -10000 - com.tencent.mm.compatible.util.f.getLine();
                    AppMethodBeat.o(31074);
                    return -1;
                } else if (((int) s.boW(this.BGu.field_fileFullPath)) > 26214400) {
                    Log.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene doScene : file is too large");
                    m.HS(this.BGu.systemRowid);
                    AppMethodBeat.o(31074);
                    return -1;
                } else {
                    if (Util.isNullOrNil(this.iwK)) {
                        aW = s.aW(this.BGu.field_fileFullPath, (int) this.BGu.field_offset, 8192);
                    } else {
                        aW = s.aW(this.BGu.field_fileFullPath, (int) this.BGu.field_offset, 32768);
                    }
                    if (Util.isNullOrNil(aW)) {
                        Log.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene doScene : data is null");
                        this.retCode = -10000 - com.tencent.mm.compatible.util.f.getLine();
                        AppMethodBeat.o(31074);
                        return -1;
                    }
                    emy emy = (emy) this.rr.iLK.iLR;
                    emy.jfi = this.BGu.field_appId;
                    emy.KIy = (int) this.BGu.field_sdkVer;
                    emy.NkS = this.BGu.field_clientAppDataId;
                    emy.oUv = (int) this.BGu.field_type;
                    emy.UserName = z.aTY();
                    emy.BsF = (int) this.BGu.field_totalLen;
                    emy.BsG = (int) this.BGu.field_offset;
                    if (this.iwK == null || !this.BiZ) {
                        emy.BsH = aW.length;
                        emy.BsI = new SKBuiltinBuffer_t().setBuffer(aW);
                        if (this.iwK != null) {
                            emy.MD5 = this.iwK;
                        }
                        int dispatch = dispatch(gVar, this.rr, this);
                        AppMethodBeat.o(31074);
                        return dispatch;
                    }
                    emy.MD5 = this.iwK;
                    emy.BsF = (int) this.BGu.field_totalLen;
                    emy.BsH = 0;
                    emy.BsI = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
                    this.BiZ = false;
                    int dispatch2 = dispatch(gVar, this.rr, this);
                    AppMethodBeat.o(31074);
                    return dispatch2;
                }
            }
        }
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, com.tencent.mm.network.s sVar, byte[] bArr) {
        AppMethodBeat.i(31075);
        Log.d("MicroMsg.NetSceneUploadAppAttach", "onGYNetEnd : errType = " + i3 + ", errCode = " + i4);
        if (i3 == 3 && i4 == -1 && !Util.isNullOrNil(this.iYT)) {
            Log.w("MicroMsg.NetSceneUploadAppAttach", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", this.iYT);
            AppMethodBeat.o(31075);
        } else if (i3 == 0 && i4 == 0) {
            emz emz = (emz) ((com.tencent.mm.ak.d) sVar).iLL.iLR;
            if (emz.jfi != null && this.iwK == null && (!emz.jfi.equals(this.BGu.field_appId) || !emz.NkS.equals(this.BGu.field_clientAppDataId))) {
                Log.e("MicroMsg.NetSceneUploadAppAttach", "argument is not consistent");
                this.retCode = -10000 - com.tencent.mm.compatible.util.f.getLine();
                this.callback.onSceneEnd(3, -1, "", this);
                AppMethodBeat.o(31075);
            } else if (emz.BsF < 0 || ((long) emz.BsF) != this.BGu.field_totalLen || emz.BsG < 0 || ((long) emz.BsG) > this.BGu.field_totalLen) {
                Log.e("MicroMsg.NetSceneUploadAppAttach", "dataLen, startPos or totalLen is incorrect");
                this.retCode = -10000 - com.tencent.mm.compatible.util.f.getLine();
                this.callback.onSceneEnd(3, -1, "", this);
                AppMethodBeat.o(31075);
            } else {
                this.BGu.field_offset = (long) emz.BsG;
                this.BGu.field_mediaSvrId = m.bdH(emz.jfl) ? emz.jfl : "";
                if (this.BGu.field_status == 105) {
                    Log.w("MicroMsg.NetSceneUploadAppAttach", "onGYNetEnd STATUS PAUSE [" + this.BGu.field_mediaSvrId + "," + this.BGu.field_offset + "] ");
                    this.callback.onSceneEnd(i3, -1, "", this);
                    AppMethodBeat.o(31075);
                    return;
                }
                if (this.BGu.field_offset == this.BGu.field_totalLen) {
                    if (Util.isNullOrNil(this.BGu.field_mediaSvrId)) {
                        Log.e("MicroMsg.NetSceneUploadAppAttach", "finish upload but mediaid == null!");
                        this.retCode = -10000 - com.tencent.mm.compatible.util.f.getLine();
                        this.callback.onSceneEnd(3, -1, "", this);
                        m.HS(this.BGu.systemRowid);
                        AppMethodBeat.o(31075);
                        return;
                    }
                    this.BGu.field_status = 199;
                    h.INSTANCE.a(10420, 0, 1, Long.valueOf(this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(this.BGu.field_totalLen - this.JWM));
                }
                boolean a2 = ao.cgO().a(this.BGu, new String[0]);
                if (!a2) {
                    Log.e("MicroMsg.NetSceneUploadAppAttach", "onGYNetEnd update info ret:".concat(String.valueOf(a2)));
                    this.retCode = -10000 - com.tencent.mm.compatible.util.f.getLine();
                    e(null);
                    this.callback.onSceneEnd(3, -1, "", this);
                    AppMethodBeat.o(31075);
                } else if (this.BGu.field_status == 199) {
                    this.callback.onSceneEnd(0, 0, "", this);
                    AppMethodBeat.o(31075);
                } else {
                    if (doScene(dispatcher(), this.callback) < 0) {
                        Log.e("MicroMsg.NetSceneUploadAppAttach", "onGYNetEnd : doScene fail");
                        this.callback.onSceneEnd(3, -1, "", this);
                    }
                    AppMethodBeat.o(31075);
                }
            }
        } else {
            Log.e("MicroMsg.NetSceneUploadAppAttach", "onGYNetEnd : errType = " + i3 + ", errCode = " + i4);
            this.retCode = -10000 - com.tencent.mm.compatible.util.f.getLine();
            if (i3 == 4) {
                h.INSTANCE.a(10420, Integer.valueOf(i4), 1, Long.valueOf(this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(this.BGu.field_totalLen - this.JWM));
            }
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(31075);
        }
    }

    @Override // com.tencent.mm.ak.q
    public final int securityLimitCount() {
        return 3200;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return TbsListener.ErrorCode.COPY_INSTALL_SUCCESS;
    }

    @Override // com.tencent.mm.ak.q
    public final q.b securityVerificationChecked(com.tencent.mm.network.s sVar) {
        return q.b.EOk;
    }

    public final long gnc() {
        if (this.BGu == null) {
            return 0;
        }
        return this.BGu.field_msgInfoId;
    }

    /* access modifiers changed from: package-private */
    public final void e(com.tencent.mm.i.d dVar) {
        AppMethodBeat.i(31076);
        if (this.BGu.field_type != 2) {
            AppMethodBeat.o(31076);
            return;
        }
        com.tencent.mm.storage.c Fu = com.tencent.mm.model.c.d.aXu().Fu("100131");
        if (Fu.isValid()) {
            this.hmp = af.getInt(Fu.gzz().get("needUploadData"), 1);
        }
        if (this.hmn || this.hmp == 0) {
            AppMethodBeat.o(31076);
            return;
        }
        this.hmq = dVar;
        this.hmn = true;
        qx qxVar = new qx();
        EventCenter.instance.addListener(this.hms);
        qxVar.dXu.filePath = this.BGu.field_fileFullPath;
        qxVar.dXu.dDZ = System.currentTimeMillis();
        EventCenter.instance.publish(qxVar);
        AppMethodBeat.o(31076);
    }
}
