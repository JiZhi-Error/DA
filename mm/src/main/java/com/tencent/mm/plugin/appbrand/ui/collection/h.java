package com.tencent.mm.plugin.appbrand.ui.collection;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.modelappbrand.a.g;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.plugin.appbrand.launching.e.f;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.a.e;
import java.util.regex.Pattern;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0010\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001.B\u0019\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0015J\u0016\u0010\"\u001a\u00020 2\u0006\u0010#\u001a\u00020\u00152\u0006\u0010$\u001a\u00020%J\b\u0010&\u001a\u00020 H\u0002J\b\u0010'\u001a\u00020 H\u0002J\u0012\u0010(\u001a\u00020 2\b\u0010)\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010*\u001a\u00020\r2\b\u0010)\u001a\u0004\u0018\u00010\u0005H\u0016J\u001e\u0010+\u001a\u00020 2\b\u0010)\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010,\u001a\u0004\u0018\u00010-H\u0002R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rXD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001d\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001c¨\u0006/"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnLongClickListener;", "itemView", "Landroid/view/View;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder$IEnterWxaListener;", "(Landroid/view/View;Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder$IEnterWxaListener;)V", "bottomLine", "getBottomLine", "()Landroid/view/View;", "canShowLongClickTestMenu", "", "getCanShowLongClickTestMenu", "()Z", "imageIcon", "Landroid/widget/ImageView;", "getImageIcon", "()Landroid/widget/ImageView;", "itemInfo", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "mListener", "getMListener", "()Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder$IEnterWxaListener;", "textName", "Landroid/widget/TextView;", "getTextName", "()Landroid/widget/TextView;", "textType", "getTextType", "fillContent", "", "dataItem", "fillDiffs", "newItem", "diffs", "Landroid/os/Bundle;", "fillIconURL", "fillNickname", "onClick", "v", "onLongClick", "startWeApp", "path", "", "IEnterWxaListener", "plugin-appbrand-integration_release"})
public class h extends RecyclerView.v implements View.OnClickListener, View.OnLongClickListener {
    private final boolean obd;
    private final a obe;
    private final TextView obf;
    private final TextView obg;
    final ImageView obh;
    final View obi;
    LocalUsageInfo obk;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder$IEnterWxaListener;", "", "onEnter", "", "plugin-appbrand-integration_release"})
    public interface a {
        void onEnter();
    }

    public /* synthetic */ h(View view) {
        this(view, null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(View view, a aVar) {
        super(view);
        p.h(view, "itemView");
        AppMethodBeat.i(51284);
        this.obe = aVar;
        this.obd = true;
        view.setOnClickListener(this);
        if (bYl() && a.bYj()) {
            view.setOnLongClickListener(this);
        }
        View findViewById = view.findViewById(R.id.gh0);
        p.g(findViewById, "itemView.findViewById(R.id.primary_text)");
        this.obf = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.iha);
        p.g(findViewById2, "itemView.findViewById(R.id.tag_text)");
        this.obg = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.dt5);
        p.g(findViewById3, "itemView.findViewById(R.id.icon)");
        this.obh = (ImageView) findViewById3;
        View findViewById4 = view.findViewById(R.id.brt);
        p.g(findViewById4, "itemView.findViewById(R.id.divider)");
        this.obi = findViewById4;
        AppMethodBeat.o(51284);
    }

    public static final /* synthetic */ void a(h hVar, View view, String str) {
        AppMethodBeat.i(175232);
        hVar.b(view, str);
        AppMethodBeat.o(175232);
    }

    public boolean bYl() {
        return this.obd;
    }

    private final void b(View view, String str) {
        AppMethodBeat.i(175230);
        LocalUsageInfo localUsageInfo = this.obk;
        if (localUsageInfo != null) {
            f fVar = f.mZp;
            if (view == null) {
                p.hyc();
            }
            Context context = view.getContext();
            String str2 = localUsageInfo.username;
            String str3 = localUsageInfo.appId;
            int i2 = localUsageInfo.iOo;
            AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
            appBrandStatObject.scene = 1103;
            fVar.a(context, str2, str3, str, i2, 0, appBrandStatObject, null, null);
            a aVar = this.obe;
            if (aVar != null) {
                aVar.onEnter();
                AppMethodBeat.o(175230);
                return;
            }
            AppMethodBeat.o(175230);
            return;
        }
        AppMethodBeat.o(175230);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\b0\bH\n¢\u0006\u0002\b\t"}, hxF = {"<anonymous>", "", "menu", "Landroid/view/ContextMenu;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/view/View;", "<anonymous parameter 2>", "Landroid/view/ContextMenu$ContextMenuInfo;", "onCreateContextMenu"})
    static final class b implements View.OnCreateContextMenuListener {
        final /* synthetic */ String lCM;

        b(String str) {
            this.lCM = str;
        }

        public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            AppMethodBeat.i(175227);
            contextMenu.add(0, 0, 0, "打开小程序且path=" + this.lCM);
            contextMenu.add(0, 1, 0, R.string.sj);
            AppMethodBeat.o(175227);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", FirebaseAnalytics.b.INDEX, "", "onMMMenuItemSelected"})
    static final class c implements o.g {
        final /* synthetic */ View haw;
        final /* synthetic */ String lCM;
        final /* synthetic */ h obl;

        c(h hVar, View view, String str) {
            this.obl = hVar;
            this.haw = view;
            this.lCM = str;
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(175228);
            switch (i2) {
                case 0:
                    h.a(this.obl, this.haw, this.lCM);
                    AppMethodBeat.o(175228);
                    return;
                case 1:
                    LocalUsageInfo localUsageInfo = this.obl.obk;
                    if (localUsageInfo != null) {
                        View view = this.haw;
                        if (view == null) {
                            p.hyc();
                        }
                        AppBrandProfileUI.a(view.getContext(), localUsageInfo.username, 3, "", new WxaExposedParams.a().XN(localUsageInfo.appId).wh(3).bAv(), null, null);
                        AppMethodBeat.o(175228);
                        return;
                    }
                    break;
            }
            AppMethodBeat.o(175228);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onDismiss"})
    static final class d implements e.b {
        public static final d obm = new d();

        static {
            AppMethodBeat.i(175229);
            AppMethodBeat.o(175229);
        }

        d() {
        }

        @Override // com.tencent.mm.ui.widget.a.e.b
        public final void onDismiss() {
        }
    }

    public final void f(LocalUsageInfo localUsageInfo) {
        AppMethodBeat.i(51281);
        p.h(localUsageInfo, "dataItem");
        this.obk = localUsageInfo;
        String vO = com.tencent.mm.plugin.appbrand.appcache.e.vO(localUsageInfo.iOo);
        String str = vO;
        if (str == null || str.length() == 0) {
            this.obg.setVisibility(8);
        } else {
            this.obg.setVisibility(0);
            this.obg.setText(vO);
        }
        bYo();
        bYn();
        AppMethodBeat.o(51281);
    }

    /* access modifiers changed from: package-private */
    public final void bYn() {
        AppMethodBeat.i(51282);
        com.tencent.mm.modelappbrand.a.b aXY = com.tencent.mm.modelappbrand.a.b.aXY();
        ImageView imageView = this.obh;
        LocalUsageInfo localUsageInfo = this.obk;
        if (localUsageInfo == null) {
            p.hyc();
        }
        aXY.a(imageView, localUsageInfo.kVZ, com.tencent.mm.modelappbrand.a.a.aXX(), g.iJB);
        AppMethodBeat.o(51282);
    }

    /* access modifiers changed from: package-private */
    public final void bYo() {
        String str;
        AppMethodBeat.i(51283);
        LocalUsageInfo localUsageInfo = this.obk;
        if (localUsageInfo == null) {
            p.hyc();
        }
        String str2 = localUsageInfo.nickname;
        TextView textView = this.obf;
        String str3 = str2;
        if (str3 == null || str3.length() == 0) {
            LocalUsageInfo localUsageInfo2 = this.obk;
            if (localUsageInfo2 == null) {
                p.hyc();
            }
            String str4 = localUsageInfo2.username;
            p.g(str4, "itemInfo!!.username");
            String quote = Pattern.quote("@app");
            p.g(quote, "Pattern.quote(ConstantsStorage.TAG_APPBRAND)");
            str = n.by(str4, quote, "");
        } else {
            str = str2;
        }
        textView.setText(str);
        AppMethodBeat.o(51283);
    }

    public void onClick(View view) {
        AppMethodBeat.i(51280);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        b(view, null);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(51280);
    }

    public boolean onLongClick(View view) {
        boolean z;
        AppMethodBeat.i(175231);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
        if (a.bYj()) {
            if (view == null) {
                p.hyc();
            }
            new com.tencent.mm.ui.tools.l(view.getContext()).a(view, new b("?wechat_appbrand_test=1"), new c(this, view, "?wechat_appbrand_test=1"), d.obm);
            z = true;
        } else {
            z = false;
        }
        com.tencent.mm.hellhoundlib.a.a.a(z, this, "com/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(175231);
        return z;
    }
}
