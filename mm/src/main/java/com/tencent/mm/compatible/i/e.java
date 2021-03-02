package com.tencent.mm.compatible.i;

import android.annotation.TargetApi;
import android.media.MediaRecorder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.o;
import java.io.File;
import java.io.FileDescriptor;

@TargetApi(16)
public final class e extends MediaRecorder {
    private FileDescriptor gLG;
    private o mFile;

    @Override // android.media.MediaRecorder
    public final void setOutputFile(String str) {
        AppMethodBeat.i(155941);
        this.mFile = str == null ? null : new o(str);
        this.gLG = null;
        AppMethodBeat.o(155941);
    }

    @Override // android.media.MediaRecorder
    @Deprecated
    public final void setOutputFile(File file) {
        AppMethodBeat.i(155942);
        setOutputFile(file.getPath());
        AppMethodBeat.o(155942);
    }

    @Override // android.media.MediaRecorder
    public final void setOutputFile(FileDescriptor fileDescriptor) {
        this.mFile = null;
        this.gLG = fileDescriptor;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0049  */
    @Override // android.media.MediaRecorder
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void prepare() {
        /*
        // Method dump skipped, instructions count: 110
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.compatible.i.e.prepare():void");
    }
}
