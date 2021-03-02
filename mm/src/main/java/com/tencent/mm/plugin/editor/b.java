package com.tencent.mm.plugin.editor;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.Spanned;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.b.f;
import com.tencent.mm.b.g;
import com.tencent.mm.memory.a.c;
import com.tencent.mm.plugin.editor.model.a.a;
import com.tencent.mm.plugin.editor.model.a.d;
import com.tencent.mm.plugin.editor.model.a.h;
import com.tencent.mm.plugin.editor.model.a.i;
import com.tencent.mm.plugin.editor.model.a.j;
import com.tencent.mm.plugin.editor.model.a.l;
import com.tencent.mm.plugin.editor.model.a.m;
import com.tencent.mm.plugin.fav.a.ao;
import com.tencent.mm.plugin.fav.ui.e;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.LongBitmapHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import com.tencent.tavkit.component.TAVExporter;
import java.util.ArrayList;
import java.util.regex.Pattern;

public final class b {
    public static b qOg = null;
    private static f<String, Integer> qOh = new c(30);

    static {
        AppMethodBeat.i(181633);
        AppMethodBeat.o(181633);
    }

    public static String fJ(String str, String str2) {
        String str3;
        int i2;
        int i3;
        int i4 = TAVExporter.VIDEO_EXPORT_HEIGHT;
        AppMethodBeat.i(181615);
        if (Util.isNullOrNil(str2)) {
            str3 = ao.cVk() + FilePathGenerator.ANDROID_DIR_SEP + (g.getMessageDigest((str + System.currentTimeMillis()).getBytes()) + "_HD");
        } else {
            str3 = str2;
        }
        if (!s.YS(str3)) {
            BitmapFactory.Options imageOptions = BitmapUtil.getImageOptions(str);
            if (imageOptions == null || imageOptions.outWidth <= 0 || imageOptions.outHeight <= 0) {
                Log.e("MicroMsg.EditorUtil", "GetImageOptions Error");
                AppMethodBeat.o(181615);
                return null;
            }
            int i5 = imageOptions.outHeight;
            int i6 = imageOptions.outWidth;
            if (i6 > 1280) {
                i6 = 1280;
            }
            if (i5 <= 1280) {
                i4 = i5;
            }
            if (imageOptions.outHeight < imageOptions.outWidth) {
                i2 = i4;
                i3 = i6;
            } else {
                i2 = i6;
                i3 = i4;
            }
            if (LongBitmapHandler.isLongPicture(str) > 0) {
                i3 = imageOptions.outHeight;
                i2 = imageOptions.outWidth;
            }
            BitmapUtil.createThumbNail(str, i3, i2, Bitmap.CompressFormat.JPEG, 95, str3, true);
        }
        AppMethodBeat.o(181615);
        return str3;
    }

    public static String fK(String str, String str2) {
        String str3;
        int i2;
        int i3;
        int i4 = 800;
        AppMethodBeat.i(181616);
        if (Util.isNullOrNil(str2)) {
            str3 = ao.cVk() + FilePathGenerator.ANDROID_DIR_SEP + (g.getMessageDigest((str + System.currentTimeMillis()).getBytes()) + "_TH");
        } else {
            str3 = str2;
        }
        if (!s.YS(str3)) {
            BitmapFactory.Options imageOptions = BitmapUtil.getImageOptions(str);
            if (imageOptions == null || imageOptions.outWidth <= 0 || imageOptions.outHeight <= 0) {
                Log.e("MicroMsg.EditorUtil", "GetImageOptions Error,use orignal file");
                AppMethodBeat.o(181616);
                return null;
            }
            int i5 = imageOptions.outHeight;
            int i6 = imageOptions.outWidth;
            while (i6 * i5 > 2764800) {
                i6 >>= 1;
                i5 >>= 1;
            }
            if (i6 > 800) {
                i6 = 800;
            }
            if (i5 <= 800) {
                i4 = i5;
            }
            if (imageOptions.outHeight < imageOptions.outWidth) {
                i2 = i4;
                i3 = i6;
            } else {
                i2 = i6;
                i3 = i4;
            }
            BitmapUtil.createThumbNail(str, i3, i2, Bitmap.CompressFormat.JPEG, 95, str3, true);
        }
        AppMethodBeat.o(181616);
        return str3;
    }

    public static Bitmap alI(String str) {
        AppMethodBeat.i(181617);
        Bitmap bd = e.bd(str, false);
        if (bd != null) {
            AppMethodBeat.o(181617);
            return bd;
        } else if (Util.isNullOrNil((String) null)) {
            AppMethodBeat.o(181617);
            return null;
        } else {
            Bitmap bd2 = e.bd(null, false);
            AppMethodBeat.o(181617);
            return bd2;
        }
    }

    public static a a(a aVar) {
        d iVar;
        AppMethodBeat.i(181618);
        if (aVar == null) {
            AppMethodBeat.o(181618);
            return null;
        }
        switch (aVar.getType()) {
            case -1:
                iVar = new i();
                break;
            case 0:
            case 3:
            case 5:
            default:
                iVar = null;
                break;
            case 1:
                iVar = new j();
                ((j) iVar).content = ((j) aVar).content;
                break;
            case 2:
                iVar = new h();
                ((h) iVar).qPL = ((h) aVar).qPL;
                break;
            case 4:
                iVar = new m();
                m mVar = (m) iVar;
                m mVar2 = (m) aVar;
                mVar.qPS = mVar2.qPS;
                mVar.length = mVar2.length;
                mVar.qPR = mVar2.qPR;
                mVar.mav = mVar2.mav;
                mVar.dLu = mVar2.dLu;
                mVar.dLt = mVar2.dLt;
                mVar.qPP = mVar2.qPP;
                break;
            case 6:
                iVar = new l();
                l lVar = (l) iVar;
                l lVar2 = (l) aVar;
                lVar.thumbPath = lVar2.thumbPath;
                lVar.duration = lVar2.duration;
                lVar.qPP = lVar2.qPP;
                break;
        }
        if (iVar == null) {
            AppMethodBeat.o(181618);
            return null;
        }
        iVar.type = ((d) aVar).type;
        iVar.qPO = ((d) aVar).qPO;
        iVar.dUs = ((d) aVar).dUs;
        AppMethodBeat.o(181618);
        return iVar;
    }

    public static String b(a aVar) {
        AppMethodBeat.i(181619);
        if (aVar == null) {
            AppMethodBeat.o(181619);
            return "";
        } else if (aVar.getType() == 2) {
            String str = ((h) aVar).qPL;
            AppMethodBeat.o(181619);
            return str;
        } else {
            String str2 = ((d) aVar).dUs;
            AppMethodBeat.o(181619);
            return str2;
        }
    }

    public static String c(a aVar) {
        AppMethodBeat.i(181620);
        if (aVar == null) {
            AppMethodBeat.o(181620);
            return "";
        } else if (aVar.getType() == 2) {
            String str = ((h) aVar).dUs;
            AppMethodBeat.o(181620);
            return str;
        } else if (aVar.getType() == 6) {
            String str2 = ((l) aVar).thumbPath;
            AppMethodBeat.o(181620);
            return str2;
        } else {
            AppMethodBeat.o(181620);
            return "";
        }
    }

    public static int alJ(String str) {
        AppMethodBeat.i(181621);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(181621);
            return 0;
        }
        int alL = alL(alO(str));
        AppMethodBeat.o(181621);
        return alL;
    }

    public static int b(String str, int i2, int i3, boolean z) {
        AppMethodBeat.i(181622);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(181622);
            return 0;
        }
        Spanned alS = com.tencent.mm.plugin.editor.model.nativenote.a.a.alS(str);
        if (alS == null) {
            AppMethodBeat.o(181622);
            return 0;
        }
        if (z) {
            i3 = alS.length();
        }
        if (i2 < 0 || i2 > alS.length() || i3 < 0 || i3 > alS.length() || i2 > i3) {
            AppMethodBeat.o(181622);
            return 0;
        }
        Spanned spanned = (Spanned) alS.subSequence(i2, i3);
        if (spanned == null) {
            AppMethodBeat.o(181622);
            return 0;
        }
        int alL = alL(spanned.toString());
        AppMethodBeat.o(181622);
        return alL;
    }

    public static int alK(String str) {
        AppMethodBeat.i(181623);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(181623);
            return 0;
        } else if (qOh.check(str)) {
            int intValue = qOh.get(str).intValue();
            AppMethodBeat.o(181623);
            return intValue;
        } else {
            int alL = alL(str);
            qOh.put(str, Integer.valueOf(alL));
            AppMethodBeat.o(181623);
            return alL;
        }
    }

    private static int alL(String str) {
        int i2 = 0;
        AppMethodBeat.i(181624);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(181624);
            return 0;
        }
        for (int i3 = 0; i3 < str.length(); i3++) {
            i2 = z(str.charAt(i3)) + i2;
        }
        AppMethodBeat.o(181624);
        return i2;
    }

    private static int z(char c2) {
        if (c2 <= 127) {
            return 1;
        }
        return 2;
    }

    public static String a(Context context, a aVar) {
        AppMethodBeat.i(181625);
        if (aVar == null) {
            AppMethodBeat.o(181625);
            return "";
        }
        int type = aVar.getType();
        if (type == 1) {
            String str = ((j) aVar).content;
            AppMethodBeat.o(181625);
            return str;
        } else if (type == 3) {
            String string = context.getString(R.string.fn3);
            AppMethodBeat.o(181625);
            return string;
        } else if (type == 2) {
            String string2 = context.getString(R.string.fn2);
            AppMethodBeat.o(181625);
            return string2;
        } else if (type == 6) {
            String string3 = context.getString(R.string.fn4);
            AppMethodBeat.o(181625);
            return string3;
        } else if (type == 4) {
            String string4 = context.getString(R.string.fn5);
            AppMethodBeat.o(181625);
            return string4;
        } else if (type == 5) {
            String string5 = context.getString(R.string.fn1);
            AppMethodBeat.o(181625);
            return string5;
        } else {
            AppMethodBeat.o(181625);
            return "";
        }
    }

    public static String alM(String str) {
        AppMethodBeat.i(181626);
        String replaceAll = Pattern.compile("wa-b>", 2).matcher(Pattern.compile("<[/]?w(x|n)-[^>]*>", 2).matcher(Pattern.compile("</wn-todo>", 2).matcher(Pattern.compile("</wx-li>", 2).matcher(Pattern.compile("wx-b>", 2).matcher(str).replaceAll("wa-b>")).replaceAll("<br/>")).replaceAll("<br/>")).replaceAll("")).replaceAll("wx-b>");
        AppMethodBeat.o(181626);
        return replaceAll;
    }

    public static float AO(long j2) {
        float f2 = 1.0f;
        AppMethodBeat.i(181627);
        float f3 = ((float) j2) / 1000.0f;
        if (f3 >= 1.0f) {
            f2 = f3;
        }
        float round = (float) Math.round(f2);
        AppMethodBeat.o(181627);
        return round;
    }

    public static CharSequence J(Context context, int i2) {
        AppMethodBeat.i(181628);
        if (i2 <= 0) {
            String string = context.getString(R.string.cc3, 0, 0);
            AppMethodBeat.o(181628);
            return string;
        }
        String string2 = context.getString(R.string.cc3, Integer.valueOf(i2 / 60), Integer.valueOf(i2 % 60));
        AppMethodBeat.o(181628);
        return string2;
    }

    public static ArrayList<String> alN(String str) {
        AppMethodBeat.i(181629);
        if (Util.isNullOrNil(str) || str.length() == 0) {
            AppMethodBeat.o(181629);
            return null;
        }
        String[] split = Pattern.compile("\n", 2).matcher(Pattern.compile("<div></div>", 2).matcher(Pattern.compile("</object>", 2).matcher(Pattern.compile("<hr[^>]*>", 2).matcher(Pattern.compile("<object[^>]*>", 2).matcher(Pattern.compile("<div><object[^>]*></object></div>", 2).matcher(str).replaceAll("<object>")).replaceAll("#WNNoteNode#<ThisisNoteNodeObj>#WNNoteNode#")).replaceAll("#WNNoteNode#<ThisisNoteNodeHrObj>#WNNoteNode#")).replaceAll("")).replaceAll("")).replaceAll("").replaceAll("<br>", "<br/>").trim().split("#WNNoteNode#");
        ArrayList<String> arrayList = new ArrayList<>();
        for (String str2 : split) {
            if (str2.length() > 0) {
                String replace = str2.replace("</div>", "<div>");
                int i2 = -1;
                if (replace.endsWith("<div>")) {
                    i2 = replace.lastIndexOf("<div>");
                }
                if (i2 > 0) {
                    replace = replace.substring(0, i2);
                }
                arrayList.add(replace.replace("<div><br/>", "<div>"));
            }
        }
        AppMethodBeat.o(181629);
        return arrayList;
    }

    public static String alO(String str) {
        AppMethodBeat.i(181630);
        if (Util.isNullOrNil(str) || str.length() == 0) {
            AppMethodBeat.o(181630);
            return str;
        }
        String replaceAll = Pattern.compile("&nbsp;", 2).matcher(Pattern.compile("<[^>]*>", 2).matcher(Pattern.compile("</p>", 2).matcher(Pattern.compile("<p [^>]*>", 2).matcher(Pattern.compile("<hr[^>]*>", 2).matcher(Pattern.compile("</wx-todo>", 2).matcher(Pattern.compile("</wx-li>", 2).matcher(Pattern.compile("<div>", 2).matcher(Pattern.compile("<br[^>]*>", 2).matcher(str).replaceAll("\n")).replaceAll("")).replaceAll("\n")).replaceAll("\n")).replaceAll("\n")).replaceAll("")).replaceAll("")).replaceAll("")).replaceAll(" ");
        AppMethodBeat.o(181630);
        return replaceAll;
    }

    public static boolean alP(String str) {
        AppMethodBeat.i(181631);
        int length = "<br/>".length();
        if (Util.isNullOrNil(str) || str.length() < length) {
            AppMethodBeat.o(181631);
            return false;
        }
        int i2 = 0;
        while (i2 < str.length()) {
            int i3 = i2 + length;
            if (i3 > str.length()) {
                AppMethodBeat.o(181631);
                return false;
            } else if (!"<br/>".equalsIgnoreCase(str.substring(i2, i3))) {
                AppMethodBeat.o(181631);
                return false;
            } else {
                i2 = i3;
            }
        }
        AppMethodBeat.o(181631);
        return true;
    }

    public static String alQ(String str) {
        AppMethodBeat.i(181632);
        String alO = alO(Pattern.compile("<object[^>]*>", 2).matcher(str).replaceAll("#WNNoteNode#<ThisisNoteNodeObj>#WNNoteNode#"));
        if (Util.isNullOrNil(alO) || alO.length() == 0) {
            AppMethodBeat.o(181632);
            return alO;
        }
        String replaceAll = Pattern.compile("\\s*|\t|\r|\n").matcher(alO).replaceAll("");
        AppMethodBeat.o(181632);
        return replaceAll;
    }
}
