package com.tencent.mm.plugin.flutter.a;

import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.g;
import com.tencent.mm.ab.i;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public final class c {
    public LinkedHashMap<String, Object> mzT;
    public String wJd;
    public String wJe;
    public HashMap<String, Object> wJf;
    public int wJg = 0;
    public boolean wJh = false;

    public c() {
    }

    public c(String str, String str2, LinkedHashMap<String, Object> linkedHashMap) {
        this.wJd = str;
        this.wJe = str2;
        this.mzT = linkedHashMap;
    }

    public final String bua() {
        AppMethodBeat.i(123738);
        i iVar = new i();
        try {
            iVar.h("plugin", this.wJd);
            iVar.h("entry", this.wJe);
            if (this.mzT != null) {
                i iVar2 = new i();
                for (Map.Entry<String, Object> entry : this.mzT.entrySet()) {
                    iVar2.h(entry.getKey(), entry.getValue());
                }
                iVar.h(NativeProtocol.WEB_DIALOG_PARAMS, iVar2);
            }
            if (this.wJf != null) {
                i iVar3 = new i();
                for (Map.Entry<String, Object> entry2 : this.wJf.entrySet()) {
                    iVar3.h(entry2.getKey(), entry2.getValue());
                }
                iVar.h("initParams", iVar3);
            }
            iVar.U("parentPageType", this.wJg);
            iVar.w("isInitRoute", this.wJh);
        } catch (g e2) {
        }
        String iVar4 = iVar.toString();
        AppMethodBeat.o(123738);
        return iVar4;
    }

    public final String toString() {
        AppMethodBeat.i(123739);
        String bua = bua();
        AppMethodBeat.o(123739);
        return bua;
    }
}
