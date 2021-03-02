package com.tencent.mm.plugin.emojicapture.model;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.emoji.b.k;
import com.tencent.mm.emoji.b.n;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.appbrand.jsapi.p.z;
import com.tencent.mm.plugin.emojicapture.api.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.xlabeffect.e;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.widget.a.d;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 (2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001(B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0011H\u0002J\b\u0010\u0018\u001a\u00020\tH\u0016J\b\u0010\u0019\u001a\u00020\u0006H\u0016J\u0012\u0010\u001a\u001a\u00020\u00112\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0011H\u0016J\u0010\u0010\u001e\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J \u0010\u001f\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J \u0010\"\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020$H\u0016J \u0010%\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020$H\u0016J\b\u0010'\u001a\u00020!H\u0016R\u0010\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0004\n\u0002\b\u0007R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006)"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/model/PluginEmojiCapture;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/emojicapture/api/IPluginEmojiCapture;", "Lcom/tencent/mm/kernel/api/ICoreAccountCallback;", "()V", "TAG", "", "TAG$1", "isInit", "", "()Z", "setInit", "(Z)V", "cameraCheck", "context", "Landroid/content/Context;", "execute", "", Scopes.PROFILE, "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "firstOpenCheck", "onResult", "Lcom/tencent/mm/plugin/emojicapture/api/IPluginEmojiCapture$CheckCallback;", "initCheck", "isStickerEnable", "name", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "overSizeCheck", "preCheck", "scene", "", "prepareEmojiCapture", "lensIdWithUrl", "Lcom/tencent/mm/plugin/emojicapture/api/IPluginEmojiCapture$PrepareStickerCallback;", "prepareStickerPreview", "url", "stickerRecommendCount", "Companion", "plugin-emojicapture_release"})
public final class PluginEmojiCapture extends f implements com.tencent.mm.kernel.api.c, com.tencent.mm.plugin.emojicapture.api.a {
    private static final String TAG = TAG;
    private static final int roD = roD;
    private static final String roE = roE;
    private static final String roF = roF;
    private static final String roG = roG;
    private static final String roH = roH;
    public static final a roI = new a((byte) 0);
    private final String gVB = "MicroMsg.PluginEmojiCapture";
    private boolean isInit;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/model/PluginEmojiCapture$Companion;", "", "()V", "MIN_STORAGE_SIZE", "", "getMIN_STORAGE_SIZE", "()I", "TAG", "", "VIDEO_LUT_FILE_DIR", "getVIDEO_LUT_FILE_DIR", "()Ljava/lang/String;", "YT_FILE_ROOT_DIR", "getYT_FILE_ROOT_DIR", "YT_MODEL_BACKUP_FILE_DIR", "getYT_MODEL_BACKUP_FILE_DIR", "YT_MODEL_FILE_DIR", "getYT_MODEL_FILE_DIR", "plugin-emojicapture_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(203);
        AppMethodBeat.o(203);
    }

    public final boolean isInit() {
        return this.isInit;
    }

    public final void setInit(boolean z) {
        this.isInit = z;
    }

    @Override // com.tencent.mm.kernel.a.c.b, com.tencent.mm.kernel.b.f
    public final String name() {
        return "plugin-emojicapture";
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public final void execute(g gVar) {
        AppMethodBeat.i(193);
        Log.i(this.gVB, "Plugin EmojiCapture Execute");
        if (MMApplicationContext.isMainProcess()) {
            e eVar = e.JRF;
            e.glw();
            e eVar2 = e.JRF;
            e.hXZ();
        }
        Boolean valueOf = gVar != null ? Boolean.valueOf(gVar.FY(":tools")) : null;
        if (valueOf == null) {
            p.hyc();
        }
        if (valueOf.booleanValue()) {
            initCheck();
        }
        AppMethodBeat.o(193);
    }

    private final void initCheck() {
        if (!this.isInit) {
            this.isInit = true;
        }
    }

    @Override // com.tencent.mm.plugin.emojicapture.api.a
    public final void preCheck(Context context, int i2, a.AbstractC0965a aVar) {
        AppMethodBeat.i(194);
        p.h(context, "context");
        p.h(aVar, "onResult");
        com.tencent.mm.aq.b.bby();
        com.tencent.mm.aq.b.bbA();
        if (!cameraCheck(context) || !overSizeCheck(context)) {
            aVar.ha(false);
            AppMethodBeat.o(194);
        } else if (i2 != 2) {
            aVar.ha(true);
            AppMethodBeat.o(194);
        } else {
            firstOpenCheck(context, aVar);
            AppMethodBeat.o(194);
        }
    }

    @Override // com.tencent.mm.plugin.emojicapture.api.a
    public final boolean isStickerEnable() {
        AppMethodBeat.i(195);
        boolean isStickerEnable = n.isStickerEnable();
        AppMethodBeat.o(195);
        return isStickerEnable;
    }

    @Override // com.tencent.mm.plugin.emojicapture.api.a
    public final int stickerRecommendCount() {
        AppMethodBeat.i(174297);
        int stickerRecommendCount = n.stickerRecommendCount();
        AppMethodBeat.o(174297);
        return stickerRecommendCount;
    }

    @Override // com.tencent.mm.plugin.emojicapture.api.a
    public final void prepareStickerPreview(Context context, String str, a.b bVar) {
        AppMethodBeat.i(196);
        p.h(context, "context");
        p.h(str, "url");
        p.h(bVar, "onResult");
        new b(context, str, bVar);
        AppMethodBeat.o(196);
    }

    @Override // com.tencent.mm.plugin.emojicapture.api.a
    public final void prepareEmojiCapture(Context context, String str, a.b bVar) {
        AppMethodBeat.i(197);
        p.h(context, "context");
        p.h(str, "lensIdWithUrl");
        p.h(bVar, "onResult");
        new a(context, str, bVar);
        AppMethodBeat.o(197);
    }

    @Override // com.tencent.mm.kernel.api.c
    public final void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(z.CTRL_INDEX);
        Log.i(this.gVB, "onAccountInitialized: ");
        com.tencent.mm.pluginsdk.cmd.b.a(new c(), "//emojicapture");
        AppMethodBeat.o(z.CTRL_INDEX);
    }

    @Override // com.tencent.mm.kernel.api.c
    public final void onAccountRelease() {
        AppMethodBeat.i(199);
        Log.i(this.gVB, "onAccountRelease: ");
        com.tencent.mm.pluginsdk.cmd.b.V("//emojicapture");
        AppMethodBeat.o(199);
    }

    private final void firstOpenCheck(Context context, a.AbstractC0965a aVar) {
        AppMethodBeat.i(200);
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        p.g(aAh, "MMKernel.storage()");
        Object i2 = aAh.azQ().i(ar.a.USERINFO_EMOJI_CAPTURE_OPENED_BOOLEAN);
        if (i2 == null || !(i2 instanceof Boolean) || !((Boolean) i2).booleanValue()) {
            com.tencent.mm.aq.b bby = com.tencent.mm.aq.b.bby();
            p.g(bby, "FontResLogic.getInstance()");
            if (!bby.bbz()) {
                h.INSTANCE.F(933, 2);
            }
            new d.a(context).aoO(R.string.bmp).b(BitmapFactory.decodeResource(context.getResources(), R.drawable.emoji_capture_first_open_notice), false, 0).aoS(R.string.bmo).aoV(R.string.bmm).a(new b(aVar)).hbn().show();
            com.tencent.mm.kernel.e aAh2 = com.tencent.mm.kernel.g.aAh();
            p.g(aAh2, "MMKernel.storage()");
            aAh2.azQ().set(ar.a.USERINFO_EMOJI_CAPTURE_OPENED_BOOLEAN, Boolean.TRUE);
            Log.i(this.gVB, "first open check false");
            AppMethodBeat.o(200);
            return;
        }
        aVar.ha(true);
        AppMethodBeat.o(200);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
    public static final class b implements DialogInterface.OnDismissListener {
        final /* synthetic */ a.AbstractC0965a roJ;

        b(a.AbstractC0965a aVar) {
            this.roJ = aVar;
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.i(191);
            this.roJ.ha(true);
            AppMethodBeat.o(191);
        }
    }

    private final boolean overSizeCheck(Context context) {
        AppMethodBeat.i(201);
        k kVar = k.gXr;
        if (k.auQ()) {
            new d.a(context).aoO(R.string.bmt).aoS(R.string.bms).aoV(R.string.bmr).c(new c(context)).aoW(R.string.bmq).hbn().show();
            Log.i(this.gVB, "over size check false");
            AppMethodBeat.o(201);
            return false;
        }
        AppMethodBeat.o(201);
        return true;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
    public static final class c implements DialogInterface.OnClickListener {
        final /* synthetic */ Context $context;

        c(Context context) {
            this.$context = context;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AppMethodBeat.i(192);
            Intent intent = new Intent();
            intent.putExtra("key_emoji_panel_type", 1);
            com.tencent.mm.br.c.b(this.$context, "emoji", ".ui.EmojiCustomUI", intent);
            AppMethodBeat.o(192);
        }
    }

    private final boolean cameraCheck(Context context) {
        AppMethodBeat.i(202);
        if (com.tencent.mm.plugin.voip.f.hy(context) || com.tencent.mm.plugin.voip.f.cC(context) || com.tencent.mm.bh.e.cA(context) || com.tencent.mm.q.a.cD(context)) {
            Log.i(this.gVB, "camera check false");
            AppMethodBeat.o(202);
            return false;
        }
        AppMethodBeat.o(202);
        return true;
    }
}
