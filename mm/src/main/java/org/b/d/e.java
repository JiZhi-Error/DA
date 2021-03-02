package org.b.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.b.g.c;

public final class e {
    public final List<d> Uil;

    public e() {
        AppMethodBeat.i(40530);
        this.Uil = new ArrayList();
        AppMethodBeat.o(40530);
    }

    public e(List<d> list) {
        AppMethodBeat.i(40531);
        this.Uil = new ArrayList(list);
        AppMethodBeat.o(40531);
    }

    public e(Map<String, String> map) {
        this();
        AppMethodBeat.i(40532);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            this.Uil.add(new d(entry.getKey(), entry.getValue()));
        }
        AppMethodBeat.o(40532);
    }

    public final String hQj() {
        AppMethodBeat.i(40533);
        if (this.Uil.size() == 0) {
            AppMethodBeat.o(40533);
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (d dVar : this.Uil) {
            sb.append('&').append(dVar.hQi());
        }
        String substring = sb.toString().substring(1);
        AppMethodBeat.o(40533);
        return substring;
    }

    public final void a(e eVar) {
        AppMethodBeat.i(40534);
        this.Uil.addAll(eVar.Uil);
        AppMethodBeat.o(40534);
    }

    public final void bvv(String str) {
        AppMethodBeat.i(40535);
        if (str != null && str.length() > 0) {
            for (String str2 : str.split("&")) {
                String[] split = str2.split("=");
                this.Uil.add(new d(c.decode(split[0]), split.length > 1 ? c.decode(split[1]) : ""));
            }
        }
        AppMethodBeat.o(40535);
    }
}
