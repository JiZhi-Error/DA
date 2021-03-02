package com.tencent.mm.plugin.emojicapture.e;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.e;
import com.tencent.mm.plugin.appbrand.jsapi.k.aa;
import com.tencent.mm.plugin.emojicapture.c.c;
import com.tencent.mm.plugin.emojicapture.ui.editor.EditorItemContainer;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 .2\u00020\u0001:\u0001.B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010 \u001a\u00020\u0018H\u0016J\u0010\u0010!\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020\u001cH\u0002J\u0018\u0010%\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'H\u0016J\u0010\u0010)\u001a\u00020\u001c2\u0006\u0010*\u001a\u00020\u000fH\u0016J\u0018\u0010+\u001a\u00020\u001c2\u0006\u0010,\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/presenter/EditorItemPresenter;", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorItemContract$IPresenter;", "view", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorItemContract$IView;", "(Lcom/tencent/mm/plugin/emojicapture/contract/EditorItemContract$IView;)V", "basicScale", "", "clipPath", "Landroid/graphics/Path;", "drawingBounds", "Landroid/graphics/Rect;", "framePadding", "frameRect", "frameStroke", "isClipping", "", "isEditing", "maxScale", "minScale", "originPivot", "", "paint", "Landroid/graphics/Paint;", "touchTracker", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker;", "validBounds", "Landroid/graphics/RectF;", "drawCommon", "", "canvas", "Landroid/graphics/Canvas;", "drawOutside", "getTouchTracker", "onTouch", "event", "Landroid/view/MotionEvent;", "resetMatrix", "setDrawingSize", "width", "", "height", "setEditing", "editing", "setValidArea", "bounds", "radius", "Companion", "plugin-emojicapture_release"})
public final class b implements c.a {
    public static final a rrf = new a((byte) 0);
    private float aXt = 2.0f;
    private float aXu = 0.25f;
    private final Paint paint = new Paint();
    private final com.tencent.mm.plugin.recordvideo.ui.editor.c.c rqT = new com.tencent.mm.plugin.recordvideo.ui.editor.c.c();
    private final RectF rqU = new RectF();
    private final Path rqV = new Path();
    private final Rect rqW = new Rect();
    private boolean rqX;
    private boolean rqY = true;
    private float rqZ = 1.0f;
    private final float rra;
    private final float rrb;
    private final float rrc;
    private final float[] rrd = new float[2];
    private final c.b rre;

    static {
        AppMethodBeat.i(aa.CTRL_INDEX);
        AppMethodBeat.o(aa.CTRL_INDEX);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "m", "Landroid/graphics/Matrix;", "<anonymous parameter 1>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.e.b$b  reason: collision with other inner class name */
    static final class C0971b extends q implements m<Matrix, Boolean, x> {
        final /* synthetic */ b rrg;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0971b(b bVar) {
            super(2);
            this.rrg = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(Matrix matrix, Boolean bool) {
            AppMethodBeat.i(256433);
            Matrix matrix2 = matrix;
            bool.booleanValue();
            p.h(matrix2, "m");
            this.rrg.rqT.gT.set(matrix2);
            c.b bVar = this.rrg.rre;
            if (bVar == null) {
                t tVar = new t("null cannot be cast to non-null type android.view.View");
                AppMethodBeat.o(256433);
                throw tVar;
            }
            ((View) bVar).invalidate();
            x xVar = x.SXb;
            AppMethodBeat.o(256433);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/presenter/EditorItemPresenter$Companion;", "", "()V", "DEFAULT_SCALE_TO_BOUNDS", "", "MAX_SCALE_TO_BOUNDS", "MIN_SCALE_TO_BOUNDS", "plugin-emojicapture_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public b(c.b bVar) {
        p.h(bVar, "view");
        AppMethodBeat.i(e.CTRL_INDEX);
        this.rre = bVar;
        c.b bVar2 = this.rre;
        if (bVar2 == null) {
            t tVar = new t("null cannot be cast to non-null type android.view.View");
            AppMethodBeat.o(e.CTRL_INDEX);
            throw tVar;
        }
        Context context = ((View) bVar2).getContext();
        p.g(context, "(view as View).context");
        Resources resources = context.getResources();
        this.rqT.aXt = this.aXt;
        this.rqT.aXu = this.aXu;
        this.paint.setColor(-1);
        this.paint.setAntiAlias(true);
        this.paint.setStrokeWidth(resources.getDimension(R.dimen.a1e));
        this.paint.setStyle(Paint.Style.FILL);
        this.rra = resources.getDimension(R.dimen.a1e);
        this.rrb = resources.getDimension(R.dimen.a1c);
        this.rrc = resources.getDimension(R.dimen.a1d);
        AppMethodBeat.o(e.CTRL_INDEX);
    }

    @Override // com.tencent.mm.plugin.emojicapture.c.c.a
    public final com.tencent.mm.plugin.recordvideo.ui.editor.c.c getTouchTracker() {
        return this.rqT;
    }

    @Override // com.tencent.mm.plugin.emojicapture.c.c.a
    public final void fF(int i2, int i3) {
        AppMethodBeat.i(335);
        this.rqT.width = i2;
        this.rqT.height = i3;
        this.rqW.right = i2;
        this.rqW.bottom = i3;
        resetMatrix();
        AppMethodBeat.o(335);
    }

    @Override // com.tencent.mm.plugin.emojicapture.c.c.a
    public final void a(RectF rectF, float f2) {
        AppMethodBeat.i(336);
        p.h(rectF, "bounds");
        this.rqU.set(rectF);
        this.rqV.addRoundRect(new RectF(rectF.left, rectF.top, rectF.right, rectF.bottom), f2, f2, Path.Direction.CW);
        resetMatrix();
        AppMethodBeat.o(336);
    }

    private final void resetMatrix() {
        AppMethodBeat.i(337);
        this.rqT.gT.reset();
        this.rqT.gT.postTranslate(((float) (-this.rqW.width())) / 2.0f, ((float) (-this.rqW.height())) / 2.0f);
        if (!this.rqU.isEmpty() && !this.rqW.isEmpty()) {
            this.rqZ = this.rqU.width() / ((float) Math.max(this.rqW.width(), this.rqW.height()));
            float f2 = this.rqZ * 0.5f;
            this.aXt = this.rqZ * 2.0f;
            this.aXu = this.rqZ * 0.25f;
            this.rqT.aXt = this.aXt;
            this.rqT.aXu = this.aXu;
            this.rqT.gT.postScale(f2, f2);
        }
        this.rqT.gT.postTranslate((this.rqU.left + this.rqU.right) / 2.0f, (this.rqU.top + this.rqU.bottom) / 2.0f);
        AppMethodBeat.o(337);
    }

    @Override // com.tencent.mm.plugin.emojicapture.c.c.a
    public final void setEditing(boolean z) {
        AppMethodBeat.i(338);
        this.rqX = z;
        c.b bVar = this.rre;
        if (bVar == null) {
            t tVar = new t("null cannot be cast to non-null type android.view.View");
            AppMethodBeat.o(338);
            throw tVar;
        }
        ((View) bVar).postInvalidate();
        AppMethodBeat.o(338);
    }

    @Override // com.tencent.mm.plugin.emojicapture.c.c.a
    public final boolean R(MotionEvent motionEvent) {
        AppMethodBeat.i(339);
        p.h(motionEvent, "event");
        EditorItemContainer itemContainer = this.rre.getItemContainer();
        if (this.rqT.Y(motionEvent)) {
            if (itemContainer != null) {
                itemContainer.a(this.rre, motionEvent);
            }
            switch (motionEvent.getActionMasked()) {
                case 0:
                    this.rqY = true;
                    c.b bVar = this.rre;
                    if (bVar != null) {
                        ((View) bVar).bringToFront();
                        this.rrd[0] = ((float) this.rqT.width) / 2.0f;
                        this.rrd[1] = ((float) this.rqT.height) / 2.0f;
                        this.rqT.gT.mapPoints(this.rrd);
                        break;
                    } else {
                        t tVar = new t("null cannot be cast to non-null type android.view.View");
                        AppMethodBeat.o(339);
                        throw tVar;
                    }
                case 1:
                case 3:
                    this.rqY = true;
                    com.tencent.mm.plugin.recordvideo.ui.editor.c.a aVar = new com.tencent.mm.plugin.recordvideo.ui.editor.c.a();
                    aVar.aXu = this.aXu;
                    aVar.aXt = this.aXt;
                    aVar.n(new float[]{((float) this.rqW.width()) / 2.0f, ((float) this.rqW.height()) / 2.0f});
                    aVar.f(new RectF(this.rqU.left, this.rqU.top, this.rqU.right, this.rqU.bottom));
                    float[] fArr = {((float) this.rqT.width) / 2.0f, ((float) this.rqT.height) / 2.0f};
                    this.rqT.gT.mapPoints(fArr);
                    if (!aVar.CgM.contains(fArr[0], fArr[1])) {
                        aVar.f(new RectF(this.rrd[0], this.rrd[1], this.rrd[0], this.rrd[1]));
                    }
                    aVar.a(this.rqT.gT, new C0971b(this));
                    break;
                case 2:
                    this.rqY = false;
                    break;
            }
            c.b bVar2 = this.rre;
            if (bVar2 == null) {
                t tVar2 = new t("null cannot be cast to non-null type android.view.View");
                AppMethodBeat.o(339);
                throw tVar2;
            }
            ((View) bVar2).invalidate();
            AppMethodBeat.o(339);
            return true;
        }
        AppMethodBeat.o(339);
        return false;
    }

    @Override // com.tencent.mm.plugin.emojicapture.c.c.a
    public final void q(Canvas canvas) {
        AppMethodBeat.i(340);
        p.h(canvas, "canvas");
        if (this.rqY) {
            canvas.clipPath(this.rqV);
        }
        canvas.setMatrix(this.rqT.gT);
        if (this.rqX) {
            float f2 = ((float) this.rqW.left) - (this.rrb / this.rqZ);
            float f3 = ((float) this.rqW.top) - (this.rrb / this.rqZ);
            float f4 = ((float) this.rqW.right) + (this.rrb / this.rqZ);
            float f5 = ((float) this.rqW.bottom) + (this.rrb / this.rqZ);
            float f6 = (this.rrc / 2.0f) / this.rqZ;
            this.paint.setStrokeWidth(this.rra / this.rqZ);
            canvas.drawRect(f2 - f6, f3 - f6, f2 + f6, f3 + f6, this.paint);
            canvas.drawRect(f4 - f6, f3 - f6, f4 + f6, f3 + f6, this.paint);
            canvas.drawRect(f4 - f6, f5 - f6, f4 + f6, f5 + f6, this.paint);
            canvas.drawRect(f2 - f6, f5 - f6, f2 + f6, f5 + f6, this.paint);
            canvas.drawLines(new float[]{f2, f3, f4, f3, f4, f3, f4, f5, f4, f5, f2, f5, f2, f5, f2, f3}, this.paint);
        }
        AppMethodBeat.o(340);
    }

    @Override // com.tencent.mm.plugin.emojicapture.c.c.a
    public final void r(Canvas canvas) {
        AppMethodBeat.i(FacebookRequestErrorClassification.EC_TOO_MANY_USER_ACTION_CALLS);
        p.h(canvas, "canvas");
        AppMethodBeat.o(FacebookRequestErrorClassification.EC_TOO_MANY_USER_ACTION_CALLS);
    }
}
