package android.support.v4.content.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.support.annotation.a;
import android.support.b.a;
import android.support.v4.content.a.d;
import android.util.AttributeSet;
import android.util.Xml;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class b {
    public final Shader JC;
    private final ColorStateList JD;
    public int mColor;

    private b(Shader shader, ColorStateList colorStateList, int i2) {
        this.JC = shader;
        this.JD = colorStateList;
        this.mColor = i2;
    }

    static b at(int i2) {
        return new b(null, null, i2);
    }

    public final boolean ex() {
        return this.JC != null;
    }

    public final boolean isStateful() {
        return this.JC == null && this.JD != null && this.JD.isStateful();
    }

    public final boolean e(int[] iArr) {
        int colorForState;
        if (!isStateful() || (colorForState = this.JD.getColorForState(iArr, this.JD.getDefaultColor())) == this.mColor) {
            return false;
        }
        this.mColor = colorForState;
        return true;
    }

    public final boolean ey() {
        return ex() || this.mColor != 0;
    }

    public static b b(Resources resources, @a int i2, Resources.Theme theme) {
        int next;
        d.a aVar;
        Shader sweepGradient;
        try {
            XmlResourceParser xml = resources.getXml(i2);
            AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
            do {
                next = xml.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next != 2) {
                throw new XmlPullParserException("No start tag found");
            }
            String name = xml.getName();
            char c2 = 65535;
            switch (name.hashCode()) {
                case 89650992:
                    if (name.equals("gradient")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 1191572447:
                    if (name.equals("selector")) {
                        c2 = 0;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    ColorStateList c3 = a.c(resources, xml, asAttributeSet, theme);
                    return new b(null, c3, c3.getDefaultColor());
                case 1:
                    String name2 = xml.getName();
                    if (!name2.equals("gradient")) {
                        throw new XmlPullParserException(xml.getPositionDescription() + ": invalid gradient color tag " + name2);
                    }
                    TypedArray a2 = g.a(resources, theme, asAttributeSet, a.C0005a.GradientColor);
                    float a3 = g.a(a2, (XmlPullParser) xml, "startX", 8, 0.0f);
                    float a4 = g.a(a2, (XmlPullParser) xml, "startY", 9, 0.0f);
                    float a5 = g.a(a2, (XmlPullParser) xml, "endX", 10, 0.0f);
                    float a6 = g.a(a2, (XmlPullParser) xml, "endY", 11, 0.0f);
                    float a7 = g.a(a2, (XmlPullParser) xml, "centerX", 3, 0.0f);
                    float a8 = g.a(a2, (XmlPullParser) xml, "centerY", 4, 0.0f);
                    int a9 = g.a(a2, (XmlPullParser) xml, "type", 2, 0);
                    int a10 = g.a(a2, xml, "startColor", 0);
                    boolean a11 = g.a(xml, "centerColor");
                    int a12 = g.a(a2, xml, "centerColor", 7);
                    int a13 = g.a(a2, xml, "endColor", 1);
                    int a14 = g.a(a2, (XmlPullParser) xml, "tileMode", 6, 0);
                    float a15 = g.a(a2, (XmlPullParser) xml, "gradientRadius", 5, 0.0f);
                    a2.recycle();
                    d.a e2 = d.e(resources, xml, asAttributeSet, theme);
                    if (e2 != null) {
                        aVar = e2;
                    } else if (a11) {
                        aVar = new d.a(a10, a12, a13);
                    } else {
                        aVar = new d.a(a10, a13);
                    }
                    switch (a9) {
                        case 1:
                            if (a15 > 0.0f) {
                                sweepGradient = new RadialGradient(a7, a8, a15, aVar.mColors, aVar.JN, d.au(a14));
                                break;
                            } else {
                                throw new XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
                            }
                        case 2:
                            sweepGradient = new SweepGradient(a7, a8, aVar.mColors, aVar.JN);
                            break;
                        default:
                            sweepGradient = new LinearGradient(a3, a4, a5, a6, aVar.mColors, aVar.JN, d.au(a14));
                            break;
                    }
                    return new b(sweepGradient, null, 0);
                default:
                    throw new XmlPullParserException(xml.getPositionDescription() + ": unsupported complex color tag " + name);
            }
        } catch (Exception e3) {
            return null;
        }
    }
}
