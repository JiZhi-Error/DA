package com.tencent.mm.ui.b;

import android.app.Activity;
import android.support.v7.view.i;
import android.view.ActionMode;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c extends i {
    private Activity mActivity;

    public c(Window.Callback callback, Activity activity) {
        super(callback);
        this.mActivity = activity;
    }

    @Override // android.support.v7.view.i
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        AppMethodBeat.i(141517);
        ActionMode onWindowStartingActionMode = this.mActivity.onWindowStartingActionMode(callback);
        AppMethodBeat.o(141517);
        return onWindowStartingActionMode;
    }
}
