package com.tencent.mm.plugin.location.ui.impl;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.plugin.location.ui.impl.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.at;

public class PickPoi extends FrameLayout {
    private Animation FN;
    private Context context;
    protected c yKY;
    public c.a yLe = new c.a() {
        /* class com.tencent.mm.plugin.location.ui.impl.PickPoi.AnonymousClass2 */

        @Override // com.tencent.mm.modelgeo.c.a
        public final void b(Addr addr) {
            AppMethodBeat.i(56081);
            Log.d("MicroMsg.PickPoi", "onLocationAddr %s", addr.toString());
            if (PickPoi.this.yMC == null) {
                Log.i("MicroMsg.PickPoi", "error, empty poi!");
                AppMethodBeat.o(56081);
                return;
            }
            if (PickPoi.this.yMC.c(addr) && PickPoi.this.yME != null) {
                if (PickPoi.this.yMF != null) {
                    PickPoi.this.yMF.a(PickPoi.this.yMC);
                }
                PickPoi.this.yME.notifyDataSetChanged();
            }
            AppMethodBeat.o(56081);
        }
    };
    private View yMB;
    private f yMC = new f();
    boolean yMD = true;
    private e yME = null;
    c.b yMF;

    public PickPoi(Context context2) {
        super(context2);
        AppMethodBeat.i(56082);
        init(context2);
        AppMethodBeat.o(56082);
    }

    public PickPoi(Context context2, AttributeSet attributeSet) {
        super(context2, attributeSet);
        AppMethodBeat.i(56083);
        init(context2);
        AppMethodBeat.o(56083);
    }

    public PickPoi(Context context2, AttributeSet attributeSet, int i2) {
        super(context2, attributeSet, i2);
        AppMethodBeat.i(56084);
        init(context2);
        AppMethodBeat.o(56084);
    }

    private void init(final Context context2) {
        AppMethodBeat.i(56085);
        this.context = context2;
        this.yKY = com.tencent.mm.modelgeo.c.bbX();
        this.FN = AnimationUtils.loadAnimation(context2, R.anim.fc);
        final View inflate = LayoutInflater.from(context2).inflate(R.layout.b2c, (ViewGroup) this, true);
        this.yMB = inflate.findViewById(R.id.eq8);
        post(new Runnable() {
            /* class com.tencent.mm.plugin.location.ui.impl.PickPoi.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(56080);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) inflate.getLayoutParams();
                layoutParams.bottomMargin = ((int) ((((double) PickPoi.this.yMB.getHeight()) / 2.0d) + 0.5d)) + at.fromDPToPix(context2, 20);
                inflate.setLayoutParams(layoutParams);
                AppMethodBeat.o(56080);
            }
        });
        AppMethodBeat.o(56085);
    }

    public final void l(double d2, double d3) {
        AppMethodBeat.i(56086);
        this.yMC = new f();
        this.yMC.type = 3;
        this.yMC.mName = this.context.getResources().getString(R.string.ekf);
        this.yMC.cik = d2;
        this.yMC.cil = d3;
        this.yMC.yMN = "";
        this.yKY.a(this.yLe);
        this.yKY.a(d2, d3, this.yLe);
        this.yMD = true;
        AppMethodBeat.o(56086);
    }

    public void setAdapter(e eVar) {
        this.yME = eVar;
    }

    public f getPoi() {
        return this.yMC;
    }

    public final void play() {
        AppMethodBeat.i(182075);
        this.yMB.clearAnimation();
        this.yMB.startAnimation(this.FN);
        AppMethodBeat.o(182075);
    }

    public void setLocationArrow(int i2) {
        AppMethodBeat.i(56087);
        ((ImageView) this.yMB).setImageResource(i2);
        AppMethodBeat.o(56087);
    }

    public void setOnCurPoiGet(c.b bVar) {
        this.yMF = bVar;
    }
}
