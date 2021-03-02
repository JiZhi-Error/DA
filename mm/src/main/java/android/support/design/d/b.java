package android.support.design.d;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.design.a;
import android.support.v4.content.a.f;
import android.support.v4.e.m;
import android.text.TextPaint;
import android.util.TypedValue;
import com.tencent.smtt.sdk.WebView;

public final class b {
    public final String fontFamily;
    private final int lA;
    boolean lB = false;
    Typeface lC;
    public final ColorStateList ld;
    public final ColorStateList lu;
    public final ColorStateList lv;
    public final boolean lw;
    public final ColorStateList lx;
    public final float ly;
    public final float lz;
    public final float shadowRadius;
    public final float textSize;
    public final int textStyle;
    public final int typeface;

    public b(Context context, int i2) {
        int i3 = 11;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i2, a.C0008a.TextAppearance);
        this.textSize = obtainStyledAttributes.getDimension(0, 0.0f);
        this.ld = a.b(context, obtainStyledAttributes, 3);
        this.lu = a.b(context, obtainStyledAttributes, 4);
        this.lv = a.b(context, obtainStyledAttributes, 5);
        this.textStyle = obtainStyledAttributes.getInt(2, 0);
        this.typeface = obtainStyledAttributes.getInt(1, 1);
        i3 = !obtainStyledAttributes.hasValue(11) ? 10 : i3;
        this.lA = obtainStyledAttributes.getResourceId(i3, 0);
        this.fontFamily = obtainStyledAttributes.getString(i3);
        this.lw = obtainStyledAttributes.getBoolean(12, false);
        this.lx = a.b(context, obtainStyledAttributes, 6);
        this.ly = obtainStyledAttributes.getFloat(7, 0.0f);
        this.lz = obtainStyledAttributes.getFloat(8, 0.0f);
        this.shadowRadius = obtainStyledAttributes.getFloat(9, 0.0f);
        obtainStyledAttributes.recycle();
    }

    private Typeface I(Context context) {
        Typeface typeface2 = null;
        if (this.lB) {
            return this.lC;
        }
        if (!context.isRestricted()) {
            try {
                int i2 = this.lA;
                if (!context.isRestricted()) {
                    typeface2 = f.a(context, i2, new TypedValue(), 0, null, false);
                }
                this.lC = typeface2;
                if (this.lC != null) {
                    this.lC = Typeface.create(this.lC, this.textStyle);
                }
            } catch (Resources.NotFoundException | UnsupportedOperationException e2) {
            } catch (Exception e3) {
                new StringBuilder("Error loading font ").append(this.fontFamily);
            }
        }
        bI();
        this.lB = true;
        return this.lC;
    }

    private void a(Context context, final TextPaint textPaint, final f.a aVar) {
        if (this.lB) {
            a(textPaint, this.lC);
            return;
        }
        bI();
        if (context.isRestricted()) {
            this.lB = true;
            a(textPaint, this.lC);
            return;
        }
        try {
            int i2 = this.lA;
            AnonymousClass1 r4 = new f.a() {
                /* class android.support.design.d.b.AnonymousClass1 */

                @Override // android.support.v4.content.a.f.a
                public final void a(Typeface typeface) {
                    b.this.lC = Typeface.create(typeface, b.this.textStyle);
                    b.this.a(textPaint, typeface);
                    b.this.lB = true;
                    aVar.a(typeface);
                }

                @Override // android.support.v4.content.a.f.a
                public final void D(int i2) {
                    b.this.bI();
                    b.this.lB = true;
                    aVar.D(i2);
                }
            };
            m.checkNotNull(r4);
            if (context.isRestricted()) {
                r4.a(-4, (Handler) null);
            } else {
                f.a(context, i2, new TypedValue(), 0, r4, false);
            }
        } catch (UnsupportedOperationException e2) {
        } catch (Resources.NotFoundException e3) {
        } catch (Exception e4) {
            new StringBuilder("Error loading font ").append(this.fontFamily);
        }
    }

    /* access modifiers changed from: package-private */
    public final void bI() {
        if (this.lC == null) {
            this.lC = Typeface.create(this.fontFamily, this.textStyle);
        }
        if (this.lC == null) {
            switch (this.typeface) {
                case 1:
                    this.lC = Typeface.SANS_SERIF;
                    break;
                case 2:
                    this.lC = Typeface.SERIF;
                    break;
                case 3:
                    this.lC = Typeface.MONOSPACE;
                    break;
                default:
                    this.lC = Typeface.DEFAULT;
                    break;
            }
            if (this.lC != null) {
                this.lC = Typeface.create(this.lC, this.textStyle);
            }
        }
    }

    public final void b(Context context, TextPaint textPaint, f.a aVar) {
        int i2;
        c(context, textPaint, aVar);
        textPaint.setColor(this.ld != null ? this.ld.getColorForState(textPaint.drawableState, this.ld.getDefaultColor()) : WebView.NIGHT_MODE_COLOR);
        float f2 = this.shadowRadius;
        float f3 = this.ly;
        float f4 = this.lz;
        if (this.lx != null) {
            i2 = this.lx.getColorForState(textPaint.drawableState, this.lx.getDefaultColor());
        } else {
            i2 = 0;
        }
        textPaint.setShadowLayer(f2, f3, f4, i2);
    }

    public final void a(TextPaint textPaint, Typeface typeface2) {
        textPaint.setTypeface(typeface2);
        int style = (typeface2.getStyle() ^ -1) & this.textStyle;
        textPaint.setFakeBoldText((style & 1) != 0);
        textPaint.setTextSkewX((style & 2) != 0 ? -0.25f : 0.0f);
        textPaint.setTextSize(this.textSize);
    }

    public final void c(Context context, TextPaint textPaint, f.a aVar) {
        if (c.lG) {
            a(textPaint, I(context));
            return;
        }
        a(context, textPaint, aVar);
        if (!this.lB) {
            a(textPaint, this.lC);
        }
    }
}
