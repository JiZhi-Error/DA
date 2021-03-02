package com.tencent.mm.plugin.finder.viewmodel.component;

import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b&\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0004¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderLiveTagBaseUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "setWindowStyle", "", "Companion", "plugin-finder_release"})
public abstract class FinderLiveTagBaseUIC extends UIComponent {
    public static final a wyA = new a((byte) 0);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderLiveTagBaseUIC(Fragment fragment) {
        super(fragment);
        p.h(fragment, "fragment");
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderLiveTagBaseUIC$Companion;", "", "()V", "KEY_HAS_NEXT_ACTION", "", "KEY_START_LIVE", "KEY_TAG_INFO", "REQUEST_CODE_SUB_TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* access modifiers changed from: protected */
    public final void dIl() {
        if (getActivity() instanceof MMActivity) {
            AppCompatActivity activity = getActivity();
            if (activity == null) {
                throw new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            }
            ((MMActivity) activity).setSelfNavigationBarVisible(8);
        }
        getContext().getWindow().addFlags(2097280);
        getContext().getWindow().addFlags(67108864);
        if (Build.VERSION.SDK_INT >= 21) {
            getContext().getWindow().clearFlags(67108864);
            Window window = getContext().getWindow();
            p.g(window, "context.window");
            View decorView = window.getDecorView();
            p.g(decorView, "context.window.decorView");
            decorView.setSystemUiVisibility(1792);
            getContext().getWindow().addFlags(Integer.MIN_VALUE);
            Window window2 = getContext().getWindow();
            p.g(window2, "context.window");
            window2.setStatusBarColor(0);
            Window window3 = getContext().getWindow();
            p.g(window3, "context.window");
            window3.setNavigationBarColor(0);
        }
        getContext().getWindow().setFormat(-3);
        getContext().getWindow().setSoftInputMode(51);
    }
}
