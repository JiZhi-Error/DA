package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.webkit.ValueCallback;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.q;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.a.iv;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelstat.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.smtt.sdk.QbSdk;
import java.util.HashMap;

@a(2)
public class WebViewDownloadWithX5UI extends MMActivity {
    private Button JfK;
    private final com.tencent.mm.plugin.webview.modeltools.a JfY = new com.tencent.mm.plugin.webview.modeltools.a();
    private Context mContext;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WebViewDownloadWithX5UI() {
        AppMethodBeat.i(79828);
        AppMethodBeat.o(79828);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(79829);
        super.onCreate(bundle);
        this.mContext = this;
        setMMTitle(getString(R.string.iyw));
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.webview.ui.tools.WebViewDownloadWithX5UI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(79823);
                WebViewDownloadWithX5UI.this.finish();
                AppMethodBeat.o(79823);
                return true;
            }
        });
        overridePendingTransition(MMFragmentActivity.a.ogm, MMFragmentActivity.a.ogn);
        this.JfK = (Button) findViewById(R.id.bu9);
        ImageView imageView = (ImageView) findViewById(R.id.bun);
        TextView textView = (TextView) findViewById(R.id.bup);
        final String stringExtra = getIntent().getStringExtra("task_url");
        String stringExtra2 = getIntent().getStringExtra("title");
        final long longExtra = getIntent().getLongExtra("task_size", 0);
        final String stringExtra3 = getIntent().getStringExtra("page_url");
        String stringExtra4 = getIntent().getStringExtra("thumb_url");
        Log.i("MicroMsg.WebViewDownloadWithX5UI", "onCreate: url=%s,taskSize=%d, thumbUrl=%s", stringExtra, Long.valueOf(longExtra), stringExtra4);
        if (longExtra > 0) {
            String sizeMB = Util.getSizeMB(longExtra);
            this.JfK.setText(getString(R.string.iyn, new Object[]{sizeMB}));
        }
        if (g.aAc()) {
            com.tencent.mm.av.a.a bcV = q.bcV();
            c.a aVar = new c.a();
            aVar.jbq = R.raw.webview_download_thumb_unknown;
            aVar.jbf = true;
            bcV.a(stringExtra4, imageView, aVar.bdv());
        } else {
            imageView.setImageResource(R.raw.webview_download_thumb_unknown);
        }
        textView.setVisibility(0);
        if (!Util.isNullOrNil(stringExtra2)) {
            textView.setText(stringExtra2);
        } else {
            textView.setText(getString(R.string.iyv));
        }
        h.INSTANCE.a(14217, "", 1, stringExtra3, stringExtra, 1);
        this.JfK.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.webview.ui.tools.WebViewDownloadWithX5UI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(79826);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/WebViewDownloadWithX5UI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (!NetStatusUtil.isNetworkConnected(WebViewDownloadWithX5UI.this.mContext)) {
                    Toast.makeText(WebViewDownloadWithX5UI.this.mContext, WebViewDownloadWithX5UI.this.getString(R.string.dom), 0).show();
                    Log.i("MicroMsg.WebViewDownloadWithX5UI", "startDownload fail, network not ready");
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/WebViewDownloadWithX5UI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(79826);
                } else if (!g.aAh().isSDCardAvailable()) {
                    Toast.makeText(WebViewDownloadWithX5UI.this.mContext, WebViewDownloadWithX5UI.this.getString(R.string.doq), 0).show();
                    Log.i("MicroMsg.WebViewDownloadWithX5UI", "startDownload fail, sdcard not ready");
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/WebViewDownloadWithX5UI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(79826);
                } else if (longExtra <= 0 || e.yV(longExtra)) {
                    if (NetStatusUtil.isWifi(WebViewDownloadWithX5UI.this.mContext)) {
                        WebViewDownloadWithX5UI.a(WebViewDownloadWithX5UI.this, stringExtra, stringExtra3);
                    } else {
                        h.INSTANCE.a(14217, "", 4, stringExtra3, stringExtra, 1);
                        com.tencent.mm.ui.base.h.a((Context) WebViewDownloadWithX5UI.this, WebViewDownloadWithX5UI.this.getString(R.string.iyr), WebViewDownloadWithX5UI.this.getString(R.string.iys), WebViewDownloadWithX5UI.this.getString(R.string.iym), WebViewDownloadWithX5UI.this.getString(R.string.sz), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.webview.ui.tools.WebViewDownloadWithX5UI.AnonymousClass2.AnonymousClass1 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(79824);
                                h.INSTANCE.a(14217, "", 5, stringExtra3, stringExtra, 1);
                                WebViewDownloadWithX5UI.a(WebViewDownloadWithX5UI.this, stringExtra, stringExtra3);
                                dialogInterface.dismiss();
                                AppMethodBeat.o(79824);
                            }
                        }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.webview.ui.tools.WebViewDownloadWithX5UI.AnonymousClass2.AnonymousClass2 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(79825);
                                h.INSTANCE.a(14217, "", 6, stringExtra3, stringExtra, 1);
                                dialogInterface.dismiss();
                                AppMethodBeat.o(79825);
                            }
                        }, (int) R.color.afp);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/WebViewDownloadWithX5UI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(79826);
                } else {
                    Toast.makeText(WebViewDownloadWithX5UI.this.mContext, WebViewDownloadWithX5UI.this.getString(R.string.don), 0).show();
                    Log.i("MicroMsg.WebViewDownloadWithX5UI", "startDownload fail, not enough space, require size = " + longExtra);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/WebViewDownloadWithX5UI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(79826);
                }
            }
        });
        AppMethodBeat.o(79829);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(79830);
        super.onDestroy();
        AppMethodBeat.o(79830);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.cbo;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(79831);
        super.onActivityResult(i2, i3, intent);
        if (this.JfY.d(this, i2, i3, intent)) {
            if (-1 == i3) {
                finish();
            }
            AppMethodBeat.o(79831);
            return;
        }
        AppMethodBeat.o(79831);
    }

    @Override // com.tencent.mm.ui.MMFragmentActivity
    public void startActivity(Intent intent) {
        AppMethodBeat.i(79832);
        if (Util.isEqual(intent.getType(), "application/vnd.android.package-archive")) {
            r.l(MMApplicationContext.getContext(), intent.getData());
            AppMethodBeat.o(79832);
            return;
        }
        super.startActivity(intent);
        AppMethodBeat.o(79832);
    }

    static /* synthetic */ void a(WebViewDownloadWithX5UI webViewDownloadWithX5UI, String str, String str2) {
        boolean z;
        AppMethodBeat.i(79833);
        iv ivVar = new iv();
        ivVar.dNx.url = str;
        ivVar.dNx.md5 = "";
        ivVar.dNx.extInfo = "";
        ivVar.dNx.appId = "";
        EventCenter.instance.publish(ivVar);
        h.INSTANCE.a(14217, "", 2, str2, str, 1);
        d.d(10, "WebViewDownloadWithX5UI_startDownload", webViewDownloadWithX5UI.hashCode());
        int tbsVersion = com.tencent.xweb.x5.sdk.d.getTbsVersion(webViewDownloadWithX5UI);
        if (g.aAc()) {
            String str3 = (String) g.aAh().azQ().get(274528, "");
            if (TextUtils.isEmpty(str3) || !com.tencent.mm.pluginsdk.model.app.q.s(webViewDownloadWithX5UI.getContext(), str3)) {
                z = false;
            } else {
                Log.i("MicroMsg.WebViewDownloadWithX5UI", "use always option PackageName is %s", str3);
                z = true;
            }
        } else {
            z = false;
        }
        if (z || tbsVersion <= 0) {
            webViewDownloadWithX5UI.JfY.c(webViewDownloadWithX5UI, str);
            AppMethodBeat.o(79833);
            return;
        }
        HashMap hashMap = new HashMap(2);
        hashMap.put(QbSdk.LOGIN_TYPE_KEY_PARTNER_ID, "com.tencent.mm");
        hashMap.put(QbSdk.LOGIN_TYPE_KEY_PARTNER_CALL_POS, "9");
        boolean a2 = com.tencent.xweb.x5.sdk.d.a(webViewDownloadWithX5UI, str, hashMap, new ValueCallback<String>() {
            /* class com.tencent.mm.plugin.webview.ui.tools.WebViewDownloadWithX5UI.AnonymousClass3 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // android.webkit.ValueCallback
            public final /* synthetic */ void onReceiveValue(String str) {
                AppMethodBeat.i(79827);
                String str2 = str;
                Log.i("MicroMsg.WebViewDownloadWithX5UI", "onReceiveValue Value = %s", str2);
                if ("closeMiniQb".equals(str2)) {
                    WebViewDownloadWithX5UI.this.finish();
                }
                AppMethodBeat.o(79827);
            }
        });
        Log.i("MicroMsg.WebViewDownloadWithX5UI", "startQbOrMiniQBToLoadUrl ret = %b", Boolean.valueOf(a2));
        if (!a2) {
            webViewDownloadWithX5UI.JfY.c(webViewDownloadWithX5UI, str);
        }
        AppMethodBeat.o(79833);
    }
}
