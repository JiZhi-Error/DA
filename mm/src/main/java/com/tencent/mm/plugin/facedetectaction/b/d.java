package com.tencent.mm.plugin.facedetectaction.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.facedetect.PluginFace;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.plugin.facedetectaction.b.e;
import com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI;
import com.tencent.mm.plugin.flash.c.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bnf;
import com.tencent.mm.protocal.protobuf.bnh;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.youtu.ytcommon.YTCommonExInterface;
import com.tencent.youtu.ytfacetrack.YTFaceTrack;
import com.tencent.youtu.ytfacetrack.param.YTFaceDetectParam;
import com.tencent.youtu.ytfacetrack.param.YTFaceTrackParam;
import com.tencent.youtu.ytposedetect.YTPoseDetectInterface;
import com.tencent.ytcommon.util.YTCommonInterface;

public final class d implements i {
    public static d sXz = new d();
    String dYK;
    public String dYL;
    String dYM;
    public MMActivity gte;
    public int irL;
    public int mStatus = 0;
    String packageName;
    private String personId;
    int requestCode;
    private String sQY;
    b sXA;
    private e sXB;
    private float sXC;
    private String sXD;
    public a sXE;
    public int sXF;
    public int sXG;
    public FaceActionUI sXH;
    public boolean sXI = false;
    int scene;
    MMHandler workerHandler;

    public interface a {
        void a(int i2, int i3, String str, String str2, int i4);

        void a(bnh bnh);

        void aX(int i2, String str);

        void cTY();
    }

    static {
        AppMethodBeat.i(104222);
        AppMethodBeat.o(104222);
    }

    public final void a(FaceActionUI faceActionUI) {
        AppMethodBeat.i(104215);
        b.axn("reqCfg");
        com.tencent.mm.plugin.facedetectaction.a.a aVar = new com.tencent.mm.plugin.facedetectaction.a.a(this.scene, this.packageName, this.dYK);
        g.azz().a(2696, this);
        g.azz().a(aVar, 0);
        this.sXH = faceActionUI;
        AppMethodBeat.o(104215);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        int i4;
        boolean z;
        boolean z2;
        AppMethodBeat.i(104216);
        Log.i("MicroMsg.FaceCheckActionMgr", "onSceneEnd, errType: %s, errCode: %s, errMsg: %s, scene: %s", Integer.valueOf(i2), Integer.valueOf(i3), str, qVar);
        if (qVar instanceof com.tencent.mm.plugin.facedetectaction.a.a) {
            g.azz().b(2696, this);
            com.tencent.mm.plugin.facedetectaction.a.a aVar = (com.tencent.mm.plugin.facedetectaction.a.a) qVar;
            b.s("errorType", i2 + "#" + i3);
            if (i2 == 0 && i3 == 0) {
                bnf bnf = aVar.sXg;
                b.dLj().eqT = bnf.pTZ;
                b.s("rspCfg", Integer.valueOf(bnf.pTZ));
                b.s("msgCfg", bnf.pUa);
                Log.i("MicroMsg.FaceCheckActionMgr", "GetFaceCheckAction, ret_code: %s, ret_msg: %s, action_data: %s, reduction_ratio: %s, take_message: %s", Integer.valueOf(bnf.pTZ), bnf.pUa, bnf.action_data, Float.valueOf(bnf.LVN), bnf.LjH);
                if (bnf.pTZ == 0) {
                    this.personId = bnf.person_id;
                    this.sQY = bnf.action_data;
                    this.sXC = bnf.LVN;
                    this.sXD = bnf.LjH;
                    switch (Util.getInt(this.sQY, -1)) {
                        case 1:
                        case 3:
                            i4 = 1;
                            break;
                        case 2:
                        case 4:
                        default:
                            i4 = -1;
                            break;
                        case 5:
                            i4 = 2;
                            break;
                    }
                    if (i4 != -1) {
                        String str2 = bnf.LVO;
                        Log.i("MicroMsg.FaceCheckActionMgr", "onGetLiveTypeFinish, liveType: %s, actionHint: %s", Integer.valueOf(i4), str2);
                        b bVar = this.sXA;
                        MMActivity mMActivity = this.gte;
                        b.tryLoadLibrary();
                        if (!PluginFace.isEnabled()) {
                            z2 = false;
                        } else {
                            int initAuth = YTCommonInterface.initAuth(MMApplicationContext.getContext(), "rel_wechat_2055-12-06.lic1.2", 0);
                            Log.i("MicroMsg.FaceCheckActionEngine", "initAuth ret: %s", Integer.valueOf(initAuth));
                            bVar.liveType = i4;
                            if (initAuth != 0) {
                                h.INSTANCE.idkeyStat(917, 58, 1, false);
                                z2 = false;
                            } else {
                                h.INSTANCE.idkeyStat(917, 57, 1, false);
                                Log.i("MicroMsg.FaceCheckActionEngine", "initYoutuInstance()");
                                int i5 = -1;
                                if (PluginFace.isEnabled()) {
                                    i5 = YTFaceTrack.GlobalInit(com.tencent.mm.b.q.k(p.cTh(), false) + FilePathGenerator.ANDROID_DIR_SEP);
                                }
                                Log.i("MicroMsg.FaceCheckActionEngine", "YTPoseDetectInterface.initModel ret: %s", Integer.valueOf(i5));
                                if (i5 != 0) {
                                    z = false;
                                } else {
                                    YTFaceDetectParam GetFaceDetectParam = YTFaceTrack.getInstance().GetFaceDetectParam();
                                    GetFaceDetectParam.bigger_face_mode = true;
                                    GetFaceDetectParam.min_face_size = 50;
                                    YTFaceTrack.getInstance().SetFaceDetectParam(GetFaceDetectParam);
                                    YTFaceTrackParam GetFaceTrackParam = YTFaceTrack.getInstance().GetFaceTrackParam();
                                    GetFaceTrackParam.need_pose_estimate = true;
                                    GetFaceTrackParam.detect_interval = 20;
                                    YTFaceTrack.getInstance().SetFaceTrackParam(GetFaceTrackParam);
                                    int initModel = YTPoseDetectInterface.initModel();
                                    if (initModel != 0) {
                                        Log.i("MicroMsg.FaceCheckActionEngine", "YTFaceTraceInterface.initModel failed，return:".concat(String.valueOf(initModel)));
                                        z = false;
                                    } else {
                                        z = true;
                                        YTPoseDetectInterface.setSafetyLevel(1);
                                    }
                                }
                                if (z) {
                                    YTCommonExInterface.setAppBrightness(mMActivity, 255);
                                    bVar.status = 1;
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                bVar.sXw = 
                                /*  JADX ERROR: Method code generation error
                                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x01b8: IPUT  
                                      (wrap: com.tencent.mm.plugin.facedetectaction.b.b$1 : 0x01b5: CONSTRUCTOR  (r3v41 com.tencent.mm.plugin.facedetectaction.b.b$1) = (r13v0 'bVar' com.tencent.mm.plugin.facedetectaction.b.b) call: com.tencent.mm.plugin.facedetectaction.b.b.1.<init>(com.tencent.mm.plugin.facedetectaction.b.b):void type: CONSTRUCTOR)
                                      (r13v0 'bVar' com.tencent.mm.plugin.facedetectaction.b.b)
                                     com.tencent.mm.plugin.facedetectaction.b.b.sXw com.tencent.youtu.ytposedetect.YTPoseDetectInterface$PoseDetectOnFrame in method: com.tencent.mm.plugin.facedetectaction.b.d.onSceneEnd(int, int, java.lang.String, com.tencent.mm.ak.q):void, file: classes7.dex
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:157)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:157)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x01b5: CONSTRUCTOR  (r3v41 com.tencent.mm.plugin.facedetectaction.b.b$1) = (r13v0 'bVar' com.tencent.mm.plugin.facedetectaction.b.b) call: com.tencent.mm.plugin.facedetectaction.b.b.1.<init>(com.tencent.mm.plugin.facedetectaction.b.b):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.facedetectaction.b.d.onSceneEnd(int, int, java.lang.String, com.tencent.mm.ak.q):void, file: classes7.dex
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:428)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                    	... 50 more
                                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.facedetectaction.b.b, state: GENERATED_AND_UNLOADED
                                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                    	... 54 more
                                    */
                                /*
                                // Method dump skipped, instructions count: 810
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.facedetectaction.b.d.onSceneEnd(int, int, java.lang.String, com.tencent.mm.ak.q):void");
                            }

                            public final void aj(Runnable runnable) {
                                AppMethodBeat.i(104217);
                                if (this.workerHandler != null) {
                                    this.workerHandler.post(runnable);
                                }
                                AppMethodBeat.o(104217);
                            }

                            public final void onBackPressed() {
                                AppMethodBeat.i(104218);
                                if (this.sXH != null) {
                                    if (this.mStatus == 0 || this.mStatus == 1) {
                                        this.sXH.a("cancel", 90004, null, Boolean.valueOf(this.sXH.sYp));
                                        AppMethodBeat.o(104218);
                                        return;
                                    } else if (this.mStatus == 2) {
                                        this.sXH.a("cancel", 0, null, Boolean.valueOf(this.sXH.sYp));
                                        AppMethodBeat.o(104218);
                                        return;
                                    } else if (this.mStatus == 3) {
                                        this.sXH.a("cancel", 90006, null, Boolean.valueOf(this.sXH.sYp));
                                    }
                                }
                                AppMethodBeat.o(104218);
                            }

                            public final void release(boolean z) {
                                AppMethodBeat.i(104219);
                                Log.i("MicroMsg.FaceCheckActionMgr", "release, recreate: %s", Boolean.valueOf(z));
                                if (this.sXA != null) {
                                    b.release();
                                    this.sXA = new b();
                                }
                                if (this.sXB != null) {
                                    if (com.tencent.mm.plugin.facedetect.e.a.cTF().isStarted()) {
                                        com.tencent.mm.plugin.facedetect.e.a.cTF().cTH();
                                    }
                                    this.sXB = null;
                                }
                                if (z) {
                                    if (this.workerHandler != null) {
                                        this.workerHandler.getSerial().RUS.quit();
                                        this.workerHandler = null;
                                    }
                                    sXz = new d();
                                }
                                AppMethodBeat.o(104219);
                            }

                            static /* synthetic */ void a(d dVar, final byte[][] bArr, final int i2, final int i3) {
                                AppMethodBeat.i(104220);
                                Log.i("MicroMsg.FaceCheckActionMgr", "processRecordFrameData, frames: %s, width: %s, height: %s", bArr, Integer.valueOf(i2), Integer.valueOf(i3));
                                if (dVar.sXE != null) {
                                    dVar.sXE.cTY();
                                }
                                dVar.aj(new Runnable() {
                                    /* class com.tencent.mm.plugin.facedetectaction.b.d.AnonymousClass2 */

                                    public final void run() {
                                        int i2;
                                        int i3;
                                        AppMethodBeat.i(104214);
                                        d.this.sXB = new e(d.this.personId, d.this.sXC, d.this.irL, d.this.sXF, d.this.sXG);
                                        d.this.sXB.sXO = String.valueOf(d.this.sXH.getContext().hashCode());
                                        d.this.sXB.sXM = new e.a() {
                                            /* class com.tencent.mm.plugin.facedetectaction.b.d.AnonymousClass2.AnonymousClass1 */

                                            @Override // com.tencent.mm.plugin.facedetectaction.b.e.a
                                            public final void a(String str, String str2, String str3, byte[] bArr) {
                                                AppMethodBeat.i(104212);
                                                Log.i("MicroMsg.FaceCheckActionMgr", "onUploadFinish, fileName: %s, fileId: %s, aesKey: %s", str, str, str2, str3);
                                                h.INSTANCE.idkeyStat(917, 50, 1, false);
                                                d.a(d.this, str, str2, str3, bArr);
                                                AppMethodBeat.o(104212);
                                            }

                                            @Override // com.tencent.mm.plugin.facedetectaction.b.e.a
                                            public final void onError() {
                                                AppMethodBeat.i(104213);
                                                Log.i("MicroMsg.FaceCheckActionMgr", "on record error");
                                                if (d.this.sXE != null) {
                                                    d.this.sXE.a(2, -1, "", "", 1);
                                                    h.INSTANCE.idkeyStat(917, 47, 1, false);
                                                }
                                                AppMethodBeat.o(104213);
                                            }
                                        };
                                        e eVar = d.this.sXB;
                                        byte[][] bArr = bArr;
                                        int i4 = i2;
                                        int i5 = i3;
                                        if (bArr != null && i4 > 0 && i5 > 0) {
                                            Log.i("MicroMsg.FaceCheckVideoRecordMgr", "recordAllPostDetectFrames, width: %s, height: %s, frames.size: %s, cameraFrameWidth: %s, cameraFrameHeight: %s", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(bArr.length), Integer.valueOf(eVar.sXF), Integer.valueOf(eVar.sXG));
                                            VideoTransPara videoTransPara = new VideoTransPara();
                                            videoTransPara.isDefault = true;
                                            videoTransPara.width = i4;
                                            videoTransPara.height = i5;
                                            videoTransPara.fps = 30;
                                            videoTransPara.videoBitrate = 12000000;
                                            videoTransPara.iiH = 10;
                                            videoTransPara.audioBitrate = 64000;
                                            videoTransPara.iSU = 2;
                                            videoTransPara.iSV = 1;
                                            videoTransPara.audioSampleRate = 16000;
                                            videoTransPara.duration = 15;
                                            int length = bArr.length * videoTransPara.fps;
                                            videoTransPara.videoBitrate = 3686400;
                                            if (eVar.sXC > 0.0f) {
                                                videoTransPara.videoBitrate = (int) (((float) videoTransPara.videoBitrate) * eVar.sXC);
                                            }
                                            Log.i("MicroMsg.FaceCheckVideoRecordMgr", "final video bitrate: %s", Integer.valueOf(videoTransPara.videoBitrate));
                                            if (!(eVar.sXF == i4 && eVar.sXG == i5)) {
                                                Log.e("MicroMsg.FaceCheckVideoRecordMgr", "camera frame size and sdk output size not match!!!");
                                                if (!(bArr == null || bArr[0] == null)) {
                                                    byte[] bArr2 = bArr[0];
                                                    Log.i("MicroMsg.FaceCheckVideoRecordMgr", "first frame size: %s", Integer.valueOf(bArr2.length));
                                                    if (bArr2.length != ((i4 * i5) * 3) / 2 && bArr2.length == ((eVar.sXF * eVar.sXG) * 3) / 2) {
                                                        i3 = eVar.sXF;
                                                        i2 = eVar.sXG;
                                                        com.tencent.mm.plugin.facedetect.e.a cTF = com.tencent.mm.plugin.facedetect.e.a.cTF();
                                                        int i6 = eVar.orientation;
                                                        e.AnonymousClass1 r7 = new Runnable(length, videoTransPara, bArr) {
                                                            /* class com.tencent.mm.plugin.facedetectaction.b.e.AnonymousClass1 */
                                                            final /* synthetic */ int moi;
                                                            final /* synthetic */ VideoTransPara sXQ;
                                                            final /* synthetic */ byte[][] sXR;

                                                            {
                                                                this.moi = r2;
                                                                this.sXQ = r3;
                                                                this.sXR = r4;
                                                            }

                                                            public final void run() {
                                                                AppMethodBeat.i(104223);
                                                                com.tencent.mm.plugin.facedetect.e.a cTF = com.tencent.mm.plugin.facedetect.e.a.cTF();
                                                                cTF.sUq.postToWorker(
                                                                /*  JADX ERROR: Method code generation error
                                                                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0013: INVOKE  
                                                                      (wrap: com.tencent.mm.sdk.platformtools.MMHandler : 0x000c: IGET  (r2v0 com.tencent.mm.sdk.platformtools.MMHandler) = (r0v0 'cTF' com.tencent.mm.plugin.facedetect.e.a) com.tencent.mm.plugin.facedetect.e.a.sUq com.tencent.mm.sdk.platformtools.MMHandler)
                                                                      (wrap: com.tencent.mm.plugin.facedetect.e.a$4 : 0x0010: CONSTRUCTOR  (r3v0 com.tencent.mm.plugin.facedetect.e.a$4) = 
                                                                      (r0v0 'cTF' com.tencent.mm.plugin.facedetect.e.a)
                                                                      (wrap: int : 0x000a: IGET  (r1v0 int) = (r5v0 'this' com.tencent.mm.plugin.facedetectaction.b.e$1 A[IMMUTABLE_TYPE, THIS]) com.tencent.mm.plugin.facedetectaction.b.e.1.moi int)
                                                                     call: com.tencent.mm.plugin.facedetect.e.a.4.<init>(com.tencent.mm.plugin.facedetect.e.a, int):void type: CONSTRUCTOR)
                                                                     type: VIRTUAL call: com.tencent.mm.sdk.platformtools.MMHandler.postToWorker(java.lang.Runnable):boolean in method: com.tencent.mm.plugin.facedetectaction.b.e.1.run():void, file: classes7.dex
                                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                                                                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                                                                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                                                                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                                                                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                                                                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                                                                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                                                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                                                                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                                                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                                                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0010: CONSTRUCTOR  (r3v0 com.tencent.mm.plugin.facedetect.e.a$4) = 
                                                                      (r0v0 'cTF' com.tencent.mm.plugin.facedetect.e.a)
                                                                      (wrap: int : 0x000a: IGET  (r1v0 int) = (r5v0 'this' com.tencent.mm.plugin.facedetectaction.b.e$1 A[IMMUTABLE_TYPE, THIS]) com.tencent.mm.plugin.facedetectaction.b.e.1.moi int)
                                                                     call: com.tencent.mm.plugin.facedetect.e.a.4.<init>(com.tencent.mm.plugin.facedetect.e.a, int):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.facedetectaction.b.e.1.run():void, file: classes7.dex
                                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                                                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                                                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                                                                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                                                                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                                                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                                                    	... 14 more
                                                                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.facedetect.e.a, state: GENERATED_AND_UNLOADED
                                                                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                                                                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                                                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                                                    	... 20 more
                                                                    */
                                                                /*
                                                                    this = this;
                                                                    r4 = 104223(0x1971f, float:1.46048E-40)
                                                                    com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
                                                                    com.tencent.mm.plugin.facedetect.e.a r0 = com.tencent.mm.plugin.facedetect.e.a.cTF()
                                                                    int r1 = r5.moi
                                                                    com.tencent.mm.sdk.platformtools.MMHandler r2 = r0.sUq
                                                                    com.tencent.mm.plugin.facedetect.e.a$4 r3 = new com.tencent.mm.plugin.facedetect.e.a$4
                                                                    r3.<init>(r1)
                                                                    r2.postToWorker(r3)
                                                                    com.tencent.mm.plugin.facedetect.e.a r0 = com.tencent.mm.plugin.facedetect.e.a.cTF()
                                                                    com.tencent.mm.modelcontrol.VideoTransPara r1 = r5.sXQ
                                                                    int r1 = r1.fps
                                                                    float r1 = (float) r1
                                                                    com.tencent.mm.sdk.platformtools.MMHandler r2 = r0.sUq
                                                                    com.tencent.mm.plugin.facedetect.e.a$5 r3 = new com.tencent.mm.plugin.facedetect.e.a$5
                                                                    r3.<init>(r1)
                                                                    r2.postToWorker(r3)
                                                                    com.tencent.mm.plugin.facedetectaction.b.e r0 = com.tencent.mm.plugin.facedetectaction.b.e.this
                                                                    byte[][] r1 = r5.sXR
                                                                    com.tencent.mm.plugin.facedetectaction.b.d r2 = com.tencent.mm.plugin.facedetectaction.b.d.sXz
                                                                    com.tencent.mm.plugin.facedetectaction.b.e$2 r3 = new com.tencent.mm.plugin.facedetectaction.b.e$2
                                                                    r3.<init>(r1)
                                                                    r2.aj(r3)
                                                                    com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
                                                                    return
                                                                */
                                                                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.facedetectaction.b.e.AnonymousClass1.run():void");
                                                            }
                                                        };
                                                        Log.i("MicroMsg.FaceVideoRecorder", "initRecorderForActionVerify");
                                                        Log.i("MicroMsg.FaceVideoRecorder", "hy: cameraOrientation: %d, previewWidth: %d, previewHeight: %d,isLandscape: %b,  degree: %d, param: %s", Integer.valueOf(i6), Integer.valueOf(i3), Integer.valueOf(i2), Boolean.FALSE, 0, videoTransPara);
                                                        cTF.sUC.b(cTF.gVN, videoTransPara);
                                                        cTF.sUq.postToWorker(
                                                        /*  JADX ERROR: Method code generation error
                                                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x018f: INVOKE  
                                                              (wrap: com.tencent.mm.sdk.platformtools.MMHandler : 0x0188: IGET  (r8v4 com.tencent.mm.sdk.platformtools.MMHandler) = (r1v24 'cTF' com.tencent.mm.plugin.facedetect.e.a) com.tencent.mm.plugin.facedetect.e.a.sUq com.tencent.mm.sdk.platformtools.MMHandler)
                                                              (wrap: com.tencent.mm.plugin.facedetect.e.a$3 : 0x018c: CONSTRUCTOR  (r0v12 com.tencent.mm.plugin.facedetect.e.a$3) = 
                                                              (r1v24 'cTF' com.tencent.mm.plugin.facedetect.e.a)
                                                              (r2v6 'i6' int)
                                                              (r3v7 'i2' int)
                                                              (r4v9 'i3' int)
                                                              (r5v2 'i4' int)
                                                              (r6v1 'i5' int)
                                                              (r7v10 'r7' com.tencent.mm.plugin.facedetectaction.b.e$1)
                                                             call: com.tencent.mm.plugin.facedetect.e.a.3.<init>(com.tencent.mm.plugin.facedetect.e.a, int, int, int, int, int, java.lang.Runnable):void type: CONSTRUCTOR)
                                                             type: VIRTUAL call: com.tencent.mm.sdk.platformtools.MMHandler.postToWorker(java.lang.Runnable):boolean in method: com.tencent.mm.plugin.facedetectaction.b.d.2.run():void, file: classes7.dex
                                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                                                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                                                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                                                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                                                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                                                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                                                            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                                            	at java.util.ArrayList.forEach(ArrayList.java:1259)
                                                            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                                            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                                            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x018c: CONSTRUCTOR  (r0v12 com.tencent.mm.plugin.facedetect.e.a$3) = 
                                                              (r1v24 'cTF' com.tencent.mm.plugin.facedetect.e.a)
                                                              (r2v6 'i6' int)
                                                              (r3v7 'i2' int)
                                                              (r4v9 'i3' int)
                                                              (r5v2 'i4' int)
                                                              (r6v1 'i5' int)
                                                              (r7v10 'r7' com.tencent.mm.plugin.facedetectaction.b.e$1)
                                                             call: com.tencent.mm.plugin.facedetect.e.a.3.<init>(com.tencent.mm.plugin.facedetect.e.a, int, int, int, int, int, java.lang.Runnable):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.facedetectaction.b.d.2.run():void, file: classes7.dex
                                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                                                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                                                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                                                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                                            	... 34 more
                                                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.facedetect.e.a, state: GENERATED_AND_UNLOADED
                                                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                                                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                                            	... 40 more
                                                            */
                                                        /*
                                                        // Method dump skipped, instructions count: 412
                                                        */
                                                        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.facedetectaction.b.d.AnonymousClass2.run():void");
                                                    }
                                                });
                                                AppMethodBeat.o(104220);
                                            }

                                            static /* synthetic */ void a(d dVar, String str, String str2, String str3, byte[] bArr) {
                                                AppMethodBeat.i(104221);
                                                Log.i("MicroMsg.FaceCheckActionMgr", "requestCheckAction, fileName: %s, fileId: %s, aesKey: %s needSignContract:%s ", str, str2, str3, Boolean.valueOf(dVar.sXI));
                                                b.axn("reqVerify");
                                                com.tencent.mm.plugin.facedetectaction.a.b bVar = new com.tencent.mm.plugin.facedetectaction.a.b(dVar.personId, dVar.sQY, dVar.sXC, str2, str3, dVar.scene, dVar.sXD, dVar.packageName, bArr, dVar.sXI);
                                                g.azz().a(2726, dVar);
                                                g.azz().a(bVar, 0);
                                                AppMethodBeat.o(104221);
                                            }
                                        }
