package com.tencent.mm.kiss.widget.textview;

import android.annotation.TargetApi;
import android.graphics.Typeface;
import android.os.Build;
import android.text.InputFilter;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kiss.widget.textview.a.a;
import com.tencent.mm.sdk.platformtools.Log;

public final class d {
    private static e hup = new e();
    private static final SpannableString huq = new SpannableString("");
    int breakStrategy = -1;
    public int gravity = 51;
    float huA = 0.0f;
    float huB = 1.0f;
    boolean huC = false;
    InputFilter.LengthFilter huD = null;
    CharSequence hur = null;
    CharSequence hus = null;
    int hut = 0;
    int huu = 0;
    TextPaint huv = null;
    Layout.Alignment huw = Layout.Alignment.ALIGN_NORMAL;
    TextUtils.TruncateAt hux = null;
    int huy = -1;
    TextDirectionHeuristic huz = null;
    int maxLength = -1;
    int maxLines = Integer.MAX_VALUE;
    int width = 0;

    static {
        AppMethodBeat.i(141031);
        AppMethodBeat.o(141031);
    }

    public static d a(CharSequence charSequence, int i2, a aVar) {
        int i3;
        Typeface create;
        int i4;
        float f2;
        int i5;
        int i6;
        boolean z = false;
        AppMethodBeat.i(141027);
        if (charSequence == null) {
            charSequence = "";
        }
        int length = charSequence.length();
        if (charSequence == null) {
            charSequence = "";
        }
        d aBk = aBk();
        aBk.hur = charSequence.toString();
        aBk.hus = charSequence;
        aBk.hut = 0;
        aBk.huu = length;
        aBk.width = i2;
        aBk.huv = new TextPaint();
        if (aVar.maxLines != -1) {
            aBk.qi(aVar.maxLines);
        }
        if (aVar.maxLength != -1 && (i6 = aVar.maxLength) >= 0) {
            aBk.maxLength = i6;
            aBk.huD = new InputFilter.LengthFilter(aBk.maxLength);
        }
        Layout.Alignment alignment = aVar.huw;
        if (alignment != null) {
            aBk.huw = alignment;
        }
        if (aVar.hux != null) {
            aBk.a(aVar.hux);
        }
        aBk.gravity = aVar.gravity;
        if (aVar.huY != -1 && (i5 = aVar.huY) >= 0) {
            aBk.huy = i5;
        }
        if (aVar.huz != null) {
            TextDirectionHeuristic textDirectionHeuristic = aVar.huz;
            if (Build.VERSION.SDK_INT >= 18) {
                aBk.huz = textDirectionHeuristic;
            }
        }
        float f3 = aVar.huA;
        float f4 = aVar.huB;
        aBk.huA = f3;
        aBk.huB = f4;
        aBk.huC = aVar.huC;
        if (aVar.sB != null) {
            if (aVar.fontStyle != -1) {
                Typeface typeface = aVar.sB;
                int i7 = aVar.fontStyle;
                if (i7 > 0) {
                    if (typeface == null) {
                        create = Typeface.defaultFromStyle(i7);
                    } else {
                        create = Typeface.create(typeface, i7);
                    }
                    aBk.c(create);
                    if (create != null) {
                        i4 = create.getStyle();
                    } else {
                        i4 = 0;
                    }
                    int i8 = (i4 ^ -1) & i7;
                    TextPaint textPaint = aBk.huv;
                    if ((i8 & 1) != 0) {
                        z = true;
                    }
                    textPaint.setFakeBoldText(z);
                    TextPaint textPaint2 = aBk.huv;
                    if ((i8 & 2) != 0) {
                        f2 = -0.25f;
                    } else {
                        f2 = 0.0f;
                    }
                    textPaint2.setTextSkewX(f2);
                } else {
                    aBk.huv.setFakeBoldText(false);
                    aBk.huv.setTextSkewX(0.0f);
                    aBk.c(typeface);
                }
            } else {
                aBk.c(aVar.sB);
            }
        }
        if (aVar.textSize != -1.0f) {
            aBk.huv.setTextSize(aVar.textSize);
        }
        if (aVar.textColor != -1) {
            aBk.huv.setColor(aVar.textColor);
        }
        if (aVar.linkColor != -1) {
            aBk.huv.linkColor = aVar.linkColor;
        }
        if (aVar.iW != null) {
            aBk.huv = aVar.iW;
        }
        if (aVar.breakStrategy >= 0 && (i3 = aVar.breakStrategy) >= 0) {
            aBk.breakStrategy = i3;
        }
        AppMethodBeat.o(141027);
        return aBk;
    }

    public static d a(CharSequence charSequence, TextPaint textPaint, int i2) {
        AppMethodBeat.i(196220);
        d aBk = aBk();
        aBk.hus = charSequence;
        aBk.hut = 0;
        aBk.huu = charSequence.length();
        aBk.huv = textPaint;
        aBk.width = i2;
        AppMethodBeat.o(196220);
        return aBk;
    }

    private static d aBk() {
        AppMethodBeat.i(196221);
        d aBm = hup.aBm();
        if (aBm == null) {
            aBm = new d();
        }
        AppMethodBeat.o(196221);
        return aBm;
    }

    public final d C(CharSequence charSequence) {
        AppMethodBeat.i(196222);
        if (charSequence == null) {
            AppMethodBeat.o(196222);
        } else {
            this.hus = charSequence;
            this.hut = 0;
            this.huu = charSequence.length();
            AppMethodBeat.o(196222);
        }
        return this;
    }

    public final d a(TextUtils.TruncateAt truncateAt) {
        if (truncateAt != null) {
            this.hux = truncateAt;
        }
        return this;
    }

    public final d qi(int i2) {
        if (i2 >= 0) {
            this.maxLines = i2;
        }
        return this;
    }

    private d c(Typeface typeface) {
        AppMethodBeat.i(141028);
        this.huv.setTypeface(typeface);
        AppMethodBeat.o(141028);
        return this;
    }

    @TargetApi(18)
    public final f aBl() {
        int i2;
        boolean z;
        StaticLayout staticLayout;
        int i3;
        CharSequence filter;
        AppMethodBeat.i(141029);
        if (this.hux == null || this.huy <= 0) {
            i2 = this.width;
        } else {
            i2 = this.huy;
        }
        if (this.hux == null && this.maxLines == 1) {
            this.hux = TextUtils.TruncateAt.END;
        }
        if (!(this.maxLength <= 0 || this.huD == null || (filter = this.huD.filter(this.hus, 0, this.hus.length(), huq, 0, 0)) == null)) {
            this.hus = filter;
            if (this.huu > this.hus.length()) {
                this.huu = this.hus.length();
            }
        }
        if (h.DEBUG) {
            Log.i("StaticTextView.StaticLayoutBuilder", "StaticLayoutWrapper build " + ((Object) this.hus) + " " + this.width);
        }
        if (this.huw == Layout.Alignment.ALIGN_NORMAL) {
            switch (this.gravity & 8388615) {
                case 1:
                    this.huw = Layout.Alignment.ALIGN_CENTER;
                    break;
                case 3:
                case 8388611:
                    this.huw = Layout.Alignment.ALIGN_NORMAL;
                    break;
                case 5:
                case 8388613:
                    this.huw = Layout.Alignment.ALIGN_OPPOSITE;
                    break;
                default:
                    this.huw = Layout.Alignment.ALIGN_NORMAL;
                    break;
            }
        }
        this.huv.setAntiAlias(true);
        if ((this.huz == null || (com.tencent.mm.compatible.util.d.oD(18) && this.huz == TextDirectionHeuristics.FIRSTSTRONG_LTR)) && (this.maxLines == Integer.MAX_VALUE || this.maxLines == -1)) {
            z = true;
        } else {
            z = false;
        }
        try {
            staticLayout = a(this.hus, z, i2, this.breakStrategy);
        } catch (Exception e2) {
            Log.i("StaticTextView.StaticLayoutBuilder", "build static layout error: %s", e2.getMessage());
            while (true) {
                if (0 < 3) {
                    try {
                        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.hus);
                        MetricAffectingSpan[] metricAffectingSpanArr = (MetricAffectingSpan[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), MetricAffectingSpan.class);
                        if (metricAffectingSpanArr == null || metricAffectingSpanArr.length <= 0) {
                            i3 = 100;
                        } else {
                            spannableStringBuilder.insert(spannableStringBuilder.getSpanStart(metricAffectingSpanArr[0]) - 1, (CharSequence) " ");
                            i3 = 0 + 1;
                        }
                        this.hus = spannableStringBuilder;
                        StaticLayout a2 = a(this.hus, z, i2, this.breakStrategy);
                        Log.i("StaticTextView.StaticLayoutBuilder", "fix from build static layout, fixCount: %s", Integer.valueOf(i3));
                        staticLayout = a2;
                    } catch (Exception e3) {
                        Log.i("StaticTextView.StaticLayoutBuilder", "fix, build static layout error: %s, fixCount: %s", e3.getMessage(), 0);
                    }
                } else {
                    staticLayout = null;
                }
            }
        }
        if (staticLayout == null) {
            this.hus = this.hus.toString();
            staticLayout = a(this.hus, z, i2, this.breakStrategy);
        }
        f fVar = new f(staticLayout);
        fVar.huG = this.hur;
        fVar.text = this.hus;
        fVar.maxLength = this.maxLength;
        fVar.maxLines = this.maxLines;
        fVar.huw = this.huw;
        fVar.hux = this.hux;
        fVar.iW = this.huv;
        fVar.gravity = this.gravity;
        fVar.breakStrategy = this.breakStrategy;
        hup.a(this);
        AppMethodBeat.o(141029);
        return fVar;
    }

    private StaticLayout a(CharSequence charSequence, boolean z, int i2, int i3) {
        StaticLayout a2;
        AppMethodBeat.i(196223);
        if (i3 >= 0) {
            a2 = StaticLayout.Builder.obtain(charSequence, this.hut, this.huu, this.huv, this.width).setAlignment(this.huw).setTextDirection(TextDirectionHeuristics.FIRSTSTRONG_LTR).setLineSpacing(this.huA, this.huB).setIncludePad(this.huC).setEllipsize(this.hux).setEllipsizedWidth(i2).setBreakStrategy(i3).setMaxLines(Integer.MAX_VALUE).build();
        } else if (z) {
            a2 = new StaticLayout(charSequence, this.hut, this.huu, this.huv, this.width, this.huw, this.huB, this.huA, this.huC, this.hux, i2);
        } else if (Build.VERSION.SDK_INT >= 18) {
            if (this.huz == null) {
                this.huz = TextDirectionHeuristics.FIRSTSTRONG_LTR;
            }
            a2 = com.tencent.mm.kiss.widget.textview.b.a.b(charSequence, this.hut, this.huu, this.huv, this.width, this.huw, this.huz, this.huB, this.huA, this.huC, this.hux, i2, this.maxLines);
        } else {
            a2 = com.tencent.mm.kiss.widget.textview.b.a.a(charSequence, this.hut, this.huu, this.huv, this.width, this.huw, this.huB, this.huA, this.huC, this.hux, i2, this.maxLines);
        }
        AppMethodBeat.o(196223);
        return a2;
    }
}
