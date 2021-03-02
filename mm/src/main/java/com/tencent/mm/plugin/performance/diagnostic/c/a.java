package com.tencent.mm.plugin.performance.diagnostic.c;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.performance.diagnostic.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;

public final class a extends a.AbstractC1572a {
    private final String ATS;
    private final String ATT;
    private final String ATU;

    public a(com.tencent.mm.plugin.performance.diagnostic.a<? extends com.tencent.wxperf.jni.a, ? extends a.AbstractC1572a> aVar) {
        super(aVar);
        AppMethodBeat.i(201071);
        this.ATS = aVar.eBC() + ".$hook";
        this.ATT = aVar.eBC() + ".$ignore";
        this.ATU = aVar.eBC() + ".$thread";
        AppMethodBeat.o(201071);
    }

    @Override // com.tencent.mm.plugin.performance.diagnostic.a.AbstractC1572a
    public final void aB(Map<String, String> map) {
        AppMethodBeat.i(201072);
        super.aB(map);
        String str = map.get(this.ATS);
        if (TextUtils.isEmpty(str)) {
            Log.e("MicroMsg.PthreadHookConfigStg", "ERROR(PthreadHook): hook regex is blank");
            AppMethodBeat.o(201072);
            return;
        }
        this.djK.encode(this.ATS, str);
        this.djK.encode(this.ATT, map.get(this.ATT));
        this.djK.encode(this.ATU, map.get(this.ATU));
        AppMethodBeat.o(201072);
    }

    public final String eBZ() {
        AppMethodBeat.i(201073);
        String aJV = aJV("");
        AppMethodBeat.o(201073);
        return aJV;
    }

    public final String aJV(String str) {
        AppMethodBeat.i(201074);
        String decodeString = this.djK.decodeString(this.ATS, str);
        AppMethodBeat.o(201074);
        return decodeString;
    }

    public final String eCa() {
        AppMethodBeat.i(201075);
        String decodeString = this.djK.decodeString(this.ATT, null);
        AppMethodBeat.o(201075);
        return decodeString;
    }

    public final String eCm() {
        AppMethodBeat.i(201076);
        String aJW = aJW("");
        AppMethodBeat.o(201076);
        return aJW;
    }

    public final String aJW(String str) {
        AppMethodBeat.i(201077);
        String decodeString = this.djK.decodeString(this.ATU, str);
        AppMethodBeat.o(201077);
        return decodeString;
    }

    @Override // com.tencent.mm.plugin.performance.diagnostic.a.AbstractC1572a
    public final long eBV() {
        return -1;
    }
}
