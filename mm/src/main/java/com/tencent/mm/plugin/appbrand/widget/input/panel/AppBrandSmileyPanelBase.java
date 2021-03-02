package com.tencent.mm.plugin.appbrand.widget.input.panel;

import android.annotation.SuppressLint;
import android.app.Activity;
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
import com.tencent.mm.plugin.appbrand.ui.b;
import com.tencent.mm.plugin.appbrand.widget.input.panel.AppBrandSmileyViewPager;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.ui.base.MMDotView;

public class AppBrandSmileyPanelBase extends LinearLayout implements ViewPager.OnPageChangeListener, AppBrandSmileyViewPager.b {
    private Activity mActivity;
    private View mContentView = null;
    private boolean ouu = false;
    private c owP;
    private f oxa;
    private AppBrandSmileyViewPager oxb = null;
    private MMDotView oxc;
    private boolean oxd = true;

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i2, float f2, int i3) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i2) {
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.panel.AppBrandSmileyViewPager.b
    public final void ccj() {
        AppMethodBeat.i(49937);
        if (this.oxb == null) {
            AppMethodBeat.o(49937);
            return;
        }
        this.owP.oxd = i.isPortOrientation(getContext());
        AppBrandSmileyViewPager.a aVar = (AppBrandSmileyViewPager.a) this.oxb.getAdapter();
        if (aVar != null) {
            aVar.oxn.clear();
            aVar.owP = this.owP;
            aVar.notifyDataSetChanged();
        } else {
            AppBrandSmileyViewPager.a aVar2 = new AppBrandSmileyViewPager.a();
            aVar2.owP = this.owP;
            this.oxb.setAdapter(aVar2);
        }
        this.oxb.post(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.widget.input.panel.AppBrandSmileyPanelBase.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(49935);
                AppBrandSmileyPanelBase.this.onPageSelected(AppBrandSmileyPanelBase.this.oxb.getCurrentItem());
                AppMethodBeat.o(49935);
            }
        });
        AppMethodBeat.o(49937);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(49938);
        super.onSizeChanged(i2, i3, i4, i5);
        ccn();
        AppMethodBeat.o(49938);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(49939);
        if (this.ouu) {
            super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(0, Integer.MIN_VALUE));
            AppMethodBeat.o(49939);
            return;
        }
        i.isPortOrientation(getContext());
        super.onMeasure(i2, i3);
        AppMethodBeat.o(49939);
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"WrongCall"})
    public final void eM(int i2, int i3) {
        AppMethodBeat.i(49940);
        super.onMeasure(i2, i3);
        AppMethodBeat.o(49940);
    }

    public AppBrandSmileyPanelBase(Context context) {
        super(context, null);
        AppMethodBeat.i(49941);
        init();
        AppMethodBeat.o(49941);
    }

    public AppBrandSmileyPanelBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(49942);
        init();
        AppMethodBeat.o(49942);
    }

    public void setOnTextOperationListener(f fVar) {
        this.oxa = fVar;
        this.owP.oxg = this.oxa;
    }

    /* access modifiers changed from: protected */
    public final c getManager() {
        return this.owP;
    }

    public final void onDestroy() {
        AppMethodBeat.i(49943);
        c cVar = this.owP;
        cVar.oxf = null;
        cVar.owO = null;
        if (this.mContentView != null) {
            ((ViewGroup) this.mContentView.getParent()).removeView(this.mContentView);
            ((ViewGroup) this.mContentView).removeAllViews();
            this.mContentView = null;
        }
        this.mActivity = null;
        AppMethodBeat.o(49943);
    }

    public final void cck() {
        AppMethodBeat.i(49944);
        if (this.mContentView != null) {
            this.mContentView.setVisibility(0);
        }
        AppMethodBeat.o(49944);
    }

    public final void ccl() {
        AppMethodBeat.i(49945);
        if (this.mContentView != null) {
            this.mContentView.setVisibility(4);
        }
        AppMethodBeat.o(49945);
    }

    private void init() {
        AppMethodBeat.i(49946);
        this.mActivity = AndroidContextUtil.castActivityOrNull(getContext());
        this.owP = cbG();
        this.owP.owO = getContext();
        this.owP.oxg = this.oxa;
        AppMethodBeat.o(49946);
    }

    /* access modifiers changed from: protected */
    public c cbG() {
        AppMethodBeat.i(49947);
        c cVar = new c();
        AppMethodBeat.o(49947);
        return cVar;
    }

    public void setVisibility(int i2) {
        AppMethodBeat.i(49948);
        if (i2 == 0) {
            this.ouu = false;
        } else {
            this.ouu = true;
        }
        super.setVisibility(i2);
        if (!this.ouu) {
            b.G(this.mActivity);
            initView();
        }
        AppMethodBeat.o(49948);
    }

    /* access modifiers changed from: protected */
    public final void Ai(int i2) {
        AppMethodBeat.i(49949);
        super.setVisibility(i2);
        AppMethodBeat.o(49949);
    }

    private void ccm() {
        AppMethodBeat.i(49950);
        this.mContentView.setVisibility(0);
        AppMethodBeat.o(49950);
    }

    /* access modifiers changed from: protected */
    public final void initView() {
        AppMethodBeat.i(49951);
        if (this.mContentView == null || getChildCount() <= 0) {
            if (this.mContentView == null) {
                this.mContentView = View.inflate(MMApplicationContext.getContext(), R.layout.gz, null);
            } else if (this.mContentView.getParent() != null) {
                ((ViewGroup) this.mContentView.getParent()).removeView(this.mContentView);
            }
            this.oxb = (AppBrandSmileyViewPager) this.mContentView.findViewById(R.id.htj);
            this.oxb.setOnPageChangeListener(this);
            this.oxb.setPanelManager(this.owP);
            this.oxb.setOnSizeChangedListener(this);
            this.oxc = (MMDotView) this.mContentView.findViewById(R.id.htg);
            this.oxc.setDotCount(1);
            ccn();
            addView(this.mContentView, new LinearLayout.LayoutParams(-1, -1));
            AppMethodBeat.o(49951);
            return;
        }
        ccm();
        AppMethodBeat.o(49951);
    }

    private void ccn() {
        AppMethodBeat.i(49952);
        if (this.oxc == null) {
            AppMethodBeat.o(49952);
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
        AppMethodBeat.o(49952);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i2) {
        AppMethodBeat.i(49936);
        a cco = this.owP.cco();
        int pageCount = cco.getPageCount();
        int i3 = i2 - cco.owQ;
        if (pageCount <= 1) {
            this.oxc.setVisibility(4);
            AppMethodBeat.o(49936);
            return;
        }
        this.oxc.setVisibility(0);
        this.oxc.setDotCount(pageCount);
        this.oxc.setSelectedDot(i3);
        AppMethodBeat.o(49936);
    }
}
