package com.tencent.mm.plugin.finder.profile.uic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.utils.b;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.view.d;
import com.tencent.mm.plugin.i.a.ai;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.protocal.protobuf.apg;
import com.tencent.mm.protocal.protobuf.azg;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;
import org.json.JSONObject;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n*\u0001\u001f\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\rH\u0002J\b\u00103\u001a\u000201H\u0002J\u0012\u00104\u001a\u0002012\b\u00105\u001a\u0004\u0018\u000106H\u0016J\b\u00107\u001a\u000201H\u0016J\u0010\u00108\u001a\u0002012\u0006\u00109\u001a\u00020:H\u0002J\"\u0010;\u001a\u0002012\u0006\u0010<\u001a\u00020,2\b\b\u0002\u00109\u001a\u00020:2\b\b\u0002\u0010=\u001a\u00020,J\b\u0010>\u001a\u000201H\u0002J\b\u0010?\u001a\u00020\rH\u0002J\b\u0010@\u001a\u00020\rH\u0002J\b\u0010A\u001a\u000201H\u0002J\b\u0010B\u001a\u000201H\u0002J\b\u0010C\u001a\u000201H\u0002R#\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068FX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\r8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u000fR\u001b\u0010\u0016\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0016\u0010\u000fR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0010\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0004\n\u0002\u0010 R#\u0010!\u001a\n \u0007*\u0004\u0018\u00010\"0\"8FX\u0002¢\u0006\f\n\u0004\b%\u0010\u000b\u001a\u0004\b#\u0010$R#\u0010&\u001a\n \u0007*\u0004\u0018\u00010'0'8FX\u0002¢\u0006\f\n\u0004\b*\u0010\u000b\u001a\u0004\b(\u0010)R#\u0010+\u001a\n \u0007*\u0004\u0018\u00010,0,8BX\u0002¢\u0006\f\n\u0004\b/\u0010\u000b\u001a\u0004\b-\u0010.¨\u0006D"}, hxF = {"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileEduUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "checkBox", "Landroid/widget/CheckBox;", "kotlin.jvm.PlatformType", "getCheckBox", "()Landroid/widget/CheckBox;", "checkBox$delegate", "Lkotlin/Lazy;", "clickGo", "", "getClickGo", "()Z", "setClickGo", "(Z)V", "fromMusic", "getFromMusic", "setFromMusic", "isSelf", "isSelfFlag", "isSelfFlag$delegate", "loadingComponent", "Lcom/tencent/mm/plugin/finder/utils/DelayLoadingComponent;", "getLoadingComponent", "()Lcom/tencent/mm/plugin/finder/utils/DelayLoadingComponent;", "setLoadingComponent", "(Lcom/tencent/mm/plugin/finder/utils/DelayLoadingComponent;)V", "profileSettingCallback", "com/tencent/mm/plugin/finder/profile/uic/FinderProfileEduUIC$profileSettingCallback$1", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileEduUIC$profileSettingCallback$1;", "tipsLayout", "Landroid/view/View;", "getTipsLayout", "()Landroid/view/View;", "tipsLayout$delegate", "tv", "Landroid/widget/TextView;", "getTv", "()Landroid/widget/TextView;", "tv$delegate", ch.COL_USERNAME, "", "getUsername", "()Ljava/lang/String;", "username$delegate", "doSet", "", "isChecked", "initLinkText", "onCreateAfter", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "report21874", NativeProtocol.WEB_DIALOG_ACTION, "", "report21875", "eid", "actionId", "resetLoading", "showEduBottomSheet", "showWxProfileTips", "switchWxProfileSetting", "updateBottomSheetCount", "updateCount", "plugin-finder_release"})
public final class FinderProfileEduUIC extends UIComponent {
    private final kotlin.f tZk;
    private final kotlin.f tZl = kotlin.g.ah(new c(this));
    com.tencent.mm.plugin.finder.utils.b tux;
    private final kotlin.f vaP;
    private final kotlin.f vaQ;
    private final kotlin.f vaR;
    private boolean vaS;
    boolean vaT;
    private final j vaU;

    private View dms() {
        AppMethodBeat.i(250185);
        View view = (View) this.vaP.getValue();
        AppMethodBeat.o(250185);
        return view;
    }

    private TextView dmt() {
        AppMethodBeat.i(250187);
        TextView textView = (TextView) this.vaR.getValue();
        AppMethodBeat.o(250187);
        return textView;
    }

    private final String getUsername() {
        AppMethodBeat.i(250190);
        String str = (String) this.tZk.getValue();
        AppMethodBeat.o(250190);
        return str;
    }

    private final boolean isSelfFlag() {
        AppMethodBeat.i(250188);
        boolean booleanValue = ((Boolean) this.tZl.getValue()).booleanValue();
        AppMethodBeat.o(250188);
        return booleanValue;
    }

    public final CheckBox getCheckBox() {
        AppMethodBeat.i(250186);
        CheckBox checkBox = (CheckBox) this.vaQ.getValue();
        AppMethodBeat.o(250186);
        return checkBox;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke"})
    static final class b extends q implements kotlin.g.a.b<String, x> {
        final /* synthetic */ FinderProfileEduUIC vaV;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(FinderProfileEduUIC finderProfileEduUIC) {
            super(1);
            this.vaV = finderProfileEduUIC;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(String str) {
            AppMethodBeat.i(250173);
            p.h(str, LocaleUtil.ITALIAN);
            Intent intent = new Intent();
            intent.putExtra("Contact_User", z.aTY());
            intent.putExtra("CONTACT_INFO_UI_SOURCE", 22);
            com.tencent.mm.br.c.b(this.vaV.getContext(), Scopes.PROFILE, ".ui.ContactInfoUI", intent);
            com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
            com.tencent.mm.plugin.finder.report.k.b(this.vaV.getActivity(), 13, 5);
            x xVar = x.SXb;
            AppMethodBeat.o(250173);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke", "com/tencent/mm/plugin/finder/profile/uic/FinderProfileEduUIC$onCreateAfter$3$1"})
    static final class d extends q implements kotlin.g.a.b<String, x> {
        final /* synthetic */ FinderProfileEduUIC vaV;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(FinderProfileEduUIC finderProfileEduUIC) {
            super(1);
            this.vaV = finderProfileEduUIC;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(String str) {
            AppMethodBeat.i(250175);
            p.h(str, LocaleUtil.ITALIAN);
            Intent intent = new Intent();
            intent.putExtra("Contact_User", z.aTY());
            intent.putExtra("CONTACT_INFO_UI_SOURCE", 22);
            com.tencent.mm.br.c.b(this.vaV.getContext(), Scopes.PROFILE, ".ui.ContactInfoUI", intent);
            FinderProfileEduUIC.a(this.vaV, "to_profile", 0, null, 6);
            x xVar = x.SXb;
            AppMethodBeat.o(250175);
            return xVar;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderProfileEduUIC(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(250197);
        this.vaP = kotlin.g.ah(new k(appCompatActivity));
        this.vaQ = kotlin.g.ah(new a(appCompatActivity));
        this.vaR = kotlin.g.ah(new l(appCompatActivity));
        this.tZk = kotlin.g.ah(new m(appCompatActivity));
        this.vaU = new j(this, appCompatActivity);
        AppMethodBeat.o(250197);
    }

    public static final /* synthetic */ void b(FinderProfileEduUIC finderProfileEduUIC) {
        AppMethodBeat.i(250200);
        finderProfileEduUIC.nQ(true);
        AppMethodBeat.o(250200);
    }

    private final boolean isSelf() {
        AppMethodBeat.i(250189);
        boolean j2 = p.j(getUsername(), z.aUg());
        AppMethodBeat.o(250189);
        return j2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x01bb  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x01dc  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x02e7  */
    @Override // com.tencent.mm.ui.component.UIComponent
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onCreateAfter(android.os.Bundle r13) {
        /*
        // Method dump skipped, instructions count: 763
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.profile.uic.FinderProfileEduUIC.onCreateAfter(android.os.Bundle):void");
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class g implements View.OnClickListener {
        final /* synthetic */ FinderProfileEduUIC vaV;

        g(FinderProfileEduUIC finderProfileEduUIC) {
            this.vaV = finderProfileEduUIC;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(250178);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileEduUIC$onCreateAfter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.vaV.getCheckBox().toggle();
            FinderProfileEduUIC.a(this.vaV);
            FinderProfileEduUIC.dmu();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileEduUIC$onCreateAfter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(250178);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class h implements View.OnClickListener {
        final /* synthetic */ FinderProfileEduUIC vaV;

        h(FinderProfileEduUIC finderProfileEduUIC) {
            this.vaV = finderProfileEduUIC;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(250179);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileEduUIC$onCreateAfter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            FinderProfileEduUIC.a(this.vaV);
            FinderProfileEduUIC.dmu();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileEduUIC$onCreateAfter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(250179);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "onDismiss", "com/tencent/mm/plugin/finder/profile/uic/FinderProfileEduUIC$onCreateAfter$3$2"})
    static final class e implements d.a {
        final /* synthetic */ FinderProfileEduUIC vaV;

        e(FinderProfileEduUIC finderProfileEduUIC) {
            this.vaV = finderProfileEduUIC;
        }

        @Override // com.tencent.mm.plugin.finder.view.d.a
        public final void onDismiss() {
            AppMethodBeat.i(250176);
            if (!this.vaV.vaT) {
                FinderProfileEduUIC.a(this.vaV, "cancel", 0, null, 6);
            }
            AppMethodBeat.o(250176);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/profile/uic/FinderProfileEduUIC$onCreateAfter$3$3"})
    static final class f implements View.OnClickListener {
        final /* synthetic */ com.tencent.mm.plugin.finder.view.d tru;
        final /* synthetic */ FinderProfileEduUIC vaV;

        f(com.tencent.mm.plugin.finder.view.d dVar, FinderProfileEduUIC finderProfileEduUIC) {
            this.tru = dVar;
            this.vaV = finderProfileEduUIC;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(250177);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileEduUIC$onCreateAfter$$inlined$apply$lambda$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            FinderProfileEduUIC.a(this.vaV, "set", 0, null, 6);
            this.vaV.vaT = true;
            CheckBox checkBox = this.vaV.getCheckBox();
            p.g(checkBox, "checkBox");
            checkBox.setChecked(true);
            FinderProfileEduUIC.b(this.vaV);
            this.tru.bMo();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileEduUIC$onCreateAfter$$inlined$apply$lambda$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(250177);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class i implements View.OnClickListener {
        final /* synthetic */ com.tencent.mm.plugin.finder.view.d tru;

        i(com.tencent.mm.plugin.finder.view.d dVar) {
            this.tru = dVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(250180);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileEduUIC$onCreateAfter$3$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.tru.bMo();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileEduUIC$onCreateAfter$3$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(250180);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onResume() {
        AppMethodBeat.i(250192);
        super.onResume();
        CheckBox checkBox = getCheckBox();
        p.g(checkBox, "checkBox");
        y yVar = y.vXH;
        checkBox.setChecked(y.dCG());
        AppMethodBeat.o(250192);
    }

    private final void nQ(boolean z) {
        AppMethodBeat.i(250193);
        Log.i("SimpleUIComponent", "change isShowAtWxProfile, now:".concat(String.valueOf(z)));
        com.tencent.mm.plugin.finder.utils.b bVar = this.tux;
        if (bVar != null) {
            bVar.end();
        }
        b.a aVar = com.tencent.mm.plugin.finder.utils.b.vVa;
        this.tux = b.a.e(getContext(), getContext().getString(R.string.a06), 500);
        com.tencent.mm.plugin.finder.utils.b bVar2 = this.tux;
        if (bVar2 != null) {
            bVar2.begin();
        }
        ((com.tencent.mm.plugin.i.a.x) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.i.a.x.class)).a(z, this.vaU);
        AppMethodBeat.o(250193);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/finder/profile/uic/FinderProfileEduUIC$profileSettingCallback$1", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModUserInfo;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"})
    public static final class j implements ai<azg> {
        final /* synthetic */ AppCompatActivity uQi;
        final /* synthetic */ FinderProfileEduUIC vaV;

        j(FinderProfileEduUIC finderProfileEduUIC, AppCompatActivity appCompatActivity) {
            this.vaV = finderProfileEduUIC;
            this.uQi = appCompatActivity;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.protocal.protobuf.apg] */
        @Override // com.tencent.mm.plugin.i.a.ai
        public final /* synthetic */ void a(azg azg, apg apg) {
            AppMethodBeat.i(250181);
            p.h(azg, "req");
            p.h(apg, "ret");
            Log.i("SimpleUIComponent", "profileSettingCallback, " + apg.retCode);
            if (apg.retCode != 0) {
                CheckBox checkBox = this.vaV.getCheckBox();
                p.g(checkBox, "checkBox");
                com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(aj.class);
                p.g(ah, "MMKernel.plugin(IPluginFinder::class.java)");
                checkBox.setChecked(((aj) ah).getFinderSwitchApi().dCv());
                u.makeText(this.uQi, this.vaV.getString(R.string.dax), 0).show();
            }
            com.tencent.mm.plugin.finder.utils.b bVar = this.vaV.tux;
            if (bVar != null) {
                bVar.end();
                AppMethodBeat.o(250181);
                return;
            }
            AppMethodBeat.o(250181);
        }
    }

    private final void Ka(int i2) {
        String str;
        int i3 = null;
        AppMethodBeat.i(250194);
        String cMD = ((com.tencent.mm.plugin.expt.b.c) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.c.class)).cMD();
        String stringExtra = getActivity().getIntent().getStringExtra("key_context_id");
        if (stringExtra == null) {
            str = "";
        } else {
            str = stringExtra;
        }
        if (i2 == 1) {
            AppCompatActivity activity = getActivity();
            if (!(activity instanceof MMFinderUI)) {
                activity = null;
            }
            MMFinderUI mMFinderUI = (MMFinderUI) activity;
            if (mMFinderUI != null) {
                i3 = Integer.valueOf(mMFinderUI.getCommentScene());
            }
        } else {
            i3 = 78;
        }
        String valueOf = String.valueOf(System.currentTimeMillis());
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.vaS) {
                jSONObject.put("Source", 1);
            } else {
                jSONObject.put("Source", 0);
            }
        } catch (Throwable th) {
        }
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(21874, cMD, str, i3, Integer.valueOf(i2), valueOf, getUsername(), jSONObject.toString());
        AppMethodBeat.o(250194);
    }

    public static /* synthetic */ void a(FinderProfileEduUIC finderProfileEduUIC, String str, int i2, String str2, int i3) {
        AppMethodBeat.i(261275);
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        if ((i3 & 4) != 0) {
            str2 = "";
        }
        finderProfileEduUIC.R(str, i2, str2);
        AppMethodBeat.o(261275);
    }

    public final void R(String str, int i2, String str2) {
        AppMethodBeat.i(261274);
        p.h(str, "eid");
        p.h(str2, "actionId");
        String cMD = ((com.tencent.mm.plugin.expt.b.c) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.c.class)).cMD();
        String stringExtra = getActivity().getIntent().getStringExtra("key_context_id");
        if (stringExtra == null) {
            stringExtra = "";
        }
        String valueOf = String.valueOf(System.currentTimeMillis());
        JSONObject jSONObject = new JSONObject();
        try {
            if (p.j(str, "mv") || p.j(str, "mvdelete")) {
                jSONObject.put("feedid", str2);
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(21875, cMD, stringExtra, 78, Integer.valueOf(i2), valueOf, str, jSONObject.toString());
                AppMethodBeat.o(261274);
            }
            if (p.j(str, "draft") || p.j(str, "draftdelete")) {
                jSONObject.put("draftid", str2);
            }
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(21875, cMD, stringExtra, 78, Integer.valueOf(i2), valueOf, str, jSONObject.toString());
            AppMethodBeat.o(261274);
        } catch (Throwable th) {
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
    static final class k extends q implements kotlin.g.a.a<View> {
        final /* synthetic */ AppCompatActivity uQi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(AppCompatActivity appCompatActivity) {
            super(0);
            this.uQi = appCompatActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ View invoke() {
            AppMethodBeat.i(250182);
            View findViewById = this.uQi.findViewById(R.id.by5);
            AppMethodBeat.o(250182);
            return findViewById;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/CheckBox;", "kotlin.jvm.PlatformType", "invoke"})
    static final class a extends q implements kotlin.g.a.a<CheckBox> {
        final /* synthetic */ AppCompatActivity uQi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(AppCompatActivity appCompatActivity) {
            super(0);
            this.uQi = appCompatActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ CheckBox invoke() {
            AppMethodBeat.i(250172);
            CheckBox checkBox = (CheckBox) this.uQi.findViewById(R.id.by6);
            AppMethodBeat.o(250172);
            return checkBox;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class l extends q implements kotlin.g.a.a<TextView> {
        final /* synthetic */ AppCompatActivity uQi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(AppCompatActivity appCompatActivity) {
            super(0);
            this.uQi = appCompatActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ TextView invoke() {
            AppMethodBeat.i(250183);
            TextView textView = (TextView) this.uQi.findViewById(R.id.by7);
            AppMethodBeat.o(250183);
            return textView;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class c extends q implements kotlin.g.a.a<Boolean> {
        final /* synthetic */ FinderProfileEduUIC vaV;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(FinderProfileEduUIC finderProfileEduUIC) {
            super(0);
            this.vaV = finderProfileEduUIC;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Boolean invoke() {
            AppMethodBeat.i(250174);
            Boolean valueOf = Boolean.valueOf(this.vaV.getIntent().getBooleanExtra("KEY_FINDER_SELF_FLAG", false));
            AppMethodBeat.o(250174);
            return valueOf;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "", "kotlin.jvm.PlatformType", "invoke"})
    static final class m extends q implements kotlin.g.a.a<String> {
        final /* synthetic */ AppCompatActivity uQi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        m(AppCompatActivity appCompatActivity) {
            super(0);
            this.uQi = appCompatActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ String invoke() {
            AppMethodBeat.i(250184);
            String stringExtra = this.uQi.getIntent().getStringExtra("finder_username");
            AppMethodBeat.o(250184);
            return stringExtra;
        }
    }

    public static final /* synthetic */ void a(FinderProfileEduUIC finderProfileEduUIC) {
        AppMethodBeat.i(250198);
        com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
        com.tencent.mm.plugin.finder.report.k.b(finderProfileEduUIC.getActivity(), 13, 1);
        CheckBox checkBox = finderProfileEduUIC.getCheckBox();
        p.g(checkBox, "checkBox");
        boolean isChecked = checkBox.isChecked();
        y yVar = y.vXH;
        if (isChecked != y.dCG()) {
            finderProfileEduUIC.nQ(isChecked);
        }
        AppMethodBeat.o(250198);
    }

    public static final /* synthetic */ void dmu() {
        AppMethodBeat.i(250199);
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        p.g(aAh, "MMKernel.storage()");
        aAh.azQ().set(ar.a.USERINFO_FINDER_WXPROFILE_ENTRY_EDU_INT_SYNC, (Object) 1);
        AppMethodBeat.o(250199);
    }
}
