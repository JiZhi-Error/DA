package com.tencent.mm.plugin.webview.ui.tools.media;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.modelsns.h;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.media.h;
import com.tencent.mm.protocal.protobuf.jo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/media/MPVideoShareToSns;", "", "()V", "TAG", "", "doShareToSns", "", "videoInfo", "Lcom/tencent/mm/protocal/protobuf/BaseMpShareVideoInfo;", "context", "Lcom/tencent/mm/ui/MMActivity;", "currentEnterId", "", "plugin-webview_release"})
public final class c {
    public static final c Jwu = new c();
    private static final String TAG = TAG;

    static {
        AppMethodBeat.i(210561);
        AppMethodBeat.o(210561);
    }

    private c() {
    }

    public static void b(jo joVar, MMActivity mMActivity, int i2) {
        AppMethodBeat.i(210560);
        if (joVar == null || mMActivity == null) {
            Log.w(TAG, "doShareToSns msgInfo is null");
            AppMethodBeat.o(210560);
            return;
        }
        Intent intent = new Intent();
        h hVar = new h();
        hVar.jli = joVar;
        intent.putExtra("ksnsupload_mp_video_xml", hVar.bfF());
        intent.putExtra("Ksnsupload_type", 19);
        intent.putExtra("need_result", true);
        com.tencent.mm.br.c.a(mMActivity, ".plugin.sns.ui.SnsUploadUI", intent, 5, new a(mMActivity, joVar, i2));
        AppMethodBeat.o(210560);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "mmOnActivityResult"})
    public static final class a implements MMActivity.a {
        final /* synthetic */ MMActivity $context;
        final /* synthetic */ jo Jwv;
        final /* synthetic */ int Jww;

        a(MMActivity mMActivity, jo joVar, int i2) {
            this.$context = mMActivity;
            this.Jwv = joVar;
            this.Jww = i2;
        }

        @Override // com.tencent.mm.ui.MMActivity.a
        public final void d(int i2, int i3, Intent intent) {
            com.tencent.mm.plugin.webview.d.h hVar;
            com.tencent.mm.plugin.webview.d.h hVar2;
            AppMethodBeat.i(210559);
            if (i3 == -1) {
                com.tencent.mm.ui.base.h.cA(this.$context, this.$context.getString(R.string.z0));
                if ((this.$context instanceof WebViewUI) && (hVar2 = ((WebViewUI) this.$context).IBw) != null) {
                    jo joVar = this.Jwv;
                    if (joVar == null) {
                        p.hyc();
                    }
                    hVar2.lT(joVar.KOf, "success");
                }
                h.a aVar = h.JwJ;
                jo joVar2 = this.Jwv;
                if (joVar2 == null) {
                    p.hyc();
                }
                String str = joVar2.KOf;
                p.g(str, "videoInfo!!.videoVid");
                jo joVar3 = this.Jwv;
                if (joVar3 == null) {
                    p.hyc();
                }
                String str2 = joVar3.KOe;
                p.g(str2, "videoInfo!!.mpUrl");
                h.a.i(2, str, str2, this.Jww);
                AppMethodBeat.o(210559);
                return;
            }
            com.tencent.mm.ui.base.h.cA(this.$context, this.$context.getString(R.string.h0j));
            if (!(this.$context instanceof WebViewUI) || (hVar = ((WebViewUI) this.$context).IBw) == null) {
                AppMethodBeat.o(210559);
                return;
            }
            jo joVar4 = this.Jwv;
            if (joVar4 == null) {
                p.hyc();
            }
            hVar.lT(joVar4.KOf, "canceled");
            AppMethodBeat.o(210559);
        }
    }
}
