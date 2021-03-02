package com.tencent.mm.plugin.recordvideo.plugin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.recordvideo.activity.a.b;
import com.tencent.mm.plugin.recordvideo.b.a.a;
import com.tencent.mm.plugin.recordvideo.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.ar;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 #2\u00020\u00012\u00020\u0002:\u0001#B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\u000e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018J\"\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u000b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0012\u0010\u001e\u001a\u00020\u00152\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0010\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u000bH\u0016R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006$"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/plugin/RecordAlbumPlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "view", "Landroid/widget/ImageView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/widget/ImageView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "enable", "", "scene", "", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getView", "()Landroid/widget/ImageView;", "setView", "(Landroid/widget/ImageView;)V", "checkOnClickByScene", "", "initConfig", "config", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onClick", "v", "Landroid/view/View;", "setVisibility", "visibility", "Companion", "plugin-recordvideo_release"})
public final class u implements View.OnClickListener, t {
    public static final a BRp = new a((byte) 0);
    public boolean enable = true;
    public int scene;
    private ImageView tkI;
    private d wgr;

    static {
        AppMethodBeat.i(75612);
        AppMethodBeat.o(75612);
    }

    public u(ImageView imageView, d dVar) {
        p.h(imageView, "view");
        p.h(dVar, "status");
        AppMethodBeat.i(75611);
        this.tkI = imageView;
        this.wgr = dVar;
        this.tkI.setOnClickListener(this);
        this.tkI.setImageDrawable(ar.m(this.tkI.getContext(), R.raw.icons_filled_album, -1));
        AppMethodBeat.o(75611);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void aSs() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final String name() {
        return null;
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final boolean onBackPress() {
        return false;
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onDetach() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onPause() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(237302);
        p.h(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        p.h(iArr, "grantResults");
        t.a.a(strArr, iArr);
        AppMethodBeat.o(237302);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onResume() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void release() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void reset() {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/plugin/RecordAlbumPlugin$Companion;", "", "()V", "MEDIA_REQUEST_CODE", "", "TAG", "", "plugin-recordvideo_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void onClick(View view) {
        boolean z;
        boolean z2 = false;
        AppMethodBeat.i(75608);
        b bVar = new b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/plugin/RecordAlbumPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        Log.i("MicroMsg.RecordAlbumPlugin", "click RecordAlbumPlugin");
        Intent intent = new Intent();
        switch (this.scene) {
            case 3:
                intent.putExtra("key_edit_video_max_time_length", com.tencent.mm.plugin.recordvideo.b.a.a.BNL.eJE());
                intent.putExtra("key_edit_text_color", "#0E9CE6");
                boolean a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_story_enable_vlog, false);
                e aAh = g.aAh();
                p.g(aAh, "storage()");
                if (aAh.azQ().getInt(ar.a.USERINFO_TOP_STORY_VLOG_ENABLE_INT, 0) == 1 || a2) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    z2 = true;
                }
                intent.putExtra("key_can_select_video_and_pic", z2);
                if (((a.C1638a) com.tencent.mm.plugin.recordvideo.b.a.a.BNL.aLT()).BNR) {
                    Context context = this.tkI.getContext();
                    if (context == null) {
                        kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
                        AppMethodBeat.o(75608);
                        throw tVar;
                    }
                    s.a((Activity) context, 1000, 9, 22, 3, intent);
                } else {
                    Context context2 = this.tkI.getContext();
                    if (context2 == null) {
                        kotlin.t tVar2 = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
                        AppMethodBeat.o(75608);
                        throw tVar2;
                    }
                    s.a((Activity) context2, 1000, 1, 22, 2, intent);
                }
                c cVar = c.BXI;
                c.eKX().rA(0);
                break;
            case 11:
                intent.putExtra("album_business_tag", "album_business_media");
                Context context3 = this.tkI.getContext();
                if (context3 != null) {
                    s.a((Activity) context3, 1000, 9, 25, 3, intent);
                    break;
                } else {
                    kotlin.t tVar3 = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
                    AppMethodBeat.o(75608);
                    throw tVar3;
                }
            case 15:
                intent.putExtra("key_edit_video_max_time_length", com.tencent.mm.plugin.recordvideo.b.a.a.BNL.eJE());
                intent.putExtra("key_edit_text_color", "#0E9CE6");
                Context context4 = this.tkI.getContext();
                if (context4 != null) {
                    s.a((Activity) context4, 1000, 1, 22, 3, intent);
                    c cVar2 = c.BXI;
                    c.eKX().rA(0);
                    break;
                } else {
                    kotlin.t tVar4 = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
                    AppMethodBeat.o(75608);
                    throw tVar4;
                }
            default:
                intent.putExtra("album_business_tag", "album_business_media");
                Context context5 = this.tkI.getContext();
                if (context5 != null) {
                    s.a((Activity) context5, 1000, 1, 23, 3, intent);
                    break;
                } else {
                    kotlin.t tVar5 = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
                    AppMethodBeat.o(75608);
                    throw tVar5;
                }
        }
        c cVar3 = c.BXI;
        c.VI(4);
        c cVar4 = c.BXI;
        c.eKY().ahM();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/RecordAlbumPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(75608);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void setVisibility(int i2) {
        AppMethodBeat.i(75609);
        if (this.enable) {
            this.tkI.setVisibility(i2);
        }
        AppMethodBeat.o(75609);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onActivityResult(int i2, int i3, Intent intent) {
        ArrayList<String> arrayList = null;
        AppMethodBeat.i(75610);
        Log.i("MicroMsg.RecordAlbumPlugin", "onActivityResult requestCode:" + i2 + " resultCode:" + i3 + " data:" + intent);
        if (i2 == 1000 && i3 == -1) {
            Bundle bundle = new Bundle();
            ArrayList<String> stringArrayListExtra = intent != null ? intent.getStringArrayListExtra("key_select_video_list") : null;
            if (intent != null) {
                arrayList = intent.getStringArrayListExtra("key_select_image_list");
            }
            b.a aVar = com.tencent.mm.plugin.recordvideo.activity.a.b.BJA;
            bundle.putInt("PARAM_ROUTER_INT", b.a.c(-1, arrayList, stringArrayListExtra));
            bundle.putStringArrayList("PARAM_VIDEO_LIST", stringArrayListExtra);
            bundle.putStringArrayList("PARAM_PHOTO_LIST", arrayList);
            this.wgr.a(d.c.BUE, bundle);
            AppMethodBeat.o(75610);
            return;
        }
        AppMethodBeat.o(75610);
    }
}
