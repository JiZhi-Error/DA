package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.smtt.export.external.interfaces.DownloadListener;
import com.tencent.smtt.sdk.c.c;

/* access modifiers changed from: package-private */
public class b implements DownloadListener {
    private byte _hellAccFlag_;

    /* renamed from: a  reason: collision with root package name */
    private DownloadListener f1987a;

    /* renamed from: b  reason: collision with root package name */
    private WebView f1988b;

    public b(WebView webView, DownloadListener downloadListener, boolean z) {
        this.f1987a = downloadListener;
        this.f1988b = webView;
    }

    @Override // com.tencent.smtt.export.external.interfaces.DownloadListener
    public void onDownloadStart(String str, String str2, byte[] bArr, String str3, String str4, String str5, long j2, String str6, String str7) {
        AppMethodBeat.i(55133);
        if (this.f1987a != null) {
            this.f1987a.onDownloadStart(str, str3, str4, str5, j2);
            AppMethodBeat.o(55133);
        } else if (QbSdk.canOpenMimeFileType(this.f1988b.getContext(), str5)) {
            Intent intent = new Intent("com.tencent.QQBrowser.action.sdk.document");
            intent.setFlags(268435456);
            intent.putExtra("key_reader_sdk_url", str);
            intent.putExtra("key_reader_sdk_type", 1);
            intent.setData(Uri.parse(str));
            Context context = this.f1988b.getContext();
            a bl = new a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/smtt/sdk/b", "onDownloadStart", "(Ljava/lang/String;Ljava/lang/String;[BLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/smtt/sdk/b", "onDownloadStart", "(Ljava/lang/String;Ljava/lang/String;[BLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(55133);
        } else {
            ApplicationInfo applicationInfo = this.f1988b.getContext().getApplicationInfo();
            if (applicationInfo == null || !"com.tencent.mm".equals(applicationInfo.packageName)) {
                c.a(this.f1988b.getContext(), str, null, null);
            }
            AppMethodBeat.o(55133);
        }
    }

    @Override // com.tencent.smtt.export.external.interfaces.DownloadListener
    public void onDownloadVideo(String str, long j2, int i2) {
    }

    @Override // com.tencent.smtt.export.external.interfaces.DownloadListener
    public void onDownloadStart(String str, String str2, String str3, String str4, long j2) {
        AppMethodBeat.i(55134);
        onDownloadStart(str, null, null, str2, str3, str4, j2, null, null);
        AppMethodBeat.o(55134);
    }
}
