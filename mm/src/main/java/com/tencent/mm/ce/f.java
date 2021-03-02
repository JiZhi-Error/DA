package com.tencent.mm.ce;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.memory.a.b;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.SmileyInfo;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;

public final class f {
    private static volatile f NKW = null;
    public static Pattern NLl;
    private static final Comparator<a> NLm = new Comparator<a>() {
        /* class com.tencent.mm.ce.f.AnonymousClass1 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public final /* synthetic */ int compare(a aVar, a aVar2) {
            AppMethodBeat.i(104930);
            a aVar3 = aVar;
            a aVar4 = aVar2;
            if (aVar3 == null && aVar4 == null) {
                AppMethodBeat.o(104930);
                return 0;
            } else if (aVar3 == null || Util.isNullOrNil(aVar3.text)) {
                AppMethodBeat.o(104930);
                return 1;
            } else if (aVar4 == null || Util.isNullOrNil(aVar4.text)) {
                AppMethodBeat.o(104930);
                return -1;
            } else {
                int compareTo = aVar3.text.compareTo(aVar4.text);
                AppMethodBeat.o(104930);
                return compareTo;
            }
        }
    };
    private static boolean NLn = false;
    private final String IFy = "assets:///newemoji/";
    public String[] NKX = null;
    public String[] NKY = null;
    public String[] NKZ = null;
    public String[] NLa = null;
    public String[] NLb = null;
    public String[] NLc = null;
    public ArrayList<SmileyInfo> NLd;
    private final Map<String, a> NLe = Collections.synchronizedMap(new HashMap());
    private int NLf = 100;
    private int NLg = 0;
    private HashMap<String, SmileyInfo> NLh = new HashMap<>();
    private SparseArray<String> NLi = new SparseArray<>();
    private com.tencent.mm.b.f<String, Bitmap> NLj = new b(100, getClass());
    private boolean NLk = true;
    private final String dFG = "newemoji-config.xml";
    private final String gVw = (com.tencent.mm.loader.j.b.aKC() + "emoji/newemoji/");
    private final String versionName = "config.conf";

    static {
        AppMethodBeat.i(104945);
        AppMethodBeat.o(104945);
    }

    private f(Context context) {
        AppMethodBeat.i(104931);
        long currentTimeMillis = System.currentTimeMillis();
        this.NKX = context.getResources().getStringArray(R.array.ak);
        this.NKY = context.getResources().getStringArray(R.array.an);
        this.NKZ = context.getResources().getStringArray(R.array.al);
        this.NLa = context.getResources().getStringArray(R.array.ap);
        this.NLb = context.getResources().getStringArray(R.array.am);
        this.NLc = context.getResources().getStringArray(R.array.ao);
        gxV();
        Log.d("MicroMsg.QQSmileyManager", "QQSmileyManager use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(104931);
    }

    public static f gxT() {
        AppMethodBeat.i(104932);
        if (NKW == null) {
            synchronized (f.class) {
                try {
                    if (NKW == null) {
                        NKW = new f(MMApplicationContext.getContext());
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(104932);
                    throw th;
                }
            }
        }
        f fVar = NKW;
        AppMethodBeat.o(104932);
        return fVar;
    }

    private synchronized int gxU() {
        int i2 = 0;
        synchronized (this) {
            AppMethodBeat.i(104933);
            this.NLe.clear();
            if (this.NKX == null || this.NKZ == null || this.NKX.length != this.NKZ.length) {
                Log.i("MicroMsg.QQSmileyManager", "read smiley array failed.");
            } else {
                int length = this.NKX.length;
                int i3 = 0;
                while (i3 < length) {
                    String str = this.NKX[i3];
                    String str2 = this.NKZ[i3];
                    String str3 = (this.NKY == null || this.NKY.length <= i3) ? "" : this.NKY[i3];
                    String str4 = (this.NLa == null || this.NLa.length <= i3) ? "" : this.NLa[i3];
                    String str5 = (this.NLb == null || this.NLb.length <= i3) ? "" : this.NLb[i3];
                    String str6 = (this.NLc == null || this.NLc.length <= i3) ? "" : this.NLc[i3];
                    SmileyInfo smileyInfo = new SmileyInfo(str, str3, str2, str4, str5, str6, i3);
                    this.NLe.put(str, new a(i3, str, str, ""));
                    this.NLe.put(str2, new a(i3, str, str2, ""));
                    this.NLe.put(str3, new a(i3, str, str3, ""));
                    this.NLe.put(str4, new a(i3, str, str4, ""));
                    this.NLe.put(str5, new a(i3, str, str5, ""));
                    this.NLe.put(str6, new a(i3, str, str6, ""));
                    this.NLh.put(str, smileyInfo);
                    this.NLi.put(smileyInfo.field_eggIndex, smileyInfo.field_key);
                    i3++;
                }
                i2 = length;
            }
            gxX();
            AppMethodBeat.o(104933);
        }
        return i2;
    }

    public final boolean gxV() {
        AppMethodBeat.i(104934);
        Log.i("MicroMsg.QQSmileyManager", "checkNewEmoji");
        ArrayList<SmileyInfo> cFJ = ((d) g.ah(d.class)).getProvider().cFJ();
        if (cFJ == null || cFJ.isEmpty()) {
            gxW();
            AppMethodBeat.o(104934);
            return true;
        }
        gxW();
        AppMethodBeat.o(104934);
        return false;
    }

    public final synchronized void gxW() {
        AppMethodBeat.i(104936);
        long currentTimeMillis = System.currentTimeMillis();
        this.NLh.clear();
        this.NLi.clear();
        this.NLj.clear();
        gxU();
        int EY = com.tencent.mm.emoji.e.b.EY(this.gVw + "config.conf");
        int EY2 = com.tencent.mm.emoji.e.b.EY("assets:///newemoji/config.conf");
        String str = this.gVw + "newemoji-config.xml";
        Log.i("MicroMsg.QQSmileyManager", "updateSmiley: local:%s, asset:%s", Integer.valueOf(EY), Integer.valueOf(EY2));
        if (EY <= 0 || EY < EY2 || !s.YS(str)) {
            this.NLd = null;
        } else {
            this.NLk = false;
            this.NLd = com.tencent.mm.emoji.e.b.d(new o(str));
            Log.i("MicroMsg.QQSmileyManager", "updateSmiley: local size: %s", Integer.valueOf(this.NLd.size()));
        }
        if (this.NLd == null || this.NLd.size() <= 0) {
            this.NLk = true;
            this.NLd = com.tencent.mm.emoji.e.b.d(new o("assets:///newemoji/newemoji-config.xml"));
            Log.i("MicroMsg.QQSmileyManager", "updateSmiley: asset size: %s", Integer.valueOf(this.NLd.size()));
        }
        if (this.NLd == null || this.NLd.isEmpty()) {
            Log.i("MicroMsg.QQSmileyManager", "newSmileys list is null.");
        } else {
            Iterator<SmileyInfo> it = this.NLd.iterator();
            while (it.hasNext()) {
                SmileyInfo next = it.next();
                this.NLh.put(next.field_key, next);
                this.NLi.put(next.field_eggIndex, next.field_key);
                this.NLe.put(next.field_key, new a(-1, next.field_key, next.field_key, next.field_fileName));
                if (!Util.isNullOrNil(next.field_cnValue) && !BuildConfig.COMMAND.equalsIgnoreCase(next.field_cnValue)) {
                    this.NLe.put(next.field_cnValue, new a(-1, next.field_key, next.field_cnValue, next.field_fileName));
                }
                if (!Util.isNullOrNil(next.field_qqValue) && !BuildConfig.COMMAND.equalsIgnoreCase(next.field_qqValue)) {
                    this.NLe.put(next.field_qqValue, new a(-1, next.field_key, next.field_qqValue, next.field_fileName));
                }
                if (!Util.isNullOrNil(next.field_twValue) && !BuildConfig.COMMAND.equalsIgnoreCase(next.field_twValue)) {
                    this.NLe.put(next.field_twValue, new a(-1, next.field_key, next.field_twValue, next.field_fileName));
                }
                if (!Util.isNullOrNil(next.field_enValue) && !BuildConfig.COMMAND.equalsIgnoreCase(next.field_enValue)) {
                    this.NLe.put(next.field_enValue, new a(-1, next.field_key, next.field_enValue, next.field_fileName));
                }
                if (!Util.isNullOrNil(next.field_thValue) && !BuildConfig.COMMAND.equalsIgnoreCase(next.field_thValue)) {
                    this.NLe.put(next.field_thValue, new a(-1, next.field_key, next.field_thValue, next.field_fileName));
                }
            }
        }
        gxX();
        Log.i("MicroMsg.QQSmileyManager", "updateSmiley end use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(104936);
    }

    private void gxX() {
        AppMethodBeat.i(199815);
        synchronized (this.NLe) {
            try {
                this.NLg = 0;
                this.NLf = 100;
                for (String str : this.NLe.keySet()) {
                    if (str != null) {
                        int length = str.length();
                        if (length > this.NLg) {
                            this.NLg = length;
                        }
                        if (length < this.NLf) {
                            this.NLf = length;
                        }
                    }
                }
                Log.i("MicroMsg.QQSmileyManager", "checkMaxLength: %s, %s", Integer.valueOf(this.NLf), Integer.valueOf(this.NLg));
            } finally {
                AppMethodBeat.o(199815);
            }
        }
    }

    public final boolean bif(String str) {
        AppMethodBeat.i(104937);
        if (big(str) != null) {
            AppMethodBeat.o(104937);
            return true;
        }
        AppMethodBeat.o(104937);
        return false;
    }

    public final a big(String str) {
        a aVar;
        AppMethodBeat.i(104938);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(104938);
            return null;
        }
        synchronized (this.NLe) {
            try {
                int min = Math.min(this.NLg, str.length());
                int i2 = this.NLf;
                while (true) {
                    if (i2 > min) {
                        aVar = null;
                        break;
                    }
                    aVar = this.NLe.get(str.substring(0, i2));
                    if (aVar != null) {
                        break;
                    }
                    i2++;
                }
            } finally {
                AppMethodBeat.o(104938);
            }
        }
        return aVar;
    }

    public final SpannableString b(SpannableString spannableString, int i2, int i3) {
        AppMethodBeat.i(104939);
        if (spannableString == null || spannableString.length() == 0) {
            AppMethodBeat.o(104939);
        } else {
            String spannableString2 = spannableString.toString();
            int i4 = 0;
            int i5 = -1;
            while (true) {
                i5 = spannableString2.indexOf(47, i5 + 1);
                if (i5 != -1) {
                    if (i5 < spannableString2.length() - 1) {
                        if (i4 >= i3) {
                            break;
                        } else if (a(i5, spannableString, i2)) {
                            i4++;
                        }
                    }
                } else {
                    break;
                }
            }
            while (true) {
                i5 = spannableString2.indexOf(91, i5 + 1);
                if (i5 != -1) {
                    if (i5 < spannableString2.length() - 1) {
                        if (i4 >= i3) {
                            break;
                        } else if (a(i5, spannableString, i2)) {
                            i4++;
                        }
                    }
                } else {
                    break;
                }
            }
            AppMethodBeat.o(104939);
        }
        return spannableString;
    }

    private boolean a(int i2, SpannableString spannableString, int i3) {
        AppMethodBeat.i(104940);
        a big = big(new StringBuilder().append((Object) spannableString.subSequence(i2, spannableString.length())).toString());
        if (big != null) {
            Drawable a2 = a(big);
            if (a2 == null || i2 > spannableString.length() || big.text.length() + i2 > spannableString.length()) {
                Log.i("MicroMsg.QQSmileyManager", "spanQQSmileyIcon failed. drawable not found. smiley:%s", big.toString());
            } else {
                b.gxI().a(spannableString, a2, i2, i2 + big.text.length(), i3);
                AppMethodBeat.o(104940);
                return true;
            }
        }
        AppMethodBeat.o(104940);
        return false;
    }

    public final Drawable a(SmileyInfo smileyInfo) {
        Drawable bih;
        AppMethodBeat.i(177039);
        int i2 = smileyInfo.field_position;
        if (i2 >= 0) {
            bih = b.gxI().Al(i2);
        } else {
            bih = bih(smileyInfo.field_fileName);
        }
        AppMethodBeat.o(177039);
        return bih;
    }

    private Drawable a(a aVar) {
        Drawable bih;
        AppMethodBeat.i(104941);
        int i2 = aVar.pos;
        if (i2 >= 0) {
            bih = b.gxI().Al(i2);
        } else {
            bih = bih(aVar.name);
        }
        AppMethodBeat.o(104941);
        return bih;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x00cd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.drawable.Drawable bih(java.lang.String r12) {
        /*
        // Method dump skipped, instructions count: 442
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ce.f.bih(java.lang.String):android.graphics.drawable.Drawable");
    }

    public final SmileyInfo bii(String str) {
        AppMethodBeat.i(104943);
        if (this.NLh == null || !this.NLh.containsKey(str)) {
            Log.i("MicroMsg.QQSmileyManager", "getSmileyInfo failed. smiley map no contains key:%s", str.replace("\\", "\\\\"));
            AppMethodBeat.o(104943);
            return null;
        }
        SmileyInfo smileyInfo = this.NLh.get(str);
        AppMethodBeat.o(104943);
        return smileyInfo;
    }

    public final ArrayList<String> gxY() {
        AppMethodBeat.i(104944);
        ArrayList<String> arrayList = new ArrayList<>();
        if (this.NLd != null) {
            Iterator<SmileyInfo> it = this.NLd.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().field_key);
            }
        }
        AppMethodBeat.o(104944);
        return arrayList;
    }

    public static class a {
        public String key;
        public String name;
        public int pos;
        public String text;

        a(int i2, String str, String str2, String str3) {
            this.pos = i2;
            this.key = str;
            this.text = str2;
            this.name = str3;
        }
    }
}
