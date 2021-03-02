package com.tencent.mm.sdk.platformtools;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Printer;
import com.tencent.f.d.a;
import com.tencent.f.d.b;
import com.tencent.f.j.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Objects;

public class MMHandler implements a {
    private static final long SLOW_DURATION = 5000;
    private static final long SLOW_UI_DURATION = 300;
    private static final Handler UIHandler = new Handler(Looper.getMainLooper());
    private final Object lock;
    private final a realHandler;
    private volatile Message runningMsg;

    public interface Callback extends Handler.Callback {
    }

    @Target({ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.TYPE, ElementType.PARAMETER})
    @Retention(RetentionPolicy.CLASS)
    @interface Specially {
    }

    static {
        AppMethodBeat.i(182962);
        AppMethodBeat.o(182962);
    }

    public MMHandler() {
        AppMethodBeat.i(157623);
        this.lock = new Object();
        this.realHandler = createHandler(Looper.myLooper(), com.tencent.f.j.a.hmE(), null);
        AppMethodBeat.o(157623);
    }

    public MMHandler(Callback callback) {
        AppMethodBeat.i(157625);
        this.lock = new Object();
        this.realHandler = createHandler(Looper.myLooper(), com.tencent.f.j.a.hmE(), callback);
        AppMethodBeat.o(157625);
    }

    public MMHandler(Looper looper) {
        AppMethodBeat.i(157624);
        this.lock = new Object();
        Objects.requireNonNull(looper);
        this.realHandler = createHandler(looper, null, null);
        AppMethodBeat.o(157624);
    }

    public MMHandler(Looper looper, Callback callback) {
        AppMethodBeat.i(157626);
        this.lock = new Object();
        Objects.requireNonNull(looper);
        this.realHandler = createHandler(looper, null, callback);
        AppMethodBeat.o(157626);
    }

    public MMHandler(String str, Callback callback) {
        AppMethodBeat.i(157627);
        this.lock = new Object();
        Objects.requireNonNull(str);
        this.realHandler = createHandler(null, com.tencent.f.j.a.bqt(str), callback);
        AppMethodBeat.o(157627);
    }

    public MMHandler(String str) {
        AppMethodBeat.i(157628);
        this.lock = new Object();
        this.realHandler = createHandler(null, com.tencent.f.j.a.bqt(str), null);
        AppMethodBeat.o(157628);
    }

    public MMHandler(com.tencent.f.j.a aVar) {
        AppMethodBeat.i(182942);
        this.lock = new Object();
        Objects.requireNonNull(aVar);
        this.realHandler = createHandler(null, aVar, null);
        AppMethodBeat.o(182942);
    }

    public MMHandler(com.tencent.f.j.a aVar, Callback callback) {
        AppMethodBeat.i(182943);
        this.lock = new Object();
        Objects.requireNonNull(aVar);
        this.realHandler = createHandler(null, aVar, callback);
        AppMethodBeat.o(182943);
    }

    @Override // com.tencent.f.d.a
    public String getMessageName(Message message) {
        AppMethodBeat.i(157629);
        String messageName = this.realHandler.getMessageName(message);
        AppMethodBeat.o(157629);
        return messageName;
    }

    @Override // com.tencent.f.d.a
    public Message obtainMessage() {
        AppMethodBeat.i(157630);
        Message obtainMessage = this.realHandler.obtainMessage();
        AppMethodBeat.o(157630);
        return obtainMessage;
    }

    @Override // com.tencent.f.d.a
    public Message obtainMessage(int i2) {
        AppMethodBeat.i(157631);
        Message obtainMessage = this.realHandler.obtainMessage(i2);
        AppMethodBeat.o(157631);
        return obtainMessage;
    }

    @Override // com.tencent.f.d.a
    public Message obtainMessage(int i2, Object obj) {
        AppMethodBeat.i(157632);
        Message obtainMessage = this.realHandler.obtainMessage(i2, obj);
        AppMethodBeat.o(157632);
        return obtainMessage;
    }

    @Override // com.tencent.f.d.a
    public Message obtainMessage(int i2, int i3, int i4) {
        AppMethodBeat.i(157633);
        Message obtainMessage = this.realHandler.obtainMessage(i2, i3, i4);
        AppMethodBeat.o(157633);
        return obtainMessage;
    }

    @Override // com.tencent.f.d.a
    public Message obtainMessage(int i2, int i3, int i4, Object obj) {
        AppMethodBeat.i(157634);
        Message obtainMessage = this.realHandler.obtainMessage(i2, i3, i4, obj);
        AppMethodBeat.o(157634);
        return obtainMessage;
    }

    @Override // com.tencent.f.d.a
    public boolean post(Runnable runnable) {
        AppMethodBeat.i(157635);
        boolean post = this.realHandler.post(runnable);
        AppMethodBeat.o(157635);
        return post;
    }

    @Override // com.tencent.f.d.a
    public boolean postAtTime(Runnable runnable, long j2) {
        AppMethodBeat.i(157636);
        boolean postAtTime = this.realHandler.postAtTime(runnable, j2);
        AppMethodBeat.o(157636);
        return postAtTime;
    }

    @Override // com.tencent.f.d.a
    public boolean postAtTime(Runnable runnable, Object obj, long j2) {
        AppMethodBeat.i(157637);
        boolean postAtTime = this.realHandler.postAtTime(runnable, obj, j2);
        AppMethodBeat.o(157637);
        return postAtTime;
    }

    @Override // com.tencent.f.d.a
    public boolean postDelayed(Runnable runnable, long j2) {
        AppMethodBeat.i(157638);
        boolean postDelayed = this.realHandler.postDelayed(runnable, j2);
        AppMethodBeat.o(157638);
        return postDelayed;
    }

    @Override // com.tencent.f.d.a
    public boolean postDelayed(Runnable runnable, Object obj, long j2) {
        AppMethodBeat.i(182944);
        boolean postDelayed = this.realHandler.postDelayed(runnable, obj, j2);
        AppMethodBeat.o(182944);
        return postDelayed;
    }

    @Override // com.tencent.f.d.a
    public boolean postAtFrontOfQueue(Runnable runnable) {
        AppMethodBeat.i(157639);
        boolean postAtFrontOfQueue = this.realHandler.postAtFrontOfQueue(runnable);
        AppMethodBeat.o(157639);
        return postAtFrontOfQueue;
    }

    @Override // com.tencent.f.d.a
    public void removeCallbacks(Runnable runnable) {
        AppMethodBeat.i(157641);
        this.realHandler.removeCallbacks(runnable);
        AppMethodBeat.o(157641);
    }

    @Override // com.tencent.f.d.a
    public void removeCallbacks(Runnable runnable, Object obj) {
        AppMethodBeat.i(157642);
        this.realHandler.removeCallbacks(runnable, obj);
        AppMethodBeat.o(157642);
    }

    @Override // com.tencent.f.d.a
    public boolean sendMessage(Message message) {
        AppMethodBeat.i(157643);
        boolean sendMessage = this.realHandler.sendMessage(message);
        AppMethodBeat.o(157643);
        return sendMessage;
    }

    @Override // com.tencent.f.d.a
    public boolean sendEmptyMessage(int i2) {
        AppMethodBeat.i(157644);
        boolean sendEmptyMessage = this.realHandler.sendEmptyMessage(i2);
        AppMethodBeat.o(157644);
        return sendEmptyMessage;
    }

    @Override // com.tencent.f.d.a
    public boolean sendEmptyMessageDelayed(int i2, long j2) {
        AppMethodBeat.i(157645);
        boolean sendEmptyMessageDelayed = this.realHandler.sendEmptyMessageDelayed(i2, j2);
        AppMethodBeat.o(157645);
        return sendEmptyMessageDelayed;
    }

    @Override // com.tencent.f.d.a
    public boolean sendEmptyMessageAtTime(int i2, long j2) {
        AppMethodBeat.i(157646);
        boolean sendEmptyMessageAtTime = this.realHandler.sendEmptyMessageAtTime(i2, j2);
        AppMethodBeat.o(157646);
        return sendEmptyMessageAtTime;
    }

    @Override // com.tencent.f.d.a
    public boolean sendMessageDelayed(Message message, long j2) {
        AppMethodBeat.i(157647);
        boolean sendMessageDelayed = this.realHandler.sendMessageDelayed(message, j2);
        AppMethodBeat.o(157647);
        return sendMessageDelayed;
    }

    @Override // com.tencent.f.d.a
    public final boolean sendMessageAtTime(Message message, long j2) {
        AppMethodBeat.i(157648);
        boolean sendMessageAtTime = this.realHandler.sendMessageAtTime(message, j2);
        AppMethodBeat.o(157648);
        return sendMessageAtTime;
    }

    @Override // com.tencent.f.d.a
    public boolean sendMessageAtFrontOfQueue(Message message) {
        AppMethodBeat.i(157649);
        boolean sendMessageAtFrontOfQueue = this.realHandler.sendMessageAtFrontOfQueue(message);
        AppMethodBeat.o(157649);
        return sendMessageAtFrontOfQueue;
    }

    @Override // com.tencent.f.d.a
    public boolean executeOrSendMessage(Message message) {
        AppMethodBeat.i(182945);
        boolean executeOrSendMessage = this.realHandler.executeOrSendMessage(message);
        AppMethodBeat.o(182945);
        return executeOrSendMessage;
    }

    @Override // com.tencent.f.d.a
    public void removeMessages(int i2) {
        AppMethodBeat.i(157650);
        this.realHandler.removeMessages(i2);
        AppMethodBeat.o(157650);
    }

    @Override // com.tencent.f.d.a
    public void removeMessages(int i2, Object obj) {
        AppMethodBeat.i(157651);
        this.realHandler.removeMessages(i2, obj);
        AppMethodBeat.o(157651);
    }

    @Override // com.tencent.f.d.a
    public final void dispatchMessage(Message message) {
        AppMethodBeat.i(182946);
        this.realHandler.dispatchMessage(message);
        AppMethodBeat.o(182946);
    }

    @Override // com.tencent.f.d.a
    public void removeCallbacksAndMessages(Object obj) {
        AppMethodBeat.i(157652);
        this.realHandler.removeCallbacksAndMessages(obj);
        AppMethodBeat.o(157652);
    }

    @Override // com.tencent.f.d.a
    public boolean hasMessages(int i2) {
        AppMethodBeat.i(157653);
        boolean hasMessages = this.realHandler.hasMessages(i2);
        AppMethodBeat.o(157653);
        return hasMessages;
    }

    @Override // com.tencent.f.d.a
    public boolean hasMessages(int i2, Object obj) {
        AppMethodBeat.i(157654);
        boolean hasMessages = this.realHandler.hasMessages(i2, obj);
        AppMethodBeat.o(157654);
        return hasMessages;
    }

    @Override // com.tencent.f.d.a
    public Looper getLooper() {
        AppMethodBeat.i(157655);
        Looper looper = this.realHandler.getLooper();
        AppMethodBeat.o(157655);
        return looper;
    }

    @Override // com.tencent.f.d.a
    public String getSerialTag() {
        AppMethodBeat.i(182947);
        String serialTag = this.realHandler.getSerialTag();
        AppMethodBeat.o(182947);
        return serialTag;
    }

    @Override // com.tencent.f.d.a
    public com.tencent.f.j.a getSerial() {
        AppMethodBeat.i(182948);
        com.tencent.f.j.a serial = this.realHandler.getSerial();
        AppMethodBeat.o(182948);
        return serial;
    }

    public void handleMessage(Message message) {
    }

    @Override // com.tencent.f.d.a
    public boolean isQuit() {
        AppMethodBeat.i(182949);
        boolean isQuit = this.realHandler.isQuit();
        AppMethodBeat.o(182949);
        return isQuit;
    }

    @Override // com.tencent.f.d.a
    public boolean quit() {
        boolean quit;
        AppMethodBeat.i(182950);
        synchronized (this.lock) {
            try {
                quit = this.realHandler.quit();
                this.lock.notifyAll();
            } finally {
                AppMethodBeat.o(182950);
            }
        }
        return quit;
    }

    public boolean quitSafely() {
        AppMethodBeat.i(182951);
        this.realHandler.post(new Runnable() {
            /* class com.tencent.mm.sdk.platformtools.MMHandler.AnonymousClass1 */

            public void run() {
                AppMethodBeat.i(182937);
                MMHandler.this.quit();
                AppMethodBeat.o(182937);
            }
        });
        AppMethodBeat.o(182951);
        return true;
    }

    @Override // com.tencent.f.d.a
    public final Handler getSelf() {
        AppMethodBeat.i(182952);
        Handler self = this.realHandler.getSelf();
        AppMethodBeat.o(182952);
        return self;
    }

    @Override // com.tencent.f.d.a
    public void dump(Printer printer, String str) {
        AppMethodBeat.i(157656);
        this.realHandler.dump(printer, str);
        AppMethodBeat.o(157656);
    }

    public String toString() {
        AppMethodBeat.i(157657);
        String obj = this.realHandler.toString();
        AppMethodBeat.o(157657);
        return obj;
    }

    public void setHasDefaultLooper(boolean z) {
        AppMethodBeat.i(230337);
        if (this.realHandler instanceof c) {
            ((c) this.realHandler).setHasDefaultLooper(z);
        }
        AppMethodBeat.o(230337);
    }

    public void setLogging(boolean z) {
        AppMethodBeat.i(230338);
        if (this.realHandler instanceof c) {
            ((c) this.realHandler).setLogging(z);
        }
        AppMethodBeat.o(230338);
    }

    public void postUI(Runnable runnable) {
        AppMethodBeat.i(182953);
        UIHandler.post(runnable);
        AppMethodBeat.o(182953);
    }

    public void postUIDelayed(Runnable runnable, long j2) {
        AppMethodBeat.i(182954);
        UIHandler.postDelayed(runnable, j2);
        AppMethodBeat.o(182954);
    }

    public Message getRunningMessage() {
        return this.runningMsg;
    }

    public void join() {
        AppMethodBeat.i(182955);
        join(0);
        AppMethodBeat.o(182955);
    }

    public void join(long j2) {
        AppMethodBeat.i(182956);
        synchronized (this.lock) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                if (j2 >= 0) {
                    if (j2 != 0) {
                        long j3 = 0;
                        while (!isQuit()) {
                            long j4 = j2 - j3;
                            if (j4 <= 0) {
                                break;
                            }
                            this.lock.wait(j4);
                            j3 = System.currentTimeMillis() - currentTimeMillis;
                        }
                    } else {
                        while (!isQuit()) {
                            this.lock.wait(j2);
                        }
                    }
                } else {
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("timeout value is negative");
                    AppMethodBeat.o(182956);
                    throw illegalArgumentException;
                }
            } finally {
                AppMethodBeat.o(182956);
            }
        }
    }

    @Specially
    public static Handler createFreeHandler(Looper looper) {
        AppMethodBeat.i(182957);
        Handler handler = new Handler(looper);
        AppMethodBeat.o(182957);
        return handler;
    }

    private a createHandler(Looper looper, com.tencent.f.j.a aVar, Callback callback) {
        AppMethodBeat.i(182958);
        if (looper == Looper.getMainLooper() || aVar == com.tencent.f.j.a.hmD()) {
            a createLooperHandler = createLooperHandler(Looper.getMainLooper(), callback);
            AppMethodBeat.o(182958);
            return createLooperHandler;
        } else if (aVar != null) {
            a createSerialHandler = createSerialHandler(aVar, callback);
            AppMethodBeat.o(182958);
            return createSerialHandler;
        } else if (looper != null) {
            a createLooperHandler2 = createLooperHandler(looper, callback);
            AppMethodBeat.o(182958);
            return createLooperHandler2;
        } else {
            RuntimeException runtimeException = new RuntimeException("looper and serial is null!");
            AppMethodBeat.o(182958);
            throw runtimeException;
        }
    }

    private a createLooperHandler(Looper looper, final Callback callback) {
        AppMethodBeat.i(182959);
        final long id = Looper.getMainLooper().getThread().getId();
        b bVar = new b(new Handler(looper, callback) {
            /* class com.tencent.mm.sdk.platformtools.MMHandler.AnonymousClass2 */

            public void dispatchMessage(Message message) {
                AppMethodBeat.i(182938);
                long currentTimeMillis = System.currentTimeMillis();
                MMHandler.this.runningMsg = message;
                super.dispatchMessage(message);
                MMHandler.this.runningMsg = null;
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                Thread currentThread = Thread.currentThread();
                if (id != currentThread.getId() ? currentTimeMillis2 >= MMHandler.SLOW_DURATION : currentTimeMillis2 >= MMHandler.SLOW_UI_DURATION) {
                    Log.w("Handler#Monitor", "This msg handle so slow[%sms]! runnable=%s callback=%s thread=%s", Long.valueOf(currentTimeMillis2), message.getCallback(), callback, currentThread.getName());
                }
                AppMethodBeat.o(182938);
            }

            public void handleMessage(Message message) {
                AppMethodBeat.i(182939);
                MMHandler.this.handleMessage(message);
                AppMethodBeat.o(182939);
            }
        });
        AppMethodBeat.o(182959);
        return bVar;
    }

    @SuppressLint({"HandlerLeak"})
    private a createSerialHandler(com.tencent.f.j.a aVar, final Callback callback) {
        AppMethodBeat.i(182960);
        final long id = Looper.getMainLooper().getThread().getId();
        AnonymousClass3 r0 = new c(aVar, callback) {
            /* class com.tencent.mm.sdk.platformtools.MMHandler.AnonymousClass3 */

            @Override // com.tencent.f.d.a, com.tencent.f.j.c
            public void dispatchMessage(Message message) {
                AppMethodBeat.i(182940);
                long currentTimeMillis = System.currentTimeMillis();
                MMHandler.this.runningMsg = message;
                super.dispatchMessage(message);
                MMHandler.this.runningMsg = null;
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                Thread currentThread = Thread.currentThread();
                if (id != currentThread.getId() ? currentTimeMillis2 >= MMHandler.SLOW_DURATION : currentTimeMillis2 >= MMHandler.SLOW_UI_DURATION) {
                    Log.w("Handler#Monitor", "This msg handle so slow[%sms]! runnable=%s callback=%s thread=%s", Long.valueOf(currentTimeMillis2), message.getCallback(), callback, currentThread.getName());
                }
                AppMethodBeat.o(182940);
            }

            @Override // com.tencent.f.j.c
            public void handleMessage(Message message) {
                AppMethodBeat.i(182941);
                MMHandler.this.handleMessage(message);
                AppMethodBeat.o(182941);
            }
        };
        AppMethodBeat.o(182960);
        return r0;
    }

    @Deprecated
    public final boolean postToWorker(Runnable runnable) {
        AppMethodBeat.i(182961);
        boolean post = this.realHandler.post(runnable);
        AppMethodBeat.o(182961);
        return post;
    }
}
