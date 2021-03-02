package com.tencent.mm.plugin.emojicapture.b;

import android.app.ActivityManager;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.emoji.b.n;
import com.tencent.mm.media.b.c;
import com.tencent.mm.plugin.appbrand.jsapi.k.g;
import com.tencent.mm.plugin.emojicapture.model.e;
import com.tencent.mm.plugin.emojicapture.proxy.EmojiCaptureProxy;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.storage.ar;
import com.tencent.tavkit.component.TAVExporter;
import com.tencent.thumbplayer.core.common.TPCodecParamers;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\b\u0010\r\u001a\u00020\u000eH\u0002J\u0018\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0005H\u0014J\u0006\u0010\u0012\u001a\u00020\u000eJ\b\u0010\u0013\u001a\u00020\u0002H\u0016J\b\u0010\u0014\u001a\u00020\u000eH\u0016J\b\u0010\u0015\u001a\u00020\u000eH\u0002J\b\u0010\u0016\u001a\u00020\u000eH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/config/EmojiCameraElementConfig;", "Lcom/tencent/mm/media/config/SimpleElementConfig;", "Lcom/tencent/mm/plugin/emojicapture/config/EmojiCameraElementConfig$CameraPreviewConfig;", "()V", "CAPTURE_PREVIEW_SIZE_HIGH", "", "CAPTURE_PREVIEW_SIZE_LOW", "RECORDER_CAPTURE_RESOLUTION_1080P", "RECORDER_CAPTURE_RESOLUTION_720P", "TAG", "", "highPerformance", "", "checkHighPerformance", "", "getIntDynamicConfig", "key", "defValue", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "initDefaultConfig", "loadConfig", "setPreviewConfig", "setServerUseCpuCrop", "CameraPreviewConfig", "plugin-emojicapture_release"})
public final class a extends c<C0966a> {
    private static final String TAG = TAG;
    private static boolean rnY = true;
    public static final a rnZ = new a();

    static {
        AppMethodBeat.i(g.CTRL_INDEX);
        AppMethodBeat.o(g.CTRL_INDEX);
    }

    private a() {
    }

    @Override // com.tencent.mm.media.b.c
    public final void aLS() {
        C0966a aVar;
        boolean z = true;
        AppMethodBeat.i(132);
        ((C0966a) aLQ()).ilO = false;
        if (WeChatEnvironment.hasDebugger()) {
            if (MMApplicationContext.isMMProcess()) {
                aVar = (C0966a) aLQ();
                z = n.avh();
            } else {
                aVar = (C0966a) aLQ();
                EmojiCaptureProxy.a aVar2 = EmojiCaptureProxy.rrF;
                if (EmojiCaptureProxy.rrE.getInt(ar.a.USERINFO_EMOJI_SPRING_FESTIVAL_CROP_TYPE_INT, 1) != 0) {
                    z = false;
                }
            }
            aVar.ilO = z;
        }
        if (((C0966a) aLQ()).ilO) {
            ((C0966a) aLQ()).hzj = TAVExporter.VIDEO_EXPORT_WIDTH;
        } else {
            ((C0966a) aLQ()).hzj = 1080;
        }
        Log.i(TAG, "config resolution:" + ((C0966a) aLQ()).hzj + ", useCpuCrop:" + ((C0966a) aLQ()).ilO);
        AppMethodBeat.o(132);
    }

    @Override // com.tencent.mm.media.b.c
    public final int ab(String str, int i2) {
        AppMethodBeat.i(133);
        p.h(str, "key");
        if (MMApplicationContext.isMMProcess()) {
            com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class);
            p.g(af, "MMKernel.service<IConfig…onfigService::class.java)");
            int i3 = Util.getInt(((com.tencent.mm.plugin.zero.b.a) af).aqJ().getValue(str), i2);
            AppMethodBeat.o(133);
            return i3;
        }
        EmojiCaptureProxy.a aVar = EmojiCaptureProxy.rrF;
        int i4 = Util.getInt(EmojiCaptureProxy.rrE.getDynamicConfig(str), i2);
        AppMethodBeat.o(133);
        return i4;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001c\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J;\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001a\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001a\u0010\b\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015¨\u0006#"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/config/EmojiCameraElementConfig$CameraPreviewConfig;", "", "resolution", "", "useCpuCrop", "", "previewSize", "stickerSampleSize", "useCameraApi2", "(IZIIZ)V", "getPreviewSize", "()I", "setPreviewSize", "(I)V", "getResolution", "setResolution", "getStickerSampleSize", "setStickerSampleSize", "getUseCameraApi2", "()Z", "setUseCameraApi2", "(Z)V", "getUseCpuCrop", "setUseCpuCrop", "component1", "component2", "component3", "component4", "component5", "copy", "equals", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "", "plugin-emojicapture_release"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.b.a$a  reason: collision with other inner class name */
    public static final class C0966a {
        public int hzj;
        public boolean ilO;
        public int roa;
        int rob;
        private boolean roc;

        public final boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof C0966a) {
                    C0966a aVar = (C0966a) obj;
                    if (!(this.hzj == aVar.hzj && this.ilO == aVar.ilO && this.roa == aVar.roa && this.rob == aVar.rob && this.roc == aVar.roc)) {
                        return false;
                    }
                }
                return false;
            }
            return true;
        }

        public final int hashCode() {
            int i2 = 1;
            int i3 = this.hzj * 31;
            boolean z = this.ilO;
            if (z) {
                z = true;
            }
            int i4 = z ? 1 : 0;
            int i5 = z ? 1 : 0;
            int i6 = z ? 1 : 0;
            int i7 = (((((i4 + i3) * 31) + this.roa) * 31) + this.rob) * 31;
            boolean z2 = this.roc;
            if (!z2) {
                i2 = z2 ? 1 : 0;
            }
            return i7 + i2;
        }

        public final String toString() {
            AppMethodBeat.i(129);
            String str = "CameraPreviewConfig(resolution=" + this.hzj + ", useCpuCrop=" + this.ilO + ", previewSize=" + this.roa + ", stickerSampleSize=" + this.rob + ", useCameraApi2=" + this.roc + ")";
            AppMethodBeat.o(129);
            return str;
        }

        private C0966a() {
            this.hzj = 1080;
            this.ilO = false;
            this.roa = 640;
            this.rob = 1;
            this.roc = false;
        }

        public /* synthetic */ C0966a(byte b2) {
            this();
        }
    }

    public final void init() {
        boolean z = true;
        AppMethodBeat.i(130);
        bS(new C0966a((byte) 0));
        Object systemService = MMApplicationContext.getContext().getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        if (systemService == null) {
            t tVar = new t("null cannot be cast to non-null type android.app.ActivityManager");
            AppMethodBeat.o(130);
            throw tVar;
        }
        ActivityManager activityManager = (ActivityManager) systemService;
        int largeMemoryClass = activityManager.getLargeMemoryClass();
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        long j2 = (memoryInfo.totalMem / 1024) / 1024;
        int a2 = ((b) com.tencent.mm.kernel.g.af(b.class)).a(b.a.clicfg_emoji_high_mem_class, 512);
        int a3 = ((b) com.tencent.mm.kernel.g.af(b.class)).a(b.a.clicfg_emoji_high_total_mem, 2048);
        boolean z2 = d.oD(23) && largeMemoryClass >= a2 && j2 >= ((long) a3);
        rnY = z2;
        if (z2) {
            e eVar = e.roB;
            e.cJh();
        } else {
            e eVar2 = e.roB;
            e.cJi();
        }
        Log.i(TAG, "checkHighPerformance: device: " + largeMemoryClass + ", " + j2 + "; high: " + a2 + ", " + a3 + "; " + rnY);
        if (rnY) {
            ((C0966a) aLQ()).roa = ((b) com.tencent.mm.kernel.g.af(b.class)).a(b.a.clicfg_emoji_high_preview_size, 640);
            ((C0966a) aLQ()).rob = ((b) com.tencent.mm.kernel.g.af(b.class)).a(b.a.clicfg_emoji_high_sample_size, 1);
        } else {
            ((C0966a) aLQ()).roa = ((b) com.tencent.mm.kernel.g.af(b.class)).a(b.a.clicfg_emoji_low_preview_size, 480);
            ((C0966a) aLQ()).rob = ((b) com.tencent.mm.kernel.g.af(b.class)).a(b.a.clicfg_emoji_low_sample_size, 1);
        }
        int i2 = ae.gKA.gJc;
        int i3 = ae.gKA.gJd;
        if (i2 != -1) {
            Log.i(TAG, "setPreviewConfig: use device preview ".concat(String.valueOf(i2)));
            ((C0966a) aLQ()).roa = i2;
        }
        if (i3 != -1) {
            Log.i(TAG, "setPreviewConfig: use device sample size ".concat(String.valueOf(i3)));
            ((C0966a) aLQ()).rob = i3;
        }
        Log.i(TAG, "setPreviewConfig: " + ((C0966a) aLQ()).roa + ", " + ((C0966a) aLQ()).rob);
        boolean z3 = ab("VideoRecordUseCpuCrop", 0) == 1;
        int i4 = ae.gKB.gJa;
        Log.i(TAG, "setServerUseCpuCrop, serverConfigUseCpuCrop:" + z3 + ", deviceConfigUseCpuCrop:" + i4);
        if (z3) {
            ((C0966a) aLQ()).ilO = true;
        }
        if (i4 != -1) {
            C0966a aVar = (C0966a) aLQ();
            if (i4 != 1) {
                z = false;
            }
            aVar.ilO = z;
        }
        Log.i(TAG, "final set useCpuCrop:" + ((C0966a) aLQ()).ilO);
        AppMethodBeat.o(130);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.tencent.mm.media.b.c
    public final /* synthetic */ C0966a aLR() {
        AppMethodBeat.i(TPCodecParamers.TP_PROFILE_MPEG2_AAC_HE);
        C0966a aVar = new C0966a((byte) 0);
        AppMethodBeat.o(TPCodecParamers.TP_PROFILE_MPEG2_AAC_HE);
        return aVar;
    }
}
