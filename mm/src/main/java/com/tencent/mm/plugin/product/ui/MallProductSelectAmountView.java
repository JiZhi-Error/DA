package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;

public class MallProductSelectAmountView extends LinearLayout {
    private ImageView Bbj = null;
    private ImageView Bbk = null;
    private int Bbl = Integer.MAX_VALUE;
    private int Bbm = 1;
    private int Bbn = 1;
    private int Bbo = this.Bbn;
    private a Bbp = null;
    private TextView jUP = null;

    public interface a {
        void hO(int i2, int i3);

        void iZ(int i2);
    }

    static /* synthetic */ int e(MallProductSelectAmountView mallProductSelectAmountView) {
        int i2 = mallProductSelectAmountView.Bbo;
        mallProductSelectAmountView.Bbo = i2 + 1;
        return i2;
    }

    static /* synthetic */ boolean f(MallProductSelectAmountView mallProductSelectAmountView) {
        AppMethodBeat.i(67010);
        boolean eDE = mallProductSelectAmountView.eDE();
        AppMethodBeat.o(67010);
        return eDE;
    }

    static /* synthetic */ int i(MallProductSelectAmountView mallProductSelectAmountView) {
        int i2 = mallProductSelectAmountView.Bbo;
        mallProductSelectAmountView.Bbo = i2 - 1;
        return i2;
    }

    public void setOnAmountChangeListener(a aVar) {
        this.Bbp = aVar;
    }

    public MallProductSelectAmountView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(67003);
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.bj6, (ViewGroup) this, true);
        this.jUP = (TextView) inflate.findViewById(R.id.f9c);
        this.Bbj = (ImageView) inflate.findViewById(R.id.f9b);
        this.Bbk = (ImageView) inflate.findViewById(R.id.f9h);
        this.jUP.setText(new StringBuilder().append(this.Bbo).toString());
        this.Bbj.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.product.ui.MallProductSelectAmountView.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(67001);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/product/ui/MallProductSelectAmountView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (MallProductSelectAmountView.this.Bbo + 1 > MallProductSelectAmountView.this.Bbl) {
                    if (MallProductSelectAmountView.this.Bbp != null) {
                        MallProductSelectAmountView.this.Bbp.hO(MallProductSelectAmountView.this.Bbo, MallProductSelectAmountView.this.Bbm);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/product/ui/MallProductSelectAmountView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(67001);
                    return;
                }
                MallProductSelectAmountView.e(MallProductSelectAmountView.this);
                if (MallProductSelectAmountView.f(MallProductSelectAmountView.this)) {
                    MallProductSelectAmountView.this.jUP.setText(new StringBuilder().append(MallProductSelectAmountView.this.Bbo).toString());
                }
                if (MallProductSelectAmountView.this.Bbp != null) {
                    MallProductSelectAmountView.this.Bbp.iZ(MallProductSelectAmountView.this.Bbo);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/product/ui/MallProductSelectAmountView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(67001);
            }
        });
        this.Bbk.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.product.ui.MallProductSelectAmountView.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(67002);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/product/ui/MallProductSelectAmountView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (MallProductSelectAmountView.this.Bbo - 1 < MallProductSelectAmountView.this.Bbn) {
                    if (MallProductSelectAmountView.this.Bbp != null) {
                        MallProductSelectAmountView.this.Bbp.hO(MallProductSelectAmountView.this.Bbo, 2);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/product/ui/MallProductSelectAmountView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(67002);
                    return;
                }
                MallProductSelectAmountView.i(MallProductSelectAmountView.this);
                if (MallProductSelectAmountView.f(MallProductSelectAmountView.this)) {
                    MallProductSelectAmountView.this.jUP.setText(new StringBuilder().append(MallProductSelectAmountView.this.Bbo).toString());
                }
                MallProductSelectAmountView.f(MallProductSelectAmountView.this);
                if (MallProductSelectAmountView.this.Bbp != null) {
                    MallProductSelectAmountView.this.Bbp.iZ(MallProductSelectAmountView.this.Bbo);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/product/ui/MallProductSelectAmountView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(67002);
            }
        });
        AppMethodBeat.o(67003);
    }

    public void setAmount(int i2) {
        AppMethodBeat.i(67004);
        this.Bbo = i2;
        if (eDE()) {
            this.jUP.setText(new StringBuilder().append(this.Bbo).toString());
            if (this.Bbp != null) {
                this.Bbp.iZ(this.Bbo);
            }
        }
        AppMethodBeat.o(67004);
    }

    private boolean eDE() {
        AppMethodBeat.i(67005);
        if (this.Bbo > this.Bbl) {
            this.Bbo = this.Bbl;
            if (this.Bbp != null) {
                this.Bbp.iZ(this.Bbo);
            }
            if (this.Bbp != null) {
                this.Bbp.hO(this.Bbo, this.Bbm);
            }
            this.jUP.setText(new StringBuilder().append(this.Bbo).toString());
            AppMethodBeat.o(67005);
            return false;
        }
        if (this.Bbo > this.Bbn) {
            this.Bbk.setEnabled(true);
        } else if (this.Bbo == this.Bbn) {
            this.Bbk.setEnabled(false);
        } else {
            this.Bbk.setEnabled(false);
            this.Bbo = this.Bbn;
            if (this.Bbp != null) {
                this.Bbp.iZ(this.Bbo);
            }
            if (this.Bbp != null) {
                this.Bbp.hO(this.Bbo, 2);
            }
            this.jUP.setText(new StringBuilder().append(this.Bbo).toString());
            AppMethodBeat.o(67005);
            return false;
        }
        AppMethodBeat.o(67005);
        return true;
    }

    public void setAddEnable(boolean z) {
        AppMethodBeat.i(67006);
        this.Bbj.setEnabled(z);
        AppMethodBeat.o(67006);
    }

    public void setRemoveEnable(boolean z) {
        AppMethodBeat.i(67007);
        this.Bbk.setEnabled(z);
        AppMethodBeat.o(67007);
    }

    public final void hN(int i2, int i3) {
        AppMethodBeat.i(67008);
        if (i2 > i3) {
            this.Bbm = 3;
            this.Bbl = i3;
        } else {
            this.Bbm = 1;
            this.Bbl = i2;
        }
        eDE();
        if (this.Bbp != null) {
            this.Bbp.iZ(this.Bbo);
        }
        AppMethodBeat.o(67008);
    }

    public void setMinAmount(int i2) {
        AppMethodBeat.i(67009);
        this.Bbn = i2;
        eDE();
        AppMethodBeat.o(67009);
    }
}
