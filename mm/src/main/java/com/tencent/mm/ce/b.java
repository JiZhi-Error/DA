package com.tencent.mm.ce;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.api.f;
import com.tencent.mm.emoji.decode.MMGIFJNIFactory;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.Iterator;
import java.util.LinkedList;

public class b extends f {
    public static final String NKt = (com.tencent.mm.loader.j.b.aKA() + "app_font");
    public static final String NKu = (NKt + "/color_emoji");
    private static final boolean NKv = (Build.VERSION.SDK_INT < 19);
    private static b NKw;
    private int NKA;
    public long NKB = 0;
    private a NKC = new a();
    private SparseArray<c> NKD = new SparseArray<>();
    public SparseArray<c> NKE = new SparseArray<>();
    private SparseArray<c> NKF = new SparseArray<>();
    private SparseArray<SparseArray<c>> NKG = new SparseArray<>();
    private SparseArray<String> NKH = null;
    private com.tencent.mm.b.f<String, Bitmap> NKI = new com.tencent.mm.memory.a.b(200, getClass());
    private boolean NKJ = false;
    private LinkedList<d> NKK;
    private final Spannable.Factory NKL = new Spannable.Factory() {
        /* class com.tencent.mm.ce.b.AnonymousClass1 */

        public final Spannable newSpannable(CharSequence charSequence) {
            AppMethodBeat.i(104896);
            SpannableString spannableString = new SpannableString(charSequence);
            AppMethodBeat.o(104896);
            return spannableString;
        }
    };
    private int NKx = 0;
    private int NKy;
    private int NKz;
    private Context mContext = MMApplicationContext.getContext();
    private LinkedList<c> oEG;

    static {
        AppMethodBeat.i(104917);
        AppMethodBeat.o(104917);
    }

    private b() {
        AppMethodBeat.i(104897);
        if (!s.YS(NKu)) {
            gxL();
        } else {
            Log.i("MicroMsg.EmojiHelper", "emoji color file exist.");
        }
        init();
        if (com.tencent.mm.cb.a.jk(this.mContext)) {
            this.NKx = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 4);
            AppMethodBeat.o(104897);
            return;
        }
        this.NKx = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 2);
        AppMethodBeat.o(104897);
    }

    public static b gxI() {
        AppMethodBeat.i(104898);
        if (NKw == null) {
            synchronized (b.class) {
                try {
                    NKw = new b();
                } catch (Throwable th) {
                    AppMethodBeat.o(104898);
                    throw th;
                }
            }
        }
        b bVar = NKw;
        AppMethodBeat.o(104898);
        return bVar;
    }

    public final a gxJ() {
        return this.NKC;
    }

    public final int getOffset() {
        return this.NKz;
    }

    private static void gxK() {
        AppMethodBeat.i(104899);
        o oVar = new o(NKt);
        if (oVar.isFile()) {
            oVar.delete();
        }
        if (!oVar.exists()) {
            oVar.mkdirs();
        }
        AppMethodBeat.o(104899);
    }

    private static void gxL() {
        AppMethodBeat.i(104900);
        long currentTimeMillis = System.currentTimeMillis();
        gxK();
        s.nw("assets:///color_emoji", NKu);
        Log.d("MicroMsg.EmojiHelper", "copyColorEmojiFile. use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(104900);
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x00d4 A[SYNTHETIC, Splitter:B:30:0x00d4] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00d9 A[Catch:{ IOException -> 0x00dd }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00ef A[SYNTHETIC, Splitter:B:39:0x00ef] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00f4 A[Catch:{ IOException -> 0x00fb }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean init() {
        /*
        // Method dump skipped, instructions count: 278
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ce.b.init():boolean");
    }

    public static void bhX(String str) {
        AppMethodBeat.i(199814);
        gxK();
        s.nw(str, NKu);
        AppMethodBeat.o(199814);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0042 A[SYNTHETIC, Splitter:B:20:0x0042] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0047 A[Catch:{ IOException -> 0x0050 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0062 A[SYNTHETIC, Splitter:B:30:0x0062] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0067 A[Catch:{ IOException -> 0x006e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long bhY(java.lang.String r8) {
        /*
        // Method dump skipped, instructions count: 137
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ce.b.bhY(java.lang.String):long");
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x003f A[SYNTHETIC, Splitter:B:20:0x003f] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0044 A[Catch:{ IOException -> 0x004c }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x005e A[SYNTHETIC, Splitter:B:30:0x005e] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0063 A[Catch:{ IOException -> 0x006a }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int bhZ(java.lang.String r8) {
        /*
        // Method dump skipped, instructions count: 129
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ce.b.bhZ(java.lang.String):int");
    }

    /* access modifiers changed from: package-private */
    public class a {
        c NKN;
        boolean NKO = false;
        int end;
        int start;

        public a(c cVar, int i2, int i3, boolean z) {
            this.NKN = cVar;
            this.start = i2;
            this.end = i3;
            this.NKO = z;
        }
    }

    public final SpannableString a(SpannableString spannableString, int i2, PInt pInt) {
        AppMethodBeat.i(104904);
        SpannableString spannableString2 = (SpannableString) a(spannableString, i2, pInt, this.NKL);
        AppMethodBeat.o(104904);
        return spannableString2;
    }

    public final Spannable a(Spannable spannable, int i2, PInt pInt, Spannable.Factory factory) {
        Spannable spannable2;
        int charCount;
        int i3;
        int i4;
        AppMethodBeat.i(104905);
        if (spannable == null || spannable.length() == 0) {
            AppMethodBeat.o(104905);
            return spannable;
        }
        String obj = spannable.toString();
        LinkedList<a> linkedList = new LinkedList();
        int length = obj.length();
        for (int i5 = 0; i5 < length; i5 = charCount) {
            int codePointAt = obj.codePointAt(i5);
            charCount = i5 + Character.charCount(codePointAt);
            if (charCount < length) {
                i3 = obj.codePointAt(charCount);
            } else {
                i3 = 0;
            }
            c ajN = gxI().ajN(codePointAt);
            if (ajN != null) {
                linkedList.add(new a(ajN, i5, i5 + 1, true));
            } else {
                c kK = gxI().kK(codePointAt, i3);
                if (kK != null) {
                    if (kK.owI != 0 || (127995 <= i3 && i3 <= 127999)) {
                        i4 = charCount + Character.charCount(i3);
                    } else {
                        i4 = charCount;
                    }
                    linkedList.add(new a(kK, i5, i4, false));
                    charCount = i4;
                }
            }
            if (linkedList.size() >= pInt.value) {
                break;
            }
        }
        if (linkedList.size() == 0) {
            AppMethodBeat.o(104905);
            return spannable;
        }
        if (NKv) {
            StringBuilder sb = new StringBuilder(obj);
            for (a aVar : linkedList) {
                if (!aVar.NKO) {
                    if (aVar.NKN.owJ == 0 || aVar.end - aVar.start != 1) {
                        sb.replace(aVar.start, aVar.end, "....".substring(0, aVar.end - aVar.start));
                    } else {
                        sb.replace(aVar.start, aVar.end, String.valueOf((char) aVar.NKN.owJ));
                    }
                }
            }
            spannable2 = factory.newSpannable(sb.toString());
        } else {
            spannable2 = spannable;
        }
        for (a aVar2 : linkedList) {
            a(spannable2, gxI().a(aVar2.NKN, true), aVar2.start, aVar2.end, i2);
        }
        pInt.value -= linkedList.size();
        AppMethodBeat.o(104905);
        return spannable2;
    }

    public static boolean bia(String str) {
        int i2;
        AppMethodBeat.i(104906);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(104906);
            return false;
        }
        String str2 = str.toString();
        int length = str2.length();
        int i3 = 0;
        while (i3 < length) {
            int codePointAt = str2.codePointAt(i3);
            int charCount = Character.charCount(codePointAt) + i3;
            if (charCount < length) {
                i2 = str2.codePointAt(charCount);
            } else {
                i2 = 0;
            }
            if (gxI().ajN(codePointAt) != null) {
                AppMethodBeat.o(104906);
                return true;
            } else if (gxI().kK(codePointAt, i2) != null) {
                AppMethodBeat.o(104906);
                return true;
            } else {
                i3 = charCount;
            }
        }
        AppMethodBeat.o(104906);
        return false;
    }

    public final String bib(String str) {
        int i2;
        AppMethodBeat.i(104907);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(104907);
            return str;
        }
        if (this.NKH == null) {
            gxM();
        }
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        int i3 = 0;
        while (i3 < length) {
            int codePointAt = str.codePointAt(i3);
            i3 += Character.charCount(codePointAt);
            if (i3 < length) {
                i2 = str.codePointAt(i3);
            } else {
                i2 = 0;
            }
            c ajN = gxI().ajN(codePointAt);
            if (ajN != null) {
                String str2 = this.NKH.get(ajN.owJ);
                if (str2 != null) {
                    sb.append(str2);
                } else {
                    sb.append(this.mContext.getString(R.string.tv));
                }
            } else {
                c kK = gxI().kK(codePointAt, i2);
                if (kK != null) {
                    if (kK.owI != 0) {
                        i3 = Character.charCount(i2) + i3;
                    }
                    String str3 = this.NKH.get(kK.owJ);
                    if (str3 != null) {
                        sb.append(str3);
                    } else {
                        sb.append(this.mContext.getString(R.string.tv));
                    }
                } else {
                    sb.appendCodePoint(codePointAt);
                }
            }
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(104907);
        return sb2;
    }

    public static String alW(String str) {
        int i2;
        AppMethodBeat.i(104908);
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        int i3 = 0;
        while (i3 < length) {
            int codePointAt = str.codePointAt(i3);
            int charCount = Character.charCount(codePointAt) + i3;
            if (charCount < length) {
                i2 = str.codePointAt(charCount);
            } else {
                i2 = 0;
            }
            c ajN = gxI().ajN(codePointAt);
            if (ajN != null) {
                sb.appendCodePoint(ajN.owH);
                if (ajN.owI != 0) {
                    sb.appendCodePoint(ajN.owI);
                    i3 = charCount;
                }
            } else {
                c kK = gxI().kK(codePointAt, i2);
                sb.appendCodePoint(codePointAt);
                if (!(kK == null || kK.owI == 0)) {
                    i3 = Character.charCount(kK.owI) + charCount;
                    sb.appendCodePoint(kK.owI);
                }
            }
            i3 = charCount;
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(104908);
        return sb2;
    }

    private void gxM() {
        String[] stringArray;
        AppMethodBeat.i(104909);
        Context context = MMApplicationContext.getContext();
        String loadApplicationLanguage = LocaleUtil.loadApplicationLanguage(context.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), context);
        if (loadApplicationLanguage.equals(LocaleUtil.CHINA)) {
            stringArray = context.getResources().getStringArray(R.array.f3024i);
        } else if (loadApplicationLanguage.equals(LocaleUtil.TAIWAN) || loadApplicationLanguage.equals(LocaleUtil.HONGKONG)) {
            stringArray = context.getResources().getStringArray(R.array.k);
        } else {
            stringArray = context.getResources().getStringArray(R.array.f3025j);
        }
        String[] stringArray2 = context.getResources().getStringArray(R.array.f3023h);
        this.NKH = new SparseArray<>();
        int i2 = 0;
        while (i2 < stringArray2.length && i2 < stringArray.length) {
            this.NKH.put(stringArray2[i2].charAt(0), stringArray[i2]);
            i2++;
        }
        AppMethodBeat.o(104909);
    }

    public final void a(Spannable spannable, Drawable drawable, int i2, int i3, int i4) {
        AppMethodBeat.i(104910);
        try {
            drawable.setBounds(0, 0, (int) (((float) i4) * 1.3f), (int) (((float) i4) * 1.3f));
            com.tencent.mm.ui.widget.a aVar = new com.tencent.mm.ui.widget.a(drawable, 1);
            aVar.QBM = this.NKx;
            spannable.setSpan(aVar, i2, i3, 33);
            AppMethodBeat.o(104910);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.EmojiHelper", e2, "", new Object[0]);
            AppMethodBeat.o(104910);
        }
    }

    public final c bic(String str) {
        AppMethodBeat.i(177034);
        if (Util.isNullOrNil(str)) {
            Log.i("MicroMsg.EmojiHelper", "getEmoji item failed. key is null.");
            AppMethodBeat.o(177034);
            return null;
        }
        int codePointAt = str.codePointAt(0);
        if (ajN(codePointAt) != null) {
            c ajN = ajN(codePointAt);
            AppMethodBeat.o(177034);
            return ajN;
        }
        c kK = kK(codePointAt, 0);
        AppMethodBeat.o(177034);
        return kK;
    }

    public final c kK(int i2, int i3) {
        boolean z;
        AppMethodBeat.i(104911);
        if (this.NKK == null || this.NKK.isEmpty() || this.NKJ) {
            this.NKK = new LinkedList<>(this.NKC.NKr);
            this.NKJ = false;
        }
        if (this.NKK == null || this.NKK.isEmpty()) {
            AppMethodBeat.o(104911);
            return null;
        }
        Iterator<d> it = this.NKK.iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            d next = it.next();
            if (i2 < next.min || i2 > next.max) {
                z = z2;
            } else {
                z = true;
            }
            z2 = z;
        }
        if (!z2) {
            AppMethodBeat.o(104911);
            return null;
        }
        SparseArray<c> sparseArray = this.NKG.get(i2);
        if (sparseArray == null) {
            AppMethodBeat.o(104911);
            return null;
        } else if (sparseArray.size() != 1 || sparseArray.get(0) == null) {
            c cVar = sparseArray.get(i3);
            AppMethodBeat.o(104911);
            return cVar;
        } else {
            c cVar2 = sparseArray.get(0);
            AppMethodBeat.o(104911);
            return cVar2;
        }
    }

    public final c ajN(int i2) {
        AppMethodBeat.i(104912);
        if (i2 < 57345 || i2 > 58679) {
            AppMethodBeat.o(104912);
            return null;
        }
        c cVar = this.NKD.get(i2);
        AppMethodBeat.o(104912);
        return cVar;
    }

    public final Drawable Al(int i2) {
        AppMethodBeat.i(104913);
        Drawable a2 = a(this.NKF.get(i2), true);
        AppMethodBeat.o(104913);
        return a2;
    }

    public final Drawable a(c cVar, boolean z) {
        byte[] bArr;
        Bitmap bitmap;
        byte[] bArr2;
        AppMethodBeat.i(104914);
        if (cVar == null) {
            Log.i("MicroMsg.EmojiHelper", "Emoji Item is null.");
            AppMethodBeat.o(104914);
            return null;
        }
        try {
            Bitmap bitmap2 = this.NKI.get(new StringBuilder().append(cVar.bNu).toString());
            if (bitmap2 == null || bitmap2.isRecycled()) {
                if (cVar.owH != 0 || this.NKB >= 1480413778780L) {
                    bArr = null;
                    bitmap = bitmap2;
                } else {
                    bArr = s.aW("assets:///emoji/qqemoji/" + cVar.NKQ + ".wxam", 0, -1);
                    Bitmap decodeThumb = MMGIFJNIFactory.Companion.decodeThumb(bArr);
                    if (decodeThumb == null) {
                        h.INSTANCE.dN(711, 20);
                    }
                    bitmap = decodeThumb;
                }
                if (bitmap == null) {
                    bArr2 = s.aW(NKu, cVar.bNu + this.NKz, cVar.size);
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inPreferredConfig = Bitmap.Config.RGB_565;
                    bitmap = BitmapFactory.decodeByteArray(bArr2, 0, bArr2.length, options);
                } else {
                    bArr2 = bArr;
                }
                if (bitmap != null) {
                    bitmap.setDensity(240);
                    this.NKI.put(new StringBuilder().append(cVar.bNu).toString(), bitmap);
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(MMApplicationContext.getContext().getResources(), bitmap);
                    AppMethodBeat.o(104914);
                    return bitmapDrawable;
                }
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(cVar.size);
                objArr[1] = Integer.valueOf(bArr2 == null ? 0 : bArr2.length);
                Log.i("MicroMsg.EmojiHelper", "bitmap is null. decode byte array failed. size:%d data length:%d", objArr);
                if (z) {
                    gxI();
                    int bhZ = bhZ(NKu);
                    gxI();
                    long bhY = bhY(NKu);
                    Log.i("MicroMsg.EmojiHelper", "emoji error currentSupportVersion:%d currentVersion:%d supportVersion:%d Version:%d", Integer.valueOf(this.NKA), Long.valueOf(this.NKB), Integer.valueOf(bhZ), Long.valueOf(bhY));
                    if (bhZ != this.NKA || bhY <= this.NKB) {
                        gxN();
                        Drawable a2 = a(cVar, false);
                        AppMethodBeat.o(104914);
                        return a2;
                    }
                    init();
                    Drawable a3 = a(cVar, false);
                    AppMethodBeat.o(104914);
                    return a3;
                }
                AppMethodBeat.o(104914);
                return null;
            }
            BitmapDrawable bitmapDrawable2 = new BitmapDrawable(MMApplicationContext.getContext().getResources(), bitmap2);
            AppMethodBeat.o(104914);
            return bitmapDrawable2;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.EmojiHelper", e2, "", new Object[0]);
        }
    }

    private void gxN() {
        AppMethodBeat.i(104915);
        if (MMApplicationContext.isMainProcess() && g.aAc()) {
            s.deleteFile(NKu);
            com.tencent.mm.pluginsdk.j.a.a.b.gnC();
            String kC = com.tencent.mm.pluginsdk.j.a.a.b.kC(37, 4);
            if (s.YS(kC)) {
                bhX(kC);
            } else {
                gxL();
                com.tencent.mm.pluginsdk.j.a.a.b.gnC().g(37, 4, -1, false);
            }
            init();
        }
        AppMethodBeat.o(104915);
    }

    private void gxO() {
        AppMethodBeat.i(104916);
        this.oEG = new LinkedList<>(this.NKC.NKs);
        if (this.oEG == null || this.oEG.isEmpty()) {
            Log.i("MicroMsg.EmojiHelper", "initIndex failed. items is empty.");
            AppMethodBeat.o(104916);
            return;
        }
        Iterator<c> it = this.oEG.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next.owH != 0) {
                SparseArray<c> sparseArray = this.NKG.get(next.owH);
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                    this.NKG.append(next.owH, sparseArray);
                }
                sparseArray.put(next.owI, next);
                if (next.owJ != 0) {
                    this.NKD.append(next.owJ, next);
                }
                if (next.NKP != -1) {
                    this.NKE.append(next.NKP, next);
                }
            } else {
                this.NKF.append(next.NKQ, next);
            }
        }
        AppMethodBeat.o(104916);
    }
}
