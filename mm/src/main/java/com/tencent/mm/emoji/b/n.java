package com.tencent.mm.emoji.b;

import com.tencent.liteav.audio.TXEAudioDef;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.n.h;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.gif.MMWXGFJNI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;

public final class n {
    private static boolean gXN = false;
    private static boolean gXO = false;
    private static boolean gXP = false;
    private static boolean gXQ = false;
    private static boolean gXR = false;
    private static boolean gXS = false;

    public static boolean auV() {
        AppMethodBeat.i(104462);
        if ((h.aqJ().getInt("EmotionRewardOption", 0) & 1) == 1) {
            AppMethodBeat.o(104462);
            return false;
        }
        AppMethodBeat.o(104462);
        return true;
    }

    public static boolean auW() {
        AppMethodBeat.i(104463);
        if ((h.aqJ().getInt("EmotionRewardOption", 0) & 2) == 2) {
            AppMethodBeat.o(104463);
            return false;
        }
        AppMethodBeat.o(104463);
        return true;
    }

    public static boolean auX() {
        AppMethodBeat.i(104464);
        if ((h.aqJ().getInt("EmotionRewardOption", 0) & 4) == 4) {
            AppMethodBeat.o(104464);
            return true;
        }
        AppMethodBeat.o(104464);
        return false;
    }

    public static int auY() {
        AppMethodBeat.i(104465);
        int i2 = Util.getInt(h.aqJ().getValue("CustomEmojiMaxSize"), 300);
        AppMethodBeat.o(104465);
        return i2;
    }

    public static int auZ() {
        AppMethodBeat.i(104466);
        int i2 = Util.getInt(h.aqJ().getValue("CustomEmojiMaxSize"), 300);
        AppMethodBeat.o(104466);
        return i2;
    }

    public static String ava() {
        AppMethodBeat.i(104467);
        String value = h.aqJ().getValue("C2CEmojiNotAutoDownloadTimeRange");
        AppMethodBeat.o(104467);
        return value;
    }

    public static String avb() {
        AppMethodBeat.i(104468);
        String value = h.aqJ().getValue("EmotionPanelConfigName");
        AppMethodBeat.o(104468);
        return value;
    }

    public static boolean avc() {
        AppMethodBeat.i(104469);
        if (!gXN) {
            int i2 = h.aqJ().getInt("EnableEmoticonExternUrl", 0);
            int errorCode = MMWXGFJNI.getErrorCode();
            if ((i2 & 1) != 1) {
                gXQ = false;
            } else if (avj() || avk()) {
                gXQ = false;
            } else {
                gXQ = true;
            }
            if (errorCode < 0) {
                gXQ = false;
                switch (errorCode) {
                    case -906:
                        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(711, 10, 1, false);
                        break;
                    case -905:
                        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(711, 9, 1, false);
                        break;
                    case -904:
                        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(711, 8, 1, false);
                        break;
                    case -903:
                        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(711, 7, 1, false);
                        break;
                    case -902:
                        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(711, 6, 1, false);
                        break;
                    case TXEAudioDef.TXE_AUDIO_COMMON_ERR_INVALID_PARAMS:
                        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(711, 5, 1, false);
                        break;
                }
            }
            gXN = true;
            Log.i("MicroMsg.emoji.EmotionDynamicConfigMgr", "isEnableHevcDownload:%b", Boolean.valueOf(gXQ));
        }
        boolean z = gXQ;
        AppMethodBeat.o(104469);
        return z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x003c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean avd() {
        /*
        // Method dump skipped, instructions count: 112
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.emoji.b.n.avd():boolean");
    }

    public static boolean ave() {
        AppMethodBeat.i(104471);
        if (!gXP) {
            if ((h.aqJ().getInt("EnableEmoticonExternUrl", 0) & 4) == 4) {
                gXS = true;
            } else {
                gXS = false;
            }
            gXP = true;
        }
        Log.i("MicroMsg.emoji.EmotionDynamicConfigMgr", "isEnableHevcUpload:%b", Boolean.valueOf(gXS));
        boolean z = gXS;
        AppMethodBeat.o(104471);
        return z;
    }

    public static boolean avf() {
        AppMethodBeat.i(104472);
        if ((h.aqJ().getInt("ShowEmoticonCameraEntrance", 3) & 1) > 0) {
            AppMethodBeat.o(104472);
            return true;
        }
        AppMethodBeat.o(104472);
        return false;
    }

    public static boolean avg() {
        AppMethodBeat.i(104473);
        if ((h.aqJ().getInt("ShowEmoticonCameraEntrance", 3) & 2) > 0) {
            AppMethodBeat.o(104473);
            return true;
        }
        AppMethodBeat.o(104473);
        return false;
    }

    public static boolean isSpringFestivalEnable() {
        AppMethodBeat.i(104474);
        ((b) g.af(b.class)).a(b.a.clicfg_emoji_spring_festival, 0);
        h.aqJ().getInt("EmotionSpringFestivalPendantSwitch", 0);
        AppMethodBeat.o(104474);
        return false;
    }

    public static boolean avh() {
        AppMethodBeat.i(104475);
        if (g.aAh().azQ().getInt(ar.a.USERINFO_EMOJI_SPRING_FESTIVAL_CROP_TYPE_INT, 1) == 0) {
            AppMethodBeat.o(104475);
            return true;
        }
        AppMethodBeat.o(104475);
        return false;
    }

    public static boolean avi() {
        AppMethodBeat.i(104476);
        if (h.aqJ().getInt("ForbiddenEmotionSpringFestivalMsgTail", 0) > 0) {
            AppMethodBeat.o(104476);
            return false;
        }
        AppMethodBeat.o(104476);
        return true;
    }

    public static boolean isStickerEnable() {
        AppMethodBeat.i(104477);
        int i2 = g.aAh().azQ().getInt(ar.a.USERINFO_EMOJI_STICKER_ENABLE_INT, 0);
        if (i2 == 1) {
            AppMethodBeat.o(104477);
            return true;
        } else if (i2 == 2) {
            AppMethodBeat.o(104477);
            return false;
        } else {
            AppMethodBeat.o(104477);
            return true;
        }
    }

    public static int stickerRecommendCount() {
        AppMethodBeat.i(177029);
        int a2 = ((b) g.af(b.class)).a(b.a.clicfg_emoji_sticker_recommend_count, 9);
        AppMethodBeat.o(177029);
        return a2;
    }

    private static boolean avj() {
        boolean z = true;
        AppMethodBeat.i(104478);
        try {
            MMApplicationContext.getContext().getPackageManager().getPackageInfo("com.google.android.wearable.app.cn", 1);
        } catch (Exception e2) {
            z = false;
        }
        AppMethodBeat.o(104478);
        return z;
    }

    private static boolean avk() {
        boolean z = true;
        AppMethodBeat.i(104479);
        try {
            MMApplicationContext.getContext().getPackageManager().getPackageInfo("com.google.android.wearable.app", 1);
        } catch (Exception e2) {
            z = false;
        }
        AppMethodBeat.o(104479);
        return z;
    }

    public static boolean avl() {
        AppMethodBeat.i(104480);
        int i2 = g.aAh().azQ().getInt(ar.a.USERINFO_EMOJI_UPLOAD_CDN_INT, 0);
        if (i2 == 1) {
            AppMethodBeat.o(104480);
            return true;
        } else if (i2 == 2) {
            AppMethodBeat.o(104480);
            return false;
        } else {
            boolean a2 = ((b) g.af(b.class)).a(b.a.clicfg_emoji_upload_cdn, false);
            AppMethodBeat.o(104480);
            return a2;
        }
    }
}
