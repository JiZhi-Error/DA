package com.tencent.mm.model;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.a.g;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.List;

public class bo {
    private static bo iDZ;
    public b iDY;

    public interface b {
        void onNotify();
    }

    public static bo aVL() {
        AppMethodBeat.i(20376);
        synchronized (bo.class) {
            try {
                if (iDZ == null) {
                    iDZ = new bo();
                }
            } catch (Throwable th) {
                AppMethodBeat.o(20376);
                throw th;
            }
        }
        bo boVar = iDZ;
        AppMethodBeat.o(20376);
        return boVar;
    }

    private bo() {
    }

    public static bn aVM() {
        AppMethodBeat.i(20378);
        bg.aVF();
        SharedPreferences FQ = c.FQ("banner");
        if (FQ == null) {
            AppMethodBeat.o(20378);
            return null;
        }
        int i2 = FQ.getInt("CurrentType", -1);
        int i3 = FQ.getInt("CurrentShowType", -1);
        String string = FQ.getString("CurrentData", "");
        if (i2 != -1) {
            switch (i2) {
                case 1:
                    a aVN = aVN();
                    if (aVN == a.SUCC || aVN == a.SUCC_UNLOAD || g.aWT().aWR()) {
                        if (g.aWT().aWR()) {
                            Log.i("MicorMsg.MainFrameBannerStorage", "has abtest case. ignore bind bind contacts banner.");
                        } else {
                            Log.i("MicorMsg.MainFrameBannerStorage", "already Bind the Mobile");
                        }
                        AppMethodBeat.o(20378);
                        return null;
                    }
                case 2:
                    if (aVN() == a.SUCC || g.aWT().aWR()) {
                        if (g.aWT().aWR()) {
                            Log.i("MicorMsg.MainFrameBannerStorage", "has abtest case. ignore bind upload contacts banner.");
                        } else {
                            Log.i("MicorMsg.MainFrameBannerStorage", "already upload the contacts");
                        }
                        AppMethodBeat.o(20378);
                        return null;
                    }
                case 3:
                    Log.i("MicorMsg.MainFrameBannerStorage", "avatar already existed");
                    AppMethodBeat.o(20378);
                    return null;
                case 11:
                    AppMethodBeat.o(20378);
                    return null;
                case 10000:
                case 57005:
                    AppMethodBeat.o(20378);
                    return null;
            }
            bn bnVar = new bn(i2, i3, string);
            AppMethodBeat.o(20378);
            return bnVar;
        }
        AppMethodBeat.o(20378);
        return null;
    }

    public final void dn(int i2, int i3) {
        AppMethodBeat.i(20379);
        bg.aVF();
        SharedPreferences FQ = c.FQ("banner");
        if (FQ == null) {
            AppMethodBeat.o(20379);
            return;
        }
        SharedPreferences.Editor edit = FQ.edit();
        switch (i3) {
            case 1:
                edit.remove("CurrentType").remove("CurrentShowType").remove("CurrentData").commit();
                break;
            case 2:
                edit.remove("CurrentType").remove("CurrentShowType").remove("CurrentData").commit();
                List<Integer> Ko = Ko("HistoryInfo");
                if (!Ko.contains(Integer.valueOf(i2))) {
                    Ko.add(Integer.valueOf(i2));
                }
                c("HistoryInfo", Ko);
                break;
            case 3:
                if (i2 == 3) {
                    edit.remove("CurrentType").remove("CurrentShowType").remove("CurrentData").commit();
                    break;
                }
                break;
        }
        if (this.iDY != null) {
            this.iDY.onNotify();
        }
        AppMethodBeat.o(20379);
    }

    private static boolean clearAll() {
        AppMethodBeat.i(20380);
        bg.aVF();
        SharedPreferences FQ = c.FQ("banner");
        if (FQ == null || !FQ.edit().clear().commit()) {
            AppMethodBeat.o(20380);
            return false;
        }
        AppMethodBeat.o(20380);
        return true;
    }

    private static boolean b(bn bnVar) {
        AppMethodBeat.i(20381);
        boolean contains = Ko("HistoryInfo").contains(Integer.valueOf(bnVar.type));
        AppMethodBeat.o(20381);
        return contains;
    }

    private static boolean c(String str, List<Integer> list) {
        AppMethodBeat.i(20382);
        bg.aVF();
        SharedPreferences FQ = c.FQ("banner");
        if (FQ == null) {
            AppMethodBeat.o(20382);
            return false;
        }
        SharedPreferences.Editor edit = FQ.edit();
        edit.putInt(str + "ArraySize", list.size());
        for (int i2 = 0; i2 < list.size(); i2++) {
            edit.putInt(str + i2, list.get(i2).intValue());
        }
        boolean commit = edit.commit();
        AppMethodBeat.o(20382);
        return commit;
    }

    private static List<Integer> Ko(String str) {
        AppMethodBeat.i(20383);
        bg.aVF();
        SharedPreferences FQ = c.FQ("banner");
        if (FQ == null) {
            AppMethodBeat.o(20383);
            return null;
        }
        int i2 = FQ.getInt(str + "ArraySize", 0);
        ArrayList arrayList = new ArrayList(i2);
        for (int i3 = 0; i3 < i2; i3++) {
            arrayList.add(Integer.valueOf(FQ.getInt(str + i3, 0)));
        }
        AppMethodBeat.o(20383);
        return arrayList;
    }

    public enum a {
        NO_INIT,
        SET_MOBILE,
        SUCC,
        SUCC_UNLOAD;

        public static a valueOf(String str) {
            AppMethodBeat.i(20374);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(20374);
            return aVar;
        }

        static {
            AppMethodBeat.i(20375);
            AppMethodBeat.o(20375);
        }
    }

    public static a aVN() {
        AppMethodBeat.i(20384);
        try {
            bg.aVF();
            String str = (String) c.azQ().get(4097, "");
            bg.aVF();
            String str2 = (String) c.azQ().get(6, "");
            boolean aUI = z.aUI();
            Log.d("MicorMsg.MainFrameBannerStorage", "isUpload " + aUI + " stat " + z.aUc());
            if (str == null || str.length() <= 0) {
                str = null;
            }
            if (str2 == null || str2.length() <= 0) {
                str2 = null;
            }
            if (str == null && str2 == null) {
                a aVar = a.NO_INIT;
                AppMethodBeat.o(20384);
                return aVar;
            } else if (str != null && str2 == null) {
                a aVar2 = a.SET_MOBILE;
                AppMethodBeat.o(20384);
                return aVar2;
            } else if (aUI) {
                a aVar3 = a.SUCC;
                AppMethodBeat.o(20384);
                return aVar3;
            } else {
                a aVar4 = a.SUCC_UNLOAD;
                AppMethodBeat.o(20384);
                return aVar4;
            }
        } catch (Exception e2) {
            a aVar5 = a.NO_INIT;
            AppMethodBeat.o(20384);
            return aVar5;
        }
    }

    public final boolean a(bn bnVar) {
        boolean z = true;
        AppMethodBeat.i(20377);
        if (bnVar.type == 10000) {
            clearAll();
            if (this.iDY != null) {
                this.iDY.onNotify();
            }
            AppMethodBeat.o(20377);
            return true;
        } else if (bnVar.type == 57005) {
            AppMethodBeat.o(20377);
            return false;
        } else {
            bg.aVF();
            SharedPreferences FQ = c.FQ("banner");
            if (FQ == null) {
                AppMethodBeat.o(20377);
                return false;
            }
            SharedPreferences.Editor edit = FQ.edit();
            bn aVM = aVM();
            if (b(bnVar)) {
                z = false;
            }
            if (aVM != null && aVM.dDG == 2) {
                List<Integer> Ko = Ko("HistoryInfo");
                if (!Ko.contains(Integer.valueOf(aVM.type))) {
                    Ko.add(Integer.valueOf(aVM.type));
                }
                c("HistoryInfo", Ko);
            }
            if (z) {
                edit.putInt("CurrentType", bnVar.type).putInt("CurrentShowType", bnVar.dDG).putString("CurrentData", bnVar.data).commit();
            }
            if (this.iDY != null) {
                this.iDY.onNotify();
            }
            AppMethodBeat.o(20377);
            return z;
        }
    }
}
