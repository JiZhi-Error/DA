package com.tencent.midas.data;

import android.text.TextUtils;
import com.pay.http.APBaseHttpAns;
import com.pay.http.APNetworkManager;
import com.pay.http.IAPHttpAnsObserver;
import com.pay.tool.APMidasTools;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.api.APMidasPayAPI;
import com.tencent.midas.api.request.APMidasBaseRequest;
import com.tencent.midas.comm.APLog;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class APPluginReportManager {
    public static final String MIDASPLUGIN_ENTER_ABILITY = "sdk.plugin.enter.ability";
    public static final String MIDASPLUGIN_FORMAT_APKLOAD_ERROR = "sdk.loadapk_error";
    public static final String MIDASPLUGIN_FORMAT_APKLOAD_FAIL = "sdk.loadapk_fail";
    public static final String MIDASPLUGIN_FORMAT_TIME = "sdk.plugin.time";
    public static final String MIDASPLUGIN_LAUNCH_PURE_H5_ERROR_REASON = "sdk.plugin.pureH5.error.reason";
    public static final String MIDASPLUGIN_NAME_LAUNCH_ERROR = "sdk.plugin.launch.error";
    public static final String MIDASPLUGIN_TIMENAME_GET_FILELIST_FROM_ASSETS = "sdk.plugin.init.getFileListFromAssets.time";
    public static final String MIDASPLUGIN_TIMENAME_INIT = "timename.init";
    public static final String MIDASPLUGIN_TIMENAME_INIT_KERNEL = "sdk.plugin.init.kernel.totaltime";
    public static final String MIDASPLUGIN_TIMENAME_INIT_TOTALTIME = "sdk.plugin.init.totaltime";
    public static final String MIDASPLUGIN_TIMENAME_INSTALL_FROM_ASSETS = "sdk.plugin.init.installFromAssets.time";
    public static final String MIDASPLUGIN_TIMENAME_INSTALL_FROM_LOCAL = "sdk.plugin.init.installFromLocal.time";
    public static final String MIDASPLUGIN_TIMENAME_IS_NEED_ASSETS_UPDATE = "sdk.plugin.init.isNeedAssetsUpdate.time";
    public static final String MIDASPLUGIN_TIMENAME_IS_NEED_LOCAL_UPDATE = "sdk.plugin.init.isNeedLocalUpdate.time";
    public static final String MIDASPLUGIN_TIMENAME_LAUNCHABILITY = "timename.launchability";
    public static final String MIDASPLUGIN_TIMENAME_LAUNCHINFO = "timename.launchinfo";
    public static final String MIDASPLUGIN_TIMENAME_LAUNCHNET = "timename.launchnet";
    public static final String MIDASPLUGIN_TIMENAME_LAUNCHPAY = "timename.launchpay";
    public static final String MIDASPLUGIN_TIMENAME_LAUNCHPAY_WAIT_INIT = "sdk.plugin.launchPay.wait.init.time";
    public static final String MIDASPLUGIN_TIMENAME_LAUNCHWEB = "timename.launchweb";
    public static final String MIDASPLUGIN_TIMENAME_LOAD_DEX = "sdk.plugin.init.loadDex.time";
    public static final String MIDASPLUGIN_TIMENAME_PLUGIN_VALID = "sdk.plugin.init.pluginvalid.time";
    public static final String MIDASPLUGIN_TIMENAME_READ_FILE_FROM_ASSETS = "sdk.plugin.init.readFileFromAssets.time";
    public static final String MIDASPLUGIN_TIMENAME_UNZIP_SO = "sdk.plugin.init.unzip.so.time";
    public static final String MIDASPLUGIN_TIMENAME_WRITE_FILE_TO_DATA = "sdk.plugin.init.writeFileToData.time";
    public static final String MIDASPLUGIN_WEBPAGE_BACK = "sdk.plugin.webpage.back";
    public static final String MIDASPLUGIN_WEBPAGE_CLOSE = "sdk.plugin.webpage.close";
    public static final String MIDASPLUGIN_WEBPAGE_HEAD_INIT = "sdk.plugin.webpage.head.init";
    public static final String MIDASPLUGIN_WEBPAGE_INIT = "sdk.plugin.webpage.init";
    public static final String MIDASPLUGIN_WEBPAGE_KEYBACK = "sdk.plugin.webpage.keyback";
    public static final String MIDASPLUGIN_WEBPAGE_REFRESH = "sdk.plugin.webpage.refresh";
    public static final String MIDASPLUGIN_WEBPAGE_SYSTEM = "sdk.plugin.webpage.system";
    public static final String MIDASPLUGIN_WEBPAGE_WEBCLOSE = "sdk.plugin.webpage.webclose";
    public static final String MIDASPLUGIN_WEBPAGE_X5 = "sdk.plugin.webpage.x5";
    public static final String MIDASPLUGIN_WEBPAGE_X5_BACK = "sdk.plugin.webpage.x5.back";
    public static final String MIDASPLUGIN_WEBPAGE_X5_CLOSE = "sdk.plugin.webpage.x5.close";
    public static final String MIDASPLUGIN_WEBPAGE_X5_HEAD_INIT = "sdk.plugin.webpage.x5.head.init";
    public static final String MIDASPLUGIN_WEBPAGE_X5_KEYBACK = "sdk.plugin.webpage.x5.keyback";
    public static final String MIDASPLUGIN_WEBPAGE_X5_REFRESH = "sdk.plugin.webpage.x5.refresh";
    public static final String MIDASPLUGIN_X5_INIT = "sdk.plugin.x5.init";
    public static final String MIDASPLUGIN_X5_INIT_FAIL = "sdk.plugin.x5.init.fail";
    public static final String MIDASPLUGIN_X5_INIT_SUCCESS = "sdk.plugin.x5.init.success";
    private static APPluginReportManager gInstance = null;
    ArrayList<APClickStreamParams> initDataReport;
    ArrayList<APClickStreamParams> payDataReport;

    private APPluginReportManager() {
        AppMethodBeat.i(193003);
        this.initDataReport = null;
        this.payDataReport = null;
        this.initDataReport = new ArrayList<>();
        this.payDataReport = new ArrayList<>();
        AppMethodBeat.o(193003);
    }

    /* access modifiers changed from: package-private */
    public static class SingletonHolder {
        private static APPluginReportManager instance = new APPluginReportManager();

        private SingletonHolder() {
        }

        static {
            AppMethodBeat.i(193002);
            AppMethodBeat.o(193002);
        }
    }

    public static APPluginReportManager getInstance() {
        AppMethodBeat.i(193004);
        APPluginReportManager aPPluginReportManager = SingletonHolder.instance;
        AppMethodBeat.o(193004);
        return aPPluginReportManager;
    }

    public static void initDataRelease() {
        AppMethodBeat.i(193005);
        try {
            if (getInstance() != null) {
                getInstance().initDataReport.clear();
            }
            AppMethodBeat.o(193005);
        } catch (Exception e2) {
            AppMethodBeat.o(193005);
        }
    }

    public static void payDataRelease() {
        AppMethodBeat.i(193006);
        try {
            if (getInstance() != null) {
                getInstance().payDataReport.clear();
            }
            AppMethodBeat.o(193006);
        } catch (Exception e2) {
            AppMethodBeat.o(193006);
        }
    }

    public void initInterfaceInit(String str, APMidasBaseRequest aPMidasBaseRequest) {
        AppMethodBeat.i(193007);
        APInitData.init();
        APInitData.singleton().setInitGUID(APMidasTools.getUUID());
        APInitData.singleton().setInitInterfaceTime(System.currentTimeMillis());
        APPluginDataInterface.init();
        APPluginDataInterface.singleton().setLaunchInterface(str);
        APMidasAnalyzeParams.getInstance().AnalyzeParams(aPMidasBaseRequest);
        AppMethodBeat.o(193007);
    }

    public void payInterfaceInit(APMidasBaseRequest aPMidasBaseRequest, String str) {
        AppMethodBeat.i(193008);
        APPluginDataInterface.init();
        APPluginDataInterface.singleton().setLaunchInterface(str);
        APMultiProcessData aPMultiProcessData = new APMultiProcessData();
        aPMultiProcessData.setGuid(APMidasTools.getUUID());
        long currentTimeMillis = System.currentTimeMillis();
        APLog.i("showFirstPageInsertDB=====", "all:".concat(String.valueOf(currentTimeMillis)));
        aPMultiProcessData.setPayInterfaceTime(currentTimeMillis);
        if (APInitData.singleton().getInitInterfaceTime() < 1) {
            aPMultiProcessData.setIntervalTime(0);
        } else {
            aPMultiProcessData.setIntervalTime((int) (System.currentTimeMillis() - APInitData.singleton().getInitInterfaceTime()));
        }
        APPluginDataInterface.singleton().setProcessData(aPMultiProcessData);
        APMidasAnalyzeParams.getInstance().setSaveType(aPMidasBaseRequest);
        APMidasAnalyzeParams.getInstance().AnalyzeParams(aPMidasBaseRequest);
        AppMethodBeat.o(193008);
    }

    private StringBuffer reportParams2Str(APClickStreamParams aPClickStreamParams) {
        AppMethodBeat.i(193009);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("3=" + aPClickStreamParams.openid);
        stringBuffer.append("|7=0");
        stringBuffer.append("|13=" + aPClickStreamParams.dataId);
        stringBuffer.append("|24=" + aPClickStreamParams.offerid);
        if (!TextUtils.isEmpty(aPClickStreamParams.payid)) {
            stringBuffer.append("|4=" + aPClickStreamParams.payid);
        }
        if (!TextUtils.isEmpty(aPClickStreamParams.isBindQQ)) {
            stringBuffer.append("|55=" + aPClickStreamParams.isBindQQ);
        }
        stringBuffer.append("|21=" + aPClickStreamParams.format);
        stringBuffer.append("|26=" + aPClickStreamParams.pf);
        if (!TextUtils.isEmpty(aPClickStreamParams.token)) {
            stringBuffer.append("|56=" + aPClickStreamParams.token);
        }
        APLog.i("getLogRecord extend pre", aPClickStreamParams.extend);
        if (!TextUtils.isEmpty(aPClickStreamParams.extend)) {
            stringBuffer.append("|8=" + aPClickStreamParams.extend);
        }
        if (!TextUtils.isEmpty(aPClickStreamParams.from)) {
            stringBuffer.append("|20=" + aPClickStreamParams.from);
        }
        if (!TextUtils.isEmpty(aPClickStreamParams.savetype)) {
            stringBuffer.append("|47=" + aPClickStreamParams.savetype);
        }
        stringBuffer.append("|29=" + aPClickStreamParams.guid);
        stringBuffer.append("|31=" + aPClickStreamParams.device);
        stringBuffer.append("|38=" + aPClickStreamParams.currentTimeMillis);
        stringBuffer.append("|34=" + aPClickStreamParams.uinTypeFromSvr);
        stringBuffer.append("|35=" + aPClickStreamParams.uinFromSvr);
        stringBuffer.append("|37=" + aPClickStreamParams.SessionId);
        stringBuffer.append("|43=" + aPClickStreamParams.SessionType);
        if (!TextUtils.isEmpty(aPClickStreamParams.PayLevel)) {
            stringBuffer.append("|54=" + aPClickStreamParams.PayLevel);
        }
        if (!TextUtils.isEmpty(aPClickStreamParams.VipFlags)) {
            stringBuffer.append("|53=" + aPClickStreamParams.VipFlags);
        }
        AppMethodBeat.o(193009);
        return stringBuffer;
    }

    public void insertTimeData(String str, String str2) {
        AppMethodBeat.i(193010);
        APLog.i("insertTimeData interfaceName=", str);
        APLog.i("insertTimeData timeName=", str2);
        if (TextUtils.isEmpty(APPluginDataInterface.singleton().getOfferId())) {
            AppMethodBeat.o(193010);
        } else if (str == APMidasPluginInfo.LAUNCH_INTERFACE_INIT) {
            long currentTimeMillis = System.currentTimeMillis() - APInitData.singleton().getInitInterfaceTime();
            APLog.i("时耗", "insertTimeData timeName=" + str2 + ",initTime:" + currentTimeMillis);
            insertOneRecord(str, MIDASPLUGIN_FORMAT_TIME, "", constructTimeReport(str2, currentTimeMillis));
            AppMethodBeat.o(193010);
        } else {
            long j2 = 0;
            if (APPluginDataInterface.singleton().getProcessData() != null) {
                j2 = System.currentTimeMillis() - APPluginDataInterface.singleton().getProcessData().getPayInterfaceTime();
            }
            APLog.i("时耗", "insertTimeData timeName=" + str2 + ",payTime:" + j2);
            insertOneRecord(str, MIDASPLUGIN_FORMAT_TIME, "", constructTimeReport(str2, j2));
            AppMethodBeat.o(193010);
        }
    }

    public void insertTimeData(String str, String str2, long j2) {
        AppMethodBeat.i(193011);
        APLog.d("insertTimeData interfaceName=", str + " timeName=" + str2 + " time=" + String.valueOf(j2));
        if (TextUtils.isEmpty(APPluginDataInterface.singleton().getOfferId())) {
            AppMethodBeat.o(193011);
            return;
        }
        insertOneRecord(str, MIDASPLUGIN_FORMAT_TIME, "", constructTimeReport(str2, j2));
        AppMethodBeat.o(193011);
    }

    public void insertTimeDataEx(String str, String str2, long j2) {
        AppMethodBeat.i(193012);
        long timeInterval = APMidasTools.getTimeInterval(j2, System.currentTimeMillis());
        APLog.d("insertTimeDataEx", "timeName:" + str2 + ",time" + timeInterval);
        insertTimeData(str, str2, timeInterval);
        AppMethodBeat.o(193012);
    }

    public void insertData(String str, String str2, String str3, String str4) {
        AppMethodBeat.i(193013);
        APLog.i("insertTimeData interfaceName=", str + " format=" + str2 + " action=" + str3 + " extend=" + str4);
        insertOneRecord(str, str2, str3, str4);
        AppMethodBeat.o(193013);
    }

    private void insertOneRecord(String str, String str2, String str3, String str4) {
        AppMethodBeat.i(193014);
        APClickStreamParams aPClickStreamParams = new APClickStreamParams();
        aPClickStreamParams.device = "android_v" + APMidasPayAPI.getMidasPluginVersion();
        aPClickStreamParams.openid = APPluginDataInterface.singleton().getOpenId();
        aPClickStreamParams.format = str2;
        aPClickStreamParams.from = str3;
        aPClickStreamParams.offerid = APPluginDataInterface.singleton().getOfferId();
        aPClickStreamParams.pf = APPluginDataInterface.singleton().getPf();
        aPClickStreamParams.SessionId = APPluginDataInterface.singleton().getSessionId();
        aPClickStreamParams.SessionType = APPluginDataInterface.singleton().getSessionType();
        if (!TextUtils.isEmpty(str4)) {
            aPClickStreamParams.extend = APMidasTools.urlEncode(str4, 3);
        }
        switch (APPluginDataInterface.singleton().getSaveType()) {
            case 0:
                aPClickStreamParams.savetype = "game";
                break;
            case 1:
                aPClickStreamParams.savetype = "goods";
                break;
            case 2:
            case 3:
                aPClickStreamParams.savetype = "acct";
                break;
            case 4:
                aPClickStreamParams.savetype = "month";
                break;
            case 5:
                aPClickStreamParams.savetype = "subscribe";
                break;
            default:
                aPClickStreamParams.savetype = "game";
                break;
        }
        aPClickStreamParams.currentTimeMillis = String.valueOf(System.currentTimeMillis());
        if (str.equals(APMidasPluginInfo.LAUNCH_INTERFACE_INIT)) {
            APInitData.singleton();
            aPClickStreamParams.dataId = APInitData.getInitdataCount();
            aPClickStreamParams.VipFlags = APInitData.singleton().getInitGUID();
            this.initDataReport.add(aPClickStreamParams);
            AppMethodBeat.o(193014);
            return;
        }
        aPClickStreamParams.dataId = APDataId.getDataId();
        APMultiProcessData processData = APPluginDataInterface.singleton().getProcessData();
        if (processData != null) {
            aPClickStreamParams.VipFlags = processData.getGuid();
        }
        this.payDataReport.add(aPClickStreamParams);
        AppMethodBeat.o(193014);
    }

    private String getAllReportRecord(ArrayList<APClickStreamParams> arrayList) {
        AppMethodBeat.i(193015);
        int size = arrayList.size();
        if (size <= 0) {
            AppMethodBeat.o(193015);
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2++;
            stringBuffer.append("record" + i3 + "=");
            stringBuffer.append(reportParams2Str(arrayList.get(i3)));
            stringBuffer.append("&");
        }
        if (stringBuffer.length() > 0) {
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("num=");
        stringBuffer2.append(i2);
        stringBuffer2.append("&");
        stringBuffer2.append(stringBuffer.toString());
        stringBuffer.setLength(0);
        String stringBuffer3 = stringBuffer2.toString();
        AppMethodBeat.o(193015);
        return stringBuffer3;
    }

    public void reportImmediatelyOneRecord(String str, String str2, String str3) {
        AppMethodBeat.i(193016);
        APClickStreamParams aPClickStreamParams = new APClickStreamParams();
        aPClickStreamParams.device = "android_v" + APMidasPayAPI.getMidasPluginVersion();
        aPClickStreamParams.openid = APPluginDataInterface.singleton().getOpenId();
        aPClickStreamParams.format = str2;
        aPClickStreamParams.from = "";
        aPClickStreamParams.offerid = APPluginDataInterface.singleton().getOfferId();
        aPClickStreamParams.pf = APPluginDataInterface.singleton().getPf();
        aPClickStreamParams.SessionId = APPluginDataInterface.singleton().getSessionId();
        aPClickStreamParams.SessionType = APPluginDataInterface.singleton().getSessionType();
        if (!TextUtils.isEmpty(str3)) {
            aPClickStreamParams.extend = APMidasTools.urlEncode(str3, 3);
        }
        switch (APPluginDataInterface.singleton().getSaveType()) {
            case 0:
                aPClickStreamParams.savetype = "game";
                break;
            case 1:
                aPClickStreamParams.savetype = "goods";
                break;
            case 2:
            case 3:
                aPClickStreamParams.savetype = "acct";
                break;
            case 4:
                aPClickStreamParams.savetype = "month";
                break;
            case 5:
                aPClickStreamParams.savetype = "subscribe";
                break;
            default:
                aPClickStreamParams.savetype = "game";
                break;
        }
        aPClickStreamParams.currentTimeMillis = String.valueOf(System.currentTimeMillis());
        if (str.equals(APMidasPluginInfo.LAUNCH_INTERFACE_INIT)) {
            APInitData.singleton();
            aPClickStreamParams.dataId = APInitData.getInitdataCount();
            aPClickStreamParams.VipFlags = APInitData.singleton().getInitGUID();
        } else {
            aPClickStreamParams.dataId = APDataId.getDataId();
            APMultiProcessData processData = APPluginDataInterface.singleton().getProcessData();
            if (processData != null) {
                aPClickStreamParams.VipFlags = processData.getGuid();
            }
        }
        ArrayList<APClickStreamParams> arrayList = new ArrayList<>();
        arrayList.add(aPClickStreamParams);
        String allReportRecord = getAllReportRecord(arrayList);
        if (TextUtils.isEmpty(allReportRecord)) {
            AppMethodBeat.o(193016);
            return;
        }
        APNetworkManager.getInstance().dataReport(allReportRecord, new IAPHttpAnsObserver() {
            /* class com.tencent.midas.data.APPluginReportManager.AnonymousClass1 */

            @Override // com.pay.http.IAPHttpAnsObserver
            public void onStop(APBaseHttpAns aPBaseHttpAns) {
            }

            @Override // com.pay.http.IAPHttpAnsObserver
            public void onFinish(APBaseHttpAns aPBaseHttpAns) {
            }

            @Override // com.pay.http.IAPHttpAnsObserver
            public void onError(APBaseHttpAns aPBaseHttpAns) {
            }
        });
        AppMethodBeat.o(193016);
    }

    public synchronized void dataReport(String str) {
        String allReportRecord;
        AppMethodBeat.i(193017);
        if (str.equals(APMidasPluginInfo.LAUNCH_INTERFACE_INIT)) {
            allReportRecord = getAllReportRecord(this.initDataReport);
        } else {
            allReportRecord = getAllReportRecord(this.payDataReport);
        }
        if (TextUtils.isEmpty(allReportRecord)) {
            AppMethodBeat.o(193017);
        } else {
            APNetworkManager.getInstance().dataReport(allReportRecord, new IAPHttpAnsObserver() {
                /* class com.tencent.midas.data.APPluginReportManager.AnonymousClass2 */

                @Override // com.pay.http.IAPHttpAnsObserver
                public void onStop(APBaseHttpAns aPBaseHttpAns) {
                }

                @Override // com.pay.http.IAPHttpAnsObserver
                public void onFinish(APBaseHttpAns aPBaseHttpAns) {
                }

                @Override // com.pay.http.IAPHttpAnsObserver
                public void onError(APBaseHttpAns aPBaseHttpAns) {
                }
            });
            AppMethodBeat.o(193017);
        }
    }

    private String constructTimeReport(String str, long j2) {
        AppMethodBeat.i(193018);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("name=");
        stringBuffer.append(str);
        stringBuffer.append("&");
        stringBuffer.append("times=");
        stringBuffer.append(j2);
        stringBuffer.append("&");
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(193018);
        return stringBuffer2;
    }

    private void invokeAPKReportManager(String str, int i2, String str2, String str3, String str4, String str5) {
        Method method;
        Object obj;
        Method method2 = null;
        AppMethodBeat.i(193019);
        try {
            Class<?> cls = Class.forName("com.pay.data.report.APDataReportManager");
            if (cls != null) {
                try {
                    method = cls.getDeclaredMethod("getInstance", new Class[0]);
                } catch (NoSuchMethodException e2) {
                    APLog.i("APPluginReportManager", "invokeAPKReportManager error:" + e2.toString());
                    method = null;
                }
                try {
                    obj = method.invoke(null, new Object[0]);
                } catch (Exception e3) {
                    APLog.i("APPluginReportManager", "invokeAPKReportManager error:" + e3.toString());
                    obj = null;
                }
                try {
                    method2 = cls.getMethod("insertData", String.class, Integer.TYPE, String.class, String.class, String.class, String.class);
                } catch (NoSuchMethodException e4) {
                    APLog.i("APPluginReportManager", "invokeAPKReportManager error:" + e4.toString());
                }
                try {
                    method2.invoke(obj, str, Integer.valueOf(i2), str2, str3, str4, str5);
                    AppMethodBeat.o(193019);
                    return;
                } catch (Exception e5) {
                    APLog.i("APPluginReportManager", "invokeAPKReportManager error:" + e5.toString());
                }
            }
            AppMethodBeat.o(193019);
        } catch (Exception e6) {
            APLog.i("APPluginReportManager", "invokeAPKReportManager error:" + e6.toString());
            AppMethodBeat.o(193019);
        }
    }
}
