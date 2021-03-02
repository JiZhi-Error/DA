package com.tencent.mm.plugin.subapp.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public final class b implements h, i {
    private Queue<a> FJJ = null;
    private boolean FJK = false;

    @Override // com.tencent.mm.ak.h
    public final h.b b(h.a aVar) {
        AppMethodBeat.i(28920);
        String a2 = z.a(aVar.heO.KHn);
        if (this.FJJ == null) {
            this.FJJ = new LinkedList();
        }
        a aVar2 = new a(a2);
        if (aVar2.jVt != null) {
            this.FJJ.offer(aVar2);
            fte();
        }
        AppMethodBeat.o(28920);
        return null;
    }

    /* access modifiers changed from: package-private */
    public static class a {
        public Queue<String> FJL = new LinkedList();
        public String jVt;

        a(String str) {
            AppMethodBeat.i(28919);
            this.jVt = str;
            Log.d("MicroMsg.PushMessageExtension", "DoSceneStruct:".concat(String.valueOf(str)));
            ArrayList<com.tencent.mm.pluginsdk.k.a.a> cm = com.tencent.mm.pluginsdk.k.a.a.cm(MMApplicationContext.getContext(), str);
            if (cm == null || cm.size() <= 0) {
                Log.e("MicroMsg.PushMessageExtension", "Parse Message Failed !");
                AppMethodBeat.o(28919);
                return;
            }
            for (int i2 = 0; i2 < cm.size(); i2++) {
                Map<String, String> map = cm.get(i2).Kaz;
                if (map != null) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        this.FJL.offer(entry.getValue());
                    }
                }
            }
            AppMethodBeat.o(28919);
        }
    }

    private void fte() {
        AppMethodBeat.i(28921);
        if (this.FJK) {
            AppMethodBeat.o(28921);
        } else if (this.FJJ.size() == 0) {
            AppMethodBeat.o(28921);
        } else {
            a peek = this.FJJ.peek();
            if (peek.FJL.size() == 0) {
                this.FJJ.poll();
                bg.aVF();
                c.azQ().set(8193, peek.jVt);
                bg.aVF();
                c.azQ().set(8449, Long.valueOf(Util.nowSecond()));
                AppMethodBeat.o(28921);
                return;
            }
            String peek2 = peek.FJL.peek();
            if (peek2 == null || peek2.length() <= 0) {
                AppMethodBeat.o(28921);
                return;
            }
            this.FJK = true;
            a aVar = new a(peek2);
            bg.azz().a(141, this);
            bg.azz().a(aVar, 0);
            AppMethodBeat.o(28921);
        }
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(28922);
        if (qVar.getType() != 141) {
            this.FJK = false;
            AppMethodBeat.o(28922);
            return;
        }
        bg.azz().b(141, this);
        String str2 = ((a) qVar).url;
        a peek = this.FJJ.peek();
        if (peek == null || peek.FJL.size() == 0) {
            Log.e("MicroMsg.PushMessageExtension", "getDoSceneQueue failed ! reset queue!");
            this.FJJ = new LinkedList();
            this.FJK = false;
            AppMethodBeat.o(28922);
        } else if (peek.FJL.size() == 0) {
            Log.e("MicroMsg.PushMessageExtension", "get imgQueue failed ! ignore this message");
            this.FJJ.poll();
            this.FJK = false;
            AppMethodBeat.o(28922);
        } else if (!peek.FJL.peek().equals(str2)) {
            Log.e("MicroMsg.PushMessageExtension", "check img url failed ! ignore this message");
            this.FJJ.poll();
            this.FJK = false;
            AppMethodBeat.o(28922);
        } else if (i2 == 0 && i3 == 0) {
            peek.FJL.poll();
            this.FJK = false;
            fte();
            AppMethodBeat.o(28922);
        } else {
            Log.e("MicroMsg.PushMessageExtension", "down failed [" + i2 + "," + i3 + "] ignore this message : img:[" + str2 + "] ");
            this.FJJ.poll();
            this.FJK = false;
            AppMethodBeat.o(28922);
        }
    }

    @Override // com.tencent.mm.ak.h
    public final void b(h.c cVar) {
    }
}
