package com.tencent.mm.ui.widget.sortlist;

import android.content.Context;
import android.view.View;
import android.widget.Checkable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c extends b implements Checkable {
    public c(Context context) {
        super(context);
    }

    public final boolean isChecked() {
        AppMethodBeat.i(159751);
        View childAt = getChildAt(0);
        if (childAt instanceof Checkable) {
            boolean isChecked = ((Checkable) childAt).isChecked();
            AppMethodBeat.o(159751);
            return isChecked;
        }
        AppMethodBeat.o(159751);
        return false;
    }

    public final void setChecked(boolean z) {
        AppMethodBeat.i(159752);
        View childAt = getChildAt(0);
        if (childAt instanceof Checkable) {
            ((Checkable) childAt).setChecked(z);
        }
        AppMethodBeat.o(159752);
    }

    public final void toggle() {
        AppMethodBeat.i(159753);
        View childAt = getChildAt(0);
        if (childAt instanceof Checkable) {
            ((Checkable) childAt).toggle();
        }
        AppMethodBeat.o(159753);
    }
}
