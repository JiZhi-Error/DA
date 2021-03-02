package com.tencent.tmassistantsdk.downloadclient;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.util.TMLog;
import java.util.ArrayList;
import java.util.Iterator;

public class TMAssistantDownloadSDKManager {
    protected static TMAssistantDownloadSDKManager mInstance = null;
    protected static ArrayList<TMAssistantDownloadOpenSDKClient> mOpenSDKClientList = new ArrayList<>();
    protected static ArrayList<TMAssistantDownloadSDKClient> mSDKClientList = new ArrayList<>();
    protected static TMAssistantDownloadSDKSettingClient mSDKSettingClient = null;
    protected Context mContext = null;

    static {
        AppMethodBeat.i(101902);
        AppMethodBeat.o(101902);
    }

    protected TMAssistantDownloadSDKManager(Context context) {
        this.mContext = context;
    }

    public static synchronized TMAssistantDownloadSDKManager getInstance(Context context) {
        TMAssistantDownloadSDKManager tMAssistantDownloadSDKManager;
        synchronized (TMAssistantDownloadSDKManager.class) {
            AppMethodBeat.i(101896);
            if (mInstance == null) {
                mInstance = new TMAssistantDownloadSDKManager(context);
            }
            tMAssistantDownloadSDKManager = mInstance;
            AppMethodBeat.o(101896);
        }
        return tMAssistantDownloadSDKManager;
    }

    public synchronized TMAssistantDownloadSDKClient getDownloadSDKClient(String str) {
        TMAssistantDownloadSDKClient tMAssistantDownloadSDKClient;
        AppMethodBeat.i(101897);
        if (str != null && str.length() > 0) {
            Iterator<TMAssistantDownloadSDKClient> it = mSDKClientList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    tMAssistantDownloadSDKClient = new TMAssistantDownloadSDKClient(this.mContext, str);
                    tMAssistantDownloadSDKClient.initTMAssistantDownloadSDK();
                    mSDKClientList.add(tMAssistantDownloadSDKClient);
                    AppMethodBeat.o(101897);
                    break;
                }
                tMAssistantDownloadSDKClient = it.next();
                if (tMAssistantDownloadSDKClient.mClientKey.equals(str)) {
                    AppMethodBeat.o(101897);
                    break;
                }
            }
        } else {
            tMAssistantDownloadSDKClient = null;
            AppMethodBeat.o(101897);
        }
        return tMAssistantDownloadSDKClient;
    }

    public synchronized TMAssistantDownloadSDKSettingClient getDownloadSDKSettingClient() {
        TMAssistantDownloadSDKSettingClient tMAssistantDownloadSDKSettingClient;
        AppMethodBeat.i(101898);
        if (mSDKSettingClient == null) {
            TMAssistantDownloadSDKSettingClient tMAssistantDownloadSDKSettingClient2 = new TMAssistantDownloadSDKSettingClient(this.mContext, "TMAssistantDownloadSDKManager");
            mSDKSettingClient = tMAssistantDownloadSDKSettingClient2;
            tMAssistantDownloadSDKSettingClient2.initTMAssistantDownloadSDK();
        }
        tMAssistantDownloadSDKSettingClient = mSDKSettingClient;
        AppMethodBeat.o(101898);
        return tMAssistantDownloadSDKSettingClient;
    }

    public synchronized TMAssistantDownloadOpenSDKClient getDownloadOpenSDKClient(String str) {
        TMAssistantDownloadOpenSDKClient tMAssistantDownloadOpenSDKClient;
        AppMethodBeat.i(101899);
        Iterator<TMAssistantDownloadOpenSDKClient> it = mOpenSDKClientList.iterator();
        while (true) {
            if (it.hasNext()) {
                tMAssistantDownloadOpenSDKClient = it.next();
                if (tMAssistantDownloadOpenSDKClient.mClientKey.equals(str)) {
                    AppMethodBeat.o(101899);
                    break;
                }
            } else {
                tMAssistantDownloadOpenSDKClient = new TMAssistantDownloadOpenSDKClient(this.mContext, str, "com.tencent.android.qqdownloader.SDKService");
                if (tMAssistantDownloadOpenSDKClient.initTMAssistantDownloadSDK()) {
                    mOpenSDKClientList.add(tMAssistantDownloadOpenSDKClient);
                    AppMethodBeat.o(101899);
                } else {
                    tMAssistantDownloadOpenSDKClient = null;
                    AppMethodBeat.o(101899);
                }
            }
        }
        return tMAssistantDownloadOpenSDKClient;
    }

    public synchronized boolean releaseDownloadSDKClient(String str) {
        boolean z;
        AppMethodBeat.i(101900);
        Iterator<TMAssistantDownloadSDKClient> it = mSDKClientList.iterator();
        while (true) {
            if (it.hasNext()) {
                TMAssistantDownloadSDKClient next = it.next();
                if (next != null && next.mClientKey.equals(str)) {
                    next.unInitTMAssistantDownloadSDK();
                    it.remove();
                    AppMethodBeat.o(101900);
                    z = true;
                    break;
                }
            } else if (mSDKSettingClient == null || !mSDKSettingClient.mClientKey.equals(str)) {
                z = false;
                AppMethodBeat.o(101900);
            } else {
                mSDKSettingClient.unInitTMAssistantDownloadSDK();
                mSDKSettingClient = null;
                AppMethodBeat.o(101900);
                z = true;
            }
        }
        return z;
    }

    public static synchronized void closeAllService(Context context) {
        synchronized (TMAssistantDownloadSDKManager.class) {
            AppMethodBeat.i(101901);
            TMLog.i("TMAssistantDownloadSDKManager", "closeAllService method!");
            if (mInstance == null) {
                TMLog.i("TMAssistantDownloadSDKManager", "manager minstance == null");
                AppMethodBeat.o(101901);
            } else {
                if (mSDKClientList != null && mSDKClientList.size() > 0) {
                    Iterator<TMAssistantDownloadSDKClient> it = mSDKClientList.iterator();
                    while (it.hasNext()) {
                        TMAssistantDownloadSDKClient next = it.next();
                        if (next != null) {
                            next.unInitTMAssistantDownloadSDK();
                        }
                    }
                    mSDKClientList.clear();
                }
                if (mSDKSettingClient != null) {
                    mSDKSettingClient.unInitTMAssistantDownloadSDK();
                    mSDKSettingClient = null;
                }
                mInstance = null;
                AppMethodBeat.o(101901);
            }
        }
    }

    public static String about() {
        return "TMAssistantDownloadSDKManager_2014_03_04_17_55_release_25406";
    }
}
