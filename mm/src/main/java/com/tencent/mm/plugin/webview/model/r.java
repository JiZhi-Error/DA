package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.g.a.yb;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.protocal.protobuf.bwf;
import com.tencent.mm.protocal.protobuf.bwg;
import com.tencent.mm.protocal.protobuf.ekr;
import com.tencent.mm.protocal.protobuf.eks;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public final class r {
    private int IXM = 2000;
    private int IXN = 50;
    private LinkedList<ekr> IXO = null;
    ArrayList<Integer> IXP = null;
    HashMap<String, String> IXQ = null;

    public final boolean d(LinkedList<ekr> linkedList, int i2, int i3) {
        AppMethodBeat.i(78892);
        if (linkedList.size() == 0) {
            Log.d("MicroMsg.NetSceneGetTransTextXWeb", "translate: reqStringList is empty!!");
            AppMethodBeat.o(78892);
            return false;
        }
        if (i2 <= 0) {
            i2 = this.IXM;
        }
        if (i3 <= 0) {
            i3 = this.IXN;
        }
        Log.d("MicroMsg.NetSceneGetTransTextXWeb", "translate: all cgi begin !! to translate reqStringList.size() = " + linkedList.size() + " maxByte = " + i2 + " maxCount = " + i3);
        this.IXQ = new HashMap<>();
        this.IXO = linkedList;
        this.IXP = new ArrayList<>();
        LinkedList<ekr> linkedList2 = new LinkedList<>();
        for (int i4 = 0; i4 < this.IXO.size(); i4++) {
            ekr ekr = this.IXO.get(i4);
            int length = ekr.NjW.getBytes().length;
            if (length > i2) {
                Log.d("MicroMsg.NetSceneGetTransTextXWeb", "translate: translate string is too long need cut !! len = ".concat(String.valueOf(length)));
            } else {
                linkedList2.add(ekr);
                if (linkedList2.size() == i3 || i4 == this.IXO.size() - 1) {
                    Integer bz = bz(linkedList2);
                    if (bz == null) {
                        Log.e("MicroMsg.NetSceneGetTransTextXWeb", "translate: do cgi err");
                        AppMethodBeat.o(78892);
                        return false;
                    }
                    this.IXP.add(bz);
                    linkedList2 = new LinkedList<>();
                }
            }
        }
        AppMethodBeat.o(78892);
        return true;
    }

    private Integer bz(LinkedList<ekr> linkedList) {
        AppMethodBeat.i(78893);
        try {
            bwf bwf = new bwf();
            bwf.Mcg = linkedList;
            bwf.oTy = linkedList.size();
            d.a aVar = new d.a();
            aVar.iLN = bwf;
            aVar.iLO = new bwg();
            aVar.uri = "/cgi-bin/micromsg-bin/gettranstext";
            aVar.funcId = 631;
            aVar.iLP = 0;
            aVar.respCmdId = 0;
            d aXF = aVar.aXF();
            final Integer valueOf = Integer.valueOf(bwf.hashCode());
            Log.i("MicroMsg.NetSceneGetTransTextXWeb", "translate: reqStringList size = " + linkedList.size() + " hashcode = " + valueOf);
            IPCRunCgi.a(aXF, new IPCRunCgi.a() {
                /* class com.tencent.mm.plugin.webview.model.r.AnonymousClass1 */

                @Override // com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a
                public final void a(int i2, int i3, String str, d dVar) {
                    AppMethodBeat.i(78891);
                    if (i2 == 0 && i3 == 0) {
                        r rVar = r.this;
                        Integer num = valueOf;
                        bwg bwg = (bwg) dVar.iLL.iLR;
                        Log.d("MicroMsg.NetSceneGetTransTextXWeb", "translate: cgi return!!  processRespData hashcode = " + num + "  response.MsgList.size() = " + bwg.Mcg.size());
                        if (!rVar.IXP.remove(num)) {
                            Log.e("MicroMsg.NetSceneGetTransTextXWeb", "translate: err cgi return!!");
                            AppMethodBeat.o(78891);
                            return;
                        }
                        String str2 = "";
                        for (int i4 = 0; i4 < bwg.Mcg.size(); i4++) {
                            eks eks = bwg.Mcg.get(i4);
                            if (eks == null || eks.Ret != 0 || eks.NjY == null || eks.NjY.trim().length() == 0) {
                                Log.e("MicroMsg.NetSceneGetTransTextXWeb", "translate: some translate message err!! ");
                                if (eks != null) {
                                    Log.d("MicroMsg.NetSceneGetTransTextXWeb", "translate: some translate message err!! rsp ClientMsgID = " + eks.NjV + " TranslatedText = " + eks.NjY + " ret = " + eks.Ret);
                                }
                            } else {
                                if (eks.Myy != null && eks.Myy.length() > 0) {
                                    str2 = eks.Myy;
                                }
                                rVar.IXQ.put(String.valueOf(eks.NjV), eks.NjY);
                            }
                        }
                        if (rVar.IXP.size() == 0) {
                            Log.d("MicroMsg.NetSceneGetTransTextXWeb", "translate: all cgi finish !! TranslateMessageListResultEvent publish!  translated HashMapAll.size() = " + rVar.IXQ.size());
                            rVar.IXQ.put("BrandWording", str2);
                            yb ybVar = new yb();
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(rVar.IXQ);
                            ybVar.eet.eeu = arrayList;
                            EventCenter.instance.publish(ybVar);
                        }
                        AppMethodBeat.o(78891);
                        return;
                    }
                    Log.i("MicroMsg.NetSceneGetTransTextXWeb", "translate: onSceneEnd errType = %d, errCode = %d ,errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                    AppMethodBeat.o(78891);
                }
            });
            AppMethodBeat.o(78893);
            return valueOf;
        } catch (Exception e2) {
            Log.e("MicroMsg.NetSceneGetTransTextXWeb", "translate: do cgi failed！！！");
            AppMethodBeat.o(78893);
            return null;
        }
    }
}
