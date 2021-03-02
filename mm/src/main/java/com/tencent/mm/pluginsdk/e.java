package com.tencent.mm.pluginsdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.HashMap;

public final class e {

    public static final class b {
        public static int JSF = 15;
        public static int JSG = 5;
        public static int JSH = 5;
        public static int JSI = 3;
    }

    public static final class c {
        public static final HashMap<Integer, Integer> JSJ;

        static {
            AppMethodBeat.i(133667);
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            JSJ = hashMap;
            hashMap.put(22, 64);
            JSJ.put(9, 64);
            JSJ.put(3, 64);
            JSJ.put(23, 64);
            JSJ.put(25, 64);
            JSJ.put(13, 64);
            JSJ.put(29, 256);
            JSJ.put(34, 512);
            JSJ.put(6, 512);
            JSJ.put(35, 1024);
            JSJ.put(36, 4096);
            JSJ.put(37, 32768);
            JSJ.put(38, 32768);
            JSJ.put(42, 131072);
            JSJ.put(40, 65536);
            JSJ.put(41, 65536);
            JSJ.put(46, Integer.valueOf((int) TPMediaCodecProfileLevel.HEVCMainTierLevel52));
            JSJ.put(48, 524288);
            JSJ.put(51, 1048576);
            JSJ.put(52, Integer.valueOf((int) TPMediaCodecProfileLevel.HEVCHighTierLevel6));
            JSJ.put(54, 4194304);
            JSJ.put(56, Integer.valueOf((int) TPMediaCodecProfileLevel.HEVCHighTierLevel61));
            AppMethodBeat.o(133667);
        }
    }

    public static final class d {
        public static int bcV(String str) {
            AppMethodBeat.i(133668);
            if (str == null) {
                AppMethodBeat.o(133668);
                return 0;
            } else if ("EAN-13".equals(str) || "EAN_13".equals(str)) {
                AppMethodBeat.o(133668);
                return 4;
            } else if ("EAN-8".equals(str) || "EAN_8".equals(str)) {
                AppMethodBeat.o(133668);
                return 3;
            } else if ("EAN-2".equals(str)) {
                AppMethodBeat.o(133668);
                return 1;
            } else if ("EAN-5".equals(str)) {
                AppMethodBeat.o(133668);
                return 2;
            } else if ("UPC-A".equals(str) || "UPC_A".equals(str)) {
                AppMethodBeat.o(133668);
                return 5;
            } else if ("UPC-E".equals(str) || "UPC_E".equals(str)) {
                AppMethodBeat.o(133668);
                return 6;
            } else if ("CODE-39".equals(str) || "CODE_39".equals(str)) {
                AppMethodBeat.o(133668);
                return 9;
            } else if ("CODE-93".equals(str) || "CODE_93".equals(str)) {
                AppMethodBeat.o(133668);
                return 10;
            } else if ("CODE-128".equals(str) || "CODE_128".equals(str)) {
                AppMethodBeat.o(133668);
                return 11;
            } else if ("COMPOSITE".equals(str)) {
                AppMethodBeat.o(133668);
                return 12;
            } else if ("I/25".equals(str) || "ITF".equals(str)) {
                AppMethodBeat.o(133668);
                return 13;
            } else if ("DATABAR".equals(str)) {
                AppMethodBeat.o(133668);
                return 7;
            } else if ("DATABAR-EXP".equals(str)) {
                AppMethodBeat.o(133668);
                return 8;
            } else if ("RSS_14".equals(str)) {
                AppMethodBeat.o(133668);
                return 15;
            } else if ("RSS_EXPANDED".equals(str)) {
                AppMethodBeat.o(133668);
                return 16;
            } else if ("MAXICODE".equals(str)) {
                AppMethodBeat.o(133668);
                return 18;
            } else if ("PDF_417".equals(str)) {
                AppMethodBeat.o(133668);
                return 20;
            } else if ("QR_CODE".equals(str)) {
                AppMethodBeat.o(133668);
                return 19;
            } else if ("CODABAR".equals(str)) {
                AppMethodBeat.o(133668);
                return 17;
            } else if ("ISBN10".equals(str)) {
                AppMethodBeat.o(133668);
                return 14;
            } else if ("DATA_MATRIX".equals(str)) {
                AppMethodBeat.o(133668);
                return 21;
            } else if ("WX_CODE".equals(str)) {
                AppMethodBeat.o(133668);
                return 22;
            } else {
                AppMethodBeat.o(133668);
                return 0;
            }
        }

        public static boolean bcW(String str) {
            AppMethodBeat.i(133669);
            if ((Util.isNullOrNil(str) || !str.equals("QR_CODE")) && !str.equals("WX_CODE")) {
                AppMethodBeat.o(133669);
                return false;
            }
            AppMethodBeat.o(133669);
            return true;
        }

        public static boolean ahw(int i2) {
            if (i2 == 19 || i2 == 22) {
                return true;
            }
            return false;
        }
    }

    public static final class a {
        public static final HashMap<String, Long> JSE;

        public static Long bcU(String str) {
            AppMethodBeat.i(133665);
            if (str == null) {
                AppMethodBeat.o(133665);
                return null;
            }
            Long l = JSE.get(str.toLowerCase());
            AppMethodBeat.o(133665);
            return l;
        }

        static {
            AppMethodBeat.i(133666);
            HashMap<String, Long> hashMap = new HashMap<>();
            JSE = hashMap;
            hashMap.put("doc", 64L);
            JSE.put("docx", 128L);
            JSE.put("ppt", 256L);
            JSE.put("pptx", 512L);
            JSE.put("xls", 1024L);
            JSE.put("xlsx", 2048L);
            JSE.put("pdf", 4096L);
            JSE.put("1", 1L);
            JSE.put(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL, 2L);
            JSE.put("48", 4L);
            JSE.put("43", 8L);
            JSE.put("mp3", 16L);
            JSE.put("wav", 16L);
            JSE.put("wma", 16L);
            JSE.put("avi", 8L);
            JSE.put("rmvb", 8L);
            JSE.put("rm", 8L);
            JSE.put("mpg", 8L);
            JSE.put("mpeg", 8L);
            JSE.put("wmv", 8L);
            JSE.put("mp4", 8L);
            JSE.put("mkv", 8L);
            AppMethodBeat.o(133666);
        }
    }
}
