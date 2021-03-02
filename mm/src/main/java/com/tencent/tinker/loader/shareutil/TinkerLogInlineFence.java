package com.tencent.tinker.loader.shareutil;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.tinker.anno.Keep;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Keep
final class TinkerLogInlineFence extends Handler {
    private static final String TAG = "Tinker.TinkerLogInlineFence";
    private static final Handler mainThreadHandler = new Handler(Looper.getMainLooper());
    private static final List<Object[]> pendingLogs = Collections.synchronizedList(new ArrayList());

    TinkerLogInlineFence() {
    }

    public final void handleMessage(Message message) {
        handleMessage_$noinline$(message);
    }

    private void handleMessage_$noinline$(Message message) {
        try {
            dummyThrowExceptionMethod();
        } finally {
            handleMessageImpl(message);
        }
    }

    private void handleMessageImpl(Message message) {
        ShareTinkerLog.TinkerLogImp defaultImpl = ShareTinkerLog.getDefaultImpl();
        ShareTinkerLog.TinkerLogImp impl = ShareTinkerLog.getImpl();
        switch (message.what) {
            case 2:
                Object[] objArr = (Object[]) message.obj;
                if (impl != null) {
                    impl.v((String) objArr[2], (String) objArr[3], (Object[]) objArr[4]);
                }
                if (impl == null || impl == defaultImpl) {
                    pendingLogs.add(objArr);
                    return;
                }
                return;
            case 3:
                Object[] objArr2 = (Object[]) message.obj;
                if (impl != null) {
                    impl.d((String) objArr2[2], (String) objArr2[3], (Object[]) objArr2[4]);
                }
                if (impl == null || impl == defaultImpl) {
                    pendingLogs.add(objArr2);
                    return;
                }
                return;
            case 4:
                Object[] objArr3 = (Object[]) message.obj;
                if (impl != null) {
                    impl.i((String) objArr3[2], (String) objArr3[3], (Object[]) objArr3[4]);
                }
                if (impl == null || impl == defaultImpl) {
                    pendingLogs.add(objArr3);
                    return;
                }
                return;
            case 5:
                Object[] objArr4 = (Object[]) message.obj;
                if (impl != null) {
                    impl.w((String) objArr4[2], (String) objArr4[3], (Object[]) objArr4[4]);
                }
                if (impl == null || impl == defaultImpl) {
                    pendingLogs.add(objArr4);
                    return;
                }
                return;
            case 6:
                Object[] objArr5 = (Object[]) message.obj;
                if (impl != null) {
                    impl.e((String) objArr5[2], (String) objArr5[3], (Object[]) objArr5[4]);
                }
                if (impl == null || impl == defaultImpl) {
                    pendingLogs.add(objArr5);
                    return;
                }
                return;
            case 4001:
                Object[] objArr6 = (Object[]) message.obj;
                if (impl != null) {
                    impl.printErrStackTrace((String) objArr6[2], (Throwable) objArr6[3], (String) objArr6[4], (Object[]) objArr6[5]);
                }
                if (impl == null || impl == defaultImpl) {
                    pendingLogs.add(objArr6);
                    return;
                }
                return;
            case 4002:
                printPendingLogs(impl);
                return;
            default:
                impl.e(TAG, "[-] Bad msg id: " + message.what, new Object[0]);
                return;
        }
    }

    private static void printPendingLogs(final ShareTinkerLog.TinkerLogImp tinkerLogImp) {
        if (tinkerLogImp != null && !pendingLogs.isEmpty()) {
            new Thread(new Runnable() {
                /* class com.tencent.tinker.loader.shareutil.TinkerLogInlineFence.AnonymousClass1 */

                public final void run() {
                    final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.ENGLISH);
                    for (final Object[] objArr : TinkerLogInlineFence.pendingLogs) {
                        TinkerLogInlineFence.mainThreadHandler.post(new Runnable() {
                            /* class com.tencent.tinker.loader.shareutil.TinkerLogInlineFence.AnonymousClass1.AnonymousClass1 */

                            public void run() {
                                String str = "[PendingLog @ " + simpleDateFormat.format(new Date(((Long) objArr[1]).longValue())) + "] ";
                                switch (((Integer) objArr[0]).intValue()) {
                                    case 2:
                                        tinkerLogImp.v((String) objArr[2], str + ((String) objArr[3]), (Object[]) objArr[4]);
                                        return;
                                    case 3:
                                        tinkerLogImp.d((String) objArr[2], str + ((String) objArr[3]), (Object[]) objArr[4]);
                                        return;
                                    case 4:
                                        tinkerLogImp.i((String) objArr[2], str + ((String) objArr[3]), (Object[]) objArr[4]);
                                        return;
                                    case 5:
                                        tinkerLogImp.w((String) objArr[2], str + ((String) objArr[3]), (Object[]) objArr[4]);
                                        return;
                                    case 6:
                                        tinkerLogImp.e((String) objArr[2], str + ((String) objArr[3]), (Object[]) objArr[4]);
                                        return;
                                    case 4001:
                                        tinkerLogImp.printErrStackTrace((String) objArr[2], (Throwable) objArr[3], str + ((String) objArr[4]), (Object[]) objArr[5]);
                                        return;
                                    default:
                                        return;
                                }
                            }
                        });
                    }
                    TinkerLogInlineFence.pendingLogs.clear();
                }
            }, "tinker_log_printer").start();
        }
    }

    private static void dummyThrowExceptionMethod() {
        if (TinkerLogInlineFence.class.isPrimitive()) {
            throw new RuntimeException();
        }
    }
}
