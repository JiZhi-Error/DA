package com.tencent.mm.plugin.taskbar.ui.section.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.SpannableString;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.loader.e.d;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.plugin.finder.storage.x;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.taskbar.ui.section.g;
import com.tencent.mm.plugin.taskbar.ui.section.other.a;
import com.tencent.mm.plugin.taskbar.ui.section.other.b;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.aws;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/taskbar/ui/section/live/TaskBarSectionOtherViewLiveHelper;", "Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherViewBaseHelper;", "callback", "Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherViewBaseHelper$Callback;", "(Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherViewBaseHelper$Callback;)V", "getDefaultImageRes", "", "data", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "getSubtitle", "", "onBindViewHolder", "", "pos", "viewHolder", "Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherView$BaseViewHolder;", "viewModel", "Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionViewModel;", "plugin-taskbar_release"})
public final class a extends b {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(b.a aVar) {
        super(aVar);
        p.h(aVar, "callback");
        AppMethodBeat.i(263606);
        AppMethodBeat.o(263606);
    }

    @Override // com.tencent.mm.plugin.taskbar.ui.section.other.b
    public final void a(int i2, a.b bVar, g gVar) {
        boolean z;
        String str;
        FinderMedia finderMedia;
        String str2;
        String str3;
        LinkedList<FinderMedia> linkedList;
        String str4;
        AppMethodBeat.i(263603);
        p.h(bVar, "viewHolder");
        p.h(gVar, "viewModel");
        super.a(i2, bVar, gVar);
        aws aws = new aws();
        try {
            aws.parseFrom(gVar.FVI.get(i2).field_data);
        } catch (Throwable th) {
            Log.e("MicroMsg.TaskBarSectionLiveView", "FinderLiveMultiTaskData parse fail", th);
        }
        if (aws.tuO == null) {
            AppMethodBeat.o(263603);
            return;
        }
        View view = bVar.aus;
        p.g(view, "viewHolder.itemView");
        Context context = view.getContext();
        FinderObject finderObject = aws.tuO;
        if (finderObject == null) {
            p.hyc();
        }
        p.g(finderObject, "data.finderObject!!");
        FinderContact finderContact = finderObject.contact;
        String str5 = (finderContact == null || (str4 = finderContact.nickname) == null) ? "" : str4;
        if (str5.length() > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            SpannableString c2 = com.tencent.mm.pluginsdk.ui.span.l.c(context, ((CharSequence) str5) + com.tencent.mm.cb.a.aI(context, R.string.j7u));
            p.g(c2, "MMSpanManager.spanForSmi…_subtitle_live_suffix)}\")");
            str = c2;
        } else {
            str = str5;
        }
        TextView textView = bVar.hbb;
        p.g(textView, "viewHolder.title");
        textView.setText(str);
        FinderObjectDesc finderObjectDesc = finderObject.objectDesc;
        if (finderObjectDesc == null || (linkedList = finderObjectDesc.media) == null) {
            finderMedia = null;
        } else {
            finderMedia = (FinderMedia) j.kt(linkedList);
        }
        if (finderMedia == null || (str2 = finderMedia.coverUrl) == null) {
            str2 = "";
        }
        p.g(str2, "firstMedia?.coverUrl ?: \"\"");
        if (finderMedia != null) {
            str3 = finderMedia.thumbUrl;
        } else {
            str3 = null;
        }
        String I = p.I(str3, Util.nullAsNil(finderMedia != null ? finderMedia.thumb_url_token : null));
        if (!Util.isNullOrNil(str2)) {
            I = str2;
        }
        bVar.image.setImageBitmap(null);
        m mVar = m.uJa;
        com.tencent.mm.loader.b<o, Bitmap> a2 = m.djY().bQ(new com.tencent.mm.plugin.finder.loader.p(I, x.FULL_IMAGE)).a(new d(null, null, 3));
        m mVar2 = m.uJa;
        com.tencent.mm.loader.b<o, Bitmap> a3 = a2.a(m.a(m.a.TIMELINE));
        ImageView imageView = bVar.image;
        p.g(imageView, "viewHolder.image");
        a3.c(imageView);
        awe awe = finderObject.liveInfo;
        int i3 = awe != null ? awe.liveStatus : 2;
        Log.i("MicroMsg.TaskBarSectionOtherViewBaseHelper", "onBind live " + i3 + ' ' + str);
        if (i3 == 1) {
            View view2 = bVar.Vca;
            p.g(view2, "viewHolder.liveWidget");
            view2.setVisibility(0);
            View view3 = bVar.Vcb;
            p.g(view3, "viewHolder.liveEndWidget");
            view3.setVisibility(8);
            AppMethodBeat.o(263603);
            return;
        }
        View view4 = bVar.Vca;
        p.g(view4, "viewHolder.liveWidget");
        view4.setVisibility(8);
        View view5 = bVar.Vcb;
        p.g(view5, "viewHolder.liveEndWidget");
        view5.setVisibility(0);
        com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(aj.class);
        p.g(ah, "MMKernel.plugin(IPluginFinder::class.java)");
        ((aj) ah).getFinderUtilApi().g(bVar.image, I);
        AppMethodBeat.o(263603);
    }

    @Override // com.tencent.mm.plugin.taskbar.ui.section.other.b
    public final String o(MultiTaskInfo multiTaskInfo) {
        AppMethodBeat.i(263604);
        String aI = com.tencent.mm.cb.a.aI(MMApplicationContext.getContext(), R.string.j7t);
        p.g(aI, "ResourceHelper.getString…ar_section_subtitle_live)");
        AppMethodBeat.o(263604);
        return aI;
    }

    @Override // com.tencent.mm.plugin.taskbar.ui.section.other.b
    public final int u(MultiTaskInfo multiTaskInfo) {
        AppMethodBeat.i(263605);
        p.h(multiTaskInfo, "data");
        AppMethodBeat.o(263605);
        return R.drawable.cw1;
    }
}
