package com.tencent.scanlib.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.TextureView;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.scanlib.a.b;
import com.tencent.scanlib.a.c;
import com.tencent.scanlib.a.f;
import com.tencent.stubs.logger.Log;

public abstract class ScanView extends FrameLayout implements Camera.AutoFocusCallback, Camera.PreviewCallback, TextureView.SurfaceTextureListener {
    protected static int ROZ = 80;
    protected static int RPb = 1000;
    public f ROY;
    private long RPa;
    private b RPc = new b(Looper.myLooper());
    private a RPd = new a(Looper.myLooper());
    protected TextureView bec;
    private long lastShotTime;
    private int screenOrientation;
    protected SurfaceTexture surfaceTexture;

    static /* synthetic */ Matrix a(ScanView scanView, Point point, Point point2) {
        float f2;
        float f3;
        Log.i("ScanView", "from " + point + " to " + point2);
        Matrix matrix = new Matrix();
        scanView.bec.getTransform(matrix);
        matrix.reset();
        Log.i("ScanView", "before matrix ".concat(String.valueOf(matrix)));
        if (point.equals(point2)) {
            return matrix;
        }
        int cameraRotation = scanView.ROY.getCameraRotation();
        Point hkV = scanView.ROY.hkV();
        int i2 = (hkV.x - point2.x) / 2;
        int i3 = (hkV.y - point2.y) / 2;
        if (cameraRotation % TXLiveConstants.RENDER_ROTATION_180 != 0) {
            f2 = (((float) point2.x) * 1.0f) / ((float) point.y);
            f3 = (((float) point2.y) * 1.0f) / ((float) point.x);
            i2 = (hkV.y - point2.x) / 2;
            i3 = (hkV.x - point2.y) / 2;
        } else {
            f2 = (((float) point2.x) * 1.0f) / ((float) point.x);
            f3 = (((float) point2.y) * 1.0f) / ((float) point.y);
        }
        float max = Math.max(f2, f3);
        Log.i("ScanView", "scaleX %f, scaleY %f, scale %f, dx %d, dy %d", Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(max), Integer.valueOf(i2), Integer.valueOf(i3));
        matrix.preScale(1.0f / f2, 1.0f / f3);
        matrix.postScale(max, max);
        matrix.postTranslate((float) (-i2), (float) (-i3));
        Log.i("ScanView", "after matrix ".concat(String.valueOf(matrix)));
        return matrix;
    }

    public ScanView(Context context) {
        super(context);
    }

    public ScanView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ScanView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public void onCreate() {
        Log.i("ScanView", "onCreate");
        init();
    }

    public void onResume() {
        Log.i("ScanView", "onResume");
    }

    public void onPause() {
        Log.i("ScanView", "onPause");
    }

    public void onStop() {
        Log.i("ScanView", "onStop");
    }

    public void onDestroy() {
        Log.i("ScanView", "onDestroy");
        this.bec.setSurfaceTextureListener(null);
    }

    /* access modifiers changed from: protected */
    public void eQY() {
        this.ROY = new com.tencent.scanlib.a.a();
    }

    /* access modifiers changed from: protected */
    public void init() {
        this.bec = new TextureView(getContext());
        this.bec.setSurfaceTextureListener(this);
        addView(this.bec, new FrameLayout.LayoutParams(-1, -1));
        eQY();
        this.screenOrientation = getResources().getConfiguration().orientation;
        a((b.AbstractCallableC2185b.a) null);
    }

    public void a(b.AbstractCallableC2185b.a aVar) {
        Log.i("ScanView", "try open camera");
        if (!this.ROY.isOpen()) {
            Log.i("ScanView", "camera is not open");
            int rotation = ((Activity) getContext()).getWindowManager().getDefaultDisplay().getRotation();
            c hkZ = c.hkZ();
            hkZ.ROp.submit(
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x003e: INVOKE  
                  (wrap: java.util.concurrent.ExecutorService : 0x0037: IGET  (r0v10 java.util.concurrent.ExecutorService) = (r1v3 'hkZ' com.tencent.scanlib.a.c) com.tencent.scanlib.a.c.ROp java.util.concurrent.ExecutorService)
                  (wrap: com.tencent.scanlib.a.c$1 : 0x003b: CONSTRUCTOR  (r3v1 com.tencent.scanlib.a.c$1) = 
                  (r1v3 'hkZ' com.tencent.scanlib.a.c)
                  (wrap: com.tencent.scanlib.a.b$g : 0x0034: CONSTRUCTOR  (r2v0 com.tencent.scanlib.a.b$g) = 
                  (wrap: com.tencent.scanlib.a.f : 0x0032: IGET  (r3v0 com.tencent.scanlib.a.f) = (r4v0 'this' com.tencent.scanlib.ui.ScanView A[IMMUTABLE_TYPE, THIS]) com.tencent.scanlib.ui.ScanView.ROY com.tencent.scanlib.a.f)
                  (r0v9 'rotation' int)
                 call: com.tencent.scanlib.a.b.g.<init>(com.tencent.scanlib.a.f, int):void type: CONSTRUCTOR)
                  (r5v0 'aVar' com.tencent.scanlib.a.b$b$a)
                 call: com.tencent.scanlib.a.c.1.<init>(com.tencent.scanlib.a.c, com.tencent.scanlib.a.b$b, com.tencent.scanlib.a.b$b$a):void type: CONSTRUCTOR)
                 type: INTERFACE call: java.util.concurrent.ExecutorService.submit(java.lang.Runnable):java.util.concurrent.Future in method: com.tencent.scanlib.ui.ScanView.a(com.tencent.scanlib.a.b$b$a):void, file: classes7.dex
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
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x003b: CONSTRUCTOR  (r3v1 com.tencent.scanlib.a.c$1) = 
                  (r1v3 'hkZ' com.tencent.scanlib.a.c)
                  (wrap: com.tencent.scanlib.a.b$g : 0x0034: CONSTRUCTOR  (r2v0 com.tencent.scanlib.a.b$g) = 
                  (wrap: com.tencent.scanlib.a.f : 0x0032: IGET  (r3v0 com.tencent.scanlib.a.f) = (r4v0 'this' com.tencent.scanlib.ui.ScanView A[IMMUTABLE_TYPE, THIS]) com.tencent.scanlib.ui.ScanView.ROY com.tencent.scanlib.a.f)
                  (r0v9 'rotation' int)
                 call: com.tencent.scanlib.a.b.g.<init>(com.tencent.scanlib.a.f, int):void type: CONSTRUCTOR)
                  (r5v0 'aVar' com.tencent.scanlib.a.b$b$a)
                 call: com.tencent.scanlib.a.c.1.<init>(com.tencent.scanlib.a.c, com.tencent.scanlib.a.b$b, com.tencent.scanlib.a.b$b$a):void type: CONSTRUCTOR in method: com.tencent.scanlib.ui.ScanView.a(com.tencent.scanlib.a.b$b$a):void, file: classes7.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                	... 21 more
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.scanlib.a.c, state: GENERATED_AND_UNLOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 27 more
                */
            /*
                this = this;
                java.lang.String r0 = "ScanView"
                java.lang.String r1 = "try open camera"
                com.tencent.stubs.logger.Log.i(r0, r1)
                com.tencent.scanlib.a.f r0 = r4.ROY
                boolean r0 = r0.isOpen()
                if (r0 != 0) goto L_0x0042
                java.lang.String r0 = "ScanView"
                java.lang.String r1 = "camera is not open"
                com.tencent.stubs.logger.Log.i(r0, r1)
                android.content.Context r0 = r4.getContext()
                android.app.Activity r0 = (android.app.Activity) r0
                android.view.WindowManager r0 = r0.getWindowManager()
                android.view.Display r0 = r0.getDefaultDisplay()
                int r0 = r0.getRotation()
                com.tencent.scanlib.a.c r1 = com.tencent.scanlib.a.c.hkZ()
                com.tencent.scanlib.a.b$g r2 = new com.tencent.scanlib.a.b$g
                com.tencent.scanlib.a.f r3 = r4.ROY
                r2.<init>(r3, r0)
                java.util.concurrent.ExecutorService r0 = r1.ROp
                com.tencent.scanlib.a.c$1 r3 = new com.tencent.scanlib.a.c$1
                r3.<init>(r2, r5)
                r0.submit(r3)
            L_0x0041:
                return
            L_0x0042:
                java.lang.String r0 = "ScanView"
                java.lang.String r1 = "camera is already open!"
                com.tencent.stubs.logger.Log.i(r0, r1)
                if (r5 == 0) goto L_0x0041
                r5.eRl()
                goto L_0x0041
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.scanlib.ui.ScanView.a(com.tencent.scanlib.a.b$b$a):void");
        }

        public final void aPK() {
            Log.i("ScanView", "try close camera");
            if (this.ROY.isOpen()) {
                c hkZ = c.hkZ();
                hkZ.ROp.submit(
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0023: INVOKE  
                      (wrap: java.util.concurrent.ExecutorService : 0x001c: IGET  (r2v1 java.util.concurrent.ExecutorService) = (r0v3 'hkZ' com.tencent.scanlib.a.c) com.tencent.scanlib.a.c.ROp java.util.concurrent.ExecutorService)
                      (wrap: com.tencent.scanlib.a.c$4 : 0x0020: CONSTRUCTOR  (r3v0 com.tencent.scanlib.a.c$4) = 
                      (r0v3 'hkZ' com.tencent.scanlib.a.c)
                      (wrap: com.tencent.scanlib.a.b$f : 0x0019: CONSTRUCTOR  (r1v1 com.tencent.scanlib.a.b$f) = 
                      (wrap: com.tencent.scanlib.a.f : 0x0017: IGET  (r2v0 com.tencent.scanlib.a.f) = (r4v0 'this' com.tencent.scanlib.ui.ScanView A[IMMUTABLE_TYPE, THIS]) com.tencent.scanlib.ui.ScanView.ROY com.tencent.scanlib.a.f)
                     call: com.tencent.scanlib.a.b.f.<init>(com.tencent.scanlib.a.f):void type: CONSTRUCTOR)
                     call: com.tencent.scanlib.a.c.4.<init>(com.tencent.scanlib.a.c, com.tencent.scanlib.a.b$a):void type: CONSTRUCTOR)
                     type: INTERFACE call: java.util.concurrent.ExecutorService.submit(java.lang.Runnable):java.util.concurrent.Future in method: com.tencent.scanlib.ui.ScanView.aPK():void, file: classes7.dex
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
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0020: CONSTRUCTOR  (r3v0 com.tencent.scanlib.a.c$4) = 
                      (r0v3 'hkZ' com.tencent.scanlib.a.c)
                      (wrap: com.tencent.scanlib.a.b$f : 0x0019: CONSTRUCTOR  (r1v1 com.tencent.scanlib.a.b$f) = 
                      (wrap: com.tencent.scanlib.a.f : 0x0017: IGET  (r2v0 com.tencent.scanlib.a.f) = (r4v0 'this' com.tencent.scanlib.ui.ScanView A[IMMUTABLE_TYPE, THIS]) com.tencent.scanlib.ui.ScanView.ROY com.tencent.scanlib.a.f)
                     call: com.tencent.scanlib.a.b.f.<init>(com.tencent.scanlib.a.f):void type: CONSTRUCTOR)
                     call: com.tencent.scanlib.a.c.4.<init>(com.tencent.scanlib.a.c, com.tencent.scanlib.a.b$a):void type: CONSTRUCTOR in method: com.tencent.scanlib.ui.ScanView.aPK():void, file: classes7.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                    	... 21 more
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.scanlib.a.c, state: GENERATED_AND_UNLOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                    	... 27 more
                    */
                /*
                    this = this;
                    java.lang.String r0 = "ScanView"
                    java.lang.String r1 = "try close camera"
                    com.tencent.stubs.logger.Log.i(r0, r1)
                    com.tencent.scanlib.a.f r0 = r4.ROY
                    boolean r0 = r0.isOpen()
                    if (r0 == 0) goto L_0x0026
                    com.tencent.scanlib.a.c r0 = com.tencent.scanlib.a.c.hkZ()
                    com.tencent.scanlib.a.b$f r1 = new com.tencent.scanlib.a.b$f
                    com.tencent.scanlib.a.f r2 = r4.ROY
                    r1.<init>(r2)
                    java.util.concurrent.ExecutorService r2 = r0.ROp
                    com.tencent.scanlib.a.c$4 r3 = new com.tencent.scanlib.a.c$4
                    r3.<init>(r1)
                    r2.submit(r3)
                L_0x0026:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.scanlib.ui.ScanView.aPK():void");
            }

            public final void a(b.c.a aVar) {
                int rotation = ((Activity) getContext()).getWindowManager().getDefaultDisplay().getRotation();
                Log.i("ScanView", "try reopen camera ".concat(String.valueOf(rotation)));
                c hkZ = c.hkZ();
                hkZ.ROp.submit(
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0035: INVOKE  
                      (wrap: java.util.concurrent.ExecutorService : 0x002e: IGET  (r0v5 java.util.concurrent.ExecutorService) = (r1v1 'hkZ' com.tencent.scanlib.a.c) com.tencent.scanlib.a.c.ROp java.util.concurrent.ExecutorService)
                      (wrap: com.tencent.scanlib.a.c$5 : 0x0032: CONSTRUCTOR  (r3v2 com.tencent.scanlib.a.c$5) = 
                      (r1v1 'hkZ' com.tencent.scanlib.a.c)
                      (wrap: com.tencent.scanlib.a.b$h : 0x002b: CONSTRUCTOR  (r2v2 com.tencent.scanlib.a.b$h) = 
                      (wrap: com.tencent.scanlib.a.f : 0x0029: IGET  (r3v1 com.tencent.scanlib.a.f) = (r4v0 'this' com.tencent.scanlib.ui.ScanView A[IMMUTABLE_TYPE, THIS]) com.tencent.scanlib.ui.ScanView.ROY com.tencent.scanlib.a.f)
                      (r0v4 'rotation' int)
                     call: com.tencent.scanlib.a.b.h.<init>(com.tencent.scanlib.a.f, int):void type: CONSTRUCTOR)
                      (r5v0 'aVar' com.tencent.scanlib.a.b$c$a)
                     call: com.tencent.scanlib.a.c.5.<init>(com.tencent.scanlib.a.c, com.tencent.scanlib.a.b$c, com.tencent.scanlib.a.b$c$a):void type: CONSTRUCTOR)
                     type: INTERFACE call: java.util.concurrent.ExecutorService.submit(java.lang.Runnable):java.util.concurrent.Future in method: com.tencent.scanlib.ui.ScanView.a(com.tencent.scanlib.a.b$c$a):void, file: classes7.dex
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
                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0032: CONSTRUCTOR  (r3v2 com.tencent.scanlib.a.c$5) = 
                      (r1v1 'hkZ' com.tencent.scanlib.a.c)
                      (wrap: com.tencent.scanlib.a.b$h : 0x002b: CONSTRUCTOR  (r2v2 com.tencent.scanlib.a.b$h) = 
                      (wrap: com.tencent.scanlib.a.f : 0x0029: IGET  (r3v1 com.tencent.scanlib.a.f) = (r4v0 'this' com.tencent.scanlib.ui.ScanView A[IMMUTABLE_TYPE, THIS]) com.tencent.scanlib.ui.ScanView.ROY com.tencent.scanlib.a.f)
                      (r0v4 'rotation' int)
                     call: com.tencent.scanlib.a.b.h.<init>(com.tencent.scanlib.a.f, int):void type: CONSTRUCTOR)
                      (r5v0 'aVar' com.tencent.scanlib.a.b$c$a)
                     call: com.tencent.scanlib.a.c.5.<init>(com.tencent.scanlib.a.c, com.tencent.scanlib.a.b$c, com.tencent.scanlib.a.b$c$a):void type: CONSTRUCTOR in method: com.tencent.scanlib.ui.ScanView.a(com.tencent.scanlib.a.b$c$a):void, file: classes7.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                    	... 14 more
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.scanlib.a.c, state: GENERATED_AND_UNLOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                    	... 20 more
                    */
                /*
                    this = this;
                    android.content.Context r0 = r4.getContext()
                    android.app.Activity r0 = (android.app.Activity) r0
                    android.view.WindowManager r0 = r0.getWindowManager()
                    android.view.Display r0 = r0.getDefaultDisplay()
                    int r0 = r0.getRotation()
                    java.lang.String r1 = "ScanView"
                    java.lang.String r2 = "try reopen camera "
                    java.lang.String r3 = java.lang.String.valueOf(r0)
                    java.lang.String r2 = r2.concat(r3)
                    com.tencent.stubs.logger.Log.i(r1, r2)
                    com.tencent.scanlib.a.c r1 = com.tencent.scanlib.a.c.hkZ()
                    com.tencent.scanlib.a.b$h r2 = new com.tencent.scanlib.a.b$h
                    com.tencent.scanlib.a.f r3 = r4.ROY
                    r2.<init>(r3, r0)
                    java.util.concurrent.ExecutorService r0 = r1.ROp
                    com.tencent.scanlib.a.c$5 r3 = new com.tencent.scanlib.a.c$5
                    r3.<init>(r2, r5)
                    r0.submit(r3)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.scanlib.ui.ScanView.a(com.tencent.scanlib.a.b$c$a):void");
            }

            public final void a(final b.d.a aVar) {
                Log.i("ScanView", "try start preview");
                if (this.ROY.isOpen() && !this.ROY.dEO() && this.surfaceTexture != null) {
                    c hkZ = c.hkZ();
                    hkZ.ROp.submit(
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0036: INVOKE  
                          (wrap: java.util.concurrent.ExecutorService : 0x002f: IGET  (r3v1 java.util.concurrent.ExecutorService) = (r0v6 'hkZ' com.tencent.scanlib.a.c) com.tencent.scanlib.a.c.ROp java.util.concurrent.ExecutorService)
                          (wrap: com.tencent.scanlib.a.c$2 : 0x0033: CONSTRUCTOR  (r4v0 com.tencent.scanlib.a.c$2) = 
                          (r0v6 'hkZ' com.tencent.scanlib.a.c)
                          (wrap: com.tencent.scanlib.a.b$i : 0x0027: CONSTRUCTOR  (r1v1 com.tencent.scanlib.a.b$i) = 
                          (wrap: com.tencent.scanlib.a.f : 0x0023: IGET  (r2v0 com.tencent.scanlib.a.f) = (r5v0 'this' com.tencent.scanlib.ui.ScanView A[IMMUTABLE_TYPE, THIS]) com.tencent.scanlib.ui.ScanView.ROY com.tencent.scanlib.a.f)
                          (wrap: android.graphics.SurfaceTexture : 0x0025: IGET  (r3v0 android.graphics.SurfaceTexture) = (r5v0 'this' com.tencent.scanlib.ui.ScanView A[IMMUTABLE_TYPE, THIS]) com.tencent.scanlib.ui.ScanView.surfaceTexture android.graphics.SurfaceTexture)
                         call: com.tencent.scanlib.a.b.i.<init>(com.tencent.scanlib.a.f, android.graphics.SurfaceTexture):void type: CONSTRUCTOR)
                          (wrap: com.tencent.scanlib.ui.ScanView$1 : 0x002c: CONSTRUCTOR  (r2v1 com.tencent.scanlib.ui.ScanView$1) = 
                          (r5v0 'this' com.tencent.scanlib.ui.ScanView A[IMMUTABLE_TYPE, THIS])
                          (r6v0 'aVar' com.tencent.scanlib.a.b$d$a A[SKIP_ARG])
                         call: com.tencent.scanlib.ui.ScanView.1.<init>(com.tencent.scanlib.ui.ScanView, com.tencent.scanlib.a.b$d$a):void type: CONSTRUCTOR)
                         call: com.tencent.scanlib.a.c.2.<init>(com.tencent.scanlib.a.c, com.tencent.scanlib.a.b$d, com.tencent.scanlib.a.b$d$a):void type: CONSTRUCTOR)
                         type: INTERFACE call: java.util.concurrent.ExecutorService.submit(java.lang.Runnable):java.util.concurrent.Future in method: com.tencent.scanlib.ui.ScanView.a(com.tencent.scanlib.a.b$d$a):void, file: classes7.dex
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
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.util.ArrayList.forEach(ArrayList.java:1259)
                        	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0033: CONSTRUCTOR  (r4v0 com.tencent.scanlib.a.c$2) = 
                          (r0v6 'hkZ' com.tencent.scanlib.a.c)
                          (wrap: com.tencent.scanlib.a.b$i : 0x0027: CONSTRUCTOR  (r1v1 com.tencent.scanlib.a.b$i) = 
                          (wrap: com.tencent.scanlib.a.f : 0x0023: IGET  (r2v0 com.tencent.scanlib.a.f) = (r5v0 'this' com.tencent.scanlib.ui.ScanView A[IMMUTABLE_TYPE, THIS]) com.tencent.scanlib.ui.ScanView.ROY com.tencent.scanlib.a.f)
                          (wrap: android.graphics.SurfaceTexture : 0x0025: IGET  (r3v0 android.graphics.SurfaceTexture) = (r5v0 'this' com.tencent.scanlib.ui.ScanView A[IMMUTABLE_TYPE, THIS]) com.tencent.scanlib.ui.ScanView.surfaceTexture android.graphics.SurfaceTexture)
                         call: com.tencent.scanlib.a.b.i.<init>(com.tencent.scanlib.a.f, android.graphics.SurfaceTexture):void type: CONSTRUCTOR)
                          (wrap: com.tencent.scanlib.ui.ScanView$1 : 0x002c: CONSTRUCTOR  (r2v1 com.tencent.scanlib.ui.ScanView$1) = 
                          (r5v0 'this' com.tencent.scanlib.ui.ScanView A[IMMUTABLE_TYPE, THIS])
                          (r6v0 'aVar' com.tencent.scanlib.a.b$d$a A[SKIP_ARG])
                         call: com.tencent.scanlib.ui.ScanView.1.<init>(com.tencent.scanlib.ui.ScanView, com.tencent.scanlib.a.b$d$a):void type: CONSTRUCTOR)
                         call: com.tencent.scanlib.a.c.2.<init>(com.tencent.scanlib.a.c, com.tencent.scanlib.a.b$d, com.tencent.scanlib.a.b$d$a):void type: CONSTRUCTOR in method: com.tencent.scanlib.ui.ScanView.a(com.tencent.scanlib.a.b$d$a):void, file: classes7.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                        	... 21 more
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.scanlib.a.c, state: GENERATED_AND_UNLOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                        	... 27 more
                        */
                    /*
                        this = this;
                        java.lang.String r0 = "ScanView"
                        java.lang.String r1 = "try start preview"
                        com.tencent.stubs.logger.Log.i(r0, r1)
                        com.tencent.scanlib.a.f r0 = r5.ROY
                        boolean r0 = r0.isOpen()
                        if (r0 == 0) goto L_0x0039
                        com.tencent.scanlib.a.f r0 = r5.ROY
                        boolean r0 = r0.dEO()
                        if (r0 != 0) goto L_0x0039
                        android.graphics.SurfaceTexture r0 = r5.surfaceTexture
                        if (r0 == 0) goto L_0x0039
                        com.tencent.scanlib.a.c r0 = com.tencent.scanlib.a.c.hkZ()
                        com.tencent.scanlib.a.b$i r1 = new com.tencent.scanlib.a.b$i
                        com.tencent.scanlib.a.f r2 = r5.ROY
                        android.graphics.SurfaceTexture r3 = r5.surfaceTexture
                        r1.<init>(r2, r3)
                        com.tencent.scanlib.ui.ScanView$1 r2 = new com.tencent.scanlib.ui.ScanView$1
                        r2.<init>(r6)
                        java.util.concurrent.ExecutorService r3 = r0.ROp
                        com.tencent.scanlib.a.c$2 r4 = new com.tencent.scanlib.a.c$2
                        r4.<init>(r1, r2)
                        r3.submit(r4)
                    L_0x0039:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.scanlib.ui.ScanView.a(com.tencent.scanlib.a.b$d$a):void");
                }

                public void stopPreview() {
                    Log.i("ScanView", "try stop preview");
                    if (this.ROY.isOpen()) {
                        c hkZ = c.hkZ();
                        hkZ.ROp.submit(
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0023: INVOKE  
                              (wrap: java.util.concurrent.ExecutorService : 0x001c: IGET  (r2v1 java.util.concurrent.ExecutorService) = (r0v3 'hkZ' com.tencent.scanlib.a.c) com.tencent.scanlib.a.c.ROp java.util.concurrent.ExecutorService)
                              (wrap: com.tencent.scanlib.a.c$3 : 0x0020: CONSTRUCTOR  (r3v0 com.tencent.scanlib.a.c$3) = 
                              (r0v3 'hkZ' com.tencent.scanlib.a.c)
                              (wrap: com.tencent.scanlib.a.b$j : 0x0019: CONSTRUCTOR  (r1v1 com.tencent.scanlib.a.b$j) = 
                              (wrap: com.tencent.scanlib.a.f : 0x0017: IGET  (r2v0 com.tencent.scanlib.a.f) = (r4v0 'this' com.tencent.scanlib.ui.ScanView A[IMMUTABLE_TYPE, THIS]) com.tencent.scanlib.ui.ScanView.ROY com.tencent.scanlib.a.f)
                             call: com.tencent.scanlib.a.b.j.<init>(com.tencent.scanlib.a.f):void type: CONSTRUCTOR)
                             call: com.tencent.scanlib.a.c.3.<init>(com.tencent.scanlib.a.c, com.tencent.scanlib.a.b$e):void type: CONSTRUCTOR)
                             type: INTERFACE call: java.util.concurrent.ExecutorService.submit(java.lang.Runnable):java.util.concurrent.Future in method: com.tencent.scanlib.ui.ScanView.stopPreview():void, file: classes7.dex
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
                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                            	at java.util.ArrayList.forEach(ArrayList.java:1259)
                            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0020: CONSTRUCTOR  (r3v0 com.tencent.scanlib.a.c$3) = 
                              (r0v3 'hkZ' com.tencent.scanlib.a.c)
                              (wrap: com.tencent.scanlib.a.b$j : 0x0019: CONSTRUCTOR  (r1v1 com.tencent.scanlib.a.b$j) = 
                              (wrap: com.tencent.scanlib.a.f : 0x0017: IGET  (r2v0 com.tencent.scanlib.a.f) = (r4v0 'this' com.tencent.scanlib.ui.ScanView A[IMMUTABLE_TYPE, THIS]) com.tencent.scanlib.ui.ScanView.ROY com.tencent.scanlib.a.f)
                             call: com.tencent.scanlib.a.b.j.<init>(com.tencent.scanlib.a.f):void type: CONSTRUCTOR)
                             call: com.tencent.scanlib.a.c.3.<init>(com.tencent.scanlib.a.c, com.tencent.scanlib.a.b$e):void type: CONSTRUCTOR in method: com.tencent.scanlib.ui.ScanView.stopPreview():void, file: classes7.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                            	... 21 more
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.scanlib.a.c, state: GENERATED_AND_UNLOADED
                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                            	... 27 more
                            */
                        /*
                            this = this;
                            java.lang.String r0 = "ScanView"
                            java.lang.String r1 = "try stop preview"
                            com.tencent.stubs.logger.Log.i(r0, r1)
                            com.tencent.scanlib.a.f r0 = r4.ROY
                            boolean r0 = r0.isOpen()
                            if (r0 == 0) goto L_0x0026
                            com.tencent.scanlib.a.c r0 = com.tencent.scanlib.a.c.hkZ()
                            com.tencent.scanlib.a.b$j r1 = new com.tencent.scanlib.a.b$j
                            com.tencent.scanlib.a.f r2 = r4.ROY
                            r1.<init>(r2)
                            java.util.concurrent.ExecutorService r2 = r0.ROp
                            com.tencent.scanlib.a.c$3 r3 = new com.tencent.scanlib.a.c$3
                            r3.<init>(r1)
                            r2.submit(r3)
                        L_0x0026:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.tencent.scanlib.ui.ScanView.stopPreview():void");
                    }

                    public void IC(long j2) {
                        long currentTimeMillis = System.currentTimeMillis() - this.lastShotTime;
                        if (currentTimeMillis > ((long) ROZ)) {
                            this.RPc.removeMessages(0);
                            this.RPc.sendEmptyMessageDelayed(0, j2);
                            return;
                        }
                        this.RPc.removeMessages(0);
                        this.RPc.sendEmptyMessageDelayed(0, (((long) ROZ) - currentTimeMillis) + j2);
                    }

                    /* access modifiers changed from: package-private */
                    public class b extends Handler {
                        b(Looper looper) {
                            super(looper);
                        }

                        public final void handleMessage(Message message) {
                            AppMethodBeat.i(3608);
                            ScanView.this.lastShotTime = System.currentTimeMillis();
                            Log.i("ScanView", "take one shot");
                            if (ScanView.this.ROY.dEO()) {
                                ScanView.this.ROY.a(ScanView.this);
                            }
                            AppMethodBeat.o(3608);
                        }
                    }

                    class a extends Handler {
                        a(Looper looper) {
                            super(looper);
                        }

                        public final void handleMessage(Message message) {
                            AppMethodBeat.i(3607);
                            ScanView.this.RPa = System.currentTimeMillis();
                            if (ScanView.this.ROY.dEO()) {
                                if (!"auto".equals(ScanView.this.ROY.getFocusMode())) {
                                    ScanView.this.ROY.setFocusMode("auto");
                                }
                                ScanView.this.ROY.autoFocus(ScanView.this);
                                Log.i("ScanView", "do auto focus");
                            }
                            AppMethodBeat.o(3607);
                        }
                    }

                    public void onAutoFocus(boolean z, Camera camera) {
                        Log.i("ScanView", "onAutoFocus %s", Boolean.valueOf(z));
                    }

                    public final void Oy(long j2) {
                        long currentTimeMillis = System.currentTimeMillis() - this.RPa;
                        if (currentTimeMillis > ((long) RPb)) {
                            this.RPd.removeMessages(0);
                            this.RPd.sendEmptyMessageDelayed(0, j2);
                            return;
                        }
                        this.RPd.removeMessages(0);
                        this.RPd.sendEmptyMessageDelayed(0, (((long) RPb) - currentTimeMillis) + j2);
                    }

                    /* access modifiers changed from: protected */
                    public void onDetachedFromWindow() {
                        super.onDetachedFromWindow();
                        stopPreview();
                        aPK();
                    }

                    public void onPreviewFrame(byte[] bArr, Camera camera) {
                        this.lastShotTime = 0;
                    }

                    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture2, final int i2, final int i3) {
                        Log.i("ScanView", "surface available, %d %d", Integer.valueOf(i2), Integer.valueOf(i3));
                        this.surfaceTexture = surfaceTexture2;
                        if (this.ROY.isOpen()) {
                            this.ROY.p(new Point(i2, i3));
                            a(new b.d.a() {
                                /* class com.tencent.scanlib.ui.ScanView.AnonymousClass2 */

                                @Override // com.tencent.scanlib.a.b.d.a
                                public final void eRk() {
                                    AppMethodBeat.i(174606);
                                    ScanView.this.IC(0);
                                    AppMethodBeat.o(174606);
                                }
                            });
                            return;
                        }
                        a(new b.AbstractCallableC2185b.a() {
                            /* class com.tencent.scanlib.ui.ScanView.AnonymousClass3 */

                            @Override // com.tencent.scanlib.a.b.AbstractCallableC2185b.a
                            public final void eRl() {
                                AppMethodBeat.i(3606);
                                ScanView.this.ROY.p(new Point(i2, i3));
                                ScanView.this.a(new b.d.a() {
                                    /* class com.tencent.scanlib.ui.ScanView.AnonymousClass3.AnonymousClass1 */

                                    @Override // com.tencent.scanlib.a.b.d.a
                                    public final void eRk() {
                                        AppMethodBeat.i(174607);
                                        ScanView.this.IC(0);
                                        AppMethodBeat.o(174607);
                                    }
                                });
                                AppMethodBeat.o(3606);
                            }
                        });
                    }

                    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture2, int i2, int i3) {
                        Log.i("ScanView", "surface size changed, %d %d", Integer.valueOf(i2), Integer.valueOf(i3));
                    }

                    /* access modifiers changed from: protected */
                    public void onConfigurationChanged(Configuration configuration) {
                        super.onConfigurationChanged(configuration);
                        Log.i("ScanView", "onConfigurationChanged %d,%d", Integer.valueOf(configuration.orientation), Integer.valueOf(this.screenOrientation));
                        if (configuration.orientation != this.screenOrientation && this.ROY != null) {
                            this.screenOrientation = configuration.orientation;
                            a(new b.c.a() {
                                /* class com.tencent.scanlib.ui.ScanView.AnonymousClass4 */

                                @Override // com.tencent.scanlib.a.b.c.a
                                public final void eRl() {
                                    AppMethodBeat.i(174609);
                                    ScanView.this.ROY.p(new Point(ScanView.this.bec.getWidth(), ScanView.this.bec.getHeight()));
                                    ScanView.this.a(new b.d.a() {
                                        /* class com.tencent.scanlib.ui.ScanView.AnonymousClass4.AnonymousClass1 */

                                        @Override // com.tencent.scanlib.a.b.d.a
                                        public final void eRk() {
                                            AppMethodBeat.i(174608);
                                            ScanView.this.IC(0);
                                            AppMethodBeat.o(174608);
                                        }
                                    });
                                    AppMethodBeat.o(174609);
                                }
                            });
                        }
                    }

                    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture2) {
                        Log.i("ScanView", "surface destroyed");
                        return true;
                    }

                    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture2) {
                    }
                }
