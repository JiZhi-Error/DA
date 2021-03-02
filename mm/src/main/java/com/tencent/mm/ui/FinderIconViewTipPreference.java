package com.tencent.mm.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.plugin.finder.utils.c;
import com.tencent.mm.plugin.newtips.NormalIconNewTipPreference;
import com.tencent.mm.protocal.protobuf.ehv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.LinkedList;
import kotlin.g.a.a;

public class FinderIconViewTipPreference extends NormalIconNewTipPreference {
    ViewGroup OBA;
    View OBB;
    View OBC;
    View OBD;
    View OBE;
    ImageView OBF;
    ImageView OBG;
    ImageView OBH;
    ImageView OBI;
    ImageView OBJ;
    ImageView OBK;
    ImageView OBL;
    ArrayList<View> OBM;
    ArrayList<ImageView> OBN;
    private RelativeLayout OBO;
    private WeImageView OBP;
    private LinearLayout OBQ;
    private RelativeLayout OBR;
    private LinearLayout.LayoutParams OBS;
    private LinearLayout.LayoutParams OBT;
    private LinearLayout.LayoutParams OBU;
    private LinearLayout.LayoutParams OBV;
    Context mContext;
    TextView qMD;
    TextView qME;

    public FinderIconViewTipPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FinderIconViewTipPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(232525);
        this.mContext = context;
        this.OYo = true;
        setLayoutResource(R.layout.agx);
        AppMethodBeat.o(232525);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference, com.tencent.mm.ui.base.preference.IconPreference, com.tencent.mm.ui.base.preference.NormalIconPreference, com.tencent.mm.plugin.newtips.NormalIconNewTipPreference
    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(232526);
        View onCreateView = super.onCreateView(viewGroup);
        Log.i("FinderIconViewTipPreference", "onCreateView hashCode:" + hashCode() + " view:" + onCreateView);
        AppMethodBeat.o(232526);
        return onCreateView;
    }

    @Override // com.tencent.mm.ui.base.preference.Preference, com.tencent.mm.ui.base.preference.IconPreference
    public final void onBindView(View view) {
        AppMethodBeat.i(232527);
        super.onBindView(view);
        Log.i("FinderIconViewTipPreference", "onBindView view:" + view + " root:" + this.gvQ);
        c.vVc.a("FinderIconViewTipPreference", this.gvQ != null, true, false, new a<String>() {
            /* class com.tencent.mm.ui.FinderIconViewTipPreference.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* bridge */ /* synthetic */ String invoke() {
                return "onBindView view root empty";
            }
        });
        if (this.gvQ == null && view != null) {
            this.gvQ = view;
            Log.i("FinderIconViewTipPreference", "has exception");
        }
        this.OBP = (WeImageView) this.gvQ.findViewById(R.id.h6u);
        this.OBQ = (LinearLayout) this.gvQ.findViewById(R.id.hff);
        this.OBR = (RelativeLayout) this.gvQ.findViewById(R.id.ilk);
        gHI();
        AppMethodBeat.o(232527);
    }

    private boolean akN(int i2) {
        View findViewById;
        AppMethodBeat.i(232528);
        if (this.OBA == null) {
            if (this.mView == null) {
                findViewById = null;
            } else {
                findViewById = this.mView.findViewById(16908312);
            }
            ViewGroup viewGroup = (ViewGroup) findViewById;
            gHI();
            if (viewGroup == null || viewGroup.getChildCount() > 0) {
                Log.i("FinderIconViewTipPreference", "[initWidgetFrame] fail,WidgetFrame has child!");
                AppMethodBeat.o(232528);
                return false;
            }
            this.OBA = viewGroup;
            if (i2 == 2 || i2 == 5 || i2 == 1 || i2 == 4 || i2 == 6 || i2 == 7) {
                View inflate = View.inflate(super.mContext, R.layout.b_s, this.OBA);
                this.OBB = inflate.findViewById(R.id.daa);
                this.OBC = inflate.findViewById(R.id.dak);
                this.OBF = (ImageView) inflate.findViewById(R.id.da_);
                this.OBG = (ImageView) inflate.findViewById(R.id.daw);
                this.OBJ = (ImageView) inflate.findViewById(R.id.h7d);
                alJ(8);
                this.OBL = (ImageView) inflate.findViewById(R.id.h7j);
                this.qME = (TextView) inflate.findViewById(R.id.h7p);
                this.qMD = (TextView) inflate.findViewById(R.id.eah);
                this.OBK = (ImageView) inflate.findViewById(R.id.g0l);
                this.OBO = (RelativeLayout) inflate.findViewById(R.id.wv);
            } else if (i2 == 3) {
                View inflate2 = View.inflate(super.mContext, R.layout.b_i, this.OBA);
                this.OBB = inflate2.findViewById(R.id.daa);
                this.OBD = inflate2.findViewById(R.id.dac);
                this.OBE = inflate2.findViewById(R.id.dae);
                this.OBM = new ArrayList<>(3);
                this.OBM.add(this.OBB);
                this.OBM.add(this.OBD);
                this.OBM.add(this.OBE);
                this.OBF = (ImageView) inflate2.findViewById(R.id.da_);
                this.OBH = (ImageView) inflate2.findViewById(R.id.dab);
                this.OBI = (ImageView) inflate2.findViewById(R.id.dad);
                this.OBN = new ArrayList<>(3);
                this.OBN.add(this.OBF);
                this.OBN.add(this.OBH);
                this.OBN.add(this.OBI);
                this.OBJ = (ImageView) inflate2.findViewById(R.id.h7d);
            }
            AppMethodBeat.o(232528);
            return true;
        }
        AppMethodBeat.o(232528);
        return true;
    }

    private void gHI() {
        AppMethodBeat.i(232529);
        Log.i("FinderIconViewTipPreference", "changeContent");
        if (this.gvQ != null) {
            if (this.OBU == null) {
                this.OBU = (LinearLayout.LayoutParams) ((ViewGroup) this.gvQ.findViewById(R.id.be9)).getLayoutParams();
            }
            if (this.OBV == null) {
                this.OBV = new LinearLayout.LayoutParams(-2, this.OBU.height, 0.0f);
            }
            if (this.OBS == null) {
                this.OBS = (LinearLayout.LayoutParams) this.OBQ.getLayoutParams();
            }
            if (this.OBT == null) {
                this.OBT = new LinearLayout.LayoutParams(-1, -1, 0.0f);
            }
        }
        AppMethodBeat.o(232529);
    }

    private void AY(boolean z) {
        AppMethodBeat.i(232530);
        Log.i("FinderIconViewTipPreference", "changeContentLayoutParam :".concat(String.valueOf(z)));
        if (this.gvQ != null) {
            ViewGroup viewGroup = (ViewGroup) this.gvQ.findViewById(R.id.be9);
            if (z) {
                viewGroup.setLayoutParams(this.OBU);
                this.OBQ.setLayoutParams(this.OBS);
                aE(this.OBR, 8);
                aE(this.OBP, 0);
            } else {
                viewGroup.setLayoutParams(this.OBV);
                this.OBQ.setLayoutParams(this.OBT);
                aE(this.OBR, 0);
                aE(this.OBA, 0);
                aE(this.OBP, 8);
            }
            this.OBR.requestLayout();
        }
        AppMethodBeat.o(232530);
    }

    public final void a(boolean z, ehv ehv, int i2, boolean z2, boolean z3, boolean z4) {
        AppMethodBeat.i(232531);
        Log.i("FinderIconViewTipPreference", "[showFinderAvatars] show=%s title=%s url=%s style=%s withRedDot=%s isRightTitle=%s isLiveRedDot=%s", Boolean.valueOf(z), ehv.title, ehv.url, Integer.valueOf(i2), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4));
        if (!akN(i2)) {
            AppMethodBeat.o(232531);
            return;
        }
        if (i2 == 1) {
            AY(false);
            a(z, ehv, false, z2, z3, Boolean.valueOf(z4));
        } else if (i2 == 2) {
            AY(false);
            a(z, ehv, false, z2, z3, z4);
        } else if (i2 == 4) {
            AY(false);
            a(z, ehv, true, z2, z3, Boolean.valueOf(z4));
        } else if (i2 == 5) {
            AY(false);
            a(z, ehv, true, z2, z3, z4);
        } else if (i2 == 3) {
            AY(false);
            g(z, ehv);
        } else if (i2 == 6) {
            AY(false);
            e(z, ehv);
        } else if (i2 == 7) {
            AY(false);
            f(z, ehv);
        }
        if (!z2) {
            aE(this.OBJ, 8);
            alJ(8);
        }
        AppMethodBeat.o(232531);
    }

    private void aE(View view, int i2) {
        AppMethodBeat.i(232532);
        if (!(view == null || view.getVisibility() == i2)) {
            view.setVisibility(i2);
        }
        if (view != null && view == this.OBA && i2 == 8) {
            AY(true);
        }
        AppMethodBeat.o(232532);
    }

    private void gHJ() {
        AppMethodBeat.i(232533);
        if (this.OBM == null) {
            AppMethodBeat.o(232533);
            return;
        }
        int size = this.OBM.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view = this.OBM.get(i2);
            if (view != null && view.getVisibility() == 0) {
                view.setVisibility(8);
            }
        }
        AppMethodBeat.o(232533);
    }

    private boolean gHK() {
        AppMethodBeat.i(232534);
        if (this.OBM == null || this.OBN == null) {
            Log.i("FinderIconViewTipPreference", "friend avatar is null");
            AppMethodBeat.o(232534);
            return false;
        }
        int size = this.OBM.size();
        int size2 = this.OBN.size();
        if (size == 3 && size == size2) {
            AppMethodBeat.o(232534);
            return true;
        }
        Log.i("FinderIconViewTipPreference", "friend avatar size illegal");
        AppMethodBeat.o(232534);
        return false;
    }

    private void a(ehv ehv, boolean z, boolean z2, boolean z3, boolean z4) {
        AppMethodBeat.i(232535);
        if (this.OBG == null || this.OBC == null) {
            AppMethodBeat.o(232535);
            return;
        }
        aE(this.OBO, 0);
        aE(this.OBK, 8);
        if (z) {
            ViewGroup.LayoutParams layoutParams = this.OBG.getLayoutParams();
            float dimension = this.OBG.getContext().getResources().getDimension(R.dimen.ci);
            layoutParams.width = (int) dimension;
            layoutParams.height = (int) dimension;
            this.OBG.setLayoutParams(layoutParams);
        } else {
            ViewGroup.LayoutParams layoutParams2 = this.OBG.getLayoutParams();
            float dimension2 = this.OBG.getContext().getResources().getDimension(R.dimen.cc);
            layoutParams2.width = (int) dimension2;
            layoutParams2.height = (int) dimension2;
            this.OBG.setLayoutParams(layoutParams2);
        }
        if (!Util.isNullOrNil(ehv.url)) {
            Log.i("FinderIconViewTipPreference", "[bindSingleSquareAvatarTask] load=%s isBigAvatar=%s isWithRedDot=%s", ehv.url, Boolean.valueOf(z), Boolean.valueOf(z2));
            m mVar = m.uJa;
            d<o> dkb = m.dkb();
            com.tencent.mm.plugin.finder.loader.a aVar = new com.tencent.mm.plugin.finder.loader.a(ehv.url);
            ImageView imageView = this.OBG;
            m mVar2 = m.uJa;
            dkb.a(aVar, imageView, m.a(m.a.WX_AVATAR));
        } else {
            Log.w("FinderIconViewTipPreference", "[bindSingleSquareAvatarTask] tipsInfo.url is null.");
        }
        aE(this.OBB, 8);
        aE(this.OBC, 0);
        aE(this.OBG, 0);
        aE(this.OBJ, 8);
        aE(this.OBA, 0);
        if (z2) {
            aE(this.OBL, 0);
            if (!z4) {
                ViewGroup.LayoutParams layoutParams3 = this.OBL.getLayoutParams();
                layoutParams3.width = -2;
                layoutParams3.height = -2;
                this.OBL.setLayoutParams(layoutParams3);
                this.OBL.setImageResource(R.drawable.b1a);
            } else {
                ViewGroup.LayoutParams layoutParams4 = this.OBJ.getLayoutParams();
                int e2 = com.tencent.mm.view.d.e(this.OBJ.getContext(), 11.1f);
                layoutParams4.width = e2;
                layoutParams4.height = e2;
                this.OBL.setLayoutParams(layoutParams4);
                this.OBL.setImageResource(R.raw.finder_live_icon);
            }
        } else {
            aE(this.OBL, 8);
        }
        if (Util.isNullOrNil(ehv.title)) {
            aE(this.qME, 8);
            aE(this.qMD, 8);
        } else if (z3) {
            aE(this.qMD, 8);
            aE(this.qME, 0);
            if (this.qME != null) {
                this.qME.setText(ehv.title);
                AppMethodBeat.o(232535);
                return;
            }
        } else {
            aE(this.qME, 8);
            gHL();
            aE(this.qMD, 0);
            if (this.qMD != null) {
                this.qMD.setText(ehv.title);
                AppMethodBeat.o(232535);
                return;
            }
        }
        AppMethodBeat.o(232535);
    }

    private void a(ehv ehv, boolean z) {
        AppMethodBeat.i(232536);
        if (z) {
            this.qMD.setMaxLines(2);
            this.qMD.setMaxWidth((int) (((double) av.az(this.qMD.getContext()).x) * 0.4d));
        } else {
            gHL();
        }
        aE(this.qMD, 0);
        aE(this.OBK, 0);
        aE(this.qME, 8);
        aE(this.OBO, 8);
        if (this.qMD != null) {
            this.qMD.setText(ehv.title);
        }
        AppMethodBeat.o(232536);
    }

    private void b(ehv ehv, boolean z, boolean z2, boolean z3, boolean z4) {
        AppMethodBeat.i(232537);
        if (this.OBF == null || this.OBB == null) {
            AppMethodBeat.o(232537);
            return;
        }
        aE(this.OBO, 0);
        aE(this.OBK, 8);
        if (z) {
            ViewGroup.LayoutParams layoutParams = this.OBF.getLayoutParams();
            float dimension = this.OBF.getContext().getResources().getDimension(R.dimen.ci);
            layoutParams.width = (int) dimension;
            layoutParams.height = (int) dimension;
            this.OBF.setLayoutParams(layoutParams);
        } else {
            ViewGroup.LayoutParams layoutParams2 = this.OBF.getLayoutParams();
            float dimension2 = this.OBF.getContext().getResources().getDimension(R.dimen.cc);
            layoutParams2.width = (int) dimension2;
            layoutParams2.height = (int) dimension2;
            this.OBF.setLayoutParams(layoutParams2);
        }
        if (!Util.isNullOrNil(ehv.url)) {
            Log.i("FinderIconViewTipPreference", "[bindSingleAvatarTask] load=%s isBigAvatar=%s isWithRedDot=%s", ehv.url, Boolean.valueOf(z), Boolean.valueOf(z2));
            m mVar = m.uJa;
            d<o> dka = m.dka();
            com.tencent.mm.plugin.finder.loader.a aVar = new com.tencent.mm.plugin.finder.loader.a(ehv.url);
            ImageView imageView = this.OBF;
            m mVar2 = m.uJa;
            dka.a(aVar, imageView, m.a(m.a.AVATAR));
        } else {
            Log.w("FinderIconViewTipPreference", "[bindSingleAvatarTask] tipsInfo.url is null.");
        }
        aE(this.OBB, 0);
        aE(this.OBC, 8);
        aE(this.OBG, 8);
        aE(this.OBL, 8);
        aE(this.OBA, 0);
        if (z2) {
            aE(this.OBJ, 0);
            if (!z4) {
                ViewGroup.LayoutParams layoutParams3 = this.OBJ.getLayoutParams();
                layoutParams3.width = -2;
                layoutParams3.height = -2;
                this.OBJ.setLayoutParams(layoutParams3);
                this.OBJ.setImageResource(R.drawable.b1a);
            } else {
                ViewGroup.LayoutParams layoutParams4 = this.OBJ.getLayoutParams();
                int e2 = com.tencent.mm.view.d.e(this.OBJ.getContext(), 11.1f);
                layoutParams4.width = e2;
                layoutParams4.height = e2;
                this.OBJ.setLayoutParams(layoutParams4);
                this.OBJ.setImageResource(R.raw.finder_live_icon);
            }
        } else {
            aE(this.OBJ, 8);
        }
        if (Util.isNullOrNil(ehv.title)) {
            aE(this.qME, 8);
            aE(this.qMD, 8);
        } else if (z3) {
            aE(this.qMD, 8);
            aE(this.qME, 0);
            if (this.qME != null) {
                this.qME.setText(ehv.title);
                AppMethodBeat.o(232537);
                return;
            }
        } else {
            aE(this.qME, 8);
            gHL();
            aE(this.qMD, 0);
            if (this.qMD != null) {
                this.qMD.setText(ehv.title);
                AppMethodBeat.o(232537);
                return;
            }
        }
        AppMethodBeat.o(232537);
    }

    private void b(ehv ehv) {
        AppMethodBeat.i(232538);
        LinkedList<String> linkedList = ehv.duo;
        int size = linkedList.size();
        Log.i("FinderIconViewTipPreference", "url size = ".concat(String.valueOf(size)));
        int min = Math.min(size, 3);
        int i2 = 0;
        while (min > 0) {
            int i3 = min - 1;
            View view = this.OBM.get(i3);
            m mVar = m.uJa;
            d<o> dka = m.dka();
            int i4 = i2 + 1;
            com.tencent.mm.plugin.finder.loader.a aVar = new com.tencent.mm.plugin.finder.loader.a(linkedList.get(i2));
            m mVar2 = m.uJa;
            dka.a(aVar, this.OBN.get(i3), m.a(m.a.AVATAR));
            if (view != null) {
                view.setVisibility(0);
                i2 = i4;
                min = i3;
            } else {
                i2 = i4;
                min = i3;
            }
        }
        AppMethodBeat.o(232538);
    }

    private void a(boolean z, ehv ehv, boolean z2, boolean z3, boolean z4, Boolean bool) {
        AppMethodBeat.i(232539);
        alF(8);
        alE(8);
        alI(8);
        alD(8);
        BB(false);
        if (z) {
            b(ehv, z2, z3, z4, bool.booleanValue());
        } else {
            aE(this.OBA, 8);
        }
        notifyDataSetChanged();
        AppMethodBeat.o(232539);
    }

    private void a(boolean z, ehv ehv, boolean z2, boolean z3, boolean z4, boolean z5) {
        AppMethodBeat.i(232540);
        alF(8);
        alE(8);
        alI(8);
        alD(8);
        BB(false);
        if (z) {
            a(ehv, z2, z3, z4, z5);
        } else {
            aE(this.OBA, 8);
        }
        notifyDataSetChanged();
        AppMethodBeat.o(232540);
    }

    private void e(boolean z, ehv ehv) {
        AppMethodBeat.i(232541);
        alF(8);
        alE(8);
        alI(8);
        alD(8);
        BB(false);
        if (z) {
            a(ehv, false);
        } else {
            aE(this.OBA, 8);
        }
        notifyDataSetChanged();
        AppMethodBeat.o(232541);
    }

    private void f(boolean z, ehv ehv) {
        AppMethodBeat.i(232542);
        alF(8);
        alE(8);
        alI(8);
        alD(8);
        BB(false);
        if (z) {
            a(ehv, true);
        } else {
            aE(this.OBA, 8);
        }
        notifyDataSetChanged();
        AppMethodBeat.o(232542);
    }

    private void gHL() {
        AppMethodBeat.i(232543);
        this.qMD.setMaxLines(1);
        AppMethodBeat.o(232543);
    }

    private void g(boolean z, ehv ehv) {
        AppMethodBeat.i(232544);
        Log.d("FinderIconViewTipPreference", "bindAvatars() show:%s", Boolean.valueOf(z));
        if (!z) {
            alF(8);
            alE(8);
            alI(8);
            alD(8);
            aE(this.OBA, 8);
        } else if (ehv != null && ehv.duo != null && ehv.duo.size() > 0 && gHK()) {
            alF(8);
            alI(8);
            alH(8);
            alJ(8);
            BB(false);
            gHJ();
            b(ehv);
            aE(this.OBJ, 0);
            aE(this.OBA, 0);
        }
        notifyDataSetChanged();
        AppMethodBeat.o(232544);
    }

    @Override // com.tencent.mm.plugin.newtips.a.a, com.tencent.mm.plugin.newtips.NormalIconNewTipPreference
    public final boolean qW(boolean z) {
        AppMethodBeat.i(232545);
        if (z) {
            gHM();
        } else {
            AY(true);
        }
        boolean qW = super.qW(z);
        AppMethodBeat.o(232545);
        return qW;
    }

    @Override // com.tencent.mm.plugin.newtips.a.a, com.tencent.mm.plugin.newtips.NormalIconNewTipPreference
    public final boolean a(boolean z, ehv ehv) {
        AppMethodBeat.i(232546);
        gHM();
        boolean a2 = super.a(z, ehv);
        AppMethodBeat.o(232546);
        return a2;
    }

    @Override // com.tencent.mm.plugin.newtips.a.a, com.tencent.mm.plugin.newtips.NormalIconNewTipPreference
    public final boolean qX(boolean z) {
        AppMethodBeat.i(232547);
        gHM();
        boolean qX = super.qX(z);
        AppMethodBeat.o(232547);
        return qX;
    }

    private void gHM() {
        AppMethodBeat.i(232548);
        aE(this.OBA, 8);
        AppMethodBeat.o(232548);
    }
}
