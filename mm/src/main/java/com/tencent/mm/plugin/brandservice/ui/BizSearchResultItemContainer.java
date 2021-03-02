package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.b.l;
import com.tencent.mm.plugin.brandservice.b.m;
import com.tencent.mm.plugin.brandservice.ui.c;
import com.tencent.mm.protocal.protobuf.ru;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.LinkedList;
import java.util.List;

public class BizSearchResultItemContainer extends LinearLayout implements i {
    private int mScene = 0;
    private int poA;
    private int pob;
    private ListView pop;
    c poq;
    private TextView por;
    c pot;
    private a pou;
    m pov;
    private b pow;
    private long[] pox;
    int poy;
    private boolean poz;

    public interface b {
        void clW();

        void clX();
    }

    static /* synthetic */ void a(BizSearchResultItemContainer bizSearchResultItemContainer, String str, int i2, long j2) {
        AppMethodBeat.i(5652);
        bizSearchResultItemContainer.b(str, i2, j2);
        AppMethodBeat.o(5652);
    }

    public BizSearchResultItemContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(5640);
        View inflate = View.inflate(getContext(), R.layout.bp5, this);
        this.pot = new c((byte) 0);
        this.pou = new a((byte) 0);
        this.por = (TextView) inflate.findViewById(R.id.c2h);
        this.pop = (ListView) inflate.findViewById(R.id.h5k);
        AppMethodBeat.o(5640);
    }

    public void setAdapter(c cVar) {
        AppMethodBeat.i(5641);
        this.poq = cVar;
        if (this.poq != null) {
            this.poq.setScene(this.mScene);
            ListView listView = this.pop;
            a aVar = this.pou;
            View inflate = View.inflate(getContext(), R.layout.b27, null);
            aVar.poD = inflate.findViewById(R.id.epq);
            aVar.poE = inflate.findViewById(R.id.epf);
            aVar.poF = inflate.findViewById(R.id.ept);
            aVar.poD.setVisibility(8);
            aVar.poE.setVisibility(8);
            aVar.poF.setVisibility(8);
            listView.addFooterView(inflate, null, false);
            this.pop.setAdapter((ListAdapter) this.poq);
            this.pop.setOnScrollListener(new AbsListView.OnScrollListener() {
                /* class com.tencent.mm.plugin.brandservice.ui.BizSearchResultItemContainer.AnonymousClass1 */
                boolean poB = false;

                public final void onScrollStateChanged(AbsListView absListView, int i2) {
                    AppMethodBeat.i(5636);
                    if (i2 == 0 && this.poB && BizSearchResultItemContainer.a(BizSearchResultItemContainer.this)) {
                        BizSearchResultItemContainer.a(BizSearchResultItemContainer.this, BizSearchResultItemContainer.this.pot.dDv, BizSearchResultItemContainer.this.pot.offset, BizSearchResultItemContainer.this.pox[BizSearchResultItemContainer.this.pox.length - 1]);
                    }
                    AppMethodBeat.o(5636);
                }

                public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
                    if (i2 + i3 == i4) {
                        this.poB = true;
                    } else {
                        this.poB = false;
                    }
                }
            });
            this.pop.setOnItemClickListener(this.poq);
            if (this.pot.pnH == 0) {
                setBusinessTypes(1);
                AppMethodBeat.o(5641);
                return;
            }
        } else {
            this.pop.setAdapter((ListAdapter) this.poq);
        }
        AppMethodBeat.o(5641);
    }

    public c getAdapter() {
        return this.poq;
    }

    private void b(String str, int i2, long j2) {
        List<ru> list;
        AppMethodBeat.i(5642);
        this.pot.poG = true;
        g.azz().a(1071, this);
        ru ruVar = null;
        c.a BE = this.poq.BE(this.pox[this.pox.length - 1]);
        if (BE != null) {
            list = BE.poo;
        } else {
            list = null;
        }
        if (list == null || list.size() == 0) {
            Log.i("MicroMsg.BrandService.BizSearchResultItemContainer", "Get business content by type failed.(keyword : %s, offset : %s, businessType : %s)", str, Integer.valueOf(i2), Long.valueOf(j2));
        } else {
            ruVar = list.get(list.size() - 1);
        }
        String str2 = ruVar != null ? ruVar.KZj : "";
        Log.d("MicroMsg.BrandService.BizSearchResultItemContainer", "keyword(%s), offset(%d), businessType(%d), searchId(%s).", str, Integer.valueOf(i2), Long.valueOf(j2), str2);
        g.azz().a(new l(str, j2, i2, this.mScene, str2), 0);
        this.pou.updateStatus(1);
        AppMethodBeat.o(5642);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        int i4;
        int i5;
        LinkedList<ru> linkedList;
        int i6;
        ru ruVar;
        int i7 = 3;
        AppMethodBeat.i(5643);
        Log.i("MicroMsg.BrandService.BizSearchResultItemContainer", "errType (%d) , errCode (%d) , errMsg (errMsg)", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.pow != null) {
            this.pow.clX();
        }
        if (i2 == 0 && i3 == 0) {
            this.poz = false;
            if (qVar == null) {
                Log.e("MicroMsg.BrandService.BizSearchResultItemContainer", "scene is null.");
                AppMethodBeat.o(5643);
                return;
            }
            if (qVar.getType() == 1070) {
                Log.i("MicroMsg.BrandService.BizSearchResultItemContainer", "BizSearchHomePage.");
                g.azz().b(1070, this);
                m mVar = (m) qVar;
                if (mVar.pnI == null) {
                    linkedList = null;
                } else {
                    linkedList = mVar.pnI.MUM;
                }
                this.poq.m(this.pot.dDv, linkedList);
                c.a BE = this.poq.BE(this.pox[this.pox.length - 1]);
                if (BE == null || BE.pon) {
                    i6 = 0;
                } else {
                    i6 = BE.continueFlag;
                }
                if (i6 != 0) {
                    i7 = 2;
                }
                if (!(linkedList == null || linkedList.size() <= 0 || (ruVar = linkedList.get(linkedList.size() - 1)) == null)) {
                    this.pot.offset = ruVar.KZk + this.poy;
                }
                i4 = i7;
                i5 = i6;
            } else if (qVar.getType() == 1071) {
                g.azz().b(1071, this);
                Log.i("MicroMsg.BrandService.BizSearchResultItemContainer", "BizSearchDetailPage.");
                ru clR = ((l) qVar).clR();
                if (clR == null || clR.xKD == null) {
                    Log.e("MicroMsg.BrandService.BizSearchResultItemContainer", "BusinessContent or itemList is null.");
                }
                int i8 = clR == null ? 0 : clR.KZh;
                if (i8 == 0) {
                    i4 = 3;
                } else {
                    i4 = 2;
                }
                this.poq.a(clR, true);
                if (clR != null) {
                    Log.d("MicroMsg.BrandService.BizSearchResultItemContainer", "searchId : %s.", clR.KZj);
                    this.pot.offset = clR.KZk + this.poy;
                }
                i5 = i8;
            } else {
                Log.e("MicroMsg.BrandService.BizSearchResultItemContainer", "Error type(%d).", Integer.valueOf(qVar.getType()));
                AppMethodBeat.o(5643);
                return;
            }
            if (this.poq.isEmpty()) {
                new MMHandler(Looper.getMainLooper()).post(new Runnable() {
                    /* class com.tencent.mm.plugin.brandservice.ui.BizSearchResultItemContainer.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(5637);
                        BizSearchResultItemContainer.this.por.setVisibility(BizSearchResultItemContainer.this.poq.isEmpty() ? 0 : 8);
                        AppMethodBeat.o(5637);
                    }
                });
            } else {
                this.pot.isSearchMode = true;
            }
            this.pot.continueFlag = i5;
            this.pou.updateStatus(i4);
            this.pot.poG = false;
            Log.v("MicroMsg.BrandService.BizSearchResultItemContainer", "The next load data offset is (%d).", Integer.valueOf(this.pot.offset));
            AppMethodBeat.o(5643);
            return;
        }
        this.pot.poG = false;
        this.poz = true;
        Toast.makeText(getContext(), getContext().getString(R.string.dg3, Integer.valueOf(i2), Integer.valueOf(i3)), 0).show();
        AppMethodBeat.o(5643);
    }

    /* access modifiers changed from: package-private */
    public final void reset() {
        AppMethodBeat.i(5644);
        this.poq.clV();
        this.pou.updateStatus(0);
        this.pot.isSearchMode = false;
        this.pot.poG = false;
        this.pot.offset = 0;
        this.pot.dDv = null;
        this.pot.continueFlag = 1;
        AppMethodBeat.o(5644);
    }

    public void setBusinessTypes(long... jArr) {
        AppMethodBeat.i(5645);
        if (jArr != null && jArr.length > 0) {
            this.pox = jArr;
            this.pot.pnH = 0;
            for (int i2 = 0; i2 < jArr.length; i2++) {
                this.pot.pnH |= jArr[i2];
            }
            this.poq.b(jArr);
        }
        AppMethodBeat.o(5645);
    }

    public void setReporter(c.b bVar) {
        AppMethodBeat.i(5646);
        if (this.poq != null) {
            this.poq.setReporter(bVar);
        }
        AppMethodBeat.o(5646);
    }

    public final void cH(String str, int i2) {
        AppMethodBeat.i(5647);
        if (this.poq.isEmpty()) {
            this.por.setVisibility(8);
        }
        if (str == null) {
            AppMethodBeat.o(5647);
            return;
        }
        String trim = str.trim();
        if ("".equals(trim) || (trim.equals(this.pot.dDv) && !this.poz)) {
            AppMethodBeat.o(5647);
        } else if (this.pot.poG) {
            AppMethodBeat.o(5647);
        } else {
            reset();
            this.pot.poG = true;
            this.pot.dDv = trim;
            this.poy = i2;
            if (this.poA != 1) {
                g.azz().a(1070, this);
                this.pov = new m(this.pot.dDv, this.pot.pnH, this.mScene);
                g.azz().a(this.pov, 0);
            } else if (this.pox.length == 0) {
                Log.i("MicroMsg.BrandService.BizSearchResultItemContainer", "business type size is 0.");
                AppMethodBeat.o(5647);
                return;
            } else {
                b(trim, i2, this.pox[0]);
                this.pou.updateStatus(0);
            }
            if (this.pow != null) {
                this.pow.clW();
            }
            AppMethodBeat.o(5647);
        }
    }

    public b getIOnSearchStateChangedListener() {
        return this.pow;
    }

    public void setIOnSearchStateChangedListener(b bVar) {
        this.pow = bVar;
    }

    public void setScene(int i2) {
        AppMethodBeat.i(5648);
        this.mScene = i2;
        this.poq.setScene(this.mScene);
        AppMethodBeat.o(5648);
    }

    public void setAddContactScene(int i2) {
        AppMethodBeat.i(5649);
        this.pob = i2;
        this.poq.setAddContactScene(i2);
        AppMethodBeat.o(5649);
    }

    public final void setDisplayArgs$25decb5(boolean z) {
        AppMethodBeat.i(5650);
        this.poq.F(z, false);
        AppMethodBeat.o(5650);
    }

    public void setMode(int i2) {
        this.poA = i2;
    }

    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        AppMethodBeat.i(5651);
        super.setOnTouchListener(onTouchListener);
        this.pop.setOnTouchListener(onTouchListener);
        AppMethodBeat.o(5651);
    }

    /* access modifiers changed from: package-private */
    public static class c {
        public int continueFlag;
        public String dDv;
        public boolean isSearchMode;
        public int offset;
        public long pnH;
        public boolean poG;

        private c() {
            this.continueFlag = 1;
        }

        /* synthetic */ c(byte b2) {
            this();
        }
    }

    /* access modifiers changed from: package-private */
    public static class a {
        View poD;
        View poE;
        View poF;

        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        public final void updateStatus(int i2) {
            AppMethodBeat.i(5638);
            switch (i2) {
                case 1:
                    G(true, false);
                    AppMethodBeat.o(5638);
                    return;
                case 2:
                    G(false, true);
                    AppMethodBeat.o(5638);
                    return;
                case 3:
                    G(false, false);
                    AppMethodBeat.o(5638);
                    return;
                default:
                    G(false, false);
                    AppMethodBeat.o(5638);
                    return;
            }
        }

        private void G(boolean z, boolean z2) {
            int i2;
            int i3 = 0;
            AppMethodBeat.i(5639);
            View view = this.poD;
            if (z) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            view.setVisibility(i2);
            this.poE.setVisibility(8);
            View view2 = this.poF;
            if (!z2) {
                i3 = 8;
            }
            view2.setVisibility(i3);
            AppMethodBeat.o(5639);
        }
    }

    static /* synthetic */ boolean a(BizSearchResultItemContainer bizSearchResultItemContainer) {
        return bizSearchResultItemContainer.pot.isSearchMode && bizSearchResultItemContainer.pot.continueFlag != 0 && !bizSearchResultItemContainer.pot.poG;
    }
}
