package com.tencent.mm.ui.tools.a;

import android.graphics.PointF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.List;

public final class a {
    private static float b(PointF pointF, PointF pointF2) {
        AppMethodBeat.i(182570);
        float hypot = (float) Math.hypot((double) (pointF.x - pointF2.x), (double) (pointF.y - pointF2.y));
        AppMethodBeat.o(182570);
        return hypot;
    }

    public static List<PointF> jV(List<PointF> list) {
        AppMethodBeat.i(205380);
        double d2 = 0.0d;
        try {
            int size = list.size();
            int i2 = 1;
            PointF pointF = list.get(0);
            while (i2 < size) {
                d2 += (double) b(pointF, list.get(i2));
                i2++;
                pointF = list.get(i2);
            }
            double d3 = d2 / 200.0d;
            double d4 = 0.0d;
            ArrayList arrayList = new ArrayList();
            arrayList.add(new PointF(list.get(0).x, list.get(0).y));
            int size2 = list.size();
            int i3 = 1;
            PointF pointF2 = list.get(0);
            while (i3 < size2) {
                PointF pointF3 = list.get(i3);
                double b2 = (double) b(pointF2, pointF3);
                if (d4 + b2 < d3) {
                    d4 += b2;
                    PointF pointF4 = list.get(i3);
                    i3++;
                    pointF2 = pointF4;
                } else if (b2 > 0.0d) {
                    double d5 = (d3 - d4) / b2;
                    PointF pointF5 = new PointF((float) (((double) pointF2.x) + (((double) (pointF3.x - pointF2.x)) * d5)), (float) ((d5 * ((double) (pointF3.y - pointF2.y))) + ((double) pointF2.y)));
                    arrayList.add(pointF5);
                    d4 = 0.0d;
                    pointF2 = pointF5;
                }
            }
            AppMethodBeat.o(205380);
            return arrayList;
        } catch (Throwable th) {
            Log.e("MicroMsg.GestureRecognizer.ToIos", th.toString());
            ArrayList arrayList2 = new ArrayList();
            AppMethodBeat.o(205380);
            return arrayList2;
        }
    }

    private static List<Float> jW(List<PointF> list) {
        AppMethodBeat.i(205381);
        double d2 = 0.0d;
        double d3 = 0.0d;
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            PointF pointF = list.get(i2);
            d2 += (double) pointF.x;
            d3 += (double) pointF.y;
        }
        PointF pointF2 = new PointF((float) (d2 / ((double) size)), (float) (d3 / ((double) size)));
        for (int i3 = 0; i3 < size; i3++) {
            PointF pointF3 = list.get(i3);
            pointF3.x -= pointF2.x;
            pointF3.y -= pointF2.y;
        }
        double d4 = Double.MAX_VALUE;
        double d5 = -1.7976931348623157E308d;
        double d6 = Double.MAX_VALUE;
        int i4 = 0;
        double d7 = -1.7976931348623157E308d;
        while (i4 < size) {
            PointF pointF4 = list.get(i4);
            d4 = Math.min(d4, (double) pointF4.x);
            d5 = Math.max(d5, (double) pointF4.x);
            d6 = Math.min(d6, (double) pointF4.y);
            i4++;
            d7 = Math.max(d7, (double) pointF4.y);
        }
        C2130a aVar = new C2130a((byte) 0);
        double d8 = d5 - d4;
        double d9 = d7 - d6;
        double max = Math.max(d8, d9);
        boolean z = Math.min(d8, d9) / max < 0.20000000298023224d;
        double d10 = aVar.QxD / d8;
        double d11 = aVar.QxE / d9;
        if (z) {
            d10 = aVar.QxD / max;
            d11 = aVar.QxE / max;
        }
        for (int i5 = 0; i5 < size; i5++) {
            PointF pointF5 = list.get(i5);
            pointF5.x = (float) (((double) pointF5.x) * d10);
            pointF5.y = (float) (((double) pointF5.y) * d11);
        }
        PointF pointF6 = list.get(0);
        double atan2 = Math.atan2((double) pointF6.y, (double) pointF6.x);
        double floor = (0.7853981633974483d * Math.floor((0.39269908169872414d + atan2) / 0.7853981633974483d)) - atan2;
        double cos = Math.cos(floor);
        double sin = Math.sin(floor);
        for (int i6 = 0; i6 < size; i6++) {
            PointF pointF7 = list.get(i6);
            pointF7.x = (float) ((((double) pointF7.x) * cos) - (((double) pointF7.y) * sin));
            pointF7.y = (float) ((((double) pointF7.x) * sin) + (((double) pointF7.y) * cos));
        }
        ArrayList arrayList = new ArrayList();
        double d12 = 0.0d;
        for (int i7 = 0; i7 < size; i7++) {
            PointF pointF8 = list.get(i7);
            arrayList.add(Float.valueOf(pointF8.x));
            arrayList.add(Float.valueOf(pointF8.y));
            d12 += Math.pow((double) pointF8.x, 2.0d) + Math.pow((double) pointF8.y, 2.0d);
        }
        double sqrt = Math.sqrt(d12);
        int size2 = arrayList.size();
        for (int i8 = 0; i8 < size2; i8++) {
            arrayList.set(i8, Float.valueOf((float) ((((double) ((Float) arrayList.get(i8)).floatValue()) / sqrt) + 1.0E-4d)));
        }
        AppMethodBeat.o(205381);
        return arrayList;
    }

    public static double E(List<PointF> list, List<PointF> list2) {
        AppMethodBeat.i(205382);
        try {
            List<PointF> jV = jV(list);
            List<PointF> jV2 = jV(list2);
            List<Float> jW = jW(jV);
            List<Float> jW2 = jW(jV2);
            double d2 = 0.0d;
            double d3 = 0.0d;
            int size = jW.size();
            int size2 = jW2.size();
            int i2 = 0;
            while (i2 < size && i2 < size2) {
                d2 += (double) ((jW2.get(i2 + 1).floatValue() * jW.get(i2 + 1).floatValue()) + (jW.get(i2).floatValue() * jW2.get(i2).floatValue()));
                d3 += (double) ((jW.get(i2).floatValue() * jW2.get(i2 + 1).floatValue()) - (jW2.get(i2).floatValue() * jW.get(i2 + 1).floatValue()));
                i2 += 2;
            }
            if (d2 != 0.0d) {
                double atan = Math.atan(d3 / d2);
                double acos = Math.acos((Math.sin(atan) * d3) + (d2 * Math.cos(atan)));
                AppMethodBeat.o(205382);
                return acos;
            }
            Log.e("MicroMsg.GestureRecognizer.ToIos", "devide a but a == 0");
            AppMethodBeat.o(205382);
            return 1.5707963267948966d;
        } catch (Throwable th) {
            Log.e("MicroMsg.GestureRecognizer.ToIos", th.toString());
            AppMethodBeat.o(205382);
            return 0.0d;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.ui.tools.a.a$a  reason: collision with other inner class name */
    public static class C2130a {
        double QxD;
        double QxE;

        /* synthetic */ C2130a(byte b2) {
            this();
        }

        private C2130a() {
            this.QxD = 150.0d;
            this.QxE = 150.0d;
        }
    }

    public static List<PointF> jX(List<PointF> list) {
        int i2;
        AppMethodBeat.i(205383);
        ArrayList arrayList = new ArrayList();
        if (list == null || list.size() <= 0) {
            AppMethodBeat.o(205383);
            return arrayList;
        }
        int size = list.size();
        arrayList.add(list.get(0));
        int size2 = arrayList.size() - 1;
        int i3 = 1;
        while (i3 < size) {
            if (!list.get(i3).equals(arrayList.get(size2))) {
                arrayList.add(list.get(i3));
                i2 = arrayList.size() - 1;
            } else {
                i2 = size2;
            }
            i3++;
            size2 = i2;
        }
        Log.i("MicroMsg.GestureRecognizer", arrayList.toString());
        AppMethodBeat.o(205383);
        return arrayList;
    }
}
