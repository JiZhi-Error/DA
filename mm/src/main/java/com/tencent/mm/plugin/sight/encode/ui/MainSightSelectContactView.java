package com.tencent.mm.plugin.sight.encode.ui;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.sight.encode.ui.d;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.n;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class MainSightSelectContactView extends FrameLayout implements AbsListView.OnScrollListener, d.a, n {
    public int DpV;
    public d DpW;
    Animation DpX;
    public c DpY;
    private View DpZ;
    boolean Dps = false;
    public MMFragmentActivity Dpx;
    public a Dqa;
    public LinearLayout Dqb;
    private View Dqc;
    private int Dqd = -1;
    private int Dqe = -1;
    public HashSet<String> Dqf;
    public HashSet<String> Dqg;
    public ListView mListView;

    public MainSightSelectContactView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MainSightSelectContactView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public void setMainSightContentView(a aVar) {
        this.Dqa = aVar;
    }

    public void setEmptyBgView(View view) {
        this.DpZ = view;
    }

    public void setSearchView(View view) {
        AppMethodBeat.i(28755);
        d dVar = this.DpW;
        dVar.DpN = view;
        dVar.xrL = (EditText) view.findViewById(R.id.bxz);
        dVar.DpM = (TextView) view.findViewById(R.id.hde);
        dVar.xrL.setOnFocusChangeListener(dVar);
        dVar.xrL.addTextChangedListener(dVar);
        dVar.DpM.setOnClickListener(dVar);
        dVar.DpP = (InputMethodManager) view.getContext().getSystemService("input_method");
        AppMethodBeat.o(28755);
    }

    public ListView getListView() {
        return this.mListView;
    }

    @Override // com.tencent.mm.plugin.sight.encode.ui.d.a
    public final void eWn() {
        AppMethodBeat.i(28756);
        if (this.Dqb == null) {
            AppMethodBeat.o(28756);
            return;
        }
        this.Dqb.getChildAt(0).setVisibility(0);
        this.DpZ.setVisibility(8);
        am(true, false);
        this.Dqa.eWb();
        AppMethodBeat.o(28756);
    }

    @Override // com.tencent.mm.plugin.sight.encode.ui.d.a
    public final void eWm() {
        AppMethodBeat.i(28757);
        if (this.Dqb == null) {
            AppMethodBeat.o(28757);
            return;
        }
        this.Dqb.getChildAt(0).setVisibility(8);
        this.DpZ.setVisibility(0);
        List<String> list = this.DpY.DpF;
        list.remove("@search.tencent");
        list.remove("@sns.tencent");
        list.remove("@draft.tencent");
        c(list, false, true);
        this.Dqa.eWc();
        if (!this.Dqa.Zx()) {
            this.Dqa.eWd();
        }
        this.Dqa.eWe();
        AppMethodBeat.o(28757);
    }

    public final void eWo() {
        AppMethodBeat.i(28758);
        this.mListView.post(new Runnable() {
            /* class com.tencent.mm.plugin.sight.encode.ui.MainSightSelectContactView.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(28754);
                if (MainSightSelectContactView.this.Dqd != MainSightSelectContactView.this.DpY.getCount() || MainSightSelectContactView.this.Dqa.getViewHeight() < MainSightSelectContactView.this.Dqe) {
                    if (MainSightSelectContactView.this.Dqc != null) {
                        MainSightSelectContactView.this.mListView.removeFooterView(MainSightSelectContactView.this.Dqc);
                    }
                    int i2 = MainSightSelectContactView.this.Dqe;
                    if (MainSightSelectContactView.this.Dqe < 0 || MainSightSelectContactView.this.Dqe > MainSightSelectContactView.this.Dqa.getViewHeight()) {
                        i2 = MainSightSelectContactView.this.Dqa.getViewHeight();
                    }
                    MainSightSelectContactView.this.Dqd = MainSightSelectContactView.this.DpY.getCount();
                    MainSightSelectContactView.this.Dqe = i2;
                    int i3 = 0;
                    for (int i4 = 0; i4 < MainSightSelectContactView.this.DpY.getCount(); i4++) {
                        View view = MainSightSelectContactView.this.DpY.getView(i4, null, MainSightSelectContactView.this.mListView);
                        view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                        i3 += view.getMeasuredHeight();
                        if (i3 >= i2) {
                            AppMethodBeat.o(28754);
                            return;
                        }
                    }
                    int i5 = i2 - i3;
                    if (i5 > 0) {
                        MainSightSelectContactView.this.Dqc = new View(MainSightSelectContactView.this.getContext());
                        MainSightSelectContactView.this.Dqc.setLayoutParams(new AbsListView.LayoutParams(-1, i5));
                        MainSightSelectContactView.this.Dqc.setBackgroundResource(R.color.fm);
                        MainSightSelectContactView.this.mListView.addFooterView(MainSightSelectContactView.this.Dqc);
                    }
                    AppMethodBeat.o(28754);
                    return;
                }
                AppMethodBeat.o(28754);
            }
        });
        AppMethodBeat.o(28758);
    }

    private void c(List<String> list, boolean z, boolean z2) {
        AppMethodBeat.i(28759);
        if (this.Dps) {
            AppMethodBeat.o(28759);
        } else if (list == null) {
            AppMethodBeat.o(28759);
        } else {
            if (z) {
                this.Dqg.clear();
                this.Dqf.clear();
                c.DpH = true;
                c.DpI = false;
            }
            if (this.DpY != null) {
                this.DpY.cv(list);
            }
            if (z2) {
                eWo();
                AppMethodBeat.o(28759);
                return;
            }
            if (this.Dqc != null) {
                this.mListView.removeFooterView(this.Dqc);
            }
            AppMethodBeat.o(28759);
        }
    }

    public final void am(boolean z, boolean z2) {
        AppMethodBeat.i(28760);
        List<String> arrayList = new ArrayList<>();
        arrayList.add("@search.tencent");
        arrayList.add("@sns.tencent");
        List<String> initData = getInitData();
        if (z) {
            arrayList.addAll(this.Dqg);
            for (String str : initData) {
                if (!arrayList.contains(str)) {
                    arrayList.add(str);
                }
            }
        } else {
            arrayList.addAll(initData);
        }
        c(arrayList, z2, true);
        AppMethodBeat.o(28760);
    }

    public List<String> getInitData() {
        AppMethodBeat.i(28761);
        ArrayList arrayList = new ArrayList();
        bg.aVF();
        List<String> gCv = c.aST().gCv();
        gCv.remove(z.aTY());
        arrayList.addAll(gCv);
        AppMethodBeat.o(28761);
        return arrayList;
    }

    @Override // com.tencent.mm.ui.contact.n
    public Activity getActivity() {
        return this.Dpx;
    }

    @Override // com.tencent.mm.ui.contact.n
    public ListView getContentLV() {
        return this.mListView;
    }

    public LinkedList<String> getSelectedContact() {
        AppMethodBeat.i(28764);
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.addAll(this.Dqg);
        AppMethodBeat.o(28764);
        return linkedList;
    }

    public final boolean eWp() {
        AppMethodBeat.i(28765);
        if (this.Dqg == null) {
            AppMethodBeat.o(28765);
            return true;
        }
        boolean isEmpty = this.Dqg.isEmpty();
        AppMethodBeat.o(28765);
        return isEmpty;
    }

    /* access modifiers changed from: package-private */
    public final String vg(int i2) {
        AppMethodBeat.i(28766);
        a anH = this.DpY.getItem(i2);
        if (anH == null) {
            AppMethodBeat.o(28766);
            return null;
        }
        as asVar = anH.contact;
        if (asVar == null) {
            AppMethodBeat.o(28766);
            return null;
        }
        String str = asVar.field_username;
        AppMethodBeat.o(28766);
        return str;
    }

    public static boolean XI(int i2) {
        return i2 == -1;
    }

    public void setIsMultiSelect(boolean z) {
        this.DpY.DpG = z;
    }

    @Override // com.tencent.mm.plugin.sight.encode.ui.d.a
    public final void gK(List<String> list) {
        AppMethodBeat.i(28767);
        c(list, false, false);
        AppMethodBeat.o(28767);
    }

    public void onScrollStateChanged(AbsListView absListView, int i2) {
        AppMethodBeat.i(28768);
        if (i2 == 1) {
            Util.hideVKB(absListView);
        }
        AppMethodBeat.o(28768);
    }

    public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        AppMethodBeat.i(28769);
        if (this.Dqb == null || absListView == null || this.Dqb.getHeight() <= 0 || this.Dpx == null) {
            AppMethodBeat.o(28769);
            return;
        }
        int height = this.Dqb.getHeight() - this.Dpx.getSupportActionBar().getHeight();
        int i5 = -this.Dqb.getTop();
        if (i5 < 0) {
            AppMethodBeat.o(28769);
            return;
        }
        this.Dqa.setCameraShadowAlpha(((float) i5) / ((float) height));
        this.Dqa.uH(this.Dqb.getTop() < 0 && this.Dqb.getTop() <= (-height));
        AppMethodBeat.o(28769);
    }

    @Override // com.tencent.mm.ui.contact.n
    public final boolean b(a aVar) {
        AppMethodBeat.i(28762);
        if (!aVar.PWh || aVar.contact == null) {
            AppMethodBeat.o(28762);
            return false;
        }
        boolean contains = this.Dqf.contains(aVar.contact.field_username);
        AppMethodBeat.o(28762);
        return contains;
    }

    @Override // com.tencent.mm.ui.contact.n
    public final boolean a(a aVar) {
        AppMethodBeat.i(28763);
        if (!aVar.PWh || aVar.contact == null) {
            AppMethodBeat.o(28763);
            return false;
        }
        boolean contains = this.Dqg.contains(aVar.contact.field_username);
        AppMethodBeat.o(28763);
        return contains;
    }
}
