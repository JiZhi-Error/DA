package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;

public class ag extends aj {
    public LinearLayout pwA;
    public LinearLayout pwz;

    @Override // com.tencent.mm.plugin.brandservice.ui.timeline.item.aj
    public final void a(View view, b bVar) {
        AppMethodBeat.i(5999);
        super.a(view, bVar);
        AppMethodBeat.o(5999);
    }

    @Override // com.tencent.mm.plugin.brandservice.ui.timeline.item.aj
    public final void cne() {
        AppMethodBeat.i(6000);
        if (this.puO == null) {
            AppMethodBeat.o(6000);
            return;
        }
        this.gvv = (ImageView) this.puO.findViewById(R.id.x1);
        this.pvG = (TextView) this.puO.findViewById(R.id.fz_);
        this.pxG = this.puO.findViewById(R.id.a98);
        this.timeTV = (TextView) this.puO.findViewById(R.id.in3);
        this.pxF = this.puO.findViewById(R.id.a54);
        this.pwz = (LinearLayout) this.puO.findViewById(R.id.a8m);
        this.pwA = (LinearLayout) this.puO.findViewById(R.id.a8c);
        AppMethodBeat.o(6000);
    }
}
