package com.tencent.mm.plugin.story.ui.view.gallery;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.au;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryHeaderView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "avatarIv", "Landroid/widget/ImageView;", "getAvatarIv", "()Landroid/widget/ImageView;", "setAvatarIv", "(Landroid/widget/ImageView;)V", "nickNameTv", "Landroid/widget/TextView;", "getNickNameTv", "()Landroid/widget/TextView;", "setNickNameTv", "(Landroid/widget/TextView;)V", "setUserName", "", "user", "", "plugin-story_release"})
public final class GalleryHeaderView extends RelativeLayout {
    private ImageView gyr;
    private TextView kcZ;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GalleryHeaderView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(120333);
        View.inflate(context, R.layout.c06, this);
        this.gyr = (ImageView) findViewById(R.id.x1);
        this.kcZ = (TextView) findViewById(R.id.fzg);
        setPadding(0, 0, 0, au.aD(context));
        AppMethodBeat.o(120333);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GalleryHeaderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        AppMethodBeat.i(120334);
        AppMethodBeat.o(120334);
    }

    public final ImageView getAvatarIv() {
        return this.gyr;
    }

    public final void setAvatarIv(ImageView imageView) {
        this.gyr = imageView;
    }

    public final TextView getNickNameTv() {
        return this.kcZ;
    }

    public final void setNickNameTv(TextView textView) {
        this.kcZ = textView;
    }

    public final void setUserName(String str) {
        AppMethodBeat.i(120332);
        if (str != null) {
            a af = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
            p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
            as Kn = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).aSN().Kn(str);
            TextView textView = this.kcZ;
            if (textView != null) {
                Context context = getContext();
                p.g(Kn, "contact");
                textView.setText(com.tencent.mm.pluginsdk.ui.span.l.b(context, Kn.arJ(), textView.getTextSize()));
            }
            a.b.d(this.gyr, str, 0.5f);
        }
        AppMethodBeat.o(120332);
    }
}
