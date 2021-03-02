package com.tencent.mm.plugin.recordvideo.b;

import android.app.ActivityManager;
import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.plugin.mmsight.model.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.tavkit.component.TAVExporter;
import com.tencent.tavkit.component.TAVPlayer;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\b\u0010\u0014\u001a\u00020\u0011H\u0002J\u0006\u0010\u0015\u001a\u00020\nJ\u0006\u0010\u0016\u001a\u00020\u0011J \u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\u0019\u001a\u00020\nJ\b\u0010\u001a\u001a\u00020\nH\u0007J\u0006\u0010\u001b\u001a\u00020\bJ\u0006\u0010\u001c\u001a\u00020\u0004J\u0006\u0010\u000b\u001a\u00020\u0004J\b\u0010\u001d\u001a\u00020\nH\u0002J\b\u0010\u001e\u001a\u00020\u0011H\u0002J\b\u0010\u001f\u001a\u00020\u0011H\u0002J\b\u0010 \u001a\u00020\u0011H\u0002J\u0006\u0010!\u001a\u00020\u0011J\u0006\u0010\"\u001a\u00020\nJ\u0006\u0010#\u001a\u00020\nJ\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/config/SightRecordConfig;", "", "()V", "RECORDER_CAPTURE_RESOLUTION_1080P", "", "RECORDER_CAPTURE_RESOLUTION_540P", "RECORDER_CAPTURE_RESOLUTION_720P", "TAG", "", "initSucc", "", "resolutionLimit", "scene", "svrConfigUseCpuCrop", "videoParams", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "afterCameraOpen", "", "cropPreviewSize", "Landroid/graphics/Point;", "checkEnableHevc", "cpuCrop", "doIDKeyReport", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "videoTransPara", "adjustVideoSizeByScreen", "isInit", "listConfig", "recorderType", "serverConfigUseCpuCrop", "setResolutionLimit", "setVideoSize", "setVideoSizeKeepRatio", "unInit", "useCameraApi2", "useImageStream", "plugin-recordvideo_release"})
public final class g {
    private static boolean BNv;
    private static boolean BNw;
    public static final g BNx = new g();
    private static int ilT = -1;
    private static VideoTransPara irT;
    private static int scene;

    static {
        AppMethodBeat.i(75384);
        AppMethodBeat.o(75384);
    }

    private g() {
    }

    public static /* synthetic */ void b(VideoTransPara videoTransPara, int i2) {
        AppMethodBeat.i(163423);
        a(videoTransPara, i2, true);
        AppMethodBeat.o(163423);
    }

    public static void a(VideoTransPara videoTransPara, int i2, boolean z) {
        Integer num;
        boolean z2;
        int i3;
        int i4;
        boolean z3;
        boolean z4;
        Integer num2;
        Integer num3;
        VideoTransPara videoTransPara2;
        Point point;
        AppMethodBeat.i(163422);
        p.h(videoTransPara, "videoTransPara");
        Log.i("MicroMsg.SightRecordConfig", "init videoTransPara:".concat(String.valueOf(videoTransPara)));
        irT = videoTransPara;
        scene = i2;
        StringBuilder sb = new StringBuilder("ABA: snstimeline Use ABA methods to improve the capturing bitrate, abaSwitch:");
        VideoTransPara videoTransPara3 = irT;
        StringBuilder append = sb.append(videoTransPara3 != null ? Integer.valueOf(videoTransPara3.iTg) : null).append(" videoBitrate: ");
        VideoTransPara videoTransPara4 = irT;
        if (videoTransPara4 != null) {
            num = Integer.valueOf(videoTransPara4.videoBitrate);
        } else {
            num = null;
        }
        Log.i("MicroMsg.SightRecordConfig", append.append(num).toString());
        k.d(irT);
        if (ae.gKA.gIV != -1 && (ae.gKA.gIV & 1) != 0) {
            ilT = 1080;
            Log.i("MicroMsg.SightRecordConfig", "config set setResolutionLimit use strategyMask 1080p");
        } else if (ae.gKA.gIV != -1 && (ae.gKA.gIV & 2) != 0) {
            ilT = TAVExporter.VIDEO_EXPORT_WIDTH;
            Log.i("MicroMsg.SightRecordConfig", "config set setResolutionLimit use strategyMask 720p");
        } else if (k.zux || k.zuy.zuK > 1 || k.ejH()) {
            ilT = k.zuy.ilT;
            Log.i("MicroMsg.SightRecordConfig", "config set setResolutionLimit use recorderOption:" + k.zuy.zuK + " resolutionLimit:" + ilT);
        } else {
            ilT = 1080;
            Log.i("MicroMsg.SightRecordConfig", "config set setResolutionLimit default 1080p");
            if (k.zuy.gIP == 1) {
                Object systemService = MMApplicationContext.getContext().getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME);
                if (systemService == null) {
                    t tVar = new t("null cannot be cast to non-null type android.app.ActivityManager");
                    AppMethodBeat.o(163422);
                    throw tVar;
                }
                int largeMemoryClass = ((ActivityManager) systemService).getLargeMemoryClass();
                int gy = d.gy(MMApplicationContext.getContext());
                Point ejr = d.ejr();
                Log.i("MicroMsg.SightRecordConfig", "config set setResolutionLimit ffmpeg memoryClass:" + largeMemoryClass + ", totalMemory:" + gy + ", screenSize:" + ejr);
                if (largeMemoryClass < 512 || ((float) gy) < 1725.0f || Math.min(ejr.x, ejr.y) < 1080) {
                    ilT = TAVPlayer.VIDEO_PLAYER_WIDTH;
                    Log.i("MicroMsg.SightRecordConfig", "config set setResolutionLimit ffmpeg memory not fit use 540p");
                } else {
                    ilT = 1080;
                    Log.i("MicroMsg.SightRecordConfig", "config set setResolutionLimit ffmpeg memory fit use 1080p");
                }
            }
        }
        if (z && (videoTransPara2 = irT) != null && k.zuy.gIP == 2) {
            Point az = ao.az(MMApplicationContext.getContext());
            if (ao.jU(MMApplicationContext.getContext())) {
                point = ao.gx(MMApplicationContext.getContext());
            } else {
                point = az;
            }
            if (irT != null) {
                if (((b) com.tencent.mm.kernel.g.af(b.class)).a(b.a.clicfg_video_align_long_side, true)) {
                    videoTransPara2.width = (int) ((((float) point.x) / ((float) point.y)) * ((float) videoTransPara2.height));
                    videoTransPara2.width = d.QH(videoTransPara2.width);
                } else {
                    videoTransPara2.height = (int) ((((float) point.y) / ((float) point.x)) * ((float) videoTransPara2.width));
                    videoTransPara2.height = d.QH(videoTransPara2.height);
                }
                Log.i("MicroMsg.SightRecordConfig", "setVideoSize, MediaCodec encode, video size: %sx%s", Integer.valueOf(videoTransPara2.width), Integer.valueOf(videoTransPara2.height));
            }
        }
        if (irT == null) {
            Log.i("MicroMsg.SightRecordConfig", "init error, videoParams is null");
            BNw = false;
            AppMethodBeat.o(163422);
            return;
        }
        VideoTransPara videoTransPara5 = irT;
        if (videoTransPara5 != null) {
            if (ilT < 540 || videoTransPara5.width <= 0 || videoTransPara5.height <= 0 || videoTransPara5.videoBitrate <= 0 || videoTransPara5.fps <= 0) {
                BNw = false;
                Log.i("MicroMsg.SightRecordConfig", "init error, param error");
            } else {
                BNw = true;
                Log.i("MicroMsg.SightRecordConfig", "init config succ");
            }
        }
        a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class);
        p.g(af, "MMKernel.service<IConfig…onfigService::class.java)");
        boolean z5 = Util.getInt(((com.tencent.mm.plugin.zero.b.a) af).aqJ().getValue("VideoRecordUseCpuCrop"), 0) == 1;
        int i5 = ae.gKB.gJa;
        Log.i("MicroMsg.SightRecordConfig", "serverConfigUseCpuCrop, serverConfigUseCpuCrop:" + z5 + ", deviceConfigUseCpuCrop:" + i5);
        if (z5) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (i5 != -1) {
            if (i5 == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
        }
        Log.i("MicroMsg.SightRecordConfig", "final set useCpuCrop:".concat(String.valueOf(z2)));
        BNv = z2;
        switch (scene) {
            case 1:
                i3 = ae.gKA.gJu;
                break;
            case 2:
                i3 = ae.gKA.gJv;
                break;
            default:
                i3 = -1;
                break;
        }
        switch (scene) {
            case 1:
                i4 = ae.gKA.gJs;
                break;
            case 2:
                i4 = ae.gKA.gJt;
                break;
            default:
                i4 = -1;
                break;
        }
        switch (scene) {
            case 1:
                if (((b) com.tencent.mm.kernel.g.af(b.class)).a(b.a.clicfg_capture_c2c_sw_hevc_encode_enable, 0) != 1) {
                    z3 = false;
                    break;
                } else {
                    z3 = true;
                    break;
                }
            case 2:
                if (((b) com.tencent.mm.kernel.g.af(b.class)).a(b.a.clicfg_capture_sns_sw_hevc_encode_enable, 0) != 1) {
                    z3 = false;
                    break;
                } else {
                    z3 = true;
                    break;
                }
            default:
                z3 = false;
                break;
        }
        switch (scene) {
            case 1:
                if (((b) com.tencent.mm.kernel.g.af(b.class)).a(b.a.clicfg_capture_c2c_hw_hevc_encode_enable, 0) != 1) {
                    z4 = false;
                    break;
                } else {
                    z4 = true;
                    break;
                }
            case 2:
                if (((b) com.tencent.mm.kernel.g.af(b.class)).a(b.a.clicfg_capture_sns_hw_hevc_encode_enable, 0) != 1) {
                    z4 = false;
                    break;
                } else {
                    z4 = true;
                    break;
                }
            default:
                z4 = false;
                break;
        }
        Log.i("MicroMsg.SightRecordConfig", "checkEnableHevc, deviceSwEnableHevc:" + i3 + ", deviceHwEnableHevc:" + i4 + ", exptSwEnableHevc:" + z3 + ", exptHwEnableHevc:" + z4);
        if (z3 || i3 != -1) {
            if (i3 == 1) {
                VideoTransPara videoTransPara6 = irT;
                if (videoTransPara6 != null) {
                    videoTransPara6.iTs = 1;
                }
            } else if (z3 && i3 == 2) {
                VideoTransPara videoTransPara7 = irT;
                if (videoTransPara7 != null) {
                    videoTransPara7.iTs = 0;
                }
            } else if (z3) {
                VideoTransPara videoTransPara8 = irT;
                if (videoTransPara8 != null) {
                    videoTransPara8.iTs = 1;
                }
            } else {
                VideoTransPara videoTransPara9 = irT;
                if (videoTransPara9 != null) {
                    videoTransPara9.iTs = 0;
                }
            }
        }
        if (z4 || i4 != -1) {
            if (i4 == 1) {
                VideoTransPara videoTransPara10 = irT;
                if (videoTransPara10 != null) {
                    videoTransPara10.iTr = 1;
                }
            } else if (z4 && i4 == 2) {
                VideoTransPara videoTransPara11 = irT;
                if (videoTransPara11 != null) {
                    videoTransPara11.iTr = 0;
                }
            } else if (z4) {
                VideoTransPara videoTransPara12 = irT;
                if (videoTransPara12 != null) {
                    videoTransPara12.iTr = 1;
                }
            } else {
                VideoTransPara videoTransPara13 = irT;
                if (videoTransPara13 != null) {
                    videoTransPara13.iTr = 0;
                }
            }
        }
        VideoTransPara videoTransPara14 = irT;
        if (videoTransPara14 != null && videoTransPara14.iTs == 1) {
            k.zuy.gIP = 1;
        }
        StringBuilder sb2 = new StringBuilder("checkEnableHevc, hwEnableHevc:");
        VideoTransPara videoTransPara15 = irT;
        if (videoTransPara15 != null) {
            num2 = Integer.valueOf(videoTransPara15.iTr);
        } else {
            num2 = null;
        }
        StringBuilder append2 = sb2.append(num2).append(", swEnableHevc:");
        VideoTransPara videoTransPara16 = irT;
        if (videoTransPara16 != null) {
            num3 = Integer.valueOf(videoTransPara16.iTs);
        } else {
            num3 = null;
        }
        Log.i("MicroMsg.SightRecordConfig", append2.append(num3).toString());
        AppMethodBeat.o(163422);
    }

    public static final boolean isInit() {
        return BNw;
    }

    public static String eJx() {
        AppMethodBeat.i(237256);
        String str = "cpuCrop:" + eJB() + ", recorderType:" + eJz() + ", resolutionLimit:" + ilT + ", videoParams:" + irT;
        AppMethodBeat.o(237256);
        return str;
    }

    public static void unInit() {
        AppMethodBeat.i(75380);
        Log.i("MicroMsg.SightRecordConfig", "unInit");
        BNw = false;
        AppMethodBeat.o(75380);
    }

    public static VideoTransPara eJy() {
        return irT;
    }

    public static int eJz() {
        if (k.zuy == null || !BNw) {
            return 2;
        }
        return k.zuy.gIP;
    }

    public static int eJA() {
        return ilT;
    }

    public static boolean eJB() {
        boolean z;
        Integer num;
        VideoTransPara videoTransPara;
        Integer num2 = null;
        AppMethodBeat.i(75381);
        if (k.zuy == null || !BNw) {
            AppMethodBeat.o(75381);
            return false;
        }
        if (k.zuy.gIP == 1) {
            z = true;
        } else {
            z = false;
        }
        StringBuilder append = new StringBuilder("cpuCrop: recorderTypeCpuCrop:").append(z).append(", serverConfigUseCpuCrop:").append(BNv).append(", swEnableHevc:");
        VideoTransPara videoTransPara2 = irT;
        if (videoTransPara2 != null) {
            num = Integer.valueOf(videoTransPara2.iTs);
        } else {
            num = null;
        }
        StringBuilder append2 = append.append(num).append(", hwEnableHevc:");
        VideoTransPara videoTransPara3 = irT;
        if (videoTransPara3 != null) {
            num2 = Integer.valueOf(videoTransPara3.iTr);
        }
        Log.i("MicroMsg.SightRecordConfig", append2.append(num2).toString());
        if (z || BNv || ((videoTransPara = irT) != null && videoTransPara.iTs == 1)) {
            AppMethodBeat.o(75381);
            return true;
        }
        AppMethodBeat.o(75381);
        return false;
    }

    public static final void j(Point point) {
        AppMethodBeat.i(75382);
        p.h(point, "cropPreviewSize");
        int i2 = point.x;
        int i3 = point.y;
        Log.i("MicroMsg.SightRecordConfig", "afterCameraOpen, cropPreviewWidth:" + i2 + ", cropPreviewHeight:" + i3 + ", recorderType:" + k.zuy.gIP + ", resolutionLimit:" + ilT);
        VideoTransPara videoTransPara = irT;
        if (videoTransPara == null) {
            AppMethodBeat.o(75382);
        } else if (k.zuy.gIP == 1) {
            if (i3 > videoTransPara.width) {
                if (ilT == 1080) {
                    videoTransPara.width = i3 / 2;
                    Log.i("MicroMsg.SightRecordConfig", "afterCameraOpen ffempg 1080p, videoWidth:" + videoTransPara.width);
                } else if (ilT == 720) {
                    videoTransPara.width = (int) (((double) i3) * 0.75d);
                    Log.i("MicroMsg.SightRecordConfig", "afterCameraOpen ffempg 720p, videoWidth:" + videoTransPara.width);
                }
                videoTransPara.height = (int) ((((float) i2) / ((float) i3)) * ((float) videoTransPara.width));
            } else {
                Log.i("MicroMsg.SightRecordConfig", "afterCameraOpen ffmpeg use crop preview size");
                videoTransPara.width = i3;
                videoTransPara.height = i2;
            }
            if (videoTransPara.width % 2 != 0) {
                videoTransPara.width--;
            }
            if (videoTransPara.height % 2 != 0) {
                videoTransPara.height--;
            }
            Log.i("MicroMsg.SightRecordConfig", "afterCameraOpen ffmpeg final videoSize:" + videoTransPara.width + 'x' + videoTransPara.height);
            AppMethodBeat.o(75382);
        } else {
            if ((ilT == 720 || ilT == 540) && i3 < videoTransPara.width) {
                Log.i("MicroMsg.SightRecordConfig", "afterCameraOpen mediacodec 720p or 540p:" + ilT + ", adjust video size");
                if (ilT == 540) {
                    videoTransPara.width = i3;
                    Log.i("MicroMsg.SightRecordConfig", "afterCameraOpen mediacodec 540p, videoWidth:" + videoTransPara.width);
                } else if (ilT == 720) {
                    videoTransPara.width = (int) (((double) i3) * 0.75d);
                    Log.i("MicroMsg.SightRecordConfig", "afterCameraOpen mediacodec 720p, videoWidth:" + videoTransPara.width);
                }
                videoTransPara.height = (int) ((((float) i2) / ((float) i3)) * ((float) videoTransPara.width));
                videoTransPara.width = d.QH(videoTransPara.width);
                videoTransPara.height = d.QH(videoTransPara.height);
                Log.i("MicroMsg.SightRecordConfig", "afterCameraOpen final adjust video size:" + videoTransPara.width + 'x' + videoTransPara.height);
            }
            AppMethodBeat.o(75382);
        }
    }

    public static void eJC() {
        int i2;
        AppMethodBeat.i(75383);
        h.INSTANCE.idkeyStat(440, 0, 1, false);
        int i3 = 36;
        if (BNw) {
            if (eJz() == 1) {
                i3 = 39;
            }
            if (ilT == 720) {
                i2 = i3 + 1;
            } else {
                i2 = i3 + 2;
            }
            h.INSTANCE.idkeyStat(440, (long) i2, 1, false);
        }
        AppMethodBeat.o(75383);
    }
}
