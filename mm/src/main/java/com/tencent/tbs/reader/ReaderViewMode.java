package com.tencent.tbs.reader;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tbs.reader.ITbsReader;

public class ReaderViewMode extends FrameLayout {
    public static final String TAG = "ReaderView";

    /* renamed from: a  reason: collision with root package name */
    protected ITbsReader.IReaderCore f2799a = null;

    public ReaderViewMode(Context context, ITbsReader iTbsReader) {
        super(context);
        AppMethodBeat.i(53091);
        if (iTbsReader != null) {
            this.f2799a = iTbsReader.getReaderCore();
        }
        if (this.f2799a != null) {
            this.f2799a.init(context);
        }
        AppMethodBeat.o(53091);
    }

    public int openFile(Bundle bundle) {
        AppMethodBeat.i(53092);
        if (this.f2799a == null || bundle == null) {
            AppMethodBeat.o(53092);
            return -1;
        }
        int openFile = this.f2799a.openFile(getContext(), bundle, this, null);
        int i2 = 1100;
        if (openFile != 0) {
            i2 = 1101;
        }
        ReaderEngine.getInstance().report(i2, "ViewOpenFile:".concat(String.valueOf(openFile)), null);
        AppMethodBeat.o(53092);
        return openFile;
    }

    public void closeFile() {
        AppMethodBeat.i(53093);
        if (this.f2799a != null) {
            this.f2799a.closeFile();
        }
        AppMethodBeat.o(53093);
    }

    public void destroy() {
        AppMethodBeat.i(53094);
        if (this.f2799a != null) {
            this.f2799a.destroy();
        }
        this.f2799a = null;
        AppMethodBeat.o(53094);
    }

    public void onSizeChanged(Integer num, Integer num2) {
        AppMethodBeat.i(53095);
        if (this.f2799a != null) {
            this.f2799a.onSizeChanged(num, num2);
        }
        AppMethodBeat.o(53095);
    }
}
