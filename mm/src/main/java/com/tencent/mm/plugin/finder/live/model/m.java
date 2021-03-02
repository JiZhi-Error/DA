package com.tencent.mm.plugin.finder.live.model;

import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.style.ImageSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.model.n;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006JR\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001aH\u0016R\u0014\u0010\u0007\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveRoundImageSpan;", "Landroid/text/style/ImageSpan;", "drawable", "Landroid/graphics/drawable/Drawable;", "config", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveRoundImageSpanConfig;", "(Landroid/graphics/drawable/Drawable;Lcom/tencent/mm/plugin/finder/live/model/FinderLiveRoundImageSpanConfig;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "draw", "", "canvas", "Landroid/graphics/Canvas;", "text", "", "start", "", "end", "x", "", "top", "y", "bottom", "paint", "Landroid/graphics/Paint;", "Companion", "plugin-finder_release"})
public final class m extends ImageSpan {
    public static final a ujk = new a((byte) 0);
    private final String TAG = "FinderLiveRoundImageSpan";
    private final n uiH;

    static {
        AppMethodBeat.i(246181);
        AppMethodBeat.o(246181);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public m(Drawable drawable, n nVar) {
        super(drawable);
        p.h(drawable, "drawable");
        p.h(nVar, "config");
        AppMethodBeat.i(246180);
        this.uiH = nVar;
        AppMethodBeat.o(246180);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveRoundImageSpan$Companion;", "", "()V", "generateDrawable", "Landroid/graphics/drawable/Drawable;", "spanStr", "", "textSize", "", "textPading", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static /* synthetic */ Drawable atF(String str) {
            AppMethodBeat.i(246178);
            n.a aVar = n.ujr;
            n.a aVar2 = n.ujr;
            Drawable b2 = b(str, (float) n.dfR(), n.dfS());
            AppMethodBeat.o(246178);
            return b2;
        }

        private static Drawable b(String str, float f2, float f3) {
            AppMethodBeat.i(260472);
            p.h(str, "spanStr");
            Paint paint = new Paint();
            paint.setTextSize(f2);
            float measureText = paint.measureText(str, 0, str.length()) + (2.0f * f3) + f3;
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setBounds(0, 0, (int) measureText, 1);
            GradientDrawable gradientDrawable2 = gradientDrawable;
            AppMethodBeat.o(260472);
            return gradientDrawable2;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0058, code lost:
        if (r2 == com.tencent.mm.plugin.finder.live.model.n.dfT()) goto L_0x005a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void draw(android.graphics.Canvas r11, java.lang.CharSequence r12, int r13, int r14, float r15, int r16, int r17, int r18, android.graphics.Paint r19) {
        /*
        // Method dump skipped, instructions count: 243
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.live.model.m.draw(android.graphics.Canvas, java.lang.CharSequence, int, int, float, int, int, int, android.graphics.Paint):void");
    }
}
