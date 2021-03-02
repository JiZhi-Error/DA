package com.tencent.mm.plugin.finder.live.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import kotlin.g.b.p;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u000f\u001a\u00020\rJ\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0011R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\u0004¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveRotationHelper;", "", "context", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "(Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getContext", "()Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "setContext", "changeScreenOrientation", "", "changeScreenToLandscape", "changeScreenToPortrait", "enableAutoRotation", "", "lockScreenRotation", "plugin-finder_release"})
public final class l {
    final String TAG = "Finder.LiveRotationHelper";
    MMFinderUI ujj;

    public l(MMFinderUI mMFinderUI) {
        p.h(mMFinderUI, "context");
        AppMethodBeat.i(246177);
        this.ujj = mMFinderUI;
        AppMethodBeat.o(246177);
    }
}
