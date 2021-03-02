package com.tencent.mm.plugin.recordvideo.ui.editor.item;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.view.EmojiStatusView;
import com.tencent.mm.plugin.gif.d;
import com.tencent.mm.plugin.gif.h;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.EditorItemContainer;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.a.e;
import com.tencent.mm.plugin.recordvideo.ui.editor.view.b;
import com.tencent.mm.plugin.recordvideo.ui.editor.view.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.au;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\n\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0014\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010&\u001a\u00020\u0012H\u0016J\b\u0010'\u001a\u00020(H\u0016J\n\u0010)\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010*\u001a\u00020\nH\u0016J\b\u0010+\u001a\u00020,H\u0016J\u0016\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000200J\u0010\u00102\u001a\u00020.2\u0006\u00103\u001a\u000204H\u0014J\u0010\u00105\u001a\u00020\u00102\u0006\u00106\u001a\u000207H\u0016J\u000e\u00108\u001a\u00020.2\u0006\u00109\u001a\u00020\fJ\u0018\u0010:\u001a\u00020.2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010;\u001a\u000200H\u0016J\u000e\u0010<\u001a\u00020.2\u0006\u00109\u001a\u00020\fJ\u0012\u0010=\u001a\u00020.2\b\u0010>\u001a\u0004\u0018\u00010?H\u0016J\u0018\u0010@\u001a\u00020.2\u0006\u0010A\u001a\u00020\n2\u0006\u0010B\u001a\u00020CH\u0016J\u000e\u0010D\u001a\u00020.2\u0006\u0010\u0013\u001a\u00020\u0014J\u0010\u0010E\u001a\u00020.2\u0006\u0010\u0019\u001a\u00020\nH\u0016R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R(\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006F"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EmojiItemView;", "Lcom/tencent/mm/emoji/view/EmojiStatusView;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/IEditable;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/IEditView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TAG", "", "displayRect", "Landroid/graphics/Rect;", "emojiItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EmojiItem;", "frameDrawable", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/ActiveFrameDrawable;", "isReshow", "", "originPivot", "", "stateResolve", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer$ItemStateResolve;", "touchTracker", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker;", "getTouchTracker", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker;", "validRect", "value", "Landroid/graphics/Matrix;", "viewMatrix", "getViewMatrix", "()Landroid/graphics/Matrix;", "setViewMatrix", "(Landroid/graphics/Matrix;)V", "createEditorData", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "createEditorItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "matrix", "getContentBoundary", "getDrawRect", "Landroid/graphics/RectF;", "getEditorData", "getSafeArea", "getType", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/EditItemType;", "initScale", "", "sx", "", "sy", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "reshowEmoji", "item", "setDefaultLocation", "heightPercent", "setEmojiItem", "setImageDrawable", "drawable", "Landroid/graphics/drawable/Drawable;", "setSafeArea", "safeRect", "damp", "", "setStateResolve", "setValidArea", "plugin-recordvideo_release"})
public final class f extends EmojiStatusView implements g, c {
    private final Rect Cao = new Rect(0, 0, au.az(MMApplicationContext.getContext()).x, au.az(MMApplicationContext.getContext()).y);
    private final Rect Cap = new Rect(0, 0, au.az(MMApplicationContext.getContext()).x, au.az(MMApplicationContext.getContext()).y);
    private EditorItemContainer.b Caq;
    private Matrix CeE;
    private final com.tencent.mm.plugin.recordvideo.ui.editor.view.a Cey;
    private e Cfv;
    private boolean Cfw;
    private final String TAG = "MicroMsg.EmojiItemView";
    private final com.tencent.mm.plugin.recordvideo.ui.editor.c.c rqT = new com.tencent.mm.plugin.recordvideo.ui.editor.c.c();
    private final float[] rrd = new float[2];

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "m", "Landroid/graphics/Matrix;", "animateFinish", "", "invoke"})
    static final class a extends q implements m<Matrix, Boolean, x> {
        final /* synthetic */ MotionEvent CaJ;
        final /* synthetic */ f Cfx;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(f fVar, MotionEvent motionEvent) {
            super(2);
            this.Cfx = fVar;
            this.CaJ = motionEvent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(Matrix matrix, Boolean bool) {
            AppMethodBeat.i(237766);
            Matrix matrix2 = matrix;
            boolean booleanValue = bool.booleanValue();
            p.h(matrix2, "m");
            this.Cfx.getTouchTracker().g(matrix2);
            this.Cfx.postInvalidate();
            if (booleanValue) {
                this.Cfx.getTouchTracker().Y(this.CaJ);
                this.Cfx.bringToFront();
                EditorItemContainer.b bVar = this.Cfx.Caq;
                if (bVar != null) {
                    bVar.d(this.Cfx, this.CaJ);
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(237766);
            return xVar;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(Context context) {
        super(context);
        p.h(context, "context");
        AppMethodBeat.i(237774);
        this.rqT.aXu = 0.5f;
        this.rqT.aXt = 3.0f;
        Resources resources = getResources();
        p.g(resources, "resources");
        this.Cey = new com.tencent.mm.plugin.recordvideo.ui.editor.view.a(resources);
        AppMethodBeat.o(237774);
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.view.c
    public final boolean Ig(long j2) {
        AppMethodBeat.i(237775);
        boolean a2 = c.a.a(this, j2);
        AppMethodBeat.o(237775);
        return a2;
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.view.c
    public final boolean aLB(String str) {
        AppMethodBeat.i(237776);
        p.h(str, "objID");
        boolean a2 = c.a.a(this, str);
        AppMethodBeat.o(237776);
        return a2;
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.view.c
    public final boolean eLK() {
        return true;
    }

    public final com.tencent.mm.plugin.recordvideo.ui.editor.c.c getTouchTracker() {
        return this.rqT;
    }

    public final Matrix getViewMatrix() {
        return this.CeE;
    }

    public final void setViewMatrix(Matrix matrix) {
        AppMethodBeat.i(76124);
        if (p.j(this.CeE, matrix)) {
            AppMethodBeat.o(76124);
            return;
        }
        if (matrix != null) {
            this.rqT.setMatrix(matrix);
        }
        AppMethodBeat.o(76124);
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.view.c
    public final void setValidArea(Rect rect) {
        AppMethodBeat.i(76125);
        p.h(rect, "validRect");
        this.Cao.set(rect);
        AppMethodBeat.o(76125);
    }

    public final void setStateResolve(EditorItemContainer.b bVar) {
        AppMethodBeat.i(76126);
        p.h(bVar, "stateResolve");
        this.Caq = bVar;
        AppMethodBeat.o(76126);
    }

    public final void af(float f2, float f3) {
        AppMethodBeat.i(237767);
        if (!(f2 == 0.0f || f3 == 0.0f)) {
            this.rqT.gT.setScale(f2, f3);
        }
        AppMethodBeat.o(237767);
    }

    /* access modifiers changed from: protected */
    public final void onDraw(Canvas canvas) {
        AppMethodBeat.i(76127);
        p.h(canvas, "canvas");
        canvas.save();
        canvas.setMatrix(this.rqT.gT);
        if (isActivated()) {
            this.Cey.draw(canvas);
        }
        canvas.restore();
        canvas.clipRect(this.Cao);
        canvas.save();
        canvas.setMatrix(this.rqT.gT);
        Drawable drawable = getDrawable();
        if (drawable != null) {
            drawable.draw(canvas);
        }
        canvas.restore();
        AppMethodBeat.o(76127);
    }

    public final void setEmojiItem(e eVar) {
        AppMethodBeat.i(237768);
        p.h(eVar, "item");
        this.Cfv = eVar;
        setEmojiInfo(eVar.gWm);
        AppMethodBeat.o(237768);
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.view.c
    public final a getEditorData() {
        return this.Cfv;
    }

    public final void a(e eVar) {
        AppMethodBeat.i(237769);
        p.h(eVar, "item");
        this.Cfw = true;
        setViewMatrix(eVar.Cft);
        setEmojiInfo(eVar.gWm);
        AppMethodBeat.o(237769);
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        AppMethodBeat.i(76128);
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
        AppMethodBeat.o(76128);
        return z;
    }

    @Override // android.support.v7.widget.AppCompatImageView
    public final void setImageDrawable(Drawable drawable) {
        AppMethodBeat.i(76129);
        if (drawable != null) {
            if (drawable instanceof h) {
                ((h) drawable).rU();
            }
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (!this.Cfw) {
                this.rqT.gT.postTranslate(((float) this.rqT.width) / 2.0f, ((float) this.rqT.height) / 2.0f);
                this.rqT.width = intrinsicWidth;
                this.rqT.height = intrinsicHeight;
                this.rqT.gT.postTranslate(((float) (-intrinsicWidth)) / 2.0f, -((((float) ((this.Cap.top + this.Cap.bottom) / 2)) - (((float) (this.Cao.top + this.Cao.bottom)) / 2.0f)) + (((float) intrinsicHeight) / 2.0f)));
            }
            this.Cey.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            this.rqT.o(new float[]{0.0f, 0.0f, (float) intrinsicWidth, 0.0f, 0.0f, (float) intrinsicHeight, (float) intrinsicWidth, (float) intrinsicHeight});
        }
        super.setImageDrawable(drawable);
        AppMethodBeat.o(76129);
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.item.g
    public final com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a c(Matrix matrix) {
        AppMethodBeat.i(237770);
        if (getEmojiInfo() == null) {
            AppMethodBeat.o(237770);
            return null;
        } else if (getDrawable() instanceof BitmapDrawable) {
            Drawable drawable = getDrawable();
            if (drawable == null) {
                t tVar = new t("null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
                AppMethodBeat.o(237770);
                throw tVar;
            }
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            Matrix matrix2 = new Matrix();
            matrix2.postConcat(this.rqT.gT);
            if (matrix != null) {
                matrix2.postConcat(matrix);
            }
            com.tencent.mm.plugin.recordvideo.ui.editor.item.a.c cVar = new com.tencent.mm.plugin.recordvideo.ui.editor.item.a.c(bitmap, matrix2);
            AppMethodBeat.o(237770);
            return cVar;
        } else {
            float f2 = 1.0f;
            if (getDrawable() instanceof d) {
                Drawable drawable2 = getDrawable();
                if (drawable2 == null) {
                    t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.gif.MMGIFDrawable");
                    AppMethodBeat.o(237770);
                    throw tVar2;
                }
                f2 = ((d) drawable2).getEmojiDensityScale();
            } else if (getDrawable() instanceof h) {
                Drawable drawable3 = getDrawable();
                if (drawable3 == null) {
                    t tVar3 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.gif.MMWXGFDrawable");
                    AppMethodBeat.o(237770);
                    throw tVar3;
                }
                f2 = ((h) drawable3).getEmojiDensityScale();
            }
            Matrix matrix3 = new Matrix();
            Log.i(this.TAG, "createEditorItem displayRect:" + this.Cap + " validRect:" + this.Cao);
            matrix3.setScale(f2, f2);
            matrix3.postConcat(this.rqT.gT);
            if (matrix != null) {
                matrix3.postConcat(matrix);
            }
            EmojiInfo emojiInfo = getEmojiInfo();
            if (emojiInfo == null) {
                p.hyc();
            }
            e eVar = new e(emojiInfo, matrix3);
            AppMethodBeat.o(237770);
            return eVar;
        }
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.item.g
    public final a cJO() {
        com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d dVar;
        com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d dVar2;
        String str = null;
        AppMethodBeat.i(237771);
        if (getEmojiInfo() == null) {
            AppMethodBeat.o(237771);
            return null;
        } else if (getDrawable() instanceof BitmapDrawable) {
            Matrix matrix = new Matrix();
            matrix.postConcat(this.rqT.gT);
            e eVar = new e(getEmojiInfo(), matrix, matrix);
            e eVar2 = this.Cfv;
            if (!(eVar2 == null || (dVar2 = eVar2.Cev) == null)) {
                eVar.Cev.ai(dVar2.getStart(), dVar2.getEnd());
            }
            e eVar3 = this.Cfv;
            if (eVar3 != null) {
                str = eVar3.objectId;
            }
            eVar.objectId = str;
            e eVar4 = eVar;
            AppMethodBeat.o(237771);
            return eVar4;
        } else {
            float f2 = 1.0f;
            if (getDrawable() instanceof d) {
                Drawable drawable = getDrawable();
                if (drawable == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.gif.MMGIFDrawable");
                    AppMethodBeat.o(237771);
                    throw tVar;
                }
                f2 = ((d) drawable).getEmojiDensityScale();
            } else if (getDrawable() instanceof h) {
                Drawable drawable2 = getDrawable();
                if (drawable2 == null) {
                    t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.gif.MMWXGFDrawable");
                    AppMethodBeat.o(237771);
                    throw tVar2;
                }
                f2 = ((h) drawable2).getEmojiDensityScale();
            }
            Matrix matrix2 = new Matrix();
            Matrix matrix3 = new Matrix();
            Log.i(this.TAG, "createEditorData displayRect:" + this.Cap + " validRect:" + this.Cao);
            matrix3.set(this.rqT.gT);
            matrix3.postTranslate(((float) (-(this.Cap.width() - this.Cao.width()))) / 2.0f, -((float) this.Cao.top));
            matrix2.setScale(f2, f2);
            matrix2.postConcat(this.rqT.gT);
            e eVar5 = new e(getEmojiInfo(), matrix3, matrix2);
            e eVar6 = this.Cfv;
            if (!(eVar6 == null || (dVar = eVar6.Cev) == null)) {
                eVar5.Cev.ai(dVar.getStart(), dVar.getEnd());
            }
            e eVar7 = this.Cfv;
            if (eVar7 != null) {
                str = eVar7.objectId;
            }
            eVar5.objectId = str;
            e eVar8 = eVar5;
            AppMethodBeat.o(237771);
            return eVar8;
        }
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.view.c
    public final void b(Rect rect, int i2) {
        AppMethodBeat.i(237772);
        p.h(rect, "safeRect");
        this.rqT.BKm = rect;
        this.rqT.Chb = com.tencent.mm.cb.a.fromDPToPix(getContext(), i2);
        AppMethodBeat.o(237772);
    }

    public final Rect getSafeArea() {
        AppMethodBeat.i(76132);
        Rect rect = this.rqT.BKm;
        if (rect == null) {
            Resources resources = getResources();
            p.g(resources, "resources");
            int i2 = resources.getDisplayMetrics().widthPixels;
            Resources resources2 = getResources();
            p.g(resources2, "resources");
            rect = new Rect(0, 0, i2, resources2.getDisplayMetrics().heightPixels);
        }
        AppMethodBeat.o(76132);
        return rect;
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.view.c
    public final float[] getContentBoundary() {
        AppMethodBeat.i(76133);
        float[] fArr = (float[]) this.rqT.Chg.clone();
        AppMethodBeat.o(76133);
        return fArr;
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.view.c
    public final void a(Rect rect, float f2) {
        AppMethodBeat.i(76134);
        p.h(rect, "displayRect");
        this.Cap.set(rect);
        this.rqT.gT.postTranslate(((float) rect.width()) / 2.0f, ((float) rect.height()) * f2);
        AppMethodBeat.o(76134);
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.view.c
    public final b getType() {
        return b.EditItemTypeEmoji;
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.view.c
    public final RectF getDrawRect() {
        AppMethodBeat.i(237773);
        RectF rectF = new RectF(this.rqT.Chg[0], this.rqT.Chg[1], this.rqT.Chg[2], this.rqT.Chg[3]);
        AppMethodBeat.o(237773);
        return rectF;
    }
}
