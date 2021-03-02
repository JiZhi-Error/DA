package com.tencent.mm.plugin.qqmail.b;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.qqmail.b.a;

public final class b extends a {
    private a.AbstractC1611a BqY;
    private String filePath;
    private int iMt;
    Bundle param = null;
    private String url;

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    @Override // com.tencent.mm.plugin.qqmail.b.a, com.tencent.mm.pluginsdk.model.n
    public final /* synthetic */ Bundle doInBackground(Bundle[] bundleArr) {
        AppMethodBeat.i(198575);
        Bundle a2 = a(bundleArr);
        AppMethodBeat.o(198575);
        return a2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.tencent.mm.pluginsdk.model.n
    public final /* synthetic */ void onPostExecute(Bundle bundle) {
        AppMethodBeat.i(198574);
        Bundle bundle2 = bundle;
        if (this.BqY != null) {
            this.BqY.onResult(bundle2);
        }
        AppMethodBeat.o(198574);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    @Override // com.tencent.mm.pluginsdk.model.n
    public final /* synthetic */ void onProgressUpdate(Integer[] numArr) {
        AppMethodBeat.i(198573);
        Integer[] numArr2 = numArr;
        if (this.BqY != null) {
            this.BqY.onProgress(numArr2[0].intValue());
        }
        AppMethodBeat.o(198573);
    }

    b(String str, String str2, a.AbstractC1611a aVar) {
        this.url = str;
        this.filePath = str2;
        this.BqY = aVar;
    }

    @Override // com.tencent.mm.plugin.qqmail.b.a
    public final Bundle a(Bundle... bundleArr) {
        AppMethodBeat.i(198571);
        if (bundleArr.length > 0) {
            this.param = bundleArr[0];
        }
        Bundle eGl = eGl();
        AppMethodBeat.o(198571);
        return eGl;
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x0140  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0145  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x014a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.os.Bundle eGl() {
        /*
        // Method dump skipped, instructions count: 375
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.qqmail.b.b.eGl():android.os.Bundle");
    }
}
