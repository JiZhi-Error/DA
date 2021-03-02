package com.tencent.mm.modelstat;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.RWCache;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.storagebase.h;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;
import java.util.HashSet;
import junit.framework.Assert;

public final class m extends MStorage implements RWCache.IRWCacheAppender<Integer, k> {
    public static final String[] SQL_CREATE = {"CREATE TABLE IF NOT EXISTS netstat ( id INTEGER PRIMARY KEY, peroid INT, textCountIn INT, textBytesIn INT, imageCountIn INT, imageBytesIn INT, voiceCountIn INT, voiceBytesIn INT, videoCountIn INT, videoBytesIn INT, mobileBytesIn INT, wifiBytesIn INT, sysMobileBytesIn INT, sysWifiBytesIn INT, textCountOut INT, textBytesOut INT, imageCountOut INT, imageBytesOut INT, voiceCountOut INT, voiceBytesOut INT, videoCountOut INT, videoBytesOut INT, mobileBytesOut INT, wifiBytesOut INT, sysMobileBytesOut INT, sysWifiBytesOut INT, reserved1 INT, reserved2 INT, reserved3 TEXT, realMobileBytesIn INT, realWifiBytesIn INT, realMobileBytesOut INT, realWifiBytesOut INT) ", "CREATE INDEX IF NOT EXISTS  statInfoIndex ON netstat ( peroid ) "};
    private static final String[] joU = {"realMobileBytesIn", "realWifiBytesIn", "realMobileBytesOut", "realWifiBytesOut"};
    public h iFy;
    private long joR;
    public RWCache<Integer, k> joS = new RWCache<>(this, g.aAk().getLooper(), 30, 2, 300000, 1000);
    private long joT;

    public m(h hVar) {
        AppMethodBeat.i(151097);
        this.iFy = hVar;
        HashSet hashSet = new HashSet();
        for (String str : joU) {
            hashSet.add(str);
        }
        Cursor rawQuery = this.iFy.rawQuery("PRAGMA table_info(netstat);", null, 2);
        int columnIndex = rawQuery.getColumnIndex("name");
        while (rawQuery.moveToNext()) {
            hashSet.remove(rawQuery.getString(columnIndex));
        }
        rawQuery.close();
        String[] strArr = joU;
        for (String str2 : strArr) {
            if (hashSet.contains(str2)) {
                this.iFy.execSQL("netstat", "ALTER TABLE netstat ADD COLUMN " + str2 + " INT;");
            }
        }
        this.joT = System.currentTimeMillis();
        AppMethodBeat.o(151097);
    }

    public final k tU(int i2) {
        AppMethodBeat.i(151098);
        k kVar = this.joS.get(Integer.valueOf(i2));
        if (kVar == null) {
            Cursor query = this.iFy.query("netstat", null, "peroid = ".concat(String.valueOf(i2)), null, null, null, null, 2);
            if (query.moveToFirst()) {
                kVar = new k();
                kVar.convertFrom(query);
            }
            query.close();
            if (kVar != null) {
                this.joS.set(Integer.valueOf(i2), kVar);
            } else {
                RWCache<Integer, k> rWCache = this.joS;
                Integer valueOf = Integer.valueOf(i2);
                k kVar2 = new k();
                kVar2.cSx = 0;
                kVar2.id = 0;
                kVar2.jog = 0;
                kVar2.joh = 0;
                kVar2.joi = 0;
                kVar2.joj = 0;
                kVar2.jok = 0;
                kVar2.jol = 0;
                kVar2.jom = 0;
                kVar2.jon = 0;
                kVar2.joo = 0;
                kVar2.jop = 0;
                kVar2.joq = 0;
                kVar2.jor = 0;
                kVar2.jos = 0;
                kVar2.jot = 0;
                kVar2.jou = 0;
                kVar2.jov = 0;
                kVar2.jow = 0;
                kVar2.jox = 0;
                kVar2.joy = 0;
                kVar2.joz = 0;
                kVar2.joA = 0;
                kVar2.joB = 0;
                kVar2.joC = 0;
                kVar2.joD = 0;
                kVar2.joE = 0;
                kVar2.joF = 0;
                kVar2.joG = 0;
                kVar2.joH = 0;
                kVar2.joI = 0;
                rWCache.set(valueOf, kVar2);
            }
        } else if (kVar.jog != i2) {
            kVar = null;
        }
        AppMethodBeat.o(151098);
        return kVar;
    }

    public final void a(k kVar) {
        AppMethodBeat.i(151099);
        Assert.assertNotNull(kVar);
        long currentTimeMillis = System.currentTimeMillis();
        if (kVar.jog <= 0) {
            kVar.jog = (int) (currentTimeMillis / Util.MILLSECONDS_OF_DAY);
        }
        if (kVar.jog <= 0) {
            AppMethodBeat.o(151099);
            return;
        }
        k tU = tU(kVar.jog);
        if (tU == null || kVar.jog != tU.jog) {
            kVar.cSx |= 2;
            kVar.id = -1;
            if (tU != null) {
                Log.i("MicroMsg.NetStat", tU.toString());
            } else {
                Log.i("MicroMsg.NetStat", "NetStat started.");
            }
        } else {
            kVar.cSx = tU.cSx | 1;
            kVar.joh = (int) (((long) kVar.joh) + tU.joi);
            kVar.joi += tU.joi;
            kVar.joj = (int) (((long) kVar.joj) + tU.jok);
            kVar.jok += tU.jok;
            kVar.jol += tU.jol;
            kVar.jom += tU.jom;
            kVar.jon += tU.jon;
            kVar.joo += tU.joo;
            kVar.jop += tU.jop;
            kVar.joq += tU.joq;
            kVar.jor += tU.jor;
            kVar.jos += tU.jos;
            kVar.jot = (int) (((long) kVar.jot) + tU.jou);
            kVar.jou += tU.jou;
            kVar.jov = (int) (((long) kVar.jov) + tU.jow);
            kVar.jow += tU.jow;
            kVar.jox += tU.jox;
            kVar.joy += tU.joy;
            kVar.joz += tU.joz;
            kVar.joA += tU.joA;
            kVar.joB += tU.joB;
            kVar.joC += tU.joC;
            kVar.joD += tU.joD;
            kVar.joE += tU.joE;
            kVar.joF += tU.joF;
            kVar.joG += tU.joG;
            kVar.joH += tU.joH;
            kVar.joI += tU.joI;
            kVar.id = tU.id;
            kVar.cSx |= 2;
            if (currentTimeMillis - this.joT > 300000) {
                Log.i("MicroMsg.NetStat", kVar.toString());
            }
            b(kVar);
            AppMethodBeat.o(151099);
        }
        this.joT = currentTimeMillis;
        b(kVar);
        AppMethodBeat.o(151099);
    }

    public final boolean b(k kVar) {
        AppMethodBeat.i(151100);
        Assert.assertNotNull(kVar);
        Assert.assertTrue(kVar.jog > 0);
        boolean z = this.joS.set(Integer.valueOf(kVar.jog), kVar);
        AppMethodBeat.o(151100);
        return z;
    }

    public final long bgj() {
        AppMethodBeat.i(151101);
        this.joS.appendAll(true);
        int nowMilliSecond = (int) ((Util.nowMilliSecond() - 1296000000) / Util.MILLSECONDS_OF_DAY);
        int currentDayInMills = (int) (Util.currentDayInMills() / Util.MILLSECONDS_OF_DAY);
        Cursor rawQuery = this.iFy.rawQuery("SELECT peroid FROM netstat  WHERE peroid > " + nowMilliSecond + " order by peroid limit 1", null, 2);
        if (rawQuery.moveToFirst()) {
            currentDayInMills = rawQuery.getInt(rawQuery.getColumnIndex("peroid"));
        }
        rawQuery.close();
        long j2 = ((long) currentDayInMills) * Util.MILLSECONDS_OF_DAY;
        AppMethodBeat.o(151101);
        return j2;
    }

    public final k tV(int i2) {
        k kVar = null;
        AppMethodBeat.i(151102);
        this.joS.appendAll(true);
        Cursor rawQuery = this.iFy.rawQuery("SELECT MAX( id), MAX( peroid), SUM( textCountIn), SUM( textBytesIn), SUM( imageCountIn), SUM( imageBytesIn), SUM( voiceCountIn), SUM( voiceBytesIn), SUM( videoCountIn), SUM( videoBytesIn), SUM( mobileBytesIn), SUM( wifiBytesIn), SUM( sysMobileBytesIn), SUM( sysWifiBytesIn), SUM( textCountOut), SUM( textBytesOut), SUM( imageCountOut), SUM( imageBytesOut), SUM( voiceCountOut), SUM( voiceBytesOut), SUM( videoCountOut), SUM( videoBytesOut), SUM( mobileBytesOut), SUM( wifiBytesOut), SUM( sysMobileBytesOut), SUM( sysWifiBytesOut ), SUM( realMobileBytesIn ), SUM( realWifiBytesIn ), SUM( realMobileBytesOut ), SUM( realWifiBytesOut ) FROM netstat WHERE peroid >= ".concat(String.valueOf(i2)), null, 2);
        if (rawQuery.moveToFirst()) {
            kVar = new k();
            kVar.convertFrom(rawQuery);
        }
        rawQuery.close();
        AppMethodBeat.o(151102);
        return kVar;
    }

    @Override // com.tencent.mm.sdk.platformtools.RWCache.IRWCacheAppender
    public final boolean preAppend() {
        AppMethodBeat.i(151103);
        if (this.iFy.inTransaction()) {
            Log.i("MicroMsg.NetStat", "summer preAppend inTransaction return false");
            AppMethodBeat.o(151103);
            return false;
        }
        this.joR = this.iFy.beginTransaction(Thread.currentThread().getId());
        if (this.joR <= 0) {
            Log.i("MicroMsg.NetStat", "summer preAppend ticket: " + this.joR + " return false");
            AppMethodBeat.o(151103);
            return false;
        }
        AppMethodBeat.o(151103);
        return true;
    }

    @Override // com.tencent.mm.sdk.platformtools.RWCache.IRWCacheAppender
    public final void append(RWCache<Integer, k> rWCache, RWCache.Holder<Integer, k> holder) {
        AppMethodBeat.i(223642);
        int i2 = holder.funcType;
        V v = holder.values;
        if (v != null && i2 == 1) {
            int i3 = v.jog;
            int i4 = v.id;
            if (i3 > 0) {
                ContentValues contentValues = new ContentValues();
                if ((v.cSx & 2) != 0) {
                    contentValues.put("peroid", Integer.valueOf(v.jog));
                }
                if ((v.cSx & 4) != 0) {
                    contentValues.put("textCountIn", Integer.valueOf(v.joh));
                }
                if ((v.cSx & 8) != 0) {
                    contentValues.put("textBytesIn", Long.valueOf(v.joi));
                }
                if ((v.cSx & 16) != 0) {
                    contentValues.put("imageCountIn", Integer.valueOf(v.joj));
                }
                if ((v.cSx & 32) != 0) {
                    contentValues.put("imageBytesIn", Long.valueOf(v.jok));
                }
                if ((v.cSx & 64) != 0) {
                    contentValues.put("voiceCountIn", Integer.valueOf(v.jol));
                }
                if ((v.cSx & 128) != 0) {
                    contentValues.put("voiceBytesIn", Long.valueOf(v.jom));
                }
                if ((v.cSx & 256) != 0) {
                    contentValues.put("videoCountIn", Integer.valueOf(v.jon));
                }
                if ((v.cSx & 512) != 0) {
                    contentValues.put("videoBytesIn", Long.valueOf(v.joo));
                }
                if ((v.cSx & 1024) != 0) {
                    contentValues.put("mobileBytesIn", Long.valueOf(v.jop));
                }
                if ((v.cSx & 2048) != 0) {
                    contentValues.put("wifiBytesIn", Long.valueOf(v.joq));
                }
                if ((v.cSx & 4096) != 0) {
                    contentValues.put("sysMobileBytesIn", Long.valueOf(v.jor));
                }
                if ((v.cSx & 8192) != 0) {
                    contentValues.put("sysWifiBytesIn", Long.valueOf(v.jos));
                }
                if ((v.cSx & 16384) != 0) {
                    contentValues.put("textCountOut", Integer.valueOf(v.jot));
                }
                if ((v.cSx & 32768) != 0) {
                    contentValues.put("textBytesOut", Long.valueOf(v.jou));
                }
                if ((v.cSx & 65536) != 0) {
                    contentValues.put("imageCountOut", Integer.valueOf(v.jov));
                }
                if ((v.cSx & 131072) != 0) {
                    contentValues.put("imageBytesOut", Long.valueOf(v.jow));
                }
                if ((v.cSx & TPMediaCodecProfileLevel.HEVCMainTierLevel52) != 0) {
                    contentValues.put("voiceCountOut", Integer.valueOf(v.jox));
                }
                if ((v.cSx & 524288) != 0) {
                    contentValues.put("voiceBytesOut", Long.valueOf(v.joy));
                }
                if ((v.cSx & 1048576) != 0) {
                    contentValues.put("videoCountOut", Integer.valueOf(v.joz));
                }
                if ((v.cSx & TPMediaCodecProfileLevel.HEVCHighTierLevel6) != 0) {
                    contentValues.put("videoBytesOut", Long.valueOf(v.joA));
                }
                if ((v.cSx & 4194304) != 0) {
                    contentValues.put("mobileBytesOut", Long.valueOf(v.joB));
                }
                if ((v.cSx & TPMediaCodecProfileLevel.HEVCHighTierLevel61) != 0) {
                    contentValues.put("wifiBytesOut", Long.valueOf(v.joC));
                }
                if ((v.cSx & TPMediaCodecProfileLevel.HEVCMainTierLevel62) != 0) {
                    contentValues.put("sysMobileBytesOut", Long.valueOf(v.joD));
                }
                if ((v.cSx & TPMediaCodecProfileLevel.HEVCHighTierLevel62) != 0) {
                    contentValues.put("sysWifiBytesOut", Long.valueOf(v.joE));
                }
                if ((v.cSx & 67108864) != 0) {
                    contentValues.put("realMobileBytesIn", Long.valueOf(v.joF));
                }
                if ((v.cSx & 134217728) != 0) {
                    contentValues.put("realWifiBytesIn", Long.valueOf(v.joG));
                }
                if ((v.cSx & 268435456) != 0) {
                    contentValues.put("realMobileBytesOut", Long.valueOf(v.joH));
                }
                if ((v.cSx & 536870912) != 0) {
                    contentValues.put("realWifiBytesOut", Long.valueOf(v.joI));
                }
                if (i4 < 0) {
                    v.id = (int) this.iFy.insert("netstat", "id", contentValues);
                    AppMethodBeat.o(223642);
                    return;
                }
                this.iFy.update("netstat", contentValues, "peroid=".concat(String.valueOf(i3)), null);
            }
        }
        AppMethodBeat.o(223642);
    }

    @Override // com.tencent.mm.sdk.platformtools.RWCache.IRWCacheAppender
    public final void postAppend() {
        AppMethodBeat.i(151105);
        if (this.joR > 0) {
            this.iFy.endTransaction(this.joR);
        }
        AppMethodBeat.o(151105);
    }
}
