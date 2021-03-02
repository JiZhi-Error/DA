package com.tencent.mm.plugin.festival.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;

public final class FestivalWaitForHeartbeatLoadingProxyUIC extends UIComponent {
    private static final ConcurrentHashMap<String, c> UBF = new ConcurrentHashMap<>();
    public static final a UBG = new a((byte) 0);
    private String dPI;

    public interface b {
        void finish();
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FestivalWaitForHeartbeatLoadingProxyUIC(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(263215);
        AppMethodBeat.o(263215);
    }

    static {
        AppMethodBeat.i(263216);
        AppMethodBeat.o(263216);
    }

    public static final class c implements b {
        FestivalWaitForHeartbeatLoadingProxyUIC UBH;
        public final String dPI = String.valueOf(hashCode());

        public c() {
            AppMethodBeat.i(263208);
            AppMethodBeat.o(263208);
        }

        @Override // com.tencent.mm.plugin.festival.ui.FestivalWaitForHeartbeatLoadingProxyUIC.b
        public final void finish() {
            AppCompatActivity activity;
            AppMethodBeat.i(263207);
            Log.i("MicroMsg.FestivalWaitForHeartbeatLoadingProxyUIC", "finish presenter, requestId:" + this.dPI);
            FestivalWaitForHeartbeatLoadingProxyUIC.UBF.remove(this.dPI);
            FestivalWaitForHeartbeatLoadingProxyUIC festivalWaitForHeartbeatLoadingProxyUIC = this.UBH;
            if (festivalWaitForHeartbeatLoadingProxyUIC == null || (activity = festivalWaitForHeartbeatLoadingProxyUIC.getActivity()) == null) {
                AppMethodBeat.o(263207);
                return;
            }
            activity.finish();
            AppMethodBeat.o(263207);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onCreateBefore(Bundle bundle) {
        AppMethodBeat.i(263211);
        super.onCreateBefore(bundle);
        getActivity().setTheme(R.style.q6);
        AppMethodBeat.o(263211);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(263212);
        super.onCreate(bundle);
        getActivity().overridePendingTransition(0, 0);
        com.tencent.mm.ui.statusbar.d.jV(getActivity());
        com.tencent.mm.ui.base.b.a(getActivity(), null);
        String stringExtra = getIntent().getStringExtra("INTENT_KEY_REQUEST_ID");
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.dPI = stringExtra;
        String str = this.dPI;
        if (str == null) {
            p.btv("requestId");
        }
        if (str.length() == 0) {
            getActivity().finish();
            AppMethodBeat.o(263212);
            return;
        }
        ConcurrentHashMap<String, c> concurrentHashMap = UBF;
        String str2 = this.dPI;
        if (str2 == null) {
            p.btv("requestId");
        }
        c cVar = concurrentHashMap.get(str2);
        if (cVar == null) {
            getActivity().finish();
            AppMethodBeat.o(263212);
            return;
        }
        cVar.UBH = this;
        ActionBar supportActionBar = getActivity().getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.hide();
        }
        android.app.ActionBar actionBar = getActivity().getActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        AppCompatActivity activity = getActivity();
        if (!(activity instanceof MMActivity)) {
            activity = null;
        }
        MMActivity mMActivity = (MMActivity) activity;
        if (mMActivity != null) {
            mMActivity.setContentViewVisibility(4);
            SwipeBackLayout swipeBackLayout = mMActivity.getSwipeBackLayout();
            if (swipeBackLayout != null) {
                swipeBackLayout.setEnableGesture(false);
            }
        }
        q a2 = h.a((Context) getActivity(), getActivity().getString(R.string.ekc), true, (DialogInterface.OnCancelListener) null);
        if (a2 != null) {
            a2.setOnCancelListener(new d(this));
            a2.setOnDismissListener(new e(this));
            AppMethodBeat.o(263212);
            return;
        }
        AppMethodBeat.o(263212);
    }

    static final class d implements DialogInterface.OnCancelListener {
        final /* synthetic */ FestivalWaitForHeartbeatLoadingProxyUIC UBI;

        d(FestivalWaitForHeartbeatLoadingProxyUIC festivalWaitForHeartbeatLoadingProxyUIC) {
            this.UBI = festivalWaitForHeartbeatLoadingProxyUIC;
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.i(263209);
            this.UBI.getActivity().finish();
            this.UBI.getActivity().overridePendingTransition(0, 0);
            AppMethodBeat.o(263209);
        }
    }

    static final class e implements DialogInterface.OnDismissListener {
        final /* synthetic */ FestivalWaitForHeartbeatLoadingProxyUIC UBI;

        e(FestivalWaitForHeartbeatLoadingProxyUIC festivalWaitForHeartbeatLoadingProxyUIC) {
            this.UBI = festivalWaitForHeartbeatLoadingProxyUIC;
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.i(263210);
            this.UBI.getActivity().finish();
            this.UBI.getActivity().overridePendingTransition(0, 0);
            AppMethodBeat.o(263210);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final int getLayoutId() {
        return -1;
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onFinished() {
        AppMethodBeat.i(263213);
        super.onFinished();
        getActivity().overridePendingTransition(0, 0);
        AppMethodBeat.o(263213);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onDestroy() {
        AppMethodBeat.i(263214);
        super.onDestroy();
        String str = this.dPI;
        if (str == null) {
            p.btv("requestId");
        }
        if (str.length() > 0) {
            ConcurrentHashMap<String, c> concurrentHashMap = UBF;
            String str2 = this.dPI;
            if (str2 == null) {
                p.btv("requestId");
            }
            concurrentHashMap.remove(str2);
        }
        AppMethodBeat.o(263214);
    }
}
