package com.tencent.mm.plugin.appbrand.page;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class AppBrandActionHeaderLayout extends LinearLayout {
    private int crI = -1;
    private Context mContext;
    private TextView nnA;
    private LinearLayout nnt;
    private HorizontalScrollView nnu;
    private AppBrandActionSingleHeaderView nnv;
    private AppBrandActionMultipleHeaderView nnw;
    private AppBrandActionMultipleHeaderView nnx;
    private AppBrandActionMultipleHeaderView nny;
    private AppBrandActionMultipleHeaderView nnz;

    public AppBrandActionHeaderLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(147431);
        bh(context);
        AppMethodBeat.o(147431);
    }

    @TargetApi(11)
    public AppBrandActionHeaderLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(147432);
        bh(context);
        AppMethodBeat.o(147432);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(147433);
        if (this.crI > 0) {
            i3 = View.MeasureSpec.makeMeasureSpec(this.crI, 1073741824);
        }
        super.onMeasure(i2, i3);
        if (this.crI > 0 && getMeasuredHeight() > this.crI) {
            super.setMeasuredDimension(getMeasuredWidth(), this.crI);
        }
        AppMethodBeat.o(147433);
    }

    public void setForceHeight(int i2) {
        AppMethodBeat.i(169505);
        this.crI = Math.max(i2, -1);
        if (getParent() instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) getParent();
            if (this.crI > 0) {
                viewGroup.setMinimumHeight(this.crI);
            }
            requestLayout();
        }
        AppMethodBeat.o(169505);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.i(147435);
        super.onAttachedToWindow();
        if (this.crI > 0) {
            setForceHeight(this.crI);
        }
        AppMethodBeat.o(147435);
    }

    private void bh(Context context) {
        AppMethodBeat.i(147436);
        this.mContext = context;
        View.inflate(context, R.layout.gi, this);
        this.nnt = (LinearLayout) findViewById(R.id.sq);
        this.nnu = (HorizontalScrollView) findViewById(R.id.so);
        this.nnv = (AppBrandActionSingleHeaderView) findViewById(R.id.t0);
        this.nnw = (AppBrandActionMultipleHeaderView) findViewById(R.id.su);
        this.nnx = (AppBrandActionMultipleHeaderView) findViewById(R.id.sv);
        this.nny = (AppBrandActionMultipleHeaderView) findViewById(R.id.sw);
        this.nnz = (AppBrandActionMultipleHeaderView) findViewById(R.id.sx);
        this.nnA = (TextView) findViewById(R.id.sr);
        this.nnw.setVisibility(8);
        this.nnx.setVisibility(8);
        this.nny.setVisibility(8);
        this.nnz.setVisibility(8);
        this.nnA.setVisibility(8);
        AppMethodBeat.o(147436);
    }

    public void setActionHeaderStyle(boolean z) {
        AppMethodBeat.i(147437);
        if (z) {
            this.nnv.setTextViewTextColor(this.mContext.getResources().getColor(R.color.ag2));
            this.nnw.setTextViewTextColor(this.mContext.getResources().getColor(R.color.ag2));
            this.nnx.setTextViewTextColor(this.mContext.getResources().getColor(R.color.ag2));
            this.nny.setTextViewTextColor(this.mContext.getResources().getColor(R.color.ag2));
            this.nnz.setTextViewTextColor(this.mContext.getResources().getColor(R.color.ag2));
            this.nnA.setTextColor(this.mContext.getResources().getColor(R.color.ag2));
            AppMethodBeat.o(147437);
            return;
        }
        this.nnv.setTextViewTextColor(this.mContext.getResources().getColor(R.color.g0));
        this.nnw.setTextViewTextColor(this.mContext.getResources().getColor(R.color.g0));
        this.nnx.setTextViewTextColor(this.mContext.getResources().getColor(R.color.g0));
        this.nny.setTextViewTextColor(this.mContext.getResources().getColor(R.color.g0));
        this.nnz.setTextViewTextColor(this.mContext.getResources().getColor(R.color.g0));
        this.nnA.setTextColor(this.mContext.getResources().getColor(R.color.g0));
        AppMethodBeat.o(147437);
    }

    @Deprecated
    public void setAppId(String str) {
    }

    public void setStatusDescription(CharSequence charSequence) {
        AppMethodBeat.i(147438);
        this.nnA.setText(charSequence);
        this.nnA.setVisibility(0);
        this.nnt.setVisibility(8);
        this.nnu.setVisibility(8);
        AppMethodBeat.o(147438);
    }

    public TextView getStatusTextView() {
        return this.nnA;
    }
}
