package com.tencent.mm.plugin.finder.widget.pref;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\tB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\n¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/finder/widget/pref/FinderBlackListPreference;", "Lcom/tencent/mm/ui/base/preference/PreferenceTitleCategory;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "plugin-finder_release"})
public final class FinderBlackListPreference extends PreferenceTitleCategory {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderBlackListPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        p.h(attributeSet, "attributeSet");
        AppMethodBeat.i(256157);
        setLayoutResource(R.layout.aim);
        AppMethodBeat.o(256157);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderBlackListPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        p.h(attributeSet, "attributeSet");
        AppMethodBeat.i(256158);
        setLayoutResource(R.layout.aim);
        AppMethodBeat.o(256158);
    }
}
