package com.tencent.mm.pluginsdk.ui;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.j;
import java.util.HashMap;
import java.util.Map;

public final class b implements j.a, j.b {
    private final j.a Kbe;
    private final HashMap<String, j.a> gKR = new HashMap<>();

    public b(j.a aVar) {
        AppMethodBeat.i(223831);
        this.Kbe = aVar;
        AppMethodBeat.o(223831);
    }

    public final j.a gow() {
        return this.Kbe;
    }

    public final boolean a(String str, j.a aVar) {
        boolean z;
        AppMethodBeat.i(223832);
        synchronized (this.gKR) {
            try {
                z = this.gKR.put(str, aVar) == null;
            } finally {
                AppMethodBeat.o(223832);
            }
        }
        return z;
    }

    public final void beq(String str) {
        AppMethodBeat.i(223833);
        synchronized (this.gKR) {
            try {
                this.gKR.remove(str);
            } finally {
                AppMethodBeat.o(223833);
            }
        }
    }

    @Override // com.tencent.mm.pluginsdk.ui.j.a
    public final Bitmap a(String str, int i2, int i3, int i4) {
        AppMethodBeat.i(223834);
        Bitmap a2 = ber(str).a(str, i2, i3, i4);
        AppMethodBeat.o(223834);
        return a2;
    }

    @Override // com.tencent.mm.pluginsdk.ui.j.a
    public final Bitmap fZ(String str) {
        AppMethodBeat.i(223835);
        Bitmap fZ = ber(str).fZ(str);
        AppMethodBeat.o(223835);
        return fZ;
    }

    @Override // com.tencent.mm.pluginsdk.ui.j.a
    public final Bitmap ga(String str) {
        AppMethodBeat.i(223836);
        Bitmap ga = ber(str).ga(str);
        AppMethodBeat.o(223836);
        return ga;
    }

    @Override // com.tencent.mm.pluginsdk.ui.j.a
    public final Bitmap Wg() {
        AppMethodBeat.i(223837);
        Bitmap Wg = this.Kbe.Wg();
        AppMethodBeat.o(223837);
        return Wg;
    }

    @Override // com.tencent.mm.pluginsdk.ui.j.a
    public final void a(j jVar) {
        AppMethodBeat.i(223838);
        ber(jVar.getTag()).a(jVar);
        this.Kbe.a(jVar);
        AppMethodBeat.o(223838);
    }

    private j.a ber(String str) {
        AppMethodBeat.i(223839);
        if (str == null) {
            j.a aVar = this.Kbe;
            AppMethodBeat.o(223839);
            return aVar;
        }
        synchronized (this.gKR) {
            try {
                for (Map.Entry<String, j.a> entry : this.gKR.entrySet()) {
                    if (str.endsWith(entry.getKey())) {
                        return entry.getValue();
                    }
                }
                j.a aVar2 = this.Kbe;
                AppMethodBeat.o(223839);
                return aVar2;
            } finally {
                AppMethodBeat.o(223839);
            }
        }
    }

    @Override // com.tencent.mm.pluginsdk.ui.j.b
    public final boolean aub(String str) {
        AppMethodBeat.i(223840);
        j.a ber = ber(str);
        if (ber instanceof j.b) {
            boolean aub = ((j.b) ber).aub(str);
            AppMethodBeat.o(223840);
            return aub;
        }
        AppMethodBeat.o(223840);
        return true;
    }
}
