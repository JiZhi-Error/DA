package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.p;
import com.tencent.mm.ag.v;
import com.tencent.mm.al.ag;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.z;

public class aj extends a {
    public ImageView gvv;
    public Context mContext;
    public View ptQ;
    public View puO;
    public TextView pvG;
    public b pxE;
    public View pxF;
    public View pxG;
    private View.OnClickListener pxx = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.brandservice.ui.timeline.item.aj.AnonymousClass1 */

        public final void onClick(View view) {
            AppMethodBeat.i(6019);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            z R = ag.ban().R(((com.tencent.mm.plugin.brandservice.a.a) g.af(com.tencent.mm.plugin.brandservice.a.a.class)).dq(view), "msgId");
            if (R != null) {
                aj.this.pxE.pqZ.f(R, 4);
            } else {
                Log.w("MicroMsg.BizTimeLineItem", "mediaIconClickListener info is null");
            }
            a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(6019);
        }
    };
    public TextView timeTV;

    public aj() {
        AppMethodBeat.i(6020);
        AppMethodBeat.o(6020);
    }

    public final void a(Context context, b bVar) {
        this.mContext = context;
        this.pxE = bVar;
    }

    public void a(View view, b bVar) {
        AppMethodBeat.i(6021);
        a(view.getContext(), bVar);
        AppMethodBeat.o(6021);
    }

    public void cne() {
        AppMethodBeat.i(6022);
        if (this.puO == null) {
            AppMethodBeat.o(6022);
            return;
        }
        this.gvv = (ImageView) this.puO.findViewById(R.id.x1);
        this.pvG = (TextView) this.puO.findViewById(R.id.fz_);
        this.pxG = this.puO.findViewById(R.id.a98);
        this.timeTV = (TextView) this.puO.findViewById(R.id.in3);
        this.pxF = this.puO.findViewById(R.id.a54);
        AppMethodBeat.o(6022);
    }

    public void dw(View view) {
        AppMethodBeat.i(6023);
        W(view, b.prq);
        AppMethodBeat.o(6023);
    }

    public static void W(View view, int i2) {
        AppMethodBeat.i(6024);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = i2;
        view.setLayoutParams(layoutParams);
        AppMethodBeat.o(6024);
    }

    public final boolean a(ai aiVar, z zVar, v vVar) {
        AppMethodBeat.i(6025);
        boolean a2 = a(aiVar.ptX, aiVar.ptY, zVar, vVar);
        AppMethodBeat.o(6025);
        return a2;
    }

    public final boolean a(View view, TextView textView, z zVar, v vVar) {
        AppMethodBeat.i(6026);
        if (vVar == null || Util.isNullOrNil(vVar.url)) {
            view.setVisibility(8);
            a(zVar, vVar, view, textView, 0);
            AppMethodBeat.o(6026);
            return false;
        }
        p ahw = ((com.tencent.mm.plugin.brandservice.a.b) g.af(com.tencent.mm.plugin.brandservice.a.b.class)).ahw(vVar.url);
        String str = "";
        if (ahw != null && ahw.izY != null && !Util.isNullOrNil(ahw.izY.izW)) {
            str = ahw.izY.izW;
        } else if (!(ahw == null || ahw.izZ == null || Util.isNullOrNil(ahw.izZ.izS))) {
            str = ahw.izZ.izS;
        }
        if (!Util.isNullOrNil(str)) {
            view.setVisibility(0);
            textView.setText(str);
            a(zVar, vVar, view, textView, ahw.izZ.izT);
            AppMethodBeat.o(6026);
            return true;
        }
        view.setVisibility(8);
        a(zVar, vVar, view, textView, 0);
        AppMethodBeat.o(6026);
        return false;
    }

    public void a(ImageView imageView, z zVar, int i2, String str) {
        AppMethodBeat.i(6027);
        ((com.tencent.mm.plugin.brandservice.a.a) g.af(com.tencent.mm.plugin.brandservice.a.a.class)).a(imageView, zVar.field_msgId, str, zVar.field_content, i2);
        imageView.setOnClickListener(this.pxx);
        AppMethodBeat.o(6027);
    }

    public void a(z zVar, v vVar, View view, TextView textView, int i2) {
    }
}
