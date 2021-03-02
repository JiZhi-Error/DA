package com.google.android.gms.common.data;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

@SafeParcelable.Class(creator = "BitmapTeleporterCreator")
public class BitmapTeleporter extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<BitmapTeleporter> CREATOR = new BitmapTeleporterCreator();
    @SafeParcelable.Field(id = 3)
    private final int zzac;
    @SafeParcelable.VersionField(id = 1)
    private final int zzal;
    @SafeParcelable.Field(id = 2)
    private ParcelFileDescriptor zznb;
    private Bitmap zznc;
    private boolean zznd;
    private File zzne;

    static {
        AppMethodBeat.i(11508);
        AppMethodBeat.o(11508);
    }

    @SafeParcelable.Constructor
    BitmapTeleporter(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) ParcelFileDescriptor parcelFileDescriptor, @SafeParcelable.Param(id = 3) int i3) {
        this.zzal = i2;
        this.zznb = parcelFileDescriptor;
        this.zzac = i3;
        this.zznc = null;
        this.zznd = false;
    }

    public BitmapTeleporter(Bitmap bitmap) {
        this.zzal = 1;
        this.zznb = null;
        this.zzac = 0;
        this.zznc = bitmap;
        this.zznd = true;
    }

    private static void zza(Closeable closeable) {
        AppMethodBeat.i(11507);
        try {
            closeable.close();
            AppMethodBeat.o(11507);
        } catch (IOException e2) {
            AppMethodBeat.o(11507);
        }
    }

    private final FileOutputStream zzcj() {
        AppMethodBeat.i(11506);
        if (this.zzne == null) {
            IllegalStateException illegalStateException = new IllegalStateException("setTempDir() must be called before writing this object to a parcel");
            AppMethodBeat.o(11506);
            throw illegalStateException;
        }
        try {
            File createTempFile = File.createTempFile("teleporter", ".tmp", this.zzne);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
                this.zznb = ParcelFileDescriptor.open(createTempFile, 268435456);
                createTempFile.delete();
                AppMethodBeat.o(11506);
                return fileOutputStream;
            } catch (FileNotFoundException e2) {
                IllegalStateException illegalStateException2 = new IllegalStateException("Temporary file is somehow already deleted");
                AppMethodBeat.o(11506);
                throw illegalStateException2;
            }
        } catch (IOException e3) {
            IllegalStateException illegalStateException3 = new IllegalStateException("Could not create temporary file", e3);
            AppMethodBeat.o(11506);
            throw illegalStateException3;
        }
    }

    public Bitmap get() {
        AppMethodBeat.i(11502);
        if (!this.zznd) {
            DataInputStream dataInputStream = new DataInputStream(new ParcelFileDescriptor.AutoCloseInputStream(this.zznb));
            try {
                byte[] bArr = new byte[dataInputStream.readInt()];
                int readInt = dataInputStream.readInt();
                int readInt2 = dataInputStream.readInt();
                Bitmap.Config valueOf = Bitmap.Config.valueOf(dataInputStream.readUTF());
                dataInputStream.read(bArr);
                zza(dataInputStream);
                ByteBuffer wrap = ByteBuffer.wrap(bArr);
                Bitmap createBitmap = Bitmap.createBitmap(readInt, readInt2, valueOf);
                createBitmap.copyPixelsFromBuffer(wrap);
                this.zznc = createBitmap;
                this.zznd = true;
            } catch (IOException e2) {
                IllegalStateException illegalStateException = new IllegalStateException("Could not read from parcel file descriptor", e2);
                AppMethodBeat.o(11502);
                throw illegalStateException;
            } catch (Throwable th) {
                zza(dataInputStream);
                AppMethodBeat.o(11502);
                throw th;
            }
        }
        Bitmap bitmap = this.zznc;
        AppMethodBeat.o(11502);
        return bitmap;
    }

    public void release() {
        AppMethodBeat.i(11504);
        if (!this.zznd) {
            try {
                this.zznb.close();
                AppMethodBeat.o(11504);
                return;
            } catch (IOException e2) {
            }
        }
        AppMethodBeat.o(11504);
    }

    public void setTempDir(File file) {
        AppMethodBeat.i(11505);
        if (file == null) {
            NullPointerException nullPointerException = new NullPointerException("Cannot set null temp directory");
            AppMethodBeat.o(11505);
            throw nullPointerException;
        }
        this.zzne = file;
        AppMethodBeat.o(11505);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(11503);
        if (this.zznb == null) {
            Bitmap bitmap = this.zznc;
            ByteBuffer allocate = ByteBuffer.allocate(bitmap.getRowBytes() * bitmap.getHeight());
            bitmap.copyPixelsToBuffer(allocate);
            byte[] array = allocate.array();
            DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(zzcj()));
            try {
                dataOutputStream.writeInt(array.length);
                dataOutputStream.writeInt(bitmap.getWidth());
                dataOutputStream.writeInt(bitmap.getHeight());
                dataOutputStream.writeUTF(bitmap.getConfig().toString());
                dataOutputStream.write(array);
                zza(dataOutputStream);
            } catch (IOException e2) {
                IllegalStateException illegalStateException = new IllegalStateException("Could not write into unlinked file", e2);
                AppMethodBeat.o(11503);
                throw illegalStateException;
            } catch (Throwable th) {
                zza(dataOutputStream);
                AppMethodBeat.o(11503);
                throw th;
            }
        }
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzal);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zznb, i2 | 1, false);
        SafeParcelWriter.writeInt(parcel, 3, this.zzac);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        this.zznb = null;
        AppMethodBeat.o(11503);
    }
}
