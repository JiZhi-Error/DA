package com.tencent.mm.plugin.facedetectlight.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.ImageFormat;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Build;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.TextureView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.d;
import com.tencent.mm.compatible.deviceinfo.v;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.facedetect.model.d;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.plugin.facedetectaction.b.a;
import com.tencent.mm.plugin.facedetectaction.ui.FaceActionMask;
import com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI;
import com.tencent.mm.plugin.flash.view.FaceReflectMask;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.ui.base.MMTextureView;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.youtu.ytposedetect.YTPoseDetectInterface;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public final class a implements TextureView.SurfaceTextureListener {
    int RbO = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_face_action_cache_data_size, 5);
    private volatile AtomicInteger RbP = new AtomicInteger(0);
    boolean RbQ = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_face_action_old_ui_camera_preview_sy, false);
    boolean enable = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_face_action_copy_data, true);
    private String goe;
    private boolean imf;
    private d.a.C0301a imk;
    private Context mContext;
    int mDesiredPreviewHeight;
    int mDesiredPreviewWidth;
    private Point pbD = null;
    public ImageView pcg;
    private Point sRF = null;
    private Point sRG = null;
    private boolean sRH;
    private int sRI;
    private Point sRK = null;
    public volatile boolean sTE;
    private Camera.PreviewCallback sVE = new Camera.PreviewCallback() {
        /* class com.tencent.mm.plugin.facedetectlight.ui.a.AnonymousClass1 */

        public final void onPreviewFrame(byte[] bArr, Camera camera) {
            AppMethodBeat.i(258253);
            if (!a.this.RbQ) {
                if (a.this.sZm != null) {
                    if (!a.this.enable || a.this.RbP.get() < a.this.RbO) {
                        a.this.sZm.postToWorker(a.this.enable ? new b(bArr, camera) : new c(bArr, camera));
                        AppMethodBeat.o(258253);
                        return;
                    }
                    Log.i("MicroMsg.FaceReflectCam", "drop frame  %d", Integer.valueOf(a.this.RbP.get()));
                    AppMethodBeat.o(258253);
                    return;
                }
            } else if (a.this.sZd && a.this.sTE && a.this.sZl == 2) {
                a.b.sXv.a(bArr, camera);
            }
            AppMethodBeat.o(258253);
        }
    };
    d.b sVF = new d.b() {
        /* class com.tencent.mm.plugin.facedetectlight.ui.a.AnonymousClass10 */

        @Override // com.tencent.mm.plugin.facedetect.model.d.b
        public final void bC(byte[] bArr) {
            AppMethodBeat.i(104293);
            com.tencent.mm.plugin.facedetect.model.c.sQB.k(bArr);
            AppMethodBeat.o(104293);
        }

        @Override // com.tencent.mm.plugin.facedetect.model.d.b
        public final com.tencent.mm.memory.a<byte[]> cSS() {
            return com.tencent.mm.plugin.facedetect.model.c.sQB;
        }
    };
    private FaceActionUI sXH;
    public int sXk;
    public String sXl;
    private a.AbstractC1040a sXn;
    private MMTextureView sYY;
    private HandlerThread sYZ;
    public FaceActionMask sYd;
    private MMHandler sZa;
    public v sZb;
    private volatile boolean sZc;
    public volatile boolean sZd;
    public TextView sZe;
    private FaceReflectMask sZf;
    public PreviewFrameLayout sZg;
    private int sZh = 0;
    public ImageView sZi;
    private Bitmap sZj;
    private boolean sZk;
    private int sZl = 2;
    public MMHandler sZm = new MMHandler("mPreviewHandlerThread");

    static /* synthetic */ boolean g(a aVar) {
        AppMethodBeat.i(258259);
        boolean cUc = aVar.cUc();
        AppMethodBeat.o(258259);
        return cUc;
    }

    public final void a(MMTextureView mMTextureView) {
        AppMethodBeat.i(104296);
        this.sYY = mMTextureView;
        if (this.sYY.isAvailable()) {
            j(mMTextureView.getSurfaceTexture());
        }
        this.sYY.setSurfaceTextureListener(this);
        this.sYY.setVisibility(0);
        this.sYY.setAlpha(0.0f);
        if (this.sZl == 2 && !this.sZk) {
            MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.facedetectlight.ui.a.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(104284);
                    a.this.pcg.setVisibility(8);
                    a.this.sZi.setVisibility(8);
                    a.this.sZk = true;
                    AppMethodBeat.o(104284);
                }
            }, 700);
        }
        AppMethodBeat.o(104296);
    }

    private void j(final SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(104297);
        Log.i("MicroMsg.FaceReflectCam", "openCameraForSurfaceTexture");
        if (this.sZl == 1) {
            this.sZf.setVisibility(0);
        } else {
            this.sYd.setVisibility(0);
        }
        cUd();
        if (this.sZa != null) {
            this.sZa.post(new Runnable() {
                /* class com.tencent.mm.plugin.facedetectlight.ui.a.AnonymousClass4 */

                public final void run() {
                    AppMethodBeat.i(104285);
                    a.this.sZc = a.g(a.this);
                    if (!a.this.sZc) {
                        h.INSTANCE.idkeyStat(917, a.this.sZl == 1 ? 3 : 39, 1, false);
                        a.this.sZc = a.g(a.this);
                    }
                    h.INSTANCE.idkeyStat(917, a.this.sZl == 1 ? 2 : 38, 1, false);
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.facedetectlight.ui.a.AnonymousClass4.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(258254);
                            if (a.this.sZb == null || a.this.sZb.gIJ || !a.this.sZc) {
                                Log.e("MicroMsg.FaceReflectCam", "camera is null or has released!");
                                AppMethodBeat.o(258254);
                                return;
                            }
                            if (a.this.sZl != 1) {
                                com.tencent.mm.plugin.facedetectaction.b.a aVar = a.b.sXv;
                                Context applicationContext = a.this.sXH.getApplicationContext();
                                FaceActionUI faceActionUI = a.this.sXH;
                                Camera camera = a.this.sZb.gII;
                                int i2 = a.this.sZh;
                                TextView textView = a.this.sZe;
                                a.AbstractC1040a aVar2 = a.this.sXn;
                                int i3 = a.this.sRI;
                                Point point = new Point(a.this.mDesiredPreviewWidth, a.this.mDesiredPreviewHeight);
                                int i4 = a.this.sXk;
                                String str = a.this.sXl;
                                int i5 = a.this.mDesiredPreviewWidth;
                                int i6 = a.this.mDesiredPreviewHeight;
                                Log.i("MicroMsg.FaceActionLogic", "initFaceDetect（）");
                                aVar.mContext = applicationContext;
                                aVar.mCamera = camera;
                                aVar.lPd = i2;
                                aVar.sXm = textView;
                                aVar.sXq = faceActionUI.getResources().getDisplayMetrics().widthPixels;
                                aVar.sXr = faceActionUI.getResources().getDisplayMetrics().heightPixels;
                                Log.i("MicroMsg.FaceActionLogic", "mUiWidth:%s  mUiHeight：%s", Integer.valueOf(aVar.sXq), Integer.valueOf(aVar.sXr));
                                aVar.sXn = aVar2;
                                aVar.sXk = i4;
                                aVar.sXl = str;
                                aVar.mDesiredPreviewWidth = i5;
                                aVar.mDesiredPreviewHeight = i6;
                                aVar.sXo = new Rect(0, 0, 0, 0);
                                aVar.sXp = new Rect(0, 0, 0, 0);
                                aVar.sXt = true;
                                Log.i("MicroMsg.FaceActionLogic", "action：%s,mActionHint:%s", Integer.valueOf(aVar.sXk), aVar.sXl);
                                if (aVar.sXl == null) {
                                    switch (aVar.sXk) {
                                        case 1:
                                            aVar.sXm.setText(R.string.c41);
                                            break;
                                        case 2:
                                            aVar.sXm.setText(R.string.c42);
                                            break;
                                    }
                                } else {
                                    aVar.sXm.setText(aVar.sXl);
                                }
                                YTPoseDetectInterface.start(applicationContext.getApplicationContext(), camera, i2, 
                                /*  JADX ERROR: Method code generation error
                                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0174: INVOKE  
                                      (wrap: android.content.Context : 0x016b: INVOKE  (r2v6 android.content.Context) = (r2v5 'applicationContext' android.content.Context) type: VIRTUAL call: android.content.Context.getApplicationContext():android.content.Context)
                                      (r4v3 'camera' android.hardware.Camera)
                                      (r5v2 'i2' int)
                                      (wrap: com.tencent.mm.plugin.facedetectaction.b.a$1 : 0x0171: CONSTRUCTOR  (r3v15 com.tencent.mm.plugin.facedetectaction.b.a$1) = (r1v17 'aVar' com.tencent.mm.plugin.facedetectaction.b.a) call: com.tencent.mm.plugin.facedetectaction.b.a.1.<init>(com.tencent.mm.plugin.facedetectaction.b.a):void type: CONSTRUCTOR)
                                     type: STATIC call: com.tencent.youtu.ytposedetect.YTPoseDetectInterface.start(android.content.Context, android.hardware.Camera, int, com.tencent.youtu.ytposedetect.YTPoseDetectInterface$PoseDetectResult):int in method: com.tencent.mm.plugin.facedetectlight.ui.a.4.1.run():void, file: classes9.dex
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
                                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0171: CONSTRUCTOR  (r3v15 com.tencent.mm.plugin.facedetectaction.b.a$1) = (r1v17 'aVar' com.tencent.mm.plugin.facedetectaction.b.a) call: com.tencent.mm.plugin.facedetectaction.b.a.1.<init>(com.tencent.mm.plugin.facedetectaction.b.a):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.facedetectlight.ui.a.4.1.run():void, file: classes9.dex
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                    	... 23 more
                                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.facedetectaction.b.a, state: GENERATED_AND_UNLOADED
                                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                    	... 29 more
                                    */
                                /*
                                // Method dump skipped, instructions count: 448
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.facedetectlight.ui.a.AnonymousClass4.AnonymousClass1.run():void");
                            }
                        });
                        AppMethodBeat.o(104285);
                    }
                });
                this.sZa.post(new Runnable() {
                    /* class com.tencent.mm.plugin.facedetectlight.ui.a.AnonymousClass5 */

                    public final void run() {
                        AppMethodBeat.i(104286);
                        try {
                            a.a(a.this, surfaceTexture);
                            a aVar = a.this;
                            Camera.PreviewCallback previewCallback = a.this.sVE;
                            if (aVar.sZb == null) {
                                Log.w("MicroMsg.FaceReflectCam", "hy: camera is null. setPreviewCallback failed");
                            } else {
                                int bitsPerPixel = ((aVar.mDesiredPreviewWidth * aVar.mDesiredPreviewHeight) * ImageFormat.getBitsPerPixel(aVar.sZb.getParameters().getPreviewFormat())) / 8;
                                for (int i2 = 0; i2 < aVar.RbO; i2++) {
                                    aVar.sZb.addCallbackBuffer(com.tencent.mm.plugin.facedetect.model.c.sQB.h(Integer.valueOf(bitsPerPixel)));
                                }
                                aVar.sZb.setPreviewCallbackWithBuffer(new Camera.PreviewCallback(previewCallback) {
                                    /* class com.tencent.mm.plugin.facedetectlight.ui.a.AnonymousClass2 */
                                    final /* synthetic */ Camera.PreviewCallback sRL;

                                    {
                                        this.sRL = r2;
                                    }

                                    public final void onPreviewFrame(byte[] bArr, Camera camera) {
                                        AppMethodBeat.i(104282);
                                        MMHandlerThread.postToMainThread(new Runnable() {
                                            /* class com.tencent.mm.plugin.facedetectlight.ui.a.AnonymousClass2.AnonymousClass1 */

                                            public final void run() {
                                                AppMethodBeat.i(104281);
                                                a.this.sYY.setAlpha(1.0f);
                                                AppMethodBeat.o(104281);
                                            }
                                        });
                                        if (this.sRL != null) {
                                            this.sRL.onPreviewFrame(bArr, camera);
                                        }
                                        camera.addCallbackBuffer(bArr);
                                        AppMethodBeat.o(104282);
                                    }
                                });
                                com.tencent.mm.plugin.facedetect.model.d.cSR().a(aVar.sVF);
                            }
                            com.tencent.mm.plugin.flash.c.b.axn("openCamera");
                            AppMethodBeat.o(104286);
                        } catch (Exception e2) {
                            com.tencent.mm.plugin.flash.c.b.s("openCamera", -1);
                            if (a.this.sZl != 1) {
                                Log.i("MicroMsg.FaceReflectCam", "preview error");
                                com.tencent.f.h.RTc.aV(
                                /*  JADX ERROR: Method code generation error
                                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0098: INVOKE  
                                      (wrap: com.tencent.f.i : 0x0091: SGET  (r1v4 com.tencent.f.i) =  com.tencent.f.h.RTc com.tencent.f.i)
                                      (wrap: com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI$2 : 0x0095: CONSTRUCTOR  (r2v0 com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI$2) = 
                                      (wrap: com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI : 0x008d: IGET  (r0v6 com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI) = 
                                      (wrap: com.tencent.mm.plugin.facedetectlight.ui.a : 0x008b: IGET  (r0v5 com.tencent.mm.plugin.facedetectlight.ui.a) = (r7v0 'this' com.tencent.mm.plugin.facedetectlight.ui.a$5 A[IMMUTABLE_TYPE, THIS]) com.tencent.mm.plugin.facedetectlight.ui.a.5.sZn com.tencent.mm.plugin.facedetectlight.ui.a)
                                     com.tencent.mm.plugin.facedetectlight.ui.a.sXH com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI)
                                     call: com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI.2.<init>(com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI):void type: CONSTRUCTOR)
                                     type: INTERFACE call: com.tencent.f.i.aV(java.lang.Runnable):com.tencent.f.i.d in method: com.tencent.mm.plugin.facedetectlight.ui.a.5.run():void, file: classes7.dex
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
                                    	at jadx.core.codegen.RegionGen.makeCatchBlock(RegionGen.java:362)
                                    	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:317)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:69)
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
                                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0095: CONSTRUCTOR  (r2v0 com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI$2) = 
                                      (wrap: com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI : 0x008d: IGET  (r0v6 com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI) = 
                                      (wrap: com.tencent.mm.plugin.facedetectlight.ui.a : 0x008b: IGET  (r0v5 com.tencent.mm.plugin.facedetectlight.ui.a) = (r7v0 'this' com.tencent.mm.plugin.facedetectlight.ui.a$5 A[IMMUTABLE_TYPE, THIS]) com.tencent.mm.plugin.facedetectlight.ui.a.5.sZn com.tencent.mm.plugin.facedetectlight.ui.a)
                                     com.tencent.mm.plugin.facedetectlight.ui.a.sXH com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI)
                                     call: com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI.2.<init>(com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.facedetectlight.ui.a.5.run():void, file: classes7.dex
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                    	... 25 more
                                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI, state: GENERATED_AND_UNLOADED
                                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                    	... 31 more
                                    */
                                /*
                                // Method dump skipped, instructions count: 159
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.facedetectlight.ui.a.AnonymousClass5.run():void");
                            }
                        });
                        AppMethodBeat.o(104297);
                        return;
                    }
                    Log.i("MicroMsg.FaceReflectCam", "back thread is not running");
                    AppMethodBeat.o(104297);
                }

                public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                    AppMethodBeat.i(104298);
                    Log.i("MicroMsg.FaceReflectCam", "surfaceDestroyed");
                    if (this.sZa != null) {
                        this.sZa.post(new Runnable() {
                            /* class com.tencent.mm.plugin.facedetectlight.ui.a.AnonymousClass6 */

                            public final void run() {
                                AppMethodBeat.i(104287);
                                a.this.aPK();
                                AppMethodBeat.o(104287);
                            }
                        });
                        if (this.sYZ != null) {
                            Log.i("MicroMsg.FaceReflectCam", "stop camera thread");
                            try {
                                Thread.sleep(500, 0);
                            } catch (InterruptedException e2) {
                                Log.i("MicroMsg.FaceReflectCam", "background thread sleep error：" + e2.getMessage());
                            }
                            if (Build.VERSION.SDK_INT >= 18) {
                                this.sYZ.quitSafely();
                            } else {
                                this.sYZ.quit();
                            }
                            try {
                                this.sYZ.join();
                                this.sYZ = null;
                                this.sZa = null;
                            } catch (InterruptedException e3) {
                                Log.i("MicroMsg.FaceReflectCam", "stop xbackground thread error：" + e3.getMessage());
                            }
                            Log.i("MicroMsg.FaceReflectCam", "stop camera thread finish");
                        }
                    } else {
                        Log.i("MicroMsg.FaceReflectCam", "back thread is not running");
                    }
                    AppMethodBeat.o(104298);
                    return false;
                }

                public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
                    AppMethodBeat.i(104299);
                    Log.i("MicroMsg.FaceReflectCam", "onSurfaceTextureAvailable, width: %s, height: %s", Integer.valueOf(i2), Integer.valueOf(i3));
                    j(surfaceTexture);
                    AppMethodBeat.o(104299);
                }

                public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
                }

                public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
                }

                private boolean cUc() {
                    int i2;
                    int i3;
                    Point point;
                    boolean z;
                    AppMethodBeat.i(104300);
                    Log.i("MicroMsg.FaceReflectCam", "start open camera");
                    this.sZc = false;
                    this.imf = true;
                    com.tencent.mm.compatible.c.a aVar = com.tencent.mm.compatible.c.a.gDs;
                    int anJ = com.tencent.mm.compatible.c.a.anJ();
                    int i4 = 0;
                    while (true) {
                        if (i4 >= anJ) {
                            i4 = -1;
                            break;
                        }
                        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                        Camera.getCameraInfo(i4, cameraInfo);
                        if (cameraInfo.facing == 1 && this.imf) {
                            Log.d("MicroMsg.FaceReflectCam", "hy: front Camera found");
                            break;
                        }
                        if (cameraInfo.facing == 0 && !this.imf) {
                            Log.d("MicroMsg.FaceReflectCam", "hy: front Camera found");
                            break;
                        }
                        i4++;
                    }
                    if (i4 == -1) {
                        Log.i("MicroMsg.FaceReflectCam", "not found available camera id");
                        AppMethodBeat.o(104300);
                        return false;
                    }
                    long currentTicks = Util.currentTicks();
                    Log.i("MicroMsg.FaceReflectCam", "openCameraRes：" + this.imk);
                    if (this.imk == null) {
                        Log.i("MicroMsg.FaceReflectCam", "openCameraRes is null");
                        if (this.sZl == 1) {
                            Log.i("MicroMsg.FaceReflectCam", "mFaceReflectController openCameraRe");
                            try {
                                this.imk = com.tencent.mm.compatible.deviceinfo.d.a(this.mContext, i4, null);
                            } catch (Exception e2) {
                                AppMethodBeat.o(104300);
                                return false;
                            }
                        } else {
                            Log.i("MicroMsg.FaceReflectCam", "mFaceActionUI openCameraRe");
                            this.imk = com.tencent.mm.compatible.deviceinfo.d.a(this.sXH.getContext(), i4, null);
                        }
                    }
                    if (this.imk == null) {
                        Log.i("MicroMsg.FaceReflectCam", "in open(), openCameraRes == null");
                        try {
                            IOException iOException = new IOException();
                            AppMethodBeat.o(104300);
                            throw iOException;
                        } catch (IOException e3) {
                            Log.i("MicroMsg.FaceReflectCam", "set cameraRes exception" + e3.getMessage());
                            AppMethodBeat.o(104300);
                            return false;
                        }
                    } else {
                        this.sZh = i4;
                        this.sZc = true;
                        Log.d("MicroMsg.FaceReflectCam", "openCamera done, cameraId=[%s] costTime=[%s]", Integer.valueOf(i4), Long.valueOf(Util.ticksToNow(currentTicks)));
                        this.sRI = this.imk.dYT;
                        this.sRH = this.imk.dYT % TXLiveConstants.RENDER_ROTATION_180 != 0;
                        this.sZb = this.imk.gGr;
                        if (this.sZb == null) {
                            Log.e("MicroMsg.FaceReflectCam", "in open(), camera == null, bNeedRotate=[%s]", Boolean.valueOf(this.sRH));
                            try {
                                IOException iOException2 = new IOException();
                                AppMethodBeat.o(104300);
                                throw iOException2;
                            } catch (IOException e4) {
                                Log.i("MicroMsg.FaceReflectCam", "set cameraRotation exception" + e4.getMessage());
                            }
                        }
                        try {
                            Camera.Parameters parameters = this.sZb.getParameters();
                            if (this.sZl == 1) {
                                i2 = this.mContext.getResources().getDisplayMetrics().widthPixels;
                                i3 = this.mContext.getResources().getDisplayMetrics().heightPixels;
                            } else {
                                i2 = this.sXH.getResources().getDisplayMetrics().widthPixels;
                                i3 = this.sXH.getResources().getDisplayMetrics().heightPixels;
                            }
                            if (parameters == null) {
                                AppMethodBeat.o(104300);
                                return false;
                            }
                            this.pbD = new Point(i2, i3);
                            Point point2 = this.pbD;
                            Point point3 = this.sRG;
                            String str = parameters.get("preview-size-values");
                            if (str == null) {
                                str = parameters.get("preview-size-value");
                            }
                            if (str != null) {
                                Log.d("MicroMsg.FaceReflectCam", "preview-size-values parameter: ".concat(String.valueOf(str)));
                                point = a(parameters, point2);
                            } else {
                                point = null;
                            }
                            if (point == null) {
                                point = new Point((point3.x >> 3) << 3, (point3.y >> 3) << 3);
                            }
                            this.sRF = point;
                            this.sRK = new Point(this.sRF);
                            Log.d("MicroMsg.FaceReflectCam", "getCameraResolution: " + this.pbD + " camera:" + this.sRF + "bestVideoEncodeSize: " + this.sRK);
                            this.mDesiredPreviewWidth = this.sRF.x;
                            this.mDesiredPreviewHeight = this.sRF.y;
                            parameters.setPreviewSize(this.mDesiredPreviewWidth, this.mDesiredPreviewHeight);
                            Log.e("MicroMsg.FaceReflectCam", "mDesiredPreviewWidth：" + this.mDesiredPreviewWidth);
                            Log.e("MicroMsg.FaceReflectCam", "mDesiredPreviewHeight：" + this.mDesiredPreviewHeight);
                            parameters.setZoom(0);
                            parameters.setSceneMode("auto");
                            try {
                                if (parameters.getSupportedFocusModes() == null || !parameters.getSupportedFocusModes().contains("auto")) {
                                    Log.i("MicroMsg.FaceReflectCam", "camera not support FOCUS_MODE_AUTO");
                                } else {
                                    Log.i("MicroMsg.FaceReflectCam", "set FocusMode to FOCUS_MODE_AUTO");
                                    parameters.setFocusMode("auto");
                                }
                            } catch (Exception e5) {
                                Log.e("MicroMsg.FaceReflectCam", "set focus mode error: %s", e5.getMessage());
                            }
                            List<Integer> supportedPreviewFormats = parameters.getSupportedPreviewFormats();
                            Iterator<Integer> it = supportedPreviewFormats.iterator();
                            boolean z2 = false;
                            while (true) {
                                if (!it.hasNext()) {
                                    z = false;
                                    break;
                                }
                                int intValue = it.next().intValue();
                                Log.d("MicroMsg.FaceReflectCam", "supportedPreviewFormat: ".concat(String.valueOf(intValue)));
                                if (intValue == 17) {
                                    z = true;
                                    break;
                                }
                                z2 = intValue == 842094169 ? true : z2;
                            }
                            if (z) {
                                parameters.setPreviewFormat(17);
                            } else if (z2) {
                                Log.e("MicroMsg.FaceReflectCam", "Preview not support PixelFormat.YCbCr_420_SP, but hasYU12");
                                parameters.setPreviewFormat(842094169);
                            } else {
                                Log.e("MicroMsg.FaceReflectCam", "Preview not support PixelFormat.YCbCr_420_SP. Use format: %s", supportedPreviewFormats.get(0));
                                parameters.setPreviewFormat(supportedPreviewFormats.get(0).intValue());
                            }
                            if (this.sRH) {
                                parameters.setRotation(this.sRI);
                            }
                            double d2 = this.sZg.getmAspectRatio();
                            Log.d("MicroMsg.FaceReflectCam", "original ratio=".concat(String.valueOf(d2)));
                            final double d3 = ((double) this.mDesiredPreviewWidth) / ((double) this.mDesiredPreviewHeight);
                            Log.d("MicroMsg.FaceReflectCam", "new ratio=".concat(String.valueOf(d3)));
                            if (d2 == d3) {
                                Log.d("MicroMsg.FaceReflectCam", "NO NEED reset ratio");
                            } else {
                                Log.d("MicroMsg.FaceReflectCam", "start reset ratio");
                                MMHandlerThread.postToMainThread(new Runnable() {
                                    /* class com.tencent.mm.plugin.facedetectlight.ui.a.AnonymousClass7 */

                                    public final void run() {
                                        AppMethodBeat.i(104288);
                                        Log.d("MicroMsg.FaceReflectCam", "reset ratio");
                                        int i2 = a.this.sZg.getContext().getResources().getDisplayMetrics().widthPixels;
                                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) a.this.sZg.getLayoutParams();
                                        layoutParams.width = (int) (((double) i2) * 0.7d);
                                        layoutParams.height = (int) (((double) layoutParams.width) * d3);
                                        layoutParams.addRule(13, -1);
                                        a.this.sZg.setLayoutParams(layoutParams);
                                        a.this.sZg.setAspectRatio(d3);
                                        Log.d("MicroMsg.FaceReflectCam", "after reset ratio=" + a.this.sZg.getmAspectRatio());
                                        AppMethodBeat.o(104288);
                                    }
                                });
                            }
                            a(parameters);
                            List<int[]> supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
                            Log.d("MicroMsg.FaceReflectCam", "range:" + supportedPreviewFpsRange.size());
                            for (int i5 = 0; i5 < supportedPreviewFpsRange.size(); i5++) {
                                int[] iArr = supportedPreviewFpsRange.get(i5);
                                for (int i6 = 0; i6 < iArr.length; i6++) {
                                    Log.i("MicroMsg.FaceReflectCam", "Camera SupportedPreviewFpsRange：", Integer.valueOf(iArr[i6]));
                                }
                            }
                            Log.i("MicroMsg.FaceReflectCam", "Camera preview-fps-range：" + parameters.get("preview-fps-range"));
                            Log.i("MicroMsg.FaceReflectCam", "Camera preview-fps-range：" + parameters.get("preview-frame-rate"));
                            try {
                                this.sZb.setParameters(parameters);
                            } catch (Exception e6) {
                                Log.printErrStackTrace("MicroMsg.FaceReflectCam", e6, "setParameters error", new Object[0]);
                            }
                            boolean z3 = this.sZc;
                            AppMethodBeat.o(104300);
                            return z3;
                        } catch (Exception e7) {
                            Log.printErrStackTrace("MicroMsg.FaceReflectCam", e7, "camera getParameters error: %s", e7.getMessage());
                            AppMethodBeat.o(104300);
                            return false;
                        }
                    }
                }

                public a(FaceActionUI faceActionUI, a.AbstractC1040a aVar) {
                    AppMethodBeat.i(104295);
                    this.sXH = faceActionUI;
                    this.sZc = false;
                    this.sTE = false;
                    this.sYZ = null;
                    this.sZc = false;
                    this.sZk = false;
                    this.sXn = aVar;
                    Log.i("MicroMsg.FaceReflectCam", "clicfg_face_action_copy_data :%b，enableCameraPreviewSy：%b", Boolean.valueOf(this.enable), Boolean.valueOf(this.RbQ));
                    AppMethodBeat.o(104295);
                }

                class c implements Runnable {
                    private byte[] data;
                    private Camera gII;

                    c(byte[] bArr, Camera camera) {
                        this.data = bArr;
                        this.gII = camera;
                    }

                    public final void run() {
                        AppMethodBeat.i(258258);
                        if (a.this.sZd && a.this.sTE && a.this.sZl == 2) {
                            a.b.sXv.a(this.data, this.gII);
                        }
                        AppMethodBeat.o(258258);
                    }
                }

                class b implements Runnable {
                    private byte[] RbT;
                    private Camera gII;

                    b(byte[] bArr, Camera camera) {
                        AppMethodBeat.i(258256);
                        byte[] bArr2 = new byte[bArr.length];
                        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                        this.RbT = bArr2;
                        this.gII = camera;
                        a.this.RbP.set(a.this.RbP.get() + 1);
                        AppMethodBeat.o(258256);
                    }

                    public final void run() {
                        AppMethodBeat.i(258257);
                        if (a.this.sZd && a.this.sTE && a.this.sZl == 2 && this.RbT != null && this.RbT.length > 0) {
                            a.b.sXv.a(this.RbT, this.gII);
                            this.RbT = null;
                            a.this.RbP.set(a.this.RbP.get() - 1);
                        }
                        AppMethodBeat.o(258257);
                    }
                }

                public final void aPK() {
                    AppMethodBeat.i(104302);
                    Log.i("MicroMsg.FaceReflectCam", "closeCamera start");
                    if (this.sZm != null) {
                        this.sZm.quit();
                        this.sZm = null;
                    }
                    if (this.sZb != null) {
                        try {
                            if (this.sTE) {
                                this.sTE = false;
                                this.sZb.stopPreview();
                                this.sZb.setPreviewCallback(null);
                                Log.i("MicroMsg.FaceReflectCam", "stop preview, not previewing");
                            }
                        } catch (Exception e2) {
                            Log.i("MicroMsg.FaceReflectCam", "Error setting camera preview: " + e2.getMessage());
                        }
                        try {
                            this.sZb.release();
                            this.sZb = null;
                            com.tencent.mm.plugin.facedetect.model.d.cSR().b(this.sVF);
                            a.b.sXv.sXm = null;
                            this.sZb = null;
                        } catch (Exception e3) {
                            Log.i("MicroMsg.FaceReflectCam", "Error setting camera preview: " + e3.getMessage());
                            this.sZb = null;
                        } catch (Throwable th) {
                            this.sZb = null;
                            AppMethodBeat.o(104302);
                            throw th;
                        }
                    }
                    Log.i("MicroMsg.FaceReflectCam", "closeCamera end");
                    AppMethodBeat.o(104302);
                }

                public final void cUd() {
                    AppMethodBeat.i(104303);
                    if (this.sYZ == null) {
                        Log.i("MicroMsg.FaceReflectCam", "start camera thread");
                        this.sYZ = com.tencent.f.c.d.hB("cameraBackground", 5);
                        this.sYZ.start();
                        this.sZa = new MMHandler(this.sYZ.getLooper());
                    }
                    AppMethodBeat.o(104303);
                }

                private static Point a(Camera.Parameters parameters, Point point) {
                    int i2;
                    int i3;
                    float f2;
                    AppMethodBeat.i(104304);
                    ArrayList<Camera.Size> arrayList = new ArrayList(parameters.getSupportedPreviewSizes());
                    Collections.sort(arrayList, new C1042a((byte) 0));
                    Point point2 = null;
                    float f3 = ((float) point.x) / ((float) point.y);
                    Log.d("MicroMsg.FaceReflectCam", "screen.x: %d, screen.y: %d, ratio: %f", Integer.valueOf(point.x), Integer.valueOf(point.y), Float.valueOf(f3));
                    long availableMemoryMB = Util.getAvailableMemoryMB(MMApplicationContext.getContext());
                    Log.d("MicroMsg.FaceReflectCam", "systemAvailableMemInMB: %d", Long.valueOf(availableMemoryMB));
                    int i4 = point.x;
                    int i5 = point.y;
                    float f4 = Float.POSITIVE_INFINITY;
                    for (Camera.Size size : arrayList) {
                        int i6 = size.width;
                        int i7 = size.height;
                        Log.i("MicroMsg.FaceReflectCam", "realWidth: %d, realHeight: %d", Integer.valueOf(i6), Integer.valueOf(i7));
                        int i8 = i6 * i7;
                        if (i8 >= 150400 && i8 <= 983040) {
                            boolean z = i6 > i7;
                            if (z) {
                                i2 = i7;
                            } else {
                                i2 = i6;
                            }
                            if (z) {
                                i3 = i6;
                            } else {
                                i3 = i7;
                            }
                            Log.d("MicroMsg.FaceReflectCam", "maybeFlippedWidth: %d, maybeFlippedHeight: %d", Integer.valueOf(i2), Integer.valueOf(i3));
                            if (i2 == point.x && i3 == point.y && k(i2, i3, availableMemoryMB)) {
                                Point point3 = new Point(i6, i7);
                                Log.i("MicroMsg.FaceReflectCam", "Found preview size exactly matching screen size: ".concat(String.valueOf(point3)));
                                AppMethodBeat.o(104304);
                                return point3;
                            }
                            float abs = Math.abs((((float) i2) / ((float) i3)) - f3);
                            if (i6 % 10 == 0) {
                                if (abs >= f4 || !k(i6, i7, availableMemoryMB)) {
                                    f2 = f4;
                                } else {
                                    f2 = abs;
                                    point2 = new Point(i6, i7);
                                }
                                Log.i("MicroMsg.FaceReflectCam", "diff:[%s] newdiff:[%s] w:[%s] h:[%s]", Float.valueOf(f2), Float.valueOf(abs), Integer.valueOf(i6), Integer.valueOf(i7));
                                f4 = f2;
                            }
                        }
                    }
                    if (point2 == null) {
                        Camera.Size previewSize = parameters.getPreviewSize();
                        if (previewSize != null) {
                            point2 = new Point(previewSize.width, previewSize.height);
                            Log.i("MicroMsg.FaceReflectCam", "No suitable preview sizes, using default: ".concat(String.valueOf(point2)));
                        } else {
                            Log.e("MicroMsg.FaceReflectCam", "hy: can not find default size!!");
                        }
                    }
                    Log.i("MicroMsg.FaceReflectCam", "Found best approximate preview size: ".concat(String.valueOf(point2)));
                    AppMethodBeat.o(104304);
                    return point2;
                }

                private static void a(Camera.Parameters parameters) {
                    boolean z;
                    AppMethodBeat.i(104305);
                    if (ae.gKt.gFP > 0) {
                        Log.i("MicroMsg.FaceReflectCam", "set frame rate > 0, do not try set preview fps range");
                        AppMethodBeat.o(104305);
                        return;
                    }
                    List<int[]> supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
                    if (supportedPreviewFpsRange == null || supportedPreviewFpsRange.size() == 0) {
                        AppMethodBeat.o(104305);
                        return;
                    }
                    int i2 = Integer.MIN_VALUE;
                    int i3 = Integer.MIN_VALUE;
                    boolean z2 = false;
                    int size = supportedPreviewFpsRange.size();
                    int i4 = 0;
                    while (i4 < size) {
                        int[] iArr = supportedPreviewFpsRange.get(i4);
                        if (iArr != null && iArr.length > 1) {
                            int i5 = iArr[0];
                            int i6 = iArr[1];
                            Log.i("MicroMsg.FaceReflectCam", "dkfps %d:[%d %d]", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6));
                            if (i5 >= 0 && i6 >= i5) {
                                if (i6 >= i3 && !z2) {
                                    i3 = i6;
                                    i2 = i5;
                                }
                                if (i6 >= 30000) {
                                    z = true;
                                    i4++;
                                    z2 = z;
                                }
                            }
                        }
                        z = z2;
                        i4++;
                        z2 = z;
                    }
                    Log.i("MicroMsg.FaceReflectCam", "dkfps get fit  [%d %d], max target fps %d", Integer.valueOf(i2), Integer.valueOf(i3), 30);
                    if (i2 == Integer.MAX_VALUE || i3 == Integer.MAX_VALUE) {
                        AppMethodBeat.o(104305);
                        return;
                    }
                    try {
                        parameters.setPreviewFpsRange(i2, i3);
                        Log.i("MicroMsg.FaceReflectCam", "set fps range %d %d", Integer.valueOf(i2), Integer.valueOf(i3));
                        AppMethodBeat.o(104305);
                    } catch (Exception e2) {
                        Log.i("MicroMsg.FaceReflectCam", "trySetPreviewFpsRangeParameters Exception, %s, %s", Looper.myLooper(), e2.getMessage());
                        AppMethodBeat.o(104305);
                    }
                }

                /* access modifiers changed from: package-private */
                /* renamed from: com.tencent.mm.plugin.facedetectlight.ui.a$a  reason: collision with other inner class name */
                public static class C1042a implements Comparator<Camera.Size> {
                    private C1042a() {
                    }

                    /* synthetic */ C1042a(byte b2) {
                        this();
                    }

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                    @Override // java.util.Comparator
                    public final /* bridge */ /* synthetic */ int compare(Camera.Size size, Camera.Size size2) {
                        Camera.Size size3 = size;
                        Camera.Size size4 = size2;
                        int i2 = size3.height * size3.width;
                        int i3 = size4.height * size4.width;
                        if (i3 < i2) {
                            return -1;
                        }
                        if (i3 > i2) {
                            return 1;
                        }
                        return 0;
                    }
                }

                private static boolean k(int i2, int i3, long j2) {
                    AppMethodBeat.i(104306);
                    double d2 = ((((((double) i2) * ((double) i3)) * 3.0d) / 2.0d) / 1024.0d) / 1024.0d;
                    Log.d("MicroMsg.FaceReflectCam", "dataSizeInMB: %f, availableMemInMb: %d", Double.valueOf(d2), Long.valueOf(j2));
                    if (((double) j2) / d2 >= 5.0d) {
                        AppMethodBeat.o(104306);
                        return true;
                    }
                    AppMethodBeat.o(104306);
                    return false;
                }

                static /* synthetic */ void a(a aVar, SurfaceTexture surfaceTexture) {
                    AppMethodBeat.i(258260);
                    Log.i("MicroMsg.FaceReflectCam", "start Preview");
                    Log.i("MicroMsg.FaceReflectCam", "mIsPreviewing is " + aVar.sTE);
                    if (aVar.sZb != null && !aVar.sTE) {
                        try {
                            aVar.sZb.setPreviewTexture(surfaceTexture);
                        } catch (IOException e2) {
                            Log.i("MicroMsg.FaceReflectCam", "start Preview failed ：" + e2.getMessage());
                        }
                        com.tencent.mm.plugin.facedetect.model.c.dj(aVar.mDesiredPreviewWidth, aVar.mDesiredPreviewHeight);
                        aVar.sZb.startPreview();
                        aVar.sTE = true;
                        Log.i("MicroMsg.FaceReflectCam", "start preview, is previewing");
                        if (aVar.sZl == 1) {
                            MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                                /* class com.tencent.mm.plugin.facedetectlight.ui.a.AnonymousClass8 */

                                public final void run() {
                                    AppMethodBeat.i(104290);
                                    a.s(a.this);
                                    AppMethodBeat.o(104290);
                                }
                            }, 500);
                        }
                    }
                    AppMethodBeat.o(258260);
                }

                static /* synthetic */ void s(a aVar) {
                    AppMethodBeat.i(258261);
                    aVar.sZj = aVar.sYY.getBitmap();
                    ThreadPool.post(new Runnable() {
                        /* class com.tencent.mm.plugin.facedetectlight.ui.a.AnonymousClass9 */

                        public final void run() {
                            AppMethodBeat.i(258255);
                            a aVar = a.this;
                            MMApplicationContext.getContext();
                            aVar.sZj = p.l(a.this.goe, a.this.sZj);
                            MMHandlerThread.postToMainThread(new Runnable() {
                                /* class com.tencent.mm.plugin.facedetectlight.ui.a.AnonymousClass9.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(104291);
                                    a.this.pcg.setImageBitmap(a.this.sZj);
                                    AppMethodBeat.o(104291);
                                }
                            });
                            AppMethodBeat.o(258255);
                        }
                    }, "saveFaceBitmap");
                    AppMethodBeat.o(258261);
                }
            }
