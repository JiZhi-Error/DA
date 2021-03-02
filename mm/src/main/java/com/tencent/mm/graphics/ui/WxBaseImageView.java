package com.tencent.mm.graphics.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.graphics.a.b;
import com.tencent.mm.graphics.a.c;
import com.tencent.mm.graphics.b.d;
import com.tencent.mm.graphics.c;
import com.tencent.mm.graphics.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.lang.ref.WeakReference;

public class WxBaseImageView extends FrameLayout {
    private long aWK;
    private boolean cxw;
    private ViewStub hkA;
    private ViewStub hkB;
    private ImageView hkC;
    public SubsamplingScaleImageView hkD;
    private b hkE;
    private a hkF;
    private c hkG;
    private boolean hkH;
    private a.C0348a hkI;
    private a.C0348a hkJ;
    private boolean hkK;
    private boolean hkL;
    private boolean hkM;
    private boolean hkN;
    private boolean hkO;
    private boolean hkP;
    private MMHandler hkQ;
    protected int imageHeight;
    protected int imageWidth;
    private Context mContext;
    private Rect mRect;

    public WxBaseImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public WxBaseImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(136229);
        this.hkA = null;
        this.hkB = null;
        this.hkC = null;
        this.hkD = null;
        this.hkE = null;
        this.hkF = null;
        this.hkG = c.Tile;
        this.hkH = false;
        this.mRect = new Rect();
        this.hkO = false;
        this.hkP = false;
        this.hkQ = null;
        this.mContext = context;
        LayoutInflater.from(getContext()).inflate(R.layout.c5z, (ViewGroup) this, true);
        this.hkA = (ViewStub) findViewById(R.id.icx);
        View inflate = this.hkA.inflate();
        if (inflate != null) {
            this.hkD = (SubsamplingScaleImageView) inflate;
            this.hkD.setVisibility(0);
        }
        com.tencent.mm.graphics.b.c cVar = com.tencent.mm.graphics.b.c.INSTANCE;
        if (!cVar.hki) {
            cVar.hki = true;
            Log.i("MicroMsg.Metronome", "[start] stack:%s", Util.getStack());
            cVar.axF().postFrameCallback(cVar);
        }
        d.INSTANCE.hkm = new WeakReference<>(this.mContext);
        this.hkD.setOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
            /* class com.tencent.mm.graphics.ui.WxBaseImageView.AnonymousClass1 */

            public final void onViewAttachedToWindow(View view) {
            }

            public final void onViewDetachedFromWindow(View view) {
                AppMethodBeat.i(136221);
                d.INSTANCE.axH();
                WxBaseImageView.a(WxBaseImageView.this);
                AppMethodBeat.o(136221);
            }
        });
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.a.WxBaseImageView);
        try {
            setTileBackgroundColor(obtainStyledAttributes.getColor(0, 0));
        } finally {
            obtainStyledAttributes.recycle();
            AppMethodBeat.o(136229);
        }
    }

    public boolean hasOverlappingRendering() {
        return false;
    }

    public void setTileBackgroundColor(int i2) {
        AppMethodBeat.i(224113);
        if (this.hkD != null) {
            this.hkD.setTileBackgroundColor(i2);
        }
        AppMethodBeat.o(224113);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(136230);
        super.onMeasure(i2, i3);
        this.mRect.left = getLeft();
        this.mRect.right = getRight();
        this.mRect.top = getTop();
        this.mRect.bottom = getBottom();
        if (!getGlobalVisibleRect(this.mRect)) {
            this.hkH = false;
        } else {
            Log.d("MicroMsg.WxBaseImageView", "alvinluo ImageView visible, can report");
            this.hkH = true;
            if (!this.hkP) {
                this.hkP = true;
                d dVar = d.INSTANCE;
                synchronized (dVar.hkp) {
                    try {
                        if (dVar.isRunning) {
                            Log.w("MicroMsg.PerformanceMonitor", "hy: already running. stop last and run new");
                            dVar.isRunning = false;
                        }
                        if (dVar.hko != null) {
                            dVar.hko.cancel();
                        }
                        System.gc();
                        dVar.hkn.clear();
                        if (!(dVar.hkm == null || dVar.hkm.get() == null)) {
                            dVar.hkn.put(2, new com.tencent.mm.graphics.b.b(dVar.hkm.get()));
                        }
                        i iVar = h.RTc;
                        d.AnonymousClass1 r3 = 
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x009a: CONSTRUCTOR  (r3v1 'r3' com.tencent.mm.graphics.b.d$1) = (r1v5 'dVar' com.tencent.mm.graphics.b.d) call: com.tencent.mm.graphics.b.d.1.<init>(com.tencent.mm.graphics.b.d):void type: CONSTRUCTOR in method: com.tencent.mm.graphics.ui.WxBaseImageView.onMeasure(int, int):void, file: classes8.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                            	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:306)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:69)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                            	at jadx.core.codegen.RegionGen.makeSynchronizedRegion(RegionGen.java:249)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:71)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:157)
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
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.graphics.b.d, state: GENERATED_AND_UNLOADED
                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                            	... 36 more
                            */
                        /*
                        // Method dump skipped, instructions count: 175
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.graphics.ui.WxBaseImageView.onMeasure(int, int):void");
                    }

                    public void setForceTileFlag(com.tencent.mm.graphics.a.c cVar) {
                        AppMethodBeat.i(136231);
                        Log.d("MicroMsg.WxBaseImageView", "hy: setting force tile flag; %s", cVar);
                        this.hkG = cVar;
                        AppMethodBeat.o(136231);
                    }

                    public final void a(String str, com.davemorrissey.labs.subscaleview.view.a aVar) {
                        AppMethodBeat.i(136232);
                        Log.d("MicroMsg.WxBaseImageView", "alvinluo: loading from local file: %s, width: %d, height: %d, %d", str, Integer.valueOf(this.imageWidth), Integer.valueOf(this.imageHeight), Integer.valueOf(hashCode()));
                        if (this.hkG == com.tencent.mm.graphics.a.c.Tile) {
                            if (this.hkD == null) {
                                Log.e("MicroMsg.WxBaseImageView", "alvinluo WxBaseImageView laodFile mTileIv is null");
                                AppMethodBeat.o(136232);
                                return;
                            } else if (str == null) {
                                Log.i("MicroMsg.WxBaseImageView", "alvinluo WxBaseImageView loadFile path is null");
                                AppMethodBeat.o(136232);
                                return;
                            } else {
                                this.hkA.setVisibility(0);
                                com.davemorrissey.labs.subscaleview.view.a aP = com.davemorrissey.labs.subscaleview.view.a.aP(str);
                                int i2 = this.imageWidth;
                                int i3 = this.imageHeight;
                                if (aP.bitmap == null) {
                                    aP.aWX = i2;
                                    aP.aWY = i3;
                                }
                                if (aP.aWZ != null) {
                                    aP.aWW = true;
                                    aP.aWX = aP.aWZ.width();
                                    aP.aWY = aP.aWZ.height();
                                }
                                this.aWK = System.currentTimeMillis();
                                Log.i("MicroMsg.WxBaseImageView", "alvinluo onStartLoad imagePath: %s, mStartLoadTime: %d", str, Long.valueOf(this.aWK));
                                this.hkJ = new a.C0348a();
                                this.hkJ.imageType = 22;
                                this.hkJ.imagePath = str;
                                this.hkJ.from = getActivityName();
                                this.hkL = true;
                                if (aVar != null) {
                                    this.hkI = new a.C0348a();
                                    if (aVar.getUri() != null) {
                                        this.hkI.imagePath = aVar.getUri().toString();
                                    } else {
                                        this.hkI.imagePath = "";
                                    }
                                    Log.d("MicroMsg.WxBaseImageView", "alvinluo onStartLoad previewImagePath: %s", this.hkI.imagePath);
                                    this.hkI.imageType = 21;
                                    this.hkI.from = getActivityName();
                                    this.hkK = true;
                                } else {
                                    this.hkK = false;
                                }
                                if (aVar != null) {
                                    this.hkD.a(aP, aVar);
                                    AppMethodBeat.o(136232);
                                    return;
                                }
                                this.hkD.setImage(aP);
                            }
                        }
                        AppMethodBeat.o(136232);
                    }

                    public final void cN(int i2, int i3) {
                        this.imageWidth = i2;
                        this.imageHeight = i3;
                    }

                    /* access modifiers changed from: protected */
                    public final void a(View.OnTouchListener onTouchListener) {
                        if (this.hkD != null) {
                            this.hkD.aZa = onTouchListener;
                        }
                    }

                    public PointF getImageViewMatrixScale() {
                        AppMethodBeat.i(224114);
                        if (this.hkD != null) {
                            PointF imageViewMatrixScale = this.hkD.getImageViewMatrixScale();
                            AppMethodBeat.o(224114);
                            return imageViewMatrixScale;
                        }
                        AppMethodBeat.o(224114);
                        return null;
                    }

                    public PointF getImageViewMatrixTranslation() {
                        AppMethodBeat.i(224115);
                        if (this.hkD != null) {
                            PointF imageViewMatrixTranslation = this.hkD.getImageViewMatrixTranslation();
                            AppMethodBeat.o(224115);
                            return imageViewMatrixTranslation;
                        }
                        AppMethodBeat.o(224115);
                        return null;
                    }

                    public void setImageViewMatrix(Matrix matrix) {
                        AppMethodBeat.i(224116);
                        if (this.hkD != null) {
                            this.hkD.setImageViewMatrix(matrix);
                        }
                        AppMethodBeat.o(224116);
                    }

                    public void setScaleRate(float f2) {
                        AppMethodBeat.i(136233);
                        if (this.hkD != null) {
                            this.hkD.setScaleRate(f2);
                        }
                        AppMethodBeat.o(136233);
                    }

                    public void setEdgeSwipeListener(SubsamplingScaleImageView.c cVar) {
                        AppMethodBeat.i(136234);
                        this.hkD.setEdgeSwipeListener(cVar);
                        AppMethodBeat.o(136234);
                    }

                    public void setAnimateMode(com.tencent.mm.graphics.a.a aVar) {
                        AppMethodBeat.i(136235);
                        Log.d("MicroMsg.WxBaseImageView", "hy: set current animation mode: %s", aVar);
                        AppMethodBeat.o(136235);
                    }

                    public void setFitType(ImageView.ScaleType scaleType) {
                        AppMethodBeat.i(136236);
                        Log.d("MicroMsg.WxBaseImageView", "hy: set fit type: %s", scaleType);
                        AppMethodBeat.o(136236);
                    }

                    public Bitmap getFullImageBitmap() {
                        AppMethodBeat.i(136237);
                        if (this.hkD != null) {
                            Bitmap fullImageBitmap = this.hkD.getFullImageBitmap();
                            AppMethodBeat.o(136237);
                            return fullImageBitmap;
                        }
                        AppMethodBeat.o(136237);
                        return null;
                    }

                    public void setGestureDetectorListener(GestureDetector.SimpleOnGestureListener simpleOnGestureListener) {
                        AppMethodBeat.i(136238);
                        if (this.hkD != null) {
                            this.hkD.setGestureDetectorListener(simpleOnGestureListener);
                        }
                        AppMethodBeat.o(136238);
                    }

                    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
                        AppMethodBeat.i(136239);
                        if (this.hkD != null) {
                            this.hkD.setOnLongClickListener(onLongClickListener);
                        }
                        AppMethodBeat.o(136239);
                    }

                    public void setOnImageLoadEventListener(final b bVar) {
                        AppMethodBeat.i(136240);
                        if (this.hkD != null) {
                            this.hkE = new b() {
                                /* class com.tencent.mm.graphics.ui.WxBaseImageView.AnonymousClass3 */

                                @Override // com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView.e
                                public final void sb() {
                                    AppMethodBeat.i(136223);
                                    WxBaseImageView.d(WxBaseImageView.this);
                                    if (bVar != null) {
                                        bVar.sb();
                                    }
                                    AppMethodBeat.o(136223);
                                }

                                @Override // com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView.e
                                public final void n(Bitmap bitmap) {
                                    AppMethodBeat.i(136224);
                                    WxBaseImageView.e(WxBaseImageView.this);
                                    if (bVar != null) {
                                        bVar.n(bitmap);
                                    }
                                    AppMethodBeat.o(136224);
                                }

                                @Override // com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView.e
                                public final void a(com.davemorrissey.labs.subscaleview.a.c cVar) {
                                    AppMethodBeat.i(136225);
                                    WxBaseImageView.a(WxBaseImageView.this, cVar);
                                    if (bVar != null) {
                                        bVar.a(cVar);
                                    }
                                    AppMethodBeat.o(136225);
                                }

                                @Override // com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView.e
                                public final void b(com.davemorrissey.labs.subscaleview.a.c cVar) {
                                    AppMethodBeat.i(136226);
                                    WxBaseImageView.b(WxBaseImageView.this, cVar);
                                    if (bVar != null) {
                                        bVar.b(cVar);
                                    }
                                    AppMethodBeat.o(136226);
                                }

                                @Override // com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView.e
                                public final void c(com.davemorrissey.labs.subscaleview.a.c cVar) {
                                    AppMethodBeat.i(136227);
                                    WxBaseImageView.b(WxBaseImageView.this, cVar);
                                    if (bVar != null) {
                                        bVar.c(cVar);
                                    }
                                    AppMethodBeat.o(136227);
                                }

                                @Override // com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView.e
                                public final void sc() {
                                    AppMethodBeat.i(136228);
                                    Log.i("MicroMsg.WxBaseImageView", "alvinluo onPreviewReleased");
                                    if (bVar != null) {
                                        bVar.sc();
                                    }
                                    AppMethodBeat.o(136228);
                                }
                            };
                            this.hkD.setOnImageEventListener(this.hkE);
                        }
                        AppMethodBeat.o(136240);
                    }

                    public float getScale() {
                        AppMethodBeat.i(136241);
                        if (this.hkD != null) {
                            float scale = this.hkD.getScale();
                            AppMethodBeat.o(136241);
                            return scale;
                        }
                        AppMethodBeat.o(136241);
                        return 1.0f;
                    }

                    public final void axJ() {
                        AppMethodBeat.i(136242);
                        if (this.hkD != null) {
                            SubsamplingScaleImageView subsamplingScaleImageView = this.hkD;
                            subsamplingScaleImageView.a(subsamplingScaleImageView.aYR, new PointF(0.0f, 0.0f));
                        }
                        AppMethodBeat.o(136242);
                    }

                    public void setMinScale(float f2) {
                        AppMethodBeat.i(224117);
                        if (this.hkD != null) {
                            this.hkD.setMinScale(f2);
                        }
                        AppMethodBeat.o(224117);
                    }

                    public float getMinScale() {
                        AppMethodBeat.i(224118);
                        if (this.hkD != null) {
                            float minScale = this.hkD.getMinScale();
                            AppMethodBeat.o(224118);
                            return minScale;
                        }
                        AppMethodBeat.o(224118);
                        return 1.0f;
                    }

                    public void l(float f2, float f3, float f4) {
                        AppMethodBeat.i(224119);
                        if (this.hkD != null) {
                            SubsamplingScaleImageView subsamplingScaleImageView = this.hkD;
                            PointF pointF = new PointF(f3, f4);
                            Log.v(subsamplingScaleImageView.TAG, "alvinluo zoomToWithAnimation target scale: %s, mScaleRate: %s", Float.valueOf(f2), Float.valueOf(subsamplingScaleImageView.aYR));
                            SubsamplingScaleImageView.b bVar = new SubsamplingScaleImageView.b(subsamplingScaleImageView, f2, subsamplingScaleImageView.a(pointF), (byte) 0);
                            bVar.aZu = false;
                            bVar.duration = (long) subsamplingScaleImageView.aXH;
                            bVar.aZw = 4;
                            bVar.start();
                            subsamplingScaleImageView.invalidate();
                        }
                        AppMethodBeat.o(224119);
                    }

                    public float y(float f2, float f3) {
                        AppMethodBeat.i(224120);
                        if (this.hkD != null) {
                            SubsamplingScaleImageView subsamplingScaleImageView = this.hkD;
                            PointF pointF = new PointF(f2, f3);
                            float a2 = subsamplingScaleImageView.a(subsamplingScaleImageView.a(pointF), pointF);
                            AppMethodBeat.o(224120);
                            return a2;
                        }
                        AppMethodBeat.o(224120);
                        return 0.0f;
                    }

                    public void setCustomScaleRate(Float f2) {
                        AppMethodBeat.i(224121);
                        if (!(this.hkD == null || f2 == null)) {
                            this.hkD.setScaleRate(f2.floatValue());
                        }
                        AppMethodBeat.o(224121);
                    }

                    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
                        AppMethodBeat.i(224122);
                        if (this.hkD != null) {
                            this.hkD.setOnDoubleTapListener(onDoubleTapListener);
                        }
                        AppMethodBeat.o(224122);
                    }

                    public void setOnZoomScaleChangedListener(SubsamplingScaleImageView.f fVar) {
                        AppMethodBeat.i(224123);
                        if (this.hkD != null) {
                            this.hkD.setOnStateChangedListener(fVar);
                        }
                        AppMethodBeat.o(224123);
                    }

                    public void setAllowInterceptTouchEvent(boolean z) {
                        AppMethodBeat.i(224124);
                        if (this.hkD != null) {
                            this.hkD.setAllowInterceptTouchEvent(z);
                        }
                        AppMethodBeat.o(224124);
                    }

                    private String getActivityName() {
                        AppMethodBeat.i(136243);
                        if (this.mContext == null || !(this.mContext instanceof Activity)) {
                            AppMethodBeat.o(136243);
                            return "Default";
                        }
                        String simpleName = ((Activity) this.mContext).getClass().getSimpleName();
                        AppMethodBeat.o(136243);
                        return simpleName;
                    }

                    private void pC(int i2) {
                        AppMethodBeat.i(136244);
                        try {
                            if (!(this.hkD == null || this.hkI == null)) {
                                this.hkI.hkv = (int) (System.currentTimeMillis() - this.aWK);
                                com.davemorrissey.labs.subscaleview.d.a imageDecodeRecord = this.hkD.getImageDecodeRecord();
                                if (imageDecodeRecord != null) {
                                    this.hkI.hkw = imageDecodeRecord.aWS;
                                } else {
                                    this.hkI.hkw = 0;
                                }
                                this.hkI.hku = i2;
                                this.hkI.orientation = this.hkD.getPreviewOrientation();
                                this.hkI.width = this.hkD.getPreviewWidth();
                                this.hkI.height = this.hkD.getPreviewHeight();
                                this.hkI.aXk = 1;
                                this.hkI.fileSize = (int) s.boW(this.hkI.imagePath);
                            }
                            AppMethodBeat.o(136244);
                        } catch (Exception e2) {
                            Log.printErrStackTrace("MicroMsg.WxBaseImageView", e2, "alvinluo fillPreviewInfo exception", new Object[0]);
                            AppMethodBeat.o(136244);
                        }
                    }

                    private void pD(int i2) {
                        AppMethodBeat.i(136245);
                        try {
                            if (!(this.hkD == null || this.hkJ == null)) {
                                this.hkJ.hkv = (int) (System.currentTimeMillis() - this.aWK);
                                com.davemorrissey.labs.subscaleview.d.a imageDecodeRecord = this.hkD.getImageDecodeRecord();
                                if (imageDecodeRecord != null) {
                                    this.hkJ.hkw = imageDecodeRecord.aWU + imageDecodeRecord.aWT;
                                } else {
                                    this.hkI.hkw = 0;
                                }
                                this.hkJ.hku = i2;
                                this.hkJ.orientation = this.hkD.getRequiredRotation();
                                this.hkJ.width = this.hkD.getSWidth();
                                this.hkJ.height = this.hkD.getSHeight();
                                this.hkJ.aXk = this.hkD.getFullImageSampleSize();
                                this.hkJ.fileSize = (int) s.boW(this.hkJ.imagePath);
                            }
                            AppMethodBeat.o(136245);
                        } catch (Exception e2) {
                            Log.printErrStackTrace("MicroMsg.WxBaseImageView", e2, "alvinluo fillMainInfo exception", new Object[0]);
                            AppMethodBeat.o(136245);
                        }
                    }

                    private void axK() {
                        AppMethodBeat.i(136246);
                        if (!this.hkH) {
                            AppMethodBeat.o(136246);
                        } else if (this.cxw) {
                            AppMethodBeat.o(136246);
                        } else if (this.hkK && !this.hkM) {
                            AppMethodBeat.o(136246);
                        } else if (!this.hkL || this.hkN) {
                            Log.i("MicroMsg.WxBaseImageView", "alvinluo reportImageInfo info ready and report");
                            a aVar = a.INSTANCE;
                            a.a(this.hkJ, this.hkI);
                            this.cxw = true;
                            AppMethodBeat.o(136246);
                        } else {
                            AppMethodBeat.o(136246);
                        }
                    }

                    static /* synthetic */ void a(WxBaseImageView wxBaseImageView) {
                        AppMethodBeat.i(136247);
                        if (com.tencent.mm.graphics.b.c.INSTANCE.hki) {
                            com.tencent.mm.graphics.b.c.INSTANCE.stop();
                        }
                        if (!wxBaseImageView.hkH) {
                            Log.i("MicroMsg.WxBaseImageView", "alvinluo hasReportPerformance can't report");
                            AppMethodBeat.o(136247);
                        } else if (wxBaseImageView.hkO) {
                            Log.i("MicroMsg.WxBaseImageView", "alvinluo hasReportPerformance and return");
                            AppMethodBeat.o(136247);
                        } else {
                            if (wxBaseImageView.hkQ == null) {
                                wxBaseImageView.hkQ = new MMHandler("WxBaseImageViewReport");
                            }
                            wxBaseImageView.hkQ.postToWorker(new Runnable() {
                                /* class com.tencent.mm.graphics.ui.WxBaseImageView.AnonymousClass2 */

                                public final void run() {
                                    AppMethodBeat.i(136222);
                                    synchronized (this) {
                                        try {
                                            Log.i("MicroMsg.WxBaseImageView", "alvinluo reportPerformanceInfo threadId: %d", Long.valueOf(Thread.currentThread().getId()));
                                            com.tencent.mm.graphics.b.b axG = d.INSTANCE.axG();
                                            a aVar = a.INSTANCE;
                                            a.a(axG);
                                            WxBaseImageView.this.hkO = true;
                                            WxBaseImageView.c(WxBaseImageView.this);
                                        } finally {
                                            AppMethodBeat.o(136222);
                                        }
                                    }
                                }
                            });
                            AppMethodBeat.o(136247);
                        }
                    }

                    static /* synthetic */ void c(WxBaseImageView wxBaseImageView) {
                        AppMethodBeat.i(136248);
                        try {
                            if (wxBaseImageView.hkQ != null) {
                                wxBaseImageView.hkQ.quit();
                            }
                            AppMethodBeat.o(136248);
                        } catch (Exception e2) {
                            Log.printErrStackTrace("MicroMsg.WxBaseImageView", e2, "alvinluo quitReportThread exception", new Object[0]);
                            AppMethodBeat.o(136248);
                        }
                    }

                    static /* synthetic */ void d(WxBaseImageView wxBaseImageView) {
                        AppMethodBeat.i(136249);
                        if (!(wxBaseImageView.hkD == null || wxBaseImageView.hkI == null || !wxBaseImageView.hkK)) {
                            wxBaseImageView.pC(0);
                            wxBaseImageView.hkI.hku = 0;
                            wxBaseImageView.hkM = true;
                            wxBaseImageView.axK();
                        }
                        AppMethodBeat.o(136249);
                    }

                    static /* synthetic */ void e(WxBaseImageView wxBaseImageView) {
                        AppMethodBeat.i(136250);
                        if (!(wxBaseImageView.hkD == null || wxBaseImageView.hkJ == null || !wxBaseImageView.hkL)) {
                            wxBaseImageView.pD(0);
                            wxBaseImageView.hkN = true;
                            wxBaseImageView.axK();
                        }
                        AppMethodBeat.o(136250);
                    }

                    static /* synthetic */ void a(WxBaseImageView wxBaseImageView, com.davemorrissey.labs.subscaleview.a.c cVar) {
                        AppMethodBeat.i(136251);
                        if (wxBaseImageView.hkI != null) {
                            wxBaseImageView.pC(cVar.errCode);
                            wxBaseImageView.hkM = true;
                            wxBaseImageView.axK();
                        }
                        AppMethodBeat.o(136251);
                    }

                    static /* synthetic */ void b(WxBaseImageView wxBaseImageView, com.davemorrissey.labs.subscaleview.a.c cVar) {
                        AppMethodBeat.i(136252);
                        if (wxBaseImageView.hkJ != null) {
                            wxBaseImageView.pD(cVar.errCode);
                            wxBaseImageView.hkN = true;
                            wxBaseImageView.axK();
                        }
                        AppMethodBeat.o(136252);
                    }
                }
