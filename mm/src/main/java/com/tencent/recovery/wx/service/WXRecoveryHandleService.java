package com.tencent.recovery.wx.service;

import android.content.Context;
import android.os.PowerManager;
import com.tencent.recovery.log.RecoveryLog;
import com.tencent.recovery.model.RecoveryData;
import com.tencent.recovery.model.RecoveryHandleItem;
import com.tencent.recovery.model.RecoveryHandleResult;
import com.tencent.recovery.service.RecoveryHandleService;
import com.tencent.recovery.wx.WXConstantsRecovery;
import com.tencent.recovery.wx.util.NetUtil;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.ArrayList;

public class WXRecoveryHandleService extends RecoveryHandleService {
    private static final String TAG = "Recovery.WXRecoveryHandleService";
    private PowerManager powerManager;

    @Override // com.tencent.recovery.service.RecoveryHandleService
    public void onCreate() {
        super.onCreate();
        RecoveryLog.i(TAG, "onCreate", new Object[0]);
        this.powerManager = (PowerManager) getSystemService("power");
    }

    @Override // com.tencent.recovery.service.RecoveryHandleService
    public void onDestroy() {
        RecoveryLog.i(TAG, "onDestroy", new Object[0]);
        super.onDestroy();
    }

    @Override // com.tencent.recovery.service.RecoveryHandleService
    public void alreadyRunning(Context context, RecoveryData recoveryData, ArrayList<RecoveryHandleItem> arrayList, int i2, boolean z) {
        arrayList.add(generateHandleItem(recoveryData, String.format("%s[%b]", WXConstantsRecovery.HandleReportKeys.KeyTotalCount, Boolean.valueOf(z))));
        arrayList.add(generateHandleItem(recoveryData, String.format("%s[%b]", WXConstantsRecovery.HandleReportKeys.KeyAlreadyRunning, Boolean.valueOf(z))));
    }

    @Override // com.tencent.recovery.service.RecoveryHandleService
    public RecoveryHandleResult handleException(Context context, RecoveryData recoveryData, ArrayList<RecoveryHandleItem> arrayList, int i2, boolean z) {
        RecoveryHandleResult recoveryHandleResult = new RecoveryHandleResult();
        arrayList.add(generateHandleItem(recoveryData, String.format("%s[%b]", WXConstantsRecovery.HandleReportKeys.KeyTotalCount, Boolean.valueOf(z))));
        RecoveryHandleItem generateHandleItem = generateHandleItem(recoveryData, "");
        if (NetUtil.isConnected(this)) {
            realHandleException(context, recoveryData, generateHandleItem, recoveryHandleResult);
        } else {
            RecoveryLog.i(TAG, "no network", new Object[0]);
            if (!z) {
                recoveryHandleResult.retry = true;
            }
            generateHandleItem.key = String.format("%s[%b]", WXConstantsRecovery.HandleReportKeys.KeyNoNetWork, Boolean.valueOf(z));
        }
        arrayList.add(generateHandleItem);
        return recoveryHandleResult;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00e1 A[SYNTHETIC, Splitter:B:33:0x00e1] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00ec A[SYNTHETIC, Splitter:B:39:0x00ec] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0101  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void realHandleException(android.content.Context r10, com.tencent.recovery.model.RecoveryData r11, com.tencent.recovery.model.RecoveryHandleItem r12, com.tencent.recovery.model.RecoveryHandleResult r13) {
        /*
        // Method dump skipped, instructions count: 358
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.recovery.wx.service.WXRecoveryHandleService.realHandleException(android.content.Context, com.tencent.recovery.model.RecoveryData, com.tencent.recovery.model.RecoveryHandleItem, com.tencent.recovery.model.RecoveryHandleResult):void");
    }

    /* access modifiers changed from: protected */
    public RecoveryHandleItem generateHandleItem(RecoveryData recoveryData, String str) {
        RecoveryHandleItem recoveryHandleItem = new RecoveryHandleItem();
        recoveryHandleItem.uuid = recoveryData.uuid;
        recoveryHandleItem.clientVersion = recoveryData.clientVersion;
        recoveryHandleItem.timestamp = System.currentTimeMillis();
        recoveryHandleItem.key = str;
        recoveryHandleItem.processName = recoveryData.processName;
        recoveryHandleItem.phoneStatus = getCurrentPhoneStatus(this);
        return recoveryHandleItem;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00cd, code lost:
        r2 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00ce, code lost:
        r4 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x010d, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x010e, code lost:
        r2 = r1;
        r4 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0117, code lost:
        r4.disconnect();
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:47:0x00bd, B:52:0x00ca] */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0028 A[SYNTHETIC, Splitter:B:10:0x0028] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0063 A[SYNTHETIC, Splitter:B:18:0x0063] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0070 A[SYNTHETIC, Splitter:B:26:0x0070] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00fa A[SYNTHETIC, Splitter:B:60:0x00fa] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00ff  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x010d A[ExcHandler: all (r1v1 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:47:0x00bd] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0112 A[SYNTHETIC, Splitter:B:70:0x0112] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0117  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String getConfigData(java.lang.String r9, com.tencent.recovery.model.RecoveryHandleItem r10) {
        /*
        // Method dump skipped, instructions count: 404
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.recovery.wx.service.WXRecoveryHandleService.getConfigData(java.lang.String, com.tencent.recovery.model.RecoveryHandleItem):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0092, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0093, code lost:
        r3 = r1;
        r5 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00d4, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00d5, code lost:
        r2 = r1;
        r5 = r0;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:40:0x0082, B:45:0x008f] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x002a A[SYNTHETIC, Splitter:B:12:0x002a] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0035 A[SYNTHETIC, Splitter:B:19:0x0035] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00c0 A[SYNTHETIC, Splitter:B:53:0x00c0] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00d4 A[ExcHandler: all (r1v5 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:40:0x0082] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00d9 A[SYNTHETIC, Splitter:B:63:0x00d9] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00de  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final byte[] getPatchData(java.lang.String r7, java.lang.String r8, com.tencent.recovery.model.RecoveryHandleItem r9) {
        /*
        // Method dump skipped, instructions count: 297
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.recovery.wx.service.WXRecoveryHandleService.getPatchData(java.lang.String, java.lang.String, com.tencent.recovery.model.RecoveryHandleItem):byte[]");
    }

    public static byte[] readFromStream(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr, 0, 1024);
            if (read <= 0) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    public static boolean checkResolveIPAddress(String str) {
        try {
            InetAddress byName = InetAddress.getByName(str);
            if (byName == null || byName.getHostAddress() == null) {
                return false;
            }
            return true;
        } catch (Exception e2) {
            return false;
        }
    }

    public String getCurrentPhoneStatus(Context context) {
        String currentNetWorkStatus = NetUtil.getCurrentNetWorkStatus(context);
        boolean isScreenOn = this.powerManager.isScreenOn();
        boolean checkResolveIPAddress = checkResolveIPAddress("dldir1.qq.com");
        return currentNetWorkStatus + "|" + isScreenOn + "|" + checkResolveIPAddress + "|" + checkResolveIPAddress("www.qq.com");
    }
}
