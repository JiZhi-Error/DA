package com.tencent.mm.plugin.emoji.ui.v2;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.emoji.a.a.a;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.plugin.emoji.a.g;
import com.tencent.mm.plugin.emoji.model.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.sdk.platformtools.Log;

public class EmojiStoreV2MainFragment extends EmojiStoreV2BaseFragment {
    private boolean rkK = false;
    private g rkL;

    @Override // com.tencent.mm.ui.MMFragment
    public int getLayoutId() {
        return R.layout.a32;
    }

    @Override // android.support.v4.app.Fragment, com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2BaseFragment
    public void onAttach(Activity activity) {
        AppMethodBeat.i(109206);
        super.onAttach(activity);
        Log.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onAttach");
        AppMethodBeat.o(109206);
    }

    @Override // com.tencent.mm.ui.FragmentActivitySupport, android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment, com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2BaseFragment
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(109207);
        super.onCreate(bundle);
        Log.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onCreate");
        this.rbN.eql = 1;
        AppMethodBeat.o(109207);
    }

    @Override // android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment, com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2BaseFragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        AppMethodBeat.i(109208);
        Log.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onCreateView");
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        AppMethodBeat.o(109208);
        return onCreateView;
    }

    @Override // android.support.v4.app.Fragment, com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2BaseFragment
    public void onActivityCreated(Bundle bundle) {
        AppMethodBeat.i(109209);
        Log.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onActivityCreated");
        super.onActivityCreated(bundle);
        AppMethodBeat.o(109209);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2BaseFragment
    public final void cHU() {
        EmotionSummary emotionSummary;
        boolean z = true;
        AppMethodBeat.i(109210);
        try {
            int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
            int lastVisiblePosition = this.mListView.getLastVisiblePosition();
            if (lastVisiblePosition - firstVisiblePosition <= 0) {
                AppMethodBeat.o(109210);
                return;
            }
            boolean z2 = e.cFX().rbn;
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            StringBuilder sb3 = new StringBuilder();
            while (firstVisiblePosition < lastVisiblePosition) {
                f FN = this.rkL.FN(firstVisiblePosition);
                if (!(FN == null || (emotionSummary = FN.qYl) == null)) {
                    if (!z) {
                        sb.append("#");
                        sb2.append("#");
                        sb3.append("#");
                    }
                    sb.append(emotionSummary.ProductID);
                    sb2.append(z2 ? emotionSummary.ExptDesc : emotionSummary.Introduce);
                    sb3.append(firstVisiblePosition + 1);
                    z = false;
                }
                firstVisiblePosition++;
            }
            this.rbN.eqm = 1;
            this.rbN.ix(sb.toString());
            this.rbN.iy(sb2.toString());
            this.rbN.iz(sb3.toString());
            this.rbN.bfK();
            AppMethodBeat.o(109210);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.emoji.EmojiStoreV2MainFragment", e2, "", new Object[0]);
            AppMethodBeat.o(109210);
        }
    }

    @Override // android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment, com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2BaseFragment
    public void onStart() {
        AppMethodBeat.i(109211);
        super.onStart();
        Log.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onStart");
        AppMethodBeat.o(109211);
    }

    @Override // android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment, com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2BaseFragment
    public void onResume() {
        AppMethodBeat.i(109212);
        super.onResume();
        Log.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onResume");
        AppMethodBeat.o(109212);
    }

    @Override // android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment, com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2BaseFragment
    public void onPause() {
        AppMethodBeat.i(109213);
        super.onPause();
        Log.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onPause");
        AppMethodBeat.o(109213);
    }

    @Override // android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment, com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2BaseFragment
    public void onStop() {
        AppMethodBeat.i(109214);
        super.onStop();
        Log.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onStop");
        AppMethodBeat.o(109214);
    }

    @Override // android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment, com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2BaseFragment
    public void onDestroyView() {
        AppMethodBeat.i(109215);
        super.onDestroyView();
        Log.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onResume");
        AppMethodBeat.o(109215);
    }

    @Override // com.tencent.mm.ui.FragmentActivitySupport, android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment, com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2BaseFragment
    public void onDestroy() {
        AppMethodBeat.i(109216);
        super.onDestroy();
        Log.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onDestroy");
        AppMethodBeat.o(109216);
    }

    @Override // android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment, com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2BaseFragment
    public void onDetach() {
        AppMethodBeat.i(109217);
        super.onDetach();
        Log.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onDestroy");
        AppMethodBeat.o(109217);
    }

    @Override // com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2BaseFragment
    public final int cGQ() {
        return 5;
    }

    @Override // com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2BaseFragment
    public final a cGJ() {
        AppMethodBeat.i(109218);
        this.rkL = new g(getContext());
        g gVar = this.rkL;
        AppMethodBeat.o(109218);
        return gVar;
    }

    @Override // com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2BaseFragment
    public final boolean cHZ() {
        return true;
    }

    @Override // android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment, com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2BaseFragment
    public void setUserVisibleHint(boolean z) {
        AppMethodBeat.i(109219);
        super.setUserVisibleHint(z);
        if (!this.rkK && z) {
            this.rkK = true;
            h.INSTANCE.a(12740, 4, "", "", "", 1, 1);
        }
        AppMethodBeat.o(109219);
    }
}
