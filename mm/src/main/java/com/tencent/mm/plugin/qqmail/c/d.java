package com.tencent.mm.plugin.qqmail.c;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.type.IPCLong;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.f;

public class d implements b<IPCLong, Bundle> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
    @Override // com.tencent.mm.ipcinvoker.b
    public /* synthetic */ void invoke(IPCLong iPCLong, com.tencent.mm.ipcinvoker.d<Bundle> dVar) {
        AppMethodBeat.i(198581);
        FileDownloadTaskInfo Co = f.cBv().Co(iPCLong.value);
        Bundle bundle = new Bundle();
        bundle.putInt("download_status", Co.status);
        bundle.putFloat("download_progress", (1.0f * ((float) Co.qJe)) / ((float) Co.oJj));
        bundle.putString("download_apk_path", Co.path);
        dVar.bn(bundle);
        AppMethodBeat.o(198581);
    }
}
