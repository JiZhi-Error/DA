package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.memory.a.b;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import java.util.LinkedList;

public abstract class a<T> extends BaseAdapter {
    private static int xOd = 500;
    protected Context mContext;
    protected LinkedList<T> xHv;
    private AbstractC1407a xOa;
    protected boolean xOb = false;
    private f<String, Bitmap> xOc;
    private MTimerHandler xOe = new MTimerHandler(new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.game.ui.a.AnonymousClass2 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(41856);
            a.this.notifyDataSetChanged();
            AppMethodBeat.o(41856);
            return false;
        }
    }, false);
    private final MStorage.IOnStorageChange xOf = new MStorage.IOnStorageChange() {
        /* class com.tencent.mm.plugin.game.ui.a.AnonymousClass3 */

        @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
        public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
            AppMethodBeat.i(41857);
            a.this.xOe.stopTimer();
            a.this.xOe.startTimer((long) a.xOd);
            AppMethodBeat.o(41857);
        }
    };

    /* renamed from: com.tencent.mm.plugin.game.ui.a$a  reason: collision with other inner class name */
    public interface AbstractC1407a {
    }

    public a(Context context) {
        this.mContext = context;
        this.xHv = new LinkedList<>();
        this.xOc = new b(20, getClass());
        com.tencent.mm.plugin.r.a.eAS().add(this.xOf);
    }

    public void aU(LinkedList<T> linkedList) {
        if (linkedList != null) {
            this.xHv.addAll(linkedList);
            if (this.xOa != null) {
                this.xHv.size();
            }
            super.notifyDataSetChanged();
        } else if (this.xOa != null) {
            this.xHv.size();
        }
    }

    public void aV(LinkedList<T> linkedList) {
        if (linkedList != null) {
            this.xHv = linkedList;
            if (this.xOa != null) {
                this.xHv.size();
            }
            super.notifyDataSetChanged();
        } else if (this.xOa != null) {
            this.xHv.size();
        }
    }

    public void clear() {
        if (this.xHv != null) {
            this.xHv.clear();
        }
        if (this.xOc != null) {
            this.xOc.a(new f.a<String, Bitmap>() {
                /* class com.tencent.mm.plugin.game.ui.a.AnonymousClass1 */
            });
        }
        this.xOc = null;
        com.tencent.mm.plugin.r.a.eAS().remove(this.xOf);
    }

    /* access modifiers changed from: protected */
    public final Bitmap aAz(String str) {
        Bitmap bitmap;
        if (Util.isNullOrNil(str)) {
            return null;
        }
        if (this.xOc.check(str) && (bitmap = this.xOc.get(str)) != null && !bitmap.isRecycled()) {
            return bitmap;
        }
        Bitmap c2 = h.c(str, 1, com.tencent.mm.cb.a.getDensity(this.mContext));
        if (c2 == null || c2.isRecycled()) {
            return c2;
        }
        this.xOc.x(str, c2);
        return c2;
    }

    public int getCount() {
        return this.xHv.size();
    }

    public Object getItem(int i2) {
        return this.xHv.get(i2);
    }

    public long getItemId(int i2) {
        return (long) i2;
    }
}
