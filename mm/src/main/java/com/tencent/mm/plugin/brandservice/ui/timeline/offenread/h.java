package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class h extends RecyclerView.l {
    private int atO = -1;
    Context mContext;
    private float mFs = ((float) ViewConfiguration.get(MMApplicationContext.getContext()).getScaledTouchSlop());
    private int mLastState = 0;
    int mOffsetX;
    RecyclerView.r mSmoothScroller;
    int oDP;
    int oDQ = 0;
    RecyclerView.r oDR;
    int oDS;
    private boolean oDU = false;
    LinearLayoutManager oDV;
    private boolean oDW = false;
    private boolean oDY = false;
    private boolean oDZ = false;
    private boolean oEa = false;
    private int owQ = 0;
    int owW = 0;
    BizTimeLineHotListView pzW;
    private b pzX = null;
    a pzY = null;

    public interface a {
        void Dk(int i2);

        void V(int i2, boolean z);
    }

    public interface b {
    }

    public h(int i2) {
        AppMethodBeat.i(6143);
        this.owQ = i2;
        AppMethodBeat.o(6143);
    }

    private void ccY() {
        this.oDU = false;
        this.oDW = false;
        this.pzX = null;
        this.atO = -1;
    }

    @Override // android.support.v7.widget.RecyclerView.l
    public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
        AppMethodBeat.i(6144);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(recyclerView);
        bVar.pH(i2);
        bVar.pH(i3);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineViewPagerHelper", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
        super.onScrolled(recyclerView, i2, i3);
        this.oDQ += i2;
        if (!(this.pzY == null || (i2 == 0 && i3 == 0))) {
            this.pzY.Dk(this.oDQ);
        }
        this.mOffsetX += i2;
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineViewPagerHelper", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(6144);
    }

    @Override // android.support.v7.widget.RecyclerView.l
    public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
        AppMethodBeat.i(6145);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(recyclerView);
        bVar.pH(i2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineViewPagerHelper", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
        super.onScrollStateChanged(recyclerView, i2);
        Log.i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo onScrollStateChanged newState: %d", Integer.valueOf(i2));
        if (i2 == 0 && this.mLastState != 2) {
            int AE = AE(this.mOffsetX);
            if (this.pzW != null && this.oDZ) {
                this.mSmoothScroller.atO = AE;
                this.oEa = true;
                this.pzW.getLayoutManager().startSmoothScroll(this.mSmoothScroller);
            }
            this.oDY = true;
        } else if (!this.oDY && i2 == 2) {
            this.oDY = true;
        } else if (i2 == 0) {
            this.oDP = this.mOffsetX;
            this.oDY = false;
            int i3 = this.owW;
            int ks = this.oDV.ks();
            Log.i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo onScrollStateChanged firstPos: %d", Integer.valueOf(ks));
            if (ks != -1) {
                this.owW = ks / this.oDS;
                Log.i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo onScrollStateChanged mCurPage: %d, firstVisible: %d", Integer.valueOf(this.owW), Integer.valueOf(ks));
                if (!(i3 == this.owW || this.pzY == null)) {
                    this.pzY.V(this.owW, !this.oDZ);
                }
            } else {
                Log.e("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo onScrollStateChanged firstPos is -1, invalid, mCurPage: %d", Integer.valueOf(this.owW));
            }
            this.oDZ = false;
            this.oDQ = 0;
            if (this.oDW) {
                Log.d("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo scrollMore");
                this.pzW.getAdapter().aq(this.pzW.getDataCount(), 5);
                b bVar2 = this.pzX;
                this.oDW = false;
                int dataCount = this.pzW.getDataCount();
                int i4 = dataCount / this.oDS;
                if (dataCount % this.oDS == 0) {
                    i4++;
                }
                int i5 = i4 + 1;
                int i6 = this.oDS * i5;
                if (i6 <= 0) {
                    i6 = 0;
                }
                Log.i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo smoothScrollToLastPage allCount: %d, lastPage: %d, targetPos: %d", Integer.valueOf(dataCount), Integer.valueOf(i5), Integer.valueOf(i6));
                this.pzX = bVar2;
                this.oDU = true;
                int AG = AG(i6);
                this.atO = AH(AG);
                this.owW = AG(this.oDV.kt());
                Log.i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo fastScroll curPage: %d, pos: %d, targetPage: %d, targetPos: %d", Integer.valueOf(this.owW), Integer.valueOf(i6), Integer.valueOf(AG), Integer.valueOf(this.atO));
                if (AG == this.owW) {
                    ccZ();
                } else {
                    W(this.atO, true);
                }
            } else {
                ccZ();
            }
            if (this.oEa) {
                Log.i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo scrollBy x: -1, y: 0");
                this.oEa = false;
                this.pzW.scrollBy(-1, 0);
            }
        } else if (i2 == 1) {
            Log.i("MicroMsg.BizTimeLineViewPagerHelper", "SCROLL_STATE_DRAGGING");
            this.oDZ = true;
        }
        this.mLastState = i2;
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineViewPagerHelper", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(6145);
    }

    /* access modifiers changed from: package-private */
    public final void ccZ() {
        AppMethodBeat.i(6146);
        if (this.oDU) {
            Log.i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo onScrollAnimationEnd");
            ccY();
        }
        AppMethodBeat.o(6146);
    }

    /* access modifiers changed from: package-private */
    public final int AE(int i2) {
        AppMethodBeat.i(6147);
        int i3 = this.owW;
        float width = (float) this.pzW.getWidth();
        int i4 = this.owW;
        Log.d("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo getOffsetToPosition offset: %d, mTmpOffset: %d, diff: %d, width: %s, mTouchSlop: %s, curPage: %d", Integer.valueOf(i2), Integer.valueOf(this.oDP), Integer.valueOf(i2 - this.oDP), Float.valueOf(width), Float.valueOf(this.mFs), Integer.valueOf(this.owW));
        if (((float) (i2 - this.oDP)) >= width / 2.0f) {
            i3 = AG(this.oDV.ku());
        } else if (i2 - this.oDP >= 0 && ((float) (i2 - this.oDP)) < this.mFs) {
            Log.i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo [getOffsetToPosition] targetPage: %s targetPos: %s", Integer.valueOf(i3), Integer.valueOf(AF(i3)));
            int AF = AF(i3);
            AppMethodBeat.o(6147);
            return AF;
        } else if (((float) (i2 - this.oDP)) <= (-width) / 2.0f) {
            i3 = AG(this.oDV.ks());
        }
        int itemCount = this.pzW.getAdapter().getItemCount();
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
        Log.i("MicroMsg.BizTimeLineViewPagerHelper", "[getOffsetToPosition] lastPage: %d, targetPage: %d targetPos: %d", Integer.valueOf(i4), Integer.valueOf(max), Integer.valueOf(AH(max)));
        int AF2 = AF(max);
        AppMethodBeat.o(6147);
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
        AppMethodBeat.i(6148);
        if (this.pzW != null && (this.oDZ || z)) {
            this.oDR.atO = i2;
            this.oEa = true;
            this.pzW.getLayoutManager().startSmoothScroll(this.oDR);
        }
        AppMethodBeat.o(6148);
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
        AppMethodBeat.i(6149);
        if (i2 == 0) {
            AppMethodBeat.o(6149);
            return 0;
        }
        int completelyCountPerPage = (a.getCompletelyCountPerPage() * i2) + 1;
        AppMethodBeat.o(6149);
        return completelyCountPerPage;
    }

    public static int Dl(int i2) {
        AppMethodBeat.i(6150);
        int completelyCountPerPage = ((i2 + 1) * a.getCompletelyCountPerPage()) + 1;
        AppMethodBeat.o(6150);
        return completelyCountPerPage;
    }
}
