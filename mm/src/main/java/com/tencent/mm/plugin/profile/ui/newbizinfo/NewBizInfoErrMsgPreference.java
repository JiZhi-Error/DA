package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.MMNeat7extView;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0017H\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R$\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X.¢\u0006\u0002\n\u0000¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoErrMsgPreference;", "Lcom/tencent/mm/ui/base/preference/Preference;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bindView", "", "value", "", "errMsg", "getErrMsg", "()Ljava/lang/String;", "setErrMsg", "(Ljava/lang/String;)V", "errMsgTv", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "onBindView", "", "view", "Landroid/view/View;", "setText", "app_release"})
public final class NewBizInfoErrMsgPreference extends Preference {
    private MMNeat7extView Bjq;
    private String errMsg = "";
    private boolean rFe;

    public NewBizInfoErrMsgPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public NewBizInfoErrMsgPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(39608);
        p.h(view, "view");
        super.onBindView(view);
        View findViewById = view.findViewById(R.id.a5k);
        MMNeat7extView mMNeat7extView = (MMNeat7extView) findViewById;
        mMNeat7extView.setTextSize(1, 16.0f);
        mMNeat7extView.setTextColor(mMNeat7extView.getResources().getColor(R.color.u7));
        p.g(findViewById, "view.findViewById<MMNeat…ey_text_color))\n        }");
        this.Bjq = (MMNeat7extView) findViewById;
        this.rFe = true;
        eFf();
        AppMethodBeat.o(39608);
    }

    private final void eFf() {
        AppMethodBeat.i(39609);
        MMNeat7extView mMNeat7extView = this.Bjq;
        if (mMNeat7extView == null) {
            p.btv("errMsgTv");
        }
        mMNeat7extView.aw(com.tencent.mm.pluginsdk.ui.span.l.j(mMNeat7extView.getContext(), this.errMsg, (int) mMNeat7extView.getTextSize()));
        AppMethodBeat.o(39609);
    }

    public final void setErrMsg(String str) {
        AppMethodBeat.i(39610);
        p.h(str, "value");
        this.errMsg = str;
        if (this.rFe) {
            eFf();
        }
        AppMethodBeat.o(39610);
    }
}
