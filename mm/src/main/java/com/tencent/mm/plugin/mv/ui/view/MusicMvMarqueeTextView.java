package com.tencent.mm.plugin.mv.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001a\u0018\u0000 ;2\u00020\u0001:\u0006;<=>?@B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020!H\u0016J\b\u0010#\u001a\u00020\u0017H\u0014J\b\u0010$\u001a\u00020\u0017H\u0014J\u0010\u0010%\u001a\u00020!2\u0006\u0010&\u001a\u00020'H\u0014J\u0018\u0010(\u001a\u00020!2\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0007H\u0014J(\u0010+\u001a\u00020!2\u0006\u0010,\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u0007H\u0014J \u00100\u001a\u00020!2\b\u00101\u001a\u0004\u0018\u00010\u00192\u0006\u00102\u001a\u00020\u00172\u0006\u00103\u001a\u00020\u0007J\u0006\u00104\u001a\u00020!J\u0010\u00105\u001a\u00020!2\b\u00106\u001a\u0004\u0018\u00010\u0019J\u000e\u00107\u001a\u00020!2\u0006\u00108\u001a\u00020\u0010J\u000e\u00109\u001a\u00020!2\u0006\u00103\u001a\u00020\u0007J\u000e\u0010:\u001a\u00020!2\u0006\u00102\u001a\u00020\u0017R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001c\u001a\u00020\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006A"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvMarqueeTextView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "effect", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvMarqueeTextView$ScrollEffect;", "getEffect", "()Lcom/tencent/mm/plugin/mv/ui/view/MusicMvMarqueeTextView$ScrollEffect;", "setEffect", "(Lcom/tencent/mm/plugin/mv/ui/view/MusicMvMarqueeTextView$ScrollEffect;)V", "needScroll", "", "paint", "Landroid/graphics/Paint;", "scroller", "Landroid/widget/Scroller;", "scrolling", "spaceWidth", "", "textContent", "", "textHeight", "textWidth", "viewProvider", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvMarqueeTextView$ViewProvider;", "getViewProvider", "()Lcom/tencent/mm/plugin/mv/ui/view/MusicMvMarqueeTextView$ViewProvider;", "checkScroll", "", "computeScroll", "getLeftFadingEdgeStrength", "getRightFadingEdgeStrength", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onSizeChanged", "w", "h", "oldw", "oldh", "setContent", "content", "textSize", "textColor", "setShadow", "setText", "text", "setTextBold", "bold", "setTextColor", "setTextSize", "Companion", "NoEffect", "ScrollEffect", "ScrollReverseEffect", "ScrollToNextEffect", "ViewProvider", "plugin-mv_release"})
public final class MusicMvMarqueeTextView extends View {
    public static final a Ayv = new a((byte) 0);
    private String Ayp;
    private float Ayq;
    private float Ayr;
    private final Scroller Ays;
    private final e Ayt;
    private b Ayu;
    private float jq;
    private boolean ons;
    public final Paint paint;
    private boolean scrolling;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\b\u001a\u00020\u0006H&¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvMarqueeTextView$ScrollEffect;", "", "isAtEnd", "", "isAtStart", "onDraw", "", "start", "stop", "plugin-mv_release"})
    public interface b {
        boolean ewv();

        boolean eww();

        void onDraw();

        void start();

        void stop();
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\u0003H&¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvMarqueeTextView$ViewProvider;", "", "getContentWidth", "", "getScroller", "Landroid/widget/Scroller;", "getSpaceWidth", "getView", "Landroid/view/View;", "getWidth", "plugin-mv_release"})
    public interface e {
        float ewx();

        float ewy();

        Scroller ewz();

        View getView();

        float getWidth();
    }

    static {
        AppMethodBeat.i(257610);
        AppMethodBeat.o(257610);
    }

    public MusicMvMarqueeTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, (byte) 0);
    }

    private /* synthetic */ MusicMvMarqueeTextView(Context context, AttributeSet attributeSet, byte b2) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MusicMvMarqueeTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(257609);
        this.paint = new Paint(1);
        this.Ayp = "";
        this.Ays = new Scroller(context, new LinearInterpolator());
        this.scrolling = true;
        this.Ayt = new f(this);
        this.Ayu = new d(this.Ayt);
        this.Ayr = ((float) com.tencent.mm.cb.a.fromDPToPix(context, 8)) * 4.0f;
        AppMethodBeat.o(257609);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvMarqueeTextView$Companion;", "", "()V", "LOOP_WAIT_INTERVAL", "", "ScrollNone", "", "ScrollReverse", "ScrollToNext", "TAG", "", "plugin-mv_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016¨\u0006\n"}, hxF = {"com/tencent/mm/plugin/mv/ui/view/MusicMvMarqueeTextView$viewProvider$1", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvMarqueeTextView$ViewProvider;", "getContentWidth", "", "getScroller", "Landroid/widget/Scroller;", "getSpaceWidth", "getView", "Landroid/view/View;", "getWidth", "plugin-mv_release"})
    public static final class f implements e {
        final /* synthetic */ MusicMvMarqueeTextView AyE;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        f(MusicMvMarqueeTextView musicMvMarqueeTextView) {
            this.AyE = musicMvMarqueeTextView;
        }

        @Override // com.tencent.mm.plugin.mv.ui.view.MusicMvMarqueeTextView.e
        public final View getView() {
            return this.AyE;
        }

        @Override // com.tencent.mm.plugin.mv.ui.view.MusicMvMarqueeTextView.e
        public final float getWidth() {
            AppMethodBeat.i(257592);
            float width = (float) this.AyE.getWidth();
            AppMethodBeat.o(257592);
            return width;
        }

        @Override // com.tencent.mm.plugin.mv.ui.view.MusicMvMarqueeTextView.e
        public final float ewx() {
            AppMethodBeat.i(257593);
            float f2 = this.AyE.jq;
            AppMethodBeat.o(257593);
            return f2;
        }

        @Override // com.tencent.mm.plugin.mv.ui.view.MusicMvMarqueeTextView.e
        public final float ewy() {
            AppMethodBeat.i(257594);
            float f2 = this.AyE.Ayr;
            AppMethodBeat.o(257594);
            return f2;
        }

        @Override // com.tencent.mm.plugin.mv.ui.view.MusicMvMarqueeTextView.e
        public final Scroller ewz() {
            AppMethodBeat.i(257595);
            Scroller scroller = this.AyE.Ays;
            AppMethodBeat.o(257595);
            return scroller;
        }
    }

    public final e getViewProvider() {
        return this.Ayt;
    }

    public final b getEffect() {
        return this.Ayu;
    }

    public final void setEffect(b bVar) {
        AppMethodBeat.i(257596);
        p.h(bVar, "<set-?>");
        this.Ayu = bVar;
        AppMethodBeat.o(257596);
    }

    public final void setText(String str) {
        AppMethodBeat.i(257597);
        if (!p.j(this.Ayp, str)) {
            if (str == null) {
                str = "";
            }
            this.Ayp = str;
            this.jq = this.paint.measureText(this.Ayp);
            this.Ayq = this.paint.getFontMetrics().bottom - this.paint.getFontMetrics().top;
            this.Ayu.stop();
            scrollTo(0, 0);
            ewu();
        }
        AppMethodBeat.o(257597);
    }

    public final void setTextSize(float f2) {
        AppMethodBeat.i(257598);
        if (this.paint.getTextSize() != f2) {
            this.paint.setTextSize(f2);
            this.jq = this.paint.measureText(this.Ayp);
            this.Ayq = this.paint.getFontMetrics().bottom - this.paint.getFontMetrics().top;
            ewu();
        }
        AppMethodBeat.o(257598);
    }

    public final void setTextColor(int i2) {
        AppMethodBeat.i(257599);
        if (this.paint.getColor() != i2) {
            this.paint.setColor(i2);
            invalidate();
        }
        AppMethodBeat.o(257599);
    }

    public final void setTextBold(boolean z) {
        AppMethodBeat.i(257600);
        this.paint.setFakeBoldText(z);
        AppMethodBeat.o(257600);
    }

    public final void b(String str, float f2, int i2) {
        AppMethodBeat.i(257601);
        this.paint.setTextSize(f2);
        this.paint.setColor(i2);
        if (str == null) {
            str = "";
        }
        this.Ayp = str;
        this.jq = this.paint.measureText(this.Ayp);
        this.Ayq = this.paint.getFontMetrics().bottom - this.paint.getFontMetrics().top;
        ewu();
        AppMethodBeat.o(257601);
    }

    private final void ewu() {
        AppMethodBeat.i(257602);
        if (((float) getWidth()) >= this.jq) {
            this.ons = false;
            this.Ayu.stop();
            scrollTo(0, 0);
            AppMethodBeat.o(257602);
            return;
        }
        this.ons = true;
        if (this.scrolling) {
            this.Ayu.start();
        }
        AppMethodBeat.o(257602);
    }

    /* access modifiers changed from: protected */
    public final void onMeasure(int i2, int i3) {
        AppMethodBeat.i(257603);
        int size = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i2);
        int paddingTop = ((int) this.Ayq) + getPaddingTop() + getPaddingBottom();
        if (mode == Integer.MIN_VALUE && ((float) size) >= this.jq) {
            size = (int) this.jq;
        }
        setMeasuredDimension(size, paddingTop);
        AppMethodBeat.o(257603);
    }

    /* access modifiers changed from: protected */
    public final void onSizeChanged(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(257604);
        super.onSizeChanged(i2, i3, i4, i5);
        ewu();
        AppMethodBeat.o(257604);
    }

    /* access modifiers changed from: protected */
    public final float getLeftFadingEdgeStrength() {
        AppMethodBeat.i(257605);
        if (!this.ons || this.Ayu.ewv()) {
            AppMethodBeat.o(257605);
            return 0.0f;
        }
        AppMethodBeat.o(257605);
        return 1.0f;
    }

    /* access modifiers changed from: protected */
    public final float getRightFadingEdgeStrength() {
        AppMethodBeat.i(257606);
        if (!this.ons || this.Ayu.eww()) {
            AppMethodBeat.o(257606);
            return 0.0f;
        }
        AppMethodBeat.o(257606);
        return 1.0f;
    }

    public final void computeScroll() {
        AppMethodBeat.i(257607);
        if (this.Ays.computeScrollOffset()) {
            scrollTo(this.Ays.getCurrX(), this.Ays.getCurrY());
            postInvalidate();
        }
        AppMethodBeat.o(257607);
    }

    /* access modifiers changed from: protected */
    public final void onDraw(Canvas canvas) {
        AppMethodBeat.i(257608);
        p.h(canvas, "canvas");
        int save = canvas.save();
        canvas.translate(0.0f, ((float) getPaddingTop()) - this.paint.getFontMetrics().top);
        canvas.drawText(this.Ayp, 0.0f, 0.0f, this.paint);
        if (this.ons) {
            canvas.translate(this.jq + this.Ayr, 0.0f);
            canvas.drawText(this.Ayp, 0.0f, 0.0f, this.paint);
        }
        canvas.restoreToCount(save);
        if (this.ons) {
            this.Ayu.onDraw();
        }
        AppMethodBeat.o(257608);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \"2\u00020\u0001:\u0001\"B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u001fH\u0016J\b\u0010!\u001a\u00020\u001fH\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006#"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvMarqueeTextView$ScrollToNextEffect;", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvMarqueeTextView$ScrollEffect;", "viewProvider", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvMarqueeTextView$ViewProvider;", "(Lcom/tencent/mm/plugin/mv/ui/view/MusicMvMarqueeTextView$ViewProvider;)V", "scrollInterval", "", "getScrollInterval", "()J", "setScrollInterval", "(J)V", "scrollSpeed", "", "getScrollSpeed", "()F", "setScrollSpeed", "(F)V", "startScrollTask", "Ljava/lang/Runnable;", "state", "", "getState", "()I", "setState", "(I)V", "getViewProvider", "()Lcom/tencent/mm/plugin/mv/ui/view/MusicMvMarqueeTextView$ViewProvider;", "isAtEnd", "", "isAtStart", "onDraw", "", "start", "stop", "Companion", "plugin-mv_release"})
    public static final class d implements b {
        public static final a AyC = new a((byte) 0);
        private final Runnable AyB = new b(this);
        final e Ayt;
        float Ayw = 200.0f;
        private long Ayx = 5000;
        int state;

        static {
            AppMethodBeat.i(257591);
            AppMethodBeat.o(257591);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvMarqueeTextView$ScrollToNextEffect$Companion;", "", "()V", "StateNone", "", "StateScroll", "StateWait", "plugin-mv_release"})
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(byte b2) {
                this();
            }
        }

        public d(e eVar) {
            p.h(eVar, "viewProvider");
            AppMethodBeat.i(257590);
            this.Ayt = eVar;
            AppMethodBeat.o(257590);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        static final class b implements Runnable {
            final /* synthetic */ d AyD;

            b(d dVar) {
                this.AyD = dVar;
            }

            public final void run() {
                AppMethodBeat.i(257585);
                this.AyD.state = 2;
                float ewy = this.AyD.Ayt.ewy() + this.AyD.Ayt.ewx();
                this.AyD.Ayt.ewz().startScroll(0, 0, (int) ewy, 0, (int) ((ewy / this.AyD.Ayw) * 1000.0f));
                this.AyD.Ayt.getView().postInvalidate();
                AppMethodBeat.o(257585);
            }
        }

        @Override // com.tencent.mm.plugin.mv.ui.view.MusicMvMarqueeTextView.b
        public final boolean ewv() {
            AppMethodBeat.i(257586);
            if (this.Ayt.getView().getScrollX() == 0) {
                AppMethodBeat.o(257586);
                return true;
            }
            AppMethodBeat.o(257586);
            return false;
        }

        @Override // com.tencent.mm.plugin.mv.ui.view.MusicMvMarqueeTextView.b
        public final boolean eww() {
            return false;
        }

        @Override // com.tencent.mm.plugin.mv.ui.view.MusicMvMarqueeTextView.b
        public final void start() {
            AppMethodBeat.i(257587);
            if (this.state == 0) {
                this.state = 1;
                this.Ayt.getView().removeCallbacks(this.AyB);
                this.Ayt.getView().postDelayed(this.AyB, this.Ayx);
            }
            AppMethodBeat.o(257587);
        }

        @Override // com.tencent.mm.plugin.mv.ui.view.MusicMvMarqueeTextView.b
        public final void stop() {
            AppMethodBeat.i(257588);
            this.state = 0;
            this.Ayt.getView().removeCallbacks(this.AyB);
            this.Ayt.ewz().forceFinished(true);
            this.Ayt.getView().scrollTo(0, 0);
            AppMethodBeat.o(257588);
        }

        @Override // com.tencent.mm.plugin.mv.ui.view.MusicMvMarqueeTextView.b
        public final void onDraw() {
            AppMethodBeat.i(257589);
            if (this.Ayt.ewz().isFinished()) {
                this.Ayt.getView().scrollTo(0, 0);
                if (this.state == 2) {
                    this.state = 1;
                    this.Ayt.getView().removeCallbacks(this.AyB);
                    this.Ayt.getView().postDelayed(this.AyB, this.Ayx);
                }
            }
            AppMethodBeat.o(257589);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 #2\u00020\u0001:\u0001#B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001dH\u0016J\b\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020 H\u0016J\b\u0010\"\u001a\u00020 H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006$"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvMarqueeTextView$ScrollReverseEffect;", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvMarqueeTextView$ScrollEffect;", "viewProvider", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvMarqueeTextView$ViewProvider;", "(Lcom/tencent/mm/plugin/mv/ui/view/MusicMvMarqueeTextView$ViewProvider;)V", "reverseTask", "Ljava/lang/Runnable;", "scrollInterval", "", "getScrollInterval", "()J", "setScrollInterval", "(J)V", "scrollSpeed", "", "getScrollSpeed", "()F", "setScrollSpeed", "(F)V", "scrollTask", "state", "", "getState", "()I", "setState", "(I)V", "getViewProvider", "()Lcom/tencent/mm/plugin/mv/ui/view/MusicMvMarqueeTextView$ViewProvider;", "isAtEnd", "", "isAtStart", "onDraw", "", "start", "stop", "Companion", "plugin-mv_release"})
    public static final class c implements b {
        public static final a Ayz = new a((byte) 0);
        private final Runnable Aoa = new RunnableC1559c(this);
        final e Ayt;
        float Ayw = 200.0f;
        private long Ayx = 2000;
        private final Runnable Ayy = new b(this);
        int state = 3;

        static {
            AppMethodBeat.i(257584);
            AppMethodBeat.o(257584);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvMarqueeTextView$ScrollReverseEffect$Companion;", "", "()V", "StateNone", "", "StateReverse", "StateScroll", "StateWait", "plugin-mv_release"})
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(byte b2) {
                this();
            }
        }

        public c(e eVar) {
            p.h(eVar, "viewProvider");
            AppMethodBeat.i(257583);
            this.Ayt = eVar;
            AppMethodBeat.o(257583);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.plugin.mv.ui.view.MusicMvMarqueeTextView$c$c  reason: collision with other inner class name */
        static final class RunnableC1559c implements Runnable {
            final /* synthetic */ c AyA;

            RunnableC1559c(c cVar) {
                this.AyA = cVar;
            }

            public final void run() {
                AppMethodBeat.i(257577);
                this.AyA.state = 2;
                float ewx = this.AyA.Ayt.ewx() - this.AyA.Ayt.getWidth();
                this.AyA.Ayt.ewz().startScroll(0, 0, (int) ewx, 0, (int) ((ewx / this.AyA.Ayw) * 1000.0f));
                this.AyA.Ayt.getView().postInvalidate();
                AppMethodBeat.o(257577);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        static final class b implements Runnable {
            final /* synthetic */ c AyA;

            b(c cVar) {
                this.AyA = cVar;
            }

            public final void run() {
                AppMethodBeat.i(257576);
                this.AyA.state = 3;
                float ewx = this.AyA.Ayt.ewx() - this.AyA.Ayt.getWidth();
                this.AyA.Ayt.ewz().startScroll((int) ewx, 0, -((int) ewx), 0, (int) ((ewx / this.AyA.Ayw) * 1000.0f));
                this.AyA.Ayt.getView().postInvalidate();
                AppMethodBeat.o(257576);
            }
        }

        @Override // com.tencent.mm.plugin.mv.ui.view.MusicMvMarqueeTextView.b
        public final boolean ewv() {
            AppMethodBeat.i(257578);
            if (this.Ayt.ewz().getCurrX() == 0) {
                AppMethodBeat.o(257578);
                return true;
            }
            AppMethodBeat.o(257578);
            return false;
        }

        @Override // com.tencent.mm.plugin.mv.ui.view.MusicMvMarqueeTextView.b
        public final boolean eww() {
            AppMethodBeat.i(257579);
            if (this.Ayt.ewz().getCurrX() == ((int) (this.Ayt.ewx() - this.Ayt.getWidth()))) {
                AppMethodBeat.o(257579);
                return true;
            }
            AppMethodBeat.o(257579);
            return false;
        }

        @Override // com.tencent.mm.plugin.mv.ui.view.MusicMvMarqueeTextView.b
        public final void start() {
            AppMethodBeat.i(257580);
            if (this.state != 0) {
                AppMethodBeat.o(257580);
                return;
            }
            this.Ayt.getView().removeCallbacks(this.Aoa);
            this.Ayt.getView().postDelayed(this.Aoa, this.Ayx);
            this.state = 1;
            AppMethodBeat.o(257580);
        }

        @Override // com.tencent.mm.plugin.mv.ui.view.MusicMvMarqueeTextView.b
        public final void stop() {
            AppMethodBeat.i(257581);
            this.state = 0;
            this.Ayt.getView().removeCallbacks(this.Aoa);
            this.Ayt.getView().removeCallbacks(this.Ayy);
            AppMethodBeat.o(257581);
        }

        @Override // com.tencent.mm.plugin.mv.ui.view.MusicMvMarqueeTextView.b
        public final void onDraw() {
            AppMethodBeat.i(257582);
            if (this.Ayt.ewz().isFinished()) {
                if (this.state == 2) {
                    this.Ayt.getView().removeCallbacks(this.Ayy);
                    this.Ayt.getView().postDelayed(this.Ayy, this.Ayx);
                    this.state = 1;
                    AppMethodBeat.o(257582);
                    return;
                } else if (this.state == 3) {
                    this.Ayt.getView().removeCallbacks(this.Aoa);
                    this.Ayt.getView().postDelayed(this.Aoa, this.Ayx);
                    this.state = 1;
                }
            }
            AppMethodBeat.o(257582);
        }
    }
}
