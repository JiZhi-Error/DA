package com.tencent.mm.plugin.gallery.ui;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.memory.a.b;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MultiTouchImageView;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;

/* access modifiers changed from: package-private */
public final class e {
    private QueueWorkerThread iOL = new QueueWorkerThread(1, "album-image-gallery-lazy-loader");
    private int mScrollState = 0;
    private SparseArray<WeakReference<MultiTouchImageView>> xqf = new SparseArray<>();
    HashMap<String, Integer> xqg = new HashMap<>();
    private SparseArray<String> xqh = new SparseArray<>();
    SparseArray<Bitmap> xqi = new SparseArray<>();
    protected f<String, Bitmap> xqj = new b(5, new f.b<String, Bitmap>() {
        /* class com.tencent.mm.plugin.gallery.ui.e.AnonymousClass1 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // com.tencent.mm.b.f.b
        public final /* synthetic */ void c(String str, Bitmap bitmap, Bitmap bitmap2) {
            AppMethodBeat.i(111546);
            Bitmap bitmap3 = bitmap;
            if (bitmap3 != null && !bitmap3.isRecycled() && e.this.xqk.indexOfKey(bitmap3.hashCode()) < 0) {
                Log.i("ImageAdapter", "bitmap recycle %s", bitmap3.toString());
                bitmap3.recycle();
            }
            AppMethodBeat.o(111546);
        }
    }, getClass());
    protected SparseIntArray xqk = new SparseIntArray();
    private LinkedList<String> xql = new LinkedList<>();
    d xqm;
    boolean xqn = false;

    static /* synthetic */ void a(e eVar, int i2, Bitmap bitmap) {
        AppMethodBeat.i(111556);
        eVar.b(i2, bitmap);
        AppMethodBeat.o(111556);
    }

    public e(d dVar) {
        AppMethodBeat.i(111549);
        this.xqm = dVar;
        AppMethodBeat.o(111549);
    }

    public final void detach() {
        AppMethodBeat.i(111550);
        this.xqm = null;
        this.xqf.clear();
        this.xqi.clear();
        this.xqh.clear();
        this.xqg.clear();
        dSj();
        AppMethodBeat.o(111550);
    }

    private void dSj() {
        AppMethodBeat.i(111551);
        this.xqj.a(new f.a<String, Bitmap>() {
            /* class com.tencent.mm.plugin.gallery.ui.e.AnonymousClass2 */
        });
        AppMethodBeat.o(111551);
    }

    public final void onPageScrollStateChanged(int i2) {
        AppMethodBeat.i(111552);
        this.mScrollState = i2;
        if (dSk()) {
            int[] iArr = new int[this.xqi.size()];
            for (int i3 = 0; i3 < iArr.length; i3++) {
                iArr[i3] = this.xqi.keyAt(i3);
            }
            for (int i4 : iArr) {
                b(i4, this.xqi.get(i4));
            }
        }
        AppMethodBeat.o(111552);
    }

    /* access modifiers changed from: package-private */
    public final boolean dSk() {
        return this.mScrollState == 0;
    }

    private void NT(int i2) {
        AppMethodBeat.i(111553);
        if (this.xqh.get(i2) != null) {
            this.xqf.remove(i2);
            this.xqh.remove(i2);
            this.xqg.remove(this.xqh.get(i2));
            this.xqi.remove(i2);
        }
        AppMethodBeat.o(111553);
    }

    private void a(int i2, MultiTouchImageView multiTouchImageView, String str) {
        AppMethodBeat.i(257752);
        this.xqg.put(str, Integer.valueOf(i2));
        this.xqh.put(i2, str);
        this.xqf.put(i2, new WeakReference<>(multiTouchImageView));
        AppMethodBeat.o(257752);
    }

    private void b(int i2, Bitmap bitmap) {
        AppMethodBeat.i(111554);
        if (this.xqf.get(i2) == null) {
            AppMethodBeat.o(111554);
            return;
        }
        MultiTouchImageView multiTouchImageView = this.xqf.get(i2).get();
        String str = this.xqh.get(i2);
        if (!(bitmap == null || multiTouchImageView == null)) {
            int hashCode = bitmap.hashCode();
            int indexOfValue = this.xqk.indexOfValue(i2);
            if (indexOfValue >= 0) {
                this.xqk.removeAt(indexOfValue);
            }
            this.xqk.put(hashCode, i2);
        }
        this.xqm.a(multiTouchImageView, str, bitmap);
        NT(i2);
        AppMethodBeat.o(111554);
    }

    public final void a(MultiTouchImageView multiTouchImageView, String str) {
        AppMethodBeat.i(257753);
        if (this.xql.contains(str)) {
            AppMethodBeat.o(257753);
            return;
        }
        int hashCode = multiTouchImageView.hashCode();
        NT(hashCode);
        a(hashCode, multiTouchImageView, str);
        this.xql.add(str);
        YC();
        AppMethodBeat.o(257753);
    }

    /* access modifiers changed from: package-private */
    public final void YC() {
        AppMethodBeat.i(111555);
        if (this.xqn) {
            AppMethodBeat.o(111555);
        } else if (this.xql.size() == 0) {
            AppMethodBeat.o(111555);
        } else {
            final String removeLast = this.xql.removeLast();
            if (!this.xqg.containsKey(removeLast)) {
                AppMethodBeat.o(111555);
                return;
            }
            this.xqn = true;
            this.iOL.add(new QueueWorkerThread.ThreadObject() {
                /* class com.tencent.mm.plugin.gallery.ui.e.AnonymousClass3 */
                private Bitmap xqp = null;

                @Override // com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject
                public final boolean doInBackground() {
                    AppMethodBeat.i(111547);
                    if (e.this.xqm == null || TextUtils.isEmpty(removeLast)) {
                        AppMethodBeat.o(111547);
                        return false;
                    }
                    String str = removeLast;
                    long currentTicks = Util.currentTicks();
                    Bitmap aOp = r.aOp(str);
                    Log.v("MicroMsg.ImageAdapter", "test decode: %d filePath:%s", Long.valueOf(Util.ticksToNow(currentTicks)), str);
                    this.xqp = aOp;
                    AppMethodBeat.o(111547);
                    return true;
                }

                @Override // com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject
                public final boolean onPostExecute() {
                    AppMethodBeat.i(111548);
                    e.this.xqn = false;
                    if (e.this.xqg.containsKey(removeLast)) {
                        int intValue = e.this.xqg.get(removeLast).intValue();
                        if (!e.this.dSk()) {
                            e.this.xqi.put(intValue, this.xqp);
                        } else {
                            e.a(e.this, intValue, this.xqp);
                        }
                    }
                    e.this.xqj.x(removeLast, this.xqp);
                    this.xqp = null;
                    e.this.YC();
                    AppMethodBeat.o(111548);
                    return false;
                }
            });
            AppMethodBeat.o(111555);
        }
    }
}
