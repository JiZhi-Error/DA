package com.tencent.tbs.reader;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class TbsReaderManager {
    public static final String TAG = "TbsReaderManager";

    /* renamed from: a  reason: collision with root package name */
    protected ITbsReader f2803a = null;

    public ReaderViewMode createReaderView(Context context, ITbsReaderCallback iTbsReaderCallback) {
        AppMethodBeat.i(53096);
        destroy();
        this.f2803a = ReaderEngine.getInstance().createTbsReader(context.getApplicationContext(), 1, iTbsReaderCallback);
        ReaderViewMode readerViewMode = new ReaderViewMode(context, this.f2803a);
        AppMethodBeat.o(53096);
        return readerViewMode;
    }

    public ReaderMixerMode createReaderMode(Context context, ITbsReaderCallback iTbsReaderCallback) {
        AppMethodBeat.i(187986);
        destroy();
        this.f2803a = ReaderEngine.getInstance().createTbsReader(context.getApplicationContext(), 3, iTbsReaderCallback);
        ReaderMixerMode readerMixerMode = new ReaderMixerMode(context, this.f2803a);
        AppMethodBeat.o(187986);
        return readerMixerMode;
    }

    public ReaderPluginPreLoad getPluginPre(Context context) {
        AppMethodBeat.i(53098);
        ReaderPluginPreLoad readerPluginPreLoad = new ReaderPluginPreLoad(context, this.f2803a);
        AppMethodBeat.o(53098);
        return readerPluginPreLoad;
    }

    public void doAction(Integer num, Object obj, Object obj2) {
        AppMethodBeat.i(53099);
        if (this.f2803a != null) {
            this.f2803a.doCommand(num, obj, obj2);
        }
        AppMethodBeat.o(53099);
    }

    public ITbsReader getTbsReader() {
        return this.f2803a;
    }

    public void destroy() {
        AppMethodBeat.i(53100);
        if (this.f2803a != null) {
            this.f2803a.destroy();
        }
        this.f2803a = null;
        AppMethodBeat.o(53100);
    }
}
