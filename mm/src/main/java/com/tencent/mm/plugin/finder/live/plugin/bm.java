package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.live.c.b;
import com.tencent.mm.plugin.finder.live.viewmodel.k;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0011J\u001a\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016R\u0014\u0010\u0007\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveVideoOrientationPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statueMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "videoOrientationBtn", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "getVideoOrientationBtn", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "canClearScreen", "", "setLayoutOrientation", "", "isFitRenderMode", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-finder_release"})
public final class bm extends d {
    private static final String uuK = uuK;
    private static final String uuL = uuL;
    public static final a uuM = new a((byte) 0);
    private final String TAG = "Finder.LiveVideoOrientationPlugin";
    private final b hOy;
    private final WeImageView uuJ;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public bm(final ViewGroup viewGroup, b bVar) {
        super(viewGroup, bVar);
        p.h(viewGroup, "root");
        p.h(bVar, "statueMonitor");
        AppMethodBeat.i(247111);
        this.hOy = bVar;
        this.uuJ = (WeImageView) viewGroup.findViewById(R.id.j5k);
        viewGroup.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.finder.live.plugin.bm.AnonymousClass1 */
            final /* synthetic */ bm uuN;

            {
                this.uuN = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(247106);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveVideoOrientationPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Context context = viewGroup.getContext();
                p.g(context, "root.context");
                Resources resources = context.getResources();
                p.g(resources, "root.context.resources");
                if (resources.getConfiguration().orientation == 1) {
                    bm bmVar = this.uuN;
                    a aVar = bm.uuM;
                    String str = bm.uuL;
                    p.h(str, NativeProtocol.WEB_DIALOG_ACTION);
                    Bundle bundle = new Bundle();
                    bundle.putString("ACTION_POST_LANDSCAPE", str);
                    bmVar.getLiveData().a(new k("EVENT_POST_LANDSCAPE_ACTION", bundle, null));
                    bmVar.hTt().onLandscapeAction(bmVar.getLiveData().uEg, bmVar.getLiveData().uEf, bundle, null);
                } else {
                    bm bmVar2 = this.uuN;
                    a aVar2 = bm.uuM;
                    d.a(bmVar2, bm.uuK);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveVideoOrientationPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(247106);
            }
        });
        viewGroup.post(new Runnable() {
            /* class com.tencent.mm.plugin.finder.live.plugin.bm.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(247107);
                Rect rect = new Rect();
                viewGroup.getHitRect(rect);
                Context context = MMApplicationContext.getContext();
                p.g(context, "MMApplicationContext.getContext()");
                int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R.dimen.ct);
                rect.inset(-dimensionPixelOffset, -dimensionPixelOffset);
                ViewParent parent = viewGroup.getParent();
                if (parent == null) {
                    t tVar = new t("null cannot be cast to non-null type android.view.View");
                    AppMethodBeat.o(247107);
                    throw tVar;
                }
                ((View) parent).setTouchDelegate(new TouchDelegate(rect, viewGroup));
                AppMethodBeat.o(247107);
            }
        });
        m mVar = m.vVH;
        m.a(this);
        AppMethodBeat.o(247111);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveVideoOrientationPlugin$Companion;", "", "()V", bm.uuL, "", "getLANDSCAPE_ACTION_CHANGE_VIDEO", "()Ljava/lang/String;", bm.uuK, "getPORTRAIT_ACTION_CHANGE_VIDEO", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(247112);
        AppMethodBeat.o(247112);
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d
    public final boolean dgK() {
        return true;
    }

    @Override // com.tencent.mm.live.c.a
    public final void statusChange(b.c cVar, Bundle bundle) {
        AppMethodBeat.i(247110);
        p.h(cVar, "status");
        super.statusChange(cVar, bundle);
        switch (bn.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
                m mVar = m.vVH;
                m.a(this);
                break;
        }
        AppMethodBeat.o(247110);
    }

    public final void nx(boolean z) {
        AppMethodBeat.i(247109);
        Context context = this.hwr.getContext();
        p.g(context, "root.context");
        Resources resources = context.getResources();
        p.g(resources, "root.context.resources");
        int i2 = resources.getConfiguration().orientation;
        Log.i(this.TAG, "setLayoutOrientation isFitRenderMode:" + z + ",orientaion:" + i2);
        if (!z) {
            rg(8);
            AppMethodBeat.o(247109);
            return;
        }
        switch (i2) {
            case 1:
                this.uuJ.setImageResource(R.raw.icons_outlined_vtoh);
                WeImageView weImageView = this.uuJ;
                Context context2 = this.hwr.getContext();
                p.g(context2, "root.context");
                weImageView.setIconColor(context2.getResources().getColor(R.color.am));
                rg(0);
                com.tencent.mm.plugin.finder.report.live.m.vli.a((Integer) 0, 1, s.al.FROM_ONPLUGIN);
                AppMethodBeat.o(247109);
                return;
            case 2:
                this.uuJ.setImageResource(R.raw.icons_outlined_htov);
                WeImageView weImageView2 = this.uuJ;
                Context context3 = this.hwr.getContext();
                p.g(context3, "root.context");
                weImageView2.setIconColor(context3.getResources().getColor(R.color.am));
                rg(0);
                com.tencent.mm.plugin.finder.report.live.m.vli.a((Integer) 0, 2, s.al.FROM_ONPLUGIN);
                AppMethodBeat.o(247109);
                return;
            default:
                rg(8);
                AppMethodBeat.o(247109);
                return;
        }
    }
}
