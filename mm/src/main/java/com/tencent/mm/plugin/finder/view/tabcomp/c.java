package com.tencent.mm.plugin.finder.view.tabcomp;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\b\u0016\u0018\u0000 -2\u00020\u0001:\u0001-B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0011\b\u0016\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001e\u001a\u00020\u0006H\u0016J\b\u0010\u001f\u001a\u00020\u0006H\u0016J\u000e\u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\"J\u0010\u0010#\u001a\u00020\t2\u0006\u0010$\u001a\u00020\tH\u0002J\u0012\u0010%\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0018\u0010&\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u001a\u0010'\u001a\u00020\u001a2\b\u0010(\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\tH\u0016J\u0010\u0010)\u001a\u00020\u001a2\u0006\u0010\u000b\u001a\u00020\tH\u0016J\u000e\u0010*\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020\tJ\u0010\u0010,\u001a\u00020\u001a2\u0006\u0010\u000b\u001a\u00020\tH\u0016R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006."}, hxF = {"Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderTab;", "Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderBaseTab;", "title", "", "(Ljava/lang/String;)V", "titleId", "", "(I)V", "isFirstValidSelect", "", "isFirstValidUnSelect", "isTabSelected", "isUnSelected", "tabRedIv", "Landroid/widget/ImageView;", "getTabRedIv", "()Landroid/widget/ImageView;", "setTabRedIv", "(Landroid/widget/ImageView;)V", "titleTv", "Landroid/widget/TextView;", "getTitleTv", "()Landroid/widget/TextView;", "setTitleTv", "(Landroid/widget/TextView;)V", "firstValidSelect", "", "tabView", "Landroid/view/ViewGroup;", "firstValidUnSelect", "getLastSelectTabIndex", "getLayoutId", "getTitle", "context", "Landroid/content/Context;", "isShouldSelect", "isSelected", "onTabInflated", "onTabStatusChanged", "setTabRedDot", "redDotText", "setTabTitle", "setTextBold", "isBold", "setTextColor", "Companion", "plugin-finder_release"})
public class c extends a {
    public static final a wtC = new a((byte) 0);
    private String title = "";
    protected TextView titleTv;
    protected ImageView uPX;
    private int uQk;
    private boolean wtA;
    private boolean wtB;
    private boolean wty;
    private boolean wtz;

    static {
        AppMethodBeat.i(255301);
        AppMethodBeat.o(255301);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderTab$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public c(String str) {
        p.h(str, "title");
        AppMethodBeat.i(255300);
        this.title = str;
        AppMethodBeat.o(255300);
    }

    public c(int i2) {
        this.uQk = i2;
    }

    @Override // com.tencent.mm.plugin.finder.view.tabcomp.a
    public int getLayoutId() {
        return R.layout.ahi;
    }

    @Override // com.tencent.mm.plugin.finder.view.tabcomp.a
    public void u(ViewGroup viewGroup) {
        AppMethodBeat.i(255291);
        if (viewGroup != null) {
            this.titleTv = (TextView) viewGroup.findViewById(R.id.ifz);
            this.uPX = (ImageView) viewGroup.findViewById(R.id.ig3);
            AppMethodBeat.o(255291);
            return;
        }
        AppMethodBeat.o(255291);
    }

    @Override // com.tencent.mm.plugin.finder.view.tabcomp.a
    public void pd(boolean z) {
        AppMethodBeat.i(255292);
        TextView textView = this.titleTv;
        if (textView != null) {
            Context context = textView.getContext();
            p.g(context, "this.context");
            textView.setText(getTitle(context));
            pe(z);
            setTextBold(z);
            AppMethodBeat.o(255292);
            return;
        }
        AppMethodBeat.o(255292);
    }

    @Override // com.tencent.mm.plugin.finder.view.tabcomp.a
    public void a(boolean z, ViewGroup viewGroup) {
        AppMethodBeat.i(255293);
        p.h(viewGroup, "tabView");
        pd(z);
        if (z) {
            if (!this.wty && (this.wtz || pf(z))) {
                t(viewGroup);
                this.wty = true;
                AppMethodBeat.o(255293);
                return;
            }
        } else if (!this.wtA && (this.wtB || pf(z))) {
            v(viewGroup);
            this.wtA = true;
        }
        AppMethodBeat.o(255293);
    }

    @Override // com.tencent.mm.plugin.finder.view.tabcomp.a
    public void by(String str, boolean z) {
    }

    public int dHM() {
        return 0;
    }

    public void v(ViewGroup viewGroup) {
        AppMethodBeat.i(255294);
        p.h(viewGroup, "tabView");
        Log.i("Finder.FinderTab", "firstValidUnSelected");
        AppMethodBeat.o(255294);
    }

    public void t(ViewGroup viewGroup) {
        AppMethodBeat.i(255295);
        p.h(viewGroup, "tabView");
        Log.i("Finder.FinderTab", "firstValidSelected");
        AppMethodBeat.o(255295);
    }

    public void pe(boolean z) {
        AppMethodBeat.i(255296);
        TextView textView = this.titleTv;
        if (textView == null) {
            AppMethodBeat.o(255296);
        } else if (z) {
            Context context = textView.getContext();
            p.g(context, "context");
            textView.setTextColor(context.getResources().getColor(R.color.a2x));
            AppMethodBeat.o(255296);
        } else {
            Context context2 = textView.getContext();
            p.g(context2, "context");
            textView.setTextColor(context2.getResources().getColor(R.color.l4));
            AppMethodBeat.o(255296);
        }
    }

    public final void setTextBold(boolean z) {
        AppMethodBeat.i(255297);
        TextView textView = this.titleTv;
        if (textView == null) {
            AppMethodBeat.o(255297);
        } else if (z) {
            ao.a(textView.getPaint(), 0.8f);
            AppMethodBeat.o(255297);
        } else {
            ao.b(textView.getPaint());
            AppMethodBeat.o(255297);
        }
    }

    public final String getTitle(Context context) {
        String str;
        AppMethodBeat.i(255298);
        p.h(context, "context");
        if (!Util.isNullOrNil(this.title)) {
            String str2 = this.title;
            AppMethodBeat.o(255298);
            return str2;
        }
        if (this.uQk > 0) {
            str = context.getResources().getString(this.uQk);
        } else {
            str = "";
        }
        p.g(str, "if (titleId > 0) {\n     …\n            \"\"\n        }");
        AppMethodBeat.o(255298);
        return str;
    }

    private final boolean pf(boolean z) {
        AppMethodBeat.i(255299);
        if (z) {
            this.wtz = true;
        } else {
            this.wtB = true;
        }
        if (dHM() == 0 || this.index != 0) {
            AppMethodBeat.o(255299);
            return true;
        }
        AppMethodBeat.o(255299);
        return false;
    }
}
