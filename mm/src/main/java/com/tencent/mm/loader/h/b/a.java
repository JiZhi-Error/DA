package com.tencent.mm.loader.h.b;

import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.s;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.InputStream;

public final class a implements Closeable {
    byte[] icl = null;
    d icm;
    c icn;
    Object ico;
    InputStream inputStream = null;

    public static a Hk(String str) {
        return j(str, null);
    }

    public static a j(String str, Object obj) {
        return a(new C0406a(str), obj);
    }

    public static a Hl(String str) {
        return a(MMApplicationContext.getContext().getAssets().open(str), MMApplicationContext.getContext().getAssets().open(str));
    }

    private static <T extends d & c> a a(T t, Object obj) {
        return new a(t, t, obj);
    }

    private a(d dVar, c cVar, Object obj) {
        this.icm = dVar;
        this.icn = cVar;
        this.ico = obj;
    }

    public final InputStream aKu() {
        if (this.inputStream != null) {
            return this.inputStream;
        }
        if (this.icm == null) {
            return null;
        }
        this.inputStream = this.icm.aKu();
        return this.inputStream;
    }

    public final Object getTag() {
        return this.ico;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.icm != null) {
            this.icm.close();
            this.icm = null;
        }
        if (this.icn != null) {
            this.icn.close();
        }
    }

    /* access modifiers changed from: package-private */
    public static class e implements d {
        InputStream icq;

        public e(InputStream inputStream) {
            this.icq = inputStream;
        }

        @Override // com.tencent.mm.loader.h.b.d
        public final InputStream aKu() {
            return this.icq;
        }

        @Override // com.tencent.mm.loader.h.b.b
        public final void close() {
            a.t(this.icq);
        }
    }

    /* access modifiers changed from: package-private */
    public static class c implements c {
        InputStream icq;

        public c(InputStream inputStream) {
            this.icq = inputStream;
        }

        @Override // com.tencent.mm.loader.h.b.b
        public final void close() {
            a.t(this.icq);
        }
    }

    static class d implements d {
        InputStream aFm = null;
        byte[] icp;

        public d(byte[] bArr) {
            this.icp = bArr;
        }

        @Override // com.tencent.mm.loader.h.b.d
        public final InputStream aKu() {
            if (this.aFm == null) {
                this.aFm = new ByteArrayInputStream(this.icp);
            }
            return this.aFm;
        }

        @Override // com.tencent.mm.loader.h.b.b
        public final void close() {
            a.t(this.aFm);
        }
    }

    static class b implements c {
        byte[] icp;

        public b(byte[] bArr) {
            this.icp = bArr;
        }

        @Override // com.tencent.mm.loader.h.b.b
        public final void close() {
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.loader.h.b.a$a  reason: collision with other inner class name */
    public static class C0406a implements c, d {
        InputStream aFm = null;
        String mFilePath;

        public C0406a(String str) {
            this.mFilePath = str;
        }

        @Override // com.tencent.mm.loader.h.b.d
        public final InputStream aKu() {
            try {
                this.aFm = s.openRead(this.mFilePath);
                return this.aFm;
            } catch (FileNotFoundException e2) {
                return null;
            }
        }

        @Override // com.tencent.mm.loader.h.b.b
        public final void close() {
            a.t(this.aFm);
        }
    }

    public static a a(InputStream inputStream2, InputStream inputStream3) {
        return new a(new e(inputStream2), new c(inputStream3), null);
    }

    public static a ae(byte[] bArr) {
        return new a(new d(bArr), new b(bArr), null);
    }

    static /* synthetic */ void t(InputStream inputStream2) {
        if (inputStream2 != null) {
            try {
                inputStream2.close();
            } catch (Exception e2) {
            }
        }
    }
}
