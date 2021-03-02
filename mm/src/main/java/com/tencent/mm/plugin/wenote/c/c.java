package com.tencent.mm.plugin.wenote.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.Spanned;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.b.f;
import com.tencent.mm.b.g;
import com.tencent.mm.plugin.fav.a.ao;
import com.tencent.mm.plugin.fav.ui.e;
import com.tencent.mm.plugin.wenote.model.a.d;
import com.tencent.mm.plugin.wenote.model.a.h;
import com.tencent.mm.plugin.wenote.model.a.i;
import com.tencent.mm.plugin.wenote.model.a.k;
import com.tencent.mm.plugin.wenote.model.a.l;
import com.tencent.mm.plugin.wenote.model.a.o;
import com.tencent.mm.plugin.wenote.model.a.r;
import com.tencent.mm.plugin.wenote.model.nativenote.a.a;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.LongBitmapHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import com.tencent.tavkit.component.TAVExporter;
import java.util.HashMap;
import java.util.regex.Pattern;

public final class c {
    public static HashMap<String, String> JJr = new HashMap<>();
    public static HashMap<String, r> JJs = new HashMap<>();
    public static c JJt = null;
    private static f<String, Integer> qOh = new com.tencent.mm.memory.a.c(30);

    static {
        AppMethodBeat.i(30687);
        AppMethodBeat.o(30687);
    }

    public static String fJ(String str, String str2) {
        String str3;
        int i2;
        int i3;
        int i4 = TAVExporter.VIDEO_EXPORT_HEIGHT;
        AppMethodBeat.i(30675);
        if (Util.isNullOrNil(str2)) {
            str3 = ao.cVk() + FilePathGenerator.ANDROID_DIR_SEP + (g.getMessageDigest((str + System.currentTimeMillis()).getBytes()) + "_HD");
        } else {
            str3 = str2;
        }
        if (!s.YS(str3)) {
            BitmapFactory.Options imageOptions = BitmapUtil.getImageOptions(str);
            if (imageOptions == null || imageOptions.outWidth <= 0 || imageOptions.outHeight <= 0) {
                Log.e("MicroMsg.WNNoteUtil", "GetImageOptions Error");
                AppMethodBeat.o(30675);
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
        AppMethodBeat.o(30675);
        return str3;
    }

    public static String fK(String str, String str2) {
        String str3;
        int i2;
        int i3;
        int i4 = 800;
        AppMethodBeat.i(30676);
        if (Util.isNullOrNil(str2)) {
            str3 = ao.cVk() + FilePathGenerator.ANDROID_DIR_SEP + (g.getMessageDigest((str + System.currentTimeMillis()).getBytes()) + "_TH");
        } else {
            str3 = str2;
        }
        if (!s.YS(str3)) {
            BitmapFactory.Options imageOptions = BitmapUtil.getImageOptions(str);
            if (imageOptions == null || imageOptions.outWidth <= 0 || imageOptions.outHeight <= 0) {
                Log.e("MicroMsg.WNNoteUtil", "GetImageOptions Error,use orignal file");
                AppMethodBeat.o(30676);
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
        AppMethodBeat.o(30676);
        return str3;
    }

    public static Bitmap alI(String str) {
        AppMethodBeat.i(30677);
        Bitmap bd = e.bd(str, false);
        if (bd != null) {
            AppMethodBeat.o(30677);
            return bd;
        } else if (Util.isNullOrNil((String) null)) {
            AppMethodBeat.o(30677);
            return null;
        } else {
            Bitmap bd2 = e.bd(null, false);
            AppMethodBeat.o(30677);
            return bd2;
        }
    }

    public static com.tencent.mm.plugin.wenote.model.a.c c(com.tencent.mm.plugin.wenote.model.a.c cVar) {
        o hVar;
        AppMethodBeat.i(30678);
        if (cVar == null) {
            AppMethodBeat.o(30678);
            return null;
        }
        switch (cVar.getType()) {
            case -1:
                hVar = new h();
                break;
            case 0:
            default:
                hVar = null;
                break;
            case 1:
                hVar = new i();
                ((i) hVar).content = ((i) cVar).content;
                break;
            case 2:
                hVar = new com.tencent.mm.plugin.wenote.model.a.f();
                ((com.tencent.mm.plugin.wenote.model.a.f) hVar).qPL = ((com.tencent.mm.plugin.wenote.model.a.f) cVar).qPL;
                break;
            case 3:
                hVar = new com.tencent.mm.plugin.wenote.model.a.g();
                com.tencent.mm.plugin.wenote.model.a.g gVar = (com.tencent.mm.plugin.wenote.model.a.g) hVar;
                com.tencent.mm.plugin.wenote.model.a.g gVar2 = (com.tencent.mm.plugin.wenote.model.a.g) cVar;
                gVar.lat = gVar2.lat;
                gVar.lng = gVar2.lng;
                gVar.JIb = gVar2.JIb;
                gVar.iUO = gVar2.iUO;
                gVar.kHV = gVar2.kHV;
                break;
            case 4:
                hVar = new l();
                l lVar = (l) hVar;
                l lVar2 = (l) cVar;
                lVar.qPS = lVar2.qPS;
                lVar.length = lVar2.length;
                lVar.qPR = lVar2.qPR;
                lVar.mav = lVar2.mav;
                lVar.dLu = lVar2.dLu;
                lVar.dLt = lVar2.dLt;
                lVar.qPP = lVar2.qPP;
                break;
            case 5:
                hVar = new d();
                d dVar = (d) hVar;
                d dVar2 = (d) cVar;
                dVar.title = dVar2.title;
                dVar.content = dVar2.content;
                dVar.mav = dVar2.mav;
                dVar.qPP = dVar2.qPP;
                break;
            case 6:
                hVar = new k();
                k kVar = (k) hVar;
                k kVar2 = (k) cVar;
                kVar.thumbPath = kVar2.thumbPath;
                kVar.duration = kVar2.duration;
                kVar.qPP = kVar2.qPP;
                break;
        }
        if (hVar == null) {
            AppMethodBeat.o(30678);
            return null;
        }
        hVar.type = ((o) cVar).type;
        hVar.qPO = ((o) cVar).qPO;
        hVar.dUs = ((o) cVar).dUs;
        AppMethodBeat.o(30678);
        return hVar;
    }

    public static String d(com.tencent.mm.plugin.wenote.model.a.c cVar) {
        AppMethodBeat.i(30679);
        if (cVar == null) {
            AppMethodBeat.o(30679);
            return "";
        } else if (cVar.getType() == 2) {
            String str = ((com.tencent.mm.plugin.wenote.model.a.f) cVar).qPL;
            AppMethodBeat.o(30679);
            return str;
        } else {
            String str2 = ((o) cVar).dUs;
            AppMethodBeat.o(30679);
            return str2;
        }
    }

    public static String e(com.tencent.mm.plugin.wenote.model.a.c cVar) {
        AppMethodBeat.i(30680);
        if (cVar == null) {
            AppMethodBeat.o(30680);
            return "";
        } else if (cVar.getType() == 2) {
            String str = ((com.tencent.mm.plugin.wenote.model.a.f) cVar).dUs;
            AppMethodBeat.o(30680);
            return str;
        } else if (cVar.getType() == 6) {
            String str2 = ((k) cVar).thumbPath;
            AppMethodBeat.o(30680);
            return str2;
        } else {
            AppMethodBeat.o(30680);
            return "";
        }
    }

    public static int alJ(String str) {
        AppMethodBeat.i(30681);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(30681);
            return 0;
        }
        int alL = alL(b.alO(str));
        AppMethodBeat.o(30681);
        return alL;
    }

    public static int b(String str, int i2, int i3, boolean z) {
        AppMethodBeat.i(30682);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(30682);
            return 0;
        }
        Spanned alS = a.alS(str);
        if (alS == null) {
            AppMethodBeat.o(30682);
            return 0;
        }
        if (z) {
            i3 = alS.length();
        }
        if (i2 < 0 || i2 > alS.length() || i3 < 0 || i3 > alS.length() || i2 > i3) {
            AppMethodBeat.o(30682);
            return 0;
        }
        Spanned spanned = (Spanned) alS.subSequence(i2, i3);
        if (spanned == null) {
            AppMethodBeat.o(30682);
            return 0;
        }
        int alL = alL(spanned.toString());
        AppMethodBeat.o(30682);
        return alL;
    }

    public static int alK(String str) {
        AppMethodBeat.i(30683);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(30683);
            return 0;
        } else if (qOh.check(str)) {
            int intValue = qOh.get(str).intValue();
            AppMethodBeat.o(30683);
            return intValue;
        } else {
            int alL = alL(str);
            qOh.put(str, Integer.valueOf(alL));
            AppMethodBeat.o(30683);
            return alL;
        }
    }

    private static int alL(String str) {
        int i2 = 0;
        AppMethodBeat.i(30684);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(30684);
            return 0;
        }
        for (int i3 = 0; i3 < str.length(); i3++) {
            i2 = z(str.charAt(i3)) + i2;
        }
        AppMethodBeat.o(30684);
        return i2;
    }

    private static int z(char c2) {
        if (c2 <= 127) {
            return 1;
        }
        return 2;
    }

    public static String a(Context context, com.tencent.mm.plugin.wenote.model.a.c cVar) {
        AppMethodBeat.i(30685);
        if (cVar == null) {
            AppMethodBeat.o(30685);
            return "";
        }
        int type = cVar.getType();
        if (type == 1) {
            String str = ((i) cVar).content;
            AppMethodBeat.o(30685);
            return str;
        } else if (type == 3) {
            String string = context.getString(R.string.j3f);
            AppMethodBeat.o(30685);
            return string;
        } else if (type == 2) {
            String string2 = context.getString(R.string.j3e);
            AppMethodBeat.o(30685);
            return string2;
        } else if (type == 6) {
            String string3 = context.getString(R.string.j3g);
            AppMethodBeat.o(30685);
            return string3;
        } else if (type == 4) {
            String string4 = context.getString(R.string.j3h);
            AppMethodBeat.o(30685);
            return string4;
        } else if (type == 5) {
            String string5 = context.getString(R.string.j3d);
            AppMethodBeat.o(30685);
            return string5;
        } else {
            AppMethodBeat.o(30685);
            return "";
        }
    }

    public static String alM(String str) {
        AppMethodBeat.i(30686);
        String replaceAll = Pattern.compile("wa-b>", 2).matcher(Pattern.compile("<[/]?w(x|n)-[^>]*>", 2).matcher(Pattern.compile("</wn-todo>", 2).matcher(Pattern.compile("</wx-li>", 2).matcher(Pattern.compile("wx-b>", 2).matcher(str).replaceAll("wa-b>")).replaceAll("<br/>")).replaceAll("<br/>")).replaceAll("")).replaceAll("wx-b>");
        AppMethodBeat.o(30686);
        return replaceAll;
    }
}
