package com.tencent.mm.plugin.recordvideo.ui.editor.item;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.i.m;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.EditorItemContainer;
import com.tencent.mm.plugin.recordvideo.ui.editor.view.c;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.au;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\n\u0010]\u001a\u0004\u0018\u00010^H\u0016J\u0014\u0010_\u001a\u0004\u0018\u00010`2\b\u0010a\u001a\u0004\u0018\u00010WH\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010b\u001a\u00020,H\u0016J\b\u0010c\u001a\u00020dH\u0016J\b\u0010e\u001a\u00020\u0015H\u0016J\u0010\u0010f\u001a\u00020g2\u0006\u0010h\u001a\u00020iH\u0014J\u0010\u0010j\u001a\u00020\u00192\u0006\u0010k\u001a\u00020lH\u0016J\u0018\u0010m\u001a\u00020g2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010n\u001a\u00020AH\u0016J\u0018\u0010o\u001a\u00020g2\u0006\u0010p\u001a\u00020\u00152\u0006\u0010q\u001a\u00020\u000fH\u0016J\u000e\u0010r\u001a\u00020g2\u0006\u00105\u001a\u000206J\u0010\u0010s\u001a\u00020g2\u0006\u0010U\u001a\u00020\u0015H\u0016R(\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0011\"\u0004\b(\u0010\u0013R\u0014\u0010)\u001a\u00020\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0011R\u000e\u0010+\u001a\u00020,X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010/\u001a\u000200X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0010\u00105\u001a\u0004\u0018\u000106X\u000e¢\u0006\u0002\n\u0000R\u001c\u00107\u001a\u0004\u0018\u000108X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001a\u0010=\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u0011\"\u0004\b?\u0010\u0013R\u001a\u0010@\u001a\u00020AX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001a\u0010F\u001a\u00020AX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010C\"\u0004\bH\u0010ER\u001a\u0010I\u001a\u00020AX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010C\"\u0004\bK\u0010ER\u001a\u0010L\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\u001b\"\u0004\bN\u0010\u001dR\u0011\u0010O\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\bP\u0010\u0011R\u0011\u0010Q\u001a\u00020R¢\u0006\b\n\u0000\u001a\u0004\bS\u0010TR\u0014\u0010U\u001a\u00020\u0015X\u0004¢\u0006\b\n\u0000\u001a\u0004\bV\u0010\u0017R(\u0010X\u001a\u0004\u0018\u00010W2\b\u0010\u0007\u001a\u0004\u0018\u00010W@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\¨\u0006t"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BitmapItemView;", "Landroid/view/View;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/IEditable;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/IEditView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "value", "Landroid/graphics/Bitmap;", "bitmap", "getBitmap", "()Landroid/graphics/Bitmap;", "setBitmap", "(Landroid/graphics/Bitmap;)V", "color", "", "getColor", "()I", "setColor", "(I)V", "displayRect", "Landroid/graphics/Rect;", "getDisplayRect", "()Landroid/graphics/Rect;", "enableNotify", "", "getEnableNotify", "()Z", "setEnableNotify", "(Z)V", "frameDrawable", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/ActiveFrameDrawable;", FirebaseAnalytics.b.LOCATION, "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LocationItem;", m.NAME, "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LocationItem;", "setLocation", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LocationItem;)V", "marginBottom", "getMarginBottom", "setMarginBottom", "navigateBarHeight", "getNavigateBarHeight", "originPivot", "", "paint", "Landroid/graphics/Paint;", "sourceDataType", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorDataType;", "getSourceDataType", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorDataType;", "setSourceDataType", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorDataType;)V", "stateResolve", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer$ItemStateResolve;", "text", "", "getText", "()Ljava/lang/CharSequence;", "setText", "(Ljava/lang/CharSequence;)V", "textBg", "getTextBg", "setTextBg", "textSize", "", "getTextSize", "()F", "setTextSize", "(F)V", "touchDownX", "getTouchDownX", "setTouchDownX", "touchDownY", "getTouchDownY", "setTouchDownY", "touchMoved", "getTouchMoved", "setTouchMoved", "touchSlop", "getTouchSlop", "touchTracker", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker;", "getTouchTracker", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker;", "validRect", "getValidRect", "Landroid/graphics/Matrix;", "viewMatrix", "getViewMatrix", "()Landroid/graphics/Matrix;", "setViewMatrix", "(Landroid/graphics/Matrix;)V", "createEditorData", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "createEditorItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "matrix", "getContentBoundary", "getDrawRect", "Landroid/graphics/RectF;", "getSafeArea", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "setDefaultLocation", "heightPercent", "setSafeArea", "safeRect", "damp", "setStateResolve", "setValidArea", "plugin-recordvideo_release"})
public abstract class b extends View implements g, c {
    private final Rect Cao = new Rect(0, 0, au.az(MMApplicationContext.getContext()).x, au.az(MMApplicationContext.getContext()).y);
    private final Rect Cap = new Rect(0, 0, au.az(MMApplicationContext.getContext()).x, au.az(MMApplicationContext.getContext()).y);
    private EditorItemContainer.b Caq;
    private int CeA;
    private int CeB;
    private k CeC;
    private d CeD = d.TEXT;
    private Matrix CeE;
    private boolean CeF;
    private final com.tencent.mm.plugin.recordvideo.ui.editor.view.a Cey;
    private final int Cez = au.aD(MMApplicationContext.getContext());
    private Bitmap bitmap;
    private int color;
    private boolean gZU;
    private float gZX;
    private float gZY;
    private final Paint paint = new Paint();
    private final int rZ;
    private final com.tencent.mm.plugin.recordvideo.ui.editor.c.c rqT = new com.tencent.mm.plugin.recordvideo.ui.editor.c.c();
    private final float[] rrd = new float[2];
    private CharSequence text;
    private float textSize = getResources().getDimension(R.dimen.a1l);

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "m", "Landroid/graphics/Matrix;", "animateFinish", "", "invoke"})
    public static final class a extends q implements kotlin.g.a.m<Matrix, Boolean, x> {
        final /* synthetic */ MotionEvent CaJ;
        final /* synthetic */ b CeG;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(b bVar, MotionEvent motionEvent) {
            super(2);
            this.CeG = bVar;
            this.CaJ = motionEvent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(Matrix matrix, Boolean bool) {
            AppMethodBeat.i(237746);
            Matrix matrix2 = matrix;
            boolean booleanValue = bool.booleanValue();
            p.h(matrix2, "m");
            this.CeG.getTouchTracker().g(matrix2);
            this.CeG.postInvalidate();
            if (booleanValue) {
                this.CeG.getTouchTracker().Y(this.CaJ);
                this.CeG.bringToFront();
                EditorItemContainer.b bVar = this.CeG.Caq;
                if (bVar != null) {
                    bVar.d(this.CeG, this.CaJ);
                }
                if (!this.CeG.getTouchMoved()) {
                    this.CeG.performClick();
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(237746);
            return xVar;
        }
    }

    public b(Context context) {
        super(context);
        this.rqT.aXu = 0.5f;
        this.rqT.aXt = 3.0f;
        Resources resources = getResources();
        p.g(resources, "resources");
        this.Cey = new com.tencent.mm.plugin.recordvideo.ui.editor.view.a(resources);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        p.g(viewConfiguration, "ViewConfiguration.get(context)");
        this.rZ = viewConfiguration.getScaledTouchSlop();
        this.paint.setAntiAlias(true);
        this.CeF = true;
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.view.c
    public final boolean Ig(long j2) {
        return c.a.a(this, j2);
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.view.c
    public final boolean aLB(String str) {
        p.h(str, "objID");
        return c.a.a(this, str);
    }

    public final com.tencent.mm.plugin.recordvideo.ui.editor.c.c getTouchTracker() {
        return this.rqT;
    }

    /* access modifiers changed from: protected */
    public final int getNavigateBarHeight() {
        return this.Cez;
    }

    /* access modifiers changed from: protected */
    public final Rect getValidRect() {
        return this.Cao;
    }

    /* access modifiers changed from: protected */
    public final Rect getDisplayRect() {
        return this.Cap;
    }

    public final CharSequence getText() {
        return this.text;
    }

    public final void setText(CharSequence charSequence) {
        this.text = charSequence;
    }

    public final float getTextSize() {
        return this.textSize;
    }

    public final void setTextSize(float f2) {
        this.textSize = f2;
    }

    public final int getColor() {
        return this.color;
    }

    public final void setColor(int i2) {
        this.color = i2;
    }

    public final int getTextBg() {
        return this.CeA;
    }

    public final void setTextBg(int i2) {
        this.CeA = i2;
    }

    public final int getMarginBottom() {
        return this.CeB;
    }

    public final void setMarginBottom(int i2) {
        this.CeB = i2;
    }

    public final k getLocation() {
        return this.CeC;
    }

    public final void setLocation(k kVar) {
        this.CeC = kVar;
    }

    public final d getSourceDataType() {
        return this.CeD;
    }

    public final void setSourceDataType(d dVar) {
        p.h(dVar, "<set-?>");
        this.CeD = dVar;
    }

    public final Bitmap getBitmap() {
        return this.bitmap;
    }

    public final void setBitmap(Bitmap bitmap2) {
        this.bitmap = bitmap2;
        if (bitmap2 != null) {
            this.rqT.width = bitmap2.getWidth();
            this.rqT.height = bitmap2.getHeight();
            this.rqT.gT.preTranslate(((float) (-bitmap2.getWidth())) / 2.0f, ((float) (-bitmap2.getHeight())) / 2.0f);
            this.Cey.setBounds(0, 0, bitmap2.getWidth(), bitmap2.getHeight());
            this.rqT.o(new float[]{0.0f, 0.0f, (float) bitmap2.getWidth(), 0.0f, 0.0f, (float) bitmap2.getHeight(), (float) bitmap2.getWidth(), (float) bitmap2.getHeight()});
        }
    }

    public final Matrix getViewMatrix() {
        return this.CeE;
    }

    public final void setViewMatrix(Matrix matrix) {
        this.CeE = matrix;
        if (matrix != null) {
            this.rqT.setMatrix(matrix);
            Canvas canvas = new Canvas();
            canvas.save();
            if (this.CeE != null) {
                canvas.setMatrix(matrix);
            }
            if (isActivated()) {
                this.Cey.draw(canvas);
            }
            if (this.bitmap != null) {
                Bitmap bitmap2 = this.bitmap;
                if (bitmap2 == null) {
                    p.hyc();
                }
                canvas.drawBitmap(bitmap2, 0.0f, 0.0f, (Paint) null);
            }
        }
    }

    public final float getTouchDownX() {
        return this.gZX;
    }

    public final void setTouchDownX(float f2) {
        this.gZX = f2;
    }

    public final float getTouchDownY() {
        return this.gZY;
    }

    public final void setTouchDownY(float f2) {
        this.gZY = f2;
    }

    public final boolean getTouchMoved() {
        return this.gZU;
    }

    public final void setTouchMoved(boolean z) {
        this.gZU = z;
    }

    public final int getTouchSlop() {
        return this.rZ;
    }

    public final boolean getEnableNotify() {
        return this.CeF;
    }

    public final void setEnableNotify(boolean z) {
        this.CeF = z;
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.view.c
    public final void a(Rect rect, float f2) {
        p.h(rect, "displayRect");
        this.Cap.set(rect);
        this.rqT.gT.postTranslate(((float) rect.width()) / 2.0f, ((float) rect.height()) * f2);
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.view.c
    public void setValidArea(Rect rect) {
        p.h(rect, "validRect");
        this.Cao.set(rect);
    }

    public final void setStateResolve(EditorItemContainer.b bVar) {
        p.h(bVar, "stateResolve");
        this.Caq = bVar;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        p.h(motionEvent, "event");
        if (motionEvent.getActionMasked() == 3 || motionEvent.getActionMasked() == 1) {
            z = true;
        } else {
            z = this.rqT.Y(motionEvent);
            if (z) {
                bringToFront();
                EditorItemContainer.b bVar = this.Caq;
                if (bVar != null) {
                    bVar.d(this, motionEvent);
                }
                postInvalidate();
            }
        }
        if (z) {
            switch (motionEvent.getActionMasked()) {
                case 0:
                    this.gZX = motionEvent.getX();
                    this.gZY = motionEvent.getY();
                    this.gZU = false;
                    this.rrd[0] = ((float) this.rqT.width) / 2.0f;
                    this.rrd[1] = ((float) this.rqT.height) / 2.0f;
                    this.rqT.gT.mapPoints(this.rrd);
                    break;
                case 1:
                    com.tencent.mm.plugin.recordvideo.ui.editor.c.a aVar = new com.tencent.mm.plugin.recordvideo.ui.editor.c.a();
                    Rect rect = this.Cao;
                    aVar.aXu = this.rqT.aXu;
                    aVar.aXt = this.rqT.aXt;
                    aVar.n(new float[]{((float) this.rqT.width) / 2.0f, ((float) this.rqT.height) / 2.0f});
                    aVar.f(new RectF((float) rect.left, (float) rect.top, (float) rect.right, (float) rect.bottom));
                    float[] fArr = {((float) this.rqT.width) / 2.0f, ((float) this.rqT.height) / 2.0f};
                    this.rqT.gT.mapPoints(fArr);
                    if (!aVar.CgM.contains(fArr[0], fArr[1])) {
                        aVar.f(new RectF(this.rrd[0], this.rrd[1], this.rrd[0], this.rrd[1]));
                    }
                    aVar.a(this.rqT.gT, new a(this, motionEvent));
                    break;
                case 2:
                    float max = Math.max(Math.abs(motionEvent.getX() - this.gZX), Math.abs(motionEvent.getY() - this.gZY));
                    if (!this.gZU) {
                        this.gZU = max > ((float) this.rZ);
                        break;
                    }
                    break;
            }
        }
        return z;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        p.h(canvas, "canvas");
        canvas.save();
        if (this.CeE != null) {
            canvas.setMatrix(this.CeE);
        } else {
            canvas.setMatrix(this.rqT.gT);
        }
        if (isActivated()) {
            this.Cey.draw(canvas);
        }
        canvas.restore();
        canvas.clipRect(this.Cao);
        canvas.save();
        if (this.CeE != null) {
            canvas.setMatrix(this.CeE);
        } else {
            canvas.setMatrix(this.rqT.gT);
        }
        if (this.bitmap != null) {
            Bitmap bitmap2 = this.bitmap;
            if (bitmap2 == null) {
                p.hyc();
            }
            canvas.drawBitmap(bitmap2, 0.0f, 0.0f, this.paint);
        }
        canvas.restore();
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.item.g
    public final com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a c(Matrix matrix) {
        if (this.bitmap == null) {
            return null;
        }
        Matrix matrix2 = new Matrix();
        matrix2.postConcat(this.rqT.gT);
        if (matrix != null) {
            matrix2.postConcat(matrix);
        }
        return new com.tencent.mm.plugin.recordvideo.ui.editor.item.a.c(this.bitmap, matrix2);
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.item.g
    public a cJO() {
        if (this.bitmap == null) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.postConcat(this.rqT.gT);
        if (this.CeD == d.TEXT || this.CeD == d.TIP) {
            return new q(this.text, this.color, this.CeA, this.CeB, matrix);
        }
        k kVar = this.CeC;
        if (kVar == null) {
            p.hyc();
        }
        String str = kVar.Cfy;
        k kVar2 = this.CeC;
        if (kVar2 == null) {
            p.hyc();
        }
        String str2 = kVar2.kHV;
        k kVar3 = this.CeC;
        if (kVar3 == null) {
            p.hyc();
        }
        float f2 = kVar3.dTj;
        k kVar4 = this.CeC;
        if (kVar4 == null) {
            p.hyc();
        }
        return new k(str, str2, f2, kVar4.latitude, matrix);
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.view.c
    public final boolean eLK() {
        return this.CeF;
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.view.c
    public final void b(Rect rect, int i2) {
        p.h(rect, "safeRect");
        this.rqT.BKm = rect;
        this.rqT.Chb = com.tencent.mm.cb.a.fromDPToPix(getContext(), i2);
    }

    public Rect getSafeArea() {
        Rect rect = this.rqT.BKm;
        if (rect != null) {
            return rect;
        }
        Resources resources = getResources();
        p.g(resources, "resources");
        int i2 = resources.getDisplayMetrics().widthPixels;
        Resources resources2 = getResources();
        p.g(resources2, "resources");
        return new Rect(0, 0, i2, resources2.getDisplayMetrics().heightPixels);
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.view.c
    public float[] getContentBoundary() {
        return (float[]) this.rqT.Chg.clone();
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.view.c
    public RectF getDrawRect() {
        return new RectF(this.rqT.Chg[0], this.rqT.Chg[1], this.rqT.Chg[2], this.rqT.Chg[3]);
    }
}
