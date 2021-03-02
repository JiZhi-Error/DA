package com.tencent.mm.sdk.platformtools;

import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MessageTask;
import junit.framework.Assert;

public class MMLogHandler extends Handler implements MessageTask.MessageTaskCallback {
    private static final String TAG = "MicroMsg.MMLogHandler";
    private MMHandler.Callback callback;
    public MessageTaskListener listener;
    private Looper looper = getLooper();
    private String toStringResult = null;

    public interface MessageTaskListener {
        void handleMessage(Message message);

        void onLog(Message message, Runnable runnable, Thread thread, long j2, long j3, float f2);

        void onTaskAdded(Runnable runnable, MessageTask messageTask);

        void onTaskRunEnd(Runnable runnable, MessageTask messageTask);
    }

    public MMLogHandler(MessageTaskListener messageTaskListener) {
        AppMethodBeat.i(230348);
        this.listener = messageTaskListener;
        AppMethodBeat.o(230348);
    }

    public MMLogHandler(Looper looper2, MessageTaskListener messageTaskListener) {
        super(looper2);
        AppMethodBeat.i(230349);
        this.listener = messageTaskListener;
        AppMethodBeat.o(230349);
    }

    public MMLogHandler(MMHandler.Callback callback2, MessageTaskListener messageTaskListener) {
        super(callback2);
        AppMethodBeat.i(230350);
        this.callback = callback2;
        this.listener = messageTaskListener;
        AppMethodBeat.o(230350);
    }

    public MMLogHandler(Looper looper2, MMHandler.Callback callback2, MessageTaskListener messageTaskListener) {
        super(looper2, callback2);
        AppMethodBeat.i(230351);
        this.callback = callback2;
        this.listener = messageTaskListener;
        AppMethodBeat.o(230351);
    }

    public boolean sendMessageAtTime(Message message, long j2) {
        AppMethodBeat.i(230352);
        Assert.assertTrue("msg is null", message != null);
        Runnable callback2 = message.getCallback();
        long uptimeMillis = j2 - SystemClock.uptimeMillis();
        if (callback2 == null) {
            boolean sendMessageAtTime = super.sendMessageAtTime(message, j2);
            AppMethodBeat.o(230352);
            return sendMessageAtTime;
        }
        MessageTask messageTask = new MessageTask(this.looper.getThread(), message.getTarget() == null ? this : message.getTarget(), callback2, message.obj, this);
        if (uptimeMillis > 0) {
            messageTask.delayTime = uptimeMillis;
        }
        Message obtain = Message.obtain(message.getTarget(), messageTask);
        obtain.what = message.what;
        obtain.arg1 = message.arg1;
        obtain.arg2 = message.arg2;
        obtain.obj = message.obj;
        obtain.replyTo = message.replyTo;
        obtain.setData(message.getData());
        message.recycle();
        if (getLooper() == null || getLooper().getThread().isAlive()) {
            if (this.listener != null) {
                this.listener.onTaskAdded(callback2, messageTask);
            }
            boolean sendMessageAtTime2 = super.sendMessageAtTime(obtain, j2);
            if (!sendMessageAtTime2 && this.listener != null) {
                this.listener.onTaskRunEnd(callback2, messageTask);
            }
            AppMethodBeat.o(230352);
            return sendMessageAtTime2;
        }
        Log.w(TAG, "sendMessageAtTime but thread[%d, %s] is dead so return false!", Long.valueOf(getLooper().getThread().getId()), getLooper().getThread().getName());
        AppMethodBeat.o(230352);
        return false;
    }

    public void dispatchMessage(Message message) {
        AppMethodBeat.i(230353);
        if (message.getCallback() == null && this.callback == null) {
            long currentTimeMillis = System.currentTimeMillis();
            long threadCpuTimeNanos = Debug.threadCpuTimeNanos();
            handleMessage(message);
            if (this.listener != null) {
                this.listener.onLog(message, null, this.looper.getThread(), System.currentTimeMillis() - currentTimeMillis, Debug.threadCpuTimeNanos() - threadCpuTimeNanos, -1.0f);
            }
            AppMethodBeat.o(230353);
            return;
        }
        super.dispatchMessage(message);
        AppMethodBeat.o(230353);
    }

    public void handleMessage(Message message) {
        AppMethodBeat.i(230354);
        if (this.listener != null) {
            this.listener.handleMessage(message);
        }
        AppMethodBeat.o(230354);
    }

    public String toString() {
        AppMethodBeat.i(230355);
        if (this.toStringResult == null) {
            this.toStringResult = "MMLogHandler{listener = " + this.listener + "}";
        }
        String str = this.toStringResult;
        AppMethodBeat.o(230355);
        return str;
    }

    @Override // com.tencent.mm.sdk.platformtools.MessageTask.MessageTaskCallback
    public void onRunEnd(Runnable runnable, MessageTask messageTask) {
        AppMethodBeat.i(230356);
        if (this.listener != null) {
            this.listener.onTaskRunEnd(runnable, messageTask);
        }
        AppMethodBeat.o(230356);
    }

    @Override // com.tencent.mm.sdk.platformtools.MessageTask.MessageTaskCallback
    public void onLog(Message message, Runnable runnable, Thread thread, long j2, long j3, float f2) {
        AppMethodBeat.i(230357);
        if (this.listener != null) {
            this.listener.onLog(message, runnable, thread, j2, j3, f2);
        }
        AppMethodBeat.o(230357);
    }
}
