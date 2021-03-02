package com.tencent.mm.plugin.emojicapture.ui.editor.text;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.j;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.e;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.f;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.k;
import com.tencent.mm.plugin.emojicapture.ui.editor.FontTextView;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 32\u00020\u0001:\u00013B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0012\u0010 \u001a\u00020\u000f2\b\u0010!\u001a\u0004\u0018\u00010\u001eH\u0002J\b\u0010\"\u001a\u0004\u0018\u00010\u0018J\u0006\u0010#\u001a\u00020\tJ(\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\t2\u0006\u0010'\u001a\u00020\t2\u0006\u0010(\u001a\u00020\t2\u0006\u0010)\u001a\u00020\tH\u0014J\u0006\u0010*\u001a\u00020%J\b\u0010+\u001a\u00020%H\u0002J\u0006\u0010,\u001a\u00020%J\b\u0010-\u001a\u00020%H\u0002J \u0010.\u001a\u00020%2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010/\u001a\u00020\t2\u0006\u00100\u001a\u000201J \u0010.\u001a\u00020%2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010/\u001a\u00020\t2\u0006\u00102\u001a\u00020\tR\u000e\u0010\u000b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000eX\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000eX\u000e¢\u0006\u0004\n\u0002\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u000eX\u000e¢\u0006\u0004\n\u0002\u0010\u001f¨\u00064"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/FontAnimTextView;", "Landroid/widget/ImageView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animCount", "animIndex", "bitmapArray", "", "Landroid/graphics/Bitmap;", "[Landroid/graphics/Bitmap;", "fontPaths", "", "[Ljava/lang/String;", "strokeColor", "switchRunnable", "Ljava/lang/Runnable;", "text", "", "textColor", "textDrawer", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/TextDrawer;", "typefaceIndex", "wxTypeFaces", "Landroid/graphics/Typeface;", "[Landroid/graphics/Typeface;", "createTextBitmap", "typeface", "getText", "getTextColor", "onSizeChanged", "", "w", "h", "oldw", "oldh", "pause", "refresh", "resume", "switchFont", "updateText", "color", "change", "", "stroke", "Companion", "plugin-emojicapture_release"})
public final class FontAnimTextView extends ImageView {
    public static final a rvF = new a((byte) 0);
    private c rvm;
    private String[] rvo;
    private Typeface[] rvp;
    private int rvq;
    private final Runnable rvr;
    private final int rvw;
    private int rvx;
    private final Bitmap[] rvy;
    private int strokeColor;
    private CharSequence text;
    private int textColor;

    static {
        AppMethodBeat.i(818);
        AppMethodBeat.o(818);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0082 A[LOOP:1: B:12:0x0080->B:13:0x0082, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public FontAnimTextView(android.content.Context r10, android.util.AttributeSet r11, int r12) {
        /*
        // Method dump skipped, instructions count: 175
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.emojicapture.ui.editor.text.FontAnimTextView.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public static final /* synthetic */ void a(FontAnimTextView fontAnimTextView) {
        AppMethodBeat.i(819);
        fontAnimTextView.cJQ();
        AppMethodBeat.o(819);
    }

    public FontAnimTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/FontAnimTextView$Companion;", "", "()V", "ANIM_INTERVAL", "", "TEXT_COLOR_INVALID", "", "plugin-emojicapture_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        final /* synthetic */ FontAnimTextView rvG;

        b(FontAnimTextView fontAnimTextView) {
            this.rvG = fontAnimTextView;
        }

        public final void run() {
            AppMethodBeat.i(810);
            FontAnimTextView.a(this.rvG);
            AppMethodBeat.o(810);
        }
    }

    /* access modifiers changed from: protected */
    public final void onSizeChanged(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(811);
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 != i4) {
            refresh();
        }
        AppMethodBeat.o(811);
    }

    public final void pause() {
        AppMethodBeat.i(f.CTRL_INDEX);
        removeCallbacks(this.rvr);
        AppMethodBeat.o(f.CTRL_INDEX);
    }

    public final CharSequence getText() {
        return this.text;
    }

    public final void e(CharSequence charSequence, int i2, int i3) {
        AppMethodBeat.i(e.CTRL_INDEX);
        this.text = charSequence;
        this.textColor = i2;
        this.strokeColor = i3;
        refresh();
        AppMethodBeat.o(e.CTRL_INDEX);
    }

    public final int getTextColor() {
        return this.textColor;
    }

    public final void refresh() {
        AppMethodBeat.i(k.CTRL_INDEX);
        CharSequence charSequence = this.text;
        if (charSequence != null) {
            if (charSequence.length() > 0) {
                kotlin.a.e.P(this.rvy);
                this.rvx = 0;
                this.rvq = 0;
                cJQ();
                AppMethodBeat.o(k.CTRL_INDEX);
                return;
            }
        }
        removeCallbacks(this.rvr);
        setImageBitmap(null);
        AppMethodBeat.o(k.CTRL_INDEX);
    }

    private final void cJQ() {
        AppMethodBeat.i(j.CTRL_INDEX);
        this.rvx++;
        this.rvx %= this.rvw;
        Typeface typeface = this.rvp[this.rvq];
        this.rvm.anr(this.rvo[this.rvq]);
        this.rvq++;
        this.rvq %= this.rvp.length;
        if (this.rvy[this.rvx] == null) {
            this.rvy[this.rvx] = d(typeface);
        }
        removeCallbacks(this.rvr);
        postDelayed(this.rvr, 100);
        setImageBitmap(this.rvy[this.rvx]);
        AppMethodBeat.o(j.CTRL_INDEX);
    }

    private final Bitmap d(Typeface typeface) {
        AppMethodBeat.i(816);
        FontTextView fontTextView = new FontTextView(getContext());
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        fontTextView.setMaxWidth((float) width);
        fontTextView.setTextDrawer(this.rvm);
        fontTextView.setTypeface(typeface);
        fontTextView.d(this.text, this.textColor, this.strokeColor);
        fontTextView.measure(View.MeasureSpec.makeMeasureSpec(width, Integer.MIN_VALUE), 0);
        Bitmap createBitmap = Bitmap.createBitmap(fontTextView.getMeasuredWidth(), fontTextView.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.save();
        fontTextView.draw(canvas);
        canvas.restore();
        p.g(createBitmap, "bitmap");
        AppMethodBeat.o(816);
        return createBitmap;
    }
}
