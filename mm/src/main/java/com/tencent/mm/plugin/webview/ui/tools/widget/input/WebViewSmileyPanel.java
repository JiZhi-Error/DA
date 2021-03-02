package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.i;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewSmileyViewPager;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMDotView;

public class WebViewSmileyPanel extends LinearLayout implements ViewPager.OnPageChangeListener, WebViewSmileyViewPager.a {
    private c JBa;
    private a JBd;
    private WebViewSmileyViewPager JBe = null;
    private View mContentView = null;
    private boolean ouu = false;
    private MMDotView oxc;
    private boolean oxd = true;
    private MMActivity pQZ;

    public interface a {
        void aHC();

        void append(String str);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i2, float f2, int i3) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i2) {
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewSmileyViewPager.a
    public final void ccj() {
        AppMethodBeat.i(82346);
        if (this.JBe == null) {
            AppMethodBeat.o(82346);
            return;
        }
        this.JBa.oxd = i.isPortOrientation(getContext());
        WebViewSmileyViewPager.b bVar = (WebViewSmileyViewPager.b) this.JBe.getAdapter();
        if (bVar != null) {
            bVar.oxn.clear();
            bVar.JBa = this.JBa;
            bVar.notifyDataSetChanged();
        } else {
            WebViewSmileyViewPager.b bVar2 = new WebViewSmileyViewPager.b();
            bVar2.JBa = this.JBa;
            this.JBe.setAdapter(bVar2);
        }
        this.JBe.post(new Runnable() {
            /* class com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewSmileyPanel.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(82344);
                WebViewSmileyPanel.this.onPageSelected(WebViewSmileyPanel.this.JBe.getCurrentItem());
                AppMethodBeat.o(82344);
            }
        });
        AppMethodBeat.o(82346);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(82347);
        super.onSizeChanged(i2, i3, i4, i5);
        ccn();
        AppMethodBeat.o(82347);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(82348);
        if (this.ouu) {
            super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(0, Integer.MIN_VALUE));
            AppMethodBeat.o(82348);
            return;
        }
        i.isPortOrientation(getContext());
        super.onMeasure(i2, i3);
        AppMethodBeat.o(82348);
    }

    public WebViewSmileyPanel(Context context) {
        super(context, null);
        AppMethodBeat.i(82349);
        init();
        AppMethodBeat.o(82349);
    }

    public WebViewSmileyPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(82350);
        init();
        AppMethodBeat.o(82350);
    }

    public void setOnTextOperationListener(a aVar) {
        this.JBd = aVar;
        this.JBa.JBh = this.JBd;
    }

    /* access modifiers changed from: protected */
    public final c getManager() {
        return this.JBa;
    }

    public final void onDestroy() {
        AppMethodBeat.i(212143);
        this.JBa.onDestroy();
        if (this.mContentView != null) {
            ((ViewGroup) this.mContentView.getParent()).removeView(this.mContentView);
            ((ViewGroup) this.mContentView).removeAllViews();
            this.mContentView = null;
        }
        this.pQZ = null;
        AppMethodBeat.o(212143);
    }

    public final void cck() {
        AppMethodBeat.i(212144);
        if (this.mContentView != null) {
            this.mContentView.setVisibility(0);
        }
        AppMethodBeat.o(212144);
    }

    private void init() {
        AppMethodBeat.i(82351);
        this.pQZ = (MMActivity) getContext();
        this.JBa = new c();
        this.JBa.owO = getContext();
        this.JBa.JBh = this.JBd;
        AppMethodBeat.o(82351);
    }

    public void setVisibility(int i2) {
        AppMethodBeat.i(82352);
        if (i2 == 0) {
            this.ouu = false;
        } else {
            this.ouu = true;
        }
        super.setVisibility(i2);
        if (!this.ouu) {
            this.pQZ.hideVKB();
            if (this.mContentView == null || getChildCount() <= 0) {
                if (this.mContentView == null) {
                    this.mContentView = View.inflate(MMApplicationContext.getContext(), R.layout.cby, null);
                } else if (this.mContentView.getParent() != null) {
                    ((ViewGroup) this.mContentView.getParent()).removeView(this.mContentView);
                }
                this.JBe = (WebViewSmileyViewPager) this.mContentView.findViewById(R.id.htj);
                this.JBe.setOnPageChangeListener(this);
                this.JBe.setPanelManager(this.JBa);
                this.JBe.setOnSizeChangedListener(this);
                this.oxc = (MMDotView) this.mContentView.findViewById(R.id.htg);
                this.oxc.setDotCount(1);
                ccn();
                addView(this.mContentView, new LinearLayout.LayoutParams(-1, -1));
            } else {
                this.mContentView.setVisibility(0);
                AppMethodBeat.o(82352);
                return;
            }
        }
        AppMethodBeat.o(82352);
    }

    private void ccn() {
        AppMethodBeat.i(82353);
        if (this.oxc == null) {
            AppMethodBeat.o(82353);
            return;
        }
        boolean isPortOrientation = i.isPortOrientation(getContext());
        if (isPortOrientation != this.oxd) {
            if (isPortOrientation) {
                this.oxc.setPadding(0, 0, 0, getContext().getResources().getDimensionPixelSize(R.dimen.ib));
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.oxc.getLayoutParams();
                layoutParams.bottomMargin = getContext().getResources().getDimensionPixelSize(R.dimen.a35);
                this.oxc.setLayoutParams(layoutParams);
            } else {
                this.oxc.setPadding(0, 0, 0, getContext().getResources().getDimensionPixelSize(R.dimen.i2));
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.oxc.getLayoutParams();
                layoutParams2.bottomMargin = 0;
                this.oxc.setLayoutParams(layoutParams2);
            }
            this.oxd = isPortOrientation;
        }
        AppMethodBeat.o(82353);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i2) {
        AppMethodBeat.i(82345);
        a giG = this.JBa.giG();
        int pageCount = giG.getPageCount();
        int i3 = i2 - giG.owQ;
        if (pageCount <= 1) {
            this.oxc.setVisibility(4);
            AppMethodBeat.o(82345);
            return;
        }
        this.oxc.setVisibility(0);
        this.oxc.setDotCount(pageCount);
        this.oxc.setSelectedDot(i3);
        AppMethodBeat.o(82345);
    }
}
