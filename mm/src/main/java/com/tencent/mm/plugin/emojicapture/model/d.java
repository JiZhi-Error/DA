package com.tencent.mm.plugin.emojicapture.model;

import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import com.tencent.smtt.sdk.WebView;
import java.util.Arrays;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/model/EmojiCaptureConstants;", "", "()V", "Companion", "plugin-emojicapture_release"})
public final class d {
    private static final String TAG = TAG;
    public static final a roA = new a((byte) 0);
    private static boolean rot = true;
    private static int rou = 5;
    private static int rov = 640;
    private static int rox = 9;
    private static float roy = (((float) rov) * 0.06666667f);
    private static int roz = 320;

    @l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u00109\u001a\u00020\t2\u0006\u0010:\u001a\u00020\u0004H\u0007J\u000e\u0010;\u001a\u00020\u001e2\u0006\u0010<\u001a\u00020\u0004J\u000e\u0010;\u001a\u00020\u00042\u0006\u0010=\u001a\u00020\u001eJ\b\u0010>\u001a\u00020\u001eH\u0007J\u0010\u0010?\u001a\u00020\u001e2\u0006\u0010@\u001a\u00020\u001eH\u0007J\u0010\u0010A\u001a\u00020\u001e2\u0006\u0010@\u001a\u00020\u001eH\u0007J\b\u0010B\u001a\u00020\u001eH\u0007J\b\u0010C\u001a\u00020\u001eH\u0007J\b\u0010D\u001a\u00020\u001eH\u0007J\b\u0010E\u001a\u00020\u001eH\u0007J\b\u0010F\u001a\u00020GH\u0007J\b\u0010H\u001a\u00020GH\u0007J\b\u0010I\u001a\u000204H\u0007J\u0006\u0010J\u001a\u000204R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0010R\u000e\u0010\u001d\u001a\u00020\u001eXT¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\"\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u000e\"\u0004\b$\u0010\u0010R\u000e\u0010%\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u001eXD¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u001eXT¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u001eXT¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u001eXT¢\u0006\u0002\n\u0000R\u001a\u0010/\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u000e\"\u0004\b1\u0010\u0010R\u000e\u00102\u001a\u00020\u001eXT¢\u0006\u0002\n\u0000R\u001a\u00103\u001a\u000204X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00105\"\u0004\b6\u00107R\u000e\u00108\u001a\u00020\tXT¢\u0006\u0002\n\u0000¨\u0006K"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/model/EmojiCaptureConstants$Companion;", "", "()V", "CHIN", "", "DefaultEmojiVideoFrameDuration", "DefaultFilterIndex", "EYE", "EmojiCornerPercent", "", "EmojiMinRecordTime", "EmojiPreviewHeight", "EmojiPreviewSize", "getEmojiPreviewSize", "()I", "setEmojiPreviewSize", "(I)V", "EmojiPreviewWidth", "EmojiPtSegmentInputSize", "EmojiRoundCornerRadius", "getEmojiRoundCornerRadius", "()F", "setEmojiRoundCornerRadius", "(F)V", "EmojiVideoSpeedupRate", "FACEV", "FinalEmojiSize", "getFinalEmojiSize", "setFinalEmojiSize", "FontPath", "", "MaxAttachedEmoji", "NOSE", "NonSpeedUpFrameRate", "RecommendCount", "getRecommendCount", "setRecommendCount", "RecordFrameDelayMs", "RecordVideoBitRate", "SHAPE", "SKIN", "SpeedUpFrameDropFpsLimit", "SpeedUpFrameRate", "TAG", "TempFileDir", "TempGif", "TempThumb", "captureMaxDuration", "getCaptureMaxDuration", "setCaptureMaxDuration", "debugBeautyParaSpName", "isSupportHevc", "", "()Z", "setSupportHevc", "(Z)V", "segBackgroundStorkeWidth", "calcRoundCornerRadius", "size", "formatColor", "intColor", "stringColor", "getExportPath", "getFontAssetsPath", "fontName", "getFontDataPath", "getTempGifPath", "getTempRoot", "getTempThumbPath", "getTempVideoPath", "removeTempFiles", "", "setup", "useFreetype", "useNewFont", "plugin-emojicapture_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static String cIJ() {
            AppMethodBeat.i(155);
            StringBuilder sb = new StringBuilder();
            com.tencent.mm.emoji.e.a aVar = com.tencent.mm.emoji.e.a.hdT;
            String sb2 = sb.append(com.tencent.mm.emoji.e.a.awu()).append("capture_emoji/").toString();
            s.boN(sb2);
            AppMethodBeat.o(155);
            return sb2;
        }

        public static String cIK() {
            AppMethodBeat.i(156);
            String str = cIJ() + "video_" + Util.nowMilliSecond();
            AppMethodBeat.o(156);
            return str;
        }

        public static String cIL() {
            AppMethodBeat.i(157);
            String str = cIJ() + "temp_thumb" + Util.nowMilliSecond();
            AppMethodBeat.o(157);
            return str;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
            return false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:6:0x001f, code lost:
            if (r0.equals(com.tencent.mm.sdk.platformtools.LocaleUtil.HONGKONG) != false) goto L_0x0021;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:7:0x0021, code lost:
            com.tencent.matrix.trace.core.AppMethodBeat.o(158);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x002d, code lost:
            if (r0.equals(com.tencent.mm.sdk.platformtools.LocaleUtil.TAIWAN) != false) goto L_0x0021;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static boolean cIM() {
            /*
                r2 = 158(0x9e, float:2.21E-43)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                java.lang.String r0 = com.tencent.mm.sdk.platformtools.LocaleUtil.getApplicationLanguage()
                if (r0 != 0) goto L_0x0010
            L_0x000b:
                r0 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            L_0x000f:
                return r0
            L_0x0010:
                int r1 = r0.hashCode()
                switch(r1) {
                    case 115861428: goto L_0x0018;
                    case 115861812: goto L_0x0026;
                    default: goto L_0x0017;
                }
            L_0x0017:
                goto L_0x000b
            L_0x0018:
                java.lang.String r1 = "zh_HK"
                boolean r0 = r0.equals(r1)
                if (r0 == 0) goto L_0x000b
            L_0x0021:
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                goto L_0x000f
            L_0x0026:
                java.lang.String r1 = "zh_TW"
                boolean r0 = r0.equals(r1)
                if (r0 == 0) goto L_0x000b
                goto L_0x0021
                switch-data {115861428->0x0018, 115861812->0x0026, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.emojicapture.model.d.a.cIM():boolean");
        }

        public static String Gm(int i2) {
            AppMethodBeat.i(JsApiGetBackgroundAudioState.CTRL_INDEX);
            if (i2 == 0) {
                AppMethodBeat.o(JsApiGetBackgroundAudioState.CTRL_INDEX);
                return "";
            }
            ae aeVar = ae.SYK;
            String format = String.format("%06X", Arrays.copyOf(new Object[]{Integer.valueOf(16777215 & i2)}, 1));
            p.g(format, "java.lang.String.format(format, *args)");
            AppMethodBeat.o(JsApiGetBackgroundAudioState.CTRL_INDEX);
            return format;
        }

        public static int anl(String str) {
            int i2 = 0;
            AppMethodBeat.i(160);
            p.h(str, "stringColor");
            if (n.J(str, "#", false)) {
                int parseColor = Color.parseColor(str);
                AppMethodBeat.o(160);
                return parseColor;
            }
            try {
                i2 = (Integer.parseInt(str, kotlin.n.a.avR(16)) & -1) | WebView.NIGHT_MODE_COLOR;
            } catch (Exception e2) {
            }
            AppMethodBeat.o(160);
            return i2;
        }
    }

    static {
        AppMethodBeat.i(161);
        AppMethodBeat.o(161);
    }
}
