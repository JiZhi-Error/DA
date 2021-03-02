package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public final class ab implements i {
    int BsA = 0;
    private j BsB = new j() {
        /* class com.tencent.mm.plugin.qqmail.d.ab.AnonymousClass2 */

        @Override // com.tencent.mm.ak.j
        public final void a(int i2, int i3, q qVar) {
            ai aiVar;
            AppMethodBeat.i(122776);
            Log.i("MicroMsg.ShareModeMailAppService", "currentSendFile: %s, offset: %d, totalLen: %d, filesInfo.size: %d", ab.this.Bsw, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(ab.this.Bsv.size()));
            if (i2 >= i3) {
                HashMap<String, String> hashMap = ab.this.Bsy;
                String str = ab.this.Bsx;
                u uVar = (u) qVar;
                if (uVar.rr != null) {
                    aiVar = (ai) uVar.rr.iLL.iLR;
                } else {
                    aiVar = null;
                }
                hashMap.put(str, aiVar.Brm);
                if (ab.this.Bsz != null) {
                    ab.this.Bsv.size();
                }
                if (ab.this.Bsv.isEmpty()) {
                    Log.i("MicroMsg.ShareModeMailAppService", "finished send all files");
                    AppMethodBeat.o(122776);
                    return;
                }
                Log.i("MicroMsg.ShareModeMailAppService", "finished send one file, continue to send another one");
                e remove = ab.this.Bsv.remove(0);
                ab.this.Bsw = remove.fileId;
                ab.this.Bsx = remove.fileName;
                g.aAg().hqi.a(new u(ab.this.Bsx, ab.this.Bsw, this), 0);
            }
            AppMethodBeat.o(122776);
        }
    };
    private a Bsk;
    private Map<String, String> Bsl = new HashMap();
    private Map<String, String> Bsm = new LinkedHashMap();
    private Map<String, String> Bsn = new LinkedHashMap();
    private Map<String, String> Bso = new HashMap();
    private d Bsp = null;
    private c Bsq = null;
    private HashMap<Long, Integer> Bsr = new HashMap<>();
    private HashMap<Long, String> Bss = new HashMap<>();
    private HashMap<String, Integer> Bst = new HashMap<>();
    private int Bsu = 0;
    ArrayList<e> Bsv = new ArrayList<>();
    String Bsw = null;
    String Bsx = null;
    HashMap<String, String> Bsy = new HashMap<>();
    b Bsz;

    public interface a {
    }

    public interface b {
    }

    public interface c {
    }

    public interface d {
    }

    public static class e {
        public String fileId;
        public String fileName;
    }

    public ab() {
        AppMethodBeat.i(122778);
        g.aAg().hqi.a(483, this);
        g.aAg().hqi.a(484, this);
        g.aAg().hqi.a(485, this);
        AppMethodBeat.o(122778);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(122786);
        Log.i("MicroMsg.ShareModeMailAppService", "onSceneEnd, errType: %d, errCode: %d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 != 0 || i3 != 0) {
            Log.e("MicroMsg.ShareModeMailAppService", "errType = %d, errCode = %d", Integer.valueOf(i2), Integer.valueOf(i3));
            if (qVar.getType() == 483) {
                a((q) qVar);
                AppMethodBeat.o(122786);
                return;
            }
            if (this.Bsq != null) {
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.qqmail.d.ab.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(122775);
                        AppMethodBeat.o(122775);
                    }
                });
            }
            AppMethodBeat.o(122786);
        } else if (qVar.getType() == 483) {
            a((q) qVar);
            AppMethodBeat.o(122786);
        } else {
            if (qVar.getType() != 484) {
                qVar.getType();
            }
            AppMethodBeat.o(122786);
        }
    }

    private static ArrayList<Long> l(HashMap<Long, Integer> hashMap) {
        AppMethodBeat.i(122789);
        ArrayList<Long> arrayList = new ArrayList<>();
        for (Long l : hashMap.keySet()) {
            arrayList.add(l);
        }
        AppMethodBeat.o(122789);
        return arrayList;
    }

    private void a(q qVar) {
        AppMethodBeat.i(122790);
        this.Bsu++;
        Log.i("MicroMsg.ShareModeMailAppService", "processCheckImgStatusSceneEnd, checkTimes: %d", Integer.valueOf(this.Bsu));
        Iterator<f> it = qVar.eGp().iterator();
        while (it.hasNext()) {
            f next = it.next();
            long j2 = (long) next.Brl;
            int i2 = next.oTW;
            if (this.Bsr.containsKey(Long.valueOf(j2))) {
                Log.i("MicroMsg.ShareModeMailAppService", "msgSvrId: %d, status: %d", Long.valueOf(j2), Integer.valueOf(i2));
                if (i2 == 0) {
                    this.Bsr.remove(Long.valueOf(j2));
                    if (next.Brm != null) {
                        Log.i("MicroMsg.ShareModeMailAppService", "msgSvrId: %d, attachId: %s", Long.valueOf(j2), next.Brm);
                        this.Bss.put(Long.valueOf(j2), next.Brm);
                        this.Bst.put(next.Brm, Integer.valueOf(next.FileSize));
                    }
                } else {
                    this.Bsr.put(Long.valueOf(j2), Integer.valueOf(i2));
                }
            }
        }
        if (this.Bsr.isEmpty()) {
            Log.i("MicroMsg.ShareModeMailAppService", "all image is in server");
            if (this.Bsk != null) {
                new ArrayList();
            }
            AppMethodBeat.o(122790);
        } else if (this.Bsu < 3) {
            Log.i("MicroMsg.ShareModeMailAppService", "checkTime small than limit, doScene again");
            g.aAg().hqi.a(new q(l(this.Bsr)), 0);
            AppMethodBeat.o(122790);
        } else {
            l(this.Bsr);
            AppMethodBeat.o(122790);
        }
    }
}
