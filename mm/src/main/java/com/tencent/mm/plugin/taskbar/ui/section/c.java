package com.tencent.mm.plugin.taskbar.ui.section;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.taskbar.ui.section.b;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B5\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionEmptyView;", "Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView;", "context", "Landroid/content/Context;", "callback", "Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView$Callback;", "sectionType", "", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "(Landroid/content/Context;Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView$Callback;ILandroid/util/AttributeSet;I)V", "emptyTitle", "Landroid/widget/TextView;", "notifyDataSetChanged", "", "titleName", "", "updateEmptyState", "isFull", "", "plugin-taskbar_release"})
@SuppressLint({"ViewConstructor"})
public final class c extends b {
    private HashMap _$_findViewCache;
    public final TextView qco;

    public c(Context context, b.a aVar, int i2, char c2) {
        this(context, aVar, i2, (byte) 0);
    }

    @Override // com.tencent.mm.plugin.taskbar.ui.section.b
    public final View ewN() {
        AppMethodBeat.i(238500);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf((int) R.id.be3));
        if (view == null) {
            view = findViewById(R.id.be3);
            this._$_findViewCache.put(Integer.valueOf((int) R.id.be3), view);
        }
        AppMethodBeat.o(238500);
        return view;
    }

    private /* synthetic */ c(Context context, b.a aVar, int i2, byte b2) {
        this(context, aVar, i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private c(Context context, b.a aVar, int i2) {
        super(context, aVar, i2, null, 0);
        p.h(context, "context");
        p.h(aVar, "callback");
        AppMethodBeat.i(238499);
        View inflate = LayoutInflater.from(context).inflate(R.layout.c1w, (ViewGroup) getContainerView(), false);
        View findViewById = inflate.findViewById(R.id.c3b);
        p.g(findViewById, "view.findViewById(R.id.empty_title)");
        this.qco = (TextView) findViewById;
        p.g(inflate, "view");
        fS(inflate);
        AppMethodBeat.o(238499);
    }

    @Override // com.tencent.mm.plugin.taskbar.ui.section.b
    public final String fvi() {
        return "";
    }

    @Override // com.tencent.mm.plugin.taskbar.ui.section.b
    public final void notifyDataSetChanged() {
    }
}
