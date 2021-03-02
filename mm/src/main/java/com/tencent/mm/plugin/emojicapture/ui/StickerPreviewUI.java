package com.tencent.mm.plugin.emojicapture.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.emojicapture.proxy.EmojiCaptureProxy;
import com.tencent.mm.plugin.emojicapture.ui.preview.StickerPreviewView;
import com.tencent.mm.plugin.mmsight.model.k;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sticker.loader.e;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.statusbar.d;
import com.tencent.smtt.sdk.TbsListener;
import kotlin.g.b.p;
import kotlin.l;

@com.tencent.mm.ui.base.a(3)
@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0014J\b\u0010\f\u001a\u00020\tH\u0002J\u0012\u0010\r\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0010\u001a\u00020\tH\u0014J\b\u0010\u0011\u001a\u00020\tH\u0014J\b\u0010\u0012\u001a\u00020\tH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/ui/StickerPreviewUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "TAG", "", "stickerPreview", "Lcom/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewView;", "stickerUrl", "finish", "", "getLayoutId", "", "initOnCreateAfterConnected", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "plugin-emojicapture_release"})
public final class StickerPreviewUI extends MMActivity {
    private final String TAG = "MicroMsg.StickerPreviewUI";
    private StickerPreviewView rsA;
    private String rsz;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(512);
        overridePendingTransition(R.anim.p, -1);
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            window.addFlags(134217728);
        }
        setActionbarColor(0);
        updateBackBtn(getDrawable(R.raw.actionbar_icon_light_close));
        d.e(getWindow());
        setBackBtn(new b(this));
        setMMTitle(R.string.hey);
        this.rsz = getIntent().getStringExtra("sticker_url");
        k.ejI();
        EmojiCaptureProxy.a aVar = EmojiCaptureProxy.rrF;
        EmojiCaptureProxy.a.cJA();
        EmojiCaptureProxy.a aVar2 = EmojiCaptureProxy.rrF;
        com.tencent.mm.remoteservice.d serverProxy = EmojiCaptureProxy.rrE.getServerProxy();
        if (serverProxy != null) {
            serverProxy.connect(new c(this));
            AppMethodBeat.o(512);
            return;
        }
        AppMethodBeat.o(512);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class b implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ StickerPreviewUI rsB;

        b(StickerPreviewUI stickerPreviewUI) {
            this.rsB = stickerPreviewUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(510);
            this.rsB.finish();
            AppMethodBeat.o(510);
            return true;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class c implements Runnable {
        final /* synthetic */ StickerPreviewUI rsB;

        c(StickerPreviewUI stickerPreviewUI) {
            this.rsB = stickerPreviewUI;
        }

        public final void run() {
            AppMethodBeat.i(TbsListener.ErrorCode.INFO_CODE_FILEREADER_OPENFILEREADER_MINIQBFAILED);
            StickerPreviewUI.a(this.rsB);
            AppMethodBeat.o(TbsListener.ErrorCode.INFO_CODE_FILEREADER_OPENFILEREADER_MINIQBFAILED);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032,\u0010\u0004\u001a(\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006 \u0007*\u0014\u0012\u000e\b\u0001\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\u00050\u00052\u000e\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\t0\tH\n¢\u0006\u0004\b\n\u0010\u000b"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "", "", "kotlin.jvm.PlatformType", "results", "", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V"})
    public static final class a implements com.tencent.mm.pluginsdk.permission.c {
        final /* synthetic */ StickerPreviewUI rsB;

        a(StickerPreviewUI stickerPreviewUI) {
            this.rsB = stickerPreviewUI;
        }

        @Override // com.tencent.mm.pluginsdk.permission.c
        public final void b(int i2, int[] iArr) {
            boolean z;
            boolean z2 = true;
            AppMethodBeat.i(256436);
            p.g(iArr, "results");
            int length = iArr.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    z2 = false;
                    break;
                }
                if (iArr[i3] != 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    break;
                }
                i3++;
            }
            if (z2) {
                Log.w(this.rsB.TAG, "request permission: not granted");
                this.rsB.finish();
            }
            AppMethodBeat.o(256436);
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.byu;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onPause() {
        AppMethodBeat.i(513);
        super.onPause();
        StickerPreviewView stickerPreviewView = this.rsA;
        if (stickerPreviewView != null) {
            stickerPreviewView.rtc.stopPreview();
            AppMethodBeat.o(513);
            return;
        }
        AppMethodBeat.o(513);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onResume() {
        AppMethodBeat.i(514);
        super.onResume();
        StickerPreviewView stickerPreviewView = this.rsA;
        if (stickerPreviewView != null) {
            stickerPreviewView.onResume();
            AppMethodBeat.o(514);
            return;
        }
        AppMethodBeat.o(514);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(515);
        super.onDestroy();
        StickerPreviewView stickerPreviewView = this.rsA;
        if (stickerPreviewView != null) {
            e eVar = e.NNN;
            e.b(stickerPreviewView.rxg);
            AppMethodBeat.o(515);
            return;
        }
        AppMethodBeat.o(515);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public final void finish() {
        AppMethodBeat.i(com.tencent.mm.plugin.appbrand.jsapi.openvoice.c.CTRL_INDEX);
        super.finish();
        overridePendingTransition(-1, R.anim.q);
        AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.openvoice.c.CTRL_INDEX);
    }

    public static final /* synthetic */ void a(StickerPreviewUI stickerPreviewUI) {
        StickerPreviewView stickerPreviewView;
        AppMethodBeat.i(com.tencent.mm.plugin.appbrand.jsapi.openvoice.a.CTRL_INDEX);
        stickerPreviewUI.rsA = (StickerPreviewView) stickerPreviewUI.findViewById(R.id.i62);
        String str = stickerPreviewUI.rsz;
        if (!(str == null || (stickerPreviewView = stickerPreviewUI.rsA) == null)) {
            stickerPreviewView.setStickerUrl(str);
        }
        if (com.tencent.mm.pluginsdk.permission.b.e(stickerPreviewUI, "android.permission.CAMERA")) {
            StickerPreviewView stickerPreviewView2 = stickerPreviewUI.rsA;
            if (stickerPreviewView2 != null) {
                stickerPreviewView2.onResume();
                AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.openvoice.a.CTRL_INDEX);
                return;
            }
            AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.openvoice.a.CTRL_INDEX);
            return;
        }
        Log.i(stickerPreviewUI.TAG, "initOnCreateAfterConnected: no permission");
        com.tencent.mm.pluginsdk.permission.b.a(new a(stickerPreviewUI), "android.permission.CAMERA");
        AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.openvoice.a.CTRL_INDEX);
    }
}
