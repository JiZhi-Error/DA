package com.tencent.mm.live.c;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.g;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.b.a.c;
import com.tencent.mm.live.b.m;
import com.tencent.mm.live.b.r;
import com.tencent.mm.live.c.b;
import com.tencent.mm.live.view.LiveBottomSheetPanel;
import com.tencent.mm.live.view.a.d;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.q;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.g.a.b;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010+\u001a\u00020,H\u0002J\b\u0010-\u001a\u00020,H\u0016J\b\u0010.\u001a\u00020\u001aH\u0016J\u0012\u0010/\u001a\u00020,2\b\u00100\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u00101\u001a\u00020,H\u0002J\u0010\u00102\u001a\u00020,2\u0006\u00103\u001a\u00020\rH\u0002J,\u00104\u001a\u00020,2\u0006\u00105\u001a\u00020\n2\u0006\u00106\u001a\u00020\n2\b\u00107\u001a\u0004\u0018\u00010\r2\b\u00108\u001a\u0004\u0018\u000109H\u0016J\b\u0010:\u001a\u00020,H\u0016J\b\u0010;\u001a\u00020,H\u0016J\u000e\u0010<\u001a\u00020,2\u0006\u0010=\u001a\u00020>J\u0010\u0010?\u001a\u00020,2\u0006\u0010@\u001a\u00020\rH\u0002J\u0006\u0010A\u001a\u00020,J\u001a\u0010B\u001a\u00020,2\u0006\u0010C\u001a\u00020D2\b\u0010E\u001a\u0004\u0018\u00010FH\u0016J\b\u0010G\u001a\u00020,H\u0016J\u000e\u0010H\u001a\u00020,2\u0006\u0010I\u001a\u00020\u001aR\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rXD¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\n0\u000fj\b\u0012\u0004\u0012\u00020\n`\u0010X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\r0\u000fj\b\u0012\u0004\u0012\u00020\r`\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010)\u001a\u0012\u0012\u0004\u0012\u00020\n0\u000fj\b\u0012\u0004\u0012\u00020\n`\u0010X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010*\u001a\u0012\u0012\u0004\u0012\u00020\r0\u000fj\b\u0012\u0004\u0012\u00020\r`\u0010X\u0004¢\u0006\u0002\n\u0000¨\u0006J"}, hxF = {"Lcom/tencent/mm/live/plugin/LiveMembersListPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Landroid/view/View$OnClickListener;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "BOTTOM_ITEM_SHEET_EXPOSE", "", "BOTTOM_ITEM_SHEET_KICK", "TAG", "", "anchorSheetIds", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "anchorSheetItems", "blankArea", "Landroid/view/View;", "contentGroup", "Lcom/tencent/mm/live/view/LiveBottomSheetPanel;", "curWechatRoom", "emptyTip", "Landroid/widget/TextView;", "isAnchor", "", "kickProgressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "loadingBar", "Landroid/widget/ProgressBar;", "membersAdapter", "Lcom/tencent/mm/live/view/adapter/LiveMemberAdapter;", "retryTip", "singleIconBtn", "Landroid/widget/ImageView;", "singleRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "singleSubTitleTv", "singleTitleTv", "titleGroup", "visitorSheetIds", "visitorSheetItems", "hideMembersList", "", "mount", "onBackPress", "onClick", "view", "onGetLiveOnlineByRoomFail", "onGetLiveOnlineByRoomSuccess", "wechatRoomId", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "pause", "resume", "setupConfig", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "showKickSheet", ch.COL_USERNAME, "showMembersList", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "unMount", "updateKickResult", "kickSucc", "plugin-logic_release"})
public final class ai extends a implements View.OnClickListener, i {
    private final String TAG = "MicroMsg.LiveMembersListPlugin";
    private boolean dMz;
    private final b hOp;
    private final int hRH;
    private final int hRI = 1;
    private final ImageView hRJ;
    private final TextView hRK;
    private final TextView hRL;
    private final TextView hRM;
    private final RecyclerView hRN;
    private final ProgressBar hRO;
    private final TextView hRP;
    private final d hRQ;
    private final View hRR;
    public q hRS;
    private final ArrayList<String> hRT;
    private final ArrayList<String> hRU;
    private final ArrayList<Integer> hRV;
    private final ArrayList<Integer> hRW;
    private String hRX;
    private final View hRx;
    private final LiveBottomSheetPanel hRy;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ai(ViewGroup viewGroup, b bVar) {
        super(viewGroup, bVar);
        p.h(viewGroup, "root");
        p.h(bVar, "statusMonitor");
        AppMethodBeat.i(208121);
        this.hOp = bVar;
        View findViewById = viewGroup.findViewById(R.id.eiu);
        p.g(findViewById, "root.findViewById(R.id.l…ist_single_room_icon_btn)");
        this.hRJ = (ImageView) findViewById;
        View findViewById2 = viewGroup.findViewById(R.id.eiw);
        p.g(findViewById2, "root.findViewById(R.id.l…ist_single_room_title_tv)");
        this.hRK = (TextView) findViewById2;
        View findViewById3 = viewGroup.findViewById(R.id.eit);
        p.g(findViewById3, "root.findViewById(R.id.l…e_members_list_retry_tip)");
        this.hRL = (TextView) findViewById3;
        View findViewById4 = viewGroup.findViewById(R.id.eir);
        p.g(findViewById4, "root.findViewById(R.id.l…e_members_list_empty_tip)");
        this.hRM = (TextView) findViewById4;
        View findViewById5 = viewGroup.findViewById(R.id.eix);
        p.g(findViewById5, "root.findViewById(R.id.l…rs_list_single_room_view)");
        this.hRN = (RecyclerView) findViewById5;
        View findViewById6 = viewGroup.findViewById(R.id.eiq);
        p.g(findViewById6, "root.findViewById(R.id.l…embers_list_content_area)");
        this.hRy = (LiveBottomSheetPanel) findViewById6;
        View findViewById7 = viewGroup.findViewById(R.id.eis);
        p.g(findViewById7, "root.findViewById(R.id.live_members_list_loading)");
        this.hRO = (ProgressBar) findViewById7;
        View findViewById8 = viewGroup.findViewById(R.id.eip);
        p.g(findViewById8, "root.findViewById(R.id.l…_members_list_blank_area)");
        this.hRx = findViewById8;
        View findViewById9 = viewGroup.findViewById(R.id.eiy);
        p.g(findViewById9, "root.findViewById(R.id.l…list_single_sub_title_tv)");
        this.hRP = (TextView) findViewById9;
        this.hRQ = new d();
        View findViewById10 = viewGroup.findViewById(R.id.eiv);
        p.g(findViewById10, "root.findViewById(R.id.l…_single_room_title_group)");
        this.hRR = findViewById10;
        this.hRT = new ArrayList<>();
        this.hRU = new ArrayList<>();
        this.hRV = new ArrayList<>();
        this.hRW = new ArrayList<>();
        this.hRX = "";
        this.hRQ.hXE = new b<View, x>(this) {
            /* class com.tencent.mm.live.c.ai.AnonymousClass1 */
            final /* synthetic */ ai hRY;

            {
                this.hRY = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(View view) {
                AppMethodBeat.i(208108);
                View view2 = view;
                p.h(view2, LocaleUtil.ITALIAN);
                Object tag = view2.getTag();
                if (tag == null) {
                    t tVar = new t("null cannot be cast to non-null type kotlin.String");
                    AppMethodBeat.o(208108);
                    throw tVar;
                }
                ai.a(this.hRY, (String) tag);
                x xVar = x.SXb;
                AppMethodBeat.o(208108);
                return xVar;
            }
        };
        RecyclerView recyclerView = this.hRN;
        viewGroup.getContext();
        recyclerView.setLayoutManager(new GridLayoutManager(5));
        this.hRN.setAdapter(this.hRQ);
        this.hRy.setTranslationY((float) au.az(viewGroup.getContext()).y);
        this.hRy.setOnVisibilityListener(new b<Boolean, x>(this) {
            /* class com.tencent.mm.live.c.ai.AnonymousClass2 */
            final /* synthetic */ ai hRY;

            {
                this.hRY = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(Boolean bool) {
                AppMethodBeat.i(208109);
                if (!bool.booleanValue()) {
                    b.C0376b.a(this.hRY.hOp, b.c.hLP);
                }
                x xVar = x.SXb;
                AppMethodBeat.o(208109);
                return xVar;
            }
        });
        if (!isLandscape()) {
            this.hRy.setPadding(viewGroup.getPaddingLeft(), viewGroup.getPaddingTop(), viewGroup.getPaddingRight(), viewGroup.getPaddingBottom() + au.aD(viewGroup.getContext()));
        } else {
            ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
            if (layoutParams == null) {
                t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                AppMethodBeat.o(208121);
                throw tVar;
            }
            ((ViewGroup.MarginLayoutParams) layoutParams).width = au.az(viewGroup.getContext()).y;
        }
        this.hRx.setOnClickListener(this);
        this.hRJ.setOnClickListener(this);
        this.hRL.setOnClickListener(this);
        m mVar = m.hGg;
        m.f(name(), new kotlin.g.a.a<x>(this) {
            /* class com.tencent.mm.live.c.ai.AnonymousClass3 */
            final /* synthetic */ ai hRY;

            {
                this.hRY = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(208110);
                if (this.hRY.hwr.getVisibility() == 0) {
                    Log.i(this.hRY.TAG, "onlineCntChanged in LiveMembersListPlugin, will update");
                    r rVar = r.hIg;
                    com.tencent.mm.live.b.x xVar = com.tencent.mm.live.b.x.hJf;
                    r.z(com.tencent.mm.live.b.x.aGm(), true);
                }
                x xVar2 = x.SXb;
                AppMethodBeat.o(208110);
                return xVar2;
            }
        });
        AppMethodBeat.o(208121);
    }

    public final void a(LiveConfig liveConfig) {
        AppMethodBeat.i(208113);
        p.h(liveConfig, "config");
        this.dMz = liveConfig.aBC() == LiveConfig.hvT;
        if (this.dMz) {
            com.tencent.mm.live.b.x xVar = com.tencent.mm.live.b.x.hJf;
            if (com.tencent.mm.live.b.x.aGo().size() > 1) {
                ImageView imageView = this.hRJ;
                Context context = this.hwr.getContext();
                p.g(context, "root.context");
                imageView.setImageDrawable(ar.e(context.getResources().getDrawable(R.raw.icons_filled_back), -1));
            } else {
                ImageView imageView2 = this.hRJ;
                Context context2 = this.hwr.getContext();
                p.g(context2, "root.context");
                imageView2.setImageDrawable(ar.e(context2.getResources().getDrawable(R.raw.icons_filled_close), -1));
            }
            TextView textView = this.hRP;
            Context context3 = this.hwr.getContext();
            p.g(context3, "root.context");
            textView.setText(context3.getResources().getString(R.string.eh4));
            this.hRT.add(this.hwr.getContext().getString(R.string.egt));
            this.hRT.add(this.hwr.getContext().getString(R.string.egu));
            this.hRV.add(Integer.valueOf(this.hRI));
            this.hRV.add(Integer.valueOf(this.hRH));
            AppMethodBeat.o(208113);
            return;
        }
        ImageView imageView3 = this.hRJ;
        Context context4 = this.hwr.getContext();
        p.g(context4, "root.context");
        imageView3.setImageDrawable(ar.e(context4.getResources().getDrawable(R.raw.icons_filled_close), -1));
        TextView textView2 = this.hRP;
        Context context5 = this.hwr.getContext();
        p.g(context5, "root.context");
        textView2.setText(context5.getResources().getString(R.string.eh4));
        this.hRU.add(this.hwr.getContext().getString(R.string.egt));
        this.hRW.add(Integer.valueOf(this.hRI));
        AppMethodBeat.o(208113);
    }

    public final void aHF() {
        A a2;
        AppMethodBeat.i(208114);
        com.tencent.mm.live.b.x xVar = com.tencent.mm.live.b.x.hJf;
        HashMap<String, o<ArrayList<String>, Integer>> aGo = com.tencent.mm.live.b.x.aGo();
        com.tencent.mm.live.b.x xVar2 = com.tencent.mm.live.b.x.hJf;
        o<ArrayList<String>, Integer> oVar = aGo.get(com.tencent.mm.live.b.x.aGm());
        if (oVar != null) {
            a2 = oVar.first;
        } else {
            a2 = null;
        }
        A a3 = a2;
        if (a3 == null || a3.isEmpty()) {
            this.hRO.setVisibility(0);
            this.hRL.setVisibility(8);
            this.hRM.setVisibility(8);
            this.hRR.setVisibility(0);
            this.hRN.setVisibility(8);
        } else {
            this.hRO.setVisibility(8);
            this.hRL.setVisibility(8);
            this.hRM.setVisibility(8);
            this.hRR.setVisibility(0);
            this.hRN.setVisibility(0);
        }
        r rVar = r.hIg;
        com.tencent.mm.live.b.x xVar3 = com.tencent.mm.live.b.x.hJf;
        r.GM(com.tencent.mm.live.b.x.aGm());
        this.hRy.post(new a(this));
        AppMethodBeat.o(208114);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class a implements Runnable {
        final /* synthetic */ ai hRY;

        a(ai aiVar) {
            this.hRY = aiVar;
        }

        public final void run() {
            AppMethodBeat.i(208112);
            this.hRY.hRy.show();
            AppMethodBeat.o(208112);
        }
    }

    public final void onClick(View view) {
        AppMethodBeat.i(208115);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveMembersListPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.eiu) {
            this.hRy.hide();
        } else if (valueOf != null && valueOf.intValue() == R.id.eit) {
            r rVar = r.hIg;
            r.aGb();
        } else if (valueOf != null && valueOf.intValue() == R.id.eip) {
            this.hRy.hide();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveMembersListPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(208115);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.live.c.a
    public final void statusChange(b.c cVar, Bundle bundle) {
        AppMethodBeat.i(208116);
        p.h(cVar, "status");
        super.statusChange(cVar, bundle);
        switch (aj.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
            case 2:
            case 3:
                rg(4);
                AppMethodBeat.o(208116);
                return;
            case 4:
                rg(0);
                aHF();
                AppMethodBeat.o(208116);
                return;
            case 5:
                rg(0);
                aHF();
                AppMethodBeat.o(208116);
                return;
            case 6:
                rg(0);
                aHF();
                if (this.hRS == null) {
                    this.hRS = q.a(this.hwr.getContext(), this.hwr.getContext().getString(R.string.egy), true, 2, null);
                }
                q qVar = this.hRS;
                if (qVar != null) {
                    qVar.show();
                    AppMethodBeat.o(208116);
                    return;
                }
                break;
        }
        AppMethodBeat.o(208116);
    }

    @Override // com.tencent.mm.live.c.a
    public final void mount() {
        AppMethodBeat.i(208117);
        com.tencent.mm.kernel.b aAg = g.aAg();
        p.g(aAg, "MMKernel.network()");
        aAg.azz().a(3806, this);
        com.tencent.mm.kernel.b aAg2 = g.aAg();
        p.g(aAg2, "MMKernel.network()");
        aAg2.azz().a(3662, this);
        com.tencent.mm.kernel.b aAg3 = g.aAg();
        p.g(aAg3, "MMKernel.network()");
        aAg3.azz().a(3700, this);
        AppMethodBeat.o(208117);
    }

    @Override // com.tencent.mm.live.c.a
    public final void resume() {
    }

    @Override // com.tencent.mm.live.c.a
    public final void pause() {
    }

    @Override // com.tencent.mm.live.c.a
    public final void unMount() {
        AppMethodBeat.i(208118);
        com.tencent.mm.kernel.b aAg = g.aAg();
        p.g(aAg, "MMKernel.network()");
        aAg.azz().b(3806, this);
        com.tencent.mm.kernel.b aAg2 = g.aAg();
        p.g(aAg2, "MMKernel.network()");
        aAg2.azz().b(3662, this);
        com.tencent.mm.kernel.b aAg3 = g.aAg();
        p.g(aAg3, "MMKernel.network()");
        aAg3.azz().b(3700, this);
        AppMethodBeat.o(208118);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        A<String> a2;
        Integer num;
        A a3;
        int i4;
        AppMethodBeat.i(208120);
        if (qVar instanceof c) {
            if (!(i2 == 0 && i3 == 0) && !((c) qVar).hJE) {
                Log.i(this.TAG, "onGetLiveOnlineByRoomFail");
                if (!this.dMz) {
                    this.hRL.setVisibility(0);
                    this.hRO.setVisibility(8);
                    this.hRR.setVisibility(8);
                    this.hRN.setVisibility(8);
                    this.hRM.setVisibility(8);
                }
                AppMethodBeat.o(208120);
                return;
            } else if (i2 == 0 && i3 == 0) {
                com.tencent.mm.live.b.x xVar = com.tencent.mm.live.b.x.hJf;
                this.hRX = com.tencent.mm.live.b.x.aGm();
                ArrayList arrayList = new ArrayList();
                com.tencent.mm.live.b.x xVar2 = com.tencent.mm.live.b.x.hJf;
                o<ArrayList<String>, Integer> oVar = com.tencent.mm.live.b.x.aGo().get(this.hRX);
                if (oVar != null) {
                    a2 = oVar.first;
                } else {
                    a2 = null;
                }
                if (a2 != null) {
                    for (String str2 : a2) {
                        arrayList.add(new com.tencent.mm.live.view.a.g(str2));
                    }
                }
                A a4 = a2;
                if (a4 == null || a4.isEmpty()) {
                    this.hRM.setVisibility(0);
                    this.hRO.setVisibility(8);
                    this.hRR.setVisibility(0);
                    this.hRN.setVisibility(8);
                    this.hRL.setVisibility(8);
                    TextView textView = this.hRK;
                    ae aeVar = ae.SYK;
                    Context context = this.hwr.getContext();
                    p.g(context, "root.context");
                    String string = context.getResources().getString(R.string.eh6);
                    p.g(string, "root.context.resources.g…ember_list_visitor_title)");
                    Object[] objArr = new Object[1];
                    if (a2 != null) {
                        i4 = Integer.valueOf(a2.size());
                    } else {
                        i4 = 0;
                    }
                    objArr[0] = i4;
                    String format = String.format(string, Arrays.copyOf(objArr, 1));
                    p.g(format, "java.lang.String.format(format, *args)");
                    textView.setText(format);
                } else {
                    this.hRM.setVisibility(8);
                    this.hRO.setVisibility(8);
                    this.hRR.setVisibility(0);
                    this.hRN.setVisibility(0);
                    this.hRL.setVisibility(8);
                    TextView textView2 = this.hRK;
                    ae aeVar2 = ae.SYK;
                    Context context2 = this.hwr.getContext();
                    p.g(context2, "root.context");
                    String string2 = context2.getResources().getString(R.string.eh6);
                    p.g(string2, "root.context.resources.g…ember_list_visitor_title)");
                    String format2 = String.format(string2, Arrays.copyOf(new Object[]{Integer.valueOf(a2.size())}, 1));
                    p.g(format2, "java.lang.String.format(format, *args)");
                    textView2.setText(format2);
                    d dVar = this.hRQ;
                    ArrayList arrayList2 = arrayList;
                    p.h(arrayList2, "members");
                    dVar.hXt.clear();
                    dVar.hXt.addAll(arrayList2);
                    this.hRQ.notifyDataSetChanged();
                }
                String str3 = this.TAG;
                StringBuilder append = new StringBuilder("onGetLiveOnlineByRoomSuccess curWechatRoom:").append(this.hRX).append(" size:");
                com.tencent.mm.live.b.x xVar3 = com.tencent.mm.live.b.x.hJf;
                o<ArrayList<String>, Integer> oVar2 = com.tencent.mm.live.b.x.aGo().get(this.hRX);
                if (oVar2 == null || (a3 = oVar2.first) == null) {
                    num = null;
                } else {
                    num = Integer.valueOf(a3.size());
                }
                Log.i(str3, append.append(num).toString());
            }
        }
        AppMethodBeat.o(208120);
    }

    @Override // com.tencent.mm.live.c.a
    public final boolean onBackPress() {
        AppMethodBeat.i(208119);
        if (this.hwr.getVisibility() == 0) {
            this.hRy.hide();
            AppMethodBeat.o(208119);
            return true;
        }
        AppMethodBeat.o(208119);
        return false;
    }

    public static final /* synthetic */ void a(ai aiVar, String str) {
        AppMethodBeat.i(208122);
        Bundle bundle = new Bundle();
        bundle.putString("PARAM_MEMBERS_PROFILE_USERNAME", str);
        bundle.putBoolean("PARAM_MEMBERS_PROFILE_NEED_NOTIFY_CLOSE", true);
        aiVar.hRy.hide();
        aiVar.hOp.statusChange(b.c.hMk, bundle);
        AppMethodBeat.o(208122);
    }
}
