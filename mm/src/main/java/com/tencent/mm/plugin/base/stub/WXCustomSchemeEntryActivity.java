package com.tencent.mm.plugin.base.stub;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.pluginsdk.g;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@JgClassChecked(author = 50, fComment = "checked", lastDate = "20141016", reviewer = 50, vComment = {EType.ACTIVITYCHECK})
public class WXCustomSchemeEntryActivity extends AutoLoginActivity {
    private List<String> pex;

    @Override // com.tencent.mm.pluginsdk.ui.AutoLoginActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.pluginsdk.ui.AutoLoginActivity, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(22269);
        Log.i("MicroMsg.WXCustomSchemeEntryActivity", "onCreate");
        this.pex = new ArrayList();
        this.pex.add("cardpackage");
        this.pex.add("connectToFreeWifi");
        this.pex.add("wap");
        super.onCreate(bundle);
        setTitleVisibility(0);
        AppMethodBeat.o(22269);
    }

    @Override // com.tencent.mm.pluginsdk.ui.AutoLoginActivity, com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.jm;
    }

    @Override // com.tencent.mm.pluginsdk.ui.AutoLoginActivity
    public final boolean ab(Intent intent) {
        AppMethodBeat.i(22270);
        Uri uri = null;
        try {
            uri = getIntent().getData();
        } catch (Exception e2) {
            Log.e("MicroMsg.WXCustomSchemeEntryActivity", "get url from intent failed : %s", e2.getMessage());
        }
        Uri parse = Uri.parse(g.bcY(uri.toString()));
        if (parse != null) {
            if (g.bcZ(parse.toString())) {
                AppMethodBeat.o(22270);
                return true;
            }
            String scheme = parse.getScheme();
            String host = parse.getHost();
            String query = parse.getQuery();
            Log.i("MicroMsg.WXCustomSchemeEntryActivity", "uri is %s,scheme is %s, host is %s, query is %s", parse.toString(), scheme, host, query);
            if (!Util.isNullOrNil(host) && this.pex.contains(host)) {
                Log.i("MicroMsg.WXCustomSchemeEntryActivity", "match the host : %s", host);
                if (host.equals("cardpackage")) {
                    String queryParameter = parse.getQueryParameter("encrystr");
                    Log.i("MicroMsg.WXCustomSchemeEntryActivity", "card encrypt value = %s", queryParameter);
                    if (!Util.isNullOrNil(queryParameter) && queryParameter.length() < 1024) {
                        AppMethodBeat.o(22270);
                        return true;
                    }
                }
                if (host.equals("connectToFreeWifi")) {
                    if (!Util.isNullOrNil(query) && query.startsWith("apKey=") && query.length() > 6) {
                        String substring = query.substring(6);
                        Log.i("MicroMsg.WXCustomSchemeEntryActivity", "apKey value = %s", substring);
                        if (!Util.isNullOrNil(substring) && substring.length() < 1024) {
                            AppMethodBeat.o(22270);
                            return true;
                        }
                    } else if (parse.toString().startsWith("weixin://connectToFreeWifi/friendWifi")) {
                        AppMethodBeat.o(22270);
                        return true;
                    }
                }
                if (host.equals("wap") && parse.toString().startsWith("weixin://wap/pay")) {
                    Log.i("MicroMsg.WXCustomSchemeEntryActivity", "preLogin for WX_WAP_PAY");
                    AppMethodBeat.o(22270);
                    return true;
                }
            }
        }
        finish();
        AppMethodBeat.o(22270);
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x016e  */
    @Override // com.tencent.mm.pluginsdk.ui.AutoLoginActivity
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.tencent.mm.pluginsdk.ui.AutoLoginActivity.a r14, android.content.Intent r15) {
        /*
        // Method dump skipped, instructions count: 1004
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.base.stub.WXCustomSchemeEntryActivity.a(com.tencent.mm.pluginsdk.ui.AutoLoginActivity$a, android.content.Intent):void");
    }

    private String ckg() {
        AppMethodBeat.i(22272);
        if (d.oF(21)) {
            try {
                Field declaredField = Class.forName("android.app.Activity").getDeclaredField("mReferrer");
                declaredField.setAccessible(true);
                String str = (String) declaredField.get(this);
                AppMethodBeat.o(22272);
                return str;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.WXCustomSchemeEntryActivity", e2, "", new Object[0]);
                AppMethodBeat.o(22272);
                return "No referrer";
            }
        } else {
            AppMethodBeat.o(22272);
            return "";
        }
    }
}
