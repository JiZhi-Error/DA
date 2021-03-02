package com.tencent.mm.plugin.kidswatch.model;

import android.view.View;
import com.tencent.mm.pluginsdk.ui.applet.u;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0012\u0010\u000e\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH&R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/kidswatch/model/KidsWatchAvoidDuplicatedPressableSpan;", "Lcom/tencent/mm/pluginsdk/ui/span/PressableClickSpan;", "()V", "colorConfig", "", "hrefInfo", "Lcom/tencent/mm/pluginsdk/ui/applet/HrefInfo;", "(ILcom/tencent/mm/pluginsdk/ui/applet/HrefInfo;)V", "mLastClickTicks", "", "onClick", "", "widget", "Landroid/view/View;", "onClickImp", "Companion", "plugin-kidswatch_release"})
public abstract class a extends p {
    public static final C1452a yAA = new C1452a((byte) 0);
    private long yAz = -1;

    public abstract void ebS();

    public a() {
        super(1, (u) null);
    }

    @Override // com.tencent.mm.pluginsdk.ui.span.p
    public void onClick(View view) {
        kotlin.g.b.p.h(view, "widget");
        if (Util.ticksToNow(this.yAz) > 1000) {
            super.onClick(view);
            ebS();
        } else {
            Log.w("MicroMsg.AvoidDuplicatedPressableSpan", "hy: too often click");
            setIsPressed(false);
        }
        this.yAz = Util.currentTicks();
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/kidswatch/model/KidsWatchAvoidDuplicatedPressableSpan$Companion;", "", "()V", "MIN_TWEEN", "", "TAG", "", "plugin-kidswatch_release"})
    /* renamed from: com.tencent.mm.plugin.kidswatch.model.a$a  reason: collision with other inner class name */
    public static final class C1452a {
        private C1452a() {
        }

        public /* synthetic */ C1452a(byte b2) {
            this();
        }
    }
}
