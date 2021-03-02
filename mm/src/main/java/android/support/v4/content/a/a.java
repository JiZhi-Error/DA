package android.support.v4.content.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.b.a;
import android.util.AttributeSet;
import android.util.StateSet;
import android.util.Xml;
import com.tencent.mm.R;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class a {
    public static ColorStateList createFromXml(Resources resources, XmlPullParser xmlPullParser, Resources.Theme theme) {
        int next;
        AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return c(resources, xmlPullParser, asAttributeSet, theme);
        }
        throw new XmlPullParserException("No start tag found");
    }

    public static ColorStateList c(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        String name = xmlPullParser.getName();
        if (name.equals("selector")) {
            return d(resources, xmlPullParser, attributeSet, theme);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid color state list tag " + name);
    }

    private static ColorStateList d(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int depth;
        TypedArray obtainStyledAttributes;
        int i2;
        int depth2 = xmlPullParser.getDepth() + 1;
        int[][] iArr = new int[20][];
        int[] iArr2 = new int[20];
        int i3 = 0;
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1 || ((depth = xmlPullParser.getDepth()) < depth2 && next == 3)) {
                int[] iArr3 = new int[i3];
                int[][] iArr4 = new int[i3][];
                System.arraycopy(iArr2, 0, iArr3, 0, i3);
                System.arraycopy(iArr, 0, iArr4, 0, i3);
            } else if (next == 2 && depth <= depth2 && xmlPullParser.getName().equals("item")) {
                int[] iArr5 = a.C0005a.ColorStateListItem;
                if (theme == null) {
                    obtainStyledAttributes = resources.obtainAttributes(attributeSet, iArr5);
                } else {
                    obtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, iArr5, 0, 0);
                }
                int color = obtainStyledAttributes.getColor(0, -65281);
                float f2 = 1.0f;
                if (obtainStyledAttributes.hasValue(1)) {
                    f2 = obtainStyledAttributes.getFloat(1, 1.0f);
                } else if (obtainStyledAttributes.hasValue(2)) {
                    f2 = obtainStyledAttributes.getFloat(2, 1.0f);
                }
                obtainStyledAttributes.recycle();
                int i4 = 0;
                int attributeCount = attributeSet.getAttributeCount();
                int[] iArr6 = new int[attributeCount];
                int i5 = 0;
                while (i5 < attributeCount) {
                    int attributeNameResource = attributeSet.getAttributeNameResource(i5);
                    if (attributeNameResource == 16843173 || attributeNameResource == 16843551 || attributeNameResource == R.attr.ba) {
                        i2 = i4;
                    } else {
                        int i6 = i4 + 1;
                        if (!attributeSet.getAttributeBooleanValue(i5, false)) {
                            attributeNameResource = -attributeNameResource;
                        }
                        iArr6[i4] = attributeNameResource;
                        i2 = i6;
                    }
                    i5++;
                    i4 = i2;
                }
                int[] trimStateSet = StateSet.trimStateSet(iArr6, i4);
                iArr2 = e.a(iArr2, i3, (Math.round(f2 * ((float) Color.alpha(color))) << 24) | (16777215 & color));
                i3++;
                iArr = (int[][]) e.a(iArr, i3, trimStateSet);
            }
        }
        int[] iArr32 = new int[i3];
        int[][] iArr42 = new int[i3][];
        System.arraycopy(iArr2, 0, iArr32, 0, i3);
        System.arraycopy(iArr, 0, iArr42, 0, i3);
        return new ColorStateList(iArr42, iArr32);
    }
}
