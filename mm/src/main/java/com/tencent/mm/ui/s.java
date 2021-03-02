package com.tencent.mm.ui;

import android.content.Context;
import android.database.Cursor;
import android.os.Looper;
import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.sdk.storage.MStorageEx;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;

public abstract class s<T> extends BaseAdapter implements MStorage.IOnStorageChange, MStorageEx.IOnStorageChange {
    protected T OFE;
    private Cursor OFG = null;
    protected Map<Integer, T> OFH = null;
    protected a OFI;
    private int OFJ = 0;
    private int OFK = 0;
    private int OFL = 0;
    private Runnable OFM = new Runnable() {
        /* class com.tencent.mm.ui.s.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(141316);
            if (s.this.OFJ != 0) {
                Log.v("MicroMsg.MListAdapter", "ashutest:: onResetCursorJobRun, current AbsListViewScrollType %d, post resetCursorJob, retryTimes %d", Integer.valueOf(s.this.OFJ), Integer.valueOf(s.b(s.this)));
                s.this.wMu.removeCallbacks(s.this.OFM);
                if (20 > s.this.OFL) {
                    s.this.wMu.postDelayed(s.this.OFM, 100);
                    AppMethodBeat.o(141316);
                    return;
                }
                Log.w("MicroMsg.MListAdapter", "ashutest:: onResetCursorJobRun, current AbsListViewScrollType %d, do resetCursorJob, retryTimes %d", Integer.valueOf(s.this.OFJ), Integer.valueOf(s.this.OFL));
            }
            Log.d("MicroMsg.MListAdapter", "ashutest:: do resetCursorJob");
            s.this.OFL = 0;
            s.this.gIK();
            AppMethodBeat.o(141316);
        }
    };
    public Context context;
    protected int count;
    private MMHandler wMu = new MMHandler(Looper.getMainLooper());

    public interface a {
        void bnE();
    }

    public abstract T a(T t, Cursor cursor);

    public abstract void anp();

    /* access modifiers changed from: protected */
    public abstract void anq();

    static /* synthetic */ int b(s sVar) {
        int i2 = sVar.OFL + 1;
        sVar.OFL = i2;
        return i2;
    }

    public s(Context context2, T t) {
        this.OFE = t;
        this.context = context2;
        this.count = -1;
    }

    /* access modifiers changed from: protected */
    public Cursor getCursor() {
        if (this.OFG == null || this.OFG.isClosed()) {
            anq();
            Assert.assertNotNull(this.OFG);
        }
        return this.OFG;
    }

    public final void setCursor(Cursor cursor) {
        this.OFG = cursor;
        this.count = -1;
    }

    public void Bh(boolean z) {
        if (!z) {
            if (this.OFH != null) {
                this.OFH.clear();
                this.OFH = null;
            }
        } else if (this.OFH == null) {
            this.OFH = new HashMap();
        }
    }

    public final void a(a aVar) {
        this.OFI = aVar;
    }

    public final void gGV() {
        this.OFI = null;
    }

    public void ebf() {
        if (this.OFH != null) {
            this.OFH.clear();
        }
        if (this.OFG != null) {
            this.OFG.close();
        }
        this.count = -1;
    }

    public int getCount() {
        if (this.count < 0) {
            this.count = getCursor().getCount();
        }
        return this.count + dWu();
    }

    public final int getRealCount() {
        if (this.count < 0) {
            this.count = getCursor().getCount();
        }
        return this.count;
    }

    public long getItemId(int i2) {
        return 0;
    }

    @Override // com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange
    public void onNotifyChange(int i2, MStorageEx mStorageEx, Object obj) {
        if (obj == null || !(obj instanceof String)) {
            Log.d("MicroMsg.MListAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i2), mStorageEx, obj);
            return;
        }
        onNotifyChange((String) obj, null);
    }

    @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
    public void onNotifyChange(String str, MStorageEventData mStorageEventData) {
        gIK();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void gIK() {
        Log.v("MicroMsg.MListAdapter", "ashutest:: on UI, directly call resetCursor Job");
        ebf();
        anp();
        if (this.OFI != null) {
            this.OFI.bnE();
        }
    }

    public T getItem(int i2) {
        T t;
        if (Ox(i2)) {
            return dWw();
        }
        if (this.OFH != null && (t = this.OFH.get(Integer.valueOf(i2))) != null) {
            return t;
        }
        if (i2 < 0 || !getCursor().moveToPosition(i2)) {
            return null;
        }
        if (this.OFH == null) {
            return a(this.OFE, getCursor());
        }
        T a2 = a(null, getCursor());
        this.OFH.put(Integer.valueOf(i2), a2);
        return a2;
    }

    public boolean Ox(int i2) {
        return i2 >= this.count && i2 < this.count + dWu();
    }

    /* access modifiers changed from: protected */
    public int dWu() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public T dWw() {
        return this.OFE;
    }
}
