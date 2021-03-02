package com.tencent.mm.plugin.finder.live.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.live.c.b;
import com.tencent.mm.live.core.core.c.a;
import com.tencent.mm.plugin.finder.live.plugin.d;
import com.tencent.mm.plugin.finder.report.live.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.a.e;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u001f\u001a\u00020 H\u0002J\u0006\u0010!\u001a\u00020 J\u0006\u0010\"\u001a\u00020 J\u0006\u0010#\u001a\u00020$J\u0010\u0010%\u001a\u00020 2\u0006\u0010&\u001a\u00020'H\u0002J\u000e\u0010(\u001a\u00020 2\u0006\u0010)\u001a\u00020\nJ\u0006\u0010*\u001a\u00020 R\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n \u0013*\u0004\u0018\u00010\u00120\u0012X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n \u0013*\u0004\u0018\u00010\u00150\u0015X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\n \u0013*\u0004\u0018\u00010\u00170\u0017X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\n \u0013*\u0004\u0018\u00010\u00170\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006+"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorMicEntranceWidget;", "", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "basePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;)V", "SHEET_MORE_ACTION_STOP_LINK", "", "TAG", "", "getBasePlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "linkBottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "linkMicGroup", "Landroid/view/View;", "kotlin.jvm.PlatformType", "linkMicIcon", "Landroid/widget/ImageView;", "linkMicPkTip", "Landroid/widget/TextView;", "linkMicTip", "menuItemClickListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "getRoot", "()Landroid/view/ViewGroup;", "getStatusMonitor", "()Lcom/tencent/mm/live/plugin/ILiveStatus;", "buildRequestLinkMicDialog", "", "checkLinkMicGroup", "checkVisible", "isVisible", "", "prepareLinkMenuItems", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "setVisible", "visible", "updateApplyLinkInfo", "plugin-finder_release"})
public final class b {
    public final String TAG = "Finder.FinderLiveAnchorMicEntranceWidget";
    public final TextView UQR = ((TextView) this.hwr.findViewById(R.id.jw6));
    final com.tencent.mm.live.c.b hOp;
    public final ViewGroup hwr;
    private final View uFA = this.hwr.findViewById(R.id.cn3);
    public final TextView uFB = ((TextView) this.hwr.findViewById(R.id.cn4));
    private final ImageView uFC = ((ImageView) this.hwr.findViewById(R.id.cn2));
    public final d uFw;
    private o.g uhx = new c(this);
    final int usX;
    e uvt;

    public b(ViewGroup viewGroup, com.tencent.mm.live.c.b bVar, d dVar) {
        p.h(viewGroup, "root");
        p.h(bVar, "statusMonitor");
        p.h(dVar, "basePlugin");
        AppMethodBeat.i(248027);
        this.hwr = viewGroup;
        this.hOp = bVar;
        this.uFw = dVar;
        ImageView imageView = this.uFC;
        Context context = this.hwr.getContext();
        p.g(context, "root.context");
        imageView.setImageDrawable(ar.e(context.getResources().getDrawable(R.raw.finder_icons_filled_link_mic), -1));
        this.uFA.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.finder.live.widget.b.AnonymousClass1 */
            final /* synthetic */ b uFD;

            {
                this.uFD = r1;
            }

            /* JADX WARNING: Code restructure failed: missing block: B:18:0x00e0, code lost:
                if (r0 == null) goto L_0x009e;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:9:0x009c, code lost:
                if (r0 == null) goto L_0x009e;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void onClick(android.view.View r10) {
                /*
                // Method dump skipped, instructions count: 227
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.live.widget.b.AnonymousClass1.onClick(android.view.View):void");
            }
        });
        AppMethodBeat.o(248027);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onMMMenuItemSelected"})
    static final class c implements o.g {
        final /* synthetic */ b uFD;

        c(b bVar) {
            this.uFD = bVar;
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(248024);
            Integer valueOf = menuItem != null ? Integer.valueOf(menuItem.getItemId()) : null;
            int i3 = this.uFD.usX;
            if (valueOf == null) {
                AppMethodBeat.o(248024);
                return;
            }
            if (valueOf.intValue() == i3) {
                Log.i(this.uFD.TAG, "SHEET_MORE_ACTION_STOP_LINK");
                if (this.uFD.hOp.getLiveRole() == 0) {
                    m mVar = m.vli;
                    m.ou(true);
                }
                b.C0376b.a(this.uFD.hOp, b.c.hNP);
                e eVar = this.uFD.uvt;
                if (eVar != null) {
                    eVar.bMo();
                    AppMethodBeat.o(248024);
                    return;
                }
            }
            AppMethodBeat.o(248024);
        }
    }

    public final void dju() {
        AppMethodBeat.i(248025);
        a.C0381a aVar = a.hAj;
        if (a.C0381a.aDp()) {
            this.hwr.setVisibility(0);
            AppMethodBeat.o(248025);
        } else if (!this.uFw.getLiveData().diZ() || this.uFw.getLiveData().djm() || !this.uFw.getLiveData().isLiveStarted()) {
            this.hwr.setVisibility(8);
            AppMethodBeat.o(248025);
        } else {
            this.hwr.setVisibility(0);
            AppMethodBeat.o(248025);
        }
    }

    public final void djv() {
        AppMethodBeat.i(248026);
        List<com.tencent.mm.plugin.finder.live.viewmodel.e> list = this.uFw.getLiveData().UPX;
        p.g(list, "basePlugin.liveData.linkMicUserList");
        if ((!list.isEmpty()) || this.uFw.getLiveData().djs() || this.uFw.getLiveData().djr()) {
            ImageView imageView = this.uFC;
            Context context = this.hwr.getContext();
            p.g(context, "root.context");
            Drawable drawable = context.getResources().getDrawable(R.raw.finder_icons_filled_link_mic);
            Context context2 = this.hwr.getContext();
            p.g(context2, "root.context");
            imageView.setImageDrawable(ar.e(drawable, context2.getResources().getColor(R.color.ae)));
            View view = this.uFA;
            p.g(view, "linkMicGroup");
            Context context3 = this.hwr.getContext();
            p.g(context3, "root.context");
            view.setBackground(context3.getResources().getDrawable(R.drawable.a1d));
            AppMethodBeat.o(248026);
            return;
        }
        ImageView imageView2 = this.uFC;
        Context context4 = this.hwr.getContext();
        p.g(context4, "root.context");
        imageView2.setImageDrawable(ar.e(context4.getResources().getDrawable(R.raw.finder_icons_filled_link_mic), -1));
        View view2 = this.uFA;
        p.g(view2, "linkMicGroup");
        Context context5 = this.hwr.getContext();
        p.g(context5, "root.context");
        view2.setBackground(context5.getResources().getDrawable(R.drawable.a1c));
        AppMethodBeat.o(248026);
    }
}
