package com.tencent.mm.view;

import android.view.View;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.e;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\u0013\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020)HÖ\u0001J\t\u0010*\u001a\u00020+HÖ\u0001R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0004R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006,"}, hxF = {"Lcom/tencent/mm/view/ExposedData;", "", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "attachStateChangeListener", "Landroid/view/View$OnAttachStateChangeListener;", "getAttachStateChangeListener", "()Landroid/view/View$OnAttachStateChangeListener;", "setAttachStateChangeListener", "(Landroid/view/View$OnAttachStateChangeListener;)V", "exposedChildKey", "", "getExposedChildKey", "()J", "setExposedChildKey", "(J)V", "exposedKey", "getExposedKey", "setExposedKey", "getView", "()Landroid/view/View;", "setView", "viewExposeListener", "Lcom/tencent/mm/view/ExposeElves$OnViewExposedListener;", "getViewExposeListener", "()Lcom/tencent/mm/view/ExposeElves$OnViewExposedListener;", "setViewExposeListener", "(Lcom/tencent/mm/view/ExposeElves$OnViewExposedListener;)V", "viewGroupChildExposeListener", "Lcom/tencent/mm/view/ExposeElves$OnViewGroupChildExposedListener;", "getViewGroupChildExposeListener", "()Lcom/tencent/mm/view/ExposeElves$OnViewGroupChildExposedListener;", "setViewGroupChildExposeListener", "(Lcom/tencent/mm/view/ExposeElves$OnViewGroupChildExposedListener;)V", "component1", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "", "toString", "", "libmmui_release"})
public final class g {
    long Rja = -1;
    View.OnAttachStateChangeListener Rjb;
    e.b Rjc;
    e.c Rjd;
    long Rje;
    View view;

    public final boolean equals(Object obj) {
        AppMethodBeat.i(204948);
        if (this == obj || ((obj instanceof g) && p.j(this.view, ((g) obj).view))) {
            AppMethodBeat.o(204948);
            return true;
        }
        AppMethodBeat.o(204948);
        return false;
    }

    public final int hashCode() {
        AppMethodBeat.i(204947);
        View view2 = this.view;
        if (view2 != null) {
            int hashCode = view2.hashCode();
            AppMethodBeat.o(204947);
            return hashCode;
        }
        AppMethodBeat.o(204947);
        return 0;
    }

    public final String toString() {
        AppMethodBeat.i(204946);
        String str = "ExposedData(view=" + this.view + ")";
        AppMethodBeat.o(204946);
        return str;
    }

    public g(View view2) {
        p.h(view2, "view");
        AppMethodBeat.i(204945);
        this.view = view2;
        AppMethodBeat.o(204945);
    }
}
