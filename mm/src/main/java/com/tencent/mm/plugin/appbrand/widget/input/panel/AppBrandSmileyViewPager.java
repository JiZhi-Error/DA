package com.tencent.mm.plugin.appbrand.widget.input.panel;

import android.content.Context;
import android.os.Build;
import android.support.v4.view.q;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.CustomViewPager;
import java.lang.ref.SoftReference;

public class AppBrandSmileyViewPager extends CustomViewPager {
    private c owP;
    private int oxk = 0;
    private int oxl = 0;
    private b oxm;

    public interface b {
        void ccj();
    }

    public AppBrandSmileyViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(49963);
        if (Build.VERSION.SDK_INT >= 9) {
            setOverScrollMode(2);
        }
        AppMethodBeat.o(49963);
    }

    public void setPanelManager(c cVar) {
        this.owP = cVar;
    }

    @Override // com.tencent.mm.ui.mogic.WxViewPager
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(49964);
        super.onSizeChanged(i2, i3, i4, i5);
        if (this.owP != null && (((i2 > 0 && i4 != i2) || (i3 > 0 && i5 != i3)) && ((i3 > 0 && i3 != this.oxk) || (i2 > 0 && i2 != this.oxl)))) {
            this.owP.oxh = i3;
            this.owP.oxi = i2;
            if (this.oxm != null) {
                this.oxm.ccj();
            }
        }
        if (i3 > 0) {
            this.oxk = i3;
        }
        if (i2 > 0) {
            this.oxl = i2;
        }
        AppMethodBeat.o(49964);
    }

    public void setOnSizeChangedListener(b bVar) {
        this.oxm = bVar;
    }

    static class a extends q {
        c owP;
        SparseArray<SoftReference<View>> oxn = new SparseArray<>();
        private boolean oxo = false;

        a() {
            AppMethodBeat.i(49957);
            AppMethodBeat.o(49957);
        }

        @Override // android.support.v4.view.q
        public final int getItemPosition(Object obj) {
            AppMethodBeat.i(49958);
            if (this.oxo) {
                AppMethodBeat.o(49958);
                return -2;
            }
            int itemPosition = super.getItemPosition(obj);
            AppMethodBeat.o(49958);
            return itemPosition;
        }

        @Override // android.support.v4.view.q
        public final void notifyDataSetChanged() {
            AppMethodBeat.i(49959);
            this.oxo = true;
            super.notifyDataSetChanged();
            this.oxo = false;
            AppMethodBeat.o(49959);
        }

        @Override // android.support.v4.view.q
        public final int getCount() {
            AppMethodBeat.i(49960);
            int pageCount = this.owP.cco().getPageCount();
            AppMethodBeat.o(49960);
            return pageCount;
        }

        @Override // android.support.v4.view.q
        public final boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.q
        public final void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
            AppMethodBeat.i(49961);
            viewGroup.removeView((View) obj);
            AppMethodBeat.o(49961);
        }

        @Override // android.support.v4.view.q
        public final Object instantiateItem(ViewGroup viewGroup, int i2) {
            AppMethodBeat.i(49962);
            View view = null;
            if (this.oxn.get(i2) != null) {
                view = this.oxn.get(i2).get();
            }
            if (view == null) {
                View Ap = this.owP.cco().Ap(i2);
                if (Ap != null) {
                    viewGroup.addView(Ap, 0);
                    this.oxn.put(i2, new SoftReference<>(Ap));
                } else {
                    Log.e("MicroMsg.AppBrandSmileyViewPagerAdapter", "contentView == null!");
                }
                AppMethodBeat.o(49962);
                return Ap;
            }
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            viewGroup.addView(view, 0);
            AppMethodBeat.o(49962);
            return view;
        }
    }
}
