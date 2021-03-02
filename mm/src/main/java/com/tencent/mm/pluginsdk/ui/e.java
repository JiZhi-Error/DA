package com.tencent.mm.pluginsdk.ui;

import android.widget.AbsListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public final class e implements AbsListView.OnScrollListener {
    private AbsListView.OnScrollListener Kbl;
    private ArrayList<WeakReference<a>> Kbm;

    public interface a {
        void onScrollStateChanged(boolean z);
    }

    public e() {
        this(null);
    }

    public e(AbsListView.OnScrollListener onScrollListener) {
        AppMethodBeat.i(152123);
        this.Kbm = new ArrayList<>();
        this.Kbl = onScrollListener;
        AppMethodBeat.o(152123);
    }

    public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        AppMethodBeat.i(152124);
        if (this.Kbl != null) {
            this.Kbl.onScroll(absListView, i2, i3, i4);
        }
        AppMethodBeat.o(152124);
    }

    public final void onScrollStateChanged(AbsListView absListView, int i2) {
        AppMethodBeat.i(152125);
        if (i2 == 2) {
            zM(true);
        } else {
            zM(false);
        }
        if (this.Kbl != null) {
            this.Kbl.onScrollStateChanged(absListView, i2);
        }
        AppMethodBeat.o(152125);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(152126);
        this.Kbm.add(new WeakReference<>(aVar));
        AppMethodBeat.o(152126);
    }

    private void zM(boolean z) {
        AppMethodBeat.i(152127);
        for (int i2 = 0; i2 < this.Kbm.size(); i2++) {
            WeakReference<a> weakReference = this.Kbm.get(i2);
            if (weakReference != null) {
                a aVar = weakReference.get();
                if (aVar != null) {
                    aVar.onScrollStateChanged(z);
                } else {
                    this.Kbm.remove(i2);
                }
            } else {
                this.Kbm.remove(i2);
            }
        }
        AppMethodBeat.o(152127);
    }
}
