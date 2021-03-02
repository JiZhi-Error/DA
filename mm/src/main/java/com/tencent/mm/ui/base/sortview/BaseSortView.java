package com.tencent.mm.ui.base.sortview;

import android.content.Context;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.sortview.c;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseSortView extends LinearLayout implements VerticalScrollBar.a {
    private VerticalScrollBar OZR;
    private View OZS;
    private c OZT = new c(getItemViewCreator());
    private AdapterView.OnItemLongClickListener OZU;
    private List<d> OZV = new ArrayList();
    public boolean OZW;
    public boolean OZX;
    private a OZY;
    private AdapterView.OnItemSelectedListener Yj;
    private AdapterView.OnItemClickListener awr;
    private int mMode;
    private ListView pqt;

    public interface a {
        void cz(List<d> list);
    }

    public abstract boolean a(String str, d dVar);

    public abstract c.a getItemViewCreator();

    public abstract ListView getListView();

    public abstract View getNoResultView();

    public abstract VerticalScrollBar getScrollBar();

    public abstract View inflate();

    public BaseSortView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        inflate();
        this.OZR = getScrollBar();
        this.pqt = getListView();
        this.OZS = getNoResultView();
        this.OZW = true;
        BF(true);
        this.pqt.setAdapter((ListAdapter) this.OZT);
        if (this.OZR != null) {
            this.OZR.setOnScrollBarTouchListener(this);
        }
        this.OZT.registerDataSetObserver(new DataSetObserver() {
            /* class com.tencent.mm.ui.base.sortview.BaseSortView.AnonymousClass1 */

            public final void onChanged() {
                AppMethodBeat.i(142687);
                if (BaseSortView.this.OZY != null) {
                    BaseSortView.this.OZY.cz(BaseSortView.this.OZT.OZV);
                }
                AppMethodBeat.o(142687);
            }
        });
        this.pqt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.ui.base.sortview.BaseSortView.AnonymousClass2 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(142688);
                b bVar = new b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/sortview/BaseSortView$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                if (BaseSortView.this.awr != null) {
                    BaseSortView.this.awr.onItemClick(adapterView, view, i2, j2);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/sortview/BaseSortView$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(142688);
            }
        });
        this.pqt.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            /* class com.tencent.mm.ui.base.sortview.BaseSortView.AnonymousClass3 */

            @Override // android.widget.AdapterView.OnItemLongClickListener
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(142689);
                if (BaseSortView.this.OZU != null) {
                    boolean onItemLongClick = BaseSortView.this.OZU.onItemLongClick(adapterView, view, i2, j2);
                    AppMethodBeat.o(142689);
                    return onItemLongClick;
                }
                AppMethodBeat.o(142689);
                return false;
            }
        });
        this.pqt.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            /* class com.tencent.mm.ui.base.sortview.BaseSortView.AnonymousClass4 */

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public final void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(142690);
                b bVar = new b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/sortview/BaseSortView$4", "android/widget/AdapterView$OnItemSelectedListener", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                if (BaseSortView.this.Yj != null) {
                    BaseSortView.this.Yj.onItemSelected(adapterView, view, i2, j2);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/sortview/BaseSortView$4", "android/widget/AdapterView$OnItemSelectedListener", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(142690);
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public final void onNothingSelected(AdapterView<?> adapterView) {
                AppMethodBeat.i(142691);
                if (BaseSortView.this.Yj != null) {
                    BaseSortView.this.Yj.onNothingSelected(adapterView);
                }
                AppMethodBeat.o(142691);
            }
        });
    }

    public void refresh() {
        this.OZT.refresh();
    }

    public c getAdapter() {
        return this.OZT;
    }

    public final void hy(List<d> list) {
        if (this.mMode == 0 && this.OZV != list) {
            this.OZV.clear();
            if (list != null) {
                this.OZV.addAll(list);
            }
        }
        this.OZT.hy(list);
    }

    public final void bmm(String str) {
        boolean z;
        boolean z2 = true;
        if (this.mMode != 1) {
            Log.w("MicroMsg.BaseSortView", "Can't doFilter successfully out of the search mode.");
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (!Util.isNullOrNil(str)) {
            arrayList.clear();
            for (d dVar : this.OZV) {
                if (a(str, dVar)) {
                    arrayList.add(dVar);
                }
            }
            z = true;
        } else {
            z = false;
        }
        A(this.pqt, z && arrayList.size() > 0);
        View view = this.OZS;
        if (!z || arrayList.size() > 0) {
            z2 = false;
        }
        A(view, z2);
        hy(arrayList);
    }

    public List<d> getDatas() {
        return this.OZT.OZV;
    }

    @Override // com.tencent.mm.ui.base.VerticalScrollBar.a
    public final void DP(String str) {
        int bmn = this.OZT.bmn(str);
        if (bmn >= 0) {
            this.pqt.setSelection(bmn);
        }
    }

    public AdapterView.OnItemClickListener getOnItemClickListener() {
        return this.awr;
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.awr = onItemClickListener;
    }

    public AdapterView.OnItemLongClickListener getOnItemLongClickListener() {
        return this.OZU;
    }

    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        this.OZU = onItemLongClickListener;
    }

    public AdapterView.OnItemSelectedListener getOnItemSelectedListener() {
        return this.Yj;
    }

    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.Yj = onItemSelectedListener;
    }

    public int getMode() {
        return this.mMode;
    }

    public void setMode(int i2) {
        if (i2 == 1) {
            this.mMode = 1;
            bmm("");
            return;
        }
        this.mMode = 0;
        A(this.OZS, false);
        A(this.pqt, true);
        hy(this.OZV);
    }

    protected static void A(View view, boolean z) {
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    public final void BF(boolean z) {
        this.OZX = z;
        if (this.OZR != null) {
            this.OZR.setVisibility(z ? 0 : 8);
        }
    }

    public final boolean gLU() {
        return this.OZW;
    }

    public final void gLV() {
        this.OZW = false;
        this.OZT.refresh();
    }

    public a getDataSetObserver() {
        return this.OZY;
    }

    public void setDataSetObserver(a aVar) {
        this.OZY = aVar;
    }
}
