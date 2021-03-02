package com.tencent.mm.plugin.finder.viewmodel.component;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.api.g;
import com.tencent.mm.plugin.finder.report.d;
import com.tencent.mm.plugin.finder.report.live.m;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.pluginsdk.i.f;
import com.tencent.mm.protocal.protobuf.awg;
import com.tencent.mm.protocal.protobuf.awi;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.sqlitelint.util.SQLiteLintUtil;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderLiveLotteryDetailUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "plugin-finder_release"})
public final class FinderLiveLotteryDetailUIC extends UIComponent {
    public static final a wyd = new a((byte) 0);

    static {
        AppMethodBeat.i(255758);
        AppMethodBeat.o(255758);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderLiveLotteryDetailUIC$Companion;", "", "()V", "KEY_LOTTERY_HISTORY_DETAIL_INFO", "", "TAG", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderLiveLotteryDetailUIC(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(255757);
        AppMethodBeat.o(255757);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final int getLayoutId() {
        return R.layout.aee;
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onCreate(Bundle bundle) {
        awi awi;
        String string;
        TextView textView;
        String str;
        String str2;
        boolean z;
        String string2;
        bbn bbn = null;
        AppMethodBeat.i(255756);
        super.onCreate(bundle);
        AppCompatActivity activity = getActivity();
        if (activity == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(255756);
            throw tVar;
        }
        MMActivity mMActivity = (MMActivity) activity;
        mMActivity.setMMTitle(R.string.cx7);
        mMActivity.setBackBtn(new c(mMActivity));
        String stringExtra = getActivity().getIntent().getStringExtra("KEY_LIVE_ANCHOR_USERNAME");
        byte[] byteArrayExtra = getActivity().getIntent().getByteArrayExtra("KEY_LOTTERY_HISTORY_INFO");
        if (byteArrayExtra != null) {
            awi awi2 = new awi();
            try {
                awi2.parseFrom(byteArrayExtra);
            } catch (Throwable th) {
                Log.e("FinderLiveLotteryDetailUIC", "onCreate: lottery info parse errpr", th);
                awi2 = null;
            }
            awi = awi2;
        } else {
            awi = null;
        }
        if (awi != null) {
            c.a aVar = com.tencent.mm.plugin.finder.api.c.tsp;
            g asG = c.a.asG(stringExtra);
            String string3 = getActivity().getResources().getString(R.string.cvf);
            p.g(string3, "activity.resources.getSt…ery_history_detail_title)");
            if (asG != null) {
                string3 = string3 + "·" + asG.getNickname();
            }
            TextView textView2 = (TextView) getActivity().findViewById(R.id.eti);
            p.g(textView2, "activity.lottery_detail_title");
            textView2.setText(string3);
            String str3 = awi.description;
            if (str3 == null || str3.length() == 0) {
                LinearLayout linearLayout = (LinearLayout) getActivity().findViewById(R.id.etd);
                p.g(linearLayout, "activity.lottery_detail_item_container");
                linearLayout.setVisibility(8);
            } else {
                LinearLayout linearLayout2 = (LinearLayout) getActivity().findViewById(R.id.etd);
                p.g(linearLayout2, "activity.lottery_detail_item_container");
                linearLayout2.setVisibility(0);
            }
            TextView textView3 = (TextView) getActivity().findViewById(R.id.etf);
            p.g(textView3, "activity.lottery_detail_item_desc");
            textView3.setText(awi.description);
            TextView textView4 = (TextView) getActivity().findViewById(R.id.eth);
            p.g(textView4, "activity.lottery_detail_item_type");
            awg awg = awi.LGn;
            if (awg == null || awg.LGY != 1) {
                string = getActivity().getResources().getString(R.string.cvn);
                textView = textView4;
            } else {
                awg awg2 = awi.LGn;
                if (!(awg2 == null || (str2 = awg2.LGZ) == null)) {
                    p.g(str2, LocaleUtil.ITALIAN);
                    if (str2.length() > 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        str2 = null;
                    }
                    if (!(str2 == null || (string2 = getActivity().getResources().getString(R.string.cv2, str2)) == null)) {
                        string = string2;
                        textView = textView4;
                    }
                }
                string = getActivity().getResources().getString(R.string.cvl);
                textView = textView4;
            }
            textView.setText(string);
            TextView textView5 = (TextView) getActivity().findViewById(R.id.ete);
            p.g(textView5, "activity.lottery_detail_item_count");
            textView5.setText(getActivity().getResources().getString(R.string.cv_, Integer.valueOf(awi.ugF)));
            TextView textView6 = (TextView) getActivity().findViewById(R.id.etg);
            p.g(textView6, "activity.lottery_detail_item_time");
            textView6.setText(f.formatTime(SQLiteLintUtil.YYYY_MM_DD_HH_mm, (long) awi.iqg));
            FinderReporterUIC.a aVar2 = FinderReporterUIC.wzC;
            AppCompatActivity activity2 = getActivity();
            if (activity2 == null) {
                t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                AppMethodBeat.o(255756);
                throw tVar2;
            }
            FinderReporterUIC fH = FinderReporterUIC.a.fH((MMActivity) activity2);
            if (fH != null) {
                bbn = fH.dIx();
            }
            d dVar = d.vdp;
            d.b dnK = d.dnK();
            String aUg = z.aUg();
            p.g(aUg, "ConfigStorageLogic.getMyFinderUsername()");
            if (stringExtra == null) {
                str = "";
            } else {
                str = stringExtra;
            }
            dnK.ah(aUg, "", str);
            d dVar2 = d.vdp;
            d.dnK().a(bbn, 4);
            ((LinearLayout) getActivity().findViewById(R.id.etn)).setOnClickListener(new b(bbn, this, stringExtra, awi));
            AppMethodBeat.o(255756);
            return;
        }
        getActivity().finish();
        AppMethodBeat.o(255756);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class c implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ MMActivity wyh;

        c(MMActivity mMActivity) {
            this.wyh = mMActivity;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(255755);
            this.wyh.finish();
            AppMethodBeat.o(255755);
            return true;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/viewmodel/component/FinderLiveLotteryDetailUIC$onCreate$2$5"})
    static final class b implements View.OnClickListener {
        final /* synthetic */ bbn $contextObj;
        final /* synthetic */ FinderLiveLotteryDetailUIC wye;
        final /* synthetic */ String wyf;
        final /* synthetic */ awi wyg;

        b(bbn bbn, FinderLiveLotteryDetailUIC finderLiveLotteryDetailUIC, String str, awi awi) {
            this.$contextObj = bbn;
            this.wye = finderLiveLotteryDetailUIC;
            this.wyf = str;
            this.wyg = awi;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(255754);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderLiveLotteryDetailUIC$onCreate$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
            com.tencent.mm.plugin.finder.utils.a.a(this.wye.getActivity(), this.wyf, this.$contextObj);
            m.vli.a(s.ay.CLICK_WIN_DETAIL_ENTER_PRIVATE_UI, "");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderLiveLotteryDetailUIC$onCreate$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(255754);
        }
    }
}
