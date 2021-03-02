package com.tencent.mm.plugin.webview.ui.tools.media;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.y;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.media.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import com.tencent.youtu.sdkkitframework.common.StateEvent;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/media/MPVideoTransmitHelper;", "", "()V", "TAG", "", "mpShareVideoInfo", "Lcom/tencent/mm/message/MPShareVideoInfo;", "getMpShareVideoInfo", "()Lcom/tencent/mm/message/MPShareVideoInfo;", "setMpShareVideoInfo", "(Lcom/tencent/mm/message/MPShareVideoInfo;)V", "onActivityResult", "", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/app/Activity;", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "plugin-webview_release"})
public final class e {
    final String TAG = "MicroMsg.MPVideoTransmit";
    public y iwi;

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "bundle", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "onCallback"})
    public static final class a<T> implements d<Bundle> {
        final /* synthetic */ e Jwz;
        final /* synthetic */ Activity msB;

        a(e eVar, Activity activity) {
            this.Jwz = eVar;
            this.msB = activity;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.ipcinvoker.d
        public final /* synthetic */ void bn(Bundle bundle) {
            AppMethodBeat.i(82660);
            if (bundle.getBoolean("ret", true)) {
                MMHandlerThread.postToMainThread(new Runnable(this) {
                    /* class com.tencent.mm.plugin.webview.ui.tools.media.e.a.AnonymousClass1 */
                    final /* synthetic */ a JwA;

                    {
                        this.JwA = r1;
                    }

                    public final void run() {
                        h hVar;
                        AppMethodBeat.i(82658);
                        com.tencent.mm.ui.base.h.cA(this.JwA.msB, this.JwA.msB.getString(R.string.ajk));
                        if ((this.JwA.msB instanceof WebViewUI) && (hVar = ((WebViewUI) this.JwA.msB).IBw) != null) {
                            y yVar = this.JwA.Jwz.iwi;
                            if (yVar == null) {
                                p.hyc();
                            }
                            hVar.lT(yVar.KOf, "success");
                        }
                        h.a aVar = h.JwJ;
                        y yVar2 = this.JwA.Jwz.iwi;
                        if (yVar2 == null) {
                            p.hyc();
                        }
                        String str = yVar2.KOf;
                        p.g(str, "mpShareVideoInfo!!.videoVid");
                        y yVar3 = this.JwA.Jwz.iwi;
                        if (yVar3 == null) {
                            p.hyc();
                        }
                        String str2 = yVar3.KOe;
                        p.g(str2, "mpShareVideoInfo!!.mpUrl");
                        y yVar4 = this.JwA.Jwz.iwi;
                        if (yVar4 == null) {
                            p.hyc();
                        }
                        h.a.i(1, str, str2, yVar4.iAP);
                        AppMethodBeat.o(82658);
                    }
                });
                AppMethodBeat.o(82660);
                return;
            }
            Log.w(this.Jwz.TAG, "share fail");
            MMHandlerThread.postToMainThread(new Runnable(this) {
                /* class com.tencent.mm.plugin.webview.ui.tools.media.e.a.AnonymousClass2 */
                final /* synthetic */ a JwA;

                {
                    this.JwA = r1;
                }

                public final void run() {
                    WebViewUI webViewUI;
                    com.tencent.mm.plugin.webview.d.h hVar;
                    AppMethodBeat.i(82659);
                    if (!(this.JwA.msB instanceof WebViewUI) || (webViewUI = (WebViewUI) this.JwA.msB) == null || (hVar = webViewUI.IBw) == null) {
                        AppMethodBeat.o(82659);
                        return;
                    }
                    y yVar = this.JwA.Jwz.iwi;
                    if (yVar == null) {
                        p.hyc();
                    }
                    hVar.lT(yVar.KOf, StateEvent.ProcessResult.FAILED);
                    AppMethodBeat.o(82659);
                }
            });
            AppMethodBeat.o(82660);
        }
    }

    public final boolean d(Activity activity, int i2, int i3, Intent intent) {
        com.tencent.mm.plugin.webview.d.h hVar;
        String str;
        AppMethodBeat.i(82661);
        p.h(activity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        if (3 != i2) {
            AppMethodBeat.o(82661);
            return false;
        } else if (this.iwi == null) {
            Log.w(this.TAG, "onActivityResult mpMsgInfo is null");
            AppMethodBeat.o(82661);
            return true;
        } else {
            if (i3 == -1) {
                String stringExtra = intent != null ? intent.getStringExtra("Select_Conv_User") : null;
                if (intent != null) {
                    str = intent.getStringExtra("custom_send_text");
                } else {
                    str = null;
                }
                if (stringExtra != null) {
                    d dVar = d.Jwx;
                    y yVar = this.iwi;
                    if (yVar == null) {
                        p.hyc();
                    }
                    d.b(stringExtra, yVar, str, new a(this, activity));
                }
            } else {
                Log.w(this.TAG, "share cancel");
                if ((activity instanceof WebViewUI) && (hVar = ((WebViewUI) activity).IBw) != null) {
                    y yVar2 = this.iwi;
                    if (yVar2 == null) {
                        p.hyc();
                    }
                    hVar.lT(yVar2.KOf, "canceled");
                }
            }
            AppMethodBeat.o(82661);
            return true;
        }
    }
}
