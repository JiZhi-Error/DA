package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import junit.framework.Assert;

public final class MMGridPaperGridView extends GridView {
    private AdapterView.OnItemClickListener FMs = new AdapterView.OnItemClickListener() {
        /* class com.tencent.mm.ui.base.MMGridPaperGridView.AnonymousClass1 */

        @Override // android.widget.AdapterView.OnItemClickListener
        public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            AppMethodBeat.i(141986);
            b bVar = new b();
            bVar.bm(adapterView);
            bVar.bm(view);
            bVar.pH(i2);
            bVar.zo(j2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/MMGridPaperGridView$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
            if (MMGridPaperGridView.this.OQU == null) {
                Log.w("MicroMsg.MMGridPaperGridView", "on item click, but main adapter is null");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/MMGridPaperGridView$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(141986);
                return;
            }
            j unused = MMGridPaperGridView.this.OQU;
            int unused2 = MMGridPaperGridView.this.OQQ;
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/MMGridPaperGridView$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(141986);
        }
    };
    private int OQO;
    private int OQP;
    private int OQQ;
    private int OQR = -1;
    private boolean OQS = false;
    private a OQT;
    private j OQU;
    private AdapterView.OnItemLongClickListener OQV = new AdapterView.OnItemLongClickListener() {
        /* class com.tencent.mm.ui.base.MMGridPaperGridView.AnonymousClass2 */

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            AppMethodBeat.i(141987);
            if (MMGridPaperGridView.this.OQU == null) {
                Log.w("MicroMsg.MMGridPaperGridView", "on item long click, but main adapter is null");
                AppMethodBeat.o(141987);
            } else {
                j unused = MMGridPaperGridView.this.OQU;
                int unused2 = MMGridPaperGridView.this.OQQ;
                AppMethodBeat.o(141987);
            }
            return false;
        }
    };
    private int mCount;
    private int mIndex;

    public MMGridPaperGridView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(141995);
        AppMethodBeat.o(141995);
    }

    public MMGridPaperGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(141996);
        AppMethodBeat.o(141996);
    }

    public final int getIndex() {
        return this.mIndex;
    }

    public final void a(int i2, int i3, int i4, j jVar) {
        boolean z = true;
        AppMethodBeat.i(141997);
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(i2);
        objArr[1] = Integer.valueOf(i3);
        objArr[2] = Integer.valueOf(i4);
        if (jVar != null) {
            z = false;
        }
        objArr[3] = Boolean.valueOf(z);
        Log.i("MicroMsg.MMGridPaperGridView", "index[%d], rows[%d], columns[%d], adapter is null[%B]", objArr);
        this.mIndex = i2;
        this.OQO = i3;
        this.OQP = i4;
        this.OQU = jVar;
        this.mCount = this.OQO * this.OQP;
        this.OQQ = this.mIndex * this.mCount;
        if (this.OQU != null && this.OQU.getCount() - this.OQQ < this.mCount) {
            this.mCount = this.OQU.getCount() - this.OQQ;
        }
        if (getAdapter() == null) {
            Log.w("MicroMsg.MMGridPaperGridView", "get adapter null, new one");
            this.OQT = new a(this, (byte) 0);
            setAdapter((ListAdapter) this.OQT);
        }
        setNumColumns(this.OQP);
        setColumnWidth(3);
        setOnItemClickListener(this.FMs);
        setOnItemLongClickListener(this.OQV);
        AppMethodBeat.o(141997);
    }

    public final void notifyDataSetChanged() {
        AppMethodBeat.i(141998);
        if (this.OQT != null) {
            this.OQT.notifyDataSetChanged();
        }
        AppMethodBeat.o(141998);
    }

    public final void setHiddenIndex(int i2) {
        this.OQR = i2;
    }

    public final void setClearMode(boolean z) {
        this.OQS = z;
    }

    /* access modifiers changed from: package-private */
    public class a extends BaseAdapter {
        private a() {
        }

        /* synthetic */ a(MMGridPaperGridView mMGridPaperGridView, byte b2) {
            this();
        }

        public final boolean isEnabled(int i2) {
            AppMethodBeat.i(141988);
            if (MMGridPaperGridView.this.OQU == null) {
                AppMethodBeat.o(141988);
                return false;
            }
            j unused = MMGridPaperGridView.this.OQU;
            int unused2 = MMGridPaperGridView.this.OQQ;
            AppMethodBeat.o(141988);
            return true;
        }

        public final int getItemViewType(int i2) {
            AppMethodBeat.i(141989);
            if (MMGridPaperGridView.this.OQU == null) {
                AppMethodBeat.o(141989);
            } else {
                j unused = MMGridPaperGridView.this.OQU;
                int unused2 = MMGridPaperGridView.this.OQQ;
                AppMethodBeat.o(141989);
            }
            return 0;
        }

        public final int getViewTypeCount() {
            AppMethodBeat.i(141990);
            if (MMGridPaperGridView.this.OQU == null) {
                AppMethodBeat.o(141990);
            } else {
                j unused = MMGridPaperGridView.this.OQU;
                AppMethodBeat.o(141990);
            }
            return 1;
        }

        public final int getCount() {
            AppMethodBeat.i(141991);
            if (MMGridPaperGridView.this.mCount < 0 || MMGridPaperGridView.this.OQU == null) {
                AppMethodBeat.o(141991);
                return 0;
            }
            int i2 = MMGridPaperGridView.this.mCount;
            AppMethodBeat.o(141991);
            return i2;
        }

        public final Object getItem(int i2) {
            AppMethodBeat.i(141992);
            if (MMGridPaperGridView.this.OQU == null) {
                AppMethodBeat.o(141992);
                return null;
            }
            Object item = MMGridPaperGridView.this.OQU.getItem(MMGridPaperGridView.this.OQQ + i2);
            AppMethodBeat.o(141992);
            return item;
        }

        public final long getItemId(int i2) {
            AppMethodBeat.i(141993);
            if (MMGridPaperGridView.this.OQU == null) {
                AppMethodBeat.o(141993);
                return 0;
            }
            long itemId = MMGridPaperGridView.this.OQU.getItemId(MMGridPaperGridView.this.OQQ + i2);
            AppMethodBeat.o(141993);
            return itemId;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            boolean z;
            AppMethodBeat.i(141994);
            long currentTicks = Util.currentTicks();
            Object[] objArr = new Object[5];
            objArr[0] = Integer.valueOf(MMGridPaperGridView.this.mIndex);
            objArr[1] = Integer.valueOf(i2);
            objArr[2] = Boolean.valueOf(view == null);
            objArr[3] = viewGroup.toString();
            objArr[4] = Boolean.valueOf(MMGridPaperGridView.this.OQS);
            Log.v("MicroMsg.MMGridPaperGridView", "getView:index[%d], pos[%d], converrView is null[%B], parent is [%s], mClearMode[%B]", objArr);
            if (MMGridPaperGridView.this.OQS) {
                view = null;
            }
            View e2 = MMGridPaperGridView.this.OQU == null ? null : MMGridPaperGridView.this.OQU.e(MMGridPaperGridView.this.OQQ + i2, view);
            if (e2 != null) {
                z = true;
            } else {
                z = false;
            }
            Assert.assertTrue(z);
            if (-1 == MMGridPaperGridView.this.OQR || MMGridPaperGridView.this.OQQ + i2 != MMGridPaperGridView.this.OQR) {
                e2.setVisibility(0);
            } else {
                e2.setVisibility(4);
            }
            Log.v("MicroMsg.MMGridPaperGridView", "get View ok: use %d ms, hidden index[%d], cur global index[%d]", Long.valueOf(Util.ticksToNow(currentTicks)), Integer.valueOf(MMGridPaperGridView.this.OQR), Integer.valueOf(MMGridPaperGridView.this.OQQ + i2));
            AppMethodBeat.o(141994);
            return e2;
        }
    }
}
