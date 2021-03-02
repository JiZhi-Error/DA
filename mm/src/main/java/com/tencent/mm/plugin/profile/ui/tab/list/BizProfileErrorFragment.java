package com.tencent.mm.plugin.profile.ui.tab.list;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\b8TX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileErrorFragment;", "Lcom/tencent/mm/plugin/profile/ui/tab/list/BaseBizProfileFragment;", "()V", OpenSDKTool4Assistant.EXTRA_ERROR_MSG, "", "errorTextView", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "msgType", "", "getMsgType", "()I", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "setErrorMsg", "", "app_release"})
public final class BizProfileErrorFragment extends BaseBizProfileFragment {
    private MMNeat7extView BmS;
    public String errorMsg;

    @Override // android.support.v4.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        AppMethodBeat.i(230723);
        p.h(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.wm, viewGroup, false);
        View findViewById = inflate.findViewById(R.id.a5t);
        p.g(findViewById, "view.findViewById(R.id.biz_profile_err_msg_text)");
        this.BmS = (MMNeat7extView) findViewById;
        MMNeat7extView mMNeat7extView = this.BmS;
        if (mMNeat7extView == null) {
            p.btv("errorTextView");
        }
        MMNeat7extView mMNeat7extView2 = this.BmS;
        if (mMNeat7extView2 == null) {
            p.btv("errorTextView");
        }
        Context context = mMNeat7extView.getContext();
        String str = this.errorMsg;
        if (str == null) {
            p.btv(OpenSDKTool4Assistant.EXTRA_ERROR_MSG);
        }
        mMNeat7extView2.aw(com.tencent.mm.pluginsdk.ui.span.l.j(context, str, (int) mMNeat7extView.getTextSize()));
        AppMethodBeat.o(230723);
        return inflate;
    }
}
