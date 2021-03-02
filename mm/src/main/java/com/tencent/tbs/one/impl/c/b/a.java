package com.tencent.tbs.one.impl.c.b;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tbs.one.impl.a.f;
import java.lang.reflect.Constructor;
import java.util.HashMap;

public final class a extends LayoutInflater {

    /* renamed from: b  reason: collision with root package name */
    private static final StackTraceElement[] f2531b = new StackTraceElement[0];

    /* renamed from: d  reason: collision with root package name */
    private static final Class<?>[] f2532d = {Context.class, AttributeSet.class};

    /* renamed from: a  reason: collision with root package name */
    public ClassLoader f2533a;

    /* renamed from: c  reason: collision with root package name */
    private final Object[] f2534c;

    /* renamed from: e  reason: collision with root package name */
    private final HashMap<String, Constructor<? extends View>> f2535e;

    /* renamed from: f  reason: collision with root package name */
    private HashMap<String, Boolean> f2536f;

    protected a(Context context) {
        super(context);
        AppMethodBeat.i(173848);
        this.f2534c = new Object[2];
        this.f2535e = new HashMap<>();
        a();
        AppMethodBeat.o(173848);
    }

    private a(LayoutInflater layoutInflater, Context context) {
        super(layoutInflater, context);
        AppMethodBeat.i(173849);
        this.f2534c = new Object[2];
        this.f2535e = new HashMap<>();
        a();
        AppMethodBeat.o(173849);
    }

    private Class<? extends View> a(String str) {
        AppMethodBeat.i(173853);
        if (this.f2533a != null) {
            try {
                Class<? extends U> asSubclass = this.f2533a.loadClass(str).asSubclass(View.class);
                AppMethodBeat.o(173853);
                return asSubclass;
            } catch (ClassNotFoundException e2) {
            }
        }
        Class<? extends U> asSubclass2 = getClass().getClassLoader().loadClass(str).asSubclass(View.class);
        AppMethodBeat.o(173853);
        return asSubclass2;
    }

    private void a() {
        AppMethodBeat.i(173850);
        if (Build.VERSION.SDK_INT >= 11) {
            try {
                setFactory2(new LayoutInflater.Factory2() {
                    /* class com.tencent.tbs.one.impl.c.b.a.AnonymousClass1 */

                    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
                        AppMethodBeat.i(173869);
                        View a2 = a.this.a(str, attributeSet);
                        AppMethodBeat.o(173869);
                        return a2;
                    }

                    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
                        return null;
                    }
                });
                AppMethodBeat.o(173850);
                return;
            } catch (Exception e2) {
            }
        }
        setFactory(new LayoutInflater.Factory() {
            /* class com.tencent.tbs.one.impl.c.b.a.AnonymousClass2 */

            public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
                AppMethodBeat.i(173870);
                View a2 = a.this.a(str, attributeSet);
                AppMethodBeat.o(173870);
                return a2;
            }
        });
        AppMethodBeat.o(173850);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x009f, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00a0, code lost:
        r2 = new android.view.InflateException(r11.getPositionDescription() + ": Error inflating class " + r10, r1);
        r2.setStackTrace(com.tencent.tbs.one.impl.c.b.a.f2531b);
        com.tencent.matrix.trace.core.AppMethodBeat.o(173855);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00cc, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00d4, code lost:
        r1 = new android.view.InflateException(r11.getPositionDescription() + ": Class is not a View " + r10);
        r1.setStackTrace(com.tencent.tbs.one.impl.c.b.a.f2531b);
        com.tencent.matrix.trace.core.AppMethodBeat.o(173855);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0100, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0101, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0102, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(173855);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0108, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x010a, code lost:
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0123, code lost:
        r1 = "<unknown>";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x013d, code lost:
        r1 = r1.getName();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0148, code lost:
        r1 = r3;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x008a A[Catch:{ NoSuchMethodException -> 0x009f, ClassCastException -> 0x00d3, ClassNotFoundException -> 0x0101, Exception -> 0x0144 }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x009f A[ExcHandler: NoSuchMethodException (r1v18 'e' java.lang.NoSuchMethodException A[CUSTOM_DECLARE]), Splitter:B:5:0x001d] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00d3 A[ExcHandler: ClassCastException (e java.lang.ClassCastException), Splitter:B:5:0x001d] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0101 A[ExcHandler: ClassNotFoundException (r1v15 'e' java.lang.ClassNotFoundException A[CUSTOM_DECLARE]), Splitter:B:5:0x001d] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0123  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x013d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.view.View b(java.lang.String r10, android.util.AttributeSet r11) {
        /*
        // Method dump skipped, instructions count: 330
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tbs.one.impl.c.b.a.b(java.lang.String, android.util.AttributeSet):android.view.View");
    }

    private static void c(String str, AttributeSet attributeSet) {
        AppMethodBeat.i(173856);
        InflateException inflateException = new InflateException(attributeSet.getPositionDescription() + ": Class not allowed to be inflated " + str);
        AppMethodBeat.o(173856);
        throw inflateException;
    }

    public final View a(String str, AttributeSet attributeSet) {
        AppMethodBeat.i(173854);
        View view = null;
        if (-1 != str.indexOf(46)) {
            try {
                view = b(str, attributeSet);
            } catch (Throwable th) {
                f.b("Failed to create view %s", str, th);
            }
        }
        if (view == null) {
            try {
                view = -1 == str.indexOf(46) ? onCreateView(str, attributeSet) : createView(str, null, attributeSet);
            } catch (Throwable th2) {
                f.b("Failed to create view %s", str, th2);
            }
        }
        AppMethodBeat.o(173854);
        return view;
    }

    public final LayoutInflater cloneInContext(Context context) {
        AppMethodBeat.i(173851);
        a aVar = new a(this, context);
        AppMethodBeat.o(173851);
        return aVar;
    }

    public final void setFilter(LayoutInflater.Filter filter) {
        AppMethodBeat.i(173852);
        super.setFilter(filter);
        if (filter != null) {
            this.f2536f = new HashMap<>();
        }
        AppMethodBeat.o(173852);
    }
}
