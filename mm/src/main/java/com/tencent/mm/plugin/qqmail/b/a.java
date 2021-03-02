package com.tencent.mm.plugin.qqmail.b;

import android.os.Bundle;
import com.tencent.f.b;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.model.n;
import java.util.concurrent.ExecutorService;

public class a extends n<Bundle, Integer, Bundle> {

    /* renamed from: com.tencent.mm.plugin.qqmail.b.a$a  reason: collision with other inner class name */
    public interface AbstractC1611a {
        void onProgress(int i2);

        void onResult(Bundle bundle);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    @Override // com.tencent.mm.pluginsdk.model.n
    public /* synthetic */ Bundle doInBackground(Bundle[] bundleArr) {
        AppMethodBeat.i(198570);
        Bundle a2 = a(bundleArr);
        AppMethodBeat.o(198570);
        return a2;
    }

    public Bundle a(Bundle... bundleArr) {
        return null;
    }

    @Override // com.tencent.mm.pluginsdk.model.n
    public final ExecutorService eGk() {
        AppMethodBeat.i(198569);
        b bqp = h.RTc.bqp("MailDownloadAsyncTask");
        AppMethodBeat.o(198569);
        return bqp;
    }
}
