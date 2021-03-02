package com.tencent.mm.plugin.finder.utils;

import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/finder/utils/LoadingProgressBar;", "Lcom/tencent/mm/plugin/finder/utils/LoadingWidget;", "()V", "loadingProgressBar", "Landroid/widget/ProgressBar;", "getLoadingProgressBar", "()Landroid/widget/ProgressBar;", "setLoadingProgressBar", "(Landroid/widget/ProgressBar;)V", "dismiss", "", "show", "plugin-finder_release"})
public final class ah extends ai {
    public ProgressBar uuU;

    @Override // com.tencent.mm.plugin.finder.utils.ai
    public final void show() {
        AppMethodBeat.i(253792);
        ProgressBar progressBar = this.uuU;
        if (progressBar != null) {
            progressBar.setVisibility(0);
            AppMethodBeat.o(253792);
            return;
        }
        AppMethodBeat.o(253792);
    }

    @Override // com.tencent.mm.plugin.finder.utils.ai
    public final void dismiss() {
        AppMethodBeat.i(253793);
        ProgressBar progressBar = this.uuU;
        if (progressBar != null) {
            progressBar.setVisibility(8);
            AppMethodBeat.o(253793);
            return;
        }
        AppMethodBeat.o(253793);
    }
}
