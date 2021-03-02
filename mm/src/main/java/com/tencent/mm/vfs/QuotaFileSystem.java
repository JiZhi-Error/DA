package com.tencent.mm.vfs;

import android.os.Handler;
import android.os.Message;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.FileSystem;
import com.tencent.stubs.logger.Log;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.ByteChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuotaFileSystem extends AbstractFileSystem {
    public static final Parcelable.Creator<QuotaFileSystem> CREATOR = new Parcelable.Creator<QuotaFileSystem>() {
        /* class com.tencent.mm.vfs.QuotaFileSystem.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ QuotaFileSystem[] newArray(int i2) {
            return new QuotaFileSystem[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ QuotaFileSystem createFromParcel(Parcel parcel) {
            AppMethodBeat.i(187711);
            QuotaFileSystem quotaFileSystem = new QuotaFileSystem(parcel);
            AppMethodBeat.o(187711);
            return quotaFileSystem;
        }
    };
    protected final boolean RaW;
    protected final FileSystem Rbo;
    protected final long Rby;
    protected final long RcT;
    protected final long nfE;

    static /* synthetic */ int Od(long j2) {
        if (j2 == 0) {
            return 0;
        }
        return j2 > 0 ? 1 : -1;
    }

    public QuotaFileSystem(FileSystem fileSystem, long j2, long j3, long j4) {
        AppMethodBeat.i(170157);
        this.Rbo = fileSystem;
        this.Rby = j2;
        this.RcT = j3;
        this.nfE = j4;
        this.RaW = true;
        hei();
        AppMethodBeat.o(170157);
    }

    protected QuotaFileSystem(Parcel parcel) {
        AppMethodBeat.i(13189);
        aa.a(parcel, QuotaFileSystem.class, 2);
        this.Rbo = (FileSystem) parcel.readParcelable(getClass().getClassLoader());
        if (this.Rbo == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Wrong wrapped filesystem.");
            AppMethodBeat.o(13189);
            throw illegalArgumentException;
        }
        this.Rby = parcel.readLong();
        this.RcT = parcel.readLong();
        this.nfE = parcel.readLong();
        this.RaW = parcel.readByte() != 0;
        hei();
        AppMethodBeat.o(13189);
    }

    private void hei() {
        AppMethodBeat.i(13190);
        if (this.RcT < this.Rby) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Cleaning threshold must not less than target size.");
            AppMethodBeat.o(13190);
            throw illegalArgumentException;
        }
        AppMethodBeat.o(13190);
    }

    public String toString() {
        AppMethodBeat.i(13200);
        String str = "QuotaFS [" + ((this.Rby / 1024) / 1024) + "MB | " + this.Rbo.toString() + "]";
        AppMethodBeat.o(13200);
        return str;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(13201);
        aa.b(parcel, QuotaFileSystem.class, 2);
        parcel.writeParcelable(this.Rbo, i2);
        parcel.writeLong(this.Rby);
        parcel.writeLong(this.RcT);
        parcel.writeLong(this.nfE);
        parcel.writeByte((byte) (this.RaW ? 1 : 0));
        AppMethodBeat.o(13201);
    }

    static {
        AppMethodBeat.i(13202);
        AppMethodBeat.o(13202);
    }

    @Override // com.tencent.mm.vfs.FileSystem
    public final FileSystem.b cj(Map<String, String> map) {
        AppMethodBeat.i(187724);
        b bVar = new b(this.Rbo.cj(map));
        AppMethodBeat.o(187724);
        return bVar;
    }

    protected class b extends c implements Handler.Callback {
        private final Object RaY = new Object();
        private HashMap<String, Long> RaZ;
        protected final List<FileSystem.b> RbF;
        private final Handler Rba;
        protected final FileSystem.b Rbp;

        b(FileSystem.b bVar) {
            AppMethodBeat.i(187714);
            this.Rbp = bVar;
            this.RbF = Collections.singletonList(bVar);
            if (QuotaFileSystem.this.RaW) {
                this.RaZ = new HashMap<>();
                this.Rba = new Handler(g.hYQ().Vmp.getLooper(), this);
                AppMethodBeat.o(187714);
                return;
            }
            this.RaZ = null;
            this.Rba = null;
            AppMethodBeat.o(187714);
        }

        @Override // com.tencent.mm.vfs.FileSystem.b
        public final FileSystem hdQ() {
            return QuotaFileSystem.this;
        }

        @Override // com.tencent.mm.vfs.c
        public final FileSystem.b ho(String str, int i2) {
            return this.Rbp;
        }

        @Override // com.tencent.mm.vfs.c
        public final List<FileSystem.b> hdS() {
            return this.RbF;
        }

        private void dA(String str, boolean z) {
            boolean isEmpty;
            AppMethodBeat.i(187715);
            if (!QuotaFileSystem.this.RaW) {
                AppMethodBeat.o(187715);
            } else if (z) {
                synchronized (this.RaY) {
                    try {
                        this.RaZ.remove(str);
                    } finally {
                        AppMethodBeat.o(187715);
                    }
                }
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                synchronized (this.RaY) {
                    try {
                        isEmpty = this.RaZ.isEmpty();
                        this.RaZ.put(str, Long.valueOf(currentTimeMillis));
                    } finally {
                        AppMethodBeat.o(187715);
                    }
                }
                if (isEmpty) {
                    this.Rba.sendMessageDelayed(Message.obtain(), Util.MILLSECONDS_OF_MINUTE);
                }
            }
        }

        @Override // com.tencent.mm.vfs.FileSystem.b, com.tencent.mm.vfs.c
        public final InputStream openRead(String str) {
            AppMethodBeat.i(187716);
            InputStream openRead = this.Rbp.openRead(str);
            dA(str, false);
            AppMethodBeat.o(187716);
            return openRead;
        }

        @Override // com.tencent.mm.vfs.a, com.tencent.mm.vfs.FileSystem.b, com.tencent.mm.vfs.c
        public final ReadableByteChannel boI(String str) {
            AppMethodBeat.i(187717);
            ReadableByteChannel boI = this.Rbp.boI(str);
            dA(str, false);
            AppMethodBeat.o(187717);
            return boI;
        }

        @Override // com.tencent.mm.vfs.FileSystem.b, com.tencent.mm.vfs.c
        public final OutputStream dw(String str, boolean z) {
            AppMethodBeat.i(187718);
            OutputStream dw = this.Rbp.dw(str, z);
            dA(str, true);
            AppMethodBeat.o(187718);
            return dw;
        }

        @Override // com.tencent.mm.vfs.a, com.tencent.mm.vfs.FileSystem.b, com.tencent.mm.vfs.c
        public final WritableByteChannel dv(String str, boolean z) {
            AppMethodBeat.i(187719);
            WritableByteChannel dv = this.Rbp.dv(str, z);
            dA(str, true);
            AppMethodBeat.o(187719);
            return dv;
        }

        @Override // com.tencent.mm.vfs.a, com.tencent.mm.vfs.FileSystem.b, com.tencent.mm.vfs.c
        public final ByteChannel boJ(String str) {
            AppMethodBeat.i(187720);
            ByteChannel boJ = this.Rbp.boJ(str);
            dA(str, true);
            AppMethodBeat.o(187720);
            return boJ;
        }

        @Override // com.tencent.mm.vfs.a, com.tencent.mm.vfs.FileSystem.b, com.tencent.mm.vfs.c
        public final ParcelFileDescriptor nr(String str, String str2) {
            AppMethodBeat.i(187721);
            ParcelFileDescriptor nr = this.Rbp.nr(str, str2);
            dA(str, str2.contains("w"));
            AppMethodBeat.o(187721);
            return nr;
        }

        public final boolean handleMessage(Message message) {
            HashMap<String, Long> hashMap;
            AppMethodBeat.i(187723);
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
                    AppMethodBeat.o(187723);
                    throw th;
                }
            }
            if (hashMap != null) {
                for (Map.Entry<String, Long> entry : hashMap.entrySet()) {
                    this.Rbp.ck(entry.getKey(), entry.getValue().longValue());
                }
                Log.d("VFS.QuotaFileSystem", "Flush access time cache entries: " + hashMap.size());
            }
            AppMethodBeat.o(187723);
            return true;
        }

        /* JADX WARNING: Removed duplicated region for block: B:129:0x03f9  */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x0068  */
        @Override // com.tencent.mm.vfs.a, com.tencent.mm.vfs.FileSystem.b, com.tencent.mm.vfs.c
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(android.os.CancellationSignal r19) {
            /*
            // Method dump skipped, instructions count: 1056
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.vfs.QuotaFileSystem.b.a(android.os.CancellationSignal):void");
        }
    }

    static final class a {
        final e RcU;
        int bva = 0;

        a(e eVar) {
            this.RcU = eVar;
        }

        public final String toString() {
            AppMethodBeat.i(13187);
            String str = "children: " + this.bva + " [" + this.RcU + "]";
            AppMethodBeat.o(13187);
            return str;
        }
    }
}
