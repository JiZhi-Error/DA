package android.support.v4.content.a;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.b.a;
import android.util.Base64;
import android.util.TypedValue;
import android.util.Xml;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class c {

    public interface a {
    }

    public static final class d implements a {
        public final android.support.v4.c.a JK;
        public final int JL;
        public final int JM;

        public d(android.support.v4.c.a aVar, int i2, int i3) {
            this.JK = aVar;
            this.JM = i2;
            this.JL = i3;
        }
    }

    /* renamed from: android.support.v4.content.a.c$c  reason: collision with other inner class name */
    public static final class C0021c {
        public int JF;
        public boolean JG;
        public String JH;
        public int JI;
        public int JJ;
        public final String mFileName;

        public C0021c(String str, int i2, boolean z, String str2, int i3, int i4) {
            this.mFileName = str;
            this.JF = i2;
            this.JG = z;
            this.JH = str2;
            this.JI = i3;
            this.JJ = i4;
        }
    }

    public static final class b implements a {
        public final C0021c[] JE;

        public b(C0021c[] cVarArr) {
            this.JE = cVarArr;
        }
    }

    public static a a(XmlPullParser xmlPullParser, Resources resources) {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next != 2) {
            throw new XmlPullParserException("No start tag found");
        }
        xmlPullParser.require(2, null, "font-family");
        if (xmlPullParser.getName().equals("font-family")) {
            return b(xmlPullParser, resources);
        }
        skip(xmlPullParser);
        return null;
    }

    private static a b(XmlPullParser xmlPullParser, Resources resources) {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), a.C0005a.FontFamily);
        String string = obtainAttributes.getString(0);
        String string2 = obtainAttributes.getString(4);
        String string3 = obtainAttributes.getString(5);
        int resourceId = obtainAttributes.getResourceId(1, 0);
        int integer = obtainAttributes.getInteger(2, 1);
        int integer2 = obtainAttributes.getInteger(3, 500);
        obtainAttributes.recycle();
        if (string == null || string2 == null || string3 == null) {
            ArrayList arrayList = new ArrayList();
            while (xmlPullParser.next() != 3) {
                if (xmlPullParser.getEventType() == 2) {
                    if (xmlPullParser.getName().equals("font")) {
                        arrayList.add(c(xmlPullParser, resources));
                    } else {
                        skip(xmlPullParser);
                    }
                }
            }
            if (arrayList.isEmpty()) {
                return null;
            }
            return new b((C0021c[]) arrayList.toArray(new C0021c[arrayList.size()]));
        }
        while (xmlPullParser.next() != 3) {
            skip(xmlPullParser);
        }
        return new d(new android.support.v4.c.a(string, string2, string3, a(resources, resourceId)), integer, integer2);
    }

    public static List<List<byte[]>> a(Resources resources, int i2) {
        int i3;
        if (i2 == 0) {
            return Collections.emptyList();
        }
        TypedArray obtainTypedArray = resources.obtainTypedArray(i2);
        try {
            if (obtainTypedArray.length() == 0) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            if (Build.VERSION.SDK_INT >= 21) {
                i3 = obtainTypedArray.getType(0);
            } else {
                TypedValue typedValue = new TypedValue();
                obtainTypedArray.getValue(0, typedValue);
                i3 = typedValue.type;
            }
            if (i3 == 1) {
                for (int i4 = 0; i4 < obtainTypedArray.length(); i4++) {
                    int resourceId = obtainTypedArray.getResourceId(i4, 0);
                    if (resourceId != 0) {
                        arrayList.add(b(resources.getStringArray(resourceId)));
                    }
                }
            } else {
                arrayList.add(b(resources.getStringArray(i2)));
            }
            obtainTypedArray.recycle();
            return arrayList;
        } finally {
            obtainTypedArray.recycle();
        }
    }

    private static List<byte[]> b(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            arrayList.add(Base64.decode(str, 0));
        }
        return arrayList;
    }

    private static C0021c c(XmlPullParser xmlPullParser, Resources resources) {
        boolean z;
        int i2;
        int i3;
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), a.C0005a.FontFamilyFont);
        int i4 = obtainAttributes.getInt(obtainAttributes.hasValue(8) ? 8 : 1, 400);
        if (1 == obtainAttributes.getInt(obtainAttributes.hasValue(6) ? 6 : 2, 0)) {
            z = true;
        } else {
            z = false;
        }
        if (obtainAttributes.hasValue(9)) {
            i2 = 9;
        } else {
            i2 = 3;
        }
        String string = obtainAttributes.getString(obtainAttributes.hasValue(7) ? 7 : 4);
        int i5 = obtainAttributes.getInt(i2, 0);
        if (obtainAttributes.hasValue(5)) {
            i3 = 5;
        } else {
            i3 = 0;
        }
        int resourceId = obtainAttributes.getResourceId(i3, 0);
        String string2 = obtainAttributes.getString(i3);
        obtainAttributes.recycle();
        while (xmlPullParser.next() != 3) {
            skip(xmlPullParser);
        }
        return new C0021c(string2, i4, z, string, i5, resourceId);
    }

    private static void skip(XmlPullParser xmlPullParser) {
        int i2 = 1;
        while (i2 > 0) {
            switch (xmlPullParser.next()) {
                case 2:
                    i2++;
                    break;
                case 3:
                    i2--;
                    break;
            }
        }
    }
}
