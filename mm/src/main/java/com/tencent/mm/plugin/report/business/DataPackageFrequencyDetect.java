package com.tencent.mm.plugin.report.business;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.g.b.a.k;
import com.tencent.mm.network.af;
import com.tencent.mm.plugin.expt.h.d;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.vendor.Huawei;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003-./B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J\u001a\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J\u0006\u0010\u0014\u001a\u00020\nJ\u0006\u0010\u0015\u001a\u00020\nJ\u0006\u0010\u0016\u001a\u00020\nJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0018\u001a\u00020\u0007J0\u0010\u0019\u001a\u00020\u001a2\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u001cj\b\u0012\u0004\u0012\u00020\u0007`\u001d2\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u0007H\u0002J\u000e\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\"J@\u0010#\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\u00102\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u0004H\u0002JD\u0010#\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\u00102\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u001cj\b\u0012\u0004\u0012\u00020\u0007`\u001d2\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010+\u001a\u00020\u001aH\u0002J\u0006\u0010,\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u00060"}, hxF = {"Lcom/tencent/mm/plugin/report/business/DataPackageFrequencyDetect;", "Lcom/tencent/mm/network/MMPushCore$IDataPackageReporter;", "()V", "TAG", "", "dataPackageInfoList", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/report/business/DataPackageFrequencyDetect$DataPackageInfo;", "isScreenOff", "", "receiver", "Lcom/tencent/mm/plugin/report/business/DataPackageFrequencyDetect$Receiver;", "addNetReq", "", "type", "", "length", "addNetResp", "cgi", "canDataPackageFrequencyStatistics", "canStatisticsOtherStratagy", "dataPackageStatisticsOnlyHuawei", "formatTimeMillis", "timeMillis", "ifMatchHuaweiBatteryStratagy", "Lcom/tencent/mm/plugin/report/business/DataPackageFrequencyDetect$CheckResult;", "sortedTimeList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "maxInterval", "eachInterval", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "application", "Landroid/app/Application;", "reportDataFrequency", NativeProtocol.WEB_DIALOG_ACTION, "reqNum", "respNum", "dataStartTime", "dataEndTime", "reqContent", "respContent", "checkResult", "reportDataPackageFrequency", "CheckResult", "DataPackageInfo", "Receiver", "plugin-report_release"})
public final class DataPackageFrequencyDetect implements af.a {
    public static final DataPackageFrequencyDetect CxA = new DataPackageFrequencyDetect();
    private static final Receiver Cxy = new Receiver();
    private static final ConcurrentHashMap<Long, b> Cxz = new ConcurrentHashMap<>();
    private static final String TAG = TAG;
    private static boolean djZ;

    static {
        AppMethodBeat.i(224175);
        AppMethodBeat.o(224175);
    }

    private DataPackageFrequencyDetect() {
    }

    public final void d(Application application) {
        AppMethodBeat.i(224166);
        p.h(application, "application");
        if (MMApplicationContext.isPushProcess()) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            application.registerReceiver(Cxy, intentFilter);
            af.a(this);
        }
        AppMethodBeat.o(224166);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/report/business/DataPackageFrequencyDetect$Receiver;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "plugin-report_release"})
    public static final class Receiver extends BroadcastReceiver {
        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(224165);
            if (intent != null) {
                String action = intent.getAction();
                DataPackageFrequencyDetect dataPackageFrequencyDetect = DataPackageFrequencyDetect.CxA;
                String str = DataPackageFrequencyDetect.TAG;
                StringBuilder append = new StringBuilder("ACTION_SCREEN:").append(Util.nullAs(action, "")).append(" isScreenOff:");
                DataPackageFrequencyDetect dataPackageFrequencyDetect2 = DataPackageFrequencyDetect.CxA;
                StringBuilder append2 = append.append(DataPackageFrequencyDetect.djZ).append(" dataPackageInfoList:");
                DataPackageFrequencyDetect dataPackageFrequencyDetect3 = DataPackageFrequencyDetect.CxA;
                Log.i(str, append2.append(DataPackageFrequencyDetect.Cxz.size()).toString());
                DataPackageFrequencyDetect dataPackageFrequencyDetect4 = DataPackageFrequencyDetect.CxA;
                DataPackageFrequencyDetect.djZ = p.j("android.intent.action.SCREEN_OFF", action);
                DataPackageFrequencyDetect dataPackageFrequencyDetect5 = DataPackageFrequencyDetect.CxA;
                if (!DataPackageFrequencyDetect.djZ) {
                    try {
                        DataPackageFrequencyDetect dataPackageFrequencyDetect6 = DataPackageFrequencyDetect.CxA;
                        if (DataPackageFrequencyDetect.eOt()) {
                            DataPackageFrequencyDetect dataPackageFrequencyDetect7 = DataPackageFrequencyDetect.CxA;
                            boolean eOu = DataPackageFrequencyDetect.eOu();
                            if (!eOu || (eOu && Huawei.ifHUAWEI())) {
                                DataPackageFrequencyDetect dataPackageFrequencyDetect8 = DataPackageFrequencyDetect.CxA;
                                DataPackageFrequencyDetect.eOs();
                                AppMethodBeat.o(224165);
                                return;
                            }
                        }
                    } catch (Exception e2) {
                        DataPackageFrequencyDetect dataPackageFrequencyDetect9 = DataPackageFrequencyDetect.CxA;
                        Log.e(DataPackageFrequencyDetect.TAG, e2.getClass().getSimpleName() + ", " + e2.getMessage());
                    }
                }
                AppMethodBeat.o(224165);
                return;
            }
            AppMethodBeat.o(224165);
        }
    }

    @Override // com.tencent.mm.network.af.a
    public final void F(int i2, long j2) {
        AppMethodBeat.i(224167);
        if (djZ) {
            long currentTimeMillis = System.currentTimeMillis();
            Cxz.put(Long.valueOf(currentTimeMillis), new b(currentTimeMillis, true, i2, "", j2));
        }
        AppMethodBeat.o(224167);
    }

    @Override // com.tencent.mm.network.af.a
    public final void K(String str, long j2) {
        String str2;
        AppMethodBeat.i(224168);
        if (djZ) {
            long currentTimeMillis = System.currentTimeMillis();
            ConcurrentHashMap<Long, b> concurrentHashMap = Cxz;
            Long valueOf = Long.valueOf(currentTimeMillis);
            if (str == null) {
                str2 = "";
            } else {
                str2 = str;
            }
            concurrentHashMap.put(valueOf, new b(currentTimeMillis, false, -1, str2, j2));
        }
        AppMethodBeat.o(224168);
    }

    public static void eOs() {
        AppMethodBeat.i(224169);
        if (Cxz.size() <= 0) {
            AppMethodBeat.o(224169);
            return;
        }
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(Cxz);
        Cxz.clear();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : concurrentHashMap.entrySet()) {
            Log.d(TAG, String.valueOf(entry.getValue()));
            arrayList.add(entry.getKey());
        }
        j.sort(arrayList);
        a a2 = a(arrayList, 300000, 5000);
        if (a2.result) {
            a(1, arrayList, concurrentHashMap, a2);
            AppMethodBeat.o(224169);
            return;
        }
        a a3 = a(arrayList, Util.MILLSECONDS_OF_HOUR, Util.MILLSECONDS_OF_MINUTE);
        if (a3.result) {
            a(2, arrayList, concurrentHashMap, a3);
            AppMethodBeat.o(224169);
            return;
        }
        String b2 = d.cRY().b("clicfg_android_data_package_frequency_statistic_other_report_switch", "1", false, true);
        Log.d(TAG, "canStatisticsOtherStratagy() sw:%s", b2);
        if (Util.isEqual(b2, "1")) {
            Object obj = arrayList.get(0);
            p.g(obj, "timeList[0]");
            long longValue = ((Number) obj).longValue();
            Object obj2 = arrayList.get(arrayList.size() - 1);
            p.g(obj2, "timeList[timeList.size - 1]");
            a(3, arrayList, concurrentHashMap, new a(false, longValue, ((Number) obj2).longValue()));
        }
        AppMethodBeat.o(224169);
    }

    private static a a(ArrayList<Long> arrayList, long j2, long j3) {
        AppMethodBeat.i(224170);
        if (arrayList.size() < 2) {
            a aVar = new a(false, 0, 0);
            AppMethodBeat.o(224170);
            return aVar;
        }
        long longValue = arrayList.get(arrayList.size() - 1).longValue();
        Long l = arrayList.get(0);
        p.g(l, "sortedTimeList[0]");
        if (longValue - l.longValue() < j2) {
            a aVar2 = new a(false, 0, 0);
            AppMethodBeat.o(224170);
            return aVar2;
        }
        ArrayList arrayList2 = new ArrayList();
        int i2 = 0;
        long j4 = -1;
        for (T t : arrayList) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                j.hxH();
            }
            long longValue2 = t.longValue();
            if (j4 != -1 && longValue2 - j4 > j3) {
                arrayList2.add(Integer.valueOf(i2));
            }
            i2 = i3;
            j4 = longValue2;
        }
        if (arrayList2.size() == 0) {
            Long l2 = arrayList.get(0);
            p.g(l2, "sortedTimeList[0]");
            long longValue3 = l2.longValue();
            Long l3 = arrayList.get(arrayList.size() - 1);
            p.g(l3, "sortedTimeList[sortedTimeList.size - 1]");
            a aVar3 = new a(true, longValue3, l3.longValue());
            AppMethodBeat.o(224170);
            return aVar3;
        }
        Long l4 = arrayList.get(0);
        p.g(l4, "sortedTimeList[0]");
        long longValue4 = l4.longValue();
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            if (arrayList.get(num.intValue() - 1).longValue() - longValue4 >= j2) {
                Long l5 = arrayList.get(num.intValue() - 1);
                p.g(l5, "sortedTimeList[i - 1]");
                a aVar4 = new a(true, longValue4, l5.longValue());
                AppMethodBeat.o(224170);
                return aVar4;
            }
            p.g(num, "i");
            Long l6 = arrayList.get(num.intValue());
            p.g(l6, "sortedTimeList[i]");
            longValue4 = l6.longValue();
        }
        a aVar5 = new a(false, 0, 0);
        AppMethodBeat.o(224170);
        return aVar5;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\b\u0010\u0015\u001a\u00020\tH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/report/business/DataPackageFrequencyDetect$DataPackageInfo;", "", "time", "", "req", "", "type", "", "cgi", "", "length", "(JZILjava/lang/String;J)V", "getCgi", "()Ljava/lang/String;", "getLength", "()J", "getReq", "()Z", "getTime", "getType", "()I", "toString", "plugin-report_release"})
    public static final class b {
        final boolean CxB;
        final String cgi;
        private final long length;
        private final long time;
        final int type;

        public b(long j2, boolean z, int i2, String str, long j3) {
            p.h(str, "cgi");
            AppMethodBeat.i(224164);
            this.time = j2;
            this.CxB = z;
            this.type = i2;
            this.cgi = str;
            this.length = j3;
            AppMethodBeat.o(224164);
        }

        public final String toString() {
            AppMethodBeat.i(224163);
            StringBuilder sb = new StringBuilder("DataPackageInfo(time=");
            DataPackageFrequencyDetect dataPackageFrequencyDetect = DataPackageFrequencyDetect.CxA;
            Object Av = DataPackageFrequencyDetect.Av(this.time);
            if (Av == null) {
                Av = Long.valueOf(this.time);
            }
            String sb2 = sb.append(Av).append(", req=").append(this.CxB).append(", type=").append(this.type).append(", cgi='").append(this.cgi).append("', length=").append(this.length).append(')').toString();
            AppMethodBeat.o(224163);
            return sb2;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/report/business/DataPackageFrequencyDetect$CheckResult;", "", "result", "", "startTime", "", "endTime", "(ZJJ)V", "getEndTime", "()J", "getResult", "()Z", "getStartTime", "plugin-report_release"})
    public static final class a {
        final long endTime;
        final boolean result;
        final long startTime;

        public a(boolean z, long j2, long j3) {
            this.result = z;
            this.startTime = j2;
            this.endTime = j3;
        }
    }

    public static String Av(long j2) {
        AppMethodBeat.i(224172);
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date(j2));
        AppMethodBeat.o(224172);
        return format;
    }

    public static boolean eOt() {
        AppMethodBeat.i(224173);
        String b2 = d.cRY().b("clicfg_android_data_package_frequency_statistic_switch", "1", false, true);
        Log.d(TAG, "canDataPackageFrequencyStatistics() sw:%s", b2);
        boolean isEqual = Util.isEqual(b2, "1");
        AppMethodBeat.o(224173);
        return isEqual;
    }

    public static boolean eOu() {
        AppMethodBeat.i(224174);
        String b2 = d.cRY().b("clicfg_android_data_package_frequency_statistic_only_huawei_switch", AppEventsConstants.EVENT_PARAM_VALUE_NO, false, true);
        Log.d(TAG, "dataPackageStatisticsOnlyHuawei() sw:%s", b2);
        boolean isEqual = Util.isEqual(b2, "1");
        AppMethodBeat.o(224174);
        return isEqual;
    }

    private static void a(int i2, ArrayList<Long> arrayList, ConcurrentHashMap<Long, b> concurrentHashMap, a aVar) {
        AppMethodBeat.i(224171);
        int indexOf = arrayList.indexOf(Long.valueOf(aVar.startTime));
        int indexOf2 = arrayList.indexOf(Long.valueOf(aVar.endTime));
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        long j2 = 0;
        long j3 = 0;
        if (indexOf <= indexOf2) {
            while (true) {
                b bVar = concurrentHashMap.get(arrayList.get(indexOf));
                if (bVar != null) {
                    if (bVar.CxB) {
                        j2++;
                        int i3 = 0;
                        if (hashMap.containsKey(Integer.valueOf(bVar.type))) {
                            Object obj = hashMap.get(Integer.valueOf(bVar.type));
                            if (obj == null) {
                                p.hyc();
                            }
                            i3 = ((Number) obj).intValue();
                        }
                        hashMap.put(Integer.valueOf(bVar.type), Integer.valueOf(i3 + 1));
                    } else {
                        j3++;
                        int i4 = 0;
                        if (hashMap2.containsKey(bVar.cgi)) {
                            Object obj2 = hashMap2.get(bVar.cgi);
                            if (obj2 == null) {
                                p.hyc();
                            }
                            i4 = ((Number) obj2).intValue();
                        }
                        hashMap2.put(bVar.cgi, Integer.valueOf(i4 + 1));
                    }
                }
                if (indexOf == indexOf2) {
                    break;
                }
                indexOf++;
            }
        }
        StringBuilder sb = new StringBuilder();
        Set<Map.Entry> entrySet = hashMap.entrySet();
        p.g(entrySet, "reqMap.entries");
        for (Map.Entry entry : entrySet) {
            sb.append(new StringBuilder().append((Integer) entry.getKey()).append('_').append((Integer) entry.getValue()).append(';').toString());
        }
        StringBuilder sb2 = new StringBuilder();
        Set<Map.Entry> entrySet2 = hashMap2.entrySet();
        p.g(entrySet2, "respMap.entries");
        for (Map.Entry entry2 : entrySet2) {
            Object key = entry2.getKey();
            p.g(key, "it.key");
            sb2.append(n.oD((String) key, FilePathGenerator.ANDROID_DIR_SEP) + '_' + ((Integer) entry2.getValue()) + ';');
        }
        long j4 = aVar.startTime;
        long j5 = aVar.endTime;
        String sb3 = sb.toString();
        p.g(sb3, "reqContent.toString()");
        String sb4 = sb2.toString();
        p.g(sb4, "respContent.toString()");
        k kVar = new k();
        kVar.jB(i2);
        kVar.bM(j2);
        kVar.bN(j3);
        kVar.bO(j4);
        kVar.bP(j5);
        kVar.hN(sb3);
        kVar.hO(sb4);
        kVar.bQ(j2 + j3);
        kVar.bfK();
        Log.i(TAG, kVar.abW());
        AppMethodBeat.o(224171);
    }
}
