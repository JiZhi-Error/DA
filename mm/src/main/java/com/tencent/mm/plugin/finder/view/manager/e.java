package com.tencent.mm.plugin.finder.view.manager;

import android.content.Context;
import android.text.Spannable;
import android.text.style.ForegroundColorSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.utils.w;
import com.tencent.mm.plugin.finder.view.FinderPostEditText;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J.\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00180\u0017j\b\u0012\u0004\u0012\u00020\u0018`\u0019R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/manager/FinderTopicSuggestManager;", "", "descTv", "Lcom/tencent/mm/plugin/finder/view/FinderPostEditText;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/plugin/finder/view/FinderPostEditText;Lcom/tencent/mm/ui/MMActivity;)V", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "curTopicInfoList", "", "Lcom/tencent/mm/plugin/finder/utils/FinderTopicUtil$TopicStringInfo;", "getCurTopicInfoList", "()Ljava/util/List;", "getDescTv", "()Lcom/tencent/mm/plugin/finder/view/FinderPostEditText;", "extractTopicAndSetSpan", "", "curDesc", "", "s", "Landroid/text/Editable;", "atStringInfoList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/utils/FinderAtUtil$AtStringInfo;", "Lkotlin/collections/ArrayList;", "Companion", "plugin-finder_release"})
public final class e {
    private static final String TAG = TAG;
    public static final a wtu = new a((byte) 0);
    private final MMActivity activity;
    private final FinderPostEditText vQR;
    public final List<w.c> wtt = new ArrayList();

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "start", "", "end", "invoke"})
    public static final class b extends q implements m<Integer, Integer, x> {
        final /* synthetic */ Spannable wsN;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(Spannable spannable) {
            super(2);
            this.wsN = spannable;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(Integer num, Integer num2) {
            AppMethodBeat.i(168543);
            int intValue = num.intValue();
            int intValue2 = num2.intValue();
            Spannable spannable = this.wsN;
            Context context = MMApplicationContext.getContext();
            p.g(context, "MMApplicationContext.getContext()");
            spannable.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.x0)), intValue, intValue2, 17);
            x xVar = x.SXb;
            AppMethodBeat.o(168543);
            return xVar;
        }
    }

    public e(FinderPostEditText finderPostEditText, MMActivity mMActivity) {
        p.h(finderPostEditText, "descTv");
        p.h(mMActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(255289);
        this.vQR = finderPostEditText;
        this.activity = mMActivity;
        AppMethodBeat.o(255289);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/manager/FinderTopicSuggestManager$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(168549);
        AppMethodBeat.o(168549);
    }
}
