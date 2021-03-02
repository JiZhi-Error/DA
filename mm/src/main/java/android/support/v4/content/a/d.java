package android.support.v4.content.a;

import android.graphics.Shader;
import java.util.List;

/* access modifiers changed from: package-private */
public final class d {
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0064, code lost:
        throw new org.xmlpull.v1.XmlPullParserException(r9.getPositionDescription() + ": <item> tag requires a 'color' attribute and a 'offset' attribute!");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static android.support.v4.content.a.d.a e(android.content.res.Resources r8, org.xmlpull.v1.XmlPullParser r9, android.util.AttributeSet r10, android.content.res.Resources.Theme r11) {
        /*
        // Method dump skipped, instructions count: 142
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.content.a.d.e(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):android.support.v4.content.a.d$a");
    }

    static Shader.TileMode au(int i2) {
        switch (i2) {
            case 1:
                return Shader.TileMode.REPEAT;
            case 2:
                return Shader.TileMode.MIRROR;
            default:
                return Shader.TileMode.CLAMP;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class a {
        final float[] JN;
        final int[] mColors;

        a(List<Integer> list, List<Float> list2) {
            int size = list.size();
            this.mColors = new int[size];
            this.JN = new float[size];
            for (int i2 = 0; i2 < size; i2++) {
                this.mColors[i2] = list.get(i2).intValue();
                this.JN[i2] = list2.get(i2).floatValue();
            }
        }

        a(int i2, int i3) {
            this.mColors = new int[]{i2, i3};
            this.JN = new float[]{0.0f, 1.0f};
        }

        a(int i2, int i3, int i4) {
            this.mColors = new int[]{i2, i3, i4};
            this.JN = new float[]{0.0f, 0.5f, 1.0f};
        }
    }
}
