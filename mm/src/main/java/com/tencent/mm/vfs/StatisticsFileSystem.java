package com.tencent.mm.vfs;

import android.os.CancellationSignal;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.vfs.FileSystem;
import com.tencent.mm.vfs.a.f;
import com.tencent.mm.vfs.a.h;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class StatisticsFileSystem extends AbstractFileSystem {
    public static final Parcelable.Creator<StatisticsFileSystem> CREATOR = new Parcelable.Creator<StatisticsFileSystem>() {
        /* class com.tencent.mm.vfs.StatisticsFileSystem.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ StatisticsFileSystem[] newArray(int i2) {
            return new StatisticsFileSystem[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ StatisticsFileSystem createFromParcel(Parcel parcel) {
            AppMethodBeat.i(187741);
            StatisticsFileSystem statisticsFileSystem = new StatisticsFileSystem(parcel);
            AppMethodBeat.o(187741);
            return statisticsFileSystem;
        }
    };
    private static final String[] Rdx = {""};
    protected final FileSystem Rbo;
    protected final boolean Rcx;
    protected final String[] Rdy;

    static {
        AppMethodBeat.i(187754);
        AppMethodBeat.o(187754);
    }

    public StatisticsFileSystem(FileSystem fileSystem) {
        this.Rbo = fileSystem;
        this.Rdy = Rdx;
        this.Rcx = true;
    }

    public StatisticsFileSystem(FileSystem fileSystem, Collection<String> collection) {
        AppMethodBeat.i(187748);
        this.Rbo = fileSystem;
        this.Rcx = true;
        if (collection.isEmpty()) {
            this.Rdy = Rdx;
            AppMethodBeat.o(187748);
            return;
        }
        this.Rdy = new String[collection.size()];
        int i2 = 0;
        for (String str : collection) {
            this.Rdy[i2] = aa.q(str, true, true);
            i2++;
        }
        Arrays.sort(this.Rdy);
        AppMethodBeat.o(187748);
    }

    protected StatisticsFileSystem(Parcel parcel) {
        AppMethodBeat.i(187749);
        aa.a(parcel, StatisticsFileSystem.class, 1);
        this.Rbo = (FileSystem) parcel.readParcelable(getClass().getClassLoader());
        if (this.Rbo == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Wrong wrapped filesystem.");
            AppMethodBeat.o(187749);
            throw illegalArgumentException;
        }
        this.Rdy = parcel.createStringArray();
        this.Rcx = parcel.readByte() != 0;
        AppMethodBeat.o(187749);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int i3 = 1;
        AppMethodBeat.i(187750);
        aa.b(parcel, StatisticsFileSystem.class, 1);
        parcel.writeParcelable(this.Rbo, i2);
        parcel.writeStringArray(this.Rdy);
        if (!this.Rcx) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
        AppMethodBeat.o(187750);
    }

    public String toString() {
        AppMethodBeat.i(187751);
        String obj = this.Rbo.toString();
        AppMethodBeat.o(187751);
        return obj;
    }

    protected class a extends c {
        protected final List<FileSystem.b> RbF;
        protected final FileSystem.b Rbp;
        final boolean[] Rdz;

        a(FileSystem.b bVar) {
            AppMethodBeat.i(187745);
            this.Rbp = bVar;
            this.RbF = Collections.singletonList(bVar);
            this.Rdz = new boolean[StatisticsFileSystem.this.Rdy.length];
            AppMethodBeat.o(187745);
        }

        @Override // com.tencent.mm.vfs.FileSystem.b
        public final FileSystem hdQ() {
            return StatisticsFileSystem.this;
        }

        @Override // com.tencent.mm.vfs.c
        public final FileSystem.b ho(String str, int i2) {
            return this.Rbp;
        }

        @Override // com.tencent.mm.vfs.c
        public final List<FileSystem.b> hdS() {
            return this.RbF;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: com.tencent.mm.vfs.StatisticsFileSystem$a$a  reason: collision with other inner class name */
        public class C2152a implements f.a<e, e>, h.a<e> {
            final long RdB = System.currentTimeMillis();
            final int RdC;
            int RdD = 0;
            int RdE = 0;
            long RdF = 0;
            int RdG = 0;
            long RdH = 0;
            int RdI = 0;
            final String mPath;
            final int mPos;
            long mTotalSize = 0;

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.vfs.a.f.a
            public final /* synthetic */ e er(e eVar) {
                AppMethodBeat.i(187744);
                e eVar2 = eVar;
                this.mTotalSize += eVar2.RbH;
                if (eVar2.RbJ) {
                    this.RdE++;
                } else {
                    this.RdD++;
                    if (eVar2.size > this.RdH) {
                        this.RdH = eVar2.size;
                    }
                }
                if (!eVar2.RbJ) {
                    if (eVar2.RbI > 0) {
                        this.RdF += this.RdB - eVar2.RbI;
                    } else {
                        this.RdI++;
                    }
                }
                int boS = StatisticsFileSystem.boS(eVar2.NGP) - this.RdC;
                if (this.RdG < boS) {
                    this.RdG = boS;
                }
                AppMethodBeat.o(187744);
                return eVar2;
            }

            C2152a(String str, int i2) {
                AppMethodBeat.i(187742);
                this.mPath = str;
                this.mPos = i2;
                this.RdC = StatisticsFileSystem.boS(str);
                AppMethodBeat.o(187742);
            }

            @Override // com.tencent.mm.vfs.a.h.a
            public final void hen() {
                AppMethodBeat.i(187743);
                StatisticsFileSystem statisticsFileSystem = StatisticsFileSystem.this;
                Object[] objArr = new Object[14];
                objArr[0] = "relPath";
                objArr[1] = this.mPath;
                objArr[2] = "totalSize";
                objArr[3] = Long.valueOf(this.mTotalSize);
                objArr[4] = "fileCount";
                objArr[5] = Integer.valueOf(this.RdD);
                objArr[6] = "dirCount";
                objArr[7] = Integer.valueOf(this.RdE);
                objArr[8] = "averageAge";
                objArr[9] = Long.valueOf(this.RdD - this.RdI == 0 ? 0 : this.RdF / ((long) (this.RdD - this.RdI)));
                objArr[10] = "maxDepth";
                objArr[11] = Integer.valueOf(this.RdG);
                objArr[12] = "maxFileSize";
                objArr[13] = Long.valueOf(this.RdH);
                statisticsFileSystem.l(2, objArr);
                if (g.hYQ().Vmp.getLooper() == Looper.myLooper()) {
                    a.this.Rdz[this.mPos] = true;
                }
                AppMethodBeat.o(187743);
            }
        }

        @Override // com.tencent.mm.vfs.FileSystem.b, com.tencent.mm.vfs.c
        public final Iterable<e> dx(String str, boolean z) {
            AppMethodBeat.i(187746);
            Iterable<e> dx = super.dx(str, z);
            if (dx == null || !z) {
                AppMethodBeat.o(187746);
                return dx;
            }
            String q = aa.q(str, true, true);
            int binarySearch = Arrays.binarySearch(StatisticsFileSystem.this.Rdy, q);
            if (binarySearch < 0) {
                AppMethodBeat.o(187746);
                return dx;
            }
            C2152a aVar = new C2152a(q, binarySearch);
            h hVar = new h(new f(dx, aVar), aVar);
            AppMethodBeat.o(187746);
            return hVar;
        }

        @Override // com.tencent.mm.vfs.a, com.tencent.mm.vfs.FileSystem.b, com.tencent.mm.vfs.c
        public final void a(CancellationSignal cancellationSignal) {
            Iterable<e> dx;
            AppMethodBeat.i(187747);
            if (StatisticsFileSystem.this.Rcx) {
                for (int i2 = 0; i2 < StatisticsFileSystem.this.Rdy.length; i2++) {
                    if (!this.Rdz[i2] && (dx = dx(StatisticsFileSystem.this.Rdy[i2], true)) != null) {
                        Iterator<e> it = dx.iterator();
                        int i3 = 0;
                        while (it.hasNext()) {
                            it.next();
                            int i4 = i3 + 1;
                            if (i3 >= 10) {
                                cancellationSignal.throwIfCanceled();
                                i3 = 0;
                            } else {
                                i3 = i4;
                            }
                        }
                    }
                }
            }
            super.a(cancellationSignal);
            Arrays.fill(this.Rdz, false);
            AppMethodBeat.o(187747);
        }
    }

    @Override // com.tencent.mm.vfs.FileSystem
    public final /* synthetic */ FileSystem.b cj(Map map) {
        AppMethodBeat.i(187752);
        a aVar = new a(this.Rbo.cj(map));
        AppMethodBeat.o(187752);
        return aVar;
    }

    static /* synthetic */ int boS(String str) {
        int i2 = 1;
        AppMethodBeat.i(187753);
        if (str.startsWith(FilePathGenerator.ANDROID_DIR_SEP)) {
            str = str.substring(1);
        }
        if (str.endsWith(FilePathGenerator.ANDROID_DIR_SEP)) {
            str = str.substring(0, str.length() - 1);
        }
        if (str.isEmpty()) {
            AppMethodBeat.o(187753);
            return 0;
        }
        int length = str.length();
        for (int i3 = 0; i3 < length; i3++) {
            if (str.charAt(i3) == '/') {
                i2++;
            }
        }
        AppMethodBeat.o(187753);
        return i2;
    }
}
