package com.tencent.luggage.game.widget.input;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.widget.input.n;
import com.tencent.mm.plugin.appbrand.widget.input.w;
import com.tencent.mm.sdk.platformtools.Log;

public final class a extends w {
    private static final int VIEW_ID = R.id.o2;
    public C0175a cxQ;
    public WAGamePanelInputEditText cxR;
    private View.OnClickListener cxS;

    private a(Context context) {
        super(context, null);
        AppMethodBeat.i(130711);
        Ag(VIEW_ID);
        AppMethodBeat.o(130711);
    }

    public static a cd(View view) {
        AppMethodBeat.i(130712);
        a aVar = (a) view.getRootView().findViewById(VIEW_ID);
        AppMethodBeat.o(130712);
        return aVar;
    }

    public static a ce(View view) {
        a aVar;
        AppMethodBeat.i(130713);
        n cW = n.cW(view);
        n.cY(view);
        w dc = w.dc(view);
        if (dc != null && (dc.getParent() instanceof ViewGroup)) {
            ((ViewGroup) dc.getParent()).removeView(dc);
        }
        a cd = cd(view);
        if (cd == null) {
            if (view instanceof a) {
                aVar = (a) view;
            } else {
                aVar = new a(view.getContext());
            }
            cW.cX(aVar);
        } else {
            aVar = cd;
        }
        AppMethodBeat.o(130713);
        return aVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.w
    public final void Np() {
        AppMethodBeat.i(130714);
        ce(this);
        AppMethodBeat.o(130714);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.w
    public final void Nq() {
        AppMethodBeat.i(130715);
        this.cxQ.setIsHide(false);
        AppMethodBeat.o(130715);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.w
    public final void Nr() {
        boolean z;
        int i2 = 0;
        AppMethodBeat.i(130716);
        View confirmButton = this.cxQ.getConfirmButton();
        if ((this.cxR.getInputType() & 131072) > 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            i2 = 8;
        }
        confirmButton.setVisibility(i2);
        AppMethodBeat.o(130716);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.w
    public final WAGamePanelInputEditText getAttachedEditText() {
        AppMethodBeat.i(130717);
        WAGamePanelInputEditText wAGamePanelInputEditText = (WAGamePanelInputEditText) super.getAttachedEditText();
        AppMethodBeat.o(130717);
        return wAGamePanelInputEditText;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.w
    public final void show() {
        AppMethodBeat.i(130718);
        this.oum = this.cxR;
        this.cxR.requestFocus();
        super.show();
        AppMethodBeat.o(130718);
    }

    public final void setOnConfirmClickListener(View.OnClickListener onClickListener) {
        this.cxS = onClickListener;
    }

    /* renamed from: com.tencent.luggage.game.widget.input.a$a  reason: collision with other inner class name */
    public static final class C0175a extends FrameLayout implements w.a {
        public View cxV;

        public final View getConfirmButton() {
            AppMethodBeat.i(130707);
            if (this.cxV == null) {
                this.cxV = findViewById(R.id.dfe);
            }
            View view = this.cxV;
            AppMethodBeat.o(130707);
            return view;
        }

        public C0175a(Context context) {
            super(context);
            AppMethodBeat.i(130708);
            LayoutInflater.from(context).inflate(R.layout.dy, (ViewGroup) this, true);
            ((Button) findViewById(R.id.dfe)).setText(R.string.a17);
            AppMethodBeat.o(130708);
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.input.w.a
        public final void setIsHide(boolean z) {
            AppMethodBeat.i(130709);
            setVisibility(z ? 8 : 0);
            AppMethodBeat.o(130709);
        }

        public final void setEditBarMargins(int i2) {
            AppMethodBeat.i(263558);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cxV.getLayoutParams();
            Log.i("MicroMsg.WAGameInputPanel", "EditBar setmConfirmButtonPadding tolerate(%d),rightMargin(%d).", Integer.valueOf(i2), Integer.valueOf(layoutParams.rightMargin));
            layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.rightMargin + i2, layoutParams.bottomMargin);
            this.cxV.setLayoutParams(layoutParams);
            AppMethodBeat.o(263558);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.w
    public final /* synthetic */ View Ns() {
        AppMethodBeat.i(130720);
        C0175a aVar = new C0175a(getContext());
        this.cxR = (WAGamePanelInputEditText) aVar.findViewById(R.id.dff);
        aVar.getConfirmButton().setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.luggage.game.widget.input.a.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(130705);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/luggage/game/widget/input/WAGameInputPanel$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (a.this.cxS != null) {
                    a.this.cxS.onClick(view);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/luggage/game/widget/input/WAGameInputPanel$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(130705);
            }
        });
        this.oum = this.cxR;
        this.cxQ = aVar;
        AppMethodBeat.o(130720);
        return aVar;
    }
}
