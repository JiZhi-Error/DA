package com.tencent.mm.plugin.appbrand.page;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.luggage.sdk.d.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.plugin.appbrand.widget.g;

@SuppressLint({"ViewConstructor"})
public final class i extends LinearLayout {
    private ImageView nnL = ((ImageView) findViewById(R.id.nw));
    private TextView nnM = ((TextView) findViewById(R.id.ny));
    private Button nnN = ((Button) findViewById(R.id.nv));

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i(Context context, d dVar) {
        super(context);
        boolean z = true;
        AppMethodBeat.i(147440);
        inflate(getContext(), R.layout.dq, this);
        this.nnM.setText(getResources().getString(R.string.et0, dVar.OM().brandName));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.nnL.getLayoutParams();
        if ((dVar.getAppConfig() == null || dVar.getAppConfig().bzF() == null || !dVar.getAppConfig().bzF().bzL()) ? false : z) {
            layoutParams.topMargin = a.aH(getContext(), R.dimen.ph);
            this.nnL.setLayoutParams(layoutParams);
            requestLayout();
        }
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        this.nnL.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        b.aXY().a(this.nnL, dVar.OM().jyi, ((g) dVar.af(g.class)).cab(), com.tencent.mm.modelappbrand.a.g.iJB);
        this.nnN.setVisibility(8);
        setBackgroundColor(-1);
        AppMethodBeat.o(147440);
    }
}
