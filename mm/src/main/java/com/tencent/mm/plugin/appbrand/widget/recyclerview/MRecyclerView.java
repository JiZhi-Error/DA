package com.tencent.mm.plugin.appbrand.widget.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MRecyclerView extends RecyclerView {
    private View GQ;
    protected a oEr;
    private a oEs;
    private b oEt;

    public interface a {
        void S(View view, int i2);
    }

    public interface b {
        boolean T(View view, int i2);
    }

    public MRecyclerView(Context context) {
        super(context);
        AppMethodBeat.i(131570);
        init();
        AppMethodBeat.o(131570);
    }

    public MRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(131571);
        init();
        AppMethodBeat.o(131571);
    }

    public MRecyclerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(131572);
        init();
        AppMethodBeat.o(131572);
    }

    private void init() {
        AppMethodBeat.i(131573);
        this.oEr = new a();
        if (cdc()) {
            this.oEr.au(true);
        }
        super.setAdapter(this.oEr);
        this.oEr.a(new RecyclerView.c() {
            /* class com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.AnonymousClass1 */

            @Override // android.support.v7.widget.RecyclerView.c
            public final void onChanged() {
                AppMethodBeat.i(131567);
                if (MRecyclerView.this.GQ != null) {
                    MRecyclerView.this.GQ.setVisibility(MRecyclerView.this.cdb() ? 0 : 8);
                }
                AppMethodBeat.o(131567);
            }
        });
        AppMethodBeat.o(131573);
    }

    public final int U(RecyclerView.v vVar) {
        int i2;
        AppMethodBeat.i(131574);
        if (this.oEr == null) {
            AppMethodBeat.o(131574);
            return -1;
        }
        a aVar = this.oEr;
        if (vVar == null) {
            AppMethodBeat.o(131574);
            return -1;
        } else if (vVar.lR() == -1) {
            AppMethodBeat.o(131574);
            return -1;
        } else {
            int lR = vVar.lR();
            if (aVar.oEf.isEmpty()) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            int i3 = lR - i2;
            AppMethodBeat.o(131574);
            return i3;
        }
    }

    @Override // android.support.v7.widget.RecyclerView
    public void setAdapter(RecyclerView.a aVar) {
        AppMethodBeat.i(131575);
        a aVar2 = this.oEr;
        if (aVar2.adj != null) {
            if (!aVar2.adj.equals(aVar)) {
                aVar2.adj.b(aVar2.oEj);
            }
            AppMethodBeat.o(131575);
        }
        aVar2.adj = aVar;
        if (aVar2.adj != null) {
            aVar2.adj.a(aVar2.oEj);
        }
        AppMethodBeat.o(131575);
    }

    @Override // android.support.v7.widget.RecyclerView
    public RecyclerView.a getAdapter() {
        return this.oEr;
    }

    @Override // android.support.v7.widget.RecyclerView
    public final void scrollToPosition(int i2) {
        AppMethodBeat.i(131576);
        super.scrollToPosition(i2);
        AppMethodBeat.o(131576);
    }

    public final void addHeaderView(View view) {
        AppMethodBeat.i(131577);
        a aVar = this.oEr;
        aVar.oEf.add(view);
        aVar.aq(0, 1);
        AppMethodBeat.o(131577);
    }

    public void addFooterView(View view) {
        AppMethodBeat.i(131578);
        this.oEr.addFooterView(view);
        AppMethodBeat.o(131578);
    }

    public final void c(int i2, View view) {
        AppMethodBeat.i(131579);
        this.oEr.c(i2, view);
        AppMethodBeat.o(131579);
    }

    public final void dl(View view) {
        AppMethodBeat.i(131580);
        this.oEr.dl(view);
        AppMethodBeat.o(131580);
    }

    public void setEmptyView(View view) {
        AppMethodBeat.i(131581);
        if (this.GQ == view) {
            AppMethodBeat.o(131581);
            return;
        }
        this.GQ = view;
        if (this.GQ != null) {
            this.GQ.setVisibility(cdb() ? 0 : 8);
        }
        AppMethodBeat.o(131581);
    }

    public View getEmptyView() {
        return this.GQ;
    }

    public void setOnItemClickListener(a aVar) {
        AppMethodBeat.i(131582);
        this.oEs = aVar;
        this.oEr.oEh = new b() {
            /* class com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.appbrand.widget.recyclerview.b
            public final void Q(View view, int i2) {
                AppMethodBeat.i(131568);
                if (MRecyclerView.this.oEs != null) {
                    MRecyclerView.this.oEs.S(view, i2);
                }
                AppMethodBeat.o(131568);
            }
        };
        AppMethodBeat.o(131582);
    }

    public void setOnItemLongClickListener(b bVar) {
        AppMethodBeat.i(131583);
        this.oEt = bVar;
        this.oEr.oEi = new c() {
            /* class com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.AnonymousClass3 */

            @Override // com.tencent.mm.plugin.appbrand.widget.recyclerview.c
            public final boolean R(View view, int i2) {
                AppMethodBeat.i(131569);
                if (MRecyclerView.this.oEt != null) {
                    boolean T = MRecyclerView.this.oEt.T(view, i2);
                    AppMethodBeat.o(131569);
                    return T;
                }
                AppMethodBeat.o(131569);
                return false;
            }
        };
        AppMethodBeat.o(131583);
    }

    /* access modifiers changed from: protected */
    public boolean cdb() {
        AppMethodBeat.i(131584);
        if (this.oEr.getItemCount() == 0) {
            AppMethodBeat.o(131584);
            return true;
        }
        AppMethodBeat.o(131584);
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean cdc() {
        return true;
    }
}
