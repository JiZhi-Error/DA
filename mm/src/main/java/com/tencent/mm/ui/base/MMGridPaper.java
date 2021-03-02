package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.base.MMFlipper;
import com.tencent.mm.ui.base.j;
import junit.framework.Assert;

public final class MMGridPaper extends LinearLayout {
    protected int OOj = 10;
    protected int OOk = 10;
    final MMFlipper.c OPW = new MMFlipper.c() {
        /* class com.tencent.mm.ui.base.MMGridPaper.AnonymousClass5 */

        @Override // com.tencent.mm.ui.base.MMFlipper.c
        public final void z(int i2, final int i3, boolean z) {
            AppMethodBeat.i(164148);
            Log.d("MicroMsg.MMGridPaper", "onScreenChanged:curScreen[%d], topEdge[%d], bottomEdge[%d], virtualPage[%d]", Integer.valueOf(i3), Integer.valueOf(MMGridPaper.this.OQt), Integer.valueOf(MMGridPaper.this.OQu), Integer.valueOf(MMGridPaper.this.OQv));
            if (i3 <= MMGridPaper.this.OQt && MMGridPaper.this.OQt > 0) {
                MMGridPaper.this.wMu.post(new Runnable() {
                    /* class com.tencent.mm.ui.base.MMGridPaper.AnonymousClass5.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(141966);
                        MMGridPaperGridView mMGridPaperGridView = (MMGridPaperGridView) MMGridPaper.this.OQm.getChildAt(MMGridPaper.this.OQm.getChildCount() - 1);
                        int childCount = i3 - (MMGridPaper.this.OQm.getChildCount() >> 1);
                        Log.i("MicroMsg.MMGridPaper", "move up, old index[%d], new index[%d]", Integer.valueOf(MMGridPaper.this.OQm.getChildCount() - 1), Integer.valueOf(childCount));
                        MMGridPaper.this.OQm.removeViewAt(MMGridPaper.this.OQm.getChildCount() - 1);
                        mMGridPaperGridView.a(childCount, MMGridPaper.this.mNumRows, MMGridPaper.this.mNumColumns, MMGridPaper.this.OQn);
                        MMGridPaper.this.OQm.addView(mMGridPaperGridView, 0);
                        MMGridPaper.this.OQm.alx(MMGridPaper.this.OQm.getChildCount() >> 1);
                        MMGridPaper.a(MMGridPaper.this, -1);
                        AppMethodBeat.o(141966);
                    }
                });
            } else if (i3 >= MMGridPaper.this.OQu && MMGridPaper.this.OQu < MMGridPaper.this.OQv - 1) {
                MMGridPaper.this.wMu.post(new Runnable() {
                    /* class com.tencent.mm.ui.base.MMGridPaper.AnonymousClass5.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(141967);
                        MMGridPaperGridView mMGridPaperGridView = (MMGridPaperGridView) MMGridPaper.this.OQm.getChildAt(0);
                        int childCount = i3 + (MMGridPaper.this.OQm.getChildCount() >> 1);
                        Log.i("MicroMsg.MMGridPaper", "move down, old index[0], new index[%d]", Integer.valueOf(childCount));
                        MMGridPaper.this.OQm.removeViewAt(0);
                        mMGridPaperGridView.a(childCount, MMGridPaper.this.mNumRows, MMGridPaper.this.mNumColumns, MMGridPaper.this.OQn);
                        MMGridPaper.this.OQm.addView(mMGridPaperGridView);
                        MMGridPaper.this.OQm.alx(MMGridPaper.this.OQm.getChildCount() >> 1);
                        MMGridPaper.a(MMGridPaper.this, 1);
                        AppMethodBeat.o(141967);
                    }
                });
            }
            MMGridPaper.this.OQr = i3;
            MMGridPaper.this.oxc.setSelectedDot(i3);
            AppMethodBeat.o(164148);
        }
    };
    final MMFlipper.b OPY = new MMFlipper.b() {
        /* class com.tencent.mm.ui.base.MMGridPaper.AnonymousClass4 */

        @Override // com.tencent.mm.ui.base.MMFlipper.b
        public final void ig(int i2, int i3) {
            AppMethodBeat.i(141965);
            Log.v("MicroMsg.MMGridPaper", "onMeasure width:[new %d, old %d] height:[new %d, old %d], dialogMode[%B], orientationChange[%B]", Integer.valueOf(i2), Integer.valueOf(MMGridPaper.this.OQo), Integer.valueOf(i3), Integer.valueOf(MMGridPaper.this.OQp), Boolean.valueOf(MMGridPaper.this.OQD), Boolean.valueOf(MMGridPaper.this.OQC));
            if ((Math.abs(MMGridPaper.this.OQp - i3) < 50 && Math.abs(MMGridPaper.this.OQo - i2) < 50) || i3 == 0 || i2 == 0) {
                Log.d("MicroMsg.MMGridPaper", "match width height limit, return");
                AppMethodBeat.o(141965);
            } else if (!MMGridPaper.this.OQD || MMGridPaper.this.OQo <= i2 || MMGridPaper.this.OQC) {
                Log.v("MicroMsg.MMGridPaper", "onMeasure: match");
                Log.v("MicroMsg.MMGridPaper", "onMeasure: mIsManualMeasureMode[%b]", Boolean.valueOf(MMGridPaper.this.OQG));
                MMGridPaper.this.OQC = false;
                if (!MMGridPaper.this.OQG) {
                    MMGridPaper.this.OQp = i3;
                    MMGridPaper.this.OQo = i2;
                }
                MMGridPaper.this.refresh();
                AppMethodBeat.o(141965);
            } else {
                Log.d("MicroMsg.MMGridPaper", "match ori limit, return");
                AppMethodBeat.o(141965);
            }
        }
    };
    protected int OQA = 96;
    protected int OQB = 96;
    protected boolean OQC = false;
    protected boolean OQD = false;
    protected int OQE = -1;
    protected int OQF = -1;
    protected boolean OQG = false;
    protected int OQH = 0;
    protected int OQI = 0;
    protected a OQJ;
    protected MMFlipper OQm;
    protected j OQn;
    protected int OQo;
    protected int OQp;
    protected int OQq = 0;
    protected int OQr = 0;
    protected int OQs = 3;
    protected int OQt = 0;
    protected int OQu = (this.OQs - 1);
    protected int OQv = 0;
    protected boolean OQw = false;
    protected int OQx = 9;
    protected int OQy = -1;
    protected int OQz = -1;
    protected View agA;
    protected int mCurrentOrientation = 0;
    protected int mMaxColumns = -1;
    protected int mMaxRows = -1;
    protected int mNumColumns = 0;
    protected int mNumRows = 0;
    protected MMDotView oxc;
    protected MMHandler wMu = new MMHandler(Looper.getMainLooper());

    public interface a {
    }

    static /* synthetic */ void a(MMGridPaper mMGridPaper) {
        AppMethodBeat.i(141984);
        mMGridPaper.eRp();
        AppMethodBeat.o(141984);
    }

    public MMGridPaper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(141969);
        View.inflate(getContext(), R.layout.b8a, this);
        this.mCurrentOrientation = getScreenOrientation();
        AppMethodBeat.o(141969);
    }

    public final void setOnPageSizeChangeListener(a aVar) {
        this.OQJ = aVar;
    }

    public final void setMaxDotCount(int i2) {
        this.OQx = i2;
    }

    public final void setItemWidthInDp(int i2) {
        this.OQA = i2;
    }

    public final void setItemHeightInDp(int i2) {
        this.OQB = i2;
    }

    public final void setMaxRow(int i2) {
        this.mMaxRows = i2;
    }

    public final void setMaxCol(int i2) {
        this.mMaxColumns = i2;
    }

    public final void setDisplayHeightLandInDp(int i2) {
        this.OQy = i2;
    }

    public final void setDisplayHeightPortInDp(int i2) {
        this.OQz = i2;
    }

    public final void setDialogMode(boolean z) {
        this.OQD = z;
    }

    public final void gKG() {
        this.OQF = 3;
        this.OQE = 3;
    }

    public final void gKH() {
        this.OOj = 8;
        this.OOk = 15;
    }

    public final void setHeaderView(View view) {
        AppMethodBeat.i(141970);
        this.agA = view;
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.dnz);
        viewGroup.removeAllViews();
        if (this.agA != null) {
            viewGroup.addView(this.agA);
        }
        AppMethodBeat.o(141970);
    }

    public final void setGridPaperAdapter(j jVar) {
        boolean z = true;
        AppMethodBeat.i(141971);
        this.OQn = jVar;
        Object[] objArr = new Object[1];
        if (jVar != null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        Log.d("MicroMsg.MMGridPaper", "setGridPaperAdapter:adapter is null[%B]", objArr);
        if (this.OQn != null) {
            this.OQn.OQN = new j.a() {
                /* class com.tencent.mm.ui.base.MMGridPaper.AnonymousClass1 */

                @Override // com.tencent.mm.ui.base.j.a
                public final void cmy() {
                    AppMethodBeat.i(141962);
                    MMGridPaper.this.refresh();
                    AppMethodBeat.o(141962);
                }
            };
        }
        gpW();
        AppMethodBeat.o(141971);
    }

    public final void refresh() {
        AppMethodBeat.i(141972);
        this.OQq = this.OQr * this.mNumColumns * this.mNumRows;
        Log.v("MicroMsg.MMGridPaper", "refreshed:virtualPage[%d], col[%d], row[%d], scrollCount[%d]", Integer.valueOf(this.OQr), Integer.valueOf(this.mNumColumns), Integer.valueOf(this.mNumRows), Integer.valueOf(this.OQq));
        gpW();
        AppMethodBeat.o(141972);
    }

    public final int getPageCount() {
        return this.OQv;
    }

    public final int getItemsCountPerPage() {
        return this.mNumRows * this.mNumColumns;
    }

    private int getScreenOrientation() {
        int i2;
        AppMethodBeat.i(141973);
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        if (defaultDisplay.getWidth() < defaultDisplay.getHeight()) {
            i2 = 1;
        } else {
            i2 = 2;
        }
        AppMethodBeat.o(141973);
        return i2;
    }

    private void gKI() {
        AppMethodBeat.i(141974);
        if (-1 == this.OQy || getScreenOrientation() != 2) {
            if (-1 != this.OQz && getScreenOrientation() == 1) {
                View findViewById = findViewById(R.id.dl4);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
                int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix(getContext(), this.OQz);
                if (fromDPToPix != layoutParams.height) {
                    Log.i("MicroMsg.MMGridPaper", "set port mode, special height is %d", Integer.valueOf(this.OQz));
                    layoutParams.height = fromDPToPix;
                    findViewById.setLayoutParams(layoutParams);
                    this.wMu.post(new Runnable() {
                        /* class com.tencent.mm.ui.base.MMGridPaper.AnonymousClass3 */

                        public final void run() {
                            AppMethodBeat.i(141964);
                            Log.w("MicroMsg.MMGridPaper", "post do setDotView");
                            MMGridPaper.a(MMGridPaper.this);
                            AppMethodBeat.o(141964);
                        }
                    });
                }
            }
            AppMethodBeat.o(141974);
            return;
        }
        View findViewById2 = findViewById(R.id.dl4);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) findViewById2.getLayoutParams();
        int fromDPToPix2 = com.tencent.mm.cb.a.fromDPToPix(getContext(), this.OQy);
        if (fromDPToPix2 != layoutParams2.height) {
            Log.i("MicroMsg.MMGridPaper", "set land mode, special height is %d", Integer.valueOf(this.OQy));
            layoutParams2.height = fromDPToPix2;
            findViewById2.setLayoutParams(layoutParams2);
            this.wMu.post(new Runnable() {
                /* class com.tencent.mm.ui.base.MMGridPaper.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(141963);
                    Log.w("MicroMsg.MMGridPaper", "post do setDotView");
                    MMGridPaper.a(MMGridPaper.this);
                    AppMethodBeat.o(141963);
                }
            });
        }
        AppMethodBeat.o(141974);
    }

    private void gpW() {
        AppMethodBeat.i(141975);
        Log.v("MicroMsg.MMGridPaper", "MMGridPaper initFlipper");
        if (this.oxc == null) {
            this.oxc = (MMDotView) findViewById(R.id.dl5);
            this.oxc.setMaxCount(this.OQx);
        }
        if (this.OQm == null) {
            this.OQm = (MMFlipper) findViewById(R.id.dl6);
            this.OQm.setOnMeasureListener(this.OPY);
            this.OQm.setOnScreenChangedListener(this.OPW);
        }
        gKI();
        gKJ();
        AppMethodBeat.o(141975);
    }

    private boolean alz(int i2) {
        AppMethodBeat.i(141976);
        Log.d("MicroMsg.MMGridPaper", "totalCount is %d, dialogMode is %B", Integer.valueOf(i2), Boolean.valueOf(this.OQD));
        Assert.assertTrue(i2 >= 0);
        if (!this.OQD) {
            AppMethodBeat.o(141976);
            return true;
        }
        int kT = kT(i2, this.mNumColumns);
        int screenOrientation = getScreenOrientation();
        switch (screenOrientation) {
            case 1:
                int min = Math.min(kT, this.OQE);
                int i3 = ((this.OQB + 10) * min) + 8;
                Log.d("MicroMsg.MMGridPaper", "orientation[%d], minRows[%d], targetHeight[%d], displayHeight[%d], orientationChange[%B]", Integer.valueOf(screenOrientation), Integer.valueOf(min), Integer.valueOf(i3), Integer.valueOf(this.OQz), Boolean.valueOf(this.OQC));
                if (this.OQz != i3) {
                    this.OQz = i3;
                    AppMethodBeat.o(141976);
                    return false;
                }
                AppMethodBeat.o(141976);
                return true;
            case 2:
                int min2 = Math.min(kT, this.OQF);
                int i4 = ((this.OQB + 10) * min2) + 8;
                Log.d("MicroMsg.MMGridPaper", "orientation[%d], minRows[%d], targetHeight[%d], displayHeight[%d], orientationChange[%B]", Integer.valueOf(screenOrientation), Integer.valueOf(min2), Integer.valueOf(i4), Integer.valueOf(this.OQy), Boolean.valueOf(this.OQC));
                if (this.OQy != i4) {
                    this.OQy = i4;
                    AppMethodBeat.o(141976);
                    return false;
                }
                AppMethodBeat.o(141976);
                return true;
            default:
                AppMethodBeat.o(141976);
                return true;
        }
    }

    public final void setGridWidth(int i2) {
        this.OQo = i2;
    }

    public final void setGridHeight(int i2) {
        this.OQp = i2;
    }

    public final void setManualMeasureMode(boolean z) {
        this.OQG = z;
    }

    private void gKJ() {
        AppMethodBeat.i(141977);
        Log.v("MicroMsg.MMGridPaper", "initSubGrid, grid width %d, grid height %d", Integer.valueOf(this.OQo), Integer.valueOf(this.OQp));
        if (this.OQo == 0 || this.OQp == 0) {
            Log.w("MicroMsg.MMGridPaper", "initSubGrid:gridWithd or gridHeight is 0");
            AppMethodBeat.o(141977);
            return;
        }
        int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix(getContext(), this.OQA);
        int fromDPToPix2 = com.tencent.mm.cb.a.fromDPToPix(getContext(), this.OQB);
        int max = Math.max(this.OQo / fromDPToPix, 1);
        int max2 = Math.max(this.OQp / fromDPToPix2, 1);
        if (!(max == this.mNumColumns && max2 == this.mNumRows)) {
            this.OQw = true;
        }
        this.mNumColumns = max;
        if (this.mMaxColumns != -1) {
            this.mNumColumns = Math.min(this.mNumColumns, this.mMaxColumns);
        }
        this.mNumRows = max2;
        if (this.mMaxRows != -1) {
            this.mNumRows = Math.min(this.mNumRows, this.mMaxRows);
        }
        int i2 = this.mNumRows * this.mNumColumns;
        this.OQv = 0;
        int count = (this.OQn == null ? 0 : this.OQn.getCount()) + 0;
        if (!alz(count)) {
            gKI();
            AppMethodBeat.o(141977);
            return;
        }
        this.OQv = kT(count, i2);
        this.OQr = Math.min(this.OQv - 1, kU(this.OQq, i2));
        this.OQs = Math.min(3, this.OQv);
        this.OQt = Math.min(this.OQv - this.OQs, Math.max(0, this.OQr - (this.OQs >> 1)));
        this.OQu = (this.OQt + this.OQs) - 1;
        Log.d("MicroMsg.MMGridPaper", "initSubGrid:item[%ddp,%ddp], row[%d], column[%d], activePage[%d], virtualPage[%d], curVirtualPage[%d], edge[%d, %d]", Integer.valueOf(this.OQA), Integer.valueOf(this.OQB), Integer.valueOf(this.mNumRows), Integer.valueOf(this.mNumColumns), Integer.valueOf(this.OQs), Integer.valueOf(this.OQv), Integer.valueOf(this.OQr), Integer.valueOf(this.OQt), Integer.valueOf(this.OQu));
        if (this.OQm.getChildCount() != this.OQs || this.OQw) {
            Log.w("MicroMsg.MMGridPaper", "error child count or RowOrColChanged(%B), reset child view", Boolean.valueOf(this.OQw));
            this.OQw = false;
            this.OQm.removeAllViews();
            for (int i3 = this.OQt; i3 <= this.OQu; i3++) {
                MMGridPaperGridView mMGridPaperGridView = (MMGridPaperGridView) inflate(getContext(), R.layout.b81, null);
                mMGridPaperGridView.a(i3, this.mNumRows, this.mNumColumns, this.OQn);
                mMGridPaperGridView.setHorizontalSpacing(com.tencent.mm.cb.a.fromDPToPix(getContext(), this.OOj));
                mMGridPaperGridView.setVerticalSpacing(com.tencent.mm.cb.a.fromDPToPix(getContext(), this.OOk));
                this.OQm.addView(mMGridPaperGridView, new LinearLayout.LayoutParams(-1, -1));
            }
        } else {
            for (int i4 = this.OQt; i4 <= this.OQu; i4++) {
                MMGridPaperGridView mMGridPaperGridView2 = (MMGridPaperGridView) this.OQm.getChildAt(i4 - this.OQt);
                if (mMGridPaperGridView2.getIndex() != i4) {
                    Log.w("MicroMsg.MMGridPaper", "old index %d, new index %d, reset it", Integer.valueOf(mMGridPaperGridView2.getIndex()), Integer.valueOf(i4));
                    mMGridPaperGridView2.a(i4, this.mNumRows, this.mNumColumns, this.OQn);
                    mMGridPaperGridView2.notifyDataSetChanged();
                } else {
                    Log.v("MicroMsg.MMGridPaper", "same grid index, continus");
                }
            }
        }
        eRp();
        AppMethodBeat.o(141977);
    }

    private static int kT(int i2, int i3) {
        AppMethodBeat.i(141978);
        if (i3 <= 0) {
            Log.w("MicroMsg.MMGridPaper", "ceil:total[%d], length[%d]", Integer.valueOf(i2), Integer.valueOf(i3));
            AppMethodBeat.o(141978);
            return 0;
        }
        int i4 = i2;
        int i5 = 0;
        while (i4 > 0) {
            i4 -= i3;
            i5++;
        }
        Log.i("MicroMsg.MMGridPaper", "ceil:num[%d], length[%d], result[%d]", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i5));
        AppMethodBeat.o(141978);
        return i5;
    }

    private static int kU(int i2, int i3) {
        AppMethodBeat.i(141979);
        if (i2 == 0 || i3 <= 0) {
            Log.w("MicroMsg.MMGridPaper", "floor:total[%d], length[%d]", Integer.valueOf(i2), Integer.valueOf(i3));
            AppMethodBeat.o(141979);
            return 0;
        }
        int i4 = i2;
        int i5 = 0;
        while (i4 >= i3) {
            i4 -= i3;
            i5++;
        }
        Log.i("MicroMsg.MMGridPaper", "floor:num[%d], length[%d], result[%d]", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i5));
        AppMethodBeat.o(141979);
        return i5;
    }

    private void eRp() {
        AppMethodBeat.i(141980);
        Log.v("MicroMsg.MMGridPaper", "set DotView");
        Assert.assertTrue(this.OQv >= 0);
        this.oxc.setDotCount(this.OQv);
        if (this.OQn == null || this.OQv <= 1) {
            this.oxc.setVisibility(8);
            Log.v("MicroMsg.MMGridPaper", "set DotView gone");
        } else {
            this.oxc.setVisibility(0);
            Log.v("MicroMsg.MMGridPaper", "set DotView visible");
        }
        if (this.OQr >= this.OQv) {
            this.OQr = this.OQv - 1;
        }
        this.OQm.alx(this.OQr - this.OQt);
        this.OQm.aly(this.OQr);
        this.oxc.setSelectedDot(this.OQr);
        AppMethodBeat.o(141980);
    }

    /* access modifiers changed from: protected */
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(141981);
        Log.d("MicroMsg.MMGridPaper", "onLayout left=%s top=%s right=%s bottom=%s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
        if (this.mCurrentOrientation != getScreenOrientation()) {
            this.mCurrentOrientation = getScreenOrientation();
            Log.d("MicroMsg.MMGridPaper", "onLayout, currentOrientation changed, reAdjustDisplayArea");
            this.OQC = true;
            clearAnimation();
            gKI();
            gKJ();
        }
        super.onLayout(z, i2, i3, i4, i5);
        AppMethodBeat.o(141981);
    }

    @TargetApi(8)
    public final void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(141982);
        if (configuration.orientation == 1 || configuration.orientation == 2) {
            Log.d("MicroMsg.MMGridPaper", "onConfigChanged:" + configuration.orientation);
            this.OQC = true;
        }
        AppMethodBeat.o(141982);
    }

    private MMGridPaperGridView getCurrentPage() {
        AppMethodBeat.i(141983);
        MMGridPaperGridView mMGridPaperGridView = (MMGridPaperGridView) this.OQm.getChildAt(this.OQm.getCurScreen());
        AppMethodBeat.o(141983);
        return mMGridPaperGridView;
    }

    static /* synthetic */ void a(MMGridPaper mMGridPaper, int i2) {
        mMGridPaper.OQt += i2;
        if (mMGridPaper.OQt < 0) {
            mMGridPaper.OQt = 0;
        } else if (mMGridPaper.OQt > mMGridPaper.OQv - mMGridPaper.OQs) {
            mMGridPaper.OQt = mMGridPaper.OQv - mMGridPaper.OQs;
        }
        mMGridPaper.OQu = (mMGridPaper.OQt + mMGridPaper.OQs) - 1;
    }
}
