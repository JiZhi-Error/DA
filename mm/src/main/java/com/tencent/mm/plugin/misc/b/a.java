package com.tencent.mm.plugin.misc.b;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.support.v4.content.b;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.CellSignalStrengthCdma;
import android.telephony.CellSignalStrengthGsm;
import android.telephony.CellSignalStrengthLte;
import android.telephony.CellSignalStrengthWcdma;
import android.telephony.TelephonyManager;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a implements i, c, com.tencent.mm.kernel.b.c {
    private static volatile a zra;
    private Handler mHandler = new Handler();

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.plugin.misc.b.a$a  reason: collision with other inner class name */
    public static class C1477a {
        public String cellid;
        public String mcc;
        public boolean mjF;
        public String mnc;
        public String type;
        public String zrc;
        public int zrd;
    }

    public a() {
        AppMethodBeat.i(127606);
        AppMethodBeat.o(127606);
    }

    public static synchronized a eiW() {
        a aVar;
        synchronized (a.class) {
            AppMethodBeat.i(127607);
            if (zra == null) {
                zra = new a();
            }
            aVar = zra;
            AppMethodBeat.o(127607);
        }
        return aVar;
    }

    @Override // com.tencent.mm.kernel.api.c
    public final void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(127608);
        g.azz().a(-1, this);
        AppMethodBeat.o(127608);
    }

    @Override // com.tencent.mm.kernel.api.c
    public final void onAccountRelease() {
        AppMethodBeat.i(127609);
        g.azz().b(-1, this);
        AppMethodBeat.o(127609);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(final int i2, final int i3, String str, final q qVar) {
        AppMethodBeat.i(127610);
        if (str == null || !str.startsWith("autoauth_errmsg_")) {
            this.mHandler.post(new Runnable() {
                /* class com.tencent.mm.plugin.misc.b.a.AnonymousClass1 */

                public final void run() {
                    String uri;
                    AppMethodBeat.i(127605);
                    int type = qVar.getType();
                    boolean z = false;
                    s reqResp = qVar.getReqResp();
                    if (type == 1616 || type == 1518 || type == 385) {
                        z = true;
                    } else if (!(reqResp == null || (uri = reqResp.getUri()) == null || !uri.startsWith("/cgi-bin/mmpay-bin/"))) {
                        z = true;
                    }
                    if (z) {
                        a.an(i2, i3, type);
                    }
                    AppMethodBeat.o(127605);
                }
            });
            AppMethodBeat.o(127610);
            return;
        }
        AppMethodBeat.o(127610);
    }

    public static void an(int i2, int i3, int i4) {
        boolean z;
        C1477a aVar;
        int i5;
        AppMethodBeat.i(161885);
        try {
            if (!NetStatusUtil.isMobile(MMApplicationContext.getContext())) {
                AppMethodBeat.o(161885);
            } else if (b.checkSelfPermission(MMApplicationContext.getContext(), "android.permission.ACCESS_FINE_LOCATION") != 0) {
                AppMethodBeat.o(161885);
            } else {
                if (i2 == 0 && i3 == 0) {
                    z = true;
                } else {
                    z = false;
                }
                List<C1477a> gw = gw(MMApplicationContext.getContext());
                if (gw.size() == 0) {
                    AppMethodBeat.o(161885);
                    return;
                }
                C1477a aVar2 = gw.get(0);
                Iterator<C1477a> it = gw.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        aVar = aVar2;
                        break;
                    }
                    aVar = it.next();
                    if (aVar.mjF) {
                        break;
                    }
                }
                String str = aVar.mcc;
                String str2 = aVar.mnc;
                String str3 = aVar.zrc;
                String str4 = aVar.cellid;
                String str5 = aVar.type;
                int i6 = aVar.zrd;
                Log.i("MicroMsg.NetworkOptReport", "reportCellInfo mcc[%s] mnc[%s] lac[%s] cellid[%s] netType[%s] dbm[%d] type[%d] success[%s] errType[%d] errCode[%d] cmdid[%d] reportType[%d]", str, str2, str3, str4, str5, Integer.valueOf(i6), 1, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), 3);
                h hVar = h.INSTANCE;
                Object[] objArr = new Object[13];
                objArr[0] = str;
                objArr[1] = str2;
                objArr[2] = str3;
                objArr[3] = str4;
                objArr[4] = str5;
                objArr[5] = 1;
                if (z) {
                    i5 = 0;
                } else {
                    i5 = 1;
                }
                objArr[6] = Integer.valueOf(i5);
                objArr[7] = 0;
                objArr[8] = Integer.valueOf(i6);
                objArr[9] = Integer.valueOf(i2);
                objArr[10] = Integer.valueOf(i3);
                objArr[11] = Integer.valueOf(i4);
                objArr[12] = 3;
                hVar.a(15608, 3, h.u(objArr), false, false);
                AppMethodBeat.o(161885);
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.NetworkOptReport", "getNetType : %s", Util.stackTraceToString(e2));
            AppMethodBeat.o(161885);
        }
    }

    private static synchronized List<C1477a> gw(Context context) {
        LinkedList linkedList;
        int i2;
        synchronized (a.class) {
            AppMethodBeat.i(127612);
            linkedList = new LinkedList();
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            int i3 = Build.VERSION.SDK_INT;
            try {
                List<CellInfo> allCellInfo = telephonyManager.getAllCellInfo();
                if (allCellInfo != null) {
                    for (CellInfo cellInfo : allCellInfo) {
                        C1477a aVar = new C1477a();
                        if (cellInfo instanceof CellInfoGsm) {
                            CellSignalStrengthGsm cellSignalStrength = ((CellInfoGsm) cellInfo).getCellSignalStrength();
                            CellIdentityGsm cellIdentity = ((CellInfoGsm) cellInfo).getCellIdentity();
                            int mnc = cellIdentity.getMnc();
                            aVar.cellid = new StringBuilder().append(cellIdentity.getCid()).toString();
                            aVar.mcc = new StringBuilder().append(cellIdentity.getMcc()).toString();
                            aVar.mnc = new StringBuilder().append(cellIdentity.getMnc()).toString();
                            aVar.zrc = new StringBuilder().append(cellIdentity.getLac()).toString();
                            aVar.zrd = cellSignalStrength.getDbm();
                            aVar.mjF = cellInfo.isRegistered();
                            aVar.type = NetStatusUtil.CELL_GSM;
                            i2 = mnc;
                        } else if (cellInfo instanceof CellInfoCdma) {
                            CellSignalStrengthCdma cellSignalStrength2 = ((CellInfoCdma) cellInfo).getCellSignalStrength();
                            CellIdentityCdma cellIdentity2 = ((CellInfoCdma) cellInfo).getCellIdentity();
                            int systemId = cellIdentity2.getSystemId();
                            aVar.cellid = new StringBuilder().append(cellIdentity2.getBasestationId()).toString();
                            aVar.mnc = new StringBuilder().append(cellIdentity2.getSystemId()).toString();
                            aVar.zrc = new StringBuilder().append(cellIdentity2.getNetworkId()).toString();
                            aVar.zrd = cellSignalStrength2.getDbm();
                            aVar.mjF = cellInfo.isRegistered();
                            aVar.type = NetStatusUtil.CELL_CDMA;
                            i2 = systemId;
                        } else if (cellInfo instanceof CellInfoLte) {
                            CellSignalStrengthLte cellSignalStrength3 = ((CellInfoLte) cellInfo).getCellSignalStrength();
                            CellIdentityLte cellIdentity3 = ((CellInfoLte) cellInfo).getCellIdentity();
                            int mnc2 = cellIdentity3.getMnc();
                            aVar.cellid = new StringBuilder().append(cellIdentity3.getCi()).toString();
                            aVar.mcc = new StringBuilder().append(cellIdentity3.getMcc()).toString();
                            aVar.mnc = new StringBuilder().append(cellIdentity3.getMnc()).toString();
                            aVar.zrc = new StringBuilder().append(cellIdentity3.getTac()).toString();
                            aVar.zrd = cellSignalStrength3.getDbm();
                            aVar.mjF = cellInfo.isRegistered();
                            aVar.type = "lte";
                            i2 = mnc2;
                        } else if (i3 < 18 || !(cellInfo instanceof CellInfoWcdma)) {
                            Log.i("MicroMsg.NetworkOptReport", "Unknown type of cell signal!\n ClassName: " + cellInfo.getClass().getSimpleName() + "\n ToString: " + cellInfo.toString());
                            i2 = 0;
                        } else {
                            CellSignalStrengthWcdma cellSignalStrength4 = ((CellInfoWcdma) cellInfo).getCellSignalStrength();
                            CellIdentityWcdma cellIdentity4 = ((CellInfoWcdma) cellInfo).getCellIdentity();
                            int mnc3 = cellIdentity4.getMnc();
                            aVar.cellid = new StringBuilder().append(cellIdentity4.getCid()).toString();
                            aVar.mcc = new StringBuilder().append(cellIdentity4.getMcc()).toString();
                            aVar.mnc = new StringBuilder().append(cellIdentity4.getMnc()).toString();
                            aVar.zrc = new StringBuilder().append(cellIdentity4.getLac()).toString();
                            aVar.zrd = cellSignalStrength4.getDbm();
                            aVar.mjF = cellInfo.isRegistered();
                            aVar.type = "wcdma";
                            i2 = mnc3;
                        }
                        if (aVar.mnc.length() == 1) {
                            aVar.mnc = AppEventsConstants.EVENT_PARAM_VALUE_NO + aVar.mnc;
                        }
                        if (i2 != Integer.MAX_VALUE) {
                            linkedList.add(aVar);
                        }
                    }
                }
            } catch (Exception e2) {
                Log.e("MicroMsg.NetworkOptReport", "loadCellInfo: Unable to obtain cell signal information: ", e2);
            }
            AppMethodBeat.o(127612);
        }
        return linkedList;
    }
}
