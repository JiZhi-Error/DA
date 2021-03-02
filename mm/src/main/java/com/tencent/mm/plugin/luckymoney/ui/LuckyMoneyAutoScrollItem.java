package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public class LuckyMoneyAutoScrollItem extends ListView {
    public static SparseArray<Integer> zbA;
    private int ady;
    private Context mContext;
    private a zbu;
    private long zbv;
    private int zbw;
    private CountDownTimer zbx;
    private int zby;
    private b zbz;

    /* access modifiers changed from: package-private */
    public interface b {
        void efW();
    }

    static /* synthetic */ int a(LuckyMoneyAutoScrollItem luckyMoneyAutoScrollItem) {
        int i2 = luckyMoneyAutoScrollItem.ady + 1;
        luckyMoneyAutoScrollItem.ady = i2;
        return i2;
    }

    static {
        AppMethodBeat.i(65430);
        SparseArray<Integer> sparseArray = new SparseArray<>();
        zbA = sparseArray;
        sparseArray.put(0, Integer.valueOf((int) R.drawable.cia));
        zbA.put(1, Integer.valueOf((int) R.drawable.cib));
        zbA.put(2, Integer.valueOf((int) R.drawable.cic));
        zbA.put(3, Integer.valueOf((int) R.drawable.cid));
        zbA.put(4, Integer.valueOf((int) R.drawable.cie));
        zbA.put(5, Integer.valueOf((int) R.drawable.cif));
        zbA.put(6, Integer.valueOf((int) R.drawable.cig));
        zbA.put(7, Integer.valueOf((int) R.drawable.cih));
        zbA.put(8, Integer.valueOf((int) R.drawable.cii));
        zbA.put(9, Integer.valueOf((int) R.drawable.cij));
        AppMethodBeat.o(65430);
    }

    public LuckyMoneyAutoScrollItem(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        AppMethodBeat.i(65427);
        this.zbu = null;
        this.zbv = 900;
        this.zbw = 0;
        this.ady = 0;
        this.zbz = null;
        this.mContext = context;
        this.zbu = new a(this, (byte) 0);
        setAdapter((ListAdapter) this.zbu);
        this.zby = (int) ((this.mContext.getResources().getDisplayMetrics().density * 60.0f) + 0.5f);
        Log.i("MicroMsg.LuckyMoneyAutoScrollView", "hy: scroll height is: %d", Integer.valueOf(this.zby));
        AppMethodBeat.o(65427);
    }

    public LuckyMoneyAutoScrollItem(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public void setScrollTime(long j2) {
        this.zbv = j2;
    }

    public static void setResouceMap(SparseArray<Integer> sparseArray) {
        AppMethodBeat.i(65428);
        zbA.clear();
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            int keyAt = sparseArray.keyAt(i2);
            zbA.put(keyAt, sparseArray.get(keyAt));
        }
        AppMethodBeat.o(65428);
    }

    /* access modifiers changed from: package-private */
    public void setOnScrollEndListener(b bVar) {
        this.zbz = bVar;
    }

    public final void efV() {
        AppMethodBeat.i(65429);
        if (this.zbx != null) {
            this.zbx.cancel();
        }
        final long j2 = ((long) (this.zbw * 50)) + this.zbv;
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyAutoScrollItem.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(65424);
                LuckyMoneyAutoScrollItem.this.zbx = new CountDownTimer(j2) {
                    /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyAutoScrollItem.AnonymousClass1.AnonymousClass1 */

                    public final void onTick(long j2) {
                        AppMethodBeat.i(65422);
                        LuckyMoneyAutoScrollItem luckyMoneyAutoScrollItem = LuckyMoneyAutoScrollItem.this;
                        com.tencent.mm.hellhoundlib.b.a a2 = c.a(LuckyMoneyAutoScrollItem.a(LuckyMoneyAutoScrollItem.this), new com.tencent.mm.hellhoundlib.b.a());
                        com.tencent.mm.hellhoundlib.a.a.a(luckyMoneyAutoScrollItem, a2.axQ(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyAutoScrollItem$1$1", "onTick", "(J)V", "Undefined", "smoothScrollToPosition", "(I)V");
                        luckyMoneyAutoScrollItem.smoothScrollToPosition(((Integer) a2.pG(0)).intValue());
                        com.tencent.mm.hellhoundlib.a.a.a(luckyMoneyAutoScrollItem, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyAutoScrollItem$1$1", "onTick", "(J)V", "Undefined", "smoothScrollToPosition", "(I)V");
                        AppMethodBeat.o(65422);
                    }

                    public final void onFinish() {
                        AppMethodBeat.i(65423);
                        if (LuckyMoneyAutoScrollItem.this.zbz != null) {
                            LuckyMoneyAutoScrollItem.this.zbz.efW();
                        }
                        AppMethodBeat.o(65423);
                    }
                }.start();
                AppMethodBeat.o(65424);
            }
        });
        AppMethodBeat.o(65429);
    }

    public void setFinalNumber(int i2) {
        this.zbw = i2;
    }

    class a extends BaseAdapter {
        private a() {
        }

        /* synthetic */ a(LuckyMoneyAutoScrollItem luckyMoneyAutoScrollItem, byte b2) {
            this();
        }

        public final int getCount() {
            return 2147483646;
        }

        public final Object getItem(int i2) {
            AppMethodBeat.i(65425);
            Integer valueOf = Integer.valueOf(i2 % 10);
            AppMethodBeat.o(65425);
            return valueOf;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            C1467a aVar;
            AppMethodBeat.i(65426);
            if (view == null || view.getTag() == null) {
                view = LayoutInflater.from(LuckyMoneyAutoScrollItem.this.mContext).inflate(R.layout.b3e, (ViewGroup) null);
                C1467a aVar2 = new C1467a();
                aVar2.zbE = (ImageView) view.findViewById(R.id.ikf);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (C1467a) view.getTag();
            }
            aVar.zbE.setImageResource(LuckyMoneyAutoScrollItem.zbA.get(i2 % 10).intValue());
            AppMethodBeat.o(65426);
            return view;
        }

        /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyAutoScrollItem$a$a  reason: collision with other inner class name */
        class C1467a {
            ImageView zbE;

            C1467a() {
            }
        }
    }
}
