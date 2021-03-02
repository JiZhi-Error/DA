package com.tencent.mm.sticker.ui.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sticker.d;
import com.tencent.mm.sticker.e;
import com.tencent.mm.sticker.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010\u0018\u001a\u00020\u0019J\b\u0010\u001a\u001a\u00020\u0019H\u0014J\u0010\u0010\u001b\u001a\u00020\u00192\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u0006\u0010\u001c\u001a\u00020\u0019J\u0006\u0010\u001d\u001a\u00020\u0019R\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, hxF = {"Lcom/tencent/mm/sticker/ui/view/CaptureStickerHint;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "actionIndex", "actions", "Ljava/util/LinkedList;", "hintIcon", "Landroid/widget/ImageView;", "hintText", "Landroid/widget/TextView;", "stickerPack", "Lcom/tencent/mm/sticker/StickerPack;", "switchStickerHintRunnable", "Ljava/lang/Runnable;", "hideStickerHint", "", "onFinishInflate", "setStickerPack", "showStickerHint", "switchHint", "Companion", "plugin-sticker_release"})
public final class CaptureStickerHint extends LinearLayout {
    private static final SparseArray<int[]> NOG = new SparseArray<>();
    private static final SparseArray<int[]> NOH = new SparseArray<>();
    public static final a NOI = new a((byte) 0);
    private final ImageView NOD;
    private int NOE;
    private final Runnable NOF;
    private final String TAG;
    private LinkedList<Integer> mRG;
    private f rpM;
    private final TextView vuT;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CaptureStickerHint(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(194239);
        this.TAG = "MicroMsg.CaptureStickerHint";
        this.mRG = new LinkedList<>();
        this.NOF = new b(this);
        View.inflate(context, R.layout.byt, this);
        View findViewById = findViewById(R.id.i6e);
        p.g(findViewById, "findViewById(R.id.sticker_preview_hint_icon)");
        this.NOD = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.i6f);
        p.g(findViewById2, "findViewById(R.id.sticker_preview_hint_text)");
        this.vuT = (TextView) findViewById2;
        AppMethodBeat.o(194239);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CaptureStickerHint(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        AppMethodBeat.i(194240);
        AppMethodBeat.o(194240);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        final /* synthetic */ CaptureStickerHint NOJ;

        b(CaptureStickerHint captureStickerHint) {
            this.NOJ = captureStickerHint;
        }

        public final void run() {
            AppMethodBeat.i(194234);
            this.NOJ.gzv();
            AppMethodBeat.o(194234);
        }
    }

    /* access modifiers changed from: protected */
    public final void onFinishInflate() {
        AppMethodBeat.i(194235);
        super.onFinishInflate();
        setOrientation(1);
        setGravity(17);
        AppMethodBeat.o(194235);
    }

    public final void setStickerPack(f fVar) {
        HashMap<String, d> hashMap;
        Collection<d> values;
        HashMap<String, d> hashMap2;
        Collection<d> values2;
        HashMap<String, d> hashMap3;
        Collection<d> values3;
        AppMethodBeat.i(194236);
        if (!p.j(this.rpM, fVar)) {
            removeCallbacks(this.NOF);
            this.rpM = fVar;
            this.mRG.clear();
            if (fVar != null) {
                LinkedList<Integer> linkedList = this.mRG;
                LinkedList<d> linkedList2 = new LinkedList();
                e eVar = fVar.NNs;
                if (!(eVar == null || (hashMap3 = eVar.NMT) == null || (values3 = hashMap3.values()) == null)) {
                    linkedList2.addAll(values3);
                }
                e eVar2 = fVar.NNt;
                if (!(eVar2 == null || (hashMap2 = eVar2.NMT) == null || (values2 = hashMap2.values()) == null)) {
                    linkedList2.addAll(values2);
                }
                e eVar3 = fVar.NNu;
                if (!(eVar3 == null || (hashMap = eVar3.NMT) == null || (values = hashMap.values()) == null)) {
                    linkedList2.addAll(values);
                }
                ArrayList arrayList = new ArrayList();
                for (d dVar : linkedList2) {
                    Integer valueOf = dVar.NMN > 0 ? Integer.valueOf(dVar.NMN) : null;
                    if (valueOf != null) {
                        arrayList.add(valueOf);
                    }
                }
                linkedList.addAll(arrayList);
            }
            if (this.mRG.size() > 0) {
                this.NOE = 0;
                gzv();
                AppMethodBeat.o(194236);
                return;
            }
            gzw();
        }
        AppMethodBeat.o(194236);
    }

    public final void gzv() {
        AppMethodBeat.i(194237);
        if (this.NOE >= this.mRG.size()) {
            gzw();
            AppMethodBeat.o(194237);
            return;
        }
        setVisibility(0);
        SparseArray<int[]> sparseArray = NOH;
        Integer num = this.mRG.get(this.NOE);
        p.g(num, "actions[actionIndex]");
        int[] iArr = sparseArray.get(num.intValue());
        if (iArr == null) {
            this.vuT.setText((CharSequence) null);
        } else if (this.NOE == 0) {
            this.vuT.setText(iArr[0]);
        } else {
            this.vuT.setText(iArr[1]);
        }
        SparseArray<int[]> sparseArray2 = NOG;
        Integer num2 = this.mRG.get(this.NOE);
        p.g(num2, "actions[actionIndex]");
        int[] iArr2 = sparseArray2.get(num2.intValue());
        if (iArr2 != null) {
            com.tencent.mm.ui.f.a aVar = new com.tencent.mm.ui.f.a();
            for (int i2 : iArr2) {
                Drawable drawable = getContext().getDrawable(i2);
                if (drawable == null) {
                    p.hyc();
                }
                aVar.addFrame(drawable, 300);
            }
            this.NOD.setImageDrawable(aVar);
            aVar.start();
        } else {
            this.NOD.setImageDrawable(null);
        }
        this.NOE++;
        postDelayed(this.NOF, 2000);
        AppMethodBeat.o(194237);
    }

    private void gzw() {
        AppMethodBeat.i(194238);
        this.NOD.setImageDrawable(null);
        setVisibility(8);
        AppMethodBeat.o(194238);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\n"}, hxF = {"Lcom/tencent/mm/sticker/ui/view/CaptureStickerHint$Companion;", "", "()V", "tipsIconIds", "Landroid/util/SparseArray;", "", "getTipsIconIds", "()Landroid/util/SparseArray;", "tipsStrIds", "getTipsStrIds", "plugin-sticker_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(194241);
        SparseArray<int[]> sparseArray = NOG;
        e.a aVar = e.NNq;
        sparseArray.put(e.NMU, new int[]{R.drawable.btz, R.drawable.bu0});
        SparseArray<int[]> sparseArray2 = NOG;
        e.a aVar2 = e.NNq;
        sparseArray2.put(e.NMV, new int[]{R.drawable.btx, R.drawable.bty});
        SparseArray<int[]> sparseArray3 = NOG;
        e.a aVar3 = e.NNq;
        sparseArray3.put(e.NMW, new int[]{R.drawable.btv, R.drawable.btw});
        SparseArray<int[]> sparseArray4 = NOG;
        e.a aVar4 = e.NNq;
        sparseArray4.put(e.NMX, new int[]{R.drawable.bu1, R.drawable.bu2});
        SparseArray<int[]> sparseArray5 = NOG;
        e.a aVar5 = e.NNq;
        sparseArray5.put(e.NMY, new int[]{R.drawable.btn, R.drawable.bto});
        SparseArray<int[]> sparseArray6 = NOG;
        e.a aVar6 = e.NNq;
        sparseArray6.put(e.NMZ, new int[]{R.drawable.btp, R.drawable.btq});
        SparseArray<int[]> sparseArray7 = NOG;
        e.a aVar7 = e.NNq;
        sparseArray7.put(e.NNa, new int[]{R.drawable.btt, R.drawable.btu});
        SparseArray<int[]> sparseArray8 = NOG;
        e.a aVar8 = e.NNq;
        sparseArray8.put(e.NNb, new int[]{R.drawable.btr, R.drawable.bts});
        SparseArray<int[]> sparseArray9 = NOG;
        e.a aVar9 = e.NNq;
        sparseArray9.put(e.NNc, new int[]{R.drawable.bu9, R.drawable.bu_});
        SparseArray<int[]> sparseArray10 = NOG;
        e.a aVar10 = e.NNq;
        sparseArray10.put(e.NNd, new int[]{R.drawable.bui, R.drawable.buj});
        SparseArray<int[]> sparseArray11 = NOG;
        e.a aVar11 = e.NNq;
        sparseArray11.put(e.NNe, new int[]{R.drawable.bum, R.drawable.bun});
        SparseArray<int[]> sparseArray12 = NOG;
        e.a aVar12 = e.NNq;
        sparseArray12.put(e.NNf, new int[]{R.drawable.bu5, R.drawable.bu6});
        SparseArray<int[]> sparseArray13 = NOG;
        e.a aVar13 = e.NNq;
        sparseArray13.put(e.NNg, new int[]{R.drawable.bug, R.drawable.buh});
        SparseArray<int[]> sparseArray14 = NOG;
        e.a aVar14 = e.NNq;
        sparseArray14.put(e.NNh, new int[]{R.drawable.buc, R.drawable.bud});
        SparseArray<int[]> sparseArray15 = NOG;
        e.a aVar15 = e.NNq;
        sparseArray15.put(e.NNi, new int[]{R.drawable.bua, R.drawable.bub});
        SparseArray<int[]> sparseArray16 = NOG;
        e.a aVar16 = e.NNq;
        sparseArray16.put(e.NNj, new int[]{R.drawable.bue, R.drawable.buf});
        SparseArray<int[]> sparseArray17 = NOG;
        e.a aVar17 = e.NNq;
        sparseArray17.put(e.NNk, new int[]{R.drawable.buk, R.drawable.bul});
        SparseArray<int[]> sparseArray18 = NOG;
        e.a aVar18 = e.NNq;
        sparseArray18.put(e.NNl, new int[]{R.drawable.buo, R.drawable.bup});
        SparseArray<int[]> sparseArray19 = NOG;
        e.a aVar19 = e.NNq;
        sparseArray19.put(e.NNm, new int[]{R.drawable.bu3, R.drawable.bu4});
        SparseArray<int[]> sparseArray20 = NOG;
        e.a aVar20 = e.NNq;
        sparseArray20.put(e.NNo, new int[]{R.drawable.bu7, R.drawable.bu8});
        SparseArray<int[]> sparseArray21 = NOH;
        e.a aVar21 = e.NNq;
        sparseArray21.put(e.NMU, new int[]{R.string.hfa, R.string.hfb});
        SparseArray<int[]> sparseArray22 = NOH;
        e.a aVar22 = e.NNq;
        sparseArray22.put(e.NMV, new int[]{R.string.hf9, R.string.hf_});
        SparseArray<int[]> sparseArray23 = NOH;
        e.a aVar23 = e.NNq;
        sparseArray23.put(e.NMW, new int[]{R.string.hf7, R.string.hf8});
        SparseArray<int[]> sparseArray24 = NOH;
        e.a aVar24 = e.NNq;
        sparseArray24.put(e.NMX, new int[]{R.string.hfc, R.string.hfd});
        SparseArray<int[]> sparseArray25 = NOH;
        e.a aVar25 = e.NNq;
        sparseArray25.put(e.NMY, new int[]{R.string.hez, R.string.hf0});
        SparseArray<int[]> sparseArray26 = NOH;
        e.a aVar26 = e.NNq;
        sparseArray26.put(e.NMZ, new int[]{R.string.hf1, R.string.hf2});
        SparseArray<int[]> sparseArray27 = NOH;
        e.a aVar27 = e.NNq;
        sparseArray27.put(e.NNa, new int[]{R.string.hf5, R.string.hf6});
        SparseArray<int[]> sparseArray28 = NOH;
        e.a aVar28 = e.NNq;
        sparseArray28.put(e.NNb, new int[]{R.string.hf3, R.string.hf4});
        SparseArray<int[]> sparseArray29 = NOH;
        e.a aVar29 = e.NNq;
        sparseArray29.put(e.NNc, new int[]{R.string.hfk, R.string.hfl});
        SparseArray<int[]> sparseArray30 = NOH;
        e.a aVar30 = e.NNq;
        sparseArray30.put(e.NNd, new int[]{R.string.hfu, R.string.hfv});
        SparseArray<int[]> sparseArray31 = NOH;
        e.a aVar31 = e.NNq;
        sparseArray31.put(e.NNe, new int[]{R.string.hfy, R.string.hfz});
        SparseArray<int[]> sparseArray32 = NOH;
        e.a aVar32 = e.NNq;
        sparseArray32.put(e.NNf, new int[]{R.string.hfg, R.string.hfh});
        SparseArray<int[]> sparseArray33 = NOH;
        e.a aVar33 = e.NNq;
        sparseArray33.put(e.NNg, new int[]{R.string.hfs, R.string.hft});
        SparseArray<int[]> sparseArray34 = NOH;
        e.a aVar34 = e.NNq;
        sparseArray34.put(e.NNh, new int[]{R.string.hfo, R.string.hfp});
        SparseArray<int[]> sparseArray35 = NOH;
        e.a aVar35 = e.NNq;
        sparseArray35.put(e.NNi, new int[]{R.string.hfm, R.string.hfn});
        SparseArray<int[]> sparseArray36 = NOH;
        e.a aVar36 = e.NNq;
        sparseArray36.put(e.NNj, new int[]{R.string.hfq, R.string.hfr});
        SparseArray<int[]> sparseArray37 = NOH;
        e.a aVar37 = e.NNq;
        sparseArray37.put(e.NNk, new int[]{R.string.hfw, R.string.hfx});
        SparseArray<int[]> sparseArray38 = NOH;
        e.a aVar38 = e.NNq;
        sparseArray38.put(e.NNl, new int[]{R.string.hg0, R.string.hg1});
        SparseArray<int[]> sparseArray39 = NOH;
        e.a aVar39 = e.NNq;
        sparseArray39.put(e.NNm, new int[]{R.string.hfe, R.string.hff});
        SparseArray<int[]> sparseArray40 = NOH;
        e.a aVar40 = e.NNq;
        sparseArray40.put(e.NNo, new int[]{R.string.hfi, R.string.hfj});
        AppMethodBeat.o(194241);
    }
}
