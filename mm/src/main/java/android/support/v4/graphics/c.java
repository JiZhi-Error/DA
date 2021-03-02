package android.support.v4.graphics;

import android.graphics.Path;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.r.f;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.thumbplayer.core.common.TPCodecParamers;
import java.util.ArrayList;

public final class c {
    static float[] a(float[] fArr, int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException();
        }
        int length = fArr.length;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i3 = i2 + 0;
        int min = Math.min(i3, length + 0);
        float[] fArr2 = new float[i3];
        System.arraycopy(fArr, 0, fArr2, 0, min);
        return fArr2;
    }

    public static Path x(String str) {
        Path path = new Path();
        b[] y = y(str);
        if (y == null) {
            return null;
        }
        try {
            b.a(y, path);
            return path;
        } catch (RuntimeException e2) {
            throw new RuntimeException("Error in parsing ".concat(String.valueOf(str)), e2);
        }
    }

    public static b[] y(String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = 1;
        int i3 = 0;
        while (i2 < str.length()) {
            int e2 = e(str, i2);
            String trim = str.substring(i3, e2).trim();
            if (trim.length() > 0) {
                a(arrayList, trim.charAt(0), z(trim));
            }
            i2 = e2 + 1;
            i3 = e2;
        }
        if (i2 - i3 == 1 && i3 < str.length()) {
            a(arrayList, str.charAt(i3), new float[0]);
        }
        return (b[]) arrayList.toArray(new b[arrayList.size()]);
    }

    public static b[] a(b[] bVarArr) {
        if (bVarArr == null) {
            return null;
        }
        b[] bVarArr2 = new b[bVarArr.length];
        for (int i2 = 0; i2 < bVarArr.length; i2++) {
            bVarArr2[i2] = new b(bVarArr[i2]);
        }
        return bVarArr2;
    }

    public static boolean a(b[] bVarArr, b[] bVarArr2) {
        if (bVarArr == null || bVarArr2 == null || bVarArr.length != bVarArr2.length) {
            return false;
        }
        for (int i2 = 0; i2 < bVarArr.length; i2++) {
            if (!(bVarArr[i2].JT == bVarArr2[i2].JT && bVarArr[i2].JU.length == bVarArr2[i2].JU.length)) {
                return false;
            }
        }
        return true;
    }

    private static int e(String str, int i2) {
        while (i2 < str.length()) {
            char charAt = str.charAt(i2);
            if (((charAt - 'A') * (charAt - 'Z') <= 0 || (charAt - 'a') * (charAt - 'z') <= 0) && charAt != 'e' && charAt != 'E') {
                break;
            }
            i2++;
        }
        return i2;
    }

    private static void a(ArrayList<b> arrayList, char c2, float[] fArr) {
        arrayList.add(new b(c2, fArr));
    }

    /* access modifiers changed from: package-private */
    public static class a {
        int JR;
        boolean JS;

        a() {
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0062 A[Catch:{ NumberFormatException -> 0x007e }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0072 A[Catch:{ NumberFormatException -> 0x007e }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0075 A[Catch:{ NumberFormatException -> 0x007e }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x009c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static float[] z(java.lang.String r12) {
        /*
        // Method dump skipped, instructions count: 184
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.graphics.c.z(java.lang.String):float[]");
    }

    public static class b {
        public char JT;
        public float[] JU;

        b(char c2, float[] fArr) {
            this.JT = c2;
            this.JU = fArr;
        }

        b(b bVar) {
            this.JT = bVar.JT;
            this.JU = c.a(bVar.JU, bVar.JU.length);
        }

        public static void a(b[] bVarArr, Path path) {
            float[] fArr = new float[6];
            char c2 = 'm';
            for (int i2 = 0; i2 < bVarArr.length; i2++) {
                a(path, fArr, c2, bVarArr[i2].JT, bVarArr[i2].JU);
                c2 = bVarArr[i2].JT;
            }
        }

        public final void a(b bVar, b bVar2, float f2) {
            for (int i2 = 0; i2 < bVar.JU.length; i2++) {
                this.JU[i2] = (bVar.JU[i2] * (1.0f - f2)) + (bVar2.JU[i2] * f2);
            }
        }

        private static void a(Path path, float[] fArr, char c2, char c3, float[] fArr2) {
            int i2;
            boolean z;
            float f2;
            float f3;
            float f4;
            float f5;
            float f6;
            float f7;
            boolean z2;
            float f8;
            float f9;
            float f10 = fArr[0];
            float f11 = fArr[1];
            float f12 = fArr[2];
            float f13 = fArr[3];
            float f14 = fArr[4];
            float f15 = fArr[5];
            switch (c3) {
                case 'A':
                case PlayerException.EXCEPTION_IN_RELEASE /*{ENCODED_INT: 97}*/:
                    i2 = 7;
                    break;
                case 'C':
                case 'c':
                    i2 = 6;
                    break;
                case 'H':
                case com.tencent.mm.plugin.appbrand.jsapi.pay.b.CTRL_INDEX /*{ENCODED_INT: 86}*/:
                case 'h':
                case 'v':
                    i2 = 1;
                    break;
                case WXMediaMessage.IMediaObject.TYPE_MUSIC_VIDEO /*{ENCODED_INT: 76}*/:
                case TPCodecParamers.TP_PROFILE_H264_MAIN /*{ENCODED_INT: 77}*/:
                case f.CTRL_INDEX /*{ENCODED_INT: 84}*/:
                case 'l':
                case 'm':
                case 't':
                    i2 = 2;
                    break;
                case 'Q':
                case 'S':
                case 'q':
                case 's':
                    i2 = 4;
                    break;
                case 'Z':
                case 'z':
                    path.close();
                    path.moveTo(f14, f15);
                    f13 = f15;
                    f12 = f14;
                    f11 = f15;
                    f10 = f14;
                    i2 = 2;
                    break;
                default:
                    i2 = 2;
                    break;
            }
            int i3 = 0;
            float f16 = f15;
            float f17 = f14;
            float f18 = f13;
            float f19 = f12;
            float f20 = f11;
            float f21 = f10;
            while (i3 < fArr2.length) {
                switch (c3) {
                    case 'A':
                        float f22 = fArr2[i3 + 5];
                        float f23 = fArr2[i3 + 6];
                        float f24 = fArr2[i3 + 0];
                        float f25 = fArr2[i3 + 1];
                        float f26 = fArr2[i3 + 2];
                        boolean z3 = fArr2[i3 + 3] != 0.0f;
                        if (fArr2[i3 + 4] != 0.0f) {
                            z = true;
                        } else {
                            z = false;
                        }
                        a(path, f21, f20, f22, f23, f24, f25, f26, z3, z);
                        float f27 = fArr2[i3 + 5];
                        float f28 = fArr2[i3 + 6];
                        f2 = f16;
                        f3 = f17;
                        f4 = f28;
                        f5 = f27;
                        f6 = f28;
                        f7 = f27;
                        break;
                    case 'C':
                        path.cubicTo(fArr2[i3 + 0], fArr2[i3 + 1], fArr2[i3 + 2], fArr2[i3 + 3], fArr2[i3 + 4], fArr2[i3 + 5]);
                        float f29 = fArr2[i3 + 4];
                        float f30 = fArr2[i3 + 5];
                        float f31 = fArr2[i3 + 2];
                        f2 = f16;
                        f3 = f17;
                        f4 = fArr2[i3 + 3];
                        f5 = f31;
                        f6 = f30;
                        f7 = f29;
                        break;
                    case 'H':
                        path.lineTo(fArr2[i3 + 0], f20);
                        f2 = f16;
                        f3 = f17;
                        f4 = f18;
                        f5 = f19;
                        f6 = f20;
                        f7 = fArr2[i3 + 0];
                        break;
                    case WXMediaMessage.IMediaObject.TYPE_MUSIC_VIDEO /*{ENCODED_INT: 76}*/:
                        path.lineTo(fArr2[i3 + 0], fArr2[i3 + 1]);
                        float f32 = fArr2[i3 + 0];
                        f2 = f16;
                        f3 = f17;
                        f4 = f18;
                        f5 = f19;
                        f6 = fArr2[i3 + 1];
                        f7 = f32;
                        break;
                    case TPCodecParamers.TP_PROFILE_H264_MAIN /*{ENCODED_INT: 77}*/:
                        float f33 = fArr2[i3 + 0];
                        float f34 = fArr2[i3 + 1];
                        if (i3 <= 0) {
                            path.moveTo(fArr2[i3 + 0], fArr2[i3 + 1]);
                            f2 = f34;
                            f3 = f33;
                            f4 = f18;
                            f5 = f19;
                            f6 = f34;
                            f7 = f33;
                            break;
                        } else {
                            path.lineTo(fArr2[i3 + 0], fArr2[i3 + 1]);
                            f2 = f16;
                            f3 = f17;
                            f4 = f18;
                            f5 = f19;
                            f6 = f34;
                            f7 = f33;
                            break;
                        }
                    case 'Q':
                        path.quadTo(fArr2[i3 + 0], fArr2[i3 + 1], fArr2[i3 + 2], fArr2[i3 + 3]);
                        float f35 = fArr2[i3 + 0];
                        float f36 = fArr2[i3 + 1];
                        float f37 = fArr2[i3 + 2];
                        f2 = f16;
                        f3 = f17;
                        f4 = f36;
                        f5 = f35;
                        f6 = fArr2[i3 + 3];
                        f7 = f37;
                        break;
                    case 'S':
                        if (c2 == 'c' || c2 == 's' || c2 == 'C' || c2 == 'S') {
                            f9 = (2.0f * f21) - f19;
                            f8 = (2.0f * f20) - f18;
                        } else {
                            f8 = f20;
                            f9 = f21;
                        }
                        path.cubicTo(f9, f8, fArr2[i3 + 0], fArr2[i3 + 1], fArr2[i3 + 2], fArr2[i3 + 3]);
                        float f38 = fArr2[i3 + 0];
                        float f39 = fArr2[i3 + 1];
                        float f40 = fArr2[i3 + 2];
                        f2 = f16;
                        f3 = f17;
                        f4 = f39;
                        f5 = f38;
                        f6 = fArr2[i3 + 3];
                        f7 = f40;
                        break;
                    case f.CTRL_INDEX /*{ENCODED_INT: 84}*/:
                        if (c2 == 'q' || c2 == 't' || c2 == 'Q' || c2 == 'T') {
                            f21 = (2.0f * f21) - f19;
                            f20 = (2.0f * f20) - f18;
                        }
                        path.quadTo(f21, f20, fArr2[i3 + 0], fArr2[i3 + 1]);
                        float f41 = fArr2[i3 + 0];
                        f2 = f16;
                        f3 = f17;
                        f4 = f20;
                        f5 = f21;
                        f6 = fArr2[i3 + 1];
                        f7 = f41;
                        break;
                    case com.tencent.mm.plugin.appbrand.jsapi.pay.b.CTRL_INDEX /*{ENCODED_INT: 86}*/:
                        path.lineTo(f21, fArr2[i3 + 0]);
                        f2 = f16;
                        f3 = f17;
                        f4 = f18;
                        f5 = f19;
                        f6 = fArr2[i3 + 0];
                        f7 = f21;
                        break;
                    case PlayerException.EXCEPTION_IN_RELEASE /*{ENCODED_INT: 97}*/:
                        float f42 = fArr2[i3 + 5] + f21;
                        float f43 = fArr2[i3 + 6] + f20;
                        float f44 = fArr2[i3 + 0];
                        float f45 = fArr2[i3 + 1];
                        float f46 = fArr2[i3 + 2];
                        boolean z4 = fArr2[i3 + 3] != 0.0f;
                        if (fArr2[i3 + 4] != 0.0f) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        a(path, f21, f20, f42, f43, f44, f45, f46, z4, z2);
                        float f47 = f21 + fArr2[i3 + 5];
                        float f48 = f20 + fArr2[i3 + 6];
                        f2 = f16;
                        f3 = f17;
                        f4 = f48;
                        f5 = f47;
                        f6 = f48;
                        f7 = f47;
                        break;
                    case 'c':
                        path.rCubicTo(fArr2[i3 + 0], fArr2[i3 + 1], fArr2[i3 + 2], fArr2[i3 + 3], fArr2[i3 + 4], fArr2[i3 + 5]);
                        float f49 = f21 + fArr2[i3 + 2];
                        float f50 = f20 + fArr2[i3 + 3];
                        float f51 = f21 + fArr2[i3 + 4];
                        f2 = f16;
                        f3 = f17;
                        f4 = f50;
                        f5 = f49;
                        f6 = fArr2[i3 + 5] + f20;
                        f7 = f51;
                        break;
                    case 'h':
                        path.rLineTo(fArr2[i3 + 0], 0.0f);
                        f2 = f16;
                        f3 = f17;
                        f4 = f18;
                        f5 = f19;
                        f6 = f20;
                        f7 = f21 + fArr2[i3 + 0];
                        break;
                    case 'l':
                        path.rLineTo(fArr2[i3 + 0], fArr2[i3 + 1]);
                        float f52 = f21 + fArr2[i3 + 0];
                        f2 = f16;
                        f3 = f17;
                        f4 = f18;
                        f5 = f19;
                        f6 = fArr2[i3 + 1] + f20;
                        f7 = f52;
                        break;
                    case 'm':
                        float f53 = f21 + fArr2[i3 + 0];
                        float f54 = fArr2[i3 + 1] + f20;
                        if (i3 <= 0) {
                            path.rMoveTo(fArr2[i3 + 0], fArr2[i3 + 1]);
                            f2 = f54;
                            f3 = f53;
                            f4 = f18;
                            f5 = f19;
                            f6 = f54;
                            f7 = f53;
                            break;
                        } else {
                            path.rLineTo(fArr2[i3 + 0], fArr2[i3 + 1]);
                            f2 = f16;
                            f3 = f17;
                            f4 = f18;
                            f5 = f19;
                            f6 = f54;
                            f7 = f53;
                            break;
                        }
                    case 'q':
                        path.rQuadTo(fArr2[i3 + 0], fArr2[i3 + 1], fArr2[i3 + 2], fArr2[i3 + 3]);
                        float f55 = f21 + fArr2[i3 + 0];
                        float f56 = f20 + fArr2[i3 + 1];
                        float f57 = f21 + fArr2[i3 + 2];
                        f2 = f16;
                        f3 = f17;
                        f4 = f56;
                        f5 = f55;
                        f6 = fArr2[i3 + 3] + f20;
                        f7 = f57;
                        break;
                    case 's':
                        float f58 = 0.0f;
                        float f59 = 0.0f;
                        if (c2 == 'c' || c2 == 's' || c2 == 'C' || c2 == 'S') {
                            f58 = f21 - f19;
                            f59 = f20 - f18;
                        }
                        path.rCubicTo(f58, f59, fArr2[i3 + 0], fArr2[i3 + 1], fArr2[i3 + 2], fArr2[i3 + 3]);
                        float f60 = f21 + fArr2[i3 + 0];
                        float f61 = f20 + fArr2[i3 + 1];
                        float f62 = f21 + fArr2[i3 + 2];
                        f2 = f16;
                        f3 = f17;
                        f4 = f61;
                        f5 = f60;
                        f6 = fArr2[i3 + 3] + f20;
                        f7 = f62;
                        break;
                    case 't':
                        float f63 = 0.0f;
                        float f64 = 0.0f;
                        if (c2 == 'q' || c2 == 't' || c2 == 'Q' || c2 == 'T') {
                            f63 = f21 - f19;
                            f64 = f20 - f18;
                        }
                        path.rQuadTo(f63, f64, fArr2[i3 + 0], fArr2[i3 + 1]);
                        float f65 = f21 + f63;
                        float f66 = f21 + fArr2[i3 + 0];
                        f2 = f16;
                        f3 = f17;
                        f4 = f20 + f64;
                        f5 = f65;
                        f6 = fArr2[i3 + 1] + f20;
                        f7 = f66;
                        break;
                    case 'v':
                        path.rLineTo(0.0f, fArr2[i3 + 0]);
                        f2 = f16;
                        f3 = f17;
                        f4 = f18;
                        f5 = f19;
                        f6 = fArr2[i3 + 0] + f20;
                        f7 = f21;
                        break;
                    default:
                        f2 = f16;
                        f3 = f17;
                        f4 = f18;
                        f5 = f19;
                        f6 = f20;
                        f7 = f21;
                        break;
                }
                i3 += i2;
                f16 = f2;
                f17 = f3;
                f18 = f4;
                f19 = f5;
                f20 = f6;
                f21 = f7;
                c2 = c3;
            }
            fArr[0] = f21;
            fArr[1] = f20;
            fArr[2] = f19;
            fArr[3] = f18;
            fArr[4] = f17;
            fArr[5] = f16;
        }

        private static void a(Path path, float f2, float f3, float f4, float f5, float f6, float f7, float f8, boolean z, boolean z2) {
            double d2;
            double d3;
            while (true) {
                double radians = Math.toRadians((double) f8);
                double cos = Math.cos(radians);
                double sin = Math.sin(radians);
                double d4 = ((((double) f2) * cos) + (((double) f3) * sin)) / ((double) f6);
                double d5 = ((((double) (-f2)) * sin) + (((double) f3) * cos)) / ((double) f7);
                double d6 = ((((double) f4) * cos) + (((double) f5) * sin)) / ((double) f6);
                double d7 = ((((double) (-f4)) * sin) + (((double) f5) * cos)) / ((double) f7);
                double d8 = d4 - d6;
                double d9 = d5 - d7;
                double d10 = (d4 + d6) / 2.0d;
                double d11 = (d5 + d7) / 2.0d;
                double d12 = (d8 * d8) + (d9 * d9);
                if (d12 != 0.0d) {
                    double d13 = (1.0d / d12) - 0.25d;
                    if (d13 < 0.0d) {
                        float sqrt = (float) (Math.sqrt(d12) / 1.99999d);
                        f6 *= sqrt;
                        f7 *= sqrt;
                    } else {
                        double sqrt2 = Math.sqrt(d13);
                        double d14 = d8 * sqrt2;
                        double d15 = d9 * sqrt2;
                        if (z == z2) {
                            d2 = d10 - d15;
                            d3 = d14 + d11;
                        } else {
                            d2 = d15 + d10;
                            d3 = d11 - d14;
                        }
                        double atan2 = Math.atan2(d5 - d3, d4 - d2);
                        double atan22 = Math.atan2(d7 - d3, d6 - d2) - atan2;
                        if (z2 != (atan22 >= 0.0d)) {
                            if (atan22 > 0.0d) {
                                atan22 -= 6.283185307179586d;
                            } else {
                                atan22 += 6.283185307179586d;
                            }
                        }
                        double d16 = d2 * ((double) f6);
                        double d17 = ((double) f7) * d3;
                        a(path, (d16 * cos) - (d17 * sin), (d16 * sin) + (cos * d17), (double) f6, (double) f7, (double) f2, (double) f3, radians, atan2, atan22);
                        return;
                    }
                } else {
                    return;
                }
            }
        }

        private static void a(Path path, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10) {
            int ceil = (int) Math.ceil(Math.abs((4.0d * d10) / 3.141592653589793d));
            double cos = Math.cos(d8);
            double sin = Math.sin(d8);
            double cos2 = Math.cos(d9);
            double sin2 = Math.sin(d9);
            double d11 = (((-d4) * cos) * sin2) - ((d5 * sin) * cos2);
            double d12 = (cos2 * d5 * cos) + (sin2 * (-d4) * sin);
            double d13 = d10 / ((double) ceil);
            int i2 = 0;
            while (i2 < ceil) {
                double d14 = d9 + d13;
                double sin3 = Math.sin(d14);
                double cos3 = Math.cos(d14);
                double d15 = (((d4 * cos) * cos3) + d2) - ((d5 * sin) * sin3);
                double d16 = (d5 * cos * sin3) + (d4 * sin * cos3) + d3;
                double d17 = (((-d4) * cos) * sin3) - ((d5 * sin) * cos3);
                double d18 = (cos3 * d5 * cos) + (sin3 * (-d4) * sin);
                double tan = Math.tan((d14 - d9) / 2.0d);
                double sqrt = ((Math.sqrt((tan * (3.0d * tan)) + 4.0d) - 1.0d) * Math.sin(d14 - d9)) / 3.0d;
                path.rLineTo(0.0f, 0.0f);
                path.cubicTo((float) ((d11 * sqrt) + d6), (float) (d7 + (d12 * sqrt)), (float) (d15 - (sqrt * d17)), (float) (d16 - (sqrt * d18)), (float) d15, (float) d16);
                d12 = d18;
                d11 = d17;
                d9 = d14;
                i2++;
                d7 = d16;
                d6 = d15;
            }
        }
    }
}
