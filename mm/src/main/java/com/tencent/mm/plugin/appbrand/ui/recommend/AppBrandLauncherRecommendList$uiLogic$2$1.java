package com.tencent.mm.plugin.appbrand.ui.recommend;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.ui.recommend.AppBrandLauncherRecommendList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u001c\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\fXD¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0013"}, hxF = {"com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandLauncherRecommendList$uiLogic$2$1", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic;", "contentView", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getContentView", "()Landroid/view/View;", "headerViewText", "", "getHeaderViewText", "()Ljava/lang/String;", "needHeader", "", "getNeedHeader", "()Z", "postOnUiThread", "", "runnable", "Ljava/lang/Runnable;", "plugin-appbrand-integration_release"})
public final class AppBrandLauncherRecommendList$uiLogic$2$1 extends AppBrandRecommendUILogic {
    private final boolean needHeader = true;
    final /* synthetic */ AppBrandLauncherRecommendList.b oeC;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AppBrandLauncherRecommendList$uiLogic$2$1(AppBrandLauncherRecommendList.b bVar, FragmentActivity fragmentActivity) {
        super(fragmentActivity);
        this.oeC = bVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.recommend.AppBrandRecommendUILogic
    public final String bYN() {
        AppMethodBeat.i(51306);
        String string = this.oeC.oeB.getString(R.string.qk);
        p.g(string, "this@AppBrandLauncherRec…header_text_all_use_hint)");
        AppMethodBeat.o(51306);
        return string;
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.recommend.AppBrandRecommendUILogic
    public final View getContentView() {
        AppMethodBeat.i(51307);
        View contentView = this.oeC.oeB.getContentView();
        AppMethodBeat.o(51307);
        return contentView;
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.recommend.AppBrandRecommendUILogic
    public final boolean bYO() {
        return this.needHeader;
    }
}
