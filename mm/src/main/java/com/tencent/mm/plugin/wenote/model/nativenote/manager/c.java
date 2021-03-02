package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.wenote.c.b;
import com.tencent.mm.plugin.wenote.model.a.d;
import com.tencent.mm.plugin.wenote.model.a.f;
import com.tencent.mm.plugin.wenote.model.a.g;
import com.tencent.mm.plugin.wenote.model.a.i;
import com.tencent.mm.plugin.wenote.model.a.k;
import com.tencent.mm.plugin.wenote.model.a.l;
import com.tencent.mm.plugin.wenote.model.a.o;
import com.tencent.mm.plugin.wenote.model.h;
import com.tencent.mm.plugin.wenote.model.nativenote.b.a;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public class c {
    private static volatile c JIc = null;
    public a JId = null;
    public boolean JIe = false;
    public ArrayList<com.tencent.mm.plugin.wenote.model.a.c> mDataList = null;
    public aml qQq = null;
    public int qQr = 0;
    public int qQs = 0;
    public int qQt = 0;

    private c() {
    }

    public static c gjL() {
        AppMethodBeat.i(30410);
        if (JIc == null) {
            synchronized (c.class) {
                try {
                    if (JIc == null) {
                        JIc = new c();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(30410);
                    throw th;
                }
            }
        }
        c cVar = JIc;
        AppMethodBeat.o(30410);
        return cVar;
    }

    public final void gjM() {
        AppMethodBeat.i(179744);
        this.JId = null;
        if (this.mDataList != null) {
            Iterator<com.tencent.mm.plugin.wenote.model.a.c> it = this.mDataList.iterator();
            while (it.hasNext()) {
                com.tencent.mm.plugin.wenote.model.a.c next = it.next();
                next.JHL = null;
                next.JHJ = null;
                next.JHK = null;
            }
        }
        AppMethodBeat.o(179744);
    }

    public final int size() {
        AppMethodBeat.i(30411);
        if (this.mDataList != null) {
            int size = this.mDataList.size();
            AppMethodBeat.o(30411);
            return size;
        }
        AppMethodBeat.o(30411);
        return 0;
    }

    public final com.tencent.mm.plugin.wenote.model.a.c ahp(int i2) {
        AppMethodBeat.i(30412);
        if (this.mDataList == null || i2 < 0 || i2 >= this.mDataList.size()) {
            AppMethodBeat.o(30412);
            return null;
        }
        com.tencent.mm.plugin.wenote.model.a.c cVar = this.mDataList.get(i2);
        AppMethodBeat.o(30412);
        return cVar;
    }

    public final boolean a(com.tencent.mm.plugin.wenote.model.a.c cVar) {
        boolean z = true;
        AppMethodBeat.i(30413);
        synchronized (this) {
            if (cVar != null) {
                try {
                    if (this.mDataList != null) {
                        this.mDataList.add(cVar);
                        a(cVar, true);
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(30413);
                    throw th;
                }
            }
            z = false;
        }
        AppMethodBeat.o(30413);
        return z;
    }

    public final boolean b(int i2, ArrayList<com.tencent.mm.plugin.wenote.model.a.c> arrayList) {
        boolean z;
        int i3;
        int i4;
        AppMethodBeat.i(30414);
        if (arrayList == null || arrayList.size() <= 0) {
            AppMethodBeat.o(30414);
            return false;
        }
        synchronized (this) {
            try {
                if (this.mDataList != null) {
                    int i5 = 0;
                    i3 = 0;
                    i4 = i2;
                    while (i5 < arrayList.size() && i4 >= 0 && i4 <= this.mDataList.size()) {
                        com.tencent.mm.plugin.wenote.model.a.c cVar = arrayList.get(i5);
                        if (cVar != null) {
                            b(cVar);
                            this.mDataList.add(i4, cVar);
                            i3++;
                            i4++;
                            a(cVar, true);
                        }
                        i5++;
                        i3 = i3;
                    }
                    z = true;
                } else {
                    z = false;
                    i3 = 0;
                    i4 = i2;
                }
            } finally {
                AppMethodBeat.o(30414);
            }
        }
        if (z && this.JId != null) {
            this.JId.ft(i4 - i3, i3);
        }
        return z;
    }

    public final boolean a(int i2, com.tencent.mm.plugin.wenote.model.a.c cVar) {
        boolean z = true;
        AppMethodBeat.i(30415);
        synchronized (this) {
            try {
                if (this.mDataList == null || i2 < 0 || i2 > this.mDataList.size()) {
                    z = false;
                } else {
                    this.mDataList.add(i2, cVar);
                    a(cVar, true);
                }
            } finally {
                AppMethodBeat.o(30415);
            }
        }
        if (z && this.JId != null) {
            this.JId.Fs(i2);
            if (i2 > 0) {
                this.JId.fu(i2 - 1, this.mDataList.size() - (i2 - 1));
            } else {
                this.JId.fu(i2, this.mDataList.size() - i2);
            }
        }
        return z;
    }

    private boolean b(int i2, com.tencent.mm.plugin.wenote.model.a.c cVar) {
        boolean z = true;
        AppMethodBeat.i(30416);
        if (cVar == null || this.mDataList == null || i2 < 0 || i2 > this.mDataList.size()) {
            z = false;
        } else {
            this.mDataList.add(i2, cVar);
            a(cVar, true);
        }
        AppMethodBeat.o(30416);
        return z;
    }

    public final boolean ae(int i2, boolean z) {
        boolean z2 = false;
        AppMethodBeat.i(30417);
        synchronized (this) {
            try {
                if (this.mDataList != null && i2 >= 0 && i2 < this.mDataList.size()) {
                    a(this.mDataList.get(i2), false);
                    this.mDataList.remove(i2);
                    z2 = true;
                }
            } finally {
                AppMethodBeat.o(30417);
            }
        }
        if (z2 && z && this.JId != null) {
            this.JId.Ft(i2);
            if (i2 > 0) {
                this.JId.fu(i2 - 1, this.mDataList.size() - (i2 - 1));
            } else {
                this.JId.fu(i2, this.mDataList.size() - i2);
            }
        }
        return z2;
    }

    private boolean Fx(int i2) {
        boolean z;
        AppMethodBeat.i(30418);
        if (this.mDataList == null || i2 < 0 || i2 >= this.mDataList.size()) {
            z = false;
        } else {
            a(this.mDataList.get(i2), false);
            this.mDataList.remove(i2);
            z = true;
        }
        AppMethodBeat.o(30418);
        return z;
    }

    public final void Fy(int i2) {
        AppMethodBeat.i(30419);
        if (this.JId != null) {
            this.JId.Fr(i2);
        }
        AppMethodBeat.o(30419);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0044, code lost:
        if (r0 == -1) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0048, code lost:
        if (r5.JId == null) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004a, code lost:
        r5.JId.Fr(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004f, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(30420);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r6, com.tencent.mm.plugin.wenote.model.a.c r7) {
        /*
            r5 = this;
            r1 = 0
            r2 = -1
            r4 = 30420(0x76d4, float:4.2627E-41)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
            monitor-enter(r5)
            java.util.ArrayList<com.tencent.mm.plugin.wenote.model.a.c> r0 = r5.mDataList     // Catch:{ all -> 0x0053 }
            if (r0 != 0) goto L_0x0013
            monitor-exit(r5)     // Catch:{ all -> 0x0053 }
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
        L_0x0010:
            return
        L_0x0011:
            int r1 = r1 + 1
        L_0x0013:
            java.util.ArrayList<com.tencent.mm.plugin.wenote.model.a.c> r0 = r5.mDataList
            int r0 = r0.size()
            if (r1 >= r0) goto L_0x0059
            java.util.ArrayList<com.tencent.mm.plugin.wenote.model.a.c> r0 = r5.mDataList
            java.lang.Object r0 = r0.get(r1)
            com.tencent.mm.plugin.wenote.model.a.c r0 = (com.tencent.mm.plugin.wenote.model.a.c) r0
            java.lang.String r0 = r0.gjF()
            boolean r0 = r0.equals(r6)
            if (r0 == 0) goto L_0x0011
            java.util.ArrayList<com.tencent.mm.plugin.wenote.model.a.c> r0 = r5.mDataList
            java.lang.Object r0 = r0.get(r1)
            com.tencent.mm.plugin.wenote.model.a.c r0 = (com.tencent.mm.plugin.wenote.model.a.c) r0
            r3 = 0
            r5.a(r0, r3)
            java.util.ArrayList<com.tencent.mm.plugin.wenote.model.a.c> r0 = r5.mDataList
            r0.set(r1, r7)
            r0 = 1
            r5.a(r7, r0)
            r0 = r1
        L_0x0043:
            monitor-exit(r5)
            if (r0 == r2) goto L_0x004f
            com.tencent.mm.plugin.wenote.model.nativenote.b.a r1 = r5.JId
            if (r1 == 0) goto L_0x004f
            com.tencent.mm.plugin.wenote.model.nativenote.b.a r1 = r5.JId
            r1.Fr(r0)
        L_0x004f:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            goto L_0x0010
        L_0x0053:
            r0 = move-exception
            monitor-exit(r5)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            throw r0
        L_0x0059:
            r0 = r2
            goto L_0x0043
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wenote.model.nativenote.manager.c.a(java.lang.String, com.tencent.mm.plugin.wenote.model.a.c):void");
    }

    public final void bbU(String str) {
        long j2;
        AppMethodBeat.i(30421);
        if (Util.isNullOrNil(str) || this.mDataList == null) {
            AppMethodBeat.o(30421);
            return;
        }
        final ArrayList<String> alN = b.alN(str);
        if (alN == null || alN.size() <= 0) {
            AppMethodBeat.o(30421);
            return;
        }
        synchronized (this) {
            try {
                Log.i("MicroMsg.Note.NoteDataManager", "updateDataByHtml, mHasInitDataListFinish :％B", Boolean.valueOf(this.JIe));
                MMHandlerThread aAk = bg.aAk();
                AnonymousClass2 r3 = new Runnable() {
                    /* class com.tencent.mm.plugin.wenote.model.nativenote.manager.c.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(30408);
                        ArrayList<com.tencent.mm.plugin.wenote.model.a.c> a2 = h.a((Object) c.this.mDataList, (List<String>) alN, false);
                        Log.i("MicroMsg.Note.NoteDataManager", "updateDataByHtml, start mNotifyListener.setUpNoteData(dataItems, true)");
                        if (c.this.JId != null) {
                            c.this.JId.f(a2, true);
                        }
                        AppMethodBeat.o(30408);
                    }
                };
                if (this.JIe) {
                    j2 = 500;
                } else {
                    j2 = 1000;
                }
                aAk.postToWorkerDelayed(r3, j2);
            } catch (Exception e2) {
                Log.e("MicroMsg.Note.NoteDataManager", "updateDataByHtml exception,%s", e2.toString());
            }
            try {
            } catch (Throwable th) {
                AppMethodBeat.o(30421);
                throw th;
            }
        }
        AppMethodBeat.o(30421);
    }

    public final void cDp() {
        AppMethodBeat.i(30422);
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(this.mDataList != null ? this.mDataList.size() : 0);
        Log.i("MicroMsg.Note.NoteDataManager", "clear mDataList, size:%d", objArr);
        synchronized (this) {
            try {
                if (this.mDataList != null) {
                    this.mDataList.clear();
                }
            } catch (Throwable th) {
                AppMethodBeat.o(30422);
                throw th;
            }
        }
        this.qQt = 0;
        this.qQs = 0;
        AppMethodBeat.o(30422);
    }

    public final void af(int i2, boolean z) {
        AppMethodBeat.i(30423);
        synchronized (this) {
            try {
                if (this.mDataList != null) {
                    if (i2 >= 0 && i2 < this.mDataList.size()) {
                        com.tencent.mm.plugin.wenote.model.a.c cVar = this.mDataList.get(i2);
                        if (!(cVar == null || cVar.qPH == z)) {
                            cVar.qPH = z;
                            if (this.JId != null) {
                                this.JId.Fr(i2);
                            }
                        }
                    } else if (i2 == -1) {
                        for (int i3 = 0; i3 < this.mDataList.size(); i3++) {
                            com.tencent.mm.plugin.wenote.model.a.c cVar2 = this.mDataList.get(i3);
                            if (!(cVar2 == null || cVar2.qPH == z)) {
                                cVar2.qPH = z;
                                if (this.JId != null) {
                                    this.JId.Fr(i3);
                                }
                            }
                        }
                    }
                    AppMethodBeat.o(30423);
                }
            } finally {
                AppMethodBeat.o(30423);
            }
        }
    }

    public final int cDq() {
        int i2;
        AppMethodBeat.i(30424);
        synchronized (this) {
            try {
                if (this.mDataList != null) {
                    int i3 = 0;
                    while (true) {
                        if (i3 >= this.mDataList.size()) {
                            break;
                        } else if (this.mDataList.get(i3).qPA) {
                            i2 = i3;
                            break;
                        } else {
                            i3++;
                        }
                    }
                }
                i2 = -1;
            } finally {
                AppMethodBeat.o(30424);
            }
        }
        return i2;
    }

    public final void cDr() {
        AppMethodBeat.i(30425);
        synchronized (this) {
            try {
                if (this.mDataList != null) {
                    Iterator<com.tencent.mm.plugin.wenote.model.a.c> it = this.mDataList.iterator();
                    while (it.hasNext()) {
                        com.tencent.mm.plugin.wenote.model.a.c next = it.next();
                        next.qPA = false;
                        next.qPG = false;
                    }
                }
            } finally {
                AppMethodBeat.o(30425);
            }
        }
    }

    private void cDs() {
        AppMethodBeat.i(30426);
        if (this.mDataList != null) {
            Iterator<com.tencent.mm.plugin.wenote.model.a.c> it = this.mDataList.iterator();
            while (it.hasNext()) {
                com.tencent.mm.plugin.wenote.model.a.c next = it.next();
                next.qPA = false;
                next.qPG = false;
            }
        }
        AppMethodBeat.o(30426);
    }

    public final void ag(int i2, boolean z) {
        AppMethodBeat.i(30427);
        synchronized (this) {
            try {
                if (this.mDataList != null && i2 >= 0 && i2 < this.mDataList.size()) {
                    for (int i3 = 0; i3 < this.mDataList.size(); i3++) {
                        if (i3 == i2) {
                            this.mDataList.get(i3).qPA = true;
                            this.mDataList.get(i3).qPG = z;
                        } else {
                            this.mDataList.get(i3).qPA = false;
                            this.mDataList.get(i3).qPG = false;
                        }
                    }
                    AppMethodBeat.o(30427);
                }
            } finally {
                AppMethodBeat.o(30427);
            }
        }
    }

    public final int cDt() {
        int i2;
        AppMethodBeat.i(30428);
        synchronized (this) {
            try {
                if (this.mDataList != null) {
                    int i3 = 0;
                    while (true) {
                        if (i3 < this.mDataList.size()) {
                            if (this.mDataList.get(i3).getType() == 4 && ((l) this.mDataList.get(i3)).qPX.booleanValue()) {
                                i2 = i3;
                                break;
                            }
                            i3++;
                        } else {
                            break;
                        }
                    }
                }
                i2 = -1;
            } finally {
                AppMethodBeat.o(30428);
            }
        }
        return i2;
    }

    public final String cDu() {
        String sb;
        AppMethodBeat.i(30429);
        synchronized (this) {
            try {
                if (this.qQr == 0 && this.mDataList != null) {
                    Iterator<com.tencent.mm.plugin.wenote.model.a.c> it = this.mDataList.iterator();
                    while (it.hasNext()) {
                        o oVar = (o) it.next();
                        if (oVar.qPN.startsWith("WeNote_")) {
                            int i2 = Util.getInt(oVar.qPN.substring(7), -1);
                            if (i2 <= this.qQr) {
                                i2 = this.qQr;
                            }
                            this.qQr = i2;
                        }
                    }
                }
                StringBuilder sb2 = new StringBuilder("WeNote_");
                int i3 = this.qQr + 1;
                this.qQr = i3;
                sb = sb2.append(i3).toString();
            } finally {
                AppMethodBeat.o(30429);
            }
        }
        return sb;
    }

    private String cDv() {
        AppMethodBeat.i(30430);
        if (this.qQr == 0 && this.mDataList != null) {
            Iterator<com.tencent.mm.plugin.wenote.model.a.c> it = this.mDataList.iterator();
            while (it.hasNext()) {
                o oVar = (o) it.next();
                if (oVar.qPN.startsWith("WeNote_")) {
                    int i2 = Util.getInt(oVar.qPN.substring(7), -1);
                    if (i2 <= this.qQr) {
                        i2 = this.qQr;
                    }
                    this.qQr = i2;
                }
            }
        }
        StringBuilder sb = new StringBuilder("WeNote_");
        int i3 = this.qQr + 1;
        this.qQr = i3;
        String sb2 = sb.append(i3).toString();
        AppMethodBeat.o(30430);
        return sb2;
    }

    public final String cDw() {
        String str;
        String str2;
        AppMethodBeat.i(30431);
        String str3 = "";
        synchronized (this) {
            try {
                if (this.mDataList == null || this.mDataList.size() <= 0) {
                    str = "";
                } else {
                    int i2 = 0;
                    while (i2 < this.mDataList.size()) {
                        com.tencent.mm.plugin.wenote.model.a.c cVar = this.mDataList.get(i2);
                        switch (cVar.getType()) {
                            case -1:
                                str2 = str3 + "<hr/>";
                                continue;
                                i2++;
                                str3 = str2;
                            case 1:
                                i iVar = (i) cVar;
                                if (Util.isNullOrNil(iVar.content)) {
                                    str2 = str3 + "<br/>";
                                    continue;
                                } else {
                                    str3 = str3 + iVar.content;
                                    if (i2 + 1 < this.mDataList.size() && this.mDataList.get(i2 + 1).getType() == 1 && !Util.isNullOrNil(((i) this.mDataList.get(i2 + 1)).content)) {
                                        str2 = str3 + "<br/>";
                                    }
                                }
                                i2++;
                                str3 = str2;
                            case 2:
                                str2 = str3 + cY(((f) cVar).qPN, 2);
                                continue;
                                i2++;
                                str3 = str2;
                            case 3:
                                str2 = str3 + cY(((g) cVar).qPN, 3);
                                continue;
                                i2++;
                                str3 = str2;
                            case 4:
                                l lVar = (l) cVar;
                                str2 = str3 + cY(lVar.qPN, lVar.getType());
                                continue;
                                i2++;
                                str3 = str2;
                            case 5:
                                str2 = str3 + cY(((d) cVar).qPN, 5);
                                continue;
                                i2++;
                                str3 = str2;
                            case 6:
                                str2 = str3 + cY(((k) cVar).qPN, 6);
                                continue;
                                i2++;
                                str3 = str2;
                            case 20:
                                str2 = str3 + cY(((com.tencent.mm.plugin.wenote.model.a.b) cVar).qPN, 20);
                                continue;
                                i2++;
                                str3 = str2;
                        }
                        str2 = str3;
                        i2++;
                        str3 = str2;
                    }
                    str = str3.replaceAll("\n", "<br/>");
                    AppMethodBeat.o(30431);
                }
            } finally {
                AppMethodBeat.o(30431);
            }
        }
        return str;
    }

    private static String cY(String str, int i2) {
        AppMethodBeat.i(30432);
        String format = String.format("<div><object data-type=\"%d\" id=\"%s\" name=\"%s\" class=\"item item-\"></object></div>", Integer.valueOf(i2), str, str);
        AppMethodBeat.o(30432);
        return format;
    }

    public final anb alU(String str) {
        boolean z;
        byte[] bArr;
        AppMethodBeat.i(30433);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.Note.NoteDataManager", "getFavProtoItem error ,htmlstr is null or nil");
            AppMethodBeat.o(30433);
            return null;
        }
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            for (int i2 = 0; i2 < this.mDataList.size(); i2++) {
                try {
                    com.tencent.mm.plugin.wenote.model.a.c cVar = this.mDataList.get(i2);
                    if (Util.isNullOrNil(cVar.dLl)) {
                        cVar.dLl = com.tencent.mm.plugin.wenote.model.f.alR(cVar.toString());
                    }
                    if (cVar.getType() == -1) {
                        if (arrayList.size() <= 0 || ((o) arrayList.get(arrayList.size() - 1)).type != 1) {
                            i iVar = new i();
                            iVar.content = "\n";
                            iVar.dLl = cVar.dLl;
                            iVar.qPN = "-1";
                            iVar.type = 1;
                            iVar.qPM = null;
                            arrayList.add(iVar);
                        } else {
                            StringBuilder sb = new StringBuilder();
                            i iVar2 = (i) arrayList.get(arrayList.size() - 1);
                            iVar2.content = sb.append(iVar2.content).append("\n").toString();
                        }
                    } else if (cVar.getType() >= -1) {
                        if ((cVar.getType() == 6 || cVar.getType() == 4) && Util.isNullOrNil(((o) cVar).dUs)) {
                            aml aml = new aml();
                            aml.bgs(cVar.dLl);
                            aml.bgp(cVar.cDg());
                            String b2 = com.tencent.mm.plugin.wenote.model.f.b(aml);
                            if (s.YS(b2)) {
                                Log.e("MicroMsg.Note.NoteDataManager", "getFavProtoItem,type = %d, localfile exsit,but localpath is null or nil, set path here", Integer.valueOf(cVar.getType()));
                                ((o) cVar).dUs = b2;
                            }
                        }
                        if (cVar.getType() != 1) {
                            arrayList.add((o) cVar);
                        } else {
                            i iVar3 = (i) cVar;
                            if (!Util.isNullOrNil(iVar3.content)) {
                                if (arrayList.size() <= 0 || ((o) arrayList.get(arrayList.size() - 1)).getType() != 1) {
                                    i iVar4 = new i();
                                    iVar4.content = iVar3.content;
                                    iVar4.dLl = iVar3.dLl;
                                    iVar4.qPN = iVar3.qPN;
                                    iVar4.type = iVar3.type;
                                    iVar4.qPM = null;
                                    arrayList.add(iVar4);
                                } else {
                                    StringBuilder sb2 = new StringBuilder();
                                    i iVar5 = (i) arrayList.get(arrayList.size() - 1);
                                    iVar5.content = sb2.append(iVar5.content).append(iVar3.content).toString();
                                }
                                if (i2 + 1 < this.mDataList.size() && this.mDataList.get(i2 + 1).getType() == 1 && !Util.isNullOrNil(((i) this.mDataList.get(i2 + 1)).content)) {
                                    StringBuilder sb3 = new StringBuilder();
                                    i iVar6 = (i) arrayList.get(arrayList.size() - 1);
                                    iVar6.content = sb3.append(iVar6.content).append("<br/>").toString();
                                }
                            } else if (arrayList.size() <= 0 || ((o) arrayList.get(arrayList.size() - 1)).getType() != 1) {
                                i iVar7 = new i();
                                iVar7.content = "<br/>";
                                iVar7.dLl = iVar3.dLl;
                                iVar7.qPN = iVar3.qPN;
                                iVar7.type = iVar3.type;
                                iVar7.qPM = null;
                                arrayList.add(iVar7);
                            } else {
                                StringBuilder sb4 = new StringBuilder();
                                i iVar8 = (i) arrayList.get(arrayList.size() - 1);
                                iVar8.content = sb4.append(iVar8.content).append("<br/>").toString();
                            }
                        }
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(30433);
                    throw th;
                }
            }
        }
        String replaceAll = Pattern.compile("</wx-", 2).matcher(Pattern.compile("<wx-", 2).matcher(str).replaceAll("<")).replaceAll("</");
        try {
            bArr = replaceAll.getBytes(MimeTypeUtil.ContentType.DEFAULT_CHARSET);
            z = false;
        } catch (UnsupportedEncodingException e2) {
            Log.printErrStackTrace("MicroMsg.Note.NoteDataManager", e2, "", new Object[0]);
            Log.e("MicroMsg.Note.NoteDataManager", "writehtmlfile, use utf-8 encoding error,use default encoding,");
            z = true;
            bArr = null;
        }
        this.qQq.ajd(8);
        this.qQq.bgC("WeNoteHtmlFile");
        this.qQq.At(true);
        this.qQq.bgp(".htm");
        this.qQq.bgs(com.tencent.mm.plugin.wenote.model.f.alR(this.qQq.toString()));
        String b3 = com.tencent.mm.plugin.wenote.model.f.b(this.qQq);
        Log.i("MicroMsg.Note.NoteDataManager", "getFavProtoItem: save note html file, path is %s", b3);
        com.tencent.mm.vfs.o oVar = new com.tencent.mm.vfs.o(b3);
        if (oVar.exists()) {
            oVar.delete();
        }
        if (!oVar.exists()) {
            try {
                oVar.createNewFile();
            } catch (IOException e3) {
                Log.printErrStackTrace("MicroMsg.Note.NoteDataManager", e3, "", new Object[0]);
                AppMethodBeat.o(30433);
                return null;
            }
        }
        if (z || s.f(b3, bArr, bArr.length) != 0) {
            Log.i("MicroMsg.Note.NoteDataManager", "writefile error,return");
            Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(R.string.cc0), 1).show();
            AppMethodBeat.o(30433);
            return null;
        }
        this.qQq.bgt(b3);
        Log.i("MicroMsg.Note.NoteDataManager", "do WNNoteBase.ConvertNote2FavProtoItem");
        anb a2 = com.tencent.mm.plugin.wenote.model.d.a(replaceAll, arrayList, this.qQq);
        AppMethodBeat.o(30433);
        return a2;
    }

    public final int a(com.tencent.mm.plugin.wenote.model.a.c cVar, WXRTEditText wXRTEditText, boolean z, boolean z2, boolean z3) {
        AppMethodBeat.i(30434);
        if (cVar == null) {
            AppMethodBeat.o(30434);
            return -1;
        }
        ArrayList<com.tencent.mm.plugin.wenote.model.a.c> arrayList = new ArrayList<>();
        arrayList.add(cVar);
        int a2 = a(arrayList, wXRTEditText, true, z, z2, z3);
        AppMethodBeat.o(30434);
        return a2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:142:0x0281, code lost:
        r1 = gjL().size() - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x028d, code lost:
        r6 = new com.tencent.mm.plugin.wenote.model.a.i();
        r6.type = 1;
        r6.content = "";
        r6.qPC = 0;
        r6.qPA = true;
        r6.qPG = false;
        b(r1, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x02a4, code lost:
        if (r3 != 0) goto L_0x015a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x02a6, code lost:
        r10.JId.fu(r3, gjL().size() - r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:?, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0100, code lost:
        if ((r2 - 1) < 0) goto L_0x0281;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x010c, code lost:
        if ((r2 - 1) >= gjL().size()) goto L_0x0281;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x010e, code lost:
        r1 = r2 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0110, code lost:
        if (r16 == false) goto L_0x0133;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0112, code lost:
        r1 = r1 + 1;
        r2 = r2 + 1;
        cDs();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0121, code lost:
        if (r1 >= gjL().size()) goto L_0x028d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0123, code lost:
        r6 = gjL().ahp(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x012b, code lost:
        if (r6 == null) goto L_0x0133;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x012d, code lost:
        r6.qPC = 0;
        r6.qPA = true;
        r6.qPG = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0135, code lost:
        if (r10.JId == null) goto L_0x0166;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0137, code lost:
        r2 = r2 - r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0138, code lost:
        if (r4 == false) goto L_0x013c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x013a, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x013c, code lost:
        if (r3 < 0) goto L_0x0145;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x013e, code lost:
        if (r2 <= 0) goto L_0x0145;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0140, code lost:
        r10.JId.ft(r3, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0145, code lost:
        if (r3 <= 0) goto L_0x02a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0147, code lost:
        r10.JId.fu(r3 - 1, gjL().size() - (r3 - 1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x015a, code lost:
        if (r15 == false) goto L_0x0161;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x015c, code lost:
        r10.JId.cCw();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0161, code lost:
        r10.JId.Fu(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0166, code lost:
        cDy();
        com.tencent.matrix.trace.core.AppMethodBeat.o(30435);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(java.util.ArrayList<com.tencent.mm.plugin.wenote.model.a.c> r11, com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText r12, boolean r13, boolean r14, boolean r15, boolean r16) {
        /*
        // Method dump skipped, instructions count: 710
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wenote.model.nativenote.manager.c.a(java.util.ArrayList, com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText, boolean, boolean, boolean, boolean):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x01f2, code lost:
        r1 = gjL().size() - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x01fd, code lost:
        if (r5 != 0) goto L_0x01df;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x01ff, code lost:
        r9.JId.fu(r5, gjL().size() - r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:?, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x01a9, code lost:
        if ((r2 - 1) < 0) goto L_0x01f2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01b5, code lost:
        if ((r2 - 1) >= gjL().size()) goto L_0x01f2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01b7, code lost:
        r1 = r2 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x01bb, code lost:
        if (r9.JId == null) goto L_0x01e4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x01bd, code lost:
        r2 = r2 - r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x01be, code lost:
        if (r3 == false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01c0, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x01c2, code lost:
        if (r5 < 0) goto L_0x01cb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x01c4, code lost:
        if (r2 <= 0) goto L_0x01cb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x01c6, code lost:
        r9.JId.ft(r5, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x01cb, code lost:
        if (r5 <= 0) goto L_0x01fd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x01cd, code lost:
        r9.JId.fu(r5 - 1, gjL().size() - (r5 - 1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x01df, code lost:
        r9.JId.Fu(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x01e4, code lost:
        cDy();
        com.tencent.matrix.trace.core.AppMethodBeat.o(30436);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(java.util.ArrayList<com.tencent.mm.plugin.wenote.model.a.c> r10, int r11, int r12, int r13, int r14) {
        /*
        // Method dump skipped, instructions count: 534
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wenote.model.nativenote.manager.c.a(java.util.ArrayList, int, int, int, int):int");
    }

    private void b(com.tencent.mm.plugin.wenote.model.a.c cVar) {
        AppMethodBeat.i(30437);
        if (cVar == null) {
            AppMethodBeat.o(30437);
            return;
        }
        o oVar = (o) cVar;
        if (oVar.getType() > 1) {
            if (Util.isNullOrNil(oVar.qPN)) {
                oVar.qPN = cDv();
            }
            com.tencent.mm.plugin.wenote.model.d dVar = com.tencent.mm.plugin.wenote.model.c.gjz().JGL;
            if (dVar == null) {
                Log.e("MicroMsg.Note.NoteDataManager", "processItem,item is %s, but get wnnote base is null", cVar.toString());
            } else if (dVar.JGS == null) {
                Log.e("MicroMsg.Note.NoteDataManager", "processItem,item is %s, but mEditorIdToDataItem is null", cVar.toString());
            } else {
                dVar.JGS.put(oVar.qPN, oVar);
            }
        }
        if (Util.isNullOrNil(cVar.dLl)) {
            cVar.dLl = com.tencent.mm.plugin.wenote.model.f.alR(cVar.toString());
        }
        AppMethodBeat.o(30437);
    }

    public final ArrayList<com.tencent.mm.plugin.wenote.model.a.c> cDx() {
        AppMethodBeat.i(30438);
        if (this.mDataList == null) {
            AppMethodBeat.o(30438);
            return null;
        }
        ArrayList<com.tencent.mm.plugin.wenote.model.a.c> arrayList = new ArrayList<>();
        synchronized (this) {
            try {
                Iterator<com.tencent.mm.plugin.wenote.model.a.c> it = this.mDataList.iterator();
                while (it.hasNext()) {
                    arrayList.add(com.tencent.mm.plugin.wenote.c.c.c(it.next()));
                }
            } finally {
                AppMethodBeat.o(30438);
            }
        }
        return arrayList;
    }

    public final boolean U(ArrayList<com.tencent.mm.plugin.wenote.model.a.c> arrayList) {
        AppMethodBeat.i(30439);
        StringBuilder sb = new StringBuilder();
        Iterator<com.tencent.mm.plugin.wenote.model.a.c> it = arrayList.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            com.tencent.mm.plugin.wenote.model.a.c next = it.next();
            if (next.getType() != 1) {
                i2++;
            } else {
                sb.append(((i) next).content);
            }
        }
        boolean fw = fw(com.tencent.mm.plugin.wenote.c.c.alJ(sb.toString()), i2);
        AppMethodBeat.o(30439);
        return fw;
    }

    public final boolean fw(int i2, int i3) {
        boolean z;
        boolean z2;
        if (i2 < 0) {
            z = false;
        } else {
            z = true;
        }
        if (i3 < 0) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (!z || this.qQs + i2 <= 16384) {
            return z2 && this.qQt + i3 > 30;
        }
        return true;
    }

    public final void cDy() {
        AppMethodBeat.i(30440);
        bg.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.wenote.model.nativenote.manager.c.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(30409);
                synchronized (c.this) {
                    try {
                        if (c.this.mDataList != null) {
                            StringBuilder sb = new StringBuilder();
                            Iterator it = c.this.mDataList.iterator();
                            int i2 = 0;
                            while (it.hasNext()) {
                                com.tencent.mm.plugin.wenote.model.a.c cVar = (com.tencent.mm.plugin.wenote.model.a.c) it.next();
                                if (cVar.getType() != 1) {
                                    i2++;
                                } else {
                                    sb.append(((i) cVar).content);
                                }
                            }
                            c.this.qQs = com.tencent.mm.plugin.wenote.c.c.alJ(sb.toString());
                            c.this.qQt = i2;
                            AppMethodBeat.o(30409);
                        }
                    } finally {
                        AppMethodBeat.o(30409);
                    }
                }
            }
        });
        AppMethodBeat.o(30440);
    }

    private void a(com.tencent.mm.plugin.wenote.model.a.c cVar, boolean z) {
        AppMethodBeat.i(30441);
        if (cVar == null) {
            AppMethodBeat.o(30441);
        } else if (cVar.getType() == 1) {
            int alJ = com.tencent.mm.plugin.wenote.c.c.alJ(((i) cVar).content);
            if (z) {
                this.qQs = alJ + this.qQs;
                AppMethodBeat.o(30441);
                return;
            }
            this.qQs -= alJ;
            AppMethodBeat.o(30441);
        } else if (z) {
            this.qQt++;
            AppMethodBeat.o(30441);
        } else {
            this.qQt--;
            AppMethodBeat.o(30441);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:47:0x010d, code lost:
        if (r2 == -1) goto L_0x011f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0111, code lost:
        if (r10.JId == null) goto L_0x011f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0113, code lost:
        r10.JId.fu(r2, r10.mDataList.size() - r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x011f, code lost:
        cDy();
        com.tencent.matrix.trace.core.AppMethodBeat.o(30442);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void fx(int r11, int r12) {
        /*
        // Method dump skipped, instructions count: 298
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wenote.model.nativenote.manager.c.fx(int, int):void");
    }

    public final String bbV(String str) {
        String str2;
        boolean z;
        AppMethodBeat.i(30443);
        synchronized (this) {
            try {
                if (this.mDataList != null) {
                    int i2 = 0;
                    String str3 = str;
                    while (true) {
                        if (i2 >= this.mDataList.size()) {
                            str2 = str3;
                            break;
                        }
                        if (this.mDataList.get(i2).getType() == 1) {
                            String replace = b.alO(((i) this.mDataList.get(i2)).content).replace("&lt;", "<").replace("&gt;", ">").replace(" ", " ");
                            if (!Util.isNullOrNil(replace)) {
                                String[] split = replace.split("\n");
                                int i3 = 0;
                                while (true) {
                                    if (i3 >= split.length) {
                                        z = false;
                                        str2 = str3;
                                        break;
                                    } else if (!Util.isNullOrNil(split[i3].trim())) {
                                        str2 = split[i3];
                                        z = true;
                                        break;
                                    } else {
                                        i3++;
                                    }
                                }
                                if (z) {
                                    break;
                                }
                                i2++;
                                str3 = str2;
                            }
                        }
                        str2 = str3;
                        i2++;
                        str3 = str2;
                    }
                } else {
                    str2 = str;
                }
            } finally {
                AppMethodBeat.o(30443);
            }
        }
        if (str2.length() > 1000) {
            str2 = str2.substring(0, 1000);
        }
        return str2;
    }

    public final int cDz() {
        AppMethodBeat.i(30444);
        synchronized (this) {
            try {
                if (this.mDataList == null) {
                    return -1;
                }
                for (int i2 = 0; i2 < this.mDataList.size(); i2++) {
                    com.tencent.mm.plugin.wenote.model.a.c cVar = this.mDataList.get(i2);
                    if (cVar != null && cVar.getType() != -3 && cVar.getType() != -2) {
                        AppMethodBeat.o(30444);
                        return i2;
                    }
                }
                AppMethodBeat.o(30444);
                return -1;
            } finally {
                AppMethodBeat.o(30444);
            }
        }
    }

    public final int cDA() {
        AppMethodBeat.i(30445);
        synchronized (this) {
            try {
                if (this.mDataList == null) {
                    return -1;
                }
                for (int size = this.mDataList.size() - 1; size >= 0; size--) {
                    com.tencent.mm.plugin.wenote.model.a.c cVar = this.mDataList.get(size);
                    if (cVar != null && cVar.getType() != -3 && cVar.getType() != -2) {
                        AppMethodBeat.o(30445);
                        return size;
                    }
                }
                AppMethodBeat.o(30445);
                return -1;
            } finally {
                AppMethodBeat.o(30445);
            }
        }
    }
}
