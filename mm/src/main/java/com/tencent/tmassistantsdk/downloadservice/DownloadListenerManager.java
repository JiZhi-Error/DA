package com.tencent.tmassistantsdk.downloadservice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;

public class DownloadListenerManager {
    protected static DownloadListenerManager mDownloadListenerManager = null;
    protected final ArrayList<IDownloadManagerListener> mListeners = new ArrayList<>();

    public static DownloadListenerManager getInstance() {
        AppMethodBeat.i(101974);
        if (mDownloadListenerManager == null) {
            mDownloadListenerManager = new DownloadListenerManager();
        }
        DownloadListenerManager downloadListenerManager = mDownloadListenerManager;
        AppMethodBeat.o(101974);
        return downloadListenerManager;
    }

    protected DownloadListenerManager() {
        AppMethodBeat.i(101975);
        AppMethodBeat.o(101975);
    }

    public synchronized void Add(IDownloadManagerListener iDownloadManagerListener) {
        AppMethodBeat.i(101976);
        if (!this.mListeners.contains(iDownloadManagerListener)) {
            this.mListeners.add(iDownloadManagerListener);
        }
        AppMethodBeat.o(101976);
    }

    public synchronized void Remove(IDownloadManagerListener iDownloadManagerListener) {
        AppMethodBeat.i(101977);
        this.mListeners.remove(iDownloadManagerListener);
        AppMethodBeat.o(101977);
    }

    public synchronized void OnDownloadStateChanged(String str, int i2, int i3, String str2, boolean z, boolean z2) {
        AppMethodBeat.i(101978);
        Iterator<IDownloadManagerListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().OnDownloadStateChanged(str, i2, i3, str2, z, z2);
        }
        AppMethodBeat.o(101978);
    }

    public synchronized void OnDownloadProgressChanged(String str, long j2, long j3) {
        AppMethodBeat.i(101979);
        Iterator<IDownloadManagerListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().OnDownloadProgressChanged(str, j2, j3);
        }
        AppMethodBeat.o(101979);
    }
}
