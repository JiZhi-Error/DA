package com.tencent.mm.plugin.wenote.b;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.a.e;
import com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI;
import java.util.Objects;

public final class b extends e {
    private NoteEditorUI VhV;

    public b(NoteEditorUI noteEditorUI) {
        super(noteEditorUI);
        this.VhV = noteEditorUI;
    }

    @Override // com.tencent.mm.plugin.ball.a.e, com.tencent.mm.plugin.ball.a.f
    public final Activity getActivity() {
        AppMethodBeat.i(258861);
        Activity activity = (Activity) Objects.requireNonNull(super.getActivity());
        AppMethodBeat.o(258861);
        return activity;
    }

    @Override // com.tencent.mm.plugin.ball.a.e, com.tencent.mm.plugin.ball.a.f
    public final boolean aGg() {
        AppMethodBeat.i(30264);
        boolean aGg = super.aGg();
        AppMethodBeat.o(30264);
        return aGg;
    }

    @Override // com.tencent.mm.plugin.ball.a.e, com.tencent.mm.plugin.ball.a.f
    public final void hb(boolean z) {
        AppMethodBeat.i(30265);
        if (this.VhV != null) {
            this.VhV.goBack();
            super.hb(z);
        }
        AppMethodBeat.o(30265);
    }
}
