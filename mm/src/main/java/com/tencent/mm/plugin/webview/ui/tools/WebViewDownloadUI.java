package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Context;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.iv;
import com.tencent.mm.kernel.i;
import com.tencent.mm.modelstat.d;
import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.g;
import com.tencent.mm.plugin.downloader.model.m;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;

@i
public class WebViewDownloadUI extends MMActivity {
    private boolean IYZ;
    private Button JfK;
    private Button JfL;
    private a JfM;
    private String JfN;
    private int JfO;
    private m JfP = new m() {
        /* class com.tencent.mm.plugin.webview.ui.tools.WebViewDownloadUI.AnonymousClass4 */

        @Override // com.tencent.mm.plugin.downloader.model.m
        public final void k(long j2, String str) {
            AppMethodBeat.i(79808);
            Log.i("MicroMsg.WebViewDownloadUI", "onTaskStarted id=%d, savedFilePath=%s", Long.valueOf(j2), str);
            AppMethodBeat.o(79808);
        }

        @Override // com.tencent.mm.plugin.downloader.model.m
        public final void b(long j2, String str, boolean z) {
            AppMethodBeat.i(79809);
            Log.i("MicroMsg.WebViewDownloadUI", "onTaskFinished id=%d, savedFilePath=%s, hasChangeUrl=%b", Long.valueOf(j2), str, Boolean.valueOf(z));
            Toast.makeText(WebViewDownloadUI.this.getContext(), WebViewDownloadUI.this.getString(R.string.iyt), 1).show();
            WebViewDownloadUI.this.finish();
            AppMethodBeat.o(79809);
        }

        @Override // com.tencent.mm.plugin.downloader.model.m
        public final void b(long j2, int i2, boolean z) {
            AppMethodBeat.i(79810);
            Log.i("MicroMsg.WebViewDownloadUI", "onTaskFailed id=%d, errCode=%d, hasChangeUrl=%b", Long.valueOf(j2), Integer.valueOf(i2), Boolean.valueOf(z));
            Toast.makeText(WebViewDownloadUI.this.getContext(), WebViewDownloadUI.this.getString(R.string.iyq), 1).show();
            WebViewDownloadUI.this.finish();
            AppMethodBeat.o(79810);
        }

        @Override // com.tencent.mm.plugin.downloader.model.m
        public final void Bd(long j2) {
            AppMethodBeat.i(79811);
            Log.i("MicroMsg.WebViewDownloadUI", "onTaskRemoved id=%d", Long.valueOf(j2));
            WebViewDownloadUI.this.finish();
            AppMethodBeat.o(79811);
        }

        @Override // com.tencent.mm.plugin.downloader.model.m
        public final void Be(long j2) {
            AppMethodBeat.i(79812);
            Log.i("MicroMsg.WebViewDownloadUI", "onTaskPaused id=%d", Long.valueOf(j2));
            AppMethodBeat.o(79812);
        }

        @Override // com.tencent.mm.plugin.downloader.model.m
        public final void a(long j2, String str, long j3, long j4) {
        }

        @Override // com.tencent.mm.plugin.downloader.model.m
        public final void l(long j2, String str) {
            AppMethodBeat.i(79813);
            Log.i("MicroMsg.WebViewDownloadUI", "onTaskResumed id=%d, savedFilePath=%s", Long.valueOf(j2), str);
            AppMethodBeat.o(79813);
        }

        @Override // com.tencent.mm.plugin.downloader.model.m
        public final void Bf(long j2) {
        }
    };
    private int eik;
    private int fromScene;
    private long lAs;
    private Context mContext;
    private TextView nAB;
    private String packageName;
    private int qIG;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WebViewDownloadUI() {
        AppMethodBeat.i(79818);
        AppMethodBeat.o(79818);
    }

    /* access modifiers changed from: package-private */
    public enum a {
        TO_DOWNLOAD,
        DOWNLOADING;

        public static a valueOf(String str) {
            AppMethodBeat.i(79816);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(79816);
            return aVar;
        }

        static {
            AppMethodBeat.i(79817);
            AppMethodBeat.o(79817);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x032c, code lost:
        if (com.tencent.mm.sdk.platformtools.Util.isNullOrNil(r17) == false) goto L_0x058a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x034c, code lost:
        r15 = r25.get(r27 + ".$version");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0351, code lost:
        if (com.tencent.mm.sdk.platformtools.Util.isNullOrNil(r18) == false) goto L_0x0586;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0373, code lost:
        r17 = r25.get(r27 + ".$developer");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x037d, code lost:
        if (com.tencent.mm.sdk.platformtools.Util.isNullOrNil(r29.packageName) == false) goto L_0x0510;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x037f, code lost:
        r29.packageName = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0383, code lost:
        r18 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0510, code lost:
        r2 = r15;
        r14 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0582, code lost:
        r18 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0586, code lost:
        r17 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x058a, code lost:
        r15 = r17;
     */
    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r30) {
        /*
        // Method dump skipped, instructions count: 1431
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.ui.tools.WebViewDownloadUI.onCreate(android.os.Bundle):void");
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(79820);
        super.onDestroy();
        Log.i("MicroMsg.WebViewDownloadUI", "onDestroy hasCallback=%b", Boolean.valueOf(this.IYZ));
        if (!this.IYZ) {
            com.tencent.mm.g.a.i iVar = new com.tencent.mm.g.a.i();
            iVar.dBY.dBZ = true;
            iVar.dBY.scene = this.JfO;
            EventCenter.instance.publish(iVar);
            this.IYZ = true;
        }
        f.cBv();
        c.b(this.JfP);
        AppMethodBeat.o(79820);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.cbp;
    }

    private void a(a aVar) {
        AppMethodBeat.i(79821);
        Log.i("MicroMsg.WebViewDownloadUI", "setDownloadState old=%s new=%s", this.JfM, aVar);
        this.JfM = aVar;
        switch (this.JfM) {
            case TO_DOWNLOAD:
                this.JfK.setVisibility(0);
                this.nAB.setVisibility(8);
                this.JfL.setVisibility(8);
                AppMethodBeat.o(79821);
                return;
            case DOWNLOADING:
                this.JfK.setVisibility(8);
                this.JfL.setVisibility(0);
                this.nAB.setVisibility(0);
                break;
        }
        AppMethodBeat.o(79821);
    }

    static /* synthetic */ void a(WebViewDownloadUI webViewDownloadUI, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i2) {
        long a2;
        AppMethodBeat.i(211045);
        iv ivVar = new iv();
        ivVar.dNx.url = str;
        ivVar.dNx.md5 = str2;
        ivVar.dNx.extInfo = str3;
        ivVar.dNx.appId = str4;
        EventCenter.instance.publish(ivVar);
        h.INSTANCE.a(14217, str4, 2, str6, str, Integer.valueOf(webViewDownloadUI.fromScene));
        g.a aVar = new g.a();
        aVar.alj(str);
        aVar.alk(str5);
        aVar.all(str7);
        aVar.setFileMD5(str2);
        aVar.setAppId(str4);
        aVar.gm(str8);
        aVar.kS(true);
        aVar.Fl(webViewDownloadUI.qIG);
        aVar.Rv(str3);
        aVar.setScene(i2);
        g gVar = aVar.qIY;
        boolean z = ((b) com.tencent.mm.kernel.g.af(b.class)).a(b.a.clicfg_webview_download_use_mars, 1) == 1;
        if (webViewDownloadUI.eik != 1 || !z) {
            a2 = f.cBv().a(gVar);
        } else {
            aVar.Fp(webViewDownloadUI.eik);
            a2 = f.cBv().b(gVar);
        }
        Log.i("MicroMsg.WebViewDownloadUI", "downloadOpBtn.onClick, lastDownloadId = %d, downloadId=%d, useMars=%b, downloadType=%d", Long.valueOf(webViewDownloadUI.lAs), Long.valueOf(a2), Boolean.valueOf(z), Integer.valueOf(webViewDownloadUI.eik));
        webViewDownloadUI.lAs = a2;
        com.tencent.mm.g.a.i iVar = new com.tencent.mm.g.a.i();
        iVar.dBY.dCa = a2;
        iVar.dBY.dBZ = false;
        iVar.dBY.scene = webViewDownloadUI.JfO;
        EventCenter.instance.publish(iVar);
        webViewDownloadUI.IYZ = true;
        if (a2 <= 0) {
            Toast.makeText(webViewDownloadUI.getContext(), webViewDownloadUI.getString(R.string.iyq), 1).show();
            webViewDownloadUI.finish();
            AppMethodBeat.o(211045);
            return;
        }
        webViewDownloadUI.a(a.DOWNLOADING);
        d.d(10, "WebViewDownloadUI_startDownload", webViewDownloadUI.hashCode());
        AppMethodBeat.o(211045);
    }
}
