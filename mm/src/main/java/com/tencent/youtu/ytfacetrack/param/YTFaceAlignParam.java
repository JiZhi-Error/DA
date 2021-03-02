package com.tencent.youtu.ytfacetrack.param;

public class YTFaceAlignParam {
    public int net_fix_config;
    public int refine_config;

    public static class NETFIXCONFIG {
        public static int FIX_EYE = 1;
        public static int FIX_EYEBROW = 2;
        public static int FIX_EYEBROW_MOUTH = 6;
        public static int FIX_EYE_EYEBROW = 3;
        public static int FIX_EYE_EYEBROW_MOUTH = 7;
        public static int FIX_EYE_MOUTH = 5;
        public static int FIX_MOUTH = 4;
        public static int FIX_NONE = 0;
    }

    public static class REFINE {
        public static int REFINE_CONFIG_ALL = 8198;
        public static int REFINE_CONFIG_EYEMOUTH = 8199;
        public static int REFINE_CONFIG_OFF = 8197;
    }
}
