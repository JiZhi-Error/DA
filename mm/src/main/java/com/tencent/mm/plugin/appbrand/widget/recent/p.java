package com.tencent.mm.plugin.appbrand.widget.recent;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class p extends RecyclerView.l {
    private int atO = -1;
    Context mContext;
    private float mFs = ((float) ViewConfiguration.get(MMApplicationContext.getContext()).getScaledTouchSlop());
    private int mLastState = 0;
    int mOffsetX;
    RecyclerView.r mSmoothScroller;
    BaseAppBrandRecentView oDO;
    private int oDP;
    private int oDQ = 0;
    RecyclerView.r oDR;
    int oDS;
    private b oDT = null;
    private boolean oDU = false;
    LinearLayoutManager oDV;
    private boolean oDW = false;
    a oDX = null;
    private boolean oDY = false;
    private boolean oDZ = false;
    private boolean oEa = false;
    private int owQ = 0;
    int owW = 0;

    public interface a {
        void V(int i2, boolean z);

        void c(RecyclerView recyclerView, int i2);

        void c(RecyclerView recyclerView, int i2, int i3);
    }

    public interface b {
    }

    public p(int i2) {
        AppMethodBeat.i(227841);
        this.owQ = i2;
        AppMethodBeat.o(227841);
    }

    private void ccY() {
        this.oDU = false;
        this.oDW = false;
        this.oDT = null;
        this.atO = -1;
    }

    @Override // android.support.v7.widget.RecyclerView.l
    public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
        AppMethodBeat.i(227842);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(recyclerView);
        bVar.pH(i2);
        bVar.pH(i3);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/recent/ViewPagerHelper", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
        super.onScrolled(recyclerView, i2, i3);
        this.oDQ += i2;
        if (this.oDX != null) {
            this.oDX.c(recyclerView, this.oDQ);
        }
        this.mOffsetX += i2;
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/recent/ViewPagerHelper", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(227842);
    }

    @Override // android.support.v7.widget.RecyclerView.l
    public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
        AppMethodBeat.i(227843);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(recyclerView);
        bVar.pH(i2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/recent/ViewPagerHelper", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
        super.onScrollStateChanged(recyclerView, i2);
        Log.i("ViewPagerHelper", "alvinluo onScrollStateChanged newState: %d", Integer.valueOf(i2));
        if (this.oDX != null) {
            this.oDX.c(recyclerView, i2, this.oDQ);
        }
        if (i2 == 0 && this.mLastState != 2) {
            int AE = AE(this.mOffsetX);
            if (this.oDO != null && this.oDZ) {
                this.mSmoothScroller.atO = AE;
                this.oEa = true;
                this.oDO.getLayoutManager().startSmoothScroll(this.mSmoothScroller);
            }
            this.oDY = true;
        } else if (!this.oDY && i2 == 2) {
            this.oDY = true;
        } else if (i2 == 0) {
            this.oDP = this.mOffsetX;
            this.oDY = false;
            int i3 = this.owW;
            int ks = this.oDV.ks();
            Log.i("ViewPagerHelper", "alvinluo onScrollStateChanged firstPos: %d", Integer.valueOf(ks));
            if (ks != -1) {
                this.owW = ks / this.oDS;
                Log.i("ViewPagerHelper", "alvinluo onScrollStateChanged mCurPage: %d, firstVisible: %d", Integer.valueOf(this.owW), Integer.valueOf(ks));
                if (!(i3 == this.owW || this.oDX == null)) {
                    this.oDX.V(this.owW, !this.oDZ);
                }
            } else {
                Log.e("ViewPagerHelper", "alvinluo onScrollStateChanged firstPos is -1, invalid, mCurPage: %d", Integer.valueOf(this.owW));
            }
            this.oDZ = false;
            this.oDQ = 0;
            if (this.oDW) {
                Log.d("ViewPagerHelper", "alvinluo scrollMore");
                d.ccS();
                this.oDW = false;
                this.oDT = this.oDT;
                this.oDU = true;
                int AG = AG(0);
                this.atO = AH(AG);
                this.owW = AG(this.oDV.kt());
                Log.i("ViewPagerHelper", "alvinluo fastScroll curPage: %d, pos: %d, targetPage: %d, targetPos: %d", Integer.valueOf(this.owW), 0, Integer.valueOf(AG), Integer.valueOf(this.atO));
                W(this.atO, true);
                ccZ();
            } else {
                ccZ();
            }
            if (this.oEa) {
                Log.i("ViewPagerHelper", "alvinluo scrollBy x: -1, y: 0");
                this.oEa = false;
                this.oDO.scrollBy(-1, 0);
            }
        } else if (i2 == 1) {
            Log.i("ViewPagerHelper", "SCROLL_STATE_DRAGGING");
            this.oDZ = true;
        }
        this.mLastState = i2;
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/recent/ViewPagerHelper", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(227843);
    }

    /* access modifiers changed from: package-private */
    public final void ccZ() {
        AppMethodBeat.i(227844);
        if (this.oDU) {
            Log.i("ViewPagerHelper", "alvinluo onScrollAnimationEnd");
            ccY();
        }
        AppMethodBeat.o(227844);
    }

    /* access modifiers changed from: package-private */
    public final int AE(int i2) {
        AppMethodBeat.i(227845);
        int i3 = this.owW;
        float width = (float) this.oDO.getWidth();
        int i4 = this.owW;
        Log.d("ViewPagerHelper", "alvinluo getOffsetToPosition offset: %d, mTmpOffset: %d, diff: %d, width: %s, mTouchSlop: %s, curPage: %d", Integer.valueOf(i2), Integer.valueOf(this.oDP), Integer.valueOf(i2 - this.oDP), Float.valueOf(width), Float.valueOf(this.mFs), Integer.valueOf(this.owW));
        if (((float) (i2 - this.oDP)) >= width / 2.0f) {
            i3 = AG(this.oDV.ku());
        } else if (i2 - this.oDP >= 0 && ((float) (i2 - this.oDP)) < this.mFs) {
            Log.i("ViewPagerHelper", "alvinluo [getOffsetToPosition] targetPage: %s targetPos: %s", Integer.valueOf(i3), Integer.valueOf(AF(i3)));
            int AF = AF(i3);
            AppMethodBeat.o(227845);
            return AF;
        } else if (((float) (i2 - this.oDP)) <= (-width) / 2.0f) {
            i3 = AG(this.oDV.ks());
        }
        int itemCount = this.oDO.getAdapter().getItemCount();
        int i5 = itemCount / this.oDS;
        if (itemCount % this.oDS != 0) {
            i5++;
        }
        int max = Math.max(Math.min(i3, i5 - 1), -1);
        if (max - i4 > 1) {
            max = i4 + 1;
        } else if (i4 - max > 1) {
            max = i4 - 1;
        }
        Log.i("ViewPagerHelper", "[getOffsetToPosition] lastPage: %d, targetPage: %d targetPos: %d", Integer.valueOf(i4), Integer.valueOf(max), Integer.valueOf(AH(max)));
        int AF2 = AF(max);
        AppMethodBeat.o(227845);
        return AF2;
    }

    private int AF(int i2) {
        if (i2 == 0) {
            return 0;
        }
        return (this.oDS * i2) + this.owQ;
    }

    /* access modifiers changed from: package-private */
    public final void W(int i2, boolean z) {
        AppMethodBeat.i(227846);
        if (this.oDO != null && (this.oDZ || z)) {
            this.oDR.atO = i2;
            this.oEa = true;
            this.oDO.getLayoutManager().startSmoothScroll(this.oDR);
        }
        AppMethodBeat.o(227846);
    }

    private int AG(int i2) {
        if (this.owQ == 0) {
            return i2 / this.oDS;
        }
        int i3 = i2 / this.oDS;
        if (i2 % this.oDS != 0 || i2 == 0) {
            return i3;
        }
        return i3 - 1;
    }

    public static int AH(int i2) {
        AppMethodBeat.i(227847);
        if (i2 == 0) {
            AppMethodBeat.o(227847);
            return 0;
        }
        d.ccS();
        int completelyCountPerPage = (d.getCompletelyCountPerPage() * i2) + 1;
        AppMethodBeat.o(227847);
        return completelyCountPerPage;
    }
}
