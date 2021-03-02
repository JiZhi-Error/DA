package com.tencent.mm.ui.widget.cropview;

import android.animation.Animator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import kotlin.g.b.z;
import kotlin.t;
import kotlin.x;

public class CropLayout extends BaseCropLayout {
    public static final a QMC = new a((byte) 0);
    private final RectF BZj = new RectF();
    private c GGN;
    private b QLZ;
    private kotlin.g.a.b<? super Matrix, Boolean> QMA;
    private final float[] QMB;
    private float QMa = 0.25f;
    private float QMb = 5.0f;
    private float QMc = 1.0f;
    private float QMd = 1.0f;
    private boolean QMe = true;
    protected boolean QMf;
    private final Rect QMg = new Rect();
    private final Rect QMh = new Rect();
    private final RectF QMi = new RectF();
    private Rect QMj = new Rect();
    private e QMk = e.CENTER_CROP;
    boolean QMl = true;
    private boolean QMm;
    private boolean QMn;
    private boolean QMo;
    private float QMp;
    private float QMq;
    private boolean QMr;
    private final float[] QMs;
    private Animator QMt;
    private final float[] QMu;
    private boolean QMv;
    private boolean QMw;
    private Animator QMx;
    private Animator QMy;
    private Animator QMz;
    private View contentView;
    private View.OnClickListener dec;
    private Matrix dgW = new Matrix();
    private final Matrix rM;
    private final Rect rwL = new Rect();
    private final RectF vY;
    private float[] values;
    private Rect xne = new Rect();
    private float xnf = 1.0f;

    public interface b {
        void o(float f2, float f3, float f4);

        void onScroll(float f2, float f3);
    }

    public interface c {
        void onChange();
    }

    public interface d extends c {
        void fDj();

        void fDk();
    }

    public enum e {
        CENTER_CROP,
        CENTER_INSIDE,
        ALIGN_START;

        static {
            AppMethodBeat.i(164380);
            AppMethodBeat.o(164380);
        }

        public static e valueOf(String str) {
            AppMethodBeat.i(164382);
            e eVar = (e) Enum.valueOf(e.class, str);
            AppMethodBeat.o(164382);
            return eVar;
        }
    }

    static {
        AppMethodBeat.i(164441);
        AppMethodBeat.o(164441);
    }

    /* access modifiers changed from: package-private */
    public static final class f extends kotlin.g.b.q implements kotlin.g.a.b<Matrix, Boolean> {
        public static final f QMH = new f();

        static {
            AppMethodBeat.i(164385);
            AppMethodBeat.o(164385);
        }

        f() {
            super(1);
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(Matrix matrix) {
            AppMethodBeat.i(164384);
            kotlin.g.b.p.h(matrix, LocaleUtil.ITALIAN);
            Boolean bool = Boolean.FALSE;
            AppMethodBeat.o(164384);
            return bool;
        }
    }

    public static final class k extends kotlin.g.b.q implements kotlin.g.a.b<Matrix, Boolean> {
        public static final k QMM = new k();

        static {
            AppMethodBeat.i(164391);
            AppMethodBeat.o(164391);
        }

        k() {
            super(1);
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(Matrix matrix) {
            AppMethodBeat.i(164390);
            kotlin.g.b.p.h(matrix, LocaleUtil.ITALIAN);
            Boolean bool = Boolean.FALSE;
            AppMethodBeat.o(164390);
            return bool;
        }
    }

    public static final class l extends kotlin.g.b.q implements kotlin.g.a.b<Matrix, Boolean> {
        public static final l QMN = new l();

        static {
            AppMethodBeat.i(164393);
            AppMethodBeat.o(164393);
        }

        l() {
            super(1);
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(Matrix matrix) {
            AppMethodBeat.i(164392);
            kotlin.g.b.p.h(matrix, LocaleUtil.ITALIAN);
            Boolean bool = Boolean.FALSE;
            AppMethodBeat.o(164392);
            return bool;
        }
    }

    public static final /* synthetic */ void a(CropLayout cropLayout, float f2, float f3) {
        AppMethodBeat.i(164443);
        cropLayout.e(f2, f3, 1);
        AppMethodBeat.o(164443);
    }

    public static final /* synthetic */ void a(CropLayout cropLayout, float f2, float f3, float f4) {
        AppMethodBeat.i(164444);
        cropLayout.u(f2, f3, f4);
        AppMethodBeat.o(164444);
    }

    public static final /* synthetic */ void b(CropLayout cropLayout, float f2) {
        AppMethodBeat.i(204904);
        cropLayout.cA(f2);
        AppMethodBeat.o(204904);
    }

    public static final /* synthetic */ void b(CropLayout cropLayout, float f2, float f3) {
        AppMethodBeat.i(164446);
        cropLayout.aB(f2, f3);
        AppMethodBeat.o(164446);
    }

    public static final /* synthetic */ float[] c(CropLayout cropLayout) {
        AppMethodBeat.i(164447);
        float[] matrixValues = cropLayout.getMatrixValues();
        AppMethodBeat.o(164447);
        return matrixValues;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CropLayout(Context context) {
        super(context);
        kotlin.g.b.p.h(context, "context");
        AppMethodBeat.i(164438);
        Context context2 = getContext();
        kotlin.g.b.p.g(context2, "context");
        setBackgroundColor(context2.getResources().getColor(17170444));
        this.rM = new Matrix();
        this.QMs = new float[2];
        this.QMu = new float[2];
        this.QMA = f.QMH;
        this.vY = new RectF();
        this.QMB = new float[2];
        this.values = new float[9];
        AppMethodBeat.o(164438);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CropLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.g.b.p.h(context, "context");
        AppMethodBeat.i(164439);
        Context context2 = getContext();
        kotlin.g.b.p.g(context2, "context");
        setBackgroundColor(context2.getResources().getColor(17170444));
        this.rM = new Matrix();
        this.QMs = new float[2];
        this.QMu = new float[2];
        this.QMA = f.QMH;
        this.vY = new RectF();
        this.QMB = new float[2];
        this.values = new float[9];
        AppMethodBeat.o(164439);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CropLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        kotlin.g.b.p.h(context, "context");
        AppMethodBeat.i(164440);
        Context context2 = getContext();
        kotlin.g.b.p.g(context2, "context");
        setBackgroundColor(context2.getResources().getColor(17170444));
        this.rM = new Matrix();
        this.QMs = new float[2];
        this.QMu = new float[2];
        this.QMA = f.QMH;
        this.vY = new RectF();
        this.QMB = new float[2];
        this.values = new float[9];
        AppMethodBeat.o(164440);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final b getCropLayoutTouchListener() {
        return this.QLZ;
    }

    public final void setCropLayoutTouchListener(b bVar) {
        this.QLZ = bVar;
    }

    public final c getOnChangeListener() {
        return this.GGN;
    }

    public final void setOnChangeListener(c cVar) {
        this.GGN = cVar;
    }

    public final View.OnClickListener getClickListener() {
        return this.dec;
    }

    public final void setClickListener(View.OnClickListener onClickListener) {
        this.dec = onClickListener;
    }

    public final Matrix getMainMatrix() {
        return this.dgW;
    }

    public final void setMainMatrix(Matrix matrix) {
        AppMethodBeat.i(164403);
        kotlin.g.b.p.h(matrix, "<set-?>");
        this.dgW = matrix;
        AppMethodBeat.o(164403);
    }

    public final float getMinScaleFactor() {
        return this.QMa;
    }

    public final void setMinScaleFactor(float f2) {
        this.QMa = f2;
    }

    public final float getMaxScaleFactor() {
        return this.QMb;
    }

    public final void setMaxScaleFactor(float f2) {
        this.QMb = f2;
    }

    public final float getMinScaleValue() {
        return this.QMc;
    }

    public final void setMinScaleValue(float f2) {
        this.QMc = f2;
    }

    public final float getMaxScaleValue() {
        return this.QMd;
    }

    public final void setMaxScaleValue(float f2) {
        this.QMd = f2;
    }

    public final void setShouldLayout(boolean z) {
        this.QMf = z;
    }

    public final RectF getVisibilityRect() {
        return this.BZj;
    }

    public final Rect getWidgetRect() {
        return this.QMg;
    }

    public final Rect getContentOriginalRect() {
        return this.QMh;
    }

    public final Rect getContentRect() {
        return this.rwL;
    }

    public final RectF getContentRectF() {
        return this.QMi;
    }

    public final Rect getContentBaseRect() {
        return this.QMj;
    }

    public final void setContentBaseRect(Rect rect) {
        AppMethodBeat.i(204895);
        kotlin.g.b.p.h(rect, "<set-?>");
        this.QMj = rect;
        AppMethodBeat.o(204895);
    }

    public final Rect getContentCenterRect() {
        return this.xne;
    }

    public final void setContentCenterRect(Rect rect) {
        AppMethodBeat.i(164404);
        kotlin.g.b.p.h(rect, "<set-?>");
        this.xne = rect;
        AppMethodBeat.o(164404);
    }

    public final View getContentView() {
        return this.contentView;
    }

    public final void setContentView(View view) {
        this.contentView = view;
    }

    public final e getScaleType() {
        return this.QMk;
    }

    public final void setScaleType(e eVar) {
        AppMethodBeat.i(164405);
        kotlin.g.b.p.h(eVar, "<set-?>");
        this.QMk = eVar;
        AppMethodBeat.o(164405);
    }

    public final void setFirstCancelOrUp(boolean z) {
        this.QMl = z;
    }

    public final void reset() {
        AppMethodBeat.i(164406);
        this.BZj.setEmpty();
        this.rwL.setEmpty();
        this.QMi.setEmpty();
        this.xne.setEmpty();
        this.QMj.setEmpty();
        this.vY.setEmpty();
        this.dgW = new Matrix();
        this.xnf = 1.0f;
        this.QMc = 1.0f;
        this.QMd = 1.0f;
        this.QMb = 5.0f;
        this.QMa = 0.25f;
        this.QMp = 0.0f;
        this.QMq = 0.0f;
        this.QMB[0] = 0.0f;
        this.QMB[1] = 0.0f;
        this.QMe = true;
        this.QMf = false;
        this.QMl = true;
        this.QMA = k.QMM;
        this.values = new float[9];
        AppMethodBeat.o(164406);
    }

    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(164407);
        super.onLayout(z, i2, i3, i4, i5);
        if (z) {
            this.QMg.set(i2, i3, i4, i5);
            this.QMf = true;
        }
        e(z, i2, i3, i4, i5);
        AppMethodBeat.o(164407);
    }

    public static /* synthetic */ void a(CropLayout cropLayout, RectF rectF) {
        AppMethodBeat.i(204897);
        cropLayout.b(rectF, false);
        AppMethodBeat.o(204897);
    }

    public void b(RectF rectF, boolean z) {
        AppMethodBeat.i(204896);
        kotlin.g.b.p.h(rectF, "rectF");
        float f2 = this.BZj.bottom - this.QMi.bottom;
        float f3 = this.BZj.top - this.QMi.top;
        if (f2 > 0.0f && f2 <= f3) {
            e(0.0f, -f2, 4);
        } else if (this.QMi.height() <= this.BZj.height() || z) {
            t((1.0f * this.BZj.height()) / this.QMi.height(), this.QMi.centerX(), this.QMi.bottom);
            e(0.0f, -(this.BZj.bottom - this.QMi.bottom), 4);
        }
        this.BZj.set(rectF);
        AppMethodBeat.o(204896);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public void e(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(164409);
        if (this.BZj.isEmpty()) {
            this.BZj.set(0.0f, 0.0f, (float) (i4 - i2), (float) (i5 - i3));
        }
        View view = this.contentView;
        if (view != null) {
            if (!this.QMf) {
                if (z) {
                    switch (a.haE[this.QMk.ordinal()]) {
                        case 1:
                            l(this.BZj);
                            AppMethodBeat.o(164409);
                            return;
                        case 2:
                            k(this.BZj);
                            AppMethodBeat.o(164409);
                            return;
                        case 3:
                            j(this.BZj);
                            break;
                    }
                }
            } else {
                this.QMf = false;
                if (this.QMe) {
                    this.dgW.reset();
                }
                this.QMj.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
                view.setPivotX(this.QMj.exactCenterX());
                view.setPivotY(this.QMj.exactCenterY());
                this.vY.set(this.QMj);
                this.dgW.mapRect(this.vY);
                this.vY.round(this.rwL);
                this.QMi.set(this.vY);
                if (this.QMe) {
                    this.dgW.reset();
                    switch (a.$EnumSwitchMapping$0[this.QMk.ordinal()]) {
                        case 1:
                            l(this.BZj);
                            break;
                        case 2:
                            k(this.BZj);
                            break;
                        case 3:
                            j(this.BZj);
                            break;
                    }
                    if (this.QMA.invoke(this.dgW).booleanValue()) {
                        hbh();
                        this.QMi.round(this.xne);
                        AppMethodBeat.o(164409);
                        return;
                    }
                } else {
                    if (this.QMA.invoke(this.dgW).booleanValue()) {
                        hbh();
                        this.QMi.round(this.xne);
                    }
                    AppMethodBeat.o(164409);
                    return;
                }
            }
            AppMethodBeat.o(164409);
            return;
        }
        AppMethodBeat.o(164409);
    }

    @Override // com.tencent.mm.ui.widget.cropview.TouchEventLayout
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        AppMethodBeat.i(204898);
        kotlin.g.b.p.h(motionEvent, "e");
        View.OnClickListener onClickListener = this.dec;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
        boolean onSingleTapUp = super.onSingleTapUp(motionEvent);
        AppMethodBeat.o(204898);
        return onSingleTapUp;
    }

    @Override // com.tencent.mm.ui.widget.cropview.BaseCropLayout, com.tencent.mm.ui.widget.cropview.TouchEventLayout
    public boolean onDown(MotionEvent motionEvent) {
        AppMethodBeat.i(164411);
        super.onDown(motionEvent);
        c cVar = this.GGN;
        if (!(cVar instanceof d)) {
            cVar = null;
        }
        d dVar = (d) cVar;
        if (dVar != null) {
            dVar.fDj();
        }
        Animator animator = this.QMt;
        if (animator != null) {
            animator.cancel();
        }
        Animator animator2 = this.QMx;
        if (animator2 != null) {
            animator2.cancel();
        }
        AppMethodBeat.o(164411);
        return true;
    }

    @Override // com.tencent.mm.ui.widget.cropview.BaseCropLayout, com.tencent.mm.ui.widget.cropview.TouchEventLayout
    public void ad(MotionEvent motionEvent) {
        boolean z;
        float f2;
        float f3;
        boolean z2;
        AppMethodBeat.i(164412);
        kotlin.g.b.p.h(motionEvent, "e1");
        super.ad(motionEvent);
        this.QMn = false;
        this.QMo = false;
        this.QMl = false;
        Animator animator = this.QMt;
        boolean isStarted = animator != null ? animator.isStarted() : false;
        if (isStarted) {
            z = true;
        } else {
            z = false;
        }
        if (this.QNk) {
            z2 = false;
        } else if (z) {
            z2 = false;
        } else {
            boolean hbc = hbc();
            boolean hbd = hbd();
            if (!hbd || !hbc) {
                Animator animator2 = this.QMt;
                if (animator2 != null) {
                    animator2.cancel();
                }
                Animator animator3 = this.QMy;
                if (animator3 != null) {
                    animator3.cancel();
                }
                float centerX = this.QMi.centerX();
                float centerY = this.QMi.centerY();
                float centerX2 = this.BZj.centerX();
                float centerY2 = this.BZj.centerY();
                float f4 = getContentViewScale()[0];
                float width = this.BZj.width() / this.QMi.width();
                float height = this.BZj.height() / this.QMi.height();
                PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("scale", f4, (this.QMk == e.CENTER_CROP ? Math.max(height, width) : Math.min(height, width)) * f4);
                PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat("transX", centerX, centerX2);
                PropertyValuesHolder ofFloat3 = PropertyValuesHolder.ofFloat("transY", centerY, centerY2);
                float f5 = this.BZj.right - this.QMi.right;
                float f6 = this.BZj.left - this.QMi.left;
                float[] fArr = new float[2];
                fArr[0] = 0.0f;
                if (f6 < 0.0f && f5 < 0.0f) {
                    f2 = f6;
                } else if (f6 <= 0.0f || f5 <= 0.0f) {
                    f2 = 0.0f;
                } else {
                    f2 = f5;
                }
                fArr[1] = f2;
                PropertyValuesHolder ofFloat4 = PropertyValuesHolder.ofFloat("edgeX", fArr);
                float f7 = this.BZj.bottom - this.QMi.bottom;
                float f8 = this.BZj.top - this.QMi.top;
                float[] fArr2 = new float[2];
                fArr2[0] = 0.0f;
                if (f8 < 0.0f && f7 < 0.0f) {
                    f3 = f8;
                } else if (f8 <= 0.0f || f7 <= 0.0f) {
                    f3 = 0.0f;
                } else {
                    f3 = f7;
                }
                fArr2[1] = f3;
                PropertyValuesHolder ofFloat5 = PropertyValuesHolder.ofFloat("edgeY", fArr2);
                new StringBuilder("[startCenterAnim] source=0 edgeLeft=").append(f6).append(" edgeRight=").append(f5).append(" edgeTop=").append(f8).append(" edgeBottom=").append(f7);
                z.c cVar = new z.c();
                cVar.SYD = 0.0f;
                z.c cVar2 = new z.c();
                cVar2.SYD = 0.0f;
                ValueAnimator ofPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(ofFloat, ofFloat2, ofFloat3, ofFloat4, ofFloat5);
                ofPropertyValuesHolder.addUpdateListener(new m(this, hbd, hbc, cVar, cVar2));
                ofPropertyValuesHolder.addListener(new n(this, hbd, hbc, cVar, cVar2));
                ofPropertyValuesHolder.setInterpolator(new DecelerateInterpolator());
                ofPropertyValuesHolder.setDuration(160L);
                ofPropertyValuesHolder.start();
                this.QMy = ofPropertyValuesHolder;
                z2 = true;
            } else {
                z2 = false;
            }
        }
        if (!z2 && !isStarted) {
            hbg();
        }
        this.QMr = false;
        AppMethodBeat.o(164412);
    }

    @Override // com.tencent.mm.ui.widget.cropview.TouchEventLayout
    public boolean onTouch(View view, MotionEvent motionEvent) {
        AppMethodBeat.i(164414);
        kotlin.g.b.p.h(view, "v");
        kotlin.g.b.p.h(motionEvent, "event");
        if (motionEvent.getAction() == 0) {
            this.QMm = false;
        }
        if (motionEvent.getPointerCount() > 1) {
            this.QMm = true;
        }
        boolean onTouch = super.onTouch(view, motionEvent);
        AppMethodBeat.o(164414);
        return onTouch;
    }

    private final void e(float f2, float f3, int i2) {
        AppMethodBeat.i(164415);
        if (i2 == 4) {
            aB(f2, f3);
            AppMethodBeat.o(164415);
            return;
        }
        if (!hbc()) {
            f2 = 0.0f;
        } else if (hbe()) {
            f2 *= 0.4f;
        }
        if (!hbd()) {
            f3 = 0.0f;
        } else if (hbf()) {
            f3 *= 0.4f;
        }
        aB(f2, f3);
        AppMethodBeat.o(164415);
    }

    @Override // com.tencent.mm.ui.widget.cropview.TouchEventLayout
    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        AppMethodBeat.i(164416);
        kotlin.g.b.p.h(scaleGestureDetector, "detector");
        t(scaleGestureDetector.getScaleFactor(), scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
        AppMethodBeat.o(164416);
        return true;
    }

    public final void t(float f2, float f3, float f4) {
        AppMethodBeat.i(164417);
        if (getContentViewScale()[0] * f2 < this.QMc || getContentViewScale()[0] * f2 > this.QMd) {
            if (!this.QMr) {
                performHapticFeedback(0, 2);
                this.QMr = true;
            }
            AppMethodBeat.o(164417);
            return;
        }
        if (this.contentView != null) {
            u(f2, f3, f4);
            this.QMp = f3;
            this.QMq = f4;
        }
        AppMethodBeat.o(164417);
    }

    public final void hba() {
        AppMethodBeat.i(204899);
        ValueAnimator ofPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofFloat(FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION, 0.0f, -90.0f));
        z.c cVar = new z.c();
        cVar.SYD = 0.0f;
        ofPropertyValuesHolder.addUpdateListener(new j(cVar, this));
        ofPropertyValuesHolder.setDuration((long) (110.0f * (Math.abs(-90.0f) / 90.0f)));
        ofPropertyValuesHolder.start();
        AppMethodBeat.o(204899);
    }

    public static final class j implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ CropLayout QMI;
        final /* synthetic */ z.c QMJ;
        final /* synthetic */ float QML = -90.0f;

        j(z.c cVar, CropLayout cropLayout) {
            this.QMJ = cVar;
            this.QMI = cropLayout;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(164389);
            Object animatedValue = valueAnimator.getAnimatedValue(FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION);
            if (animatedValue == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.Float");
                AppMethodBeat.o(164389);
                throw tVar;
            }
            float floatValue = ((Float) animatedValue).floatValue();
            CropLayout.a(this.QMI, floatValue - this.QMJ.SYD);
            this.QMJ.SYD = floatValue;
            AppMethodBeat.o(164389);
        }
    }

    public final void hbb() {
        AppMethodBeat.i(204900);
        float f2 = -getRotateDegrees();
        if (f2 == 0.0f) {
            AppMethodBeat.o(204900);
            return;
        }
        ValueAnimator ofPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofFloat(FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION, 0.0f, f2));
        z.c cVar = new z.c();
        cVar.SYD = 0.0f;
        ofPropertyValuesHolder.addUpdateListener(new i(cVar, this, f2));
        ofPropertyValuesHolder.setDuration((long) (110.0f * (Math.abs(f2) / 90.0f)));
        ofPropertyValuesHolder.start();
        AppMethodBeat.o(204900);
    }

    public static final class i implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ CropLayout QMI;
        final /* synthetic */ z.c QMJ;
        final /* synthetic */ float QMK;

        i(z.c cVar, CropLayout cropLayout, float f2) {
            this.QMJ = cVar;
            this.QMI = cropLayout;
            this.QMK = f2;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(164388);
            Object animatedValue = valueAnimator.getAnimatedValue(FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION);
            if (animatedValue == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.Float");
                AppMethodBeat.o(164388);
                throw tVar;
            }
            float floatValue = ((Float) animatedValue).floatValue();
            CropLayout.a(this.QMI, floatValue - this.QMJ.SYD);
            this.QMJ.SYD = floatValue;
            AppMethodBeat.o(164388);
        }
    }

    private final float getRotateDegrees() {
        AppMethodBeat.i(164418);
        this.dgW.getValues(this.values);
        float f2 = -((float) Math.round(Math.atan2((double) this.values[1], (double) this.values[0]) * 57.29577951308232d));
        AppMethodBeat.o(164418);
        return f2;
    }

    private final float getRotate() {
        Matrix matrix;
        AppMethodBeat.i(164419);
        View view = this.contentView;
        if (!(view == null || (matrix = view.getMatrix()) == null)) {
            matrix.getValues(this.values);
        }
        float f2 = -((float) Math.round(Math.atan2((double) this.values[1], (double) this.values[0]) * 57.29577951308232d));
        AppMethodBeat.o(164419);
        return f2;
    }

    public static final class g implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ CropLayout QMI;
        private float aTD;
        private float aTE;

        g(CropLayout cropLayout) {
            this.QMI = cropLayout;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(164386);
            kotlin.g.b.p.h(valueAnimator, LocaleUtil.ITALIAN);
            Object animatedValue = valueAnimator.getAnimatedValue("transX");
            if (animatedValue == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.Float");
                AppMethodBeat.o(164386);
                throw tVar;
            }
            float floatValue = ((Float) animatedValue).floatValue();
            Object animatedValue2 = valueAnimator.getAnimatedValue("transY");
            if (animatedValue2 == null) {
                t tVar2 = new t("null cannot be cast to non-null type kotlin.Float");
                AppMethodBeat.o(164386);
                throw tVar2;
            }
            float floatValue2 = ((Float) animatedValue2).floatValue();
            CropLayout.a(this.QMI, this.aTD - floatValue, this.aTE - floatValue2);
            this.aTD = floatValue;
            this.aTE = floatValue2;
            AppMethodBeat.o(164386);
        }
    }

    public static final class h implements Animator.AnimatorListener {
        final /* synthetic */ CropLayout QMI;

        h(CropLayout cropLayout) {
            this.QMI = cropLayout;
        }

        public final void onAnimationRepeat(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(164387);
            CropLayout.a(this.QMI);
            AppMethodBeat.o(164387);
        }

        public final void onAnimationCancel(Animator animator) {
        }

        public final void onAnimationStart(Animator animator) {
        }
    }

    private boolean hbc() {
        AppMethodBeat.i(164421);
        boolean z = this.QMi.width() > this.BZj.width();
        if (z && !this.QMv) {
            this.QMn = true;
        }
        this.QMv = z;
        AppMethodBeat.o(164421);
        return z;
    }

    public final boolean hbd() {
        AppMethodBeat.i(164422);
        boolean z = this.QMi.height() > this.BZj.height();
        if (z && !this.QMw) {
            this.QMo = true;
        }
        this.QMw = z;
        AppMethodBeat.o(164422);
        return z;
    }

    private final boolean hbe() {
        return this.BZj.left < this.QMi.left || this.BZj.right > this.QMi.right;
    }

    private boolean hbf() {
        return this.BZj.top < this.QMi.top || this.BZj.bottom > this.QMi.bottom;
    }

    /* access modifiers changed from: package-private */
    public static final class m implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ CropLayout QMI;
        final /* synthetic */ boolean QMO;
        final /* synthetic */ boolean QMP;
        final /* synthetic */ z.c QMQ;
        final /* synthetic */ z.c QMR;

        m(CropLayout cropLayout, boolean z, boolean z2, z.c cVar, z.c cVar2) {
            this.QMI = cropLayout;
            this.QMO = z;
            this.QMP = z2;
            this.QMQ = cVar;
            this.QMR = cVar2;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            float f2;
            float f3;
            AppMethodBeat.i(164394);
            if ((this.QMI.getScaleType() == e.CENTER_INSIDE && !this.QMO && !this.QMP) || (this.QMI.getScaleType() == e.CENTER_CROP && (!this.QMO || !this.QMP))) {
                Object animatedValue = valueAnimator.getAnimatedValue("scale");
                if (animatedValue == null) {
                    t tVar = new t("null cannot be cast to non-null type kotlin.Float");
                    AppMethodBeat.o(164394);
                    throw tVar;
                }
                CropLayout.a(this.QMI, (((Float) animatedValue).floatValue() * 1.0f) / this.QMI.getContentViewScale()[0], this.QMI.getContentRectF().centerX(), this.QMI.getContentRectF().centerY());
            }
            Object animatedValue2 = valueAnimator.getAnimatedValue("transX");
            if (animatedValue2 == null) {
                t tVar2 = new t("null cannot be cast to non-null type kotlin.Float");
                AppMethodBeat.o(164394);
                throw tVar2;
            }
            float floatValue = ((Float) animatedValue2).floatValue();
            Object animatedValue3 = valueAnimator.getAnimatedValue("transY");
            if (animatedValue3 == null) {
                t tVar3 = new t("null cannot be cast to non-null type kotlin.Float");
                AppMethodBeat.o(164394);
                throw tVar3;
            }
            float floatValue2 = ((Float) animatedValue3).floatValue();
            Object animatedValue4 = valueAnimator.getAnimatedValue("edgeX");
            if (animatedValue4 == null) {
                t tVar4 = new t("null cannot be cast to non-null type kotlin.Float");
                AppMethodBeat.o(164394);
                throw tVar4;
            }
            float floatValue3 = ((Float) animatedValue4).floatValue();
            Object animatedValue5 = valueAnimator.getAnimatedValue("edgeY");
            if (animatedValue5 == null) {
                t tVar5 = new t("null cannot be cast to non-null type kotlin.Float");
                AppMethodBeat.o(164394);
                throw tVar5;
            }
            float floatValue4 = ((Float) animatedValue5).floatValue();
            float f4 = floatValue3 - this.QMQ.SYD;
            float f5 = floatValue4 - this.QMR.SYD;
            float centerX = floatValue - this.QMI.getContentRectF().centerX();
            float centerY = floatValue2 - this.QMI.getContentRectF().centerY();
            CropLayout cropLayout = this.QMI;
            if (this.QMP) {
                f2 = -f4;
            } else {
                f2 = -centerX;
            }
            if (this.QMO) {
                f3 = -f5;
            } else {
                f3 = -centerY;
            }
            CropLayout.b(cropLayout, f2, f3);
            this.QMQ.SYD = floatValue3;
            this.QMR.SYD = floatValue4;
            AppMethodBeat.o(164394);
        }
    }

    public static final class n implements Animator.AnimatorListener {
        final /* synthetic */ CropLayout QMI;
        final /* synthetic */ boolean QMO;
        final /* synthetic */ boolean QMP;
        final /* synthetic */ z.c QMQ;
        final /* synthetic */ z.c QMR;

        n(CropLayout cropLayout, boolean z, boolean z2, z.c cVar, z.c cVar2) {
            this.QMI = cropLayout;
            this.QMO = z;
            this.QMP = z2;
            this.QMQ = cVar;
            this.QMR = cVar2;
        }

        public final void onAnimationRepeat(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(204894);
            c onChangeListener = this.QMI.getOnChangeListener();
            if (!(onChangeListener instanceof d)) {
                onChangeListener = null;
            }
            d dVar = (d) onChangeListener;
            if (dVar != null) {
                dVar.fDk();
                AppMethodBeat.o(204894);
                return;
            }
            AppMethodBeat.o(204894);
        }

        public final void onAnimationCancel(Animator animator) {
        }

        public final void onAnimationStart(Animator animator) {
        }
    }

    public static /* synthetic */ void a(CropLayout cropLayout) {
        AppMethodBeat.i(164424);
        cropLayout.hbg();
        AppMethodBeat.o(164424);
    }

    private void hbg() {
        AppMethodBeat.i(164423);
        Animator animator = this.QMx;
        if (animator != null) {
            animator.cancel();
        }
        if (this.QNk) {
            AppMethodBeat.o(164423);
            return;
        }
        int i2 = (int) (this.QMi.left - this.BZj.left);
        int i3 = (int) (this.QMi.top - this.BZj.top);
        int i4 = (int) (this.BZj.right - this.QMi.right);
        int i5 = (int) (this.BZj.bottom - this.QMi.bottom);
        if (!hbe() || i2 <= 0) {
            if (!hbe() || i4 <= 0) {
                i2 = 0;
            } else if (hbc()) {
                i2 = -i4;
            } else {
                i2 = (int) (this.QMi.centerX() - this.BZj.centerX());
            }
        } else if (!hbc()) {
            i2 = (int) (this.QMi.centerX() - this.BZj.centerX());
        }
        if (!hbf() || i3 <= 0) {
            if (!hbf() || i5 <= 0) {
                i3 = 0;
            } else if (hbd()) {
                i3 = -i5;
            } else {
                i3 = (int) (this.QMi.centerY() - this.BZj.centerY());
            }
        } else if (!hbd()) {
            i3 = (int) (this.QMi.centerY() - this.BZj.centerY());
        }
        if (i2 == 0 && i3 == 0) {
            c cVar = this.GGN;
            if (!(cVar instanceof d)) {
                cVar = null;
            }
            d dVar = (d) cVar;
            if (dVar != null) {
                dVar.fDk();
                AppMethodBeat.o(164423);
                return;
            }
            AppMethodBeat.o(164423);
            return;
        }
        ValueAnimator ofPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofInt("transX", 0, i2), PropertyValuesHolder.ofInt("transY", 0, i3));
        ofPropertyValuesHolder.addUpdateListener(new o(this, null));
        ofPropertyValuesHolder.addListener(new p(this, null));
        ofPropertyValuesHolder.setInterpolator(new DecelerateInterpolator());
        ofPropertyValuesHolder.setDuration(160L);
        ofPropertyValuesHolder.start();
        this.QMx = ofPropertyValuesHolder;
        AppMethodBeat.o(164423);
    }

    public static final class o implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ CropLayout QMI;
        final /* synthetic */ Animator.AnimatorListener QMS = null;
        private int wcr;
        private int wqz;

        o(CropLayout cropLayout, Animator.AnimatorListener animatorListener) {
            this.QMI = cropLayout;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(164395);
            kotlin.g.b.p.h(valueAnimator, LocaleUtil.ITALIAN);
            Object animatedValue = valueAnimator.getAnimatedValue("transX");
            if (animatedValue == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.Int");
                AppMethodBeat.o(164395);
                throw tVar;
            }
            int intValue = ((Integer) animatedValue).intValue();
            Object animatedValue2 = valueAnimator.getAnimatedValue("transY");
            if (animatedValue2 == null) {
                t tVar2 = new t("null cannot be cast to non-null type kotlin.Int");
                AppMethodBeat.o(164395);
                throw tVar2;
            }
            int intValue2 = ((Integer) animatedValue2).intValue();
            CropLayout.b(this.QMI, (float) (intValue - this.wcr), (float) (intValue2 - this.wqz));
            this.wcr = intValue;
            this.wqz = intValue2;
            AppMethodBeat.o(164395);
        }
    }

    public static final class p implements Animator.AnimatorListener {
        final /* synthetic */ CropLayout QMI;
        final /* synthetic */ Animator.AnimatorListener QMS = null;

        p(CropLayout cropLayout, Animator.AnimatorListener animatorListener) {
            this.QMI = cropLayout;
        }

        public final void onAnimationRepeat(Animator animator) {
            AppMethodBeat.i(164396);
            kotlin.g.b.p.h(animator, "animation");
            Animator.AnimatorListener animatorListener = this.QMS;
            if (animatorListener != null) {
                animatorListener.onAnimationRepeat(animator);
                AppMethodBeat.o(164396);
                return;
            }
            AppMethodBeat.o(164396);
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(164397);
            kotlin.g.b.p.h(animator, "animation");
            Animator.AnimatorListener animatorListener = this.QMS;
            if (animatorListener != null) {
                animatorListener.onAnimationEnd(animator);
            }
            c onChangeListener = this.QMI.getOnChangeListener();
            if (!(onChangeListener instanceof d)) {
                onChangeListener = null;
            }
            d dVar = (d) onChangeListener;
            if (dVar != null) {
                dVar.fDk();
                AppMethodBeat.o(164397);
                return;
            }
            AppMethodBeat.o(164397);
        }

        public final void onAnimationCancel(Animator animator) {
            AppMethodBeat.i(164398);
            kotlin.g.b.p.h(animator, "animation");
            Animator.AnimatorListener animatorListener = this.QMS;
            if (animatorListener != null) {
                animatorListener.onAnimationCancel(animator);
                AppMethodBeat.o(164398);
                return;
            }
            AppMethodBeat.o(164398);
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.i(164399);
            kotlin.g.b.p.h(animator, "animation");
            Animator.AnimatorListener animatorListener = this.QMS;
            if (animatorListener != null) {
                animatorListener.onAnimationStart(animator);
                AppMethodBeat.o(164399);
                return;
            }
            AppMethodBeat.o(164399);
        }
    }

    public final void a(kotlin.g.a.a<x> aVar, ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        AppMethodBeat.i(164425);
        kotlin.g.b.p.h(aVar, "onAnimationEnd");
        Animator animator = this.QMy;
        if (animator != null) {
            animator.cancel();
        }
        getMatrixValues();
        float f2 = getContentViewScale()[0];
        float centerX = this.QMi.centerX();
        float centerY = this.QMi.centerY();
        float exactCenterX = this.xne.exactCenterX();
        float exactCenterY = this.xne.exactCenterY();
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("scale", f2, this.xnf);
        ValueAnimator ofPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofFloat("percent", 0.0f, 1.0f), ofFloat, PropertyValuesHolder.ofFloat("transX", centerX, exactCenterX), PropertyValuesHolder.ofFloat("transY", centerY, exactCenterY));
        ofPropertyValuesHolder.addUpdateListener(new q(this, aVar, animatorUpdateListener));
        ofPropertyValuesHolder.setInterpolator(new DecelerateInterpolator());
        ofPropertyValuesHolder.setDuration(300L);
        ofPropertyValuesHolder.addListener(new r(this, aVar, animatorUpdateListener));
        ofPropertyValuesHolder.addUpdateListener(animatorUpdateListener);
        ofPropertyValuesHolder.start();
        this.QMz = ofPropertyValuesHolder;
        AppMethodBeat.o(164425);
    }

    static final class q implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ kotlin.g.a.a Axu;
        final /* synthetic */ CropLayout QMI;
        final /* synthetic */ ValueAnimator.AnimatorUpdateListener QMT;

        q(CropLayout cropLayout, kotlin.g.a.a aVar, ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
            this.QMI = cropLayout;
            this.Axu = aVar;
            this.QMT = animatorUpdateListener;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(164400);
            Object animatedValue = valueAnimator.getAnimatedValue("scale");
            if (animatedValue == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.Float");
                AppMethodBeat.o(164400);
                throw tVar;
            }
            float floatValue = ((Float) animatedValue).floatValue();
            Object animatedValue2 = valueAnimator.getAnimatedValue("transX");
            if (animatedValue2 == null) {
                t tVar2 = new t("null cannot be cast to non-null type kotlin.Float");
                AppMethodBeat.o(164400);
                throw tVar2;
            }
            float floatValue2 = ((Float) animatedValue2).floatValue();
            Object animatedValue3 = valueAnimator.getAnimatedValue("transY");
            if (animatedValue3 == null) {
                t tVar3 = new t("null cannot be cast to non-null type kotlin.Float");
                AppMethodBeat.o(164400);
                throw tVar3;
            }
            float floatValue3 = ((Float) animatedValue3).floatValue();
            CropLayout.c(this.QMI);
            CropLayout.b(this.QMI, (floatValue * 1.0f) / this.QMI.getContentViewScale()[0]);
            CropLayout.b(this.QMI, -(floatValue2 - this.QMI.getContentRectF().centerX()), -(floatValue3 - this.QMI.getContentRectF().centerY()));
            AppMethodBeat.o(164400);
        }
    }

    public static final class r implements Animator.AnimatorListener {
        final /* synthetic */ kotlin.g.a.a Axu;
        final /* synthetic */ CropLayout QMI;
        final /* synthetic */ ValueAnimator.AnimatorUpdateListener QMT;

        r(CropLayout cropLayout, kotlin.g.a.a aVar, ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
            this.QMI = cropLayout;
            this.Axu = aVar;
            this.QMT = animatorUpdateListener;
        }

        public final void onAnimationRepeat(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(164402);
            this.QMI.post(new Runnable(this) {
                /* class com.tencent.mm.ui.widget.cropview.CropLayout.r.AnonymousClass1 */
                final /* synthetic */ r QMU;

                {
                    this.QMU = r1;
                }

                public final void run() {
                    AppMethodBeat.i(164401);
                    this.QMU.Axu.invoke();
                    AppMethodBeat.o(164401);
                }
            });
            AppMethodBeat.o(164402);
        }

        public final void onAnimationCancel(Animator animator) {
        }

        public final void onAnimationStart(Animator animator) {
        }
    }

    private void j(RectF rectF) {
        float centerX;
        float centerY;
        AppMethodBeat.i(204901);
        kotlin.g.b.p.h(rectF, "widget");
        float max = Math.max((rectF.width() * 1.0f) / ((float) this.QMj.width()), (rectF.height() * 1.0f) / ((float) this.QMj.height()));
        if (this.QMi.height() > this.BZj.height()) {
            centerX = this.QMi.centerX() - this.BZj.centerX();
            centerY = this.QMi.top - this.BZj.top;
        } else if (this.QMi.width() > this.BZj.width()) {
            centerX = this.QMi.left - this.BZj.left;
            centerY = this.QMi.centerY() - this.BZj.centerY();
        } else {
            centerX = this.QMi.centerX() - this.BZj.centerX();
            centerY = this.QMi.centerY() - this.BZj.centerY();
        }
        this.xnf = max;
        this.QMc = this.QMa * this.xnf;
        this.QMd = this.QMb * this.xnf;
        aB(centerX, centerY);
        u(max, this.BZj.centerX(), this.BZj.centerY());
        this.QMi.round(this.xne);
        new StringBuilder("[alignStart] scale=").append(max).append(" offsetX=").append(centerX).append(" offsetY=").append(centerY).append(" contentBaseRect=").append(this.QMj).append(" contentRect=").append(this.rwL);
        AppMethodBeat.o(204901);
    }

    private void k(RectF rectF) {
        AppMethodBeat.i(164426);
        kotlin.g.b.p.h(rectF, "widget");
        float max = Math.max((rectF.width() * 1.0f) / ((float) this.QMj.width()), (rectF.height() * 1.0f) / ((float) this.QMj.height()));
        float centerX = this.QMi.centerX() - this.BZj.centerX();
        float centerY = this.QMi.centerY() - this.BZj.centerY();
        this.xnf = max;
        this.QMc = this.QMa * this.xnf;
        this.QMd = this.QMb * this.xnf;
        aB(centerX, centerY);
        u(max, this.BZj.centerX(), this.BZj.centerY());
        this.QMi.round(this.xne);
        new StringBuilder("[centerCrop] scale=").append(max).append(" offsetX=").append(centerX).append(" offsetY=").append(centerY).append(" contentBaseRect=").append(this.QMj).append(" contentRect=").append(this.rwL);
        AppMethodBeat.o(164426);
    }

    private void l(RectF rectF) {
        AppMethodBeat.i(164427);
        kotlin.g.b.p.h(rectF, "widget");
        float min = Math.min((rectF.width() * 1.0f) / ((float) this.QMj.width()), (rectF.height() * 1.0f) / ((float) this.QMj.height()));
        float centerX = this.QMi.centerX() - this.BZj.centerX();
        float centerY = this.QMi.centerY() - this.BZj.centerY();
        this.xnf = min;
        this.QMc = this.QMa * this.xnf;
        this.QMd = this.QMb * this.xnf;
        aB(centerX, centerY);
        u(min, this.BZj.centerX(), this.BZj.centerY());
        this.QMi.round(this.xne);
        new StringBuilder("[centerInside] scale=").append(min).append(" offsetX=").append(centerX).append(" offsetY=").append(centerY).append(" contentBaseRect=").append(this.QMj).append(" contentRect=").append(this.rwL);
        AppMethodBeat.o(164427);
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.g.a.b<? super android.graphics.Matrix, java.lang.Boolean>, kotlin.g.a.b<android.graphics.Matrix, java.lang.Boolean> */
    public final kotlin.g.a.b<Matrix, Boolean> getInitFinish() {
        return this.QMA;
    }

    public final void setInitFinish(kotlin.g.a.b<? super Matrix, Boolean> bVar) {
        AppMethodBeat.i(204902);
        kotlin.g.b.p.h(bVar, "<set-?>");
        this.QMA = bVar;
        AppMethodBeat.o(204902);
    }

    public static /* synthetic */ void a(CropLayout cropLayout, View view, int i2, int i3, Matrix matrix, e eVar, kotlin.g.a.b bVar, int i4) {
        AppMethodBeat.i(164429);
        cropLayout.a(view, i2, i3, (i4 & 8) != 0 ? new Matrix() : matrix, (i4 & 16) != 0 ? e.CENTER_CROP : eVar, (i4 & 32) != 0 ? l.QMN : bVar);
        AppMethodBeat.o(164429);
    }

    public final void a(View view, int i2, int i3, Matrix matrix, e eVar, kotlin.g.a.b<? super Matrix, Boolean> bVar) {
        AppMethodBeat.i(164428);
        kotlin.g.b.p.h(view, "view");
        kotlin.g.b.p.h(matrix, "matrix");
        kotlin.g.b.p.h(eVar, "scaleType");
        kotlin.g.b.p.h(bVar, "initFinish");
        this.QMh.set(0, 0, i2, i3);
        this.QMA = bVar;
        this.contentView = view;
        this.dgW = matrix;
        this.QMe = matrix.isIdentity();
        this.QMf = true;
        this.QMk = eVar;
        removeView(view);
        addView(view, 0, new FrameLayout.LayoutParams(i2, i3));
        AppMethodBeat.o(164428);
    }

    public static /* synthetic */ void b(CropLayout cropLayout) {
        AppMethodBeat.i(164431);
        cropLayout.De(false);
        AppMethodBeat.o(164431);
    }

    public final void De(boolean z) {
        AppMethodBeat.i(164430);
        View view = this.contentView;
        if (view != null) {
            removeView(view);
            if (z) {
                reset();
            }
            this.contentView = null;
            AppMethodBeat.o(164430);
            return;
        }
        AppMethodBeat.o(164430);
    }

    private final void u(float f2, float f3, float f4) {
        AppMethodBeat.i(164432);
        if (this.QMi.isEmpty()) {
            AppMethodBeat.o(164432);
            return;
        }
        float width = (f3 - this.QMi.left) / this.QMi.width();
        float height = (f4 - this.QMi.top) / this.QMi.height();
        cA(f2);
        b bVar = this.QLZ;
        if (bVar != null) {
            bVar.o(f2, f3, f4);
        }
        float width2 = (width * this.QMi.width()) + this.QMi.left;
        float f5 = this.QMi.top;
        this.dgW.postTranslate(f3 - width2, f4 - ((height * this.QMi.height()) + f5));
        hbh();
        AppMethodBeat.o(164432);
    }

    private final void cA(float f2) {
        AppMethodBeat.i(204903);
        this.dgW.postScale(f2, f2, 0.0f, 0.0f);
        hbh();
        AppMethodBeat.o(204903);
    }

    private final void aB(float f2, float f3) {
        AppMethodBeat.i(164433);
        b bVar = this.QLZ;
        if (bVar != null) {
            bVar.onScroll(-f2, -f3);
        }
        this.dgW.postTranslate(-f2, -f3);
        hbh();
        AppMethodBeat.o(164433);
    }

    public final RectF getTmpRectF() {
        return this.vY;
    }

    public final void hbh() {
        AppMethodBeat.i(164434);
        View view = this.contentView;
        if (view != null) {
            float[] matrixValues = getMatrixValues();
            float f2 = getContentViewScale()[0];
            kotlin.g.b.l lVar = kotlin.g.b.l.SYx;
            if (f2 != kotlin.g.b.l.hyb()) {
                kotlin.g.b.l lVar2 = kotlin.g.b.l.SYx;
                if (f2 != kotlin.g.b.l.hya() && !Float.isNaN(f2)) {
                    view.setRotation(getRotateDegrees());
                    view.setPivotX(0.0f);
                    view.setPivotY(0.0f);
                    view.setScaleX(f2);
                    view.setScaleY(f2);
                    view.setTranslationX(matrixValues[2]);
                    view.setTranslationY(matrixValues[5]);
                }
            }
        }
        View view2 = this.contentView;
        if (view2 != null) {
            this.vY.set(this.QMj);
            view2.getMatrix().mapRect(this.vY);
            this.QMi.set(this.vY);
            this.vY.round(this.rwL);
        }
        c cVar = this.GGN;
        if (cVar != null) {
            cVar.onChange();
            AppMethodBeat.o(164434);
            return;
        }
        AppMethodBeat.o(164434);
    }

    public final float[] getContentViewTrans() {
        AppMethodBeat.i(164435);
        this.dgW.getValues(this.values);
        float f2 = this.values[2];
        float f3 = this.values[5];
        this.QMB[0] = f2;
        this.QMB[1] = f3;
        float[] fArr = this.QMB;
        AppMethodBeat.o(164435);
        return fArr;
    }

    public final float[] getContentViewScale() {
        AppMethodBeat.i(164436);
        getMatrixValues();
        float f2 = this.values[0];
        float f3 = this.values[3];
        float sqrt = (float) Math.sqrt((((double) f3) * ((double) f3)) + ((double) (f2 * f2)));
        float[] fArr = {sqrt, sqrt};
        AppMethodBeat.o(164436);
        return fArr;
    }

    private final float[] getMatrixValues() {
        AppMethodBeat.i(164437);
        this.dgW.getValues(this.values);
        float[] fArr = this.values;
        int length = fArr.length;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            }
            int i4 = i3 + 1;
            if (Float.isNaN(fArr[i2])) {
                new StringBuilder("MatrixValues Error! index=").append(i3).append(" value=").append(this.values[i3]);
                this.values[i3] = 1.0f;
                break;
            }
            i2++;
            i3 = i4;
        }
        float[] fArr2 = this.values;
        AppMethodBeat.o(164437);
        return fArr2;
    }

    @Override // com.tencent.mm.ui.widget.cropview.TouchEventLayout
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        AppMethodBeat.i(164413);
        kotlin.g.b.p.h(motionEvent, "e1");
        kotlin.g.b.p.h(motionEvent2, "e2");
        if (this.QNl) {
            e(f2, f3, 0);
        }
        AppMethodBeat.o(164413);
        return true;
    }

    @Override // com.tencent.mm.ui.widget.cropview.TouchEventLayout
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        AppMethodBeat.i(164420);
        kotlin.g.b.p.h(motionEvent, "e1");
        kotlin.g.b.p.h(motionEvent2, "e2");
        if (!this.QNj) {
            AppMethodBeat.o(164420);
            return false;
        }
        float f4 = 0.5f * f2;
        float f5 = 0.5f * f3;
        if (this.QMm || (Math.abs(f4) < 1000.0f && Math.abs(f5) < 1000.0f)) {
            AppMethodBeat.o(164420);
            return false;
        }
        boolean hbe = hbe();
        boolean hbf = hbf();
        boolean hbc = hbc();
        boolean hbd = hbd();
        if (!hbe || !hbf) {
            if ((this.QMi.left >= this.BZj.left && f4 > 0.0f) || (this.QMi.right <= this.BZj.left && f4 < 0.0f)) {
                if (this.QMk == e.CENTER_CROP || this.QMk == e.ALIGN_START) {
                    AppMethodBeat.o(164420);
                    return false;
                }
                f4 = 0.0f;
            }
            if ((this.QMi.top >= this.BZj.top && f5 > 0.0f) || (this.QMi.bottom <= this.BZj.bottom && f5 < 0.0f)) {
                if (this.QMk == e.CENTER_CROP || this.QMk == e.ALIGN_START) {
                    AppMethodBeat.o(164420);
                    return false;
                }
                f5 = 0.0f;
            }
            Animator animator = this.QMt;
            if (animator != null) {
                animator.cancel();
            }
            this.QMu[0] = 0.0f;
            this.QMu[1] = 0.0f;
            float f6 = this.QMi.right - this.BZj.right;
            float f7 = this.BZj.left - this.QMi.left;
            if (f4 < 0.0f) {
                this.QMu[0] = -Math.min(Math.abs(f4), Math.abs(f6));
            } else {
                this.QMu[0] = Math.min(Math.abs(f4), Math.abs(f7));
            }
            float f8 = this.QMi.bottom - this.BZj.bottom;
            float f9 = this.BZj.top - this.QMi.top;
            if (f5 < 0.0f) {
                this.QMu[1] = -Math.min(Math.abs(f5), Math.abs(f8));
            } else {
                this.QMu[1] = Math.min(Math.abs(f5), Math.abs(f9));
            }
            float[] fArr = this.QMu;
            new StringBuilder("[onFling] velocityX=").append(f4).append(" velocityY=").append(f5).append("  fixTransX=").append(fArr[0]).append(" fixTransY=").append(fArr[1]).append(" isOverEdgeHorizontal=").append(hbe).append(" isOverEdgeVertical=").append(hbf).append(" isOverHorizontal=").append(hbc).append(" isOverVertical=").append(hbd);
            ValueAnimator ofPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofFloat("transX", 0.0f, fArr[0]), PropertyValuesHolder.ofFloat("transY", 0.0f, fArr[1]));
            ofPropertyValuesHolder.addUpdateListener(new g(this));
            ofPropertyValuesHolder.addListener(new h(this));
            ofPropertyValuesHolder.setInterpolator(new DecelerateInterpolator());
            ofPropertyValuesHolder.setDuration(400L);
            ofPropertyValuesHolder.start();
            this.QMt = ofPropertyValuesHolder;
            AppMethodBeat.o(164420);
            return true;
        }
        AppMethodBeat.o(164420);
        return false;
    }

    public static final /* synthetic */ void a(CropLayout cropLayout, float f2) {
        Matrix matrix;
        Matrix matrix2;
        AppMethodBeat.i(164442);
        cropLayout.rM.reset();
        View view = cropLayout.contentView;
        if (!(view == null || (matrix2 = view.getMatrix()) == null)) {
            matrix2.invert(cropLayout.rM);
        }
        cropLayout.QMs[0] = cropLayout.BZj.centerX();
        cropLayout.QMs[1] = cropLayout.BZj.centerY();
        cropLayout.rM.mapPoints(cropLayout.QMs);
        cropLayout.rM.getValues(cropLayout.values);
        cropLayout.dgW.postRotate(f2);
        cropLayout.hbh();
        View view2 = cropLayout.contentView;
        if (!(view2 == null || (matrix = view2.getMatrix()) == null)) {
            matrix.mapPoints(cropLayout.QMs);
        }
        cropLayout.dgW.postTranslate(cropLayout.BZj.centerX() - cropLayout.QMs[0], cropLayout.BZj.centerY() - cropLayout.QMs[1]);
        cropLayout.hbh();
        AppMethodBeat.o(164442);
    }
}
