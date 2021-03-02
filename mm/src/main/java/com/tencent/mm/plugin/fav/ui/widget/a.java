package com.tencent.mm.plugin.fav.ui.widget;

import android.view.View;
import android.view.ViewStub;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.sdk.platformtools.LocaleUtil;

public final class a {
    public Button kjo;
    public TextView qqI;
    public long tml = b.cUh();
    public boolean tmn = false;
    public View tmo;
    public AbstractC1050a tmp;

    /* renamed from: com.tencent.mm.plugin.fav.ui.widget.a$a  reason: collision with other inner class name */
    public interface AbstractC1050a {
        void cVF();
    }

    public a() {
        AppMethodBeat.i(107507);
        AppMethodBeat.o(107507);
    }

    public final void show() {
        AppMethodBeat.i(107508);
        if (!this.tmn) {
            if (this.tmo == null) {
                AppMethodBeat.o(107508);
                return;
            }
            if (this.tmo instanceof ViewStub) {
                this.tmo = ((ViewStub) this.tmo).inflate();
            }
            this.qqI = (TextView) this.tmo.findViewById(R.id.cbe);
            if (!LocaleUtil.isChineseAppLang()) {
                this.qqI.setTextSize(1, 14.0f);
            }
            this.kjo = (Button) this.tmo.findViewById(R.id.cbd);
            cWQ();
            this.kjo.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.fav.ui.widget.a.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(107506);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/widget/FavCleanFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (a.this.tmp == null) {
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/widget/FavCleanFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(107506);
                        return;
                    }
                    a.this.tmp.cVF();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/widget/FavCleanFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(107506);
                }
            });
            this.tmn = true;
        }
        if (this.tmo.getVisibility() != 0) {
            this.tmo.setVisibility(0);
            this.tmo.startAnimation(AnimationUtils.loadAnimation(this.tmo.getContext(), R.anim.br));
        }
        AppMethodBeat.o(107508);
    }

    public final void hide() {
        AppMethodBeat.i(107509);
        if (!this.tmn) {
            AppMethodBeat.o(107509);
            return;
        }
        if (this.tmo.getVisibility() != 8) {
            this.tmo.setVisibility(8);
            this.tmo.startAnimation(AnimationUtils.loadAnimation(this.tmo.getContext(), R.anim.bs));
        }
        AppMethodBeat.o(107509);
    }

    public final void cWQ() {
        AppMethodBeat.i(107510);
        this.qqI.setText(this.qqI.getContext().getString(R.string.c8b, b.DP(this.tml)));
        this.kjo.setEnabled(false);
        AppMethodBeat.o(107510);
    }
}
