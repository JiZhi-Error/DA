package com.tencent.mm.live.c;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.b.o;
import com.tencent.mm.live.b.r;
import com.tencent.mm.live.c.b;
import com.tencent.mm.live.view.LiveBottomSheetPanel;
import com.tencent.mm.model.ap;
import com.tencent.mm.model.z;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.RoundCornerImageView;
import com.tencent.mm.ui.widget.a.e;
import java.util.Arrays;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007JH\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\t2\u0006\u0010&\u001a\u00020\t2\u0006\u0010'\u001a\u00020\t2\u0006\u0010(\u001a\u00020\t2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020$0*2\u0010\b\u0002\u0010+\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010*H\u0002J\b\u0010,\u001a\u00020\u001bH\u0016J\u0012\u0010-\u001a\u00020$2\b\u0010.\u001a\u0004\u0018\u00010\u0011H\u0016J\u000e\u0010/\u001a\u00020$2\u0006\u00100\u001a\u000201J\u001a\u00102\u001a\u00020$2\u0006\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u000106H\u0016J\u0012\u00107\u001a\u00020$2\b\u0010\"\u001a\u0004\u0018\u00010\fH\u0002R\u000e\u0010\b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000eX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n \u000f*\u0004\u0018\u00010\u00110\u0011X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n \u000f*\u0004\u0018\u00010\u00110\u0011X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n \u000f*\u0004\u0018\u00010\u00160\u0016X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n \u000f*\u0004\u0018\u00010\u00180\u0018X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001a\n \u000f*\u0004\u0018\u00010\u00180\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001d\u001a\n \u000f*\u0004\u0018\u00010\u00110\u0011X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001e\u001a\n \u000f*\u0004\u0018\u00010\u00180\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001f\u001a\n \u000f*\u0004\u0018\u00010\u00180\u0018X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010 \u001a\n \u000f*\u0004\u0018\u00010\u00180\u0018X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010!\u001a\n \u000f*\u0004\u0018\u00010\u00180\u0018X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000¨\u00068"}, hxF = {"Lcom/tencent/mm/live/plugin/LiveMemberProfilePlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Landroid/view/View$OnClickListener;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "SHEET_REMOVE", "", "SHEET_TITLE", "TAG", "", "avatarIcon", "Lcom/tencent/mm/ui/widget/RoundCornerImageView;", "kotlin.jvm.PlatformType", "blankArea", "Landroid/view/View;", "bottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "closeBtn", "contentGroup", "Lcom/tencent/mm/live/view/LiveBottomSheetPanel;", "cutLiveTv", "Landroid/widget/TextView;", "exposeTv", "isAnchor", "", "needNotifyClosed", "optionGroup", "removeTv", "tipTv1", "tipTv2", "titleTv", ch.COL_USERNAME, "buildConfirmDialog", "", "title", "item", "titleColor", "itemColor", "click", "Lkotlin/Function0;", "cancelClick", "onBackPress", "onClick", "v", "setupConfig", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "updateProfileInfo", "plugin-logic_release"})
public final class ag extends a implements View.OnClickListener {
    private final String TAG = "MicroMsg.LiveMemberProfilePlugin";
    private boolean dMz;
    private final b hOp;
    private com.tencent.mm.ui.widget.a.e hOv;
    private final View hRd;
    private final int hRo;
    private final int hRp = 1;
    private final View hRq;
    private final TextView hRr;
    private final TextView hRs;
    private final TextView hRt;
    private final TextView hRu;
    private final TextView hRv;
    private final RoundCornerImageView hRw;
    private final View hRx;
    private final LiveBottomSheetPanel hRy;
    private boolean hRz;
    private final TextView titleTv;
    private String username;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ag(ViewGroup viewGroup, b bVar) {
        super(viewGroup, bVar);
        p.h(viewGroup, "root");
        p.h(bVar, "statusMonitor");
        AppMethodBeat.i(208107);
        this.hOp = bVar;
        this.hRq = viewGroup.findViewById(R.id.eja);
        this.hRr = (TextView) viewGroup.findViewById(R.id.ej_);
        this.hRs = (TextView) viewGroup.findViewById(R.id.ejb);
        this.hRt = (TextView) viewGroup.findViewById(R.id.ej9);
        this.titleTv = (TextView) viewGroup.findViewById(R.id.ej4);
        this.hRu = (TextView) viewGroup.findViewById(R.id.ej5);
        this.hRv = (TextView) viewGroup.findViewById(R.id.ej6);
        this.hRw = (RoundCornerImageView) viewGroup.findViewById(R.id.ej8);
        this.hRd = viewGroup.findViewById(R.id.ej1);
        this.hRx = viewGroup.findViewById(R.id.ej0);
        this.hRy = (LiveBottomSheetPanel) viewGroup.findViewById(R.id.ej2);
        LiveBottomSheetPanel liveBottomSheetPanel = this.hRy;
        p.g(liveBottomSheetPanel, "contentGroup");
        liveBottomSheetPanel.setTranslationY((float) au.az(viewGroup.getContext()).y);
        this.hRy.setOnVisibilityListener(new kotlin.g.a.b<Boolean, x>(this) {
            /* class com.tencent.mm.live.c.ag.AnonymousClass1 */
            final /* synthetic */ ag hRA;

            {
                this.hRA = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(Boolean bool) {
                AppMethodBeat.i(208091);
                if (!bool.booleanValue()) {
                    this.hRA.rg(8);
                    if (this.hRA.hRz) {
                        b.C0376b.a(this.hRA.hOp, b.c.hMj);
                    }
                }
                x xVar = x.SXb;
                AppMethodBeat.o(208091);
                return xVar;
            }
        });
        if (this.hRy != null) {
            ViewGroup.LayoutParams layoutParams = this.hRy.getLayoutParams();
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                if (!isLandscape()) {
                    this.hRy.setPadding(this.hRy.getPaddingLeft(), this.hRy.getPaddingTop(), this.hRy.getPaddingRight(), au.aD(viewGroup.getContext()));
                } else {
                    layoutParams.width = au.az(viewGroup.getContext()).y;
                    ((LinearLayout.LayoutParams) layoutParams).gravity = 1;
                }
            }
        }
        this.hRr.setOnClickListener(this);
        this.hRs.setOnClickListener(this);
        this.hRw.setOnClickListener(this);
        this.hRd.setOnClickListener(this);
        this.hRx.setOnClickListener(this);
        this.hRt.setOnClickListener(this);
        AppMethodBeat.o(208107);
    }

    private final void a(int i2, int i3, kotlin.g.a.a<x> aVar, kotlin.g.a.a<x> aVar2) {
        AppMethodBeat.i(208102);
        if (this.hOv == null) {
            this.hOv = new com.tencent.mm.ui.widget.a.e(this.hwr.getContext(), 1, true);
            com.tencent.mm.ui.widget.a.e eVar = this.hOv;
            if (eVar != null) {
                eVar.hbs();
            }
            View inflate = View.inflate(this.hwr.getContext(), R.layout.b0l, null);
            TextView textView = (TextView) inflate.findViewById(R.id.eg6);
            p.g(textView, "bottomSheetTitleTv");
            textView.setText(this.hwr.getContext().getString(i2));
            com.tencent.mm.ui.widget.a.e eVar2 = this.hOv;
            if (eVar2 != null) {
                eVar2.setTitleView(inflate);
            }
        }
        com.tencent.mm.ui.widget.a.e eVar3 = this.hOv;
        if (eVar3 != null) {
            eVar3.hbr();
        }
        com.tencent.mm.ui.widget.a.e eVar4 = this.hOv;
        if (eVar4 != null) {
            eVar4.setFooterView(null);
        }
        com.tencent.mm.ui.widget.a.e eVar5 = this.hOv;
        if (eVar5 != null) {
            eVar5.a(new a(this, R.color.xq, i3));
        }
        com.tencent.mm.ui.widget.a.e eVar6 = this.hOv;
        if (eVar6 != null) {
            eVar6.a(new b(this, aVar));
        }
        com.tencent.mm.ui.widget.a.e eVar7 = this.hOv;
        if (eVar7 != null) {
            eVar7.a(new c(aVar2));
        }
        com.tencent.mm.ui.widget.a.e eVar8 = this.hOv;
        if (eVar8 != null) {
            eVar8.b(new d(this));
            AppMethodBeat.o(208102);
            return;
        }
        AppMethodBeat.o(208102);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    public static final class a implements o.f {
        final /* synthetic */ ag hRA;
        final /* synthetic */ int hRB = R.color.xq;
        final /* synthetic */ int hRC;

        a(ag agVar, int i2, int i3) {
            this.hRA = agVar;
            this.hRC = i3;
        }

        @Override // com.tencent.mm.ui.base.o.f
        public final void onCreateMMMenu(m mVar) {
            AppMethodBeat.i(208093);
            mVar.clear();
            if (this.hRB == 0) {
                int i2 = this.hRA.hRp;
                Context context = this.hRA.hwr.getContext();
                p.g(context, "root.context");
                mVar.d(i2, context.getResources().getString(this.hRC));
                AppMethodBeat.o(208093);
                return;
            }
            int i3 = this.hRA.hRp;
            Context context2 = this.hRA.hwr.getContext();
            p.g(context2, "root.context");
            int color = context2.getResources().getColor(this.hRB);
            Context context3 = this.hRA.hwr.getContext();
            p.g(context3, "root.context");
            mVar.a(i3, color, context3.getResources().getString(this.hRC));
            AppMethodBeat.o(208093);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "i", "", "onMMMenuItemSelected"})
    public static final class b implements o.g {
        final /* synthetic */ ag hRA;
        final /* synthetic */ kotlin.g.a.a hRD;

        b(ag agVar, kotlin.g.a.a aVar) {
            this.hRA = agVar;
            this.hRD = aVar;
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(208094);
            p.h(menuItem, "menuItem");
            int itemId = menuItem.getItemId();
            if (itemId != this.hRA.hRo) {
                if (itemId == this.hRA.hRp) {
                    this.hRD.invoke();
                    com.tencent.mm.ui.widget.a.e eVar = this.hRA.hOv;
                    if (eVar != null) {
                        eVar.bMo();
                        AppMethodBeat.o(208094);
                        return;
                    }
                    AppMethodBeat.o(208094);
                    return;
                }
                com.tencent.mm.ui.widget.a.e eVar2 = this.hRA.hOv;
                if (eVar2 != null) {
                    eVar2.bMo();
                    AppMethodBeat.o(208094);
                    return;
                }
            }
            AppMethodBeat.o(208094);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onClick"})
    public static final class c implements e.a {
        final /* synthetic */ kotlin.g.a.a hRE;

        c(kotlin.g.a.a aVar) {
            this.hRE = aVar;
        }

        @Override // com.tencent.mm.ui.widget.a.e.a
        public final void onClick() {
            AppMethodBeat.i(208095);
            kotlin.g.a.a aVar = this.hRE;
            if (aVar != null) {
                aVar.invoke();
                AppMethodBeat.o(208095);
                return;
            }
            AppMethodBeat.o(208095);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onDismiss"})
    public static final class d implements e.b {
        final /* synthetic */ ag hRA;

        d(ag agVar) {
            this.hRA = agVar;
        }

        @Override // com.tencent.mm.ui.widget.a.e.b
        public final void onDismiss() {
            AppMethodBeat.i(208096);
            this.hRA.hOv = null;
            AppMethodBeat.o(208096);
        }
    }

    public final void a(LiveConfig liveConfig) {
        AppMethodBeat.i(208103);
        p.h(liveConfig, "config");
        this.dMz = liveConfig.aBC() == LiveConfig.hvT;
        AppMethodBeat.o(208103);
    }

    @Override // com.tencent.mm.live.c.a
    public final void statusChange(b.c cVar, Bundle bundle) {
        boolean z;
        AppMethodBeat.i(208104);
        p.h(cVar, "status");
        switch (ah.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
                rg(0);
                String string = bundle != null ? bundle.getString("PARAM_MEMBERS_PROFILE_USERNAME") : null;
                if (bundle != null) {
                    z = bundle.getBoolean("PARAM_MEMBERS_PROFILE_NEED_NOTIFY_CLOSE");
                } else {
                    z = false;
                }
                this.hRz = z;
                Log.i(this.TAG, "updateProfileInfo:".concat(String.valueOf(string)));
                this.username = string;
                if (string != null) {
                    a.b.c(this.hRw, string);
                    com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
                    p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
                    as Kn = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).aSN().Kn(string);
                    if (Kn != null) {
                        TextView textView = this.titleTv;
                        p.g(textView, "titleTv");
                        Context context = this.hwr.getContext();
                        com.tencent.mm.live.b.x xVar = com.tencent.mm.live.b.x.hJf;
                        TextView textView2 = this.titleTv;
                        p.g(textView2, "titleTv");
                        textView.setText(com.tencent.mm.pluginsdk.ui.span.l.b(context, com.tencent.mm.live.b.x.GV(string), textView2.getTextSize()));
                        StringBuffer stringBuffer = new StringBuffer();
                        if (Kn.ajE() == 1) {
                            Context context2 = this.hwr.getContext();
                            p.g(context2, "root.context");
                            p.g(stringBuffer.append(context2.getResources().getString(R.string.gxi)).append(" "), "tip.append(root.context.…ng.sex_male)).append(\" \")");
                        } else if (Kn.ajE() == 2) {
                            Context context3 = this.hwr.getContext();
                            p.g(context3, "root.context");
                            stringBuffer.append(context3.getResources().getString(R.string.gxh)).append(" ");
                        }
                        stringBuffer.append(Kn.getProvince()).append(" ");
                        stringBuffer.append(Kn.getCity());
                        if (Util.isNullOrNil(stringBuffer)) {
                            TextView textView3 = this.hRu;
                            p.g(textView3, "tipTv1");
                            textView3.setVisibility(8);
                        } else {
                            TextView textView4 = this.hRu;
                            p.g(textView4, "tipTv1");
                            textView4.setVisibility(0);
                            TextView textView5 = this.hRu;
                            p.g(textView5, "tipTv1");
                            textView5.setText(stringBuffer);
                        }
                        if (Util.isNullOrNil(Kn.getSignature())) {
                            TextView textView6 = this.hRv;
                            p.g(textView6, "tipTv2");
                            textView6.setVisibility(8);
                        } else {
                            TextView textView7 = this.hRv;
                            p.g(textView7, "tipTv2");
                            textView7.setVisibility(0);
                            TextView textView8 = this.hRv;
                            p.g(textView8, "tipTv2");
                            textView8.setText(Kn.getSignature());
                        }
                    }
                }
                com.tencent.mm.kernel.c.a af2 = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.chatroom.a.c.class);
                p.g(af2, "MMKernel.service(IChatroomService::class.java)");
                ap aSX = ((com.tencent.mm.plugin.chatroom.a.c) af2).aSX();
                com.tencent.mm.live.b.x xVar2 = com.tencent.mm.live.b.x.hJf;
                ah Kd = aSX.Kd(com.tencent.mm.live.b.x.aGm());
                if (this.dMz) {
                    if (Util.isEqual(z.aTY(), string)) {
                        View view = this.hRq;
                        p.g(view, "optionGroup");
                        view.setVisibility(4);
                    } else {
                        TextView textView9 = this.hRt;
                        p.g(textView9, "cutLiveTv");
                        textView9.setVisibility(8);
                        TextView textView10 = this.hRs;
                        p.g(textView10, "removeTv");
                        textView10.setVisibility(0);
                        TextView textView11 = this.hRr;
                        p.g(textView11, "exposeTv");
                        textView11.setVisibility(0);
                        View view2 = this.hRq;
                        p.g(view2, "optionGroup");
                        view2.setVisibility(0);
                    }
                } else if (Util.isEqual(z.aTY(), string)) {
                    View view3 = this.hRq;
                    p.g(view3, "optionGroup");
                    view3.setVisibility(4);
                } else {
                    com.tencent.mm.live.b.x xVar3 = com.tencent.mm.live.b.x.hJf;
                    if (Util.isEqual(string, com.tencent.mm.live.b.x.aGt())) {
                        TextView textView12 = this.hRt;
                        p.g(textView12, "cutLiveTv");
                        textView12.setVisibility(8);
                        TextView textView13 = this.hRs;
                        p.g(textView13, "removeTv");
                        textView13.setVisibility(8);
                        TextView textView14 = this.hRr;
                        p.g(textView14, "exposeTv");
                        textView14.setVisibility(0);
                        View view4 = this.hRq;
                        p.g(view4, "optionGroup");
                        view4.setVisibility(0);
                        if (Kd != null) {
                            if (Kd.JO(z.aTY()) || Kd.bjf(z.aTY())) {
                                TextView textView15 = this.hRt;
                                p.g(textView15, "cutLiveTv");
                                textView15.setVisibility(0);
                            } else {
                                TextView textView16 = this.hRt;
                                p.g(textView16, "cutLiveTv");
                                textView16.setVisibility(8);
                            }
                        }
                    } else {
                        TextView textView17 = this.hRt;
                        p.g(textView17, "cutLiveTv");
                        textView17.setVisibility(8);
                        TextView textView18 = this.hRs;
                        p.g(textView18, "removeTv");
                        textView18.setVisibility(8);
                        TextView textView19 = this.hRr;
                        p.g(textView19, "exposeTv");
                        textView19.setVisibility(0);
                        View view5 = this.hRq;
                        p.g(view5, "optionGroup");
                        view5.setVisibility(0);
                    }
                }
                this.hRy.show();
                AppMethodBeat.o(208104);
                return;
            case 2:
                this.hRy.hide();
                break;
        }
        AppMethodBeat.o(208104);
    }

    public final void onClick(View view) {
        AppMethodBeat.i(208105);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveMemberProfilePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.ej_) {
            b.C0376b.a(this.hOp, b.c.hMf);
            com.tencent.mm.live.b.x xVar = com.tencent.mm.live.b.x.hJf;
            String aGm = com.tencent.mm.live.b.x.aGm();
            com.tencent.mm.live.b.x xVar2 = com.tencent.mm.live.b.x.hJf;
            long j2 = com.tencent.mm.live.b.x.aGr().hyH;
            com.tencent.mm.live.b.x xVar3 = com.tencent.mm.live.b.x.hJf;
            String aGt = com.tencent.mm.live.b.x.aGt();
            String aTY = z.aTY();
            p.g(aTY, "ConfigStorageLogic.getUsernameFromUserInfo()");
            com.tencent.mm.live.b.x xVar4 = com.tencent.mm.live.b.x.hJf;
            com.tencent.mm.live.d.e.a(aGm, j2, aGt, 10, 1, aTY, com.tencent.mm.live.b.x.aGr().LIa);
            com.tencent.mm.live.b.x xVar5 = com.tencent.mm.live.b.x.hJf;
            String aGm2 = com.tencent.mm.live.b.x.aGm();
            com.tencent.mm.live.b.x xVar6 = com.tencent.mm.live.b.x.hJf;
            long j3 = com.tencent.mm.live.b.x.aGr().hyH;
            com.tencent.mm.live.b.x xVar7 = com.tencent.mm.live.b.x.hJf;
            String str = com.tencent.mm.live.b.x.aGr().LpF;
            com.tencent.mm.live.b.x xVar8 = com.tencent.mm.live.b.x.hJf;
            int i2 = com.tencent.mm.live.b.x.aGr().LIa;
            com.tencent.mm.live.b.x xVar9 = com.tencent.mm.live.b.x.hJf;
            com.tencent.mm.live.d.e.a(aGm2, j3, str, i2, com.tencent.mm.live.b.x.aGt());
            com.tencent.mm.live.d.f.aIP();
            Intent intent = new Intent();
            intent.putExtra("showShare", false);
            ae aeVar = ae.SYK;
            o.a aVar = com.tencent.mm.live.b.o.hGl;
            String str2 = com.tencent.mm.live.b.o.hGi;
            com.tencent.mm.live.b.x xVar10 = com.tencent.mm.live.b.x.hJf;
            com.tencent.mm.live.b.x xVar11 = com.tencent.mm.live.b.x.hJf;
            String format = String.format(str2, Arrays.copyOf(new Object[]{59, Long.valueOf(com.tencent.mm.live.b.x.aGr().hyH), this.username, com.tencent.mm.live.b.x.aGm()}, 4));
            p.g(format, "java.lang.String.format(format, *args)");
            intent.putExtra("rawUrl", format);
            com.tencent.mm.br.c.b(this.hwr.getContext(), "webview", ".ui.tools.WebViewUI", intent);
        } else if (valueOf != null && valueOf.intValue() == R.id.ejb) {
            a(R.string.egv, R.string.egu, new e(this), null);
            com.tencent.mm.ui.widget.a.e eVar = this.hOv;
            if (eVar != null) {
                eVar.dGm();
            }
        } else if (valueOf == null || valueOf.intValue() != R.id.ej8) {
            if ((valueOf != null && valueOf.intValue() == R.id.ej1) || (valueOf != null && valueOf.intValue() == R.id.ej0)) {
                this.hRy.hide();
            } else if (valueOf != null && valueOf.intValue() == R.id.ej9) {
                com.tencent.mm.live.b.x xVar12 = com.tencent.mm.live.b.x.hJf;
                String aGm3 = com.tencent.mm.live.b.x.aGm();
                com.tencent.mm.live.b.x xVar13 = com.tencent.mm.live.b.x.hJf;
                long j4 = com.tencent.mm.live.b.x.aGr().hyH;
                com.tencent.mm.live.b.x xVar14 = com.tencent.mm.live.b.x.hJf;
                String aGt2 = com.tencent.mm.live.b.x.aGt();
                String aTY2 = z.aTY();
                p.g(aTY2, "ConfigStorageLogic.getUsernameFromUserInfo()");
                com.tencent.mm.live.b.x xVar15 = com.tencent.mm.live.b.x.hJf;
                com.tencent.mm.live.d.e.a(aGm3, j4, aGt2, 11, 1, aTY2, com.tencent.mm.live.b.x.aGr().LIa);
                a(R.string.eh8, R.string.eh7, f.hRF, g.hRG);
                com.tencent.mm.ui.widget.a.e eVar2 = this.hOv;
                if (eVar2 != null) {
                    eVar2.dGm();
                }
                this.hRy.hide();
            }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveMemberProfilePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(208105);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class e extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ ag hRA;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(ag agVar) {
            super(0);
            this.hRA = agVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(208097);
            Bundle bundle = new Bundle();
            String str = this.hRA.username;
            if (str == null) {
                str = "";
            }
            bundle.putString("PARAM_LIVE_KICK_USERNAME", str);
            this.hRA.hOp.statusChange(b.c.hMe, bundle);
            x xVar = x.SXb;
            AppMethodBeat.o(208097);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class f extends q implements kotlin.g.a.a<x> {
        public static final f hRF = new f();

        static {
            AppMethodBeat.i(208099);
            AppMethodBeat.o(208099);
        }

        f() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(208098);
            r rVar = r.hIg;
            r.eE(true);
            com.tencent.mm.live.b.x xVar = com.tencent.mm.live.b.x.hJf;
            String aGm = com.tencent.mm.live.b.x.aGm();
            com.tencent.mm.live.b.x xVar2 = com.tencent.mm.live.b.x.hJf;
            long j2 = com.tencent.mm.live.b.x.aGr().hyH;
            com.tencent.mm.live.b.x xVar3 = com.tencent.mm.live.b.x.hJf;
            String aGt = com.tencent.mm.live.b.x.aGt();
            String aTY = z.aTY();
            p.g(aTY, "ConfigStorageLogic.getUsernameFromUserInfo()");
            com.tencent.mm.live.b.x xVar4 = com.tencent.mm.live.b.x.hJf;
            com.tencent.mm.live.d.e.a(aGm, j2, aGt, 11, 2, aTY, com.tencent.mm.live.b.x.aGr().LIa);
            x xVar5 = x.SXb;
            AppMethodBeat.o(208098);
            return xVar5;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class g extends q implements kotlin.g.a.a<x> {
        public static final g hRG = new g();

        static {
            AppMethodBeat.i(208101);
            AppMethodBeat.o(208101);
        }

        g() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(208100);
            com.tencent.mm.live.b.x xVar = com.tencent.mm.live.b.x.hJf;
            String aGm = com.tencent.mm.live.b.x.aGm();
            com.tencent.mm.live.b.x xVar2 = com.tencent.mm.live.b.x.hJf;
            long j2 = com.tencent.mm.live.b.x.aGr().hyH;
            com.tencent.mm.live.b.x xVar3 = com.tencent.mm.live.b.x.hJf;
            String aGt = com.tencent.mm.live.b.x.aGt();
            String aTY = z.aTY();
            p.g(aTY, "ConfigStorageLogic.getUsernameFromUserInfo()");
            com.tencent.mm.live.b.x xVar4 = com.tencent.mm.live.b.x.hJf;
            com.tencent.mm.live.d.e.a(aGm, j2, aGt, 11, 3, aTY, com.tencent.mm.live.b.x.aGr().LIa);
            x xVar5 = x.SXb;
            AppMethodBeat.o(208100);
            return xVar5;
        }
    }

    @Override // com.tencent.mm.live.c.a
    public final boolean onBackPress() {
        AppMethodBeat.i(208106);
        if (this.hwr.getVisibility() == 0) {
            this.hRy.hide();
            AppMethodBeat.o(208106);
            return true;
        }
        boolean onBackPress = super.onBackPress();
        AppMethodBeat.o(208106);
        return onBackPress;
    }
}
