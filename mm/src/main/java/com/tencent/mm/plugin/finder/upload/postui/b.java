package com.tencent.mm.plugin.finder.upload.postui;

import android.content.Intent;
import android.os.Bundle;
import com.facebook.internal.AnalyticsEvents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.view.FinderExtendReadingView;
import com.tencent.mm.plugin.finder.view.manager.c;
import com.tencent.mm.plugin.finder.widget.post.a;
import com.tencent.mm.protocal.protobuf.aqp;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.ui.MMActivity;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.a.q;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B8\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0007¢\u0006\u0002\u0010\rJ\b\u0010\u001c\u001a\u00020\bH\u0016J \u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020!H\u0002J\u0018\u0010\"\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010#\u001a\u00020\fH\u0016J\b\u0010$\u001a\u00020\fH\u0016J\b\u0010%\u001a\u00020\fH\u0016J\u0010\u0010&\u001a\u00020\f2\b\u0010'\u001a\u0004\u0018\u00010\u000fJ\b\u0010(\u001a\u00020\bH\u0016R\u000e\u0010\u000e\u001a\u00020\u000fXD¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R,\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, hxF = {"Lcom/tencent/mm/plugin/finder/upload/postui/FinderExtendReadingWidget;", "Lcom/tencent/mm/plugin/finder/upload/postui/IFinderPostWidget;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Lcom/tencent/mm/ui/MMActivity;", "extendReadingView", "Lcom/tencent/mm/plugin/finder/view/FinderExtendReadingView;", "changeEditViewCallback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", WeChatBrands.Business.GROUP_OPEN, "", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/view/FinderExtendReadingView;Lkotlin/jvm/functions/Function1;)V", "TAG", "", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "getChangeEditViewCallback", "()Lkotlin/jvm/functions/Function1;", "extendReadingManager", "Lcom/tencent/mm/plugin/finder/view/manager/FinderExtendReadingManager;", "getExtendReadingView", "()Lcom/tencent/mm/plugin/finder/view/FinderExtendReadingView;", "intent", "Landroid/content/Intent;", "postData", "Landroid/os/Bundle;", "canPost", "fillData", "link", "title", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "", "onCreate", "onDestroy", "onPause", "onResume", "setUrl", "url", "shouldInterceptBackPress", "plugin-finder_release"})
public final class b {
    public final String TAG = "Finder.FinderExtendReadingWidget";
    private final MMActivity activity;
    public Intent intent;
    public c vUH = new c(this.activity, this.vUJ, new q<String, String, Integer, x>(this) {
        /* class com.tencent.mm.plugin.finder.upload.postui.b.AnonymousClass1 */
        final /* synthetic */ b vUL;

        {
            this.vUL = r2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.q
        public final /* synthetic */ x d(String str, String str2, Integer num) {
            AppMethodBeat.i(261421);
            String str3 = str;
            String str4 = str2;
            int intValue = num.intValue();
            p.h(str3, "link");
            p.h(str4, "title");
            b bVar = this.vUL;
            aqp aqp = new aqp();
            aqp.link = str3;
            aqp.title = str4;
            aqp.style = intValue;
            Bundle bundle = bVar.vUI;
            if (bundle != null) {
                a.C1355a aVar = com.tencent.mm.plugin.finder.widget.post.a.wCk;
                bundle.putByteArray(com.tencent.mm.plugin.finder.widget.post.a.dIZ(), aqp.toByteArray());
            }
            Intent intent = bVar.intent;
            if (intent != null) {
                intent.putExtra("saveExtendReadingLink", str3);
            }
            Intent intent2 = bVar.intent;
            if (intent2 != null) {
                intent2.putExtra("saveExtendReadingTitle", str4);
            }
            Intent intent3 = bVar.intent;
            if (intent3 != null) {
                intent3.putExtra("saveExtendReadingStyle", intValue);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(261421);
            return xVar;
        }
    }, this.vUK);
    public Bundle vUI;
    public final FinderExtendReadingView vUJ;
    private final kotlin.g.a.b<Boolean, x> vUK;

    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: kotlin.g.a.b<? super java.lang.Boolean, kotlin.x> */
    /* JADX WARN: Multi-variable type inference failed */
    public b(MMActivity mMActivity, FinderExtendReadingView finderExtendReadingView, kotlin.g.a.b<? super Boolean, x> bVar) {
        p.h(mMActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        p.h(finderExtendReadingView, "extendReadingView");
        p.h(bVar, "changeEditViewCallback");
        AppMethodBeat.i(253239);
        this.activity = mMActivity;
        this.vUJ = finderExtendReadingView;
        this.vUK = bVar;
        AppMethodBeat.o(253239);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class a implements Runnable {
        final /* synthetic */ String mkH;
        final /* synthetic */ b vUL;

        public a(b bVar, String str) {
            this.vUL = bVar;
            this.mkH = str;
        }

        public final void run() {
            AppMethodBeat.i(261422);
            this.vUL.vUH.bye(this.mkH);
            AppMethodBeat.o(261422);
        }
    }
}
