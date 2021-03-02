package com.tencent.mm.plugin.finder.viewmodel.hometab;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.view.tabcomp.c;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.Map;
import kotlin.a.ae;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.s;

@l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0017\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\u000e\u001a\u00020\u0003H\u0016J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u0012H\u0017J\u001a\u0010\u0016\u001a\u00020\u00102\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u0015H\u0016J\u0010\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0015H\u0016J\u0010\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0015H\u0003R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/hometab/FinderHomeTab;", "Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderTab;", "titleId", "", "tabType", "(II)V", "getTabType", "()I", "titleIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getTitleIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setTitleIv", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "getLayoutId", "onTabInflated", "", "tabView", "Landroid/view/ViewGroup;", "onTabStatusChanged", "isSelected", "", "setTabRedDot", "redDotText", "", "isTabSelected", "setTabTitle", "setTitleTv", "Companion", "plugin-finder_release"})
public final class a extends c {
    private static final Map<Integer, Integer> wBK = ae.e(s.U(3, 0), s.U(1, 1), s.U(4, 2));
    public static final C1354a wBL = new C1354a((byte) 0);
    private final int dLS;
    private WeImageView uPW;

    public a(int i2, int i3) {
        super(i2);
        this.dLS = i3;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/hometab/FinderHomeTab$Companion;", "", "()V", "tabTypeConverter", "", "", "getTabIndex", "tabType", "plugin-finder_release"})
    /* renamed from: com.tencent.mm.plugin.finder.viewmodel.hometab.a$a  reason: collision with other inner class name */
    public static final class C1354a {
        private C1354a() {
        }

        public /* synthetic */ C1354a(byte b2) {
            this();
        }

        public static int MK(int i2) {
            AppMethodBeat.i(256098);
            Integer num = (Integer) a.wBK.get(Integer.valueOf(i2));
            if (num != null) {
                int intValue = num.intValue();
                AppMethodBeat.o(256098);
                return intValue;
            }
            AppMethodBeat.o(256098);
            return -1;
        }
    }

    static {
        AppMethodBeat.i(256104);
        AppMethodBeat.o(256104);
    }

    @Override // com.tencent.mm.plugin.finder.view.tabcomp.c, com.tencent.mm.plugin.finder.view.tabcomp.a
    public final int getLayoutId() {
        switch (this.dLS) {
            case 1:
                return R.layout.acb;
            case 2:
            default:
                return R.layout.ac9;
            case 3:
            case 4:
                return R.layout.aca;
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.plugin.finder.view.tabcomp.c, com.tencent.mm.plugin.finder.view.tabcomp.a
    public final void u(ViewGroup viewGroup) {
        AppMethodBeat.i(256099);
        if (viewGroup != null) {
            this.titleTv = (TextView) viewGroup.findViewById(R.id.ifz);
            TextView textView = this.titleTv;
            if (textView != null) {
                textView.setTextSize(1, 15.0f);
            }
            switch (this.dLS) {
                case 1:
                    this.uPW = (WeImageView) viewGroup.findViewById(R.id.ig2);
                    this.uPX = (ImageView) viewGroup.findViewById(R.id.ig3);
                    dIR();
                    AppMethodBeat.o(256099);
                    return;
                case 3:
                case 4:
                    this.uPX = (ImageView) viewGroup.findViewById(R.id.ifw);
                    break;
            }
            AppMethodBeat.o(256099);
            return;
        }
        AppMethodBeat.o(256099);
    }

    @Override // com.tencent.mm.plugin.finder.view.tabcomp.c, com.tencent.mm.plugin.finder.view.tabcomp.a
    @SuppressLint({"ResourceType"})
    public final void a(boolean z, ViewGroup viewGroup) {
        int i2;
        AppMethodBeat.i(256100);
        p.h(viewGroup, "tabView");
        pe(z);
        setTextBold(z);
        switch (this.dLS) {
            case 2:
                WeImageView weImageView = this.uPW;
                if (weImageView != null) {
                    if (z) {
                        i2 = R.raw.icons_filled_location;
                    } else {
                        i2 = R.raw.icons_outlined_location;
                    }
                    weImageView.setImageResource(i2);
                    AppMethodBeat.o(256100);
                    return;
                }
                AppMethodBeat.o(256100);
                return;
            case 1:
                dIR();
                break;
        }
        AppMethodBeat.o(256100);
    }

    @SuppressLint({"ResourceType"})
    private final void dIR() {
        int i2;
        int color;
        AppMethodBeat.i(256103);
        WeImageView weImageView = this.uPW;
        if (weImageView != null) {
            if (weImageView.isSelected()) {
                i2 = R.raw.icons_filled_little_like;
            } else {
                i2 = R.raw.icons_outlined_little_like;
            }
            weImageView.setImageResource(i2);
            if (weImageView.isSelected()) {
                color = weImageView.getResources().getColor(R.color.a2x);
            } else {
                color = weImageView.getResources().getColor(R.color.l4);
            }
            weImageView.setIconColor(color);
            AppMethodBeat.o(256103);
            return;
        }
        AppMethodBeat.o(256103);
    }

    @Override // com.tencent.mm.plugin.finder.view.tabcomp.c, com.tencent.mm.plugin.finder.view.tabcomp.a
    public final void pd(boolean z) {
        AppMethodBeat.i(256101);
        TextView textView = this.titleTv;
        if (textView != null) {
            Context context = textView.getContext();
            p.g(context, "context");
            textView.setText(getTitle(context));
            pe(z);
            setTextBold(z);
            AppMethodBeat.o(256101);
            return;
        }
        AppMethodBeat.o(256101);
    }

    @Override // com.tencent.mm.plugin.finder.view.tabcomp.c, com.tencent.mm.plugin.finder.view.tabcomp.a
    public final void by(String str, boolean z) {
        AppMethodBeat.i(256102);
        ImageView imageView = this.uPX;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 4);
            AppMethodBeat.o(256102);
            return;
        }
        AppMethodBeat.o(256102);
    }
}
