package com.tencent.mm.plugin.ipcall.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class f {
    private static Map<Integer, List<Integer>> yoH = new HashMap();
    public int mAT = -1;

    public final boolean OZ(int i2) {
        AppMethodBeat.i(25359);
        if (Pa(i2)) {
            Log.i("MicroMsg.IPCallStateIndicator", "updateState, origin: %s, new: %s", stateToString(this.mAT), stateToString(i2));
            this.mAT = i2;
            AppMethodBeat.o(25359);
            return true;
        }
        Log.i("MicroMsg.IPCallStateIndicator", "transform state error, origin state: %s, new state: %s", stateToString(i.eaw().mAT), stateToString(i2));
        AppMethodBeat.o(25359);
        return false;
    }

    public final boolean eal() {
        return this.mAT == 1 || this.mAT == 3 || this.mAT == 4 || this.mAT == 5;
    }

    public final boolean eam() {
        return this.mAT == 4 || this.mAT == 5;
    }

    public final boolean ean() {
        return this.mAT == 5;
    }

    public final boolean eao() {
        return this.mAT == 5;
    }

    private boolean Pa(int i2) {
        AppMethodBeat.i(25360);
        if (this.mAT == -1) {
            AppMethodBeat.o(25360);
            return true;
        } else if (!yoH.containsKey(Integer.valueOf(this.mAT)) || !yoH.get(Integer.valueOf(this.mAT)).contains(Integer.valueOf(i2))) {
            AppMethodBeat.o(25360);
            return false;
        } else {
            AppMethodBeat.o(25360);
            return true;
        }
    }

    public static String stateToString(int i2) {
        AppMethodBeat.i(25361);
        switch (i2) {
            case -1:
                AppMethodBeat.o(25361);
                return "RESET_STATE";
            case 0:
            case 6:
            case 7:
            default:
                String valueOf = String.valueOf(i2);
                AppMethodBeat.o(25361);
                return valueOf;
            case 1:
                AppMethodBeat.o(25361);
                return "START_INVITE";
            case 2:
                AppMethodBeat.o(25361);
                return "INVITE_FAILED";
            case 3:
                AppMethodBeat.o(25361);
                return "INVITE_SUCCESS";
            case 4:
                AppMethodBeat.o(25361);
                return "RING_ING";
            case 5:
                AppMethodBeat.o(25361);
                return "USER_ACCEPT";
            case 8:
                AppMethodBeat.o(25361);
                return "USER_CANCEL";
            case 9:
                AppMethodBeat.o(25361);
                return "USER_SELF_SHUTDOWN";
            case 10:
                AppMethodBeat.o(25361);
                return "OTHER_SIDE_USER_SHUTDOWN";
            case 11:
                AppMethodBeat.o(25361);
                return "USER_SELF_SHUTDOWN_BY_ERR";
            case 12:
                AppMethodBeat.o(25361);
                return "CANCEL_BY_ERR";
        }
    }

    static {
        AppMethodBeat.i(25362);
        ArrayList arrayList = new ArrayList();
        arrayList.add(3);
        arrayList.add(2);
        arrayList.add(8);
        arrayList.add(12);
        yoH.put(1, arrayList);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(12);
        arrayList2.add(8);
        yoH.put(2, arrayList2);
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(4);
        arrayList3.add(5);
        arrayList3.add(8);
        arrayList3.add(12);
        yoH.put(3, arrayList3);
        ArrayList arrayList4 = new ArrayList();
        arrayList4.add(5);
        arrayList4.add(8);
        arrayList4.add(12);
        yoH.put(4, arrayList4);
        ArrayList arrayList5 = new ArrayList();
        arrayList5.add(9);
        arrayList5.add(10);
        arrayList5.add(11);
        yoH.put(5, arrayList5);
        AppMethodBeat.o(25362);
    }
}
