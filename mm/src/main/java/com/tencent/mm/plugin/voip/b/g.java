package com.tencent.mm.plugin.voip.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.media.k.d;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\tH\u0007J\b\u0010\n\u001a\u00020\u0006H\u0007J\b\u0010\u000b\u001a\u00020\u0006H\u0002J\u0006\u0010\f\u001a\u00020\u0006J\u0006\u0010\r\u001a\u00020\u0006J\b\u0010\u000e\u001a\u00020\u0006H\u0007J\b\u0010\u000f\u001a\u00020\u0006H\u0007J\b\u0010\u0010\u001a\u00020\u0006H\u0007J\b\u0010\u0011\u001a\u00020\u0006H\u0007J\b\u0010\u0012\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/voip/util/VoipRendererHelper;", "", "()V", "TAG", "", "checkPermissionByGpuInfo", "", "remoteInfo", "getXSettingVoipBeautyValue", "", "isAllowToUseFaceBeauty", "isNotAllowToUseFaceBeautyByGPUInfo", "isUseGpuCrop", "isUseGpuRgb2Yuv", "isUseNewCameraModular", "isUseNewVoipRenderer", "isUseRemovePreviewCallback", "isVoipUseCameraApi2", "isXSettingAllowToCheckGpu", "plugin-voip_release"})
public final class g {
    public static final g HgZ = new g();

    static {
        AppMethodBeat.i(236080);
        AppMethodBeat.o(236080);
    }

    private g() {
    }

    public static final boolean fKe() {
        AppMethodBeat.i(236070);
        switch (ae.gKE.gHk) {
            case -1:
                if (BuildInfo.IS_FLAVOR_RED) {
                    AppMethodBeat.o(236070);
                    return true;
                }
                boolean a2 = ((b) com.tencent.mm.kernel.g.af(b.class)).a(b.a.clicfg_voip_newrenderer_switch_new, false);
                AppMethodBeat.o(236070);
                return a2;
            case 0:
            default:
                boolean a3 = ((b) com.tencent.mm.kernel.g.af(b.class)).a(b.a.clicfg_voip_newrenderer_switch_new, false);
                AppMethodBeat.o(236070);
                return a3;
            case 1:
                AppMethodBeat.o(236070);
                return true;
            case 2:
                AppMethodBeat.o(236070);
                return false;
        }
    }

    public static final boolean fKf() {
        AppMethodBeat.i(236071);
        switch (ae.gKE.gHo) {
            case -1:
                if (com.tencent.mm.media.widget.d.b.rG(12)) {
                    AppMethodBeat.o(236071);
                    return true;
                } else if (BuildInfo.IS_FLAVOR_RED || BuildInfo.DEBUG) {
                    AppMethodBeat.o(236071);
                    return true;
                } else {
                    AppMethodBeat.o(236071);
                    return false;
                }
            case 0:
            default:
                AppMethodBeat.o(236071);
                return false;
            case 1:
                AppMethodBeat.o(236071);
                return true;
            case 2:
                AppMethodBeat.o(236071);
                return false;
        }
    }

    public static final boolean fKg() {
        AppMethodBeat.i(236072);
        if (!fKh() || !fKf()) {
            switch (ae.gKE.gHn) {
                case -1:
                    if (BuildInfo.IS_FLAVOR_RED || BuildInfo.DEBUG) {
                        AppMethodBeat.o(236072);
                        return true;
                    }
                    boolean a2 = ((b) com.tencent.mm.kernel.g.af(b.class)).a(b.a.clicfg_voip_newrenderer_remove_previewcallback, false);
                    AppMethodBeat.o(236072);
                    return a2;
                case 0:
                default:
                    boolean a3 = ((b) com.tencent.mm.kernel.g.af(b.class)).a(b.a.clicfg_voip_newrenderer_remove_previewcallback, false);
                    AppMethodBeat.o(236072);
                    return a3;
                case 1:
                    AppMethodBeat.o(236072);
                    return true;
                case 2:
                    AppMethodBeat.o(236072);
                    return false;
            }
        } else {
            AppMethodBeat.o(236072);
            return true;
        }
    }

    public static final boolean fKh() {
        AppMethodBeat.i(236073);
        switch (ae.gKE.gHp) {
            case -1:
                if (BuildInfo.IS_FLAVOR_RED || BuildInfo.DEBUG) {
                    AppMethodBeat.o(236073);
                    return true;
                }
                boolean a2 = ((b) com.tencent.mm.kernel.g.af(b.class)).a(b.a.clicfg_voip_use_new_camera_modular, false);
                AppMethodBeat.o(236073);
                return a2;
            case 0:
            default:
                boolean a3 = ((b) com.tencent.mm.kernel.g.af(b.class)).a(b.a.clicfg_voip_use_new_camera_modular, false);
                AppMethodBeat.o(236073);
                return a3;
            case 1:
                AppMethodBeat.o(236073);
                return true;
            case 2:
                AppMethodBeat.o(236073);
                return false;
        }
    }

    public static boolean fKi() {
        AppMethodBeat.i(236074);
        switch (ae.gKE.gHq) {
            case 1:
                AppMethodBeat.o(236074);
                return true;
            case 2:
                AppMethodBeat.o(236074);
                return false;
            default:
                if (BuildInfo.IS_FLAVOR_RED) {
                    AppMethodBeat.o(236074);
                    return true;
                } else if (fKj() || ((b) com.tencent.mm.kernel.g.af(b.class)).a(b.a.clicfg_voip_newrenderer_switch_gpu_rgb2yuv, false)) {
                    AppMethodBeat.o(236074);
                    return true;
                } else {
                    AppMethodBeat.o(236074);
                    return false;
                }
        }
    }

    public static boolean fKj() {
        AppMethodBeat.i(236075);
        switch (ae.gKE.gHr) {
            case 1:
                AppMethodBeat.o(236075);
                return true;
            case 2:
                AppMethodBeat.o(236075);
                return false;
            default:
                if (BuildInfo.IS_FLAVOR_RED) {
                    AppMethodBeat.o(236075);
                    return true;
                }
                boolean a2 = ((b) com.tencent.mm.kernel.g.af(b.class)).a(b.a.clicfg_voip_newrenderer_switch_gpu_crop, false);
                AppMethodBeat.o(236075);
                return a2;
        }
    }

    public static final int fKk() {
        AppMethodBeat.i(236076);
        int a2 = ((b) com.tencent.mm.kernel.g.af(b.class)).a(b.a.clicfg_voip_xsetting_beauty_value, 1);
        AppMethodBeat.o(236076);
        return a2;
    }

    private static boolean fKm() {
        boolean z;
        AppMethodBeat.i(236078);
        String a2 = ((b) com.tencent.mm.kernel.g.af(b.class)).a(b.a.clicfg_voip_facebeauty_gpu_blacklist, "");
        p.g(a2, "remoteRatingLimited");
        boolean z2 = false;
        for (T t : n.a((CharSequence) a2, new char[]{';'})) {
            if (z2) {
                AppMethodBeat.o(236078);
                return true;
            } else if (!Util.isNullOrNil((String) t)) {
                try {
                    z2 = aUC(t);
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.VoipRendererHelper", e2, "isNotAllowToUseFaceBeautyByGPUInfo error", new Object[0]);
                    z = false;
                }
            } else {
                z = z2;
                z2 = z;
            }
        }
        AppMethodBeat.o(236078);
        return z2;
    }

    private static boolean aUC(String str) {
        boolean z = true;
        AppMethodBeat.i(236079);
        i iVar = new i(str);
        int optInt = iVar.optInt(TMQQDownloaderOpenSDKConst.UINTYPE_CODE);
        Log.i("MicroMsg.VoipRendererHelper", "gpu faceBeauty black list is ".concat(String.valueOf(str)));
        String aNf = d.ilx.aNf();
        if (!Util.isNullOrNil(aNf)) {
            try {
                i iVar2 = new i(aNf);
                if (optInt != 0) {
                    if (optInt != iVar2.optInt(TMQQDownloaderOpenSDKConst.UINTYPE_CODE)) {
                        z = false;
                    }
                    if (z) {
                        Log.i("MicroMsg.VoipRendererHelper", new StringBuilder("code is fit true cause code fit").toString());
                    }
                } else {
                    if (!p.j(iVar.optString("vendor"), iVar2.optString("vendor")) || !p.j(iVar.optString("name"), iVar2.optString("name")) || !p.j(iVar.optString("version"), iVar2.optString("version"))) {
                        z = false;
                    }
                    if (z) {
                        Log.i("MicroMsg.VoipRendererHelper", new StringBuilder("code is fit true cause name and vendor and version fit").toString());
                    }
                }
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.VoipRendererHelper", e2, "checkPermissionByGpuInfo error", new Object[0]);
                z = false;
            }
            AppMethodBeat.o(236079);
            return z;
        }
        AppMethodBeat.o(236079);
        return false;
    }

    public static final boolean fKl() {
        AppMethodBeat.i(236077);
        if (((b) com.tencent.mm.kernel.g.af(b.class)).a(b.a.clicfg_voip_xsetting_allow_checkgpu, false) && !fKm()) {
            int aNe = d.ilx.aNe();
            int a2 = ((b) com.tencent.mm.kernel.g.af(b.class)).a(b.a.clicfg_voip_facebeauty_gpu_rating_limited, 50);
            Log.i("MicroMsg.VoipRendererHelper", "gpu info rating is " + aNe + " and remote limited is " + a2);
            if (aNe >= a2) {
                AppMethodBeat.o(236077);
                return true;
            }
        }
        AppMethodBeat.o(236077);
        return false;
    }
}
