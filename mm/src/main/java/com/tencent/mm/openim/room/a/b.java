package com.tencent.mm.openim.room.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.protocal.protobuf.cvu;
import com.tencent.mm.protocal.protobuf.cvv;
import com.tencent.mm.protocal.protobuf.xh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public interface b {

    public static class a {
        public static LinkedList<cvt> aM(List<String> list) {
            AppMethodBeat.i(151319);
            LinkedList<cvt> linkedList = new LinkedList<>();
            for (String str : list) {
                cvt cvt = new cvt();
                cvt.userName = str;
                linkedList.add(cvt);
            }
            AppMethodBeat.o(151319);
            return linkedList;
        }
    }

    public static class c {
        public static as a(as asVar, cvu cvu) {
            AppMethodBeat.i(151322);
            asVar.setUsername(cvu.userName);
            asVar.setNickname(cvu.nickName);
            AppMethodBeat.o(151322);
            return asVar;
        }

        public static LinkedList<xh> aN(List<cvv> list) {
            AppMethodBeat.i(151323);
            LinkedList<xh> linkedList = new LinkedList<>();
            if (list == null) {
                AppMethodBeat.o(151323);
                return linkedList;
            }
            for (cvv cvv : list) {
                xh xhVar = new xh();
                xhVar.UserName = cvv.userName;
                xhVar.oUJ = cvv.nickName;
                xhVar.Liq = cvv.gCv;
                xhVar.Lir = cvv.LpH;
                xhVar.Lis = cvv.LpI;
                xhVar.Lit = cvv.MBo;
                xhVar.Liu = cvv.MBq;
                linkedList.add(xhVar);
            }
            AppMethodBeat.o(151323);
            return linkedList;
        }
    }

    /* renamed from: com.tencent.mm.openim.room.a.b$b  reason: collision with other inner class name */
    public static class C0499b {
        public final List<String> dSX = new ArrayList();
        public final List<String> dSZ = new ArrayList();
        public final List<String> dTa = new ArrayList();
        public final List<String> grX = new ArrayList();
        public final List<String> grY = new ArrayList();
        public final List<String> grZ = new ArrayList();

        public C0499b() {
            AppMethodBeat.i(151320);
            AppMethodBeat.o(151320);
        }

        public final void q(LinkedList<cvu> linkedList) {
            AppMethodBeat.i(151321);
            Iterator<cvu> it = linkedList.iterator();
            while (it.hasNext()) {
                cvu next = it.next();
                int i2 = next.status;
                if (i2 == 0) {
                    this.grX.add(next.userName);
                } else if (i2 == 3) {
                    Log.d("OpenIMChatRoomMember.Classifier", " blacklist : " + next.userName);
                    this.grY.add(next.userName);
                } else if (i2 == 1) {
                    Log.d("OpenIMChatRoomMember.Classifier", " not user : " + next.userName);
                    this.dSZ.add(next.userName);
                } else if (i2 == 2) {
                    Log.d("OpenIMChatRoomMember.Classifier", " invalid username : " + next.userName);
                    this.dSX.add(next.userName);
                } else if (i2 == 4) {
                    Log.d("OpenIMChatRoomMember.Classifier", " verify user : " + next.userName);
                    this.dTa.add(next.userName);
                } else if (i2 != 5) {
                    if (i2 == 6) {
                        this.grZ.add(next.userName);
                    } else {
                        Log.w("OpenIMChatRoomMember.Classifier", "unknown member status : status = ".concat(String.valueOf(i2)));
                    }
                }
            }
            AppMethodBeat.o(151321);
        }
    }
}
