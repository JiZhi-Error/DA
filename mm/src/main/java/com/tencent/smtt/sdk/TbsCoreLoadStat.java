package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.utils.TbsLog;
import java.util.Arrays;

public class TbsCoreLoadStat {

    /* renamed from: d  reason: collision with root package name */
    private static TbsCoreLoadStat f1775d = null;
    public static volatile int mLoadErrorCode = -1;

    /* renamed from: a  reason: collision with root package name */
    private TbsSequenceQueue f1776a = null;

    /* renamed from: b  reason: collision with root package name */
    private boolean f1777b = false;

    /* renamed from: c  reason: collision with root package name */
    private final int f1778c = 3;

    private TbsCoreLoadStat() {
    }

    public static TbsCoreLoadStat getInstance() {
        AppMethodBeat.i(55023);
        if (f1775d == null) {
            f1775d = new TbsCoreLoadStat();
        }
        TbsCoreLoadStat tbsCoreLoadStat = f1775d;
        AppMethodBeat.o(55023);
        return tbsCoreLoadStat;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        AppMethodBeat.i(55024);
        TbsLog.d("TbsCoreLoadStat", "TbsCoreLoadStat--clearErrorCodeQueue");
        if (this.f1776a != null) {
            this.f1776a.clear();
        }
        this.f1777b = false;
        AppMethodBeat.o(55024);
    }

    public void setLoadErrorCode(Context context, int i2) {
        AppMethodBeat.i(55025);
        setLoadErrorCode(context, i2, null);
        TbsLog.e(TbsListener.tag_load_error, String.valueOf(i2));
        AppMethodBeat.o(55025);
    }

    public synchronized void setLoadErrorCode(Context context, int i2, Throwable th) {
        AppMethodBeat.i(55026);
        if (mLoadErrorCode == -1) {
            mLoadErrorCode = i2;
            TbsLog.d("TbsCoreLoadStat", "TbsCoreLoadStat--setLoadErrorCode errorCode=".concat(String.valueOf(i2)));
            TbsLog.d("TbsCoreLoadStat", "TbsCoreLoadStat--setLoadErrorCode errorDetail=".concat(String.valueOf(th)));
            TbsLog.addLog(TbsLog.TBSLOG_CODE_SDK_LOAD_ERROR, "code=%d,desc=%s", Integer.valueOf(i2), String.valueOf(th));
            if (th != null) {
                TbsLogReport.getInstance(context).setLoadErrorCode(i2, th);
                AppMethodBeat.o(55026);
            } else {
                TbsLog.e("TbsCoreLoadStat", "setLoadErrorCode :: error is null with errorCode: " + i2 + "; Check & correct it!");
                AppMethodBeat.o(55026);
            }
        } else {
            TbsLog.w("TbsCoreLoadStat", "setLoadErrorCode :: error(" + mLoadErrorCode + ") was already reported; " + i2 + " is duplicated. Try to remove it!");
            AppMethodBeat.o(55026);
        }
    }

    public class TbsSequenceQueue {

        /* renamed from: b  reason: collision with root package name */
        private int f1780b;

        /* renamed from: c  reason: collision with root package name */
        private int f1781c;

        /* renamed from: d  reason: collision with root package name */
        private int[] f1782d;

        /* renamed from: e  reason: collision with root package name */
        private int f1783e;

        /* renamed from: f  reason: collision with root package name */
        private int f1784f;

        public TbsSequenceQueue() {
            AppMethodBeat.i(54378);
            this.f1780b = 10;
            this.f1783e = 0;
            this.f1784f = 0;
            this.f1781c = this.f1780b;
            this.f1782d = new int[this.f1781c];
            AppMethodBeat.o(54378);
        }

        public TbsSequenceQueue(int i2, int i3) {
            AppMethodBeat.i(54379);
            this.f1780b = 10;
            this.f1783e = 0;
            this.f1784f = 0;
            this.f1781c = i3;
            this.f1782d = new int[this.f1781c];
            this.f1782d[0] = i2;
            this.f1784f++;
            AppMethodBeat.o(54379);
        }

        public int length() {
            return this.f1784f - this.f1783e;
        }

        public void add(int i2) {
            AppMethodBeat.i(54380);
            if (this.f1784f > this.f1781c - 1) {
                IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException("sequeue is full");
                AppMethodBeat.o(54380);
                throw indexOutOfBoundsException;
            }
            int[] iArr = this.f1782d;
            int i3 = this.f1784f;
            this.f1784f = i3 + 1;
            iArr[i3] = i2;
            AppMethodBeat.o(54380);
        }

        public int remove() {
            AppMethodBeat.i(54381);
            if (empty()) {
                IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException("sequeue is null");
                AppMethodBeat.o(54381);
                throw indexOutOfBoundsException;
            }
            int i2 = this.f1782d[this.f1783e];
            int[] iArr = this.f1782d;
            int i3 = this.f1783e;
            this.f1783e = i3 + 1;
            iArr[i3] = 0;
            AppMethodBeat.o(54381);
            return i2;
        }

        public int element() {
            AppMethodBeat.i(54382);
            if (empty()) {
                IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException("sequeue is null");
                AppMethodBeat.o(54382);
                throw indexOutOfBoundsException;
            }
            int i2 = this.f1782d[this.f1783e];
            AppMethodBeat.o(54382);
            return i2;
        }

        public boolean empty() {
            return this.f1784f == this.f1783e;
        }

        public void clear() {
            AppMethodBeat.i(54383);
            Arrays.fill(this.f1782d, 0);
            this.f1783e = 0;
            this.f1784f = 0;
            AppMethodBeat.o(54383);
        }

        public String toString() {
            AppMethodBeat.i(54384);
            if (empty()) {
                AppMethodBeat.o(54384);
                return "";
            }
            StringBuilder sb = new StringBuilder("[");
            for (int i2 = this.f1783e; i2 < this.f1784f; i2++) {
                sb.append(String.valueOf(this.f1782d[i2]) + ",");
            }
            int length = sb.length();
            String sb2 = sb.delete(length - 1, length).append("]").toString();
            AppMethodBeat.o(54384);
            return sb2;
        }
    }
}
