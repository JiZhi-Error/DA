package com.tencent.mm.plugin.finder.live.widget;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.live.c.b;
import com.tencent.mm.plugin.finder.live.plugin.d;
import com.tencent.mm.plugin.finder.report.live.m;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u001e\u001a\u00020\u001fJ\b\u0010 \u001a\u00020!H\u0002J\u0006\u0010\"\u001a\u00020\u001fJ\b\u0010#\u001a\u00020!H\u0002J\u0006\u0010$\u001a\u00020\u001fJ\u0006\u0010%\u001a\u00020\u001fJ\u0006\u0010&\u001a\u00020!J\u0012\u0010'\u001a\u00020\u001f2\b\u0010(\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010)\u001a\u00020\u001f2\u0006\u0010*\u001a\u00020+H\u0002J\u000e\u0010,\u001a\u00020\u001f2\u0006\u0010-\u001a\u00020\nR\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eXD¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\n \u0013*\u0004\u0018\u00010\u00120\u0012X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\n \u0013*\u0004\u0018\u00010\u00170\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006."}, hxF = {"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorMicEntranceWidget;", "Landroid/view/View$OnClickListener;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "basePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;)V", "SHEET_MORE_ACTION_AUDIO_LINK", "", "SHEET_MORE_ACTION_STOP_LINK", "SHEET_MORE_ACTION_VIDEO_LINK", "TAG", "", "getBasePlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "clickArea", "Landroid/view/View;", "kotlin.jvm.PlatformType", "linkBottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "linkMicIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "menuItemClickListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "getRoot", "()Landroid/view/ViewGroup;", "getStatusMonitor", "()Lcom/tencent/mm/live/plugin/ILiveStatus;", "buildRequestLinkMicDialog", "", "checkLicense", "", "checkLinkMicGroup", "checkPermission", "checkRequestLinkMic", "checkVisible", "isVisible", "onClick", "v", "prepareLinkMenuItems", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "setVisible", "visible", "plugin-finder_release"})
public final class q implements View.OnClickListener {
    private final String TAG = "Finder.FinderLiveVisitorMicEntranceWidget";
    public final View clickArea = this.hwr.findViewById(R.id.cz1);
    final com.tencent.mm.live.c.b hOp;
    public final ViewGroup hwr;
    public final d uFw;
    public final WeImageView uHM = ((WeImageView) this.hwr.findViewById(R.id.cz2));
    private o.g uhx = new c(this);
    private final int usV;
    private final int usW = 1;
    private final int usX = 2;
    private e uvt;

    public q(ViewGroup viewGroup, com.tencent.mm.live.c.b bVar, d dVar) {
        p.h(viewGroup, "root");
        p.h(bVar, "statusMonitor");
        p.h(dVar, "basePlugin");
        AppMethodBeat.i(248182);
        this.hwr = viewGroup;
        this.hOp = bVar;
        this.uFw = dVar;
        this.clickArea.setOnClickListener(this);
        AppMethodBeat.o(248182);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onMMMenuItemSelected"})
    static final class c implements o.g {
        final /* synthetic */ q uHN;

        c(q qVar) {
            this.uHN = qVar;
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(248174);
            Integer valueOf = menuItem != null ? Integer.valueOf(menuItem.getItemId()) : null;
            int i3 = this.uHN.usV;
            if (valueOf != null && valueOf.intValue() == i3) {
                Log.i(this.uHN.TAG, "SHEET_MORE_ACTION_VIDEO_LINK");
                if (!this.uHN.uFw.getLiveData().diZ()) {
                    Log.i(this.uHN.TAG, "skip apply mic, disable mic");
                    Context context = this.uHN.hwr.getContext();
                    Context context2 = this.uHN.hwr.getContext();
                    p.g(context2, "root.context");
                    u.makeText(context, context2.getResources().getString(R.string.ctu), 0).show();
                    AppMethodBeat.o(248174);
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putInt("PARAM_FINDER_LIVE_LINK_MIC_TYPE", 2);
                this.uHN.hOp.statusChange(b.c.hNL, bundle);
                e eVar = this.uHN.uvt;
                if (eVar != null) {
                    eVar.bMo();
                }
                if (this.uHN.hOp.getLiveRole() == 0) {
                    m.a(m.vli, s.ax.APPLY_VIDEO_LINKMIC, (s.z) null, 6);
                }
                AppMethodBeat.o(248174);
                return;
            }
            int i4 = this.uHN.usW;
            if (valueOf != null && valueOf.intValue() == i4) {
                Log.i(this.uHN.TAG, "SHEET_MORE_ACTION_AUDIO_LINK");
                if (!this.uHN.uFw.getLiveData().diZ()) {
                    Log.i(this.uHN.TAG, "skip apply mic, disable mic");
                    Context context3 = this.uHN.hwr.getContext();
                    Context context4 = this.uHN.hwr.getContext();
                    p.g(context4, "root.context");
                    u.makeText(context3, context4.getResources().getString(R.string.ctu), 0).show();
                    AppMethodBeat.o(248174);
                    return;
                }
                Bundle bundle2 = new Bundle();
                bundle2.putInt("PARAM_FINDER_LIVE_LINK_MIC_TYPE", 1);
                this.uHN.hOp.statusChange(b.c.hNL, bundle2);
                e eVar2 = this.uHN.uvt;
                if (eVar2 != null) {
                    eVar2.bMo();
                }
                if (this.uHN.hOp.getLiveRole() == 0) {
                    m.a(m.vli, s.ax.APPLY_AUDIO_LINKMIC, (s.z) null, 6);
                }
                AppMethodBeat.o(248174);
                return;
            }
            int i5 = this.uHN.usX;
            if (valueOf == null) {
                AppMethodBeat.o(248174);
                return;
            }
            if (valueOf.intValue() == i5) {
                Log.i(this.uHN.TAG, "SHEET_MORE_ACTION_STOP_LINK");
                if (this.uHN.hOp.getLiveRole() == 0) {
                    m mVar = m.vli;
                    m.ou(true);
                }
                b.C0376b.a(this.uHN.hOp, b.c.hNP);
                e eVar3 = this.uHN.uvt;
                if (eVar3 != null) {
                    eVar3.bMo();
                    AppMethodBeat.o(248174);
                    return;
                }
            }
            AppMethodBeat.o(248174);
        }
    }

    public final void dju() {
        AppMethodBeat.i(248175);
        if (!this.uFw.getLiveData().diZ() || this.uFw.getLiveData().djm() || !this.uFw.getLiveData().isLiveStarted()) {
            this.hwr.setVisibility(8);
        } else {
            this.hwr.setVisibility(0);
        }
        m.vli.a(s.ax.LINKMIC_ICON_EXPLORE, s.z.INVALIDATE, this.hwr.getVisibility());
        AppMethodBeat.o(248175);
    }

    public final void djR() {
        AppMethodBeat.i(248176);
        if (!this.uFw.getLiveData().diZ()) {
            Log.i(this.TAG, "skip apply mic, disable mic");
            Context context = this.hwr.getContext();
            Context context2 = this.hwr.getContext();
            p.g(context2, "root.context");
            u.makeText(context, context2.getResources().getString(R.string.ctu), 0).show();
            AppMethodBeat.o(248176);
        } else if (!this.uFw.getLiveData().uDC) {
            Log.i(this.TAG, "skip apply mic, ban comment");
            Context context3 = this.hwr.getContext();
            Context context4 = this.hwr.getContext();
            p.g(context4, "root.context");
            u.makeText(context3, context4.getResources().getString(R.string.cts), 0).show();
            AppMethodBeat.o(248176);
        } else if (!djT()) {
            Log.i(this.TAG, "skip apply mic, live lisence unchecked");
            b.C0376b.a(this.hOp, b.c.hNT);
            AppMethodBeat.o(248176);
        } else if (!TW()) {
            Log.i(this.TAG, "skip apply mic, live permission unchecked");
            AppMethodBeat.o(248176);
        } else if (this.uFw.getLiveData().djr()) {
            Context context5 = this.hwr.getContext();
            Context context6 = this.hwr.getContext();
            p.g(context6, "root.context");
            u.makeText(context5, context6.getResources().getString(R.string.cuh), 0).show();
            AppMethodBeat.o(248176);
        } else if (!this.uFw.getLiveData().hTX() || this.uFw.getLiveData().UQh.LFy == 1) {
            djS();
            AppMethodBeat.o(248176);
        } else {
            Bundle bundle = new Bundle();
            Context context7 = this.hwr.getContext();
            p.g(context7, "root.context");
            bundle.putString("PARAM_FINDER_BOTTOM_TIP_TITLE", context7.getResources().getString(R.string.jaf));
            Context context8 = this.hwr.getContext();
            p.g(context8, "root.context");
            bundle.putString("PARAM_FINDER_BOTTOM_TIP_MSG", context8.getResources().getString(R.string.jae));
            bundle.putInt("PARAM_FINDER_BOTTOM_TIP_SCENE", 0);
            this.uFw.umc.statusChange(b.c.wlu, bundle);
            AppMethodBeat.o(248176);
        }
    }

    public final void djS() {
        AppMethodBeat.i(248177);
        if (this.uvt == null) {
            this.uvt = new e(this.hwr.getContext(), 1, true);
            e eVar = this.uvt;
            if (eVar != null) {
                eVar.hbs();
            }
        }
        e eVar2 = this.uvt;
        if (eVar2 != null) {
            eVar2.hbr();
        }
        e eVar3 = this.uvt;
        if (eVar3 != null) {
            eVar3.Dp(true);
        }
        e eVar4 = this.uvt;
        if (eVar4 != null) {
            eVar4.a(new a(this));
        }
        e eVar5 = this.uvt;
        if (eVar5 != null) {
            eVar5.a(this.uhx);
        }
        e eVar6 = this.uvt;
        if (eVar6 != null) {
            eVar6.b(new b(this));
        }
        e eVar7 = this.uvt;
        if (eVar7 != null) {
            eVar7.dGm();
        }
        m.a(m.vli, s.ax.APPLY_LINKMIC, (s.z) null, 6);
        AppMethodBeat.o(248177);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    public static final class a implements o.f {
        final /* synthetic */ q uHN;

        a(q qVar) {
            this.uHN = qVar;
        }

        @Override // com.tencent.mm.ui.base.o.f
        public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
            AppMethodBeat.i(248172);
            e eVar = this.uHN.uvt;
            if (eVar != null) {
                eVar.setFooterView(null);
            }
            mVar.clear();
            q qVar = this.uHN;
            p.g(mVar, "menu");
            q.a(qVar, mVar);
            AppMethodBeat.o(248172);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onDismiss"})
    public static final class b implements e.b {
        final /* synthetic */ q uHN;

        b(q qVar) {
            this.uHN = qVar;
        }

        @Override // com.tencent.mm.ui.widget.a.e.b
        public final void onDismiss() {
            AppMethodBeat.i(248173);
            this.uHN.uvt = null;
            AppMethodBeat.o(248173);
        }
    }

    public final boolean isVisible() {
        AppMethodBeat.i(248178);
        if (this.hwr.getVisibility() == 0) {
            AppMethodBeat.o(248178);
            return true;
        }
        AppMethodBeat.o(248178);
        return false;
    }

    private static boolean djT() {
        AppMethodBeat.i(248179);
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (com.tencent.mm.plugin.finder.storage.c.duQ() == 1) {
            AppMethodBeat.o(248179);
            return true;
        }
        AppMethodBeat.o(248179);
        return false;
    }

    private final boolean TW() {
        AppMethodBeat.i(248180);
        Context context = this.hwr.getContext();
        if (context == null) {
            t tVar = new t("null cannot be cast to non-null type android.app.Activity");
            AppMethodBeat.o(248180);
            throw tVar;
        } else if (!com.tencent.mm.pluginsdk.permission.b.a((Activity) context, "android.permission.CAMERA", 16, "", "")) {
            Log.i(this.TAG, "not get enough permission checkCamera");
            AppMethodBeat.o(248180);
            return false;
        } else {
            Context context2 = this.hwr.getContext();
            if (context2 == null) {
                t tVar2 = new t("null cannot be cast to non-null type android.app.Activity");
                AppMethodBeat.o(248180);
                throw tVar2;
            } else if (!com.tencent.mm.pluginsdk.permission.b.a((Activity) context2, "android.permission.RECORD_AUDIO", 80, "", "")) {
                Log.i(this.TAG, "not get enough permission checkMicroPhone");
                AppMethodBeat.o(248180);
                return false;
            } else {
                AppMethodBeat.o(248180);
                return true;
            }
        }
    }

    public final void onClick(View view) {
        AppMethodBeat.i(248181);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorMicEntranceWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.cz1) {
            djR();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorMicEntranceWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(248181);
    }

    public static final /* synthetic */ void a(q qVar, com.tencent.mm.ui.base.m mVar) {
        T t;
        AppMethodBeat.i(248183);
        List<com.tencent.mm.plugin.finder.live.viewmodel.e> list = qVar.uFw.getLiveData().UPZ;
        p.g(list, "basePlugin.liveData.audienceLinkMicUserList");
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (Util.isEqual(t.uCo, qVar.uFw.getLiveData().djq())) {
                break;
            }
        }
        if (t != null) {
            int i2 = qVar.usX;
            Context context = qVar.hwr.getContext();
            p.g(context, "root.context");
            int color = context.getResources().getColor(R.color.xq);
            Context context2 = qVar.hwr.getContext();
            p.g(context2, "root.context");
            mVar.a(i2, color, context2.getResources().getString(R.string.ctt));
            AppMethodBeat.o(248183);
            return;
        }
        int i3 = qVar.usV;
        Context context3 = qVar.hwr.getContext();
        p.g(context3, "root.context");
        Context context4 = qVar.hwr.getContext();
        p.g(context4, "root.context");
        mVar.a(i3, context3.getResources().getString(R.string.cx2), R.raw.icons_filled_video_call, context4.getResources().getColor(R.color.BW_100_Alpha_0_5));
        int i4 = qVar.usW;
        Context context5 = qVar.hwr.getContext();
        p.g(context5, "root.context");
        Context context6 = qVar.hwr.getContext();
        p.g(context6, "root.context");
        mVar.a(i4, context5.getResources().getString(R.string.cx1), R.raw.icons_filled_call, context6.getResources().getColor(R.color.BW_100_Alpha_0_5));
        AppMethodBeat.o(248183);
    }
}
