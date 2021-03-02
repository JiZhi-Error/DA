package com.tencent.mm.cc;

import android.arch.a.c.a;
import android.content.Context;
import android.content.res.AssetManager;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cc.d;
import com.tencent.mm.cc.g;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class h {
    private static d NDA;
    private static g NDB;
    private static String NDC = "";
    private static boolean NDD = false;
    private static boolean NDE = true;
    private static a<String, Boolean> NDF = new a<String, Boolean>() {
        /* class com.tencent.mm.cc.h.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.arch.a.c.a
        public final /* bridge */ /* synthetic */ Boolean apply(String str) {
            return Boolean.TRUE;
        }
    };
    private static final List<String> NDx = Arrays.asList(LocaleUtil.CHINA, LocaleUtil.ENGLISH);
    private static h NDy;
    private static i NDz;

    static {
        AppMethodBeat.i(141263);
        AppMethodBeat.o(141263);
    }

    public static h gvF() {
        h hVar;
        AppMethodBeat.i(141249);
        synchronized (h.class) {
            try {
                if (NDy == null) {
                    NDy = new h();
                }
                hVar = NDy;
            } finally {
                AppMethodBeat.o(141249);
            }
        }
        return hVar;
    }

    private h() {
    }

    private static boolean bhE(String str) {
        AppMethodBeat.i(141250);
        if (NDx.contains(str)) {
            AppMethodBeat.o(141250);
            return false;
        }
        AppMethodBeat.o(141250);
        return true;
    }

    private static void clean() {
        AppMethodBeat.i(141251);
        if (NDz != null) {
            i iVar = NDz;
            if (iVar.NDG != null) {
                iVar.NDG.clear();
            }
            if (iVar.NDH != null) {
                iVar.NDH = null;
            }
        }
        if (NDA != null) {
            d dVar = NDA;
            if (dVar.NDr != null) {
                dVar.NDr.clear();
            }
            if (dVar.mData != null) {
                dVar.mData = null;
            }
        }
        if (NDB != null) {
            g gVar = NDB;
            if (gVar.NDv != null) {
                gVar.NDv.clear();
            }
            if (gVar.mData != null) {
                gVar.mData = null;
            }
        }
        AppMethodBeat.o(141251);
    }

    public static h jq(Context context) {
        AppMethodBeat.i(141252);
        h cw = cw(context, LocaleUtil.loadApplicationLanguage(context.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), context));
        AppMethodBeat.o(141252);
        return cw;
    }

    public static h cw(Context context, String str) {
        Locale locale;
        AppMethodBeat.i(141253);
        if (context.getResources() == null) {
            Log.e("MicroMsg.language.StringResouces", "the resource is null! why?");
            AppMethodBeat.o(141253);
            return null;
        }
        AssetManager assets = context.getAssets();
        if (assets != null) {
            gvF();
        }
        if (assets != null) {
            gvF();
            if (NDE) {
                if (Util.isNullOrNil(str) || str.equalsIgnoreCase(LocaleUtil.LANGUAGE_DEFAULT)) {
                    locale = Locale.getDefault();
                    LocaleUtil.updateApplicationResourceLocale(context, locale);
                } else {
                    locale = LocaleUtil.transLanguageToLocale(str);
                }
                String locale2 = locale.toString();
                gvF();
                boolean bhE = bhE(locale2);
                NDD = bhE;
                if (bhE) {
                    gvF();
                    c(assets, locale2);
                    h gvF = gvF();
                    AppMethodBeat.o(141253);
                    return gvF;
                }
                clean();
                NDC = locale2;
                AppMethodBeat.o(141253);
                return null;
            }
        }
        AppMethodBeat.o(141253);
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x01c8 A[SYNTHETIC, Splitter:B:49:0x01c8] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x01cd A[SYNTHETIC, Splitter:B:52:0x01cd] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x01ff A[SYNTHETIC, Splitter:B:61:0x01ff] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0204 A[SYNTHETIC, Splitter:B:64:0x0204] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void c(android.content.res.AssetManager r13, java.lang.String r14) {
        /*
        // Method dump skipped, instructions count: 573
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.cc.h.c(android.content.res.AssetManager, java.lang.String):void");
    }

    public static boolean gvG() {
        AppMethodBeat.i(141256);
        if (!NDE || !NDD) {
            AppMethodBeat.o(141256);
            return false;
        }
        AppMethodBeat.o(141256);
        return true;
    }

    public static boolean gvz() {
        return NDE;
    }

    public static String getString(int i2) {
        AppMethodBeat.i(141257);
        if (NDz == null) {
            AppMethodBeat.o(141257);
            return null;
        }
        String string = NDz.getString(i2);
        AppMethodBeat.o(141257);
        return string;
    }

    public static String getQuantityString(int i2, int i3) {
        AppMethodBeat.i(141258);
        if (NDA == null) {
            AppMethodBeat.o(141258);
            return null;
        }
        String quantityString = NDA.getQuantityString(i2, i3, new Object[0]);
        AppMethodBeat.o(141258);
        return quantityString;
    }

    public static String getQuantityString(int i2, int i3, Object... objArr) {
        AppMethodBeat.i(141259);
        if (NDA == null) {
            AppMethodBeat.o(141259);
            return null;
        }
        String quantityString = NDA.getQuantityString(i2, i3, objArr);
        AppMethodBeat.o(141259);
        return quantityString;
    }

    public static String[] getStringArray(int i2) {
        int length;
        String[] strArr;
        AppMethodBeat.i(141260);
        if (NDB == null) {
            AppMethodBeat.o(141260);
            return null;
        }
        g gVar = NDB;
        int indexOfKey = gVar.NDv.indexOfKey(i2);
        if (indexOfKey < 0) {
            AppMethodBeat.o(141260);
            return null;
        }
        if (indexOfKey < gVar.NDv.size() - 1) {
            length = gVar.NDv.valueAt(indexOfKey + 1).NDw[0];
        } else {
            length = gVar.mData.length;
        }
        g.a valueAt = gVar.NDv.valueAt(indexOfKey);
        int length2 = valueAt.NDw.length;
        if (length2 > 0) {
            String[] strArr2 = new String[length2];
            for (int i3 = 0; i3 < length2; i3++) {
                if (i3 < length2 - 1) {
                    strArr2[i3] = new String(gVar.mData, valueAt.NDw[i3], valueAt.NDw[i3 + 1] - valueAt.NDw[i3]);
                } else {
                    strArr2[i3] = new String(gVar.mData, valueAt.NDw[i3], length - valueAt.NDw[i3]);
                }
            }
            strArr = strArr2;
        } else {
            strArr = null;
        }
        AppMethodBeat.o(141260);
        return strArr;
    }

    private static int a(DataInputStream dataInputStream, SparseArray<d.a> sparseArray, int i2, int i3) {
        AppMethodBeat.i(141261);
        try {
            int readByte = dataInputStream.readByte();
            if (readByte < 0) {
                AppMethodBeat.o(141261);
                return 0;
            }
            int[] iArr = new int[readByte];
            int[] iArr2 = new int[readByte];
            int i4 = 0;
            for (int i5 = 0; i5 < readByte; i5++) {
                iArr[i5] = dataInputStream.readByte();
                iArr2[i5] = i3;
                short readShort = dataInputStream.readShort();
                i4 += readShort;
                i3 += readShort;
            }
            sparseArray.append(i2, new d.a(i2, iArr, iArr2));
            AppMethodBeat.o(141261);
            return i4;
        } catch (IOException e2) {
            Log.e("MicroMsg.language.StringResouces", "exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(141261);
            return 0;
        }
    }

    public static CharSequence an(CharSequence charSequence) {
        if (charSequence == null) {
        }
        return charSequence;
    }

    public static String jr(Context context) {
        AppMethodBeat.i(205095);
        if (BuildInfo.IS_FLAVOR_BLUE) {
            String string = context.getString(R.string.kd);
            AppMethodBeat.o(205095);
            return string;
        } else if (com.tencent.mm.protocal.d.KyR) {
            String string2 = context.getString(R.string.gx);
            AppMethodBeat.o(205095);
            return string2;
        } else {
            AppMethodBeat.o(205095);
            return "";
        }
    }
}
