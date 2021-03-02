package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;

public final class c {
    public Map<Integer, a> Ebw = new HashMap();
    public b EhP;
    public boolean cQp = true;
    private RecyclerView hak;
    private LinearLayoutManager vKp;

    public interface b {
        void Zc(int i2);

        boolean Zd(int i2);

        boolean Ze(int i2);

        void Zf(int i2);

        void a(int i2, c cVar);

        void onDestroy();
    }

    public c(RecyclerView recyclerView) {
        AppMethodBeat.i(96948);
        this.hak = recyclerView;
        if (recyclerView.getLayoutManager() == null || !(recyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("set LinearLayoutManger to RecyclerView first");
            AppMethodBeat.o(96948);
            throw illegalArgumentException;
        } else if (recyclerView.getAdapter() == null || !(recyclerView.getAdapter() instanceof b)) {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("set Adapter which implemented ExposureListener to RecyclerView first");
            AppMethodBeat.o(96948);
            throw illegalArgumentException2;
        } else {
            this.EhP = (b) recyclerView.getAdapter();
            this.vKp = (LinearLayoutManager) recyclerView.getLayoutManager();
            this.hak.a(new C1724c(recyclerView, (LinearLayoutManager) recyclerView.getLayoutManager()));
            AppMethodBeat.o(96948);
        }
    }

    public final void fdT() {
        AppMethodBeat.i(96949);
        if (!this.cQp) {
            AppMethodBeat.o(96949);
            return;
        }
        fcS();
        int ks = this.vKp.ks();
        int ku = this.vKp.ku();
        for (Map.Entry<Integer, a> entry : this.Ebw.entrySet()) {
            if (entry.getKey().intValue() < ks || entry.getKey().intValue() > ku) {
                if (entry.getValue().DXw) {
                    this.EhP.Zc(entry.getKey().intValue());
                    entry.getValue().fcU();
                }
            } else if (entry.getValue().DXw) {
                if (!this.EhP.Zd(entry.getKey().intValue())) {
                    this.EhP.Zc(entry.getKey().intValue());
                    entry.getValue().fcU();
                } else if (this.EhP.Ze(entry.getKey().intValue())) {
                    this.EhP.Zf(entry.getKey().intValue());
                }
            }
        }
        AppMethodBeat.o(96949);
    }

    public final void fcS() {
        AppMethodBeat.i(96950);
        if (!this.cQp) {
            AppMethodBeat.o(96950);
            return;
        }
        if (this.vKp != null) {
            int ks = this.vKp.ks();
            int ku = this.vKp.ku();
            Log.d("RecyclerViewExposureMgr", "appear [%d, %d]", Integer.valueOf(ks), Integer.valueOf(ku));
            if (ks == ku && ks == -1) {
                Log.i("RecyclerViewExposureMgr", "no exposuring child");
                AppMethodBeat.o(96950);
                return;
            }
            iz(ks, ku);
        }
        AppMethodBeat.o(96950);
    }

    private void iz(int i2, int i3) {
        AppMethodBeat.i(96951);
        while (i2 <= i3) {
            a aVar = this.Ebw.get(Integer.valueOf(i2));
            if (aVar == null) {
                aVar = new a(this, (byte) 0);
                this.Ebw.put(Integer.valueOf(i2), aVar);
            }
            if (this.EhP.Zd(i2)) {
                if (!aVar.DXw) {
                    this.EhP.a(i2, this);
                    aVar.fcT();
                } else if (this.EhP.Ze(i2)) {
                    this.EhP.Zf(i2);
                }
            }
            i2++;
        }
        AppMethodBeat.o(96951);
    }

    public final void fdU() {
        AppMethodBeat.i(96952);
        if (this.vKp != null) {
            int ks = this.vKp.ks();
            int ku = this.vKp.ku();
            Log.d("RecyclerViewExposureMgr", "disappear [%d, %d]", Integer.valueOf(ks), Integer.valueOf(ku));
            if (ks == ku && ks == -1) {
                Log.i("RecyclerViewExposureMgr", "no exposuring child");
                AppMethodBeat.o(96952);
                return;
            }
            for (int i2 = ks; i2 <= ku; i2++) {
                a aVar = this.Ebw.get(Integer.valueOf(i2));
                if (aVar != null && aVar.DXw) {
                    this.EhP.Zc(i2);
                    aVar.fcU();
                }
            }
        }
        AppMethodBeat.o(96952);
    }

    public class a {
        public boolean DXw;

        private a() {
        }

        /* synthetic */ a(c cVar, byte b2) {
            this();
        }

        /* access modifiers changed from: package-private */
        public final void fcT() {
            if (!this.DXw) {
                this.DXw = true;
            }
        }

        /* access modifiers changed from: package-private */
        public final void fcU() {
            if (this.DXw) {
                this.DXw = false;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.c$c  reason: collision with other inner class name */
    class C1724c extends RecyclerView.l {
        int EbC = Integer.MAX_VALUE;
        private int EbD = -1;
        private int EbE = -1;
        private long EbF = 0;
        Runnable EbG = new Runnable() {
            /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.c.C1724c.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(96942);
                if (C1724c.this.EbC == 1) {
                    c.this.fdT();
                    C1724c.this.hak.postDelayed(C1724c.this.EbG, 100);
                }
                AppMethodBeat.o(96942);
            }
        };
        RecyclerView hak;
        private LinearLayoutManager pcs;

        public C1724c(RecyclerView recyclerView, LinearLayoutManager linearLayoutManager) {
            AppMethodBeat.i(96943);
            this.hak = recyclerView;
            this.pcs = linearLayoutManager;
            AppMethodBeat.o(96943);
        }

        private void fcV() {
            AppMethodBeat.i(96944);
            this.hak.getHandler().removeCallbacks(this.EbG);
            AppMethodBeat.o(96944);
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            AppMethodBeat.i(96945);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/RecyclerViewExposureMgr$MyScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
            super.onScrollStateChanged(recyclerView, i2);
            if (i2 != this.EbC) {
                if (i2 != 1) {
                    fcV();
                }
                switch (i2) {
                    case 0:
                        c.this.fdT();
                        if (this.EbC == 2) {
                            int ks = this.pcs.ks();
                            int ku = this.pcs.ku();
                            if (ku >= this.EbD) {
                                if (ks > this.EbE) {
                                    iB(this.EbE, ks);
                                    break;
                                }
                            } else {
                                iB(ku, this.EbD);
                                break;
                            }
                        }
                        break;
                    case 1:
                        fcV();
                        this.hak.postDelayed(this.EbG, 100);
                        break;
                    case 2:
                        this.EbD = this.pcs.ks();
                        this.EbE = this.pcs.ku();
                        this.EbF = System.currentTimeMillis();
                        break;
                }
            }
            this.EbC = i2;
            Log.d("RecyclerViewExposureMgr", "state ".concat(String.valueOf(i2)));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/RecyclerViewExposureMgr$MyScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
            AppMethodBeat.o(96945);
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            AppMethodBeat.i(96946);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            bVar.pH(i3);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/RecyclerViewExposureMgr$MyScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
            super.onScrolled(recyclerView, i2, i3);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/RecyclerViewExposureMgr$MyScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
            AppMethodBeat.o(96946);
        }

        private void iB(int i2, int i3) {
            AppMethodBeat.i(96947);
            c.a(c.this, i2, i3);
            AppMethodBeat.o(96947);
        }
    }

    static /* synthetic */ void a(c cVar, int i2, int i3) {
        AppMethodBeat.i(96953);
        if (i2 > i3) {
            Log.e("RecyclerViewExposureMgr", "wtf start > end");
            AppMethodBeat.o(96953);
            return;
        }
        if (cVar.cQp) {
            cVar.iz(i2, i3);
            while (i2 <= i3) {
                a aVar = cVar.Ebw.get(Integer.valueOf(i2));
                if (aVar != null && aVar.DXw) {
                    cVar.EhP.Zc(i2);
                    aVar.fcU();
                }
                i2++;
            }
        }
        AppMethodBeat.o(96953);
    }
}
