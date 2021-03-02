package com.tencent.mm.ui.gridviewheaders;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class c extends BaseAdapter {
    private static boolean Qkh;
    final b Qki;
    private GridHeadersGridView Qkj;
    private final List<View> Qkk = new ArrayList();
    private View[] Qkl;
    private DataSetObserver Tr = new DataSetObserver() {
        /* class com.tencent.mm.ui.gridviewheaders.c.AnonymousClass1 */

        public final void onChanged() {
            AppMethodBeat.i(142759);
            c cVar = c.this;
            cVar.mCount = 0;
            int gWs = cVar.Qki.gWs();
            if (gWs == 0) {
                cVar.mCount = cVar.Qki.getCount();
            } else {
                for (int i2 = 0; i2 < gWs; i2++) {
                    cVar.mCount += cVar.Qki.aob(i2) + cVar.mNumColumns;
                }
            }
            c.this.notifyDataSetChanged();
            AppMethodBeat.o(142759);
        }

        public final void onInvalidated() {
            AppMethodBeat.i(142760);
            c.this.Qkk.clear();
            c.this.notifyDataSetInvalidated();
            AppMethodBeat.o(142760);
        }
    };
    private final Context mContext;
    int mCount;
    int mNumColumns = 1;

    public c(Context context, GridHeadersGridView gridHeadersGridView, b bVar) {
        AppMethodBeat.i(142775);
        this.mContext = context;
        this.Qki = bVar;
        this.Qkj = gridHeadersGridView;
        bVar.registerDataSetObserver(this.Tr);
        AppMethodBeat.o(142775);
    }

    public final boolean areAllItemsEnabled() {
        return false;
    }

    public final int getCount() {
        AppMethodBeat.i(142776);
        this.mCount = 0;
        int gWs = this.Qki.gWs();
        if (gWs == 0) {
            int count = this.Qki.getCount();
            AppMethodBeat.o(142776);
            return count;
        }
        for (int i2 = 0; i2 < gWs; i2++) {
            this.mCount += this.Qki.aob(i2) + aod(i2) + this.mNumColumns;
        }
        int i3 = this.mCount;
        AppMethodBeat.o(142776);
        return i3;
    }

    public final Object getItem(int i2) {
        AppMethodBeat.i(142777);
        C2116c aoe = aoe(i2);
        if (aoe.mPosition == -1 || aoe.mPosition == -2) {
            AppMethodBeat.o(142777);
            return null;
        }
        Object item = this.Qki.getItem(aoe.mPosition);
        AppMethodBeat.o(142777);
        return item;
    }

    public final long getItemId(int i2) {
        AppMethodBeat.i(142778);
        C2116c aoe = aoe(i2);
        if (aoe.mPosition == -2) {
            AppMethodBeat.o(142778);
            return -1;
        } else if (aoe.mPosition == -1) {
            AppMethodBeat.o(142778);
            return -2;
        } else {
            long itemId = this.Qki.getItemId(aoe.mPosition);
            AppMethodBeat.o(142778);
            return itemId;
        }
    }

    public final int getItemViewType(int i2) {
        AppMethodBeat.i(142779);
        C2116c aoe = aoe(i2);
        if (aoe.mPosition == -2) {
            AppMethodBeat.o(142779);
            return 1;
        } else if (aoe.mPosition == -1) {
            AppMethodBeat.o(142779);
            return 0;
        } else {
            int itemViewType = this.Qki.getItemViewType(aoe.mPosition);
            if (itemViewType == -1) {
                AppMethodBeat.o(142779);
                return itemViewType;
            }
            int i3 = itemViewType + 2;
            AppMethodBeat.o(142779);
            return i3;
        }
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        d dVar;
        View view2;
        b bVar;
        AppMethodBeat.i(142780);
        if (view instanceof d) {
            d dVar2 = (d) view;
            view2 = dVar2.getChildAt(0);
            dVar = dVar2;
        } else {
            dVar = null;
            view2 = view;
        }
        C2116c aoe = aoe(i2);
        if (aoe.mPosition == -2) {
            b bVar2 = new b(this.mContext);
            bVar2.setHeaderWidth(this.Qkj.getWidth());
            bVar2.setHeaderId(aoe.Qkp);
            bVar2.setTag(this.Qki.a(aoe.Qkp, (View) bVar2.getTag(), viewGroup));
            bVar = bVar2;
        } else if (aoe.mPosition == -1) {
            a aVar = (a) view2;
            if (aVar == null) {
                aVar = new a(this.mContext);
            }
            bVar = aVar;
        } else {
            bVar = this.Qki.getView(aoe.mPosition, view2, viewGroup);
        }
        if (dVar == null) {
            dVar = new d(this.mContext);
        }
        dVar.removeAllViews();
        dVar.addView(bVar);
        dVar.setPosition(i2);
        dVar.setNumColumns(this.mNumColumns);
        this.Qkl[i2 % this.mNumColumns] = dVar;
        if (i2 % this.mNumColumns == 0) {
            Qkh = true;
            for (int i3 = 1; i3 < this.Qkl.length; i3++) {
                this.Qkl[i3] = getView(i2 + i3, null, viewGroup);
            }
            Qkh = false;
        }
        dVar.setRowSiblings(this.Qkl);
        if (!Qkh && (i2 % this.mNumColumns == this.mNumColumns - 1 || i2 == getCount() - 1)) {
            aoc(this.mNumColumns);
        }
        AppMethodBeat.o(142780);
        return dVar;
    }

    public final int getViewTypeCount() {
        AppMethodBeat.i(142781);
        int viewTypeCount = this.Qki.getViewTypeCount() + 2;
        AppMethodBeat.o(142781);
        return viewTypeCount;
    }

    public final boolean hasStableIds() {
        AppMethodBeat.i(142782);
        boolean hasStableIds = this.Qki.hasStableIds();
        AppMethodBeat.o(142782);
        return hasStableIds;
    }

    public final boolean isEmpty() {
        AppMethodBeat.i(142783);
        boolean isEmpty = this.Qki.isEmpty();
        AppMethodBeat.o(142783);
        return isEmpty;
    }

    public final boolean isEnabled(int i2) {
        AppMethodBeat.i(142784);
        C2116c aoe = aoe(i2);
        if (aoe.mPosition == -1 || aoe.mPosition == -2) {
            AppMethodBeat.o(142784);
            return false;
        }
        boolean isEnabled = this.Qki.isEnabled(aoe.mPosition);
        AppMethodBeat.o(142784);
        return isEnabled;
    }

    public final void registerDataSetObserver(DataSetObserver dataSetObserver) {
        AppMethodBeat.i(142785);
        this.Qki.registerDataSetObserver(dataSetObserver);
        AppMethodBeat.o(142785);
    }

    public final void setNumColumns(int i2) {
        AppMethodBeat.i(142786);
        this.mNumColumns = i2;
        aoc(i2);
        AppMethodBeat.o(142786);
    }

    public final void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        AppMethodBeat.i(142787);
        this.Qki.unregisterDataSetObserver(dataSetObserver);
        AppMethodBeat.o(142787);
    }

    private void aoc(int i2) {
        AppMethodBeat.i(142788);
        this.Qkl = new View[i2];
        Arrays.fill(this.Qkl, (Object) null);
        AppMethodBeat.o(142788);
    }

    private int aod(int i2) {
        AppMethodBeat.i(142789);
        int aob = this.Qki.aob(i2) % this.mNumColumns;
        if (aob == 0) {
            AppMethodBeat.o(142789);
            return 0;
        }
        int i3 = this.mNumColumns - aob;
        AppMethodBeat.o(142789);
        return i3;
    }

    /* access modifiers changed from: protected */
    public final long EQ(int i2) {
        AppMethodBeat.i(142790);
        long j2 = (long) aoe(i2).Qkp;
        AppMethodBeat.o(142790);
        return j2;
    }

    /* access modifiers changed from: protected */
    public final View a(int i2, View view, ViewGroup viewGroup) {
        AppMethodBeat.i(142791);
        if (this.Qki.gWs() == 0) {
            AppMethodBeat.o(142791);
            return null;
        }
        View a2 = this.Qki.a(aoe(i2).Qkp, view, viewGroup);
        AppMethodBeat.o(142791);
        return a2;
    }

    /* access modifiers changed from: protected */
    public final C2116c aoe(int i2) {
        int i3 = 0;
        AppMethodBeat.i(142792);
        int gWs = this.Qki.gWs();
        if (gWs != 0) {
            int i4 = i2;
            int i5 = i2;
            while (i3 < gWs) {
                int aob = this.Qki.aob(i3);
                if (i5 == 0) {
                    C2116c cVar = new C2116c(-2, i3);
                    AppMethodBeat.o(142792);
                    return cVar;
                }
                int i6 = i5 - this.mNumColumns;
                if (i6 < 0) {
                    C2116c cVar2 = new C2116c(-1, i3);
                    AppMethodBeat.o(142792);
                    return cVar2;
                }
                int i7 = i4 - this.mNumColumns;
                if (i6 < aob) {
                    C2116c cVar3 = new C2116c(i7, i3);
                    AppMethodBeat.o(142792);
                    return cVar3;
                }
                int aod = aod(i3);
                i5 = i6 - (aob + aod);
                i3++;
                i4 = i7 - aod;
            }
            C2116c cVar4 = new C2116c(-1, i3);
            AppMethodBeat.o(142792);
            return cVar4;
        } else if (i2 >= this.Qki.getCount()) {
            C2116c cVar5 = new C2116c(-1, 0);
            AppMethodBeat.o(142792);
            return cVar5;
        } else {
            C2116c cVar6 = new C2116c(i2, 0);
            AppMethodBeat.o(142792);
            return cVar6;
        }
    }

    protected class a extends View {
        public a(Context context) {
            super(context);
        }
    }

    /* access modifiers changed from: protected */
    public class b extends FrameLayout {
        private int Qkn;
        private int Qko;

        public b(Context context) {
            super(context);
        }

        public final int getHeaderId() {
            return this.Qkn;
        }

        public final void setHeaderId(int i2) {
            this.Qkn = i2;
        }

        public final void setHeaderWidth(int i2) {
            this.Qko = i2;
        }

        /* access modifiers changed from: protected */
        public final void onMeasure(int i2, int i3) {
            AppMethodBeat.i(142762);
            View view = (View) getTag();
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(generateDefaultLayoutParams());
            }
            if (view.getVisibility() != 8 && view.getMeasuredHeight() == 0) {
                view.measure(View.MeasureSpec.makeMeasureSpec(this.Qko, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
            }
            setMeasuredDimension(View.MeasureSpec.getSize(i2), view.getMeasuredHeight());
            AppMethodBeat.o(142762);
        }

        /* access modifiers changed from: protected */
        @Override // android.widget.FrameLayout, android.widget.FrameLayout
        public final FrameLayout.LayoutParams generateDefaultLayoutParams() {
            AppMethodBeat.i(142763);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            AppMethodBeat.o(142763);
            return layoutParams;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: com.tencent.mm.ui.gridviewheaders.c$c  reason: collision with other inner class name */
    public class C2116c {
        protected int Qkp;
        protected int mPosition;

        protected C2116c(int i2, int i3) {
            this.mPosition = i2;
            this.Qkp = i3;
        }
    }

    /* access modifiers changed from: protected */
    public class d extends FrameLayout {
        private View[] Qkl;
        private boolean Qkq;
        private int mNumColumns;
        private int mPosition;

        public d(Context context) {
            super(context);
        }

        public final Object getTag() {
            AppMethodBeat.i(142766);
            Object tag = getChildAt(0).getTag();
            AppMethodBeat.o(142766);
            return tag;
        }

        public final Object getTag(int i2) {
            AppMethodBeat.i(142767);
            Object tag = getChildAt(0).getTag(i2);
            AppMethodBeat.o(142767);
            return tag;
        }

        public final View getView() {
            AppMethodBeat.i(142768);
            View childAt = getChildAt(0);
            AppMethodBeat.o(142768);
            return childAt;
        }

        public final void setNumColumns(int i2) {
            this.mNumColumns = i2;
        }

        public final void setPosition(int i2) {
            this.mPosition = i2;
        }

        @SuppressLint({"NewApi"})
        public final void setRowSiblings(View[] viewArr) {
            this.Qkl = viewArr;
        }

        public final void setTag(int i2, Object obj) {
            AppMethodBeat.i(142769);
            getChildAt(0).setTag(i2, obj);
            AppMethodBeat.o(142769);
        }

        public final void setTag(Object obj) {
            AppMethodBeat.i(142770);
            getChildAt(0).setTag(obj);
            AppMethodBeat.o(142770);
        }

        /* access modifiers changed from: protected */
        @Override // android.widget.FrameLayout, android.widget.FrameLayout
        public final FrameLayout.LayoutParams generateDefaultLayoutParams() {
            AppMethodBeat.i(142771);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            AppMethodBeat.o(142771);
            return layoutParams;
        }

        /* access modifiers changed from: protected */
        public final void onMeasure(int i2, int i3) {
            AppMethodBeat.i(142772);
            super.onMeasure(i2, i3);
            if (this.mNumColumns == 1 || c.this.Qkl == null) {
                AppMethodBeat.o(142772);
                return;
            }
            if (this.mPosition % this.mNumColumns == 0 && !this.Qkq) {
                this.Qkq = true;
                for (View view : this.Qkl) {
                    view.measure(i2, i3);
                }
                this.Qkq = false;
            }
            int measuredHeight = getMeasuredHeight();
            View[] viewArr = this.Qkl;
            int i4 = measuredHeight;
            for (View view2 : viewArr) {
                if (view2 != null) {
                    i4 = Math.max(i4, view2.getMeasuredHeight());
                }
            }
            if (i4 == measuredHeight) {
                AppMethodBeat.o(142772);
                return;
            }
            super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(i4, 1073741824));
            AppMethodBeat.o(142772);
        }
    }
}
