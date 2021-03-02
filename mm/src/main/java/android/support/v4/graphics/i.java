package android.support.v4.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.support.v4.c.b;
import android.support.v4.content.a.c;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* access modifiers changed from: package-private */
public class i {

    /* access modifiers changed from: package-private */
    public interface a<T> {
        boolean t(T t);

        int u(T t);
    }

    i() {
    }

    private static <T> T a(T[] tArr, int i2, a<T> aVar) {
        int i3 = (i2 & 1) == 0 ? 400 : 700;
        boolean z = (i2 & 2) != 0;
        T t = null;
        int i4 = Integer.MAX_VALUE;
        for (T t2 : tArr) {
            int abs = Math.abs(aVar.u(t2) - i3) * 2;
            int i5 = (aVar.t(t2) == z ? 0 : 1) + abs;
            if (t == null || i4 > i5) {
                i4 = i5;
                t = t2;
            }
        }
        return t;
    }

    /* access modifiers changed from: protected */
    public final b.C0019b a(b.C0019b[] bVarArr, int i2) {
        return (b.C0019b) a(bVarArr, i2, new a<b.C0019b>() {
            /* class android.support.v4.graphics.i.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // android.support.v4.graphics.i.a
            public final /* bridge */ /* synthetic */ boolean t(b.C0019b bVar) {
                return bVar.JG;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // android.support.v4.graphics.i.a
            public final /* bridge */ /* synthetic */ int u(b.C0019b bVar) {
                return bVar.JF;
            }
        });
    }

    protected static Typeface a(Context context, InputStream inputStream) {
        File X = j.X(context);
        if (X == null) {
            return null;
        }
        try {
            if (!j.a(X, inputStream)) {
                return null;
            }
            Typeface createFromFile = Typeface.createFromFile(X.getPath());
            X.delete();
            return createFromFile;
        } catch (RuntimeException e2) {
            return null;
        } finally {
            X.delete();
        }
    }

    public Typeface a(Context context, b.C0019b[] bVarArr, int i2) {
        InputStream inputStream;
        Throwable th;
        InputStream inputStream2;
        Typeface typeface = null;
        if (bVarArr.length > 0) {
            try {
                inputStream2 = context.getContentResolver().openInputStream(a(bVarArr, i2).mUri);
                try {
                    typeface = a(context, inputStream2);
                    j.closeQuietly(inputStream2);
                } catch (IOException e2) {
                    j.closeQuietly(inputStream2);
                    return typeface;
                } catch (Throwable th2) {
                    th = th2;
                    inputStream = inputStream2;
                    j.closeQuietly(inputStream);
                    throw th;
                }
            } catch (IOException e3) {
                inputStream2 = null;
                j.closeQuietly(inputStream2);
                return typeface;
            } catch (Throwable th3) {
                th = th3;
                inputStream = null;
                j.closeQuietly(inputStream);
                throw th;
            }
        }
        return typeface;
    }

    public Typeface a(Context context, Resources resources, int i2, String str, int i3) {
        File X = j.X(context);
        if (X == null) {
            return null;
        }
        try {
            if (!j.a(X, resources, i2)) {
                return null;
            }
            Typeface createFromFile = Typeface.createFromFile(X.getPath());
            X.delete();
            return createFromFile;
        } catch (RuntimeException e2) {
            return null;
        } finally {
            X.delete();
        }
    }

    public Typeface a(Context context, c.b bVar, Resources resources, int i2) {
        c.C0021c cVar = (c.C0021c) a(bVar.JE, i2, new a<c.C0021c>() {
            /* class android.support.v4.graphics.i.AnonymousClass2 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // android.support.v4.graphics.i.a
            public final /* bridge */ /* synthetic */ boolean t(c.C0021c cVar) {
                return cVar.JG;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // android.support.v4.graphics.i.a
            public final /* bridge */ /* synthetic */ int u(c.C0021c cVar) {
                return cVar.JF;
            }
        });
        if (cVar == null) {
            return null;
        }
        return d.a(context, resources, cVar.JJ, cVar.mFileName, i2);
    }
}
