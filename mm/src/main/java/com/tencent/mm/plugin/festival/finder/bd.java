package com.tencent.mm.plugin.festival.finder;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.g.b.a.oe;
import com.tencent.mm.g.b.a.of;
import com.tencent.mm.live.c.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.festival.PluginFestival;
import com.tencent.mm.plugin.festival.model.ParcelableFestivalWish;
import com.tencent.mm.plugin.festival.model.a.c;
import com.tencent.mm.plugin.festival.model.a.d;
import com.tencent.mm.plugin.festival.model.ai;
import com.tencent.mm.plugin.festival.model.e;
import com.tencent.mm.plugin.finder.live.model.s;
import com.tencent.mm.plugin.finder.model.w;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.axf;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 A2\u00020\u0001:\u0002ABB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u0012\u001a\u00020\u0013J\b\u0010\u0014\u001a\u00020\fH\u0016J\b\u0010\u0015\u001a\u00020\fH\u0002J\b\u0010\u0016\u001a\u00020\u0013H\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020!H\u0002J\u0018\u0010\"\u001a\u00020\u00132\u0006\u0010 \u001a\u00020!2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010#\u001a\u00020\u0013H\u0002J\b\u0010$\u001a\u00020\u0013H\u0002J\u0010\u0010%\u001a\u00020&2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010'\u001a\u00020\u0013H\u0002J\b\u0010(\u001a\u00020\fH\u0002J\u0010\u0010)\u001a\u00020\u00132\u0006\u0010*\u001a\u00020+H\u0002J\b\u0010,\u001a\u00020\u0013H\u0002J\"\u0010-\u001a\u00020\u00132\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020/2\b\u00101\u001a\u0004\u0018\u000102H\u0016J\u0010\u00103\u001a\u00020\u00132\u0006\u00104\u001a\u000205H\u0002J\u0010\u00106\u001a\u00020\u00132\u0006\u00104\u001a\u000205H\u0002J\b\u00107\u001a\u00020\u0013H\u0002J\b\u00108\u001a\u00020\u0013H\u0002J\b\u00109\u001a\u00020\u0013H\u0002J\b\u0010:\u001a\u00020\u0013H\u0002J\b\u0010;\u001a\u00020\u0013H\u0002J\u001a\u0010<\u001a\u00020\u00132\u0006\u0010=\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u00010@H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006C"}, hxF = {"Lcom/tencent/mm/plugin/festival/finder/FestivalFinderMoreActionPlugin;", "Lcom/tencent/mm/plugin/festival/finder/FestivalFinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Lcom/tencent/mm/ui/MMActivity;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/ui/MMActivity;)V", "bottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "enableVisitorRoleEntrance", "", "isLiving", "menuItemClickListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "moreActionBtn", "Landroid/widget/RelativeLayout;", "buildConfirmDialog", "", "canClearScreen", "checkCanSharePic", "chooseVisitorRole", "createHeader", "Landroid/view/View;", "doShareLive2Friend", "feedObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "doShareLive2SNS", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "doSharePic2Friend", "path", "", "doSharePic2SNS", "expose", "exposeImpl", "getFinderLive", "Lcom/tencent/mm/protocal/protobuf/FinderLiveShareObject;", "hideMoreActionBottomSheet", "isShareForbidden", "makeTextLinkable", "textView", "Landroid/widget/TextView;", "miniWindow", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "prepareMenuItems", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "prepareSecondMenuItems", "screenClearAction", "setJumpWithoutMiniWindow", "shareLive2Friend", "shareLive2SNS", "showMyWishAction", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "Companion", "CustomClickSpan", "plugin-festival_release"})
public final class bd extends p {
    @Deprecated
    public static final a UvJ = new a((byte) 0);
    private boolean UvI = true;
    private final MMActivity activity;
    private final com.tencent.mm.live.c.b hOp;
    com.tencent.mm.ui.widget.a.e hOv;
    private boolean hSh;
    o.g uhx;
    private final RelativeLayout utd;

    static {
        AppMethodBeat.i(262716);
        AppMethodBeat.o(262716);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public bd(ViewGroup viewGroup, com.tencent.mm.live.c.b bVar, MMActivity mMActivity) {
        super(viewGroup, bVar);
        p.h(viewGroup, "root");
        p.h(bVar, "statusMonitor");
        p.h(mMActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(262715);
        this.hOp = bVar;
        this.activity = mMActivity;
        View findViewById = viewGroup.findViewById(R.id.cvy);
        p.g(findViewById, "root.findViewById(R.id.f…ve_more_action_btn_group)");
        this.utd = (RelativeLayout) findViewById;
        m mVar = m.vVH;
        this.UvI = m.hVq();
        this.utd.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.festival.finder.bd.AnonymousClass1 */
            final /* synthetic */ bd UvK;

            {
                this.UvK = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(262693);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/festival/finder/FestivalFinderMoreActionPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                b.C0376b.a(this.UvK.hOp, b.c.hNn);
                com.tencent.mm.cr.d.hiy();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/festival/finder/FestivalFinderMoreActionPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(262693);
            }
        });
        m mVar2 = m.vVH;
        m.a(this);
        Log.i("MicroMsg.FestivalFinderLiveMoreActionPlugin", "enableVisitorRoleEntrance:" + this.UvI);
        this.uhx = new j(this);
        AppMethodBeat.o(262715);
    }

    public static final /* synthetic */ void i(bd bdVar) {
        AppMethodBeat.i(262723);
        bdVar.dhE();
        AppMethodBeat.o(262723);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fXT¢\u0006\u0002\n\u0000¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/festival/finder/FestivalFinderMoreActionPlugin$Companion;", "", "()V", "SHEET_MORE_ACTION_MINI_WINDOW", "", "SHEET_MORE_ACTION_MY_WISH", "SHEET_MORE_ACTION_REPORT", "SHEET_MORE_ACTION_SCREEN_CLEAR", "SHEET_MORE_ACTION_SHARE_2_FRIEMD", "SHEET_MORE_ACTION_SHARE_2_SNS", "SHEET_MORE_ACTION_VISITOR_ROLE", "TAG", "", "plugin-festival_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d
    public final boolean dgK() {
        return true;
    }

    private final void dhC() {
        AppMethodBeat.i(262709);
        getLiveData().uDS = false;
        AppMethodBeat.o(262709);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onMMMenuItemSelected"})
    static final class j implements o.g {
        final /* synthetic */ bd UvK;

        j(bd bdVar) {
            this.UvK = bdVar;
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(262707);
            Integer valueOf = menuItem != null ? Integer.valueOf(menuItem.getItemId()) : null;
            a unused = bd.UvJ;
            if (valueOf != null && valueOf.intValue() == 0) {
                bd.e(this.UvK);
                AppMethodBeat.o(262707);
                return;
            }
            a unused2 = bd.UvJ;
            if (valueOf != null && valueOf.intValue() == 1) {
                bd.f(this.UvK);
                AppMethodBeat.o(262707);
                return;
            }
            a unused3 = bd.UvJ;
            if (valueOf != null && valueOf.intValue() == 7) {
                bd.g(this.UvK);
                if (this.UvK.hOp.getLiveRole() == 0) {
                    com.tencent.mm.plugin.finder.report.live.m.vli.hUH();
                    AppMethodBeat.o(262707);
                    return;
                }
            } else {
                a unused4 = bd.UvJ;
                if (valueOf != null && valueOf.intValue() == 6) {
                    bd.h(this.UvK);
                } else {
                    a unused5 = bd.UvJ;
                    if (valueOf != null && valueOf.intValue() == 3) {
                        bd.j(this.UvK);
                    } else {
                        a unused6 = bd.UvJ;
                        if (valueOf != null && valueOf.intValue() == 4) {
                            bd.k(this.UvK);
                        } else {
                            a unused7 = bd.UvJ;
                            if (valueOf != null && valueOf.intValue() == 11) {
                                bd.l(this.UvK);
                                AppMethodBeat.o(262707);
                                return;
                            }
                        }
                    }
                }
                bd.i(this.UvK);
            }
            AppMethodBeat.o(262707);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    static final class c implements o.f {
        final /* synthetic */ bd UvK;

        c(bd bdVar) {
            this.UvK = bdVar;
        }

        @Override // com.tencent.mm.ui.base.o.f
        public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
            AppMethodBeat.i(262698);
            com.tencent.mm.ui.widget.a.e eVar = this.UvK.hOv;
            if (eVar != null) {
                eVar.setFooterView(null);
            }
            mVar.clear();
            bd bdVar = this.UvK;
            p.g(mVar, "menu");
            bd.a(bdVar, mVar);
            AppMethodBeat.o(262698);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    static final class d implements o.f {
        final /* synthetic */ bd UvK;

        d(bd bdVar) {
            this.UvK = bdVar;
        }

        @Override // com.tencent.mm.ui.base.o.f
        public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
            AppMethodBeat.i(262699);
            com.tencent.mm.ui.widget.a.e eVar = this.UvK.hOv;
            if (eVar != null) {
                eVar.setFooterView(null);
            }
            mVar.clear();
            bd bdVar = this.UvK;
            p.g(mVar, "menu");
            bd.b(bdVar, mVar);
            AppMethodBeat.o(262699);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onDismiss"})
    static final class e implements e.b {
        final /* synthetic */ bd UvK;

        e(bd bdVar) {
            this.UvK = bdVar;
        }

        @Override // com.tencent.mm.ui.widget.a.e.b
        public final void onDismiss() {
            AppMethodBeat.i(262700);
            b.C0376b.a(this.UvK.hOp, b.c.hNo);
            this.UvK.hOv = null;
            AppMethodBeat.o(262700);
        }
    }

    /* access modifiers changed from: package-private */
    public final void H(TextView textView) {
        AppMethodBeat.i(262710);
        CharSequence text = textView.getText();
        if (text instanceof Spannable) {
            int length = text.length();
            CharSequence text2 = textView.getText();
            if (text2 == null) {
                t tVar = new t("null cannot be cast to non-null type android.text.Spannable");
                AppMethodBeat.o(262710);
                throw tVar;
            }
            Spannable spannable = (Spannable) text2;
            URLSpan[] uRLSpanArr = (URLSpan[]) spannable.getSpans(0, length, URLSpan.class);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(text);
            spannableStringBuilder.clearSpans();
            if (uRLSpanArr != null) {
                for (URLSpan uRLSpan : uRLSpanArr) {
                    Context context = this.hwr.getContext();
                    p.g(context, "root.context");
                    p.g(uRLSpan, LocaleUtil.ITALIAN);
                    spannableStringBuilder.setSpan(new b(context, uRLSpan.getURL()), spannable.getSpanStart(uRLSpan), spannable.getSpanEnd(uRLSpan), 33);
                }
            }
            textView.setText(spannableStringBuilder);
        }
        AppMethodBeat.o(262710);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/festival/finder/FestivalFinderMoreActionPlugin$CustomClickSpan;", "Landroid/text/style/ClickableSpan;", "context", "Landroid/content/Context;", "url", "", "(Landroid/content/Context;Ljava/lang/String;)V", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "plugin-festival_release"})
    public static final class b extends ClickableSpan {
        private final Context context;
        private final String url;

        public b(Context context2, String str) {
            p.h(context2, "context");
            AppMethodBeat.i(262696);
            this.context = context2;
            this.url = str;
            AppMethodBeat.o(262696);
        }

        public final void updateDrawState(TextPaint textPaint) {
            AppMethodBeat.i(262694);
            p.h(textPaint, "ds");
            super.updateDrawState(textPaint);
            textPaint.setColor(this.context.getResources().getColor(R.color.agb));
            AppMethodBeat.o(262694);
        }

        public final void onClick(View view) {
            AppMethodBeat.i(262695);
            p.h(view, "widget");
            a unused = bd.UvJ;
            Log.i("MicroMsg.FestivalFinderLiveMoreActionPlugin", "click go url:%s", this.url);
            Intent intent = new Intent();
            intent.putExtra("rawUrl", this.url);
            com.tencent.mm.br.c.b(this.context, "webview", ".ui.tools.WebViewUI", intent);
            oe oeVar = new oe();
            oeVar.PE(Util.nowSecond());
            com.tencent.mm.plugin.festival.model.a.b bVar = com.tencent.mm.plugin.festival.model.a.b.UzX;
            oeVar.GJ(com.tencent.mm.plugin.festival.model.a.b.hRV());
            oeVar.PZ(2);
            oeVar.bfK();
            AppMethodBeat.o(262695);
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.live.c.a
    public final void statusChange(b.c cVar, Bundle bundle) {
        boolean z;
        FinderObject finderObject;
        FinderObject finderObject2;
        String str = null;
        AppMethodBeat.i(262711);
        p.h(cVar, "status");
        super.statusChange(cVar, bundle);
        switch (be.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
            case 2:
                rg(4);
                this.hSh = false;
                AppMethodBeat.o(262711);
                return;
            case 3:
            case 4:
                this.hSh = true;
                AppMethodBeat.o(262711);
                return;
            case 5:
                m mVar = m.vVH;
                m.a(this);
                AppMethodBeat.o(262711);
                return;
            case 6:
                if (bundle != null) {
                    str = bundle.getString("FariyWandPicPath");
                }
                if (str != null) {
                    getLiveData().uDS = false;
                    Intent intent = new Intent();
                    intent.putExtra("Retr_File_Name", str);
                    intent.putExtra("Retr_Compress_Type", 0);
                    intent.putExtra("Retr_Msg_Type", 0);
                    com.tencent.mm.br.c.a(this.activity, ".ui.transmit.MsgRetransmitUI", intent, 1, h.UvM);
                    AppMethodBeat.o(262711);
                    return;
                }
                AppMethodBeat.o(262711);
                return;
            case 7:
                if (getLiveData().uDz == null || ((finderObject2 = getLiveData().uDz) != null && finderObject2.id == 0)) {
                    u.u(this.hwr.getContext(), this.hwr.getContext().getString(R.string.j9k), 0);
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    if (bundle != null) {
                        str = bundle.getString("FariyWandPicPath");
                    }
                    String str2 = str;
                    if (!(str2 == null || str2.length() == 0) && (finderObject = getLiveData().uDz) != null) {
                        getLiveData().uDS = false;
                        FinderItem.a aVar = FinderItem.Companion;
                        Log.i("MicroMsg.FestivalFinderLiveMoreActionPlugin", "share finderObject festival2021 to sns");
                        Intent intent2 = new Intent();
                        com.tencent.mm.modelsns.d dVar = new com.tencent.mm.modelsns.d();
                        dVar.a(y(new w(FinderItem.a.a(finderObject, 16384)).feedObject));
                        intent2.putExtra("ksnsupload_finder_live_xml", dVar.bfF());
                        intent2.putExtra("Ksnsupload_type", 28);
                        intent2.putExtra("sns_kemdia_path", str);
                        intent2.putExtra("need_result", true);
                        com.tencent.mm.br.c.a(this.activity, ".plugin.sns.ui.SnsUploadUI", intent2, 2, new i(this));
                        AppMethodBeat.o(262711);
                        return;
                    }
                }
                break;
        }
        AppMethodBeat.o(262711);
    }

    private final void dhE() {
        AppMethodBeat.i(262712);
        b.C0376b.a(this.hOp, b.c.hNo);
        com.tencent.mm.ui.widget.a.e eVar = this.hOv;
        if (eVar != null) {
            eVar.bMo();
            AppMethodBeat.o(262712);
            return;
        }
        AppMethodBeat.o(262712);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "mmOnActivityResult"})
    static final class h implements MMActivity.a {
        public static final h UvM = new h();

        static {
            AppMethodBeat.i(262705);
            AppMethodBeat.o(262705);
        }

        h() {
        }

        @Override // com.tencent.mm.ui.MMActivity.a
        public final void d(int i2, int i3, Intent intent) {
            AppMethodBeat.i(262704);
            new ArrayList();
            if (i3 == -1) {
                ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("SendMsgUsernames");
                p.g(stringArrayListExtra, "data.getStringArrayListE…sgRetr.KSendMsgUsernames)");
                a unused = bd.UvJ;
                Log.i("MicroMsg.FestivalFinderLiveMoreActionPlugin", "share festival2021 pic to ".concat(String.valueOf(stringArrayListExtra)));
                if (!stringArrayListExtra.isEmpty()) {
                    a unused2 = bd.UvJ;
                    Log.i("MicroMsg.FestivalFinderLiveMoreActionPlugin", "share festival2021 pic to conversation");
                    com.tencent.mm.plugin.festival.model.a.d dVar = com.tencent.mm.plugin.festival.model.a.d.UAc;
                    com.tencent.mm.plugin.festival.model.a.d.a(d.a.Chat);
                    AppMethodBeat.o(262704);
                    return;
                }
            } else {
                a unused3 = bd.UvJ;
                Log.i("MicroMsg.FestivalFinderLiveMoreActionPlugin", "cancel share festival2021 pic to conversation");
            }
            AppMethodBeat.o(262704);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "mmOnActivityResult"})
    static final class i implements MMFragmentActivity.b {
        final /* synthetic */ bd UvK;

        i(bd bdVar) {
            this.UvK = bdVar;
        }

        @Override // com.tencent.mm.ui.MMFragmentActivity.b
        public final void d(int i2, int i3, Intent intent) {
            AppMethodBeat.i(262706);
            if (i3 == -1) {
                com.tencent.mm.ui.base.h.cA(this.UvK.activity, this.UvK.activity.getContext().getString(R.string.z0));
                a unused = bd.UvJ;
                Log.i("MicroMsg.FestivalFinderLiveMoreActionPlugin", "share festival2021 pic to snstimeline");
                com.tencent.mm.plugin.festival.model.a.d dVar = com.tencent.mm.plugin.festival.model.a.d.UAc;
                com.tencent.mm.plugin.festival.model.a.d.a(d.a.SnsTimeline);
                AppMethodBeat.o(262706);
                return;
            }
            a unused2 = bd.UvJ;
            Log.i("MicroMsg.FestivalFinderLiveMoreActionPlugin", "cancel share festival2021 pic to snstimeline");
            AppMethodBeat.o(262706);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "mmOnActivityResult"})
    public static final class f implements MMActivity.a {
        public static final f UvL = new f();

        static {
            AppMethodBeat.i(262702);
            AppMethodBeat.o(262702);
        }

        f() {
        }

        @Override // com.tencent.mm.ui.MMActivity.a
        public final void d(int i2, int i3, Intent intent) {
            AppMethodBeat.i(262701);
            new ArrayList();
            if (i3 == -1) {
                ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("SendMsgUsernames");
                p.g(stringArrayListExtra, "data.getStringArrayListE…sgRetr.KSendMsgUsernames)");
                a unused = bd.UvJ;
                Log.i("MicroMsg.FestivalFinderLiveMoreActionPlugin", "share festival2021 live to ".concat(String.valueOf(stringArrayListExtra)));
                if (!stringArrayListExtra.isEmpty()) {
                    a unused2 = bd.UvJ;
                    Log.i("MicroMsg.FestivalFinderLiveMoreActionPlugin", "share festival2021 live to conversation");
                    com.tencent.mm.plugin.festival.model.a.c cVar = com.tencent.mm.plugin.festival.model.a.c.UzY;
                    com.tencent.mm.plugin.festival.model.a.c.a(c.a.Chat);
                    AppMethodBeat.o(262701);
                    return;
                }
            } else {
                a unused3 = bd.UvJ;
                Log.i("MicroMsg.FestivalFinderLiveMoreActionPlugin", "cancel share festival2021 live to conversation");
            }
            AppMethodBeat.o(262701);
        }
    }

    private static axf y(FinderItem finderItem) {
        String str;
        String str2;
        AppMethodBeat.i(262713);
        axf axf = new axf();
        axf.feedId = com.tencent.mm.ac.d.zs(finderItem.getId());
        awe liveInfo = finderItem.getLiveInfo();
        axf.hJs = com.tencent.mm.ac.d.zs(liveInfo != null ? liveInfo.liveId : 0);
        axf.username = finderItem.field_username;
        axf.nickName = finderItem.getNickName();
        com.tencent.mm.plugin.finder.search.i iVar = com.tencent.mm.plugin.finder.search.i.vvu;
        axf.desc = com.tencent.mm.plugin.finder.search.i.auY(finderItem.getDescription());
        String str3 = finderItem.getLiveMediaList().getFirst().coverUrl;
        if (str3 == null || str3.length() == 0) {
            str = p.I(finderItem.getLiveMediaList().getFirst().thumbUrl, Util.nullAsNil(finderItem.getLiveMediaList().getFirst().thumb_url_token));
        } else {
            str = finderItem.getLiveMediaList().getFirst().coverUrl;
        }
        axf.coverUrl = str;
        axf.width = finderItem.getLiveMediaList().getFirst().width;
        axf.height = finderItem.getLiveMediaList().getFirst().height;
        FinderContact finderContact = finderItem.getFeedObject().contact;
        if (finderContact == null || (str2 = finderContact.headUrl) == null) {
            str2 = "";
        }
        axf.headUrl = str2;
        axf.objectNonceId = finderItem.getFeedObject().objectNonceId;
        e.a aVar = com.tencent.mm.plugin.festival.model.e.UxL;
        axf.liveStatus = e.a.getLiveStatus();
        AppMethodBeat.o(262713);
        return axf;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "mmOnActivityResult"})
    public static final class g implements MMFragmentActivity.b {
        final /* synthetic */ bd UvK;

        g(bd bdVar) {
            this.UvK = bdVar;
        }

        @Override // com.tencent.mm.ui.MMFragmentActivity.b
        public final void d(int i2, int i3, Intent intent) {
            AppMethodBeat.i(262703);
            if (i3 == -1) {
                com.tencent.mm.ui.base.h.cA(this.UvK.activity, this.UvK.activity.getContext().getString(R.string.z0));
                a unused = bd.UvJ;
                Log.i("MicroMsg.FestivalFinderLiveMoreActionPlugin", "share festival2021 live to snstimeline");
                com.tencent.mm.plugin.festival.model.a.c cVar = com.tencent.mm.plugin.festival.model.a.c.UzY;
                com.tencent.mm.plugin.festival.model.a.c.a(c.a.SnsTimeline);
                AppMethodBeat.o(262703);
                return;
            }
            a unused2 = bd.UvJ;
            Log.i("MicroMsg.FestivalFinderLiveMoreActionPlugin", "cancel share festival2021 live to snstimeline");
            AppMethodBeat.o(262703);
        }
    }

    @Override // com.tencent.mm.live.c.a
    public final void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(262714);
        switch (i2) {
            case 1009:
                if (i3 != -1) {
                    Log.i("MicroMsg.FestivalFinderLiveMoreActionPlugin", "REQUEST_FINDER_LIVE_ROLE resultCode:" + i3 + ",data:" + intent);
                    break;
                } else {
                    at atVar = at.Uuv;
                    s finderLiveAssistant = at.getFinderLiveAssistant();
                    if (finderLiveAssistant != null) {
                        finderLiveAssistant.b(this);
                        AppMethodBeat.o(262714);
                        return;
                    }
                    AppMethodBeat.o(262714);
                    return;
                }
        }
        AppMethodBeat.o(262714);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class k extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ bd UvK;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(bd bdVar) {
            super(0);
            this.UvK = bdVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(262708);
            Context context = this.UvK.hwr.getContext();
            if (context == null) {
                t tVar = new t("null cannot be cast to non-null type android.app.Activity");
                AppMethodBeat.o(262708);
                throw tVar;
            }
            ((Activity) context).finish();
            x xVar = x.SXb;
            AppMethodBeat.o(262708);
            return xVar;
        }
    }

    public static final /* synthetic */ void a(bd bdVar, com.tencent.mm.ui.base.m mVar) {
        boolean z;
        FinderObject finderObject;
        FinderObject finderObject2;
        AppMethodBeat.i(262717);
        com.tencent.mm.plugin.festival.model.t tVar = com.tencent.mm.plugin.festival.model.t.UyR;
        if (!com.tencent.mm.plugin.festival.model.t.awC(1)) {
            Context context = bdVar.hwr.getContext();
            p.g(context, "root.context");
            String string = context.getResources().getString(R.string.cxd);
            Context context2 = bdVar.hwr.getContext();
            p.g(context2, "root.context");
            mVar.a(0, string, R.raw.finder_icons_filled_share, context2.getResources().getColor(R.color.Brand), bdVar.getLiveData().uDz == null || ((finderObject2 = bdVar.getLiveData().uDz) != null && finderObject2.id == 0));
            Context context3 = bdVar.hwr.getContext();
            p.g(context3, "root.context");
            String string2 = context3.getResources().getString(R.string.cxe);
            if (bdVar.getLiveData().uDz == null || ((finderObject = bdVar.getLiveData().uDz) != null && finderObject.id == 0)) {
                z = true;
            } else {
                z = false;
            }
            mVar.a(1, string2, R.raw.bottomsheet_icon_moment, 0, z);
        }
        AppMethodBeat.o(262717);
    }

    public static final /* synthetic */ void b(bd bdVar, com.tencent.mm.ui.base.m mVar) {
        AppMethodBeat.i(262718);
        mVar.a(3, bdVar.hwr.getContext().getString(R.string.j90), R.raw.icons_filled_star2021, android.support.v4.content.b.n(bdVar.hwr.getContext(), R.color.BW_100_Alpha_0_8));
        Context context = bdVar.hwr.getContext();
        p.g(context, "root.context");
        mVar.b(4, context.getResources().getString(R.string.cx9), R.raw.icons_outlined_mini_window);
        if (!bdVar.getLiveData().uDR) {
            Context context2 = bdVar.hwr.getContext();
            p.g(context2, "root.context");
            String string = context2.getResources().getString(R.string.cxa);
            p.g(string, "root.context.resources.g…more_action_screen_clear)");
            mVar.b(6, string, R.raw.finder_icons_screen_clear);
        }
        Context context3 = bdVar.hwr.getContext();
        p.g(context3, "root.context");
        mVar.b(7, context3.getResources().getString(R.string.cx_), R.raw.icons_outlined_report_problem);
        if (bdVar.UvI) {
            Context context4 = bdVar.hwr.getContext();
            p.g(context4, "root.context");
            mVar.b(11, context4.getResources().getString(R.string.jcn), R.raw.icons_outlined_exchange);
        }
        AppMethodBeat.o(262718);
    }

    public static final /* synthetic */ void e(bd bdVar) {
        AppMethodBeat.i(262719);
        Log.i("MicroMsg.FestivalFinderLiveMoreActionPlugin", "share2FriendImpl");
        FinderObject finderObject = bdVar.getLiveData().uDz;
        if (finderObject != null) {
            FinderItem.a aVar = FinderItem.Companion;
            FinderItem a2 = FinderItem.a.a(finderObject, 16384);
            k.b bVar = new k.b();
            com.tencent.mm.plugin.i.a.b bVar2 = new com.tencent.mm.plugin.i.a.b();
            bVar2.b(y(a2));
            bVar.a(bVar2);
            bVar.type = 77;
            bVar.title = MMApplicationContext.getContext().getString(R.string.enf);
            bVar.url = MMApplicationContext.getContext().getString(R.string.eng);
            bVar.description = bVar2.wDV.desc;
            bVar.thumburl = bVar2.wDV.coverUrl;
            Intent intent = new Intent();
            intent.putExtra("Retr_Msg_Type", 29);
            intent.putExtra("Multi_Retr", true);
            intent.putExtra("Retr_Msg_content", k.b.a(bVar, null, null));
            intent.putExtra("Retr_go_to_chattingUI", false);
            intent.putExtra("Retr_show_success_tips", true);
            com.tencent.mm.br.c.a(bdVar.activity, ".ui.transmit.MsgRetransmitUI", intent, 0, f.UvL);
            bdVar.dhC();
        }
        b.C0376b.a(bdVar.hOp, b.c.hNo);
        com.tencent.mm.ui.widget.a.e eVar = bdVar.hOv;
        if (eVar != null) {
            eVar.bMo();
            AppMethodBeat.o(262719);
            return;
        }
        AppMethodBeat.o(262719);
    }

    public static final /* synthetic */ void f(bd bdVar) {
        AppMethodBeat.i(262720);
        Log.i("MicroMsg.FestivalFinderLiveMoreActionPlugin", "share2SNSImpl");
        FinderObject finderObject = bdVar.getLiveData().uDz;
        if (finderObject != null) {
            awe awe = finderObject.liveInfo;
            if (awe != null) {
                e.a aVar = com.tencent.mm.plugin.festival.model.e.UxL;
                awe.liveStatus = e.a.getLiveStatus();
            }
            FinderItem.a aVar2 = FinderItem.Companion;
            Log.i("MicroMsg.FestivalFinderLiveMoreActionPlugin", "share finderObject festival2021 to sns");
            Intent intent = new Intent();
            com.tencent.mm.modelsns.d dVar = new com.tencent.mm.modelsns.d();
            dVar.a(y(new w(FinderItem.a.a(finderObject, 16384)).feedObject));
            intent.putExtra("ksnsupload_finder_live_xml", dVar.bfF());
            intent.putExtra("Ksnsupload_type", 27);
            intent.putExtra("need_result", true);
            intent.putExtra("Ksnsupload_title", MMApplicationContext.getContext().getString(R.string.enf));
            intent.putExtra("Ksnsupload_link", MMApplicationContext.getContext().getString(R.string.eng));
            com.tencent.mm.br.c.a(bdVar.activity, ".plugin.sns.ui.SnsUploadUI", intent, 1, new g(bdVar));
            bdVar.dhC();
        }
        b.C0376b.a(bdVar.hOp, b.c.hNo);
        com.tencent.mm.ui.widget.a.e eVar = bdVar.hOv;
        if (eVar != null) {
            eVar.bMo();
            AppMethodBeat.o(262720);
            return;
        }
        AppMethodBeat.o(262720);
    }

    public static final /* synthetic */ void g(bd bdVar) {
        AppMethodBeat.i(262721);
        Log.i("MicroMsg.FestivalFinderLiveMoreActionPlugin", "exposeImpl");
        at atVar = at.Uuv;
        s finderLiveAssistant = at.getFinderLiveAssistant();
        if (finderLiveAssistant != null) {
            s.a.a(finderLiveAssistant, bdVar.activity, bdVar.getLiveData().liveInfo.liveId, bdVar.getLiveData().hwd);
        }
        bdVar.dhE();
        AppMethodBeat.o(262721);
    }

    public static final /* synthetic */ void h(bd bdVar) {
        s.h hVar;
        AppMethodBeat.i(262722);
        com.tencent.mm.plugin.festival.model.a.a aVar = com.tencent.mm.plugin.festival.model.a.a.UzS;
        of PF = new of().PF(com.tencent.mm.plugin.festival.model.a.a.hRU());
        com.tencent.mm.plugin.festival.model.a.b bVar = com.tencent.mm.plugin.festival.model.a.b.UzX;
        PF.GK(com.tencent.mm.plugin.festival.model.a.b.hRV()).Tz(z.aTY()).SM(5).SR(4).bfK();
        bdVar.getLiveData().uDR = true;
        Bundle bundle = new Bundle();
        bundle.putBoolean("PARAM_FINDER_LIVE_SCREEN_CLEAR", bdVar.getLiveData().uDR);
        bdVar.hOp.statusChange(b.c.hNl, bundle);
        if (bdVar.hOp.getLiveRole() == 0) {
            if (bdVar.getLiveData().uDR) {
                hVar = s.h.CLICK_CLEAR_SCREEN_MENU;
            } else {
                hVar = s.h.CLICK_CLEAR_SCREEN_CANCEL;
            }
            com.tencent.mm.plugin.finder.report.live.m.vli.a(hVar);
        }
        AppMethodBeat.o(262722);
    }

    public static final /* synthetic */ void j(bd bdVar) {
        AppMethodBeat.i(262724);
        com.tencent.mm.plugin.festival.model.a.a aVar = com.tencent.mm.plugin.festival.model.a.a.UzS;
        of PF = new of().PF(com.tencent.mm.plugin.festival.model.a.a.hRU());
        com.tencent.mm.plugin.festival.model.a.b bVar = com.tencent.mm.plugin.festival.model.a.b.UzX;
        PF.GK(com.tencent.mm.plugin.festival.model.a.b.hRV()).Tz(z.aTY()).SM(4).SR(4).bfK();
        com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(PluginFestival.class);
        p.g(ah, "plugin(PluginFestival::class.java)");
        ai hRS = ((PluginFestival) ah).getFestivalWishStorage().hRS();
        if (hRS == null || hRS.field_delFlag != 0) {
            u.cE(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(R.string.j91));
            AppMethodBeat.o(262724);
            return;
        }
        com.tencent.mm.live.c.b bVar2 = bdVar.hOp;
        b.c cVar = b.c.wsX;
        Bundle bundle = new Bundle();
        ParcelableFestivalWish.a aVar2 = ParcelableFestivalWish.UzR;
        bundle.putParcelable("PARAM_FESTIVAL_FINDER_LIVE_PERSONAL_WISH_DATA_MODEL", ParcelableFestivalWish.a.a(hRS));
        bundle.putBoolean("PARAM_FESTIVAL_FINDER_LIVE_PERSONAL_WISH_CAN_JUMP_CONTACT_PROFILE", true);
        bVar2.statusChange(cVar, bundle);
        AppMethodBeat.o(262724);
    }

    public static final /* synthetic */ void k(bd bdVar) {
        AppMethodBeat.i(262725);
        com.tencent.mm.ac.d.a(300, new k(bdVar));
        AppMethodBeat.o(262725);
    }

    public static final /* synthetic */ void l(bd bdVar) {
        AppMethodBeat.i(262726);
        Log.i("MicroMsg.FestivalFinderLiveMoreActionPlugin", "chooseVisitorRole");
        at atVar = at.Uuv;
        com.tencent.mm.plugin.finder.live.model.s finderLiveAssistant = at.getFinderLiveAssistant();
        if (finderLiveAssistant != null) {
            s.a.a(finderLiveAssistant, bdVar.activity);
        }
        bdVar.dhE();
        AppMethodBeat.o(262726);
    }
}
