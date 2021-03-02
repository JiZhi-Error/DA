package com.tencent.mm.plugin.profile.ui.tab.list;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.profile.ui.tab.data.BizProfileDataFetcher;
import com.tencent.mm.protocal.protobuf.ph;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010$\u001a\u00020%H\u0004J\b\u0010&\u001a\u00020%H\u0016J\u0010\u0010'\u001a\u00020%2\u0006\u0010(\u001a\u00020\u0015H\u0016J\u0010\u0010)\u001a\u00020%2\u0006\u0010*\u001a\u00020\u001bH\u0016J\b\u0010+\u001a\u00020%H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001b\u0010\t\u001a\u00020\n8TX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00020\u00108TX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0014\u001a\u00020\u0015X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0012\u0010 \u001a\u00020!X¤\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#¨\u0006,"}, hxF = {"Lcom/tencent/mm/plugin/profile/ui/tab/list/BaseBizProfileFragment;", "Landroid/support/v4/app/Fragment;", "()V", "bizUsername", "", "getBizUsername", "()Ljava/lang/String;", "setBizUsername", "(Ljava/lang/String;)V", "footerTextView", "Landroid/widget/TextView;", "getFooterTextView", "()Landroid/widget/TextView;", "footerTextView$delegate", "Lkotlin/Lazy;", "footerView", "Landroid/view/View;", "getFooterView", "()Landroid/view/View;", "footerView$delegate", "mBizProfileResp", "Lcom/tencent/mm/protocal/protobuf/BizProfileV2Resp;", "getMBizProfileResp", "()Lcom/tencent/mm/protocal/protobuf/BizProfileV2Resp;", "setMBizProfileResp", "(Lcom/tencent/mm/protocal/protobuf/BizProfileV2Resp;)V", "mDataFetcher", "Lcom/tencent/mm/plugin/profile/ui/tab/data/BizProfileDataFetcher;", "getMDataFetcher", "()Lcom/tencent/mm/plugin/profile/ui/tab/data/BizProfileDataFetcher;", "setMDataFetcher", "(Lcom/tencent/mm/plugin/profile/ui/tab/data/BizProfileDataFetcher;)V", "msgType", "", "getMsgType", "()I", "fetchMsgList", "", "onAppBarLayoutExpand", "setBizProfileResp", "bizProfileResp", "setDataFetcher", "dataFetcher", "showErrorView", "app_release"})
public abstract class BaseBizProfileFragment extends Fragment {
    protected BizProfileDataFetcher BmN;
    protected ph BmO;
    private final f BmP = g.ah(new b(this));
    private final f BmQ = g.ah(new a(this));
    protected String dVu;

    /* access modifiers changed from: protected */
    public final TextView eFL() {
        return (TextView) this.BmQ.getValue();
    }

    /* access modifiers changed from: protected */
    public final View getFooterView() {
        return (View) this.BmP.getValue();
    }

    /* access modifiers changed from: protected */
    public final void Rx(String str) {
        p.h(str, "<set-?>");
        this.dVu = str;
    }

    /* access modifiers changed from: protected */
    public final void d(BizProfileDataFetcher bizProfileDataFetcher) {
        p.h(bizProfileDataFetcher, "<set-?>");
        this.BmN = bizProfileDataFetcher;
    }

    /* access modifiers changed from: protected */
    public final BizProfileDataFetcher eFJ() {
        BizProfileDataFetcher bizProfileDataFetcher = this.BmN;
        if (bizProfileDataFetcher == null) {
            p.btv("mDataFetcher");
        }
        return bizProfileDataFetcher;
    }

    /* access modifiers changed from: protected */
    public final void e(ph phVar) {
        p.h(phVar, "<set-?>");
        this.BmO = phVar;
    }

    /* access modifiers changed from: protected */
    public final ph eFK() {
        ph phVar = this.BmO;
        if (phVar == null) {
            p.btv("mBizProfileResp");
        }
        return phVar;
    }

    public void eFM() {
    }

    public void f(ph phVar) {
        p.h(phVar, "bizProfileResp");
        this.BmO = phVar;
    }

    public void e(BizProfileDataFetcher bizProfileDataFetcher) {
        p.h(bizProfileDataFetcher, "dataFetcher");
        this.BmN = bizProfileDataFetcher;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
    static final class b extends q implements kotlin.g.a.a<View> {
        final /* synthetic */ BaseBizProfileFragment BmR;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(BaseBizProfileFragment baseBizProfileFragment) {
            super(0);
            this.BmR = baseBizProfileFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ View invoke() {
            AppMethodBeat.i(230722);
            View inflate = LayoutInflater.from(this.BmR.getContext()).inflate(R.layout.xl, (ViewGroup) null, false);
            AppMethodBeat.o(230722);
            return inflate;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class a extends q implements kotlin.g.a.a<TextView> {
        final /* synthetic */ BaseBizProfileFragment BmR;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(BaseBizProfileFragment baseBizProfileFragment) {
            super(0);
            this.BmR = baseBizProfileFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ TextView invoke() {
            AppMethodBeat.i(230721);
            TextView textView = (TextView) this.BmR.getFooterView().findViewById(R.id.a61);
            AppMethodBeat.o(230721);
            return textView;
        }
    }
}
