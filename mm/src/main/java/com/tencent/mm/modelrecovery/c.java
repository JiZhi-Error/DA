package com.tencent.mm.modelrecovery;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiInstallDownloadTask;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.recovery.ConstantsRecovery;
import com.tencent.recovery.model.RecoveryStatusItem;
import com.tencent.recovery.report.RecoveryReporter;
import com.tencent.wxmm.v2helper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class c {
    public static HashMap<String, Integer> jhL;

    public static void bey() {
        b bVar;
        AppMethodBeat.i(20594);
        List<RecoveryStatusItem> itemList = RecoveryReporter.getItemList(MMApplicationContext.getContext(), ConstantsRecovery.ReportType.ProcessStatus, RecoveryStatusItem.class);
        Log.i("MicroMsg.Recovery.WXRecoveryReporter", "reportStatus " + itemList.size());
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        for (RecoveryStatusItem recoveryStatusItem : itemList) {
            a aVar = hashMap.containsKey(recoveryStatusItem.processName) ? (a) hashMap.get(recoveryStatusItem.processName) : new a();
            if (hashMap2.containsKey(recoveryStatusItem.processName)) {
                bVar = (b) hashMap2.get(recoveryStatusItem.processName);
            } else {
                bVar = new b();
            }
            aVar.gAZ++;
            if (recoveryStatusItem.processStartFlag == 1) {
                aVar.jhO++;
            } else {
                aVar.jhP++;
            }
            boolean z = false;
            switch (recoveryStatusItem.processStage) {
                case 1:
                    if (recoveryStatusItem.processStartFlag == 1) {
                        bVar.jhR++;
                        switch (recoveryStatusItem.processStatus) {
                            case 4096:
                                bVar.jhZ++;
                                z = true;
                                break;
                            case 65536:
                            case 1048576:
                                bVar.jhV++;
                                z = true;
                                break;
                        }
                    } else {
                        bVar.jhS++;
                        switch (recoveryStatusItem.processStatus) {
                            case 4096:
                                bVar.jia++;
                                z = true;
                                break;
                            case 65536:
                            case 1048576:
                                bVar.jhW++;
                                z = true;
                                break;
                        }
                    }
                case 16:
                    if (recoveryStatusItem.processStartFlag == 1) {
                        bVar.jhT++;
                        switch (recoveryStatusItem.processStatus) {
                            case 4096:
                                bVar.jib++;
                                z = true;
                                break;
                            case 65536:
                            case 1048576:
                                bVar.jhX++;
                                z = true;
                                break;
                        }
                    } else {
                        bVar.jhU++;
                        switch (recoveryStatusItem.processStatus) {
                            case 4096:
                                bVar.jic++;
                                z = true;
                                break;
                            case 65536:
                            case 1048576:
                                bVar.jhY++;
                                z = true;
                                break;
                        }
                    }
            }
            if (!z) {
                Log.i("MicroMsg.Recovery.WXRecoveryReporter", "recovery statics not set exception");
            }
            hashMap.put(recoveryStatusItem.processName, aVar);
            hashMap2.put(recoveryStatusItem.processName, bVar);
        }
        b(hashMap);
        c(hashMap2);
        RecoveryReporter.clearReportFile(MMApplicationContext.getContext(), ConstantsRecovery.ReportType.ProcessStatus);
        AppMethodBeat.o(20594);
    }

    public static class a {
        public int gAZ;
        public int jhM;
        public int jhN;
        public int jhO;
        public int jhP;
        public int jhQ;

        public final String toString() {
            AppMethodBeat.i(20592);
            StringBuffer stringBuffer = new StringBuffer();
            if (this.gAZ > 0) {
                stringBuffer.append("totalCount:" + this.gAZ + " ");
            }
            if (this.jhM > 0) {
                stringBuffer.append("enterRecoveryCount:" + this.jhM + " ");
            }
            if (this.jhN > 0) {
                stringBuffer.append("existRecoveryProcessCount:" + this.jhN + " ");
            }
            if (this.jhO > 0) {
                stringBuffer.append("foregroundExpCount:" + this.jhO + " ");
            }
            if (this.jhP > 0) {
                stringBuffer.append("backgroundExpCount:" + this.jhP + " ");
            }
            if (this.jhQ > 0) {
                stringBuffer.append("normalCount:" + this.jhQ + " ");
            }
            String stringBuffer2 = stringBuffer.toString();
            AppMethodBeat.o(20592);
            return stringBuffer2;
        }
    }

    public static class b {
        public int jhR;
        public int jhS;
        public int jhT;
        public int jhU;
        public int jhV;
        public int jhW;
        public int jhX;
        public int jhY;
        public int jhZ;
        public int jia;
        public int jib;
        public int jic;

        public final String toString() {
            AppMethodBeat.i(20593);
            StringBuffer stringBuffer = new StringBuffer();
            if (this.jhR > 0) {
                stringBuffer.append("appForegroundExpCount:" + this.jhR + " ");
            }
            if (this.jhS > 0) {
                stringBuffer.append("appBackgroundExpCount:" + this.jhS + " ");
            }
            if (this.jhT > 0) {
                stringBuffer.append("componentForegroundExpCount:" + this.jhT + " ");
            }
            if (this.jhU > 0) {
                stringBuffer.append("componentBackgroundExpCount:" + this.jhU + " ");
            }
            if (this.jhV > 0) {
                stringBuffer.append("appForegroundCrashOrAnrExpCount:" + this.jhV + " ");
            }
            if (this.jhW > 0) {
                stringBuffer.append("appBackgroundCrashOrAnrExpCount:" + this.jhW + " ");
            }
            if (this.jhX > 0) {
                stringBuffer.append("componentForegroundCrashOrAnrExpCount:" + this.jhX + " ");
            }
            if (this.jhY > 0) {
                stringBuffer.append("componentBackgroundCrashOrAnrExpCount:" + this.jhY + " ");
            }
            if (this.jhZ > 0) {
                stringBuffer.append("appForegroundTimeoutExpCount:" + this.jhZ + " ");
            }
            if (this.jia > 0) {
                stringBuffer.append("appBackgroundTimeoutExpCount:" + this.jia + " ");
            }
            if (this.jib > 0) {
                stringBuffer.append("componentForegroundTimeoutExpCount:" + this.jib + " ");
            }
            if (this.jic > 0) {
                stringBuffer.append("componentBackgroundTimeoutExpCount:" + this.jic + " ");
            }
            String stringBuffer2 = stringBuffer.toString();
            AppMethodBeat.o(20593);
            return stringBuffer2;
        }
    }

    private static void b(HashMap<String, a> hashMap) {
        AppMethodBeat.i(20595);
        ArrayList<IDKey> arrayList = new ArrayList<>();
        for (Map.Entry<String, a> entry : hashMap.entrySet()) {
            if (jhL.containsKey(entry.getKey())) {
                int intValue = jhL.get(entry.getKey()).intValue();
                a value = entry.getValue();
                if (value.gAZ > 0) {
                    IDKey iDKey = new IDKey();
                    iDKey.SetID(v2helper.EMethodSetSpkEnhance);
                    iDKey.SetKey(intValue + 0);
                    iDKey.SetValue((long) value.gAZ);
                    arrayList.add(iDKey);
                }
                if (value.jhM > 0) {
                    IDKey iDKey2 = new IDKey();
                    iDKey2.SetID(v2helper.EMethodSetSpkEnhance);
                    iDKey2.SetKey(intValue + 1);
                    iDKey2.SetValue((long) value.jhM);
                    arrayList.add(iDKey2);
                }
                if (value.jhN > 0) {
                    IDKey iDKey3 = new IDKey();
                    iDKey3.SetID(v2helper.EMethodSetSpkEnhance);
                    iDKey3.SetKey(intValue + 2);
                    iDKey3.SetValue((long) value.jhN);
                    arrayList.add(iDKey3);
                }
                if (value.jhO > 0) {
                    IDKey iDKey4 = new IDKey();
                    iDKey4.SetID(v2helper.EMethodSetSpkEnhance);
                    iDKey4.SetKey(intValue + 3);
                    iDKey4.SetValue((long) value.jhO);
                    arrayList.add(iDKey4);
                }
                if (value.jhP > 0) {
                    IDKey iDKey5 = new IDKey();
                    iDKey5.SetID(v2helper.EMethodSetSpkEnhance);
                    iDKey5.SetKey(intValue + 4);
                    iDKey5.SetValue((long) value.jhP);
                    arrayList.add(iDKey5);
                }
                if (value.jhQ > 0) {
                    IDKey iDKey6 = new IDKey();
                    iDKey6.SetID(v2helper.EMethodSetSpkEnhance);
                    iDKey6.SetKey(intValue + 5);
                    iDKey6.SetValue((long) value.jhQ);
                    arrayList.add(iDKey6);
                }
            }
        }
        if (arrayList.size() > 0) {
            h.INSTANCE.b(arrayList, true);
        }
        Log.i("MicroMsg.Recovery.WXRecoveryReporter", "report recovery generalObj %s %s", MMApplicationContext.getProcessName(), hashMap.toString());
        AppMethodBeat.o(20595);
    }

    private static void c(HashMap<String, b> hashMap) {
        AppMethodBeat.i(20596);
        ArrayList<IDKey> arrayList = new ArrayList<>();
        for (Map.Entry<String, b> entry : hashMap.entrySet()) {
            if (jhL.containsKey(entry.getKey())) {
                int intValue = jhL.get(entry.getKey()).intValue();
                b value = entry.getValue();
                if (value.jhR > 0) {
                    IDKey iDKey = new IDKey();
                    iDKey.SetID(JsApiInstallDownloadTask.CTRL_INDEX);
                    iDKey.SetKey(intValue + 0);
                    iDKey.SetValue((long) value.jhR);
                    arrayList.add(iDKey);
                }
                if (value.jhS > 0) {
                    IDKey iDKey2 = new IDKey();
                    iDKey2.SetID(JsApiInstallDownloadTask.CTRL_INDEX);
                    iDKey2.SetKey(intValue + 1);
                    iDKey2.SetValue((long) value.jhS);
                    arrayList.add(iDKey2);
                }
                if (value.jhT > 0) {
                    IDKey iDKey3 = new IDKey();
                    iDKey3.SetID(JsApiInstallDownloadTask.CTRL_INDEX);
                    iDKey3.SetKey(intValue + 2);
                    iDKey3.SetValue((long) value.jhT);
                    arrayList.add(iDKey3);
                }
                if (value.jhU > 0) {
                    IDKey iDKey4 = new IDKey();
                    iDKey4.SetID(JsApiInstallDownloadTask.CTRL_INDEX);
                    iDKey4.SetKey(intValue + 3);
                    iDKey4.SetValue((long) value.jhU);
                    arrayList.add(iDKey4);
                }
                if (value.jhV > 0) {
                    IDKey iDKey5 = new IDKey();
                    iDKey5.SetID(JsApiInstallDownloadTask.CTRL_INDEX);
                    iDKey5.SetKey(intValue + 4);
                    iDKey5.SetValue((long) value.jhV);
                    arrayList.add(iDKey5);
                }
                if (value.jhW > 0) {
                    IDKey iDKey6 = new IDKey();
                    iDKey6.SetID(JsApiInstallDownloadTask.CTRL_INDEX);
                    iDKey6.SetKey(intValue + 5);
                    iDKey6.SetValue((long) value.jhW);
                    arrayList.add(iDKey6);
                }
                if (value.jhX > 0) {
                    IDKey iDKey7 = new IDKey();
                    iDKey7.SetID(JsApiInstallDownloadTask.CTRL_INDEX);
                    iDKey7.SetKey(intValue + 6);
                    iDKey7.SetValue((long) value.jhX);
                    arrayList.add(iDKey7);
                }
                if (value.jhY > 0) {
                    IDKey iDKey8 = new IDKey();
                    iDKey8.SetID(JsApiInstallDownloadTask.CTRL_INDEX);
                    iDKey8.SetKey(intValue + 7);
                    iDKey8.SetValue((long) value.jhY);
                    arrayList.add(iDKey8);
                }
                if (value.jhZ > 0) {
                    IDKey iDKey9 = new IDKey();
                    iDKey9.SetID(JsApiInstallDownloadTask.CTRL_INDEX);
                    iDKey9.SetKey(intValue + 8);
                    iDKey9.SetValue((long) value.jhZ);
                    arrayList.add(iDKey9);
                }
                if (value.jia > 0) {
                    IDKey iDKey10 = new IDKey();
                    iDKey10.SetID(JsApiInstallDownloadTask.CTRL_INDEX);
                    iDKey10.SetKey(intValue + 9);
                    iDKey10.SetValue((long) value.jia);
                    arrayList.add(iDKey10);
                }
                if (value.jib > 0) {
                    IDKey iDKey11 = new IDKey();
                    iDKey11.SetID(JsApiInstallDownloadTask.CTRL_INDEX);
                    iDKey11.SetKey(intValue + 10);
                    iDKey11.SetValue((long) value.jib);
                    arrayList.add(iDKey11);
                }
                if (value.jic > 0) {
                    IDKey iDKey12 = new IDKey();
                    iDKey12.SetID(JsApiInstallDownloadTask.CTRL_INDEX);
                    iDKey12.SetKey(intValue + 11);
                    iDKey12.SetValue((long) value.jic);
                    arrayList.add(iDKey12);
                }
            }
        }
        if (arrayList.size() > 0) {
            h.INSTANCE.b(arrayList, true);
        }
        Log.i("MicroMsg.Recovery.WXRecoveryReporter", "report recovery statusObj %s %s", MMApplicationContext.getProcessName(), hashMap.toString());
        AppMethodBeat.o(20596);
    }

    static {
        AppMethodBeat.i(20597);
        HashMap<String, Integer> hashMap = new HashMap<>();
        jhL = hashMap;
        hashMap.put(MMApplicationContext.getPackageName(), 0);
        jhL.put(MMApplicationContext.getPackageName() + ":push", 20);
        jhL.put(MMApplicationContext.getPackageName() + ":tools", 40);
        jhL.put(MMApplicationContext.getPackageName() + ":exdevice", 60);
        jhL.put(MMApplicationContext.getPackageName() + ":sandbox", 80);
        AppMethodBeat.o(20597);
    }
}
