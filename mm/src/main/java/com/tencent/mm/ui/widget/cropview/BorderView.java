package com.tencent.mm.ui.widget.cropview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.R;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0002J\u0010\u0010-\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0002J\u0006\u0010.\u001a\u00020*J\u0010\u0010/\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0014J(\u00100\u001a\u00020*2\u0006\u00101\u001a\u00020\t2\u0006\u00102\u001a\u00020\t2\u0006\u00103\u001a\u00020\t2\u0006\u00104\u001a\u00020\tH\u0014J\u000e\u00105\u001a\u00020*2\u0006\u00106\u001a\u00020\u001eJ\b\u00107\u001a\u00020*H\u0002R\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0011\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0012\u0010\u000eR\u001b\u0010\u0014\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0015\u0010\u000eR\u001b\u0010\u0017\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0010\u001a\u0004\b\u0018\u0010\u000eR\u001b\u0010\u001a\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0010\u001a\u0004\b\u001b\u0010\u000eR\u000e\u0010\u001d\u001a\u00020\u001eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u001eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\"X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\"X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u001eX\u000e¢\u0006\u0002\n\u0000¨\u00068"}, hxF = {"Lcom/tencent/mm/ui/widget/cropview/BorderView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "BOX_GIRD_WIDTH", "", "getBOX_GIRD_WIDTH", "()F", "BOX_GIRD_WIDTH$delegate", "Lkotlin/Lazy;", "BOX_LINE_WIDTH", "getBOX_LINE_WIDTH", "BOX_LINE_WIDTH$delegate", "BOX_PADDING", "getBOX_PADDING", "BOX_PADDING$delegate", "CORNER_LENGTH", "getCORNER_LENGTH", "CORNER_LENGTH$delegate", "CORNER_WIDTH", "getCORNER_WIDTH", "CORNER_WIDTH$delegate", "currentRect", "Landroid/graphics/Rect;", "isInit", "", "mBoxPaint", "Landroid/graphics/Paint;", "mBoxRect", "mCornerPaint", "mGirdLinePaint", "mGirdLinePath", "Landroid/graphics/Path;", "tmpRect", "drawCorner", "", "canvas", "Landroid/graphics/Canvas;", "drawCutBoxLine", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "onDraw", "onSizeChanged", "w", "h", "oldw", "oldh", "setBorderRect", "rect", "updateBorderRect", "libmmui_release"})
public final class BorderView extends View {
    private final f BYE = g.ah(new b(this));
    private final f BYF = g.ah(new a(this));
    private final f BYG = g.ah(new e(this));
    private final f BYI = g.ah(new c(this));
    private final f BYJ = g.ah(new d(this));
    private Rect QLX;
    private Rect dgS = new Rect();
    private final Path hnX = new Path();
    private final Paint hnZ = new Paint();
    private final Paint hoc = new Paint();
    private final Paint hod = new Paint();
    private boolean isInit;
    private Rect mC = new Rect();

    private final float getBOX_GIRD_WIDTH() {
        AppMethodBeat.i(164371);
        float floatValue = ((Number) this.BYF.getValue()).floatValue();
        AppMethodBeat.o(164371);
        return floatValue;
    }

    private final float getBOX_LINE_WIDTH() {
        AppMethodBeat.i(164370);
        float floatValue = ((Number) this.BYE.getValue()).floatValue();
        AppMethodBeat.o(164370);
        return floatValue;
    }

    private final float getBOX_PADDING() {
        AppMethodBeat.i(164373);
        float floatValue = ((Number) this.BYI.getValue()).floatValue();
        AppMethodBeat.o(164373);
        return floatValue;
    }

    private final float getCORNER_LENGTH() {
        AppMethodBeat.i(164374);
        float floatValue = ((Number) this.BYJ.getValue()).floatValue();
        AppMethodBeat.o(164374);
        return floatValue;
    }

    private final float getCORNER_WIDTH() {
        AppMethodBeat.i(164372);
        float floatValue = ((Number) this.BYG.getValue()).floatValue();
        AppMethodBeat.o(164372);
        return floatValue;
    }

    public BorderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(164378);
        AppMethodBeat.o(164378);
    }

    public BorderView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(164379);
        AppMethodBeat.o(164379);
    }

    /* access modifiers changed from: protected */
    public final void onSizeChanged(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(164375);
        super.onSizeChanged(i2, i3, i4, i5);
        if (!this.isInit) {
            this.isInit = true;
            this.hnZ.setColor(-1);
            this.hnZ.setStrokeWidth(getBOX_LINE_WIDTH());
            this.hnZ.setStyle(Paint.Style.STROKE);
            this.hnZ.setAntiAlias(true);
            this.hoc.set(this.hnZ);
            this.hoc.setStrokeWidth(getBOX_GIRD_WIDTH());
            this.hod.set(this.hnZ);
            this.hod.setStrokeWidth(getCORNER_WIDTH());
        }
        AppMethodBeat.o(164375);
    }

    public final void setBorderRect(Rect rect) {
        AppMethodBeat.i(164376);
        p.h(rect, "rect");
        this.QLX = rect;
        AppMethodBeat.o(164376);
    }

    /* access modifiers changed from: protected */
    public final void onDraw(Canvas canvas) {
        AppMethodBeat.i(164377);
        p.h(canvas, "canvas");
        super.onDraw(canvas);
        Rect rect = this.QLX;
        if (rect == null) {
            p.btv("currentRect");
        }
        if (!rect.equals(this.mC)) {
            Rect rect2 = this.mC;
            Rect rect3 = this.QLX;
            if (rect3 == null) {
                p.btv("currentRect");
            }
            rect2.set(rect3);
            Rect rect4 = this.dgS;
            Rect rect5 = this.QLX;
            if (rect5 == null) {
                p.btv("currentRect");
            }
            int box_padding = rect5.left + ((int) getBOX_PADDING());
            Rect rect6 = this.QLX;
            if (rect6 == null) {
                p.btv("currentRect");
            }
            int box_padding2 = rect6.top + ((int) getBOX_PADDING());
            Rect rect7 = this.QLX;
            if (rect7 == null) {
                p.btv("currentRect");
            }
            int box_padding3 = rect7.right - ((int) getBOX_PADDING());
            Rect rect8 = this.QLX;
            if (rect8 == null) {
                p.btv("currentRect");
            }
            rect4.set(box_padding, box_padding2, box_padding3, rect8.bottom - ((int) getBOX_PADDING()));
            this.hnX.reset();
            for (int i2 = 1; i2 <= 2; i2++) {
                this.hnX.moveTo((float) (this.dgS.left + ((this.dgS.width() / 3) * i2)), (float) this.dgS.top);
                this.hnX.lineTo((float) (this.dgS.left + ((this.dgS.width() / 3) * i2)), (float) this.dgS.bottom);
                this.hnX.moveTo((float) this.dgS.left, (float) (this.dgS.top + ((this.dgS.height() / 3) * i2)));
                this.hnX.lineTo((float) this.dgS.right, (float) (this.dgS.top + ((this.dgS.height() / 3) * i2)));
            }
        }
        canvas.drawPath(this.hnX, this.hoc);
        canvas.drawRect(this.dgS, this.hnZ);
        canvas.drawLine(((float) this.dgS.left) - getCORNER_WIDTH(), ((float) this.dgS.top) - (getCORNER_WIDTH() / 2.0f), getCORNER_LENGTH() + ((float) this.dgS.left), ((float) this.dgS.top) - (getCORNER_WIDTH() / 2.0f), this.hod);
        canvas.drawLine((getCORNER_WIDTH() / 2.0f) + (((float) this.dgS.right) - getCORNER_LENGTH()), ((float) this.dgS.top) - (getCORNER_WIDTH() / 2.0f), getCORNER_WIDTH() + ((float) this.dgS.right), ((float) this.dgS.top) - (getCORNER_WIDTH() / 2.0f), this.hod);
        canvas.drawLine(((float) this.dgS.left) - (getCORNER_WIDTH() / 2.0f), ((float) this.dgS.top) - (getCORNER_WIDTH() / 2.0f), ((float) this.dgS.left) - (getCORNER_WIDTH() / 2.0f), getCORNER_LENGTH() + ((float) this.dgS.top), this.hod);
        canvas.drawLine(((float) this.dgS.left) - (getCORNER_WIDTH() / 2.0f), (getCORNER_WIDTH() / 2.0f) + (((float) this.dgS.bottom) - getCORNER_LENGTH()), ((float) this.dgS.left) - (getCORNER_WIDTH() / 2.0f), (getCORNER_WIDTH() / 2.0f) + ((float) this.dgS.bottom), this.hod);
        canvas.drawLine((getCORNER_WIDTH() / 2.0f) + ((float) this.dgS.right), (float) this.dgS.top, (getCORNER_WIDTH() / 2.0f) + ((float) this.dgS.right), getCORNER_LENGTH() + ((float) this.dgS.top), this.hod);
        canvas.drawLine((getCORNER_WIDTH() / 2.0f) + ((float) this.dgS.right), (getCORNER_WIDTH() / 2.0f) + (((float) this.dgS.bottom) - getCORNER_LENGTH()), (getCORNER_WIDTH() / 2.0f) + ((float) this.dgS.right), (getCORNER_WIDTH() / 2.0f) + ((float) this.dgS.bottom), this.hod);
        canvas.drawLine(((float) this.dgS.left) - getCORNER_WIDTH(), (getCORNER_WIDTH() / 2.0f) + ((float) this.dgS.bottom), getCORNER_LENGTH() + ((float) this.dgS.left), (getCORNER_WIDTH() / 2.0f) + ((float) this.dgS.bottom), this.hod);
        canvas.drawLine(((float) this.dgS.right) - getCORNER_LENGTH(), (getCORNER_WIDTH() / 2.0f) + ((float) this.dgS.bottom), getCORNER_WIDTH() + ((float) this.dgS.right), (getCORNER_WIDTH() / 2.0f) + ((float) this.dgS.bottom), this.hod);
        AppMethodBeat.o(164377);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends q implements kotlin.g.a.a<Float> {
        final /* synthetic */ BorderView QLY;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(BorderView borderView) {
            super(0);
            this.QLY = borderView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Float invoke() {
            AppMethodBeat.i(164365);
            Context context = this.QLY.getContext();
            p.g(context, "context");
            Float valueOf = Float.valueOf(context.getResources().getDimension(R.dimen.ts));
            AppMethodBeat.o(164365);
            return valueOf;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class a extends q implements kotlin.g.a.a<Float> {
        final /* synthetic */ BorderView QLY;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(BorderView borderView) {
            super(0);
            this.QLY = borderView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Float invoke() {
            AppMethodBeat.i(164364);
            Context context = this.QLY.getContext();
            p.g(context, "context");
            Float valueOf = Float.valueOf(context.getResources().getDimension(R.dimen.tr));
            AppMethodBeat.o(164364);
            return valueOf;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class e extends q implements kotlin.g.a.a<Float> {
        final /* synthetic */ BorderView QLY;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(BorderView borderView) {
            super(0);
            this.QLY = borderView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Float invoke() {
            AppMethodBeat.i(164368);
            Context context = this.QLY.getContext();
            p.g(context, "context");
            Float valueOf = Float.valueOf(context.getResources().getDimension(R.dimen.tq));
            AppMethodBeat.o(164368);
            return valueOf;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class c extends q implements kotlin.g.a.a<Float> {
        final /* synthetic */ BorderView QLY;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(BorderView borderView) {
            super(0);
            this.QLY = borderView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Float invoke() {
            AppMethodBeat.i(164366);
            Context context = this.QLY.getContext();
            p.g(context, "context");
            Float valueOf = Float.valueOf(context.getResources().getDimension(R.dimen.tt));
            AppMethodBeat.o(164366);
            return valueOf;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class d extends q implements kotlin.g.a.a<Float> {
        final /* synthetic */ BorderView QLY;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(BorderView borderView) {
            super(0);
            this.QLY = borderView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Float invoke() {
            AppMethodBeat.i(164367);
            Context context = this.QLY.getContext();
            p.g(context, "context");
            Float valueOf = Float.valueOf(context.getResources().getDimension(R.dimen.tp));
            AppMethodBeat.o(164367);
            return valueOf;
        }
    }
}
