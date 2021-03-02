package com.tencent.mm.plugin.story.ui.view.gallery;

import android.widget.CompoundButton;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16})
public final class h implements CompoundButton.OnCheckedChangeListener {
    private final /* synthetic */ m hEX;

    h(m mVar) {
        this.hEX = mVar;
    }

    public final /* synthetic */ void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        AppMethodBeat.i(120385);
        p.g(this.hEX.invoke(compoundButton, Boolean.valueOf(z)), "invoke(...)");
        AppMethodBeat.o(120385);
    }
}
