package androidx.versionedparcelable;

import android.os.Parcelable;
import java.lang.reflect.InvocationTargetException;

public abstract class a {
    /* access modifiers changed from: protected */
    public abstract void a(Parcelable parcelable);

    /* access modifiers changed from: protected */
    public abstract boolean dc(int i2);

    /* access modifiers changed from: protected */
    public abstract void dd(int i2);

    /* access modifiers changed from: protected */
    public abstract void nw();

    /* access modifiers changed from: protected */
    public abstract a nx();

    /* access modifiers changed from: protected */
    public abstract byte[] ny();

    /* access modifiers changed from: protected */
    public abstract <T extends Parcelable> T nz();

    /* access modifiers changed from: protected */
    public abstract int readInt();

    /* access modifiers changed from: protected */
    public abstract String readString();

    /* access modifiers changed from: protected */
    public abstract void writeByteArray(byte[] bArr);

    /* access modifiers changed from: protected */
    public abstract void writeInt(int i2);

    /* access modifiers changed from: protected */
    public abstract void writeString(String str);

    public final void i(byte[] bArr) {
        dd(2);
        writeByteArray(bArr);
    }

    public final void aM(int i2, int i3) {
        dd(i3);
        writeInt(i2);
    }

    public final void M(String str) {
        dd(7);
        writeString(str);
    }

    public final void writeParcelable(Parcelable parcelable, int i2) {
        dd(i2);
        a(parcelable);
    }

    public final int aN(int i2, int i3) {
        return !dc(i3) ? i2 : readInt();
    }

    public final String N(String str) {
        return !dc(7) ? str : readString();
    }

    public final byte[] j(byte[] bArr) {
        return !dc(2) ? bArr : ny();
    }

    public final <T extends Parcelable> T a(T t, int i2) {
        return !dc(i2) ? t : (T) nz();
    }

    public final void a(c cVar) {
        dd(1);
        b(cVar);
    }

    /* access modifiers changed from: protected */
    public final void b(c cVar) {
        if (cVar == null) {
            writeString(null);
            return;
        }
        c(cVar);
        a nx = nx();
        a(cVar, nx);
        nx.nw();
    }

    private void c(c cVar) {
        try {
            writeString(j((Class<? extends c>) cVar.getClass()).getName());
        } catch (ClassNotFoundException e2) {
            throw new RuntimeException(cVar.getClass().getSimpleName() + " does not have a Parcelizer", e2);
        }
    }

    public final <T extends c> T d(T t) {
        return !dc(1) ? t : (T) nA();
    }

    /* access modifiers changed from: protected */
    public final <T extends c> T nA() {
        String readString = readString();
        if (readString == null) {
            return null;
        }
        return (T) a(readString, nx());
    }

    private static <T extends c> T a(String str, a aVar) {
        try {
            return (T) ((c) Class.forName(str, true, a.class.getClassLoader()).getDeclaredMethod("read", a.class).invoke(null, aVar));
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e2);
        } catch (InvocationTargetException e3) {
            if (e3.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e3.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e3);
        } catch (NoSuchMethodException e4) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e4);
        } catch (ClassNotFoundException e5) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e5);
        }
    }

    private static Class j(Class<? extends c> cls) {
        return Class.forName(String.format("%s.%sParcelizer", cls.getPackage().getName(), cls.getSimpleName()), false, cls.getClassLoader());
    }

    private static <T extends c> void a(T t, a aVar) {
        try {
            j((Class<? extends c>) t.getClass()).getDeclaredMethod("write", t.getClass(), a.class).invoke(null, t, aVar);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e2);
        } catch (InvocationTargetException e3) {
            if (e3.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e3.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e3);
        } catch (NoSuchMethodException e4) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e4);
        } catch (ClassNotFoundException e5) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e5);
        }
    }
}
