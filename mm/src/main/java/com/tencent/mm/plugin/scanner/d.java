package com.tencent.mm.plugin.scanner;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.co.f;
import com.tencent.mm.protocal.protobuf.bwr;
import com.tencent.mm.protocal.protobuf.bws;
import com.tencent.mm.protocal.protobuf.ku;
import com.tencent.mm.protocal.protobuf.kv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.e;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.j.c;
import java.util.LinkedList;

public final class d {
    public final e<bws> bZ(int i2, String str) {
        AppMethodBeat.i(151552);
        Integer valueOf = Integer.valueOf(i2);
        f b2 = new f().L(valueOf, str).b(new a<bws, c<Integer, String>>() {
            /* class com.tencent.mm.plugin.scanner.d.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.vending.c.a
            public final /* synthetic */ bws call(c<Integer, String> cVar) {
                AppMethodBeat.i(151551);
                c<Integer, String> cVar2 = cVar;
                final b hdH = g.hdH();
                int intValue = ((Integer) cVar2.get(0)).intValue();
                String str = (String) cVar2.get(1);
                d.a aVar = new d.a();
                aVar.iLN = new ku();
                aVar.iLO = new kv();
                aVar.uri = "/cgi-bin/micromsg-bin/batchgeturlinfo";
                aVar.funcId = 3964;
                com.tencent.mm.ak.d aXF = aVar.aXF();
                ku kuVar = (ku) aXF.iLK.iLR;
                bwr bwr = new bwr();
                bwr.Url = str;
                bwr.Mcw = g.cj(intValue, str);
                kuVar.Scene = 1;
                LinkedList<bwr> linkedList = new LinkedList<>();
                linkedList.add(bwr);
                kuVar.KOL = linkedList.size();
                kuVar.xKD = linkedList;
                aa.a(aXF, new aa.a() {
                    /* class com.tencent.mm.plugin.scanner.d.AnonymousClass1.AnonymousClass1 */

                    @Override // com.tencent.mm.ak.aa.a
                    public final int a(int i2, int i3, String str, com.tencent.mm.ak.d dVar, q qVar) {
                        AppMethodBeat.i(151550);
                        if (i2 == 0 && i3 == 0) {
                            kv kvVar = (kv) dVar.iLL.iLR;
                            if (kvVar == null || kvVar.xKD == null || kvVar.xKD.size() == 0) {
                                Log.i("MicroMsg.FetchQRCodeInfoService", "resp error");
                                AppMethodBeat.o(151550);
                            } else {
                                hdH.G(kvVar.xKD.getFirst());
                                AppMethodBeat.o(151550);
                            }
                        } else {
                            Log.i("MicroMsg.FetchQRCodeInfoService", "fetchQRCodeInfo errType:%d errCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
                            AppMethodBeat.o(151550);
                        }
                        return 0;
                    }
                }, true);
                AppMethodBeat.o(151551);
                return null;
            }
        });
        AppMethodBeat.o(151552);
        return b2;
    }
}
