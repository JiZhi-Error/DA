package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.content.Context;
import android.support.v4.view.q;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.CustomViewPager;
import java.lang.ref.SoftReference;

public class WebViewSmileyViewPager extends CustomViewPager {
    private c JBa;
    private a JBj;
    private int oxk = 0;
    private int oxl = 0;

    public interface a {
        void ccj();
    }

    public WebViewSmileyViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(82362);
        if (d.oD(9)) {
            setOverScrollMode(2);
        }
        AppMethodBeat.o(82362);
    }

    public void setPanelManager(c cVar) {
        this.JBa = cVar;
    }

    @Override // com.tencent.mm.ui.mogic.WxViewPager
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(82363);
        super.onSizeChanged(i2, i3, i4, i5);
        if (this.JBa != null && (((i2 > 0 && i4 != i2) || (i3 > 0 && i5 != i3)) && ((i3 > 0 && i3 != this.oxk) || (i2 > 0 && i2 != this.oxl)))) {
            this.JBa.oxh = i3;
            this.JBa.oxi = i2;
            if (this.JBj != null) {
                this.JBj.ccj();
            }
        }
        if (i3 > 0) {
            this.oxk = i3;
        }
        if (i2 > 0) {
            this.oxl = i2;
        }
        AppMethodBeat.o(82363);
    }

    public void setOnSizeChangedListener(a aVar) {
        this.JBj = aVar;
    }

    static class b extends q {
        c JBa;
        SparseArray<SoftReference<View>> oxn = new SparseArray<>();
        private boolean oxo = false;

        b() {
            AppMethodBeat.i(82356);
            AppMethodBeat.o(82356);
        }

        @Override // android.support.v4.view.q
        public final int getItemPosition(Object obj) {
            AppMethodBeat.i(82357);
            if (this.oxo) {
                AppMethodBeat.o(82357);
                return -2;
            }
            int itemPosition = super.getItemPosition(obj);
            AppMethodBeat.o(82357);
            return itemPosition;
        }

        @Override // android.support.v4.view.q
        public final void notifyDataSetChanged() {
            AppMethodBeat.i(82358);
            this.oxo = true;
            super.notifyDataSetChanged();
            this.oxo = false;
            AppMethodBeat.o(82358);
        }

        @Override // android.support.v4.view.q
        public final int getCount() {
            AppMethodBeat.i(82359);
            int pageCount = this.JBa.giG().getPageCount();
            AppMethodBeat.o(82359);
            return pageCount;
        }

        @Override // android.support.v4.view.q
        public final boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.q
        public final void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
            AppMethodBeat.i(82360);
            viewGroup.removeView((View) obj);
            AppMethodBeat.o(82360);
        }

        @Override // android.support.v4.view.q
        public final Object instantiateItem(ViewGroup viewGroup, int i2) {
            AppMethodBeat.i(82361);
            View view = null;
            if (this.oxn.get(i2) != null) {
                view = this.oxn.get(i2).get();
            }
            if (view == null) {
                View Ap = this.JBa.giG().Ap(i2);
                if (Ap != null) {
                    viewGroup.addView(Ap, 0);
                    this.oxn.put(i2, new SoftReference<>(Ap));
                } else {
                    Log.e("MicroMsg.WebViewSmileyViewPagerAdapter", "contentView == null!");
                }
                AppMethodBeat.o(82361);
                return Ap;
            }
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            viewGroup.addView(view, 0);
            AppMethodBeat.o(82361);
            return view;
        }
    }
}
