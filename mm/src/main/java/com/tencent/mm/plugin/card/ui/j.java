package com.tencent.mm.plugin.card.ui;

import android.graphics.Bitmap;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMVerticalTextView;
import com.tencent.mm.ui.base.p;
import java.util.ArrayList;

public final class j {
    public Bitmap kuJ;
    public p kuK = null;
    ImageView kuL;
    View kuM;
    View.OnClickListener kuO = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.card.ui.j.AnonymousClass1 */

        public final void onClick(View view) {
            AppMethodBeat.i(113548);
            b bVar = new b();
            bVar.bm(view);
            a.b("com/tencent/mm/plugin/card/ui/CardPopupWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (view.getId() == R.id.gel || view.getId() == R.id.geh) {
                if (j.this.kuK != null && j.this.kuK.isShowing()) {
                    j.this.kuK.dismiss();
                }
                if (!j.this.pQV.csz()) {
                    j.this.cwj();
                }
            }
            a.a(this, "com/tencent/mm/plugin/card/ui/CardPopupWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(113548);
        }
    };
    com.tencent.mm.plugin.card.base.b pQV;
    float pWC = 0.0f;
    public Bitmap pWu;
    boolean pZM = true;
    MMActivity qdG;
    Bitmap qdH = null;
    TextView qdI;
    TextView qdJ;
    View qdK;
    ImageView qdL;
    MMVerticalTextView qdM;
    MMVerticalTextView qdN;
    ArrayList<Bitmap> qdO = new ArrayList<>();
    String qdP = "";

    public j(MMActivity mMActivity) {
        AppMethodBeat.i(113550);
        this.qdG = mMActivity;
        AppMethodBeat.o(113550);
    }

    private void bd(float f2) {
        AppMethodBeat.i(113551);
        WindowManager.LayoutParams attributes = this.qdG.getWindow().getAttributes();
        attributes.screenBrightness = f2;
        this.qdG.getWindow().setAttributes(attributes);
        AppMethodBeat.o(113551);
    }

    public final void cwi() {
        AppMethodBeat.i(113552);
        if (this.pWC < 0.8f) {
            bd(0.8f);
        }
        AppMethodBeat.o(113552);
    }

    public final void cwj() {
        AppMethodBeat.i(113553);
        bd(this.pWC);
        AppMethodBeat.o(113553);
    }

    public final void cwk() {
        AppMethodBeat.i(113554);
        if (this.kuK != null && this.kuK.isShowing()) {
            this.kuL.setImageBitmap(this.kuJ);
        }
        AppMethodBeat.o(113554);
    }

    /* access modifiers changed from: package-private */
    public final void recycleBmpList() {
        AppMethodBeat.i(113555);
        if (this.qdO.size() > 2) {
            for (int size = this.qdO.size() - 1; size > 1; size--) {
                l.Z(this.qdO.remove(size));
            }
        }
        AppMethodBeat.o(113555);
    }
}
