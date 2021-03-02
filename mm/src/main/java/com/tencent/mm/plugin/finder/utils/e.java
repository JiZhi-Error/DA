package com.tencent.mm.plugin.finder.utils;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.ao;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0004"}, hxF = {"setTextBold", "", "Landroid/widget/TextView;", "setTextNormal", "plugin-finder_release"})
public final class e {
    public static final void n(TextView textView) {
        AppMethodBeat.i(253386);
        p.h(textView, "$this$setTextBold");
        ao.a(textView.getPaint(), 0.8f);
        AppMethodBeat.o(253386);
    }

    public static final void o(TextView textView) {
        AppMethodBeat.i(253387);
        p.h(textView, "$this$setTextNormal");
        ao.b(textView.getPaint());
        AppMethodBeat.o(253387);
    }
}
