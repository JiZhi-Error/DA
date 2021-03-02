package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\tJ\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0015J\u0006\u0010\u0017\u001a\u00020\u0010J\u0006\u0010\u0018\u001a\u00020\u0010J\b\u0010\u0019\u001a\u00020\u0010H\u0014J\u0006\u0010\u001a\u001a\u00020\u0010J\u0006\u0010\u001b\u001a\u00020\u0010J\u0006\u0010\u001c\u001a\u00020\u0010J\u0006\u0010\u001d\u001a\u00020\u0010J\u000e\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020 J\u0006\u0010!\u001a\u00020\u0010J\u000e\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u0015R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderImageBulletSubtitleLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bulletSubtitlePresenter", "Lcom/tencent/mm/plugin/finder/feed/FinderBulletSubtitlePresenter;", "bulletSubtitleViewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderBulletSubtitleViewCallback;", "bindData", "", "feed", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "tabType", "getFunctionSwitch", "", "isStartLoop", "onAttach", "onDetach", "onDetachedFromWindow", "pause", "refreshData", "reset", "resume", "setBulletSubtitleAlpha", "alpha", "", "startLoop", "switchFunction", "isTurnOn", "plugin-finder_release"})
public final class FinderImageBulletSubtitleLayout extends FrameLayout {
    public e tOr = new e(this, this.tOs);
    public d tOs;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderImageBulletSubtitleLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(243893);
        Context context2 = getContext();
        p.g(context2, "context");
        this.tOs = new d(context2);
        AppMethodBeat.o(243893);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderImageBulletSubtitleLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(243894);
        Context context2 = getContext();
        p.g(context2, "context");
        this.tOs = new d(context2);
        AppMethodBeat.o(243894);
    }

    public final boolean getFunctionSwitch() {
        AppMethodBeat.i(243890);
        boolean functionSwitch = this.tOr.getFunctionSwitch();
        AppMethodBeat.o(243890);
        return functionSwitch;
    }

    public final void setBulletSubtitleAlpha(float f2) {
        AppMethodBeat.i(243891);
        this.tOr.dcy().setAlpha(f2);
        AppMethodBeat.o(243891);
    }

    /* access modifiers changed from: protected */
    public final void onDetachedFromWindow() {
        AppMethodBeat.i(243892);
        super.onDetachedFromWindow();
        this.tOs.onDetach();
        AppMethodBeat.o(243892);
    }
}
