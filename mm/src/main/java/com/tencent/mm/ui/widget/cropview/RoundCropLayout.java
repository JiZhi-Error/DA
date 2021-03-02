package com.tencent.mm.ui.widget.cropview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.base.MultiTouchImageView;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0012\u0018\u00002\u00020\u0001:\u000267B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0012\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010#\u001a\u0004\u0018\u00010\u0018J0\u0010$\u001a\u00020 2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\t2\u0006\u0010(\u001a\u00020\t2\u0006\u0010)\u001a\u00020\t2\u0006\u0010*\u001a\u00020\tH\u0014J\u0010\u0010+\u001a\u00020 2\b\u0010,\u001a\u0004\u0018\u00010\u0018J\u000e\u0010-\u001a\u00020 2\u0006\u0010.\u001a\u00020\tJ\u000e\u0010/\u001a\u00020 2\u0006\u0010.\u001a\u00020\tJ\u000e\u00100\u001a\u00020 2\u0006\u00101\u001a\u00020\tJ\u000e\u00102\u001a\u00020 2\u0006\u00103\u001a\u00020\fJ\u0010\u00104\u001a\u00020 2\b\u00105\u001a\u0004\u0018\u00010\u000eR\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u0002\n\u0000¨\u00068"}, hxF = {"Lcom/tencent/mm/ui/widget/cropview/RoundCropLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "DEFAULT_CROP_WIDTH_RATIO", "", "TAG", "", "circleAreaPaint", "Landroid/graphics/Paint;", "circleLinePaint", "cropLayerColor", "cropLineColor", "cropLineWidth", "cropWidth", "cropWidthRatio", "imageBitmap", "Landroid/graphics/Bitmap;", "imageView", "Lcom/tencent/mm/ui/base/MultiTouchImageView;", "scaleDetector", "Landroid/view/ScaleGestureDetector;", "scrollDetector", "Landroid/view/GestureDetector;", "draw", "", "canvas", "Landroid/graphics/Canvas;", "getCropBitmap", "onLayout", "changed", "", "left", "top", "right", "bottom", "setBitmap", "bitmap", "setCropLayerColor", "colorValue", "setCropLineColor", "setCropWidth", "width", "setCropWidthRatio", "ratio", "setImagePath", "filePath", "ScrollScaleListener", "SimpleTouchListener", "libmmui_release"})
public final class RoundCropLayout extends FrameLayout {
    private ScaleGestureDetector QFu;
    private final float QMY;
    private float QMZ;
    private int QNa;
    private int QNb;
    private int QNc;
    private Paint QNd;
    private Paint QNe;
    private GestureDetector QNf;
    private final String TAG;
    private int hDQ;
    private Bitmap imageBitmap;
    private MultiTouchImageView lTJ;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public RoundCropLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
        p.h(context, "context");
        AppMethodBeat.i(164465);
        AppMethodBeat.o(164465);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RoundCropLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(164466);
        this.TAG = "MicroMsg.RoundCropLayout";
        this.QMY = 0.9f;
        this.QNa = -1;
        this.QNb = at.fromDPToPix(getContext(), 1);
        this.QNc = getResources().getColor(R.color.BW_0_Alpha_0_3);
        this.QNd = new Paint();
        this.QNe = new Paint();
        setWillNotDraw(false);
        this.QNd.setColor(this.QNa);
        this.QNd.setStrokeWidth((float) this.QNb);
        this.QNd.setAntiAlias(true);
        this.QNd.setStyle(Paint.Style.STROKE);
        this.QNe.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.lTJ = new MultiTouchImageView(context, null);
        addView(this.lTJ, 0, new FrameLayout.LayoutParams(-1, -1));
        a aVar = new a();
        this.QNf = new GestureDetector(context, aVar);
        this.QFu = new ScaleGestureDetector(context, aVar);
        this.QFu.setQuickScaleEnabled(true);
        this.lTJ.setOnTouchListener(new b());
        setCropWidthRatio(this.QMY);
        AppMethodBeat.o(164466);
    }

    public final void setCropWidthRatio(float f2) {
        this.QMZ = f2;
    }

    public final void setCropWidth(int i2) {
        this.hDQ = i2;
    }

    public final void setCropLineColor(int i2) {
        this.QNa = i2;
    }

    public final void setCropLayerColor(int i2) {
        this.QNc = i2;
    }

    public final void setBitmap(Bitmap bitmap) {
        AppMethodBeat.i(164460);
        this.imageBitmap = bitmap;
        Bitmap bitmap2 = this.imageBitmap;
        if (bitmap2 != null) {
            this.lTJ.setImageBitmap(bitmap2);
            this.lTJ.cN(bitmap2.getWidth(), bitmap2.getHeight());
            this.lTJ.gKy();
            AppMethodBeat.o(164460);
            return;
        }
        AppMethodBeat.o(164460);
    }

    public final void setImagePath(String str) {
        AppMethodBeat.i(164461);
        kotlin.c.a.ai(new c(this, str));
        AppMethodBeat.o(164461);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class c extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ RoundCropLayout QNg;
        final /* synthetic */ String msC;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(RoundCropLayout roundCropLayout, String str) {
            super(0);
            this.QNg = roundCropLayout;
            this.msC = str;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/ui/widget/cropview/RoundCropLayout$setImagePath$1$1$1"})
        static final class a implements Runnable {
            final /* synthetic */ c QNh;
            final /* synthetic */ Bitmap zZz;

            a(c cVar, Bitmap bitmap) {
                this.QNh = cVar;
                this.zZz = bitmap;
            }

            public final void run() {
                AppMethodBeat.i(164458);
                this.QNh.QNg.setBitmap(this.zZz);
                AppMethodBeat.o(164458);
            }
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(164459);
            Bitmap decodeFile = BitmapUtil.decodeFile(this.msC);
            if (decodeFile != null) {
                this.QNg.post(new a(this, decodeFile));
            }
            x xVar = x.SXb;
            AppMethodBeat.o(164459);
            return xVar;
        }
    }

    public final Bitmap getCropBitmap() {
        AppMethodBeat.i(164462);
        Bitmap bitmap = this.imageBitmap;
        if (bitmap != null) {
            int width = (getWidth() - this.hDQ) / 2;
            int height = (getHeight() - this.hDQ) / 2;
            Matrix matrix = new Matrix();
            this.lTJ.getImageMatrix().invert(matrix);
            RectF rectF = new RectF();
            matrix.mapRect(rectF, new RectF((float) width, (float) height, (float) (getWidth() - width), (float) (getHeight() - height)));
            Log.i(this.TAG, "cropArea ".concat(String.valueOf(rectF)));
            if (rectF.left < 0.0f) {
                rectF.left = 0.0f;
            }
            if (rectF.top < 0.0f) {
                rectF.top = 0.0f;
            }
            if (rectF.right > ((float) bitmap.getWidth())) {
                rectF.right = (float) bitmap.getWidth();
            }
            if (rectF.bottom > ((float) bitmap.getHeight())) {
                rectF.bottom = (float) bitmap.getHeight();
            }
            Log.i(this.TAG, "fix cropArea ".concat(String.valueOf(rectF)));
            if (rectF.width() > 0.0f && rectF.height() > 0.0f) {
                Bitmap bitmap2 = this.imageBitmap;
                if (bitmap2 == null) {
                    p.hyc();
                }
                Bitmap createBitmap = Bitmap.createBitmap(bitmap2, (int) rectF.left, (int) rectF.top, (int) rectF.width(), (int) rectF.height());
                AppMethodBeat.o(164462);
                return createBitmap;
            }
        }
        AppMethodBeat.o(164462);
        return null;
    }

    /* access modifiers changed from: protected */
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(164463);
        super.onLayout(z, i2, i3, i4, i5);
        if (this.hDQ == 0) {
            this.hDQ = (int) (this.QMZ * ((float) getWidth()));
        }
        AppMethodBeat.o(164463);
    }

    public final void draw(Canvas canvas) {
        AppMethodBeat.i(164464);
        super.draw(canvas);
        if (canvas != null) {
            int saveLayer = canvas.saveLayer(0.0f, 0.0f, (float) getWidth(), (float) getHeight(), null, 31);
            canvas.drawColor(this.QNc);
            canvas.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), ((float) (this.hDQ / 2)) + ((float) this.QNb), this.QNd);
            canvas.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), (float) (this.hDQ / 2), this.QNe);
            canvas.restoreToCount(saveLayer);
        }
        AppMethodBeat.o(164464);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, hxF = {"Lcom/tencent/mm/ui/widget/cropview/RoundCropLayout$SimpleTouchListener;", "Landroid/view/View$OnTouchListener;", "(Lcom/tencent/mm/ui/widget/cropview/RoundCropLayout;)V", "isScale", "", "onTouch", "v", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "libmmui_release"})
    final class b implements View.OnTouchListener {
        private boolean hDM;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public b() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(164457);
            Integer valueOf = motionEvent != null ? Integer.valueOf(motionEvent.getActionMasked()) : null;
            Log.d(RoundCropLayout.this.TAG, "action ".concat(String.valueOf(valueOf)));
            if (valueOf != null && valueOf.intValue() == 0) {
                this.hDM = false;
            } else if (valueOf != null && valueOf.intValue() == 5 && motionEvent.getPointerCount() == 2) {
                this.hDM = true;
            }
            RoundCropLayout.this.QFu.onTouchEvent(motionEvent);
            if (!this.hDM) {
                GestureDetector gestureDetector = RoundCropLayout.this.QNf;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, bl.axQ(), "com/tencent/mm/ui/widget/cropview/RoundCropLayout$SimpleTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
                com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, gestureDetector.onTouchEvent((MotionEvent) bl.pG(0)), "com/tencent/mm/ui/widget/cropview/RoundCropLayout$SimpleTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
            }
            AppMethodBeat.o(164457);
            return true;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u000b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\f\u001a\u00020\r2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J,\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/ui/widget/cropview/RoundCropLayout$ScrollScaleListener;", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "Landroid/view/ScaleGestureDetector$OnScaleGestureListener;", "(Lcom/tencent/mm/ui/widget/cropview/RoundCropLayout;)V", "onDown", "", "e", "Landroid/view/MotionEvent;", "onScale", "detector", "Landroid/view/ScaleGestureDetector;", "onScaleBegin", "onScaleEnd", "", "onScroll", "e1", "e2", "distanceX", "", "distanceY", "libmmui_release"})
    final class a extends GestureDetector.SimpleOnGestureListener implements ScaleGestureDetector.OnScaleGestureListener {
        public final boolean onContextClick(MotionEvent motionEvent) {
            AppMethodBeat.i(204908);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/cropview/RoundCropLayout$ScrollScaleListener", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
            boolean onContextClick = super.onContextClick(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(onContextClick, this, "com/tencent/mm/ui/widget/cropview/RoundCropLayout$ScrollScaleListener", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(204908);
            return onContextClick;
        }

        public final boolean onDoubleTap(MotionEvent motionEvent) {
            AppMethodBeat.i(204907);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/cropview/RoundCropLayout$ScrollScaleListener", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
            boolean onDoubleTap = super.onDoubleTap(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(onDoubleTap, this, "com/tencent/mm/ui/widget/cropview/RoundCropLayout$ScrollScaleListener", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(204907);
            return onDoubleTap;
        }

        public final void onLongPress(MotionEvent motionEvent) {
            AppMethodBeat.i(204906);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/cropview/RoundCropLayout$ScrollScaleListener", "android/view/GestureDetector$SimpleOnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V", this, bVar.axR());
            super.onLongPress(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/cropview/RoundCropLayout$ScrollScaleListener", "android/view/GestureDetector$SimpleOnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V");
            AppMethodBeat.o(204906);
        }

        public final boolean onSingleTapUp(MotionEvent motionEvent) {
            AppMethodBeat.i(204905);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/cropview/RoundCropLayout$ScrollScaleListener", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
            boolean onSingleTapUp = super.onSingleTapUp(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(onSingleTapUp, this, "com/tencent/mm/ui/widget/cropview/RoundCropLayout$ScrollScaleListener", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(204905);
            return onSingleTapUp;
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public a() {
        }

        public final boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            AppMethodBeat.i(164453);
            if (motionEvent2 != null) {
                Log.d(RoundCropLayout.this.TAG, "distanceX " + f2 + " distanceY " + f3);
                RoundCropLayout.this.lTJ.au(-f2, -f3);
                AppMethodBeat.o(164453);
                return true;
            }
            AppMethodBeat.o(164453);
            return false;
        }

        public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            AppMethodBeat.i(164454);
            Log.d(RoundCropLayout.this.TAG, "scale begin");
            AppMethodBeat.o(164454);
            return true;
        }

        public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            AppMethodBeat.i(164455);
            Log.d(RoundCropLayout.this.TAG, "scale end");
            AppMethodBeat.o(164455);
        }

        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            AppMethodBeat.i(164456);
            if (scaleGestureDetector != null) {
                Log.d(RoundCropLayout.this.TAG, "onScale scaleFactor " + scaleGestureDetector.getScaleFactor() + " imageScale " + RoundCropLayout.this.lTJ.getScale() + " pivot (" + scaleGestureDetector.getFocusX() + ", " + scaleGestureDetector.getFocusY() + ')');
                RoundCropLayout.this.lTJ.r(scaleGestureDetector.getScaleFactor() * RoundCropLayout.this.lTJ.getScale(), scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
            }
            AppMethodBeat.o(164456);
            return true;
        }
    }
}
