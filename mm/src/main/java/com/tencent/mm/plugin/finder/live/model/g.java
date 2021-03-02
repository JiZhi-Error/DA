package com.tencent.mm.plugin.finder.live.model;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.style.ImageSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.f;
import com.tencent.mm.plugin.finder.live.model.n;
import com.tencent.mm.plugin.finder.utils.c;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.view.d;
import kotlin.g.b.p;

public final class g extends ImageSpan {
    private static final int uiI;
    private static final int uiJ;
    public static final a uiK = new a((byte) 0);
    private final String TAG = "FinderLiveItalicImageSpan";
    private String uiF = "";
    private String uiG = "";
    private final n uiH;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(Drawable drawable, n nVar) {
        super(drawable);
        p.h(drawable, "drawable");
        p.h(nVar, "config");
        AppMethodBeat.i(246109);
        this.uiH = nVar;
        AppMethodBeat.o(246109);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static /* synthetic */ Drawable atD(String str) {
            AppMethodBeat.i(246105);
            n.a aVar = n.ujr;
            n.a aVar2 = n.ujr;
            float f2 = n.ujp;
            p.h(str, "spanStr");
            Paint paint = new Paint();
            paint.setTextSize((float) n.ujo);
            float measureText = ((float) g.uiJ) + paint.measureText(str, 0, str.length()) + (2.0f * f2) + f2;
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setBounds(0, 0, (int) measureText, 1);
            GradientDrawable gradientDrawable2 = gradientDrawable;
            AppMethodBeat.o(246105);
            return gradientDrawable2;
        }
    }

    static {
        AppMethodBeat.i(246110);
        int e2 = d.e(MMApplicationContext.getContext(), 2.0f);
        uiI = e2;
        uiJ = e2 * 2;
        AppMethodBeat.o(246110);
    }

    public final void ag(String str, String str2, String str3) {
        AppMethodBeat.i(246106);
        p.h(str, "text");
        p.h(str2, "spanStr");
        p.h(str3, "italicStr");
        this.uiH.setText(str);
        this.uiF = str2;
        this.uiG = str3;
        AppMethodBeat.o(246106);
    }

    public final void atC(String str) {
        AppMethodBeat.i(246107);
        String str2 = str;
        if (!(str2 == null || str2.length() == 0)) {
            try {
                this.uiH.bgColor = Color.parseColor(str);
                AppMethodBeat.o(246107);
                return;
            } catch (Exception e2) {
                f.a.a(c.vVc, "liveInvalidBadgeInfoColor", false, false, null, 28);
                Log.e(this.TAG, e2 + ",serverColor:" + str);
            }
        }
        AppMethodBeat.o(246107);
    }

    public final void draw(Canvas canvas, CharSequence charSequence, int i2, int i3, float f2, int i4, int i5, int i6, Paint paint) {
        int i7;
        AppMethodBeat.i(246108);
        p.h(canvas, "canvas");
        p.h(paint, "paint");
        try {
            int color = paint.getColor();
            float textSize = paint.getTextSize();
            Typeface typeface = paint.getTypeface();
            int a2 = kotlin.n.n.a(this.uiH.text, this.uiF, 0, false, 6);
            if (a2 < 0) {
                a2 = 0;
            }
            int length = this.uiF.length();
            int i8 = a2 + length;
            int length2 = this.uiH.text.length();
            if (i8 >= length2) {
                i8 = length2;
            }
            CharSequence charSequence2 = this.uiH.text;
            paint.setColor(this.uiH.bgColor);
            paint.setTextSize((float) this.uiH.textSize);
            float f3 = ((float) this.uiH.kcc) / 2.0f;
            float f4 = (((float) i6) - ((float) i4)) / 2.0f;
            canvas.drawRoundRect(new RectF(f2, f4 - f3, paint.measureText(charSequence2, a2, i8) + this.uiH.ujl + this.uiH.ujm + f2 + ((float) uiJ), f4 + f3), f3, f3, paint);
            int length3 = this.uiG.length();
            int i9 = a2 + (length - length3);
            if (i9 <= a2) {
                i9 = a2 + 1;
            }
            if (i9 >= length2) {
                i9 = length2;
            }
            CharSequence charSequence3 = this.uiH.text;
            int intValue = (charSequence3 != null ? Integer.valueOf(kotlin.n.n.a(charSequence3, this.uiG, 0, false, 6)) : null).intValue();
            int i10 = intValue + length3;
            if (i10 >= length2) {
                i7 = length2;
            } else {
                i7 = i10;
            }
            CharSequence charSequence4 = this.uiH.text;
            paint.setColor(this.uiH.textColor);
            float abs = (Math.abs(paint.ascent() + paint.descent()) / 2.0f) + ((float) ((i6 - i4) / 2)) + 1.0f;
            canvas.drawText(this.uiH.text, a2, i9, f2 + this.uiH.ujl, abs, paint);
            paint.setTypeface(Typeface.create(Typeface.DEFAULT, 2));
            canvas.drawText(this.uiH.text, intValue, i7, f2 + ((float) ((int) paint.measureText(charSequence4, a2, i9))) + this.uiH.ujl + ((float) uiI), abs, paint);
            paint.setColor(color);
            paint.setTextSize(textSize);
            paint.setTypeface(typeface);
            AppMethodBeat.o(246108);
        } catch (Exception e2) {
            f.a.a(c.vVc, "liveInvalidBadgeTag", false, false, null, 28);
            y yVar = y.vXH;
            y.a(e2, this.TAG + ".draw");
            AppMethodBeat.o(246108);
        }
    }
}
