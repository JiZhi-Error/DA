package com.tencent.mm.plugin.taskbar.ui.section.d;

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
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.taskbar.ui.section.g;
import com.tencent.mm.plugin.taskbar.ui.section.other.a;
import com.tencent.mm.plugin.taskbar.ui.section.other.b;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.cnu;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/taskbar/ui/section/video/TaskBarSectionOtherViewVideoHelper;", "Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherViewBaseHelper;", "callback", "Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherViewBaseHelper$Callback;", "(Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherViewBaseHelper$Callback;)V", "getDefaultImageRes", "", "data", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "getSubtitle", "", "onBindViewHolder", "", "pos", "viewHolder", "Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherView$BaseViewHolder;", "viewModel", "Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionViewModel;", "plugin-taskbar_release"})
public final class a extends b {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(b.a aVar) {
        super(aVar);
        p.h(aVar, "callback");
        AppMethodBeat.i(263641);
        AppMethodBeat.o(263641);
    }

    @Override // com.tencent.mm.plugin.taskbar.ui.section.other.b
    public final void a(int i2, a.b bVar, g gVar) {
        FinderMedia finderMedia;
        String str;
        String str2;
        FinderObjectDesc finderObjectDesc;
        LinkedList<FinderMedia> linkedList;
        String str3;
        boolean z = true;
        AppMethodBeat.i(263638);
        p.h(bVar, "viewHolder");
        p.h(gVar, "viewModel");
        super.a(i2, bVar, gVar);
        cnu cnu = new cnu();
        try {
            cnu.parseFrom(gVar.FVI.get(i2).field_data);
        } catch (Throwable th) {
            Log.e("AppBrandDesktopSectionVideoView", "MegaVideoFloatBallInfo parse fail", th);
        }
        if (cnu.Muf.isEmpty()) {
            AppMethodBeat.o(263638);
            return;
        }
        View view = bVar.aus;
        p.g(view, "viewHolder.itemView");
        Context context = view.getContext();
        FinderObject finderObject = cnu.Muf.get(0);
        FinderContact finderContact = finderObject.contact;
        String str4 = (finderContact == null || (str3 = finderContact.nickname) == null) ? "" : str3;
        if (str4.length() <= 0) {
            z = false;
        }
        if (z) {
            SpannableString c2 = com.tencent.mm.pluginsdk.ui.span.l.c(context, str4 + com.tencent.mm.cb.a.aI(context, R.string.j7y));
            p.g(c2, "MMSpanManager.spanForSmi…subtitle_video_suffix)}\")");
            str4 = c2;
        }
        TextView textView = bVar.hbb;
        p.g(textView, "viewHolder.title");
        textView.setText(str4);
        if (finderObject == null || (finderObjectDesc = finderObject.objectDesc) == null || (linkedList = finderObjectDesc.media) == null) {
            finderMedia = null;
        } else {
            finderMedia = linkedList.getFirst();
        }
        if (finderMedia == null || (str = finderMedia.coverUrl) == null) {
            str = "";
        }
        p.g(str, "finderMedia?.coverUrl ?: \"\"");
        if (finderMedia != null) {
            str2 = finderMedia.thumbUrl;
        } else {
            str2 = null;
        }
        String I = p.I(str2, Util.nullAsNil(finderMedia != null ? finderMedia.thumb_url_token : null));
        if (Util.isNullOrNil(str)) {
            str = I;
        }
        ImageView imageView = bVar.image;
        imageView.setImageBitmap(null);
        m mVar = m.uJa;
        com.tencent.mm.loader.b<o, Bitmap> a2 = m.djY().bQ(new com.tencent.mm.plugin.finder.loader.p(str, x.FULL_IMAGE)).a(new d(null, null, 3));
        m mVar2 = m.uJa;
        com.tencent.mm.loader.b<o, Bitmap> a3 = a2.a(m.a(m.a.TIMELINE));
        p.g(imageView, LocaleUtil.ITALIAN);
        a3.c(imageView);
        ImageView imageView2 = bVar.EsM;
        p.g(imageView2, "viewHolder.playBtn");
        imageView2.setVisibility(0);
        AppMethodBeat.o(263638);
    }

    @Override // com.tencent.mm.plugin.taskbar.ui.section.other.b
    public final String o(MultiTaskInfo multiTaskInfo) {
        AppMethodBeat.i(263639);
        String aI = com.tencent.mm.cb.a.aI(MMApplicationContext.getContext(), R.string.j7x);
        p.g(aI, "ResourceHelper.getString…r_section_subtitle_video)");
        AppMethodBeat.o(263639);
        return aI;
    }

    @Override // com.tencent.mm.plugin.taskbar.ui.section.other.b
    public final int u(MultiTaskInfo multiTaskInfo) {
        AppMethodBeat.i(263640);
        p.h(multiTaskInfo, "data");
        AppMethodBeat.o(263640);
        return R.drawable.cw4;
    }
}
