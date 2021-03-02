package com.tencent.mm.plugin.vlog.model.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.vfs.s;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.tav.core.ExportErrorStatus;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J6\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0016J\u000e\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0004J\u0006\u0010\u001b\u001a\u00020\u0012J\u0006\u0010\u001c\u001a\u00020\u0012J\u0006\u0010\u001d\u001a\u00020\u0012J\u0006\u0010\u001e\u001a\u00020\u0012J\u0016\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u0016J\u0006\u0010\"\u001a\u00020\u0012J\u0006\u0010#\u001a\u00020\u0012J\u000e\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u0007J\u0016\u0010&\u001a\u00020\r2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\r0(H\u0002J\u000e\u0010)\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\u0004J\u000e\u0010+\u001a\u00020\u00122\u0006\u0010,\u001a\u00020-J\u0014\u0010.\u001a\u00020\u00122\f\u0010/\u001a\b\u0012\u0004\u0012\u0002000(J&\u00101\u001a\u00020\u00122\u0006\u00102\u001a\u00020\u00162\u0006\u00103\u001a\u00020\u00162\u0006\u00104\u001a\u00020\u00072\u0006\u00105\u001a\u00020\u0016J&\u00106\u001a\u00020\u00122\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\r0(2\u0006\u00107\u001a\u00020\r2\b\b\u0002\u00105\u001a\u00020\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rXT¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000fX\u0004¢\u0006\u0002\n\u0000¨\u00068"}, hxF = {"Lcom/tencent/mm/plugin/vlog/model/report/MultiMediaIDKeyStat;", "", "()V", "DATA_ID", "", "ERR_ID", "HighFpsLimit", "", "HighResolutionLimit", "MuxStateResumeFromPrevious", "MuxStateStart", "MuxStateUnknown", "TAG", "", "muxReportMMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "finishMux", "", "path", "cost", "hasOriginSound", "", "hasMusic", "isHevcHard", "isHevcSoft", "markGetCompositionLabelCost", "markGetCompositionLabelFail", "markGetCompositionLabelSucc", "markGetFrameThumbFailed", "markGetFrameThumbNull", "markMuxTrackCount", "count", "videoAndImage", "markSelectNonYuv420Video", "markStartGetCompositionLabel", "muxErrCode", TMQQDownloaderOpenSDKConst.UINTYPE_CODE, "pathListHashKey", "pathList", "", "report", "key", "reportCompositionInfo", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "reportEditItem", "itemList", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "reportMuxResult", "background", "success", "retryCount", "softEncode", "startMux", "outputPath", "plugin-vlog_release"})
public final class a {
    private static final MultiProcessMMKV GAW = MultiProcessMMKV.getMMKV("MultiMediaIDKeyStatMuxMark");
    private static final int GAX = 0;
    private static final int GAY = 1;
    private static final int GAZ = 2;
    public static final a GBa = new a();

    static {
        AppMethodBeat.i(190814);
        AppMethodBeat.o(190814);
    }

    private a() {
    }

    public static void bd(int i2, boolean z) {
        AppMethodBeat.i(190801);
        Log.i("MicroMsg.MultiMediaIDKeyStat", "markMuxTrackCount, count:" + i2 + ", videoAndImage:" + z);
        if (z) {
            h.INSTANCE.n(1371, 2, 1);
        }
        if (i2 <= 1) {
            h.INSTANCE.n(1371, 3, 1);
            AppMethodBeat.o(190801);
        } else if (2 <= i2 && 3 >= i2) {
            h.INSTANCE.n(1371, 4, 1);
            AppMethodBeat.o(190801);
        } else if (4 <= i2 && 5 >= i2) {
            h.INSTANCE.n(1371, 5, 1);
            AppMethodBeat.o(190801);
        } else {
            h.INSTANCE.n(1371, 6, 1);
            AppMethodBeat.o(190801);
        }
    }

    public static void c(List<String> list, String str, boolean z) {
        AppMethodBeat.i(190802);
        p.h(list, "pathList");
        p.h(str, "outputPath");
        Log.i("MicroMsg.MultiMediaIDKeyStat", "startMux, pathList:" + list + ", outputPath:" + str + ", softEncode:" + z);
        if (!list.isEmpty()) {
            if (GAW.getInt(str, GAX) == GAY) {
                Log.i("MicroMsg.MultiMediaIDKeyStat", "check mux may be resume from previous error");
                GAW.putInt(str, GAZ);
                h.INSTANCE.n(1371, 99, 1);
            } else {
                GAW.putInt(str, GAY);
            }
            h.INSTANCE.n(1371, 0, 1);
            if (z) {
                h.INSTANCE.n(1371, 139, 1);
            }
            h.INSTANCE.n(1371, 8, (long) list.size());
            h.INSTANCE.n(1371, 9, 1);
            for (T t : list) {
                if (!s.YS(t)) {
                    h.INSTANCE.n(1372, 1, 0);
                }
                MultiMediaVideoChecker.a aTV = MultiMediaVideoChecker.GyY.aTV(t);
                Log.i("MicroMsg.MultiMediaIDKeyStat", "startMux, videoInfo:".concat(String.valueOf(aTV)));
                if (aTV != null && aTV.width > 0 && aTV.height > 0 && aTV.cKu > 0.0f) {
                    if (aTV.zzJ) {
                        Log.i("MicroMsg.MultiMediaIDKeyStat", "video is h265 path:".concat(String.valueOf(t)));
                        h.INSTANCE.n(1371, 25, 1);
                    }
                    if (aTV.width >= 2000 || aTV.height >= 2000) {
                        Log.i("MicroMsg.MultiMediaIDKeyStat", "video high resolution:[" + aTV.width + ", " + aTV.height + "], path:" + ((String) t));
                        h.INSTANCE.n(1371, 26, 1);
                    }
                    if (aTV.cKu >= 40.0f) {
                        Log.i("MicroMsg.MultiMediaIDKeyStat", "video high fps:" + aTV.cKu + ", path:" + ((String) t));
                        h.INSTANCE.n(1371, 27, 1);
                    }
                    h.INSTANCE.n(1371, 12, (long) aTV.cKu);
                    h.INSTANCE.n(1371, 13, 1);
                } else if (aTV == null) {
                    Log.i("MicroMsg.MultiMediaIDKeyStat", "cannot get videoInfo path:".concat(String.valueOf(t)));
                    h.INSTANCE.n(1372, 0, 1);
                } else if (aTV.width <= 0 || aTV.height <= 0) {
                    Log.i("MicroMsg.MultiMediaIDKeyStat", "cannot get video width/height path:".concat(String.valueOf(t)));
                    h.INSTANCE.n(1372, 2, 1);
                } else if (aTV.cKu <= 0.0f) {
                    Log.i("MicroMsg.MultiMediaIDKeyStat", "cannot get video fps path:".concat(String.valueOf(t)));
                    h.INSTANCE.n(1372, 3, 1);
                }
            }
        }
        AppMethodBeat.o(190802);
    }

    public static void a(String str, long j2, boolean z, boolean z2, boolean z3, boolean z4) {
        AppMethodBeat.i(190803);
        p.h(str, "path");
        Log.i("MicroMsg.MultiMediaIDKeyStat", "finishMux:" + str + ", cost:" + j2 + ", hasOriginSound:" + z + ", hasMusic:" + z2 + ", isHevcHard:" + z3 + ", isHevcSoft:" + z4);
        boolean z5 = false;
        if (!s.YS(str)) {
            Log.i("MicroMsg.MultiMediaIDKeyStat", "finish mux file not exist path:".concat(String.valueOf(str)));
            h.INSTANCE.n(1372, 18, 1);
            z5 = true;
        }
        MultiMediaVideoChecker.a aTV = MultiMediaVideoChecker.GyY.aTV(str);
        if (aTV == null || aTV.width <= 0 || aTV.height <= 0 || aTV.cKu <= 0.0f) {
            if (aTV == null) {
                Log.i("MicroMsg.MultiMediaIDKeyStat", "finish mux cannot get videoInfo path:".concat(String.valueOf(str)));
                h.INSTANCE.n(1372, 19, 1);
            } else if (aTV.width <= 0 || aTV.height <= 0) {
                Log.i("MicroMsg.MultiMediaIDKeyStat", "finish mux cannot get videoInfo width/height path:".concat(String.valueOf(str)));
                h.INSTANCE.n(1372, 20, 1);
            } else if (aTV.cKu <= 0.0f) {
                Log.i("MicroMsg.MultiMediaIDKeyStat", "finish mux cannot get videoInfo fps path:".concat(String.valueOf(str)));
                h.INSTANCE.n(1372, 21, 1);
            }
            z5 = false;
        } else {
            h.INSTANCE.n(1371, 1, 1);
            if (z4) {
                h.INSTANCE.n(1371, 129, 1);
            }
            if (z3) {
                h.INSTANCE.n(1371, 130, 1);
            }
            if (!z3 && !z4) {
                h.INSTANCE.n(1371, 62, j2);
                h.INSTANCE.n(1371, 63, 1);
            } else if (z3) {
                h.INSTANCE.n(1371, 132, j2);
            } else if (z4) {
                h.INSTANCE.n(1371, 135, j2);
            }
            h.INSTANCE.n(1371, 16, (long) aTV.cKu);
            h.INSTANCE.n(1371, 17, 1);
            if (z && !z2) {
                h.INSTANCE.n(1371, 20, 1);
            } else if (!z && !z2) {
                h.INSTANCE.n(1371, 21, 1);
                h.INSTANCE.n(1371, 36, aTV.duration);
                h.INSTANCE.n(1371, 37, 1);
            } else if (z && z2) {
                h.INSTANCE.n(1371, 22, 1);
                h.INSTANCE.n(1371, 47, aTV.duration);
                h.INSTANCE.n(1371, 48, 1);
            } else if (!z && z2) {
                h.INSTANCE.n(1371, 23, 1);
                h.INSTANCE.n(1371, 58, aTV.duration);
                h.INSTANCE.n(1371, 59, 1);
            }
            Log.i("MicroMsg.MultiMediaIDKeyStat", "finish mux video duration:" + aTV.duration);
            long j3 = aTV.duration / 1000;
            if (0 <= j3 && 10 >= j3) {
                if (!z && !z2) {
                    h.INSTANCE.n(1371, 29, 1);
                } else if (z && z2) {
                    h.INSTANCE.n(1371, 40, 1);
                } else if (!z && z2) {
                    h.INSTANCE.n(1371, 51, 1);
                }
                h.INSTANCE.n(1371, 66, j2);
                h.INSTANCE.n(1371, 67, 1);
            } else if (11 <= j3 && 20 >= j3) {
                if (!z && !z2) {
                    h.INSTANCE.n(1371, 30, 1);
                } else if (z && z2) {
                    h.INSTANCE.n(1371, 41, 1);
                } else if (!z && z2) {
                    h.INSTANCE.n(1371, 52, 1);
                }
                h.INSTANCE.n(1371, 70, j2);
                h.INSTANCE.n(1371, 71, 1);
            } else if (21 <= j3 && 30 >= j3) {
                if (!z && !z2) {
                    h.INSTANCE.n(1371, 31, 1);
                } else if (z && z2) {
                    h.INSTANCE.n(1371, 42, 1);
                } else if (!z && z2) {
                    h.INSTANCE.n(1371, 53, 1);
                }
                h.INSTANCE.n(1371, 74, j2);
                h.INSTANCE.n(1371, 75, 1);
            } else if (31 <= j3 && 40 >= j3) {
                if (!z && !z2) {
                    h.INSTANCE.n(1371, 32, 1);
                } else if (z && z2) {
                    h.INSTANCE.n(1371, 43, 1);
                } else if (!z && z2) {
                    h.INSTANCE.n(1371, 54, 1);
                }
                h.INSTANCE.n(1371, 78, j2);
                h.INSTANCE.n(1371, 79, 1);
            } else if (41 <= j3 && 50 >= j3) {
                if (!z && !z2) {
                    h.INSTANCE.n(1371, 33, 1);
                } else if (z && z2) {
                    h.INSTANCE.n(1371, 44, 1);
                } else if (!z && z2) {
                    h.INSTANCE.n(1371, 55, 1);
                }
                h.INSTANCE.n(1371, 82, j2);
                h.INSTANCE.n(1371, 83, 1);
            } else if (51 <= j3 && 60 >= j3) {
                if (!z && !z2) {
                    h.INSTANCE.n(1371, 34, 1);
                } else if (z && z2) {
                    h.INSTANCE.n(1371, 45, 1);
                } else if (!z && z2) {
                    h.INSTANCE.n(1371, 56, 1);
                }
                h.INSTANCE.n(1371, 86, j2);
                h.INSTANCE.n(1371, 87, 1);
            }
        }
        if (GAW.getInt(str, GAX) == GAZ) {
            if (z5) {
                Log.i("MicroMsg.MultiMediaIDKeyStat", "finishMux error is resume from previous");
                h.INSTANCE.n(1371, 101, 1);
            } else {
                Log.i("MicroMsg.MultiMediaIDKeyStat", "finishMux success is resume from previous");
                h.INSTANCE.n(1371, 100, 1);
            }
        }
        GAW.remove(str);
        AppMethodBeat.o(190803);
    }

    public static void acB(int i2) {
        AppMethodBeat.i(190804);
        Log.i("MicroMsg.MultiMediaIDKeyStat", "muxErrCode:".concat(String.valueOf(i2)));
        switch (i2) {
            case ExportErrorStatus.END_WRITE_AUDIO_SAMPLE /*{ENCODED_INT: -124}*/:
                h.INSTANCE.n(1372, 41, 1);
                AppMethodBeat.o(190804);
                return;
            case ExportErrorStatus.END_WRITE_VIDEO_SAMPLE /*{ENCODED_INT: -123}*/:
                h.INSTANCE.n(1372, 40, 1);
                AppMethodBeat.o(190804);
                return;
            case ExportErrorStatus.WRITE_AUDIO_SAMPLE /*{ENCODED_INT: -122}*/:
                h.INSTANCE.n(1372, 39, 1);
                AppMethodBeat.o(190804);
                return;
            case ExportErrorStatus.WRITE_VIDEO_SAMPLE /*{ENCODED_INT: -121}*/:
                h.INSTANCE.n(1372, 38, 1);
                AppMethodBeat.o(190804);
                return;
            case ExportErrorStatus.APPEND_VIDEO_SAMPLE_SWAP_BUFFERS /*{ENCODED_INT: -113}*/:
                h.INSTANCE.n(1372, 37, 1);
                AppMethodBeat.o(190804);
                return;
            case ExportErrorStatus.RENDER_SAMPLE_BUFFER /*{ENCODED_INT: -112}*/:
                h.INSTANCE.n(1372, 36, 1);
                AppMethodBeat.o(190804);
                return;
            case ExportErrorStatus.APPEND_VIDEO_SAMPLE_MAKE_CURRENT /*{ENCODED_INT: -111}*/:
                h.INSTANCE.n(1372, 35, 1);
                AppMethodBeat.o(190804);
                return;
            case ExportErrorStatus.APPEND_BUFFER /*{ENCODED_INT: -110}*/:
                h.INSTANCE.n(1372, 34, 1);
                AppMethodBeat.o(190804);
                return;
            case -104:
                h.INSTANCE.n(1372, 33, 1);
                AppMethodBeat.o(190804);
                return;
            case -103:
                h.INSTANCE.n(1372, 32, 1);
                AppMethodBeat.o(190804);
                return;
            case -102:
                h.INSTANCE.n(1372, 31, 1);
                AppMethodBeat.o(190804);
                return;
            case -101:
                h.INSTANCE.n(1372, 30, 1);
                AppMethodBeat.o(190804);
                return;
            case -15:
                h.INSTANCE.n(1372, 9, 1);
                AppMethodBeat.o(190804);
                return;
            case -14:
                h.INSTANCE.n(1372, 8, 1);
                AppMethodBeat.o(190804);
                return;
            case -11:
                h.INSTANCE.n(1372, 6, 1);
                AppMethodBeat.o(190804);
                return;
            case -10:
                h.INSTANCE.n(1372, 5, 1);
                AppMethodBeat.o(190804);
                return;
            default:
                h.INSTANCE.n(1372, 16, 1);
                AppMethodBeat.o(190804);
                return;
        }
    }

    public static void c(boolean z, boolean z2, int i2, boolean z3) {
        int i3;
        AppMethodBeat.i(190805);
        if (z) {
            switch (i2) {
                case 1:
                    if (!z2) {
                        i3 = 93;
                        break;
                    } else {
                        i3 = 92;
                        break;
                    }
                case 2:
                    if (!z2) {
                        if (!z3) {
                            i3 = 95;
                            break;
                        } else {
                            i3 = TbsListener.ErrorCode.NEEDDOWNLOAD_3;
                            break;
                        }
                    } else if (!z3) {
                        i3 = 94;
                        break;
                    } else {
                        i3 = 141;
                        break;
                    }
                default:
                    if (!z2) {
                        if (!z3) {
                            i3 = 97;
                            break;
                        } else {
                            i3 = 144;
                            break;
                        }
                    } else if (!z3) {
                        i3 = 96;
                        break;
                    } else {
                        i3 = TbsListener.ErrorCode.NEEDDOWNLOAD_4;
                        break;
                    }
            }
        } else {
            i3 = z2 ? 90 : 91;
        }
        h.INSTANCE.n(1371, (long) i3, 1);
        AppMethodBeat.o(190805);
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x006a A[EDGE_INSN: B:37:0x006a->B:25:0x006a ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void hQ(java.util.List<? extends com.tencent.mm.plugin.recordvideo.ui.editor.item.a> r10) {
        /*
        // Method dump skipped, instructions count: 136
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.vlog.model.report.a.hQ(java.util.List):void");
    }

    public static void fCh() {
        AppMethodBeat.i(190808);
        h.INSTANCE.n(1371, 117, 1);
        AppMethodBeat.o(190808);
    }

    public static void fCi() {
        AppMethodBeat.i(190809);
        h.INSTANCE.n(1371, 118, 1);
        AppMethodBeat.o(190809);
    }

    public static void fCj() {
        AppMethodBeat.i(190810);
        h.INSTANCE.n(1371, 119, 1);
        AppMethodBeat.o(190810);
    }

    public static void KS(long j2) {
        AppMethodBeat.i(190811);
        h.INSTANCE.n(1371, 121, j2);
        h.INSTANCE.n(1371, 122, 1);
        AppMethodBeat.o(190811);
    }

    public static void report(long j2) {
        AppMethodBeat.i(190812);
        h.INSTANCE.F(1371, j2);
        AppMethodBeat.o(190812);
    }

    public static void fCk() {
        AppMethodBeat.i(190813);
        h.INSTANCE.n(1371, 127, 1);
        AppMethodBeat.o(190813);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0080  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(com.tencent.mm.plugin.vlog.model.ac r11) {
        /*
        // Method dump skipped, instructions count: 145
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.vlog.model.report.a.a(com.tencent.mm.plugin.vlog.model.ac):void");
    }
}
