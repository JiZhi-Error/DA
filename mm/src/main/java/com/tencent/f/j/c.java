package com.tencent.f.j;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Printer;
import com.tencent.f.d;
import com.tencent.f.h;
import com.tencent.f.i.e;
import com.tencent.f.i.j;
import com.tencent.f.j.d;
import com.tencent.f.k.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Objects;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;

public class c implements com.tencent.f.d.a {
    private static final String TAG = "SerialHandler";
    private final Handler.Callback callback;
    private boolean hasDefaultLooper;
    private boolean isLogging;
    private AtomicBoolean isQuit;
    private final Handler proxyHandler;
    private b recycleMethod;
    private final a serial;
    private final String serialTag;

    static /* synthetic */ void access$400(c cVar, Message message) {
        AppMethodBeat.i(183463);
        cVar.recycleMessage(message);
        AppMethodBeat.o(183463);
    }

    public static c create(String str) {
        AppMethodBeat.i(256685);
        c cVar = new c(str);
        AppMethodBeat.o(256685);
        return cVar;
    }

    public c(a aVar) {
        this(aVar, (Handler.Callback) null);
    }

    public c(a aVar, Handler.Callback callback2) {
        AppMethodBeat.i(183430);
        this.isLogging = true;
        this.isQuit = new AtomicBoolean();
        this.proxyHandler = new Handler(Looper.getMainLooper()) {
            /* class com.tencent.f.j.c.AnonymousClass1 */

            public final void dispatchMessage(Message message) {
                AppMethodBeat.i(183411);
                c.this.dispatchMessage(message);
                AppMethodBeat.o(183411);
            }

            public final void handleMessage(Message message) {
                AppMethodBeat.i(183412);
                c.this.handleMessage(message);
                AppMethodBeat.o(183412);
            }

            public final boolean sendMessageAtTime(Message message, long j2) {
                AppMethodBeat.i(183413);
                message.setTarget(c.this.proxyHandler);
                boolean sendMessageAtTime = c.this.sendMessageAtTime(message, j2);
                AppMethodBeat.o(183413);
                return sendMessageAtTime;
            }

            public final String toString() {
                AppMethodBeat.i(183414);
                String cVar = c.this.toString();
                AppMethodBeat.o(183414);
                return cVar;
            }
        };
        this.recycleMethod = new b(Message.class, "recycleUnchecked", new Class[0]);
        Objects.requireNonNull(aVar);
        this.serial = aVar;
        this.serialTag = aVar.tag;
        this.callback = callback2;
        try {
            new com.tencent.f.k.a(Handler.class, "mLooper").eE(this.proxyHandler);
            AppMethodBeat.o(183430);
        } catch (Exception e2) {
            RuntimeException runtimeException = new RuntimeException(e2);
            AppMethodBeat.o(183430);
            throw runtimeException;
        }
    }

    public c(String str) {
        this(a.bqt(str), (Handler.Callback) null);
        AppMethodBeat.i(256686);
        AppMethodBeat.o(256686);
    }

    public c(String str, Handler.Callback callback2) {
        this(a.bqt(str), callback2);
        AppMethodBeat.i(256687);
        AppMethodBeat.o(256687);
    }

    public void setHasDefaultLooper(boolean z) {
        this.hasDefaultLooper = z;
    }

    public void setLogging(boolean z) {
        this.isLogging = z;
    }

    @Override // com.tencent.f.d.a
    public String getSerialTag() {
        return this.serialTag;
    }

    @Override // com.tencent.f.d.a
    public a getSerial() {
        return this.serial;
    }

    @Override // com.tencent.f.d.a
    public String getMessageName(Message message) {
        AppMethodBeat.i(183431);
        String messageName = this.proxyHandler.getMessageName(message);
        AppMethodBeat.o(183431);
        return messageName;
    }

    @Override // com.tencent.f.d.a
    public Message obtainMessage() {
        AppMethodBeat.i(183432);
        Message obtainMessage = this.proxyHandler.obtainMessage();
        AppMethodBeat.o(183432);
        return obtainMessage;
    }

    @Override // com.tencent.f.d.a
    public Message obtainMessage(int i2) {
        AppMethodBeat.i(183433);
        Message obtainMessage = this.proxyHandler.obtainMessage(i2);
        AppMethodBeat.o(183433);
        return obtainMessage;
    }

    @Override // com.tencent.f.d.a
    public Message obtainMessage(int i2, Object obj) {
        AppMethodBeat.i(183434);
        Message obtainMessage = this.proxyHandler.obtainMessage(i2, obj);
        AppMethodBeat.o(183434);
        return obtainMessage;
    }

    @Override // com.tencent.f.d.a
    public Message obtainMessage(int i2, int i3, int i4) {
        AppMethodBeat.i(183435);
        Message obtainMessage = this.proxyHandler.obtainMessage(i2, i3, i4);
        AppMethodBeat.o(183435);
        return obtainMessage;
    }

    @Override // com.tencent.f.d.a
    public Message obtainMessage(int i2, int i3, int i4, Object obj) {
        AppMethodBeat.i(183436);
        Message obtainMessage = this.proxyHandler.obtainMessage(i2, i3, i4, obj);
        AppMethodBeat.o(183436);
        return obtainMessage;
    }

    @Override // com.tencent.f.d.a
    public boolean post(Runnable runnable) {
        AppMethodBeat.i(183437);
        boolean post = this.proxyHandler.post(runnable);
        AppMethodBeat.o(183437);
        return post;
    }

    @Override // com.tencent.f.d.a
    public boolean postAtTime(Runnable runnable, long j2) {
        AppMethodBeat.i(183438);
        boolean postAtTime = this.proxyHandler.postAtTime(runnable, j2);
        AppMethodBeat.o(183438);
        return postAtTime;
    }

    @Override // com.tencent.f.d.a
    public boolean postAtTime(Runnable runnable, Object obj, long j2) {
        AppMethodBeat.i(183439);
        boolean postAtTime = this.proxyHandler.postAtTime(runnable, obj, j2);
        AppMethodBeat.o(183439);
        return postAtTime;
    }

    @Override // com.tencent.f.d.a
    public boolean postDelayed(Runnable runnable, long j2) {
        AppMethodBeat.i(183440);
        boolean postDelayed = this.proxyHandler.postDelayed(runnable, j2);
        AppMethodBeat.o(183440);
        return postDelayed;
    }

    @Override // com.tencent.f.d.a
    public boolean postDelayed(Runnable runnable, Object obj, long j2) {
        AppMethodBeat.i(183441);
        Message obtain = Message.obtain(this.proxyHandler, runnable);
        obtain.obj = obj;
        boolean sendMessageDelayed = sendMessageDelayed(obtain, j2);
        AppMethodBeat.o(183441);
        return sendMessageDelayed;
    }

    @Override // com.tencent.f.d.a
    public boolean postAtFrontOfQueue(Runnable runnable) {
        AppMethodBeat.i(183442);
        boolean sendMessageAtTime = this.proxyHandler.sendMessageAtTime(Message.obtain(this.proxyHandler, runnable), Long.MIN_VALUE);
        AppMethodBeat.o(183442);
        return sendMessageAtTime;
    }

    @Override // com.tencent.f.d.a
    public boolean sendMessage(Message message) {
        AppMethodBeat.i(183443);
        boolean sendMessage = this.proxyHandler.sendMessage(message);
        AppMethodBeat.o(183443);
        return sendMessage;
    }

    @Override // com.tencent.f.d.a
    public boolean sendEmptyMessage(int i2) {
        AppMethodBeat.i(183444);
        boolean sendEmptyMessage = this.proxyHandler.sendEmptyMessage(i2);
        AppMethodBeat.o(183444);
        return sendEmptyMessage;
    }

    @Override // com.tencent.f.d.a
    public boolean sendEmptyMessageDelayed(int i2, long j2) {
        AppMethodBeat.i(183445);
        boolean sendEmptyMessageDelayed = this.proxyHandler.sendEmptyMessageDelayed(i2, j2);
        AppMethodBeat.o(183445);
        return sendEmptyMessageDelayed;
    }

    @Override // com.tencent.f.d.a
    public boolean sendEmptyMessageAtTime(int i2, long j2) {
        AppMethodBeat.i(183446);
        boolean sendEmptyMessageAtTime = this.proxyHandler.sendEmptyMessageAtTime(i2, j2);
        AppMethodBeat.o(183446);
        return sendEmptyMessageAtTime;
    }

    @Override // com.tencent.f.d.a
    public boolean sendMessageDelayed(Message message, long j2) {
        AppMethodBeat.i(183447);
        boolean sendMessageDelayed = this.proxyHandler.sendMessageDelayed(message, j2);
        AppMethodBeat.o(183447);
        return sendMessageDelayed;
    }

    @Override // com.tencent.f.d.a
    public boolean sendMessageAtFrontOfQueue(Message message) {
        AppMethodBeat.i(183448);
        boolean sendMessageAtTime = this.proxyHandler.sendMessageAtTime(message, Long.MIN_VALUE);
        AppMethodBeat.o(183448);
        return sendMessageAtTime;
    }

    @Override // com.tencent.f.d.a
    public boolean executeOrSendMessage(Message message) {
        AppMethodBeat.i(183449);
        if (a.hmE() == this.serial) {
            dispatchMessage(message);
            AppMethodBeat.o(183449);
            return true;
        }
        boolean sendMessage = sendMessage(message);
        AppMethodBeat.o(183449);
        return sendMessage;
    }

    @Override // com.tencent.f.d.a
    public boolean sendMessageAtTime(Message message, long j2) {
        AppMethodBeat.i(183450);
        a createRunnable = createRunnable(message);
        if (isQuit()) {
            d.RSQ.g(createRunnable.getKey(), 0, this.serialTag);
            AppMethodBeat.o(183450);
            return false;
        } else if (h.RTc.isShutdown()) {
            d.RSQ.g(createRunnable.getKey(), 0, this.serialTag);
            AppMethodBeat.o(183450);
            return false;
        } else {
            if (j2 != Long.MIN_VALUE) {
                long uptimeMillis = j2 - SystemClock.uptimeMillis();
                if (a.hmD() == this.serial) {
                    h.RTc.n(createRunnable, uptimeMillis);
                } else {
                    h.RTc.a(createRunnable, uptimeMillis, this.serialTag);
                }
            } else if (a.hmD() == this.serial) {
                h.RTc.aW(createRunnable);
            } else {
                h.RTc.c(createRunnable, this.serialTag);
            }
            AppMethodBeat.o(183450);
            return true;
        }
    }

    @Override // com.tencent.f.d.a
    public void dispatchMessage(Message message) {
        AppMethodBeat.i(183451);
        if (message.getCallback() != null) {
            message.getCallback().run();
            AppMethodBeat.o(183451);
        } else if (this.callback == null || !this.callback.handleMessage(message)) {
            handleMessage(message);
            AppMethodBeat.o(183451);
        } else {
            AppMethodBeat.o(183451);
        }
    }

    public void handleMessage(Message message) {
    }

    @Override // com.tencent.f.d.a
    public void removeCallbacks(final Runnable runnable) {
        AppMethodBeat.i(183452);
        this.serial.RUS.a(new d.b() {
            /* class com.tencent.f.j.c.AnonymousClass3 */

            @Override // com.tencent.f.j.d.b
            public final boolean c(e eVar) {
                boolean z = false;
                AppMethodBeat.i(183418);
                Object obj = eVar.RUI;
                if (obj instanceof a) {
                    a aVar = (a) obj;
                    if (aVar.token == c.this && aVar.RUY.getCallback() == runnable) {
                        z = true;
                    }
                    if (z) {
                        aVar.cancel();
                    }
                    AppMethodBeat.o(183418);
                    return z;
                }
                AppMethodBeat.o(183418);
                return false;
            }
        });
        AppMethodBeat.o(183452);
    }

    @Override // com.tencent.f.d.a
    public void removeCallbacks(final Runnable runnable, final Object obj) {
        AppMethodBeat.i(183453);
        this.serial.RUS.a(new d.b() {
            /* class com.tencent.f.j.c.AnonymousClass4 */

            @Override // com.tencent.f.j.d.b
            public final boolean c(e eVar) {
                boolean z = false;
                AppMethodBeat.i(183419);
                Object obj = eVar.RUI;
                if (obj instanceof a) {
                    a aVar = (a) obj;
                    if (aVar.token == c.this && aVar.RUY.getCallback() == runnable && aVar.RUY.obj == obj) {
                        z = true;
                    }
                    if (z) {
                        aVar.cancel();
                    }
                    AppMethodBeat.o(183419);
                    return z;
                }
                AppMethodBeat.o(183419);
                return false;
            }
        });
        AppMethodBeat.o(183453);
    }

    @Override // com.tencent.f.d.a
    public void removeMessages(final int i2) {
        AppMethodBeat.i(183454);
        this.serial.RUS.a(new d.b() {
            /* class com.tencent.f.j.c.AnonymousClass5 */

            @Override // com.tencent.f.j.d.b
            public final boolean c(e eVar) {
                boolean z = false;
                AppMethodBeat.i(183420);
                Object obj = eVar.RUI;
                if (obj instanceof a) {
                    a aVar = (a) obj;
                    if (aVar.token == c.this && aVar.RUY.what == i2) {
                        z = true;
                    }
                    if (z) {
                        aVar.cancel();
                    }
                    AppMethodBeat.o(183420);
                    return z;
                }
                AppMethodBeat.o(183420);
                return false;
            }
        });
        AppMethodBeat.o(183454);
    }

    @Override // com.tencent.f.d.a
    public void removeMessages(final int i2, final Object obj) {
        AppMethodBeat.i(183455);
        this.serial.RUS.a(new d.b() {
            /* class com.tencent.f.j.c.AnonymousClass6 */

            @Override // com.tencent.f.j.d.b
            public final boolean c(e eVar) {
                boolean z = false;
                AppMethodBeat.i(183421);
                Object obj = eVar.RUI;
                if (obj instanceof a) {
                    a aVar = (a) obj;
                    if (aVar.token == c.this && aVar.RUY.what == i2 && aVar.RUY.obj == obj) {
                        z = true;
                    }
                    if (z) {
                        aVar.cancel();
                    }
                    AppMethodBeat.o(183421);
                    return z;
                }
                AppMethodBeat.o(183421);
                return false;
            }
        });
        AppMethodBeat.o(183455);
    }

    @Override // com.tencent.f.d.a
    public void removeCallbacksAndMessages(final Object obj) {
        AppMethodBeat.i(183456);
        this.serial.RUS.a(new d.b() {
            /* class com.tencent.f.j.c.AnonymousClass7 */

            @Override // com.tencent.f.j.d.b
            public final boolean c(e eVar) {
                boolean z = false;
                AppMethodBeat.i(183422);
                Object obj = eVar.RUI;
                if (obj instanceof a) {
                    a aVar = (a) obj;
                    if (aVar.token == c.this && (obj == null || aVar.RUY.obj == obj)) {
                        z = true;
                    }
                    if (z) {
                        aVar.cancel();
                    }
                    AppMethodBeat.o(183422);
                    return z;
                }
                AppMethodBeat.o(183422);
                return false;
            }
        });
        AppMethodBeat.o(183456);
    }

    @Override // com.tencent.f.d.a
    public boolean hasMessages(final int i2) {
        AppMethodBeat.i(183457);
        boolean a2 = this.serial.RUS.a(new d.a() {
            /* class com.tencent.f.j.c.AnonymousClass8 */

            @Override // com.tencent.f.j.d.a
            public final boolean d(e eVar) {
                AppMethodBeat.i(183423);
                Object obj = eVar.RUI;
                if (obj instanceof a) {
                    a aVar = (a) obj;
                    if (aVar.token == c.this && aVar.RUY.what == i2) {
                        AppMethodBeat.o(183423);
                        return true;
                    }
                    AppMethodBeat.o(183423);
                    return false;
                }
                AppMethodBeat.o(183423);
                return false;
            }
        });
        AppMethodBeat.o(183457);
        return a2;
    }

    @Override // com.tencent.f.d.a
    public boolean hasMessages(int i2, final Object obj) {
        AppMethodBeat.i(183458);
        boolean a2 = this.serial.RUS.a(new d.a() {
            /* class com.tencent.f.j.c.AnonymousClass9 */

            @Override // com.tencent.f.j.d.a
            public final boolean d(e eVar) {
                AppMethodBeat.i(183424);
                Object obj = eVar.RUI;
                if (obj instanceof a) {
                    a aVar = (a) obj;
                    if (aVar.token == c.this && aVar.RUY.obj == obj) {
                        AppMethodBeat.o(183424);
                        return true;
                    }
                    AppMethodBeat.o(183424);
                    return false;
                }
                AppMethodBeat.o(183424);
                return false;
            }
        });
        AppMethodBeat.o(183458);
        return a2;
    }

    @Override // com.tencent.f.d.a
    public Looper getLooper() {
        return null;
    }

    @Override // com.tencent.f.d.a
    public boolean isQuit() {
        AppMethodBeat.i(183459);
        boolean z = this.isQuit.get();
        AppMethodBeat.o(183459);
        return z;
    }

    @Override // com.tencent.f.d.a
    public boolean quit() {
        AppMethodBeat.i(183460);
        if (this.isQuit.compareAndSet(false, true)) {
            cancelAll();
            AppMethodBeat.o(183460);
            return true;
        }
        AppMethodBeat.o(183460);
        return false;
    }

    private void cancelAll() {
        AppMethodBeat.i(256688);
        this.serial.RUS.a(new d.b() {
            /* class com.tencent.f.j.c.AnonymousClass10 */

            @Override // com.tencent.f.j.d.b
            public final boolean c(e eVar) {
                boolean z = false;
                AppMethodBeat.i(183425);
                Object obj = eVar.RUI;
                if (obj instanceof a) {
                    a aVar = (a) obj;
                    if (aVar.token == c.this) {
                        z = true;
                    }
                    if (z) {
                        aVar.cancel();
                    }
                    AppMethodBeat.o(183425);
                    return z;
                }
                AppMethodBeat.o(183425);
                return false;
            }
        });
        AppMethodBeat.o(256688);
    }

    public boolean quitSafely() {
        AppMethodBeat.i(256689);
        post(new Runnable() {
            /* class com.tencent.f.j.c.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(256684);
                c.this.quit();
                AppMethodBeat.o(256684);
            }
        });
        AppMethodBeat.o(256689);
        return true;
    }

    @Override // com.tencent.f.d.a
    public Handler getSelf() {
        return null;
    }

    @Override // com.tencent.f.d.a
    public void dump(Printer printer, String str) {
        AppMethodBeat.i(183461);
        printer.println(str + this.serial.RUS.hmI().toString());
        AppMethodBeat.o(183461);
    }

    /* access modifiers changed from: protected */
    public a createRunnable(Message message) {
        AppMethodBeat.i(256690);
        a aVar = new a(message);
        AppMethodBeat.o(256690);
        return aVar;
    }

    /* access modifiers changed from: package-private */
    public class a implements e, j {
        private Message RUY;
        private String RUZ;
        private Future<?> dBz;
        Object token;

        a(Message message) {
            AppMethodBeat.i(183426);
            if (message == null) {
                NullPointerException nullPointerException = new NullPointerException("msg is null");
                AppMethodBeat.o(183426);
                throw nullPointerException;
            }
            this.RUY = message;
            this.RUZ = c.this.serialTag + "#" + c.this.getMessageName(message);
            this.token = c.this;
            AppMethodBeat.o(183426);
        }

        public final void run() {
            AppMethodBeat.i(183427);
            if (c.this.isQuit.get()) {
                this.dBz.cancel(false);
                com.tencent.f.d.RSS.w(c.TAG, String.format("this handler has quit! %s", this.RUZ), new Object[0]);
                AppMethodBeat.o(183427);
            } else if (this.RUY.getTarget() == null && this.RUY.obj == null && this.RUY.what == 0) {
                this.dBz.cancel(false);
                com.tencent.f.d.RSS.w(c.TAG, String.format("maybe it's removed before! %s", this.RUZ), new Object[0]);
                AppMethodBeat.o(183427);
            } else {
                ((Handler) Objects.requireNonNull(this.RUY.getTarget(), "target is null!")).dispatchMessage(this.RUY);
                c.access$400(c.this, this.RUY);
                AppMethodBeat.o(183427);
            }
        }

        public final boolean cancel() {
            AppMethodBeat.i(183428);
            c.access$400(c.this, this.RUY);
            boolean cancel = this.dBz.cancel(false);
            AppMethodBeat.o(183428);
            return cancel;
        }

        @Override // com.tencent.f.i.h, com.tencent.f.i.g
        public final String getKey() {
            return this.RUZ;
        }

        @Override // com.tencent.f.i.e
        public final void a(Future future) {
            this.dBz = future;
        }

        @Override // com.tencent.f.i.j
        public final boolean axI() {
            AppMethodBeat.i(183429);
            boolean z = c.this.isLogging;
            AppMethodBeat.o(183429);
            return z;
        }
    }

    private void recycleMessage(Message message) {
        AppMethodBeat.i(256691);
        if (message == null) {
            AppMethodBeat.o(256691);
            return;
        }
        try {
            this.recycleMethod.invoke(message, new Object[0]);
            AppMethodBeat.o(256691);
        } catch (Exception e2) {
            RuntimeException runtimeException = new RuntimeException(e2);
            AppMethodBeat.o(256691);
            throw runtimeException;
        }
    }

    public String toString() {
        AppMethodBeat.i(183462);
        String format = String.format("SerialHandler(%s) %s", getSerialTag(), getClass().getName());
        AppMethodBeat.o(183462);
        return format;
    }
}
