package com.tencent.mm.plugin.appbrand.ad.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.a.g;
import com.tencent.mm.plugin.appbrand.ad.e;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.sdk.platformtools.Util;

public class AppBrandMenuFooter extends LinearLayout {
    private View kHq;

    public AppBrandMenuFooter(Context context) {
        super(context);
        AppMethodBeat.i(160568);
        bh(context);
        AppMethodBeat.o(160568);
    }

    public AppBrandMenuFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(160569);
        bh(context);
        AppMethodBeat.o(160569);
    }

    private void bh(Context context) {
        AppMethodBeat.i(160570);
        this.kHq = LayoutInflater.from(context).inflate(R.layout.ea, this);
        AppMethodBeat.o(160570);
    }

    public void setPageView(ag agVar) {
        AppMethodBeat.i(160571);
        ((TextView) this.kHq.findViewById(R.id.ft7)).setText(Util.nullAsNil(e.Uy(agVar.getAppId())));
        b.aXY().a((ImageView) this.kHq.findViewById(R.id.dt5), e.Uz(agVar.getAppId()), R.drawable.d3, g.iJB);
        AppMethodBeat.o(160571);
    }
}
