package com.tencent.mm.plugin.finder.live.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.MenuItem;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.live.c.b;
import com.tencent.mm.plugin.finder.live.model.s;
import com.tencent.mm.plugin.finder.live.viewmodel.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.a.e;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000 %2\u00020\u0001:\u0001%B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u000b\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\fJ\u0006\u0010\u0019\u001a\u00020\u0017J\u0012\u0010\u001a\u001a\u00020\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\u001c\u001a\u00020\u0017H&J\u0010\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0006\u0010 \u001a\u00020\bJ\u0010\u0010!\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020#H&J\u0010\u0010$\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020#H&R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006&"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveMicStateWidget;", "", "root", "Landroid/view/ViewGroup;", "basePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;)V", "TAG", "", "getBasePlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "bindLinkMicUser", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveLinkMicUser;", "getBindLinkMicUser", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveLinkMicUser;", "setBindLinkMicUser", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveLinkMicUser;)V", "bottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "menuItemClickListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "getRoot", "()Landroid/view/ViewGroup;", "", "linkMicUser", "buildBottomSheet", "goToFinderProfile", "finderUsername", "hideLinkMicBottomBar", "prepareMenuItems", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "printBindMicUser", "showLinkMicBottomBar", "contentRect", "Landroid/graphics/Rect;", "updateLinkMicBottomBar", "Companion", "plugin-finder_release"})
public abstract class z {
    public static final a USb = new a((byte) 0);
    private final String TAG = "Finder.FinderLiveMicStateWidget";
    e USa;
    private com.tencent.mm.ui.widget.a.e hOv;
    final ViewGroup hwr;
    final com.tencent.mm.plugin.finder.live.plugin.d uFw;
    private final o.g uhx = new d(this);

    public abstract void hTE();

    public abstract void x(Rect rect);

    public abstract void y(Rect rect);

    public z(ViewGroup viewGroup, com.tencent.mm.plugin.finder.live.plugin.d dVar) {
        p.h(viewGroup, "root");
        p.h(dVar, "basePlugin");
        this.hwr = viewGroup;
        this.uFw = dVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveMicStateWidget$Companion;", "", "()V", "SHEET_MORE_EXPOSE", "", "SHEET_MORE_PORFILE", "SHEET_MORE_REWARD", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onMMMenuItemSelected"})
    static final class d implements o.g {
        final /* synthetic */ z USc;

        d(z zVar) {
            this.USc = zVar;
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            String str;
            String str2;
            String str3;
            String str4;
            String str5 = null;
            AppMethodBeat.i(261206);
            Integer valueOf = menuItem != null ? Integer.valueOf(menuItem.getItemId()) : null;
            if (valueOf != null && valueOf.intValue() == 0) {
                Log.i(this.USc.TAG, "SHEET_MORE_REWARD");
                Bundle bundle = new Bundle();
                e eVar = this.USc.USa;
                if (eVar == null || (str = eVar.username) == null) {
                    str = "";
                }
                bundle.putString("PARAM_FINDER_LIVE_LINK_USERNAME", str);
                e eVar2 = this.USc.USa;
                if (eVar2 == null || (str2 = eVar2.nickname) == null) {
                    str2 = "";
                }
                bundle.putString("PARAM_FINDER_LIVE_LINK_NICKNAME", str2);
                e eVar3 = this.USc.USa;
                if (eVar3 != null) {
                    str3 = eVar3.headUrl;
                } else {
                    str3 = null;
                }
                bundle.putString("PARAM_FINDER_LIVE_LINK_AVATAR", str3);
                this.USc.uFw.umc.statusChange(b.c.hMG, bundle);
                com.tencent.mm.ui.widget.a.e eVar4 = this.USc.hOv;
                if (eVar4 != null) {
                    eVar4.bMo();
                    AppMethodBeat.o(261206);
                    return;
                }
                AppMethodBeat.o(261206);
            } else if (valueOf != null && valueOf.intValue() == 1) {
                Log.i(this.USc.TAG, "SHEET_MORE_PORFILE");
                z zVar = this.USc;
                e eVar5 = this.USc.USa;
                if (eVar5 != null) {
                    str5 = eVar5.username;
                }
                z.a(zVar, str5);
                com.tencent.mm.ui.widget.a.e eVar6 = this.USc.hOv;
                if (eVar6 != null) {
                    eVar6.bMo();
                    AppMethodBeat.o(261206);
                    return;
                }
                AppMethodBeat.o(261206);
            } else if (valueOf == null) {
                AppMethodBeat.o(261206);
            } else {
                if (valueOf.intValue() == 2) {
                    Log.i(this.USc.TAG, "SHEET_MORE_EXPOSE");
                    e eVar7 = this.USc.USa;
                    if (!(eVar7 == null || (str4 = eVar7.username) == null)) {
                        com.tencent.mm.plugin.finder.live.model.o oVar = com.tencent.mm.plugin.finder.live.model.o.ujN;
                        s finderLiveAssistant = com.tencent.mm.plugin.finder.live.model.o.getFinderLiveAssistant();
                        if (finderLiveAssistant != null) {
                            Context context = this.USc.hwr.getContext();
                            p.g(context, "root.context");
                            finderLiveAssistant.a(context, this.USc.uFw.getLiveData().liveInfo.liveId, str4, (Long) 0L);
                        }
                    }
                    com.tencent.mm.ui.widget.a.e eVar8 = this.USc.hOv;
                    if (eVar8 != null) {
                        eVar8.bMo();
                        AppMethodBeat.o(261206);
                        return;
                    }
                }
                AppMethodBeat.o(261206);
            }
        }
    }

    public void b(m mVar) {
        p.h(mVar, "menu");
        e eVar = this.USa;
        if (eVar != null) {
            com.tencent.mm.plugin.finder.utils.m mVar2 = com.tencent.mm.plugin.finder.utils.m.vVH;
            if (!com.tencent.mm.plugin.finder.utils.m.dBP() && this.uFw.getLiveData().dja() && !com.tencent.mm.ac.d.cW(eVar.UPP, 16)) {
                Context context = this.hwr.getContext();
                p.g(context, "root.context");
                SpannableStringBuilder append = new SpannableStringBuilder(context.getResources().getString(R.string.j_s)).append('\"').append((CharSequence) com.tencent.mm.pluginsdk.ui.span.l.c(this.hwr.getContext(), eVar.nickname)).append('\"');
                p.g(append, "SpannableStringBuilder(r…it.nickname)).append('\"')");
                mVar.d(0, append);
            }
            if (as.bjt(eVar.username)) {
                Context context2 = this.hwr.getContext();
                p.g(context2, "root.context");
                SpannableStringBuilder append2 = new SpannableStringBuilder(context2.getResources().getString(R.string.jb4)).append('\"').append((CharSequence) com.tencent.mm.pluginsdk.ui.span.l.c(this.hwr.getContext(), eVar.nickname)).append('\"');
                Context context3 = this.hwr.getContext();
                p.g(context3, "root.context");
                SpannableStringBuilder append3 = append2.append((CharSequence) context3.getResources().getString(R.string.jb3));
                p.g(append3, "SpannableStringBuilder(r…_mic_goto_profile_after))");
                mVar.d(1, append3);
            }
            Context context4 = this.hwr.getContext();
            p.g(context4, "root.context");
            mVar.d(2, context4.getResources().getString(R.string.cx_));
        }
    }

    public final void g(e eVar) {
        p.h(eVar, "linkMicUser");
        this.USa = eVar;
    }

    public final void hUr() {
        if (this.hOv == null) {
            this.hOv = new com.tencent.mm.ui.widget.a.e(this.hwr.getContext(), 1, true);
            com.tencent.mm.ui.widget.a.e eVar = this.hOv;
            if (eVar != null) {
                eVar.hbs();
            }
        }
        com.tencent.mm.ui.widget.a.e eVar2 = this.hOv;
        if (eVar2 != null) {
            eVar2.hbr();
        }
        com.tencent.mm.ui.widget.a.e eVar3 = this.hOv;
        if (eVar3 != null) {
            eVar3.Dp(true);
        }
        com.tencent.mm.ui.widget.a.e eVar4 = this.hOv;
        if (eVar4 != null) {
            eVar4.a(new b(this));
        }
        com.tencent.mm.ui.widget.a.e eVar5 = this.hOv;
        if (eVar5 != null) {
            eVar5.a(this.uhx);
        }
        com.tencent.mm.ui.widget.a.e eVar6 = this.hOv;
        if (eVar6 != null) {
            eVar6.b(new c(this));
        }
        com.tencent.mm.ui.widget.a.e eVar7 = this.hOv;
        if (eVar7 != null) {
            eVar7.dGm();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    static final class b implements o.f {
        final /* synthetic */ z USc;

        b(z zVar) {
            this.USc = zVar;
        }

        @Override // com.tencent.mm.ui.base.o.f
        public final void onCreateMMMenu(m mVar) {
            AppMethodBeat.i(261204);
            com.tencent.mm.ui.widget.a.e eVar = this.USc.hOv;
            if (eVar != null) {
                eVar.setFooterView(null);
            }
            mVar.clear();
            z zVar = this.USc;
            p.g(mVar, "menu");
            zVar.b(mVar);
            AppMethodBeat.o(261204);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onDismiss"})
    static final class c implements e.b {
        final /* synthetic */ z USc;

        c(z zVar) {
            this.USc = zVar;
        }

        @Override // com.tencent.mm.ui.widget.a.e.b
        public final void onDismiss() {
            AppMethodBeat.i(261205);
            this.USc.hOv = null;
            AppMethodBeat.o(261205);
        }
    }

    public static final /* synthetic */ void a(z zVar, String str) {
        boolean z;
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            Log.i(zVar.TAG, "goToFinderProfile finderUsername:".concat(String.valueOf(str)));
            return;
        }
        com.tencent.mm.plugin.finder.live.model.o oVar = com.tencent.mm.plugin.finder.live.model.o.ujN;
        s finderLiveAssistant = com.tencent.mm.plugin.finder.live.model.o.getFinderLiveAssistant();
        if (finderLiveAssistant != null) {
            s.a.a(finderLiveAssistant, false, str);
        }
    }
}
