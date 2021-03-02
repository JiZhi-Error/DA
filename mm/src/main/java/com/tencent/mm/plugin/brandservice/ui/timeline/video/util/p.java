package com.tencent.mm.plugin.brandservice.ui.timeline.video.util;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.R;
import com.tencent.mm.ag.x;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplShareWebViewToolUI;
import com.tencent.mm.plugin.webview.model.az;
import com.tencent.mm.plugin.webview.ui.tools.j;
import com.tencent.mm.plugin.webview.ui.tools.o;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.smtt.sdk.TbsListener;
import java.lang.ref.WeakReference;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010%\u001a\u0004\u0018\u00010 J\b\u0010&\u001a\u00020'H\u0002J\b\u0010(\u001a\u00020'H\u0002J\b\u0010)\u001a\u00020'H\u0002J\b\u0010*\u001a\u00020'H\u0002J\u0018\u0010+\u001a\u00020\u00132\u0006\u0010,\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u0004H\u0002J\u001e\u0010.\u001a\u00020'2\u0006\u0010\u001e\u001a\u00020 2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u0011J\b\u0010/\u001a\u00020\u0013H\u0002J \u00100\u001a\u00020\u00132\u0006\u00101\u001a\u00020\u00042\u0006\u00102\u001a\u00020\u00042\b\u00103\u001a\u0004\u0018\u000104J\u0006\u00105\u001a\u00020'J\b\u00106\u001a\u00020'H\u0002J\u0018\u00107\u001a\u00020\u00132\u0006\u0010,\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u0004H\u0002J\u000e\u00108\u001a\u00020'2\u0006\u0010\u0018\u001a\u00020\u0013J\u0006\u00109\u001a\u00020'R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR \u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fX.¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006:"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/MpMenuHelper;", "", "()V", "MENU_ID_CANCEL_HAO_KAN", "", "MENU_ID_CANCEL_MINIMIZE", "MENU_ID_COPY_LINK", "MENU_ID_EXPOSE", "MENU_ID_FAV", "MENU_ID_HAO_KAN", "MENU_ID_MINIMIZE", "MENU_ID_SEND_TO_FRIEND", "MENU_ID_SHARE_TO_TIMELINE", "MENU_ID_SHOW_BIZ", "TAG", "", "controller", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizNativePageController;", "isBottomSheetShowing", "", "mmBottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "msgInfo", "Lcom/tencent/mm/message/MPMsgInfo;", "onlyShowShareMenu", "shareExtInfo", "getShareExtInfo", "()Ljava/lang/String;", "setShareExtInfo", "(Ljava/lang/String;)V", "ui", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI;", "getUi$plugin_brandservice_release", "()Ljava/lang/ref/WeakReference;", "setUi$plugin_brandservice_release", "(Ljava/lang/ref/WeakReference;)V", "context", "copyLink", "", "doExpose", "fav", "goProfile", "hasShowMenuPermission", "id", "bitSet", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "isFinished", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onDestroy", "shareToTimeline", "shouldDisableMenuItem", "showMenu", "updateMenu", "plugin-brandservice_release"})
public final class p {
    final String TAG = "MicroMsg.MpMenuHelper";
    com.tencent.mm.ui.widget.a.e nVN;
    public WeakReference<TmplShareWebViewToolUI> nhy;
    public x pHv;
    public com.tencent.mm.plugin.brandservice.ui.timeline.video.b pIL;
    final int pLT;
    final int pLU = 1;
    final int pLV = 2;
    final int pLW = 3;
    final int pLX = 4;
    final int pLY = 5;
    final int pLZ = 6;
    final int pMa = 7;
    final int pMb = 8;
    final int pMc = 9;
    public boolean pMd;
    boolean pMe;
    public String pMf = "";

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "bundle", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "onCallback"})
    public static final class a<T> implements com.tencent.mm.ipcinvoker.d<Bundle> {
        final /* synthetic */ p pMg;

        public a(p pVar) {
            this.pMg = pVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.ipcinvoker.d
        public final /* synthetic */ void bn(Bundle bundle) {
            int i2;
            AppMethodBeat.i(7345);
            if (bundle.getBoolean("ret", true)) {
                MMHandlerThread.postToMainThread(new Runnable(this) {
                    /* class com.tencent.mm.plugin.brandservice.ui.timeline.video.util.p.a.AnonymousClass1 */
                    final /* synthetic */ a pMh;

                    {
                        this.pMh = r1;
                    }

                    public final void run() {
                        AppMethodBeat.i(7344);
                        TmplShareWebViewToolUI cpV = this.pMh.pMg.cpV();
                        TmplShareWebViewToolUI cpV2 = this.pMh.pMg.cpV();
                        h.cA(cpV, cpV2 != null ? cpV2.getString(R.string.ajk) : null);
                        AppMethodBeat.o(7344);
                    }
                });
                if (this.pMg.pMd) {
                    i2 = 10;
                } else {
                    i2 = 1;
                }
                p.b(this.pMg).pHq.aL(i2, this.pMg.pMf);
                AppMethodBeat.o(7345);
                return;
            }
            Log.w(this.pMg.TAG, "share fail");
            AppMethodBeat.o(7345);
        }
    }

    public static final /* synthetic */ x a(p pVar) {
        AppMethodBeat.i(7360);
        x xVar = pVar.pHv;
        if (xVar == null) {
            kotlin.g.b.p.btv("msgInfo");
        }
        AppMethodBeat.o(7360);
        return xVar;
    }

    public static final /* synthetic */ com.tencent.mm.plugin.brandservice.ui.timeline.video.b b(p pVar) {
        AppMethodBeat.i(7361);
        com.tencent.mm.plugin.brandservice.ui.timeline.video.b bVar = pVar.pIL;
        if (bVar == null) {
            kotlin.g.b.p.btv("controller");
        }
        AppMethodBeat.o(7361);
        return bVar;
    }

    public final void ani() {
        AppMethodBeat.i(7352);
        if (this.pMe) {
            ks(this.pMd);
        }
        AppMethodBeat.o(7352);
    }

    public final void ks(boolean z) {
        o.a aVar;
        String str;
        AppMethodBeat.i(7353);
        this.pMd = z;
        if (!z) {
            this.pMf = "";
        }
        if (isFinished()) {
            Log.i(this.TAG, "showMenu return:isFinished=%b", Boolean.valueOf(isFinished()));
            AppMethodBeat.o(7353);
            return;
        }
        if (!this.pMe) {
            if (z) {
                com.tencent.mm.plugin.brandservice.ui.timeline.video.b bVar = this.pIL;
                if (bVar == null) {
                    kotlin.g.b.p.btv("controller");
                }
                if ((bVar.iwg & 8) != 0) {
                    com.tencent.mm.plugin.brandservice.ui.timeline.video.b bVar2 = this.pIL;
                    if (bVar2 == null) {
                        kotlin.g.b.p.btv("controller");
                    }
                    if ((bVar2.iwg & 16) != 0) {
                        TmplShareWebViewToolUI cpV = cpV();
                        TmplShareWebViewToolUI cpV2 = cpV();
                        if (cpV2 != null) {
                            str = cpV2.getString(R.string.j4h);
                        } else {
                            str = null;
                        }
                        h.cA(cpV, str);
                        AppMethodBeat.o(7353);
                        return;
                    }
                }
                this.nVN = new com.tencent.mm.ui.widget.a.e((Context) cpV(), 1, false);
            } else {
                this.nVN = new com.tencent.mm.ui.widget.a.e((Context) cpV(), 0, true);
            }
        }
        com.tencent.mm.ui.widget.a.e eVar = this.nVN;
        if (eVar != null) {
            eVar.b(new c(this));
        }
        com.tencent.mm.ui.widget.a.e eVar2 = this.nVN;
        if (eVar2 != null) {
            eVar2.a(new d(this, z));
        }
        g gVar = new g(this);
        com.tencent.mm.ui.widget.a.e eVar3 = this.nVN;
        if (eVar3 != null) {
            eVar3.a(gVar);
        }
        com.tencent.mm.ui.widget.a.e eVar4 = this.nVN;
        if (eVar4 != null) {
            eVar4.b(new e(this, z));
        }
        TmplShareWebViewToolUI cpV3 = cpV();
        String fZM = cpV3 != null ? cpV3.fZM() : null;
        TmplShareWebViewToolUI cpV4 = cpV();
        if (cpV4 == null || cpV4.ILE == null) {
            aVar = null;
        } else {
            aVar = o.baw(fZM);
        }
        boolean isMpUrl = ((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).isMpUrl(fZM);
        if (!z && isMpUrl && aVar != null && aVar.isDataValid()) {
            View inflate = LayoutInflater.from(cpV()).inflate(R.layout.bam, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.iy5);
            View findViewById = inflate.findViewById(R.id.bex);
            kotlin.g.b.p.g(textView, "nickNameTextView");
            textView.setText(aVar.Jkn);
            com.tencent.mm.av.a.a.bdb().a(aVar.Jko, (ImageView) inflate.findViewById(R.id.e4o), new c.a().bdq().bdt().ty(R.drawable.bca).bdv());
            findViewById.setOnClickListener(new f(this, aVar));
            com.tencent.mm.ui.tools.o.hp(findViewById);
            com.tencent.mm.ui.widget.a.e eVar5 = this.nVN;
            if (eVar5 != null) {
                eVar5.V(inflate, true);
            }
        }
        com.tencent.mm.ui.widget.a.e eVar6 = this.nVN;
        if (eVar6 != null) {
            eVar6.b(gVar);
        }
        com.tencent.mm.ui.widget.a.e eVar7 = this.nVN;
        if (eVar7 != null) {
            eVar7.dGm();
        }
        this.pMe = true;
        AppMethodBeat.o(7353);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onDismiss"})
    public static final class c implements e.b {
        final /* synthetic */ p pMg;

        c(p pVar) {
            this.pMg = pVar;
        }

        @Override // com.tencent.mm.ui.widget.a.e.b
        public final void onDismiss() {
            this.pMg.pMe = false;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    public static final class d implements o.f {
        final /* synthetic */ p pMg;
        final /* synthetic */ boolean pMi;

        d(p pVar, boolean z) {
            this.pMg = pVar;
            this.pMi = z;
        }

        /* JADX WARNING: Removed duplicated region for block: B:44:0x00f7  */
        /* JADX WARNING: Removed duplicated region for block: B:56:0x013c  */
        @Override // com.tencent.mm.ui.base.o.f
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onCreateMMMenu(com.tencent.mm.ui.base.m r15) {
            /*
            // Method dump skipped, instructions count: 472
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.brandservice.ui.timeline.video.util.p.d.onCreateMMMenu(com.tencent.mm.ui.base.m):void");
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", FirebaseAnalytics.b.INDEX, "", "onMMMenuItemSelected"})
    public static final class g implements o.g {
        final /* synthetic */ p pMg;

        g(p pVar) {
            this.pMg = pVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:323:0x06e0  */
        /* JADX WARNING: Removed duplicated region for block: B:328:0x0711 A[Catch:{ IOException -> 0x0792 }] */
        /* JADX WARNING: Removed duplicated region for block: B:330:0x071b A[Catch:{ IOException -> 0x0792 }] */
        /* JADX WARNING: Removed duplicated region for block: B:332:0x0720 A[Catch:{ IOException -> 0x0792 }] */
        /* JADX WARNING: Removed duplicated region for block: B:336:0x0756  */
        /* JADX WARNING: Removed duplicated region for block: B:342:0x078e  */
        /* JADX WARNING: Removed duplicated region for block: B:343:0x0790  */
        /* JADX WARNING: Removed duplicated region for block: B:374:0x0882  */
        @Override // com.tencent.mm.ui.base.o.g
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onMMMenuItemSelected(android.view.MenuItem r10, int r11) {
            /*
            // Method dump skipped, instructions count: 2181
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.brandservice.ui.timeline.video.util.p.g.onMMMenuItemSelected(android.view.MenuItem, int):void");
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    public static final class e implements o.f {
        final /* synthetic */ p pMg;
        final /* synthetic */ boolean pMi;

        e(p pVar, boolean z) {
            this.pMg = pVar;
            this.pMi = z;
        }

        @Override // com.tencent.mm.ui.base.o.f
        public final void onCreateMMMenu(m mVar) {
            String str;
            com.tencent.mm.plugin.webview.ui.tools.o oVar;
            o.a aVar;
            boolean z;
            String str2;
            String str3;
            String str4;
            AppMethodBeat.i(7348);
            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(480, 0, 1, false);
            mVar.clear();
            if (this.pMg.cpV() == null) {
                AppMethodBeat.o(7348);
                return;
            }
            if (!this.pMi) {
                TmplShareWebViewToolUI cpV = this.pMg.cpV();
                if (cpV == null) {
                    kotlin.g.b.p.hyc();
                }
                if (cpV.gff() != null) {
                    TmplShareWebViewToolUI cpV2 = this.pMg.cpV();
                    if (cpV2 == null) {
                        kotlin.g.b.p.hyc();
                    }
                    if (cpV2.gff().bPq()) {
                        int i2 = this.pMg.pMb;
                        TmplShareWebViewToolUI cpV3 = this.pMg.cpV();
                        mVar.b(i2, cpV3 != null ? cpV3.getString(R.string.ftx) : null, R.raw.icons_outlined_multitask);
                    }
                }
            }
            TmplShareWebViewToolUI cpV4 = this.pMg.cpV();
            if (cpV4 != null) {
                str = cpV4.fZM();
            } else {
                str = null;
            }
            TmplShareWebViewToolUI cpV5 = this.pMg.cpV();
            if (cpV5 != null) {
                oVar = cpV5.ILE;
            } else {
                oVar = null;
            }
            if (oVar != null) {
                aVar = com.tencent.mm.plugin.webview.ui.tools.o.baw(str);
            } else {
                aVar = null;
            }
            if (aVar == null || !aVar.isDataValid()) {
                z = true;
            } else {
                z = false;
            }
            if (p.a(this.pMg, 1) && z) {
                int i3 = this.pMg.pLY;
                TmplShareWebViewToolUI cpV6 = this.pMg.cpV();
                if (cpV6 != null) {
                    str4 = cpV6.getString(R.string.j4f);
                } else {
                    str4 = null;
                }
                mVar.a(i3, str4, R.raw.icons_outlined_official_accounts, p.b(this.pMg, 1));
            }
            if (p.a(this.pMg, 0)) {
                int i4 = this.pMg.pMa;
                TmplShareWebViewToolUI cpV7 = this.pMg.cpV();
                if (cpV7 != null) {
                    str3 = cpV7.getString(R.string.ahk);
                } else {
                    str3 = null;
                }
                mVar.a(i4, str3, R.raw.icons_outlined_report_problem, p.b(this.pMg, 0));
            }
            if (p.a(this.pMg, 32)) {
                int i5 = this.pMg.pLZ;
                TmplShareWebViewToolUI cpV8 = this.pMg.cpV();
                if (cpV8 != null) {
                    str2 = cpV8.getString(R.string.j45);
                } else {
                    str2 = null;
                }
                mVar.a(i5, str2, R.raw.icons_outlined_link, p.b(this.pMg, 32));
            }
            AppMethodBeat.o(7348);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class f implements View.OnClickListener {
        final /* synthetic */ p pMg;
        final /* synthetic */ o.a pMj;

        f(p pVar, o.a aVar) {
            this.pMg = pVar;
            this.pMj = aVar;
        }

        public final void onClick(View view) {
            com.tencent.mm.ui.widget.a.e eVar;
            j jVar;
            az azVar;
            az.d gdh;
            AppMethodBeat.i(175545);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/video/util/MpMenuHelper$showMenu$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            TmplShareWebViewToolUI cpV = this.pMg.cpV();
            if (!(cpV == null || (azVar = cpV.IMs) == null || (gdh = azVar.gdh()) == null)) {
                Object[] objArr = new Object[3];
                WeakReference<TmplShareWebViewToolUI> weakReference = this.pMg.nhy;
                if (weakReference == null) {
                    kotlin.g.b.p.btv("ui");
                }
                TmplShareWebViewToolUI tmplShareWebViewToolUI = weakReference.get();
                objArr[0] = tmplShareWebViewToolUI != null ? tmplShareWebViewToolUI.coX() : null;
                objArr[1] = 38;
                objArr[2] = 1;
                gdh.C(objArr).report();
            }
            TmplShareWebViewToolUI cpV2 = this.pMg.cpV();
            if (!(cpV2 == null || (jVar = cpV2.Jjm) == null)) {
                jVar.gx("Contact_Scene", TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_3);
            }
            TmplShareWebViewToolUI cpV3 = this.pMg.cpV();
            if (cpV3 != null) {
                cpV3.bas(this.pMj.brandUsername);
            }
            if (!(this.pMg.nVN == null || (eVar = this.pMg.nVN) == null)) {
                eVar.bMo();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/video/util/MpMenuHelper$showMenu$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(175545);
        }
    }

    public final TmplShareWebViewToolUI cpV() {
        AppMethodBeat.i(7355);
        WeakReference<TmplShareWebViewToolUI> weakReference = this.nhy;
        if (weakReference == null) {
            kotlin.g.b.p.btv("ui");
        }
        if (weakReference.get() == null) {
            AppMethodBeat.o(7355);
            return null;
        }
        WeakReference<TmplShareWebViewToolUI> weakReference2 = this.nhy;
        if (weakReference2 == null) {
            kotlin.g.b.p.btv("ui");
        }
        TmplShareWebViewToolUI tmplShareWebViewToolUI = weakReference2.get();
        if (tmplShareWebViewToolUI == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplShareWebViewToolUI");
            AppMethodBeat.o(7355);
            throw tVar;
        }
        TmplShareWebViewToolUI tmplShareWebViewToolUI2 = tmplShareWebViewToolUI;
        AppMethodBeat.o(7355);
        return tmplShareWebViewToolUI2;
    }

    public final void onDestroy() {
        AppMethodBeat.i(7356);
        if (this.nVN != null) {
            com.tencent.mm.ui.widget.a.e eVar = this.nVN;
            if (eVar == null) {
                kotlin.g.b.p.hyc();
            }
            if (eVar.isShowing()) {
                com.tencent.mm.ui.widget.a.e eVar2 = this.nVN;
                if (eVar2 == null) {
                    kotlin.g.b.p.hyc();
                }
                eVar2.bMo();
            }
        }
        AppMethodBeat.o(7356);
    }

    /* access modifiers changed from: package-private */
    public final boolean isFinished() {
        AppMethodBeat.i(7357);
        WeakReference<TmplShareWebViewToolUI> weakReference = this.nhy;
        if (weakReference == null) {
            kotlin.g.b.p.btv("ui");
        }
        if (weakReference.get() != null) {
            WeakReference<TmplShareWebViewToolUI> weakReference2 = this.nhy;
            if (weakReference2 == null) {
                kotlin.g.b.p.btv("ui");
            }
            TmplShareWebViewToolUI tmplShareWebViewToolUI = weakReference2.get();
            if (tmplShareWebViewToolUI == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplShareWebViewToolUI");
                AppMethodBeat.o(7357);
                throw tVar;
            } else if (!tmplShareWebViewToolUI.isFinishing()) {
                AppMethodBeat.o(7357);
                return false;
            }
        }
        AppMethodBeat.o(7357);
        return true;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "bundle", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "onCallback"})
    static final class b<T> implements com.tencent.mm.ipcinvoker.d<Bundle> {
        final /* synthetic */ Intent $intent;
        final /* synthetic */ p pMg;

        b(p pVar, Intent intent) {
            this.pMg = pVar;
            this.$intent = intent;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.ipcinvoker.d
        public final /* synthetic */ void bn(Bundle bundle) {
            AppMethodBeat.i(7346);
            com.tencent.mm.br.c.a((Context) this.pMg.cpV(), "sns", ".ui.SnsUploadUI", this.$intent, 1, false);
            AppMethodBeat.o(7346);
        }
    }

    public static final /* synthetic */ boolean a(p pVar, int i2) {
        AppMethodBeat.i(7358);
        if (pVar.pMd) {
            com.tencent.mm.plugin.brandservice.ui.timeline.video.b bVar = pVar.pIL;
            if (bVar == null) {
                kotlin.g.b.p.btv("controller");
            }
            if ((bVar.iwg & i2) != 0) {
                AppMethodBeat.o(7358);
                return false;
            }
        }
        AppMethodBeat.o(7358);
        return true;
    }

    public static final /* synthetic */ boolean b(p pVar, int i2) {
        AppMethodBeat.i(7359);
        com.tencent.mm.plugin.brandservice.ui.timeline.video.b bVar = pVar.pIL;
        if (bVar == null) {
            kotlin.g.b.p.btv("controller");
        }
        if ((bVar.iwg & i2) != 0) {
            AppMethodBeat.o(7359);
            return true;
        }
        AppMethodBeat.o(7359);
        return false;
    }
}
