package com.tencent.mm.ui.conversation;

import android.database.AbstractCursor;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public final class m extends AbstractCursor {
    private a[] Qgl;
    private int Qgm;
    private int Qgn;
    int Qgo;
    LinkedList<c> Qgp;
    private final b Qgq;
    private Cursor To;
    private DataSetObserver mObserver;
    private int rIF;

    public enum e {
        ASC(1),
        DESC(-1);
        
        final int op;

        public static e valueOf(String str) {
            AppMethodBeat.i(234223);
            e eVar = (e) Enum.valueOf(e.class, str);
            AppMethodBeat.o(234223);
            return eVar;
        }

        static {
            AppMethodBeat.i(234224);
            AppMethodBeat.o(234224);
        }

        private e(int i2) {
            this.op = i2;
        }
    }

    public static final class b {
        long Qgt = 0;
        private long Qgu = 0;
        private long Qgv = 0;
        long Qgw = 0;
        long Qgx = 0;

        static /* synthetic */ long a(b bVar) {
            long j2 = bVar.Qgu;
            bVar.Qgu = 1 + j2;
            return j2;
        }

        static /* synthetic */ long b(b bVar) {
            long j2 = bVar.Qgv;
            bVar.Qgv = 1 + j2;
            return j2;
        }

        public final String toString() {
            AppMethodBeat.i(234219);
            try {
                String format = String.format("total=%d, hit=%d [%.2f%%], reset,fill=%d, %d [%.2f%%], compare=%d [%.2f%%]", Long.valueOf(this.Qgt), Long.valueOf(this.Qgu), Float.valueOf((((float) this.Qgu) * 100.0f) / ((float) this.Qgt)), Long.valueOf(this.Qgv), Long.valueOf(this.Qgw), Float.valueOf((((float) this.Qgv) * 100.0f) / ((float) this.Qgw)), Long.valueOf(this.Qgx), Float.valueOf((((float) this.Qgx) * 100.0f) / ((float) this.Qgt)));
                AppMethodBeat.o(234219);
                return format;
            } catch (Throwable th) {
                StringBuilder sb = new StringBuilder();
                sb.append("total=").append(this.Qgt).append("hit=").append(this.Qgu).append("clearWindow=").append(this.Qgv).append("fillWindow=").append(this.Qgw).append("compare=").append(this.Qgx);
                String sb2 = sb.toString();
                AppMethodBeat.o(234219);
                return sb2;
            }
        }
    }

    public static final class c {
        public final d QgA;
        public final int Qgy;
        public final int Qgz;

        public c(int i2, int i3, d dVar) {
            this.Qgy = i2;
            this.Qgz = i3;
            this.QgA = dVar;
        }
    }

    public static class d implements Comparable<d> {
        public static final d QgB = new d(0);
        public long QgC = 0;
        public int QgD = 0;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // java.lang.Comparable
        public final /* synthetic */ int compareTo(d dVar) {
            AppMethodBeat.i(234220);
            int a2 = a(dVar);
            AppMethodBeat.o(234220);
            return a2;
        }

        static {
            AppMethodBeat.i(234221);
            AppMethodBeat.o(234221);
        }

        public d() {
        }

        public d(long j2) {
            this.QgC = j2;
            this.QgD = 0;
        }

        public final int hashCode() {
            return (this.QgD << 31) | ((int) this.QgC);
        }

        public final int a(d dVar) {
            if (this == dVar) {
                return 0;
            }
            if (dVar == null || QgB == dVar) {
                return 1;
            }
            if (this.QgD == dVar.QgD && this.QgC == dVar.QgC) {
                return 0;
            }
            if (this.QgD != dVar.QgD) {
                return this.QgD - dVar.QgD;
            }
            long j2 = this.QgC - dVar.QgC;
            if (j2 < 0) {
                return -1;
            }
            return j2 != 0 ? 1 : 0;
        }
    }

    public static abstract class a {
        private final LinkedHashMap<String, Integer> Qgs = new LinkedHashMap<>();

        /* access modifiers changed from: protected */
        public abstract d c(Cursor cursor, int i2);

        /* access modifiers changed from: protected */
        public abstract Cursor gVZ();

        public final d anY(int i2) {
            Cursor gVZ = gVZ();
            if (gVZ == null) {
                return new d((long) i2);
            }
            if (i2 < 0) {
                try {
                    return d.QgB;
                } catch (Throwable th) {
                    return d.QgB;
                }
            } else {
                gVZ.moveToPosition(i2);
                return c(gVZ, i2);
            }
        }

        /* access modifiers changed from: protected */
        public final int b(Cursor cursor, String str) {
            Integer num = this.Qgs.get(str);
            if (num != null) {
                return num.intValue();
            }
            String[] columnNames = cursor.getColumnNames();
            for (int i2 = 0; i2 < columnNames.length; i2++) {
                if (str.equals(columnNames[i2])) {
                    this.Qgs.put(str, Integer.valueOf(i2));
                    return i2;
                }
            }
            this.Qgs.put(str, -1);
            return -1;
        }
    }

    public static m gWa() {
        AppMethodBeat.i(234225);
        m mVar = new m(new a() {
            /* class com.tencent.mm.ui.conversation.m.AnonymousClass2 */

            @Override // com.tencent.mm.ui.conversation.m.a
            public final Cursor gVZ() {
                return null;
            }

            /* access modifiers changed from: protected */
            @Override // com.tencent.mm.ui.conversation.m.a
            public final d c(Cursor cursor, int i2) {
                AppMethodBeat.i(234218);
                d dVar = new d((long) i2);
                AppMethodBeat.o(234218);
                return dVar;
            }
        });
        AppMethodBeat.o(234225);
        return mVar;
    }

    private m(a... aVarArr) {
        this(e.ASC, aVarArr);
    }

    public m(e eVar, a... aVarArr) {
        AppMethodBeat.i(234226);
        this.mObserver = new DataSetObserver() {
            /* class com.tencent.mm.ui.conversation.m.AnonymousClass1 */

            public final void onChanged() {
                AppMethodBeat.i(234216);
                m.this.mPos = -1;
                m.this.gWb();
                AppMethodBeat.o(234216);
            }

            public final void onInvalidated() {
                AppMethodBeat.i(234217);
                m.this.mPos = -1;
                m.this.gWb();
                AppMethodBeat.o(234217);
            }
        };
        this.rIF = -1;
        this.Qgm = e.ASC.op;
        this.Qgn = 100;
        this.Qgo = -1;
        this.Qgp = new LinkedList<>();
        this.Qgq = new b();
        this.Qgm = eVar.op;
        if (aVarArr.length < 2) {
            this.Qgl = aVarArr;
        } else {
            this.Qgl = new a[]{aVarArr[0], aVarArr[1]};
        }
        this.To = this.Qgl[0].gVZ();
        for (int i2 = 0; i2 < this.Qgl.length; i2++) {
            if (anX(i2) != null) {
                anX(i2).registerDataSetObserver(this.mObserver);
            }
        }
        AppMethodBeat.o(234226);
    }

    public final int getCount() {
        AppMethodBeat.i(234227);
        int length = this.Qgl.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            if (anX(i3) != null) {
                i2 += anX(i3).getCount();
            }
        }
        AppMethodBeat.o(234227);
        return i2;
    }

    public final boolean onMove(int i2, int i3) {
        AppMethodBeat.i(234228);
        this.Qgq.Qgt++;
        this.rIF = i3;
        if (this.Qgl.length < 2) {
            boolean anU = anU(i3);
            AppMethodBeat.o(234228);
            return anU;
        }
        boolean anV = anV(i3);
        AppMethodBeat.o(234228);
        return anV;
    }

    private boolean anU(int i2) {
        boolean z = false;
        AppMethodBeat.i(234229);
        try {
            b.a(this.Qgq);
            this.To = this.Qgl[0].gVZ();
            z = this.To.moveToPosition(i2);
            AppMethodBeat.o(234229);
        } catch (Throwable th) {
            Log.w("MergeSortCursorWrapper", "onMoveOneCursorOnly fail:" + th.getMessage());
            AppMethodBeat.o(234229);
        }
        return z;
    }

    public final void gWb() {
        AppMethodBeat.i(234231);
        if (this.Qgo != -1) {
            b.b(this.Qgq);
        }
        this.Qgo = -1;
        this.Qgp = new LinkedList<>();
        AppMethodBeat.o(234231);
    }

    private c anW(int i2) {
        AppMethodBeat.i(234232);
        try {
            c cVar = this.Qgp.get(i2 - this.Qgo);
            AppMethodBeat.o(234232);
            return cVar;
        } catch (IndexOutOfBoundsException e2) {
            Log.w("MergeSortCursorWrapper", "locateElement fail:" + e2.getMessage());
            AppMethodBeat.o(234232);
            return null;
        }
    }

    public final String getString(int i2) {
        AppMethodBeat.i(234233);
        String string = gWc().getString(i2);
        AppMethodBeat.o(234233);
        return string;
    }

    public final short getShort(int i2) {
        AppMethodBeat.i(234234);
        short s = gWc().getShort(i2);
        AppMethodBeat.o(234234);
        return s;
    }

    public final int getInt(int i2) {
        AppMethodBeat.i(234235);
        int i3 = gWc().getInt(i2);
        AppMethodBeat.o(234235);
        return i3;
    }

    public final long getLong(int i2) {
        AppMethodBeat.i(234236);
        long j2 = gWc().getLong(i2);
        AppMethodBeat.o(234236);
        return j2;
    }

    public final float getFloat(int i2) {
        AppMethodBeat.i(234237);
        float f2 = gWc().getFloat(i2);
        AppMethodBeat.o(234237);
        return f2;
    }

    public final double getDouble(int i2) {
        AppMethodBeat.i(234238);
        double d2 = gWc().getDouble(i2);
        AppMethodBeat.o(234238);
        return d2;
    }

    public final int getType(int i2) {
        AppMethodBeat.i(234239);
        int type = gWc().getType(i2);
        AppMethodBeat.o(234239);
        return type;
    }

    public final boolean isNull(int i2) {
        AppMethodBeat.i(234240);
        boolean isNull = gWc().isNull(i2);
        AppMethodBeat.o(234240);
        return isNull;
    }

    public final byte[] getBlob(int i2) {
        AppMethodBeat.i(234241);
        byte[] blob = gWc().getBlob(i2);
        AppMethodBeat.o(234241);
        return blob;
    }

    public final String[] getColumnNames() {
        AppMethodBeat.i(234242);
        if (this.To != null) {
            String[] columnNames = gWc().getColumnNames();
            AppMethodBeat.o(234242);
            return columnNames;
        }
        String[] strArr = new String[0];
        AppMethodBeat.o(234242);
        return strArr;
    }

    public final void deactivate() {
        AppMethodBeat.i(234243);
        int length = this.Qgl.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (anX(i2) != null) {
                anX(i2).deactivate();
            }
        }
        super.deactivate();
        AppMethodBeat.o(234243);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        AppMethodBeat.i(234244);
        int length = this.Qgl.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (anX(i2) != null) {
                anX(i2).close();
            }
        }
        super.close();
        AppMethodBeat.o(234244);
    }

    public final void registerContentObserver(ContentObserver contentObserver) {
        AppMethodBeat.i(234245);
        int length = this.Qgl.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (anX(i2) != null) {
                anX(i2).registerContentObserver(contentObserver);
            }
        }
        AppMethodBeat.o(234245);
    }

    public final void unregisterContentObserver(ContentObserver contentObserver) {
        AppMethodBeat.i(234246);
        int length = this.Qgl.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (anX(i2) != null) {
                anX(i2).unregisterContentObserver(contentObserver);
            }
        }
        AppMethodBeat.o(234246);
    }

    public final void registerDataSetObserver(DataSetObserver dataSetObserver) {
        AppMethodBeat.i(234247);
        int length = this.Qgl.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (anX(i2) != null) {
                anX(i2).registerDataSetObserver(dataSetObserver);
            }
        }
        AppMethodBeat.o(234247);
    }

    public final void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        AppMethodBeat.i(234248);
        int length = this.Qgl.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (anX(i2) != null) {
                anX(i2).unregisterDataSetObserver(dataSetObserver);
            }
        }
        AppMethodBeat.o(234248);
    }

    public final boolean requery() {
        AppMethodBeat.i(234249);
        int length = this.Qgl.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (anX(i2) != null && !anX(i2).requery()) {
                AppMethodBeat.o(234249);
                return false;
            }
        }
        AppMethodBeat.o(234249);
        return true;
    }

    private Cursor anX(int i2) {
        AppMethodBeat.i(234250);
        Cursor gVZ = this.Qgl[i2].gVZ();
        AppMethodBeat.o(234250);
        return gVZ;
    }

    /* access modifiers changed from: package-private */
    public final Cursor gWc() {
        AppMethodBeat.i(234251);
        if (this.To == null || this.To.isClosed()) {
            onMove(-1, this.rIF);
        }
        Cursor cursor = this.To;
        AppMethodBeat.o(234251);
        return cursor;
    }

    private boolean anV(int i2) {
        int i3;
        boolean z;
        AppMethodBeat.i(234230);
        int i4 = this.Qgo;
        int size = this.Qgo + this.Qgp.size();
        if (i4 > i2 || i2 >= size) {
            this.Qgq.Qgw++;
            a aVar = this.Qgl[0];
            a aVar2 = this.Qgl[1];
            if (i2 <= 0) {
                i3 = this.Qgn;
            } else {
                i3 = (((this.Qgn - 1) + i2) / this.Qgn) * this.Qgn;
            }
            int min = Math.min(i3 * 2, getCount());
            if (min < i3 * 2) {
                i3 = min;
            }
            int i5 = 0;
            int i6 = 0;
            d anY = aVar.anY(0);
            d anY2 = aVar2.anY(0);
            LinkedList<c> linkedList = new LinkedList<>();
            for (int i7 = 0; i7 < i3 && (d.QgB != anY || d.QgB != anY2); i7++) {
                if (d.QgB == anY) {
                    linkedList.add(new c(1, i6, anY2));
                    i6++;
                    anY2 = aVar2.anY(i6);
                } else if (d.QgB == anY2) {
                    linkedList.add(new c(0, i5, anY));
                    i5++;
                    anY = aVar.anY(i5);
                } else {
                    this.Qgq.Qgx++;
                    if (this.Qgm * anY.a(anY2) <= 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        linkedList.add(new c(0, i5, anY));
                        i5++;
                        anY = aVar.anY(i5);
                    } else {
                        linkedList.add(new c(1, i6, anY2));
                        i6++;
                        anY2 = aVar2.anY(i6);
                    }
                }
            }
            if (linkedList.size() != i3) {
                Log.w("MergeSortCursorWrapper", "fillWindow K=%d, N=%d (%d), iterator=[%d, %d]", 0, Integer.valueOf(linkedList.size()), Integer.valueOf(i3), Integer.valueOf(i5), Integer.valueOf(i6));
            }
            this.Qgo = 0;
            this.Qgp = linkedList;
        } else {
            b.a(this.Qgq);
        }
        c anW = anW(i2);
        if (anW == null) {
            AppMethodBeat.o(234230);
            return false;
        }
        try {
            this.To = this.Qgl[anW.Qgy].gVZ();
            boolean moveToPosition = this.To.moveToPosition(anW.Qgz);
            AppMethodBeat.o(234230);
            return moveToPosition;
        } catch (Throwable th) {
            Log.w("MergeSortCursorWrapper", "onMoveTwoCursorMixed fail:" + th.getMessage());
            AppMethodBeat.o(234230);
            return false;
        }
    }
}
