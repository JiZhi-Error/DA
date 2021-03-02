package com.tencent.mm.wallet_core.c;

import android.text.TextUtils;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.k.g;
import com.tencent.mm.plugin.appbrand.jsapi.k.r;
import com.tencent.mm.plugin.appbrand.jsapi.p.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.thumbplayer.core.common.TPCodecParamers;
import java.util.ArrayList;

public final class ab {
    public static int IoV = 1;
    public static int IoW = 2;
    public static long Ruj = 0;

    public static void hht() {
        AppMethodBeat.i(72806);
        Ruj = System.currentTimeMillis();
        AppMethodBeat.o(72806);
    }

    public static int hhu() {
        AppMethodBeat.i(72807);
        int currentTimeMillis = (int) ((System.currentTimeMillis() - Ruj) / 1000);
        AppMethodBeat.o(72807);
        return currentTimeMillis;
    }

    public static void e(String str, String str2, String str3, int i2, String str4) {
        String str5;
        Exception e2;
        AppMethodBeat.i(72808);
        if (str3 == null || str3.length() <= 0) {
            AppMethodBeat.o(72808);
            return;
        }
        String str6 = null;
        try {
            if (Character.isDigit(str3.charAt(0))) {
                str5 = str3;
                for (int i3 = 0; i3 < str5.length(); i3++) {
                    try {
                        char charAt = str5.charAt(i3);
                        if (!Character.isDigit(charAt) && !".".equalsIgnoreCase(String.valueOf(charAt))) {
                            str6 = str5.substring(i3).trim();
                            str5 = str5.substring(0, i3 - 1).trim();
                        }
                    } catch (Exception e3) {
                        e2 = e3;
                        Log.e("MicroMsg.WalletReportUtil", "", e2);
                        h.INSTANCE.a(10756, str, str2, str5, str6, Integer.valueOf(i2), str4);
                        AppMethodBeat.o(72808);
                    }
                }
            } else {
                str5 = str3;
                for (int i4 = 0; i4 < str5.length(); i4++) {
                    char charAt2 = str5.charAt(i4);
                    if (Character.isDigit(charAt2) || ".".equalsIgnoreCase(String.valueOf(charAt2))) {
                        str6 = str5.substring(0, i4 - 1).trim();
                        str5 = str5.substring(i4).trim();
                    }
                }
            }
        } catch (Exception e4) {
            e2 = e4;
            str5 = str3;
            Log.e("MicroMsg.WalletReportUtil", "", e2);
            h.INSTANCE.a(10756, str, str2, str5, str6, Integer.valueOf(i2), str4);
            AppMethodBeat.o(72808);
        }
        h.INSTANCE.a(10756, str, str2, str5, str6, Integer.valueOf(i2), str4);
        AppMethodBeat.o(72808);
    }

    public static void mg(int i2, int i3) {
        AppMethodBeat.i(72809);
        h.INSTANCE.a(12097, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(System.currentTimeMillis()));
        AppMethodBeat.o(72809);
    }

    public static void a(int i2, int i3, int i4, int i5, long j2, int i6, String str) {
        boolean z;
        AppMethodBeat.i(72810);
        if (mh(i2, i3) || mi(i2, i3) || mj(i2, i3) || aqi(i2) || mk(i2, i3)) {
            Log.i("MicroMsg.WalletReportUtil", "reportIDKeyWalletPay the cmdType is for idkey report cmdType:" + i2 + " cmdid:" + i3);
            int i7 = -1;
            if (i6 == 4) {
                i7 = 132;
            } else if (i6 == 1) {
                i7 = TbsListener.ErrorCode.STARTDOWNLOAD_4;
            } else if (i6 == 2 || i6 == 36) {
                i7 = TPCodecParamers.TP_PROFILE_MPEG2_AAC_HE;
            } else if (i6 == 3) {
                i7 = 130;
            } else if (i6 == 5) {
                i7 = 153;
            } else if (i6 == 100) {
                i7 = 133;
            } else if (i6 == 6 || i6 == 1001) {
                i7 = 152;
            } else if (i6 == 11) {
                i7 = g.CTRL_INDEX;
            } else if (i6 == 21) {
                i7 = b.CTRL_INDEX;
            } else if (i6 == 31 || i6 == 33 || i6 == 32) {
                i7 = 118;
            } else if (i6 == 37) {
                i7 = 117;
            } else if (i6 == 39) {
                i7 = com.tencent.mm.plugin.appbrand.jsapi.af.g.CTRL_INDEX;
            }
            if (i7 == -1) {
                Log.e("MicroMsg.WalletReportUtil", "reportIDKeyWalletPay get ID by scene is -1, the scene is ".concat(String.valueOf(i6)));
                i7 = -1;
                if (i2 == 385 && i3 == 74) {
                    i7 = g.CTRL_INDEX;
                }
                if (i2 == 385 && i3 == 75) {
                    i7 = b.CTRL_INDEX;
                } else if (aqi(i2)) {
                    i7 = 117;
                } else if (mk(i2, i3)) {
                    i7 = 145;
                } else if (i2 == 397) {
                    i7 = TPCodecParamers.TP_PROFILE_MPEG2_AAC_HE;
                } else if (i2 == 398) {
                    i7 = 130;
                } else if (i2 == 422) {
                    i7 = 153;
                } else if (i2 == 556) {
                    i7 = 152;
                } else if (i2 == 498) {
                    i7 = 133;
                } else if (i2 == 1544 || i2 == 1582) {
                    i7 = 118;
                } else if (i2 == 1575) {
                    i7 = 117;
                }
            }
            if (i7 == -1) {
                Log.e("MicroMsg.WalletReportUtil", "reportIDKeyWalletPay the cmdType is for idkey report cmdType:" + i2 + " cmdid:" + i3 + " , ID is -1");
                i7 = -1;
                if (TextUtils.isEmpty(str)) {
                    i7 = -1;
                } else if (str.equals("BalanceFetchProcess")) {
                    i7 = b.CTRL_INDEX;
                } else if (str.equals("BalanceSaveProcess")) {
                    i7 = g.CTRL_INDEX;
                }
            }
            if (i7 == -1) {
                Log.e("MicroMsg.WalletReportUtil", "reportIDKeyWalletPay the processName is for idkey report processName:" + str + " , ID is -1");
                AppMethodBeat.o(72810);
                return;
            }
            IDKey iDKey = new IDKey();
            iDKey.SetID(i7);
            iDKey.SetValue(1);
            if (mh(i2, i3)) {
                iDKey.SetKey(26);
            } else if (mi(i2, i3)) {
                iDKey.SetKey(45);
            } else if (aqi(i2)) {
                if (i2 == 1581) {
                    iDKey.SetKey(64);
                } else {
                    iDKey.SetKey(83);
                }
            } else if (mk(i2, i3)) {
                if (i3 == 0) {
                    iDKey.SetKey(7);
                } else {
                    iDKey.SetKey(26);
                }
            } else if (mj(i2, i3)) {
                iDKey.SetKey(7);
            } else {
                Log.e("MicroMsg.WalletReportUtil", "reportIDKeyWalletPay the cmdType is for idkey report cmdType:" + i2 + " cmdid:" + i3 + " , ID is -1");
                AppMethodBeat.o(72810);
                return;
            }
            ArrayList<IDKey> arrayList = new ArrayList<>();
            IDKey iDKey2 = new IDKey();
            iDKey2.SetID(i7);
            iDKey2.SetValue(1);
            IDKey iDKey3 = new IDKey();
            iDKey3.SetID(i7);
            iDKey3.SetValue(1);
            IDKey iDKey4 = new IDKey();
            iDKey4.SetID(i7);
            iDKey4.SetValue((long) ((int) j2));
            if (mh(i2, i3)) {
                iDKey2.SetKey(19);
                if (j2 <= 1000) {
                    iDKey3.SetKey(20);
                    iDKey4.SetKey(23);
                } else if (j2 > 1000 && j2 <= 3000) {
                    iDKey3.SetKey(21);
                    iDKey4.SetKey(24);
                } else if (j2 > 3000) {
                    iDKey3.SetKey(22);
                    iDKey4.SetKey(25);
                }
            } else if (mi(i2, i3)) {
                iDKey2.SetKey(38);
                if (j2 <= 1000) {
                    iDKey3.SetKey(39);
                    iDKey4.SetKey(42);
                } else if (j2 > 1000 && j2 <= 3000) {
                    iDKey3.SetKey(40);
                    iDKey4.SetKey(43);
                } else if (j2 > 3000) {
                    iDKey3.SetKey(41);
                    iDKey4.SetKey(44);
                }
            } else if (i2 == 1581) {
                iDKey2.SetKey(57);
                if (j2 <= 1000) {
                    iDKey3.SetKey(58);
                    iDKey4.SetKey(61);
                } else if (j2 > 1000 && j2 <= 3000) {
                    iDKey3.SetKey(59);
                    iDKey4.SetKey(62);
                } else if (j2 > 3000) {
                    iDKey3.SetKey(60);
                    iDKey4.SetKey(63);
                }
            } else if (i2 == 1685) {
                iDKey2.SetKey(76);
                if (j2 <= 1000) {
                    iDKey3.SetKey(77);
                    iDKey4.SetKey(80);
                } else if (j2 > 1000 && j2 <= 3000) {
                    iDKey3.SetKey(78);
                    iDKey4.SetKey(81);
                } else if (j2 > 3000) {
                    iDKey3.SetKey(79);
                    iDKey4.SetKey(82);
                }
            } else if (i2 == 1558 && i3 == 0) {
                iDKey2.SetKey(0);
                if (j2 <= 1000) {
                    iDKey3.SetKey(1);
                    iDKey4.SetKey(4);
                } else if (j2 > 1000 && j2 <= 3000) {
                    iDKey3.SetKey(2);
                    iDKey4.SetKey(5);
                } else if (j2 > 3000) {
                    iDKey3.SetKey(3);
                    iDKey4.SetKey(6);
                }
            } else if (i2 == 1558 && i3 == 1) {
                iDKey2.SetKey(19);
                if (j2 <= 1000) {
                    iDKey3.SetKey(20);
                    iDKey4.SetKey(23);
                } else if (j2 > 1000 && j2 <= 3000) {
                    iDKey3.SetKey(21);
                    iDKey4.SetKey(24);
                } else if (j2 > 3000) {
                    iDKey3.SetKey(22);
                    iDKey4.SetKey(25);
                }
            } else {
                iDKey2.SetKey(0);
                if (j2 <= 1000) {
                    iDKey3.SetKey(1);
                    iDKey4.SetKey(4);
                } else if (j2 > 1000 && j2 <= 3000) {
                    iDKey3.SetKey(2);
                    iDKey4.SetKey(5);
                } else if (j2 > 3000) {
                    iDKey3.SetKey(3);
                    iDKey4.SetKey(6);
                }
            }
            arrayList.add(iDKey2);
            arrayList.add(iDKey3);
            arrayList.add(iDKey4);
            h.INSTANCE.b(arrayList, true);
            ArrayList<IDKey> arrayList2 = new ArrayList<>();
            if (!(i4 == 0 && i5 == 0)) {
                ArrayList arrayList3 = new ArrayList();
                IDKey iDKey5 = new IDKey();
                iDKey5.SetID(i7);
                iDKey5.SetValue(1);
                IDKey iDKey6 = new IDKey();
                iDKey6.SetID(i7);
                iDKey6.SetValue(1);
                if (mh(i2, i3)) {
                    iDKey5.SetKey(27);
                    if (i5 < 0) {
                        iDKey6.SetKey(28);
                    } else if (i5 > 0) {
                        iDKey6.SetKey(29);
                    }
                } else if (mi(i2, i3)) {
                    iDKey5.SetKey(46);
                    if (i5 < 0) {
                        iDKey6.SetKey(47);
                    } else if (i5 > 0) {
                        iDKey6.SetKey(48);
                    }
                } else if (i2 == 1581) {
                    iDKey5.SetKey(65);
                    if (i5 < 0) {
                        iDKey6.SetKey(66);
                    } else if (i5 > 0) {
                        iDKey6.SetKey(67);
                    }
                } else if (i2 == 1685) {
                    iDKey5.SetKey(84);
                    if (i5 < 0) {
                        iDKey6.SetKey(85);
                    } else if (i5 > 0) {
                        iDKey6.SetKey(86);
                    }
                } else if (i2 == 1558 && i3 == 0) {
                    iDKey5.SetKey(8);
                    if (i5 < 0) {
                        iDKey6.SetKey(9);
                    } else if (i5 > 0) {
                        iDKey6.SetKey(10);
                    }
                } else if (i2 == 1558 && i3 == 1) {
                    iDKey5.SetKey(27);
                    if (i5 < 0) {
                        iDKey6.SetKey(28);
                    } else if (i5 > 0) {
                        iDKey6.SetKey(29);
                    }
                } else {
                    iDKey5.SetKey(8);
                    if (i5 < 0) {
                        iDKey6.SetKey(9);
                    } else if (i5 > 0) {
                        iDKey6.SetKey(10);
                    }
                }
                arrayList3.add(iDKey5);
                arrayList3.add(iDKey6);
                arrayList2.addAll(arrayList3);
            }
            arrayList2.add(iDKey);
            h.INSTANCE.b(arrayList2, true);
            AppMethodBeat.o(72810);
            return;
        }
        if (i2 == 385 && i3 == 19) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            ArrayList<IDKey> arrayList4 = new ArrayList<>();
            IDKey iDKey7 = new IDKey();
            iDKey7.SetID(r.CTRL_INDEX);
            iDKey7.SetValue(1);
            iDKey7.SetKey(0);
            arrayList4.add(iDKey7);
            if (!(i4 == 0 && i5 == 0)) {
                IDKey iDKey8 = new IDKey();
                iDKey8.SetID(r.CTRL_INDEX);
                iDKey8.SetValue(1);
                iDKey8.SetKey(1);
                arrayList4.add(iDKey8);
            }
            h.INSTANCE.b(arrayList4, true);
            AppMethodBeat.o(72810);
            return;
        }
        AppMethodBeat.o(72810);
    }

    private static boolean mh(int i2, int i3) {
        return i2 == 385 && i3 == 112;
    }

    private static boolean mi(int i2, int i3) {
        return i2 == 385 && (i3 == 0 || i3 == 1 || i3 == 16);
    }

    private static boolean mj(int i2, int i3) {
        return i2 == 398 || (i2 == 385 && (i3 == 74 || i3 == 75)) || i2 == 1544 || i2 == 1582 || i2 == 498 || i2 == 397 || i2 == 1575 || i2 == 1639 || i2 == 556 || i2 == 422;
    }

    private static boolean aqi(int i2) {
        return i2 == 1581 || i2 == 1685;
    }

    private static boolean mk(int i2, int i3) {
        return i2 == 1558 && (i3 == 0 || i3 == 1);
    }
}
