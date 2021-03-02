package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\n¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/FinderUserTagView;", "Landroid/support/v7/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "plugin-finder_release"})
public final class FinderUserTagView extends AppCompatTextView {
    public FinderUserTagView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(168426);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
        setLayoutParams(marginLayoutParams);
        Context context2 = getContext();
        p.g(context2, "context");
        marginLayoutParams.rightMargin = (int) context2.getResources().getDimension(R.dimen.ct);
        Context context3 = getContext();
        p.g(context3, "context");
        setTextColor(context3.getResources().getColor(R.color.BW_0_Alpha_0_5));
        Context context4 = getContext();
        p.g(context4, "context");
        setTextSize(0, context4.getResources().getDimension(R.dimen.k6));
        AppMethodBeat.o(168426);
    }

    public FinderUserTagView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(168427);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
        setLayoutParams(marginLayoutParams);
        Context context2 = getContext();
        p.g(context2, "context");
        marginLayoutParams.rightMargin = (int) context2.getResources().getDimension(R.dimen.ct);
        Context context3 = getContext();
        p.g(context3, "context");
        setTextColor(context3.getResources().getColor(R.color.BW_0_Alpha_0_5));
        Context context4 = getContext();
        p.g(context4, "context");
        setTextSize(0, context4.getResources().getDimension(R.dimen.k6));
        AppMethodBeat.o(168427);
    }
}
