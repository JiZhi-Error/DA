package com.tencent.mm.plugin.exdevice.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.q;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.protocal.protobuf.bxc;
import com.tencent.mm.protocal.protobuf.ecf;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u001c\u001dB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u001e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u0006R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\n¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/plugin/exdevice/ui/SportProfileUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "appName", "", "getAppName", "()Ljava/lang/String;", "setAppName", "(Ljava/lang/String;)V", "profileData", "Lcom/tencent/mm/protocal/protobuf/GetUserRankDetailResponse;", "getProfileData", "()Lcom/tencent/mm/protocal/protobuf/GetUserRankDetailResponse;", "setProfileData", "(Lcom/tencent/mm/protocal/protobuf/GetUserRankDetailResponse;)V", "rankId", "getRankId", "setRankId", "inflateItemView", "Landroid/view/View;", "viewType", "", "updateItemView", "", "itemView", ch.COL_USERNAME, "OtherBtnViewHolder", "ProfileViewHolder", "app_release"})
public final class SportProfileUIC extends UIComponent {
    String appName;
    String rCB;
    public bxc rMR;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SportProfileUIC(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(230647);
        AppMethodBeat.o(230647);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class d implements View.OnClickListener {
        final /* synthetic */ SportProfileUIC rMU;

        d(SportProfileUIC sportProfileUIC) {
            this.rMU = sportProfileUIC;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(230639);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/SportProfileUIC$updateItemView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.plugin.sport.a.c.pl(8);
            AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
            appBrandStatObject.scene = 1063;
            ((r) com.tencent.mm.kernel.g.af(r.class)).a(this.rMU.getActivity(), (String) null, "wx3fca79fc5715b185", 0, 0, "", appBrandStatObject);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/SportProfileUIC$updateItemView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(230639);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class f implements View.OnClickListener {
        final /* synthetic */ SportProfileUIC rMU;

        f(SportProfileUIC sportProfileUIC) {
            this.rMU = sportProfileUIC;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(230641);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/SportProfileUIC$updateItemView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Intent intent = new Intent(this.rMU.getActivity(), ExdeviceFollowsUI.class);
            AppCompatActivity activity = this.rMU.getActivity();
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/plugin/exdevice/ui/SportProfileUIC$updateItemView$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            activity.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/plugin/exdevice/ui/SportProfileUIC$updateItemView$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/SportProfileUIC$updateItemView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(230641);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class g implements View.OnClickListener {
        final /* synthetic */ SportProfileUIC rMU;

        g(SportProfileUIC sportProfileUIC) {
            this.rMU = sportProfileUIC;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(230642);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/SportProfileUIC$updateItemView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (!Util.isNullOrNil(this.rMU.rCB) && (!p.j("#", this.rMU.rCB))) {
                Intent intent = new Intent(this.rMU.getActivity(), ExdeviceLikeUI.class);
                String str = this.rMU.appName;
                if (str == null) {
                    str = "";
                }
                intent.putExtra("app_username", str);
                String str2 = this.rMU.rCB;
                if (str2 == null) {
                    str2 = "";
                }
                intent.putExtra("rank_id", str2);
                intent.putExtra("key_is_like_read_only", true);
                AppCompatActivity activity = this.rMU.getActivity();
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/plugin/exdevice/ui/SportProfileUIC$updateItemView$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                activity.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/plugin/exdevice/ui/SportProfileUIC$updateItemView$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/SportProfileUIC$updateItemView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(230642);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "info", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "kotlin.jvm.PlatformType", "onGetWeAppInfo"})
    static final class h implements q.a {
        final /* synthetic */ z.f qhQ;
        final /* synthetic */ ImageView rMO;

        h(z.f fVar, ImageView imageView) {
            this.qhQ = fVar;
            this.rMO = imageView;
        }

        @Override // com.tencent.mm.plugin.appbrand.service.q.a
        public final void b(WxaAttributes wxaAttributes) {
            AppMethodBeat.i(230644);
            if (wxaAttributes != null) {
                com.tencent.f.h.RTc.aV(new a(wxaAttributes, this));
                AppMethodBeat.o(230644);
                return;
            }
            AppMethodBeat.o(230644);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/exdevice/ui/SportProfileUIC$updateItemView$7$1$1$1"})
        static final class a implements Runnable {
            final /* synthetic */ WxaAttributes rMP;
            final /* synthetic */ h rNf;

            a(WxaAttributes wxaAttributes, h hVar) {
                this.rMP = wxaAttributes;
                this.rNf = hVar;
            }

            public final void run() {
                AppMethodBeat.i(230643);
                View findViewById = this.rNf.qhQ.SYG.findViewById(R.id.t7);
                p.g(findViewById, "view.findViewById<TextView>(R.id.appbrand_name_tv)");
                ((TextView) findViewById).setText(this.rMP.field_nickname);
                com.tencent.mm.av.q.bcV().a(this.rMP.field_smallHeadURL, this.rNf.rMO, new c.a().bdt().bdq().bdv());
                AppMethodBeat.o(230643);
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/exdevice/ui/SportProfileUIC$updateItemView$7$2"})
    static final class c implements View.OnClickListener {
        final /* synthetic */ ecf rMI;
        final /* synthetic */ SportProfileUIC rMU;
        final /* synthetic */ z.f rNc;

        c(ecf ecf, SportProfileUIC sportProfileUIC, z.f fVar) {
            this.rMI = ecf;
            this.rMU = sportProfileUIC;
            this.rNc = fVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(230638);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/SportProfileUIC$updateItemView$$inlined$forEach$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            ((q) com.tencent.mm.kernel.g.af(q.class)).b(this.rMI.appId, new q.a(this) {
                /* class com.tencent.mm.plugin.exdevice.ui.SportProfileUIC.c.AnonymousClass1 */
                final /* synthetic */ c rNd;

                {
                    this.rNd = r1;
                }

                @Override // com.tencent.mm.plugin.appbrand.service.q.a
                public final void b(final WxaAttributes wxaAttributes) {
                    AppMethodBeat.i(230637);
                    if (wxaAttributes != null) {
                        f.a aVar = new f.a(MMApplicationContext.getContext());
                        aVar.bow(this.rNd.rMU.getActivity().getString(R.string.hq6, new Object[]{wxaAttributes.field_nickname})).Dq(true);
                        aVar.apa(R.string.h4);
                        aVar.c(new f.c() {
                            /* class com.tencent.mm.plugin.exdevice.ui.SportProfileUIC.c.AnonymousClass1.AnonymousClass1 */

                            @Override // com.tencent.mm.ui.widget.a.f.c
                            public final void e(boolean z, String str) {
                                AppMethodBeat.i(230636);
                                if (z) {
                                    wq wqVar = new wq();
                                    wqVar.ecI.userName = wxaAttributes.field_username;
                                    wqVar.ecI.ecK = this.rNd.rMI.Ncv;
                                    wqVar.ecI.scene = 1171;
                                    EventCenter.instance.publish(wqVar);
                                }
                                AppMethodBeat.o(230636);
                            }
                        }).show();
                        AppMethodBeat.o(230637);
                        return;
                    }
                    AppMethodBeat.o(230637);
                }
            });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/SportProfileUIC$updateItemView$$inlined$forEach$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(230638);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class i implements View.OnClickListener {
        final /* synthetic */ String hLl;
        final /* synthetic */ SportProfileUIC rMU;

        i(SportProfileUIC sportProfileUIC, String str) {
            this.rMU = sportProfileUIC;
            this.hLl = str;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(230645);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/SportProfileUIC$updateItemView$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Intent intent = new Intent(this.rMU.getActivity(), SportHistoryUI.class);
            intent.putExtra(ch.COL_USERNAME, this.hLl);
            AppCompatActivity activity = this.rMU.getActivity();
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/plugin/exdevice/ui/SportProfileUIC$updateItemView$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            activity.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/plugin/exdevice/ui/SportProfileUIC$updateItemView$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/SportProfileUIC$updateItemView$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(230645);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class j implements View.OnClickListener {
        final /* synthetic */ String hLl;
        final /* synthetic */ SportProfileUIC rMU;

        j(SportProfileUIC sportProfileUIC, String str) {
            this.rMU = sportProfileUIC;
            this.hLl = str;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(230646);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/SportProfileUIC$updateItemView$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Intent intent = new Intent();
            intent.putExtra("Contact_User", this.hLl);
            com.tencent.mm.br.c.b(this.rMU.getActivity(), Scopes.PROFILE, ".ui.ContactInfoUI", intent);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/SportProfileUIC$updateItemView$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(230646);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class e implements View.OnClickListener {
        final /* synthetic */ SportProfileUIC rMU;

        e(SportProfileUIC sportProfileUIC) {
            this.rMU = sportProfileUIC;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(230640);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/SportProfileUIC$updateItemView$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (this.rMU.getActivity() instanceof ExdeviceProfileUI) {
                AppCompatActivity activity = this.rMU.getActivity();
                if (activity == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI");
                    AppMethodBeat.o(230640);
                    throw tVar;
                }
                ((ExdeviceProfileUI) activity).cLP();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/SportProfileUIC$updateItemView$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(230640);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010'\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR\u001c\u0010*\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010$\"\u0004\b,\u0010&¨\u0006-"}, hxF = {"Lcom/tencent/mm/plugin/exdevice/ui/SportProfileUIC$ProfileViewHolder;", "", "(Lcom/tencent/mm/plugin/exdevice/ui/SportProfileUIC;)V", "addFollowTV", "Landroid/widget/TextView;", "getAddFollowTV", "()Landroid/widget/TextView;", "setAddFollowTV", "(Landroid/widget/TextView;)V", "likeIcon", "Landroid/widget/ImageView;", "getLikeIcon", "()Landroid/widget/ImageView;", "setLikeIcon", "(Landroid/widget/ImageView;)V", "mAvatarIv", "getMAvatarIv", "setMAvatarIv", "mDateTv", "getMDateTv", "setMDateTv", "mLikeCountTv", "getMLikeCountTv", "setMLikeCountTv", "mNickNameTv", "getMNickNameTv", "setMNickNameTv", "mSportLayout", "Landroid/widget/LinearLayout;", "getMSportLayout", "()Landroid/widget/LinearLayout;", "setMSportLayout", "(Landroid/widget/LinearLayout;)V", "mSportLayoutDivider", "Landroid/view/View;", "getMSportLayoutDivider", "()Landroid/view/View;", "setMSportLayoutDivider", "(Landroid/view/View;)V", "mStepTv", "getMStepTv", "setMStepTv", "todayLayout", "getTodayLayout", "setTodayLayout", "app_release"})
    public final class b {
        TextView qpf;
        ImageView qyu;
        TextView rIw;
        TextView rMV;
        TextView rMW;
        LinearLayout rMX;
        View rMY;
        View rMZ;
        ImageView rNa;
        TextView rNb;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public b() {
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/exdevice/ui/SportProfileUIC$OtherBtnViewHolder;", "", "(Lcom/tencent/mm/plugin/exdevice/ui/SportProfileUIC;)V", "donateBtn", "Landroid/view/View;", "getDonateBtn", "()Landroid/view/View;", "setDonateBtn", "(Landroid/view/View;)V", "followBtn", "getFollowBtn", "setFollowBtn", "app_release"})
    public final class a {
        View rMS;
        View rMT;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public a() {
        }
    }
}
