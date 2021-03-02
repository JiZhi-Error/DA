package com.tencent.f.d;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Printer;
import com.tencent.f.d;
import com.tencent.f.j.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

public final class b implements a {
    private AtomicBoolean isQuit = new AtomicBoolean();
    private final Handler proxyHandler;

    public b(Handler handler) {
        AppMethodBeat.i(183245);
        this.proxyHandler = handler;
        AppMethodBeat.o(183245);
    }

    @Override // com.tencent.f.d.a
    public final String getMessageName(Message message) {
        AppMethodBeat.i(183246);
        String messageName = this.proxyHandler.getMessageName(message);
        AppMethodBeat.o(183246);
        return messageName;
    }

    @Override // com.tencent.f.d.a
    public final Message obtainMessage() {
        AppMethodBeat.i(183247);
        Message obtainMessage = this.proxyHandler.obtainMessage();
        AppMethodBeat.o(183247);
        return obtainMessage;
    }

    @Override // com.tencent.f.d.a
    public final Message obtainMessage(int i2) {
        AppMethodBeat.i(183248);
        Message obtainMessage = this.proxyHandler.obtainMessage(i2);
        AppMethodBeat.o(183248);
        return obtainMessage;
    }

    @Override // com.tencent.f.d.a
    public final Message obtainMessage(int i2, Object obj) {
        AppMethodBeat.i(183249);
        Message obtainMessage = this.proxyHandler.obtainMessage(i2, obj);
        AppMethodBeat.o(183249);
        return obtainMessage;
    }

    @Override // com.tencent.f.d.a
    public final Message obtainMessage(int i2, int i3, int i4) {
        AppMethodBeat.i(183250);
        Message obtainMessage = this.proxyHandler.obtainMessage(i2, i3, i4);
        AppMethodBeat.o(183250);
        return obtainMessage;
    }

    @Override // com.tencent.f.d.a
    public final Message obtainMessage(int i2, int i3, int i4, Object obj) {
        AppMethodBeat.i(183251);
        Message obtainMessage = this.proxyHandler.obtainMessage(i2, i3, i4, obj);
        AppMethodBeat.o(183251);
        return obtainMessage;
    }

    @Override // com.tencent.f.d.a
    public final boolean post(Runnable runnable) {
        AppMethodBeat.i(183252);
        boolean post = this.proxyHandler.post(runnable);
        AppMethodBeat.o(183252);
        return post;
    }

    @Override // com.tencent.f.d.a
    public final boolean postAtTime(Runnable runnable, long j2) {
        AppMethodBeat.i(183253);
        boolean postAtTime = this.proxyHandler.postAtTime(runnable, j2);
        AppMethodBeat.o(183253);
        return postAtTime;
    }

    @Override // com.tencent.f.d.a
    public final boolean postAtTime(Runnable runnable, Object obj, long j2) {
        AppMethodBeat.i(183254);
        boolean postAtTime = this.proxyHandler.postAtTime(runnable, obj, j2);
        AppMethodBeat.o(183254);
        return postAtTime;
    }

    @Override // com.tencent.f.d.a
    public final boolean postDelayed(Runnable runnable, long j2) {
        AppMethodBeat.i(183255);
        boolean postDelayed = this.proxyHandler.postDelayed(runnable, j2);
        AppMethodBeat.o(183255);
        return postDelayed;
    }

    @Override // com.tencent.f.d.a
    public final boolean postDelayed(Runnable runnable, Object obj, long j2) {
        AppMethodBeat.i(183256);
        if (Build.VERSION.SDK_INT >= 28) {
            boolean postDelayed = this.proxyHandler.postDelayed(runnable, obj, j2);
            AppMethodBeat.o(183256);
            return postDelayed;
        }
        RuntimeException runtimeException = new RuntimeException("Call requires API level 28 (current min is 19): android.os.Handler#postDelayed");
        AppMethodBeat.o(183256);
        throw runtimeException;
    }

    @Override // com.tencent.f.d.a
    public final boolean postAtFrontOfQueue(Runnable runnable) {
        AppMethodBeat.i(183257);
        boolean postAtFrontOfQueue = this.proxyHandler.postAtFrontOfQueue(runnable);
        AppMethodBeat.o(183257);
        return postAtFrontOfQueue;
    }

    @Override // com.tencent.f.d.a
    public final void removeCallbacks(Runnable runnable) {
        AppMethodBeat.i(183258);
        this.proxyHandler.removeCallbacks(runnable);
        AppMethodBeat.o(183258);
    }

    @Override // com.tencent.f.d.a
    public final void removeCallbacks(Runnable runnable, Object obj) {
        AppMethodBeat.i(183259);
        this.proxyHandler.removeCallbacks(runnable, obj);
        AppMethodBeat.o(183259);
    }

    @Override // com.tencent.f.d.a
    public final boolean sendMessage(Message message) {
        AppMethodBeat.i(183260);
        boolean sendMessage = this.proxyHandler.sendMessage(message);
        AppMethodBeat.o(183260);
        return sendMessage;
    }

    @Override // com.tencent.f.d.a
    public final boolean sendEmptyMessage(int i2) {
        AppMethodBeat.i(183261);
        boolean sendEmptyMessage = this.proxyHandler.sendEmptyMessage(i2);
        AppMethodBeat.o(183261);
        return sendEmptyMessage;
    }

    @Override // com.tencent.f.d.a
    public final boolean sendEmptyMessageDelayed(int i2, long j2) {
        AppMethodBeat.i(183262);
        boolean sendEmptyMessageDelayed = this.proxyHandler.sendEmptyMessageDelayed(i2, j2);
        AppMethodBeat.o(183262);
        return sendEmptyMessageDelayed;
    }

    @Override // com.tencent.f.d.a
    public final boolean sendEmptyMessageAtTime(int i2, long j2) {
        AppMethodBeat.i(183263);
        boolean sendEmptyMessageAtTime = this.proxyHandler.sendEmptyMessageAtTime(i2, j2);
        AppMethodBeat.o(183263);
        return sendEmptyMessageAtTime;
    }

    @Override // com.tencent.f.d.a
    public final boolean sendMessageDelayed(Message message, long j2) {
        AppMethodBeat.i(183264);
        boolean sendMessageDelayed = this.proxyHandler.sendMessageDelayed(message, j2);
        AppMethodBeat.o(183264);
        return sendMessageDelayed;
    }

    @Override // com.tencent.f.d.a
    public final boolean sendMessageAtTime(Message message, long j2) {
        AppMethodBeat.i(183265);
        if (isQuit()) {
            AppMethodBeat.o(183265);
            return false;
        }
        boolean sendMessageAtTime = this.proxyHandler.sendMessageAtTime(message, j2);
        AppMethodBeat.o(183265);
        return sendMessageAtTime;
    }

    @Override // com.tencent.f.d.a
    public final boolean sendMessageAtFrontOfQueue(Message message) {
        AppMethodBeat.i(183266);
        boolean sendMessageAtFrontOfQueue = this.proxyHandler.sendMessageAtFrontOfQueue(message);
        AppMethodBeat.o(183266);
        return sendMessageAtFrontOfQueue;
    }

    @Override // com.tencent.f.d.a
    public final boolean executeOrSendMessage(Message message) {
        AppMethodBeat.i(183267);
        if (isQuit()) {
            AppMethodBeat.o(183267);
            return false;
        } else if (getLooper() == Looper.myLooper()) {
            this.proxyHandler.dispatchMessage(message);
            AppMethodBeat.o(183267);
            return true;
        } else {
            boolean sendMessage = sendMessage(message);
            AppMethodBeat.o(183267);
            return sendMessage;
        }
    }

    @Override // com.tencent.f.d.a
    public final void removeMessages(int i2) {
        AppMethodBeat.i(183268);
        this.proxyHandler.removeMessages(i2);
        AppMethodBeat.o(183268);
    }

    @Override // com.tencent.f.d.a
    public final void removeMessages(int i2, Object obj) {
        AppMethodBeat.i(183269);
        this.proxyHandler.removeMessages(i2, obj);
        AppMethodBeat.o(183269);
    }

    @Override // com.tencent.f.d.a
    public final void dispatchMessage(Message message) {
        AppMethodBeat.i(183270);
        this.proxyHandler.dispatchMessage(message);
        AppMethodBeat.o(183270);
    }

    @Override // com.tencent.f.d.a
    public final void removeCallbacksAndMessages(Object obj) {
        AppMethodBeat.i(183271);
        this.proxyHandler.removeCallbacksAndMessages(obj);
        AppMethodBeat.o(183271);
    }

    @Override // com.tencent.f.d.a
    public final boolean hasMessages(int i2) {
        AppMethodBeat.i(183272);
        boolean hasMessages = this.proxyHandler.hasMessages(i2);
        AppMethodBeat.o(183272);
        return hasMessages;
    }

    @Override // com.tencent.f.d.a
    public final boolean hasMessages(int i2, Object obj) {
        AppMethodBeat.i(183273);
        boolean hasMessages = this.proxyHandler.hasMessages(i2, obj);
        AppMethodBeat.o(183273);
        return hasMessages;
    }

    @Override // com.tencent.f.d.a
    public final Looper getLooper() {
        AppMethodBeat.i(183274);
        Looper looper = this.proxyHandler.getLooper();
        AppMethodBeat.o(183274);
        return looper;
    }

    @Override // com.tencent.f.d.a
    public final String getSerialTag() {
        return null;
    }

    @Override // com.tencent.f.d.a
    public final a getSerial() {
        return null;
    }

    @Override // com.tencent.f.d.a
    public final boolean quit() {
        AppMethodBeat.i(183275);
        if (this.isQuit.compareAndSet(false, true)) {
            removeCallbacksAndMessages(null);
            if (getLooper() != null) {
                d.RSS.w("WrapperHandler", "Do you want to quit this looper thread? You'd better get this Looper to quit.", new Object[0]);
            }
            AppMethodBeat.o(183275);
            return true;
        }
        AppMethodBeat.o(183275);
        return false;
    }

    @Override // com.tencent.f.d.a
    public final Handler getSelf() {
        return this.proxyHandler;
    }

    @Override // com.tencent.f.d.a
    public final void dump(Printer printer, String str) {
        AppMethodBeat.i(183276);
        this.proxyHandler.dump(printer, str);
        AppMethodBeat.o(183276);
    }

    @Override // com.tencent.f.d.a
    public final boolean isQuit() {
        AppMethodBeat.i(183277);
        boolean z = this.isQuit.get();
        AppMethodBeat.o(183277);
        return z;
    }

    public final String toString() {
        AppMethodBeat.i(183278);
        String handler = this.proxyHandler.toString();
        AppMethodBeat.o(183278);
        return handler;
    }
}
