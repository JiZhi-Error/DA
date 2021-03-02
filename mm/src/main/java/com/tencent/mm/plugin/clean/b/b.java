package com.tencent.mm.plugin.clean.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.clean.c.c;
import com.tencent.mm.plugin.f.b.a;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.s;
import java.util.HashSet;
import java.util.List;

public final class b implements Runnable {
    private List<String> qpB;
    private List<c> qpC;
    private com.tencent.mm.plugin.clean.c.b qpD;
    private long qpE = 0;

    public b(List<String> list, List<c> list2, com.tencent.mm.plugin.clean.c.b bVar) {
        this.qpB = list;
        this.qpC = list2;
        this.qpD = bVar;
    }

    private void da(List<a> list) {
        AppMethodBeat.i(22769);
        int size = list.size();
        HashSet hashSet = new HashSet();
        bg.aVF();
        long beginTransaction = com.tencent.mm.model.c.getDataDB().beginTransaction(Thread.currentThread().getId());
        for (int i2 = 0; i2 < size; i2++) {
            a aVar = list.get(i2);
            long currentTicks = Util.currentTicks();
            if (!hashSet.contains(Long.valueOf(aVar.field_msgId))) {
                bg.aVF();
                ca Hb = com.tencent.mm.model.c.aSQ().Hb(aVar.field_msgId);
                if (Hb.field_msgId != 0 && !Hb.gDB()) {
                    com.tencent.mm.plugin.f.b crW = com.tencent.mm.plugin.f.b.crW();
                    long j2 = aVar.field_msgId;
                    crW.pPO = true;
                    crW.pPN.add(Long.valueOf(j2));
                    Log.d("MicroMsg.CalcWxService", "%d lock msg change [%d] [%s]", Integer.valueOf(crW.hashCode()), Long.valueOf(j2), Util.getStack());
                    Hb.gDC();
                    bg.aVF();
                    com.tencent.mm.model.c.aSQ().a(aVar.field_msgId, Hb);
                }
                hashSet.add(Long.valueOf(aVar.field_msgId));
                Log.d("MicroMsg.DeleteFileByWxIndex", "%s deleteByIndex handle msg[%d]", bgQ(), Long.valueOf(Util.ticksToNow(currentTicks)));
            }
            if (aVar != null && !com.tencent.mm.plugin.f.a.Ea(aVar.field_msgSubType) && aVar.field_size > 0) {
                this.qpE += aVar.field_size;
                s.deleteFile(g.aAh().hqF + aVar.field_path);
                aVar.field_path = "";
                aVar.field_size = 0;
                com.tencent.mm.plugin.f.b.crW().crX().update(aVar.systemRowid, aVar, false);
            }
            Log.d("MicroMsg.DeleteFileByWxIndex", "%s deleteByIndex[%d]", bgQ(), Long.valueOf(Util.ticksToNow(currentTicks)));
        }
        bg.aVF();
        com.tencent.mm.model.c.getDataDB().endTransaction(beginTransaction);
        AppMethodBeat.o(22769);
    }

    public final void run() {
        AppMethodBeat.i(22770);
        if (this.qpB != null) {
            long currentTicks = Util.currentTicks();
            int size = this.qpB.size();
            int i2 = 0;
            for (String str : this.qpB) {
                if (!Util.isNullOrNil(str)) {
                    long currentTicks2 = Util.currentTicks();
                    PLong pLong = new PLong();
                    PLong pLong2 = new PLong();
                    com.tencent.mm.plugin.f.b.b crX = com.tencent.mm.plugin.f.b.crW().crX();
                    long currentTicks3 = Util.currentTicks();
                    String str2 = "select max(msgtime), min(msgtime) from WxFileIndex2 where username='" + str + "' and msgSubType in (1,20,23,30,32,34 ) and size > 0 ";
                    Cursor cursor = null;
                    try {
                        Cursor rawQuery = crX.db.rawQuery(str2, null);
                        if (rawQuery != null && rawQuery.moveToFirst()) {
                            pLong.value = rawQuery.getLong(0);
                            pLong2.value = rawQuery.getLong(1);
                        }
                        if (rawQuery != null) {
                            rawQuery.close();
                        }
                    } catch (Exception e2) {
                        Log.printErrStackTrace("MicroMsg.WxFileIndexStorage", e2, " sql [%s]", str2);
                        if (0 != 0) {
                            cursor.close();
                        }
                    } catch (Throwable th) {
                        if (0 != 0) {
                            cursor.close();
                        }
                        AppMethodBeat.o(22770);
                        throw th;
                    }
                    Log.i("MicroMsg.WxFileIndexStorage", "getNoThumbMediaMsgTimeByUsername [%s] cost[%d]", str, Long.valueOf(Util.ticksToNow(currentTicks3)));
                    pLong2.value--;
                    long j2 = pLong.value;
                    long max = Math.max(j2 - 2592000000L, pLong2.value);
                    if (max == j2) {
                        max--;
                    }
                    List<a> u = com.tencent.mm.plugin.f.b.crW().crX().u(str, j2, max);
                    long size2 = ((long) u.size()) + 0;
                    da(u);
                    while (max > pLong2.value) {
                        max = Math.max(max - 2592000000L, pLong2.value);
                        if (max == max) {
                            max--;
                        }
                        List<a> u2 = com.tencent.mm.plugin.f.b.crW().crX().u(str, max, max);
                        size2 += (long) u2.size();
                        da(u2);
                    }
                    Log.i("MicroMsg.DeleteFileByWxIndex", "%s deleteByName [%s] [%d] [%d %d] cost[%d]", bgQ(), str, Long.valueOf(size2), Long.valueOf(pLong2.value), Long.valueOf(pLong.value), Long.valueOf(Util.ticksToNow(currentTicks2)));
                }
                i2++;
                if (this.qpD != null) {
                    this.qpD.fo(i2, size);
                }
            }
            if (this.qpD != null) {
                this.qpD.Ce(this.qpE);
            }
            com.tencent.mm.plugin.f.b.crW().csc();
            Log.i("MicroMsg.DeleteFileByWxIndex", "%s deleteByUsername cost[%d]", bgQ(), Long.valueOf(Util.ticksToNow(currentTicks)));
            AppMethodBeat.o(22770);
        } else if (this.qpC != null) {
            long currentTicks4 = Util.currentTicks();
            int size3 = this.qpC.size();
            int i3 = 0;
            for (c cVar : this.qpC) {
                da(cVar.qpJ);
                i3++;
                if (this.qpD != null) {
                    this.qpD.fo(i3, size3);
                }
            }
            if (this.qpD != null) {
                this.qpD.Ce(this.qpE);
            }
            com.tencent.mm.plugin.f.b.crW().csc();
            Log.i("MicroMsg.DeleteFileByWxIndex", "%s deleteByNewAnalyseItem cost[%d]", bgQ(), Long.valueOf(Util.ticksToNow(currentTicks4)));
            AppMethodBeat.o(22770);
        } else {
            AppMethodBeat.o(22770);
        }
    }

    private String bgQ() {
        AppMethodBeat.i(22771);
        String sb = new StringBuilder().append(hashCode()).toString();
        AppMethodBeat.o(22771);
        return sb;
    }
}
