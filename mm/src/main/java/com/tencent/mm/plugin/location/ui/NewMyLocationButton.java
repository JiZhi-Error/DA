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

public class NewMyLocationButton extends FrameLayout {
    private Context context;
    private b.a gmA = new b.a() {
        /* class com.tencent.mm.plugin.location.ui.NewMyLocationButton.AnonymousClass1 */

        @Override // com.tencent.mm.modelgeo.b.a
        public final boolean a(boolean z, float f2, float f3, int i2, double d2, double d3) {
            AppMethodBeat.i(55845);
            if (!z) {
                AppMethodBeat.o(55845);
                return false;
            }
            NewMyLocationButton.this.yHF.setVisibility(8);
            NewMyLocationButton.this.yHE.setVisibility(0);
            if (NewMyLocationButton.this.yHG != null && NewMyLocationButton.this.yHH) {
                NewMyLocationButton.this.yHG.getIController().setCenter((double) f3, (double) f2);
                if (NewMyLocationButton.this.yHG.getZoomLevel() < 15) {
                    NewMyLocationButton.this.yHG.getIController().setZoom(15);
                }
            }
            new MMHandler(Looper.getMainLooper()).post(new Runnable() {
                /* class com.tencent.mm.plugin.location.ui.NewMyLocationButton.AnonymousClass1.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(55844);
                    d.bca().c(NewMyLocationButton.this.gmA);
                    AppMethodBeat.o(55844);
                }
            });
            AppMethodBeat.o(55845);
            return false;
        }
    };
    private ImageButton yHE;
    private LinearLayout yHF;
    private com.tencent.mm.plugin.k.d yHG;
    private boolean yHH = true;

    public NewMyLocationButton(Context context2, AttributeSet attributeSet, int i2) {
        super(context2, attributeSet, i2);
        AppMethodBeat.i(55846);
        this.context = context2;
        init();
        AppMethodBeat.o(55846);
    }

    public NewMyLocationButton(Context context2, AttributeSet attributeSet) {
        super(context2, attributeSet);
        AppMethodBeat.i(55847);
        this.context = context2;
        init();
        AppMethodBeat.o(55847);
    }

    public void setAnimToSelf(boolean z) {
        this.yHH = z;
    }

    private void init() {
        AppMethodBeat.i(55848);
        View inflate = View.inflate(this.context, R.layout.bfw, this);
        this.yHE = (ImageButton) inflate.findViewById(R.id.fx8);
        this.yHF = (LinearLayout) inflate.findViewById(R.id.fxg);
        AppMethodBeat.o(55848);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(55849);
        this.yHE.setOnClickListener(onClickListener);
        AppMethodBeat.o(55849);
    }

    public void setProgressBar(com.tencent.mm.plugin.k.d dVar) {
        AppMethodBeat.i(55850);
        this.yHG = dVar;
        this.yHF.setVisibility(0);
        this.yHE.setVisibility(8);
        d.bca().b(this.gmA, true);
        AppMethodBeat.o(55850);
    }

    public void setSelected(boolean z) {
        AppMethodBeat.i(55851);
        if (z != this.yHE.isSelected()) {
            this.yHE.setSelected(z);
        }
        AppMethodBeat.o(55851);
    }
}
