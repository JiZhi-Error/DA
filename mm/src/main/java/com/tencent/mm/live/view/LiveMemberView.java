package com.tencent.mm.live.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.internal.AnalyticsEvents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.ui.at;
import java.util.Arrays;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001c\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u001c2\u0006\u0010\u001d\u001a\u00020\tR\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/live/view/LiveMemberView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "avatarGroup1", "Landroid/view/ViewGroup;", "avatarGroup2", "avatarGroup3", "avatarIcon1", "Landroid/widget/ImageView;", "avatarIcon2", "avatarIcon3", "loaderOptions", "Lcom/tencent/mm/modelimage/loader/cfg/ImageLoaderOptions;", "memberCountTv", "Landroid/widget/TextView;", "updateMemberInfo", "", "headImgList", "", "onlineCount", "plugin-logic_release"})
public final class LiveMemberView extends RelativeLayout {
    private final String TAG;
    private final ImageView hWB;
    private final ViewGroup hWC;
    private final ImageView hWD;
    private final ViewGroup hWE;
    private final ImageView hWF;
    private final ViewGroup hWG;
    private final TextView hWH;
    private c hWI;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LiveMemberView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(208563);
        this.TAG = "MicoroMSg.LiveMemberView";
        View.inflate(context, R.layout.b18, this);
        View findViewById = findViewById(R.id.ei7);
        p.g(findViewById, "findViewById(R.id.live_member_avatar_icon1)");
        this.hWB = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.ei8);
        p.g(findViewById2, "findViewById(R.id.live_member_avatar_icon2)");
        this.hWD = (ImageView) findViewById2;
        View findViewById3 = findViewById(R.id.ei9);
        p.g(findViewById3, "findViewById(R.id.live_member_avatar_icon3)");
        this.hWF = (ImageView) findViewById3;
        View findViewById4 = findViewById(R.id.ei_);
        p.g(findViewById4, "findViewById(R.id.live_member_avatar_icon_group1)");
        this.hWC = (ViewGroup) findViewById4;
        View findViewById5 = findViewById(R.id.eia);
        p.g(findViewById5, "findViewById(R.id.live_member_avatar_icon_group2)");
        this.hWE = (ViewGroup) findViewById5;
        View findViewById6 = findViewById(R.id.eib);
        p.g(findViewById6, "findViewById(R.id.live_member_avatar_icon_group3)");
        this.hWG = (ViewGroup) findViewById6;
        View findViewById7 = findViewById(R.id.eid);
        p.g(findViewById7, "findViewById(R.id.live_member_count_tv)");
        this.hWH = (TextView) findViewById7;
        setPadding(at.fromDPToPix(context, 4), at.fromDPToPix(context, 4), at.fromDPToPix(context, 4), at.fromDPToPix(context, 4));
        setBackground(context.getResources().getDrawable(R.drawable.acy));
        TextView textView = this.hWH;
        ae aeVar = ae.SYK;
        String string = context.getResources().getString(R.string.egr);
        p.g(string, "context.resources.getStr…string.live_member_count)");
        String format = String.format(string, Arrays.copyOf(new Object[]{0}, 1));
        p.g(format, "java.lang.String.format(format, *args)");
        textView.setText(format);
        c.a aVar = new c.a();
        aVar.ty(R.raw.default_avatar);
        this.hWI = aVar.bdv();
        AppMethodBeat.o(208563);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public LiveMemberView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        p.h(attributeSet, "attrs");
        AppMethodBeat.i(208564);
        AppMethodBeat.o(208564);
    }
}
