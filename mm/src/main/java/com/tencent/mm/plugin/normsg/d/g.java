package com.tencent.mm.plugin.normsg.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class g {
    private static String[] AGk = {decodeString(MMApplicationContext.getContext().getFilesDir().getParent() + "/dumeq/tekcos/ved/"), decodeString(MMApplicationContext.getContext().getFilesDir().getParent() + "/epip_umeq/ved/")};
    private static String[] AGl = {decodeString(MMApplicationContext.getContext().getFilesDir().getParent() + "/hsifdlog")};
    private static String[] AGm = {decodeString(MMApplicationContext.getContext().getFilesDir().getParent() + "/os.umeq_gubed_collam_cbil/bil/metsys/"), decodeString(MMApplicationContext.getContext().getFilesDir().getParent() + "/ecart_umeq/sys/"), decodeString(MMApplicationContext.getContext().getFilesDir().getParent() + "/sporp-umeq/nib/metsys/")};
    public static boolean AGn;
    public static boolean AGo;
    public static boolean AGp;

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0161  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x017b A[SYNTHETIC, Splitter:B:32:0x017b] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0186 A[SYNTHETIC, Splitter:B:38:0x0186] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x015b A[EDGE_INSN: B:53:0x015b->B:23:0x015b ?: BREAK  , SYNTHETIC] */
    static {
        /*
        // Method dump skipped, instructions count: 417
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.normsg.d.g.<clinit>():void");
    }

    private static String decodeString(String str) {
        AppMethodBeat.i(149092);
        String[] strArr = {MMApplicationContext.getContext().getFilesDir().getParent(), str, g.class.toString()};
        String sb = new StringBuilder(strArr[1].substring(strArr[0].length() + 1)).reverse().toString();
        AppMethodBeat.o(149092);
        return sb;
    }
}
