package com.tencent.mm.plugin.clean.ui;

import android.content.Intent;
import android.content.pm.Signature;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.b.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.clean.ui.fileindexui.CleanNewUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore;
import org.json.JSONException;
import org.json.JSONObject;

@a(19)
public class CleanUI extends MMActivity {
    private static final String qpO = (HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e2m) + "/cgi-bin/readtemplate?t=w_safe&qqpimenter=shoushen");
    private long qpP;
    private String qpQ = "com.tencent.qqpimsecure";
    private String qpR = "00B1208638DE0FCD3E920886D658DAF6";
    private String qpS = "11206657";
    private JSONObject qpT;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static {
        AppMethodBeat.i(231659);
        AppMethodBeat.o(231659);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(22840);
        super.onCreate(bundle);
        if (!getIntent().getBooleanExtra("had_detected_no_sdcard_space", false) || !cyQ()) {
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent(this, CleanNewUI.class));
            com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/clean/ui/CleanUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/clean/ui/CleanUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            finish();
            AppMethodBeat.o(22840);
            return;
        }
        finish();
        AppMethodBeat.o(22840);
    }

    private boolean cyQ() {
        String messageDigest;
        AppMethodBeat.i(22841);
        cyR();
        if (!q.s(getContext(), this.qpQ)) {
            AppMethodBeat.o(22841);
            return false;
        }
        Signature[] cj = q.cj(this, this.qpQ);
        if (cj == null || cj[0] == null || (messageDigest = g.getMessageDigest(cj[0].toByteArray())) == null || !messageDigest.equalsIgnoreCase(this.qpR)) {
            AppMethodBeat.o(22841);
            return false;
        }
        try {
            Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(this.qpQ);
            if (launchIntentForPackage != null) {
                Bundle bundle = new Bundle();
                q.k(bundle, this.qpS);
                launchIntentForPackage.putExtras(bundle);
                launchIntentForPackage.addFlags(268435456);
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(launchIntentForPackage);
                com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/clean/ui/CleanUI", "jumpToQQMgrApp", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/clean/ui/CleanUI", "jumpToQQMgrApp", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                h.INSTANCE.idkeyStat(282, 6, 1, false);
                AppMethodBeat.o(22841);
                return true;
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.CleanUI", e2, "", new Object[0]);
        }
        AppMethodBeat.o(22841);
        return true;
    }

    private boolean cyR() {
        AppMethodBeat.i(22842);
        bg.aVF();
        String str = (String) c.azQ().get(ar.a.USERINFO_CLEANUI_QQMGRINFO_STRING, "");
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(22842);
            return false;
        }
        try {
            this.qpT = new JSONObject(str);
            this.qpQ = this.qpT.getString(AssistantStore.DownloadInfos.DownloadInfoColumns.PACKAGENAME);
            this.qpT.get("md5");
            this.qpS = this.qpT.getString("launcherID");
            this.qpR = this.qpT.getString("signature");
            this.qpT.get("url");
            this.qpP = this.qpT.getLong("size");
            AppMethodBeat.o(22842);
            return true;
        } catch (JSONException e2) {
            Log.printErrStackTrace("MicroMsg.CleanUI", e2, "", new Object[0]);
            AppMethodBeat.o(22842);
            return false;
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.ur;
    }
}
