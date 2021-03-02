package com.tencent.mm.plugin.updater.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ac.d;
import com.tencent.mm.protocal.protobuf.eht;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.report.MMSecDataActivity;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\bJ\b\u0010\n\u001a\u00020\u000bH\u0014J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0004H\u0002¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/updater/ui/AutoUpdateDialogSettingUI;", "Lcom/tencent/mm/ui/report/MMSecDataActivity;", "()V", "getApkMd5", "", "file", "getCurrentApkMD5", "context", "Landroid/content/Context;", "getCurrentApkPath", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "saveDialogData", "clientVersionStr", "plugin-updater_release"})
public final class AutoUpdateDialogSettingUI extends MMSecDataActivity {
    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(194771);
        super.onCreate(bundle);
        setMMTitle(R.string.a4r);
        setBackBtn(new a(this));
        findViewById(R.id.g3k).setOnClickListener(new b(this));
        AppMethodBeat.o(194771);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class a implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ AutoUpdateDialogSettingUI GwM;

        a(AutoUpdateDialogSettingUI autoUpdateDialogSettingUI) {
            this.GwM = autoUpdateDialogSettingUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(194767);
            this.GwM.finish();
            AppMethodBeat.o(194767);
            return false;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b implements View.OnClickListener {
        final /* synthetic */ AutoUpdateDialogSettingUI GwM;

        b(AutoUpdateDialogSettingUI autoUpdateDialogSettingUI) {
            this.GwM = autoUpdateDialogSettingUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(194770);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/updater/ui/AutoUpdateDialogSettingUI$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            View findViewById = this.GwM.findViewById(R.id.b3s);
            p.g(findViewById, "findViewById<EditText>(R.id.client_version_et)");
            final String obj = ((EditText) findViewById).getText().toString();
            String str = obj;
            if (!(str == null || str.length() == 0)) {
                d.i(new kotlin.g.a.a<x>(this) {
                    /* class com.tencent.mm.plugin.updater.ui.AutoUpdateDialogSettingUI.b.AnonymousClass1 */
                    final /* synthetic */ b GwN;

                    {
                        this.GwN = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.g.a.a
                    public final /* synthetic */ x invoke() {
                        AppMethodBeat.i(194769);
                        MMApplicationContext.getContext();
                        com.tencent.mm.plugin.hp.d.d.dZA();
                        AutoUpdateDialogSettingUI.a(this.GwN.GwM, obj);
                        d.h(new kotlin.g.a.a<x>(this) {
                            /* class com.tencent.mm.plugin.updater.ui.AutoUpdateDialogSettingUI.b.AnonymousClass1.AnonymousClass1 */
                            final /* synthetic */ AnonymousClass1 GwP;

                            {
                                this.GwP = r2;
                            }

                            /* Return type fixed from 'java.lang.Object' to match base method */
                            @Override // kotlin.g.a.a
                            public final /* synthetic */ x invoke() {
                                AppMethodBeat.i(194768);
                                u.makeText(this.GwP.GwN.GwM.getContext(), this.GwP.GwN.GwM.getString(R.string.wo), 0).show();
                                x xVar = x.SXb;
                                AppMethodBeat.o(194768);
                                return xVar;
                            }
                        });
                        x xVar = x.SXb;
                        AppMethodBeat.o(194769);
                        return xVar;
                    }
                });
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/updater/ui/AutoUpdateDialogSettingUI$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(194770);
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.hh;
    }

    private static String gp(Context context) {
        String str;
        AppMethodBeat.i(194772);
        p.h(context, "context");
        try {
            str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.sourceDir;
        } catch (Exception e2) {
            str = null;
        }
        AppMethodBeat.o(194772);
        return str;
    }

    public static final /* synthetic */ void a(AutoUpdateDialogSettingUI autoUpdateDialogSettingUI, String str) {
        String str2;
        AppMethodBeat.i(194773);
        eht eht = new eht();
        eht.cri = "";
        eht.title = autoUpdateDialogSettingUI.getContext().getString(R.string.dgd);
        eht.Nhk = autoUpdateDialogSettingUI.getContext().getString(R.string.e3o);
        eht.xWM = autoUpdateDialogSettingUI.getContext().getString(R.string.hsi);
        eht.ynv = "";
        AutoUpdateDialogSettingUI autoUpdateDialogSettingUI2 = autoUpdateDialogSettingUI;
        p.h(autoUpdateDialogSettingUI2, "context");
        String gp = gp(autoUpdateDialogSettingUI2);
        if (gp == null || !new o(gp).exists()) {
            str2 = null;
        } else {
            com.tencent.mm.d.a fO = com.tencent.mm.d.a.fO(gp);
            if (fO == null || fO.djf == null) {
                str2 = s.bhK(gp);
            } else {
                str2 = fO.djf.apkMd5;
            }
        }
        eht.ynw = str2;
        eht.nJK = 0;
        eht.pkK = "";
        eht.patchMd5 = "";
        eht.versionCode = 0;
        eht.Nhj = "";
        try {
            eht.Nhl = com.tencent.mm.plugin.hp.d.d.aBM(str);
        } catch (Exception e2) {
        }
        eht.msg = "";
        com.tencent.mm.plugin.hp.d.d.a(eht);
        AppMethodBeat.o(194773);
    }
}
