package com.tencent.mm.plugin.emoji.ui.v2;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.emoji.a.a.a;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.plugin.emoji.a.h;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.sdk.platformtools.Log;

public class EmojiStoreV2PersonFragment extends EmojiStoreV2BaseFragment {
    private boolean rkK = false;
    private h rkM;

    @Override // com.tencent.mm.ui.MMFragment
    public int getLayoutId() {
        return R.layout.a34;
    }

    @Override // android.support.v4.app.Fragment, com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2BaseFragment
    public void onAttach(Activity activity) {
        AppMethodBeat.i(109220);
        super.onAttach(activity);
        Log.d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onAttach");
        AppMethodBeat.o(109220);
    }

    @Override // com.tencent.mm.ui.FragmentActivitySupport, android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment, com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2BaseFragment
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(109221);
        super.onCreate(bundle);
        Log.d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onCreate");
        this.rbN.eql = 2;
        AppMethodBeat.o(109221);
    }

    @Override // android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment, com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2BaseFragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        AppMethodBeat.i(109222);
        Log.d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onCreateView");
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        AppMethodBeat.o(109222);
        return onCreateView;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2BaseFragment
    public final void cHU() {
        EmotionSummary emotionSummary;
        boolean z = true;
        AppMethodBeat.i(109223);
        try {
            int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
            if (firstVisiblePosition <= 0) {
                firstVisiblePosition = 1;
            }
            int lastVisiblePosition = this.mListView.getLastVisiblePosition();
            if (lastVisiblePosition - firstVisiblePosition <= 0) {
                AppMethodBeat.o(109223);
                return;
            }
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            StringBuilder sb3 = new StringBuilder();
            for (int i2 = firstVisiblePosition - 1; i2 < lastVisiblePosition - 1; i2++) {
                for (int i3 = 0; i3 < 3; i3++) {
                    int FO = this.rkM.FO(i2) + i3;
                    f FN = this.rkM.getItem(FO);
                    if (!(FN == null || (emotionSummary = FN.qYl) == null)) {
                        if (!z) {
                            sb.append("#");
                            sb2.append("#");
                            sb3.append("#");
                        }
                        sb.append(emotionSummary.ProductID);
                        sb2.append(emotionSummary.PackName);
                        sb3.append(FO + 1);
                        z = false;
                    }
                }
            }
            this.rbN.eqm = 1;
            this.rbN.ix(sb.toString());
            this.rbN.iy(sb2.toString());
            this.rbN.iz(sb3.toString());
            this.rbN.bfK();
            AppMethodBeat.o(109223);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.emoji.EmojiStoreV2PersonFragment", e2, "", new Object[0]);
            AppMethodBeat.o(109223);
        }
    }

    @Override // android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment, com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2BaseFragment
    public void onStart() {
        AppMethodBeat.i(109224);
        super.onStart();
        Log.d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onStart");
        AppMethodBeat.o(109224);
    }

    @Override // android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment, com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2BaseFragment
    public void onResume() {
        AppMethodBeat.i(109225);
        super.onResume();
        Log.d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onResume");
        if (this.rjM != null) {
            this.rjM.cIc();
        }
        AppMethodBeat.o(109225);
    }

    @Override // android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment, com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2BaseFragment
    public void onPause() {
        AppMethodBeat.i(109226);
        super.onPause();
        Log.d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onPause");
        AppMethodBeat.o(109226);
    }

    @Override // android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment, com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2BaseFragment
    public void onStop() {
        AppMethodBeat.i(109227);
        super.onStop();
        Log.d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onStop");
        AppMethodBeat.o(109227);
    }

    @Override // android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment, com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2BaseFragment
    public void onDestroyView() {
        AppMethodBeat.i(109228);
        super.onDestroyView();
        Log.d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onResume");
        AppMethodBeat.o(109228);
    }

    @Override // com.tencent.mm.ui.FragmentActivitySupport, android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment, com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2BaseFragment
    public void onDestroy() {
        AppMethodBeat.i(109229);
        super.onDestroy();
        Log.d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onDestroy");
        AppMethodBeat.o(109229);
    }

    @Override // android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment, com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2BaseFragment
    public void onDetach() {
        AppMethodBeat.i(109230);
        super.onDetach();
        Log.d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onDestroy");
        AppMethodBeat.o(109230);
    }

    @Override // com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2BaseFragment
    public final int cGQ() {
        return 9;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2BaseFragment
    public final void b(int i2, int i3, q qVar) {
        AppMethodBeat.i(109231);
        super.b(i2, i3, qVar);
        if (this.rjM != null) {
            this.rjM.updateTitle();
        }
        AppMethodBeat.o(109231);
    }

    @Override // com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2BaseFragment
    public final a cGJ() {
        AppMethodBeat.i(109232);
        this.rkM = new h(getContext());
        h hVar = this.rkM;
        AppMethodBeat.o(109232);
        return hVar;
    }

    @Override // com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2BaseFragment
    public final boolean cHZ() {
        return false;
    }

    @Override // android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment, com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2BaseFragment
    public void setUserVisibleHint(boolean z) {
        AppMethodBeat.i(109233);
        super.setUserVisibleHint(z);
        if (!this.rkK && z) {
            this.rkK = true;
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(12740, 4, "", "", "", 2, 2);
        }
        AppMethodBeat.o(109233);
    }
}
