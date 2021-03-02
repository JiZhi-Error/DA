package com.tencent.mm.plugin.kidswatch.ui.login;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.q;
import com.tencent.mm.plugin.kidswatch.b.a;
import com.tencent.mm.plugin.kidswatch.model.KidsWatchAcctInfo;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.widget.RoundCornerImageView;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u0012\u001a\u00020\u0013J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\u000e\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u0010J\b\u0010\u0016\u001a\u00020\u0013H\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/kidswatch/ui/login/KidsWatchCardLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "imageLoaderOptionsBuilder", "Lcom/tencent/mm/modelimage/loader/cfg/ImageLoaderOptions$Builder;", "isLogin", "", "kidsAcctInfo", "Lcom/tencent/mm/plugin/kidswatch/model/KidsWatchAcctInfo;", "radius", "markLastCard", "", "prepareViews", "setData", "updateLoginStatus", "plugin-kidswatch_release"})
public final class KidsWatchCardLayout extends LinearLayout {
    private HashMap _$_findViewCache;
    private final int radius;
    boolean sPq;
    private KidsWatchAcctInfo yAY;
    private final c.a yAZ;

    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(256211);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(256211);
        return view;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KidsWatchCardLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(256208);
        this.radius = at.fromDPToPix(context, 16);
        this.yAZ = new c.a();
        setNestedScrollingEnabled(true);
        View.inflate(context, R.layout.axh, this);
        ((RoundCornerImageView) _$_findCachedViewById(R.id.wn)).ly(this.radius, this.radius);
        this.yAZ.ty(R.drawable.bca);
        this.yAZ.aw((float) this.radius).bdt();
        ebV();
        a aVar = a.yBL;
        Context context2 = getContext();
        p.g(context2, "context");
        a.a(context2, (LinearLayout) _$_findCachedViewById(R.id.ajm), null);
        AppMethodBeat.o(256208);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public KidsWatchCardLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        p.h(attributeSet, "attrs");
        AppMethodBeat.i(256209);
        AppMethodBeat.o(256209);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public KidsWatchCardLayout(Context context) {
        this(context, null, 0);
        p.h(context, "context");
        AppMethodBeat.i(256210);
        AppMethodBeat.o(256210);
    }

    public final void setData(KidsWatchAcctInfo kidsWatchAcctInfo) {
        AppMethodBeat.i(256206);
        p.h(kidsWatchAcctInfo, "kidsAcctInfo");
        this.yAY = kidsWatchAcctInfo;
        q.bcV().a(kidsWatchAcctInfo.iAR, (RoundCornerImageView) _$_findCachedViewById(R.id.wn), this.yAZ.bdv());
        TextView textView = (TextView) _$_findCachedViewById(R.id.fzd);
        p.g(textView, "nicknameTV");
        textView.setText(kidsWatchAcctInfo.nickName);
        this.sPq = kidsWatchAcctInfo.yAy == 1;
        TextView textView2 = (TextView) _$_findCachedViewById(R.id.bow);
        p.g(textView2, "deviceNameTV");
        textView2.setText(kidsWatchAcctInfo.deviceName);
        ebV();
        AppMethodBeat.o(256206);
    }

    private final void ebV() {
        AppMethodBeat.i(256207);
        if (this.sPq) {
            TextView textView = (TextView) _$_findCachedViewById(R.id.erd);
            p.g(textView, "loginStatusIconTV");
            textView.setBackground(com.tencent.mm.cb.a.l(getContext(), R.drawable.a9i));
            TextView textView2 = (TextView) _$_findCachedViewById(R.id.ere);
            p.g(textView2, "loginStatusTV");
            textView2.setText(getContext().getString(R.string.eap));
            AppMethodBeat.o(256207);
            return;
        }
        TextView textView3 = (TextView) _$_findCachedViewById(R.id.erd);
        p.g(textView3, "loginStatusIconTV");
        textView3.setBackground(com.tencent.mm.cb.a.l(getContext(), R.drawable.a9c));
        TextView textView4 = (TextView) _$_findCachedViewById(R.id.ere);
        p.g(textView4, "loginStatusTV");
        textView4.setText(getContext().getString(R.string.ea7));
        AppMethodBeat.o(256207);
    }
}
