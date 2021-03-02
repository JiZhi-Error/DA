package com.tencent.mm.plugin.fav.ui.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;

public final class c extends LinearLayout {
    private View tmA;
    public View tmB;
    public View tmC;
    private a tmD;
    private boolean tmE = false;
    private boolean tmF = false;
    private int tmG;

    public interface a {
        void cWd();
    }

    public c(Context context) {
        super(context);
        AppMethodBeat.i(107522);
        setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.tmA = View.inflate(getContext(), R.layout.a7u, null);
        View inflate = View.inflate(getContext(), R.layout.a76, null);
        inflate.findViewById(R.id.g3n).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.fav.ui.widget.c.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(107520);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/widget/FavHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (c.this.tmG == 1 || c.this.tmG == 3) {
                    Log.i("MicroMsg.FavHeaderView", "click clear fav item");
                    if (c.this.tmD != null) {
                        c.this.tmD.cWd();
                    }
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/widget/FavHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(107520);
            }
        });
        this.tmB = inflate;
        View inflate2 = View.inflate(getContext(), R.layout.a7s, null);
        inflate2.findViewById(R.id.cdx).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.fav.ui.widget.c.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(107521);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/widget/FavHeaderView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.i("MicroMsg.FavHeaderView", "click retry item");
                List<g> cUV = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().cUV();
                if (cUV == null || cUV.isEmpty()) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/widget/FavHeaderView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(107521);
                    return;
                }
                for (g gVar : cUV) {
                    if (!gVar.cUy()) {
                        Log.w("MicroMsg.FavHeaderView", "item id is %d, status is not upload fail", Integer.valueOf(gVar.field_id));
                    } else {
                        com.tencent.mm.plugin.fav.a.b.l(gVar);
                    }
                }
                c.this.tmC.setVisibility(8);
                c.this.tmB.setVisibility(8);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/widget/FavHeaderView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(107521);
            }
        });
        this.tmC = inflate2;
        addView(this.tmA, new LinearLayout.LayoutParams((ViewGroup.MarginLayoutParams) layoutParams));
        addView(this.tmB, new LinearLayout.LayoutParams((ViewGroup.MarginLayoutParams) layoutParams));
        addView(this.tmC, new LinearLayout.LayoutParams((ViewGroup.MarginLayoutParams) layoutParams));
        AppMethodBeat.o(107522);
    }

    public final void mJ(boolean z) {
        AppMethodBeat.i(107523);
        this.tmA.setVisibility(z ? 0 : 8);
        AppMethodBeat.o(107523);
    }

    private void Ih(int i2) {
        AppMethodBeat.i(107524);
        this.tmG = i2;
        Log.i("MicroMsg.FavHeaderView", "showStatusBar status:".concat(String.valueOf(i2)));
        if (i2 == 0) {
            this.tmC.setVisibility(8);
            this.tmB.setVisibility(8);
            AppMethodBeat.o(107524);
        } else if (i2 == 1) {
            if (!this.tmE) {
                h.INSTANCE.a(14109, 1);
            }
            this.tmE = true;
            this.tmC.setVisibility(8);
            this.tmB.setVisibility(0);
            this.tmB.findViewById(R.id.g3r).setVisibility(0);
            this.tmB.findViewById(R.id.g3s).setVisibility(8);
            AppMethodBeat.o(107524);
        } else if (i2 == 2) {
            this.tmC.setVisibility(0);
            this.tmB.setVisibility(8);
            AppMethodBeat.o(107524);
        } else {
            if (i2 == 3) {
                if (!this.tmF) {
                    h.INSTANCE.a(14109, 0);
                }
                this.tmF = true;
                this.tmC.setVisibility(8);
                this.tmB.setVisibility(0);
                this.tmB.findViewById(R.id.g3r).setVisibility(8);
                this.tmB.findViewById(R.id.g3s).setVisibility(0);
            }
            AppMethodBeat.o(107524);
        }
    }

    public final void cWR() {
        long j2;
        boolean z;
        AppMethodBeat.i(107525);
        List<g> cUV = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().cUV();
        if (cUV != null) {
            j2 = 0;
            z = false;
            for (g gVar : cUV) {
                j2 = com.tencent.mm.plugin.fav.a.b.a(gVar) + j2;
                z = true;
            }
            Log.i("MicroMsg.FavHeaderView", "triggerStatusBar uploadFailedItemList size:%d,totalSize:%d", Integer.valueOf(cUV.size()), Long.valueOf(j2));
        } else {
            j2 = 0;
            z = false;
        }
        if (z) {
            if (j2 > com.tencent.mm.plugin.fav.a.b.cUh()) {
                Ih(1);
                AppMethodBeat.o(107525);
                return;
            }
            Ih(2);
            AppMethodBeat.o(107525);
        } else if (com.tencent.mm.plugin.fav.a.b.cUk()) {
            Ih(3);
            AppMethodBeat.o(107525);
        } else {
            Ih(0);
            AppMethodBeat.o(107525);
        }
    }

    public final void setCleanFavSpace(a aVar) {
        this.tmD = aVar;
    }
}
