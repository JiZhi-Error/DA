package com.tencent.mm.plugin.topstory.ui.b;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.a.e;
import java.util.Objects;

public final class b extends e {
    public b(Activity activity) {
        super(activity);
    }

    @Override // com.tencent.mm.plugin.ball.a.e, com.tencent.mm.plugin.ball.a.f
    public final Activity getActivity() {
        AppMethodBeat.i(263559);
        Activity activity = (Activity) Objects.requireNonNull(super.getActivity());
        AppMethodBeat.o(263559);
        return activity;
    }

    @Override // com.tencent.mm.plugin.ball.a.e, com.tencent.mm.plugin.ball.a.f
    public final int chH() {
        return 0;
    }
}
