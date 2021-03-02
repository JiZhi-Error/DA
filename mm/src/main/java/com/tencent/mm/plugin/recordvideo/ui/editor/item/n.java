package com.tencent.mm.plugin.recordvideo.ui.editor.item;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.EditorItemContainer;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.a.h;
import com.tencent.mm.plugin.recordvideo.ui.editor.view.b;
import com.tencent.mm.plugin.recordvideo.ui.editor.view.c;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.au;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0014\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010!\u001a\u00020\u000fH\u0016J\b\u0010\"\u001a\u00020#H\u0016J\n\u0010$\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010%\u001a\u00020\bH\u0016J\b\u0010&\u001a\u00020'H\u0016J\u0006\u0010(\u001a\u00020)J\u0010\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020,H\u0014J\u0010\u0010-\u001a\u00020\r2\u0006\u0010.\u001a\u00020/H\u0016J\u0006\u00100\u001a\u00020)J\u0018\u00101\u001a\u00020)2\u0006\u0010\t\u001a\u00020\b2\u0006\u00102\u001a\u000203H\u0016J\u000e\u00104\u001a\u00020)2\u0006\u0010\u0010\u001a\u00020\u0011J\u0018\u00105\u001a\u00020)2\u0006\u00106\u001a\u00020\b2\u0006\u00107\u001a\u000208H\u0016J\u0016\u00109\u001a\u00020)2\u0006\u0010:\u001a\u0002082\u0006\u0010;\u001a\u000208J\u000e\u0010<\u001a\u00020)2\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u0010=\u001a\u00020)2\u0006\u0010\u001a\u001a\u00020\bH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006>"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/PagItemView;", "Landroid/view/View;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/IEditable;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/IEditView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "contentRect", "Landroid/graphics/Rect;", "displayRect", "frameDrawable", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/ActiveFrameDrawable;", "isValid", "", "originPivot", "", "pagItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/PagStickerItem;", "paint", "Landroid/graphics/Paint;", "stateResolve", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer$ItemStateResolve;", "touchTracker", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker;", "getTouchTracker", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker;", "validRect", "createEditorData", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "createEditorItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "matrix", "Landroid/graphics/Matrix;", "getContentBoundary", "getDrawRect", "Landroid/graphics/RectF;", "getEditorData", "getSafeArea", "getType", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/EditItemType;", "onDelete", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "onUpdate", "setDefaultLocation", "heightPercent", "", "setEditItem", "setSafeArea", "safeRect", "damp", "", "setSize", "width", "height", "setStateResolve", "setValidArea", "plugin-recordvideo_release"})
public final class n extends View implements g, c {
    private final Rect Cao = new Rect(0, 0, au.az(MMApplicationContext.getContext()).x, au.az(MMApplicationContext.getContext()).y);
    private final Rect Cap = new Rect(0, 0, au.az(MMApplicationContext.getContext()).x, au.az(MMApplicationContext.getContext()).y);
    private EditorItemContainer.b Caq;
    private final com.tencent.mm.plugin.recordvideo.ui.editor.view.a Cey;
    private o CfY;
    private boolean daZ = true;
    private final Paint paint = new Paint();
    private final com.tencent.mm.plugin.recordvideo.ui.editor.c.c rqT = new com.tencent.mm.plugin.recordvideo.ui.editor.c.c();
    private final float[] rrd = new float[2];
    private final Rect rwL = new Rect();

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "m", "Landroid/graphics/Matrix;", "animateFinish", "", "invoke"})
    static final class a extends q implements m<Matrix, Boolean, x> {
        final /* synthetic */ MotionEvent CaJ;
        final /* synthetic */ n CfZ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(n nVar, MotionEvent motionEvent) {
            super(2);
            this.CfZ = nVar;
            this.CaJ = motionEvent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(Matrix matrix, Boolean bool) {
            AppMethodBeat.i(237800);
            Matrix matrix2 = matrix;
            boolean booleanValue = bool.booleanValue();
            p.h(matrix2, "m");
            if (this.CfZ.daZ) {
                this.CfZ.getTouchTracker().g(matrix2);
                o oVar = this.CfZ.CfY;
                if (oVar != null) {
                    oVar.g(this.CfZ.getTouchTracker().gT);
                }
                this.CfZ.postInvalidate();
                if (booleanValue) {
                    this.CfZ.getTouchTracker().Y(this.CaJ);
                    this.CfZ.bringToFront();
                    EditorItemContainer.b bVar = this.CfZ.Caq;
                    if (bVar != null) {
                        bVar.d(this.CfZ, this.CaJ);
                    }
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(237800);
            return xVar;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public n(Context context) {
        super(context);
        p.h(context, "context");
        AppMethodBeat.i(237814);
        this.rqT.aXu = 0.5f;
        this.rqT.aXt = 3.0f;
        Resources resources = getResources();
        p.g(resources, "resources");
        this.Cey = new com.tencent.mm.plugin.recordvideo.ui.editor.view.a(resources);
        this.paint.setColor(822083583);
        this.paint.setStyle(Paint.Style.FILL);
        AppMethodBeat.o(237814);
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.view.c
    public final boolean Ig(long j2) {
        AppMethodBeat.i(237815);
        boolean a2 = c.a.a(this, j2);
        AppMethodBeat.o(237815);
        return a2;
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.view.c
    public final boolean aLB(String str) {
        AppMethodBeat.i(237816);
        p.h(str, "objID");
        boolean a2 = c.a.a(this, str);
        AppMethodBeat.o(237816);
        return a2;
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.view.c
    public final boolean eLK() {
        return true;
    }

    public final com.tencent.mm.plugin.recordvideo.ui.editor.c.c getTouchTracker() {
        return this.rqT;
    }

    public final void setStateResolve(EditorItemContainer.b bVar) {
        AppMethodBeat.i(237801);
        p.h(bVar, "stateResolve");
        this.Caq = bVar;
        AppMethodBeat.o(237801);
    }

    public final void setEditItem(o oVar) {
        float f2;
        AppMethodBeat.i(237802);
        p.h(oVar, "pagItem");
        this.CfY = oVar;
        this.rqT.gT.postScale(oVar.scale, oVar.scale);
        int i2 = oVar.width;
        int i3 = oVar.height;
        this.Cey.setBounds(0, 0, i2, i3);
        this.rwL.set(0, 0, i2, i3);
        this.rqT.gT.postTranslate(((float) this.rqT.width) / 2.0f, ((float) this.rqT.height) / 2.0f);
        this.rqT.width = i2;
        this.rqT.height = i3;
        o oVar2 = this.CfY;
        if (oVar2 != null) {
            f2 = oVar2.scale;
        } else {
            f2 = 1.0f;
        }
        this.rqT.gT.postTranslate((((float) (-i2)) * f2) / 2.0f, -(((f2 * ((float) i3)) / 2.0f) + (((float) ((this.Cap.top + this.Cap.bottom) / 2)) - (((float) (this.Cao.top + this.Cao.bottom)) / 2.0f))));
        this.rqT.o(new float[]{0.0f, 0.0f, (float) i2, 0.0f, 0.0f, (float) i3, (float) i2, (float) i3});
        o oVar3 = this.CfY;
        if (oVar3 != null) {
            oVar3.g(this.rqT.gT);
            AppMethodBeat.o(237802);
            return;
        }
        AppMethodBeat.o(237802);
    }

    public final void eMs() {
        j jVar;
        AppMethodBeat.i(237803);
        o oVar = this.CfY;
        if (!(oVar == null || (jVar = oVar.Cgd) == null)) {
            jVar.eMs();
        }
        this.daZ = false;
        AppMethodBeat.o(237803);
    }

    /* access modifiers changed from: protected */
    public final void onDraw(Canvas canvas) {
        AppMethodBeat.i(237804);
        p.h(canvas, "canvas");
        super.onDraw(canvas);
        canvas.save();
        canvas.setMatrix(this.rqT.gT);
        if (isActivated()) {
            this.Cey.draw(canvas);
        }
        canvas.restore();
        AppMethodBeat.o(237804);
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        j jVar;
        AppMethodBeat.i(237805);
        p.h(motionEvent, "event");
        if (motionEvent.getActionMasked() == 3 || motionEvent.getActionMasked() == 1) {
            z = true;
        } else {
            z = this.rqT.Y(motionEvent);
            if (z) {
                o oVar = this.CfY;
                if (oVar != null) {
                    oVar.g(this.rqT.gT);
                }
                bringToFront();
                o oVar2 = this.CfY;
                if (!(oVar2 == null || (jVar = oVar2.Cgd) == null)) {
                    jVar.eMr();
                }
                EditorItemContainer.b bVar = this.Caq;
                if (bVar != null) {
                    bVar.d(this, motionEvent);
                }
                postInvalidate();
            }
        }
        if (motionEvent.getActionMasked() == 0) {
            this.rrd[0] = ((float) this.rqT.width) / 2.0f;
            this.rrd[1] = ((float) this.rqT.height) / 2.0f;
            this.rqT.gT.mapPoints(this.rrd);
        } else if (motionEvent.getActionMasked() == 1) {
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
        }
        AppMethodBeat.o(237805);
        return z;
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.item.g
    public final com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a c(Matrix matrix) {
        AppMethodBeat.i(237806);
        Matrix matrix2 = new Matrix();
        matrix2.postConcat(this.rqT.gT);
        matrix2.postTranslate(((float) (-(this.Cap.width() - this.Cao.width()))) / 2.0f, ((float) (-(this.Cap.height() - this.Cao.height()))) / 2.0f);
        if (matrix != null) {
            matrix2.postConcat(matrix);
        }
        h hVar = new h(matrix2);
        AppMethodBeat.o(237806);
        return hVar;
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.item.g
    public final a cJO() {
        AppMethodBeat.i(237807);
        o oVar = this.CfY;
        if (oVar != null) {
            oVar.gT.set(this.rqT.gT);
        }
        o oVar2 = this.CfY;
        AppMethodBeat.o(237807);
        return oVar2;
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.view.c
    public final void b(Rect rect, int i2) {
        AppMethodBeat.i(237808);
        p.h(rect, "safeRect");
        AppMethodBeat.o(237808);
    }

    public final Rect getSafeArea() {
        AppMethodBeat.i(237809);
        Rect rect = this.rqT.BKm;
        if (rect == null) {
            Resources resources = getResources();
            p.g(resources, "resources");
            int i2 = resources.getDisplayMetrics().widthPixels;
            Resources resources2 = getResources();
            p.g(resources2, "resources");
            rect = new Rect(0, 0, i2, resources2.getDisplayMetrics().heightPixels);
        }
        AppMethodBeat.o(237809);
        return rect;
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.view.c
    public final void setValidArea(Rect rect) {
        AppMethodBeat.i(237810);
        p.h(rect, "validRect");
        this.Cao.set(rect);
        AppMethodBeat.o(237810);
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.view.c
    public final void a(Rect rect, float f2) {
        AppMethodBeat.i(237811);
        p.h(rect, "displayRect");
        this.Cap.set(rect);
        this.rqT.gT.postTranslate(((float) rect.width()) / 2.0f, ((float) rect.height()) * f2);
        o oVar = this.CfY;
        if (oVar != null) {
            oVar.g(this.rqT.gT);
            AppMethodBeat.o(237811);
            return;
        }
        AppMethodBeat.o(237811);
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.view.c
    public final float[] getContentBoundary() {
        AppMethodBeat.i(237812);
        float[] fArr = (float[]) this.rqT.Chg.clone();
        AppMethodBeat.o(237812);
        return fArr;
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.view.c
    public final b getType() {
        return b.EditItemTypePagSticker;
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.view.c
    public final RectF getDrawRect() {
        AppMethodBeat.i(237813);
        RectF rectF = new RectF(this.rqT.Chg[0], this.rqT.Chg[1], this.rqT.Chg[2], this.rqT.Chg[3]);
        AppMethodBeat.o(237813);
        return rectF;
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.view.c
    public final a getEditorData() {
        return this.CfY;
    }
}
