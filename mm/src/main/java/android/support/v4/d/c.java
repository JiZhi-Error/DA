package android.support.v4.d;

import android.os.Build;
import android.support.v4.e.j;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
import java.util.concurrent.Executor;

public final class c implements Spannable {
    private static Executor Oh = null;
    private static final Object sLock = new Object();
    public final Spannable Oi;
    public final a Oj;
    private final PrecomputedText Ok;

    public static final class a {
        public final TextPaint Ol;
        public final TextDirectionHeuristic Om;
        public final int On;
        public final int Oo;
        final PrecomputedText.Params Op;

        /* renamed from: android.support.v4.d.c$a$a  reason: collision with other inner class name */
        public static class C0023a {
            public final TextPaint Ol;
            public TextDirectionHeuristic Om;
            public int On;
            public int Oo;

            public C0023a(TextPaint textPaint) {
                this.Ol = textPaint;
                if (Build.VERSION.SDK_INT >= 23) {
                    this.On = 1;
                    this.Oo = 1;
                } else {
                    this.Oo = 0;
                    this.On = 0;
                }
                if (Build.VERSION.SDK_INT >= 18) {
                    this.Om = TextDirectionHeuristics.FIRSTSTRONG_LTR;
                } else {
                    this.Om = null;
                }
            }
        }

        public a(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, int i2, int i3) {
            if (Build.VERSION.SDK_INT >= 28) {
                this.Op = new PrecomputedText.Params.Builder(textPaint).setBreakStrategy(i2).setHyphenationFrequency(i3).setTextDirection(textDirectionHeuristic).build();
            } else {
                this.Op = null;
            }
            this.Ol = textPaint;
            this.Om = textDirectionHeuristic;
            this.On = i2;
            this.Oo = i3;
        }

        public a(PrecomputedText.Params params) {
            this.Ol = params.getTextPaint();
            this.Om = params.getTextDirection();
            this.On = params.getBreakStrategy();
            this.Oo = params.getHyphenationFrequency();
            this.Op = params;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.Op != null) {
                return this.Op.equals(aVar.Op);
            }
            if (Build.VERSION.SDK_INT >= 23) {
                if (this.On != aVar.On) {
                    return false;
                }
                if (this.Oo != aVar.Oo) {
                    return false;
                }
            }
            if (Build.VERSION.SDK_INT >= 18 && this.Om != aVar.Om) {
                return false;
            }
            if (this.Ol.getTextSize() != aVar.Ol.getTextSize()) {
                return false;
            }
            if (this.Ol.getTextScaleX() != aVar.Ol.getTextScaleX()) {
                return false;
            }
            if (this.Ol.getTextSkewX() != aVar.Ol.getTextSkewX()) {
                return false;
            }
            if (Build.VERSION.SDK_INT >= 21) {
                if (this.Ol.getLetterSpacing() != aVar.Ol.getLetterSpacing()) {
                    return false;
                }
                if (!TextUtils.equals(this.Ol.getFontFeatureSettings(), aVar.Ol.getFontFeatureSettings())) {
                    return false;
                }
            }
            if (this.Ol.getFlags() != aVar.Ol.getFlags()) {
                return false;
            }
            if (Build.VERSION.SDK_INT >= 24) {
                if (!this.Ol.getTextLocales().equals(aVar.Ol.getTextLocales())) {
                    return false;
                }
            } else if (Build.VERSION.SDK_INT >= 17 && !this.Ol.getTextLocale().equals(aVar.Ol.getTextLocale())) {
                return false;
            }
            return this.Ol.getTypeface() == null ? aVar.Ol.getTypeface() == null : this.Ol.getTypeface().equals(aVar.Ol.getTypeface());
        }

        public final int hashCode() {
            if (Build.VERSION.SDK_INT >= 24) {
                return j.hash(Float.valueOf(this.Ol.getTextSize()), Float.valueOf(this.Ol.getTextScaleX()), Float.valueOf(this.Ol.getTextSkewX()), Float.valueOf(this.Ol.getLetterSpacing()), Integer.valueOf(this.Ol.getFlags()), this.Ol.getTextLocales(), this.Ol.getTypeface(), Boolean.valueOf(this.Ol.isElegantTextHeight()), this.Om, Integer.valueOf(this.On), Integer.valueOf(this.Oo));
            } else if (Build.VERSION.SDK_INT >= 21) {
                return j.hash(Float.valueOf(this.Ol.getTextSize()), Float.valueOf(this.Ol.getTextScaleX()), Float.valueOf(this.Ol.getTextSkewX()), Float.valueOf(this.Ol.getLetterSpacing()), Integer.valueOf(this.Ol.getFlags()), this.Ol.getTextLocale(), this.Ol.getTypeface(), Boolean.valueOf(this.Ol.isElegantTextHeight()), this.Om, Integer.valueOf(this.On), Integer.valueOf(this.Oo));
            } else if (Build.VERSION.SDK_INT >= 18) {
                return j.hash(Float.valueOf(this.Ol.getTextSize()), Float.valueOf(this.Ol.getTextScaleX()), Float.valueOf(this.Ol.getTextSkewX()), Integer.valueOf(this.Ol.getFlags()), this.Ol.getTextLocale(), this.Ol.getTypeface(), this.Om, Integer.valueOf(this.On), Integer.valueOf(this.Oo));
            } else if (Build.VERSION.SDK_INT >= 17) {
                return j.hash(Float.valueOf(this.Ol.getTextSize()), Float.valueOf(this.Ol.getTextScaleX()), Float.valueOf(this.Ol.getTextSkewX()), Integer.valueOf(this.Ol.getFlags()), this.Ol.getTextLocale(), this.Ol.getTypeface(), this.Om, Integer.valueOf(this.On), Integer.valueOf(this.Oo));
            } else {
                return j.hash(Float.valueOf(this.Ol.getTextSize()), Float.valueOf(this.Ol.getTextScaleX()), Float.valueOf(this.Ol.getTextSkewX()), Integer.valueOf(this.Ol.getFlags()), this.Ol.getTypeface(), this.Om, Integer.valueOf(this.On), Integer.valueOf(this.Oo));
            }
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("{");
            sb.append("textSize=" + this.Ol.getTextSize());
            sb.append(", textScaleX=" + this.Ol.getTextScaleX());
            sb.append(", textSkewX=" + this.Ol.getTextSkewX());
            if (Build.VERSION.SDK_INT >= 21) {
                sb.append(", letterSpacing=" + this.Ol.getLetterSpacing());
                sb.append(", elegantTextHeight=" + this.Ol.isElegantTextHeight());
            }
            if (Build.VERSION.SDK_INT >= 24) {
                sb.append(", textLocale=" + this.Ol.getTextLocales());
            } else if (Build.VERSION.SDK_INT >= 17) {
                sb.append(", textLocale=" + this.Ol.getTextLocale());
            }
            sb.append(", typeface=" + this.Ol.getTypeface());
            if (Build.VERSION.SDK_INT >= 26) {
                sb.append(", variationSettings=" + this.Ol.getFontVariationSettings());
            }
            sb.append(", textDir=" + this.Om);
            sb.append(", breakStrategy=" + this.On);
            sb.append(", hyphenationFrequency=" + this.Oo);
            sb.append("}");
            return sb.toString();
        }
    }

    public final void setSpan(Object obj, int i2, int i3, int i4) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
        } else if (Build.VERSION.SDK_INT >= 28) {
            this.Ok.setSpan(obj, i2, i3, i4);
        } else {
            this.Oi.setSpan(obj, i2, i3, i4);
        }
    }

    public final void removeSpan(Object obj) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
        } else if (Build.VERSION.SDK_INT >= 28) {
            this.Ok.removeSpan(obj);
        } else {
            this.Oi.removeSpan(obj);
        }
    }

    @Override // android.text.Spanned
    public final <T> T[] getSpans(int i2, int i3, Class<T> cls) {
        return Build.VERSION.SDK_INT >= 28 ? (T[]) this.Ok.getSpans(i2, i3, cls) : (T[]) this.Oi.getSpans(i2, i3, cls);
    }

    public final int getSpanStart(Object obj) {
        return this.Oi.getSpanStart(obj);
    }

    public final int getSpanEnd(Object obj) {
        return this.Oi.getSpanEnd(obj);
    }

    public final int getSpanFlags(Object obj) {
        return this.Oi.getSpanFlags(obj);
    }

    public final int nextSpanTransition(int i2, int i3, Class cls) {
        return this.Oi.nextSpanTransition(i2, i3, cls);
    }

    public final int length() {
        return this.Oi.length();
    }

    public final char charAt(int i2) {
        return this.Oi.charAt(i2);
    }

    public final CharSequence subSequence(int i2, int i3) {
        return this.Oi.subSequence(i2, i3);
    }

    public final String toString() {
        return this.Oi.toString();
    }
}
