package com.tencent.mm.plugin.story.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.internal.AnalyticsEvents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.storage.as;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\tR\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/view/StoryAvatarItemView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "avatarIv", "Landroid/widget/ImageView;", "dp_2", "nameTv", "Landroid/widget/TextView;", "unreadTip", "setAvatar", "", ch.COL_USERNAME, "", "setTipCount", "count", "plugin-story_release"})
public final class StoryAvatarItemView extends RelativeLayout {
    private final int FBA = a.fromDPToPix(getContext(), 2);
    private TextView FBB;
    private TextView gxs;
    private ImageView gyr;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StoryAvatarItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        p.h(attributeSet, "attributeSet");
        AppMethodBeat.i(120084);
        View.inflate(getContext(), R.layout.bza, this);
        View findViewById = findViewById(R.id.i7b);
        p.g(findViewById, "findViewById(R.id.story_avatar_item_iv)");
        this.gyr = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.i7c);
        p.g(findViewById2, "findViewById(R.id.story_avatar_item_name_tv)");
        this.gxs = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.i7d);
        p.g(findViewById3, "findViewById(R.id.story_avatar_item_unread_tip)");
        this.FBB = (TextView) findViewById3;
        AppMethodBeat.o(120084);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StoryAvatarItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        p.h(attributeSet, "attributeSet");
        AppMethodBeat.i(120085);
        View.inflate(getContext(), R.layout.bza, this);
        View findViewById = findViewById(R.id.i7b);
        p.g(findViewById, "findViewById(R.id.story_avatar_item_iv)");
        this.gyr = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.i7c);
        p.g(findViewById2, "findViewById(R.id.story_avatar_item_name_tv)");
        this.gxs = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.i7d);
        p.g(findViewById3, "findViewById(R.id.story_avatar_item_unread_tip)");
        this.FBB = (TextView) findViewById3;
        AppMethodBeat.o(120085);
    }

    public final void setAvatar(String str) {
        String arJ;
        AppMethodBeat.i(120082);
        p.h(str, ch.COL_USERNAME);
        a.b.d(this.gyr, str, 0.5f);
        this.gyr.setBackground(getResources().getDrawable(R.drawable.awo));
        this.gyr.setPadding(this.FBA, this.FBA, this.FBA, this.FBA);
        com.tencent.mm.kernel.c.a af = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
        p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
        as Kn = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).aSN().Kn(str);
        this.gxs.setText(com.tencent.mm.pluginsdk.ui.span.l.b(getContext(), (Kn == null || (arJ = Kn.arJ()) == null) ? "" : arJ, this.gxs.getTextSize()));
        AppMethodBeat.o(120082);
    }

    public final void setTipCount(int i2) {
        AppMethodBeat.i(120083);
        if (i2 <= 0) {
            this.FBB.setVisibility(8);
            AppMethodBeat.o(120083);
            return;
        }
        this.FBB.setText(String.valueOf(i2));
        this.FBB.setVisibility(0);
        AppMethodBeat.o(120083);
    }
}
