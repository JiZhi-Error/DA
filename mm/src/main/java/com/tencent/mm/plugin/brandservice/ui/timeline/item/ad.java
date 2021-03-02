package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.view.View;
import com.facebook.internal.AnalyticsEvents;
import com.tencent.mm.storage.z;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\b&\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J(\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H&J\b\u0010\u0014\u001a\u00020\u0004H\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0004H\u0016J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0019\u001a\u00020\nH\u0016J\u0010\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0012H&J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u0018\u0010\u001d\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u0000H\u0016J\u0010\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u0004H\u0016J\b\u0010!\u001a\u00020\nH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006#"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardTmpl;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BaseBizTimeViewHolder;", "()V", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "", "getStyle", "()I", "setStyle", "(I)V", "clickCard", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "extra", "", "filling", "position", "convertView", "Landroid/view/View;", "parent", "getCardType", "getVideoRelativePos", "", "getVideoStatus", "getVideoView", "gone", "inflate", "isVideoCard", "", "registerCard", "cardTmpl", "setVideoStatus", "status", "show", "PlayStatus", "plugin-brandservice_release"})
public abstract class ad extends a {
    public static final a pwU = new a((byte) 0);
    private int style = -1;

    public abstract void a(z zVar, int i2, View view, View view2);

    public void cmO() {
    }

    public void show() {
    }

    public int getStyle() {
        return this.style;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardTmpl$PlayStatus;", "", "()V", "PAUSE", "", "PLAY", "STOP", "plugin-brandservice_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public void a(z zVar, ad adVar) {
        p.h(zVar, "info");
        p.h(adVar, "cardTmpl");
    }

    public boolean cmS() {
        return false;
    }

    public View getVideoView() {
        return null;
    }

    public void setVideoStatus(int i2) {
    }

    public void a(z zVar, String str) {
        p.h(zVar, "info");
        p.h(str, "extra");
    }
}
