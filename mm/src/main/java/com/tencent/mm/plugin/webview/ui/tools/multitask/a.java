package com.tencent.mm.plugin.webview.ui.tools.multitask;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Parcel;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.api.aa;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.multitask.a.a;
import com.tencent.mm.plugin.multitask.animation.swipeahead.b;
import com.tencent.mm.plugin.multitask.b.c;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.taskbar.api.c;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.floatball.d;
import com.tencent.mm.plugin.webview.ui.tools.o;
import com.tencent.mm.protocal.protobuf.ach;
import com.tencent.mm.protocal.protobuf.fah;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.e;
import java.util.HashSet;
import java.util.Set;

public final class a extends c {
    private static final Set<String> IUM;
    private static final c.a JwV = new c.a() {
        /* class com.tencent.mm.plugin.webview.ui.tools.multitask.a.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.taskbar.api.c.a
        public final void a(MultiTaskInfo multiTaskInfo) {
            AppMethodBeat.i(212023);
            Log.d("MicroMsg.WebMultiTaskHelper", "MultiTaskInfo, name:%s", multiTaskInfo.field_showData.title);
            fah fah = new fah();
            try {
                fah.parseFrom(multiTaskInfo.field_data);
                int i2 = fah.Nwt;
                String str = fah.edo;
                if (i2 >= 0 && !Util.isNullOrNil(str)) {
                    int i3 = fah.Nwo;
                    Log.d("MicroMsg.WebMultiTaskHelper", "addToPreload, name:%s", multiTaskInfo.field_showData.title);
                    ((b) g.af(b.class)).a(str, i2, i3, new Object[0]);
                }
                d dVar = d.JmQ;
                d.r(multiTaskInfo);
                AppMethodBeat.o(212023);
            } catch (Throwable th) {
                Log.e("MicroMsg.WebMultiTaskHelper", "WebMultiTaskData parse fail", th);
                AppMethodBeat.o(212023);
            }
        }

        @Override // com.tencent.mm.plugin.taskbar.api.c.a
        public final void b(MultiTaskInfo multiTaskInfo) {
            AppMethodBeat.i(212024);
            a.t(multiTaskInfo);
            AppMethodBeat.o(212024);
        }

        @Override // com.tencent.mm.plugin.taskbar.api.c.a
        public final void c(MultiTaskInfo multiTaskInfo) {
            AppMethodBeat.i(212025);
            Log.d("MicroMsg.WebMultiTaskHelper", "onTaskBarItemRemoved, name:%s", multiTaskInfo.field_showData.title);
            d dVar = d.JmQ;
            d.q(multiTaskInfo);
            AppMethodBeat.o(212025);
        }
    };
    public fah IVb;
    private WebViewUI Jkg;
    private boolean JmJ;
    private boolean JmK = false;
    private boolean JwT = true;
    private boolean JwU = false;

    static {
        AppMethodBeat.i(212049);
        HashSet hashSet = new HashSet();
        IUM = hashSet;
        hashSet.add("title");
        IUM.add("webpageTitle");
        IUM.add("hide_option_menu");
        IUM.add("translate_webview");
        IUM.add("srcUsername");
        IUM.add("srcDisplayname");
        IUM.add("mode");
        IUM.add("KTemplateId");
        IUM.add("KPublisherId");
        IUM.add(e.p.Ozw);
        IUM.add(e.p.Ozx);
        IUM.add("pay_channel");
        IUM.add("key_download_restrict");
        IUM.add("key_wallet_region");
        IUM.add("key_function_id");
        IUM.add(e.p.OzA);
        IUM.add("geta8key_scene");
        IUM.add("biz_video_msg_id");
        IUM.add("biz_video_msg_index");
        IUM.add("biz_video_msg_svr_id");
        IUM.add("biz_mp_msg_info");
        IUM.add(e.p.OzI);
        IUM.add("key_menu_hide_expose");
        IUM.add("webviewCurrentProcess");
        AppMethodBeat.o(212049);
    }

    public a(com.tencent.mm.plugin.multitask.a.a aVar, WebViewUI webViewUI) {
        super(aVar);
        AppMethodBeat.i(212026);
        this.Jkg = webViewUI;
        this.IVb = new fah();
        if (this.Aak.getIntent() != null) {
            com.tencent.mm.plugin.multitask.f.b.b(this.Aak.getIntent(), this.IVb);
        }
        Log.i("MicroMsg.WebMultiTaskHelper", "createWebMultiTaskHelper, WebViewUI:%s", Integer.valueOf(webViewUI.hashCode()));
        AppMethodBeat.o(212026);
    }

    @Override // com.tencent.mm.plugin.multitask.b.a, com.tencent.mm.plugin.multitask.b.b
    public final void ic(boolean z) {
        AppMethodBeat.i(212027);
        bPu();
        super.ic(z);
        AppMethodBeat.o(212027);
    }

    @Override // com.tencent.mm.plugin.multitask.b.a, com.tencent.mm.plugin.multitask.b.c
    public final boolean O(int i2, boolean z) {
        AppMethodBeat.i(212028);
        bPu();
        if (!this.JwU) {
            this.JwT = false;
        }
        boolean O = super.O(i2, this.JwT);
        AppMethodBeat.o(212028);
        return O;
    }

    @Override // com.tencent.mm.plugin.multitask.b.a
    public final boolean erb() {
        boolean z;
        boolean z2;
        AppMethodBeat.i(212029);
        if (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_multitask_taskbar_disable_webview_capture_on_close, 0) != 0) {
            z = true;
        } else {
            z = false;
        }
        Object[] objArr = new Object[1];
        if (!z) {
            z2 = true;
        } else {
            z2 = false;
        }
        objArr[0] = Boolean.valueOf(z2);
        Log.i("MicroMsg.WebMultiTaskHelper", "shouldCaptureOnClose:%b", objArr);
        if (!z) {
            AppMethodBeat.o(212029);
            return true;
        }
        AppMethodBeat.o(212029);
        return false;
    }

    @Override // com.tencent.mm.plugin.multitask.b.a
    public final void d(Bitmap bitmap, boolean z) {
        AppMethodBeat.i(212030);
        if (this.Jkg.gft() == null) {
            Log.i("MicroMsg.WebMultiTaskHelper", "not MP page");
            AppMethodBeat.o(212030);
        } else if (z) {
            Log.i("MicroMsg.WebMultiTaskHelper", "ended, remove historyTaskInfo");
            erc();
            AppMethodBeat.o(212030);
        } else {
            Log.i("MicroMsg.WebMultiTaskHelper", "not ended update historyTaskInfo");
            c(bitmap, true);
            AppMethodBeat.o(212030);
        }
    }

    @Override // com.tencent.mm.plugin.multitask.b.a
    public final boolean bPp() {
        AppMethodBeat.i(212031);
        if (!this.Jkg.gbH() || !this.Aak.bPp()) {
            AppMethodBeat.o(212031);
            return false;
        }
        AppMethodBeat.o(212031);
        return true;
    }

    public final boolean wu(int i2) {
        AppMethodBeat.i(212032);
        boolean O = O(i2, this.JwT);
        AppMethodBeat.o(212032);
        return O;
    }

    public final void ahe(int i2) {
        AppMethodBeat.i(212034);
        Log.i("MicroMsg.WebMultiTaskHelper", "sync Read State %d", Integer.valueOf(i2));
        this.JwU = true;
        if (i2 == 0) {
            this.JwT = false;
            bPu();
            ai(null);
            AppMethodBeat.o(212034);
            return;
        }
        this.JwT = true;
        erc();
        AppMethodBeat.o(212034);
    }

    @Override // com.tencent.mm.plugin.multitask.b.a, com.tencent.mm.plugin.multitask.b.b
    public final void bPu() {
        AppMethodBeat.i(212035);
        try {
            this.IVb.edo = this.Jkg.coX();
            o.a gft = this.Jkg.gft();
            if (gft != null) {
                this.Abp.erh().title = gft.title;
                this.Abp.erh().MwR = gft.Jko;
                String str = this.Abp.erh().nickname;
                if (TextUtils.isEmpty(str)) {
                    str = gft.Jkn;
                }
                this.Abp.erh().nickname = str;
                this.IVb.coverUrl = gft.iAo;
            }
            String str2 = this.Abp.erh().title;
            if (TextUtils.isEmpty(str2)) {
                str2 = this.Jkg.getIntent().getStringExtra("webpageTitle");
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = this.Jkg.pGj.getTitle();
            }
            this.Abp.erh().title = str2;
            this.Abp.field_data = this.IVb.toByteArray();
            AppMethodBeat.o(212035);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.WebMultiTaskHelper", e2, "onMenuMultiTaskSelected", new Object[0]);
            AppMethodBeat.o(212035);
        }
    }

    @Override // com.tencent.mm.plugin.multitask.b.a, com.tencent.mm.plugin.multitask.b.c
    public final void G(int i2, String str) {
        AppMethodBeat.i(212036);
        this.JmJ = true;
        super.G(i2, str);
        if (!eqZ() && ((com.tencent.mm.plugin.brandservice.a.b) g.af(com.tencent.mm.plugin.brandservice.a.b.class)).ahv(this.Jkg.coX())) {
            this.Abp.field_id = com.tencent.mm.plugin.multitask.g.aGH(this.Jkg.coX());
            Log.i("MicroMsg.WebMultiTaskHelper", "isMpArticle, url: %s", this.Jkg.coX());
        }
        AppMethodBeat.o(212036);
    }

    @Override // com.tencent.mm.plugin.multitask.b.a, com.tencent.mm.plugin.multitask.b.b
    public final void ah(Bitmap bitmap) {
        AppMethodBeat.i(212037);
        if (this.JmJ) {
            super.ah(bitmap);
        }
        AppMethodBeat.o(212037);
    }

    @Override // com.tencent.mm.plugin.multitask.b.a
    public final void eqX() {
        AppMethodBeat.i(212038);
        if (this.JmJ) {
            super.eqX();
        }
        AppMethodBeat.o(212038);
    }

    @Override // com.tencent.mm.plugin.multitask.b.a, com.tencent.mm.plugin.multitask.b.c
    public final void dkj() {
        AppMethodBeat.i(212039);
        if (this.JmJ) {
            super.dkj();
        }
        AppMethodBeat.o(212039);
    }

    @Override // com.tencent.mm.plugin.multitask.b.a
    public final void ai(Bitmap bitmap) {
        AppMethodBeat.i(212040);
        if (this.JmJ) {
            super.ai(bitmap);
        }
        AppMethodBeat.o(212040);
    }

    @Override // com.tencent.mm.plugin.multitask.b.a
    public final void bCA() {
        AppMethodBeat.i(212041);
        super.bCA();
        if (!this.JmK) {
            this.JmK = true;
        }
        AppMethodBeat.o(212041);
    }

    @Override // com.tencent.mm.plugin.multitask.b.a
    public final void aGj() {
        AppMethodBeat.i(212042);
        super.aGj();
        this.JmK = false;
        AppMethodBeat.o(212042);
    }

    @Override // com.tencent.mm.plugin.multitask.b.a, com.tencent.mm.plugin.multitask.b.b
    public final boolean bPq() {
        AppMethodBeat.i(212043);
        boolean gbH = this.Jkg.gbH();
        AppMethodBeat.o(212043);
        return gbH;
    }

    public static void euA() {
        AppMethodBeat.i(212044);
        ((com.tencent.mm.plugin.taskbar.api.c) g.af(com.tencent.mm.plugin.taskbar.api.c.class)).a(2, JwV);
        AppMethodBeat.o(212044);
    }

    public static void euB() {
        AppMethodBeat.i(212045);
        ((com.tencent.mm.plugin.taskbar.api.c) g.af(com.tencent.mm.plugin.taskbar.api.c.class)).b(2, JwV);
        AppMethodBeat.o(212045);
    }

    public static boolean isMpUrl(String str) {
        AppMethodBeat.i(212046);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(212046);
            return false;
        } else if (str.startsWith(HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e20) + FilePathGenerator.ANDROID_DIR_SEP) || str.startsWith(HttpWrapperBase.PROTOCAL_HTTP + WeChatHosts.domainString(R.string.e20) + FilePathGenerator.ANDROID_DIR_SEP)) {
            AppMethodBeat.o(212046);
            return true;
        } else {
            AppMethodBeat.o(212046);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.multitask.b.a
    public final boolean dki() {
        return true;
    }

    public final void setRawUrl(String str) {
        this.IVb.edo = str;
    }

    public final int ghY() {
        return this.IVb.Nwi;
    }

    @Override // com.tencent.mm.plugin.multitask.b.a
    public final MultiTaskInfo era() {
        AppMethodBeat.i(212033);
        if (this.Abp == null || this.Abp.field_data == null) {
            AppMethodBeat.o(212033);
            return null;
        }
        Parcel obtain = Parcel.obtain();
        obtain.setDataPosition(0);
        this.Abp.writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        MultiTaskInfo createFromParcel = MultiTaskInfo.CREATOR.createFromParcel(obtain);
        createFromParcel.field_id = com.tencent.mm.plugin.multitask.g.aGG(((aa) g.af(aa.class)).fM(this.Jkg.coX()));
        AppMethodBeat.o(212033);
        return createFromParcel;
    }

    public final void ghZ() {
        AppMethodBeat.i(212047);
        if (this.AbC != null) {
            com.tencent.mm.plugin.multitask.animation.swipeahead.b bVar = this.AbC;
            Log.i("MicroMsg.FloatMultiTaskIndicatorController", "stop FloatIndicatorController");
            MMHandlerThread.postToMainThread(new b.c(bVar));
            bVar.Aak.a((a.AbstractC1499a) null);
        }
        AppMethodBeat.o(212047);
    }

    static /* synthetic */ void t(MultiTaskInfo multiTaskInfo) {
        AppMethodBeat.i(212048);
        fah fah = new fah();
        try {
            fah.parseFrom(multiTaskInfo.field_data);
            String str = multiTaskInfo.field_id;
            String str2 = fah.edo;
            Log.i("MicroMsg.WebMultiTaskHelper", "handleClicked, url:%s", str2);
            int i2 = fah.Nwt;
            Intent intent = new Intent();
            try {
                ach ach = new ach();
                ach.LmR = true;
                intent.putExtra("key_multi_task_common_info", ach.toByteArray());
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.WebMultiTaskHelper", e2, "onTaskBarItemClicked", new Object[0]);
            }
            com.tencent.mm.plugin.multitask.f.b.a(intent, fah);
            intent.putExtra("rawUrl", str2);
            intent.putExtra("minimize_secene", 0);
            intent.putExtra("float_ball_key", str);
            intent.putExtra("key_enable_teen_mode_check", true);
            intent.putExtra("webpageTitle", fah.title);
            if (i2 >= 0) {
                int i3 = fah.Nwo;
                int i4 = fah.Nwp;
                if (((com.tencent.mm.plugin.brandservice.a.b) g.af(com.tencent.mm.plugin.brandservice.a.b.class)).CR(i3) && ((com.tencent.mm.plugin.brandservice.a.b) g.af(com.tencent.mm.plugin.brandservice.a.b.class)).a(MMApplicationContext.getContext(), str2, i2, i3, i4, intent)) {
                    Log.i("MicroMsg.WebMultiTaskHelper", "openWebPage, use fast Load");
                    AppMethodBeat.o(212048);
                    return;
                }
            }
            com.tencent.mm.br.c.b(MMApplicationContext.getContext(), "webview", ".ui.tools.WebViewUI", intent);
            d dVar = d.JmQ;
            d.s(multiTaskInfo);
            AppMethodBeat.o(212048);
        } catch (Throwable th) {
            Log.e("MicroMsg.WebMultiTaskHelper", "WebMultiTaskData parse fail", th);
            AppMethodBeat.o(212048);
        }
    }
}
