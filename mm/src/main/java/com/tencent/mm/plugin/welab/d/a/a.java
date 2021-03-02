package com.tencent.mm.plugin.welab.d.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ec;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class a extends ec {
    private static final List<String> JGd = Arrays.asList("_cn", "_hk", "_tw", "_en");
    public static IAutoDBItem.MAutoDBInfo info;
    private Map<String, Field> JGc = new HashMap();

    public a() {
        AppMethodBeat.i(146255);
        AppMethodBeat.o(146255);
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    public int hashCode() {
        AppMethodBeat.i(146256);
        int hashCode = this.field_LabsAppId.hashCode();
        AppMethodBeat.o(146256);
        return hashCode;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(146257);
        if (obj == this) {
            AppMethodBeat.o(146257);
            return true;
        } else if (obj instanceof a) {
            boolean equals = ((a) obj).field_LabsAppId.equals(this.field_LabsAppId);
            AppMethodBeat.o(146257);
            return equals;
        } else {
            AppMethodBeat.o(146257);
            return false;
        }
    }

    public final boolean isValid() {
        AppMethodBeat.i(146258);
        if (TextUtils.isEmpty(this.field_LabsAppId) || this.field_LabsAppId.equals("labs1de6f3")) {
            AppMethodBeat.o(146258);
            return false;
        }
        AppMethodBeat.o(146258);
        return true;
    }

    public final boolean isRunning() {
        AppMethodBeat.i(146259);
        if (!isValid() || System.currentTimeMillis() / 1000 < this.field_starttime || System.currentTimeMillis() / 1000 >= this.field_endtime) {
            AppMethodBeat.o(146259);
            return false;
        }
        AppMethodBeat.o(146259);
        return true;
    }

    public final boolean isExpired() {
        AppMethodBeat.i(146260);
        if (!isValid() || System.currentTimeMillis() / 1000 < this.field_endtime) {
            AppMethodBeat.o(146260);
            return false;
        }
        AppMethodBeat.o(146260);
        return true;
    }

    public String toString() {
        AppMethodBeat.i(146261);
        String str = "[appid " + this.field_LabsAppId + ",title " + this.field_Title_cn + ", exptId " + this.field_expId + "]";
        AppMethodBeat.o(146261);
        return str;
    }

    public final String bbH(String str) {
        AppMethodBeat.i(146262);
        String afQ = afQ(str + "Key_android");
        if (!TextUtils.isEmpty(afQ)) {
            String string = MMApplicationContext.getResources().getString(MMApplicationContext.getResources().getIdentifier(afQ, "string", MMApplicationContext.getPackageName()));
            if (!TextUtils.isEmpty(string)) {
                AppMethodBeat.o(146262);
                return string;
            }
        }
        String currentLanguage = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
        if (LocaleUtil.isSimplifiedChineseAppLang()) {
            String mo = mo(str, "_cn");
            AppMethodBeat.o(146262);
            return mo;
        } else if (LocaleUtil.HONGKONG.equals(currentLanguage)) {
            String mo2 = mo(str, "_hk");
            AppMethodBeat.o(146262);
            return mo2;
        } else if (LocaleUtil.TAIWAN.equals(currentLanguage)) {
            String mo3 = mo(str, "_tw");
            AppMethodBeat.o(146262);
            return mo3;
        } else {
            String mo4 = mo(str, "_en");
            AppMethodBeat.o(146262);
            return mo4;
        }
    }

    private String mo(String str, String str2) {
        AppMethodBeat.i(146263);
        String afQ = afQ(str + str2);
        if (!TextUtils.isEmpty(afQ)) {
            AppMethodBeat.o(146263);
            return afQ;
        }
        String bbI = bbI(str);
        AppMethodBeat.o(146263);
        return bbI;
    }

    private String bbI(String str) {
        AppMethodBeat.i(146264);
        Iterator<String> it = JGd.iterator();
        while (it.hasNext()) {
            String afQ = afQ(str + it.next());
            if (!TextUtils.isEmpty(afQ)) {
                AppMethodBeat.o(146264);
                return afQ;
            }
        }
        AppMethodBeat.o(146264);
        return "";
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x001d A[SYNTHETIC, Splitter:B:8:0x001d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String afQ(java.lang.String r5) {
        /*
            r4 = this;
            r3 = 146265(0x23b59, float:2.04961E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
            java.util.Map<java.lang.String, java.lang.reflect.Field> r0 = r4.JGc
            java.lang.Object r0 = r0.get(r5)
            java.lang.reflect.Field r0 = (java.lang.reflect.Field) r0
            if (r0 != 0) goto L_0x0049
            java.lang.Class<com.tencent.mm.plugin.welab.d.a.a> r1 = com.tencent.mm.plugin.welab.d.a.a.class
            java.lang.reflect.Field r2 = r1.getField(r5)     // Catch:{ NoSuchFieldException -> 0x0027 }
            java.util.Map<java.lang.String, java.lang.reflect.Field> r0 = r4.JGc     // Catch:{ NoSuchFieldException -> 0x0046 }
            r0.put(r5, r2)     // Catch:{ NoSuchFieldException -> 0x0046 }
        L_0x001b:
            if (r2 == 0) goto L_0x003f
            java.lang.Object r0 = r2.get(r4)     // Catch:{ IllegalAccessException -> 0x0034 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ IllegalAccessException -> 0x0034 }
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
        L_0x0026:
            return r0
        L_0x0027:
            r1 = move-exception
            r2 = r0
        L_0x0029:
            java.lang.String r0 = "LabAppInfo"
            java.lang.String r1 = com.tencent.mm.sdk.platformtools.Util.stackTraceToString(r1)
            com.tencent.mm.sdk.platformtools.Log.w(r0, r1)
            goto L_0x001b
        L_0x0034:
            r0 = move-exception
            java.lang.String r1 = "LabAppInfo"
            java.lang.String r0 = com.tencent.mm.sdk.platformtools.Util.stackTraceToString(r0)
            com.tencent.mm.sdk.platformtools.Log.w(r1, r0)
        L_0x003f:
            java.lang.String r0 = ""
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
            goto L_0x0026
        L_0x0046:
            r0 = move-exception
            r1 = r0
            goto L_0x0029
        L_0x0049:
            r2 = r0
            goto L_0x001b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.welab.d.a.a.afQ(java.lang.String):java.lang.String");
    }

    public final boolean isOffline() {
        AppMethodBeat.i(146266);
        if (isExpired() || this.field_Switch == 3) {
            AppMethodBeat.o(146266);
            return true;
        }
        AppMethodBeat.o(146266);
        return false;
    }

    public final boolean gjo() {
        AppMethodBeat.i(146267);
        if (!isRunning() || !(this.field_Switch == 2 || this.field_Switch == 1)) {
            AppMethodBeat.o(146267);
            return false;
        }
        AppMethodBeat.o(146267);
        return true;
    }

    public final void reportIdkey() {
        AppMethodBeat.i(146268);
        if (this.field_idkey > 0 && this.field_idkeyValue >= 0) {
            h.INSTANCE.idkeyStat((long) this.field_idkey, (long) this.field_idkeyValue, 1, false);
        }
        AppMethodBeat.o(146268);
    }

    public final boolean gjp() {
        return this.field_bItemFromXExpt == 1;
    }

    public final boolean gjq() {
        if (this.field_status == 1) {
            return true;
        }
        return false;
    }

    static {
        AppMethodBeat.i(146269);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[46];
        mAutoDBInfo.columns = new String[47];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "LabsAppId";
        mAutoDBInfo.colsMap.put("LabsAppId", "TEXT PRIMARY KEY ");
        sb.append(" LabsAppId TEXT PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "LabsAppId";
        mAutoDBInfo.columns[1] = "expId";
        mAutoDBInfo.colsMap.put("expId", "TEXT default '' ");
        sb.append(" expId TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "Type";
        mAutoDBInfo.colsMap.put("Type", "INTEGER default '0' ");
        sb.append(" Type INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "BizType";
        mAutoDBInfo.colsMap.put("BizType", "INTEGER default '0' ");
        sb.append(" BizType INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "Switch";
        mAutoDBInfo.colsMap.put("Switch", "INTEGER default '0' ");
        sb.append(" Switch INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "AllVer";
        mAutoDBInfo.colsMap.put("AllVer", "INTEGER default '0' ");
        sb.append(" AllVer INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "DetailURL";
        mAutoDBInfo.colsMap.put("DetailURL", "TEXT");
        sb.append(" DetailURL TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[7] = "WeAppUser";
        mAutoDBInfo.colsMap.put("WeAppUser", "TEXT");
        sb.append(" WeAppUser TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[8] = "WeAppPath";
        mAutoDBInfo.colsMap.put("WeAppPath", "TEXT");
        sb.append(" WeAppPath TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[9] = "Pos";
        mAutoDBInfo.colsMap.put("Pos", "INTEGER default '0' ");
        sb.append(" Pos INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[10] = "TitleKey_android";
        mAutoDBInfo.colsMap.put("TitleKey_android", "TEXT");
        sb.append(" TitleKey_android TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[11] = "Title_cn";
        mAutoDBInfo.colsMap.put("Title_cn", "TEXT");
        sb.append(" Title_cn TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[12] = "Title_hk";
        mAutoDBInfo.colsMap.put("Title_hk", "TEXT");
        sb.append(" Title_hk TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[13] = "Title_tw";
        mAutoDBInfo.colsMap.put("Title_tw", "TEXT");
        sb.append(" Title_tw TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[14] = "Title_en";
        mAutoDBInfo.colsMap.put("Title_en", "TEXT");
        sb.append(" Title_en TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[15] = "Desc_cn";
        mAutoDBInfo.colsMap.put("Desc_cn", "TEXT");
        sb.append(" Desc_cn TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[16] = "Desc_hk";
        mAutoDBInfo.colsMap.put("Desc_hk", "TEXT");
        sb.append(" Desc_hk TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[17] = "Desc_tw";
        mAutoDBInfo.colsMap.put("Desc_tw", "TEXT");
        sb.append(" Desc_tw TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[18] = "Desc_en";
        mAutoDBInfo.colsMap.put("Desc_en", "TEXT");
        sb.append(" Desc_en TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[19] = "Introduce_cn";
        mAutoDBInfo.colsMap.put("Introduce_cn", "TEXT");
        sb.append(" Introduce_cn TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[20] = "Introduce_hk";
        mAutoDBInfo.colsMap.put("Introduce_hk", "TEXT");
        sb.append(" Introduce_hk TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[21] = "Introduce_tw";
        mAutoDBInfo.colsMap.put("Introduce_tw", "TEXT");
        sb.append(" Introduce_tw TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[22] = "Introduce_en";
        mAutoDBInfo.colsMap.put("Introduce_en", "TEXT");
        sb.append(" Introduce_en TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[23] = "starttime";
        mAutoDBInfo.colsMap.put("starttime", "LONG");
        sb.append(" starttime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[24] = "endtime";
        mAutoDBInfo.colsMap.put("endtime", "LONG");
        sb.append(" endtime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[25] = "sequence";
        mAutoDBInfo.colsMap.put("sequence", "LONG");
        sb.append(" sequence LONG");
        sb.append(", ");
        mAutoDBInfo.columns[26] = "prioritylevel";
        mAutoDBInfo.colsMap.put("prioritylevel", "INTEGER");
        sb.append(" prioritylevel INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[27] = "status";
        mAutoDBInfo.colsMap.put("status", "INTEGER");
        sb.append(" status INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[28] = "ThumbUrl_cn";
        mAutoDBInfo.colsMap.put("ThumbUrl_cn", "TEXT");
        sb.append(" ThumbUrl_cn TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[29] = "ThumbUrl_hk";
        mAutoDBInfo.colsMap.put("ThumbUrl_hk", "TEXT");
        sb.append(" ThumbUrl_hk TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[30] = "ThumbUrl_tw";
        mAutoDBInfo.colsMap.put("ThumbUrl_tw", "TEXT");
        sb.append(" ThumbUrl_tw TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[31] = "ThumbUrl_en";
        mAutoDBInfo.colsMap.put("ThumbUrl_en", "TEXT");
        sb.append(" ThumbUrl_en TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[32] = "ImgUrl_android_cn";
        mAutoDBInfo.colsMap.put("ImgUrl_android_cn", "TEXT");
        sb.append(" ImgUrl_android_cn TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[33] = "ImgUrl_android_hk";
        mAutoDBInfo.colsMap.put("ImgUrl_android_hk", "TEXT");
        sb.append(" ImgUrl_android_hk TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[34] = "ImgUrl_android_tw";
        mAutoDBInfo.colsMap.put("ImgUrl_android_tw", "TEXT");
        sb.append(" ImgUrl_android_tw TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[35] = "ImgUrl_android_en";
        mAutoDBInfo.colsMap.put("ImgUrl_android_en", "TEXT");
        sb.append(" ImgUrl_android_en TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[36] = "RedPoint";
        mAutoDBInfo.colsMap.put("RedPoint", "INTEGER");
        sb.append(" RedPoint INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[37] = "WeAppDebugMode";
        mAutoDBInfo.colsMap.put("WeAppDebugMode", "INTEGER");
        sb.append(" WeAppDebugMode INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[38] = "idkey";
        mAutoDBInfo.colsMap.put("idkey", "INTEGER");
        sb.append(" idkey INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[39] = "idkeyValue";
        mAutoDBInfo.colsMap.put("idkeyValue", "INTEGER");
        sb.append(" idkeyValue INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[40] = "Icon";
        mAutoDBInfo.colsMap.put("Icon", "TEXT");
        sb.append(" Icon TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[41] = "ImgUrl_cn";
        mAutoDBInfo.colsMap.put("ImgUrl_cn", "TEXT");
        sb.append(" ImgUrl_cn TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[42] = "ImgUrl_hk";
        mAutoDBInfo.colsMap.put("ImgUrl_hk", "TEXT");
        sb.append(" ImgUrl_hk TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[43] = "ImgUrl_tw";
        mAutoDBInfo.colsMap.put("ImgUrl_tw", "TEXT");
        sb.append(" ImgUrl_tw TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[44] = "ImgUrl_en";
        mAutoDBInfo.colsMap.put("ImgUrl_en", "TEXT");
        sb.append(" ImgUrl_en TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[45] = "bItemFromXExpt";
        mAutoDBInfo.colsMap.put("bItemFromXExpt", "INTEGER");
        sb.append(" bItemFromXExpt INTEGER");
        mAutoDBInfo.columns[46] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(146269);
    }
}
