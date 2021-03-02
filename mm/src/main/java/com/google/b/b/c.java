package com.google.b.b;

import com.tencent.kinda.framework.app.KindaConfigCacheStg;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.smtt.sdk.TbsListener;
import java.util.HashMap;
import java.util.Map;

public enum c {
    Cp437(new int[]{0, 2}, new String[0]),
    ISO8859_1(new int[]{1, 3}, KindaConfigCacheStg.SAVE_CHARSET),
    ISO8859_2(4, "ISO-8859-2"),
    ISO8859_3(5, "ISO-8859-3"),
    ISO8859_4(6, "ISO-8859-4"),
    ISO8859_5(7, "ISO-8859-5"),
    ISO8859_6(8, "ISO-8859-6"),
    ISO8859_7(9, "ISO-8859-7"),
    ISO8859_8(10, "ISO-8859-8"),
    ISO8859_9(11, "ISO-8859-9"),
    ISO8859_10(12, "ISO-8859-10"),
    ISO8859_11(13, "ISO-8859-11"),
    ISO8859_13(15, "ISO-8859-13"),
    ISO8859_14(16, "ISO-8859-14"),
    ISO8859_15(17, "ISO-8859-15"),
    ISO8859_16(18, "ISO-8859-16"),
    SJIS(20, "Shift_JIS"),
    Cp1250(21, "windows-1250"),
    Cp1251(22, "windows-1251"),
    Cp1252(23, "windows-1252"),
    Cp1256(24, "windows-1256"),
    UnicodeBigUnmarked(25, "UTF-16BE", "UnicodeBig"),
    UTF8(26, MimeTypeUtil.ContentType.DEFAULT_CHARSET),
    ASCII(new int[]{27, TbsListener.ErrorCode.NEEDDOWNLOAD_TRUE}, "US-ASCII"),
    Big5,
    GB18030(29, "GB2312", "EUC_CN", "GBK"),
    EUC_KR(30, "EUC-KR");
    
    private static final Map<Integer, c> cdb = new HashMap();
    private static final Map<String, c> cdc = new HashMap();
    public final int[] cdd;
    private final String[] cde;

    public static c valueOf(String str) {
        AppMethodBeat.i(12206);
        c cVar = (c) Enum.valueOf(c.class, str);
        AppMethodBeat.o(12206);
        return cVar;
    }

    static {
        AppMethodBeat.i(12210);
        c[] values = values();
        for (c cVar : values) {
            for (int i2 : cVar.cdd) {
                cdb.put(Integer.valueOf(i2), cVar);
            }
            cdc.put(cVar.name(), cVar);
            for (String str : cVar.cde) {
                cdc.put(str, cVar);
            }
        }
        AppMethodBeat.o(12210);
    }

    /* JADX WARN: Incorrect types in method signature: (I)V */
    private c(String str) {
        this(new int[]{28}, new String[0]);
        AppMethodBeat.i(12207);
        AppMethodBeat.o(12207);
    }

    private c(int i2, String... strArr) {
        AppMethodBeat.i(12208);
        this.cdd = new int[]{i2};
        this.cde = strArr;
        AppMethodBeat.o(12208);
    }

    private c(int[] iArr, String... strArr) {
        this.cdd = iArr;
        this.cde = strArr;
    }

    public static c cr(String str) {
        AppMethodBeat.i(12209);
        c cVar = cdc.get(str);
        AppMethodBeat.o(12209);
        return cVar;
    }
}
