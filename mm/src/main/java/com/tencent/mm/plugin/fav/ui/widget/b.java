package com.tencent.mm.plugin.fav.ui.widget;

import android.view.View;
import android.view.ViewStub;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public final class b {
    private boolean tmn = false;
    private View tmo;
    private ImageButton tms;
    private ImageButton tmt;
    private ImageButton tmu;
    private View tmv;
    private View tmw;
    private View tmx;
    public a tmy;

    public interface a {
        void cVF();

        void cVS();

        void cVT();
    }

    public final void dQ(View view) {
        this.tmn = false;
        this.tmo = view;
    }

    public final void mI(boolean z) {
        AppMethodBeat.i(107517);
        if (!this.tmn) {
            if (this.tmo == null) {
                AppMethodBeat.o(107517);
                return;
            }
            if (this.tmo instanceof ViewStub) {
                this.tmo = ((ViewStub) this.tmo).inflate();
            }
            this.tmv = this.tmo.findViewById(R.id.cd1);
            this.tmw = this.tmo.findViewById(R.id.cd2);
            this.tmx = this.tmo.findViewById(R.id.cd3);
            this.tms = (ImageButton) this.tmo.findViewById(R.id.cbu);
            this.tms.setEnabled(false);
            this.tms.setContentDescription(this.tms.getContext().getString(R.string.hro));
            this.tms.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.fav.ui.widget.b.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(107514);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/widget/FavEditFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (b.this.tmy == null) {
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/widget/FavEditFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(107514);
                        return;
                    }
                    b.this.tmy.cVS();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/widget/FavEditFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(107514);
                }
            });
            this.tmt = (ImageButton) this.tmo.findViewById(R.id.cbr);
            this.tmt.setEnabled(false);
            this.tmt.setContentDescription(this.tmt.getContext().getString(R.string.bq2));
            this.tmt.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.fav.ui.widget.b.AnonymousClass2 */

                public final void onClick(View view) {
                    AppMethodBeat.i(107515);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/widget/FavEditFooter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (b.this.tmy == null) {
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/widget/FavEditFooter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(107515);
                        return;
                    }
                    b.this.tmy.cVT();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/widget/FavEditFooter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(107515);
                }
            });
            if (z) {
                this.tmw.setVisibility(8);
                this.tmt.setVisibility(8);
            }
            this.tmu = (ImageButton) this.tmo.findViewById(R.id.cbs);
            this.tmu.setEnabled(false);
            this.tmu.setContentDescription(this.tmu.getContext().getString(R.string.blb));
            this.tmu.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.fav.ui.widget.b.AnonymousClass3 */

                public final void onClick(View view) {
                    AppMethodBeat.i(107516);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/widget/FavEditFooter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (b.this.tmy == null) {
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/widget/FavEditFooter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(107516);
                        return;
                    }
                    b.this.tmy.cVF();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/widget/FavEditFooter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(107516);
                }
            });
            this.tmn = true;
        }
        if (this.tmo.getVisibility() != 0) {
            this.tmo.setVisibility(0);
            this.tmo.startAnimation(AnimationUtils.loadAnimation(this.tmo.getContext(), R.anim.br));
        }
        AppMethodBeat.o(107517);
    }

    public final void hide() {
        AppMethodBeat.i(107518);
        if (!this.tmn) {
            AppMethodBeat.o(107518);
            return;
        }
        if (this.tmo.getVisibility() != 8) {
            this.tmo.setVisibility(8);
            this.tmo.startAnimation(AnimationUtils.loadAnimation(this.tmo.getContext(), R.anim.bs));
        }
        AppMethodBeat.o(107518);
    }

    public final void gf(boolean z) {
        AppMethodBeat.i(107519);
        if (!this.tmn) {
            AppMethodBeat.o(107519);
            return;
        }
        this.tms.setEnabled(z);
        this.tmt.setEnabled(z);
        this.tmu.setEnabled(z);
        AppMethodBeat.o(107519);
    }
}
