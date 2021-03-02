package com.tencent.mm.plugin.appbrand.widget.input.panel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.aa;

public class AppBrandSmileyGrid extends GridView {
    AdapterView.OnItemClickListener awr = new AdapterView.OnItemClickListener() {
        /* class com.tencent.mm.plugin.appbrand.widget.input.panel.AppBrandSmileyGrid.AnonymousClass1 */

        @Override // android.widget.AdapterView.OnItemClickListener
        public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            AppMethodBeat.i(49929);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(adapterView);
            bVar.bm(view);
            bVar.pH(i2);
            bVar.zo(j2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/input/panel/AppBrandSmileyGrid$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
            if (i2 == AppBrandSmileyGrid.this.owT.getCount() - 1) {
                if (AppBrandSmileyGrid.this.owP.oxg != null) {
                    AppBrandSmileyGrid.this.owP.oxg.aHC();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/input/panel/AppBrandSmileyGrid$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(49929);
            } else if ((AppBrandSmileyGrid.this.owW * (AppBrandSmileyGrid.this.owV - 1)) + i2 >= AppBrandSmileyGrid.this.owU) {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/input/panel/AppBrandSmileyGrid$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(49929);
            } else {
                int i3 = (AppBrandSmileyGrid.this.owW * (AppBrandSmileyGrid.this.owV - 1)) + i2;
                if (AppBrandSmileyGrid.this.owP.oxg != null) {
                    AppBrandSmileyGrid.this.owP.oxg.append(AppBrandSmileyGrid.this.owP.cbY().An(i3));
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/input/panel/AppBrandSmileyGrid$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(49929);
            }
        }
    };
    int gOF = 0;
    private c owP;
    a owT;
    int owU;
    int owV = 0;
    int owW;
    int owX = 0;
    int owY = 0;

    public AppBrandSmileyGrid(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(49933);
        AppMethodBeat.o(49933);
    }

    /* access modifiers changed from: package-private */
    public int getRowSpacing() {
        return this.owX;
    }

    public void setPanelManager(c cVar) {
        this.owP = cVar;
    }

    /* access modifiers changed from: package-private */
    public class a extends BaseAdapter {
        private a() {
        }

        /* synthetic */ a(AppBrandSmileyGrid appBrandSmileyGrid, byte b2) {
            this();
        }

        public final int getCount() {
            AppMethodBeat.i(49930);
            int i2 = AppBrandSmileyGrid.this.owV;
            AppMethodBeat.o(49930);
            return i2;
        }

        public final Object getItem(int i2) {
            return null;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            b bVar;
            AppMethodBeat.i(49931);
            if (view == null || view.getTag() == null) {
                view = aa.jQ(new ContextThemeWrapper(AppBrandSmileyGrid.this.getContext(), (int) R.style.i4)).inflate(R.layout.gy, (ViewGroup) null);
                view.setLayoutParams(new AbsListView.LayoutParams(-1, ((AppBrandSmileyGrid.this.owP.oxh - com.tencent.mm.cb.a.aG(AppBrandSmileyGrid.this.getContext(), R.dimen.i2)) - com.tencent.mm.cb.a.aG(AppBrandSmileyGrid.this.getContext(), R.dimen.a35)) / AppBrandSmileyGrid.this.gOF));
                bVar = new b(view);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            if (i2 == getCount() - 1) {
                bVar.nnL.setImageResource(R.drawable.rg);
                bVar.nnL.setContentDescription(AppBrandSmileyGrid.this.getContext().getString(R.string.bld));
            } else {
                int i3 = ((AppBrandSmileyGrid.this.owV - 1) * AppBrandSmileyGrid.this.owW) + i2;
                if (i3 > AppBrandSmileyGrid.this.owU - 1) {
                    bVar.nnL.setImageDrawable(null);
                } else {
                    bVar.nnL.setImageDrawable(AppBrandSmileyGrid.this.owP.cbY().Al(i3));
                }
            }
            AppMethodBeat.o(49931);
            return view;
        }
    }

    static final class b {
        ImageView nnL;

        public b(View view) {
            AppMethodBeat.i(49932);
            this.nnL = (ImageView) view.findViewById(R.id.ur);
            AppMethodBeat.o(49932);
        }
    }
}
