package com.tencent.mm.plugin.backup.g;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.hardcoder.g;
import com.tencent.mm.jniinterface.AesEcb;
import com.tencent.mm.plugin.backup.f.j;
import com.tencent.mm.plugin.backup.i.x;
import com.tencent.mm.plugin.backup.i.y;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.protobuf.is;
import com.tencent.mm.protocal.protobuf.it;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.io.InputStream;
import java.util.HashSet;
import java.util.LinkedList;

public final class c extends b {
    private static String TAG = "MicroMsg.BackupDataPushScene";
    private i gNh;
    private y oPA = new y();
    private int oPB = 0;
    private a oPC = null;
    private PByteArray oPm = new PByteArray();
    public x oPz = new x();

    public interface b {
        void g(boolean z, String str, int i2);
    }

    /* renamed from: com.tencent.mm.plugin.backup.g.c$c  reason: collision with other inner class name */
    public interface AbstractC0848c {
        void a(c cVar);
    }

    public static void a(b bVar, AbstractC0848c cVar, String str, String str2, byte[] bArr) {
        int i2;
        AppMethodBeat.i(21706);
        a aVar = new a(str2);
        if (aVar.iKP <= 0) {
            i2 = 1;
        } else {
            i2 = (int) (((long) aVar.iKP) / g.ACTION_MINI_PROGRAM_LAUNCH);
            if (((long) aVar.iKP) % g.ACTION_MINI_PROGRAM_LAUNCH != 0) {
                i2++;
            }
        }
        for (int i3 = 0; i3 < i2; i3++) {
            cVar.a(new c(bVar, str, aVar, bArr));
        }
        AppMethodBeat.o(21706);
    }

    public static void a(b bVar, AbstractC0848c cVar, String str, LinkedList<is> linkedList, byte[] bArr) {
        AppMethodBeat.i(21707);
        cVar.a(new c(bVar, str, linkedList, bArr));
        AppMethodBeat.o(21707);
    }

    private c(final b bVar, String str, a aVar, byte[] bArr) {
        Pair pair;
        AppMethodBeat.i(21708);
        this.oPz.oUz = str;
        this.oPz.oUA = 2;
        this.gNh = new i() {
            /* class com.tencent.mm.plugin.backup.g.c.AnonymousClass1 */

            @Override // com.tencent.mm.ak.i
            public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                AppMethodBeat.i(21700);
                c cVar = (c) qVar;
                bVar.g(a.a(cVar.oPC, cVar), cVar.oPz.oUz, cVar.cgH());
                AppMethodBeat.o(21700);
            }
        };
        this.oPC = aVar;
        a.b(aVar, this);
        a aVar2 = this.oPC;
        if (aVar2.iKP <= 0) {
            pair = new Pair(0, new byte[0]);
        } else {
            int i2 = (int) (((long) (aVar2.iKP - aVar2.offset)) > g.ACTION_MINI_PROGRAM_LAUNCH ? g.ACTION_MINI_PROGRAM_LAUNCH : (long) (aVar2.iKP - aVar2.offset));
            byte[] bArr2 = new byte[i2];
            aVar2.b(bArr2, ((long) i2) < g.ACTION_MINI_PROGRAM_LAUNCH);
            int i3 = aVar2.offset;
            aVar2.offset += i2;
            pair = new Pair(Integer.valueOf(i3), bArr2);
        }
        if (pair.second == null || pair.first == null) {
            Log.w(TAG, "BackupDataPushScene media backFileOp getNext error, file path:%s", this.oPC.filePath);
            this.oPz.oTm = null;
            AppMethodBeat.o(21708);
            return;
        }
        byte[] bArr3 = (byte[]) pair.second;
        this.oPz.oUB = this.oPC.iKP;
        this.oPz.oUC = ((Integer) pair.first).intValue();
        this.oPz.oUD = this.oPz.oUC + bArr3.length;
        this.oPz.oTm = a(bArr3, this.oPz.oUD == this.oPz.oUB, bArr);
        Log.d(TAG, "BackupDataPushScene msgid:%s, size:%d", str, Integer.valueOf(this.oPz.oUB));
        cgG();
        AppMethodBeat.o(21708);
    }

    private c(final b bVar, String str, LinkedList<is> linkedList, byte[] bArr) {
        byte[] bArr2;
        AppMethodBeat.i(21709);
        this.oPz.oUz = str;
        this.oPz.oUA = 1;
        this.gNh = new i() {
            /* class com.tencent.mm.plugin.backup.g.c.AnonymousClass2 */

            @Override // com.tencent.mm.ak.i
            public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                AppMethodBeat.i(21701);
                c cVar = (c) qVar;
                bVar.g(true, cVar.oPz.oUz, cVar.cgH());
                AppMethodBeat.o(21701);
            }
        };
        try {
            it itVar = new it();
            itVar.oTA = linkedList;
            itVar.oTz = linkedList.size();
            bArr2 = itVar.toByteArray();
        } catch (Exception e2) {
            String str2 = TAG;
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(linkedList == null ? -1 : linkedList.size());
            objArr[1] = e2.getMessage();
            Log.e(str2, "BackupDataPushScene text, BakChatMsgList to buf error, list size[%d], errMsg:%s", objArr);
            bArr2 = null;
        }
        bArr2 = bArr2 == null ? new byte[0] : bArr2;
        this.oPz.oUC = 0;
        this.oPz.oUD = bArr2.length;
        this.oPz.oUB = bArr2.length;
        this.oPz.oTm = a(bArr2, true, bArr);
        cgG();
        AppMethodBeat.o(21709);
    }

    @Override // com.tencent.mm.plugin.backup.g.b
    public final void Bm(int i2) {
        AppMethodBeat.i(21710);
        this.gNh.onSceneEnd(0, this.oPA.oTW, "", this);
        AppMethodBeat.o(21710);
    }

    private void cgG() {
        AppMethodBeat.i(21711);
        this.oPB = cgC();
        try {
            j.a(this.oPz.toByteArray(), this.oPB, (short) getType(), this.oPm, b.oIY);
            a(this.oPB, this.oPm);
            AppMethodBeat.o(21711);
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "PacketBackupDataPush to buf fail:%s", e2.toString());
            AppMethodBeat.o(21711);
        }
    }

    @Override // com.tencent.mm.plugin.backup.g.b
    public final boolean cgA() {
        AppMethodBeat.i(21712);
        byte[] bArr = this.oPm.value;
        int i2 = this.oPB;
        if (b.oPq != null) {
            Log.i("MicroMsg.BackupBaseScene", "doSceneSameThread ret[%d], sendSeq[%d], type[%d], buflen[%d]", Integer.valueOf(b.oPq.m(i2, bArr)), Integer.valueOf(i2), Integer.valueOf(getType()), Integer.valueOf(bArr.length));
        }
        AppMethodBeat.o(21712);
        return true;
    }

    private static com.tencent.mm.bw.b a(byte[] bArr, boolean z, byte[] bArr2) {
        AppMethodBeat.i(21713);
        if (Util.getLength(bArr2) <= 0 || Util.getLength(bArr) <= 0) {
            com.tencent.mm.bw.b bVar = new com.tencent.mm.bw.b(bArr);
            AppMethodBeat.o(21713);
            return bVar;
        }
        com.tencent.mm.bw.b bVar2 = new com.tencent.mm.bw.b(AesEcb.aesCryptEcb(bArr, bArr2, true, z));
        AppMethodBeat.o(21713);
        return bVar2;
    }

    public final int cgH() {
        if (this.oPm.value == null) {
            return 0;
        }
        return this.oPm.value.length;
    }

    @Override // com.tencent.mm.plugin.backup.g.b
    public final com.tencent.mm.bw.a cgq() {
        return this.oPA;
    }

    @Override // com.tencent.mm.plugin.backup.g.b
    public final com.tencent.mm.bw.a cgr() {
        return this.oPz;
    }

    @Override // com.tencent.mm.plugin.backup.g.b, com.tencent.mm.ak.q
    public final int getType() {
        return 6;
    }

    /* access modifiers changed from: package-private */
    public static class a {
        private static String TAG = "MicroMsg.BackupDataPushScene.BackFileOp";
        String filePath = null;
        int iKP = 0;
        private HashSet<c> oPF = new HashSet<>();
        private InputStream oPG = null;
        int offset = 0;

        public a(String str) {
            AppMethodBeat.i(21702);
            this.filePath = str;
            this.iKP = (int) s.boW(this.filePath);
            if (this.iKP < 0) {
                this.iKP = 0;
            }
            AppMethodBeat.o(21702);
        }

        /* access modifiers changed from: package-private */
        public final boolean b(byte[] bArr, boolean z) {
            AppMethodBeat.i(21703);
            try {
                if (this.oPG == null) {
                    this.oPG = s.openRead(this.filePath);
                }
                if (this.oPG.read(bArr) != bArr.length) {
                    AppMethodBeat.o(21703);
                    return false;
                }
                if (z) {
                    this.oPG.close();
                }
                AppMethodBeat.o(21703);
                return true;
            } catch (Exception e2) {
                AppMethodBeat.o(21703);
                return false;
            }
        }

        static /* synthetic */ boolean a(a aVar, c cVar) {
            AppMethodBeat.i(21704);
            if (!aVar.oPF.contains(cVar) && cVar.oPz.oUA == 2) {
                Log.e(TAG, "checkSceneAllFinish Error!! media scene not in sceneHashSet");
            }
            aVar.oPF.remove(cVar);
            boolean isEmpty = aVar.oPF.isEmpty();
            AppMethodBeat.o(21704);
            return isEmpty;
        }

        static /* synthetic */ void b(a aVar, c cVar) {
            AppMethodBeat.i(21705);
            aVar.oPF.add(cVar);
            AppMethodBeat.o(21705);
        }
    }
}
