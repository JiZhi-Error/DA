package com.tencent.mm.plugin.webview.ui.tools.media;

import android.content.Context;
import android.view.MenuItem;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.y;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.pluginsdk.ui.tools.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.a.e;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/media/MpVideoMenuHelper;", "", "()V", "MENU_ID_FAV", "", "MENU_ID_SEND_TO_FRIEND", "MENU_ID_SEND_TO_SNS", "TAG", "", "showMenu", "", "ui", "Landroid/content/Context;", "mpShareVideoInfo", "Lcom/tencent/mm/message/MPShareVideoInfo;", "from", "plugin-webview_release"})
public final class g {
    private static final int JwE = 2;
    public static final g JwF = new g();
    private static final String TAG = TAG;
    private static final int pLT = 1;
    private static final int pLV = 0;

    static {
        AppMethodBeat.i(82675);
        AppMethodBeat.o(82675);
    }

    private g() {
    }

    public static void a(Context context, y yVar, int i2) {
        AppMethodBeat.i(82674);
        p.h(context, "ui");
        p.h(yVar, "mpShareVideoInfo");
        a aVar = a.JvG;
        a.kr(i2, 3);
        if (context instanceof WebViewUI) {
            e eVar = new e(context, 1, false);
            eVar.a(new a(context, i2));
            eVar.a(new b(context, yVar, i2));
            eVar.a(new c(i2));
            eVar.o(" ", 1);
            eVar.Do(true);
            eVar.dGm();
            AppMethodBeat.o(82674);
            return;
        }
        Log.e(TAG, "not in WebViewUI now!");
        AppMethodBeat.o(82674);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    public static final class a implements o.f {
        final /* synthetic */ Context JwG;
        final /* synthetic */ int JwH;

        a(Context context, int i2) {
            this.JwG = context;
            this.JwH = i2;
        }

        @Override // com.tencent.mm.ui.base.o.f
        public final void onCreateMMMenu(m mVar) {
            AppMethodBeat.i(82671);
            g gVar = g.JwF;
            mVar.a(g.pLT, (CharSequence) this.JwG.getString(R.string.ftk), R.raw.bottomsheet_icon_transmit, false);
            if (z.gsM()) {
                g gVar2 = g.JwF;
                mVar.a(g.JwE, (CharSequence) this.JwG.getString(R.string.ftl), R.raw.bottomsheet_icon_moment, false);
            }
            if (!(2 == this.JwH || 5 == this.JwH)) {
                g gVar3 = g.JwF;
                mVar.a(g.pLV, (CharSequence) this.JwG.getString(R.string.fn9), R.raw.bottomsheet_icon_fav, false);
            }
            AppMethodBeat.o(82671);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", FirebaseAnalytics.b.INDEX, "", "onMMMenuItemSelected"})
    public static final class b implements o.g {
        final /* synthetic */ Context JwG;
        final /* synthetic */ int JwH;
        final /* synthetic */ y Jwy;

        b(Context context, y yVar, int i2) {
            this.JwG = context;
            this.Jwy = yVar;
            this.JwH = i2;
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(82672);
            p.g(menuItem, "menuItem");
            int itemId = menuItem.getItemId();
            g gVar = g.JwF;
            if (itemId == g.pLT) {
                ((WebViewUI) this.JwG).JjJ.iwi = this.Jwy;
                d dVar = d.Jwx;
                d.a(this.JwG, this.Jwy.iAo, "", this.Jwy.title, this.Jwy.KOe, 2);
                a aVar = a.JvG;
                a.aN(1, this.JwH, 3);
                AppMethodBeat.o(82672);
                return;
            }
            g gVar2 = g.JwF;
            if (itemId == g.pLV) {
                f fVar = f.JwB;
                f.b(this.Jwy);
                h.cA(this.JwG, this.JwG.getString(R.string.caf));
                a aVar2 = a.JvG;
                a.aN(2, this.JwH, 3);
                AppMethodBeat.o(82672);
                return;
            }
            g gVar3 = g.JwF;
            if (itemId == g.JwE) {
                c cVar = c.Jwu;
                y yVar = this.Jwy;
                Context context = this.JwG;
                if (context == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                    AppMethodBeat.o(82672);
                    throw tVar;
                }
                c.b(yVar, (MMActivity) context, this.Jwy.iAP);
                a aVar3 = a.JvG;
                a.aN(4, this.JwH, 3);
            }
            AppMethodBeat.o(82672);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onClick"})
    public static final class c implements e.a {
        final /* synthetic */ int JwH;

        c(int i2) {
            this.JwH = i2;
        }

        @Override // com.tencent.mm.ui.widget.a.e.a
        public final void onClick() {
            AppMethodBeat.i(82673);
            a aVar = a.JvG;
            a.aN(3, this.JwH, 3);
            AppMethodBeat.o(82673);
        }
    }
}
