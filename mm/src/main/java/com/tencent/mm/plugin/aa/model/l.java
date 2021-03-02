package com.tencent.mm.plugin.aa.model;

import com.google.android.gms.measurement.AppMeasurement;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.aa.model.cgi.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.ab;
import com.tencent.mm.protocal.protobuf.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.g;
import java.util.List;
import java.util.Map;

public final class l implements i {
    public static String jSJ = "title";
    public static String jSK = "totalPayAmount";
    public static String jSL = "totalUserNumber";
    public static String jSM = "perAmount";
    public static String jSN = "chatRoomName";
    public static String jSO = "launchScene";
    public static String jSP = "payerlist";
    public static String jSQ = AppMeasurement.Param.TIMESTAMP;
    public static String jSR = "pic_cdn_url";
    public static String jSS = "pic_cdn_thumb_url";
    public static String jST = "pf_order_no";
    private static int jSU = 131100026;
    private b jSE;
    private boolean jSV = false;
    private Map<String, Object> jSW;
    private int mode = 0;

    public final boolean d(int i2, Map<String, Object> map) {
        int i3;
        int i4;
        AppMethodBeat.i(63363);
        this.jSE = g.hdx();
        if (this.jSV) {
            Log.e("MicroMsg.LaunchAALogic", "launchAA, isLaunching!!! ignore it");
            this.jSE.ej(Boolean.FALSE);
            AppMethodBeat.o(63363);
            return false;
        } else if (map == null || map.size() == 0) {
            this.jSE.ej(Boolean.FALSE);
            AppMethodBeat.o(63363);
            return false;
        } else {
            Log.i("MicroMsg.LaunchAALogic", "launchAAByMoney, data.keySet: %s", map.keySet());
            this.jSV = true;
            this.jSW = map;
            this.mode = i2;
            if (i2 == a.jRI) {
                if (!this.jSW.containsKey(jSJ) || !this.jSW.containsKey(jSM) || !this.jSW.containsKey(jSL) || !this.jSW.containsKey(jSO) || !this.jSW.containsKey(jSN) || !this.jSW.containsKey(jSQ)) {
                    this.jSE.ej(Boolean.FALSE);
                    this.jSV = false;
                    AppMethodBeat.o(63363);
                    return false;
                }
                try {
                    long longValue = ((Long) this.jSW.get(jSM)).longValue();
                    int intValue = ((Integer) this.jSW.get(jSL)).intValue();
                    long longValue2 = ((Long) this.jSW.get(jSQ)).longValue();
                    Log.i("MicroMsg.LaunchAALogic", "launchAAByMoney");
                    com.tencent.mm.kernel.g.aAi();
                    com.tencent.mm.kernel.g.aAg().hqi.a(new f(longValue, (String) this.jSW.get(jSJ), intValue, ((Integer) this.jSW.get(jSO)).intValue(), longValue2, (String) this.jSW.get(jSN)), 0);
                    if (intValue > 0 && intValue <= 10) {
                        i4 = 13;
                    } else if (intValue > 10 && intValue <= 20) {
                        i4 = 14;
                    } else if (intValue <= 20 || intValue > 50) {
                        i4 = 16;
                    } else {
                        i4 = 15;
                    }
                    h.INSTANCE.idkeyStat(407, (long) i4, 1, false);
                    this.jSE.hdw();
                    AppMethodBeat.o(63363);
                    return true;
                } catch (Exception e2) {
                    Log.e("MicroMsg.LaunchAALogic", "launchAAByMoney, without specific user error: %s", e2.getMessage());
                    this.jSE.ej(Boolean.FALSE);
                    this.jSV = false;
                    AppMethodBeat.o(63363);
                    return false;
                }
            } else if (i2 != a.jRJ) {
                AppMethodBeat.o(63363);
                return false;
            } else if (!this.jSW.containsKey(jSJ) || !this.jSW.containsKey(jSM) || !this.jSW.containsKey(jSP) || !this.jSW.containsKey(jSO) || !this.jSW.containsKey(jSN) || !this.jSW.containsKey(jSQ)) {
                this.jSE.ej(Boolean.FALSE);
                this.jSV = false;
                AppMethodBeat.o(63363);
                return false;
            } else {
                try {
                    long longValue3 = ((Long) this.jSW.get(jSM)).longValue();
                    List list = (List) this.jSW.get(jSP);
                    long longValue4 = ((Long) this.jSW.get(jSQ)).longValue();
                    com.tencent.mm.kernel.g.aAi();
                    com.tencent.mm.kernel.g.aAg().hqi.a(new f(longValue3, (String) this.jSW.get(jSJ), list, ((Integer) this.jSW.get(jSO)).intValue(), longValue4, (String) this.jSW.get(jSN), (String) this.jSW.get(jSR), (String) this.jSW.get(jSS), (String) this.jSW.get(jST)), 0);
                    int size = list.size();
                    if (size > 0 && size <= 10) {
                        i3 = 13;
                    } else if (size > 10 && size <= 20) {
                        i3 = 14;
                    } else if (size <= 20 || size > 50) {
                        i3 = 16;
                    } else {
                        i3 = 15;
                    }
                    h.INSTANCE.idkeyStat(407, (long) i3, 1, false);
                    this.jSE.hdw();
                    AppMethodBeat.o(63363);
                    return true;
                } catch (Exception e3) {
                    Log.e("MicroMsg.LaunchAALogic", "launchAAByMoney, specific user error: %", e3.getMessage());
                    this.jSE.ej(Boolean.FALSE);
                    this.jSV = false;
                    AppMethodBeat.o(63363);
                    return false;
                }
            }
        }
    }

    public final boolean F(Map<String, Object> map) {
        int i2;
        AppMethodBeat.i(63364);
        this.jSE = g.hdx();
        Log.i("MicroMsg.LaunchAALogic", "launchAAByPerson");
        if (this.jSV) {
            Log.e("MicroMsg.LaunchAALogic", "launchAA, isLaunching!!! ignore it");
            this.jSE.ej(Boolean.FALSE);
            AppMethodBeat.o(63364);
            return false;
        } else if (map == null || map.size() == 0) {
            this.jSE.ej(Boolean.FALSE);
            AppMethodBeat.o(63364);
            return false;
        } else {
            this.jSV = true;
            this.jSW = map;
            this.mode = a.jRK;
            if (this.mode != a.jRK) {
                this.jSE.ej(Boolean.FALSE);
                AppMethodBeat.o(63364);
                return false;
            }
            if (this.jSW.containsKey(jSJ) && this.jSW.containsKey(jSK) && this.jSW.containsKey(jSP) && this.jSW.containsKey(jSO) && this.jSW.containsKey(jSN) && this.jSW.containsKey(jSQ)) {
                try {
                    long longValue = ((Long) this.jSW.get(jSK)).longValue();
                    List list = (List) this.jSW.get(jSP);
                    com.tencent.mm.kernel.g.aAi();
                    com.tencent.mm.kernel.g.aAg().hqi.a(new com.tencent.mm.plugin.aa.model.cgi.g((String) this.jSW.get(jSJ), longValue, list, ((Integer) this.jSW.get(jSO)).intValue(), (String) this.jSW.get(jSN), ((Long) this.jSW.get(jSQ)).longValue(), (String) this.jSW.get(jSR), (String) this.jSW.get(jSS), (String) this.jSW.get(jST)), 0);
                    int size = list.size();
                    if (size > 0 && size <= 10) {
                        i2 = 17;
                    } else if (size > 10 && size <= 20) {
                        i2 = 18;
                    } else if (size <= 20 || size > 50) {
                        i2 = 20;
                    } else {
                        i2 = 19;
                    }
                    h.INSTANCE.idkeyStat(407, (long) i2, 1, false);
                    this.jSE.hdw();
                    AppMethodBeat.o(63364);
                    return true;
                } catch (Exception e2) {
                    Log.e("MicroMsg.LaunchAALogic", "launchAAByPerson error: %s", e2.getMessage());
                }
            }
            this.jSE.ej(Boolean.FALSE);
            this.jSV = false;
            AppMethodBeat.o(63364);
            return false;
        }
    }

    public final boolean G(Map<String, Object> map) {
        AppMethodBeat.i(212943);
        this.jSE = g.hdx();
        Log.i("MicroMsg.LaunchAALogic", "launchAAByPersonCustomize");
        if (this.jSV) {
            Log.e("MicroMsg.LaunchAALogic", "launchAA, isLaunching!!! ignore it");
            this.jSE.ej(Boolean.FALSE);
            AppMethodBeat.o(212943);
            return false;
        } else if (map == null || map.size() == 0) {
            this.jSE.ej(Boolean.FALSE);
            AppMethodBeat.o(212943);
            return false;
        } else {
            this.jSV = true;
            this.jSW = map;
            this.mode = a.jRK;
            if (this.mode != a.jRK) {
                this.jSE.ej(Boolean.FALSE);
                AppMethodBeat.o(212943);
                return false;
            }
            if (!this.jSW.containsKey(jSJ) || !this.jSW.containsKey(jSO) || !this.jSW.containsKey(jSN) || !this.jSW.containsKey(jSQ)) {
                Log.i("MicroMsg.LaunchAALogic", "launchAAByPersonCustomize interrupt");
                this.jSE.ej(Boolean.FALSE);
                this.jSV = false;
            } else {
                try {
                    com.tencent.mm.kernel.g.aAi();
                    com.tencent.mm.kernel.g.aAg().hqi.a(new com.tencent.mm.plugin.aa.model.cgi.h((String) this.jSW.get(jSJ), ((Integer) this.jSW.get(jSO)).intValue(), (String) this.jSW.get(jSN), ((Long) this.jSW.get(jSQ)).longValue(), (String) this.jSW.get(jSR), (String) this.jSW.get(jSS), (String) this.jSW.get(jST)), 0);
                    this.jSE.hdw();
                    AppMethodBeat.o(212943);
                    return true;
                } catch (Exception e2) {
                    Log.e("MicroMsg.LaunchAALogic", "launchAAByPersonCustomize error: %s", e2.getMessage());
                    this.jSE.ej(Boolean.FALSE);
                    this.jSV = false;
                }
            }
            AppMethodBeat.o(212943);
            return false;
        }
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(63365);
        Log.i("MicroMsg.LaunchAALogic", "onSceneEnd, errType: %s, errCode: %s, scene: %s, mode: %s", Integer.valueOf(i2), Integer.valueOf(i3), qVar, Integer.valueOf(this.mode));
        if (qVar.getType() == 1624) {
            this.jSV = false;
            if (i2 == 0 && i3 == 0) {
                f fVar = (f) qVar;
                com.tencent.mm.protocal.protobuf.g gVar = fVar.jTf;
                Object[] objArr = new Object[4];
                objArr[0] = Integer.valueOf(gVar.dDN);
                objArr[1] = gVar.qwn;
                objArr[2] = Boolean.valueOf(gVar.KBu == null);
                objArr[3] = gVar.KBs;
                Log.i("MicroMsg.LaunchAALogic", "launchAAByMoney, onSceneEnd, retCode: %s, retmsg: %s, msgXml==null: %s, billNo: %s", objArr);
                if (gVar.dDN == 0) {
                    if (gVar.KBu != null) {
                        i.u(gVar.KBs, fVar.chatroomName, gVar.KBu);
                        g.a(this.jSE, Boolean.TRUE);
                    } else {
                        i.a(gVar.KBs, false, 0);
                        g.a(this.jSE, Boolean.TRUE);
                    }
                    i.SB(fVar.chatroomName);
                    h.INSTANCE.idkeyStat(407, 0, 1, false);
                    AppMethodBeat.o(63365);
                    return;
                }
                if (this.jSE != null) {
                    if (gVar.dDN > 0) {
                        ab abVar = gVar.KBD;
                        if (abVar != null && abVar.KCl > 0) {
                            this.jSE.ej(abVar);
                        } else if (gVar.KBE != null && gVar.KBE.cSx == 1 && !Util.isNullOrNil(gVar.KBE.qwt) && !Util.isNullOrNil(gVar.KBE.lHA) && !Util.isNullOrNil(gVar.KBE.lHB) && !Util.isNullOrNil(gVar.KBE.dQx)) {
                            this.jSE.ej(gVar.KBE);
                        } else if (!Util.isNullOrNil(gVar.qwn)) {
                            this.jSE.ej(gVar.qwn);
                        } else {
                            this.jSE.ej(Boolean.FALSE);
                        }
                    } else {
                        this.jSE.ej(Boolean.FALSE);
                    }
                }
                h.INSTANCE.idkeyStat(407, 2, 1, false);
                AppMethodBeat.o(63365);
                return;
            }
            if (this.jSE != null) {
                this.jSE.ej(Boolean.FALSE);
            }
            h.INSTANCE.idkeyStat(407, 1, 1, false);
            AppMethodBeat.o(63365);
        } else if (qVar.getType() == 1655) {
            this.jSV = false;
            if (i2 == 0 && i3 == 0) {
                com.tencent.mm.plugin.aa.model.cgi.g gVar2 = (com.tencent.mm.plugin.aa.model.cgi.g) qVar;
                k kVar = gVar2.jTh;
                Object[] objArr2 = new Object[3];
                objArr2[0] = Integer.valueOf(kVar.dDN);
                objArr2[1] = kVar.qwn;
                objArr2[2] = Boolean.valueOf(kVar.KBu == null);
                Log.i("MicroMsg.LaunchAALogic", "launchAAByPerson, onSceneEnd, retCode: %s, retmsg: %s, msgxml==null: %s", objArr2);
                Log.d("MicroMsg.LaunchAALogic", "launchAAByPerson, onSceneEnd, retMsg: %s, billNo: %s", kVar.qwn, kVar.KBs);
                if (kVar.dDN == 0) {
                    if (kVar.KBu != null) {
                        i.u(kVar.KBs, gVar2.chatroomName, kVar.KBu);
                        g.a(this.jSE, Boolean.TRUE, kVar.KBs);
                    } else {
                        i.a(kVar.KBs, false, 0);
                        g.a(this.jSE, Boolean.TRUE, kVar.KBs);
                    }
                    i.SB(gVar2.chatroomName);
                    h.INSTANCE.idkeyStat(407, 3, 1, false);
                    AppMethodBeat.o(63365);
                    return;
                }
                if (kVar.dDN > 0) {
                    ab abVar2 = kVar.KBD;
                    if (abVar2 != null && abVar2.KCl > 0) {
                        this.jSE.ej(abVar2);
                    } else if (kVar.KBE != null && kVar.KBE.cSx == 1 && !Util.isNullOrNil(kVar.KBE.qwt) && !Util.isNullOrNil(kVar.KBE.lHA) && !Util.isNullOrNil(kVar.KBE.lHB) && !Util.isNullOrNil(kVar.KBE.dQx)) {
                        this.jSE.ej(kVar.KBE);
                    } else if (!Util.isNullOrNil(kVar.qwn)) {
                        this.jSE.ej(kVar.qwn);
                    } else {
                        this.jSE.ej(Boolean.FALSE);
                    }
                } else {
                    this.jSE.ej(Boolean.FALSE);
                }
                h.INSTANCE.idkeyStat(407, 5, 1, false);
                AppMethodBeat.o(63365);
                return;
            }
            if (this.jSE != null) {
                this.jSE.ej(Boolean.FALSE);
            }
            h.INSTANCE.idkeyStat(407, 4, 1, false);
            AppMethodBeat.o(63365);
        } else {
            if (qVar.getType() == 2831) {
                this.jSV = false;
                if (i2 == 0 && i3 == 0) {
                    com.tencent.mm.plugin.aa.model.cgi.h hVar = (com.tencent.mm.plugin.aa.model.cgi.h) qVar;
                    com.tencent.mm.protocal.protobuf.i iVar = hVar.jTj;
                    Object[] objArr3 = new Object[3];
                    objArr3[0] = Integer.valueOf(iVar.dDN);
                    objArr3[1] = iVar.qwn;
                    objArr3[2] = Boolean.valueOf(iVar.KBu == null);
                    Log.i("MicroMsg.LaunchAALogic", "launchAAByPersonCustomize, onSceneEnd, retCode: %s, retmsg: %s, msgxml==null: %s", objArr3);
                    Log.i("MicroMsg.LaunchAALogic", "launchAAByPersonCustomize, onSceneEnd, retMsg: %s, billNo: %s", iVar.qwn, iVar.KBs);
                    if (iVar.dDN == 0) {
                        if (iVar.KBu != null) {
                            i.u(iVar.KBs, hVar.chatroomName, iVar.KBu);
                            g.a(this.jSE, Boolean.TRUE, iVar.KBs);
                        } else {
                            i.a(iVar.KBs, false, 0);
                            g.a(this.jSE, Boolean.TRUE, iVar.KBs);
                        }
                        i.SB(hVar.chatroomName);
                        h.INSTANCE.idkeyStat(407, 3, 1, false);
                        AppMethodBeat.o(63365);
                        return;
                    }
                    if (iVar.dDN > 0) {
                        ab abVar3 = iVar.KBD;
                        if (abVar3 != null && abVar3.KCl > 0) {
                            this.jSE.ej(abVar3);
                        } else if (iVar.KBE != null && iVar.KBE.cSx == 1 && !Util.isNullOrNil(iVar.KBE.qwt) && !Util.isNullOrNil(iVar.KBE.lHA) && !Util.isNullOrNil(iVar.KBE.lHB) && !Util.isNullOrNil(iVar.KBE.dQx)) {
                            this.jSE.ej(iVar.KBE);
                        } else if (!Util.isNullOrNil(iVar.qwn)) {
                            this.jSE.ej(iVar.qwn);
                        } else {
                            this.jSE.ej(Boolean.FALSE);
                        }
                    } else {
                        this.jSE.ej(Boolean.FALSE);
                    }
                    h.INSTANCE.idkeyStat(407, 5, 1, false);
                    AppMethodBeat.o(63365);
                    return;
                }
                if (this.jSE != null) {
                    this.jSE.ej(Boolean.FALSE);
                }
                h.INSTANCE.idkeyStat(407, 4, 1, false);
            }
            AppMethodBeat.o(63365);
        }
    }
}
