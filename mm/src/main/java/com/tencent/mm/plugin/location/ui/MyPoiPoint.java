package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.mapsdk.raster.model.Circle;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.modelgeo.b;
import com.tencent.mm.plugin.k.d;
import com.tencent.mm.sdk.platformtools.Log;

public class MyPoiPoint extends FrameLayout {
    private final String TAG;
    public b.a gmA;
    private d yHK;
    public com.tencent.mm.modelgeo.d yHL;
    private boolean yHM;
    Circle yHN;

    private MyPoiPoint(Context context) {
        super(context);
        AppMethodBeat.i(55836);
        this.TAG = "MicroMsg.MyPoiPoint";
        this.yHM = false;
        this.gmA = new b.a() {
            /* class com.tencent.mm.plugin.location.ui.MyPoiPoint.AnonymousClass1 */

            @Override // com.tencent.mm.modelgeo.b.a
            public final boolean a(boolean z, float f2, float f3, int i2, double d2, double d3) {
                AppMethodBeat.i(55835);
                if (!z) {
                    AppMethodBeat.o(55835);
                    return false;
                }
                Log.d("MicroMsg.MyPoiPoint", "new location comes! lat : %f, lng: %f, accuracy: %f.", Float.valueOf(f3), Float.valueOf(f2), Double.valueOf(d3));
                if (MyPoiPoint.this.yHK != null) {
                    if (MyPoiPoint.this.yHN != null) {
                        MyPoiPoint.this.yHN.setCenter(new LatLng((double) f3, (double) f2));
                        MyPoiPoint.this.yHN.setRadius(d3);
                    } else {
                        MyPoiPoint.this.yHN = MyPoiPoint.this.yHK.drawAccuracyCircle((double) f3, (double) f2, d3);
                    }
                    if (!MyPoiPoint.this.yHM) {
                        MyPoiPoint.this.yHM = true;
                        MyPoiPoint.this.yHK.addPinView(MyPoiPoint.this, (double) f3, (double) f2);
                    } else {
                        MyPoiPoint.this.yHK.updateLocaitonPinLayout(MyPoiPoint.this, (double) f3, (double) f2);
                    }
                }
                AppMethodBeat.o(55835);
                return true;
            }
        };
        init(context);
        AppMethodBeat.o(55836);
    }

    public MyPoiPoint(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(55837);
        this.TAG = "MicroMsg.MyPoiPoint";
        this.yHM = false;
        this.gmA = new b.a() {
            /* class com.tencent.mm.plugin.location.ui.MyPoiPoint.AnonymousClass1 */

            @Override // com.tencent.mm.modelgeo.b.a
            public final boolean a(boolean z, float f2, float f3, int i2, double d2, double d3) {
                AppMethodBeat.i(55835);
                if (!z) {
                    AppMethodBeat.o(55835);
                    return false;
                }
                Log.d("MicroMsg.MyPoiPoint", "new location comes! lat : %f, lng: %f, accuracy: %f.", Float.valueOf(f3), Float.valueOf(f2), Double.valueOf(d3));
                if (MyPoiPoint.this.yHK != null) {
                    if (MyPoiPoint.this.yHN != null) {
                        MyPoiPoint.this.yHN.setCenter(new LatLng((double) f3, (double) f2));
                        MyPoiPoint.this.yHN.setRadius(d3);
                    } else {
                        MyPoiPoint.this.yHN = MyPoiPoint.this.yHK.drawAccuracyCircle((double) f3, (double) f2, d3);
                    }
                    if (!MyPoiPoint.this.yHM) {
                        MyPoiPoint.this.yHM = true;
                        MyPoiPoint.this.yHK.addPinView(MyPoiPoint.this, (double) f3, (double) f2);
                    } else {
                        MyPoiPoint.this.yHK.updateLocaitonPinLayout(MyPoiPoint.this, (double) f3, (double) f2);
                    }
                }
                AppMethodBeat.o(55835);
                return true;
            }
        };
        init(context);
        AppMethodBeat.o(55837);
    }

    public MyPoiPoint(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(55838);
        this.TAG = "MicroMsg.MyPoiPoint";
        this.yHM = false;
        this.gmA = new b.a() {
            /* class com.tencent.mm.plugin.location.ui.MyPoiPoint.AnonymousClass1 */

            @Override // com.tencent.mm.modelgeo.b.a
            public final boolean a(boolean z, float f2, float f3, int i2, double d2, double d3) {
                AppMethodBeat.i(55835);
                if (!z) {
                    AppMethodBeat.o(55835);
                    return false;
                }
                Log.d("MicroMsg.MyPoiPoint", "new location comes! lat : %f, lng: %f, accuracy: %f.", Float.valueOf(f3), Float.valueOf(f2), Double.valueOf(d3));
                if (MyPoiPoint.this.yHK != null) {
                    if (MyPoiPoint.this.yHN != null) {
                        MyPoiPoint.this.yHN.setCenter(new LatLng((double) f3, (double) f2));
                        MyPoiPoint.this.yHN.setRadius(d3);
                    } else {
                        MyPoiPoint.this.yHN = MyPoiPoint.this.yHK.drawAccuracyCircle((double) f3, (double) f2, d3);
                    }
                    if (!MyPoiPoint.this.yHM) {
                        MyPoiPoint.this.yHM = true;
                        MyPoiPoint.this.yHK.addPinView(MyPoiPoint.this, (double) f3, (double) f2);
                    } else {
                        MyPoiPoint.this.yHK.updateLocaitonPinLayout(MyPoiPoint.this, (double) f3, (double) f2);
                    }
                }
                AppMethodBeat.o(55835);
                return true;
            }
        };
        init(context);
        AppMethodBeat.o(55838);
    }

    public MyPoiPoint(Context context, d dVar) {
        this(context);
        this.yHK = dVar;
    }

    private void init(Context context) {
        AppMethodBeat.i(55839);
        LayoutInflater.from(context).inflate(R.layout.bie, (ViewGroup) this, true);
        this.yHL = com.tencent.mm.modelgeo.d.bca();
        edh();
        AppMethodBeat.o(55839);
    }

    public void setIMapView(d dVar) {
        this.yHK = dVar;
    }

    public final void edh() {
        AppMethodBeat.i(55840);
        Log.d("MicroMsg.MyPoiPoint", "enableLocation");
        this.yHL.b(this.gmA, true);
        AppMethodBeat.o(55840);
    }
}
