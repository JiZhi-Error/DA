package com.tencent.mm.plugin.story.c.a;

import android.app.ActivityManager;
import android.graphics.Point;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.plugin.story.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.storage.ar;
import com.tencent.tavkit.component.TAVExporter;
import com.tencent.tavkit.component.TAVPlayer;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001%B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0002H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u001bH\u0016J\b\u0010\u001d\u001a\u00020\u001bH\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020\u001bH\u0002J\u0006\u0010!\u001a\u00020\u001bJ\b\u0010\"\u001a\u00020\u001bH\u0002J\b\u0010#\u001a\u00020\u001fH\u0002J\b\u0010$\u001a\u00020\u001bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016XT¢\u0006\u0002\n\u0000¨\u0006&"}, hxF = {"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryCameraElementConfig;", "Lcom/tencent/mm/plugin/story/config/StoryElementConfig;", "Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryCameraElementConfig$CameraPreviewConfig;", "()V", "CPU_CROP_AVAILABLE", "", "CPU_CROP_MMKV_KEY", "", "CPU_CROP_NOT_AVAILABLE", "RECORDER_CAPTURE_RESOLUTION_1080P", "RECORDER_CAPTURE_RESOLUTION_540P", "RECORDER_CAPTURE_RESOLUTION_720P", "RESOLUTION", "StoryCameraUseApi1", "StoryCameraUseApi2", "StoryCropSizeWithCPU", "StoryCropSizeWithGPU", "TAG", "USECPUCROP", "USE_HIGHEST_RESOLUTION_MEMORYCLASS_LIMIT_MB", "USE_HIGHEST_RESOLUTION_MEMORY_LIMIT_MB", "USE_HIGHEST_RESOLUTION_MEMORY_LIMIT_MB_BUFFER", "", "getElementName", "Lcom/tencent/mm/plugin/story/config/StoryConfigConstant$ElementName;", "initDefaultConfig", "loadCameraApiConfig", "", "loadConfig", "loadCropTypeConfig", "loadDeviceResolutionConfig", "", "loadResolutionConfig", "markCpuCropNotAvailable", "setServerUseCpuCrop", "tryUse1080Preview", "use720Preview", "CameraPreviewConfig", "plugin-story_release"})
public final class b extends com.tencent.mm.plugin.story.c.b<a> {
    public static final b FkY = new b();

    static {
        AppMethodBeat.i(118584);
        AppMethodBeat.o(118584);
    }

    private b() {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J'\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000f¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryCameraElementConfig$CameraPreviewConfig;", "", "resolution", "", "useCpuCrop", "", "useCameraApi2", "(IZZ)V", "getResolution", "()I", "setResolution", "(I)V", "getUseCameraApi2", "()Z", "setUseCameraApi2", "(Z)V", "getUseCpuCrop", "setUseCpuCrop", "component1", "component2", "component3", "copy", "equals", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "", "plugin-story_release"})
    public static final class a {
        int hzj;
        boolean ilO;
        boolean roc;

        public final boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof a) {
                    a aVar = (a) obj;
                    if (!(this.hzj == aVar.hzj && this.ilO == aVar.ilO && this.roc == aVar.roc)) {
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
            int i7 = (i4 + i3) * 31;
            boolean z2 = this.roc;
            if (!z2) {
                i2 = z2 ? 1 : 0;
            }
            return i7 + i2;
        }

        public final String toString() {
            AppMethodBeat.i(118581);
            String str = "CameraPreviewConfig(resolution=" + this.hzj + ", useCpuCrop=" + this.ilO + ", useCameraApi2=" + this.roc + ")";
            AppMethodBeat.o(118581);
            return str;
        }

        private a() {
            this.hzj = TAVExporter.VIDEO_EXPORT_WIDTH;
            this.ilO = false;
            this.roc = false;
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.media.b.c
    public final /* synthetic */ Object aLR() {
        AppMethodBeat.i(118582);
        a aVar = new a((byte) 0);
        AppMethodBeat.o(118582);
        return aVar;
    }

    @Override // com.tencent.mm.media.b.c
    public final void aLS() {
        boolean z;
        boolean z2;
        int i2;
        boolean z3;
        boolean z4;
        boolean z5 = true;
        AppMethodBeat.i(118583);
        a aVar = (a) aLQ();
        e aAh = g.aAh();
        p.g(aAh, "MMKernel.storage()");
        if (aAh.azQ().getInt(ar.a.USERINFO_TOP_STORY_CAMERA_API_INT, 2) == 2) {
            z = true;
        } else {
            z = false;
        }
        aVar.roc = z;
        Log.i("MicroMsg.StoryCameraElementConfig", "cameraPreviewConfig.useCameraApi2 debug : " + ((a) aLQ()).roc);
        boolean z6 = ab("VideoRecordUseCpuCrop", 0) == 1;
        int i3 = ae.gKB.gJa;
        Log.i("MicroMsg.StoryCameraElementConfig", "setServerUseCpuCrop, serverConfigUseCpuCrop:" + z6 + ", deviceConfigUseCpuCrop:" + i3 + ", localCpuCropConfig:" + MultiProcessMMKV.getMMKV(a.b.MODEL_STORY.name()).getInt("use_cpu_crop", 0));
        if (z6) {
            ((a) aLQ()).ilO = true;
        }
        if (i3 != -1) {
            a aVar2 = (a) aLQ();
            if (i3 == 1) {
                z4 = true;
            } else {
                z4 = false;
            }
            aVar2.ilO = z4;
        }
        Log.i("MicroMsg.StoryCameraElementConfig", "final set useCpuCrop:" + ((a) aLQ()).ilO);
        if (WeChatEnvironment.hasDebugger()) {
            a aVar3 = (a) aLQ();
            e aAh2 = g.aAh();
            p.g(aAh2, "MMKernel.storage()");
            if (aAh2.azQ().getInt(ar.a.USERINFO_TOP_STORY_CROP_TYPE_INT, 2) == 1) {
                z3 = true;
            } else {
                z3 = false;
            }
            aVar3.ilO = z3;
            Log.i("MicroMsg.StoryCameraElementConfig", "cameraPreviewConfig.useCpuCrop debug : " + ((a) aLQ()).ilO);
        }
        if (ae.gKB.gIW != -1) {
            a aVar4 = (a) aLQ();
            switch (ae.gKB.gIW) {
                case 2:
                case 4:
                case 5:
                case 6:
                    i2 = 720;
                    break;
                case 3:
                    if (!((a) aLQ()).ilO) {
                        i2 = 720;
                        break;
                    } else {
                        i2 = TAVPlayer.VIDEO_PLAYER_WIDTH;
                        break;
                    }
                default:
                    i2 = 1080;
                    break;
            }
            aVar4.hzj = i2;
            Log.i("MicroMsg.StoryCameraElementConfig", "loadDeviceResolutionConfig " + ((a) aLQ()).hzj + "  value " + ae.gKB.gIW);
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            Point ejr = d.ejr();
            int ab = ab("Sight1080pRecordMinApiLevel", 19);
            Log.i("MicroMsg.StoryCameraElementConfig", "record1080pApiLevel: " + ab + "  screenSize x " + ejr.x + " y " + ejr.y);
            Object systemService = MMApplicationContext.getContext().getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME);
            if (systemService == null) {
                t tVar = new t("null cannot be cast to non-null type android.app.ActivityManager");
                AppMethodBeat.o(118583);
                throw tVar;
            }
            int largeMemoryClass = ((ActivityManager) systemService).getLargeMemoryClass();
            double gy = (double) d.gy(MMApplicationContext.getContext());
            if ((ae.gKB.gIV == -1 || (ae.gKB.gIV & 1) != 0) && com.tencent.mm.compatible.util.d.oD(ab) && largeMemoryClass >= 512 && gy >= 1725.0d && Math.min(ejr.x, ejr.y) >= 1080) {
                ((a) aLQ()).hzj = 1080;
            } else {
                Log.i("MicroMsg.StoryCameraElementConfig", "currentRecorderCaptureResolution is :" + ((a) aLQ()) + ".resolution");
                z5 = false;
            }
            if (!z5) {
                ((a) aLQ()).hzj = TAVExporter.VIDEO_EXPORT_WIDTH;
            }
        }
        AppMethodBeat.o(118583);
    }
}
