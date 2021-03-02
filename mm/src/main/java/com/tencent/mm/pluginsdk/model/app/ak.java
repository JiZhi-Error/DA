package com.tencent.mm.pluginsdk.model.app;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.an.f;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.handoff.model.HandOffFile;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.emy;
import com.tencent.mm.protocal.protobuf.emz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import com.tencent.smtt.sdk.TbsListener;
import java.io.ByteArrayOutputStream;

public final class ak extends q implements m {
    private static final long JWT = (((long) ((b) g.af(b.class)).a(b.a.clicfg_handoff_uploading_interval, 5)) * 1000);
    private c BGu;
    private long JWM = -1;
    private i callback;
    private Handler handler = new a(this, (byte) 0);
    private String iYT = "";
    private g.a iZc = new g.a() {
        /* class com.tencent.mm.pluginsdk.model.app.ak.AnonymousClass1 */

        @Override // com.tencent.mm.i.g.a
        public final int a(String str, int i2, c cVar, d dVar, boolean z) {
            AppMethodBeat.i(31077);
            Object[] objArr = new Object[7];
            objArr[0] = ak.this.iYT;
            objArr[1] = Integer.valueOf(i2);
            objArr[2] = cVar;
            objArr[3] = dVar;
            objArr[4] = Boolean.valueOf(cVar != null);
            objArr[5] = Boolean.valueOf(dVar != null);
            objArr[6] = Boolean.valueOf(z);
            Log.d("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s], progressing[%b], finish[%b], onlyCheckExist[%b]", objArr);
            if (i2 == -21005) {
                Log.i("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig cdnCallback ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", ak.this.iYT);
                ak.this.raZ = false;
                ak.this.handler.removeMessages(1);
                AppMethodBeat.o(31077);
                return 0;
            } else if (i2 != 0) {
                ak.this.raZ = false;
                ak.this.handler.removeMessages(1);
                ((com.tencent.mm.plugin.handoff.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).m23if(ak.this.id, "");
                AppMethodBeat.o(31077);
                return 0;
            } else if (ak.this.BGu.field_status == 105) {
                Log.i("MicroMsg.NetSceneUploadAppAttachForHandOff", "attach upload has paused, status:%d", Long.valueOf(ak.this.BGu.field_status));
                ak.this.raZ = false;
                ak.this.handler.removeMessages(1);
                f.baQ().Ob(ak.this.iYT);
                AppMethodBeat.o(31077);
                return 0;
            } else if (cVar != null) {
                ak.this.BGu.field_lastModifyTime = Util.nowSecond();
                ak.this.BGu.field_offset = cVar.field_finishedLength;
                ak.this.uploadedSize = ak.this.BGu.field_offset;
                AppMethodBeat.o(31077);
                return 0;
            } else {
                if (dVar != null) {
                    if (dVar.field_retCode != 0) {
                        Log.e("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig cdnCallback sceneResult.retCode :%d arg[%s] info[%s]", Integer.valueOf(dVar.field_retCode), dVar.field_arg, dVar.field_transInfo, "", "", "", "", "", "", "", dVar.gqk);
                        ak.this.raZ = false;
                        ak.this.handler.removeMessages(1);
                        ((com.tencent.mm.plugin.handoff.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).m23if(ak.this.id, "");
                    } else {
                        Log.i("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig cdnCallback upload attach by cdn, isHitCacheUpload: %d, onlyCheckExist[%b], exist[%b], signature[%s]", Integer.valueOf(dVar.field_UploadHitCacheType), Boolean.valueOf(z), Boolean.valueOf(dVar.field_exist_whencheck), Util.secPrint(ak.this.BGu.field_signature));
                        ak.this.raZ = false;
                        ak.this.handler.removeMessages(1);
                        ((com.tencent.mm.plugin.handoff.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).av(ak.this.id, dVar.field_fileId, dVar.field_aesKey);
                    }
                }
                AppMethodBeat.o(31077);
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
    private boolean iZk = true;
    private String id;
    private int jqN = 8192;
    private boolean raZ;
    private int retCode = 0;
    private com.tencent.mm.ak.d rr;
    private long startTime = 0;
    private long uploadedSize;

    static {
        AppMethodBeat.i(31083);
        AppMethodBeat.o(31083);
    }

    public static c a(HandOffFile handOffFile) {
        AppMethodBeat.i(31079);
        c cVar = new c();
        cVar.field_totalLen = handOffFile.getSize();
        cVar.field_fileFullPath = handOffFile.getFullPath();
        cVar.field_sdkVer = 0;
        cVar.field_appId = "";
        cVar.field_clientAppDataId = new StringBuilder().append(Util.nowMilliSecond()).toString();
        cVar.field_type = 0;
        cVar.field_status = 200;
        cVar.field_isUpload = true;
        cVar.field_createTime = Util.nowMilliSecond();
        cVar.field_lastModifyTime = Util.nowSecond();
        cVar.field_mediaSvrId = new StringBuilder().append(Util.nowMilliSecond()).toString();
        cVar.field_isUseCdn = 0;
        AppMethodBeat.o(31079);
        return cVar;
    }

    public ak(String str, c cVar) {
        AppMethodBeat.i(31080);
        cVar.field_offset = 0;
        cVar.field_isUpload = true;
        cVar.field_status = 101;
        cVar.field_netTimes = 0;
        this.id = str;
        this.BGu = cVar;
        if (NetStatusUtil.isWifiOr4G(MMApplicationContext.getContext())) {
            this.jqN = 32768;
        }
        d.a aVar = new d.a();
        aVar.iLN = new emy();
        aVar.iLO = new emz();
        aVar.uri = "/cgi-bin/micromsg-bin/uploadappattach";
        aVar.funcId = TbsListener.ErrorCode.COPY_INSTALL_SUCCESS;
        aVar.iLP = 105;
        aVar.respCmdId = 1000000105;
        this.rr = aVar.aXF();
        Log.i("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig new NetSceneUploadAppAttachForHandOff stack[%s]", Util.getStack());
        AppMethodBeat.o(31080);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        boolean z;
        AppMethodBeat.i(31081);
        this.callback = iVar;
        if (this.BGu.field_status != 101) {
            Log.e("MicroMsg.NetSceneUploadAppAttachForHandOff", com.tencent.mm.compatible.util.f.apq() + " summerbig get field_status failed status:" + this.BGu.field_status);
            AppMethodBeat.o(31081);
            return -1;
        }
        if (this.startTime == 0) {
            this.startTime = Util.nowMilliSecond();
            this.JWM = this.BGu.field_offset;
        }
        Log.i("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig doScene fileFullPath[%s], totalLen[%d],isUpload[%b], isUseCdn[%b], type[%d]", this.BGu.field_fileFullPath, Long.valueOf(this.BGu.field_totalLen), Boolean.valueOf(this.BGu.field_isUpload), Integer.valueOf(this.BGu.field_isUseCdn), Long.valueOf(this.BGu.field_type));
        f.baQ();
        if (com.tencent.mm.an.b.sS(4) || this.BGu.field_isUseCdn == 1) {
            int boW = (int) s.boW(this.BGu.field_fileFullPath);
            this.iYT = com.tencent.mm.an.c.a("upattach", this.BGu.field_createTime, z.aUL().field_username, "");
            Log.w("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig cdntra genClientId field_createTime[%d], useCdnTransClientId[%s]", Long.valueOf(this.BGu.field_createTime), this.iYT);
            if (Util.isNullOrNil(this.iYT)) {
                Log.w("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig cdntra genClientId failed not use cdn");
                z = false;
            } else {
                com.tencent.mm.i.g gVar2 = new com.tencent.mm.i.g();
                gVar2.taskName = "task_NetSceneUploadAppAttachForHandOff";
                int i2 = com.tencent.mm.i.a.MediaType_FILE;
                gVar2.field_appType = 0;
                gVar2.gqy = this.iZc;
                gVar2.field_mediaId = this.iYT;
                gVar2.field_fullpath = this.BGu.field_fileFullPath;
                gVar2.field_fileType = i2;
                gVar2.field_priority = com.tencent.mm.i.a.gpM;
                gVar2.field_totalLen = boW;
                gVar2.field_needStorage = false;
                gVar2.field_isStreamMedia = false;
                gVar2.field_enable_hitcheck = this.iZk;
                if (Util.isNullOrNil(gVar2.field_aesKey)) {
                    f.baR();
                    gVar2.field_aesKey = com.tencent.mm.an.a.baG();
                    Log.i("MicroMsg.NetSceneUploadAppAttachForHandOff", "summersafecdn gen aesKey new[%s]", gVar2.field_aesKey);
                }
                Log.i("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig cdntra checkUseCdn msgId:%d file[%s][%d], useCdnTransClientId[%s], fileType[%d], enable_hitcheck[%b], onlycheckexist[%b] force_aeskeycdn[%b] trysafecdn[%b] aeskey[%s], md5[%s], signature[%s], faeskey[%s], fsignature[%s]", Long.valueOf(this.BGu.field_msgInfoId), gVar2.field_fullpath, Integer.valueOf(boW), this.iYT, Integer.valueOf(gVar2.field_fileType), Boolean.valueOf(gVar2.field_enable_hitcheck), Boolean.valueOf(gVar2.field_onlycheckexist), Boolean.valueOf(gVar2.field_force_aeskeycdn), Boolean.valueOf(gVar2.field_trysafecdn), Util.secPrint(gVar2.field_aesKey), gVar2.field_filemd5, Util.secPrint(gVar2.field_svr_signature), Util.secPrint(gVar2.field_fake_bigfile_signature_aeskey), Util.secPrint(gVar2.field_fake_bigfile_signature));
                if (!f.baQ().f(gVar2)) {
                    Log.e("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig cdntra addSendTask failed.");
                    this.iYT = "";
                    z = false;
                } else {
                    if (this.BGu.field_isUseCdn != 1) {
                        this.BGu.field_isUseCdn = 1;
                    }
                    Log.i("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig checkUseCdn ret true useCdnTransClientId[%s]", this.iYT);
                    z = true;
                }
            }
        } else {
            f.baQ();
            Log.w("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig cdntra not use cdn flag:%b getCdnInfo:%d", Boolean.valueOf(com.tencent.mm.an.b.sS(4)), Integer.valueOf(this.BGu.field_isUseCdn));
            z = false;
        }
        if (z) {
            this.raZ = true;
            Message.obtain(this.handler, 1, this.id).sendToTarget();
            Log.d("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig doScene cdntra use cdn return -1 for onGYNetEnd client");
            AppMethodBeat.o(31081);
            return 0;
        } else if (this.BGu.field_netTimes > 3200) {
            Log.e("MicroMsg.NetSceneUploadAppAttachForHandOff", com.tencent.mm.compatible.util.f.apq() + " summerbig doScene info.field_netTimes > DOSCENE_LIMIT SET ERROR!");
            AppMethodBeat.o(31081);
            return -1;
        } else {
            this.BGu.field_netTimes++;
            if (Util.isNullOrNil(this.BGu.field_clientAppDataId)) {
                Log.e("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig doScene checkArgs : clientAppDataId is null");
                this.retCode = -10000 - com.tencent.mm.compatible.util.f.getLine();
                AppMethodBeat.o(31081);
                return -1;
            } else if (this.BGu.field_totalLen <= 0 || this.BGu.field_totalLen > 26214400) {
                Log.e("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig doScene checkArgs : totalLen is invalid, totalLen = " + this.BGu.field_totalLen);
                this.retCode = -10000 - com.tencent.mm.compatible.util.f.getLine();
                AppMethodBeat.o(31081);
                return -1;
            } else if (Util.isNullOrNil(this.BGu.field_fileFullPath)) {
                Log.e("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig doScene checkArgs : fileFullPath is null");
                this.retCode = -10000 - com.tencent.mm.compatible.util.f.getLine();
                AppMethodBeat.o(31081);
                return -1;
            } else if (((int) s.boW(this.BGu.field_fileFullPath)) > 26214400) {
                Log.e("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig doScene doScene : file is too large");
                AppMethodBeat.o(31081);
                return -1;
            } else {
                byte[] aW = s.aW(this.BGu.field_fileFullPath, (int) this.BGu.field_offset, this.jqN);
                if (Util.isNullOrNil(aW)) {
                    Log.e("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig doScene doScene : data is null");
                    this.retCode = -10000 - com.tencent.mm.compatible.util.f.getLine();
                    AppMethodBeat.o(31081);
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
                emy.BsH = aW.length;
                emy.BsI = new SKBuiltinBuffer_t().setBuffer(aW);
                Log.d("UploadAppAttach", String.format("AppId=%s, SdkVersion=%d, ClientAppDataId=%s, Type=%d, UserName=%s, TotalLen=%d, StartPos=%d", emy.jfi, Integer.valueOf(emy.KIy), emy.NkS, Integer.valueOf(emy.oUv), emy.UserName, Integer.valueOf(emy.BsF), Integer.valueOf(emy.BsG)));
                this.raZ = true;
                if (!this.handler.hasMessages(1)) {
                    Message.obtain(this.handler, 1, this.id).sendToTarget();
                }
                int dispatch = dispatch(gVar, this.rr, this);
                AppMethodBeat.o(31081);
                return dispatch;
            }
        }
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, com.tencent.mm.network.s sVar, byte[] bArr) {
        AppMethodBeat.i(31082);
        Log.d("MicroMsg.NetSceneUploadAppAttachForHandOff", "onGYNetEnd : errType = " + i3 + ", errCode = " + i4);
        if (i3 == 3 && i4 == -1 && !Util.isNullOrNil(this.iYT)) {
            Log.w("MicroMsg.NetSceneUploadAppAttachForHandOff", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", this.iYT);
            this.raZ = false;
            this.handler.removeMessages(1);
            AppMethodBeat.o(31082);
        } else if (i3 == 0 && i4 == 0) {
            emz emz = (emz) ((com.tencent.mm.ak.d) sVar).iLL.iLR;
            if (emz.jfi != null && (!emz.jfi.equals(this.BGu.field_appId) || !emz.NkS.equals(this.BGu.field_clientAppDataId))) {
                Log.e("MicroMsg.NetSceneUploadAppAttachForHandOff", "argument is not consistent");
                this.raZ = false;
                this.handler.removeMessages(1);
                ((com.tencent.mm.plugin.handoff.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).m23if(this.id, "");
                AppMethodBeat.o(31082);
            } else if (emz.BsF < 0 || ((long) emz.BsF) != this.BGu.field_totalLen || emz.BsG < 0 || ((long) emz.BsG) > this.BGu.field_totalLen) {
                Log.e("MicroMsg.NetSceneUploadAppAttachForHandOff", "dataLen, startPos or totalLen is incorrect");
                this.raZ = false;
                this.handler.removeMessages(1);
                ((com.tencent.mm.plugin.handoff.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).m23if(this.id, "");
                AppMethodBeat.o(31082);
            } else {
                this.BGu.field_offset = (long) emz.BsG;
                this.BGu.field_mediaSvrId = m.bdH(emz.jfl) ? emz.jfl : "";
                if (this.BGu.field_status == 105) {
                    Log.w("MicroMsg.NetSceneUploadAppAttachForHandOff", "onGYNetEnd STATUS PAUSE [" + this.BGu.field_mediaSvrId + "," + this.BGu.field_offset + "] ");
                    this.raZ = false;
                    this.handler.removeMessages(1);
                    AppMethodBeat.o(31082);
                    return;
                }
                if (this.BGu.field_offset != this.BGu.field_totalLen) {
                    this.uploadedSize = this.BGu.field_offset;
                } else if (Util.isNullOrNil(this.BGu.field_mediaSvrId)) {
                    Log.e("MicroMsg.NetSceneUploadAppAttachForHandOff", "finish upload but mediaid == null!");
                    this.raZ = false;
                    this.handler.removeMessages(1);
                    ((com.tencent.mm.plugin.handoff.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).m23if(this.id, "");
                    AppMethodBeat.o(31082);
                    return;
                } else {
                    this.BGu.field_status = 199;
                }
                if (this.BGu.field_status == 199) {
                    this.raZ = false;
                    this.handler.removeMessages(1);
                    ((com.tencent.mm.plugin.handoff.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).e(this.id, this.BGu.field_appId, (int) this.BGu.field_sdkVer, this.BGu.field_mediaSvrId);
                    AppMethodBeat.o(31082);
                    return;
                }
                if (doScene(dispatcher(), this.callback) < 0) {
                    Log.e("MicroMsg.NetSceneUploadAppAttachForHandOff", "onGYNetEnd : doScene fail");
                    this.raZ = false;
                    this.handler.removeMessages(1);
                    ((com.tencent.mm.plugin.handoff.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).m23if(this.id, "");
                }
                AppMethodBeat.o(31082);
            }
        } else {
            Log.e("MicroMsg.NetSceneUploadAppAttachForHandOff", "onGYNetEnd : errType = " + i3 + ", errCode = " + i4);
            this.raZ = false;
            this.handler.removeMessages(1);
            ((com.tencent.mm.plugin.handoff.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).m23if(this.id, "");
            AppMethodBeat.o(31082);
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

    @SuppressLint({"HandlerLeak"})
    class a extends Handler {
        private a() {
        }

        /* synthetic */ a(ak akVar, byte b2) {
            this();
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.i(31078);
            if (message.what == 1 && ak.this.raZ && ak.this.BGu.field_status != 105 && ((com.tencent.mm.plugin.handoff.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).az(ak.this.id, ak.this.uploadedSize)) {
                sendMessageDelayed(Message.obtain(this, 1, ak.this.id), ak.JWT);
            }
            AppMethodBeat.o(31078);
        }
    }
}
