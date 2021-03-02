package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.p;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.pluginsdk.model.n;
import java.io.OutputStream;
import java.util.concurrent.ExecutorService;

public final class ba extends n<p, String, Boolean> {
    private String DIl;
    private String DIp = "";
    private String fileName;
    private String iLe;
    private String mediaId;
    private OutputStream output = null;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.tencent.mm.pluginsdk.model.n
    public final /* synthetic */ void onPostExecute(Boolean bool) {
        AppMethodBeat.i(95988);
        Boolean bool2 = bool;
        super.onPostExecute(bool2);
        bool2.booleanValue();
        aj.faJ().s(this.DIp, -1, true);
        AppMethodBeat.o(95988);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    @Override // com.tencent.mm.pluginsdk.model.n
    public final /* bridge */ /* synthetic */ void onProgressUpdate(String[] strArr) {
        AppMethodBeat.i(202792);
        super.onProgressUpdate(strArr);
        AppMethodBeat.o(202792);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    @Override // com.tencent.mm.pluginsdk.model.n
    public final /* synthetic */ void z(p[] pVarArr) {
        AppMethodBeat.i(95989);
        p[] pVarArr2 = pVarArr;
        super.z(pVarArr2);
        p pVar = pVarArr2[0];
        if (pVar != null) {
            this.mediaId = pVar.mediaId;
            this.DIl = ar.ki(aj.getAccSnsPath(), this.mediaId);
            this.DIp = r.cr(pVar.requestType, this.mediaId);
            this.iLe = "sns_tmpt_" + this.mediaId;
            this.fileName = "snst_" + this.mediaId;
        }
        AppMethodBeat.o(95989);
    }

    @Override // com.tencent.mm.pluginsdk.model.n
    public final ExecutorService eGk() {
        AppMethodBeat.i(179117);
        ExecutorService faA = aj.faA();
        AppMethodBeat.o(179117);
        return faA;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    @Override // com.tencent.mm.pluginsdk.model.n
    public final /* bridge */ /* synthetic */ Boolean doInBackground(p[] pVarArr) {
        return Boolean.TRUE;
    }
}
