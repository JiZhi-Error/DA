package com.tencent.mm.plugin.sns.i;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.secdata.d;
import com.tencent.mm.plugin.secdata.f;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.widget.SnsCommentCollapseLayout;
import com.tencent.mm.protocal.protobuf.dzo;
import com.tencent.mm.protocal.protobuf.egl;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/sns/reportflow/SnsTagSearchSpanClickReportFlow;", "", "()V", "Companion", "plugin-sns_release"})
public final class a {
    public static final C1715a DRI = new C1715a((byte) 0);
    private static final String TAG = TAG;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\r\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fJ&\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0014J\u001e\u0010\u0015\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0018J\u0016\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018J \u0010\u001a\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0012R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/plugin/sns/reportflow/SnsTagSearchSpanClickReportFlow$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "onDetailPageDescSpanBindView", "", "snsInfo", "Lcom/tencent/mm/plugin/sns/storage/SnsInfo;", "view", "Landroid/view/View;", "onItemCommentSpanBindView", FFmpegMetadataRetriever.METADATA_KEY_COMMENT, "Lcom/tencent/mm/protocal/protobuf/SnsCommentInfo;", "onItemCommentSpanGenerate", "context", "Landroid/content/Context;", "scene", "", "onItemDescSpanBindView", "childViewId", "struct", "Lcom/tencent/mm/plugin/sns/ui/SnsTimeLineVendingStruct;", "onItemDescSpanGenerate", "onSnsSingleTextViewBindView", "commentInfo", "registerReporterData", "plugin-sns_release"})
    /* renamed from: com.tencent.mm.plugin.sns.i.a$a  reason: collision with other inner class name */
    public static final class C1715a {
        private C1715a() {
        }

        public /* synthetic */ C1715a(byte b2) {
            this();
        }

        public static void gZ(Context context) {
            AppMethodBeat.i(201802);
            p.h(context, "context");
            SecDataUIC.a aVar = SecDataUIC.CWq;
            SecDataUIC gU = SecDataUIC.a.gU(context);
            if (gU != null) {
                gU.a(new d());
                AppMethodBeat.o(201802);
                return;
            }
            AppMethodBeat.o(201802);
        }

        public static void a(Context context, dzo dzo, SnsInfo snsInfo, int i2) {
            f eSr;
            AppMethodBeat.i(201803);
            p.h(context, "context");
            p.h(dzo, FFmpegMetadataRetriever.METADATA_KEY_COMMENT);
            p.h(snsInfo, "snsInfo");
            egl egl = new egl();
            egl.Ngu = r.a(dzo) ? 5 : 4;
            egl.Ngv = snsInfo.getUserName() + "#" + r.Jb(snsInfo.field_snsId) + "#" + dzo.Username + "#" + dzo.MYT;
            egl.KMc = (long) dzo.CreateTime;
            egl.Ngw = i2 == 2 ? 3 : 1;
            egl.Ngx = snsInfo.field_type;
            egl.Ngy = snsInfo.localid;
            SecDataUIC.a aVar = SecDataUIC.CWq;
            SecDataUIC gU = SecDataUIC.a.gU(context);
            if (!(gU == null || (eSr = gU.eSr()) == null)) {
                eSr.c("Comment_" + dzo.hashCode(), egl);
            }
            Log.i(a.TAG, "onItemCommentSpanGenerate Comment_" + dzo.hashCode());
            AppMethodBeat.o(201803);
        }

        public static void a(View view, dzo dzo) {
            f eSr;
            f eSr2;
            f eSr3;
            AppMethodBeat.i(201804);
            p.h(view, "view");
            p.h(dzo, FFmpegMetadataRetriever.METADATA_KEY_COMMENT);
            if (view instanceof SnsCommentCollapseLayout) {
                SecDataUIC.a aVar = SecDataUIC.CWq;
                Context context = ((SnsCommentCollapseLayout) view).getContext();
                p.g(context, "view.context");
                SecDataUIC gU = SecDataUIC.a.gU(context);
                if (!(gU == null || (eSr3 = gU.eSr()) == null)) {
                    eSr3.jS("Comment_" + dzo.hashCode(), String.valueOf(((SnsCommentCollapseLayout) view).getNormalCommentTv().hashCode()));
                }
                SecDataUIC.a aVar2 = SecDataUIC.CWq;
                Context context2 = ((SnsCommentCollapseLayout) view).getContext();
                p.g(context2, "view.context");
                SecDataUIC gU2 = SecDataUIC.a.gU(context2);
                if (gU2 == null || (eSr2 = gU2.eSr()) == null) {
                    AppMethodBeat.o(201804);
                    return;
                }
                eSr2.jS("Comment_" + dzo.hashCode(), String.valueOf(((SnsCommentCollapseLayout) view).get2LineCommentTv().hashCode()));
                AppMethodBeat.o(201804);
                return;
            }
            if (view instanceof TextView) {
                SecDataUIC.a aVar3 = SecDataUIC.CWq;
                Context context3 = ((TextView) view).getContext();
                p.g(context3, "view.context");
                SecDataUIC gU3 = SecDataUIC.a.gU(context3);
                if (!(gU3 == null || (eSr = gU3.eSr()) == null)) {
                    eSr.jS("Comment_" + dzo.hashCode(), String.valueOf(view.hashCode()));
                }
                Log.i(a.TAG, "onItemCommentSpanBindView Comment_" + dzo.hashCode() + ' ' + view.hashCode());
            }
            AppMethodBeat.o(201804);
        }

        public static void a(SnsInfo snsInfo, View view) {
            f eSr;
            AppMethodBeat.i(201805);
            p.h(snsInfo, "snsInfo");
            p.h(view, "view");
            egl egl = new egl();
            egl.Ngu = 3;
            egl.Ngv = snsInfo.getUserName() + "#" + r.Jb(snsInfo.field_snsId);
            egl.KMc = (long) snsInfo.field_createTime;
            egl.Ngw = 3;
            egl.Ngx = snsInfo.field_type;
            SecDataUIC.a aVar = SecDataUIC.CWq;
            Context context = view.getContext();
            p.g(context, "view.context");
            SecDataUIC gU = SecDataUIC.a.gU(context);
            if (gU == null || (eSr = gU.eSr()) == null) {
                AppMethodBeat.o(201805);
                return;
            }
            eSr.c(String.valueOf(view.hashCode()), egl);
            AppMethodBeat.o(201805);
        }
    }

    static {
        AppMethodBeat.i(201806);
        AppMethodBeat.o(201806);
    }
}
