package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.TbsReaderView;
import java.util.LinkedList;

public class TbsReaderPredownload {
    public static final int READER_SO_SUCCESS = 2;
    public static final int READER_WAIT_IN_QUEUE = 3;

    /* renamed from: b  reason: collision with root package name */
    static final String[] f1855b = {"docx", "pptx", "xlsx", "pdf", "epub", "txt"};

    /* renamed from: a  reason: collision with root package name */
    Handler f1856a = null;

    /* renamed from: c  reason: collision with root package name */
    LinkedList<String> f1857c = new LinkedList<>();

    /* renamed from: d  reason: collision with root package name */
    boolean f1858d = false;

    /* renamed from: e  reason: collision with root package name */
    ReaderWizard f1859e = null;

    /* renamed from: f  reason: collision with root package name */
    TbsReaderView.ReaderCallback f1860f = null;

    /* renamed from: g  reason: collision with root package name */
    Object f1861g = null;

    /* renamed from: h  reason: collision with root package name */
    Context f1862h = null;

    /* renamed from: i  reason: collision with root package name */
    ReaderPreDownloadCallback f1863i = null;

    /* renamed from: j  reason: collision with root package name */
    String f1864j = "";

    public interface ReaderPreDownloadCallback {
        public static final int NOTIFY_PLUGIN_FAILED = -1;
        public static final int NOTIFY_PLUGIN_SUCCESS = 0;

        void onEvent(String str, int i2, boolean z);
    }

    public TbsReaderPredownload(ReaderPreDownloadCallback readerPreDownloadCallback) {
        AppMethodBeat.i(55030);
        this.f1863i = readerPreDownloadCallback;
        for (String str : f1855b) {
            this.f1857c.add(str);
        }
        a();
        AppMethodBeat.o(55030);
    }

    public boolean init(Context context) {
        AppMethodBeat.i(55031);
        if (context == null) {
            AppMethodBeat.o(55031);
            return false;
        }
        this.f1862h = context.getApplicationContext();
        boolean a2 = TbsReaderView.a(context.getApplicationContext());
        this.f1860f = new TbsReaderView.ReaderCallback() {
            /* class com.tencent.smtt.sdk.TbsReaderPredownload.AnonymousClass1 */

            @Override // com.tencent.smtt.sdk.TbsReaderView.ReaderCallback
            public void onCallBackAction(Integer num, Object obj, Object obj2) {
                AppMethodBeat.i(54937);
                switch (num.intValue()) {
                    case 5012:
                        int intValue = ((Integer) obj).intValue();
                        if (5014 != intValue) {
                            if (5013 == intValue) {
                                TbsReaderPredownload.this.a(0);
                            } else if (intValue == 0) {
                                TbsReaderPredownload.this.a(0);
                            } else {
                                TbsReaderPredownload.this.a(-1);
                            }
                            TbsReaderPredownload.this.f1864j = "";
                            TbsReaderPredownload.this.a(3, 100);
                            break;
                        } else {
                            AppMethodBeat.o(54937);
                            return;
                        }
                }
                AppMethodBeat.o(54937);
            }
        };
        try {
            if (this.f1859e == null) {
                this.f1859e = new ReaderWizard(this.f1860f);
            }
            if (this.f1861g == null) {
                this.f1861g = this.f1859e.getTbsReader();
            }
            if (this.f1861g != null) {
                a2 = this.f1859e.initTbsReader(this.f1861g, context.getApplicationContext());
            }
        } catch (NullPointerException e2) {
            a2 = false;
        }
        AppMethodBeat.o(55031);
        return a2;
    }

    public void startAll() {
        AppMethodBeat.i(55032);
        this.f1858d = false;
        if (!c(3) && !false) {
            a(3, 100);
        }
        AppMethodBeat.o(55032);
    }

    public void start(String str) {
        AppMethodBeat.i(55033);
        this.f1858d = false;
        b(3);
        this.f1857c.add(str);
        a(3, 100);
        AppMethodBeat.o(55033);
    }

    public void pause() {
        this.f1858d = true;
    }

    public void shutdown() {
        AppMethodBeat.i(55034);
        this.f1863i = null;
        this.f1858d = false;
        this.f1857c.clear();
        b();
        if (this.f1859e != null) {
            this.f1859e.destroy(this.f1861g);
            this.f1861g = null;
        }
        this.f1862h = null;
        AppMethodBeat.o(55034);
    }

    private void b() {
        AppMethodBeat.i(55035);
        b(3);
        AppMethodBeat.o(55035);
    }

    /* access modifiers changed from: package-private */
    public boolean a(String str) {
        AppMethodBeat.i(55036);
        if (this.f1861g == null || this.f1859e == null) {
            AppMethodBeat.o(55036);
            return false;
        } else if (!ReaderWizard.isSupportExt(str)) {
            AppMethodBeat.o(55036);
            return false;
        } else {
            boolean checkPlugin = this.f1859e.checkPlugin(this.f1861g, this.f1862h, str, true);
            AppMethodBeat.o(55036);
            return checkPlugin;
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i2) {
        AppMethodBeat.i(55037);
        if (this.f1863i != null) {
            this.f1863i.onEvent(this.f1864j, i2, this.f1857c.isEmpty());
        }
        AppMethodBeat.o(55037);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        AppMethodBeat.i(55038);
        this.f1856a = new Handler(Looper.getMainLooper()) {
            /* class com.tencent.smtt.sdk.TbsReaderPredownload.AnonymousClass2 */

            public void handleMessage(Message message) {
                AppMethodBeat.i(54939);
                switch (message.what) {
                    case 3:
                        if (!TbsReaderPredownload.this.f1857c.isEmpty() && !TbsReaderPredownload.this.f1858d) {
                            String removeFirst = TbsReaderPredownload.this.f1857c.removeFirst();
                            TbsReaderPredownload.this.f1864j = removeFirst;
                            if (!TbsReaderPredownload.this.a(removeFirst)) {
                                TbsReaderPredownload.this.a(-1);
                                break;
                            }
                        }
                        break;
                }
                AppMethodBeat.o(54939);
            }
        };
        AppMethodBeat.o(55038);
    }

    /* access modifiers changed from: package-private */
    public void b(int i2) {
        AppMethodBeat.i(55039);
        this.f1856a.removeMessages(i2);
        AppMethodBeat.o(55039);
    }

    /* access modifiers changed from: package-private */
    public boolean c(int i2) {
        AppMethodBeat.i(55040);
        boolean hasMessages = this.f1856a.hasMessages(i2);
        AppMethodBeat.o(55040);
        return hasMessages;
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, int i3) {
        AppMethodBeat.i(55041);
        this.f1856a.sendMessageDelayed(this.f1856a.obtainMessage(i2), (long) i3);
        AppMethodBeat.o(55041);
    }
}
