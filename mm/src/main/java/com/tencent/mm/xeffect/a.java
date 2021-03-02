package com.tencent.mm.xeffect;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a {
    public c Rxf = c.RxE;
    public float Rxg = 0.0f;
    public EnumC2175a Rxh = EnumC2175a.Rxj;
    public float[] Rxi = {0.0f};
    public String hDj = "";

    public a() {
        AppMethodBeat.i(236750);
        AppMethodBeat.o(236750);
    }

    /* renamed from: com.tencent.mm.xeffect.a$a  reason: collision with other inner class name */
    public enum EnumC2175a {
        Rxj,
        MeiweiLut,
        QingxinLut,
        XinxianLut,
        YouhuaLut,
        YuanqiLut;

        public static EnumC2175a valueOf(String str) {
            AppMethodBeat.i(236742);
            EnumC2175a aVar = (EnumC2175a) Enum.valueOf(EnumC2175a.class, str);
            AppMethodBeat.o(236742);
            return aVar;
        }

        static {
            AppMethodBeat.i(236743);
            AppMethodBeat.o(236743);
        }
    }

    public enum c {
        ACES_FILTER,
        LUT_FILTER,
        LUT_FILTER_FROM_FILE,
        BRIGHTEN_FILTER,
        AUTO_BALANCE_FILTER,
        HUE_SATURATION_FILTER,
        FACE_BEAUTY,
        RxE;

        public static c valueOf(String str) {
            AppMethodBeat.i(236748);
            c cVar = (c) Enum.valueOf(c.class, str);
            AppMethodBeat.o(236748);
            return cVar;
        }

        static {
            AppMethodBeat.i(236749);
            AppMethodBeat.o(236749);
        }
    }

    public enum b {
        SkinSmooth,
        EyeMorph,
        FaceMorph,
        SkinBright,
        EyeBright,
        Rxv;

        public static b valueOf(String str) {
            AppMethodBeat.i(236745);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(236745);
            return bVar;
        }

        static {
            AppMethodBeat.i(236746);
            AppMethodBeat.o(236746);
        }
    }
}
