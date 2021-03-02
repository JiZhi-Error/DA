package com.tencent.tmassistantsdk.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.downloadservice.taskmanager.ServiceDownloadTask;
import com.tencent.tmassistantsdk.storage.table.ClientInfoTable;
import com.tencent.tmassistantsdk.storage.table.DownloadInfoTable;
import java.util.ArrayList;

public class DBManager {
    protected static DBManager mInstance = null;

    public static synchronized DBManager getInstance() {
        DBManager dBManager;
        synchronized (DBManager.class) {
            AppMethodBeat.i(102406);
            if (mInstance == null) {
                mInstance = new DBManager();
            }
            dBManager = mInstance;
            AppMethodBeat.o(102406);
        }
        return dBManager;
    }

    public ArrayList<DownloadInfo> queryDownloadInfoList() {
        AppMethodBeat.i(102407);
        ArrayList<DownloadInfo> load = DownloadInfoTable.load();
        AppMethodBeat.o(102407);
        return load;
    }

    public void saveDownloadInfoList(ArrayList<DownloadInfo> arrayList) {
        AppMethodBeat.i(102408);
        DownloadInfoTable.save(arrayList);
        AppMethodBeat.o(102408);
    }

    public void addDownloadInfo(DownloadInfo downloadInfo) {
        AppMethodBeat.i(102409);
        DownloadInfoTable.add(downloadInfo);
        AppMethodBeat.o(102409);
    }

    public void deleteDownloadInfo(String str) {
        AppMethodBeat.i(102410);
        DownloadInfoTable.del(str);
        ClientInfoTable.deleteItemsByURL(str);
        AppMethodBeat.o(102410);
    }

    public DownloadInfo queryDownloadInfoByUrl(String str) {
        AppMethodBeat.i(102411);
        DownloadInfo query = DownloadInfoTable.query(str);
        AppMethodBeat.o(102411);
        return query;
    }

    public ArrayList<ServiceDownloadTask> queryWaitingAndDownloadingTaskList() {
        AppMethodBeat.i(102412);
        ArrayList<ServiceDownloadTask> query = DownloadInfoTable.query();
        AppMethodBeat.o(102412);
        return query;
    }

    public void saveClientInfo(String str, String str2) {
        AppMethodBeat.i(102413);
        ClientInfoTable.save(str, str2);
        AppMethodBeat.o(102413);
    }
}
