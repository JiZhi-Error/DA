package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.graphics.Paint;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.c;
import com.tencent.mm.ag.k;
import com.tencent.mm.g.a.aae;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class f {
    private static int jYE = 1;
    private static int jYF = 2;
    private static int jYG = 3;
    private static int jYH = 4;

    public static class a {
        public int PeH;
        public int PeI = -1;
        public int PeJ = -1;
        public long PeK = -1;
        public int role = 3;

        public a(int i2, int i3, int i4) {
            this.PeH = i2;
            this.PeI = i3;
            this.PeJ = i4;
        }

        public a(int i2, long j2) {
            this.PeH = i2;
            this.PeK = j2;
        }

        public a() {
        }
    }

    public static a h(k.b bVar) {
        AppMethodBeat.i(34307);
        String aTY = z.aTY();
        if (bVar.iyA == 2 || bVar.iyA == 3 || bVar.iyA == 5) {
            if (!Util.isNullOrNil(bVar.iyE)) {
                for (String str : bVar.iyE) {
                    String[] split = str.split(",");
                    if (split.length == 4 && split[0].equals(aTY)) {
                        a aVar = new a(Util.getInt(split[1], -1), Util.getInt(split[2], -1), Util.getInt(split[3], -1));
                        AppMethodBeat.o(34307);
                        return aVar;
                    }
                }
            }
            if (!Util.isNullOrNil(bVar.iyG)) {
                for (String str2 : bVar.iyG) {
                    String[] split2 = str2.split(",");
                    if (split2.length == 3 && split2[0].equals(aTY)) {
                        a aVar2 = new a(Util.getInt(split2[2], -1), Util.getLong(split2[1], -1));
                        AppMethodBeat.o(34307);
                        return aVar2;
                    }
                }
            }
        }
        a aVar3 = new a();
        AppMethodBeat.o(34307);
        return aVar3;
    }

    private static a i(k.b bVar) {
        AppMethodBeat.i(232838);
        if ((bVar.iyA == 2 || bVar.iyA == 3 || bVar.iyA == 5) && !Util.isNullOrNil(bVar.iyE)) {
            for (String str : bVar.iyE) {
                String[] split = str.split(",");
                if (split.length == 4) {
                    a aVar = new a(Util.getInt(split[1], -1), Util.getInt(split[2], -1), Util.getInt(split[3], -1));
                    AppMethodBeat.o(232838);
                    return aVar;
                }
            }
        }
        a aVar2 = new a();
        AppMethodBeat.o(232838);
        return aVar2;
    }

    public static String a(k.b bVar, boolean z) {
        AppMethodBeat.i(34309);
        if (bVar == null || bVar.iyA <= 0) {
            Log.i("MicroMsg.C2CAppMsgUtil", "content == null || content.c2cNewAAType <= 0");
            if (z) {
                String str = bVar.iym;
                AppMethodBeat.o(34309);
                return str;
            }
            String str2 = bVar.iyn;
            AppMethodBeat.o(34309);
            return str2;
        }
        a h2 = h(bVar);
        String str3 = bVar.iyz;
        aae aae = new aae();
        aae.egS.egU = str3;
        EventCenter.instance.publish(aae);
        switch (bVar.iyA) {
            case 2:
            case 3:
                if (h2.role == 1 || z) {
                    if (h2.PeH <= 0 || h2.PeI < 0 || h2.PeJ < 0) {
                        String string = MMApplicationContext.getContext().getString(R.string.am);
                        AppMethodBeat.o(34309);
                        return string;
                    }
                    switch (h2.PeH) {
                        case 1:
                            String string2 = MMApplicationContext.getContext().getString(R.string.an);
                            AppMethodBeat.o(34309);
                            return string2;
                        case 2:
                            String string3 = MMApplicationContext.getContext().getString(R.string.ak, Integer.valueOf(h2.PeI - h2.PeJ));
                            AppMethodBeat.o(34309);
                            return string3;
                        case 3:
                            String string4 = MMApplicationContext.getContext().getString(R.string.ah);
                            AppMethodBeat.o(34309);
                            return string4;
                        case 4:
                            String string5 = MMApplicationContext.getContext().getString(R.string.am);
                            AppMethodBeat.o(34309);
                            return string5;
                    }
                } else if (h2.role == 2) {
                    if (h2.PeH <= 0 || h2.PeK < 0) {
                        String string6 = MMApplicationContext.getContext().getString(R.string.af);
                        AppMethodBeat.o(34309);
                        return string6;
                    }
                    switch (h2.PeH) {
                        case 1:
                            String string7 = MMApplicationContext.getContext().getString(R.string.ae, Float.valueOf(((float) h2.PeK) / 100.0f));
                            AppMethodBeat.o(34309);
                            return string7;
                        case 2:
                            String string8 = MMApplicationContext.getContext().getString(R.string.ad, Float.valueOf(((float) h2.PeK) / 100.0f));
                            AppMethodBeat.o(34309);
                            return string8;
                        case 3:
                            String string9 = MMApplicationContext.getContext().getString(R.string.ag, Float.valueOf(((float) h2.PeK) / 100.0f));
                            AppMethodBeat.o(34309);
                            return string9;
                        case 4:
                            String string10 = MMApplicationContext.getContext().getString(R.string.af);
                            AppMethodBeat.o(34309);
                            return string10;
                    }
                } else if (h2.role == 3) {
                    String string11 = MMApplicationContext.getContext().getString(R.string.af);
                    AppMethodBeat.o(34309);
                    return string11;
                } else {
                    String string12 = MMApplicationContext.getContext().getString(R.string.af);
                    AppMethodBeat.o(34309);
                    return string12;
                }
            case 5:
                if (h2.role == 1 || z) {
                    if (h2.PeH <= 0 || h2.PeI < 0 || h2.PeJ < 0) {
                        String string13 = MMApplicationContext.getContext().getString(R.string.am);
                        AppMethodBeat.o(34309);
                        return string13;
                    }
                    switch (h2.PeH) {
                        case 1:
                            String string14 = MMApplicationContext.getContext().getString(R.string.an);
                            AppMethodBeat.o(34309);
                            return string14;
                        case 2:
                            String string15 = MMApplicationContext.getContext().getString(R.string.al, Integer.valueOf(h2.PeI));
                            AppMethodBeat.o(34309);
                            return string15;
                        case 3:
                            String string16 = MMApplicationContext.getContext().getString(R.string.ah);
                            AppMethodBeat.o(34309);
                            return string16;
                        case 4:
                            String string17 = MMApplicationContext.getContext().getString(R.string.am);
                            AppMethodBeat.o(34309);
                            return string17;
                    }
                } else if (h2.role != 2) {
                    a i2 = i(bVar);
                    if (i2.PeH > 0) {
                        switch (i2.PeH) {
                            case 1:
                            case 2:
                            case 3:
                                String string18 = MMApplicationContext.getContext().getString(R.string.ai);
                                AppMethodBeat.o(34309);
                                return string18;
                            case 4:
                                String string19 = MMApplicationContext.getContext().getString(R.string.af);
                                AppMethodBeat.o(34309);
                                return string19;
                        }
                    } else {
                        String string20 = MMApplicationContext.getContext().getString(R.string.af);
                        AppMethodBeat.o(34309);
                        return string20;
                    }
                } else if (h2.PeH <= 0 || h2.PeK < 0) {
                    String string21 = MMApplicationContext.getContext().getString(R.string.af);
                    AppMethodBeat.o(34309);
                    return string21;
                } else {
                    switch (h2.PeH) {
                        case 1:
                            String string22 = MMApplicationContext.getContext().getString(R.string.ae, Float.valueOf(((float) h2.PeK) / 100.0f));
                            AppMethodBeat.o(34309);
                            return string22;
                        case 2:
                            String string23 = MMApplicationContext.getContext().getString(R.string.ad, Float.valueOf(((float) h2.PeK) / 100.0f));
                            AppMethodBeat.o(34309);
                            return string23;
                        case 3:
                            String string24 = MMApplicationContext.getContext().getString(R.string.ag, Float.valueOf(((float) h2.PeK) / 100.0f));
                            AppMethodBeat.o(34309);
                            return string24;
                        case 4:
                            String string25 = MMApplicationContext.getContext().getString(R.string.af);
                            AppMethodBeat.o(34309);
                            return string25;
                    }
                }
        }
        if (z) {
            String str4 = bVar.iym;
            AppMethodBeat.o(34309);
            return str4;
        }
        String str5 = bVar.iyn;
        AppMethodBeat.o(34309);
        return str5;
    }

    public static int b(k.b bVar, boolean z) {
        AppMethodBeat.i(34308);
        if (bVar == null || bVar.iyA <= 0) {
            Log.i("MicroMsg.C2CAppMsgUtil", "content == null || content.c2cNewAAType <= 0");
            AppMethodBeat.o(34308);
            return R.raw.c2c_aa_icon_close;
        }
        a h2 = h(bVar);
        switch (bVar.iyA) {
            case 2:
            case 3:
                if (h2.role == 1 || z) {
                    if (h2.PeH <= 0 || h2.PeI < 0 || h2.PeJ < 0) {
                        AppMethodBeat.o(34308);
                        return R.raw.c2c_aa_icon_close;
                    }
                    switch (h2.PeH) {
                        case 1:
                        case 2:
                            AppMethodBeat.o(34308);
                            return R.raw.c2c_aa_icon_default;
                        case 3:
                            AppMethodBeat.o(34308);
                            return R.raw.c2c_aa_icon_check;
                        case 4:
                            AppMethodBeat.o(34308);
                            return R.raw.c2c_aa_icon_close;
                    }
                } else if (h2.role == 2) {
                    if (h2.PeH <= 0 || h2.PeK < 0) {
                        AppMethodBeat.o(34308);
                        return R.raw.c2c_aa_icon_close;
                    }
                    switch (h2.PeH) {
                        case 1:
                            AppMethodBeat.o(34308);
                            return R.raw.c2c_aa_icon_default;
                        case 2:
                        case 3:
                            AppMethodBeat.o(34308);
                            return R.raw.c2c_aa_icon_check;
                        case 4:
                            AppMethodBeat.o(34308);
                            return R.raw.c2c_aa_icon_close;
                    }
                } else if (h2.role == 3) {
                    AppMethodBeat.o(34308);
                    return R.raw.c2c_aa_icon_close;
                } else {
                    AppMethodBeat.o(34308);
                    return R.raw.c2c_aa_icon_close;
                }
            case 5:
                if (h2.role == 1 || z) {
                    if (h2.PeH <= 0 || h2.PeI < 0 || h2.PeJ < 0) {
                        AppMethodBeat.o(34308);
                        return R.raw.c2c_aa_icon_close;
                    }
                    switch (h2.PeH) {
                        case 1:
                        case 2:
                            AppMethodBeat.o(34308);
                            return R.raw.c2c_aa_icon_default;
                        case 3:
                            AppMethodBeat.o(34308);
                            return R.raw.c2c_aa_icon_check;
                        case 4:
                            AppMethodBeat.o(34308);
                            return R.raw.c2c_aa_icon_close;
                    }
                } else if (h2.role != 2) {
                    a i2 = i(bVar);
                    if (i2.PeH > 0) {
                        switch (i2.PeH) {
                            case 1:
                            case 2:
                            case 3:
                                AppMethodBeat.o(34308);
                                return R.raw.c2c_aa_icon_default;
                            case 4:
                                AppMethodBeat.o(34308);
                                return R.raw.c2c_aa_icon_close;
                        }
                    } else {
                        AppMethodBeat.o(34308);
                        return R.raw.c2c_aa_icon_close;
                    }
                } else if (h2.PeH <= 0 || h2.PeK < 0) {
                    AppMethodBeat.o(34308);
                    return R.raw.c2c_aa_icon_close;
                } else {
                    switch (h2.PeH) {
                        case 1:
                            AppMethodBeat.o(34308);
                            return R.raw.c2c_aa_icon_default;
                        case 2:
                        case 3:
                            AppMethodBeat.o(34308);
                            return R.raw.c2c_aa_icon_check;
                        case 4:
                            AppMethodBeat.o(34308);
                            return R.raw.c2c_aa_icon_close;
                    }
                }
        }
        AppMethodBeat.o(34308);
        return R.raw.c2c_aa_icon_close;
    }

    public static int c(k.b bVar, boolean z) {
        AppMethodBeat.i(34311);
        if (bVar == null || bVar.iyA <= 0) {
            Log.i("MicroMsg.C2CAppMsgUtil", "content == null || content.c2cNewAAType <= 0");
            if (z) {
                AppMethodBeat.o(34311);
                return R.drawable.k;
            }
            AppMethodBeat.o(34311);
            return R.drawable.f3077i;
        }
        String str = bVar.iyz;
        aae aae = new aae();
        aae.egS.egU = str;
        EventCenter.instance.publish(aae);
        if (aae.egT.status == jYH && bVar.iyA == 5) {
            if (z) {
                AppMethodBeat.o(34311);
                return R.drawable.f3078j;
            }
            AppMethodBeat.o(34311);
            return R.drawable.f3076h;
        } else if (aae.egT.status != jYG && aae.egT.status != jYF && aae.egT.status != jYH) {
            a h2 = h(bVar);
            switch (bVar.iyA) {
                case 2:
                case 3:
                    if (h2.role == 1 || z) {
                        if (h2.PeH > 0 && h2.PeI >= 0 && h2.PeJ >= 0) {
                            switch (h2.PeH) {
                                case 1:
                                case 2:
                                    if (z) {
                                        AppMethodBeat.o(34311);
                                        return R.drawable.f3078j;
                                    }
                                    AppMethodBeat.o(34311);
                                    return R.drawable.f3076h;
                                case 3:
                                case 4:
                                    if (z) {
                                        AppMethodBeat.o(34311);
                                        return R.drawable.k;
                                    }
                                    AppMethodBeat.o(34311);
                                    return R.drawable.f3077i;
                            }
                        } else if (z) {
                            AppMethodBeat.o(34311);
                            return R.drawable.k;
                        } else {
                            AppMethodBeat.o(34311);
                            return R.drawable.f3077i;
                        }
                    } else if (h2.role == 2) {
                        if (h2.PeH > 0 && h2.PeK >= 0) {
                            switch (h2.PeH) {
                                case 1:
                                    if (z) {
                                        AppMethodBeat.o(34311);
                                        return R.drawable.f3078j;
                                    }
                                    AppMethodBeat.o(34311);
                                    return R.drawable.f3076h;
                                case 2:
                                case 3:
                                case 4:
                                    if (z) {
                                        AppMethodBeat.o(34311);
                                        return R.drawable.k;
                                    }
                                    AppMethodBeat.o(34311);
                                    return R.drawable.f3077i;
                            }
                        } else if (z) {
                            AppMethodBeat.o(34311);
                            return R.drawable.k;
                        } else {
                            AppMethodBeat.o(34311);
                            return R.drawable.f3077i;
                        }
                    } else if (h2.role == 3) {
                        if (z) {
                            AppMethodBeat.o(34311);
                            return R.drawable.k;
                        }
                        AppMethodBeat.o(34311);
                        return R.drawable.f3077i;
                    } else if (z) {
                        AppMethodBeat.o(34311);
                        return R.drawable.k;
                    } else {
                        AppMethodBeat.o(34311);
                        return R.drawable.f3077i;
                    }
                case 5:
                    if (h2.role == 1 || z) {
                        if (h2.PeH > 0 && h2.PeI >= 0 && h2.PeJ >= 0) {
                            switch (h2.PeH) {
                                case 1:
                                case 2:
                                    if (z) {
                                        AppMethodBeat.o(34311);
                                        return R.drawable.f3078j;
                                    }
                                    AppMethodBeat.o(34311);
                                    return R.drawable.f3076h;
                                case 3:
                                case 4:
                                    if (z) {
                                        AppMethodBeat.o(34311);
                                        return R.drawable.k;
                                    }
                                    AppMethodBeat.o(34311);
                                    return R.drawable.f3077i;
                            }
                        } else if (z) {
                            AppMethodBeat.o(34311);
                            return R.drawable.k;
                        } else {
                            AppMethodBeat.o(34311);
                            return R.drawable.f3077i;
                        }
                    } else if (h2.role != 2) {
                        a i2 = i(bVar);
                        if (i2.PeH > 0) {
                            switch (i2.PeH) {
                                case 1:
                                case 2:
                                case 3:
                                    if (z) {
                                        AppMethodBeat.o(34311);
                                        return R.drawable.f3078j;
                                    }
                                    AppMethodBeat.o(34311);
                                    return R.drawable.f3076h;
                                case 4:
                                    if (z) {
                                        AppMethodBeat.o(34311);
                                        return R.drawable.k;
                                    }
                                    AppMethodBeat.o(34311);
                                    return R.drawable.f3077i;
                            }
                        } else if (z) {
                            AppMethodBeat.o(34311);
                            return R.drawable.k;
                        } else {
                            AppMethodBeat.o(34311);
                            return R.drawable.f3077i;
                        }
                    } else if (h2.PeH > 0 && h2.PeK >= 0) {
                        switch (h2.PeH) {
                            case 1:
                                if (z) {
                                    AppMethodBeat.o(34311);
                                    return R.drawable.f3078j;
                                }
                                AppMethodBeat.o(34311);
                                return R.drawable.f3076h;
                            case 2:
                            case 3:
                            case 4:
                                if (z) {
                                    AppMethodBeat.o(34311);
                                    return R.drawable.k;
                                }
                                AppMethodBeat.o(34311);
                                return R.drawable.f3077i;
                        }
                    } else if (z) {
                        AppMethodBeat.o(34311);
                        return R.drawable.k;
                    } else {
                        AppMethodBeat.o(34311);
                        return R.drawable.f3077i;
                    }
            }
            if (z) {
                AppMethodBeat.o(34311);
                return R.drawable.k;
            }
            AppMethodBeat.o(34311);
            return R.drawable.f3077i;
        } else if (z) {
            AppMethodBeat.o(34311);
            return R.drawable.k;
        } else {
            AppMethodBeat.o(34311);
            return R.drawable.f3077i;
        }
    }

    public static int d(k.b bVar, boolean z) {
        AppMethodBeat.i(34312);
        if (bVar == null || bVar.iyA <= 0) {
            Log.i("MicroMsg.C2CAppMsgUtil", "content == null || content.c2cNewAAType <= 0");
            AppMethodBeat.o(34312);
            return -8868722;
        }
        String str = bVar.iyz;
        aae aae = new aae();
        aae.egS.egU = str;
        EventCenter.instance.publish(aae);
        if (aae.egT.status == jYH && bVar.iyA == 5) {
            AppMethodBeat.o(34312);
            return -12479656;
        } else if (aae.egT.status == jYG || aae.egT.status == jYF || aae.egT.status == jYH) {
            AppMethodBeat.o(34312);
            return -8868722;
        } else {
            a h2 = h(bVar);
            switch (bVar.iyA) {
                case 2:
                case 3:
                    if (h2.role == 1 || z) {
                        if (h2.PeH <= 0 || h2.PeI < 0 || h2.PeJ < 0) {
                            AppMethodBeat.o(34312);
                            return -8868722;
                        }
                        switch (h2.PeH) {
                            case 1:
                            case 2:
                                AppMethodBeat.o(34312);
                                return -12479656;
                            case 3:
                            case 4:
                                AppMethodBeat.o(34312);
                                return -8868722;
                        }
                    } else if (h2.role == 2) {
                        if (h2.PeH <= 0 || h2.PeK < 0) {
                            AppMethodBeat.o(34312);
                            return -8868722;
                        }
                        switch (h2.PeH) {
                            case 1:
                                AppMethodBeat.o(34312);
                                return -12479656;
                            case 2:
                            case 3:
                            case 4:
                                AppMethodBeat.o(34312);
                                return -8868722;
                        }
                    } else if (h2.role == 3) {
                        AppMethodBeat.o(34312);
                        return -8868722;
                    } else {
                        AppMethodBeat.o(34312);
                        return -8868722;
                    }
                case 5:
                    if (h2.role == 1 || z) {
                        if (h2.PeH <= 0 || h2.PeI < 0 || h2.PeJ < 0) {
                            AppMethodBeat.o(34312);
                            return -8868722;
                        }
                        switch (h2.PeH) {
                            case 1:
                            case 2:
                                AppMethodBeat.o(34312);
                                return -12479656;
                            case 3:
                            case 4:
                                AppMethodBeat.o(34312);
                                return -8868722;
                        }
                    } else if (h2.role != 2) {
                        a i2 = i(bVar);
                        if (i2.PeH > 0) {
                            switch (i2.PeH) {
                                case 1:
                                case 2:
                                case 3:
                                    AppMethodBeat.o(34312);
                                    return -12479656;
                                case 4:
                                    AppMethodBeat.o(34312);
                                    return -8868722;
                            }
                        } else {
                            AppMethodBeat.o(34312);
                            return -8868722;
                        }
                    } else if (h2.PeH <= 0 || h2.PeK < 0) {
                        AppMethodBeat.o(34312);
                        return -8868722;
                    } else {
                        switch (h2.PeH) {
                            case 1:
                                AppMethodBeat.o(34312);
                                return -12479656;
                            case 2:
                            case 3:
                            case 4:
                                AppMethodBeat.o(34312);
                                return -8868722;
                        }
                    }
            }
            AppMethodBeat.o(34312);
            return -8868722;
        }
    }

    public static float a(k.b bVar, boolean z, boolean z2) {
        AppMethodBeat.i(232839);
        if (bVar == null || bVar.iyA <= 0) {
            Log.i("MicroMsg.C2CAppMsgUtil", "content == null || content.c2cNewAAType <= 0");
            AppMethodBeat.o(232839);
            return 0.3f;
        }
        String str = bVar.iyz;
        aae aae = new aae();
        aae.egS.egU = str;
        EventCenter.instance.publish(aae);
        if (aae.egT.status == jYH && bVar.iyA == 5) {
            if (z2) {
                AppMethodBeat.o(232839);
                return 0.5f;
            }
            AppMethodBeat.o(232839);
            return 0.8f;
        } else if (aae.egT.status == jYG || aae.egT.status == jYF || aae.egT.status == jYH) {
            AppMethodBeat.o(232839);
            return 0.3f;
        } else {
            a h2 = h(bVar);
            switch (bVar.iyA) {
                case 2:
                case 3:
                    if (h2.role == 1 || z) {
                        if (h2.PeH <= 0 || h2.PeI < 0 || h2.PeJ < 0) {
                            AppMethodBeat.o(232839);
                            return 0.3f;
                        }
                        switch (h2.PeH) {
                            case 1:
                            case 2:
                                if (z2) {
                                    AppMethodBeat.o(232839);
                                    return 0.5f;
                                }
                                AppMethodBeat.o(232839);
                                return 0.8f;
                            case 3:
                            case 4:
                                AppMethodBeat.o(232839);
                                return 0.3f;
                        }
                    } else if (h2.role == 2) {
                        if (h2.PeH <= 0 || h2.PeK < 0) {
                            AppMethodBeat.o(232839);
                            return 0.3f;
                        }
                        switch (h2.PeH) {
                            case 1:
                                if (z2) {
                                    AppMethodBeat.o(232839);
                                    return 0.5f;
                                }
                                AppMethodBeat.o(232839);
                                return 0.8f;
                            case 2:
                            case 3:
                            case 4:
                                AppMethodBeat.o(232839);
                                return 0.3f;
                        }
                    } else if (h2.role == 3) {
                        AppMethodBeat.o(232839);
                        return 0.3f;
                    } else {
                        AppMethodBeat.o(232839);
                        return 0.3f;
                    }
                case 5:
                    if (h2.role == 1 || z) {
                        if (h2.PeH <= 0 || h2.PeI < 0 || h2.PeJ < 0) {
                            AppMethodBeat.o(232839);
                            return 0.3f;
                        }
                        switch (h2.PeH) {
                            case 1:
                            case 2:
                                if (z2) {
                                    AppMethodBeat.o(232839);
                                    return 0.5f;
                                }
                                AppMethodBeat.o(232839);
                                return 0.8f;
                            case 3:
                            case 4:
                                AppMethodBeat.o(232839);
                                return 0.3f;
                        }
                    } else if (h2.role != 2) {
                        a i2 = i(bVar);
                        if (i2.PeH > 0) {
                            switch (i2.PeH) {
                                case 1:
                                case 2:
                                case 3:
                                    if (z2) {
                                        AppMethodBeat.o(232839);
                                        return 0.5f;
                                    }
                                    AppMethodBeat.o(232839);
                                    return 0.8f;
                                case 4:
                                    AppMethodBeat.o(232839);
                                    return 0.3f;
                            }
                        } else {
                            AppMethodBeat.o(232839);
                            return 0.3f;
                        }
                    } else if (h2.PeH <= 0 || h2.PeK < 0) {
                        AppMethodBeat.o(232839);
                        return 0.3f;
                    } else {
                        switch (h2.PeH) {
                            case 1:
                                if (z2) {
                                    AppMethodBeat.o(232839);
                                    return 0.5f;
                                }
                                AppMethodBeat.o(232839);
                                return 0.8f;
                            case 2:
                            case 3:
                            case 4:
                                AppMethodBeat.o(232839);
                                return 0.3f;
                        }
                    }
            }
            AppMethodBeat.o(232839);
            return 0.3f;
        }
    }

    public static String a(int i2, int i3, int i4, boolean z, boolean z2, String str, k.b bVar, TextView textView) {
        AppMethodBeat.i(232840);
        Context context = MMApplicationContext.getContext();
        c cVar = (c) bVar.as(c.class);
        Log.d("MicroMsg.C2CAppMsgUtil", "getC2CLuckyMoneyDescByHbStatus() hbType:%s hbStatus:%s receiveStatus:%s isGroupChat:%s exclusiveRecvUsername: %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z2), cVar.iwa);
        if (i3 == 5) {
            String string = context.getString(R.string.eo7);
            AppMethodBeat.o(232840);
            return string;
        }
        if (i2 == 1) {
            if (i3 == 4) {
                if (i4 == 2) {
                    String string2 = context.getString(R.string.eo8);
                    AppMethodBeat.o(232840);
                    return string2;
                }
                String string3 = context.getString(R.string.eo3);
                AppMethodBeat.o(232840);
                return string3;
            } else if (i3 == 3) {
                if (i4 == 2) {
                    String string4 = context.getString(R.string.eo8);
                    AppMethodBeat.o(232840);
                    return string4;
                }
                AppMethodBeat.o(232840);
                return "";
            }
        } else if (i2 == 0) {
            if (i3 == 4) {
                if (z) {
                    String string5 = context.getString(R.string.eo3);
                    AppMethodBeat.o(232840);
                    return string5;
                } else if (!z2) {
                    String string6 = context.getString(R.string.eo8);
                    AppMethodBeat.o(232840);
                    return string6;
                } else if (i4 == 2) {
                    String string7 = context.getString(R.string.eo8);
                    AppMethodBeat.o(232840);
                    return string7;
                } else {
                    String string8 = context.getString(R.string.eo3);
                    AppMethodBeat.o(232840);
                    return string8;
                }
            } else if (i3 == 3) {
                if (z) {
                    AppMethodBeat.o(232840);
                    return "";
                } else if (i4 == 2) {
                    String string9 = context.getString(R.string.eo8);
                    AppMethodBeat.o(232840);
                    return string9;
                } else {
                    AppMethodBeat.o(232840);
                    return "";
                }
            }
        } else if (i2 == 3 && !Util.isNullOrNil(cVar.iwa)) {
            String displayName = aa.getDisplayName(cVar.iwa, str);
            if (i3 == 4) {
                String string10 = context.getString(R.string.eo6, displayName);
                AppMethodBeat.o(232840);
                return string10;
            }
            String string11 = context.getString(R.string.eo4, displayName);
            if (textView == null) {
                String str2 = string11 + context.getString(R.string.eo5);
                AppMethodBeat.o(232840);
                return str2;
            }
            int width = textView.getWidth();
            if (width <= 0) {
                width = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 150);
            }
            String a2 = a(string11, context.getString(R.string.eo5), "...", textView.getPaint(), width);
            AppMethodBeat.o(232840);
            return a2;
        } else if (!Util.isNullOrNil(cVar.iwa)) {
            String displayName2 = aa.getDisplayName(cVar.iwa, str);
            if (i3 == 4) {
                String string12 = context.getString(R.string.eo6, displayName2);
                AppMethodBeat.o(232840);
                return string12;
            }
            String string13 = context.getString(R.string.eo4, displayName2);
            if (textView == null) {
                String str3 = string13 + context.getString(R.string.eo5);
                AppMethodBeat.o(232840);
                return str3;
            }
            int width2 = textView.getWidth();
            if (width2 <= 0) {
                width2 = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 150);
            }
            String a3 = a(string13, context.getString(R.string.eo5), "...", textView.getPaint(), width2);
            AppMethodBeat.o(232840);
            return a3;
        } else if (i3 == 4) {
            if (!z2 || (z && i4 == 2)) {
                String string14 = context.getString(R.string.eo8);
                AppMethodBeat.o(232840);
                return string14;
            }
            String string15 = context.getString(R.string.eo3);
            AppMethodBeat.o(232840);
            return string15;
        } else if (i3 == 3) {
            if (i4 != 2) {
                AppMethodBeat.o(232840);
                return "";
            } else if (z) {
                AppMethodBeat.o(232840);
                return "";
            } else {
                String string16 = context.getString(R.string.eo8);
                AppMethodBeat.o(232840);
                return string16;
            }
        }
        AppMethodBeat.o(232840);
        return "";
    }

    private static String a(CharSequence charSequence, CharSequence charSequence2, String str, Paint paint, int i2) {
        AppMethodBeat.i(232841);
        String str2 = charSequence.toString() + charSequence2.toString();
        float measureText = paint.measureText(str2);
        if (i2 <= 0) {
            AppMethodBeat.o(232841);
        } else if (measureText < ((float) i2)) {
            AppMethodBeat.o(232841);
        } else {
            String str3 = str + ((Object) charSequence2);
            if (paint.measureText(str3) > ((float) i2)) {
                AppMethodBeat.o(232841);
            } else {
                str2 = ((Object) charSequence) + str3;
                float measureText2 = paint.measureText(str2);
                int i3 = 1;
                while (measureText2 > ((float) i2) && i3 < 100 && i3 < charSequence.length()) {
                    str2 = ((Object) charSequence.subSequence(0, charSequence.length() - i3)) + str3;
                    measureText2 = paint.measureText(str2);
                    i3++;
                }
                AppMethodBeat.o(232841);
            }
        }
        return str2;
    }

    public static int I(int i2, int i3, boolean z) {
        return i2 == 5 ? z ? R.drawable.ko : R.drawable.km : i2 == 4 ? !z ? R.drawable.km : R.drawable.ko : i2 == 3 ? i3 == 2 ? !z ? R.drawable.km : R.drawable.ko : z ? R.drawable.kn : R.drawable.kl : z ? R.drawable.kn : R.drawable.kl;
    }

    public static int J(int i2, int i3, boolean z) {
        if (i2 == 5 || i2 == 4) {
            return R.drawable.ceu;
        }
        if (i2 != 3) {
            return -1;
        }
        if (i3 != 2) {
            return -1;
        }
        if (z) {
            return -1;
        }
        return R.drawable.ceu;
    }

    public static int K(int i2, int i3, boolean z) {
        return i2 == 5 ? z ? R.drawable.ag2 : R.drawable.af8 : i2 == 4 ? !z ? R.drawable.af8 : R.drawable.ag2 : i2 == 3 ? i3 == 2 ? !z ? R.drawable.af8 : R.drawable.ag2 : z ? R.drawable.ag1 : R.drawable.af7 : z ? R.drawable.ag1 : R.drawable.af7;
    }
}
