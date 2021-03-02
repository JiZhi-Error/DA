package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.WrapperListAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;

public class HeaderGridView extends GridView {
    public ArrayList<a> OOm = new ArrayList<>();

    public static class a {
        public ViewGroup OOn;
        public Object data;
        public boolean isSelectable;
        public View view;

        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public HeaderGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(141668);
        super.setClipChildren(false);
        AppMethodBeat.o(141668);
    }

    public HeaderGridView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(141669);
        super.setClipChildren(false);
        AppMethodBeat.o(141669);
    }

    @TargetApi(11)
    public int getNumColumns() {
        AppMethodBeat.i(141670);
        if (Build.VERSION.SDK_INT >= 11) {
            int numColumns = super.getNumColumns();
            AppMethodBeat.o(141670);
            return numColumns;
        }
        try {
            Field declaredField = getClass().getSuperclass().getDeclaredField("mNumColumns");
            declaredField.setAccessible(true);
            int i2 = declaredField.getInt(this);
            AppMethodBeat.o(141670);
            return i2;
        } catch (Exception e2) {
            AppMethodBeat.o(141670);
            return 1;
        }
    }

    public void setClipChildren(boolean z) {
    }

    public int getHeaderViewCount() {
        AppMethodBeat.i(141671);
        int size = this.OOm.size();
        AppMethodBeat.o(141671);
        return size;
    }

    public final void setAdapter$159aa965(ListAdapter listAdapter) {
        AppMethodBeat.i(141672);
        if (this.OOm.size() > 0) {
            c cVar = new c(this.OOm, listAdapter);
            if (cVar.mNumColumns != 5) {
                cVar.mNumColumns = 5;
                cVar.mDataSetObservable.notifyChanged();
            }
            super.setAdapter((ListAdapter) cVar);
            AppMethodBeat.o(141672);
            return;
        }
        super.setAdapter(listAdapter);
        AppMethodBeat.o(141672);
    }

    public class b extends FrameLayout {
        public b(Context context) {
            super(context);
        }

        /* access modifiers changed from: protected */
        public final void onMeasure(int i2, int i3) {
            AppMethodBeat.i(141651);
            super.onMeasure(View.MeasureSpec.makeMeasureSpec((HeaderGridView.this.getMeasuredWidth() - HeaderGridView.this.getPaddingLeft()) - HeaderGridView.this.getPaddingRight(), 1073741824), i3);
            AppMethodBeat.o(141651);
        }
    }

    public static class c implements Filterable, WrapperListAdapter {
        private final ListAdapter GO;
        ArrayList<a> OOm;
        boolean OOp;
        private final boolean OOq;
        public final DataSetObservable mDataSetObservable = new DataSetObservable();
        int mNumColumns = 1;

        public c(ArrayList<a> arrayList, ListAdapter listAdapter) {
            AppMethodBeat.i(141653);
            this.GO = listAdapter;
            this.OOq = listAdapter instanceof Filterable;
            if (arrayList == null) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("headerViewInfos cannot be null");
                AppMethodBeat.o(141653);
                throw illegalArgumentException;
            }
            this.OOm = arrayList;
            this.OOp = bp(this.OOm);
            AppMethodBeat.o(141653);
        }

        public final boolean isEmpty() {
            AppMethodBeat.i(141654);
            if ((this.GO == null || this.GO.isEmpty()) && this.OOm.size() == 0) {
                AppMethodBeat.o(141654);
                return true;
            }
            AppMethodBeat.o(141654);
            return false;
        }

        private static boolean bp(ArrayList<a> arrayList) {
            AppMethodBeat.i(141655);
            if (arrayList != null) {
                Iterator<a> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (!it.next().isSelectable) {
                        AppMethodBeat.o(141655);
                        return false;
                    }
                }
            }
            AppMethodBeat.o(141655);
            return true;
        }

        public final int getCount() {
            AppMethodBeat.i(141656);
            if (this.GO != null) {
                int size = (this.OOm.size() * this.mNumColumns) + this.GO.getCount();
                AppMethodBeat.o(141656);
                return size;
            }
            int size2 = this.OOm.size() * this.mNumColumns;
            AppMethodBeat.o(141656);
            return size2;
        }

        public final boolean areAllItemsEnabled() {
            AppMethodBeat.i(141657);
            if (this.GO == null) {
                AppMethodBeat.o(141657);
                return true;
            } else if (!this.OOp || !this.GO.areAllItemsEnabled()) {
                AppMethodBeat.o(141657);
                return false;
            } else {
                AppMethodBeat.o(141657);
                return true;
            }
        }

        public final boolean hasStableIds() {
            AppMethodBeat.i(141661);
            if (this.GO != null) {
                boolean hasStableIds = this.GO.hasStableIds();
                AppMethodBeat.o(141661);
                return hasStableIds;
            }
            AppMethodBeat.o(141661);
            return false;
        }

        public final int getViewTypeCount() {
            AppMethodBeat.i(141664);
            if (this.GO != null) {
                int viewTypeCount = this.GO.getViewTypeCount() + 1;
                AppMethodBeat.o(141664);
                return viewTypeCount;
            }
            AppMethodBeat.o(141664);
            return 2;
        }

        public final void registerDataSetObserver(DataSetObserver dataSetObserver) {
            AppMethodBeat.i(141665);
            this.mDataSetObservable.registerObserver(dataSetObserver);
            if (this.GO != null) {
                this.GO.registerDataSetObserver(dataSetObserver);
            }
            AppMethodBeat.o(141665);
        }

        public final void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            AppMethodBeat.i(141666);
            this.mDataSetObservable.unregisterObserver(dataSetObserver);
            if (this.GO != null) {
                this.GO.unregisterDataSetObserver(dataSetObserver);
            }
            AppMethodBeat.o(141666);
        }

        public final Filter getFilter() {
            AppMethodBeat.i(141667);
            if (this.OOq) {
                Filter filter = ((Filterable) this.GO).getFilter();
                AppMethodBeat.o(141667);
                return filter;
            }
            AppMethodBeat.o(141667);
            return null;
        }

        public final ListAdapter getWrappedAdapter() {
            return this.GO;
        }

        public final boolean isEnabled(int i2) {
            AppMethodBeat.i(141658);
            int size = this.OOm.size() * this.mNumColumns;
            if (i2 >= size) {
                int i3 = i2 - size;
                if (this.GO == null || i3 >= this.GO.getCount()) {
                    AppMethodBeat.o(141658);
                    return false;
                }
                boolean isEnabled = this.GO.isEnabled(i3);
                AppMethodBeat.o(141658);
                return isEnabled;
            } else if (i2 % this.mNumColumns != 0 || !this.OOm.get(i2 / this.mNumColumns).isSelectable) {
                AppMethodBeat.o(141658);
                return false;
            } else {
                AppMethodBeat.o(141658);
                return true;
            }
        }

        public final Object getItem(int i2) {
            AppMethodBeat.i(141659);
            int size = this.OOm.size() * this.mNumColumns;
            if (i2 >= size) {
                int i3 = i2 - size;
                if (this.GO == null || i3 >= this.GO.getCount()) {
                    AppMethodBeat.o(141659);
                    return null;
                }
                Object item = this.GO.getItem(i3);
                AppMethodBeat.o(141659);
                return item;
            } else if (i2 % this.mNumColumns == 0) {
                Object obj = this.OOm.get(i2 / this.mNumColumns).data;
                AppMethodBeat.o(141659);
                return obj;
            } else {
                AppMethodBeat.o(141659);
                return null;
            }
        }

        public final long getItemId(int i2) {
            int i3;
            AppMethodBeat.i(141660);
            int size = this.OOm.size() * this.mNumColumns;
            if (this.GO == null || i2 < size || (i3 = i2 - size) >= this.GO.getCount()) {
                AppMethodBeat.o(141660);
                return -1;
            }
            long itemId = this.GO.getItemId(i3);
            AppMethodBeat.o(141660);
            return itemId;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            AppMethodBeat.i(141662);
            int size = this.OOm.size() * this.mNumColumns;
            if (i2 < size) {
                ViewGroup viewGroup2 = this.OOm.get(i2 / this.mNumColumns).OOn;
                if (i2 % this.mNumColumns == 0) {
                    AppMethodBeat.o(141662);
                    return viewGroup2;
                }
                if (view == null) {
                    view = new View(viewGroup.getContext());
                }
                view.setVisibility(4);
                view.setMinimumHeight(viewGroup2.getHeight());
                AppMethodBeat.o(141662);
                return view;
            }
            int i3 = i2 - size;
            if (this.GO == null || i3 >= this.GO.getCount()) {
                if (view == null) {
                    view = new View(viewGroup.getContext());
                }
                view.setVisibility(4);
                AppMethodBeat.o(141662);
                return view;
            }
            View view2 = this.GO.getView(i3, view, viewGroup);
            AppMethodBeat.o(141662);
            return view2;
        }

        public final int getItemViewType(int i2) {
            int i3;
            AppMethodBeat.i(141663);
            int size = this.OOm.size() * this.mNumColumns;
            if (i2 >= size || i2 % this.mNumColumns == 0) {
                if (this.GO == null || i2 < size || (i3 = i2 - size) >= this.GO.getCount()) {
                    AppMethodBeat.o(141663);
                    return -2;
                }
                int itemViewType = this.GO.getItemViewType(i3);
                AppMethodBeat.o(141663);
                return itemViewType;
            } else if (this.GO != null) {
                int viewTypeCount = this.GO.getViewTypeCount();
                AppMethodBeat.o(141663);
                return viewTypeCount;
            } else {
                AppMethodBeat.o(141663);
                return 1;
            }
        }
    }
}
