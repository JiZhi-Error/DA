package com.tencent.mm.plugin.sns.ad.widget.recyclerview;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;

public class CardLayoutManager extends RecyclerView.LayoutManager {
    int DBe;
    int DBf = -1;
    int DBg = -1;
    int DBh = 3;
    int DBi;
    private int DBj = Integer.MIN_VALUE;
    int DBk = Integer.MIN_VALUE;
    private int DBl = 0;
    private float DBm = 0.0f;
    boolean DBn = true;
    public a DBo;
    int DBp = 0;
    private d DBq;
    private final e DBr = new e();
    public c DBs;
    boolean DBt = false;
    private boolean DBu = false;
    int DBv = 0;
    final RecyclerView mRecyclerView;

    public interface c {
        void a(CardLayoutManager cardLayoutManager, int i2);

        void a(CardLayoutManager cardLayoutManager, int i2, int i3);
    }

    public static class f {
        int height;
        int width;
    }

    static /* synthetic */ void d(CardLayoutManager cardLayoutManager) {
        AppMethodBeat.i(202486);
        cardLayoutManager.eYH();
        AppMethodBeat.o(202486);
    }

    public static abstract class d {
        protected int DBA;
        protected int DBx;
        protected int DBy;
        CardLayoutManager DBz;

        public abstract void a(int i2, float f2, View view, int i3, int i4);

        public final void Ye(int i2) {
            this.DBA = i2;
        }

        public final void iq(int i2, int i3) {
            this.DBx = i2;
            this.DBy = i3;
        }

        public boolean Yf(int i2) {
            return false;
        }

        public void fe(View view) {
        }
    }

    public CardLayoutManager(RecyclerView recyclerView) {
        AppMethodBeat.i(202465);
        this.mRecyclerView = recyclerView;
        if (this.mRecyclerView != null) {
            this.mRecyclerView.setOnFlingListener(new b());
            this.DBo = new a(this.mRecyclerView.getContext(), this);
            AppMethodBeat.o(202465);
            return;
        }
        Log.e("SnsAd.CardLayoutManager", "the layout manager will not work properly, because of null recycler view!!!");
        AppMethodBeat.o(202465);
    }

    public final void a(d dVar) {
        this.DBq = dVar;
        if (this.DBq != null) {
            this.DBq.DBz = this;
        }
    }

    public final void eYB() {
        AppMethodBeat.i(202466);
        try {
            if (this.DBo != null && 3000 > 0) {
                this.DBo.eYI();
            }
            AppMethodBeat.o(202466);
        } catch (Throwable th) {
            AppMethodBeat.o(202466);
        }
    }

    public final void eYC() {
        AppMethodBeat.i(202467);
        try {
            if (this.DBo != null) {
                this.DBo.cancel();
            }
            AppMethodBeat.o(202467);
        } catch (Throwable th) {
            AppMethodBeat.o(202467);
        }
    }

    public final RecyclerView.a cWP() {
        AppMethodBeat.i(202468);
        try {
            if (this.mRecyclerView != null) {
                RecyclerView.a adapter = this.mRecyclerView.getAdapter();
                AppMethodBeat.o(202468);
                return adapter;
            }
        } catch (Throwable th) {
        }
        AppMethodBeat.o(202468);
        return null;
    }

    public final int eYD() {
        AppMethodBeat.i(202469);
        try {
            if (this.DBt) {
                int Yb = Yb(this.DBk);
                AppMethodBeat.o(202469);
                return Yb;
            }
        } catch (Throwable th) {
        }
        AppMethodBeat.o(202469);
        return -1;
    }

    public final RecyclerView.v XZ(int i2) {
        RecyclerView.v vVar = null;
        AppMethodBeat.i(202470);
        if (this.mRecyclerView == null) {
            AppMethodBeat.o(202470);
        } else {
            try {
                int childCount = this.mRecyclerView.getChildCount() - 1;
                while (true) {
                    if (childCount < 0) {
                        break;
                    }
                    View childAt = this.mRecyclerView.getChildAt(childCount);
                    if (RecyclerView.bw(childAt) == i2) {
                        vVar = this.mRecyclerView.bi(childAt);
                        AppMethodBeat.o(202470);
                        break;
                    }
                    childCount--;
                }
            } catch (Throwable th) {
            }
            AppMethodBeat.o(202470);
        }
        return vVar;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        AppMethodBeat.i(202471);
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(-2, -2);
        AppMethodBeat.o(202471);
        return layoutParams;
    }

    private void Ya(int i2) {
        if (this.DBk != i2) {
            this.DBj = this.DBk;
            this.DBk = i2;
            this.DBu = true;
        }
    }

    private void ip(int i2, int i3) {
        AppMethodBeat.i(202473);
        Log.d("SnsAd.CardLayoutManager", "firstVirtualPosition is " + i2 + ", lastVirtualPosition " + i3 + ", should notify " + this.DBu);
        c cVar = this.DBs;
        if (!(!this.DBu || cVar == null || i2 == Integer.MIN_VALUE)) {
            int Yb = Yb(i2);
            int i4 = -1;
            if (i3 != Integer.MIN_VALUE) {
                i4 = Yb(i3);
            }
            cVar.a(this, Yb, i4);
        }
        this.DBu = false;
        AppMethodBeat.o(202473);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onMeasure(RecyclerView.n nVar, RecyclerView.s sVar, int i2, int i3) {
        AppMethodBeat.i(202474);
        try {
            d dVar = this.DBq;
            if (dVar == null || !dVar.Yf(i2)) {
                super.onMeasure(nVar, sVar, i2, i3);
            }
            AppMethodBeat.o(202474);
        } catch (Throwable th) {
            AppMethodBeat.o(202474);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.n nVar) {
        AppMethodBeat.i(202475);
        super.onDetachedFromWindow(recyclerView, nVar);
        this.DBe = 0;
        AppMethodBeat.o(202475);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.n nVar, RecyclerView.s sVar) {
        d dVar;
        AppMethodBeat.i(202476);
        this.DBt = false;
        if (sVar == null || nVar == null) {
            Log.e("SnsAd.CardLayoutManager", "the state or recycler is null!!! Right?");
            AppMethodBeat.o(202476);
            return;
        }
        try {
            this.DBi = sVar.getItemCount();
            if (this.DBi == 0 || sVar.aue) {
                Log.d("SnsAd.CardLayoutManager", "there is no item or is pre layout remove all cached view!!");
                removeAndRecycleAllViews(nVar);
                AppMethodBeat.o(202476);
                return;
            }
            if ((this.DBf == -1 || this.DBg == -1) && (dVar = this.DBq) != null) {
                View cp = nVar.cp(0);
                dVar.fe(cp);
                addView(cp);
                measureChildWithMargins(cp, 0, 0);
                this.DBf = getDecoratedMeasuredWidth(cp);
                this.DBg = getDecoratedMeasuredHeight(cp);
                dVar.Ye(this.DBh);
                dVar.iq(this.DBf, this.DBg);
            }
            detachAndScrapAttachedViews(nVar);
            c(nVar, 0);
            AppMethodBeat.o(202476);
        } catch (Throwable th) {
            AppMethodBeat.o(202476);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.s sVar) {
        AppMethodBeat.i(202477);
        try {
            super.onLayoutCompleted(sVar);
            if (!this.DBt) {
                ip(this.DBk, this.DBj);
            }
            this.DBt = true;
            AppMethodBeat.o(202477);
        } catch (Throwable th) {
            AppMethodBeat.o(202477);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        return this.DBf > 0 && this.DBg > 0;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i2, RecyclerView.n nVar, RecyclerView.s sVar) {
        AppMethodBeat.i(202478);
        try {
            SparseBooleanArray sparseBooleanArray = this.DBr.DBB;
            if (sparseBooleanArray != null) {
                for (int i3 = 0; i3 < sparseBooleanArray.size(); i3++) {
                    sparseBooleanArray.put(sparseBooleanArray.keyAt(i3), false);
                }
            }
            this.DBe += i2;
            detachAndScrapAttachedViews(nVar);
            c(nVar, i2);
            e eVar = this.DBr;
            SparseBooleanArray sparseBooleanArray2 = eVar.DBB;
            List<Integer> list = eVar.DBC;
            if (!(sparseBooleanArray2 == null || sparseBooleanArray2.size() == 0 || list == null)) {
                list.clear();
                for (int i4 = 0; i4 < sparseBooleanArray2.size(); i4++) {
                    int keyAt = sparseBooleanArray2.keyAt(i4);
                    boolean z = sparseBooleanArray2.get(keyAt);
                    if (keyAt >= 0 && keyAt < CardLayoutManager.this.DBi && !z) {
                        View cp = nVar.cp(keyAt);
                        Log.d("SnsAd.CardLayoutManager", "pos is " + keyAt + ", recycle view " + cp);
                        CardLayoutManager.this.removeAndRecycleView(cp, nVar);
                        list.add(Integer.valueOf(keyAt));
                    }
                }
                for (Integer num : list) {
                    if (num != null) {
                        sparseBooleanArray2.delete(num.intValue());
                    }
                }
                nVar.clear();
            }
            AppMethodBeat.o(202478);
            return i2;
        } catch (Throwable th) {
            AppMethodBeat.o(202478);
            return 0;
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.s sVar, int i2) {
        AppMethodBeat.i(202479);
        if (sVar == null || this.DBf == 0 || this.DBg == 0) {
            AppMethodBeat.o(202479);
            return;
        }
        try {
            if (sVar.getItemCount() == 0) {
                Log.d("SnsAd.CardLayoutManager", "the item is 0, can't smooth scroll.");
                AppMethodBeat.o(202479);
                return;
            }
            Log.d("SnsAd.CardLayoutManager", "smoothScrollToPosition the position is ".concat(String.valueOf(i2)));
            recyclerView.a((this.DBf * i2) - this.DBe, 0, (Interpolator) null);
            AppMethodBeat.o(202479);
        } catch (Throwable th) {
            AppMethodBeat.o(202479);
        }
    }

    private void c(RecyclerView.n nVar, int i2) {
        float f2 = 0.5f;
        AppMethodBeat.i(202480);
        if (this.DBi == 0 || this.DBf <= 0 || this.DBg <= 0 || this.DBq == null) {
            AppMethodBeat.o(202480);
            return;
        }
        int eYE = eYE();
        int eYF = eYF();
        float eYG = eYG();
        if (this.DBm <= 0.5f || eYG >= 0.5f || i2 >= 0) {
            f2 = eYG;
        }
        for (int i3 = eYE; i3 <= eYF; i3++) {
            int Yb = Yb(i3);
            if (Yb >= 0 && Yb < this.DBi) {
                View cp = nVar.cp(Yb);
                this.DBq.fe(cp);
                if (!(cp == null || this.DBr == null)) {
                    addView(cp, 0);
                    measureChildWithMargins(cp, 0, 0);
                    this.DBq.a(this.DBe, f2, cp, i3 - eYE, i2);
                    this.DBr.Yg(Yb);
                }
            }
        }
        this.DBm = f2;
        Ya(eYE);
        AppMethodBeat.o(202480);
    }

    private int eYE() {
        AppMethodBeat.i(202481);
        if (this.DBf <= 0 || this.DBg <= 0) {
            AppMethodBeat.o(202481);
            return 0;
        }
        int floor = (int) Math.floor((((double) this.DBe) * 1.0d) / ((double) this.DBf));
        AppMethodBeat.o(202481);
        return floor;
    }

    private int eYF() {
        AppMethodBeat.i(202482);
        int eYE = eYE() + this.DBh;
        AppMethodBeat.o(202482);
        return eYE;
    }

    private int Yb(int i2) {
        if (this.DBi == 0) {
            return 0;
        }
        if (i2 >= 0) {
            return i2 % this.DBi;
        }
        if (i2 % this.DBi == 0) {
            return 0;
        }
        int i3 = this.DBi;
        return i3 + (i2 % i3);
    }

    private float eYG() {
        if (this.DBf <= 0 || this.DBg <= 0) {
            return 0.0f;
        }
        if (this.DBe >= 0) {
            return (((float) (this.DBe % this.DBf)) * 1.0f) / ((float) this.DBf);
        }
        if (this.DBe % this.DBf != 0) {
            return ((((float) (this.DBe % this.DBf)) * 1.0f) / ((float) this.DBf)) + 1.0f;
        }
        return 0.0f;
    }

    private int Yc(int i2) {
        AppMethodBeat.i(202483);
        int i3 = this.DBp;
        this.DBp = 0;
        if (i3 == 2) {
            int i4 = i2 + 1;
            AppMethodBeat.o(202483);
            return i4;
        } else if (i3 == 1) {
            AppMethodBeat.o(202483);
            return i2;
        } else if (eYG() < 0.5f) {
            AppMethodBeat.o(202483);
            return i2;
        } else {
            int i5 = i2 + 1;
            AppMethodBeat.o(202483);
            return i5;
        }
    }

    private void eYH() {
        AppMethodBeat.i(202485);
        Yd(Yc(eYE()));
        AppMethodBeat.o(202485);
    }

    class b extends RecyclerView.j {
        b() {
        }

        @Override // android.support.v7.widget.RecyclerView.j
        public final boolean av(int i2, int i3) {
            AppMethodBeat.i(202462);
            try {
                Log.d("SnsAd.CardLayoutManager", "on fling called velocityX = ".concat(String.valueOf(i2)));
                if (i2 > CardLayoutManager.this.DBl) {
                    CardLayoutManager.this.DBp = 2;
                } else if (i2 < (-CardLayoutManager.this.DBl)) {
                    CardLayoutManager.this.DBp = 1;
                }
                if (CardLayoutManager.this.DBp != 0) {
                    CardLayoutManager.this.DBn = true;
                }
                CardLayoutManager.d(CardLayoutManager.this);
            } catch (Throwable th) {
            }
            AppMethodBeat.o(202462);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public class e {
        SparseBooleanArray DBB = new SparseBooleanArray();
        List<Integer> DBC = new LinkedList();

        e() {
            AppMethodBeat.i(202463);
            AppMethodBeat.o(202463);
        }

        /* access modifiers changed from: package-private */
        public final void Yg(int i2) {
            AppMethodBeat.i(202464);
            SparseBooleanArray sparseBooleanArray = this.DBB;
            if (sparseBooleanArray != null) {
                sparseBooleanArray.append(i2, true);
            }
            AppMethodBeat.o(202464);
        }
    }

    public static class a implements Handler.Callback {
        public final Handler sCt;
        private final WeakReference<CardLayoutManager> vjn;

        a(Context context, CardLayoutManager cardLayoutManager) {
            AppMethodBeat.i(202458);
            this.sCt = new Handler(context.getMainLooper(), this);
            this.vjn = new WeakReference<>(cardLayoutManager);
            AppMethodBeat.o(202458);
        }

        /* access modifiers changed from: package-private */
        public final void eYI() {
            AppMethodBeat.i(202459);
            if (this.sCt != null) {
                cancel();
                this.sCt.sendEmptyMessageDelayed(0, 3000);
            }
            AppMethodBeat.o(202459);
        }

        public final void cancel() {
            AppMethodBeat.i(202460);
            if (this.sCt != null) {
                this.sCt.removeMessages(0);
            }
            AppMethodBeat.o(202460);
        }

        public final boolean handleMessage(Message message) {
            CardLayoutManager cardLayoutManager;
            AppMethodBeat.i(202461);
            if (message == null) {
                AppMethodBeat.o(202461);
                return false;
            }
            if (message.what == 0) {
                try {
                    if (this.vjn == null || (cardLayoutManager = this.vjn.get()) == null) {
                        AppMethodBeat.o(202461);
                        return false;
                    }
                    if (cardLayoutManager.DBt && cardLayoutManager.mRecyclerView != null && cardLayoutManager.mRecyclerView.isAttachedToWindow()) {
                        cardLayoutManager.DBv = 1;
                        RecyclerView recyclerView = cardLayoutManager.mRecyclerView;
                        com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(cardLayoutManager.DBk + 1, new com.tencent.mm.hellhoundlib.b.a());
                        com.tencent.mm.hellhoundlib.a.a.a(recyclerView, a2.axQ(), "com/tencent/mm/plugin/sns/ad/widget/recyclerview/CardLayoutManager", "smoothScrollToNextItem", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
                        recyclerView.smoothScrollToPosition(((Integer) a2.pG(0)).intValue());
                        com.tencent.mm.hellhoundlib.a.a.a(recyclerView, "com/tencent/mm/plugin/sns/ad/widget/recyclerview/CardLayoutManager", "smoothScrollToNextItem", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
                    }
                    AppMethodBeat.o(202461);
                    return true;
                } catch (Throwable th) {
                }
            }
            AppMethodBeat.o(202461);
            return false;
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onScrollStateChanged(int i2) {
        AppMethodBeat.i(202472);
        try {
            super.onScrollStateChanged(i2);
            Log.d("SnsAd.CardLayoutManager", "the onScrollStateChanged is called, state = ".concat(String.valueOf(i2)));
            if (this.DBs != null) {
                this.DBs.a(this, i2);
            }
            if (i2 == 0) {
                Log.d("SnsAd.CardLayoutManager", "the onScrollStateChanged is called, mScrollFixed = " + this.DBn);
                if (!this.DBn) {
                    eYH();
                    this.DBn = true;
                    AppMethodBeat.o(202472);
                    return;
                }
                ip(this.DBk, this.DBj);
                AppMethodBeat.o(202472);
                return;
            }
            if (i2 == 1) {
                this.DBn = false;
                d dVar = this.DBq;
                if (this.DBv == 1 && dVar != null && eYG() > 0.5f) {
                    this.DBu = true;
                    this.DBv = 0;
                }
            }
            AppMethodBeat.o(202472);
        } catch (Throwable th) {
            AppMethodBeat.o(202472);
        }
    }

    private void Yd(int i2) {
        AppMethodBeat.i(202484);
        this.mRecyclerView.a((this.DBf * i2) - this.DBe, 0, (Interpolator) null);
        AppMethodBeat.o(202484);
    }
}
