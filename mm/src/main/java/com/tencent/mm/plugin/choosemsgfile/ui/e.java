package com.tencent.mm.plugin.choosemsgfile.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.a.f;
import java.util.Objects;

public final class e extends com.tencent.mm.plugin.ball.a.e {
    public e(Activity activity) {
        super(activity);
    }

    @Override // com.tencent.mm.plugin.ball.a.e, com.tencent.mm.plugin.ball.a.f
    public final Activity getActivity() {
        AppMethodBeat.i(123456);
        Activity activity = (Activity) Objects.requireNonNull(super.getActivity());
        AppMethodBeat.o(123456);
        return activity;
    }

    @Override // com.tencent.mm.plugin.ball.a.e, com.tencent.mm.plugin.ball.a.f
    public final Intent getIntent() {
        AppMethodBeat.i(123457);
        Intent intent = super.getIntent();
        AppMethodBeat.o(123457);
        return intent;
    }

    @Override // com.tencent.mm.plugin.ball.a.e, com.tencent.mm.plugin.ball.a.f
    public final ViewGroup chG() {
        AppMethodBeat.i(123458);
        ViewGroup chG = super.chG();
        AppMethodBeat.o(123458);
        return chG;
    }

    @Override // com.tencent.mm.plugin.ball.a.e, com.tencent.mm.plugin.ball.a.f
    public final View getContentView() {
        AppMethodBeat.i(123459);
        View contentView = super.getContentView();
        AppMethodBeat.o(123459);
        return contentView;
    }

    @Override // com.tencent.mm.plugin.ball.a.e, com.tencent.mm.plugin.ball.a.f
    public final boolean aGg() {
        AppMethodBeat.i(123460);
        boolean aGg = super.aGg();
        AppMethodBeat.o(123460);
        return aGg;
    }

    @Override // com.tencent.mm.plugin.ball.a.e, com.tencent.mm.plugin.ball.a.f
    public final void a(f.a aVar) {
        AppMethodBeat.i(123461);
        super.a(aVar);
        AppMethodBeat.o(123461);
    }

    @Override // com.tencent.mm.plugin.ball.a.e, com.tencent.mm.plugin.ball.a.f
    public final void hb(boolean z) {
        AppMethodBeat.i(123462);
        super.hb(z);
        AppMethodBeat.o(123462);
    }

    @Override // com.tencent.mm.plugin.ball.a.e, com.tencent.mm.plugin.ball.a.f
    public final void a(f.b bVar) {
        AppMethodBeat.i(123463);
        super.a(bVar);
        AppMethodBeat.o(123463);
    }
}
