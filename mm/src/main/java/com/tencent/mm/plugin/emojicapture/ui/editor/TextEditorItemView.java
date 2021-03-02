package com.tencent.mm.plugin.emojicapture.ui.editor;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.e;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.i;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.n;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.o;
import com.tencent.mm.plugin.appbrand.jsapi.share.t;
import com.tencent.mm.plugin.emojicapture.c.c;
import com.tencent.smtt.sdk.TbsListener;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 e2\u00020\u00012\u00020\u0002:\u0001eB\u0011\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005B\u001b\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB!\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\n\u0010A\u001a\u0004\u0018\u00010BH\u0016J\u0014\u0010C\u001a\u0004\u0018\u00010D2\b\u0010E\u001a\u0004\u0018\u00010FH\u0016J\u0012\u0010G\u001a\u00020\u00122\b\u0010H\u001a\u0004\u0018\u00010?H\u0002J\n\u0010I\u001a\u0004\u0018\u00010JH\u0016J\b\u0010K\u001a\u0004\u0018\u000102J\u0006\u0010L\u001a\u00020\nJ\b\u0010M\u001a\u00020&H\u0016J\u0010\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020QH\u0014J\u0010\u0010R\u001a\u00020&2\u0006\u0010S\u001a\u00020TH\u0016J\b\u0010U\u001a\u00020OH\u0016J\b\u0010V\u001a\u00020OH\u0002J\b\u0010W\u001a\u00020OH\u0002J\u0018\u0010X\u001a\u00020O2\u0006\u0010Y\u001a\u00020\n2\u0006\u0010Z\u001a\u00020\nH\u0002J\b\u0010[\u001a\u00020OH\u0016J\u0010\u0010\\\u001a\u00020O2\u0006\u0010]\u001a\u00020&H\u0016J\u0018\u0010^\u001a\u00020O2\u0006\u0010_\u001a\u00020#2\u0006\u0010`\u001a\u00020\u0017H\u0016J\b\u0010a\u001a\u00020OH\u0002J \u0010b\u001a\u00020O2\b\u00101\u001a\u0004\u0018\u0001022\u0006\u0010c\u001a\u00020\n2\u0006\u0010d\u001a\u00020&R\u000e\u0010\f\u001a\u00020\rXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0011X\u0004¢\u0006\u0004\n\u0002\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r0\u0011X\u000e¢\u0006\u0004\n\u0002\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020&X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020&X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020&X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0004¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u000102X\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020&X\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020;X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000R\u0018\u0010>\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010?0\u0011X\u000e¢\u0006\u0004\n\u0002\u0010@¨\u0006f"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/ui/editor/TextEditorItemView;", "Landroid/view/View;", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorItemContract$IView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "animCount", "animIndex", "bitmapArray", "", "Landroid/graphics/Bitmap;", "[Landroid/graphics/Bitmap;", "bitmapOffset", "Landroid/graphics/PointF;", "bottomMargin", "", "clipPath", "Landroid/graphics/Path;", "contentPadding", "drawingOffset", "fontPaths", "[Ljava/lang/String;", "framePadding", "framePaint", "Landroid/graphics/Paint;", "framePath", "framePathRect", "Landroid/graphics/RectF;", "frameStrokeWidth", "isClipping", "", "isEditing", "isEditingBeforeTouch", "isValid", "maxScale", "minScale", "originPivot", "", "strokeColor", "switchRunnable", "Ljava/lang/Runnable;", "text", "", "textColor", "textDrawer", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/TextDrawer;", "touchDownX", "touchDownY", "touchMoved", "touchSlop", "touchTracker", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker;", "typefaceIndex", "validRect", "wxTypeFaces", "Landroid/graphics/Typeface;", "[Landroid/graphics/Typeface;", "createEditorData", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "createEditorItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "matrix", "Landroid/graphics/Matrix;", "createTextBitmap", "typeface", "getItemContainer", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorItemContainer;", "getText", "getTextColor", "handleRemove", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "pause", "preSetMatrix", "refresh", "resetFrame", "contentWidth", "contentHeight", "resume", "setEditing", "editing", "setValidArea", "bounds", "radius", "switchFont", "updateText", "color", "change", "Companion", "plugin-emojicapture_release"})
public final class TextEditorItemView extends View implements c.b {
    public static final a rvD = new a((byte) 0);
    private final String TAG;
    private float aXt;
    private float aXu;
    private final float bottomMargin;
    private boolean daZ;
    private boolean gZU;
    private float gZX;
    private float gZY;
    private final float ovb;
    private final com.tencent.mm.plugin.recordvideo.ui.editor.c.c rqT;
    private final Path rqV;
    private boolean rqX;
    private boolean rqY;
    private final float rrb;
    private final float[] rrd;
    private RectF ruR;
    private boolean rvA;
    private final PointF rvB;
    private final PointF rvC;
    private com.tencent.mm.plugin.emojicapture.ui.editor.text.c rvm;
    private String[] rvo;
    private Typeface[] rvp;
    private int rvq;
    private final Runnable rvr;
    private final Paint rvs;
    private final float rvt;
    private final Path rvu;
    private final RectF rvv;
    private final int rvw;
    private int rvx;
    private final Bitmap[] rvy;
    private final float rvz;
    private int strokeColor;
    private CharSequence text;
    private int textColor;

    static {
        AppMethodBeat.i(TbsListener.ErrorCode.INFO_OPEN_FILE_TBS_INIT_FAILED);
        AppMethodBeat.o(TbsListener.ErrorCode.INFO_OPEN_FILE_TBS_INIT_FAILED);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "m", "Landroid/graphics/Matrix;", "<anonymous parameter 1>", "", "invoke"})
    static final class c extends q implements m<Matrix, Boolean, x> {
        final /* synthetic */ TextEditorItemView rvE;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(TextEditorItemView textEditorItemView) {
            super(2);
            this.rvE = textEditorItemView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(Matrix matrix, Boolean bool) {
            AppMethodBeat.i(256449);
            Matrix matrix2 = matrix;
            bool.booleanValue();
            p.h(matrix2, "m");
            if (this.rvE.daZ) {
                this.rvE.rqT.gT.set(matrix2);
                this.rvE.invalidate();
            }
            x xVar = x.SXb;
            AppMethodBeat.o(256449);
            return xVar;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x00cc A[LOOP:1: B:12:0x00ca->B:13:0x00cc, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public TextEditorItemView(android.content.Context r11, android.util.AttributeSet r12, int r13) {
        /*
        // Method dump skipped, instructions count: 361
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.emojicapture.ui.editor.TextEditorItemView.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public static final /* synthetic */ void c(TextEditorItemView textEditorItemView) {
        AppMethodBeat.i(TbsListener.ErrorCode.INFO_OPEN_FILE_MINIQB_RETURN_CANNOT_OPEN);
        textEditorItemView.cJQ();
        AppMethodBeat.o(TbsListener.ErrorCode.INFO_OPEN_FILE_MINIQB_RETURN_CANNOT_OPEN);
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.item.g
    public final com.tencent.mm.plugin.recordvideo.ui.editor.item.a cJO() {
        return null;
    }

    public TextEditorItemView(Context context) {
        this(context, null);
    }

    public TextEditorItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/ui/editor/TextEditorItemView$Companion;", "", "()V", "ANIM_INTERVAL", "", "TEXT_COLOR_INVALID", "", "plugin-emojicapture_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class d implements Runnable {
        final /* synthetic */ TextEditorItemView rvE;

        d(TextEditorItemView textEditorItemView) {
            this.rvE = textEditorItemView;
        }

        public final void run() {
            AppMethodBeat.i(com.tencent.mm.plugin.appbrand.jsapi.media.m.CTRL_INDEX);
            TextEditorItemView.c(this.rvE);
            AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.media.m.CTRL_INDEX);
        }
    }

    @Override // com.tencent.mm.plugin.emojicapture.ui.editor.a
    public final void resume() {
        AppMethodBeat.i(e.CTRL_INDEX);
        cJQ();
        AppMethodBeat.o(e.CTRL_INDEX);
    }

    @Override // com.tencent.mm.plugin.emojicapture.ui.editor.a
    public final void pause() {
        AppMethodBeat.i(com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.m.CTRL_INDEX);
        removeCallbacks(this.rvr);
        AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.m.CTRL_INDEX);
    }

    @Override // com.tencent.mm.plugin.emojicapture.ui.editor.a
    public final void a(RectF rectF, float f2) {
        AppMethodBeat.i(790);
        p.h(rectF, "bounds");
        this.ruR.set(rectF);
        this.rqV.addRoundRect(new RectF(rectF.left, rectF.top, rectF.right, rectF.bottom), f2, f2, Path.Direction.CW);
        this.rvB.set((rectF.left + (rectF.width() / 2.0f)) - (this.rvv.width() / 2.0f), (rectF.bottom - this.bottomMargin) - this.rvv.height());
        cJR();
        AppMethodBeat.o(790);
    }

    @Override // com.tencent.mm.plugin.emojicapture.ui.editor.a
    public final void setEditing(boolean z) {
        AppMethodBeat.i(i.CTRL_INDEX);
        this.rqX = z;
        postInvalidate();
        AppMethodBeat.o(i.CTRL_INDEX);
    }

    @Override // com.tencent.mm.plugin.emojicapture.ui.editor.a
    public final boolean cJP() {
        AppMethodBeat.i(com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.l.CTRL_INDEX);
        a("", 0, true);
        post(new b(this));
        AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.l.CTRL_INDEX);
        return true;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        final /* synthetic */ TextEditorItemView rvE;

        b(TextEditorItemView textEditorItemView) {
            this.rvE = textEditorItemView;
        }

        public final void run() {
            AppMethodBeat.i(com.tencent.mm.plugin.appbrand.jsapi.k.e.CTRL_INDEX);
            EditorItemContainer itemContainer = this.rvE.getItemContainer();
            if (itemContainer != null) {
                itemContainer.setEditing(this.rvE);
                AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.k.e.CTRL_INDEX);
                return;
            }
            AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.k.e.CTRL_INDEX);
        }
    }

    public final CharSequence getText() {
        if (this.daZ) {
            return this.text;
        }
        return null;
    }

    public final void a(CharSequence charSequence, int i2, boolean z) {
        boolean z2;
        boolean z3 = true;
        AppMethodBeat.i(o.CTRL_INDEX);
        if (z) {
            this.text = charSequence;
            this.textColor = i2;
            this.strokeColor = com.tencent.mm.plugin.emojicapture.ui.c.Gp(this.textColor);
            if (charSequence == null || charSequence.length() == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                z3 = false;
            }
            this.daZ = z3;
            refresh();
        }
        AppMethodBeat.o(o.CTRL_INDEX);
    }

    public final int getTextColor() {
        if (this.daZ) {
            return this.textColor;
        }
        return 0;
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(n.CTRL_INDEX);
        p.h(motionEvent, "event");
        boolean Y = this.rqT.Y(motionEvent);
        if (Y) {
            postInvalidate();
            switch (motionEvent.getActionMasked()) {
                case 0:
                    this.rvA = this.rqX;
                    this.gZU = false;
                    this.gZX = motionEvent.getX();
                    this.gZY = motionEvent.getY();
                    this.rqY = true;
                    this.rrd[0] = ((float) this.rqT.width) / 2.0f;
                    this.rrd[1] = ((float) this.rqT.height) / 2.0f;
                    this.rqT.gT.mapPoints(this.rrd);
                    break;
                case 1:
                case 3:
                    this.rqY = true;
                    if ((!this.daZ || this.rvA) && !this.gZU) {
                        performClick();
                    }
                    com.tencent.mm.plugin.recordvideo.ui.editor.c.a aVar = new com.tencent.mm.plugin.recordvideo.ui.editor.c.a();
                    aVar.aXu = this.aXu;
                    aVar.aXt = this.aXt;
                    aVar.n(new float[]{this.rvv.width() / 2.0f, this.rvv.height() / 2.0f});
                    aVar.f(new RectF(this.ruR.left, this.ruR.top, this.ruR.right, this.ruR.bottom));
                    float[] fArr = {((float) this.rqT.width) / 2.0f, ((float) this.rqT.height) / 2.0f};
                    this.rqT.gT.mapPoints(fArr);
                    if (!aVar.CgM.contains(fArr[0], fArr[1])) {
                        aVar.f(new RectF(this.rrd[0], this.rrd[1], this.rrd[0], this.rrd[1]));
                    }
                    aVar.a(this.rqT.gT, new c(this));
                    break;
                case 2:
                    this.rqY = false;
                    if (Math.abs(motionEvent.getX() - this.gZX) > this.ovb || Math.abs(motionEvent.getY() - this.gZY) > this.ovb) {
                        this.gZU = true;
                        break;
                    }
                case 5:
                case 6:
                    if (!this.daZ) {
                        AppMethodBeat.o(n.CTRL_INDEX);
                        return false;
                    }
                    break;
            }
            if (!this.daZ) {
                cJR();
            } else {
                EditorItemContainer itemContainer = getItemContainer();
                if (itemContainer != null) {
                    itemContainer.a(this, motionEvent);
                }
            }
            AppMethodBeat.o(n.CTRL_INDEX);
            return Y;
        }
        AppMethodBeat.o(n.CTRL_INDEX);
        return false;
    }

    /* access modifiers changed from: protected */
    public final void onDraw(Canvas canvas) {
        AppMethodBeat.i(com.tencent.mm.plugin.appbrand.jsapi.share.c.CTRL_INDEX);
        p.h(canvas, "canvas");
        if (this.rqY) {
            canvas.clipPath(this.rqV);
        }
        canvas.save();
        canvas.concat(this.rqT.gT);
        if (this.rqX) {
            canvas.drawPath(this.rvu, this.rvs);
        }
        Bitmap bitmap = this.rvy[this.rvx];
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, this.rvC.x, this.rvC.y, (Paint) null);
        }
        canvas.restore();
        AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.share.c.CTRL_INDEX);
    }

    private final void refresh() {
        AppMethodBeat.i(796);
        kotlin.a.e.P(this.rvy);
        this.rvx = 0;
        this.rvq = 0;
        cJQ();
        AppMethodBeat.o(796);
    }

    private final void cJQ() {
        AppMethodBeat.i(797);
        if (this.daZ) {
            this.rvx++;
            this.rvx %= this.rvw;
            Typeface typeface = this.rvp[this.rvq];
            this.rvm.anr(this.rvo[this.rvq]);
            this.rvq++;
            this.rvq %= this.rvp.length;
            if (this.rvy[this.rvx] == null) {
                Bitmap d2 = d(typeface);
                this.rvy[this.rvx] = d2;
                fL(d2.getWidth(), d2.getHeight());
            }
            removeCallbacks(this.rvr);
            postDelayed(this.rvr, 100);
        } else if (this.rvy[this.rvx] == null) {
            Typeface typeface2 = this.rvp[0];
            this.rvm.anr(this.rvo[this.rvq]);
            Bitmap d3 = d(typeface2);
            this.rvy[this.rvx] = d3;
            fL(d3.getWidth(), d3.getHeight());
        }
        invalidate();
        AppMethodBeat.o(797);
    }

    private final void fL(int i2, int i3) {
        AppMethodBeat.i(t.CTRL_INDEX);
        float f2 = ((float) i2) + (this.rrb * 2.0f);
        float f3 = ((float) i3) + (this.rrb * 2.0f);
        float width = this.rvv.width();
        float height = this.rvv.height();
        if (this.rvv.isEmpty()) {
            this.rvB.offset(f2 / 2.0f, -f3);
        } else {
            this.rvB.offset((width - f2) / 2.0f, (height - f3) / 2.0f);
        }
        this.rvv.set(0.0f, 0.0f, f2, f3);
        this.rvu.reset();
        this.rvu.addRoundRect(this.rvv, this.rrb, this.rrb, Path.Direction.CW);
        this.rqT.gT.preTranslate((((float) this.rqT.width) - f2) / 2.0f, ((float) this.rqT.height) - f3);
        if (!this.daZ) {
            cJR();
        }
        this.rqT.width = (int) f2;
        this.rqT.height = (int) f3;
        AppMethodBeat.o(t.CTRL_INDEX);
    }

    private final void cJR() {
        AppMethodBeat.i(799);
        this.rqT.gT.setTranslate(this.rvB.x, this.rvB.y);
        AppMethodBeat.o(799);
    }

    private final Bitmap d(Typeface typeface) {
        AppMethodBeat.i(800);
        FontTextView fontTextView = new FontTextView(getContext());
        fontTextView.setMaxWidth(this.ruR.width());
        fontTextView.setTextDrawer(this.rvm);
        fontTextView.setTypeface(typeface);
        fontTextView.d(this.text, this.textColor, this.strokeColor);
        fontTextView.measure(View.MeasureSpec.makeMeasureSpec((int) (this.ruR.width() - (2.0f * this.rvz)), Integer.MIN_VALUE), 0);
        Bitmap createBitmap = Bitmap.createBitmap(fontTextView.getMeasuredWidth(), fontTextView.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.save();
        fontTextView.draw(canvas);
        canvas.restore();
        p.g(createBitmap, "bitmap");
        AppMethodBeat.o(800);
        return createBitmap;
    }

    @Override // com.tencent.mm.plugin.emojicapture.c.c.b
    public final EditorItemContainer getItemContainer() {
        AppMethodBeat.i(801);
        ViewParent parent = getParent();
        p.g(parent, "parent");
        if (parent.getParent() instanceof EditorItemContainer) {
            ViewParent parent2 = getParent();
            p.g(parent2, "parent");
            ViewParent parent3 = parent2.getParent();
            if (parent3 == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.emojicapture.ui.editor.EditorItemContainer");
                AppMethodBeat.o(801);
                throw tVar;
            }
            EditorItemContainer editorItemContainer = (EditorItemContainer) parent3;
            AppMethodBeat.o(801);
            return editorItemContainer;
        }
        AppMethodBeat.o(801);
        return null;
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.item.g
    public final com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a c(Matrix matrix) {
        AppMethodBeat.i(256450);
        if (!this.daZ) {
            AppMethodBeat.o(256450);
            return null;
        }
        Matrix matrix2 = new Matrix();
        matrix2.postConcat(this.rqT.gT);
        matrix2.postTranslate(this.rvC.x, this.rvC.y);
        if (matrix != null) {
            matrix2.postConcat(matrix);
        }
        com.tencent.mm.plugin.recordvideo.ui.editor.item.a.b bVar = new com.tencent.mm.plugin.recordvideo.ui.editor.item.a.b(this.rvy, matrix2);
        AppMethodBeat.o(256450);
        return bVar;
    }
}
