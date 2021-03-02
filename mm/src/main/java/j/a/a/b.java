package j.a.a;

import android.content.Context;

/* access modifiers changed from: package-private */
public abstract class b {
    /* access modifiers changed from: package-private */
    public abstract int P(double d2);

    /* access modifiers changed from: package-private */
    public abstract void a(c cVar);

    /* access modifiers changed from: package-private */
    public abstract void a(String str, boolean z, Context context);

    /* access modifiers changed from: package-private */
    public abstract void a(boolean z, boolean z2, Context context);

    /* access modifiers changed from: package-private */
    public abstract String esX();

    /* access modifiers changed from: package-private */
    public abstract int getCurrentPosition();

    /* access modifiers changed from: package-private */
    public abstract int getDuration();

    /* access modifiers changed from: package-private */
    public abstract boolean hRs();

    /* access modifiers changed from: package-private */
    public abstract void mb(Context context);

    /* access modifiers changed from: package-private */
    public abstract void p(String str, Context context);

    /* access modifiers changed from: package-private */
    public abstract void pause();

    /* access modifiers changed from: package-private */
    public abstract void release();

    /* access modifiers changed from: package-private */
    public abstract void seek(int i2);

    /* access modifiers changed from: package-private */
    public abstract void stop();

    /* access modifiers changed from: package-private */
    public abstract void u(double d2);

    b() {
    }

    protected static boolean objectEquals(Object obj, Object obj2) {
        return (obj == null && obj2 == null) || (obj != null && obj.equals(obj2));
    }
}
