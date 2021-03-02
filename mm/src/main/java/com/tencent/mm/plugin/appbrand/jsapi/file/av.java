package com.tencent.mm.plugin.appbrand.jsapi.file;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tbs.reader.ITbsReaderCallback;
import com.tencent.tbs.reader.ReaderEngine;
import com.tencent.tbs.reader.TbsFileInterfaceImpl;

public final class av {
    public static av lVK;
    private TbsFileInterfaceImpl lVL = null;

    public static synchronized av dP(Context context) {
        av avVar;
        synchronized (av.class) {
            AppMethodBeat.i(226830);
            if (lVK == null) {
                lVK = new av(context);
            }
            avVar = lVK;
            AppMethodBeat.o(226830);
        }
        return avVar;
    }

    private av(Context context) {
        AppMethodBeat.i(226831);
        ReaderEngine.getInstance().initReaderEntry(context);
        this.lVL = new TbsFileInterfaceImpl();
        AppMethodBeat.o(226831);
    }

    public final int a(Context context, Bundle bundle, ITbsReaderCallback iTbsReaderCallback) {
        AppMethodBeat.i(226832);
        if (this.lVL == null) {
            AppMethodBeat.o(226832);
            return -1;
        }
        int openFileReader = this.lVL.openFileReader(context, bundle, iTbsReaderCallback, null);
        AppMethodBeat.o(226832);
        return openFileReader;
    }

    public final void closeFileReader() {
        AppMethodBeat.i(226833);
        if (this.lVL != null) {
            this.lVL.closeFileReader();
        }
        AppMethodBeat.o(226833);
    }
}
