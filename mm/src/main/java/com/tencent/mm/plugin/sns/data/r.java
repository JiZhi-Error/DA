package com.tencent.mm.plugin.sns.data;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.net.Uri;
import android.os.PersistableBundle;
import android.os.Vibrator;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.b.g;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.g.a.rr;
import com.tencent.mm.g.a.va;
import com.tencent.mm.kiss.widget.textview.f;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.memory.n;
import com.tencent.mm.model.cl;
import com.tencent.mm.modelsfs.e;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.sns.d.a;
import com.tencent.mm.plugin.sns.k.c;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.bk;
import com.tencent.mm.plugin.sns.ui.bl;
import com.tencent.mm.plugin.sns.ui.j;
import com.tencent.mm.plugin.sns.ui.widget.d;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.span.q;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.protocal.protobuf.dzi;
import com.tencent.mm.protocal.protobuf.dzo;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.ui.e;
import com.tencent.mm.vfs.s;
import com.tencent.wxmm.v2helper;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import org.xwalk.core.XWalkEnvironment;

public final class r {
    public static int DEG = Integer.MAX_VALUE;
    public static String DEH = FilePathGenerator.ANDROID_DIR_SEP;
    private static String DEI = "snsb";
    private static int DEJ = -1;
    private static int DEK = -1;
    public static int DEL = 3200;
    public static int DEM = 1048576;
    private static String DEN = "";
    private static String DEO = "";
    private static String DEP = WeChatHosts.domainString(R.string.e20);
    public static int MAX_SIZE = 4194304;
    public static String oJw = "<TimelineObject>";
    public static String oJx = "</TimelineObject>";
    private static Vibrator paT;

    static {
        AppMethodBeat.i(202627);
        AppMethodBeat.o(202627);
    }

    public static String cq(int i2, String str) {
        AppMethodBeat.i(95094);
        String str2 = i2 + "-" + str;
        AppMethodBeat.o(95094);
        return str2;
    }

    public static String gN(List<cnb> list) {
        AppMethodBeat.i(95095);
        if (list == null || list.size() == 0) {
            AppMethodBeat.o(95095);
            return "";
        }
        String str = "";
        int i2 = 0;
        for (cnb cnb : list) {
            if (str.length() > 0) {
                str = str + "-";
            }
            str = str + cnb.Id;
            i2++;
            if (i2 >= 4) {
                break;
            }
        }
        AppMethodBeat.o(95095);
        return str;
    }

    private static String c(cnb cnb) {
        AppMethodBeat.i(95096);
        if (!Util.isNullOrNil(cnb.MsM)) {
            String str = cnb.MsM;
            AppMethodBeat.o(95096);
            return str;
        }
        String str2 = "";
        try {
            str2 = g.getMessageDigest(cnb.toByteArray());
        } catch (Exception e2) {
        }
        AppMethodBeat.o(95096);
        return str2;
    }

    public static String aOf(String str) {
        AppMethodBeat.i(95097);
        String str2 = "snst_" + aOs(str);
        AppMethodBeat.o(95097);
        return str2;
    }

    public static String aOg(String str) {
        AppMethodBeat.i(95098);
        String str2 = "snsu_" + aOs(str);
        AppMethodBeat.o(95098);
        return str2;
    }

    public static String aOh(String str) {
        AppMethodBeat.i(95099);
        String str2 = "snsb_" + aOs(str);
        AppMethodBeat.o(95099);
        return str2;
    }

    public static String d(cnb cnb) {
        AppMethodBeat.i(95100);
        String str = "snsb_" + aOs(cnb.Id);
        if (cnb.MsK == 1) {
            String I = e.I(str + c(cnb), cnb.MsL);
            AppMethodBeat.o(95100);
            return I;
        }
        AppMethodBeat.o(95100);
        return str;
    }

    public static String e(cnb cnb) {
        AppMethodBeat.i(95101);
        String str = "snst_" + aOs(cnb.Id);
        if (cnb.MsK == 1) {
            String I = e.I(str + c(cnb), cnb.MsL);
            AppMethodBeat.o(95101);
            return I;
        }
        AppMethodBeat.o(95101);
        return str;
    }

    public static String aOi(String str) {
        AppMethodBeat.i(95102);
        String str2 = "snsu_" + aOs(str);
        AppMethodBeat.o(95102);
        return str2;
    }

    public static String f(cnb cnb) {
        AppMethodBeat.i(95103);
        String str = "snsu_" + aOs(cnb.Id);
        if (cnb.MsK == 1) {
            String I = e.I(str + c(cnb), cnb.MsL);
            AppMethodBeat.o(95103);
            return I;
        }
        AppMethodBeat.o(95103);
        return str;
    }

    public static String g(cnb cnb) {
        AppMethodBeat.i(95104);
        String str = "snsblurt_" + aOs(cnb.Id);
        if (cnb.MsK == 1) {
            String I = e.I(str + c(cnb), cnb.MsL);
            AppMethodBeat.o(95104);
            return I;
        }
        AppMethodBeat.o(95104);
        return str;
    }

    public static String h(cnb cnb) {
        AppMethodBeat.i(95105);
        String str = "snsblurs_" + aOs(cnb.Id);
        if (cnb.MsK == 1) {
            String I = e.I(str + c(cnb), cnb.MsL);
            AppMethodBeat.o(95105);
            return I;
        }
        AppMethodBeat.o(95105);
        return str;
    }

    public static String i(cnb cnb) {
        AppMethodBeat.i(95106);
        String str = "snstblur_src_" + aOs(cnb.Id);
        if (cnb.MsK == 1) {
            String I = e.I(str + c(cnb), cnb.MsL);
            AppMethodBeat.o(95106);
            return I;
        }
        AppMethodBeat.o(95106);
        return str;
    }

    public static String j(cnb cnb) {
        AppMethodBeat.i(95107);
        String str = "sight_" + aOs(cnb.Id);
        if (cnb.MsK == 1) {
            String I = e.I(str + c(cnb), cnb.MsL);
            AppMethodBeat.o(95107);
            return I;
        }
        AppMethodBeat.o(95107);
        return str;
    }

    public static String k(cnb cnb) {
        AppMethodBeat.i(95108);
        String str = "sightad_" + aOs(cnb.Id);
        if (cnb.MsK == 1) {
            String I = e.I(str, cnb.MsL);
            AppMethodBeat.o(95108);
            return I;
        }
        AppMethodBeat.o(95108);
        return str;
    }

    public static String l(cnb cnb) {
        AppMethodBeat.i(95109);
        String str = "snsb_" + aOs(cnb.Id);
        if (cnb.MsK == 1) {
            String I = e.I(str + c(cnb), cnb.MsL);
            AppMethodBeat.o(95109);
            return I;
        }
        AppMethodBeat.o(95109);
        return str;
    }

    public static String m(cnb cnb) {
        AppMethodBeat.i(95110);
        String str = "sns_tmpb_" + aOs(cnb.Id);
        if (cnb.MsK == 1) {
            String I = e.I(str + c(cnb), cnb.MsL);
            AppMethodBeat.o(95110);
            return I;
        }
        AppMethodBeat.o(95110);
        return str;
    }

    public static String aOj(String str) {
        AppMethodBeat.i(95111);
        String str2 = "sns_tmpb_" + aOs(str);
        AppMethodBeat.o(95111);
        return str2;
    }

    public static String n(cnb cnb) {
        AppMethodBeat.i(95112);
        String str = "sns_tmpt_" + aOs(cnb.Id);
        if (cnb.MsK == 1) {
            String I = e.I(str + c(cnb), cnb.MsL);
            AppMethodBeat.o(95112);
            return I;
        }
        AppMethodBeat.o(95112);
        return str;
    }

    public static String aOk(String str) {
        AppMethodBeat.i(95113);
        String str2 = "sns_tmpt_" + aOs(str);
        AppMethodBeat.o(95113);
        return str2;
    }

    public static String o(cnb cnb) {
        AppMethodBeat.i(95114);
        String str = "sns_tmpu_" + aOs(cnb.Id);
        if (cnb.MsK == 1) {
            String I = e.I(str + c(cnb), cnb.MsL);
            AppMethodBeat.o(95114);
            return I;
        }
        AppMethodBeat.o(95114);
        return str;
    }

    public static String p(cnb cnb) {
        AppMethodBeat.i(95115);
        String str = "sns_tmps_" + aOs(cnb.Id);
        if (cnb.MsK == 1) {
            String I = e.I(str + c(cnb), cnb.MsL);
            AppMethodBeat.o(95115);
            return I;
        }
        AppMethodBeat.o(95115);
        return str;
    }

    public static String aOl(String str) {
        AppMethodBeat.i(95116);
        String str2 = "sns_tmps_" + aOs(str);
        AppMethodBeat.o(95116);
        return str2;
    }

    public static String q(cnb cnb) {
        AppMethodBeat.i(95117);
        String str = "sns_tmpsad_" + aOs(cnb.Id);
        if (cnb.MsK == 1) {
            String I = e.I(str + c(cnb), cnb.MsL);
            AppMethodBeat.o(95117);
            return I;
        }
        AppMethodBeat.o(95117);
        return str;
    }

    public static String cr(int i2, String str) {
        AppMethodBeat.i(95118);
        String str2 = i2 + "-" + str;
        AppMethodBeat.o(95118);
        return str2;
    }

    public static String aOm(String str) {
        AppMethodBeat.i(95119);
        String concat = "9_".concat(String.valueOf(str));
        AppMethodBeat.o(95119);
        return concat;
    }

    public static void bm(String str, long j2) {
        AppMethodBeat.i(95120);
        Log.d("MicroMsg.SnsUtil", " name " + str + " allTime " + (System.currentTimeMillis() - j2));
        AppMethodBeat.o(95120);
    }

    public static int aBO(String str) {
        AppMethodBeat.i(202619);
        int aOn = aOn(str);
        if (str.indexOf("png") >= 0) {
            aOn = 1;
        } else if (str.indexOf("jpg") >= 0 || str.indexOf("jpeg") >= 0) {
            aOn = 2;
        } else if (str.indexOf("mp3") >= 0) {
            aOn = 3;
        } else if (str.indexOf("wxam") >= 0) {
            aOn = 4;
        } else if (str.indexOf("vcodec") >= 0) {
            AppMethodBeat.o(202619);
            return 5;
        }
        AppMethodBeat.o(202619);
        return aOn;
    }

    private static int aOn(String str) {
        AppMethodBeat.i(202620);
        try {
            BitmapFactory.Options imageOptions = BitmapUtil.getImageOptions(str);
            if (imageOptions == null) {
                AppMethodBeat.o(202620);
                return 0;
            }
            String str2 = imageOptions.outMimeType;
            if (str2 == null) {
                AppMethodBeat.o(202620);
                return 0;
            }
            String lowerCase = str2.toLowerCase();
            if (lowerCase.indexOf("png") >= 0) {
                AppMethodBeat.o(202620);
                return 1;
            } else if (lowerCase.indexOf("jpg") >= 0 || lowerCase.indexOf("jpeg") >= 0) {
                AppMethodBeat.o(202620);
                return 2;
            } else if (lowerCase.indexOf("wxam") >= 0) {
                AppMethodBeat.o(202620);
                return 4;
            } else if (lowerCase.indexOf("vcodec") >= 0) {
                AppMethodBeat.o(202620);
                return 5;
            } else {
                AppMethodBeat.o(202620);
                return 0;
            }
        } catch (Exception e2) {
            AppMethodBeat.o(202620);
            return 0;
        }
    }

    public static boolean M(Bitmap bitmap) {
        AppMethodBeat.i(95121);
        if (bitmap == null || bitmap.isRecycled()) {
            AppMethodBeat.o(95121);
            return false;
        }
        AppMethodBeat.o(95121);
        return true;
    }

    public static boolean b(n nVar) {
        AppMethodBeat.i(95122);
        if (nVar == null || nVar.isRecycled()) {
            AppMethodBeat.o(95122);
            return false;
        }
        AppMethodBeat.o(95122);
        return true;
    }

    public static Bitmap t(String str, Bitmap bitmap) {
        String str2;
        int i2;
        AppMethodBeat.i(95123);
        if (bitmap == null) {
            AppMethodBeat.o(95123);
            return null;
        }
        if (Util.isNullOrNil(str)) {
            str2 = "";
        } else {
            int lastIndexOf = str.lastIndexOf(DEH);
            if (lastIndexOf > 0 && lastIndexOf + 1 < str.length()) {
                String substring = str.substring(lastIndexOf + 1);
                if (substring.startsWith(DEI) || substring.startsWith("sns_tmpb_")) {
                    str2 = str;
                } else if (substring.startsWith("snst_") || substring.startsWith("snsu_")) {
                    str2 = "";
                }
            }
            str2 = str;
        }
        if (Util.isNullOrNil(str2)) {
            AppMethodBeat.o(95123);
            return bitmap;
        }
        try {
            Log.i("MicroMsg.SnsUtil", "[changes below by tomys]parsing jpg, path: %s, size: %s", str, Long.valueOf(s.boW(str)));
            Exif fromFile = Exif.fromFile(str);
            if (fromFile != null) {
                i2 = fromFile.getOrientationInDegree() % v2helper.VOIP_ENC_HEIGHT_LV1;
            } else {
                i2 = 0;
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.SnsUtil", e2, "Failed parsing JPEG file: ".concat(String.valueOf(str2)), new Object[0]);
            i2 = 0;
        } catch (Throwable th) {
            AppMethodBeat.o(95123);
            throw th;
        }
        Log.d("MicroMsg.SnsUtil", "exifPath : %s degree : %d", str2, Integer.valueOf(i2));
        Bitmap rotate = BitmapUtil.rotate(bitmap, (float) i2);
        AppMethodBeat.o(95123);
        return rotate;
    }

    public static n aOo(String str) {
        AppMethodBeat.i(95124);
        try {
            Log.i("MicroMsg.SnsUtil", "decodeFileToBlurThumbBitmap " + s.YS(str));
            if (!s.YS(str)) {
                AppMethodBeat.o(95124);
                return null;
            }
            n aOq = aOq(str);
            AppMethodBeat.o(95124);
            return aOq;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.SnsUtil", e2, "snsdecode error", new Object[0]);
            AppMethodBeat.o(95124);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x016d  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x019a A[SYNTHETIC, Splitter:B:74:0x019a] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x01a7 A[SYNTHETIC, Splitter:B:80:0x01a7] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x009e A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap aOp(java.lang.String r14) {
        /*
        // Method dump skipped, instructions count: 459
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.data.r.aOp(java.lang.String):android.graphics.Bitmap");
    }

    public static n aOq(String str) {
        AppMethodBeat.i(95126);
        try {
            if (!s.YS(str)) {
                AppMethodBeat.o(95126);
                return null;
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            BitmapUtil.bindlowMemeryOption(options);
            options.inSampleSize = 1;
            while (options.inSampleSize <= 10) {
                try {
                    Log.i("MicroMsg.SnsUtil", "decodeFileToBitmap %s", Integer.valueOf(options.inSampleSize));
                    long currentTicks = Util.currentTicks();
                    n c2 = a.c(str, options);
                    long ticksToNow = Util.ticksToNow(currentTicks);
                    if (c2 != null) {
                        c.bn(str, ticksToNow);
                    }
                    AppMethodBeat.o(95126);
                    return c2;
                } catch (OutOfMemoryError e2) {
                    options.inSampleSize++;
                }
            }
            AppMethodBeat.o(95126);
            return null;
        } catch (Exception e3) {
            Log.printErrStackTrace("MicroMsg.SnsUtil", e3, "snsdecode error", new Object[0]);
            AppMethodBeat.o(95126);
            return null;
        }
    }

    public static String aOr(String str) {
        AppMethodBeat.i(95127);
        StringBuffer stringBuffer = new StringBuffer(str);
        while (stringBuffer.length() < 25) {
            stringBuffer.insert(0, AppEventsConstants.EVENT_PARAM_VALUE_NO);
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(95127);
        return stringBuffer2;
    }

    public static String Jb(long j2) {
        AppMethodBeat.i(95128);
        String bigInteger = new BigInteger(Long.toBinaryString(j2), 2).toString();
        AppMethodBeat.o(95128);
        return bigInteger;
    }

    public static String Jc(long j2) {
        AppMethodBeat.i(95129);
        if (j2 == 0) {
            AppMethodBeat.o(95129);
            return "";
        }
        String aOr = aOr(new BigInteger(Long.toBinaryString(j2), 2).toString());
        AppMethodBeat.o(95129);
        return aOr;
    }

    private static String aOs(String str) {
        AppMethodBeat.i(95130);
        if (str == null) {
            AppMethodBeat.o(95130);
            return "";
        }
        int length = str.length();
        int i2 = 0;
        while (i2 < length && str.charAt(i2) == '0') {
            i2++;
        }
        String substring = str.substring(i2);
        AppMethodBeat.o(95130);
        return substring;
    }

    private static Rect av(Bitmap bitmap) {
        AppMethodBeat.i(95131);
        int width = bitmap.getWidth();
        Rect rect = new Rect(width / 4, 0, (int) (((double) (width * 3)) / 4.0d), bitmap.getHeight());
        AppMethodBeat.o(95131);
        return rect;
    }

    private static Rect aw(Bitmap bitmap) {
        AppMethodBeat.i(95132);
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        AppMethodBeat.o(95132);
        return rect;
    }

    public static Bitmap z(List<n> list, int i2) {
        Rect aw;
        int i3 = 0;
        AppMethodBeat.i(95133);
        for (n nVar : list) {
            if (!b(nVar)) {
                AppMethodBeat.o(95133);
                return null;
            }
        }
        if (i2 <= 0) {
            AppMethodBeat.o(95133);
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i2, i2, Bitmap.Config.ARGB_8888);
        int size = list.size();
        LinkedList linkedList = new LinkedList();
        int i4 = i2 >> 1;
        int i5 = i4 + 2;
        int i6 = i4 - 2;
        if (size == 2) {
            Rect rect = new Rect(0, 0, i6, i2);
            Rect rect2 = new Rect(i5, 0, i2, i2);
            linkedList.add(rect);
            linkedList.add(rect2);
        } else if (size == 3) {
            Rect rect3 = new Rect(0, 0, i6, i2);
            Rect rect4 = new Rect(i5, 0, i2, i6);
            Rect rect5 = new Rect(i5, i5, i2, i2);
            linkedList.add(rect3);
            linkedList.add(rect4);
            linkedList.add(rect5);
        } else if (size >= 4) {
            Rect rect6 = new Rect(0, 0, i6, i6);
            Rect rect7 = new Rect(0, i5, i6, i2);
            Rect rect8 = new Rect(i5, 0, i2, i6);
            Rect rect9 = new Rect(i5, i5, i2, i2);
            linkedList.add(rect6);
            linkedList.add(rect7);
            linkedList.add(rect8);
            linkedList.add(rect9);
        }
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawColor(-1);
        int i7 = 0;
        while (i3 < list.size() && i7 < 4) {
            Bitmap aSb = list.get(i3).aSb();
            Rect rect10 = (Rect) linkedList.get(i3);
            switch (list.size()) {
                case 1:
                    aw = aw(aSb);
                    break;
                case 2:
                    aw = av(aSb);
                    break;
                case 3:
                    if (i3 == 0) {
                        aw = av(aSb);
                        break;
                    } else {
                        aw = aw(aSb);
                        break;
                    }
                default:
                    aw = aw(aSb);
                    break;
            }
            canvas.drawBitmap(aSb, aw, rect10, (Paint) null);
            i3++;
            i7++;
        }
        canvas.save();
        canvas.restore();
        AppMethodBeat.o(95133);
        return createBitmap;
    }

    public static boolean aOt(String str) {
        AppMethodBeat.i(95134);
        boolean startsWith = str.startsWith(b.aKD());
        AppMethodBeat.o(95134);
        return startsWith;
    }

    public static boolean aOu(String str) {
        AppMethodBeat.i(95135);
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapUtil.decodeFile(str, options);
            int i2 = options.outWidth;
            int i3 = options.outHeight;
            if (i3 >= i2 * 2 || i2 >= i3 * 2) {
                AppMethodBeat.o(95135);
                return true;
            }
            AppMethodBeat.o(95135);
            return false;
        } catch (Exception e2) {
            Log.e("MicroMsg.SnsUtil", "get error setImageExtInfo");
            AppMethodBeat.o(95135);
            return false;
        }
    }

    public static boolean aOv(String str) {
        AppMethodBeat.i(95136);
        int i2 = MAX_SIZE;
        try {
            BitmapFactory.Options imageOptions = BitmapUtil.getImageOptions(str);
            int i3 = imageOptions.outWidth;
            int i4 = imageOptions.outHeight;
            if (i4 <= 0 && i3 <= 0) {
                AppMethodBeat.o(95136);
                return false;
            } else if (i4 >= i3 * 2 || i3 >= i4 * 2) {
                AppMethodBeat.o(95136);
                return false;
            } else if (i4 * i3 > i2) {
                AppMethodBeat.o(95136);
                return true;
            } else {
                AppMethodBeat.o(95136);
                return false;
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.SnsUtil", "get error setImageExtInfo");
            AppMethodBeat.o(95136);
            return false;
        }
    }

    public static boolean Yl(int i2) {
        AppMethodBeat.i(95137);
        MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).edit().putInt("sns_control_flag", i2).commit();
        AppMethodBeat.o(95137);
        return true;
    }

    public static int eZu() {
        AppMethodBeat.i(95138);
        int i2 = MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getInt("sns_control_flag", 0);
        AppMethodBeat.o(95138);
        return i2;
    }

    public static boolean Ym(int i2) {
        AppMethodBeat.i(95139);
        MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).edit().putInt("sns_respone_count", i2).commit();
        AppMethodBeat.o(95139);
        return true;
    }

    public static int eZv() {
        AppMethodBeat.i(95140);
        int i2 = MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getInt("sns_respone_count", 20);
        AppMethodBeat.o(95140);
        return i2;
    }

    public static String R(CharSequence charSequence) {
        AppMethodBeat.i(95141);
        if (charSequence == null) {
            AppMethodBeat.o(95141);
            return "";
        }
        SpannableString spannableString = new SpannableString(charSequence);
        q[] qVarArr = (q[]) spannableString.getSpans(0, spannableString.length(), q.class);
        Log.d("MicroMsg.SnsUtil", "removeClickSpanInString, clickSpans.length:%d", Integer.valueOf(qVarArr.length));
        for (q qVar : qVarArr) {
            spannableString.removeSpan(qVar);
        }
        String spannableString2 = spannableString.toString();
        AppMethodBeat.o(95141);
        return spannableString2;
    }

    public static void b(View view, Context context) {
        AppMethodBeat.i(95142);
        if (view != null && com.tencent.mm.cb.a.ez(context) > 1.0f) {
            float ez = com.tencent.mm.cb.a.ez(context);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix(context, 60);
            if (layoutParams.width >= 0 && layoutParams.height >= 0) {
                int i2 = (int) (((float) layoutParams.width) * ez);
                int i3 = (int) (ez * ((float) layoutParams.height));
                if (i2 > fromDPToPix) {
                    i2 = fromDPToPix;
                }
                layoutParams.width = i2;
                if (i3 <= fromDPToPix) {
                    fromDPToPix = i3;
                }
                layoutParams.height = fromDPToPix;
                view.setLayoutParams(layoutParams);
            }
        }
        AppMethodBeat.o(95142);
    }

    public static int eZw() {
        AppMethodBeat.i(95143);
        Context context = MMApplicationContext.getContext();
        if (NetStatusUtil.is2G(context)) {
            AppMethodBeat.o(95143);
            return 1;
        } else if (NetStatusUtil.is3G(context)) {
            AppMethodBeat.o(95143);
            return 2;
        } else if (NetStatusUtil.is4G(context)) {
            AppMethodBeat.o(95143);
            return 3;
        } else if (NetStatusUtil.isWifi(context)) {
            AppMethodBeat.o(95143);
            return 4;
        } else {
            AppMethodBeat.o(95143);
            return 0;
        }
    }

    public static boolean u(SnsInfo snsInfo) {
        if (snsInfo.field_type == 3 || snsInfo.field_type == 4 || snsInfo.field_type == 42 || snsInfo.field_type == 5 || snsInfo.field_type == 6 || snsInfo.field_type == 9 || snsInfo.field_type == 10 || snsInfo.field_type == 11 || snsInfo.field_type == 12 || snsInfo.field_type == 13 || snsInfo.field_type == 14 || snsInfo.field_type == 17 || snsInfo.field_type == 22 || snsInfo.field_type == 23) {
            return true;
        }
        return false;
    }

    public static long baU() {
        AppMethodBeat.i(95144);
        long rawOffset = ((long) ((int) (((long) TimeZone.getDefault().getRawOffset()) / Util.MILLSECONDS_OF_MINUTE))) / 60;
        AppMethodBeat.o(95144);
        return rawOffset;
    }

    public static SpannableString a(String str, Context context, TextView textView) {
        AppMethodBeat.i(95145);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(95145);
            return null;
        }
        SpannableString spannableString = new SpannableString(l.e(context, "<img src=\"original_label.png\"/>  " + str, (float) ((int) textView.getTextSize())));
        AppMethodBeat.o(95145);
        return spannableString;
    }

    public static String v(SnsInfo snsInfo) {
        AppMethodBeat.i(95146);
        if (snsInfo == null) {
            AppMethodBeat.o(95146);
            return AppEventsConstants.EVENT_PARAM_VALUE_NO;
        }
        String Jb = Jb(snsInfo.field_snsId);
        AppMethodBeat.o(95146);
        return Jb;
    }

    public static long aOw(String str) {
        long j2 = 0;
        AppMethodBeat.i(163071);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(163071);
        } else {
            try {
                j2 = new BigInteger(str).longValue();
                Log.i("MicroMsg.SnsUtil", "seq %s to snsId %d ", str, Long.valueOf(j2));
            } catch (Exception e2) {
            }
            AppMethodBeat.o(163071);
        }
        return j2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int aOx(java.lang.String r7) {
        /*
        // Method dump skipped, instructions count: 105
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.data.r.aOx(java.lang.String):int");
    }

    public static void a(SnsAdClick snsAdClick) {
        AppMethodBeat.i(95149);
        rr rrVar = new rr();
        rrVar.dYk.dYl = snsAdClick;
        EventCenter.instance.publish(rrVar);
        AppMethodBeat.o(95149);
    }

    public static List<PointF> aOy(String str) {
        AppMethodBeat.i(95150);
        ArrayList arrayList = new ArrayList();
        if (!Util.isNullOrNil(str)) {
            String[] split = str.split("[|]");
            int length = split.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                String[] split2 = split[i2].split("[_]");
                if (split2.length != 2) {
                    Log.e("MicroMsg.SnsUtil", "invalid gesture str! %s", str);
                    arrayList.clear();
                    break;
                }
                float f2 = Util.getFloat(split2[0], -1.0f);
                float f3 = Util.getFloat(split2[1], -1.0f);
                if (f2 == -1.0f || f3 == -1.0f) {
                    Log.e("MicroMsg.SnsUtil", "invalid gesture str! %s", str);
                    arrayList.clear();
                } else {
                    arrayList.add(new PointF(f2, f3));
                    i2++;
                }
            }
            Log.e("MicroMsg.SnsUtil", "invalid gesture str! %s", str);
            arrayList.clear();
        }
        AppMethodBeat.o(95150);
        return arrayList;
    }

    public static void uN(boolean z) {
        AppMethodBeat.i(95151);
        va vaVar = new va();
        vaVar.ebs.enable = z;
        EventCenter.instance.publish(vaVar);
        AppMethodBeat.o(95151);
    }

    public static String gO(List<PointF> list) {
        AppMethodBeat.i(95152);
        StringBuilder sb = new StringBuilder("");
        for (PointF pointF : list) {
            sb.append(pointF.x);
            sb.append("_");
            sb.append(pointF.y);
            sb.append("|");
        }
        if (list.size() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(95152);
        return sb2;
    }

    public static void e(long[] jArr) {
        AppMethodBeat.i(95153);
        try {
            if (paT == null) {
                paT = (Vibrator) MMApplicationContext.getContext().getSystemService("vibrator");
            }
            paT.vibrate(jArr, -1);
            AppMethodBeat.o(95153);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.SnsUtil", e2, "vibrate error!", new Object[0]);
            AppMethodBeat.o(95153);
        }
    }

    public static String kb(String str, String str2) {
        AppMethodBeat.i(95154);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            Log.e("MicroMsg.SnsUtil", "appendAdUxInfo empty:" + str + ", " + str2);
            AppMethodBeat.o(95154);
            return str;
        }
        String str3 = "";
        try {
            str3 = URLEncoder.encode(str2, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
        } catch (Exception e2) {
            Log.e("MicroMsg.SnsUtil", "appendAdUxInfo exp:" + e2.toString() + ", " + str2);
        }
        String aJ = aJ(str, "uxinfo", str3);
        Log.i("MicroMsg.SnsUtil", "appendAdUxInfo, ret=".concat(String.valueOf(aJ)));
        AppMethodBeat.o(95154);
        return aJ;
    }

    public static void h(Intent intent, String str) {
        String str2;
        AppMethodBeat.i(95155);
        String str3 = e.p.OzI;
        if (str == null) {
            str2 = "";
        } else {
            str2 = str;
        }
        intent.putExtra(str3, str2);
        Log.i("MicroMsg.SnsUtil", "appendAdUxInfoForAdPay, uxInfo=".concat(String.valueOf(str)));
        AppMethodBeat.o(95155);
    }

    public static void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i2) {
        AppMethodBeat.i(95156);
        if (!Util.isNullOrNil(str2)) {
            str2 = i.o(str2, String.format("gdt_vid=%s", str5), String.format("weixinadinfo=%s.%s.0.0", str4, str5));
        }
        com.tencent.mm.plugin.appbrand.api.g gVar = new com.tencent.mm.plugin.appbrand.api.g();
        gVar.dCw = str6;
        gVar.username = str;
        gVar.version = Util.safeParseInt(str3);
        gVar.kHw = str2;
        gVar.scene = i2;
        gVar.kHy = new PersistableBundle();
        gVar.kHy.putString("adUxInfo", str7);
        ((com.tencent.mm.plugin.appbrand.service.r) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.service.r.class)).a(MMApplicationContext.getContext(), gVar);
        Log.i("MicroMsg.SnsUtil", "jumpWeApp userName=" + str + ", path=" + str2 + ", ver=" + str3 + ", scene=" + gVar.scene + ", uxinfo=" + str7);
        AppMethodBeat.o(95156);
    }

    private static String aJ(String str, String str2, String str3) {
        String str4;
        String str5;
        String str6;
        AppMethodBeat.i(95157);
        try {
            int indexOf = str.indexOf("#");
            if (indexOf >= 0) {
                str5 = str.substring(0, indexOf);
                str4 = str.substring(indexOf);
            } else {
                str4 = "";
                str5 = str;
            }
            if (str5.contains("?")) {
                str6 = str5 + "&" + str2 + "=" + str3;
            } else {
                str6 = str5 + "?" + str2 + "=" + str3;
            }
            str = str6 + str4;
            AppMethodBeat.o(95157);
        } catch (Exception e2) {
            Log.e("MicroMsg.SnsUtil", "appendUrlParams exp:" + e2.toString());
            AppMethodBeat.o(95157);
        }
        return str;
    }

    public static String eZx() {
        AppMethodBeat.i(95161);
        if (Util.isNullOrNil(DEN)) {
            long aWz = cl.aWz();
            StringBuilder sb = new StringBuilder();
            com.tencent.mm.kernel.g.aAf();
            DEN = sb.append(com.tencent.mm.kernel.a.ayV()).append("_").append(aWz).toString();
        }
        String str = DEN;
        AppMethodBeat.o(95161);
        return str;
    }

    public static void eZy() {
        DEN = "";
    }

    public static void aOz(String str) {
        AppMethodBeat.i(95162);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(95162);
            return;
        }
        DEO += str + ";";
        AppMethodBeat.o(95162);
    }

    public static String eZz() {
        String str = DEO;
        DEO = "";
        return str;
    }

    public static String aOA(String str) {
        Uri parse;
        AppMethodBeat.i(176243);
        if (Util.isNullOrNil(str) || (parse = Uri.parse(str)) == null) {
            str = "";
        } else if (Util.isEqual(parse.getHost(), DEP)) {
            str = Util.nullAs(parse.getQueryParameter("__biz"), "") + "_" + Util.nullAs(parse.getQueryParameter("mid"), "") + "_" + Util.nullAs(parse.getQueryParameter("idx"), "");
        }
        AppMethodBeat.o(176243);
        return str;
    }

    public static boolean Yn(int i2) {
        if (i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4 || i2 == 5) {
            return true;
        }
        return false;
    }

    public static int Yo(int i2) {
        if (i2 == 1) {
            return 5;
        }
        if (i2 == 2) {
            return 8;
        }
        if (i2 == 3) {
            return 9;
        }
        if (i2 == 4 || i2 == 5) {
            return 6;
        }
        return 0;
    }

    public static boolean a(dzo dzo) {
        AppMethodBeat.i(202621);
        if (dzo == null || Util.isNullOrNil(dzo.MZm)) {
            AppMethodBeat.o(202621);
            return false;
        }
        AppMethodBeat.o(202621);
        return true;
    }

    public static dzo a(dzi dzi, SnsObject snsObject) {
        AppMethodBeat.i(202622);
        if (dzi == null || snsObject == null) {
            AppMethodBeat.o(202622);
            return null;
        }
        String str = dzi.iAc;
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(202622);
            return null;
        }
        String str2 = dzi.MKC;
        LinkedList<dzo> linkedList = snsObject.CommentUserList;
        if (linkedList != null) {
            for (int size = linkedList.size() - 1; size >= 0; size--) {
                dzo dzo = linkedList.get(size);
                if (dzo != null && TextUtils.equals(str2, dzo.Username) && TextUtils.equals(dzo.iAc, str)) {
                    AppMethodBeat.o(202622);
                    return dzo;
                }
            }
        }
        AppMethodBeat.o(202622);
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:145:0x0461  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x049f  */
    /* JADX WARNING: Removed duplicated region for block: B:302:0x088c  */
    /* JADX WARNING: Removed duplicated region for block: B:305:0x08a2  */
    /* JADX WARNING: Removed duplicated region for block: B:328:0x0904  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tencent.mm.plugin.sns.ui.bl a(com.tencent.mm.plugin.sns.storage.SnsInfo r18, com.tencent.mm.protocal.protobuf.SnsObject r19, android.content.Context r20, com.tencent.mm.plugin.sns.ui.bk r21, boolean r22, com.tencent.mm.storage.bv r23, java.lang.String r24, java.util.Map<java.lang.String, java.lang.Boolean> r25, java.util.Map<java.lang.String, java.lang.String> r26, java.util.List<java.lang.String> r27) {
        /*
        // Method dump skipped, instructions count: 2555
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.data.r.a(com.tencent.mm.plugin.sns.storage.SnsInfo, com.tencent.mm.protocal.protobuf.SnsObject, android.content.Context, com.tencent.mm.plugin.sns.ui.bk, boolean, com.tencent.mm.storage.bv, java.lang.String, java.util.Map, java.util.Map, java.util.List):com.tencent.mm.plugin.sns.ui.bl");
    }

    private static void a(final bl blVar, final bk bkVar, Context context) {
        com.tencent.mm.kiss.widget.textview.a.a textViewConfig;
        SpannableStringBuilder spannableStringBuilder;
        boolean z;
        int viewWidth;
        com.tencent.mm.kiss.widget.textview.b bVar;
        AppMethodBeat.i(202624);
        LinkedList<dzo> linkedList = blVar.DqN.CommentUserList;
        blVar.ENl = new l();
        for (dzo dzo : linkedList) {
            dzo.iAc = Util.nullAsNil(dzo.iAc);
            if (com.tencent.mm.plugin.sns.ui.widget.e.iY(dzo.MYX, 16)) {
                textViewConfig = com.tencent.mm.plugin.sns.ui.widget.c.flh().getTextViewConfig();
            } else {
                textViewConfig = d.fli().getTextViewConfig();
            }
            CharSequence a2 = com.tencent.mm.plugin.sns.ui.widget.e.a(context, dzo, new j() {
                /* class com.tencent.mm.plugin.sns.data.r.AnonymousClass1 */

                @Override // com.tencent.mm.pluginsdk.ui.span.q.a, com.tencent.mm.plugin.sns.ui.j
                public final void b(View view, Object obj) {
                    AppMethodBeat.i(202618);
                    if (blVar.DqO == null || !blVar.DqO.isAd()) {
                        bkVar.EBk.source = 14;
                    } else {
                        bkVar.EBk.source = 0;
                    }
                    bkVar.EBk.b(view, obj);
                    AppMethodBeat.o(202618);
                }
            }, blVar.DqO.field_type, blVar.DqO.getUserName(), 1, ah.DKd, ah.DKf, blVar.DqO);
            if (com.tencent.mm.plugin.sns.ui.widget.e.c(dzo)) {
                String b2 = com.tencent.mm.plugin.sns.ui.widget.e.b(dzo);
                String string = context.getResources().getString(R.string.h5h);
                if (!Util.isNullOrNil(b2)) {
                    b2 = b2 + ": ";
                }
                String str = ("" + b2) + string;
                int indexOf = str.indexOf(":");
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(str);
                if (indexOf != -1) {
                    spannableStringBuilder2.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.BW_50)), 0, str.length(), 0);
                    spannableStringBuilder2.setSpan(new BackgroundColorSpan(context.getResources().getColor(R.color.BW_90)), indexOf + 1, str.length(), 0);
                }
                spannableStringBuilder = spannableStringBuilder2;
            } else {
                spannableStringBuilder = a2;
            }
            com.tencent.mm.kiss.widget.textview.c cVar = com.tencent.mm.kiss.widget.textview.c.hue;
            if (textViewConfig == null || (bVar = cVar.huf.get(Integer.valueOf(com.tencent.mm.kiss.widget.textview.c.a(textViewConfig)))) == null) {
                z = false;
            } else {
                LinkedList<f> linkedList2 = bVar.hud.get(spannableStringBuilder.toString());
                if (linkedList2 == null || linkedList2.size() == 0) {
                    z = false;
                } else {
                    z = true;
                }
            }
            if (z) {
                blVar.ENl.a(dzo, spannableStringBuilder);
                if (!Util.isNullOrNil(dzo.MYY) && dzo.MYY.get(0) != null && !com.tencent.mm.plugin.sns.ui.widget.e.c(dzo)) {
                    blVar.ENl.a(dzo, Util.nullAsNil(dzo.MYY.get(0).Md5));
                }
                a(dzo, spannableStringBuilder, blVar);
            } else {
                blVar.ENl.a(dzo, spannableStringBuilder);
                if (!Util.isNullOrNil(dzo.MYY) && dzo.MYY.get(0) != null && !com.tencent.mm.plugin.sns.ui.widget.e.c(dzo)) {
                    blVar.ENl.a(dzo, Util.nullAsNil(dzo.MYY.get(0).Md5));
                }
                a(dzo, spannableStringBuilder, blVar);
                if (com.tencent.mm.plugin.sns.ui.widget.e.iY(dzo.MYX, 16)) {
                    viewWidth = com.tencent.mm.plugin.sns.ui.widget.c.flh().getViewWidth();
                } else {
                    viewWidth = d.fli().getViewWidth();
                }
                if (viewWidth > 0) {
                    com.tencent.mm.kiss.widget.textview.c.hue.a(textViewConfig, com.tencent.mm.kiss.widget.textview.d.a(spannableStringBuilder, viewWidth, textViewConfig).aBl());
                }
            }
        }
        AppMethodBeat.o(202624);
    }

    private static String a(TimeLineObject timeLineObject, Context context, Map<String, String> map) {
        AppMethodBeat.i(202625);
        if (timeLineObject.ContentObj.LoU == 26) {
            String string = context.getString(R.string.c8z);
            AppMethodBeat.o(202625);
            return string;
        } else if ((timeLineObject.ContentObj.LoU == 28 || timeLineObject.ContentObj.LoU == 29 || timeLineObject.ContentObj.LoU == 37 || timeLineObject.ContentObj.LoU == 38 || timeLineObject.ContentObj.LoU == 36) && (((aj) com.tencent.mm.kernel.g.ah(aj.class)).showFinderEntry() || ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_finder_no_support_share_switch, 0) == 0)) {
            if (timeLineObject.ContentObj.LoU == 28 && timeLineObject.ContentObj.dME != null && !Util.isNullOrNil(timeLineObject.ContentObj.dME.nickname)) {
                String str = context.getString(R.string.chy) + " · " + timeLineObject.ContentObj.dME.nickname;
                AppMethodBeat.o(202625);
                return str;
            } else if (timeLineObject.ContentObj.LoU != 36 || timeLineObject.ContentObj.Lpd == null || Util.isNullOrNil(timeLineObject.ContentObj.Lpd.nickname)) {
                String string2 = context.getString(R.string.chy);
                AppMethodBeat.o(202625);
                return string2;
            } else {
                String str2 = context.getString(R.string.chy) + " · " + timeLineObject.ContentObj.Lpd.nickname;
                AppMethodBeat.o(202625);
                return str2;
            }
        } else if ((timeLineObject.ContentObj.LoU == 34 || timeLineObject.ContentObj.LoU == 43) && (((aj) com.tencent.mm.kernel.g.ah(aj.class)).showFinderEntry() || ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_finder_no_support_share_switch, 0) == 0)) {
            if ((timeLineObject.ContentObj.LoU == 34 || timeLineObject.ContentObj.LoU == 43) && timeLineObject.ContentObj.Lpc != null && !Util.isNullOrNil(timeLineObject.ContentObj.Lpc.nickName)) {
                String str3 = context.getString(R.string.chy) + " · " + timeLineObject.ContentObj.Lpc.nickName;
                AppMethodBeat.o(202625);
                return str3;
            }
            String string3 = context.getString(R.string.chy);
            AppMethodBeat.o(202625);
            return string3;
        } else if (timeLineObject.ContentObj.LoU == 30) {
            WxaAttributes Xk = ((com.tencent.mm.plugin.appbrand.service.q) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.service.q.class)).Xk(timeLineObject.weappInfo.username);
            if (Xk == null || Util.isNullOrNil(Xk.field_nickname)) {
                String string4 = context.getString(R.string.a0f);
                AppMethodBeat.o(202625);
                return string4;
            }
            String str4 = Xk.field_nickname;
            AppMethodBeat.o(202625);
            return str4;
        } else {
            if (timeLineObject.ContentObj.LoU == 39) {
                switch (timeLineObject.ContentObj.izD) {
                    case 3:
                    case XWalkEnvironment.TEST_APK_START_VERSION /*{ENCODED_INT: 100000000}*/:
                        if (timeLineObject.ContentObj.LoU != 28 || timeLineObject.ContentObj.dME == null || Util.isNullOrNil(timeLineObject.ContentObj.dME.nickname)) {
                            String string5 = context.getString(R.string.chy);
                            AppMethodBeat.o(202625);
                            return string5;
                        }
                        String str5 = context.getString(R.string.chy) + " · " + timeLineObject.ContentObj.dME.nickname;
                        AppMethodBeat.o(202625);
                        return str5;
                }
            }
            if (timeLineObject.ContentObj.LoU != 1 || timeLineObject.ContentObj.Lpc == null) {
                if (timeLineObject.AppInfo == null) {
                    AppMethodBeat.o(202625);
                    return "";
                } else if (Util.isNullOrNil(timeLineObject.AppInfo.Id)) {
                    AppMethodBeat.o(202625);
                    return "";
                } else if (map.containsKey(timeLineObject.AppInfo.Id)) {
                    String str6 = map.get(timeLineObject.AppInfo.Id);
                    AppMethodBeat.o(202625);
                    return str6;
                } else {
                    String q = h.q(context, timeLineObject.AppInfo.Id, Util.getInt(timeLineObject.AppInfo.Version, 0));
                    if (Util.isNullOrNil(q)) {
                        AppMethodBeat.o(202625);
                        return q;
                    }
                    map.put(timeLineObject.AppInfo.Id, q);
                    AppMethodBeat.o(202625);
                    return q;
                }
            } else if (!Util.isNullOrNil(timeLineObject.ContentObj.Lpc.nickName)) {
                String str7 = timeLineObject.ContentObj.Lpc.nickName;
                AppMethodBeat.o(202625);
                return str7;
            } else {
                AppMethodBeat.o(202625);
                return "";
            }
        }
    }

    private static void a(dzo dzo, CharSequence charSequence, bl blVar) {
        AppMethodBeat.i(202626);
        if (ah.DKc <= 0) {
            blVar.ENl.b(dzo, charSequence);
        } else if (charSequence instanceof SpannableStringBuilder) {
            blVar.ENl.b(dzo, com.tencent.mm.plugin.sns.ui.widget.e.b((SpannableStringBuilder) charSequence));
            AppMethodBeat.o(202626);
            return;
        }
        AppMethodBeat.o(202626);
    }

    private static String a(bl blVar) {
        if (blVar.DqS == null) {
            return "";
        }
        return blVar.DqS.UserName;
    }
}
