package com.tencent.mm.plugin.choosemsgfile.b.d;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ab.f;
import com.tencent.mm.ab.g;
import com.tencent.mm.ag.k;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.choosemsgfile.compat.MsgFile;
import com.tencent.mm.choosemsgfile.compat.a;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.choosemsgfile.b.b.a;
import com.tencent.mm.plugin.choosemsgfile.b.b.b;
import com.tencent.mm.plugin.choosemsgfile.b.b.h;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.LruCache;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.a.f;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class c {
    private static LruCache<Integer, com.tencent.mm.av.a.a.c> qoO = new LruCache<>(3);

    public static a a(com.tencent.mm.plugin.choosemsgfile.b.c.c cVar, ca caVar, String str, String str2, String str3) {
        AppMethodBeat.i(123363);
        if (Util.isNullOrNil(str2)) {
            str2 = "all";
        }
        List<String> akz = akz(str3);
        String lowerCase = str2.toLowerCase();
        char c2 = 65535;
        switch (lowerCase.hashCode()) {
            case 96673:
                if (lowerCase.equals("all")) {
                    c2 = 0;
                    break;
                }
                break;
            case 3143036:
                if (lowerCase.equals("file")) {
                    c2 = 3;
                    break;
                }
                break;
            case 100313435:
                if (lowerCase.equals("image")) {
                    c2 = 1;
                    break;
                }
                break;
            case 112202875:
                if (lowerCase.equals("video")) {
                    c2 = 2;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                a a2 = a(cVar, caVar, str, akz);
                if (a2 == null && (a2 = b(cVar, caVar)) == null) {
                    a2 = a(cVar, caVar);
                }
                AppMethodBeat.o(123363);
                return a2;
            case 1:
                a a3 = a(cVar, caVar);
                AppMethodBeat.o(123363);
                return a3;
            case 2:
                a b2 = b(cVar, caVar);
                AppMethodBeat.o(123363);
                return b2;
            case 3:
                a a4 = a(cVar, caVar, str, akz);
                AppMethodBeat.o(123363);
                return a4;
            default:
                AppMethodBeat.o(123363);
                return null;
        }
    }

    public static List<String> akz(String str) {
        AppMethodBeat.i(123364);
        ArrayList arrayList = new ArrayList();
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(123364);
        } else {
            try {
                f fVar = new f(str);
                for (int i2 = 0; i2 < fVar.length(); i2++) {
                    String optString = fVar.optString(i2, "");
                    if (!Util.isNullOrNil(optString)) {
                        arrayList.add(optString);
                    }
                }
            } catch (g e2) {
                Log.printErrStackTrace("MicroMsg.MsgFileUtils", e2, "", new Object[0]);
            }
            AppMethodBeat.o(123364);
        }
        return arrayList;
    }

    private static a a(com.tencent.mm.plugin.choosemsgfile.b.c.c cVar, ca caVar, String str, List<String> list) {
        String str2;
        k.b HD;
        AppMethodBeat.i(123365);
        if (caVar.dOQ() && (str2 = caVar.field_content) != null && (HD = k.b.HD(str2)) != null && HD.type == 6) {
            com.tencent.mm.plugin.choosemsgfile.b.b.f fVar = new com.tencent.mm.plugin.choosemsgfile.b.b.f(cVar, caVar, str);
            if (list == null || list.size() == 0) {
                AppMethodBeat.o(123365);
                return fVar;
            }
            for (String str3 : list) {
                if (fVar.getFileName().endsWith(str3)) {
                    AppMethodBeat.o(123365);
                    return fVar;
                }
            }
        }
        AppMethodBeat.o(123365);
        return null;
    }

    private static a a(com.tencent.mm.plugin.choosemsgfile.b.c.c cVar, ca caVar) {
        AppMethodBeat.i(123366);
        if (caVar.gDr()) {
            b bVar = new b(cVar, caVar);
            AppMethodBeat.o(123366);
            return bVar;
        } else if (caVar.gAz()) {
            com.tencent.mm.plugin.choosemsgfile.b.b.g gVar = new com.tencent.mm.plugin.choosemsgfile.b.b.g(cVar, caVar);
            AppMethodBeat.o(123366);
            return gVar;
        } else {
            AppMethodBeat.o(123366);
            return null;
        }
    }

    private static a b(com.tencent.mm.plugin.choosemsgfile.b.c.c cVar, ca caVar) {
        AppMethodBeat.i(123367);
        if (caVar.cWJ() || caVar.cWL()) {
            h hVar = new h(cVar, caVar);
            AppMethodBeat.o(123367);
            return hVar;
        }
        AppMethodBeat.o(123367);
        return null;
    }

    public static String b(ca caVar, boolean z) {
        String str = null;
        AppMethodBeat.i(123368);
        if (caVar == null) {
            AppMethodBeat.o(123368);
            return null;
        } else if (caVar.field_isSend == 1) {
            String aTY = z.aTY();
            AppMethodBeat.o(123368);
            return aTY;
        } else {
            if (z) {
                str = bp.Ks(caVar.field_content);
            }
            if (Util.isNullOrNil(str)) {
                str = caVar.field_talker;
            }
            AppMethodBeat.o(123368);
            return str;
        }
    }

    public static String Cc(long j2) {
        AppMethodBeat.i(123369);
        String a2 = com.tencent.mm.ui.gridviewheaders.a.gWr().a(new Date(j2), MMApplicationContext.getContext());
        AppMethodBeat.o(123369);
        return a2;
    }

    public static long Cd(long j2) {
        AppMethodBeat.i(123370);
        long b2 = com.tencent.mm.ui.gridviewheaders.a.gWr().b(new Date(j2));
        AppMethodBeat.o(123370);
        return b2;
    }

    static {
        AppMethodBeat.i(123381);
        AppMethodBeat.o(123381);
    }

    public static final com.tencent.mm.av.a.a.c eT(Context context) {
        AppMethodBeat.i(123371);
        com.tencent.mm.av.a.a.c cVar = qoO.get(4);
        if (cVar == null) {
            c.a aVar = new c.a();
            aVar.jbi = 1;
            aVar.jby = true;
            aVar.hZA = com.tencent.mm.cb.a.jn(context) / 4;
            aVar.hZz = com.tencent.mm.cb.a.jn(context) / 4;
            aVar.jbt = R.color.a3k;
            cVar = aVar.bdv();
            qoO.put(4, cVar);
        }
        AppMethodBeat.o(123371);
        return cVar;
    }

    public static void a(Context context, View view, a aVar) {
        AppMethodBeat.i(123372);
        Intent intent = new Intent();
        if (aVar == null) {
            Log.e("MicroMsg.MsgFileUtils", "[enterGallery] item == null");
            AppMethodBeat.o(123372);
            return;
        }
        ca caVar = aVar.qnv;
        if (caVar == null) {
            Log.e("MicroMsg.MsgFileUtils", "[enterGallery] msg == null");
            AppMethodBeat.o(123372);
            return;
        }
        int i2 = context.getResources().getConfiguration().orientation;
        int i3 = 0;
        int i4 = 0;
        int[] iArr = new int[2];
        if (view != null) {
            i3 = view.getWidth();
            i4 = view.getHeight();
            view.getLocationInWindow(iArr);
        }
        intent.addFlags(536870912);
        intent.putExtra("img_gallery_msg_id", caVar.field_msgId).putExtra("img_gallery_msg_svr_id", caVar.field_msgSvrId).putExtra("img_gallery_talker", caVar.field_talker).putExtra("img_gallery_chatroom_name", caVar.field_talker).putExtra("img_gallery_orientation", i2).putExtra("show_enter_grid", false).putExtra("img_gallery_enter_from_scene", 1);
        if (view != null) {
            intent.putExtra("img_gallery_width", i3).putExtra("img_gallery_height", i4).putExtra("img_gallery_left", iArr[0]).putExtra("img_gallery_top", iArr[1]).putExtra("img_gallery_enter_from_grid", true);
        } else {
            intent.putExtra("img_gallery_back_from_grid", true);
        }
        com.tencent.mm.br.c.f(context, "com.tencent.mm.ui.chatting.gallery.ImageGalleryUI", intent);
        ((Activity) context).overridePendingTransition(0, 0);
        AppMethodBeat.o(123372);
    }

    public static String akA(String str) {
        AppMethodBeat.i(123373);
        if (Util.isNullOrNil(str)) {
            Log.i("MicroMsg.MsgFileUtils", "type is null, use default type");
            AppMethodBeat.o(123373);
            return "all";
        } else if ("all".equals(str) || "image".equals(str) || "video".equals(str) || "file".equals(str)) {
            Log.i("MicroMsg.MsgFileUtils", "type is invalid, use default type");
            AppMethodBeat.o(123373);
            return str;
        } else {
            AppMethodBeat.o(123373);
            return "all";
        }
    }

    public static String Ir(String str) {
        AppMethodBeat.i(123374);
        if (ab.Eq(str)) {
            as Kn = ((l) com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(str);
            if (Kn == null || Util.isNullOrNil(Kn.field_nickname)) {
                ah Kd = ((com.tencent.mm.plugin.chatroom.a.c) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kd(str);
                if (Kd == null) {
                    Log.e("MicroMsg.MsgFileUtils", "%s chatRoomMember is null", str);
                    AppMethodBeat.o(123374);
                    return "";
                }
                String str2 = Kd.field_displayname;
                AppMethodBeat.o(123374);
                return str2;
            }
            String str3 = Kn.field_nickname;
            AppMethodBeat.o(123374);
            return str3;
        }
        as Kn2 = ((l) com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(str);
        if (Kn2 == null) {
            Log.e("MicroMsg.MsgFileUtils", "%s, contact is null", str);
            AppMethodBeat.o(123374);
            return "";
        }
        String str4 = Kn2.field_nickname;
        AppMethodBeat.o(123374);
        return str4;
    }

    public static void g(Context context, long j2) {
        AppMethodBeat.i(123375);
        if (!com.tencent.mm.kernel.g.aAh().isSDCardAvailable()) {
            u.g(context, null);
            AppMethodBeat.o(123375);
            return;
        }
        Intent intent = new Intent();
        intent.setClassName(context, "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
        intent.putExtra("app_msg_id", j2);
        intent.putExtra("scene", 1);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/choosemsgfile/logic/util/MsgFileUtils", "enterFileProfile", "(Landroid/content/Context;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/choosemsgfile/logic/util/MsgFileUtils", "enterFileProfile", "(Landroid/content/Context;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(123375);
    }

    public static String akB(String str) {
        AppMethodBeat.i(123376);
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1069324867:
                if (str.equals("mp3pro")) {
                    c2 = '\n';
                    break;
                }
                break;
            case -810722925:
                if (str.equals("vorbis")) {
                    c2 = 15;
                    break;
                }
                break;
            case -284840886:
                if (str.equals("unknown")) {
                    c2 = '=';
                    break;
                }
                break;
            case 1827:
                if (str.equals("7z")) {
                    c2 = ':';
                    break;
                }
                break;
            case 3124:
                if (str.equals("au")) {
                    c2 = 16;
                    break;
                }
                break;
            case 3169:
                if (str.equals("cd")) {
                    c2 = '\f';
                    break;
                }
                break;
            case 3479:
                if (str.equals("md")) {
                    c2 = '\r';
                    break;
                }
                break;
            case 3631:
                if (str.equals("ra")) {
                    c2 = ',';
                    break;
                }
                break;
            case 3643:
                if (str.equals("rm")) {
                    c2 = '+';
                    break;
                }
                break;
            case 3798:
                if (str.equals("wm")) {
                    c2 = '\'';
                    break;
                }
                break;
            case 52316:
                if (str.equals("3gp")) {
                    c2 = '(';
                    break;
                }
                break;
            case 96323:
                if (str.equals("aac")) {
                    c2 = 24;
                    break;
                }
                break;
            case 96574:
                if (str.equals("aif")) {
                    c2 = 27;
                    break;
                }
                break;
            case 96710:
                if (str.equals("amr")) {
                    c2 = 17;
                    break;
                }
                break;
            case 96790:
                if (str.equals("ape")) {
                    c2 = 25;
                    break;
                }
                break;
            case 96884:
                if (str.equals("asf")) {
                    c2 = '\"';
                    break;
                }
                break;
            case 96902:
                if (str.equals("asx")) {
                    c2 = '!';
                    break;
                }
                break;
            case 96980:
                if (str.equals("avi")) {
                    c2 = 28;
                    break;
                }
                break;
            case 97669:
                if (str.equals("bmp")) {
                    c2 = '6';
                    break;
                }
                break;
            case 98244:
                if (str.equals("cab")) {
                    c2 = '<';
                    break;
                }
                break;
            case 99453:
                if (str.equals("dib")) {
                    c2 = '2';
                    break;
                }
                break;
            case 99640:
                if (str.equals("doc")) {
                    c2 = 2;
                    break;
                }
                break;
            case 99752:
                if (str.equals("f4v")) {
                    c2 = '#';
                    break;
                }
                break;
            case 101488:
                if (str.equals("flv")) {
                    c2 = '$';
                    break;
                }
                break;
            case 102340:
                if (str.equals("gif")) {
                    c2 = '7';
                    break;
                }
                break;
            case 104581:
                if (str.equals("iso")) {
                    c2 = ';';
                    break;
                }
                break;
            case 105439:
                if (str.equals("jpe")) {
                    c2 = '1';
                    break;
                }
                break;
            case 105441:
                if (str.equals("jpg")) {
                    c2 = '4';
                    break;
                }
                break;
            case 106479:
                if (str.equals("m4v")) {
                    c2 = 29;
                    break;
                }
                break;
            case 108104:
                if (str.equals("mid")) {
                    c2 = 21;
                    break;
                }
                break;
            case 108184:
                if (str.equals("mkv")) {
                    c2 = '%';
                    break;
                }
                break;
            case 108230:
                if (str.equals("mmf")) {
                    c2 = 20;
                    break;
                }
                break;
            case 108272:
                if (str.equals("mp3")) {
                    c2 = 23;
                    break;
                }
                break;
            case 108273:
                if (str.equals("mp4")) {
                    c2 = ')';
                    break;
                }
                break;
            case 108290:
                if (str.equals("mod")) {
                    c2 = 14;
                    break;
                }
                break;
            case 108322:
                if (str.equals("mpe")) {
                    c2 = ' ';
                    break;
                }
                break;
            case 110834:
                if (str.equals("pdf")) {
                    c2 = 4;
                    break;
                }
                break;
            case 111145:
                if (str.equals("png")) {
                    c2 = '5';
                    break;
                }
                break;
            case 111220:
                if (str.equals("ppt")) {
                    c2 = 7;
                    break;
                }
                break;
            case 112670:
                if (str.equals("ram")) {
                    c2 = '-';
                    break;
                }
                break;
            case 112675:
                if (str.equals("rar")) {
                    c2 = '8';
                    break;
                }
                break;
            case 113252:
                if (str.equals("rtf")) {
                    c2 = 1;
                    break;
                }
                break;
            case 114833:
                if (str.equals("tif")) {
                    c2 = '0';
                    break;
                }
                break;
            case 115312:
                if (str.equals("txt")) {
                    c2 = 0;
                    break;
                }
                break;
            case 116079:
                if (str.equals("url")) {
                    c2 = '\t';
                    break;
                }
                break;
            case 116937:
                if (str.equals("vob")) {
                    c2 = 30;
                    break;
                }
                break;
            case 117003:
                if (str.equals("vqf")) {
                    c2 = 11;
                    break;
                }
                break;
            case 117835:
                if (str.equals("wma")) {
                    c2 = 19;
                    break;
                }
                break;
            case 117856:
                if (str.equals("wmv")) {
                    c2 = '&';
                    break;
                }
                break;
            case 118783:
                if (str.equals("xls")) {
                    c2 = 5;
                    break;
                }
                break;
            case 120609:
                if (str.equals("zip")) {
                    c2 = '9';
                    break;
                }
                break;
            case 2993896:
                if (str.equals("aiff")) {
                    c2 = 26;
                    break;
                }
                break;
            case 3088960:
                if (str.equals("docx")) {
                    c2 = 3;
                    break;
                }
                break;
            case 3259225:
                if (str.equals("jfif")) {
                    c2 = '.';
                    break;
                }
                break;
            case 3268712:
                if (str.equals("jpeg")) {
                    c2 = '3';
                    break;
                }
                break;
            case 3351329:
                if (str.equals("midi")) {
                    c2 = 22;
                    break;
                }
                break;
            case 3358085:
                if (str.equals("mpeg")) {
                    c2 = 31;
                    break;
                }
                break;
            case 3447940:
                if (str.equals("pptx")) {
                    c2 = '\b';
                    break;
                }
                break;
            case 3504679:
                if (str.equals("rmvb")) {
                    c2 = '*';
                    break;
                }
                break;
            case 3530325:
                if (str.equals("silk")) {
                    c2 = 18;
                    break;
                }
                break;
            case 3559925:
                if (str.equals("tiff")) {
                    c2 = '/';
                    break;
                }
                break;
            case 3682393:
                if (str.equals("xlsx")) {
                    c2 = 6;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case 1:
            case 2:
            case 3:
                AppMethodBeat.o(123376);
                return "#3980c1";
            case 4:
                AppMethodBeat.o(123376);
                return "#c84e3a";
            case 5:
            case 6:
                AppMethodBeat.o(123376);
                return "#278453";
            case 7:
            case '\b':
                AppMethodBeat.o(123376);
                return "#ff7a42";
            case '\t':
                AppMethodBeat.o(123376);
                return "#33B0D6";
            case '\n':
            case 11:
            case '\f':
            case '\r':
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
                AppMethodBeat.o(123376);
                return "#42AA73";
            case 28:
            case 29:
            case 30:
            case 31:
            case ' ':
            case '!':
            case '\"':
            case '#':
            case '$':
            case '%':
            case '&':
            case '\'':
            case '(':
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_CREATOR:
            case '*':
            case '+':
            case ',':
            case '-':
                AppMethodBeat.o(123376);
                return "#6781F0";
            default:
                AppMethodBeat.o(123376);
                return "#888888";
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static void a(int i2, int i3, Intent intent, a.AbstractC0293a aVar) {
        AppMethodBeat.i(123377);
        if (i2 == b.qoN) {
            switch (i3) {
                case -1:
                    if (intent == null) {
                        Log.e("MicroMsg.MsgFileUtils", "data is null");
                        a(aVar, "data is null");
                        AppMethodBeat.o(123377);
                        return;
                    }
                    ArrayList<MsgFile> parcelableArrayListExtra = intent.getParcelableArrayListExtra("FILEPATHS");
                    if (parcelableArrayListExtra == null) {
                        Log.e("MicroMsg.MsgFileUtils", "msgFiles is null");
                        a(aVar, "msgFiles is null");
                        AppMethodBeat.o(123377);
                        return;
                    }
                    if (aVar != null) {
                        aVar.a(-1, "", parcelableArrayListExtra);
                    }
                    AppMethodBeat.o(123377);
                    return;
                case 0:
                    if (aVar != null) {
                        aVar.a(0, "", null);
                        break;
                    }
                    break;
                case 1:
                    if (intent == null) {
                        Log.e("MicroMsg.MsgFileUtils", "data is null");
                        a(aVar, "data is null");
                        AppMethodBeat.o(123377);
                        return;
                    }
                    a(aVar, intent.getStringExtra("ERRMSG"));
                    AppMethodBeat.o(123377);
                    return;
            }
        }
        AppMethodBeat.o(123377);
    }

    private static void a(a.AbstractC0293a aVar, String str) {
        AppMethodBeat.i(123378);
        if (aVar != null) {
            aVar.a(1, str, null);
        }
        AppMethodBeat.o(123378);
    }

    public static String akC(String str) {
        AppMethodBeat.i(123379);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(123379);
            return "";
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf < 0) {
            AppMethodBeat.o(123379);
            return "";
        }
        String substring = str.substring(lastIndexOf + 1);
        AppMethodBeat.o(123379);
        return substring;
    }

    public static void V(Context context, int i2) {
        AppMethodBeat.i(123380);
        String format = String.format(context.getString(R.string.b3q), Integer.valueOf(i2));
        f.a aVar = new f.a(context);
        aVar.bow(format).Dq(false);
        aVar.b(new f.c() {
            /* class com.tencent.mm.plugin.choosemsgfile.b.d.c.AnonymousClass1 */

            @Override // com.tencent.mm.ui.widget.a.f.c
            public final void e(boolean z, String str) {
            }
        }).show();
        AppMethodBeat.o(123380);
    }
}
