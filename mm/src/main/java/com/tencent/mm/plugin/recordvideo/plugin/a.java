package com.tencent.mm.plugin.recordvideo.plugin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.api.ac;
import com.tencent.mm.api.ad;
import com.tencent.mm.api.r;
import com.tencent.mm.emoji.b.b.n;
import com.tencent.mm.plugin.recordvideo.d.c;
import com.tencent.mm.plugin.recordvideo.e.e;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.ar;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u0016J\n\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\u0012\u0010\u001e\u001a\u00020\u00162\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010!\u001a\u00020\u0016H\u0016J\u0010\u0010\"\u001a\u00020\u00162\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020\u00162\u0006\u0010&\u001a\u00020$H\u0016J\u0006\u0010'\u001a\u00020\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006("}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddEmojiPlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseIconPlugin;", "parent", "Landroid/view/ViewGroup;", "view", "Landroid/widget/ImageView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Landroid/widget/ImageView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "emojiPanel", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/panel/EditorEmojiPanel;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getView", "()Landroid/widget/ImageView;", "setView", "(Landroid/widget/ImageView;)V", "addExternalPanel", "", "externalPanelDataProvider", "Lcom/tencent/mm/emoji/model/panel/ExternalPanelDataProvider;", "hideEmojiPanel", "name", "", "onBackPress", "", "onClick", "v", "Landroid/view/View;", "release", "resetIconColor", "iconColor", "", "setVisibility", "visibility", "showEmojiPanel", "plugin-recordvideo_release"})
public final class a implements View.OnClickListener, t {
    private final com.tencent.mm.plugin.recordvideo.ui.editor.a.a BPP;
    private ImageView tkI;
    d wgr;

    public a(ViewGroup viewGroup, ImageView imageView, d dVar) {
        p.h(viewGroup, "parent");
        p.h(imageView, "view");
        p.h(dVar, "status");
        AppMethodBeat.i(75458);
        this.tkI = imageView;
        this.wgr = dVar;
        this.tkI.setOnClickListener(this);
        this.tkI.setImageDrawable(ar.m(this.tkI.getContext(), R.raw.icons_filled_sticker, -1));
        Context context = viewGroup.getContext();
        p.g(context, "parent.context");
        this.BPP = new com.tencent.mm.plugin.recordvideo.ui.editor.a.a(context, viewGroup);
        this.BPP.Ccp = new b<Boolean, x>(this) {
            /* class com.tencent.mm.plugin.recordvideo.plugin.a.AnonymousClass1 */
            final /* synthetic */ a BPQ;

            {
                this.BPQ = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(Boolean bool) {
                AppMethodBeat.i(75451);
                if (bool.booleanValue()) {
                    d.b.a(this.BPQ.wgr, d.c.BUT);
                } else {
                    d.b.a(this.BPQ.wgr, d.c.BVj);
                }
                x xVar = x.SXb;
                AppMethodBeat.o(75451);
                return xVar;
            }
        };
        com.tencent.mm.plugin.recordvideo.ui.editor.a.a aVar = this.BPP;
        AnonymousClass2 r0 = new ac.a(this) {
            /* class com.tencent.mm.plugin.recordvideo.plugin.a.AnonymousClass2 */
            final /* synthetic */ a BPQ;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.BPQ = r1;
            }

            @Override // com.tencent.mm.api.ac.a
            public final void a(r rVar) {
                AppMethodBeat.i(75452);
                p.h(rVar, "emojiInfo");
                Log.i("MicroMsg.EditorVideoPluginLayoutNew", "[onSelectedEmoji] emojiInfo:%s", rVar);
                Bundle bundle = new Bundle();
                bundle.putParcelable("PARAM_EDIT_EMOJI_INFO", (EmojiInfo) rVar);
                this.BPQ.wgr.a(d.c.BWl, bundle);
                onHide();
                AppMethodBeat.o(75452);
            }

            @Override // com.tencent.mm.api.ac.a
            public final void onHide() {
                AppMethodBeat.i(75453);
                this.BPQ.BPP.setShow(false);
                AppMethodBeat.o(75453);
            }
        };
        p.h(r0, "callback");
        ac VK = ad.VK();
        p.g(VK, "callbackWrapper");
        VK.a(r0);
        aVar.hee.setCallback(VK);
        e eVar = e.Cit;
        e.a(this.BPP);
        AppMethodBeat.o(75458);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void aSs() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onActivityResult(int i2, int i3, Intent intent) {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onDetach() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onPause() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(237266);
        p.h(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        p.h(iArr, "grantResults");
        t.a.a(strArr, iArr);
        AppMethodBeat.o(237266);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onResume() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void reset() {
    }

    public final void onClick(View view) {
        AppMethodBeat.i(75454);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/plugin/EditAddEmojiPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        this.BPP.setShow(true);
        c cVar = c.BXI;
        c.aLu("KEY_CLICK_EMOJI_COUNT_INT");
        c cVar2 = c.BXI;
        c.VH(4);
        c cVar3 = c.BXI;
        c.VI(6);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/EditAddEmojiPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(75454);
    }

    public final void a(n nVar) {
        AppMethodBeat.i(237262);
        p.h(nVar, "externalPanelDataProvider");
        com.tencent.mm.plugin.recordvideo.ui.editor.a.a aVar = this.BPP;
        p.h(nVar, "externalPanelDataProvider");
        aVar.hee.a(nVar);
        AppMethodBeat.o(237262);
    }

    public final void eKm() {
        AppMethodBeat.i(237263);
        this.BPP.setShow(true);
        AppMethodBeat.o(237263);
    }

    public final void efU() {
        AppMethodBeat.i(237264);
        this.BPP.setShow(false);
        AppMethodBeat.o(237264);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void release() {
        AppMethodBeat.i(75455);
        this.BPP.hee.destroy();
        AppMethodBeat.o(75455);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final boolean onBackPress() {
        boolean z;
        AppMethodBeat.i(75456);
        if (this.BPP.hed.getVisibility() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            this.BPP.setShow(false);
            AppMethodBeat.o(75456);
            return true;
        }
        AppMethodBeat.o(75456);
        return false;
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final String name() {
        return "plugin_emoji";
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void setVisibility(int i2) {
        AppMethodBeat.i(75457);
        this.tkI.setVisibility(i2);
        AppMethodBeat.o(75457);
    }

    public final void VC(int i2) {
        AppMethodBeat.i(237265);
        this.tkI.setImageDrawable(ar.m(this.tkI.getContext(), R.raw.icons_filled_sticker, i2));
        AppMethodBeat.o(237265);
    }
}
