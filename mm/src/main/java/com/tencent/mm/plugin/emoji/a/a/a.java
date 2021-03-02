package com.tencent.mm.plugin.emoji.a.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.plugin.emoji.model.g;
import com.tencent.mm.plugin.emoji.model.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;

public abstract class a extends BaseAdapter {
    private final String TAG = "MicroMsg.BaseEmojiListAdapter";
    private final String gLh = "lock";
    protected Context mContext;
    private HashMap<String, com.tencent.mm.plugin.emoji.a.a> qXJ;
    public AbsListView qXY;
    public c qXZ;
    public j.a qYa;
    protected volatile boolean qYb = false;
    private int qYc = 0;
    private int qYd = 0;

    public abstract void FK(int i2);

    public abstract void FL(int i2);

    public abstract void FM(int i2);

    public abstract View b(int i2, View view, ViewGroup viewGroup);

    public abstract int cFk();

    public abstract int cFl();

    public abstract int cFm();

    /* access modifiers changed from: protected */
    public abstract com.tencent.mm.plugin.emoji.a.a d(Context context, View view);

    public a(Context context) {
        this.mContext = context;
        if (this.mContext != null) {
            this.qXJ = new HashMap<>();
        }
    }

    public final void a(c cVar) {
        if (cVar != null && this.qXZ != cVar) {
            this.qXZ = cVar.cFp();
            notifyDataSetChanged();
        }
    }

    /* access modifiers changed from: protected */
    public void cFj() {
        if (this.qXJ != null) {
            this.qXJ.clear();
        }
        super.notifyDataSetChanged();
        this.qYb = true;
    }

    public void notifyDataSetChanged() {
        this.qYb = false;
        if (this.qXZ != null) {
            this.qXZ.notifyDataSetChanged();
            int i2 = this.qYc;
            this.qYc = i2 + 1;
            Log.d("MicroMsg.BaseEmojiListAdapter", "xxx data Notify: %d", Integer.valueOf(i2));
        }
        int i3 = this.qYd;
        this.qYd = i3 + 1;
        Log.v("MicroMsg.BaseEmojiListAdapter", "xxx ui Notify: %d", Integer.valueOf(i3));
        cFj();
    }

    public final void b(final g gVar) {
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.emoji.a.a.a.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(108349);
                if (gVar == null) {
                    AppMethodBeat.o(108349);
                    return;
                }
                a.this.qXZ = a.this.a(gVar);
                a.this.notifyDataSetChanged();
                AppMethodBeat.o(108349);
            }
        });
    }

    /* access modifiers changed from: protected */
    public c a(g gVar) {
        return new c(gVar);
    }

    public int getCount() {
        if (this.qXZ == null) {
            return 0;
        }
        return this.qXZ.size();
    }

    /* renamed from: FN */
    public f getItem(int i2) {
        if (this.qXZ == null) {
            return null;
        }
        return this.qXZ.FS(i2);
    }

    public long getItemId(int i2) {
        return (long) i2;
    }

    public View getView(int i2, View view, ViewGroup viewGroup) {
        com.tencent.mm.plugin.emoji.a.a aVar = null;
        if (view != null) {
            aVar = (com.tencent.mm.plugin.emoji.a.a) view.getTag();
        }
        f FN = getItem(i2);
        if (aVar == null) {
            aVar = d(this.mContext, view);
            view = aVar.getRoot();
            this.qXJ.put(a(FN), aVar);
        } else if (!Util.isNullOrNil(a(FN))) {
            if (this.qXJ.containsValue(aVar)) {
                this.qXJ.remove(aVar.getProductId());
            }
            this.qXJ.put(a(FN), aVar);
        }
        aVar.mPosition = i2;
        aVar.qWK = FN;
        View b2 = b(i2, view, viewGroup);
        aVar.cFh();
        return b2;
    }

    public static String a(f fVar) {
        if (fVar == null) {
            return null;
        }
        if (fVar.qYk == f.a.cellset) {
            return fVar.qYm.ID + "_cell";
        }
        return fVar.qYl.ProductID;
    }

    public void clear() {
        if (this.qXJ != null) {
            this.qXJ.clear();
            this.qXJ = null;
        }
        if (this.qXZ != null) {
            this.qXZ.clear();
            this.qXZ = null;
        }
        this.qYb = false;
    }

    public void dc(String str, int i2) {
        if (this.qXJ != null && this.qXZ != null && str != null) {
            f amb = this.qXZ.amb(str);
            if (amb != null) {
                a(amb, str, i2);
            }
            if (!(amb == null || this.qXZ == null || amb.mStatus != -1)) {
                Log.i("MicroMsg.BaseEmojiListAdapter", "force refresh status");
                amb.a(this.qXZ.qYi, this.qXZ.amf(str), this.qXZ.amd(str));
            }
            com.tencent.mm.plugin.emoji.a.a ama = ama(str);
            if (ama != null) {
                String productId = ama.getProductId() == null ? null : ama.getProductId();
                if (productId != null && productId.equals(str)) {
                    ama.cFh();
                }
            }
        }
    }

    public final com.tencent.mm.plugin.emoji.a.a ama(String str) {
        if (this.qXJ == null) {
            return null;
        }
        return this.qXJ.get(str);
    }

    public final void dd(String str, int i2) {
        if (this.qXJ != null && this.qXZ != null && str != null) {
            f amb = this.qXZ.amb(str);
            if (amb != null) {
                if (i2 >= 0 && i2 < 100) {
                    a(amb, str, 6);
                    amb.HH = i2;
                }
                if (i2 >= 100) {
                    a(amb, str, 7);
                }
            }
            com.tencent.mm.plugin.emoji.a.a ama = ama(str);
            if (ama != null) {
                String productId = ama.getProductId() == null ? null : ama.getProductId();
                if (productId != null && productId.equals(str)) {
                    ama.cFh();
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void a(f fVar, String str, int i2) {
        if (fVar != null && str != null) {
            fVar.setStatus(i2);
            this.qXZ.de(str, i2);
        }
    }

    public final void refreshView() {
        if (this.qYb) {
            super.notifyDataSetChanged();
        }
    }
}
