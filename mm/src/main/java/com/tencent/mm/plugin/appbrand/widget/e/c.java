package com.tencent.mm.plugin.appbrand.widget.e;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.animation.LinearInterpolator;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.b;
import com.tencent.mm.plugin.location_soso.api.SoSoMapView;
import com.tencent.tencentmap.mapsdk.map.Projection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class c {
    f oyA;
    private LinkedList<b.h> oyx;
    Marker oyy;
    private SoSoMapView oyz;
    public AnimatorSet xc;

    public c(LinkedList<b.h> linkedList, Marker marker, SoSoMapView soSoMapView) {
        AppMethodBeat.i(146584);
        this.oyx = linkedList;
        this.oyy = marker;
        this.oyz = soSoMapView;
        init();
        AppMethodBeat.o(146584);
    }

    private void init() {
        AppMethodBeat.i(146585);
        this.xc = new AnimatorSet();
        this.oyA = new f();
        ArrayList arrayList = new ArrayList();
        Iterator<b.h> it = this.oyx.iterator();
        while (it.hasNext()) {
            b.h next = it.next();
            if (next.mat != 0.0f && next.latitude != 0.0d && next.longitude != 0.0d) {
                ValueAnimator a2 = a(next);
                ValueAnimator b2 = b(next);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.play(b2).with(a2);
                arrayList.add(animatorSet);
            } else if (next.mat != 0.0f) {
                arrayList.add(b(next));
            } else {
                arrayList.add(a(next));
            }
        }
        this.xc.playSequentially(arrayList);
        AppMethodBeat.o(146585);
    }

    private ValueAnimator a(b.h hVar) {
        AppMethodBeat.i(146586);
        LatLng[] latLngArr = {new LatLng(hVar.maD, hVar.maC), new LatLng(hVar.latitude, hVar.longitude)};
        final e b2 = this.oyA.b(latLngArr[0]);
        final e b3 = this.oyA.b(latLngArr[1]);
        final double[] dArr = new double[1];
        Projection projection = this.oyz.getProjection();
        double d2 = 0.0d;
        for (int i2 = 0; i2 <= 0; i2++) {
            dArr[0] = projection.distanceBetween(latLngArr[0], latLngArr[1]);
            d2 = dArr[0] + 0.0d;
        }
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setDuration((long) ((((double) hVar.duration) * dArr[0]) / d2));
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.setFloatValues((float) dArr[0]);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.tencent.mm.plugin.appbrand.widget.e.c.AnonymousClass1 */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(146582);
                if (b2.equals(b3)) {
                    AppMethodBeat.o(146582);
                    return;
                }
                double parseDouble = Double.parseDouble(String.valueOf(valueAnimator.getAnimatedValue()));
                double d2 = b2.x + (((b3.x - b2.x) * parseDouble) / dArr[0]);
                double d3 = ((parseDouble * (b3.y - b2.y)) / dArr[0]) + b2.y;
                Marker marker = c.this.oyy;
                f fVar = c.this.oyA;
                e eVar = new e(d2, d3);
                marker.setPosition(new LatLng(90.0d - Math.toDegrees(Math.atan(Math.exp(((-(0.5d - (eVar.y / fVar.oyM))) * 2.0d) * 3.141592653589793d)) * 2.0d), ((eVar.x / fVar.oyM) - 0.5d) * 360.0d));
                AppMethodBeat.o(146582);
            }
        });
        AppMethodBeat.o(146586);
        return valueAnimator;
    }

    private ValueAnimator b(b.h hVar) {
        AppMethodBeat.i(217260);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.oyy.getRotation(), this.oyy.getRotation() + hVar.mat);
        ofFloat.setDuration((long) hVar.duration);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.tencent.mm.plugin.appbrand.widget.e.c.AnonymousClass2 */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(146583);
                c.this.oyy.setRotation((float) Double.parseDouble(String.valueOf(valueAnimator.getAnimatedValue())));
                AppMethodBeat.o(146583);
            }
        });
        AppMethodBeat.o(217260);
        return ofFloat;
    }
}
