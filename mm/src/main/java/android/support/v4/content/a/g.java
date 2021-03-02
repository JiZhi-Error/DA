package android.support.v4.content.a;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import org.xmlpull.v1.XmlPullParser;

public final class g {
    public static boolean a(XmlPullParser xmlPullParser, String str) {
        return xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str) != null;
    }

    public static float a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i2, float f2) {
        return !a(xmlPullParser, str) ? f2 : typedArray.getFloat(i2, f2);
    }

    public static boolean a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i2, boolean z) {
        return !a(xmlPullParser, str) ? z : typedArray.getBoolean(i2, z);
    }

    public static int a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i2, int i3) {
        return !a(xmlPullParser, str) ? i3 : typedArray.getInt(i2, i3);
    }

    public static int a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i2) {
        if (!a(xmlPullParser, str)) {
            return 0;
        }
        return typedArray.getColor(i2, 0);
    }

    public static b a(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme, String str, int i2) {
        if (a(xmlPullParser, str)) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(i2, typedValue);
            if (typedValue.type >= 28 && typedValue.type <= 31) {
                return b.at(typedValue.data);
            }
            b b2 = b.b(typedArray.getResources(), typedArray.getResourceId(i2, 0), theme);
            if (b2 != null) {
                return b2;
            }
        }
        return b.at(0);
    }

    public static int b(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i2) {
        if (!a(xmlPullParser, str)) {
            return 0;
        }
        return typedArray.getResourceId(i2, 0);
    }

    public static String c(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i2) {
        if (!a(xmlPullParser, str)) {
            return null;
        }
        return typedArray.getString(i2);
    }

    public static TypedValue a(TypedArray typedArray, XmlPullParser xmlPullParser, String str) {
        if (!a(xmlPullParser, str)) {
            return null;
        }
        return typedArray.peekValue(0);
    }

    public static TypedArray a(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        if (theme == null) {
            return resources.obtainAttributes(attributeSet, iArr);
        }
        return theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }
}
