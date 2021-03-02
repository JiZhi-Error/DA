package com.tencent.tbs.reader;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tbs.reader.ITbsReader;

public class ReaderMixerMode {
    public static final String TAG = "ReaderDialogMode";

    /* renamed from: a  reason: collision with root package name */
    protected ITbsReader.IReaderCore f2796a = null;

    /* renamed from: b  reason: collision with root package name */
    protected Context f2797b;

    public ReaderMixerMode(Context context, ITbsReader iTbsReader) {
        AppMethodBeat.i(187967);
        this.f2797b = context;
        if (iTbsReader != null) {
            this.f2796a = iTbsReader.getReaderCore();
        }
        if (this.f2796a != null) {
            this.f2796a.init(context);
        }
        AppMethodBeat.o(187967);
    }

    public int openFile(Bundle bundle, FrameLayout frameLayout) {
        AppMethodBeat.i(187968);
        if (this.f2796a == null || bundle == null) {
            AppMethodBeat.o(187968);
            return -1;
        }
        int openFile = this.f2796a.openFile(this.f2797b, bundle, frameLayout, null);
        int i2 = 1100;
        if (openFile != 0) {
            i2 = 1101;
        }
        ReaderEngine.getInstance().report(i2, "openFile:".concat(String.valueOf(openFile)), null);
        AppMethodBeat.o(187968);
        return openFile;
    }

    public void onSizeChanged(int i2, int i3) {
        AppMethodBeat.i(187969);
        if (this.f2796a != null) {
            this.f2796a.onSizeChanged(Integer.valueOf(i2), Integer.valueOf(i3));
        }
        AppMethodBeat.o(187969);
    }

    public void closeFile() {
        AppMethodBeat.i(187970);
        if (this.f2796a != null) {
            this.f2796a.closeFile();
        }
        AppMethodBeat.o(187970);
    }

    public void destroy() {
        AppMethodBeat.i(187971);
        if (this.f2796a != null) {
            this.f2796a.destroy();
        }
        this.f2796a = null;
        this.f2797b = null;
        AppMethodBeat.o(187971);
    }

    public void onSizeChanged(Integer num, Integer num2) {
        AppMethodBeat.i(187972);
        if (this.f2796a != null) {
            this.f2796a.onSizeChanged(num, num2);
        }
        AppMethodBeat.o(187972);
    }
}
