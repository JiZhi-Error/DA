package com.tencent.mm.plugin.fav.ui.g;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.a.e;
import com.tencent.mm.plugin.ball.a.f;
import java.util.Objects;

public final class b extends e {
    public b(Activity activity) {
        super(activity);
    }

    @Override // com.tencent.mm.plugin.ball.a.e, com.tencent.mm.plugin.ball.a.f
    public final Activity getActivity() {
        AppMethodBeat.i(107293);
        Activity activity = (Activity) Objects.requireNonNull(super.getActivity());
        AppMethodBeat.o(107293);
        return activity;
    }

    @Override // com.tencent.mm.plugin.ball.a.e, com.tencent.mm.plugin.ball.a.f
    public final Intent getIntent() {
        AppMethodBeat.i(107294);
        Intent intent = super.getIntent();
        AppMethodBeat.o(107294);
        return intent;
    }

    @Override // com.tencent.mm.plugin.ball.a.e, com.tencent.mm.plugin.ball.a.f
    public final ViewGroup chG() {
        AppMethodBeat.i(107295);
        ViewGroup chG = super.chG();
        AppMethodBeat.o(107295);
        return chG;
    }

    @Override // com.tencent.mm.plugin.ball.a.e, com.tencent.mm.plugin.ball.a.f
    public final View getContentView() {
        AppMethodBeat.i(107296);
        View contentView = super.getContentView();
        AppMethodBeat.o(107296);
        return contentView;
    }

    @Override // com.tencent.mm.plugin.ball.a.e, com.tencent.mm.plugin.ball.a.f
    public final boolean aGg() {
        AppMethodBeat.i(107297);
        boolean aGg = super.aGg();
        AppMethodBeat.o(107297);
        return aGg;
    }

    @Override // com.tencent.mm.plugin.ball.a.e, com.tencent.mm.plugin.ball.a.f
    public final void a(f.a aVar) {
        AppMethodBeat.i(107298);
        super.a(aVar);
        AppMethodBeat.o(107298);
    }

    @Override // com.tencent.mm.plugin.ball.a.e, com.tencent.mm.plugin.ball.a.f
    public final void hb(boolean z) {
        AppMethodBeat.i(107299);
        super.hb(z);
        AppMethodBeat.o(107299);
    }

    @Override // com.tencent.mm.plugin.ball.a.e, com.tencent.mm.plugin.ball.a.f
    public final void a(f.b bVar) {
        AppMethodBeat.i(107300);
        super.a(bVar);
        AppMethodBeat.o(107300);
    }
}
