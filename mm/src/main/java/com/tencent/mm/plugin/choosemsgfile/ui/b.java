package com.tencent.mm.plugin.choosemsgfile.ui;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Objects;

public final class b extends com.tencent.mm.plugin.multitask.a.b {
    public b(Activity activity) {
        super(activity);
    }

    @Override // com.tencent.mm.plugin.multitask.a.b, com.tencent.mm.plugin.multitask.a.a
    public final Activity getActivity() {
        AppMethodBeat.i(237151);
        Activity activity = (Activity) Objects.requireNonNull(super.getActivity());
        AppMethodBeat.o(237151);
        return activity;
    }
}
