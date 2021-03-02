package com.tencent.mm.vfs;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.FileSystem;
import com.tencent.mm.vfs.g;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;

public class RC4EncryptedFileSystem extends AbstractFileSystem {
    public static final Parcelable.Creator<RC4EncryptedFileSystem> CREATOR = new Parcelable.Creator<RC4EncryptedFileSystem>() {
        /* class com.tencent.mm.vfs.RC4EncryptedFileSystem.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ RC4EncryptedFileSystem[] newArray(int i2) {
            return new RC4EncryptedFileSystem[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RC4EncryptedFileSystem createFromParcel(Parcel parcel) {
            AppMethodBeat.i(13203);
            RC4EncryptedFileSystem rC4EncryptedFileSystem = new RC4EncryptedFileSystem(parcel, (byte) 0);
            AppMethodBeat.o(13203);
            return rC4EncryptedFileSystem;
        }
    };
    protected final FileSystem Rbo;
    protected final g.b RcY;
    private final Key RcZ;
    protected final String gIx;

    /* synthetic */ RC4EncryptedFileSystem(Parcel parcel, byte b2) {
        this(parcel);
    }

    public RC4EncryptedFileSystem(FileSystem fileSystem, String str) {
        AppMethodBeat.i(13204);
        this.RcY = g.hYR();
        if (this.RcY == null) {
            RuntimeException runtimeException = new RuntimeException("Set global generator by calling setKeyGenerator(...) before initializing FileSystem objects.");
            AppMethodBeat.o(13204);
            throw runtimeException;
        }
        this.Rbo = fileSystem;
        this.gIx = str;
        this.RcZ = this.RcY.Z(this.gIx, g.hYQ().Vmn.hej());
        AppMethodBeat.o(13204);
    }

    private RC4EncryptedFileSystem(Parcel parcel) {
        AppMethodBeat.i(13205);
        aa.a(parcel, RC4EncryptedFileSystem.class, 3);
        this.RcY = g.hYR();
        if (this.RcY == null) {
            RuntimeException runtimeException = new RuntimeException("Set global generator by calling setGlobalKeyGenerator(...) before initializing FileSystem objects.");
            AppMethodBeat.o(13205);
            throw runtimeException;
        }
        this.Rbo = (FileSystem) parcel.readParcelable(getClass().getClassLoader());
        this.gIx = parcel.readString();
        this.RcZ = this.RcY.Z(this.gIx, g.hYQ().Vmn.hej());
        AppMethodBeat.o(13205);
    }

    @Override // com.tencent.mm.vfs.FileSystem
    public final FileSystem.b cj(Map<String, String> map) {
        Key Z;
        AppMethodBeat.i(187730);
        if (this.RcZ != null) {
            Z = this.RcZ;
        } else {
            Z = this.RcY.Z(this.gIx, map);
            if (Z == null) {
                RuntimeException runtimeException = new RuntimeException("Cannot generate key.");
                AppMethodBeat.o(187730);
                throw runtimeException;
            }
        }
        a aVar = new a(this.Rbo.cj(map), Z);
        AppMethodBeat.o(187730);
        return aVar;
    }

    public String toString() {
        AppMethodBeat.i(13212);
        String str = "RC4 [" + this.Rbo.toString() + "]";
        AppMethodBeat.o(13212);
        return str;
    }

    @Override // com.tencent.mm.vfs.AbstractFileSystem
    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(13213);
        aa.b(parcel, RC4EncryptedFileSystem.class, 3);
        parcel.writeParcelable(this.Rbo, i2);
        parcel.writeString(this.gIx);
        AppMethodBeat.o(13213);
    }

    static {
        AppMethodBeat.i(13214);
        AppMethodBeat.o(13214);
    }

    protected class a extends ab {
        protected final Key Rda;

        a(FileSystem.b bVar, Key key) {
            super(bVar);
            this.Rda = key;
        }

        @Override // com.tencent.mm.vfs.ab, com.tencent.mm.vfs.FileSystem.b
        public final int hdR() {
            AppMethodBeat.i(187725);
            int hdR = this.Rbp.hdR() & -19;
            AppMethodBeat.o(187725);
            return hdR;
        }

        @Override // com.tencent.mm.vfs.ab, com.tencent.mm.vfs.FileSystem.b
        public final InputStream openRead(String str) {
            AppMethodBeat.i(187726);
            Key key = this.Rda;
            if (key == null) {
                FileNotFoundException fileNotFoundException = new FileNotFoundException("Key is not initialized.");
                AppMethodBeat.o(187726);
                throw fileNotFoundException;
            }
            try {
                Cipher instance = Cipher.getInstance("RC4");
                instance.init(2, key);
                CipherInputStream cipherInputStream = new CipherInputStream(this.Rbp.openRead(str), instance);
                AppMethodBeat.o(187726);
                return cipherInputStream;
            } catch (GeneralSecurityException e2) {
                FileNotFoundException fileNotFoundException2 = (FileNotFoundException) new FileNotFoundException("Failed to initialize cipher: " + e2.getMessage()).initCause(e2);
                AppMethodBeat.o(187726);
                throw fileNotFoundException2;
            }
        }

        @Override // com.tencent.mm.vfs.ab, com.tencent.mm.vfs.FileSystem.b
        public final OutputStream dw(String str, boolean z) {
            AppMethodBeat.i(187727);
            Key key = this.Rda;
            if (key == null) {
                FileNotFoundException fileNotFoundException = new FileNotFoundException("Key is not initialized.");
                AppMethodBeat.o(187727);
                throw fileNotFoundException;
            } else if (z) {
                FileNotFoundException fileNotFoundException2 = new FileNotFoundException("Appending encrypted files is not supported.");
                AppMethodBeat.o(187727);
                throw fileNotFoundException2;
            } else {
                try {
                    Cipher instance = Cipher.getInstance("RC4");
                    instance.init(1, key);
                    CipherOutputStream cipherOutputStream = new CipherOutputStream(this.Rbp.dw(str, false), instance);
                    AppMethodBeat.o(187727);
                    return cipherOutputStream;
                } catch (GeneralSecurityException e2) {
                    FileNotFoundException fileNotFoundException3 = (FileNotFoundException) new FileNotFoundException("Failed to initialize cipher: " + e2.getMessage()).initCause(e2);
                    AppMethodBeat.o(187727);
                    throw fileNotFoundException3;
                }
            }
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.vfs.a, com.tencent.mm.vfs.ab
        public final boolean b(String str, FileSystem.b bVar, String str2) {
            AppMethodBeat.i(187728);
            if (bVar instanceof a) {
                a aVar = (a) bVar;
                if (RC4EncryptedFileSystem.this.RcY == RC4EncryptedFileSystem.this.RcY && RC4EncryptedFileSystem.this.gIx.equals(RC4EncryptedFileSystem.this.gIx) && aVar.Rda.equals(this.Rda) && (this.Rbp instanceof a)) {
                    boolean b2 = ((a) this.Rbp).b(str, ((a) bVar).Rbp, str2);
                    AppMethodBeat.o(187728);
                    return b2;
                }
            }
            boolean b3 = super.b(str, bVar, str2);
            AppMethodBeat.o(187728);
            return b3;
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.vfs.a, com.tencent.mm.vfs.ab
        public final long d(String str, FileSystem.b bVar, String str2) {
            AppMethodBeat.i(187729);
            if (bVar instanceof a) {
                a aVar = (a) bVar;
                if (RC4EncryptedFileSystem.this.RcY == RC4EncryptedFileSystem.this.RcY && RC4EncryptedFileSystem.this.gIx.equals(RC4EncryptedFileSystem.this.gIx) && aVar.Rda.equals(this.Rda) && (this.Rbp instanceof a)) {
                    long d2 = ((a) this.Rbp).d(str, ((a) bVar).Rbp, str2);
                    AppMethodBeat.o(187729);
                    return d2;
                }
            }
            long d3 = super.d(str, bVar, str2);
            AppMethodBeat.o(187729);
            return d3;
        }

        @Override // com.tencent.mm.vfs.FileSystem.b
        public final /* bridge */ /* synthetic */ FileSystem hdQ() {
            return RC4EncryptedFileSystem.this;
        }
    }
}
