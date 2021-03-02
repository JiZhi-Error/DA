package com.tencent.mm.platformtools;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.CoreService;
import com.tencent.mm.booter.InstallReceiver;
import com.tencent.mm.booter.MMReceivers;
import com.tencent.mm.booter.MountReceiver;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.downloader.model.FileDownloadReceiver;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;

public class BroadcastHelper implements CoreService.a {
    private static final String TAG = "MicroMsg.BroadcastHelper";
    private static HashMap<String, BroadcastReceiver> broadcastReceiverHashMap = new HashMap<>();

    static {
        AppMethodBeat.i(20712);
        AppMethodBeat.o(20712);
    }

    public static void registerBroadcast(BroadcastReceiver broadcastReceiver, String str) {
        AppMethodBeat.i(20704);
        registerBroadcast(broadcastReceiver, new String[]{str}, new String[0]);
        AppMethodBeat.o(20704);
    }

    public static void registerBroadcast(BroadcastReceiver broadcastReceiver, String str, String str2) {
        AppMethodBeat.i(20705);
        registerBroadcast(broadcastReceiver, new String[]{str}, new String[]{str2});
        AppMethodBeat.o(20705);
    }

    public static void registerBroadcast(BroadcastReceiver broadcastReceiver, String[] strArr) {
        AppMethodBeat.i(20706);
        registerBroadcast(broadcastReceiver, strArr, new String[0]);
        AppMethodBeat.o(20706);
    }

    public static void registerBroadcast(BroadcastReceiver broadcastReceiver, String[] strArr, String str) {
        AppMethodBeat.i(20707);
        registerBroadcast(broadcastReceiver, strArr, new String[]{str});
        AppMethodBeat.o(20707);
    }

    public static void registerBroadcast(BroadcastReceiver broadcastReceiver, String[] strArr, String[] strArr2) {
        AppMethodBeat.i(20708);
        Log.i(TAG, "registerBroadcast: " + broadcastReceiver.getClass().getSimpleName());
        IntentFilter intentFilter = new IntentFilter();
        if (!Util.isNullOrNil(strArr)) {
            for (String str : strArr) {
                intentFilter.addAction(str);
            }
        }
        if (!Util.isNullOrNil(strArr2)) {
            for (String str2 : strArr2) {
                intentFilter.addCategory(str2);
            }
        }
        MMApplicationContext.getContext().registerReceiver(broadcastReceiver, intentFilter);
        AppMethodBeat.o(20708);
    }

    public static void unRegisterBroadcast(BroadcastReceiver broadcastReceiver) {
        AppMethodBeat.i(20709);
        Log.i(TAG, "unRegisterBroadcast: " + broadcastReceiver.getClass().getSimpleName());
        if (broadcastReceiver != null) {
            MMApplicationContext.getContext().unregisterReceiver(broadcastReceiver);
        }
        AppMethodBeat.o(20709);
    }

    @Override // com.tencent.mm.booter.CoreService.a
    public void registerBroadcasts() {
        AppMethodBeat.i(20710);
        Log.i(TAG, "registerBroadcasts()");
        if (MMApplicationContext.isPushProcess() && d.oD(24)) {
            MMReceivers.ConnectionReceiver connectionReceiver = new MMReceivers.ConnectionReceiver();
            broadcastReceiverHashMap.put(MMReceivers.ConnectionReceiver.class.getSimpleName(), connectionReceiver);
            registerBroadcast(connectionReceiver, "android.net.conn.CONNECTIVITY_CHANGE");
        }
        if (MMApplicationContext.isMMProcess() && d.oD(26)) {
            FileDownloadReceiver fileDownloadReceiver = new FileDownloadReceiver();
            broadcastReceiverHashMap.put(FileDownloadReceiver.class.getSimpleName(), fileDownloadReceiver);
            registerBroadcast(fileDownloadReceiver, "android.intent.action.DOWNLOAD_COMPLETE");
            MountReceiver mountReceiver = new MountReceiver();
            broadcastReceiverHashMap.put(MountReceiver.class.getSimpleName(), mountReceiver);
            registerBroadcast(mountReceiver, new String[]{"android.intent.action.MEDIA_MOUNTED", "android.intent.action.MEDIA_EJECT", "android.intent.action.MEDIA_UNMOUNTED", "android.intent.action.MEDIA_SHARED", "android.intent.action.MEDIA_SCANNER_STARTED", "android.intent.action.MEDIA_SCANNER_FINISHED", "android.intent.action.MEDIA_REMOVED", "android.intent.action.MEDIA_BAD_REMOVAL"});
        }
        AppMethodBeat.o(20710);
    }

    @Override // com.tencent.mm.booter.CoreService.a
    public void unRegisterBroadcasts() {
        AppMethodBeat.i(20711);
        Log.i(TAG, "unRegisterBroadcasts()");
        try {
            if (MMApplicationContext.isPushProcess() && d.oD(24)) {
                unRegisterBroadcast((MMReceivers.ConnectionReceiver) broadcastReceiverHashMap.get(MMReceivers.ConnectionReceiver.class.getSimpleName()));
            }
            if (MMApplicationContext.isMMProcess() && d.oD(26)) {
                unRegisterBroadcast((FileDownloadReceiver) broadcastReceiverHashMap.get(FileDownloadReceiver.class.getSimpleName()));
                unRegisterBroadcast((InstallReceiver) broadcastReceiverHashMap.get(InstallReceiver.class.getSimpleName()));
                unRegisterBroadcast((MountReceiver) broadcastReceiverHashMap.get(MountReceiver.class.getSimpleName()));
            }
            AppMethodBeat.o(20711);
        } catch (Exception e2) {
            Log.e(TAG, "unRegisterBroadcasts() Exception = %s ", e2.getMessage());
            AppMethodBeat.o(20711);
        }
    }
}
