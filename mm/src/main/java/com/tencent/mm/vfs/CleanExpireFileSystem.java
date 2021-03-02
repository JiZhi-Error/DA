package com.tencent.mm.vfs;

import android.annotation.TargetApi;
import android.database.Cursor;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.Message;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.system.ErrnoException;
import android.system.Os;
import android.system.StructStat;
import com.tencent.kinda.framework.app.KindaConfigCacheStg;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.h.d;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.protocal.protobuf.aai;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.al;
import com.tencent.mm.storage.am;
import com.tencent.mm.vfs.ExpireFileSystem;
import com.tencent.mm.vfs.FileSystem;
import com.tencent.tav.coremedia.TimeUtil;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.ByteChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class CleanExpireFileSystem extends ExpireFileSystem {
    public static final Parcelable.Creator<CleanExpireFileSystem> CREATOR = new Parcelable.Creator<CleanExpireFileSystem>() {
        /* class com.tencent.mm.vfs.CleanExpireFileSystem.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ CleanExpireFileSystem[] newArray(int i2) {
            return new CleanExpireFileSystem[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ CleanExpireFileSystem createFromParcel(Parcel parcel) {
            AppMethodBeat.i(197186);
            CleanExpireFileSystem cleanExpireFileSystem = new CleanExpireFileSystem(parcel);
            AppMethodBeat.o(197186);
            return cleanExpireFileSystem;
        }
    };
    private final boolean RaW;
    private final long RaX;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public CleanExpireFileSystem(com.tencent.mm.vfs.FileSystem r13) {
        /*
            r12 = this;
            r6 = 604800000(0x240c8400, double:2.988109026E-315)
            r10 = 0
            r8 = 197198(0x3024e, float:2.76333E-40)
            r1 = 1
            r0 = 0
            com.tencent.mm.plugin.expt.h.d r2 = com.tencent.mm.plugin.expt.h.d.cRY()
            java.lang.String r3 = "clicfg_clean_expire_default_expire_time"
            java.lang.String r4 = java.lang.Long.toString(r6)
            java.lang.String r2 = r2.b(r3, r4, r0, r1)
            long r4 = com.tencent.mm.sdk.platformtools.Util.getLong(r2, r6)
            com.tencent.mm.plugin.expt.h.d r2 = com.tencent.mm.plugin.expt.h.d.cRY()
            java.lang.String r3 = "clicfg_clean_expire_need_reset_expire_time"
            java.lang.String r6 = "0"
            java.lang.String r2 = r2.b(r3, r6, r0, r1)
            int r2 = com.tencent.mm.sdk.platformtools.Util.getInt(r2, r0)
            if (r2 <= 0) goto L_0x0032
            r0 = r1
        L_0x0032:
            java.lang.String r2 = "CleanExpireFileSystem"
            com.tencent.mm.sdk.platformtools.MultiProcessMMKV r6 = com.tencent.mm.sdk.platformtools.MultiProcessMMKV.getMMKV(r2)
            java.lang.String r2 = "CleanExpireCurrentExpireTime"
            long r2 = r6.getLong(r2, r10)
            int r7 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1))
            if (r7 <= 0) goto L_0x004a
            int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r7 > 0) goto L_0x004a
            if (r0 == 0) goto L_0x0051
        L_0x004a:
            java.lang.String r0 = "CleanExpireCurrentExpireTime"
            r6.encode(r0, r4)
            r2 = r4
        L_0x0051:
            r12.<init>(r13, r2)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r8)
            r2 = 60000(0xea60, double:2.9644E-319)
            r12.RaX = r2
            r12.RaW = r1
            com.tencent.matrix.trace.core.AppMethodBeat.o(r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.vfs.CleanExpireFileSystem.<init>(com.tencent.mm.vfs.FileSystem):void");
    }

    protected CleanExpireFileSystem(Parcel parcel) {
        super(parcel);
        AppMethodBeat.i(197199);
        this.RaX = Util.MILLSECONDS_OF_MINUTE;
        aa.a(parcel, CleanExpireFileSystem.class, 2);
        this.RaW = parcel.readByte() != 0;
        AppMethodBeat.o(197199);
    }

    @Override // com.tencent.mm.vfs.FileSystem, com.tencent.mm.vfs.ExpireFileSystem
    public final FileSystem.b cj(Map<String, String> map) {
        AppMethodBeat.i(197200);
        a aVar = new a(this.Rbo.cj(map));
        AppMethodBeat.o(197200);
        return aVar;
    }

    @Override // com.tencent.mm.vfs.ExpireFileSystem
    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(197201);
        super.writeToParcel(parcel, i2);
        aa.b(parcel, CleanExpireFileSystem.class, 2);
        parcel.writeByte((byte) (this.RaW ? 1 : 0));
        AppMethodBeat.o(197201);
    }

    @Override // com.tencent.mm.vfs.ExpireFileSystem
    public String toString() {
        AppMethodBeat.i(197202);
        String str = "CleanExpire [" + this.Rbo.toString() + "]";
        AppMethodBeat.o(197202);
        return str;
    }

    static {
        AppMethodBeat.i(197203);
        AppMethodBeat.o(197203);
    }

    protected class a extends ExpireFileSystem.a implements Handler.Callback {
        private final Object RaY = new Object();
        private HashMap<String, Long> RaZ;
        private final Handler Rba;

        public a(FileSystem.b bVar) {
            super(bVar);
            AppMethodBeat.i(197187);
            if (CleanExpireFileSystem.this.RaW) {
                this.RaZ = new HashMap<>();
                this.Rba = new Handler(g.hYQ().Vmp.getLooper(), this);
                AppMethodBeat.o(197187);
                return;
            }
            this.RaZ = null;
            this.Rba = null;
            AppMethodBeat.o(197187);
        }

        private void dA(String str, boolean z) {
            boolean isEmpty;
            AppMethodBeat.i(197188);
            if (!CleanExpireFileSystem.this.RaW) {
                AppMethodBeat.o(197188);
            } else if (z) {
                synchronized (this.RaY) {
                    try {
                        this.RaZ.remove(str);
                    } finally {
                        AppMethodBeat.o(197188);
                    }
                }
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                synchronized (this.RaY) {
                    try {
                        isEmpty = this.RaZ.isEmpty();
                        this.RaZ.put(str, Long.valueOf(currentTimeMillis));
                    } finally {
                        AppMethodBeat.o(197188);
                    }
                }
                if (isEmpty) {
                    this.Rba.sendMessageDelayed(Message.obtain(), Util.MILLSECONDS_OF_MINUTE);
                }
            }
        }

        @Override // com.tencent.mm.vfs.FileSystem.b, com.tencent.mm.vfs.c
        public final InputStream openRead(String str) {
            AppMethodBeat.i(197189);
            InputStream openRead = this.Rbp.openRead(str);
            dA(str, false);
            AppMethodBeat.o(197189);
            return openRead;
        }

        @Override // com.tencent.mm.vfs.a, com.tencent.mm.vfs.FileSystem.b, com.tencent.mm.vfs.c
        public final ReadableByteChannel boI(String str) {
            AppMethodBeat.i(197190);
            ReadableByteChannel boI = this.Rbp.boI(str);
            dA(str, false);
            AppMethodBeat.o(197190);
            return boI;
        }

        @Override // com.tencent.mm.vfs.FileSystem.b, com.tencent.mm.vfs.c
        public final OutputStream dw(String str, boolean z) {
            AppMethodBeat.i(197191);
            OutputStream dw = this.Rbp.dw(str, z);
            dA(str, true);
            AppMethodBeat.o(197191);
            return dw;
        }

        @Override // com.tencent.mm.vfs.a, com.tencent.mm.vfs.FileSystem.b, com.tencent.mm.vfs.c
        public final WritableByteChannel dv(String str, boolean z) {
            AppMethodBeat.i(197192);
            WritableByteChannel dv = this.Rbp.dv(str, z);
            dA(str, true);
            AppMethodBeat.o(197192);
            return dv;
        }

        @Override // com.tencent.mm.vfs.a, com.tencent.mm.vfs.FileSystem.b, com.tencent.mm.vfs.c
        public final ByteChannel boJ(String str) {
            AppMethodBeat.i(197193);
            ByteChannel boJ = this.Rbp.boJ(str);
            dA(str, true);
            AppMethodBeat.o(197193);
            return boJ;
        }

        @Override // com.tencent.mm.vfs.a, com.tencent.mm.vfs.FileSystem.b, com.tencent.mm.vfs.c
        public final ParcelFileDescriptor nr(String str, String str2) {
            AppMethodBeat.i(197194);
            ParcelFileDescriptor nr = this.Rbp.nr(str, str2);
            dA(str, str2.contains("w"));
            AppMethodBeat.o(197194);
            return nr;
        }

        @Override // com.tencent.mm.vfs.a, com.tencent.mm.vfs.FileSystem.b, com.tencent.mm.vfs.c, com.tencent.mm.vfs.ExpireFileSystem.a
        public final void a(CancellationSignal cancellationSignal) {
            long j2;
            long j3;
            float f2;
            float f3;
            long j4;
            long j5;
            double d2;
            aai aai;
            double d3;
            AppMethodBeat.i(197195);
            CleanExpireFileSystem.this.l(1, new Object[0]);
            if (CleanExpireFileSystem.this.RaW) {
                HashMap<String, Long> hashMap = null;
                synchronized (this.RaY) {
                    try {
                        if (!this.RaZ.isEmpty()) {
                            hashMap = this.RaZ;
                            this.RaZ = new HashMap<>();
                        }
                    } catch (Throwable th) {
                        AppMethodBeat.o(197195);
                        throw th;
                    }
                }
                if (hashMap != null) {
                    for (Map.Entry<String, Long> entry : hashMap.entrySet()) {
                        cancellationSignal.throwIfCanceled();
                        this.Rbp.ck(entry.getKey(), entry.getValue().longValue());
                    }
                }
            }
            cancellationSignal.throwIfCanceled();
            int i2 = 0;
            PLong pLong = new PLong();
            PLong pLong2 = new PLong();
            int i3 = -1;
            int i4 = -1;
            MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("CleanExpireFileSystem");
            long j6 = mmkv.getLong("CleanExpireCurrentExpireTime", 0);
            long j7 = Util.getLong(d.cRY().b("clicfg_clean_expire_default_expire_time", Long.toString(604800000), false, true), 604800000);
            if (j6 < 0 || j6 > j7) {
                mmkv.encode("CleanExpireCurrentExpireTime", j7);
                j2 = j7;
            } else {
                j2 = j6;
            }
            long currentTimeMillis = System.currentTimeMillis();
            int count = am.gBD().getCount();
            int i5 = Util.getInt(d.cRY().b("clicfg_clean_expire_storage_min", "100", false, true), 100);
            if (count > i5) {
                am gBD = am.gBD();
                String format = String.format("SELECT SUM(IdCount) FROM (SELECT COUNT( %s ) AS IdCount FROM %s GROUP BY %s ) %s WHERE IdCount > 1", "id", "CleanDeleteItem", "id", "CleanDeleteItem");
                Log.d("MicroMsg.CleanDeleteItemStorage", "calculateRepetitionCount:".concat(String.valueOf(format)));
                Cursor rawQuery = gBD.db.rawQuery(format, null);
                int i6 = 0;
                if (rawQuery == null) {
                    Log.e("MicroMsg.CleanDeleteItemStorage", "calculateTheRepetitionRatio failed");
                    i6 = 0;
                } else {
                    if (rawQuery.moveToFirst()) {
                        i6 = rawQuery.getInt(0);
                    }
                    rawQuery.close();
                    Log.i("MicroMsg.CleanDeleteItemStorage", "calculateRepetitionCount, count:%d,", Integer.valueOf(i6));
                }
                f3 = (((float) i6) * 1000000.0f) / ((float) count);
                int i7 = Util.getInt(d.cRY().b("clicfg_clean_expire_repetition_ratio_list_size", "28", false, true), 28);
                String string = mmkv.getString("CleanExpireRepetitionRatioList", "");
                aai aai2 = new aai();
                if (!Util.isNullOrNil(string)) {
                    try {
                        aai2.parseFrom(string.getBytes(KindaConfigCacheStg.SAVE_CHARSET));
                    } catch (IOException e2) {
                        Log.e("VFS.CleanExpireFileSystem", "Parsing Failed: %s", e2.getMessage());
                    }
                }
                if (aai2.Llw == null) {
                    aai2.Llw = new LinkedList<>();
                }
                while (aai2.Llw.size() > i7) {
                    aai2.Llw.removeFirst();
                }
                aai2.Llw.add(Float.valueOf(f3));
                int size = aai2.Llw.size();
                try {
                    mmkv.encode("CleanExpireRepetitionRatioList", new String(aai2.toByteArray(), kotlin.n.d.ISO_8859_1));
                } catch (IOException e3) {
                    Log.e("VFS.CleanExpireFileSystem", "toByteArray Failed: %s", e3.getMessage());
                }
                if (size >= Util.getInt(d.cRY().b("clicfg_clean_expire_repetition_ratio_min_size", "7", false, true), 7)) {
                    int i8 = Util.getInt(d.cRY().b("clicfg_clean_expire_change_switch", "2", false, true), 2);
                    if (i8 > 0) {
                        double d4 = 0.0d;
                        if (i8 == 1) {
                            double d5 = (double) (Util.getFloat(d.cRY().b("clicfg_clean_expire_repetition_ratio_left_range", "0.009", false, true), 0.009f) * 1000000.0f);
                            d2 = (double) (Util.getFloat(d.cRY().b("clicfg_clean_expire_repetition_ratio_right_range", "0.011", false, true), 0.011f) * 1000000.0f);
                            d4 = d5;
                        } else if (i8 == 2) {
                            if (aai2.Llw == null) {
                                String string2 = mmkv.getString("CleanExpireRepetitionRatioList", "");
                                aai aai3 = new aai();
                                if (!Util.isNullOrNil(string2)) {
                                    try {
                                        aai3.parseFrom(string2.getBytes(KindaConfigCacheStg.SAVE_CHARSET));
                                    } catch (IOException e4) {
                                        Log.e("VFS.CleanExpireFileSystem", "Parsing Failed: %s", e4.getMessage());
                                    }
                                }
                                if (aai3.Llw == null) {
                                    aai3.Llw = new LinkedList<>();
                                }
                                aai = aai3;
                            } else {
                                aai = aai2;
                            }
                            int size2 = aai.Llw.size();
                            float f4 = 0.0f;
                            if (size2 > 0) {
                                Float valueOf = Float.valueOf(0.0f);
                                Iterator<Float> it = aai.Llw.iterator();
                                while (it.hasNext()) {
                                    valueOf = Float.valueOf(it.next().floatValue() + valueOf.floatValue());
                                }
                                float floatValue = valueOf.floatValue() / ((float) size2);
                                Double valueOf2 = Double.valueOf(0.0d);
                                Iterator<Float> it2 = aai.Llw.iterator();
                                while (it2.hasNext()) {
                                    valueOf2 = Double.valueOf(Math.pow((double) (it2.next().floatValue() - floatValue), 2.0d) + valueOf2.doubleValue());
                                }
                                d3 = Math.sqrt(valueOf2.doubleValue() / ((double) size2));
                                f4 = floatValue;
                            } else {
                                d3 = 0.0d;
                            }
                            int i9 = Util.getInt(d.cRY().b("clicfg_clean_expire_repetition_ratio_left_range_var_count", "1", false, true), 1);
                            int i10 = Util.getInt(d.cRY().b("clicfg_clean_expire_repetition_ratio_right_range_var_count", "2", false, true), 2);
                            float f5 = 1000000.0f * Util.getFloat(d.cRY().b("clicfg_clean_expire_repetition_min", "-1", false, true), -1.0f);
                            float f6 = 1000000.0f * Util.getFloat(d.cRY().b("clicfg_clean_expire_repetition_max", "-1", false, true), -1.0f);
                            double d6 = (((double) i9) * d3) + ((double) f4);
                            d2 = (d3 * ((double) i10)) + ((double) f4);
                            if (f5 > 0.0f && d6 < ((double) f5)) {
                                d6 = (double) f5;
                                if (d2 < ((double) f5)) {
                                    if (f6 > 0.0f) {
                                        d2 = (double) f6;
                                        d4 = d6;
                                    } else {
                                        d2 = ((double) f5) * 1.1d;
                                        d4 = d6;
                                    }
                                }
                            }
                            d4 = d6;
                        } else {
                            d2 = 0.0d;
                        }
                        Long l = 259200000L;
                        long j8 = Util.getLong(d.cRY().b("clicfg_clean_expire_time_change_threshold", l.toString(), false, true), 259200000);
                        long j9 = Util.getLong(d.cRY().b("clicfg_clean_expire_time_change_step", Long.valueOf((long) Util.MILLSECONDS_OF_DAY).toString(), false, true), Util.MILLSECONDS_OF_DAY);
                        float f7 = Util.getFloat(d.cRY().b("clicfg_clean_expire_time_change_step_ratio", Float.valueOf(888888.9f).toString(), false, true), 888888.9f);
                        if (((double) f3) > d2) {
                            j5 = j2 + j9;
                            i3 = 1;
                            if (j5 > j7) {
                                j5 = j7;
                            }
                        } else if (((double) f3) < d4) {
                            i3 = 2;
                            if (j2 > j8) {
                                j5 = j2 - j9;
                            } else {
                                j5 = ((long) (((float) j2) * f7)) / TimeUtil.SECOND_TO_US;
                            }
                            if (j5 < 0) {
                                j5 = j2;
                            }
                        } else {
                            i3 = 0;
                            j5 = j2;
                        }
                        mmkv.encode("CleanExpireCurrentExpireTime", j5);
                    } else {
                        j5 = j2;
                    }
                    am.gBD().a(j7, pLong, pLong2);
                    am gBD2 = am.gBD();
                    String format2 = String.format("SELECT SUM(IdCount) FROM (SELECT COUNT( %s ) AS IdCount FROM %s WHERE %s >= %d GROUP BY %s ) %s WHERE IdCount > 1", "id", "CleanDeleteItem", "saveTime", Long.valueOf(j7), "id", "CleanDeleteItem");
                    Log.d("MicroMsg.CleanDeleteItemStorage", "calculateDefaultRepetitionCount:".concat(String.valueOf(format2)));
                    Cursor rawQuery2 = gBD2.db.rawQuery(format2, null);
                    int i11 = 0;
                    if (rawQuery2 == null) {
                        Log.e("MicroMsg.CleanDeleteItemStorage", "calculateTheRepetitionRatio failed");
                        i11 = 0;
                    } else {
                        if (rawQuery2.moveToFirst()) {
                            i11 = rawQuery2.getInt(0);
                        }
                        rawQuery2.close();
                        Log.i("MicroMsg.CleanDeleteItemStorage", "calculateDefaultRepetitionCount, threshold:%d, count:%d,", Long.valueOf(j7), Integer.valueOf(i11));
                    }
                    long j10 = (long) i11;
                    if (count > i5) {
                        f2 = (((float) j10) * 1000000.0f) / ((float) count);
                        j3 = j5;
                        i4 = i8;
                        i2 = size;
                    } else {
                        j3 = j5;
                        i4 = i8;
                        f2 = -1.0f;
                        i2 = size;
                    }
                } else {
                    j3 = j2;
                    f2 = -1.0f;
                    i2 = size;
                }
            } else {
                j3 = j2;
                f2 = -1.0f;
                f3 = -1.0f;
            }
            long currentTimeMillis2 = -1 + (System.currentTimeMillis() - currentTimeMillis);
            long currentTimeMillis3 = System.currentTimeMillis() - j3;
            Iterable<e> dx = this.Rbp.dx("", true);
            if (dx != null) {
                j4 = 0;
                for (e eVar : dx) {
                    cancellationSignal.throwIfCanceled();
                    if (!eVar.RbJ && eVar.RbI <= currentTimeMillis3) {
                        long c2 = c(eVar);
                        if (eVar.hdW()) {
                            long j11 = eVar.RbH < 0 ? eVar.size : eVar.RbH;
                            j4 += j11;
                            if (!eVar.name.endsWith(FilePathGenerator.NO_MEDIA_FILENAME)) {
                                al alVar = new al();
                                alVar.field_createTime = c2;
                                if (alVar.field_createTime < 0) {
                                    alVar.field_createTime = eVar.RbI;
                                }
                                alVar.field_modifyTime = eVar.RbI;
                                alVar.field_deleteTime = System.currentTimeMillis();
                                alVar.field_id = eVar.name;
                                alVar.field_saveTime = alVar.field_deleteTime - alVar.field_createTime;
                                alVar.field_size = j11;
                                alVar.field_flags = 0;
                                am.gBD().insert(alVar);
                            }
                        }
                        j4 = j4;
                    }
                }
            } else {
                j4 = 0;
            }
            long currentTimeMillis4 = System.currentTimeMillis();
            long j12 = Util.getLong(d.cRY().b("clicfg_clean_expire_storage_count", "50000", false, true), 20000);
            if (((long) am.gBD().getCount()) > j12) {
                am gBD3 = am.gBD();
                long count2 = (long) gBD3.getCount();
                if (count2 <= j12) {
                    Log.i("MicroMsg.CleanDeleteItemStorage", "cleanDate don't need to clean");
                }
                String format3 = String.format("DELETE FROM %s WHERE %s IN ( SELECT %s FROM %s ORDER BY %s LIMIT %d )", "CleanDeleteItem", "deleteTime", "deleteTime", "CleanDeleteItem", "deleteTime", Long.valueOf(count2 - j12));
                Log.d("MicroMsg.CleanDeleteItemStorage", "cleanData:".concat(String.valueOf(format3)));
                Log.i("MicroMsg.CleanDeleteItemStorage", "cleanData result:%b, size:%d, originCount:%d, finalCount:%d", Boolean.valueOf(gBD3.db.execSQL("CleanDeleteItem", format3)), Long.valueOf(j12), Long.valueOf(count2), Integer.valueOf(gBD3.getCount()));
            }
            CleanExpireFileSystem.this.l(3, "cleanStorageCount", Integer.valueOf(count), "cleanRepetitionRatio", Float.valueOf(f3), "cleanRepetitionRatioCount", Integer.valueOf(i2), "cleanStorageRepetitionRatio", Float.valueOf(f2), "cleanStorageDeleteSize", Long.valueOf(pLong.value), "cleanStorageFreeSize", Long.valueOf(pLong2.value), "deleteSize", Long.valueOf(j4), "cleanOriginExpireTime", Long.valueOf(j2), "cleanNewExpireTime", Long.valueOf(j3), "cleanExtraCostTime", Long.valueOf((System.currentTimeMillis() - currentTimeMillis4) + currentTimeMillis2), "cleanTrend", Integer.valueOf(i3), "changeSwitch", Integer.valueOf(i4));
            for (FileSystem.b bVar : hdS()) {
                cancellationSignal.throwIfCanceled();
                bVar.a(cancellationSignal);
            }
            AppMethodBeat.o(197195);
        }

        @TargetApi(21)
        private static long c(e eVar) {
            AppMethodBeat.i(197196);
            StructStat structStat = null;
            if (eVar != null) {
                try {
                    if (eVar.RbK != null && (eVar.RbK.hdQ() instanceof NativeFileSystem)) {
                        structStat = Os.stat(eVar.RbK.dz(eVar.NGP, false));
                    }
                } catch (ErrnoException e2) {
                    AppMethodBeat.o(197196);
                    return -1;
                }
            }
            if (structStat == null) {
                AppMethodBeat.o(197196);
                return -1;
            }
            long j2 = structStat.st_ctime;
            AppMethodBeat.o(197196);
            return j2;
        }

        public final boolean handleMessage(Message message) {
            HashMap<String, Long> hashMap;
            AppMethodBeat.i(197197);
            synchronized (this.RaY) {
                try {
                    if (!this.RaZ.isEmpty()) {
                        HashMap<String, Long> hashMap2 = this.RaZ;
                        this.RaZ = new HashMap<>();
                        hashMap = hashMap2;
                    } else {
                        hashMap = null;
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(197197);
                    throw th;
                }
            }
            if (hashMap != null) {
                for (Map.Entry<String, Long> entry : hashMap.entrySet()) {
                    this.Rbp.ck(entry.getKey(), entry.getValue().longValue());
                }
                Log.d("VFS.CleanExpireFileSystem", "Flush access time cache entries: " + hashMap.size());
            }
            AppMethodBeat.o(197197);
            return true;
        }
    }
}
