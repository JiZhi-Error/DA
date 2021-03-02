package com.tencent.tbs.reader;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tbs.reader.ITbsReader;

public class ReaderPluginPreLoad {
    public static final String TAG = "ReaderPluginPreLoad";

    /* renamed from: a  reason: collision with root package name */
    protected ITbsReader.IReaderPlugin f2798a = null;

    public ReaderPluginPreLoad(Context context, ITbsReader iTbsReader) {
        AppMethodBeat.i(53088);
        if (iTbsReader != null) {
            this.f2798a = iTbsReader.getReaderPlugin();
        }
        if (this.f2798a != null) {
            this.f2798a.initPlugin(context);
        }
        AppMethodBeat.o(53088);
    }

    public int downloadPlugin(Context context, String str) {
        AppMethodBeat.i(53089);
        int i2 = 0;
        if (this.f2798a != null) {
            i2 = this.f2798a.downloadPlugin(context, str);
        }
        AppMethodBeat.o(53089);
        return i2;
    }

    public void destroy() {
        AppMethodBeat.i(53090);
        if (this.f2798a != null) {
            this.f2798a.destroy();
        }
        AppMethodBeat.o(53090);
    }
}
