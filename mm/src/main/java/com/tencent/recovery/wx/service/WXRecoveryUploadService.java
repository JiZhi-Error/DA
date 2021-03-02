package com.tencent.recovery.wx.service;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.v4.e.c;
import android.text.TextUtils;
import com.tencent.mm.recovery.b;
import com.tencent.mm.recoveryv2.f;
import com.tencent.mm.recoveryv2.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.recovery.ConstantsRecovery;
import com.tencent.recovery.log.RecoveryLog;
import com.tencent.recovery.model.RecoveryHandleItem;
import com.tencent.recovery.report.RecoveryReporter;
import com.tencent.recovery.service.RecoveryUploadService;
import com.tencent.recovery.util.Util;
import com.tencent.recovery.wx.WXConstantsRecovery;
import com.tencent.recovery.wx.WXRecoveryVersion;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

@SuppressLint({"LongLogTag"})
public class WXRecoveryUploadService extends RecoveryUploadService {
    private static final String EXTRA_FETCH_BASE_ID = "extra_fetch_base_id";
    private static final String EXTRA_PATCH_URL = "extra_patch_url";
    private static final String RECOVERY_TAG = "MicroMsg.recovery.service";
    private static final String TAG = "Recovery.WXRecoveryUploadService";
    private static final String UNIT_REPORT_TAG = "RecoveryHandle";

    public static void fetchTinkerPatch(Context context, String str) {
        Intent intent = new Intent();
        intent.setClass(context, WXRecoveryUploadService.class);
        intent.putExtra(EXTRA_FETCH_BASE_ID, str);
        try {
            context.startService(intent);
        } catch (Throwable th) {
            Log.w(RECOVERY_TAG, "start service fail", th);
        }
    }

    @Override // com.tencent.recovery.service.RecoveryUploadService
    public void onHandleIntent(Intent intent) {
        if (intent.getIntExtra("extra_crash_count", -1) == -1) {
            String stringExtra = intent.getStringExtra(EXTRA_FETCH_BASE_ID);
            if (TextUtils.isEmpty(stringExtra)) {
                super.onHandleIntent(intent);
                return;
            }
            Log.i(RECOVERY_TAG, "fetchTinkerPatchByBaseId");
            Log.i(RECOVERY_TAG, "baseId = ".concat(String.valueOf(stringExtra)));
            Context applicationContext = getApplicationContext();
            AnonymousClass1 r2 = new c<Integer>() {
                /* class com.tencent.recovery.wx.service.WXRecoveryUploadService.AnonymousClass1 */

                public void accept(Integer num) {
                    Log.i(WXRecoveryUploadService.RECOVERY_TAG, "fetchTinkerPatchByBaseId callback, status = ".concat(String.valueOf(num)));
                }
            };
            f.i("MicroMsg.recovery.operator", "#fetchTinkerPatchForTest");
            b.AnonymousClass3 r3 = 
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x004b: CONSTRUCTOR  (r3v2 'r3' com.tencent.mm.recovery.b$3) = 
                  (r1v4 'applicationContext' android.content.Context)
                  (r0v5 'stringExtra' java.lang.String)
                  (r2v3 'r2' com.tencent.recovery.wx.service.WXRecoveryUploadService$1)
                 call: com.tencent.mm.recovery.b.3.<init>(android.content.Context, java.lang.String, android.support.v4.e.c):void type: CONSTRUCTOR in method: com.tencent.recovery.wx.service.WXRecoveryUploadService.onHandleIntent(android.content.Intent):void, file: classes.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.recovery.b, state: GENERATED_AND_UNLOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                	... 25 more
                */
            /*
            // Method dump skipped, instructions count: 131
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.recovery.wx.service.WXRecoveryUploadService.onHandleIntent(android.content.Intent):void");
        }

        private void fetchTinkerPatch(Intent intent) {
            int[] iArr = {0};
            try {
                com.tencent.mm.recovery.c cVar = new com.tencent.mm.recovery.c(iArr);
                String stringExtra = intent.getStringExtra(EXTRA_PATCH_URL);
                if (TextUtils.isEmpty(stringExtra)) {
                    stringExtra = intent.getDataString();
                }
                if (TextUtils.isEmpty(stringExtra)) {
                    f.i(RECOVERY_TAG, "#fetchTinkerPatch, fetch patch url with cgi");
                    b.b(getApplicationContext(), cVar);
                } else {
                    f.i(RECOVERY_TAG, "#fetchTinkerPatch, download patch with given url, url = ".concat(String.valueOf(stringExtra)));
                    b.a(getApplicationContext(), stringExtra, cVar);
                }
            } catch (Throwable th) {
                f.w(RECOVERY_TAG, "fetch error", th);
                iArr[0] = 10;
            }
            f.i(RECOVERY_TAG, "#fetchTinkerPatch done, status = " + iArr[0]);
            i iQ = i.iQ(getApplication());
            iQ.NBY = false;
            iQ.NBX = iArr[0];
            iQ.save();
        }

        @Override // com.tencent.recovery.service.RecoveryUploadService
        public boolean tryToUploadData() {
            Intent intent = new Intent();
            intent.setPackage(getPackageName());
            intent.setAction(WXConstantsRecovery.IntentAction.RECOVERY_STATUS_UPLOAD);
            sendBroadcast(intent);
            List<RecoveryHandleItem> itemList = RecoveryReporter.getItemList(this, ConstantsRecovery.ReportType.HandleStatus, RecoveryHandleItem.class);
            boolean uploadData = uploadData(itemList);
            if (itemList.size() == 0 || uploadData) {
                RecoveryReporter.clearReportFile(this, ConstantsRecovery.ReportType.HandleStatus);
            }
            return uploadData;
        }

        /* access modifiers changed from: protected */
        public boolean uploadData(List<RecoveryHandleItem> list) {
            String str;
            int uuid = Util.getUUID(this);
            JSONArray jSONArray = new JSONArray();
            String baseClientVersion = WXRecoveryVersion.getBaseClientVersion(this);
            String str2 = baseClientVersion;
            for (RecoveryHandleItem recoveryHandleItem : list) {
                try {
                    jSONArray.put(new JSONObject().put("tag", UNIT_REPORT_TAG).put("info", recoveryHandleItem.key).put(OpenSDKTool4Assistant.EXTRA_UIN, recoveryHandleItem.uuid).put("deviceUUID", uuid).put("time", Util.getTimeFormat(recoveryHandleItem.timestamp)).put("cver", recoveryHandleItem.clientVersion).put("processName", recoveryHandleItem.processName).put("phoneStatus", recoveryHandleItem.phoneStatus));
                    if (compareVersion(recoveryHandleItem.clientVersion, str2) > 0) {
                        str = recoveryHandleItem.clientVersion;
                    } else {
                        str = str2;
                    }
                    str2 = str;
                } catch (Exception e2) {
                }
            }
            boolean pushData = pushData(jSONArray, str2);
            RecoveryLog.i(TAG, "upload result %b %d", Boolean.valueOf(pushData), Integer.valueOf(list.size()));
            return pushData;
        }

        /* JADX WARNING: Removed duplicated region for block: B:34:0x01d8 A[SYNTHETIC, Splitter:B:34:0x01d8] */
        /* JADX WARNING: Removed duplicated region for block: B:43:0x01f5 A[SYNTHETIC, Splitter:B:43:0x01f5] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private boolean pushData(org.json.JSONArray r13, java.lang.String r14) {
            /*
            // Method dump skipped, instructions count: 531
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.recovery.wx.service.WXRecoveryUploadService.pushData(org.json.JSONArray, java.lang.String):boolean");
        }

        public static String convertStreamToString(InputStream inputStream) {
            if (inputStream == null) {
                return "";
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder sb = new StringBuilder();
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        sb.append(readLine + "\n");
                    } else {
                        try {
                            break;
                        } catch (IOException e2) {
                            RecoveryLog.printErrStackTrace(TAG, e2, "", new Object[0]);
                        }
                    }
                } catch (IOException e3) {
                    RecoveryLog.printErrStackTrace(TAG, e3, "", new Object[0]);
                    try {
                        inputStream.close();
                    } catch (IOException e4) {
                        RecoveryLog.printErrStackTrace(TAG, e4, "", new Object[0]);
                    }
                } catch (Throwable th) {
                    try {
                        inputStream.close();
                    } catch (IOException e5) {
                        RecoveryLog.printErrStackTrace(TAG, e5, "", new Object[0]);
                    }
                    throw th;
                }
            }
            inputStream.close();
            return sb.toString();
        }

        private static int compareVersion(String str, String str2) {
            try {
                int intValue = Integer.decode(str).intValue();
                int intValue2 = Integer.decode(str2).intValue();
                if (intValue > intValue2) {
                    return 1;
                }
                if (intValue2 > intValue) {
                    return -1;
                }
                return 0;
            } catch (Exception e2) {
                return 0;
            }
        }
    }
