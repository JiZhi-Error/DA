package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.live.c.b;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.api.g;
import com.tencent.mm.plugin.finder.cgi.cn;
import com.tencent.mm.plugin.finder.live.model.o;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010&\u001a\u00020\u0013H\u0016J,\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\b\u0010,\u001a\u0004\u0018\u00010\t2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\u0016\u0010/\u001a\u00020(2\u000e\u00100\u001a\n\u0012\u0004\u0012\u00020(\u0018\u000101J\u001a\u00102\u001a\u00020(2\u0006\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u000106H\u0016J\b\u00107\u001a\u00020(H\u0016J\u0010\u00108\u001a\u00020(2\u0006\u00109\u001a\u00020\tH\u0002J\u0006\u0010:\u001a\u00020(J\u000e\u0010;\u001a\u00020(2\u0006\u0010<\u001a\u00020=J\u000e\u0010>\u001a\u00020(2\u0006\u0010<\u001a\u00020?R\u000e\u0010\b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006@"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorAfterPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "root", "Landroid/view/ViewGroup;", "statueMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "backBtn", "Landroid/widget/ImageView;", "infoGroup", "Landroid/widget/LinearLayout;", "likeCountTv", "Landroid/widget/TextView;", "likeTv", "liveDurationTv", "livingToFinish", "", "newFollowCountContainer", "Landroid/view/View;", "newFollowCountTv", "newFollowIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "newFollowTv", "okBtn", "Landroid/widget/Button;", "rootContent", "Landroid/widget/RelativeLayout;", "split1", "titleTv", "visitorCountTv", "visitorTv", "wecoinHotCountTv", "wecoinHotGroup", "wecoinHotGroupArrow", "wecoinHotTv", "onBackPress", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "show", "afterAction", "Lkotlin/Function0;", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "unMount", "updateBg", "bgUrl", "updateBgByUsername", "updateFinishInfo", "info", "Lcom/tencent/mm/plugin/finder/live/viewmodel/AnchorFinishInfo;", "updateLiveInfo", "Lcom/tencent/mm/protocal/protobuf/FinderCloseLiveResp;", "plugin-finder_release"})
public final class e extends d implements i {
    private final String TAG = "Finder.LiveAnchorAfterPlugin";
    public final View ULh;
    public final ImageView hNZ;
    private final TextView hOc;
    public final TextView hOd;
    public final TextView hOf;
    public final TextView hOg;
    private final RelativeLayout hOm;
    public final b hOy;
    private final TextView hPG;
    public final Button hPX;
    private final TextView titleTv;
    private final View ume;
    public final TextView umf;
    private final TextView umg;
    public final WeImageView umh;
    public final View umi;
    private final TextView umj;
    public final TextView umk;
    public final View uml;
    public final LinearLayout umm;
    public boolean umn;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(final ViewGroup viewGroup, b bVar) {
        super(viewGroup, bVar);
        p.h(viewGroup, "root");
        p.h(bVar, "statueMonitor");
        AppMethodBeat.i(246410);
        this.hOy = bVar;
        View findViewById = viewGroup.findViewById(R.id.edy);
        p.g(findViewById, "root.findViewById(R.id.live_after_over_tv)");
        this.titleTv = (TextView) findViewById;
        View findViewById2 = viewGroup.findViewById(R.id.ed_);
        p.g(findViewById2, "root.findViewById(R.id.live_after_duration_tv)");
        this.hOg = (TextView) findViewById2;
        View findViewById3 = viewGroup.findViewById(R.id.eew);
        p.g(findViewById3, "root.findViewById(R.id.live_after_visitor_count)");
        this.hOd = (TextView) findViewById3;
        View findViewById4 = viewGroup.findViewById(R.id.eev);
        p.g(findViewById4, "root.findViewById(R.id.live_after_visitor)");
        this.hOc = (TextView) findViewById4;
        View findViewById5 = viewGroup.findViewById(R.id.edi);
        p.g(findViewById5, "root.findViewById(R.id.live_after_like_count)");
        this.hOf = (TextView) findViewById5;
        View findViewById6 = viewGroup.findViewById(R.id.edh);
        p.g(findViewById6, "root.findViewById(R.id.live_after_like)");
        this.hPG = (TextView) findViewById6;
        View findViewById7 = viewGroup.findViewById(R.id.ede);
        p.g(findViewById7, "root.findViewById(R.id.l…er_info_new_follow_group)");
        this.ume = findViewById7;
        View findViewById8 = viewGroup.findViewById(R.id.edw);
        p.g(findViewById8, "root.findViewById(R.id.l…e_after_new_follow_count)");
        this.umf = (TextView) findViewById8;
        View findViewById9 = viewGroup.findViewById(R.id.edv);
        p.g(findViewById9, "root.findViewById(R.id.live_after_new_follow)");
        this.umg = (TextView) findViewById9;
        View findViewById10 = viewGroup.findViewById(R.id.edx);
        p.g(findViewById10, "root.findViewById(R.id.live_after_new_follow_icon)");
        this.umh = (WeImageView) findViewById10;
        View findViewById11 = viewGroup.findViewById(R.id.edg);
        p.g(findViewById11, "root.findViewById(R.id.l…er_info_wecoin_hot_group)");
        this.umi = findViewById11;
        View findViewById12 = viewGroup.findViewById(R.id.k06);
        p.g(findViewById12, "root.findViewById(R.id.l…e_after_wecoin_hot_arrow)");
        this.ULh = findViewById12;
        View findViewById13 = viewGroup.findViewById(R.id.eex);
        p.g(findViewById13, "root.findViewById(R.id.live_after_wecoin_hot)");
        this.umj = (TextView) findViewById13;
        View findViewById14 = viewGroup.findViewById(R.id.eey);
        p.g(findViewById14, "root.findViewById(R.id.l…e_after_wecoin_hot_count)");
        this.umk = (TextView) findViewById14;
        View findViewById15 = viewGroup.findViewById(R.id.eej);
        p.g(findViewById15, "root.findViewById(R.id.live_after_split_1)");
        this.uml = findViewById15;
        View findViewById16 = viewGroup.findViewById(R.id.eda);
        p.g(findViewById16, "root.findViewById(R.id.live_after_finish_btn)");
        this.hPX = (Button) findViewById16;
        View findViewById17 = viewGroup.findViewById(R.id.eeu);
        p.g(findViewById17, "root.findViewById(R.id.live_after_ui_root_group)");
        this.hOm = (RelativeLayout) findViewById17;
        View findViewById18 = viewGroup.findViewById(R.id.edc);
        p.g(findViewById18, "root.findViewById(R.id.live_after_info_group)");
        this.umm = (LinearLayout) findViewById18;
        View findViewById19 = viewGroup.findViewById(R.id.xx);
        p.g(findViewById19, "root.findViewById(R.id.back_icon)");
        this.hNZ = (ImageView) findViewById19;
        this.hPX.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.finder.live.plugin.e.AnonymousClass1 */
            final /* synthetic */ e umo;

            {
                this.umo = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(246398);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorAfterPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                this.umo.hOy.statusChange(b.c.hLD, null);
                if (this.umo.hOy.getLiveRole() == 1) {
                    k kVar = k.vkd;
                    k.a(s.e.CLICK_FINISH, "");
                }
                a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorAfterPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(246398);
            }
        });
        this.ume.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.finder.live.plugin.e.AnonymousClass2 */
            final /* synthetic */ e umo;

            {
                this.umo = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(246399);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorAfterPlugin$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (Util.safeParseInt(this.umo.umf.getText().toString()) > 0) {
                    Intent intent = new Intent();
                    intent.putExtra("PARAM_FINDER_LIVE_ID", this.umo.getLiveData().liveInfo.liveId);
                    com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
                    Context context = viewGroup.getContext();
                    p.g(context, "root.context");
                    com.tencent.mm.plugin.finder.utils.a.ae(context, intent);
                }
                a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorAfterPlugin$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(246399);
            }
        });
        this.umi.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.finder.live.plugin.e.AnonymousClass3 */
            final /* synthetic */ e umo;

            {
                this.umo = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(246400);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorAfterPlugin$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                this.umo.getLiveData().uDS = false;
                Intent intent = new Intent();
                intent.putExtra("KEY_LIVE_ID", this.umo.getLiveData().liveInfo.liveId);
                intent.putExtra("KEY_OBJECT_ID", this.umo.getLiveData().hFK);
                intent.putExtra("KEY_OBJECT_NONCE_ID", this.umo.getLiveData().hwg);
                intent.putExtra("TYPE_MEMBER_ONLINE", this.umo.getLiveData().liveInfo.ViH);
                com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
                Context context = viewGroup.getContext();
                p.g(context, "root.context");
                com.tencent.mm.plugin.finder.utils.a.af(context, intent);
                if (this.umo.hOy.getLiveRole() == 1) {
                    k kVar = k.vkd;
                    k.a(s.e.SEE_GIFT_LIST, String.valueOf(s.i.ENTER_UI.action));
                }
                a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorAfterPlugin$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(246400);
            }
        });
        TextView textView = this.titleTv;
        ViewGroup.LayoutParams layoutParams = textView != null ? textView.getLayoutParams() : null;
        if (layoutParams == null) {
            t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            AppMethodBeat.o(246410);
            throw tVar;
        }
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin += au.getStatusBarHeight(MMApplicationContext.getContext());
        Button button = this.hPX;
        ViewGroup.LayoutParams layoutParams2 = button != null ? button.getLayoutParams() : null;
        if (layoutParams2 == null) {
            t tVar2 = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            AppMethodBeat.o(246410);
            throw tVar2;
        }
        ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin += au.aD(MMApplicationContext.getContext());
        ao.a(this.titleTv.getPaint(), 0.8f);
        ao.a(this.hPX.getPaint(), 0.8f);
        this.hNZ.setImageDrawable(ar.m(viewGroup.getContext(), R.raw.icons_filled_back, -1));
        this.hNZ.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.finder.live.plugin.e.AnonymousClass4 */
            final /* synthetic */ e umo;

            {
                this.umo = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(246401);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorAfterPlugin$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                this.umo.hOy.statusChange(b.c.hLD, null);
                a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorAfterPlugin$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(246401);
            }
        });
        AppMethodBeat.o(246410);
    }

    public final void dgL() {
        g gVar;
        String str = null;
        AppMethodBeat.i(246404);
        RelativeLayout relativeLayout = this.hOm;
        Context context = this.hwr.getContext();
        p.g(context, "root.context");
        relativeLayout.setBackgroundColor(context.getResources().getColor(R.color.q3));
        if (getLiveData().hwd != null) {
            c.a aVar = c.tsp;
            gVar = c.a.asG(getLiveData().hwd);
        } else {
            gVar = null;
        }
        if (gVar != null) {
            str = gVar.field_avatarUrl;
        }
        if (!Util.isNullOrNil(str)) {
            dgM();
            AppMethodBeat.o(246404);
            return;
        }
        Log.i(this.TAG, "update bg fail,contact is null!");
        com.tencent.mm.kernel.b aAg = com.tencent.mm.kernel.g.aAg();
        p.g(aAg, "MMKernel.network()");
        aAg.azz().a(3736, this);
        o oVar = o.ujN;
        com.tencent.mm.plugin.finder.live.model.s finderLiveAssistant = o.getFinderLiveAssistant();
        if (finderLiveAssistant != null) {
            finderLiveAssistant.aty(getLiveData().hwd);
            AppMethodBeat.o(246404);
            return;
        }
        AppMethodBeat.o(246404);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        String str2;
        AppMethodBeat.i(246405);
        Log.i(this.TAG, "onSceneEnd errType:" + i2 + ", errCode:" + i3 + ", scene:" + qVar);
        if (qVar instanceof cn) {
            FinderContact cZk = ((cn) qVar).cZk();
            Log.i(this.TAG, "update bg,user page isOnlyFetchUserInfo:" + ((cn) qVar).twC + ", local username:" + getLiveData().hwd + ",req username:" + ((cn) qVar).tuH + "，contact username:" + (cZk != null ? cZk.username : null));
            if (((cn) qVar).twC && p.j(((cn) qVar).tuH, getLiveData().hwd)) {
                com.tencent.mm.kernel.b aAg = com.tencent.mm.kernel.g.aAg();
                p.g(aAg, "MMKernel.network()");
                aAg.azz().b(3736, this);
                if (!(cZk == null || (str2 = cZk.headUrl) == null)) {
                    p.g(str2, LocaleUtil.ITALIAN);
                    dgM();
                    AppMethodBeat.o(246405);
                    return;
                }
            }
        }
        AppMethodBeat.o(246405);
    }

    private final void dgM() {
        AppMethodBeat.i(246406);
        com.tencent.mm.plugin.finder.live.util.g gVar = com.tencent.mm.plugin.finder.live.util.g.uwd;
        com.tencent.mm.plugin.finder.live.util.g.a(getLiveData().hwd, getLiveData().uEu, this.hOm);
        AppMethodBeat.o(246406);
    }

    @Override // com.tencent.mm.live.c.a
    public final void statusChange(b.c cVar, Bundle bundle) {
        AppMethodBeat.i(246407);
        p.h(cVar, "status");
        switch (f.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
                this.umn = bundle != null ? bundle.getBoolean("PARAM_FINDER_LIVE_LIVE_FINISH_MANUAL") : false;
                break;
        }
        AppMethodBeat.o(246407);
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d, com.tencent.mm.live.c.a
    public final void unMount() {
        AppMethodBeat.i(246408);
        super.unMount();
        com.tencent.mm.kernel.b aAg = com.tencent.mm.kernel.g.aAg();
        p.g(aAg, "MMKernel.network()");
        aAg.azz().b(3736, this);
        AppMethodBeat.o(246408);
    }

    @Override // com.tencent.mm.live.c.a
    public final boolean onBackPress() {
        AppMethodBeat.i(246409);
        if (this.hOy.getLiveRole() == 1) {
            k kVar = k.vkd;
            k.a(s.e.CLICK_FINISH, "");
        }
        boolean onBackPress = super.onBackPress();
        AppMethodBeat.o(246409);
        return onBackPress;
    }
}
