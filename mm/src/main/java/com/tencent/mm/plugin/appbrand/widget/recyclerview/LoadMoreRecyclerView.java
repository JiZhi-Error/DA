package com.tencent.mm.plugin.appbrand.widget.recyclerview;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;

public class LoadMoreRecyclerView extends MRecyclerView {
    private View gAy;
    private a oEm;
    boolean oEn;

    public interface a {
        void bYy();
    }

    public LoadMoreRecyclerView(Context context) {
        super(context);
        AppMethodBeat.i(131557);
        init();
        AppMethodBeat.o(131557);
    }

    public LoadMoreRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(131558);
        init();
        AppMethodBeat.o(131558);
    }

    public LoadMoreRecyclerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(131559);
        init();
        AppMethodBeat.o(131559);
    }

    /* access modifiers changed from: protected */
    public LinearLayoutManager bYx() {
        AppMethodBeat.i(131560);
        getContext();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager();
        AppMethodBeat.o(131560);
        return linearLayoutManager;
    }

    private void init() {
        AppMethodBeat.i(131561);
        final LinearLayoutManager bYx = bYx();
        super.setLayoutManager(bYx);
        a(new RecyclerView.l() {
            /* class com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView.AnonymousClass1 */
            int oEo = 0;

            @Override // android.support.v7.widget.RecyclerView.l
            public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                AppMethodBeat.i(131554);
                b bVar = new b();
                bVar.bm(recyclerView);
                bVar.pH(i2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
                super.onScrollStateChanged(recyclerView, i2);
                if (i2 == 0 && LoadMoreRecyclerView.this.oEn && this.oEo == LoadMoreRecyclerView.this.oEr.getItemCount() - 1 && LoadMoreRecyclerView.this.oEm != null) {
                    LoadMoreRecyclerView.this.oEm.bYy();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
                AppMethodBeat.o(131554);
            }

            @Override // android.support.v7.widget.RecyclerView.l
            public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                AppMethodBeat.i(131555);
                b bVar = new b();
                bVar.bm(recyclerView);
                bVar.pH(i2);
                bVar.pH(i3);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
                super.onScrolled(recyclerView, i2, i3);
                this.oEo = bYx.ku();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
                AppMethodBeat.o(131555);
            }
        });
        this.oEr.a(new RecyclerView.c() {
            /* class com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView.AnonymousClass2 */

            @Override // android.support.v7.widget.RecyclerView.c
            public final void onItemRangeRemoved(int i2, int i3) {
                AppMethodBeat.i(131556);
                super.onItemRangeRemoved(i2, i3);
                if (LoadMoreRecyclerView.this.oEn && bYx.ku() == LoadMoreRecyclerView.this.oEr.getItemCount() - 1 && LoadMoreRecyclerView.this.oEm != null) {
                    LoadMoreRecyclerView.this.oEm.bYy();
                }
                AppMethodBeat.o(131556);
            }
        });
        AppMethodBeat.o(131561);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView
    public final void addFooterView(View view) {
        AppMethodBeat.i(131562);
        int cda = this.oEr.cda() - 1;
        if (this.gAy == null || cda < 0) {
            super.addFooterView(view);
            AppMethodBeat.o(131562);
            return;
        }
        super.c(cda, view);
        AppMethodBeat.o(131562);
    }

    @Override // android.support.v7.widget.RecyclerView
    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
    }

    public void setLoadingView(View view) {
        AppMethodBeat.i(131563);
        if (this.gAy == view) {
            AppMethodBeat.o(131563);
            return;
        }
        if (this.gAy != null && !this.gAy.equals(view)) {
            dl(this.gAy);
        }
        this.gAy = view;
        if (this.gAy != null) {
            addFooterView(this.gAy);
            this.gAy.setVisibility(this.oEn ? 0 : 8);
        }
        AppMethodBeat.o(131563);
    }

    public void setLoadingView(int i2) {
        AppMethodBeat.i(131564);
        setLoadingView(LayoutInflater.from(getContext()).inflate(i2, (ViewGroup) this, false));
        AppMethodBeat.o(131564);
    }

    public final void showLoading(boolean z) {
        AppMethodBeat.i(131565);
        if (this.oEn == z) {
            AppMethodBeat.o(131565);
            return;
        }
        this.oEn = z;
        if (this.gAy != null) {
            this.gAy.setVisibility(this.oEn ? 0 : 8);
        }
        AppMethodBeat.o(131565);
    }

    public void setOnLoadingStateChangedListener(a aVar) {
        this.oEm = aVar;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView
    public final boolean cdb() {
        AppMethodBeat.i(131566);
        if (this.gAy == null) {
            boolean cdb = super.cdb();
            AppMethodBeat.o(131566);
            return cdb;
        } else if (this.oEr.getItemCount() == 1 && this.oEr.cda() == 1) {
            AppMethodBeat.o(131566);
            return true;
        } else {
            AppMethodBeat.o(131566);
            return false;
        }
    }
}
