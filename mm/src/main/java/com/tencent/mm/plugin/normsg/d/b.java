package com.tencent.mm.plugin.normsg.d;

import android.content.Context;
import android.graphics.Region;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.FileDescriptor;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class b {
    private static final String AFA = d.aIJ("\rk\u0002l\bN!B7D");
    private static final String AFB = d.aIJ("\"D+H=N\u001dx\u0019k\b`");
    private static final String AFC = d.aIJ("m\u001dx\nl\u0003q\u001c]>]8K8Q3Z6_+R\u0013p\u0004m\u0002l");
    private static final String AFD = d.aIJ("Ì¿Ú®èïÊ©Ê¯Ü¯Æ¤Í¡È¼Åäå¬Â¤Ëüúâ");
    private static final String AFE = d.aIJ("¬ßºÎáëªÉªÏ¼Ï¦Ä­Á¨Ü¥ëàÌ¢Ä«Øïéñ");
    private static final String AFF = d.aIJ("îøÜ¹Ë­Â°Ýÿùùò÷êÒ±Å¬Ã­ÿéð");
    private static final ClassLoader AFk = b.class.getClassLoader();
    private static final String AFl = d.aIJ("\u001f~\u0010t\u0006i\u0000dJ<U0Gi\bk\bm\u001em\u0004f\u000fc\n~\u0007)`!B!D7D-O&J#W.c\u0002l\rj\u000f}Y\n~\u000bi");
    private static final String AFm = d.aIJ("\u0011p\u001ez\bg\u000ejD+Xv%@2D-N+f\u0007i\bo\nx");
    private static final String AFn = d.aIJ("\u0007t7V5]8");
    private static final String AFo = d.aIJ("\u0017v\u0005L\"V3A'F%@");
    private static final String AFp = d.aIJ("\ng$E)E'F%N");
    private static final String AFq = d.aIJ("\u000ec5\\9N\u001cs\u001ch!L<P");
    private static final String AFr = d.aIJ("Ñ°ÞºÈ§Îªòþ§Æ¥Æ£Ð£Ê¨Á­Ä°Éç®ïïùãèíà©Ç³Ö¤Å¦Ò»Ôºùøóäâ");
    private static final String AFs = d.aIJ("Ù¸Ü¸ùùïõþûö¿Ñ¥À²Ó°Ä­Â¬ïîåòô");
    private static final String AFt = d.aIJ("éëÞ½Þ»È»Ò°ÙµÜ¨ÑöçôãåÈ§É½Ï Ì Å·");
    private static final String AFu = d.aIJ("\u001ak\u001e{\tp<S0Q=t\u001an\u000by\u001f~\u001dx");
    private static final String AFv = d.aIJ("?Y0^:l\u0005`\u0017U,m\u000em\b{\ba\u0003j\u0006o\u001bb+O");
    private static final String AFw = d.aIJ("+M$J.o\fo\ny\nc\u0001h\u0004m\u0019`.A%@\tg\u0001n,U\u0014w\u0014q\u0002q\u0018z\u0013\u0016b\u001bR6");
    private static final String AFx = d.aIJ("!G.@$e\u0006e\u0000s\u0000i\u000bb\u000eg\u0013j$K/J\u0003m\u000bd&_\t`\u0005r;_");
    private static final String AFy = d.aIJ("÷ðÕ¶Õ°Ã°Ù»Ò¾×£Úûú³Ý»Ô§åÊ£Æ±ø");
    private static final String AFz = d.aIJ("±×¾Ð´õõãùò÷ú´Û¿ÚýôÅ¼èõ");
    public final Queue<g> AFG;
    private final Map<Object, IBinder> AFH;
    private final Map<IBinder, Integer> AFI;
    private final Handler AFJ;
    private IInterface AFK;
    private volatile boolean mInitialized;

    public interface g {
        void a(int i2, View view, List<AccessibilityNodeInfo> list);

        boolean a(int i2, int i3, View view);

        void onError(Throwable th);
    }

    /* synthetic */ b(byte b2) {
        this();
    }

    static /* synthetic */ boolean a(b bVar, int i2, int i3, View view) {
        AppMethodBeat.i(149079);
        boolean b2 = bVar.b(i2, i3, view);
        AppMethodBeat.o(149079);
        return b2;
    }

    static /* synthetic */ void b(b bVar, int i2, View view, List list) {
        AppMethodBeat.i(149081);
        bVar.b(i2, view, list);
        AppMethodBeat.o(149081);
    }

    static /* synthetic */ void b(b bVar, Throwable th) {
        AppMethodBeat.i(149083);
        bVar.o(th);
        AppMethodBeat.o(149083);
    }

    static /* synthetic */ boolean b(b bVar, int i2, int i3, View view) {
        AppMethodBeat.i(149082);
        boolean c2 = bVar.c(i2, i3, view);
        AppMethodBeat.o(149082);
        return c2;
    }

    static {
        AppMethodBeat.i(149084);
        AppMethodBeat.o(149084);
    }

    static final class h {
        static final b AFZ = new b((byte) 0);

        static {
            AppMethodBeat.i(149065);
            AppMethodBeat.o(149065);
        }
    }

    public static b eye() {
        return h.AFZ;
    }

    public final synchronized void initialize(Context context) {
        f fVar;
        Object obj;
        AppMethodBeat.i(149070);
        if (this.mInitialized) {
            AppMethodBeat.o(149070);
        } else if (Build.VERSION.SDK_INT < 15) {
            f fVar2 = new f("unsupported system, api: " + Build.VERSION.SDK_INT);
            AppMethodBeat.o(149070);
            throw fVar2;
        } else {
            try {
                IInterface iInterface = (IInterface) i.a(AFl, AFo, i.b(IBinder.class), (IBinder) i.a(AFm, "getService", i.b(String.class), "accessibility"));
                this.AFK = (IInterface) Proxy.newProxyInstance(AFk, iInterface.getClass().getInterfaces(), new c(iInterface));
                ((Map) i.jh(AFm, AFn)).put("accessibility", this.AFK.asBinder());
                try {
                    Object b2 = i.b((Class<?>) AccessibilityManager.class, "getInstance", i.b(Context.class), context);
                    try {
                        obj = i.d(b2, "mLock");
                    } catch (Throwable th) {
                        obj = null;
                    }
                    if (obj != null) {
                        synchronized (obj) {
                            try {
                                i.c(b2, "mService", this.AFK);
                            } catch (Throwable th2) {
                                AppMethodBeat.o(149070);
                                throw th2;
                            }
                        }
                    } else {
                        i.c(b2, "mService", this.AFK);
                    }
                    this.mInitialized = true;
                    AppMethodBeat.o(149070);
                } catch (Throwable th3) {
                    throw fVar;
                }
            } finally {
                fVar = new f(th3);
                AppMethodBeat.o(149070);
            }
        }
    }

    public final synchronized void ensureInitialized() {
        AppMethodBeat.i(149071);
        if (!this.mInitialized) {
            IllegalStateException illegalStateException = new IllegalStateException("you must call initialize first.");
            AppMethodBeat.o(149071);
            throw illegalStateException;
        }
        AppMethodBeat.o(149071);
    }

    final class c extends e {
        private InvocationHandler AFV = new InvocationHandler() {
            /* class com.tencent.mm.plugin.normsg.d.b.c.AnonymousClass1 */

            @Override // java.lang.reflect.InvocationHandler
            public final Object invoke(Object obj, Method method, Object[] objArr) {
                Object b2;
                AppMethodBeat.i(149051);
                synchronized (b.this) {
                    try {
                        if (b.AFu.equals(method.getName())) {
                            b2 = b.this.AFK;
                        } else {
                            try {
                                b2 = method.invoke(c.this.AFY.asBinder(), objArr);
                                AppMethodBeat.o(149051);
                            } catch (InvocationTargetException e2) {
                                Throwable targetException = e2.getTargetException();
                                Class<?>[] exceptionTypes = method.getExceptionTypes();
                                if (exceptionTypes != null && exceptionTypes.length > 0) {
                                    for (Class<?> cls : method.getExceptionTypes()) {
                                        if (cls.isAssignableFrom(targetException.getClass())) {
                                            AppMethodBeat.o(149051);
                                            throw targetException;
                                        }
                                    }
                                }
                                b.a(b.this, targetException);
                                b2 = b.b(method);
                                AppMethodBeat.o(149051);
                            } catch (Throwable th) {
                                b.a(b.this, th);
                                b2 = b.b(method);
                                AppMethodBeat.o(149051);
                            }
                        }
                    } finally {
                        AppMethodBeat.o(149051);
                    }
                }
                return b2;
            }
        };

        c(IInterface iInterface) {
            super(iInterface);
            AppMethodBeat.i(149052);
            AppMethodBeat.o(149052);
        }

        @Override // com.tencent.mm.plugin.normsg.d.b.e, java.lang.reflect.InvocationHandler
        public final Object invoke(Object obj, Method method, Object[] objArr) {
            Object d2;
            AppMethodBeat.i(149053);
            if (b.AFs.equals(method.getName()) && objArr != null && objArr.length >= 2) {
                Object obj2 = objArr[1];
                try {
                    if (!i.findClass(b.AFr).isAssignableFrom(obj2.getClass())) {
                        IllegalStateException illegalStateException = new IllegalStateException("mismatched conn class: " + obj2.getClass() + ", give up intercepting.");
                        AppMethodBeat.o(149053);
                        throw illegalStateException;
                    }
                    WeakReference weakReference = (WeakReference) i.d(obj2, b.AFq);
                    Object obj3 = weakReference.get();
                    if (obj3 == null) {
                        Log.e("MicroMsg.AED", "lost viewRootImpl instance, give up intercepting.");
                    } else {
                        if (Build.VERSION.SDK_INT < 16) {
                            d2 = obj3;
                        } else {
                            d2 = i.d(i.b(obj3, b.AFt, (Class<?>[]) null, new Object[0]), "mHandler");
                        }
                        Handler.Callback callback = (Handler.Callback) i.d(d2, b.AFp);
                        if (!(callback instanceof C1565b)) {
                            i.c(d2, b.AFp, new C1565b(obj3, callback));
                        }
                        synchronized (b.this.AFH) {
                            try {
                                Object obj4 = (IBinder) b.this.AFH.get(obj3);
                                if (obj4 == null) {
                                    obj4 = new a(weakReference.get(), ((IInterface) obj2).asBinder());
                                    b.this.AFH.put(obj3, obj4);
                                }
                                objArr[1] = (IInterface) i.a(b.AFr + "$Stub", "asInterface", i.b(IBinder.class), obj4);
                            } catch (Throwable th) {
                                AppMethodBeat.o(149053);
                                throw th;
                            }
                        }
                    }
                } catch (Throwable th2) {
                    Log.printErrStackTrace("MicroMsg.AED", th2, "unexpected exception.", new Object[0]);
                    b.a(b.this, th2);
                    objArr[1] = obj2;
                }
            }
            Object invoke = super.invoke(obj, method, objArr);
            AppMethodBeat.o(149053);
            return invoke;
        }

        @Override // com.tencent.mm.plugin.normsg.d.b.e
        public final IBinder asBinder() {
            AppMethodBeat.i(149054);
            IBinder iBinder = (IBinder) Proxy.newProxyInstance(b.AFk, new Class[]{IBinder.class}, this.AFV);
            AppMethodBeat.o(149054);
            return iBinder;
        }
    }

    final class a extends d {
        private i AFP = null;
        private WeakReference<Object> AFQ = null;

        a(Object obj, IBinder iBinder) {
            super(iBinder);
            AppMethodBeat.i(149045);
            try {
                this.AFQ = new WeakReference<>(obj);
                this.AFP = new i(i.findClass(b.AFr + "$Stub"));
                AppMethodBeat.o(149045);
            } catch (Throwable th) {
                b.a(b.this, th);
                AppMethodBeat.o(149045);
            }
        }

        /* access modifiers changed from: protected */
        @Override // android.os.Binder, com.tencent.mm.plugin.normsg.d.b.d
        public final boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            AppMethodBeat.i(149046);
            if (i2 <= 0 || i2 > 16777215) {
                boolean onTransact = super.onTransact(i2, parcel, parcel2, i3);
                AppMethodBeat.o(149046);
                return onTransact;
            } else if (this.AFP == null) {
                Log.e("MicroMsg.AED", "init failed, give up intercepting.");
                boolean onTransact2 = super.onTransact(i2, parcel, parcel2, i3);
                AppMethodBeat.o(149046);
                return onTransact2;
            } else if (this.AFQ.get() == null) {
                Log.e("MicroMsg.AED", "lost viewRootImpl instance, give up intercepting.");
                boolean onTransact3 = super.onTransact(i2, parcel, parcel2, i3);
                AppMethodBeat.o(149046);
                return onTransact3;
            } else {
                String str = this.AFP.eyp().get(i2);
                try {
                    parcel.enforceInterface(b.AFr);
                    if (b.AFw.equals(str)) {
                        int i4 = Build.VERSION.SDK_INT;
                        if (i4 < 16) {
                            parcel.readInt();
                        } else {
                            parcel.readLong();
                        }
                        if (i4 >= 16 && i4 < 17) {
                            parcel.readInt();
                            parcel.readInt();
                        } else if (i4 >= 21 && parcel.readInt() != 0) {
                            Region.CREATOR.createFromParcel(parcel);
                        }
                        parcel.readInt();
                        IBinder readStrongBinder = parcel.readStrongBinder();
                        if (i4 >= 16) {
                            parcel.readInt();
                        }
                        b.this.AFI.put(readStrongBinder, Integer.valueOf(parcel.readInt()));
                    } else if (b.AFx.equals(str)) {
                        int i5 = Build.VERSION.SDK_INT;
                        if (i5 < 16) {
                            parcel.readInt();
                        } else {
                            parcel.readLong();
                        }
                        if (i5 >= 16) {
                            parcel.readInt();
                            if (i5 < 17) {
                                parcel.readInt();
                                parcel.readInt();
                            }
                        }
                        parcel.readInt();
                        IBinder readStrongBinder2 = parcel.readStrongBinder();
                        if (i5 >= 16) {
                            parcel.readInt();
                        }
                        b.this.AFI.put(readStrongBinder2, Integer.valueOf(parcel.readInt()));
                    } else if (b.AFy.equals(str)) {
                        int i6 = Build.VERSION.SDK_INT;
                        parcel.readLong();
                        parcel.readString();
                        if (i6 >= 21 && parcel.readInt() != 0) {
                            Region.CREATOR.createFromParcel(parcel);
                        }
                        parcel.readInt();
                        IBinder readStrongBinder3 = parcel.readStrongBinder();
                        parcel.readInt();
                        b.this.AFI.put(readStrongBinder3, Integer.valueOf(parcel.readInt()));
                    } else if (b.AFz.equals(str)) {
                        int i7 = Build.VERSION.SDK_INT;
                        parcel.readLong();
                        parcel.readString();
                        if (i7 >= 16 && i7 < 17) {
                            parcel.readInt();
                            parcel.readInt();
                        } else if (i7 >= 21 && parcel.readInt() != 0) {
                            Region.CREATOR.createFromParcel(parcel);
                        }
                        parcel.readInt();
                        IBinder readStrongBinder4 = parcel.readStrongBinder();
                        parcel.readInt();
                        b.this.AFI.put(readStrongBinder4, Integer.valueOf(parcel.readInt()));
                    } else if (b.AFA.equals(str)) {
                        int i8 = Build.VERSION.SDK_INT;
                        parcel.readLong();
                        parcel.readInt();
                        if (i8 >= 16 && i8 < 17) {
                            parcel.readInt();
                            parcel.readInt();
                        } else if (i8 >= 21 && parcel.readInt() != 0) {
                            Region.CREATOR.createFromParcel(parcel);
                        }
                        parcel.readInt();
                        IBinder readStrongBinder5 = parcel.readStrongBinder();
                        parcel.readInt();
                        b.this.AFI.put(readStrongBinder5, Integer.valueOf(parcel.readInt()));
                    } else if (b.AFB.equals(str)) {
                        int i9 = Build.VERSION.SDK_INT;
                        parcel.readLong();
                        parcel.readInt();
                        if (i9 >= 16 && i9 < 17) {
                            parcel.readInt();
                            parcel.readInt();
                        } else if (i9 >= 21 && parcel.readInt() != 0) {
                            Region.CREATOR.createFromParcel(parcel);
                        }
                        parcel.readInt();
                        IBinder readStrongBinder6 = parcel.readStrongBinder();
                        parcel.readInt();
                        b.this.AFI.put(readStrongBinder6, Integer.valueOf(parcel.readInt()));
                    } else if (b.AFC.equals(str)) {
                        int i10 = Build.VERSION.SDK_INT;
                        if (i10 < 16) {
                            parcel.readInt();
                        } else {
                            parcel.readLong();
                        }
                        parcel.readInt();
                        if (i10 >= 16 && parcel.readInt() != 0) {
                            Bundle.CREATOR.createFromParcel(parcel);
                        }
                        parcel.readInt();
                        IBinder readStrongBinder7 = parcel.readStrongBinder();
                        if (i10 >= 16) {
                            parcel.readInt();
                        }
                        b.this.AFI.put(readStrongBinder7, Integer.valueOf(parcel.readInt()));
                    }
                } catch (Throwable th) {
                    Log.printErrStackTrace("MicroMsg.AED", th, "unexpected exception.", new Object[0]);
                    b.a(b.this, th);
                }
                boolean onTransact4 = super.onTransact(i2, parcel, parcel2, i3);
                AppMethodBeat.o(149046);
                return onTransact4;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.normsg.d.b$b  reason: collision with other inner class name */
    final class C1565b implements Handler.Callback {
        private final WeakReference<Object> AFQ;
        private final Handler.Callback AFR;

        C1565b(Object obj, Handler.Callback callback) {
            AppMethodBeat.i(149048);
            this.AFQ = new WeakReference<>(obj);
            this.AFR = callback;
            AppMethodBeat.o(149048);
        }

        public final boolean handleMessage(Message message) {
            IInterface iInterface;
            int i2;
            final View view;
            int i3;
            int intValue;
            int intValue2;
            AppMethodBeat.i(149049);
            Object obj = this.AFQ.get();
            if (obj == null) {
                Log.e("MicroMsg.AED", "lost viewRootImpl instance, give up intercepting.");
                boolean o = o(message);
                AppMethodBeat.o(149049);
                return o;
            }
            try {
                View view2 = (View) i.b(obj, "getView", (Class<?>[]) null, new Object[0]);
                if (view2 == null) {
                    Log.e("MicroMsg.AED", "cannot find root view, give up intercepting.");
                    boolean o2 = o(message);
                    AppMethodBeat.o(149049);
                    return o2;
                }
                switch (message.what) {
                    case 1:
                    case 2:
                    case 3:
                    case 5:
                    case 6:
                    case 1020:
                        iInterface = (IInterface) i.d(message.obj, "arg1");
                        break;
                    case 4:
                    case TXLiteAVCode.EVT_CAMERA_REMOVED:
                        iInterface = (IInterface) i.d(message.obj, "arg2");
                        break;
                    case 1021:
                    case 1022:
                        iInterface = (IInterface) message.obj;
                        break;
                    default:
                        iInterface = null;
                        break;
                }
                if (iInterface == null) {
                    Log.w("MicroMsg.AED", "callback is null, give up intercepting, op: %s", Integer.valueOf(message.what));
                    boolean o3 = o(message);
                    AppMethodBeat.o(149049);
                    return o3;
                } else if (!Proxy.isProxyClass(iInterface.getClass()) || !(Proxy.getInvocationHandler(iInterface) instanceof e)) {
                    switch (message.what) {
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 1020:
                        case 1021:
                        case TXLiteAVCode.EVT_CAMERA_REMOVED:
                            switch (message.what) {
                                case 1:
                                case 3:
                                case 6:
                                    i2 = message.arg2;
                                    break;
                                case 2:
                                case 4:
                                case 1020:
                                case TXLiteAVCode.EVT_CAMERA_REMOVED:
                                    i2 = ((Integer) i.d(message.obj, "argi1")).intValue();
                                    break;
                                case 5:
                                    i2 = ((Integer) i.d(message.obj, "argi2")).intValue();
                                    break;
                                case 1021:
                                    i2 = message.arg1;
                                    break;
                                default:
                                    i2 = 0;
                                    break;
                            }
                            view = (View) i.b(view2, b.AFv, i.b(Integer.TYPE), Integer.valueOf(i2));
                            break;
                        case 1022:
                            if (message.what == 1022) {
                                i3 = message.arg1;
                            } else {
                                i3 = 0;
                            }
                            view = view2.findViewById(i3);
                            break;
                        default:
                            view = null;
                            break;
                    }
                    switch (message.what) {
                        case 1:
                        case 2:
                        case 4:
                        case 6:
                        case 1020:
                            intValue = ((Integer) i.d(message.obj, "argi3")).intValue();
                            break;
                        case 3:
                        case 5:
                            intValue = ((Integer) i.d(message.obj, "argi1")).intValue();
                            break;
                        case 1021:
                        case 1022:
                            intValue = message.arg2;
                            break;
                        case TXLiteAVCode.EVT_CAMERA_REMOVED:
                            intValue = ((Integer) i.d(message.obj, "argi2")).intValue();
                            break;
                        default:
                            intValue = 0;
                            break;
                    }
                    final Integer num = (Integer) b.this.AFI.remove(iInterface.asBinder());
                    if (num == null) {
                        Log.w("MicroMsg.AED", "callback %s's binder is unmarked, give up intercept.", iInterface.getClass().getName());
                        boolean o4 = o(message);
                        AppMethodBeat.o(149049);
                        return o4;
                    }
                    switch (message.what) {
                        case 1:
                        case 1020:
                            switch (message.what) {
                                case 1:
                                case 1020:
                                    intValue2 = ((Integer) i.d(message.obj, "argi2")).intValue();
                                    break;
                                default:
                                    intValue2 = 0;
                                    break;
                            }
                            if (!b.a(b.this, intValue2, num.intValue(), view)) {
                                i.b(iInterface, b.AFF, i.b(Boolean.TYPE, Integer.TYPE), Boolean.FALSE, Integer.valueOf(intValue));
                                AppMethodBeat.o(149049);
                                return true;
                            }
                            break;
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 1021:
                        case 1022:
                        case TXLiteAVCode.EVT_CAMERA_REMOVED:
                            IInterface iInterface2 = (IInterface) Proxy.newProxyInstance(b.AFk, iInterface.getClass().getInterfaces(), new e(iInterface) {
                                /* class com.tencent.mm.plugin.normsg.d.b.C1565b.AnonymousClass1 */

                                @Override // com.tencent.mm.plugin.normsg.d.b.e, java.lang.reflect.InvocationHandler
                                public final Object invoke(Object obj, Method method, Object[] objArr) {
                                    AppMethodBeat.i(149047);
                                    String name = method.getName();
                                    if (b.AFD.equals(name)) {
                                        ArrayList arrayList = new ArrayList();
                                        if (objArr[0] != null) {
                                            arrayList.add((AccessibilityNodeInfo) objArr[0]);
                                        }
                                        b.a(b.this, num.intValue(), view, arrayList);
                                        if (arrayList.isEmpty()) {
                                            objArr[0] = null;
                                        } else {
                                            objArr[0] = arrayList.get(0);
                                        }
                                    } else if (b.AFE.equals(name)) {
                                        List list = (List) objArr[0];
                                        if (list == null) {
                                            list = new ArrayList();
                                        }
                                        b.a(b.this, num.intValue(), view, list);
                                    }
                                    Object invoke = super.invoke(obj, method, objArr);
                                    AppMethodBeat.o(149047);
                                    return invoke;
                                }
                            });
                            switch (message.what) {
                                case 1:
                                case 2:
                                case 3:
                                case 5:
                                case 6:
                                case 1020:
                                    i.c(message.obj, "arg1", iInterface2);
                                    break;
                                case 4:
                                case TXLiteAVCode.EVT_CAMERA_REMOVED:
                                    i.c(message.obj, "arg2", iInterface2);
                                    break;
                                case 1021:
                                case 1022:
                                    message.obj = iInterface2;
                                    break;
                            }
                    }
                    boolean o5 = o(message);
                    AppMethodBeat.o(149049);
                    return o5;
                } else {
                    Log.w("MicroMsg.AED", "reused callback, skip rest works.");
                    boolean o6 = o(message);
                    AppMethodBeat.o(149049);
                    return o6;
                }
            } catch (Throwable th) {
                b.a(b.this, th);
            }
        }

        private boolean o(Message message) {
            AppMethodBeat.i(149050);
            if (this.AFR != null) {
                boolean handleMessage = this.AFR.handleMessage(message);
                AppMethodBeat.o(149050);
                return handleMessage;
            }
            AppMethodBeat.o(149050);
            return false;
        }
    }

    private void b(int i2, View view, List<AccessibilityNodeInfo> list) {
        AppMethodBeat.i(149072);
        for (g gVar : this.AFG) {
            gVar.a(i2, view, list);
        }
        AppMethodBeat.o(149072);
    }

    private boolean b(final int i2, final int i3, final View view) {
        AppMethodBeat.i(149073);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            boolean c2 = c(i2, i3, view);
            AppMethodBeat.o(149073);
            return c2;
        }
        final boolean[] zArr = {true, false};
        this.AFJ.post(new Runnable() {
            /* class com.tencent.mm.plugin.normsg.d.b.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(149043);
                zArr[0] = b.b(b.this, i2, i3, view);
                synchronized (zArr) {
                    try {
                        zArr[1] = true;
                        zArr.notifyAll();
                    } finally {
                        AppMethodBeat.o(149043);
                    }
                }
            }
        });
        synchronized (zArr) {
            while (!zArr[1]) {
                try {
                    try {
                        zArr.wait();
                    } catch (InterruptedException e2) {
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(149073);
                    throw th;
                }
            }
        }
        boolean z = zArr[0];
        AppMethodBeat.o(149073);
        return z;
    }

    private boolean c(int i2, int i3, View view) {
        AppMethodBeat.i(149074);
        for (g gVar : this.AFG) {
            if (!gVar.a(i2, i3, view)) {
                AppMethodBeat.o(149074);
                return false;
            }
        }
        AppMethodBeat.o(149074);
        return true;
    }

    private void o(Throwable th) {
        AppMethodBeat.i(149075);
        for (g gVar : this.AFG) {
            gVar.onError(th);
        }
        AppMethodBeat.o(149075);
    }

    class e implements InvocationHandler {
        protected final IInterface AFY;

        e(IInterface iInterface) {
            this.AFY = iInterface;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            AppMethodBeat.i(149063);
            try {
                if ("asBinder".equals(method.getName())) {
                    IBinder asBinder = asBinder();
                    AppMethodBeat.o(149063);
                    return asBinder;
                }
                Object invoke = method.invoke(this.AFY, objArr);
                AppMethodBeat.o(149063);
                return invoke;
            } catch (InvocationTargetException e2) {
                Throwable targetException = e2.getTargetException();
                if (targetException instanceof RuntimeException) {
                    AppMethodBeat.o(149063);
                    throw targetException;
                }
                Class<?>[] exceptionTypes = method.getExceptionTypes();
                if (exceptionTypes != null && exceptionTypes.length > 0) {
                    for (Class<?> cls : method.getExceptionTypes()) {
                        if (cls.isAssignableFrom(targetException.getClass())) {
                            AppMethodBeat.o(149063);
                            throw targetException;
                        }
                    }
                }
                b.a(b.this, targetException);
                Object b2 = b.b(method);
                AppMethodBeat.o(149063);
                return b2;
            } catch (Throwable th) {
                b.a(b.this, th);
                Object b3 = b.b(method);
                AppMethodBeat.o(149063);
                return b3;
            }
        }

        public IBinder asBinder() {
            AppMethodBeat.i(149064);
            IBinder asBinder = this.AFY.asBinder();
            AppMethodBeat.o(149064);
            return asBinder;
        }
    }

    class d extends Binder {
        protected final IBinder AFX;

        d(IBinder iBinder) {
            this.AFX = iBinder;
        }

        @Override // android.os.IBinder
        public String getInterfaceDescriptor() {
            AppMethodBeat.i(149055);
            try {
                String interfaceDescriptor = this.AFX.getInterfaceDescriptor();
                AppMethodBeat.o(149055);
                return interfaceDescriptor;
            } catch (RemoteException e2) {
                AppMethodBeat.o(149055);
                return "<failure>";
            }
        }

        public boolean pingBinder() {
            AppMethodBeat.i(149056);
            boolean pingBinder = this.AFX.pingBinder();
            AppMethodBeat.o(149056);
            return pingBinder;
        }

        public boolean isBinderAlive() {
            AppMethodBeat.i(149057);
            boolean isBinderAlive = this.AFX.isBinderAlive();
            AppMethodBeat.o(149057);
            return isBinderAlive;
        }

        public IInterface queryLocalInterface(String str) {
            return null;
        }

        @Override // android.os.IBinder
        public void dump(FileDescriptor fileDescriptor, String[] strArr) {
            AppMethodBeat.i(149058);
            try {
                this.AFX.dump(fileDescriptor, strArr);
                AppMethodBeat.o(149058);
            } catch (RemoteException e2) {
                AppMethodBeat.o(149058);
            }
        }

        @Override // android.os.IBinder
        public void dumpAsync(FileDescriptor fileDescriptor, String[] strArr) {
            AppMethodBeat.i(149059);
            try {
                this.AFX.dumpAsync(fileDescriptor, strArr);
                AppMethodBeat.o(149059);
            } catch (RemoteException e2) {
                AppMethodBeat.o(149059);
            }
        }

        /* access modifiers changed from: protected */
        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            boolean z = false;
            AppMethodBeat.i(149060);
            try {
                if (this.AFX.isBinderAlive()) {
                    z = this.AFX.transact(i2, parcel, parcel2, i3);
                    AppMethodBeat.o(149060);
                } else {
                    AppMethodBeat.o(149060);
                }
            } catch (RemoteException e2) {
                AppMethodBeat.o(149060);
                throw e2;
            } catch (Throwable th) {
                b.a(b.this, th);
                AppMethodBeat.o(149060);
            }
            return z;
        }

        @Override // android.os.IBinder
        public void linkToDeath(IBinder.DeathRecipient deathRecipient, int i2) {
            AppMethodBeat.i(149061);
            try {
                this.AFX.linkToDeath(deathRecipient, i2);
                AppMethodBeat.o(149061);
            } catch (RemoteException e2) {
                deathRecipient.binderDied();
                AppMethodBeat.o(149061);
            }
        }

        public boolean unlinkToDeath(IBinder.DeathRecipient deathRecipient, int i2) {
            AppMethodBeat.i(149062);
            boolean unlinkToDeath = this.AFX.unlinkToDeath(deathRecipient, i2);
            AppMethodBeat.o(149062);
            return unlinkToDeath;
        }
    }

    final class i implements IBinder {
        private final Class<?> AGa;
        private a<String> AGb = null;
        private String AGc = null;

        /* access modifiers changed from: package-private */
        public final class a<T> extends SparseArray<T> {
            private a() {
            }

            /* synthetic */ a(i iVar, byte b2) {
                this();
            }

            public final void clear() {
                AppMethodBeat.i(149066);
                UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
                AppMethodBeat.o(149066);
                throw unsupportedOperationException;
            }

            @Override // android.util.SparseArray
            public final void put(int i2, T t) {
                AppMethodBeat.i(149067);
                if (get(i2) != null) {
                    UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
                    AppMethodBeat.o(149067);
                    throw unsupportedOperationException;
                }
                super.put(i2, t);
                AppMethodBeat.o(149067);
            }
        }

        i(Class<?> cls) {
            this.AGa = cls;
        }

        public final synchronized SparseArray<String> eyp() {
            a<String> aVar;
            AppMethodBeat.i(149068);
            if (this.AGb != null) {
                aVar = this.AGb;
                AppMethodBeat.o(149068);
            } else {
                this.AGb = new a<>(this, (byte) 0);
                try {
                    IInterface iInterface = (IInterface) i.b(this.AGa, "asInterface", i.b(IBinder.class), this);
                    Class<?>[] interfaces = this.AGa.getInterfaces();
                    for (Class<?> cls : interfaces) {
                        if (IInterface.class.isAssignableFrom(cls)) {
                            Method[] declaredMethods = cls.getDeclaredMethods();
                            for (Method method : declaredMethods) {
                                if (!"asBinder".equals(method.getName())) {
                                    this.AGc = method.getName();
                                    if (!method.isAccessible()) {
                                        method.setAccessible(true);
                                    }
                                    Class<?>[] parameterTypes = method.getParameterTypes();
                                    int length = parameterTypes.length;
                                    Object[] objArr = new Object[length];
                                    for (int i2 = 0; i2 < length; i2++) {
                                        Class<?> cls2 = parameterTypes[i2];
                                        if (cls2.isPrimitive()) {
                                            if (Boolean.TYPE.isAssignableFrom(cls2)) {
                                                objArr[i2] = Boolean.FALSE;
                                            } else {
                                                objArr[i2] = 0;
                                            }
                                        } else if (Number.class.isAssignableFrom(cls2)) {
                                            objArr[i2] = 0;
                                        } else if (Character.class.isAssignableFrom(cls2)) {
                                            objArr[i2] = (char) 0;
                                        } else if (Boolean.class.isAssignableFrom(cls2)) {
                                            objArr[i2] = Boolean.FALSE;
                                        } else {
                                            objArr[i2] = null;
                                        }
                                    }
                                    method.invoke(iInterface, objArr);
                                }
                            }
                        }
                    }
                } catch (Throwable th) {
                    Log.printErrStackTrace("MicroMsg.AED", th, "unexpected exception.", new Object[0]);
                    b.a(b.this, th);
                    this.AGb.clear();
                }
                aVar = this.AGb;
                AppMethodBeat.o(149068);
            }
            return aVar;
        }

        @Override // android.os.IBinder
        public final String getInterfaceDescriptor() {
            return null;
        }

        public final boolean pingBinder() {
            return false;
        }

        public final boolean isBinderAlive() {
            return false;
        }

        public final IInterface queryLocalInterface(String str) {
            return null;
        }

        @Override // android.os.IBinder
        public final void dump(FileDescriptor fileDescriptor, String[] strArr) {
        }

        @Override // android.os.IBinder
        public final void dumpAsync(FileDescriptor fileDescriptor, String[] strArr) {
        }

        @Override // android.os.IBinder
        public final boolean transact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            AppMethodBeat.i(149069);
            synchronized (this) {
                try {
                    if (this.AGb != null) {
                        this.AGb.put(i2, this.AGc);
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(149069);
                    throw th;
                }
            }
            AppMethodBeat.o(149069);
            return false;
        }

        @Override // android.os.IBinder
        public final void linkToDeath(IBinder.DeathRecipient deathRecipient, int i2) {
        }

        public final boolean unlinkToDeath(IBinder.DeathRecipient deathRecipient, int i2) {
            return false;
        }
    }

    public static class f extends Exception {
        f(String str) {
            super(str);
        }

        f(Throwable th) {
            super(th);
        }
    }

    private b() {
        AppMethodBeat.i(149076);
        this.AFG = new ConcurrentLinkedQueue();
        this.AFH = new WeakHashMap();
        this.AFI = new ConcurrentHashMap();
        this.AFJ = new Handler(Looper.getMainLooper());
        this.AFK = null;
        this.mInitialized = false;
        AppMethodBeat.o(149076);
    }

    static /* synthetic */ void a(b bVar, final Throwable th) {
        AppMethodBeat.i(149077);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            bVar.o(th);
            AppMethodBeat.o(149077);
            return;
        }
        final boolean[] zArr = {false};
        bVar.AFJ.post(new Runnable() {
            /* class com.tencent.mm.plugin.normsg.d.b.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(149044);
                b.b(b.this, th);
                synchronized (zArr) {
                    try {
                        zArr[0] = true;
                        zArr.notifyAll();
                    } finally {
                        AppMethodBeat.o(149044);
                    }
                }
            }
        });
        synchronized (zArr) {
            while (!zArr[0]) {
                try {
                    try {
                        zArr.wait();
                    } catch (InterruptedException e2) {
                    }
                } finally {
                    AppMethodBeat.o(149077);
                }
            }
        }
    }

    static /* synthetic */ Object b(Method method) {
        AppMethodBeat.i(149078);
        Class<?> returnType = method.getReturnType();
        if (returnType.isPrimitive()) {
            if (Boolean.TYPE.isAssignableFrom(returnType)) {
                Boolean bool = Boolean.FALSE;
                AppMethodBeat.o(149078);
                return bool;
            }
            AppMethodBeat.o(149078);
            return 0;
        } else if (Number.class.isAssignableFrom(returnType)) {
            AppMethodBeat.o(149078);
            return 0;
        } else if (Character.class.isAssignableFrom(returnType)) {
            AppMethodBeat.o(149078);
            return (char) 0;
        } else if (Boolean.class.isAssignableFrom(returnType)) {
            Boolean bool2 = Boolean.FALSE;
            AppMethodBeat.o(149078);
            return bool2;
        } else {
            AppMethodBeat.o(149078);
            return null;
        }
    }

    static /* synthetic */ void a(b bVar, final int i2, final View view, final List list) {
        AppMethodBeat.i(149080);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            bVar.b(i2, view, list);
            AppMethodBeat.o(149080);
            return;
        }
        final boolean[] zArr = {false};
        bVar.AFJ.post(new Runnable() {
            /* class com.tencent.mm.plugin.normsg.d.b.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(149042);
                b.b(b.this, i2, view, list);
                synchronized (zArr) {
                    try {
                        zArr[0] = true;
                        zArr.notifyAll();
                    } finally {
                        AppMethodBeat.o(149042);
                    }
                }
            }
        });
        synchronized (zArr) {
            while (!zArr[0]) {
                try {
                    try {
                        zArr.wait();
                    } catch (InterruptedException e2) {
                    }
                } finally {
                    AppMethodBeat.o(149080);
                }
            }
        }
    }
}
