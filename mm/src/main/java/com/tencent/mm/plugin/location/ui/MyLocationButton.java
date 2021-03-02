package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.modelgeo.b;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.sdk.platformtools.MMHandler;

public class MyLocationButton extends FrameLayout {
    private Context context;
    public b.a gmA = new b.a() {
        /* class com.tencent.mm.plugin.location.ui.MyLocationButton.AnonymousClass1 */

        @Override // com.tencent.mm.modelgeo.b.a
        public final boolean a(boolean z, float f2, float f3, int i2, double d2, double d3) {
            AppMethodBeat.i(55826);
            if (!z) {
                AppMethodBeat.o(55826);
                return false;
            }
            MyLocationButton.this.yHF.setVisibility(8);
            MyLocationButton.this.yHE.setVisibility(0);
            if (MyLocationButton.this.yHG != null && MyLocationButton.this.yHH) {
                MyLocationButton.this.yHG.getIController().setCenter((double) f3, (double) f2);
                if (MyLocationButton.this.yHG.getZoomLevel() < 15) {
                    MyLocationButton.this.yHG.getIController().setZoom(15);
                }
            }
            new MMHandler(Looper.getMainLooper()).post(new Runnable() {
                /* class com.tencent.mm.plugin.location.ui.MyLocationButton.AnonymousClass1.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(55825);
                    d.bca().c(MyLocationButton.this.gmA);
                    AppMethodBeat.o(55825);
                }
            });
            AppMethodBeat.o(55826);
            return false;
        }
    };
    private ImageButton yHE;
    private LinearLayout yHF;
    private com.tencent.mm.plugin.k.d yHG;
    private boolean yHH = true;

    public MyLocationButton(Context context2, AttributeSet attributeSet, int i2) {
        super(context2, attributeSet, i2);
        AppMethodBeat.i(55827);
        this.context = context2;
        init();
        AppMethodBeat.o(55827);
    }

    public MyLocationButton(Context context2, AttributeSet attributeSet) {
        super(context2, attributeSet);
        AppMethodBeat.i(55828);
        this.context = context2;
        init();
        AppMethodBeat.o(55828);
    }

    public void setAnimToSelf(boolean z) {
        this.yHH = z;
    }

    private void init() {
        AppMethodBeat.i(55829);
        View inflate = View.inflate(this.context, R.layout.beq, this);
        this.yHE = (ImageButton) inflate.findViewById(R.id.eq4);
        this.yHF = (LinearLayout) inflate.findViewById(R.id.gl_);
        AppMethodBeat.o(55829);
    }

    public final void edf() {
        AppMethodBeat.i(55830);
        this.yHE.setImageResource(R.drawable.bkv);
        AppMethodBeat.o(55830);
    }

    public final void edg() {
        AppMethodBeat.i(55831);
        this.yHE.setImageResource(R.drawable.bkw);
        AppMethodBeat.o(55831);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(55832);
        this.yHE.setOnClickListener(onClickListener);
        AppMethodBeat.o(55832);
    }

    public void setProgressBar(com.tencent.mm.plugin.k.d dVar) {
        AppMethodBeat.i(55833);
        this.yHG = dVar;
        this.yHF.setVisibility(0);
        this.yHE.setVisibility(8);
        d.bca().b(this.gmA, true);
        AppMethodBeat.o(55833);
    }

    public ImageButton getMyLocationBtn() {
        return this.yHE;
    }

    public LinearLayout getProgressBar() {
        return this.yHF;
    }
}
